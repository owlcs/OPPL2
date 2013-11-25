package org.coode.oppl.queryplanner;

import static org.coode.oppl.utils.ArgCheck.checkNotNull;

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
import org.coode.oppl.rendering.ManchesterSyntaxRenderer;
import org.semanticweb.owlapi.model.OWLAxiom;

/** @author Luigi Iannone */
public class AssertedAxiomPlannerItem extends AbstractQueryPlannerItem {
    private final OWLAxiom axiom;

    /** @param constraintSystem
     * @param axiom */
    public AssertedAxiomPlannerItem(ConstraintSystem constraintSystem, OWLAxiom axiom) {
        super(constraintSystem);
        this.axiom = checkNotNull(axiom, "axiom");
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
                Set<BindingNode> newLeaves = updateBindingsAssertedAxiom(
                        instantiatedAxiom, runtimeExceptionHandler);
                toReturn.addAll(merge(bindingNode, newLeaves));
            }
            if (executionMonitor.isCancelled()) {
                toReturn = null;
            }
        } else {
            toReturn.addAll(updateBindingsAssertedAxiom(getAxiom(),
                    runtimeExceptionHandler));
        }
        return toReturn;
    }

    private Set<BindingNode> updateBindingsAssertedAxiom(OWLAxiom ax,
            RuntimeExceptionHandler runtimeExceptionHandler) {
        assert ax != null;
        Set<BindingNode> toReturn = new HashSet<BindingNode>();
        int initialSize = getConstraintSystem().getLeaves() == null ? 0
                : getConstraintSystem().getLeaves().size();
        Logging.getQueryLogger().log("Initial size: ", initialSize);
        AxiomQuery query = new AssertedSolvabilityBasedAxiomQuery(getConstraintSystem()
                .getOntologyManager().getOntologies(), getConstraintSystem(),
                runtimeExceptionHandler);
        ax.accept(query);
        toReturn.addAll(query.getLeaves());
        return toReturn;
    }

    @Override
    public void accept(QueryPlannerVisitor visitor) {
        visitor.visitAssertedAxiomPlannerItem(this);
    }

    @Override
    public <O> O accept(QueryPlannerVisitorEx<O> visitor) {
        return visitor.visitAssertedAxiomPlannerItem(this);
    }

    /** @return the axiom */
    public OWLAxiom getAxiom() {
        return axiom;
    }

    @Override
    public String toString() {
        ManchesterSyntaxRenderer renderer = getConstraintSystem().getOPPLFactory()
                .getManchesterSyntaxRenderer(getConstraintSystem());
        getAxiom().accept(renderer);
        return String.format("ASSERTED %s ", renderer.toString());
    }
}
