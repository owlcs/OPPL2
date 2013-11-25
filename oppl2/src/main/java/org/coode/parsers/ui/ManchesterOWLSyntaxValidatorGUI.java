package org.coode.parsers.ui;

import static org.coode.oppl.utils.ArgCheck.checkNotNull;

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
import org.coode.oppl.OPPLShortFormProvider;
import org.coode.parsers.ErrorListener;
import org.coode.parsers.MOWLLexer;
import org.coode.parsers.ManchesterOWLSyntaxParser;
import org.coode.parsers.ManchesterOWLSyntaxSimplify;
import org.coode.parsers.ManchesterOWLSyntaxTree;
import org.coode.parsers.ManchesterOWLSyntaxTypes;
import org.coode.parsers.ShortFormEntityRenderer;
import org.coode.parsers.SymbolTable;
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

/** @author Luigi Iannone */
public class ManchesterOWLSyntaxValidatorGUI extends JFrame {
    private final class AxiomChecker implements ExpressionChecker<OWLAxiom> {
        public AxiomChecker() {}

        private final class AxiomCheckerErrorListener implements ErrorListener {
            public AxiomCheckerErrorListener() {}

            private CommonTree lastErrorTree = null;

            public void clear() {
                lastErrorTree = null;
            }

            boolean isRedundant(CommonTree possibleParent, CommonTree newErrorTree) {
                if (possibleParent == null) {
                    return false;
                }
                boolean b = possibleParent == newErrorTree
                        || newErrorTree.equals(possibleParent);
                if (!b) {
                    b = possibleParent.parent == newErrorTree;
                    if (!b) {
                        b = this.isRedundant(possibleParent.parent, newErrorTree);
                    }
                }
                return b;
            }

            @Override
            public void reportThrowable(Throwable t, int line, int charPosInLine,
                    int length) {
                lastReport = new ErrorReportImpl(t.getMessage(), line, charPosInLine,
                        length);
            }

            boolean isRedundant(CommonTree newErrorTree) {
                return this.isRedundant(lastErrorTree, newErrorTree);
            }

            @Override
            public void unrecognisedSymbol(CommonTree t) {
                lastErrorTree = t;
                lastReport = new ErrorReportImpl("Unrecognised token " + t.getText(),
                        t.getLine(), t.getCharPositionInLine(), t.getText().length());
            }

            @Override
            public void recognitionException(RecognitionException e) {
                String message = e.getMessage() == null ? e.getClass().getName() : e
                        .getMessage();
                int endIndex = e.token.getText() == null ? 0 : e.token.getText().length();
                lastReport = new ErrorReportImpl(message + " on token " + e.token,
                        e.line, e.charPositionInLine, endIndex);
            }

            @Override
            public void
                    recognitionException(RecognitionException e, String... tokenNames) {
                String message = "Recognition exception on the token " + e.token
                        + e.getClass().getSimpleName();
                int endIndex = e.token.getText() == null ? 0 : e.token.getText().length();
                lastReport = new ErrorReportImpl(message, e.line, e.charPositionInLine,
                        endIndex);
            }

            @Override
            public void rewriteEmptyStreamException(RewriteEmptyStreamException e) {
                lastReport = new ErrorReportImpl("Incomplete input ", 0, 0, 0);
            }

            @Override
            public void incompatibleSymbols(CommonTree parentExpression,
                    CommonTree... expressions) {
                StringBuilder builder = new StringBuilder();
                builder.append("[");
                boolean first = true;
                for (CommonTree expression : expressions) {
                    String comma = first ? "" : ", ";
                    first = false;
                    builder.append(comma);
                    builder.append(expression.getText() == null ? "" : expression
                            .getText());
                }
                builder.append("]");
                lastReport = new ErrorReportImpl("Incompatible children expressions: "
                        + builder.toString() + " for the parent expression  "
                        + parentExpression.getText(), parentExpression.getLine(),
                        parentExpression.getCharPositionInLine(), parentExpression
                                .getText().length());
            }

            @Override
            public void incompatibleSymbolType(CommonTree t, org.coode.parsers.Type type,
                    CommonTree expression) {
                if (!this.isRedundant(t)) {
                    lastErrorTree = t;
                    lastReport = new ErrorReportImpl("Incompatible type: " + type
                            + "  for token: " + t.getText()
                            + " for the parent expression " + expression.getText(),
                            t.getLine(), t.getCharPositionInLine(), t.getText().length());
                }
            }

            @Override
            public void illegalToken(CommonTree t, String message) {
                lastReport = new ErrorReportImpl("Illegal token: " + t.getText(),
                        t.getLine(), t.getCharPositionInLine(), t.getText().length());
            }
        }

        private final class ErrorReportImpl extends AbstractLinearisingErrorReport {
            private final String message;
            private final int charPositionInLine;
            private final int line;
            private final int length;

            /** @param message
             * @param charPositionInline
             * @param line
             * @param length */
            public ErrorReportImpl(String message, int line, int charPositionInline,
                    int length) {
                this.message = checkNotNull(message, "message");
                charPositionInLine = charPositionInline;
                this.line = line;
                this.length = length;
            }

            @Override
            public String getMessage() {
                return message;
            }

            @Override
            public int getCharPositionInLine() {
                return charPositionInLine;
            }

            @Override
            public int getLine() {
                return line;
            }

            @Override
            public int getLength() {
                return length;
            }
        }

        protected final AxiomCheckerErrorListener listener = new AxiomCheckerErrorListener();
        protected ErrorReport lastReport = null;
        private OWLAxiom lastObject = null;
        private final TreeAdaptor adaptor = new CommonTreeAdaptor() {
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

        @Override
        public void check(String text) {
            reset();
            parsed = parse(text);
            lastObject = parsed == null || parsed.getOWLObject() == null ? null : parsed
                    .getOWLObject().accept(new OWLObjectVisitorExAdapter<OWLAxiom>() {
                        @Override
                        protected OWLAxiom getDefaultReturnValue(OWLObject object) {
                            lastReport = new ErrorReportImpl(
                                    "Wrong kind of owl object parsed "
                                            + object.getClass().getName(), 0, 0, 0);
                            return super.getDefaultReturnValue(object);
                        }

                        @Override
                        public OWLAxiom visit(OWLSubClassOfAxiom axiom) {
                            return axiom;
                        }

                        @Override
                        public OWLAxiom visit(
                                OWLNegativeObjectPropertyAssertionAxiom axiom) {
                            return axiom;
                        }

                        @Override
                        public OWLAxiom visit(OWLAsymmetricObjectPropertyAxiom axiom) {
                            return axiom;
                        }

                        @Override
                        public OWLAxiom visit(OWLReflexiveObjectPropertyAxiom axiom) {
                            return axiom;
                        }

                        @Override
                        public OWLAxiom visit(OWLDisjointClassesAxiom axiom) {
                            return axiom;
                        }

                        @Override
                        public OWLAxiom visit(OWLDataPropertyDomainAxiom axiom) {
                            return axiom;
                        }

                        @Override
                        public OWLAxiom visit(OWLObjectPropertyDomainAxiom axiom) {
                            return axiom;
                        }

                        @Override
                        public OWLAxiom visit(OWLEquivalentObjectPropertiesAxiom axiom) {
                            return axiom;
                        }

                        @Override
                        public OWLAxiom visit(OWLDifferentIndividualsAxiom axiom) {
                            return axiom;
                        }

                        @Override
                        public OWLAxiom visit(OWLDisjointObjectPropertiesAxiom axiom) {
                            return axiom;
                        }

                        @Override
                        public OWLAxiom visit(OWLObjectPropertyRangeAxiom axiom) {
                            return axiom;
                        }

                        @Override
                        public OWLAxiom visit(OWLObjectPropertyAssertionAxiom axiom) {
                            return axiom;
                        }

                        @Override
                        public OWLAxiom visit(OWLFunctionalObjectPropertyAxiom axiom) {
                            return axiom;
                        }

                        @Override
                        public OWLAxiom visit(OWLSubObjectPropertyOfAxiom axiom) {
                            return axiom;
                        }

                        @Override
                        public OWLAxiom visit(OWLDisjointUnionAxiom axiom) {
                            return axiom;
                        }

                        @Override
                        public OWLAxiom visit(OWLDeclarationAxiom axiom) {
                            return axiom;
                        }

                        @Override
                        public OWLAxiom visit(OWLSymmetricObjectPropertyAxiom axiom) {
                            return axiom;
                        }

                        @Override
                        public OWLAxiom visit(OWLDataPropertyRangeAxiom axiom) {
                            return axiom;
                        }

                        @Override
                        public OWLAxiom visit(OWLFunctionalDataPropertyAxiom axiom) {
                            return axiom;
                        }

                        @Override
                        public OWLAxiom visit(OWLEquivalentDataPropertiesAxiom axiom) {
                            return axiom;
                        }

                        @Override
                        public OWLAxiom visit(OWLClassAssertionAxiom axiom) {
                            return axiom;
                        }

                        @Override
                        public OWLAxiom visit(OWLEquivalentClassesAxiom axiom) {
                            return axiom;
                        }

                        @Override
                        public OWLAxiom visit(OWLDataPropertyAssertionAxiom axiom) {
                            return axiom;
                        }

                        @Override
                        public OWLAxiom visit(OWLTransitiveObjectPropertyAxiom axiom) {
                            return axiom;
                        }

                        @Override
                        public OWLAxiom visit(OWLIrreflexiveObjectPropertyAxiom axiom) {
                            return axiom;
                        }

                        @Override
                        public OWLAxiom visit(OWLSubDataPropertyOfAxiom axiom) {
                            return axiom;
                        }

                        @Override
                        public OWLAxiom visit(
                                OWLInverseFunctionalObjectPropertyAxiom axiom) {
                            return axiom;
                        }

                        @Override
                        public OWLAxiom visit(OWLSameIndividualAxiom axiom) {
                            return axiom;
                        }

                        @Override
                        public OWLAxiom visit(OWLSubPropertyChainOfAxiom axiom) {
                            return axiom;
                        }

                        @Override
                        public OWLAxiom visit(OWLInverseObjectPropertiesAxiom axiom) {
                            return axiom;
                        }
                    });
        }

        private void reset() {
            lastObject = null;
            lastReport = null;
            parsed = null;
            listener.clear();
            symbolTable = symbolTableFactory.createSymbolTable();
            if (autoCompleter == null) {
                // AutoCompletionMatcher matcher = new
                // ParseTreeBasedAutoCompletionMatcher() {
                // @Override
                // protected SymbolTable getSymbolTable() {
                // return AxiomChecker.this.symbolTable;
                // }
                // };
                AutoCompletionMatcher matcher = new ManchesterOWLSyntaxSimpleAutoCompletionMatcher(
                        new ShortFormEntityRenderer(new OPPLShortFormProvider(
                                new SimpleShortFormProvider())), manager);
                autoCompleter = new AutoCompleter(axiomValidator, matcher);
            }
        }

        @Override
        public OWLAxiom createObject(String text) {
            return lastObject;
        }

        @Override
        public ErrorReport getErrorReport() {
            return lastReport;
        }

        protected ManchesterOWLSyntaxTree parse(String input) {
            MOWLLexer lexer = new MOWLLexer(new ANTLRStringStream(input));
            final TokenRewriteStream tokens = new TokenRewriteStream(lexer);
            ManchesterOWLSyntaxParser parser = new ManchesterOWLSyntaxParser(tokens,
                    listener);
            parser.setTreeAdaptor(adaptor);
            RuleReturnScope r = parser.main();
            CommonTree tree = (CommonTree) r.getTree();
            if (tree != null) {
                CommonTreeNodeStream nodes = new CommonTreeNodeStream(tree);
                nodes.setTokenStream(tokens); // where to find tokens
                nodes.setTreeAdaptor(adaptor);
                // RESOLVE SYMBOLS, COMPUTE EXPRESSION TYPES
                symbolTable.setErrorListener(listener);
                ManchesterOWLSyntaxSimplify simplify = new ManchesterOWLSyntaxSimplify(
                        nodes);
                simplify.setTreeAdaptor(adaptor);
                simplify.downup(tree);
                nodes.reset();
                ManchesterOWLSyntaxTypes typeComp = new ManchesterOWLSyntaxTypes(nodes,
                        symbolTable, listener);
                typeComp.downup(tree); // trigger resolve/type computation
                // actions
                // WALK TREE TO DUMP SUBTREE TYPES
            }
            return (ManchesterOWLSyntaxTree) tree;
        }
    }

    private static final long serialVersionUID = 20100L;
    protected final OWLOntologyManager manager = OWLManager.createOWLOntologyManager();
    protected final SymbolTableFactory<SymbolTable> symbolTableFactory = new SimpleSymbolTableFactory(
            manager);
    private final ExpressionChecker<OWLAxiom> checker = new AxiomChecker();
    protected final ExpressionEditor<OWLAxiom> axiomValidator;

    /** @param uri */
    public void loadOntology(URI uri) {
        try {
            manager.loadOntology(IRI.create(uri));
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
        axiomValidator = new ExpressionEditor<OWLAxiom>(manager, checker);
        initGUI();
    }

    private void initGUI() {
        setLayout(new BorderLayout());
        setTitle(getName());
        axiomValidator.setPreferredSize(new Dimension(400, 300));
        this.add(axiomValidator, BorderLayout.CENTER);
    }

    @SuppressWarnings("javadoc")
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
