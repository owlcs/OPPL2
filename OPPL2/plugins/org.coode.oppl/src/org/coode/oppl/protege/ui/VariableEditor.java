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
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JToolBar;

import org.coode.oppl.exceptions.InvalidVariableNameException;
import org.coode.oppl.exceptions.OPPLException;
import org.coode.oppl.utils.ParserFactory;
import org.coode.oppl.variablemansyntax.ConstraintSystem;
import org.coode.oppl.variablemansyntax.Variable;
import org.coode.oppl.variablemansyntax.VariableScope;
import org.coode.oppl.variablemansyntax.VariableType;
import org.coode.oppl.variablemansyntax.generated.RegExpGenerated;
import org.coode.oppl.variablemansyntax.generated.SingleValueGeneratedVariable;
import org.protege.editor.core.ui.util.ComponentFactory;
import org.protege.editor.core.ui.util.InputVerificationStatusChangedListener;
import org.protege.editor.core.ui.util.VerifyingOptionPane;
import org.protege.editor.owl.OWLEditorKit;
import org.protege.editor.owl.model.description.OWLExpressionParserException;
import org.protege.editor.owl.ui.clsdescriptioneditor.ExpressionEditor;
import org.protege.editor.owl.ui.clsdescriptioneditor.OWLExpressionChecker;
import org.semanticweb.owl.model.OWLException;

/**
 * @author Luigi Iannone
 * 
 */
public class VariableEditor extends AbstractVariableEditor {
	private final class ActionListener1 implements ActionListener {
		final boolean useScope;

		protected ActionListener1(boolean scope) {
			this.useScope = scope;
		}

		@SuppressWarnings("unused")
		public void actionPerformed(ActionEvent e) {
			VariableType variableType = VariableEditor.this.jRadioButtonTypeMap
					.get(VariableEditor.this.findSelectedButton());
			final ScopeEditor scopeEditor = ScopeEditor.getTypeScopeEditor(
					variableType, VariableEditor.this.owlEditorKit);
			if (this.useScope) {
				scopeEditor.setScope(VariableEditor.this.lastVariableScope);
			}
			final VerifyingOptionPane optionPane = new NoDefaultFocusVerifyingOptionPane(
					scopeEditor);
			final InputVerificationStatusChangedListener verificationListener = new InputVerificationStatusChangedListener() {
				public void verifiedStatusChanged(boolean verified) {
					optionPane.setOKEnabled(verified);
				}
			};
			scopeEditor.addStatusChangedListener(verificationListener);
			final JDialog dlg = optionPane.createDialog(
					VariableEditor.this.owlEditorKit.getWorkspace(), null);
			// The editor shouldn't be modal (or should it?)
			dlg.setModal(true);
			dlg.setTitle(scopeEditor.getTitle());
			dlg.setResizable(true);
			dlg.pack();
			dlg.setLocationRelativeTo(VariableEditor.this.owlEditorKit
					.getWorkspace());
			dlg.addComponentListener(new ComponentAdapter() {
				@Override
				public void componentHidden(ComponentEvent e1) {
					Object retVal = optionPane.getValue();
					if (retVal != null && retVal.equals(JOptionPane.OK_OPTION)) {
						VariableEditor.this.lastVariableScope = scopeEditor
								.getVariableScope();
						VariableEditor.this.handleChange();
					}
					if (ActionListener1.this.useScope) {
						VariableEditor.this.deleteScopeButton.setEnabled(true);
						VariableEditor.this.editScopeButton.setEnabled(true);
					}
					scopeEditor
							.removeStatusChangedListener(verificationListener);
				}
			});
			dlg.setVisible(true);
		}
	}

	private class ChangeTypeActionListener implements ActionListener {
		public ChangeTypeActionListener() {
		}

		@SuppressWarnings("unused")
		public void actionPerformed(ActionEvent e) {
			VariableEditor.this.lastVariableScope = null;
			VariableEditor.this.createScopeButton.setEnabled(true);
			VariableEditor.this.handleChange();
		}
	}

	private static final long serialVersionUID = 8899160597858126563L;
	// private static Map<VariableType, String> typeLabelStringMap;
	protected final OWLEditorKit owlEditorKit;
	private final ConstraintSystem constraintSystem;
	protected final Map<JRadioButton, VariableType> jRadioButtonTypeMap = new HashMap<JRadioButton, VariableType>();
	private final Map<VariableType, JRadioButton> typeJRadioButonMap = new HashMap<VariableType, JRadioButton>();
	protected VariableScope lastVariableScope = null;
	protected JButton createScopeButton = new JButton("Create");
	protected JButton editScopeButton = new JButton("Edit");
	protected JButton deleteScopeButton = new JButton("Clear");

	// static {
	// typeLabelStringMap = new HashMap<VariableType, String>();
	// EnumSet<VariableType> types = EnumSet.allOf(VariableType.class);
	// for (VariableType variableType : types) {
	// typeLabelStringMap.put(variableType, variableType.name());
	// }
	// }
	public VariableEditor(OWLEditorKit owlEditorKit,
			ConstraintSystem constraintSystem) {
		this.setLayout(new BorderLayout());
		this.owlEditorKit = owlEditorKit;
		this.constraintSystem = constraintSystem;
		this.variableNameExpressionEditor = new ExpressionEditor<String>(
				owlEditorKit, new OWLExpressionChecker<String>() {
					private String variableName;

					public void check(String text)
							throws OWLExpressionParserException {
						this.variableName = null;
						if (text.matches("(\\?)?(\\w)+")) {
							this.variableName = text.startsWith("?") ? text
									: "?" + text;
						} else {
							throw new OWLExpressionParserException(
									new InvalidVariableNameException(text));
						}
					}

					public String createObject(String text)
							throws OWLExpressionParserException {
						this.check(text);
						return this.variableName;
					}
				});
		JPanel variableNamePanel = new JPanel(new BorderLayout());
		variableNamePanel.setBorder(ComponentFactory
				.createTitledBorder("Variable name:"));
		// De-activate OWL default auto-completer
		for (KeyListener l : this.variableNameExpressionEditor
				.getKeyListeners()) {
			this.variableNameExpressionEditor.removeKeyListener(l);
		}
		this.variableNameExpressionEditor
				.addStatusChangedListener(new InputVerificationStatusChangedListener() {
					public void verifiedStatusChanged(boolean newState) {
						if (newState) {
							VariableEditor.this.handleChange();
						}
					}
				});
		variableNamePanel.add(this.variableNameExpressionEditor);
		this.add(variableNamePanel, BorderLayout.NORTH);
		this.variableTypeButtonGroup = new ButtonGroup();
		JPanel variableTypePanel = new JPanel(new GridLayout(0, VariableType
				.values().length));
		for (VariableType variableType : VariableType.values()) {
			JRadioButton typeRadioButton = new JRadioButton(variableType.name());
			typeRadioButton.addActionListener(new ChangeTypeActionListener());
			this.variableTypeButtonGroup.add(typeRadioButton);
			variableTypePanel.add(typeRadioButton);
			this.jRadioButtonTypeMap.put(typeRadioButton, variableType);
			this.typeJRadioButonMap.put(variableType, typeRadioButton);
		}
		this.typeJRadioButonMap.get(VariableType.values()[0]).setSelected(true);
		JPanel scopeBorderPanel = new JPanel(new BorderLayout());
		scopeBorderPanel.setBorder(ComponentFactory
				.createTitledBorder("Variable Scope"));
		this.createScopeButton.setEnabled(false);
		this.editScopeButton.setEnabled(false);
		this.deleteScopeButton.setEnabled(false);
		JToolBar scopeToolBar = new JToolBar();
		scopeToolBar.setFloatable(false);
		scopeToolBar.add(this.createScopeButton);
		this.createScopeButton.addActionListener(new ActionListener1(false));
		this.editScopeButton.addActionListener(new ActionListener1(true));
		this.deleteScopeButton.addActionListener(new ActionListener() {
			@SuppressWarnings("unused")
			public void actionPerformed(ActionEvent e) {
				VariableEditor.this.lastVariableScope = null;
				VariableEditor.this.createScopeButton.setEnabled(true);
				VariableEditor.this.handleChange();
			}
		});
		scopeToolBar.add(this.editScopeButton);
		scopeToolBar.add(this.deleteScopeButton);
		scopeBorderPanel.add(scopeToolBar, BorderLayout.NORTH);
		JPanel variableTypeAndScopePanel = new JPanel(new BorderLayout());
		variableTypeAndScopePanel.add(scopeBorderPanel, BorderLayout.NORTH);
		variableTypeAndScopePanel.add(variableTypePanel, BorderLayout.CENTER);
		variableTypeAndScopePanel.setBorder(ComponentFactory
				.createTitledBorder("Variable Type"));
		this.add(variableTypeAndScopePanel, BorderLayout.CENTER);
	}

	protected void handleChange() {
		JRadioButton selectedJRadioButton = this.findSelectedButton();
		VariableType type = this.jRadioButtonTypeMap.get(selectedJRadioButton);
		if (this.check()) {
			try {
				String variableName = this.variableNameExpressionEditor
						.createObject();
				this.updateVariable(variableName, type);
				this.updateTypeScope(type);
				this.notifyListeners();
			} catch (OPPLException e) {
				this.notifyListeners();
				throw new RuntimeException(e);
			} catch (OWLExpressionParserException e) {
				this.notifyListeners();
				throw new RuntimeException(e);
			} catch (OWLException e) {
				this.notifyListeners();
				throw new RuntimeException(e);
			}
		} else {
			this.updateTypeScope(type);
			this.notifyListeners();
		}
		this.setupButtonsEnabling();
	}

	private void setupButtonsEnabling() {
		this.createScopeButton.setEnabled(this.lastVariableScope == null);
		this.editScopeButton.setEnabled(!this.createScopeButton.isEnabled());
		this.deleteScopeButton.setEnabled(this.editScopeButton.isEnabled());
	}

	/**
	 * @param type
	 */
	private void updateTypeScope(VariableType type) {
		if (this.lastVariableScope != null && type != null) {
			this.findSelectedButton();
			JRadioButton radioButton = this.findSelectedButton();
			if (radioButton != null) {
				radioButton.setText(type.name()
						+ "["
						+ this.lastVariableScope.getDirection()
						+ " "
						+ this.owlEditorKit.getModelManager().getRendering(
								this.lastVariableScope.getScopingObject())
						+ "]");
			}
		} else {
			for (JRadioButton typeRadioButton : this.jRadioButtonTypeMap
					.keySet()) {
				typeRadioButton.setText(this.jRadioButtonTypeMap.get(
						typeRadioButton).name());
			}
		}
	}

	@Override
	protected boolean check() {
		try {
			boolean toReturn = true;
			this.variableNameExpressionEditor.createObject();
			Object selectedValue = this.jRadioButtonTypeMap.get(this
					.findSelectedButton());
			toReturn = selectedValue instanceof VariableType;
			return toReturn;
		} catch (OWLExpressionParserException e) {
			return false;
		} catch (OWLException e) {
			return false;
		}
	}

	/**
	 * @param variableName
	 * @param type
	 * @throws OPPLException
	 */
	private void updateVariable(String variableName, VariableType type)
			throws OPPLException {
		if (this.variable != null) {
			this.constraintSystem.removeVariable(this.variable);
		}
		this.variable = this.constraintSystem
				.createVariable(variableName, type);
		if (this.lastVariableScope != null) {
			this.variable.setVariableScope(this.lastVariableScope,
					ParserFactory.getInstance().getOPPLFactory()
							.getVariableScopeChecker());
		}
	}

	@Override
	public void setVariable(Variable v) {
		this.clear();
		this.lastVariableScope = v.getVariableScope();
		this.variableNameExpressionEditor.setText(v.getName());
		this.typeJRadioButonMap.get(v.getType()).setSelected(true);
		this.updateTypeScope(v.getType());
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
	}

	@Override
	@SuppressWarnings("unused")
	public void setVariable(SingleValueGeneratedVariable<?> variable) {
		throw new RuntimeException(
				"GeneratedVariables not allowed on a regular VariableEditor!");
	}

	@Override
	public void setVariable(RegExpGenerated variable) {
		throw new RuntimeException(
				"RegExpGeneratedVariables not allowed on a regular VariableEditor!");
	}
}
