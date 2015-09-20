package org.coode.oppl.function;

import org.coode.oppl.Renderable;
import org.semanticweb.owlapi.util.ShortFormProvider;

/**
 * A function
 * 
 * @author Luigi Iannone
 * @param <O>
 *        type
 */
public interface OPPLFunction<O> extends Renderable {

    /**
     * @param params
     *        params
     * @return computed value
     */
    O compute(ValueComputationParameters params);

    /**
     * @param visitor
     *        visitor
     * @param
     *        <P>
     *        visitor return type
     * @return visitor value
     */
    <P> P accept(OPPLFunctionVisitorEx<P> visitor);

    /**
     * @param visitor
     *        visitor
     */
    void accept(OPPLFunctionVisitor visitor);

    /**
     * @param shortFormProvider
     *        shortFormProvider
     * @return rendering
     */
    String render(ShortFormProvider shortFormProvider);
}
