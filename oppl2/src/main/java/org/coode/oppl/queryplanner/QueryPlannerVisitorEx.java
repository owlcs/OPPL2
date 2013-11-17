package org.coode.oppl.queryplanner;

public interface QueryPlannerVisitorEx<O> {
    O visitConstraintQueryPlannerItem(
            ConstraintQueryPlannerItem constraintQueryPlannerItem);

    O visitAssertedAxiomPlannerItem(AssertedAxiomPlannerItem assertedAxiomPlannerItem);

    O visitInferredAxiomQueryPlannerItem(
            InferredAxiomQueryPlannerItem inferredAxiomQueryPlannerItem);
}
