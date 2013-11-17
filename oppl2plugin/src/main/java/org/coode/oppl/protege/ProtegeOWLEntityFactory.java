package org.coode.oppl.protege;

import org.coode.oppl.EntityFactory;
import org.coode.oppl.entity.OWLEntityCreationException;
import org.coode.oppl.entity.OWLEntityCreationSet;
import org.coode.oppl.entity.OWLEntityFactory;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLAnnotationProperty;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLDataProperty;
import org.semanticweb.owlapi.model.OWLEntity;
import org.semanticweb.owlapi.model.OWLNamedIndividual;
import org.semanticweb.owlapi.model.OWLObjectProperty;

public class ProtegeOWLEntityFactory implements OWLEntityFactory {
    private final EntityFactory delegateFactory;

    public ProtegeOWLEntityFactory(ProtegeOPPLFactory f) {
        delegateFactory = new EntityFactory(f);
    }

    @Override
    public OWLEntityCreationSet<OWLClass> createOWLClass(String shortName, IRI baseIRI)
            throws OWLEntityCreationException {
        return delegateFactory.createOWLClass(shortName, baseIRI);
    }

    @Override
    public OWLEntityCreationSet<OWLDataProperty> createOWLDataProperty(String shortName,
            IRI baseIRI) throws OWLEntityCreationException {
        return delegateFactory.createOWLDataProperty(shortName, baseIRI);
    }

    @Override
    public <T extends OWLEntity> OWLEntityCreationSet<T> createOWLEntity(Class<T> type,
            String shortName, IRI baseIRI) throws OWLEntityCreationException {
        return delegateFactory.createOWLEntity(type, shortName, baseIRI);
    }

    @Override
    public OWLEntityCreationSet<OWLNamedIndividual> createOWLIndividual(String shortName,
            IRI baseIRI) throws OWLEntityCreationException {
        return delegateFactory.createOWLIndividual(shortName, baseIRI);
    }

    @Override
    public OWLEntityCreationSet<OWLObjectProperty> createOWLObjectProperty(
            String shortName, IRI baseIRI) throws OWLEntityCreationException {
        return delegateFactory.createOWLObjectProperty(shortName, baseIRI);
    }

    @Override
    public OWLEntityCreationSet<OWLAnnotationProperty> createOWLAnnotationProperty(
            String shortName, IRI baseIRI) throws OWLEntityCreationException {
        return delegateFactory.createOWLAnnotationProperty(shortName, baseIRI);
    }

    @Override
    public <T extends OWLEntity> OWLEntityCreationSet<T> preview(Class<T> type,
            String shortName, IRI baseIRI) throws OWLEntityCreationException {
        return delegateFactory.preview(type, shortName, baseIRI);
    }

    @Override
    public void tryCreate(Class<? extends OWLEntity> type, String shortName, IRI baseIRI)
            throws OWLEntityCreationException {
        delegateFactory.tryCreate(type, shortName, baseIRI);
    }
}
