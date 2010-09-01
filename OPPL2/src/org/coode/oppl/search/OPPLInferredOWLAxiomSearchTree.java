/**
 *
 */
package org.coode.oppl.search;

import org.coode.oppl.ConstraintSystem;

/**
 * @author Luigi Iannone
 * 
 */
public class OPPLInferredOWLAxiomSearchTree extends AbstractOPPLAxiomSearchTree {
	public OPPLInferredOWLAxiomSearchTree(ConstraintSystem constraintSystem) {
		super(constraintSystem);
	}

	/**
	 * @return {@code true} if the input {@link OPPLOWLAxiomSearchNode}
	 *         represents an OWLAxiom that can be inferred using the reasoner
	 *         exposed by the ConstraintSystem.
	 * @see org.coode.oppl.search.SearchTree#goalReached(java.lang.Object)
	 */
	@Override
	protected boolean goalReached(OPPLOWLAxiomSearchNode start) {
		boolean toReturn = start.getBinding().isLeaf();
		if (toReturn) {
			toReturn = this.getConstraintSystem().getReasoner().isEntailed(
					start.getAxiom());
		}
		return toReturn;
	}
}
