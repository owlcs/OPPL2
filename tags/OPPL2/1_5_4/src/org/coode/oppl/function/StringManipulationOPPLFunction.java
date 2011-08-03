package org.coode.oppl.function;

import org.coode.oppl.exceptions.RuntimeExceptionHandler;

public abstract class StringManipulationOPPLFunction implements OPPLFunction<String> {
	private final OPPLFunction<String> argument;

	/**
	 * @param argument
	 */
	public StringManipulationOPPLFunction(OPPLFunction<String> argument) {
		if (argument == null) {
			throw new NullPointerException("The argument cannot be null");
		}
		this.argument = argument;
	}

	public String compute(ValueComputationParameters params) {
		String argumentValue = this.getArgument().compute(params);
		String toReturn = this.manipulate(argumentValue, params.getRuntimeExceptionHandler());
		return toReturn;
	}

	protected abstract String manipulate(String string,
			RuntimeExceptionHandler runTimeExceptionHandler);

	public abstract void accept(StringManipulationOPPLFunctionVisitor visitor);

	public abstract <O> O accept(StringManipulationOPPLFunctionVisitorEx<O> visitor);

	/**
	 * @return the argument
	 */
	public OPPLFunction<String> getArgument() {
		return this.argument;
	}
}
