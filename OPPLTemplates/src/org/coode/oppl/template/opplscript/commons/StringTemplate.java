/**
 * 
 */
package org.coode.oppl.template.opplscript.commons;

import org.coode.oppl.OPPLScript;
import org.coode.oppl.template.opplscript.OPPLScriptParsingStrategy;
import org.coode.oppl.template.opplscript.OPPLScriptReplacementStrategy;
import org.coode.oppl.template.opplscript.OPPLScriptTemplate;

/**
 * @author Luigi Iannone
 * 
 */
public final class StringTemplate implements OPPLScriptTemplate {
	private final String templateString;
	private final OPPLScriptReplacementStrategy replacementStrategy;
	private final OPPLScriptParsingStrategy parserCreationStrategy;

	public StringTemplate(String templateString,
			OPPLScriptReplacementStrategy replacementStrategy,
			OPPLScriptParsingStrategy parserCreationStrategy) {
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
	public OPPLScriptReplacementStrategy getReplacementStrategy() {
		return this.replacementStrategy;
	}

	/**
	 * @see org.coode.oppl.template.OPPLTemplate#getTemplateString()
	 */
	public String getTemplateString() {
		return this.templateString;
	}
}
