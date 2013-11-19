
package org.coode.parsers.oppl.testcase;

import java.util.List;

import org.coode.oppl.OPPLAbstractFactory;
import org.coode.oppl.OPPLFactory;
import org.coode.oppl.OPPLScript;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyManager;
import org.semanticweb.owlapi.reasoner.OWLReasoner;

/** @author Luigi Iannone */
public class OPPLTestCaseFactory implements AbstractOPPLTestCaseFactory {
    private final OWLOntology ontology;
    private final OWLOntologyManager ontologyManager;
    private final OWLReasoner reasoner;

    public OPPLTestCaseFactory(OWLOntology ontology, OWLOntologyManager ontologyManager,
            OWLReasoner reasoner) {
        if (ontologyManager == null) {
            throw new NullPointerException("The ontology manager cannot be null");
        }
        if (ontology == null) {
            throw new NullPointerException("The ontology  cannot be null");
        }
        this.ontologyManager = ontologyManager;
        this.ontology = ontology;
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

    /** @return the ontology */
    public OWLOntology getOntology() {
        return ontology;
    }

    /** @return the ontologyManager */
    public OWLOntologyManager getOntologyManager() {
        return ontologyManager;
    }

    /** @return the reasoner */
    public OWLReasoner getReasoner() {
        return reasoner;
    }
}
