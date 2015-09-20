package org.coode.parsers.oppl.test;

import static org.junit.Assert.assertNotNull;

import org.antlr.runtime.*;
import org.antlr.runtime.tree.CommonErrorNode;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.CommonTreeAdaptor;
import org.antlr.runtime.tree.CommonTreeNodeStream;
import org.antlr.runtime.tree.TreeAdaptor;
import org.coode.parsers.ManchesterOWLSyntaxSimplify;
import org.coode.parsers.ManchesterOWLSyntaxTree;
import org.coode.parsers.common.SilentListener;
import org.coode.parsers.oppl.OPPLLexer;
import org.coode.parsers.oppl.OPPLScriptParser;
import org.coode.parsers.oppl.OPPLSyntaxTree;
import org.junit.Test;

/**
 * Test for the AST generation for OPPL
 * 
 * @author Luigi Iannone
 */
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
    public void shouldTestSubClassQuery() {
        String query = "?x:CLASS SELECT ?x subClassOf Thing BEGIN ADD ?x subClassOf Thing END;";
        ManchesterOWLSyntaxTree parsed = parse(query);
        assertNotNull(parsed);
    }

    @Test
    public void shouldTestSubClassQueryNAryAxiom() {
        String query = "?x:CLASS SELECT DisjointClasses set(Thing, Nothing) BEGIN ADD ?x subClassOf Thing END;";
        ManchesterOWLSyntaxTree parsed = parse(query);
        assertNotNull(parsed);
    }

    @Test
    public void shouldTestSubClassQueryNAryAxiomVariableValues() {
        String query = "?x:CLASS SELECT DisjointClasses: set(?x.VALUES) BEGIN ADD ?x subClassOf Thing END;";
        ManchesterOWLSyntaxTree parsed = parse(query);
        assertNotNull(parsed);
    }

    @Test
    public void shouldTestLowerCase() {
        String query = "?x:CLASS=create(\"BLA\".toLowerCase) SELECT ?x subClassOf Thing BEGIN ADD ?x subClassOf Thing END;";
        ManchesterOWLSyntaxTree parsed = parse(query);
        assertNotNull(parsed);
    }

    @Test
    public void shouldTestUpperCase() {
        String query = "?x:CLASS=create(\"BLA\".toUpperCase) SELECT ?x subClassOf Thing BEGIN ADD ?x subClassOf Thing END;";
        ManchesterOWLSyntaxTree parsed = parse(query);
        assertNotNull(parsed);
    }

    @Test
    public void shouldTestLowerCaseInConcat() {
        String query = "?x:CLASS, ?y:CLASS=create(?x.RENDERING +\"_\"+\"BLA\".toLowerCase) SELECT ?x subClassOf Thing BEGIN ADD ?x subClassOf Thing END;";
        ManchesterOWLSyntaxTree parsed = parse(query);
        assertNotNull(parsed);
    }

    @Test
    public void shouldTestLowerCaseInConcatWithGroups() {
        String query = "?x:CLASS = MATCH(\"(.+)Topping\"), ?y:CLASS=create(\"Topping_\" + ?x.GROUPS(1).toLowerCase) SELECT ?x subClassOf Thing BEGIN ADD ?x subClassOf Thing END;";
        ManchesterOWLSyntaxTree parsed = parse(query);
        assertNotNull(parsed);
    }

    @Test
    public void shouldTestUpperCaseInConcatWithGroups() {
        String query = "?x:CLASS = MATCH(\"(.+)Topping\"), ?y:CLASS=create(\"Topping_\" + ?x.GROUPS(1).toUpperCase) SELECT ?x subClassOf Thing BEGIN ADD ?x subClassOf Thing END;";
        ManchesterOWLSyntaxTree parsed = parse(query);
        assertNotNull(parsed);
    }

    @Test
    public void shouldTestLowerCaseParenthesys() {
        String query = "?x:CLASS=create((\"Bla\"+ \"Bla\").toLowerCase) SELECT ?x subClassOf Thing BEGIN ADD ?x subClassOf Thing END;";
        ManchesterOWLSyntaxTree parsed = parse(query);
        assertNotNull(parsed);
    }

    @Test
    public void shouldTestUpperCaseInConcat() {
        String query = "?x:CLASS, ?y:CLASS=create(?x.RENDERING +\"_\"+\"BLA\".toUpperCase) SELECT ?x subClassOf Thing BEGIN ADD ?x subClassOf Thing END;";
        ManchesterOWLSyntaxTree parsed = parse(query);
        assertNotNull(parsed);
    }

    @Test
    public void shouldTestRegexpQuery() {
        String query = "?x:CLASS = MATCH (\".*ing\") SELECT ?x subClassOf Thing BEGIN ADD ?x subClassOf Thing END;";
        ManchesterOWLSyntaxTree parsed = parse(query);
        assertNotNull(parsed);
    }

    @Test
    public void shouldTestGeneratedVariable() {
        String query = "?x:CLASS, ?y:OBJECTPROPERTY = MATCH(\" has((\\w+)) \"), ?z:CLASS, ?feature:CLASS = create(?y.GROUPS(1)) SELECT ASSERTED ?x subClassOf ?y some ?z BEGIN REMOVE ?x subClassOf ?y some ?z, ADD ?x subClassOf !hasFeature some (?feature and !hasValue some ?z) END;";
        ManchesterOWLSyntaxTree parsed = parse(query);
        assertNotNull(parsed);
    }

    protected ManchesterOWLSyntaxTree parse(String input) {
        ANTLRStringStream antlrStringStream = new ANTLRStringStream(input);
        OPPLLexer lexer = new OPPLLexer(antlrStringStream);
        final TokenRewriteStream tokens = new TokenRewriteStream(lexer);
        OPPLScriptParser parser = new OPPLScriptParser(tokens, new SilentListener());
        parser.setTreeAdaptor(adaptor);
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
        }
        return (ManchesterOWLSyntaxTree) r.getTree();
    }
}
