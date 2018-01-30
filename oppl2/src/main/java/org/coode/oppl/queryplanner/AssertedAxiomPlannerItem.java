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
import org.coode.oppl.rendering.ManchesterSyntaxRenderer;
import org.semanticweb.owlapi.model.OWLAxiom;

/**
 * @author Luigi Iannone
 */
public class AssertedAxiomPlannerItem extends AbstractQueryPlannerItem {

    private final OWLAxiom axiom;

    /**
     * @param constraintSystem constraintSystem
     * @param axiom axiom
     */
    public AssertedAxiomPlannerItem(ConstraintSystem constraintSystem, OWLAxiom axiom) {
        super(constraintSystem);
        this.axiom = checkNotNull(axiom, "axiom");
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
                    updateBindingsAssertedAxiom(instantiatedAxiom, runtimeExceptionHandler);
                toReturn.addAll(merge(bindingNode, newLeaves));
            }
            if (executionMonitor.isCancelled()) {
                toReturn = null;
            }
        } else {
            toReturn.addAll(updateBindingsAssertedAxiom(getAxiom(), runtimeExceptionHandler));
        }
        return toReturn;
    }

    private Set<BindingNode> updateBindingsAssertedAxiom(OWLAxiom ax,
        RuntimeExceptionHandler runtimeExceptionHandler) {
        assert ax != null;
        int initialSize = getConstraintSystem().leavesCount();
        Logging.getQueryLogger().log("Initial size: ", Integer.valueOf(initialSize));
        AxiomQuery query =
            new AssertedSolvabilityBasedAxiomQuery(getConstraintSystem().getOntologyManager(),
                getConstraintSystem(), runtimeExceptionHandler);
        ax.accept(query);
        return asSet(query.leaves());
    }

    @Override
    public void accept(QueryPlannerVisitor visitor) {
        visitor.visitAssertedAxiomPlannerItem(this);
    }

    @Override
    public <O> O accept(QueryPlannerVisitorEx<O> visitor) {
        return visitor.visitAssertedAxiomPlannerItem(this);
    }

    /**
     * @return the axiom
     */
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
