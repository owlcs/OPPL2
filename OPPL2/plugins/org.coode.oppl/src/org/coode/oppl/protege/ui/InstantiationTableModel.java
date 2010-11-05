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
import org.coode.oppl.function.SimpleValueComputationParameters;
import org.coode.oppl.function.ValueComputationParameters;
import org.protege.editor.owl.OWLEditorKit;
import org.semanticweb.owlapi.model.OWLObject;

/**
 * @author Luigi Iannone
 * 
 */
public class InstantiationTableModel implements TableModel {
	private final class LeavesComparator implements Comparator<BindingNode> {
		public int compare(BindingNode aBindingNode,
				BindingNode anotherBindingNode) {
			int toReturn = 0;
			Set<Variable> assignedVariables = aBindingNode
					.getAssignedVariables();
			Iterator<Variable> iterator = assignedVariables.iterator();
			ValueComputationParameters parameters = new SimpleValueComputationParameters(
					InstantiationTableModel.this.opplScript
							.getConstraintSystem(), BindingNode
							.getEmptyBindingNode());
			while (toReturn == 0 && iterator.hasNext()) {
				Variable variable = iterator.next();
				OWLObject aValue = aBindingNode.getAssignmentValue(variable,
						parameters);
				OWLObject anotherValue = anotherBindingNode.getAssignmentValue(
						variable, parameters);
				toReturn = InstantiationTableModel.this.getOWLEditorKit()
						.getModelManager().getRendering(aValue).compareTo(
								InstantiationTableModel.this.getOWLEditorKit()
										.getModelManager().getRendering(
												anotherValue));
			}
			return toReturn;
		}
	}

	private static final NoOPPLScriptTableModel NO_OPPL_SCRIPT_TABLE_MODEL = new NoOPPLScriptTableModel();
	private final Set<TableModelListener> listeners = new HashSet<TableModelListener>();
	private final List<BindingNode> leaves = new ArrayList<BindingNode>();
	private final OPPLScript opplScript;
	private final OWLEditorKit owlEditorKit;

	private static final class NoOPPLScriptTableModel implements TableModel {
		private NoOPPLScriptTableModel() {
		}

		public void addTableModelListener(TableModelListener l) {
		}

		public Class<?> getColumnClass(int columnIndex) {
			return null;
		}

		public int getColumnCount() {
			return 1;
		}

		public String getColumnName(int columnIndex) {
			return "Invalid Script";
		}

		public int getRowCount() {
			return 0;
		}

		public Object getValueAt(int rowIndex, int columnIndex) {
			return null;
		}

		public boolean isCellEditable(int rowIndex, int columnIndex) {
			return false;
		}

		public void removeTableModelListener(TableModelListener l) {
		}

		public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		}
	}

	/**
	 * @param opplScript
	 */
	public InstantiationTableModel(OPPLScript opplScript,
			OWLEditorKit owlEditorKit) {
		if (opplScript == null) {
			throw new NullPointerException("The OPPL Script cannot be null");
		}
		if (owlEditorKit == null) {
			throw new NullPointerException("The OWL Editor Kit cannot be null");
		}
		this.owlEditorKit = owlEditorKit;
		this.opplScript = opplScript;
		Set<BindingNode> scriptLeaves = this.getOPPLScript()
				.getConstraintSystem().getLeaves();
		if (scriptLeaves != null) {
			this.leaves.addAll(scriptLeaves);
			Collections.sort(this.leaves, new LeavesComparator());
		}
	}

	/**
	 * @see javax.swing.table.TableModel#addTableModelListener(javax.swing.event.TableModelListener)
	 */
	public void addTableModelListener(TableModelListener l) {
		if (l != null) {
			this.listeners.remove(l);
		}
	}

	/**
	 * @see javax.swing.table.TableModel#getColumnClass(int)
	 */
	public Class<?> getColumnClass(int columnIndex) {
		return OWLObject.class;
	}

	/**
	 * @see javax.swing.table.TableModel#getColumnCount()
	 */
	public int getColumnCount() {
		return this.opplScript.getVariables().size();
	}

	/**
	 * @see javax.swing.table.TableModel#getColumnName(int)
	 */
	public String getColumnName(int columnIndex) {
		List<Variable> sortedVariables = new ArrayList<Variable>(this
				.getOPPLScript().getVariables());
		Collections.sort(sortedVariables, new Comparator<Variable>() {
			public int compare(Variable variable, Variable anotherVariable) {
				return variable.getName().compareTo(anotherVariable.getName());
			}
		});
		return sortedVariables.get(columnIndex).getName();
	}

	/**
	 * @see javax.swing.table.TableModel#getRowCount()
	 */
	public int getRowCount() {
		return this.getLeaves().size();
	}

	/**
	 * @see javax.swing.table.TableModel#getValueAt(int, int)
	 */
	public Object getValueAt(int rowIndex, int columnIndex) {
		Object toReturn = null;
		BindingNode leaf = this.getLeaves().get(rowIndex);
		List<Variable> sortedVariables = new ArrayList<Variable>(this
				.getOPPLScript().getVariables());
		Collections.sort(sortedVariables, new Comparator<Variable>() {
			public int compare(Variable variable, Variable anotherVariable) {
				return variable.getName().compareTo(anotherVariable.getName());
			}
		});
		ValueComputationParameters parameters = new SimpleValueComputationParameters(
				this.opplScript.getConstraintSystem(), leaf);
		Variable variable = sortedVariables.get(columnIndex);
		toReturn = leaf.getAssignmentValue(variable, parameters);
		return toReturn;
	}

	/**
	 * @see javax.swing.table.TableModel#isCellEditable(int, int)
	 */
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return false;
	}

	/**
	 * @see javax.swing.table.TableModel#removeTableModelListener(javax.swing.event.TableModelListener)
	 */
	public void removeTableModelListener(TableModelListener l) {
		this.listeners.remove(l);
	}

	/**
	 * @see javax.swing.table.TableModel#setValueAt(java.lang.Object, int, int)
	 */
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
	}

	/**
	 * @return the leaves
	 */
	public List<BindingNode> getLeaves() {
		return new ArrayList<BindingNode>(this.leaves);
	}

	/**
	 * @return the opplScript
	 */
	public OPPLScript getOPPLScript() {
		return this.opplScript;
	}

	public static TableModel getNoOPPLScriptTableModel() {
		return InstantiationTableModel.NO_OPPL_SCRIPT_TABLE_MODEL;
	}

	/**
	 * @return the owlEditorKit
	 */
	public OWLEditorKit getOWLEditorKit() {
		return this.owlEditorKit;
	}
}
