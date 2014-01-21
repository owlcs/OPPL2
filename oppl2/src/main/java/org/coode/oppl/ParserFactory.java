package org.coode.oppl;

import static org.coode.oppl.utils.ArgCheck.checkNotNull;

import org.coode.oppl.OPPLParser.AbstractParserFactory;
import org.coode.parsers.ErrorListener;
import org.coode.parsers.factory.SymbolTableFactory;
import org.coode.parsers.oppl.OPPLSymbolTable;
import org.coode.parsers.oppl.factory.SimpleSymbolTableFactory;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyManager;
import org.semanticweb.owlapi.reasoner.OWLReasoner;

/** @author Luigi Iannone */
public class ParserFactory implements AbstractParserFactory {
    private final OWLOntologyManager ontologyManager;
    private final OWLOntology ontology;
    private final OWLReasoner reasoner;

    /** @param ontologyManager
     *            ontologyManager
     * @param ontology
     *            ontology
     * @param reasoner
     *            reasoner */
    public ParserFactory(OWLOntologyManager ontologyManager, OWLOntology ontology,
            OWLReasoner reasoner) {
        this.ontologyManager = checkNotNull(ontologyManager, "ontologyManager");
        this.ontology = checkNotNull(ontology, "ontology");
        this.reasoner = reasoner;
    }

    @Override
    public OPPLParser build(ErrorListener errorListener) {
        SymbolTableFactory<OPPLSymbolTable> symbolTableFactory = new SimpleSymbolTableFactory(
                getOntologyManager());
        return this.build(errorListener, symbolTableFactory);
    }

    /** @param errorListener
     *            errorListener
     * @param symbolTableFactory
     *            symbolTableFactory
     * @return new parser */
    public OPPLParser build(ErrorListener errorListener,
            SymbolTableFactory<OPPLSymbolTable> symbolTableFactory) {
        return new OPPLParser(getOPPLFactory(), errorListener, symbolTableFactory);
    }

    @Override
    public OPPLFactory getOPPLFactory() {
        return new OPPLFactory(getOntologyManager(), getOntology(), getReasoner());
    }

    /** @return the ontologyManager */
    public OWLOntologyManager getOntologyManager() {
        return ontologyManager;
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
