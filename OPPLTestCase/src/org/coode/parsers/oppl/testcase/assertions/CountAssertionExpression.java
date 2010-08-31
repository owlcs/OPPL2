package org.coode.parsers.oppl.testcase.assertions;

import java.util.Formatter;
import java.util.Set;

import org.coode.oppl.Variable;
import org.coode.oppl.bindingtree.BindingNode;
import org.semanticweb.owlapi.model.OWLObject;

public class CountAssertionExpression implements AssertionExpression<Integer> {
	private final Variable variable;

	/**
	 * @param variable
	 */
	public CountAssertionExpression(Variable variable) {
		if (variable == null) {
			throw new NullPointerException("The variable cannot be null");
		}
		this.variable = variable;
	}

	/**
	 * @return the variable
	 */
	public Variable getVariable() {
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

	public Integer resolve(Set<? extends BindingNode> bindings) {
		int count = 0;
		for (BindingNode bindingNode : bindings) {
			OWLObject value = bindingNode.getAssignmentValue(this.getVariable());
			if (value != null) {
				count++;
			}
		}
		return count;
	}
}
