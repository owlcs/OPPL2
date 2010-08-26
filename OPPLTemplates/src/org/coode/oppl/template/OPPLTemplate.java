/**
 * 
 */
package org.coode.oppl.template;

import org.coode.oppl.OPPLScript;

/**
 * A template is a String with place-holders. Replacing such place holders with
 * the appropriate String will produce an OPPL Script.
 * 
 * @author Luigi Iannone
 * 
 */
public interface OPPLTemplate {
	/**
	 * Retrieves the template String.
	 * 
	 * @return A String with place-holders.
	 */
	String getTemplateString();

	/**
	 * Performs the replacement.
	 * 
	 * 
	 * 
	 * @return an OPPLScript if the replacement produced a valid
	 *         {@link OPPLScript}. <code>null</code> otherwise.
	 */
	OPPLScript replace();
}
