package org.coode.oppl;

import static org.coode.oppl.utils.ArgCheck.checkNotNull;

import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;
import org.coode.parsers.*;
import org.coode.parsers.common.SilentListener;
import org.coode.parsers.factory.SymbolTableFactory;
import org.coode.parsers.oppl.*;
import org.semanticweb.owlapi.model.OWLAxiom;
import org.semanticweb.owlapi.model.OWLLiteral;

/**
 * @author Luigi Iannone
 */
public class OPPLParser implements AbstractOPPLParser {

    /**
     * Abstract factory for creating parsers
     * 
     * @author Luigi Iannone
     */
    public interface AbstractParserFactory {

        /**
         * Builds an OPPLParser attaching an ErrorListener to it.
         * 
         * @param errorListener
         *        The ErrorListener. Cannot be {@code null}.
         * @return An OPPLParser.
         * @throws NullPointerException
         *         when the input is {@code null}.
         */
        OPPLParser build(ErrorListener errorListener);

        /**
         * Retrieves an instance OPPLAbstractFactory that this
         * AbstractParserFactory provides.
         * 
         * @return An OPPLAbstractFactory
         */
        OPPLAbstractFactory getOPPLFactory();
    }

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
    private final SymbolTableFactory<OPPLSymbolTable> symbolTableFactory;

    /**
     * @param factory
     *        factory
     * @param listener
     *        listener
     * @param symbolTableFactory
     *        symbolTableFactory
     */
    public OPPLParser(OPPLAbstractFactory factory, ErrorListener listener,
        SymbolTableFactory<OPPLSymbolTable> symbolTableFactory) {
        opplFactory = checkNotNull(factory, "factory");
        this.listener = checkNotNull(listener, "listener");
        this.symbolTableFactory = checkNotNull(symbolTableFactory, "symbolTableFactory");
    }

    private final ErrorListener listener;
    private final OPPLAbstractFactory opplFactory;

    @Override
    public OPPLScript parse(String input) {
        OPPLSymbolTable symtab = getSymbolTableFactory().createSymbolTable();
        symtab.setErrorListener(getListener());
        ANTLRStringStream antlrStringStream = new ANTLRStringStream(input);
        OPPLLexer lexer = new OPPLLexer(antlrStringStream);
        ConstraintSystem constraintSystem = getOPPLAbstractFactory()
            .createConstraintSystem();
        final TokenRewriteStream tokens = new TokenRewriteStream(lexer);
        OPPLScriptParser parser = new OPPLScriptParser(tokens, getListener());
        parser.setTreeAdaptor(ADAPTOR);
        try {
            RuleReturnScope r = parser.statement();
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
                    symtab, new DefaultTypeEnforcer(symtab, getOPPLAbstractFactory()
                        .getOWLEntityFactory(), getListener()), getListener());
                typeEnforcement.downup(tree);
                symtab.setErrorListener(typeEnforcement.getErrorListener());
                nodes.reset();
                // I will re-create the Manchester OWL types parser with the
                // actual error listener
                mOWLTypes = new ManchesterOWLSyntaxTypes(nodes, symtab, getListener());
                mOWLTypes.downup(tree);
                nodes.reset();
                OPPLTypes opplTypes = new OPPLTypes(nodes, symtab, getListener(),
                    constraintSystem, getOPPLAbstractFactory());
                opplTypes.downup(tree);
            }
            return tree != null ? (OPPLScript) ((OPPLSyntaxTree) tree).getOPPLContent()
                : null;
        } catch (RewriteEmptyStreamException e) {
            listener.rewriteEmptyStreamException(e);
            return null;
        } catch (Exception e) {
            listener.reportThrowable(e, 0, 0, 0);
            return null;
        }
    }

    /**
     * @return the symbolTableFactory
     */
    public SymbolTableFactory<OPPLSymbolTable> getSymbolTableFactory() {
        return symbolTableFactory;
    }

    /**
     * @return the listener
     */
    public ErrorListener getListener() {
        return listener;
    }

    /**
     * @return the factory
     */
    public OPPLAbstractFactory getOPPLAbstractFactory() {
        return opplFactory;
    }

    /**
     * @param input
     *        input
     * @param symbolTable
     *        symbolTable
     * @param constraintSystem
     *        constraintSystem
     * @return abstract constraint
     */
    public AbstractConstraint parseConstraint(String input, OPPLSymbolTable symbolTable,
        ConstraintSystem constraintSystem) {
        ANTLRStringStream antlrStringStream = new ANTLRStringStream(input);
        OPPLLexer lexer = new OPPLLexer(antlrStringStream);
        final TokenRewriteStream tokens = new TokenRewriteStream(lexer);
        OPPLScriptParser parser = new OPPLScriptParser(tokens);
        parser.setTreeAdaptor(ADAPTOR);
        symbolTable.setErrorListener(getListener());
        try {
            RuleReturnScope r = parser.constraint();
            CommonTree tree = (CommonTree) r.getTree();
            CommonTreeNodeStream nodes = new CommonTreeNodeStream(tree);
            nodes.setTokenStream(tokens); // where to find tokens
            nodes.setTreeAdaptor(ADAPTOR);
            nodes.reset();
            // RESOLVE SYMBOLS, COMPUTE EXPRESSION TYPES
            ManchesterOWLSyntaxSimplify simplify = new ManchesterOWLSyntaxSimplify(nodes);
            simplify.setTreeAdaptor(ADAPTOR);
            tree = (CommonTree) simplify.downup(tree);
            nodes.reset();
            OPPLDefine define = new OPPLDefine(nodes, symbolTable, getListener(),
                constraintSystem);
            define.setTreeAdaptor(ADAPTOR);
            define.downup(tree);
            nodes.reset();
            ManchesterOWLSyntaxTypes mOWLTypes = new ManchesterOWLSyntaxTypes(nodes,
                symbolTable, getListener());
            mOWLTypes.downup(tree);
            nodes.reset();
            OPPLTypesParts opplTypes = new OPPLTypesParts(nodes, symbolTable,
                getListener(), constraintSystem, getOPPLAbstractFactory());
            opplTypes.downup(tree);
            return (AbstractConstraint) ((OPPLSyntaxTree) tree).getOPPLContent();
        } catch (RecognitionException e) {
            listener.recognitionException(e);
            return null;
        } catch (RewriteEmptyStreamException e) {
            listener.rewriteEmptyStreamException(e);
            return null;
        } catch (Exception e) {
            listener.reportThrowable(e, 0, 0, 0);
            return null;
        }
    }

    /**
     * @param input
     *        input
     * @param variable
     *        variable
     * @param symbolTable
     *        symbolTable
     * @param constraintSystem
     *        constraintSystem
     * @return variable
     */
    public Variable<?> parseOPPLFunction(String input, Variable<?> variable,
        OPPLSymbolTable symbolTable, ConstraintSystem constraintSystem) {
        ANTLRStringStream antlrStringStream = new ANTLRStringStream(input);
        OPPLLexer lexer = new OPPLLexer(antlrStringStream);
        final TokenRewriteStream tokens = new TokenRewriteStream(lexer);
        OPPLScriptParser parser = new OPPLScriptParser(tokens);
        parser.setTreeAdaptor(ADAPTOR);
        symbolTable.setErrorListener(getListener());
        try {
            RuleReturnScope r = parser.opplFunction();
            CommonTree tree = (CommonTree) r.getTree();
            CommonTreeNodeStream nodes = new CommonTreeNodeStream(tree);
            nodes.setTokenStream(tokens); // where to find tokens
            nodes.setTreeAdaptor(ADAPTOR);
            nodes.reset();
            // RESOLVE SYMBOLS, COMPUTE EXPRESSION TYPES
            ManchesterOWLSyntaxTypes mOWLTypes = new ManchesterOWLSyntaxTypes(nodes,
                symbolTable, new SilentListener());
            symbolTable.setErrorListener(mOWLTypes.getErrorListener());
            mOWLTypes.downup(tree);
            nodes.reset();
            OPPLTypeEnforcement typeEnforcement = new OPPLTypeEnforcement(nodes,
                symbolTable,
                new DefaultTypeEnforcer(symbolTable, getOPPLAbstractFactory()
                    .getOWLEntityFactory(), getListener()), getListener());
            typeEnforcement.downup(tree);
            symbolTable.setErrorListener(typeEnforcement.getErrorListener());
            nodes.reset();
            // I will re-create the Manchester OWL types parser with the
            // actual error listener
            mOWLTypes = new ManchesterOWLSyntaxTypes(nodes, symbolTable, getListener());
            mOWLTypes.downup(tree);
            nodes.reset();
            mOWLTypes.downup(tree);
            nodes.reset();
            OPPLTypesParts opplTypes = new OPPLTypesParts(nodes, symbolTable,
                getListener(), constraintSystem, getOPPLAbstractFactory());
            opplTypes.setVariable(variable);
            opplTypes.downup(tree);
            return (Variable<?>) ((OPPLSyntaxTree) tree).getOPPLContent();
        } catch (RecognitionException e) {
            listener.recognitionException(e);
            return null;
        } catch (RewriteEmptyStreamException e) {
            listener.rewriteEmptyStreamException(e);
            return null;
        } catch (Exception e) {
            listener.reportThrowable(e, 0, 0, 0);
            return null;
        }
    }

    /**
     * @param input
     *        input
     * @param variable
     *        variable
     * @param symbolTable
     *        symbolTable
     * @param constraintSystem
     *        constraintSystem
     * @return variable
     */
    public Variable<?> parseRegExp(String input, Variable<?> variable,
        OPPLSymbolTable symbolTable, ConstraintSystem constraintSystem) {
        ANTLRStringStream antlrStringStream = new ANTLRStringStream(input);
        OPPLLexer lexer = new OPPLLexer(antlrStringStream);
        final TokenRewriteStream tokens = new TokenRewriteStream(lexer);
        OPPLScriptParser parser = new OPPLScriptParser(tokens);
        parser.setTreeAdaptor(ADAPTOR);
        symbolTable.setErrorListener(getListener());
        try {
            RuleReturnScope r = parser.regexp();
            CommonTree tree = (CommonTree) r.getTree();
            CommonTreeNodeStream nodes = new CommonTreeNodeStream(tree);
            nodes.setTokenStream(tokens); // where to find tokens
            nodes.setTreeAdaptor(ADAPTOR);
            nodes.reset();
            // RESOLVE SYMBOLS, COMPUTE EXPRESSION TYPES
            ManchesterOWLSyntaxSimplify simplify = new ManchesterOWLSyntaxSimplify(nodes);
            simplify.setTreeAdaptor(ADAPTOR);
            tree = (CommonTree) simplify.downup(tree);
            nodes.reset();
            OPPLDefine define = new OPPLDefine(nodes, symbolTable, getListener(),
                constraintSystem);
            define.setTreeAdaptor(ADAPTOR);
            define.downup(tree);
            nodes.reset();
            ManchesterOWLSyntaxTypes mOWLTypes = new ManchesterOWLSyntaxTypes(nodes,
                symbolTable, getListener());
            mOWLTypes.downup(tree);
            nodes.reset();
            mOWLTypes.downup(tree);
            nodes.reset();
            OPPLTypesParts opplTypes = new OPPLTypesParts(nodes, symbolTable,
                getListener(), constraintSystem, getOPPLAbstractFactory());
            opplTypes.setVariable(variable);
            opplTypes.downup(tree);
            return (Variable<?>) ((OPPLSyntaxTree) tree).getOPPLContent();
        } catch (RecognitionException e) {
            listener.recognitionException(e);
            return null;
        } catch (RewriteEmptyStreamException e) {
            listener.rewriteEmptyStreamException(e);
            return null;
        } catch (Exception e) {
            listener.reportThrowable(e, 0, 0, 0);
            return null;
        }
    }

    /**
     * @param input
     *        input
     * @param symbolTable
     *        symbolTable
     * @return axiom
     * @see org.coode.oppl.AbstractOPPLParser#parse(java.lang.String)
     */
    public OWLAxiom parseAxiom(String input, OPPLSymbolTable symbolTable) {
        ANTLRStringStream antlrStringStream = new ANTLRStringStream(input);
        OPPLLexer lexer = new OPPLLexer(antlrStringStream);
        final TokenRewriteStream tokens = new TokenRewriteStream(lexer);
        OPPLScriptParser parser = new OPPLScriptParser(tokens);
        parser.setTreeAdaptor(ADAPTOR);
        symbolTable.setErrorListener(getListener());
        try {
            RuleReturnScope r = parser.axiom();
            CommonTree tree = (CommonTree) r.getTree();
            CommonTreeNodeStream nodes = new CommonTreeNodeStream(tree);
            nodes.setTokenStream(tokens); // where to find tokens
            nodes.setTreeAdaptor(ADAPTOR);
            nodes.reset();
            // RESOLVE SYMBOLS, COMPUTE EXPRESSION TYPES
            ManchesterOWLSyntaxSimplify simplify = new ManchesterOWLSyntaxSimplify(nodes);
            simplify.setTreeAdaptor(ADAPTOR);
            tree = (CommonTree) simplify.downup(tree);
            ManchesterOWLSyntaxTypes mOWLTypes = new ManchesterOWLSyntaxTypes(nodes,
                symbolTable, new SilentListener());
            symbolTable.setErrorListener(mOWLTypes.getErrorListener());
            mOWLTypes.downup(tree);
            nodes.reset();
            OPPLTypeEnforcement typeEnforcement = new OPPLTypeEnforcement(nodes,
                symbolTable,
                new DefaultTypeEnforcer(symbolTable, getOPPLAbstractFactory()
                    .getOWLEntityFactory(), getListener()), getListener());
            typeEnforcement.downup(tree);
            symbolTable.setErrorListener(typeEnforcement.getErrorListener());
            nodes.reset();
            // I will re-create the Manchester OWL types parser with the
            // actual error listener
            mOWLTypes = new ManchesterOWLSyntaxTypes(nodes, symbolTable, getListener());
            mOWLTypes.downup(tree);
            nodes.reset();
            mOWLTypes.downup(tree);
            return (OWLAxiom) ((OPPLSyntaxTree) tree).getOWLObject();
        } catch (RecognitionException e) {
            listener.recognitionException(e);
            return null;
        } catch (RewriteEmptyStreamException e) {
            listener.rewriteEmptyStreamException(e);
            return null;
        } catch (Exception e) {
            listener.reportThrowable(e, 0, 0, 0);
            return null;
        }
    }

    /**
     * @param input
     *        input
     * @return literal
     */
    public OWLLiteral parsePlainConstant(String input) {
        OPPLSymbolTable symbolTable = getSymbolTableFactory().createSymbolTable();
        symbolTable.setErrorListener(getListener());
        ANTLRStringStream antlrStringStream = new ANTLRStringStream(input);
        MOWLLexer lexer = new MOWLLexer(antlrStringStream);
        final TokenRewriteStream tokens = new TokenRewriteStream(lexer);
        ManchesterOWLSyntaxParser parser = new ManchesterOWLSyntaxParser(tokens);
        parser.setTreeAdaptor(ADAPTOR);
        try {
            RuleReturnScope r = parser.constant();
            CommonTree tree = (CommonTree) r.getTree();
            CommonTreeNodeStream nodes = new CommonTreeNodeStream(tree);
            nodes.setTokenStream(tokens); // where to find tokens
            nodes.setTreeAdaptor(ADAPTOR);
            nodes.reset();
            // RESOLVE SYMBOLS, COMPUTE EXPRESSION TYPES
            ManchesterOWLSyntaxSimplify simplify = new ManchesterOWLSyntaxSimplify(nodes);
            simplify.setTreeAdaptor(ADAPTOR);
            tree = (CommonTree) simplify.downup(tree);
            nodes.reset();
            ManchesterOWLSyntaxTypesParts mOWLTypes = new ManchesterOWLSyntaxTypesParts(
                nodes, symbolTable, getListener());
            mOWLTypes.downup(tree);
            return (OWLLiteral) ((ManchesterOWLSyntaxTree) tree).getOWLObject();
        } catch (RecognitionException e) {
            listener.recognitionException(e);
            return null;
        } catch (RewriteEmptyStreamException e) {
            listener.rewriteEmptyStreamException(e);
            return null;
        } catch (Exception e) {
            listener.reportThrowable(e, 0, 0, 0);
            return null;
        }
    }
}
