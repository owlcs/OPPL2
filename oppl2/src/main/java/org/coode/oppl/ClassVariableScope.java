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

import org.coode.oppl.generated.GeneratedVariable;
import org.coode.oppl.rendering.ManchesterSyntaxRenderer;
import org.coode.oppl.variabletypes.VariableType;
import org.semanticweb.owlapi.model.OWLClassExpression;

/**
 * Represents a range limitations that could be added to a
 * {@link GeneratedVariable} instance with CLASS {@link VariableType}
 * 
 * @author Luigi Iannone
 */
public abstract class ClassVariableScope extends
    AbstractVariableScope<OWLClassExpression>implements
    VariableScope<OWLClassExpression> {

    private final OWLClassExpression description;
    private static Map<OWLClassExpression, SuperClassVariableScope> superClassesScopes = new HashMap<>();
    private static Map<OWLClassExpression, SubClassVariableScope> subClassesScopes = new HashMap<>();

    /**
     * @param description
     *        description
     * @param checker
     *        checker
     */
    ClassVariableScope(OWLClassExpression description, VariableScopeChecker checker) {
        super(checker);
        this.description = description;
    }

    /**
     * @return the description
     */
    public OWLClassExpression getClassExpression() {
        return description;
    }

    static SubClassVariableScope buildSubClassVariableScope(
        OWLClassExpression description, VariableScopeChecker checker) {
        SubClassVariableScope toReturn = subClassesScopes.get(description);
        if (toReturn == null) {
            toReturn = new SubClassVariableScope(description, checker);
            subClassesScopes.put(description, toReturn);
        }
        return toReturn;
    }

    static SuperClassVariableScope buildSuperClassVariableScope(
        OWLClassExpression description, VariableScopeChecker checker) {
        SuperClassVariableScope toReturn = superClassesScopes.get(description);
        if (toReturn == null) {
            toReturn = new SuperClassVariableScope(description, checker);
            superClassesScopes.put(description, toReturn);
        }
        return toReturn;
    }

    @Override
    public OWLClassExpression getScopingObject() {
        return getClassExpression();
    }

    @Override
    public String render(ConstraintSystem constraintSystem) {
        ManchesterSyntaxRenderer renderer = constraintSystem.getOPPLFactory()
            .getManchesterSyntaxRenderer(constraintSystem);
        getScopingObject().accept(renderer);
        return String.format("[%s %s]", getDirection(), renderer);
    }
}
