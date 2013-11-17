/**
 * 
 */
package org.coode.oppl.lint;

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
import org.coode.parsers.oppl.OPPLSymbolTable;
import org.coode.parsers.oppl.OPPLSyntaxTree;
import org.coode.parsers.oppl.OPPLTypeEnforcement;
import org.coode.parsers.oppl.OPPLTypes;
import org.coode.parsers.oppl.lint.OPPLLintCombinedParser;
import org.coode.parsers.oppl.lint.OPPLLintLexer;
import org.coode.parsers.oppl.lint.OPPLLintTypes;

/**
 * @author Luigi Iannone
 * 
 */
public class OPPLLintParser implements AbstractOPPLLintParser {
	/**
	 * Abstract factory for creating parsers
	 * 
	 * @author Luigi Iannone
	 * 
	 */
	public interface AbstractParserFactory {
		/**
		 * Builds an OPPLLintParser attaching an ErrorListener to it.
		 * 
		 * @param errorListener
		 *            The ErrorListener. Cannot be {@code null}.
		 * @return An OPPLLintParser.
		 * @throws NullPointerException
		 *             when the input is {@code null}.
		 */
		public OPPLLintParser build(ErrorListener errorListener);

		/**
		 * Retrieves an instance OPPLLintAbstractFactory that this
		 * AbstractParserFactory provides.
		 * 
		 * @return An OPPLLintAbstractFactory
		 */
		public OPPLLintAbstractFactory getOPPLLintAbstractFactory();
	}

	private final ErrorListener listener;
	private final OPPLLintAbstractFactory opplLintFactory;
	private final SymbolTableFactory<OPPLSymbolTable> symbolTableFactory;
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

	public OPPLLintParser(OPPLLintAbstractFactory factory, ErrorListener listener,
			SymbolTableFactory<OPPLSymbolTable> symbolTableFactory) {
		if (factory == null) {
			throw new NullPointerException("The OPPL factory cannot be null");
		}
		if (listener == null) {
			throw new NullPointerException("The error listener cannot be null");
		}
		if (symbolTableFactory == null) {
			throw new NullPointerException("The symbol table factory cannot be null");
		}
		this.opplLintFactory = factory;
		this.listener = listener;
		this.symbolTableFactory = symbolTableFactory;
	}

	public OPPLLintScript parse(String input, RuntimeExceptionHandler handler) {
		if (input == null) {
			throw new NullPointerException("The input string cannot be null");
		}
		if (handler == null) {
			throw new NullPointerException("The run-time exception handler cannot be null");
		}
		OPPLSymbolTable symtab = this.getSymbolTableFactory().createSymbolTable();
		symtab.setErrorListener(this.getListener());
		ANTLRStringStream antlrStringStream = new ANTLRStringStream(input);
		OPPLLintLexer lexer = new OPPLLintLexer(antlrStringStream);
		ConstraintSystem constraintSystem = this.getOPPLLintFactory().getOPPLFactory().createConstraintSystem();
		final TokenRewriteStream tokens = new TokenRewriteStream(lexer);
		OPPLLintCombinedParser parser = new OPPLLintCombinedParser(tokens, this.getListener());
		parser.setTreeAdaptor(ADAPTOR);
		try {
			RuleReturnScope r = parser.lint();
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
				OPPLDefine define = new OPPLDefine(nodes, symtab, this.getListener(),
						constraintSystem);
				define.setTreeAdaptor(ADAPTOR);
				define.downup(tree);
				nodes.reset();
				ManchesterOWLSyntaxTypes mOWLTypes = new ManchesterOWLSyntaxTypes(nodes, symtab,
						new SilentListener());
				symtab.setErrorListener(mOWLTypes.getErrorListener());
				mOWLTypes.downup(tree);
				nodes.reset();
				OPPLTypeEnforcement typeEnforcement = new OPPLTypeEnforcement(nodes, symtab,
						new DefaultTypeEnforcer(symtab,
								this.getOPPLLintFactory().getOPPLFactory().getOWLEntityFactory(),
								this.getListener()), this.getListener());
				typeEnforcement.downup(tree);
				symtab.setErrorListener(typeEnforcement.getErrorListener());
				nodes.reset();
				// I will re-create the Manchester OWL types parser with the
				// actual error listener
				mOWLTypes = new ManchesterOWLSyntaxTypes(nodes, symtab, this.getListener());
				mOWLTypes.downup(tree);
				nodes.reset();
				OPPLTypes opplTypes = new OPPLTypes(nodes, symtab, this.getListener(),
						constraintSystem, this.getOPPLLintFactory().getOPPLFactory());
				opplTypes.downup(tree);
				OPPLLintTypes opplLintTypes = new OPPLLintTypes(nodes, symtab, this.getListener(),
						constraintSystem, this.getOPPLLintFactory(), handler);
				opplLintTypes.downup(tree);
			}
			return tree != null ? (OPPLLintScript) ((OPPLSyntaxTree) tree).getOPPLContent() : null;
		} catch (RecognitionException e) {
			this.listener.recognitionException(e);
			return null;
		}
	}

	public String parseDescription(String input, OPPLSymbolTable symtab,
			RuntimeExceptionHandler handler) {
		symtab.setErrorListener(this.getListener());
		ANTLRStringStream antlrStringStream = new ANTLRStringStream(input);
		OPPLLintLexer lexer = new OPPLLintLexer(antlrStringStream);
		ConstraintSystem constraintSystem = this.getOPPLLintFactory().getOPPLFactory().createConstraintSystem();
		final TokenRewriteStream tokens = new TokenRewriteStream(lexer);
		OPPLLintCombinedParser parser = new OPPLLintCombinedParser(tokens, this.getListener());
		parser.setTreeAdaptor(ADAPTOR);
		try {
			RuleReturnScope r = parser.text();
			CommonTree tree = (CommonTree) r.getTree();
			if (tree != null) {
				CommonTreeNodeStream nodes = new CommonTreeNodeStream(tree);
				nodes.setTokenStream(tokens); // where to find tokens
				nodes.setTreeAdaptor(ADAPTOR);
				nodes.reset();
				ManchesterOWLSyntaxSimplify simplify = new ManchesterOWLSyntaxSimplify(nodes);
				simplify.setTreeAdaptor(ADAPTOR);
				tree = (CommonTree) simplify.downup(tree);
				nodes.reset();
				OPPLLintTypes opplLintTypes = new OPPLLintTypes(nodes, symtab, this.getListener(),
						constraintSystem, this.getOPPLLintFactory(), handler);
				opplLintTypes.downup(tree);
			}
			return tree != null ? (String) ((OPPLSyntaxTree) tree).getOPPLContent() : null;
		} catch (RecognitionException e) {
			this.listener.recognitionException(e);
			return null;
		}
	}

	/**
	 * @return the symbolTableFactory
	 */
	public SymbolTableFactory<OPPLSymbolTable> getSymbolTableFactory() {
		return this.symbolTableFactory;
	}

	/**
	 * @return the opplLintFactory
	 */
	public OPPLLintAbstractFactory getOPPLLintFactory() {
		return this.opplLintFactory;
	}

	/**
	 * @return the listener
	 */
	public ErrorListener getListener() {
		return this.listener;
	}
}
