package org.coode.oppl.search.solvability;

import static org.coode.oppl.utils.ArgCheck.checkNotNull;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.stream.Stream;

import org.coode.oppl.bindingtree.BindingNode;
import org.semanticweb.owlapi.model.OWLAxiom;

/**
 * Applies a set of solvability strategies, until either a node is solved or the strategies are
 * exhausted.
 * 
 * @author Luigi Iannone
 */
public class MultipleAxiomSolvability implements AxiomSolvability {

    static class FalseUnsolvable implements SolvabilitySearchNodeVisitorEx<Boolean> {
        @Override
        public Boolean visitSolvableSearchNode(SolvableSearchNode solvableSearchNode) {
            return Boolean.TRUE;
        }

        @Override
        public Boolean visitSolvedSearchNode(SolvedSearchNode solvedSearchNode) {
            return Boolean.TRUE;
        }

        @Override
        public Boolean visitNoSolutionSolvableSearchNode(
            NoSolutionSolvableSearchNode noSolutionSolvableSearchNode) {
            return Boolean.TRUE;
        }

        @Override
        public Boolean visitUnsolvableSearchNode(UnsolvableSearchNode unsolvableSearchNode) {
            return Boolean.FALSE;
        }
    }

    private final Set<AxiomSolvability> delegates = new HashSet<>();

    /**
     * @param delegates delegates
     */
    public MultipleAxiomSolvability(Collection<? extends AxiomSolvability> delegates) {
        this.delegates.addAll(checkNotNull(delegates, "delegates"));
        if (delegates.isEmpty()) {
            throw new IllegalArgumentException("The delegate collection canont be empty");
        }
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
            solved = toReturn != null && toReturn.accept(FALSE_UNSOLVABLE).booleanValue();
        }
        return toReturn;
    }

    private static final FalseUnsolvable FALSE_UNSOLVABLE = new FalseUnsolvable();

    /**
     * @return the delegates
     * @deprecated use stream version
     */
    @Deprecated
    public Set<AxiomSolvability> getDelegates() {
        return new HashSet<>(delegates);
    }

    /**
     * @return the delegates
     */
    public Stream<AxiomSolvability> delegates() {
        return delegates.stream();
    }
}
