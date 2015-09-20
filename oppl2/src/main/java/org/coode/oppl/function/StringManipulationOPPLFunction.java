package org.coode.oppl.function;

import static org.coode.oppl.utils.ArgCheck.checkNotNull;

import org.coode.oppl.exceptions.RuntimeExceptionHandler;

/**
 * @author Luigi Iannone
 */
public abstract class StringManipulationOPPLFunction implements OPPLFunction<String> {

    private final OPPLFunction<String> argument;

    /**
     * @param argument
     *        argument
     */
    public StringManipulationOPPLFunction(OPPLFunction<String> argument) {
        this.argument = checkNotNull(argument, "argument");
    }

    @Override
    public String compute(ValueComputationParameters params) {
        String argumentValue = getArgument().compute(params);
        String toReturn = manipulate(argumentValue, params.getRuntimeExceptionHandler());
        return toReturn;
    }

    protected abstract String manipulate(String string,
        RuntimeExceptionHandler runTimeExceptionHandler);

    /**
     * @param visitor
     *        visitor
     */
    public abstract void accept(StringManipulationOPPLFunctionVisitor visitor);

    /**
     * @param visitor
     *        visitor
     * @param <O>
     *        visitor return type
     * @return visitor value
     */
    public abstract <O> O accept(StringManipulationOPPLFunctionVisitorEx<O> visitor);

    /**
     * @return the argument
     */
    public OPPLFunction<String> getArgument() {
        return argument;
    }
}
