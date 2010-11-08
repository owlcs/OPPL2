package org.coode.oppl.variabletypes;


public class CONSTANTVariableImpl extends VariableImpl implements
		CONSTANTVariable {
	public CONSTANTVariableImpl(String name) {
		super(name, org.coode.oppl.variabletypes.CONSTANT);
	}

	@Override
	public <P> P accept(VariableTypeVisitorEx<P> visitor) {
		return visitor.visit(this);
	}
}
