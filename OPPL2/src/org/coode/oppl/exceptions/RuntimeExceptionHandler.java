package org.coode.oppl.exceptions;

import java.util.regex.PatternSyntaxException;

import org.semanticweb.owlapi.model.OWLRuntimeException;

/**
 * Handles run-time error raised during the execution of an OPPL Script
 * 
 * @author Luigi Iannone
 * 
 */
public interface RuntimeExceptionHandler {
	public void handleOWLRuntimeException(OWLRuntimeException e);

	public void handlePatternSyntaxExcpetion(PatternSyntaxException e);
}
