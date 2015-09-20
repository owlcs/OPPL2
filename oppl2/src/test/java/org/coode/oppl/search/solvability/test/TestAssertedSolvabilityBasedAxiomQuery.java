package org.coode.oppl.search.solvability.test;

import static org.junit.Assert.assertTrue;

import org.coode.oppl.ConstraintSystem;
import org.coode.oppl.OPPLFactory;
import org.coode.oppl.Variable;
import org.coode.oppl.exceptions.QuickFailRuntimeExceptionHandler;
import org.coode.oppl.exceptions.RuntimeExceptionHandler;
import org.coode.oppl.querymatching.AssertedSolvabilityBasedAxiomQuery;
import org.coode.oppl.querymatching.AssertedTreeSearchSingleAxiomQuery;
import org.coode.oppl.variabletypes.VariableTypeFactory;
import org.junit.Test;
import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.model.*;

@SuppressWarnings("javadoc")
public class TestAssertedSolvabilityBasedAxiomQuery {

    private final static RuntimeExceptionHandler HANDLER = new QuickFailRuntimeExceptionHandler();

    @Test
    public void shouldTestSubClassAxiom() throws Exception {
        OWLOntologyManager manager = OWLManager.createOWLOntologyManager();
        OWLOntology ontology = manager.createOntology();
        OPPLFactory opplFactory = new OPPLFactory(manager, ontology, null);
        ConstraintSystem constraintSystem = opplFactory.createConstraintSystem();
        Variable<OWLClassExpression> x = constraintSystem.createVariable("?x",
            VariableTypeFactory.getCLASSVariableType(), null);
        OWLDataFactory dataFactory = manager.getOWLDataFactory();
        manager.addAxiom(
            ontology,
            dataFactory.getOWLSubClassOfAxiom(
                dataFactory.getOWLClass(IRI.create("A")),
                dataFactory.getOWLClass(IRI.create("A"))));
        OWLSubClassOfAxiom axiom = dataFactory.getOWLSubClassOfAxiom(
            dataFactory.getOWLClass(x.getIRI()),
            dataFactory.getOWLClass(IRI.create("A")));
        AssertedSolvabilityBasedAxiomQuery assertedSolvabilityBasedAxiomQuery = new AssertedSolvabilityBasedAxiomQuery(
            manager, constraintSystem, HANDLER);
        axiom.accept(assertedSolvabilityBasedAxiomQuery);
        constraintSystem.setLeaves(assertedSolvabilityBasedAxiomQuery.getLeaves());
        ConstraintSystem newConstraintSystem = opplFactory.createConstraintSystem();
        newConstraintSystem.importVariable(x);
        AssertedTreeSearchSingleAxiomQuery assertedTreeSearchSingleAxiomQuery = new AssertedTreeSearchSingleAxiomQuery(
            manager.getOntologies(), newConstraintSystem, HANDLER);
        axiom.accept(assertedTreeSearchSingleAxiomQuery);
        newConstraintSystem.setLeaves(assertedTreeSearchSingleAxiomQuery.getLeaves());
        assertTrue(constraintSystem.getLeaves().equals(newConstraintSystem.getLeaves()));
    }

    @Test
    public void shouldTestUnsolvableSubClassAxiom() throws Exception {
        OWLOntologyManager manager = OWLManager.createOWLOntologyManager();
        OWLOntology ontology = manager.createOntology();
        OPPLFactory opplFactory = new OPPLFactory(manager, ontology, null);
        ConstraintSystem constraintSystem = opplFactory.createConstraintSystem();
        Variable<OWLClassExpression> x = constraintSystem.createVariable("?x",
            VariableTypeFactory.getCLASSVariableType(), null);
        Variable<OWLClassExpression> y = constraintSystem.createVariable("?y",
            VariableTypeFactory.getCLASSVariableType(), null);
        OWLDataFactory dataFactory = manager.getOWLDataFactory();
        manager.addAxiom(
            ontology,
            dataFactory.getOWLSubClassOfAxiom(
                dataFactory.getOWLClass(IRI.create("A")),
                dataFactory.getOWLClass(IRI.create("A"))));
        OWLSubClassOfAxiom axiom = dataFactory.getOWLSubClassOfAxiom(
            dataFactory.getOWLClass(x.getIRI()), dataFactory.getOWLClass(y.getIRI()));
        ConstraintSystem newConstraintSystem = opplFactory.createConstraintSystem();
        newConstraintSystem.importVariable(x);
        newConstraintSystem.importVariable(y);
        AssertedSolvabilityBasedAxiomQuery assertedSolvabilityBasedAxiomQuery = new AssertedSolvabilityBasedAxiomQuery(
            manager, constraintSystem, HANDLER);
        axiom.accept(assertedSolvabilityBasedAxiomQuery);
        constraintSystem.setLeaves(assertedSolvabilityBasedAxiomQuery.getLeaves());
        AssertedTreeSearchSingleAxiomQuery assertedTreeSearchSingleAxiomQuery = new AssertedTreeSearchSingleAxiomQuery(
            manager.getOntologies(), newConstraintSystem, HANDLER);
        axiom.accept(assertedTreeSearchSingleAxiomQuery);
        newConstraintSystem.setLeaves(assertedTreeSearchSingleAxiomQuery.getLeaves());
        assertTrue(constraintSystem.getLeaves().equals(newConstraintSystem.getLeaves()));
    }
}
