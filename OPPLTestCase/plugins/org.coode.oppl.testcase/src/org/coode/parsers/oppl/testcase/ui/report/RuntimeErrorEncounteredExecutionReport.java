/**
 * 
 */
package org.coode.parsers.oppl.testcase.ui.report;

import java.util.Formatter;

import org.coode.parsers.oppl.testcase.OPPLTestCase;

/**
 * Represents an execution report about an OPPL Test Case whose execution was
 * abnormal because of an internal error/exception.
 * 
 * @author Luigi Iannone
 * 
 */
public class RuntimeErrorEncounteredExecutionReport extends UnsuccessfulExecutionReport {
	private final Throwable cause;

	/**
	 * @param opplTestCase
	 */
	public RuntimeErrorEncounteredExecutionReport(OPPLTestCase opplTestCase, Throwable t) {
		super(opplTestCase);
		if (t == null) {
			throw new NullPointerException("The Error/exception cannot be null");
		}
		this.cause = t;
	}

	/**
	 * @see org.coode.parsers.oppl.testcase.ui.report.Report#accept(org.coode.parsers
	 *      .oppl.testcase.ui.report.ReportVisitor)
	 */
	public void accept(ReportVisitor visitor) {
		visitor.visitRuntimeErrorEncounteredExecutionReport(this);
	}

	/**
	 * @see org.coode.parsers.oppl.testcase.ui.report.Report#accept(org.coode.parsers
	 *      .oppl.testcase.ui.report.ReportVisitorEx)
	 */
	public <O> O accept(ReportVisitorEx<O> visitor) {
		return visitor.visitRuntimeErrorEncounteredExecutionReport(this);
	}

	/**
	 * @return the cause
	 */
	public Throwable getCause() {
		return this.cause;
	}

	@Override
	public String toString() {
		Formatter formatter = new Formatter();
		formatter.format("RUNTIME ERROR %s", this.getCause());
		return formatter.toString();
	}
}
