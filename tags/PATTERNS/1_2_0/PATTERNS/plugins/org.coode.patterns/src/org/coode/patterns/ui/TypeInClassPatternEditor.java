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
import java.awt.Dimension;
import java.awt.event.KeyListener;
import java.util.HashSet;
import java.util.Set;

import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import org.coode.patterns.InstantiatedPatternModel;
import org.coode.patterns.protege.ProtegeInstantiatedPatternModel;
import org.protege.editor.core.ui.util.ComponentFactory;
import org.protege.editor.core.ui.util.InputVerificationStatusChangedListener;
import org.protege.editor.core.ui.util.VerifiedInputEditor;
import org.protege.editor.owl.OWLEditorKit;
import org.protege.editor.owl.model.description.OWLExpressionParserException;
import org.protege.editor.owl.ui.clsdescriptioneditor.ExpressionEditor;
import org.protege.editor.owl.ui.frame.AbstractOWLFrameSectionRowObjectEditor;
import org.semanticweb.owl.model.OWLException;

/**
 * @author Luigi Iannone
 * 
 *         Jul 2, 2008
 */
public class TypeInClassPatternEditor extends
		AbstractOWLFrameSectionRowObjectEditor<InstantiatedPatternModel>
		implements VerifiedInputEditor, InputVerificationStatusChangedListener {
	private OWLEditorKit owlEditorKit;
	private JPanel mainPane;
	private ExpressionEditor<ProtegeInstantiatedPatternModel> editor;
	protected InstantiatedPatternModel instantiatedPatternModel;
	protected Set<InputVerificationStatusChangedListener> listeners = new HashSet<InputVerificationStatusChangedListener>();

	public TypeInClassPatternEditor(OWLEditorKit owlEditorKit) {
		this.owlEditorKit = owlEditorKit;
		this.mainPane = new JPanel(new BorderLayout());
		this.mainPane.setFocusable(false);
		this.setup();
	}

	private void setup() {
		this.editor = new ExpressionEditor<ProtegeInstantiatedPatternModel>(
				this.owlEditorKit,
				new InstantiatedPatternModelExpressionChecker(
						this.owlEditorKit, true));
		// will go away when the completer will be removed from the expression
		// editor
		this.removeKeyListeners();
		new InstantiatedPatternCompleter(this.owlEditorKit, this.editor,
				this.editor.getExpressionChecker());
		this.editor.setPreferredSize(new Dimension(50, 200));
		this.editor.addStatusChangedListener(this);
		JScrollPane editorPane = ComponentFactory.createScrollPane(this.editor);
		JPanel editorPanel = new JPanel(new BorderLayout());
		editorPanel.setBorder(ComponentFactory
				.createTitledBorder("Instantiated Pattern "));
		editorPanel.add(editorPane);
		this.mainPane.add(editorPanel);
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

	public void clear() {
		this.mainPane.removeAll();
		this.setup();
	}

	public void dispose() {
		this.editor.removeStatusChangedListener(this);
	}

	public InstantiatedPatternModel getEditedObject() {
		return this.instantiatedPatternModel;
	}

	public JComponent getEditorComponent() {
		return this.mainPane;
	}

	/**
	 * @param listener
	 */
	private void notifyListener(InputVerificationStatusChangedListener listener) {
		boolean valid = this.instantiatedPatternModel != null ? this.instantiatedPatternModel
				.isValid()
				: false;
		listener.verifiedStatusChanged(valid);
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

	public void verifiedStatusChanged(boolean newState) {
		this.instantiatedPatternModel = null;
		if (newState) {
			try {
				this.instantiatedPatternModel = this.editor.createObject();
				this.handleChange();
			} catch (OWLExpressionParserException e) {
				e.printStackTrace();
			} catch (OWLException e) {
				e.printStackTrace();
			}
		}
		this.handleChange();
	}

	public void handleChange() {
		for (InputVerificationStatusChangedListener listener : this.listeners) {
			this.notifyListener(listener);
		}
	}

	public void setInstantiatedPatternModel(
			ProtegeInstantiatedPatternModel patternModel) {
		this.editor.setText(patternModel.render());
	}
}
