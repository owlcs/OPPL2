package org.coode.parsers.oppl.variableattribute;

import org.coode.oppl.variablemansyntax.ConstraintSystem;

public interface AttributeFactory<O> {
	public O create(ConstraintSystem constraintSystem);
}
