/**
 * 
 */
package org.coode.parsers.test;

import java.util.Arrays;

import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.RewriteEmptyStreamException;
import org.coode.parsers.ErrorListener;
import org.coode.parsers.Type;

/** Extends this to check a particular error is expected. Override the method(s)
 * corresponding to the expected error(s).
 * 
 * @author Luigi Iannone */
@SuppressWarnings("javadoc")
public abstract class AbstractExpectedErrorCheckerErrorListener implements ErrorListener {
    private final ErrorCheckerCallBack errorChecker;

    public AbstractExpectedErrorCheckerErrorListener(ErrorCheckerCallBack errorChecker) {
        if (errorChecker == null) {
            throw new NullPointerException("The error checker cannot be null");
        }
        this.errorChecker = errorChecker;
    }

    @Override
    public void unrecognisedSymbol(CommonTree t) {
        getErrorChecker().unexpectedError("Unexpected unrecognised symbol on token " + t);
    }

    @Override
    public void incompatibleSymbolType(CommonTree t, Type type, CommonTree expression) {
        getErrorChecker().unexpectedError(
                String.format(
                        "Unexpected incompatible symbol for token %s type %s inside %s",
                        t, type, expression));
    }

    @Override
    public void incompatibleSymbols(CommonTree parentExpression, CommonTree... trees) {
        getErrorChecker().unexpectedError(
                String.format("Unexpected incompatible symbols  inside %s [%s]",
                        parentExpression, Arrays.toString(trees)));
    }

    @Override
    public void illegalToken(CommonTree t, String message) {
        getErrorChecker().unexpectedError(
                String.format("Unexpected illegal token for token %s type message %s", t,
                        message));
    }

    @Override
    public void recognitionException(RecognitionException e) {
        getErrorChecker().unexpectedError(
                String.format("Unexpected recognition exception message %s",
                        e.getMessage()));
    }

    @Override
    public void recognitionException(RecognitionException e, String... tokenNames) {
        getErrorChecker().unexpectedError(Arrays.toString(tokenNames));
    }

    @Override
    public void rewriteEmptyStreamException(RewriteEmptyStreamException e) {
        getErrorChecker().unexpectedError(
                String.format("Unexpected rewrite empty stream exception %s",
                        e.getMessage()));
    }

    @Override
    public void reportThrowable(Throwable t, int line, int charPosInLine, int length) {
        getErrorChecker().unexpectedError(
                String.format(
                        "Unexpected  exception %s at line %d position %d length %d",
                        t.getMessage(), line, charPosInLine, length));
    }

    /** @return the errorChecker */
    public ErrorCheckerCallBack getErrorChecker() {
        return errorChecker;
    }

    public static ErrorListener getIllegalTokenExpected(
            final ErrorCheckerCallBack errorChecker) {
        return new AbstractExpectedErrorCheckerErrorListener(errorChecker) {
            @Override
            public void illegalToken(CommonTree t, String message) {
                errorChecker.getErrorListenerForExpectedError().illegalToken(t, message);
            }
        };
    }

    public static ErrorListener getIncompatibleSymbols(
            final ErrorCheckerCallBack errorChecker) {
        return new AbstractExpectedErrorCheckerErrorListener(errorChecker) {
            @Override
            public void incompatibleSymbols(CommonTree parentExpression,
                    CommonTree... trees) {
                errorChecker.getErrorListenerForExpectedError().incompatibleSymbols(
                        parentExpression, trees);
            }
        };
    }

    public static ErrorListener getIncompatibleSymbolType(
            final ErrorCheckerCallBack errorChecker) {
        return new AbstractExpectedErrorCheckerErrorListener(errorChecker) {
            @Override
            public void incompatibleSymbolType(CommonTree t, Type type,
                    CommonTree expression) {
                errorChecker.getErrorListenerForExpectedError().incompatibleSymbolType(t,
                        type, expression);
            }
        };
    }

    public static ErrorListener getRecognitionException(
            final ErrorCheckerCallBack errorChecker) {
        return new AbstractExpectedErrorCheckerErrorListener(errorChecker) {
            @Override
            public void recognitionException(RecognitionException e) {
                errorChecker.getErrorListenerForExpectedError().recognitionException(e);
            }
        };
    }

    public static ErrorListener getRecognitionExceptionWithTokens(
            final ErrorCheckerCallBack errorChecker) {
        return new AbstractExpectedErrorCheckerErrorListener(errorChecker) {
            @Override
            public void
                    recognitionException(RecognitionException e, String... tokenNames) {
                errorChecker.getErrorListenerForExpectedError().recognitionException(e,
                        tokenNames);
            }
        };
    }

    public static ErrorListener
            getReportThrowable(final ErrorCheckerCallBack errorChecker) {
        return new AbstractExpectedErrorCheckerErrorListener(errorChecker) {
            @Override
            public void reportThrowable(Throwable t, int line, int charPosInLine,
                    int length) {
                errorChecker.getErrorListenerForExpectedError().reportThrowable(t, line,
                        charPosInLine, length);
            }
        };
    }

    public static ErrorListener getRewriteEmptyStreamException(
            final ErrorCheckerCallBack errorChecker) {
        return new AbstractExpectedErrorCheckerErrorListener(errorChecker) {
            @Override
            public void rewriteEmptyStreamException(RewriteEmptyStreamException e) {
                errorChecker.getErrorListenerForExpectedError()
                        .rewriteEmptyStreamException(e);
            }
        };
    }

    public static ErrorListener getUnrecognisedSymbol(
            final ErrorCheckerCallBack errorChecker) {
        return new AbstractExpectedErrorCheckerErrorListener(errorChecker) {
            @Override
            public void unrecognisedSymbol(CommonTree t) {
                errorChecker.getErrorListenerForExpectedError().unrecognisedSymbol(t);
            }
        };
    }
}
