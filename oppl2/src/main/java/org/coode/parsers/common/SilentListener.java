package org.coode.parsers.common;

import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.RewriteEmptyStreamException;
import org.coode.parsers.ErrorListener;
import org.coode.parsers.Type;

/** This implementation does not do anything when any error is encountered.
 * 
 * @author Luigi Iannone */
public class SilentListener implements ErrorListener {
    @Override
    public void illegalToken(CommonTree t, String message) {}

    @Override
    public void incompatibleSymbolType(CommonTree t, Type type, CommonTree expression) {}

    @Override
    public void incompatibleSymbols(CommonTree parentExpression, CommonTree... trees) {}

    @Override
    public void recognitionException(RecognitionException e) {}

    @Override
    public void recognitionException(RecognitionException e, String... tokenNames) {}

    @Override
    public void reportThrowable(Throwable t, int line, int charPosInLine, int length) {}

    @Override
    public void rewriteEmptyStreamException(RewriteEmptyStreamException e) {}

    @Override
    public void unrecognisedSymbol(CommonTree t) {}
}
