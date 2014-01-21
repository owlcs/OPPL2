package org.coode.oppl.function;

import org.coode.oppl.function.inline.InlineSet;
import org.semanticweb.owlapi.model.OWLObject;

/** @author Luigi Iannone
 * @param <T>
 *            visitor type */
public interface OPPLFunctionVisitorEx<T> extends
        StringManipulationOPPLFunctionVisitorEx<T> {
    /** @param aggregation
     *            aggregation
     * @param <O>
     *            aggregation fuction type
     * @param <I>
     *            aggregation type
     * @return visitor result */
    <O, I> T visitAggregation(Aggregation<O, I> aggregation);

    /** @param constant
     *            constant
     * @param <O>
     *            constant type
     * @return visitor result */
    <O> T visitConstant(Constant<O> constant);

    /** @param valuesVariableAtttribute
     *            valuesVariableAtttribute
     * @param <O>
     *            variable type
     * @return visitor result */
    <O extends OWLObject> T visitValuesVariableAtttribute(
            ValuesVariableAtttribute<O> valuesVariableAtttribute);

    /** @param renderingVariableAttribute
     *            renderingVariableAttribute
     * @return visitor result */
    T visitRenderingVariableAttribute(
            RenderingVariableAttribute renderingVariableAttribute);

    /** @param groupVariableAttribute
     *            groupVariableAttribute
     * @param <O>
     *            variable type
     * @return visitor result */
    <O extends OWLObject> T visitGroupVariableAttribute(
            GroupVariableAttribute<O> groupVariableAttribute);

    /** @param expression
     *            expression
     * @param <O>
     *            expression type
     * @return visitor result */
    <O extends OWLObject> T visitExpression(Expression<O> expression);

    /** @param create
     *            create
     * @param <O>
     *            create return type
     * @param <I>
     *            create type
     * @return visitor result */
    <O, I extends OPPLFunction<?>> T visitCreate(Create<I, O> create);

    /** @param iriVariableAttribute
     *            iriVariableAttribute
     * @return visitor result */
    T visitIRIVariableAttribute(IRIVariableAttribute iriVariableAttribute);

    /** @param opplFunction
     *            opplFunction
     * @return visitor result */
    <P extends OWLObject> T visitGenericOPPLFunction(OPPLFunction<P> opplFunction);

    /** @param inlineSet
     *            inlineSet
     * @param <O>
     *            function type
     * @return visitor result */
    <O extends OWLObject> T visitInlineSet(InlineSet<O> inlineSet);
}
