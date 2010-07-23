/**
 *
 */
package org.coode.oppl.variablemansyntax.generated;

import org.coode.oppl.rendering.ManchesterSyntaxRenderer;
import org.coode.oppl.utils.ArgCheck;
import org.coode.oppl.utils.ParserFactory;
import org.coode.oppl.variablemansyntax.ConstraintSystem;
import org.coode.oppl.variablemansyntax.VariableType;
import org.coode.oppl.variablemansyntax.VariableTypeVisitorEx;
import org.semanticweb.owl.model.OWLObject;

/**
 * @author Luigi Iannone
 * 
 */
public class VariableExpressionGeneratedVariable extends
		AbstractGeneratedVariable<OWLObject> {
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
	public VariableExpressionGeneratedVariable(String name,
			OWLObject owlObject, ConstraintSystem constraintSystem) {
		super(name, VariableType.getVariableType(owlObject),
				new VariableExpressionGeneratedValue(owlObject,
						constraintSystem));
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
		ManchesterSyntaxRenderer manchesterSyntaxRenderer = ParserFactory
				.getInstance().getOPPLFactory().getManchesterSyntaxRenderer(
						this.constraintSystem);
		this.owlObject.accept(manchesterSyntaxRenderer);
		return manchesterSyntaxRenderer.toString();
	}

	public String getArgumentString() {
		return this.getOPPLFunction();
	}

	@Override
	protected SingleValueGeneratedVariable<OWLObject> replace(
			SingleValueGeneratedValue<OWLObject> unusedValue) {
		// TODO check that the unused parameter is legit
		return this;
	}

	public <P> P accept(VariableTypeVisitorEx<P> visitor) {
		return visitor.visit(this);
	}
}
