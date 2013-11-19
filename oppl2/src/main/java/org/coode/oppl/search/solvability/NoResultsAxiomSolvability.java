package org.coode.oppl.search.solvability;

import org.coode.oppl.ConstraintSystem;
import org.coode.oppl.bindingtree.BindingNode;
import org.coode.oppl.utils.VariableExtractor;
import org.semanticweb.owlapi.model.OWLAxiom;
import org.semanticweb.owlapi.model.OWLObject;
import org.semanticweb.owlapi.model.OWLSubClassOfAxiom;
import org.semanticweb.owlapi.util.OWLObjectVisitorExAdapter;

/** @author Luigi Iannone */
public class NoResultsAxiomSolvability extends QuerySolverBasedAbstractAxiomSolvability
        implements AxiomSolvability {
    /** @param constraintSystem
     * @param querySolver */
    public NoResultsAxiomSolvability(ConstraintSystem constraintSystem,
            QuerySolver querySolver) {
        super(constraintSystem, querySolver);
    }

    @Override
    public SolvabilitySearchNode getSolvabilitySearchNode(OWLAxiom owlAxiom,
            final BindingNode bindingNode) {
        final VariableExtractor variableExtractor = new VariableExtractor(
                getConstraintSystem(), true);
        return owlAxiom.accept(new OWLObjectVisitorExAdapter<SolvabilitySearchNode>() {
            @Override
            protected SolvabilitySearchNode getDefaultReturnValue(OWLObject object) {
                return new UnsolvableSearchNode((OWLAxiom) object, bindingNode);
            }

            @Override
            public SolvabilitySearchNode visit(OWLSubClassOfAxiom axiom) {
                SolvabilitySearchNode toReturn = new UnsolvableSearchNode(axiom,
                        bindingNode);
                // Solvable sub-class axioms are in the form <subClass>
                // subClassOf <superClass>
                // where either superClass or subClass is variable free
                boolean variableFreeSuperClass = variableExtractor.extractVariables(
                        axiom.getSuperClass()).isEmpty();
                boolean variableFreeSubClass = variableExtractor.extractVariables(
                        axiom.getSubClass()).isEmpty();
                boolean canBeSolved = variableFreeSubClass
                        && axiom.getSuperClass().isAnonymous() || variableFreeSuperClass
                        && axiom.getSubClass().isAnonymous();
                if (canBeSolved && variableFreeSubClass) {
                    toReturn = NoResultsAxiomSolvability.this.getQuerySolver()
                            .hasNoSuperClass(axiom.getSubClass()) ? new NoSolutionSolvableSearchNode(
                            axiom, bindingNode) : toReturn;
                } else if (canBeSolved && variableFreeSuperClass) {
                    toReturn = NoResultsAxiomSolvability.this.getQuerySolver()
                            .hasNoSubClass(axiom.getSuperClass()) ? new NoSolutionSolvableSearchNode(
                            axiom, bindingNode) : toReturn;
                }
                return toReturn;
            }
        });
    }
}
