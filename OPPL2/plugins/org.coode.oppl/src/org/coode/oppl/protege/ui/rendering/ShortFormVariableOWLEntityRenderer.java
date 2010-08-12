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
package org.coode.oppl.protege.ui.rendering;

import org.coode.oppl.ConstraintSystem;
import org.coode.oppl.Variable;
import org.protege.editor.owl.ui.renderer.OWLEntityRenderer;
import org.semanticweb.owlapi.model.OWLEntity;
import org.semanticweb.owlapi.util.SimpleShortFormProvider;

public class ShortFormVariableOWLEntityRenderer implements OWLEntityRenderer {
	private final ConstraintSystem constraintSystem;
	private static final SimpleShortFormProvider SHORT_FORM_PROVIDER = new SimpleShortFormProvider();

	public String render(OWLEntity entity) {
		Variable variable = this.getConstraintSystem().getVariable(
				entity.getURI());
		return variable != null ? this.getConstraintSystem().render(variable)
				: SHORT_FORM_PROVIDER.getShortForm(entity);
	}

	/**
	 * @param constraintSystem
	 * @param modelManager
	 */
	public ShortFormVariableOWLEntityRenderer(ConstraintSystem constraintSystem) {
		this.constraintSystem = constraintSystem;
	}

	/**
	 * @return the constraintSystem
	 */
	public ConstraintSystem getConstraintSystem() {
		return this.constraintSystem;
	}
}