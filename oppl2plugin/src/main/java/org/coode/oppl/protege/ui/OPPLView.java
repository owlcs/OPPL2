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
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;

import javax.swing.*;
import javax.swing.event.ListDataEvent;
import javax.swing.event.ListDataListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableModel;

import org.coode.oppl.*;
import org.coode.oppl.bindingtree.BindingNode;
import org.coode.oppl.exceptions.RuntimeExceptionHandler;
import org.coode.oppl.function.SimpleValueComputationParameters;
import org.coode.oppl.protege.ProtegeParserFactory;
import org.coode.oppl.protege.ui.rendering.InstantiationTableCellRenderer;
import org.coode.oppl.utils.AbstractVariableVisitorExAdapter;
import org.coode.oppl.utils.EvaluationResults;
import org.coode.oppl.validation.OPPLScriptValidator;
import org.coode.oppl.variabletypes.InputVariable;
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
 */
public final class OPPLView extends AbstractOWLViewComponent implements
    InputVerificationStatusChangedListener {

    private static final String INSTANTIATED_AXIOMS_TITLE = "Instantiated axioms: ";
    private static final String BINDINGS_TITLE = "Bindings";
    private static final String AFFECTED_AXIOMS_TITLE = "Affected axioms";
    private RuntimeExceptionHandler runtimeExceptionHandler;

    private final class InstantiatedAxiomListModel implements ListModel {

        private final Set<BindingNode> bindingNodes = new HashSet<>();
        private final Set<ListDataListener> listeners = new HashSet<>();
        private final List<OWLAxiom> instantiations = new ArrayList<>();

        public InstantiatedAxiomListModel() {}

        private final void init() {
            instantiations.clear();
            for (BindingNode leaf : getBindingNodes()) {
                instantiateAxioms(leaf);
            }
            notifyListeners();
        }

        public void clear() {
            bindingNodes.clear();
            init();
        }

        public void setBindingNodes(Collection<? extends BindingNode> bindingNodes) {
            this.bindingNodes.clear();
            this.bindingNodes.addAll(bindingNodes);
            init();
        }

        /**
         * @param leaf
         *        leaf
         */
        private void instantiateAxioms(BindingNode leaf) {
            if (statementModel != null) {
                OPPLQuery query = statementModel.getQuery();
                if (query != null) {
                    PartialOWLObjectInstantiator partialOWLObjectInstantiator = new PartialOWLObjectInstantiator(
                        new SimpleValueComputationParameters(
                            statementModel.getConstraintSystem(), leaf,
                            getRuntimeExceptionHandler()));
                    List<OWLAxiom> assertedAxioms = query.getAssertedAxioms();
                    for (OWLAxiom owlAxiom : assertedAxioms) {
                        instantiations.add((OWLAxiom) owlAxiom
                            .accept(partialOWLObjectInstantiator));
                    }
                    List<OWLAxiom> axioms = query.getAxioms();
                    for (OWLAxiom owlAxiom : axioms) {
                        instantiations.add((OWLAxiom) owlAxiom
                            .accept(partialOWLObjectInstantiator));
                    }
                }
            }
        }

        private void notifyListeners() {
            for (ListDataListener l : listeners) {
                l.contentsChanged(new ListDataEvent(this, ListDataEvent.CONTENTS_CHANGED,
                    0, instantiations.size() - 1));
            }
        }

        @Override
        public void addListDataListener(ListDataListener l) {
            if (l != null) {
                listeners.add(l);
            }
        }

        @Override
        public OWLAxiom getElementAt(int index) {
            return instantiations.get(index);
        }

        @Override
        public int getSize() {
            return instantiations.size();
        }

        @Override
        public void removeListDataListener(ListDataListener l) {
            listeners.remove(l);
        }

        /**
         * @return the bindingNodes
         */
        public Set<BindingNode> getBindingNodes() {
            return new HashSet<>(bindingNodes);
        }
    }

    private final class ReasonerOPPLScriptValiator implements OPPLScriptValidator {

        private final class ScriptVisitor implements OPPLScriptVisitorEx<Boolean> {

            public ScriptVisitor() {}

            @Override
            public Boolean visitActions(List<OWLAxiomChange> changes, Boolean p) {
                return p == null ? true : p;
            }

            @Override
            public Boolean visit(OPPLQuery q, Boolean p) {
                return p == null ? true : p;
            }

            @Override
            public Boolean visit(Variable<?> v, Boolean p) {
                AbstractVariableVisitorExAdapter<Boolean> nullScopeDetector = new AbstractVariableVisitorExAdapter<Boolean>(
                    true) {

                    @Override
                    public <P extends OWLObject> Boolean visit(InputVariable<P> iv) {
                        return iv.getVariableScope() == null;
                    }
                };
                return p == null ? v.accept(nullScopeDetector) : p
                    || v.accept(nullScopeDetector);
            }
        }

        public ReasonerOPPLScriptValiator() {}

        @Override
        public boolean accept(OPPLScript script) {
            OWLReasoner reasoner = getOWLEditorKit().getModelManager().getReasoner();
            Boolean accept = script.accept(new ScriptVisitor());
            return !(reasoner instanceof NoOpReasoner) || accept;
        }

        @Override
        public String getValidationRuleDescription() {
            return "If the script contains scoped variables the selected reasoner cannot be NoOpReasoner";
        }
    }

    class OPPLExecutorSwingWorker extends SwingWorker<List<OWLAxiomChange>, OPPLScript> {

        private final List<OWLAxiomChange> changes = new ArrayList<>();

        /**
         * @param changes
         *        changes
         */
        protected OPPLExecutorSwingWorker(List<OWLAxiomChange> changes) {
            this.changes.addAll(changes);
        }

        @Override
        protected List<OWLAxiomChange> doInBackground() {
            getOWLEditorKit().getModelManager().applyChanges(changes);
            return changes;
        }

        @Override
        protected void done() {
            SwingUtilities.invokeLater(new Runnable() {

                @Override
                public void run() {
                    window.setVisible(false);
                    window.dispose();
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
                ActionListModel model = (ActionListModel) affectedAxioms.getModel();
                model.clear();
                if (!isCancelled()) {
                    if (changes != null) {
                        for (OWLAxiomChange axiomChange : changes) {
                            model.addAction(axiomChange, false, true);
                        }
                        revalidate();
                        EvaluationResults evaluationResults = new EvaluationResults(
                            statementModel, changes);
                        copyResultsAction.setEnabled(true);
                        copyResultsAction.setResult(evaluationResults.toString());
                        bindingTableModel = new InstantiationTableModel(statementModel,
                            getOWLEditorKit());
                        bindingTable.setModel(bindingTableModel);
                        bindingTreeScrollPane
                            .setBorder(ComponentFactory.createTitledBorder(String
                                .format("%s: %d", BINDINGS_TITLE,
                                    bindingTableModel.getRowCount())));
                        SwingUtilities.invokeLater(new Runnable() {

                            @Override
                            public void run() {
                                affectedScrollPane.setBorder(ComponentFactory
                                    .createTitledBorder(String.format("%s: %d",
                                        AFFECTED_AXIOMS_TITLE, affectedAxioms
                                            .getModel().getSize())));
                                window.setVisible(false);
                                window.dispose();
                            }
                        });
                    }
                } else {
                    evaluate.setEnabled(true);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            } catch (CancellationException e) {
                ActionListModel model = (ActionListModel) affectedAxioms.getModel();
                model.clear();
                evaluate.setEnabled(true);
                SwingUtilities.invokeLater(new Runnable() {

                    @Override
                    public void run() {
                        affectedScrollPane.setBorder(ComponentFactory
                            .createTitledBorder(String.format("%s: %d",
                                AFFECTED_AXIOMS_TITLE, affectedAxioms.getModel()
                                    .getSize())));
                        window.setVisible(false);
                        window.dispose();
                    }
                });
            }
        }

        @Override
        protected List<OWLAxiomChange> doInBackground() {
            List<OWLAxiomChange> result = new ArrayList<>();
            try {
                ChangeExtractor changeExtractor = new ChangeExtractor(
                    getRuntimeExceptionHandler(), new ExecutionMonitor() {

                        @Override
                        public boolean isCancelled() {
                            return OPPLChangeDetectorSwingWorker.this.isCancelled();
                        }

                        @Override
                        public void progressIncrementChanged(int newValue) {
                            progressBarModel.setValue(newValue);
                        }
                    }, considerImportClosureCheckBox.isSelected());
                result.addAll(changeExtractor.visit(statementModel));
            } catch (Exception e) {
                e.printStackTrace();
            }
            return result;
        }
    }

    private static final long serialVersionUID = 20100L;
    private static final String OPPL_COMPUTATION_IN_PROGRESS_PLEASE_WAIT = "OPPL Computation in progress...please wait";
    protected OPPLEditor editor;
    protected final ReasonerOPPLScriptValiator validator = new ReasonerOPPLScriptValiator();
    protected final JButton evaluate = new JButton("Evaluate");
    protected final JButton stopEvaluation = new JButton("Cancel");
    protected final JButton execute = new JButton("Execute");
    protected ActionList affectedAxioms;
    protected final InstantiatedAxiomListModel instantiatedAxiomListModel = new InstantiatedAxiomListModel();
    protected OWLLinkedObjectList instantiatedAxiomsList;
    protected OPPLScript statementModel;
    protected JDialog window;
    protected JScrollPane affectedScrollPane;
    protected JScrollPane instantiatedScrollPane;
    protected final JCheckBox considerImportClosureCheckBox = new JCheckBox(
        "When removing consider Active Ontology Imported Closure", false);
    protected final CopyAction copyResultsAction = new CopyAction(
        "Copy results to Clipboard");
    protected final BoundedRangeModel progressBarModel = new DefaultBoundedRangeModel();
    protected TableModel bindingTableModel = InstantiationTableModel
        .getNoOPPLScriptTableModel();
    protected final JTable bindingTable = new JTable(bindingTableModel);
    protected JScrollPane bindingTreeScrollPane;
    protected OPPLChangeDetectorSwingWorker opplSwingWorker;

    @Override
    protected void disposeOWLView() {
        // this.getOWLEditorKit().getModelManager().removeListener(this);
        editor.removeStatusChangedListener(this);
        editor.dispose();
        ProtegeParserFactory.getInstance(getOWLEditorKit()).dispose();
    }

    @Override
    protected void initialiseOWLView() {
        setLayout(new BorderLayout());
        JSplitPane mainPanel = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
        mainPanel.setDividerLocation(.6);
        mainPanel.setResizeWeight(.6);
        JPanel statementPanel = new JPanel(new BorderLayout());
        ProtegeParserFactory.reset();
        OPPLAbstractFactory opplFactory = ProtegeParserFactory.getInstance(
            getOWLEditorKit()).getOPPLFactory();
        runtimeExceptionHandler = new ShowMessageRuntimeExceptionHandler(this);
        affectedAxioms = new ActionList(getOWLEditorKit(),
            new ConstraintSystem(getOWLEditorKit().getModelManager()
                .getActiveOntology(), getOWLEditorKit().getModelManager()
                    .getOWLOntologyManager(), opplFactory), false);
        instantiatedAxiomsList = new OWLLinkedObjectList(getOWLEditorKit());
        instantiatedAxiomsList.setModel(instantiatedAxiomListModel);
        OWLCellRenderer cellRenderer = new OWLCellRenderer(getOWLEditorKit());
        cellRenderer.setWrap(true);
        cellRenderer.setHighlightKeywords(true);
        considerImportClosureCheckBox.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                affectedAxioms.getDefaultModel().clear();
                affectedScrollPane.setBorder(ComponentFactory
                    .createTitledBorder("Affected axioms: "));
                evaluate.setEnabled(statementModel != null);
                copyResultsAction.setEnabled(false);
                execute.setEnabled(false);
            }
        });
        instantiatedAxiomsList.setCellRenderer(cellRenderer);
        editor = new OPPLEditor(getOWLEditorKit(), validator);
        editor.setPreferredSize(new Dimension(200, 300));
        statementPanel.add(evaluate, BorderLayout.SOUTH);
        mainPanel.add(statementPanel, JSplitPane.TOP);
        // Effects GUI portion
        JSplitPane effects = new JSplitPane();
        affectedScrollPane = ComponentFactory.createScrollPane(affectedAxioms);
        instantiatedScrollPane = ComponentFactory
            .createScrollPane(instantiatedAxiomsList);
        instantiatedScrollPane.setBorder(ComponentFactory
            .createTitledBorder(OPPLView.INSTANTIATED_AXIOMS_TITLE));
        affectedScrollPane.setBorder(ComponentFactory
            .createTitledBorder(AFFECTED_AXIOMS_TITLE));
        JPanel bottomPanel = new JPanel(new BorderLayout());
        JToolBar toolBar = new JToolBar(SwingConstants.HORIZONTAL);
        toolBar.setFloatable(false);
        toolBar.add(copyResultsAction);
        statementPanel
            .add(ComponentFactory.createScrollPane(editor), BorderLayout.CENTER);
        JPanel toolBarPanel = new JPanel(new BorderLayout());
        toolBarPanel.add(toolBar, BorderLayout.WEST);
        toolBarPanel.add(considerImportClosureCheckBox, BorderLayout.EAST);
        bottomPanel.add(toolBarPanel, BorderLayout.NORTH);
        effects.add(affectedScrollPane, JSplitPane.LEFT);
        JSplitPane instantiatonPanel = new JSplitPane();
        bindingTreeScrollPane = ComponentFactory.createScrollPane(bindingTable);
        bindingTreeScrollPane.setBorder(ComponentFactory
            .createTitledBorder(OPPLView.BINDINGS_TITLE));
        instantiatonPanel.add(bindingTreeScrollPane, JSplitPane.LEFT);
        instantiatonPanel.add(instantiatedScrollPane, JSplitPane.RIGHT);
        effects.add(instantiatonPanel, JSplitPane.RIGHT);
        bottomPanel.add(effects, BorderLayout.CENTER);
        mainPanel.add(bottomPanel, JSplitPane.BOTTOM);
        this.add(mainPanel, BorderLayout.CENTER);
        this.add(execute, BorderLayout.SOUTH);
        evaluate.setEnabled(false);
        execute.setEnabled(false);
        copyResultsAction.setEnabled(false);
        evaluate.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                evaluate.setEnabled(false);
                copyResultsAction.setEnabled(false);
                OPPLView.this.setupOPPLProgressMonitor();
                opplSwingWorker = new OPPLChangeDetectorSwingWorker();
                window.pack();
                SwingUtilities.invokeLater(new Runnable() {

                    @Override
                    public void run() {
                        window.setVisible(true);
                    }
                });
                opplSwingWorker.execute();
            }
        });
        stopEvaluation.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                opplSwingWorker.cancel(true);
            }
        });
        affectedAxioms.getModel().addListDataListener(new ListDataListener() {

            @Override
            public void contentsChanged(ListDataEvent e) {
                execute.setEnabled(affectedAxioms.getModel().getSize() > 0);
            }

            @Override
            public void intervalAdded(ListDataEvent e) {
                execute.setEnabled(affectedAxioms.getModel().getSize() > 0);
            }

            @Override
            public void intervalRemoved(ListDataEvent e) {
                execute.setEnabled(affectedAxioms.getModel().getSize() > 0);
            }
        });
        execute.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                ActionListModel model = (ActionListModel) affectedAxioms.getModel();
                OPPLView.this.setupOPPLProgressMonitor();
                window.pack();
                List<OWLAxiomChange> changes = model.getOWLAxiomChanges();
                OPPLExecutorSwingWorker executorSwingWorker = new OPPLExecutorSwingWorker(
                    changes);
                SwingUtilities.invokeLater(new Runnable() {

                    @Override
                    public void run() {
                        affectedScrollPane.setBorder(ComponentFactory
                            .createTitledBorder(AFFECTED_AXIOMS_TITLE));
                        editor.clear();
                        window.setVisible(true);
                    }
                });
                executorSwingWorker.execute();
                model.clear();
            }
        });
        editor.addStatusChangedListener(this);
        bindingTable.setDefaultRenderer(OWLObject.class,
            new InstantiationTableCellRenderer(getOWLEditorKit()));
        bindingTable.setDefaultRenderer(Set.class, new InstantiationTableCellRenderer(
            getOWLEditorKit()));
        bindingTable.getSelectionModel().addListSelectionListener(
            new ListSelectionListener() {

                @Override
                public void valueChanged(ListSelectionEvent e) {
                    if (!e.getValueIsAdjusting()
                        && bindingTable.getModel() instanceof InstantiationTableModel) {
                        InstantiationTableModel instantiationTableModel = (InstantiationTableModel) bindingTable
                            .getModel();
                        int[] selectedRows = bindingTable.getSelectedRows();
                        Set<BindingNode> bindingNodes = new HashSet<>(
                            selectedRows.length);
                        for (int i : selectedRows) {
                            bindingNodes.add(instantiationTableModel.getLeaves().get(
                                i));
                        }
                        instantiatedAxiomListModel.setBindingNodes(bindingNodes);
                    }
                }
            });
    }

    protected final void setupOPPLProgressMonitor() {
        JPanel panel = new JPanel(new BorderLayout(7, 7));
        progressBarModel.setValue(0);
        JProgressBar progressBar = new JProgressBar(progressBarModel);
        JPanel progressPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        progressPanel.add(progressBar);
        progressPanel.add(stopEvaluation);
        panel.add(progressPanel, BorderLayout.SOUTH);
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        JLabel label = new JLabel(OPPL_COMPUTATION_IN_PROGRESS_PLEASE_WAIT);
        panel.add(label, BorderLayout.NORTH);
        window = new JDialog((Frame) SwingUtilities.getAncestorOfClass(Frame.class,
            getOWLEditorKit().getWorkspace()), "OPPL Engine progress", true);
        window.setLocation(400, 400);
        JPanel holderPanel = new JPanel(new BorderLayout(7, 7));
        holderPanel.add(panel, BorderLayout.NORTH);
        holderPanel.setBorder(BorderFactory.createEmptyBorder(5, 10, 10, 10));
        window.getContentPane().setLayout(new BorderLayout());
        window.getContentPane().add(holderPanel, BorderLayout.NORTH);
        window.pack();
        Dimension windowSize = window.getSize();
        window.setSize(400, windowSize.height);
        window.setResizable(false);
    }

    @Override
    public void verifiedStatusChanged(boolean newState) {
        instantiatedAxiomListModel.clear();
        bindingTableModel = InstantiationTableModel.getNoOPPLScriptTableModel();
        bindingTable.setModel(bindingTableModel);
        evaluate.setEnabled(newState);
        copyResultsAction.setEnabled(false);
        bindingTreeScrollPane.setBorder(ComponentFactory
            .createTitledBorder(BINDINGS_TITLE));
        affectedAxioms.getDefaultModel().clear();
        OPPLView.this.affectedScrollPane.setBorder(ComponentFactory
            .createTitledBorder(AFFECTED_AXIOMS_TITLE));
        if (newState) {
            statementModel = editor.getOPPLScript();
            bindingTableModel = new InstantiationTableModel(statementModel,
                getOWLEditorKit());
            bindingTable.setModel(bindingTableModel);
        }
    }

    /**
     * @return the runtimeExceptionHandler
     */
    public RuntimeExceptionHandler getRuntimeExceptionHandler() {
        return runtimeExceptionHandler;
    }

    /**
     * @param runtimeExceptionHandler
     *        the runtimeExceptionHandler to set
     */
    public void setRuntimeExceptionHandler(RuntimeExceptionHandler runtimeExceptionHandler) {
        this.runtimeExceptionHandler = runtimeExceptionHandler;
    }
}
