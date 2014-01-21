package org.coode.oppl.search.solvability;

import org.coode.oppl.bindingtree.BindingNode;
import org.semanticweb.owlapi.model.OWLAxiom;

/** @author Luigi Iannone */
public interface AxiomSolvability {
    /** @param owlAxiom
     *            owlAxiom
     * @param bindingNode
     *            bindingNode
     * @return solvability search node */
    SolvabilitySearchNode getSolvabilitySearchNode(OWLAxiom owlAxiom,
            BindingNode bindingNode);
}
