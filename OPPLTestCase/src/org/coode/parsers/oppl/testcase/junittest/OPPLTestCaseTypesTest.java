package org.coode.parsers.oppl.testcase.junittest;

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
import org.coode.parsers.ErrorListener;
import org.coode.parsers.ManchesterOWLSyntaxSimplify;
import org.coode.parsers.ManchesterOWLSyntaxTypes;
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
import org.coode.parsers.test.JUnitTestErrorListener;
import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;
import org.semanticweb.owlapi.model.OWLOntologyManager;

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
		public Object errorNode(TokenStream input, Token start, Token stop,
				RecognitionException e) {
			return new CommonErrorNode(input, start, stop, e);
		}
	};
	private static final ErrorListener ERROR_LISTENER = new JUnitTestErrorListener();

	protected OPPLTestCase parse(String input, OWLOntology ontology,
			OWLOntologyManager ontologyManager) {
		SimpleSymbolTableFactory simpleSymbolTableFactory = new SimpleSymbolTableFactory(
				ontologyManager);
		OPPLTestCaseSymbolTable symtab = simpleSymbolTableFactory
				.createSymbolTable();
		AbstractOPPLTestCaseFactory testCaseFactory = new OPPLTestCaseFactory(
				ontology, ontologyManager, null);
		ConstraintSystem constraintSystem = testCaseFactory.getOPPLFactory()
				.createConstraintSystem();
		ANTLRStringStream antlrStringStream = new ANTLRStringStream(input);
		OPPLTestCaseLexer opplTestCaseLexer = new OPPLTestCaseLexer(
				antlrStringStream);
		final TokenRewriteStream tokens = new TokenRewriteStream(
				opplTestCaseLexer);
		OPPLTestCaseCombinedParser parser = new OPPLTestCaseCombinedParser(
				tokens, ERROR_LISTENER);
		parser.setTreeAdaptor(adaptor);
		try {
			RuleReturnScope r = parser.testCase();
			CommonTree tree = (CommonTree) r.getTree();
			CommonTreeNodeStream nodes = new CommonTreeNodeStream(tree);
			nodes.setTokenStream(tokens); // where to find tokens
			nodes.setTreeAdaptor(adaptor);
			nodes.reset();
			// RESOLVE SYMBOLS, COMPUTE EXPRESSION TYPES
			ManchesterOWLSyntaxSimplify simplify = new ManchesterOWLSyntaxSimplify(
					nodes);
			simplify.setTreeAdaptor(adaptor);
			simplify.downup(tree);
			nodes.reset();
			OPPLDefine define = new OPPLDefine(nodes, symtab, ERROR_LISTENER,
					constraintSystem);
			define.setTreeAdaptor(adaptor);
			define.downup(tree);
			nodes.reset();
			ManchesterOWLSyntaxTypes mOWLTypes = new ManchesterOWLSyntaxTypes(
					nodes, symtab, ERROR_LISTENER);
			mOWLTypes.downup(tree);
			nodes.reset();
			OPPLTypeEnforcement typeEnforcement = new OPPLTypeEnforcement(
					nodes, symtab, new DefaultTypeEnforcer(symtab,
							testCaseFactory.getOPPLFactory()
									.getOWLEntityFactory(), ERROR_LISTENER),
					ERROR_LISTENER);
			typeEnforcement.downup(tree);
			nodes.reset();
			mOWLTypes.downup(tree);
			nodes.reset();
			OPPLTypes opplTypes = new OPPLTypes(nodes, symtab, ERROR_LISTENER,
					constraintSystem, testCaseFactory.getOPPLFactory());
			opplTypes.downup(tree);
			nodes.reset();
			OPPLTestCaseTypes opplTestCaseTypes = new OPPLTestCaseTypes(nodes,
					symtab, ERROR_LISTENER, constraintSystem, testCaseFactory);
			opplTestCaseTypes.downup(tree);
			return (OPPLTestCase) ((OPPLSyntaxTree) r.getTree())
					.getOPPLContent();
		} catch (RecognitionException e) {
			e.printStackTrace();
			return null;
		}
	}

	public void testOneAssertion() {
		String testCase = "testOneAssertion; INFERENCE; ?x:CLASS SELECT ?x subClassOf Thing ASSERT ?x = Thing";
		OWLOntologyManager ontologyManager = OWLManager
				.createOWLOntologyManager();
		OWLOntology ontology;
		try {
			ontology = ontologyManager.createOntology();
			OPPLTestCase parsed = this.parse(testCase, ontology,
					ontologyManager);
			assertNotNull(parsed);
			System.out.println("OPPLTestCaseParserTest.testOneAssertion()\n"
					+ parsed);
		} catch (OWLOntologyCreationException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	public void testOneAssertionWithMessage() {
		String testCase = "testOneAssertion; INFERENCE; ?x:CLASS SELECT ?x subClassOf Thing ASSERT ?x = Thing; ?x is not equal to Thing";
		OWLOntologyManager ontologyManager = OWLManager
				.createOWLOntologyManager();
		OWLOntology ontology;
		try {
			ontology = ontologyManager.createOntology();
			OPPLTestCase parsed = this.parse(testCase, ontology,
					ontologyManager);
			assertNotNull(parsed);
			System.out
					.println("OPPLTestCaseParserTest.testOneAssertionWithMessage()\n"
							+ parsed);
		} catch (OWLOntologyCreationException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	public void testNotEqualAssertionWithMessage() {
		String testCase = "testOneAssertion; INFERENCE; ?x:CLASS SELECT ?x subClassOf Thing ASSERT ?x != Thing; ?x is equal to Thing;";
		OWLOntologyManager ontologyManager = OWLManager
				.createOWLOntologyManager();
		OWLOntology ontology;
		try {
			ontology = ontologyManager.createOntology();
			OPPLTestCase parsed = this.parse(testCase, ontology,
					ontologyManager);
			assertNotNull(parsed);
			System.out
					.println("OPPLTestCaseParserTest.testOneAssertionWithMessage()\n"
							+ parsed);
		} catch (OWLOntologyCreationException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	public void testCountAssertionWithMessage() {
		String testCase = "testOneAssertion; INFERENCE; ?x:CLASS SELECT ?x subClassOf Thing ASSERT count(?x) = 2; ?x values count is not 2;";
		OWLOntologyManager ontologyManager = OWLManager
				.createOWLOntologyManager();
		OWLOntology ontology;
		try {
			ontology = ontologyManager.createOntology();
			OPPLTestCase parsed = this.parse(testCase, ontology,
					ontologyManager);
			assertNotNull(parsed);
			System.out
					.println("OPPLTestCaseParserTest.testCountAssertionWithMessage()\n"
							+ parsed);
		} catch (OWLOntologyCreationException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	public void testContainsAssertionWithMessage() {
		String testCase = "testOneAssertion; INFERENCE; ?x:CLASS SELECT ?x subClassOf Thing ASSERT ?x CONTAINS Thing; ?x values do not contain Thing;";
		OWLOntologyManager ontologyManager = OWLManager
				.createOWLOntologyManager();
		OWLOntology ontology;
		try {
			ontology = ontologyManager.createOntology();
			OPPLTestCase parsed = this.parse(testCase, ontology,
					ontologyManager);
			assertNotNull(parsed);
			System.out
					.println("OPPLTestCaseTypesTest.testContainsAssertionWithMessage()\n"
							+ parsed);
		} catch (OWLOntologyCreationException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	public void testContainsAssertionWithMessageWithMoreThanOneOWLObject() {
		String testCase = "testOneAssertion; INFERENCE; ?x:CLASS SELECT ?x subClassOf Thing ASSERT ?x CONTAINS Thing, Nothing; ?x values do not contain Thing and Nothing;";
		OWLOntologyManager ontologyManager = OWLManager
				.createOWLOntologyManager();
		OWLOntology ontology;
		try {
			ontology = ontologyManager.createOntology();
			OPPLTestCase parsed = this.parse(testCase, ontology,
					ontologyManager);
			assertNotNull(parsed);
			System.out
					.println("OPPLTestCaseTypesTest.testContainsAssertionWithMessageWithMoreThanOneOWLObject()\n"
							+ parsed);
		} catch (OWLOntologyCreationException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	public void testVariableEqualAssertionWithMessage() {
		String testCase = "testOneAssertion; INFERENCE; ?x:CLASS, ?y:CLASS SELECT ?x subClassOf ?y ASSERT ?x = ?y; ?x values are not equal to ?y;";
		OWLOntologyManager ontologyManager = OWLManager
				.createOWLOntologyManager();
		OWLOntology ontology;
		try {
			ontology = ontologyManager.createOntology();
			OPPLTestCase parsed = this.parse(testCase, ontology,
					ontologyManager);
			assertNotNull(parsed);
			System.out
					.println("OPPLTestCaseTypesTest.testVariableEqualAssertionWithMessage()\n"
							+ parsed);
		} catch (OWLOntologyCreationException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
}
