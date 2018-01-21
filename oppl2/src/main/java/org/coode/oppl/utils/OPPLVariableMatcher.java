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
package org.coode.oppl.utils;

import java.util.HashSet;
import java.util.Set;

import org.coode.oppl.ConstraintSystem;
import org.coode.oppl.Variable;
import org.coode.oppl.variabletypes.ANNOTATIONPROPERTYVariableType;
import org.coode.oppl.variabletypes.CLASSVariableType;
import org.coode.oppl.variabletypes.CONSTANTVariableType;
import org.coode.oppl.variabletypes.DATAPROPERTYVariableType;
import org.coode.oppl.variabletypes.INDIVIDUALVariableType;
import org.coode.oppl.variabletypes.OBJECTPROPERTYVariableType;
import org.coode.oppl.variabletypes.VariableTypeVisitorEx;

/**
 * Contains some utility method for matching variable names
 * 
 * @author Luigi Iannone
 */
public class OPPLVariableMatcher {

    /**
     * @param name name
     * @param constraintSystem constraintSystem
     * @param matchClasses matchClasses
     * @param matchObjectProperties matchObjectProperties
     * @param matchDataProperties matchDataProperties
     * @param matchIndividuals matchIndividuals
     * @param matchConstants matchConstants
     * @param matchAnnotationProperty matchAnnotationProperty
     * @return the Set of Variable instances whose names start with the input String from the input
     *         ConstraintSystem, provided their type has to be included.
     */
    public static Set<Variable<?>> matches(final String name, ConstraintSystem constraintSystem,
        final boolean matchClasses, final boolean matchObjectProperties,
        final boolean matchDataProperties, final boolean matchIndividuals,
        final boolean matchConstants, final boolean matchAnnotationProperty) {
        Set<Variable<?>> variables = constraintSystem.getVariables();
        Set<Variable<?>> toReturn = new HashSet<>(variables.size());
        VariableTypeVisitorEx<Boolean> visitor = new VariableTypeVisitorEx<Boolean>() {

            @Override
            public Boolean visitCLASSVariableType(CLASSVariableType classVariableType) {
                return Boolean.valueOf(matchClasses);
            }

            @Override
            public Boolean visitOBJECTPROPERTYVariableType(
                OBJECTPROPERTYVariableType objectpropertyVariableType) {
                return Boolean.valueOf(matchObjectProperties);
            }

            @Override
            public Boolean visitDATAPROPERTYVariableType(
                DATAPROPERTYVariableType datapropertyVariableType) {
                return Boolean.valueOf(matchDataProperties);
            }

            @Override
            public Boolean visitINDIVIDUALVariableType(
                INDIVIDUALVariableType individualVariableType) {
                return Boolean.valueOf(matchIndividuals);
            }

            @Override
            public Boolean visitCONSTANTVariableType(CONSTANTVariableType constantVariableType) {
                return Boolean.valueOf(matchConstants);
            }

            @Override
            public Boolean visitANNOTATIONPROPERTYVariableType(
                ANNOTATIONPROPERTYVariableType annotationpropertyVariableType) {
                return Boolean.valueOf(matchAnnotationProperty);
            }
        };
        for (Variable<?> variable : variables) {
            if (variable != null && variable.getName().startsWith(name)
                && variable.getType().accept(visitor).booleanValue()) {
                toReturn.add(variable);
            }
        }
        return toReturn;
    }
}
