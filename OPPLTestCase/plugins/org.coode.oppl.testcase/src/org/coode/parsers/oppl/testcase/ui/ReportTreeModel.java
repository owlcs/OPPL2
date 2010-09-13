/**
 * 
 */
package org.coode.parsers.oppl.testcase.ui;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.swing.event.TreeModelEvent;
import javax.swing.event.TreeModelListener;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;

import org.coode.parsers.oppl.testcase.OPPLTestCase;
import org.coode.parsers.oppl.testcase.ui.report.DefaultReportVisitorExAdapter;
import org.coode.parsers.oppl.testcase.ui.report.Report;
import org.coode.parsers.oppl.testcase.ui.report.SuccessfulExecutionReport;

/**
 * @author Luigi Iannone
 * 
 */
public final class ReportTreeModel implements TreeModel {
	private static final String TEST_CASES_EXECUTED = "Test Cases executed";
	private static final String DEFAULT_ROOT = "No Test Case";
	private final Map<OPPLTestCase, List<Report>> reportMap = new HashMap<OPPLTestCase, List<Report>>();
	private String root = DEFAULT_ROOT;
	private final Set<TreeModelListener> listeners = new HashSet<TreeModelListener>();
	private final static Comparator<OPPLTestCase> LEXICOGRAPHIC_COMPARATOR = new Comparator<OPPLTestCase>() {
		public int compare(OPPLTestCase o1, OPPLTestCase o2) {
			int toReturn = 0;
			if (o1 == null) {
				toReturn = -1;
			} else if (o2 == null) {
				toReturn = 1;
			} else {
				toReturn = o1.getName().compareTo(o2.getName());
			}
			return toReturn;
		}
	};

	/**
	 * 
	 * @see javax.swing.tree.TreeModel#getRoot()
	 */
	public Object getRoot() {
		return this.root;
	}

	/**
	 * @see javax.swing.tree.TreeModel#getChild(java.lang.Object, int)
	 */
	public Object getChild(Object parent, int index) {
		Object toReturn = null;
		if (parent == this.getRoot()) {
			List<OPPLTestCase> list = new ArrayList<OPPLTestCase>(
					this.reportMap.keySet());
			Collections.sort(list, LEXICOGRAPHIC_COMPARATOR);
			if (index >= 0 && index < list.size()) {
				toReturn = list.get(index);
			}
		} else {
			// It must then be an OPPLTestCase as reports are leaves
			List<Report> list = this.reportMap.get(parent);
			if (list != null && index >= 0 && index < list.size()) {
				toReturn = list.get(index);
			}
		}
		return toReturn;
	}

	/**
	 * @see javax.swing.tree.TreeModel#getChildCount(java.lang.Object)
	 */
	public int getChildCount(Object parent) {
		int toReturn = 0;
		if (parent == this.getRoot()) {
			toReturn = this.reportMap.keySet().size();
		} else {
			// It must then be an OPPLTestCase as reports are leaves
			List<Report> list = this.reportMap.get(parent);
			toReturn = list.size();
		}
		return toReturn;
	}

	/**
	 * @see javax.swing.tree.TreeModel#isLeaf(java.lang.Object)
	 */
	public boolean isLeaf(Object node) {
		return node == this.getRoot() && this.reportMap.isEmpty()
				|| Report.class.isAssignableFrom(node.getClass());
	}

	/**
	 * @see javax.swing.tree.TreeModel#valueForPathChanged(javax.swing.tree.TreePath,
	 *      java.lang.Object)
	 */
	public void valueForPathChanged(TreePath path, Object newValue) {
		// Do nothing
	}

	/**
	 * @see javax.swing.tree.TreeModel#getIndexOfChild(java.lang.Object,
	 *      java.lang.Object)
	 */
	public int getIndexOfChild(Object parent, Object child) {
		int toReturn = -1;
		if (parent == this.getRoot()) {
			List<OPPLTestCase> list = new ArrayList<OPPLTestCase>(
					this.reportMap.keySet());
			Collections.sort(list, LEXICOGRAPHIC_COMPARATOR);
			toReturn = list.indexOf(child);
		} else {
			// It must then be an OPPLTestCase as reports are leaves
			List<Report> list = this.reportMap.get(parent);
			toReturn = list.indexOf(child);
		}
		return toReturn;
	}

	/**
	 * @see javax.swing.tree.TreeModel#addTreeModelListener(javax.swing.event.
	 *      TreeModelListener)
	 */
	public void addTreeModelListener(TreeModelListener l) {
		if (l != null) {
			this.listeners.add(l);
		}
	}

	/**
	 * 
	 * @see javax.swing.tree.TreeModel#removeTreeModelListener(javax.swing.event.
	 *      TreeModelListener)
	 */
	public void removeTreeModelListener(TreeModelListener l) {
		this.listeners.remove(l);
	}

	private void notifyListeners() {
		for (TreeModelListener l : this.listeners) {
			l.treeStructureChanged(new TreeModelEvent(this, new Object[] { this
					.getRoot() }));
		}
	}

	public void clear() {
		this.root = DEFAULT_ROOT;
		this.reportMap.clear();
		this.notifyListeners();
	}

	public void addReports(Map<OPPLTestCase, List<Report>> reports) {
		if (this.reportMap.isEmpty()) {
			this.root = ReportTreeModel.TEST_CASES_EXECUTED;
		}
		this.reportMap.putAll(reports);
		this.notifyListeners();
	}

	/**
	 * Determines whether all the OPPLTestCases in this model have run
	 * successfully. Please notice that an empty OPPLTestCase set is also
	 * considered a successful one.
	 * 
	 * @return <code>true</code> if all the OPPLTestCase instances in this have
	 *         successful reports or there's not OPPLTestCase reports in this.
	 */
	public boolean isSuccessful() {
		boolean toReturn = this.reportMap.isEmpty();
		if (!toReturn) {
			Iterator<List<Report>> iterator = this.reportMap.values()
					.iterator();
			boolean found = false;
			while (!found && iterator.hasNext()) {
				List<Report> list = iterator.next();
				Iterator<Report> listIterator = list.iterator();
				while (!found && listIterator.hasNext()) {
					Report report = listIterator.next();
					found = this.isUnsuccessful(report);
				}
			}
			toReturn = !found;
		}
		return toReturn;
	}

	/**
	 * Determines whether the input OPPLTestCase in this model has run
	 * successfully.
	 * 
	 * @param opplTestCase
	 *            The input OPPLTestCase. Cannot be <code>null</code> and must
	 *            be in those contained into this model.
	 * @return <code>true</code> if all the reports related to the input
	 *         OPPLTestCase are successful.
	 * @throws NullPointerException
	 *             if the input OPPLTestCase is <code>null</code>.
	 * @throws IllegalArgumentException
	 *             if the input OPPLTestCase is not contained into the reports
	 *             in this model.
	 */
	public boolean isSuccessful(OPPLTestCase opplTestCase) {
		if (opplTestCase == null) {
			throw new NullPointerException(
					"The input OPPLTestCase cannot be null");
		}
		if (!this.reportMap.keySet().contains(opplTestCase)) {
			throw new IllegalArgumentException(
					"The OPPL Test case is not contained into the reports in this model");
		}
		List<Report> reports = this.reportMap.get(opplTestCase);
		Iterator<Report> iterator = reports.iterator();
		boolean found = false;
		while (!found && iterator.hasNext()) {
			Report report = iterator.next();
			found = this.isUnsuccessful(report);
		}
		return !found;
	}

	/**
	 * @param report
	 * @return
	 */
	public boolean isUnsuccessful(Report report) {
		boolean found;
		found = report.accept(new DefaultReportVisitorExAdapter<Boolean>(true) {
			@Override
			public Boolean visitSuccessfulExecutionReport(
					SuccessfulExecutionReport successfulExecutionReport) {
				return false;
			}
		});
		return found;
	}

	/**
	 * Retrieves all the paths leading to unsuccessful reports. If all the
	 * OPPLTestCases in this are successful an empty array will be returned.
	 * 
	 * @return a possibly empty TreePath[]
	 */
	public TreePath[] getUnsuccessfulTreePaths() {
		Set<TreePath> toReturn = new HashSet<TreePath>();
		for (List<Report> reportList : this.reportMap.values()) {
			for (Report report : reportList) {
				if (this.isUnsuccessful(report)) {
					toReturn.add(new TreePath(new Object[] { this.getRoot(),
							report.getOPPLTestCase(), report }));
				}
			}
		}
		return toReturn.toArray(new TreePath[toReturn.size()]);
	}
}
