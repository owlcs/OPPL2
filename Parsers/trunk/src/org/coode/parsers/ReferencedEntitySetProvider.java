package org.coode.parsers;

import java.net.URI;
import java.util.HashSet;
import java.util.Set;

import org.semanticweb.owl.model.OWLDataFactory;
import org.semanticweb.owl.model.OWLEntity;
import org.semanticweb.owl.model.OWLOntology;
import org.semanticweb.owl.util.OWLEntitySetProvider;
import org.semanticweb.owl.vocab.XSDVocabulary;

/**
 * Author: Matthew Horridge<br>
 * The University Of Manchester<br>
 * Bio-Health Informatics Group<br>
 * Date: 28-Nov-2007<br>
 * <br>
 */
public class ReferencedEntitySetProvider implements OWLEntitySetProvider<OWLEntity> {
	private final Set<OWLOntology> ontologies = new HashSet<OWLOntology>();
	private final OWLDataFactory dataFactory;

	public ReferencedEntitySetProvider(Set<OWLOntology> ontologies, OWLDataFactory dataFactory) {
		if (ontologies == null) {
			throw new NullPointerException("The ontologies cannot be null");
		}
		if (dataFactory == null) {
			throw new NullPointerException("The data factory cannot be null");
		}
		this.ontologies.addAll(ontologies);
		this.dataFactory = dataFactory;
	}

	public Set<OWLEntity> getEntities() {
		Set<OWLEntity> entities = new HashSet<OWLEntity>();
		entities.add(this.getDataFactory().getOWLThing());
		entities.add(this.getDataFactory().getOWLNothing());
		entities.add(this.getDataFactory().getTopDataType());
		for (URI uri : XSDVocabulary.ALL_DATATYPES) {
			entities.add(this.getDataFactory().getOWLDataType(uri));
		}
		for (OWLOntology ont : this.ontologies) {
			entities.addAll(ont.getReferencedClasses());
			entities.addAll(ont.getReferencedObjectProperties());
			entities.addAll(ont.getReferencedDataProperties());
			entities.addAll(ont.getReferencedIndividuals());
			entities.addAll(ont.getReferencedDatatypes());
		}
		return entities;
	}

	/**
	 * @return the dataFactory
	 */
	public OWLDataFactory getDataFactory() {
		return this.dataFactory;
	}
}
