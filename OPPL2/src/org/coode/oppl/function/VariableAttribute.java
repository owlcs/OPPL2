package org.coode.oppl.function;

import org.coode.oppl.ConstraintSystem;
import org.coode.oppl.Variable;
import org.semanticweb.owlapi.util.ShortFormProvider;

public abstract class VariableAttribute<O> extends AbstractOPPLFunction<O> implements
		OPPLFunction<O> {
	private final Variable<?> variable;
	private final AttributeName attribute;

	/**
	 * @param variable
	 * @param attribute
	 */
	public VariableAttribute(Variable<?> variable, AttributeName attribute) {
		if (variable == null) {
			throw new NullPointerException("The variable cannot be null");
		}
		if (attribute == null) {
			throw new NullPointerException("The attribute cannot be null");
		}
		this.variable = variable;
		this.attribute = attribute;
	}

	/**
	 * @return the variable
	 */
	public Variable<?> getVariable() {
		return this.variable;
	}

	/**
	 * @return the attribute
	 */
	public AttributeName getAttribute() {
		return this.attribute;
	}

	@Override
	public String toString() {
		return String.format("%s.%s", this.getVariable().getName(), this.getAttribute());
	}

	public String render(ConstraintSystem constraintSystem) {
		return this.toString();
	}

	public String render(ShortFormProvider shortFormProvider) {
		return this.toString();
	}
}
