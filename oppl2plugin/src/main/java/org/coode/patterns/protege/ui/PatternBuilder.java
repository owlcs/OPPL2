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
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.KeyListener;
import java.io.Serializable;
import java.util.*;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListDataEvent;
import javax.swing.event.ListDataListener;

import org.coode.oppl.ConstraintSystem;
import org.coode.oppl.Variable;
import org.coode.oppl.VariableVisitorEx;
import org.coode.oppl.generated.GeneratedVariable;
import org.coode.oppl.generated.RegexpGeneratedVariable;
import org.coode.oppl.protege.ui.*;
import org.coode.oppl.protege.ui.message.Error;
import org.coode.oppl.protege.ui.message.MessageListCellRenderer;
import org.coode.oppl.variabletypes.InputVariable;
import org.coode.parsers.ui.InputVerificationStatusChangedListener;
import org.coode.parsers.ui.VerifiedInputEditor;
import org.coode.patterns.*;
import org.protege.editor.core.ui.util.ComponentFactory;
import org.protege.editor.core.ui.util.VerifyingOptionPane;
import org.protege.editor.owl.OWLEditorKit;
import org.protege.editor.owl.ui.editor.AbstractOWLObjectEditor;
import org.semanticweb.owlapi.model.OWLAxiom;
import org.semanticweb.owlapi.model.OWLAxiomChange;
import org.semanticweb.owlapi.model.OWLObject;

/**
 * @author Luigi Iannone Jun 10, 2008
 */
public class PatternBuilder extends AbstractOWLObjectEditor<PatternModel>implements
    VerifiedInputEditor, PatternModelChangeListener, HasPatternModel, Serializable {

    private final class PatternBuilderModel {

        private String name = "";
        private final List<Variable<?>> variables = new ArrayList<>();
        private final List<OWLAxiomChange> actions = new ArrayList<>();
        private Variable<?> returnVariable = null;
        private String modelRendering = "";
        private PatternConstraintSystem constraintSystem;

        public PatternBuilderModel(AbstractPatternModelFactory factory) {
            constraintSystem = factory.createConstraintSystem();
        }

        /**
         * @return the name
         */
        public String getName() {
            return name;
        }

        /**
         * @param name
         *        the name to set
         */
        public void setName(String name) {
            boolean changed = this.name == null && name != null
                || !this.name.equals(name);
            if (changed) {
                this.name = name;
                notifyBuilder();
            }
        }

        /**
         * @return the returnVariable
         */
        public Variable<?> getReturnVariable() {
            return returnVariable;
        }

        /**
         * @param returnVariable
         *        the returnVariable to set
         */
        public void setReturnVariable(Variable<?> returnVariable) {
            boolean changed = this.returnVariable == null && returnVariable != null
                || !this.returnVariable.equals(returnVariable);
            if (changed) {
                this.returnVariable = returnVariable;
                notifyBuilder();
            }
        }

        /**
         * @return the variables
         */
        public List<Variable<?>> getVariables() {
            return new ArrayList<>(variables);
        }

        public void addVariable(Variable<?> v) {
            boolean modified = variables.add(v);
            if (modified) {
                constraintSystem.importVariable(v);
                notifyBuilder();
            }
        }

        public void removeVariable(Variable<?> v) {
            boolean modified = variables.remove(v);
            if (modified) {
                purgeActions(v);
                constraintSystem.removeVariable(v);
                notifyBuilder();
            }
        }

        /**
         * @return the actions
         */
        public List<OWLAxiomChange> getActions() {
            return new ArrayList<>(actions);
        }

        public void addAction(OWLAxiomChange action) {
            boolean modified = actions.add(action);
            if (modified) {
                notifyBuilder();
            }
        }

        public void removeAction(OWLAxiomChange action) {
            boolean modified = actions.remove(action);
            if (modified) {
                notifyBuilder();
            }
        }

        public boolean check() {
            boolean validName = name.matches("\\S+");
            if (!validName) {
                errorListModel.addElement(new Error("Invalid name"));
            }
            boolean enoughVariables = !variables.isEmpty();
            boolean enoughActions = !actions.isEmpty();
            if (!enoughVariables) {
                errorListModel.addElement(new Error("No Variables"));
            }
            if (!enoughActions) {
                errorListModel.addElement(new Error("No actions"));
            }
            boolean found = false;
            if (modelRendering != null) {
                StringTokenizer tokenizer = new StringTokenizer(modelRendering);
                while (tokenizer.hasMoreTokens()) {
                    String token = tokenizer.nextToken();
                    if (token.startsWith("?")) {
                        String variableName = token.trim();
                        found = !existsVariable(variableName);
                        if (found) {
                            errorListModel.addElement(new Error("Invalid variable name "
                                + variableName));
                        }
                    }
                }
            }
            return validName && enoughVariables && enoughActions && !found;
        }

        private boolean existsVariable(String variableName) {
            boolean found = false;
            Iterator<Variable<?>> it = variables.iterator();
            while (!found && it.hasNext()) {
                found = it.next().getName().equals(variableName);
            }
            return found;
        }

        /**
         * @return the rendering
         */
        public String getRendering() {
            return modelRendering;
        }

        /**
         * @param rendering
         *        the rendering to set
         */
        public void setRendering(String rendering) {
            boolean changed = modelRendering == null && rendering != null
                || !modelRendering.equals(rendering);
            if (changed) {
                modelRendering = rendering;
                notifyBuilder();
            }
        }

        public void notifyBuilder() {
            handleChange();
        }

        public void importPatternModel(PatternModel pattern) {
            if (pattern != null) {
                constraintSystem = pattern.getConstraintSystem();
                name = pattern.getName();
                variables.clear();
                variables.addAll(pattern.getVariables());
                actions.clear();
                actions.addAll(pattern.getActions());
                modelRendering = pattern.getRendering();
                returnVariable = pattern.getReturnVariable();
                notifyBuilder();
            } else {
                reset();
            }
        }

        public void reset() {
            name = "";
            variables.clear();
            actions.clear();
            returnVariable = null;
            modelRendering = "";
            notifyBuilder();
        }

        /**
         * @return the constraintSystem
         */
        public PatternConstraintSystem getConstraintSystem() {
            return constraintSystem;
        }

        /**
         * @param v
         *        v
         */
        private void purgeActions(Variable<?> v) {
            Set<OWLAxiomChange> toRemove = new HashSet<>();
            for (OWLAxiomChange action : actions) {
                OWLAxiom axiom = action.getAxiom();
                Set<Variable<?>> axiomVariables = patternBuilderModel
                    .getConstraintSystem().getAxiomVariables(axiom);
                if (axiomVariables.contains(v)) {
                    toRemove.add(action);
                }
            }
            actions.removeAll(toRemove);
        }

        public void replaceVariable(Variable<?> oldVariable, Variable<?> newVariable) {
            boolean modified = variables.remove(oldVariable);
            if (modified) {
                if (oldVariable.getType() != newVariable.getType()) {
                    purgeActions(oldVariable);
                }
                variables.add(newVariable);
                constraintSystem.removeVariable(oldVariable);
                constraintSystem.importVariable(newVariable);
                notifyBuilder();
            }
        }
    }

    private class PatternBuilderActionList extends ActionList {

        final class AddActionAdapter extends ComponentAdapter {

            private final VerifyingOptionPane optionPane;
            private final InputVerificationStatusChangedListener verificationListener;
            private final OWLAxiomChangeEditor actionEditor;

            AddActionAdapter(VerifyingOptionPane optionPane,
                InputVerificationStatusChangedListener verificationListener,
                OWLAxiomChangeEditor actionEditor) {
                this.optionPane = optionPane;
                this.verificationListener = verificationListener;
                this.actionEditor = actionEditor;
            }

            @Override
            public void componentHidden(ComponentEvent e) {
                Object retVal = optionPane.getValue();
                if (retVal != null && retVal.equals(JOptionPane.OK_OPTION)) {
                    OWLAxiomChange action = actionEditor.getOwlAxiomChange();
                    patternBuilderModel.addAction(action);
                }
                actionEditor.removeStatusChangedListener(verificationListener);
                actionEditor.dispose();
            }
        }

        public PatternBuilderActionList() {
            super(owlEditorKit, patternBuilderModel.getConstraintSystem(), true);
        }

        @Override
        protected void handleAdd() {
            final OWLAxiomChangeEditor actionEditor = new OWLAxiomChangeEditor(
                owlEditorKit, patternBuilderModel.getConstraintSystem());
            final VerifyingOptionPane optionPane = new NoDefaultFocusVerifyingOptionPane(
                actionEditor);
            final InputVerificationStatusChangedListener verificationListener = new InputVerificationStatusChangedListener() {

                @Override
                public void verifiedStatusChanged(boolean verified) {
                    optionPane.setOKEnabled(verified);
                }
            };
            actionEditor.addStatusChangedListener(verificationListener);
            final JDialog dlg = optionPane
                .createDialog(owlEditorKit.getWorkspace(), null);
            dlg.setModal(true);
            dlg.setTitle("Action editor");
            dlg.setResizable(true);
            dlg.pack();
            dlg.setLocationRelativeTo(owlEditorKit.getWorkspace());
            dlg.addComponentListener(new AddActionAdapter(optionPane,
                verificationListener, actionEditor));
            dlg.setVisible(true);
        }

        @Override
        protected void handleDelete() {
            Object selectedValue = getSelectedValue();
            if (PatternBuilderActionListItem.class.isAssignableFrom(selectedValue
                .getClass())) {
                PatternBuilderActionListItem item = (PatternBuilderActionListItem) selectedValue;
                OWLAxiomChange action = item.getAxiomChange();
                patternBuilderModel.removeAction(action);
            }
        }

        private static final long serialVersionUID = 20100L;
    }

    private class PatternBuilderActionListItem extends ActionListItem {

        private final class EditActionAdapter extends ComponentAdapter {

            private final VerifyingOptionPane optionPane;
            private final OWLAxiomChangeEditor actionEditor;
            private final InputVerificationStatusChangedListener verificationListener;

            protected EditActionAdapter(VerifyingOptionPane optionPane,
                OWLAxiomChangeEditor actionEditor,
                InputVerificationStatusChangedListener verificationListener) {
                this.optionPane = optionPane;
                this.actionEditor = actionEditor;
                this.verificationListener = verificationListener;
            }

            @Override
            public void componentHidden(ComponentEvent e) {
                Object retVal = optionPane.getValue();
                if (retVal != null && retVal.equals(JOptionPane.OK_OPTION)) {
                    OWLAxiomChange action = actionEditor.getOwlAxiomChange();
                    // DefaultListModel model = (DefaultListModel)
                    // PatternBuilder.this.actionList
                    // .getModel();
                    PatternBuilderActionListItem selectedValue = (PatternBuilderActionListItem) actionList
                        .getSelectedValue();
                    // model.removeElement(selectedValue);
                    patternBuilderModel.removeAction(selectedValue.getAxiomChange());
                    patternBuilderModel.addAction(action);
                    // model.addElement(new PatternBuilderActionListItem(action,
                    // true, true));
                    handleChange();
                }
                actionEditor.removeStatusChangedListener(verificationListener);
                actionEditor.dispose();
            }
        }

        public PatternBuilderActionListItem(OWLAxiomChange axiomChange,
            boolean isEditable, boolean isDeleteable) {
            super(axiomChange, isEditable, isDeleteable);
        }

        @Override
        public void handleEdit() {
            ConstraintSystem cs = patternBuilderModel.getConstraintSystem();
            final OWLAxiomChangeEditor actionEditor = new OWLAxiomChangeEditor(
                owlEditorKit, cs);
            actionEditor.setOWLAxiomChange(getAxiomChange());
            final VerifyingOptionPane optionPane = new NoDefaultFocusVerifyingOptionPane(
                actionEditor);
            final InputVerificationStatusChangedListener verificationListener = new InputVerificationStatusChangedListener() {

                @Override
                public void verifiedStatusChanged(boolean verified) {
                    optionPane.setOKEnabled(verified);
                }
            };
            actionEditor.addStatusChangedListener(verificationListener);
            final JDialog dlg = optionPane
                .createDialog(owlEditorKit.getWorkspace(), null);
            dlg.setModal(true);
            dlg.setTitle("Action editor");
            dlg.setResizable(true);
            dlg.pack();
            dlg.setLocationRelativeTo(owlEditorKit.getWorkspace());
            dlg.addComponentListener(new EditActionAdapter(optionPane, actionEditor,
                verificationListener));
            dlg.setVisible(true);
        }
    }

    private class PatternVariableList extends VariableList implements ListDataListener {

        private static final long serialVersionUID = 20100L;

        @Override
        protected void handleAdd() {
            final AbstractVariableEditor<?> variableEditor = getSelectedValue() instanceof InputVariableSectionHeader
                ? new VariableEditor(
                    PatternBuilder.this.owlEditorKit,
                    patternBuilderModel.getConstraintSystem())
                : new GeneratedVariableEditor(PatternBuilder.this.owlEditorKit,
                    patternBuilderModel.getConstraintSystem());
            final VerifyingOptionPane optionPane = new NoDefaultFocusVerifyingOptionPane(
                variableEditor);
            final InputVerificationStatusChangedListener verificationListener = new InputVerificationStatusChangedListener() {

                @Override
                public void verifiedStatusChanged(boolean verified) {
                    optionPane.setOKEnabled(verified);
                }
            };
            variableEditor.addStatusChangedListener(verificationListener);
            final JDialog dlg = optionPane.createDialog(
                PatternBuilder.this.owlEditorKit.getWorkspace(), null);
            dlg.setModal(true);
            dlg.setTitle(variableEditor.getEditorName());
            dlg.setResizable(true);
            dlg.pack();
            dlg.setLocationRelativeTo(PatternBuilder.this.owlEditorKit.getWorkspace());
            dlg.addComponentListener(new ComponentAdapter() {

                @Override
                public void componentHidden(ComponentEvent e) {
                    Object retVal = optionPane.getValue();
                    if (retVal != null && retVal.equals(JOptionPane.OK_OPTION)) {
                        Variable<?> variable = variableEditor.getVariable();
                        patternBuilderModel.addVariable(variable);
                    }
                    variableEditor.removeStatusChangedListener(verificationListener);
                    variableEditor.dispose();
                }
            });
            dlg.setVisible(true);
        }

        @Override
        protected void handleDelete() {
            Object selectedValue = getSelectedValue();
            if (PatternBuilderVariableListItem.class.isAssignableFrom(selectedValue
                .getClass())) {
                PatternBuilderVariableListItem item = (PatternBuilderVariableListItem) selectedValue;
                patternBuilderModel.removeVariable(item.getVariable());
            }
        }

        public PatternVariableList(OWLEditorKit owlEditorKit) {
            super(owlEditorKit, patternBuilderModel.getConstraintSystem());
            getDefaultModel().addElement(new InputVariableSectionHeader());
            getDefaultModel().addElement(new GeneratedVariableSectionHeader());
            getModel().addListDataListener(this);
        }

        @Override
        public void contentsChanged(ListDataEvent e) {
            updatePatternModel();
        }

        private void updatePatternModel() {
            for (int i = 0; i < getModel().getSize(); i++) {
                Object element = getModel().getElementAt(i);
                if (element instanceof PatternBuilderVariableListItem) {
                    PatternBuilderVariableListItem item = (PatternBuilderVariableListItem) element;
                    if (patternModel != null
                        && !patternModel.getVariables().contains(item.getVariable())) {
                        patternModel.addVariable(item.getVariable());
                    }
                }
            }
        }

        public void clear() {
            getDefaultModel().clear();
            getDefaultModel().addElement(new InputVariableSectionHeader());
            getDefaultModel().addElement(new GeneratedVariableSectionHeader());
        }

        @Override
        public void intervalAdded(ListDataEvent e) {
            updatePatternModel();
        }

        @Override
        public void intervalRemoved(ListDataEvent e) {
            updatePatternModel();
        }

        /**
         * @param listItem
         *        listItem
         */
        protected void placeListItem(PatternBuilderVariableListItem listItem) {
            int i = -1;
            if (listItem.getVariable() instanceof GeneratedVariable<?>) {
                i = getModel().getSize();
            } else {
                Enumeration<?> elements = getDefaultModel().elements();
                boolean found = false;
                while (!found && elements.hasMoreElements()) {
                    i++;
                    Object element = elements.nextElement();
                    found = element instanceof GeneratedVariableSectionHeader;
                }
                if (!found) {
                    throw new RuntimeException("Section lost");
                }
            }
            getDefaultModel().add(i, listItem);
        }
    }

    /**
     * @author Luigi Iannone
     */
    public class PatternBuilderVariableListItem extends VariableListItem {

        /**
         * @param variable
         *        variable
         * @param constraintSystem
         *        constraintSystem
         * @param owlEditorKit
         *        owlEditorKit
         * @param isEditable
         *        isEditable
         * @param isDeleatable
         *        isDeleatable
         */
        public PatternBuilderVariableListItem(Variable<?> variable,
            PatternConstraintSystem constraintSystem, OWLEditorKit owlEditorKit,
            boolean isEditable, boolean isDeleatable) {
            super(variable, constraintSystem, owlEditorKit, isEditable, isDeleatable);
        }

        @Override
        public String getTooltip() {
            return getVariable().toString();
        }

        @Override
        public void handleEdit() {
            final ConstraintSystem cs = patternBuilderModel.getConstraintSystem();
            final AbstractVariableEditor<?> variableEditor = getVariable().accept(
                new VariableVisitorEx<AbstractVariableEditor<?>>() {

                    @Override
                    public <P extends OWLObject> AbstractVariableEditor<?> visit(
                        RegexpGeneratedVariable<P> regExpGenerated) {
                        RegExpVariableEditor regExpVariableEditor = new RegExpVariableEditor(
                            owlEditorKit, cs);
                        regExpVariableEditor.setVariable(regExpGenerated);
                        return regExpVariableEditor;
                    }

                    @Override
                    public <P extends OWLObject> AbstractVariableEditor<?> visit(
                        GeneratedVariable<P> v) {
                        GeneratedVariableEditor generatedVariableEditor = new GeneratedVariableEditor(
                            owlEditorKit, cs);
                        generatedVariableEditor.setVariable(v);
                        return generatedVariableEditor;
                    }

                    @Override
                    public <P extends OWLObject> AbstractVariableEditor<?> visit(
                        InputVariable<P> v) {
                        VariableEditor ve = new VariableEditor(owlEditorKit, cs);
                        ve.setVariable(v);
                        return ve;
                    }
                });
            final VerifyingOptionPane optionPane = new NoDefaultFocusVerifyingOptionPane(
                variableEditor);
            final InputVerificationStatusChangedListener verificationListener = new InputVerificationStatusChangedListener() {

                @Override
                public void verifiedStatusChanged(boolean verified) {
                    optionPane.setOKEnabled(verified);
                }
            };
            variableEditor.addStatusChangedListener(verificationListener);
            final JDialog dlg = optionPane
                .createDialog(owlEditorKit.getWorkspace(), null);
            dlg.setModal(true);
            dlg.setTitle(variableEditor.getEditorName());
            dlg.setResizable(true);
            dlg.pack();
            dlg.setLocationRelativeTo(owlEditorKit.getWorkspace());
            dlg.addComponentListener(new ComponentAdapter() {

                @Override
                public void componentHidden(ComponentEvent e) {
                    Object retVal = optionPane.getValue();
                    if (retVal != null && retVal.equals(JOptionPane.OK_OPTION)) {
                        Object selectedValue = variableList.getSelectedValue();
                        if (selectedValue instanceof VariableListItem) {
                            VariableListItem item = (VariableListItem) selectedValue;
                            Variable<?> oldVariable = item.getVariable();
                            patternBuilderModel.replaceVariable(oldVariable,
                                variableEditor.getVariable());
                        }
                    }
                    variableEditor.removeStatusChangedListener(verificationListener);
                    variableEditor.dispose();
                    handleChange();
                }
            });
            dlg.setVisible(true);
        }
    }

    private static final long serialVersionUID = 20100L;
    private final Set<InputVerificationStatusChangedListener> listeners = new HashSet<>();
    protected final OWLEditorKit owlEditorKit;
    protected PatternModel patternModel = null;
    private final JPanel mainPanel = new JPanel();
    protected final PatternVariableList variableList;
    protected final ActionList actionList;
    protected final JTextField nameEditor = new JTextField();
    private final JTextField rendering = new JTextField();
    protected final JCheckBox allowReturnValueCheckBox;
    protected final DefaultComboBoxModel returnValueListModel = new DefaultComboBoxModel();
    protected final JComboBox returnValuesComboBox = new JComboBox(returnValueListModel);
    protected final PatternBuilderModel patternBuilderModel;
    private final JPanel errorPanel = new JPanel(new BorderLayout());
    protected final DefaultListModel errorListModel = new DefaultListModel();
    private final JList errorList = new JList(errorListModel);
    private final AbstractPatternModelFactory factory;
    private final JSplitPane patternBodyPanel;

    /**
     * @param owlEditorKit
     *        owlEditorKit
     * @param f
     *        factory
     */
    public PatternBuilder(OWLEditorKit owlEditorKit, AbstractPatternModelFactory f) {
        factory = f;
        patternBuilderModel = new PatternBuilderModel(factory);
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setName("Pattern Builder");
        errorPanel.setBorder(ComponentFactory.createTitledBorder("Errors:"));
        errorPanel.add(ComponentFactory.createScrollPane(errorList));
        errorPanel.setPreferredSize(new Dimension(200, 75));
        errorList.setCellRenderer(new MessageListCellRenderer());
        JPanel builderPanel = new JPanel(new BorderLayout());
        this.owlEditorKit = owlEditorKit;
        nameEditor.getDocument().addDocumentListener(new DocumentListener() {

            @Override
            public void changedUpdate(DocumentEvent e) {
                patternBuilderModel.setName(nameEditor.getText());
            }

            @Override
            public void insertUpdate(DocumentEvent e) {
                patternBuilderModel.setName(nameEditor.getText());
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                patternBuilderModel.setName(nameEditor.getText());
            }
        });
        JPanel patternNamePanel = new JPanel(new BorderLayout());
        patternNamePanel.add(nameEditor);
        patternNamePanel.setBorder(ComponentFactory.createTitledBorder("Pattern name"));
        builderPanel.add(patternNamePanel, BorderLayout.NORTH);
        removeKeyListeners();
        patternBodyPanel = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
        // patternBodyPanel.setDividerLocation(JSplitPane.5);
        variableList = new PatternVariableList(this.owlEditorKit);
        actionList = new PatternBuilderActionList();
        // this.actionList.getModel().addListDataListener(this.actionListListener);
        JScrollPane variablePane = ComponentFactory.createScrollPane(variableList);
        patternBodyPanel.add(variablePane, JSplitPane.TOP);
        patternBodyPanel.add(ComponentFactory.createScrollPane(actionList),
            JSplitPane.BOTTOM);
        builderPanel.add(patternBodyPanel, BorderLayout.CENTER);
        patternBodyPanel.setResizeWeight(0.5);
        rendering.getDocument().addDocumentListener(new DocumentListener() {

            @Override
            public void changedUpdate(DocumentEvent e) {
                PatternBuilder.this.renderingUpdate();
            }

            @Override
            public void insertUpdate(DocumentEvent e) {
                PatternBuilder.this.renderingUpdate();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                PatternBuilder.this.renderingUpdate();
            }
        });
        JPanel renderingPanelBorder = new JPanel(new BorderLayout());
        renderingPanelBorder.setBorder(ComponentFactory.createTitledBorder("Rendering "));
        renderingPanelBorder.add(ComponentFactory.createScrollPane(rendering));
        JPanel returnPanelBorder = new JPanel(new BorderLayout());
        returnPanelBorder.setBorder(ComponentFactory.createTitledBorder("Return"));
        allowReturnValueCheckBox = new JCheckBox("Allow Return Value");
        allowReturnValueCheckBox.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                returnValuesComboBox.setEnabled(allowReturnValueCheckBox.isSelected());
            }
        });
        returnValuesComboBox.setEnabled(false);
        returnValuesComboBox.setRenderer(variableList.getVariableListCellRenderer());
        returnValuesComboBox.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Object selectedItem = returnValuesComboBox.getSelectedItem();
                if (selectedItem instanceof VariableListItem) {
                    VariableListItem item = (VariableListItem) selectedItem;
                    Variable<?> variable = item.getVariable();
                    patternBuilderModel.setReturnVariable(variable);
                }
            }
        });
        returnPanelBorder.add(allowReturnValueCheckBox, BorderLayout.NORTH);
        returnPanelBorder.add(returnValuesComboBox, BorderLayout.CENTER);
        JPanel southPanel = new JPanel(new BorderLayout());
        southPanel.add(renderingPanelBorder, BorderLayout.NORTH);
        southPanel.add(returnPanelBorder, BorderLayout.CENTER);
        builderPanel.add(southPanel, BorderLayout.SOUTH);
        builderPanel.revalidate();
        mainPanel.add(errorPanel, BorderLayout.SOUTH);
        mainPanel.add(builderPanel, BorderLayout.CENTER);
    }

    protected void renderingUpdate() {
        patternBuilderModel.setRendering(rendering.getText());
    }

    @Override
    public void addStatusChangedListener(InputVerificationStatusChangedListener listener) {
        listeners.add(listener);
        notifyListener(listener, patternBuilderModel.check());
    }

    private void updateGUI() {
        String name = patternBuilderModel.getName();
        if (!name.equals(nameEditor.getText())) {
            nameEditor.setText(name);
        }
        List<Variable<?>> variables = patternBuilderModel.getVariables();
        variableList.clear();
        for (Variable<?> variable : variables) {
            PatternBuilderVariableListItem variableListItem = new PatternBuilderVariableListItem(
                variable, patternBuilderModel.getConstraintSystem(), owlEditorKit,
                true, true);
            variableList.placeListItem(variableListItem);
        }
        actionList.clear();
        List<OWLAxiomChange> actions = patternBuilderModel.getActions();
        for (OWLAxiomChange axiomChange : actions) {
            PatternBuilderActionListItem actionItem = new PatternBuilderActionListItem(
                axiomChange, true, true);
            ((ActionListModel) actionList.getModel()).addElement(actionItem);
        }
        Variable<?> returnVariable = patternBuilderModel.getReturnVariable();
        returnValueListModel.removeAllElements();
        HashSet<Variable<?>> returnVariables = new HashSet<>(variables);
        returnVariables.add(patternBuilderModel.getConstraintSystem()
            .getThisClassVariable());
        for (Variable<?> variable : returnVariables) {
            PatternBuilderVariableListItem item = new PatternBuilderVariableListItem(
                variable, patternBuilderModel.getConstraintSystem(), owlEditorKit,
                false, false);
            if (returnValueListModel.getIndexOf(item) == -1) {
                returnValueListModel.addElement(item);
            }
            if (variable.equals(returnVariable)) {
                returnValuesComboBox.setSelectedItem(item);
            }
        }
        if (!rendering.getText().equals(patternBuilderModel.getRendering())) {
            rendering.setText(patternBuilderModel.getRendering());
        }
        mainPanel.revalidate();
    }

    @Override
    public void removeStatusChangedListener(
        InputVerificationStatusChangedListener listener) {
        listeners.remove(listener);
    }

    @Override
    public PatternModel getPatternModel() {
        return patternModel;
    }

    @Override
    public void handleChange() {
        patternModel = null;
        errorListModel.clear();
        actionList.setConstraintSystem(patternBuilderModel.getConstraintSystem());
        boolean newState = patternBuilderModel.check();
        if (newState) {
            List<Variable<?>> variables = patternBuilderModel.getVariables();
            List<OWLAxiomChange> actions = patternBuilderModel.getActions();
            try {
                patternModel = factory.createPatternModel(nameEditor.getText(),
                    variables, actions, null, rendering.getText(),
                    patternBuilderModel.getConstraintSystem());
                if (allowReturnValueCheckBox.isSelected()) {
                    patternModel
                        .setReturnVariable(((VariableListItem) returnValuesComboBox
                            .getSelectedItem()).getVariable());
                }
            } catch (EmptyVariableListException e) {
                patternModel = null;
                errorListModel.addElement(new Error("No variables"));
            } catch (EmptyActionListException e) {
                patternModel = null;
                errorListModel.addElement(new Error("No actions"));
            } catch (UnsuitableOPPLScriptException e) {
                patternModel = null;
                errorListModel.addElement(new Error("Failed " + e.getMessage()));
            }
        } else {
            patternModel = null;
        }
        errorPanel.setVisible(!errorListModel.isEmpty());
        updateGUI();
        notifyListeners(newState);
    }

    /**
     * @param newState
     *        newState
     */
    private void notifyListeners(boolean newState) {
        for (InputVerificationStatusChangedListener listener : listeners) {
            notifyListener(listener, newState);
        }
    }

    /**
     * @param listener
     *        listener
     * @param newState
     *        newState
     */
    private void notifyListener(InputVerificationStatusChangedListener listener,
        boolean newState) {
        listener.verifiedStatusChanged(newState);
    }

    @Override
    public void dispose() {}

    @Override
    public PatternModel getEditedObject() {
        return patternModel;
    }

    @Override
    public JComponent getEditorComponent() {
        return mainPanel;
    }

    /**
     * @param patternModel
     *        the patternModel to set
     */
    public void setPatternModel(PatternModel patternModel) {
        if (patternModel != null) {
            patternBuilderModel.importPatternModel(patternModel);
        }
    }

    @Override
    public boolean canEdit(Object object) {
        return true;
    }

    @Override
    public boolean setEditedObject(PatternModel editedObject) {
        setPatternModel(editedObject);
        return true;
    }

    @Override
    public String getEditorTypeName() {
        return "Build Pattern Model";
    }

    private void removeKeyListeners() {
        KeyListener[] keyListeners = nameEditor.getKeyListeners();
        for (KeyListener keyListener : keyListeners) {
            nameEditor.removeKeyListener(keyListener);
        }
    }
}
