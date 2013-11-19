
package org.coode.oppl.template;

/** Abstraction over the replacement strategy. Implementations specify how they
 * perform the substitution of place-holders. The result of the replacement is
 * parametrised.
 * 
 * @param <I>
 *            The type of input
 * @param <O>
 *            The type of replacement result.
 * @author Luigi Iannone */
public interface ReplacementStrategy<I, O> {
    /** Replace the place-holders in the input templateString and builds the
     * relative OPPLScript.
     * 
     * @param templateString
     *            The String containing the template. Cannot be
     *            <code>null</code>.
     * @param parserCreationStrategy
     *            The Parser creation strategy to generate an OPPL Parser for
     *            the resulting script. Cannot be <code>null</code>.
     * @return The OPPLScript resulting from the replacement, or
     *         <code>null</code> if parser errors occurred.
     * @throws NullPointerException
     *             if either input is <code>null</code>. */
    O replace(I template);
}
