package org.coode.patterns.locality;

import org.semanticweb.owlapi.model.OWLAxiom;
import org.semanticweb.owlapi.reasoner.OWLReasoner;

public class AxiomLocality {
    /**
	 * 
	 */
    private boolean isLocal;
    private final OWLReasoner reasoner;

    public AxiomLocality(OWLReasoner r) {
        if (r == null) {
            throw new NullPointerException("The reasoner cannot be null");
        }
        reasoner = r;
    }

    public boolean isLocal() {
        return isLocal;
    }

    public boolean isLocal(OWLAxiom axiom) {
        reset();
        isLocal = reasoner.isEntailed(axiom);
        return this.isLocal();
    }

    public void reset() {
        isLocal = false;
    }
}
