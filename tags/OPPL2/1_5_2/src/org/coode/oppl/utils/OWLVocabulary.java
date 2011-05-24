/**
 * 
 */
package org.coode.oppl.utils;

import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLDataFactory;
import org.semanticweb.owlapi.model.OWLEntity;

/**
 * Contains well known OWLObject instances that can then be used across the API.
 * 
 * @author Luigi Iannone
 * 
 */
public class OWLVocabulary {
	private final static OWLDataFactory dataFactory = OWLManager.createOWLOntologyManager().getOWLDataFactory();

	/**
	 * @return the dataFactory
	 */
	private static OWLDataFactory getDataFactory() {
		return dataFactory;
	}

	public static OWLClass getOWLThing() {
		return getDataFactory().getOWLThing();
	}

	public static OWLClass getOWLNothing() {
		return getDataFactory().getOWLNothing();
	}

	public static OWLEntity getOWLTopDataProperty() {
		return getDataFactory().getOWLTopDataProperty();
	}

	public static OWLEntity getOWLTopObjectProperty() {
		return getDataFactory().getOWLTopObjectProperty();
	}

	public static OWLEntity getTopDatatype() {
		return getDataFactory().getTopDatatype();
	}
}
