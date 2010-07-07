package org.coode.oppl.test;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import junit.framework.TestCase;

import org.coode.oppl.ChangeExtractor;
import org.coode.oppl.OPPLScript;
import org.coode.oppl.search.OPPLAssertedOWLAxiomSearchTree;
import org.coode.oppl.search.OPPLOWLAxiomSearchNode;
import org.coode.oppl.search.OWLAxiomSearchTree;
import org.coode.oppl.search.SearchTree;
import org.coode.oppl.syntax.ParseException;
import org.coode.oppl.utils.ParserFactory;
import org.coode.oppl.utils.VariableExtractor;
import org.coode.oppl.variablemansyntax.ConstraintSystem;
import org.coode.oppl.variablemansyntax.PartialOWLObjectInstantiator;
import org.coode.oppl.variablemansyntax.Variable;
import org.coode.oppl.variablemansyntax.VariableTypeVisitorEx;
import org.coode.oppl.variablemansyntax.bindingtree.Assignment;
import org.coode.oppl.variablemansyntax.bindingtree.BindingNode;
import org.coode.oppl.variablemansyntax.generated.SingleValueGeneratedVariable;
import org.coode.oppl.variablemansyntax.variabletypes.CLASSVariable;
import org.coode.oppl.variablemansyntax.variabletypes.CONSTANTVariable;
import org.coode.oppl.variablemansyntax.variabletypes.DATAPROPERTYVariable;
import org.coode.oppl.variablemansyntax.variabletypes.INDIVIDUALVariable;
import org.coode.oppl.variablemansyntax.variabletypes.OBJECTPROPERTYVariable;
import org.semanticweb.owl.apibinding.OWLManager;
import org.semanticweb.owl.model.AxiomType;
import org.semanticweb.owl.model.OWLAxiom;
import org.semanticweb.owl.model.OWLClass;
import org.semanticweb.owl.model.OWLDataProperty;
import org.semanticweb.owl.model.OWLDescription;
import org.semanticweb.owl.model.OWLIndividual;
import org.semanticweb.owl.model.OWLObject;
import org.semanticweb.owl.model.OWLObjectProperty;
import org.semanticweb.owl.model.OWLOntology;
import org.semanticweb.owl.model.OWLOntologyCreationException;
import org.semanticweb.owl.model.OWLOntologyManager;
import org.semanticweb.owl.model.OWLSubClassAxiom;
import org.semanticweb.owl.util.OWLAxiomVisitorAdapter;

public class SearchTest extends TestCase {
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
			OWLOntology ontology = manager.loadOntology(URI.create("http://www.co-ode.org/ontologies/pizza/2007/02/12/pizza.owl"));
			OWLClass namedPizzaClass = manager.getOWLDataFactory().getOWLClass(
					URI.create("http://www.co-ode.org/ontologies/pizza/pizza.owl#NamedPizza"));
			OWLClass pizzaClass = manager.getOWLDataFactory().getOWLClass(
					URI.create("http://www.co-ode.org/ontologies/pizza/pizza.owl#Pizza"));
			final OWLSubClassAxiom subClassAxiom = manager.getOWLDataFactory().getOWLSubClassAxiom(
					namedPizzaClass,
					pizzaClass);
			String opplString = "?x:CLASS, ?y:CLASS SELECT ASSERTED ?x subClassOf ?y BEGIN ADD ?x subClassOf ?y END;";
			final OPPLScript opplScript = this.parsescript(manager, ontology, opplString);
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
					Set<Variable> variables = variableExtractor.extractVariables(node);
					List<OWLAxiom> toReturn = new ArrayList<OWLAxiom>();
					for (Variable variable : variables) {
						Set<Variable> unassignedVariables = new HashSet<Variable>(variables);
						unassignedVariables.remove(variable);
						Collection<? extends OWLObject> assignedValues = this.getAssignableValues(variable);
						for (OWLObject assignedValue : assignedValues) {
							Assignment assignment = new Assignment(variable, assignedValue);
							BindingNode bindingNode = new BindingNode(
									Collections.singleton(assignment), variables);
							PartialOWLObjectInstantiator instantiator = new PartialOWLObjectInstantiator(
									bindingNode, constraintSystem);
							toReturn.add((OWLAxiom) node.accept(instantiator));
						}
					}
					return toReturn;
				}

				private final VariableTypeVisitorEx<Collection<? extends OWLObject>> assignableValuesVisitor = new VariableTypeVisitorEx<Collection<? extends OWLObject>>() {
					public Collection<? extends OWLObject> visit(SingleValueGeneratedVariable<?> v) {
						return v.getPossibleBindings();
					}

					public Collection<? extends OWLObject> visit(INDIVIDUALVariable v) {
						return getAllIndividuals();
					}

					public Collection<? extends OWLObject> visit(DATAPROPERTYVariable v) {
						return getAllDataProperties();
					}

					public Collection<? extends OWLObject> visit(OBJECTPROPERTYVariable v) {
						return getObjectProperties();
					}

					public Collection<? extends OWLObject> visit(CONSTANTVariable v) {
						return getAllConstants();
					}

					public Collection<? extends OWLObject> visit(CLASSVariable v) {
						return getAllClasses();
					}
				};

				private Collection<? extends OWLObject> getAssignableValues(Variable variable) {
					Set<OWLObject> toReturn = new HashSet<OWLObject>();
					toReturn.addAll(variable.accept(this.assignableValuesVisitor));
					// VariableType type = variable.getType();
					// switch (type) {
					// case CLASS:
					// toReturn.addAll(this.getAllClasses());
					// break;
					// case DATAPROPERTY:
					// toReturn.addAll(this.getAllDataProperties());
					// break;
					// case OBJECTPROPERTY:
					// toReturn.addAll(this.getObjectProperties());
					// break;
					// case INDIVIDUAL:
					// toReturn.addAll(this.getAllIndividuals());
					// break;
					// case CONSTANT:
					// toReturn.addAll(this.getAllConstants());
					// break;
					// default:
					// break;
					// }
					return toReturn;
				}

				private Collection<? extends OWLObject> getAllConstants() {
					return Collections.emptySet();
				}

				private Collection<? extends OWLObject> getAllIndividuals() {
					Set<OWLIndividual> toReturn = new HashSet<OWLIndividual>();
					Set<OWLOntology> ontologies = manager.getOntologies();
					for (OWLOntology owlOntology : ontologies) {
						toReturn.addAll(owlOntology.getReferencedIndividuals());
					}
					return toReturn;
				}

				private Collection<? extends OWLObject> getObjectProperties() {
					Set<OWLObjectProperty> toReturn = new HashSet<OWLObjectProperty>();
					Set<OWLOntology> ontologies = manager.getOntologies();
					for (OWLOntology owlOntology : ontologies) {
						toReturn.addAll(owlOntology.getReferencedObjectProperties());
					}
					return toReturn;
				}

				private Collection<? extends OWLObject> getAllDataProperties() {
					Set<OWLDataProperty> toReturn = new HashSet<OWLDataProperty>();
					Set<OWLOntology> ontologies = manager.getOntologies();
					for (OWLOntology owlOntology : ontologies) {
						toReturn.addAll(owlOntology.getReferencedDataProperties());
					}
					return toReturn;
				}

				private Collection<? extends OWLObject> getAllClasses() {
					Set<OWLClass> toReturn = new HashSet<OWLClass>();
					Set<OWLOntology> ontologies = manager.getOntologies();
					for (OWLOntology owlOntology : ontologies) {
						toReturn.addAll(owlOntology.getReferencedClasses());
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
		} catch (ParseException e) {
			fail(e.getMessage());
			e.printStackTrace();
		}
	}

	private OPPLScript parsescript(final OWLOntologyManager manager, OWLOntology ontology,
			String opplString) throws ParseException {
		final OPPLScript opplScript = ParserFactory.initParser(opplString, ontology, manager, null).Start();
		return opplScript;
	}

	public void testOWLAxiomSearchTree() {
		final OWLOntologyManager manager = OWLManager.createOWLOntologyManager();
		try {
			OWLOntology ontology = manager.loadOntology(URI.create("http://www.co-ode.org/ontologies/pizza/2007/02/12/pizza.owl"));
			String opplString = "?x:CLASS, ?y:CLASS SELECT ASSERTED ?x subClassOf ?y BEGIN ADD ?x subClassOf ?y END;";
			final OPPLScript opplScript = this.parsescript(manager, ontology, opplString);
			OWLAxiom start = opplScript.getQuery().getAssertedAxioms().iterator().next();
			SearchTree<OWLAxiom> searchTree = new OWLAxiomSearchTree(manager,
					opplScript.getConstraintSystem());
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
				Set<OWLSubClassAxiom> axioms = onOwlOntology.getAxioms(AxiomType.SUBCLASS);
				for (OWLSubClassAxiom owlSubClassAxiom : axioms) {
					owlSubClassAxiom.accept(new OWLAxiomVisitorAdapter() {
						@Override
						public void visit(OWLSubClassAxiom axiom) {
							OWLDescription subClass = axiom.getSubClass();
							OWLDescription superClass = axiom.getSuperClass();
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
		} catch (ParseException e) {
			fail(e.getMessage());
			e.printStackTrace();
		}
	}

	public void testOWLAxiomOPPLSearchTreeMultipleAxiomsVersusQueryNotFound() {
		final OWLOntologyManager manager = OWLManager.createOWLOntologyManager();
		try {
			OWLOntology ontology = manager.loadOntology(URI.create("http://www.co-ode.org/ontologies/pizza/2007/02/12/pizza.owl"));
			String opplString = "?x:CLASS, ?y:CLASS SELECT ASSERTED ?x subClassOf Pizza, ASSERTED ?x subClassOf hasTopping some MozzarellaTopping BEGIN ADD ?x subClassOf ?y END;";
			final OPPLScript opplScript = this.parsescript(manager, ontology, opplString);
			final OPPLScript checkOPPLScript = this.parsescript(manager, ontology, opplString);
			final Set<OWLAxiom> correctResults = this.getOPPLScriptCorrectResults(checkOPPLScript);
			Iterator<OWLAxiom> iterator = opplScript.getQuery().getAssertedAxioms().iterator();
			OWLAxiom firstAxiom = iterator.next();
			OWLAxiom secondAxiom = iterator.next();
			VariableExtractor variableExtractor = new VariableExtractor(
					opplScript.getConstraintSystem(), false);
			OPPLAssertedOWLAxiomSearchTree searchTree = new OPPLAssertedOWLAxiomSearchTree(
					opplScript.getConstraintSystem());
			List<List<OPPLOWLAxiomSearchNode>> solutions = new ArrayList<List<OPPLOWLAxiomSearchNode>>();
			boolean found = searchTree.exhaustiveSearchTree(
					new OPPLOWLAxiomSearchNode(firstAxiom, new BindingNode(
							new HashSet<Assignment>(),
							variableExtractor.extractVariables(firstAxiom))),
					solutions);
			Set<OWLAxiom> results = new HashSet<OWLAxiom>(solutions.size());
			solutions.clear();
			found = searchTree.exhaustiveSearchTree(
					new OPPLOWLAxiomSearchNode(secondAxiom, new BindingNode(
							new HashSet<Assignment>(),
							variableExtractor.extractVariables(secondAxiom))),
					solutions);
			assertFalse("It's not there but can find it ", found);
			System.out.println("Found? " + found);
			for (List<OPPLOWLAxiomSearchNode> path : solutions) {
				results.add(path.get(path.size() - 1).getAxiom());
			}
			System.out.println(results);
			assertTrue(
					"Results, size = " + results.size()
							+ "  do not match with the expected ones size = "
							+ correctResults.size(),
					correctResults.size() == results.size());
		} catch (OWLOntologyCreationException e) {
			fail(e.getMessage());
			e.printStackTrace();
		} catch (ParseException e) {
			fail(e.getMessage());
			e.printStackTrace();
		}
	}

	/**
	 * @param manager
	 * @param ontology
	 * @param opplScript
	 * @return
	 */
	private Set<OWLAxiom> getOPPLScriptCorrectResults(final OPPLScript opplScript) {
		ChangeExtractor changeExtractor = new ChangeExtractor(opplScript.getConstraintSystem(),
				true);
		opplScript.accept(changeExtractor);
		Set<BindingNode> checkLeaves = opplScript.getConstraintSystem().getLeaves();
		final Set<OWLAxiom> correctResults = new HashSet<OWLAxiom>();
		Set<OWLAxiom> queryAxioms = new HashSet<OWLAxiom>();
		queryAxioms.addAll(opplScript.getQuery().getAssertedAxioms());
		queryAxioms.addAll(opplScript.getQuery().getAxioms());
		for (BindingNode bindingNode : checkLeaves) {
			PartialOWLObjectInstantiator partialOWLObjectInstantiator = new PartialOWLObjectInstantiator(
					bindingNode, opplScript.getConstraintSystem());
			for (OWLAxiom owlAxiom : queryAxioms) {
				correctResults.add((OWLAxiom) owlAxiom.accept(partialOWLObjectInstantiator));
			}
		}
		return correctResults;
	}

	public void testOWLAxiomOPPLSearchTreeMultipleAxiomsVersusQueryFound() {
		final OWLOntologyManager manager = OWLManager.createOWLOntologyManager();
		try {
			OWLOntology ontology = manager.loadOntology(URI.create("http://www.co-ode.org/ontologies/pizza/2007/02/12/pizza.owl"));
			String opplString = "?x:CLASS, ?y:CLASS SELECT ASSERTED ?x subClassOf NamedPizza, ASSERTED ?x subClassOf hasTopping some MozzarellaTopping BEGIN ADD ?x subClassOf ?y END;";
			final OPPLScript opplScript = this.parsescript(manager, ontology, opplString);
			final OPPLScript checkOPPLScript = this.parsescript(manager, ontology, opplString);
			final Set<OWLAxiom> correctResults = this.getOPPLScriptCorrectResults(checkOPPLScript);
			Iterator<OWLAxiom> iterator = opplScript.getQuery().getAssertedAxioms().iterator();
			OWLAxiom firstAxiom = iterator.next();
			OWLAxiom secondAxiom = iterator.next();
			VariableExtractor variableExtractor = new VariableExtractor(
					opplScript.getConstraintSystem(), false);
			OPPLAssertedOWLAxiomSearchTree searchTree = new OPPLAssertedOWLAxiomSearchTree(
					opplScript.getConstraintSystem());
			List<List<OPPLOWLAxiomSearchNode>> solutions = new ArrayList<List<OPPLOWLAxiomSearchNode>>();
			boolean found = searchTree.exhaustiveSearchTree(
					new OPPLOWLAxiomSearchNode(firstAxiom, new BindingNode(
							new HashSet<Assignment>(),
							variableExtractor.extractVariables(firstAxiom))),
					solutions);
			Set<OWLAxiom> results = new HashSet<OWLAxiom>(solutions.size());
			solutions.clear();
			found = searchTree.exhaustiveSearchTree(
					new OPPLOWLAxiomSearchNode(secondAxiom, new BindingNode(
							new HashSet<Assignment>(),
							variableExtractor.extractVariables(secondAxiom))),
					solutions);
			assertTrue("It's not there but can find it ", found);
			System.out.println("Found? " + found);
			for (List<OPPLOWLAxiomSearchNode> path : solutions) {
				OPPLOWLAxiomSearchNode searchLeaf = path.get(path.size() - 1);
				BindingNode leaf = searchLeaf.getBinding();
				PartialOWLObjectInstantiator partialOWLObjectInstantiator = new PartialOWLObjectInstantiator(
						leaf, opplScript.getConstraintSystem());
				results.add((OWLAxiom) firstAxiom.accept(partialOWLObjectInstantiator));
				results.add((OWLAxiom) secondAxiom.accept(partialOWLObjectInstantiator));
			}
			for (OWLAxiom owlAxiom : results) {
				assertTrue(
						"The axiom " + owlAxiom.toString()
								+ " is not contained in the expected results",
						correctResults.contains(owlAxiom));
			}
			for (OWLAxiom owlAxiom : correctResults) {
				assertTrue("The correct axiom " + owlAxiom.toString()
						+ " is not contained in the search results", results.contains(owlAxiom));
			}
			assertTrue(
					"Results, size = " + results.size()
							+ "  do not match with the expected ones size = "
							+ correctResults.size(),
					correctResults.size() == results.size());
		} catch (OWLOntologyCreationException e) {
			fail(e.getMessage());
			e.printStackTrace();
		} catch (ParseException e) {
			fail(e.getMessage());
			e.printStackTrace();
		}
	}
}
