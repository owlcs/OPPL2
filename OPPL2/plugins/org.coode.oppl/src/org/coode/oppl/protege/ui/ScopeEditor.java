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
import org.coode.oppl.VariableScopes;
import org.coode.oppl.VariableScopes.Direction;
import org.coode.oppl.variabletypes.VariableType;
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
 * 
 */
public abstract class ScopeEditor extends JPanel implements VerifiedInputEditor {
	static class ClassScopeEditor extends ScopeEditor implements
			InputVerificationStatusChangedListener, ChangeListener {
		/**
		 *
		 */
		private static final long serialVersionUID = 1748983757452740791L;
		private final ExpressionEditor<OWLClassExpression> editor = new ExpressionEditor<OWLClassExpression>(
				this.owlEditorKit, this.owlEditorKit.getOWLModelManager()
						.getOWLExpressionCheckerFactory()
						.getOWLClassExpressionChecker());
		private final ButtonGroup directionButtonGroup = new ButtonGroup();
		private final Map<JRadioButton, Direction> radioButtonDirectionMap = new HashMap<JRadioButton, Direction>();
		private final Map<Direction, JRadioButton> directionRadioButtonMap = new HashMap<Direction, JRadioButton>();
		private static final String CLASS_TITLE = "Class Variable Scope";

		public ClassScopeEditor(OWLEditorKit owlEditorKit) {
			super(CLASS_TITLE, owlEditorKit);
			this.setLayout(new BorderLayout());
			JRadioButton superClassRadioButton = new JRadioButton(
					Direction.SUPERCLASSOF.toString());
			superClassRadioButton.setSelected(true);
			this.radioButtonDirectionMap.put(superClassRadioButton,
					Direction.SUPERCLASSOF);
			this.directionRadioButtonMap.put(Direction.SUPERCLASSOF,
					superClassRadioButton);
			this.directionButtonGroup.add(superClassRadioButton);
			superClassRadioButton.getModel().addChangeListener(this);
			JRadioButton subClassRadioButton = new JRadioButton(
					Direction.SUBCLASSOF.toString());
			this.radioButtonDirectionMap.put(subClassRadioButton,
					Direction.SUBCLASSOF);
			this.directionRadioButtonMap.put(Direction.SUBCLASSOF,
					subClassRadioButton);
			this.directionButtonGroup.add(subClassRadioButton);
			JPanel directionPanel = new JPanel(new GridLayout(0, 2));
			directionPanel.setBorder(ComponentFactory
					.createTitledBorder("Direction"));
			directionPanel.add(subClassRadioButton);
			directionPanel.add(superClassRadioButton);
			subClassRadioButton.setSelected(true);
			this.editor.addStatusChangedListener(this);
			this.editor.setPreferredSize(new Dimension(100, 100));
			this.add(directionPanel, BorderLayout.NORTH);
			JPanel editorPaneBorder = new JPanel(new BorderLayout());
			editorPaneBorder.setBorder(ComponentFactory
					.createTitledBorder("Scoping Class Description"));
			JScrollPane editorPane = ComponentFactory
					.createScrollPane(this.editor);
			editorPaneBorder.add(editorPane);
			this.add(editorPaneBorder, BorderLayout.CENTER);
		}

		private JRadioButton findSelectedButton() {
			JRadioButton button = null;
			Enumeration<AbstractButton> directions = this.directionButtonGroup
					.getElements();
			boolean found = false;
			while (!found && directions.hasMoreElements()) {
				button = (JRadioButton) directions.nextElement();
				found = button.isSelected();
			}
			return found ? button : null;
		}

		public void verifiedStatusChanged(boolean newState) {
			this.setVariableScope(null);
			if (newState) {
				JRadioButton button = this.findSelectedButton();
				if (button != null) {
					Direction direction = this.radioButtonDirectionMap
							.get(button);
					OWLClassExpression object = null;
					try {
						object = this.editor.createObject();
					} catch (OWLException e) {
						throw new RuntimeException(e);
					}
					if (direction.equals(Direction.SUPERCLASSOF)) {
						this.setVariableScope(VariableScopes
								.buildSuperClassVariableScope(object));
					}
					if (direction.equals(Direction.SUBCLASSOF)) {
						this.setVariableScope(VariableScopes
								.buildSubClassVariableScope(object));
					}
				}
			}
		}

		public void stateChanged(ChangeEvent e) {
			JRadioButton selectedButton = this.findSelectedButton();
			if (selectedButton != null) {
				Direction direction = this.radioButtonDirectionMap
						.get(selectedButton);
				OWLClassExpression object = null;
				try {
					object = this.editor.createObject();
					if (direction.equals(Direction.SUPERCLASSOF)) {
						this.setVariableScope(VariableScopes
								.buildSuperClassVariableScope(object));
					}
					if (direction.equals(Direction.SUBCLASSOF)) {
						this.setVariableScope(VariableScopes
								.buildSubClassVariableScope(object));
					}
				} catch (OWLException ex) {
					this.setVariableScope(null);
				}
			}
		}

		@Override
		public void dispose() {
			this.editor.removeStatusChangedListener(this);
		}

		@Override
		public void setScope(VariableScope<?> scope) {
			this.editor.setText(this.owlEditorKit.getModelManager()
					.getRendering(scope.getScopingObject()));
			JRadioButton radioButton = this.directionRadioButtonMap.get(scope
					.getDirection());
			if (radioButton != null) {
				radioButton.setSelected(true);
			}
		}
	}

	static class IndividualScopeEditor extends ScopeEditor implements
			InputVerificationStatusChangedListener {
		/**
		 *
		 */
		private static final long serialVersionUID = 1748983757452740791L;
		private final ExpressionEditor<OWLClassExpression> editor = new ExpressionEditor<OWLClassExpression>(
				this.owlEditorKit, this.owlEditorKit.getModelManager()
						.getOWLExpressionCheckerFactory()
						.getOWLClassExpressionChecker());
		private static final String INDIVIDUAL_TITLE = "Individual Variable Scope";

		public IndividualScopeEditor(OWLEditorKit owlEditorKit) {
			super(INDIVIDUAL_TITLE, owlEditorKit);
			this.setLayout(new BorderLayout());
			this.editor.addStatusChangedListener(this);
			this.editor.setSize(new Dimension(100, 50));
			JPanel editorPaneBorder = new JPanel(new BorderLayout());
			JScrollPane editorPane = ComponentFactory
					.createScrollPane(this.editor);
			editorPaneBorder.setBorder(ComponentFactory
					.createTitledBorder("Scoping Class Description"));
			editorPaneBorder.add(editorPane);
			this.add(editorPaneBorder, BorderLayout.CENTER);
		}

		public void verifiedStatusChanged(boolean newState) {
			this.setVariableScope(null);
			if (newState) {
				try {
					this.setVariableScope(VariableScopes
							.buildIndividualVariableScope(this.editor
									.createObject()));
				} catch (OWLException e) {
					throw new RuntimeException(e);
				}
			}
		}

		@Override
		public void dispose() {
			this.editor.removeStatusChangedListener(this);
		}

		@Override
		public void setScope(VariableScope<?> scope) {
			OWLObject scopingObject = scope.getScopingObject();
			this.editor.setText(this.owlEditorKit.getModelManager()
					.getRendering(scopingObject));
		}
	}

	static class PropertyScopeEditor extends ScopeEditor implements
			ChangeListener {
		/**
		 *
		 */
		private static final long serialVersionUID = 1014596361426722995L;
		private ButtonGroup directionButtonGroup = new ButtonGroup();
		private Map<JRadioButton, Direction> radioButtonDirectionMap = new HashMap<JRadioButton, Direction>();
		private AbstractHierarchySelectorPanel<?> propertyTree;
		private final static String PROPERTY_TITLE = "Property Variable Scope";
		private final boolean isDataProperty;

		public PropertyScopeEditor(OWLEditorKit owlEditorKit,
				boolean isDataProperty) {
			super(PROPERTY_TITLE, owlEditorKit);
			this.isDataProperty = isDataProperty;
			this.setLayout(new BorderLayout());
			JRadioButton superPropertyRadioButton = new JRadioButton(
					Direction.SUBPROPERTYOF.toString());
			superPropertyRadioButton.setSelected(true);
			this.radioButtonDirectionMap.put(superPropertyRadioButton,
					Direction.SUBPROPERTYOF);
			this.directionButtonGroup.add(superPropertyRadioButton);
			JRadioButton subPropertyRadioButton = new JRadioButton(
					Direction.SUPERPROPERTYOF.toString());
			this.radioButtonDirectionMap.put(subPropertyRadioButton,
					Direction.SUPERPROPERTYOF);
			this.directionButtonGroup.add(subPropertyRadioButton);
			JPanel directionPanel = new JPanel(new GridLayout(0, 2));
			directionPanel.setBorder(ComponentFactory
					.createTitledBorder("Direction"));
			directionPanel.add(subPropertyRadioButton);
			directionPanel.add(superPropertyRadioButton);
			subPropertyRadioButton.setSelected(true);
			this.add(directionPanel, BorderLayout.NORTH);
			this.propertyTree = isDataProperty ? new OWLDataPropertySelectorPanel(
					this.owlEditorKit)
					: new OWLObjectPropertySelectorPanel(this.owlEditorKit);
			this.propertyTree.addSelectionListener(this);
			JPanel propertyPaneBorder = new JPanel(new BorderLayout());
			JScrollPane propertyPane = ComponentFactory
					.createScrollPane(this.propertyTree);
			propertyPaneBorder.setBorder(ComponentFactory
					.createTitledBorder("Scoping property"));
			propertyPane.setSize(new Dimension(100, 50));
			propertyPaneBorder.add(propertyPane);
			this.add(propertyPaneBorder, BorderLayout.SOUTH);
		}

		public void valueChanged(TreeSelectionEvent e) {
		}

		private JRadioButton findSelectedButton() {
			JRadioButton button = null;
			Enumeration<AbstractButton> directions = this.directionButtonGroup
					.getElements();
			boolean found = false;
			while (!found && directions.hasMoreElements()) {
				button = (JRadioButton) directions.nextElement();
				found = button.isSelected();
			}
			return found ? button : null;
		}

		@Override
		public void dispose() {
			this.propertyTree.removeSelectionListener(this);
		}

		@Override
		public void setScope(VariableScope<?> scope) {
			if (this.isDataProperty) {
				OWLDataPropertySelectorPanel panel = (OWLDataPropertySelectorPanel) this.propertyTree;
				panel.setSelection((OWLDataProperty) scope.getScopingObject());
			} else {
				OWLObjectPropertySelectorPanel panel = (OWLObjectPropertySelectorPanel) this.propertyTree;
				panel
						.setSelection((OWLObjectProperty) scope
								.getScopingObject());
			}
		}

		public void stateChanged(ChangeEvent e) {
			Object lastPathComponent = this.propertyTree.getSelectedObject();
			JRadioButton selectedButton = this.findSelectedButton();
			if (selectedButton != null) {
				Direction direction = this.radioButtonDirectionMap
						.get(selectedButton);
				this.setVariableScope(null);
				if (lastPathComponent != null && direction != null) {
					if (direction.equals(Direction.SUBPROPERTYOF)) {
						if (lastPathComponent instanceof OWLDataProperty) {
							this
									.setVariableScope(VariableScopes
											.buildSubPropertyVariableScope((OWLDataProperty) lastPathComponent));
						} else if (lastPathComponent instanceof OWLObjectProperty) {
							this
									.setVariableScope(VariableScopes
											.buildSubPropertyVariableScope((OWLObjectProperty) lastPathComponent));
						}
					}
					if (direction.equals(Direction.SUPERPROPERTYOF)) {
						if (lastPathComponent instanceof OWLDataProperty) {
							this
									.setVariableScope(VariableScopes
											.buildSuperPropertyVariableScope((OWLDataProperty) lastPathComponent));
						} else if (lastPathComponent instanceof OWLObjectProperty) {
							this
									.setVariableScope(VariableScopes
											.buildSuperPropertyVariableScope((OWLObjectProperty) lastPathComponent));
						}
					}
				}
			}
		}
	}

	private static final long serialVersionUID = 2459124639459085302L;
	protected final OWLEditorKit owlEditorKit;
	private List<InputVerificationStatusChangedListener> listeners = new ArrayList<InputVerificationStatusChangedListener>();
	private VariableScope<?> variableScope = null;
	private final String title;

	protected ScopeEditor(String title, OWLEditorKit owlEditorKit) {
		this.owlEditorKit = owlEditorKit;
		this.title = title;
	}

	/**
	 * @return the VariableScope set by this ScopeEditor. It can be
	 *         <code>null</code>
	 */
	public VariableScope<?> getVariableScope() {
		return this.variableScope;
	}

	protected final void setVariableScope(VariableScope<?> variableScope) {
		this.variableScope = variableScope;
		this.notifyListeners();
	}

	private void notifyListeners() {
		for (InputVerificationStatusChangedListener listener : this.listeners) {
			listener.verifiedStatusChanged(this.variableScope != null);
		}
	}

	public static ScopeEditor getTypeScopeEditor(VariableType variableType,
			OWLEditorKit owlEditorKit) {
		// XXX can't replace this with a visitor
		ScopeEditor toReturn = null;
		switch (variableType) {
		case CLASS:
			toReturn = new ClassScopeEditor(owlEditorKit);
			break;
		case DATAPROPERTY:
			toReturn = new PropertyScopeEditor(owlEditorKit, true);
			break;
		case OBJECTPROPERTY:
			toReturn = new PropertyScopeEditor(owlEditorKit, false);
			break;
		case INDIVIDUAL:
			toReturn = new IndividualScopeEditor(owlEditorKit);
			break;
		default:
			break;
		}
		return toReturn;
	}

	public void addStatusChangedListener(
			InputVerificationStatusChangedListener listener) {
		this.listeners.add(listener);
		this.notifyListeners();
	}

	public void removeStatusChangedListener(
			InputVerificationStatusChangedListener listener) {
		this.listeners.remove(listener);
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return this.title;
	}

	public abstract void dispose();

	public abstract void setScope(VariableScope<?> scope);
}
