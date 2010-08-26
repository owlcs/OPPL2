/**
 * 
 */
package org.coode.oppl.template;

/**
 * OPPLTemplate built over a String.
 * 
 * @author Luigi Iannone
 * 
 */
public abstract class StringTemplate implements OPPLTemplate {
	private final String templateString;
	private final ReplacementStrategy replacementStrategy;

	/**
	 * @param templateString
	 */
	public StringTemplate(String templateString, ReplacementStrategy replacementStrategy) {
		if (templateString == null) {
			throw new NullPointerException("The template string cannot be null");
		}
		if (replacementStrategy == null) {
			throw new NullPointerException("The replacement strategy cannot be null");
		}
		this.templateString = templateString;
		this.replacementStrategy = replacementStrategy;
	}

	/**
	 * @see org.coode.oppl.template.OPPLTemplate#getTemplateString()
	 */
	public String getTemplateString() {
		return this.templateString;
	}

	/**
	 * @return the replacementStrategy
	 */
	public ReplacementStrategy getReplacementStrategy() {
		return this.replacementStrategy;
	}
}
