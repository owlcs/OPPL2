/**
 * 
 */
package org.coode.oppl.lint.filtering.protege;

import org.coode.lint.protege.loader.AbstractLintPluginLoader;
import org.eclipse.core.runtime.IExtension;
import org.protege.editor.core.plugin.PluginExtensionMatcher;
import org.protege.editor.owl.OWLEditorKit;

/**
 * @author Luigi Iannone
 * 
 */
public class FilteringOPPLLintPluginLoader extends
		AbstractLintPluginLoader<FilteringOPPLLintPlugin> {
	public FilteringOPPLLintPluginLoader(OWLEditorKit owlEditorKit) {
		super("uk.ac.manchester.cs.lintroll.oppl",
				FilteringOPPLLintPlugin.FILTER_OPPL_LINT_PLUGIN_TYPE_ID, owlEditorKit);
	}

	/**
	 * @see org.protege.editor.core.plugin.AbstractPluginLoader#getExtensionMatcher()
	 */
	@Override
	protected PluginExtensionMatcher getExtensionMatcher() {
		return new PluginExtensionMatcher() {
			/**
			 * Determines whether the specified <code>Extension</code>
			 * constitutes a "match" or not.
			 * 
			 * @param extension
			 *            The <code>Extension</code> to test.
			 * @return <code>true</code> if the <code>Extension</code> matches
			 *         or <code>false</code> if the <code>Extension</code> 
			 *         doesn't match.
			 */
			public boolean matches(IExtension extension) {
				return true;
			}
		};
	}

	/**
	 * @see org.protege.editor.core.plugin.AbstractPluginLoader#createInstance(org
	 *      .eclipse.core.runtime.IExtension)
	 */
	@Override
	protected FilteringOPPLLintPlugin createInstance(IExtension extension) {
		return new FilteringOPPLLintPlugin(extension, this.getOWLEditorKit());
	}
}
