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

    void accept(ReportVisitor visitor);

    <O> O accept(ReportVisitorEx<O> visitor);
}
