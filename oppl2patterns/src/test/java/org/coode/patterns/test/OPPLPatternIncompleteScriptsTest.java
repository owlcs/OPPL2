/**
 * 
 */
package org.coode.patterns.test;

import static org.coode.oppl.patterntestontologies.PatternTestOntologies.test;

import org.junit.Test;

/** @author Luigi Iannone */
@SuppressWarnings("javadoc")
public class OPPLPatternIncompleteScriptsTest extends AbstractPatternTestCase {
    @Test
    public void shouldTestJustVariableDefinition() {
        String script = "?X:CLASS";
        parseWrong(script, test, new AbstractExpectedErrorCheckerErrorListener());
    }
}
