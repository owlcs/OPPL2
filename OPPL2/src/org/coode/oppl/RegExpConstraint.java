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

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.coode.oppl.function.OPPLFunction;
import org.coode.oppl.function.ValueComputationParameters;
import org.coode.oppl.rendering.ManchesterSyntaxRenderer;
import org.semanticweb.owlapi.model.OWLObject;

/**
 * Constraint that verifies whether a variable values are contained in a
 * collection
 * 
 * @author Luigi Iannone
 * 
 */
public class RegExpConstraint implements AbstractConstraint {
	private final Variable variable;
	private final OPPLFunction<Pattern> expression;
	private final ConstraintSystem constraintSystem;

	/**
	 * @param variable
	 * @param collection
	 * @param constraintSystem
	 */
	public RegExpConstraint(Variable variable, OPPLFunction<Pattern> exp,
			ConstraintSystem cs) {
		this.variable = variable;
		this.constraintSystem = cs;
		this.expression = exp;
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

	public boolean matches(ValueComputationParameters parameters) {
		OWLObject assignmentValue = parameters.getBindingNode()
				.getAssignmentValue(this.getVariable(), parameters);
		boolean found = false;
		if (assignmentValue != null) {
			Pattern p = this.getExpression().compute(parameters);
			ManchesterSyntaxRenderer renderer = parameters
					.getConstraintSystem().getOPPLFactory()
					.getManchesterSyntaxRenderer(this.getConstraintSystem());
			assignmentValue.accept(renderer);
			Matcher matcher = p.matcher(renderer.toString());
			found = matcher.matches();
		}
		return found;
	}

	@Override
	public String toString() {
		return this.variable.getName() + " Match("
				+ this.getExpression().render(this.getConstraintSystem()) + ")";
	}

	public String render(ConstraintSystem constraintSystem) {
		return this.toString();
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ (this.expression == null ? 0 : this.expression.hashCode());
		result = prime * result
				+ (this.variable == null ? 0 : this.variable.hashCode());
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
		RegExpConstraint other = (RegExpConstraint) obj;
		if (this.expression == null) {
			if (other.expression != null) {
				return false;
			}
		} else if (!this.expression.equals(other.expression)) {
			return false;
		}
		if (this.variable == null) {
			if (other.variable != null) {
				return false;
			}
		} else if (!this.variable.equals(other.variable)) {
			return false;
		}
		return true;
	}

	/**
	 * @return the expression
	 */
	public OPPLFunction<Pattern> getExpression() {
		return this.expression;
	}
}
