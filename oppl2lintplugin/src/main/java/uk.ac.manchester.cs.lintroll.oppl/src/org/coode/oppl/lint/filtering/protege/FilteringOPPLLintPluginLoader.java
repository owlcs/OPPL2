
package org.coode.oppl.lint.filtering.protege;

import java.util.EnumSet;

import org.coode.lint.protege.loader.AbstractLintPluginLoader;
import org.coode.oppl.protege.ProtegeParserFactory;
import org.eclipse.core.runtime.IExtension;
import org.protege.editor.core.plugin.PluginExtensionMatcher;
import org.protege.editor.owl.OWLEditorKit;
import org.protege.editor.owl.model.event.EventType;

/**
 * @author Luigi Iannone
 * 
 */
public class FilteringOPPLLintPluginLoader
		extends
		AbstractLintPluginLoader<FilteringOPPLLintPlugin, FilteringOPPLLintProtegePluginInstanceAdapter> {
	public FilteringOPPLLintPluginLoader(OWLEditorKit owlEditorKit) {
		super("uk.ac.manchester.cs.lintroll.oppl",
				FilteringOPPLLintPlugin.FILTER_OPPL_LINT_PLUGIN_TYPE_ID, owlEditorKit);
	}

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

	@Override
	protected FilteringOPPLLintPlugin createInstance(IExtension extension) {
		return new FilteringOPPLLintPlugin(extension, this.getOWLEditorKit());
	}

	@Override
	public EnumSet<EventType> getRelevantEventTypes() {
		return EnumSet.of(
				EventType.ACTIVE_ONTOLOGY_CHANGED,
				EventType.ONTOLOGY_RELOADED,
				EventType.REASONER_CHANGED,
				EventType.ABOUT_TO_CLASSIFY,
				EventType.ONTOLOGY_CLASSIFIED,
				EventType.ENTITY_RENDERER_CHANGED);
	}

	@Override
	public void dispose() {
		ProtegeParserFactory.getInstance(this.getOWLEditorKit()).dispose();
	}
}
