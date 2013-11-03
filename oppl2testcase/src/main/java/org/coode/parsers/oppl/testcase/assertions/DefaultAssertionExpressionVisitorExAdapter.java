/**
 * 
 */
package org.coode.parsers.oppl.testcase.assertions;

/**
 * Adapter that implements a default behaviour that can be overridden where
 * desired.
 * 
 * @author Luigi Iannone
 * 
 */
public abstract class DefaultAssertionExpressionVisitorExAdapter<O> implements
		AssertionExpressionVisitorEx<O> {
	private final O defaultValue;

	public DefaultAssertionExpressionVisitorExAdapter() {
		this(null);
	}

	/**
	 * @param defaultValue
	 */
	public DefaultAssertionExpressionVisitorExAdapter(O defaultValue) {
		this.defaultValue = defaultValue;
	}

	/**
	 * @return the defaultValue
	 */
	protected O getDefaultValue(AssertionExpression<?> assertionExpression) {
		return this.defaultValue;
	}

	public O visitCountAssertionExpression(
			CountAssertionExpression countAssertionExpression) {
		return this.getDefaultValue(countAssertionExpression);
	}

	public O visitCountStarAssertionExpression(
			CountStarAssertionExpression countStarAssertionExpression) {
		return this.getDefaultValue(countStarAssertionExpression);
	}

	public O visitIntegerAssertionExpressionVisitor(
			IntegerAssertionExpression integerAssertionExpression) {
		return this.getDefaultValue(integerAssertionExpression);
	}

	public O visitOWLExpressionAssertionExpression(
			OWLExpressionAssertionExpression owlExpressionAssertionExpression) {
		return this.getDefaultValue(owlExpressionAssertionExpression);
	}

	public O visitBindingNodeCountAssertionExpression(
			BindingNodeCountAssertionExpression bindingNodeCountAssertionExpression) {
		return this.getDefaultValue(bindingNodeCountAssertionExpression);
	}
}
