package org.coode.parsers;

import static org.coode.oppl.utils.ArgCheck.checkNotNull;

import java.util.*;

import org.semanticweb.owlapi.model.*;
import org.semanticweb.owlapi.vocab.OWL2Datatype;

/**
 * @author Luigi Iannone
 */
public class OWLEntityRenderingCacheImpl implements OWLEntityRenderingCache {

    protected Map<String, OWLClass> owlClassMap = new HashMap<>();
    protected Map<String, OWLObjectProperty> owlObjectPropertyMap = new HashMap<>();
    protected Map<String, OWLDataProperty> owlDataPropertyMap = new HashMap<>();
    protected Map<String, OWLNamedIndividual> owlIndividualMap = new HashMap<>();
    protected Map<String, OWLDatatype> owlDatatypeMap = new HashMap<>();
    protected Map<String, OWLAnnotationProperty> owlAnnotationPropertyMap = new HashMap<>();
    protected Map<OWLEntity, String> entityRenderingMap = new HashMap<>();
    protected final OWLOntologyManager manager;
    protected final OWLEntityRenderer entityRenderer;
    protected OWLOntologyChangeListener listener = new OWLOntologyChangeListener() {

        @Override
        public void ontologiesChanged(List<? extends OWLOntologyChange> changes) {
            OWLEntityRenderingCacheImpl.this.processChanges(changes);
        }
    };

    /**
     * @param manager
     *        manager
     * @param entityRenderer
     *        entityRenderer
     */
    public OWLEntityRenderingCacheImpl(OWLOntologyManager manager,
        OWLEntityRenderer entityRenderer) {
        this.manager = checkNotNull(manager, "manager");
        this.entityRenderer = checkNotNull(entityRenderer, "entityRenderer");
        this.manager.addOntologyChangeListener(listener);
        rebuild();
    }

    protected void processChanges(List<? extends OWLOntologyChange> changes) {
        for (OWLOntologyChange change : changes) {
            if (change instanceof OWLAxiomChange) {
                OWLAxiomChange chg = (OWLAxiomChange) change;
                for (OWLEntity ent : chg.getSignature()) {
                    updateRendering(ent);
                }
            }
        }
    }

    @Override
    public void rebuild() {
        clear();
        OWLClass thing = manager.getOWLDataFactory().getOWLThing();
        owlClassMap.put(entityRenderer.render(thing), thing);
        entityRenderingMap.put(thing, entityRenderer.render(thing));
        OWLClass nothing = manager.getOWLDataFactory().getOWLNothing();
        entityRenderingMap.put(nothing, entityRenderer.render(nothing));
        owlClassMap.put(entityRenderer.render(nothing), nothing);
        for (OWLOntology ont : manager.getOntologies()) {
            for (OWLClass cls : ont.getClassesInSignature()) {
                this.addRendering(cls, owlClassMap);
            }
            for (OWLObjectProperty prop : ont.getObjectPropertiesInSignature()) {
                this.addRendering(prop, owlObjectPropertyMap);
            }
            for (OWLDataProperty prop : ont.getDataPropertiesInSignature()) {
                this.addRendering(prop, owlDataPropertyMap);
            }
            for (OWLNamedIndividual ind : ont.getIndividualsInSignature()) {
                this.addRendering(ind, owlIndividualMap);
            }
            // datatypes
            EnumSet<OWL2Datatype> allDataTypes = EnumSet.allOf(OWL2Datatype.class);
            for (OWL2Datatype dt : allDataTypes) {
                OWLDatatype owlDatatype = manager.getOWLDataFactory().getOWLDatatype(
                    dt.getIRI());
                this.addRendering(owlDatatype, owlDatatypeMap);
            }
        }
    }

    /** remove change listener */
    public void dispose() {
        clear();
        manager.removeOntologyChangeListener(listener);
    }

    private void clear() {
        owlClassMap.clear();
        owlObjectPropertyMap.clear();
        owlDataPropertyMap.clear();
        owlIndividualMap.clear();
        owlDatatypeMap.clear();
        entityRenderingMap.clear();
    }

    @Override
    public OWLClass getOWLClass(String rendering) {
        return owlClassMap.get(rendering);
    }

    @Override
    public OWLObjectProperty getOWLObjectProperty(String rendering) {
        return owlObjectPropertyMap.get(rendering);
    }

    @Override
    public OWLDataProperty getOWLDataProperty(String rendering) {
        return owlDataPropertyMap.get(rendering);
    }

    @Override
    public OWLNamedIndividual getOWLIndividual(String rendering) {
        return owlIndividualMap.get(rendering);
    }

    @Override
    public OWLDatatype getOWLDataType(String rendering) {
        return owlDatatypeMap.get(rendering);
    }

    @Override
    public String getRendering(OWLEntity owlEntity) {
        return entityRenderingMap.get(owlEntity);
    }

    @Override
    public OWLEntity getOWLEntity(String rendering) {
        // Examine in the order of class, property, individual
        OWLEntity entity = getOWLClass(rendering);
        if (entity != null) {
            return entity;
        }
        entity = getOWLObjectProperty(rendering);
        if (entity != null) {
            return entity;
        }
        entity = getOWLDataProperty(rendering);
        if (entity != null) {
            return entity;
        }
        entity = getOWLIndividual(rendering);
        if (entity != null) {
            return entity;
        }
        entity = getOWLDataType(rendering);
        if (entity != null) {
            return entity;
        }
        return null;
    }

    @Override
    public void addRendering(OWLEntity owlEntity) {
        owlEntity.accept(new OWLEntityVisitor() {

            @Override
            public void visit(OWLDataProperty entity) {
                OWLEntityRenderingCacheImpl.this.addRendering(entity, owlDataPropertyMap);
            }

            @Override
            public void visit(OWLObjectProperty entity) {
                OWLEntityRenderingCacheImpl.this.addRendering(entity,
                    owlObjectPropertyMap);
            }

            @Override
            public void visit(OWLNamedIndividual entity) {
                OWLEntityRenderingCacheImpl.this.addRendering(entity, owlIndividualMap);
            }

            @Override
            public void visit(OWLClass entity) {
                OWLEntityRenderingCacheImpl.this.addRendering(entity, owlClassMap);
            }

            @Override
            public void visit(OWLDatatype entity) {
                OWLEntityRenderingCacheImpl.this.addRendering(entity, owlDatatypeMap);
            }

            @Override
            public void visit(OWLAnnotationProperty property) {
                OWLEntityRenderingCacheImpl.this.addRendering(property,
                    owlAnnotationPropertyMap);
            }
        });
    }

    protected <T extends OWLEntity> void addRendering(T entity, Map<String, T> map) {
        if (!entityRenderingMap.containsKey(entity)) {
            String rendering = entityRenderer.render(entity);
            map.put(rendering, entity);
            entityRenderingMap.put(entity, rendering);
        }
    }

    @Override
    public void removeRendering(OWLEntity owlEntity) {
        final String oldRendering = entityRenderingMap.get(owlEntity);
        entityRenderingMap.remove(owlEntity);
        owlEntity.accept(new OWLEntityVisitor() {

            @Override
            public void visit(OWLClass entity) {
                owlClassMap.remove(oldRendering);
            }

            @Override
            public void visit(OWLDataProperty entity) {
                owlDataPropertyMap.remove(oldRendering);
            }

            @Override
            public void visit(OWLObjectProperty entity) {
                owlObjectPropertyMap.remove(oldRendering);
            }

            @Override
            public void visit(OWLNamedIndividual entity) {
                owlIndividualMap.remove(oldRendering);
            }

            @Override
            public void visit(OWLDatatype entity) {
                owlDatatypeMap.remove(oldRendering);
            }

            @Override
            public void visit(OWLAnnotationProperty property) {
                owlAnnotationPropertyMap.remove(oldRendering);
            }
        });
    }

    @Override
    public void updateRendering(final OWLEntity ent) {
        boolean updateRendering = false;
        for (OWLOntology ont : manager.getOntologies()) {
            if (ont.containsEntityInSignature(ent)) {
                updateRendering = true;
                break;
            }
        }
        removeRendering(ent); // always remove the old rendering
        if (updateRendering) {
            this.addRendering(ent);
        }
    }

    @Override
    public Set<String> getOWLClassRenderings() {
        return owlClassMap.keySet();
    }

    @Override
    public Set<String> getOWLObjectPropertyRenderings() {
        return owlObjectPropertyMap.keySet();
    }

    @Override
    public Set<String> getOWLDataPropertyRenderings() {
        return owlDataPropertyMap.keySet();
    }

    @Override
    public Set<String> getOWLIndividualRenderings() {
        return owlIndividualMap.keySet();
    }

    @Override
    public Set<String> getOWLDatatypeRenderings() {
        return owlDatatypeMap.keySet();
    }

    @Override
    public Set<String> getOWLEntityRenderings() {
        Set<String> renderings = new HashSet<>(owlClassMap.size()
            + owlObjectPropertyMap.size() + owlDataPropertyMap.size()
            + owlIndividualMap.size() + owlDatatypeMap.size());
        renderings.addAll(owlClassMap.keySet());
        renderings.addAll(owlObjectPropertyMap.keySet());
        renderings.addAll(owlDataPropertyMap.keySet());
        renderings.addAll(owlIndividualMap.keySet());
        renderings.addAll(owlDatatypeMap.keySet());
        return renderings;
    }
}
