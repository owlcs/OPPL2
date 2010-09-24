/**
 * 
 */
package org.coode.parsers.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.net.URI;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

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
import org.antlr.runtime.tree.RewriteEmptyStreamException;
import org.antlr.runtime.tree.TreeAdaptor;
import org.coode.parsers.ErrorListener;
import org.coode.parsers.MOWLLexer;
import org.coode.parsers.ManchesterOWLSyntaxParser;
import org.coode.parsers.ManchesterOWLSyntaxSimplify;
import org.coode.parsers.ManchesterOWLSyntaxTree;
import org.coode.parsers.ManchesterOWLSyntaxTypes;
import org.coode.parsers.ShortFormEntityRenderer;
import org.coode.parsers.SymbolTable;
import org.coode.parsers.Type;
import org.coode.parsers.factory.SimpleSymbolTableFactory;
import org.coode.parsers.factory.SymbolTableFactory;
import org.coode.parsers.ui.autocompletionmatcher.AutoCompletionMatcher;
import org.coode.parsers.ui.autocompletionmatcher.ManchesterOWLSyntaxSimpleAutoCompletionMatcher;
import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLAsymmetricObjectPropertyAxiom;
import org.semanticweb.owlapi.model.OWLAxiom;
import org.semanticweb.owlapi.model.OWLClassAssertionAxiom;
import org.semanticweb.owlapi.model.OWLDataPropertyAssertionAxiom;
import org.semanticweb.owlapi.model.OWLDataPropertyDomainAxiom;
import org.semanticweb.owlapi.model.OWLDataPropertyRangeAxiom;
import org.semanticweb.owlapi.model.OWLDeclarationAxiom;
import org.semanticweb.owlapi.model.OWLDifferentIndividualsAxiom;
import org.semanticweb.owlapi.model.OWLDisjointClassesAxiom;
import org.semanticweb.owlapi.model.OWLDisjointObjectPropertiesAxiom;
import org.semanticweb.owlapi.model.OWLDisjointUnionAxiom;
import org.semanticweb.owlapi.model.OWLEquivalentClassesAxiom;
import org.semanticweb.owlapi.model.OWLEquivalentDataPropertiesAxiom;
import org.semanticweb.owlapi.model.OWLEquivalentObjectPropertiesAxiom;
import org.semanticweb.owlapi.model.OWLFunctionalDataPropertyAxiom;
import org.semanticweb.owlapi.model.OWLFunctionalObjectPropertyAxiom;
import org.semanticweb.owlapi.model.OWLInverseFunctionalObjectPropertyAxiom;
import org.semanticweb.owlapi.model.OWLInverseObjectPropertiesAxiom;
import org.semanticweb.owlapi.model.OWLIrreflexiveObjectPropertyAxiom;
import org.semanticweb.owlapi.model.OWLNegativeObjectPropertyAssertionAxiom;
import org.semanticweb.owlapi.model.OWLObject;
import org.semanticweb.owlapi.model.OWLObjectPropertyAssertionAxiom;
import org.semanticweb.owlapi.model.OWLObjectPropertyDomainAxiom;
import org.semanticweb.owlapi.model.OWLObjectPropertyRangeAxiom;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;
import org.semanticweb.owlapi.model.OWLOntologyManager;
import org.semanticweb.owlapi.model.OWLReflexiveObjectPropertyAxiom;
import org.semanticweb.owlapi.model.OWLSameIndividualAxiom;
import org.semanticweb.owlapi.model.OWLSubClassOfAxiom;
import org.semanticweb.owlapi.model.OWLSubDataPropertyOfAxiom;
import org.semanticweb.owlapi.model.OWLSubObjectPropertyOfAxiom;
import org.semanticweb.owlapi.model.OWLSubPropertyChainOfAxiom;
import org.semanticweb.owlapi.model.OWLSymmetricObjectPropertyAxiom;
import org.semanticweb.owlapi.model.OWLTransitiveObjectPropertyAxiom;
import org.semanticweb.owlapi.util.OWLObjectVisitorExAdapter;
import org.semanticweb.owlapi.util.SimpleShortFormProvider;

/**
 * @author Luigi Iannone
 * 
 */
public class ManchesterOWLSyntaxValidatorGUI extends JFrame {
	private final class AxiomChecker implements ExpressionChecker<OWLAxiom> {
		private final class AxiomCheckerErrorListener implements ErrorListener {
			private CommonTree lastErrorTree = null;

			public void clear() {
				this.lastErrorTree = null;
			}

			boolean isRedundant(CommonTree possibleParent,
					CommonTree newErrorTree) {
				boolean b = possibleParent != null;
				if (b) {
					b = possibleParent == newErrorTree
							|| newErrorTree.equals(possibleParent);
					if (!b) {
						b = possibleParent.parent == newErrorTree;
						if (!b) {
							b = this.isRedundant(possibleParent.parent,
									newErrorTree);
						}
					}
				}
				return b;
			}

			public void reportThrowable(Throwable t, int line,
					int charPosInLine, int length) {
				AxiomChecker.this.lastReport = new ErrorReportImpl(t
						.getMessage(), line, charPosInLine, length);
			}

			boolean isRedundant(CommonTree newErrorTree) {
				return this.isRedundant(this.lastErrorTree, newErrorTree);
			}

			public void unrecognisedSymbol(CommonTree t) {
				this.lastErrorTree = t;
				AxiomChecker.this.lastReport = new ErrorReportImpl(
						"Unrecognised token " + t.getText(), t.getLine(), t
								.getCharPositionInLine(), t.getText().length());
			}

			public void recognitionException(RecognitionException e) {
				String message = e.getMessage() == null ? e.getClass()
						.getName() : e.getMessage();
				int endIndex = e.token.getText() == null ? 0 : e.token
						.getText().length();
				AxiomChecker.this.lastReport = new ErrorReportImpl(message
						+ " on token " + e.token, e.line, e.charPositionInLine,
						endIndex);
			}

			public void recognitionException(RecognitionException e,
					String... tokenNames) {
				String message = "Recognition exception on the token "
						+ e.token + e.getClass().getSimpleName();
				int endIndex = e.token.getText() == null ? 0 : e.token
						.getText().length();
				AxiomChecker.this.lastReport = new ErrorReportImpl(message,
						e.line, e.charPositionInLine, endIndex);
			}

			public void rewriteEmptyStreamException(
					RewriteEmptyStreamException e) {
				AxiomChecker.this.lastReport = new ErrorReportImpl(
						"Incomplete input ", 0, 0, 0);
				;
			}

			public void incompatibleSymbols(CommonTree parentExpression,
					CommonTree... expressions) {
				StringBuilder builder = new StringBuilder();
				builder.append("[");
				boolean first = true;
				for (CommonTree expression : expressions) {
					String comma = first ? "" : ", ";
					first = false;
					builder.append(comma);
					builder.append(expression.getText() == null ? ""
							: expression.getText());
				}
				builder.append("]");
				AxiomChecker.this.lastReport = new ErrorReportImpl(
						"Incompatible children expressions: "
								+ builder.toString()
								+ " for the parent expression  "
								+ parentExpression.getText(), parentExpression
								.getLine(), parentExpression
								.getCharPositionInLine(), parentExpression
								.getText().length());
			}

			public void incompatibleSymbolType(CommonTree t, Type type,
					CommonTree expression) {
				if (!this.isRedundant(t)) {
					this.lastErrorTree = t;
					AxiomChecker.this.lastReport = new ErrorReportImpl(
							"Incompatible type: " + type + "  for token: "
									+ t.getText()
									+ " for the parent expression "
									+ expression.getText(), t.getLine(), t
									.getCharPositionInLine(), t.getText()
									.length());
				}
			}

			public void illegalToken(CommonTree t, String message) {
				AxiomChecker.this.lastReport = new ErrorReportImpl(
						"Illegal token: " + t.getText(), t.getLine(), t
								.getCharPositionInLine(), t.getText().length());
			}
		}

		private final class ErrorReportImpl extends
				AbstractLinearisingErrorReport {
			private final String message;
			private final int charPositionInLine;
			private final int line;
			private final int length;

			/**
			 * @param message
			 * @param charPositionInline
			 * @param endIndex
			 */
			public ErrorReportImpl(String message, int line,
					int charPositionInline, int length) {
				if (message == null) {
					throw new NullPointerException("The message cannot be null");
				}
				this.message = message;
				this.charPositionInLine = charPositionInline;
				this.line = line;
				this.length = length;
			}

			/**
			 * @return the message
			 */
			public String getMessage() {
				return this.message;
			}

			/**
			 * @return the startIndex
			 */
			public int getCharPositionInLine() {
				return this.charPositionInLine;
			}

			/**
			 * @return the line
			 */
			public int getLine() {
				return this.line;
			}

			/**
			 * @return the length
			 */
			public int getLength() {
				return this.length;
			}
		}

		private AxiomCheckerErrorListener listener = new AxiomCheckerErrorListener();
		private ErrorReport lastReport = null;
		private OWLAxiom lastObject = null;
		private TreeAdaptor adaptor = new CommonTreeAdaptor() {
			@Override
			public Object create(Token token) {
				return new ManchesterOWLSyntaxTree(token);
			}

			@Override
			public Object dupNode(Object t) {
				if (t == null) {
					return null;
				}
				return this.create(((ManchesterOWLSyntaxTree) t).token);
			}

			@Override
			public Object errorNode(TokenStream input, Token start, Token stop,
					RecognitionException e) {
				return new CommonErrorNode(input, start, stop, e);
			}
		};
		private ManchesterOWLSyntaxTree parsed;
		private SymbolTable symbolTable;
		// private CommonTreeNodeStream lastNodeStream = null;
		private AutoCompleter autoCompleter = null;

		public void check(String text) {
			this.reset();
			this.parsed = this.parse(text);
			this.lastObject = this.parsed == null
					|| this.parsed.getOWLObject() == null ? null : this.parsed
					.getOWLObject().accept(
							new OWLObjectVisitorExAdapter<OWLAxiom>() {
								@Override
								protected OWLAxiom getDefaultReturnValue(
										OWLObject object) {
									AxiomChecker.this.lastReport = new ErrorReportImpl(
											"Wrong kind of owl object parsed "
													+ object.getClass()
															.getName(), 0, 0, 0);
									return super.getDefaultReturnValue(object);
								}

								/**
								 * @see org.semanticweb.owl.model.OWLAxiomVisitorEx#visit(org.semanticweb.owl.model.OWLSubClassAxiom)
								 */
								@Override
								public OWLAxiom visit(OWLSubClassOfAxiom axiom) {
									return axiom;
								}

								/**
								 * @see org.semanticweb.owl.model.OWLAxiomVisitorEx#visit(org.semanticweb.owl.model.OWLNegativeObjectPropertyAssertionAxiom)
								 */
								@Override
								public OWLAxiom visit(
										OWLNegativeObjectPropertyAssertionAxiom axiom) {
									return axiom;
								}

								/**
								 * @see org.semanticweb.owl.model.OWLAxiomVisitorEx#visit(org.semanticweb.owl.model.OWLAntiSymmetricObjectPropertyAxiom)
								 */
								@Override
								public OWLAxiom visit(
										OWLAsymmetricObjectPropertyAxiom axiom) {
									return axiom;
								}

								/**
								 * @see org.semanticweb.owl.model.OWLAxiomVisitorEx#visit(org.semanticweb.owl.model.OWLReflexiveObjectPropertyAxiom)
								 */
								@Override
								public OWLAxiom visit(
										OWLReflexiveObjectPropertyAxiom axiom) {
									return axiom;
								}

								/**
								 * @see org.semanticweb.owl.model.OWLAxiomVisitorEx#visit(org.semanticweb.owl.model.OWLDisjointClassesAxiom)
								 */
								@Override
								public OWLAxiom visit(
										OWLDisjointClassesAxiom axiom) {
									return axiom;
								}

								/**
								 * @see org.semanticweb.owl.model.OWLAxiomVisitorEx#visit(org.semanticweb.owl.model.OWLDataPropertyDomainAxiom)
								 */
								@Override
								public OWLAxiom visit(
										OWLDataPropertyDomainAxiom axiom) {
									return axiom;
								}

								/**
								 * @see org.semanticweb.owl.model.OWLAxiomVisitorEx#visit(org.semanticweb.owl.model.OWLObjectPropertyDomainAxiom)
								 */
								@Override
								public OWLAxiom visit(
										OWLObjectPropertyDomainAxiom axiom) {
									return axiom;
								}

								/**
								 * @see org.semanticweb.owl.model.OWLAxiomVisitorEx#visit(org.semanticweb.owl.model.OWLEquivalentObjectPropertiesAxiom)
								 */
								@Override
								public OWLAxiom visit(
										OWLEquivalentObjectPropertiesAxiom axiom) {
									return axiom;
								}

								/**
								 * @see org.semanticweb.owl.model.OWLAxiomVisitorEx#visit(org.semanticweb.owl.model.OWLDifferentIndividualsAxiom)
								 */
								@Override
								public OWLAxiom visit(
										OWLDifferentIndividualsAxiom axiom) {
									return axiom;
								}

								/**
								 * @see org.semanticweb.owl.model.OWLAxiomVisitorEx#visit(org.semanticweb.owl.model.OWLDisjointObjectPropertiesAxiom)
								 */
								@Override
								public OWLAxiom visit(
										OWLDisjointObjectPropertiesAxiom axiom) {
									return axiom;
								}

								/**
								 * @see org.semanticweb.owl.model.OWLAxiomVisitorEx#visit(org.semanticweb.owl.model.OWLObjectPropertyRangeAxiom)
								 */
								@Override
								public OWLAxiom visit(
										OWLObjectPropertyRangeAxiom axiom) {
									return axiom;
								}

								/**
								 * @see org.semanticweb.owl.model.OWLAxiomVisitorEx#visit(org.semanticweb.owl.model.OWLObjectPropertyAssertionAxiom)
								 */
								@Override
								public OWLAxiom visit(
										OWLObjectPropertyAssertionAxiom axiom) {
									return axiom;
								}

								/**
								 * @see org.semanticweb.owl.model.OWLAxiomVisitorEx#visit(org.semanticweb.owl.model.OWLFunctionalObjectPropertyAxiom)
								 */
								@Override
								public OWLAxiom visit(
										OWLFunctionalObjectPropertyAxiom axiom) {
									return axiom;
								}

								/**
								 * @see org.semanticweb.owl.model.OWLAxiomVisitorEx#visit(org.semanticweb.owl.model.OWLObjectSubPropertyAxiom)
								 */
								@Override
								public OWLAxiom visit(
										OWLSubObjectPropertyOfAxiom axiom) {
									return axiom;
								}

								/**
								 * @see org.semanticweb.owl.model.OWLAxiomVisitorEx#visit(org.semanticweb.owl.model.OWLDisjointUnionAxiom)
								 */
								@Override
								public OWLAxiom visit(
										OWLDisjointUnionAxiom axiom) {
									return axiom;
								}

								/**
								 * @see org.semanticweb.owl.model.OWLAxiomVisitorEx#visit(org.semanticweb.owl.model.OWLDeclarationAxiom)
								 */
								@Override
								public OWLAxiom visit(OWLDeclarationAxiom axiom) {
									return axiom;
								}

								/**
								 * @see org.semanticweb.owl.model.OWLAxiomVisitorEx#visit(org.semanticweb.owl.model.OWLSymmetricObjectPropertyAxiom)
								 */
								@Override
								public OWLAxiom visit(
										OWLSymmetricObjectPropertyAxiom axiom) {
									return axiom;
								}

								/**
								 * @see org.semanticweb.owl.model.OWLAxiomVisitorEx#visit(org.semanticweb.owl.model.OWLDataPropertyRangeAxiom)
								 */
								@Override
								public OWLAxiom visit(
										OWLDataPropertyRangeAxiom axiom) {
									return axiom;
								}

								/**
								 * @see org.semanticweb.owl.model.OWLAxiomVisitorEx#visit(org.semanticweb.owl.model.OWLFunctionalDataPropertyAxiom)
								 */
								@Override
								public OWLAxiom visit(
										OWLFunctionalDataPropertyAxiom axiom) {
									return axiom;
								}

								/**
								 * @see org.semanticweb.owl.model.OWLAxiomVisitorEx#visit(org.semanticweb.owl.model.OWLEquivalentDataPropertiesAxiom)
								 */
								@Override
								public OWLAxiom visit(
										OWLEquivalentDataPropertiesAxiom axiom) {
									return axiom;
								}

								/**
								 * @see org.semanticweb.owl.model.OWLAxiomVisitorEx#visit(org.semanticweb.owl.model.OWLClassAssertionAxiom)
								 */
								@Override
								public OWLAxiom visit(
										OWLClassAssertionAxiom axiom) {
									return axiom;
								}

								/**
								 * @see org.semanticweb.owl.model.OWLAxiomVisitorEx#visit(org.semanticweb.owl.model.OWLEquivalentClassesAxiom)
								 */
								@Override
								public OWLAxiom visit(
										OWLEquivalentClassesAxiom axiom) {
									return axiom;
								}

								/**
								 * @see org.semanticweb.owl.model.OWLAxiomVisitorEx#visit(org.semanticweb.owl.model.OWLDataPropertyAssertionAxiom)
								 */
								@Override
								public OWLAxiom visit(
										OWLDataPropertyAssertionAxiom axiom) {
									return axiom;
								}

								/**
								 * @see org.semanticweb.owl.model.OWLAxiomVisitorEx#visit(org.semanticweb.owl.model.OWLTransitiveObjectPropertyAxiom)
								 */
								@Override
								public OWLAxiom visit(
										OWLTransitiveObjectPropertyAxiom axiom) {
									return axiom;
								}

								/**
								 * @see org.semanticweb.owl.model.OWLAxiomVisitorEx#visit(org.semanticweb.owl.model.OWLIrreflexiveObjectPropertyAxiom)
								 */
								@Override
								public OWLAxiom visit(
										OWLIrreflexiveObjectPropertyAxiom axiom) {
									return axiom;
								}

								/**
								 * @see org.semanticweb.owl.model.OWLAxiomVisitorEx#visit(org.semanticweb.owl.model.OWLDataSubPropertyAxiom)
								 */
								@Override
								public OWLAxiom visit(
										OWLSubDataPropertyOfAxiom axiom) {
									return axiom;
								}

								/**
								 * @see org.semanticweb.owl.model.OWLAxiomVisitorEx#visit(org.semanticweb.owl.model.OWLInverseFunctionalObjectPropertyAxiom)
								 */
								@Override
								public OWLAxiom visit(
										OWLInverseFunctionalObjectPropertyAxiom axiom) {
									return axiom;
								}

								/**
								 * @see org.semanticweb.owl.model.OWLAxiomVisitorEx#visit(org.semanticweb.owl.model.OWLSameIndividualsAxiom)
								 */
								@Override
								public OWLAxiom visit(
										OWLSameIndividualAxiom axiom) {
									return axiom;
								}

								/**
								 * @see org.semanticweb.owl.model.OWLAxiomVisitorEx#visit(org.semanticweb.owl.model.OWLObjectPropertyChainSubPropertyAxiom)
								 */
								@Override
								public OWLAxiom visit(
										OWLSubPropertyChainOfAxiom axiom) {
									return axiom;
								}

								/**
								 * @see org.semanticweb.owl.model.OWLAxiomVisitorEx#visit(org.semanticweb.owl.model.OWLInverseObjectPropertiesAxiom)
								 */
								@Override
								public OWLAxiom visit(
										OWLInverseObjectPropertiesAxiom axiom) {
									return axiom;
								}
							});
		}

		/**
		 * 
		 */
		private void reset() {
			this.lastObject = null;
			this.lastReport = null;
			this.parsed = null;
			this.listener.clear();
			this.symbolTable = ManchesterOWLSyntaxValidatorGUI.this.symbolTableFactory
					.createSymbolTable();
			if (this.autoCompleter == null) {
				// AutoCompletionMatcher matcher = new
				// ParseTreeBasedAutoCompletionMatcher() {
				// @Override
				// protected SymbolTable getSymbolTable() {
				// return AxiomChecker.this.symbolTable;
				// }
				// };
				AutoCompletionMatcher matcher = new ManchesterOWLSyntaxSimpleAutoCompletionMatcher(
						new ShortFormEntityRenderer(
								new SimpleShortFormProvider()),
						ManchesterOWLSyntaxValidatorGUI.this.manager);
				this.autoCompleter = new AutoCompleter(
						ManchesterOWLSyntaxValidatorGUI.this.axiomValidator,
						matcher);
			}
		}

		public OWLAxiom createObject(String text) {
			return this.lastObject;
		}

		public ErrorReport getErrorReport() {
			return this.lastReport;
		}

		protected ManchesterOWLSyntaxTree parse(String input) {
			MOWLLexer lexer = new MOWLLexer(new ANTLRStringStream(input));
			final TokenRewriteStream tokens = new TokenRewriteStream(lexer);
			ManchesterOWLSyntaxParser parser = new ManchesterOWLSyntaxParser(
					tokens, this.listener);
			parser.setTreeAdaptor(this.adaptor);
			try {
				RuleReturnScope r = parser.main();
				CommonTree tree = (CommonTree) r.getTree();
				if (tree != null) {
					CommonTreeNodeStream nodes = new CommonTreeNodeStream(tree);
					nodes.setTokenStream(tokens); // where to find tokens
					nodes.setTreeAdaptor(this.adaptor);
					// RESOLVE SYMBOLS, COMPUTE EXPRESSION TYPES
					this.symbolTable.setErrorListener(this.listener);
					ManchesterOWLSyntaxSimplify simplify = new ManchesterOWLSyntaxSimplify(
							nodes);
					simplify.setTreeAdaptor(this.adaptor);
					simplify.downup(tree);
					nodes.reset();
					ManchesterOWLSyntaxTypes typeComp = new ManchesterOWLSyntaxTypes(
							nodes, this.symbolTable, this.listener);
					typeComp.downup(tree); // trigger resolve/type computation
					// actions
					// WALK TREE TO DUMP SUBTREE TYPES
					System.out.println(tree.toStringTree());
				}
				return (ManchesterOWLSyntaxTree) tree;
			} catch (RecognitionException e) {
				this.listener.recognitionException(e);
				return null;
			}
		}
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -4513506293333415642L;
	private final OWLOntologyManager manager = OWLManager
			.createOWLOntologyManager();
	private final SymbolTableFactory<SymbolTable> symbolTableFactory = new SimpleSymbolTableFactory(
			this.manager);
	private ExpressionChecker<OWLAxiom> checker = new AxiomChecker();
	private ExpressionEditor<OWLAxiom> axiomValidator;

	public void loadOntology(URI uri) {
		try {
			this.manager.loadOntology(IRI.create(uri));
		} catch (OWLOntologyCreationException e) {
			JOptionPane.showMessageDialog(this, e.getMessage(),
					"Error in loading ontology", JOptionPane.ERROR_MESSAGE);
		}
	}

	@Override
	public String getName() {
		return "Syntax validator";
	}

	public ManchesterOWLSyntaxValidatorGUI() {
		this.axiomValidator = new ExpressionEditor<OWLAxiom>(this.manager,
				this.checker);
		this.initGUI();
	}

	/**
	 * 
	 */
	private void initGUI() {
		this.setLayout(new BorderLayout());
		this.setTitle(this.getName());
		this.axiomValidator.setPreferredSize(new Dimension(400, 300));
		this.add(this.axiomValidator, BorderLayout.CENTER);
	}

	public static void main(String[] args) {
		ManchesterOWLSyntaxValidatorGUI frame = new ManchesterOWLSyntaxValidatorGUI();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		for (String string : args) {
			frame.loadOntology(URI.create(string));
		}
		frame.setVisible(true);
	}
}
