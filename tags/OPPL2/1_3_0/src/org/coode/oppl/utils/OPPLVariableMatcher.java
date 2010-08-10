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
import org.coode.oppl.VariableTypeVisitorEx;
import org.coode.oppl.generated.SingleValueGeneratedVariable;
import org.coode.oppl.variabletypes.CLASSVariable;
import org.coode.oppl.variabletypes.CONSTANTVariable;
import org.coode.oppl.variabletypes.DATAPROPERTYVariable;
import org.coode.oppl.variabletypes.INDIVIDUALVariable;
import org.coode.oppl.variabletypes.OBJECTPROPERTYVariable;

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
	public static Set<Variable> matches(final String name,
			ConstraintSystem constraintSystem, final boolean matchClasses,
			final boolean matchObjectProperties,
			final boolean matchDataProperties, final boolean matchIndividuals,
			final boolean matchConstants) {
		Set<Variable> variables = constraintSystem.getVariables();
		Set<Variable> toReturn = new HashSet<Variable>(variables.size());
		VariableTypeVisitorEx<Variable> visitor = new VariableTypeVisitorEx<Variable>() {
			public Variable visit(SingleValueGeneratedVariable<?> v) {
				if (v.getName().startsWith(name)) {
					return v;
				}
				return null;
			}

			public Variable visit(INDIVIDUALVariable v) {
				if (matchIndividuals && v.getName().startsWith(name)) {
					return v;
				}
				return null;
			}

			public Variable visit(DATAPROPERTYVariable v) {
				if (matchDataProperties && v.getName().startsWith(name)) {
					return v;
				}
				return null;
			}

			public Variable visit(OBJECTPROPERTYVariable v) {
				if (matchObjectProperties && v.getName().startsWith(name)) {
					return v;
				}
				return null;
			}

			public Variable visit(CONSTANTVariable v) {
				if (matchConstants && v.getName().startsWith(name)) {
					return v;
				}
				return null;
			}

			public Variable visit(CLASSVariable v) {
				if (matchClasses && v.getName().startsWith(name)) {
					return v;
				}
				return null;
			}
		};
		for (Variable variable : variables) {
			Variable v = variable.accept(visitor);
			if (v != null) {
				toReturn.add(v);
			}
			// switch (variable.getType()) {
			// case CLASS:
			// if (matchClasses && variable.getName().startsWith(name)) {
			// toReturn.add(variable);
			// }
			// break;
			// case OBJECTPROPERTY:
			// if (matchObjectProperties
			// && variable.getName().startsWith(name)) {
			// toReturn.add(variable);
			// }
			// break;
			// case DATAPROPERTY:
			// if (matchDataProperties
			// && variable.getName().startsWith(name)) {
			// toReturn.add(variable);
			// }
			// break;
			// case INDIVIDUAL:
			// if (matchIndividuals && variable.getName().startsWith(name)) {
			// toReturn.add(variable);
			// }
			// break;
			// case CONSTANT:
			// if (matchConstants && variable.getName().startsWith(name)) {
			// toReturn.add(variable);
			// }
			// break;
			// default:
			// break;
			// }
		}
		return toReturn;
	}
}
