package org.coode.oppl.search;

import static org.coode.oppl.utils.ArgCheck.checkNotNull;
import static org.semanticweb.owlapi.util.OWLAPIStreamUtils.asSet;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

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

    class ScopeChecker extends AbstractVariableVisitorExAdapter<Boolean> {
        private final OWLObject owlObject;

        ScopeChecker(Boolean defaultValue, OWLObject owlObject) {
            super(defaultValue);
            this.owlObject = owlObject;
        }

        @Override
        public <P extends OWLObject> Boolean visit(InputVariable<P> v) {
            VariableScope<?> variableScope = v.getVariableScope();
            try {
                return Boolean.valueOf(variableScope == null || variableScope.check(owlObject));
            } catch (OWLRuntimeException e) {
                getRuntimeExceptionHandler().handleOWLRuntimeException(e);
                return Boolean.FALSE;
            }
        }
    }

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
            for (OWLObject value : getAssignableValues(variable, parameters)) {
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
        return asSet(getConstraintSystem().getOntologyManager().ontologies()
            .flatMap(OWLOntology::classesInSignature));
    }

    private Collection<OWLLiteral> getAllConstants() {
        Set<OWLLiteral> toReturn = new HashSet<>();
        OWLObjectVisitor constantExtractor = new ConstantExtractor(toReturn);
        ConstantCollector visitor = new ConstantCollector(toReturn, constantExtractor);
        getConstraintSystem().getOntologyManager().ontologies().flatMap(OWLOntology::axioms)
            .forEach(a -> a.accept(visitor));
        return toReturn;
    }

    private Collection<OWLDataProperty> getAllDataProperties() {
        return asSet(getConstraintSystem().getOntologyManager().ontologies()
            .flatMap(OWLOntology::dataPropertiesInSignature));
    }

    private Collection<OWLIndividual> getAllIndividuals() {
        return asSet(getConstraintSystem().getOntologyManager().ontologies()
            .flatMap(OWLOntology::individualsInSignature));
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
        return asSet(variable
            .accept(new AssignableValueExtractor(assignableValuesVisitor, parameters)).stream()
            .filter(o -> variable.accept(new ScopeChecker(Boolean.TRUE, o)).booleanValue()));
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
        return asSet(getConstraintSystem().getOntologyManager().ontologies()
            .flatMap(OWLOntology::annotationPropertiesInSignature));
    }

    /**
     * @return the constraintSystem
     */
    public ConstraintSystem getConstraintSystem() {
        return constraintSystem;
    }

    private Collection<OWLObjectProperty> getObjectProperties() {
        return asSet(getConstraintSystem().getOntologyManager().ontologies()
            .flatMap(OWLOntology::objectPropertiesInSignature));
    }

    @Override
    public boolean exhaustiveSearchTree(OPPLOWLAxiomSearchNode start,
        List<List<OPPLOWLAxiomSearchNode>> solutions) {
        initAssignableValues();
        if (getConstraintSystem().leavesCount() > 0) {
            AtomicBoolean found = new AtomicBoolean(false);
            Logging.getQueryTestLogging().fine("Existing leaves count: ",
                Integer.valueOf(getConstraintSystem().leavesCount()));
            getConstraintSystem().leaves().forEach(bindingNode -> found.compareAndSet(false,
                nextElement(start, solutions, bindingNode)));
            return found.get();
        }
        return super.exhaustiveSearchTree(start, solutions);
    }

    protected boolean nextElement(OPPLOWLAxiomSearchNode start,
        List<List<OPPLOWLAxiomSearchNode>> solutions, BindingNode bindingNode) {
        ValueComputationParameters parameters = new SimpleValueComputationParameters(
            getConstraintSystem(), bindingNode, getRuntimeExceptionHandler());
        PartialOWLObjectInstantiator partialObjectInstantiator =
            new PartialOWLObjectInstantiator(parameters);
        OWLAxiom newStartAxiom = (OWLAxiom) start.getAxiom().accept(partialObjectInstantiator);
        VariableExtractor variableExtractor = new VariableExtractor(getConstraintSystem(), false);
        BindingNode newBindingNode = new BindingNode(bindingNode.getAssignments(),
            variableExtractor.extractVariables(newStartAxiom));
        OPPLOWLAxiomSearchNode newStart = new OPPLOWLAxiomSearchNode(newStartAxiom, newBindingNode);
        List<List<OPPLOWLAxiomSearchNode>> bindingNodeSolutions = new ArrayList<>();
        boolean bindingNodeSearch = super.exhaustiveSearchTree(newStart, bindingNodeSolutions);
        if (bindingNodeSearch) {
            solutions.addAll(bindingNodeSolutions);
        }
        return bindingNodeSearch;
    }

    /**
     * @return the runtimeExceptionHandler
     */
    public RuntimeExceptionHandler getRuntimeExceptionHandler() {
        return runtimeExceptionHandler;
    }
}
