/**
 * 
 */
package org.coode.parsers.oppl.testcase.assertions;

import java.util.HashSet;
import java.util.Set;

import org.coode.oppl.ConstraintSystem;
import org.coode.oppl.PartialOWLObjectInstantiator;
import org.coode.oppl.bindingtree.BindingNode;
import org.coode.oppl.exceptions.RuntimeExceptionHandler;
import org.coode.oppl.function.SimpleValueComputationParameters;
import org.coode.oppl.function.ValueComputationParameters;
import org.coode.oppl.rendering.ManchesterSyntaxRenderer;
import org.coode.parsers.oppl.testcase.AbstractOPPLTestCaseFactory;
import org.semanticweb.owlapi.model.OWLObject;

/**
 * Represents an OWL Object in an assertion.
 * 
 * @author Luigi Iannone
 * 
 */
public class OWLExpressionAssertionExpression implements AssertionExpression<Set<OWLObject>> {
	private final OWLObject owlObject;
	private final AbstractOPPLTestCaseFactory testCaseFactory;
	private final ConstraintSystem constraintSystem;
	private final RuntimeExceptionHandler handler;

	/**
	 * @param owlObject
	 * @param testCaseFactory
	 */
	public OWLExpressionAssertionExpression(OWLObject owlObject, ConstraintSystem constraintSystem,
			AbstractOPPLTestCaseFactory testCaseFactory, RuntimeExceptionHandler handler) {
		if (owlObject == null) {
			throw new NullPointerException("The OWL object cannot be null");
		}
		if (testCaseFactory == null) {
			throw new NullPointerException("The test case factory cannot be null");
		}
		if (constraintSystem == null) {
			throw new NullPointerException("The constraint system cannot be null");
		}
		if (handler == null) {
			throw new NullPointerException("The runtime exception handler cannot be null");
		}
		this.owlObject = owlObject;
		this.testCaseFactory = testCaseFactory;
		this.constraintSystem = constraintSystem;
		this.handler = handler;
	}

	public void accept(AssertionExpressionVisitor assertionExpressionVisitor) {
		assertionExpressionVisitor.visitOWLExpressionAssertionExpression(this);
	}

	public <O> O accept(AssertionExpressionVisitorEx<O> assertionExpressionVisitor) {
		return assertionExpressionVisitor.visitOWLExpressionAssertionExpression(this);
	}

	/**
	 * @return the owlObject
	 */
	public OWLObject getOWLObject() {
		return this.owlObject;
	}

	/**
	 * @return the testCaseFactory
	 */
	public AbstractOPPLTestCaseFactory getTestCaseFactory() {
		return this.testCaseFactory;
	}

	@Override
	public String toString() {
		ManchesterSyntaxRenderer renderer = this.getTestCaseFactory().getOPPLFactory().getManchesterSyntaxRenderer(
				this.getConstraintSystem());
		this.owlObject.accept(renderer);
		return renderer.toString();
	}

	/**
	 * @return the constraintSystem
	 */
	public ConstraintSystem getConstraintSystem() {
		return this.constraintSystem;
	}

	public Set<OWLObject> resolve(Set<? extends BindingNode> bindings,
			ConstraintSystem constraintSystem) {
		Set<OWLObject> toReturn = new HashSet<OWLObject>();
		for (BindingNode bindingNode : bindings) {
			ValueComputationParameters parameters = new SimpleValueComputationParameters(
					this.getConstraintSystem(), bindingNode, this.handler);
			PartialOWLObjectInstantiator instantiator = new PartialOWLObjectInstantiator(parameters);
			toReturn.add(this.owlObject.accept(instantiator));
		}
		return toReturn;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (this.owlObject == null ? 0 : this.owlObject.hashCode());
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
		OWLExpressionAssertionExpression other = (OWLExpressionAssertionExpression) obj;
		if (this.owlObject == null) {
			if (other.owlObject != null) {
				return false;
			}
		} else if (!this.owlObject.equals(other.owlObject)) {
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
