package org.coode.parsers.oppl.variableattribute;

import org.coode.oppl.ConstraintSystem;

public interface AttributeFactory<O> {
	public O create(ConstraintSystem constraintSystem);
}
