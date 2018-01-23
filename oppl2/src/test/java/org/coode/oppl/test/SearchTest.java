package org.coode.oppl.test;

import static org.coode.oppl.testontologies.TestOntologies.df;
import static org.coode.oppl.testontologies.TestOntologies.pizza;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.semanticweb.owlapi.util.OWLAPIStreamUtils.asSet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

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
import org.semanticweb.owlapi.model.AxiomType;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLAxiom;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLObject;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLSubClassOfAxiom;

@SuppressWarnings("javadoc")
public class SearchTest {

    OWLOntology ontology;
    private final ErrorListener errorListener = new JUnitTestErrorListener();
    final RuntimeExceptionHandler HANDLER = new QuickFailRuntimeExceptionHandler();

    @Before
    public void setUp() {
        ontology = pizza;
    }

    @Test
    public void shouldTestIntegerSearchTree() {
        final Map<Integer, List<Integer>> childrenLists = new HashMap<>();
        childrenLists.put(Integer.valueOf(2), Arrays.asList(Integer.valueOf(1), Integer.valueOf(3),
            Integer.valueOf(4), Integer.valueOf(5)));
        childrenLists.put(Integer.valueOf(1),
            Arrays.asList(Integer.valueOf(2), Integer.valueOf(3)));
        childrenLists.put(Integer.valueOf(4),
            Arrays.asList(Integer.valueOf(5), Integer.valueOf(3)));
        childrenLists.put(Integer.valueOf(5), Arrays.asList(Integer.valueOf(1)));
        SearchTree<Integer> searchTree = new SearchTree<Integer>() {

            @Override
            protected boolean goalReached(Integer start) {
                return start.intValue() == 3;
            }

            @Override
            protected List<Integer> getChildren(Integer node) {
                return childrenLists.get(node) == null ? new ArrayList<>()
                    : childrenLists.get(node);
            }
        };
        List<List<Integer>> result = new ArrayList<>();
        boolean found = searchTree.exhaustiveSearchTree(Integer.valueOf(2), result);
        assertTrue("It's there but cannot find it ", found);
        SearchTree<Integer> anotherSearchTree = new SearchTree<Integer>() {

            @Override
            protected boolean goalReached(Integer start) {
                return start.intValue() == 7;
            }

            @Override
            protected List<Integer> getChildren(Integer node) {
                return childrenLists.get(node) == null ? new ArrayList<>()
                    : childrenLists.get(node);
            }
        };
        found = anotherSearchTree.exhaustiveSearchTree(Integer.valueOf(2), result);
        assertFalse("It's not there but can find it ", found);
    }

    @Test
    public void shouldTestOWLAxiomSearch() {
        OWLClass namedPizzaClass =
            df.getOWLClass(IRI.create("http://pizza.com/pizza.owl#NamedPizza"));
        OWLClass pizzaClass = df.getOWLClass(IRI.create("http://pizza.com/pizza.owl#Pizza"));
        final OWLSubClassOfAxiom subClassAxiom =
            df.getOWLSubClassOfAxiom(namedPizzaClass, pizzaClass);
        String opplString =
            "?x:CLASS, ?y:CLASS SELECT ASSERTED ?x subClassOf ?y BEGIN ADD ?x subClassOf ?y END;";
        final OPPLScript opplScript = parseScript(ontology, opplString);
        OWLAxiom start = opplScript.getQuery().getAssertedAxioms().iterator().next();
        SearchTree<OWLAxiom> searchTree = new SearchTree<OWLAxiom>() {

            @Override
            protected boolean goalReached(OWLAxiom startAxiom) {
                return startAxiom.equalsIgnoreAnnotations(subClassAxiom);
            }

            @Override
            protected List<OWLAxiom> getChildren(OWLAxiom node) {
                ConstraintSystem constraintSystem = opplScript.getConstraintSystem();
                VariableExtractor variableExtractor =
                    new VariableExtractor(constraintSystem, false);
                Set<Variable<?>> variables = variableExtractor.extractVariables(node);
                List<OWLAxiom> toReturn = new ArrayList<>();
                for (Variable<?> variable : variables) {
                    Set<Variable<?>> unassignedVariables = new HashSet<>(variables);
                    unassignedVariables.remove(variable);
                    Collection<? extends OWLObject> assignedValues = getAssignableValues(variable);
                    for (OWLObject assignedValue : assignedValues) {
                        Assignment assignment = new Assignment(variable, assignedValue);
                        BindingNode bindingNode =
                            new BindingNode(Collections.singleton(assignment), variables);
                        ValueComputationParameters parameters =
                            new SimpleValueComputationParameters(constraintSystem, bindingNode,
                                HANDLER);
                        PartialOWLObjectInstantiator instantiator =
                            new PartialOWLObjectInstantiator(parameters);
                        toReturn.add((OWLAxiom) node.accept(instantiator));
                    }
                }
                return toReturn;
            }

            private Set<? extends OWLObject> getAssignableValues(Variable<?> variable) {
                return asSet(variable.getType().accept(assignableValuesVisitor), OWLObject.class);
            }

            private final VariableTypeVisitorEx<Stream<? extends OWLObject>> assignableValuesVisitor =
                new AssValVisitor(ontology);
        };
        List<List<OWLAxiom>> solutions = new ArrayList<>();
        boolean found = searchTree.exhaustiveSearchTree(start, solutions);
        assertTrue("It's there but cannot find it: " + start + "\n" + solutions, found);
    }

    private OPPLScript parseScript(OWLOntology o, String opplString) {
        OPPLParser parser =
            new ParserFactory(o.getOWLOntologyManager(), o, null).build(errorListener);
        return parser.parse(opplString);
    }

    @Test
    public void shouldTestOWLAxiomSearchTree() {
        String opplString =
            "?x:CLASS, ?y:CLASS SELECT ASSERTED ?x subClassOf ?y BEGIN ADD ?x subClassOf ?y END;";
        final OPPLScript opplScript = parseScript(ontology, opplString);
        OWLAxiom start = opplScript.getQuery().getAssertedAxioms().iterator().next();
        ValueComputationParameters parameters = new SimpleValueComputationParameters(
            opplScript.getConstraintSystem(), BindingNode.createNewEmptyBindingNode(), HANDLER);
        SearchTree<OWLAxiom> searchTree = new OWLAxiomSearchTree(parameters);
        List<List<OWLAxiom>> solutions = new ArrayList<>();
        boolean found = searchTree.exhaustiveSearchTree(start, solutions);
        assertTrue("It's there but cannot find it ", found);
        Set<OWLAxiom> results = new HashSet<>(solutions.size());
        for (List<OWLAxiom> path : solutions) {
            results.add(path.get(path.size() - 1));
        }
        final Set<OWLSubClassOfAxiom> subClassAxioms = asSet(pizza.axioms(AxiomType.SUBCLASS_OF)
            .filter(ax -> ax.getSubClass().isOWLClass() && ax.getSuperClass().isOWLClass()));
        assertTrue("Mismatched count sub class axioms count " + subClassAxioms.size()
            + " solutions count " + results.size(), results.size() == subClassAxioms.size());
    }
}
