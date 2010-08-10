/**
 * 
 */
package org.coode.patterns;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.coode.parsers.ErrorListener;
import org.coode.parsers.oppl.OPPLSyntaxTree;
import org.coode.parsers.oppl.patterns.OPPLPatternsSymbolTable;
import org.coode.parsers.oppl.patterns.factory.SimpleSymbolTableFactory;
import org.coode.patterns.OPPLPatternParser.AbstractParserFactory;
import org.coode.patterns.OPPLPatternParser.PatternReferenceResolver;
import org.semanticweb.owl.model.OWLOntology;
import org.semanticweb.owl.model.OWLOntologyManager;

/**
 * @author Luigi Iannone
 * 
 */
public class ParserFactory implements AbstractParserFactory {
	private static final class VisitedPatternReferenceResolver implements PatternReferenceResolver {
		private final Set<String> visited = new HashSet<String>();

		public VisitedPatternReferenceResolver(Collection<? extends String> visitedPatterns) {
			assert visitedPatterns != null;
			this.visited.addAll(visitedPatterns);
		}

		public void resolvePattern(OPPLSyntaxTree reference, String patternName,
				PatternConstraintSystem constraintSystem, OPPLPatternsSymbolTable symbolTable,
				String... args) {
			symbolTable.resolvePattern(
					reference,
					patternName,
					constraintSystem,
					this.getVisited(),
					args);
		}

		/**
		 * @return the visited
		 */
		public Set<String> getVisited() {
			return new HashSet<String>(this.visited);
		}
	}

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
