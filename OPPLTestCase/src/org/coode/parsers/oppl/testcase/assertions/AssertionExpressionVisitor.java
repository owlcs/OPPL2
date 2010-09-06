/**
 * 
 */
package org.coode.parsers.oppl.testcase.assertions;

/**
 * Visitor pattern for AssertionExpression.
 * 
 * @author Luigi Iannone
 * 
 */
public interface AssertionExpressionVisitor {
	void visitCountAssertionExpression(
			CountAssertionExpression countAssertionExpression);

	void visitIntegerAssertionExpressionVisitor(
			IntegerAssertionExpression integerAssertionExpression);

	void visitOWLExpressionAssertionExpression(
			OWLExpressionAssertionExpression owlExpressionAssertionExpression);

	void visitCountStarAssertionExpression(
			CountStarAssertionExpression countStarAssertionExpression);
}
