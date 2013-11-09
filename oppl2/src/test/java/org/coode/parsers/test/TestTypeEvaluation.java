/**
 * 
 */
package org.coode.parsers.test;

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
import org.coode.oppl.Ontologies;
import org.coode.parsers.ErrorListener;
import org.coode.parsers.MOWLLexer;
import org.coode.parsers.ManchesterOWLSyntaxParser;
import org.coode.parsers.ManchesterOWLSyntaxTree;
import org.coode.parsers.ManchesterOWLSyntaxTypes;
import org.coode.parsers.SymbolTable;
import org.coode.parsers.common.SystemErrorEcho;
import org.coode.parsers.factory.SimpleSymbolTableFactory;
import org.coode.parsers.factory.SymbolTableFactory;
import org.junit.Test;
import org.semanticweb.owlapi.model.OWLOntologyManager;

/** @author Luigi Iannone */
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

    @Test
    public void main() throws RecognitionException {
        Ontologies ontologies = new Ontologies();
        OWLOntologyManager ontologyManager = ontologies.pizza.getOWLOntologyManager();
        SymbolTableFactory<SymbolTable> symbolTableFactory = new SimpleSymbolTableFactory(
                ontologyManager);
        String input = "hasTopping subPropertyOf INV (hasTopping)";
        System.out.println(input);
        MOWLLexer lexer = new MOWLLexer(new ANTLRStringStream(input));
        final TokenRewriteStream tokens = new TokenRewriteStream(lexer);
        ManchesterOWLSyntaxParser parser = new ManchesterOWLSyntaxParser(tokens);
        parser.setTreeAdaptor(adaptor);
        RuleReturnScope r = parser.main();
        CommonTree tree = (CommonTree) r.getTree();
        System.out.println(tree.toString());
        CommonTreeNodeStream nodes = new CommonTreeNodeStream(tree);
        nodes.setTokenStream(tokens); // where to find tokens
        nodes.setTreeAdaptor(adaptor);
        // RESOLVE SYMBOLS, COMPUTE EXPRESSION TYPES
        SymbolTable symtab = symbolTableFactory.createSymbolTable();
        symtab.setErrorListener(errorListener);
        ManchesterOWLSyntaxTypes typeComp = new ManchesterOWLSyntaxTypes(nodes, symtab,
                new SystemErrorEcho());
        typeComp.downup(tree); // trigger resolve/type computation actions
        // WALK TREE TO DUMP SUBTREE TYPES
        System.out.println(tree.toStringTree());
    }

    private static ErrorListener errorListener = new SystemErrorEcho();
}
