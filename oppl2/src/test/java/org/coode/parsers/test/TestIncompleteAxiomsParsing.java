/**
 * 
 */
package org.coode.parsers.test;

import static org.coode.oppl.Ontologies.*;
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
import org.coode.parsers.ManchesterOWLSyntaxAutoCompleteCombinedParser;
import org.coode.parsers.ManchesterOWLSyntaxSimplify;
import org.coode.parsers.ManchesterOWLSyntaxTree;
import org.coode.parsers.common.SilentListener;
import org.coode.parsers.oppl.OPPLSymbolTable;
import org.junit.Test;

/** @author Luigi Iannone */
public class TestIncompleteAxiomsParsing {
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
    private ErrorListener errorListener = new SilentListener();

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
            OPPLSymbolTable symtab = getOPPLSymbolTable(pizza);
            symtab.setErrorListener(errorListener);
            ManchesterOWLSyntaxSimplify simplify = new ManchesterOWLSyntaxSimplify(nodes);
            simplify.setTreeAdaptor(adaptor);
            simplify.downup(tree);
            nodes.reset();
            return (ManchesterOWLSyntaxTree) tree;
        } catch (RecognitionException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void testSubClassAxiom() {
        ManchesterOWLSyntaxTree parsed = parse("Pizza subClassOf NamedPizza and");
        assertNotNull(parsed);
    }

    @Test
    public void testIncompleteStandaloneExpression() {
        ManchesterOWLSyntaxTree parsed = parse("NamedPizza and Pizza s");
        assertNotNull(parsed);
    }
}
