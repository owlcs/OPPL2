package org.coode.oppl.variabletypes;


public class OBJECTPROPERTYVariableImpl extends VariableImpl implements
		OBJECTPROPERTYVariable {
	public OBJECTPROPERTYVariableImpl(String name) {
		super(name, org.coode.oppl.variabletypes.OBJECTPROPERTY);
	}

	@Override
	public <P> P accept(VariableTypeVisitorEx<P> visitor) {
		return visitor.visit(this);
	}
}
