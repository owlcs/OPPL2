package org.coode.patterns;

import static org.coode.oppl.utils.ArgCheck.checkNotNull;

import java.util.Collection;

import org.coode.parsers.ErrorListener;
import org.coode.parsers.oppl.patterns.factory.SimpleSymbolTableFactory;
import org.coode.patterns.OPPLPatternParser.AbstractParserFactory;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyManager;

/**
 * @author Luigi Iannone
 */
public class ParserFactory implements AbstractParserFactory {

    private final OWLOntology ontology;
    private final OWLOntologyManager ontologyManager;

    /**
     * @param ontology
     *        ontology
     * @param ontologyManager
     *        ontologyManager
     */
    public ParserFactory(OWLOntology ontology, OWLOntologyManager ontologyManager) {
        this.ontology = checkNotNull(ontology, "ontology");
        this.ontologyManager = checkNotNull(ontologyManager, "ontologyManager");
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

    /**
     * @return the ontologyManager
     */
    public OWLOntologyManager getOntologyManager() {
        return ontologyManager;
    }

    /**
     * @return the ontology
     */
    public OWLOntology getOntology() {
        return ontology;
    }
}
