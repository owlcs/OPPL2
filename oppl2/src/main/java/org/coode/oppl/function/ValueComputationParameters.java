package org.coode.oppl.function;

import org.coode.oppl.ConstraintSystem;
import org.coode.oppl.bindingtree.BindingNode;
import org.coode.oppl.exceptions.RuntimeExceptionHandler;

/** @author Luigi Iannone */
public interface ValueComputationParameters {
    /** @return constraint system */
    ConstraintSystem getConstraintSystem();

    /** @return binding node */
    BindingNode getBindingNode();

    /** @return exception handler */
    RuntimeExceptionHandler getRuntimeExceptionHandler();
}
