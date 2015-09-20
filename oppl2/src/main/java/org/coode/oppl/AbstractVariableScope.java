package org.coode.oppl;

import static org.coode.oppl.utils.ArgCheck.checkNotNull;

import org.semanticweb.owlapi.model.OWLObject;

/**
 * @author Luigi Iannone
 * @param <O>
 *        type
 */
public abstract class AbstractVariableScope<O extends OWLObject> implements
    VariableScope<O> {

    private final VariableScopeChecker checker;

    /**
     * @param checker
     *        checker
     */
    public AbstractVariableScope(VariableScopeChecker checker) {
        this.checker = checkNotNull(checker, "The checker");
    }

    /**
     * @return the checker
     */
    public VariableScopeChecker getChecker() {
        return this.checker;
    }
}
