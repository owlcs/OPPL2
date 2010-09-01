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

import java.net.URI;

import org.coode.oppl.ManchesterVariableSyntax;
import org.coode.oppl.PlainVariableVisitor;
import org.coode.oppl.Variable;
import org.coode.oppl.VariableScope;
import org.coode.oppl.VariableScopeChecker;
import org.coode.oppl.VariableType;
import org.coode.oppl.VariableTypeVisitorEx;
import org.coode.oppl.VariableVisitor;
import org.coode.oppl.utils.ArgCheck;

/**
 * @author Luigi Iannone
 * 
 */
public abstract class VariableImpl implements Variable {
	private final String name;
	private final VariableType type;
	private final URI uri;
	private VariableScope variableScope = null;

	protected VariableImpl(String name, VariableType type) {
		ArgCheck.checkNullArgument("The name", name);
		ArgCheck.checkNullArgument("The type", type);
		this.name = name;
		this.type = type;
		this.uri = URI.create(ManchesterVariableSyntax.NAMESPACE + this.getName());
	}

	public String getName() {
		return this.name;
	}

	public URI getURI() {
		return this.uri;
	}

	/**
	 * @return the type
	 */
	public VariableType getType() {
		return this.type;
	}

	@Override
	public String toString() {
		return this.name + ":" + this.getType();
	}

	@Override
	public boolean equals(Object obj) {
		return obj instanceof Variable && this.name.equals(((Variable) obj).getName());
	}

	@Override
	public int hashCode() {
		return this.name.hashCode();
	}

	public VariableScope getVariableScope() {
		return this.variableScope;
	}

	public void setVariableScope(VariableScope variableScope,
			VariableScopeChecker variableScopeChecker) {
		this.variableScope = variableScope;
	}

	public <P> P accept(VariableVisitor<P> visitor) {
		return visitor.visit(this);
	}

	public abstract <P> P accept(VariableTypeVisitorEx<P> visitor);

	public void accept(PlainVariableVisitor visitor) {
		visitor.visit(this);
	}
}
