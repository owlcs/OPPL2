package org.coode.oppl.function;

import org.coode.oppl.function.inline.InlineSet;
import org.semanticweb.owlapi.model.OWLObject;

public interface OPPLFunctionVisitor extends StringManipulationOPPLFunctionVisitor {
    <O, I> void visitAggregation(Aggregation<O, I> aggregation);

    <O extends OWLObject> void visitInlineSet(InlineSet<O> inlineSet);

    <O> void visitConstant(Constant<O> constant);

    <O extends OWLObject> void visitValuesVariableAtttribute(
            ValuesVariableAtttribute<O> valuesVariableAtttribute);

    void visitRenderingVariableAttribute(
            RenderingVariableAttribute renderingVariableAttribute);

    <O extends OWLObject> void visitGroupVariableAttribute(
            GroupVariableAttribute<O> groupVariableAttribute);

    <O extends OWLObject> void visitExpression(Expression<O> expression);

    <O, I extends OPPLFunction<?>> void visitCreate(Create<I, O> create);

    void visitIRIVariableAttribute(IRIVariableAttribute iriVariableAttribute);

    <O extends OWLObject> void visitGenericOPPLFunction(OPPLFunction<O> opplFunction);
}
