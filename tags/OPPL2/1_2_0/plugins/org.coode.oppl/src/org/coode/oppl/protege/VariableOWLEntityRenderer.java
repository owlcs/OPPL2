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

import org.coode.oppl.entity.OWLEntityRenderer;
import org.coode.oppl.utils.ParserFactory;
import org.coode.oppl.variablemansyntax.ConstraintSystem;
import org.protege.editor.owl.model.OWLModelManager;
import org.semanticweb.owl.model.OWLEntity;

public class VariableOWLEntityRenderer implements OWLEntityRenderer {
	private final ConstraintSystem constraintSystem;
	private final OWLModelManager modelManager;

	public String render(OWLEntity entity) {
		OWLEntityRenderer entityRenderer = ParserFactory.getInstance()
				.getOPPLFactory().getOWLEntityRenderer(this.constraintSystem);
		return entityRenderer.render(entity);
	}

	/**
	 * @param constraintSystem
	 * @param modelManager
	 */
	public VariableOWLEntityRenderer(ConstraintSystem constraintSystem,
			OWLModelManager modelManager) {
		this.constraintSystem = constraintSystem;
		this.modelManager = modelManager;
	}

	/**
	 * @return the modelManager
	 */
	public OWLModelManager getModelManager() {
		return this.modelManager;
	}

	/**
	 * @return the constraintSystem
	 */
	public ConstraintSystem getConstraintSystem() {
		return this.constraintSystem;
	}
}