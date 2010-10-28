/**
 * 
 */
package org.coode.oppl.function;

/**
 * @author Luigi Iannone
 * 
 */
public class Constant<O> extends AbstractOPPLFunction<O> implements OPPLFunction<O> {
	private final O value;

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
}
