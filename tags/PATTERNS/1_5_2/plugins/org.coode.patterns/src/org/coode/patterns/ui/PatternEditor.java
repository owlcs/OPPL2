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
import java.util.List;
import java.util.Set;

import javax.swing.JComponent;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import org.coode.oppl.utils.ArgCheck;
import org.coode.parsers.ui.InputVerificationStatusChangedListener;
import org.coode.patterns.AbstractPatternModelFactory;
import org.coode.patterns.PatternModel;
import org.protege.editor.owl.OWLEditorKit;
import org.protege.editor.owl.model.event.OWLModelManagerChangeEvent;
import org.protege.editor.owl.model.event.OWLModelManagerListener;
import org.protege.editor.owl.ui.editor.AbstractOWLObjectEditor;
import org.semanticweb.owlapi.model.OWLException;
import org.semanticweb.owlapi.model.OWLOntologyChange;
import org.semanticweb.owlapi.model.OWLOntologyChangeListener;

/**
 * @author Luigi Iannone
 * 
 *         Apr 2, 2009
 */
public class PatternEditor extends AbstractOWLObjectEditor<PatternModel> implements
		org.protege.editor.core.ui.util.VerifiedInputEditor, ChangeListener {
	private final JTabbedPane mainPanel = new JTabbedPane();
	private final Set<org.protege.editor.core.ui.util.InputVerificationStatusChangedListener> listeners = new HashSet<org.protege.editor.core.ui.util.InputVerificationStatusChangedListener>();
	private final PatternBuilder patternBuilder;
	private final TypeInPatternBuilder patternTextEditor;
	private PatternModel patternModel = null;
	private final OWLModelManagerListener modelManagerListener = new OWLModelManagerListener() {
		public void handleChange(OWLModelManagerChangeEvent event) {
			PatternEditor.this.mainPanel.setSelectedComponent(PatternEditor.this.patternBuilder.getEditorComponent());
		}
	};
	private final OWLOntologyChangeListener ontologyChangeListener = new OWLOntologyChangeListener() {
		public void ontologiesChanged(List<? extends OWLOntologyChange> changes)
				throws OWLException {
			PatternEditor.this.mainPanel.setSelectedComponent(PatternEditor.this.patternBuilder.getEditorComponent());
		}
	};
	private final OWLEditorKit owlEditorKit;

	public PatternEditor(OWLEditorKit owlEditorKit, AbstractPatternModelFactory f) {
		if (owlEditorKit == null) {
			throw new NullPointerException("The OWL editor kit cannot be null");
		}
		if (f == null) {
			throw new NullPointerException("The Pattern factory cannot be null");
		}
		this.owlEditorKit = owlEditorKit;
		this.patternBuilder = new PatternBuilder(this.getOWLEditorKit(), f);
		this.patternTextEditor = new TypeInPatternBuilder(this.getOWLEditorKit());
		this.patternBuilder.addStatusChangedListener(new InputVerificationStatusChangedListener() {
			public void verifiedStatusChanged(boolean newState) {
				PatternEditor.this.patternModel = null;
				if (newState) {
					PatternEditor.this.patternModel = PatternEditor.this.patternBuilder.getEditedObject();
				}
				PatternEditor.this.handleChange();
			}
		});
		this.patternTextEditor.addStatusChangedListener(new InputVerificationStatusChangedListener() {
			public void verifiedStatusChanged(boolean newState) {
				PatternEditor.this.patternModel = null;
				if (newState) {
					PatternEditor.this.patternModel = PatternEditor.this.patternTextEditor.getEditedObject();
				}
				PatternEditor.this.handleChange();
			}
		});
		this.mainPanel.addChangeListener(this);
		this.getOWLEditorKit().getOWLModelManager().addListener(this.modelManagerListener);
		this.getOWLEditorKit().getOWLModelManager().getOWLOntologyManager().addOntologyChangeListener(
				this.ontologyChangeListener);
		this.initGUI();
		this.handleChange();
	}

	protected void handleChange() {
		boolean newState = this.patternModel != null;
		this.notifyListeners(newState);
	}

	private void notifyListeners(boolean newState) {
		for (org.protege.editor.core.ui.util.InputVerificationStatusChangedListener l : this.listeners) {
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
			org.protege.editor.core.ui.util.InputVerificationStatusChangedListener listener) {
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
			org.protege.editor.core.ui.util.InputVerificationStatusChangedListener listener) {
		this.listeners.remove(listener);
	}

	public void dispose() {
		this.listeners.clear();
		this.patternBuilder.dispose();
		this.patternTextEditor.dispose();
		this.getOWLEditorKit().getOWLModelManager().removeListener(this.modelManagerListener);
		this.getOWLEditorKit().getOWLModelManager().getOWLOntologyManager().removeOntologyChangeListener(
				this.ontologyChangeListener);
	}

	public PatternModel getEditedObject() {
		return this.patternModel;
	}

	public JComponent getEditorComponent() {
		return this.mainPanel;
	}

	public void stateChanged(ChangeEvent e) {
		Component selectedComponent = this.mainPanel.getSelectedComponent();
		if (this.patternModel != null) {
			if (selectedComponent.equals(this.patternBuilder.getEditorComponent())) {
				this.patternBuilder.setPatternModel(this.patternModel);
			}
			if (selectedComponent.equals(this.patternTextEditor.getEditorComponent())) {
				this.patternTextEditor.setPatternModel(this.patternModel);
			}
		}
	}

	public void setPatternModel(PatternModel patternModel) {
		this.patternTextEditor.setPatternModel(patternModel);
		this.patternBuilder.setPatternModel(patternModel);
	}

	public boolean canEdit(Object object) {
		return true;
	}

	public String getEditorTypeName() {
		return "Pattern model editor";
	}

	public boolean setEditedObject(PatternModel editedObject) {
		this.setPatternModel(editedObject);
		return true;
	}

	/**
	 * @return the owlEditorKit
	 */
	public OWLEditorKit getOWLEditorKit() {
		return this.owlEditorKit;
	}
}
