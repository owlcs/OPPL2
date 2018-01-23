package org.coode.patterns.locality;

import static org.semanticweb.owlapi.util.OWLAPIStreamUtils.asSet;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import org.coode.oppl.Variable;
import org.coode.oppl.bindingtree.BindingNode;
import org.coode.oppl.exceptions.RuntimeExceptionHandler;
import org.coode.oppl.variabletypes.ANNOTATIONPROPERTYVariableType;
import org.coode.oppl.variabletypes.CLASSVariableType;
import org.coode.oppl.variabletypes.CONSTANTVariableType;
import org.coode.oppl.variabletypes.DATAPROPERTYVariableType;
import org.coode.oppl.variabletypes.INDIVIDUALVariableType;
import org.coode.oppl.variabletypes.InputVariable;
import org.coode.oppl.variabletypes.OBJECTPROPERTYVariableType;
import org.coode.oppl.variabletypes.VariableTypeVisitorEx;
import org.coode.patterns.InstantiatedPatternModel;
import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLAnnotationProperty;
import org.semanticweb.owlapi.model.OWLAxiom;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLDataFactory;
import org.semanticweb.owlapi.model.OWLDataProperty;
import org.semanticweb.owlapi.model.OWLEntity;
import org.semanticweb.owlapi.model.OWLNamedIndividual;
import org.semanticweb.owlapi.model.OWLObject;
import org.semanticweb.owlapi.model.OWLObjectProperty;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyChangeException;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;
import org.semanticweb.owlapi.model.OWLOntologyManager;
import org.semanticweb.owlapi.reasoner.OWLReasoner;

/**
 * @author Luigi Iannone
 */
public class LocalityChecker {

    private class SigmaBuilder implements VariableTypeVisitorEx<OWLEntity> {

        private final OWLOntologyManager manager;
        private final OWLDataFactory factory;

        SigmaBuilder(OWLOntologyManager manager) {
            this.manager = manager;
            factory = manager.getOWLDataFactory();
        }

        IRI create() {
            return IRI.create("urn:sigmaplus:a" + UUID.randomUUID().toString());
        }

        @Override
        public OWLAnnotationProperty visitANNOTATIONPROPERTYVariableType(
            ANNOTATIONPROPERTYVariableType annotationpropertyVariableType) {
            OWLAnnotationProperty property = factory.getOWLAnnotationProperty(create());
            try {
                manager.addAxiom(scratchpad, factory.getOWLDeclarationAxiom(property));
            } catch (OWLOntologyChangeException e) {
                // should never happen
                throw new RuntimeException("Unexpected condition", e);
            }
            return property;
        }

        @Override
        public OWLEntity visitINDIVIDUALVariableType(INDIVIDUALVariableType v) {
            OWLNamedIndividual owlIndividual = factory.getOWLNamedIndividual(create());
            try {
                manager.addAxiom(scratchpad, factory.getOWLDeclarationAxiom(owlIndividual));
            } catch (OWLOntologyChangeException e) {
                // should never happen
                throw new RuntimeException("Unexpected condition", e);
            }
            return owlIndividual;
        }

        @Override
        public OWLEntity visitDATAPROPERTYVariableType(DATAPROPERTYVariableType v) {
            OWLDataProperty owlDataProperty = factory.getOWLDataProperty(create());
            try {
                manager.addAxiom(scratchpad, factory.getOWLDeclarationAxiom(owlDataProperty));
            } catch (OWLOntologyChangeException e) {
                // should never happen
                throw new RuntimeException("Unexpected condition", e);
            }
            return owlDataProperty;
        }

        @Override
        public OWLEntity visitOBJECTPROPERTYVariableType(OBJECTPROPERTYVariableType v) {
            OWLObjectProperty owlObjectProperty = factory.getOWLObjectProperty(create());
            try {
                manager.addAxiom(scratchpad, factory.getOWLDeclarationAxiom(owlObjectProperty));
            } catch (OWLOntologyChangeException e) {
                // should never happen
                throw new RuntimeException("Unexpected condition", e);
            }
            return owlObjectProperty;
        }

        @Override
        public OWLEntity visitCONSTANTVariableType(CONSTANTVariableType v) {
            // it's not an owlentity in this case
            return null;
        }

        @Override
        public OWLEntity visitCLASSVariableType(CLASSVariableType v) {
            OWLClass owlClass = factory.getOWLClass(create());
            try {
                manager.addAxiom(scratchpad, factory.getOWLDeclarationAxiom(owlClass));
            } catch (OWLOntologyChangeException e) {
                // should never happen
                throw new RuntimeException("Unexpected condition", e);
            }
            return owlClass;
        }
    }

    private InstantiatedPatternModel instantiatedPatternModel;
    private final Set<OWLEntity> entities = new HashSet<>();
    private LocalityEvaluator evaluator;
    private final OWLOntologyManager myManager;
    protected final OWLOntology scratchpad;
    private LocalityCheckerLeafBrusher leafBrusher;
    private final VariableTypeVisitorEx<OWLEntity> plusBuilder;
    private final VariableTypeVisitorEx<OWLEntity> minusBuilder;
    private Map<Variable<?>, SigmaPlusSigmaMinus> sigmaValues;
    private OWLOntologyManager externalManager;
    private final RuntimeExceptionHandler handler;

    /**
     * @param manager manager
     * @param r r
     * @param entities entities
     * @param handler handler
     */
    public LocalityChecker(final OWLOntologyManager manager, OWLReasoner r,
        Collection<? extends OWLEntity> entities, RuntimeExceptionHandler handler) {
        externalManager = manager;
        this.handler = handler;
        myManager = OWLManager.createOWLOntologyManager();
        myManager.getIRIMappers().add(ontologyIRI -> ontologyIRI);
        try {
            scratchpad = myManager.createOntology(Collections.<OWLAxiom>emptySet());
            // neither exceptions should ever be thrown
        } catch (OWLOntologyCreationException e) {
            throw new RuntimeException("Unexpected exception type", e);
        } catch (OWLOntologyChangeException e) {
            throw new RuntimeException("Unexpected exception type", e);
        }
        evaluator = new SemanticLocalityEvaluator(externalManager, r);
        this.entities.addAll(entities);
        plusBuilder = new SigmaBuilder(myManager);
        minusBuilder = new SigmaBuilder(myManager) {

            @Override
            IRI create() {
                return IRI.create("urn:sigmaminus:a" + UUID.randomUUID().toString());
            }
        };
    }

    /**
     * @param owlentities owlentities
     */
    public void setSignature(Collection<? extends OWLEntity> owlentities) {
        entities.clear();
        entities.addAll(owlentities);
    }

    /**
     * @param m m
     */
    public void setInstantiatedPatternModel(InstantiatedPatternModel m) {
        instantiatedPatternModel = m;
    }

    /**
     * @return true if local
     */
    public boolean isLocal() {
        sigmaValues = buildMinimalBindingNodes();
        BindingNode rootBindingNode = new BindingNode(sigmaValues.keySet());
        leafBrusher = new LocalityCheckerLeafBrusher(getEvaluator(),
            getInstantiatedPatternModel().getConstraintSystem(),
            getInstantiatedPatternModel().getInstantiatedPattern(), sigmaValues, entities,
            getHandler());
        rootBindingNode.accept(leafBrusher);
        boolean local = leafBrusher.isLocal();
        return local;
    }

    /**
     * @param o o
     * @param signature signature
     * @return all binding nodes
     */
    public Map<Variable<?>, Collection<OWLObject>> extractAllPossibleBindingNodes(OWLOntology o,
        Set<OWLEntity> signature) {
        Map<Variable<?>, Collection<OWLObject>> toReturn = new HashMap<>();
        List<InputVariable<?>> inputVariables = instantiatedPatternModel.getInputVariables();
        for (InputVariable<?> v : inputVariables) {
            Set<OWLObject> values = new HashSet<>();
            toReturn.put(v, values);
            if (instantiatedPatternModel.getInstantiations(v).size() == 0) {
                // no instantiations
                Set<? extends OWLObject> referencedValues =
                    v.getType().getReferencedOWLObjects(Arrays.asList(o));
                for (OWLObject bind : referencedValues) {
                    if (signature.contains(bind)) {
                        values.add(bind);
                    }
                }
                toReturn.put(v, values);
            }
        }
        return toReturn;
    }

    /**
     * @return minimal binding nodes
     */
    public Map<Variable<?>, SigmaPlusSigmaMinus> buildMinimalBindingNodes() {
        Map<Variable<?>, SigmaPlusSigmaMinus> toReturn = new HashMap<>();
        List<InputVariable<?>> inputVariables = instantiatedPatternModel.getInputVariables();
        for (Variable<?> v : inputVariables) {
            if (instantiatedPatternModel.getInstantiations(v).size() == 0) {
                SigmaPlusSigmaMinus values = new SigmaPlusSigmaMinus(
                    v.getType().accept(plusBuilder), v.getType().accept(minusBuilder));
                if (values.getPlus() != null && values.getMinus() != null) {
                    toReturn.put(v, values);
                }
            }
        }
        return toReturn;
    }

    /**
     * @return non local axioms
     */
    public List<OWLAxiom> getNonLocalAxioms() {
        return leafBrusher.getNonLocalAxioms();
    }

    /**
     * @return explored nodes
     */
    public List<BindingNode> getExploredNodes() {
        return leafBrusher.getExploredBindings();
    }

    /**
     * @return explored nodes locality
     */
    public List<Boolean> getExploredNodesLocality() {
        return leafBrusher.getExploredBindingsLocality();
    }

    /**
     * @param ontologies ontologies
     * @return collected entities
     */
    public static Set<OWLEntity> collectEntities(Set<OWLOntology> ontologies) {
        return asSet(ontologies.stream().flatMap(OWLOntology::signature));
    }

    /**
     * @return the instantiatedPatternModel
     */
    public InstantiatedPatternModel getInstantiatedPatternModel() {
        return instantiatedPatternModel;
    }

    /**
     * @return the evaluator
     */
    public LocalityEvaluator getEvaluator() {
        return evaluator;
    }

    /**
     * @param evaluator the evaluator to set
     */
    public void setEvaluator(LocalityEvaluator evaluator) {
        this.evaluator = evaluator;
    }

    /**
     * @return the entities
     */
    public Set<OWLEntity> getEntities() {
        return new HashSet<>(entities);
    }

    /**
     * @return sigma values
     */
    public Map<Variable<?>, SigmaPlusSigmaMinus> getSigmaValues() {
        return Collections.unmodifiableMap(sigmaValues);
    }

    /**
     * @return sigma minus
     */
    public Set<OWLEntity> getSigmaMinus() {
        Set<OWLEntity> externalSigmaValues = new HashSet<>();
        for (SigmaPlusSigmaMinus s : sigmaValues.values()) {
            externalSigmaValues.add(s.getMinus());
        }
        return externalSigmaValues;
    }

    /**
     * @return sigma plus
     */
    public Set<OWLEntity> getSigmaPlus() {
        Set<OWLEntity> externalSigmaValues = new HashSet<>();
        for (SigmaPlusSigmaMinus s : sigmaValues.values()) {
            externalSigmaValues.add(s.getPlus());
        }
        return externalSigmaValues;
    }

    /**
     * @return the handler
     */
    public RuntimeExceptionHandler getHandler() {
        return handler;
    }
}
