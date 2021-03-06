package org.coode.parsers.common;

import java.util.ArrayList;
import java.util.List;

import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.RewriteEmptyStreamException;
import org.coode.parsers.ErrorListener;
import org.coode.parsers.Type;
import org.coode.parsers.common.exception.*;

/**
 * @author Luigi Iannone
 */
public class QuickFailErrorListener implements ErrorListener {

    @Override
    public void unrecognisedSymbol(CommonTree t) {
        throw new UnrecognisedSymbolParsingException(t.getText(), t.getLine(),
            t.getCharPositionInLine());
    }

    @Override
    public void incompatibleSymbolType(CommonTree t, Type type, CommonTree expression) {
        throw new IncompatibleSymbolTypeParsingException(t.getText(), type,
            expression.getText(), t.getLine(), t.getCharPositionInLine());
    }

    @Override
    public void incompatibleSymbols(CommonTree parentExpression, CommonTree... trees) {
        List<String> symbols = new ArrayList<>(trees.length);
        for (CommonTree commonTree : trees) {
            symbols.add(commonTree.getText());
        }
        throw new IncompatibleSymbolsParsingException(parentExpression.getText(),
            parentExpression.getLine(), parentExpression.getCharPositionInLine(),
            symbols.toArray(new String[symbols.size()]));
    }

    @Override
    public void illegalToken(CommonTree t, String message) {
        throw new IllegalTokenParsingException(t.getText(), t.getLine(),
            t.getCharPositionInLine(), message);
    }

    @Override
    public void recognitionException(RecognitionException e) {
        throw new RecognitionParsingException(e.line, e.charPositionInLine);
    }

    @Override
    public void recognitionException(RecognitionException e, String... tokenNames) {
        throw new RecognitionParsingException(e.line, e.charPositionInLine, tokenNames);
    }

    @Override
    public void rewriteEmptyStreamException(RewriteEmptyStreamException e) {
        throw new RewriteEmptyStreamParsingException(0, 0);
    }

    @Override
    public void reportThrowable(Throwable t, int line, int charPosInLine, int length) {
        throw new ParsingException(line, charPosInLine, t);
    }
}
