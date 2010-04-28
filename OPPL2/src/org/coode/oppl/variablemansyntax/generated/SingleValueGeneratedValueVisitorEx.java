package org.coode.oppl.variablemansyntax.generated;

import org.coode.oppl.variablemansyntax.generated.factory.OWLObjectCollectionGeneratedValue;
import org.coode.oppl.variablemansyntax.generated.factory.RenderingVariableGeneratedValue;

public interface SingleValueGeneratedValueVisitorEx<O> {
	O visitConcatGeneratedValues(ConcatGeneratedValues concatGeneratedValues);

	O visitStringGeneratedValue(StringGeneratedValue stringGeneratedValue);

	O visitStringGeneratedValue(RegExpGeneratedValue regExpGeneratedValue);

	O vistVariableIndexGeneratedValue(
			VariableIndexGeneratedValue variableIndexGeneratedValue);

	O visitVariableExpressionGeneratedValue(
			VariableExpressionGeneratedValue variableExpressionGeneratedValue);

	O visitOWLObjectCollectionGeneratedValue(
			OWLObjectCollectionGeneratedValue owlObjectCollectionGeneratedValue);

	O visitRenderingVariableGeneratedValue(
			RenderingVariableGeneratedValue renderingVariableGeneratedValue);

	O visitSingleValueGeneratedValueVisitor(
			SingleValueGeneratedValue<?> singleValueGeneratedValue);
}
