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
     * @param template
     *            template
     * @return The OPPLScript resulting from the replacement, or {@code null} if
     *         parser errors occurred.
     * @throws NullPointerException
     *             if either input is {@code null}. */
    O replace(I template);
}
