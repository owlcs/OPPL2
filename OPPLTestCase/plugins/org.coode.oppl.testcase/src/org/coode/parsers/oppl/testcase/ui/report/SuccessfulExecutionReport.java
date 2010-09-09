/**
 * 
 */
package org.coode.parsers.oppl.testcase.ui.report;

import java.util.Formatter;

import org.coode.parsers.oppl.testcase.OPPLTestCase;
import org.coode.parsers.oppl.testcase.Test;

/**
 * Represents an entirely successful execution execution of test inside an
 * OPPLTestCase
 * 
 * 
 * @author Luigi Iannone
 * 
 */
public final class SuccessfulExecutionReport extends AbstractReport {
	private final Test successfulTest;

	/**
	 * @param opplTestCase
	 */
	public SuccessfulExecutionReport(OPPLTestCase opplTestCase, Test test) {
		super(opplTestCase);
		if (test == null) {
			throw new NullPointerException("The successful test case cannot be null");
		}
		this.successfulTest = test;
	}

	/**
	 * @see org.coode.parsers.oppl.testcase.ui.report.Report#accept(org.coode.parsers
	 *      .oppl.testcase.ui.report.ReportVisitor)
	 */
	public void accept(ReportVisitor visitor) {
		visitor.visitSuccessfulExecutionReport(this);
	}

	/**
	 * @see org.coode.parsers.oppl.testcase.ui.report.Report#accept(org.coode.parsers
	 *      .oppl.testcase.ui.report.ReportVisitorEx)
	 */
	public <O> O accept(ReportVisitorEx<O> visitor) {
		return visitor.visitSuccessfulExecutionReport(this);
	}

	/**
	 * @return the successfulTest
	 */
	public Test getSuccessfulTest() {
		return this.successfulTest;
	}

	@Override
	public String toString() {
		Formatter formatter = new Formatter();
		formatter.format("SUCCESSFUL %s", this.getSuccessfulTest());
		return formatter.toString();
	}
}
