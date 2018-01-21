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

import java.util.stream.Stream;

import org.coode.oppl.VariableScopes.Direction;
import org.coode.oppl.generated.GeneratedVariable;
import org.coode.oppl.variabletypes.VariableType;
import org.semanticweb.owlapi.model.OWLObject;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLProperty;
import org.semanticweb.owlapi.model.OWLPropertyExpression;
import org.semanticweb.owlapi.model.OWLRuntimeException;
import org.semanticweb.owlapi.search.EntitySearcher;

/**
 * Represents a range limitations that could be added to a {@link GeneratedVariable} instance with
 * OBJECTPROERTY or DATAPROPERTY {@link VariableType}, in particular this restricts the possible
 * values to the set of primitive object properties or data properties that are sub-properties of a
 * given property
 * 
 * @author Luigi Iannone
 * @param <P> type
 */
public class SubPropertyVariableScope<P extends OWLPropertyExpression>
    extends PropertyVariableScope<P> {

    SubPropertyVariableScope(P property, VariableScopeChecker checker) {
        super(property, checker);
    }

    @Override
    public boolean check(OWLObject owlObject) throws OWLRuntimeException {
        return owlObject instanceof OWLProperty
            && this.check(getProperty(), getChecker().getOntologyManager().ontologies());
    }

    boolean check(P property, Stream<OWLOntology> ontologies) {
        return EntitySearcher.getSuperProperties(property, ontologies).anyMatch(property::equals);
    }

    @Override
    public Direction getDirection() {
        return Direction.SUBPROPERTYOF;
    }
}
