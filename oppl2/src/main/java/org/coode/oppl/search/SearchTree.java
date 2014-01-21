package org.coode.oppl.search;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/** @author Luigi Iannone
 * @param <N>
 *            type */
public abstract class SearchTree<N> {
    protected boolean depthFirstSearch(N start, Stack<N> result) {
        if (result.contains(start)) {
            return false;
        }
        result.push(start);
        boolean goalReached = this.goalReached(start);
        if (goalReached) {
            return true;
        }
        List<N> children = this.getChildren(start);
        for (int i = 0; i < children.size(); i++) {
            N child = children.get(i);
            if (this.depthFirstSearch(child, result)) {
                return true;
            }
        }
        // No path was found
        result.pop();
        return false;
    }

    protected boolean exhaustiveDepthFirstSearch(N start, Stack<N> currrentPath,
            List<List<N>> solutions) {
        if (currrentPath.contains(start)) {
            return false;
        }
        currrentPath.push(start);
        boolean goalReached = this.goalReached(start);
        if (goalReached) {
            solutions.add(new ArrayList<N>(currrentPath));
            currrentPath.pop();
            return true;
        }
        List<N> children = this.getChildren(start);
        boolean found = false;
        for (int i = 0; i < children.size(); i++) {
            N child = children.get(i);
            boolean searchSubTree = this.exhaustiveDepthFirstSearch(child, currrentPath,
                    solutions);
            found = found || searchSubTree;
        }
        currrentPath.pop();
        return found;
    }

    /** @param start
     *            start
     * @param solutions
     *            solutions
     * @return true if found */
    public boolean exhaustiveSearchTree(N start, List<List<N>> solutions) {
        solutions.clear();
        return this.exhaustiveDepthFirstSearch(start, new Stack<N>(), solutions);
    }

    protected abstract List<N> getChildren(N node);

    /** @param node
     *            node
     * @return {@code true} if the input {@link OPPLOWLAxiomSearchNode}
     *         represents an OWLAxiom that is contained in one of the ontologies
     *         managed by the ontology manager encapsulated in this
     *         OPPLOWLAxiomSearchTree. */
    protected abstract boolean goalReached(N node);
}
