package org.coode.oppl.template;

/** Generic component whose implementations parse an instance of I and produce
 * instance of the parameter O
 * 
 * @param <O>
 *            The type produced by the parsing.
 * @param <I>
 *            The kind of input.
 * @author Luigi Iannone */
public interface ParsingStrategy<I, O> {
    /** Parses the input and produces an instance of the parameter O.
     * 
     * @param input
     *            The input to parse. cannot be {@code null}.
     * @return an instance O
     * @throws NullPointerException
     *             if the input is {@code null}. */
    O parse(I input);
}
