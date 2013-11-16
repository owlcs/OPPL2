package org.coode.parsers.oppl.test;

import static org.coode.oppl.testontologies.TestOntologies.*;
import static org.coode.parsers.oppl.test.SymbolTables.getOPPLSymbolTable;
import static org.junit.Assert.*;

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
import org.coode.oppl.ConstraintSystem;
import org.coode.oppl.OPPLFactory;
import org.coode.oppl.OPPLScript;
import org.coode.oppl.variabletypes.InputVariable;
import org.coode.parsers.ManchesterOWLSyntaxSimplify;
import org.coode.parsers.ManchesterOWLSyntaxTypes;
import org.coode.parsers.common.SilentListener;
import org.coode.parsers.oppl.DefaultTypeEnforcer;
import org.coode.parsers.oppl.OPPLDefine;
import org.coode.parsers.oppl.OPPLLexer;
import org.coode.parsers.oppl.OPPLScriptParser;
import org.coode.parsers.oppl.OPPLSymbolTable;
import org.coode.parsers.oppl.OPPLSyntaxTree;
import org.coode.parsers.oppl.OPPLTypeEnforcement;
import org.coode.parsers.oppl.OPPLTypes;
import org.junit.Test;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.reasoner.OWLReasoner;

import uk.ac.manchester.cs.jfact.JFactFactory;

/** Test for the AST generation for OPPL
 * 
 * @author Luigi Iannone */
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

    @Test
    public void shouldTestSubClassQuery() {
        String query = "?x:CLASS SELECT ?x subClassOf Thing BEGIN ADD ?x subClassOf Thing END;";
        OPPLSyntaxTree parsed = this.parse(query, syntax);
        assertNotNull(parsed);
        assertNotNull(parsed.getOPPLContent());
        equalsIgnoreWhitespace(query, parsed.getOPPLContent());
    }

    @Test
    public void shouldTestRegexpQuery() {
        String query = "?x:CLASS = MATCH (\".*ing\") SELECT ?x subClassOf Thing BEGIN ADD ?x subClassOf Thing END;";
        OPPLSyntaxTree parsed = this.parse(query, syntax);
        assertNotNull(parsed);
        assertNotNull(parsed.getOPPLContent());
        equalsIgnoreWhitespace(query, parsed.getOPPLContent());
    }

    @Test
    public void shouldTestAggregateVaraibleValuesAndLooseObjects() {
        String query = "?x:CLASS, ?y:CLASS = createIntersection(?x.VALUES,Thing)  SELECT ?x subClassOf Thing BEGIN ADD ?x subClassOf Thing END;";
        OPPLSyntaxTree parsed = this.parse(query, syntax);
        assertNotNull(parsed);
        assertNotNull(parsed.getOPPLContent());
        equalsIgnoreWhitespace(query, parsed.getOPPLContent());
    }

    @Test
    public void shouldTestGeneratedVariable() {
        OWLOntology ontology = ondrejtest;
        String query = "?x:CLASS, ?y:OBJECTPROPERTY = MATCH(\" has((\\w+)) \"), ?z:CLASS, ?feature:CLASS = create(?y.GROUPS(1)) SELECT ASSERTED ?x subClassOf ?y some ?z BEGIN REMOVE ?x subClassOf ?y some ?z, ADD ?x subClassOf !hasFeature some (?feature and !hasValue some ?z) END;";
        OPPLSyntaxTree parsed = this.parse(query, ontology);
        assertNotNull(parsed);
        assertNotNull(parsed.getOPPLContent());
        equalsIgnoreWhitespace(query, parsed.getOPPLContent());
    }

    protected OPPLSyntaxTree parse(String input, OWLOntology ontology) {
        return OPPLScriptTypesParserTest.parse(input, ontology, null,
                getOPPLSymbolTable(pizza));
    }

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

    @Test
    public void shouldTestCreateIndividual() {
        OPPLSymbolTable symtab = getOPPLSymbolTable(managerForPizzaAndOndrej);
        OWLOntology ontology = ondrejtest;
        String query = "?x:CLASS, ?y:INDIVIDUAL = create(?x.RENDERING+\"Instance\") SELECT ASSERTED ?x subClassOf Pizza BEGIN REMOVE ?y types ?x END;";
        OPPLSyntaxTree parsed = OPPLScriptTypesParserTest.parse(query, ontology, null,
                symtab);
        assertNotNull(parsed);
        assertNotNull(parsed.getOPPLContent());
        equalsIgnoreWhitespace(query, parsed.getOPPLContent());
    }

    @Test
    public void shouldTestHasKey() {
        String query = "?x:CLASS SELECT ?x HasKey hasTopping Thing BEGIN ADD ?x subClassOf Thing END;";
        OPPLSyntaxTree parsed = this.parse(query, pizza);
        assertNotNull(parsed);
        assertNotNull(parsed.getOPPLContent());
        equalsIgnoreWhitespace(query, parsed.getOPPLContent());
    }

    @Test
    public void shouldTestAnnotationAssertionsInQuery() {
        String query = "?x:CLASS SELECT <blah#Luigi> label \"aLabel\" BEGIN ADD ?x subClassOf Thing END;";
        OPPLSyntaxTree parsed = this.parse(query, pizza);
        assertNotNull(parsed);
        assertNotNull(parsed.getOPPLContent());
        equalsIgnoreWhitespace(query, parsed.getOPPLContent());
    }

    @Test
    public void shouldTestAnnotationAssertionsInActions() {
        String query = "?x:CLASS SELECT ?x subClassOf Thing  BEGIN ADD <blah#Luigi> label \"aLabel\" END;";
        OPPLSyntaxTree parsed = this.parse(query, pizza);
        assertNotNull(parsed);
        assertNotNull(parsed.getOPPLContent());
        equalsIgnoreWhitespace(query, parsed.getOPPLContent());
    }

    @Test
    public void shouldTestSubClassQueryNAryAxiom() {
        String query = "?x:CLASS SELECT DisjointClasses set(Thing, Nothing) BEGIN ADD ?x subClassOf Thing END;";
        OPPLSyntaxTree parsed = this.parse(query, pizza);
        assertNotNull(parsed);
        assertNotNull(parsed.getOPPLContent());
        equalsIgnoreWhitespace(query, parsed.getOPPLContent());
    }

    @Test
    public void shouldTestSubClassQueryNAryAxiomVariableValues() {
        String query = "?x:CLASS SELECT DisjointClasses: set(?x.VALUES, Thing) BEGIN ADD ?x subClassOf Thing END;";
        OPPLSyntaxTree parsed = this.parse(query, pizza);
        assertNotNull(parsed);
        assertNotNull(parsed.getOPPLContent());
        equalsIgnoreWhitespace(query, parsed.getOPPLContent());
    }

    @Test
    public void shouldTestVariableIRIAttribute() {
        String query = "?x:CLASS SELECT ?x.IRI label \"aLabel\" BEGIN ADD ?x subClassOf Thing END;";
        OPPLSyntaxTree parsed = this.parse(query, pizza);
        assertNotNull(parsed);
        assertNotNull(parsed.getOPPLContent());
        equalsIgnoreWhitespace(query, parsed.getOPPLContent());
    }

    @Test
    public void shouldTestAsymmetricObjectProperty() {
        String query = "?x:OBJECTPROPERTY SELECT ?x subPropertyOf hasTopping BEGIN REMOVE Asymmetric ?x END;";
        OPPLSyntaxTree parsed = this.parse(query, pizza);
        assertNotNull(parsed);
        assertNotNull(parsed.getOPPLContent());
        equalsIgnoreWhitespace(query, parsed.getOPPLContent());
    }

    @Test
    public void shouldTestVariableScope() {
        JFactFactory reasonerFactory = new JFactFactory();
        OWLReasoner reasoner = reasonerFactory.createReasoner(pizza);
        String query = "?M:CLASS[subClassOf NamedPizza], ?I:CLASS, ?S:CLASS SELECT ?M SubClassOf hasTopping some ?I, ?M SubClassOf hasBase some ?S WHERE ?M != Nothing BEGIN ADD ?M SubClassOf Thing END;";
        OPPLSyntaxTree parsed = OPPLScriptTypesParserTest.parse(query, pizza, reasoner,
                getOPPLSymbolTable(pizza));
        assertNotNull(parsed);
        assertNotNull(parsed.getOPPLContent());
        equalsIgnoreWhitespace(query, parsed.getOPPLContent());
        assertTrue(((InputVariable<?>) ((OPPLScript) parsed.getOPPLContent())
                .getVariables().get(0)).getVariableScope() != null);
    }

    @Test
    public void shouldTestVariableScopeInverseProperty() {
        JFactFactory reasonerFactory = new JFactFactory();
        OWLReasoner reasoner = reasonerFactory.createReasoner(pizza);
        String query = "?M:CLASS[subClassOf NamedPizza], ?I:CLASS[subClassOf INV(hasTopping) some Thing], ?S:CLASS SELECT ?M SubClassOf hasTopping some ?I, ?M SubClassOf hasBase some ?S WHERE ?M != Nothing BEGIN ADD ?M SubClassOf Thing END;";
        OPPLSyntaxTree parsed = OPPLScriptTypesParserTest.parse(query, pizza, reasoner,
                getOPPLSymbolTable(pizza));
        assertNotNull(parsed);
        assertNotNull(parsed.getOPPLContent());
        equalsIgnoreWhitespace(query, parsed.getOPPLContent());
        assertTrue(((InputVariable<?>) ((OPPLScript) parsed.getOPPLContent())
                .getVariables().get(0)).getVariableScope() != null);
    }

    @Test
    public void shouldTestNoQuery() {
        String query = "?x:CLASS BEGIN ADD ?x subClassOf Thing END;";
        OPPLSyntaxTree parsed = this.parse(query, pizza);
        assertNotNull(parsed);
        assertNotNull(parsed.getOPPLContent());
        equalsIgnoreWhitespace(query, parsed.getOPPLContent());
    }

    @Test
    public void shouldTestNoVariablesQuery() {
        String query = "BEGIN ADD Nothing subClassOf Thing, REMOVE Thing subClassOf Nothing END;";
        OPPLSyntaxTree parsed = this.parse(query, pizza);
        assertNotNull(parsed);
        assertNotNull(parsed.getOPPLContent());
        equalsIgnoreWhitespace(query, parsed.getOPPLContent());
    }

    @Test
    public void shouldTestVariableAnnotationObject() {
        String query = "?x:CLASS, ?y:CONSTANT SELECT ?x.IRI label ?y BEGIN ADD ?x subClassOf  Thing END;";
        OPPLSyntaxTree parsed = this.parse(query, pizza);
        assertNotNull(parsed);
        assertNotNull(parsed.getOPPLContent());
        equalsIgnoreWhitespace(query, parsed.getOPPLContent());
    }

    @Test
    public void shouldTestNominalClassVariableValues() {
        String query = "?x:INDIVIDUAL,?sibling:CLASS = {?x }, ?siblingUnion:CLASS = createUnion(?sibling.VALUES) SELECT Robert hasSibling ?x BEGIN ADD Robert types  ?siblingUnion END;";
        OPPLSyntaxTree parsed = OPPLScriptTypesParserTest.parse(query, siblings, null,
                getOPPLSymbolTable(siblings));
        assertNotNull(parsed);
        assertNotNull(parsed.getOPPLContent());
        equalsIgnoreWhitespace(query, parsed.getOPPLContent());
    }

    @Test
    public void shouldTestLowerCase() {
        String query = "?x:CLASS=create(\"BLA\".toLowerCase) SELECT ?x subClassOf Thing BEGIN ADD ?x subClassOf Thing END;";
        OPPLSyntaxTree parsed = this.parse(query, pizza);
        assertNotNull(parsed);
        equalsIgnoreWhitespace(query, parsed.getOPPLContent());
        assertNotNull(parsed.getOPPLContent());
    }

    @Test
    public void shouldTestUpperCase() {
        String query = "?x:CLASS=create(\"BLA\".toUpperCase) SELECT ?x subClassOf Thing BEGIN ADD ?x subClassOf Thing END;";
        OPPLSyntaxTree parsed = this.parse(query, pizza);
        assertNotNull(parsed);
        equalsIgnoreWhitespace(query, parsed.getOPPLContent());
        assertNotNull(parsed.getOPPLContent());
    }

    @Test
    public void shouldTestLowerCaseInConcat() {
        String query = "?x:CLASS, ?y:CLASS=create(?x.RENDERING +\"_\"+\"BLA\".toLowerCase) SELECT ?x subClassOf Thing BEGIN ADD ?x subClassOf Thing END;";
        OPPLSyntaxTree parsed = this.parse(query, pizza);
        assertNotNull(parsed);
        equalsIgnoreWhitespace(query, parsed.getOPPLContent());
        assertNotNull(parsed.getOPPLContent());
    }

    private void equalsIgnoreWhitespace(String a, Object b) {
        StringBuilder b1 = new StringBuilder(a.toUpperCase().replace("OWL:", "")
                .replace("\"", "").replace("^^STRING", "").replace("TYPES", "TYPE")
                .replace("?", "").replace("!", "").replace("\n", "").replace(":", "")
                .replace("NOTHING, THING", "TB").replace("THING, NOTHING", "TB")
                .replace("THING", "").replace("INV(", "INVERSE(").replace(" ", "")
                .replace("(X.VALUES,)", "XV").replace("(,X.VALUES)", "XV"));
        StringBuilder b2 = new StringBuilder(b.toString().toUpperCase()
                .replace("OWL:", "").replace("\"", "").replace("?", "")
                .replace("^^STRING", "").replace(" VARIABLEMANSYNTAX##", "")
                .replace(":", "").replace("!", "").replace("NOTHING, THING", "TB")
                .replace("THING, NOTHING", "TB").replace("THING", "")
                .replace("(HASVALUE SOME Z)", "HASVALUESOMEZ").replace(" ", "")
                .replace("(X.VALUES,)", "XV").replace("(,X.VALUES)", "XV"));
        for (int i = 0; i < b1.length();) {
            if (Character.isWhitespace(b1.charAt(i)) || b1.charAt(i) == '?') {
                b1.deleteCharAt(i);
            } else {
                i++;
            }
        }
        for (int i = 0; i < b2.length();) {
            if (Character.isWhitespace(b2.charAt(i)) || b2.charAt(i) == '?') {
                b2.deleteCharAt(i);
            } else {
                i++;
            }
        }
        assertEquals(b1.toString(), b2.toString());
    }

    @Test
    public void shouldTestLowerCaseInConcatWithGroups() {
        String query = "?x:CLASS = MATCH(\"(.+)Topping\"), ?y:CLASS=create(\"Topping_\"+ ?x.GROUPS(1).toLowerCase) SELECT ?x SubClassOf Thing BEGIN ADD ?x subClassOf Thing END;";
        OPPLSyntaxTree parsed = OPPLScriptTypesParserTest.parse(query, pizza, null,
                getOPPLSymbolTable(pizza));
        assertNotNull(parsed);
        equalsIgnoreWhitespace(query, parsed.getOPPLContent());
        assertNotNull(parsed.getOPPLContent());
    }

    @Test
    public void shouldTestLowerCaseParenthesys() {
        String query = "?x:CLASS=create((\"Bla\"+ \"Bla\").toLowerCase) SELECT ?x subClassOf Thing BEGIN ADD ?x subClassOf Thing END;";
        OPPLSyntaxTree parsed = this.parse(query, pizza);
        assertNotNull(parsed);
        equalsIgnoreWhitespace(query.replace("(\"Bla\"+ \"Bla\")", "Bla+Bla"),
                parsed.getOPPLContent());
        assertNotNull(parsed.getOPPLContent());
    }

    @Test
    public void shouldTestUpperCaseInConcatWithGroups() {
        String query = "?x:CLASS = MATCH(\"(.+)Topping\"), ?y:CLASS=create(\"Topping_\"+ ?x.GROUPS(1).toUpperCase) SELECT ?x subClassOf Thing BEGIN ADD ?x subClassOf Thing END;";
        OPPLSyntaxTree parsed = this.parse(query, pizza);
        assertNotNull(parsed);
        equalsIgnoreWhitespace(query, parsed.getOPPLContent());
        assertNotNull(parsed.getOPPLContent());
    }

    @Test
    public void shouldTestUpperCaseInConcat() {
        String query = "?x:CLASS, ?y:CLASS=create(?x.RENDERING +\"_\"+\"BLA\".toUpperCase) SELECT ?x subClassOf Thing BEGIN ADD ?x subClassOf Thing END;";
        OPPLSyntaxTree parsed = this.parse(query, pizza);
        assertNotNull(parsed);
        equalsIgnoreWhitespace(query, parsed.getOPPLContent());
        assertNotNull(parsed.getOPPLContent());
    }
}
