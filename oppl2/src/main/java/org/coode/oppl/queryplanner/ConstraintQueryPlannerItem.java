package org.coode.oppl.queryplanner;

import static org.coode.oppl.utils.ArgCheck.checkNotNull;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.coode.oppl.AbstractConstraint;
import org.coode.oppl.ConstraintSystem;
import org.coode.oppl.ExecutionMonitor;
import org.coode.oppl.bindingtree.BindingNode;
import org.coode.oppl.exceptions.RuntimeExceptionHandler;
import org.coode.oppl.function.SimpleValueComputationParameters;
import org.coode.oppl.function.ValueComputationParameters;
import org.coode.oppl.querymatching.ConstraintChecker;

/** @author Luigi Iannone */
public class ConstraintQueryPlannerItem extends AbstractQueryPlannerItem {
    private final AbstractConstraint constraint;

    /** @param constraintSystem
     *            constraintSystem
     * @param constraint
     *            constraint */
    public ConstraintQueryPlannerItem(ConstraintSystem constraintSystem,
            AbstractConstraint constraint) {
        super(constraintSystem);
        this.constraint = checkNotNull(constraint, "constraint");
    }

    @Override
    public Set<BindingNode> match(Collection<? extends BindingNode> currentLeaves,
            ExecutionMonitor executionMonitor,
            RuntimeExceptionHandler runtimeExceptionHandler) {
        Set<BindingNode> toReturn = new HashSet<BindingNode>(currentLeaves.size());
        Iterator<? extends BindingNode> it = currentLeaves.iterator();
        BindingNode leaf;
        while (!executionMonitor.isCancelled() && it.hasNext()) {
            leaf = it.next();
            boolean holdingLeaf = checkConstraint(leaf, getConstraint(),
                    runtimeExceptionHandler);
            if (!holdingLeaf) {
                it.remove();
            }
        }
        if (executionMonitor.isCancelled()) {
            toReturn = null;
        }
        if (toReturn != null) {
            toReturn.addAll(currentLeaves);
        }
        return toReturn;
    }

    private boolean checkConstraint(BindingNode leaf, AbstractConstraint c,
            RuntimeExceptionHandler runtimeExceptionHandler) {
        boolean hold = true;
        ValueComputationParameters parameters = new SimpleValueComputationParameters(
                getConstraintSystem(), leaf, runtimeExceptionHandler);
        ConstraintChecker constraintChecker = new ConstraintChecker(parameters);
        hold = c.accept(constraintChecker);
        return hold;
    }

    @Override
    public void accept(QueryPlannerVisitor visitor) {
        visitor.visitConstraintQueryPlannerItem(this);
    }

    @Override
    public <O> O accept(QueryPlannerVisitorEx<O> visitor) {
        return visitor.visitConstraintQueryPlannerItem(this);
    }

    /** @return the constraint */
    public AbstractConstraint getConstraint() {
        return constraint;
    }

    @Override
    public String toString() {
        return getConstraint().render(getConstraintSystem());
    }
}
