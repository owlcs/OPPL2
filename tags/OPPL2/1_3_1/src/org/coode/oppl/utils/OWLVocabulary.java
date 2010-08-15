/**
 * 
 */
package org.coode.oppl.utils;

import java.net.URI;

import org.semanticweb.owl.apibinding.OWLManager;
import org.semanticweb.owl.model.OWLClass;
import org.semanticweb.owl.model.OWLDataFactory;
import org.semanticweb.owl.model.OWLDataProperty;
import org.semanticweb.owl.model.OWLDataType;
import org.semanticweb.owl.model.OWLObjectProperty;

/**
 * Contains well known OWLObject instances that can then be used across the API.
 * 
 * @author Luigi Iannone
 * 
 */
public class OWLVocabulary {
	private final static OWLDataFactory dataFactory = OWLManager
			.createOWLOntologyManager().getOWLDataFactory();
	private final static URI TOP_OWL_OBJECT_PROPERTY_URI = URI
			.create("http://www.coode.org/patternLearning#topOWLObjectProperty");
	private final static URI TOP_OWL_DATA_PROPERTY_URI = URI
			.create("http://www.coode.org/patternLearning#topOWLDataProperty");

	/**
	 * @return the dataFactory
	 */
	private static OWLDataFactory getDataFactory() {
		return dataFactory;
	}

	private final static OWLObjectProperty topOWLObjectProperty = getDataFactory()
			.getOWLObjectProperty(TOP_OWL_OBJECT_PROPERTY_URI);
	private final static OWLDataProperty topOWLDataProperty = getDataFactory()
			.getOWLDataProperty(TOP_OWL_DATA_PROPERTY_URI);

	/**
	 * @return the topOWLObjectProperty
	 */
	public static OWLObjectProperty getTopOWLObjectProperty() {
		return topOWLObjectProperty;
	}

	/**
	 * @return the topOWLDataProperty
	 */
	public static OWLDataProperty getTopOWLDataProperty() {
		return topOWLDataProperty;
	}

	public static OWLClass getOWLThing() {
		return getDataFactory().getOWLThing();
	}

	public static OWLClass getOWLNothing() {
		return getDataFactory().getOWLNothing();
	}

	public static OWLDataType getTopDataType() {
		return getDataFactory().getTopDataType();
	}
}
