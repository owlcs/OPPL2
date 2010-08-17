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

import org.coode.patterns.PatternModel;
import org.protege.editor.owl.OWLEditorKit;
import org.protege.editor.owl.ui.frame.OWLSubClassAxiomFrameSectionRow;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLSubClassAxiom;

/**
 * @author Luigi Iannone
 * 
 *         Jul 24, 2008
 */
public class PatternOWLSubClassAxiomFrameSectionRow extends
		OWLSubClassAxiomFrameSectionRow {
	private final PatternModel generatingPatternModel;

	/**
	 * @param owlEditorKit
	 * @param section
	 * @param ontology
	 * @param rootObject
	 * @param axiom
	 */
	public PatternOWLSubClassAxiomFrameSectionRow(OWLEditorKit owlEditorKit,
			PatternOWLSubCLassAxiomFrameSection section, OWLOntology ontology,
			OWLClass rootObject, OWLSubClassAxiom axiom,
			PatternModel generatingPatternModel) {
		super(owlEditorKit, section, ontology, rootObject, axiom);
		this.generatingPatternModel = generatingPatternModel;
	}

	@Override
	public boolean isDeleteable() {
		return false;
	}

	@Override
	public boolean isEditable() {
		return false;
	}

	/**
	 * @return the generatingPatternModel
	 */
	public final PatternModel getGeneratingPatternModel() {
		return this.generatingPatternModel;
	}
}
