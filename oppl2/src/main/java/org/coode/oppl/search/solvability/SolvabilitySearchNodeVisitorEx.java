package org.coode.oppl.search.solvability;

/** @author Luigi Iannone
 * @param <O> */
public interface SolvabilitySearchNodeVisitorEx<O> {
    /** @param solvedSearchNode
     * @return visitor value */
    O visitSolvedSearchNode(SolvedSearchNode solvedSearchNode);

    /** @param unsolvableSearchNode
     * @return visitor value */
    O visitUnsolvableSearchNode(UnsolvableSearchNode unsolvableSearchNode);

    /** @param solvableSearchNode
     * @return visitor value */
    O visitSolvableSearchNode(SolvableSearchNode solvableSearchNode);

    /** @param noSolutionSolvableSearchNode
     * @return visitor value */
    O visitNoSolutionSolvableSearchNode(
            NoSolutionSolvableSearchNode noSolutionSolvableSearchNode);
}
