package org.coode.oppl;

/**
 * @author Luigi Iannone
 */
public interface AbstractOPPLParser {

    /**
     * Parses a valid OPPL string into an OPPL Script
     * 
     * @param input
     *        The OPPL string. Cannot be {@code null}.
     * @return The resulting OPPLScript if the input String is valid.
     *         {@code null} otherwise.
     * @throws NullPointerException
     *         if the input is {@code null}.
     */
    OPPLScript parse(String input);
}
