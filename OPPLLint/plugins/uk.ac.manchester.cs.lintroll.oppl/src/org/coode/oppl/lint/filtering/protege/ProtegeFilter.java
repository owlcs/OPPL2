package org.coode.oppl.lint.filtering.protege;

import org.coode.oppl.lint.filtering.Filter;
import org.protege.editor.owl.OWLEditorKit;
import org.semanticweb.owl.inference.OWLReasoner;
import org.semanticweb.owl.model.OWLObject;
import org.semanticweb.owl.model.OWLOntologyManager;

public class ProtegeFilter<O extends OWLObject> implements Filter<O> {
	private final OWLEditorKit owlEditorKit;
	private final Filter<O> delegate;

	/**
	 * @param owlEditorKit
	 */
	private ProtegeFilter(OWLEditorKit owlEditorKit, Filter<O> delegate) {
		if (delegate == null) {
			throw new NullPointerException("The delegate cannot be null");
		}
		if (owlEditorKit == null) {
			throw new NullPointerException("The OWL Editor Kit cannot be null");
		}
		this.owlEditorKit = owlEditorKit;
		this.delegate = delegate;
	}

	/**
	 * @return the owlEditorKit
	 */
	public OWLEditorKit getOWLEditorKit() {
		return this.owlEditorKit;
	}

	/**
	 * @param owlObject
	 * @return
	 * @see org.coode.oppl.lint.filtering.Filter#accept(org.semanticweb.owl.model.OWLObject)
	 */
	public boolean accept(O owlObject) {
		return this.getDelegate().accept(owlObject);
	}

	/**
	 * @return the delegate
	 */
	public Filter<O> getDelegate() {
		return this.delegate;
	}

	public OWLOntologyManager getOntologyManager() {
		return this.getOWLEditorKit().getOWLModelManager().getOWLOntologyManager();
	}

	public OWLReasoner getOWLReasoner() {
		return this.getOWLEditorKit().getOWLModelManager().getReasoner();
	}

	public static <P extends OWLObject> ProtegeFilter<P> buildProtegeFilter(
			OWLEditorKit owlEditorKit, Filter<P> delegate) {
		if (delegate == null) {
			throw new NullPointerException("The delegate cannot be null");
		}
		if (owlEditorKit == null) {
			throw new NullPointerException("The OWL Editor Kit cannot be null");
		}
		return new ProtegeFilter<P>(owlEditorKit, delegate);
	}
}
