/**
 * 
 */
package org.coode.oppl.search.solvability;

import org.coode.oppl.ConstraintSystem;
import org.coode.oppl.Variable;
import org.coode.oppl.bindingtree.BindingNode;
import org.coode.oppl.utils.VariableExtractor;
import org.semanticweb.owlapi.model.OWLAxiom;
import org.semanticweb.owlapi.model.OWLAxiomVisitorEx;
import org.semanticweb.owlapi.model.OWLObject;
import org.semanticweb.owlapi.model.OWLSubClassOfAxiom;
import org.semanticweb.owlapi.util.OWLObjectVisitorExAdapter;

/**
 * @author Luigi Iannone
 * 
 */
public final class AxiomSolvability extends
		OWLObjectVisitorExAdapter<SolvabilitySearchNode> implements
		OWLAxiomVisitorEx<SolvabilitySearchNode> {
	private final VariableExtractor variableExtractor;
	private final BindingNode bindingNode;
	private final QuerySolver querySolver;

	/**
	 * @param constraintSystem
	 */
	public AxiomSolvability(ConstraintSystem constraintSystem,
			BindingNode bindingNode, QuerySolver querySolver) {
		if (constraintSystem == null) {
			throw new NullPointerException(
					"The constraint system cannot be null");
		}
		if (bindingNode == null) {
			throw new NullPointerException("The binding node cannot be null");
		}
		if (querySolver == null) {
			throw new NullPointerException("The query solver cannot be null");
		}
		this.variableExtractor = new VariableExtractor(constraintSystem, true);
		this.bindingNode = bindingNode;
		this.querySolver = querySolver;
	}

	@Override
	protected SolvabilitySearchNode getDefaultReturnValue(OWLObject object) {
		return new UnsolvableSearchNode((OWLAxiom) object, this.bindingNode);
	}

	@Override
	public SolvabilitySearchNode visit(OWLSubClassOfAxiom axiom) {
		SolvabilitySearchNode toReturn = new UnsolvableSearchNode(axiom,
				this.bindingNode);
		// Solvable sub-class axioms are in the form ?x subClassOf <Variable
		// Free Class Expression>
		// or <Variable Free Class Expression> subClassOf ?x
		boolean isSolvable = this.variableExtractor.extractVariables(axiom)
				.size() == 1
				&& (this.variableExtractor.extractVariables(
						axiom.getSuperClass()).isEmpty()
						&& !axiom.getSubClass().isAnonymous()
						&& this.variableExtractor.extractVariables(
								axiom.getSubClass()).size() == 1 || this.variableExtractor
						.extractVariables(axiom.getSubClass()).isEmpty()
						&& !axiom.getSuperClass().isAnonymous()
						&& this.variableExtractor.extractVariables(
								axiom.getSuperClass()).size() == 1);
		if (isSolvable) {
			Variable variable = this.variableExtractor.extractVariables(axiom)
					.iterator().next();
			toReturn = axiom.getSubClass().isAnonymous() ? new SolvableSearchNode(
					variable, axiom, this.bindingNode, this.querySolver
							.getSuperClasses(axiom.getSubClass()))
					: new SolvableSearchNode(variable, axiom, this.bindingNode,
							this.querySolver.getSubClasses(axiom
									.getSuperClass()));
		}
		return toReturn;
	}
}
