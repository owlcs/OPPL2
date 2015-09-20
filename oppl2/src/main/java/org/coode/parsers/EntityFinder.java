package org.coode.parsers;

import java.util.Set;

import org.semanticweb.owlapi.model.*;

/**
 * Author: Matthew Horridge<br>
 * The University Of Manchester<br>
 * Medical Informatics Group<br>
 * Date: 16-May-2006<br>
 * <br>
 * <br>
 * matthew.horridge@cs.man.ac.uk<br>
 * www.cs.man.ac.uk/~horridgm<br>
 * <br>
 */
public interface EntityFinder {

    /**
     * Gets the entities that match the specified string.
     * 
     * @param match
     *        match
     * @return matched entities
     */
    Set<OWLEntity> getEntities(String match);

    /**
     * @param match
     *        match
     * @param fullRegExp
     *        fullRegExp
     * @return matched entities
     */
    Set<OWLEntity> getEntities(String match, boolean fullRegExp);

    /**
     * @param match
     *        match
     * @return matched classes
     */
    Set<OWLClass> getMatchingOWLClasses(String match);

    /**
     * @param match
     *        match
     * @param fullRegExp
     *        fullRegExp
     * @return matched entities
     */
    Set<OWLClass> getMatchingOWLClasses(String match, boolean fullRegExp);

    /**
     * @param match
     *        match
     * @return matched entities
     */
    Set<OWLObjectProperty> getMatchingOWLObjectProperties(String match);

    /**
     * @param match
     *        match
     * @param fullRegExp
     *        fullRegExp
     * @return matched entities
     */
    Set<OWLObjectProperty> getMatchingOWLObjectProperties(String match, boolean fullRegExp);

    /**
     * @param match
     *        match
     * @return matched entities
     */
    Set<OWLDataProperty> getMatchingOWLDataProperties(String match);

    /**
     * @param match
     *        match
     * @param fullRegExp
     *        fullRegExp
     * @return matched entities
     */
    Set<OWLDataProperty> getMatchingOWLDataProperties(String match, boolean fullRegExp);

    /**
     * @param match
     *        match
     * @return matched entities
     */
    Set<OWLNamedIndividual> getMatchingOWLIndividuals(String match);

    /**
     * @param match
     *        match
     * @param fullRegExp
     *        fullRegExp
     * @return matched entities
     */
    Set<OWLNamedIndividual> getMatchingOWLIndividuals(String match, boolean fullRegExp);

    /**
     * @param match
     *        match
     * @return matched entities
     */
    Set<OWLDatatype> getMatchingOWLDataTypes(String match);

    /**
     * @param match
     *        match
     * @param fullRegExp
     *        fullRegExp
     * @return matched entities
     */
    Set<OWLDatatype> getMatchingOWLDataTypes(String match, boolean fullRegExp);
}
