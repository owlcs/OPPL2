package org.coode.oppl.generated;

import java.util.regex.Pattern;

import org.coode.oppl.Variable;
import org.coode.oppl.VariableType;
import org.coode.oppl.variabletypes.CLASSVariableImpl;
import org.semanticweb.owlapi.model.OWLClass;

public class CLASSRegexpGeneratedVariable extends
		RegexpGeneratedVariable<OWLClass> {
	/**
	 * @param name
	 * @param type
	 * @param pattern
	 */
	public CLASSRegexpGeneratedVariable(String name, Pattern pattern) {
		super(name, VariableType.CLASS, pattern);
	}

	@Override
	protected Variable initDelegate() {
		return new CLASSVariableImpl(this.getName());
	}
}
