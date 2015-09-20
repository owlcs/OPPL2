package org.coode.parsers.oppl.testcase.assertions;

/**
 * Visitor pattern for AssertionExpression.
 * 
 * @author Luigi Iannone
 */
public interface AssertionExpressionVisitor {

    /**
     * @param countAssertionExpression
     *        countAssertionExpression
     */
    void visitCountAssertionExpression(CountAssertionExpression countAssertionExpression);

    /**
     * @param integerAssertionExpression
     *        integerAssertionExpression
     */
    void visitIntegerAssertionExpressionVisitor(
        IntegerAssertionExpression integerAssertionExpression);

    /**
     * @param owlExpressionAssertionExpression
     *        owlExpressionAssertionExpression
     */
    void visitOWLExpressionAssertionExpression(
        OWLExpressionAssertionExpression owlExpressionAssertionExpression);

    /**
     * @param countStarAssertionExpression
     *        countStarAssertionExpression
     */
    void visitCountStarAssertionExpression(
        CountStarAssertionExpression countStarAssertionExpression);

    /**
     * @param bindingNodeCountAssertionExpression
     *        bindingNodeCountAssertionExpression
     */
    void visitBindingNodeCountAssertionExpression(
        BindingNodeCountAssertionExpression bindingNodeCountAssertionExpression);
}
