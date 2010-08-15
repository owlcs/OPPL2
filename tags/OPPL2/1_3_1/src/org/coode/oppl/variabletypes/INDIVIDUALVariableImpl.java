package org.coode.oppl.variabletypes;

import org.coode.oppl.VariableType;
import org.coode.oppl.VariableTypeVisitorEx;

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
