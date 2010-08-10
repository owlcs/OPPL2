package org.coode.oppl.variabletypes;

import org.coode.oppl.VariableType;
import org.coode.oppl.VariableTypeVisitorEx;

public class CLASSVariableImpl extends VariableImpl implements CLASSVariable {
	public CLASSVariableImpl(String name) {
		super(name, VariableType.CLASS);
	}

	@Override
	public <P> P accept(VariableTypeVisitorEx<P> visitor) {
		return visitor.visit(this);
	}
}
