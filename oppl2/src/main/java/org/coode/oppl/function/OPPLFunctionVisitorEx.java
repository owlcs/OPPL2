package org.coode.oppl.function;

import org.coode.oppl.function.inline.InlineSet;
import org.semanticweb.owlapi.model.OWLObject;

public interface OPPLFunctionVisitorEx<T> extends
        StringManipulationOPPLFunctionVisitorEx<T> {
    public <O, I> T visitAggregation(Aggregation<O, I> aggregation);

    public <O> T visitConstant(Constant<O> constant);

    public <O extends OWLObject> T visitValuesVariableAtttribute(
            ValuesVariableAtttribute<O> valuesVariableAtttribute);

    public T visitRenderingVariableAttribute(
            RenderingVariableAttribute renderingVariableAttribute);

    public <O extends OWLObject> T visitGroupVariableAttribute(
            GroupVariableAttribute<O> groupVariableAttribute);

    public <O extends OWLObject> T visitExpression(Expression<O> expression);

    public <O, I extends OPPLFunction<?>> T visitCreate(Create<I, O> create);

    public T visitIRIVariableAttribute(IRIVariableAttribute iriVariableAttribute);

    public <P extends OWLObject> T visitGenericOPPLFunction(OPPLFunction<P> opplFunction);

    public <O extends OWLObject> T visitInlineSet(InlineSet<O> inlineSet);
}
