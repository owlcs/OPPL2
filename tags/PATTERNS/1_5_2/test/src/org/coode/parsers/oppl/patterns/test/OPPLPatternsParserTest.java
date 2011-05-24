package org.coode.parsers.oppl.patterns.test;

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
import org.coode.parsers.ManchesterOWLSyntaxSimplify;
import org.coode.parsers.oppl.OPPLSyntaxTree;
import org.coode.parsers.oppl.patterns.OPPLPatternLexer;
import org.coode.parsers.oppl.patterns.OPPLPatternScriptParser;

/**
 * Test for the AST generation for OPPL
 * 
 * @author Luigi Iannone
 * 
 */
public class OPPLPatternsParserTest extends TestCase {
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

	public void testFood() {
		String patternString = "?x:CLASS, ?y:CLASS, ?forbiddenContent:CLASS = createUnion(?x.VALUES) BEGIN ADD $thisClass equivalentTo contains only (not ?forbiddenContent) END; A ?x free stuff; RETURN $thisClass";
		OPPLSyntaxTree parsed = this.parse(patternString);
		System.out.println(parsed.toStringTree());
		assertNotNull(parsed);
	}

	public void testMenu() {
		String patternString = "?x:CLASS[subClassOf Food] BEGIN ADD $thisClass subClassOf Menu, ADD $thisClass subClassOf contains only (Course and contains only ($FreeFromPattern(?x))) END; A ?x free Menu";
		OPPLSyntaxTree parsed = this.parse(patternString);
		System.out.println(parsed.toStringTree());
		assertNotNull(parsed);
	}

	public void testPizza() {
		String patternString = "?base:CLASS,?topping:CLASS, ?allToppings:CLASS = createUnion(?topping.VALUES) BEGIN ADD $thisClass subClassOf Pizza, ADD $thisClass subClassOf hasTopping some ?topping,  ADD $thisClass subClassOf hasTopping only ?allToppings, ADD $thisClass subClassOf hasBase some ?base  END; A pizza with ?base base and ?topping toppings";
		OPPLSyntaxTree parsed = this.parse(patternString);
		System.out.println(parsed.toStringTree());
		assertNotNull(parsed);
	}

	public void testDOLCEInformationRealization() {
		String patternString = "?informationObject:CLASS, ?informationRealization:CLASS, ?realizationProperty:OBJECTPROPERTY BEGIN ADD ?informationRealization subClassOf InformationRealization, ADD ?informationObject subClassOf InformationObject, ADD ?realizationProperty subPropertyOf realizes, ADD ?informationRealization subClassOf PhysicalObject and ?realizationProperty some ?InformationObject END;Information Realization Pattern: ?informationRealization ?realizationProperty ?informationObject";
		OPPLSyntaxTree parsed = this.parse(patternString);
		System.out.println(parsed.toStringTree());
		assertNotNull(parsed);
	}

	public void testDOLCEPersonRoleTimeInterval() {
		String patternString = "?person:CLASS, ?role:CLASS, ?timeInterval:CLASS BEGIN ADD $thisClass subClassOf Situation, ADD $thisClass subClassOf isSettingFor some ?person, ADD $thisClass subClassOf isSettingFor some ?role, ADD $thisClass subClassOf isSettingFor some ?timeInterval END; Situation where ?person play the role ?role during the time interval ?timeInterval";
		OPPLSyntaxTree parsed = this.parse(patternString);
		System.out.println(parsed.toStringTree());
		assertNotNull(parsed);
	}

	public void testParseThisClassAtomic() {
		String input = "$thisClass";
		ANTLRStringStream antlrStringStream = new ANTLRStringStream(input);
		OPPLPatternLexer lexer = new OPPLPatternLexer(antlrStringStream);
		final TokenRewriteStream tokens = new TokenRewriteStream(lexer);
		OPPLPatternScriptParser parser = new OPPLPatternScriptParser(tokens);
		parser.setTreeAdaptor(adaptor);
		try {
			RuleReturnScope r = parser.atomic();
			assertNotNull(r);
			CommonTree tree = (CommonTree) r.getTree();
			System.out.println(tree.toStringTree());
		} catch (RecognitionException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	public void testParseAtomic() {
		String input = "Thing";
		ANTLRStringStream antlrStringStream = new ANTLRStringStream(input);
		OPPLPatternLexer lexer = new OPPLPatternLexer(antlrStringStream);
		final TokenRewriteStream tokens = new TokenRewriteStream(lexer);
		OPPLPatternScriptParser parser = new OPPLPatternScriptParser(tokens);
		parser.setTreeAdaptor(adaptor);
		try {
			RuleReturnScope r = parser.atomic();
			assertNotNull(r);
			CommonTree tree = (CommonTree) r.getTree();
			System.out.println(tree.toStringTree());
		} catch (RecognitionException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	public void testParseThisClassExpression() {
		String input = "$thisClass";
		ANTLRStringStream antlrStringStream = new ANTLRStringStream(input);
		OPPLPatternLexer lexer = new OPPLPatternLexer(antlrStringStream);
		final TokenRewriteStream tokens = new TokenRewriteStream(lexer);
		OPPLPatternScriptParser parser = new OPPLPatternScriptParser(tokens);
		parser.setTreeAdaptor(adaptor);
		try {
			RuleReturnScope r = parser.expression();
			assertNotNull(r);
			CommonTree tree = (CommonTree) r.getTree();
			System.out.println(tree.toStringTree());
		} catch (RecognitionException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	public void testParseUnaryVariable() {
		String input = "?x";
		ANTLRStringStream antlrStringStream = new ANTLRStringStream(input);
		OPPLPatternLexer lexer = new OPPLPatternLexer(antlrStringStream);
		final TokenRewriteStream tokens = new TokenRewriteStream(lexer);
		OPPLPatternScriptParser parser = new OPPLPatternScriptParser(tokens);
		parser.setTreeAdaptor(adaptor);
		try {
			RuleReturnScope r = parser.unary();
			assertNotNull(r);
			CommonTree tree = (CommonTree) r.getTree();
			System.out.println(tree.toStringTree());
		} catch (RecognitionException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	public void testParseUnaryThisClass() {
		String input = "$thisClass";
		ANTLRStringStream antlrStringStream = new ANTLRStringStream(input);
		OPPLPatternLexer lexer = new OPPLPatternLexer(antlrStringStream);
		final TokenRewriteStream tokens = new TokenRewriteStream(lexer);
		OPPLPatternScriptParser parser = new OPPLPatternScriptParser(tokens);
		parser.setTreeAdaptor(adaptor);
		try {
			RuleReturnScope r = parser.unary();
			assertNotNull(r);
			CommonTree tree = (CommonTree) r.getTree();
			System.out.println(tree.toStringTree());
		} catch (RecognitionException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	public void testParseThisClassAtomicSubClassAxiom() {
		String input = "$thisClass subClassOf Thing";
		ANTLRStringStream antlrStringStream = new ANTLRStringStream(input);
		OPPLPatternLexer lexer = new OPPLPatternLexer(antlrStringStream);
		final TokenRewriteStream tokens = new TokenRewriteStream(lexer);
		OPPLPatternScriptParser parser = new OPPLPatternScriptParser(tokens);
		parser.setTreeAdaptor(adaptor);
		try {
			RuleReturnScope r = parser.axiom();
			assertNotNull(r);
			CommonTree tree = (CommonTree) r.getTree();
			System.out.println(tree.toStringTree());
		} catch (RecognitionException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	public void testParseExpression() {
		String input = "Thing";
		ANTLRStringStream antlrStringStream = new ANTLRStringStream(input);
		OPPLPatternLexer lexer = new OPPLPatternLexer(antlrStringStream);
		final TokenRewriteStream tokens = new TokenRewriteStream(lexer);
		OPPLPatternScriptParser parser = new OPPLPatternScriptParser(tokens);
		parser.setTreeAdaptor(adaptor);
		try {
			RuleReturnScope r = parser.expression();
			assertNotNull(r);
			CommonTree tree = (CommonTree) r.getTree();
			System.out.println(tree.toStringTree());
		} catch (RecognitionException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	public void testParsePatternReferenceAtomic() {
		String input = "$p(Thing,Nothing)";
		ANTLRStringStream antlrStringStream = new ANTLRStringStream(input);
		OPPLPatternLexer lexer = new OPPLPatternLexer(antlrStringStream);
		final TokenRewriteStream tokens = new TokenRewriteStream(lexer);
		OPPLPatternScriptParser parser = new OPPLPatternScriptParser(tokens);
		parser.setTreeAdaptor(adaptor);
		try {
			RuleReturnScope r = parser.atomic();
			assertNotNull(r);
			CommonTree tree = (CommonTree) r.getTree();
			System.out.println(tree.toStringTree());
		} catch (RecognitionException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	protected OPPLSyntaxTree parse(String input) {
		ANTLRStringStream antlrStringStream = new ANTLRStringStream(input);
		OPPLPatternLexer lexer = new OPPLPatternLexer(antlrStringStream);
		final TokenRewriteStream tokens = new TokenRewriteStream(lexer);
		OPPLPatternScriptParser parser = new OPPLPatternScriptParser(tokens);
		parser.setTreeAdaptor(adaptor);
		try {
			RuleReturnScope r = parser.pattern();
			CommonTree tree = (CommonTree) r.getTree();
			CommonTreeNodeStream nodes = new CommonTreeNodeStream(tree);
			nodes.setTokenStream(tokens); // where to find tokens
			nodes.setTreeAdaptor(adaptor);
			nodes.reset();
			// RESOLVE SYMBOLS, COMPUTE EXPRESSION TYPES
			ManchesterOWLSyntaxSimplify simplify = new ManchesterOWLSyntaxSimplify(nodes);
			simplify.setTreeAdaptor(adaptor);
			simplify.downup(tree);
			return (OPPLSyntaxTree) r.getTree();
		} catch (RecognitionException e) {
			e.printStackTrace();
			fail(e.getMessage());
			return null;
		}
	}
}
