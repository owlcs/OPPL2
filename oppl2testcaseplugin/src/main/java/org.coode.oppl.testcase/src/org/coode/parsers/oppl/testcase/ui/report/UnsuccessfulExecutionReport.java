/**
 * 
 */
package org.coode.parsers.oppl.testcase.ui.report;

import org.coode.parsers.oppl.testcase.OPPLTestCase;

/** Represents a partly unsuccessful execution of an OPPLTestCase, i.e.: one when
 * either the configuration failed, or the execution of the query could not
 * terminate because of an internal error was raised, or one of the assertions
 * in the test did.
 * 
 * @author Luigi Iannone */
public abstract class UnsuccessfulExecutionReport extends AbstractReport {
    /** @param opplTestCase */
    public UnsuccessfulExecutionReport(OPPLTestCase opplTestCase) {
        super(opplTestCase);
    }
}
