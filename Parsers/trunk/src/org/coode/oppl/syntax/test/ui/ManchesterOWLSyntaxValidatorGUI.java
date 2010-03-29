/**
 * 
 */
package org.coode.oppl.syntax.test.ui;

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
import org.coode.oppl.syntax.BidirectionalShortFormProviderAdapter;
import org.coode.oppl.syntax.ErrorListener;
import org.coode.oppl.syntax.ManchesterOWLSyntaxLexer;
import org.coode.oppl.syntax.ManchesterOWLSyntaxParser;
import org.coode.oppl.syntax.ManchesterOWLSyntaxSimplify;
import org.coode.oppl.syntax.ManchesterOWLSyntaxTree;
import org.coode.oppl.syntax.ManchesterOWLSyntaxTypes;
import org.coode.oppl.syntax.OWLEntityCheckerScope;
import org.coode.oppl.syntax.SymbolTable;
import org.coode.oppl.syntax.Type;
import org.semanticweb.owl.apibinding.OWLManager;
import org.semanticweb.owl.expression.ShortFormEntityChecker;
import org.semanticweb.owl.model.OWLAntiSymmetricObjectPropertyAxiom;
import org.semanticweb.owl.model.OWLAxiom;
import org.semanticweb.owl.model.OWLAxiomAnnotationAxiom;
import org.semanticweb.owl.model.OWLClassAssertionAxiom;
import org.semanticweb.owl.model.OWLDataPropertyAssertionAxiom;
import org.semanticweb.owl.model.OWLDataPropertyDomainAxiom;
import org.semanticweb.owl.model.OWLDataPropertyRangeAxiom;
import org.semanticweb.owl.model.OWLDataSubPropertyAxiom;
import org.semanticweb.owl.model.OWLDeclarationAxiom;
import org.semanticweb.owl.model.OWLDifferentIndividualsAxiom;
import org.semanticweb.owl.model.OWLDisjointClassesAxiom;
import org.semanticweb.owl.model.OWLDisjointObjectPropertiesAxiom;
import org.semanticweb.owl.model.OWLDisjointUnionAxiom;
import org.semanticweb.owl.model.OWLEntityAnnotationAxiom;
import org.semanticweb.owl.model.OWLEquivalentClassesAxiom;
import org.semanticweb.owl.model.OWLEquivalentDataPropertiesAxiom;
import org.semanticweb.owl.model.OWLEquivalentObjectPropertiesAxiom;
import org.semanticweb.owl.model.OWLFunctionalDataPropertyAxiom;
import org.semanticweb.owl.model.OWLFunctionalObjectPropertyAxiom;
import org.semanticweb.owl.model.OWLImportsDeclaration;
import org.semanticweb.owl.model.OWLInverseFunctionalObjectPropertyAxiom;
import org.semanticweb.owl.model.OWLInverseObjectPropertiesAxiom;
import org.semanticweb.owl.model.OWLIrreflexiveObjectPropertyAxiom;
import org.semanticweb.owl.model.OWLNegativeObjectPropertyAssertionAxiom;
import org.semanticweb.owl.model.OWLObject;
import org.semanticweb.owl.model.OWLObjectPropertyAssertionAxiom;
import org.semanticweb.owl.model.OWLObjectPropertyChainSubPropertyAxiom;
import org.semanticweb.owl.model.OWLObjectPropertyDomainAxiom;
import org.semanticweb.owl.model.OWLObjectPropertyRangeAxiom;
import org.semanticweb.owl.model.OWLObjectSubPropertyAxiom;
import org.semanticweb.owl.model.OWLOntologyAnnotationAxiom;
import org.semanticweb.owl.model.OWLOntologyCreationException;
import org.semanticweb.owl.model.OWLOntologyManager;
import org.semanticweb.owl.model.OWLReflexiveObjectPropertyAxiom;
import org.semanticweb.owl.model.OWLSameIndividualsAxiom;
import org.semanticweb.owl.model.OWLSubClassAxiom;
import org.semanticweb.owl.model.OWLSymmetricObjectPropertyAxiom;
import org.semanticweb.owl.model.OWLTransitiveObjectPropertyAxiom;
import org.semanticweb.owl.model.utils.DefaultOWLObjectVisitorEx;
import org.semanticweb.owl.util.SimpleShortFormProvider;

/**
 * @author Luigi Iannone
 * 
 */
public class ManchesterOWLSyntaxValidatorGUI extends JFrame {
	private final class AxiomChecker implements ExpressionChecker<OWLAxiom> {
		private final class ErrorReportImpl implements ErrorReport {
			private final String message;

			/**
			 * @param message
			 * @param startIndex
			 * @param endIndex
			 */
			public ErrorReportImpl(String message, int line, int startIndex,
					int endIndex) {
				if (message == null) {
					throw new NullPointerException("The message cannot be null");
				}
				this.message = message;
				this.startIndex = startIndex;
				this.endIndex = endIndex;
				this.line = line;
			}

			private final int startIndex;
			private final int endIndex;
			private final int line;

			/**
			 * @return the message
			 */
			public String getMessage() {
				return this.message;
			}

			/**
			 * @return the startIndex
			 */
			public int getStartIndex() {
				return this.startIndex;
			}

			/**
			 * @return the endIndex
			 */
			public int getEndIndex() {
				return this.endIndex;
			}

			/**
			 * @return the line
			 */
			public int getLine() {
				return this.line;
			}
		}

		private ErrorListener listener = new ErrorListener() {
			public void unrecognisedSymbol(Token t) {
				AxiomChecker.this.lastReport = new ErrorReportImpl(
						"Unrecognised token " + t.getText(), t.getLine(), t
								.getCharPositionInLine(),
						t.getText().length() - 1);
			}

			public void recognitionException(RecognitionException e) {
				System.err.println("Recognition exception " + e.getMessage()
						+ " " + e.getUnexpectedType());
			}

			public void rewriteEmptyStreamException(
					RewriteEmptyStreamException e) {
				System.err.println(e.getMessage());
			}

			public void incompatibleSymbols(Token parentExpression,
					Token... tokens) {
				for (Token t : tokens) {
					AxiomChecker.this.lastReport = new ErrorReportImpl(
							"Incompatible token: " + t.getText()
									+ " for the parent expression  "
									+ parentExpression.getText(), t.getLine(),
							t.getCharPositionInLine(), t.getText().length() - 1);
				}
			}

			public void incompatibleSymbolType(Token t, Type type,
					Token expression) {
				AxiomChecker.this.lastReport = new ErrorReportImpl(
						"Incompatible type: " + type + "  for token: "
								+ t.getText() + " for the parent expression "
								+ expression.getText(), t.getLine(), t
								.getCharPositionInLine(),
						t.getText().length() - 1);
			}

			public void illegalToken(Token token, String message) {
				AxiomChecker.this.lastReport = new ErrorReportImpl(
						"Illegal token: " + token.getText(), token.getLine(),
						token.getCharPositionInLine(),
						token.getText().length() - 1);
			}
		};
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

		public void check(String text) {
			this.lastObject = null;
			ManchesterOWLSyntaxTree parsed = this.parse(text);
			this.lastObject = parsed == null || parsed.getOWLObject() == null ? null
					: parsed.getOWLObject().accept(
							new DefaultOWLObjectVisitorEx<OWLAxiom>() {
								@Override
								protected OWLAxiom doDefault(OWLObject owlObject) {
									AxiomChecker.this.lastReport = new ErrorReportImpl(
											"Wrong kind of owl object parsed "
													+ owlObject.getClass()
															.getName(), 0, 0, 0);
									return null;
								}

								/**
								 * @see org.semanticweb.owl.model.OWLAxiomVisitorEx#visit(org.semanticweb.owl.model.OWLSubClassAxiom)
								 */
								@Override
								public OWLAxiom visit(OWLSubClassAxiom axiom) {
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
										OWLAntiSymmetricObjectPropertyAxiom axiom) {
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
								 * @see org.semanticweb.owl.model.OWLAxiomVisitorEx#visit(org.semanticweb.owl.model.OWLImportsDeclaration)
								 */
								@Override
								public OWLAxiom visit(
										OWLImportsDeclaration axiom) {
									return axiom;
								}

								/**
								 * @see org.semanticweb.owl.model.OWLAxiomVisitorEx#visit(org.semanticweb.owl.model.OWLAxiomAnnotationAxiom)
								 */
								@Override
								public OWLAxiom visit(
										OWLAxiomAnnotationAxiom axiom) {
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
										OWLObjectSubPropertyAxiom axiom) {
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
								 * @see org.semanticweb.owl.model.OWLAxiomVisitorEx#visit(org.semanticweb.owl.model.OWLEntityAnnotationAxiom)
								 */
								@Override
								public OWLAxiom visit(
										OWLEntityAnnotationAxiom axiom) {
									return axiom;
								}

								/**
								 * @see org.semanticweb.owl.model.OWLAxiomVisitorEx#visit(org.semanticweb.owl.model.OWLOntologyAnnotationAxiom)
								 */
								@Override
								public OWLAxiom visit(
										OWLOntologyAnnotationAxiom axiom) {
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
										OWLDataSubPropertyAxiom axiom) {
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
										OWLSameIndividualsAxiom axiom) {
									return axiom;
								}

								/**
								 * @see org.semanticweb.owl.model.OWLAxiomVisitorEx#visit(org.semanticweb.owl.model.OWLObjectPropertyChainSubPropertyAxiom)
								 */
								@Override
								public OWLAxiom visit(
										OWLObjectPropertyChainSubPropertyAxiom axiom) {
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

		public OWLAxiom createObject(String text) {
			return this.lastObject;
		}

		public ErrorReport getErrorReport() {
			return this.lastReport;
		}

		protected ManchesterOWLSyntaxTree parse(String input) {
			ManchesterOWLSyntaxLexer lexer = new ManchesterOWLSyntaxLexer(
					new ANTLRStringStream(input));
			final TokenRewriteStream tokens = new TokenRewriteStream(lexer);
			ManchesterOWLSyntaxParser parser = new ManchesterOWLSyntaxParser(
					tokens);
			parser.setTreeAdaptor(this.adaptor);
			SymbolTable symtab = new SymbolTable(
					new OWLEntityCheckerScope(
							new ShortFormEntityChecker(
									new BidirectionalShortFormProviderAdapter(
											ManchesterOWLSyntaxValidatorGUI.this.manager
													.getOntologies(),
											new SimpleShortFormProvider()))),
					ManchesterOWLSyntaxValidatorGUI.this.manager
							.getOWLDataFactory());
			try {
				RuleReturnScope r = parser.main();
				CommonTree tree = (CommonTree) r.getTree();
				if (tree != null) {
					System.out.println(tree.toStringTree());
					CommonTreeNodeStream nodes = new CommonTreeNodeStream(tree);
					nodes.setTokenStream(tokens); // where to find tokens
					nodes.setTreeAdaptor(this.adaptor);
					// RESOLVE SYMBOLS, COMPUTE EXPRESSION TYPES
					symtab.setErrorListener(this.listener);
					ManchesterOWLSyntaxSimplify simplify = new ManchesterOWLSyntaxSimplify(
							nodes);
					simplify.setTreeAdaptor(this.adaptor);
					simplify.downup(tree);
					nodes.reset();
					ManchesterOWLSyntaxTypes typeComp = new ManchesterOWLSyntaxTypes(
							nodes, symtab);
					typeComp.downup(tree); // trigger resolve/type computation
					// actions
					// WALK TREE TO DUMP SUBTREE TYPES
					System.out.println(tree.toStringTree());
				}
				return (ManchesterOWLSyntaxTree) tree;
			} catch (RecognitionException e) {
				e.printStackTrace();
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
	private ExpressionChecker<OWLAxiom> checker = new AxiomChecker();

	public void loadOntology(URI uri) {
		try {
			this.manager.loadOntology(uri);
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
		this.initGUI();
	}

	/**
	 * 
	 */
	private void initGUI() {
		this.setLayout(new BorderLayout());
		this.setTitle(this.getName());
		ExpressionEditor<OWLAxiom> axiomValidator = new ExpressionEditor<OWLAxiom>(
				this.manager, this.checker);
		axiomValidator.setPreferredSize(new Dimension(400, 300));
		this.add(axiomValidator, BorderLayout.CENTER);
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
