package org.coode.oppl.function;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.coode.oppl.ConstraintSystem;
import org.coode.oppl.Variable;
import org.coode.oppl.bindingtree.BindingNode;
import org.semanticweb.owlapi.model.OWLObject;

/**
 * @author Luigi Iannone
 * @param <O> type
 */
public class ValuesVariableAtttribute<O extends OWLObject>
    extends VariableAttribute<Collection<O>> {

    /**
     * @param variable variable
     */
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
    public ValueComputation<Collection<O>> getValueComputation(
        final ValueComputationParameters parameters) {
        return new ValueComputation<Collection<O>>() {

            @SuppressWarnings("unchecked")
            @Override
            public Collection<O> compute(OPPLFunction<? extends Collection<O>> opplFunction) {
                ConstraintSystem constraintSystem = parameters.getConstraintSystem();
                Set<BindingNode> leaves = constraintSystem.getLeaves();
                Set<O> toReturn = null;
                if (leaves != null) {
                    toReturn = new HashSet<>(leaves.size());
                    for (BindingNode bindingNode : leaves) {
                        OWLObject assignmentValue = bindingNode.getAssignmentValue(
                            ValuesVariableAtttribute.this.getVariable(),
                            new SimpleValueComputationParameters(parameters.getConstraintSystem(),
                                bindingNode, parameters.getRuntimeExceptionHandler()));
                        if (assignmentValue != null) {
                            toReturn.add((O) assignmentValue);
                        }
                    }
                }
                return toReturn;
            }
        };
    }

    /**
     * @param v v
     * @param <P> atribute type
     * @return new value variable attribute
     */
    public static <P extends OWLObject> ValuesVariableAtttribute<P> getValuesVariableAtttribute(
        Variable<P> v) {
        return new ValuesVariableAtttribute<>(v);
    }
}
