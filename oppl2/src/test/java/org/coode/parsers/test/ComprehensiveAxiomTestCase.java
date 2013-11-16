package org.coode.parsers.test;

import static org.coode.oppl.testontologies.TestOntologies.*;
import static org.coode.parsers.oppl.test.SymbolTables.*;
import static org.junit.Assert.assertTrue;

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
import org.coode.parsers.Type;
import org.coode.parsers.common.SilentListener;
import org.junit.Test;

@SuppressWarnings("javadoc")
public class ComprehensiveAxiomTestCase {
    private SymbolTable symbolTable = getSymbolTable(pizza);
    private static TypeAssociation ASSOCOATION = new TypeAssociation();
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
    private ErrorListener errorListener = new SilentListener();

    protected ManchesterOWLSyntaxTree parse(String input, SymbolTable symbolTable) {
        MOWLLexer lexer = new MOWLLexer(new ANTLRStringStream(input));
        final TokenRewriteStream tokens = new TokenRewriteStream(lexer);
        ManchesterOWLSyntaxParser parser = new ManchesterOWLSyntaxParser(tokens,
                new RecognizerSharedState(), errorListener);
        parser.setTreeAdaptor(adaptor);
        RuleReturnScope r;
        try {
            r = parser.main();
        } catch (RecognitionException e) {
            throw new RuntimeException(e);
        }
        CommonTree tree = (CommonTree) r.getTree();
        CommonTreeNodeStream nodes = new CommonTreeNodeStream(tree);
        nodes.setTokenStream(tokens); // where to find tokens
        nodes.setTreeAdaptor(adaptor);
        // RESOLVE SYMBOLS, COMPUTE EXPRESSION TYPES
        ManchesterOWLSyntaxSimplify simplify = new ManchesterOWLSyntaxSimplify(nodes);
        simplify.setTreeAdaptor(adaptor);
        simplify.downup(tree);
        nodes.reset();
        ManchesterOWLSyntaxTypes typeComp = new ManchesterOWLSyntaxTypes(nodes,
                symbolTable, errorListener);
        typeComp.downup(tree); // trigger resolve/type computation actions
        return (ManchesterOWLSyntaxTree) tree;
    }

    @Test
    public void testSubClass() {
        symbolTable = getOPPLSymbolTable(managerForPizzaAndSyntax);
        String input = "NamedPizza subClassOf Pizza and hasTopping min 2";
        ManchesterOWLSyntaxTree parsed = parse(input, symbolTable);
        Type parseType = parsed.getEvalType();
        assertTrue("parse type " + parseType, parseType == OWLAxiomType.SUBCLASS);
        parseType = parse(
                "NamedPizza and hasTopping min 2 and hasTopping value Italy and aDataProperty value \"2\"^int subClassOf Pizza and hasTopping min 2 Thing",
                symbolTable).getEvalType();
        assertTrue("parse type " + parseType, parseType == OWLAxiomType.SUBCLASS);
        parseType = parse(
                "Pizza subClassOf hasTopping some (Thing and hasTopping only PizzaTopping)",
                symbolTable).getEvalType();
        // Change keyword case
    }

    @Test
    public void testClassAssertion() {
        ManchesterOWLSyntaxTree parsed = parse(
                "America types NamedPizza or not (hasTopping some Pizza)", symbolTable);
        Type parseType = parsed.getEvalType();
        assertTrue("parse type " + parseType, parseType == OWLAxiomType.CLASS_ASSERTION);
        assertTrue(parsed.getOWLObject().accept(ASSOCOATION) == OWLAxiomType.CLASS_ASSERTION);
        parseType = parse("America InstanceOf NamedPizza or not (hasTopping some Pizza)",
                symbolTable).getEvalType();
        assertTrue("parse type " + parseType, parseType == OWLAxiomType.CLASS_ASSERTION);
        parseType = parse("America Type NamedPizza or not (hasTopping some Pizza)",
                symbolTable).getEvalType();
        assertTrue("parse type " + parseType, parseType == OWLAxiomType.CLASS_ASSERTION);
    }

    @Test
    public void testObjectPropertyAssertion() {
        ManchesterOWLSyntaxTree parsed = parse("America  hasTopping Italy", symbolTable);
        Type parseType = parsed.getEvalType();
        assertTrue("parse type " + parseType,
                parseType == OWLAxiomType.OBJECT_PROPERTY_ASSERTION);
        assertTrue(parsed.getOWLObject().accept(ASSOCOATION) == OWLAxiomType.OBJECT_PROPERTY_ASSERTION);
        parsed = parse("America  INV ( INV (hasTopping)) Italy", symbolTable);
        parseType = parsed.getEvalType();
        assertTrue("parse type " + parseType,
                parseType == OWLAxiomType.OBJECT_PROPERTY_ASSERTION);
        assertTrue(parsed.getOWLObject().accept(ASSOCOATION) == OWLAxiomType.OBJECT_PROPERTY_ASSERTION);
    }

    @Test
    public void testOWLKeys() {
        ManchesterOWLSyntaxTree parsed = parse("Pizza HasKey hasTopping , hasBase",
                symbolTable);
        Type parseType = parsed.getEvalType();
        assertTrue("parse type " + parseType, parseType == OWLAxiomType.HAS_KEY);
        assertTrue(parsed.getOWLObject().accept(ASSOCOATION) == OWLAxiomType.HAS_KEY);
        parsed = parse("Pizza HasKey hasTopping , INV (hasBase)", symbolTable);
        parseType = parsed.getEvalType();
        assertTrue("parse type " + parseType, parseType == OWLAxiomType.HAS_KEY);
        assertTrue(parsed.getOWLObject().accept(ASSOCOATION) == OWLAxiomType.HAS_KEY);
    }

    @Test
    public void testDataPropertyAssertion() {
        symbolTable = getOPPLSymbolTable(managerForPizzaAndSyntax);
        ManchesterOWLSyntaxTree parsed = parse(
                "America  aDataProperty \" Monica dei topolissimi \"^int", symbolTable);
        Type parseType = parsed.getEvalType();
        assertTrue("parse type " + parseType,
                parseType == OWLAxiomType.DATA_PROPERTY_ASSERTION);
        assertTrue(parsed.getOWLObject().accept(ASSOCOATION) == OWLAxiomType.DATA_PROPERTY_ASSERTION);
    }

    @Test
    public void testEquivalentClass() {
        ManchesterOWLSyntaxTree parsed = parse(
                "NamedPizza or not (hasTopping some Pizza) equivalentTo Pizza and  NamedPizza",
                symbolTable);
        Type parseType = parsed.getEvalType();
        assertTrue("parse type " + parseType,
                parseType == OWLAxiomType.EQUIVALENT_CLASSES);
        assertTrue(parsed.getOWLObject().accept(ASSOCOATION) == OWLAxiomType.EQUIVALENT_CLASSES);
        parsed = parse("NamedPizza  equivalentTo Pizza", symbolTable);
        parseType = parsed.getEvalType();
        assertTrue("parse type " + parseType,
                parseType == OWLAxiomType.EQUIVALENT_CLASSES);
        assertTrue(parsed.getOWLObject().accept(ASSOCOATION) == OWLAxiomType.EQUIVALENT_CLASSES);
        // Change the keyword case
        parsed = parse(
                "Pizza or not (hasTopping some Thing) EquivalentTo Pizza and  NamedPizza",
                symbolTable);
        parseType = parsed.getEvalType();
        assertTrue("parse type " + parseType,
                parseType == OWLAxiomType.EQUIVALENT_CLASSES);
        assertTrue(parsed.getOWLObject().accept(ASSOCOATION) == OWLAxiomType.EQUIVALENT_CLASSES);
    }

    @Test
    public void testEquivalentClassEscapedEntities() {
        ManchesterOWLSyntaxTree parsed = parse(
                "NamedPizza or not ('hasTopping' some Pizza) equivalentTo Pizza and  NamedPizza",
                symbolTable);
        Type parseType = parsed.getEvalType();
        assertTrue("parse type " + parseType,
                parseType == OWLAxiomType.EQUIVALENT_CLASSES);
        assertTrue(parsed.getOWLObject().accept(ASSOCOATION) == OWLAxiomType.EQUIVALENT_CLASSES);
        parsed = parse("NamedPizza  equivalentTo Pizza", symbolTable);
        parseType = parsed.getEvalType();
        assertTrue("parse type " + parseType,
                parseType == OWLAxiomType.EQUIVALENT_CLASSES);
        assertTrue(parsed.getOWLObject().accept(ASSOCOATION) == OWLAxiomType.EQUIVALENT_CLASSES);
    }

    @Test
    public void testDisjointClasses() {
        ManchesterOWLSyntaxTree parsed = parse(
                "NamedPizza or not (hasTopping some Pizza) DisjointWith Pizza and  NamedPizza",
                symbolTable);
        Type parseType = parsed.getEvalType();
        assertTrue("parse type " + parseType, parseType == OWLAxiomType.DISJOINT_CLASSES);
        assertTrue(parsed.getOWLObject().accept(ASSOCOATION) == OWLAxiomType.DISJOINT_CLASSES);
    }

    @Test
    public void testDisjointObjectProperties() {
        ManchesterOWLSyntaxTree parsed = parse("hasTopping  DisjointWith INV (hasBase)",
                symbolTable);
        Type parseType = parsed.getEvalType();
        assertTrue("parse type " + parseType,
                parseType == OWLAxiomType.DISJOINT_OBJECT_PROPERTIES);
        assertTrue(parsed.getOWLObject().accept(ASSOCOATION) == OWLAxiomType.DISJOINT_OBJECT_PROPERTIES);
    }

    @Test
    public void testDisjointDataProperties() {
        symbolTable = getOPPLSymbolTable(managerForPizzaAndSyntax);
        ManchesterOWLSyntaxTree parsed = parse(
                "aDataProperty  DisjointWith aDataProperty", symbolTable);
        Type parseType = parsed.getEvalType();
        assertTrue("parse type " + parseType,
                parseType == OWLAxiomType.DISJOINT_DATA_PROPERTIES);
        assertTrue(parsed.getOWLObject().accept(ASSOCOATION) == OWLAxiomType.DISJOINT_DATA_PROPERTIES);
    }

    @Test
    public void testEquivalentObjectProperties() {
        ManchesterOWLSyntaxTree parsed = parse(
                "INV (hasTopping) equivalentTo INV (hasBase)", symbolTable);
        Type parseType = parsed.getEvalType();
        assertTrue("parse type " + parseType,
                parseType == OWLAxiomType.EQUIVALENT_OBJECT_PROPERTIES);
        assertTrue(parsed.getOWLObject().accept(ASSOCOATION) == OWLAxiomType.EQUIVALENT_OBJECT_PROPERTIES);
    }

    @Test
    public void testEquivalentDataProperties() {
        symbolTable = getOPPLSymbolTable(managerForPizzaAndSyntax);
        ManchesterOWLSyntaxTree parsed = parse(
                "aDataProperty equivalentTo aDataProperty", symbolTable);
        Type parseType = parsed.getEvalType();
        assertTrue("parse type " + parseType,
                parseType == OWLAxiomType.EQUIVALENT_DATA_PROPERTIES);
        assertTrue(parsed.getOWLObject().accept(ASSOCOATION) == OWLAxiomType.EQUIVALENT_DATA_PROPERTIES);
    }

    @Test
    public void testSubObjectProperty() {
        ManchesterOWLSyntaxTree parsed = parse("hasTopping subPropertyOf hasBase",
                symbolTable);
        Type parseType = parsed.getEvalType();
        assertTrue("parse type " + parseType,
                parseType == OWLAxiomType.SUB_OBJECT_PROPERTY);
        assertTrue(parsed.getOWLObject().accept(ASSOCOATION) == OWLAxiomType.SUB_OBJECT_PROPERTY);
    }

    @Test
    public void testSubDataProperty() {
        symbolTable = getOPPLSymbolTable(managerForPizzaAndSyntax);
        ManchesterOWLSyntaxTree parsed = parse(
                "aDataProperty subPropertyOf aDataProperty", symbolTable);
        Type parseType = parsed.getEvalType();
        assertTrue("parse type " + parseType, parseType == OWLAxiomType.SUB_DATA_PROPERTY);
        assertTrue(parsed.getOWLObject().accept(ASSOCOATION) == OWLAxiomType.SUB_DATA_PROPERTY);
    }

    @Test
    public void testDomainAxiom() {
        symbolTable = getOPPLSymbolTable(managerForPizzaAndSyntax);
        ManchesterOWLSyntaxTree parsed = parse("hasTopping Domain Pizza and Thing",
                symbolTable);
        Type parseType = parsed.getEvalType();
        assertTrue("parse type " + parseType,
                parseType == OWLAxiomType.OBJECT_PROPERTY_DOMAIN);
        assertTrue(parsed.getOWLObject().accept(ASSOCOATION) == OWLAxiomType.OBJECT_PROPERTY_DOMAIN);
        parsed = parse("aDataProperty Domain Thing and Pizza", symbolTable);
        parseType = parsed.getEvalType();
        assertTrue("parse type " + parseType,
                parseType == OWLAxiomType.DATA_PROPERTY_DOMAIN);
        assertTrue(parsed.getOWLObject().accept(ASSOCOATION) == OWLAxiomType.DATA_PROPERTY_DOMAIN);
    }

    @Test
    public void testRangeAxiom() {
        symbolTable = getOPPLSymbolTable(managerForPizzaAndSyntax);
        ManchesterOWLSyntaxTree parsed = parse("hasTopping Range Pizza and Thing",
                symbolTable);
        Type parseType = parsed.getEvalType();
        assertTrue("parse type " + parseType,
                parseType == OWLAxiomType.OBJECT_PROPERTY_RANGE);
        assertTrue(parsed.getOWLObject().accept(ASSOCOATION) == OWLAxiomType.OBJECT_PROPERTY_RANGE);
        parsed = parse("aDataProperty Range int", symbolTable);
        parseType = parsed.getEvalType();
        assertTrue("parse type " + parseType,
                parseType == OWLAxiomType.DATA_PROPERTY_RANGE);
        assertTrue(parsed.getOWLObject().accept(ASSOCOATION) == OWLAxiomType.DATA_PROPERTY_RANGE);
    }

    @Test
    public void testPropertyChainSubProperty() {
        ManchesterOWLSyntaxTree parsed = parse(
                "hasTopping o hasBase subPropertyOf hasBase", symbolTable);
        Type parseType = parsed.getEvalType();
        assertTrue("parse type " + parseType,
                parseType == OWLAxiomType.PROPERTY_CHAIN_SUB_PROPERTY);
        assertTrue(parsed.getOWLObject().accept(ASSOCOATION) == OWLAxiomType.PROPERTY_CHAIN_SUB_PROPERTY);
    }

    @Test
    public void testSameIndividuals() {
        ManchesterOWLSyntaxTree parsed = parse("America  sameAs Italy", symbolTable);
        Type parseType = parsed.getEvalType();
        assertTrue("parse type " + parseType, parseType == OWLAxiomType.SAME_INDIVIDUAL);
        assertTrue(parsed.getOWLObject().accept(ASSOCOATION) == OWLAxiomType.SAME_INDIVIDUAL);
    }

    @Test
    public void testDifferentIndividuals() {
        ManchesterOWLSyntaxTree parsed = parse("America  differentFrom Italy",
                symbolTable);
        Type parseType = parsed.getEvalType();
        assertTrue("parse type " + parseType,
                parseType == OWLAxiomType.DIFFERENT_INDIVIDUALS);
        assertTrue(parsed.getOWLObject().accept(ASSOCOATION) == OWLAxiomType.DIFFERENT_INDIVIDUALS);
    }

    @Test
    public void testFunctionalObjectProperty() {
        ManchesterOWLSyntaxTree parsed = parse("Functional hasBase", symbolTable);
        Type parseType = parsed.getEvalType();
        assertTrue("parse type " + parseType,
                parseType == OWLAxiomType.FUNCTIONAL_OBJECT_PROPERTY);
        assertTrue(parsed.getOWLObject().accept(ASSOCOATION) == OWLAxiomType.FUNCTIONAL_OBJECT_PROPERTY);
    }

    @Test
    public void testFunctionalDataProperty() {
        symbolTable = getOPPLSymbolTable(managerForPizzaAndSyntax);
        ManchesterOWLSyntaxTree parsed = parse("Functional aDataProperty", symbolTable);
        Type parseType = parsed.getEvalType();
        assertTrue("parse type " + parseType,
                parseType == OWLAxiomType.FUNCTIONAL_DATA_PROPERTY);
        assertTrue(parsed.getOWLObject().accept(ASSOCOATION) == OWLAxiomType.FUNCTIONAL_DATA_PROPERTY);
    }

    @Test
    public void testInverseFunctionalObjectProperty() {
        ManchesterOWLSyntaxTree parsed = parse("InverseFunctional hasTopping",
                symbolTable);
        Type parseType = parsed.getEvalType();
        assertTrue("parse type " + parseType,
                parseType == OWLAxiomType.INVERSE_FUNCTIONAL_OBJECT_PROPERTY);
        assertTrue(parsed.getOWLObject().accept(ASSOCOATION) == OWLAxiomType.INVERSE_FUNCTIONAL_OBJECT_PROPERTY);
    }

    @Test
    public void testInverseObjectProperties() {
        ManchesterOWLSyntaxTree parsed = parse("hasTopping InverseOf hasTopping",
                symbolTable);
        Type parseType = parsed.getEvalType();
        assertTrue("parse type " + parseType,
                parseType == OWLAxiomType.INVERSE_OBJECT_PROPERTIES);
        assertTrue(parsed.getOWLObject().accept(ASSOCOATION) == OWLAxiomType.INVERSE_OBJECT_PROPERTIES);
    }

    @Test
    public void testIrreflexiveObjectProperty() {
        ManchesterOWLSyntaxTree parsed = parse("Irreflexive hasTopping", symbolTable);
        Type parseType = parsed.getEvalType();
        assertTrue("parse type " + parseType,
                parseType == OWLAxiomType.IRREFLEXIVE_OBJECT_PROPERTY);
        assertTrue(parsed.getOWLObject().accept(ASSOCOATION) == OWLAxiomType.IRREFLEXIVE_OBJECT_PROPERTY);
    }

    @Test
    public void testReflexiveObjectProperty() {
        ManchesterOWLSyntaxTree parsed = parse("Reflexive hasTopping", symbolTable);
        Type parseType = parsed.getEvalType();
        assertTrue("parse type " + parseType,
                parseType == OWLAxiomType.REFLEXIVE_OBJECT_PROPERTY);
        assertTrue(parsed.getOWLObject().accept(ASSOCOATION) == OWLAxiomType.REFLEXIVE_OBJECT_PROPERTY);
    }

    @Test
    public void testSymmetricObjectProperty() {
        ManchesterOWLSyntaxTree parsed = parse("Symmetric hasTopping", symbolTable);
        Type parseType = parsed.getEvalType();
        assertTrue("parse type " + parseType,
                parseType == OWLAxiomType.SYMMETRIC_OBJECT_PROPERTY);
        assertTrue(parsed.getOWLObject().accept(ASSOCOATION) == OWLAxiomType.SYMMETRIC_OBJECT_PROPERTY);
    }

    @Test
    public void testTransitiveObjectProperty() {
        ManchesterOWLSyntaxTree parsed = parse("Transitive hasTopping", symbolTable);
        Type parseType = parsed.getEvalType();
        assertTrue("parse type " + parseType,
                parseType == OWLAxiomType.TRANSITIVE_OBJECT_PROPERTY);
        assertTrue(parsed.getOWLObject().accept(ASSOCOATION) == OWLAxiomType.TRANSITIVE_OBJECT_PROPERTY);
    }

    @Test
    public void testNegativeObjectPropertyAssertion() {
        ManchesterOWLSyntaxTree parsed = parse("not America hasTopping Italy",
                symbolTable);
        Type parseType = parsed.getEvalType();
        assertTrue("parse type " + parseType,
                parseType == OWLAxiomType.NEGATIVE_OBJECT_PROPERTY_ASSERTION);
        assertTrue(parsed.getOWLObject().accept(ASSOCOATION) == OWLAxiomType.NEGATIVE_OBJECT_PROPERTY_ASSERTION);
    }

    @Test
    public void testDataRange() {
        symbolTable = getOPPLSymbolTable(managerForPizzaAndSyntax);
        ManchesterOWLSyntaxTree parsed = parse(
                "Thing subClassOf aDataProperty some int [ > \"1\"]", symbolTable);
        Type parseType = parsed.getEvalType();
        assertTrue("parse type " + parseType, parseType == OWLAxiomType.SUBCLASS);
        assertTrue(parsed.getOWLObject().accept(ASSOCOATION) == OWLAxiomType.SUBCLASS);
    }

    @Test
    public void testDataRangeConjuntion() {
        symbolTable = getOPPLSymbolTable(managerForPizzaAndSyntax);
        ManchesterOWLSyntaxTree parsed = parse(
                "Thing subClassOf aDataProperty some (int [ > \"1\"] and int[>\"3\"])",
                symbolTable);
        Type parseType = parsed.getEvalType();
        assertTrue("parse type " + parseType, parseType == OWLAxiomType.SUBCLASS);
        assertTrue(parsed.getOWLObject().accept(ASSOCOATION) == OWLAxiomType.SUBCLASS);
    }

    @Test
    public void testDataRangeDisjuntion() {
        symbolTable = getOPPLSymbolTable(managerForPizzaAndSyntax);
        ManchesterOWLSyntaxTree parsed = parse(
                "Thing subClassOf aDataProperty some (int [ > \"1\"] or int[>\"3\"])",
                symbolTable);
        Type parseType = parsed.getEvalType();
        assertTrue("parse type " + parseType, parseType == OWLAxiomType.SUBCLASS);
        assertTrue(parsed.getOWLObject().accept(ASSOCOATION) == OWLAxiomType.SUBCLASS);
    }

    @Test
    public void testAnnotationAssertionAxiom() {
        ManchesterOWLSyntaxTree parsed = parse("<blah#Luigi> label \"boh\"", symbolTable);
        Type parseType = parsed.getEvalType();
        assertTrue("parse type " + parseType,
                parseType == OWLAxiomType.ANNOTATION_ASSERTION);
        assertTrue(parsed.getOWLObject().accept(ASSOCOATION) == OWLAxiomType.ANNOTATION_ASSERTION);
        parsed = parse("<blah#Luigi> label <blah#Monica>", symbolTable);
        parseType = parsed.getEvalType();
        assertTrue("parse type " + parseType,
                parseType == OWLAxiomType.ANNOTATION_ASSERTION);
        assertTrue(parsed.getOWLObject().accept(ASSOCOATION) == OWLAxiomType.ANNOTATION_ASSERTION);
    }

    @Test
    public void testAnnotationAssertionWithLanguageTagAxiom() {
        ManchesterOWLSyntaxTree parsed = parse("<blah#Luigi> label \"bello\"@it",
                symbolTable);
        Type parseType = parsed.getEvalType();
        assertTrue("parse type " + parseType,
                parseType == OWLAxiomType.ANNOTATION_ASSERTION);
        assertTrue(parsed.getOWLObject().accept(ASSOCOATION) == OWLAxiomType.ANNOTATION_ASSERTION);
    }
}
