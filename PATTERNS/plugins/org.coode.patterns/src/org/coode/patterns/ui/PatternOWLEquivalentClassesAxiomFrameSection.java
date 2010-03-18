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

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.coode.patterns.AbstractPatternModelFactory;
import org.coode.patterns.PatternModel;
import org.coode.patterns.utils.Utils;
import org.protege.editor.owl.OWLEditorKit;
import org.protege.editor.owl.ui.frame.OWLEquivalentClassesAxiomFrameSection;
import org.protege.editor.owl.ui.frame.OWLFrame;
import org.semanticweb.owl.model.OWLAxiomAnnotationAxiom;
import org.semanticweb.owl.model.OWLClass;
import org.semanticweb.owl.model.OWLDescription;
import org.semanticweb.owl.model.OWLEquivalentClassesAxiom;
import org.semanticweb.owl.model.OWLOntology;

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
			OWLDescription descr, OWLOntology ont) {
		Set<OWLEquivalentClassesAxiom> toReturn = new HashSet<OWLEquivalentClassesAxiom>();
		if (!descr.isAnonymous()) {
			for (OWLEquivalentClassesAxiom ax : ont
					.getEquivalentClassesAxioms(getRootObject().asOWLClass())) {
				Set<OWLAxiomAnnotationAxiom> annotationAxioms = ax
						.getAnnotationAxioms(ont);
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
		Set<OWLAxiomAnnotationAxiom> annotationAxioms = ax
				.getAnnotationAxioms(ontology);
		boolean isPatternGenerated = Utils.isPatternGenerated(annotationAxioms);
		if (isPatternGenerated) {
			PatternModel generatingPatternModel = Utils
					.getGeneratingPatternModel(annotationAxioms,
							getOWLEditorKit().getModelManager()
									.getOWLOntologyManager(), this.factory);
			if (generatingPatternModel != null) {
				addRow(new PatternOWLEquivalentClassesAxiomFrameSectionRow(
						getOWLEditorKit(), this, ontology, getRootObject()
								.asOWLClass(), ax, generatingPatternModel));
			}
		}
	}

	@Override
	protected void refillInferred() {
	}

	@Override
	public void visit(OWLAxiomAnnotationAxiom annotationAxiom) {
		if (Utils.isPatternGenerated(Collections.singleton(annotationAxiom))) {
			reset();
		}
	}
}
