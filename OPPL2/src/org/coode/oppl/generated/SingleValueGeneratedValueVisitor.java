package org.coode.oppl.generated;

import org.coode.oppl.generated.factory.OWLObjectCollectionGeneratedValue;
import org.coode.oppl.generated.factory.RenderingVariableGeneratedValue;

public interface SingleValueGeneratedValueVisitor {
	void visitConcatGeneratedValues(ConcatGeneratedValues concatGeneratedValues);

	void visitRegExpGeneratedValue(RegExpGeneratedValue<?> regExpGeneratedValue);

	void visitStringGeneratedValue(StringGeneratedValue stringGeneratedValue);

	void visitVariableExpressionGeneratedValue(
			VariableExpressionGeneratedValue variableExpressionGeneratedValue);

	void vistVariableIndexGeneratedValue(VariableIndexGeneratedValue<?> variableIndexGeneratedValue);

	void visitOWLObjectCollectionGeneratedValue(
			OWLObjectCollectionGeneratedValue owlObjectCollectionGeneratedValue);

	void visitRenderingVariableGeneratedValue(
			RenderingVariableGeneratedValue renderingVariableGeneratedValue);

	void visitSingleValueGeneratedValueVisitor(
			SingleValueGeneratedValue<?> singleValueGeneratedValue);
}
