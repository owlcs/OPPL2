package org.coode.oppl.template.commons.opplscript;

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

/** Builds a parser that recognises named entities based on the value for the
 * annotation whose annotation properties are listed in a List provided to the
 * constructor for this class.
 * 
 * @author Luigi Iannone */
public class AnnotationBasedSimpleOPPLParserCreationStrategy extends
        SimpleOPPLParserCreationStrategy {
    private final SymbolTableFactory<OPPLSymbolTable> symbolTableFactory;

    public AnnotationBasedSimpleOPPLParserCreationStrategy(List<IRI> iris,
            OWLOntologyManager ontologyManager, OWLOntology ontology,
            OWLReasoner reasoner, ErrorListener errorListener) {
        super(ontologyManager, ontology, reasoner, errorListener);
        if (iris == null) {
            throw new NullPointerException(
                    "The collection of annotation property IRIs cannot be null");
        }
        symbolTableFactory = new AnnotationBasedSymbolTableFactory(ontologyManager, iris);
    }

    @Override
    public OPPLParser build() {
        return getParserFactory().build(getErrorListener(), symbolTableFactory);
    }
}
