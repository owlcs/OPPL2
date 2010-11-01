package org.coode.oppl.generated;

import java.util.regex.Pattern;

import org.coode.oppl.Variable;
import org.coode.oppl.variabletypes.OBJECTPROPERTYVariableImpl;
import org.semanticweb.owlapi.model.OWLObjectProperty;

public class OBJECTPROPERTYRegexpGeneratedVariable extends
		RegexpGeneratedVariable<OWLObjectProperty> {
	/**
	 * @param name
	 * @param type
	 * @param pattern
	 */
	public OBJECTPROPERTYRegexpGeneratedVariable(String name, Pattern pattern) {
		super(name, pattern);
	}

	@Override
	protected Variable initDelegate(String name) {
		return new OBJECTPROPERTYVariableImpl(name);
	}
}
