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
package org.coode.patterns.protege;

import java.util.Set;

import org.coode.patterns.PatternExtractor;
import org.coode.patterns.protege.utils.ProtegeParserFactory;
import org.coode.patterns.syntax.PatternParser;
import org.protege.editor.owl.model.OWLModelManager;
import org.semanticweb.owl.model.OWLConstantAnnotation;

/**
 * @author Luigi Iannone
 * 
 *         Jun 9, 2008
 */
public class ProtegePatternExtractor extends PatternExtractor {
	private OWLModelManager owlModelManager;

	public ProtegePatternExtractor(OWLModelManager owlModelManager) {
		super(owlModelManager.getActiveOntology(), owlModelManager
				.getOWLOntologyManager());
		this.owlModelManager = owlModelManager;
	}

	public ProtegePatternExtractor(OWLModelManager modelManager,
			Set<OWLConstantAnnotation> visited) {
		super(modelManager.getActiveOntology(), modelManager
				.getOWLOntologyManager(), visited);
		this.owlModelManager = modelManager;
	}

	@Override
	protected PatternParser initParser(String value) {
		PatternParser parser = ProtegeParserFactory.initProtegeParser(value,
				this.owlModelManager);
		parser.setVisited(getVisitedPatternNames());
		// parser.setPatternModelFactory(new ProtegePatternModelFactory(
		// this.owlModelManager));
		return parser;
	}
}
