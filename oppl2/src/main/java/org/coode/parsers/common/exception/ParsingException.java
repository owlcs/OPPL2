package org.coode.parsers.common.exception;

/** @author Luigi Iannone */
public class ParsingException extends RuntimeException {
    private static final long serialVersionUID = 20100L;
    private final int charPositionInLine;
    private final int line;

    /** @param line
     *            line
     * @param charPositionInLine
     *            charPositionInLine
     * @param message
     *            message
     * @param cause
     *            cause */
    public ParsingException(int line, int charPositionInLine, String message,
            Throwable cause) {
        super(message, cause);
        this.charPositionInLine = charPositionInLine;
        this.line = line;
    }

    /** @param message
     *            message
     * @param line
     *            line
     * @param charPositionInLine
     *            charPositionInLine */
    public ParsingException(String message, int line, int charPositionInLine) {
        super(message);
        this.charPositionInLine = charPositionInLine;
        this.line = line;
    }

    /** @param line
     *            line
     * @param charPositionInLine
     *            charPositionInLine
     * @param cause
     *            cause */
    public ParsingException(int line, int charPositionInLine, Throwable cause) {
        super(cause);
        this.charPositionInLine = charPositionInLine;
        this.line = line;
    }

    /** @return the charPositionInLine */
    public int getCharPositionInLine() {
        return charPositionInLine;
    }

    /** @return the line */
    public int getLine() {
        return line;
    }
}
