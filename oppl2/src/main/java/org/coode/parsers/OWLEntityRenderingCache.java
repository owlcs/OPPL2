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
    void rebuild();

    void addRendering(OWLEntity owlEntity);

    void removeRendering(OWLEntity owlEntity);

    void updateRendering(OWLEntity owlEntity);

    OWLEntity getOWLEntity(String rendering);

    OWLClass getOWLClass(String rendering);

    OWLObjectProperty getOWLObjectProperty(String rendering);

    OWLDataProperty getOWLDataProperty(String rendering);

    OWLIndividual getOWLIndividual(String rendering);

    OWLDatatype getOWLDataType(String rendering);

    Set<String> getOWLClassRenderings();

    Set<String> getOWLObjectPropertyRenderings();

    Set<String> getOWLDataPropertyRenderings();

    Set<String> getOWLIndividualRenderings();

    Set<String> getOWLDatatypeRenderings();

    Set<String> getOWLEntityRenderings();

    String getRendering(OWLEntity owlEntity);
}
