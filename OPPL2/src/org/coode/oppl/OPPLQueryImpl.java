/**
 * Copyright (C) 2008, University of Manchester
 *
 * Modifications to the initial code base are copyright of their
 * respective authors, or their employers as appropriate.  Authorship
 * of the modifications may be determined from the ChangeLog placed at
 * the end of this file.
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.

 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.

 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301  USA
 */
package org.coode.oppl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

import org.coode.oppl.bindingtree.BindingNode;
import org.coode.oppl.exceptions.RuntimeExceptionHandler;
import org.coode.oppl.function.OPPLFunction;
import org.coode.oppl.function.SimpleValueComputationParameters;
import org.coode.oppl.queryplanner.AssertedAxiomPlannerItem;
import org.coode.oppl.queryplanner.ConstraintQueryPlannerItem;
import org.coode.oppl.queryplanner.InferredAxiomQueryPlannerItem;
import org.coode.oppl.queryplanner.QueryItemVariableExtractor;
import org.coode.oppl.queryplanner.QueryPlannerItem;
import org.coode.oppl.rendering.ManchesterSyntaxRenderer;
import org.coode.oppl.utils.VariableExtractor;
import org.semanticweb.owlapi.model.OWLAxiom;
import org.semanticweb.owlapi.model.OWLException;
import org.semanticweb.owlapi.model.OWLObject;
import org.semanticweb.owlapi.model.OWLOntologyChange;
import org.semanticweb.owlapi.model.OWLOntologyChangeListener;
import org.semanticweb.owlapi.model.OWLRuntimeException;
import org.semanticweb.owlapi.util.ShortFormProvider;

/**
 * @author Luigi Iannone
 * 
 */
public class OPPLQueryImpl implements OPPLQuery {
	private final List<OWLAxiom> axioms = new ArrayList<OWLAxiom>();
	private final List<OWLAxiom> assertedAxioms = new ArrayList<OWLAxiom>();
	private final Set<AbstractConstraint> constraints = new HashSet<AbstractConstraint>();
	private final ConstraintSystem constraintSystem;
	private boolean dirty = true;
	private final OWLOntologyChangeListener listener = new OWLOntologyChangeListener() {
		public void ontologiesChanged(List<? extends OWLOntologyChange> changes)
				throws OWLException {
			OPPLQueryImpl.this.setDirty(true);
		}
	};
	private final OPPLAbstractFactory factory;

	public OPPLQueryImpl(OPPLQuery query, OPPLAbstractFactory factory) {
		this(query.getConstraintSystem(), factory);
		for (OWLAxiom assertedAxiom : query.getAssertedAxioms()) {
			this.addAssertedAxiom(assertedAxiom);
		}
		for (OWLAxiom axiom : query.getAxioms()) {
			this.addAxiom(axiom);
		}
		for (AbstractConstraint constraint : query.getConstraints()) {
			this.addConstraint(constraint);
		}
	}

	/**
	 * @param constraintSystem
	 */
	public OPPLQueryImpl(ConstraintSystem constraintSystem, OPPLAbstractFactory factory) {
		if (constraintSystem == null) {
			throw new NullPointerException("The constraint system cannot be null");
		}
		this.constraintSystem = constraintSystem;
		this.getConstraintSystem().getOntologyManager().addOntologyChangeListener(this.listener);
		this.factory = factory;
	}

	/**
	 * 
	 * @see org.coode.oppl.OPPLQuery#addAssertedAxiom(org.semanticweb.owl.model.OWLAxiom)
	 */
	public void addAssertedAxiom(OWLAxiom axiom) {
		if (axiom == null) {
			throw new NullPointerException("The axiom cannot be null");
		}
		this.assertedAxioms.add(axiom);
	}

	/**
	 * @see org.coode.oppl.OPPLQuery#addAxiom(org.semanticweb.owl.model.OWLAxiom)
	 */
	public void addAxiom(OWLAxiom axiom) {
		if (axiom == null) {
			throw new NullPointerException("The axiom cannot be null");
		}
		this.axioms.add(axiom);
	}

	/**
	 * @see org.coode.oppl.OPPLQuery#addConstraint(org.coode.oppl.InequalityConstraint)
	 */
	public void addConstraint(AbstractConstraint constraint) {
		if (constraint == null) {
			throw new NullPointerException("The constraint cannot be null");
		}
		this.constraints.add(constraint);
	}

	/**
	 * @return the axioms
	 */
	public List<OWLAxiom> getAxioms() {
		return new ArrayList<OWLAxiom>(this.axioms);
	}

	/**
	 * @return the assertedAxioms
	 */
	public List<OWLAxiom> getAssertedAxioms() {
		return new ArrayList<OWLAxiom>(this.assertedAxioms);
	}

	public List<AbstractConstraint> getConstraints() {
		return new ArrayList<AbstractConstraint>(this.constraints);
	}

	@Override
	public String toString() {
		StringBuffer buffer = new StringBuffer("SELECT ");
		int i = 0;
		for (OWLAxiom axiom : this.getAssertedAxioms()) {
			ManchesterSyntaxRenderer renderer = this.factory.getManchesterSyntaxRenderer(this.constraintSystem);
			buffer.append("ASSERTED ");
			axiom.accept(renderer);
			buffer.append(renderer.toString());
			if (i < this.getAssertedAxioms().size() - 1) {
				buffer.append(",");
			}
			buffer.append('\n');
			i++;
		}
		i = 0;
		for (OWLAxiom axiom : this.getAxioms()) {
			ManchesterSyntaxRenderer renderer = this.factory.getManchesterSyntaxRenderer(this.constraintSystem);
			axiom.accept(renderer);
			buffer.append(renderer.toString());
			if (i < this.getAxioms().size() - 1) {
				buffer.append(",");
			}
			buffer.append('\n');
			i++;
		}
		if (this.getConstraints().size() > 0) {
			buffer.append(" WHERE ");
			i = 0;
			for (AbstractConstraint c : this.getConstraints()) {
				buffer.append(c.render(this.getConstraintSystem()));
				if (i < this.getConstraints().size() - 1) {
					buffer.append(",");
				}
				buffer.append('\n');
				i++;
			}
		}
		return buffer.toString();
	}

	public String render(ShortFormProvider shortFormProvider) {
		StringBuffer buffer = new StringBuffer("SELECT ");
		int i = 0;
		for (OWLAxiom axiom : this.getAssertedAxioms()) {
			ManchesterSyntaxRenderer renderer = new ManchesterSyntaxRenderer(shortFormProvider);
			buffer.append("ASSERTED ");
			axiom.accept(renderer);
			buffer.append(renderer.toString());
			if (i < this.getAssertedAxioms().size() - 1) {
				buffer.append(",");
			}
			buffer.append('\n');
			i++;
		}
		i = 0;
		for (OWLAxiom axiom : this.getAxioms()) {
			ManchesterSyntaxRenderer renderer = new ManchesterSyntaxRenderer(shortFormProvider);
			axiom.accept(renderer);
			buffer.append(renderer.toString());
			if (i < this.getAxioms().size() - 1) {
				buffer.append(",");
			}
			buffer.append('\n');
			i++;
		}
		if (this.getConstraints().size() > 0) {
			buffer.append(" WHERE ");
			i = 0;
			for (AbstractConstraint c : this.getConstraints()) {
				buffer.append(c.render(shortFormProvider));
				if (i < this.getConstraints().size() - 1) {
					buffer.append(",");
				}
				buffer.append('\n');
				i++;
			}
		}
		return buffer.toString();
	}

	public String render() {
		StringBuffer buffer = new StringBuffer("SELECT ");
		int i = 0;
		for (OWLAxiom axiom : this.getAssertedAxioms()) {
			ManchesterSyntaxRenderer renderer = this.factory.getManchesterSyntaxRenderer(this.constraintSystem);
			buffer.append("ASSERTED ");
			axiom.accept(renderer);
			buffer.append(renderer.toString());
			if (i < this.getAssertedAxioms().size() - 1) {
				buffer.append(",");
			}
			buffer.append('\n');
			i++;
		}
		i = 0;
		for (OWLAxiom axiom : this.getAxioms()) {
			ManchesterSyntaxRenderer renderer = this.factory.getManchesterSyntaxRenderer(this.constraintSystem);
			axiom.accept(renderer);
			buffer.append(renderer.toString());
			if (i < this.getAxioms().size() - 1) {
				buffer.append(",");
			}
			buffer.append('\n');
			i++;
		}
		if (this.getConstraints().size() > 0) {
			buffer.append("\nWHERE ");
			i = 0;
			for (AbstractConstraint c : this.getConstraints()) {
				buffer.append(c.render(this.getConstraintSystem()));
				if (i < this.getConstraints().size() - 1) {
					buffer.append(",");
				}
				buffer.append('\n');
				i++;
			}
		}
		return buffer.toString();
	}

	/**
	 * @return the constraintSystem
	 */
	public ConstraintSystem getConstraintSystem() {
		return this.constraintSystem;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ (this.assertedAxioms == null ? 0 : this.assertedAxioms.hashCode());
		result = prime * result + (this.axioms == null ? 0 : this.axioms.hashCode());
		result = prime * result + (this.constraints == null ? 0 : this.constraints.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (this.getClass() != obj.getClass()) {
			return false;
		}
		OPPLQueryImpl other = (OPPLQueryImpl) obj;
		if (this.assertedAxioms == null) {
			if (other.assertedAxioms != null) {
				return false;
			}
		} else if (!this.assertedAxioms.equals(other.assertedAxioms)) {
			return false;
		}
		if (this.axioms == null) {
			if (other.axioms != null) {
				return false;
			}
		} else if (!this.axioms.equals(other.axioms)) {
			return false;
		}
		if (this.constraints == null) {
			if (other.constraints != null) {
				return false;
			}
		} else if (!this.constraints.equals(other.constraints)) {
			return false;
		}
		return true;
	}

	public void execute(Collection<? extends BindingNode> leaves,
			RuntimeExceptionHandler runtimeExceptionHandler) {
		try {
			this.constraintSystem.setLeaves(new HashSet<BindingNode>(leaves));
			this.doExecute(runtimeExceptionHandler, false);
			this.setDirty(false);
		} catch (OWLRuntimeException e) {
			runtimeExceptionHandler.handleOWLRuntimeException(e);
		}
	}

	public void execute(RuntimeExceptionHandler runtimeExceptionHandler) {
		if (this.isDirty()) {
			try {
				this.doExecute(runtimeExceptionHandler, true);
				this.setDirty(false);
			} catch (OWLRuntimeException e) {
				runtimeExceptionHandler.handleOWLRuntimeException(e);
			}
		}
	}

	/**
	 * @param runtimeExceptionHandler
	 * @throws OWLRuntimeException
	 * 
	 */
	private void doExecute(RuntimeExceptionHandler runtimeExceptionHandler,
			boolean resetConstraintSystem) throws OWLRuntimeException {
		if (resetConstraintSystem) {
			this.getConstraintSystem().reset();
		}
		Set<BindingNode> currentLeaves = this.getConstraintSystem().getLeaves();
		List<QueryPlannerItem> queryPlannerItems = new ArrayList<QueryPlannerItem>();
		for (OWLAxiom axiom : this.getAssertedAxioms()) {
			queryPlannerItems.add(new AssertedAxiomPlannerItem(this.getConstraintSystem(), axiom));
		}
		for (OWLAxiom axiom : this.getAxioms()) {
			// TODO: can be optimised using de-composition in simpler axioms see
			// http://www.webont.org/owled/2011/papers/owled2011_submission_4.pdf
			// Table 1
			queryPlannerItems.add(new InferredAxiomQueryPlannerItem(this.getConstraintSystem(),
					axiom));
		}
		Comparator<QueryPlannerItem> comparator = new Comparator<QueryPlannerItem>() {
			public int compare(QueryPlannerItem anItem, QueryPlannerItem anotherItem) {
				int toReturn = 0;
				if (anItem == null) {
					toReturn = anotherItem == null ? toReturn : -1;
				} else {
					QueryItemVariableExtractor variableExtractor = new QueryItemVariableExtractor();
					int difference = anItem.accept(variableExtractor).size()
							- anotherItem.accept(variableExtractor).size();
					toReturn = difference == 0 ? anItem.hashCode() - anotherItem.hashCode()
							: difference;
				}
				return toReturn;
			}
		};
		Collections.sort(queryPlannerItems, comparator);
		// I want to sort the constraints separately as their matching can only
		// happen on existing leaves.
		List<ConstraintQueryPlannerItem> constraintsItems = new ArrayList<ConstraintQueryPlannerItem>();
		for (AbstractConstraint c : this.getConstraints()) {
			constraintsItems.add(new ConstraintQueryPlannerItem(this.getConstraintSystem(), c));
		}
		for (QueryPlannerItem queryPlannerItem : queryPlannerItems) {
			currentLeaves = queryPlannerItem.match(currentLeaves, runtimeExceptionHandler);
			// Now I check the constraints
			for (ConstraintQueryPlannerItem c : new HashSet<ConstraintQueryPlannerItem>(
					constraintsItems)) {
				if (this.canMatch(c, currentLeaves, runtimeExceptionHandler)) {
					currentLeaves = c.match(currentLeaves, runtimeExceptionHandler);
					constraintsItems.remove(c);
				}
			}
		}
		this.getConstraintSystem().setLeaves(currentLeaves);
	}

	private boolean canMatch(ConstraintQueryPlannerItem c, Set<BindingNode> currentLeaves,
			RuntimeExceptionHandler runtimeExceptionHandler) {
		boolean found = false;
		AbstractConstraint constraint = c.getConstraint();
		Iterator<BindingNode> iterator = currentLeaves.iterator();
		while (!found && iterator.hasNext()) {
			final BindingNode bindingNode = iterator.next();
			final SimpleValueComputationParameters parameters = new SimpleValueComputationParameters(
					this.getConstraintSystem(), bindingNode, runtimeExceptionHandler);
			final OWLObjectInstantiator instantiator = new OWLObjectInstantiator(parameters);
			final VariableExtractor variableExtractor = new VariableExtractor(
					OPPLQueryImpl.this.getConstraintSystem(), false);
			found = constraint.accept(new ConstraintVisitorEx<Boolean>() {
				public Boolean visit(InequalityConstraint c) {
					OWLObject instantiatedExpression = c.getExpression().accept(instantiator);
					return bindingNode.getAssignmentValue(c.getVariable(), parameters) == null
							|| !variableExtractor.extractVariables(instantiatedExpression).isEmpty();
				}

				public Boolean visit(InCollectionConstraint<? extends OWLObject> c) {
					boolean found = false;
					Iterator<? extends OWLObject> iterator = c.getCollection().iterator();
					while (!found && iterator.hasNext()) {
						OWLObject owlObject = iterator.next();
						OWLObject instantiated = owlObject.accept(instantiator);
						found = !variableExtractor.extractVariables(instantiated).isEmpty();
					}
					return bindingNode.getAssignmentValue(c.getVariable(), parameters) == null
							|| found;
				}

				public Boolean visit(RegExpConstraint c) {
					OPPLFunction<Pattern> expression = c.getExpression();
					Set<Variable<?>> extractedVariables = variableExtractor.extractVariables(expression);
					boolean found = false;
					Iterator<Variable<?>> iterator = extractedVariables.iterator();
					while (!found && iterator.hasNext()) {
						Variable<?> variable = iterator.next();
						found = bindingNode.getAssignmentValue(variable, parameters) == null;
					}
					return bindingNode.getAssignmentValue(c.getVariable(), parameters) == null
							|| found;
				}

				public Boolean visit(NAFConstraint nafConstraint) {
					OWLAxiom instantiatedAxiom = (OWLAxiom) nafConstraint.getAxiom().accept(
							instantiator);
					Set<Variable<?>> extractedVariables = variableExtractor.extractVariables(instantiatedAxiom);
					return !extractedVariables.isEmpty();
				}
			});
		}
		return !found;
	}

	/**
	 * @return the dirty
	 */
	public boolean isDirty() {
		return this.dirty;
	}

	/**
	 * @param dirty
	 *            the dirty to set
	 */
	public void setDirty(boolean dirty) {
		this.dirty = dirty;
	}
}
