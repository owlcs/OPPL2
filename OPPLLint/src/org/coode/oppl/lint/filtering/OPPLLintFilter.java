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
	 * @see org.coode.oppl.lint.filtering.Filter#accept(org.semanticweb.owl.model.OWLObject)
	 */
	public boolean accept(OWLObject owlObject) {
		return this.delegate.accept(owlObject);
	}

	/**
	 * @return
	 * @see org.coode.oppl.lint.filtering.Filter#getOntologyManager()
	 */
	public OWLOntologyManager getOntologyManager() {
		return this.delegate.getOntologyManager();
	}

	/**
	 * @return
	 * @see org.coode.oppl.lint.filtering.Filter#getOWLReasoner()
	 */
	public OWLReasoner getOWLReasoner() {
		return this.delegate.getOWLReasoner();
	}

	public LintConfiguration getLintConfiguration() {
		return this.lint.getLintConfiguration();
	}

	public Class<?> getOriginatingFilterClass() {
		return this.delegate.getOriginatingFilterClass();
	}
}
