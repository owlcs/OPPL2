package org.coode.parsers.ui;

/** @author Luigi Iannone */
public interface ErrorReport {
    /** @return message */
    String getMessage();

    /** @return char position */
    int getCharPositionInLine();

    /** @return length */
    int getLength();

    /** @return line */
    int getLine();

    /** Linearises the input text and returns the position of this error report
     * in a monodimensional space.
     * 
     * @param text
     *            text
     * @return the position of the initial character this error report refers to
     *         in a linearised version of the input text. */
    int getLinearisedPosition(String text);
}
