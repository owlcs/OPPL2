package org.coode.parsers.common.exception;

/**
 * @author Luigi Iannone
 */
public class UnrecognisedSymbolParsingException extends ParsingException {

    private static final long serialVersionUID = 20100L;
    private final String symbol;

    /**
     * @param tokenText
     *        tokenText
     * @param line
     *        line
     * @param charPositionInLine
     *        charPositionInLine
     */
    public UnrecognisedSymbolParsingException(String tokenText, int line,
        int charPositionInLine) {
        super(String.format("Unrecognised token %s at line %d char position in line %d",
            tokenText, line, charPositionInLine), line, charPositionInLine);
        symbol = tokenText;
    }

    /**
     * @return the symbol
     */
    public String getSymbol() {
        return symbol;
    }
}
