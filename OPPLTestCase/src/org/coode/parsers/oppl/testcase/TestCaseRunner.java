/**
 * 
 */
package org.coode.parsers.oppl.testcase;

import java.util.HashSet;
import java.util.Set;

import org.coode.oppl.OPPLScript;
import org.coode.oppl.bindingtree.BindingNode;
import org.coode.oppl.exceptions.OPPLException;

/**
 * Abstract component that executes the test case. It runs the query then checks
 * each test. It will fail after the first test fails
 * 
 * @author Luigi Iannone
 * 
 */
public abstract class TestCaseRunner {
	private final OPPLTestCase opplTestCase;

	/**
	 * @param opplTestCase
	 */
	public TestCaseRunner(OPPLTestCase opplTestCase) {
		if (opplTestCase == null) {
			throw new NullPointerException("The OPPL Test case cannot be null");
		}
		this.opplTestCase = opplTestCase;
	}

	/**
	 * @return the opplTestCase
	 */
	public OPPLTestCase getOPPLTestCase() {
		return this.opplTestCase;
	}

	public final void run() {
		Set<BindingNode> bindings = this.executeQuery();
		this.runTests(bindings);
	}

	protected final void runTests(Set<? extends BindingNode> bindings) {
		for (Test test : this.getOPPLTestCase().getTests()) {
			this.runTest(test, bindings);
		}
	}

	protected void runTest(Test test, Set<? extends BindingNode> bindings) {
	}

	protected Set<BindingNode> executeQuery() {
		Set<BindingNode> toReturn = new HashSet<BindingNode>();
		try {
			OPPLScript opplScript = this.getOPPLTestCase().getOPPLScript();
			opplScript.getQuery().execute();
			Set<BindingNode> leaves = opplScript.getConstraintSystem().getLeaves();
			if (leaves != null) {
				toReturn = new HashSet<BindingNode>(leaves);
			}
		} catch (OPPLException e) {
			this.fail(e);
		}
		return toReturn;
	}

	protected abstract void fail(Throwable e);
}
