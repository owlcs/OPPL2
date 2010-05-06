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

import org.coode.oppl.variablemansyntax.ConstraintSystem;
import org.coode.oppl.variablemansyntax.Variable;
import org.protege.editor.owl.model.OWLModelManager;
import org.semanticweb.owl.model.OWLEntity;
import org.semanticweb.owl.util.ShortFormProvider;

public class ProtegeSimpleVariableShortFormProvider implements
		ShortFormProvider {
	private final OWLModelManager modelManager;
	private final ConstraintSystem constraintSystem;

	public ProtegeSimpleVariableShortFormProvider(OWLModelManager modelManager,
			ConstraintSystem constraintSystem) {
		this.modelManager = modelManager;
		this.constraintSystem = constraintSystem;
	}

	public void dispose() {
	}

	public String getShortForm(OWLEntity entity) {
		String toReturn = getModelManager().getRendering(entity);
		if (this.constraintSystem != null) {
			Variable v = getConstraintSystem().getVariable(entity.getURI());
			if (v != null) {
				toReturn = v.getName();
			}
		}
		return toReturn;
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