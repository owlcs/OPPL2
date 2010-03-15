package org.coode.oppl.variablemansyntax.variabletypes;

import org.coode.oppl.variablemansyntax.VariableType;
import org.coode.oppl.variablemansyntax.VariableTypeVisitorEx;

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
