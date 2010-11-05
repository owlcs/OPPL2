package org.coode.oppl.generated;

import java.util.regex.Pattern;

import org.coode.oppl.Variable;
import org.coode.oppl.function.OPPLFunction;
import org.coode.oppl.variabletypes.INDIVIDUALVariableImpl;
import org.semanticweb.owlapi.model.OWLNamedIndividual;

public class INDIVIDUALRegexpGeneratedVariable extends
		RegexpGeneratedVariable<OWLNamedIndividual> {
	/**
	 * @param name
	 * @param patternGeneratingOPPLFunction
	 */
	public INDIVIDUALRegexpGeneratedVariable(String name,
			OPPLFunction<Pattern> patternGeneratingOPPLFunction) {
		super(name, patternGeneratingOPPLFunction);
	}

	@Override
	protected Variable initDelegate(String name) {
		return new INDIVIDUALVariableImpl(name);
	}
}
