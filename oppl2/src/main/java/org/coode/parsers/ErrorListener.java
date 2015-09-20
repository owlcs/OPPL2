package org.coode.parsers;

import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.RewriteEmptyStreamException;

/**
 * @author Luigi Iannone
 */
public interface ErrorListener {

    /**
     * @param t
     *        t
     */
    void unrecognisedSymbol(CommonTree t);

    /**
     * @param t
     *        t
     * @param type
     *        type
     * @param expression
     *        expression
     */
    void incompatibleSymbolType(CommonTree t, Type type, CommonTree expression);

    /**
     * @param parentExpression
     *        parentExpression
     * @param trees
     *        trees
     */
    void incompatibleSymbols(CommonTree parentExpression, CommonTree... trees);

    /**
     * @param t
     *        t
     * @param message
     *        message
     */
    void illegalToken(CommonTree t, String message);

    /**
     * @param e
     *        e
     */
    void recognitionException(RecognitionException e);

    /**
     * @param e
     *        e
     * @param tokenNames
     *        tokenNames
     */
    void recognitionException(RecognitionException e, String... tokenNames);

    /**
     * @param e
     *        e
     */
    void rewriteEmptyStreamException(RewriteEmptyStreamException e);

    /**
     * @param t
     *        t
     * @param line
     *        line
     * @param charPosInLine
     *        charPosInLine
     * @param length
     *        length
     */
    void reportThrowable(Throwable t, int line, int charPosInLine, int length);
}
