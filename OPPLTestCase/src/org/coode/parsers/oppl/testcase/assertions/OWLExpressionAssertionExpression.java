/**
 * 
 */
package org.coode.parsers.oppl.testcase.assertions;

import java.util.Set;

import org.coode.oppl.ConstraintSystem;
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

	/**
	 * @param owlObject
	 * @param testCaseFactory
	 */
	public OWLExpressionAssertionExpression(OWLObject owlObject, ConstraintSystem constraintSystem,
			AbstractOPPLTestCaseFactory testCaseFactory) {
		if (owlObject == null) {
			throw new NullPointerException("The OWL object cannot be null");
		}
		if (testCaseFactory == null) {
			throw new NullPointerException("The test case factory cannot be null");
		}
		if (constraintSystem == null) {
			throw new NullPointerException("The constraint system cannot be null");
		}
		this.owlObject = owlObject;
		this.testCaseFactory = testCaseFactory;
		this.constraintSystem = constraintSystem;
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
}
