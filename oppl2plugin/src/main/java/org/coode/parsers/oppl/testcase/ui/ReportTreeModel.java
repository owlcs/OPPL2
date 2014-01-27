package org.coode.parsers.oppl.testcase.ui;

import static org.coode.oppl.utils.ArgCheck.checkNotNull;

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

/** @author Luigi Iannone */
public final class ReportTreeModel implements TreeModel {
    private static final String TEST_CASES_EXECUTED = "Test Cases executed";
    private static final String DEFAULT_ROOT = "No Test Case";
    private final Map<OPPLTestCase, List<Report>> reportMap = new HashMap<OPPLTestCase, List<Report>>();
    private String root = DEFAULT_ROOT;
    private final Set<TreeModelListener> listeners = new HashSet<TreeModelListener>();
    private final static Comparator<OPPLTestCase> LEXICOGRAPHIC_COMPARATOR = new Comparator<OPPLTestCase>() {
        @Override
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

    @Override
    public Object getRoot() {
        return root;
    }

    @Override
    public Object getChild(Object parent, int index) {
        Object toReturn = null;
        if (parent == getRoot()) {
            List<OPPLTestCase> list = new ArrayList<OPPLTestCase>(reportMap.keySet());
            Collections.sort(list, LEXICOGRAPHIC_COMPARATOR);
            if (index >= 0 && index < list.size()) {
                toReturn = list.get(index);
            }
        } else {
            // It must then be an OPPLTestCase as reports are leaves
            List<Report> list = reportMap.get(parent);
            if (list != null && index >= 0 && index < list.size()) {
                toReturn = list.get(index);
            }
        }
        return toReturn;
    }

    @Override
    public int getChildCount(Object parent) {
        int toReturn = 0;
        if (parent == getRoot()) {
            toReturn = reportMap.keySet().size();
        } else {
            // It must then be an OPPLTestCase as reports are leaves
            List<Report> list = reportMap.get(parent);
            toReturn = list.size();
        }
        return toReturn;
    }

    @Override
    public boolean isLeaf(Object node) {
        return node == getRoot() && reportMap.isEmpty()
                || Report.class.isAssignableFrom(node.getClass());
    }

    @Override
    public void valueForPathChanged(TreePath path, Object newValue) {
        // Do nothing
    }

    @Override
    public int getIndexOfChild(Object parent, Object child) {
        int toReturn = -1;
        if (parent == getRoot()) {
            List<OPPLTestCase> list = new ArrayList<OPPLTestCase>(reportMap.keySet());
            Collections.sort(list, LEXICOGRAPHIC_COMPARATOR);
            toReturn = list.indexOf(child);
        } else {
            // It must then be an OPPLTestCase as reports are leaves
            List<Report> list = reportMap.get(parent);
            toReturn = list.indexOf(child);
        }
        return toReturn;
    }

    @Override
    public void addTreeModelListener(TreeModelListener l) {
        if (l != null) {
            listeners.add(l);
        }
    }

    @Override
    public void removeTreeModelListener(TreeModelListener l) {
        listeners.remove(l);
    }

    private void notifyListeners() {
        for (TreeModelListener l : listeners) {
            l.treeStructureChanged(new TreeModelEvent(this, new Object[] { getRoot() }));
        }
    }

    /** clear report map */
    public void clear() {
        root = DEFAULT_ROOT;
        reportMap.clear();
        notifyListeners();
    }

    /** @param reports
     *            reports */
    public void addReports(Map<OPPLTestCase, List<Report>> reports) {
        if (reportMap.isEmpty()) {
            root = ReportTreeModel.TEST_CASES_EXECUTED;
        }
        reportMap.putAll(reports);
        notifyListeners();
    }

    /** Determines whether all the OPPLTestCases in this model have run
     * successfully. Please notice that an empty OPPLTestCase set is also
     * considered a successful one.
     * 
     * @return {@code true} if all the OPPLTestCase instances in this have
     *         successful reports or there's not OPPLTestCase reports in this. */
    public boolean isSuccessful() {
        boolean toReturn = reportMap.isEmpty();
        if (!toReturn) {
            Iterator<List<Report>> iterator = reportMap.values().iterator();
            boolean found = false;
            while (!found && iterator.hasNext()) {
                List<Report> list = iterator.next();
                Iterator<Report> listIterator = list.iterator();
                while (!found && listIterator.hasNext()) {
                    Report report = listIterator.next();
                    found = isUnsuccessful(report);
                }
            }
            toReturn = !found;
        }
        return toReturn;
    }

    /** Determines whether the input OPPLTestCase in this model has run
     * successfully.
     * 
     * @param opplTestCase
     *            The input OPPLTestCase. Cannot be {@code null} and must be in
     *            those contained into this model.
     * @return {@code true} if all the reports related to the input OPPLTestCase
     *         are successful.
     * @throws NullPointerException
     *             if the input OPPLTestCase is {@code null}.
     * @throws IllegalArgumentException
     *             if the input OPPLTestCase is not contained into the reports
     *             in this model. */
    public boolean isSuccessful(OPPLTestCase opplTestCase) {
        if (!reportMap.keySet().contains(opplTestCase)) {
            throw new IllegalArgumentException(
                    "The OPPL Test case is not contained into the reports in this model");
        }
        List<Report> reports = reportMap.get(checkNotNull(opplTestCase, "opplTestCase"));
        Iterator<Report> iterator = reports.iterator();
        boolean found = false;
        while (!found && iterator.hasNext()) {
            Report report = iterator.next();
            found = isUnsuccessful(report);
        }
        return !found;
    }

    /** @param report
     *            report
     * @return true if unsuccesful */
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

    /** Retrieves all the paths leading to unsuccessful reports. If all the
     * OPPLTestCases in this are successful an empty array will be returned.
     * 
     * @return a possibly empty TreePath[] */
    public TreePath[] getUnsuccessfulTreePaths() {
        Set<TreePath> toReturn = new HashSet<TreePath>();
        for (List<Report> reportList : reportMap.values()) {
            for (Report report : reportList) {
                if (isUnsuccessful(report)) {
                    toReturn.add(new TreePath(new Object[] { getRoot(),
                            report.getOPPLTestCase() }));
                }
            }
        }
        return toReturn.toArray(new TreePath[toReturn.size()]);
    }
}
