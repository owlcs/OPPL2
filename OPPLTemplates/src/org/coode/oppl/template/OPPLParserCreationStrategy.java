package org.coode.oppl.template;

import org.coode.oppl.OPPLParser;

/**
 * Implementations of this interface provide OPPLParser instances.
 * 
 * @author Luigi Iannone
 * 
 */
public interface OPPLParserCreationStrategy {
	/**
	 * Builds an OPPLParser
	 * 
	 * @return the OPPLParser.
	 */
	OPPLParser build();
}
