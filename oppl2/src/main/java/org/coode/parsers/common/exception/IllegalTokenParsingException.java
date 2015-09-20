package org.coode.parsers.common.exception;

/**
 * @author Luigi Iannone
 */
public class IllegalTokenParsingException extends ParsingException {

    private static final long serialVersionUID = 20100L;
    private final String token;

    /**
     * @param line
     *        line
     * @param charPositionInLine
     *        charPositionInLine
     * @param message
     *        message
     * @param token
     *        token
     */
    public IllegalTokenParsingException(String token, int line, int charPositionInLine,
        String message) {
        super(message, line, charPositionInLine);
        this.token = token;
    }

    /**
     * @return the token
     */
    public String getToken() {
        return token;
    }
}
