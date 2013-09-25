package org.coode.oppl.entity;

import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLAnnotationProperty;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLDataProperty;
import org.semanticweb.owlapi.model.OWLEntity;
import org.semanticweb.owlapi.model.OWLNamedIndividual;
import org.semanticweb.owlapi.model.OWLObjectProperty;

public interface OWLEntityFactory {
    public abstract OWLEntityCreationSet<OWLClass> createOWLClass(String shortName,
            IRI baseIRI) throws OWLEntityCreationException;

    public abstract OWLEntityCreationSet<OWLObjectProperty> createOWLObjectProperty(
            String shortName, IRI baseIRI) throws OWLEntityCreationException;

    public abstract OWLEntityCreationSet<OWLAnnotationProperty>
            createOWLAnnotationProperty(String shortName, IRI baseIRI)
                    throws OWLEntityCreationException;

    public abstract OWLEntityCreationSet<OWLDataProperty> createOWLDataProperty(
            String shortName, IRI baseIRI) throws OWLEntityCreationException;

    public abstract OWLEntityCreationSet<OWLNamedIndividual> createOWLIndividual(
            String shortName, IRI baseIRI) throws OWLEntityCreationException;

    public abstract <T extends OWLEntity> OWLEntityCreationSet<T> createOWLEntity(
            Class<T> type, String shortName, IRI baseIRI)
            throws OWLEntityCreationException;

    public abstract void tryCreate(Class<? extends OWLEntity> type, String shortName,
            IRI baseIRI) throws OWLEntityCreationException;

    public abstract <T extends OWLEntity> OWLEntityCreationSet<T> preview(Class<T> type,
            String shortName, IRI baseIRI) throws OWLEntityCreationException;
}
