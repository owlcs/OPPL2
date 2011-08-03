package org.coode.oppl.queryplanner;

public interface QueryPlannerVisitor {
	void visitConstraintQueryPlannerItem(ConstraintQueryPlannerItem constraintQueryPlannerItem);

	void visitAssertedAxiomPlannerItem(AssertedAxiomPlannerItem assertedAxiomPlannerItem);

	void visitInferredAxiomQueryPlannerItem(
			InferredAxiomQueryPlannerItem inferredAxiomQueryPlannerItem);
}
