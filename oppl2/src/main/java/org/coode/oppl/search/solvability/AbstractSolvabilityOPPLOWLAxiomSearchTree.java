package org.coode.oppl.search.solvability;

import static org.coode.oppl.utils.ArgCheck.checkNotNull;
import static org.semanticweb.owlapi.util.OWLAPIStreamUtils.asList;
import static org.semanticweb.owlapi.util.OWLAPIStreamUtils.asSet;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;

import org.coode.oppl.ConstraintSystem;
import org.coode.oppl.PartialOWLObjectInstantiator;
import org.coode.oppl.Variable;
import org.coode.oppl.VariableScope;
import org.coode.oppl.VariableVisitorEx;
import org.coode.oppl.bindingtree.Assignment;
import org.coode.oppl.bindingtree.BindingNode;
import org.coode.oppl.exceptions.RuntimeExceptionHandler;
import org.coode.oppl.function.SimpleValueComputationParameters;
import org.coode.oppl.function.ValueComputationParameters;
import org.coode.oppl.generated.GeneratedVariable;
import org.coode.oppl.generated.RegexpGeneratedVariable;
import org.coode.oppl.log.Logging;
import org.coode.oppl.queryplanner.ConstantExtractor;
import org.coode.oppl.rendering.ManchesterSyntaxRenderer;
import org.coode.oppl.search.AssignableValueExtractor;
import org.coode.oppl.search.SearchTree;
import org.coode.oppl.utils.AbstractVariableVisitorExAdapter;
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
import org.semanticweb.owlapi.model.OWLAxiomVisitor;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLClassAssertionAxiom;
import org.semanticweb.owlapi.model.OWLClassExpressionVisitor;
import org.semanticweb.owlapi.model.OWLDataProperty;
import org.semanticweb.owlapi.model.OWLDataPropertyAssertionAxiom;
import org.semanticweb.owlapi.model.OWLDisjointClassesAxiom;
import org.semanticweb.owlapi.model.OWLEquivalentClassesAxiom;
import org.semanticweb.owlapi.model.OWLIndividual;
import org.semanticweb.owlapi.model.OWLLiteral;
import org.semanticweb.owlapi.model.OWLNegativeDataPropertyAssertionAxiom;
import org.semanticweb.owlapi.model.OWLObject;
import org.semanticweb.owlapi.model.OWLObjectProperty;
import org.semanticweb.owlapi.model.OWLObjectVisitor;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLRuntimeException;
import org.semanticweb.owlapi.model.OWLSubClassOfAxiom;

/**
 * @author Luigi Iannone
 */
public abstract class AbstractSolvabilityOPPLOWLAxiomSearchTree
    extends SearchTree<SolvabilitySearchNode> {

    class AcceptabilityVisitor implements VariableVisitorEx<Boolean> {
        private final OWLObject value;
        private final BindingNode binding;

        AcceptabilityVisitor(OWLObject value, BindingNode binding) {
            this.value = value;
            this.binding = binding;
        }

        @Override
        public <O extends OWLObject> Boolean visit(InputVariable<O> v) {
            try {
                return Boolean
                    .valueOf(v.getVariableScope() == null || v.getVariableScope().check(value));
            } catch (OWLRuntimeException e) {
                getRuntimeExceptionHandler().handleOWLRuntimeException(e);
                return Boolean.FALSE;
            }
        }

        @Override
        public <O extends OWLObject> Boolean visit(GeneratedVariable<O> v) {
            return Boolean.FALSE;
        }

        @Override
        public <O extends OWLObject> Boolean visit(RegexpGeneratedVariable<O> regExpGenerated) {
            ManchesterSyntaxRenderer renderer = getConstraintSystem().getOPPLFactory()
                .getManchesterSyntaxRenderer(getConstraintSystem());
            value.accept(renderer);
            Matcher matcher = regExpGenerated.getPatternGeneratingOPPLFunction()
                .compute(new SimpleValueComputationParameters(getConstraintSystem(), binding,
                    getRuntimeExceptionHandler()))
                .matcher(renderer.toString());
            return Boolean.valueOf(matcher.matches());
        }
    }

    class ScopeChecker extends AbstractVariableVisitorExAdapter<Boolean> {
        private final OWLObject owlObject;

        ScopeChecker(Boolean defaultValue, OWLObject owlObject) {
            super(defaultValue);
            this.owlObject = owlObject;
        }

        @Override
        public <P extends OWLObject> Boolean visit(InputVariable<P> v) {
            VariableScope<?> variableScope = v.getVariableScope();
            return Boolean.valueOf(variableScope == null || variableScope.check(owlObject));
        }
    }

    /** test */
    private final class ConstantCollector implements OWLAxiomVisitor {

        private final Set<OWLLiteral> toReturn;
        private final OWLClassExpressionVisitor constantExtractor;

        ConstantCollector(Set<OWLLiteral> toReturn, OWLClassExpressionVisitor constantExtractor) {
            this.toReturn = toReturn;
            this.constantExtractor = constantExtractor;
        }

        @Override
        public void visit(OWLClassAssertionAxiom axiom) {
            axiom.getClassExpression().accept(constantExtractor);
        }

        @Override
        public void visit(OWLDataPropertyAssertionAxiom axiom) {
            toReturn.add(axiom.getObject());
        }

        @Override
        public void visit(OWLDisjointClassesAxiom axiom) {
            axiom.classExpressions().forEach(c -> c.accept(constantExtractor));
        }

        @Override
        public void visit(OWLEquivalentClassesAxiom axiom) {
            axiom.classExpressions().forEach(c -> c.accept(constantExtractor));
        }

        @Override
        public void visit(OWLNegativeDataPropertyAssertionAxiom axiom) {
            toReturn.add(axiom.getObject());
        }

        @Override
        public void visit(OWLSubClassOfAxiom axiom) {
            axiom.getSubClass().accept(constantExtractor);
            axiom.getSuperClass().accept(constantExtractor);
        }
    }

    private final ConstraintSystem constraintSystem;
    private final RuntimeExceptionHandler runtimeExceptionHandler;
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
    protected final Set<OWLClass> allClasses = new HashSet<>();
    protected final Set<OWLLiteral> allConstants = new HashSet<>();
    protected final Set<OWLDataProperty> allDataProperties = new HashSet<>();
    protected final Set<OWLIndividual> allIndividuals = new HashSet<>();
    protected final Set<OWLObjectProperty> allObjectProperties = new HashSet<>();
    protected final Set<OWLAnnotationProperty> allAnnotationProperties = new HashSet<>();

    /**
     * @param constraintSystem constraintSystem
     * @param runtimeExceptionHandler runtimeExceptionHandler
     */
    public AbstractSolvabilityOPPLOWLAxiomSearchTree(ConstraintSystem constraintSystem,
        RuntimeExceptionHandler runtimeExceptionHandler) {
        this.constraintSystem = checkNotNull(constraintSystem, "constraintSystem");
        this.runtimeExceptionHandler =
            checkNotNull(runtimeExceptionHandler, "runtimeExceptionHandler");
    }

    /**
     * @return the constraintSystem
     */
    public ConstraintSystem getConstraintSystem() {
        return constraintSystem;
    }

    @Override
    protected boolean goalReached(SolvabilitySearchNode node) {
        return node.accept(new SolvabilitySearchNodeVisitorEx<Boolean>() {

            @Override
            public Boolean visitSolvedSearchNode(SolvedSearchNode solvedSearchNode) {
                return Boolean.TRUE;
            }

            @Override
            public Boolean visitNoSolutionSolvableSearchNode(
                NoSolutionSolvableSearchNode noSolutionSolvableSearchNode) {
                // I have reached a node whose children will never lead to a
                // solution. This node will have no children but will not
                // represent a solution either.
                return Boolean.FALSE;
            }

            @Override
            public Boolean visitSolvableSearchNode(SolvableSearchNode solvableSearchNode) {
                // Next round each of them may generate a bunch of solved ones.
                // I will return false so the children generation will be
                // invoked again.
                return Boolean.FALSE;
            }

            @Override
            public Boolean visitUnsolvableSearchNode(UnsolvableSearchNode unsolvableSearchNode) {
                // There is a possibility that from an unsolved node I generate
                // a leaf which is not a solved node without passing through a
                // solvable one. Hence I should provide for checks of variable
                // free nodes that are neither Solved nor Solvable. This check
                // depends on the particular kind of axiom I am searching for
                // (asserted, or inferred), therefore it will be delegated to
                // the concrete sub-class.
                return Boolean.valueOf(AbstractSolvabilityOPPLOWLAxiomSearchTree.this
                    .goalReachedUnsolvabelNode(unsolvableSearchNode));
            }
        }).booleanValue();
    }

    protected abstract boolean goalReachedUnsolvabelNode(UnsolvableSearchNode unsolvableSearchNode);

    @Override
    protected List<SolvabilitySearchNode> getChildren(SolvabilitySearchNode node) {
        return node.accept(new SolvabilitySearchNodeVisitorEx<List<SolvabilitySearchNode>>() {

            @Override
            public List<SolvabilitySearchNode> visitSolvableSearchNode(
                SolvableSearchNode solvableSearchNode) {
                Variable<?> variable = solvableSearchNode.getVariable();
                final BindingNode binding = solvableSearchNode.getBinding();
                // Need to check it is fine to assign, as regexp
                // variables might not like the value.
                return asList(solvableSearchNode.values()
                    .filter(
                        v -> variable.accept(new AcceptabilityVisitor(v, binding)).booleanValue())
                    .map(v -> findAcceptable(solvableSearchNode, variable, binding, v)));
            }

            protected SolvedSearchNode findAcceptable(SolvableSearchNode solvableSearchNode,
                Variable<?> variable, final BindingNode binding, final OWLObject value) {
                Assignment assignment = new Assignment(variable, value);
                BindingNode childBinding = new BindingNode(binding);
                childBinding.addAssignment(assignment);
                ValueComputationParameters parameters = new SimpleValueComputationParameters(
                    AbstractSolvabilityOPPLOWLAxiomSearchTree.this.getConstraintSystem(),
                    childBinding,
                    AbstractSolvabilityOPPLOWLAxiomSearchTree.this.getRuntimeExceptionHandler());
                PartialOWLObjectInstantiator instantiator =
                    new PartialOWLObjectInstantiator(parameters);
                OWLAxiom instantiatedAxiom =
                    (OWLAxiom) solvableSearchNode.getAxiom().accept(instantiator);
                return new SolvedSearchNode(instantiatedAxiom, childBinding);
            }

            @Override
            public List<SolvabilitySearchNode> visitSolvedSearchNode(
                SolvedSearchNode solvedSearchNode) {
                return Collections.emptyList();
            }

            @Override
            public List<SolvabilitySearchNode> visitUnsolvableSearchNode(
                UnsolvableSearchNode unsolvableSearchNode) {
                return AbstractSolvabilityOPPLOWLAxiomSearchTree.this
                    .getUnsolvableNodeChildren(unsolvableSearchNode);
            }

            @Override
            public List<SolvabilitySearchNode> visitNoSolutionSolvableSearchNode(
                NoSolutionSolvableSearchNode noSolutionSolvableSearchNode) {
                return Collections.emptyList();
            }
        });
    }

    protected List<SolvabilitySearchNode> getUnsolvableNodeChildren(UnsolvableSearchNode node) {
        List<SolvabilitySearchNode> toReturn = new ArrayList<>();
        VariableExtractor variableExtractor = new VariableExtractor(getConstraintSystem(), false);
        Set<Variable<?>> variables = variableExtractor.extractVariables(node.getAxiom());
        BindingNode binding = node.getBinding();
        ValueComputationParameters parameters = new SimpleValueComputationParameters(
            getConstraintSystem(), node.getBinding(), getRuntimeExceptionHandler());
        for (Variable<?> variable : variables) {
            for (OWLObject value : getAssignableValues(variable, parameters)) {
                Assignment assignment = new Assignment(variable, value);
                BindingNode childBinding = new BindingNode(binding);
                childBinding.addAssignment(assignment);
                ValueComputationParameters newParameters = new SimpleValueComputationParameters(
                    getConstraintSystem(), childBinding, getRuntimeExceptionHandler());
                PartialOWLObjectInstantiator instantiator =
                    new PartialOWLObjectInstantiator(newParameters);
                OWLAxiom instantiatedAxiom = (OWLAxiom) node.getAxiom().accept(instantiator);
                SolvabilitySearchNode child = SolvabilitySearchNode.buildSolvabilitySearchNode(
                    instantiatedAxiom, getAxiomSolvability(), childBinding);
                toReturn.add(child);
            }
        }
        return toReturn;
    }

    private Collection<? extends OWLObject> getAssignableValues(Variable<?> variable,
        ValueComputationParameters parameters) {
        try {
            return asSet(variable
                .accept(new AssignableValueExtractor(assignableValuesVisitor, parameters)).stream()
                .filter(o -> variable.accept(new ScopeChecker(Boolean.TRUE, o)).booleanValue()));
        } catch (OWLRuntimeException e) {
            getRuntimeExceptionHandler().handleOWLRuntimeException(e);
            return Collections.emptyList();
        }
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
            Integer.valueOf(allConstants.size()));
    }

    private Collection<OWLClass> getAllClasses() {
        return asList(getConstraintSystem().getOntologyManager().ontologies()
            .flatMap(OWLOntology::classesInSignature).distinct());
    }

    private Collection<OWLLiteral> getAllConstants() {
        final Set<OWLLiteral> toReturn = new HashSet<>();
        final OWLObjectVisitor constantExtractor = new ConstantExtractor(toReturn);
        ConstantCollector visitor = new ConstantCollector(toReturn, constantExtractor);
        getConstraintSystem().getOntologyManager().ontologies().flatMap(OWLOntology::axioms)
            .forEach(a -> a.accept(visitor));
        return toReturn;
    }

    private Collection<OWLDataProperty> getAllDataProperties() {
        return asList(getConstraintSystem().getOntologyManager().ontologies()
            .flatMap(OWLOntology::dataPropertiesInSignature));
    }

    private Collection<OWLIndividual> getAllIndividuals() {
        return asSet(getConstraintSystem().getOntologyManager().ontologies()
            .flatMap(OWLOntology::individualsInSignature));
    }

    private Collection<OWLObjectProperty> getObjectProperties() {
        return asSet(getConstraintSystem().getOntologyManager().ontologies()
            .flatMap(OWLOntology::objectPropertiesInSignature));
    }

    @Override
    public boolean exhaustiveSearchTree(SolvabilitySearchNode start,
        List<List<SolvabilitySearchNode>> solutions) {
        initAssignableValues();
        return super.exhaustiveSearchTree(start, solutions);
    }

    protected abstract AxiomSolvability getAxiomSolvability();

    /**
     * @param axiom axiom
     * @param bindingNode bindingNode
     * @return solvability search node
     */
    public SolvabilitySearchNode buildSolvabilitySearchNode(OWLAxiom axiom,
        BindingNode bindingNode) {
        return SolvabilitySearchNode.buildSolvabilitySearchNode(axiom, getAxiomSolvability(),
            bindingNode);
    }

    /**
     * @return the runtimeExceptionHandler
     */
    public RuntimeExceptionHandler getRuntimeExceptionHandler() {
        return runtimeExceptionHandler;
    }

    private Set<OWLAnnotationProperty> getAllAnnotationProperties() {
        return asSet(getConstraintSystem().getOntologyManager().ontologies()
            .flatMap(OWLOntology::annotationPropertiesInSignature));
    }
}
