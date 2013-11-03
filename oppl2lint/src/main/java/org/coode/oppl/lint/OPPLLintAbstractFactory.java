package org.coode.oppl.lint;

import org.coode.oppl.OPPLAbstractFactory;
import org.coode.oppl.OPPLScript;
import org.coode.oppl.Variable;
import org.coode.oppl.exceptions.RuntimeExceptionHandler;

public interface OPPLLintAbstractFactory {
	/**
	 * Initialises the OPPL Parser with the input String
	 * 
	 * @param string
	 * 
	 */
	OPPLLintScript buildOPPLLintScript(String name, OPPLScript opplScript, Variable<?> v,
			String explanationTemplate, String description, boolean inferenceRequired,
			RuntimeExceptionHandler handler);

	OPPLAbstractFactory getOPPLFactory();
}
