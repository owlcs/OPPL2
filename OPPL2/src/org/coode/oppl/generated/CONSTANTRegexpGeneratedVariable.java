package org.coode.oppl.generated;

import java.util.regex.Pattern;

import org.coode.oppl.Variable;
import org.coode.oppl.function.OPPLFunction;
import org.coode.oppl.variabletypes.INDIVIDUALVariableImpl;
import org.semanticweb.owlapi.model.OWLLiteral;

public class CONSTANTRegexpGeneratedVariable extends
		RegexpGeneratedVariable<OWLLiteral> {
	/**
	 * @param name
	 * @param patternGeneratingOPPLFunction
	 */
	public CONSTANTRegexpGeneratedVariable(String name,
			OPPLFunction<Pattern> patternGeneratingOPPLFunction) {
		super(name, patternGeneratingOPPLFunction);
	}

	@Override
	protected Variable initDelegate(String name) {
		return new INDIVIDUALVariableImpl(name);
	}
}
