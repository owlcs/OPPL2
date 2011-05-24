package org.coode.parsers;

import org.semanticweb.owlapi.expression.OWLEntityChecker;
import org.semanticweb.owlapi.expression.ShortFormEntityChecker;
import org.semanticweb.owlapi.model.OWLAnnotationProperty;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLDataProperty;
import org.semanticweb.owlapi.model.OWLDatatype;
import org.semanticweb.owlapi.model.OWLNamedIndividual;
import org.semanticweb.owlapi.model.OWLObjectProperty;
import org.semanticweb.owlapi.util.SimpleShortFormProvider;

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
	 * @param shrotFormProviderAdaptor
	 */
	public DisposableShortFormEntityChecker(OWLEntityChecker owlEntityChecker) {
		if (owlEntityChecker == null) {
			throw new NullPointerException("The OWLEntity checker cannot be null");
		}
		this.delegate = owlEntityChecker;
		this.shrotFormProviderAdaptor = new BidirectionalShortFormProviderAdapter(
				new SimpleShortFormProvider());
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
	public OWLDatatype getOWLDatatype(String name) {
		return this.delegate.getOWLDatatype(name);
	}

	/**
	 * @param name
	 * @return
	 * @see org.semanticweb.owl.expression.OWLEntityChecker#getOWLIndividual(java.lang.String)
	 */
	public OWLNamedIndividual getOWLIndividual(String name) {
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

	public OWLAnnotationProperty getOWLAnnotationProperty(String name) {
		return this.delegate.getOWLAnnotationProperty(name);
	}

	public void dispose() {
		this.shrotFormProviderAdaptor.dispose();
	}
}
