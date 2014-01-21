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
import org.coode.oppl.generated.GeneratedVariable;
import org.coode.oppl.rendering.ManchesterSyntaxRenderer;
import org.coode.oppl.variabletypes.VariableType;
import org.semanticweb.owlapi.model.OWLClassExpression;
import org.semanticweb.owlapi.model.OWLIndividual;
import org.semanticweb.owlapi.model.OWLObject;
import org.semanticweb.owlapi.model.OWLRuntimeException;

/** Represents a range limitations that could be added to a
 * {@link GeneratedVariable} instance with INDIVIDUAL {@link VariableType}, in
 * particular this restricts the possible values to the set of individuals that
 * are instances of a given OWLClassExpression
 * 
 * @author Luigi Iannone */
public class IndividualVariableScope extends AbstractVariableScope<OWLClassExpression>
        implements VariableScope<OWLClassExpression> {
    private static Map<OWLClassExpression, IndividualVariableScope> cache = new HashMap<OWLClassExpression, IndividualVariableScope>();
    private OWLClassExpression classExpression;

    /** @param classExpression
     *            classExpression
     * @param checker
     *            checker */
    IndividualVariableScope(OWLClassExpression classExpression,
            VariableScopeChecker checker) {
        super(checker);
        this.classExpression = classExpression;
    }

    static IndividualVariableScope buildIndividualVariableScope(
            OWLClassExpression classDescription, VariableScopeChecker checker) {
        IndividualVariableScope toReturn = cache.get(classDescription);
        if (toReturn == null) {
            toReturn = new IndividualVariableScope(classDescription, checker);
            cache.put(classDescription, toReturn);
        }
        return toReturn;
    }

    /** @return the description */
    public OWLClassExpression getClassExpression() {
        return classExpression;
    }

    /** @param classExpression
     *            the description to set */
    public void setDescription(OWLClassExpression classExpression) {
        this.classExpression = classExpression;
    }

    @Override
    public boolean check(OWLObject owlObject) throws OWLRuntimeException {
        return owlObject instanceof OWLIndividual
                && getChecker().check((OWLIndividual) owlObject, this);
    }

    @Override
    public Direction getDirection() {
        return Direction.INSTANCEOF;
    }

    @Override
    public OWLClassExpression getScopingObject() {
        return getClassExpression();
    }

    @Override
    public String render(ConstraintSystem constraintSystem) {
        ManchesterSyntaxRenderer renderer = constraintSystem.getOPPLFactory()
                .getManchesterSyntaxRenderer(constraintSystem);
        getClassExpression().accept(renderer);
        return String.format("[%s %s]", getDirection(), renderer);
    }
}
