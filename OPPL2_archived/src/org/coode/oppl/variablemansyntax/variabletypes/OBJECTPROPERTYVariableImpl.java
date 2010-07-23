package org.coode.oppl.variablemansyntax.variabletypes;

import org.coode.oppl.variablemansyntax.VariableType;
import org.coode.oppl.variablemansyntax.VariableTypeVisitorEx;

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
