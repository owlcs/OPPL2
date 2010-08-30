/**
 * 
 */
package org.coode.oppl.template.commons;

import org.coode.oppl.OPPLScript;
import org.coode.oppl.template.OPPLParserCreationStrategy;
import org.coode.oppl.template.OPPLTemplate;
import org.coode.oppl.template.ReplacementStrategy;

/**
 * @author Luigi Iannone
 * 
 */
public final class StringTemplate implements OPPLTemplate {
	private final String templateString;
	private final ReplacementStrategy replacementStrategy;
	private final OPPLParserCreationStrategy parserCreationStrategy;

	public StringTemplate(String templateString,
			ReplacementStrategy replacementStrategy,
			OPPLParserCreationStrategy parserCreationStrategy) {
		if (templateString == null) {
			throw new NullPointerException("The template string cannot be null");
		}
		if (replacementStrategy == null) {
			throw new NullPointerException(
					"The replacement strategy cannot be null");
		}
		if (parserCreationStrategy == null) {
			throw new NullPointerException("The parser factory cannot be null");
		}
		this.templateString = templateString;
		this.replacementStrategy = replacementStrategy;
		this.parserCreationStrategy = parserCreationStrategy;
	}

	/**
	 * @see org.coode.oppl.template.OPPLTemplate#replace()
	 */
	public OPPLScript replace() {
		return this.getReplacementStrategy().replace(this.getTemplateString(),
				this.parserCreationStrategy);
	}

	/**
	 * @return the replacementStrategy
	 */
	public ReplacementStrategy getReplacementStrategy() {
		return this.replacementStrategy;
	}

	/**
	 * @see org.coode.oppl.template.OPPLTemplate#getTemplateString()
	 */
	public String getTemplateString() {
		return this.templateString;
	}
}
