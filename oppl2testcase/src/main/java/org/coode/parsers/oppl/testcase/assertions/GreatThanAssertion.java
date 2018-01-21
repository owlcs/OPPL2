package org.coode.parsers.oppl.testcase.assertions;

import static org.coode.oppl.utils.ArgCheck.checkNotNull;

import java.util.Set;

import org.coode.oppl.ConstraintSystem;
import org.coode.oppl.bindingtree.BindingNode;

/**
 * Represents the assertion that the left hand side is less than the right hand side
 * 
 * @author Luigi Iannone
 */
public class GreatThanAssertion implements Assertion {

    private final AssertionExpression<Integer> left;
    private final AssertionExpression<Integer> right;

    /**
     * @param left left
     * @param right right
     */
    public GreatThanAssertion(AssertionExpression<Integer> left,
        AssertionExpression<Integer> right) {
        this.left = checkNotNull(left, "left");
        this.right = checkNotNull(right, "right");
    }

    /**
     * @return the left
     */
    public AssertionExpression<Integer> getLeft() {
        return left;
    }

    /**
     * @return the right
     */
    public AssertionExpression<Integer> getRight() {
        return right;
    }

    @Override
    public void accept(AssertionVisitor visitor) {
        visitor.visitAssertGreaterThan(this);
    }

    @Override
    public <O> O accept(AssertionVisitorEx<O> visitor) {
        return visitor.visitAssertGreaterThan(this);
    }

    @Override
    public boolean holds(Set<? extends BindingNode> bindings, ConstraintSystem constraintSystem) {
        return getLeft().resolve(bindings, constraintSystem).intValue() > getRight()
            .resolve(bindings, constraintSystem).intValue();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (left == null ? 0 : left.hashCode());
        result = prime * result + (right == null ? 0 : right.hashCode());
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
        GreatThanAssertion other = (GreatThanAssertion) obj;
        if (left == null) {
            if (other.left != null) {
                return false;
            }
        } else if (!left.equals(other.left)) {
            return false;
        }
        if (right == null) {
            if (other.right != null) {
                return false;
            }
        } else if (!right.equals(other.right)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return String.format("%s > %s", getLeft(), getRight());
    }
}
