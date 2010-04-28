package org.coode.parsers.oppl.test;

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
import org.coode.oppl.OPPLFactory;
import org.coode.parsers.ErrorListener;
import org.coode.parsers.ManchesterOWLSyntaxSimplify;
import org.coode.parsers.ManchesterOWLSyntaxTypes;
import org.coode.parsers.factory.SymbolTableFactory;
import org.coode.parsers.oppl.DefaultTypeEnforcer;
import org.coode.parsers.oppl.OPPLDefine;
import org.coode.parsers.oppl.OPPLLexer;
import org.coode.parsers.oppl.OPPLScriptParser;
import org.coode.parsers.oppl.OPPLSymbolTable;
import org.coode.parsers.oppl.OPPLSyntaxTree;
import org.coode.parsers.oppl.OPPLTypeEnforcement;
import org.coode.parsers.oppl.OPPLTypes;
import org.coode.parsers.oppl.factory.SimpleSymbolTableFactory;
import org.coode.parsers.test.ComprehensiveAxiomTestCase;
import org.coode.parsers.test.SystemErrorEcho;
import org.semanticweb.owl.apibinding.OWLManager;
import org.semanticweb.owl.model.OWLOntology;
import org.semanticweb.owl.model.OWLOntologyCreationException;
import org.semanticweb.owl.model.OWLOntologyManager;

/**
 * Test for the AST generation for OPPL
 * 
 * @author Luigi Iannone
 * 
 */
public class OPPLScriptTypesParserTest extends TestCase {
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
	private final ErrorListener listener = new SystemErrorEcho();
	private static OWLOntologyManager ONTOLOGY_MANAGER = OWLManager.createOWLOntologyManager();
	private static OWLOntology SYNTAX_ONTOLOGY;
	private final static SymbolTableFactory SYMBOL_TABLE_FACTORY = new SimpleSymbolTableFactory(
			ONTOLOGY_MANAGER);
	private static OPPLSymbolTable symtab;

	public void testSubClassQuery() {
		String query = "?x:CLASS SELECT ?x subClassOf Thing BEGIN ADD ?x subClassOf Thing END;";
		OPPLSyntaxTree parsed = this.parse(query, SYNTAX_ONTOLOGY);
		System.out.println(parsed.toStringTree());
		assertNotNull(parsed);
		assertNotNull(parsed.getOPPLContent());
		System.out.println(parsed.getOPPLContent());
	}

	static {
		try {
			ONTOLOGY_MANAGER.loadOntologyFromPhysicalURI(URI.create("http://www.co-ode.org/ontologies/pizza/2007/02/12/pizza.owl"));
			SYNTAX_ONTOLOGY = ONTOLOGY_MANAGER.loadOntology(ComprehensiveAxiomTestCase.class.getResource(
					"syntaxTest.owl").toURI());
			symtab = (OPPLSymbolTable) SYMBOL_TABLE_FACTORY.createSymbolTable();
		} catch (OWLOntologyCreationException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
	}

	public void testRegexpQuery() {
		String query = "?x:CLASS = MATCH (\".*ing\") SELECT ?x subClassOf Thing BEGIN ADD ?x subClassOf Thing END;";
		OPPLSyntaxTree parsed = this.parse(query, SYNTAX_ONTOLOGY);
		System.out.println(parsed.toStringTree());
		assertNotNull(parsed);
		assertNotNull(parsed.getOPPLContent());
		System.out.println(parsed.getOPPLContent());
	}

	public void testGeneratedVariable() {
		OWLOntology ontology;
		try {
			ontology = ONTOLOGY_MANAGER.loadOntologyFromPhysicalURI(this.getClass().getResource(
					"ondrejTest.owl").toURI());
			String query = "?x:CLASS, ?y:OBJECTPROPERTY = MATCH(\" has((\\w+)) \"), ?z:CLASS, ?feature:CLASS = create(?y.GROUPS(1)) SELECT ASSERTED ?x subClassOf ?y some ?z BEGIN REMOVE ?x subClassOf ?y some ?z, ADD ?x subClassOf !hasFeature some (?feature and !hasValue some ?z) END;";
			OPPLSyntaxTree parsed = this.parse(query, ontology);
			System.out.println(parsed.toStringTree());
			assertNotNull(parsed);
			assertNotNull(parsed.getOPPLContent());
			System.out.println(parsed.getOPPLContent());
		} catch (OWLOntologyCreationException e) {
			fail();
			e.printStackTrace();
		} catch (URISyntaxException e) {
			fail();
			e.printStackTrace();
		}
	}

	protected OPPLSyntaxTree parse(String input, OWLOntology ontology) {
		OPPLFactory opplFactory = new OPPLFactory(ONTOLOGY_MANAGER, ontology, null);
		ANTLRStringStream antlrStringStream = new ANTLRStringStream(input);
		OPPLLexer lexer = new OPPLLexer(antlrStringStream);
		final TokenRewriteStream tokens = new TokenRewriteStream(lexer);
		OPPLScriptParser parser = new OPPLScriptParser(tokens);
		parser.setTreeAdaptor(adaptor);
		try {
			RuleReturnScope r = parser.statement();
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
			OPPLDefine define = new OPPLDefine(nodes, symtab, this.listener);
			define.downup(tree);
			nodes.reset();
			ManchesterOWLSyntaxTypes mOWLTypes = new ManchesterOWLSyntaxTypes(nodes, symtab,
					this.listener);
			mOWLTypes.downup(tree);
			nodes.reset();
			OPPLTypeEnforcement typeEnforcement = new OPPLTypeEnforcement(nodes, symtab,
					new DefaultTypeEnforcer(symtab, opplFactory.getOWLEntityFactory(),
							this.listener), this.listener);
			typeEnforcement.downup(tree);
			nodes.reset();
			mOWLTypes.downup(tree);
			nodes.reset();
			OPPLTypes opplTypes = new OPPLTypes(nodes, symtab, this.listener, opplFactory);
			opplTypes.downup(tree);
			return (OPPLSyntaxTree) r.getTree();
		} catch (RecognitionException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	protected void setUp() throws Exception {
		symtab.clear();
	}
}