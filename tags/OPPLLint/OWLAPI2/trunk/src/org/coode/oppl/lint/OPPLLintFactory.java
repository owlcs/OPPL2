/**
 *
 */
package org.coode.oppl.lint;

import org.coode.oppl.OPPLAbstractFactory;
import org.coode.oppl.OPPLFactory;
import org.coode.oppl.OPPLScript;
import org.coode.oppl.Variable;
import org.semanticweb.owl.inference.OWLReasoner;
import org.semanticweb.owl.model.OWLOntology;
import org.semanticweb.owl.model.OWLOntologyManager;

/**
 * @author Luigi Iannone
 * 
 */
public class OPPLLintFactory implements OPPLLintAbstractFactory {
	private final OWLOntologyManager ontologyManager;
	private final OWLOntology ontology;
	private final OWLReasoner reasoner;

	/**
	 * @param ontologyManager
	 */
	public OPPLLintFactory(OWLOntology ontology, OWLOntologyManager ontologyManager,
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

	public OPPLLintScript buildOPPLLintScript(String name, OPPLScript opplScript, Variable v,
			String explanationTemplate, String description, boolean inferenceRequired) {
		return opplScript.getActions().isEmpty() ? new OPPLLintScript(name, opplScript, v,
				explanationTemplate, description, this.ontologyManager, inferenceRequired)
				: new ActingOPPLLintScript(name, opplScript, v, explanationTemplate, description,
						this.getOntologyManager(), inferenceRequired);
	}

	/**
	 * @return the ontologyManager
	 */
	public OWLOntologyManager getOntologyManager() {
		return this.ontologyManager;
	}

	public OPPLAbstractFactory getOPPLFactory() {
		return new OPPLFactory(this.getOntologyManager(), this.getOntology(), this.getReasoner());
	}

	/**
	 * @return the ontology
	 */
	public OWLOntology getOntology() {
		return this.ontology;
	}

	/**
	 * @return the reasoner
	 */
	public OWLReasoner getReasoner() {
		return this.reasoner;
	}
}
