/**
 * 
 */
package org.coode.oppl.search.solvability;

import org.coode.oppl.ConstraintSystem;

/** @author Luigi Iannone */
public abstract class QuerySolverBasedAbstractAxiomSolvability extends
        AbstractAxiomSolvability {
    private final QuerySolver querySolver;

    /** @param constraintSystem
     * @param querySolver */
    public QuerySolverBasedAbstractAxiomSolvability(ConstraintSystem constraintSystem,
            QuerySolver querySolver) {
        super(constraintSystem);
        if (querySolver == null) {
            throw new NullPointerException("The query solver cannot be null");
        }
        this.querySolver = querySolver;
    }

    /** @return the querySolver */
    public QuerySolver getQuerySolver() {
        return querySolver;
    }
}
