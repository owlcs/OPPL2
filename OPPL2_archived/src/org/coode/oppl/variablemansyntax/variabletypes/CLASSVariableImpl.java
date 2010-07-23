package org.coode.oppl.variablemansyntax.variabletypes;

import org.coode.oppl.variablemansyntax.VariableType;
import org.coode.oppl.variablemansyntax.VariableTypeVisitorEx;

public class CLASSVariableImpl extends VariableImpl implements CLASSVariable {
	public CLASSVariableImpl(String name) {
		super(name, VariableType.CLASS);
	}

	@Override
	public <P> P accept(VariableTypeVisitorEx<P> visitor) {
		return visitor.visit(this);
	}
}
