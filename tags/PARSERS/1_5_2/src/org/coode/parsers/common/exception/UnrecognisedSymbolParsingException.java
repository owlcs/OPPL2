package org.coode.parsers.common.exception;

public class UnrecognisedSymbolParsingException extends ParsingException {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3123067319497878938L;
	private final String symbol;

	/**
	 * @param message
	 * @param line
	 * @param charPositionInLine
	 */
	public UnrecognisedSymbolParsingException(String tokenText, int line, int charPositionInLine) {
		super(String.format(
				"Unrecognised token %s at line %d char position in line %d",
				tokenText,
				line,
				charPositionInLine), line, charPositionInLine);
		this.symbol = tokenText;
	}

	/**
	 * @return the symbol
	 */
	public String getSymbol() {
		return this.symbol;
	}
}
