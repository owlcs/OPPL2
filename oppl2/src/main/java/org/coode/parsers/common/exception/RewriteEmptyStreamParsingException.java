package org.coode.parsers.common.exception;

/** @author Luigi Iannone */
public class RewriteEmptyStreamParsingException extends ParsingException {
    private static final long serialVersionUID = 20100L;

    /** @param line
     *            line
     * @param charPositionInLine
     *            charPositionInLine */
    public RewriteEmptyStreamParsingException(int line, int charPositionInLine) {
        super(String.format(
                "Rewriting an empty stream at line %d char position in line %d", line,
                charPositionInLine), line, charPositionInLine);
    }
}
