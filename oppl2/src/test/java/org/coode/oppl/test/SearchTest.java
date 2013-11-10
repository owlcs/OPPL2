package org.coode.oppl.test;

import static org.coode.oppl.Ontologies.*;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.coode.oppl.ConstraintSystem;
import org.coode.oppl.OPPLParser;
import org.coode.oppl.OPPLScript;
import org.coode.oppl.ParserFactory;
import org.coode.oppl.PartialOWLObjectInstantiator;
import org.coode.oppl.Variable;
import org.coode.oppl.bindingtree.Assignment;
import org.coode.oppl.bindingtree.BindingNode;
import org.coode.oppl.exceptions.QuickFailRuntimeExceptionHandler;
import org.coode.oppl.exceptions.RuntimeExceptionHandler;
import org.coode.oppl.function.SimpleValueComputationParameters;
import org.coode.oppl.function.ValueComputationParameters;
import org.coode.oppl.search.OWLAxiomSearchTree;
import org.coode.oppl.search.SearchTree;
import org.coode.oppl.utils.VariableExtractor;
import org.coode.oppl.variabletypes.VariableTypeVisitorEx;
import org.coode.parsers.ErrorListener;
import org.coode.parsers.test.JUnitTestErrorListener;
import org.junit.Before;
import org.junit.Test;
import org.semanticweb.owlapi.io.OWLFunctionalSyntaxOntologyFormat;
import org.semanticweb.owlapi.io.SystemOutDocumentTarget;
import org.semanticweb.owlapi.model.AxiomType;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLAxiom;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLClassExpression;
import org.semanticweb.owlapi.model.OWLObject;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;
import org.semanticweb.owlapi.model.OWLOntologyStorageException;
import org.semanticweb.owlapi.model.OWLSubClassOfAxiom;
import org.semanticweb.owlapi.util.OWLAxiomVisitorAdapter;

@SuppressWarnings("javadoc")
public class SearchTest {
    OWLOntology ontology;
    private final ErrorListener errorListener = new JUnitTestErrorListener();
    final RuntimeExceptionHandler HANDLER = new QuickFailRuntimeExceptionHandler();

    @Before
    public void setUp() throws OWLOntologyCreationException {
        ontology = pizza;
    }

    @Test
    public void testIntegerSearchTree() {
        final Map<Integer, List<Integer>> childrenLists = new HashMap<Integer, List<Integer>>();
        childrenLists.put(2, Arrays.asList(1, 3, 4, 5));
        childrenLists.put(1, Arrays.asList(2, 3));
        childrenLists.put(4, Arrays.asList(5, 3));
        childrenLists.put(5, Arrays.asList(1));
        SearchTree<Integer> searchTree = new SearchTree<Integer>() {
            @Override
            protected boolean goalReached(Integer start) {
                return start == 3;
            }

            @Override
            protected List<Integer> getChildren(Integer node) {
                return childrenLists.get(node) == null ? new ArrayList<Integer>()
                        : childrenLists.get(node);
            }
        };
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        boolean found = searchTree.exhaustiveSearchTree(2, result);
        assertTrue("It's there but cannot find it ", found);
        System.out.println("Found? " + found);
        for (List<Integer> path : result) {
            System.out.println(path);
        }
        SearchTree<Integer> anotherSearchTree = new SearchTree<Integer>() {
            @Override
            protected boolean goalReached(Integer start) {
                return start == 7;
            }

            @Override
            protected List<Integer> getChildren(Integer node) {
                return childrenLists.get(node) == null ? new ArrayList<Integer>()
                        : childrenLists.get(node);
            }
        };
        found = anotherSearchTree.exhaustiveSearchTree(2, result);
        System.out.println("Found? " + found);
        for (List<Integer> path : result) {
            System.out.println(path);
        }
        assertFalse("It's not there but can find it ", found);
    }

    @Test
    public void testOWLAxiomSearch() throws OWLOntologyStorageException {
        OWLClass namedPizzaClass = df.getOWLClass(IRI
                .create("http://pizza.com/pizza.owl#NamedPizza"));
        OWLClass pizzaClass = df.getOWLClass(IRI
                .create("http://pizza.com/pizza.owl#Pizza"));
        final OWLSubClassOfAxiom subClassAxiom = df.getOWLSubClassOfAxiom(
                namedPizzaClass, pizzaClass);
        String opplString = "?x:CLASS, ?y:CLASS SELECT ASSERTED ?x subClassOf ?y BEGIN ADD ?x subClassOf ?y END;";
        final OPPLScript opplScript = parseScript(ontology, opplString);
        OWLAxiom start = opplScript.getQuery().getAssertedAxioms().iterator().next();
        SearchTree<OWLAxiom> searchTree = new SearchTree<OWLAxiom>() {
            @Override
            protected boolean goalReached(OWLAxiom startAxiom) {
                // System.out.println(startAxiom + "\t" + subClassAxiom);
                return startAxiom.equalsIgnoreAnnotations(subClassAxiom);
            }

            @Override
            protected List<OWLAxiom> getChildren(OWLAxiom node) {
                ConstraintSystem constraintSystem = opplScript.getConstraintSystem();
                VariableExtractor variableExtractor = new VariableExtractor(
                        constraintSystem, false);
                Set<Variable<?>> variables = variableExtractor.extractVariables(node);
                List<OWLAxiom> toReturn = new ArrayList<OWLAxiom>();
                for (Variable<?> variable : variables) {
                    Set<Variable<?>> unassignedVariables = new HashSet<Variable<?>>(
                            variables);
                    unassignedVariables.remove(variable);
                    Collection<? extends OWLObject> assignedValues = getAssignableValues(variable);
                    for (OWLObject assignedValue : assignedValues) {
                        Assignment assignment = new Assignment(variable, assignedValue);
                        BindingNode bindingNode = new BindingNode(
                                Collections.singleton(assignment), variables);
                        ValueComputationParameters parameters = new SimpleValueComputationParameters(
                                constraintSystem, bindingNode, HANDLER);
                        PartialOWLObjectInstantiator instantiator = new PartialOWLObjectInstantiator(
                                parameters);
                        toReturn.add((OWLAxiom) node.accept(instantiator));
                    }
                }
                return toReturn;
            }

            private Set<? extends OWLObject> getAssignableValues(Variable<?> variable) {
                return variable.getType().accept(assignableValuesVisitor);
            }

            private final VariableTypeVisitorEx<Set<? extends OWLObject>> assignableValuesVisitor = new AssValVisitor(
                    ontology);
        };
        List<List<OWLAxiom>> solutions = new ArrayList<List<OWLAxiom>>();
        boolean found = searchTree.exhaustiveSearchTree(start, solutions);
        assertTrue("It's there but cannot find it: " + start + "\n" + solutions, found);
        System.out.println("Found? " + found);
        for (List<OWLAxiom> path : solutions) {
            System.out.println(path);
        }
    }

    private OPPLScript parseScript(OWLOntology o, String opplString) {
        OPPLParser parser = new ParserFactory(o.getOWLOntologyManager(), o, null)
                .build(errorListener);
        return parser.parse(opplString);
    }

    @Test
    public void testOWLAxiomSearchTree() {
        String opplString = "?x:CLASS, ?y:CLASS SELECT ASSERTED ?x subClassOf ?y BEGIN ADD ?x subClassOf ?y END;";
        final OPPLScript opplScript = parseScript(ontology, opplString);
        OWLAxiom start = opplScript.getQuery().getAssertedAxioms().iterator().next();
        ValueComputationParameters parameters = new SimpleValueComputationParameters(
                opplScript.getConstraintSystem(),
                BindingNode.createNewEmptyBindingNode(), HANDLER);
        SearchTree<OWLAxiom> searchTree = new OWLAxiomSearchTree(parameters);
        List<List<OWLAxiom>> solutions = new ArrayList<List<OWLAxiom>>();
        boolean found = searchTree.exhaustiveSearchTree(start, solutions);
        assertTrue("It's there but cannot find it ", found);
        System.out.println("Found? " + found);
        Set<OWLAxiom> results = new HashSet<OWLAxiom>(solutions.size());
        for (List<OWLAxiom> path : solutions) {
            results.add(path.get(path.size() - 1));
            System.out.println(path);
        }
        final Set<OWLAxiom> subClassAxioms = new HashSet<OWLAxiom>(solutions.size());
        Set<OWLSubClassOfAxiom> axioms = pizza.getAxioms(AxiomType.SUBCLASS_OF);
        for (OWLSubClassOfAxiom owlSubClassAxiom : axioms) {
            owlSubClassAxiom.accept(new OWLAxiomVisitorAdapter() {
                @Override
                public void visit(OWLSubClassOfAxiom axiom) {
                    OWLClassExpression subClass = axiom.getSubClass();
                    OWLClassExpression superClass = axiom.getSuperClass();
                    if (!subClass.isAnonymous() && !superClass.isAnonymous()) {
                        subClassAxioms.add(axiom);
                    }
                }
            });
        }
        assertTrue("Mismatched count sub class axioms count " + subClassAxioms.size()
                + " solutions count " + results.size(),
                results.size() == subClassAxioms.size());
    }
}
