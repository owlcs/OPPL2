package org.coode.oppl.function;

import org.semanticweb.owlapi.model.OWLObject;

public interface OPPLFunctionVisitor {
	public <O, I> void visitAggregation(Aggregation<O, I> aggregation);

	public <O> void visitConstant(Constant<O> constant);

	public <O extends OWLObject> void visitValuesVariableAtttribute(
			ValuesVariableAtttribute<O> valuesVariableAtttribute);

	public void visitRenderingVariableAttribute(
			RenderingVariableAttribute renderingVariableAttribute);

	public <O extends OWLObject> void visitGroupVariableAttribute(
			GroupVariableAttribute<O> groupVariableAttribute);

	public <O extends OWLObject> void visitExpression(Expression<O> expression);
}
