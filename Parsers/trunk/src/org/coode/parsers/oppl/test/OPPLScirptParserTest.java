package org.coode.parsers.oppl.test;

import junit.framework.TestCase;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.RuleReturnScope;
import org.antlr.runtime.TokenRewriteStream;
import org.antlr.runtime.tree.CommonTree;
import org.coode.parsers.oppl.OPPLLexer;
import org.coode.parsers.oppl.OPPLScriptParser;

/**
 * Test for the AST generation for OPPL
 * 
 * @author Luigi Iannone
 * 
 */
public class OPPLScirptParserTest extends TestCase {
	public void testSubClassQuery() {
		String query = "?x:CLASS SELECT ?x subClassOf Thing BEGIN ADD ?x subClassOf Thing END;";
		CommonTree parsed = this.parse(query);
		System.out.println(parsed.toStringTree());
		assertNotNull(parsed);
	}

	protected CommonTree parse(String input) {
		ANTLRStringStream antlrStringStream = new ANTLRStringStream(input);
		OPPLLexer lexer = new OPPLLexer(antlrStringStream);
		final TokenRewriteStream tokens = new TokenRewriteStream(lexer);
		OPPLScriptParser parser = new OPPLScriptParser(tokens);
		try {
			RuleReturnScope r = parser.statement();
			return (CommonTree) r.getTree();
		} catch (RecognitionException e) {
			e.printStackTrace();
			return null;
		}
	}
}
