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
import org.coode.oppl.ConstraintSystem;
import org.coode.oppl.OPPLParser;
import org.coode.oppl.OPPLParser.AbstractParserFactory;
import org.coode.oppl.protege.ProtegeParserFactory;
import org.coode.parsers.oppl.OPPLSymbolTable;
import org.coode.parsers.ui.ExpressionEditor;
import org.coode.parsers.ui.InputVerificationStatusChangedListener;
import org.coode.parsers.ui.VerifiedInputEditor;
import org.protege.editor.core.ui.util.ComponentFactory;
import org.protege.editor.owl.OWLEditorKit;

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
	private final OWLEditorKit owlEditorKit;
	private final ConstraintSystem constraintSystem;
	private final OPPLExpressionChecker<AbstractConstraint> constraintExpressionChecker;

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
	public void addStatusChangedListener(InputVerificationStatusChangedListener listener) {
		this.listeners.add(listener);
		listener.verifiedStatusChanged(this.check());
	}

	private boolean check() {
		boolean toReturn = false;
		this.constraint = this.constraintEditor.createObject();
		toReturn = this.constraint != null;
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
	public void removeStatusChangedListener(InputVerificationStatusChangedListener listener) {
		this.listeners.remove(listener);
	}

	public void handleChange() {
		boolean isValid = this.check();
		this.notifyListeners(isValid);
	}

	public OPPLConstraintEditor(OWLEditorKit owlEditorKit, ConstraintSystem constraintSystem) {
		this.setLayout(new BorderLayout());
		this.owlEditorKit = owlEditorKit;
		this.constraintSystem = constraintSystem;
		this.constraintExpressionChecker = new OPPLExpressionChecker<AbstractConstraint>(
				this.getOWLEditorKit()) {
			@Override
			protected AbstractConstraint parse(String text) {
				AbstractParserFactory factory = ProtegeParserFactory.getInstance(this.getOWLEditorKit());
				OPPLParser parser = factory.build(this.getListener());
				OPPLSymbolTable symbolTable = parser.getSymbolTableFactory().createSymbolTable();
				symbolTable.importConstraintSystem(OPPLConstraintEditor.this.getConstraintSystem());
				AbstractConstraint toReturn = parser.parseConstraint(
						text,
						symbolTable,
						OPPLConstraintEditor.this.getConstraintSystem());
				return toReturn;
			}
		};
		// Setup the constraint editor
		this.constraintEditor = new ExpressionEditor<AbstractConstraint>(
				this.getOWLEditorKit().getOWLModelManager().getOWLOntologyManager(),
				this.constraintExpressionChecker);
		JPanel constraintEditorPanel = new JPanel(new BorderLayout());
		constraintEditorPanel.add(ComponentFactory.createScrollPane(this.constraintEditor));
		// remove listeners
		KeyListener[] keyListeners = this.constraintEditor.getKeyListeners();
		for (KeyListener keyListener : keyListeners) {
			this.constraintEditor.removeKeyListener(keyListener);
		}
		this.constraintEditor.addStatusChangedListener(new InputVerificationStatusChangedListener() {
			public void verifiedStatusChanged(boolean newState) {
				OPPLConstraintEditor.this.handleChange();
			}
		});
		this.add(constraintEditorPanel, BorderLayout.CENTER);
	}

	public void dispose() {
	}

	/**
	 * @return the owlEditorKit
	 */
	public OWLEditorKit getOWLEditorKit() {
		return this.owlEditorKit;
	}

	/**
	 * @return the constraintSystem
	 */
	public ConstraintSystem getConstraintSystem() {
		return this.constraintSystem;
	}
}
