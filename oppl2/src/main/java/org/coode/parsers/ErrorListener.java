
package org.coode.parsers;

import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.RewriteEmptyStreamException;

/** @author Luigi Iannone */
public interface ErrorListener {
    public void unrecognisedSymbol(CommonTree t);

    public void incompatibleSymbolType(CommonTree t, Type type, CommonTree expression);

    public void incompatibleSymbols(CommonTree parentExpression, CommonTree... trees);

    public void illegalToken(CommonTree t, String message);

    public void recognitionException(RecognitionException e);

    public void recognitionException(RecognitionException e, String... tokenNames);

    public void rewriteEmptyStreamException(RewriteEmptyStreamException e);

    public void reportThrowable(Throwable t, int line, int charPosInLine, int length);
}
