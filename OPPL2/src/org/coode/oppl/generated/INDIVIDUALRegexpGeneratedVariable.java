package org.coode.oppl.generated;

import java.util.regex.Pattern;

import org.coode.oppl.Variable;
import org.coode.oppl.variabletypes.INDIVIDUALVariableImpl;
import org.semanticweb.owlapi.model.OWLNamedIndividual;

public class INDIVIDUALRegexpGeneratedVariable extends RegexpGeneratedVariable<OWLNamedIndividual> {
	/**
	 * @param name
	 * @param type
	 * @param pattern
	 */
	public INDIVIDUALRegexpGeneratedVariable(String name, Pattern pattern) {
		super(name, pattern);
	}

	@Override
	protected Variable initDelegate(String name) {
		return new INDIVIDUALVariableImpl(name);
	}
}
