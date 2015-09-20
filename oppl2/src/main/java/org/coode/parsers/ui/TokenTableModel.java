package org.coode.parsers.ui;

import static org.coode.oppl.utils.ArgCheck.checkNotNull;

import java.io.File;
import java.util.*;

import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import org.antlr.runtime.Token;
import org.coode.parsers.utils.TokenFileSorter;

/**
 * @author Luigi Iannone
 */
public class TokenTableModel implements TableModel {

    /**
     * 
     */
    public static final String TOKEN_NAME = "TOKEN NAME";
    private final Set<TokenFileSorter> tokenFileSorters = new HashSet<>();
    private final List<String> anomalies = new ArrayList<>();
    private final DefaultTableModel delegate;
    private int maxUsedTokenIndex = 0;

    /**
     * @param tokenFileSorters
     *        tokenFileSorters
     */
    public TokenTableModel(Collection<? extends TokenFileSorter> tokenFileSorters) {
        this.tokenFileSorters.addAll(checkNotNull(tokenFileSorters, "tokenFileSorters"));
        delegate = new DefaultTableModel();
        Set<String> tokenNames = new TreeSet<>();
        for (TokenFileSorter tokenFileSorter : tokenFileSorters) {
            for (Token token : tokenFileSorter.getTokens()) {
                tokenNames.add(token.getText());
            }
        }
        delegate.addColumn(TokenTableModel.TOKEN_NAME);
        List<TokenFileSorter> sorterList = new ArrayList<>(
            tokenFileSorters);
        for (TokenFileSorter tokenFileSorter : sorterList) {
            delegate.addColumn(tokenFileSorter.getPath().substring(
                tokenFileSorter.getPath().lastIndexOf(File.separatorChar) + 1));
        }
        for (String string : tokenNames) {
            delegate.addRow(getRow(string, sorterList));
        }
    }

    private String[] getRow(String tokenName, List<TokenFileSorter> sorters) {
        List<String> row = new ArrayList<>();
        row.add(tokenName);
        for (TokenFileSorter tokenFileSorter : sorters) {
            Iterator<Token> iterator = tokenFileSorter.getTokens().iterator();
            boolean found = false;
            while (!found && iterator.hasNext()) {
                Token token = iterator.next();
                found = token.getText().compareTo(tokenName) == 0;
                if (found) {
                    maxUsedTokenIndex = Math.max(maxUsedTokenIndex, token.getType());
                    row.add(Integer.toString(token.getType()));
                }
            }
            if (!found) {
                row.add("-");
            }
        }
        // If there's more than one value in the row (excluding the token name
        // this is anomalous
        Set<String> distinctValues = new HashSet<>(row);
        distinctValues.remove("-");
        if (distinctValues.size() > 2) {
            anomalies.add(tokenName);
        }
        return row.toArray(new String[row.size()]);
    }

    @Override
    public void addTableModelListener(TableModelListener l) {
        delegate.addTableModelListener(l);
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return delegate.getColumnClass(columnIndex);
    }

    @Override
    public int getColumnCount() {
        return delegate.getColumnCount();
    }

    @Override
    public String getColumnName(int columnIndex) {
        return delegate.getColumnName(columnIndex);
    }

    @Override
    public int getRowCount() {
        return delegate.getRowCount();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return delegate.getValueAt(rowIndex, columnIndex);
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public void removeTableModelListener(TableModelListener l) {
        delegate.removeTableModelListener(l);
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        delegate.setValueAt(aValue, rowIndex, columnIndex);
    }

    /**
     * @return the anomalies
     */
    public List<String> getAnomalies() {
        return new ArrayList<>(anomalies);
    }

    /**
     * @return the maxUsedTokenIndex
     */
    public int getMaxUsedTokenIndex() {
        return maxUsedTokenIndex;
    }

    /**
     * @return min index
     */
    public int getMinUnusedTokenIndex() {
        List<Integer> unused = new ArrayList<>();
        for (int i = 4; i < getMaxUsedTokenIndex(); i++) {
            Iterator<TokenFileSorter> iterator = tokenFileSorters.iterator();
            boolean found = false;
            while (!found && iterator.hasNext()) {
                TokenFileSorter tokenFileSorter = iterator.next();
                Iterator<Token> tokensIterator = tokenFileSorter.getTokens().iterator();
                while (!found && tokensIterator.hasNext()) {
                    Token token = tokensIterator.next();
                    found = token.getType() == i;
                }
            }
            if (!found) {
                unused.add(new Integer(i));
            }
        }
        Collections.sort(unused);
        return unused.get(0);
    }
}
