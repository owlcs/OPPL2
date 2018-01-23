package org.coode.oppl.search;

import org.coode.oppl.ConstraintSystem;
import org.coode.oppl.exceptions.RuntimeExceptionHandler;

/**
 * @author Luigi Iannone
 */
public class OPPLAssertedOWLAxiomSearchTree extends AbstractOPPLAxiomSearchTree {

    /**
     * @param constraintSystem constraintSystem
     * @param runtimeExceptionHandler runtimeExceptionHandler
     */
    public OPPLAssertedOWLAxiomSearchTree(ConstraintSystem constraintSystem,
        RuntimeExceptionHandler runtimeExceptionHandler) {
        super(constraintSystem, runtimeExceptionHandler);
    }

    @Override
    protected boolean goalReached(OPPLOWLAxiomSearchNode start) {
        return getConstraintSystem().getOntologyManager().ontologies()
            .anyMatch(o -> o.containsAxiom(start.getAxiom()));
    }
}
