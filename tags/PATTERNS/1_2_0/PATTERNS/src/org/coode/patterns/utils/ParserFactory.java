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
package org.coode.patterns.utils;

import java.io.StringReader;

import org.coode.patterns.PatternModelFactory;
import org.coode.patterns.syntax.PatternParser;
import org.semanticweb.owl.inference.OWLReasoner;
import org.semanticweb.owl.model.OWLOntology;
import org.semanticweb.owl.model.OWLOntologyManager;

/**
 * @author Luigi Iannone
 * 
 */
public class ParserFactory {
	// static PatternParser parser = null;
	public static PatternParser initParser(String formulaBody,
			OWLOntology ontology, OWLOntologyManager ontologyManager) {
		return initParser(formulaBody, ontology, ontologyManager, null);
	}

	public static PatternParser initParser(String formulaBody,
			OWLOntology ontology, OWLOntologyManager ontologyManager,
			OWLReasoner reasoner) {
		PatternParser parser = new PatternParser(new StringReader(formulaBody),
				ontologyManager, reasoner);
		parser.setPatternModelFactory(new PatternModelFactory(ontology,
				ontologyManager, reasoner, formulaBody));
		return parser;
	}

	public static PatternParser reinitParser(String formulaBody,
			PatternParser inputParser) {
		PatternParser parser = new PatternParser(new StringReader(formulaBody),
				inputParser.getOWLOntologyManager(), inputParser.getReasoner());
		parser.setPatternModelFactory(inputParser.getPatternModelFactory());
		return parser;
	}
	// public static PatternParser initParser(InputStream formulaBody,
	// OWLModelManager manager) {
	// parser = new PatternParser(formulaBody,
	// manager.getOWLOntologyManager(), manager.getReasoner());
	// parser.setPatternModelFactory(new ProtegePatternModelFactory(manager));
	// OPPLParser.setOPPLFactory(new ProtegeOPPLFactory(manager));
	// return parser;
	// }
	// public static PatternParser initParser(InputStream in,
	// OWLOntology ontology, OWLOntologyManager manager) {
	// parser = new PatternParser(new InputStreamReader(in), manager, null);
	// parser
	// .setPatternModelFactory(new PatternModelFactory(ontology,
	// manager));
	// return parser;
	// }
}
