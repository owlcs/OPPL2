package org.coode.oppl.variablemansyntax.variabletypes;

import org.coode.oppl.variablemansyntax.VariableType;
import org.coode.oppl.variablemansyntax.VariableTypeVisitorEx;

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
