package org.coode.oppl.function;

/** @author Luigi Iannone
 * @param <O>
 *            type */
public interface ValueComputation<O> {
    /** @param opplFunction
     *            opplFunction
     * @return computed value */
    O compute(OPPLFunction<? extends O> opplFunction);
}
