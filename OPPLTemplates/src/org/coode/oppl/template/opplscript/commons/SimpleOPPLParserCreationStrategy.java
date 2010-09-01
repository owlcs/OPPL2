/**
 * 
 */
package org.coode.oppl.template.opplscript.commons;

import org.coode.oppl.OPPLParser;
import org.coode.oppl.OPPLScript;
import org.coode.oppl.ParserFactory;
import org.coode.oppl.template.ParsingStrategy;
import org.coode.parsers.ErrorListener;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyManager;
import org.semanticweb.owlapi.reasoner.OWLReasoner;

/**
 * @author Luigi Iannone
 * 
 */
public class SimpleOPPLParserCreationStrategy implements
		ParsingStrategy<String, OPPLScript> {
	private final ErrorListener errorListener;
	private final ParserFactory parserFactory;

	/**
	 * @param errorListener
	 */
	public SimpleOPPLParserCreationStrategy(OWLOntologyManager ontologyManager,
			OWLOntology ontology, OWLReasoner reasoner,
			ErrorListener errorListener) {
		if (ontologyManager == null) {
			throw new NullPointerException(
					"The ontology manager cannot be null");
		}
		if (ontology == null) {
			throw new NullPointerException("The ontology cannot be null");
		}
		if (errorListener == null) {
			throw new NullPointerException("The error listener cannot be null");
		}
		this.parserFactory = new ParserFactory(ontologyManager, ontology,
				reasoner);
		this.errorListener = errorListener;
	}

	protected OPPLParser build() {
		return this.parserFactory.build(this.getErrorListener());
	}

	public OPPLScript parse(String input) {
		OPPLParser parser = this.build();
		return parser.parse(input);
	}

	/**
	 * @return the errorListener
	 */
	public ErrorListener getErrorListener() {
		return this.errorListener;
	}

	/**
	 * @return the parserFactory
	 */
	public ParserFactory getParserFactory() {
		return this.parserFactory;
	}
}
