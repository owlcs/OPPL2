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

import java.util.Set;

import org.coode.oppl.VariableScopes.Direction;
import org.semanticweb.owlapi.model.OWLObject;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLProperty;
import org.semanticweb.owlapi.model.OWLPropertyExpression;
import org.semanticweb.owlapi.model.OWLRuntimeException;

/**
 * Represents a range limitations that could be added to a
 * {@link GeneratedVariable} instance with OBJECTPROERTY or DATAPRPERTY
 * {@link VariableType}, in particular this restricts the possible values to the
 * set of primitive object properties or data properties that are
 * super-properties of a given property
 * 
 * @author Luigi Iannone
 * 
 */
public class SuperPropertyVariableScope<P extends OWLPropertyExpression<?, ?>> extends
		PropertyVariableScope<P> {
	SuperPropertyVariableScope(P property) {
		super(property);
	}

	public boolean check(OWLObject owlObject, VariableScopeChecker checker)
			throws OWLRuntimeException {
		return owlObject instanceof OWLProperty
				&& this.check(this.getProperty(), checker.getOntologyManager().getOntologies());
	}

	boolean check(P property, Set<OWLOntology> ontologies) {
		return property.getSubProperties(ontologies).contains(property);
	}

	/**
	 * @see org.coode.oppl.VariableScope#getDirection()
	 */
	public Direction getDirection() {
		return Direction.SUPERPROPERTYOF;
	}
}
