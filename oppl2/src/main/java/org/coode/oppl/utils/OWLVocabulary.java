package org.coode.oppl.utils;

import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLDataFactory;
import org.semanticweb.owlapi.model.OWLEntity;

/**
 * Contains well known OWLObject instances that can then be used across the API.
 * 
 * @author Luigi Iannone
 */
public class OWLVocabulary {

    private final static OWLDataFactory dataFactory = OWLManager
        .createOWLOntologyManager().getOWLDataFactory();

    /**
     * @return the dataFactory
     */
    private static OWLDataFactory getDataFactory() {
        return dataFactory;
    }

    /**
     * @return thing
     */
    public static OWLClass getOWLThing() {
        return getDataFactory().getOWLThing();
    }

    /**
     * @return nothing
     */
    public static OWLClass getOWLNothing() {
        return getDataFactory().getOWLNothing();
    }

    /**
     * @return top data property
     */
    public static OWLEntity getOWLTopDataProperty() {
        return getDataFactory().getOWLTopDataProperty();
    }

    /**
     * @return top object property
     */
    public static OWLEntity getOWLTopObjectProperty() {
        return getDataFactory().getOWLTopObjectProperty();
    }

    /**
     * @return top datatype
     */
    public static OWLEntity getTopDatatype() {
        return getDataFactory().getTopDatatype();
    }
}
