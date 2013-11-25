package org.coode.oppl.function;

import static org.coode.oppl.utils.ArgCheck.checkNotNull;

import org.coode.oppl.ConstraintSystem;
import org.coode.oppl.bindingtree.BindingNode;
import org.coode.oppl.exceptions.RuntimeExceptionHandler;

public class SimpleValueComputationParameters implements ValueComputationParameters {
    private final ConstraintSystem constraintSystem;
    private final BindingNode bindingNode;
    private final RuntimeExceptionHandler runtimeExceptionHandler;

    /** @param constraintSystem
     * @param bindingNode
     * @param runtimeExceptionHandler */
    public SimpleValueComputationParameters(ConstraintSystem constraintSystem,
            BindingNode bindingNode, RuntimeExceptionHandler runtimeExceptionHandler) {
        this.constraintSystem = checkNotNull(constraintSystem, "constraintSystem");
        this.bindingNode = checkNotNull(bindingNode, "bindingNode");
        this.runtimeExceptionHandler = checkNotNull(runtimeExceptionHandler,
                "runtimeExceptionHandler");
    }

    @Override
    public BindingNode getBindingNode() {
        return bindingNode;
    }

    @Override
    public ConstraintSystem getConstraintSystem() {
        return constraintSystem;
    }

    /** @return the runtimeExceptionHandler */
    @Override
    public RuntimeExceptionHandler getRuntimeExceptionHandler() {
        return runtimeExceptionHandler;
    }
}
