package org.coode.oppl.generated.factory;

import java.util.List;

import org.coode.oppl.ConstraintSystem;
import org.coode.oppl.Variable;
import org.coode.oppl.bindingtree.BindingNode;
import org.coode.oppl.generated.Attribute;
import org.coode.oppl.generated.SingleValueGeneratedValueVisitor;
import org.coode.oppl.generated.SingleValueGeneratedValueVisitorEx;
import org.coode.oppl.generated.VariableGeneratedValue;

public class RenderingVariableGeneratedValue extends VariableGeneratedValue<String> {
	private final ConstraintSystem constraintSystem;

	public RenderingVariableGeneratedValue(Variable variable, Attribute attribute,
			ConstraintSystem constraintSystem) {
		super(variable, attribute);
		this.constraintSystem = constraintSystem;
	}

	public String getGeneratedValue(BindingNode node) {
		return RenderingAttributeGenerator.getInstance(this.constraintSystem).getValue(
				node.getAssignmentValue(this.getVariable()));
	}

	public List<String> computePossibleValues() {
		return RenderingAttributeGenerator.getInstance(this.getConstraintSystem()).getValues(
				this.getVariable());
	}

	public void accept(SingleValueGeneratedValueVisitor visitor) {
		visitor.visitRenderingVariableGeneratedValue(this);
	}

	public <O> O accept(SingleValueGeneratedValueVisitorEx<O> visitor) {
		return visitor.visitRenderingVariableGeneratedValue(this);
	}

	/**
	 * @return the constraintSystem
	 */
	public ConstraintSystem getConstraintSystem() {
		return this.constraintSystem;
	}
}