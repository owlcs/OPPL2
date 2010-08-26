/**
 * 
 */
package org.coode.oppl.template.commons;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Formatter;
import java.util.List;
import java.util.MissingFormatArgumentException;

import org.coode.oppl.OPPLParser;
import org.coode.oppl.OPPLScript;
import org.coode.oppl.template.OPPLParserCreationStrategy;
import org.coode.oppl.template.ReplacementStrategy;

/**
 * Uses {@link Formatter} to perform the substitution.
 * 
 * @author Luigi Iannone
 * 
 */
public final class JavaFormatterReplacementStrategy implements ReplacementStrategy {
	private List<Object> params;

	public JavaFormatterReplacementStrategy(Collection<? extends Object> params) {
		if (params == null) {
			throw new NullPointerException("The parameters collection cannot be null");
		}
		this.params = new ArrayList<Object>(params);
	}

	/**
	 * @throws MissingFormatArgumentException
	 *             when there is an argument in the template whose replacement
	 *             is missing
	 * @see org.coode.oppl.template.ReplacementStrategy#replace(java.lang.String,
	 *      org.coode.oppl.template.OPPLParserCreationStrategy)
	 */
	public OPPLScript replace(String templateString,
			OPPLParserCreationStrategy parserCreationStrategy) {
		Formatter formatter = new Formatter();
		formatter.format(templateString, this.params.toArray());
		String opplScriptString = formatter.toString();
		OPPLParser parser = parserCreationStrategy.build();
		OPPLScript opplScript = parser.parse(opplScriptString);
		return opplScript;
	}

	@Override
	public String toString() {
		return "java.util.Formatter based Strategy";
	}
}
