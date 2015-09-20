package org.coode.parsers.oppl.testcase.assertions;

import static org.coode.oppl.utils.ArgCheck.checkNotNull;

import java.util.Set;

import org.coode.oppl.ConstraintSystem;
import org.coode.oppl.bindingtree.BindingNode;

/**
 * Asserts that the expression on the left is equal to the one on the right.
 * 
 * @author Luigi Iannone
 */
public class AssertEqual implements Assertion {

    private final AssertionExpression<?> left;
    private final AssertionExpression<?> right;

    /**
     * @param left
     *        left
     * @param right
     *        right
     */
    public AssertEqual(AssertionExpression<?> left, AssertionExpression<?> right) {
        this.left = checkNotNull(left, "left");
        this.right = checkNotNull(right, "right");
    }

    @Override
    public void accept(AssertionVisitor visitor) {
        visitor.visitAssertEqual(this);
    }

    @Override
    public <O> O accept(AssertionVisitorEx<O> visitor) {
        return visitor.visitAssertEqual(this);
    }

    /**
     * @return the left
     */
    public AssertionExpression<?> getLeft() {
        return left;
    }

    /**
     * @return the right
     */
    public AssertionExpression<?> getRight() {
        return right;
    }

    @Override
    public String toString() {
        return String.format("%s = %s", getLeft(), getRight());
    }

    @Override
    public boolean holds(Set<? extends BindingNode> bindings,
        ConstraintSystem constraintSystem) {
        Object leftObjects = getLeft().resolve(bindings, constraintSystem);
        Object rightObjects = getRight().resolve(bindings, constraintSystem);
        return leftObjects.equals(rightObjects);
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
        AssertEqual other = (AssertEqual) obj;
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
}
