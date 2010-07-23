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

import java.awt.Component;
import java.awt.Dimension;
import java.util.HashSet;
import java.util.Set;

import javax.swing.JComponent;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import org.coode.oppl.utils.ArgCheck;
import org.coode.patterns.AbstractPatternModelFactory;
import org.coode.patterns.PatternModel;
import org.protege.editor.core.ui.util.InputVerificationStatusChangedListener;
import org.protege.editor.core.ui.util.VerifiedInputEditor;
import org.protege.editor.owl.OWLEditorKit;
import org.protege.editor.owl.ui.frame.AbstractOWLFrameSectionRowObjectEditor;

/**
 * @author Luigi Iannone
 * 
 *         Apr 2, 2009
 */
public class PatternEditor extends
		AbstractOWLFrameSectionRowObjectEditor<PatternModel> implements
		VerifiedInputEditor, ChangeListener {
	private final JTabbedPane mainPanel = new JTabbedPane();
	private final Set<InputVerificationStatusChangedListener> listeners = new HashSet<InputVerificationStatusChangedListener>();
	protected final PatternBuilder patternBuilder;
	private final TypeInPatternBuilder patternTextEditor;
	protected PatternModel patternModel = null;

	public PatternEditor(OWLEditorKit owlEditorKit,
			AbstractPatternModelFactory f) {
		this.patternBuilder = new PatternBuilder(owlEditorKit, f);
		this.patternTextEditor = new TypeInPatternBuilder(owlEditorKit);
		this.patternBuilder
				.addStatusChangedListener(new InputVerificationStatusChangedListener() {
					public void verifiedStatusChanged(boolean newState) {
						PatternEditor.this.patternModel = null;
						if (newState) {
							PatternEditor.this.patternModel = PatternEditor.this.patternBuilder
									.getEditedObject();
						}
						PatternEditor.this.handleChange();
					}
				});
		this.patternTextEditor
				.addStatusChangedListener(new InputVerificationStatusChangedListener() {
					public void verifiedStatusChanged(boolean newState) {
						PatternEditor.this.patternModel = null;
						if (newState) {
							PatternEditor.this.patternModel = PatternEditor.this.patternTextEditor
									.getEditedObject();
						}
						PatternEditor.this.handleChange();
					}
				});
		this.mainPanel.addChangeListener(this);
		this.initGUI();
	}

	protected void handleChange() {
		boolean newState = this.patternModel != null;
		this.notifyListeners(newState);
	}

	private void notifyListeners(boolean newState) {
		for (InputVerificationStatusChangedListener l : this.listeners) {
			l.verifiedStatusChanged(newState);
		}
	}

	/**
	 *
	 */
	private void initGUI() {
		this.mainPanel.add(this.patternBuilder.getEditorComponent());
		this.mainPanel.add(this.patternTextEditor.getEditorComponent());
		this.mainPanel.setPreferredSize(new Dimension(600, 700));
	}

	/**
	 * @see org.protege.editor.core.ui.util.VerifiedInputEditor#addStatusChangedListener
	 *      (org.protege.editor.core.ui.util.InputVerificationStatusChangedListener)
	 */
	public void addStatusChangedListener(
			InputVerificationStatusChangedListener listener) {
		ArgCheck.checkNullArgument("The listener", listener);
		listener.verifiedStatusChanged(this.patternModel != null);
		this.listeners.add(listener);
	}

	/**
	 * @see org.protege.editor.core.ui.util.VerifiedInputEditor#
	 *      removeStatusChangedListener
	 *      (org.protege.editor.core.ui.util.InputVerificationStatusChangedListener)
	 */
	public void removeStatusChangedListener(
			InputVerificationStatusChangedListener listener) {
		this.listeners.remove(listener);
	}

	public void clear() {
		this.patternBuilder.clear();
		this.patternTextEditor.clear();
	}

	public void dispose() {
		this.patternBuilder.dispose();
		this.patternTextEditor.dispose();
	}

	public PatternModel getEditedObject() {
		return this.patternModel;
	}

	public JComponent getEditorComponent() {
		return this.mainPanel;
	}

	@SuppressWarnings("unused")
	public void stateChanged(ChangeEvent e) {
		Component selectedComponent = this.mainPanel.getSelectedComponent();
		if (this.patternModel != null) {
			if (selectedComponent.equals(this.patternBuilder
					.getEditorComponent())) {
				this.patternBuilder.setPatternModel(this.patternModel);
			}
			if (selectedComponent.equals(this.patternTextEditor
					.getEditorComponent())) {
				this.patternTextEditor.setPatternModel(this.patternModel);
			}
		}
	}

	public void setPatternModel(PatternModel patternModel) {
		this.patternTextEditor.setPatternModel(patternModel);
		this.patternBuilder.setPatternModel(patternModel);
	}
}
