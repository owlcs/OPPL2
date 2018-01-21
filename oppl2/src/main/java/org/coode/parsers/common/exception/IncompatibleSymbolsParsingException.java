package org.coode.parsers.common.exception;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Luigi Iannone
 */
public class IncompatibleSymbolsParsingException extends ParsingException {

    private static final long serialVersionUID = 20100L;
    private final Set<String> incompatibleSymbols = new HashSet<>();

    /**
     * @param parentExpression parentExpression
     * @param line line
     * @param charPositionInLine charPositionInLine
     * @param incompatibleSymbols incompatibleSymbols
     */
    public IncompatibleSymbolsParsingException(String parentExpression, int line,
        int charPositionInLine, String... incompatibleSymbols) {
        super(
            String.format("Incompatible symbols  at line %d char position in line %d for %s",
                Integer.valueOf(line), Integer.valueOf(charPositionInLine), parentExpression),
            line, charPositionInLine);
        for (String string : incompatibleSymbols) {
            this.incompatibleSymbols.add(string);
        }
    }

    /**
     * @return the incompatibleSymbols
     */
    public Set<String> getIncompatibleSymbols() {
        return new HashSet<>(incompatibleSymbols);
    }
}
