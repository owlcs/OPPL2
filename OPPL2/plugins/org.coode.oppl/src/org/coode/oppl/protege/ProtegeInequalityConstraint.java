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
package org.coode.oppl.protege;

import org.coode.oppl.InequalityConstraint;
import org.coode.oppl.protege.ui.VariableOWLObjectRenderer;
import org.coode.oppl.protege.ui.rendering.ShortFormVariableOWLEntityRenderer;
import org.protege.editor.owl.model.OWLModelManager;

/**
 * @author Luigi Iannone
 * 
 */
public class ProtegeInequalityConstraint extends InequalityConstraint {
	private ShortFormVariableOWLEntityRenderer entityRenderer;
	private final VariableOWLObjectRenderer variableOWLObjectRenderer;
	private final InequalityConstraint constraint;

	public ProtegeInequalityConstraint(InequalityConstraint constraint,
			OWLModelManager modelManager) {
		super(constraint.getVariable(), constraint.getExpression(), constraint
				.getConstraintSystem());
		this.constraint = constraint;
		this.variableOWLObjectRenderer = new VariableOWLObjectRenderer(
				modelManager);
	}

	@Override
	public String toString() {
		this.entityRenderer = new ShortFormVariableOWLEntityRenderer(
				getConstraintSystem());
		return this.constraint.getVariable().getName()
				+ " != "
				+ this.variableOWLObjectRenderer.render(getExpression(),
						this.entityRenderer);
	}

	@Override
	public boolean equals(Object obj) {
		// the changes in this class are not relevant for hashcode and equals
		return super.equals(obj);
	}

	@Override
	public int hashCode() {
		// the changes in this class are not relevant for hashcode and equals
		return super.hashCode();
	}
}
