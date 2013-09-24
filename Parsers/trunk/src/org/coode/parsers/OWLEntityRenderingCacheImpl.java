package org.coode.parsers;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.semanticweb.owlapi.model.OWLAnnotationProperty;
import org.semanticweb.owlapi.model.OWLAxiomChange;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLDataProperty;
import org.semanticweb.owlapi.model.OWLDatatype;
import org.semanticweb.owlapi.model.OWLEntity;
import org.semanticweb.owlapi.model.OWLEntityVisitor;
import org.semanticweb.owlapi.model.OWLNamedIndividual;
import org.semanticweb.owlapi.model.OWLObjectProperty;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyChange;
import org.semanticweb.owlapi.model.OWLOntologyChangeListener;
import org.semanticweb.owlapi.model.OWLOntologyManager;
import org.semanticweb.owlapi.vocab.OWL2Datatype;

public class OWLEntityRenderingCacheImpl implements OWLEntityRenderingCache {
	private final Map<String, OWLClass> owlClassMap = new HashMap<String, OWLClass>();
	private final Map<String, OWLObjectProperty> owlObjectPropertyMap = new HashMap<String, OWLObjectProperty>();
	private final Map<String, OWLDataProperty> owlDataPropertyMap = new HashMap<String, OWLDataProperty>();
	private final Map<String, OWLNamedIndividual> owlIndividualMap = new HashMap<String, OWLNamedIndividual>();
	private final Map<String, OWLDatatype> owlDatatypeMap = new HashMap<String, OWLDatatype>();
	private final Map<String, OWLAnnotationProperty> owlAnnotationPropertyMap = new HashMap<String, OWLAnnotationProperty>();
	private final Map<OWLEntity, String> entityRenderingMap = new HashMap<OWLEntity, String>();
	private final OWLOntologyManager manager;
	private final OWLEntityRenderer entityRenderer;
	private final OWLOntologyChangeListener listener = new OWLOntologyChangeListener() {
		public void ontologiesChanged(List<? extends OWLOntologyChange> changes) {
			OWLEntityRenderingCacheImpl.this.processChanges(changes);
		}
	};

	public OWLEntityRenderingCacheImpl(OWLOntologyManager manager,
			OWLEntityRenderer entityRenderer) {
		if (manager == null) {
			throw new NullPointerException(
					"The ontolgoy manager cannot be null");
		}
		if (entityRenderer == null) {
			throw new NullPointerException("The entity render cannot be null");
		}
		this.manager = manager;
		this.entityRenderer = entityRenderer;
		this.manager.addOntologyChangeListener(this.listener);
		this.rebuild();
	}

	private void processChanges(List<? extends OWLOntologyChange> changes) {
		for (OWLOntologyChange change : changes) {
			if (change instanceof OWLAxiomChange) {
				OWLAxiomChange chg = (OWLAxiomChange) change;
				for (OWLEntity ent : chg.getSignature()) {
					this.updateRendering(ent);
				}
			}
		}
	}

	public void rebuild() {
		this.clear();
		OWLClass thing = this.manager.getOWLDataFactory().getOWLThing();
		this.owlClassMap.put(this.entityRenderer.render(thing), thing);
		this.entityRenderingMap.put(thing, this.entityRenderer.render(thing));
		OWLClass nothing = this.manager.getOWLDataFactory().getOWLNothing();
		this.entityRenderingMap.put(nothing,
				this.entityRenderer.render(nothing));
		this.owlClassMap.put(this.entityRenderer.render(nothing), nothing);
		for (OWLOntology ont : this.manager.getOntologies()) {
			for (OWLClass cls : ont.getClassesInSignature()) {
				this.addRendering(cls, this.owlClassMap);
			}
			for (OWLObjectProperty prop : ont.getObjectPropertiesInSignature()) {
				this.addRendering(prop, this.owlObjectPropertyMap);
			}
			for (OWLDataProperty prop : ont.getDataPropertiesInSignature()) {
				this.addRendering(prop, this.owlDataPropertyMap);
			}
			for (OWLNamedIndividual ind : ont.getIndividualsInSignature()) {
				this.addRendering(ind, this.owlIndividualMap);
			}
			// datatypes
			EnumSet<OWL2Datatype> allDataTypes = EnumSet
					.allOf(OWL2Datatype.class);
			for (OWL2Datatype dt : allDataTypes) {
				OWLDatatype owlDatatype = this.manager.getOWLDataFactory()
						.getOWLDatatype(dt.getIRI());
				this.addRendering(owlDatatype, this.owlDatatypeMap);
			}
		}
	}

	public void dispose() {
		this.clear();
		this.manager.removeOntologyChangeListener(this.listener);
	}

	private void clear() {
		this.owlClassMap.clear();
		this.owlObjectPropertyMap.clear();
		this.owlDataPropertyMap.clear();
		this.owlIndividualMap.clear();
		this.owlDatatypeMap.clear();
		this.entityRenderingMap.clear();
	}

	public OWLClass getOWLClass(String rendering) {
		return this.owlClassMap.get(rendering);
	}

	public OWLObjectProperty getOWLObjectProperty(String rendering) {
		return this.owlObjectPropertyMap.get(rendering);
	}

	public OWLDataProperty getOWLDataProperty(String rendering) {
		return this.owlDataPropertyMap.get(rendering);
	}

	public OWLNamedIndividual getOWLIndividual(String rendering) {
		return this.owlIndividualMap.get(rendering);
	}

	public OWLDatatype getOWLDataType(String rendering) {
		return this.owlDatatypeMap.get(rendering);
	}

	public String getRendering(OWLEntity owlEntity) {
		return this.entityRenderingMap.get(owlEntity);
	}

	public OWLEntity getOWLEntity(String rendering) {
		// Examine in the order of class, property, individual
		OWLEntity entity = this.getOWLClass(rendering);
		if (entity != null) {
			return entity;
		}
		entity = this.getOWLObjectProperty(rendering);
		if (entity != null) {
			return entity;
		}
		entity = this.getOWLDataProperty(rendering);
		if (entity != null) {
			return entity;
		}
		entity = this.getOWLIndividual(rendering);
		if (entity != null) {
			return entity;
		}
		entity = this.getOWLDataType(rendering);
		if (entity != null) {
			return entity;
		}
		return null;
	}

	public void addRendering(OWLEntity owlEntity) {
		owlEntity.accept(new OWLEntityVisitor() {
			public void visit(OWLDataProperty entity) {
				OWLEntityRenderingCacheImpl.this.addRendering(entity,
						OWLEntityRenderingCacheImpl.this.owlDataPropertyMap);
			}

			public void visit(OWLObjectProperty entity) {
				OWLEntityRenderingCacheImpl.this.addRendering(entity,
						OWLEntityRenderingCacheImpl.this.owlObjectPropertyMap);
			}

			public void visit(OWLNamedIndividual entity) {
				OWLEntityRenderingCacheImpl.this.addRendering(entity,
						OWLEntityRenderingCacheImpl.this.owlIndividualMap);
			}

			public void visit(OWLClass entity) {
				OWLEntityRenderingCacheImpl.this.addRendering(entity,
						OWLEntityRenderingCacheImpl.this.owlClassMap);
			}

			public void visit(OWLDatatype entity) {
				OWLEntityRenderingCacheImpl.this.addRendering(entity,
						OWLEntityRenderingCacheImpl.this.owlDatatypeMap);
			}

			public void visit(OWLAnnotationProperty property) {
				OWLEntityRenderingCacheImpl.this
						.addRendering(
								property,
								OWLEntityRenderingCacheImpl.this.owlAnnotationPropertyMap);
			}
		});
	}

	private <T extends OWLEntity> void addRendering(T entity, Map<String, T> map) {
		if (!this.entityRenderingMap.containsKey(entity)) {
			String rendering = this.entityRenderer.render(entity);
			map.put(rendering, entity);
			this.entityRenderingMap.put(entity, rendering);
		}
	}

	public void removeRendering(OWLEntity owlEntity) {
		final String oldRendering = this.entityRenderingMap.get(owlEntity);
		this.entityRenderingMap.remove(owlEntity);
		owlEntity.accept(new OWLEntityVisitor() {
			public void visit(OWLClass entity) {
				OWLEntityRenderingCacheImpl.this.owlClassMap
						.remove(oldRendering);
			}

			public void visit(OWLDataProperty entity) {
				OWLEntityRenderingCacheImpl.this.owlDataPropertyMap
						.remove(oldRendering);
			}

			public void visit(OWLObjectProperty entity) {
				OWLEntityRenderingCacheImpl.this.owlObjectPropertyMap
						.remove(oldRendering);
			}

			public void visit(OWLNamedIndividual entity) {
				OWLEntityRenderingCacheImpl.this.owlIndividualMap
						.remove(oldRendering);
			}

			public void visit(OWLDatatype entity) {
				OWLEntityRenderingCacheImpl.this.owlDatatypeMap
						.remove(oldRendering);
			}

			public void visit(OWLAnnotationProperty property) {
				OWLEntityRenderingCacheImpl.this.owlAnnotationPropertyMap
						.remove(oldRendering);
			}
		});
	}

	public void updateRendering(final OWLEntity ent) {
		boolean updateRendering = false;
		for (OWLOntology ont : this.manager.getOntologies()) {
			if (ont.containsEntityInSignature(ent)) {
				updateRendering = true;
				break;
			}
		}
		this.removeRendering(ent); // always remove the old rendering
		if (updateRendering) {
			this.addRendering(ent);
		}
	}

	public Set<String> getOWLClassRenderings() {
		return this.owlClassMap.keySet();
	}

	public Set<String> getOWLObjectPropertyRenderings() {
		return this.owlObjectPropertyMap.keySet();
	}

	public Set<String> getOWLDataPropertyRenderings() {
		return this.owlDataPropertyMap.keySet();
	}

	public Set<String> getOWLIndividualRenderings() {
		return this.owlIndividualMap.keySet();
	}

	public Set<String> getOWLDatatypeRenderings() {
		return this.owlDatatypeMap.keySet();
	}

	public Set<String> getOWLEntityRenderings() {
		Set<String> renderings = new HashSet<String>(this.owlClassMap.size()
				+ this.owlObjectPropertyMap.size()
				+ this.owlDataPropertyMap.size() + this.owlIndividualMap.size()
				+ this.owlDatatypeMap.size());
		renderings.addAll(this.owlClassMap.keySet());
		renderings.addAll(this.owlObjectPropertyMap.keySet());
		renderings.addAll(this.owlDataPropertyMap.keySet());
		renderings.addAll(this.owlIndividualMap.keySet());
		renderings.addAll(this.owlDatatypeMap.keySet());
		return renderings;
	}
}
