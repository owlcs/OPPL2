package org.coode.oppl.exceptions;

import java.util.regex.PatternSyntaxException;

import org.semanticweb.owlapi.model.OWLRuntimeException;

/**
 * This implementation simply re-throws the exception thrown or throws new run-time ones to
 * interrupt the exceution.
 * 
 * @author Luigi Iannone
 */
public class QuickFailRuntimeExceptionHandler implements RuntimeExceptionHandler {

    private static void handleRuntimeException(RuntimeException e) {
        throw e;
    }

    @Override
    public void handleOWLRuntimeException(OWLRuntimeException e) {
        handleRuntimeException(e);
    }

    @Override
    public void handlePatternSyntaxExcpetion(PatternSyntaxException e) {
        handleRuntimeException(e);
    }

    @Override
    public void handleException(RuntimeException e) {
        handleRuntimeException(e);
    }
}
