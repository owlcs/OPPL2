package org.coode.parsers.test;

import java.util.Formatter;
import java.util.Locale;

import junit.framework.TestCase;

import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.RewriteEmptyStreamException;
import org.coode.parsers.ErrorListener;
import org.coode.parsers.Type;

public final class JUnitTestErrorListener implements ErrorListener {
	public void unrecognisedSymbol(CommonTree t) {
		TestCase.fail("Unrecognised symbol " + t);
	}

	public void rewriteEmptyStreamException(RewriteEmptyStreamException e) {
		TestCase.fail(e.getMessage());
	}

	public void reportThrowable(Throwable t, int line, int charPosInLine, int length) {
		TestCase.fail(t.getMessage() + " at line " + line + " position " + charPosInLine
				+ " length " + length);
	}

	public void recognitionException(RecognitionException e, String... tokenNames) {
		StringBuilder out = new StringBuilder();
		Formatter formatter = new Formatter(out, Locale.getDefault());
		for (String string : tokenNames) {
			formatter.format("%s ", string);
		}
		TestCase.fail(e.getMessage() + out.toString());
	}

	public void recognitionException(RecognitionException e) {
		TestCase.fail(e.getMessage());
	}

	public void incompatibleSymbols(CommonTree parentExpression, CommonTree... trees) {
		StringBuilder out = new StringBuilder();
		Formatter formatter = new Formatter(out, Locale.getDefault());
		formatter.format("Incompatible symbols in %s ", parentExpression.getText());
		for (CommonTree commonTree : trees) {
			formatter.format("%s ", commonTree.getText());
		}
		TestCase.fail(out.toString());
	}

	public void incompatibleSymbolType(CommonTree t, Type type, CommonTree expression) {
		StringBuilder out = new StringBuilder();
		Formatter formatter = new Formatter(out, Locale.getDefault());
		formatter.format(
				"Incompatible symbols type [%s] for %s  in %s ",
				type,
				t.getText(),
				expression.getText());
		TestCase.fail(out.toString());
	}

	public void illegalToken(CommonTree t, String message) {
		StringBuilder out = new StringBuilder();
		Formatter formatter = new Formatter(out, Locale.getDefault());
		formatter.format("Illegal token %s  additional information: [%s]", t, message);
		TestCase.fail(out.toString());
	}
}