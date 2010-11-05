package org.coode.oppl.generated;

import java.util.regex.Pattern;

import org.coode.oppl.Variable;
import org.coode.oppl.function.OPPLFunction;
import org.coode.oppl.variabletypes.CLASSVariableImpl;
import org.semanticweb.owlapi.model.OWLClass;

public class CLASSRegexpGeneratedVariable extends
		RegexpGeneratedVariable<OWLClass> {
	/**
	 * @param name
	 * @param patternGeneratingOPPLFunction
	 */
	public CLASSRegexpGeneratedVariable(String name,
			OPPLFunction<Pattern> patternGeneratingOPPLFunction) {
		super(name, patternGeneratingOPPLFunction);
	}

	@Override
	protected Variable initDelegate(String name) {
		return new CLASSVariableImpl(name);
	}
}
