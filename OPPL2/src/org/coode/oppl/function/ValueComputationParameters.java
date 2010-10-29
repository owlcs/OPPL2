package org.coode.oppl.function;

import org.coode.oppl.ConstraintSystem;
import org.coode.oppl.OPPLAbstractFactory;
import org.coode.oppl.bindingtree.BindingNode;

public interface ValueComputationParameters {
	ConstraintSystem getConstraintSystem();

	OPPLAbstractFactory getOPPLFactory();

	BindingNode getBindingNode();
}
