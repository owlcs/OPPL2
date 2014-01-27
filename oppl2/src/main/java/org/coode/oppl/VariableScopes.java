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

import org.semanticweb.owlapi.model.OWLClassExpression;
import org.semanticweb.owlapi.model.OWLDataProperty;
import org.semanticweb.owlapi.model.OWLPropertyExpression;

/** This class consists exclusively of static methods that operate on or return
 * {@link VariableScope} instances
 * 
 * @author Luigi Iannone */
public class VariableScopes {
    /** @author Luigi Iannone */
    public enum Direction {
        /** subclass */
        SUBCLASSOF("subClassOf"),
        /** superclass */
        SUPERCLASSOF("superClassOf"),
        /** subproperty */
        SUBPROPERTYOF("subPropertyOf"),
        /** superproperty */
        SUPERPROPERTYOF("superPropertyOf"),
        /** instance */
        INSTANCEOF("instanceOf");
        private final String direction;

        Direction(String s) {
            direction = s;
        }

        /** Parser the input String and returns the corresponding Direction. If
         * the input does not correspond to any possible Direction instance,
         * then {@code null} is returned. The method is case insensitive.
         * 
         * @param direction
         *            direction
         * @return the Direction corresponding to the input String (can be null) */
        public static Direction getDirection(String direction) {
            for (Direction d : values()) {
                if (direction.equalsIgnoreCase(d.direction)) {
                    return d;
                }
            }
            return null;
        }

        @Override
        public String toString() {
            return direction;
        }
    }

    /** @param description
     *            description
     * @param checker
     *            checker
     * @return a VariableScope instance restricting values to be sub-classes of
     *         the input OWLClassExpression */
    public static SubClassVariableScope buildSubClassVariableScope(
            OWLClassExpression description, VariableScopeChecker checker) {
        return ClassVariableScope.buildSubClassVariableScope(description, checker);
    }

    /** @param description
     *            description
     * @param checker
     *            checker
     * @return a VariableScope instance restricting values to be super-classes
     *         of the input OWLClassExpression */
    public static SuperClassVariableScope buildSuperClassVariableScope(
            OWLClassExpression description, VariableScopeChecker checker) {
        return ClassVariableScope.buildSuperClassVariableScope(description, checker);
    }

    /** @param property
     *            property
     * @param checker
     *            checker
     * @return a VariableScope instance restricting values to be sub-properties
     *         of the input OWLProperty */
    public static SubPropertyVariableScope<OWLDataProperty>
            buildSubPropertyVariableScope(OWLDataProperty property,
                    VariableScopeChecker checker) {
        return PropertyVariableScope.buildSubPropertyVariableScope(property, checker);
    }

    /** @param property
     *            property
     * @param checker
     *            checker
     * @param <P>
     *            property type
     * @return a VariableScope instance restricting values to be sub-properties
     *         of the input OWLProperty */
    public static <P extends OWLPropertyExpression<?, ?>> SubPropertyVariableScope<P>
            buildSubPropertyVariableScope(P property, VariableScopeChecker checker) {
        return PropertyVariableScope.buildSubPropertyVariableScope(property, checker);
    }

    /** @param property
     *            property
     * @param checker
     *            checker
     * @param <P>
     *            property type
     * @return a VariableScope instance restricting values to be
     *         super-properties of the input OWLProperty */
    public static <P extends OWLPropertyExpression<?, ?>> SuperPropertyVariableScope<P>
            buildSuperPropertyVariableScope(P property, VariableScopeChecker checker) {
        return PropertyVariableScope.buildSuperPropertyVariableScope(property, checker);
    }

    /** @param description
     *            description
     * @param checker
     *            checker
     * @return a VariableScope instance restricting values to be instances of
     *         the input OWLClassExpression */
    public static IndividualVariableScope buildIndividualVariableScope(
            OWLClassExpression description, VariableScopeChecker checker) {
        return IndividualVariableScope.buildIndividualVariableScope(description, checker);
    }
}
