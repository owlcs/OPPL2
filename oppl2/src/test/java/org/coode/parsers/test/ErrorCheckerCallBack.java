/**
 * 
 */
package org.coode.parsers.test;

import org.coode.parsers.ErrorListener;

/** @author Luigi Iannone */
public interface ErrorCheckerCallBack {
    void unexpectedError(String errorMessage);

    ErrorListener getErrorListenerForExpectedError();
}
