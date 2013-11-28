package org.coode.oppl.search.solvability;

/** @author Luigi Iannone */
public interface SolvabilitySearchNodeVisitor {
    /** @param solvedSearchNode */
    void visitSolvedSearchNode(SolvedSearchNode solvedSearchNode);

    /** @param unsolvableSearchNode */
    void visitUnsolvableSearchNode(UnsolvableSearchNode unsolvableSearchNode);

    /** @param solvableSearchNode */
    void visitSolvableSearchNode(SolvableSearchNode solvableSearchNode);

    /** @param noSolutionSolvableSearchNode */
    void visitNoSolutionSolvableSearchNode(
            NoSolutionSolvableSearchNode noSolutionSolvableSearchNode);
}
