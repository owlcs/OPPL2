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

/** @author Luigi Iannone */
public class ParserFactory implements AbstractParserFactory {
    private final OWLOntology ontology;
    private final OWLOntologyManager ontologyManager;

    /** @param ontology
     * @param ontologyManager */
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

    @Override
    public OPPLPatternParser build(ErrorListener errorListener) {
        return new OPPLPatternParser(getPatternFactory(), errorListener,
                new SimpleSymbolTableFactory(getOntologyManager()));
    }

    @Override
    public OPPLPatternParser build(Collection<? extends String> visitedPatterns,
            ErrorListener errorListener) {
        return new OPPLPatternParser(getPatternFactory(), errorListener,
                new SimpleSymbolTableFactory(getOntologyManager()),
                new VisitedPatternReferenceResolver(visitedPatterns));
    }

    @Override
    public AbstractPatternModelFactory getPatternFactory() {
        return new PatternModelFactory(getOntology(), getOntologyManager());
    }

    /** @return the ontologyManager */
    public OWLOntologyManager getOntologyManager() {
        return ontologyManager;
    }

    /** @return the ontology */
    public OWLOntology getOntology() {
        return ontology;
    }
}
