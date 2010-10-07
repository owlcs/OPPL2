package org.coode.oppl.search.solvability.test;

import junit.framework.TestCase;

import org.coode.oppl.ConstraintSystem;
import org.coode.oppl.OPPLFactory;
import org.coode.oppl.Variable;
import org.coode.oppl.VariableType;
import org.coode.oppl.exceptions.OPPLException;
import org.coode.oppl.querymatching.AssertedSolvabilityBasedAxiomQuery;
import org.coode.oppl.querymatching.AssertedTreeSearchSingleAxiomQuery;
import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLDataFactory;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;
import org.semanticweb.owlapi.model.OWLOntologyManager;
import org.semanticweb.owlapi.model.OWLSubClassOfAxiom;

public class TestAssertedSolvabilityBasedAxiomQuery extends TestCase {
	@Override
	protected void setUp() throws Exception {
		super.setUp();
	}

	public void testSubClassAxiom() {
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
			AssertedSolvabilityBasedAxiomQuery assertedSolvabilityBasedAxiomQuery = new AssertedSolvabilityBasedAxiomQuery(
					manager.getOntologies(), constraintSystem);
			axiom.accept(assertedSolvabilityBasedAxiomQuery);
			ConstraintSystem newConstraintSystem = opplFactory.createConstraintSystem();
			newConstraintSystem.importVariable(x);
			AssertedTreeSearchSingleAxiomQuery assertedTreeSearchSingleAxiomQuery = new AssertedTreeSearchSingleAxiomQuery(
					manager.getOntologies(), newConstraintSystem);
			axiom.accept(assertedTreeSearchSingleAxiomQuery);
			assertTrue(constraintSystem.getLeaves().equals(newConstraintSystem.getLeaves()));
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
			ConstraintSystem newConstraintSystem = opplFactory.createConstraintSystem();
			newConstraintSystem.importVariable(x);
			newConstraintSystem.importVariable(y);
			AssertedSolvabilityBasedAxiomQuery assertedSolvabilityBasedAxiomQuery = new AssertedSolvabilityBasedAxiomQuery(
					manager.getOntologies(), constraintSystem);
			axiom.accept(assertedSolvabilityBasedAxiomQuery);
			AssertedTreeSearchSingleAxiomQuery assertedTreeSearchSingleAxiomQuery = new AssertedTreeSearchSingleAxiomQuery(
					manager.getOntologies(), newConstraintSystem);
			axiom.accept(assertedTreeSearchSingleAxiomQuery);
			assertTrue(constraintSystem.getLeaves().equals(newConstraintSystem.getLeaves()));
		} catch (OWLOntologyCreationException e) {
			e.printStackTrace();
			fail(e.getMessage());
		} catch (OPPLException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
}
