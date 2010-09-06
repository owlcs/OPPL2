/**
 * 
 */
package org.coode.parsers.oppl.testcase.assertions;

import java.util.Collection;
import java.util.Formatter;
import java.util.HashSet;
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
	private final ConstraintSystem constraintSystem;
	private final Set<OWLObject> values = new HashSet<OWLObject>();
	private final AbstractOPPLTestCaseFactory testCaseFactory;

	/**
	 * @param variable
	 * @param value
	 */
	public AssertContains(Variable variable,
			Collection<? extends OWLObject> values,
			ConstraintSystem constraintSystem,
			AbstractOPPLTestCaseFactory testCaseFactory) {
		if (variable == null) {
			throw new NullPointerException("The variable cannot be null");
		}
		if (values == null) {
			throw new NullPointerException("The values cannot be null");
		}
		if (values.isEmpty()) {
			throw new IllegalArgumentException("The values cannot be empty");
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
		this.values.addAll(values);
		this.constraintSystem = constraintSystem;
		this.testCaseFactory = testCaseFactory;
	}

	/**
	 * @return the variable
	 */
	public Variable getVariable() {
		return this.variable;
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
		formatter.format("%s CONTAINS ", this.getVariable().getName());
		boolean first = true;
		for (OWLObject v : this.getValues()) {
			String comma = first ? "" : ", ";
			first = false;
			ManchesterSyntaxRenderer renderer = this.getTestCaseFactory()
					.getOPPLFactory().getManchesterSyntaxRenderer(
							this.getConstraintSystem());
			v.accept(renderer);
			formatter.format("%s%s", comma, renderer.toString());
		}
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
		Set<OWLObject> containerValues = new HashSet<OWLObject>(bindings.size());
		for (BindingNode bindingNode : bindings) {
			OWLObject value = bindingNode.getAssignmentValue(this.variable);
			if (value != null) {
				containerValues.add(value);
			}
		}
		return containerValues.containsAll(this.getValues());
	}

	/**
	 * @return the values
	 */
	public Set<OWLObject> getValues() {
		return new HashSet<OWLObject>(this.values);
	}
}
