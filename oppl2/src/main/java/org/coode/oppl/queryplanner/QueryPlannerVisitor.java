package org.coode.oppl.queryplanner;

/** @author Luigi Iannone */
public interface QueryPlannerVisitor {
    /** @param constraintQueryPlannerItem */
    void visitConstraintQueryPlannerItem(
            ConstraintQueryPlannerItem constraintQueryPlannerItem);

    /** @param assertedAxiomPlannerItem */
    void visitAssertedAxiomPlannerItem(AssertedAxiomPlannerItem assertedAxiomPlannerItem);

    /** @param inferredAxiomQueryPlannerItem */
    void visitInferredAxiomQueryPlannerItem(
            InferredAxiomQueryPlannerItem inferredAxiomQueryPlannerItem);
}
