package org.coode.oppl.search;

import static org.coode.oppl.utils.ArgCheck.checkNotNull;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.coode.oppl.ConstraintSystem;
import org.coode.oppl.PartialOWLObjectInstantiator;
import org.coode.oppl.Variable;
import org.coode.oppl.VariableScope;
import org.coode.oppl.bindingtree.Assignment;
import org.coode.oppl.bindingtree.BindingNode;
import org.coode.oppl.exceptions.RuntimeExceptionHandler;
import org.coode.oppl.function.SimpleValueComputationParameters;
import org.coode.oppl.function.ValueComputationParameters;
import org.coode.oppl.log.Logging;
import org.coode.oppl.queryplanner.ConstantExtractor;
import org.coode.oppl.utils.AbstractVariableVisitorExAdapter;
import org.coode.oppl.utils.ConstantCollector;
import org.coode.oppl.utils.VariableExtractor;
import org.coode.oppl.variabletypes.ANNOTATIONPROPERTYVariableType;
import org.coode.oppl.variabletypes.CLASSVariableType;
import org.coode.oppl.variabletypes.CONSTANTVariableType;
import org.coode.oppl.variabletypes.DATAPROPERTYVariableType;
import org.coode.oppl.variabletypes.INDIVIDUALVariableType;
import org.coode.oppl.variabletypes.InputVariable;
import org.coode.oppl.variabletypes.OBJECTPROPERTYVariableType;
import org.coode.oppl.variabletypes.VariableTypeVisitorEx;
import org.semanticweb.owlapi.model.OWLAnnotationProperty;
import org.semanticweb.owlapi.model.OWLAxiom;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLDataProperty;
import org.semanticweb.owlapi.model.OWLIndividual;
import org.semanticweb.owlapi.model.OWLLiteral;
import org.semanticweb.owlapi.model.OWLObject;
import org.semanticweb.owlapi.model.OWLObjectProperty;
import org.semanticweb.owlapi.model.OWLObjectVisitor;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLRuntimeException;

/** axiom search tree */
public abstract class AbstractOPPLAxiomSearchTree extends SearchTree<OPPLOWLAxiomSearchNode> {

    private final ConstraintSystem constraintSystem;
    private final RuntimeExceptionHandler runtimeExceptionHandler;
    protected final Set<OWLClass> allClasses = new HashSet<>();
    protected final Set<OWLObjectProperty> allObjectProperties = new HashSet<>();
    protected final Set<OWLAnnotationProperty> allAnnotationProperties = new HashSet<>();
    protected final Set<OWLDataProperty> allDataProperties = new HashSet<>();
    protected final Set<OWLIndividual> allIndividuals = new HashSet<>();
    protected final Set<OWLLiteral> allConstants = new HashSet<>();

    protected AbstractOPPLAxiomSearchTree(ConstraintSystem constraintSystem,
        RuntimeExceptionHandler runtimeExceptionHandler) {
        this.constraintSystem = checkNotNull(constraintSystem, "constraintSystem");
        this.runtimeExceptionHandler =
            checkNotNull(runtimeExceptionHandler, "runtimeExceptionHandler");
    }

    @Override
    protected abstract boolean goalReached(OPPLOWLAxiomSearchNode start);

    @Override
    protected List<OPPLOWLAxiomSearchNode> getChildren(OPPLOWLAxiomSearchNode node) {
        List<OPPLOWLAxiomSearchNode> toReturn = new ArrayList<>();
        Set<Variable<?>> variables = node.getBinding().getUnassignedVariables();
        BindingNode binding = node.getBinding();
        ValueComputationParameters parameters = new SimpleValueComputationParameters(
            getConstraintSystem(), node.getBinding(), getRuntimeExceptionHandler());
        if (!variables.isEmpty()) {
            Variable<?> variable = variables.iterator().next();
            Set<OWLObject> values = new HashSet<>();
            values.addAll(getAssignableValues(variable, parameters));
            for (OWLObject value : values) {
                Assignment assignment = new Assignment(variable, value);
                BindingNode childBinding = new BindingNode(binding);
                childBinding.addAssignment(assignment);
                ValueComputationParameters newParameters = new SimpleValueComputationParameters(
                    getConstraintSystem(), childBinding, getRuntimeExceptionHandler());
                PartialOWLObjectInstantiator instantiator =
                    new PartialOWLObjectInstantiator(newParameters);
                OWLAxiom instantiatedAxiom = (OWLAxiom) node.getAxiom().accept(instantiator);
                OPPLOWLAxiomSearchNode child =
                    new OPPLOWLAxiomSearchNode(instantiatedAxiom, childBinding);
                toReturn.add(child);
            }
        }
        return toReturn;
    }

    private Collection<OWLClass> getAllClasses() {
        Set<OWLClass> toReturn = new HashSet<>();
        for (OWLOntology owlOntology : getConstraintSystem().getOntologyManager().getOntologies()) {
            toReturn.addAll(owlOntology.getClassesInSignature());
        }
        return toReturn;
    }

    private Collection<OWLLiteral> getAllConstants() {
        Set<OWLLiteral> toReturn = new HashSet<>();
        OWLObjectVisitor constantExtractor = new ConstantExtractor(toReturn);
        ConstantCollector visitor = new ConstantCollector(toReturn, constantExtractor);
        for (OWLOntology owlOntology : getConstraintSystem().getOntologyManager().getOntologies()) {
            for (OWLAxiom axiomToVisit : owlOntology.getAxioms()) {
                axiomToVisit.accept(visitor);
            }
        }
        return toReturn;
    }

    private Collection<OWLDataProperty> getAllDataProperties() {
        Set<OWLDataProperty> toReturn = new HashSet<>();
        for (OWLOntology owlOntology : getConstraintSystem().getOntologyManager().getOntologies()) {
            toReturn.addAll(owlOntology.getDataPropertiesInSignature());
        }
        return toReturn;
    }

    private Collection<OWLIndividual> getAllIndividuals() {
        Set<OWLIndividual> toReturn = new HashSet<>();
        for (OWLOntology owlOntology : getConstraintSystem().getOntologyManager().getOntologies()) {
            toReturn.addAll(owlOntology.getIndividualsInSignature());
        }
        return toReturn;
    }

    private final VariableTypeVisitorEx<Set<? extends OWLObject>> assignableValuesVisitor =
        new VariableTypeVisitorEx<Set<? extends OWLObject>>() {

            @Override
            public Set<? extends OWLObject> visitCLASSVariableType(
                CLASSVariableType classVariableType) {
                return allClasses;
            }

            @Override
            public Set<? extends OWLObject> visitOBJECTPROPERTYVariableType(
                OBJECTPROPERTYVariableType objectpropertyVariableType) {
                return allObjectProperties;
            }

            @Override
            public Set<? extends OWLObject> visitDATAPROPERTYVariableType(
                DATAPROPERTYVariableType datapropertyVariableType) {
                return allDataProperties;
            }

            @Override
            public Set<? extends OWLObject> visitINDIVIDUALVariableType(
                INDIVIDUALVariableType individualVariableType) {
                return allIndividuals;
            }

            @Override
            public Set<? extends OWLObject> visitCONSTANTVariableType(
                CONSTANTVariableType constantVariableType) {
                return allConstants;
            }

            @Override
            public Set<? extends OWLObject> visitANNOTATIONPROPERTYVariableType(
                ANNOTATIONPROPERTYVariableType annotationpropertyVariableType) {
                return allAnnotationProperties;
            }
        };

    private Collection<? extends OWLObject> getAssignableValues(Variable<?> variable,
        ValueComputationParameters parameters) {
        Set<OWLObject> toReturn = new HashSet<>();
        toReturn.addAll(
            variable.accept(new AssignableValueExtractor(assignableValuesVisitor, parameters)));
        Iterator<OWLObject> iterator = toReturn.iterator();
        while (iterator.hasNext()) {
            final OWLObject owlObject = iterator.next();
            boolean inScope =
                variable.accept(new AbstractVariableVisitorExAdapter<Boolean>(Boolean.TRUE) {

                    @Override
                    public <P extends OWLObject> Boolean visit(InputVariable<P> v) {
                        VariableScope<?> variableScope = v.getVariableScope();
                        try {
                            return Boolean
                                .valueOf(variableScope == null || variableScope.check(owlObject));
                        } catch (OWLRuntimeException e) {
                            AbstractOPPLAxiomSearchTree.this.getRuntimeExceptionHandler()
                                .handleOWLRuntimeException(e);
                            return Boolean.FALSE;
                        }
                    }
                }).booleanValue();
            if (!inScope) {
                iterator.remove();
            }
        }
        return toReturn;
    }

    private void initAssignableValues() {
        allClasses.addAll(getAllClasses());
        Logging.getQueryLogger().fine("Possible class values ", Integer.valueOf(allClasses.size()));
        allDataProperties.addAll(getAllDataProperties());
        Logging.getQueryLogger().fine("Possible data property values ",
            Integer.valueOf(allDataProperties.size()));
        allObjectProperties.addAll(getObjectProperties());
        Logging.getQueryLogger().fine("Possible object property values ",
            Integer.valueOf(allObjectProperties.size()));
        allIndividuals.addAll(getAllIndividuals());
        Logging.getQueryLogger().fine("Possible individual  values ",
            Integer.valueOf(allIndividuals.size()));
        allConstants.addAll(getAllConstants());
        Logging.getQueryLogger().fine("Possible constant  values ",
            Integer.valueOf(allConstants.size()));
        allAnnotationProperties.addAll(getAllAnnotationProperties());
        Logging.getQueryLogger().fine("Possible annotation properties values ",
            Integer.valueOf(allAnnotationProperties.size()));
    }

    private Set<OWLAnnotationProperty> getAllAnnotationProperties() {
        Set<OWLAnnotationProperty> toReturn = new HashSet<>();
        for (OWLOntology ontology : getConstraintSystem().getOntologyManager().getOntologies()) {
            toReturn.addAll(ontology.getAnnotationPropertiesInSignature());
        }
        return toReturn;
    }

    /**
     * @return the constraintSystem
     */
    public ConstraintSystem getConstraintSystem() {
        return constraintSystem;
    }

    private Collection<OWLObjectProperty> getObjectProperties() {
        Set<OWLObjectProperty> toReturn = new HashSet<>();
        for (OWLOntology owlOntology : getConstraintSystem().getOntologyManager().getOntologies()) {
            toReturn.addAll(owlOntology.getObjectPropertiesInSignature());
        }
        return toReturn;
    }

    @Override
    public boolean exhaustiveSearchTree(OPPLOWLAxiomSearchNode start,
        List<List<OPPLOWLAxiomSearchNode>> solutions) {
        initAssignableValues();
        Set<BindingNode> existingLeaves = getConstraintSystem().getLeaves();
        boolean found = false;
        if (existingLeaves != null) {
            Logging.getQueryTestLogging().fine("Existing leaves count: ",
                Integer.valueOf(existingLeaves.size()));
            int leafIndex = 1;
            for (BindingNode bindingNode : existingLeaves) {
                Logging.getQueryTestLogging().fine("Exhaustive search on leaf: ",
                    Integer.valueOf(leafIndex), " out of ", Integer.valueOf(existingLeaves.size()));
                leafIndex++;
                ValueComputationParameters parameters = new SimpleValueComputationParameters(
                    getConstraintSystem(), bindingNode, getRuntimeExceptionHandler());
                PartialOWLObjectInstantiator partialObjectInstantiator =
                    new PartialOWLObjectInstantiator(parameters);
                OWLAxiom newStartAxiom =
                    (OWLAxiom) start.getAxiom().accept(partialObjectInstantiator);
                VariableExtractor variableExtractor =
                    new VariableExtractor(getConstraintSystem(), false);
                BindingNode newBindingNode = new BindingNode(bindingNode.getAssignments(),
                    variableExtractor.extractVariables(newStartAxiom));
                OPPLOWLAxiomSearchNode newStart =
                    new OPPLOWLAxiomSearchNode(newStartAxiom, newBindingNode);
                List<List<OPPLOWLAxiomSearchNode>> bindingNodeSolutions = new ArrayList<>();
                boolean bindingNodeSearch =
                    super.exhaustiveSearchTree(newStart, bindingNodeSolutions);
                found = found || bindingNodeSearch;
                if (bindingNodeSearch) {
                    solutions.addAll(bindingNodeSolutions);
                }
            }
        } else {
            found = super.exhaustiveSearchTree(start, solutions);
        }
        Set<BindingNode> newLeaves = new HashSet<>();
        for (List<OPPLOWLAxiomSearchNode> path : solutions) {
            OPPLOWLAxiomSearchNode leafSerachNode = path.get(path.size() - 1);
            BindingNode newLeaf = leafSerachNode.getBinding();
            newLeaves.add(newLeaf);
        }
        // this.constraintSystem.setLeaves(newLeaves);
        return found;
    }

    /**
     * @return the runtimeExceptionHandler
     */
    public RuntimeExceptionHandler getRuntimeExceptionHandler() {
        return runtimeExceptionHandler;
    }
}
