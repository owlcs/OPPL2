package org.coode.parsers.oppl.testcase.assertions;

import java.util.Formatter;
import java.util.HashSet;
import java.util.Set;

import org.coode.oppl.ConstraintSystem;
import org.coode.oppl.Variable;
import org.coode.oppl.bindingtree.BindingNode;
import org.coode.oppl.exceptions.RuntimeExceptionHandler;
import org.coode.oppl.function.SimpleValueComputationParameters;
import org.coode.oppl.function.ValueComputationParameters;
import org.semanticweb.owlapi.model.OWLObject;

public class CountAssertionExpression implements AssertionExpression<Integer> {
	private final Variable<?> variable;
	private final RuntimeExceptionHandler handler;

	/**
	 * @param variable
	 */
	public CountAssertionExpression(Variable<?> variable, RuntimeExceptionHandler handler) {
		if (variable == null) {
			throw new NullPointerException("The variable cannot be null");
		}
		if (handler == null) {
			throw new NullPointerException("The run-time exception cannot be null");
		}
		this.variable = variable;
		this.handler = handler;
	}

	/**
	 * @return the variable
	 */
	public Variable<?> getVariable() {
		return this.variable;
	}

	public void accept(AssertionExpressionVisitor assertionExpressionVisitor) {
		assertionExpressionVisitor.visitCountAssertionExpression(this);
	}

	public <O> O accept(AssertionExpressionVisitorEx<O> assertionExpressionVisitor) {
		return assertionExpressionVisitor.visitCountAssertionExpression(this);
	}

	@Override
	public String toString() {
		Formatter formatter = new Formatter();
		formatter.format("count(%s)", this.getVariable().getName());
		return formatter.toString();
	}

	public Integer resolve(Set<? extends BindingNode> bindings, ConstraintSystem constraintSystem) {
		Set<OWLObject> values = new HashSet<OWLObject>(bindings.size());
		for (BindingNode bindingNode : bindings) {
			ValueComputationParameters parameters = new SimpleValueComputationParameters(
					constraintSystem, bindingNode, this.getHandler());
			OWLObject value = bindingNode.getAssignmentValue(this.getVariable(), parameters);
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
		result = prime * result + (this.variable == null ? 0 : this.variable.hashCode());
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
		if (this.variable == null) {
			if (other.variable != null) {
				return false;
			}
		} else if (!this.variable.equals(other.variable)) {
			return false;
		}
		return true;
	}

	/**
	 * @return the handler
	 */
	public RuntimeExceptionHandler getHandler() {
		return this.handler;
	}
}
