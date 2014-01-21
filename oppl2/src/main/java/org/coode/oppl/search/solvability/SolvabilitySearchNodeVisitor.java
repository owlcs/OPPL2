package org.coode.oppl.search.solvability;

/** @author Luigi Iannone */
public interface SolvabilitySearchNodeVisitor {
    /** @param solvedSearchNode
     *            solvedSearchNode */
    void visitSolvedSearchNode(SolvedSearchNode solvedSearchNode);

    /** @param unsolvableSearchNode
     *            unsolvableSearchNode */
    void visitUnsolvableSearchNode(UnsolvableSearchNode unsolvableSearchNode);

    /** @param solvableSearchNode
     *            solvableSearchNode */
    void visitSolvableSearchNode(SolvableSearchNode solvableSearchNode);

    /** @param noSolutionSolvableSearchNode
     *            noSolutionSolvableSearchNode */
    void visitNoSolutionSolvableSearchNode(
            NoSolutionSolvableSearchNode noSolutionSolvableSearchNode);
}
