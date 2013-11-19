package org.coode.oppl.search.solvability;

import org.coode.oppl.ConstraintSystem;

/** @author Luigi Iannone */
public abstract class AbstractAxiomSolvability implements AxiomSolvability {
    private final ConstraintSystem constraintSystem;

    /** @param constraintSystem */
    public AbstractAxiomSolvability(ConstraintSystem constraintSystem) {
        if (constraintSystem == null) {
            throw new NullPointerException("The constraint system cannot be null");
        }
        this.constraintSystem = constraintSystem;
    }

    /** @return the constraintSystem */
    public ConstraintSystem getConstraintSystem() {
        return constraintSystem;
    }
}
