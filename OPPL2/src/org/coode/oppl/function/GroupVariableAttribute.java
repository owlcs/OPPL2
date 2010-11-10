package org.coode.oppl.function;

import java.util.regex.Matcher;

import org.coode.oppl.ConstraintSystem;
import org.coode.oppl.generated.RegexpGeneratedVariable;
import org.coode.oppl.rendering.ManchesterSyntaxRenderer;
import org.semanticweb.owlapi.model.OWLObject;

public class GroupVariableAttribute<O extends OWLObject> extends VariableAttribute<String> {
	private final int index;
	private final RegexpGeneratedVariable<O> regexpGeneratedVariable;

	/**
	 * @param variable
	 * @param attribute
	 */
	public GroupVariableAttribute(RegexpGeneratedVariable<O> variable, int index) {
		super(variable, AttributeName.GROUP);
		if (index < 0) {
			throw new IllegalArgumentException(String.format("Invalid index %d", index));
		}
		this.index = index;
		this.regexpGeneratedVariable = variable;
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
	public ValueComputation<String> getValueComputation(final ValueComputationParameters parameters) {
		return new ValueComputation<String>() {
			public String compute(OPPLFunction<? extends String> opplFunction) {
				String toReturn = null;
				OWLObject assignmentValue = parameters.getBindingNode().getAssignmentValue(
						GroupVariableAttribute.this.getVariable(),
						parameters);
				if (assignmentValue != null) {
					ManchesterSyntaxRenderer renderer = parameters.getConstraintSystem().getOPPLFactory().getManchesterSyntaxRenderer(
							parameters.getConstraintSystem());
					assignmentValue.accept(renderer);
					Matcher matcher = GroupVariableAttribute.this.getRegexpGeneratedVariable().getPatternGeneratingOPPLFunction().compute(
							parameters).matcher(renderer.toString());
					if (matcher.matches()
							&& matcher.groupCount() >= GroupVariableAttribute.this.index) {
						toReturn = matcher.group(GroupVariableAttribute.this.index);
					}
				}
				return toReturn;
			}
		};
	}

	@Override
	public String toString() {
		return String.format(
				"%s.%s(%d)",
				this.getVariable().getName(),
				this.getAttribute(),
				this.getIndex());
	}

	@Override
	public String render(ConstraintSystem constraintSystem) {
		return this.toString();
	}

	/**
	 * @return the regexpGeneratedVariable
	 */
	public RegexpGeneratedVariable<O> getRegexpGeneratedVariable() {
		return this.regexpGeneratedVariable;
	}

	public static <P extends OWLObject> GroupVariableAttribute<P> getGroupVariableAttribute(
			RegexpGeneratedVariable<P> variable, int index) {
		return new GroupVariableAttribute<P>(variable, index);
	}
}
