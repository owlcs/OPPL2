/**
 * 
 */
package org.coode.oppl.lint.filtering;

import org.semanticweb.owl.model.OWLObject;

/**
 * @author Luigi Iannone
 * 
 */
public interface Filter<O extends OWLObject> {
	/**
	 * Accepts or rejects an input object
	 * 
	 * @param owlObject
	 *            The input object to filter.
	 * @return {@code true} when the input owlObject is acceptable for this
	 *         Filter.
	 * @throws NullPointerException
	 *             if the input is {@code null}.
	 */
	boolean accept(O owlObject);
}
