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

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.logging.Level;

import org.coode.oppl.bindingtree.BindingNode;
import org.coode.oppl.log.Logging;
import org.semanticweb.owl.inference.OWLReasonerException;
import org.semanticweb.owl.model.OWLAxiom;
import org.semanticweb.owl.model.OWLDescription;
import org.semanticweb.owl.model.OWLObject;
import org.semanticweb.owl.model.OWLOntology;

import com.clarkparsia.explanation.SatisfiabilityConverter;

/**
 * This ConstraintVisitor implementation verifies if the visited Constraint
 * holds
 * 
 * @author Luigi Iannone
 * 
 */
public class ConstraintChecker implements ConstraintVisitorEx<Boolean> {
	private final BindingNode bindingNode;
	private final ConstraintSystem constraintSystem;
	private final OWLObjectInstantiator instantiator;

	/**
	 * @param bindingNode
	 */
	public ConstraintChecker(BindingNode bindingNode, ConstraintSystem cs) {
		if (bindingNode == null) {
			throw new NullPointerException("The binding node cannot be null");
		}
		if (cs == null) {
			throw new NullPointerException(
					"The constraint system cannot be null");
		}
		this.bindingNode = bindingNode;
		this.constraintSystem = cs;
		this.instantiator = new OWLObjectInstantiator(this.getBindingNode(),
				this.getConstraintSystem());
	}

	/**
	 * @see org.coode.oppl.ConstraintVisitorEx#visit(org.coode.oppl.InequalityConstraint)
	 */
	public Boolean visit(InequalityConstraint c) {
		OWLObject expression = c.getExpression();
		OWLObjectInstantiator instantiator = new OWLObjectInstantiator(this
				.getBindingNode(), this.getConstraintSystem());
		OWLObject instantiatedObject = expression.accept(instantiator);
		Variable variable = c.getVariable();
		OWLObject assignedValue = this.getBindingNode().getAssignmentValue(
				variable);
		return !assignedValue.equals(instantiatedObject);
	}

	/**
	 * @see org.coode.oppl.ConstraintVisitorEx#visit(org.coode.oppl.InCollectionConstraint)
	 */
	public Boolean visit(InCollectionConstraint<? extends OWLObject> c) {
		Set<? extends OWLObject> collection = c.getCollection();
		OWLObject assignedValue = this.getBindingNode().getAssignmentValue(
				c.getVariable());
		Set<OWLObject> instantiatedObjects = new HashSet<OWLObject>(collection
				.size());
		for (OWLObject owlObject : collection) {
			instantiatedObjects.add(owlObject.accept(this.instantiator));
		}
		return instantiatedObjects.contains(assignedValue);
	}

	public Boolean visit(InCollectionRegExpConstraint c) {
		Set<OWLObject> collection = c.getCollection(this.getBindingNode());
		OWLObject assignedValue = this.getBindingNode().getAssignmentValue(
				c.getVariable());
		Set<OWLObject> instantiatedObjects = new HashSet<OWLObject>(collection
				.size());
		for (OWLObject owlObject : collection) {
			instantiatedObjects.add(owlObject.accept(this.instantiator));
		}
		return instantiatedObjects.contains(assignedValue);
	}

	public Boolean visit(NAFConstraint nafConstraint) {
		OWLAxiom instantiatedAxiom = (OWLAxiom) nafConstraint.getAxiom()
				.accept(this.instantiator);
		boolean toReturn = false;
		try {
			if (this.getConstraintSystem().getReasoner() != null) {
				SatisfiabilityConverter satisfiabilityConverter = new SatisfiabilityConverter(
						this.getConstraintSystem().getOntologyManager()
								.getOWLDataFactory());
				OWLDescription convert = satisfiabilityConverter
						.convert(instantiatedAxiom);
				toReturn = !this.getConstraintSystem().getReasoner()
						.isSubClassOf(
								convert,
								this.getConstraintSystem().getOntologyManager()
										.getOWLDataFactory().getOWLNothing());
			} else {
				boolean found = false;
				Iterator<OWLOntology> iterator = this.getConstraintSystem()
						.getOntologyManager().getOntologies().iterator();
				while (!found && iterator.hasNext()) {
					OWLOntology ontology = iterator.next();
					found = ontology.containsAxiom(instantiatedAxiom);
				}
				toReturn = !found;
			}
		} catch (OWLReasonerException e) {
			Logging.getQueryLogger().log(
					Level.WARNING,
					" OWLReasonerException  caught whilst checking the constraint "
							+ nafConstraint.render());
		}
		return toReturn;
	}

	/**
	 * @return the constraintSystem
	 */
	public ConstraintSystem getConstraintSystem() {
		return this.constraintSystem;
	}

	/**
	 * @return the bindingNode
	 */
	public BindingNode getBindingNode() {
		return this.bindingNode;
	}
}
