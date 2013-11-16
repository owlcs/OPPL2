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

    /** @see org.coode.parsers.oppl.testcase.TestCaseRunner#fail(org.coode.parsers.oppl.testcase.OPPLTest) */
    @Override
    protected void fail(OPPLTest test) {
        String message = test.getMessage();
        if (message != OPPLTest.NO_MESSAGE) {
            Assert.fail(test.getMessage());
        } else {
            Assert.fail();
        }
    }

    /** @see org.coode.parsers.oppl.testcase.TestCaseRunner#fail(java.lang.Throwable) */
    @Override
    protected void fail(Throwable e) {
        Assert.fail(e.getMessage());
    }

    /** @see org.coode.parsers.oppl.testcase.TestCaseRunner#success(org.coode.parsers
     *      .oppl.testcase.OPPLTest) */
    @Override
    protected void success(OPPLTest test) {}

    @Override
    protected void configurationFailed(String message) {
        Assert.fail(message);
    }
}
