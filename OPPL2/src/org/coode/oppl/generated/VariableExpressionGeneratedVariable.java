/**
 *
 */
package org.coode.oppl.generated;

import org.coode.oppl.ConstraintSystem;
import org.coode.oppl.VariableType;
import org.coode.oppl.VariableTypeVisitorEx;
import org.coode.oppl.rendering.ManchesterSyntaxRenderer;
import org.coode.oppl.utils.ArgCheck;
import org.semanticweb.owlapi.model.OWLObject;

/**
 * @author Luigi Iannone
 * 
 */
public class VariableExpressionGeneratedVariable extends AbstractGeneratedVariable<OWLObject> {
	private final ConstraintSystem constraintSystem;
	private final OWLObject owlObject;

	/**
	 * Builds an instance of VariableExpressionGeneratedVariable from a name and
	 * an OWLObject.
	 * 
	 * @param name
	 *            the name for this variable. cannot be {@code null}.
	 * @param owlObject
	 *            the OWL object on which this variable will be based. Cannot be
	 *            {@code null}. It can depend on other variables.
	 * @param constraintSystem
	 *            the Constraint system containing all the variables necessary
	 *            to express this one. Cannot be {@code null}.
	 * @throws NullPointerException
	 *             when any of the inputs is {@code null}.
	 */
	public VariableExpressionGeneratedVariable(String name, OWLObject owlObject,
			ConstraintSystem constraintSystem) {
		super(name, VariableType.getVariableType(owlObject), new VariableExpressionGeneratedValue(
				owlObject, constraintSystem));
		ArgCheck.checkNullArgument("The constraint system", constraintSystem);
		ArgCheck.checkNullArgument("The OWL Object", owlObject);
		this.owlObject = owlObject;
		this.constraintSystem = constraintSystem;
	}

	@Override
	protected OWLObject generateObject(OWLObject generatedValue) {
		return generatedValue;
	}

	public String getOPPLFunction() {
		ManchesterSyntaxRenderer manchesterSyntaxRenderer = this.getConstraintSystem().getOPPLFactory().getManchesterSyntaxRenderer(
				this.getConstraintSystem());
		this.owlObject.accept(manchesterSyntaxRenderer);
		return manchesterSyntaxRenderer.toString();
	}

	public String getArgumentString() {
		return this.getOPPLFunction();
	}

	@Override
	protected SingleValueGeneratedVariable<OWLObject> replace(
			SingleValueGeneratedValue<OWLObject> unusedValue) {
		return this;
	}

	public <P> P accept(VariableTypeVisitorEx<P> visitor) {
		return visitor.visit(this);
	}

	/**
	 * @return the constraintSystem
	 */
	public ConstraintSystem getConstraintSystem() {
		return this.constraintSystem;
	}
}
