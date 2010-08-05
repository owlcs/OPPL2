package org.coode.oppl.lint.filtering.protege;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Properties;

import org.coode.lint.protege.LintProtegePluginInstance;
import org.coode.lint.protege.configuration.LintConfigurationInitializer;
import org.coode.oppl.lint.OPPLLintScript;
import org.coode.oppl.lint.filtering.Filter;
import org.coode.oppl.lint.filtering.FilteringOPPLLint;
import org.eclipse.core.runtime.IExtension;
import org.protege.editor.core.ProtegeApplication;
import org.protege.editor.core.plugin.PluginProperties;
import org.protege.editor.core.prefs.Preferences;
import org.protege.editor.core.prefs.PreferencesManager;
import org.semanticweb.owl.lint.Lint;
import org.semanticweb.owl.lint.configuration.LintConfiguration;
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

	@Override
	public String toString() {
		return this.delegate.toString();
	}

	public void dispose() throws Exception {
	}

	public void initialise() throws Exception {
	}

	public Lint<?> getOriginatingLint() {
		return this.delegate;
	}

	public LintConfigurationInitializer getLintConfigurationInitializer() {
		return new LintConfigurationInitializer() {
			public void initialise(LintConfiguration lintConfiguration) {
				Preferences lintPreferences = PreferencesManager.getInstance().getApplicationPreferences(
						FilteringOPPLLintProtegePluginInstanceAdapter.this.delegate.getLintConfiguration().getFilter().getOriginatingFilterClass());
				byte[] byteArray = lintPreferences.getByteArray("configuration", null);
				if (byteArray != null) {
					try {
						Properties properties = new Properties();
						properties.load(new ByteArrayInputStream(byteArray));
						Enumeration<?> keys = properties.propertyNames();
						while (keys.hasMoreElements()) {
							Object propertyName = keys.nextElement();
							String value = properties.getProperty(propertyName.toString());
							lintConfiguration.setProperty(propertyName.toString(), value);
						}
					} catch (IOException e) {
						ProtegeApplication.getErrorLog().logError(e);
					}
				}
			}
		};
	}
}
