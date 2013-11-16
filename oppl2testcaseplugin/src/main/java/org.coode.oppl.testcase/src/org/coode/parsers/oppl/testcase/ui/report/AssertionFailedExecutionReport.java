/**
 * 
 */
package org.coode.parsers.oppl.testcase.ui.report;

import java.util.Formatter;

import org.coode.parsers.oppl.testcase.OPPLTest;
import org.coode.parsers.oppl.testcase.OPPLTestCase;

/** Represents an unsuccesful execution of an OPPLTestCase where an assertion in
 * a test failed.
 * 
 * @author Luigi Iannone */
public class AssertionFailedExecutionReport extends UnsuccessfulExecutionReport {
    private final OPPLTest failedTest;

    /** @param opplTestCase
     * @param failedTest */
    public AssertionFailedExecutionReport(OPPLTestCase opplTestCase, OPPLTest failedTest) {
        super(opplTestCase);
        if (failedTest == null) {
            throw new NullPointerException("The Failed test cannot be null");
        }
        this.failedTest = failedTest;
    }

    /** @see org.coode.parsers.oppl.testcase.ui.report.Report#accept(org.coode.parsers
     *      .oppl.testcase.ui.report.ReportVisitor) */
    public void accept(ReportVisitor visitor) {
        visitor.visitAssertionFailedExecutionReport(this);
    }

    /** @see org.coode.parsers.oppl.testcase.ui.report.Report#accept(org.coode.parsers
     *      .oppl.testcase.ui.report.ReportVisitorEx) */
    public <O> O accept(ReportVisitorEx<O> visitor) {
        return visitor.visitAssertionFailedExecutionReport(this);
    }

    /** @return the failedTest */
    public OPPLTest getFailedTest() {
        return failedTest;
    }

    @Override
    public String toString() {
        Formatter formatter = new Formatter();
        formatter.format("FAILED %s", getFailedTest());
        return formatter.toString();
    }
}
