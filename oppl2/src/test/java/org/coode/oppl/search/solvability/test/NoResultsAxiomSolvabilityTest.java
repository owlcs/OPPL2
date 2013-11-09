package org.coode.oppl.search.solvability.test;

import static org.junit.Assert.fail;

import org.coode.oppl.ConstraintSystem;
import org.coode.oppl.OPPLFactory;
import org.coode.oppl.Variable;
import org.coode.oppl.bindingtree.BindingNode;
import org.coode.oppl.search.solvability.AssertedModelQuerySolver;
import org.coode.oppl.search.solvability.AxiomSolvability;
import org.coode.oppl.search.solvability.NoResultsAxiomSolvability;
import org.coode.oppl.search.solvability.NoSolutionSolvableSearchNode;
import org.coode.oppl.search.solvability.SolvabilitySearchNode;
import org.coode.oppl.search.solvability.SolvabilitySearchNodeVisitor;
import org.coode.oppl.search.solvability.SolvableSearchNode;
import org.coode.oppl.search.solvability.SolvedSearchNode;
import org.coode.oppl.search.solvability.UnsolvableSearchNode;
import org.coode.oppl.variabletypes.VariableTypeFactory;
import org.junit.Test;
import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLClassExpression;
import org.semanticweb.owlapi.model.OWLDataFactory;
import org.semanticweb.owlapi.model.OWLObjectProperty;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyManager;
import org.semanticweb.owlapi.model.OWLSubClassOfAxiom;

public class NoResultsAxiomSolvabilityTest {
    @Test
    public void testNoResultsSubClassAxiom() throws Exception {
        OWLOntologyManager manager = OWLManager.createOWLOntologyManager();
        OWLOntology ontology = manager.createOntology();
        OPPLFactory opplFactory = new OPPLFactory(manager, ontology, null);
        ConstraintSystem constraintSystem = opplFactory.createConstraintSystem();
        Variable<OWLClassExpression> x = constraintSystem.createVariable("?x",
                VariableTypeFactory.getCLASSVariableType(), null);
        OWLDataFactory dataFactory = manager.getOWLDataFactory();
        OWLClass a = dataFactory.getOWLClass(IRI.create("A"));
        OWLClass b = dataFactory.getOWLClass(IRI.create("B"));
        OWLClass c = dataFactory.getOWLClass(IRI.create("C"));
        OWLObjectProperty p = dataFactory.getOWLObjectProperty(IRI.create("p"));
        manager.addAxiom(
                ontology,
                dataFactory.getOWLSubClassOfAxiom(
                        dataFactory.getOWLObjectSomeValuesFrom(p, a),
                        dataFactory.getOWLObjectSomeValuesFrom(p, b)));
        OWLSubClassOfAxiom axiom = dataFactory.getOWLSubClassOfAxiom(
                dataFactory.getOWLObjectSomeValuesFrom(p,
                        dataFactory.getOWLClass(x.getIRI())),
                dataFactory.getOWLObjectSomeValuesFrom(p, c));
        AxiomSolvability axiomSolvability = new NoResultsAxiomSolvability(
                constraintSystem, new AssertedModelQuerySolver(manager));
        SolvabilitySearchNode node = axiomSolvability.getSolvabilitySearchNode(axiom,
                BindingNode.createNewEmptyBindingNode());
        node.accept(new SolvabilitySearchNodeVisitor() {
            public void visitUnsolvableSearchNode(
                    UnsolvableSearchNode unsolvableSearchNode) {
                fail("Wrong type of solvability node: unsolvable, when expecting no solutions");
            }

            public void visitSolvedSearchNode(SolvedSearchNode solvedSearchNode) {
                fail("Wrong type of solvability node: solved, when expecting no solutions");
            }

            public void visitNoSolutionSolvableSearchNode(
                    NoSolutionSolvableSearchNode noSolutionSolvableSearchNode) {
                // That's fine
            }

            public void visitSolvableSearchNode(SolvableSearchNode solvableSearchNode) {
                fail("Wrong type of solvability node: no solution, when expecting no solutions");
            }
        });
    }

    @Test
    public void testUnsolvableSubClassAxiom() throws Exception {
        OWLOntologyManager manager = OWLManager.createOWLOntologyManager();
        OWLOntology ontology = manager.createOntology();
        OPPLFactory opplFactory = new OPPLFactory(manager, ontology, null);
        ConstraintSystem constraintSystem = opplFactory.createConstraintSystem();
        Variable<OWLClassExpression> x = constraintSystem.createVariable("?x",
                VariableTypeFactory.getCLASSVariableType(), null);
        OWLDataFactory dataFactory = manager.getOWLDataFactory();
        OWLClass a = dataFactory.getOWLClass(IRI.create("A"));
        OWLClass b = dataFactory.getOWLClass(IRI.create("B"));
        OWLObjectProperty p = dataFactory.getOWLObjectProperty(IRI.create("p"));
        manager.addAxiom(
                ontology,
                dataFactory.getOWLSubClassOfAxiom(
                        dataFactory.getOWLObjectSomeValuesFrom(p, a),
                        dataFactory.getOWLObjectSomeValuesFrom(p, b)));
        OWLSubClassOfAxiom axiom = dataFactory.getOWLSubClassOfAxiom(
                dataFactory.getOWLObjectSomeValuesFrom(p,
                        dataFactory.getOWLClass(x.getIRI())),
                dataFactory.getOWLObjectSomeValuesFrom(p, b));
        AxiomSolvability axiomSolvability = new NoResultsAxiomSolvability(
                constraintSystem, new AssertedModelQuerySolver(manager));
        SolvabilitySearchNode node = axiomSolvability.getSolvabilitySearchNode(axiom,
                BindingNode.createNewEmptyBindingNode());
        node.accept(new SolvabilitySearchNodeVisitor() {
            public void visitUnsolvableSearchNode(
                    UnsolvableSearchNode unsolvableSearchNode) {
                // That's fine
            }

            public void visitSolvedSearchNode(SolvedSearchNode solvedSearchNode) {
                fail("Wrong type of solvability node: solved, when expecting unsolvable");
            }

            public void visitNoSolutionSolvableSearchNode(
                    NoSolutionSolvableSearchNode noSolutionSolvableSearchNode) {
                fail("Wrong type of solvability node: no solutions, when expecting unsolvable");
            }

            public void visitSolvableSearchNode(SolvableSearchNode solvableSearchNode) {
                fail("Wrong type of solvability node: no solution, when expecting unsolvable");
            }
        });
    }
}
