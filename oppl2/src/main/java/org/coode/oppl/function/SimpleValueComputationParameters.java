package org.coode.oppl.function;

import org.coode.oppl.ConstraintSystem;
import org.coode.oppl.bindingtree.BindingNode;
import org.coode.oppl.exceptions.RuntimeExceptionHandler;

public class SimpleValueComputationParameters implements ValueComputationParameters {
    private final ConstraintSystem constraintSystem;
    private final BindingNode bindingNode;
    private final RuntimeExceptionHandler runtimeExceptionHandler;

    /** @param constraintSystem
     * @param bindingNode
     * @param fact */
    public SimpleValueComputationParameters(ConstraintSystem constraintSystem,
            BindingNode bindingNode, RuntimeExceptionHandler runtimeExceptionHandler) {
        if (constraintSystem == null) {
            throw new NullPointerException("The constraint system cannot be null");
        }
        if (bindingNode == null) {
            throw new NullPointerException("The binding node cannot be null");
        }
        if (runtimeExceptionHandler == null) {
            throw new NullPointerException("The runtime exception handler cannot be null");
        }
        this.constraintSystem = constraintSystem;
        this.bindingNode = bindingNode;
        this.runtimeExceptionHandler = runtimeExceptionHandler;
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
