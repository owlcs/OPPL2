/**
 * 
 */
package org.coode.parsers;

import org.semanticweb.owl.expression.OWLEntityChecker;

/**
 * @author Luigi Iannone
 * 
 */
public interface DisposableOWLEntityChecker extends OWLEntityChecker {
	/**
	 * Frees up the resources used by this DisposableOWLEntityChecker.
	 */
	public void dispose();
}
