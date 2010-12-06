package org.coode.parsers.oppl.testcase.junittest;

import java.util.regex.PatternSyntaxException;

import junit.framework.TestCase;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.RuleReturnScope;
import org.antlr.runtime.Token;
import org.antlr.runtime.TokenRewriteStream;
import org.antlr.runtime.TokenStream;
import org.antlr.runtime.tree.CommonErrorNode;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.CommonTreeAdaptor;
import org.antlr.runtime.tree.CommonTreeNodeStream;
import org.antlr.runtime.tree.TreeAdaptor;
import org.coode.oppl.ConstraintSystem;
import org.coode.oppl.exceptions.RuntimeExceptionHandler;
import org.coode.parsers.ErrorListener;
import org.coode.parsers.ManchesterOWLSyntaxSimplify;
import org.coode.parsers.ManchesterOWLSyntaxTypes;
import org.coode.parsers.common.JUnitTestErrorListener;
import org.coode.parsers.oppl.DefaultTypeEnforcer;
import org.coode.parsers.oppl.OPPLDefine;
import org.coode.parsers.oppl.OPPLSyntaxTree;
import org.coode.parsers.oppl.OPPLTypeEnforcement;
import org.coode.parsers.oppl.OPPLTypes;
import org.coode.parsers.oppl.testcase.AbstractOPPLTestCaseFactory;
import org.coode.parsers.oppl.testcase.OPPLTestCase;
import org.coode.parsers.oppl.testcase.OPPLTestCaseCombinedParser;
import org.coode.parsers.oppl.testcase.OPPLTestCaseFactory;
import org.coode.parsers.oppl.testcase.OPPLTestCaseLexer;
import org.coode.parsers.oppl.testcase.OPPLTestCaseSymbolTable;
import org.coode.parsers.oppl.testcase.OPPLTestCaseTypes;
import org.coode.parsers.oppl.testcase.SimpleSymbolTableFactory;
import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;
import org.semanticweb.owlapi.model.OWLOntologyManager;
import org.semanticweb.owlapi.model.OWLRuntimeException;

public class OPPLTestCaseTypesTest extends TestCase {
	private static TreeAdaptor adaptor = new CommonTreeAdaptor() {
		@Override
		public Object create(Token token) {
			return new OPPLSyntaxTree(token);
		}

		@Override
		public Object dupNode(Object t) {
			if (t == null) {
				return null;
			}
			return this.create(((OPPLSyntaxTree) t).token);
		}

		@Override
		public Object errorNode(TokenStream input, Token start, Token stop, RecognitionException e) {
			return new CommonErrorNode(input, start, stop, e);
		}
	};
	private static final ErrorListener ERROR_LISTENER = new JUnitTestErrorListener();
	private static final RuntimeExceptionHandler HANDLER = new RuntimeExceptionHandler() {
		public void handlePatternSyntaxExcpetion(PatternSyntaxException e) {
			ERROR_LISTENER.reportThrowable(e, 0, 0, 0);
		}

		public void handleOWLRuntimeException(OWLRuntimeException e) {
			ERROR_LISTENER.reportThrowable(e, 0, 0, 0);
		}

		public void handleException(RuntimeException e) {
			ERROR_LISTENER.reportThrowable(e, 0, 0, 0);
		}
	};

	protected OPPLTestCase parse(String input, OWLOntology ontology,
			OWLOntologyManager ontologyManager) {
		SimpleSymbolTableFactory simpleSymbolTableFactory = new SimpleSymbolTableFactory(
				ontologyManager);
		OPPLTestCaseSymbolTable symtab = simpleSymbolTableFactory.createSymbolTable();
		symtab.setErrorListener(ERROR_LISTENER);
		AbstractOPPLTestCaseFactory testCaseFactory = new OPPLTestCaseFactory(ontology,
				ontologyManager, null);
		ConstraintSystem constraintSystem = testCaseFactory.getOPPLFactory().createConstraintSystem();
		ANTLRStringStream antlrStringStream = new ANTLRStringStream(input);
		OPPLTestCaseLexer opplTestCaseLexer = new OPPLTestCaseLexer(antlrStringStream);
		final TokenRewriteStream tokens = new TokenRewriteStream(opplTestCaseLexer);
		OPPLTestCaseCombinedParser parser = new OPPLTestCaseCombinedParser(tokens, ERROR_LISTENER);
		parser.setTreeAdaptor(adaptor);
		try {
			RuleReturnScope r = parser.testCase();
			CommonTree tree = (CommonTree) r.getTree();
			CommonTreeNodeStream nodes = new CommonTreeNodeStream(tree);
			nodes.setTokenStream(tokens); // where to find tokens
			nodes.setTreeAdaptor(adaptor);
			nodes.reset();
			// RESOLVE SYMBOLS, COMPUTE EXPRESSION TYPES
			ManchesterOWLSyntaxSimplify simplify = new ManchesterOWLSyntaxSimplify(nodes);
			simplify.setTreeAdaptor(adaptor);
			simplify.downup(tree);
			nodes.reset();
			System.out.println(tree.toStringTree());
			OPPLDefine define = new OPPLDefine(nodes, symtab, ERROR_LISTENER, constraintSystem);
			define.setTreeAdaptor(adaptor);
			define.downup(tree);
			nodes.reset();
			ManchesterOWLSyntaxTypes mOWLTypes = new ManchesterOWLSyntaxTypes(nodes, symtab,
					ERROR_LISTENER);
			mOWLTypes.downup(tree);
			nodes.reset();
			OPPLTypeEnforcement typeEnforcement = new OPPLTypeEnforcement(
					nodes,
					symtab,
					new DefaultTypeEnforcer(symtab,
							testCaseFactory.getOPPLFactory().getOWLEntityFactory(), ERROR_LISTENER),
					ERROR_LISTENER);
			typeEnforcement.downup(tree);
			nodes.reset();
			mOWLTypes.downup(tree);
			nodes.reset();
			OPPLTypes opplTypes = new OPPLTypes(nodes, symtab, ERROR_LISTENER, constraintSystem,
					testCaseFactory.getOPPLFactory());
			opplTypes.downup(tree);
			nodes.reset();
			OPPLTestCaseTypes opplTestCaseTypes = new OPPLTestCaseTypes(nodes, symtab,
					ERROR_LISTENER, constraintSystem, testCaseFactory, HANDLER);
			opplTestCaseTypes.downup(tree);
			return (OPPLTestCase) ((OPPLSyntaxTree) r.getTree()).getOPPLContent();
		} catch (RecognitionException e) {
			e.printStackTrace();
			return null;
		}
	}

	public void testOneAssertion() {
		String testCase = "testOneAssertion; INFERENCE; ?x:CLASS SELECT ?x subClassOf Thing ASSERT ?x = Thing";
		OWLOntologyManager ontologyManager = OWLManager.createOWLOntologyManager();
		OWLOntology ontology;
		try {
			ontology = ontologyManager.createOntology();
			OPPLTestCase parsed = this.parse(testCase, ontology, ontologyManager);
			assertNotNull(parsed);
			System.out.println("OPPLTestCaseParserTest.testOneAssertion()\n" + parsed);
		} catch (OWLOntologyCreationException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	public void testOneAssertionWithMessage() {
		String testCase = "testOneAssertion; INFERENCE; ?x:CLASS SELECT ?x subClassOf Thing ASSERT ?x = Thing; ?x is not equal to Thing";
		OWLOntologyManager ontologyManager = OWLManager.createOWLOntologyManager();
		OWLOntology ontology;
		try {
			ontology = ontologyManager.createOntology();
			OPPLTestCase parsed = this.parse(testCase, ontology, ontologyManager);
			assertNotNull(parsed);
			System.out.println("OPPLTestCaseParserTest.testOneAssertionWithMessage()\n" + parsed);
		} catch (OWLOntologyCreationException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	public void testNotEqualAssertionWithMessage() {
		String testCase = "testOneAssertion; INFERENCE; ?x:CLASS SELECT ?x subClassOf Thing ASSERT ?x != Thing; ?x is equal to Thing;";
		OWLOntologyManager ontologyManager = OWLManager.createOWLOntologyManager();
		OWLOntology ontology;
		try {
			ontology = ontologyManager.createOntology();
			OPPLTestCase parsed = this.parse(testCase, ontology, ontologyManager);
			assertNotNull(parsed);
			System.out.println("OPPLTestCaseParserTest.testOneAssertionWithMessage()\n" + parsed);
		} catch (OWLOntologyCreationException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	public void testCountAssertionWithMessage() {
		String testCase = "testOneAssertion; INFERENCE; ?x:CLASS SELECT ?x subClassOf Thing ASSERT count(?x) = 2; ?x values count is not 2;";
		OWLOntologyManager ontologyManager = OWLManager.createOWLOntologyManager();
		OWLOntology ontology;
		try {
			ontology = ontologyManager.createOntology();
			OPPLTestCase parsed = this.parse(testCase, ontology, ontologyManager);
			assertNotNull(parsed);
			System.out.println("OPPLTestCaseParserTest.testCountAssertionWithMessage()\n" + parsed);
		} catch (OWLOntologyCreationException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	public void testContainsAssertionWithMessage() {
		String testCase = "testOneAssertion; INFERENCE; ?x:CLASS SELECT ?x subClassOf Thing ASSERT ?x CONTAINS Thing; ?x values do not contain Thing;";
		OWLOntologyManager ontologyManager = OWLManager.createOWLOntologyManager();
		OWLOntology ontology;
		try {
			ontology = ontologyManager.createOntology();
			OPPLTestCase parsed = this.parse(testCase, ontology, ontologyManager);
			assertNotNull(parsed);
			System.out.println("OPPLTestCaseTypesTest.testContainsAssertionWithMessage()\n"
					+ parsed);
		} catch (OWLOntologyCreationException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	public void testContainsAssertionWithMessageWithMoreThanOneOWLObject() {
		String testCase = "testOneAssertion; INFERENCE; ?x:CLASS SELECT ?x subClassOf Thing ASSERT ?x CONTAINS Thing, Nothing; ?x values do not contain Thing and Nothing;";
		OWLOntologyManager ontologyManager = OWLManager.createOWLOntologyManager();
		OWLOntology ontology;
		try {
			ontology = ontologyManager.createOntology();
			OPPLTestCase parsed = this.parse(testCase, ontology, ontologyManager);
			assertNotNull(parsed);
			System.out.println("OPPLTestCaseTypesTest.testContainsAssertionWithMessageWithMoreThanOneOWLObject()\n"
					+ parsed);
		} catch (OWLOntologyCreationException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	public void testVariableEqualAssertionWithMessage() {
		String testCase = "testOneAssertion; INFERENCE; ?x:CLASS, ?y:CLASS SELECT ?x subClassOf ?y ASSERT ?x = ?y; ?x values are not equal to ?y;";
		OWLOntologyManager ontologyManager = OWLManager.createOWLOntologyManager();
		OWLOntology ontology;
		try {
			ontology = ontologyManager.createOntology();
			OPPLTestCase parsed = this.parse(testCase, ontology, ontologyManager);
			assertNotNull(parsed);
			System.out.println("OPPLTestCaseTypesTest.testVariableEqualAssertionWithMessage()\n"
					+ parsed);
		} catch (OWLOntologyCreationException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	public void testCountStarAssertionWithMessage() {
		String testCase = "testOneAssertion;  ?x:CLASS, ?y:CLASS SELECT ?x subClassOf ?y ASSERT count(*)= 1; The total count of bindings is not 1;";
		OWLOntologyManager ontologyManager = OWLManager.createOWLOntologyManager();
		OWLOntology ontology;
		try {
			ontology = ontologyManager.createOntology();
			OPPLTestCase parsed = this.parse(testCase, ontology, ontologyManager);
			assertNotNull(parsed);
			System.out.println("OPPLTestCaseTypesTest.testCountStarAssertionWithMessage()\n"
					+ parsed);
		} catch (OWLOntologyCreationException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	public void testLessThanAssertionWithMessage() {
		String testCase = "testOneAssertion;  ?x:CLASS, ?y:CLASS SELECT ?x subClassOf ?y ASSERT count(*)< 1; The total count of bindings is greater than or equal to 1;";
		OWLOntologyManager ontologyManager = OWLManager.createOWLOntologyManager();
		OWLOntology ontology;
		try {
			ontology = ontologyManager.createOntology();
			OPPLTestCase parsed = this.parse(testCase, ontology, ontologyManager);
			assertNotNull(parsed);
			System.out.println("OPPLTestCaseTypesTest.testLessThanAssertionWithMessage()\n"
					+ parsed);
		} catch (OWLOntologyCreationException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	public void testLessThanEqualToAssertionWithMessage() {
		String testCase = "testOneAssertion;  ?x:CLASS, ?y:CLASS SELECT ?x subClassOf ?y ASSERT count(*)<= 1; The total count of bindings is greater 1;";
		OWLOntologyManager ontologyManager = OWLManager.createOWLOntologyManager();
		OWLOntology ontology;
		try {
			ontology = ontologyManager.createOntology();
			OPPLTestCase parsed = this.parse(testCase, ontology, ontologyManager);
			assertNotNull(parsed);
			System.out.println("OPPLTestCaseTypesTest.testLessThanEqualToAssertionWithMessage()\n"
					+ parsed);
		} catch (OWLOntologyCreationException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	public void testGreaterThanEqualToAssertionWithMessage() {
		String testCase = "testOneAssertion;  ?x:CLASS, ?y:CLASS SELECT ?x subClassOf ?y ASSERT count(*) >= 1; The total count of bindings is Less than 1;";
		OWLOntologyManager ontologyManager = OWLManager.createOWLOntologyManager();
		OWLOntology ontology;
		try {
			ontology = ontologyManager.createOntology();
			OPPLTestCase parsed = this.parse(testCase, ontology, ontologyManager);
			assertNotNull(parsed);
			System.out.println("OPPLTestCaseTypesTest.testGreaterThanEqualToAssertionWithMessage()\n"
					+ parsed);
		} catch (OWLOntologyCreationException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	public void testGreaterThanAssertionWithMessage() {
		String testCase = "testOneAssertion;  ?x:CLASS, ?y:CLASS SELECT ?x subClassOf ?y ASSERT count(*)> 1; The total count of bindings is Less than or equal to 1;";
		OWLOntologyManager ontologyManager = OWLManager.createOWLOntologyManager();
		OWLOntology ontology;
		try {
			ontology = ontologyManager.createOntology();
			OPPLTestCase parsed = this.parse(testCase, ontology, ontologyManager);
			assertNotNull(parsed);
			System.out.println("OPPLTestCaseTypesTest.testGreaterThanAssertionWithMessage()\n"
					+ parsed);
		} catch (OWLOntologyCreationException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	public void testBindingWithMessage() {
		String testCase = "testOneAssertion; ?x:CLASS, ?y:CLASS SELECT ?x subClassOf ?y ASSERT count(?x=Thing, ?y=Thing) > 0; The total count of bindings with ?x=Thing and ?y=Thing is less or equal than 0";
		OWLOntologyManager ontologyManager = OWLManager.createOWLOntologyManager();
		OWLOntology ontology;
		try {
			ontology = ontologyManager.createOntology();
			OPPLTestCase parsed = this.parse(testCase, ontology, ontologyManager);
			assertNotNull(parsed);
			System.out.println("OPPLTestCaseTypesTest.testBindingWithMessage()\n" + parsed);
		} catch (OWLOntologyCreationException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	public void test2BindingsWithOutMessages() {
		String testCase = "testOneAssertion; ?x:CLASS, ?y:CLASS SELECT ?x subClassOf ?y ASSERT count(?x=Pizza, ?y=PizzaBase) > 0 ASSERT count(?x=Thing, ?y=Nothing) > 0";
		OWLOntologyManager ontologyManager = OWLManager.createOWLOntologyManager();
		OWLOntology ontology;
		try {
			ontology = ontologyManager.loadOntology(IRI.create("http://www.co-ode.org/ontologies/pizza/2007/02/12/pizza.owl"));
			OPPLTestCase parsed = this.parse(testCase, ontology, ontologyManager);
			assertNotNull(parsed);
			System.out.println("OPPLTestCaseTypesTest.test2BindingsWithMessages()\n" + parsed);
		} catch (OWLOntologyCreationException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
}
