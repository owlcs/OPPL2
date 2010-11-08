/**
 * 
 */
package org.coode.oppl.exceptions;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.PatternSyntaxException;

import org.semanticweb.owlapi.model.OWLRuntimeException;

/**
 * This implementation collects all the run-time exception raised.
 * 
 * @author Luigi Iannone
 * 
 */
public class CollectRuntimeExceptionHandler implements RuntimeExceptionHandler {
	private final Set<RuntimeException> exceptions = new HashSet<RuntimeException>();

	/**
	 * @see org.coode.oppl.exceptions.RuntimeExceptionHandler#handleOWLRuntimeException(org.semanticweb.owlapi.model.OWLRuntimeException)
	 */
	public void handleOWLRuntimeException(OWLRuntimeException e) {
		this.handleRuntimeException(e);
	}

	private void handleRuntimeException(RuntimeException e) {
		this.exceptions.add(e);
	}

	/**
	 * @see org.coode.oppl.exceptions.RuntimeExceptionHandler#handlePatternSyntaxExcpetion(java.util.regex.PatternSyntaxException)
	 */
	public void handlePatternSyntaxExcpetion(PatternSyntaxException e) {
		this.handleRuntimeException(e);
	}

	/**
	 * @return the exceptions
	 */
	public Set<RuntimeException> getExceptions() {
		return new HashSet<RuntimeException>(this.exceptions);
	}
}
