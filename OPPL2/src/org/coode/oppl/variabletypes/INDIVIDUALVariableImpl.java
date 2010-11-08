package org.coode.oppl.variabletypes;


public class INDIVIDUALVariableImpl extends VariableImpl implements
		INDIVIDUALVariable {
	public INDIVIDUALVariableImpl(String name) {
		super(name, org.coode.oppl.variabletypes.INDIVIDUAL);
	}

	@Override
	public <P> P accept(VariableTypeVisitorEx<P> visitor) {
		return visitor.visit(this);
	}
}
