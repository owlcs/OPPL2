package org.coode.oppl.search.solvability;

import static org.coode.oppl.utils.ArgCheck.checkNotNull;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;

import org.coode.oppl.ConstraintSystem;
import org.coode.oppl.Variable;
import org.coode.oppl.exceptions.RuntimeExceptionHandler;
import org.coode.oppl.utils.VariableExtractor;
import org.semanticweb.owlapi.model.OWLAxiom;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyManager;

/** @author Luigi Iannone */
public class AssertedSolvabilitySearchTree extends
        AbstractSolvabilityOPPLOWLAxiomSearchTree {
    private final OWLOntologyManager ontologyManager;

    /** @param constraintSystem
     *            constraintSystem
     * @param ontologyManager
     *            ontologyManager
     * @param runtimeExceptionHandler
     *            runtimeExceptionHandler */
    public AssertedSolvabilitySearchTree(ConstraintSystem constraintSystem,
            OWLOntologyManager ontologyManager,
            RuntimeExceptionHandler runtimeExceptionHandler) {
        super(constraintSystem, runtimeExceptionHandler);
        this.ontologyManager = checkNotNull(ontologyManager, "ontologyManager");
    }

    @Override
    protected AxiomSolvability getAxiomSolvability() {
        AssertedModelQuerySolver querySolver = new AssertedModelQuerySolver(
                getOntologyManager());
        return new MultipleAxiomSolvability(
                Arrays.asList(
                        new OWLClassSubClassOfAxiomSolvability(getConstraintSystem(),
                                querySolver),
                        new NoResultsAxiomSolvability(getConstraintSystem(), querySolver),
                        new OWLObjectPropertyFillersAxiomSolvability(
                                getConstraintSystem(), querySolver)));
    }

    @Override
    protected boolean
            goalReachedUnsolvabelNode(UnsolvableSearchNode unsolvableSearchNode) {
        VariableExtractor variableExtractor = new VariableExtractor(
                getConstraintSystem(), true);
        Set<Variable<?>> extractVariables = variableExtractor
                .extractVariables(unsolvableSearchNode.getAxiom());
        return extractVariables.isEmpty() ? findAxiom(unsolvableSearchNode.getAxiom())
                : false;
    }

    private boolean findAxiom(OWLAxiom axiom) {
        boolean found = false;
        Iterator<OWLOntology> iterator = getConstraintSystem().getOntologyManager()
                .getOntologies().iterator();
        while (!found && iterator.hasNext()) {
            OWLOntology ontology = iterator.next();
            found = ontology.containsAxiom(axiom);
        }
        return found;
    }

    /** @return the ontologyManager */
    public OWLOntologyManager getOntologyManager() {
        return ontologyManager;
    }
}
