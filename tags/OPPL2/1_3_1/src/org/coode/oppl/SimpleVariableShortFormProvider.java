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

import org.semanticweb.owl.model.OWLEntity;
import org.semanticweb.owl.util.ShortFormProvider;
import org.semanticweb.owl.util.SimpleURIShortFormProvider;

/**
 * @author Luigi Iannone
 * 
 */
public class SimpleVariableShortFormProvider implements ShortFormProvider {
	private final SimpleURIShortFormProvider uriShortFormProvider = new SimpleURIShortFormProvider();
	protected ConstraintSystem constraintSystem;

	/**
	 * @param constraintSystem
	 */
	public SimpleVariableShortFormProvider(ConstraintSystem constraintSystem) {
		this.constraintSystem = constraintSystem;
	}

	/**
	 * @see org.semanticweb.owl.util.ShortFormProvider#dispose()
	 */
	public void dispose() {
		// Nothing to do here
	}

	/**
	 * @see org.semanticweb.owl.util.ShortFormProvider#getShortForm(org.semanticweb.owl.model.OWLEntity)
	 */
	public String getShortForm(OWLEntity entity) {
		String toReturn = this.uriShortFormProvider.getShortForm(entity
				.getURI());
		if (this.constraintSystem != null) {
			Variable v = this.constraintSystem.getVariable(entity.getURI());
			if (v != null) {
				toReturn = this.constraintSystem.render(v);
			}
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
}
