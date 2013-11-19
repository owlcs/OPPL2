package org.coode.oppl.function;

/** @author Luigi Iannone */
public interface ValueComputation<O> {
    O compute(OPPLFunction<? extends O> opplFunction);
}
