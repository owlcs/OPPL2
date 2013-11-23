package org.coode.oppl.function;

import org.coode.oppl.Renderable;
import org.semanticweb.owlapi.util.ShortFormProvider;

/** A function
 * 
 * @author Luigi Iannone */
public interface OPPLFunction<O> extends Renderable {
    O compute(ValueComputationParameters params);

    <P> P accept(OPPLFunctionVisitorEx<P> visitor);

    void accept(OPPLFunctionVisitor visitor);

    String render(ShortFormProvider shortFormProvider);
}
