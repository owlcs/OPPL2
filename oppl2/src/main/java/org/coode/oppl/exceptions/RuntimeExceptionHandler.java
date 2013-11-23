package org.coode.oppl.exceptions;

import java.util.regex.PatternSyntaxException;

import org.semanticweb.owlapi.model.OWLRuntimeException;

/** Handles run-time error raised during the execution of an OPPL Script
 * 
 * @author Luigi Iannone */
public interface RuntimeExceptionHandler {
    void handleOWLRuntimeException(OWLRuntimeException e);

    void handlePatternSyntaxExcpetion(PatternSyntaxException e);

    void handleException(RuntimeException e);
}
