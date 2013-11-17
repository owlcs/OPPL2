package org.coode.oppl.function;

import org.coode.oppl.ConstraintSystem;
import org.coode.oppl.bindingtree.BindingNode;
import org.coode.oppl.exceptions.RuntimeExceptionHandler;

public interface ValueComputationParameters {
    ConstraintSystem getConstraintSystem();

    BindingNode getBindingNode();

    RuntimeExceptionHandler getRuntimeExceptionHandler();
}
