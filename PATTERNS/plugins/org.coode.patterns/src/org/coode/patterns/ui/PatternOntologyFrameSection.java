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
import java.util.List;

import org.coode.patterns.AbstractPatternModelFactory;
import org.coode.patterns.PatternExtractor;
import org.coode.patterns.PatternModel;
import org.coode.patterns.protege.ProtegeParserFactory;
import org.protege.editor.owl.OWLEditorKit;
import org.protege.editor.owl.ui.frame.AbstractOWLFrameSection;
import org.protege.editor.owl.ui.frame.OWLFrame;
import org.protege.editor.owl.ui.frame.OWLFrameSectionRow;
import org.protege.editor.owl.ui.frame.OWLFrameSectionRowObjectEditor;
import org.semanticweb.owlapi.model.OWLAnnotation;
import org.semanticweb.owlapi.model.OWLConstant;
import org.semanticweb.owlapi.model.OWLConstantAnnotation;
import org.semanticweb.owlapi.model.OWLDataFactory;
import org.semanticweb.owlapi.model.OWLObject;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyAnnotationAxiom;
import org.semanticweb.owlapi.model.OWLOntologyChange;
import org.semanticweb.owlapi.model.RemoveAxiom;

/**
 * @author Luigi Iannone
 * 
 *         Jun 11, 2008
 */
public class PatternOntologyFrameSection extends
		AbstractOWLFrameSection<OWLOntology, OWLOntologyAnnotationAxiom, PatternModel> {
	private static final String LABEL = "Patterns ";
	protected boolean canEdit = true;
	protected boolean canAdd = true;
	protected boolean canDelete = true;
	private final AbstractPatternModelFactory factory;

	protected PatternOntologyFrameSection(OWLEditorKit editorKit,
			OWLFrame<? extends OWLOntology> frame) {
		this(editorKit, frame, true, true, true);
	}

	public PatternOntologyFrameSection(OWLEditorKit owlEditorKit,
			OWLFrame<? extends OWLOntology> frame, boolean canEdit, boolean canAdd,
			boolean canDelete) {
		super(owlEditorKit, LABEL, frame);
		this.canEdit = canEdit;
		this.canAdd = canAdd;
		this.canDelete = canDelete;
		this.factory = ProtegeParserFactory.getInstance(owlEditorKit).getPatternFactory();
	}

	@Override
	protected void clear() {
	}

	@Override
	public boolean canAdd() {
		return this.canAdd;
	}

	@Override
	public boolean canAddRows() {
		return this.canAdd;
	}

	@Override
	protected OWLOntologyAnnotationAxiom createAxiom(PatternModel object) {
		OWLDataFactory dataFactory = this.getOWLDataFactory();
		OWLConstant constant = dataFactory.getOWLTypedConstant(object.toString());
		URI annotationURI = object.getUri();
		OWLConstantAnnotation annotation = dataFactory.getOWLConstantAnnotation(
				annotationURI,
				constant);
		OWLOntologyAnnotationAxiom axiom = this.getOWLDataFactory().getOWLOntologyAnnotationAxiom(
				this.getRootObject(),
				annotation);
		return axiom;
	}

	@Override
	public OWLFrameSectionRowObjectEditor<PatternModel> getObjectEditor() {
		// return new PatternBuilder(this.getOWLEditorKit());
		return new PatternEditor(this.getOWLEditorKit(), this.factory);
	}

	@Override
	protected void refill(OWLOntology ontology) {
		for (OWLOntologyAnnotationAxiom ontologyAnnotationAxiom : this.getRootObject().getAnnotations(
				ontology)) {
			PatternExtractor patternExtractor = this.factory.getPatternExtractor(ProtegeParserFactory.getDefaultErrorListener());
			OWLAnnotation<? extends OWLObject> annotation = ontologyAnnotationAxiom.getAnnotation();
			if (annotation.accept(patternExtractor) != null) {
				this.addRow(new PatternOntologyFrameSectionRow(this.getOWLEditorKit(), this,
						ontology, this.getRootObject(), ontologyAnnotationAxiom, this.canEdit,
						this.canDelete));
			}
		}
	}

	public Comparator<OWLFrameSectionRow<OWLOntology, OWLOntologyAnnotationAxiom, PatternModel>> getRowComparator() {
		return null;
	}

	@Override
	public void visit(OWLOntologyAnnotationAxiom ontologyAnnotationAxiom) {
		PatternExtractor patternExtractor = this.factory.getPatternExtractor(ProtegeParserFactory.getDefaultErrorListener());
		OWLAnnotation<? extends OWLObject> annotation = ontologyAnnotationAxiom.getAnnotation();
		if (annotation.accept(patternExtractor) != null) {
			this.reset();
		}
	}

	@Override
	protected void handleChanges(List<? extends OWLOntologyChange> changes) {
		if (this.getRootObject() == null) {
			return;
		}
		for (OWLOntologyChange change : changes) {
			if (change.isAxiomChange() && !(change instanceof RemoveAxiom)) {
				change.getAxiom().accept(PatternOntologyFrameSection.this);
			}
		}
	}
}
