package org.coode.parsers.oppl.testcase.assertions;

import java.util.Set;

import org.coode.oppl.ConstraintSystem;
import org.coode.oppl.bindingtree.BindingNode;

/**
 * An assertion is a test on the results of a query contained in an OPPLTestCase
 * 
 * @author Luigi Iannone
 */
public interface Assertion {

    /**
     * @param visitor
     *        visitor
     */
    void accept(AssertionVisitor visitor);

    /**
     * @param visitor
     *        visitor
     * @return visitor value
     */
    <O> O accept(AssertionVisitorEx<O> visitor);

    /**
     * Determines whether this Assertion is valid for the input bindings.
     * 
     * @param bindings
     *        The bindings against which this Assertion will be checked. Cannot
     *        be {@code null}.
     * @param constraintSystem
     *        . Cannot be {@code null}.
     * @return {@code true} if this Assertion holds.
     * @throws NullPointerException
     *         if either input is {@code null}.
     */
    boolean holds(Set<? extends BindingNode> bindings, ConstraintSystem constraintSystem);
}
