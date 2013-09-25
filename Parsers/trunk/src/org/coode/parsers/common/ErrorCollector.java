/**
 * 
 */
package org.coode.parsers.common;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.RewriteEmptyStreamException;
import org.coode.parsers.ErrorListener;
import org.coode.parsers.Type;
import org.coode.parsers.common.exception.IllegalTokenParsingException;
import org.coode.parsers.common.exception.IncompatibleSymbolTypeParsingException;
import org.coode.parsers.common.exception.IncompatibleSymbolsParsingException;
import org.coode.parsers.common.exception.ParsingException;
import org.coode.parsers.common.exception.RecognitionParsingException;
import org.coode.parsers.common.exception.RewriteEmptyStreamParsingException;
import org.coode.parsers.common.exception.UnrecognisedSymbolParsingException;

/** @author Luigi Iannone */
public class ErrorCollector implements ErrorListener {
    private final Set<Throwable> errors = new HashSet<Throwable>();

    @Override
    public void unrecognisedSymbol(CommonTree t) {
        errors.add(new UnrecognisedSymbolParsingException(t.getText(), t.getLine(), t
                .getCharPositionInLine()));
    }

    @Override
    public void incompatibleSymbolType(CommonTree t, Type type, CommonTree expression) {
        errors.add(new IncompatibleSymbolTypeParsingException(t.getText(), type,
                expression.getText(), t.getLine(), t.getCharPositionInLine()));
    }

    @Override
    public void incompatibleSymbols(CommonTree parentExpression, CommonTree... trees) {
        List<String> symbols = new ArrayList<String>(trees.length);
        for (CommonTree commonTree : trees) {
            symbols.add(commonTree.getText());
        }
        errors.add(new IncompatibleSymbolsParsingException(parentExpression.getText(),
                parentExpression.getLine(), parentExpression.getCharPositionInLine(),
                symbols.toArray(new String[symbols.size()])));
    }

    @Override
    public void illegalToken(CommonTree t, String message) {
        errors.add(new IllegalTokenParsingException(t.getText(), t.getLine(), t
                .getCharPositionInLine(), message));
    }

    @Override
    public void recognitionException(RecognitionException e) {
        errors.add(new RecognitionParsingException(e.line, e.charPositionInLine));
    }

    @Override
    public void recognitionException(RecognitionException e, String... tokenNames) {
        errors.add(new RecognitionParsingException(e.line, e.charPositionInLine,
                tokenNames));
    }

    @Override
    public void rewriteEmptyStreamException(RewriteEmptyStreamException e) {
        errors.add(new RewriteEmptyStreamParsingException(0, 0));
    }

    @Override
    public void reportThrowable(Throwable t, int line, int charPosInLine, int length) {
        errors.add(new ParsingException(line, charPosInLine, t));
    }

    /** @return the errors */
    public Set<Throwable> getErrors() {
        return new HashSet<Throwable>(errors);
    }
}
