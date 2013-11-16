/**
 * 
 */
package org.coode.patterns.test;

import static org.coode.oppl.patterntestontologies.PatternTestOntologies.test;

import org.coode.parsers.ErrorListener;
import org.coode.parsers.common.SystemErrorEcho;

/** @author Luigi Iannone */
public class OPPLPatternIncompleteScriptsTest extends AbstractPatternTestCase {
    private final static ErrorListener JUNITERR_ERROR_LISTENER = new SystemErrorEcho();

    public void testJustVariableDefinition() {
        String script = "?X:CLASS";
        parseWrong(script, test, new AbstractExpectedErrorCheckerErrorListener());
    }
}
