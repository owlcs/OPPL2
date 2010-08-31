package org.coode.parsers.oppl.testcase.assertions;

import java.util.Set;

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

	public <O> O accept(AssertionExpressionVisitorEx<O> assertionExpressionVisitor) {
		return assertionExpressionVisitor.visitIntegerAssertionExpressionVisitor(this);
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

	public Integer resolve(Set<? extends BindingNode> bindings) {
		return this.getIntValue();
	}
}
