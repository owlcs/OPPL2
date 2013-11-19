package org.coode.oppl.search.solvability;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.coode.oppl.bindingtree.BindingNode;
import org.semanticweb.owlapi.model.OWLAxiom;

/** Applies a set of solvability strategies, until either a node is solved or the
 * strategies are exhausted.
 * 
 * @author Luigi Iannone */
public class MultipleAxiomSolvability implements AxiomSolvability {
    private final Set<AxiomSolvability> delegates = new HashSet<AxiomSolvability>();

    public MultipleAxiomSolvability(Collection<? extends AxiomSolvability> delegates) {
        if (delegates == null) {
            throw new NullPointerException("The delegate collection cannot be null");
        }
        if (delegates.isEmpty()) {
            throw new IllegalArgumentException("The delegate collection canont be empty");
        }
        this.delegates.addAll(delegates);
    }

    @Override
    public SolvabilitySearchNode getSolvabilitySearchNode(OWLAxiom owlAxiom,
            BindingNode bindingNode) {
        boolean solved = false;
        Iterator<AxiomSolvability> iterator = delegates.iterator();
        SolvabilitySearchNode toReturn = null;
        while (!solved && iterator.hasNext()) {
            AxiomSolvability axiomSolvability = iterator.next();
            toReturn = axiomSolvability.getSolvabilitySearchNode(owlAxiom, bindingNode);
            solved = toReturn.accept(new SolvabilitySearchNodeVisitorEx<Boolean>() {
                @Override
                public Boolean visitSolvableSearchNode(
                        SolvableSearchNode solvableSearchNode) {
                    return true;
                }

                @Override
                public Boolean visitSolvedSearchNode(SolvedSearchNode solvedSearchNode) {
                    return true;
                }

                @Override
                public Boolean visitNoSolutionSolvableSearchNode(
                        NoSolutionSolvableSearchNode noSolutionSolvableSearchNode) {
                    return true;
                }

                @Override
                public Boolean visitUnsolvableSearchNode(
                        UnsolvableSearchNode unsolvableSearchNode) {
                    return false;
                }
            });
        }
        return toReturn;
    }

    /** @return the delegates */
    public Set<AxiomSolvability> getDelegates() {
        return new HashSet<AxiomSolvability>(delegates);
    }
}
