/**
 * 
 */
package org.coode.parsers.oppl.testcase.assertions;

/**
 * Visitor pattern for the hierarchy rooted in {@link Assertion} with a return
 * value.
 * 
 * @author Luigi Iannone
 * @param <O>
 *            the type of the returned value.
 */
public interface AssertionVisitorEx<O> {
	O visitAssertEqual(AssertEqual assertEqual);

	O visitAssertNotEqual(AssertNotEqual assertNotEqual);

	O visitAssertContains(AssertContains assertContains);

	O visitAssertionComplement(AssertionComplement assertionComplement);

	O visitAssertLessThan(LessThanAssertion lessThanAssertion);

	O visitAssertLessThanEqualtTo(
			LessThanEqualToAssertion lessThanEqualToAssertion);

	O visitAssertGreaterThan(GreatThanAssertion greatThanAssertion);

	O visitAssertGreaterThanEqualTo(
			GreaterThanEqualToAssertion greaterThanEqualToAssertion);
}
