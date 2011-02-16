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

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (this.attribute == null ? 0 : this.attribute.hashCode());
		result = prime * result + (this.variable == null ? 0 : this.variable.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (this.getClass() != obj.getClass()) {
			return false;
		}
		VariableAttribute<?> other = (VariableAttribute<?>) obj;
		if (this.attribute != other.attribute) {
			return false;
		}
		if (this.variable == null) {
			if (other.variable != null) {
				return false;
			}
		} else if (!this.variable.equals(other.variable)) {
			return false;
		}
		return true;
	}
}
