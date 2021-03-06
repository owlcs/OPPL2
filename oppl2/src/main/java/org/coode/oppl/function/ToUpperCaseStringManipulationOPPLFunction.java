package org.coode.oppl.function;

import org.coode.oppl.ConstraintSystem;
import org.coode.oppl.exceptions.RuntimeExceptionHandler;
import org.semanticweb.owlapi.util.ShortFormProvider;

/**
 * @author Luigi Iannone
 */
public class ToUpperCaseStringManipulationOPPLFunction extends
    StringManipulationOPPLFunction {

    /**
     * @param argument
     *        argument
     */
    public ToUpperCaseStringManipulationOPPLFunction(OPPLFunction<String> argument) {
        super(argument);
    }

    @Override
    public <P> P accept(OPPLFunctionVisitorEx<P> visitor) {
        return visitor.visitToUpperCaseStringManipulationOPPLFunction(this);
    }

    @Override
    public void accept(OPPLFunctionVisitor visitor) {
        visitor.visitToUpperCaseStringManipulationOPPLFunction(this);
    }

    @Override
    public String render(ConstraintSystem constraintSystem) {
        return String.format("%s.%s", getArgument().render(constraintSystem),
            "toUpperCase");
    }

    @Override
    public String render(ShortFormProvider shortFormProvider) {
        return String.format("%s.%s", getArgument().render(shortFormProvider),
            "toUpperCase");
    }

    @Override
    protected String manipulate(String string,
        RuntimeExceptionHandler runTimeExceptionHandler) {
        if (string == null) {
            runTimeExceptionHandler.handleException(new NullPointerException(
                "The string cannot be null"));
            return "";
        }
        return string.toUpperCase();
    }

    @Override
    public void accept(StringManipulationOPPLFunctionVisitor visitor) {
        visitor.visitToUpperCaseStringManipulationOPPLFunction(this);
    }

    @Override
    public <O> O accept(StringManipulationOPPLFunctionVisitorEx<O> visitor) {
        return visitor.visitToUpperCaseStringManipulationOPPLFunction(this);
    }
}
