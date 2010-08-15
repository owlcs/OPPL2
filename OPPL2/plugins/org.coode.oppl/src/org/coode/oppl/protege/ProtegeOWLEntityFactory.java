package org.coode.oppl.protege;

import org.coode.oppl.EntityFactory;
import org.coode.oppl.entity.OWLEntityCreationException;
import org.coode.oppl.entity.OWLEntityCreationSet;
import org.coode.oppl.entity.OWLEntityFactory;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLDataProperty;
import org.semanticweb.owlapi.model.OWLEntity;
import org.semanticweb.owlapi.model.OWLNamedIndividual;
import org.semanticweb.owlapi.model.OWLObjectProperty;

public class ProtegeOWLEntityFactory implements OWLEntityFactory {
	private EntityFactory delegateFactory;

	public ProtegeOWLEntityFactory(ProtegeOPPLFactory f) {
		this.delegateFactory = new EntityFactory(f);
	}

	public OWLEntityCreationSet<OWLClass> createOWLClass(String shortName,
			IRI baseIRI) throws OWLEntityCreationException {
		return this.delegateFactory.createOWLClass(shortName, baseIRI);
	}

	public OWLEntityCreationSet<OWLDataProperty> createOWLDataProperty(
			String shortName, IRI baseIRI) throws OWLEntityCreationException {
		return this.delegateFactory.createOWLDataProperty(shortName, baseIRI);
	}

	public <T extends OWLEntity> OWLEntityCreationSet<T> createOWLEntity(
			Class<T> type, String shortName, IRI baseIRI)
			throws OWLEntityCreationException {
		return this.delegateFactory.createOWLEntity(type, shortName, baseIRI);
	}

	public OWLEntityCreationSet<OWLNamedIndividual> createOWLIndividual(
			String shortName, IRI baseIRI) throws OWLEntityCreationException {
		return this.delegateFactory.createOWLIndividual(shortName, baseIRI);
	}

	public OWLEntityCreationSet<OWLObjectProperty> createOWLObjectProperty(
			String shortName, IRI baseIRI) throws OWLEntityCreationException {
		return this.delegateFactory.createOWLObjectProperty(shortName, baseIRI);
	}

	public <T extends OWLEntity> OWLEntityCreationSet<T> preview(Class<T> type,
			String shortName, IRI baseIRI) throws OWLEntityCreationException {
		return this.delegateFactory.preview(type, shortName, baseIRI);
	}

	public void tryCreate(Class<? extends OWLEntity> type, String shortName,
			IRI baseIRI) throws OWLEntityCreationException {
		this.delegateFactory.tryCreate(type, shortName, baseIRI);
	}
}