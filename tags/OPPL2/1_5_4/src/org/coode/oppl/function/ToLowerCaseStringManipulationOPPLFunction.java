package org.coode.oppl.function;

import org.coode.oppl.ConstraintSystem;
import org.coode.oppl.exceptions.RuntimeExceptionHandler;
import org.semanticweb.owlapi.util.ShortFormProvider;

public class ToLowerCaseStringManipulationOPPLFunction extends StringManipulationOPPLFunction {
	/**
	 * @param argument
	 */
	public ToLowerCaseStringManipulationOPPLFunction(OPPLFunction<String> arg) {
		super(arg);
	}

	public <P> P accept(OPPLFunctionVisitorEx<P> visitor) {
		return visitor.visitToLowerCaseStringManipulationOPPLFunction(this);
	}

	public void accept(OPPLFunctionVisitor visitor) {
		visitor.visitToLowerCaseStringManipulationOPPLFunction(this);
	}

	public String render(ConstraintSystem constraintSystem) {
		return String.format("%s.%s", this.getArgument().render(constraintSystem), "toLowerCase");
	}

	public String render(ShortFormProvider shortFormProvider) {
		return String.format("%s.%s", this.getArgument().render(shortFormProvider), "toLowerCase");
	}

	@Override
	protected String manipulate(String string, RuntimeExceptionHandler runTimeExceptionHandler) {
		if (string == null) {
			runTimeExceptionHandler.handleException(new NullPointerException(
					"The string cannot be null"));
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
