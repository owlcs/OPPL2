/**
 * 
 */
package org.coode.oppl.variablemansyntax.generated;

import org.coode.oppl.variablemansyntax.generated.factory.OWLObjectCollectionGeneratedValue;
import org.coode.oppl.variablemansyntax.generated.factory.RenderingVariableGeneratedValue;

/**
 * @author Luigi Iannone
 * 
 */
public abstract class DefaultSingleValueGeneratedValueVisitorExAdapter<O>
		implements SingleValueGeneratedValueVisitorEx<O> {
	protected abstract O doDefault(SingleValueGeneratedValue<?> value);

	/**
	 * @see org.coode.oppl.variablemansyntax.generated.SingleValueGeneratedValueVisitorEx#visitConcatGeneratedValues(org.coode.oppl.variablemansyntax.generated.ConcatGeneratedValues)
	 */
	public O visitConcatGeneratedValues(
			ConcatGeneratedValues concatGeneratedValues) {
		return this.doDefault(concatGeneratedValues);
	}

	/**
	 * @see org.coode.oppl.variablemansyntax.generated.SingleValueGeneratedValueVisitorEx#visitOWLObjectCollectionGeneratedValue(org.coode.oppl.variablemansyntax.generated.factory.OWLObjectCollectionGeneratedValue)
	 */
	public O visitOWLObjectCollectionGeneratedValue(
			OWLObjectCollectionGeneratedValue owlObjectCollectionGeneratedValue) {
		return this.doDefault(owlObjectCollectionGeneratedValue);
	}

	/**
	 * @see org.coode.oppl.variablemansyntax.generated.SingleValueGeneratedValueVisitorEx#visitRenderingVariableGeneratedValue(org.coode.oppl.variablemansyntax.generated.factory.RenderingVariableGeneratedValue)
	 */
	public O visitRenderingVariableGeneratedValue(
			RenderingVariableGeneratedValue renderingVariableGeneratedValue) {
		return this.doDefault(renderingVariableGeneratedValue);
	}

	/**
	 * @see org.coode.oppl.variablemansyntax.generated.SingleValueGeneratedValueVisitorEx#visitStringGeneratedValue(org.coode.oppl.variablemansyntax.generated.StringGeneratedValue)
	 */
	public O visitStringGeneratedValue(StringGeneratedValue stringGeneratedValue) {
		return this.doDefault(stringGeneratedValue);
	}

	/**
	 * @see org.coode.oppl.variablemansyntax.generated.SingleValueGeneratedValueVisitorEx#visitStringGeneratedValue(org.coode.oppl.variablemansyntax.generated.RegExpGeneratedValue)
	 */
	public O visitStringGeneratedValue(RegExpGeneratedValue regExpGeneratedValue) {
		return this.doDefault(regExpGeneratedValue);
	}

	/**
	 * @see org.coode.oppl.variablemansyntax.generated.SingleValueGeneratedValueVisitorEx#visitVariableExpressionGeneratedValue(org.coode.oppl.variablemansyntax.generated.VariableExpressionGeneratedValue)
	 */
	public O visitVariableExpressionGeneratedValue(
			VariableExpressionGeneratedValue variableExpressionGeneratedValue) {
		return this.doDefault(variableExpressionGeneratedValue);
	}

	/**
	 * @see org.coode.oppl.variablemansyntax.generated.SingleValueGeneratedValueVisitorEx#vistVariableIndexGeneratedValue(org.coode.oppl.variablemansyntax.generated.VariableIndexGeneratedValue)
	 */
	public O vistVariableIndexGeneratedValue(
			VariableIndexGeneratedValue variableIndexGeneratedValue) {
		return this.doDefault(variableIndexGeneratedValue);
	}

	/**
	 * @see org.coode.oppl.variablemansyntax.generated.SingleValueGeneratedValueVisitorEx#visitSingleValueGeneratedValueVisitor(org.coode.oppl.variablemansyntax.generated.SingleValueGeneratedValue)
	 */
	public O visitSingleValueGeneratedValueVisitor(
			SingleValueGeneratedValue<?> singleValueGeneratedValue) {
		return this.doDefault(singleValueGeneratedValue);
	}
}
