package org.coode.parsers.oppl.testcase.assertions;

import java.util.Set;

import org.coode.oppl.ConstraintSystem;
import org.coode.oppl.bindingtree.BindingNode;

/**
 * An expression that could be used as an argument in Assertions. It can be
 * resolved against a Set of bindings by calling the resolve methods. It
 * transforms the AssertionExpression into an object
 * 
 * @author Luigi Iannone
 * @param <T>
 *        The kind of object this AssertionExpression resolves to.
 */
public interface AssertionExpression<T> {

    /**
     * @param assertionExpressionVisitor
     *        assertionExpressionVisitor
     */
    void accept(AssertionExpressionVisitor assertionExpressionVisitor);

    /**
     * @param assertionExpressionVisitor
     *        assertionExpressionVisitor
     * @return visitor value
     */
    <O> O accept(AssertionExpressionVisitorEx<O> assertionExpressionVisitor);

    /**
     * Resolves the expression according to the input set of bindings.
     * 
     * @param bindings
     *        The Set of bindings providing value for the variables. Cannot be
     *        {@code null}.
     * @param constraintSystem
     *        Cannot be {@code null}.
     * @return an object of class {@code T}.
     * @throws NullPointerException
     *         if either input is {@code null}.
     */
    T resolve(Set<? extends BindingNode> bindings, ConstraintSystem constraintSystem);
}
