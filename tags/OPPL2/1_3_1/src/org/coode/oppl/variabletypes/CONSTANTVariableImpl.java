package org.coode.oppl.variabletypes;

import org.coode.oppl.VariableType;
import org.coode.oppl.VariableTypeVisitorEx;

public class CONSTANTVariableImpl extends VariableImpl implements
		CONSTANTVariable {
	public CONSTANTVariableImpl(String name) {
		super(name, VariableType.CONSTANT);
	}

	@Override
	public <P> P accept(VariableTypeVisitorEx<P> visitor) {
		return visitor.visit(this);
	}
}
