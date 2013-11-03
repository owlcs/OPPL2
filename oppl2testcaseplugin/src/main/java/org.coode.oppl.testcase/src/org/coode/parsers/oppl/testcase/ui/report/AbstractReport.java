/**
 * 
 */
package org.coode.parsers.oppl.testcase.ui.report;

import org.coode.parsers.oppl.testcase.OPPLTestCase;

/**
 * 
 * @author Luigi Iannone
 * 
 */
public abstract class AbstractReport implements Report {
	private final OPPLTestCase opplTestCase;

	/**
	 * @param opplTestCase
	 */
	public AbstractReport(OPPLTestCase opplTestCase) {
		if (opplTestCase == null) {
			throw new NullPointerException("The OPPL test case cannot be null");
		}
		this.opplTestCase = opplTestCase;
	}

	/**
	 * @see org.coode.parsers.oppl.testcase.ui.report.Report#getOPPLTestCase()
	 */
	public OPPLTestCase getOPPLTestCase() {
		return this.opplTestCase;
	}
}
