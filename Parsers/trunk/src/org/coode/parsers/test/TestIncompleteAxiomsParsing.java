/**
 * 
 */
package org.coode.parsers.test;

import java.net.URI;
import java.net.URISyntaxException;

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
import org.coode.parsers.MOWLLexer;
import org.coode.parsers.ManchesterOWLSyntaxAutoCompleteCombinedParser;
import org.coode.parsers.ManchesterOWLSyntaxSimplify;
import org.coode.parsers.ManchesterOWLSyntaxTree;
import org.coode.parsers.SymbolTable;
import org.coode.parsers.factory.SimpleSymbolTableFactory;
import org.coode.parsers.factory.SymbolTableFactory;
import org.semanticweb.owl.apibinding.OWLManager;
import org.semanticweb.owl.model.OWLOntologyCreationException;
import org.semanticweb.owl.model.OWLOntologyManager;

/**
 * @author Luigi Iannone
 * 
 */
public class TestIncompleteAxiomsParsing extends TestCase {
	private static OWLOntologyManager ONTOLOGY_MANAGER = OWLManager
			.createOWLOntologyManager();
	private final static SymbolTableFactory SYMBOL_TABLE_FACTORY = new SimpleSymbolTableFactory(
			ONTOLOGY_MANAGER);
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
	private ErrorListener errorListener = new SystemErrorEcho();
	private static SymbolTable symtab;
	static {
		try {
			ONTOLOGY_MANAGER
					.loadOntologyFromPhysicalURI(URI
							.create("http://www.co-ode.org/ontologies/pizza/2007/02/12/pizza.owl"));
			ONTOLOGY_MANAGER.loadOntology(ComprehensiveAxiomTestCase.class
					.getResource("syntaxTest.owl").toURI());
			symtab = SYMBOL_TABLE_FACTORY.createSymbolTable();
		} catch (OWLOntologyCreationException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
	}

	protected ManchesterOWLSyntaxTree parse(String input) {
		MOWLLexer lexer = new MOWLLexer(new ANTLRStringStream(input));
		final TokenRewriteStream tokens = new TokenRewriteStream(lexer);
		ManchesterOWLSyntaxAutoCompleteCombinedParser parser = new ManchesterOWLSyntaxAutoCompleteCombinedParser(
				tokens);
		parser.setTreeAdaptor(adaptor);
		try {
			RuleReturnScope r = parser.main();
			CommonTree tree = (CommonTree) r.getTree();
			CommonTreeNodeStream nodes = new CommonTreeNodeStream(tree);
			nodes.setTokenStream(tokens); // where to find tokens
			nodes.setTreeAdaptor(adaptor);
			symtab.setErrorListener(this.errorListener);
			ManchesterOWLSyntaxSimplify simplify = new ManchesterOWLSyntaxSimplify(
					nodes);
			simplify.setTreeAdaptor(adaptor);
			simplify.downup(tree);
			nodes.reset();
			return (ManchesterOWLSyntaxTree) tree;
		} catch (RecognitionException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		symtab.clear();
	}

	public void testSubClassAxiom() {
		ManchesterOWLSyntaxTree parsed = this
				.parse("Pizza subClassOf NamedPizza and");
		assertNotNull(parsed);
		System.out.println(parsed.toStringTree());
	}

	public void testIncompleteStandaloneExpression() {
		ManchesterOWLSyntaxTree parsed = this.parse("NamedPizza and Pizza s");
		assertNotNull(parsed);
		System.out.println(parsed.toStringTree());
	}
}
