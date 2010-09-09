/**
 * 
 */
package org.coode.parsers.oppl.testcase.protege;

import java.util.List;

import org.coode.oppl.OPPLAbstractFactory;
import org.coode.oppl.OPPLScript;
import org.coode.oppl.protege.ProtegeOPPLFactory;
import org.coode.parsers.oppl.testcase.AbstractOPPLTestCaseFactory;
import org.coode.parsers.oppl.testcase.OPPLTestCase;
import org.coode.parsers.oppl.testcase.OPPLTestCaseImpl;
import org.coode.parsers.oppl.testcase.Test;
import org.protege.editor.owl.OWLEditorKit;

/**
 * @author Luigi Iannone
 * 
 */
public class ProtegeOPPLTestCaseFactory implements AbstractOPPLTestCaseFactory {
	private final OWLEditorKit owlEditorKit;

	/**
	 * @param owlEditorKit
	 */
	public ProtegeOPPLTestCaseFactory(OWLEditorKit owlEditorKit) {
		if (owlEditorKit == null) {
			throw new NullPointerException("The OWL editor kit cannot be null");
		}
		this.owlEditorKit = owlEditorKit;
	}

	/**
	 * @see org.coode.parsers.oppl.testcase.AbstractOPPLTestCaseFactory#buildOPPLTestCase
	 *      (java.lang.String, org.coode.oppl.OPPLScript, java.util.List,
	 *      boolean)
	 */
	public OPPLTestCase buildOPPLTestCase(String name, OPPLScript opplContent, List<Test> tests,
			boolean requiresInference) {
		return new OPPLTestCaseImpl(name, opplContent, tests, requiresInference);
	}

	/**
	 * @see org.coode.parsers.oppl.testcase.AbstractOPPLTestCaseFactory#getOPPLFactory
	 *      ()
	 */
	public OPPLAbstractFactory getOPPLFactory() {
		return new ProtegeOPPLFactory(this.getOWLEditorKit());
	}

	/**
	 * @return the owlEditorKit
	 */
	public OWLEditorKit getOWLEditorKit() {
		return this.owlEditorKit;
	}
}
