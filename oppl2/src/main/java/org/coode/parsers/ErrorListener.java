package org.coode.parsers;

import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.RewriteEmptyStreamException;

/** @author Luigi Iannone */
public interface ErrorListener {
    void unrecognisedSymbol(CommonTree t);

    void incompatibleSymbolType(CommonTree t, Type type, CommonTree expression);

    void incompatibleSymbols(CommonTree parentExpression, CommonTree... trees);

    void illegalToken(CommonTree t, String message);

    void recognitionException(RecognitionException e);

    void recognitionException(RecognitionException e, String... tokenNames);

    void rewriteEmptyStreamException(RewriteEmptyStreamException e);

    void reportThrowable(Throwable t, int line, int charPosInLine, int length);
}
