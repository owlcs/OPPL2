package org.coode.oppl.search.solvability;

import static org.coode.oppl.utils.ArgCheck.checkNotNull;

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
        this.querySolver = checkNotNull(querySolver, "querySolver");
    }

    /** @return the querySolver */
    public QuerySolver getQuerySolver() {
        return querySolver;
    }
}
