package org.coode.oppl.search.solvability.test;

import java.util.Arrays;
import java.util.HashSet;

import junit.framework.TestCase;

import org.coode.oppl.ConstraintSystem;
import org.coode.oppl.OPPLFactory;
import org.coode.oppl.Variable;
import org.coode.oppl.VariableType;
import org.coode.oppl.bindingtree.BindingNode;
import org.coode.oppl.exceptions.OPPLException;
import org.coode.oppl.search.solvability.AssertedModelQuerySolver;
import org.coode.oppl.search.solvability.AxiomSolvability;
import org.coode.oppl.search.solvability.InferredModelQuerySolver;
import org.coode.oppl.search.solvability.SolvabilitySearchNode;
import org.coode.oppl.search.solvability.SolvabilitySearchNodeVisitor;
import org.coode.oppl.search.solvability.SolvableSearchNode;
import org.coode.oppl.search.solvability.SolvedSearchNode;
import org.coode.oppl.search.solvability.UnsolvableSearchNode;
import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLAxiom;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLDataFactory;
import org.semanticweb.owlapi.model.OWLObjectProperty;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;
import org.semanticweb.owlapi.model.OWLOntologyManager;
import org.semanticweb.owlapi.model.OWLSubClassOfAxiom;

import com.clarkparsia.pellet.owlapiv3.PelletReasoner;
import com.clarkparsia.pellet.owlapiv3.PelletReasonerFactory;

public class AxiomSolvabilityTest extends TestCase {
	@Override
	protected void setUp() throws Exception {
		super.setUp();
	}

	public void testSolvableSubClassAxiom() {
		OWLOntologyManager manager = OWLManager.createOWLOntologyManager();
		OWLOntology ontology;
		try {
			ontology = manager.createOntology();
			OPPLFactory opplFactory = new OPPLFactory(manager, ontology, null);
			ConstraintSystem constraintSystem = opplFactory.createConstraintSystem();
			Variable x = constraintSystem.createVariable("?x", VariableType.CLASS);
			OWLDataFactory dataFactory = manager.getOWLDataFactory();
			manager.addAxiom(ontology, dataFactory.getOWLSubClassOfAxiom(
					dataFactory.getOWLClass(IRI.create("A")),
					dataFactory.getOWLClass(IRI.create("A"))));
			OWLSubClassOfAxiom axiom = dataFactory.getOWLSubClassOfAxiom(
					dataFactory.getOWLClass(x.getIRI()),
					dataFactory.getOWLClass(IRI.create("A")));
			AxiomSolvability axiomSolvability = new AxiomSolvability(constraintSystem,
					BindingNode.createNewEmptyBindingNode(), new AssertedModelQuerySolver(manager));
			SolvabilitySearchNode node = axiom.accept(axiomSolvability);
			node.accept(new SolvabilitySearchNodeVisitor() {
				public void visitUnsolvableSearchNode(UnsolvableSearchNode unsolvableSearchNode) {
					fail("Wrong type of solvability node: unsolvable, when expecting solavble");
				}

				public void visitSolvedSearchNode(SolvedSearchNode solvedSearchNode) {
					fail("Wrong type of solvability node: solved, when expecting solavble");
				}

				public void visitSolvableSearchNode(SolvableSearchNode solvableSearchNode) {
					// That's fine
					System.out.println("Values " + solvableSearchNode.getValues());
				}
			});
		} catch (OWLOntologyCreationException e) {
			e.printStackTrace();
			fail(e.getMessage());
		} catch (OPPLException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	public void testInferredSolvableSubClassAxiom() {
		OWLOntologyManager manager = OWLManager.createOWLOntologyManager();
		OWLOntology ontology;
		try {
			ontology = manager.createOntology();
			PelletReasonerFactory reasonerFactory = new PelletReasonerFactory();
			PelletReasoner reasoner = reasonerFactory.createReasoner(ontology);
			OPPLFactory opplFactory = new OPPLFactory(manager, ontology, reasoner);
			ConstraintSystem constraintSystem = opplFactory.createConstraintSystem();
			Variable x = constraintSystem.createVariable("?x", VariableType.CLASS);
			OWLDataFactory dataFactory = manager.getOWLDataFactory();
			OWLSubClassOfAxiom axiom = dataFactory.getOWLSubClassOfAxiom(
					dataFactory.getOWLClass(x.getIRI()),
					dataFactory.getOWLClass(IRI.create("A")));
			AxiomSolvability axiomSolvability = new AxiomSolvability(constraintSystem,
					BindingNode.createNewEmptyBindingNode(), new InferredModelQuerySolver(reasoner));
			SolvabilitySearchNode node = axiom.accept(axiomSolvability);
			node.accept(new SolvabilitySearchNodeVisitor() {
				public void visitUnsolvableSearchNode(UnsolvableSearchNode unsolvableSearchNode) {
					fail("Wrong type of solvability node: unsolvable, when expecting solavble");
				}

				public void visitSolvedSearchNode(SolvedSearchNode solvedSearchNode) {
					fail("Wrong type of solvability node: solved, when expecting solavble");
				}

				public void visitSolvableSearchNode(SolvableSearchNode solvableSearchNode) {
					// That's fine
					System.out.println("Values " + solvableSearchNode.getValues());
				}
			});
		} catch (OWLOntologyCreationException e) {
			e.printStackTrace();
			fail(e.getMessage());
		} catch (OPPLException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	public void testSolvableSubClassAxiomMultipleValues() {
		OWLOntologyManager manager = OWLManager.createOWLOntologyManager();
		OWLOntology ontology;
		try {
			ontology = manager.createOntology();
			OPPLFactory opplFactory = new OPPLFactory(manager, ontology, null);
			ConstraintSystem constraintSystem = opplFactory.createConstraintSystem();
			Variable x = constraintSystem.createVariable("?x", VariableType.CLASS);
			OWLDataFactory dataFactory = manager.getOWLDataFactory();
			manager.addAxioms(
					ontology,
					new HashSet<OWLAxiom>(Arrays.asList(
							dataFactory.getOWLSubClassOfAxiom(
									dataFactory.getOWLClass(IRI.create("A")),
									dataFactory.getOWLClass(IRI.create("A"))),
							dataFactory.getOWLSubClassOfAxiom(
									dataFactory.getOWLClass(IRI.create("B")),
									dataFactory.getOWLClass(IRI.create("A"))))));
			OWLSubClassOfAxiom axiom = dataFactory.getOWLSubClassOfAxiom(
					dataFactory.getOWLClass(x.getIRI()),
					dataFactory.getOWLClass(IRI.create("A")));
			AxiomSolvability axiomSolvability = new AxiomSolvability(constraintSystem,
					BindingNode.createNewEmptyBindingNode(), new AssertedModelQuerySolver(manager));
			SolvabilitySearchNode node = axiom.accept(axiomSolvability);
			node.accept(new SolvabilitySearchNodeVisitor() {
				public void visitUnsolvableSearchNode(UnsolvableSearchNode unsolvableSearchNode) {
					fail("Wrong type of solvability node: unsolvable, when expecting solavble");
				}

				public void visitSolvedSearchNode(SolvedSearchNode solvedSearchNode) {
					fail("Wrong type of solvability node: solved, when expecting solavble");
				}

				public void visitSolvableSearchNode(SolvableSearchNode solvableSearchNode) {
					assertTrue(solvableSearchNode.getValues().size() == 2);
					System.out.println("Values " + solvableSearchNode.getValues());
				}
			});
		} catch (OWLOntologyCreationException e) {
			e.printStackTrace();
			fail(e.getMessage());
		} catch (OPPLException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	public void testSolvableSubClassAxiomComplexExpression() {
		OWLOntologyManager manager = OWLManager.createOWLOntologyManager();
		OWLOntology ontology;
		try {
			ontology = manager.createOntology();
			OPPLFactory opplFactory = new OPPLFactory(manager, ontology, null);
			ConstraintSystem constraintSystem = opplFactory.createConstraintSystem();
			Variable x = constraintSystem.createVariable("?x", VariableType.CLASS);
			OWLDataFactory dataFactory = manager.getOWLDataFactory();
			OWLClass a = dataFactory.getOWLClass(IRI.create("A"));
			OWLObjectProperty p = dataFactory.getOWLObjectProperty(IRI.create("p"));
			manager.addAxiom(
					ontology,
					dataFactory.getOWLSubClassOfAxiom(
							a,
							dataFactory.getOWLObjectSomeValuesFrom(p, a)));
			OWLSubClassOfAxiom axiom = dataFactory.getOWLSubClassOfAxiom(
					dataFactory.getOWLClass(x.getIRI()),
					dataFactory.getOWLObjectSomeValuesFrom(p, a));
			AxiomSolvability axiomSolvability = new AxiomSolvability(constraintSystem,
					BindingNode.createNewEmptyBindingNode(), new AssertedModelQuerySolver(manager));
			SolvabilitySearchNode node = axiom.accept(axiomSolvability);
			node.accept(new SolvabilitySearchNodeVisitor() {
				public void visitUnsolvableSearchNode(UnsolvableSearchNode unsolvableSearchNode) {
					fail("Wrong type of solvability node: unsolvable, when expecting solavble");
				}

				public void visitSolvedSearchNode(SolvedSearchNode solvedSearchNode) {
					fail("Wrong type of solvability node: solved, when expecting solavble");
				}

				public void visitSolvableSearchNode(SolvableSearchNode solvableSearchNode) {
					// That's fine
					System.out.println("Values " + solvableSearchNode.getValues());
				}
			});
		} catch (OWLOntologyCreationException e) {
			e.printStackTrace();
			fail(e.getMessage());
		} catch (OPPLException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	public void testUnSolvableSubClassAxiomComplexExpression() {
		OWLOntologyManager manager = OWLManager.createOWLOntologyManager();
		OWLOntology ontology;
		try {
			ontology = manager.createOntology();
			OPPLFactory opplFactory = new OPPLFactory(manager, ontology, null);
			ConstraintSystem constraintSystem = opplFactory.createConstraintSystem();
			Variable x = constraintSystem.createVariable("?x", VariableType.CLASS);
			OWLDataFactory dataFactory = manager.getOWLDataFactory();
			OWLClass a = dataFactory.getOWLClass(IRI.create("A"));
			OWLObjectProperty p = dataFactory.getOWLObjectProperty(IRI.create("p"));
			manager.addAxiom(
					ontology,
					dataFactory.getOWLSubClassOfAxiom(
							a,
							dataFactory.getOWLObjectSomeValuesFrom(p, a)));
			OWLSubClassOfAxiom axiom = dataFactory.getOWLSubClassOfAxiom(
					dataFactory.getOWLObjectIntersectionOf(a, dataFactory.getOWLClass(x.getIRI())),
					dataFactory.getOWLObjectSomeValuesFrom(p, a));
			AxiomSolvability axiomSolvability = new AxiomSolvability(constraintSystem,
					BindingNode.createNewEmptyBindingNode(), new AssertedModelQuerySolver(manager));
			SolvabilitySearchNode node = axiom.accept(axiomSolvability);
			node.accept(new SolvabilitySearchNodeVisitor() {
				public void visitUnsolvableSearchNode(UnsolvableSearchNode unsolvableSearchNode) {
					// That's fine
				}

				public void visitSolvedSearchNode(SolvedSearchNode solvedSearchNode) {
					fail("Wrong type of solvability node: solved, when expecting unsolavble");
				}

				public void visitSolvableSearchNode(SolvableSearchNode solvableSearchNode) {
					fail("Wrong type of solvability node: solvable, when expecting unsolavble");
				}
			});
		} catch (OWLOntologyCreationException e) {
			e.printStackTrace();
			fail(e.getMessage());
		} catch (OPPLException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	public void testUnsolvableSubClassAxiom() {
		OWLOntologyManager manager = OWLManager.createOWLOntologyManager();
		OWLOntology ontology;
		try {
			ontology = manager.createOntology();
			OPPLFactory opplFactory = new OPPLFactory(manager, ontology, null);
			ConstraintSystem constraintSystem = opplFactory.createConstraintSystem();
			Variable x = constraintSystem.createVariable("?x", VariableType.CLASS);
			Variable y = constraintSystem.createVariable("?y", VariableType.CLASS);
			OWLDataFactory dataFactory = manager.getOWLDataFactory();
			manager.addAxiom(ontology, dataFactory.getOWLSubClassOfAxiom(
					dataFactory.getOWLClass(IRI.create("A")),
					dataFactory.getOWLClass(IRI.create("A"))));
			OWLSubClassOfAxiom axiom = dataFactory.getOWLSubClassOfAxiom(
					dataFactory.getOWLClass(x.getIRI()),
					dataFactory.getOWLClass(y.getIRI()));
			AxiomSolvability axiomSolvability = new AxiomSolvability(constraintSystem,
					BindingNode.createNewEmptyBindingNode(), new AssertedModelQuerySolver(manager));
			SolvabilitySearchNode node = axiom.accept(axiomSolvability);
			node.accept(new SolvabilitySearchNodeVisitor() {
				public void visitUnsolvableSearchNode(UnsolvableSearchNode unsolvableSearchNode) {
					// That's fine
				}

				public void visitSolvedSearchNode(SolvedSearchNode solvedSearchNode) {
					fail("Wrong type of solvability node: solved, when expecting unsolavble");
				}

				public void visitSolvableSearchNode(SolvableSearchNode solvableSearchNode) {
					fail("Wrong type of solvability node: solvable, when expecting unsolavble");
				}
			});
		} catch (OWLOntologyCreationException e) {
			e.printStackTrace();
			fail(e.getMessage());
		} catch (OPPLException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
}