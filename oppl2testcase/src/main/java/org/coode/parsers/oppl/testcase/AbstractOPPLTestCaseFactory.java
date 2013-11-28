package org.coode.parsers.oppl.testcase;

import java.util.List;

import org.coode.oppl.OPPLAbstractFactory;
import org.coode.oppl.OPPLScript;

/** @author Luigi Iannone */
public interface AbstractOPPLTestCaseFactory {
    /** @param name
     * @param opplContent
     * @param tests
     * @param requiresInference
     * @return oppl test case */
    OPPLTestCase buildOPPLTestCase(String name, OPPLScript opplContent,
            List<? extends OPPLTest> tests, boolean requiresInference);

    /** @return oppl factory */
    OPPLAbstractFactory getOPPLFactory();
}
