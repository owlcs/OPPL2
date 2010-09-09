/**
 * 
 */
package org.coode.parsers.oppl.testcase.assertions;

import java.util.Formatter;
import java.util.Set;

import org.coode.oppl.ConstraintSystem;
import org.coode.oppl.bindingtree.BindingNode;

/**
 * Asserts that the expression on the left is equal to the one on the right.
 * 
 * @author Luigi Iannone
 * 
 */
public class AssertEqual implements Assertion {
	private final AssertionExpression<?> left;
	private final AssertionExpression<?> right;

	/**
	 * @param left
	 * @param right
	 */
	public AssertEqual(AssertionExpression<?> left, AssertionExpression<?> right) {
		if (left == null) {
			throw new NullPointerException("The left hand side on this equality cannot be null");
		}
		if (right == null) {
			throw new NullPointerException("The right hand side on this equality cannot be null");
		}
		this.left = left;
		this.right = right;
	}

	/**
	 * @see org.coode.parsers.oppl.testcase.assertions.Assertion#accept(org.coode
	 *      .parsers.oppl.testcase.assertions.AssertionVisitor)
	 */
	public void accept(AssertionVisitor visitor) {
		visitor.visitAssertEqual(this);
	}

	/**
	 * @see org.coode.parsers.oppl.testcase.assertions.Assertion#accept(org.coode
	 *      .parsers.oppl.testcase.assertions.AssertionVisitorEx)
	 */
	public <O> O accept(AssertionVisitorEx<O> visitor) {
		return visitor.visitAssertEqual(this);
	}

	/**
	 * @return the left
	 */
	public AssertionExpression<?> getLeft() {
		return this.left;
	}

	/**
	 * @return the right
	 */
	public AssertionExpression<?> getRight() {
		return this.right;
	}

	@Override
	public String toString() {
		Formatter formatter = new Formatter();
		formatter.format("%s = %s", this.getLeft(), this.getRight());
		return formatter.toString();
	}

	public boolean holds(Set<? extends BindingNode> bindings, ConstraintSystem constraintSystem) {
		Object leftObjects = this.getLeft().resolve(bindings, constraintSystem);
		Object rightObjects = this.getRight().resolve(bindings, constraintSystem);
		return leftObjects.equals(rightObjects);
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
		result = prime * result + (this.left == null ? 0 : this.left.hashCode());
		result = prime * result + (this.right == null ? 0 : this.right.hashCode());
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
		AssertEqual other = (AssertEqual) obj;
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
}
