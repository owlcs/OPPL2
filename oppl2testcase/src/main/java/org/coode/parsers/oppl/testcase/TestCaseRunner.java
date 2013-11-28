package org.coode.parsers.oppl.testcase;

import static org.coode.oppl.utils.ArgCheck.checkNotNull;

import java.util.Collections;
import java.util.Set;
import java.util.regex.PatternSyntaxException;

import org.coode.oppl.ExecutionMonitor;
import org.coode.oppl.OPPLScript;
import org.coode.oppl.bindingtree.BindingNode;
import org.coode.oppl.exceptions.RuntimeExceptionHandler;
import org.semanticweb.owlapi.model.OWLRuntimeException;
import org.semanticweb.owlapi.reasoner.OWLReasoner;

/** Abstract component that executes the test case. It runs the query then checks
 * each test. It will fail after the first test fails
 * 
 * @author Luigi Iannone */
public abstract class TestCaseRunner {
    private final OPPLTestCase opplTestCase;
    private final boolean ignoreConfigurationFailure;
    private final ExecutionMonitor executionMonitor;
    private final RuntimeExceptionHandler handler = new RuntimeExceptionHandler() {
        @Override
        public void handlePatternSyntaxExcpetion(PatternSyntaxException e) {
            TestCaseRunner.this.fail(e);
        }

        @Override
        public void handleOWLRuntimeException(OWLRuntimeException e) {
            TestCaseRunner.this.fail(e);
        }

        @Override
        public void handleException(RuntimeException e) {
            TestCaseRunner.this.fail(e);
        }
    };

    /** @param opplTestCase */
    public TestCaseRunner(OPPLTestCase opplTestCase) {
        this(opplTestCase, ExecutionMonitor.NON_CANCELLABLE, false);
    }

    /** @param opplTestCase
     * @param executionMonitor
     * @param ignoreConfigurationFailure */
    public TestCaseRunner(OPPLTestCase opplTestCase, ExecutionMonitor executionMonitor,
            boolean ignoreConfigurationFailure) {
        this.opplTestCase = checkNotNull(opplTestCase, "opplTestCase");
        this.executionMonitor = checkNotNull(executionMonitor, "executionMonitor");
        this.ignoreConfigurationFailure = ignoreConfigurationFailure;
    }

    /** @return the opplTestCase */
    public OPPLTestCase getOPPLTestCase() {
        return opplTestCase;
    }

    /**
     * 
     */
    public final void run() {
        boolean checkConfiguration = checkConfiguration();
        if (ignoresConfigurationFailure() || checkConfiguration) {
            Set<BindingNode> bindings = executeQuery();
            runTests(bindings);
        }
    }

    protected boolean checkConfiguration() {
        OWLReasoner scriptReasoner = getOPPLTestCase().getOPPLScript()
                .getConstraintSystem().getReasoner();
        boolean check = !getOPPLTestCase().requiresInference() || scriptReasoner != null;
        if (!check) {
            configurationFailed("The Test case requires inference, but no reasoner is available to run query");
        }
        return check;
    }

    protected abstract void configurationFailed(String message);

    protected final void runTests(Set<? extends BindingNode> bindings) {
        for (OPPLTest test : getOPPLTestCase().getTests()) {
            runTest(test, bindings);
        }
    }

    protected void runTest(OPPLTest test, Set<? extends BindingNode> bindings) {
        boolean success = test.getAssertion().holds(bindings,
                getOPPLTestCase().getOPPLScript().getConstraintSystem());
        if (success) {
            success(test);
        } else {
            this.fail(test);
        }
    }

    protected abstract void success(OPPLTest test);

    protected abstract void fail(OPPLTest test);

    protected Set<BindingNode> executeQuery() {
        OPPLScript opplScript = getOPPLTestCase().getOPPLScript();
        opplScript.getQuery().execute(getHandler(), getExecutionMonitor());
        Set<BindingNode> leaves = opplScript.getConstraintSystem().getLeaves();
        if (leaves != null) {
            return leaves;
        }
        return Collections.emptySet();
    }

    protected abstract void fail(Throwable e);

    /** @return the ignoreConfigurationFailure */
    public boolean ignoresConfigurationFailure() {
        return ignoreConfigurationFailure;
    }

    /** @return the handler */
    public RuntimeExceptionHandler getHandler() {
        return handler;
    }

    /** @return the executionMonitor */
    public ExecutionMonitor getExecutionMonitor() {
        return executionMonitor;
    }
}
