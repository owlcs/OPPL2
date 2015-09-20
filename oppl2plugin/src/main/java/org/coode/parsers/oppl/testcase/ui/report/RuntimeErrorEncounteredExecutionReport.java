package org.coode.parsers.oppl.testcase.ui.report;

import static org.coode.oppl.utils.ArgCheck.checkNotNull;

import org.coode.parsers.oppl.testcase.OPPLTestCase;

/**
 * Represents an execution report about an OPPL Test Case whose execution was
 * abnormal because of an internal error/exception.
 * 
 * @author Luigi Iannone
 */
public class RuntimeErrorEncounteredExecutionReport extends UnsuccessfulExecutionReport {

    private final Throwable cause;

    /**
     * @param opplTestCase
     *        opplTestCase
     * @param t
     *        t
     */
    public RuntimeErrorEncounteredExecutionReport(OPPLTestCase opplTestCase, Throwable t) {
        super(opplTestCase);
        cause = checkNotNull(t, "t");
    }

    @Override
    public void accept(ReportVisitor visitor) {
        visitor.visitRuntimeErrorEncounteredExecutionReport(this);
    }

    @Override
    public <O> O accept(ReportVisitorEx<O> visitor) {
        return visitor.visitRuntimeErrorEncounteredExecutionReport(this);
    }

    /**
     * @return the cause
     */
    public Throwable getCause() {
        return cause;
    }

    @Override
    public String toString() {
        return String.format("RUNTIME ERROR %s", getCause());
    }
}
