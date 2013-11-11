/**
 * 
 */
package org.coode.patterns.test;

import static org.coode.oppl.test.Ontologies.test;

import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.tree.RewriteEmptyStreamException;
import org.coode.parsers.ErrorListener;
import org.coode.parsers.common.SystemErrorEcho;
import org.coode.parsers.test.AbstractExpectedErrorCheckerErrorListener;
import org.coode.parsers.test.JunitTestErrorChecker;

/** @author Luigi Iannone */
public class OPPLPatternIncompleteScriptsTest extends AbstractPatternTestCase {
    private final static ErrorListener JUNITERR_ERROR_LISTENER = new SystemErrorEcho();

    public void testJustVariableDefinition() {
        String script = "?X:CLASS";
        parseWrong(script, test, new AbstractExpectedErrorCheckerErrorListener(
                new JunitTestErrorChecker(JUNITERR_ERROR_LISTENER)) {
            @Override
            public void rewriteEmptyStreamException(RewriteEmptyStreamException e) {
                getErrorChecker().getErrorListenerForExpectedError()
                        .rewriteEmptyStreamException(e);
            }

            @Override
            public void recognitionException(RecognitionException e) {
                getErrorChecker().getErrorListenerForExpectedError()
                        .recognitionException(e);
            }
        });
    }
}
