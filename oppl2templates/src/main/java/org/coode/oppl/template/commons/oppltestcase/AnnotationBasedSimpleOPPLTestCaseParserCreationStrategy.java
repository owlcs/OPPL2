package org.coode.oppl.template.commons.oppltestcase;

import static org.coode.oppl.utils.ArgCheck.checkNotNull;

import java.util.List;

import org.coode.oppl.exceptions.RuntimeExceptionHandler;
import org.coode.parsers.ErrorListener;
import org.coode.parsers.factory.SymbolTableFactory;
import org.coode.parsers.oppl.testcase.AnnotationBasedSymbolTableFactory;
import org.coode.parsers.oppl.testcase.OPPLTestCaseParser;
import org.coode.parsers.oppl.testcase.OPPLTestCaseSymbolTable;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyManager;
import org.semanticweb.owlapi.reasoner.OWLReasoner;

/** @author Luigi Iannone */
public class AnnotationBasedSimpleOPPLTestCaseParserCreationStrategy extends
        SimpleOPPLTestCaseParsingStrategy {
    private final SymbolTableFactory<OPPLTestCaseSymbolTable> symbolTableFactory;

    /** @param iris
     *            iris
     * @param ontologyManager
     *            ontologyManager
     * @param ontology
     *            ontology
     * @param reasoner
     *            reasoner
     * @param errorListener
     *            errorListener
     * @param handler
     *            handler */
    public AnnotationBasedSimpleOPPLTestCaseParserCreationStrategy(List<IRI> iris,
            OWLOntologyManager ontologyManager, OWLOntology ontology,
            OWLReasoner reasoner, ErrorListener errorListener,
            RuntimeExceptionHandler handler) {
        super(ontologyManager, ontology, reasoner, errorListener, handler);
        symbolTableFactory = new AnnotationBasedSymbolTableFactory(ontologyManager,
                checkNotNull(iris, "iris"));
    }

    @Override
    public OPPLTestCaseParser build() {
        return getParserFactory().build(getErrorListener(), symbolTableFactory);
    }
}
