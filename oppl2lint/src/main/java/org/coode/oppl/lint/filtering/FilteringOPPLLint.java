/**
 * 
 */
package org.coode.oppl.lint.filtering;

import java.util.Collection;

import java.util.Set;

import org.coode.oppl.OPPLScript;
import org.coode.oppl.Variable;
import org.coode.oppl.exceptions.OPPLException;
import org.coode.oppl.lint.OPPLLintScript;
import org.semanticweb.owlapi.lint.Lint;
import org.semanticweb.owlapi.lint.LintException;
import org.semanticweb.owlapi.lint.LintReport;
import org.semanticweb.owlapi.lint.LintVisitor;
import org.semanticweb.owlapi.lint.LintVisitorEx;
import org.semanticweb.owlapi.lint.configuration.LintConfiguration;
import org.semanticweb.owlapi.model.OWLObject;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyManager;

import uk.ac.manchester.cs.owl.lint.LintManagerFactory;

/** @author Luigi Iannone */
public class FilteringOPPLLint implements Lint<OWLObject> {
    private final OPPLLintScript delegate;
    private final Filter<OWLObject> filter;

    /** @param delegate
     * @param filter */
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

    /** @param visitor */
    public void accept(LintVisitor visitor) {
        this.getDelegate().accept(visitor);
    }

    /** @param <P>
     * @param visitor
     * @return */
    public <P> P accept(LintVisitorEx<P> visitor) {
        return this.getDelegate().accept(visitor);
    }

    /** @param targets
     * @return
     * @throws LintException */
    public LintReport<OWLObject> detected(Collection<? extends OWLOntology> targets)
            throws LintException {
        LintReport<OWLObject> delegateDetected = this.getDelegate().detected(targets);
        LintReportFilter<OWLObject> lintReportFilter = new LintReportFilter<OWLObject>(
                this.getFilter(), LintManagerFactory.getInstance().getOntologyManager(),
                LintManagerFactory.getInstance().getReasoner(),
                this.getLintConfiguration());
        return lintReportFilter.filter(delegateDetected);
    }

    /** @return */
    public String getDescription() {
        return this.getDelegate().getDescription();
    }

    /** @param ontology
     * @param ontologyManager
     * @return
     * @throws OPPLException */
    public Set<OWLObject> getDetectedObjects(OWLOntology ontology,
            OWLOntologyManager ontologyManager) throws OPPLException {
        return this.getDelegate().getDetectedObjects(ontology, ontologyManager);
    }

    /** @return */
    public String getExplanationTemplate() {
        return this.getDelegate().getExplanationTemplate();
    }

    /** @return */
    public String getName() {
        return this.getDelegate().getName();
    }

    /** @return */
    public OWLOntologyManager getOntologyManager() {
        return this.getDelegate().getOntologyManager();
    }

    /** @return */
    public OPPLScript getOPPLScript() {
        return this.getDelegate().getOPPLScript();
    }

    /** @return */
    public Variable<?> getReturnVariable() {
        return this.getDelegate().getReturnVariable();
    }

    /** @return */
    @Override
    public String toString() {
        return String.format("Fiiltering OPPL Lint script: %s, filter: %s",
                getDelegate(), getFilter());
    }

    /** @return the delegate */
    public OPPLLintScript getDelegate() {
        return this.delegate;
    }

    /** @return the filter */
    public Filter<OWLObject> getFilter() {
        return this.filter;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (this.delegate == null ? 0 : this.delegate.hashCode());
        result = prime * result + (this.filter == null ? 0 : this.filter.hashCode());
        return result;
    }

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
