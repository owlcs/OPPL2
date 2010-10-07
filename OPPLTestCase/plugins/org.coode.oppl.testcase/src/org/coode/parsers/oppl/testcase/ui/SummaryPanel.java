/**
 * 
 */
package org.coode.parsers.oppl.testcase.ui;

import java.awt.BorderLayout;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JLabel;
import javax.swing.JPanel;

import org.coode.parsers.oppl.testcase.OPPLTestCase;
import org.coode.parsers.oppl.testcase.ui.report.AssertionFailedExecutionReport;
import org.coode.parsers.oppl.testcase.ui.report.ConfigurationFailedExecutionReport;
import org.coode.parsers.oppl.testcase.ui.report.Report;
import org.coode.parsers.oppl.testcase.ui.report.ReportVisitorEx;
import org.coode.parsers.oppl.testcase.ui.report.RuntimeErrorEncounteredExecutionReport;
import org.coode.parsers.oppl.testcase.ui.report.SuccessfulExecutionReport;
import org.coode.parsers.oppl.testcase.ui.report.UnexecutedTestReport;

/**
 * @author Luigi Iannone
 * 
 */
public class SummaryPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8637279561572511591L;
	private final JLabel runTestSummary = new JLabel();
	private final JLabel okTestSummary = new JLabel();
	private final JLabel errorTestSummary = new JLabel();
	private final Map<OPPLTestCase, List<Report>> reports = new HashMap<OPPLTestCase, List<Report>>();

	public SummaryPanel() {
		this.initGUI();
		this.refresh();
	}

	private void initGUI() {
		this.setLayout(new BorderLayout());
		this.add(this.runTestSummary, BorderLayout.WEST);
		JPanel resultBreakDown = new JPanel();
		resultBreakDown.add(this.okTestSummary);
		resultBreakDown.add(this.errorTestSummary);
		this.okTestSummary.setIcon(ReportTreeCellRenderer.getSuccessIcon(16, 16));
		this.errorTestSummary.setIcon(ReportTreeCellRenderer.getErrorIcon(16, 16));
		this.add(resultBreakDown, BorderLayout.EAST);
	}

	public void addReports(Map<OPPLTestCase, List<Report>> reports) {
		this.reports.putAll(reports);
		this.refresh();
	}

	private void refresh() {
		int count = 0;
		int okCount = 0;
		int errorCount = 0;
		for (OPPLTestCase testCase : this.reports.keySet()) {
			List<Report> testCaseReports = this.reports.get(testCase);
			if (testCaseReports != null) {
				count++;
				for (Report report : testCaseReports) {
					boolean isSuccesful = report.accept(new ReportVisitorEx<Boolean>() {
						public Boolean visitSuccessfulExecutionReport(
								SuccessfulExecutionReport successfulExecutionReport) {
							return true;
						}

						public Boolean visitAssertionFailedExecutionReport(
								AssertionFailedExecutionReport assertionFailedExecutionReport) {
							return false;
						}

						public Boolean visitConfigurationFailedExecutionReport(
								ConfigurationFailedExecutionReport configurationFailedExecutionReport) {
							return false;
						}

						public Boolean visitRuntimeErrorEncounteredExecutionReport(
								RuntimeErrorEncounteredExecutionReport runtimeErrorEncounteredExecutionReport) {
							return false;
						}

						public Boolean visitUnexecutedTestReport(
								UnexecutedTestReport unexecutedTestReport) {
							return false;
						}
					});
					if (isSuccesful) {
						okCount++;
					} else {
						errorCount++;
					}
				}
			}
		}
		this.runTestSummary.setText(String.format(
				"Run %d of %d",
				count,
				this.reports.keySet().size()));
		this.okTestSummary.setText(String.format("Succesful %d", okCount));
		this.errorTestSummary.setText(String.format("Failures %d", errorCount));
	}

	public void clear() {
		this.reports.clear();
		this.refresh();
	}
}
