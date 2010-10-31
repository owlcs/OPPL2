package org.coode.oppl.function;

import org.coode.oppl.Variable;
import org.coode.parsers.oppl.variableattribute.AttributeNames;

public abstract class VariableAttribute<O> extends AbstractOPPLFunction<O>
		implements OPPLFunction<O> {
	private final Variable variable;
	private final AttributeNames attribute;

	/**
	 * @param variable
	 * @param attribute
	 */
	public VariableAttribute(Variable variable, AttributeNames attribute) {
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
	public Variable getVariable() {
		return this.variable;
	}

	/**
	 * @return the attribute
	 */
	public AttributeNames getAttribute() {
		return this.attribute;
	}
}
