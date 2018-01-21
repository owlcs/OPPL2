package org.coode.oppl.search.solvability;

import org.coode.oppl.ConstraintSystem;
import org.coode.oppl.Variable;
import org.coode.oppl.bindingtree.BindingNode;
import org.coode.oppl.utils.VariableExtractor;
import org.semanticweb.owlapi.model.OWLAxiom;
import org.semanticweb.owlapi.model.OWLObjectPropertyAssertionAxiom;
import org.semanticweb.owlapi.model.OWLObjectVisitorEx;

/**
 * @author Luigi Iannone
 */
public class OWLObjectPropertyFillersAxiomSolvability
    extends QuerySolverBasedAbstractAxiomSolvability {

    /**
     * @param constraintSystem constraintSystem
     * @param querySolver querySolver
     */
    public OWLObjectPropertyFillersAxiomSolvability(ConstraintSystem constraintSystem,
        QuerySolver querySolver) {
        super(constraintSystem, querySolver);
    }

    @Override
    public SolvabilitySearchNode getSolvabilitySearchNode(OWLAxiom owlAxiom,
        final BindingNode bindingNode) {
        final VariableExtractor variableExtractor =
            new VariableExtractor(getConstraintSystem(), true);
        return owlAxiom.accept(new OWLObjectVisitorEx<SolvabilitySearchNode>() {
            @Override
            public <T> SolvabilitySearchNode doDefault(T object) {
                return new UnsolvableSearchNode((OWLAxiom) object, bindingNode);
            }

            @Override
            public SolvabilitySearchNode visit(OWLObjectPropertyAssertionAxiom axiom) {
                SolvabilitySearchNode toReturn = new UnsolvableSearchNode(axiom, bindingNode);
                boolean isSolvable =
                    variableExtractor.extractVariables(axiom.getSubject()).isEmpty()
                        && axiom.getSubject().isNamed()
                        && variableExtractor.extractVariables(axiom.getProperty()).isEmpty()
                        && variableExtractor.extractVariables(axiom.getObject()).size() == 1;
                if (isSolvable) {
                    Variable<?> variable =
                        variableExtractor.extractVariables(axiom.getObject()).iterator().next();
                    toReturn = new SolvableSearchNode(variable, axiom, bindingNode,
                        OWLObjectPropertyFillersAxiomSolvability.this.getQuerySolver()
                            .getNamedFillers(axiom.getSubject().asOWLNamedIndividual(),
                                axiom.getProperty()));
                }
                return toReturn;
            }
        });
    }
}
