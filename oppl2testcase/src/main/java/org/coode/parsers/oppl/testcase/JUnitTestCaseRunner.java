/**
 * 
 */
package org.coode.parsers.oppl.testcase;

import junit.framework.TestCase;

/**
 * @author Luigi Iannone
 * 
 */
public class JUnitTestCaseRunner extends TestCaseRunner {
	/**
	 * @param opplTestCase
	 */
	public JUnitTestCaseRunner(OPPLTestCase opplTestCase) {
		super(opplTestCase);
	}

	/**
	 * @see org.coode.parsers.oppl.testcase.TestCaseRunner#fail(org.coode.parsers.oppl.testcase.OPPLTest)
	 */
	@Override
	protected void fail(OPPLTest test) {
		String message = test.getMessage();
		if (message != OPPLTest.NO_MESSAGE) {
			TestCase.fail(test.getMessage());
		} else {
			TestCase.fail();
		}
	}

	/**
	 * @see org.coode.parsers.oppl.testcase.TestCaseRunner#fail(java.lang.Throwable)
	 */
	@Override
	protected void fail(Throwable e) {
		TestCase.fail(e.getMessage());
	}

	/**
	 * @see org.coode.parsers.oppl.testcase.TestCaseRunner#success(org.coode.parsers
	 *      .oppl.testcase.OPPLTest)
	 */
	@Override
	protected void success(OPPLTest test) {
	}

	@Override
	protected void configurationFailed(String message) {
		TestCase.fail(message);
	}
}
