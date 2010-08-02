/**
 * 
 */
package org.coode.oppl.lint.filtering.protege;

import org.coode.lint.protege.loader.AbstractLintPluginLoader;
import org.coode.lint.protege.loader.extensions.LoaderFactory;
import org.protege.editor.owl.OWLEditorKit;

/**
 * @author Luigi Iannone
 * 
 */
public class FilteringOPPLLintLoaderFactory implements LoaderFactory<FilteringOPPLLintPlugin> {
	public AbstractLintPluginLoader<FilteringOPPLLintPlugin> createLintPluginLoader(
			OWLEditorKit owlEditorKit) {
		return new FilteringOPPLLintPluginLoader(owlEditorKit);
	}
}
