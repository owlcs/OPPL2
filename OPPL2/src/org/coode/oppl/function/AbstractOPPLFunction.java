package org.coode.oppl.function;


public abstract class AbstractOPPLFunction<O> implements OPPLFunction<O> {
	public O compute(ValueComputationParameters params) {
		return this.getValueComputation(params).compute(this);
	}

	public abstract ValueComputation<O> getValueComputation(ValueComputationParameters parameters);
}
