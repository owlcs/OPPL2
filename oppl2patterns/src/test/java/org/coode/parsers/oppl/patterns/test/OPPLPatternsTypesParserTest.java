package org.coode.parsers.oppl.patterns.test;

import static org.coode.oppl.patterntestontologies.PatternTestOntologies.df;
import static org.coode.oppl.patterntestontologies.PatternTestOntologies.dul;
import static org.coode.oppl.patterntestontologies.PatternTestOntologies.food;
import static org.coode.oppl.patterntestontologies.PatternTestOntologies.pizza;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

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
import org.coode.oppl.Variable;
import org.coode.oppl.VariableVisitorEx;
import org.coode.oppl.generated.GeneratedVariable;
import org.coode.oppl.generated.RegexpGeneratedVariable;
import org.coode.oppl.variabletypes.InputVariable;
import org.coode.parsers.ErrorListener;
import org.coode.parsers.ManchesterOWLSyntaxSimplify;
import org.coode.parsers.ManchesterOWLSyntaxTypes;
import org.coode.parsers.common.SilentListener;
import org.coode.parsers.common.SystemErrorEcho;
import org.coode.parsers.oppl.DefaultTypeEnforcer;
import org.coode.parsers.oppl.OPPLDefine;
import org.coode.parsers.oppl.OPPLSyntaxTree;
import org.coode.parsers.oppl.OPPLTypeEnforcement;
import org.coode.parsers.oppl.OPPLTypes;
import org.coode.parsers.oppl.patterns.OPPLPatternLexer;
import org.coode.parsers.oppl.patterns.OPPLPatternScriptParser;
import org.coode.parsers.oppl.patterns.OPPLPatternsDefine;
import org.coode.parsers.oppl.patterns.OPPLPatternsReferenceDefine;
import org.coode.parsers.oppl.patterns.OPPLPatternsSymbolTable;
import org.coode.parsers.oppl.patterns.OPPLPatternsTypes;
import org.coode.parsers.oppl.patterns.factory.SimpleSymbolTableFactory;
import org.coode.patterns.OPPLPatternParser.PatternReferenceResolver;
import org.coode.patterns.PatternConstraintSystem;
import org.coode.patterns.PatternModel;
import org.coode.patterns.PatternModelFactory;
import org.junit.Test;
import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLObject;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;
import org.semanticweb.owlapi.model.OWLOntologyManager;

import uk.ac.manchester.cs.jfact.JFactFactory;

/**
 * Test for the AST generation for OPPL
 * 
 * @author Luigi Iannone
 */
@SuppressWarnings("javadoc")
public class OPPLPatternsTypesParserTest {

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
    private final ErrorListener listener = new SystemErrorEcho();
    JFactFactory factory = new JFactFactory();

    /**
     * @return reference resolver
     */
    public static PatternReferenceResolver getSimplePatternReferenceResolver() {
        return (reference, patternName, constraintSystem, symbolTable, args) -> symbolTable
            .resolvePattern(reference, patternName, constraintSystem, args);
    }

    @Test
    public void shouldTestFood() {
        String patternString =
            "?x:CLASS, ?y:CLASS, ?forbiddenContent:CLASS = createUnion(?x.VALUES) BEGIN ADD $thisClass equivalentTo contains only (not ?forbiddenContent) END; A ?x free stuff; RETURN $thisClass";
        OPPLSyntaxTree parsed = parse(patternString, food);
        assertNotNull(parsed);
        assertNotNull(parsed.getOPPLContent());
        PatternModel patternModel = (PatternModel) parsed.getOPPLContent();
        Variable<?> variable = patternModel.getConstraintSystem().getVariable("?forbiddenContent");
        assertNotNull(variable);
        boolean isGenerated = variable.accept(new VariableVisitorEx<Boolean>() {

            @Override
            public <P extends OWLObject> Boolean visit(GeneratedVariable<P> v) {
                return Boolean.TRUE;
            }

            @Override
            public <P extends OWLObject> Boolean visit(InputVariable<P> v) {
                return Boolean.FALSE;
            }

            @Override
            public <P extends OWLObject> Boolean visit(RegexpGeneratedVariable<P> regExpGenerated) {
                return Boolean.FALSE;
            }
        }).booleanValue();
        assertTrue(isGenerated);
    }

    @Test
    public void shouldTestMenu() {
        String patternString =
            "?x:CLASS[subClassOf Food] BEGIN ADD $thisClass subClassOf Menu, ADD $thisClass subClassOf contains only (Course and contains only ($Free(?x))) END; A ?x free Menu";
        OPPLSyntaxTree parsed = parse(patternString, food);
        assertNotNull(parsed);
        assertNotNull(parsed.getOPPLContent());
    }

    @Test
    public void shouldTestPizza() {
        String patternString =
            "?base:CLASS,?topping:CLASS, ?allToppings:CLASS = createUnion(?topping.VALUES) BEGIN ADD $thisClass subClassOf Pizza, ADD $thisClass subClassOf hasTopping some ?topping,  ADD $thisClass subClassOf hasTopping only ?allToppings, ADD $thisClass subClassOf hasBase some ?base  END; A pizza with ?base base and ?topping toppings";
        OPPLSyntaxTree parsed = parse(patternString, pizza);
        assertNotNull(parsed);
        assertNotNull(parsed.getOPPLContent());
    }

    @Test
    public void shouldTestNoVariablePattern() {
        String patternString = " BEGIN ADD Menu subClassOf Menu END; A variable free pattern";
        OPPLSyntaxTree parsed = parse(patternString, food);
        assertNotNull(parsed);
        assertNotNull(parsed.getOPPLContent());
    }

    @Test
    public void shouldTestComplexExpressionConjuntionGeneratedVariablePattern()
        throws OWLOntologyCreationException {
        OWLOntology ontology = OWLManager.createOWLOntologyManager().createOntology();
        OWLOntologyManager m = ontology.getOWLOntologyManager();
        m.addAxiom(ontology, df.getOWLDeclarationAxiom(df.getOWLObjectProperty(
            IRI.create(" http://www.co-ode.org/ontologies/ont.owl#part_of"))));
        String patternString =
            "?cell:CLASS, ?anatomyPart:CLASS, ?partOfRestriction:CLASS = part_of some ?anatomyPart, ?anatomyIntersection:CLASS = createIntersection(?partOfRestriction.VALUES) BEGIN ADD ?cell equivalentTo ?anatomyIntersection END;";
        OPPLSyntaxTree parsed = parse(patternString, ontology);
        assertNotNull(parsed);
        assertNotNull(parsed.getOPPLContent());
    }

    @Test
    public void shouldTestDOLCEInformationRealization() {
        String patternString =
            "?informationObject:CLASS, ?informationRealization:CLASS, ?realizationProperty:OBJECTPROPERTY BEGIN ADD ?informationRealization subClassOf InformationRealization, ADD ?informationObject subClassOf InformationObject, ADD ?realizationProperty subPropertyOf realizes, ADD ?informationRealization subClassOf PhysicalObject and ?realizationProperty some ?informationObject END; Information Realization Pattern: ?informationRealization ?realizationProperty ?informationObject";
        OPPLSyntaxTree parsed = parse(patternString, dul);
        assertNotNull(parsed);
        assertNotNull(parsed.getOPPLContent());
    }

    @Test
    public void shouldTestDOLCEPersonRoleTimeInterval() {
        String patternString =
            "?person:CLASS, ?role:CLASS, ?timeInterval:CLASS BEGIN ADD $thisClass subClassOf Situation, ADD $thisClass subClassOf isSettingFor some ?person, ADD $thisClass subClassOf isSettingFor some ?role, ADD $thisClass subClassOf isSettingFor some ?timeInterval END; Situation where ?person play the role ?role during the time interval ?timeInterval";
        OPPLSyntaxTree parsed = parse(patternString, dul);
        assertNotNull(parsed);
        assertNotNull(parsed.getOPPLContent());
    }

    protected OPPLSyntaxTree parse(String input, OWLOntology o) {
        OPPLPatternsSymbolTable symtab =
            new SimpleSymbolTableFactory(o.getOWLOntologyManager()).createSymbolTable();
        symtab.setErrorListener(getListener());
        ANTLRStringStream antlrStringStream = new ANTLRStringStream(input);
        OPPLPatternLexer lexer = new OPPLPatternLexer(antlrStringStream);
        PatternModelFactory patternModelFactory =
            new PatternModelFactory(o, o.getOWLOntologyManager(), factory.createReasoner(o));
        PatternConstraintSystem constraintSystem = patternModelFactory.createConstraintSystem();
        final TokenRewriteStream tokens = new TokenRewriteStream(lexer);
        OPPLPatternScriptParser parser = new OPPLPatternScriptParser(tokens, getListener());
        parser.setTreeAdaptor(adaptor);
        RuleReturnScope r = parser.pattern();
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
            nodes.reset();
            OPPLDefine define = new OPPLDefine(nodes, symtab, getListener(), constraintSystem);
            define.setTreeAdaptor(adaptor);
            define.downup(tree);
            nodes.reset();
            OPPLPatternsDefine patternsDefine = new OPPLPatternsDefine(nodes, symtab, getListener(),
                getSimplePatternReferenceResolver(), constraintSystem);
            patternsDefine.setTreeAdaptor(adaptor);
            patternsDefine.downup(tree);
            nodes.reset();
            ErrorListener silentErrorListener = new SilentListener();
            symtab.setErrorListener(silentErrorListener);
            ManchesterOWLSyntaxTypes mOWLTypes =
                new ManchesterOWLSyntaxTypes(nodes, symtab, silentErrorListener);
            mOWLTypes.downup(tree);
            nodes.reset();
            OPPLTypeEnforcement typeEnforcement = new OPPLTypeEnforcement(nodes, symtab,
                new DefaultTypeEnforcer(symtab,
                    patternModelFactory.getOPPLFactory().getOWLEntityFactory(), getListener()),
                getListener());
            typeEnforcement.downup(tree);
            nodes.reset();
            mOWLTypes.downup(tree);
            nodes.reset();
            OPPLTypes opplTypes = new OPPLTypes(nodes, symtab, silentErrorListener,
                constraintSystem, patternModelFactory.getOPPLFactory());
            opplTypes.downup(tree);
            nodes.reset();
            OPPLPatternsReferenceDefine patternReferenceDefine =
                new OPPLPatternsReferenceDefine(nodes, symtab, getListener(),
                    getSimplePatternReferenceResolver(), constraintSystem);
            patternReferenceDefine.setTreeAdaptor(adaptor);
            patternReferenceDefine.downup(tree);
            nodes.reset();
            symtab.setErrorListener(getListener());
            mOWLTypes = new ManchesterOWLSyntaxTypes(nodes, symtab, getListener());
            mOWLTypes.downup(tree);
            nodes.reset();
            opplTypes.downup(tree);
            nodes.reset();
            OPPLPatternsTypes opplPatternsTypes = new OPPLPatternsTypes(nodes, symtab,
                getListener(), constraintSystem, patternModelFactory);
            opplPatternsTypes.downup(tree);
        }
        return (OPPLSyntaxTree) tree;
    }

    /**
     * @return the listener
     */
    public ErrorListener getListener() {
        return listener;
    }
}
