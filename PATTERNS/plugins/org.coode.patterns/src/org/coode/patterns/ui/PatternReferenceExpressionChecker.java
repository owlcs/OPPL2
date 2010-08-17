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

import java.util.Iterator;

import org.coode.patterns.AbstractPatternModelFactory;
import org.coode.patterns.InstantiatedPatternModel;
import org.coode.patterns.PatternModel;
import org.coode.patterns.PatternReferenceNotFoundException;
import org.coode.patterns.protege.ProtegeParserFactory;
import org.coode.patterns.utils.Utils;
import org.protege.editor.owl.OWLEditorKit;
import org.protege.editor.owl.model.description.OWLExpressionParserException;
import org.protege.editor.owl.ui.clsdescriptioneditor.OWLExpressionChecker;
import org.semanticweb.owlapi.model.OWLOntology;

/**
 * @author Luigi Iannone
 * 
 *         Nov 17, 2008
 */
public class PatternReferenceExpressionChecker implements
		OWLExpressionChecker<InstantiatedPatternModel> {
	private OWLEditorKit owlEditorKit;
	private InstantiatedPatternModel instantiatedPatternModel = null;

	/**
	 * @param owlEditorKit
	 */
	public PatternReferenceExpressionChecker(OWLEditorKit owlEditorKit,
			AbstractPatternModelFactory factory) {
		this.owlEditorKit = owlEditorKit;
	}

	/**
	 * @see org.protege.editor.owl.ui.clsdescriptioneditor.OWLExpressionChecker#check(java.lang.String)
	 */
	public void check(String text) throws OWLExpressionParserException {
		Iterator<OWLOntology> it = this.owlEditorKit.getModelManager().getOntologies().iterator();
		this.instantiatedPatternModel = null;
		boolean found = false;
		PatternModel patternModel = null;
		AbstractPatternModelFactory patternFactory = ProtegeParserFactory.getInstance(
				this.owlEditorKit).getPatternFactory();
		while (!found && it.hasNext()) {
			OWLOntology ontology = it.next();
			patternModel = Utils.find(text, ontology, patternFactory);
			found = patternModel != null;
		}
		if (found) {
			this.instantiatedPatternModel = patternFactory.createInstantiatedPatternModel(patternModel);
		} else {
			throw new OWLExpressionParserException(new PatternReferenceNotFoundException(
					"Invalid pattern name: " + text));
		}
	}

	/**
	 * *
	 * 
	 * @see org.protege.editor.owl.ui.clsdescriptioneditor.OWLExpressionChecker#createObject(java.lang.String)
	 */
	public InstantiatedPatternModel createObject(String text) throws OWLExpressionParserException {
		this.check(text);
		return this.instantiatedPatternModel;
	}
}
