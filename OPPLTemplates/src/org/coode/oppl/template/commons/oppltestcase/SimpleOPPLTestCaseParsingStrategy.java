/**
 * 
 */
package org.coode.oppl.template.commons.oppltestcase;

import org.coode.oppl.template.ParsingStrategy;
import org.coode.parsers.ErrorListener;
import org.coode.parsers.oppl.testcase.OPPLTestCase;
import org.coode.parsers.oppl.testcase.OPPLTestCaseParser;
import org.coode.parsers.oppl.testcase.ParserFactory;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyManager;
import org.semanticweb.owlapi.reasoner.OWLReasoner;

/**
 * @author Luigi Iannone
 * 
 */
public class SimpleOPPLTestCaseParsingStrategy implements ParsingStrategy<String, OPPLTestCase> {
	private final ErrorListener errorListener;
	private final ParserFactory parserFactory;

	public SimpleOPPLTestCaseParsingStrategy(OWLOntologyManager ontologyManager,
			OWLOntology ontology, OWLReasoner reasoner, ErrorListener errorListener) {
		if (ontologyManager == null) {
			throw new NullPointerException("The ontology manager cannot be null");
		}
		if (ontology == null) {
			throw new NullPointerException("The ontology cannot be null");
		}
		if (errorListener == null) {
			throw new NullPointerException("The error listener cannot be null");
		}
		this.parserFactory = new ParserFactory(ontology, ontologyManager, reasoner);
		this.errorListener = errorListener;
	}

	protected OPPLTestCaseParser build() {
		return this.parserFactory.build(this.getErrorListener());
	}

	public OPPLTestCase parse(String input) {
		OPPLTestCaseParser parser = this.build();
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
