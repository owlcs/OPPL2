package org.coode.patterns.test;

import static org.junit.Assert.fail;

import java.util.Formatter;
import java.util.Locale;

import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.RewriteEmptyStreamException;
import org.coode.parsers.ErrorListener;
import org.coode.parsers.Type;

public final class JUnitTestErrorListener implements ErrorListener {
    @Override
    public void unrecognisedSymbol(CommonTree t) {
        fail("Unrecognised symbol " + t);
    }

    @Override
    public void rewriteEmptyStreamException(RewriteEmptyStreamException e) {
        fail(e.getMessage());
    }

    @Override
    public void reportThrowable(Throwable t, int line, int charPosInLine, int length) {
        fail(t.getMessage() + " at line " + line + " position " + charPosInLine
                + " length " + length);
    }

    @Override
    public void recognitionException(RecognitionException e, String... tokenNames) {
        StringBuilder out = new StringBuilder();
        Formatter formatter = new Formatter(out, Locale.getDefault());
        for (String string : tokenNames) {
            formatter.format("%s ", string);
        }
        fail(e.getMessage() + out.toString());
    }

    @Override
    public void recognitionException(RecognitionException e) {
        fail(e.getMessage());
    }

    @Override
    public void incompatibleSymbols(CommonTree parentExpression, CommonTree... trees) {
        StringBuilder out = new StringBuilder();
        Formatter formatter = new Formatter(out, Locale.getDefault());
        formatter.format("Incompatible symbols in %s ", parentExpression.getText());
        for (CommonTree commonTree : trees) {
            formatter.format("%s ", commonTree.getText());
        }
        fail(out.toString());
    }

    @Override
    public void incompatibleSymbolType(CommonTree t, Type type, CommonTree expression) {
        StringBuilder out = new StringBuilder();
        Formatter formatter = new Formatter(out, Locale.getDefault());
        formatter.format("Incompatible symbols type [%s] for %s  in %s ", type,
                t.getText(), expression.getText());
        fail(out.toString());
    }

    @Override
    public void illegalToken(CommonTree t, String message) {
        StringBuilder out = new StringBuilder();
        Formatter formatter = new Formatter(out, Locale.getDefault());
        formatter.format("Illegal token %s  additional information: [%s]", t, message);
        fail(out.toString());
    }
}
