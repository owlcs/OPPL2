package org.coode.patterns.test;

import static org.junit.Assert.fail;

import java.util.Arrays;

import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.RewriteEmptyStreamException;
import org.coode.parsers.ErrorListener;
import org.coode.parsers.Type;

@SuppressWarnings("javadoc")
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
        fail(e.getMessage() + Arrays.toString(tokenNames));
    }

    @Override
    public void recognitionException(RecognitionException e) {
        fail(e.getMessage());
    }

    @Override
    public void incompatibleSymbols(CommonTree parentExpression, CommonTree... trees) {
        StringBuilder out = new StringBuilder();
        out.append(String.format("Incompatible symbols in %s ",
            parentExpression.getText()));
        out.append(Arrays.toString(trees));
        fail(out.toString());
    }

    @Override
    public void incompatibleSymbolType(CommonTree t, Type type, CommonTree expression) {
        fail(String.format("Incompatible symbols type [%s] for %s  in %s ", type,
            t.getText(), expression.getText()));
    }

    @Override
    public void illegalToken(CommonTree t, String message) {
        fail(String.format("Illegal token %s  additional information: [%s]", t, message));
    }
}
