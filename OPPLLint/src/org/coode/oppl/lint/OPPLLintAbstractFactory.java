package org.coode.oppl.lint;

import org.coode.oppl.OPPLAbstractFactory;
import org.coode.oppl.OPPLScript;
import org.coode.oppl.Variable;

public interface OPPLLintAbstractFactory {
	/**
	 * Initialises the OPPL Parser with the input String
	 * 
	 * @param string
	 * 
	 */
	OPPLLintScript buildOPPLLintScript(String name, OPPLScript opplScript,
			Variable v, String explanationTemplate, String description);

	OPPLAbstractFactory getOPPLFactory();
}
