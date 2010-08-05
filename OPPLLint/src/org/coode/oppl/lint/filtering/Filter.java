/**
 * 
 */
package org.coode.oppl.lint.filtering;

import org.semanticweb.owl.inference.OWLReasoner;
import org.semanticweb.owl.lint.configuration.LintConfiguration;
import org.semanticweb.owl.model.OWLObject;
import org.semanticweb.owl.model.OWLOntologyManager;

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
	public boolean accept(O owlObject);

	/**
	 * @return The OWLOntologyManager used by this Filter.
	 */
	public OWLOntologyManager getOntologyManager();

	/**
	 * Retrieve the OWLReasoner used by this Filter. Please Notice this <b>may
	 * be</b> {@code null}.
	 * 
	 * @return The OWLReasoner used by this Filter.
	 */
	public OWLReasoner getOWLReasoner();

	/**
	 * Provides the LintConfiguration which will beused for all the Lint checks
	 * that make use of this filter.
	 * 
	 * @return
	 */
	public LintConfiguration getLintConfiguration();

	Class<?> getOriginatingFilterClass();
}
