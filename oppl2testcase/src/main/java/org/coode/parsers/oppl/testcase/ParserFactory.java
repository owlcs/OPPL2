package org.coode.parsers.oppl.testcase;

import static org.coode.oppl.utils.ArgCheck.checkNotNull;

import org.coode.parsers.ErrorListener;
import org.coode.parsers.factory.SymbolTableFactory;
import org.coode.parsers.oppl.testcase.OPPLTestCaseParser.AbstractParserFactory;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyManager;
import org.semanticweb.owlapi.reasoner.OWLReasoner;

/** @author Luigi Iannone */
public class ParserFactory implements AbstractParserFactory {
    private final OWLOntologyManager ontologyManager;
    private final OWLOntology ontology;
    private final OWLReasoner reasoner;

    /** @param ontology
     * @param ontologyManager
     * @param reasoner */
    public ParserFactory(OWLOntology ontology, OWLOntologyManager ontologyManager,
            OWLReasoner reasoner) {
        this.ontologyManager = checkNotNull(ontologyManager, "ontologyManager");
        this.ontology = checkNotNull(ontology, "ontology");
        this.reasoner = reasoner;
    }

    /** @param ontology
     * @param ontologyManager */
    public ParserFactory(OWLOntology ontology, OWLOntologyManager ontologyManager) {
        this(ontology, ontologyManager, null);
    }

    /** @return the ontologyManager */
    public OWLOntologyManager getOntologyManager() {
        return ontologyManager;
    }

    @Override
    public OPPLTestCaseParser build(ErrorListener errorListener) {
        SymbolTableFactory<OPPLTestCaseSymbolTable> symbolTableFactory = new SimpleSymbolTableFactory(
                getOntologyManager());
        return this.build(errorListener, symbolTableFactory);
    }

    /** @param errorListener
     * @param symbolTableFactory
     * @return oppl test case parser */
    public OPPLTestCaseParser build(ErrorListener errorListener,
            SymbolTableFactory<OPPLTestCaseSymbolTable> symbolTableFactory) {
        return new OPPLTestCaseParser(getOPPLTestCaseFactory(), errorListener,
                symbolTableFactory);
    }

    @Override
    public AbstractOPPLTestCaseFactory getOPPLTestCaseFactory() {
        return new OPPLTestCaseFactory(getOntology(), getOntologyManager(), getReasoner());
    }

    /** @return the ontology */
    public OWLOntology getOntology() {
        return ontology;
    }

    /** @return the reasoner */
    public OWLReasoner getReasoner() {
        return reasoner;
    }
}
