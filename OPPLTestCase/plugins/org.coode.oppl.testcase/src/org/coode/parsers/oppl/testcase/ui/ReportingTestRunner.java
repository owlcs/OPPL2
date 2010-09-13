/**
 * 
 */
package org.coode.parsers.oppl.testcase.ui;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.coode.parsers.oppl.testcase.OPPLTestCase;
import org.coode.parsers.oppl.testcase.Test;
import org.coode.parsers.oppl.testcase.TestCaseRunner;
import org.coode.parsers.oppl.testcase.ui.report.AssertionFailedExecutionReport;
import org.coode.parsers.oppl.testcase.ui.report.ConfigurationFailedExecutionReport;
import org.coode.parsers.oppl.testcase.ui.report.Report;
import org.coode.parsers.oppl.testcase.ui.report.RuntimeErrorEncounteredExecutionReport;
import org.coode.parsers.oppl.testcase.ui.report.SuccessfulExecutionReport;

/**
 * @author Luigi Iannone
 * 
 */
public class ReportingTestRunner {
	private final class OPPLTestCaseRunner extends TestCaseRunner {
		private final Map<OPPLTestCase, List<Report>> reports;

		/**
		 * @param opplTestCase
		 * @param reports
		 */
		public OPPLTestCaseRunner(OPPLTestCase opplTestCase,
				Map<OPPLTestCase, List<Report>> reports) {
			super(opplTestCase);
			assert reports != null;
			this.reports = reports;
		}

		/**
		 * @see org.coode.parsers.oppl.testcase.TestCaseRunner#configurationFailed(java.lang.String)
		 */
		@Override
		protected void configurationFailed(String message) {
			List<Test> tests = this.getOPPLTestCase().getTests();
			ConfigurationFailedExecutionReport configurationFailedExecutionReport = new ConfigurationFailedExecutionReport(
					this.getOPPLTestCase(), message);
			List<Report> reports = new ArrayList<Report>(tests.size() + 1);
			reports.add(configurationFailedExecutionReport);
			this.reports.put(ReportingTestRunner.this.opplTestCase, reports);
		}

		/**
		 * @see org.coode.parsers.oppl.testcase.TestCaseRunner#success(org.coode.parsers.oppl.testcase.Test)
		 */
		@Override
		protected void success(Test test) {
			List<Report> previousReports = this.reports.get(this
					.getOPPLTestCase());
			if (previousReports == null) {
				previousReports = new ArrayList<Report>();
				this.reports.put(this.getOPPLTestCase(), previousReports);
			}
			previousReports.add(new SuccessfulExecutionReport(this
					.getOPPLTestCase(), test));
		}

		/**
		 * @see org.coode.parsers.oppl.testcase.TestCaseRunner#fail(org.coode.parsers.oppl.testcase.Test)
		 */
		@Override
		protected void fail(Test test) {
			List<Report> previousReports = this.reports.get(this
					.getOPPLTestCase());
			if (previousReports == null) {
				previousReports = new ArrayList<Report>();
				this.reports.put(this.getOPPLTestCase(), previousReports);
			}
			previousReports.add(new AssertionFailedExecutionReport(this
					.getOPPLTestCase(), test));
		}

		/**
		 * @see org.coode.parsers.oppl.testcase.TestCaseRunner#fail(java.lang.Throwable)
		 */
		@Override
		protected void fail(Throwable e) {
			List<Report> previousReports = this.reports.get(this
					.getOPPLTestCase());
			if (previousReports == null) {
				previousReports = new ArrayList<Report>();
				this.reports.put(this.getOPPLTestCase(), previousReports);
			}
			previousReports.add(new RuntimeErrorEncounteredExecutionReport(this
					.getOPPLTestCase(), e));
		}
	}

	private final OPPLTestCase opplTestCase;

	/**
	 * @param opplTestCase
	 */
	public ReportingTestRunner(OPPLTestCase opplTestCase) {
		if (opplTestCase == null) {
			throw new NullPointerException("The OPPL Test Case cannot be null");
		}
		this.opplTestCase = opplTestCase;
	}

	/**
	 * @return the opplTestCase
	 */
	public OPPLTestCase getOPPLTestCase() {
		return this.opplTestCase;
	}

	/**
	 * Executes the test case returning a Map whose keys are the input
	 * OPPLTestCases and whose values are the various reports resulting from
	 * them.
	 * 
	 * 
	 * @return A Map.
	 * @throws NullPointerException
	 *             when the input is <code>null</code>.
	 */
	public Map<OPPLTestCase, List<Report>> run() {
		Map<OPPLTestCase, List<Report>> toReturn = new HashMap<OPPLTestCase, List<Report>>();
		OPPLTestCaseRunner testCaseRunner = new OPPLTestCaseRunner(
				this.opplTestCase, toReturn);
		testCaseRunner.run();
		return toReturn;
	}
}
