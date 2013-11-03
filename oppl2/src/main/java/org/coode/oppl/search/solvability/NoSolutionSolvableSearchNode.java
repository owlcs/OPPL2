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
public class NoSolutionSolvableSearchNode extends SolvabilitySearchNode {
	/**
	 * @param axiom
	 * @param bindingNode
	 */
	public NoSolutionSolvableSearchNode(OWLAxiom axiom, BindingNode bindingNode) {
		super(axiom, bindingNode);
	}

	@Override
	public void accept(SolvabilitySearchNodeVisitor visitor) {
		visitor.visitNoSolutionSolvableSearchNode(this);
	}

	@Override
	public <O> O accept(SolvabilitySearchNodeVisitorEx<O> visitor) {
		return visitor.visitNoSolutionSolvableSearchNode(this);
	}
}
