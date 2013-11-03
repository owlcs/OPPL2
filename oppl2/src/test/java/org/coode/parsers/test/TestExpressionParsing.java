/**
 * 
 */
package org.coode.parsers.test;

import static org.junit.Assert.assertNotNull;

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
import org.coode.parsers.ManchesterOWLSyntaxParser;
import org.coode.parsers.ManchesterOWLSyntaxSimplify;
import org.coode.parsers.ManchesterOWLSyntaxTree;
import org.coode.parsers.ManchesterOWLSyntaxTypes;
import org.coode.parsers.SymbolTable;
import org.coode.parsers.common.SystemErrorEcho;
import org.coode.parsers.factory.SimpleSymbolTableFactory;
import org.coode.parsers.factory.SymbolTableFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.model.OWLOntologyManager;

/** @author Luigi Iannone */
public class TestExpressionParsing {
    private OWLOntologyManager ONTOLOGY_MANAGER = OWLManager.createOWLOntologyManager();
    private final SymbolTableFactory<SymbolTable> SYMBOL_TABLE_FACTORY = new SimpleSymbolTableFactory(
            ONTOLOGY_MANAGER);
    public TreeAdaptor adaptor = new CommonTreeAdaptor() {
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
    private SymbolTable symtab;

    protected ManchesterOWLSyntaxTree parse(String input) {
        MOWLLexer lexer = new MOWLLexer(new ANTLRStringStream(input));
        final TokenRewriteStream tokens = new TokenRewriteStream(lexer);
        System.out.println(tokens.toDebugString());
        ManchesterOWLSyntaxParser parser = new ManchesterOWLSyntaxParser(tokens,
                errorListener);
        parser.setTreeAdaptor(adaptor);
        try {
            RuleReturnScope r = parser.expression();
            CommonTree tree = (CommonTree) r.getTree();
            CommonTreeNodeStream nodes = new CommonTreeNodeStream(tree);
            nodes.setTokenStream(tokens); // where to find tokens
            nodes.setTreeAdaptor(adaptor);
            symtab.setErrorListener(errorListener);
            ManchesterOWLSyntaxSimplify simplify = new ManchesterOWLSyntaxSimplify(nodes);
            simplify.setTreeAdaptor(adaptor);
            tree = (CommonTree) simplify.downup(tree);
            nodes.reset();
            ManchesterOWLSyntaxTypes types = new ManchesterOWLSyntaxTypes(nodes, symtab,
                    errorListener);
            types.downup(tree);
            return (ManchesterOWLSyntaxTree) tree;
        } catch (RecognitionException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Before
    public void setUp() throws Exception {
        ONTOLOGY_MANAGER.loadOntologyFromOntologyDocument(this.getClass()
                .getResourceAsStream("/pizza.owl"));
        ONTOLOGY_MANAGER.loadOntologyFromOntologyDocument(this.getClass()
                .getResourceAsStream("syntaxTest.owl"));
        symtab = SYMBOL_TABLE_FACTORY.createSymbolTable();
    }

    @After
    public void tearDown() throws Exception {
        symtab.dispose();
    }

    @Test
    public void testOWLClass() {
        ManchesterOWLSyntaxTree parsed = parse("Pizza");
        assertNotNull(parsed);
        System.out.println(parsed.toStringTree());
    }

    @Test
    public void testOWLClassDescription() {
        ManchesterOWLSyntaxTree parsed = parse("Pizza and Pizza");
        assertNotNull(parsed);
        System.out.println(parsed.toStringTree());
    }

    @Test
    public void testEntityReference() {
        ManchesterOWLSyntaxTree parsed = parse("'Pizza (the italian)'");
        assertNotNull(parsed);
        System.out.println(parsed.toStringTree());
    }

    @Test
    public void testRestriction() {
        ManchesterOWLSyntaxTree parsed = parse("Pizza and hasTopping some (Thing and hasTopping some Thing) and Thing");
        assertNotNull(parsed);
        System.out.println(parsed.toStringTree());
    }

    @Test
    public void testEscapeIdentifiersAsEntityReferences() {
        ManchesterOWLSyntaxTree parsed = parse("Pizza and 'hasTopping' some Thing");
        assertNotNull(parsed);
        System.out.println(parsed.toStringTree());
    }

    @Test
    public void testDataRange() {
        ManchesterOWLSyntaxTree parsed = parse("int [ > \"1\"]");
        assertNotNull(parsed);
        System.out.println(parsed.toStringTree());
    }

    @Test
    public void testComplexDataRange() {
        ManchesterOWLSyntaxTree parsed = parse("float[ > \"1\", > \"2\"]");
        assertNotNull(parsed);
        System.out.println(parsed.toStringTree());
    }

    @Test
    public void testDataRestriction() {
        ManchesterOWLSyntaxTree parsed = parse("hasKCal some float[ > \"1\", > \"2\"]");
        assertNotNull(parsed);
        System.out.println(parsed.toStringTree());
    }

    @Test
    public void testDataIntersectionOf() {
        ManchesterOWLSyntaxTree parsed = parse("float[ > \"1\"] and int [< \"1\"]");
        assertNotNull(parsed);
        System.out.println(parsed.toStringTree());
    }
}
