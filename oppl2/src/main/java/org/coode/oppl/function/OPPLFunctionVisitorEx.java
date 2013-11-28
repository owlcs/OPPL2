package org.coode.oppl.function;

import org.coode.oppl.function.inline.InlineSet;
import org.semanticweb.owlapi.model.OWLObject;

/** @author Luigi Iannone
 * @param <T> */
public interface OPPLFunctionVisitorEx<T> extends
        StringManipulationOPPLFunctionVisitorEx<T> {
    /** @param aggregation
     * @return visitor result */
    <O, I> T visitAggregation(Aggregation<O, I> aggregation);

    /** @param constant
     * @return visitor result */
    <O> T visitConstant(Constant<O> constant);

    /** @param valuesVariableAtttribute
     * @return visitor result */
    <O extends OWLObject> T visitValuesVariableAtttribute(
            ValuesVariableAtttribute<O> valuesVariableAtttribute);

    /** @param renderingVariableAttribute
     * @return visitor result */
    T visitRenderingVariableAttribute(
            RenderingVariableAttribute renderingVariableAttribute);

    /** @param groupVariableAttribute
     * @return visitor result */
    <O extends OWLObject> T visitGroupVariableAttribute(
            GroupVariableAttribute<O> groupVariableAttribute);

    /** @param expression
     * @return visitor result */
    <O extends OWLObject> T visitExpression(Expression<O> expression);

    /** @param create
     * @return visitor result */
    <O, I extends OPPLFunction<?>> T visitCreate(Create<I, O> create);

    /** @param iriVariableAttribute
     * @return visitor result */
    T visitIRIVariableAttribute(IRIVariableAttribute iriVariableAttribute);

    /** @param opplFunction
     * @return visitor result */
    <P extends OWLObject> T visitGenericOPPLFunction(OPPLFunction<P> opplFunction);

    /** @param inlineSet
     * @return visitor result */
    <O extends OWLObject> T visitInlineSet(InlineSet<O> inlineSet);
}
