package org.coode.oppl.search.solvability;

import org.coode.oppl.bindingtree.BindingNode;
import org.semanticweb.owlapi.model.OWLAxiom;

/**
 * @author Luigi Iannone
 */
public class UnsolvableSearchNode extends SolvabilitySearchNode {

    /**
     * @param axiom
     *        axiom
     * @param bindingNode
     *        bindingNode
     */
    public UnsolvableSearchNode(OWLAxiom axiom, BindingNode bindingNode) {
        super(axiom, bindingNode);
    }

    @Override
    public void accept(SolvabilitySearchNodeVisitor visitor) {
        visitor.visitUnsolvableSearchNode(this);
    }

    @Override
    public <O> O accept(SolvabilitySearchNodeVisitorEx<O> visitor) {
        return visitor.visitUnsolvableSearchNode(this);
    }
}
