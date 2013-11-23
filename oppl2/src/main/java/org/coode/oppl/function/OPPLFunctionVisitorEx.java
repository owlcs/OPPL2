package org.coode.oppl.function;

import org.coode.oppl.function.inline.InlineSet;
import org.semanticweb.owlapi.model.OWLObject;

public interface OPPLFunctionVisitorEx<T> extends
        StringManipulationOPPLFunctionVisitorEx<T> {
    <O, I> T visitAggregation(Aggregation<O, I> aggregation);

    <O> T visitConstant(Constant<O> constant);

    <O extends OWLObject> T visitValuesVariableAtttribute(
            ValuesVariableAtttribute<O> valuesVariableAtttribute);

    T visitRenderingVariableAttribute(
            RenderingVariableAttribute renderingVariableAttribute);

    <O extends OWLObject> T visitGroupVariableAttribute(
            GroupVariableAttribute<O> groupVariableAttribute);

    <O extends OWLObject> T visitExpression(Expression<O> expression);

    <O, I extends OPPLFunction<?>> T visitCreate(Create<I, O> create);

    T visitIRIVariableAttribute(IRIVariableAttribute iriVariableAttribute);

    <P extends OWLObject> T visitGenericOPPLFunction(OPPLFunction<P> opplFunction);

    <O extends OWLObject> T visitInlineSet(InlineSet<O> inlineSet);
}
