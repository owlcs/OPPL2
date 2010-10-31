package org.coode.oppl.generated;

import java.util.regex.Pattern;

import org.coode.oppl.Variable;
import org.coode.oppl.VariableType;
import org.coode.oppl.variabletypes.OBJECTPROPERTYVariableImpl;
import org.semanticweb.owlapi.model.OWLObjectProperty;

public class OBJECTPROPERTYRegexpGeneratedVariable extends
		RegexpGeneratedVariable<OWLObjectProperty> {
	/**
	 * @param name
	 * @param type
	 * @param pattern
	 */
	public OBJECTPROPERTYRegexpGeneratedVariable(String name,
			VariableType type, Pattern pattern) {
		super(name, VariableType.OBJECTPROPERTY, pattern);
	}

	@Override
	protected Variable initDelegate() {
		return new OBJECTPROPERTYVariableImpl(this.getName());
	}
}
