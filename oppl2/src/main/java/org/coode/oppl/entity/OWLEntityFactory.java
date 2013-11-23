package org.coode.oppl.entity;

import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLAnnotationProperty;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLDataProperty;
import org.semanticweb.owlapi.model.OWLEntity;
import org.semanticweb.owlapi.model.OWLNamedIndividual;
import org.semanticweb.owlapi.model.OWLObjectProperty;

public interface OWLEntityFactory {
    OWLEntityCreationSet<OWLClass> createOWLClass(String shortName, IRI baseIRI)
            throws OWLEntityCreationException;

    OWLEntityCreationSet<OWLObjectProperty> createOWLObjectProperty(String shortName,
            IRI baseIRI) throws OWLEntityCreationException;

    OWLEntityCreationSet<OWLAnnotationProperty> createOWLAnnotationProperty(
            String shortName, IRI baseIRI) throws OWLEntityCreationException;

    OWLEntityCreationSet<OWLDataProperty> createOWLDataProperty(String shortName,
            IRI baseIRI) throws OWLEntityCreationException;

    OWLEntityCreationSet<OWLNamedIndividual> createOWLIndividual(String shortName,
            IRI baseIRI) throws OWLEntityCreationException;

    <T extends OWLEntity> OWLEntityCreationSet<T> createOWLEntity(Class<T> type,
            String shortName, IRI baseIRI) throws OWLEntityCreationException;

    void tryCreate(Class<? extends OWLEntity> type, String shortName, IRI baseIRI)
            throws OWLEntityCreationException;

    <T extends OWLEntity> OWLEntityCreationSet<T> preview(Class<T> type,
            String shortName, IRI baseIRI) throws OWLEntityCreationException;
}
