package org.coode.oppl.variabletypes;


public class DATAPROPERTYVariableImpl extends VariableImpl implements
		DATAPROPERTYVariable {
	public DATAPROPERTYVariableImpl(String name) {
		super(name, org.coode.oppl.variabletypes.DATAPROPERTY);
	}

	@Override
	public <P> P accept(VariableTypeVisitorEx<P> visitor) {
		return visitor.visit(this);
	}
}
