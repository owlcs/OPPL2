package org.coode.oppl.syntax.test;

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
import org.coode.oppl.syntax.BidirectionalShortFormProviderAdapter;
import org.coode.oppl.syntax.ErrorListener;
import org.coode.oppl.syntax.ManchesterOWLSyntaxLexer;
import org.coode.oppl.syntax.ManchesterOWLSyntaxParser;
import org.coode.oppl.syntax.ManchesterOWLSyntaxSimplify;
import org.coode.oppl.syntax.ManchesterOWLSyntaxTree;
import org.coode.oppl.syntax.ManchesterOWLSyntaxTypes;
import org.coode.oppl.syntax.OWLAxiomType;
import org.coode.oppl.syntax.OWLEntityCheckerScope;
import org.coode.oppl.syntax.SymbolTable;
import org.coode.oppl.syntax.Type;
import org.semanticweb.owl.apibinding.OWLManager;
import org.semanticweb.owl.expression.ShortFormEntityChecker;
import org.semanticweb.owl.model.OWLAntiSymmetricObjectPropertyAxiom;
import org.semanticweb.owl.model.OWLAxiomAnnotationAxiom;
import org.semanticweb.owl.model.OWLClassAssertionAxiom;
import org.semanticweb.owl.model.OWLDataPropertyAssertionAxiom;
import org.semanticweb.owl.model.OWLDataPropertyDomainAxiom;
import org.semanticweb.owl.model.OWLDataPropertyRangeAxiom;
import org.semanticweb.owl.model.OWLDataSubPropertyAxiom;
import org.semanticweb.owl.model.OWLDeclarationAxiom;
import org.semanticweb.owl.model.OWLDifferentIndividualsAxiom;
import org.semanticweb.owl.model.OWLDisjointClassesAxiom;
import org.semanticweb.owl.model.OWLDisjointDataPropertiesAxiom;
import org.semanticweb.owl.model.OWLDisjointObjectPropertiesAxiom;
import org.semanticweb.owl.model.OWLDisjointUnionAxiom;
import org.semanticweb.owl.model.OWLEntityAnnotationAxiom;
import org.semanticweb.owl.model.OWLEquivalentClassesAxiom;
import org.semanticweb.owl.model.OWLEquivalentDataPropertiesAxiom;
import org.semanticweb.owl.model.OWLEquivalentObjectPropertiesAxiom;
import org.semanticweb.owl.model.OWLFunctionalDataPropertyAxiom;
import org.semanticweb.owl.model.OWLFunctionalObjectPropertyAxiom;
import org.semanticweb.owl.model.OWLImportsDeclaration;
import org.semanticweb.owl.model.OWLInverseFunctionalObjectPropertyAxiom;
import org.semanticweb.owl.model.OWLInverseObjectPropertiesAxiom;
import org.semanticweb.owl.model.OWLIrreflexiveObjectPropertyAxiom;
import org.semanticweb.owl.model.OWLNegativeDataPropertyAssertionAxiom;
import org.semanticweb.owl.model.OWLNegativeObjectPropertyAssertionAxiom;
import org.semanticweb.owl.model.OWLObject;
import org.semanticweb.owl.model.OWLObjectPropertyAssertionAxiom;
import org.semanticweb.owl.model.OWLObjectPropertyChainSubPropertyAxiom;
import org.semanticweb.owl.model.OWLObjectPropertyDomainAxiom;
import org.semanticweb.owl.model.OWLObjectPropertyRangeAxiom;
import org.semanticweb.owl.model.OWLObjectSubPropertyAxiom;
import org.semanticweb.owl.model.OWLOntologyAnnotationAxiom;
import org.semanticweb.owl.model.OWLOntologyCreationException;
import org.semanticweb.owl.model.OWLOntologyManager;
import org.semanticweb.owl.model.OWLReflexiveObjectPropertyAxiom;
import org.semanticweb.owl.model.OWLSameIndividualsAxiom;
import org.semanticweb.owl.model.OWLSubClassAxiom;
import org.semanticweb.owl.model.OWLSymmetricObjectPropertyAxiom;
import org.semanticweb.owl.model.OWLTransitiveObjectPropertyAxiom;
import org.semanticweb.owl.model.SWRLRule;
import org.semanticweb.owl.model.utils.DefaultOWLObjectVisitorEx;
import org.semanticweb.owl.util.SimpleShortFormProvider;

public class ComprehensiveAxiomTestCase extends TestCase {
	private static final class TypeAssociation extends
			DefaultOWLObjectVisitorEx<OWLAxiomType> {
		@Override
		protected OWLAxiomType doDefault(OWLObject owlObject) {
			return null;
		}

		@Override
		public OWLAxiomType visit(OWLSubClassAxiom axiom) {
			return OWLAxiomType.SUBCLASS;
		}

		@Override
		public OWLAxiomType visit(OWLNegativeObjectPropertyAssertionAxiom axiom) {
			return OWLAxiomType.NEGATIVE_OBJECT_PROPERTY_ASSERTION;
		}

		@Override
		public OWLAxiomType visit(OWLAntiSymmetricObjectPropertyAxiom axiom) {
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
		public OWLAxiomType visit(OWLImportsDeclaration axiom) {
			return null;
		}

		@Override
		public OWLAxiomType visit(OWLAxiomAnnotationAxiom axiom) {
			return null;
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
		public OWLAxiomType visit(OWLObjectSubPropertyAxiom axiom) {
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
		public OWLAxiomType visit(OWLEntityAnnotationAxiom axiom) {
			return null;
		}

		@Override
		public OWLAxiomType visit(OWLOntologyAnnotationAxiom axiom) {
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
		public OWLAxiomType visit(OWLDataSubPropertyAxiom axiom) {
			return OWLAxiomType.SUB_DATA_PROPERTY;
		}

		@Override
		public OWLAxiomType visit(OWLInverseFunctionalObjectPropertyAxiom axiom) {
			return OWLAxiomType.INVERSE_FUNCTIONAL_OBJECT_PROPERTY;
		}

		@Override
		public OWLAxiomType visit(OWLSameIndividualsAxiom axiom) {
			return OWLAxiomType.SAME_INDIVIDUAL;
		}

		@Override
		public OWLAxiomType visit(OWLObjectPropertyChainSubPropertyAxiom axiom) {
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
	private static SymbolTable symtab;
	private static TypeAssociation ASSOCOATION = new TypeAssociation();
	static {
		try {
			ONTOLOGY_MANAGER
					.loadOntologyFromPhysicalURI(URI
							.create("http://www.co-ode.org/ontologies/pizza/2007/02/12/pizza.owl"));
			ONTOLOGY_MANAGER.loadOntology(ComprehensiveAxiomTestCase.class
					.getResource("syntaxTest.owl").toURI());
			symtab = new SymbolTable(new OWLEntityCheckerScope(
					new ShortFormEntityChecker(
							new BidirectionalShortFormProviderAdapter(
									ONTOLOGY_MANAGER.getOntologies(),
									new SimpleShortFormProvider()))),
					ONTOLOGY_MANAGER.getOWLDataFactory());
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
	public static ErrorListener errorListener = new ErrorListener() {
		public void unrecognisedSymbol(Token t) {
			System.err.println("Unerecognised token " + t.getText()
					+ " at line " + t.getLine() + " position "
					+ t.getCharPositionInLine());
		}

		public void incompatibleSymbolType(Token t, Type type, Token expression) {
			System.err.println("Incompatible type " + type + " for token "
					+ t.getText() + " in expression " + expression.getText()
					+ " at line " + t.getLine() + " position "
					+ t.getCharPositionInLine());
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
				String comma = first ? " " : ", ";
				message.append(comma);
				first = false;
				message.append(token.getText());
			}
			System.err.println(message);
		}
	};

	protected ManchesterOWLSyntaxTree parse(String input) {
		ManchesterOWLSyntaxLexer lexer = new ManchesterOWLSyntaxLexer(
				new ANTLRStringStream(input));
		final TokenRewriteStream tokens = new TokenRewriteStream(lexer);
		ManchesterOWLSyntaxParser parser = new ManchesterOWLSyntaxParser(tokens);
		parser.setTreeAdaptor(adaptor);
		try {
			RuleReturnScope r = parser.main();
			CommonTree tree = (CommonTree) r.getTree();
			System.out.println(tree.toStringTree());
			CommonTreeNodeStream nodes = new CommonTreeNodeStream(tree);
			nodes.setTokenStream(tokens); // where to find tokens
			nodes.setTreeAdaptor(adaptor);
			// RESOLVE SYMBOLS, COMPUTE EXPRESSION TYPES
			symtab.setErrorListener(errorListener);
			ManchesterOWLSyntaxSimplify simplify = new ManchesterOWLSyntaxSimplify(
					nodes);
			simplify.setTreeAdaptor(adaptor);
			simplify.downup(tree);
			nodes.reset();
			ManchesterOWLSyntaxTypes typeComp = new ManchesterOWLSyntaxTypes(
					nodes, symtab);
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
		symtab.clear();
	};

	public void testSubClass() {
		ManchesterOWLSyntaxTree parsed = this
				.parse("NamedPizza subClassOf Pizza and hasTopping min 2");
		Type parseType = parsed.getEvalType();
		assertTrue("parse type " + parseType,
				parseType == OWLAxiomType.SUBCLASS);
		parseType = this
				.parse(
						"NamedPizza and hasTopping min 2 and hasTopping value Italy and aDataProperty value \"2\"^int subClassOf Pizza and hasTopping min 2 Thing")
				.getEvalType();
		assertTrue("parse type " + parseType,
				parseType == OWLAxiomType.SUBCLASS);
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
}
