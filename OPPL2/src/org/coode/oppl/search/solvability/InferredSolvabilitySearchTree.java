package org.coode.oppl.search.solvability;

import java.util.Set;

import org.coode.oppl.ConstraintSystem;
import org.coode.oppl.Variable;
import org.coode.oppl.utils.VariableExtractor;
import org.semanticweb.owlapi.reasoner.OWLReasoner;

public final class InferredSolvabilitySearchTree extends AbstractSolvabilityOPPLOWLAxiomSearchTree {
	/**
	 * @param constraintSystem
	 */
	public InferredSolvabilitySearchTree(ConstraintSystem constraintSystem) {
		super(constraintSystem);
		OWLReasoner reasoner = constraintSystem.getReasoner();
		if (reasoner == null) {
			throw new IllegalArgumentException(
					"The reasoner cannot be null in the input constraint system");
		}
	}

	@Override
	protected boolean goalReachedUnsolvabelNode(UnsolvableSearchNode unsolvableSearchNode) {
		VariableExtractor variableExtractor = new VariableExtractor(this.getConstraintSystem(),
				true);
		Set<Variable> extractVariables = variableExtractor.extractVariables(unsolvableSearchNode.getAxiom());
		return extractVariables.isEmpty() ? this.getConstraintSystem().getReasoner().isEntailed(
				unsolvableSearchNode.getAxiom()) : false;
	}

	@Override
	protected QuerySolver getQuerySolver() {
		return new InferredModelQuerySolver(this.getConstraintSystem().getReasoner());
	}
}
