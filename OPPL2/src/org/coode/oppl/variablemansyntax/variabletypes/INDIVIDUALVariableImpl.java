package org.coode.oppl.variablemansyntax.variabletypes;

import org.coode.oppl.variablemansyntax.VariableType;
import org.coode.oppl.variablemansyntax.VariableTypeVisitorEx;

public class INDIVIDUALVariableImpl extends VariableImpl implements
		INDIVIDUALVariable {
	public INDIVIDUALVariableImpl(String name) {
		super(name, VariableType.INDIVIDUAL);
	}

	@Override
	public <P> P accept(VariableTypeVisitorEx<P> visitor) {
		return visitor.visit(this);
	}
}
