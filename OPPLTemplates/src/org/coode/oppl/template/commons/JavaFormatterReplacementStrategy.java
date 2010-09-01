/**
 * 
 */
package org.coode.oppl.template.commons;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Formatter;
import java.util.List;
import java.util.MissingFormatArgumentException;

import org.coode.oppl.template.ReplacementStrategy;

/**
 * Uses {@link Formatter} to perform the substitution.
 * 
 * @author Luigi Iannone
 * 
 */
public final class JavaFormatterReplacementStrategy implements
		ReplacementStrategy<String, String> {
	private List<Object> params;

	public JavaFormatterReplacementStrategy(Collection<? extends Object> params) {
		if (params == null) {
			throw new NullPointerException(
					"The parameters collection cannot be null");
		}
		this.params = new ArrayList<Object>(params);
	}

	/**
	 * @throws MissingFormatArgumentException
	 *             when there is an argument in the template whose replacement
	 *             is missing
	 * @see org.coode.oppl.template.opplscript.OPPLScriptReplacementStrategy#replace(java.lang.String,
	 *      org.coode.oppl.template.opplscript.OPPLScriptParsingStrategy)
	 */
	public String replace(String templateString) {
		Formatter formatter = new Formatter();
		formatter.format(templateString, this.params.toArray());
		String replacedString = formatter.toString();
		return replacedString;
	}

	@Override
	public String toString() {
		return "java.util.Formatter based Strategy";
	}
}
