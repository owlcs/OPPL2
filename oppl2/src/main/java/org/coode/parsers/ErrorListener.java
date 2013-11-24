package org.coode.parsers;

import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.RewriteEmptyStreamException;

/** @author Luigi Iannone */
public interface ErrorListener {
    /** @param t */
    void unrecognisedSymbol(CommonTree t);

    /** @param t
     * @param type
     * @param expression */
    void incompatibleSymbolType(CommonTree t, Type type, CommonTree expression);

    /** @param parentExpression
     * @param trees */
    void incompatibleSymbols(CommonTree parentExpression, CommonTree... trees);

    /** @param t
     * @param message */
    void illegalToken(CommonTree t, String message);

    /** @param e */
    void recognitionException(RecognitionException e);

    /** @param e
     * @param tokenNames */
    void recognitionException(RecognitionException e, String... tokenNames);

    /** @param e */
    void rewriteEmptyStreamException(RewriteEmptyStreamException e);

    /** @param t
     * @param line
     * @param charPosInLine
     * @param length */
    void reportThrowable(Throwable t, int line, int charPosInLine, int length);
}
