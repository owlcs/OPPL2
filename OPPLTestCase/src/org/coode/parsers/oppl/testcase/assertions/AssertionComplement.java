/**
 * 
 */
package org.coode.parsers.oppl.testcase.assertions;

import java.util.Formatter;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ (this.assertion == null ? 0 : this.assertion.hashCode());
		return result;
	}

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
		AssertionComplement other = (AssertionComplement) obj;
		if (this.assertion == null) {
			if (other.assertion != null) {
				return false;
			}
		} else if (!this.assertion.equals(other.assertion)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		Formatter formatter = new Formatter();
		formatter.format("NOT %s", this.getOperand().toString());
		return formatter.toString();
	}
}
