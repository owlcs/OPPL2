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
package org.coode.oppl.utils;

import java.io.StringReader;

import org.coode.oppl.OPPLFactory;
import org.coode.oppl.syntax.OPPLParser;
import org.coode.oppl.validation.OPPLScriptValidator;
import org.semanticweb.owl.inference.OWLReasoner;
import org.semanticweb.owl.model.OWLOntology;
import org.semanticweb.owl.model.OWLOntologyManager;

/**
 * Utility class for parser initialisation.
 * 
 * @author Luigi Iannone
 * 
 */
public class ParserFactory {
	static OPPLParser parser = null;

	public static synchronized OPPLParser initParser(String formulaBody,
			OWLOntology ontology, OWLOntologyManager ontologyManager,
			OWLReasoner reasoner) {
		return initParser(formulaBody, ontology, ontologyManager, reasoner,
				null);
	}

	public static synchronized OPPLParser initParser(String formulaBody,
			OWLOntology ontology, OWLOntologyManager ontologyManager,
			OWLReasoner reasoner, OPPLScriptValidator validator) {
		if (parser == null) {
			parser = new OPPLParser(new StringReader(formulaBody),
					ontologyManager, ontology, reasoner);
		} else {
			parser.ReInit(new StringReader(formulaBody), ontologyManager,
					ontology, reasoner);
		}
		parser.setOPPLFactory(new OPPLFactory(ontologyManager, ontology,
				reasoner));
		parser.setOPPLScriptValidator(validator);
		return parser;
	}

	public static synchronized OPPLParser getInstance() {
		return parser;
	}
}
