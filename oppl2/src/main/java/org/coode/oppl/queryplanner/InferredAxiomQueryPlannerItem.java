package org.coode.oppl.queryplanner;

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

public class InferredAxiomQueryPlannerItem extends AbstractQueryPlannerItem {
    private final OWLAxiom axiom;

    /** @param constraintSystem
     * @param axiom */
    public InferredAxiomQueryPlannerItem(ConstraintSystem constraintSystem, OWLAxiom axiom) {
        super(constraintSystem);
        if (axiom == null) {
            throw new NullPointerException("The axiom cannot be null");
        }
        this.axiom = axiom;
    }

    /** @return the axiom */
    public OWLAxiom getAxiom() {
        return axiom;
    }

    @Override
    public Set<BindingNode> match(Collection<? extends BindingNode> currentLeaves,
            ExecutionMonitor executionMonitor,
            RuntimeExceptionHandler runtimeExceptionHandler) {
        Set<BindingNode> toReturn = new HashSet<BindingNode>();
        if (currentLeaves != null) {
            Iterator<? extends BindingNode> iterator = currentLeaves.iterator();
            while (!executionMonitor.isCancelled() && iterator.hasNext()) {
                BindingNode bindingNode = iterator.next();
                ValueComputationParameters parameters = new SimpleValueComputationParameters(
                        getConstraintSystem(), bindingNode, runtimeExceptionHandler);
                PartialOWLObjectInstantiator instantiator = new PartialOWLObjectInstantiator(
                        parameters);
                OWLAxiom instantiatedAxiom = (OWLAxiom) getAxiom().accept(instantiator);
                Set<BindingNode> newLeaves = updateBindings(instantiatedAxiom,
                        runtimeExceptionHandler);
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

    private Set<BindingNode> updateBindings(OWLAxiom axiom,
            RuntimeExceptionHandler runtimeExceptionHandler) throws OWLRuntimeException {
        assert axiom != null;
        Set<BindingNode> toReturn = new HashSet<BindingNode>();
        int initialSize = getConstraintSystem().getLeaves() == null ? 0
                : getConstraintSystem().getLeaves().size();
        Logging.getQueryLogger().fine("Initial size: ", initialSize);
        AxiomQuery query = getConstraintSystem().getReasoner() == null
                || !axiom.isLogicalAxiom() ? new AssertedSolvabilityBasedAxiomQuery(
                getConstraintSystem().getOntologyManager().getOntologies(),
                getConstraintSystem(), runtimeExceptionHandler)
                : new InferredSolvabilityBasedTreeSearchAxiomQuery(getConstraintSystem(),
                        runtimeExceptionHandler);
        Logging.getQueryTestLogging().fine("Used engine: ", query.getClass().getName());
        axiom.accept(query);
        toReturn.addAll(query.getLeaves());
        return toReturn;
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
