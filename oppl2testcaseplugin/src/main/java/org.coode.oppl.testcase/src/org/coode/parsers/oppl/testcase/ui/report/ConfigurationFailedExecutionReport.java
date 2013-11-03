/**
 * 
 */
package org.coode.parsers.oppl.testcase.ui.report;

import java.util.Formatter;

import org.coode.parsers.oppl.testcase.OPPLTestCase;

/**
 * Represents an execution of an OPPLTestCase that terminated unsuccessfully
 * because its configuration failed.
 * 
 * @author Luigi Iannone
 * 
 */
public class ConfigurationFailedExecutionReport extends UnsuccessfulExecutionReport {
	private final String message;

	/**
	 * @param opplTestCase
	 */
	public ConfigurationFailedExecutionReport(OPPLTestCase opplTestCase, String message) {
		super(opplTestCase);
		if (message == null) {
			throw new NullPointerException("The message cannot be null");
		}
		this.message = message;
	}

	/**
	 * @see org.coode.parsers.oppl.testcase.ui.report.Report#accept(org.coode.parsers
	 *      .oppl.testcase.ui.report.ReportVisitor)
	 */
	public void accept(ReportVisitor visitor) {
		visitor.visitConfigurationFailedExecutionReport(this);
	}

	/**
	 * @see org.coode.parsers.oppl.testcase.ui.report.Report#accept(org.coode.parsers
	 *      .oppl.testcase.ui.report.ReportVisitorEx)
	 */
	public <O> O accept(ReportVisitorEx<O> visitor) {
		return visitor.visitConfigurationFailedExecutionReport(this);
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return this.message;
	}

	@Override
	public String toString() {
		Formatter formatter = new Formatter();
		formatter.format("FAILED CONFIGURATION %s", this.getMessage());
		return formatter.toString();
	}
}
