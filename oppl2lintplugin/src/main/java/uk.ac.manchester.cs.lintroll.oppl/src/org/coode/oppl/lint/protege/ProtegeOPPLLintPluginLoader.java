package org.coode.oppl.lint.protege;

import java.util.EnumSet;

import org.coode.lint.protege.LintProtegePluginInstanceAdapter;
import org.coode.lint.protege.loader.AbstractLintPluginLoader;
import org.eclipse.core.runtime.IExtension;
import org.protege.editor.core.plugin.PluginExtensionMatcher;
import org.protege.editor.owl.OWLEditorKit;
import org.protege.editor.owl.model.event.EventType;
import org.semanticweb.owlapi.model.OWLObject;

/**
 * Author: Matthew Horridge<br>
 * The University Of Manchester<br>
 * Medical Informatics Group<br>
 * Date: 19-May-2006<br>
 * <br>
 * <br>
 * matthew.horridge@cs.man.ac.uk<br>
 * www.cs.man.ac.uk/~horridgm<br>
 * <br>
 */
public final class ProtegeOPPLLintPluginLoader extends
		AbstractLintPluginLoader<OPPLLintPlugin, LintProtegePluginInstanceAdapter<OWLObject>> {
	public ProtegeOPPLLintPluginLoader(OWLEditorKit owlEditorKit) {
		super("uk.ac.manchester.cs.lintroll.oppl", OPPLLintPlugin.LINT_PLUGIN_TYPE_ID, owlEditorKit);
	}

	/**
	 * This method needs to be overridden to create an instance of the desired
	 * plugin, based on the plugin {@code Extension}
	 * 
	 * @param extension
	 *            The {@code Extension} that describes the Java Plugin
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
	 * {@code PluginExtensionMatcher}, which is used to filter the plugin
	 * extensions to a desired subset.
	 */
	@Override
	protected PluginExtensionMatcher getExtensionMatcher() {
		return new PluginExtensionMatcher() {
			/**
			 * Determines whether the specified {@code Extension}
			 * constitutes a "match" or not.
			 * 
			 * @param extension
			 *            The {@code Extension} to test.
			 * @return {@code true} if the {@code Extension} matches
			 *         or {@code false} if the {@code Extension} 
			 *         doesn't match.
			 */
			public boolean matches(IExtension extension) {
				return true;
			}
		};
	}

	@Override
	public EnumSet<EventType> getRelevantEventTypes() {
		return EnumSet.of(
				EventType.ACTIVE_ONTOLOGY_CHANGED,
				EventType.ONTOLOGY_RELOADED,
				EventType.REASONER_CHANGED,
				EventType.ENTITY_RENDERER_CHANGED);
	}
}
