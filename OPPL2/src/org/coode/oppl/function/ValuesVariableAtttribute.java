package org.coode.oppl.function;

import java.util.Collection;

import org.coode.oppl.Variable;
import org.coode.oppl.generated.Attribute;
import org.semanticweb.owlapi.model.OWLObject;

public class ValuesVariableAtttribute<O extends OWLObject> extends VariableAttribute<Collection<O>> {
	/**
	 * @param variable
	 * @param attribute
	 */
	public ValuesVariableAtttribute(Variable variable) {
		super(variable, Attribute.VALUES);
	}

	public <P> P accept(OPPLFunctionVisitorEx<P> visitor) {
		return visitor.visitValuesVariableAtttribute(this);
	}

	public void accept(OPPLFunctionVisitor visitor) {
		visitor.visitValuesVariableAtttribute(this);
	}
}
