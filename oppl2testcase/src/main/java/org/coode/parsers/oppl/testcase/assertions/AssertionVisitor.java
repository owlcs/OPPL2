/**
 * 
 */
package org.coode.parsers.oppl.testcase.assertions;

/** Visitor pattern for the hierarchy rooted in {@link Assertion}.
 * 
 * @author Luigi Iannone */
public interface AssertionVisitor {
    /** @param assertion */
    void visitAssertEqual(AssertEqual assertion);

    /** @param assertion */
    void visitAssertNotEqual(AssertNotEqual assertion);

    /** @param assertion */
    void visitAssertContains(AssertContains assertion);

    /** @param assertion */
    void visitAssertionComplement(AssertionComplement assertion);

    /** @param assertion */
    void visitAssertLessThan(LessThanAssertion assertion);

    /** @param assertion */
    void visitAssertLessThanEqualTo(LessThanEqualToAssertion assertion);

    /** @param assertion */
    void visitAssertGreaterThan(GreatThanAssertion assertion);

    /** @param assertion */
    void visitAssertGreaterThanEqualTo(GreaterThanEqualToAssertion assertion);
}
