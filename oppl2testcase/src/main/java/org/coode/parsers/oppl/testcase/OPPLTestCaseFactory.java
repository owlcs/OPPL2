/**
 * 
 */
package org.coode.parsers.oppl.testcase;

import java.util.List;

import org.coode.oppl.OPPLAbstractFactory;
import org.coode.oppl.OPPLFactory;
import org.coode.oppl.OPPLScript;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyManager;
import org.semanticweb.owlapi.reasoner.OWLReasoner;

/**
 * @author Luigi Iannone
 * 
 */
public class OPPLTestCaseFactory implements AbstractOPPLTestCaseFactory {
	private final OWLOntology ontology;
	private final OWLOntologyManager ontologyManager;
	private final OWLReasoner reasoner;

	public OPPLTestCaseFactory(OWLOntology ontology,
			OWLOntologyManager ontologyManager, OWLReasoner reasoner) {
		if (ontologyManager == null) {
			throw new NullPointerException(
					"The ontology manager cannot be null");
		}
		if (ontology == null) {
			throw new NullPointerException("The ontology  cannot be null");
		}
		this.ontologyManager = ontologyManager;
		this.ontology = ontology;
		this.reasoner = reasoner;
	}

	/**
	 * @see org.coode.parsers.oppl.testcase.AbstractOPPLTestCaseFactory#buildOPPLTestCase
	 *      (java.lang.String, org.coode.oppl.OPPLScript, boolean)
	 */
	public OPPLTestCase buildOPPLTestCase(String name, OPPLScript opplContent,
			List<? extends OPPLTest> tests, boolean requiresInference) {
		return new OPPLTestCaseImpl(name, opplContent, tests, requiresInference);
	}

	/**
	 * @see org.coode.parsers.oppl.testcase.AbstractOPPLTestCaseFactory#getOPPLFactory()
	 */
	public OPPLAbstractFactory getOPPLFactory() {
		return new OPPLFactory(this.getOntologyManager(), this.getOntology(),
				this.getReasoner());
	}

	/**
	 * @return the ontology
	 */
	public OWLOntology getOntology() {
		return this.ontology;
	}

	/**
	 * @return the ontologyManager
	 */
	public OWLOntologyManager getOntologyManager() {
		return this.ontologyManager;
	}

	/**
	 * @return the reasoner
	 */
	public OWLReasoner getReasoner() {
		return this.reasoner;
	}
}
