package org.coode.oppl.function;

import org.semanticweb.owlapi.model.OWLObject;

public interface OPPLFunctionVisitorEx<T> {
	public <O> T visitAggregation(Aggregation<O> aggregation);

	public <O> T visitConstant(Constant<O> constant);

	public <O extends OWLObject> T visitValuesVariableAtttribute(
			ValuesVariableAtttribute<O> valuesVariableAtttribute);

	public T visitRenderingVariableAttribute(RenderingVariableAttribute renderingVariableAttribute);

	public <O extends OWLObject> T visitGroupVariableAttribute(
			GroupVariableAttribute<O> groupVariableAttribute);
}
