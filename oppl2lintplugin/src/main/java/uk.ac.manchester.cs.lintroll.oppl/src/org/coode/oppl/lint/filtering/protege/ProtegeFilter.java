package org.coode.oppl.lint.filtering.protege;

import org.coode.oppl.lint.filtering.Filter;
import org.eclipse.core.runtime.IExtension;
import org.protege.editor.owl.OWLEditorKit;
import org.protege.editor.owl.model.inference.NoOpReasoner;
import org.semanticweb.owlapi.lint.configuration.ConfigurationStrategy;
import org.semanticweb.owlapi.lint.configuration.LintConfiguration;
import org.semanticweb.owlapi.model.OWLObject;
import org.semanticweb.owlapi.model.OWLOntologyManager;
import org.semanticweb.owlapi.reasoner.OWLReasoner;
/** @author Luigi Iannone */
public class ProtegeFilter<O extends OWLObject> implements Filter<O> {
	private final OWLEditorKit owlEditorKit;
	private final Filter<O> delegate;
	private final LintConfiguration initialLintConfiguration;

	/**
	 * @param owlEditorKit
	 */
	private ProtegeFilter(OWLEditorKit owlEditorKit, Filter<O> delegate,
			IExtension extension) {
		if (delegate == null) {
			throw new NullPointerException("The delegate cannot be null");
		}
		if (owlEditorKit == null) {
			throw new NullPointerException("The OWL Editor Kit cannot be null");
		}
		this.owlEditorKit = owlEditorKit;
		this.delegate = delegate;
		this.initialLintConfiguration = ConfigurationStrategy
				.getLintConfiguration(delegate.getClass());
	}

	/**
	 * @return the owlEditorKit
	 */
	public OWLEditorKit getOWLEditorKit() {
		return this.owlEditorKit;
	}

	public boolean accept(O owlObject, OWLOntologyManager ontologyManager,
			OWLReasoner reasoner, LintConfiguration lintConfiguration) {
		return this.getDelegate().accept(
				owlObject,
				this.getOWLEditorKit().getOWLModelManager()
						.getOWLOntologyManager(), this.getOWLReasoner(),
				lintConfiguration);
	}

	/**
	 * @return the delegate
	 */
	public Filter<O> getDelegate() {
		return this.delegate;
	}

	public OWLReasoner getOWLReasoner() {
		return this.getOWLEditorKit().getOWLModelManager().getReasoner() instanceof NoOpReasoner ? null
				: this.getOWLEditorKit().getOWLModelManager().getReasoner();
	}

	public static <P extends OWLObject> ProtegeFilter<P> buildProtegeFilter(
			OWLEditorKit owlEditorKit, Filter<P> delegate, IExtension extension) {
		if (delegate == null) {
			throw new NullPointerException("The delegate cannot be null");
		}
		if (owlEditorKit == null) {
			throw new NullPointerException("The OWL Editor Kit cannot be null");
		}
		return new ProtegeFilter<P>(owlEditorKit, delegate, extension);
	}

	/**
	 * @return the initialLintConfiguration
	 */
	public LintConfiguration getInitialLintConfiguration() {
		return this.initialLintConfiguration;
	}
}
