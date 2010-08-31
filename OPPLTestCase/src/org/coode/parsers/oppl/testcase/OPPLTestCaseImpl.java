/**
 * 
 */
package org.coode.parsers.oppl.testcase;

import java.util.Collection;
import java.util.Formatter;
import java.util.HashSet;
import java.util.Set;

import org.coode.oppl.OPPLScript;

/**
 * @author Luigi Iannone
 * 
 */
public class OPPLTestCaseImpl implements OPPLTestCase {
	private final String name;
	private final OPPLScript opplScript;
	private final boolean requiresInference;
	private final Set<Test> tests = new HashSet<Test>();

	/**
	 * @param name
	 * @param opplScript
	 * @param requiresInference
	 */
	public OPPLTestCaseImpl(String name, OPPLScript opplScript, Collection<? extends Test> tests,
			boolean requiresInference) {
		if (name == null) {
			throw new NullPointerException("The name cannot be null");
		}
		if (opplScript == null) {
			throw new NullPointerException("The OPPL Script cannot be null");
		}
		if (tests == null) {
			throw new NullPointerException("The test collection cannot be null");
		}
		if (!opplScript.getActions().isEmpty()) {
			throw new IllegalArgumentException("No actions allowed in OPPL Test case scripts");
		}
		if (tests.isEmpty()) {
			throw new IllegalArgumentException("There should be at least one test");
		}
		this.name = name;
		this.opplScript = opplScript;
		this.requiresInference = requiresInference;
		this.tests.addAll(tests);
	}

	/**
	 * @see org.coode.parsers.oppl.testcase.OPPLTestCase#getName()
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * @see org.coode.parsers.oppl.testcase.OPPLTestCase#requiresInference()
	 */
	public boolean requiresInference() {
		return this.requiresInference;
	}

	/**
	 * @see org.coode.parsers.oppl.testcase.OPPLTestCase#getOPPLScript()
	 */
	public OPPLScript getOPPLScript() {
		return this.opplScript;
	}

	/**
	 * @see org.coode.parsers.oppl.testcase.OPPLTestCase#getAssertions()
	 */
	public Set<Test> getTests() {
		return new HashSet<Test>(this.tests);
	}

	@Override
	public String toString() {
		Formatter formatter = new Formatter();
		// Grammar rule
		// name SEMICOLON INFERENCE? statement test+
		formatter.format("%s; ", this.getName());
		formatter.format("%s", this.requiresInference() ? "INFERENCE; " : "");
		formatter.format("%s ", this.getOPPLScript());
		for (Test t : this.getTests()) {
			formatter.format("%s ", t);
		}
		return formatter.toString();
	}
}
