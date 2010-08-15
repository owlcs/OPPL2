package org.coode.oppl;

import org.coode.oppl.OPPLParser.AbstractParserFactory;
import org.coode.parsers.ErrorListener;
import org.coode.parsers.factory.SymbolTableFactory;
import org.coode.parsers.oppl.OPPLSymbolTable;
import org.coode.parsers.oppl.factory.SimpleSymbolTableFactory;
import org.semanticweb.owl.inference.OWLReasoner;
import org.semanticweb.owl.model.OWLOntology;
import org.semanticweb.owl.model.OWLOntologyManager;

public class ParserFactory implements AbstractParserFactory {
	private final OWLOntologyManager ontologyManager;
	private final OWLOntology ontology;
	private final OWLReasoner reasoner;

	/**
	 * @param ontologyManager
	 */
	public ParserFactory(OWLOntologyManager ontologyManager,
			OWLOntology ontology, OWLReasoner reasoner) {
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

	public OPPLParser build(ErrorListener errorListener) {
		SymbolTableFactory<OPPLSymbolTable> symbolTableFactory = new SimpleSymbolTableFactory(
				this.getOntologyManager());
		return new OPPLParser(this.getOPPLFactory(), errorListener,
				symbolTableFactory);
	}

	/**
	 * @return
	 */
	public OPPLFactory getOPPLFactory() {
		return new OPPLFactory(this.getOntologyManager(), this.getOntology(),
				this.getReasoner());
	}

	/**
	 * @return the ontologyManager
	 */
	public OWLOntologyManager getOntologyManager() {
		return this.ontologyManager;
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
