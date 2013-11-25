package org.coode.parsers.oppl.testcase;

import static org.coode.oppl.utils.ArgCheck.checkNotNull;

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
import org.coode.oppl.exceptions.RuntimeExceptionHandler;
import org.coode.parsers.ErrorListener;
import org.coode.parsers.ManchesterOWLSyntaxSimplify;
import org.coode.parsers.ManchesterOWLSyntaxTypes;
import org.coode.parsers.common.SilentListener;
import org.coode.parsers.factory.SymbolTableFactory;
import org.coode.parsers.oppl.DefaultTypeEnforcer;
import org.coode.parsers.oppl.OPPLDefine;
import org.coode.parsers.oppl.OPPLSyntaxTree;
import org.coode.parsers.oppl.OPPLTypeEnforcement;
import org.coode.parsers.oppl.OPPLTypes;

/** @author Luigi Iannone */
public class OPPLTestCaseParser {
    /** Abstract factory for creating parsers
     * 
     * @author Luigi Iannone */
    public interface AbstractParserFactory {
        /** Builds an OPPLTestCaseParser attaching an ErrorListener to it.
         * 
         * @param errorListener
         *            The ErrorListener. Cannot be {@code null}.
         * @return An OPPLLintParser.
         * @throws NullPointerException
         *             when the input is {@code null}. */
        OPPLTestCaseParser build(ErrorListener errorListener);

        /** Retrieves an instance AbstractOPPLTestCaseFactory that this
         * AbstractParserFactory provides.
         * 
         * @return An AbstractOPPLTestCaseFactory */
        AbstractOPPLTestCaseFactory getOPPLTestCaseFactory();
    }

    private final ErrorListener listener;
    private final AbstractOPPLTestCaseFactory opplTestCaseFactory;
    private final SymbolTableFactory<OPPLTestCaseSymbolTable> symbolTableFactory;
    private static final TreeAdaptor ADAPTOR = new CommonTreeAdaptor() {
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

    /** @param factory
     * @param listener
     * @param symbolTableFactory */
    public OPPLTestCaseParser(AbstractOPPLTestCaseFactory factory,
            ErrorListener listener,
            SymbolTableFactory<OPPLTestCaseSymbolTable> symbolTableFactory) {
        opplTestCaseFactory = checkNotNull(factory, "factory");
        this.listener = checkNotNull(listener, "listener");
        this.symbolTableFactory = checkNotNull(symbolTableFactory, "symbolTableFactory");
    }

    /** @return the symbolTableFactory */
    public SymbolTableFactory<OPPLTestCaseSymbolTable> getSymbolTableFactory() {
        return symbolTableFactory;
    }

    /** @return the opplLintFactory */
    public AbstractOPPLTestCaseFactory getOPPLTestCaseFactory() {
        return opplTestCaseFactory;
    }

    /** @return the listener */
    public ErrorListener getListener() {
        return listener;
    }

    /** @param input
     * @param handler
     * @return oppl test case */
    public OPPLTestCase parse(String input, RuntimeExceptionHandler handler) {
        OPPLTestCaseSymbolTable symtab = getSymbolTableFactory().createSymbolTable();
        symtab.setErrorListener(getListener());
        ANTLRStringStream antlrStringStream = new ANTLRStringStream(input);
        OPPLTestCaseLexer lexer = new OPPLTestCaseLexer(antlrStringStream);
        ConstraintSystem constraintSystem = getOPPLTestCaseFactory().getOPPLFactory()
                .createConstraintSystem();
        final TokenRewriteStream tokens = new TokenRewriteStream(lexer);
        OPPLTestCaseCombinedParser parser = new OPPLTestCaseCombinedParser(tokens,
                getListener());
        parser.setTreeAdaptor(ADAPTOR);
        try {
            RuleReturnScope r = parser.testCase();
            CommonTree tree = (CommonTree) r.getTree();
            if (tree != null) {
                CommonTreeNodeStream nodes = new CommonTreeNodeStream(tree);
                nodes.setTokenStream(tokens); // where to find tokens
                nodes.setTreeAdaptor(ADAPTOR);
                nodes.reset();
                // RESOLVE SYMBOLS, COMPUTE EXPRESSION TYPES
                ManchesterOWLSyntaxSimplify simplify = new ManchesterOWLSyntaxSimplify(
                        nodes);
                simplify.setTreeAdaptor(ADAPTOR);
                tree = (CommonTree) simplify.downup(tree);
                nodes.reset();
                OPPLDefine define = new OPPLDefine(nodes, symtab, getListener(),
                        constraintSystem);
                define.setTreeAdaptor(ADAPTOR);
                define.downup(tree);
                nodes.reset();
                ManchesterOWLSyntaxTypes mOWLTypes = new ManchesterOWLSyntaxTypes(nodes,
                        symtab, new SilentListener());
                symtab.setErrorListener(mOWLTypes.getErrorListener());
                mOWLTypes.downup(tree);
                nodes.reset();
                OPPLTypeEnforcement typeEnforcement = new OPPLTypeEnforcement(nodes,
                        symtab, new DefaultTypeEnforcer(symtab, getOPPLTestCaseFactory()
                                .getOPPLFactory().getOWLEntityFactory(), getListener()),
                        getListener());
                typeEnforcement.downup(tree);
                symtab.setErrorListener(typeEnforcement.getErrorListener());
                nodes.reset();
                // I will re-create the Manchester OWL types parser with the
                // actual error listener
                mOWLTypes = new ManchesterOWLSyntaxTypes(nodes, symtab, getListener());
                mOWLTypes.downup(tree);
                nodes.reset();
                OPPLTypes opplTypes = new OPPLTypes(nodes, symtab, getListener(),
                        constraintSystem, getOPPLTestCaseFactory().getOPPLFactory());
                opplTypes.downup(tree);
                nodes.reset();
                OPPLTestCaseTypes opplTestCaseTypes = new OPPLTestCaseTypes(nodes,
                        symtab, listener, constraintSystem, opplTestCaseFactory, handler);
                opplTestCaseTypes.downup(tree);
            }
            return tree != null ? (OPPLTestCase) ((OPPLSyntaxTree) tree).getOPPLContent()
                    : null;
        } catch (org.antlr.runtime.tree.RewriteEarlyExitException e) {
            listener.reportThrowable(new RuntimeException("Probably empty set of tests",
                    e), 0, 0, 0);
            return null;
        }
    }
}
