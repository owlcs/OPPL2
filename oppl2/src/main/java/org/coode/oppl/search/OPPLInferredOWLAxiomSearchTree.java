/**
 *
 */
package org.coode.oppl.search;

import org.coode.oppl.ConstraintSystem;
import org.coode.oppl.exceptions.RuntimeExceptionHandler;

/** @author Luigi Iannone */
public class OPPLInferredOWLAxiomSearchTree extends AbstractOPPLAxiomSearchTree {
    /** @param constraintSystem
     * @param runtimeExceptionHandler */
    public OPPLInferredOWLAxiomSearchTree(ConstraintSystem constraintSystem,
            RuntimeExceptionHandler runtimeExceptionHandler) {
        super(constraintSystem, runtimeExceptionHandler);
    }

    /** @return {@code true} if the input {@link OPPLOWLAxiomSearchNode}
     *         represents an OWLAxiom that can be inferred using the reasoner
     *         exposed by the ConstraintSystem.
     * @see org.coode.oppl.search.SearchTree#goalReached(java.lang.Object) */
    @Override
    protected boolean goalReached(OPPLOWLAxiomSearchNode start) {
        boolean toReturn = start.getBinding().isLeaf();
        if (toReturn) {
            toReturn = getConstraintSystem().getReasoner().isEntailed(start.getAxiom());
        }
        return toReturn;
    }
}
