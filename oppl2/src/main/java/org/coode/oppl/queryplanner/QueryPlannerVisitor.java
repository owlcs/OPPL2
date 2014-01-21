package org.coode.oppl.queryplanner;

/** @author Luigi Iannone */
public interface QueryPlannerVisitor {
    /** @param constraintQueryPlannerItem
     *            constraintQueryPlannerItem */
    void visitConstraintQueryPlannerItem(
            ConstraintQueryPlannerItem constraintQueryPlannerItem);

    /** @param assertedAxiomPlannerItem
     *            assertedAxiomPlannerItem */
    void visitAssertedAxiomPlannerItem(AssertedAxiomPlannerItem assertedAxiomPlannerItem);

    /** @param inferredAxiomQueryPlannerItem
     *            inferredAxiomQueryPlannerItem */
    void visitInferredAxiomQueryPlannerItem(
            InferredAxiomQueryPlannerItem inferredAxiomQueryPlannerItem);
}
