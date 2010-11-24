/**
 * 
 */
package org.coode.patterns;

import java.util.Collection;

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
import org.coode.parsers.oppl.patterns.OPPLPatternLexer;
import org.coode.parsers.oppl.patterns.OPPLPatternScriptParser;
import org.coode.parsers.oppl.patterns.OPPLPatternsDefine;
import org.coode.parsers.oppl.patterns.OPPLPatternsReferenceDefine;
import org.coode.parsers.oppl.patterns.OPPLPatternsSymbolTable;
import org.coode.parsers.oppl.patterns.OPPLPatternsTypes;

/**
 * @author Luigi Iannone
 * 
 */
public class OPPLPatternParser implements AbstractOPPLParser {
	/**
	 * Abstract factory for creating parsers
	 * 
	 * @author Luigi Iannone
	 * 
	 */
	public interface AbstractParserFactory {
		/**
		 * Builds an OPPLPatternParser attaching an ErrorListener to it.
		 * 
		 * @param errorListener
		 *            The ErrorListener. Cannot be {@code null}.
		 * @return An OPPLParser.
		 * @throws NullPointerException
		 *             when the input is {@code null}.
		 */
		public OPPLPatternParser build(ErrorListener errorListener);

		/**
		 * Builds an OPPLPatternParser attaching an ErrorListener to it. This
		 * parser takes into account the already visited patterns in order to
		 * detect cyclic references.
		 * 
		 * @param errorListener
		 *            The ErrorListener. Cannot be {@code null}.
		 * @param visitedPatterns
		 *            The Collection of visited patterns. Cannot be {@code null}
		 *            .
		 * 
		 * @return An OPPLParser.
		 * @throws NullPointerException
		 *             when either input is {@code null}.
		 */
		public OPPLPatternParser build(Collection<? extends String> visitedPatterns,
				ErrorListener errorListener);

		/**
		 * Retrieves an instance AbstractPatternModelFactory that this
		 * AbstractParserFactory provides.
		 * 
		 * @return An OPPLAbstractFactory
		 */
		public AbstractPatternModelFactory getPatternFactory();
	}

	public interface PatternReferenceResolver {
		public void resolvePattern(OPPLSyntaxTree reference, String patternName,
				PatternConstraintSystem constraintSystem, OPPLPatternsSymbolTable symbolTable,
				Object... args);
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
		public Object errorNode(TokenStream input, Token start, Token stop, RecognitionException e) {
			return new CommonErrorNode(input, start, stop, e);
		}
	};
	private final SymbolTableFactory<OPPLPatternsSymbolTable> symbolTableFactory;

	public OPPLPatternParser(AbstractPatternModelFactory factory, ErrorListener listener,
			SymbolTableFactory<OPPLPatternsSymbolTable> symbolTableFactory) {
		this(factory, listener, symbolTableFactory, getSimplePatternReferenceResolver());
	}

	/**
	 * @return
	 */
	public static PatternReferenceResolver getSimplePatternReferenceResolver() {
		return new PatternReferenceResolver() {
			public void resolvePattern(OPPLSyntaxTree reference, String patternName,
					PatternConstraintSystem constraintSystem, OPPLPatternsSymbolTable symbolTable,
					Object... args) {
				symbolTable.resolvePattern(reference, patternName, constraintSystem, args);
			}
		};
	}

	/**
	 * @param factory
	 * @param listener
	 * @param symbolTableFactory
	 */
	public OPPLPatternParser(AbstractPatternModelFactory factory, ErrorListener listener,
			SymbolTableFactory<OPPLPatternsSymbolTable> symbolTableFactory,
			PatternReferenceResolver patternReferenceResolver) {
		if (factory == null) {
			throw new NullPointerException("The OPPL factory cannot be null");
		}
		if (listener == null) {
			throw new NullPointerException("The error listener cannot be null");
		}
		if (symbolTableFactory == null) {
			throw new NullPointerException("The symbol table factory cannot be null");
		}
		if (patternReferenceResolver == null) {
			throw new NullPointerException("The pattern reference resolver cannot be null");
		}
		this.patternModelFactory = factory;
		this.listener = listener;
		this.symbolTableFactory = symbolTableFactory;
		this.patternReferenceResolver = patternReferenceResolver;
	}

	private final ErrorListener listener;
	private final AbstractPatternModelFactory patternModelFactory;
	private final PatternReferenceResolver patternReferenceResolver;

	/**
	 * @see org.coode.oppl.AbstractOPPLParser#parse(java.lang.String)
	 */
	public PatternModel parse(String input) {
		OPPLPatternsSymbolTable symtab = this.getSymbolTableFactory().createSymbolTable();
		symtab.setErrorListener(this.getListener());
		ANTLRStringStream antlrStringStream = new ANTLRStringStream(input);
		OPPLPatternLexer lexer = new OPPLPatternLexer(antlrStringStream);
		PatternConstraintSystem constraintSystem = this.getOPPLPatternFactory().createConstraintSystem();
		final TokenRewriteStream tokens = new TokenRewriteStream(lexer);
		OPPLPatternScriptParser parser = new OPPLPatternScriptParser(tokens, this.getListener());
		parser.setTreeAdaptor(ADAPTOR);
		try {
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
				simplify.downup(tree);
				nodes.reset();
				OPPLDefine define = new OPPLDefine(nodes, symtab, this.getListener(),
						constraintSystem);
				define.setTreeAdaptor(ADAPTOR);
				define.downup(tree);
				nodes.reset();
				OPPLPatternsDefine patternsDefine = new OPPLPatternsDefine(nodes, symtab,
						this.getListener(), this.getPatternReferenceResolver(), constraintSystem);
				patternsDefine.setTreeAdaptor(ADAPTOR);
				patternsDefine.downup(tree);
				nodes.reset();
				SilentListener silentListener = new SilentListener();
				symtab.setErrorListener(silentListener);
				ManchesterOWLSyntaxTypes mOWLTypes = new ManchesterOWLSyntaxTypes(nodes, symtab,
						silentListener);
				mOWLTypes.downup(tree);
				nodes.reset();
				OPPLTypeEnforcement typeEnforcement = new OPPLTypeEnforcement(
						nodes,
						symtab,
						new DefaultTypeEnforcer(
								symtab,
								this.getOPPLPatternFactory().getOPPLFactory().getOWLEntityFactory(),
								this.getListener()), this.getListener());
				typeEnforcement.downup(tree);
				nodes.reset();
				mOWLTypes.downup(tree);
				nodes.reset();
				OPPLTypes opplTypes = new OPPLTypes(nodes, symtab, silentListener,
						constraintSystem, this.getOPPLPatternFactory().getOPPLFactory());
				opplTypes.downup(tree);
				nodes.reset();
				OPPLPatternsReferenceDefine patternReferenceDefine = new OPPLPatternsReferenceDefine(
						nodes, symtab, this.getListener(), this.getPatternReferenceResolver(),
						constraintSystem);
				patternReferenceDefine.setTreeAdaptor(ADAPTOR);
				patternReferenceDefine.downup(tree);
				nodes.reset();
				symtab.setErrorListener(this.getListener());
				mOWLTypes = new ManchesterOWLSyntaxTypes(nodes, symtab, this.getListener());
				mOWLTypes.downup(tree);
				nodes.reset();
				opplTypes = new OPPLTypes(nodes, symtab, this.getListener(), constraintSystem,
						this.getOPPLPatternFactory().getOPPLFactory());
				opplTypes.downup(tree);
				nodes.reset();
				OPPLPatternsTypes opplPatternsTypes = new OPPLPatternsTypes(nodes, symtab,
						this.getListener(), constraintSystem, this.getOPPLPatternFactory());
				opplPatternsTypes.downup(tree);
			}
			return tree != null ? (PatternModel) ((OPPLSyntaxTree) tree).getOPPLContent() : null;
		} catch (RecognitionException e) {
			this.listener.recognitionException(e);
			return null;
		}
	}

	/**
	 * @return the symbolTableFactory
	 */
	public SymbolTableFactory<OPPLPatternsSymbolTable> getSymbolTableFactory() {
		return this.symbolTableFactory;
	}

	/**
	 * @return the listener
	 */
	public ErrorListener getListener() {
		return this.listener;
	}

	/**
	 * @return the factory
	 */
	public AbstractPatternModelFactory getOPPLPatternFactory() {
		return this.patternModelFactory;
	}

	/**
	 * @return the patternReferenceResolver
	 */
	public PatternReferenceResolver getPatternReferenceResolver() {
		return this.patternReferenceResolver;
	}
}
