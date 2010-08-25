package org.coode.oppl.entity;

import java.net.URI;

import org.semanticweb.owl.model.OWLClass;
import org.semanticweb.owl.model.OWLDataProperty;
import org.semanticweb.owl.model.OWLEntity;
import org.semanticweb.owl.model.OWLIndividual;
import org.semanticweb.owl.model.OWLObjectProperty;

public interface OWLEntityFactory {
	public abstract OWLEntityCreationSet<OWLClass> createOWLClass(
			String shortName, URI baseURI) throws OWLEntityCreationException;

	public abstract OWLEntityCreationSet<OWLObjectProperty> createOWLObjectProperty(
			String shortName, URI baseURI) throws OWLEntityCreationException;

	public abstract OWLEntityCreationSet<OWLDataProperty> createOWLDataProperty(
			String shortName, URI baseURI) throws OWLEntityCreationException;

	public abstract OWLEntityCreationSet<OWLIndividual> createOWLIndividual(
			String shortName, URI baseURI) throws OWLEntityCreationException;

	public abstract <T extends OWLEntity> OWLEntityCreationSet<T> createOWLEntity(
			Class<T> type, String shortName, URI baseURI)
			throws OWLEntityCreationException;

	public abstract void tryCreate(Class<? extends OWLEntity> type,
			String shortName, URI baseURI) throws OWLEntityCreationException;

	public abstract <T extends OWLEntity> OWLEntityCreationSet<T> preview(
			Class<T> type, String shortName, URI baseURI)
			throws OWLEntityCreationException;
}