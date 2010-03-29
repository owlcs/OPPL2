/**
 * 
 */
package org.coode.oppl.syntax.test;

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
import org.antlr.runtime.tree.CommonTreeNodeStream;
import org.antlr.runtime.tree.RewriteEmptyStreamException;
import org.antlr.runtime.tree.TreeAdaptor;
import org.coode.oppl.syntax.ErrorListener;
import org.coode.oppl.syntax.ManchesterOWLSyntaxLexer;
import org.coode.oppl.syntax.ManchesterOWLSyntaxParser;
import org.coode.oppl.syntax.ManchesterOWLSyntaxTree;
import org.coode.oppl.syntax.ManchesterOWLSyntaxTypes;
import org.coode.oppl.syntax.OWLEntityCheckerScope;
import org.coode.oppl.syntax.SymbolTable;
import org.coode.oppl.syntax.Type;
import org.semanticweb.owl.apibinding.OWLManager;
import org.semanticweb.owl.expression.ShortFormEntityChecker;
import org.semanticweb.owl.model.OWLOntologyCreationException;
import org.semanticweb.owl.model.OWLOntologyManager;
import org.semanticweb.owl.util.BidirectionalShortFormProviderAdapter;
import org.semanticweb.owl.util.SimpleShortFormProvider;

/**
 * @author Luigi Iannone
 * 
 */
public class TestTypeEvaluation {
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
			System.out.println(tree.toString());
			CommonTreeNodeStream nodes = new CommonTreeNodeStream(tree);
			nodes.setTokenStream(tokens); // where to find tokens
			nodes.setTreeAdaptor(adaptor);
			// RESOLVE SYMBOLS, COMPUTE EXPRESSION TYPES
			SymbolTable symtab = new SymbolTable(new OWLEntityCheckerScope(
					new ShortFormEntityChecker(
							new BidirectionalShortFormProviderAdapter(
									ontologyManager.getOntologies(),
									new SimpleShortFormProvider()))),
					ontologyManager.getOWLDataFactory());
			symtab.setErrorListener(errorListener);
			ManchesterOWLSyntaxTypes typeComp = new ManchesterOWLSyntaxTypes(
					nodes, symtab);
			typeComp.downup(tree); // trigger resolve/type computation actions
			// WALK TREE TO DUMP SUBTREE TYPES
			System.out.println(tree.toStringTree());
		} catch (RecognitionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (OWLOntologyCreationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static ErrorListener errorListener = new ErrorListener() {
		public void unrecognisedSymbol(Token t) {
			System.err.println("Unerecognised token " + t.getText()
					+ " at line " + t.getLine() + " position "
					+ t.getCharPositionInLine());
		}

		public void incompatibleSymbolType(Token t, Type type, Token expression) {
			System.err.println("Incompatible type " + type + " for token "
					+ t.getText() + " in expression " + expression
					+ " at line " + t.getLine() + " position "
					+ t.getCharPositionInLine());
		}

		public void rewriteEmptyStreamException(RewriteEmptyStreamException e) {
			System.err.println(e.getMessage());
		}

		public void recognitionException(RecognitionException e) {
			System.err.println("Recognition exception " + e.getMessage() + " "
					+ e.getUnexpectedType());
		}

		public void illegalToken(Token t, String message) {
			System.err.println("Illegal token " + t.getText() + " at line "
					+ t.getLine() + " position " + t.getCharPositionInLine()
					+ ": " + message);
		}

		public void incompatibleSymbols(Token parentExpression, Token... tokens) {
			StringBuilder message = new StringBuilder(
					"Incompatible children in " + parentExpression.getText());
			boolean first = true;
			for (Token token : tokens) {
				String comma = first ? "" : ", ";
				message.append(comma);
				first = false;
				message.append(token.getText());
			}
			System.err.println(message);
		}
	};
}
