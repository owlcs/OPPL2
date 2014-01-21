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
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.swing.JPanel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import org.coode.oppl.OPPLParser;
import org.coode.oppl.Variable;
import org.coode.oppl.protege.ProtegeParserFactory;
import org.coode.oppl.protege.ui.OPPLExpressionChecker;
import org.coode.oppl.variabletypes.ANNOTATIONPROPERTYVariableType;
import org.coode.oppl.variabletypes.CLASSVariableType;
import org.coode.oppl.variabletypes.CONSTANTVariableType;
import org.coode.oppl.variabletypes.DATAPROPERTYVariableType;
import org.coode.oppl.variabletypes.INDIVIDUALVariableType;
import org.coode.oppl.variabletypes.OBJECTPROPERTYVariableType;
import org.coode.oppl.variabletypes.VariableTypeVisitorEx;
import org.protege.editor.core.ui.util.ComponentFactory;
import org.protege.editor.core.ui.util.InputVerificationStatusChangedListener;
import org.protege.editor.core.ui.util.VerifiedInputEditor;
import org.protege.editor.owl.OWLEditorKit;
import org.protege.editor.owl.ui.selector.AbstractHierarchySelectorPanel;
import org.protege.editor.owl.ui.selector.OWLAnnotationPropertySelectorPanel;
import org.protege.editor.owl.ui.selector.OWLClassSelectorPanel;
import org.protege.editor.owl.ui.selector.OWLDataPropertySelectorPanel;
import org.protege.editor.owl.ui.selector.OWLIndividualSelectorPanel;
import org.protege.editor.owl.ui.selector.OWLObjectPropertySelectorPanel;
import org.semanticweb.owlapi.model.OWLAnnotationProperty;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLLiteral;
import org.semanticweb.owlapi.model.OWLNamedIndividual;
import org.semanticweb.owlapi.model.OWLObject;
import org.semanticweb.owlapi.model.OWLProperty;

/** @author Luigi Iannone Nov 17, 2008 */
public abstract class VariableValueEditor extends JPanel implements VerifiedInputEditor {
    private static final long serialVersionUID = 20100L;

    private static class ClassVariableValueEditor extends VariableValueEditor implements
            ChangeListener {
        private static final long serialVersionUID = 20100L;
        private final OWLClassSelectorPanel classSelectorPanel;

        ClassVariableValueEditor(OWLEditorKit owlEditorKit, Variable<?> variable) {
            super(variable.getName(), owlEditorKit);
            setLayout(new BorderLayout());
            classSelectorPanel = new OWLClassSelectorPanel(getOwlEditorKit());
            classSelectorPanel.addSelectionListener(this);
            JPanel classSelectorPanelBorder = new JPanel(new BorderLayout());
            classSelectorPanelBorder.setBorder(ComponentFactory
                    .createTitledBorder("Values: "));
            classSelectorPanelBorder.add(ComponentFactory
                    .createScrollPane(classSelectorPanel));
            this.add(classSelectorPanelBorder);
        }

        @Override
        public void stateChanged(ChangeEvent e) {
            Set<OWLClass> selectedObjects = classSelectorPanel.getSelectedObjects();
            if (selectedObjects != null) {
                setVariableValues(selectedObjects);
            }
            notifyListeners();
        }

        @Override
        public void dispose() {
            classSelectorPanel.dispose();
        }
    }

    private static class PropertyVariableValueEditor extends VariableValueEditor
            implements ChangeListener {
        private static final long serialVersionUID = 20100L;
        private final AbstractHierarchySelectorPanel<? extends OWLProperty<?, ?>> propertySelector;

        PropertyVariableValueEditor(OWLEditorKit owlEditorKit, Variable<?> variable,
                boolean isDataProperty) {
            super(variable.getName(), owlEditorKit);
            setLayout(new BorderLayout());
            propertySelector = isDataProperty ? new OWLDataPropertySelectorPanel(
                    getOwlEditorKit()) : new OWLObjectPropertySelectorPanel(
                    getOwlEditorKit());
            propertySelector.addSelectionListener(this);
            JPanel propertySelectorPanelBorder = new JPanel(new BorderLayout());
            propertySelectorPanelBorder.setBorder(ComponentFactory
                    .createTitledBorder("Values: "));
            propertySelectorPanelBorder.add(ComponentFactory
                    .createScrollPane(propertySelector));
            this.add(propertySelectorPanelBorder);
        }

        @Override
        public void stateChanged(ChangeEvent e) {
            Set<? extends OWLProperty<?, ?>> selectedObjects = propertySelector
                    .getSelectedObjects();
            if (selectedObjects != null) {
                setVariableValues(selectedObjects);
            }
            notifyListeners();
        }

        @Override
        public void dispose() {
            propertySelector.dispose();
        }
    }

    private static class AnnotationPropertyVariableValueEditor extends
            VariableValueEditor implements ChangeListener {
        private static final long serialVersionUID = 20100L;
        private final AbstractHierarchySelectorPanel<OWLAnnotationProperty> propertySelector;

        AnnotationPropertyVariableValueEditor(OWLEditorKit owlEditorKit,
                Variable<?> variable) {
            super(variable.getName(), owlEditorKit);
            setLayout(new BorderLayout());
            propertySelector = new OWLAnnotationPropertySelectorPanel(getOwlEditorKit(),
                    true);
            propertySelector.addSelectionListener(this);
            JPanel propertySelectorPanelBorder = new JPanel(new BorderLayout());
            propertySelectorPanelBorder.setBorder(ComponentFactory
                    .createTitledBorder("Values: "));
            propertySelectorPanelBorder.add(ComponentFactory
                    .createScrollPane(propertySelector));
            this.add(propertySelectorPanelBorder);
        }

        @Override
        public void stateChanged(ChangeEvent e) {
            Set<OWLAnnotationProperty> selectedObjects = propertySelector
                    .getSelectedObjects();
            if (selectedObjects != null) {
                setVariableValues(selectedObjects);
            }
            notifyListeners();
        }

        @Override
        public void dispose() {
            propertySelector.dispose();
        }
    }

    private static class IndividualVariableValueEditor extends VariableValueEditor
            implements ChangeListener {
        private static final long serialVersionUID = 20100L;
        private final OWLIndividualSelectorPanel individualSelectorPanel;

        IndividualVariableValueEditor(OWLEditorKit owlEditorKit, Variable<?> variable) {
            super(variable.getName(), owlEditorKit);
            setLayout(new BorderLayout());
            individualSelectorPanel = new OWLIndividualSelectorPanel(getOwlEditorKit());
            individualSelectorPanel.addSelectionListener(this);
            JPanel individualSelectorPanelBorder = new JPanel(new BorderLayout());
            individualSelectorPanelBorder.setBorder(ComponentFactory
                    .createTitledBorder("Values: "));
            individualSelectorPanelBorder.add(ComponentFactory
                    .createScrollPane(individualSelectorPanel));
            this.add(individualSelectorPanelBorder);
        }

        @Override
        public void stateChanged(ChangeEvent e) {
            Set<OWLNamedIndividual> selectedObjects = individualSelectorPanel
                    .getSelectedObjects();
            if (selectedObjects != null) {
                setVariableValues(selectedObjects);
            }
            notifyListeners();
        }

        @Override
        public void dispose() {
            individualSelectorPanel.dispose();
        }
    }

    private static class ConstantVariableValueEditor extends VariableValueEditor
            implements org.coode.parsers.ui.InputVerificationStatusChangedListener {
        private static final long serialVersionUID = 20100L;
        private org.coode.parsers.ui.ExpressionEditor<OWLLiteral> owlConstantEditor;

        ConstantVariableValueEditor(OWLEditorKit owlEditorKit, Variable<?> variable) {
            super(variable.getName(), owlEditorKit);
            setLayout(new BorderLayout());
            owlConstantEditor = new org.coode.parsers.ui.ExpressionEditor<OWLLiteral>(
                    getOwlEditorKit().getOWLModelManager().getOWLOntologyManager(),
                    new OPPLExpressionChecker<OWLLiteral>(getOwlEditorKit()) {
                        @Override
                        protected OWLLiteral parse(String _text) {
                            String text = _text;
                            // Parse the constant with an OPPL Parser rather
                            // than
                            // with an OPPLPatternParser
                            if (!text.contains("^")) {
                                text = "\"" + text + "\"";
                            } else if (!text.startsWith("\"")) {
                                text = text.replaceAll("(.*)\\^", "\"$1\"^");
                            }
                            OPPLParser opplParser = ProtegeParserFactory.getInstance(
                                    getOWLEditorKit()).build(getListener());
                            OWLLiteral constant = opplParser.parsePlainConstant(text);
                            return constant;
                        }
                    });
            owlConstantEditor.addStatusChangedListener(this);
            JPanel owlConstantEditorBorder = new JPanel(new BorderLayout());
            owlConstantEditorBorder.setBorder(ComponentFactory
                    .createTitledBorder("Value: "));
            owlConstantEditorBorder.add(ComponentFactory
                    .createScrollPane(owlConstantEditor));
            this.add(owlConstantEditorBorder);
        }

        @Override
        public void verifiedStatusChanged(boolean newState) {
            if (newState) {
                OWLLiteral owlConstant = owlConstantEditor.createObject();
                setVariableValues(Collections.singleton(owlConstant));
            }
        }

        @Override
        public void dispose() {
            owlConstantEditor.removeStatusChangedListener(this);
        }
    }

    protected final OWLEditorKit owlEditorKit;
    private final List<InputVerificationStatusChangedListener> listeners = new ArrayList<InputVerificationStatusChangedListener>();
    private final String title;
    private Set<OWLObject> variableValues = null;

    protected VariableValueEditor(String title, OWLEditorKit owlEditorKit) {
        this.title = title;
        this.owlEditorKit = owlEditorKit;
    }

    /** @return the owlEditorKit */
    public OWLEditorKit getOwlEditorKit() {
        return owlEditorKit;
    }

    /** @return the listeners */
    public List<InputVerificationStatusChangedListener> getListeners() {
        return listeners;
    }

    /** @return the title */
    public String getTitle() {
        return title;
    }

    /** @return the variableValues */
    public Set<OWLObject> getVariableValues() {
        return variableValues;
    }

    /** @param variableValues
     *            the variableValues to set */
    protected final void setVariableValues(Set<? extends OWLObject> variableValues) {
        if (this.variableValues == null) {
            this.variableValues = new HashSet<OWLObject>(variableValues.size());
        }
        this.variableValues.clear();
        this.variableValues.addAll(variableValues);
        notifyListeners();
    }

    @Override
    public void addStatusChangedListener(InputVerificationStatusChangedListener listener) {
        listeners.add(listener);
        notifyListener(listener);
    }

    @Override
    public void removeStatusChangedListener(
            InputVerificationStatusChangedListener listener) {
        listeners.remove(listener);
    }

    /** notify listeners */
    public void notifyListeners() {
        for (InputVerificationStatusChangedListener listener : this.getListeners()) {
            notifyListener(listener);
        }
    }

    protected void notifyListener(InputVerificationStatusChangedListener listener) {
        listener.verifiedStatusChanged(getVariableValues() != null
                && getVariableValues().size() > 0);
    }

    /** @param owlEditorKit
     *            owlEditorKit
     * @param variable
     *            variable
     * @return variable value editor */
    public static VariableValueEditor getVariableValueEditor(
            final OWLEditorKit owlEditorKit, final Variable<?> variable) {
        return variable.getType().accept(
                new VariableTypeVisitorEx<VariableValueEditor>() {
                    @Override
                    public VariableValueEditor visitCLASSVariableType(
                            CLASSVariableType classVariableType) {
                        return new ClassVariableValueEditor(owlEditorKit, variable);
                    }

                    @Override
                    public VariableValueEditor visitOBJECTPROPERTYVariableType(
                            OBJECTPROPERTYVariableType objectpropertyVariableType) {
                        return new PropertyVariableValueEditor(owlEditorKit, variable,
                                false);
                    }

                    @Override
                    public VariableValueEditor visitDATAPROPERTYVariableType(
                            DATAPROPERTYVariableType datapropertyVariableType) {
                        return new PropertyVariableValueEditor(owlEditorKit, variable,
                                true);
                    }

                    @Override
                    public VariableValueEditor visitINDIVIDUALVariableType(
                            INDIVIDUALVariableType individualVariableType) {
                        return new IndividualVariableValueEditor(owlEditorKit, variable);
                    }

                    @Override
                    public VariableValueEditor visitCONSTANTVariableType(
                            CONSTANTVariableType constantVariableType) {
                        return new ConstantVariableValueEditor(owlEditorKit, variable);
                    }

                    @Override
                    public
                            VariableValueEditor
                            visitANNOTATIONPROPERTYVariableType(
                                    ANNOTATIONPROPERTYVariableType annotationpropertyVariableType) {
                        return new AnnotationPropertyVariableValueEditor(owlEditorKit,
                                variable);
                    }
                });
    }

    /** dispose component */
    public abstract void dispose();
}
