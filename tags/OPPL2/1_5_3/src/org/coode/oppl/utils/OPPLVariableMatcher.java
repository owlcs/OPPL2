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
 * 
 */
public class OPPLVariableMatcher {
	/**
	 * @param name
	 * @param cs
	 * @param matchClasses
	 * @param matchObjectProperties
	 * @param matchDataProperties
	 * @param matchIndividuals
	 * @param matchConstants
	 * @return the Set of Variable instances whose names start with the input
	 *         String from the input ConstraintSystem, provided their type has
	 *         to be included.
	 */
	public static Set<Variable<?>> matches(final String name, ConstraintSystem constraintSystem,
			final boolean matchClasses, final boolean matchObjectProperties,
			final boolean matchDataProperties, final boolean matchIndividuals,
			final boolean matchConstants, final boolean matchAnnotationProperty) {
		Set<Variable<?>> variables = constraintSystem.getVariables();
		Set<Variable<?>> toReturn = new HashSet<Variable<?>>(variables.size());
		VariableTypeVisitorEx<Boolean> visitor = new VariableTypeVisitorEx<Boolean>() {
			public Boolean visitCLASSVariableType(CLASSVariableType classVariableType) {
				return matchClasses;
			}

			public Boolean visitOBJECTPROPERTYVariableType(
					OBJECTPROPERTYVariableType objectpropertyVariableType) {
				return matchObjectProperties;
			}

			public Boolean visitDATAPROPERTYVariableType(
					DATAPROPERTYVariableType datapropertyVariableType) {
				return matchDataProperties;
			}

			public Boolean visitINDIVIDUALVariableType(INDIVIDUALVariableType individualVariableType) {
				return matchIndividuals;
			}

			public Boolean visitCONSTANTVariableType(CONSTANTVariableType constantVariableType) {
				return matchConstants;
			}

			public Boolean visitANNOTATIONPROPERTYVariableType(
					ANNOTATIONPROPERTYVariableType annotationpropertyVariableType) {
				return matchAnnotationProperty;
			}
		};
		for (Variable<?> variable : variables) {
			if (variable != null && variable.getName().startsWith(name)
					&& variable.getType().accept(visitor)) {
				toReturn.add(variable);
			}
		}
		return toReturn;
	}
}
