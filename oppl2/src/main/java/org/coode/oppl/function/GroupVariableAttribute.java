package org.coode.oppl.function;

import java.util.regex.Matcher;

import org.coode.oppl.ConstraintSystem;
import org.coode.oppl.Variable;
import org.coode.oppl.exceptions.RuntimeExceptionHandler;
import org.coode.oppl.generated.RegexpGeneratedVariable;
import org.coode.oppl.rendering.ManchesterSyntaxRenderer;
import org.semanticweb.owlapi.model.OWLObject;
import org.semanticweb.owlapi.util.ShortFormProvider;

/** @author Luigi Iannone
 * @param <O>
 *            type */
public class GroupVariableAttribute<O extends OWLObject> extends
        VariableAttribute<String> {
    protected final int index;
    private final RegexpGeneratedVariable<O> regexpGeneratedVariable;

    /** @param variable
     *            variable
     * @param index
     *            index */
    public GroupVariableAttribute(RegexpGeneratedVariable<O> variable, int index) {
        super(variable, AttributeName.GROUPS);
        if (index < 0) {
            throw new IllegalArgumentException(String.format("Invalid index %d", index));
        }
        this.index = index;
        this.regexpGeneratedVariable = variable;
    }

    /** @return the index */
    public int getIndex() {
        return this.index;
    }

    @Override
    public void accept(OPPLFunctionVisitor visitor) {
        visitor.visitGroupVariableAttribute(this);
    }

    @Override
    public <P> P accept(OPPLFunctionVisitorEx<P> visitor) {
        return visitor.visitGroupVariableAttribute(this);
    }

    @Override
    public ValueComputation<String> getValueComputation(
            final ValueComputationParameters parameters) {
        return new ValueComputation<String>() {
            @Override
            public String compute(OPPLFunction<? extends String> opplFunction) {
                String toReturn = null;
                OWLObject assignmentValue = parameters.getBindingNode()
                        .getAssignmentValue(GroupVariableAttribute.this.getVariable(),
                                parameters);
                if (assignmentValue != null) {
                    ManchesterSyntaxRenderer renderer = parameters
                            .getConstraintSystem()
                            .getOPPLFactory()
                            .getManchesterSyntaxRenderer(parameters.getConstraintSystem());
                    assignmentValue.accept(renderer);
                    Matcher matcher = GroupVariableAttribute.this
                            .getRegexpGeneratedVariable()
                            .getPatternGeneratingOPPLFunction().compute(parameters)
                            .matcher(renderer.toString());
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
        return String.format("%s.%s(%d)", getVariable().getName(), getAttribute(),
                this.getIndex());
    }

    @Override
    public String render(ConstraintSystem constraintSystem) {
        return this.toString();
    }

    @Override
    public String render(ShortFormProvider shortFormProvider) {
        return this.toString();
    }

    /** @return the regexpGeneratedVariable */
    public RegexpGeneratedVariable<O> getRegexpGeneratedVariable() {
        return this.regexpGeneratedVariable;
    }

    /** @param variable
     *            variable
     * @param index
     *            index
     * @param <P>
     *            group attribute type
     * @return group variable attribute */
    public static <P extends OWLObject> GroupVariableAttribute<P>
            getGroupVariableAttribute(RegexpGeneratedVariable<P> variable, int index) {
        return new GroupVariableAttribute<P>(variable, index);
    }

    /** @param v
     *            v
     * @param owlObject
     *            owlObject
     * @param constraintSystem
     *            constraintSystem
     * @param handler
     *            handler
     * @return oppl function */
    @SuppressWarnings("unused")
    public OPPLFunction<String> replace(Variable<?> v, OWLObject owlObject,
            ConstraintSystem constraintSystem, RuntimeExceptionHandler handler) {
        return this;
    }
}
