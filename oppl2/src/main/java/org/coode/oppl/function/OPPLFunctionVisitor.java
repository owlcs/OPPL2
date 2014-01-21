package org.coode.oppl.function;

import org.coode.oppl.function.inline.InlineSet;
import org.semanticweb.owlapi.model.OWLObject;

/** @author Luigi Iannone */
public interface OPPLFunctionVisitor extends StringManipulationOPPLFunctionVisitor {
    /** @param aggregation
     *            aggregation
     * @param <O>
     *            aggregation fuction type
     * @param <I>
     *            aggregation type */
    <O, I> void visitAggregation(Aggregation<O, I> aggregation);

    /** @param inlineSet
     *            inlineSet
     * @param <O>
     *            set type */
    <O extends OWLObject> void visitInlineSet(InlineSet<O> inlineSet);

    /** @param constant
     *            constant
     * @param <O>
     *            constant type */
    <O> void visitConstant(Constant<O> constant);

    /** @param valuesVariableAtttribute
     *            valuesVariableAtttribute
     * @param <O>
     *            variable type */
    <O extends OWLObject> void visitValuesVariableAtttribute(
            ValuesVariableAtttribute<O> valuesVariableAtttribute);

    /** @param renderingVariableAttribute
     *            renderingVariableAttribute */
    void visitRenderingVariableAttribute(
            RenderingVariableAttribute renderingVariableAttribute);

    /** @param groupVariableAttribute
     *            groupVariableAttribute
     * @param <O>
     *            variable type */
    <O extends OWLObject> void visitGroupVariableAttribute(
            GroupVariableAttribute<O> groupVariableAttribute);

    /** @param expression
     *            expression
     * @param <O>
     *            expression type */
    <O extends OWLObject> void visitExpression(Expression<O> expression);

    /** @param create
     *            create
     * @param <O>
     *            create return type
     * @param <I>
     *            create type */
    <O, I extends OPPLFunction<?>> void visitCreate(Create<I, O> create);

    /** @param iriVariableAttribute
     *            iriVariableAttribute */
    void visitIRIVariableAttribute(IRIVariableAttribute iriVariableAttribute);

    /** @param opplFunction
     *            opplFunction
     * @param <O>
     *            function type */
    <O extends OWLObject> void visitGenericOPPLFunction(OPPLFunction<O> opplFunction);
}
