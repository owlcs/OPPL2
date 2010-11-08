/**
 * Copyright (C) 2008, University of Manchester
 *
 * Modifications to the initial code base are copyright of their
 * respective authors, or their employers as appropriate.  Authorship
 * of the modifications may be determined from the ChangeLog placed at
 * the end of this file.
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.

 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.

 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301  USA
 */
package org.coode.oppl.protege.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutionException;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JToolBar;
import javax.swing.ListModel;
import javax.swing.SwingUtilities;
import javax.swing.event.ListDataEvent;
import javax.swing.event.ListDataListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableModel;

import org.coode.oppl.ChangeExtractor;
import org.coode.oppl.ConstraintSystem;
import org.coode.oppl.OPPLAbstractFactory;
import org.coode.oppl.OPPLQuery;
import org.coode.oppl.OPPLScript;
import org.coode.oppl.OPPLScriptVisitorEx;
import org.coode.oppl.PartialOWLObjectInstantiator;
import org.coode.oppl.Variable;
import org.coode.oppl.bindingtree.BindingNode;
import org.coode.oppl.exceptions.RuntimeExceptionHandler;
import org.coode.oppl.function.SimpleValueComputationParameters;
import org.coode.oppl.protege.ProtegeParserFactory;
import org.coode.oppl.protege.ui.rendering.InstantiationTableCellRenderer;
import org.coode.oppl.utils.EvaluationResults;
import org.coode.oppl.validation.OPPLScriptValidator;
import org.jdesktop.swingworker.SwingWorker;
import org.protege.editor.core.ui.util.ComponentFactory;
import org.protege.editor.core.ui.util.InputVerificationStatusChangedListener;
import org.protege.editor.owl.model.inference.NoOpReasoner;
import org.protege.editor.owl.ui.list.OWLLinkedObjectList;
import org.protege.editor.owl.ui.renderer.OWLCellRenderer;
import org.protege.editor.owl.ui.view.AbstractOWLViewComponent;
import org.semanticweb.owlapi.model.OWLAxiom;
import org.semanticweb.owlapi.model.OWLAxiomChange;
import org.semanticweb.owlapi.model.OWLObject;
import org.semanticweb.owlapi.reasoner.OWLReasoner;

/**
 * @author Luigi Iannone
 * 
 */
public final class OPPLView extends AbstractOWLViewComponent implements
		InputVerificationStatusChangedListener {
	private static final String INSTANTIATED_AXIOMS_TITLE = "Instantiated axioms: ";
	private static final String BINDINGS_TITLE = "Bindings:";
	private RuntimeExceptionHandler runtimeExceptionHandler;

	private final class InstantiatedAxiomListModel implements ListModel {
		private final Set<BindingNode> bindingNodes = new HashSet<BindingNode>();
		private final Set<ListDataListener> listeners = new HashSet<ListDataListener>();
		private final List<OWLAxiom> instantiations = new ArrayList<OWLAxiom>();

		private final void init() {
			this.instantiations.clear();
			for (BindingNode leaf : this.getBindingNodes()) {
				this.instantiateAxioms(leaf);
			}
			this.notifyListeners();
		}

		public void clear() {
			this.bindingNodes.clear();
			this.init();
		}

		public void setBindingNodes(
				Collection<? extends BindingNode> bindingNodes) {
			this.bindingNodes.clear();
			this.bindingNodes.addAll(bindingNodes);
			this.init();
		}

		/**
		 * @param leaf
		 */
		private void instantiateAxioms(BindingNode leaf) {
			if (OPPLView.this.statementModel != null) {
				OPPLQuery query = OPPLView.this.statementModel.getQuery();
				if (query != null) {
					PartialOWLObjectInstantiator partialOWLObjectInstantiator = new PartialOWLObjectInstantiator(
							new SimpleValueComputationParameters(
									OPPLView.this.statementModel
											.getConstraintSystem(), leaf,
									OPPLView.this.getRuntimeExceptionHandler()));
					List<OWLAxiom> assertedAxioms = query.getAssertedAxioms();
					for (OWLAxiom owlAxiom : assertedAxioms) {
						this.instantiations.add((OWLAxiom) owlAxiom
								.accept(partialOWLObjectInstantiator));
					}
					List<OWLAxiom> axioms = query.getAxioms();
					for (OWLAxiom owlAxiom : axioms) {
						this.instantiations.add((OWLAxiom) owlAxiom
								.accept(partialOWLObjectInstantiator));
					}
				}
			}
		}

		private void notifyListeners() {
			for (ListDataListener l : this.listeners) {
				l.contentsChanged(new ListDataEvent(this,
						ListDataEvent.CONTENTS_CHANGED, 0, this.instantiations
								.size() - 1));
			}
		}

		public void addListDataListener(ListDataListener l) {
			if (l != null) {
				this.listeners.add(l);
			}
		}

		public Object getElementAt(int index) {
			return this.instantiations.get(index);
		}

		public int getSize() {
			return this.instantiations.size();
		}

		public void removeListDataListener(ListDataListener l) {
			this.listeners.remove(l);
		}

		/**
		 * @return the bindingNodes
		 */
		public Set<BindingNode> getBindingNodes() {
			return new HashSet<BindingNode>(this.bindingNodes);
		}
	}

	private final class ReasonerOPPLScriptValiator implements
			OPPLScriptValidator {
		private final class ScriptVisitor implements
				OPPLScriptVisitorEx<Boolean> {
			public ScriptVisitor() {
			}

			public Boolean visitActions(List<OWLAxiomChange> changes, Boolean p) {
				return p == null ? true : p;
			}

			public Boolean visit(OPPLQuery q, Boolean p) {
				return p == null ? true : p;
			}

			public Boolean visit(Variable v, Boolean p) {
				return p == null ? v.getVariableScope() == null : p
						|| v.getVariableScope() == null;
			}
		}

		public ReasonerOPPLScriptValiator() {
		}

		public boolean accept(OPPLScript script) {
			OWLReasoner reasoner = OPPLView.this.getOWLEditorKit()
					.getModelManager().getReasoner();
			Boolean accept = script.accept(new ScriptVisitor());
			return !(reasoner instanceof NoOpReasoner) || accept;
		}

		public String getValidationRuleDescription() {
			return "If the script contains scoped variables the selected reasoner cannot be NoOpReasoner";
		}
	}

	class OPPLExecutorSwingWorker extends
			SwingWorker<List<OWLAxiomChange>, OPPLScript> {
		private final List<OWLAxiomChange> changes = new ArrayList<OWLAxiomChange>();

		/**
		 * @param changes
		 */
		protected OPPLExecutorSwingWorker(List<OWLAxiomChange> changes) {
			this.changes.addAll(changes);
		}

		@Override
		protected List<OWLAxiomChange> doInBackground() {
			OPPLView.this.getOWLEditorKit().getModelManager().applyChanges(
					this.changes);
			return this.changes;
		}

		@Override
		protected void done() {
			SwingUtilities.invokeLater(new Runnable() {
				public void run() {
					OPPLView.this.window.setVisible(false);
					OPPLView.this.window.dispose();
				}
			});
		}
	}

	class OPPLChangeDetectorSwingWorker extends
			SwingWorker<List<OWLAxiomChange>, OPPLScript> {
		@Override
		protected void done() {
			List<OWLAxiomChange> changes;
			try {
				changes = this.get();
				ActionListModel model = (ActionListModel) OPPLView.this.affectedAxioms
						.getModel();
				model.clear();
				if (changes != null) {
					for (OWLAxiomChange axiomChange : changes) {
						model.addAction(axiomChange, false, true);
					}
				}
				OPPLView.this.revalidate();
				EvaluationResults evaluationResults = new EvaluationResults(
						OPPLView.this.statementModel, changes);
				OPPLView.this.copyResultsAction.setEnabled(true);
				OPPLView.this.copyResultsAction.setResult(evaluationResults
						.toString());
				OPPLView.this.bindingTableModel = new InstantiationTableModel(
						OPPLView.this.statementModel, OPPLView.this
								.getOWLEditorKit());
				OPPLView.this.bindingTable
						.setModel(OPPLView.this.bindingTableModel);
				OPPLView.this.bindingTreeScrollPane
						.setBorder(ComponentFactory
								.createTitledBorder(BINDINGS_TITLE
										+ ": "
										+ OPPLView.this.bindingTableModel
												.getRowCount()));
				SwingUtilities.invokeLater(new Runnable() {
					public void run() {
						OPPLView.this.affectedScrollPane
								.setBorder(ComponentFactory
										.createTitledBorder("Affected axioms: "
												+ OPPLView.this.affectedAxioms
														.getModel().getSize()));
						OPPLView.this.window.setVisible(false);
						OPPLView.this.window.dispose();
					}
				});
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (ExecutionException e) {
				e.printStackTrace();
			}
		}

		@Override
		protected List<OWLAxiomChange> doInBackground() {
			List<OWLAxiomChange> result = new ArrayList<OWLAxiomChange>();
			try {
				ChangeExtractor changeExtractor = new ChangeExtractor(
						OPPLView.this.getRuntimeExceptionHandler(),
						OPPLView.this.considerImportClosureCheckBox
								.isSelected());
				result.addAll(changeExtractor
						.visit(OPPLView.this.statementModel));
			} catch (Exception e) {
				e.printStackTrace();
			}
			return result;
		}
	}

	/**
	 *
	 */
	private static final long serialVersionUID = 1897093057453176659L;
	private static final String OPPL_COMPUTATION_IN_PROGRESS_PLEASE_WAIT = "OPPL Computation in progress...please wait";
	private OPPLEditor editor;
	private final ReasonerOPPLScriptValiator validator = new ReasonerOPPLScriptValiator();
	private JButton evaluate = new JButton("Evaluate");
	private JButton execute = new JButton("Execute");
	private ActionList affectedAxioms;
	private final InstantiatedAxiomListModel instantiatedAxiomListModel = new InstantiatedAxiomListModel();
	private OWLLinkedObjectList instantiatedAxiomsList;
	private OPPLScript statementModel;
	private JDialog window;
	private JScrollPane affectedScrollPane;
	private JScrollPane instantiatedScrollPane;
	private JCheckBox considerImportClosureCheckBox = new JCheckBox(
			"When removing consider Active Ontology Imported Closure", false);
	private final CopyAction copyResultsAction = new CopyAction(
			"Copy results to Clipboard");
	private TableModel bindingTableModel = InstantiationTableModel
			.getNoOPPLScriptTableModel();
	private final JTable bindingTable = new JTable(this.bindingTableModel);
	private JScrollPane bindingTreeScrollPane;

	@Override
	protected void disposeOWLView() {
		// this.getOWLEditorKit().getModelManager().removeListener(this);
		this.editor.removeStatusChangedListener(this);
		this.editor.dispose();
		ProtegeParserFactory.getInstance(this.getOWLEditorKit()).dispose();
	}

	@Override
	protected void initialiseOWLView() {
		this.setLayout(new BorderLayout());
		JSplitPane mainPanel = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
		mainPanel.setDividerLocation(.6);
		mainPanel.setResizeWeight(.6);
		JPanel statementPanel = new JPanel(new BorderLayout());
		ProtegeParserFactory.reset();
		OPPLAbstractFactory opplFactory = ProtegeParserFactory.getInstance(
				this.getOWLEditorKit()).getOPPLFactory();
		this.runtimeExceptionHandler = new ShowMessageRuntimeExceptionHandler(
				this);
		this.affectedAxioms = new ActionList(
				this.getOWLEditorKit(),
				new ConstraintSystem(this.getOWLEditorKit().getModelManager()
						.getActiveOntology(), this.getOWLEditorKit()
						.getModelManager().getOWLOntologyManager(), opplFactory),
				false);
		this.instantiatedAxiomsList = new OWLLinkedObjectList(this
				.getOWLEditorKit());
		this.instantiatedAxiomsList.setModel(this.instantiatedAxiomListModel);
		OWLCellRenderer cellRenderer = new OWLCellRenderer(this
				.getOWLEditorKit());
		cellRenderer.setWrap(true);
		cellRenderer.setHighlightKeywords(true);
		this.considerImportClosureCheckBox
				.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						((DefaultListModel) OPPLView.this.affectedAxioms
								.getModel()).clear();
						OPPLView.this.affectedScrollPane
								.setBorder(ComponentFactory
										.createTitledBorder("Affected axioms: "));
						OPPLView.this.evaluate
								.setEnabled(OPPLView.this.statementModel != null);
						OPPLView.this.copyResultsAction.setEnabled(false);
						OPPLView.this.execute.setEnabled(false);
					}
				});
		this.instantiatedAxiomsList.setCellRenderer(cellRenderer);
		// this.getOWLEditorKit().getModelManager().addListener(this);
		// this.getOWLModelManager().getOWLOntologyManager().addOntologyChangeListener(this);
		this.editor = new OPPLEditor(this.getOWLEditorKit(), this.validator);
		this.editor.setPreferredSize(new Dimension(200, 300));
		statementPanel.add(this.evaluate, BorderLayout.SOUTH);
		mainPanel.add(statementPanel, JSplitPane.TOP);
		// Effects GUI portion
		JSplitPane effects = new JSplitPane();
		this.affectedScrollPane = ComponentFactory
				.createScrollPane(this.affectedAxioms);
		this.instantiatedScrollPane = ComponentFactory
				.createScrollPane(this.instantiatedAxiomsList);
		this.instantiatedScrollPane.setBorder(ComponentFactory
				.createTitledBorder(OPPLView.INSTANTIATED_AXIOMS_TITLE));
		this.affectedScrollPane.setBorder(ComponentFactory
				.createTitledBorder("Affected axioms:"));
		JPanel bottomPanel = new JPanel(new BorderLayout());
		JToolBar toolBar = new JToolBar(JToolBar.HORIZONTAL);
		toolBar.setFloatable(false);
		toolBar.add(this.copyResultsAction);
		statementPanel.add(ComponentFactory.createScrollPane(this.editor),
				BorderLayout.CENTER);
		JPanel toolBarPanel = new JPanel(new BorderLayout());
		toolBarPanel.add(toolBar, BorderLayout.WEST);
		toolBarPanel.add(this.considerImportClosureCheckBox, BorderLayout.EAST);
		bottomPanel.add(toolBarPanel, BorderLayout.NORTH);
		effects.add(this.affectedScrollPane, JSplitPane.LEFT);
		JSplitPane instantiatonPanel = new JSplitPane();
		this.bindingTreeScrollPane = ComponentFactory
				.createScrollPane(this.bindingTable);
		this.bindingTreeScrollPane.setBorder(ComponentFactory
				.createTitledBorder(OPPLView.BINDINGS_TITLE));
		instantiatonPanel.add(this.bindingTreeScrollPane, JSplitPane.LEFT);
		instantiatonPanel.add(this.instantiatedScrollPane, JSplitPane.RIGHT);
		effects.add(instantiatonPanel, JSplitPane.RIGHT);
		bottomPanel.add(effects, BorderLayout.CENTER);
		mainPanel.add(bottomPanel, JSplitPane.BOTTOM);
		this.add(mainPanel, BorderLayout.CENTER);
		this.add(this.execute, BorderLayout.SOUTH);
		this.evaluate.setEnabled(false);
		this.execute.setEnabled(false);
		this.copyResultsAction.setEnabled(false);
		this.evaluate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OPPLView.this.evaluate.setEnabled(false);
				OPPLView.this.copyResultsAction.setEnabled(false);
				OPPLView.this.setupOPPLProgressMonitor();
				OPPLChangeDetectorSwingWorker opplSwingWorker = new OPPLChangeDetectorSwingWorker();
				OPPLView.this.window.pack();
				SwingUtilities.invokeLater(new Runnable() {
					public void run() {
						OPPLView.this.window.setVisible(true);
					}
				});
				opplSwingWorker.execute();
			}
		});
		this.affectedAxioms.getModel().addListDataListener(
				new ListDataListener() {
					public void contentsChanged(ListDataEvent e) {
						OPPLView.this.execute
								.setEnabled(OPPLView.this.affectedAxioms
										.getModel().getSize() > 0);
					}

					public void intervalAdded(ListDataEvent e) {
						OPPLView.this.execute
								.setEnabled(OPPLView.this.affectedAxioms
										.getModel().getSize() > 0);
					}

					public void intervalRemoved(ListDataEvent e) {
						OPPLView.this.execute
								.setEnabled(OPPLView.this.affectedAxioms
										.getModel().getSize() > 0);
					}
				});
		this.execute.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ActionListModel model = (ActionListModel) OPPLView.this.affectedAxioms
						.getModel();
				OPPLView.this.setupOPPLProgressMonitor();
				OPPLView.this.window.pack();
				List<OWLAxiomChange> changes = model.getOWLAxiomChanges();
				OPPLExecutorSwingWorker executorSwingWorker = new OPPLExecutorSwingWorker(
						changes);
				SwingUtilities.invokeLater(new Runnable() {
					public void run() {
						OPPLView.this.affectedScrollPane
								.setBorder(ComponentFactory
										.createTitledBorder("Affected axioms: "));
						OPPLView.this.editor.clear();
						OPPLView.this.window.setVisible(true);
					}
				});
				executorSwingWorker.execute();
				model.clear();
			}
		});
		this.editor.addStatusChangedListener(this);
		this.bindingTable.setDefaultRenderer(OWLObject.class,
				new InstantiationTableCellRenderer(this.getOWLEditorKit()));
		this.bindingTable.setDefaultRenderer(Set.class,
				new InstantiationTableCellRenderer(this.getOWLEditorKit()));
		this.bindingTable.getSelectionModel().addListSelectionListener(
				new ListSelectionListener() {
					public void valueChanged(ListSelectionEvent e) {
						if (!e.getValueIsAdjusting()
								&& OPPLView.this.bindingTable.getModel() instanceof InstantiationTableModel) {
							InstantiationTableModel instantiationTableModel = (InstantiationTableModel) OPPLView.this.bindingTable
									.getModel();
							int[] selectedRows = OPPLView.this.bindingTable
									.getSelectedRows();
							Set<BindingNode> bindingNodes = new HashSet<BindingNode>(
									selectedRows.length);
							for (int i : selectedRows) {
								bindingNodes.add(instantiationTableModel
										.getLeaves().get(i));
							}
							OPPLView.this.instantiatedAxiomListModel
									.setBindingNodes(bindingNodes);
						}
					}
				});
	}

	private final void setupOPPLProgressMonitor() {
		JPanel panel = new JPanel(new BorderLayout(7, 7));
		JProgressBar progressBar = new JProgressBar();
		panel.add(progressBar, BorderLayout.SOUTH);
		panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		progressBar.setIndeterminate(true);
		JLabel label = new JLabel(OPPL_COMPUTATION_IN_PROGRESS_PLEASE_WAIT);
		panel.add(label, BorderLayout.NORTH);
		this.window = new JDialog((Frame) SwingUtilities.getAncestorOfClass(
				Frame.class, this.getOWLEditorKit().getWorkspace()),
				"OPPL Engine progress", true);
		this.window.setLocation(400, 400);
		JPanel holderPanel = new JPanel(new BorderLayout(7, 7));
		holderPanel.add(panel, BorderLayout.NORTH);
		holderPanel.setBorder(BorderFactory.createEmptyBorder(5, 10, 10, 10));
		this.window.getContentPane().setLayout(new BorderLayout());
		this.window.getContentPane().add(holderPanel, BorderLayout.NORTH);
		this.window.pack();
		Dimension windowSize = this.window.getSize();
		this.window.setSize(400, windowSize.height);
		this.window.setResizable(false);
	}

	public void verifiedStatusChanged(boolean newState) {
		this.instantiatedAxiomListModel.clear();
		this.bindingTableModel = InstantiationTableModel
				.getNoOPPLScriptTableModel();
		this.bindingTable.setModel(this.bindingTableModel);
		this.evaluate.setEnabled(newState);
		this.copyResultsAction.setEnabled(false);
		this.bindingTreeScrollPane.setBorder(ComponentFactory
				.createTitledBorder(BINDINGS_TITLE));
		ListModel model = this.affectedAxioms.getModel();
		((DefaultListModel) model).clear();
		OPPLView.this.affectedScrollPane.setBorder(ComponentFactory
				.createTitledBorder("Affected axioms: "));
		if (newState) {
			this.statementModel = this.editor.getOPPLScript();
			this.bindingTableModel = new InstantiationTableModel(
					this.statementModel, this.getOWLEditorKit());
			this.bindingTable.setModel(this.bindingTableModel);
		}
	}

	/**
	 * @return the runtimeExceptionHandler
	 */
	public RuntimeExceptionHandler getRuntimeExceptionHandler() {
		return this.runtimeExceptionHandler;
	}

	/**
	 * @param runtimeExceptionHandler
	 *            the runtimeExceptionHandler to set
	 */
	public void setRuntimeExceptionHandler(
			RuntimeExceptionHandler runtimeExceptionHandler) {
		this.runtimeExceptionHandler = runtimeExceptionHandler;
	}
}
