package org.coode.oppl.search.solvability;

/** @author Luigi Iannone
 * @param <O>
 *            type */
public interface SolvabilitySearchNodeVisitorEx<O> {
    /** @param solvedSearchNode
     *            solvedSearchNode
     * @return visitor value */
    O visitSolvedSearchNode(SolvedSearchNode solvedSearchNode);

    /** @param unsolvableSearchNode
     *            unsolvableSearchNode
     * @return visitor value */
    O visitUnsolvableSearchNode(UnsolvableSearchNode unsolvableSearchNode);

    /** @param solvableSearchNode
     *            solvableSearchNode
     * @return visitor value */
    O visitSolvableSearchNode(SolvableSearchNode solvableSearchNode);

    /** @param noSolutionSolvableSearchNode
     *            noSolutionSolvableSearchNode
     * @return visitor value */
    O visitNoSolutionSolvableSearchNode(
            NoSolutionSolvableSearchNode noSolutionSolvableSearchNode);
}
