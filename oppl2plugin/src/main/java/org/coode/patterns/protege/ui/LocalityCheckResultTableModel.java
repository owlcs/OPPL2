package org.coode.patterns.protege.ui;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import org.coode.oppl.Variable;
import org.coode.oppl.bindingtree.BindingNode;
import org.coode.oppl.function.SimpleValueComputationParameters;
import org.coode.oppl.function.ValueComputationParameters;
import org.coode.oppl.variabletypes.InputVariable;
import org.coode.patterns.locality.LocalityChecker;
import org.semanticweb.owlapi.model.OWLEntity;

/** table model for locality checker */
public class LocalityCheckResultTableModel implements TableModel {
    private static enum values {
        PRESENT("X", 'X'), ABSENT(" ", ' ');
        private char v;
        private String val;

        values(String val, char v) {
            this.val = val;
            this.v = v;
        }

        public String value() {
            return val;
        }

        public static String getValue(char v) {
            if (v == PRESENT.v) {
                return PRESENT.val;
            }
            if (v == ABSENT.v) {
                return ABSENT.val;
            }
            throw new RuntimeException("Unknown value: " + v);
        }
    }

    private final String[][] dataArray;
    private final List<TableModelListener> listeners = new ArrayList<TableModelListener>();

    /** @return data array */
    public String[][] getDataArray() {
        return dataArray;
    }

    /** @param checker
     *            checker */
    public LocalityCheckResultTableModel(LocalityChecker checker) {
        List<InputVariable<?>> toAssign = new ArrayList<InputVariable<?>>(checker
                .getInstantiatedPatternModel().getInputVariables());
        List<Boolean> bindingsLocality = checker.getExploredNodesLocality();
        List<BindingNode> bindings = checker.getExploredNodes();
        dataArray = new String[bindings.size() + 1][toAssign.size() + 1];
        dataArray[0][0] = "Safe";
        for (int i = 0; i < toAssign.size(); i++) {
            dataArray[0][i + 1] = toAssign.get(i).getName();
        }
        Set<OWLEntity> sigmaMinus = checker.getEntities();
        sigmaMinus.addAll(checker.getSigmaPlus());
        if (bindings.size() == bindingsLocality.size()) {
            for (int i = 0; i < bindings.size(); i++) {
                setValueAt(bindingsLocality.get(i), i, 0);
                BindingNode node = bindings.get(i);
                ValueComputationParameters parameters = new SimpleValueComputationParameters(
                        checker.getInstantiatedPatternModel().getConstraintSystem(),
                        node, checker.getHandler());
                for (int j = 0; j < toAssign.size(); j++) {
                    Variable<?> v = toAssign.get(j);
                    if (sigmaMinus.contains(node.getAssignmentValue(v, parameters))) {
                        setValueAt(values.PRESENT.value(), i, j + 1);
                    } else {
                        setValueAt(values.ABSENT.value(), i, j + 1);
                    }
                }
            }
            sort();
        }
    }

    private void sort() {
        List<String> trues = new ArrayList<String>();
        List<String> falses = new ArrayList<String>();
        for (int i = 1; i < dataArray.length; i++) {
            StringBuilder b = new StringBuilder();
            for (int j = 1; j < dataArray[i].length; j++) {
                b.append(dataArray[i][j]);
            }
            String record = b.toString();
            if (Boolean.parseBoolean(dataArray[i][0])) {
                trues.add(record);
            } else {
                falses.add(record);
            }
        }
        Collections.sort(trues);
        Collections.sort(falses);
        for (int i = 0; i < trues.size(); i++) {
            String s = trues.get(i);
            dataArray[i + 1][0] = Boolean.TRUE.toString();
            for (int j = 1; j < dataArray[i + 1].length; j++) {
                dataArray[i + 1][j] = values.getValue(s.charAt(j - 1));
            }
        }
        for (int i = 0; i < falses.size(); i++) {
            String s = falses.get(i);
            dataArray[i + 1 + trues.size()][0] = Boolean.FALSE.toString();
            for (int j = 1; j < dataArray[i + 1 + trues.size()].length; j++) {
                dataArray[i + 1 + trues.size()][j] = values.getValue(s.charAt(j - 1));
            }
        }
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        dataArray[rowIndex + 1][columnIndex] = aValue.toString();
    }

    @Override
    public void removeTableModelListener(TableModelListener l) {
        listeners.remove(l);
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return dataArray[rowIndex + 1][columnIndex];
    }

    @Override
    public int getRowCount() {
        return dataArray.length - 1;
    }

    @Override
    public String getColumnName(int columnIndex) {
        return dataArray[0][columnIndex];
    }

    @Override
    public int getColumnCount() {
        return dataArray[0].length;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return String.class;
    }

    @Override
    public void addTableModelListener(TableModelListener l) {
        listeners.add(l);
    }
}
