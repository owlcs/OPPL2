package org.coode.parsers.oppl.testcase.assertions;

import java.util.Set;

import org.coode.oppl.ConstraintSystem;
import org.coode.oppl.bindingtree.BindingNode;

/**
 * Represents an Integer
 * 
 * @author Luigi Iannone
 */
public class IntegerAssertionExpression implements AssertionExpression<Integer> {

    private final int intValue;

    /**
     * @param intValue intValue
     */
    public IntegerAssertionExpression(int intValue) {
        this.intValue = intValue;
    }

    @Override
    public void accept(AssertionExpressionVisitor assertionExpressionVisitor) {
        assertionExpressionVisitor.visitIntegerAssertionExpressionVisitor(this);
    }

    @Override
    public <O> O accept(AssertionExpressionVisitorEx<O> assertionExpressionVisitor) {
        return assertionExpressionVisitor.visitIntegerAssertionExpressionVisitor(this);
    }

    /**
     * @return the intValue
     */
    public int getIntValue() {
        return intValue;
    }

    @Override
    public String toString() {
        return Integer.toString(getIntValue());
    }

    @Override
    public Integer resolve(Set<? extends BindingNode> bindings, ConstraintSystem constraintSystem) {
        return Integer.valueOf(getIntValue());
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + intValue;
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
        IntegerAssertionExpression other = (IntegerAssertionExpression) obj;
        if (intValue != other.intValue) {
            return false;
        }
        return true;
    }
}
