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
import org.coode.parsers.ErrorListener;
import org.coode.parsers.ManchesterOWLSyntaxSimplify;
import org.coode.parsers.oppl.OPPLSyntaxTree;
import org.coode.parsers.oppl.testcase.OPPLTestCaseCombinedParser;
import org.coode.parsers.oppl.testcase.OPPLTestCaseLexer;
import org.coode.parsers.test.JUnitTestErrorListener;

public class OPPLTestCaseParserTest extends TestCase {
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

	protected OPPLSyntaxTree parse(String input) {
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
			return (OPPLSyntaxTree) r.getTree();
		} catch (RecognitionException e) {
			e.printStackTrace();
			return null;
		}
	}

	public void testOneAssertion() {
		String testCase = "testOneAssertion; INFERENCE; ?x:CLASS SELECT ?x subClassOf Thing ASSERT ?x = Thing";
		OPPLSyntaxTree parsed = this.parse(testCase);
		assertNotNull(parsed);
		System.out.println("OPPLTestCaseParserTest.testOneAssertion()\n"
				+ parsed.toStringTree());
	}

	public void testOneAssertionWithMessage() {
		String testCase = "testOneAssertion; INFERENCE; ?x:CLASS SELECT ?x subClassOf Thing ASSERT ?x = Thing; ?x is not equal to Thing";
		OPPLSyntaxTree parsed = this.parse(testCase);
		assertNotNull(parsed);
		System.out
				.println("OPPLTestCaseParserTest.testOneAssertionWithMessage()\n"
						+ parsed.toStringTree());
	}

	public void testNotEqualAssertionWithMessage() {
		String testCase = "testOneAssertion; INFERENCE; ?x:CLASS SELECT ?x subClassOf Thing ASSERT ?x != Thing; ?x is equal to Thing;";
		OPPLSyntaxTree parsed = this.parse(testCase);
		assertNotNull(parsed);
		System.out
				.println("OPPLTestCaseParserTest.testOneAssertionWithMessage()\n"
						+ parsed.toStringTree());
	}

	public void testCountAssertionWithMessage() {
		String testCase = "testOneAssertion; INFERENCE; ?x:CLASS SELECT ?x subClassOf Thing ASSERT count(?x) = 2; ?x values count is not 2;";
		OPPLSyntaxTree parsed = this.parse(testCase);
		assertNotNull(parsed);
		System.out
				.println("OPPLTestCaseParserTest.testCountAssertionWithMessage()\n"
						+ parsed.toStringTree());
	}

	public void testContainsAssertionWithMessage() {
		String testCase = "testOneAssertion; INFERENCE; ?x:CLASS SELECT ?x subClassOf Thing ASSERT ?x CONTAINS Thing; ?x values do not contain Thing;";
		OPPLSyntaxTree parsed = this.parse(testCase);
		assertNotNull(parsed);
		System.out
				.println("OPPLTestCaseParserTest.testCountAssertionWithMessage()\n"
						+ parsed.toStringTree());
	}

	public void testVariableEqualAssertionWithMessage() {
		String testCase = "testOneAssertion; INFERENCE; ?x:CLASS, ?y:CLASS SELECT ?x subClassOf ?y ASSERT ?x = ?y; ?x values are not equal to ?y;";
		OPPLSyntaxTree parsed = this.parse(testCase);
		assertNotNull(parsed);
		System.out
				.println("OPPLTestCaseParserTest.testOneAssertionWithMessage()\n"
						+ parsed.toStringTree());
	}
}
