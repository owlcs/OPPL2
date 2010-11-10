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

import org.coode.oppl.ConstraintSystem;
import org.coode.oppl.ManchesterVariableSyntax;
import org.coode.oppl.PlainVariableVisitor;
import org.coode.oppl.PlainVariableVisitorEx;
import org.coode.oppl.Variable;
import org.coode.oppl.VariableScope;
import org.coode.oppl.VariableScopeChecker;
import org.coode.oppl.VariableVisitor;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLObject;

/**
 * @author Luigi Iannone
 * 
 */
class VariableImpl<O extends OWLObject> implements Variable<O> {
	private final String name;
	private final VariableType<O> type;
	private final IRI iri;
	private VariableScope<?> variableScope = null;

	VariableImpl(String name, VariableType<O> type) {
		if (name == null) {
			throw new NullPointerException("The name of the variable cannot be null");
		}
		if (type == null) {
			throw new NullPointerException("The type of the variable cannot be null");
		}
		this.name = name;
		this.type = type;
		this.iri = IRI.create(ManchesterVariableSyntax.NAMESPACE + this.getName());
	}

	public String getName() {
		return this.name;
	}

	public IRI getIRI() {
		return this.iri;
	}

	/**
	 * @return the type
	 */
	public VariableType<O> getType() {
		return this.type;
	}

	@Override
	public String toString() {
		return this.name + ":" + this.getType();
	}

	public VariableScope<?> getVariableScope() {
		return this.variableScope;
	}

	public void setVariableScope(VariableScope<?> variableScope,
			VariableScopeChecker variableScopeChecker) {
		this.variableScope = variableScope;
	}

	public <P> P accept(VariableVisitor<P> visitor) {
		return visitor.visit(this);
	}

	public <T> T accept(PlainVariableVisitorEx<T> visitor) {
		return visitor.visit(this);
	}

	public void accept(PlainVariableVisitor visitor) {
		visitor.visit(this);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (this.name == null ? 0 : this.name.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (this.getClass() != obj.getClass()) {
			return false;
		}
		VariableImpl<?> other = (VariableImpl<?>) obj;
		if (this.name == null) {
			if (other.name != null) {
				return false;
			}
		} else if (!this.name.equals(other.name)) {
			return false;
		}
		return true;
	}

	public String render(ConstraintSystem constraintSystem) {
		String scope = this.getVariableScope() == null ? "" : this.getVariableScope().render(
				constraintSystem);
		return String.format("%s:%s%s", this.getName(), this.getType(), scope);
	}
}
