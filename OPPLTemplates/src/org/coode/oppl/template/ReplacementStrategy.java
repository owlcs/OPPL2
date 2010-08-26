package org.coode.oppl.template;

import org.coode.oppl.OPPLScript;

/**
 * Abstraction over the replacement strategy. Implementations specify how they
 * perform the substitution of place-holders with Params instances.
 * 
 * @author Luigi Iannone
 * 
 */
public interface ReplacementStrategy {
	/**
	 * Replace the place-holders in the input templateString and builds the
	 * relative OPPLScript.
	 * 
	 * @param templateString
	 *            The String containing the template. Cannot be
	 *            <code>null</code>.
	 * 
	 * 
	 * @param parserCreationStrategy
	 *            The Parser creation strategy to generate an OPPL Parser for
	 *            the resulting script. Cannot be <code>null</code>.
	 * @return The OPPLScript resulting from the replacement, or
	 *         <code>null</code> if parser errors occurred.
	 * @throws NullPointerException
	 *             if either input is <code>null</code>.
	 * 
	 */
	OPPLScript replace(String templateString, OPPLParserCreationStrategy parserCreationStrategy);
}
