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
package org.coode.oppl.variabletypes;

import java.util.Collection;
import java.util.EnumSet;
import java.util.Set;
import java.util.regex.Pattern;

import org.coode.oppl.VariableScope;
import org.coode.oppl.VariableScopes.Direction;
import org.coode.oppl.function.OPPLFunction;
import org.coode.oppl.generated.GeneratedVariable;
import org.coode.oppl.generated.RegexpGeneratedVariable;
import org.semanticweb.owlapi.model.OWLObject;
import org.semanticweb.owlapi.model.OWLOntology;

/** @author Luigi Iannone
 * @param <O> */
public interface VariableType<O extends OWLObject> {
    /** @param ontologies
     * @return referenced objects */
    Set<O> getReferencedOWLObjects(Collection<? extends OWLOntology> ontologies);

    /** @return allowed deirections */
    EnumSet<Direction> getAllowedDirections();

    /** @param o
     * @return true if compatible */
    boolean isCompatibleWith(OWLObject o);

    /** @param name
     * @param patternGeneratingOPPLFunction
     * @return generated variable */
    RegexpGeneratedVariable<? extends O> getRegexpGeneratedVariable(String name,
            OPPLFunction<Pattern> patternGeneratingOPPLFunction);

    /** @param name
     * @param variableScope
     * @return input variable */
    InputVariable<O> getInputVariable(String name, VariableScope<?> variableScope);

    /** @param name
     * @param opplFunction
     * @return generated variable */
    GeneratedVariable<O> getGeneratedVariable(String name,
            OPPLFunction<? extends O> opplFunction);

    /** @param visitor */
    void accept(VariableTypeVisitor visitor);

    /** @param visitor
     * @return visitor value */
    <P> P accept(VariableTypeVisitorEx<P> visitor);
}
