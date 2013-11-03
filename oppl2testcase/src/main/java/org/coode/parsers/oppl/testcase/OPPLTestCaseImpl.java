/**
 * 
 */
package org.coode.parsers.oppl.testcase;

import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;

import org.coode.oppl.OPPLScript;

/**
 * @author Luigi Iannone
 * 
 */
public class OPPLTestCaseImpl implements OPPLTestCase {
	private final String name;
	private final OPPLScript opplScript;
	private final boolean requiresInference;
	private final List<OPPLTest> tests = new ArrayList<OPPLTest>();

	/**
	 * @param name
	 * @param opplScript
	 * @param requiresInference
	 */
	public OPPLTestCaseImpl(String name, OPPLScript opplScript,
			List<? extends OPPLTest> tests, boolean requiresInference) {
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
			throw new IllegalArgumentException(
					"No actions allowed in OPPL Test case scripts");
		}
		if (tests.isEmpty()) {
			throw new IllegalArgumentException(
					"There should be at least one test");
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
	public List<OPPLTest> getTests() {
		return new ArrayList<OPPLTest>(this.tests);
	}

	@Override
	public String toString() {
		Formatter formatter = new Formatter();
		// Grammar rule
		// name SEMICOLON INFERENCE? statement test+
		formatter.format("%s; ", this.getName());
		formatter.format("%s", this.requiresInference() ? "INFERENCE; " : "");
		formatter.format("%s ", this.getOPPLScript());
		for (OPPLTest t : this.getTests()) {
			formatter.format("%s ", t);
		}
		return formatter.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ (this.name == null ? 0 : this.name.hashCode());
		result = prime * result
				+ (this.opplScript == null ? 0 : this.opplScript.hashCode());
		result = prime * result + (this.requiresInference ? 1231 : 1237);
		result = prime * result
				+ (this.tests == null ? 0 : this.tests.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (this.getClass() != obj.getClass()) {
			return false;
		}
		OPPLTestCaseImpl other = (OPPLTestCaseImpl) obj;
		if (this.name == null) {
			if (other.name != null) {
				return false;
			}
		} else if (!this.name.equals(other.name)) {
			return false;
		}
		if (this.opplScript == null) {
			if (other.opplScript != null) {
				return false;
			}
		} else if (!this.opplScript.equals(other.opplScript)) {
			return false;
		}
		if (this.requiresInference != other.requiresInference) {
			return false;
		}
		if (this.tests == null) {
			if (other.tests != null) {
				return false;
			}
		} else if (!this.tests.equals(other.tests)) {
			return false;
		}
		return true;
	}
}
