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

import java.net.URI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.swing.JOptionPane;

import org.coode.patterns.AbstractPatternModelFactory;
import org.coode.patterns.InstantiatedPatternModel;
import org.coode.patterns.PatternExtractor;
import org.coode.patterns.PatternModel;
import org.coode.patterns.protege.ProtegeInstantiatedPatternModel;
import org.coode.patterns.protege.ProtegeParserFactory;
import org.coode.patterns.utils.Utils;
import org.protege.editor.owl.OWLEditorKit;
import org.protege.editor.owl.model.inference.NoOpReasoner;
import org.protege.editor.owl.ui.frame.AbstractOWLFrameSectionRow;
import org.protege.editor.owl.ui.frame.OWLFrameSection;
import org.protege.editor.owl.ui.frame.OWLFrameSectionRowObjectEditor;
import org.semanticweb.owlapi.model.OWLAnnotation;
import org.semanticweb.owlapi.model.OWLAxiom;
import org.semanticweb.owlapi.model.OWLAxiomAnnotationAxiom;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLConstant;
import org.semanticweb.owlapi.model.OWLConstantAnnotation;
import org.semanticweb.owlapi.model.OWLDataFactory;
import org.semanticweb.owlapi.model.OWLEntityAnnotationAxiom;
import org.semanticweb.owlapi.model.OWLObject;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyChange;
import org.semanticweb.owlapi.model.RemoveAxiom;

/**
 * @author Luigi Iannone
 * 
 *         Jun 9, 2008
 */
public class PatternClassFrameSectionRow extends
		AbstractOWLFrameSectionRow<OWLClass, OWLEntityAnnotationAxiom, InstantiatedPatternModel> {
	private final InstantiatedPatternModel patternModel;
	private final AbstractPatternModelFactory factory;

	protected PatternClassFrameSectionRow(OWLEditorKit owlEditorKit,
			OWLFrameSection<OWLClass, OWLEntityAnnotationAxiom, InstantiatedPatternModel> section,
			OWLOntology ontology, OWLClass rootObject, OWLEntityAnnotationAxiom axiom,
			AbstractPatternModelFactory f) {
		super(owlEditorKit, section, ontology, rootObject, axiom);
		this.factory = f;
		PatternExtractor patternExtractor = this.factory.getPatternExtractor(ProtegeParserFactory.getDefaultErrorListener());
		OWLAnnotation<? extends OWLObject> annotation = axiom.getAnnotation();
		this.patternModel = (InstantiatedPatternModel) annotation.accept(patternExtractor);
	}

	@Override
	protected OWLEntityAnnotationAxiom createAxiom(InstantiatedPatternModel editedObject) {
		OWLDataFactory dataFactory = this.getOWLDataFactory();
		OWLConstant constant = dataFactory.getOWLTypedConstant(editedObject.toString());
		URI annotationURI = URI.create(PatternModel.NAMESPACE
		// +
		// this.getOWLModelManager().getRendering(this.getRootObject())
				+ editedObject.getInstantiatedPatternLocalName() + "PatternInstantiation");
		OWLConstantAnnotation annotation = dataFactory.getOWLConstantAnnotation(
				annotationURI,
				constant);
		return this.getOWLDataFactory().getOWLEntityAnnotationAxiom(
				this.getRootObject(),
				annotation);
	}

	@Override
	protected OWLFrameSectionRowObjectEditor<InstantiatedPatternModel> getObjectEditor() {
		PatternInstantiationEditor editor = new PatternInstantiationEditor(this.getOWLEditorKit(),
				this.getRootObject(), this.factory);
		OWLEntityAnnotationAxiom annotationAxiom = (OWLEntityAnnotationAxiom) this.getManipulatableObjects().iterator().next();
		PatternExtractor patternExtractor = this.factory.getPatternExtractor(ProtegeParserFactory.getDefaultErrorListener());
		OWLAnnotation<? extends OWLObject> annotation = annotationAxiom.getAnnotation();
		editor.setInstantiatedPatternModel((ProtegeInstantiatedPatternModel) annotation.accept(patternExtractor));
		return editor;
	}

	public List<? extends OWLObject> getManipulatableObjects() {
		return new ArrayList<OWLObject>(Collections.singleton(this.axiom));
	}

	@Override
	public List<? extends OWLOntologyChange> getDeletionChanges() {
		List<OWLOntologyChange> deletionChanges = new ArrayList<OWLOntologyChange>(
				super.getDeletionChanges());
		Set<OWLAxiom> axioms = this.getOntology().getAxioms();
		for (OWLAxiom ax : axioms) {
			Set<OWLAxiomAnnotationAxiom> annotationAxioms = ax.getAnnotationAxioms(this.getOntology());
			if (Utils.isPatternGenerated(
					this.patternModel.getInstantiatedPatternLocalName(),
					annotationAxioms)) {
				deletionChanges.add(new RemoveAxiom(this.getOntology(), ax));
			}
		}
		return deletionChanges;
	}

	@Override
	public void handleEditingFinished(Set<InstantiatedPatternModel> editedObjects) {
		Iterator<InstantiatedPatternModel> it = editedObjects.iterator();
		boolean found = false;
		InstantiatedPatternModel instantiatedPatternModel = null;
		while (!found && it.hasNext()) {
			instantiatedPatternModel = it.next();
			found = instantiatedPatternModel.hasScopedVariables()
					&& this.getOWLEditorKit().getModelManager().getReasoner() instanceof NoOpReasoner;
			if (found) {
				JOptionPane.showMessageDialog(
						this.getOWLEditorKit().getWorkspace(),
						"The pattern model "
								+ instantiatedPatternModel.getName()
								+ " has got scoped variables but you are curently using a NoOpReasoner, the pattern will not work properly unless you activate reasoning.",
						"No Reasoner",
						JOptionPane.ERROR_MESSAGE);
			} else {
				super.handleEditingFinished(editedObjects);
			}
		}
	}

	/**
	 * @return the patternModel
	 */
	public final InstantiatedPatternModel getPatternModel() {
		return this.patternModel;
	}
}
