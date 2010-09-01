/**
 * 
 */
package org.coode.parsers.oppl.testcase.assertions;

import java.util.Formatter;
import java.util.Iterator;
import java.util.Set;

import org.coode.oppl.ConstraintSystem;
import org.coode.oppl.Variable;
import org.coode.oppl.bindingtree.BindingNode;
import org.coode.oppl.rendering.ManchesterSyntaxRenderer;
import org.coode.parsers.oppl.testcase.AbstractOPPLTestCaseFactory;
import org.semanticweb.owlapi.model.OWLObject;

/**
 * Asserts that the bindings of a Variable contain a specified value.
 * 
 * @author Luigi Iannone
 * 
 */
public class AssertContains implements Assertion {
	private final Variable variable;
	private final OWLObject value;
	private final ConstraintSystem constraintSystem;
	private final AbstractOPPLTestCaseFactory testCaseFactory;

	/**
	 * @param variable
	 * @param value
	 */
	public AssertContains(Variable variable, OWLObject value,
			ConstraintSystem constraintSystem,
			AbstractOPPLTestCaseFactory testCaseFactory) {
		if (variable == null) {
			throw new NullPointerException("The variable cannot be null");
		}
		if (value == null) {
			throw new NullPointerException("The value cannot be null");
		}
		if (constraintSystem == null) {
			throw new NullPointerException(
					"The constraint system cannot be null");
		}
		if (testCaseFactory == null) {
			throw new NullPointerException(
					"The test case factory cannot be null");
		}
		this.variable = variable;
		this.value = value;
		this.constraintSystem = constraintSystem;
		this.testCaseFactory = testCaseFactory;
	}

	/**
	 * @return the variable
	 */
	public Variable getVariable() {
		return this.variable;
	}

	/**
	 * @return the value
	 */
	public OWLObject getValue() {
		return this.value;
	}

	public <O> O accept(AssertionVisitorEx<O> visitor) {
		return visitor.visitAssertContains(this);
	}

	public void accept(AssertionVisitor visitor) {
		visitor.visitAssertContains(this);
	}

	@Override
	public String toString() {
		Formatter formatter = new Formatter();
		ManchesterSyntaxRenderer renderer = this.getTestCaseFactory()
				.getOPPLFactory().getManchesterSyntaxRenderer(
						this.getConstraintSystem());
		this.getValue().accept(renderer);
		formatter.format("%s CONTAINS %s", this.getVariable().getName(),
				renderer.toString());
		return formatter.toString();
	}

	/**
	 * @return the constraintSystem
	 */
	public ConstraintSystem getConstraintSystem() {
		return this.constraintSystem;
	}

	/**
	 * @return the testCaseFactory
	 */
	public AbstractOPPLTestCaseFactory getTestCaseFactory() {
		return this.testCaseFactory;
	}

	public boolean holds(Set<? extends BindingNode> bindings,
			ConstraintSystem constraintSystem) {
		boolean found = false;
		Iterator<? extends BindingNode> iterator = bindings.iterator();
		while (!found && iterator.hasNext()) {
			BindingNode bindingNode = iterator.next();
			found = bindingNode.getAssignmentValue(this.getVariable()).equals(
					this.getValue());
		}
		return found;
	}
}
