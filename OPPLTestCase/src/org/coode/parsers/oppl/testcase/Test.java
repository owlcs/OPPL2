/**
 * 
 */
package org.coode.parsers.oppl.testcase;

import java.util.Formatter;

import org.coode.parsers.oppl.testcase.assertions.Assertion;

/**
 * A Test contains an Assertion and an optional message that should be displayed
 * if the Assertion fails.
 * 
 * @author Luigi Iannone
 * 
 */
public class Test {
	public static final String NO_MESSAGE = "";
	private final String message;
	private final Assertion assertion;

	/**
	 * @param assertion
	 */
	public Test(Assertion assertion) {
		this(NO_MESSAGE, assertion);
	}

	/**
	 * @param message
	 * @param assertion
	 */
	public Test(String message, Assertion assertion) {
		if (message == null) {
			throw new NullPointerException("The message cannot be null");
		}
		if (assertion == null) {
			throw new NullPointerException("The assertion cannot be null");
		}
		this.message = message;
		this.assertion = assertion;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return this.message;
	}

	/**
	 * @return the assertion
	 */
	public Assertion getAssertion() {
		return this.assertion;
	}

	@Override
	public String toString() {
		Formatter formatter = new Formatter();
		// Grammar rule
		// ASSERT assertion (SEMICOLON message)?
		formatter.format(
				"ASSERT %s %s",
				this.getAssertion(),
				this.getMessage().equals(NO_MESSAGE) ? NO_MESSAGE : "; " + this.getMessage());
		return formatter.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (this.assertion == null ? 0 : this.assertion.hashCode());
		result = prime * result + (this.message == null ? 0 : this.message.hashCode());
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
		Test other = (Test) obj;
		if (this.assertion == null) {
			if (other.assertion != null) {
				return false;
			}
		} else if (!this.assertion.equals(other.assertion)) {
			return false;
		}
		if (this.message == null) {
			if (other.message != null) {
				return false;
			}
		} else if (!this.message.equals(other.message)) {
			return false;
		}
		return true;
	}
}
