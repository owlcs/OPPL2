package org.coode.oppl.test;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import junit.framework.TestCase;

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
import org.coode.oppl.variabletypes.CLASSVariableType;
import org.coode.oppl.variabletypes.CONSTANTVariableType;
import org.coode.oppl.variabletypes.DATAPROPERTYVariableType;
import org.coode.oppl.variabletypes.INDIVIDUALVariableType;
import org.coode.oppl.variabletypes.OBJECTPROPERTYVariableType;
import org.coode.oppl.variabletypes.VariableTypeVisitorEx;
import org.coode.parsers.ErrorListener;
import org.coode.parsers.common.JUnitTestErrorListener;
import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.model.AxiomType;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLAxiom;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLClassExpression;
import org.semanticweb.owlapi.model.OWLDataProperty;
import org.semanticweb.owlapi.model.OWLNamedIndividual;
import org.semanticweb.owlapi.model.OWLObject;
import org.semanticweb.owlapi.model.OWLObjectProperty;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;
import org.semanticweb.owlapi.model.OWLOntologyManager;
import org.semanticweb.owlapi.model.OWLSubClassOfAxiom;
import org.semanticweb.owlapi.util.OWLAxiomVisitorAdapter;

public class SearchTest extends TestCase {
	private final ErrorListener errorListener = new JUnitTestErrorListener();
	private final static RuntimeExceptionHandler HANDLER = new QuickFailRuntimeExceptionHandler();

	@Override
	protected void setUp() throws Exception {
		super.setUp();
	}

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

	public void testOWLAxiomSearch() {
		final OWLOntologyManager manager = OWLManager.createOWLOntologyManager();
		try {
			OWLOntology ontology = manager.loadOntology(IRI.create(URI.create("http://www.co-ode.org/ontologies/pizza/2007/02/12/pizza.owl")));
			OWLClass namedPizzaClass = manager.getOWLDataFactory().getOWLClass(
					IRI.create("http://www.co-ode.org/ontologies/pizza/pizza.owl#NamedPizza"));
			OWLClass pizzaClass = manager.getOWLDataFactory().getOWLClass(
					IRI.create("http://www.co-ode.org/ontologies/pizza/pizza.owl#Pizza"));
			final OWLSubClassOfAxiom subClassAxiom = manager.getOWLDataFactory().getOWLSubClassOfAxiom(
					namedPizzaClass,
					pizzaClass);
			String opplString = "?x:CLASS, ?y:CLASS SELECT ASSERTED ?x subClassOf ?y BEGIN ADD ?x subClassOf ?y END;";
			final OPPLScript opplScript = this.parseScript(manager, ontology, opplString);
			OWLAxiom start = opplScript.getQuery().getAssertedAxioms().iterator().next();
			SearchTree<OWLAxiom> searchTree = new SearchTree<OWLAxiom>() {
				@Override
				protected boolean goalReached(OWLAxiom startAxiom) {
					return startAxiom.equals(subClassAxiom);
				}

				@Override
				protected List<OWLAxiom> getChildren(OWLAxiom node) {
					ConstraintSystem constraintSystem = opplScript.getConstraintSystem();
					VariableExtractor variableExtractor = new VariableExtractor(constraintSystem,
							false);
					Set<Variable<?>> variables = variableExtractor.extractVariables(node);
					List<OWLAxiom> toReturn = new ArrayList<OWLAxiom>();
					for (Variable<?> variable : variables) {
						Set<Variable<?>> unassignedVariables = new HashSet<Variable<?>>(variables);
						unassignedVariables.remove(variable);
						Collection<? extends OWLObject> assignedValues = this.getAssignableValues(variable);
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

				private final VariableTypeVisitorEx<Collection<? extends OWLObject>> assignableValuesVisitor = new VariableTypeVisitorEx<Collection<? extends OWLObject>>() {
					public Collection<? extends OWLObject> visitINDIVIDUALVariableType(
							INDIVIDUALVariableType v) {
						return getAllIndividuals();
					}

					public Collection<? extends OWLObject> visitDATAPROPERTYVariableType(
							DATAPROPERTYVariableType v) {
						return getAllDataProperties();
					}

					public Collection<? extends OWLObject> visitOBJECTPROPERTYVariableType(
							OBJECTPROPERTYVariableType v) {
						return getObjectProperties();
					}

					public Collection<? extends OWLObject> visitCONSTANTVariableType(
							CONSTANTVariableType v) {
						return getAllConstants();
					}

					public Collection<? extends OWLObject> visitCLASSVariableType(
							CLASSVariableType v) {
						return getAllClasses();
					}
				};

				private Set<OWLObject> getAssignableValues(Variable<?> variable) {
					Set<OWLObject> toReturn = new HashSet<OWLObject>();
					toReturn.addAll(variable.getType().accept(this.assignableValuesVisitor));
					return toReturn;
				}

				private Collection<? extends OWLObject> getAllConstants() {
					return Collections.emptySet();
				}

				private Set<OWLNamedIndividual> getAllIndividuals() {
					Set<OWLNamedIndividual> toReturn = new HashSet<OWLNamedIndividual>();
					Set<OWLOntology> ontologies = manager.getOntologies();
					for (OWLOntology owlOntology : ontologies) {
						toReturn.addAll(owlOntology.getIndividualsInSignature());
					}
					return toReturn;
				}

				private Set<OWLObjectProperty> getObjectProperties() {
					Set<OWLObjectProperty> toReturn = new HashSet<OWLObjectProperty>();
					Set<OWLOntology> ontologies = manager.getOntologies();
					for (OWLOntology owlOntology : ontologies) {
						toReturn.addAll(owlOntology.getObjectPropertiesInSignature());
					}
					return toReturn;
				}

				private Set<OWLDataProperty> getAllDataProperties() {
					Set<OWLDataProperty> toReturn = new HashSet<OWLDataProperty>();
					Set<OWLOntology> ontologies = manager.getOntologies();
					for (OWLOntology owlOntology : ontologies) {
						toReturn.addAll(owlOntology.getDataPropertiesInSignature());
					}
					return toReturn;
				}

				private Set<OWLClass> getAllClasses() {
					Set<OWLClass> toReturn = new HashSet<OWLClass>();
					Set<OWLOntology> ontologies = manager.getOntologies();
					for (OWLOntology owlOntology : ontologies) {
						toReturn.addAll(owlOntology.getClassesInSignature());
					}
					return toReturn;
				}
			};
			List<List<OWLAxiom>> solutions = new ArrayList<List<OWLAxiom>>();
			boolean found = searchTree.exhaustiveSearchTree(start, solutions);
			assertTrue("It's there but cannot find it ", found);
			System.out.println("Found? " + found);
			for (List<OWLAxiom> path : solutions) {
				System.out.println(path);
			}
		} catch (OWLOntologyCreationException e) {
			fail(e.getMessage());
			e.printStackTrace();
		}
	}

	private OPPLScript parseScript(final OWLOntologyManager manager, OWLOntology ontology,
			String opplString) {
		OPPLParser parser = new ParserFactory(manager, ontology, null).build(this.errorListener);
		return parser.parse(opplString);
	}

	public void testOWLAxiomSearchTree() {
		final OWLOntologyManager manager = OWLManager.createOWLOntologyManager();
		try {
			OWLOntology ontology = manager.loadOntology(IRI.create("http://www.co-ode.org/ontologies/pizza/2007/02/12/pizza.owl"));
			String opplString = "?x:CLASS, ?y:CLASS SELECT ASSERTED ?x subClassOf ?y BEGIN ADD ?x subClassOf ?y END;";
			final OPPLScript opplScript = this.parseScript(manager, ontology, opplString);
			OWLAxiom start = opplScript.getQuery().getAssertedAxioms().iterator().next();
			ValueComputationParameters parameters = new SimpleValueComputationParameters(
					opplScript.getConstraintSystem(), BindingNode.createNewEmptyBindingNode(),
					HANDLER);
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
			for (OWLOntology onOwlOntology : manager.getOntologies()) {
				Set<OWLSubClassOfAxiom> axioms = onOwlOntology.getAxioms(AxiomType.SUBCLASS_OF);
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
			}
			assertTrue("Mismatched count sub class axioms count " + subClassAxioms.size()
					+ " solutions count " + results.size(), results.size() == subClassAxioms.size());
		} catch (OWLOntologyCreationException e) {
			fail(e.getMessage());
			e.printStackTrace();
		}
	}
}
