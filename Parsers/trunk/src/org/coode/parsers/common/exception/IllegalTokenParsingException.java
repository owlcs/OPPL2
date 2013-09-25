/**
 * 
 */
package org.coode.parsers.common.exception;

/** @author Luigi Iannone */
public class IllegalTokenParsingException extends ParsingException {
    /**
	 * 
	 */
    private static final long serialVersionUID = -2790580594673053303L;
    private final String token;

    /** @param line
     * @param charPositionInLine
     * @param message
     * @param cause
     * @param token */
    public IllegalTokenParsingException(String token, int line, int charPositionInLine,
            String message) {
        super(message, line, charPositionInLine);
        this.token = token;
    }

    /** @return the token */
    public String getToken() {
        return token;
    }
}
