/**
 * 
 */
package org.coode.parsers.oppl.testcase.ui.report;

import org.coode.parsers.oppl.testcase.OPPLTestCase;

/** Represents an execution report about an OPPL Test Case whose execution was
 * abnormal because of an internal error/exception.
 * 
 * @author Luigi Iannone */
public class RuntimeErrorEncounteredExecutionReport extends UnsuccessfulExecutionReport {
    private final Throwable cause;

    /** @param opplTestCase
     * @param t */
    public RuntimeErrorEncounteredExecutionReport(OPPLTestCase opplTestCase, Throwable t) {
        super(opplTestCase);
        if (t == null) {
            throw new NullPointerException("The Error/exception cannot be null");
        }
        cause = t;
    }

    @Override
    public void accept(ReportVisitor visitor) {
        visitor.visitRuntimeErrorEncounteredExecutionReport(this);
    }

    @Override
    public <O> O accept(ReportVisitorEx<O> visitor) {
        return visitor.visitRuntimeErrorEncounteredExecutionReport(this);
    }

    /** @return the cause */
    public Throwable getCause() {
        return cause;
    }

    @Override
    public String toString() {
        return String.format("RUNTIME ERROR %s", getCause());
    }
}
