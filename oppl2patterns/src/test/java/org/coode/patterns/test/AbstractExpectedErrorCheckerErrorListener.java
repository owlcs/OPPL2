package org.coode.patterns.test;

import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.RewriteEmptyStreamException;
import org.coode.parsers.ErrorListener;
import org.coode.parsers.Type;

/** Extends this to check a particular error is expected. Override the method(s)
 * corresponding to the expected error(s).
 * 
 * @author Luigi Iannone */
public class AbstractExpectedErrorCheckerErrorListener implements ErrorListener {
    @Override
    public void unrecognisedSymbol(CommonTree t) {
        throw new RuntimeException(t.toString());
    }

    @Override
    public void incompatibleSymbolType(CommonTree t, Type type, CommonTree expression) {
        throw new RuntimeException(t.toString());
    }

    @Override
    public void incompatibleSymbols(CommonTree parentExpression, CommonTree... trees) {
        throw new RuntimeException(parentExpression.toString());
    }

    @Override
    public void illegalToken(CommonTree t, String message) {
        throw new RuntimeException(t.toString());
    }

    @Override
    public void recognitionException(RecognitionException e) {
        throw new RuntimeException(e);
    }

    @Override
    public void recognitionException(RecognitionException e, String... tokenNames) {
        throw new RuntimeException(e);
    }

    @Override
    public void rewriteEmptyStreamException(RewriteEmptyStreamException e) {
        throw new RuntimeException(e);
    }

    @Override
    public void reportThrowable(Throwable t, int line, int charPosInLine, int length) {
        throw new RuntimeException(t);
    }
}
