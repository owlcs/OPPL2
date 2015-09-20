package org.coode.oppl.queryplanner;

/**
 * @author Luigi Iannone
 * @param <O>
 *        type
 */
public interface QueryPlannerVisitorEx<O> {

    /**
     * @param constraintQueryPlannerItem
     *        constraintQueryPlannerItem
     * @return visitor value
     */
    O visitConstraintQueryPlannerItem(
        ConstraintQueryPlannerItem constraintQueryPlannerItem);

    /**
     * @param assertedAxiomPlannerItem
     *        assertedAxiomPlannerItem
     * @return visitor value
     */
    O visitAssertedAxiomPlannerItem(AssertedAxiomPlannerItem assertedAxiomPlannerItem);

    /**
     * @param inferredAxiomQueryPlannerItem
     *        inferredAxiomQueryPlannerItem
     * @return visitor value
     */
    O visitInferredAxiomQueryPlannerItem(
        InferredAxiomQueryPlannerItem inferredAxiomQueryPlannerItem);
}
