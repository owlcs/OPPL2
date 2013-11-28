package org.coode.oppl.lint.filtering.protege;

import org.coode.oppl.lint.OPPLLintParser;
import org.coode.oppl.lint.OPPLLintScript;
import org.coode.oppl.lint.filtering.Filter;
import org.coode.oppl.lint.protege.OPPLLintPlugin;
import org.coode.oppl.lint.protege.ProtegeParserFactory;
import org.coode.oppl.protege.ui.ShowMessageRuntimeExceptionHandler;
import org.eclipse.core.runtime.IExtension;
import org.protege.editor.core.plugin.ExtensionInstantiator;
import org.protege.editor.core.plugin.JPFUtil;
import org.protege.editor.core.plugin.PluginUtilities;
import org.protege.editor.core.plugin.ProtegePlugin;
import org.protege.editor.owl.OWLEditorKit;
import org.semanticweb.owlapi.model.OWLObject;
/** @author Luigi Iannone */
public final class FilteringOPPLLintPlugin implements
		ProtegePlugin<FilteringOPPLLintProtegePluginInstanceAdapter> {
	public static final String FILTER_OPPL_LINT_PLUGIN_TYPE_ID = "filteroppllint";
	private final IExtension extension;
	private final OWLEditorKit owlEditorKit;

	/**
	 * @param extension
	 * @param owlEditorKit
	 */
	public FilteringOPPLLintPlugin(IExtension extension, OWLEditorKit owlEditorKit) {
		if (extension == null) {
			throw new NullPointerException("The extension cannot be null");
		}
		if (owlEditorKit == null) {
			throw new NullPointerException("The OWL editor kit cannot be null");
		}
		this.extension = extension;
		this.owlEditorKit = owlEditorKit;
	}

	public String getId() {
		return this.extension.getUniqueIdentifier();
	}

	public String getDocumentation() {
		return JPFUtil.getDocumentation(this.extension);
	}

	public FilteringOPPLLintProtegePluginInstanceAdapter newInstance()
			throws ClassNotFoundException, IllegalAccessException, InstantiationException {
		ExtensionInstantiator<OPPLLintScript> instantiator = new ExtensionInstantiator<OPPLLintScript>(
				this.extension) {
			@Override
			public OPPLLintScript instantiate() throws ClassCastException, InstantiationException,
					IllegalAccessException, ClassNotFoundException {
				String script = PluginUtilities.getAttribute(
						FilteringOPPLLintPlugin.this.extension,
						"script");
				OPPLLintParser parser = ProtegeParserFactory.getInstance(
						FilteringOPPLLintPlugin.this.owlEditorKit).build(
						OPPLLintPlugin.ERROR_LISTENER);
				OPPLLintScript lint = parser.parse(script, new ShowMessageRuntimeExceptionHandler(
						FilteringOPPLLintPlugin.this.owlEditorKit.getOWLWorkspace()));
				return lint;
			}
		};
		ExtensionInstantiator<Filter<OWLObject>> filterInstantiator = new ExtensionInstantiator<Filter<OWLObject>>(
				this.extension) {
			@SuppressWarnings("unchecked")
			@Override
			public Filter<OWLObject> instantiate() throws ClassCastException,
					InstantiationException, IllegalAccessException, ClassNotFoundException {
				Object o = PluginUtilities.getInstance().getExtensionObject(
						FilteringOPPLLintPlugin.this.extension,
						"filter");
				return (Filter<OWLObject>) o;
			}
		};
		OPPLLintScript instantiated = instantiator.instantiate();
		FilteringOPPLLintProtegePluginInstanceAdapter toReturn = null;
		Filter<OWLObject> filter = filterInstantiator.instantiate();
		if (filter != null) {
			ProtegeFilter<OWLObject> protegeFilter = ProtegeFilter.buildProtegeFilter(
					this.owlEditorKit,
					filter,
					this.extension);
			toReturn = instantiated != null ? new FilteringOPPLLintProtegePluginInstanceAdapter(
					instantiated, protegeFilter, this.extension) : null;
		}
		return toReturn;
	}
}
