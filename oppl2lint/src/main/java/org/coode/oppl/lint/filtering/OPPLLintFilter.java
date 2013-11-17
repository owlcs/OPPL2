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
public final class OPPLLintFilter implements Filter<OWLObject> {
	private final Filter<OWLObject> delegate;
	private final FilteringOPPLLint lint;

	public OPPLLintFilter(FilteringOPPLLint lint, Filter<OWLObject> delegate) {
		if (lint == null) {
			throw new NullPointerException("The lint cannot be null");
		}
		if (delegate == null) {
			throw new NullPointerException("The filter cannot be null");
		}
		this.delegate = delegate;
		this.lint = lint;
	}

	/**
	 * @param owlObject
	 * @return
	 */
	public boolean accept(OWLObject owlObject,
			OWLOntologyManager ontologyManager, OWLReasoner reasoner,
			LintConfiguration lintConfiguration) {
		return this.delegate.accept(owlObject, ontologyManager, reasoner,
				this.lint.getLintConfiguration());
	}
}
