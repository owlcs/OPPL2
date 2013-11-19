
package org.coode.parsers.oppl.testcase.assertions;

import java.util.Set;

import org.coode.oppl.ConstraintSystem;
import org.coode.oppl.bindingtree.BindingNode;

/** Represents the count of the number of binding tuples for the OPPL query.
 * 
 * @author Luigi Iannone */
public class CountStarAssertionExpression implements AssertionExpression<Integer> {
    private final static CountStarAssertionExpression instance = new CountStarAssertionExpression();

    private CountStarAssertionExpression() {}

    @Override
    public void accept(AssertionExpressionVisitor assertionExpressionVisitor) {
        assertionExpressionVisitor.visitCountStarAssertionExpression(this);
    }

    @Override
    public <O> O accept(AssertionExpressionVisitorEx<O> assertionExpressionVisitor) {
        return assertionExpressionVisitor.visitCountStarAssertionExpression(this);
    }

    @Override
    public Integer resolve(Set<? extends BindingNode> bindings,
            ConstraintSystem constraintSystem) {
        return bindings.size();
    }

    @Override
    public String toString() {
        return "count(*)";
    }

    /** @return the instance */
    public static CountStarAssertionExpression getInstance() {
        return instance;
    }
}
