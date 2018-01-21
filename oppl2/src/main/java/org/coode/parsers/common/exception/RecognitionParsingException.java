package org.coode.parsers.common.exception;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Luigi Iannone
 */
public class RecognitionParsingException extends ParsingException {

    private static final long serialVersionUID = 20100L;
    private final Set<String> symbols = new HashSet<>();

    /**
     * @param line line
     * @param charPositionInLine charPositionInLine
     */
    public RecognitionParsingException(int line, int charPositionInLine) {
        this(line, charPositionInLine, (String[]) null);
    }

    /**
     * @param line line
     * @param charPositionInLine charPositionInLine
     * @param symbols symbols
     */
    public RecognitionParsingException(int line, int charPositionInLine, String... symbols) {
        super(
            String.format("Recognition exception at line %d char position in line %d",
                Integer.valueOf(line), Integer.valueOf(charPositionInLine)),
            line, charPositionInLine);
        if (symbols != null) {
            for (String string : symbols) {
                this.symbols.add(string);
            }
        }
    }

    /**
     * @return the symbols
     */
    public Set<String> getSymbols() {
        return new HashSet<>(symbols);
    }
}
