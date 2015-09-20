package org.coode.parsers.oppl.patterns.test;

import static org.junit.Assert.assertNotNull;

import org.antlr.runtime.*;
import org.antlr.runtime.tree.CommonErrorNode;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.CommonTreeAdaptor;
import org.antlr.runtime.tree.CommonTreeNodeStream;
import org.antlr.runtime.tree.TreeAdaptor;
import org.coode.parsers.ManchesterOWLSyntaxSimplify;
import org.coode.parsers.oppl.OPPLSyntaxTree;
import org.coode.parsers.oppl.patterns.OPPLPatternLexer;
import org.coode.parsers.oppl.patterns.OPPLPatternScriptParser;
import org.junit.Test;

/**
 * Test for the AST generation for OPPL
 * 
 * @author Luigi Iannone
 */
@SuppressWarnings({ "javadoc", "unused" })
public class OPPLPatternsParserTest {

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
    public void shouldTestFood() {
        String patternString = "?x:CLASS, ?y:CLASS, ?forbiddenContent:CLASS = createUnion(?x.VALUES) BEGIN ADD $thisClass equivalentTo contains only (not ?forbiddenContent) END; A ?x free stuff; RETURN $thisClass";
        OPPLSyntaxTree parsed = parse(patternString);
        assertNotNull(parsed);
    }

    @Test
    public void shouldTestFoodLowerCase() {
        String patternString = "?x:CLASS, ?y:CLASS, ?z:CLASS= create(\"LOWERCASED_\" +?x.RENDERING.toLowerCase), ?forbiddenContent:CLASS = createUnion(?z.VALUES) BEGIN ADD $thisClass equivalentTo contains only (not ?forbiddenContent) END; A ?x free stuff; RETURN $thisClass";
        OPPLSyntaxTree parsed = parse(patternString);
        assertNotNull(parsed);
    }

    @Test
    public void shouldTestMenu() {
        String patternString = "?x:CLASS[subClassOf Food] BEGIN ADD $thisClass subClassOf Menu, ADD $thisClass subClassOf contains only (Course and contains only ($FreeFromPattern(?x))) END; A ?x free Menu";
        OPPLSyntaxTree parsed = parse(patternString);
        assertNotNull(parsed);
    }

    @Test
    public void shouldTestPizza() {
        String patternString = "?base:CLASS,?topping:CLASS, ?allToppings:CLASS = createUnion(?topping.VALUES) BEGIN ADD $thisClass subClassOf Pizza, ADD $thisClass subClassOf hasTopping some ?topping,  ADD $thisClass subClassOf hasTopping only ?allToppings, ADD $thisClass subClassOf hasBase some ?base  END; A pizza with ?base base and ?topping toppings";
        OPPLSyntaxTree parsed = parse(patternString);
        assertNotNull(parsed);
    }

    @Test
    public void shouldTestDOLCEInformationRealization() {
        String patternString = "?informationObject:CLASS, ?informationRealization:CLASS, ?realizationProperty:OBJECTPROPERTY BEGIN ADD ?informationRealization subClassOf InformationRealization, ADD ?informationObject subClassOf InformationObject, ADD ?realizationProperty subPropertyOf realizes, ADD ?informationRealization subClassOf PhysicalObject and ?realizationProperty some ?InformationObject END;Information Realization Pattern: ?informationRealization ?realizationProperty ?informationObject";
        OPPLSyntaxTree parsed = parse(patternString);
        assertNotNull(parsed);
    }

    @Test
    public void shouldTestDOLCEPersonRoleTimeInterval() {
        String patternString = "?person:CLASS, ?role:CLASS, ?timeInterval:CLASS BEGIN ADD $thisClass subClassOf Situation, ADD $thisClass subClassOf isSettingFor some ?person, ADD $thisClass subClassOf isSettingFor some ?role, ADD $thisClass subClassOf isSettingFor some ?timeInterval END; Situation where ?person play the role ?role during the time interval ?timeInterval";
        OPPLSyntaxTree parsed = parse(patternString);
        assertNotNull(parsed);
    }

    @Test
    public void shouldTestParseThisClassAtomic() {
        String input = "$thisClass";
        ANTLRStringStream antlrStringStream = new ANTLRStringStream(input);
        OPPLPatternLexer lexer = new OPPLPatternLexer(antlrStringStream);
        final TokenRewriteStream tokens = new TokenRewriteStream(lexer);
        OPPLPatternScriptParser parser = new OPPLPatternScriptParser(tokens);
        parser.setTreeAdaptor(adaptor);
        RuleReturnScope r = parser.atomic();
        assertNotNull(r);
        CommonTree tree = (CommonTree) r.getTree();
    }

    @Test
    public void shouldTestParseAtomic() {
        String input = "Thing";
        ANTLRStringStream antlrStringStream = new ANTLRStringStream(input);
        OPPLPatternLexer lexer = new OPPLPatternLexer(antlrStringStream);
        final TokenRewriteStream tokens = new TokenRewriteStream(lexer);
        OPPLPatternScriptParser parser = new OPPLPatternScriptParser(tokens);
        parser.setTreeAdaptor(adaptor);
        RuleReturnScope r = parser.atomic();
        assertNotNull(r);
        CommonTree tree = (CommonTree) r.getTree();
    }

    @Test
    public void shouldTestParseThisClassExpression() throws RecognitionException {
        String input = "$thisClass";
        ANTLRStringStream antlrStringStream = new ANTLRStringStream(input);
        OPPLPatternLexer lexer = new OPPLPatternLexer(antlrStringStream);
        final TokenRewriteStream tokens = new TokenRewriteStream(lexer);
        OPPLPatternScriptParser parser = new OPPLPatternScriptParser(tokens);
        parser.setTreeAdaptor(adaptor);
        RuleReturnScope r = parser.expression();
        assertNotNull(r);
        CommonTree tree = (CommonTree) r.getTree();
    }

    @Test
    public void shouldTestParseUnaryVariable() throws RecognitionException {
        String input = "?x";
        ANTLRStringStream antlrStringStream = new ANTLRStringStream(input);
        OPPLPatternLexer lexer = new OPPLPatternLexer(antlrStringStream);
        final TokenRewriteStream tokens = new TokenRewriteStream(lexer);
        OPPLPatternScriptParser parser = new OPPLPatternScriptParser(tokens);
        parser.setTreeAdaptor(adaptor);
        RuleReturnScope r = parser.unary();
        assertNotNull(r);
        CommonTree tree = (CommonTree) r.getTree();
    }

    @Test
    public void shouldTestParseUnaryThisClass() throws RecognitionException {
        String input = "$thisClass";
        ANTLRStringStream antlrStringStream = new ANTLRStringStream(input);
        OPPLPatternLexer lexer = new OPPLPatternLexer(antlrStringStream);
        final TokenRewriteStream tokens = new TokenRewriteStream(lexer);
        OPPLPatternScriptParser parser = new OPPLPatternScriptParser(tokens);
        parser.setTreeAdaptor(adaptor);
        RuleReturnScope r = parser.unary();
        assertNotNull(r);
        CommonTree tree = (CommonTree) r.getTree();
    }

    @Test
    public void shouldTestParseThisClassAtomicSubClassAxiom() throws RecognitionException {
        String input = "$thisClass subClassOf Thing";
        ANTLRStringStream antlrStringStream = new ANTLRStringStream(input);
        OPPLPatternLexer lexer = new OPPLPatternLexer(antlrStringStream);
        final TokenRewriteStream tokens = new TokenRewriteStream(lexer);
        OPPLPatternScriptParser parser = new OPPLPatternScriptParser(tokens);
        parser.setTreeAdaptor(adaptor);
        RuleReturnScope r = parser.axiom();
        assertNotNull(r);
        CommonTree tree = (CommonTree) r.getTree();
    }

    @Test
    public void shouldTestParseExpression() throws RecognitionException {
        String input = "Thing";
        ANTLRStringStream antlrStringStream = new ANTLRStringStream(input);
        OPPLPatternLexer lexer = new OPPLPatternLexer(antlrStringStream);
        final TokenRewriteStream tokens = new TokenRewriteStream(lexer);
        OPPLPatternScriptParser parser = new OPPLPatternScriptParser(tokens);
        parser.setTreeAdaptor(adaptor);
        RuleReturnScope r = parser.expression();
        assertNotNull(r);
        CommonTree tree = (CommonTree) r.getTree();
    }

    @Test
    public void shouldTestParsePatternReferenceAtomic() {
        String input = "$p(Thing,Nothing)";
        ANTLRStringStream antlrStringStream = new ANTLRStringStream(input);
        OPPLPatternLexer lexer = new OPPLPatternLexer(antlrStringStream);
        final TokenRewriteStream tokens = new TokenRewriteStream(lexer);
        OPPLPatternScriptParser parser = new OPPLPatternScriptParser(tokens);
        parser.setTreeAdaptor(adaptor);
        RuleReturnScope r = parser.atomic();
        assertNotNull(r);
        CommonTree tree = (CommonTree) r.getTree();
    }

    protected OPPLSyntaxTree parse(String input) {
        ANTLRStringStream antlrStringStream = new ANTLRStringStream(input);
        OPPLPatternLexer lexer = new OPPLPatternLexer(antlrStringStream);
        final TokenRewriteStream tokens = new TokenRewriteStream(lexer);
        OPPLPatternScriptParser parser = new OPPLPatternScriptParser(tokens);
        parser.setTreeAdaptor(adaptor);
        RuleReturnScope r = parser.pattern();
        CommonTree tree = (CommonTree) r.getTree();
        CommonTreeNodeStream nodes = new CommonTreeNodeStream(tree);
        nodes.setTokenStream(tokens); // where to find tokens
        nodes.setTreeAdaptor(adaptor);
        nodes.reset();
        // RESOLVE SYMBOLS, COMPUTE EXPRESSION TYPES
        ManchesterOWLSyntaxSimplify simplify = new ManchesterOWLSyntaxSimplify(nodes);
        simplify.setTreeAdaptor(adaptor);
        simplify.downup(tree);
        return (OPPLSyntaxTree) r.getTree();
    }
}
