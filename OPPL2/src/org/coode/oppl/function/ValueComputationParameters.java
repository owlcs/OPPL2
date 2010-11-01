package org.coode.oppl.function;

import org.coode.oppl.ConstraintSystem;
import org.coode.oppl.bindingtree.BindingNode;

public interface ValueComputationParameters {
	ConstraintSystem getConstraintSystem();

	BindingNode getBindingNode();
}
