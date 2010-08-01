package org.coode.oppl.lint.protege;

import org.coode.lint.protege.loader.AbstractLintPluginLoader;
import org.eclipse.core.runtime.IExtension;
import org.protege.editor.core.plugin.PluginExtensionMatcher;
import org.protege.editor.owl.OWLEditorKit;

/**
 * Author: Matthew Horridge<br>
 * The University Of Manchester<br>
 * Medical Informatics Group<br>
 * Date: 19-May-2006<br>
 * <br>
 * <p/>
 * matthew.horridge@cs.man.ac.uk<br>
 * www.cs.man.ac.uk/~horridgm<br>
 * <br>
 */
public final class ProtegeOPPLLintPluginLoader extends
		AbstractLintPluginLoader<OPPLLintPlugin> {
	public ProtegeOPPLLintPluginLoader(OWLEditorKit owlEditorKit) {
		super("uk.ac.manchester.cs.lintroll.oppl",
				OPPLLintPlugin.LINT_PLUGIN_TYPE_ID, owlEditorKit);
	}

	/**
	 * This method needs to be overridden to create an instance of the desired
	 * plugin, based on the plugin <code>Extension</code>
	 * 
	 * @param extension
	 *            The <code>Extension</code> that describes the Java Plugin
	 *            Framework extension.
	 * @return A plugin object (typically some sort of wrapper around the
	 *         extension)
	 */
	@Override
	protected OPPLLintPlugin createInstance(IExtension extension) {
		return new OPPLLintPlugin(extension, this.getOWLEditorKit());
	}

	/**
	 * This method needs to be overriden to provide a
	 * <code>PluginExtensionMatcher</code>, which is used to filter the plugin
	 * extensions to a desired subset.
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
}
