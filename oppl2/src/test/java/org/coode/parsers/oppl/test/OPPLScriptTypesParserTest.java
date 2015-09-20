package org.coode.parsers.oppl.test;

import static org.coode.oppl.testontologies.TestOntologies.*;
import static org.coode.parsers.oppl.test.SymbolTables.getOPPLSymbolTable;
import static org.junit.Assert.*;

import org.antlr.runtime.*;
import org.antlr.runtime.tree.CommonErrorNode;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.CommonTreeAdaptor;
import org.antlr.runtime.tree.CommonTreeNodeStream;
import org.antlr.runtime.tree.TreeAdaptor;
import org.coode.oppl.ConstraintSystem;
import org.coode.oppl.OPPLFactory;
import org.coode.oppl.OPPLScript;
import org.coode.oppl.variabletypes.InputVariable;
import org.coode.parsers.ManchesterOWLSyntaxSimplify;
import org.coode.parsers.ManchesterOWLSyntaxTypes;
import org.coode.parsers.common.SilentListener;
import org.coode.parsers.oppl.*;
import org.junit.ComparisonFailure;
import org.junit.Test;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.reasoner.OWLReasoner;

import uk.ac.manchester.cs.jfact.JFactFactory;

/**
 * Test for the AST generation for OPPL
 * 
 * @author Luigi Iannone
 */
@SuppressWarnings("javadoc")
public class OPPLScriptTypesParserTest {

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

    public static OPPLSyntaxTree parse(String input, OWLOntology ontology,
        OWLReasoner reasoner, OPPLSymbolTable symtab) {
        OPPLFactory opplFactory = new OPPLFactory(ontology.getOWLOntologyManager(),
            ontology, reasoner);
        ConstraintSystem constraintSystem = opplFactory.createConstraintSystem();
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
            nodes.reset();
            OPPLDefine define = new OPPLDefine(nodes, symtab, new SilentListener(),
                constraintSystem);
            define.setTreeAdaptor(adaptor);
            define.downup(tree);
            nodes.reset();
            ManchesterOWLSyntaxTypes mOWLTypes = new ManchesterOWLSyntaxTypes(nodes,
                symtab, new SilentListener());
            mOWLTypes.downup(tree);
            nodes.reset();
            OPPLTypeEnforcement typeEnforcement = new OPPLTypeEnforcement(nodes, symtab,
                new DefaultTypeEnforcer(symtab, opplFactory.getOWLEntityFactory(),
                    new SilentListener()), new SilentListener());
            typeEnforcement.downup(tree);
            nodes.reset();
            mOWLTypes.downup(tree);
            nodes.reset();
            OPPLTypes opplTypes = new OPPLTypes(nodes, symtab, new SilentListener(),
                constraintSystem, opplFactory);
            opplTypes.downup(tree);
        }
        return (OPPLSyntaxTree) r.getTree();
    }

    protected void check(OWLOntology ontology, String query, String expected, OPPLSymbolTable table) {
        OPPLSyntaxTree parsed = OPPLScriptTypesParserTest.parse(query, ontology, null,
            table);
        assertNotNull(parsed);
        Object opplContent = parsed.getOPPLContent();
        assertNotNull(opplContent);
        equalsIgnoreWhitespace(expected, opplContent);
    }

    protected void check(OWLOntology ontology, String query, String expected) {
        check(ontology, query, expected,
            getOPPLSymbolTable(ontology));
    }

    protected void check(OWLOntology ontology, String query, String expected, OWLReasoner reasoner) {
        OPPLSyntaxTree parsed = OPPLScriptTypesParserTest.parse(query, ontology, reasoner,
            getOPPLSymbolTable(pizza));
        assertNotNull(parsed);
        Object opplContent = parsed.getOPPLContent();
        assertNotNull(opplContent);
        equalsIgnoreWhitespace(expected, opplContent);
        assertTrue(((InputVariable<?>) ((OPPLScript) opplContent)
            .getVariables().get(0)).getVariableScope() != null);
    }

    @Test
    public void shouldTestSubClassQuery() {
        String query = "?x:CLASS SELECT ?x subClassOf Thing\n BEGIN ADD ?x subClassOf Thing END;";
        check(syntax, query, query);
    }

    @Test
    public void shouldTestRegexpQuery() {
        String query = "?x:CLASS= MATCH (\".*ing\") SELECT ?x subClassOf Thing\n BEGIN ADD ?x subClassOf Thing END;";
        check(syntax, query, query);
    }

    @Test
    public void shouldTestAggregateVariableValuesAndLooseObjects() {
        String query = "?x:CLASS, ?y:CLASS = createIntersection(?x.VALUES, Thing) SELECT ?x subClassOf Thing\n BEGIN ADD ?x subClassOf Thing END;";
        // XXX expected has owl:Thing
        String expected = "?x:CLASS, ?y:CLASS = createIntersection(?x.VALUES, owl:Thing) SELECT ?x subClassOf Thing\n BEGIN ADD ?x subClassOf Thing END;";
        check(syntax, query, expected);
    }

    @Test
    public void shouldTestGeneratedVariable() {
        String query = "?x:CLASS, ?y:OBJECTPROPERTY= MATCH (\" has((\\w+)) \"), ?z:CLASS, ?feature:CLASS = create(?y.GROUPS(1)) SELECT ASSERTED ?x subClassOf ?y some ?z\n BEGIN REMOVE ?x subClassOf ?y some ?z, ADD ?x subClassOf !hasFeature some (?feature and !hasValue some ?z) END;";
        String expected = "?x:CLASS, ?y:OBJECTPROPERTY= MATCH (\" has((\\w+)) \"), ?z:CLASS, ?feature:CLASS = create(?y.GROUPS(1)) SELECT ASSERTED ?x SubClassOf ?y some ?z\n"
            +
            " BEGIN REMOVE ?x SubClassOf ?y some ?z, ADD ?x SubClassOf hasFeature some \n" +
            "(?feature and (hasValue some ?z)) END;";
        // XXX expected is missing a ! before hasValue
        check(ondrejtest, query, expected);
    }

    @Test
    public void shouldTestCreateIndividual() {
        String query = "?x:CLASS, ?y:INDIVIDUAL = create(?x.RENDERING+\"Instance\") SELECT ASSERTED ?x subClassOf Pizza\n BEGIN REMOVE ?y types ?x END;";
        String expected = "?x:CLASS, ?y:INDIVIDUAL = create(?x.RENDERING+\"Instance\") "
            + "SELECT ASSERTED ?x subClassOf Pizza\n BEGIN REMOVE ?y type ?x END;";
        check(ondrejtest, query, expected, getOPPLSymbolTable(managerForPizzaAndOndrej));
    }

    @Test
    public void shouldTestHasKey() {
        String query = "?x:CLASS SELECT ?x HasKey hasTopping Thing\n BEGIN ADD ?x subClassOf Thing END;";
        String expected = "?x:CLASS SELECT ?x HasKey hasTopping\n BEGIN ADD ?x subClassOf Thing END;";
        check(pizza, query, expected);
    }

    @Test
    public void shouldTestAnnotationAssertionsInQuery() {
        String query = "?x:CLASS SELECT <blah#Luigi> label \"aLabel\"\n BEGIN ADD ?x subClassOf Thing END;";
        String expected = "?x:CLASS SELECT <blah#Luigi> label \"aLabel\"^^string\n BEGIN ADD ?x subClassOf Thing END;";
        check(pizza, query, expected);
    }

    @Test
    public void shouldTestAnnotationAssertionsInActions() {
        String query = "?x:CLASS SELECT ?x subClassOf Thing \n BEGIN ADD <blah#Luigi> label \"aLabel\" END;";
        String expected = "?x:CLASS SELECT ?x subClassOf Thing\n BEGIN ADD <blah#Luigi> label \"aLabel\"^^string END;";
        check(pizza, query, expected);
    }

    @Test
    public void shouldTestSubClassQueryNAryAxiom() {
        String query = "?x:CLASS SELECT DisjointClasses set(Thing, Nothing)\n BEGIN ADD ?x subClassOf Thing END;";
        // XXX DisjointClasses set is changed
        String expected = "?x:CLASS SELECT Nothing DisjointWith Thing\n" +
            " BEGIN ADD ?x SubClassOf Thing END;";
        check(pizza, query, expected);
    }

    @Test
    public void shouldTestSubClassQueryNAryAxiomVariableValues() {
        String query = "?x:CLASS SELECT DisjointClasses: set(?x.VALUES, Thing)\n BEGIN ADD ?x subClassOf Thing END;";
        String expected = "?x:CLASS SELECT ?x.VALUES DisjointWith Thing\n" +
            " BEGIN ADD ?x SubClassOf Thing END;";
        check(pizza, query, expected);
    }

    @Test
    public void shouldTestVariableIRIAttribute() {
        String query = "?x:CLASS SELECT ?x.IRI label \"aLabel\"\n BEGIN ADD ?x subClassOf Thing END;";
        // XXX Literals require a datatype?
        String expected = "?x:CLASS SELECT ?x.IRI label \"aLabel\"^^string\n BEGIN ADD ?x subClassOf Thing END;";
        check(pizza, query, expected);
    }

    @Test
    public void shouldTestAsymmetricObjectProperty() {
        String query = "?x:OBJECTPROPERTY SELECT ?x subPropertyOf hasTopping\n BEGIN REMOVE Asymmetric ?x END;";
        // XXX rendering contains Asymmetric:
        String expected = "?x:OBJECTPROPERTY SELECT ?x subPropertyOf hasTopping\n BEGIN REMOVE  Asymmetric: ?x END;";
        check(pizza, query, expected);
    }

    @Test
    public void shouldTestVariableScope() {
        String query = "?M:CLASS[subClassOf NamedPizza], ?I:CLASS, ?S:CLASS SELECT ?M SubClassOf hasTopping some ?I,\n?M SubClassOf hasBase some ?S\n WHERE ?M != Nothing\n BEGIN ADD ?M SubClassOf Thing END;";
        check(pizza, query, query, new JFactFactory().createReasoner(pizza));
    }

    @Test
    public void shouldTestVariableScopeInverseProperty() {
        String query = "?M:CLASS[subClassOf NamedPizza], ?I:CLASS[subClassOf INV(hasTopping) some Thing], ?S:CLASS SELECT ?M SubClassOf hasTopping some ?I, ?M SubClassOf hasBase some ?S WHERE ?M != Nothing\n BEGIN ADD ?M SubClassOf Thing END;";
        // XXX INV becomes inverse
        String expected = "?M:CLASS[subClassOf NamedPizza], ?I:CLASS[subClassOf  inverse (hasTopping) some Thing], ?S:CLASS"
            + " SELECT ?M SubClassOf hasTopping some ?I,\n?M SubClassOf hasBase some ?S\n WHERE ?M != Nothing\n BEGIN ADD ?M SubClassOf Thing END;";
        check(pizza, query, expected, new JFactFactory().createReasoner(pizza));
    }

    @Test
    public void shouldTestNoQuery() {
        String query = "?x:CLASS  BEGIN ADD ?x subClassOf Thing END;";
        check(pizza, query, query);
    }

    @Test
    public void shouldTestNoVariablesQuery() {
        String query = " BEGIN ADD Nothing subClassOf Thing, REMOVE Thing subClassOf Nothing END;";
        check(pizza, query, query);
    }

    @Test
    public void shouldTestVariableAnnotationObject() {
        String query = "?x:CLASS, ?y:CONSTANT SELECT ?x.IRI label ?y\n BEGIN ADD ?x subClassOf Thing END;";
        // XXX ?y rendered as string
        String expected = "?x:CLASS, ?y:CONSTANT SELECT ?x.IRI label \"?y\"^^string\n BEGIN ADD ?x subClassOf Thing END;";
        check(pizza, query, expected);
    }

    @Test
    public void shouldTestNominalClassVariableValues() {
        String query = "?x:INDIVIDUAL, ?sibling:CLASS = {?x}, ?siblingUnion:CLASS = createUnion(?sibling.VALUES) SELECT Robert hasSibling ?x\n BEGIN ADD Robert types ?siblingUnion END;";
        // XXX expected has type instead of types
        String expected = "?x:INDIVIDUAL, ?sibling:CLASS = {?x}, ?siblingUnion:CLASS = createUnion(?sibling.VALUES) SELECT Robert hasSibling ?x\n BEGIN ADD Robert type ?siblingUnion END;";
        check(siblings, query, expected);
    }

    @Test
    public void shouldTestLowerCase() {
        String query = "?x:CLASS = create(\"BLA\".toLowerCase) SELECT ?x subClassOf Thing\n BEGIN ADD ?x subClassOf Thing END;";
        check(pizza, query, query);
    }

    @Test
    public void shouldTestUpperCase() {
        String query = "?x:CLASS = create(\"BLA\".toUpperCase) SELECT ?x subClassOf Thing\n BEGIN ADD ?x subClassOf Thing END;";
        check(pizza, query, query);
    }

    @Test
    public void shouldTestLowerCaseInConcat() {
        String query = "?x:CLASS, ?y:CLASS = create(?x.RENDERING+\"_\"+\"BLA\".toLowerCase) SELECT ?x subClassOf Thing\n BEGIN ADD ?x subClassOf Thing END;";
        check(pizza, query, query);
    }

    private void equalsIgnoreWhitespace(String a, Object b) {
        if (!a.toLowerCase().equals(b.toString().toLowerCase())) {
            System.out.println(new ComparisonFailure("", a,
                b.toString()));
            System.out.println("OPPLScriptTypesParserTest.equalsIgnoreWhitespace() " + b.toString());
        }
        assertEquals(a.toLowerCase(), b.toString().toLowerCase());
    }

    @Test
    public void shouldTestLowerCaseInConcatWithGroups() {
        String query = "?x:CLASS= MATCH (\"(.+)Topping\"), ?y:CLASS = create(\"Topping_\"+?x.GROUPS(1).toLowerCase) SELECT ?x SubClassOf Thing\n BEGIN ADD ?x subClassOf Thing END;";
        check(pizza, query, query);
    }

    @Test
    public void shouldTestLowerCaseParenthesys() {
        String query = "?x:CLASS = create(\"Bla\"+\"Bla\".toLowerCase) SELECT ?x subClassOf Thing\n BEGIN ADD ?x subClassOf Thing END;";
        check(pizza, query, query);
    }

    @Test
    public void shouldTestUpperCaseInConcatWithGroups() {
        String query = "?x:CLASS= MATCH (\"(.+)Topping\"), ?y:CLASS = create(\"Topping_\"+?x.GROUPS(1).toUpperCase) SELECT ?x subClassOf Thing\n BEGIN ADD ?x subClassOf Thing END;";
        check(pizza, query, query);
    }

    @Test
    public void shouldTestUpperCaseInConcat() {
        String query = "?x:CLASS, ?y:CLASS = create(?x.RENDERING+\"_\"+\"BLA\".toUpperCase) SELECT ?x subClassOf Thing\n BEGIN ADD ?x subClassOf Thing END;";
        check(pizza, query, query);
    }
}
