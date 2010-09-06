/**
 * 
 */
package org.coode.parsers.oppl.testcase.assertions;

/**
 * Visitor pattern for the hierarchy rooted in {@link Assertion}.
 * 
 * @author Luigi Iannone
 * 
 */
public interface AssertionVisitor {
	void visitAssertEqual(AssertEqual assertEqual);

	void visitAssertNotEqual(AssertNotEqual assertNotEqual);

	void visitAssertContains(AssertContains assertContains);

	void visitAssertionComplement(AssertionComplement assertionComplement);

	void visitAssertLessThan(LessThanAssertion lessThanAssertion);

	void visitAssertLessThanEqualTo(
			LessThanEqualToAssertion lessThanEqualToAssertion);

	void visitAssertGreaterThan(GreatThanAssertion greatThanAssertion);

	void visitAssertGreaterThanEqualTo(
			GreaterThanEqualToAssertion greaterThanEqualToAssertion);
}
