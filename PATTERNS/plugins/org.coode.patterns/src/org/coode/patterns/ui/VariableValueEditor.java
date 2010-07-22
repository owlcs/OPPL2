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
package org.coode.patterns.ui;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.swing.JPanel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import org.coode.manchesterowlsyntax.ManchesterOWLSyntaxEditorParser;
import org.coode.oppl.Variable;
import org.protege.editor.core.ui.util.ComponentFactory;
import org.protege.editor.core.ui.util.InputVerificationStatusChangedListener;
import org.protege.editor.core.ui.util.VerifiedInputEditor;
import org.protege.editor.owl.OWLEditorKit;
import org.protege.editor.owl.model.description.OWLExpressionParserException;
import org.protege.editor.owl.ui.clsdescriptioneditor.ExpressionEditor;
import org.protege.editor.owl.ui.clsdescriptioneditor.OWLExpressionChecker;
import org.protege.editor.owl.ui.selector.AbstractHierarchySelectorPanel;
import org.protege.editor.owl.ui.selector.OWLClassSelectorPanel;
import org.protege.editor.owl.ui.selector.OWLDataPropertySelectorPanel;
import org.protege.editor.owl.ui.selector.OWLIndividualSelectorPanel;
import org.protege.editor.owl.ui.selector.OWLObjectPropertySelectorPanel;
import org.semanticweb.owl.expression.ParserException;
import org.semanticweb.owl.model.OWLClass;
import org.semanticweb.owl.model.OWLConstant;
import org.semanticweb.owl.model.OWLException;
import org.semanticweb.owl.model.OWLIndividual;
import org.semanticweb.owl.model.OWLObject;
import org.semanticweb.owl.model.OWLProperty;

/**
 * @author Luigi Iannone
 * 
 *         Nov 17, 2008
 */
public abstract class VariableValueEditor extends JPanel implements
		VerifiedInputEditor {
	/**
	 *
	 */
	private static final long serialVersionUID = -7109694040960783256L;

	private static class ClassVariableValueEditor extends VariableValueEditor
			implements ChangeListener {
		/**
		 *
		 */
		private static final long serialVersionUID = -592992214285597817L;
		private OWLClassSelectorPanel classSelectorPanel;

		ClassVariableValueEditor(OWLEditorKit owlEditorKit, Variable variable) {
			super(variable.getName(), owlEditorKit);
			this.setLayout(new BorderLayout());
			this.classSelectorPanel = new OWLClassSelectorPanel(this
					.getOwlEditorKit());
			this.classSelectorPanel.addSelectionListener(this);
			JPanel classSelectorPanelBorder = new JPanel(new BorderLayout());
			classSelectorPanelBorder.setBorder(ComponentFactory
					.createTitledBorder("Values: "));
			classSelectorPanelBorder.add(ComponentFactory
					.createScrollPane(this.classSelectorPanel));
			this.add(classSelectorPanelBorder);
		}

		@SuppressWarnings("unused")
		public void stateChanged(ChangeEvent e) {
			Set<OWLClass> selectedObjects = this.classSelectorPanel
					.getSelectedObjects();
			if (selectedObjects != null) {
				this.setVariableValues(selectedObjects);
			}
			this.notifyListeners();
		}

		@Override
		public void dispose() {
			this.classSelectorPanel.dispose();
		}
	}

	private static class PropertyVariableValueEditor extends
			VariableValueEditor implements ChangeListener {
		/**
		 *
		 */
		private static final long serialVersionUID = -6634647498199993368L;
		private AbstractHierarchySelectorPanel<? extends OWLProperty<?, ?>> propertySelector;

		PropertyVariableValueEditor(OWLEditorKit owlEditorKit,
				Variable variable, boolean isDataProperty) {
			super(variable.getName(), owlEditorKit);
			this.setLayout(new BorderLayout());
			this.propertySelector = isDataProperty ? new OWLDataPropertySelectorPanel(
					this.getOwlEditorKit())
					: new OWLObjectPropertySelectorPanel(this.getOwlEditorKit());
			this.propertySelector.addSelectionListener(this);
			JPanel propertySelectorPanelBorder = new JPanel(new BorderLayout());
			propertySelectorPanelBorder.setBorder(ComponentFactory
					.createTitledBorder("Values: "));
			propertySelectorPanelBorder.add(ComponentFactory
					.createScrollPane(this.propertySelector));
			this.add(propertySelectorPanelBorder);
		}

		@SuppressWarnings("unused")
		public void stateChanged(ChangeEvent e) {
			Set<? extends OWLProperty<?, ?>> selectedObjects = this.propertySelector
					.getSelectedObjects();
			if (selectedObjects != null) {
				this.setVariableValues(selectedObjects);
			}
			this.notifyListeners();
		}

		@Override
		public void dispose() {
			this.propertySelector.dispose();
		}
	}

	private static class IndividualVariableValueEditor extends
			VariableValueEditor implements ChangeListener {
		/**
		 *
		 */
		private static final long serialVersionUID = -1929930488764454474L;
		private OWLIndividualSelectorPanel individualSelectorPanel;

		IndividualVariableValueEditor(OWLEditorKit owlEditorKit,
				Variable variable) {
			super(variable.getName(), owlEditorKit);
			this.setLayout(new BorderLayout());
			this.individualSelectorPanel = new OWLIndividualSelectorPanel(this
					.getOwlEditorKit());
			this.individualSelectorPanel.addSelectionListener(this);
			JPanel individualSelectorPanelBorder = new JPanel(
					new BorderLayout());
			individualSelectorPanelBorder.setBorder(ComponentFactory
					.createTitledBorder("Values: "));
			individualSelectorPanelBorder.add(ComponentFactory
					.createScrollPane(this.individualSelectorPanel));
			this.add(individualSelectorPanelBorder);
		}

		@SuppressWarnings("unused")
		public void stateChanged(ChangeEvent e) {
			Set<OWLIndividual> selectedObjects = this.individualSelectorPanel
					.getSelectedObjects();
			if (selectedObjects != null) {
				this.setVariableValues(selectedObjects);
			}
			this.notifyListeners();
		}

		@Override
		public void dispose() {
			this.individualSelectorPanel.dispose();
		}
	}

	private static class ConstantVariableValueEditor extends
			VariableValueEditor implements
			InputVerificationStatusChangedListener {
		/**
		 *
		 */
		private static final long serialVersionUID = -9168873531349410794L;
		private ExpressionEditor<OWLConstant> owlConstantEditor;

		ConstantVariableValueEditor(OWLEditorKit owlEditorKit, Variable variable) {
			super(variable.getName(), owlEditorKit);
			this.setLayout(new BorderLayout());
			this.owlConstantEditor = new ExpressionEditor<OWLConstant>(this
					.getOwlEditorKit(),
					new OWLExpressionChecker<OWLConstant>() {
						private OWLConstant owlConstant = null;

						public void check(String text)
								throws OWLExpressionParserException {
							this.owlConstant = null;
							ManchesterOWLSyntaxEditorParser parser = new ManchesterOWLSyntaxEditorParser(
									ConstantVariableValueEditor.this
											.getOwlEditorKit()
											.getModelManager()
											.getOWLDataFactory(), text);
							try {
								this.owlConstant = parser.parseConstant();
							} catch (ParserException e) {
								this.owlConstant = null;
								throw new OWLExpressionParserException(e);
							}
						}

						public OWLConstant createObject(String text)
								throws OWLExpressionParserException {
							this.check(text);
							return this.owlConstant;
						}
					});
			this.owlConstantEditor.addStatusChangedListener(this);
			JPanel owlConstantEditorBorder = new JPanel(new BorderLayout());
			owlConstantEditorBorder.setBorder(ComponentFactory
					.createTitledBorder("Value: "));
			owlConstantEditorBorder.add(ComponentFactory
					.createScrollPane(this.owlConstantEditor));
			this.add(owlConstantEditorBorder);
		}

		public void verifiedStatusChanged(boolean newState) {
			if (newState) {
				try {
					OWLConstant owlConstant = this.owlConstantEditor
							.createObject();
					this.setVariableValues(Collections.singleton(owlConstant));
				} catch (OWLExpressionParserException e) {
					throw new RuntimeException(e);
				} catch (OWLException e) {
					throw new RuntimeException(e);
				}
			}
		}

		@Override
		public void dispose() {
			this.owlConstantEditor.removeStatusChangedListener(this);
		}
	}

	protected final OWLEditorKit owlEditorKit;
	private List<InputVerificationStatusChangedListener> listeners = new ArrayList<InputVerificationStatusChangedListener>();
	private final String title;
	private Set<OWLObject> variableValues = null;

	protected VariableValueEditor(String title, OWLEditorKit owlEditorKit) {
		this.title = title;
		this.owlEditorKit = owlEditorKit;
	}

	/**
	 * @return the owlEditorKit
	 */
	public OWLEditorKit getOwlEditorKit() {
		return this.owlEditorKit;
	}

	/**
	 * @return the listeners
	 */
	public List<InputVerificationStatusChangedListener> getListeners() {
		return this.listeners;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return this.title;
	}

	/**
	 * @return the variableValues
	 */
	public Set<OWLObject> getVariableValues() {
		return this.variableValues;
	}

	/**
	 * @param variableValues
	 *            the variableValues to set
	 */
	protected final void setVariableValues(
			Set<? extends OWLObject> variableValues) {
		if (this.variableValues == null) {
			this.variableValues = new HashSet<OWLObject>(variableValues.size());
		}
		this.variableValues.clear();
		this.variableValues.addAll(variableValues);
	}

	public void addStatusChangedListener(
			InputVerificationStatusChangedListener listener) {
		this.listeners.add(listener);
		this.notifyListener(listener);
	}

	public void removeStatusChangedListener(
			InputVerificationStatusChangedListener listener) {
		this.listeners.remove(listener);
	}

	public void notifyListeners() {
		for (InputVerificationStatusChangedListener listener : this
				.getListeners()) {
			this.notifyListener(listener);
		}
	}

	protected void notifyListener(
			InputVerificationStatusChangedListener listener) {
		listener.verifiedStatusChanged(this.getVariableValues() != null
				&& this.getVariableValues().size() > 0);
	}

	public static VariableValueEditor getVariableValueEditor(
			OWLEditorKit owlEditorKit, Variable variable) {
		// XXX not easy to turn from switch to other
		switch (variable.getType()) {
			case CLASS:
				return new ClassVariableValueEditor(owlEditorKit, variable);
			case OBJECTPROPERTY:
				return new PropertyVariableValueEditor(owlEditorKit, variable,
						false);
			case DATAPROPERTY:
				return new PropertyVariableValueEditor(owlEditorKit, variable,
						true);
			case INDIVIDUAL:
				return new IndividualVariableValueEditor(owlEditorKit, variable);
			case CONSTANT:
				return new ConstantVariableValueEditor(owlEditorKit, variable);
			default:
				return null;
		}
	}

	public abstract void dispose();
}
