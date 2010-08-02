package org.coode.oppl.lint.filtering.protege;

import org.coode.lint.protege.LintProtegePluginInstance;
import org.coode.oppl.lint.OPPLLintScript;
import org.coode.oppl.lint.filtering.Filter;
import org.coode.oppl.lint.filtering.FilteringOPPLLint;
import org.eclipse.core.runtime.IExtension;
import org.protege.editor.core.plugin.PluginProperties;
import org.semanticweb.owl.model.OWLObject;

public final class FilteringOPPLLintProtegePluginInstanceAdapter extends FilteringOPPLLint
		implements LintProtegePluginInstance<OWLObject> {
	private static final String NAME_PARAM = "label";
	private final FilteringOPPLLint delegate;
	private final IExtension extension;

	/**
	 * @param delegate
	 */
	public FilteringOPPLLintProtegePluginInstanceAdapter(OPPLLintScript lint,
			Filter<OWLObject> filter, IExtension extension) {
		super(lint, filter);
		if (extension == null) {
			throw new NullPointerException("The extension cannot be null");
		}
		this.delegate = new FilteringOPPLLint(lint, filter);
		this.extension = extension;
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

	public void dispose() throws Exception {
	}

	public void initialise() throws Exception {
	}
}
