package org.coode.parsers.oppl.patterns.test;

import static org.coode.oppl.patterntestontologies.PatternTestOntologies.*;
import static org.junit.Assert.*;

import java.util.Set;

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
import org.coode.parsers.Symbol;
import org.coode.parsers.common.SilentListener;
import org.coode.parsers.oppl.OPPLDefine;
import org.coode.parsers.oppl.OPPLSyntaxTree;
import org.coode.parsers.oppl.patterns.OPPLPatternLexer;
import org.coode.parsers.oppl.patterns.OPPLPatternScriptParser;
import org.coode.parsers.oppl.patterns.OPPLPatternsDefine;
import org.coode.parsers.oppl.patterns.OPPLPatternsSymbolTable;
import org.coode.patterns.AbstractPatternModelFactory;
import org.coode.patterns.OPPLPatternParser;
import org.coode.patterns.PatternConstraintSystem;
import org.coode.patterns.PatternModelFactory;
import org.junit.Test;
import org.semanticweb.owlapi.model.OWLOntology;

/** Test for the AST generation for OPPL
 * 
 * @author Luigi Iannone */
@SuppressWarnings("javadoc")
public class OPPLPatternsDefineParserTest {
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
    private OPPLPatternsSymbolTable symtab;

    public static OPPLPatternsSymbolTable getOPPLPatternSymbolTable(OWLOntology o) {
        OPPLPatternsSymbolTable symtab = new org.coode.parsers.oppl.patterns.factory.SimpleSymbolTableFactory(
                o.getOWLOntologyManager()).createSymbolTable();
        symtab.setErrorListener(new SilentListener());
        return symtab;
    }

    @Test
    public void shouldTestFood() {
        symtab = getOPPLPatternSymbolTable(food);
        String patternString = "?x:CLASS, ?y:CLASS, ?forbiddenContent:CLASS = createUnion(?x.VALUES) BEGIN ADD $thisClass equivalentTo contains only (not ?forbiddenContent) END; A ?x free stuff; RETURN $thisClass";
        OPPLSyntaxTree parsed = parse(patternString, syntax);
        assertNotNull(parsed);
        Set<Symbol> definedSymbols = symtab.getDefinedSymbols();
        assertTrue("Exected 5 actual " + definedSymbols.size() + " " + definedSymbols,
                definedSymbols.size() == 4);
    }

    @Test
    public void shouldTestMenu() {
        symtab = getOPPLPatternSymbolTable(food);
        String patternString = "?x:CLASS[subClassOf Food] BEGIN ADD $thisClass subClassOf Menu, ADD $thisClass subClassOf contains only (Course and contains only ($Free(?x))) END; A ?x free Menu";
        OPPLSyntaxTree parsed = parse(patternString, food);
        assertNotNull(parsed);
        Set<Symbol> definedSymbols = symtab.getDefinedSymbols();
        assertTrue("Exected 3 actual " + definedSymbols.size() + " " + definedSymbols,
                definedSymbols.size() == 2);
    }

    @Test
    public void shouldTestPizza() {
        symtab = getOPPLPatternSymbolTable(food);
        String patternString = "?base:CLASS,?topping:CLASS, ?allToppings:CLASS = createUnion(?topping.VALUES) BEGIN ADD $thisClass subClassOf Pizza, ADD $thisClass subClassOf hasTopping some ?topping,  ADD $thisClass subClassOf hasTopping only ?allToppings, ADD $thisClass subClassOf hasBase some ?base  END; A pizza with ?base base and ?topping toppings";
        OPPLSyntaxTree parsed = parse(patternString, syntax);
        assertNotNull(parsed);
        Set<Symbol> definedSymbols = symtab.getDefinedSymbols();
        assertTrue("Exected 5 actual " + definedSymbols.size() + " " + definedSymbols,
                definedSymbols.size() == 4);
    }

    @Test
    public void shouldTestDOLCEInformationRealization() {
        symtab = getOPPLPatternSymbolTable(food);
        String patternString = "?informationObject:CLASS, ?informationRealization:CLASS, ?realizationProperty:OBJECTPROPERTY BEGIN ADD ?informationRealization subClassOf InformationRealization, ADD ?informationObject subClassOf InformationObject, ADD ?realizationProperty subPropertyOf realizes, ADD ?informationRealization subClassOf PhysicalObject and ?realizationProperty some ?InformationObject END;Information Realization Pattern: ?informationRealization ?realizationProperty ?informationObject";
        OPPLSyntaxTree parsed = parse(patternString, syntax);
        assertNotNull(parsed);
        Set<Symbol> definedSymbols = symtab.getDefinedSymbols();
        assertTrue("Exected 3 actual " + definedSymbols.size() + " " + definedSymbols,
                definedSymbols.size() == 3);
    }

    @Test
    public void shouldTestDOLCEPersonRoleTimeInterval() {
        symtab = getOPPLPatternSymbolTable(food);
        String patternString = "?person:CLASS, ?role:CLASS, ?timeInterval:CLASS BEGIN ADD $thisClass subClassOf Situation, ADD $thisClass subClassOf isSettingFor some ?person, ADD $thisClass subClassOf isSettingFor some ?role, ADD $thisClass subClassOf isSettingFor some ?timeInterval END; Situation where ?person play the role ?role during the time interval ?timeInterval";
        OPPLSyntaxTree parsed = parse(patternString, syntax);
        assertNotNull(parsed);
        Set<Symbol> definedSymbols = symtab.getDefinedSymbols();
        assertTrue("Exected 4 actual " + definedSymbols.size() + " " + definedSymbols,
                definedSymbols.size() == 4);
    }

    protected OPPLSyntaxTree parse(String input, OWLOntology o) {
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
        AbstractPatternModelFactory factory = new PatternModelFactory(o,
                o.getOWLOntologyManager());
        PatternConstraintSystem constraintSystem = factory.createConstraintSystem();
        OPPLDefine define = new OPPLDefine(nodes, symtab, new SilentListener(),
                constraintSystem);
        define.setTreeAdaptor(adaptor);
        define.downup(tree);
        nodes.reset();
        OPPLPatternsDefine patternsDefine = new OPPLPatternsDefine(nodes, symtab,
                new SilentListener(),
                OPPLPatternParser.getSimplePatternReferenceResolver(), constraintSystem);
        patternsDefine.setTreeAdaptor(adaptor);
        patternsDefine.downup(tree);
        return (OPPLSyntaxTree) r.getTree();
    }
}
