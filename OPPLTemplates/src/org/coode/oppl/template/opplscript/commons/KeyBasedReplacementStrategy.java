/**
 * 
 */
package org.coode.oppl.template.commons;

import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.coode.oppl.OPPLParser;
import org.coode.oppl.OPPLScript;
import org.coode.oppl.template.opplscript.OPPLScriptParsingStrategy;
import org.coode.oppl.template.opplscript.OPPLScriptReplacementStrategy;

/**
 * This strategy assumes that place-holders are also keys in a
 * {@link Properties} instance. It replaces them with their corresponding
 * values. The property names are the place-holders name <b>without</b> the
 * {@literal %} prefix
 * 
 * @author Luigi Iannone
 * 
 */
public final class KeyBasedReplacementStrategy implements
		OPPLScriptReplacementStrategy {
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
	public OPPLScript replace(String templateString,
			OPPLScriptParsingStrategy parserCreationStrategy) {
		// Non greedy matching
		Pattern pattern = Pattern.compile("\\$\\{(.+?)\\}");
		String opplScriptString = templateString;
		Matcher matcher = pattern.matcher(opplScriptString);
		while (matcher.find()) {
			String placeholder = matcher.group();
			String key = matcher.group(1);
			opplScriptString = opplScriptString.replaceAll(this
					.encode(placeholder), this.getReplacement(key));
			matcher = pattern.matcher(opplScriptString);
		}
		OPPLParser parser = parserCreationStrategy.build();
		OPPLScript opplScript = parser.parse(opplScriptString);
		return opplScript;
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
