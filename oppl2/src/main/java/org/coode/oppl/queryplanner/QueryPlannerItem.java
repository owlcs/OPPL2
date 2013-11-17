package org.coode.oppl.queryplanner;

import java.util.Collection;
import java.util.Set;

import org.coode.oppl.ExecutionMonitor;
import org.coode.oppl.bindingtree.BindingNode;
import org.coode.oppl.exceptions.RuntimeExceptionHandler;

public interface QueryPlannerItem {
    /** Matches this planner items
     * 
     * @param currentLeaves
     *            The current set of leaves
     * @param executionMonitor
     *            The Execution Monitor. Cannot be {@code null}
     * @param runtimeExceptionHandler
     *            The run-time exception handler. Cannot be {@code null}.
     * @return The new Set of current leaves.
     * @throw {@link NullPointerException} if the run-time exception handler or
     *        the execution monitor is {@code null}. */
    public Set<BindingNode> match(Collection<? extends BindingNode> currentLeaves,
            ExecutionMonitor executionMonitor,
            RuntimeExceptionHandler runtimeExceptionHandler);

    // Visitor pattern methods start
    public void accept(QueryPlannerVisitor visitor);

    public <O> O accept(QueryPlannerVisitorEx<O> visitor);
    // Visitor pattern methods end
}
