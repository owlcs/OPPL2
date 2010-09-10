/**
 * 
 */
package org.coode.oppl.lint.filtering;

import org.semanticweb.owlapi.lint.configuration.LintConfiguration;
import org.semanticweb.owlapi.model.OWLObject;
import org.semanticweb.owlapi.model.OWLOntologyManager;
import org.semanticweb.owlapi.reasoner.OWLReasoner;

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
	 * @param ontologyManager
	 *            The ontology manager. Cannot be {@code null}.
	 * @param reasoner
	 *            The OWLReasoner.
	 * @return {@code true} when the input owlObject is acceptable for this
	 *         Filter.
	 * @throws NullPointerException
	 *             if any input is {@code null} except for the reasoner.
	 */
	public boolean accept(O owlObject, OWLOntologyManager ontologyManager,
			OWLReasoner reasoner, LintConfiguration lintConfiguration);
}
