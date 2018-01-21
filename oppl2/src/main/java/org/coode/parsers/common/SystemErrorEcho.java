package org.coode.parsers.common;

import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.Token;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.RewriteEmptyStreamException;
import org.coode.parsers.ErrorListener;
import org.coode.parsers.Type;

/**
 * @author Luigi Iannone
 */
public final class SystemErrorEcho implements ErrorListener {

    @Override
    public void unrecognisedSymbol(CommonTree t) {
        System.err.println("Unrecognised token " + t.getText() + " at line " + t.getLine()
            + " position " + t.getCharPositionInLine());
    }

    @Override
    public void incompatibleSymbolType(CommonTree t, Type type, CommonTree expression) {
        System.err.println("Incompatible type " + type + " for token " + t.getText()
            + " in expression " + expression + " at line " + t.getLine() + " position "
            + t.getCharPositionInLine());
    }

    @Override
    public void rewriteEmptyStreamException(RewriteEmptyStreamException e) {
        System.err.println(e.getMessage().replaceAll("rule", "Incomplete "));
    }

    @Override
    public void recognitionException(RecognitionException e) {
        Token token = e.token;
        String message = String.format(
            "Recognition exception when parsing  token: %s line %d position %d message: %s",
            token.getText(), Integer.valueOf(token.getLine()),
            Integer.valueOf(token.getCharPositionInLine()), e.getMessage());
        System.err.println(message + " unexpected token code " + e.getUnexpectedType());
    }

    @Override
    public void reportThrowable(Throwable t, int line, int charPosInLine, int length) {
        System.err.println(t.getMessage() + " at line " + line + " position " + length);
    }

    @Override
    public void recognitionException(RecognitionException e, String... tokenNames) {
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        boolean first = true;
        for (String string : tokenNames) {
            String comma = first ? "" : ", ";
            first = false;
            builder.append(comma);
            builder.append(string);
        }
        builder.append("]");
        System.err.println("Recognition exception " + e.getMessage() + " " + e.getUnexpectedType()
            + " for token names " + builder.toString());
    }

    @Override
    public void illegalToken(CommonTree t, String message) {
        System.err.println("Illegal token " + t.getText() + " at line " + t.getLine() + " position "
            + t.getCharPositionInLine() + ": " + message);
    }

    @Override
    public void incompatibleSymbols(CommonTree parentExpression, CommonTree... expressions) {
        StringBuilder message =
            new StringBuilder("Incompatible children in " + parentExpression.getText());
        boolean first = true;
        for (CommonTree token : expressions) {
            String comma = first ? "" : ", ";
            message.append(comma);
            first = false;
            message.append(token.getText());
        }
        System.err.println(message);
    }
}
