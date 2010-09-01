/**
 * 
 */
package org.coode.parsers.oppl.testcase;

import java.util.HashSet;
import java.util.Set;

import org.coode.oppl.OPPLScript;
import org.coode.oppl.bindingtree.BindingNode;
import org.coode.oppl.exceptions.OPPLException;
import org.semanticweb.owlapi.reasoner.OWLReasoner;

/**
 * Abstract component that executes the test case. It runs the query then checks
 * each test. It will fail after the first test fails
 * 
 * @author Luigi Iannone
 * 
 */
public abstract class TestCaseRunner {
	private final OPPLTestCase opplTestCase;
	private final boolean ignoreConfigurationFailure;

	public TestCaseRunner(OPPLTestCase opplTestCase) {
		this(opplTestCase, false);
	}

	/**
	 * @param opplTestCase
	 */
	public TestCaseRunner(OPPLTestCase opplTestCase,
			boolean ignoreConfigurationFailure) {
		if (opplTestCase == null) {
			throw new NullPointerException("The OPPL Test case cannot be null");
		}
		this.opplTestCase = opplTestCase;
		this.ignoreConfigurationFailure = ignoreConfigurationFailure;
	}

	/**
	 * @return the opplTestCase
	 */
	public OPPLTestCase getOPPLTestCase() {
		return this.opplTestCase;
	}

	public final void run() {
		boolean checkConfiguration = this.checkConfiguration();
		if (this.ignoresConfigurationFailure() || checkConfiguration) {
			Set<BindingNode> bindings = this.executeQuery();
			this.runTests(bindings);
		}
	}

	protected boolean checkConfiguration() {
		OWLReasoner scriptReasoner = this.getOPPLTestCase().getOPPLScript()
				.getConstraintSystem().getReasoner();
		boolean check = !this.getOPPLTestCase().requiresInference()
				|| scriptReasoner != null;
		if (!check) {
			this
					.configurationFailed("The Test case requires inference, but no reasoner is available to run query");
		}
		return check;
	}

	protected abstract void configurationFailed(String message);

	protected final void runTests(Set<? extends BindingNode> bindings) {
		for (Test test : this.getOPPLTestCase().getTests()) {
			this.runTest(test, bindings);
		}
	}

	protected void runTest(Test test, Set<? extends BindingNode> bindings) {
		boolean success = test.getAssertion().holds(bindings,
				this.getOPPLTestCase().getOPPLScript().getConstraintSystem());
		if (success) {
			this.success(test);
		} else {
			this.fail(test);
		}
	}

	protected abstract void success(Test test);

	protected abstract void fail(Test test);

	protected Set<BindingNode> executeQuery() {
		Set<BindingNode> toReturn = new HashSet<BindingNode>();
		try {
			OPPLScript opplScript = this.getOPPLTestCase().getOPPLScript();
			opplScript.getQuery().execute();
			Set<BindingNode> leaves = opplScript.getConstraintSystem()
					.getLeaves();
			if (leaves != null) {
				toReturn = new HashSet<BindingNode>(leaves);
			}
		} catch (OPPLException e) {
			this.fail(e);
		}
		return toReturn;
	}

	protected abstract void fail(Throwable e);

	/**
	 * @return the ignoreConfigurationFailure
	 */
	public boolean ignoresConfigurationFailure() {
		return this.ignoreConfigurationFailure;
	}
}
