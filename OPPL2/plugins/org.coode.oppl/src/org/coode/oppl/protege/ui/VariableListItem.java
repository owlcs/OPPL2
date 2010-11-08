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

import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

import org.coode.oppl.ConstraintSystem;
import org.coode.oppl.Variable;
import org.coode.oppl.VariableScope;
import org.coode.oppl.exceptions.OPPLException;
import org.coode.oppl.exceptions.RuntimeExceptionHandler;
import org.coode.oppl.variabletypes.VariableType;
import org.protege.editor.core.ui.list.MListItem;
import org.protege.editor.core.ui.util.InputVerificationStatusChangedListener;
import org.protege.editor.core.ui.util.VerifyingOptionPane;
import org.protege.editor.owl.OWLEditorKit;
import org.protege.editor.owl.model.inference.NoOpReasoner;
import org.semanticweb.owlapi.model.OWLObject;

/**
 * @author Luigi Iannone
 * 
 */
public class VariableListItem implements MListItem, OPPLMacroStatusChange {
	private final Variable variable;
	private final OWLEditorKit owlEditorKit;
	private final RuntimeExceptionHandler runtimeExceptionHandler;
	private final List<OPPLMacroListener> listeners = new ArrayList<OPPLMacroListener>();
	private final boolean isEditable;
	private final boolean isDeleteable;
	private final ConstraintSystem constraintSystem;

	/**
	 * @param variable
	 * @param owlEditorKit
	 */
	public VariableListItem(Variable variable,
			ConstraintSystem constraintSystem, OWLEditorKit owlEditorKit,
			boolean isEditable, boolean isDeleatable) {
		if (variable == null) {
			throw new NullPointerException("The variable cannot be null");
		}
		if (constraintSystem == null) {
			throw new NullPointerException("The constraint system cannot null");
		}
		if (owlEditorKit == null) {
			throw new NullPointerException("The OWL editor kit cannot null");
		}
		this.variable = variable;
		this.owlEditorKit = owlEditorKit;
		this.isEditable = isEditable;
		this.isDeleteable = isDeleatable;
		this.constraintSystem = constraintSystem;
		this.runtimeExceptionHandler = new ShowMessageRuntimeExceptionHandler(
				this.getOwlEditorKit().getOWLWorkspace());
	}

	/**
	 * @see org.protege.editor.core.ui.list.MListItem#getTooltip()
	 */
	public String getTooltip() {
		StringBuilder toReturnBuilder = new StringBuilder(this.variable
				.getName());
		boolean first = true;
		toReturnBuilder.append(" = ");
		for (OWLObject value : this.getConstraintSystem().getVariableBindings(
				this.variable, this.getRuntimeExceptionHandler())) {
			String rendering = first ? this.owlEditorKit.getModelManager()
					.getRendering(value) : ", "
					+ this.owlEditorKit.getModelManager().getRendering(value);
			toReturnBuilder.append(rendering);
		}
		return toReturnBuilder.toString();
	}

	/**
	 * @see org.protege.editor.core.ui.list.MListItem#handleDelete()
	 */
	public boolean handleDelete() {
		this.notifyListeners(this.getVariable());
		for (OPPLMacroListener l : new ArrayList<OPPLMacroListener>(this
				.getListeners())) {
			this.removeOPPLMacroListener(l);
		}
		return true;
	}

	/**
	 * @see org.protege.editor.core.ui.list.MListItem#handleEdit()
	 */
	public void handleEdit() {
		final ScopeEditor scopeEditor = ScopeEditor.getTypeScopeEditor(
				this.variable.getType(), this.owlEditorKit);
		final VerifyingOptionPane optionPane = new VerifyingOptionPane(
				scopeEditor) {
			/**
			 *
			 */
			private static final long serialVersionUID = 7217535942418544769L;

			@Override
			public void selectInitialValue() {
				// This is overridden so that the option pane dialog default
				// button
				// doesn't get the focus.
			}
		};
		if (this.owlEditorKit.getModelManager().getReasoner() instanceof NoOpReasoner) {
			JOptionPane
					.showMessageDialog(
							this.owlEditorKit.getWorkspace(),
							"You are not using any reasoner, in order to scope variables, please activate reasoning.",
							"No Reasoner", JOptionPane.ERROR_MESSAGE);
		} else {
			final InputVerificationStatusChangedListener verificationListener = new InputVerificationStatusChangedListener() {
				public void verifiedStatusChanged(boolean verified) {
					optionPane.setOKEnabled(verified);
				}
			};
			scopeEditor.addStatusChangedListener(verificationListener);
			final JDialog dlg = optionPane.createDialog(this.owlEditorKit
					.getWorkspace(), null);
			// The editor shouldn't be modal (or should it?)
			dlg.setModal(false);
			dlg.setTitle(scopeEditor.getTitle());
			dlg.setResizable(true);
			dlg.pack();
			dlg.setLocationRelativeTo(this.owlEditorKit.getWorkspace());
			dlg.addComponentListener(new ComponentAdapter() {
				@Override
				public void componentHidden(ComponentEvent e) {
					Object retVal = optionPane.getValue();
					if (retVal != null && retVal.equals(JOptionPane.OK_OPTION)) {
						VariableScope variableScope = scopeEditor
								.getVariableScope();
						try {
							VariableListItem.this.variable.setVariableScope(
									variableScope, VariableListItem.this
											.getConstraintSystem()
											.getOPPLFactory()
											.getVariableScopeChecker());
						} catch (OPPLException e1) {
							throw new RuntimeException(e1);
						}
					}
					scopeEditor
							.removeStatusChangedListener(verificationListener);
				}
			});
			dlg.setVisible(true);
		}
	}

	/**
	 * @see org.protege.editor.core.ui.list.MListItem#isDeleteable()
	 */
	public boolean isDeleteable() {
		return this.isDeleteable;
	}

	/**
	 * @see org.protege.editor.core.ui.list.MListItem#isEditable()
	 */
	public boolean isEditable() {
		return this.isEditable
				&& this.variable.getType() != org.coode.oppl.variabletypes.CONSTANT;
	}

	/**
	 * @return the variable
	 */
	public Variable getVariable() {
		return this.variable;
	}

	public void addOPPLMacroListener(OPPLMacroListener listener) {
		this.listeners.add(listener);
	}

	public void removeOPPLMacroListener(OPPLMacroListener listener) {
		this.listeners.remove(listener);
	}

	private void notifyListeners(Variable variable1) {
		for (OPPLMacroListener listener : this.listeners) {
			listener.handleDeletedVariable(variable1);
		}
	}

	/**
	 * @return the listeners
	 */
	private Collection<OPPLMacroListener> getListeners() {
		return this.listeners;
	}

	/**
	 * @return the owlEditorKit
	 */
	protected final OWLEditorKit getOwlEditorKit() {
		return this.owlEditorKit;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (this.isDeleteable ? 1231 : 1237);
		result = prime * result + (this.isEditable ? 1231 : 1237);
		result = prime * result
				+ (this.variable == null ? 0 : this.variable.hashCode());
		return result;
	}

	/**
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (this.getClass() != obj.getClass()) {
			return false;
		}
		VariableListItem other = (VariableListItem) obj;
		if (this.isDeleteable != other.isDeleteable) {
			return false;
		}
		if (this.isEditable != other.isEditable) {
			return false;
		}
		if (this.variable == null) {
			if (other.variable != null) {
				return false;
			}
		} else if (!this.variable.equals(other.variable)) {
			return false;
		}
		return true;
	}

	/**
	 * @return the constraintSystem
	 */
	public ConstraintSystem getConstraintSystem() {
		return this.constraintSystem;
	}

	/**
	 * @return the runtimeExceptionHandler
	 */
	public RuntimeExceptionHandler getRuntimeExceptionHandler() {
		return this.runtimeExceptionHandler;
	}
}
