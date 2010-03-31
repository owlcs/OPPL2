/**
 * 
 */
package org.coode.parsers.test;

import java.net.URI;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.RuleReturnScope;
import org.antlr.runtime.Token;
import org.antlr.runtime.TokenRewriteStream;
import org.antlr.runtime.TokenStream;
import org.antlr.runtime.tree.CommonErrorNode;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.CommonTreeAdaptor;
import org.antlr.runtime.tree.TreeAdaptor;
import org.coode.parsers.ManchesterOWLSyntaxLexer;
import org.coode.parsers.ManchesterOWLSyntaxParser;
import org.coode.parsers.ManchesterOWLSyntaxTree;
import org.semanticweb.owl.apibinding.OWLManager;
import org.semanticweb.owl.model.OWLOntologyCreationException;
import org.semanticweb.owl.model.OWLOntologyManager;

/**
 * @author Luigi Iannone
 * 
 */
public class TestParsing {
	public static TreeAdaptor adaptor = new CommonTreeAdaptor() {
		@Override
		public Object create(Token token) {
			return new ManchesterOWLSyntaxTree(token);
		}

		@Override
		public Object dupNode(Object t) {
			if (t == null) {
				return null;
			}
			return this.create(((ManchesterOWLSyntaxTree) t).token);
		}

		@Override
		public Object errorNode(TokenStream input, Token start, Token stop,
				RecognitionException e) {
			return new CommonErrorNode(input, start, stop, e);
		}
	};

	public static void main(String[] args) {
		OWLOntologyManager ontologyManager = OWLManager
				.createOWLOntologyManager();
		String input = "hasTopping subPropertyOf INV (hasTopping)";
		System.out.println(input);
		ManchesterOWLSyntaxLexer lexer = new ManchesterOWLSyntaxLexer(
				new ANTLRStringStream(input));
		final TokenRewriteStream tokens = new TokenRewriteStream(lexer);
		ManchesterOWLSyntaxParser parser = new ManchesterOWLSyntaxParser(tokens);
		parser.setTreeAdaptor(adaptor);
		try {
			ontologyManager
					.loadOntologyFromPhysicalURI(URI
							.create("http://www.co-ode.org/ontologies/pizza/2007/02/12/pizza.owl"));
			RuleReturnScope r = parser.main();
			CommonTree tree = (CommonTree) r.getTree();
			System.out.println(tree.toStringTree());
		} catch (RecognitionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (OWLOntologyCreationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	static void showTypes(ManchesterOWLSyntaxTree t, TokenRewriteStream tokens) {
		if (t.getEvalType() != null
				&& t.getType() != ManchesterOWLSyntaxParser.EXPRESSION) {
			System.out.printf("%-17s", tokens.toString(t.getTokenStartIndex(),
					t.getTokenStopIndex()));
			String ts = t.getEvalType().toString();
			System.out.printf(" type %-8s\n", ts);
		}
	}
}
