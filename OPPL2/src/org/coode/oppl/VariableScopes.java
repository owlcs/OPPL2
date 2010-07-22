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

import org.semanticweb.owl.model.OWLDataProperty;
import org.semanticweb.owl.model.OWLDescription;
import org.semanticweb.owl.model.OWLPropertyExpression;

/**
 * This class consists exclusively of static methods that operate on or return
 * {@link VariableScope} instances
 * 
 * @author Luigi Iannone
 * 
 */
public class VariableScopes {
	/**
	 * @author Luigi Iannone
	 * 
	 */
	public enum Direction {
		SUBCLASSOF("subClassOf"), SUPERCLASSOF("superClassOf"), SUBPROPERTYOF(
				"subPropertyOf"), SUPERPROPERTYOF("superPropertyOf"), INSTANCEOF(
				"instanceOf");
		private String direction;

		Direction(String s) {
			this.direction = s;
		}

		/**
		 * Parser the input String and returns the corresponding Direction. If
		 * the input does not correspond to any possible Direction instance,
		 * then <code>null</code> is returned. The method is case insensitive.
		 * 
		 * @param direction
		 * @return the Direction corresponding to the input String (can be null)
		 */
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
			return this.direction;
		}
	}

	/**
	 * @param description
	 * @return a VariableScope instance restricting values to be sub-classes of
	 *         the input OWLDescription
	 */
	public static SubClassVariableScope buildSubClassVariableScope(
			OWLDescription description) {
		return ClassVariableScope.buildSubClassVariableScope(description);
	}

	/**
	 * @param description
	 * @return a VariableScope instance restricting values to be super-classes
	 *         of the input OWLDescription
	 */
	public static SuperClassVariableScope buildSuperClassVariableScope(
			OWLDescription description) {
		return ClassVariableScope.buildSuperClassVariableScope(description);
	}

	/**
	 * @param property
	 * @return a VariableScope instance restricting values to be sub-properties
	 *         of the input OWLProperty
	 */
	public static SubPropertyVariableScope<OWLDataProperty> buildSubPropertyVariableScope(
			OWLDataProperty property) {
		return PropertyVariableScope.buildSubPropertyVariableScope(property);
	}

	/**
	 * @param property
	 * @return a VariableScope instance restricting values to be sub-properties
	 *         of the input OWLProperty
	 */
	public static <P extends OWLPropertyExpression<?, ?>> SubPropertyVariableScope<P> buildSubPropertyVariableScope(
			P property) {
		return PropertyVariableScope.buildSubPropertyVariableScope(property);
	}

	/**
	 * @param property
	 * @return a VariableScope instance restricting values to be
	 *         super-properties of the input OWLProperty
	 */
	public static <P extends OWLPropertyExpression<?, ?>> SuperPropertyVariableScope<P> buildSuperPropertyVariableScope(
			P property) {
		return PropertyVariableScope.buildSuperPropertyVariableScope(property);
	}

	/**
	 * @param description
	 * @return a VariableScope instance restricting values to be instances of
	 *         the input OWLDescription
	 */
	public static IndividualVariableScope buildIndividualVariableScope(
			OWLDescription description) {
		return IndividualVariableScope
				.buildIndividualVariableScope(description);
	}
}
