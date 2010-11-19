/**
 * 
 */
package org.coode.oppl.exceptions;

import java.util.regex.PatternSyntaxException;

import org.semanticweb.owlapi.model.OWLRuntimeException;

/**
 * This implementation simply re-throws the exception thrown or throws new
 * run-time ones to interrupt the exceution.
 * 
 * @author Luigi Iannone
 * 
 */
public class QuickFailRuntimeExceptionHandler implements RuntimeExceptionHandler {
	private void handleRuntimeException(RuntimeException e) {
		throw e;
	}

	/**
	 * @see org.coode.oppl.exceptions.RuntimeExceptionHandler#handleOWLRuntimeException
	 *      (org.semanticweb.owlapi.model.OWLRuntimeException)
	 */
	public void handleOWLRuntimeException(OWLRuntimeException e) {
		this.handleRuntimeException(e);
	}

	/**
	 * @see org.coode.oppl.exceptions.RuntimeExceptionHandler#
	 *      handlePatternSyntaxExcpetion(java.util.regex.PatternSyntaxException)
	 */
	public void handlePatternSyntaxExcpetion(PatternSyntaxException e) {
		this.handleRuntimeException(e);
	}

	public void handleException(RuntimeException e) {
		this.handleException(e);
	}
}
