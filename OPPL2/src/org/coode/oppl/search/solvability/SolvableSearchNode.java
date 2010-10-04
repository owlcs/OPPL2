/**
 * 
 */
package org.coode.oppl.search.solvability;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.coode.oppl.Variable;
import org.coode.oppl.bindingtree.BindingNode;
import org.semanticweb.owlapi.model.OWLAxiom;
import org.semanticweb.owlapi.model.OWLObject;

/**
 * @author Luigi Iannone
 * 
 */
public class SolvableSearchNode extends SolvabilitySearchNode {
	private final Set<OWLObject> values = new HashSet<OWLObject>();
	private final Variable variable;

	/**
	 * @param axiom
	 * @param bindingNode
	 */
	public SolvableSearchNode(Variable variable, OWLAxiom axiom,
			BindingNode bindingNode, Collection<? extends OWLObject> values) {
		super(axiom, bindingNode);
		if (values == null) {
			throw new NullPointerException(
					"The values collection cannot be null");
		}
		if (variable == null) {
			throw new NullPointerException("The variable cannot be null");
		}
		this.values.addAll(values);
		this.variable = variable;
	}

	/**
	 * @see org.coode.oppl.search.solvability.SolvabilitySearchNode#accept(org.coode.oppl.search.solvability.SolvabilitySearchNodeVisitor)
	 */
	@Override
	public void accept(SolvabilitySearchNodeVisitor visitor) {
		visitor.visitSolvableSearchNode(this);
	}

	/**
	 * @see org.coode.oppl.search.solvability.SolvabilitySearchNode#accept(org.coode.oppl.search.solvability.SolvabilitySearchNodeVisitorEx)
	 */
	@Override
	public <O> O accept(SolvabilitySearchNodeVisitorEx<O> visitor) {
		return visitor.visitSolvableSearchNode(this);
	}

	/**
	 * @return the values
	 */
	public Set<OWLObject> getValues() {
		return new HashSet<OWLObject>(this.values);
	}

	/**
	 * @return the variable
	 */
	public Variable getVariable() {
		return this.variable;
	}
}
