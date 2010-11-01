package org.coode.oppl.function;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.coode.oppl.ConstraintSystem;
import org.coode.oppl.Variable;
import org.coode.oppl.bindingtree.BindingNode;
import org.coode.parsers.oppl.variableattribute.AttributeNames;
import org.semanticweb.owlapi.model.OWLObject;

public class ValuesVariableAtttribute<O extends OWLObject> extends VariableAttribute<Collection<O>> {
	/**
	 * @param variable
	 * @param attribute
	 */
	public ValuesVariableAtttribute(Variable variable) {
		super(variable, AttributeNames.VALUES);
	}

	public <P> P accept(OPPLFunctionVisitorEx<P> visitor) {
		return visitor.visitValuesVariableAtttribute(this);
	}

	public void accept(OPPLFunctionVisitor visitor) {
		visitor.visitValuesVariableAtttribute(this);
	}

	@Override
	public ValueComputation<Collection<O>> getValueComputation(
			final ValueComputationParameters parameters) {
		ValueComputation<Collection<O>> valueComputation = new ValueComputation<Collection<O>>() {
			public Collection<O> compute(OPPLFunction<? extends Collection<O>> opplFunction) {
				ConstraintSystem constraintSystem = parameters.getConstraintSystem();
				Set<BindingNode> leaves = constraintSystem.getLeaves();
				Set<O> toReturn = null;
				if (leaves != null) {
					toReturn = new HashSet<O>(leaves.size());
					for (BindingNode bindingNode : leaves) {
						OWLObject assignmentValue = bindingNode.getAssignmentValue(
								ValuesVariableAtttribute.this.getVariable(),
								parameters);
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
}
