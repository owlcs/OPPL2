/**
 *
 */
package org.coode.oppl.search;

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
import org.coode.oppl.utils.DefaultOWLAxiomVisitorAdapter;
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
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLDataProperty;
import org.semanticweb.owlapi.model.OWLDatatype;
import org.semanticweb.owlapi.model.OWLEntity;
import org.semanticweb.owlapi.model.OWLEntityVisitor;
import org.semanticweb.owlapi.model.OWLIndividual;
import org.semanticweb.owlapi.model.OWLLiteral;
import org.semanticweb.owlapi.model.OWLNamedIndividual;
import org.semanticweb.owlapi.model.OWLObject;
import org.semanticweb.owlapi.model.OWLObjectProperty;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLRuntimeException;

/** @author Luigi Iannone */
public class OPPLAssertedSingleOWLAxiomSearchTree extends
        SearchTree<OPPLOWLAxiomSearchNode> {
    protected final ConstraintSystem constraintSystem;
    protected final RuntimeExceptionHandler runtimeExceptionHandler;
    protected final OWLAxiom targetAxiom;
    protected final Set<OWLClass> allClasses = new HashSet<OWLClass>();
    protected final Set<OWLObjectProperty> allObjectProperties = new HashSet<OWLObjectProperty>();
    protected final Set<OWLDataProperty> allDataProperties = new HashSet<OWLDataProperty>();
    protected final Set<OWLIndividual> allIndividuals = new HashSet<OWLIndividual>();
    protected final Set<OWLLiteral> allConstants = new HashSet<OWLLiteral>();
    protected final Set<OWLAnnotationProperty> allAnnotationProperties = new HashSet<OWLAnnotationProperty>();

    public OPPLAssertedSingleOWLAxiomSearchTree(OWLAxiom targetAxiom,
            ConstraintSystem constraintSystem,
            RuntimeExceptionHandler runtimeExceptionHandler) {
        if (constraintSystem == null) {
            throw new NullPointerException("The constraint system cannot be null");
        }
        if (runtimeExceptionHandler == null) {
            throw new NullPointerException("The runtime exception handler cannot be null");
        }
        this.targetAxiom = targetAxiom;
        this.constraintSystem = constraintSystem;
        this.runtimeExceptionHandler = runtimeExceptionHandler;
        initAssignableValues();
    }

    @Override
    protected List<OPPLOWLAxiomSearchNode> getChildren(OPPLOWLAxiomSearchNode node) {
        List<OPPLOWLAxiomSearchNode> toReturn = new ArrayList<OPPLOWLAxiomSearchNode>();
        Set<Variable<?>> variables = node.getBinding().getUnassignedVariables();
        BindingNode binding = node.getBinding();
        ValueComputationParameters parameters = new SimpleValueComputationParameters(
                getConstraintSystem(), binding, getRuntimeExceptionHandler());
        if (!variables.isEmpty()) {
            Variable<?> variable = variables.iterator().next();
            Collection<OWLObject> values = new HashSet<OWLObject>(getAssignableValues(
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
        Set<OWLObject> toReturn = new HashSet<OWLObject>();
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
        getTargetAxiom().accept(new DefaultOWLAxiomVisitorAdapter() {
            @Override
            protected void doDefault(OWLAxiom axiom) {
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

    /**
	 * 
	 */
    private void extractFromLogicAxiom() {
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

    /** @return the constraintSystem */
    public ConstraintSystem getConstraintSystem() {
        return constraintSystem;
    }

    @Override
    public boolean exhaustiveSearchTree(OPPLOWLAxiomSearchNode start,
            List<List<OPPLOWLAxiomSearchNode>> solutions) {
        if (start == null) {
            throw new NullPointerException("The starting node cannot be null");
        }
        if (solutions == null) {
            throw new NullPointerException(
                    "The list on which solutions will be stored cannot be null");
        }
        boolean found = false;
        if (getTargetAxiom().getAxiomType().equals(start.getAxiom().getAxiomType())) {
            found = super.exhaustiveSearchTree(start, solutions);
        }
        return found;
    }

    /** @return the targetAxiom */
    public OWLAxiom getTargetAxiom() {
        return targetAxiom;
    }

    /** @return the runtimeExceptionHandler */
    public RuntimeExceptionHandler getRuntimeExceptionHandler() {
        return runtimeExceptionHandler;
    }
}
