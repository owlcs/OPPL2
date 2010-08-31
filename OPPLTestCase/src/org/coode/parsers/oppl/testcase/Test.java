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
}
