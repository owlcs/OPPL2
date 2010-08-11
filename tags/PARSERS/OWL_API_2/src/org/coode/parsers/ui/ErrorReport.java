/**
 * 
 */
package org.coode.parsers.ui;

/**
 * @author Luigi Iannone
 * 
 */
public interface ErrorReport {
	String getMessage();

	int getCharPositionInLine();

	int getLength();

	int getLine();

	/**
	 * Linearises the input text and returns the position of this error report
	 * in a monodimensional space.
	 * 
	 * @param text
	 * @return the position of the initial character this error report refers to
	 *         in a linearised version of the input text.
	 */
	int getLinearisedPosition(String text);
}
