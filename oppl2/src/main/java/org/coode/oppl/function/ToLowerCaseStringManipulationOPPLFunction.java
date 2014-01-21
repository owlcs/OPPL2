package org.coode.oppl.function;

import org.coode.oppl.ConstraintSystem;
import org.coode.oppl.exceptions.RuntimeExceptionHandler;
import org.semanticweb.owlapi.util.ShortFormProvider;

/** @author Luigi Iannone */
public class ToLowerCaseStringManipulationOPPLFunction extends
        StringManipulationOPPLFunction {
    /** @param arg
     *            arg */
    public ToLowerCaseStringManipulationOPPLFunction(OPPLFunction<String> arg) {
        super(arg);
    }

    @Override
    public <P> P accept(OPPLFunctionVisitorEx<P> visitor) {
        return visitor.visitToLowerCaseStringManipulationOPPLFunction(this);
    }

    @Override
    public void accept(OPPLFunctionVisitor visitor) {
        visitor.visitToLowerCaseStringManipulationOPPLFunction(this);
    }

    @Override
    public String render(ConstraintSystem constraintSystem) {
        return String.format("%s.%s", getArgument().render(constraintSystem),
                "toLowerCase");
    }

    @Override
    public String render(ShortFormProvider shortFormProvider) {
        return String.format("%s.%s", getArgument().render(shortFormProvider),
                "toLowerCase");
    }

    @Override
    protected String manipulate(String string,
            RuntimeExceptionHandler runTimeExceptionHandler) {
        if (string == null) {
            runTimeExceptionHandler.handleException(new NullPointerException(
                    "The string cannot be null"));
            return "";
        }
        return string.toLowerCase();
    }

    @Override
    public void accept(StringManipulationOPPLFunctionVisitor visitor) {
        visitor.visitToLowerCaseStringManipulationOPPLFunction(this);
    }

    @Override
    public <O> O accept(StringManipulationOPPLFunctionVisitorEx<O> visitor) {
        return visitor.visitToLowerCaseStringManipulationOPPLFunction(this);
    }
}
