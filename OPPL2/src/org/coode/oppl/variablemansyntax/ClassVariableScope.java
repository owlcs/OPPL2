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
package org.coode.oppl.variablemansyntax;

import java.util.HashMap;
import java.util.Map;

import org.semanticweb.owl.model.OWLDescription;
import org.semanticweb.owl.model.OWLObject;

/**
 * Represents a range limitations that could be added to a
 * {@link GeneratedVariable} instance with CLASS {@link VariableType}
 * 
 * @author Luigi Iannone
 * 
 */
public abstract class ClassVariableScope implements VariableScope {
	private final OWLDescription description;
	private static Map<OWLDescription, SuperClassVariableScope> superClassesScopes = new HashMap<OWLDescription, SuperClassVariableScope>();
	private static Map<OWLDescription, SubClassVariableScope> subClassesScopes = new HashMap<OWLDescription, SubClassVariableScope>();

	/**
	 * @param description
	 */
	ClassVariableScope(OWLDescription description) {
		this.description = description;
	}

	/**
	 * @return the description
	 */
	public OWLDescription getDescription() {
		return this.description;
	}

	static SubClassVariableScope buildSubClassVariableScope(
			OWLDescription description) {
		SubClassVariableScope toReturn = subClassesScopes.get(description);
		if (toReturn == null) {
			toReturn = new SubClassVariableScope(description);
			subClassesScopes.put(description, toReturn);
		}
		return toReturn;
	}

	static SuperClassVariableScope buildSuperClassVariableScope(
			OWLDescription description) {
		SuperClassVariableScope toReturn = superClassesScopes.get(description);
		if (toReturn == null) {
			toReturn = new SuperClassVariableScope(description);
			superClassesScopes.put(description, toReturn);
		}
		return toReturn;
	}

	/**
	 * @see org.coode.oppl.variablemansyntax.VariableScope#getScopingObject()
	 */
	public OWLObject getScopingObject() {
		return getDescription();
	}
}
