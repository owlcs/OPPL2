/**
 * 
 */
package org.coode.oppl.template;

/**
 * Generic component whose implementations parse a String and produce instance
 * of the parameter O
 * 
 * @param <O>
 *            The type produced by the parsing.
 * @author Luigi Iannone
 * 
 */
public interface ParsingStrategy<O> {
	/**
	 * Parses the input and produces an instance of the parameter O.
	 * 
	 * @param input
	 *            The string to parse. cannot be <code>null</code>.
	 * 
	 * @return an instance O
	 * @throws NullPointerException
	 *             if the input is <code>null</code>.
	 */
	O parse(String input);
}
