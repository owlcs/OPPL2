/**
 * 
 */
package org.coode.parsers.oppl.testcase;

import org.junit.Assert;

/** @author Luigi Iannone */
public class JUnitTestCaseRunner extends TestCaseRunner {
    /** @param opplTestCase */
    public JUnitTestCaseRunner(OPPLTestCase opplTestCase) {
        super(opplTestCase);
    }

    @Override
    protected void fail(OPPLTest test) {
        String message = test.getMessage();
        if (message != OPPLTest.NO_MESSAGE) {
            Assert.fail(test.getMessage());
        } else {
            Assert.fail();
        }
    }

    @Override
    protected void fail(Throwable e) {
        Assert.fail(e.getMessage());
    }

    @Override
    protected void success(OPPLTest test) {}

    @Override
    protected void configurationFailed(String message) {
        Assert.fail(message);
    }
}
