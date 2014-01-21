package org.coode.parsers;

import static org.coode.oppl.utils.ArgCheck.checkNotNull;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.RewriteEmptyStreamException;

/** Error listener based on a Logger. It logs onto the internal logger all the
 * errors it encounters. Its default Level will be WARNING.
 * 
 * @author Luigi Iannone */
public class LoggerErrorListener implements ErrorListener {
    private final Logger logger;

    /** @param logger
     *            logger */
    public LoggerErrorListener(Logger logger) {
        this(logger, Level.WARNING);
    }

    private Level level;

    /** @param logger
     *            logger
     * @param level
     *            level */
    public LoggerErrorListener(Logger logger, Level level) {
        this.logger = checkNotNull(logger, "logger");
        this.level = checkNotNull(level, "level");
    }

    @Override
    public void unrecognisedSymbol(CommonTree t) {
        getLogger().log(
                getLevel(),
                "Unerecognised token " + t.getText() + " at line " + t.getLine()
                        + " position " + t.getCharPositionInLine());
    }

    @Override
    public void incompatibleSymbolType(CommonTree t, Type type, CommonTree expression) {
        getLogger().log(
                getLevel(),
                "Incompatible type " + type + " for token " + t.getText()
                        + " in expression " + expression + " at line " + t.getLine()
                        + " position " + t.getCharPositionInLine());
    }

    @Override
    public void rewriteEmptyStreamException(RewriteEmptyStreamException e) {
        getLogger().log(getLevel(), e.getMessage());
    }

    @Override
    public void recognitionException(RecognitionException e) {
        String message = e.getMessage() != null ? e.getMessage() : "";
        getLogger().log(
                getLevel(),
                "Recognition exception " + message + " unexpected token code "
                        + e.getUnexpectedType());
    }

    @Override
    public void reportThrowable(Throwable t, int line, int charPosInLine, int length) {
        getLogger().log(getLevel(),
                t.getMessage() + " at line " + line + " position " + length);
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
        getLogger().log(
                getLevel(),
                "Recognition exception " + e.getMessage() + " " + e.getUnexpectedType()
                        + " for token names " + builder.toString());
    }

    @Override
    public void illegalToken(CommonTree t, String message) {
        getLogger().log(
                getLevel(),
                "Illegal token " + t.getText() + " at line " + t.getLine() + " position "
                        + t.getCharPositionInLine() + ": " + message);
    }

    @Override
    public void incompatibleSymbols(CommonTree parentExpression,
            CommonTree... expressions) {
        StringBuilder message = new StringBuilder("Incompatible children in "
                + parentExpression.getText());
        boolean first = true;
        for (CommonTree token : expressions) {
            String comma = first ? "" : ", ";
            message.append(comma);
            first = false;
            message.append(token.getText());
        }
        getLogger().log(getLevel(), message.toString());
    }

    /** @return the level */
    public Level getLevel() {
        return level;
    }

    /** @param level
     *            the level to set */
    public void setLevel(Level level) {
        this.level = level;
    }

    /** @return the logger */
    public Logger getLogger() {
        return logger;
    }
}
