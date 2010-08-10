package org.coode.oppl.variabletypes;

import org.coode.oppl.VariableType;
import org.coode.oppl.VariableTypeVisitorEx;

public class DATAPROPERTYVariableImpl extends VariableImpl implements
		DATAPROPERTYVariable {
	public DATAPROPERTYVariableImpl(String name) {
		super(name, VariableType.DATAPROPERTY);
	}

	@Override
	public <P> P accept(VariableTypeVisitorEx<P> visitor) {
		return visitor.visit(this);
	}
}
