package org.coode.parsers.oppl.testcase.assertions;

import static org.coode.oppl.utils.ArgCheck.checkNotNull;

import java.util.HashSet;
import java.util.Set;

import org.coode.oppl.ConstraintSystem;
import org.coode.oppl.Variable;
import org.coode.oppl.bindingtree.BindingNode;
import org.coode.oppl.exceptions.RuntimeExceptionHandler;
import org.coode.oppl.function.SimpleValueComputationParameters;
import org.coode.oppl.function.ValueComputationParameters;
import org.semanticweb.owlapi.model.OWLObject;

/** @author Luigi Iannone */
public class CountAssertionExpression implements AssertionExpression<Integer> {
    private final Variable<?> variable;
    private final RuntimeExceptionHandler handler;

    /** @param variable
     * @param handler */
    public CountAssertionExpression(Variable<?> variable, RuntimeExceptionHandler handler) {
        this.variable = checkNotNull(variable, "variable");
        this.handler = checkNotNull(handler, "handler");
    }

    /** @return the variable */
    public Variable<?> getVariable() {
        return variable;
    }

    @Override
    public void accept(AssertionExpressionVisitor assertionExpressionVisitor) {
        assertionExpressionVisitor.visitCountAssertionExpression(this);
    }

    @Override
    public <O> O accept(AssertionExpressionVisitorEx<O> assertionExpressionVisitor) {
        return assertionExpressionVisitor.visitCountAssertionExpression(this);
    }

    @Override
    public String toString() {
        return String.format("count(%s)", getVariable().getName());
    }

    @Override
    public Integer resolve(Set<? extends BindingNode> bindings,
            ConstraintSystem constraintSystem) {
        Set<OWLObject> values = new HashSet<OWLObject>(bindings.size());
        for (BindingNode bindingNode : bindings) {
            ValueComputationParameters parameters = new SimpleValueComputationParameters(
                    constraintSystem, bindingNode, getHandler());
            OWLObject value = bindingNode.getAssignmentValue(getVariable(), parameters);
            if (value != null) {
                values.add(value);
            }
        }
        return values.size();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (variable == null ? 0 : variable.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (this.getClass() != obj.getClass()) {
            return false;
        }
        CountAssertionExpression other = (CountAssertionExpression) obj;
        if (variable == null) {
            if (other.variable != null) {
                return false;
            }
        } else if (!variable.equals(other.variable)) {
            return false;
        }
        return true;
    }

    /** @return the handler */
    public RuntimeExceptionHandler getHandler() {
        return handler;
    }
}
