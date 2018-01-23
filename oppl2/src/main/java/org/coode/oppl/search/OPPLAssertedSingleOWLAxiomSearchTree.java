package org.coode.oppl.search;

import static org.coode.oppl.utils.ArgCheck.checkNotNull;
import static org.semanticweb.owlapi.util.OWLAPIStreamUtils.add;

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
import org.coode.oppl.utils.AbstractVariableVisitorExAdapter;
import org.coode.oppl.utils.OWLObjectExtractor;
import org.coode.oppl.variabletypes.ANNOTATIONPROPERTYVariableType;
import org.coode.oppl.variabletypes.CLASSVariableType;
import org.coode.oppl.variabletypes.CONSTANTVariableType;
import org.coode.oppl.variabletypes.DATAPROPERTYVariableType;
import org.coode.oppl.variabletypes.INDIVIDUALVariableType;
import org.coode.oppl.variabletypes.InputVariable;
import org.coode.oppl.variabletypes.OBJECTPROPERTYVariableType;
import org.coode.oppl.variabletypes.VariableTypeVisitorEx;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLAnnotationAssertionAxiom;
import org.semanticweb.owlapi.model.OWLAnnotationProperty;
import org.semanticweb.owlapi.model.OWLAnnotationSubject;
import org.semanticweb.owlapi.model.OWLAnnotationSubjectVisitor;
import org.semanticweb.owlapi.model.OWLAnonymousIndividual;
import org.semanticweb.owlapi.model.OWLAxiom;
import org.semanticweb.owlapi.model.OWLAxiomVisitor;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLDataProperty;
import org.semanticweb.owlapi.model.OWLEntityVisitor;
import org.semanticweb.owlapi.model.OWLIndividual;
import org.semanticweb.owlapi.model.OWLLiteral;
import org.semanticweb.owlapi.model.OWLNamedIndividual;
import org.semanticweb.owlapi.model.OWLObject;
import org.semanticweb.owlapi.model.OWLObjectProperty;
import org.semanticweb.owlapi.model.OWLRuntimeException;

/**
 * @author Luigi Iannone
 */
public class OPPLAssertedSingleOWLAxiomSearchTree extends SearchTree<OPPLOWLAxiomSearchNode> {

    protected final ConstraintSystem constraintSystem;
    protected final RuntimeExceptionHandler runtimeExceptionHandler;
    protected final OWLAxiom targetAxiom;
    protected final Set<OWLClass> allClasses = new HashSet<>();
    protected final Set<OWLObjectProperty> allObjectProperties = new HashSet<>();
    protected final Set<OWLDataProperty> allDataProperties = new HashSet<>();
    protected final Set<OWLIndividual> allIndividuals = new HashSet<>();
    protected final Set<OWLLiteral> allConstants = new HashSet<>();
    protected final Set<OWLAnnotationProperty> allAnnotationProperties = new HashSet<>();

    /**
     * @param targetAxiom targetAxiom
     * @param constraintSystem constraintSystem
     * @param runtimeExceptionHandler runtimeExceptionHandler
     */
    public OPPLAssertedSingleOWLAxiomSearchTree(OWLAxiom targetAxiom,
        ConstraintSystem constraintSystem, RuntimeExceptionHandler runtimeExceptionHandler) {
        this.constraintSystem = checkNotNull(constraintSystem, "constraintSystem");
        this.runtimeExceptionHandler =
            checkNotNull(runtimeExceptionHandler, "runtimeExceptionHandler");
        this.targetAxiom = targetAxiom;
        initAssignableValues();
    }

    @Override
    protected List<OPPLOWLAxiomSearchNode> getChildren(OPPLOWLAxiomSearchNode node) {
        List<OPPLOWLAxiomSearchNode> toReturn = new ArrayList<>();
        Set<Variable<?>> variables = node.getBinding().getUnassignedVariables();
        BindingNode binding = node.getBinding();
        ValueComputationParameters parameters = new SimpleValueComputationParameters(
            getConstraintSystem(), binding, getRuntimeExceptionHandler());
        if (!variables.isEmpty()) {
            Variable<?> variable = variables.iterator().next();
            Collection<OWLObject> values = new HashSet<>(getAssignableValues(variable, parameters));
            for (OWLObject value : values) {
                Assignment assignment = new Assignment(variable, value);
                BindingNode childBinding = new BindingNode(binding);
                childBinding.addAssignment(assignment);
                ValueComputationParameters childParameters = new SimpleValueComputationParameters(
                    getConstraintSystem(), childBinding, getRuntimeExceptionHandler());
                PartialOWLObjectInstantiator instantiator =
                    new PartialOWLObjectInstantiator(childParameters);
                OWLAxiom instantiatedAxiom = (OWLAxiom) node.getAxiom().accept(instantiator);
                OPPLOWLAxiomSearchNode child =
                    new OPPLOWLAxiomSearchNode(instantiatedAxiom, childBinding);
                toReturn.add(child);
            }
        }
        return toReturn;
    }

    @Override
    protected boolean goalReached(OPPLOWLAxiomSearchNode start) {
        return targetAxiom.getAxiomWithoutAnnotations().equals(start.getAxiom());
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
            AbstractVariableVisitorExAdapter<Boolean> variableVisitor =
                new AbstractVariableVisitorExAdapter<Boolean>(Boolean.TRUE) {

                    @Override
                    public <P extends OWLObject> Boolean visit(InputVariable<P> v) {
                        VariableScope<?> variableScope = v.getVariableScope();
                        try {
                            return Boolean
                                .valueOf(variableScope == null || variableScope.check(owlObject));
                        } catch (OWLRuntimeException e) {
                            OPPLAssertedSingleOWLAxiomSearchTree.this.getRuntimeExceptionHandler()
                                .handleOWLRuntimeException(e);
                            return Boolean.FALSE;
                        }
                    }
                };
            boolean inScope = variable.accept(variableVisitor).booleanValue();
            if (!inScope) {
                iterator.remove();
            }
        }
        return toReturn;
    }

    private void initAssignableValues() {
        extractFromLogicAxiom();
        getTargetAxiom().accept(axiomVisitor);
    }

    OWLAxiomVisitor axiomVisitor = new OWLAxiomVisitor() {

        @Override
        public void doDefault(Object axiom) {
            OPPLAssertedSingleOWLAxiomSearchTree.this.extractFromLogicAxiom();
        }

        @Override
        public void visit(OWLAnnotationAssertionAxiom axiom) {
            OPPLAssertedSingleOWLAxiomSearchTree.this.extractFromLogicAxiom();
            OWLAnnotationSubject subject = axiom.getSubject();
            subject.accept(annVisitor);
        }
    };
    protected OWLEntityVisitor iriVisitor = new OWLEntityVisitor() {

        @Override
        public void visit(OWLNamedIndividual individual) {
            allIndividuals.add(individual);
        }

        @Override
        public void visit(OWLDataProperty property) {
            allDataProperties.add(property);
        }

        @Override
        public void visit(OWLObjectProperty property) {
            allObjectProperties.add(property);
        }

        @Override
        public void visit(OWLClass cls) {
            allClasses.add(cls);
        }
    };
    protected OWLAnnotationSubjectVisitor annVisitor = new OWLAnnotationSubjectVisitor() {

        @Override
        public void visit(OWLAnonymousIndividual individual) {}

        @Override
        public void visit(IRI iri) {
            OPPLAssertedSingleOWLAxiomSearchTree.this.getConstraintSystem().getOntologyManager()
                .ontologies().flatMap(o -> o.entitiesInSignature(iri))
                .forEach(e -> e.accept(iriVisitor));
        }
    };

    protected void extractFromLogicAxiom() {
        add(allClasses, OWLObjectExtractor.getAllClasses(getTargetAxiom()));
        add(allDataProperties, OWLObjectExtractor.getAllOWLDataProperties(getTargetAxiom()));
        add(allObjectProperties, OWLObjectExtractor.getAllOWLObjectProperties(getTargetAxiom()));
        add(allIndividuals, OWLObjectExtractor.getAllOWLIndividuals(getTargetAxiom()));
        add(allConstants, OWLObjectExtractor.getAllOWLLiterals(getTargetAxiom()));
        add(allAnnotationProperties,
            OWLObjectExtractor.getAllAnnotationProperties(getTargetAxiom()));
    }

    /**
     * @return the constraintSystem
     */
    public ConstraintSystem getConstraintSystem() {
        return constraintSystem;
    }

    @Override
    public boolean exhaustiveSearchTree(OPPLOWLAxiomSearchNode start,
        List<List<OPPLOWLAxiomSearchNode>> solutions) {
        checkNotNull(start, "start");
        checkNotNull(solutions, "solutions");
        boolean found = false;
        if (getTargetAxiom().getAxiomType().equals(start.getAxiom().getAxiomType())) {
            found = super.exhaustiveSearchTree(start, solutions);
        }
        return found;
    }

    /**
     * @return the targetAxiom
     */
    public OWLAxiom getTargetAxiom() {
        return targetAxiom;
    }

    /**
     * @return the runtimeExceptionHandler
     */
    public RuntimeExceptionHandler getRuntimeExceptionHandler() {
        return runtimeExceptionHandler;
    }
}
