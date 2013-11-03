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

	@Override
	public void accept(SolvabilitySearchNodeVisitor visitor) {
		visitor.visitSolvedSearchNode(this);
	}

	@Override
	public <O> O accept(SolvabilitySearchNodeVisitorEx<O> visitor) {
		return visitor.visitSolvedSearchNode(this);
	}
}
