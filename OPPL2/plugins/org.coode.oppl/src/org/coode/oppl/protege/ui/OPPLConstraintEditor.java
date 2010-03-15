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
import java.awt.event.KeyListener;
import java.util.HashSet;
import java.util.Set;

import javax.swing.JPanel;

import org.coode.oppl.AbstractConstraint;
import org.coode.oppl.syntax.ParseException;
import org.coode.oppl.syntax.TokenMgrError;
import org.coode.oppl.utils.ParserFactory;
import org.coode.oppl.utils.ProtegeParserFactory;
import org.coode.oppl.variablemansyntax.ConstraintSystem;
import org.protege.editor.core.ui.util.ComponentFactory;
import org.protege.editor.core.ui.util.InputVerificationStatusChangedListener;
import org.protege.editor.core.ui.util.VerifiedInputEditor;
import org.protege.editor.owl.OWLEditorKit;
import org.protege.editor.owl.model.description.OWLExpressionParserException;
import org.protege.editor.owl.ui.clsdescriptioneditor.ExpressionEditor;
import org.protege.editor.owl.ui.clsdescriptioneditor.OWLExpressionChecker;
import org.semanticweb.owl.model.OWLException;

/**
 * @author Luigi Iannone
 * 
 */
public class OPPLConstraintEditor extends JPanel implements VerifiedInputEditor {
	/**
	 *
	 */
	private static final long serialVersionUID = 3477960268272607549L;
	private final Set<InputVerificationStatusChangedListener> listeners = new HashSet<InputVerificationStatusChangedListener>();
	private final ExpressionEditor<AbstractConstraint> constraintEditor;
	private AbstractConstraint constraint;
	protected final OWLEditorKit owlEditorKit;
	protected final ConstraintSystem constraintSystem;

	/**
	 * @return the constraint
	 */
	public AbstractConstraint getConstraint() {
		return this.constraint;
	}

	/**
	 * @param constraint
	 *            the constraint to set
	 */
	public void setConstraint(AbstractConstraint constraint) {
		this.constraintEditor.setText(constraint.toString());
	}

	/**
	 * @see org.protege.editor.core.ui.util.VerifiedInputEditor#addStatusChangedListener(org.protege.editor.core.ui.util.InputVerificationStatusChangedListener)
	 */
	public void addStatusChangedListener(
			InputVerificationStatusChangedListener listener) {
		this.listeners.add(listener);
		listener.verifiedStatusChanged(this.check());
	}

	private boolean check() {
		boolean toReturn = false;
		try {
			this.constraintEditor.createObject();
			toReturn = true;
		} catch (OWLExpressionParserException e) {
			toReturn = false;
		} catch (OWLException e) {
			toReturn = false;
		}
		return toReturn;
	}

	/**
	 * @param isValid
	 */
	private void notifyListeners(boolean isValid) {
		for (InputVerificationStatusChangedListener listener : this.listeners) {
			listener.verifiedStatusChanged(isValid);
		}
	}

	/**
	 * @see org.protege.editor.core.ui.util.VerifiedInputEditor#removeStatusChangedListener(org.protege.editor.core.ui.util.InputVerificationStatusChangedListener)
	 */
	public void removeStatusChangedListener(
			InputVerificationStatusChangedListener listener) {
		this.listeners.remove(listener);
	}

	public void handleChange() {
		boolean isValid = this.check();
		if (isValid) {
			try {
				this.constraint = this.constraintEditor.createObject();
			} catch (OWLExpressionParserException e) {
				// This can be unless there is a bug in the check() method
				throw new RuntimeException(e);
			} catch (OWLException e) {
				// This can be unless there is a bug in the check() method
				throw new RuntimeException(e);
			}
		}
		this.notifyListeners(isValid);
	}

	public OPPLConstraintEditor(OWLEditorKit owlEditorKit,
			ConstraintSystem constraintSystem) {
		this.setLayout(new BorderLayout());
		this.owlEditorKit = owlEditorKit;
		this.constraintSystem = constraintSystem;
		// Setup the constraint editor
		this.constraintEditor = new ExpressionEditor<AbstractConstraint>(
				owlEditorKit, new OWLExpressionChecker<AbstractConstraint>() {
					private AbstractConstraint lastCheckedObject = null;

					public void check(String text)
							throws OWLExpressionParserException {
						this.lastCheckedObject = null;
						ProtegeParserFactory.initParser(text,
								OPPLConstraintEditor.this.owlEditorKit
										.getModelManager(), null);
						try {
							this.lastCheckedObject = ParserFactory
									.getInstance()
									.Constraint(
											OPPLConstraintEditor.this.constraintSystem);
						} catch (ParseException e) {
							this.lastCheckedObject = null;
							throw new OWLExpressionParserException(e);
						} catch (TokenMgrError e) {
							this.lastCheckedObject = null;
							throw new OWLExpressionParserException(e);
						}
					}

					public AbstractConstraint createObject(String text)
							throws OWLExpressionParserException {
						this.check(text);
						return this.lastCheckedObject;
					}
				});
		JPanel constraintEditorPanel = new JPanel(new BorderLayout());
		constraintEditorPanel.add(ComponentFactory
				.createScrollPane(this.constraintEditor));
		// remove listeners
		KeyListener[] keyListeners = this.constraintEditor.getKeyListeners();
		for (KeyListener keyListener : keyListeners) {
			this.constraintEditor.removeKeyListener(keyListener);
		}
		this.constraintEditor
				.addStatusChangedListener(new InputVerificationStatusChangedListener() {
					@SuppressWarnings("unused")
					public void verifiedStatusChanged(boolean newState) {
						OPPLConstraintEditor.this.handleChange();
					}
				});
		this.add(constraintEditorPanel, BorderLayout.CENTER);
	}

	public void dispose() {
	}
}
