package org.coode.oppl.generated;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.coode.oppl.ConstraintSystem;
import org.coode.oppl.OWLObjectInstantiator;
import org.coode.oppl.bindingtree.BindingNode;
import org.semanticweb.owlapi.model.OWLObject;

public class VariableExpressionGeneratedValue implements
		SingleValueGeneratedValue<OWLObject> {
	private final OWLObject owlObject;
	private final ConstraintSystem constraintSystem;

	/**
	 * @param owlObject
	 */
	protected VariableExpressionGeneratedValue(OWLObject owlObject,
			ConstraintSystem constraintSystem) {
		assert owlObject != null;
		assert constraintSystem != null;
		this.owlObject = owlObject;
		this.constraintSystem = constraintSystem;
	}

	public OWLObject getGeneratedValue(BindingNode node) {
		OWLObjectInstantiator instantiator = new OWLObjectInstantiator(node,
				this.constraintSystem);
		OWLObject instantiation = this.owlObject.accept(instantiator);
		return instantiation;
	}

	public List<OWLObject> computePossibleValues() {
		Set<BindingNode> leaves = this.constraintSystem.getLeaves();
		List<OWLObject> toReturn = new ArrayList<OWLObject>(leaves.size());
		for (BindingNode bindingNode : leaves) {
			toReturn.add(this.getGeneratedValue(bindingNode));
		}
		return toReturn;
	}

	public void accept(SingleValueGeneratedValueVisitor visitor) {
		visitor.visitVariableExpressionGeneratedValue(this);
	}

	public <O> O accept(SingleValueGeneratedValueVisitorEx<O> visitor) {
		return visitor.visitVariableExpressionGeneratedValue(this);
	}

	public OWLObject getExpression() {
		return this.owlObject;
	}
}