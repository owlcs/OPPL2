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

import java.util.Collection;

import org.coode.oppl.bindingtree.BindingNode;
import org.semanticweb.owl.model.OWLObject;

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

	/**
	 * @param bindingNode
	 */
	public ConstraintChecker(BindingNode bindingNode, ConstraintSystem cs) {
		this.bindingNode = bindingNode;
		this.constraintSystem = cs;
	}

	/**
	 * @see org.coode.oppl.ConstraintVisitorEx#visit(org.coode.oppl.InequalityConstraint)
	 */
	public Boolean visit(InequalityConstraint c) {
		OWLObject expression = c.getExpression();
		OWLObjectInstantiator instantiator = new OWLObjectInstantiator(
				this.bindingNode, this.constraintSystem);
		OWLObject instantiatedObject = expression.accept(instantiator);
		Variable variable = c.getVariable();
		OWLObject assignedValue = this.bindingNode.getAssignmentValue(variable);
		return !assignedValue.equals(instantiatedObject);
	}

	/**
	 * @see org.coode.oppl.ConstraintVisitorEx#visit(org.coode.oppl.InCollectionConstraint)
	 */
	public Boolean visit(InCollectionConstraint<? extends OWLObject> c) {
		Collection<? extends OWLObject> collection = c.getCollection();
		OWLObject assignedValue = this.bindingNode.getAssignmentValue(c
				.getVariable());
		return collection.contains(assignedValue);
	}

	public Boolean visit(InCollectionRegExpConstraint c) {
		Collection<? extends OWLObject> collection = c
				.getCollection(this.bindingNode);
		OWLObject assignedValue = this.bindingNode.getAssignmentValue(c
				.getVariable());
		return collection.contains(assignedValue);
	}
}
