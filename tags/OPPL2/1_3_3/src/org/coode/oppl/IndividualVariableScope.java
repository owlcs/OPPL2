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

import java.util.HashMap;
import java.util.Map;

import org.coode.oppl.VariableScopes.Direction;
import org.semanticweb.owl.inference.OWLReasonerException;
import org.semanticweb.owl.model.OWLDescription;
import org.semanticweb.owl.model.OWLIndividual;
import org.semanticweb.owl.model.OWLObject;

/**
 * Represents a range limitations that could be added to a
 * {@link GeneratedVariable} instance with INDIVIDUAL {@link VariableType}, in
 * particular this restricts the possible values to the set of individuals that
 * are instances of a given OWLDescription
 * 
 * @author Luigi Iannone
 * 
 */
public class IndividualVariableScope implements VariableScope {
	private static Map<OWLDescription, IndividualVariableScope> cache = new HashMap<OWLDescription, IndividualVariableScope>();
	protected OWLDescription description;

	/**
	 * @param description
	 */
	IndividualVariableScope(OWLDescription description) {
		this.description = description;
	}

	static IndividualVariableScope buildIndividualVariableScope(
			OWLDescription individual) {
		IndividualVariableScope toReturn = cache.get(individual);
		if (toReturn == null) {
			toReturn = new IndividualVariableScope(individual);
			cache.put(individual, toReturn);
		}
		return toReturn;
	}

	/**
	 * @return the description
	 */
	public OWLDescription getDescription() {
		return this.description;
	}

	/**
	 * @param description
	 *            the description to set
	 */
	public void setDescription(OWLDescription description) {
		this.description = description;
	}

	public boolean check(OWLObject owlObject, VariableScopeChecker checker)
			throws OWLReasonerException {
		return owlObject instanceof OWLIndividual
				&& checker.check((OWLIndividual) owlObject, this);
	}

	/**
	 * @see org.coode.oppl.VariableScope#getDirection()
	 */
	public Direction getDirection() {
		return Direction.INSTANCEOF;
	}

	/**
	 * @see org.coode.oppl.VariableScope#getScopingObject()
	 */
	public OWLObject getScopingObject() {
		return this.getDescription();
	}
}
