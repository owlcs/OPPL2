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
package org.coode.oppl.rendering;

import java.net.URI;

import org.coode.oppl.ConstraintSystem;
import org.coode.oppl.Variable;
import org.coode.oppl.entity.OWLEntityRenderer;
import org.semanticweb.owl.model.OWLEntity;

/**
 * @author Luigi Iannone
 * 
 */
public class VariableOWLEntityRenderer implements OWLEntityRenderer {
	private ConstraintSystem constraintSystem;
	private OWLEntityRenderer delegate;

	/**
	 * Builds a VariableOWLEntityRenderer from a generic one and a
	 * ConstraintSystem instance.
	 * 
	 * @param constraintSystem
	 *            the ConstraintSystem containing all the variables. Cannot be
	 *            {@code null}.
	 * @param delegate
	 *            the OWLEntityRenderer instance for the non-variable entities.
	 *            Cannot be {@code null}.
	 * @throws NullPointerException
	 *             when either of the inputs is {@code null}.
	 */
	public VariableOWLEntityRenderer(ConstraintSystem constraintSystem,
			OWLEntityRenderer delegate) {
		this.constraintSystem = constraintSystem;
		this.delegate = delegate;
	}

	/**
	 * @throws NullPointerException
	 *             if the input is {@code null}.
	 * @see org.protege.editor.owl.ui.renderer.OWLEntityRenderer#render(org.semanticweb
	 *      .owl.model.OWLEntity)
	 */
	public String render(OWLEntity entity) {
		String toReturn = null;
		URI uri = entity.getURI();
		Variable variable = this.constraintSystem.getVariable(uri);
		if (variable != null) {
			toReturn = this.constraintSystem.render(variable);
		} else {
			toReturn = this.delegate.render(entity);
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
	 * @param constraintSystem
	 *            the constraintSystem to set
	 */
	public void setConstraintSystem(ConstraintSystem constraintSystem) {
		this.constraintSystem = constraintSystem;
	}

	/**
	 * @return the delegate
	 */
	public OWLEntityRenderer getDelegate() {
		return this.delegate;
	}

	/**
	 * @param delegate
	 *            the delegate to set
	 */
	public void setDelegate(OWLEntityRenderer delegate) {
		this.delegate = delegate;
	}
}
