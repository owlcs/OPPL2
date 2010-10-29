package org.coode.oppl.function;

import org.coode.oppl.generated.Attribute;
import org.coode.oppl.generated.RegExpGenerated;
import org.coode.oppl.generated.VariableIndexGeneratedValue;
import org.semanticweb.owlapi.model.OWLObject;

public class GroupVariableAttribute<O extends OWLObject> extends
		VariableAttribute<String> {
	private final int index;
	private final VariableIndexGeneratedValue<O> variableIndexGeneratedVariable;

	/**
	 * @param variable
	 * @param attribute
	 */
	public GroupVariableAttribute(RegExpGenerated<O> variable, int index) {
		super(variable, Attribute.GROUP);
		if (index < 0) {
			throw new IllegalArgumentException(String.format(
					"Invalid index %d", index));
		}
		this.index = index;
		this.variableIndexGeneratedVariable = variable
				.getVariableIndexGeneratedVariable(index);
	}

	/**
	 * @return the index
	 */
	public int getIndex() {
		return this.index;
	}

	public void accept(OPPLFunctionVisitor visitor) {
		visitor.visitGroupVariableAttribute(this);
	}

	public <P> P accept(OPPLFunctionVisitorEx<P> visitor) {
		return visitor.visitGroupVariableAttribute(this);
	}

	@Override
	public ValueComputation<String> getValueComputation(
			final ValueComputationParameters parameters) {
		return new ValueComputation<String>() {
			public String compute(OPPLFunction<? extends String> opplFunction) {
				return GroupVariableAttribute.this.variableIndexGeneratedVariable
						.getGeneratedValue(parameters.getBindingNode());
			}
		};
	}
}
