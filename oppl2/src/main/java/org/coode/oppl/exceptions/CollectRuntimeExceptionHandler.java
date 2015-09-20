package org.coode.oppl.exceptions;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.PatternSyntaxException;

import org.semanticweb.owlapi.model.OWLRuntimeException;

/**
 * This implementation collects all the run-time exception raised.
 * 
 * @author Luigi Iannone
 */
public class CollectRuntimeExceptionHandler implements RuntimeExceptionHandler {

    private final Set<RuntimeException> exceptions = new HashSet<>();

    @Override
    public void handleOWLRuntimeException(OWLRuntimeException e) {
        handleRuntimeException(e);
    }

    private void handleRuntimeException(RuntimeException e) {
        exceptions.add(e);
    }

    @Override
    public void handlePatternSyntaxExcpetion(PatternSyntaxException e) {
        handleRuntimeException(e);
    }

    @Override
    public void handleException(RuntimeException e) {
        handleRuntimeException(e);
    }

    /**
     * @return the exceptions
     */
    public Set<RuntimeException> getExceptions() {
        return new HashSet<>(exceptions);
    }
}
