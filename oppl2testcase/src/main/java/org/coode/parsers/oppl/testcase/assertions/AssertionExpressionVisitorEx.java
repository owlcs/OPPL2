package org.coode.parsers.oppl.testcase.assertions;

/** Visitor pattern for AssertionExpression, with return values.
 * 
 * @author Luigi Iannone
 * @param <O>
 *            The type of the return value. */
public interface AssertionExpressionVisitorEx<O> {
    /** @param countAssertionExpression
     * @return visitor value */
    O visitCountAssertionExpression(CountAssertionExpression countAssertionExpression);

    /** @param integerAssertionExpression
     * @return visitor value */
    O visitIntegerAssertionExpressionVisitor(
            IntegerAssertionExpression integerAssertionExpression);

    /** @param owlExpressionAssertionExpression
     * @return visitor value */
    O visitOWLExpressionAssertionExpression(
            OWLExpressionAssertionExpression owlExpressionAssertionExpression);

    /** @param countStarAssertionExpression
     * @return visitor value */
    O visitCountStarAssertionExpression(
            CountStarAssertionExpression countStarAssertionExpression);

    /** @param bindingNodeCountAssertionExpression
     * @return visitor value */
    O visitBindingNodeCountAssertionExpression(
            BindingNodeCountAssertionExpression bindingNodeCountAssertionExpression);
}
