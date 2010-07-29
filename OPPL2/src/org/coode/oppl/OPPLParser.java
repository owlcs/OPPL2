/**
 * 
 */
package org.coode.oppl;

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
import org.coode.parsers.ErrorListener;
import org.coode.parsers.ManchesterOWLSyntaxSimplify;
import org.coode.parsers.ManchesterOWLSyntaxTypes;
import org.coode.parsers.factory.SymbolTableFactory;
import org.coode.parsers.oppl.DefaultTypeEnforcer;
import org.coode.parsers.oppl.OPPLDefine;
import org.coode.parsers.oppl.OPPLLexer;
import org.coode.parsers.oppl.OPPLScriptParser;
import org.coode.parsers.oppl.OPPLSymbolTable;
import org.coode.parsers.oppl.OPPLSyntaxTree;
import org.coode.parsers.oppl.OPPLTypeEnforcement;
import org.coode.parsers.oppl.OPPLTypes;
import org.coode.parsers.oppl.OPPLTypesParts;
import org.semanticweb.owl.model.OWLAxiom;

/**
 * @author Luigi Iannone
 * 
 */
public class OPPLParser implements AbstractOPPLParser {
	/**
	 * Abstract factory for creating parsers
	 * 
	 * @author Luigi Iannone
	 * 
	 */
	public interface AbstractParserFactory {
		/**
		 * Builds an OPPLParser attaching an ErrorListener to it.
		 * 
		 * @param errorListener
		 *            The ErrorListener. Cannot be {@code null}.
		 * @return An OPPLParser.
		 * @throws NullPointerException
		 *             when the input is {@code null}.
		 */
		public OPPLParser build(ErrorListener errorListener);

		/**
		 * Retrieves an instance OPPLAbstractFactory that this
		 * AbstractParserFactory provides.
		 * 
		 * @return An OPPLAbstractFactory
		 */
		public OPPLAbstractFactory getOPPLFactory();
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
	private final SymbolTableFactory<OPPLSymbolTable> symbolTableFactory;

	/**
	 * @param factory
	 * @param listener
	 * @param symbolTableFactory
	 */
	public OPPLParser(OPPLAbstractFactory factory, ErrorListener listener,
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
		this.opplFactory = factory;
		this.listener = listener;
		this.symbolTableFactory = symbolTableFactory;
	}

	private final ErrorListener listener;
	private final OPPLAbstractFactory opplFactory;

	/**
	 * @see org.coode.oppl.AbstractOPPLParser#parse(java.lang.String)
	 */
	public OPPLScript parse(String input) {
		OPPLSymbolTable symtab = this.getSymbolTableFactory().createSymbolTable();
		symtab.setErrorListener(this.getListener());
		ANTLRStringStream antlrStringStream = new ANTLRStringStream(input);
		OPPLLexer lexer = new OPPLLexer(antlrStringStream);
		ConstraintSystem constraintSystem = this.getOPPLAbstractFactory().createConstraintSystem();
		final TokenRewriteStream tokens = new TokenRewriteStream(lexer);
		OPPLScriptParser parser = new OPPLScriptParser(tokens, this.getListener());
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
				ManchesterOWLSyntaxSimplify simplify = new ManchesterOWLSyntaxSimplify(nodes);
				simplify.setTreeAdaptor(ADAPTOR);
				simplify.downup(tree);
				nodes.reset();
				OPPLDefine define = new OPPLDefine(nodes, symtab, this.getListener(),
						constraintSystem);
				define.setTreeAdaptor(ADAPTOR);
				define.downup(tree);
				nodes.reset();
				ManchesterOWLSyntaxTypes mOWLTypes = new ManchesterOWLSyntaxTypes(nodes, symtab,
						this.getListener());
				mOWLTypes.downup(tree);
				nodes.reset();
				OPPLTypeEnforcement typeEnforcement = new OPPLTypeEnforcement(nodes, symtab,
						new DefaultTypeEnforcer(symtab,
								this.getOPPLAbstractFactory().getOWLEntityFactory(),
								this.getListener()), this.getListener());
				typeEnforcement.downup(tree);
				nodes.reset();
				mOWLTypes.downup(tree);
				nodes.reset();
				OPPLTypes opplTypes = new OPPLTypes(nodes, symtab, this.getListener(),
						constraintSystem, this.getOPPLAbstractFactory());
				opplTypes.downup(tree);
			}
			return tree != null ? (OPPLScript) ((OPPLSyntaxTree) tree).getOPPLContent() : null;
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
	 * @return the listener
	 */
	public ErrorListener getListener() {
		return this.listener;
	}

	/**
	 * @return the factory
	 */
	public OPPLAbstractFactory getOPPLAbstractFactory() {
		return this.opplFactory;
	}

	public AbstractConstraint parseConstraint(String input, OPPLSymbolTable symbolTable,
			ConstraintSystem constraintSystem) {
		ANTLRStringStream antlrStringStream = new ANTLRStringStream(input);
		OPPLLexer lexer = new OPPLLexer(antlrStringStream);
		final TokenRewriteStream tokens = new TokenRewriteStream(lexer);
		OPPLScriptParser parser = new OPPLScriptParser(tokens);
		parser.setTreeAdaptor(ADAPTOR);
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
			simplify.downup(tree);
			nodes.reset();
			OPPLDefine define = new OPPLDefine(nodes, symbolTable, this.getListener(),
					constraintSystem);
			define.setTreeAdaptor(ADAPTOR);
			define.downup(tree);
			nodes.reset();
			ManchesterOWLSyntaxTypes mOWLTypes = new ManchesterOWLSyntaxTypes(nodes, symbolTable,
					this.getListener());
			mOWLTypes.downup(tree);
			nodes.reset();
			OPPLTypesParts opplTypes = new OPPLTypesParts(nodes, symbolTable, this.getListener(),
					constraintSystem, this.getOPPLAbstractFactory());
			opplTypes.downup(tree);
			return (AbstractConstraint) ((OPPLSyntaxTree) tree).getOPPLContent();
		} catch (RecognitionException e) {
			this.listener.recognitionException(e);
			return null;
		}
	}

	public Variable parseOPPLFunction(String input, Variable variable, OPPLSymbolTable symbolTable,
			ConstraintSystem constraintSystem) {
		ANTLRStringStream antlrStringStream = new ANTLRStringStream(input);
		OPPLLexer lexer = new OPPLLexer(antlrStringStream);
		final TokenRewriteStream tokens = new TokenRewriteStream(lexer);
		OPPLScriptParser parser = new OPPLScriptParser(tokens);
		parser.setTreeAdaptor(ADAPTOR);
		try {
			RuleReturnScope r = parser.opplFunction();
			CommonTree tree = (CommonTree) r.getTree();
			CommonTreeNodeStream nodes = new CommonTreeNodeStream(tree);
			nodes.setTokenStream(tokens); // where to find tokens
			nodes.setTreeAdaptor(ADAPTOR);
			nodes.reset();
			// RESOLVE SYMBOLS, COMPUTE EXPRESSION TYPES
			ManchesterOWLSyntaxSimplify simplify = new ManchesterOWLSyntaxSimplify(nodes);
			simplify.setTreeAdaptor(ADAPTOR);
			simplify.downup(tree);
			nodes.reset();
			OPPLDefine define = new OPPLDefine(nodes, symbolTable, this.getListener(),
					constraintSystem);
			define.setTreeAdaptor(ADAPTOR);
			define.downup(tree);
			nodes.reset();
			ManchesterOWLSyntaxTypes mOWLTypes = new ManchesterOWLSyntaxTypes(nodes, symbolTable,
					this.getListener());
			mOWLTypes.downup(tree);
			nodes.reset();
			mOWLTypes.downup(tree);
			nodes.reset();
			OPPLTypesParts opplTypes = new OPPLTypesParts(nodes, symbolTable, this.getListener(),
					constraintSystem, this.getOPPLAbstractFactory());
			opplTypes.setVariable(variable);
			opplTypes.downup(tree);
			return (Variable) ((OPPLSyntaxTree) tree).getOPPLContent();
		} catch (RecognitionException e) {
			this.listener.recognitionException(e);
			return null;
		}
	}

	/**
	 * @see org.coode.oppl.AbstractOPPLParser#parse(java.lang.String)
	 */
	public OWLAxiom parseAxiom(String input, OPPLSymbolTable symbolTable,
			ConstraintSystem constraintSystem) {
		ANTLRStringStream antlrStringStream = new ANTLRStringStream(input);
		OPPLLexer lexer = new OPPLLexer(antlrStringStream);
		final TokenRewriteStream tokens = new TokenRewriteStream(lexer);
		OPPLScriptParser parser = new OPPLScriptParser(tokens);
		parser.setTreeAdaptor(ADAPTOR);
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
			simplify.downup(tree);
			nodes.reset();
			OPPLDefine define = new OPPLDefine(nodes, symbolTable, this.getListener(),
					constraintSystem);
			define.setTreeAdaptor(ADAPTOR);
			define.downup(tree);
			nodes.reset();
			ManchesterOWLSyntaxTypes mOWLTypes = new ManchesterOWLSyntaxTypes(nodes, symbolTable,
					this.getListener());
			mOWLTypes.downup(tree);
			nodes.reset();
			OPPLTypeEnforcement typeEnforcement = new OPPLTypeEnforcement(
					nodes,
					symbolTable,
					new DefaultTypeEnforcer(symbolTable,
							this.getOPPLAbstractFactory().getOWLEntityFactory(), this.getListener()),
					this.getListener());
			typeEnforcement.downup(tree);
			nodes.reset();
			mOWLTypes.downup(tree);
			return (OWLAxiom) ((OPPLSyntaxTree) tree).getOWLObject();
		} catch (RecognitionException e) {
			this.listener.recognitionException(e);
			return null;
		}
	}
}
