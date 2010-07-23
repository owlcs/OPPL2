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
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import org.coode.oppl.variablemansyntax.ConstraintSystem;
import org.protege.editor.core.ui.util.ComponentFactory;
import org.protege.editor.core.ui.util.InputVerificationStatusChangedListener;
import org.protege.editor.core.ui.util.VerifiedInputEditor;
import org.protege.editor.owl.OWLEditorKit;
import org.semanticweb.owl.model.AddAxiom;
import org.semanticweb.owl.model.OWLAxiom;
import org.semanticweb.owl.model.OWLAxiomChange;
import org.semanticweb.owl.model.OWLOntology;
import org.semanticweb.owl.model.RemoveAxiom;

/**
 * @author Luigi Iannone
 * 
 */
public class OWLAxiomChangeEditor extends JPanel implements VerifiedInputEditor {
	/**
	 *
	 */
	private static final long serialVersionUID = 6494430323392010587L;
	private final Set<InputVerificationStatusChangedListener> listeners = new HashSet<InputVerificationStatusChangedListener>();
	private final OWLEditorKit owlEditorKit;
	private final AxiomEditor axiomEditor;
	private final ButtonGroup actionButtonGroup = new ButtonGroup();
	private final Map<JRadioButton, String> radioButtonActionMap = new HashMap<JRadioButton, String>();
	private final Map<String, JRadioButton> actionStringRadioButtonMap = new HashMap<String, JRadioButton>();
	private OWLAxiomChange owlAxiomChange;

	public OWLAxiomChangeEditor(OWLEditorKit owlEditorKit,
			ConstraintSystem constraintSystem) {
		this.owlEditorKit = owlEditorKit;
		this.axiomEditor = new AxiomEditor(this.owlEditorKit, constraintSystem);
		this.axiomEditor
				.addStatusChangedListener(new InputVerificationStatusChangedListener() {
					@SuppressWarnings("unused")
					public void verifiedStatusChanged(boolean newState) {
						OWLAxiomChangeEditor.this.handleChange();
					}
				});
		this.setLayout(new BorderLayout());
		JPanel actionPanel = new JPanel(new GridLayout(0, 2));
		JRadioButton addRadioButton = new JRadioButton("ADD");
		addRadioButton.setSelected(true);
		this.radioButtonActionMap.put(addRadioButton, "ADD");
		this.actionStringRadioButtonMap.put("ADD", addRadioButton);
		this.actionButtonGroup.add(addRadioButton);
		actionPanel.add(addRadioButton);
		JRadioButton removeRadioButton = new JRadioButton("REMOVE");
		this.radioButtonActionMap.put(removeRadioButton, "REMOVE");
		this.actionStringRadioButtonMap.put("REMOVE", removeRadioButton);
		this.actionButtonGroup.add(removeRadioButton);
		actionPanel.add(removeRadioButton);
		actionPanel.setBorder(ComponentFactory
				.createTitledBorder("Action Type:"));
		this.setLayout(new BorderLayout());
		this.add(actionPanel, BorderLayout.NORTH);
		this.add(this.axiomEditor, BorderLayout.CENTER);
	}

	/**
	 * @see org.protege.editor.core.ui.util.VerifiedInputEditor#addStatusChangedListener(org.protege.editor.core.ui.util.InputVerificationStatusChangedListener)
	 */
	public void addStatusChangedListener(
			InputVerificationStatusChangedListener listener) {
		listener.verifiedStatusChanged(this.check());
		this.listeners.add(listener);
	}

	private boolean check() {
		return this.findSelectedButton() != null
				&& this.axiomEditor.getAxiom() != null;
	}

	public void handleChange() {
		boolean isValid = this.check();
		if (isValid) {
			OWLAxiom axiom = this.axiomEditor.getAxiom();
			JRadioButton selectedButton = this.findSelectedButton();
			String action = this.radioButtonActionMap.get(selectedButton);
			OWLOntology activeOntology = this.owlEditorKit.getOWLModelManager()
					.getActiveOntology();
			this.owlAxiomChange = action.equals("ADD") ? new AddAxiom(
					activeOntology, axiom) : new RemoveAxiom(activeOntology,
					axiom);
		}
		this.notifyLIstenrs(isValid);
	}

	/**
	 * @see org.protege.editor.core.ui.util.VerifiedInputEditor#removeStatusChangedListener(org.protege.editor.core.ui.util.InputVerificationStatusChangedListener)
	 */
	public void removeStatusChangedListener(
			InputVerificationStatusChangedListener listener) {
		this.listeners.remove(listener);
	}

	public void notifyLIstenrs(boolean newState) {
		for (InputVerificationStatusChangedListener listener : this.listeners) {
			listener.verifiedStatusChanged(newState);
		}
	}

	private JRadioButton findSelectedButton() {
		JRadioButton button = null;
		Enumeration<AbstractButton> actions = this.actionButtonGroup
				.getElements();
		boolean found = false;
		while (!found && actions.hasMoreElements()) {
			button = (JRadioButton) actions.nextElement();
			found = button.isSelected();
		}
		return found ? button : null;
	}

	/**
	 * @return the owlAxiomChange
	 */
	public OWLAxiomChange getOwlAxiomChange() {
		return this.owlAxiomChange;
	}

	public void dispose() {
	}

	/**
	 * @param owlAxiomChange
	 *            the owlAxiomChange to set
	 */
	public void setOWLAxiomChange(OWLAxiomChange owlAxiomChange) {
		this.clear();
		JRadioButton radioButton = owlAxiomChange instanceof AddAxiom ? this.actionStringRadioButtonMap
				.get("ADD")
				: this.actionStringRadioButtonMap.get("REMOVE");
		radioButton.setSelected(true);
		this.axiomEditor.setOWLAxiom(owlAxiomChange.getAxiom());
	}

	public void clear() {
		JRadioButton button = null;
		Enumeration<AbstractButton> actions = this.actionButtonGroup
				.getElements();
		while (actions.hasMoreElements()) {
			button = (JRadioButton) actions.nextElement();
			button.setSelected(false);
		}
		this.axiomEditor.clear();
	}
}
