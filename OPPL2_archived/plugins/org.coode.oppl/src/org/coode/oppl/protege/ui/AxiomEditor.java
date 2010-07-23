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
import java.awt.event.KeyListener;
import java.util.HashSet;
import java.util.Set;

import javax.swing.JPanel;

import org.coode.oppl.protege.ui.rendering.VariableOWLCellRenderer;
import org.coode.oppl.variablemansyntax.ConstraintSystem;
import org.coode.oppl.variablemansyntax.VariableManchesterOWLSyntaxParser;
import org.protege.editor.core.ui.util.ComponentFactory;
import org.protege.editor.core.ui.util.InputVerificationStatusChangedListener;
import org.protege.editor.core.ui.util.VerifiedInputEditor;
import org.protege.editor.owl.OWLEditorKit;
import org.protege.editor.owl.model.description.OWLExpressionParserException;
import org.protege.editor.owl.ui.clsdescriptioneditor.ExpressionEditor;
import org.protege.editor.owl.ui.clsdescriptioneditor.OWLExpressionChecker;
import org.protege.editor.owl.ui.renderer.OWLCellRenderer;
import org.semanticweb.owl.expression.ParserException;
import org.semanticweb.owl.model.OWLAxiom;
import org.semanticweb.owl.model.OWLException;

/**
 * @author Luigi Iannone
 * 
 */
public class AxiomEditor extends JPanel implements VerifiedInputEditor {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6596764398797669959L;
	private final Set<InputVerificationStatusChangedListener> listeners = new HashSet<InputVerificationStatusChangedListener>();
	private final ExpressionEditor<OWLAxiom> editor;
	private final OWLEditorKit owlEditorKit;
	protected final ConstraintSystem constraintSystem;
	private OWLAxiom axiom = null;

	protected AxiomEditor(OWLEditorKit owlEditorKit,
			ConstraintSystem constraintSystem) {
		this.owlEditorKit = owlEditorKit;
		this.constraintSystem = constraintSystem;
		setLayout(new BorderLayout());
		this.editor = new ExpressionEditor<OWLAxiom>(this.owlEditorKit,
				new OWLExpressionChecker<OWLAxiom>() {
					private OWLAxiom lastEditedObject = null;

					public void check(String text)
							throws OWLExpressionParserException {
						this.lastEditedObject = null;
						VariableManchesterOWLSyntaxParser parser = new VariableManchesterOWLSyntaxParser(
								text, AxiomEditor.this.constraintSystem);
						try {
							this.lastEditedObject = parser.parseAxiom();
						} catch (ParserException e) {
							this.lastEditedObject = null;
							throw new OWLExpressionParserException(e);
						}
					}

					public OWLAxiom createObject(String text)
							throws OWLExpressionParserException {
						this.check(text);
						return this.lastEditedObject;
					}
				});
		// Deactivating auto completions
		for (KeyListener l : this.editor.getKeyListeners()) {
			this.editor.removeKeyListener(l);
		}
		this.editor
				.addStatusChangedListener(new InputVerificationStatusChangedListener() {
					public void verifiedStatusChanged(boolean newState) {
						AxiomEditor.this.check();
						AxiomEditor.this.notifyListeners(newState);
					}
				});
		JPanel editorPanel = new JPanel(new BorderLayout());
		editorPanel.setBorder(ComponentFactory
				.createTitledBorder("Axiom body:"));
		this.editor.setPreferredSize(new Dimension(50, 100));
		editorPanel.add(ComponentFactory.createScrollPane(this.editor));
		this.add(editorPanel, BorderLayout.CENTER);
	}

	/**
	 * @see org.protege.editor.core.ui.util.VerifiedInputEditor#addStatusChangedListener(org.protege.editor.core.ui.util.InputVerificationStatusChangedListener)
	 */
	public void addStatusChangedListener(
			InputVerificationStatusChangedListener listener) {
		listener.verifiedStatusChanged(check());
		this.listeners.add(listener);
	}

	protected boolean check() {
		try {
			this.axiom = this.editor.createObject();
			return true;
		} catch (OWLExpressionParserException e) {
			this.axiom = null;
			return false;
		} catch (OWLException e) {
			this.axiom = null;
			return false;
		}
	}

	/**
	 * @see org.protege.editor.core.ui.util.VerifiedInputEditor#removeStatusChangedListener(org.protege.editor.core.ui.util.InputVerificationStatusChangedListener)
	 */
	public void removeStatusChangedListener(
			InputVerificationStatusChangedListener listener) {
		this.listeners.remove(listener);
	}

	protected void notifyListeners(boolean newStatus) {
		for (InputVerificationStatusChangedListener listener : this.listeners) {
			listener.verifiedStatusChanged(newStatus);
		}
	}

	public OWLAxiom getAxiom() {
		return this.axiom;
	}

	protected void clear() {
		this.editor.setText("");
	}

	public void setOWLAxiom(OWLAxiom anOWLAxiom) {
		VariableOWLCellRenderer renderer = new VariableOWLCellRenderer(
				this.owlEditorKit, this.constraintSystem, new OWLCellRenderer(
						this.owlEditorKit));
		this.editor.setText(renderer.getRendering(anOWLAxiom));
	}
}
