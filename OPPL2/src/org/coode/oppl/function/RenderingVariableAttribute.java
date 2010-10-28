package org.coode.oppl.function;

import org.coode.oppl.Variable;
import org.coode.oppl.generated.Attribute;

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
}
