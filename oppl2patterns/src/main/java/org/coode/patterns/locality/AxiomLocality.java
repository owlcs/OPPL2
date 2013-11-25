package org.coode.patterns.locality;

import static org.coode.oppl.utils.ArgCheck.checkNotNull;

import org.semanticweb.owlapi.model.OWLAxiom;
import org.semanticweb.owlapi.reasoner.OWLReasoner;

public class AxiomLocality {
    private boolean isLocal;
    private final OWLReasoner reasoner;

    public AxiomLocality(OWLReasoner r) {
        reasoner = checkNotNull(r, "r");
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
