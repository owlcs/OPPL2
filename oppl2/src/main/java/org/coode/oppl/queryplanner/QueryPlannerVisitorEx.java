package org.coode.oppl.queryplanner;

/** @author Luigi Iannone
 * @param <O> */
public interface QueryPlannerVisitorEx<O> {
    /** @param constraintQueryPlannerItem
     * @return visitor value */
    O visitConstraintQueryPlannerItem(
            ConstraintQueryPlannerItem constraintQueryPlannerItem);

    /** @param assertedAxiomPlannerItem
     * @return visitor value */
    O visitAssertedAxiomPlannerItem(AssertedAxiomPlannerItem assertedAxiomPlannerItem);

    /** @param inferredAxiomQueryPlannerItem
     * @return visitor value */
    O visitInferredAxiomQueryPlannerItem(
            InferredAxiomQueryPlannerItem inferredAxiomQueryPlannerItem);
}
