package org.coode.parsers.oppl.testcase.ui.report;

import static org.coode.oppl.utils.ArgCheck.checkNotNull;

import org.coode.parsers.oppl.testcase.OPPLTest;
import org.coode.parsers.oppl.testcase.OPPLTestCase;

/** Represents an entirely successful execution execution of test inside an
 * OPPLTestCase
 * 
 * @author Luigi Iannone */
public final class SuccessfulExecutionReport extends AbstractReport {
    private final OPPLTest successfulTest;

    /** @param opplTestCase
     *            opplTestCase
     * @param test
     *            test */
    public SuccessfulExecutionReport(OPPLTestCase opplTestCase, OPPLTest test) {
        super(opplTestCase);
        successfulTest = checkNotNull(test, "test");
    }

    @Override
    public void accept(ReportVisitor visitor) {
        visitor.visitSuccessfulExecutionReport(this);
    }

    @Override
    public <O> O accept(ReportVisitorEx<O> visitor) {
        return visitor.visitSuccessfulExecutionReport(this);
    }

    /** @return the successfulTest */
    public OPPLTest getSuccessfulTest() {
        return successfulTest;
    }

    @Override
    public String toString() {
        return String.format("SUCCESSFUL %s", getSuccessfulTest());
    }
}
