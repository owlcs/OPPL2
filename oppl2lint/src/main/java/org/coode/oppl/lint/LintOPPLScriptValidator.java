/**
 * 
 */
package org.coode.oppl.lint;

import org.coode.oppl.OPPLScript;
import org.coode.oppl.validation.OPPLScriptValidator;

/**
 * @author Luigi Iannone
 * 
 */
public class LintOPPLScriptValidator implements OPPLScriptValidator {
	/**
	 * @see org.coode.oppl.validation.OPPLScriptValidator#accept(org.coode.oppl.
	 *      OPPLScript)
	 */
	public boolean accept(OPPLScript script) {
		return script.getQuery() != null;
	}

	/**
	 * @see org.coode.oppl.validation.OPPLScriptValidator#getValidationRuleDescription
	 *      ()
	 */
	public String getValidationRuleDescription() {
		return "The script must have a query part";
	}
}
