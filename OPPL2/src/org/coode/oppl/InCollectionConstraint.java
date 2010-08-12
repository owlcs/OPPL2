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

import java.util.Collection;
import java.util.Formatter;
import java.util.HashSet;
import java.util.Set;

import org.coode.oppl.rendering.ManchesterSyntaxRenderer;
import org.semanticweb.owlapi.model.OWLObject;

/**
 * Constraint that verifies whether a variable values are contained in a
 * collection
 * 
 * @author Luigi Iannone
 * 
 */
public class InCollectionConstraint<P extends OWLObject> implements AbstractConstraint {
	private final Variable variable;
	private final Set<P> collection = new HashSet<P>();
	private final ConstraintSystem constraintSystem;

	/**
	 * @param variable
	 * @param collection
	 * @param constraintSystem
	 */
	public InCollectionConstraint(Variable variable, Collection<? extends P> collection,
			ConstraintSystem constraintSystem) {
		if (variable == null) {
			throw new NullPointerException("The variable cannot be null");
		}
		if (collection == null) {
			throw new NullPointerException("The collection of values cannot be null");
		}
		if (constraintSystem == null) {
			throw new NullPointerException("The constraint system cannot be null");
		}
		if (collection.isEmpty()) {
			throw new IllegalArgumentException("The collection of values cannot be empty");
		}
		for (P p : collection) {
			if (!variable.getType().isCompatibleWith(p)) {
				ManchesterSyntaxRenderer manchesterSyntaxRenderer = constraintSystem.getOPPLFactory().getManchesterSyntaxRenderer(
						constraintSystem);
				p.accept(manchesterSyntaxRenderer);
				Formatter formatter = new Formatter();
				formatter.format(
						"The value %s is incompatible with variable %s of type %s",
						manchesterSyntaxRenderer.toString(),
						variable,
						variable.getType());
				throw new IllegalArgumentException(formatter.out().toString());
			}
		}
		this.variable = variable;
		this.collection.addAll(collection);
		this.constraintSystem = constraintSystem;
	}

	/**
	 * Visitor pattern required method
	 * 
	 * @return the specific output of the visit (dependent on the implementation
	 *         of the visitor input instance)
	 * @see org.coode.oppl.AbstractConstraint#accept(org.coode.oppl.ConstraintVisitorEx)
	 */
	public <O> O accept(ConstraintVisitorEx<O> visitor) {
		return visitor.visit(this);
	}

	/**
	 * @return the variable
	 */
	public Variable getVariable() {
		return this.variable;
	}

	/**
	 * @return the collection
	 */
	public Set<P> getCollection() {
		return new HashSet<P>(this.collection);
	}

	@Override
	public int hashCode() {
		return 3 * this.variable.hashCode() * 5 * this.collection.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		boolean toReturn = false;
		if (obj instanceof InCollectionConstraint<?>) {
			InCollectionConstraint<?> toCompare = (InCollectionConstraint<?>) obj;
			toReturn = this.getVariable().equals(toCompare.variable)
					&& this.getCollection().equals(toCompare.collection);
		}
		return toReturn;
	}

	@Override
	public String toString() {
		StringBuilder buffer = new StringBuilder();
		buffer.append(this.variable.getName());
		buffer.append(" IN {");
		boolean first = true;
		String comma;
		for (P p : this.collection) {
			ManchesterSyntaxRenderer manchesterSyntaxRenderer = this.getConstraintSystem().getOPPLFactory().getManchesterSyntaxRenderer(
					this.getConstraintSystem());
			comma = !first ? ", " : "";
			first = false;
			buffer.append(comma);
			p.accept(manchesterSyntaxRenderer);
			buffer.append(manchesterSyntaxRenderer.toString());
		}
		buffer.append('}');
		return buffer.toString();
	}

	public String render() {
		StringBuffer buffer = new StringBuffer();
		buffer.append(this.variable.getName());
		buffer.append(" IN {");
		boolean first = true;
		String comma;
		for (P p : this.collection) {
			comma = !first ? ", " : "";
			first = false;
			buffer.append(comma);
			ManchesterSyntaxRenderer renderer = this.getConstraintSystem().getOPPLFactory().getManchesterSyntaxRenderer(
					this.getConstraintSystem());
			p.accept(renderer);
			buffer.append(renderer.toString());
		}
		buffer.append('}');
		return buffer.toString();
	}

	public void accept(ConstraintVisitor visitor) {
		visitor.visitInCollectionConstraint(this);
	}

	/**
	 * @return the constraintSystem
	 */
	public ConstraintSystem getConstraintSystem() {
		return this.constraintSystem;
	}
}
