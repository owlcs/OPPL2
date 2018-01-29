package org.coode.oppl.queryplanner;

import static org.semanticweb.owlapi.util.OWLAPIStreamUtils.add;

import java.util.HashSet;
import java.util.Set;

import org.coode.oppl.ConstraintVisitor;
import org.coode.oppl.InCollectionConstraint;
import org.coode.oppl.InequalityConstraint;
import org.coode.oppl.NAFConstraint;
import org.coode.oppl.RegExpConstraint;
import org.coode.oppl.Variable;
import org.coode.oppl.utils.VariableExtractor;
import org.semanticweb.owlapi.model.OWLObject;

/**
 * @author Luigi Iannone
 */
public class QueryItemVariableExtractor implements QueryPlannerVisitorEx<Set<Variable<?>>> {

    @Override
    public Set<Variable<?>> visitConstraintQueryPlannerItem(
        ConstraintQueryPlannerItem constraintQueryPlannerItem) {
        final Set<Variable<?>> toReturn = new HashSet<>();
        final VariableExtractor variableExtractor =
            new VariableExtractor(constraintQueryPlannerItem.getConstraintSystem(), false);
        constraintQueryPlannerItem.getConstraint().accept(new ConstraintVisitor() {

            @Override
            public void visitInequalityConstraint(InequalityConstraint c) {
                toReturn.add(c.getVariable());
                toReturn.addAll(variableExtractor.extractVariables(c.getExpression()));
            }

            @Override
            public void visitInCollectionConstraint(InCollectionConstraint<? extends OWLObject> c) {
                toReturn.add(c.getVariable());
                add(toReturn,
                    c.collection().flatMap(v -> variableExtractor.extractVariables(v).stream()));
            }

            @Override
            public void visitInCollectionConstraint(RegExpConstraint c) {
                toReturn.add(c.getVariable());
                toReturn.addAll(variableExtractor.extractVariables(c.getExpression()));
            }

            @Override
            public void visit(NAFConstraint nafConstraint) {
                toReturn.addAll(variableExtractor.extractVariables(nafConstraint.getAxiom()));
            }
        });
        return toReturn;
    }

    @Override
    public Set<Variable<?>> visitAssertedAxiomPlannerItem(
        AssertedAxiomPlannerItem assertedAxiomPlannerItem) {
        VariableExtractor variableExtractor =
            new VariableExtractor(assertedAxiomPlannerItem.getConstraintSystem(), false);
        return variableExtractor.extractVariables(assertedAxiomPlannerItem.getAxiom());
    }

    @Override
    public Set<Variable<?>> visitInferredAxiomQueryPlannerItem(
        InferredAxiomQueryPlannerItem inferredAxiomQueryPlannerItem) {
        VariableExtractor variableExtractor =
            new VariableExtractor(inferredAxiomQueryPlannerItem.getConstraintSystem(), false);
        return variableExtractor.extractVariables(inferredAxiomQueryPlannerItem.getAxiom());
    }
}
