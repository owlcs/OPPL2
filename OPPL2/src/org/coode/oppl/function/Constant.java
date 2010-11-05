/**
 * 
 */
package org.coode.oppl.function;

import org.coode.oppl.ConstraintSystem;
import org.coode.oppl.Variable;

/**
 * @author Luigi Iannone
 * 
 */
public class Constant<O> extends AbstractOPPLFunction<O> implements
		OPPLFunction<O> {
	private final O value;
	private final ValueComputation<O> valueComputation = new ValueComputation<O>() {
		public O compute(OPPLFunction<? extends O> opplFunction) {
			return Constant.this.getValue();
		}
	};

	/**
	 * @param value
	 */
	public Constant(O value) {
		this.value = value;
	}

	/**
	 * @see org.coode.oppl.function.OPPLFunction#getValue()
	 */
	public O getValue() {
		return this.value;
	}

	public <P> P accept(OPPLFunctionVisitorEx<P> visitor) {
		return visitor.visitConstant(this);
	}

	public void accept(OPPLFunctionVisitor visitor) {
		visitor.visitConstant(this);
	}

	@Override
	public ValueComputation<O> getValueComputation(
			ValueComputationParameters parameters) {
		return this.valueComputation;
	}

	public String render(ConstraintSystem constraintSystem) {
		return this.getValue() instanceof Variable ? ((Variable) this
				.getValue()).getName()
				: this.getValue() instanceof String ? String.format("\"%s\"",
						this.getValue()) : this.getValue().toString();
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
		result = prime * result
				+ (this.value == null ? 0 : this.value.hashCode());
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
		Constant<?> other = (Constant<?>) obj;
		if (this.value == null) {
			if (other.value != null) {
				return false;
			}
		} else if (!this.value.equals(other.value)) {
			return false;
		}
		return true;
	}
}
