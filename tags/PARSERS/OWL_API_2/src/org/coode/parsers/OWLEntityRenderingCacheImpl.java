package org.coode.parsers;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.semanticweb.owl.model.OWLAxiomChange;
import org.semanticweb.owl.model.OWLClass;
import org.semanticweb.owl.model.OWLDataProperty;
import org.semanticweb.owl.model.OWLDataType;
import org.semanticweb.owl.model.OWLEntity;
import org.semanticweb.owl.model.OWLEntityVisitor;
import org.semanticweb.owl.model.OWLIndividual;
import org.semanticweb.owl.model.OWLObjectProperty;
import org.semanticweb.owl.model.OWLOntology;
import org.semanticweb.owl.model.OWLOntologyChange;
import org.semanticweb.owl.model.OWLOntologyChangeListener;
import org.semanticweb.owl.model.OWLOntologyManager;

public class OWLEntityRenderingCacheImpl implements OWLEntityRenderingCache {
	private Map<String, OWLClass> owlClassMap = new HashMap<String, OWLClass>();
	private Map<String, OWLObjectProperty> owlObjectPropertyMap = new HashMap<String, OWLObjectProperty>();
	private Map<String, OWLDataProperty> owlDataPropertyMap = new HashMap<String, OWLDataProperty>();
	private Map<String, OWLIndividual> owlIndividualMap = new HashMap<String, OWLIndividual>();
	private Map<String, OWLDataType> owlDatatypeMap = new HashMap<String, OWLDataType>();
	private Map<OWLEntity, String> entityRenderingMap = new HashMap<OWLEntity, String>();
	private final OWLOntologyManager manager;
	private final OWLEntityRenderer entityRenderer;
	private OWLOntologyChangeListener listener = new OWLOntologyChangeListener() {
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
				for (OWLEntity ent : chg.getEntities()) {
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
		this.entityRenderingMap.put(nothing, this.entityRenderer
				.render(nothing));
		this.owlClassMap.put(this.entityRenderer.render(nothing), nothing);
		for (OWLOntology ont : this.manager.getOntologies()) {
			for (OWLClass cls : ont.getReferencedClasses()) {
				this.addRendering(cls, this.owlClassMap);
			}
			for (OWLObjectProperty prop : ont.getReferencedObjectProperties()) {
				this.addRendering(prop, this.owlObjectPropertyMap);
			}
			for (OWLDataProperty prop : ont.getReferencedDataProperties()) {
				this.addRendering(prop, this.owlDataPropertyMap);
			}
			for (OWLIndividual ind : ont.getReferencedIndividuals()) {
				this.addRendering(ind, this.owlIndividualMap);
			}
			// datatypes
			final OWLDataTypeUtils datatypeUtils = new OWLDataTypeUtils(
					this.manager);
			for (OWLDataType dt : datatypeUtils.getKnownDatatypes(this.manager
					.getOntologies())) {
				this.addRendering(dt, this.owlDatatypeMap);
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

	public OWLIndividual getOWLIndividual(String rendering) {
		return this.owlIndividualMap.get(rendering);
	}

	public OWLDataType getOWLDataType(String rendering) {
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

			public void visit(OWLIndividual entity) {
				OWLEntityRenderingCacheImpl.this.addRendering(entity,
						OWLEntityRenderingCacheImpl.this.owlIndividualMap);
			}

			public void visit(OWLClass entity) {
				OWLEntityRenderingCacheImpl.this.addRendering(entity,
						OWLEntityRenderingCacheImpl.this.owlClassMap);
			}

			public void visit(OWLDataType entity) {
				OWLEntityRenderingCacheImpl.this.addRendering(entity,
						OWLEntityRenderingCacheImpl.this.owlDatatypeMap);
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

			public void visit(OWLIndividual entity) {
				OWLEntityRenderingCacheImpl.this.owlIndividualMap
						.remove(oldRendering);
			}

			public void visit(OWLDataType entity) {
				OWLEntityRenderingCacheImpl.this.owlDatatypeMap
						.remove(oldRendering);
			}
		});
	}

	public void updateRendering(final OWLEntity ent) {
		boolean updateRendering = false;
		for (OWLOntology ont : this.manager.getOntologies()) {
			if (ont.containsEntityReference(ent)) {
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
