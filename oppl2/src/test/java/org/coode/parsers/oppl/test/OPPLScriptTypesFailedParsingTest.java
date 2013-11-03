package org.coode.parsers.oppl.test;

import static org.junit.Assert.*;

import java.net.URISyntaxException;

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
import org.coode.parsers.ErrorListener;
import org.coode.parsers.ManchesterOWLSyntaxSimplify;
import org.coode.parsers.ManchesterOWLSyntaxTypes;
import org.coode.parsers.common.SystemErrorEcho;
import org.coode.parsers.factory.SymbolTableFactory;
import org.coode.parsers.oppl.DefaultTypeEnforcer;
import org.coode.parsers.oppl.OPPLDefine;
import org.coode.parsers.oppl.OPPLLexer;
import org.coode.parsers.oppl.OPPLScriptParser;
import org.coode.parsers.oppl.OPPLSymbolTable;
import org.coode.parsers.oppl.OPPLSyntaxTree;
import org.coode.parsers.oppl.OPPLTypeEnforcement;
import org.coode.parsers.oppl.OPPLTypes;
import org.coode.parsers.oppl.factory.SimpleSymbolTableFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;
import org.semanticweb.owlapi.model.OWLOntologyManager;

/** Test for the AST generation for OPPL
 * 
 * @author Luigi Iannone */
public class OPPLScriptTypesFailedParsingTest {
    private TreeAdaptor adaptor = new CommonTreeAdaptor() {
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
    private OWLOntologyManager ONTOLOGY_MANAGER = OWLManager.createOWLOntologyManager();
    protected OWLOntology PIZZA_ONTOLOGY;
    protected OWLOntology SYNTAX_ONTOLOGY;
    protected OWLOntology TEST_ONTOLOGY;
    private final SymbolTableFactory<OPPLSymbolTable> SYMBOL_TABLE_FACTORY = new SimpleSymbolTableFactory(
            ONTOLOGY_MANAGER);
    private OPPLSymbolTable symtab;

    @Before
    public void setUp() throws OWLOntologyCreationException, URISyntaxException {
        PIZZA_ONTOLOGY = ONTOLOGY_MANAGER.loadOntologyFromOntologyDocument(this
                .getClass().getResourceAsStream("/pizza.owl"));
        SYNTAX_ONTOLOGY = ONTOLOGY_MANAGER.loadOntologyFromOntologyDocument(this
                .getClass().getResourceAsStream("/syntaxTest.owl"));
        TEST_ONTOLOGY = ONTOLOGY_MANAGER.loadOntologyFromOntologyDocument(this.getClass()
                .getResourceAsStream("/test.owl"));
        symtab = SYMBOL_TABLE_FACTORY.createSymbolTable();
        symtab.setErrorListener(listener);
    }

    @Test
    public void testVariableScope() {
        String query = "?x:CLASS[subClassOf Pizza] SELECT ?x subClassOf Thing BEGIN ADD ?x subClassOf Thing END;";
        OPPLSyntaxTree parsed = parse(query, PIZZA_ONTOLOGY);
        System.out.println(parsed.toStringTree());
        assertNotNull(parsed);
        assertNull(parsed.getOPPLContent());
        System.out.println("original script: \t" + query);
        System.out.println("parsed content:  \t" + parsed.getOPPLContent());
    }

    @Test
    public void testAggregateVaraibleValuesAndLooseObjects() {
        String query = "?x:CLASS,?z:OBJECTPROPERTY, ?y:CLASS = createIntersection(?x.VALUES,?z)  SELECT ?x subClassOf Thing BEGIN ADD ?x subClassOf Thing END;";
        OPPLSyntaxTree parsed = parse(query, SYNTAX_ONTOLOGY);
        System.out.println(parsed.toStringTree());
        assertNotNull(parsed);
        assertNull(parsed.getOPPLContent());
        System.out.println("original script: \t" + query);
        System.out.println("parsed content:  \t" + parsed.getOPPLContent());
    }

    @After
    public void tearDown() throws Exception {
        symtab.dispose();
    }

    protected OPPLSyntaxTree parse(String input, OWLOntology ontology) {
        OPPLFactory opplFactory = new OPPLFactory(ONTOLOGY_MANAGER, ontology, null);
        ConstraintSystem constraintSystem = opplFactory.createConstraintSystem();
        ANTLRStringStream antlrStringStream = new ANTLRStringStream(input);
        OPPLLexer lexer = new OPPLLexer(antlrStringStream);
        final TokenRewriteStream tokens = new TokenRewriteStream(lexer);
        OPPLScriptParser parser = new OPPLScriptParser(tokens, listener);
        parser.setTreeAdaptor(adaptor);
        try {
            RuleReturnScope r = parser.statement();
            CommonTree tree = (CommonTree) r.getTree();
            CommonTreeNodeStream nodes = new CommonTreeNodeStream(tree);
            nodes.setTokenStream(tokens); // where to find tokens
            nodes.setTreeAdaptor(adaptor);
            nodes.reset();
            // RESOLVE SYMBOLS, COMPUTE EXPRESSION TYPES
            ManchesterOWLSyntaxSimplify simplify = new ManchesterOWLSyntaxSimplify(nodes);
            simplify.setTreeAdaptor(adaptor);
            simplify.downup(tree);
            nodes.reset();
            OPPLDefine define = new OPPLDefine(nodes, symtab, listener, constraintSystem);
            define.setTreeAdaptor(adaptor);
            define.downup(tree);
            nodes.reset();
            ManchesterOWLSyntaxTypes mOWLTypes = new ManchesterOWLSyntaxTypes(nodes,
                    symtab, listener);
            mOWLTypes.downup(tree);
            nodes.reset();
            OPPLTypeEnforcement typeEnforcement = new OPPLTypeEnforcement(nodes, symtab,
                    new DefaultTypeEnforcer(symtab, opplFactory.getOWLEntityFactory(),
                            listener), listener);
            typeEnforcement.downup(tree);
            nodes.reset();
            mOWLTypes.downup(tree);
            nodes.reset();
            OPPLTypes opplTypes = new OPPLTypes(nodes, symtab, listener,
                    constraintSystem, opplFactory);
            opplTypes.downup(tree);
            return (OPPLSyntaxTree) r.getTree();
        } catch (RecognitionException e) {
            e.printStackTrace();
            return null;
        }
    }
}
