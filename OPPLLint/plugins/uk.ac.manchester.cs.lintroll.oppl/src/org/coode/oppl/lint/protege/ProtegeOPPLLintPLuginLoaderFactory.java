/**
 * 
 */
package org.coode.oppl.lint.protege;

import org.coode.lint.protege.loader.AbstractLintPluginLoader;
import org.coode.lint.protege.loader.extensions.LoaderFactory;
import org.protege.editor.owl.OWLEditorKit;

/**
 * @author Luigi Iannone
 * 
 */
public class ProtegeOPPLLintPLuginLoaderFactory implements
		LoaderFactory<OPPLLintPlugin> {
	public AbstractLintPluginLoader<OPPLLintPlugin> createLintPluginLoader(
			OWLEditorKit owlEditorKit) {
		return new ProtegeOPPLLintPluginLoader(owlEditorKit);
	}
}
