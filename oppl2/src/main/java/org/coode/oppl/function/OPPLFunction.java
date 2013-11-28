package org.coode.oppl.function;

import org.coode.oppl.Renderable;
import org.semanticweb.owlapi.util.ShortFormProvider;

/** A function
 * 
 * @author Luigi Iannone
 * @param <O> */
public interface OPPLFunction<O> extends Renderable {
    /** @param params
     * @return computed value */
    O compute(ValueComputationParameters params);

    /** @param visitor
     * @return visitor value */
    <P> P accept(OPPLFunctionVisitorEx<P> visitor);

    /** @param visitor */
    void accept(OPPLFunctionVisitor visitor);

    /** @param shortFormProvider
     * @return rendering */
    String render(ShortFormProvider shortFormProvider);
}
