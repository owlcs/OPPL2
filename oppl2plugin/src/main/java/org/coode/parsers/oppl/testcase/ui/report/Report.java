/**
 * Generic report compiled after an attempt (successful or not) tp run an OPPLTestCase
 */
package org.coode.parsers.oppl.testcase.ui.report;

import org.coode.parsers.oppl.testcase.OPPLTestCase;

/** @author Luigi Iannone */
public interface Report {
    /** Retrieves the OPPLTestCase this report is about
     * 
     * @return an OPPLTestCase. */
    OPPLTestCase getOPPLTestCase();

    /** @param visitor */
    void accept(ReportVisitor visitor);

    /** @param visitor
     * @return visitor result */
    <O> O accept(ReportVisitorEx<O> visitor);
}
