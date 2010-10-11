package org.coode.parsers.ui;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import org.antlr.runtime.Token;
import org.coode.parsers.utils.TokenFileSorter;

public class TokenTableModel implements TableModel {
	public static final String TOKEN_NAME = "TOKEN NAME";
	private final Set<TokenFileSorter> tokenFileSorters = new HashSet<TokenFileSorter>();
	private final List<String> anomalies = new ArrayList<String>();
	private final DefaultTableModel delegate;
	private int maxUsedTokenIndex = 0;

	public TokenTableModel(
			Collection<? extends TokenFileSorter> tokenFileSorters) {
		if (tokenFileSorters == null) {
			throw new NullPointerException(
					"The token file sorter colleciton cannot be null");
		}
		this.tokenFileSorters.addAll(tokenFileSorters);
		this.delegate = new DefaultTableModel();
		Set<String> tokenNames = new TreeSet<String>();
		for (TokenFileSorter tokenFileSorter : tokenFileSorters) {
			for (Token token : tokenFileSorter.getTokens()) {
				tokenNames.add(token.getText());
			}
		}
		this.delegate.addColumn(TokenTableModel.TOKEN_NAME);
		List<TokenFileSorter> sorterList = new ArrayList<TokenFileSorter>(
				tokenFileSorters);
		for (TokenFileSorter tokenFileSorter : sorterList) {
			this.delegate.addColumn(tokenFileSorter.getPath()
					.substring(
							tokenFileSorter.getPath().lastIndexOf(
									File.separatorChar) + 1));
		}
		for (String string : tokenNames) {
			this.delegate.addRow(this.getRow(string, sorterList));
		}
	}

	private String[] getRow(String tokenName,
			List<TokenFileSorter> tokenFileSorters) {
		List<String> row = new ArrayList<String>();
		row.add(tokenName);
		for (TokenFileSorter tokenFileSorter : tokenFileSorters) {
			Iterator<Token> iterator = tokenFileSorter.getTokens().iterator();
			boolean found = false;
			while (!found && iterator.hasNext()) {
				Token token = iterator.next();
				found = token.getText().compareTo(tokenName) == 0;
				if (found) {
					this.maxUsedTokenIndex = Math.max(this.maxUsedTokenIndex,
							token.getType());
					row.add(Integer.toString(token.getType()));
				}
			}
			if (!found) {
				row.add("-");
			}
		}
		// If there's more than one value in the row (excluding the token name
		// this is anomalous
		Set<String> distinctValues = new HashSet<String>(row);
		distinctValues.remove("-");
		if (distinctValues.size() > 2) {
			this.anomalies.add(tokenName);
		}
		return row.toArray(new String[row.size()]);
	}

	public void addTableModelListener(TableModelListener l) {
		this.delegate.addTableModelListener(l);
	}

	public Class<?> getColumnClass(int columnIndex) {
		return this.delegate.getColumnClass(columnIndex);
	}

	public int getColumnCount() {
		return this.delegate.getColumnCount();
	}

	public String getColumnName(int columnIndex) {
		return this.delegate.getColumnName(columnIndex);
	}

	public int getRowCount() {
		return this.delegate.getRowCount();
	}

	public Object getValueAt(int rowIndex, int columnIndex) {
		return this.delegate.getValueAt(rowIndex, columnIndex);
	}

	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return false;
	}

	public void removeTableModelListener(TableModelListener l) {
		this.delegate.removeTableModelListener(l);
	}

	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		this.delegate.setValueAt(aValue, rowIndex, columnIndex);
	}

	/**
	 * @return the anomalies
	 */
	public List<String> getAnomalies() {
		return new ArrayList<String>(this.anomalies);
	}

	/**
	 * @return the maxUsedTokenIndex
	 */
	public int getMaxUsedTokenIndex() {
		return this.maxUsedTokenIndex;
	}

	public int getMinUnusedTokenIndex() {
		List<Integer> unused = new ArrayList<Integer>();
		for (int i = 4; i < this.getMaxUsedTokenIndex(); i++) {
			Iterator<TokenFileSorter> iterator = this.tokenFileSorters
					.iterator();
			boolean found = false;
			while (!found && iterator.hasNext()) {
				TokenFileSorter tokenFileSorter = iterator.next();
				Iterator<Token> tokensIterator = tokenFileSorter.getTokens()
						.iterator();
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
