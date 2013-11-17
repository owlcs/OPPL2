/**
 * 
 */
package org.coode.parsers.oppl.testcase.ui.report;

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

    @Override
    public void accept(ReportVisitor visitor) {
        visitor.visitAssertionFailedExecutionReport(this);
    }

    @Override
    public <O> O accept(ReportVisitorEx<O> visitor) {
        return visitor.visitAssertionFailedExecutionReport(this);
    }

    /** @return the failedTest */
    public OPPLTest getFailedTest() {
        return failedTest;
    }

    @Override
    public String toString() {
        return String.format("FAILED %s", getFailedTest());
    }
}
