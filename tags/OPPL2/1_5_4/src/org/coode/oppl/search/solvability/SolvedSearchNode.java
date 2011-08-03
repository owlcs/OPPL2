/**
 * 
 */
package org.coode.oppl.search.solvability;

import org.coode.oppl.bindingtree.BindingNode;
import org.semanticweb.owlapi.model.OWLAxiom;

/**
 * @author Luigi Iannone
 * 
 */
public class SolvedSearchNode extends SolvabilitySearchNode {
	/**
	 * @param axiom
	 * @param bindingNode
	 */
	public SolvedSearchNode(OWLAxiom axiom, BindingNode bindingNode) {
		super(axiom, bindingNode);
	}

	/**
	 * @see org.coode.oppl.search.solvability.SolvabilitySearchNode#accept(org.coode.oppl.search.solvability.SolvabilitySearchNodeVisitor)
	 */
	@Override
	public void accept(SolvabilitySearchNodeVisitor visitor) {
		visitor.visitSolvedSearchNode(this);
	}

	/**
	 * @see org.coode.oppl.search.solvability.SolvabilitySearchNode#accept(org.coode.oppl.search.solvability.SolvabilitySearchNodeVisitorEx)
	 */
	@Override
	public <O> O accept(SolvabilitySearchNodeVisitorEx<O> visitor) {
		return visitor.visitSolvedSearchNode(this);
	}
}
