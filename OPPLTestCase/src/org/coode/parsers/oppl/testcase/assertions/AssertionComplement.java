/**
 * 
 */
package org.coode.parsers.oppl.testcase.assertions;

import java.util.Set;

import org.coode.oppl.ConstraintSystem;
import org.coode.oppl.bindingtree.BindingNode;

/**
 * @author Luigi Iannone
 * 
 */
public class AssertionComplement implements Assertion {
	private final Assertion assertion;

	/**
	 * @param assertion
	 */
	public AssertionComplement(Assertion assertion) {
		if (assertion == null) {
			throw new NullPointerException("The assertion cannot be null");
		}
		this.assertion = assertion;
	}

	/**
	 * @see org.coode.parsers.oppl.testcase.assertions.Assertion#accept(org.coode
	 *      .parsers.oppl.testcase.assertions.AssertionVisitor)
	 */
	public void accept(AssertionVisitor visitor) {
		visitor.visitAssertionComplement(this);
	}

	/**
	 * @see org.coode.parsers.oppl.testcase.assertions.Assertion#accept(org.coode
	 *      .parsers.oppl.testcase.assertions.AssertionVisitorEx)
	 */
	public <O> O accept(AssertionVisitorEx<O> visitor) {
		return visitor.visitAssertionComplement(this);
	}

	public Assertion getOperand() {
		return this.assertion;
	}

	public boolean holds(Set<? extends BindingNode> bindings,
			ConstraintSystem constraintSystem) {
		return !this.getOperand().holds(bindings, constraintSystem);
	}
}
