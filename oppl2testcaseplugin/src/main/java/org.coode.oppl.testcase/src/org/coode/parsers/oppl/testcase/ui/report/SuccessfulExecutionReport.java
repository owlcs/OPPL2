/**
 * 
 */
package org.coode.parsers.oppl.testcase.ui.report;

import java.util.Formatter;

import org.coode.parsers.oppl.testcase.OPPLTest;
import org.coode.parsers.oppl.testcase.OPPLTestCase;

/** Represents an entirely successful execution execution of test inside an
 * OPPLTestCase
 * 
 * @author Luigi Iannone */
public final class SuccessfulExecutionReport extends AbstractReport {
    private final OPPLTest successfulTest;

    /** @param opplTestCase */
    public SuccessfulExecutionReport(OPPLTestCase opplTestCase, OPPLTest test) {
        super(opplTestCase);
        if (test == null) {
            throw new NullPointerException("The successful test case cannot be null");
        }
        successfulTest = test;
    }

    /** @see org.coode.parsers.oppl.testcase.ui.report.Report#accept(org.coode.parsers
     *      .oppl.testcase.ui.report.ReportVisitor) */
    public void accept(ReportVisitor visitor) {
        visitor.visitSuccessfulExecutionReport(this);
    }

    /** @see org.coode.parsers.oppl.testcase.ui.report.Report#accept(org.coode.parsers
     *      .oppl.testcase.ui.report.ReportVisitorEx) */
    public <O> O accept(ReportVisitorEx<O> visitor) {
        return visitor.visitSuccessfulExecutionReport(this);
    }

    /** @return the successfulTest */
    public OPPLTest getSuccessfulTest() {
        return successfulTest;
    }

    @Override
    public String toString() {
        Formatter formatter = new Formatter();
        formatter.format("SUCCESSFUL %s", getSuccessfulTest());
        return formatter.toString();
    }
}
