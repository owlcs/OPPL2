package org.coode.oppl.protege;

import java.net.URI;

import org.coode.oppl.EntityFactory;
import org.coode.oppl.entity.OWLEntityCreationException;
import org.coode.oppl.entity.OWLEntityCreationSet;
import org.coode.oppl.entity.OWLEntityFactory;
import org.semanticweb.owl.model.OWLClass;
import org.semanticweb.owl.model.OWLDataProperty;
import org.semanticweb.owl.model.OWLEntity;
import org.semanticweb.owl.model.OWLIndividual;
import org.semanticweb.owl.model.OWLObjectProperty;

public class ProtegeOWLEntityFactory implements OWLEntityFactory {
	private EntityFactory delegateFactory;
	private ProtegeOPPLFactory factory;

	//	private final org.protege.editor.owl.model.entity.OWLEntityFactory protegeOWLEntityFactory = this.factory.modelManager
	//			.getOWLEntityFactory();
	public ProtegeOWLEntityFactory(ProtegeOPPLFactory f) {
		this.factory = f;
		this.delegateFactory = new EntityFactory(f);
	}

	public OWLEntityCreationSet<OWLClass> createOWLClass(String shortName,
			URI baseURI) throws OWLEntityCreationException {
		return this.delegateFactory.createOWLClass(shortName, baseURI);
	}

	public OWLEntityCreationSet<OWLDataProperty> createOWLDataProperty(
			String shortName, URI baseURI) throws OWLEntityCreationException {
		return this.delegateFactory.createOWLDataProperty(shortName, baseURI);
	}

	public <T extends OWLEntity> OWLEntityCreationSet<T> createOWLEntity(
			Class<T> type, String shortName, URI baseURI)
			throws OWLEntityCreationException {
		return this.delegateFactory.createOWLEntity(type, shortName, baseURI);
	}

	public OWLEntityCreationSet<OWLIndividual> createOWLIndividual(
			String shortName, URI baseURI) throws OWLEntityCreationException {
		return this.delegateFactory.createOWLIndividual(shortName, baseURI);
	}

	public OWLEntityCreationSet<OWLObjectProperty> createOWLObjectProperty(
			String shortName, URI baseURI) throws OWLEntityCreationException {
		return this.delegateFactory.createOWLObjectProperty(shortName, baseURI);
	}

	public <T extends OWLEntity> OWLEntityCreationSet<T> preview(Class<T> type,
			String shortName, URI baseURI) throws OWLEntityCreationException {
		return this.delegateFactory.preview(type, shortName, baseURI);
	}

	public void tryCreate(Class<? extends OWLEntity> type, String shortName,
			URI baseURI) throws OWLEntityCreationException {
		this.delegateFactory.tryCreate(type, shortName, baseURI);
	}
	//	private <T extends OWLEntity> OWLEntityCreationSet<T> convert(
	//			org.protege.editor.owl.model.entity.OWLEntityCreationSet<T> protegeCreationSet) {
	//		List<? extends OWLOntologyChange> changes = protegeCreationSet
	//				.getOntologyChanges();
	//		T entity = protegeCreationSet.getOWLEntity();
	//		OWLEntityCreationSet<T> toReturn = new OWLEntityCreationSet<T>(entity,
	//				changes);
	//		return toReturn;
	//	}
	//
	//
	//	public OWLEntityCreationSet<OWLClass> createOWLClass(String shortName,
	//			URI baseURI) throws OWLEntityCreationException {
	//		try {
	//			org.protege.editor.owl.model.entity.OWLEntityCreationSet<OWLClass> protegeCreationSet = this.protegeOWLEntityFactory
	//					.createOWLClass(shortName, baseURI);
	//			return this.convert(protegeCreationSet);
	//		} catch (org.protege.editor.owl.model.entity.OWLEntityCreationException e) {
	//			throw new OWLEntityCreationException(e);
	//		}
	//	}
	//
	//	public OWLEntityCreationSet<OWLDataProperty> createOWLDataProperty(
	//			String shortName, URI baseURI) throws OWLEntityCreationException {
	//		try {
	//			org.protege.editor.owl.model.entity.OWLEntityCreationSet<OWLDataProperty> protegeCreationSet = this.protegeOWLEntityFactory
	//					.createOWLDataProperty(shortName, baseURI);
	//			return this.convert(protegeCreationSet);
	//		} catch (org.protege.editor.owl.model.entity.OWLEntityCreationException e) {
	//			throw new OWLEntityCreationException(e);
	//		}
	//	}
	//
	//	public <T extends OWLEntity> OWLEntityCreationSet<T> createOWLEntity(
	//			Class<T> type, String shortName, URI baseURI)
	//			throws OWLEntityCreationException {
	//		try {
	//			org.protege.editor.owl.model.entity.OWLEntityCreationSet<T> protegeCreationSet = this.protegeOWLEntityFactory
	//					.createOWLEntity(type, shortName, baseURI);
	//			return this.convert(protegeCreationSet);
	//		} catch (org.protege.editor.owl.model.entity.OWLEntityCreationException e) {
	//			throw new OWLEntityCreationException(e);
	//		}
	//	}
	//
	//	public OWLEntityCreationSet<OWLIndividual> createOWLIndividual(
	//			String shortName, URI baseURI) throws OWLEntityCreationException {
	//		try {
	//			org.protege.editor.owl.model.entity.OWLEntityCreationSet<OWLIndividual> protegeCreationSet = this.protegeOWLEntityFactory
	//					.createOWLIndividual(shortName, baseURI);
	//			return this.convert(protegeCreationSet);
	//		} catch (org.protege.editor.owl.model.entity.OWLEntityCreationException e) {
	//			throw new OWLEntityCreationException(e);
	//		}
	//	}
	//
	//	public OWLEntityCreationSet<OWLObjectProperty> createOWLObjectProperty(
	//			String shortName, URI baseURI) throws OWLEntityCreationException {
	//		try {
	//			org.protege.editor.owl.model.entity.OWLEntityCreationSet<OWLObjectProperty> protegeCreationSet = this.protegeOWLEntityFactory
	//					.createOWLObjectProperty(shortName, baseURI);
	//			return this.convert(protegeCreationSet);
	//		} catch (org.protege.editor.owl.model.entity.OWLEntityCreationException e) {
	//			throw new OWLEntityCreationException(e);
	//		}
	//	}
	//
	//	public <T extends OWLEntity> OWLEntityCreationSet<T> preview(Class<T> type,
	//			String shortName, URI baseURI) throws OWLEntityCreationException {
	//		try {
	//			org.protege.editor.owl.model.entity.OWLEntityCreationSet<T> protegeCreationSet = this.protegeOWLEntityFactory
	//					.preview(type, shortName, baseURI);
	//			return this.convert(protegeCreationSet);
	//		} catch (org.protege.editor.owl.model.entity.OWLEntityCreationException e) {
	//			throw new OWLEntityCreationException(e);
	//		}
	//	}
	//
	//	public void tryCreate(Class<? extends OWLEntity> type, String shortName,
	//			URI baseURI) throws OWLEntityCreationException {
	//		// TODO: not sure how this goes
	//	}
}