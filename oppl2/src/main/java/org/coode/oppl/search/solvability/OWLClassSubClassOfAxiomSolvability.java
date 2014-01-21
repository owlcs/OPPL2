package org.coode.oppl.search.solvability;

import org.coode.oppl.ConstraintSystem;
import org.coode.oppl.Variable;
import org.coode.oppl.bindingtree.BindingNode;
import org.coode.oppl.utils.VariableExtractor;
import org.semanticweb.owlapi.model.OWLAxiom;
import org.semanticweb.owlapi.model.OWLObject;
import org.semanticweb.owlapi.model.OWLSubClassOfAxiom;
import org.semanticweb.owlapi.util.OWLObjectVisitorExAdapter;

/** @author Luigi Iannone */
public final class OWLClassSubClassOfAxiomSolvability extends
        QuerySolverBasedAbstractAxiomSolvability {
    /** @param constraintSystem
     *            constraintSystem
     * @param querySolver
     *            querySolver */
    public OWLClassSubClassOfAxiomSolvability(ConstraintSystem constraintSystem,
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
                // Solvable sub-class axioms are in the form ?x
                // subClassOf <Variable
                // Free Class Expression>
                // or <Variable Free Class Expression> subClassOf ?x
                boolean isSolvable = variableExtractor.extractVariables(axiom).size() == 1
                        && (variableExtractor.extractVariables(axiom.getSuperClass())
                                .isEmpty()
                                && !axiom.getSubClass().isAnonymous()
                                && variableExtractor
                                        .extractVariables(axiom.getSubClass()).size() == 1 || variableExtractor
                                .extractVariables(axiom.getSubClass()).isEmpty()
                                && !axiom.getSuperClass().isAnonymous()
                                && variableExtractor.extractVariables(
                                        axiom.getSuperClass()).size() == 1);
                if (isSolvable) {
                    Variable<?> variable = variableExtractor.extractVariables(axiom)
                            .iterator().next();
                    toReturn = variableExtractor.extractVariables(axiom.getSubClass())
                            .isEmpty() ? new SolvableSearchNode(variable, axiom,
                            bindingNode, OWLClassSubClassOfAxiomSolvability.this
                                    .getQuerySolver()
                                    .getSuperClasses(axiom.getSubClass()))
                            : new SolvableSearchNode(variable, axiom, bindingNode,
                                    OWLClassSubClassOfAxiomSolvability.this
                                            .getQuerySolver().getSubClasses(
                                                    axiom.getSuperClass()));
                }
                return toReturn;
            }
        });
    }
}
