/**
 * 
 */
package org.coode.oppl.template.commons;

import org.coode.oppl.OPPLScript;
import org.coode.oppl.template.OPPLParserCreationStrategy;
import org.coode.oppl.template.ReplacementStrategy;
import org.coode.oppl.template.StringTemplate;

/**
 * @author Luigi Iannone
 * 
 */
public final class StringTemplateWithParamCollection extends StringTemplate {
	private final OPPLParserCreationStrategy parserCreationStrategy;

	public StringTemplateWithParamCollection(String templateString,
			ReplacementStrategy replacementStrategy,
			OPPLParserCreationStrategy parserCreationStrategy) {
		super(templateString, replacementStrategy);
		if (parserCreationStrategy == null) {
			throw new NullPointerException("The parser factory cannot be null");
		}
		this.parserCreationStrategy = parserCreationStrategy;
	}

	/**
	 * @see org.coode.oppl.template.OPPLTemplate#replace()
	 */
	public OPPLScript replace() {
		return this.getReplacementStrategy().replace(
				this.getTemplateString(),
				this.parserCreationStrategy);
	}
}
