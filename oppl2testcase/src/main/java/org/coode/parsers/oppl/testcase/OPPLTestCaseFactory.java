package org.coode.parsers.oppl.testcase;

import static org.coode.oppl.utils.ArgCheck.checkNotNull;

import java.util.List;

import org.coode.oppl.OPPLAbstractFactory;
import org.coode.oppl.OPPLFactory;
import org.coode.oppl.OPPLScript;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyManager;
import org.semanticweb.owlapi.reasoner.OWLReasoner;

/**
 * @author Luigi Iannone
 */
public class OPPLTestCaseFactory implements AbstractOPPLTestCaseFactory {

    private final OWLOntology ontology;
    private final OWLOntologyManager ontologyManager;
    private final OWLReasoner reasoner;

    /**
     * @param ontology
     *        ontology
     * @param ontologyManager
     *        ontologyManager
     * @param reasoner
     *        reasoner
     */
    public OPPLTestCaseFactory(OWLOntology ontology, OWLOntologyManager ontologyManager,
        OWLReasoner reasoner) {
        this.ontologyManager = checkNotNull(ontologyManager, "ontologyManager");
        this.ontology = checkNotNull(ontology, "ontology");
        this.reasoner = reasoner;
    }

    @Override
    public OPPLTestCase buildOPPLTestCase(String name, OPPLScript opplContent,
        List<? extends OPPLTest> tests, boolean requiresInference) {
        return new OPPLTestCaseImpl(name, opplContent, tests, requiresInference);
    }

    @Override
    public OPPLAbstractFactory getOPPLFactory() {
        return new OPPLFactory(getOntologyManager(), getOntology(), getReasoner());
    }

    /**
     * @return the ontology
     */
    public OWLOntology getOntology() {
        return ontology;
    }

    /**
     * @return the ontologyManager
     */
    public OWLOntologyManager getOntologyManager() {
        return ontologyManager;
    }

    /**
     * @return the reasoner
     */
    public OWLReasoner getReasoner() {
        return reasoner;
    }
}
