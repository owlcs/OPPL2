package org.coode.parsers;

import org.coode.oppl.OPPLShortFormProvider;
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

    /** @param shrotFormProviderAdaptor */
    public DisposableShortFormEntityChecker(
            BidirectionalShortFormProviderAdapter shrotFormProviderAdaptor) {
        this.shrotFormProviderAdaptor = shrotFormProviderAdaptor;
        delegate = new ShortFormEntityChecker(shrotFormProviderAdaptor);
    }

    /** @param shrotFormProviderAdaptor */
    public DisposableShortFormEntityChecker(OWLEntityChecker owlEntityChecker) {
        if (owlEntityChecker == null) {
            throw new NullPointerException("The OWLEntity checker cannot be null");
        }
        delegate = owlEntityChecker;
        shrotFormProviderAdaptor = new BidirectionalShortFormProviderAdapter(
                new OPPLShortFormProvider(new SimpleShortFormProvider()));
    }

    @Override
    public OWLClass getOWLClass(String name) {
        return delegate.getOWLClass(name);
    }

    @Override
    public OWLDataProperty getOWLDataProperty(String name) {
        return delegate.getOWLDataProperty(name);
    }

    @Override
    public OWLDatatype getOWLDatatype(String name) {
        return delegate.getOWLDatatype(name);
    }

    @Override
    public OWLNamedIndividual getOWLIndividual(String name) {
        return delegate.getOWLIndividual(name);
    }

    @Override
    public OWLObjectProperty getOWLObjectProperty(String name) {
        return delegate.getOWLObjectProperty(name);
    }

    @Override
    public OWLAnnotationProperty getOWLAnnotationProperty(String name) {
        return delegate.getOWLAnnotationProperty(name);
    }

    @Override
    public void dispose() {
        shrotFormProviderAdaptor.dispose();
    }
}
