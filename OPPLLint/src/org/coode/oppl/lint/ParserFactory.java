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
package org.coode.oppl.lint;

import org.coode.oppl.lint.OPPLLintParser.AbstractParserFactory;
import org.coode.parsers.ErrorListener;
import org.coode.parsers.factory.SymbolTableFactory;
import org.coode.parsers.oppl.OPPLSymbolTable;
import org.coode.parsers.oppl.factory.SimpleSymbolTableFactory;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyManager;
import org.semanticweb.owlapi.reasoner.OWLReasoner;

/**
 * @author Luigi Iannone
 * 
 */
public class ParserFactory implements AbstractParserFactory {
	private final OWLOntologyManager ontologyManager;
	private final OWLOntology ontology;
	private final OWLReasoner reasoner;

	/**
	 * @param ontology
	 * @param ontologyManager
	 */
	public ParserFactory(OWLOntology ontology,
			OWLOntologyManager ontologyManager, OWLReasoner reasoner) {
		if (ontologyManager == null) {
			throw new NullPointerException(
					"The ontology manager cannot be null");
		}
		if (ontology == null) {
			throw new NullPointerException("The ontology cannot be null");
		}
		this.ontologyManager = ontologyManager;
		this.ontology = ontology;
		this.reasoner = reasoner;
	}

	public ParserFactory(OWLOntology ontology,
			OWLOntologyManager ontologyManager) {
		this(ontology, ontologyManager, null);
	}

	/**
	 * @return the ontologyManager
	 */
	public OWLOntologyManager getOntologyManager() {
		return this.ontologyManager;
	}

	public OPPLLintParser build(ErrorListener errorListener) {
		SymbolTableFactory<OPPLSymbolTable> symbolTableFactory = new SimpleSymbolTableFactory(
				this.getOntologyManager());
		return new OPPLLintParser(this.getOPPLLintAbstractFactory(),
				errorListener, symbolTableFactory);
	}

	public OPPLLintAbstractFactory getOPPLLintAbstractFactory() {
		return new OPPLLintFactory(this.getOntology(), this
				.getOntologyManager(), this.getReasoner());
	}

	/**
	 * @return the ontology
	 */
	public OWLOntology getOntology() {
		return this.ontology;
	}

	/**
	 * @return the reasoner
	 */
	public OWLReasoner getReasoner() {
		return this.reasoner;
	}
}
