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

import java.util.HashSet;
import java.util.Set;

import org.coode.patterns.AbstractPatternModelFactory;
import org.coode.patterns.PatternModel;
import org.coode.patterns.utils.Utils;
import org.protege.editor.owl.OWLEditorKit;
import org.protege.editor.owl.ui.frame.OWLFrame;
import org.protege.editor.owl.ui.frame.cls.OWLEquivalentClassesAxiomFrameSection;
import org.semanticweb.owlapi.model.OWLAnnotation;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLClassExpression;
import org.semanticweb.owlapi.model.OWLEquivalentClassesAxiom;
import org.semanticweb.owlapi.model.OWLOntology;

/**
 * @author Luigi Iannone
 * 
 *         Jul 22, 2008
 */
public class PatternOWLEquivalentClassesAxiomFrameSection extends
		OWLEquivalentClassesAxiomFrameSection {
	private final AbstractPatternModelFactory factory;

	/**
	 * @param editorKit
	 * @param frame
	 */
	public PatternOWLEquivalentClassesAxiomFrameSection(OWLEditorKit editorKit,
			OWLFrame<OWLClass> frame, AbstractPatternModelFactory f) {
		super(editorKit, frame);
		this.factory = f;
	}

	@Override
	public boolean canAdd() {
		return false;
	}

	@Override
	protected Set<OWLEquivalentClassesAxiom> getClassAxioms(
			OWLClassExpression descr, OWLOntology ont) {
		Set<OWLEquivalentClassesAxiom> toReturn = new HashSet<OWLEquivalentClassesAxiom>();
		if (!descr.isAnonymous()) {
			for (OWLEquivalentClassesAxiom ax : ont
					.getEquivalentClassesAxioms(this.getRootObject()
							.asOWLClass())) {
				Set<OWLAnnotation> annotationAxioms = ax.getAnnotations();
				boolean isPatternGenerated = Utils
						.isPatternGenerated(annotationAxioms);
				if (isPatternGenerated) {
					toReturn.add(ax);
				}
			}
		}
		return toReturn;
	}

	@Override
	protected void addAxiom(OWLEquivalentClassesAxiom ax, OWLOntology ontology) {
		Set<OWLAnnotation> annotationAxioms = ax.getAnnotations();
		boolean isPatternGenerated = Utils.isPatternGenerated(annotationAxioms);
		if (isPatternGenerated) {
			PatternModel generatingPatternModel = Utils
					.getGeneratingPatternModel(annotationAxioms, this
							.getOWLEditorKit().getModelManager()
							.getOWLOntologyManager(), this.factory);
			if (generatingPatternModel != null) {
				this
						.addRow(new PatternOWLEquivalentClassesAxiomFrameSectionRow(
								this.getOWLEditorKit(), this, ontology, this
										.getRootObject().asOWLClass(), ax,
								generatingPatternModel));
			}
		}
	}

	@Override
	protected void refillInferred() {
	}

	@Override
	public void visit(OWLEquivalentClassesAxiom axiom) {
		if (Utils.isPatternGenerated(axiom.getAnnotations())) {
			this.reset();
		}
	}
}
