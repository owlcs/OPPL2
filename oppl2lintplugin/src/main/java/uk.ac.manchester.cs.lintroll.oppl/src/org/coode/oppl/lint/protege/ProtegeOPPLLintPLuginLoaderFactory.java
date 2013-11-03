/**
 * 
 */
package org.coode.oppl.lint.protege;

import org.coode.lint.protege.LintProtegePluginInstanceAdapter;
import org.coode.lint.protege.loader.AbstractLintPluginLoader;
import org.coode.lint.protege.loader.extensions.LoaderFactory;
import org.protege.editor.owl.OWLEditorKit;
import org.semanticweb.owlapi.model.OWLObject;

/**
 * @author Luigi Iannone
 * 
 */
public class ProtegeOPPLLintPLuginLoaderFactory implements
		LoaderFactory<OPPLLintPlugin, LintProtegePluginInstanceAdapter<OWLObject>> {
	public AbstractLintPluginLoader<OPPLLintPlugin, LintProtegePluginInstanceAdapter<OWLObject>> createLintPluginLoader(
			OWLEditorKit owlEditorKit) {
		return new ProtegeOPPLLintPluginLoader(owlEditorKit);
	}
}
