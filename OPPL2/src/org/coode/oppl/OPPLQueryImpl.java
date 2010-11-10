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
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;

import org.coode.oppl.bindingtree.Assignment;
import org.coode.oppl.bindingtree.BindingNode;
import org.coode.oppl.exceptions.RuntimeExceptionHandler;
import org.coode.oppl.function.SimpleValueComputationParameters;
import org.coode.oppl.function.ValueComputationParameters;
import org.coode.oppl.log.Logging;
import org.coode.oppl.querymatching.AssertedSolvabilityBasedAxiomQuery;
import org.coode.oppl.querymatching.AxiomQuery;
import org.coode.oppl.querymatching.ConstraintChecker;
import org.coode.oppl.querymatching.InferredSolvabilityBasedTreeSearchAxiomQuery;
import org.coode.oppl.rendering.ManchesterSyntaxRenderer;
import org.semanticweb.owlapi.model.OWLAxiom;
import org.semanticweb.owlapi.model.OWLException;
import org.semanticweb.owlapi.model.OWLOntologyChange;
import org.semanticweb.owlapi.model.OWLOntologyChangeListener;
import org.semanticweb.owlapi.model.OWLRuntimeException;

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

	public void execute(RuntimeExceptionHandler runtimeExceptionHandler) {
		if (this.isDirty()) {
			try {
				this.doExecute(runtimeExceptionHandler);
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
	private void doExecute(RuntimeExceptionHandler runtimeExceptionHandler)
			throws OWLRuntimeException {
		this.getConstraintSystem().reset();
		Set<BindingNode> currentLeaves = this.getConstraintSystem().getLeaves();
		for (OWLAxiom axiom : this.getAssertedAxioms()) {
			currentLeaves = this.matchAssertedAxiom(axiom, currentLeaves, runtimeExceptionHandler);
		}
		for (OWLAxiom axiom : this.getAxioms()) {
			currentLeaves = this.matchAxiom(axiom, currentLeaves, runtimeExceptionHandler);
		}
		for (AbstractConstraint c : this.getConstraints()) {
			this.matchConstraint(c, currentLeaves, runtimeExceptionHandler);
		}
		this.getConstraintSystem().setLeaves(currentLeaves);
	}

	private void matchConstraint(AbstractConstraint c,
			Collection<? extends BindingNode> currentLeaves,
			RuntimeExceptionHandler runtimeExceptionHandler) {
		assert c != null;
		if (currentLeaves != null && !currentLeaves.isEmpty()) {
			Iterator<? extends BindingNode> it = currentLeaves.iterator();
			BindingNode leaf;
			while (it.hasNext()) {
				leaf = it.next();
				boolean holdingLeaf = this.checkConstraint(leaf, c, runtimeExceptionHandler);
				if (!holdingLeaf) {
					it.remove();
				}
			}
		}
	}

	private Set<BindingNode> matchAxiom(OWLAxiom axiom,
			Collection<? extends BindingNode> currentLeaves,
			RuntimeExceptionHandler runtimeExceptionHandler) throws OWLRuntimeException {
		assert axiom != null;
		Set<BindingNode> toReturn = new HashSet<BindingNode>();
		if (currentLeaves != null) {
			for (BindingNode bindingNode : currentLeaves) {
				ValueComputationParameters parameters = new SimpleValueComputationParameters(
						this.getConstraintSystem(), bindingNode, runtimeExceptionHandler);
				PartialOWLObjectInstantiator instantiator = new PartialOWLObjectInstantiator(
						parameters);
				OWLAxiom instantiatedAxiom = (OWLAxiom) axiom.accept(instantiator);
				Set<BindingNode> newLeaves = this.updateBindings(
						instantiatedAxiom,
						runtimeExceptionHandler);
				toReturn.addAll(this.merge(bindingNode, newLeaves));
			}
		} else {
			toReturn.addAll(this.updateBindings(axiom, runtimeExceptionHandler));
		}
		return toReturn;
	}

	private Set<BindingNode> matchAssertedAxiom(OWLAxiom axiom,
			Collection<? extends BindingNode> currentLeaves,
			RuntimeExceptionHandler runtimeExceptionHandler) {
		assert axiom != null;
		Set<BindingNode> toReturn = new HashSet<BindingNode>();
		if (currentLeaves != null) {
			for (BindingNode bindingNode : currentLeaves) {
				ValueComputationParameters parameters = new SimpleValueComputationParameters(
						this.getConstraintSystem(), bindingNode, runtimeExceptionHandler);
				PartialOWLObjectInstantiator instantiator = new PartialOWLObjectInstantiator(
						parameters);
				OWLAxiom instantiatedAxiom = (OWLAxiom) axiom.accept(instantiator);
				Set<BindingNode> newLeaves = this.updateBindingsAssertedAxiom(
						instantiatedAxiom,
						runtimeExceptionHandler);
				toReturn.addAll(this.merge(bindingNode, newLeaves));
			}
		} else {
			toReturn.addAll(this.updateBindingsAssertedAxiom(axiom, runtimeExceptionHandler));
		}
		return toReturn;
	}

	private Set<BindingNode> merge(BindingNode leaf, Collection<? extends BindingNode> newLeaves) {
		Set<BindingNode> toReturn = new HashSet<BindingNode>();
		for (BindingNode bindingNode : newLeaves) {
			Set<Assignment> newAssignment = new HashSet<Assignment>(leaf.getAssignments());
			newAssignment.addAll(bindingNode.getAssignments());
			Set<Variable<?>> newUnassigendVariables = new HashSet<Variable<?>>(
					leaf.getUnassignedVariables());
			newUnassigendVariables.addAll(bindingNode.getUnassignedVariables());
			toReturn.add(new BindingNode(newAssignment, newUnassigendVariables));
		}
		return toReturn;
	}

	private Set<BindingNode> updateBindings(OWLAxiom axiom,
			RuntimeExceptionHandler runtimeExceptionHandler) throws OWLRuntimeException {
		assert axiom != null;
		Set<BindingNode> toReturn = new HashSet<BindingNode>();
		Logging.getQueryLogger().log(
				Level.INFO,
				"Initial size: "
						+ (this.getConstraintSystem().getLeaves() == null ? "empty"
								: this.getConstraintSystem().getLeaves().size()));
		AxiomQuery query = this.getConstraintSystem().getReasoner() == null ? new AssertedSolvabilityBasedAxiomQuery(
				this.getConstraintSystem().getOntologyManager().getOntologies(),
				this.getConstraintSystem(), runtimeExceptionHandler)
				: new InferredSolvabilityBasedTreeSearchAxiomQuery(this.getConstraintSystem(),
						runtimeExceptionHandler);
		Logging.getQueryTestLogging().log(Level.INFO, "Used engine: " + query.getClass().getName());
		axiom.accept(query);
		toReturn.addAll(query.getLeaves());
		return toReturn;
	}

	private Set<BindingNode> updateBindingsAssertedAxiom(OWLAxiom axiom,
			RuntimeExceptionHandler runtimeExceptionHandler) {
		assert axiom != null;
		Set<BindingNode> toReturn = new HashSet<BindingNode>();
		if (this.isVariableAxiom(axiom)) {
			Logging.getQueryLogger().log(
					Level.FINE,
					"Initial size: "
							+ (this.getConstraintSystem().getLeaves() == null ? "empty"
									: this.getConstraintSystem().getLeaves().size()));
			AxiomQuery query = new AssertedSolvabilityBasedAxiomQuery(
					this.getConstraintSystem().getOntologyManager().getOntologies(),
					this.getConstraintSystem(), runtimeExceptionHandler);
			axiom.accept(query);
			toReturn.addAll(query.getLeaves());
		}
		return toReturn;
	}

	private boolean isVariableAxiom(OWLAxiom axiom) {
		return !this.getConstraintSystem().getAxiomVariables(axiom).isEmpty();
	}

	private boolean checkConstraint(BindingNode leaf, AbstractConstraint c,
			RuntimeExceptionHandler runtimeExceptionHandler) {
		boolean hold = true;
		ValueComputationParameters parameters = new SimpleValueComputationParameters(
				this.getConstraintSystem(), leaf, runtimeExceptionHandler);
		ConstraintChecker constraintChecker = new ConstraintChecker(parameters);
		hold = c.accept(constraintChecker);
		return hold;
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
