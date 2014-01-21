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
package org.coode.patterns.protege.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.io.StringWriter;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.ListCellRenderer;
import javax.swing.SwingUtilities;
import javax.swing.event.ListDataEvent;
import javax.swing.event.ListDataListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableCellRenderer;

import org.coode.oppl.PartialOWLObjectInstantiator;
import org.coode.oppl.Variable;
import org.coode.oppl.bindingtree.BindingNode;
import org.coode.oppl.function.SimpleValueComputationParameters;
import org.coode.oppl.function.ValueComputationParameters;
import org.coode.oppl.protege.ui.ActionList;
import org.coode.oppl.protege.ui.ActionListItem;
import org.coode.oppl.protege.ui.NoDefaultFocusVerifyingOptionPane;
import org.coode.oppl.protege.ui.OPPLMList;
import org.coode.oppl.protege.ui.ShowMessageRuntimeExceptionHandler;
import org.coode.oppl.protege.ui.VariableList;
import org.coode.oppl.protege.ui.VariableListItem;
import org.coode.oppl.variabletypes.InputVariable;
import org.coode.patterns.AbstractPatternModelFactory;
import org.coode.patterns.InstantiatedPatternModel;
import org.coode.patterns.PatternModel;
import org.coode.patterns.locality.LocalityChecker;
import org.coode.patterns.protege.utils.OWLEntitySelector;
import org.coode.patterns.protege.utils.RenderableObjectCellRenderer;
import org.coode.patterns.protege.utils.VariableListModel;
import org.coode.patterns.utils.Utils;
import org.protege.editor.core.ui.list.MList;
import org.protege.editor.core.ui.list.MListButton;
import org.protege.editor.core.ui.list.MListItem;
import org.protege.editor.core.ui.list.MListSectionHeader;
import org.protege.editor.core.ui.util.ComponentFactory;
import org.protege.editor.core.ui.util.InputVerificationStatusChangedListener;
import org.protege.editor.core.ui.util.JOptionPaneEx;
import org.protege.editor.core.ui.util.VerifiedInputEditor;
import org.protege.editor.core.ui.util.VerifyingOptionPane;
import org.protege.editor.owl.OWLEditorKit;
import org.protege.editor.owl.model.inference.NoOpReasoner;
import org.protege.editor.owl.ui.editor.AbstractOWLObjectEditor;
import org.protege.editor.owl.ui.renderer.OWLCellRenderer;
import org.semanticweb.owlapi.model.AddAxiom;
import org.semanticweb.owlapi.model.OWLAxiom;
import org.semanticweb.owlapi.model.OWLAxiomChange;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLEntity;
import org.semanticweb.owlapi.model.OWLObject;
import org.semanticweb.owlapi.model.RemoveAxiom;

/** @author Luigi Iannone Jul 2, 2008 */
public class PatternInstantiationEditor extends
        AbstractOWLObjectEditor<InstantiatedPatternModel> implements VerifiedInputEditor,
        ListDataListener, ListSelectionListener {
    private final class PatternListActionListener implements ActionListener {
        final PatternInstantiationEditor pie;

        public PatternListActionListener(PatternInstantiationEditor _this) {
            pie = _this;
        }

        @Override
        public void actionPerformed(ActionEvent event) {
            pie.instantiatedPatternModel = null;
            Object selectedItem = pie.patternList.getSelectedItem();
            if (selectedItem instanceof InstantiatedPatternModel) {
                pie.instantiatedPatternModel = (InstantiatedPatternModel) selectedItem;
                if (pie.owlClass != null) {
                    pie.instantiatedPatternModel.instantiate(pie.instantiatedPatternModel
                            .getConstraintSystem().getThisClassVariable(), owlClass);
                }
                pie.refreshInstantiationPanel();
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        pie.refreshEffectsPanel();
                    }
                });
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        pie.handleChange();
                    }
                });
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        pie.variableList.setSelectedIndex(0);
                    }
                });
                pie.handleChange();
            }
        }
    }

    static final class SpecializedListCellRenderer implements ListCellRenderer {
        private final OWLCellRenderer owlCellRenderer;

        public SpecializedListCellRenderer(OWLEditorKit kit) {
            owlCellRenderer = new OWLCellRenderer(kit);
        }

        @Override
        public Component getListCellRendererComponent(JList list, Object value,
                int index, boolean isSelected, boolean cellHasFocus) {
            if (value instanceof VariableValueListItem) {
                return owlCellRenderer.getListCellRendererComponent(list,
                        ((VariableValueListItem) value).getValue(), index, isSelected,
                        cellHasFocus);
            }
            return owlCellRenderer.getListCellRendererComponent(list, value, index,
                    isSelected, cellHasFocus);
        }
    }

    private class VariableValuesMList extends OPPLMList {
        private static final long serialVersionUID = 20100L;
        protected final Variable<?> variable;

        @Override
        protected void handleAdd() {
            final VariableValueEditor variableValueEditor = VariableValueEditor
                    .getVariableValueEditor(owlEditorKit, variable);
            final VerifyingOptionPane optionPane = new NoDefaultFocusVerifyingOptionPane(
                    variableValueEditor);
            final InputVerificationStatusChangedListener verificationListener = new InputVerificationStatusChangedListener() {
                @Override
                public void verifiedStatusChanged(boolean verified) {
                    optionPane.setOKEnabled(verified);
                }
            };
            variableValueEditor.addStatusChangedListener(verificationListener);
            final JDialog dlg = optionPane
                    .createDialog(owlEditorKit.getWorkspace(), null);
            dlg.setModal(true);
            dlg.setTitle(variableValueEditor.getTitle());
            dlg.setResizable(true);
            dlg.pack();
            dlg.setLocationRelativeTo(owlEditorKit.getWorkspace());
            dlg.addComponentListener(new ComponentAdapter() {
                @Override
                public void componentHidden(ComponentEvent e) {
                    Object retVal = optionPane.getValue();
                    if (retVal != null && retVal.equals(JOptionPane.OK_OPTION)) {
                        Set<OWLObject> variableValues = variableValueEditor
                                .getVariableValues();
                        for (OWLObject object : variableValues) {
                            instantiatedPatternModel.instantiate(variable, object);
                            getDefaultModel().addElement(
                                    new VariableValueListItem(variable, object));
                        }
                    }
                    variableValueEditor.removeStatusChangedListener(verificationListener);
                    variableValueEditor.dispose();
                }
            });
            dlg.setVisible(true);
        }

        VariableValuesMList() {
            variable = null;
            DefaultListModel<Object> model = new DefaultListModel<Object>();
            super.setModel(model);
            model.addElement(new MListSectionHeader() {
                @Override
                public boolean canAdd() {
                    return false;
                }

                @Override
                public String getName() {
                    return "No pattern selected yet";
                }
            });
            setCellRenderer(new SpecializedListCellRenderer(owlEditorKit));
        }

        public VariableValuesMList(Variable<?> variable) {
            this.variable = variable;
            DefaultListModel<Object> model = new DefaultListModel<Object>();
            super.setModel(model);
            model.addElement(new MListSectionHeader() {
                @Override
                public boolean canAdd() {
                    return true;
                }

                @Override
                public String getName() {
                    return VariableValuesMList.this.variable.getName();
                }
            });
            setCellRenderer(new SpecializedListCellRenderer(owlEditorKit));
        }

        @Override
        protected void handleDelete() {
            if (getSelectedValue() instanceof VariableValueListItem) {
                VariableValueListItem item = (VariableValueListItem) getSelectedValue();
                Variable<?> v = item.getVariable();
                OWLObject value = item.getValue();
                instantiatedPatternModel.removeInstantiation(v, value);
            }
            getDefaultModel().removeElement(getSelectedValue());
            super.handleDelete();
        }
    }

    private class VariableValueListItem implements MListItem {
        private final Variable<?> variable;
        private final OWLObject value;

        /** @param variable
         *            variable
         * @param value
         *            value */
        public VariableValueListItem(Variable<?> variable, OWLObject value) {
            this.variable = variable;
            this.value = value;
        }

        @Override
        public String getTooltip() {
            return owlEditorKit.getModelManager().getRendering(value);
        }

        @Override
        public boolean handleDelete() {
            return true;
        }

        @Override
        public void handleEdit() {}

        @Override
        public boolean isDeleteable() {
            return true;
        }

        @Override
        public boolean isEditable() {
            return false;
        }

        /** @return the variable */
        public Variable<?> getVariable() {
            return variable;
        }

        /** @return the value */
        public OWLObject getValue() {
            return value;
        }
    }

    private final static class InstantiatedPatternCellRenderer implements
            ListCellRenderer {
        public InstantiatedPatternCellRenderer() {}

        private final static DefaultListCellRenderer DELEGATE = new DefaultListCellRenderer();

        @Override
        public Component getListCellRendererComponent(JList list, Object value,
                int index, boolean isSelected, boolean cellHasFocus) {
            Component toReturn = DELEGATE.getListCellRendererComponent(list, value,
                    index, isSelected, cellHasFocus);
            if (value instanceof InstantiatedPatternModel) {
                InstantiatedPatternModel instantiatedPatternModel = (InstantiatedPatternModel) value;
                StringWriter writer = new StringWriter();
                writer.append(instantiatedPatternModel.getName());
                writer.append("(");
                List<InputVariable<?>> inputVariables = instantiatedPatternModel
                        .getInputVariables();
                boolean first = true;
                for (Variable<?> inputVariable : inputVariables) {
                    String comma = first ? "" : ", ";
                    first = first ? false : first;
                    writer.append(comma);
                    writer.append(inputVariable.getName());
                }
                writer.append(")");
                toReturn = DELEGATE.getListCellRendererComponent(list, writer.toString(),
                        index, isSelected, cellHasFocus);
            }
            return toReturn;
        }
    }

    private final class LocalityResultActionListener implements ActionListener {
        LocalityResultActionListener() {}

        @Override
        public void actionPerformed(ActionEvent e) {
            JTable table = new JTable(localityChecker.print());
            table.setGridColor(Color.black);
            table.setDefaultRenderer(String.class, new TableCellRenderer() {
                private final JLabel safeFalse = new JLabel(localityChecker
                        .generateIcon(Color.red));
                private final JLabel safeTrue = new JLabel(localityChecker
                        .generateIcon(Color.green));
                private final JCheckBox present = new JCheckBox("", true);
                private final JCheckBox absent = new JCheckBox("", false);

                @Override
                public Component getTableCellRendererComponent(JTable t, Object value,
                        boolean isSelected, boolean hasFocus, int row, int column) {
                    if (value.equals(Boolean.toString(false))) {
                        return safeFalse;
                    }
                    if (value.equals(Boolean.toString(true))) {
                        return safeTrue;
                    }
                    if (value.equals("X")) {
                        return present;
                    }
                    return absent;
                }
            });
            JScrollPane report = ComponentFactory.createScrollPane(table);
            final VerifyingOptionPane optionPane = new VerifyingOptionPane(report);
            final JDialog dlg = optionPane
                    .createDialog(owlEditorKit.getWorkspace(), null);
            // The editor shouldn't be modal (or should it?)
            dlg.setModal(false);
            dlg.setTitle("Safety analysis breakdown");
            dlg.setResizable(true);
            dlg.pack();
            dlg.setLocationRelativeTo(owlEditorKit.getWorkspace());
            dlg.setVisible(true);
        }
    }

    protected final OWLEditorKit owlEditorKit;
    private JPanel mainPane;
    private final ShowMessageRuntimeExceptionHandler showMessageRuntimeExceptionHandler;
    private final DefaultComboBoxModel<Object> patternListModel = new DefaultComboBoxModel();
    protected JComboBox patternList = new JComboBox(patternListModel);
    protected InstantiatedPatternModel instantiatedPatternModel;
    private final Set<InputVerificationStatusChangedListener> listeners = new HashSet<InputVerificationStatusChangedListener>();
    private JPanel effectsBorder;
    private ActionList actionList;
    private JSplitPane instantiationPanel;
    protected OWLClass owlClass = null;
    private InstantiatedPatternModel instantantiatedPatternModel2CopyFrom = null;
    protected VariableList variableList;
    private VariableValuesMList valueList;
    private JScrollPane variablePane;
    private JScrollPane valuePane;
    private final JPanel problemPanel = new JPanel(new BorderLayout());
    private final DefaultListModel<Object> problemListModel = new DefaultListModel<Object>();
    private final JList<Object> problemList = new JList<Object>(problemListModel);
    private final AbstractPatternModelFactory factory;
    private final JButton localityCheckResultButton = new JButton();
    private final JButton localityCheckButton = new JButton("Check Locality");
    private final JButton localityCheckPreferenceButton = new JButton("Signature");
    protected LocalityCheckerActionListener localityChecker;
    protected final Set<OWLEntity> localityCheckerSignature = new HashSet<OWLEntity>();
    protected final VariableListModel<OWLEntity> localityCheckerSignatureModel = new VariableListModel<OWLEntity>(
            localityCheckerSignature, "Signature elements");
    private JPanel buttonPanel;
    private final JLabel reasonerWarning = new JLabel();

    /** Builds a PatternInstantiationEditor for a specific class, i.e.: an editor
     * for instantiating class patterns
     * 
     * @param owlEditorKit
     *            owlEditorKit
     * @param owlClass
     *            owlClass
     * @param f
     *            f */
    public PatternInstantiationEditor(OWLEditorKit owlEditorKit, OWLClass owlClass,
            AbstractPatternModelFactory f) {
        this(owlEditorKit, f);
        this.owlClass = owlClass;
    }

    /** Builds a PatternInstantiationEditor for instantiating non-class patterns
     * 
     * @param owlEditorKit
     *            owlEditorKit
     * @param f
     *            f */
    public PatternInstantiationEditor(OWLEditorKit owlEditorKit,
            AbstractPatternModelFactory f) {
        this.owlEditorKit = owlEditorKit;
        factory = f;
        mainPane = new JPanel(new BorderLayout());
        mainPane.setFocusable(false);
        localityCheckerSignature.addAll(LocalityChecker.collectEntities(this.owlEditorKit
                .getOWLModelManager().getOntologies()));
        localityCheckerSignatureModel.init();
        localityCheckResultButton.addActionListener(new LocalityResultActionListener());
        showMessageRuntimeExceptionHandler = new ShowMessageRuntimeExceptionHandler(
                this.owlEditorKit.getOWLWorkspace());
        localityChecker = new LocalityCheckerActionListener(this.owlEditorKit,
                localityCheckerSignature, localityCheckResultButton,
                showMessageRuntimeExceptionHandler);
        localityCheckButton.addActionListener(localityChecker);
        localityCheckPreferenceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MList list = new MList() {
                    private static final long serialVersionUID = 20100L;

                    @Override
                    protected List<MListButton> getButtons(Object value) {
                        // TODO Auto-generated method stub
                        return super.getButtons(value);
                    }

                    @Override
                    protected void handleAdd() {
                        OWLEntitySelector oes = new OWLEntitySelector(
                                PatternInstantiationEditor.this.owlEditorKit);
                        int ret = JOptionPaneEx.showValidatingConfirmDialog(getParent(),
                                "Add an entity to the signature", oes,
                                JOptionPane.PLAIN_MESSAGE, JOptionPane.OK_CANCEL_OPTION,
                                oes);
                        if (ret == JOptionPane.OK_OPTION) {
                            OWLEntity toAdd = oes.getOWLClass();
                            if (toAdd != null) {
                                localityCheckerSignature.add(toAdd);
                            }
                        }
                        localityCheckerSignatureModel.init();
                    }

                    @Override
                    protected void handleDelete() {
                        localityCheckerSignature
                                .remove(((VariableListModel.VariableListItem<OWLEntity>) getSelectedValue())
                                        .getItem());
                        localityCheckerSignatureModel.init();
                    }
                };
                list.setModel(localityCheckerSignatureModel);
                list.setCellRenderer(new RenderableObjectCellRenderer(
                        PatternInstantiationEditor.this.owlEditorKit));
                JScrollPane pane = ComponentFactory.createScrollPane(list);
                final VerifyingOptionPane optionPane = new VerifyingOptionPane(pane);
                final JDialog dlg = optionPane.createDialog(
                        PatternInstantiationEditor.this.owlEditorKit.getWorkspace(), null);
                // The editor shouldn't be modal (or should it?)
                dlg.setModal(false);
                dlg.setTitle("Current signature");
                dlg.setResizable(true);
                dlg.pack();
                dlg.setLocationRelativeTo(PatternInstantiationEditor.this.owlEditorKit
                        .getWorkspace());
                dlg.setVisible(true);
            }
        });
        buttonPanel = new JPanel(new BorderLayout());
        buttonPanel.add(localityCheckResultButton, BorderLayout.WEST);
        buttonPanel.add(localityCheckButton, BorderLayout.CENTER);
        buttonPanel.add(localityCheckPreferenceButton, BorderLayout.EAST);
        buttonPanel.add(reasonerWarning, BorderLayout.SOUTH);
        checkReasoner();
        localityCheckerSignatureModel.addListDataListener(new ListDataListener() {
            @Override
            public void intervalRemoved(ListDataEvent e) {
                PatternInstantiationEditor.this.handleChange();
            }

            @Override
            public void intervalAdded(ListDataEvent e) {
                PatternInstantiationEditor.this.handleChange();
            }

            @Override
            public void contentsChanged(ListDataEvent e) {
                PatternInstantiationEditor.this.handleChange();
            }
        });
        setup();
    }

    private void setup() {
        mainPane.setPreferredSize(new Dimension(500, 600));
        refillPatternList();
        patternList.setPreferredSize(new Dimension(50, 20));
        patternList.addActionListener(new PatternListActionListener(this));
        JPanel namePanel = new JPanel(new BorderLayout());
        namePanel.setBorder(ComponentFactory.createTitledBorder("Pattern:"));
        namePanel.add(ComponentFactory.createScrollPane(patternList), BorderLayout.NORTH);
        problemPanel.setBorder(ComponentFactory.createTitledBorder("Problems"));
        problemPanel.add(ComponentFactory.createScrollPane(problemList));
        namePanel.add(problemPanel, BorderLayout.SOUTH);
        JPanel editorPanel = new JPanel(new BorderLayout());
        editorPanel.add(namePanel);
        instantiationPanel = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
        instantiationPanel.setBorder(ComponentFactory.createTitledBorder("Variables:"));
        instantiationPanel.setDividerLocation(.5);
        variableList = new VariableList(owlEditorKit, factory.createConstraintSystem());
        valueList = new VariableValuesMList();
        variablePane = ComponentFactory.createScrollPane(variableList);
        instantiationPanel.add(variablePane, JSplitPane.LEFT);
        valuePane = ComponentFactory.createScrollPane(valueList);
        instantiationPanel.add(valuePane, JSplitPane.RIGHT);
        effectsBorder = new JPanel(new BorderLayout());
        effectsBorder.setBorder(ComponentFactory.createTitledBorder("Effects: "));
        actionList = new ActionList(owlEditorKit,
                instantiatedPatternModel == null ? factory.createConstraintSystem()
                        : instantiatedPatternModel.getConstraintSystem(), false);
        effectsBorder.add(ComponentFactory.createScrollPane(actionList),
                BorderLayout.CENTER);
        mainPane.add(editorPanel, BorderLayout.NORTH);
        JSplitPane centerPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
        centerPane.add(instantiationPanel, JSplitPane.TOP);
        centerPane.add(effectsBorder, JSplitPane.BOTTOM);
        centerPane.setDividerLocation(.5);
        mainPane.add(centerPane, BorderLayout.CENTER);
        mainPane.add(buttonPanel, BorderLayout.SOUTH);
        localityCheckButton.setEnabled(false);
    }

    private void refillPatternList() {
        patternListModel.removeAllElements();
        Set<String> existingPatternNames = Utils.getExistingPatternNames(owlEditorKit
                .getModelManager().getOWLOntologyManager());
        patternList.setRenderer(new InstantiatedPatternCellRenderer());
        for (String string : existingPatternNames) {
            PatternModel patternModel = Utils.find(string, owlEditorKit.getModelManager()
                    .getOWLOntologyManager(), factory);
            if (patternModel != null) {
                InstantiatedPatternModel toAdd = factory.createInstantiatedPatternModel(
                        patternModel, showMessageRuntimeExceptionHandler);
                patternListModel.addElement(toAdd);
                patternList.setSelectedItem(null);
            }
        }
    }

    @Override
    public boolean setEditedObject(InstantiatedPatternModel editedObject) {
        setInstantiatedPatternModel(editedObject);
        return true;
    }

    @Override
    public void dispose() {
        valueList.getModel().removeListDataListener(this);
        variableList.removeListSelectionListener(this);
    }

    @Override
    public InstantiatedPatternModel getEditedObject() {
        return instantiatedPatternModel;
    }

    @Override
    public JComponent getEditorComponent() {
        return mainPane;
    }

    /** @param newState
     *            newState
     * @param listener
     *            listener */
    private void notifyListener(boolean newState,
            InputVerificationStatusChangedListener listener) {
        listener.verifiedStatusChanged(newState);
    }

    @Override
    public void addStatusChangedListener(InputVerificationStatusChangedListener listener) {
        listeners.add(listener);
        notifyListener(check(), listener);
    }

    @Override
    public void removeStatusChangedListener(
            InputVerificationStatusChangedListener listener) {
        listeners.remove(listener);
    }

    protected void refreshEffectsPanel() {
        actionList.getDefaultModel().clear();
        if (instantiatedPatternModel != null) {
            actionList
                    .setConstraintSystem(instantiatedPatternModel.getConstraintSystem());
            PatternModel instantiatedPattern = instantiatedPatternModel
                    .getInstantiatedPattern();
            List<OWLAxiomChange> actions = instantiatedPattern.getActions();
            Set<OWLAxiomChange> changes = new HashSet<OWLAxiomChange>(actions.size());
            Set<BindingNode> bindingNodes = instantiatedPatternModel
                    .extractBindingNodes();
            if (bindingNodes.isEmpty()) {
                BindingNode bindingNode = new BindingNode(
                        instantiatedPattern.getInputVariables());
                ValueComputationParameters parameters = new SimpleValueComputationParameters(
                        instantiatedPatternModel.getConstraintSystem(), bindingNode,
                        showMessageRuntimeExceptionHandler);
                PartialOWLObjectInstantiator instantiator = new PartialOWLObjectInstantiator(
                        parameters);
                for (OWLAxiomChange change : actions) {
                    OWLAxiom axiom = change.getAxiom();
                    OWLAxiom instantiatedAxiom = (OWLAxiom) axiom.accept(instantiator);
                    OWLAxiomChange newAxiomChange = change.isAddAxiom() ? new AddAxiom(
                            change.getOntology(), instantiatedAxiom) : new RemoveAxiom(
                            change.getOntology(), instantiatedAxiom);
                    changes.add(newAxiomChange);
                }
            } else {
                instantiatedPatternModel.getConstraintSystem().setLeaves(bindingNodes);
                for (BindingNode bindingNode : bindingNodes) {
                    ValueComputationParameters parameters = new SimpleValueComputationParameters(
                            instantiatedPatternModel.getConstraintSystem(), bindingNode,
                            showMessageRuntimeExceptionHandler);
                    PartialOWLObjectInstantiator instantiator = new PartialOWLObjectInstantiator(
                            parameters);
                    for (OWLAxiomChange change : actions) {
                        OWLAxiom axiom = change.getAxiom();
                        OWLAxiom instantiatedAxiom = (OWLAxiom) axiom
                                .accept(instantiator);
                        OWLAxiomChange newAxiomChange = change.isAddAxiom() ? new AddAxiom(
                                change.getOntology(), instantiatedAxiom)
                                : new RemoveAxiom(change.getOntology(), instantiatedAxiom);
                        changes.add(newAxiomChange);
                    }
                }
            }
            for (OWLAxiomChange axiomChange : changes) {
                actionList.getDefaultModel().addElement(
                        new ActionListItem(axiomChange, false, false));
            }
        }
        handleChange();
        mainPane.revalidate();
    }

    protected void refreshInstantiationPanel() {
        DefaultListModel<Object> model = variableList.getDefaultModel();
        model.clear();
        valueList.getDefaultModel().clear();
        if (instantiatedPatternModel != null) {
            List<InputVariable<?>> inputVariables = instantiatedPatternModel
                    .getInputVariables();
            for (InputVariable<?> inputVariable : inputVariables) {
                model.addElement(new VariableListItem(inputVariable,
                        instantiatedPatternModel.getConstraintSystem(), owlEditorKit,
                        false, false) {
                    @Override
                    public String getTooltip() {
                        return getVariable().toString();
                    }
                });
            }
            variableList.addListSelectionListener(this);
            if (instantantiatedPatternModel2CopyFrom != null) {
                for (Variable<?> inputVariable : inputVariables) {
                    Set<OWLObject> instantiations = instantantiatedPatternModel2CopyFrom
                            .getInstantiations(inputVariable);
                    if (instantiations != null) {
                        for (OWLObject object : instantiations) {
                            instantiatedPatternModel.instantiate(inputVariable, object);
                        }
                    }
                }
                instantantiatedPatternModel2CopyFrom = null;
            }
        }
    }

    void checkReasoner() {
        if (owlEditorKit.getOWLModelManager().getReasoner() instanceof NoOpReasoner) {
            reasonerWarning.setText("Warning: no reasoner selected.");
        } else {
            reasonerWarning.setText("");
        }
    }

    /** change listener */
    public void handleChange() {
        checkReasoner();
        boolean newState = check();
        for (InputVerificationStatusChangedListener listener : listeners) {
            notifyListener(newState, listener);
        }
        localityCheckButton.removeActionListener(localityChecker);
        localityChecker = new LocalityCheckerActionListener(owlEditorKit,
                localityCheckerSignature, localityCheckResultButton,
                showMessageRuntimeExceptionHandler);
        localityCheckButton.addActionListener(localityChecker);
        localityChecker.setInstantiatedPatternModel(instantiatedPatternModel);
        if (instantiatedPatternModel != null) {
            localityCheckButton.setEnabled(true);
        } else {
            localityCheckButton.setEnabled(false);
        }
        problemPanel.setVisible(!problemListModel.isEmpty());
    }

    private boolean check() {
        boolean valid = instantiatedPatternModel != null ? instantiatedPatternModel
                .isValid() : false;
        return valid;
    }

    /** @param patternModel
     *            patternModel */
    public void setInstantiatedPatternModel(InstantiatedPatternModel patternModel) {
        mainPane.removeAll();
        setup();
        if (patternModel != null) {
            instantantiatedPatternModel2CopyFrom = patternModel;
            boolean found = false;
            for (int i = 0; i < patternListModel.getSize() && !found; i++) {
                Object element = patternListModel.getElementAt(i);
                found = element instanceof InstantiatedPatternModel
                        && patternModel.getName().equals(
                                ((InstantiatedPatternModel) element).getName());
                if (found) {
                    patternList.setSelectedItem(element);
                }
            }
        }
    }

    @Override
    public void contentsChanged(ListDataEvent e) {
        refreshEffectsPanel();
    }

    @Override
    public void intervalAdded(ListDataEvent e) {
        refreshEffectsPanel();
    }

    @Override
    public void intervalRemoved(ListDataEvent e) {
        refreshEffectsPanel();
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        Object selectedValue = variableList.getSelectedValue();
        valueList.getModel().removeListDataListener(this);
        instantiationPanel.remove(variablePane);
        instantiationPanel.remove(valuePane);
        if (selectedValue instanceof VariableListItem) {
            VariableListItem item = (VariableListItem) selectedValue;
            Variable<?> variable = item.getVariable();
            valueList = new VariableValuesMList(variable);
            valueList.getModel().addListDataListener(this);
            Set<OWLObject> instantiations = instantiatedPatternModel
                    .getInstantiations(variable);
            if (instantiations != null) {
                for (OWLObject object : instantiations) {
                    valueList.getDefaultModel().addElement(
                            new VariableValueListItem(variable, object) {
                                @Override
                                public String getTooltip() {
                                    return getVariable().toString();
                                }
                            });
                }
            }
            valuePane = ComponentFactory.createScrollPane(valueList);
        }
        instantiationPanel.add(variablePane, JSplitPane.LEFT);
        instantiationPanel.add(valuePane, JSplitPane.RIGHT);
        mainPane.revalidate();
    }

    @Override
    public String getEditorTypeName() {
        return "Instantiated Pattern Editor";
    }

    @Override
    public boolean canEdit(Object object) {
        return true;
    }
}
