/**
 * 
 */
package org.coode.patterns;

import java.util.Collection;

import org.coode.parsers.ErrorListener;
import org.coode.parsers.oppl.patterns.factory.SimpleSymbolTableFactory;
import org.coode.patterns.OPPLPatternParser.AbstractParserFactory;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyManager;

/**
 * @author Luigi Iannone
 * 
 */
public class ParserFactory implements AbstractParserFactory {
	private final OWLOntology ontology;
	private final OWLOntologyManager ontologyManager;

	/**
	 * @param ontology
	 * @param ontologyManager
	 */
	public ParserFactory(OWLOntology ontology, OWLOntologyManager ontologyManager) {
		if (ontology == null) {
			throw new NullPointerException("The ontology canont be null");
		}
		if (ontologyManager == null) {
			throw new NullPointerException("The ontology manager cannot be null");
		}
		this.ontology = ontology;
		this.ontologyManager = ontologyManager;
	}

	/**
	 * @see org.coode.patterns.OPPLPatternParser.AbstractParserFactory#build(org.
	 *      coode.parsers.ErrorListener)
	 */
	public OPPLPatternParser build(ErrorListener errorListener) {
		return new OPPLPatternParser(this.getPatternFactory(), errorListener,
				new SimpleSymbolTableFactory(this.getOntologyManager()));
	}

	public OPPLPatternParser build(Collection<? extends String> visitedPatterns,
			ErrorListener errorListener) {
		return new OPPLPatternParser(this.getPatternFactory(), errorListener,
				new SimpleSymbolTableFactory(this.getOntologyManager()),
				new VisitedPatternReferenceResolver(visitedPatterns));
	}

	/**
	 * @see org.coode.patterns.OPPLPatternParser.AbstractParserFactory#getPatternFactory
	 *      ()
	 */
	public AbstractPatternModelFactory getPatternFactory() {
		return new PatternModelFactory(this.getOntology(), this.getOntologyManager());
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
}
