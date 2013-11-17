/**
 * 
 */
package org.coode.oppl.function;

import org.coode.oppl.ConstraintSystem;
import org.coode.oppl.Renderable;
import org.semanticweb.owlapi.util.ShortFormProvider;

/** A function
 * 
 * @author Luigi Iannone */
public interface OPPLFunction<O> extends Renderable {
    public O compute(ValueComputationParameters params);

    public <P> P accept(OPPLFunctionVisitorEx<P> visitor);

    public void accept(OPPLFunctionVisitor visitor);

    @Override
    public String render(ConstraintSystem constraintSystem);

    public String render(ShortFormProvider shortFormProvider);
}
