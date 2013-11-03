/**
 * 
 */
package org.coode.parsers.oppl.testcase.ui.report;

/**
 * @author Luigi Iannone
 * 
 */
public abstract class DefaultReportVisitorExAdapter<O> implements ReportVisitorEx<O> {
	private final O defaultValue;

	public DefaultReportVisitorExAdapter() {
		this(null);
	}

	public DefaultReportVisitorExAdapter(O defaultValue) {
		this.defaultValue = defaultValue;
	}

	/**
	 * @see org.coode.parsers.oppl.testcase.ui.report.ReportVisitorEx#
	 *      visitSuccessfulExecutionReport
	 *      (org.coode.parsers.oppl.testcase.ui.report.SuccessfulExecutionReport)
	 */
	public O visitSuccessfulExecutionReport(SuccessfulExecutionReport successfulExecutionReport) {
		return this.getDefaultValue(successfulExecutionReport);
	}

	/**
	 * @see org.coode.parsers.oppl.testcase.ui.report.ReportVisitorEx#
	 *      visitConfigurationFailedExecutionReport
	 *      (org.coode.parsers.oppl.testcase.ui
	 *      .report.ConfigurationFailedExecutionReport)
	 */
	public O visitConfigurationFailedExecutionReport(
			ConfigurationFailedExecutionReport configurationFailedExecutionReport) {
		return this.getDefaultValue(configurationFailedExecutionReport);
	}

	/**
	 * @see org.coode.parsers.oppl.testcase.ui.report.ReportVisitorEx#
	 *      visitRuntimeErrorEncounteredExecutionReport
	 *      (org.coode.parsers.oppl.testcase
	 *      .ui.report.RuntimeErrorEncounteredExecutionReport)
	 */
	public O visitRuntimeErrorEncounteredExecutionReport(
			RuntimeErrorEncounteredExecutionReport runtimeErrorEncounteredExecutionReport) {
		return this.getDefaultValue(runtimeErrorEncounteredExecutionReport);
	}

	/**
	 * @see org.coode.parsers.oppl.testcase.ui.report.ReportVisitorEx#
	 *      visitAssertionFailedExecutionReport
	 *      (org.coode.parsers.oppl.testcase.ui.report
	 *      .AssertionFailedExecutionReport)
	 */
	public O visitAssertionFailedExecutionReport(
			AssertionFailedExecutionReport assertionFailedExecutionReport) {
		return this.getDefaultValue(assertionFailedExecutionReport);
	}

	/**
	 * @see org.coode.parsers.oppl.testcase.ui.report.ReportVisitorEx#
	 *      visitUnexecutedTestReport
	 *      (org.coode.parsers.oppl.testcase.ui.report.UnexecutedTestReport)
	 */
	public O visitUnexecutedTestReport(UnexecutedTestReport unexecutedTestReport) {
		return this.getDefaultValue(unexecutedTestReport);
	}

	/**
	 * @return the defaultValue
	 */
	protected O getDefaultValue(Report report) {
		return this.defaultValue;
	}
}
