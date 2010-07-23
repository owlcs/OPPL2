package org.coode.oppl.variablemansyntax.generated.factory;

import java.util.List;

import org.coode.oppl.variablemansyntax.ConstraintSystem;
import org.coode.oppl.variablemansyntax.Variable;
import org.coode.oppl.variablemansyntax.bindingtree.BindingNode;
import org.coode.oppl.variablemansyntax.generated.Attribute;
import org.coode.oppl.variablemansyntax.generated.SingleValueGeneratedValueVisitor;
import org.coode.oppl.variablemansyntax.generated.SingleValueGeneratedValueVisitorEx;
import org.coode.oppl.variablemansyntax.generated.VariableGeneratedValue;

public class RenderingVariableGeneratedValue extends
		VariableGeneratedValue<String> {
	private final ConstraintSystem constraintSystem;

	public RenderingVariableGeneratedValue(Variable variable,
			Attribute attribute, ConstraintSystem constraintSystem) {
		super(variable, attribute);
		this.constraintSystem = constraintSystem;
	}

	public String getGeneratedValue(BindingNode node) {
		return RenderingAttributeGenerator.getInstance(this.constraintSystem)
				.getValue(node.getAssignmentValue(this.getVariable()));
	}

	public List<String> computePossibleValues() {
		return RenderingAttributeGenerator.getInstance(this.constraintSystem)
				.getValues(this.getVariable());
	}

	public void accept(SingleValueGeneratedValueVisitor visitor) {
		visitor.visitRenderingVariableGeneratedValue(this);
	}

	public <O> O accept(SingleValueGeneratedValueVisitorEx<O> visitor) {
		return visitor.visitRenderingVariableGeneratedValue(this);
	}
}