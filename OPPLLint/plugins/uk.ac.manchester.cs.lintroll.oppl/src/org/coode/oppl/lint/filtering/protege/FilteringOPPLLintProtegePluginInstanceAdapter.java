package org.coode.oppl.lint.filtering.protege;

import java.util.Collection;
import java.util.Formatter;

import org.coode.lint.protege.LintProtegePluginInstance;
import org.coode.oppl.lint.OPPLLintScript;
import org.coode.oppl.lint.filtering.FilteringOPPLLint;
import org.eclipse.core.runtime.IExtension;
import org.protege.editor.core.plugin.PluginProperties;
import org.semanticweb.owl.lint.LintException;
import org.semanticweb.owl.lint.LintReport;
import org.semanticweb.owl.lint.configuration.LintConfiguration;
import org.semanticweb.owl.model.OWLObject;
import org.semanticweb.owl.model.OWLOntology;

import uk.ac.manchester.cs.owl.lint.commons.SimpleMatchBasedLintReport;

public final class FilteringOPPLLintProtegePluginInstanceAdapter extends FilteringOPPLLint
		implements LintProtegePluginInstance<OWLObject> {
	private static final String NAME_PARAM = "label";
	private final FilteringOPPLLint delegate;
	private final IExtension extension;
	private final LintConfiguration lintConfiguration;

	/**
	 * @param delegate
	 */
	public FilteringOPPLLintProtegePluginInstanceAdapter(OPPLLintScript lint,
			ProtegeFilter<OWLObject> filter, IExtension extension) {
		super(lint, filter);
		if (extension == null) {
			throw new NullPointerException("The extension cannot be null");
		}
		this.delegate = new FilteringOPPLLint(lint, filter);
		this.extension = extension;
		this.lintConfiguration = filter.getInitialLintConfiguration();
	}

	/**
	 * @return
	 * @see org.semanticweb.owl.lint.Lint#getName()
	 */
	@Override
	public String getName() {
		return PluginProperties.getParameterValue(
				this.extension,
				NAME_PARAM,
				this.delegate.getName());
	}

	@Override
	public LintReport<OWLObject> detected(Collection<? extends OWLOntology> targets)
			throws LintException {
		LintReport<OWLObject> detected = super.detected(targets);
		SimpleMatchBasedLintReport<OWLObject> toReturn = new SimpleMatchBasedLintReport<OWLObject>(
				this, detected);
		return toReturn;
	}

	@Override
	public String toString() {
		return this.delegate.toString();
	}

	public void dispose() throws Exception {
	}

	public void initialise() throws Exception {
	}

	public String getId() {
		Formatter formatter = new Formatter();
		formatter.format("filteroppllint.%s", this.extension.getSimpleIdentifier());
		String string = formatter.out().toString();
		return string;
	}

	@Override
	public LintConfiguration getLintConfiguration() {
		return this.lintConfiguration;
	}
}
