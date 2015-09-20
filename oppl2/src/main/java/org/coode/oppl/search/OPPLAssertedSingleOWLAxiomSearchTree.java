package org.coode.oppl.search;

import static org.coode.oppl.utils.ArgCheck.checkNotNull;

import java.util.*;

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
import org.coode.oppl.variabletypes.*;
import org.semanticweb.owlapi.model.*;
import org.semanticweb.owlapi.util.OWLAxiomVisitorAdapter;

/**
 * @author Luigi Iannone
 */
public class OPPLAssertedSingleOWLAxiomSearchTree extends
    SearchTree<OPPLOWLAxiomSearchNode> {

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
     * @param targetAxiom
     *        targetAxiom
     * @param constraintSystem
     *        constraintSystem
     * @param runtimeExceptionHandler
     *        runtimeExceptionHandler
     */
    public OPPLAssertedSingleOWLAxiomSearchTree(OWLAxiom targetAxiom,
        ConstraintSystem constraintSystem,
        RuntimeExceptionHandler runtimeExceptionHandler) {
        this.constraintSystem = checkNotNull(constraintSystem, "constraintSystem");
        this.runtimeExceptionHandler = checkNotNull(runtimeExceptionHandler,
            "runtimeExceptionHandler");
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
            Collection<OWLObject> values = new HashSet<>(getAssignableValues(
                variable, parameters));
            for (OWLObject value : values) {
                Assignment assignment = new Assignment(variable, value);
                BindingNode childBinding = new BindingNode(binding);
                childBinding.addAssignment(assignment);
                ValueComputationParameters childParameters = new SimpleValueComputationParameters(
                    getConstraintSystem(), childBinding, getRuntimeExceptionHandler());
                PartialOWLObjectInstantiator instantiator = new PartialOWLObjectInstantiator(
                    childParameters);
                OWLAxiom instantiatedAxiom = (OWLAxiom) node.getAxiom().accept(
                    instantiator);
                OPPLOWLAxiomSearchNode child = new OPPLOWLAxiomSearchNode(
                    instantiatedAxiom, childBinding);
                toReturn.add(child);
            }
        }
        return toReturn;
    }

    @Override
    protected boolean goalReached(OPPLOWLAxiomSearchNode start) {
        return targetAxiom.getAxiomWithoutAnnotations().equals(start.getAxiom());
    }

    private final VariableTypeVisitorEx<Set<? extends OWLObject>> assignableValuesVisitor = new VariableTypeVisitorEx<Set<? extends OWLObject>>() {

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
        toReturn.addAll(variable.accept(new AssignableValueExtractor(
            assignableValuesVisitor, parameters)));
        Iterator<OWLObject> iterator = toReturn.iterator();
        while (iterator.hasNext()) {
            final OWLObject owlObject = iterator.next();
            boolean inScope = variable
                .accept(new AbstractVariableVisitorExAdapter<Boolean>(true) {

                    @Override
                    public <P extends OWLObject> Boolean visit(InputVariable<P> v) {
                        VariableScope<?> variableScope = v.getVariableScope();
                        try {
                            return variableScope == null
                                || variableScope.check(owlObject);
                        } catch (OWLRuntimeException e) {
                            OPPLAssertedSingleOWLAxiomSearchTree.this
                                .getRuntimeExceptionHandler()
                                .handleOWLRuntimeException(e);
                            return false;
                        }
                    }
                });
            if (!inScope) {
                iterator.remove();
            }
        }
        return toReturn;
    }

    private void initAssignableValues() {
        extractFromLogicAxiom();
        getTargetAxiom().accept(new OWLAxiomVisitorAdapter() {

            @Override
            protected void handleDefault(OWLObject axiom) {
                OPPLAssertedSingleOWLAxiomSearchTree.this.extractFromLogicAxiom();
            }

            @Override
            public void visit(OWLAnnotationAssertionAxiom axiom) {
                OPPLAssertedSingleOWLAxiomSearchTree.this.extractFromLogicAxiom();
                OWLAnnotationSubject subject = axiom.getSubject();
                subject.accept(new OWLAnnotationSubjectVisitor() {

                    @Override
                    public void visit(OWLAnonymousIndividual individual) {}

                    @Override
                    public void visit(IRI iri) {
                        Set<OWLOntology> ontologies = OPPLAssertedSingleOWLAxiomSearchTree.this
                            .getConstraintSystem().getOntologyManager()
                            .getOntologies();
                        for (OWLOntology ontology : ontologies) {
                            Set<OWLEntity> entitiesInSignature = ontology
                                .getEntitiesInSignature(iri);
                            for (OWLEntity entity : entitiesInSignature) {
                                entity.accept(new OWLEntityVisitor() {

                                    @Override
                                    public void visit(OWLAnnotationProperty property) {
                                        // TODO Auto-generated method stub
                                    }

                                    @Override
                                    public void visit(OWLDatatype datatype) {}

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
                                });
                            }
                        }
                    }
                });
            }
        });
    }

    protected void extractFromLogicAxiom() {
        allClasses.addAll(OWLObjectExtractor.getAllClasses(getTargetAxiom()));
        allDataProperties.addAll(OWLObjectExtractor
            .getAllOWLDataProperties(getTargetAxiom()));
        allObjectProperties.addAll(OWLObjectExtractor
            .getAllOWLObjectProperties(getTargetAxiom()));
        allIndividuals.addAll(OWLObjectExtractor.getAllOWLIndividuals(getTargetAxiom()));
        allConstants.addAll(OWLObjectExtractor.getAllOWLLiterals(getTargetAxiom()));
        allAnnotationProperties.addAll(OWLObjectExtractor
            .getAllAnnotationProperties(getTargetAxiom()));
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
