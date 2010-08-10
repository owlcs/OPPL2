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

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

import org.coode.patterns.AbstractPatternModelFactory;
import org.coode.patterns.InstantiatedPatternModel;
import org.coode.patterns.NonClassPatternExecutor;
import org.coode.patterns.PatternExtractor;
import org.coode.patterns.PatternManager;
import org.coode.patterns.PatternModel;
import org.coode.patterns.PatternOPPLScript;
import org.coode.patterns.protege.ProtegeParserFactory;
import org.protege.editor.core.ui.list.MListButton;
import org.protege.editor.core.ui.util.InputVerificationStatusChangedListener;
import org.protege.editor.core.ui.util.VerifyingOptionPane;
import org.protege.editor.owl.OWLEditorKit;
import org.protege.editor.owl.ui.frame.AbstractOWLFrameSectionRow;
import org.protege.editor.owl.ui.frame.OWLFrameSection;
import org.protege.editor.owl.ui.frame.OWLFrameSectionRowObjectEditor;
import org.semanticweb.owl.model.OWLAnnotation;
import org.semanticweb.owl.model.OWLAxiom;
import org.semanticweb.owl.model.OWLAxiomChange;
import org.semanticweb.owl.model.OWLConstant;
import org.semanticweb.owl.model.OWLConstantAnnotation;
import org.semanticweb.owl.model.OWLDataFactory;
import org.semanticweb.owl.model.OWLObject;
import org.semanticweb.owl.model.OWLOntology;
import org.semanticweb.owl.model.OWLOntologyAnnotationAxiom;
import org.semanticweb.owl.model.OWLOntologyChange;
import org.semanticweb.owl.model.OWLOntologyChangeException;
import org.semanticweb.owl.model.RemoveAxiom;

/**
 * @author Luigi Iannone
 * 
 *         Jun 12, 2008
 */
public class PatternOntologyFrameSectionRow extends
		AbstractOWLFrameSectionRow<OWLOntology, OWLOntologyAnnotationAxiom, PatternModel> implements
		ActionListener {
	private PatternModel patternModel;
	private boolean canEdit = true;
	private boolean canDelete = true;
	private final AbstractPatternModelFactory factory;

	protected PatternOntologyFrameSectionRow(OWLEditorKit owlEditorKit,
			OWLFrameSection<OWLOntology, OWLOntologyAnnotationAxiom, PatternModel> section,
			OWLOntology ontology, OWLOntology rootObject, OWLOntologyAnnotationAxiom axiom,
			boolean canEdit, boolean canDelete) {
		super(owlEditorKit, section, ontology, rootObject, axiom);
		this.factory = ProtegeParserFactory.getInstance(this.getOWLEditorKit()).getPatternFactory();
		PatternExtractor patternExtractor = this.factory.getPatternExtractor(ProtegeParserFactory.getDefaultErrorListener());
		OWLAnnotation<? extends OWLObject> annotation = axiom.getAnnotation();
		this.patternModel = (PatternModel) annotation.accept(patternExtractor);
		this.canEdit = canEdit;
		this.canDelete = canDelete;
	}

	@Override
	public List<MListButton> getAdditionalButtons() {
		return this.patternModel.isClassPattern() ? super.getAdditionalButtons()
				: new ArrayList<MListButton>(Collections.singleton(new InstantiatePatternButton(
						this)));
	}

	@Override
	public boolean isEditable() {
		return this.canEdit;
	}

	@Override
	public boolean isDeletable() {
		return this.canDelete;
	}

	@Override
	public boolean isDeleteable() {
		return this.canDelete;
	}

	@Override
	protected OWLOntologyAnnotationAxiom createAxiom(PatternModel editedObject) {
		OWLDataFactory dataFactory = this.getOWLDataFactory();
		OWLConstant constant = dataFactory.getOWLTypedConstant(editedObject.toString());
		URI annotationURI = editedObject.getUri();
		OWLConstantAnnotation annotation = dataFactory.getOWLConstantAnnotation(
				annotationURI,
				constant);
		return this.getOWLDataFactory().getOWLOntologyAnnotationAxiom(
				this.getRootObject(),
				annotation);
	}

	@Override
	protected OWLFrameSectionRowObjectEditor<PatternModel> getObjectEditor() {
		// PatternBuilder builder = new PatternBuilder(this.getOWLEditorKit());
		// builder.setPatternModel(this.patternModel);
		// return builder;
		PatternEditor editor = new PatternEditor(this.getOWLEditorKit(), this.factory);
		editor.setPatternModel(this.patternModel);
		return editor;
	}

	public List<? extends OWLObject> getManipulatableObjects() {
		return new ArrayList<OWLObject>(Collections.singleton(this.axiom));
	}

	@Override
	public List<? extends OWLOntologyChange> getDeletionChanges() {
		Set<OWLOntology> ontologies = this.getOWLEditorKit().getModelManager().getOntologies();
		List<PatternOPPLScript> dependingPatterns = new ArrayList<PatternOPPLScript>(
				this.patternModel.getDependingPatterns(
						ontologies,
						PatternManager.getDefaultErrorListener()));
		Comparator<PatternOPPLScript> dependencyComparator = new Comparator<PatternOPPLScript>() {
			public int compare(PatternOPPLScript aPatternOPPLScript,
					PatternOPPLScript anotherPatternOPPLScript) {
				if (aPatternOPPLScript instanceof PatternModel) {
					if (anotherPatternOPPLScript instanceof InstantiatedPatternModel) {
						return 1;
					} else {
						return aPatternOPPLScript.hashCode() - anotherPatternOPPLScript.hashCode();
					}
				} else if (anotherPatternOPPLScript instanceof InstantiatedPatternModel) {
					return aPatternOPPLScript.hashCode() - anotherPatternOPPLScript.hashCode();
				} else {
					return -1;
				}
			}
		};
		List<OWLOntologyChange> changes = new ArrayList<OWLOntologyChange>(dependingPatterns.size());
		Collections.sort(dependingPatterns, dependencyComparator);
		// System.out.println(this.patternModel.getPatternLocalName()
		// + " dependencies " + dependingPatterns);
		for (PatternOPPLScript patternscript : dependingPatterns) {
			for (OWLOntology ontology : this.getOWLEditorKit().getModelManager().getOntologies()) {
				Set<? extends OWLAxiom> dependingAxioms = patternscript.getOWLAxioms(
						ontology,
						PatternManager.getDefaultErrorListener());
				for (OWLAxiom dependingAxiom : dependingAxioms) {
					changes.add(changes.size(), new RemoveAxiom(ontology, dependingAxiom));
				}
			}
		}
		for (OWLOntology ontology : ontologies) {
			Set<? extends OWLAxiom> axioms = this.patternModel.getOWLAxioms(
					ontology,
					PatternManager.getDefaultErrorListener());
			for (OWLAxiom ax : axioms) {
				changes.add(changes.size(), new RemoveAxiom(ontology, ax));
			}
		}
		return changes;
	}

	public void actionPerformed(ActionEvent e) {
		this.showInstantiationEditorDialog();
	}

	private void showInstantiationEditorDialog() {
		final PatternInstantiationEditor editor = new PatternInstantiationEditor(
				this.getOWLEditorKit(), this.factory);
		final JComponent editorComponent = editor.getEditorComponent();
		final VerifyingOptionPane optionPane = new VerifyingOptionPane(editor.getEditorComponent());
		final InputVerificationStatusChangedListener verificationListener = new InputVerificationStatusChangedListener() {
			public void verifiedStatusChanged(boolean verified) {
				optionPane.setOKEnabled(verified);
			}
		};
		InstantiatedPatternModel instantiatedPatternModel = this.factory.createInstantiatedPatternModel(this.patternModel);
		editor.setInstantiatedPatternModel(instantiatedPatternModel);
		editor.addStatusChangedListener(verificationListener);
		final JDialog dlg = optionPane.createDialog(this.getOWLEditorKit().getWorkspace(), null);
		// The editor shouldn't be modal (or should it?)
		dlg.setModal(false);
		dlg.setTitle(this.patternModel.getName());
		dlg.setResizable(true);
		dlg.pack();
		dlg.setLocationRelativeTo(this.getOWLEditorKit().getWorkspace());
		dlg.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentHidden(ComponentEvent e) {
				Object retVal = optionPane.getValue();
				editorComponent.setPreferredSize(editorComponent.getSize());
				if (retVal != null && retVal.equals(JOptionPane.OK_OPTION)) {
					PatternOntologyFrameSectionRow.this.handleInstantiation(editor);
				}
				editor.removeStatusChangedListener(verificationListener);
				editor.dispose();
			}
		});
		dlg.setVisible(true);
	}

	protected void handleInstantiation(PatternInstantiationEditor editor) {
		NonClassPatternExecutor patternExecutor = new NonClassPatternExecutor(
				editor.getEditedObject(),
				this.getOWLEditorKit().getModelManager().getActiveOntology(),
				this.getOWLEditorKit().getModelManager().getOWLOntologyManager(),
				this.patternModel.getUri());
		List<OWLAxiomChange> changes = this.patternModel.accept(patternExecutor);
		for (OWLAxiomChange change : changes) {
			try {
				this.getOWLEditorKit().getModelManager().getOWLOntologyManager().applyChange(change);
			} catch (OWLOntologyChangeException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * @return the patternModel
	 */
	final PatternModel getPatternModel() {
		return this.patternModel;
	}
}
