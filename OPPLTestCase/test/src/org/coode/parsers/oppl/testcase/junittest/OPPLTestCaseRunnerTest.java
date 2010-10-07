package org.coode.parsers.oppl.testcase.junittest;

import junit.framework.TestCase;

import org.coode.parsers.ErrorListener;
import org.coode.parsers.oppl.testcase.JUnitTestCaseRunner;
import org.coode.parsers.oppl.testcase.OPPLTestCase;
import org.coode.parsers.oppl.testcase.OPPLTestCaseParser;
import org.coode.parsers.oppl.testcase.ParserFactory;
import org.coode.parsers.oppl.testcase.Test;
import org.coode.parsers.oppl.testcase.TestCaseRunner;
import org.coode.parsers.test.JUnitTestErrorListener;
import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;
import org.semanticweb.owlapi.model.OWLOntologyManager;
import org.semanticweb.owlapi.reasoner.OWLReasoner;

import uk.ac.manchester.cs.factplusplus.owlapiv3.FaCTPlusPlusReasonerFactory;

public class OPPLTestCaseRunnerTest extends TestCase {
	private final class JunitConfigShouldFailTestCaseRunner extends
			TestCaseRunner {
		/**
		 * @param opplTestCase
		 */
		public JunitConfigShouldFailTestCaseRunner(OPPLTestCase opplTestCase) {
			super(opplTestCase);
		}

		/**
		 * @see org.coode.parsers.oppl.testcase.TestCaseRunner#fail(org.coode.parsers.oppl.testcase.Test)
		 */
		@Override
		protected void fail(Test test) {
			TestCase
					.fail("The configuration should fail and the tests should not be carried out, but they have been instead ");
		}

		@Override
		protected void configurationFailed(String message) {
		}

		/**
		 * @see org.coode.parsers.oppl.testcase.TestCaseRunner#fail(java.lang.Throwable)
		 */
		@Override
		protected void fail(Throwable e) {
			TestCase
					.fail("The configuration should fail and the query  should not be carried out, but it has and an exception was raised in the process "
							+ e.getMessage());
		}

		/**
		 * @see org.coode.parsers.oppl.testcase.TestCaseRunner#success(org.coode.parsers.oppl.testcase.Test)
		 */
		@Override
		protected void success(Test test) {
			TestCase
					.fail("The configuration should fail and the tests should not be carried out, but they have been instead ");
		}
	}

	private final class JunitShouldFailTestCaseRunner extends TestCaseRunner {
		/**
		 * @param opplTestCase
		 */
		public JunitShouldFailTestCaseRunner(OPPLTestCase opplTestCase) {
			super(opplTestCase);
		}

		/**
		 * @see org.coode.parsers.oppl.testcase.TestCaseRunner#fail(org.coode.parsers.oppl.testcase.Test)
		 */
		@Override
		protected void fail(Test test) {
		}

		@Override
		protected void configurationFailed(String message) {
			TestCase
					.fail("The configuration should be fine, it fails instead with the following message: "
							+ message);
		}

		/**
		 * @see org.coode.parsers.oppl.testcase.TestCaseRunner#fail(java.lang.Throwable)
		 */
		@Override
		protected void fail(Throwable e) {
		}

		/**
		 * @see org.coode.parsers.oppl.testcase.TestCaseRunner#success(org.coode.parsers.oppl.testcase.Test)
		 */
		@Override
		protected void success(Test test) {
			TestCase.fail("Test " + test + " sould fail; it succeded instead");
		}
	}

	private static final ErrorListener ERROR_LISTENER = new JUnitTestErrorListener();

	public void testCount() {
		String testCase = "testOneAssertion; ?x:CLASS SELECT ?x subClassOf Pizza ASSERT count(?x) = 1; ?x count is not 1;";
		OWLOntologyManager ontologyManager = OWLManager
				.createOWLOntologyManager();
		try {
			OWLOntology pizzaOntology = ontologyManager
					.loadOntology(IRI
							.create("http://www.co-ode.org/ontologies/pizza/pizza.owl"));
			ParserFactory parserFactory = new ParserFactory(pizzaOntology,
					ontologyManager);
			OPPLTestCaseParser parser = parserFactory.build(ERROR_LISTENER);
			OPPLTestCase opplTestCase = parser.parse(testCase);
			this.runTestCase(opplTestCase);
		} catch (OWLOntologyCreationException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	public void testCountInference() {
		String testCase = "testOneAssertion; INFERENCE; ?x:CLASS SELECT ?x subClassOf InterestingPizza WHERE ?x!=InterestingPizza, FAIL ?x equivalentTo Nothing  ASSERT count(?x) = 20; ?x count is not 20;";
		OWLOntologyManager ontologyManager = OWLManager
				.createOWLOntologyManager();
		try {
			OWLOntology pizzaOntology = ontologyManager
					.loadOntology(IRI
							.create("http://www.co-ode.org/ontologies/pizza/pizza.owl"));
			FaCTPlusPlusReasonerFactory reasonerFactory = new FaCTPlusPlusReasonerFactory();
			OWLReasoner reasoner = reasonerFactory
					.createReasoner(pizzaOntology);
			ParserFactory parserFactory = new ParserFactory(pizzaOntology,
					ontologyManager, reasoner);
			OPPLTestCaseParser parser = parserFactory.build(ERROR_LISTENER);
			OPPLTestCase opplTestCase = parser.parse(testCase);
			this.runTestCase(opplTestCase);
		} catch (OWLOntologyCreationException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	public void testCountShouldFail() {
		String testCase = "testOneAssertion; ?x:CLASS SELECT ?x subClassOf Pizza ASSERT count(?x) != 1; ?x count is 1;";
		OWLOntologyManager ontologyManager = OWLManager
				.createOWLOntologyManager();
		try {
			OWLOntology pizzaOntology = ontologyManager
					.loadOntology(IRI
							.create("http://www.co-ode.org/ontologies/pizza/pizza.owl"));
			ParserFactory parserFactory = new ParserFactory(pizzaOntology,
					ontologyManager);
			OPPLTestCaseParser parser = parserFactory.build(ERROR_LISTENER);
			OPPLTestCase opplTestCase = parser.parse(testCase);
			this.runTestCase(opplTestCase, false);
		} catch (OWLOntologyCreationException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	public void testConfigurationNotOK() {
		String testCase = "testOneAssertion; INFERENCE; ?x:CLASS SELECT ?x subClassOf Pizza ASSERT count(?x) != 1; ?x count is 1;";
		OWLOntologyManager ontologyManager = OWLManager
				.createOWLOntologyManager();
		try {
			OWLOntology pizzaOntology = ontologyManager
					.loadOntology(IRI
							.create("http://www.co-ode.org/ontologies/pizza/pizza.owl"));
			ParserFactory parserFactory = new ParserFactory(pizzaOntology,
					ontologyManager);
			OPPLTestCaseParser parser = parserFactory.build(ERROR_LISTENER);
			OPPLTestCase opplTestCase = parser.parse(testCase);
			TestCaseRunner runner = new JunitConfigShouldFailTestCaseRunner(
					opplTestCase);
			runner.run();
		} catch (OWLOntologyCreationException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	private void runTestCase(OPPLTestCase opplTestCase) {
		this.runTestCase(opplTestCase, true);
	}

	/**
	 * @param opplTestCase
	 */
	private void runTestCase(OPPLTestCase opplTestCase, boolean shouldSucceed) {
		TestCaseRunner runner = shouldSucceed ? new JUnitTestCaseRunner(
				opplTestCase) : new JunitShouldFailTestCaseRunner(opplTestCase);
		runner.run();
	}
}
