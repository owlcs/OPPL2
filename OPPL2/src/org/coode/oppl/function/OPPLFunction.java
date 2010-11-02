/**
 * 
 */
package org.coode.oppl.function;

import org.coode.oppl.ConstraintSystem;

/**
 * A function
 * 
 * @author Luigi Iannone
 * 
 * 
 */
public interface OPPLFunction<O> {
	public O compute(ValueComputationParameters params);

	public <P> P accept(OPPLFunctionVisitorEx<P> visitor);

	public void accept(OPPLFunctionVisitor visitor);

	public String render(ConstraintSystem constraintSystem);
}
