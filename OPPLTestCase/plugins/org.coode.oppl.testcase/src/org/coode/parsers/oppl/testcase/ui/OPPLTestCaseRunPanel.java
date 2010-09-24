/**
 * 
 */
package org.coode.parsers.oppl.testcase.ui;

import java.awt.BorderLayout;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.event.TreeModelEvent;
import javax.swing.event.TreeModelListener;
import javax.swing.tree.TreePath;

import org.coode.parsers.oppl.testcase.OPPLTestCase;
import org.coode.parsers.oppl.testcase.ui.report.Report;
import org.jdesktop.swingworker.SwingWorker;
import org.protege.editor.core.ProtegeApplication;
import org.protege.editor.core.ui.util.ComponentFactory;

/**
 * @author Luigi Iannone
 * 
 */
public class OPPLTestCaseRunPanel extends JPanel {
	private final class RunTest extends SwingWorker<Map<OPPLTestCase, List<Report>>, Object> {
		private final OPPLTestCase opplTestCase;

		/**
		 * @param opplTestCase
		 */
		public RunTest(OPPLTestCase opplTestCase) {
			this.opplTestCase = opplTestCase;
		}

		@Override
		protected Map<OPPLTestCase, List<Report>> doInBackground() throws Exception {
			ReportingTestRunner reportingTestRunner = new ReportingTestRunner(this.opplTestCase);
			return reportingTestRunner.run();
		}

		@Override
		protected void done() {
			try {
				Map<OPPLTestCase, List<Report>> reports = this.get();
				if (reports != null) {
					OPPLTestCaseRunPanel.this.resultTreeModel.addReports(reports);
				}
			} catch (InterruptedException e) {
				ProtegeApplication.getErrorLog().logError(e);
			} catch (ExecutionException e) {
				ProtegeApplication.getErrorLog().logError(e);
			}
		}
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -5802632215147728332L;
	private final ReportTreeModel resultTreeModel = new ReportTreeModel();
	private final JTree resultTree = new JTree(this.resultTreeModel);
	private TreeModelListener treeModelLister = new TreeModelListener() {
		public void treeStructureChanged(TreeModelEvent e) {
			this.expandUnsucessfulNodes();
		}

		public void treeNodesRemoved(TreeModelEvent e) {
			this.expandUnsucessfulNodes();
		}

		public void treeNodesInserted(TreeModelEvent e) {
			this.expandUnsucessfulNodes();
		}

		public void treeNodesChanged(TreeModelEvent e) {
			this.expandUnsucessfulNodes();
		}

		private void expandUnsucessfulNodes() {
			
			TreePath[] unsuccessfulTreePaths = OPPLTestCaseRunPanel.this.resultTreeModel.getUnsuccessfulTreePaths();
			for (TreePath treePath : unsuccessfulTreePaths) {
				OPPLTestCaseRunPanel.this.resultTree.expandPath(treePath);
			}
		}
	};

	public OPPLTestCaseRunPanel() {
		this.initGUI();
	}

	private void initGUI() {
		this.setLayout(new BorderLayout());
		JScrollPane resultTreeScrollPane = ComponentFactory.createScrollPane(this.resultTree);
		resultTreeScrollPane.setBorder(ComponentFactory.createTitledBorder("Test cases results"));
		this.resultTree.setCellRenderer(new ReportTreeCellRenderer());
		this.resultTreeModel.addTreeModelListener(this.treeModelLister);
		this.add(resultTreeScrollPane, BorderLayout.CENTER);
	}

	public void runTests(Collection<? extends OPPLTestCase> testCases) {
		this.resultTreeModel.clear();
		for (OPPLTestCase opplTestCase : testCases) {
			RunTest runTest = new RunTest(opplTestCase);
			runTest.execute();
		}
	}
}
