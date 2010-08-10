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
import java.util.Comparator;
import java.util.Iterator;
import java.util.Set;

import javax.swing.JOptionPane;

import org.coode.patterns.AbstractPatternModelFactory;
import org.coode.patterns.InstantiatedPatternModel;
import org.coode.patterns.PatternExtractor;
import org.coode.patterns.PatternModel;
import org.coode.patterns.PatternOPPLScript;
import org.coode.patterns.protege.ProtegeParserFactory;
import org.protege.editor.owl.OWLEditorKit;
import org.protege.editor.owl.model.inference.NoOpReasoner;
import org.protege.editor.owl.ui.frame.AbstractOWLFrameSection;
import org.protege.editor.owl.ui.frame.OWLFrame;
import org.protege.editor.owl.ui.frame.OWLFrameSectionRow;
import org.protege.editor.owl.ui.frame.OWLFrameSectionRowObjectEditor;
import org.semanticweb.owl.inference.OWLReasonerException;
import org.semanticweb.owl.model.OWLAnnotation;
import org.semanticweb.owl.model.OWLAnnotationAxiom;
import org.semanticweb.owl.model.OWLClass;
import org.semanticweb.owl.model.OWLConstant;
import org.semanticweb.owl.model.OWLConstantAnnotation;
import org.semanticweb.owl.model.OWLDataFactory;
import org.semanticweb.owl.model.OWLEntityAnnotationAxiom;
import org.semanticweb.owl.model.OWLObject;
import org.semanticweb.owl.model.OWLOntology;

/**
 * @author Luigi Iannone
 * 
 */
public class PatternClassFrameSection extends
		AbstractOWLFrameSection<OWLClass, OWLEntityAnnotationAxiom, InstantiatedPatternModel> {
	private static final String LABEL = "Patterns";
	private final AbstractPatternModelFactory factory;

	protected PatternClassFrameSection(OWLEditorKit editorKit, OWLFrame<? extends OWLClass> frame,
			AbstractPatternModelFactory f) {
		super(editorKit, LABEL, frame);
		this.factory = f;
	}

	@Override
	public boolean canAdd() {
		return this.canAddRows();
	}

	@Override
	public boolean canAddRows() {
		return true;
	}

	@Override
	protected void clear() {
	}

	@Override
	protected OWLEntityAnnotationAxiom createAxiom(InstantiatedPatternModel instantiatedPattern) {
		OWLDataFactory dataFactory = this.getOWLDataFactory();
		OWLConstant constant = dataFactory.getOWLTypedConstant(instantiatedPattern.toString());
		URI annotationURI = URI.create(PatternModel.NAMESPACE
		// +
		// this.getOWLModelManager().getRendering(this.getRootObject())
				+ instantiatedPattern.getInstantiatedPatternLocalName() + "PatternInstantiation");
		OWLConstantAnnotation annotation = dataFactory.getOWLConstantAnnotation(
				annotationURI,
				constant);
		OWLEntityAnnotationAxiom axiom = this.getOWLDataFactory().getOWLEntityAnnotationAxiom(
				this.getRootObject(),
				annotation);
		return axiom;
	}

	@Override
	public OWLFrameSectionRowObjectEditor<InstantiatedPatternModel> getObjectEditor() {
		// return new TypeInClassPatternEditor(this.getOWLEditorKit());
		return new PatternInstantiationEditor(this.getOWLEditorKit(), this.getRootObject(),
				this.factory);
	}

	@SuppressWarnings("unchecked")
	@Override
	protected void refill(OWLOntology ontology) {
		OWLClass rootObject = this.getRootObject();
		Set<OWLAnnotationAxiom> annotationAxioms = rootObject.getAnnotationAxioms(ontology);
		PatternExtractor patternExtractor = this.factory.getPatternExtractor(ProtegeParserFactory.getDefaultErrorListener());
		for (OWLAnnotationAxiom annotationAxiom : annotationAxioms) {
			OWLAnnotation annotation = annotationAxiom.getAnnotation();
			PatternOPPLScript statementModel = (PatternOPPLScript) annotation.accept(patternExtractor);
			if (statementModel != null) {
				OWLFrameSectionRow<OWLClass, OWLEntityAnnotationAxiom, InstantiatedPatternModel> row = new PatternClassFrameSectionRow(
						this.getOWLEditorKit(), this, ontology, this.getRootObject(),
						(OWLEntityAnnotationAxiom) annotationAxiom, this.factory);
				this.addRow(row);
			}
		}
	}

	@Override
	protected void refillInferred() throws OWLReasonerException {
	}

	public Comparator<OWLFrameSectionRow<OWLClass, OWLEntityAnnotationAxiom, InstantiatedPatternModel>> getRowComparator() {
		return null;
	}

	@Override
	public void visit(OWLEntityAnnotationAxiom annotationAxiom) {
		if (annotationAxiom.getSubject().equals(this.getRootObject())) {
			PatternExtractor patternExtractor = this.factory.getPatternExtractor(ProtegeParserFactory.getDefaultErrorListener());
			OWLAnnotation<? extends OWLObject> annotation = annotationAxiom.getAnnotation();
			if (annotation.accept(patternExtractor) != null) {
				this.reset();
				// List<OWLFrameSection> frameSections =
				// this.getFrame().getFrameSections();
				// for (OWLFrameSection frameSection : frameSections) {
				// if(AbstractOWLFrameSection.class.isAssignableFrom(frameSection.getClass())){
				// ((AbstractOWLFrameSection<?, ?, ?>)frameSection).;
				// }
				// }
			}
		}
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
				JOptionPane.showConfirmDialog(
						this.getOWLEditorKit().getWorkspace(),
						"The pattern model "
								+ instantiatedPatternModel.getName()
								+ " has got scoped variables but you are curently using a NoOpReasoner, the pattern will not work properly unless you activate reasoning.",
						"No Reasoner",
						JOptionPane.OK_OPTION);
			} else {
				super.handleEditingFinished(editedObjects);
			}
		}
	}
}
