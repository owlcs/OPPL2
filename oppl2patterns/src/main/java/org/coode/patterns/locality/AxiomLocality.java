package org.coode.patterns.locality;

import static org.coode.oppl.utils.ArgCheck.checkNotNull;

import org.semanticweb.owlapi.model.OWLAxiom;
import org.semanticweb.owlapi.reasoner.OWLReasoner;

/** @author Luigi Iannone */
public class AxiomLocality {
    private boolean isLocal;
    private final OWLReasoner reasoner;

    /** @param r
     *            r */
    public AxiomLocality(OWLReasoner r) {
        reasoner = checkNotNull(r, "r");
    }

    /** @return true if local */
    public boolean isLocal() {
        return isLocal;
    }

    /** @param axiom
     *            axiom
     * @return true if local */
    public boolean isLocal(OWLAxiom axiom) {
        reset();
        isLocal = reasoner.isEntailed(axiom);
        return this.isLocal();
    }

    /**
     * 
     */
    public void reset() {
        isLocal = false;
    }
}
