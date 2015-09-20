package org.coode.parsers.oppl.testcase.assertions;

/**
 * Visitor pattern for the hierarchy rooted in {@link Assertion}.
 * 
 * @author Luigi Iannone
 */
public interface AssertionVisitor {

    /**
     * @param assertion
     *        assertion
     */
    void visitAssertEqual(AssertEqual assertion);

    /**
     * @param assertion
     *        assertion
     */
    void visitAssertNotEqual(AssertNotEqual assertion);

    /**
     * @param assertion
     *        assertion
     */
    void visitAssertContains(AssertContains assertion);

    /**
     * @param assertion
     *        assertion
     */
    void visitAssertionComplement(AssertionComplement assertion);

    /**
     * @param assertion
     *        assertion
     */
    void visitAssertLessThan(LessThanAssertion assertion);

    /**
     * @param assertion
     *        assertion
     */
    void visitAssertLessThanEqualTo(LessThanEqualToAssertion assertion);

    /**
     * @param assertion
     *        assertion
     */
    void visitAssertGreaterThan(GreatThanAssertion assertion);

    /**
     * @param assertion
     *        assertion
     */
    void visitAssertGreaterThanEqualTo(GreaterThanEqualToAssertion assertion);
}
