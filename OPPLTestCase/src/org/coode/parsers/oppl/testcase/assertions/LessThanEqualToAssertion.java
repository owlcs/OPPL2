/**
 * 
 */
package org.coode.parsers.oppl.testcase.assertions;

import java.util.Set;

import org.coode.oppl.ConstraintSystem;
import org.coode.oppl.bindingtree.BindingNode;

/**
 * Represents the assertion that the left hand side is less than the right hand
 * side
 * 
 * @author Luigi Iannone
 * 
 */
public class LessThanEqualToAssertion implements Assertion {
	private final AssertionExpression<Integer> left;
	private final AssertionExpression<Integer> right;

	/**
	 * @param left
	 * @param right
	 */
	public LessThanEqualToAssertion(AssertionExpression<Integer> left,
			AssertionExpression<Integer> right) {
		if (left == null) {
			throw new NullPointerException(
					"The left hand side on this equality cannot be null");
		}
		if (right == null) {
			throw new NullPointerException(
					"The right hand side on this equality cannot be null");
		}
		this.left = left;
		this.right = right;
	}

	/**
	 * @return the left
	 */
	public AssertionExpression<Integer> getLeft() {
		return this.left;
	}

	/**
	 * @return the right
	 */
	public AssertionExpression<Integer> getRight() {
		return this.right;
	}

	public void accept(AssertionVisitor visitor) {
		visitor.visitAssertLessThanEqualTo(this);
	}

	public <O> O accept(AssertionVisitorEx<O> visitor) {
		return visitor.visitAssertLessThanEqualtTo(this);
	}

	public boolean holds(Set<? extends BindingNode> bindings,
			ConstraintSystem constraintSystem) {
		return this.getLeft().resolve(bindings, constraintSystem) <= this
				.getRight().resolve(bindings, constraintSystem);
	}
}
