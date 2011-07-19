package org.coode.parsers.oppl.test;

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
import org.coode.oppl.ConstraintSystem;
import org.coode.oppl.OPPLFactory;
import org.coode.parsers.ErrorListener;
import org.coode.parsers.ManchesterOWLSyntaxSimplify;
import org.coode.parsers.ManchesterOWLSyntaxTypes;
import org.coode.parsers.common.SystemErrorEcho;
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
import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;
import org.semanticweb.owlapi.model.OWLOntologyManager;

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
	protected static OWLOntology PIZZA_ONTOLOGY;
	protected static OWLOntology SYNTAX_ONTOLOGY;
	protected static OWLOntology TEST_ONTOLOGY;
	private final static SymbolTableFactory<OPPLSymbolTable> SYMBOL_TABLE_FACTORY = new SimpleSymbolTableFactory(
			ONTOLOGY_MANAGER);
	private OPPLSymbolTable symtab;

	public void testSubClassQuery() {
		String query = "?x:CLASS SELECT ?x subClassOf Thing BEGIN ADD ?x subClassOf Thing END;";
		OPPLSyntaxTree parsed = this.parse(query, SYNTAX_ONTOLOGY);
		System.out.println(parsed.toStringTree());
		assertNotNull(parsed);
		assertNotNull(parsed.getOPPLContent());
		System.out.println("original script: \t" + query);
		System.out.println("parsed content:  \t" + parsed.getOPPLContent());
	}

	static {
		try {
			PIZZA_ONTOLOGY = ONTOLOGY_MANAGER.loadOntology(IRI.create("http://www.co-ode.org/ontologies/pizza/2007/02/12/pizza.owl"));
			SYNTAX_ONTOLOGY = ONTOLOGY_MANAGER.loadOntology(IRI.create(OPPLScriptParserTest.class.getResource(
					"syntaxTest.owl").toURI()));
			TEST_ONTOLOGY = ONTOLOGY_MANAGER.loadOntology(IRI.create(OPPLScriptParserTest.class.getResource(
					"test.owl").toURI()));
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
		System.out.println("original script: \t" + query);
		System.out.println("parsed content:  \t" + parsed.getOPPLContent());
	}

	public void testAggregateVaraibleValuesAndLooseObjects() {
		String query = "?x:CLASS, ?y:CLASS = createIntersection(?x.VALUES,Thing)  SELECT ?x subClassOf Thing BEGIN ADD ?x subClassOf Thing END;";
		OPPLSyntaxTree parsed = this.parse(query, SYNTAX_ONTOLOGY);
		System.out.println(parsed.toStringTree());
		assertNotNull(parsed);
		assertNotNull(parsed.getOPPLContent());
		System.out.println("original script: \t" + query);
		System.out.println("parsed content:  \t" + parsed.getOPPLContent());
	}

	public void testGeneratedVariable() {
		OWLOntology ontology;
		try {
			ontology = ONTOLOGY_MANAGER.loadOntology(IRI.create(this.getClass().getResource(
					"ondrejTest.owl").toURI()));
			String query = "?x:CLASS, ?y:OBJECTPROPERTY = MATCH(\" has((\\w+)) \"), ?z:CLASS, ?feature:CLASS = create(?y.GROUPS(1)) SELECT ASSERTED ?x subClassOf ?y some ?z BEGIN REMOVE ?x subClassOf ?y some ?z, ADD ?x subClassOf !hasFeature some (?feature and !hasValue some ?z) END;";
			OPPLSyntaxTree parsed = this.parse(query, ontology);
			System.out.println(parsed.toStringTree());
			assertNotNull(parsed);
			assertNotNull(parsed.getOPPLContent());
			System.out.println("original script: \t" + query);
			System.out.println("parsed content:  \t" + parsed.getOPPLContent());
			ONTOLOGY_MANAGER.removeOntology(ontology);
		} catch (OWLOntologyCreationException e) {
			e.printStackTrace();
			fail(e.getMessage());
		} catch (URISyntaxException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	protected OPPLSyntaxTree parse(String input, OWLOntology ontology) {
		OPPLFactory opplFactory = new OPPLFactory(ONTOLOGY_MANAGER, ontology, null);
		ConstraintSystem constraintSystem = opplFactory.createConstraintSystem();
		ANTLRStringStream antlrStringStream = new ANTLRStringStream(input);
		OPPLLexer lexer = new OPPLLexer(antlrStringStream);
		final TokenRewriteStream tokens = new TokenRewriteStream(lexer);
		OPPLScriptParser parser = new OPPLScriptParser(tokens, this.listener);
		parser.setTreeAdaptor(adaptor);
		try {
			RuleReturnScope r = parser.statement();
			CommonTree tree = (CommonTree) r.getTree();
			if (tree != null) {
				CommonTreeNodeStream nodes = new CommonTreeNodeStream(tree);
				nodes.setTokenStream(tokens); // where to find tokens
				nodes.setTreeAdaptor(adaptor);
				nodes.reset();
				// RESOLVE SYMBOLS, COMPUTE EXPRESSION TYPES
				ManchesterOWLSyntaxSimplify simplify = new ManchesterOWLSyntaxSimplify(nodes);
				simplify.setTreeAdaptor(adaptor);
				simplify.downup(tree);
				nodes.reset();
				OPPLDefine define = new OPPLDefine(nodes, this.symtab, this.listener,
						constraintSystem);
				define.setTreeAdaptor(adaptor);
				define.downup(tree);
				nodes.reset();
				ManchesterOWLSyntaxTypes mOWLTypes = new ManchesterOWLSyntaxTypes(nodes,
						this.symtab, this.listener);
				mOWLTypes.downup(tree);
				nodes.reset();
				OPPLTypeEnforcement typeEnforcement = new OPPLTypeEnforcement(nodes, this.symtab,
						new DefaultTypeEnforcer(this.symtab, opplFactory.getOWLEntityFactory(),
								this.listener), this.listener);
				typeEnforcement.downup(tree);
				nodes.reset();
				mOWLTypes.downup(tree);
				nodes.reset();
				OPPLTypes opplTypes = new OPPLTypes(nodes, this.symtab, this.listener,
						constraintSystem, opplFactory);
				opplTypes.downup(tree);
			}
			return (OPPLSyntaxTree) r.getTree();
		} catch (RecognitionException e) {
			e.printStackTrace();
			return null;
		}
	}

	public void testCreateIndividual() {
		OWLOntology ontology;
		try {
			ontology = ONTOLOGY_MANAGER.loadOntology(IRI.create(this.getClass().getResource(
					"ondrejTest.owl").toURI()));
			String query = "?x:CLASS, ?y:INDIVIDUAL = create(?x.RENDERING+\"Instance\") SELECT ASSERTED ?x subClassOf Pizza BEGIN REMOVE ?y types ?x END;";
			OPPLSyntaxTree parsed = this.parse(query, ontology);
			System.out.println(parsed.toStringTree());
			assertNotNull(parsed);
			assertNotNull(parsed.getOPPLContent());
			System.out.println("original script: \t" + query);
			System.out.println("parsed content:  \t" + parsed.getOPPLContent());
			ONTOLOGY_MANAGER.removeOntology(ontology);
		} catch (OWLOntologyCreationException e) {
			e.printStackTrace();
			fail(e.getMessage());
		} catch (URISyntaxException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	public void testHasKey() {
		String query = "?x:CLASS SELECT ?x HasKey hasTopping Thing BEGIN ADD ?x subClassOf Thing END;";
		OPPLSyntaxTree parsed = this.parse(query, PIZZA_ONTOLOGY);
		System.out.println(parsed.toStringTree());
		assertNotNull(parsed);
		assertNotNull(parsed.getOPPLContent());
		System.out.println("original script: \t" + query);
		System.out.println("parsed content:  \t" + parsed.getOPPLContent());
	}

	public void testAnnotationAssertionsInQuery() {
		String query = "?x:CLASS SELECT <blah#Luigi> label \"aLabel\" BEGIN ADD ?x subClassOf Thing END;";
		OPPLSyntaxTree parsed = this.parse(query, PIZZA_ONTOLOGY);
		System.out.println(parsed.toStringTree());
		assertNotNull(parsed);
		assertNotNull(parsed.getOPPLContent());
		System.out.println("original script: \t" + query);
		System.out.println("parsed content:  \t" + parsed.getOPPLContent());
	}

	public void testAnnotationAssertionsInActions() {
		String query = "?x:CLASS SELECT ?x subClassOf Thing  BEGIN ADD <blah#Luigi> label \"aLabel\" END;";
		OPPLSyntaxTree parsed = this.parse(query, PIZZA_ONTOLOGY);
		System.out.println(parsed.toStringTree());
		assertNotNull(parsed);
		assertNotNull(parsed.getOPPLContent());
		System.out.println("original script: \t" + query);
		System.out.println("parsed content:  \t" + parsed.getOPPLContent());
	}

	public void testSubClassQueryNAryAxiom() {
		String query = "?x:CLASS SELECT DisjointClasses set(Thing, Nothing) BEGIN ADD ?x subClassOf Thing END;";
		OPPLSyntaxTree parsed = this.parse(query, PIZZA_ONTOLOGY);
		System.out.println(parsed.toStringTree());
		assertNotNull(parsed);
		assertNotNull(parsed.getOPPLContent());
		System.out.println("original script: \t" + query);
		System.out.println("parsed content:  \t" + parsed.getOPPLContent());
	}

	public void testSubClassQueryNAryAxiomVariableValues() {
		String query = "?x:CLASS SELECT DisjointClasses: set(?x.VALUES, Thing) BEGIN ADD ?x subClassOf Thing END;";
		OPPLSyntaxTree parsed = this.parse(query, PIZZA_ONTOLOGY);
		System.out.println(parsed.toStringTree());
		assertNotNull(parsed);
		assertNotNull(parsed.getOPPLContent());
		System.out.println("original script: \t" + query);
		System.out.println("parsed content:  \t" + parsed.getOPPLContent());
	}

	public void testVariableIRIAttribute() {
		String query = "?x:CLASS SELECT ?x.IRI label \"aLabel\" BEGIN ADD ?x subClassOf Thing END;";
		OPPLSyntaxTree parsed = this.parse(query, PIZZA_ONTOLOGY);
		System.out.println(parsed.toStringTree());
		assertNotNull(parsed);
		assertNotNull(parsed.getOPPLContent());
		System.out.println("original script: \t" + query);
		System.out.println("parsed content:  \t" + parsed.getOPPLContent());
	}

	public void testNoQuery() {
		String query = "?x:CLASS BEGIN ADD ?x subClassOf Thing END;";
		OPPLSyntaxTree parsed = this.parse(query, PIZZA_ONTOLOGY);
		System.out.println(parsed.toStringTree());
		assertNotNull(parsed);
		assertNotNull(parsed.getOPPLContent());
		System.out.println("original script: \t" + query);
		System.out.println("parsed content:  \t" + parsed.getOPPLContent());
	}

	public void testNoVariablesQuery() {
		String query = "BEGIN ADD Nothing subClassOf Thing, REMOVE Thing subClassOf Nothing END;";
		OPPLSyntaxTree parsed = this.parse(query, PIZZA_ONTOLOGY);
		System.out.println(parsed.toStringTree());
		assertNotNull(parsed);
		assertNotNull(parsed.getOPPLContent());
		System.out.println("original script: \t" + query);
		System.out.println("parsed content:  \t" + parsed.getOPPLContent());
	}

	public void testVariableAnnotationObject() {
		String query = "?x:CLASS, ?y:CONSTANT SELECT ?x.IRI label ?y BEGIN ADD ?x subClassOf  Thing END;";
		OPPLSyntaxTree parsed = this.parse(query, PIZZA_ONTOLOGY);
		System.out.println(parsed.toStringTree());
		assertNotNull(parsed);
		assertNotNull(parsed.getOPPLContent());
		System.out.println("original script: \t" + query);
		System.out.println("parsed content:  \t" + parsed.getOPPLContent());
	}

	public void testNominalClassVariableValues() {
		String query = "?x:INDIVIDUAL,?sibling:CLASS = {?x }, ?siblingUnion:CLASS = createUnion(?sibling.VALUES) SELECT Robert hasSibling ?x BEGIN ADD Robert types  ?siblingUnion END;";
		try {
			OWLOntology ontology = ONTOLOGY_MANAGER.loadOntologyFromOntologyDocument(this.getClass().getResourceAsStream(
					"siblings.owl"));
			OPPLSyntaxTree parsed = this.parse(query, ontology);
			System.out.println(parsed.toStringTree());
			assertNotNull(parsed);
			assertNotNull(parsed.getOPPLContent());
			System.out.println("original script: \t" + query);
			System.out.println("parsed content:  \t" + parsed.getOPPLContent());
			ONTOLOGY_MANAGER.removeOntology(ontology);
		} catch (OWLOntologyCreationException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	public void testLowerCase() {
		String query = "?x:CLASS=create(\"BLA\".toLowerCase) SELECT ?x subClassOf Thing BEGIN ADD ?x subClassOf Thing END;";
		OPPLSyntaxTree parsed = this.parse(query, PIZZA_ONTOLOGY);
		assertNotNull(parsed);
		System.out.println("original script: \t" + query);
		System.out.println("parsed content:  \t" + parsed.getOPPLContent());
		assertNotNull(parsed.getOPPLContent());
	}

	public void testUpperCase() {
		String query = "?x:CLASS=create(\"BLA\".toUpperCase) SELECT ?x subClassOf Thing BEGIN ADD ?x subClassOf Thing END;";
		OPPLSyntaxTree parsed = this.parse(query, PIZZA_ONTOLOGY);
		assertNotNull(parsed);
		System.out.println("original script: \t" + query);
		System.out.println("parsed content:  \t" + parsed.getOPPLContent());
		assertNotNull(parsed.getOPPLContent());
	}

	public void testLowerCaseInConcat() {
		String query = "?x:CLASS, ?y:CLASS=create(?x.RENDERING +\"_\"+\"BLA\".toLowerCase) SELECT ?x subClassOf Thing BEGIN ADD ?x subClassOf Thing END;";
		OPPLSyntaxTree parsed = this.parse(query, PIZZA_ONTOLOGY);
		assertNotNull(parsed);
		System.out.println("original script: \t" + query);
		System.out.println("parsed content:  \t" + parsed.getOPPLContent());
		assertNotNull(parsed.getOPPLContent());
	}

	public void testLowerCaseInConcatWithGroups() {
		String query = "?x:CLASS = MATCH(\"(.+)Topping\"), ?y:CLASS=create(\"Topping_\"+ ?x.GROUPS(1).toLowerCase) SELECT ?x subClassOf Thing BEGIN ADD ?x subClassOf Thing END;";
		OPPLSyntaxTree parsed = this.parse(query, PIZZA_ONTOLOGY);
		assertNotNull(parsed);
		System.out.println("original script: \t" + query);
		System.out.println("parsed content:  \t" + parsed.getOPPLContent());
		assertNotNull(parsed.getOPPLContent());
	}

	public void testUpperCaseInConcatWithGroups() {
		String query = "?x:CLASS = MATCH(\"(.+)Topping\"), ?y:CLASS=create(\"Topping_\"+ ?x.GROUPS(1).toUpperCase) SELECT ?x subClassOf Thing BEGIN ADD ?x subClassOf Thing END;";
		OPPLSyntaxTree parsed = this.parse(query, PIZZA_ONTOLOGY);
		assertNotNull(parsed);
		System.out.println("original script: \t" + query);
		System.out.println("parsed content:  \t" + parsed.getOPPLContent());
		assertNotNull(parsed.getOPPLContent());
	}

	public void testUpperCaseInConcat() {
		String query = "?x:CLASS, ?y:CLASS=create(?x.RENDERING +\"_\"+\"BLA\".toUpperCase) SELECT ?x subClassOf Thing BEGIN ADD ?x subClassOf Thing END;";
		OPPLSyntaxTree parsed = this.parse(query, PIZZA_ONTOLOGY);
		assertNotNull(parsed);
		System.out.println("original script: \t" + query);
		System.out.println("parsed content:  \t" + parsed.getOPPLContent());
		assertNotNull(parsed.getOPPLContent());
	}

	@Override
	protected void setUp() throws Exception {
		this.symtab = SYMBOL_TABLE_FACTORY.createSymbolTable();
		this.symtab.setErrorListener(this.listener);
	}

	@Override
	protected void tearDown() throws Exception {
		this.symtab.dispose();
	}
}
