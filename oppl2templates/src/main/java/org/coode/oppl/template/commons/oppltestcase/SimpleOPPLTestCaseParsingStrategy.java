package org.coode.oppl.template.commons.oppltestcase;

import static org.coode.oppl.utils.ArgCheck.checkNotNull;

import org.coode.oppl.exceptions.RuntimeExceptionHandler;
import org.coode.oppl.template.ParsingStrategy;
import org.coode.parsers.ErrorListener;
import org.coode.parsers.oppl.testcase.OPPLTestCase;
import org.coode.parsers.oppl.testcase.OPPLTestCaseParser;
import org.coode.parsers.oppl.testcase.ParserFactory;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyManager;
import org.semanticweb.owlapi.reasoner.OWLReasoner;

/** @author Luigi Iannone */
public class SimpleOPPLTestCaseParsingStrategy implements
        ParsingStrategy<String, OPPLTestCase> {
    private final ErrorListener errorListener;
    private final ParserFactory parserFactory;
    private final RuntimeExceptionHandler handler;

    /** @param ontologyManager
     * @param ontology
     * @param reasoner
     * @param errorListener
     * @param handler */
    public SimpleOPPLTestCaseParsingStrategy(OWLOntologyManager ontologyManager,
            OWLOntology ontology, OWLReasoner reasoner, ErrorListener errorListener,
            RuntimeExceptionHandler handler) {
        this.errorListener = checkNotNull(errorListener, "errorListener");
        this.handler = checkNotNull(handler, "handler");
        parserFactory = new ParserFactory(checkNotNull(ontology, "ontology"),
                checkNotNull(ontologyManager, "ontologyManager"), reasoner);
    }

    protected OPPLTestCaseParser build() {
        return parserFactory.build(getErrorListener());
    }

    @Override
    public OPPLTestCase parse(String input) {
        OPPLTestCaseParser parser = build();
        return parser.parse(input, getHandler());
    }

    /** @return the errorListener */
    public ErrorListener getErrorListener() {
        return errorListener;
    }

    /** @return the parserFactory */
    public ParserFactory getParserFactory() {
        return parserFactory;
    }

    /** @return the handler */
    public RuntimeExceptionHandler getHandler() {
        return handler;
    }
}
