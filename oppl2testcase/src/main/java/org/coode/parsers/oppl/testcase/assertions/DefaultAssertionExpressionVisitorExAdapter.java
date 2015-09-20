package org.coode.parsers.oppl.testcase.assertions;

/**
 * Adapter that implements a default behaviour that can be overridden where
 * desired.
 * 
 * @author Luigi Iannone
 * @param <O>
 *        type
 */
public abstract class DefaultAssertionExpressionVisitorExAdapter<O> implements
    AssertionExpressionVisitorEx<O> {

    private final O defaultValue;

    /** default constructor for null default return */
    public DefaultAssertionExpressionVisitorExAdapter() {
        this(null);
    }

    /**
     * @param defaultValue
     *        defaultValue
     */
    public DefaultAssertionExpressionVisitorExAdapter(O defaultValue) {
        this.defaultValue = defaultValue;
    }

    /**
     * @param assertionExpression
     *        assertionExpression
     * @return the defaultValue
     */
    protected O getDefaultValue(
        @SuppressWarnings("unused") AssertionExpression<?> assertionExpression) {
        return this.defaultValue;
    }

    @Override
    public O visitCountAssertionExpression(
        CountAssertionExpression countAssertionExpression) {
        return this.getDefaultValue(countAssertionExpression);
    }

    @Override
    public O visitCountStarAssertionExpression(
        CountStarAssertionExpression countStarAssertionExpression) {
        return this.getDefaultValue(countStarAssertionExpression);
    }

    @Override
    public O visitIntegerAssertionExpressionVisitor(
        IntegerAssertionExpression integerAssertionExpression) {
        return this.getDefaultValue(integerAssertionExpression);
    }

    @Override
    public O visitOWLExpressionAssertionExpression(
        OWLExpressionAssertionExpression owlExpressionAssertionExpression) {
        return this.getDefaultValue(owlExpressionAssertionExpression);
    }

    @Override
    public O visitBindingNodeCountAssertionExpression(
        BindingNodeCountAssertionExpression bindingNodeCountAssertionExpression) {
        return this.getDefaultValue(bindingNodeCountAssertionExpression);
    }
}
