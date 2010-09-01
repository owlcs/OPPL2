/**
 * 
 */
package org.coode.oppl.template.commons;

import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.coode.oppl.template.ParsingStrategy;
import org.coode.oppl.template.ReplacementStrategy;

/**
 * This strategy assumes that place-holders are also keys in a
 * {@link Properties} instance. It replaces them with their corresponding
 * values. The property names are the place-holders name <b>without</b> the
 * {@literal %} prefix
 * 
 * @author Luigi Iannone
 * 
 */
public final class KeyBasedReplacementStrategy<O> implements
		ReplacementStrategy<O> {
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
	 * @see org.coode.oppl.template.opplscript.OPPLScriptReplacementStrategy#replace(java.lang.String,
	 *      org.coode.oppl.template.opplscript.OPPLScriptParsingStrategy)
	 */
	public O replace(String templateString,
			ParsingStrategy<O> parsingStrategy) {
		// Non greedy matching
		Pattern pattern = Pattern.compile("\\$\\{(.+?)\\}");
		String replacedString = templateString;
		Matcher matcher = pattern.matcher(replacedString);
		while (matcher.find()) {
			String placeholder = matcher.group();
			String key = matcher.group(1);
			replacedString = replacedString.replaceAll(this
					.encode(placeholder), this.getReplacement(key));
			matcher = pattern.matcher(replacedString);
		}
		return parsingStrategy.parse(replacedString);
	}

	private String encode(String placeholder) {
		return placeholder.replaceAll("(\\$)", "\\\\$1").replaceAll("(\\{)",
				"\\\\$1").replaceAll("(\\})", "\\\\$1");
	}

	private String getReplacement(String placeholder) {
		String replacement = this.properties.getProperty(placeholder);
		if (replacement == null) {
			throw new NullPointerException("Missing value for place-holder "
					+ placeholder);
		}
		return replacement;
	}
}
