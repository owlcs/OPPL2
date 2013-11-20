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
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Set;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JToolBar;
import javax.swing.event.ListDataEvent;
import javax.swing.event.ListDataListener;

import org.coode.oppl.ConstraintSystem;
import org.coode.oppl.OWLObjectAbstractor;
import org.coode.oppl.PartialOWLObjectInstantiator;
import org.coode.oppl.Variable;
import org.coode.oppl.VariableScope;
import org.coode.oppl.bindingtree.Assignment;
import org.coode.oppl.bindingtree.BindingNode;
import org.coode.oppl.exceptions.RuntimeExceptionHandler;
import org.coode.oppl.function.SimpleValueComputationParameters;
import org.coode.oppl.protege.ProtegeParserFactory;
import org.coode.oppl.protege.ui.rendering.VariableOWLCellRenderer;
import org.coode.oppl.utils.AbstractVariableVisitorExAdapter;
import org.coode.oppl.variabletypes.InputVariable;
import org.protege.editor.core.ui.util.ComponentFactory;
import org.protege.editor.owl.model.OWLModelManager;
import org.protege.editor.owl.ui.renderer.OWLCellRenderer;
import org.protege.editor.owl.ui.view.AbstractOWLViewComponent;
import org.semanticweb.owlapi.model.AddAxiom;
import org.semanticweb.owlapi.model.OWLAxiom;
import org.semanticweb.owlapi.model.OWLAxiomChange;
import org.semanticweb.owlapi.model.OWLDeclarationAxiom;
import org.semanticweb.owlapi.model.OWLEntity;
import org.semanticweb.owlapi.model.OWLException;
import org.semanticweb.owlapi.model.OWLObject;
import org.semanticweb.owlapi.model.OWLOntologyChange;
import org.semanticweb.owlapi.model.OWLOntologyChangeListener;
import org.semanticweb.owlapi.model.RemoveAxiom;

/** View that allows to record macros in OPPL
 * 
 * @author Luigi Iannone */
public class OPPLMacroView extends AbstractOWLViewComponent implements
        OWLOntologyChangeListener, ListDataListener, OPPLMacroListener {
    private static final long serialVersionUID = 20100L;
    private RuntimeExceptionHandler runtimeExceptionHandler;
    protected ActionList recordedActions;
    private OWLObjectList entities;
    protected VariableList variableList;
    protected JButton recordButton;
    protected JButton stopButton;
    private JButton copy2ClipboardButton;
    private JButton clearButton;
    private ConstraintSystem constraintSystem;

    @Override
    public void initialiseOWLView() {
        constraintSystem = ProtegeParserFactory.getInstance(getOWLEditorKit())
                .getOPPLFactory().createConstraintSystem();
        runtimeExceptionHandler = new ShowMessageRuntimeExceptionHandler(this);
        setLayout(new BorderLayout());
        recordedActions = new ActionList(getOWLEditorKit(), constraintSystem, false);
        JScrollPane recordedActionsScrollPane = ComponentFactory
                .createScrollPane(recordedActions);
        JPanel recordedActionBorderPanel = new JPanel(new BorderLayout());
        recordedActionBorderPanel.setBorder(ComponentFactory
                .createTitledBorder("Recorded actions"));
        recordedActionBorderPanel.add(recordedActionsScrollPane);
        JToolBar recorderToolBar = new JToolBar();
        recordButton = new JButton(new ImageIcon(this.getClass().getClassLoader()
                .getResource("record-button.jpg")));
        recordButton.setToolTipText("Start Recording");
        recordButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                OWLModelManager modelManager = OPPLMacroView.this.getOWLEditorKit()
                        .getModelManager();
                modelManager.addOntologyChangeListener(OPPLMacroView.this);
                stopButton.setEnabled(true);
                recordButton.setEnabled(false);
            }
        });
        stopButton = new JButton(new ImageIcon(this.getClass().getClassLoader()
                .getResource("stop-button.jpg")));
        stopButton.setToolTipText("Stop Recording");
        stopButton.setEnabled(false);
        stopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                OPPLMacroView.this.getOWLEditorKit().getModelManager()
                        .removeOntologyChangeListener(OPPLMacroView.this);
                recordButton.setEnabled(true);
                stopButton.setEnabled(false);
            }
        });
        copy2ClipboardButton = new JButton(new ImageIcon(this.getClass().getClassLoader()
                .getResource("copy2Cipboard.jpg")));
        copy2ClipboardButton.setToolTipText("Copy OPPL");
        copy2ClipboardButton.setEnabled(false);
        copy2ClipboardButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StringBuilder opplString = new StringBuilder();
                DefaultListModel<Object> variableModel = variableList.getDefaultModel();
                boolean first = true;
                for (int i = 0; i < variableModel.getSize(); i++) {
                    Object variableElement = variableModel.getElementAt(i);
                    if (variableElement instanceof VariableListItem) {
                        Variable<?> v = ((VariableListItem) variableElement)
                                .getVariable();
                        String variableString = " " + v.toString();
                        VariableScope<?> variableScope = v
                                .accept(new AbstractVariableVisitorExAdapter<VariableScope<?>>(
                                        null) {
                                    @Override
                                    public <P extends OWLObject> VariableScope<?> visit(
                                            InputVariable<P> v) {
                                        return v.getVariableScope();
                                    }
                                });
                        if (variableScope != null) {
                            String scopeString = "["
                                    + variableScope.getDirection().toString()
                                    + " "
                                    + OPPLMacroView.this.getOWLModelManager()
                                            .getRendering(
                                                    variableScope.getScopingObject())
                                    + "]";
                            variableString += scopeString;
                        }
                        if (!first) {
                            opplString.append(',');
                        }
                        first = false;
                        opplString.append(variableString);
                    }
                }
                first = true;
                DefaultListModel<Object> actionModel = recordedActions.getDefaultModel();
                opplString.append("\nBEGIN");
                VariableOWLCellRenderer cellRenderer = new VariableOWLCellRenderer(
                        OPPLMacroView.this.getOWLEditorKit(), constraintSystem,
                        new OWLCellRenderer(OPPLMacroView.this.getOWLEditorKit()));
                for (int i = 0; i < actionModel.getSize(); i++) {
                    Object actionElement = actionModel.getElementAt(i);
                    if (actionElement instanceof ActionListItem) {
                        OWLAxiomChange axiomChange = ((ActionListItem) actionElement)
                                .getAxiomChange();
                        String isCommaThere = first ? "" : ",";
                        first = false;
                        String action = axiomChange.isAddAxiom() ? " \nADD "
                                : " \nREMOVE ";
                        OWLAxiom axiom = axiomChange.getAxiom();
                        String axiomRendering = cellRenderer.getRendering(axiom);
                        opplString.append(isCommaThere);
                        opplString.append(action);
                        opplString.append(axiomRendering);
                    }
                }
                opplString.append("\nEND;");
                Clipboard c = Toolkit.getDefaultToolkit().getSystemClipboard();
                StringSelection selection = new StringSelection(opplString.toString());
                c.setContents(selection, selection);
            }
        });
        clearButton = new JButton(new ImageIcon(this.getClass().getClassLoader()
                .getResource("clearButton.jpg")));
        clearButton.setToolTipText("Clear all");
        clearButton.setEnabled(false);
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                recordedActions.getDefaultModel().clear();
                variableList.getDefaultModel().clear();
            }
        });
        recorderToolBar.setFloatable(false);
        recorderToolBar.add(recordButton);
        recorderToolBar.add(stopButton);
        recorderToolBar.add(copy2ClipboardButton);
        recorderToolBar.add(clearButton);
        JSplitPane mainPanel = new JSplitPane();
        mainPanel.setBorder(null);
        JPanel recorderPanel = new JPanel(new BorderLayout());
        recorderPanel.add(recorderToolBar, BorderLayout.NORTH);
        recorderPanel.add(recordedActionBorderPanel, BorderLayout.CENTER);
        entities = new OWLObjectList(constraintSystem, getOWLEditorKit());
        entities.addOPPLMacroListener(this);
        entities.setModel(new DefaultListModel<Object>());
        variableList = new VariableList(getOWLEditorKit(), constraintSystem);
        variableList.setModel(new DefaultListModel<Object>());
        variableList.getModel().addListDataListener(entities);
        JScrollPane entitiesPane = ComponentFactory.createScrollPane(entities);
        JPanel entitiesBorderPanel = new JPanel(new BorderLayout());
        entitiesBorderPanel.setBorder(ComponentFactory
                .createTitledBorder("Named entities: "));
        entitiesBorderPanel.add(entitiesPane);
        JScrollPane variablesPane = ComponentFactory.createScrollPane(variableList);
        JPanel variableBorderPanel = new JPanel(new BorderLayout());
        variableBorderPanel.setBorder(ComponentFactory.createTitledBorder("Variables: "));
        variableBorderPanel.add(variablesPane);
        JSplitPane entitiesPanel = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
        entitiesPanel.setBorder(null);
        entitiesPanel.add(entitiesBorderPanel, JSplitPane.TOP);
        entitiesPanel.add(variableBorderPanel, JSplitPane.BOTTOM);
        mainPanel.add(recorderPanel, JSplitPane.LEFT);
        mainPanel.add(entitiesPanel, JSplitPane.RIGHT);
        this.add(mainPanel, BorderLayout.CENTER);
    }

    @Override
    protected void disposeOWLView() {
        getOWLEditorKit().getModelManager().removeOntologyChangeListener(this);
        recordedActions.getModel().removeListDataListener(this);
        getOWLModelManager().removeOntologyChangeListener(this);
        entities.removeOPPLMacroListener(this);
        variableList.getModel().removeListDataListener(entities);
    }

    @Override
    public void ontologiesChanged(List<? extends OWLOntologyChange> changes)
            throws OWLException {
        DefaultListModel<Object> existingListModel = recordedActions.getDefaultModel();
        ActionListModel updatedListModel = new ActionListModel(false);
        updatedListModel.addListDataListener(this);
        recordedActions.setModel(updatedListModel);
        if (existingListModel != null) {
            int size = existingListModel.getSize();
            for (int i = 0; i < size; i++) {
                OWLAxiomChange axiomChange = ((ActionListItem) existingListModel
                        .getElementAt(i)).getAxiomChange();
                updatedListModel.addAction(axiomChange, false, true);
            }
        }
        for (OWLOntologyChange ontologyChange : changes) {
            if (ontologyChange instanceof OWLAxiomChange
                    && !(((OWLAxiomChange) ontologyChange).getAxiom() instanceof OWLDeclarationAxiom)
                    && ((OWLAxiomChange) ontologyChange).getAxiom().isLogicalAxiom()) {
                updatedListModel.addAction((OWLAxiomChange) ontologyChange, false, true);
            }
        }
        revalidate();
    }

    @Override
    public void contentsChanged(ListDataEvent e) {
        clearButton.setEnabled(recordedActions.getModel().getSize() > 0);
        refreshEntities();
    }

    private void refreshEntities() {
        copy2ClipboardButton.setEnabled(recordedActions.getModel().getSize() > 0);
        DefaultListModel<Object> model = recordedActions.getDefaultModel();
        int size = model.getSize();
        DefaultListModel<Object> entitiesModel = entities.getDefaultModel();
        entitiesModel.clear();
        for (int i = 0; i < size; i++) {
            Object element = model.getElementAt(i);
            if (element instanceof ActionListItem) {
                ActionListItem actionListItem = (ActionListItem) element;
                OWLAxiomChange axiomChange = actionListItem.getAxiomChange();
                OWLAxiom axiom = axiomChange.getAxiom();
                Set<OWLEntity> referencedEntities = axiom.getSignature();
                for (OWLEntity entity : referencedEntities) {
                    boolean found = constraintSystem.isVariableIRI(entity.getIRI());
                    for (int j = 0; j < entitiesModel.size() && !found; j++) {
                        Object object = entitiesModel.get(j);
                        if (object instanceof OWLObjectListItem) {
                            OWLObjectListItem item = (OWLObjectListItem) object;
                            found = item.getOwlObject().equals(entity);
                        }
                    }
                    if (!found) {
                        entitiesModel.addElement(new OWLObjectListItem(entity));
                    }
                }
            }
        }
    }

    @Override
    public void intervalAdded(ListDataEvent e) {
        clearButton.setEnabled(recordedActions.getModel().getSize() > 0);
        refreshEntities();
    }

    @Override
    public void intervalRemoved(ListDataEvent e) {
        clearButton.setEnabled(recordedActions.getModel().getSize() > 0);
        refreshEntities();
    }

    @Override
    public void handleGeneralisedOWLObject(Variable<?> variable) {
        VariableListItem variableListItem = new VariableListItem(variable,
                getConstraintSystem(), getOWLEditorKit(), true, true);
        variableListItem.addOPPLMacroListener(this);
        variableList.getDefaultModel().addElement(variableListItem);
        updateActions();
    }

    private void updateActions() {
        List<Variable<?>> variables = entities.getVariables();
        ActionListModel model = (ActionListModel) recordedActions.getModel();
        int size = model.size();
        OWLObjectAbstractor abstractor = new OWLObjectAbstractor(variables,
                new SimpleValueComputationParameters(constraintSystem,
                        BindingNode.createNewEmptyBindingNode(),
                        getRuntimeExceptionHandler()));
        for (int i = 0; i < size; i++) {
            ActionListItem anActionListItem = (ActionListItem) model.remove(i);
            OWLAxiomChange axiomChange = anActionListItem.getAxiomChange();
            OWLAxiom axiom = axiomChange.getAxiom();
            OWLAxiom abstractedAxiom = (OWLAxiom) axiom.accept(abstractor);
            OWLAxiomChange newChange = axiomChange.isAddAxiom() ? new AddAxiom(
                    getOWLModelManager().getActiveOntology(), abstractedAxiom)
                    : new RemoveAxiom(getOWLModelManager().getActiveOntology(),
                            abstractedAxiom);
            model.add(i, new ActionListItem(newChange, false, true));
        }
    }

    @Override
    public void handleDeletedVariable(Variable<?> variable) {
        Set<OWLObject> possibleBindings = getConstraintSystem().getVariableBindings(
                variable, getRuntimeExceptionHandler());
        ActionListModel model = (ActionListModel) recordedActions.getModel();
        for (int i = model.getSize() - 1; i >= 0; i--) {
            Object element = model.getElementAt(i);
            if (element instanceof ActionListItem) {
                model.remove(i);
                ActionListItem item = (ActionListItem) element;
                OWLAxiomChange change = item.getAxiomChange();
                OWLAxiom axiom = change.getAxiom();
                for (OWLObject object : possibleBindings) {
                    BindingNode bindingNode = new BindingNode(new Assignment(variable,
                            object));
                    PartialOWLObjectInstantiator instantiator = new PartialOWLObjectInstantiator(
                            new SimpleValueComputationParameters(constraintSystem,
                                    bindingNode, getRuntimeExceptionHandler()));
                    OWLAxiom instantiatedAxiom = (OWLAxiom) axiom.accept(instantiator);
                    OWLAxiomChange newAxiomChange = change.isAddAxiom() ? new AddAxiom(
                            change.getOntology(), instantiatedAxiom) : new RemoveAxiom(
                            change.getOntology(), instantiatedAxiom);
                    ActionListItem newItem = new ActionListItem(newAxiomChange, false,
                            true);
                    model.addElement(newItem);
                }
            }
        }
    }

    @Override
    public void handleGeneralisedOWLObject(Variable<?> variable, OWLObject owlObject) {
        updateActions();
    }

    /** @return the constraintSystem */
    public ConstraintSystem getConstraintSystem() {
        return constraintSystem;
    }

    /** @return the runtimeExceptionHandler */
    public RuntimeExceptionHandler getRuntimeExceptionHandler() {
        return runtimeExceptionHandler;
    }
}
