package org.coode.parsers.oppl.testcase.ui.report;

import static org.coode.oppl.utils.ArgCheck.checkNotNull;

import org.coode.parsers.oppl.testcase.OPPLTestCase;

/**
 * @author Luigi Iannone
 */
public abstract class AbstractReport implements Report {

    private final OPPLTestCase opplTestCase;

    /**
     * @param opplTestCase
     *        opplTestCase
     */
    public AbstractReport(OPPLTestCase opplTestCase) {
        this.opplTestCase = checkNotNull(opplTestCase, "opplTestCase");
    }

    @Override
    public OPPLTestCase getOPPLTestCase() {
        return opplTestCase;
    }
}
