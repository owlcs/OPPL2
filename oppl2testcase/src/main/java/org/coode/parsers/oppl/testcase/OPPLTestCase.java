package org.coode.parsers.oppl.testcase;

import java.util.List;

import org.coode.oppl.OPPLScript;

/**
 * A Test case consists of a series of assertions on the results of a query
 * expressed in OPPL.
 * 
 * @author Luigi Iannone
 */
public interface OPPLTestCase {

    /**
     * Retrieves the name of this OPPLTest
     * 
     * @return a String
     */
    String getName();

    /**
     * Determines whether this OPPLTestCase should be run in presence of a
     * reasoner.
     * 
     * @return {@code true} if this OPPLTestCase needs a reasoner, {@code false}
     *         otherwise.
     */
    boolean requiresInference();

    /**
     * Retrieves the OPPLScript contained by this OPPLTestCase.
     * 
     * @return an OPPLScript instance.
     */
    OPPLScript getOPPLScript();

    /**
     * Retrieves the list of Test instances for this OPPLTestCase.
     * 
     * @return A List containing all the tests.
     */
    List<OPPLTest> getTests();
}
