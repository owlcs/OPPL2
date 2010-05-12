package org.coode.parsers;

import org.semanticweb.owl.expression.OWLEntityChecker;
import org.semanticweb.owl.expression.ShortFormEntityChecker;
import org.semanticweb.owl.model.OWLClass;
import org.semanticweb.owl.model.OWLDataProperty;
import org.semanticweb.owl.model.OWLDataType;
import org.semanticweb.owl.model.OWLIndividual;
import org.semanticweb.owl.model.OWLObjectProperty;

public class DisposableShortFormEntityChecker implements DisposableOWLEntityChecker {
	private final BidirectionalShortFormProviderAdapter shrotFormProviderAdaptor;
	private final OWLEntityChecker delegate;

	/**
	 * @param shrotFormProviderAdaptor
	 */
	public DisposableShortFormEntityChecker(
			BidirectionalShortFormProviderAdapter shrotFormProviderAdaptor) {
		this.shrotFormProviderAdaptor = shrotFormProviderAdaptor;
		this.delegate = new ShortFormEntityChecker(shrotFormProviderAdaptor);
	}

	/**
	 * @param name
	 * @return
	 * @see org.semanticweb.owl.expression.OWLEntityChecker#getOWLClass(java.lang.String)
	 */
	public OWLClass getOWLClass(String name) {
		return this.delegate.getOWLClass(name);
	}

	/**
	 * @param name
	 * @return
	 * @see org.semanticweb.owl.expression.OWLEntityChecker#getOWLDataProperty(java.lang.String)
	 */
	public OWLDataProperty getOWLDataProperty(String name) {
		return this.delegate.getOWLDataProperty(name);
	}

	/**
	 * @param name
	 * @return
	 * @see org.semanticweb.owl.expression.OWLEntityChecker#getOWLDataType(java.lang.String)
	 */
	public OWLDataType getOWLDataType(String name) {
		return this.delegate.getOWLDataType(name);
	}

	/**
	 * @param name
	 * @return
	 * @see org.semanticweb.owl.expression.OWLEntityChecker#getOWLIndividual(java.lang.String)
	 */
	public OWLIndividual getOWLIndividual(String name) {
		return this.delegate.getOWLIndividual(name);
	}

	/**
	 * @param name
	 * @return
	 * @see org.semanticweb.owl.expression.OWLEntityChecker#getOWLObjectProperty(java.lang.String)
	 */
	public OWLObjectProperty getOWLObjectProperty(String name) {
		return this.delegate.getOWLObjectProperty(name);
	}

	public void dispose() {
		this.shrotFormProviderAdaptor.dispose();
	}
}
