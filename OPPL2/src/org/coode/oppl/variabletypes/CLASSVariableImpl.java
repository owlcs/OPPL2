package org.coode.oppl.variabletypes;


public class CLASSVariableImpl extends VariableImpl implements CLASSVariable {
	public CLASSVariableImpl(String name) {
		super(name, org.coode.oppl.variabletypes.CLASS);
	}

	@Override
	public <P> P accept(VariableTypeVisitorEx<P> visitor) {
		return visitor.visit(this);
	}
}
