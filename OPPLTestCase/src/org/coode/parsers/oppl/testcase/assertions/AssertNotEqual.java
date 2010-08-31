package org.coode.parsers.oppl.testcase.assertions;

import java.util.Formatter;

/**
 * Asserts that the expression on the left is not equal to the one on the right.
 * 
 * @author Luigi Iannone
 * 
 */
public class AssertNotEqual implements Assertion {
	private final AssertionExpression left;
	private final AssertionExpression right;

	/**
	 * @param left
	 * @param right
	 */
	public AssertNotEqual(AssertionExpression left, AssertionExpression right) {
		if (left == null) {
			throw new NullPointerException("The left hand side on this equality cannot be null");
		}
		if (right == null) {
			throw new NullPointerException("The right hand side on this equality cannot be null");
		}
		this.left = left;
		this.right = right;
	}

	public <O> O accept(AssertionVisitorEx<O> visitor) {
		return visitor.visitAssertNotEqual(this);
	}

	public void accept(AssertionVisitor visitor) {
		visitor.visitAssertNotEqual(this);
	};

	/**
	 * @return the left
	 */
	public AssertionExpression getLeft() {
		return this.left;
	}

	/**
	 * @return the right
	 */
	public AssertionExpression getRight() {
		return this.right;
	}

	@Override
	public String toString() {
		Formatter formatter = new Formatter();
		formatter.format("%s != %s", this.getLeft(), this.getRight());
		return formatter.toString();
	}
}
