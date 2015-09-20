package org.coode.patterns;

import static org.coode.oppl.utils.ArgCheck.checkNotNull;

import java.util.Collection;
import java.util.List;

import org.antlr.runtime.*;
import org.antlr.runtime.tree.CommonErrorNode;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.CommonTreeAdaptor;
import org.antlr.runtime.tree.CommonTreeNodeStream;
import org.antlr.runtime.tree.TreeAdaptor;
import org.coode.oppl.AbstractOPPLParser;
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
import org.coode.parsers.oppl.patterns.*;

/**
 * @author Luigi Iannone
 */
public class OPPLPatternParser implements AbstractOPPLParser {

    /**
     * Abstract factory for creating parsers
     * 
     * @author Luigi Iannone
     */
    public interface AbstractParserFactory {

        /**
         * Builds an OPPLPatternParser attaching an ErrorListener to it.
         * 
         * @param errorListener
         *        The ErrorListener. Cannot be {@code null}.
         * @return An OPPLParser.
         * @throws NullPointerException
         *         when the input is {@code null}.
         */
        OPPLPatternParser build(ErrorListener errorListener);

        /**
         * Builds an OPPLPatternParser attaching an ErrorListener to it. This
         * parser takes into account the already visited patterns in order to
         * detect cyclic references.
         * 
         * @param errorListener
         *        The ErrorListener. Cannot be {@code null}.
         * @param visitedPatterns
         *        The Collection of visited patterns. Cannot be {@code null} .
         * @return An OPPLParser.
         * @throws NullPointerException
         *         when either input is {@code null}.
         */
        OPPLPatternParser build(Collection<? extends String> visitedPatterns,
            ErrorListener errorListener);

        /**
         * Retrieves an instance AbstractPatternModelFactory that this
         * AbstractParserFactory provides.
         * 
         * @return An OPPLAbstractFactory
         */
        AbstractPatternModelFactory getPatternFactory();
    }

    /** pattern reference resolver */
    public interface PatternReferenceResolver {

        /**
         * @param reference
         *        reference
         * @param patternName
         *        patternName
         * @param constraintSystem
         *        constraintSystem
         * @param symbolTable
         *        symbolTable
         * @param args
         *        args
         */
        void resolvePattern(OPPLSyntaxTree reference, String patternName,
            PatternConstraintSystem constraintSystem,
            OPPLPatternsSymbolTable symbolTable, List<Object>... args);
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
    private final SymbolTableFactory<OPPLPatternsSymbolTable> symbolTableFactory;

    /**
     * @param factory
     *        factory
     * @param listener
     *        listener
     * @param symbolTableFactory
     *        symbolTableFactory
     */
    public OPPLPatternParser(AbstractPatternModelFactory factory, ErrorListener listener,
        SymbolTableFactory<OPPLPatternsSymbolTable> symbolTableFactory) {
        this(factory, listener, symbolTableFactory, getSimplePatternReferenceResolver());
    }

    /**
     * @return a pattern reference resolver
     */
    public static PatternReferenceResolver getSimplePatternReferenceResolver() {
        return new PatternReferenceResolver() {

            @Override
            public void resolvePattern(OPPLSyntaxTree reference, String patternName,
                PatternConstraintSystem constraintSystem,
                OPPLPatternsSymbolTable symbolTable, List<Object>... args) {
                symbolTable
                    .resolvePattern(reference, patternName, constraintSystem, args);
            }
        };
    }

    /**
     * @param factory
     *        factory
     * @param listener
     *        listener
     * @param symbolTableFactory
     *        symbolTableFactory
     * @param patternReferenceResolver
     *        patternReferenceResolver
     */
    public OPPLPatternParser(AbstractPatternModelFactory factory, ErrorListener listener,
        SymbolTableFactory<OPPLPatternsSymbolTable> symbolTableFactory,
        PatternReferenceResolver patternReferenceResolver) {
        patternModelFactory = checkNotNull(factory, "factory");
        this.listener = checkNotNull(listener, "listener");
        this.symbolTableFactory = checkNotNull(symbolTableFactory, "symbolTableFactory");
        this.patternReferenceResolver = checkNotNull(patternReferenceResolver,
            "patternReferenceResolver");
    }

    private final ErrorListener listener;
    private final AbstractPatternModelFactory patternModelFactory;
    private final PatternReferenceResolver patternReferenceResolver;

    @Override
    public PatternModel parse(String input) {
        OPPLPatternsSymbolTable symtab = getSymbolTableFactory().createSymbolTable();
        symtab.setErrorListener(getListener());
        ANTLRStringStream antlrStringStream = new ANTLRStringStream(input);
        OPPLPatternLexer lexer = new OPPLPatternLexer(antlrStringStream);
        PatternConstraintSystem constraintSystem = getOPPLPatternFactory()
            .createConstraintSystem();
        final TokenRewriteStream tokens = new TokenRewriteStream(lexer);
        OPPLPatternScriptParser parser = new OPPLPatternScriptParser(tokens,
            getListener());
        parser.setTreeAdaptor(ADAPTOR);
        RuleReturnScope r = parser.pattern();
        CommonTree tree = (CommonTree) r.getTree();
        if (tree != null) {
            CommonTreeNodeStream nodes = new CommonTreeNodeStream(tree);
            nodes.setTokenStream(tokens); // where to find tokens
            nodes.setTreeAdaptor(ADAPTOR);
            nodes.reset();
            // RESOLVE SYMBOLS, COMPUTE EXPRESSION TYPES
            ManchesterOWLSyntaxSimplify simplify = new ManchesterOWLSyntaxSimplify(nodes);
            simplify.setTreeAdaptor(ADAPTOR);
            tree = (CommonTree) simplify.downup(tree);
            nodes.reset();
            OPPLDefine define = new OPPLDefine(nodes, symtab, getListener(),
                constraintSystem);
            define.setTreeAdaptor(ADAPTOR);
            define.downup(tree);
            nodes.reset();
            OPPLPatternsDefine patternsDefine = new OPPLPatternsDefine(nodes, symtab,
                getListener(), getPatternReferenceResolver(), constraintSystem);
            patternsDefine.setTreeAdaptor(ADAPTOR);
            patternsDefine.downup(tree);
            nodes.reset();
            SilentListener silentListener = new SilentListener();
            symtab.setErrorListener(silentListener);
            ManchesterOWLSyntaxTypes mOWLTypes = new ManchesterOWLSyntaxTypes(nodes,
                symtab, silentListener);
            mOWLTypes.downup(tree);
            nodes.reset();
            OPPLTypeEnforcement typeEnforcement = new OPPLTypeEnforcement(nodes, symtab,
                new DefaultTypeEnforcer(symtab, getOPPLPatternFactory()
                    .getOPPLFactory().getOWLEntityFactory(), getListener()),
                getListener());
            typeEnforcement.downup(tree);
            nodes.reset();
            mOWLTypes.downup(tree);
            nodes.reset();
            OPPLTypes opplTypes = new OPPLTypes(nodes, symtab, silentListener,
                constraintSystem, getOPPLPatternFactory().getOPPLFactory());
            opplTypes.downup(tree);
            nodes.reset();
            OPPLPatternsReferenceDefine patternReferenceDefine = new OPPLPatternsReferenceDefine(
                nodes, symtab, getListener(), getPatternReferenceResolver(),
                constraintSystem);
            patternReferenceDefine.setTreeAdaptor(ADAPTOR);
            patternReferenceDefine.downup(tree);
            nodes.reset();
            symtab.setErrorListener(getListener());
            mOWLTypes = new ManchesterOWLSyntaxTypes(nodes, symtab, getListener());
            mOWLTypes.downup(tree);
            nodes.reset();
            opplTypes = new OPPLTypes(nodes, symtab, getListener(), constraintSystem,
                getOPPLPatternFactory().getOPPLFactory());
            opplTypes.downup(tree);
            nodes.reset();
            OPPLPatternsTypes opplPatternsTypes = new OPPLPatternsTypes(nodes, symtab,
                getListener(), constraintSystem, getOPPLPatternFactory());
            opplPatternsTypes.downup(tree);
        }
        return tree != null ? (PatternModel) ((OPPLSyntaxTree) tree).getOPPLContent()
            : null;
    }

    /**
     * @return the symbolTableFactory
     */
    public SymbolTableFactory<OPPLPatternsSymbolTable> getSymbolTableFactory() {
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
    public AbstractPatternModelFactory getOPPLPatternFactory() {
        return patternModelFactory;
    }

    /**
     * @return the patternReferenceResolver
     */
    public PatternReferenceResolver getPatternReferenceResolver() {
        return patternReferenceResolver;
    }
}
