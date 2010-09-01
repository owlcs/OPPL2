/**
 * 
 */
package org.coode.oppl.template.commons;

import org.coode.oppl.template.OPPLTemplate;
import org.coode.oppl.template.ParsingStrategy;
import org.coode.oppl.template.ReplacementStrategy;

/**
 * @author Luigi Iannone
 * 
 */
public class StringTemplate<O> implements OPPLTemplate<O> {
	private final String templateString;
	private final ReplacementStrategy<O> replacementStrategy;
	private final ParsingStrategy<O> parserCreationStrategy;

	public StringTemplate(String templateString,
			ReplacementStrategy<O> replacementStrategy,
			ParsingStrategy<O> parserCreationStrategy) {
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
	public O replace() {
		return this.getReplacementStrategy().replace(this.getTemplateString(),
				this.parserCreationStrategy);
	}

	/**
	 * @return the replacementStrategy
	 */
	public ReplacementStrategy<O> getReplacementStrategy() {
		return this.replacementStrategy;
	}

	/**
	 * @see org.coode.oppl.template.OPPLTemplate#getTemplateString()
	 */
	public String getTemplateString() {
		return this.templateString;
	}
}
