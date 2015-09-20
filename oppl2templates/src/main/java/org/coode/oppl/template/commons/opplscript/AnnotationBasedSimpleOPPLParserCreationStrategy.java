package org.coode.oppl.template.commons.opplscript;

import static org.coode.oppl.utils.ArgCheck.checkNotNull;

import java.util.List;

import org.coode.oppl.AnnotationBasedSymbolTableFactory;
import org.coode.oppl.OPPLParser;
import org.coode.parsers.ErrorListener;
import org.coode.parsers.factory.SymbolTableFactory;
import org.coode.parsers.oppl.OPPLSymbolTable;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyManager;
import org.semanticweb.owlapi.reasoner.OWLReasoner;

/**
 * Builds a parser that recognises named entities based on the value for the
 * annotation whose annotation properties are listed in a List provided to the
 * constructor for this class.
 * 
 * @author Luigi Iannone
 */
public class AnnotationBasedSimpleOPPLParserCreationStrategy extends
    SimpleOPPLParserCreationStrategy {

    private final SymbolTableFactory<OPPLSymbolTable> symbolTableFactory;

    /**
     * @param iris
     *        iris
     * @param ontologyManager
     *        ontologyManager
     * @param ontology
     *        ontology
     * @param reasoner
     *        reasoner
     * @param errorListener
     *        errorListener
     */
    public AnnotationBasedSimpleOPPLParserCreationStrategy(List<IRI> iris,
        OWLOntologyManager ontologyManager, OWLOntology ontology,
        OWLReasoner reasoner, ErrorListener errorListener) {
        super(ontologyManager, ontology, reasoner, errorListener);
        symbolTableFactory = new AnnotationBasedSymbolTableFactory(ontologyManager,
            checkNotNull(iris, "iris"));
    }

    @Override
    public OPPLParser build() {
        return getParserFactory().build(getErrorListener(), symbolTableFactory);
    }
}
