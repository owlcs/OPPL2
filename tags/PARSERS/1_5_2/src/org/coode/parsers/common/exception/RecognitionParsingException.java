/**
 * 
 */
package org.coode.parsers.common.exception;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Luigi Iannone
 * 
 */
public class RecognitionParsingException extends ParsingException {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3503729637395219197L;
	private final Set<String> symbols = new HashSet<String>();

	public RecognitionParsingException(int line, int charPositionInLine) {
		this(line, charPositionInLine, (String[]) null);
	}

	public RecognitionParsingException(int line, int charPositionInLine, String... symbols) {
		super(String.format(
				"Recognition exception at line %d char position in line %d",
				line,
				charPositionInLine), line, charPositionInLine);
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
		return new HashSet<String>(this.symbols);
	}
}
