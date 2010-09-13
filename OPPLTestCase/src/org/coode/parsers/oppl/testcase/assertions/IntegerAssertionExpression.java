package org.coode.parsers.oppl.testcase.assertions;

import java.util.Set;

import org.coode.oppl.ConstraintSystem;
import org.coode.oppl.bindingtree.BindingNode;

/**
 * Represents an Integer
 * 
 * @author Luigi Iannone
 * 
 */
public class IntegerAssertionExpression implements AssertionExpression<Integer> {
	private final int intValue;

	/**
	 * @param intValue
	 */
	public IntegerAssertionExpression(int intValue) {
		this.intValue = intValue;
	}

	public void accept(AssertionExpressionVisitor assertionExpressionVisitor) {
		assertionExpressionVisitor.visitIntegerAssertionExpressionVisitor(this);
	}

	public <O> O accept(
			AssertionExpressionVisitorEx<O> assertionExpressionVisitor) {
		return assertionExpressionVisitor
				.visitIntegerAssertionExpressionVisitor(this);
	}

	/**
	 * @return the intValue
	 */
	public int getIntValue() {
		return this.intValue;
	}

	@Override
	public String toString() {
		return Integer.toString(this.getIntValue());
	}

	public Integer resolve(Set<? extends BindingNode> bindings,
			ConstraintSystem constraintSystem) {
		return this.getIntValue();
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
		result = prime * result + this.intValue;
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
		IntegerAssertionExpression other = (IntegerAssertionExpression) obj;
		if (this.intValue != other.intValue) {
			return false;
		}
		return true;
	}
}
