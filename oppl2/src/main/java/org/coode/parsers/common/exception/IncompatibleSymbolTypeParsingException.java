package org.coode.parsers.common.exception;

import org.coode.parsers.Type;

public class IncompatibleSymbolTypeParsingException extends ParsingException {
    private static final long serialVersionUID = -6219109479849546139L;
    private final String symbol;
    private final Type type;
    private final String parentExpression;

    /** @param message
     * @param line
     * @param charPositionInLine */
    public IncompatibleSymbolTypeParsingException(String tokenText, Type type,
            String parentExpression, int line, int charPositionInLine) {
        super(
                String.format(
                        "Incompatible symbol type (%s) %s at line %d char position in line %d for the expression %s",
                        type, tokenText, line, charPositionInLine, parentExpression),
                line, charPositionInLine);
        symbol = tokenText;
        this.type = type;
        this.parentExpression = parentExpression;
    }

    /** @return the symbol */
    public String getSymbol() {
        return symbol;
    }

    /** @return the type */
    public Type getType() {
        return type;
    }

    /** @return the parentExpression */
    public String getParentExpression() {
        return parentExpression;
    }
}
