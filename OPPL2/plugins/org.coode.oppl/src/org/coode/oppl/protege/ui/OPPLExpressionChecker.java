package org.coode.oppl.protege.ui;

import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.RewriteEmptyStreamException;
import org.coode.parsers.ErrorListener;
import org.coode.parsers.Type;
import org.coode.parsers.ui.AbstractLinearisingErrorReport;
import org.coode.parsers.ui.ErrorReport;
import org.coode.parsers.ui.ExpressionChecker;
import org.protege.editor.owl.OWLEditorKit;

public abstract class OPPLExpressionChecker<O> implements ExpressionChecker<O> {
	private final class ErrorReportImpl extends AbstractLinearisingErrorReport {
		private final String message;
		private final int charPositionInLine;
		private final int line;
		private final int length;

		/**
		 * @param message
		 * @param charPositionInline
		 * @param endIndex
		 */
		public ErrorReportImpl(String message, int line, int charPositionInline, int length) {
			if (message == null) {
				throw new NullPointerException("The message cannot be null");
			}
			this.message = message;
			this.charPositionInLine = charPositionInline;
			this.line = line;
			this.length = length;
		}

		/**
		 * @return the message
		 */
		public String getMessage() {
			return this.message;
		}

		/**
		 * @return the startIndex
		 */
		public int getCharPositionInLine() {
			return this.charPositionInLine;
		}

		/**
		 * @return the line
		 */
		public int getLine() {
			return this.line;
		}

		/**
		 * @return the length
		 */
		public int getLength() {
			return this.length;
		}
	}

	private final class OPPLExpressionCheckerErrorListener implements ErrorListener {
		private CommonTree lastErrorTree = null;

		public void clear() {
			this.lastErrorTree = null;
		}

		boolean isRedundant(CommonTree possibleParent, CommonTree newErrorTree) {
			boolean b = possibleParent != null;
			if (b) {
				b = possibleParent == newErrorTree || newErrorTree.equals(possibleParent);
				if (!b) {
					b = possibleParent.parent == newErrorTree;
					if (!b) {
						b = this.isRedundant(possibleParent.parent, newErrorTree);
					}
				}
			}
			return b;
		}

		public void reportThrowable(Throwable t, int line, int charPosInLine, int length) {
			OPPLExpressionChecker.this.lastReport = new ErrorReportImpl(t.getMessage(), line,
					charPosInLine, length);
		}

		boolean isRedundant(CommonTree newErrorTree) {
			return this.isRedundant(this.lastErrorTree, newErrorTree);
		}

		public void unrecognisedSymbol(CommonTree t) {
			this.lastErrorTree = t;
			OPPLExpressionChecker.this.lastReport = new ErrorReportImpl("Unrecognised token "
					+ t.getText(), t.getLine(), t.getCharPositionInLine(), t.getText().length());
		}

		public void recognitionException(RecognitionException e) {
			String message = e.getMessage() == null ? e.getClass().getName() : e.getMessage();
			int endIndex = e.token.getText() == null ? 0 : e.token.getText().length();
			OPPLExpressionChecker.this.lastReport = new ErrorReportImpl(message + " on token "
					+ e.token, e.line, e.charPositionInLine, endIndex);
		}

		public void recognitionException(RecognitionException e, String... tokenNames) {
			String message = "Recognition exception on the token " + e.token
					+ e.getClass().getSimpleName();
			int endIndex = e.token.getText() == null ? 0 : e.token.getText().length();
			OPPLExpressionChecker.this.lastReport = new ErrorReportImpl(message, e.line,
					e.charPositionInLine, endIndex);
		}

		public void rewriteEmptyStreamException(RewriteEmptyStreamException e) {
			OPPLExpressionChecker.this.lastReport = new ErrorReportImpl(e.getMessage().replaceAll(
					"Rule",
					"Incomplete "), 0, 0, 0);
		}

		public void incompatibleSymbols(CommonTree parentExpression, CommonTree... expressions) {
			StringBuilder builder = new StringBuilder();
			builder.append("[");
			boolean first = true;
			for (CommonTree expression : expressions) {
				String comma = first ? "" : ", ";
				first = false;
				builder.append(comma);
				builder.append(expression.getText() == null ? "" : expression.getText());
			}
			builder.append("]");
			OPPLExpressionChecker.this.lastReport = new ErrorReportImpl(
					"Incompatible children expressions: " + builder.toString()
							+ " for the parent expression  " + parentExpression.getText(),
					parentExpression.getLine(), parentExpression.getCharPositionInLine(),
					parentExpression.getText().length());
		}

		public void incompatibleSymbolType(CommonTree t, Type type, CommonTree expression) {
			if (!this.isRedundant(t)) {
				this.lastErrorTree = t;
				OPPLExpressionChecker.this.lastReport = new ErrorReportImpl("Incompatible type: "
						+ type + "  for token: " + t.getText() + " for the parent expression "
						+ expression.getText(), t.getLine(), t.getCharPositionInLine(),
						t.getText().length());
			}
		}

		public void illegalToken(CommonTree t, String message) {
			OPPLExpressionChecker.this.lastReport = new ErrorReportImpl("Illegal token: "
					+ t.getText(), t.getLine(), t.getCharPositionInLine(), t.getText().length());
		}
	}

	private final OWLEditorKit owlEditorKit;
	private final OPPLExpressionCheckerErrorListener listener = new OPPLExpressionCheckerErrorListener();
	private O lastObject = null;
	private ErrorReport lastReport = null;

	/**
	 * @param owlEditorKit
	 */
	public OPPLExpressionChecker(OWLEditorKit owlEditorKit) {
		if (owlEditorKit == null) {
			throw new NullPointerException("The OWL editor kit cannot be null");
		}
		this.owlEditorKit = owlEditorKit;
	}

	public void check(String text) {
		this.reset();
		this.lastObject = this.parse(text);
	}

	protected abstract O parse(String text);

	public O createObject(String text) {
		return this.lastObject;
	}

	public ErrorReport getErrorReport() {
		return this.lastReport;
	}

	/**
	 * 
	 */
	private void reset() {
		this.lastObject = null;
		this.lastReport = null;
		this.listener.clear();
	}

	/**
	 * @return the owlEditorKit
	 */
	public OWLEditorKit getOWLEditorKit() {
		return this.owlEditorKit;
	}

	/**
	 * @return the listener
	 */
	public ErrorListener getListener() {
		return this.listener;
	}
}
