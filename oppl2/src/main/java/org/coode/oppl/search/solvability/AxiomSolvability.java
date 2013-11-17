/**
 * 
 */
package org.coode.oppl.search.solvability;

import org.coode.oppl.bindingtree.BindingNode;
import org.semanticweb.owlapi.model.OWLAxiom;

/** @author Luigi Iannone */
public interface AxiomSolvability {
    SolvabilitySearchNode getSolvabilitySearchNode(OWLAxiom owlAxiom,
            BindingNode bindingNode);
}
