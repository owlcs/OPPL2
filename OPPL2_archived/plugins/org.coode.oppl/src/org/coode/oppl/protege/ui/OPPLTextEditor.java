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

import org.coode.oppl.OPPLScript;
import org.coode.oppl.syntax.OPPLParser;
import org.coode.oppl.syntax.ParseException;
import org.coode.oppl.utils.ArgCheck;
import org.coode.oppl.utils.ProtegeParserFactory;
import org.coode.oppl.validation.OPPLScriptValidator;
import org.protege.editor.core.ui.util.ComponentFactory;
import org.protege.editor.core.ui.util.InputVerificationStatusChangedListener;
import org.protege.editor.core.ui.util.VerifiedInputEditor;
import org.protege.editor.owl.OWLEditorKit;
import org.protege.editor.owl.model.description.OWLExpressionParserException;
import org.protege.editor.owl.model.event.EventType;
import org.protege.editor.owl.model.event.OWLModelManagerChangeEvent;
import org.protege.editor.owl.model.event.OWLModelManagerListener;
import org.protege.editor.owl.ui.clsdescriptioneditor.ExpressionEditor;
import org.protege.editor.owl.ui.clsdescriptioneditor.OWLExpressionChecker;
import org.semanticweb.owl.model.OWLException;

/**
 * Text based editor for OPPL scripts
 * 
 * @author Luigi Iannone
 * 
 */
public final class OPPLTextEditor extends JPanel implements
		VerifiedInputEditor, OWLModelManagerListener {
	private static final long serialVersionUID = -5171397595615341059L;
	private final Set<InputVerificationStatusChangedListener> listeners = new HashSet<InputVerificationStatusChangedListener>();
	private final OWLEditorKit owlEditorKit;
	private OPPLScript opplScript = null;
	private final ExpressionEditor<OPPLScript> editor;
	protected final OPPLScriptValidator validator;

	/**
	 * @return the opplScript
	 */
	public OPPLScript getOPPLScript() {
		return this.opplScript;
	}

	/**
	 * @param opplScript
	 *            the opplScript to set
	 */
	public void setOPPLScript(OPPLScript opplScript) {
		String rendering = opplScript.render();
		this.editor.setText(rendering);
	}

	/**
	 * @return the owlEditorKit
	 */
	public OWLEditorKit getOWLEditorKit() {
		return this.owlEditorKit;
	}

	/**
	 * Builds an instance of this OPPLTextBuilder.
	 * 
	 * @param owlEditorKit
	 *            the editor kit for building the instance. Cannot be
	 *            {@code null}.
	 */
	protected OPPLTextEditor(OWLEditorKit owlEditorKit) {
		this(owlEditorKit, null);
	}

	/**
	 * Builds an instance of this OPPLTextBuilder.
	 * 
	 * @param owlEditorKit
	 *            the editor kit for building the instance. Cannot be
	 *            {@code null}.
	 * @param validator
	 *            performs custom validation checks on a syntactical valid
	 *            OPPLScript.
	 * @throws NullPointerException
	 *             when the input is {@code null}.
	 */
	protected OPPLTextEditor(OWLEditorKit owlEditorKit,
			OPPLScriptValidator validator) {
		this.owlEditorKit = owlEditorKit;
		this.validator = validator;
		this.editor = new ExpressionEditor<OPPLScript>(this.owlEditorKit,
				new OWLExpressionChecker<OPPLScript>() {
					private OPPLScript lastCreatedObject = null;

					public void check(String text)
							throws OWLExpressionParserException {
						this.lastCreatedObject = null;
						OPPLParser parser = ProtegeParserFactory.initParser(
								text, OPPLTextEditor.this.getOWLEditorKit()
										.getModelManager(),
								OPPLTextEditor.this.validator);
						try {
							this.lastCreatedObject = parser.Start();
						} catch (ParseException e) {
							this.lastCreatedObject = null;
							throw new OWLExpressionParserException(e);
						}
					}

					public OPPLScript createObject(String text)
							throws OWLExpressionParserException {
						this.check(text);
						return this.lastCreatedObject;
					}
				});
		this.editor
				.addStatusChangedListener(new InputVerificationStatusChangedListener() {
					@SuppressWarnings("unused")
					public void verifiedStatusChanged(boolean newState) {
						OPPLTextEditor.this.handleChange();
					}
				});
		this.removeKeyListeners();
		this.getOWLEditorKit().getModelManager().addListener(this);
		this.initGUI();
	}

	private void initGUI() {
		this.setLayout(new BorderLayout());
		this.add(ComponentFactory.createScrollPane(this.editor));
	}

	protected void handleChange() {
		boolean b = this.check();
		this.notifyListeners(b);
	}

	private boolean check() {
		try {
			this.opplScript = this.editor.createObject();
			return true;
		} catch (OWLExpressionParserException e) {
			this.opplScript = null;
			return false;
		} catch (OWLException e) {
			this.opplScript = null;
			return false;
		}
	}

	private void notifyListeners(boolean b) {
		for (InputVerificationStatusChangedListener l : this.listeners) {
			l.verifiedStatusChanged(b);
		}
	}

	/**
	 * @see org.protege.editor.core.ui.util.VerifiedInputEditor#addStatusChangedListener
	 *      (org.protege.editor.core.ui.util.InputVerificationStatusChangedListener)
	 */
	public void addStatusChangedListener(
			InputVerificationStatusChangedListener listener) {
		ArgCheck.checkNullArgument("The listener", listener);
		this.listeners.add(listener);
	}

	/**
	 * @see org.protege.editor.core.ui.util.VerifiedInputEditor#
	 *      removeStatusChangedListener (org.protege. editor .core.ui.util.
	 *      InputVerificationStatusChangedListener )
	 */
	public void removeStatusChangedListener(
			InputVerificationStatusChangedListener listener) {
		this.listeners.remove(listener);
	}

	protected void clear() {
		this.editor.setText("");
	}

	@Override
	public String getName() {
		return "OPPL Text Editor";
	}

	public void handleChange(OWLModelManagerChangeEvent event) {
		EventType type = event.getType();
		if (type.equals(EventType.REASONER_CHANGED)) {
			this.handleChange();
		}
	}

	public void dispose() {
		this.getOWLEditorKit().getModelManager().removeListener(this);
	}

	/**
	 *
	 */
	private void removeKeyListeners() {
		KeyListener[] keyListeners = this.editor.getKeyListeners();
		for (KeyListener keyListener : keyListeners) {
			this.editor.removeKeyListener(keyListener);
		}
	}
}
