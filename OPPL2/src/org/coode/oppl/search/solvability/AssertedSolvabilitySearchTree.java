/**
 * 
 */
package org.coode.oppl.search.solvability;

import java.util.Iterator;
import java.util.Set;

import org.coode.oppl.ConstraintSystem;
import org.coode.oppl.Variable;
import org.coode.oppl.utils.VariableExtractor;
import org.semanticweb.owlapi.model.OWLAxiom;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyManager;

/**
 * @author Luigi Iannone
 * 
 */
public class AssertedSolvabilitySearchTree extends
		AbstractSolvabilityOPPLOWLAxiomSearchTree {
	private final OWLOntologyManager ontologyManager;

	/**
	 * @param constraintSystem
	 */
	public AssertedSolvabilitySearchTree(ConstraintSystem constraintSystem,
			OWLOntologyManager ontologyManager) {
		super(constraintSystem);
		if (ontologyManager == null) {
			throw new NullPointerException(
					"The ontology manager cannot be null");
		}
		this.ontologyManager = ontologyManager;
	}

	/**
	 * @see org.coode.oppl.search.solvability.AbstractSolvabilityOPPLOWLAxiomSearchTree#getQuerySolver()
	 */
	@Override
	protected QuerySolver getQuerySolver() {
		return new AssertedModelQuerySolver(this.getOntologyManager());
	}

	/**
	 * @see org.coode.oppl.search.solvability.AbstractSolvabilityOPPLOWLAxiomSearchTree#goalReachedUnsolvabelNode(org.coode.oppl.search.solvability.UnsolvableSearchNode)
	 */
	@Override
	protected boolean goalReachedUnsolvabelNode(
			UnsolvableSearchNode unsolvableSearchNode) {
		VariableExtractor variableExtractor = new VariableExtractor(this
				.getConstraintSystem(), true);
		Set<Variable> extractVariables = variableExtractor
				.extractVariables(unsolvableSearchNode.getAxiom());
		return extractVariables.isEmpty() ? this.findAxiom(unsolvableSearchNode
				.getAxiom()) : false;
	}

	private boolean findAxiom(OWLAxiom axiom) {
		boolean found = false;
		Iterator<OWLOntology> iterator = this.getConstraintSystem()
				.getOntologyManager().getOntologies().iterator();
		while (!found && iterator.hasNext()) {
			OWLOntology ontology = iterator.next();
			found = ontology.containsAxiom(axiom);
		}
		return found;
	}

	/**
	 * @return the ontologyManager
	 */
	public OWLOntologyManager getOntologyManager() {
		return this.ontologyManager;
	}
}
