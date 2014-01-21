package org.coode.parsers.oppl.testcase.assertions;

/** Visitor pattern for the hierarchy rooted in {@link Assertion} with a return
 * value.
 * 
 * @author Luigi Iannone
 * @param <O>
 *            the type of the returned value. */
public interface AssertionVisitorEx<O> {
    /** @param assertion
     *            assertion
     * @return visitor value */
    O visitAssertEqual(AssertEqual assertion);

    /** @param assertion
     *            assertion
     * @return visitor value */
    O visitAssertNotEqual(AssertNotEqual assertion);

    /** @param assertion
     *            assertion
     * @return visitor value */
    O visitAssertContains(AssertContains assertion);

    /** @param assertion
     *            assertion
     * @return visitor value */
    O visitAssertionComplement(AssertionComplement assertion);

    /** @param assertion
     *            assertion
     * @return visitor value */
    O visitAssertLessThan(LessThanAssertion assertion);

    /** @param assertion
     *            assertion
     * @return visitor value */
    O visitAssertLessThanEqualtTo(LessThanEqualToAssertion assertion);

    /** @param assertion
     *            assertion
     * @return visitor value */
    O visitAssertGreaterThan(GreatThanAssertion assertion);

    /** @param assertion
     *            assertion
     * @return visitor value */
    O visitAssertGreaterThanEqualTo(GreaterThanEqualToAssertion assertion);
}
