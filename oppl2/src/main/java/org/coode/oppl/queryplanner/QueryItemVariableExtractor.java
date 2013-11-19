package org.coode.oppl.queryplanner;

import java.util.HashSet;
import java.util.Set;

import org.coode.oppl.ConstraintVisitorEx;
import org.coode.oppl.InCollectionConstraint;
import org.coode.oppl.InequalityConstraint;
import org.coode.oppl.NAFConstraint;
import org.coode.oppl.RegExpConstraint;
import org.coode.oppl.Variable;
import org.coode.oppl.utils.VariableExtractor;
import org.semanticweb.owlapi.model.OWLObject;

/** @author Luigi Iannone */
public class QueryItemVariableExtractor implements
        QueryPlannerVisitorEx<java.util.Set<Variable<?>>> {
    @Override
    public Set<Variable<?>> visitConstraintQueryPlannerItem(
            ConstraintQueryPlannerItem constraintQueryPlannerItem) {
        Set<Variable<?>> toReturn = new HashSet<Variable<?>>();
        final VariableExtractor variableExtractor = new VariableExtractor(
                constraintQueryPlannerItem.getConstraintSystem(), false);
        toReturn.addAll(constraintQueryPlannerItem.getConstraint().accept(
                new ConstraintVisitorEx<Set<Variable<?>>>() {
                    @Override
                    public Set<Variable<?>> visit(InequalityConstraint c) {
                        Set<Variable<?>> toReturn = new HashSet<Variable<?>>();
                        toReturn.add(c.getVariable());
                        toReturn.addAll(variableExtractor.extractVariables(c
                                .getExpression()));
                        return toReturn;
                    }

                    @Override
                    public Set<Variable<?>> visit(
                            InCollectionConstraint<? extends OWLObject> c) {
                        Set<Variable<?>> toReturn = new HashSet<Variable<?>>();
                        toReturn.add(c.getVariable());
                        for (OWLObject object : c.getCollection()) {
                            toReturn.addAll(variableExtractor.extractVariables(object));
                        }
                        return toReturn;
                    }

                    @Override
                    public Set<Variable<?>> visit(RegExpConstraint c) {
                        Set<Variable<?>> toReturn = new HashSet<Variable<?>>();
                        toReturn.add(c.getVariable());
                        toReturn.addAll(variableExtractor.extractVariables(c
                                .getExpression()));
                        return toReturn;
                    }

                    @Override
                    public Set<Variable<?>> visit(NAFConstraint nafConstraint) {
                        return variableExtractor.extractVariables(nafConstraint
                                .getAxiom());
                    }
                }));
        return toReturn;
    }

    @Override
    public Set<Variable<?>> visitAssertedAxiomPlannerItem(
            AssertedAxiomPlannerItem assertedAxiomPlannerItem) {
        VariableExtractor variableExtractor = new VariableExtractor(
                assertedAxiomPlannerItem.getConstraintSystem(), false);
        return variableExtractor.extractVariables(assertedAxiomPlannerItem.getAxiom());
    }

    @Override
    public Set<Variable<?>> visitInferredAxiomQueryPlannerItem(
            InferredAxiomQueryPlannerItem inferredAxiomQueryPlannerItem) {
        VariableExtractor variableExtractor = new VariableExtractor(
                inferredAxiomQueryPlannerItem.getConstraintSystem(), false);
        return variableExtractor.extractVariables(inferredAxiomQueryPlannerItem
                .getAxiom());
    }
}
