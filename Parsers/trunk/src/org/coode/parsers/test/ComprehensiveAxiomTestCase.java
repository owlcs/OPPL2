package org.coode.parsers.test;

import java.net.URI;
import java.net.URISyntaxException;

import junit.framework.TestCase;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.RecognizerSharedState;
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
import org.coode.parsers.ManchesterOWLSyntaxParser;
import org.coode.parsers.ManchesterOWLSyntaxSimplify;
import org.coode.parsers.ManchesterOWLSyntaxTree;
import org.coode.parsers.ManchesterOWLSyntaxTypes;
import org.coode.parsers.OWLAxiomType;
import org.coode.parsers.SymbolTable;
import org.coode.parsers.SystemErrorEcho;
import org.coode.parsers.Type;
import org.coode.parsers.factory.SimpleSymbolTableFactory;
import org.coode.parsers.factory.SymbolTableFactory;
import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLAsymmetricObjectPropertyAxiom;
import org.semanticweb.owlapi.model.OWLClassAssertionAxiom;
import org.semanticweb.owlapi.model.OWLDataPropertyAssertionAxiom;
import org.semanticweb.owlapi.model.OWLDataPropertyDomainAxiom;
import org.semanticweb.owlapi.model.OWLDataPropertyRangeAxiom;
import org.semanticweb.owlapi.model.OWLDeclarationAxiom;
import org.semanticweb.owlapi.model.OWLDifferentIndividualsAxiom;
import org.semanticweb.owlapi.model.OWLDisjointClassesAxiom;
import org.semanticweb.owlapi.model.OWLDisjointDataPropertiesAxiom;
import org.semanticweb.owlapi.model.OWLDisjointObjectPropertiesAxiom;
import org.semanticweb.owlapi.model.OWLDisjointUnionAxiom;
import org.semanticweb.owlapi.model.OWLEquivalentClassesAxiom;
import org.semanticweb.owlapi.model.OWLEquivalentDataPropertiesAxiom;
import org.semanticweb.owlapi.model.OWLEquivalentObjectPropertiesAxiom;
import org.semanticweb.owlapi.model.OWLFunctionalDataPropertyAxiom;
import org.semanticweb.owlapi.model.OWLFunctionalObjectPropertyAxiom;
import org.semanticweb.owlapi.model.OWLInverseFunctionalObjectPropertyAxiom;
import org.semanticweb.owlapi.model.OWLInverseObjectPropertiesAxiom;
import org.semanticweb.owlapi.model.OWLIrreflexiveObjectPropertyAxiom;
import org.semanticweb.owlapi.model.OWLNegativeDataPropertyAssertionAxiom;
import org.semanticweb.owlapi.model.OWLNegativeObjectPropertyAssertionAxiom;
import org.semanticweb.owlapi.model.OWLObjectPropertyAssertionAxiom;
import org.semanticweb.owlapi.model.OWLObjectPropertyDomainAxiom;
import org.semanticweb.owlapi.model.OWLObjectPropertyRangeAxiom;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;
import org.semanticweb.owlapi.model.OWLOntologyManager;
import org.semanticweb.owlapi.model.OWLReflexiveObjectPropertyAxiom;
import org.semanticweb.owlapi.model.OWLSameIndividualAxiom;
import org.semanticweb.owlapi.model.OWLSubClassOfAxiom;
import org.semanticweb.owlapi.model.OWLSubDataPropertyOfAxiom;
import org.semanticweb.owlapi.model.OWLSubObjectPropertyOfAxiom;
import org.semanticweb.owlapi.model.OWLSubPropertyChainOfAxiom;
import org.semanticweb.owlapi.model.OWLSymmetricObjectPropertyAxiom;
import org.semanticweb.owlapi.model.OWLTransitiveObjectPropertyAxiom;
import org.semanticweb.owlapi.model.SWRLRule;
import org.semanticweb.owlapi.util.OWLObjectVisitorExAdapter;

public class ComprehensiveAxiomTestCase extends TestCase {
	private static final class TypeAssociation extends
			OWLObjectVisitorExAdapter<OWLAxiomType> {
		@Override
		public OWLAxiomType visit(OWLSubClassOfAxiom axiom) {
			return OWLAxiomType.SUBCLASS;
		}

		@Override
		public OWLAxiomType visit(OWLNegativeObjectPropertyAssertionAxiom axiom) {
			return OWLAxiomType.NEGATIVE_OBJECT_PROPERTY_ASSERTION;
		}

		@Override
		public OWLAxiomType visit(OWLAsymmetricObjectPropertyAxiom axiom) {
			return OWLAxiomType.SYMMETRIC_OBJECT_PROPERTY;
		}

		@Override
		public OWLAxiomType visit(OWLReflexiveObjectPropertyAxiom axiom) {
			return OWLAxiomType.REFLEXIVE_OBJECT_PROPERTY;
		}

		@Override
		public OWLAxiomType visit(OWLDisjointClassesAxiom axiom) {
			return OWLAxiomType.DISJOINT_CLASSES;
		}

		@Override
		public OWLAxiomType visit(OWLDataPropertyDomainAxiom axiom) {
			return OWLAxiomType.DATA_PROPERTY_DOMAIN;
		}

		@Override
		public OWLAxiomType visit(OWLObjectPropertyDomainAxiom axiom) {
			return OWLAxiomType.OBJECT_PROPERTY_DOMAIN;
		}

		@Override
		public OWLAxiomType visit(OWLEquivalentObjectPropertiesAxiom axiom) {
			return OWLAxiomType.EQUIVALENT_OBJECT_PROPERTIES;
		}

		@Override
		public OWLAxiomType visit(OWLNegativeDataPropertyAssertionAxiom axiom) {
			return OWLAxiomType.NEGATIVE_DATA_PROPERTY_ASSERTION;
		}

		@Override
		public OWLAxiomType visit(OWLDifferentIndividualsAxiom axiom) {
			return OWLAxiomType.DIFFERENT_INDIVIDUALS;
		}

		@Override
		public OWLAxiomType visit(OWLDisjointDataPropertiesAxiom axiom) {
			return OWLAxiomType.DISJOINT_DATA_PROPERTIES;
		}

		@Override
		public OWLAxiomType visit(OWLDisjointObjectPropertiesAxiom axiom) {
			return OWLAxiomType.DISJOINT_OBJECT_PROPERTIES;
		}

		@Override
		public OWLAxiomType visit(OWLObjectPropertyRangeAxiom axiom) {
			return OWLAxiomType.OBJECT_PROPERTY_RANGE;
		}

		@Override
		public OWLAxiomType visit(OWLObjectPropertyAssertionAxiom axiom) {
			return OWLAxiomType.OBJECT_PROPERTY_ASSERTION;
		}

		@Override
		public OWLAxiomType visit(OWLFunctionalObjectPropertyAxiom axiom) {
			return OWLAxiomType.FUNCTIONAL_OBJECT_PROPERTY;
		}

		@Override
		public OWLAxiomType visit(OWLSubObjectPropertyOfAxiom axiom) {
			return OWLAxiomType.SUB_OBJECT_PROPERTY;
		}

		@Override
		public OWLAxiomType visit(OWLDisjointUnionAxiom axiom) {
			return null;
		}

		@Override
		public OWLAxiomType visit(OWLDeclarationAxiom axiom) {
			return null;
		}

		@Override
		public OWLAxiomType visit(OWLSymmetricObjectPropertyAxiom axiom) {
			return OWLAxiomType.SYMMETRIC_OBJECT_PROPERTY;
		}

		@Override
		public OWLAxiomType visit(OWLDataPropertyRangeAxiom axiom) {
			return OWLAxiomType.DATA_PROPERTY_RANGE;
		}

		@Override
		public OWLAxiomType visit(OWLFunctionalDataPropertyAxiom axiom) {
			return OWLAxiomType.FUNCTIONAL_DATA_PROPERTY;
		}

		@Override
		public OWLAxiomType visit(OWLEquivalentDataPropertiesAxiom axiom) {
			return OWLAxiomType.EQUIVALENT_DATA_PROPERTIES;
		}

		@Override
		public OWLAxiomType visit(OWLClassAssertionAxiom axiom) {
			return OWLAxiomType.CLASS_ASSERTION;
		}

		@Override
		public OWLAxiomType visit(OWLEquivalentClassesAxiom axiom) {
			return OWLAxiomType.EQUIVALENT_CLASSES;
		}

		@Override
		public OWLAxiomType visit(OWLDataPropertyAssertionAxiom axiom) {
			return OWLAxiomType.DATA_PROPERTY_ASSERTION;
		}

		@Override
		public OWLAxiomType visit(OWLTransitiveObjectPropertyAxiom axiom) {
			return OWLAxiomType.TRANSITIVE_OBJECT_PROPERTY;
		}

		@Override
		public OWLAxiomType visit(OWLIrreflexiveObjectPropertyAxiom axiom) {
			return OWLAxiomType.IRREFLEXIVE_OBJECT_PROPERTY;
		}

		@Override
		public OWLAxiomType visit(OWLSubDataPropertyOfAxiom axiom) {
			return OWLAxiomType.SUB_DATA_PROPERTY;
		}

		@Override
		public OWLAxiomType visit(OWLInverseFunctionalObjectPropertyAxiom axiom) {
			return OWLAxiomType.INVERSE_FUNCTIONAL_OBJECT_PROPERTY;
		}

		@Override
		public OWLAxiomType visit(OWLSameIndividualAxiom axiom) {
			return OWLAxiomType.SAME_INDIVIDUAL;
		}

		@Override
		public OWLAxiomType visit(OWLSubPropertyChainOfAxiom axiom) {
			return OWLAxiomType.PROPERTY_CHAIN_SUB_PROPERTY;
		}

		@Override
		public OWLAxiomType visit(OWLInverseObjectPropertiesAxiom axiom) {
			return OWLAxiomType.INVERSE_OBJECT_PROPERTIES;
		}

		@Override
		public OWLAxiomType visit(SWRLRule rule) {
			return null;
		}
	}

	private static OWLOntologyManager ONTOLOGY_MANAGER = OWLManager
			.createOWLOntologyManager();
	private SymbolTable symtab;
	private static TypeAssociation ASSOCOATION = new TypeAssociation();
	private final static SymbolTableFactory<SymbolTable> SYMBOL_TABLE_FACTORY = new SimpleSymbolTableFactory(
			ONTOLOGY_MANAGER);
	static {
		try {
			ONTOLOGY_MANAGER
					.loadOntology(IRI
							.create(URI
									.create("http://www.co-ode.org/ontologies/pizza/2007/02/12/pizza.owl")));
			ONTOLOGY_MANAGER.loadOntology(IRI
					.create(ComprehensiveAxiomTestCase.class.getResource(
							"syntaxTest.owl").toURI()));
		} catch (OWLOntologyCreationException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
	}
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

	protected ManchesterOWLSyntaxTree parse(String input) {
		MOWLLexer lexer = new MOWLLexer(new ANTLRStringStream(input));
		final TokenRewriteStream tokens = new TokenRewriteStream(lexer);
		ManchesterOWLSyntaxParser parser = new ManchesterOWLSyntaxParser(
				tokens, new RecognizerSharedState(), this.errorListener);
		parser.setTreeAdaptor(adaptor);
		try {
			RuleReturnScope r = parser.main();
			CommonTree tree = (CommonTree) r.getTree();
			System.out.println(tree.toStringTree());
			CommonTreeNodeStream nodes = new CommonTreeNodeStream(tree);
			nodes.setTokenStream(tokens); // where to find tokens
			nodes.setTreeAdaptor(adaptor);
			// RESOLVE SYMBOLS, COMPUTE EXPRESSION TYPES
			this.symtab.setErrorListener(this.errorListener);
			ManchesterOWLSyntaxSimplify simplify = new ManchesterOWLSyntaxSimplify(
					nodes);
			simplify.setTreeAdaptor(adaptor);
			simplify.downup(tree);
			nodes.reset();
			ManchesterOWLSyntaxTypes typeComp = new ManchesterOWLSyntaxTypes(
					nodes, this.symtab, this.errorListener);
			typeComp.downup(tree); // trigger resolve/type computation actions
			// WALK TREE TO DUMP SUBTREE TYPES
			System.out.println(tree.toStringTree());
			return (ManchesterOWLSyntaxTree) tree;
		} catch (RecognitionException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		this.symtab = SYMBOL_TABLE_FACTORY.createSymbolTable();
	}

	@Override
	protected void tearDown() throws Exception {
		this.symtab.dispose();
	}

	public void testSubClass() {
		String input = "NamedPizza subClassOf Pizza and hasTopping min 2";
		ManchesterOWLSyntaxTree parsed = this.parse(input);
		Type parseType = parsed.getEvalType();
		assertTrue("parse type " + parseType,
				parseType == OWLAxiomType.SUBCLASS);
		parseType = this
				.parse(
						"NamedPizza and hasTopping min 2 and hasTopping value Italy and aDataProperty value \"2\"^int subClassOf Pizza and hasTopping min 2 Thing")
				.getEvalType();
		assertTrue("parse type " + parseType,
				parseType == OWLAxiomType.SUBCLASS);
		parseType = this
				.parse(
						"Pizza subClassOf hasTopping some (Thing and hasTopping only PizzaTopping)")
				.getEvalType();
	}

	public void testClassAssertion() {
		ManchesterOWLSyntaxTree parsed = this
				.parse("America types NamedPizza or not (hasTopping some Pizza)");
		Type parseType = parsed.getEvalType();
		assertTrue("parse type " + parseType,
				parseType == OWLAxiomType.CLASS_ASSERTION);
		assertTrue(parsed.getOWLObject().accept(ASSOCOATION) == OWLAxiomType.CLASS_ASSERTION);
		parseType = this.parse(
				"America InstanceOf NamedPizza or not (hasTopping some Pizza)")
				.getEvalType();
		assertTrue("parse type " + parseType,
				parseType == OWLAxiomType.CLASS_ASSERTION);
	}

	public void testObjectPropertyAssertion() {
		ManchesterOWLSyntaxTree parsed = this
				.parse("America  hasTopping Italy");
		Type parseType = parsed.getEvalType();
		assertTrue("parse type " + parseType,
				parseType == OWLAxiomType.OBJECT_PROPERTY_ASSERTION);
		assertTrue(parsed.getOWLObject().accept(ASSOCOATION) == OWLAxiomType.OBJECT_PROPERTY_ASSERTION);
		parsed = this.parse("America  INV ( INV (hasTopping)) Italy");
		parseType = parsed.getEvalType();
		assertTrue("parse type " + parseType,
				parseType == OWLAxiomType.OBJECT_PROPERTY_ASSERTION);
		assertTrue(parsed.getOWLObject().accept(ASSOCOATION) == OWLAxiomType.OBJECT_PROPERTY_ASSERTION);
	}

	public void testDataPropertyAssertion() {
		ManchesterOWLSyntaxTree parsed = this
				.parse("America  aDataProperty \" Monica dei topolissimi \"^int");
		Type parseType = parsed.getEvalType();
		assertTrue("parse type " + parseType,
				parseType == OWLAxiomType.DATA_PROPERTY_ASSERTION);
		assertTrue(parsed.getOWLObject().accept(ASSOCOATION) == OWLAxiomType.DATA_PROPERTY_ASSERTION);
	}

	public void testEquivalentClass() {
		ManchesterOWLSyntaxTree parsed = this
				.parse("NamedPizza or not (hasTopping some Pizza) equivalentTo Pizza and  NamedPizza");
		Type parseType = parsed.getEvalType();
		assertTrue("parse type " + parseType,
				parseType == OWLAxiomType.EQUIVALENT_CLASSES);
		assertTrue(parsed.getOWLObject().accept(ASSOCOATION) == OWLAxiomType.EQUIVALENT_CLASSES);
		parsed = this.parse("NamedPizza  equivalentTo Pizza");
		parseType = parsed.getEvalType();
		assertTrue("parse type " + parseType,
				parseType == OWLAxiomType.EQUIVALENT_CLASSES);
		assertTrue(parsed.getOWLObject().accept(ASSOCOATION) == OWLAxiomType.EQUIVALENT_CLASSES);
	}

	public void testEquivalentClassEscapedEntities() {
		ManchesterOWLSyntaxTree parsed = this
				.parse("NamedPizza or not ('hasTopping' some Pizza) equivalentTo Pizza and  NamedPizza");
		Type parseType = parsed.getEvalType();
		assertTrue("parse type " + parseType,
				parseType == OWLAxiomType.EQUIVALENT_CLASSES);
		assertTrue(parsed.getOWLObject().accept(ASSOCOATION) == OWLAxiomType.EQUIVALENT_CLASSES);
		parsed = this.parse("NamedPizza  equivalentTo Pizza");
		parseType = parsed.getEvalType();
		assertTrue("parse type " + parseType,
				parseType == OWLAxiomType.EQUIVALENT_CLASSES);
		assertTrue(parsed.getOWLObject().accept(ASSOCOATION) == OWLAxiomType.EQUIVALENT_CLASSES);
	}

	public void testDisjointClasses() {
		ManchesterOWLSyntaxTree parsed = this
				.parse("NamedPizza or not (hasTopping some Pizza) DisjointWith Pizza and  NamedPizza");
		Type parseType = parsed.getEvalType();
		assertTrue("parse type " + parseType,
				parseType == OWLAxiomType.DISJOINT_CLASSES);
		assertTrue(parsed.getOWLObject().accept(ASSOCOATION) == OWLAxiomType.DISJOINT_CLASSES);
	}

	public void testDisjointObjectProperties() {
		ManchesterOWLSyntaxTree parsed = this
				.parse("hasTopping  DisjointWith INV (hasBase)");
		Type parseType = parsed.getEvalType();
		assertTrue("parse type " + parseType,
				parseType == OWLAxiomType.DISJOINT_OBJECT_PROPERTIES);
		assertTrue(parsed.getOWLObject().accept(ASSOCOATION) == OWLAxiomType.DISJOINT_OBJECT_PROPERTIES);
	}

	public void testDisjointDataProperties() {
		ManchesterOWLSyntaxTree parsed = this
				.parse("aDataProperty  DisjointWith aDataProperty");
		Type parseType = parsed.getEvalType();
		assertTrue("parse type " + parseType,
				parseType == OWLAxiomType.DISJOINT_DATA_PROPERTIES);
		assertTrue(parsed.getOWLObject().accept(ASSOCOATION) == OWLAxiomType.DISJOINT_DATA_PROPERTIES);
	}

	public void testEquivalentObjectProperties() {
		ManchesterOWLSyntaxTree parsed = this
				.parse("INV (hasTopping) equivalentTo INV (hasBase)");
		Type parseType = parsed.getEvalType();
		assertTrue("parse type " + parseType,
				parseType == OWLAxiomType.EQUIVALENT_OBJECT_PROPERTIES);
		assertTrue(parsed.getOWLObject().accept(ASSOCOATION) == OWLAxiomType.EQUIVALENT_OBJECT_PROPERTIES);
	}

	public void testEquivalentDataProperties() {
		ManchesterOWLSyntaxTree parsed = this
				.parse("aDataProperty equivalentTo aDataProperty");
		Type parseType = parsed.getEvalType();
		assertTrue("parse type " + parseType,
				parseType == OWLAxiomType.EQUIVALENT_DATA_PROPERTIES);
		assertTrue(parsed.getOWLObject().accept(ASSOCOATION) == OWLAxiomType.EQUIVALENT_DATA_PROPERTIES);
	}

	public void testSubObjectProperty() {
		ManchesterOWLSyntaxTree parsed = this
				.parse("hasTopping subPropertyOf hasBase");
		Type parseType = parsed.getEvalType();
		assertTrue("parse type " + parseType,
				parseType == OWLAxiomType.SUB_OBJECT_PROPERTY);
		assertTrue(parsed.getOWLObject().accept(ASSOCOATION) == OWLAxiomType.SUB_OBJECT_PROPERTY);
	}

	public void testSubDataProperty() {
		ManchesterOWLSyntaxTree parsed = this
				.parse("aDataProperty subPropertyOf aDataProperty");
		Type parseType = parsed.getEvalType();
		assertTrue("parse type " + parseType,
				parseType == OWLAxiomType.SUB_DATA_PROPERTY);
		assertTrue(parsed.getOWLObject().accept(ASSOCOATION) == OWLAxiomType.SUB_DATA_PROPERTY);
	}

	public void testDomainAxiom() {
		ManchesterOWLSyntaxTree parsed = this
				.parse("hasTopping Domain Pizza and Thing");
		Type parseType = parsed.getEvalType();
		assertTrue("parse type " + parseType,
				parseType == OWLAxiomType.OBJECT_PROPERTY_DOMAIN);
		assertTrue(parsed.getOWLObject().accept(ASSOCOATION) == OWLAxiomType.OBJECT_PROPERTY_DOMAIN);
		parsed = this.parse("aDataProperty Domain Thing and Pizza");
		parseType = parsed.getEvalType();
		assertTrue("parse type " + parseType,
				parseType == OWLAxiomType.DATA_PROPERTY_DOMAIN);
		assertTrue(parsed.getOWLObject().accept(ASSOCOATION) == OWLAxiomType.DATA_PROPERTY_DOMAIN);
	}

	public void testRangeAxiom() {
		ManchesterOWLSyntaxTree parsed = this
				.parse("hasTopping Range Pizza and Thing");
		Type parseType = parsed.getEvalType();
		assertTrue("parse type " + parseType,
				parseType == OWLAxiomType.OBJECT_PROPERTY_RANGE);
		assertTrue(parsed.getOWLObject().accept(ASSOCOATION) == OWLAxiomType.OBJECT_PROPERTY_RANGE);
		parsed = this.parse("aDataProperty Range int");
		parseType = parsed.getEvalType();
		assertTrue("parse type " + parseType,
				parseType == OWLAxiomType.DATA_PROPERTY_RANGE);
		assertTrue(parsed.getOWLObject().accept(ASSOCOATION) == OWLAxiomType.DATA_PROPERTY_RANGE);
	}

	public void testPropertyChainSubProperty() {
		ManchesterOWLSyntaxTree parsed = this
				.parse("hasTopping o hasBase subPropertyOf hasBase");
		Type parseType = parsed.getEvalType();
		assertTrue("parse type " + parseType,
				parseType == OWLAxiomType.PROPERTY_CHAIN_SUB_PROPERTY);
		assertTrue(parsed.getOWLObject().accept(ASSOCOATION) == OWLAxiomType.PROPERTY_CHAIN_SUB_PROPERTY);
	}

	public void testSameIndividuals() {
		ManchesterOWLSyntaxTree parsed = this.parse("America  sameAs Italy");
		Type parseType = parsed.getEvalType();
		assertTrue("parse type " + parseType,
				parseType == OWLAxiomType.SAME_INDIVIDUAL);
		assertTrue(parsed.getOWLObject().accept(ASSOCOATION) == OWLAxiomType.SAME_INDIVIDUAL);
	}

	public void testDifferentIndividuals() {
		ManchesterOWLSyntaxTree parsed = this
				.parse("America  differentFrom Italy");
		Type parseType = parsed.getEvalType();
		assertTrue("parse type " + parseType,
				parseType == OWLAxiomType.DIFFERENT_INDIVIDUALS);
		assertTrue(parsed.getOWLObject().accept(ASSOCOATION) == OWLAxiomType.DIFFERENT_INDIVIDUALS);
	}

	public void testFunctionalObjectProperty() {
		ManchesterOWLSyntaxTree parsed = this.parse("Functional hasBase");
		Type parseType = parsed.getEvalType();
		assertTrue("parse type " + parseType,
				parseType == OWLAxiomType.FUNCTIONAL_OBJECT_PROPERTY);
		assertTrue(parsed.getOWLObject().accept(ASSOCOATION) == OWLAxiomType.FUNCTIONAL_OBJECT_PROPERTY);
	}

	public void testFunctionalDataProperty() {
		ManchesterOWLSyntaxTree parsed = this.parse("Functional aDataProperty");
		Type parseType = parsed.getEvalType();
		assertTrue("parse type " + parseType,
				parseType == OWLAxiomType.FUNCTIONAL_DATA_PROPERTY);
		assertTrue(parsed.getOWLObject().accept(ASSOCOATION) == OWLAxiomType.FUNCTIONAL_DATA_PROPERTY);
	}

	public void testInverseFunctionalObjectProperty() {
		ManchesterOWLSyntaxTree parsed = this
				.parse("InverseFunctional hasTopping");
		Type parseType = parsed.getEvalType();
		assertTrue("parse type " + parseType,
				parseType == OWLAxiomType.INVERSE_FUNCTIONAL_OBJECT_PROPERTY);
		assertTrue(parsed.getOWLObject().accept(ASSOCOATION) == OWLAxiomType.INVERSE_FUNCTIONAL_OBJECT_PROPERTY);
	}

	public void testInverseObjectProperties() {
		ManchesterOWLSyntaxTree parsed = this
				.parse("hasTopping InverseOf hasTopping");
		Type parseType = parsed.getEvalType();
		assertTrue("parse type " + parseType,
				parseType == OWLAxiomType.INVERSE_OBJECT_PROPERTIES);
		assertTrue(parsed.getOWLObject().accept(ASSOCOATION) == OWLAxiomType.INVERSE_OBJECT_PROPERTIES);
	}

	public void testIrreflexiveObjectProperty() {
		ManchesterOWLSyntaxTree parsed = this.parse("Irreflexive hasTopping");
		Type parseType = parsed.getEvalType();
		assertTrue("parse type " + parseType,
				parseType == OWLAxiomType.IRREFLEXIVE_OBJECT_PROPERTY);
		assertTrue(parsed.getOWLObject().accept(ASSOCOATION) == OWLAxiomType.IRREFLEXIVE_OBJECT_PROPERTY);
	}

	public void testReflexiveObjectProperty() {
		ManchesterOWLSyntaxTree parsed = this.parse("Reflexive hasTopping");
		Type parseType = parsed.getEvalType();
		assertTrue("parse type " + parseType,
				parseType == OWLAxiomType.REFLEXIVE_OBJECT_PROPERTY);
		assertTrue(parsed.getOWLObject().accept(ASSOCOATION) == OWLAxiomType.REFLEXIVE_OBJECT_PROPERTY);
	}

	public void testSymmetricObjectProperty() {
		ManchesterOWLSyntaxTree parsed = this.parse("Symmetric hasTopping");
		Type parseType = parsed.getEvalType();
		assertTrue("parse type " + parseType,
				parseType == OWLAxiomType.SYMMETRIC_OBJECT_PROPERTY);
		assertTrue(parsed.getOWLObject().accept(ASSOCOATION) == OWLAxiomType.SYMMETRIC_OBJECT_PROPERTY);
	}

	public void testTransitiveObjectProperty() {
		ManchesterOWLSyntaxTree parsed = this.parse("Transitive hasTopping");
		Type parseType = parsed.getEvalType();
		assertTrue("parse type " + parseType,
				parseType == OWLAxiomType.TRANSITIVE_OBJECT_PROPERTY);
		assertTrue(parsed.getOWLObject().accept(ASSOCOATION) == OWLAxiomType.TRANSITIVE_OBJECT_PROPERTY);
	}

	public void testNegativeObjectPropertyAssertion() {
		ManchesterOWLSyntaxTree parsed = this
				.parse("not America hasTopping Italy");
		Type parseType = parsed.getEvalType();
		assertTrue("parse type " + parseType,
				parseType == OWLAxiomType.NEGATIVE_OBJECT_PROPERTY_ASSERTION);
		assertTrue(parsed.getOWLObject().accept(ASSOCOATION) == OWLAxiomType.NEGATIVE_OBJECT_PROPERTY_ASSERTION);
	}

	public void testDataRange() {
		ManchesterOWLSyntaxTree parsed = this
				.parse("Thing subClassOf aDataProperty some int [ > \"1\"]");
		Type parseType = parsed.getEvalType();
		assertTrue("parse type " + parseType,
				parseType == OWLAxiomType.SUBCLASS);
		assertTrue(parsed.getOWLObject().accept(ASSOCOATION) == OWLAxiomType.SUBCLASS);
	}

	public void testDataRangeConjuntion() {
		ManchesterOWLSyntaxTree parsed = this
				.parse("Thing subClassOf aDataProperty some (int [ > \"1\"] and int[>\"3\"])");
		Type parseType = parsed.getEvalType();
		assertTrue("parse type " + parseType,
				parseType == OWLAxiomType.SUBCLASS);
		assertTrue(parsed.getOWLObject().accept(ASSOCOATION) == OWLAxiomType.SUBCLASS);
	}

	public void testDataRangeDisjuntion() {
		ManchesterOWLSyntaxTree parsed = this
				.parse("Thing subClassOf aDataProperty some (int [ > \"1\"] or int[>\"3\"])");
		Type parseType = parsed.getEvalType();
		assertTrue("parse type " + parseType,
				parseType == OWLAxiomType.SUBCLASS);
		assertTrue(parsed.getOWLObject().accept(ASSOCOATION) == OWLAxiomType.SUBCLASS);
	}
}
