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

import org.coode.patterns.AbstractPatternModelFactory;
import org.protege.editor.owl.OWLEditorKit;
import org.protege.editor.owl.ui.frame.AbstractOWLFrame;
import org.semanticweb.owl.model.OWLOntology;

/**
 * @author Luigi Iannone
 * 
 *         Jun 11, 2008
 */
public class PatternOntologyFrame extends AbstractOWLFrame<OWLOntology> {
	public PatternOntologyFrame(OWLEditorKit owlEditorKit,
			AbstractPatternModelFactory f) {
		super(owlEditorKit.getModelManager().getOWLOntologyManager());
		this.addSection(new PatternOntologyFrameSection(owlEditorKit, this, f));
	}

	public PatternOntologyFrame(OWLEditorKit owlEditorKit, boolean canEdit,
			boolean canAdd, boolean canDelete, AbstractPatternModelFactory f) {
		super(owlEditorKit.getModelManager().getOWLOntologyManager());
		this.addSection(new PatternOntologyFrameSection(owlEditorKit, this,
				canEdit, canAdd, canDelete, f));
	}
}
