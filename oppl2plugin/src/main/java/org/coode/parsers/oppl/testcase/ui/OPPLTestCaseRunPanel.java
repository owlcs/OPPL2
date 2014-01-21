package org.coode.parsers.oppl.testcase.ui;

import java.awt.BorderLayout;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.SwingWorker;
import javax.swing.event.TreeModelEvent;
import javax.swing.event.TreeModelListener;
import javax.swing.tree.TreePath;

import org.coode.parsers.oppl.testcase.OPPLTestCase;
import org.coode.parsers.oppl.testcase.ui.report.Report;
import org.protege.editor.core.ProtegeApplication;
import org.protege.editor.core.ui.util.ComponentFactory;

/** @author Luigi Iannone */
public class OPPLTestCaseRunPanel extends JPanel {
    private final class RunTest extends
            SwingWorker<Map<OPPLTestCase, List<Report>>, Object> {
        private final OPPLTestCase opplTestCase;

        /** @param opplTestCase
         *            opplTestCase */
        public RunTest(OPPLTestCase opplTestCase) {
            this.opplTestCase = opplTestCase;
        }

        @Override
        protected Map<OPPLTestCase, List<Report>> doInBackground() throws Exception {
            ReportingTestRunner reportingTestRunner = new ReportingTestRunner(
                    opplTestCase);
            return reportingTestRunner.run();
        }

        @Override
        protected void done() {
            try {
                Map<OPPLTestCase, List<Report>> reports = this.get();
                if (reports != null) {
                    resultTreeModel.addReports(reports);
                    summaryPanel.addReports(reports);
                }
            } catch (InterruptedException e) {
                ProtegeApplication.getErrorLog().logError(e);
            } catch (ExecutionException e) {
                ProtegeApplication.getErrorLog().logError(e);
            }
        }
    }

    private static final long serialVersionUID = 20100L;
    protected final ReportTreeModel resultTreeModel = new ReportTreeModel();
    protected final JTree resultTree = new JTree(resultTreeModel);
    protected final SummaryPanel summaryPanel = new SummaryPanel();
    private final TreeModelListener treeModelLister = new TreeModelListener() {
        @Override
        public void treeStructureChanged(TreeModelEvent e) {
            expandUnsucessfulNodes();
        }

        @Override
        public void treeNodesRemoved(TreeModelEvent e) {
            expandUnsucessfulNodes();
        }

        @Override
        public void treeNodesInserted(TreeModelEvent e) {
            expandUnsucessfulNodes();
        }

        @Override
        public void treeNodesChanged(TreeModelEvent e) {
            expandUnsucessfulNodes();
        }

        private void expandUnsucessfulNodes() {
            TreePath[] unsuccessfulTreePaths = resultTreeModel.getUnsuccessfulTreePaths();
            for (TreePath treePath : unsuccessfulTreePaths) {
                resultTree.expandPath(treePath);
            }
        }
    };

    /** init gui */
    public OPPLTestCaseRunPanel() {
        initGUI();
    }

    private void initGUI() {
        setLayout(new BorderLayout());
        JScrollPane resultTreeScrollPane = ComponentFactory.createScrollPane(resultTree);
        resultTreeScrollPane.setBorder(ComponentFactory
                .createTitledBorder("Test cases results"));
        resultTree.setCellRenderer(new ReportTreeCellRenderer());
        resultTreeModel.addTreeModelListener(treeModelLister);
        this.add(summaryPanel, BorderLayout.NORTH);
        this.add(resultTreeScrollPane, BorderLayout.CENTER);
    }

    /** @param testCases
     *            testCases */
    public void runTests(Collection<? extends OPPLTestCase> testCases) {
        resultTreeModel.clear();
        summaryPanel.clear();
        Map<OPPLTestCase, List<Report>> emptyReports = new HashMap<OPPLTestCase, List<Report>>();
        for (OPPLTestCase opplTestCase : testCases) {
            emptyReports.put(opplTestCase, null);
        }
        summaryPanel.addReports(emptyReports);
        for (OPPLTestCase opplTestCase : testCases) {
            RunTest runTest = new RunTest(opplTestCase);
            runTest.execute();
        }
    }
}
