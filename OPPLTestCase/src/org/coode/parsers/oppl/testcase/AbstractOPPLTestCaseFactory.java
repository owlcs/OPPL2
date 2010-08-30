/**
 * 
 */
package org.coode.parsers.oppl.testcase;

import org.coode.oppl.OPPLAbstractFactory;
import org.coode.oppl.OPPLScript;

/**
 * @author Luigi Iannone
 * 
 */
public interface AbstractOPPLTestCaseFactory {
	OPPLTestCase buildOPPLTestCase(OPPLScript opplContent);

	OPPLAbstractFactory getOPPLFactory();
}
