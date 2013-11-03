/**
 * 
 */
package org.coode.parsers.common.exception;

/** @author Luigi Iannone */
public class RewriteEmptyStreamParsingException extends ParsingException {
    /**
	 * 
	 */
    private static final long serialVersionUID = 7619818807706886578L;

    /** @param message
     * @param line
     * @param charPositionInLine */
    public RewriteEmptyStreamParsingException(int line, int charPositionInLine) {
        super(String.format(
                "Rewriting an empty stream at line %d char position in line %d", line,
                charPositionInLine), line, charPositionInLine);
    }
}
