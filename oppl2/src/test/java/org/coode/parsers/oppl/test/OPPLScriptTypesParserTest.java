package org.coode.parsers.oppl.test;

import static org.coode.oppl.Ontologies.*;
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
import org.coode.parsers.ErrorListener;
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
    private final ErrorListener listener = new SilentListener();
    OPPLSymbolTable symtab = getOPPLSymbolTable(pizza);

    @Test
    public void testSubClassQuery() {
        String query = "?x:CLASS SELECT ?x subClassOf Thing BEGIN ADD ?x subClassOf Thing END;";
        OPPLSyntaxTree parsed = this.parse(query, syntax);
        System.out.println(parsed.toStringTree());
        assertNotNull(parsed);
        assertNotNull(parsed.getOPPLContent());
        System.out.println("original script: \t" + query);
        System.out.println("parsed content:  \t" + parsed.getOPPLContent());
    }

    @Test
    public void testRegexpQuery() {
        String query = "?x:CLASS = MATCH (\".*ing\") SELECT ?x subClassOf Thing BEGIN ADD ?x subClassOf Thing END;";
        OPPLSyntaxTree parsed = this.parse(query, syntax);
        System.out.println(parsed.toStringTree());
        assertNotNull(parsed);
        assertNotNull(parsed.getOPPLContent());
        System.out.println("original script: \t" + query);
        System.out.println("parsed content:  \t" + parsed.getOPPLContent());
    }

    @Test
    public void testAggregateVaraibleValuesAndLooseObjects() {
        String query = "?x:CLASS, ?y:CLASS = createIntersection(?x.VALUES,Thing)  SELECT ?x subClassOf Thing BEGIN ADD ?x subClassOf Thing END;";
        OPPLSyntaxTree parsed = this.parse(query, syntax);
        System.out.println(parsed.toStringTree());
        assertNotNull(parsed);
        assertNotNull(parsed.getOPPLContent());
        System.out.println("original script: \t" + query);
        System.out.println("parsed content:  \t" + parsed.getOPPLContent());
    }

    @Test
    public void testGeneratedVariable() {
        OWLOntology ontology = ondrejtest;
        String query = "?x:CLASS, ?y:OBJECTPROPERTY = MATCH(\" has((\\w+)) \"), ?z:CLASS, ?feature:CLASS = create(?y.GROUPS(1)) SELECT ASSERTED ?x subClassOf ?y some ?z BEGIN REMOVE ?x subClassOf ?y some ?z, ADD ?x subClassOf !hasFeature some (?feature and !hasValue some ?z) END;";
        OPPLSyntaxTree parsed = this.parse(query, ontology);
        System.out.println(parsed.toStringTree());
        assertNotNull(parsed);
        assertNotNull(parsed.getOPPLContent());
        System.out.println("original script: \t" + query);
        System.out.println("parsed content:  \t" + parsed.getOPPLContent());
    }

    protected OPPLSyntaxTree parse(String input, OWLOntology ontology) {
        return this.parse(input, ontology, null);
    }

    protected OPPLSyntaxTree parse(String input, OWLOntology ontology,
            OWLReasoner reasoner) {
        OPPLFactory opplFactory = new OPPLFactory(ontology.getOWLOntologyManager(),
                ontology, reasoner);
        ConstraintSystem constraintSystem = opplFactory.createConstraintSystem();
        ANTLRStringStream antlrStringStream = new ANTLRStringStream(input);
        OPPLLexer lexer = new OPPLLexer(antlrStringStream);
        final TokenRewriteStream tokens = new TokenRewriteStream(lexer);
        OPPLScriptParser parser = new OPPLScriptParser(tokens, listener);
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
                nodes.reset();
                OPPLDefine define = new OPPLDefine(nodes, symtab, listener,
                        constraintSystem);
                define.setTreeAdaptor(adaptor);
                define.downup(tree);
                nodes.reset();
                ManchesterOWLSyntaxTypes mOWLTypes = new ManchesterOWLSyntaxTypes(nodes,
                        symtab, listener);
                mOWLTypes.downup(tree);
                nodes.reset();
                OPPLTypeEnforcement typeEnforcement = new OPPLTypeEnforcement(nodes,
                        symtab, new DefaultTypeEnforcer(symtab,
                                opplFactory.getOWLEntityFactory(), listener), listener);
                typeEnforcement.downup(tree);
                nodes.reset();
                mOWLTypes.downup(tree);
                nodes.reset();
                OPPLTypes opplTypes = new OPPLTypes(nodes, symtab, listener,
                        constraintSystem, opplFactory);
                opplTypes.downup(tree);
            }
            return (OPPLSyntaxTree) r.getTree();
        } catch (RecognitionException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Test
    public void testCreateIndividual() {
        symtab = getOPPLSymbolTable(managerForPizzaAndOndrej);
        OWLOntology ontology = ondrejtest;
        String query = "?x:CLASS, ?y:INDIVIDUAL = create(?x.RENDERING+\"Instance\") SELECT ASSERTED ?x subClassOf Pizza BEGIN REMOVE ?y types ?x END;";
        OPPLSyntaxTree parsed = this.parse(query, ontology);
        System.out.println(parsed.toStringTree());
        assertNotNull(parsed);
        assertNotNull(parsed.getOPPLContent());
        System.out.println("original script: \t" + query);
        System.out.println("parsed content:  \t" + parsed.getOPPLContent());
    }

    @Test
    public void testHasKey() {
        String query = "?x:CLASS SELECT ?x HasKey hasTopping Thing BEGIN ADD ?x subClassOf Thing END;";
        OPPLSyntaxTree parsed = this.parse(query, pizza);
        System.out.println(parsed.toStringTree());
        assertNotNull(parsed);
        assertNotNull(parsed.getOPPLContent());
        System.out.println("original script: \t" + query);
        System.out.println("parsed content:  \t" + parsed.getOPPLContent());
    }

    @Test
    public void testAnnotationAssertionsInQuery() {
        String query = "?x:CLASS SELECT <blah#Luigi> label \"aLabel\" BEGIN ADD ?x subClassOf Thing END;";
        OPPLSyntaxTree parsed = this.parse(query, pizza);
        System.out.println(parsed.toStringTree());
        assertNotNull(parsed);
        assertNotNull(parsed.getOPPLContent());
        System.out.println("original script: \t" + query);
        System.out.println("parsed content:  \t" + parsed.getOPPLContent());
    }

    @Test
    public void testAnnotationAssertionsInActions() {
        String query = "?x:CLASS SELECT ?x subClassOf Thing  BEGIN ADD <blah#Luigi> label \"aLabel\" END;";
        OPPLSyntaxTree parsed = this.parse(query, pizza);
        System.out.println(parsed.toStringTree());
        assertNotNull(parsed);
        assertNotNull(parsed.getOPPLContent());
        System.out.println("original script: \t" + query);
        System.out.println("parsed content:  \t" + parsed.getOPPLContent());
    }

    @Test
    public void testSubClassQueryNAryAxiom() {
        String query = "?x:CLASS SELECT DisjointClasses set(Thing, Nothing) BEGIN ADD ?x subClassOf Thing END;";
        OPPLSyntaxTree parsed = this.parse(query, pizza);
        System.out.println(parsed.toStringTree());
        assertNotNull(parsed);
        assertNotNull(parsed.getOPPLContent());
        System.out.println("original script: \t" + query);
        System.out.println("parsed content:  \t" + parsed.getOPPLContent());
    }

    @Test
    public void testSubClassQueryNAryAxiomVariableValues() {
        String query = "?x:CLASS SELECT DisjointClasses: set(?x.VALUES, Thing) BEGIN ADD ?x subClassOf Thing END;";
        OPPLSyntaxTree parsed = this.parse(query, pizza);
        System.out.println(parsed.toStringTree());
        assertNotNull(parsed);
        assertNotNull(parsed.getOPPLContent());
        System.out.println("original script: \t" + query);
        System.out.println("parsed content:  \t" + parsed.getOPPLContent());
    }

    @Test
    public void testVariableIRIAttribute() {
        String query = "?x:CLASS SELECT ?x.IRI label \"aLabel\" BEGIN ADD ?x subClassOf Thing END;";
        OPPLSyntaxTree parsed = this.parse(query, pizza);
        System.out.println(parsed.toStringTree());
        assertNotNull(parsed);
        assertNotNull(parsed.getOPPLContent());
        System.out.println("original script: \t" + query);
        System.out.println("parsed content:  \t" + parsed.getOPPLContent());
    }

    @Test
    public void testAsymmetricObjectProperty() {
        String query = "?x:OBJECTPROPERTY SELECT ?x subPropertyOf hasTopping BEGIN REMOVE Asymmetric ?x END;";
        OPPLSyntaxTree parsed = this.parse(query, pizza);
        System.out.println(parsed.toStringTree());
        assertNotNull(parsed);
        assertNotNull(parsed.getOPPLContent());
        System.out.println("original script: \t" + query);
        System.out.println("parsed content:  \t" + parsed.getOPPLContent());
    }

    @Test
    public void testVariableScope() {
        JFactFactory reasonerFactory = new JFactFactory();
        OWLReasoner reasoner = reasonerFactory.createReasoner(pizza);
        String query = "?M:CLASS[subClassOf NamedPizza], ?I:CLASS, ?S:CLASS SELECT ?M SubClassOf hasTopping some ?I, ?M SubClassOf hasBase some ?S WHERE ?M != Nothing BEGIN ADD ?M SubClassOf Thing END;";
        OPPLSyntaxTree parsed = this.parse(query, pizza, reasoner);
        System.out.println(parsed.toStringTree());
        assertNotNull(parsed);
        assertNotNull(parsed.getOPPLContent());
        System.out.println("original script: \t" + query);
        System.out.println("parsed content:  \t" + parsed.getOPPLContent());
        assertTrue(((InputVariable<?>) ((OPPLScript) parsed.getOPPLContent())
                .getVariables().get(0)).getVariableScope() != null);
    }

    @Test
    public void testVariableScopeInverseProperty() {
        JFactFactory reasonerFactory = new JFactFactory();
        OWLReasoner reasoner = reasonerFactory.createReasoner(pizza);
        String query = "?M:CLASS[subClassOf NamedPizza], ?I:CLASS[subClassOf INV(hasTopping) some Thing], ?S:CLASS SELECT ?M SubClassOf hasTopping some ?I, ?M SubClassOf hasBase some ?S WHERE ?M != Nothing BEGIN ADD ?M SubClassOf Thing END;";
        OPPLSyntaxTree parsed = this.parse(query, pizza, reasoner);
        System.out.println(parsed.toStringTree());
        assertNotNull(parsed);
        assertNotNull(parsed.getOPPLContent());
        System.out.println("original script: \t" + query);
        System.out.println("parsed content:  \t" + parsed.getOPPLContent());
        assertTrue(((InputVariable<?>) ((OPPLScript) parsed.getOPPLContent())
                .getVariables().get(0)).getVariableScope() != null);
    }

    @Test
    public void testNoQuery() {
        String query = "?x:CLASS BEGIN ADD ?x subClassOf Thing END;";
        OPPLSyntaxTree parsed = this.parse(query, pizza);
        System.out.println(parsed.toStringTree());
        assertNotNull(parsed);
        assertNotNull(parsed.getOPPLContent());
        System.out.println("original script: \t" + query);
        System.out.println("parsed content:  \t" + parsed.getOPPLContent());
    }

    @Test
    public void testNoVariablesQuery() {
        String query = "BEGIN ADD Nothing subClassOf Thing, REMOVE Thing subClassOf Nothing END;";
        OPPLSyntaxTree parsed = this.parse(query, pizza);
        System.out.println(parsed.toStringTree());
        assertNotNull(parsed);
        assertNotNull(parsed.getOPPLContent());
        System.out.println("original script: \t" + query);
        System.out.println("parsed content:  \t" + parsed.getOPPLContent());
    }

    @Test
    public void testVariableAnnotationObject() {
        String query = "?x:CLASS, ?y:CONSTANT SELECT ?x.IRI label ?y BEGIN ADD ?x subClassOf  Thing END;";
        OPPLSyntaxTree parsed = this.parse(query, pizza);
        System.out.println(parsed.toStringTree());
        assertNotNull(parsed);
        assertNotNull(parsed.getOPPLContent());
        System.out.println("original script: \t" + query);
        System.out.println("parsed content:  \t" + parsed.getOPPLContent());
    }

    @Test
    public void testNominalClassVariableValues() {
        String query = "?x:INDIVIDUAL,?sibling:CLASS = {?x }, ?siblingUnion:CLASS = createUnion(?sibling.VALUES) SELECT Robert hasSibling ?x BEGIN ADD Robert types  ?siblingUnion END;";
        symtab = getOPPLSymbolTable(siblings);
        OPPLSyntaxTree parsed = this.parse(query, siblings);
        System.out.println(parsed.toStringTree());
        assertNotNull(parsed);
        assertNotNull(parsed.getOPPLContent());
        System.out.println("original script: \t" + query);
        System.out.println("parsed content:  \t" + parsed.getOPPLContent());
    }

    @Test
    public void testLowerCase() {
        String query = "?x:CLASS=create(\"BLA\".toLowerCase) SELECT ?x subClassOf Thing BEGIN ADD ?x subClassOf Thing END;";
        OPPLSyntaxTree parsed = this.parse(query, pizza);
        assertNotNull(parsed);
        System.out.println("original script: \t" + query);
        System.out.println("parsed content:  \t" + parsed.getOPPLContent());
        System.out.println(parsed.toStringTree());
        assertNotNull(parsed.getOPPLContent());
    }

    @Test
    public void testUpperCase() {
        String query = "?x:CLASS=create(\"BLA\".toUpperCase) SELECT ?x subClassOf Thing BEGIN ADD ?x subClassOf Thing END;";
        OPPLSyntaxTree parsed = this.parse(query, pizza);
        assertNotNull(parsed);
        System.out.println("original script: \t" + query);
        System.out.println("parsed content:  \t" + parsed.getOPPLContent());
        assertNotNull(parsed.getOPPLContent());
    }

    @Test
    public void testLowerCaseInConcat() {
        String query = "?x:CLASS, ?y:CLASS=create(?x.RENDERING +\"_\"+\"BLA\".toLowerCase) SELECT ?x subClassOf Thing BEGIN ADD ?x subClassOf Thing END;";
        OPPLSyntaxTree parsed = this.parse(query, pizza);
        assertNotNull(parsed);
        System.out.println("original script: \t" + query);
        System.out.println("parsed content:  \t" + parsed.getOPPLContent());
        assertNotNull(parsed.getOPPLContent());
    }

    @Test
    public void testLowerCaseInConcatWithGroups() {
        symtab = getOPPLSymbolTable(pizza);
        String query = "?x:CLASS = MATCH(\"(.+)Topping\"), ?y:CLASS=create(\"Topping_\"+ ?x.GROUPS(1).toLowerCase) SELECT ?x subClassOf Thing BEGIN ADD ?x subClassOf Thing END;";
        OPPLSyntaxTree parsed = this.parse(query, pizza);
        assertNotNull(parsed);
        System.out.println("original script: \t" + query);
        System.out.println("parsed content:  \t" + parsed.getOPPLContent());
        assertNotNull(parsed.getOPPLContent());
    }

    @Test
    public void testLowerCaseParenthesys() {
        String query = "?x:CLASS=create((\"Bla\"+ \"Bla\").toLowerCase) SELECT ?x subClassOf Thing BEGIN ADD ?x subClassOf Thing END;";
        OPPLSyntaxTree parsed = this.parse(query, pizza);
        assertNotNull(parsed);
        System.out.println("original script: \t" + query);
        System.out.println("parsed content:  \t" + parsed.getOPPLContent());
        System.out.println(parsed.toStringTree());
        assertNotNull(parsed.getOPPLContent());
    }

    @Test
    public void testUpperCaseInConcatWithGroups() {
        String query = "?x:CLASS = MATCH(\"(.+)Topping\"), ?y:CLASS=create(\"Topping_\"+ ?x.GROUPS(1).toUpperCase) SELECT ?x subClassOf Thing BEGIN ADD ?x subClassOf Thing END;";
        OPPLSyntaxTree parsed = this.parse(query, pizza);
        assertNotNull(parsed);
        System.out.println("original script: \t" + query);
        System.out.println("parsed content:  \t" + parsed.getOPPLContent());
        assertNotNull(parsed.getOPPLContent());
    }

    @Test
    public void testUpperCaseInConcat() {
        String query = "?x:CLASS, ?y:CLASS=create(?x.RENDERING +\"_\"+\"BLA\".toUpperCase) SELECT ?x subClassOf Thing BEGIN ADD ?x subClassOf Thing END;";
        OPPLSyntaxTree parsed = this.parse(query, pizza);
        assertNotNull(parsed);
        System.out.println("original script: \t" + query);
        System.out.println("parsed content:  \t" + parsed.getOPPLContent());
        assertNotNull(parsed.getOPPLContent());
    }
}
