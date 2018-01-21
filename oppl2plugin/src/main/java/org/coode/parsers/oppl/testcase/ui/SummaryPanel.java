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
 */
public class SummaryPanel extends JPanel {

    private static final long serialVersionUID = 20100L;
    private final JLabel runTestSummary = new JLabel();
    private final JLabel okTestSummary = new JLabel();
    private final JLabel errorTestSummary = new JLabel();
    private final Map<OPPLTestCase, List<Report>> reports = new HashMap<>();

    /** default constructor */
    public SummaryPanel() {
        initGUI();
        refresh();
    }

    private void initGUI() {
        setLayout(new BorderLayout());
        this.add(runTestSummary, BorderLayout.WEST);
        JPanel resultBreakDown = new JPanel();
        resultBreakDown.add(okTestSummary);
        resultBreakDown.add(errorTestSummary);
        okTestSummary.setIcon(ReportTreeCellRenderer.getSuccessIcon(16, 16));
        errorTestSummary.setIcon(ReportTreeCellRenderer.getErrorIcon(16, 16));
        this.add(resultBreakDown, BorderLayout.EAST);
    }

    /**
     * @param reportList reportList
     */
    public void addReports(Map<OPPLTestCase, List<Report>> reportList) {
        reports.putAll(reportList);
        refresh();
    }

    private void refresh() {
        int count = 0;
        int okCount = 0;
        int errorCount = 0;
        for (OPPLTestCase testCase : reports.keySet()) {
            List<Report> testCaseReports = reports.get(testCase);
            if (testCaseReports != null) {
                count++;
                for (Report report : testCaseReports) {
                    boolean isSuccesful = report.accept(new ReportVisitorEx<Boolean>() {

                        @Override
                        public Boolean visitSuccessfulExecutionReport(
                            SuccessfulExecutionReport successfulExecutionReport) {
                            return Boolean.TRUE;
                        }

                        @Override
                        public Boolean visitAssertionFailedExecutionReport(
                            AssertionFailedExecutionReport assertionFailedExecutionReport) {
                            return Boolean.FALSE;
                        }

                        @Override
                        public Boolean visitConfigurationFailedExecutionReport(
                            ConfigurationFailedExecutionReport configurationFailedExecutionReport) {
                            return Boolean.FALSE;
                        }

                        @Override
                        public Boolean visitRuntimeErrorEncounteredExecutionReport(
                            RuntimeErrorEncounteredExecutionReport runtimeErrorEncounteredExecutionReport) {
                            return Boolean.FALSE;
                        }

                        @Override
                        public Boolean visitUnexecutedTestReport(
                            UnexecutedTestReport unexecutedTestReport) {
                            return Boolean.FALSE;
                        }
                    }).booleanValue();
                    if (isSuccesful) {
                        okCount++;
                    } else {
                        errorCount++;
                    }
                }
            }
        }
        runTestSummary.setText(String.format("Run %d of %d", Integer.valueOf(count),
            Integer.valueOf(reports.keySet().size())));
        okTestSummary.setText(String.format("Succesful %d", Integer.valueOf(okCount)));
        errorTestSummary.setText(String.format("Failures %d", Integer.valueOf(errorCount)));
    }

    /** clear reports */
    public void clear() {
        reports.clear();
        refresh();
    }
}
