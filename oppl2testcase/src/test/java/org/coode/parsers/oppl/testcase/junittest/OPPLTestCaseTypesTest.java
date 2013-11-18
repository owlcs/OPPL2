package org.coode.parsers.oppl.testcase.junittest;

import static org.coode.oppl.testcaseontologies.TestCaseTestOntologies.pizza;
import static org.junit.Assert.assertNotNull;

import java.util.regex.PatternSyntaxException;

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
import org.coode.oppl.ConstraintSystem;
import org.coode.oppl.exceptions.RuntimeExceptionHandler;
import org.coode.parsers.ErrorListener;
import org.coode.parsers.ManchesterOWLSyntaxSimplify;
import org.coode.parsers.ManchesterOWLSyntaxTypes;
import org.coode.parsers.Type;
import org.coode.parsers.oppl.DefaultTypeEnforcer;
import org.coode.parsers.oppl.OPPLDefine;
import org.coode.parsers.oppl.OPPLSyntaxTree;
import org.coode.parsers.oppl.OPPLTypeEnforcement;
import org.coode.parsers.oppl.OPPLTypes;
import org.coode.parsers.oppl.testcase.AbstractOPPLTestCaseFactory;
import org.coode.parsers.oppl.testcase.OPPLTestCase;
import org.coode.parsers.oppl.testcase.OPPLTestCaseCombinedParser;
import org.coode.parsers.oppl.testcase.OPPLTestCaseFactory;
import org.coode.parsers.oppl.testcase.OPPLTestCaseLexer;
import org.coode.parsers.oppl.testcase.OPPLTestCaseSymbolTable;
import org.coode.parsers.oppl.testcase.OPPLTestCaseTypes;
import org.coode.parsers.oppl.testcase.SimpleSymbolTableFactory;
import org.junit.Test;
import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;
import org.semanticweb.owlapi.model.OWLOntologyManager;
import org.semanticweb.owlapi.model.OWLRuntimeException;

@SuppressWarnings("javadoc")
public class OPPLTestCaseTypesTest {
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
        public Object errorNode(TokenStream input, Token start, Token stop,
                RecognitionException e) {
            return new CommonErrorNode(input, start, stop, e);
        }
    };
    static final ErrorListener ERROR_LISTENER = new ErrorListener() {
        @Override
        public void unrecognisedSymbol(CommonTree t) {
            throw new RuntimeException(t.toString());
        }

        @Override
        public void
                incompatibleSymbolType(CommonTree t, Type type, CommonTree expression) {
            throw new RuntimeException(t.toString());
        }

        @Override
        public void incompatibleSymbols(CommonTree parentExpression, CommonTree... trees) {
            throw new RuntimeException(parentExpression.toString());
        }

        @Override
        public void illegalToken(CommonTree t, String message) {
            throw new RuntimeException(t.toString());
        }

        @Override
        public void recognitionException(RecognitionException e) {
            throw new RuntimeException(e);
        }

        @Override
        public void recognitionException(RecognitionException e, String... tokenNames) {
            throw new RuntimeException(e);
        }

        @Override
        public void rewriteEmptyStreamException(RewriteEmptyStreamException e) {
            throw new RuntimeException(e);
        }

        @Override
        public void reportThrowable(Throwable t, int line, int charPosInLine, int length) {
            throw new RuntimeException(t);
        }
    };
    private static final RuntimeExceptionHandler HANDLER = new RuntimeExceptionHandler() {
        @Override
        public void handlePatternSyntaxExcpetion(PatternSyntaxException e) {
            ERROR_LISTENER.reportThrowable(e, 0, 0, 0);
        }

        @Override
        public void handleOWLRuntimeException(OWLRuntimeException e) {
            ERROR_LISTENER.reportThrowable(e, 0, 0, 0);
        }

        @Override
        public void handleException(RuntimeException e) {
            ERROR_LISTENER.reportThrowable(e, 0, 0, 0);
        }
    };

    protected OPPLTestCase parse(String input, OWLOntology ontology,
            OWLOntologyManager ontologyManager) {
        SimpleSymbolTableFactory simpleSymbolTableFactory = new SimpleSymbolTableFactory(
                ontologyManager);
        OPPLTestCaseSymbolTable symtab = simpleSymbolTableFactory.createSymbolTable();
        symtab.setErrorListener(ERROR_LISTENER);
        AbstractOPPLTestCaseFactory testCaseFactory = new OPPLTestCaseFactory(ontology,
                ontologyManager, null);
        ConstraintSystem constraintSystem = testCaseFactory.getOPPLFactory()
                .createConstraintSystem();
        ANTLRStringStream antlrStringStream = new ANTLRStringStream(input);
        OPPLTestCaseLexer opplTestCaseLexer = new OPPLTestCaseLexer(antlrStringStream);
        final TokenRewriteStream tokens = new TokenRewriteStream(opplTestCaseLexer);
        OPPLTestCaseCombinedParser parser = new OPPLTestCaseCombinedParser(tokens,
                ERROR_LISTENER);
        parser.setTreeAdaptor(adaptor);
        RuleReturnScope r = parser.testCase();
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
        OPPLDefine define = new OPPLDefine(nodes, symtab, ERROR_LISTENER,
                constraintSystem);
        define.setTreeAdaptor(adaptor);
        define.downup(tree);
        nodes.reset();
        ManchesterOWLSyntaxTypes mOWLTypes = new ManchesterOWLSyntaxTypes(nodes, symtab,
                ERROR_LISTENER);
        mOWLTypes.downup(tree);
        nodes.reset();
        OPPLTypeEnforcement typeEnforcement = new OPPLTypeEnforcement(nodes, symtab,
                new DefaultTypeEnforcer(symtab, testCaseFactory.getOPPLFactory()
                        .getOWLEntityFactory(), ERROR_LISTENER), ERROR_LISTENER);
        typeEnforcement.downup(tree);
        nodes.reset();
        mOWLTypes.downup(tree);
        nodes.reset();
        OPPLTypes opplTypes = new OPPLTypes(nodes, symtab, ERROR_LISTENER,
                constraintSystem, testCaseFactory.getOPPLFactory());
        opplTypes.downup(tree);
        nodes.reset();
        OPPLTestCaseTypes opplTestCaseTypes = new OPPLTestCaseTypes(nodes, symtab,
                ERROR_LISTENER, constraintSystem, testCaseFactory, HANDLER);
        opplTestCaseTypes.downup(tree);
        return (OPPLTestCase) ((OPPLSyntaxTree) r.getTree()).getOPPLContent();
    }

    @Test
    public void shouldTestOneAssertion() throws OWLOntologyCreationException {
        String testCase = "testOneAssertion; INFERENCE; ?x:CLASS SELECT ?x subClassOf Thing ASSERT ?x = Thing";
        OWLOntologyManager ontologyManager = OWLManager.createOWLOntologyManager();
        OWLOntology ontology = ontologyManager.createOntology();
        OPPLTestCase parsed = parse(testCase, ontology, ontologyManager);
        assertNotNull(parsed);
    }

    @Test
    public void shouldTestOneAssertionWithMessage() throws OWLOntologyCreationException {
        String testCase = "testOneAssertion; INFERENCE; ?x:CLASS SELECT ?x subClassOf Thing ASSERT ?x = Thing; ?x is not equal to Thing";
        OWLOntologyManager ontologyManager = OWLManager.createOWLOntologyManager();
        OWLOntology ontology = ontologyManager.createOntology();
        OPPLTestCase parsed = parse(testCase, ontology, ontologyManager);
        assertNotNull(parsed);
    }

    @Test
    public void shouldTestNotEqualAssertionWithMessage()
            throws OWLOntologyCreationException {
        String testCase = "testOneAssertion; INFERENCE; ?x:CLASS SELECT ?x subClassOf Thing ASSERT ?x != Thing; ?x is equal to Thing;";
        OWLOntologyManager ontologyManager = OWLManager.createOWLOntologyManager();
        OWLOntology ontology = ontologyManager.createOntology();
        OPPLTestCase parsed = parse(testCase, ontology, ontologyManager);
        assertNotNull(parsed);
    }

    @Test
    public void shouldTestCountAssertionWithMessage() throws OWLOntologyCreationException {
        String testCase = "testOneAssertion; INFERENCE; ?x:CLASS SELECT ?x subClassOf Thing ASSERT count(?x) = 2; ?x values count is not 2;";
        OWLOntologyManager ontologyManager = OWLManager.createOWLOntologyManager();
        OWLOntology ontology = ontologyManager.createOntology();
        OPPLTestCase parsed = parse(testCase, ontology, ontologyManager);
        assertNotNull(parsed);
    }

    @Test
    public void shouldTestContainsAssertionWithMessage()
            throws OWLOntologyCreationException {
        String testCase = "testOneAssertion; INFERENCE; ?x:CLASS SELECT ?x subClassOf Thing ASSERT ?x CONTAINS Thing; ?x values do not contain Thing;";
        OWLOntologyManager ontologyManager = OWLManager.createOWLOntologyManager();
        OWLOntology ontology = ontologyManager.createOntology();
        OPPLTestCase parsed = parse(testCase, ontology, ontologyManager);
        assertNotNull(parsed);
    }

    @Test
    public void shouldTestContainsAssertionWithMessageWithMoreThanOneOWLObject()
            throws OWLOntologyCreationException {
        String testCase = "testOneAssertion; INFERENCE; ?x:CLASS SELECT ?x subClassOf Thing ASSERT ?x CONTAINS Thing, Nothing; ?x values do not contain Thing and Nothing;";
        OWLOntologyManager ontologyManager = OWLManager.createOWLOntologyManager();
        OWLOntology ontology = ontologyManager.createOntology();
        OPPLTestCase parsed = parse(testCase, ontology, ontologyManager);
        assertNotNull(parsed);
    }

    @Test
    public void shouldTestVariableEqualAssertionWithMessage()
            throws OWLOntologyCreationException {
        String testCase = "testOneAssertion; INFERENCE; ?x:CLASS, ?y:CLASS SELECT ?x subClassOf ?y ASSERT ?x = ?y; ?x values are not equal to ?y;";
        OWLOntologyManager ontologyManager = OWLManager.createOWLOntologyManager();
        OWLOntology ontology = ontologyManager.createOntology();
        OPPLTestCase parsed = parse(testCase, ontology, ontologyManager);
        assertNotNull(parsed);
    }

    @Test
    public void shouldTestCountStarAssertionWithMessage()
            throws OWLOntologyCreationException {
        String testCase = "testOneAssertion;  ?x:CLASS, ?y:CLASS SELECT ?x subClassOf ?y ASSERT count(*)= 1; The total count of bindings is not 1;";
        OWLOntologyManager ontologyManager = OWLManager.createOWLOntologyManager();
        OWLOntology ontology = ontologyManager.createOntology();
        OPPLTestCase parsed = parse(testCase, ontology, ontologyManager);
        assertNotNull(parsed);
    }

    @Test
    public void shouldTestLessThanAssertionWithMessage()
            throws OWLOntologyCreationException {
        String testCase = "testOneAssertion;  ?x:CLASS, ?y:CLASS SELECT ?x subClassOf ?y ASSERT count(*)< 1; The total count of bindings is greater than or equal to 1;";
        OWLOntologyManager ontologyManager = OWLManager.createOWLOntologyManager();
        OWLOntology ontology = ontologyManager.createOntology();
        OPPLTestCase parsed = parse(testCase, ontology, ontologyManager);
        assertNotNull(parsed);
    }

    @Test
    public void shouldTestLessThanEqualToAssertionWithMessage()
            throws OWLOntologyCreationException {
        String testCase = "testOneAssertion;  ?x:CLASS, ?y:CLASS SELECT ?x subClassOf ?y ASSERT count(*)<= 1; The total count of bindings is greater than 1;";
        OWLOntologyManager ontologyManager = OWLManager.createOWLOntologyManager();
        OWLOntology ontology = ontologyManager.createOntology();
        OPPLTestCase parsed = parse(testCase, ontology, ontologyManager);
        assertNotNull(parsed);
    }

    @Test
    public void shouldTestGreaterThanEqualToAssertionWithMessage()
            throws OWLOntologyCreationException {
        String testCase = "testOneAssertion;  ?x:CLASS, ?y:CLASS SELECT ?x subClassOf ?y ASSERT count(*) >= 1; The total count of bindings is Less than 1;";
        OWLOntologyManager ontologyManager = OWLManager.createOWLOntologyManager();
        OWLOntology ontology = ontologyManager.createOntology();
        OPPLTestCase parsed = parse(testCase, ontology, ontologyManager);
        assertNotNull(parsed);
    }

    @Test
    public void shouldTestGreaterThanAssertionWithMessage()
            throws OWLOntologyCreationException {
        String testCase = "testOneAssertion;  ?x:CLASS, ?y:CLASS SELECT ?x subClassOf ?y ASSERT count(*)> 1; The total count of bindings is Less than or equal to 1;";
        OWLOntologyManager ontologyManager = OWLManager.createOWLOntologyManager();
        OWLOntology ontology = ontologyManager.createOntology();
        OPPLTestCase parsed = parse(testCase, ontology, ontologyManager);
        assertNotNull(parsed);
    }

    @Test
    public void shouldTestBindingWithMessage() throws OWLOntologyCreationException {
        String testCase = "testOneAssertion; ?x:CLASS, ?y:CLASS SELECT ?x subClassOf ?y ASSERT count(?x=Thing, ?y=Thing) > 0; The total count of bindings with ?x=Thing and ?y=Thing is less or equal than 0";
        OWLOntologyManager ontologyManager = OWLManager.createOWLOntologyManager();
        OWLOntology ontology;
        ontology = ontologyManager.createOntology();
        OPPLTestCase parsed = parse(testCase, ontology, ontologyManager);
        assertNotNull(parsed);
    }

    @Test
    public void shouldTest2BindingsWithOutMessages() {
        String testCase = "testOneAssertion; ?x:CLASS, ?y:CLASS SELECT ?x subClassOf ?y ASSERT count(?x=Pizza, ?y=PizzaBase) > 0 ASSERT count(?x=Thing, ?y=Nothing) > 0";
        OPPLTestCase parsed = parse(testCase, pizza, pizza.getOWLOntologyManager());
        assertNotNull(parsed);
    }
}
