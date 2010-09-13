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
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;

import org.coode.oppl.bindingtree.BindingNode;
import org.coode.oppl.exceptions.OPPLException;
import org.coode.oppl.log.Logging;
import org.coode.oppl.rendering.ManchesterSyntaxRenderer;
import org.semanticweb.owl.inference.OWLReasonerException;
import org.semanticweb.owl.model.OWLAxiom;
import org.semanticweb.owl.model.OWLException;
import org.semanticweb.owl.model.OWLOntologyChange;
import org.semanticweb.owl.model.OWLOntologyChangeListener;

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
	public OPPLQueryImpl(ConstraintSystem constraintSystem,
			OPPLAbstractFactory factory) {
		if (constraintSystem == null) {
			throw new NullPointerException(
					"The constraint system cannot be null");
		}
		this.constraintSystem = constraintSystem;
		this.getConstraintSystem().getOntologyManager()
				.addOntologyChangeListener(this.listener);
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
			ManchesterSyntaxRenderer renderer = this.factory
					.getManchesterSyntaxRenderer(this.constraintSystem);
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
			ManchesterSyntaxRenderer renderer = this.factory
					.getManchesterSyntaxRenderer(this.constraintSystem);
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
				buffer.append(c.render());
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
			ManchesterSyntaxRenderer renderer = this.factory
					.getManchesterSyntaxRenderer(this.constraintSystem);
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
			ManchesterSyntaxRenderer renderer = this.factory
					.getManchesterSyntaxRenderer(this.constraintSystem);
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
				buffer.append(c.render());
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
		result = prime
				* result
				+ (this.assertedAxioms == null ? 0 : this.assertedAxioms
						.hashCode());
		result = prime * result
				+ (this.axioms == null ? 0 : this.axioms.hashCode());
		result = prime * result
				+ (this.constraints == null ? 0 : this.constraints.hashCode());
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

	public void execute() throws OPPLException {
		if (this.isDirty()) {
			try {
				this.doExecute();
				this.setDirty(false);
			} catch (OWLReasonerException e) {
				throw new OPPLException("Query threw an reasoning exception", e);
			}
		}
	}

	/**
	 * @throws OWLReasonerException
	 * 
	 */
	private void doExecute() throws OWLReasonerException {
		this.getConstraintSystem().reset();
		for (OWLAxiom axiom : this.getAssertedAxioms()) {
			this.matchAssertedAxiom(axiom);
		}
		for (OWLAxiom axiom : this.getAxioms()) {
			this.matchAxiom(axiom);
		}
		for (AbstractConstraint c : this.getConstraints()) {
			this.matchConstraint(c);
		}
	}

	private void matchConstraint(AbstractConstraint c) {
		assert c != null;
		Set<BindingNode> leaves = this.getConstraintSystem().getLeaves();
		if (leaves != null && !leaves.isEmpty()) {
			Iterator<BindingNode> it = leaves.iterator();
			BindingNode leaf;
			while (it.hasNext()) {
				leaf = it.next();
				boolean holdingLeaf = this.checkConstraint(leaf, c);
				if (!holdingLeaf) {
					it.remove();
				}
			}
			this.getConstraintSystem().setLeaves(leaves);
		}
	}

	private void matchAxiom(OWLAxiom axiom) throws OWLReasonerException {
		assert axiom != null;
		this.updateBindings(axiom);
	}

	private void matchAssertedAxiom(OWLAxiom axiom) {
		assert axiom != null;
		this.updateBindingsAssertedAxiom(axiom);
	}

	private void updateBindings(OWLAxiom axiom) throws OWLReasonerException {
		assert axiom != null;
		if (this.isVariableAxiom(axiom)) {
			Logging
					.getQueryLogger()
					.log(
							Level.INFO,
							"Initial size: "
									+ (this.getConstraintSystem().getLeaves() == null ? "empty"
											: this.getConstraintSystem()
													.getLeaves().size()));
			// AxiomQuery query = this.getConstraintSystem().getReasoner() ==
			// null
			// || this.getConstraintSystem().getReasoner() instanceof
			// NoOpReasoner ? new AssertedTreeSearchSingleAxiomQuery(
			// this.getConstraintSystem().getOntologyManager()
			// .getOntologies(), this.getConstraintSystem())
			// : new InferredAxiomQuery(this.getConstraintSystem(), this
			// .getConstraintSystem().getReasoner());
			AxiomQuery query = this.getConstraintSystem().getReasoner() == null ? new AssertedTreeSearchSingleAxiomQuery(
					this.getConstraintSystem().getOntologyManager()
							.getOntologies(), this.getConstraintSystem())
					: new InferredTreeSearchAxiomQuery(this
							.getConstraintSystem());
			Logging.getQueryTestLogging().log(Level.INFO,
					"Used engine: " + query.getClass().getName());
			axiom.accept(query);
		}
	}

	private void updateBindingsAssertedAxiom(OWLAxiom axiom) {
		assert axiom != null;
		if (this.isVariableAxiom(axiom)) {
			Logging
					.getQueryLogger()
					.log(
							Level.FINE,
							"Initial size: "
									+ (this.getConstraintSystem().getLeaves() == null ? "empty"
											: this.getConstraintSystem()
													.getLeaves().size()));
			AxiomQuery query = new AssertedTreeSearchSingleAxiomQuery(
					this.getConstraintSystem().getOntologyManager()
							.getOntologies(), this.getConstraintSystem());
			axiom.accept(query);
		}
	}

	private boolean isVariableAxiom(OWLAxiom axiom) {
		return !this.getConstraintSystem().getAxiomVariables(axiom).isEmpty();
	}

	// /**
	// * @param leaf
	// * @return if the BindingNode satisfies the constraints
	// */
	// private boolean checkConstraints(BindingNode leaf) {
	// boolean hold = true;
	// Iterator<AbstractConstraint> it = this.getConstraints().iterator();
	// AbstractConstraint c;
	// ConstraintChecker constraintChecker = new ConstraintChecker(leaf, this
	// .getConstraintSystem());
	// while (hold && it.hasNext()) {
	// c = it.next();
	// hold = c.accept(constraintChecker);
	// }
	// return hold;
	// }
	private boolean checkConstraint(BindingNode leaf, AbstractConstraint c) {
		boolean hold = true;
		ConstraintChecker constraintChecker = new ConstraintChecker(leaf, this
				.getConstraintSystem());
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
