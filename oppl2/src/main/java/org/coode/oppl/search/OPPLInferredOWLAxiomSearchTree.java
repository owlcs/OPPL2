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

    @Override
    protected boolean goalReached(OPPLOWLAxiomSearchNode start) {
        boolean toReturn = start.getBinding().isLeaf();
        if (toReturn) {
            toReturn = getConstraintSystem().getReasoner().isEntailed(start.getAxiom());
        }
        return toReturn;
    }
}
