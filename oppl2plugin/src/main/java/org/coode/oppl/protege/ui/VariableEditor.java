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

import static org.coode.oppl.utils.ArgCheck.checkNotNull;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JToolBar;

import org.coode.oppl.ConstraintSystem;
import org.coode.oppl.VariableScope;
import org.coode.oppl.VariableScopeChecker;
import org.coode.oppl.exceptions.InvalidVariableNameException;
import org.coode.oppl.exceptions.OPPLException;
import org.coode.oppl.variabletypes.InputVariable;
import org.coode.oppl.variabletypes.VariableType;
import org.coode.oppl.variabletypes.VariableTypeFactory;
import org.coode.oppl.variabletypes.VariableTypeName;
import org.protege.editor.core.ui.util.ComponentFactory;
import org.protege.editor.core.ui.util.InputVerificationStatusChangedListener;
import org.protege.editor.core.ui.util.VerifyingOptionPane;
import org.protege.editor.owl.OWLEditorKit;
import org.protege.editor.owl.model.classexpression.OWLExpressionParserException;
import org.protege.editor.owl.ui.clsdescriptioneditor.ExpressionEditor;
import org.protege.editor.owl.ui.clsdescriptioneditor.OWLExpressionChecker;
import org.semanticweb.owlapi.model.OWLException;

/**
 * @author Luigi Iannone
 */
public class VariableEditor extends AbstractVariableEditor<InputVariable<?>> {

    private final class EditScopeActionListener implements ActionListener {

        protected final boolean useScope;

        protected EditScopeActionListener(boolean scope) {
            useScope = scope;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            VariableType<?> variableType = jRadioButtonTypeMap.get(findSelectedButton());
            VariableScopeChecker variableScopeChecker;
            try {
                variableScopeChecker =
                    getConstraintSystem().getOPPLFactory().getVariableScopeChecker();
                final ScopeEditor scopeEditor = ScopeEditor.getTypeScopeEditor(variableType,
                    variableScopeChecker, owlEditorKit);
                if (useScope) {
                    scopeEditor.setScope(lastVariableScope);
                }
                final VerifyingOptionPane optionPane =
                    new NoDefaultFocusVerifyingOptionPane(scopeEditor);
                final InputVerificationStatusChangedListener verificationListener =
                    verified -> optionPane.setOKEnabled(verified);
                scopeEditor.addStatusChangedListener(verificationListener);
                final JDialog dlg = optionPane.createDialog(owlEditorKit.getWorkspace(), null);
                // The editor shouldn't be modal (or should it?)
                dlg.setModal(true);
                dlg.setTitle(scopeEditor.getTitle());
                dlg.setResizable(true);
                dlg.pack();
                dlg.setLocationRelativeTo(owlEditorKit.getWorkspace());
                dlg.addComponentListener(new ComponentAdapter() {

                    @Override
                    public void componentHidden(ComponentEvent e1) {
                        Object retVal = optionPane.getValue();
                        if (retVal != null
                            && retVal.equals(Integer.valueOf(JOptionPane.OK_OPTION))) {
                            lastVariableScope = scopeEditor.getVariableScope();
                            handleChange();
                        }
                        if (useScope) {
                            deleteScopeButton.setEnabled(true);
                            editScopeButton.setEnabled(true);
                        }
                        scopeEditor.removeStatusChangedListener(verificationListener);
                        scopeEditor.dispose();
                    }
                });
                dlg.setVisible(true);
            } catch (OPPLException exception) {
                JOptionPane.showMessageDialog(owlEditorKit.getWorkspace(),
                    "Select a reasoner before");
            }
        }
    }

    private class ChangeTypeActionListener implements ActionListener {

        public ChangeTypeActionListener() {}

        @Override
        public void actionPerformed(ActionEvent e) {
            lastVariableScope = null;
            createScopeButton.setEnabled(true);
            handleChange();
        }
    }

    private static final long serialVersionUID = 20100L;
    protected final OWLEditorKit owlEditorKit;
    private final ConstraintSystem constraintSystem;
    private final JLabel typeScopeLabel = new JLabel();
    protected final Map<JRadioButton, VariableType<?>> jRadioButtonTypeMap = new HashMap<>();
    protected final Map<VariableType<?>, JRadioButton> typeJRadioButonMap = new HashMap<>();
    protected VariableScope<?> lastVariableScope = null;
    protected JButton createScopeButton = new JButton("Create");
    protected JButton editScopeButton = new JButton("Edit");
    protected JButton deleteScopeButton = new JButton("Clear");

    /**
     * @param owlEditorKit owlEditorKit
     * @param constraintSystem constraintSystem
     */
    public VariableEditor(OWLEditorKit owlEditorKit, ConstraintSystem constraintSystem) {
        this.owlEditorKit = checkNotNull(owlEditorKit, "owlEditorKit");
        this.constraintSystem = checkNotNull(constraintSystem, "constraintSystem");
        setLayout(new BorderLayout());
        variableNameExpressionEditor =
            new ExpressionEditor<>(owlEditorKit, new OWLExpressionChecker<String>() {

                private String variableName;

                @Override
                public void check(String text) throws OWLExpressionParserException {
                    variableName = null;
                    if (text.matches("(\\?)?(\\w)+")) {
                        variableName = text.startsWith("?") ? text : "?" + text;
                    } else {
                        throw new OWLExpressionParserException(
                            new InvalidVariableNameException(text));
                    }
                }

                @Override
                public String createObject(String text) throws OWLExpressionParserException {
                    this.check(text);
                    return variableName;
                }
            });
        JPanel variableNamePanel = new JPanel(new BorderLayout());
        variableNamePanel.setBorder(ComponentFactory.createTitledBorder("Variable name:"));
        // De-activate OWL default auto-completer
        for (KeyListener l : variableNameExpressionEditor.getKeyListeners()) {
            variableNameExpressionEditor.removeKeyListener(l);
        }
        variableNameExpressionEditor.addStatusChangedListener(newState -> {
            if (newState) {
                VariableEditor.this.handleChange();
            }
        });
        variableNamePanel.add(variableNameExpressionEditor);
        this.add(variableNamePanel, BorderLayout.NORTH);
        variableTypeButtonGroup = new ButtonGroup();
        JPanel variableTypePanel = new JPanel(new FlowLayout());
        for (VariableTypeName variableTypeName : VariableTypeName.values()) {
            JRadioButton typeRadioButton = new JRadioButton(variableTypeName.name());
            typeRadioButton.addActionListener(new ChangeTypeActionListener());
            variableTypeButtonGroup.add(typeRadioButton);
            variableTypePanel.add(typeRadioButton);
            VariableType<?> variableType = VariableTypeFactory.getVariableType(variableTypeName);
            jRadioButtonTypeMap.put(typeRadioButton, variableType);
            typeJRadioButonMap.put(variableType, typeRadioButton);
        }
        typeJRadioButonMap.get(VariableTypeFactory.getVariableType(VariableTypeName.values()[0]))
            .setSelected(true);
        JPanel scopeBorderPanel = new JPanel(new BorderLayout());
        scopeBorderPanel.setBorder(ComponentFactory.createTitledBorder("Variable Scope"));
        createScopeButton.setEnabled(false);
        editScopeButton.setEnabled(false);
        deleteScopeButton.setEnabled(false);
        JToolBar scopeToolBar = new JToolBar();
        scopeToolBar.setFloatable(false);
        scopeToolBar.add(createScopeButton);
        createScopeButton.addActionListener(new EditScopeActionListener(false));
        editScopeButton.addActionListener(new EditScopeActionListener(true));
        deleteScopeButton.addActionListener(e -> {
            lastVariableScope = null;
            createScopeButton.setEnabled(true);
            VariableEditor.this.handleChange();
        });
        scopeToolBar.add(editScopeButton);
        scopeToolBar.add(deleteScopeButton);
        scopeBorderPanel.add(scopeToolBar, BorderLayout.NORTH);
        JPanel variableTypeAndScopePanel = new JPanel(new BorderLayout());
        variableTypeAndScopePanel.add(scopeBorderPanel, BorderLayout.NORTH);
        variableTypeAndScopePanel.add(variableTypePanel, BorderLayout.CENTER);
        JPanel typeScopeLabelPanel = new JPanel(new FlowLayout());
        typeScopeLabelPanel.add(typeScopeLabel);
        variableTypeAndScopePanel.add(typeScopeLabelPanel, BorderLayout.SOUTH);
        variableTypeAndScopePanel.setBorder(ComponentFactory.createTitledBorder("Variable Type"));
        this.add(variableTypeAndScopePanel, BorderLayout.CENTER);
    }

    protected void handleChange() {
        JRadioButton selectedJRadioButton = findSelectedButton();
        VariableType<?> type = jRadioButtonTypeMap.get(selectedJRadioButton);
        if (check()) {
            try {
                String variableName = variableNameExpressionEditor.createObject();
                updateVariable(variableName, type);
                updateTypeScope(type);
                notifyListeners();
                this.repaint();
            } catch (OPPLException e) {
                notifyListeners();
                throw new RuntimeException(e);
            } catch (OWLExpressionParserException e) {
                notifyListeners();
                throw new RuntimeException(e);
            } catch (OWLException e) {
                notifyListeners();
                throw new RuntimeException(e);
            }
        } else {
            updateTypeScope(type);
            notifyListeners();
        }
        setupButtonsEnabling();
    }

    private void setupButtonsEnabling() {
        createScopeButton.setEnabled(lastVariableScope == null);
        editScopeButton.setEnabled(!createScopeButton.isEnabled());
        deleteScopeButton.setEnabled(editScopeButton.isEnabled());
    }

    /**
     * @param type type
     */
    private void updateTypeScope(VariableType<?> type) {
        if (lastVariableScope != null && type != null) {
            findSelectedButton();
            JRadioButton radioButton = findSelectedButton();
            if (radioButton != null) {
                typeScopeLabel
                    .setText(String.format("[%s %s]", lastVariableScope.getDirection(), owlEditorKit
                        .getModelManager().getRendering(lastVariableScope.getScopingObject())));
            }
        } else {
            typeScopeLabel.setText("");
        }
    }

    @Override
    protected boolean check() {
        try {
            boolean toReturn = true;
            variableNameExpressionEditor.createObject();
            Object selectedValue = jRadioButtonTypeMap.get(findSelectedButton());
            toReturn = selectedValue instanceof VariableType;
            return toReturn;
        } catch (OWLExpressionParserException e) {
            return false;
        } catch (OWLException e) {
            return false;
        }
    }

    /**
     * @param variableName variableName
     * @param type type
     * @throws OPPLException OPPLException
     */
    private void updateVariable(String variableName, VariableType<?> type) throws OPPLException {
        if (getVariable() != null) {
            getConstraintSystem().removeVariable(getVariable());
        }
        super.setVariable(
            getConstraintSystem().createVariable(variableName, type, lastVariableScope));
    }

    @Override
    public void setVariable(InputVariable<?> v) {
        clear();
        lastVariableScope = v.getVariableScope();
        variableNameExpressionEditor.setText(v.getName());
        typeJRadioButonMap.get(v.getType()).setSelected(true);
        updateTypeScope(v.getType());
    }

    @Override
    public void dispose() {}

    /**
     * @return the constraintSystem
     */
    public ConstraintSystem getConstraintSystem() {
        return constraintSystem;
    }

    @Override
    public String getEditorName() {
        return "Input Variable";
    }
}
