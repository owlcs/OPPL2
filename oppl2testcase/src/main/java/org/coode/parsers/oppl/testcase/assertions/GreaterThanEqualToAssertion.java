/**
 * 
 */
package org.coode.parsers.oppl.testcase.assertions;

import java.util.Formatter;
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
public class GreaterThanEqualToAssertion implements Assertion {
	private final AssertionExpression<Integer> left;
	private final AssertionExpression<Integer> right;

	/**
	 * @param left
	 * @param right
	 */
	public GreaterThanEqualToAssertion(AssertionExpression<Integer> left,
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
		visitor.visitAssertGreaterThanEqualTo(this);
	}

	public <O> O accept(AssertionVisitorEx<O> visitor) {
		return visitor.visitAssertGreaterThanEqualTo(this);
	}

	public boolean holds(Set<? extends BindingNode> bindings,
			ConstraintSystem constraintSystem) {
		return this.getLeft().resolve(bindings, constraintSystem) >= this
				.getRight().resolve(bindings, constraintSystem);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ (this.left == null ? 0 : this.left.hashCode());
		result = prime * result
				+ (this.right == null ? 0 : this.right.hashCode());
		return result;
	}

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
		GreaterThanEqualToAssertion other = (GreaterThanEqualToAssertion) obj;
		if (this.left == null) {
			if (other.left != null) {
				return false;
			}
		} else if (!this.left.equals(other.left)) {
			return false;
		}
		if (this.right == null) {
			if (other.right != null) {
				return false;
			}
		} else if (!this.right.equals(other.right)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		Formatter formatter = new Formatter();
		formatter.format("%s >= %s", this.getLeft().toString(), this.getRight()
				.toString());
		return formatter.toString();
	}
}
