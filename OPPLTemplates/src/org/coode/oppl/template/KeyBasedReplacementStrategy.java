/**
 * 
 */
package org.coode.oppl.template;

import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.coode.oppl.OPPLParser;
import org.coode.oppl.OPPLScript;

/**
 * This strategy assumes that place-holders are also keys in a
 * {@link Properties} instance. It replaces them with their corresponding
 * values. The property names are the place-holders name <b>without</b> the
 * {@literal %} prefix
 * 
 * @author Luigi Iannone
 * 
 */
public final class KeyBasedReplacementStrategy implements ReplacementStrategy {
	private final Properties properties;

	/**
	 * @param properties
	 */
	public KeyBasedReplacementStrategy(Properties properties) {
		if (properties == null) {
			throw new NullPointerException("The properties cannot be null");
		}
		this.properties = properties;
	}

	/**
	 * @see org.coode.oppl.template.ReplacementStrategy#replace(java.lang.String,
	 *      org.coode.oppl.template.OPPLParserCreationStrategy)
	 */
	public OPPLScript replace(String templateString,
			OPPLParserCreationStrategy parserCreationStrategy) {
		Pattern pattern = Pattern.compile("%\\w+");
		String opplScriptString = templateString;
		Matcher matcher = pattern.matcher(opplScriptString);
		while (matcher.find()) {
			String placeholder = matcher.group();
			opplScriptString = opplScriptString.replaceAll(
					placeholder,
					this.getReplacement(placeholder));
			matcher = pattern.matcher(opplScriptString);
		}
		OPPLParser parser = parserCreationStrategy.build();
		OPPLScript opplScript = parser.parse(opplScriptString);
		return opplScript;
	}

	private String getReplacement(String placeholder) {
		String replacement = this.properties.getProperty(placeholder.substring(1));
		if (replacement == null) {
			throw new NullPointerException("Missing value for place-holder " + placeholder);
		}
		return replacement;
	}
}
