/**
 * 
 */
package org.coode.oppl.generated;

import org.coode.oppl.generated.factory.OWLObjectCollectionGeneratedValue;
import org.coode.oppl.generated.factory.RenderingVariableGeneratedValue;

/**
 * @author Luigi Iannone
 * 
 */
public abstract class DefaultSingleValueGeneratedValueVisitorExAdapter<O> implements
		SingleValueGeneratedValueVisitorEx<O> {
	protected abstract O doDefault(SingleValueGeneratedValue<?> value);

	/**
	 * @see org.coode.oppl.generated.SingleValueGeneratedValueVisitorEx#visitConcatGeneratedValues(org.coode.oppl.generated.ConcatGeneratedValues)
	 */
	public O visitConcatGeneratedValues(ConcatGeneratedValues concatGeneratedValues) {
		return this.doDefault(concatGeneratedValues);
	}

	/**
	 * @see org.coode.oppl.generated.SingleValueGeneratedValueVisitorEx#visitOWLObjectCollectionGeneratedValue(org.coode.oppl.generated.factory.OWLObjectCollectionGeneratedValue)
	 */
	public O visitOWLObjectCollectionGeneratedValue(
			OWLObjectCollectionGeneratedValue owlObjectCollectionGeneratedValue) {
		return this.doDefault(owlObjectCollectionGeneratedValue);
	}

	/**
	 * @see org.coode.oppl.generated.SingleValueGeneratedValueVisitorEx#visitRenderingVariableGeneratedValue(org.coode.oppl.generated.factory.RenderingVariableGeneratedValue)
	 */
	public O visitRenderingVariableGeneratedValue(
			RenderingVariableGeneratedValue renderingVariableGeneratedValue) {
		return this.doDefault(renderingVariableGeneratedValue);
	}

	/**
	 * @see org.coode.oppl.generated.SingleValueGeneratedValueVisitorEx#visitStringGeneratedValue(org.coode.oppl.generated.StringGeneratedValue)
	 */
	public O visitStringGeneratedValue(StringGeneratedValue stringGeneratedValue) {
		return this.doDefault(stringGeneratedValue);
	}

	/**
	 * @see org.coode.oppl.generated.SingleValueGeneratedValueVisitorEx#visitStringGeneratedValue(org.coode.oppl.generated.RegExpGeneratedValue)
	 */
	public O visitStringGeneratedValue(RegExpGeneratedValue<?> regExpGeneratedValue) {
		return this.doDefault(regExpGeneratedValue);
	}

	/**
	 * @see org.coode.oppl.generated.SingleValueGeneratedValueVisitorEx#visitVariableExpressionGeneratedValue(org.coode.oppl.generated.VariableExpressionGeneratedValue)
	 */
	public O visitVariableExpressionGeneratedValue(
			VariableExpressionGeneratedValue variableExpressionGeneratedValue) {
		return this.doDefault(variableExpressionGeneratedValue);
	}

	/**
	 * @see org.coode.oppl.generated.SingleValueGeneratedValueVisitorEx#vistVariableIndexGeneratedValue(org.coode.oppl.generated.VariableIndexGeneratedValue)
	 */
	public O vistVariableIndexGeneratedValue(
			VariableIndexGeneratedValue<?> variableIndexGeneratedValue) {
		return this.doDefault(variableIndexGeneratedValue);
	}

	/**
	 * @see org.coode.oppl.generated.SingleValueGeneratedValueVisitorEx#visitSingleValueGeneratedValueVisitor(org.coode.oppl.generated.SingleValueGeneratedValue)
	 */
	public O visitSingleValueGeneratedValueVisitor(
			SingleValueGeneratedValue<?> singleValueGeneratedValue) {
		return this.doDefault(singleValueGeneratedValue);
	}
}
