/**
 * 
 */
package org.coode.oppl.lint.filtering;

import java.util.Collection;
import java.util.Formatter;
import java.util.Set;

import org.coode.oppl.OPPLScript;
import org.coode.oppl.Variable;
import org.coode.oppl.exceptions.OPPLException;
import org.coode.oppl.lint.OPPLLintScript;
import org.semanticweb.owlapi.model.OWLObject;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyManager;
import org.semanticweb.owlapi.lint.Lint;
import org.semanticweb.owlapi.lint.LintException;
import org.semanticweb.owlapi.lint.LintReport;
import org.semanticweb.owlapi.lint.LintVisitor;
import org.semanticweb.owlapi.lint.LintVisitorEx;
import org.semanticweb.owlapi.lint.configuration.LintConfiguration;

import uk.ac.manchester.cs.owl.lint.LintManagerFactory;

/**
 * @author Luigi Iannone
 * 
 */
public class FilteringOPPLLint implements Lint<OWLObject> {
	private final OPPLLintScript delegate;
	private final Filter<OWLObject> filter;

	/**
	 * @param delegate
	 * @param filter
	 */
	public FilteringOPPLLint(OPPLLintScript delegate, Filter<OWLObject> filter) {
		if (delegate == null) {
			throw new NullPointerException("The OPPL Lint cannot be null");
		}
		if (filter == null) {
			throw new NullPointerException("The filter cannot be null");
		}
		this.delegate = delegate;
		this.filter = filter;
	}

	/**
	 * @param visitor
	 * @see org.coode.oppl.lint.OPPLLintScript#accept(org.semanticweb.owlapi.lint.LintVisitor)
	 */
	public void accept(LintVisitor visitor) {
		this.getDelegate().accept(visitor);
	}

	/**
	 * @param <P>
	 * @param visitor
	 * @return
	 * @see org.coode.oppl.lint.OPPLLintScript#accept(org.semanticweb.owlapi.lint.LintVisitorEx)
	 */
	public <P> P accept(LintVisitorEx<P> visitor) {
		return this.getDelegate().accept(visitor);
	}

	/**
	 * @param variable
	 * @see org.coode.oppl.lint.OPPLLintScript#addVariable(org.coode.oppl.Variable)
	 */
	public void addVariable(Variable variable) {
		this.getDelegate().addVariable(variable);
	}

	/**
	 * @param targets
	 * @return
	 * @throws LintException
	 * @see org.coode.oppl.lint.OPPLLintScript#detected(java.util.Collection)
	 */
	public LintReport<OWLObject> detected(Collection<? extends OWLOntology> targets)
			throws LintException {
		LintReport<OWLObject> delegateDetected = this.getDelegate().detected(targets);
		LintReportFilter<OWLObject> lintReportFilter = new LintReportFilter<OWLObject>(
				this.getFilter(), LintManagerFactory.getInstance().getOntologyManager(),
				LintManagerFactory.getInstance().getReasoner(), this.getLintConfiguration());
		return lintReportFilter.filter(delegateDetected);
	}

	/**
	 * @return
	 * @see org.coode.oppl.lint.OPPLLintScript#getDescription()
	 */
	public String getDescription() {
		return this.getDelegate().getDescription();
	}

	/**
	 * @param ontology
	 * @param ontologyManager
	 * @return
	 * @throws OPPLException
	 * @see org.coode.oppl.lint.OPPLLintScript#getDetectedObjects(org.semanticweb.owl.model.OWLOntology,
	 *      org.semanticweb.owl.model.OWLOntologyManager)
	 */
	public Set<OWLObject> getDetectedObjects(OWLOntology ontology,
			OWLOntologyManager ontologyManager) throws OPPLException {
		return this.getDelegate().getDetectedObjects(ontology, ontologyManager);
	}

	/**
	 * @return
	 * @see org.coode.oppl.lint.OPPLLintScript#getExplanationTemplate()
	 */
	public String getExplanationTemplate() {
		return this.getDelegate().getExplanationTemplate();
	}

	/**
	 * @return
	 * @see org.coode.oppl.lint.OPPLLintScript#getName()
	 */
	public String getName() {
		return this.getDelegate().getName();
	}

	/**
	 * @return
	 * @see org.coode.oppl.lint.OPPLLintScript#getOntologyManager()
	 */
	public OWLOntologyManager getOntologyManager() {
		return this.getDelegate().getOntologyManager();
	}

	/**
	 * @return
	 * @see org.coode.oppl.lint.OPPLLintScript#getOPPLScript()
	 */
	public OPPLScript getOPPLScript() {
		return this.getDelegate().getOPPLScript();
	}

	/**
	 * @return
	 * @see org.coode.oppl.lint.OPPLLintScript#getReturnVariable()
	 */
	public Variable getReturnVariable() {
		return this.getDelegate().getReturnVariable();
	}

	/**
	 * @return
	 * @see org.coode.oppl.lint.OPPLLintScript#toString()
	 */
	@Override
	public String toString() {
		Formatter formatter = new Formatter();
		formatter.format(
				"Fiiltering OPPL Lint script: %s, filter: %s",
				this.getDelegate().toString(),
				this.getFilter().toString());
		return formatter.out().toString();
	}

	/**
	 * @return the delegate
	 */
	public OPPLLintScript getDelegate() {
		return this.delegate;
	}

	/**
	 * @return the filter
	 */
	public Filter<OWLObject> getFilter() {
		return this.filter;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (this.delegate == null ? 0 : this.delegate.hashCode());
		result = prime * result + (this.filter == null ? 0 : this.filter.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (this.getClass() != obj.getClass()) {
			return false;
		}
		FilteringOPPLLint other = (FilteringOPPLLint) obj;
		if (this.delegate == null) {
			if (other.delegate != null) {
				return false;
			}
		} else if (!this.delegate.equals(other.delegate)) {
			return false;
		}
		if (this.filter == null) {
			if (other.filter != null) {
				return false;
			}
		} else if (!this.filter.equals(other.filter)) {
			return false;
		}
		return true;
	}

	public LintConfiguration getLintConfiguration() {
		return this.delegate.getLintConfiguration();
	}

	public boolean isInferenceRequired() {
		return this.delegate.isInferenceRequired();
	}
}
