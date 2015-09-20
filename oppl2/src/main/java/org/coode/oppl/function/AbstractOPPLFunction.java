package org.coode.oppl.function;

/**
 * @author Luigi Iannone
 * @param <O>
 *        type
 */
public abstract class AbstractOPPLFunction<O> implements OPPLFunction<O> {

    @Override
    public O compute(ValueComputationParameters params) {
        return this.getValueComputation(params).compute(this);
    }

    /**
     * @param parameters
     *        parameters
     * @return computation value
     */
    public abstract ValueComputation<O> getValueComputation(
        ValueComputationParameters parameters);
}
