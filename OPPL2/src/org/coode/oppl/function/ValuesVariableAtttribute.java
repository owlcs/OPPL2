package org.coode.oppl.function;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.coode.oppl.ConstraintSystem;
import org.coode.oppl.Variable;
import org.coode.oppl.bindingtree.BindingNode;
import org.semanticweb.owlapi.model.OWLObject;

public class ValuesVariableAtttribute<O extends OWLObject> extends
        VariableAttribute<Collection<? extends O>> {
    /** @param variable
     * @param attribute */
    public ValuesVariableAtttribute(Variable<O> variable) {
        super(variable, AttributeName.VALUES);
    }

    @Override
    public <P> P accept(OPPLFunctionVisitorEx<P> visitor) {
        return visitor.visitValuesVariableAtttribute(this);
    }

    @Override
    public void accept(OPPLFunctionVisitor visitor) {
        visitor.visitValuesVariableAtttribute(this);
    }

    @Override
    public ValueComputation<Collection<? extends O>> getValueComputation(
            final ValueComputationParameters parameters) {
        ValueComputation<Collection<? extends O>> valueComputation = new ValueComputation<Collection<? extends O>>() {
            @Override
            public Collection<? extends O> compute(
                    OPPLFunction<? extends Collection<? extends O>> opplFunction) {
                ConstraintSystem constraintSystem = parameters.getConstraintSystem();
                Set<BindingNode> leaves = constraintSystem.getLeaves();
                Set<O> toReturn = null;
                if (leaves != null) {
                    toReturn = new HashSet<O>(leaves.size());
                    BindingNode mainBindingNode = parameters.getBindingNode();
                    for (BindingNode bindingNode : leaves) {
                        OWLObject assignmentValue = bindingNode.getAssignmentValue(
                                ValuesVariableAtttribute.this.getVariable(),
                                new SimpleValueComputationParameters(parameters
                                        .getConstraintSystem(), bindingNode, parameters
                                        .getRuntimeExceptionHandler()));
                        if (assignmentValue != null) {
                            toReturn.add((O) assignmentValue);
                        }
                    }
                }
                return toReturn;
            }
        };
        return valueComputation;
    }

    public static <P extends OWLObject> ValuesVariableAtttribute<P>
            getValuesVariableAtttribute(Variable<P> v) {
        return new ValuesVariableAtttribute<P>(v);
    }
}
