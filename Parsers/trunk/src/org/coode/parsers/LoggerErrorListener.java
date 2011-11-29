/**
 * 
 */
package org.coode.parsers;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.RewriteEmptyStreamException;

/**
 * Error listener based on a Logger. It logs onto the internal logger all the
 * errors it encounters. Its default Level will be WARNING.
 * 
 * @author Luigi Iannone
 * 
 */
public class LoggerErrorListener implements ErrorListener {
	private final Logger logger;

	/**
	 * @param logger
	 */
	public LoggerErrorListener(Logger logger) {
		this(logger, Level.WARNING);
	}

	private Level level;

	/**
	 * @param logger
	 */
	public LoggerErrorListener(Logger logger, Level level) {
		if (logger == null) {
			throw new NullPointerException("The Logger cannot be null");
		}
		if (level == null) {
			throw new NullPointerException("The level cannot be null");
		}
		this.logger = logger;
		this.level = level;
	}

	public void unrecognisedSymbol(CommonTree t) {
		this.getLogger().log(
				this.getLevel(),
				"Unerecognised token " + t.getText() + " at line "
						+ t.getLine() + " position "
						+ t.getCharPositionInLine());
	}

	public void incompatibleSymbolType(CommonTree t, Type type,
			CommonTree expression) {
		this.getLogger().log(
				this.getLevel(),
				"Incompatible type " + type + " for token " + t.getText()
						+ " in expression " + expression + " at line "
						+ t.getLine() + " position "
						+ t.getCharPositionInLine());
	}

	public void rewriteEmptyStreamException(RewriteEmptyStreamException e) {
		this.getLogger().log(this.getLevel(), e.getMessage());
	}

	public void recognitionException(RecognitionException e) {
		String message = e.getMessage() != null ? e.getMessage() : "";
		this.getLogger().log(
				this.getLevel(),
				"Recognition exception " + message + " unexpected token code "
						+ e.getUnexpectedType());
	}

	public void reportThrowable(Throwable t, int line, int charPosInLine,
			int length) {
		this.getLogger().log(this.getLevel(),
				t.getMessage() + " at line " + line + " position " + length);
	}

	public void recognitionException(RecognitionException e,
			String... tokenNames) {
		StringBuilder builder = new StringBuilder();
		builder.append("[");
		boolean first = true;
		for (String string : tokenNames) {
			String comma = first ? "" : ", ";
			first = false;
			builder.append(comma);
			builder.append(string);
		}
		builder.append("]");
		this.getLogger().log(
				this.getLevel(),
				"Recognition exception " + e.getMessage() + " "
						+ e.getUnexpectedType() + " for token names "
						+ builder.toString());
	}

	public void illegalToken(CommonTree t, String message) {
		this.getLogger().log(
				this.getLevel(),
				"Illegal token " + t.getText() + " at line " + t.getLine()
						+ " position " + t.getCharPositionInLine() + ": "
						+ message);
	}

	public void incompatibleSymbols(CommonTree parentExpression,
			CommonTree... expressions) {
		StringBuilder message = new StringBuilder("Incompatible children in "
				+ parentExpression.getText());
		boolean first = true;
		for (CommonTree token : expressions) {
			String comma = first ? "" : ", ";
			message.append(comma);
			first = false;
			message.append(token.getText());
		}
		this.getLogger().log(this.getLevel(), message.toString());
	}

	/**
	 * @return the level
	 */
	public Level getLevel() {
		return this.level;
	}

	/**
	 * @param level
	 *            the level to set
	 */
	public void setLevel(Level level) {
		this.level = level;
	}

	/**
	 * @return the logger
	 */
	public Logger getLogger() {
		return this.logger;
	}
}
