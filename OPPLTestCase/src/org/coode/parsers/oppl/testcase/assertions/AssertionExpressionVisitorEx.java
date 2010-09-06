package org.coode.parsers.oppl.testcase.assertions;

/**
 * Visitor pattern for AssertionExpression, with return values.
 * 
 * @author Luigi Iannone
 * 
 * @param <O>
 *            The type of the return value.
 */
public interface AssertionExpressionVisitorEx<O> {
	O visitCountAssertionExpression(
			CountAssertionExpression countAssertionExpression);

	O visitIntegerAssertionExpressionVisitor(
			IntegerAssertionExpression integerAssertionExpression);

	O visitOWLExpressionAssertionExpression(
			OWLExpressionAssertionExpression owlExpressionAssertionExpression);

	O visitCountStarAssertionExpression(
			CountStarAssertionExpression countStarAssertionExpression);
}
