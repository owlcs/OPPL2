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

import org.coode.oppl.generated.GeneratedVariable;
import org.coode.oppl.rendering.ManchesterSyntaxRenderer;
import org.coode.oppl.variabletypes.VariableType;
import org.semanticweb.owlapi.model.OWLPropertyExpression;

/**
 * Represents a range limitations that could be added to a
 * {@link GeneratedVariable} instance with OBJECTPROpERTY or DATAPROPERTY
 * {@link VariableType}
 * 
 * @author Luigi Iannone
 * 
 */
public abstract class PropertyVariableScope<P extends OWLPropertyExpression<?, ?>> extends
		AbstractVariableScope<P> implements VariableScope<P> {
	private final P property;

	/**
	 * @param property
	 */
	PropertyVariableScope(P property, VariableScopeChecker checker) {
		super(checker);
		this.property = property;
	}

	/**
	 * @return the property
	 */
	public P getProperty() {
		return this.property;
	}

	static <O extends OWLPropertyExpression<?, ?>> SubPropertyVariableScope<O> buildSubPropertyVariableScope(
			O property, VariableScopeChecker checker) {
		return new SubPropertyVariableScope<O>(property, checker);
	}

	static <O extends OWLPropertyExpression<?, ?>> SuperPropertyVariableScope<O> buildSuperPropertyVariableScope(
			O property, VariableScopeChecker checker) {
		return new SuperPropertyVariableScope<O>(property, checker);
	}

	/**
	 * @see org.coode.oppl.VariableScope#getScopingObject()
	 */
	public P getScopingObject() {
		return this.getProperty();
	}

	public String render(ConstraintSystem constraintSystem) {
		ManchesterSyntaxRenderer renderer = constraintSystem.getOPPLFactory().getManchesterSyntaxRenderer(
				constraintSystem);
		this.getScopingObject().accept(renderer);
		return String.format("[%s %s]", this.getDirection(), renderer);
	}
}
