package org.coode.oppl.generated;

import java.util.regex.Pattern;

import org.coode.oppl.Variable;
import org.coode.oppl.function.OPPLFunction;
import org.coode.oppl.variabletypes.OBJECTPROPERTYVariableImpl;
import org.semanticweb.owlapi.model.OWLObjectProperty;

public class OBJECTPROPERTYRegexpGeneratedVariable extends
		RegexpGeneratedVariable<OWLObjectProperty> {
	/**
	 * @param name
	 * @param patternGeneratingOPPLFunction
	 */
	public OBJECTPROPERTYRegexpGeneratedVariable(String name,
			OPPLFunction<Pattern> patternGeneratingOPPLFunction) {
		super(name, patternGeneratingOPPLFunction);
	}

	@Override
	protected Variable initDelegate(String name) {
		return new OBJECTPROPERTYVariableImpl(name);
	}
}
