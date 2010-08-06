/**
 * 
 */
package org.coode.oppl.lint.filtering;

import org.semanticweb.owl.lint.LintReport;
import org.semanticweb.owl.lint.configuration.LintConfiguration;
import org.semanticweb.owl.model.OWLObject;
import org.semanticweb.owl.model.OWLOntology;

import uk.ac.manchester.cs.owl.lint.commons.SimpleMatchBasedLintReport;

/**
 * @author Luigi Iannone
 * 
 */
public final class LintReportFilter<O extends OWLObject> {
	private final Filter<O> filter;
	private final LintConfiguration lintConfiguration;

	/**
	 * @param filter
	 */
	public LintReportFilter(Filter<O> filter,
			LintConfiguration lintConfiguration) {
		if (filter == null) {
			throw new NullPointerException("The filter cannot be null");
		}
		if (lintConfiguration == null) {
			throw new NullPointerException(
					"The Lint configuration cannot be null");
		}
		this.filter = filter;
		this.lintConfiguration = lintConfiguration;
	}

	/**
	 * @return the filter
	 */
	public Filter<O> getFilter() {
		return this.filter;
	}

	/**
	 * Creates a new LintReport<O> filtering out all those afftected objects in
	 * the input LintReport<O> that are not accepted by the filter of this
	 * class.
	 * 
	 * @param report
	 *            The report whose affected objects will be filtered. Cannot be
	 *            {@code null}. It will not be modified in the process.
	 * @return a new LintReport<O>
	 * @throws NullPointerException
	 *             if the input is {@code null}.
	 */
	public LintReport<O> filter(LintReport<O> report) {
		SimpleMatchBasedLintReport<O> toReturn = new SimpleMatchBasedLintReport<O>(
				report.getLint());
		for (OWLOntology ontology : report.getAffectedOntologies()) {
			for (O owlObject : report.getAffectedOWLObjects(ontology)) {
				if (this.getFilter().accept(owlObject,
						this.getLintConfiguration())) {
					toReturn.add(owlObject, ontology, report.getExplanation(
							owlObject, ontology));
				}
			}
		}
		return toReturn;
	}

	/**
	 * @return the lintConfiguration
	 */
	public LintConfiguration getLintConfiguration() {
		return this.lintConfiguration;
	}
}
