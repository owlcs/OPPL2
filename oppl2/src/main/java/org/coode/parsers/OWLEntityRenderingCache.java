package org.coode.parsers;

import java.util.Set;

import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLDataProperty;
import org.semanticweb.owlapi.model.OWLDatatype;
import org.semanticweb.owlapi.model.OWLEntity;
import org.semanticweb.owlapi.model.OWLIndividual;
import org.semanticweb.owlapi.model.OWLObjectProperty;

/** Author: Matthew Horridge<br>
 * The University Of Manchester<br>
 * Medical Informatics Group<br>
 * Date: 21-Sep-2006<br>
 * <br>
 * <p/>
 * matthew.horridge@cs.man.ac.uk<br>
 * www.cs.man.ac.uk/~horridgm<br>
 * <br> */
public interface OWLEntityRenderingCache {
    /** rebuild cache */
    void rebuild();

    /** @param owlEntity */
    void addRendering(OWLEntity owlEntity);

    /** @param owlEntity */
    void removeRendering(OWLEntity owlEntity);

    /** @param owlEntity */
    void updateRendering(OWLEntity owlEntity);

    /** @param rendering
     * @return entity */
    OWLEntity getOWLEntity(String rendering);

    /** @param rendering
     * @return class */
    OWLClass getOWLClass(String rendering);

    /** @param rendering
     * @return object property */
    OWLObjectProperty getOWLObjectProperty(String rendering);

    /** @param rendering
     * @return data property */
    OWLDataProperty getOWLDataProperty(String rendering);

    /** @param rendering
     * @return individual */
    OWLIndividual getOWLIndividual(String rendering);

    /** @param rendering
     * @return datatype */
    OWLDatatype getOWLDataType(String rendering);

    /** @return renderings for classes */
    Set<String> getOWLClassRenderings();

    /** @return renderings for object properties */
    Set<String> getOWLObjectPropertyRenderings();

    /** @return renderings for data properties */
    Set<String> getOWLDataPropertyRenderings();

    /** @return renderings for individuals */
    Set<String> getOWLIndividualRenderings();

    /** @return renderings for datatypes */
    Set<String> getOWLDatatypeRenderings();

    /** @return renderings for entities */
    Set<String> getOWLEntityRenderings();

    /** @param owlEntity
     * @return rendering for entity */
    String getRendering(OWLEntity owlEntity);
}
