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
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.TreeSelectionEvent;

import org.coode.oppl.VariableScope;
import org.coode.oppl.VariableScopeChecker;
import org.coode.oppl.VariableScopes;
import org.coode.oppl.VariableScopes.Direction;
import org.coode.oppl.variabletypes.*;
import org.protege.editor.core.ui.util.ComponentFactory;
import org.protege.editor.core.ui.util.InputVerificationStatusChangedListener;
import org.protege.editor.core.ui.util.VerifiedInputEditor;
import org.protege.editor.owl.OWLEditorKit;
import org.protege.editor.owl.ui.clsdescriptioneditor.ExpressionEditor;
import org.protege.editor.owl.ui.selector.AbstractHierarchySelectorPanel;
import org.protege.editor.owl.ui.selector.OWLDataPropertySelectorPanel;
import org.protege.editor.owl.ui.selector.OWLObjectPropertySelectorPanel;
import org.semanticweb.owlapi.model.OWLClassExpression;
import org.semanticweb.owlapi.model.OWLDataProperty;
import org.semanticweb.owlapi.model.OWLException;
import org.semanticweb.owlapi.model.OWLObject;
import org.semanticweb.owlapi.model.OWLObjectProperty;

/**
 * @author Luigi Iannone
 */
public abstract class ScopeEditor extends JPanel implements VerifiedInputEditor {

    static class ClassScopeEditor extends ScopeEditor implements
        InputVerificationStatusChangedListener, ChangeListener {

        private static final long serialVersionUID = 20100L;
        private final ExpressionEditor<OWLClassExpression> editor = new ExpressionEditor<>(
            owlEditorKit, owlEditorKit.getOWLModelManager()
                .getOWLExpressionCheckerFactory().getOWLClassExpressionChecker());
        private final ButtonGroup directionButtonGroup = new ButtonGroup();
        private final Map<JRadioButton, Direction> radioButtonDirectionMap = new HashMap<>();
        private final Map<Direction, JRadioButton> directionRadioButtonMap = new HashMap<>();
        private static final String CLASS_TITLE = "Class Variable Scope";

        public ClassScopeEditor(OWLEditorKit owlEditorKit, VariableScopeChecker checker) {
            super(CLASS_TITLE, checker, owlEditorKit);
            setLayout(new BorderLayout());
            JRadioButton superClassRadioButton = new JRadioButton(
                Direction.SUPERCLASSOF.toString());
            superClassRadioButton.setSelected(true);
            radioButtonDirectionMap.put(superClassRadioButton, Direction.SUPERCLASSOF);
            directionRadioButtonMap.put(Direction.SUPERCLASSOF, superClassRadioButton);
            directionButtonGroup.add(superClassRadioButton);
            superClassRadioButton.getModel().addChangeListener(this);
            JRadioButton subClassRadioButton = new JRadioButton(
                Direction.SUBCLASSOF.toString());
            radioButtonDirectionMap.put(subClassRadioButton, Direction.SUBCLASSOF);
            directionRadioButtonMap.put(Direction.SUBCLASSOF, subClassRadioButton);
            directionButtonGroup.add(subClassRadioButton);
            JPanel directionPanel = new JPanel(new GridLayout(0, 2));
            directionPanel.setBorder(ComponentFactory.createTitledBorder("Direction"));
            directionPanel.add(subClassRadioButton);
            directionPanel.add(superClassRadioButton);
            subClassRadioButton.setSelected(true);
            editor.addStatusChangedListener(this);
            editor.setPreferredSize(new Dimension(100, 100));
            this.add(directionPanel, BorderLayout.NORTH);
            JPanel editorPaneBorder = new JPanel(new BorderLayout());
            editorPaneBorder.setBorder(ComponentFactory
                .createTitledBorder("Scoping Class Description"));
            JScrollPane editorPane = ComponentFactory.createScrollPane(editor);
            editorPaneBorder.add(editorPane);
            this.add(editorPaneBorder, BorderLayout.CENTER);
        }

        private JRadioButton findSelectedButton() {
            JRadioButton button = null;
            Enumeration<AbstractButton> directions = directionButtonGroup.getElements();
            boolean found = false;
            while (!found && directions.hasMoreElements()) {
                button = (JRadioButton) directions.nextElement();
                found = button.isSelected();
            }
            return found ? button : null;
        }

        @Override
        public void verifiedStatusChanged(boolean newState) {
            setVariableScope(null);
            if (newState) {
                JRadioButton button = findSelectedButton();
                if (button != null) {
                    Direction direction = radioButtonDirectionMap.get(button);
                    OWLClassExpression object = null;
                    try {
                        object = editor.createObject();
                    } catch (OWLException e) {
                        throw new RuntimeException(e);
                    }
                    if (direction.equals(Direction.SUPERCLASSOF)) {
                        setVariableScope(VariableScopes.buildSuperClassVariableScope(
                            object, getChecker()));
                    }
                    if (direction.equals(Direction.SUBCLASSOF)) {
                        setVariableScope(VariableScopes.buildSubClassVariableScope(
                            object, getChecker()));
                    }
                }
            }
        }

        @Override
        public void stateChanged(ChangeEvent e) {
            JRadioButton selectedButton = findSelectedButton();
            if (selectedButton != null) {
                Direction direction = radioButtonDirectionMap.get(selectedButton);
                OWLClassExpression object = null;
                try {
                    object = editor.createObject();
                    if (direction.equals(Direction.SUPERCLASSOF)) {
                        setVariableScope(VariableScopes.buildSuperClassVariableScope(
                            object, getChecker()));
                    }
                    if (direction.equals(Direction.SUBCLASSOF)) {
                        setVariableScope(VariableScopes.buildSubClassVariableScope(
                            object, getChecker()));
                    }
                } catch (OWLException ex) {
                    setVariableScope(null);
                }
            }
        }

        @Override
        public void dispose() {
            editor.removeStatusChangedListener(this);
        }

        @Override
        public void setScope(VariableScope<?> scope) {
            editor.setText(owlEditorKit.getModelManager().getRendering(
                scope.getScopingObject()));
            JRadioButton radioButton = directionRadioButtonMap.get(scope.getDirection());
            if (radioButton != null) {
                radioButton.setSelected(true);
            }
        }
    }

    static class IndividualScopeEditor extends ScopeEditor implements
        InputVerificationStatusChangedListener {

        private static final long serialVersionUID = 20100L;
        private final ExpressionEditor<OWLClassExpression> editor = new ExpressionEditor<>(
            owlEditorKit, owlEditorKit.getModelManager()
                .getOWLExpressionCheckerFactory().getOWLClassExpressionChecker());
        private static final String INDIVIDUAL_TITLE = "Individual Variable Scope";

        public IndividualScopeEditor(VariableScopeChecker checker,
            OWLEditorKit owlEditorKit) {
            super(INDIVIDUAL_TITLE, checker, owlEditorKit);
            setLayout(new BorderLayout());
            editor.addStatusChangedListener(this);
            editor.setSize(new Dimension(100, 50));
            JPanel editorPaneBorder = new JPanel(new BorderLayout());
            JScrollPane editorPane = ComponentFactory.createScrollPane(editor);
            editorPaneBorder.setBorder(ComponentFactory
                .createTitledBorder("Scoping Class Description"));
            editorPaneBorder.add(editorPane);
            this.add(editorPaneBorder, BorderLayout.CENTER);
        }

        @Override
        public void verifiedStatusChanged(boolean newState) {
            setVariableScope(null);
            if (newState) {
                try {
                    setVariableScope(VariableScopes.buildIndividualVariableScope(
                        editor.createObject(), getChecker()));
                } catch (OWLException e) {
                    throw new RuntimeException(e);
                }
            }
        }

        @Override
        public void dispose() {
            editor.removeStatusChangedListener(this);
        }

        @Override
        public void setScope(VariableScope<?> scope) {
            OWLObject scopingObject = scope.getScopingObject();
            editor.setText(owlEditorKit.getModelManager().getRendering(scopingObject));
        }
    }

    static class PropertyScopeEditor extends ScopeEditor implements ChangeListener {

        private static final long serialVersionUID = 20100L;
        private final ButtonGroup directionButtonGroup = new ButtonGroup();
        private final Map<JRadioButton, Direction> radioButtonDirectionMap = new HashMap<>();
        private final AbstractHierarchySelectorPanel<?> propertyTree;
        private final static String PROPERTY_TITLE = "Property Variable Scope";
        private final boolean isDataProperty;

        public PropertyScopeEditor(OWLEditorKit owlEditorKit,
            VariableScopeChecker checker, boolean isDataProperty) {
            super(PROPERTY_TITLE, checker, owlEditorKit);
            this.isDataProperty = isDataProperty;
            setLayout(new BorderLayout());
            JRadioButton superPropertyRadioButton = new JRadioButton(
                Direction.SUBPROPERTYOF.toString());
            superPropertyRadioButton.setSelected(true);
            radioButtonDirectionMap
                .put(superPropertyRadioButton, Direction.SUBPROPERTYOF);
            directionButtonGroup.add(superPropertyRadioButton);
            JRadioButton subPropertyRadioButton = new JRadioButton(
                Direction.SUPERPROPERTYOF.toString());
            radioButtonDirectionMap
                .put(subPropertyRadioButton, Direction.SUPERPROPERTYOF);
            directionButtonGroup.add(subPropertyRadioButton);
            JPanel directionPanel = new JPanel(new GridLayout(0, 2));
            directionPanel.setBorder(ComponentFactory.createTitledBorder("Direction"));
            directionPanel.add(subPropertyRadioButton);
            directionPanel.add(superPropertyRadioButton);
            subPropertyRadioButton.setSelected(true);
            this.add(directionPanel, BorderLayout.NORTH);
            propertyTree = isDataProperty ? new OWLDataPropertySelectorPanel(
                this.owlEditorKit) : new OWLObjectPropertySelectorPanel(
                    this.owlEditorKit);
            propertyTree.addSelectionListener(this);
            JPanel propertyPaneBorder = new JPanel(new BorderLayout());
            JScrollPane propertyPane = ComponentFactory.createScrollPane(propertyTree);
            propertyPaneBorder.setBorder(ComponentFactory
                .createTitledBorder("Scoping property"));
            propertyPane.setSize(new Dimension(100, 50));
            propertyPaneBorder.add(propertyPane);
            this.add(propertyPaneBorder, BorderLayout.SOUTH);
        }

        public void valueChanged(@SuppressWarnings("unused") TreeSelectionEvent e) {}

        private JRadioButton findSelectedButton() {
            JRadioButton button = null;
            Enumeration<AbstractButton> directions = directionButtonGroup.getElements();
            boolean found = false;
            while (!found && directions.hasMoreElements()) {
                button = (JRadioButton) directions.nextElement();
                found = button.isSelected();
            }
            return found ? button : null;
        }

        @Override
        public void dispose() {
            propertyTree.removeSelectionListener(this);
        }

        @Override
        public void setScope(VariableScope<?> scope) {
            if (isDataProperty) {
                OWLDataPropertySelectorPanel panel = (OWLDataPropertySelectorPanel) propertyTree;
                panel.setSelection((OWLDataProperty) scope.getScopingObject());
            } else {
                OWLObjectPropertySelectorPanel panel = (OWLObjectPropertySelectorPanel) propertyTree;
                panel.setSelection((OWLObjectProperty) scope.getScopingObject());
            }
        }

        @Override
        public void stateChanged(ChangeEvent e) {
            Object lastPathComponent = propertyTree.getSelectedObject();
            JRadioButton selectedButton = findSelectedButton();
            if (selectedButton != null) {
                Direction direction = radioButtonDirectionMap.get(selectedButton);
                setVariableScope(null);
                if (lastPathComponent != null && direction != null) {
                    if (direction.equals(Direction.SUBPROPERTYOF)) {
                        if (lastPathComponent instanceof OWLDataProperty) {
                            setVariableScope(VariableScopes
                                .buildSubPropertyVariableScope(
                                    (OWLDataProperty) lastPathComponent,
                                    getChecker()));
                        } else if (lastPathComponent instanceof OWLObjectProperty) {
                            setVariableScope(VariableScopes
                                .buildSubPropertyVariableScope(
                                    (OWLObjectProperty) lastPathComponent,
                                    getChecker()));
                        }
                    }
                    if (direction.equals(Direction.SUPERPROPERTYOF)) {
                        if (lastPathComponent instanceof OWLDataProperty) {
                            setVariableScope(VariableScopes
                                .buildSuperPropertyVariableScope(
                                    (OWLDataProperty) lastPathComponent,
                                    getChecker()));
                        } else if (lastPathComponent instanceof OWLObjectProperty) {
                            setVariableScope(VariableScopes
                                .buildSuperPropertyVariableScope(
                                    (OWLObjectProperty) lastPathComponent,
                                    getChecker()));
                        }
                    }
                }
            }
        }
    }

    private static final long serialVersionUID = 20100L;
    protected final OWLEditorKit owlEditorKit;
    private final List<InputVerificationStatusChangedListener> listeners = new ArrayList<>();
    private VariableScope<?> variableScope = null;
    private final String title;
    private final VariableScopeChecker checker;

    /**
     * @return the checker
     */
    public VariableScopeChecker getChecker() {
        return checker;
    }

    protected ScopeEditor(String title, VariableScopeChecker checker,
        OWLEditorKit owlEditorKit) {
        this.owlEditorKit = owlEditorKit;
        this.title = title;
        this.checker = checker;
    }

    /**
     * @return the VariableScope set by this ScopeEditor. It can be {@code null}
     */
    public VariableScope<?> getVariableScope() {
        return variableScope;
    }

    protected final void setVariableScope(VariableScope<?> variableScope) {
        this.variableScope = variableScope;
        notifyListeners();
    }

    private void notifyListeners() {
        for (InputVerificationStatusChangedListener listener : listeners) {
            listener.verifiedStatusChanged(variableScope != null);
        }
    }

    /**
     * @param variableType
     *        variableType
     * @param checker
     *        checker
     * @param owlEditorKit
     *        owlEditorKit
     * @return typ scope editor
     */
    public static ScopeEditor getTypeScopeEditor(VariableType<?> variableType,
        final VariableScopeChecker checker, final OWLEditorKit owlEditorKit) {
        ScopeEditor toReturn = variableType
            .accept(new VariableTypeVisitorEx<ScopeEditor>() {

                @Override
                public ScopeEditor visitCLASSVariableType(
                    CLASSVariableType classVariableType) {
                    return new ClassScopeEditor(owlEditorKit, checker);
                }

                @Override
                public ScopeEditor visitOBJECTPROPERTYVariableType(
                    OBJECTPROPERTYVariableType objectpropertyVariableType) {
                    return new PropertyScopeEditor(owlEditorKit, checker, false);
                }

                @Override
                public ScopeEditor visitDATAPROPERTYVariableType(
                    DATAPROPERTYVariableType datapropertyVariableType) {
                    return new PropertyScopeEditor(owlEditorKit, checker, true);
                }

                @Override
                public ScopeEditor visitINDIVIDUALVariableType(
                    INDIVIDUALVariableType individualVariableType) {
                    return new IndividualScopeEditor(checker, owlEditorKit);
                }

                @Override
                public ScopeEditor visitCONSTANTVariableType(
                    CONSTANTVariableType constantVariableType) {
                    return null;
                }

                @Override
                public ScopeEditor visitANNOTATIONPROPERTYVariableType(
                    ANNOTATIONPROPERTYVariableType annotationpropertyVariableType) {
                    return null;
                }
            });
        return toReturn;
    }

    @Override
    public void addStatusChangedListener(InputVerificationStatusChangedListener listener) {
        listeners.add(listener);
        notifyListeners();
    }

    @Override
    public void removeStatusChangedListener(
        InputVerificationStatusChangedListener listener) {
        listeners.remove(listener);
    }

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /** dispose */
    public abstract void dispose();

    /**
     * @param scope
     *        scope
     */
    public abstract void setScope(VariableScope<?> scope);
}
