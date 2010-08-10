package org.coode.oppl.variabletypes;

import org.coode.oppl.VariableType;
import org.coode.oppl.VariableTypeVisitorEx;

public class OBJECTPROPERTYVariableImpl extends VariableImpl implements
		OBJECTPROPERTYVariable {
	public OBJECTPROPERTYVariableImpl(String name) {
		super(name, VariableType.OBJECTPROPERTY);
	}

	@Override
	public <P> P accept(VariableTypeVisitorEx<P> visitor) {
		return visitor.visit(this);
	}
}
