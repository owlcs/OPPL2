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
    private final ErrorListener listener = new SilentListener();

    @Test
    public void testVariableScope() {
        String query = "?x:CLASS[subClassOf Pizza] SELECT ?x subClassOf Thing BEGIN ADD ?x subClassOf Thing END;";
        OPPLSyntaxTree parsed = parse(query, pizza);
        assertNotNull(parsed);
        assertNull(parsed.getOPPLContent());
    }

    @Test
    public void testAggregateVaraibleValuesAndLooseObjects() {
        String query = "?x:CLASS,?z:OBJECTPROPERTY, ?y:CLASS = createIntersection(?x.VALUES,?z)  SELECT ?x subClassOf Thing BEGIN ADD ?x subClassOf Thing END;";
        OPPLSyntaxTree parsed = parse(query, syntax);
        assertNotNull(parsed);
        assertNull(parsed.getOPPLContent());
    }

    protected OPPLSyntaxTree parse(String input, OWLOntology ontology) {
        OPPLFactory opplFactory = new OPPLFactory(ontology.getOWLOntologyManager(),
                ontology, null);
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
            OPPLSymbolTable symtab = getOPPLSymbolTable(ontology);
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
            throw new RuntimeException(e);
        }
    }
}
