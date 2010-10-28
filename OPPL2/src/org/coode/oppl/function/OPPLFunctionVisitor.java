package org.coode.oppl.function;

import org.semanticweb.owlapi.model.OWLObject;

public interface OPPLFunctionVisitor {
	public <O> void visitAggregation(Aggregation<O> aggregation);

	public <O> void visitConstant(Constant<O> constant);

	public <O extends OWLObject> void visitValuesVariableAtttribute(
			ValuesVariableAtttribute<O> valuesVariableAtttribute);

	public void visitRenderingVariableAttribute(
			RenderingVariableAttribute renderingVariableAttribute);

	public <O extends OWLObject> void visitGroupVariableAttribute(
			GroupVariableAttribute<O> groupVariableAttribute);
}
