package org.coode.oppl.syntax;

import java.util.HashSet;
import java.util.Set;

import org.semanticweb.owl.model.OWLEntity;
import org.semanticweb.owl.model.OWLOntology;
import org.semanticweb.owl.util.OWLEntitySetProvider;

/**
 * Author: Matthew Horridge<br>
 * The University Of Manchester<br>
 * Bio-Health Informatics Group<br>
 * Date: 28-Nov-2007<br>
 * <br>
 */
public class ReferencedEntitySetProvider implements
		OWLEntitySetProvider<OWLEntity> {
	private Set<OWLOntology> ontologies;

	public ReferencedEntitySetProvider(Set<OWLOntology> ontologies) {
		this.ontologies = ontologies;
	}

	public Set<OWLEntity> getEntities() {
		Set<OWLEntity> entities = new HashSet<OWLEntity>();
		for (OWLOntology ont : this.ontologies) {
			entities.addAll(ont.getReferencedClasses());
			entities.addAll(ont.getReferencedObjectProperties());
			entities.addAll(ont.getReferencedDataProperties());
			entities.addAll(ont.getReferencedIndividuals());
			entities.addAll(ont.getReferencedDatatypes());
		}
		return entities;
	}
}
