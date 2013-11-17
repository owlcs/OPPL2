/**
 * 
 */
package org.coode.oppl.protege.ui;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import org.coode.oppl.OPPLScript;
import org.coode.oppl.Variable;
import org.coode.oppl.bindingtree.BindingNode;
import org.coode.oppl.exceptions.RuntimeExceptionHandler;
import org.coode.oppl.function.SimpleValueComputationParameters;
import org.coode.oppl.function.ValueComputationParameters;
import org.protege.editor.owl.OWLEditorKit;
import org.semanticweb.owlapi.model.OWLObject;

/** @author Luigi Iannone */
public class InstantiationTableModel implements TableModel {
    private final class LeavesComparator implements Comparator<BindingNode> {
        @Override
        public int compare(BindingNode aBindingNode, BindingNode anotherBindingNode) {
            int toReturn = 0;
            Set<Variable<?>> assignedVariables = aBindingNode.getAssignedVariables();
            Iterator<Variable<?>> iterator = assignedVariables.iterator();
            ValueComputationParameters parameters = new SimpleValueComputationParameters(
                    opplScript.getConstraintSystem(), BindingNode.getEmptyBindingNode(),
                    getRuntimeExceptionHandler());
            while (toReturn == 0 && iterator.hasNext()) {
                Variable<?> variable = iterator.next();
                OWLObject aValue = aBindingNode.getAssignmentValue(variable, parameters);
                OWLObject anotherValue = anotherBindingNode.getAssignmentValue(variable,
                        parameters);
                toReturn = getOWLEditorKit()
                        .getModelManager()
                        .getRendering(aValue)
                        .compareTo(
                                getOWLEditorKit().getModelManager().getRendering(
                                        anotherValue));
            }
            return toReturn;
        }
    }

    private static final NoOPPLScriptTableModel NO_OPPL_SCRIPT_TABLE_MODEL = new NoOPPLScriptTableModel();
    private final Set<TableModelListener> listeners = new HashSet<TableModelListener>();
    private final List<BindingNode> leaves = new ArrayList<BindingNode>();
    private final RuntimeExceptionHandler runtimeExceptionHandler;
    private final OPPLScript opplScript;
    private final OWLEditorKit owlEditorKit;

    private static final class NoOPPLScriptTableModel implements TableModel {
        private NoOPPLScriptTableModel() {}

        @Override
        public void addTableModelListener(TableModelListener l) {}

        @Override
        public Class<?> getColumnClass(int columnIndex) {
            return null;
        }

        @Override
        public int getColumnCount() {
            return 1;
        }

        @Override
        public String getColumnName(int columnIndex) {
            return "Invalid Script";
        }

        @Override
        public int getRowCount() {
            return 0;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            return null;
        }

        @Override
        public boolean isCellEditable(int rowIndex, int columnIndex) {
            return false;
        }

        @Override
        public void removeTableModelListener(TableModelListener l) {}

        @Override
        public void setValueAt(Object aValue, int rowIndex, int columnIndex) {}
    }

    /** @param opplScript */
    public InstantiationTableModel(OPPLScript opplScript, OWLEditorKit owlEditorKit) {
        if (opplScript == null) {
            throw new NullPointerException("The OPPL Script cannot be null");
        }
        if (owlEditorKit == null) {
            throw new NullPointerException("The OWL Editor Kit cannot be null");
        }
        this.owlEditorKit = owlEditorKit;
        this.opplScript = opplScript;
        runtimeExceptionHandler = new ShowMessageRuntimeExceptionHandler(
                getOWLEditorKit().getOWLWorkspace());
        Set<BindingNode> scriptLeaves = getOPPLScript().getConstraintSystem().getLeaves();
        if (scriptLeaves != null) {
            leaves.addAll(scriptLeaves);
            Collections.sort(leaves, new LeavesComparator());
        }
    }

    @Override
    public void addTableModelListener(TableModelListener l) {
        if (l != null) {
            listeners.remove(l);
        }
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return OWLObject.class;
    }

    @Override
    public int getColumnCount() {
        return opplScript.getVariables().size();
    }

    @Override
    public String getColumnName(int columnIndex) {
        List<Variable<?>> sortedVariables = new ArrayList<Variable<?>>(getOPPLScript()
                .getVariables());
        Collections.sort(sortedVariables, new Comparator<Variable<?>>() {
            @Override
            public int compare(Variable<?> variable, Variable<?> anotherVariable) {
                return variable.getName().compareTo(anotherVariable.getName());
            }
        });
        return sortedVariables.get(columnIndex).getName();
    }

    @Override
    public int getRowCount() {
        return getLeaves().size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Object toReturn = null;
        BindingNode leaf = getLeaves().get(rowIndex);
        List<Variable<?>> sortedVariables = new ArrayList<Variable<?>>(getOPPLScript()
                .getVariables());
        Collections.sort(sortedVariables, new Comparator<Variable<?>>() {
            @Override
            public int compare(Variable<?> variable, Variable<?> anotherVariable) {
                return variable.getName().compareTo(anotherVariable.getName());
            }
        });
        ValueComputationParameters parameters = new SimpleValueComputationParameters(
                opplScript.getConstraintSystem(), leaf, getRuntimeExceptionHandler());
        Variable<?> variable = sortedVariables.get(columnIndex);
        toReturn = leaf.getAssignmentValue(variable, parameters);
        return toReturn;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public void removeTableModelListener(TableModelListener l) {
        listeners.remove(l);
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {}

    public List<BindingNode> getLeaves() {
        return new ArrayList<BindingNode>(leaves);
    }

    public OPPLScript getOPPLScript() {
        return opplScript;
    }

    public static TableModel getNoOPPLScriptTableModel() {
        return InstantiationTableModel.NO_OPPL_SCRIPT_TABLE_MODEL;
    }

    /** @return the owlEditorKit */
    public OWLEditorKit getOWLEditorKit() {
        return owlEditorKit;
    }

    /** @return the runtimeExceptionHandler */
    public RuntimeExceptionHandler getRuntimeExceptionHandler() {
        return runtimeExceptionHandler;
    }
}
