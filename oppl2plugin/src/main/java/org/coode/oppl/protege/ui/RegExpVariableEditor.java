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
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import org.coode.oppl.ConstraintSystem;
import org.coode.oppl.ManchesterVariableSyntax;
import org.coode.oppl.OPPLParser;
import org.coode.oppl.Variable;
import org.coode.oppl.VariableVisitor;
import org.coode.oppl.VariableVisitorEx;
import org.coode.oppl.exceptions.InvalidVariableNameException;
import org.coode.oppl.generated.RegexpGeneratedVariable;
import org.coode.oppl.protege.ProtegeParserFactory;
import org.coode.oppl.variabletypes.VariableType;
import org.coode.oppl.variabletypes.VariableTypeFactory;
import org.coode.oppl.variabletypes.VariableTypeName;
import org.coode.parsers.oppl.OPPLSymbolTable;
import org.coode.parsers.ui.ExpressionEditor;
import org.coode.parsers.ui.InputVerificationStatusChangedListener;
import org.protege.editor.core.ui.util.ComponentFactory;
import org.protege.editor.owl.OWLEditorKit;
import org.protege.editor.owl.model.classexpression.OWLExpressionParserException;
import org.protege.editor.owl.ui.clsdescriptioneditor.OWLExpressionChecker;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLException;
import org.semanticweb.owlapi.model.OWLObject;

/** @author Luigi Iannone */
public class RegExpVariableEditor extends
        AbstractVariableEditor<RegexpGeneratedVariable<?>> {
    private class ChangeTypeActionListener implements ActionListener {
        public ChangeTypeActionListener() {}

        @Override
        public void actionPerformed(ActionEvent e) {
            handleChange();
        }
    }

    private static final long serialVersionUID = 20100L;
    private final OWLEditorKit owlEditorKit;
    private final ConstraintSystem constraintSystem;
    protected final Map<JRadioButton, VariableType<?>> jRadioButtonTypeMap = new HashMap<JRadioButton, VariableType<?>>();
    private final Map<VariableType<?>, JRadioButton> typeJRadioButonMap = new HashMap<VariableType<?>, JRadioButton>();
    private final OPPLExpressionChecker<RegexpGeneratedVariable<?>> opplFunctionExpressionChecker;
    private final ExpressionEditor<RegexpGeneratedVariable<?>> opplFunctionEditor;

    public RegExpVariableEditor(OWLEditorKit owlEditorKit,
            ConstraintSystem constraintSystem) {
        setLayout(new BorderLayout());
        this.owlEditorKit = owlEditorKit;
        this.constraintSystem = constraintSystem;
        opplFunctionExpressionChecker = new OPPLExpressionChecker<RegexpGeneratedVariable<?>>(
                getOWLEditorKit()) {
            @Override
            protected RegexpGeneratedVariable<?> parse(String text) {
                String variableName;
                try {
                    variableName = RegExpVariableEditor.this.variableNameExpressionEditor
                            .createObject();
                    Object selectedValue = jRadioButtonTypeMap
                            .get(RegExpVariableEditor.this.findSelectedButton());
                    if (selectedValue instanceof VariableType) {
                        Variable<?> tempVariable = RegExpVariableEditor.this
                                .createTempVariable(variableName,
                                        (VariableType<?>) selectedValue);
                        OPPLParser parser = ProtegeParserFactory.getInstance(
                                getOWLEditorKit()).build(getListener());
                        OPPLSymbolTable symbolTable = parser.getSymbolTableFactory()
                                .createSymbolTable();
                        symbolTable.importConstraintSystem(RegExpVariableEditor.this
                                .getConstraintSystem());
                        RegexpGeneratedVariable<?> variableDefinition = (RegexpGeneratedVariable<?>) parser
                                .parseRegExp(text, tempVariable, symbolTable,
                                        RegExpVariableEditor.this.getConstraintSystem());
                        return variableDefinition;
                    } else {
                        getListener()
                                .reportThrowable(
                                        new IllegalArgumentException(
                                                "The variable type cannot be undefined"),
                                        0, 0, 0);
                        return null;
                    }
                } catch (OWLException e) {
                    getListener().reportThrowable(e, 0, 0, 0);
                    return null;
                }
            }
        };
        variableNameExpressionEditor = new org.protege.editor.owl.ui.clsdescriptioneditor.ExpressionEditor<String>(
                owlEditorKit, new OWLExpressionChecker<String>() {
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
                    public String createObject(String text)
                            throws OWLExpressionParserException {
                        this.check(text);
                        return variableName;
                    }
                });
        JPanel variableNamePanel = new JPanel(new BorderLayout());
        variableNamePanel
                .setBorder(ComponentFactory.createTitledBorder("Variable name:"));
        variableNameExpressionEditor
                .addStatusChangedListener(new org.protege.editor.core.ui.util.InputVerificationStatusChangedListener() {
                    @Override
                    public void verifiedStatusChanged(boolean newState) {
                        if (newState) {
                            RegExpVariableEditor.this.handleChange();
                        }
                    }
                });
        variableNamePanel.add(variableNameExpressionEditor);
        this.add(variableNamePanel, BorderLayout.NORTH);
        variableTypeButtonGroup = new ButtonGroup();
        JPanel variableTypePanel = new JPanel(new GridLayout(0,
                VariableTypeName.values().length));
        for (VariableTypeName variableTypeName : VariableTypeName.values()) {
            JRadioButton typeRadioButton = new JRadioButton(variableTypeName.name());
            typeRadioButton.addActionListener(new ChangeTypeActionListener());
            variableTypeButtonGroup.add(typeRadioButton);
            variableTypePanel.add(typeRadioButton);
            VariableType<?> variableType = VariableTypeFactory
                    .getVariableType(variableTypeName);
            jRadioButtonTypeMap.put(typeRadioButton, variableType);
            typeJRadioButonMap.put(variableType, typeRadioButton);
        }
        typeJRadioButonMap.get(
                VariableTypeFactory.getVariableType(VariableTypeName.values()[0]))
                .setSelected(true);
        JPanel scopeBorderPanel = new JPanel(new BorderLayout());
        scopeBorderPanel.setBorder(ComponentFactory.createTitledBorder("Variable Scope"));
        JPanel variableTypeAndScopePanel = new JPanel(new BorderLayout());
        variableTypeAndScopePanel.add(scopeBorderPanel, BorderLayout.NORTH);
        variableTypeAndScopePanel.add(variableTypePanel, BorderLayout.CENTER);
        variableTypeAndScopePanel.setBorder(ComponentFactory
                .createTitledBorder("Variable Type"));
        this.add(variableTypeAndScopePanel, BorderLayout.CENTER);
        opplFunctionEditor = new ExpressionEditor<RegexpGeneratedVariable<?>>(
                getOWLEditorKit().getOWLModelManager().getOWLOntologyManager(),
                opplFunctionExpressionChecker);
        opplFunctionEditor
                .addStatusChangedListener(new InputVerificationStatusChangedListener() {
                    @Override
                    public void verifiedStatusChanged(boolean newState) {
                        RegExpVariableEditor.this.handleChange();
                    }
                });
        JPanel opplFunctionEditorPanel = new JPanel(new BorderLayout());
        opplFunctionEditorPanel.setBorder(ComponentFactory
                .createTitledBorder("OPPL Function: "));
        opplFunctionEditorPanel
                .add(ComponentFactory.createScrollPane(opplFunctionEditor));
        this.add(opplFunctionEditorPanel, BorderLayout.SOUTH);
    }

    protected void handleChange() {
        if (check()) {
            try {
                variableNameExpressionEditor.createObject();
                if (getVariable() != null) {
                    constraintSystem.removeVariable(getVariable());
                }
                super.setVariable(opplFunctionEditor.createObject());
                constraintSystem.importVariable(getVariable());
                notifyListeners();
            } catch (OWLExpressionParserException e) {
                notifyListeners();
                throw new RuntimeException(e);
            } catch (OWLException e) {
                notifyListeners();
                throw new RuntimeException(e);
            }
        } else {
            notifyListeners();
        }
    }

    @Override
    protected boolean check() {
        try {
            variableNameExpressionEditor.createObject();
            RegexpGeneratedVariable<?> createObject = opplFunctionEditor.createObject();
            return createObject != null;
        } catch (OWLExpressionParserException e) {
            return false;
        } catch (OWLException e) {
            return false;
        }
    }

    @Override
    public void dispose() {}

    protected <O extends OWLObject> Variable<O> createTempVariable(final String name,
            final VariableType<O> type) {
        return new Variable<O>() {
            @Override
            public IRI getIRI() {
                return IRI.create(ManchesterVariableSyntax.NAMESPACE + getName());
            }

            @Override
            public VariableType<O> getType() {
                return type;
            }

            @Override
            public <T> T accept(VariableVisitorEx<T> visitor) {
                return null;
            }

            @Override
            public String getName() {
                return name;
            }

            @Override
            public void accept(VariableVisitor visitor) {}

            @Override
            public String render(ConstraintSystem cs) {
                return String.format("%s:%s", getName(), getType());
            }
        };
    }

    /** @return the owlEditorKit */
    public OWLEditorKit getOWLEditorKit() {
        return owlEditorKit;
    }

    /** @return the constraintSystem */
    public ConstraintSystem getConstraintSystem() {
        return constraintSystem;
    }

    @Override
    public String getEditorName() {
        return "Regular Expression Variable";
    }

    @Override
    public void setVariable(RegexpGeneratedVariable<?> v) {
        clear();
        variableNameExpressionEditor.setText(v.getName());
        typeJRadioButonMap.get(v.getType()).setSelected(true);
        opplFunctionEditor.setText(v.getPatternGeneratingOPPLFunction().render(
                getConstraintSystem()));
    }
}
