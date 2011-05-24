package org.coode.patterns.locality;

import org.semanticweb.owlapi.model.OWLAxiom;
import org.semanticweb.owlapi.reasoner.OWLReasoner;

public class AxiomLocality {
	/**
	 * 
	 */
	private boolean isLocal;
	private OWLReasoner reasoner;

	public AxiomLocality(OWLReasoner r) {
		if (r == null) {
			throw new NullPointerException("The reasoner cannot be null");
		}
		this.reasoner = r;
	}

	public boolean isLocal() {
		return this.isLocal;
	}

	public boolean isLocal(OWLAxiom axiom) {
		this.reset();
		this.isLocal = this.reasoner.isEntailed(axiom);
		return this.isLocal();
	}

	public void reset() {
		this.isLocal = false;
	}
}