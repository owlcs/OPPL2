package org.coode.oppl.function;

/** @author Luigi Iannone
 * @param <O> */
public interface ValueComputation<O> {
    /** @param opplFunction
     * @return computed value */
    O compute(OPPLFunction<? extends O> opplFunction);
}
