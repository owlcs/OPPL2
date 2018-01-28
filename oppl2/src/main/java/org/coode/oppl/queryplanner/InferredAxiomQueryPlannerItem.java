package org.coode.oppl.queryplanner;

import static org.coode.oppl.utils.ArgCheck.checkNotNull;
import static org.semanticweb.owlapi.util.OWLAPIStreamUtils.asSet;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.coode.oppl.ConstraintSystem;
import org.coode.oppl.ExecutionMonitor;
import org.coode.oppl.PartialOWLObjectInstantiator;
import org.coode.oppl.bindingtree.BindingNode;
import org.coode.oppl.exceptions.RuntimeExceptionHandler;
import org.coode.oppl.function.SimpleValueComputationParameters;
import org.coode.oppl.function.ValueComputationParameters;
import org.coode.oppl.log.Logging;
import org.coode.oppl.querymatching.AssertedSolvabilityBasedAxiomQuery;
import org.coode.oppl.querymatching.AxiomQuery;
import org.coode.oppl.querymatching.InferredSolvabilityBasedTreeSearchAxiomQuery;
import org.coode.oppl.rendering.ManchesterSyntaxRenderer;
import org.semanticweb.owlapi.model.OWLAxiom;
import org.semanticweb.owlapi.model.OWLRuntimeException;

/**
 * @author Luigi Iannone
 */
public class InferredAxiomQueryPlannerItem extends AbstractQueryPlannerItem {

    private final OWLAxiom axiom;

    /**
     * @param constraintSystem constraintSystem
     * @param axiom axiom
     */
    public InferredAxiomQueryPlannerItem(ConstraintSystem constraintSystem, OWLAxiom axiom) {
        super(constraintSystem);
        this.axiom = checkNotNull(axiom, "axiom");
    }

    /**
     * @return the axiom
     */
    public OWLAxiom getAxiom() {
        return axiom;
    }

    @Override
    public Set<BindingNode> match(Collection<? extends BindingNode> currentLeaves,
        ExecutionMonitor executionMonitor, RuntimeExceptionHandler runtimeExceptionHandler) {
        Set<BindingNode> toReturn = new HashSet<>();
        if (currentLeaves != null) {
            Iterator<? extends BindingNode> iterator = currentLeaves.iterator();
            while (!executionMonitor.isCancelled() && iterator.hasNext()) {
                BindingNode bindingNode = iterator.next();
                ValueComputationParameters parameters = new SimpleValueComputationParameters(
                    getConstraintSystem(), bindingNode, runtimeExceptionHandler);
                PartialOWLObjectInstantiator instantiator =
                    new PartialOWLObjectInstantiator(parameters);
                OWLAxiom instantiatedAxiom = (OWLAxiom) getAxiom().accept(instantiator);
                Set<BindingNode> newLeaves =
                    updateBindings(instantiatedAxiom, runtimeExceptionHandler);
                toReturn.addAll(merge(bindingNode, newLeaves));
            }
            if (executionMonitor.isCancelled()) {
                toReturn = null;
            }
        } else {
            toReturn.addAll(updateBindings(getAxiom(), runtimeExceptionHandler));
        }
        return toReturn;
    }

    private Set<BindingNode> updateBindings(OWLAxiom ax,
        RuntimeExceptionHandler runtimeExceptionHandler) throws OWLRuntimeException {
        assert ax != null;
        int initialSize = getConstraintSystem().getLeaves() == null ? 0
            : getConstraintSystem().getLeaves().size();
        Logging.getQueryLogger().fine("Initial size: ", Integer.valueOf(initialSize));
        AxiomQuery query = getConstraintSystem().getReasoner() == null || !ax.isLogicalAxiom()
            ? new AssertedSolvabilityBasedAxiomQuery(getConstraintSystem().getOntologyManager(),
                getConstraintSystem(), runtimeExceptionHandler)
            : new InferredSolvabilityBasedTreeSearchAxiomQuery(getConstraintSystem(),
                runtimeExceptionHandler);
        Logging.getQueryTestLogging().fine("Used engine: ", query.getClass().getName());
        ax.accept(query);
        return asSet(query.leaves());
    }

    @Override
    public void accept(QueryPlannerVisitor visitor) {
        visitor.visitInferredAxiomQueryPlannerItem(this);
    }

    @Override
    public <O> O accept(QueryPlannerVisitorEx<O> visitor) {
        return visitor.visitInferredAxiomQueryPlannerItem(this);
    }

    @Override
    public String toString() {
        ManchesterSyntaxRenderer renderer = getConstraintSystem().getOPPLFactory()
            .getManchesterSyntaxRenderer(getConstraintSystem());
        getAxiom().accept(renderer);
        return String.format("INFERRED %s ", renderer.toString());
    }
}
