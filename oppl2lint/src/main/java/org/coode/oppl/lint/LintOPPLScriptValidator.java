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
	public boolean accept(OPPLScript script) {
		return script.getQuery() != null;
	}

	public String getValidationRuleDescription() {
		return "The script must have a query part";
	}
}
