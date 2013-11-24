package org.coode.oppl.function;

import org.coode.oppl.function.inline.InlineSet;
import org.semanticweb.owlapi.model.OWLObject;

/** @author Luigi Iannone */
public interface OPPLFunctionVisitor extends StringManipulationOPPLFunctionVisitor {
    /** @param aggregation */
    <O, I> void visitAggregation(Aggregation<O, I> aggregation);

    /** @param inlineSet */
    <O extends OWLObject> void visitInlineSet(InlineSet<O> inlineSet);

    /** @param constant */
    <O> void visitConstant(Constant<O> constant);

    /** @param valuesVariableAtttribute */
    <O extends OWLObject> void visitValuesVariableAtttribute(
            ValuesVariableAtttribute<O> valuesVariableAtttribute);

    /** @param renderingVariableAttribute */
    void visitRenderingVariableAttribute(
            RenderingVariableAttribute renderingVariableAttribute);

    /** @param groupVariableAttribute */
    <O extends OWLObject> void visitGroupVariableAttribute(
            GroupVariableAttribute<O> groupVariableAttribute);

    /** @param expression */
    <O extends OWLObject> void visitExpression(Expression<O> expression);

    /** @param create */
    <O, I extends OPPLFunction<?>> void visitCreate(Create<I, O> create);

    /** @param iriVariableAttribute */
    void visitIRIVariableAttribute(IRIVariableAttribute iriVariableAttribute);

    /** @param opplFunction */
    <O extends OWLObject> void visitGenericOPPLFunction(OPPLFunction<O> opplFunction);
}
