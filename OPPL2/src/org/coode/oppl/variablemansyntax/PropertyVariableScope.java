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
package org.coode.oppl.variablemansyntax;

import java.util.HashMap;
import java.util.Map;

import org.semanticweb.owl.model.OWLDataProperty;
import org.semanticweb.owl.model.OWLObject;
import org.semanticweb.owl.model.OWLObjectProperty;
import org.semanticweb.owl.model.OWLProperty;
import org.semanticweb.owl.model.OWLPropertyExpression;
import org.semanticweb.owl.model.OWLPropertyRange;

/**
 * Represents a range limitations that could be added to a {@link GeneratedVariable}
 * instance with OBJECTPROpERTY or DATAPROPERTY {@link VariableType}
 * 
 * @author Luigi Iannone
 * 
 */
@SuppressWarnings("unchecked")
public abstract class PropertyVariableScope<P extends OWLProperty<? extends OWLPropertyExpression, ? extends OWLPropertyRange>>
		implements VariableScope {
	static class Factory<P extends OWLProperty<? extends OWLPropertyExpression, ? extends OWLPropertyRange>> {
		private final Map<P, SuperPropertyVariableScope<P>> superPropertyScopes = new HashMap<P, SuperPropertyVariableScope<P>>();
		private final Map<P, SubPropertyVariableScope<P>> subPropertyScopes = new HashMap<P, SubPropertyVariableScope<P>>();

		SuperPropertyVariableScope<P> buildSuperPropertyVariableScope(P property) {
			SuperPropertyVariableScope<P> toReturn = this.superPropertyScopes
					.get(property);
			if (toReturn == null) {
				toReturn = new SuperPropertyVariableScope<P>(property);
				this.superPropertyScopes.put(property, toReturn);
			}
			return toReturn;
		}

		SubPropertyVariableScope<P> buildSubPropertyVariableScope(P property) {
			SubPropertyVariableScope<P> toReturn = this.subPropertyScopes
					.get(property);
			if (toReturn == null) {
				toReturn = new SubPropertyVariableScope<P>(property);
				this.subPropertyScopes.put(property, toReturn);
			}
			return toReturn;
		}
	}

	private static Factory<OWLDataProperty> dataPropertyFactory = new Factory<OWLDataProperty>();
	private static Factory<OWLObjectProperty> objectPropertyFactory = new Factory<OWLObjectProperty>();
	private final P property;

	/**
	 * @param property
	 */
	PropertyVariableScope(P property) {
		this.property = property;
	}

	/**
	 * @return the property
	 */
	public P getProperty() {
		return this.property;
	}

	static SubPropertyVariableScope<OWLDataProperty> buildSubPropertyVariableScope(
			OWLDataProperty aDataProperty) {
		return dataPropertyFactory.buildSubPropertyVariableScope(aDataProperty);
	}

	static SubPropertyVariableScope<OWLObjectProperty> buildSubPropertyVariableScope(
			OWLObjectProperty anObjectProperty) {
		return objectPropertyFactory
				.buildSubPropertyVariableScope(anObjectProperty);
	}

	static SuperPropertyVariableScope<OWLDataProperty> buildSuperPropertyVariableScope(
			OWLDataProperty aDataProperty) {
		return dataPropertyFactory
				.buildSuperPropertyVariableScope(aDataProperty);
	}

	static SuperPropertyVariableScope<OWLObjectProperty> buildSuperPropertyVariableScope(
			OWLObjectProperty anObjectProperty) {
		return objectPropertyFactory
				.buildSuperPropertyVariableScope(anObjectProperty);
	}

	/**
	 * @see org.coode.oppl.variablemansyntax.VariableScope#getScopingObject()
	 */
	public OWLObject getScopingObject() {
		return this.getProperty();
	}
}
