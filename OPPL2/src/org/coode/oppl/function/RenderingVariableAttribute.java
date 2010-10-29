package org.coode.oppl.function;

import org.coode.oppl.Variable;
import org.coode.oppl.bindingtree.BindingNode;
import org.coode.oppl.generated.Attribute;
import org.coode.oppl.rendering.ManchesterSyntaxRenderer;
import org.semanticweb.owlapi.model.OWLObject;

public class RenderingVariableAttribute extends VariableAttribute<String> {
	/**
	 * @param variable
	 * @param attribute
	 */
	public RenderingVariableAttribute(Variable variable) {
		super(variable, Attribute.RENDERING);
	}

	public <P> P accept(OPPLFunctionVisitorEx<P> visitor) {
		return visitor.visitRenderingVariableAttribute(this);
	}

	public void accept(OPPLFunctionVisitor visitor) {
		visitor.visitRenderingVariableAttribute(this);
	}

	@Override
	public ValueComputation<String> getValueComputation(
			final ValueComputationParameters parameters) {
		return new ValueComputation<String>() {
			public String compute(OPPLFunction<? extends String> opplFunction) {
				String toReturn = null;
				BindingNode bindingNode = parameters.getBindingNode();
				OWLObject assignmentValue = bindingNode
						.getAssignmentValue(RenderingVariableAttribute.this
								.getVariable());
				if (assignmentValue != null) {
					ManchesterSyntaxRenderer renderer = parameters
							.getOPPLFactory().getManchesterSyntaxRenderer(
									parameters.getConstraintSystem());
					assignmentValue.accept(renderer);
					toReturn = renderer.toString();
				}
				return toReturn;
			}
		};
	}
}
