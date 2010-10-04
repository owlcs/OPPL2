/**
 * 
 */
package org.coode.parsers.oppl.testcase.assertions;

import java.util.Comparator;
import java.util.Formatter;
import java.util.Set;
import java.util.TreeSet;

import org.coode.oppl.ConstraintSystem;
import org.coode.oppl.bindingtree.Assignment;
import org.coode.oppl.bindingtree.BindingNode;
import org.coode.oppl.rendering.ManchesterSyntaxRenderer;
import org.coode.parsers.oppl.testcase.AbstractOPPLTestCaseFactory;

/**
 * Represents the count of the occurrences a particular set of assignments in
 * the results of the query.
 * 
 * @author Luigi Iannone
 * 
 */
public class BindingNodeCountAssertionExpression implements
		AssertionExpression<Integer> {
	private final BindingNode bindingNode;
	private final AbstractOPPLTestCaseFactory testCaseFactory;
	private final ConstraintSystem constraintSystem;

	/**
	 * @param bindingNode
	 */
	public BindingNodeCountAssertionExpression(BindingNode bindingNode,
			ConstraintSystem constraintSystem,
			AbstractOPPLTestCaseFactory testCaseFactory) {
		if (bindingNode == null) {
			throw new NullPointerException("The binding node cannot be null");
		}
		if (constraintSystem == null) {
			throw new NullPointerException(
					"The constraint system cannot be null");
		}
		if (testCaseFactory == null) {
			throw new NullPointerException(
					"The test case factory cannot be null");
		}
		this.bindingNode = bindingNode;
		this.testCaseFactory = testCaseFactory;
		this.constraintSystem = constraintSystem;
	}

	/**
	 * @see org.coode.parsers.oppl.testcase.assertions.AssertionExpression#accept(org.coode.parsers.oppl.testcase.assertions.AssertionExpressionVisitor)
	 */
	public void accept(AssertionExpressionVisitor assertionExpressionVisitor) {
		assertionExpressionVisitor
				.visitBindingNodeCountAssertionExpression(this);
	}

	/**
	 * @see org.coode.parsers.oppl.testcase.assertions.AssertionExpression#accept(org.coode.parsers.oppl.testcase.assertions.AssertionExpressionVisitorEx)
	 */
	public <O> O accept(
			AssertionExpressionVisitorEx<O> assertionExpressionVisitor) {
		return assertionExpressionVisitor
				.visitBindingNodeCountAssertionExpression(this);
	}

	/**
	 * @see org.coode.parsers.oppl.testcase.assertions.AssertionExpression#resolve(java.util.Set,
	 *      org.coode.oppl.ConstraintSystem)
	 */
	public Integer resolve(Set<? extends BindingNode> bindings,
			ConstraintSystem constraintSystem) {
		int count = 0;
		for (BindingNode bindingNode : bindings) {
			if (bindingNode.getAssignments().containsAll(
					this.getBindingNode().getAssignments())) {
				count++;
			}
		}
		return count;
	}

	/**
	 * @return the bindingNode
	 */
	public BindingNode getBindingNode() {
		return this.bindingNode;
	}

	/**
	 * @return the testCaseFactory
	 */
	public AbstractOPPLTestCaseFactory getTestCaseFactory() {
		return this.testCaseFactory;
	}

	@Override
	public String toString() {
		Formatter formatter = new Formatter();
		formatter.format("count(");
		boolean first = true;
		TreeSet<Assignment> sortedAssignment = new TreeSet<Assignment>(
				new Comparator<Assignment>() {
					public int compare(Assignment o1, Assignment o2) {
						return o1.getAssignedVariable().getName().compareTo(
								o2.getAssignedVariable().getName());
					}
				});
		sortedAssignment.addAll(this.getBindingNode().getAssignments());
		for (Assignment a : sortedAssignment) {
			String comma = first ? "" : ", ";
			ManchesterSyntaxRenderer renderer = this.getTestCaseFactory()
					.getOPPLFactory().getManchesterSyntaxRenderer(
							this.getConstraintSystem());
			a.getAssignment().accept(renderer);
			formatter.format("%s%s = %s", comma, a.getAssignedVariable()
					.getName(), renderer.toString());
			first = false;
		}
		formatter.format(")");
		return formatter.toString();
	}

	/**
	 * @return the constraintSystem
	 */
	public ConstraintSystem getConstraintSystem() {
		return this.constraintSystem;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ (this.bindingNode == null ? 0 : this.bindingNode.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
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
		BindingNodeCountAssertionExpression other = (BindingNodeCountAssertionExpression) obj;
		if (this.bindingNode == null) {
			if (other.bindingNode != null) {
				return false;
			}
		} else if (!this.bindingNode.equals(other.bindingNode)) {
			return false;
		}
		return true;
	}
}
