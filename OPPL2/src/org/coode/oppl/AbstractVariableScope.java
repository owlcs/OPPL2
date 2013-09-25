package org.coode.oppl;

import org.semanticweb.owlapi.model.OWLObject;

public abstract class AbstractVariableScope<O extends OWLObject> implements
        VariableScope<O> {
    private final VariableScopeChecker checker;

    /** @param checker */
    public AbstractVariableScope(VariableScopeChecker checker) {
        if (checker == null) {
            throw new NullPointerException("The checker cannot be null");
        }
        this.checker = checker;
    }

    /** @return the checker */
    public VariableScopeChecker getChecker() {
        return this.checker;
    }
}
