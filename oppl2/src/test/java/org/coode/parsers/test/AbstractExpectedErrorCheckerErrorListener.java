/**
 * 
 */
package org.coode.parsers.test;

import java.util.Formatter;
import java.util.Locale;

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
        StringBuilder out = new StringBuilder();
        Formatter formatter = new Formatter(out, Locale.getDefault());
        formatter.format("Unexpected incompatible symbol for token %s type %s inside %s",
                t, type, expression);
        String errorMessage = out.toString();
        getErrorChecker().unexpectedError(errorMessage);
    }

    @Override
    public void incompatibleSymbols(CommonTree parentExpression, CommonTree... trees) {
        StringBuilder out = new StringBuilder();
        Formatter formatter = new Formatter(out, Locale.getDefault());
        formatter
                .format("Unexpected incompatible symbols  inside %s [", parentExpression);
        for (CommonTree commonTree : trees) {
            formatter.format("%s ", commonTree);
        }
        formatter.format("]");
        String errorMessage = out.toString();
        getErrorChecker().unexpectedError(errorMessage);
    }

    @Override
    public void illegalToken(CommonTree t, String message) {
        StringBuilder out = new StringBuilder();
        Formatter formatter = new Formatter(out, Locale.getDefault());
        formatter.format("Unexpected illegal token for token %s type message %s", t,
                message);
        String errorMessage = out.toString();
        getErrorChecker().unexpectedError(errorMessage);
    }

    @Override
    public void recognitionException(RecognitionException e) {
        StringBuilder out = new StringBuilder();
        Formatter formatter = new Formatter(out, Locale.getDefault());
        formatter.format("Unexpected recognition exception message %s", e.getMessage());
        String errorMessage = out.toString();
        getErrorChecker().unexpectedError(errorMessage);
    }

    @Override
    public void recognitionException(RecognitionException e, String... tokenNames) {
        StringBuilder out = new StringBuilder();
        Formatter formatter = new Formatter(out, Locale.getDefault());
        formatter.format("Unexpected recognition exception message %s", e.getMessage());
        for (String s : tokenNames) {
            formatter.format("%s ", s);
        }
        formatter.format("]");
        String errorMessage = out.toString();
        getErrorChecker().unexpectedError(errorMessage);
    }

    @Override
    public void rewriteEmptyStreamException(RewriteEmptyStreamException e) {
        StringBuilder out = new StringBuilder();
        Formatter formatter = new Formatter(out, Locale.getDefault());
        formatter.format("Unexpected rewrite empty stream exception %s", e.getMessage());
        String errorMessage = out.toString();
        getErrorChecker().unexpectedError(errorMessage);
    }

    @Override
    public void reportThrowable(Throwable t, int line, int charPosInLine, int length) {
        StringBuilder out = new StringBuilder();
        Formatter formatter = new Formatter(out, Locale.getDefault());
        formatter.format("Unexpected  exception %s at line %d position %d length %d",
                t.getMessage(), line, charPosInLine, length);
        String errorMessage = out.toString();
        getErrorChecker().unexpectedError(errorMessage);
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
