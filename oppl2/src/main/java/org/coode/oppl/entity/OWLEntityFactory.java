package org.coode.oppl.entity;

import org.semanticweb.owlapi.model.*;

/**
 * @author Luigi Iannone
 */
public interface OWLEntityFactory {

    /**
     * @param shortName
     *        shortName
     * @param baseIRI
     *        baseIRI
     * @return creation set for class
     * @throws OWLEntityCreationException
     *         OWLEntityCreationException
     */
    OWLEntityCreationSet<OWLClass> createOWLClass(String shortName, IRI baseIRI)
        throws OWLEntityCreationException;

    /**
     * @param shortName
     *        shortName
     * @param baseIRI
     *        baseIRI
     * @return creation set for object property
     * @throws OWLEntityCreationException
     *         OWLEntityCreationException
     */
    OWLEntityCreationSet<OWLObjectProperty> createOWLObjectProperty(String shortName,
        IRI baseIRI) throws OWLEntityCreationException;

    /**
     * @param shortName
     *        shortName
     * @param baseIRI
     *        baseIRI
     * @return creation set for annotation property
     * @throws OWLEntityCreationException
     *         OWLEntityCreationException
     */
    OWLEntityCreationSet<OWLAnnotationProperty> createOWLAnnotationProperty(
        String shortName, IRI baseIRI) throws OWLEntityCreationException;

    /**
     * @param shortName
     *        shortName
     * @param baseIRI
     *        baseIRI
     * @return creation set for data property
     * @throws OWLEntityCreationException
     *         OWLEntityCreationException
     */
    OWLEntityCreationSet<OWLDataProperty> createOWLDataProperty(String shortName,
        IRI baseIRI) throws OWLEntityCreationException;

    /**
     * @param shortName
     *        shortName
     * @param baseIRI
     *        baseIRI
     * @return creation set for individual
     * @throws OWLEntityCreationException
     *         OWLEntityCreationException
     */
    OWLEntityCreationSet<OWLNamedIndividual> createOWLIndividual(String shortName,
        IRI baseIRI) throws OWLEntityCreationException;

    /**
     * @param type
     *        type
     * @param shortName
     *        shortName
     * @param baseIRI
     *        baseIRI
     * @param <T>
     *        class type
     * @return creation set for entity
     * @throws OWLEntityCreationException
     *         OWLEntityCreationException
     */
    <T extends OWLEntity> OWLEntityCreationSet<T> createOWLEntity(Class<T> type,
        String shortName, IRI baseIRI) throws OWLEntityCreationException;

    /**
     * @param type
     *        type
     * @param shortName
     *        shortName
     * @param baseIRI
     *        baseIRI
     * @throws OWLEntityCreationException
     *         OWLEntityCreationException
     */
    void tryCreate(Class<? extends OWLEntity> type, String shortName, IRI baseIRI)
        throws OWLEntityCreationException;

    /**
     * @param type
     *        type
     * @param shortName
     *        shortName
     * @param baseIRI
     *        baseIRI
     * @param <T>
     *        class type
     * @return preview
     * @throws OWLEntityCreationException
     *         OWLEntityCreationException
     */
    <T extends OWLEntity> OWLEntityCreationSet<T> preview(Class<T> type,
        String shortName, IRI baseIRI) throws OWLEntityCreationException;
}
