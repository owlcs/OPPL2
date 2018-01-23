package org.coode.parsers.oppl.testcase.junittest;

import static org.coode.oppl.testcaseontologies.TestCaseTestOntologies.pizza;

import java.util.regex.PatternSyntaxException;

import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.RewriteEmptyStreamException;
import org.coode.oppl.exceptions.RuntimeExceptionHandler;
import org.coode.parsers.ErrorListener;
import org.coode.parsers.Type;
import org.coode.parsers.oppl.testcase.JUnitTestCaseRunner;
import org.coode.parsers.oppl.testcase.OPPLTest;
import org.coode.parsers.oppl.testcase.OPPLTestCase;
import org.coode.parsers.oppl.testcase.OPPLTestCaseParser;
import org.coode.parsers.oppl.testcase.ParserFactory;
import org.coode.parsers.oppl.testcase.TestCaseRunner;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.semanticweb.owlapi.model.OWLRuntimeException;
import org.semanticweb.owlapi.reasoner.OWLReasoner;

import uk.ac.manchester.cs.jfact.JFactFactory;

@SuppressWarnings("javadoc")
public class OPPLTestCaseRunnerTest {

    private final class JunitConfigShouldFailTestCaseRunner extends TestCaseRunner {

        /**
         * @param opplTestCase
         */
        public JunitConfigShouldFailTestCaseRunner(OPPLTestCase opplTestCase) {
            super(opplTestCase);
        }

        @Override
        protected void fail(OPPLTest test) {
            Assert.fail(
                "The configuration should fail and the tests should not be carried out, but they have been instead ");
        }

        @Override
        protected void configurationFailed(String message) {}

        @Override
        protected void fail(Throwable e) {
            Assert.fail(
                "The configuration should fail and the query  should not be carried out, but it has and an exception was raised in the process "
                    + e.getMessage());
        }

        @Override
        protected void success(OPPLTest test) {
            Assert.fail(
                "The configuration should fail and the tests should not be carried out, but they have been instead ");
        }
    }

    private final class JunitShouldFailTestCaseRunner extends TestCaseRunner {

        /**
         * @param opplTestCase
         */
        public JunitShouldFailTestCaseRunner(OPPLTestCase opplTestCase) {
            super(opplTestCase);
        }

        @Override
        protected void fail(OPPLTest test) {}

        @Override
        protected void configurationFailed(String message) {
            Assert.fail(
                "The configuration should be fine, it fails instead with the following message: "
                    + message);
        }

        @Override
        protected void fail(Throwable e) {}

        @Override
        protected void success(OPPLTest test) {
            Assert.fail("Test " + test + " sould fail; it succeded instead");
        }
    }

    static final ErrorListener ERROR_LISTENER = new ErrorListener() {

        @Override
        public void unrecognisedSymbol(CommonTree t) {
            throw new RuntimeException(t.toString());
        }

        @Override
        public void incompatibleSymbolType(CommonTree t, Type type, CommonTree expression) {
            throw new RuntimeException(t.toString());
        }

        @Override
        public void incompatibleSymbols(CommonTree parentExpression, CommonTree... trees) {
            throw new RuntimeException(parentExpression.toString());
        }

        @Override
        public void illegalToken(CommonTree t, String message) {
            throw new RuntimeException(t.toString());
        }

        @Override
        public void recognitionException(RecognitionException e) {
            throw new RuntimeException(e);
        }

        @Override
        public void recognitionException(RecognitionException e, String... tokenNames) {
            throw new RuntimeException(e);
        }

        @Override
        public void rewriteEmptyStreamException(RewriteEmptyStreamException e) {
            throw new RuntimeException(e);
        }

        @Override
        public void reportThrowable(Throwable t, int line, int charPosInLine, int length) {
            throw new RuntimeException(t);
        }
    };
    private static final RuntimeExceptionHandler HANDLER = new RuntimeExceptionHandler() {

        @Override
        public void handlePatternSyntaxExcpetion(PatternSyntaxException e) {
            ERROR_LISTENER.reportThrowable(e, 0, 0, 0);
        }

        @Override
        public void handleOWLRuntimeException(OWLRuntimeException e) {
            ERROR_LISTENER.reportThrowable(e, 0, 0, 0);
        }

        @Override
        public void handleException(RuntimeException e) {
            ERROR_LISTENER.reportThrowable(e, 0, 0, 0);
        }
    };

    @Test
    public void shouldTestCount() {
        String testCase =
            "testOneAssertion; ?x:CLASS SELECT ?x subClassOf Pizza ASSERT count(?x) = 1; ?x count is not 1;";
        ParserFactory parserFactory = new ParserFactory(pizza, pizza.getOWLOntologyManager());
        OPPLTestCaseParser parser = parserFactory.build(ERROR_LISTENER);
        OPPLTestCase opplTestCase = parser.parse(testCase, HANDLER);
        this.runTestCase(opplTestCase);
    }

    @Ignore
    @Test
    public void shouldTestCountInference() {
        String testCase =
            "testOneAssertion; INFERENCE; ?x:CLASS SELECT ?x subClassOf InterestingPizza WHERE ?x!=InterestingPizza, FAIL ?x equivalentTo Nothing  ASSERT count(?x) = 20; ?x count is not 20;";
        JFactFactory reasonerFactory = new JFactFactory();
        OWLReasoner reasoner = reasonerFactory.createReasoner(pizza);
        pizza.classesInSignature().filter(c -> c.getIRI().toString().contains("Interesting"))
            .forEach(c -> System.out.println(c + " " + reasoner.getSubClasses(c, true)));
        ParserFactory parserFactory =
            new ParserFactory(pizza, pizza.getOWLOntologyManager(), reasoner);
        OPPLTestCaseParser parser = parserFactory.build(ERROR_LISTENER);
        OPPLTestCase opplTestCase = parser.parse(testCase, HANDLER);
        this.runTestCase(opplTestCase);
    }

    @Test
    public void shouldTestCountShouldFail() {
        String testCase =
            "testOneAssertion; ?x:CLASS SELECT ?x subClassOf Pizza ASSERT count(?x) != 1; ?x count is 1;";
        ParserFactory parserFactory = new ParserFactory(pizza, pizza.getOWLOntologyManager());
        OPPLTestCaseParser parser = parserFactory.build(ERROR_LISTENER);
        OPPLTestCase opplTestCase = parser.parse(testCase, HANDLER);
        this.runTestCase(opplTestCase, false);
    }

    @Test
    public void shouldTestConfigurationNotOK() {
        String testCase =
            "testOneAssertion; INFERENCE; ?x:CLASS SELECT ?x subClassOf Pizza ASSERT count(?x) != 1; ?x count is 1;";
        ParserFactory parserFactory = new ParserFactory(pizza, pizza.getOWLOntologyManager());
        OPPLTestCaseParser parser = parserFactory.build(ERROR_LISTENER);
        OPPLTestCase opplTestCase = parser.parse(testCase, HANDLER);
        TestCaseRunner runner = new JunitConfigShouldFailTestCaseRunner(opplTestCase);
        runner.run();
    }

    private void runTestCase(OPPLTestCase opplTestCase) {
        this.runTestCase(opplTestCase, true);
    }

    /**
     * @param opplTestCase
     */
    private void runTestCase(OPPLTestCase opplTestCase, boolean shouldSucceed) {
        TestCaseRunner runner = shouldSucceed ? new JUnitTestCaseRunner(opplTestCase)
            : new JunitShouldFailTestCaseRunner(opplTestCase);
        runner.run();
    }
}
