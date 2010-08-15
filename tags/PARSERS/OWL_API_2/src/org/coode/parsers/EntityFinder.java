package org.coode.parsers;

import org.semanticweb.owl.model.*;

import java.util.Set;


/**
 * Author: Matthew Horridge<br>
 * The University Of Manchester<br>
 * Medical Informatics Group<br>
 * Date: 16-May-2006<br><br>
 * <p/>
 * matthew.horridge@cs.man.ac.uk<br>
 * www.cs.man.ac.uk/~horridgm<br><br>
 */
public interface EntityFinder {

    /**
     * Gets the entities that match the specified string.
     */
    Set<OWLEntity> getEntities(String match);

    Set<OWLEntity> getEntities(String match, boolean fullRegExp);


    Set<OWLClass> getMatchingOWLClasses(String match);

    Set<OWLClass> getMatchingOWLClasses(String match, boolean fullRegExp);


    Set<OWLObjectProperty> getMatchingOWLObjectProperties(String match);

    Set<OWLObjectProperty> getMatchingOWLObjectProperties(String match, boolean fullRegExp);


    Set<OWLDataProperty> getMatchingOWLDataProperties(String match);

    Set<OWLDataProperty> getMatchingOWLDataProperties(String match, boolean fullRegExp);


    Set<OWLIndividual> getMatchingOWLIndividuals(String match);

    Set<OWLIndividual> getMatchingOWLIndividuals(String match, boolean fullRegExp);


    Set<OWLDataType> getMatchingOWLDataTypes(String match);

    Set<OWLDataType> getMatchingOWLDataTypes(String match, boolean fullRegExp);
}