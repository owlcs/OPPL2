package org.coode.oppl.search.solvability;

public interface SolvabilitySearchNodeVisitor {
    void visitSolvedSearchNode(SolvedSearchNode solvedSearchNode);

    void visitUnsolvableSearchNode(UnsolvableSearchNode unsolvableSearchNode);

    void visitSolvableSearchNode(SolvableSearchNode solvableSearchNode);

    void visitNoSolutionSolvableSearchNode(
            NoSolutionSolvableSearchNode noSolutionSolvableSearchNode);
}
