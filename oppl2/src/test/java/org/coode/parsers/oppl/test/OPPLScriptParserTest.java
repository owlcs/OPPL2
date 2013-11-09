package org.coode.parsers.oppl.test;

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
import org.coode.parsers.ManchesterOWLSyntaxSimplify;
import org.coode.parsers.ManchesterOWLSyntaxTree;
import org.coode.parsers.common.SystemErrorEcho;
import org.coode.parsers.oppl.OPPLLexer;
import org.coode.parsers.oppl.OPPLScriptParser;
import org.coode.parsers.oppl.OPPLSyntaxTree;
import org.junit.Test;

/** Test for the AST generation for OPPL
 * 
 * @author Luigi Iannone */
@SuppressWarnings("javadoc")
public class OPPLScriptParserTest {
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

    @Test
    public void testSubClassQuery() {
        String query = "?x:CLASS SELECT ?x subClassOf Thing BEGIN ADD ?x subClassOf Thing END;";
        ManchesterOWLSyntaxTree parsed = parse(query);
        System.out.println(parsed.toStringTree());
        assertNotNull(parsed);
    }

    @Test
    public void testSubClassQueryNAryAxiom() {
        String query = "?x:CLASS SELECT DisjointClasses set(Thing, Nothing) BEGIN ADD ?x subClassOf Thing END;";
        ManchesterOWLSyntaxTree parsed = parse(query);
        System.out.println(parsed.toStringTree());
        assertNotNull(parsed);
    }

    @Test
    public void testSubClassQueryNAryAxiomVariableValues() {
        String query = "?x:CLASS SELECT DisjointClasses: set(?x.VALUES) BEGIN ADD ?x subClassOf Thing END;";
        ManchesterOWLSyntaxTree parsed = parse(query);
        assertNotNull(parsed);
        System.out.println(parsed.toStringTree());
    }

    @Test
    public void testLowerCase() {
        String query = "?x:CLASS=create(\"BLA\".toLowerCase) SELECT ?x subClassOf Thing BEGIN ADD ?x subClassOf Thing END;";
        ManchesterOWLSyntaxTree parsed = parse(query);
        assertNotNull(parsed);
        System.out.println(parsed.toStringTree());
    }

    @Test
    public void testUpperCase() {
        String query = "?x:CLASS=create(\"BLA\".toUpperCase) SELECT ?x subClassOf Thing BEGIN ADD ?x subClassOf Thing END;";
        ManchesterOWLSyntaxTree parsed = parse(query);
        assertNotNull(parsed);
        System.out.println(parsed.toStringTree());
    }

    @Test
    public void testLowerCaseInConcat() {
        String query = "?x:CLASS, ?y:CLASS=create(?x.RENDERING +\"_\"+\"BLA\".toLowerCase) SELECT ?x subClassOf Thing BEGIN ADD ?x subClassOf Thing END;";
        ManchesterOWLSyntaxTree parsed = parse(query);
        assertNotNull(parsed);
        System.out.println(parsed.toStringTree());
    }

    @Test
    public void testLowerCaseInConcatWithGroups() {
        String query = "?x:CLASS = MATCH(\"(.+)Topping\"), ?y:CLASS=create(\"Topping_\" + ?x.GROUPS(1).toLowerCase) SELECT ?x subClassOf Thing BEGIN ADD ?x subClassOf Thing END;";
        ManchesterOWLSyntaxTree parsed = parse(query);
        assertNotNull(parsed);
        System.out.println(parsed.toStringTree());
    }

    @Test
    public void testUpperCaseInConcatWithGroups() {
        String query = "?x:CLASS = MATCH(\"(.+)Topping\"), ?y:CLASS=create(\"Topping_\" + ?x.GROUPS(1).toUpperCase) SELECT ?x subClassOf Thing BEGIN ADD ?x subClassOf Thing END;";
        ManchesterOWLSyntaxTree parsed = parse(query);
        assertNotNull(parsed);
        System.out.println(parsed.toStringTree());
    }

    @Test
    public void testLowerCaseParenthesys() {
        String query = "?x:CLASS=create((\"Bla\"+ \"Bla\").toLowerCase) SELECT ?x subClassOf Thing BEGIN ADD ?x subClassOf Thing END;";
        ManchesterOWLSyntaxTree parsed = parse(query);
        assertNotNull(parsed);
        System.out.println(parsed.toStringTree());
    }

    @Test
    public void testUpperCaseInConcat() {
        String query = "?x:CLASS, ?y:CLASS=create(?x.RENDERING +\"_\"+\"BLA\".toUpperCase) SELECT ?x subClassOf Thing BEGIN ADD ?x subClassOf Thing END;";
        ManchesterOWLSyntaxTree parsed = parse(query);
        assertNotNull(parsed);
        System.out.println(parsed.toStringTree());
    }

    @Test
    public void testRegexpQuery() {
        String query = "?x:CLASS = MATCH (\".*ing\") SELECT ?x subClassOf Thing BEGIN ADD ?x subClassOf Thing END;";
        ManchesterOWLSyntaxTree parsed = parse(query);
        assertNotNull(parsed);
        System.out.println(parsed.toStringTree());
    }

    @Test
    public void testGeneratedVariable() {
        String query = "?x:CLASS, ?y:OBJECTPROPERTY = MATCH(\" has((\\w+)) \"), ?z:CLASS, ?feature:CLASS = create(?y.GROUPS(1)) SELECT ASSERTED ?x subClassOf ?y some ?z BEGIN REMOVE ?x subClassOf ?y some ?z, ADD ?x subClassOf !hasFeature some (?feature and !hasValue some ?z) END;";
        ManchesterOWLSyntaxTree parsed = parse(query);
        assertNotNull(parsed);
        System.out.println(parsed.toStringTree());
    }

    protected ManchesterOWLSyntaxTree parse(String input) {
        ANTLRStringStream antlrStringStream = new ANTLRStringStream(input);
        OPPLLexer lexer = new OPPLLexer(antlrStringStream);
        final TokenRewriteStream tokens = new TokenRewriteStream(lexer);
        OPPLScriptParser parser = new OPPLScriptParser(tokens, new SystemErrorEcho());
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
                ManchesterOWLSyntaxSimplify simplify = new ManchesterOWLSyntaxSimplify(
                        nodes);
                simplify.setTreeAdaptor(adaptor);
                simplify.downup(tree);
            }
            return (ManchesterOWLSyntaxTree) r.getTree();
        } catch (RecognitionException e) {
            e.printStackTrace();
            return null;
        }
    }
}
