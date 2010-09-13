package org.coode.parsers.oppl.testcase.assertions;

import java.util.Formatter;
import java.util.HashSet;
import java.util.Set;

import org.coode.oppl.ConstraintSystem;
import org.coode.oppl.Variable;
import org.coode.oppl.bindingtree.BindingNode;
import org.semanticweb.owlapi.model.OWLObject;

public class CountAssertionExpression implements AssertionExpression<Integer> {
	private final Variable variable;

	/**
	 * @param variable
	 */
	public CountAssertionExpression(Variable variable) {
		if (variable == null) {
			throw new NullPointerException("The variable cannot be null");
		}
		this.variable = variable;
	}

	/**
	 * @return the variable
	 */
	public Variable getVariable() {
		return this.variable;
	}

	public void accept(AssertionExpressionVisitor assertionExpressionVisitor) {
		assertionExpressionVisitor.visitCountAssertionExpression(this);
	}

	public <O> O accept(
			AssertionExpressionVisitorEx<O> assertionExpressionVisitor) {
		return assertionExpressionVisitor.visitCountAssertionExpression(this);
	}

	@Override
	public String toString() {
		Formatter formatter = new Formatter();
		formatter.format("count(%s)", this.getVariable().getName());
		return formatter.toString();
	}

	public Integer resolve(Set<? extends BindingNode> bindings,
			ConstraintSystem constraintSystem) {
		Set<OWLObject> values = new HashSet<OWLObject>(bindings.size());
		for (BindingNode bindingNode : bindings) {
			OWLObject value = bindingNode
					.getAssignmentValue(this.getVariable());
			if (value != null) {
				values.add(value);
			}
		}
		return values.size();
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
		CountAssertionExpression other = (CountAssertionExpression) obj;
		if (this.variable == null) {
			if (other.variable != null) {
				return false;
			}
		} else if (!this.variable.equals(other.variable)) {
			return false;
		}
		return true;
	}
}
