
package org.coode.parsers.oppl.testcase.assertions;

/** Visitor pattern for AssertionExpression.
 * 
 * @author Luigi Iannone */
public interface AssertionExpressionVisitor {
    /** @param countAssertionExpression */
    void visitCountAssertionExpression(CountAssertionExpression countAssertionExpression);

    /** @param integerAssertionExpression */
    void visitIntegerAssertionExpressionVisitor(
            IntegerAssertionExpression integerAssertionExpression);

    /** @param owlExpressionAssertionExpression */
    void visitOWLExpressionAssertionExpression(
            OWLExpressionAssertionExpression owlExpressionAssertionExpression);

    /** @param countStarAssertionExpression */
    void visitCountStarAssertionExpression(
            CountStarAssertionExpression countStarAssertionExpression);

    /** @param bindingNodeCountAssertionExpression */
    void visitBindingNodeCountAssertionExpression(
            BindingNodeCountAssertionExpression bindingNodeCountAssertionExpression);
}
