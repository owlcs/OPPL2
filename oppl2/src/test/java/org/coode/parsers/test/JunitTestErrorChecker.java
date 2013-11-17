/**
 * 
 */
package org.coode.parsers.test;

import static org.junit.Assert.fail;

import org.coode.parsers.ErrorListener;

/** Convenience JUnit ErrorChecke. Just fails when an unexpected error is raised
 * 
 * @author Luigi Iannone */
public class JunitTestErrorChecker implements ErrorCheckerCallBack {
    private final ErrorListener expectedErrorListener;

    public JunitTestErrorChecker(ErrorListener expectedErrorListener) {
        if (expectedErrorListener == null) {
            throw new NullPointerException("The expected error listener cannot be null");
        }
        this.expectedErrorListener = expectedErrorListener;
    }

    @Override
    public void unexpectedError(String errorMessage) {
        fail(errorMessage);
    }

    @Override
    public ErrorListener getErrorListenerForExpectedError() {
        return expectedErrorListener;
    }
}
