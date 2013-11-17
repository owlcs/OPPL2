package org.coode.oppl.search.solvability;

public interface SolvabilitySearchNodeVisitorEx<O> {
    O visitSolvedSearchNode(SolvedSearchNode solvedSearchNode);

    O visitUnsolvableSearchNode(UnsolvableSearchNode unsolvableSearchNode);

    O visitSolvableSearchNode(SolvableSearchNode solvableSearchNode);

    O visitNoSolutionSolvableSearchNode(
            NoSolutionSolvableSearchNode noSolutionSolvableSearchNode);
}
