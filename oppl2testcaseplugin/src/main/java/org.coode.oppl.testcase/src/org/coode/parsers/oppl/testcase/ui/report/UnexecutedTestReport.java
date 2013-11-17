/**
 * 
 */
package org.coode.parsers.oppl.testcase.ui.report;

import org.coode.parsers.oppl.testcase.OPPLTest;
import org.coode.parsers.oppl.testcase.OPPLTestCase;

/** Represents a report about a Test that has not been yet executed.
 * 
 * @author Luigi Iannone */
public class UnexecutedTestReport extends AbstractReport {
    private final OPPLTest unexecutedTest;

    /** @param opplTestCase
     * @param unexecutedTest */
    public UnexecutedTestReport(OPPLTestCase opplTestCase, OPPLTest unexecutedTest) {
        super(opplTestCase);
        if (unexecutedTest == null) {
            throw new NullPointerException("The unexecuted test cannot be null");
        }
        this.unexecutedTest = unexecutedTest;
    }

    @Override
    public void accept(ReportVisitor visitor) {
        visitor.visitUnexecutedTestReport(this);
    }

    @Override
    public <O> O accept(ReportVisitorEx<O> visitor) {
        return visitor.visitUnexecutedTestReport(this);
    }

    /** @return the unexecutedTest */
    public OPPLTest getUnexecutedTest() {
        return unexecutedTest;
    }

    @Override
    public String toString() {
        return String.format("UNEXECUTED %s", getUnexecutedTest());
    }
}
