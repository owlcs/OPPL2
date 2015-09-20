package org.coode.oppl.search.solvability;

import static org.coode.oppl.utils.ArgCheck.checkNotNull;

import org.coode.oppl.ConstraintSystem;

/**
 * @author Luigi Iannone
 */
public abstract class AbstractAxiomSolvability implements AxiomSolvability {

    private final ConstraintSystem constraintSystem;

    /**
     * @param constraintSystem
     *        constraintSystem
     */
    public AbstractAxiomSolvability(ConstraintSystem constraintSystem) {
        this.constraintSystem = checkNotNull(constraintSystem, "constraintSystem");
    }

    /**
     * @return the constraintSystem
     */
    public ConstraintSystem getConstraintSystem() {
        return constraintSystem;
    }
}
