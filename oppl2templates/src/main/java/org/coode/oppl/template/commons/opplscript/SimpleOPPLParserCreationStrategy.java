package org.coode.oppl.template.commons.opplscript;

import static org.coode.oppl.utils.ArgCheck.checkNotNull;

import org.coode.oppl.OPPLParser;
import org.coode.oppl.OPPLScript;
import org.coode.oppl.ParserFactory;
import org.coode.oppl.template.ParsingStrategy;
import org.coode.parsers.ErrorListener;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyManager;
import org.semanticweb.owlapi.reasoner.OWLReasoner;

/** @author Luigi Iannone */
public class SimpleOPPLParserCreationStrategy implements
        ParsingStrategy<String, OPPLScript> {
    private final ErrorListener errorListener;
    private final ParserFactory parserFactory;

    /** @param ontologyManager
     * @param ontology
     * @param reasoner
     * @param errorListener */
    public SimpleOPPLParserCreationStrategy(OWLOntologyManager ontologyManager,
            OWLOntology ontology, OWLReasoner reasoner, ErrorListener errorListener) {
        this.errorListener = checkNotNull(errorListener, "errorListener");
        parserFactory = new ParserFactory(
                checkNotNull(ontologyManager, "ontologyManager"), checkNotNull(ontology,
                        "ontology"), reasoner);
    }

    protected OPPLParser build() {
        return parserFactory.build(getErrorListener());
    }

    @Override
    public OPPLScript parse(String input) {
        OPPLParser parser = build();
        return parser.parse(input);
    }

    /** @return the errorListener */
    public ErrorListener getErrorListener() {
        return errorListener;
    }

    /** @return the parserFactory */
    public ParserFactory getParserFactory() {
        return parserFactory;
    }
}
