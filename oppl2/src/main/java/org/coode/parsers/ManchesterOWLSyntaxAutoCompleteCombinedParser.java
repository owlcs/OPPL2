// $ANTLR 3.2 Sep 23, 2009 12:02:23 /Users/luigi/Documents/workspace/Parsers/src/ManchesterOWLSyntaxAutoCompleteCombined.g 2011-01-10 16:18:12
package org.coode.parsers;

import org.antlr.runtime.BaseRecognizer;
import org.antlr.runtime.BitSet;
import org.antlr.runtime.DFA;
import org.antlr.runtime.IntStream;
import org.antlr.runtime.MismatchedTokenException;
import org.antlr.runtime.NoViableAltException;
import org.antlr.runtime.Parser;
import org.antlr.runtime.ParserRuleReturnScope;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.RecognizerSharedState;
import org.antlr.runtime.TokenStream;
import org.antlr.runtime.tree.CommonTreeAdaptor;
import org.antlr.runtime.tree.RewriteEmptyStreamException;
import org.antlr.runtime.tree.RewriteRuleSubtreeStream;
import org.antlr.runtime.tree.TreeAdaptor;
import org.coode.oppl.log.Logger;
import org.coode.oppl.log.Logging;

@SuppressWarnings({ "javadoc", "incomplete-switch" })
public class ManchesterOWLSyntaxAutoCompleteCombinedParser extends Parser {
    public static final String[] tokenNames = new String[] { "<invalid>", "<EOR>",
            "<DOWN>", "<UP>", "COMPOSITION", "OPEN_PARENTHESYS", "OPEN_CURLY_BRACES",
            "CLOSED_CURLY_BRACES", "CLOSED_PARENTHESYS", "WHITESPACE", "AND", "OR",
            "NOT", "SOME", "ONLY", "MIN", "MAX", "EXACTLY", "VALUE", "INVERSE",
            "SUBCLASS_OF", "SUB_PROPERTY_OF", "EQUIVALENT_TO", "SAME_AS",
            "DIFFERENT_FROM", "INVERSE_OF", "DISJOINT_WITH", "DOMAIN", "RANGE",
            "FUNCTIONAL", "SYMMETRIC", "ANTI_SYMMETRIC", "REFLEXIVE", "IRREFLEXIVE",
            "TRANSITIVE", "INVERSE_FUNCTIONAL", "POW", "COMMA", "INSTANCE_OF", "TYPES",
            "DBLQUOTE", "DIGIT", "INTEGER", "LETTER", "IDENTIFIER", "ENTITY_REFERENCE",
            "QUESTION_MARK", "Tokens", "SUB_CLASS_AXIOM", "EQUIVALENT_TO_AXIOM",
            "DISJOINT_WITH_AXIOM", "SUB_PROPERTY_AXIOM", "SAME_AS_AXIOM",
            "DIFFERENT_FROM_AXIOM", "UNARY_AXIOM", "DISJUNCTION", "CONJUNCTION",
            "PROPERTY_CHAIN", "NEGATED_EXPRESSION", "NEGATED_ASSERTION",
            "INVERSE_PROPERTY", "SOME_RESTRICTION", "ALL_RESTRICTION",
            "VALUE_RESTRICTION", "CARDINALITY_RESTRICTION", "ONE_OF", "TYPE_ASSERTION",
            "ROLE_ASSERTION", "INVERSE_OBJECT_PROPERTY_EXPRESSION", "EXPRESSION",
            "CONSTANT", "HAS_KEY", "IRI", "ANNOTATION_ASSERTION",
            "STANDALONE_EXPRESSION", "INCOMPLETE_TYPE_ASSERTION",
            "INCOMPLETE_ROLE_ASSERTION", "INCOMPLETE_UNARY_AXIOM",
            "INCOMPLETE_SUB_CLASS_AXIOM", "INCOMPLETE_EQUIVALENT_TO_AXIOM",
            "INCOMPLETE_DISJOINT_WITH_AXIOM", "INCOMPLETE_SUB_PROPERTY_AXIOM",
            "INCOMPLETE_SAME_AS_AXIOM", "INCOMPLETE_DIFFERENT_FROM_AXIOM",
            "INCOMPLETE_DOMAIN", "INCOMPLETE_RANGE", "INCOMPLETE_INVERSE_OF",
            "INCOMPLETE_PROPERTY_CHAIN", "INCOMPLETE_DISJUNCTION",
            "INCOMPLETE_CONJUNCTION", "INCOMPLETE_INVERSE_OBJECT_PROPERTY_EXPRESSION",
            "INCOMPLETE_NEGATED_EXPRESSION", "INCOMPLETE_SOME_RESTRICTION",
            "INCOMPLETE_ALL_RESTRICTION", "INCOMPLETE_CARDINALITY_RESTRICTION",
            "INCOMPLETE_ONE_OF", "INCOMPLETE_VALUE_RESTRICTION", "INCOMPLETE_EXPRESSION",
            "AT", "OPEN_SQUARE_BRACKET", "CLOSED_SQUARE_BRACKET", "EQUAL", "LESS_THAN",
            "LESS_THAN_EQUAL", "GREATER_THAN", "GREATER_THAN_EQUAL", "DATA_RANGE", "693",
            "694", "695", "696", "697", "698", "699", "700", "701", "702", "703", "704",
            "705", "706", "707", "708", "709", "710", "711", "712", "713", "714", "715",
            "716", "717", "718", "719", "720", "721", "722", "723", "724" };
    public static final int COMMA = 37;
    public static final int GREATER_THAN = 667;
    public static final int DIFFERENT_FROM = 24;
    public static final int LESS_THAN = 665;
    public static final int TYPE_ASSERTION = 66;
    public static final int INCOMPLETE_CONJUNCTION = 615;
    public static final int SAME_AS_AXIOM = 52;
    public static final int INCOMPLETE_SUB_CLASS_AXIOM = 604;
    public static final int TYPES = 39;
    public static final int ROLE_ASSERTION = 67;
    public static final int ALL_RESTRICTION = 62;
    public static final int QUESTION_MARK = 46;
    public static final int AND = 10;
    public static final int EXPRESSION = 69;
    public static final int CONSTANT = 70;
    public static final int VALUE_RESTRICTION = 63;
    public static final int ONE_OF = 65;
    public static final int CARDINALITY_RESTRICTION = 64;
    public static final int SAME_AS = 23;
    public static final int EXACTLY = 17;
    public static final int TRANSITIVE = 34;
    public static final int SUBCLASS_OF = 20;
    public static final int ENTITY_REFERENCE = 45;
    public static final int CONJUNCTION = 56;
    public static final int INVERSE_OF = 25;
    public static final int AT = 629;
    public static final int RANGE = 28;
    public static final int DATA_RANGE = 692;
    public static final int CLOSED_PARENTHESYS = 8;
    public static final int PROPERTY_CHAIN = 57;
    public static final int OPEN_SQUARE_BRACKET = 662;
    public static final int EQUIVALENT_TO_AXIOM = 49;
    public static final int INCOMPLETE_ALL_RESTRICTION = 619;
    public static final int SYMMETRIC = 30;
    public static final int DISJOINT_WITH = 26;
    public static final int INCOMPLETE_VALUE_RESTRICTION = 622;
    public static final int DISJUNCTION = 55;
    public static final int INCOMPLETE_CARDINALITY_RESTRICTION = 620;
    public static final int NEGATED_EXPRESSION = 58;
    public static final int EQUAL = 664;
    public static final int DIFFERENT_FROM_AXIOM = 53;
    public static final int GREATER_THAN_EQUAL = 668;
    public static final int EQUIVALENT_TO = 22;
    public static final int DOMAIN = 27;
    public static final int SUB_PROPERTY_OF = 21;
    public static final int INVERSE_OBJECT_PROPERTY_EXPRESSION = 68;
    public static final int INVERSE_PROPERTY = 60;
    public static final int SUB_CLASS_AXIOM = 48;
    public static final int SUB_PROPERTY_AXIOM = 51;
    public static final int INCOMPLETE_DIFFERENT_FROM_AXIOM = 609;
    public static final int INCOMPLETE_INVERSE_OBJECT_PROPERTY_EXPRESSION = 616;
    public static final int IDENTIFIER = 44;
    public static final int UNARY_AXIOM = 54;
    public static final int INCOMPLETE_PROPERTY_CHAIN = 613;
    public static final int OPEN_CURLY_BRACES = 6;
    public static final int STANDALONE_EXPRESSION = 600;
    public static final int CLOSED_SQUARE_BRACKET = 663;
    public static final int INSTANCE_OF = 38;
    public static final int INCOMPLETE_DISJUNCTION = 614;
    public static final int SOME_RESTRICTION = 61;
    public static final int INCOMPLETE_SUB_PROPERTY_AXIOM = 607;
    public static final int INCOMPLETE_INVERSE_OF = 612;
    public static final int IRI = 110;
    public static final int INCOMPLETE_DOMAIN = 610;
    public static final int LESS_THAN_EQUAL = 666;
    public static final int VALUE = 18;
    public static final int INCOMPLETE_UNARY_AXIOM = 603;
    public static final int INVERSE_FUNCTIONAL = 35;
    public static final int OR = 11;
    public static final int INCOMPLETE_EXPRESSION = 623;
    public static final int INTEGER = 42;
    public static final int INVERSE = 19;
    public static final int HAS_KEY = 109;
    public static final int DISJOINT_WITH_AXIOM = 50;
    public static final int INCOMPLETE_DISJOINT_WITH_AXIOM = 606;
    public static final int DIGIT = 41;
    public static final int COMPOSITION = 4;
    public static final int ANNOTATION_ASSERTION = 111;
    public static final int INCOMPLETE_RANGE = 611;
    public static final int FUNCTIONAL = 29;
    public static final int LETTER = 43;
    public static final int MAX = 16;
    public static final int INCOMPLETE_ROLE_ASSERTION = 602;
    public static final int NEGATED_ASSERTION = 59;
    public static final int ONLY = 14;
    public static final int DBLQUOTE = 40;
    public static final int MIN = 15;
    public static final int POW = 36;
    public static final int INCOMPLETE_TYPE_ASSERTION = 601;
    public static final int INCOMPLETE_ONE_OF = 621;
    public static final int INCOMPLETE_NEGATED_EXPRESSION = 617;
    public static final int WHITESPACE = 9;
    public static final int SOME = 13;
    public static final int INCOMPLETE_SAME_AS_AXIOM = 608;
    public static final int INCOMPLETE_EQUIVALENT_TO_AXIOM = 605;
    public static final int EOF = -1;
    public static final int ANTI_SYMMETRIC = 31;
    public static final int Tokens = 47;
    public static final int CLOSED_CURLY_BRACES = 7;
    public static final int INCOMPLETE_SOME_RESTRICTION = 618;
    public static final int REFLEXIVE = 32;
    public static final int NOT = 12;
    public static final int OPEN_PARENTHESYS = 5;
    public static final int IRREFLEXIVE = 33;
    // delegates
    public ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase_MOWLParser gMOWLParser;
    public ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase gManchesterOWLSyntaxAutoCompleteBase;

    // delegators
    public ManchesterOWLSyntaxAutoCompleteCombinedParser(TokenStream input) {
        this(input, new RecognizerSharedState());
    }

    public ManchesterOWLSyntaxAutoCompleteCombinedParser(TokenStream input,
            RecognizerSharedState state) {
        super(input, state);
        gManchesterOWLSyntaxAutoCompleteBase = new ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase(
                input, state, this);
        gMOWLParser = gManchesterOWLSyntaxAutoCompleteBase.gMOWLParser;
    }

    protected TreeAdaptor adaptor = new CommonTreeAdaptor();

    public void setTreeAdaptor(TreeAdaptor adaptor) {
        this.adaptor = adaptor;
        gManchesterOWLSyntaxAutoCompleteBase.setTreeAdaptor(this.adaptor);
    }

    public TreeAdaptor getTreeAdaptor() {
        return adaptor;
    }

    @Override
    public String[] getTokenNames() {
        return ManchesterOWLSyntaxAutoCompleteCombinedParser.tokenNames;
    }

    @Override
    public String getGrammarFileName() {
        return "/Users/luigi/Documents/workspace/Parsers/src/ManchesterOWLSyntaxAutoCompleteCombined.g";
    }

    private ErrorListener errorListener;

    public ManchesterOWLSyntaxAutoCompleteCombinedParser(TokenStream input,
            ErrorListener errorListener) {
        this(input, new RecognizerSharedState(), errorListener);
    }

    public ManchesterOWLSyntaxAutoCompleteCombinedParser(TokenStream input,
            RecognizerSharedState state, ErrorListener errorListener) {
        this(input, state);
        if (errorListener == null) {
            throw new NullPointerException("The error listener cannot be null");
        }
        this.errorListener = errorListener;
    }

    @Override
    public void displayRecognitionError(String[] t, RecognitionException e) {
        if (getErrorListener() != null) {
            getErrorListener().recognitionException(e, t);
        }
    }

    public ErrorListener getErrorListener() {
        return errorListener;
    }

    protected void mismatch(IntStream in, int ttype,
            @SuppressWarnings("unused") BitSet follow) throws RecognitionException {
        throw new MismatchedTokenException(ttype, in);
    }

    @Override
    public Object recoverFromMismatchedSet(IntStream in, RecognitionException e,
            BitSet follow) throws RecognitionException {
        throw e;
    }

    public static class main_return extends ParserRuleReturnScope {
        ManchesterOWLSyntaxTree tree;

        @Override
        public Object getTree() {
            return tree;
        }
    }

    // $ANTLR start "main"
    // /Users/luigi/Documents/workspace/Parsers/src/ManchesterOWLSyntaxAutoCompleteCombined.g:65:1:
    // main : ( options {backtrack=true; } : axiom -> axiom | incompleteAxiom ->
    // incompleteAxiom | incompleteExpression -> incompleteExpression |
    // standaloneExpression -> standaloneExpression ) ;
    public final ManchesterOWLSyntaxAutoCompleteCombinedParser.main_return main() {
        ManchesterOWLSyntaxAutoCompleteCombinedParser.main_return retval = new ManchesterOWLSyntaxAutoCompleteCombinedParser.main_return();
        retval.start = input.LT(1);
        ManchesterOWLSyntaxTree root_0 = null;
        ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase_MOWLParser.axiom_return axiom1 = null;
        ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase.incompleteAxiom_return incompleteAxiom2 = null;
        ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase.incompleteExpression_return incompleteExpression3 = null;
        ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase.standaloneExpression_return standaloneExpression4 = null;
        RewriteRuleSubtreeStream stream_incompleteExpression = new RewriteRuleSubtreeStream(
                adaptor, "rule incompleteExpression");
        RewriteRuleSubtreeStream stream_incompleteAxiom = new RewriteRuleSubtreeStream(
                adaptor, "rule incompleteAxiom");
        RewriteRuleSubtreeStream stream_axiom = new RewriteRuleSubtreeStream(adaptor,
                "rule axiom");
        RewriteRuleSubtreeStream stream_standaloneExpression = new RewriteRuleSubtreeStream(
                adaptor, "rule standaloneExpression");
        try {
            // /Users/luigi/Documents/workspace/Parsers/src/ManchesterOWLSyntaxAutoCompleteCombined.g:65:5:
            // ( ( options {backtrack=true; } : axiom -> axiom | incompleteAxiom
            // -> incompleteAxiom | incompleteExpression -> incompleteExpression
            // | standaloneExpression -> standaloneExpression ) )
            // /Users/luigi/Documents/workspace/Parsers/src/ManchesterOWLSyntaxAutoCompleteCombined.g:66:1:
            // ( options {backtrack=true; } : axiom -> axiom | incompleteAxiom
            // -> incompleteAxiom | incompleteExpression -> incompleteExpression
            // | standaloneExpression -> standaloneExpression )
            {
                // /Users/luigi/Documents/workspace/Parsers/src/ManchesterOWLSyntaxAutoCompleteCombined.g:66:1:
                // ( options {backtrack=true; } : axiom -> axiom |
                // incompleteAxiom -> incompleteAxiom | incompleteExpression ->
                // incompleteExpression | standaloneExpression ->
                // standaloneExpression )
                int alt1 = 4;
                alt1 = dfa1.predict(input);
                switch (alt1) {
                    case 1:
                    // /Users/luigi/Documents/workspace/Parsers/src/ManchesterOWLSyntaxAutoCompleteCombined.g:68:3:
                    // axiom
                    {
                        pushFollow(FOLLOW_axiom_in_main125);
                        axiom1 = axiom();
                        state._fsp--;
                        if (state.failed) {
                            return retval;
                        }
                        if (state.backtracking == 0) {
                            stream_axiom.add(axiom1.getTree());
                        }
                        // AST REWRITE
                        // elements: axiom
                        // token labels:
                        // rule labels: retval
                        // token list labels:
                        // rule list labels:
                        // wildcard labels:
                        if (state.backtracking == 0) {
                            retval.tree = root_0;
                            root_0 = (ManchesterOWLSyntaxTree) adaptor.nil();
                            // 68:10: -> axiom
                            {
                                adaptor.addChild(root_0, stream_axiom.nextTree());
                            }
                            retval.tree = root_0;
                        }
                    }
                        break;
                    case 2:
                    // /Users/luigi/Documents/workspace/Parsers/src/ManchesterOWLSyntaxAutoCompleteCombined.g:69:5:
                    // incompleteAxiom
                    {
                        pushFollow(FOLLOW_incompleteAxiom_in_main136);
                        incompleteAxiom2 = incompleteAxiom();
                        state._fsp--;
                        if (state.failed) {
                            return retval;
                        }
                        if (state.backtracking == 0) {
                            stream_incompleteAxiom.add(incompleteAxiom2.getTree());
                        }
                        // AST REWRITE
                        // elements: incompleteAxiom
                        // token labels:
                        // rule labels: retval
                        // token list labels:
                        // rule list labels:
                        // wildcard labels:
                        if (state.backtracking == 0) {
                            retval.tree = root_0;
                            root_0 = (ManchesterOWLSyntaxTree) adaptor.nil();
                            // 69:22: -> incompleteAxiom
                            {
                                adaptor.addChild(root_0,
                                        stream_incompleteAxiom.nextTree());
                            }
                            retval.tree = root_0;
                        }
                    }
                        break;
                    case 3:
                    // /Users/luigi/Documents/workspace/Parsers/src/ManchesterOWLSyntaxAutoCompleteCombined.g:70:5:
                    // incompleteExpression
                    {
                        pushFollow(FOLLOW_incompleteExpression_in_main147);
                        incompleteExpression3 = incompleteExpression();
                        state._fsp--;
                        if (state.failed) {
                            return retval;
                        }
                        if (state.backtracking == 0) {
                            stream_incompleteExpression.add(incompleteExpression3
                                    .getTree());
                        }
                        // AST REWRITE
                        // elements: incompleteExpression
                        // token labels:
                        // rule labels: retval
                        // token list labels:
                        // rule list labels:
                        // wildcard labels:
                        if (state.backtracking == 0) {
                            retval.tree = root_0;
                            root_0 = (ManchesterOWLSyntaxTree) adaptor.nil();
                            // 70:27: -> incompleteExpression
                            {
                                adaptor.addChild(root_0,
                                        stream_incompleteExpression.nextTree());
                            }
                            retval.tree = root_0;
                        }
                    }
                        break;
                    case 4:
                    // /Users/luigi/Documents/workspace/Parsers/src/ManchesterOWLSyntaxAutoCompleteCombined.g:71:9:
                    // standaloneExpression
                    {
                        pushFollow(FOLLOW_standaloneExpression_in_main164);
                        standaloneExpression4 = standaloneExpression();
                        state._fsp--;
                        if (state.failed) {
                            return retval;
                        }
                        if (state.backtracking == 0) {
                            stream_standaloneExpression.add(standaloneExpression4
                                    .getTree());
                        }
                        // AST REWRITE
                        // elements: standaloneExpression
                        // token labels:
                        // rule labels: retval
                        // token list labels:
                        // rule list labels:
                        // wildcard labels:
                        if (state.backtracking == 0) {
                            retval.tree = root_0;
                            root_0 = (ManchesterOWLSyntaxTree) adaptor.nil();
                            // 71:30: -> standaloneExpression
                            {
                                adaptor.addChild(root_0,
                                        stream_standaloneExpression.nextTree());
                            }
                            retval.tree = root_0;
                        }
                    }
                        break;
                }
            }
            retval.stop = input.LT(-1);
            if (state.backtracking == 0) {
                retval.tree = (ManchesterOWLSyntaxTree) adaptor
                        .rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        } catch (RecognitionException e) {
            if (errorListener != null) {
                errorListener.recognitionException(e);
            }
        } catch (RewriteEmptyStreamException e) {
            if (errorListener != null) {
                errorListener.rewriteEmptyStreamException(e);
            }
        } finally {}
        return retval;
    }

    // $ANTLR end "main"
    // $ANTLR start synpred1_ManchesterOWLSyntaxAutoCompleteCombined
    public final void synpred1_ManchesterOWLSyntaxAutoCompleteCombined_fragment()
            throws RecognitionException {
        // /Users/luigi/Documents/workspace/Parsers/src/ManchesterOWLSyntaxAutoCompleteCombined.g:68:3:
        // ( axiom )
        // /Users/luigi/Documents/workspace/Parsers/src/ManchesterOWLSyntaxAutoCompleteCombined.g:68:3:
        // axiom
        {
            pushFollow(FOLLOW_axiom_in_synpred1_ManchesterOWLSyntaxAutoCompleteCombined125);
            axiom();
            state._fsp--;
            if (state.failed) {
                return;
            }
        }
    }

    // $ANTLR end synpred1_ManchesterOWLSyntaxAutoCompleteCombined
    // $ANTLR start synpred2_ManchesterOWLSyntaxAutoCompleteCombined
    public final void synpred2_ManchesterOWLSyntaxAutoCompleteCombined_fragment() {
        // /Users/luigi/Documents/workspace/Parsers/src/ManchesterOWLSyntaxAutoCompleteCombined.g:69:5:
        // ( incompleteAxiom )
        // /Users/luigi/Documents/workspace/Parsers/src/ManchesterOWLSyntaxAutoCompleteCombined.g:69:5:
        // incompleteAxiom
        {
            pushFollow(FOLLOW_incompleteAxiom_in_synpred2_ManchesterOWLSyntaxAutoCompleteCombined136);
            incompleteAxiom();
            state._fsp--;
            if (state.failed) {
                return;
            }
        }
    }

    // $ANTLR end synpred2_ManchesterOWLSyntaxAutoCompleteCombined
    // $ANTLR start synpred3_ManchesterOWLSyntaxAutoCompleteCombined
    public final void synpred3_ManchesterOWLSyntaxAutoCompleteCombined_fragment() {
        // /Users/luigi/Documents/workspace/Parsers/src/ManchesterOWLSyntaxAutoCompleteCombined.g:70:5:
        // ( incompleteExpression )
        // /Users/luigi/Documents/workspace/Parsers/src/ManchesterOWLSyntaxAutoCompleteCombined.g:70:5:
        // incompleteExpression
        {
            pushFollow(FOLLOW_incompleteExpression_in_synpred3_ManchesterOWLSyntaxAutoCompleteCombined147);
            incompleteExpression();
            state._fsp--;
            if (state.failed) {
                return;
            }
        }
    }

    // $ANTLR end synpred3_ManchesterOWLSyntaxAutoCompleteCombined
    // Delegated rules
    public
            ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase.incompleteAxiom_return
            incompleteAxiom() {
        return gManchesterOWLSyntaxAutoCompleteBase.incompleteAxiom();
    }

    public
            ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase.incompleteValueRestriction_return
            incompleteValueRestriction() {
        return gManchesterOWLSyntaxAutoCompleteBase.incompleteValueRestriction();
    }

    public
            ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase.incompleteQualifiedRestriction_return
            incompleteQualifiedRestriction() {
        return gManchesterOWLSyntaxAutoCompleteBase.incompleteQualifiedRestriction();
    }

    public
            ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase.incompleteComplexPropertyExpression_return
            incompleteComplexPropertyExpression() {
        return gManchesterOWLSyntaxAutoCompleteBase.incompleteComplexPropertyExpression();
    }

    public
            ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase_MOWLParser.dataRangeFacet_return
            dataRangeFacet() throws RecognitionException {
        return gMOWLParser.dataRangeFacet();
    }

    public
            ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase.incompleteUnary_return
            incompleteUnary() {
        return gManchesterOWLSyntaxAutoCompleteBase.incompleteUnary();
    }

    public
            ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase_MOWLParser.axiom_return
            axiom() throws RecognitionException {
        return gMOWLParser.axiom();
    }

    public
            ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase_MOWLParser.binaryAxiom_return
            binaryAxiom() throws RecognitionException {
        return gMOWLParser.binaryAxiom();
    }

    public
            ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase_MOWLParser.unary_return
            unary() throws RecognitionException {
        return gMOWLParser.unary();
    }

    public
            ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase_MOWLParser.assertionAxiom_return
            assertionAxiom() throws RecognitionException {
        return gMOWLParser.assertionAxiom();
    }

    public
            ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase.incompleteOneOf_return
            incompleteOneOf() {
        return gManchesterOWLSyntaxAutoCompleteBase.incompleteOneOf();
    }

    public
            ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase.incompleteAssertionAxiom_return
            incompleteAssertionAxiom() {
        return gManchesterOWLSyntaxAutoCompleteBase.incompleteAssertionAxiom();
    }

    public
            ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase_MOWLParser.expression_return
            expression() throws RecognitionException {
        return gMOWLParser.expression();
    }

    public
            ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase_MOWLParser.unaryCharacteristic_return
            unaryCharacteristic() throws RecognitionException {
        return gMOWLParser.unaryCharacteristic();
    }

    public
            ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase_MOWLParser.unaryAxiom_return
            unaryAxiom() throws RecognitionException {
        return gMOWLParser.unaryAxiom();
    }

    public
            ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase_MOWLParser.oneOf_return
            oneOf() throws RecognitionException {
        return gMOWLParser.oneOf();
    }

    public
            ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase_MOWLParser.constant_return
            constant() throws RecognitionException {
        return gMOWLParser.constant();
    }

    public
            ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase.incompleteBinaryAxiom_return
            incompleteBinaryAxiom() {
        return gManchesterOWLSyntaxAutoCompleteBase.incompleteBinaryAxiom();
    }

    public
            ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase_MOWLParser.complexPropertyExpression_return
            complexPropertyExpression() throws RecognitionException {
        return gMOWLParser.complexPropertyExpression();
    }

    public
            ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase.incompleteConjunction_return
            incompleteConjunction() {
        return gManchesterOWLSyntaxAutoCompleteBase.incompleteConjunction();
    }

    public
            ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase_MOWLParser.iri_return
            iri() throws RecognitionException {
        return gMOWLParser.iri();
    }

    public
            ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase_MOWLParser.cardinalityRestriction_return
            cardinalityRestriction() throws RecognitionException {
        return gMOWLParser.cardinalityRestriction();
    }

    public
            ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase_MOWLParser.propertyExpression_return
            propertyExpression() throws RecognitionException {
        return gMOWLParser.propertyExpression();
    }

    public
            ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase_MOWLParser.value_return
            value() throws RecognitionException {
        return gMOWLParser.value();
    }

    public
            ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase_MOWLParser.qualifiedRestriction_return
            qualifiedRestriction() throws RecognitionException {
        return gMOWLParser.qualifiedRestriction();
    }

    public
            ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase.incompleteCardinalityRestriction_return
            incompleteCardinalityRestriction() {
        return gManchesterOWLSyntaxAutoCompleteBase.incompleteCardinalityRestriction();
    }

    public
            ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase.incompleteExpression_return
            incompleteExpression() {
        return gManchesterOWLSyntaxAutoCompleteBase.incompleteExpression();
    }

    public
            ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase_MOWLParser.valueRestriction_return
            valueRestriction() throws RecognitionException {
        return gMOWLParser.valueRestriction();
    }

    public
            ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase.standaloneExpression_return
            standaloneExpression() {
        return gManchesterOWLSyntaxAutoCompleteBase.standaloneExpression();
    }

    public
            ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase_MOWLParser.annotationAssertionAxiom_return
            annotationAssertionAxiom() throws RecognitionException {
        return gMOWLParser.annotationAssertionAxiom();
    }

    public
            ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase.incompleteUnaryAxiom_return
            incompleteUnaryAxiom() {
        return gManchesterOWLSyntaxAutoCompleteBase.incompleteUnaryAxiom();
    }

    public
            ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase_MOWLParser.restrictionKind_return
            restrictionKind() throws RecognitionException {
        return gMOWLParser.restrictionKind();
    }

    public
            ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase_MOWLParser.dataRange_return
            dataRange() throws RecognitionException {
        return gMOWLParser.dataRange();
    }

    public
            ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase_MOWLParser.atomic_return
            atomic() throws RecognitionException {
        return gMOWLParser.atomic();
    }

    public
            ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase_MOWLParser.hasKeyAxiom_return
            hasKeyAxiom() throws RecognitionException {
        return gMOWLParser.hasKeyAxiom();
    }

    public
            ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase_MOWLParser.conjunction_return
            conjunction() throws RecognitionException {
        return gMOWLParser.conjunction();
    }

    Logger logger = Logging.getParseLogging();

    public final boolean synpred1_ManchesterOWLSyntaxAutoCompleteCombined() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred1_ManchesterOWLSyntaxAutoCompleteCombined_fragment(); // can
                                                                         // never
                                                                         // throw
                                                                         // exception
        } catch (RecognitionException re) {
            logger.info("impossible: ", re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed = false;
        return success;
    }

    public final boolean synpred2_ManchesterOWLSyntaxAutoCompleteCombined() {
        state.backtracking++;
        int start = input.mark();
        synpred2_ManchesterOWLSyntaxAutoCompleteCombined_fragment();
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed = false;
        return success;
    }

    public final boolean synpred3_ManchesterOWLSyntaxAutoCompleteCombined() {
        state.backtracking++;
        int start = input.mark();
        synpred3_ManchesterOWLSyntaxAutoCompleteCombined_fragment();
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed = false;
        return success;
    }

    protected DFA1 dfa1 = new DFA1(this);
    static final String DFA1_eotS = "\23\uffff";
    static final String DFA1_eofS = "\23\uffff";
    static final String DFA1_minS = "\1\5\16\0\4\uffff";
    static final String DFA1_maxS = "\1\156\16\0\4\uffff";
    static final String DFA1_acceptS = "\17\uffff\1\1\1\2\1\3\1\4";
    static final String DFA1_specialS = "\1\uffff\1\0\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\13\1\14"
            + "\1\15\4\uffff}>";
    static final String[] DFA1_transitionS = {
            "\1\7\1\5\5\uffff\1\4\6\uffff\1\3\11\uffff\1\10\1\12\1\13\1\14"
                    + "\1\15\1\16\1\11\4\uffff\1\6\3\uffff\1\1\1\2\100\uffff\1\17",
            "\1\uffff", "\1\uffff", "\1\uffff", "\1\uffff", "\1\uffff", "\1\uffff",
            "\1\uffff", "\1\uffff", "\1\uffff", "\1\uffff", "\1\uffff", "\1\uffff",
            "\1\uffff", "\1\uffff", "", "", "", "" };
    static final short[] DFA1_eot = DFA.unpackEncodedString(DFA1_eotS);
    static final short[] DFA1_eof = DFA.unpackEncodedString(DFA1_eofS);
    static final char[] DFA1_min = DFA.unpackEncodedStringToUnsignedChars(DFA1_minS);
    static final char[] DFA1_max = DFA.unpackEncodedStringToUnsignedChars(DFA1_maxS);
    static final short[] DFA1_accept = DFA.unpackEncodedString(DFA1_acceptS);
    static final short[] DFA1_special = DFA.unpackEncodedString(DFA1_specialS);
    static final short[][] DFA1_transition;
    static {
        int numStates = DFA1_transitionS.length;
        DFA1_transition = new short[numStates][];
        for (int i = 0; i < numStates; i++) {
            DFA1_transition[i] = DFA.unpackEncodedString(DFA1_transitionS[i]);
        }
    }

    class DFA1 extends DFA {
        public DFA1(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            decisionNumber = 1;
            eot = DFA1_eot;
            eof = DFA1_eof;
            min = DFA1_min;
            max = DFA1_max;
            accept = DFA1_accept;
            special = DFA1_special;
            transition = DFA1_transition;
        }

        @Override
        public String getDescription() {
            return "66:1: ( options {backtrack=true; } : axiom -> axiom | incompleteAxiom -> incompleteAxiom | incompleteExpression -> incompleteExpression | standaloneExpression -> standaloneExpression )";
        }

        @Override
        public int specialStateTransition(int __s, IntStream _input)
                throws NoViableAltException {
            TokenStream in = (TokenStream) _input;
            int s = __s;
            int _s = s;
            switch (s) {
                case 0:
                    in.LA(1);
                    int index1_1 = in.index();
                    in.rewind();
                    s = -1;
                    if (synpred1_ManchesterOWLSyntaxAutoCompleteCombined()) {
                        s = 15;
                    } else if (synpred2_ManchesterOWLSyntaxAutoCompleteCombined()) {
                        s = 16;
                    } else if (synpred3_ManchesterOWLSyntaxAutoCompleteCombined()) {
                        s = 17;
                    } else {
                        s = 18;
                    }
                    in.seek(index1_1);
                    if (s >= 0) {
                        return s;
                    }
                    break;
                case 1:
                    in.LA(1);
                    int index1_2 = in.index();
                    in.rewind();
                    s = -1;
                    if (synpred1_ManchesterOWLSyntaxAutoCompleteCombined()) {
                        s = 15;
                    } else if (synpred2_ManchesterOWLSyntaxAutoCompleteCombined()) {
                        s = 16;
                    } else if (synpred3_ManchesterOWLSyntaxAutoCompleteCombined()) {
                        s = 17;
                    } else {
                        s = 18;
                    }
                    in.seek(index1_2);
                    if (s >= 0) {
                        return s;
                    }
                    break;
                case 2:
                    in.LA(1);
                    int index1_3 = in.index();
                    in.rewind();
                    s = -1;
                    if (synpred1_ManchesterOWLSyntaxAutoCompleteCombined()) {
                        s = 15;
                    } else if (synpred2_ManchesterOWLSyntaxAutoCompleteCombined()) {
                        s = 16;
                    } else if (synpred3_ManchesterOWLSyntaxAutoCompleteCombined()) {
                        s = 17;
                    } else {
                        s = 18;
                    }
                    in.seek(index1_3);
                    if (s >= 0) {
                        return s;
                    }
                    break;
                case 3:
                    in.LA(1);
                    int index1_4 = in.index();
                    in.rewind();
                    s = -1;
                    if (synpred1_ManchesterOWLSyntaxAutoCompleteCombined()) {
                        s = 15;
                    } else if (synpred2_ManchesterOWLSyntaxAutoCompleteCombined()) {
                        s = 16;
                    } else if (synpred3_ManchesterOWLSyntaxAutoCompleteCombined()) {
                        s = 17;
                    } else {
                        s = 18;
                    }
                    in.seek(index1_4);
                    if (s >= 0) {
                        return s;
                    }
                    break;
                case 4:
                    in.LA(1);
                    int index1_5 = in.index();
                    in.rewind();
                    s = -1;
                    if (synpred1_ManchesterOWLSyntaxAutoCompleteCombined()) {
                        s = 15;
                    } else if (synpred2_ManchesterOWLSyntaxAutoCompleteCombined()) {
                        s = 16;
                    } else if (synpred3_ManchesterOWLSyntaxAutoCompleteCombined()) {
                        s = 17;
                    } else {
                        s = 18;
                    }
                    in.seek(index1_5);
                    if (s >= 0) {
                        return s;
                    }
                    break;
                case 5:
                    in.LA(1);
                    int index1_6 = in.index();
                    in.rewind();
                    s = -1;
                    if (synpred1_ManchesterOWLSyntaxAutoCompleteCombined()) {
                        s = 15;
                    } else if (synpred2_ManchesterOWLSyntaxAutoCompleteCombined()) {
                        s = 16;
                    } else if (synpred3_ManchesterOWLSyntaxAutoCompleteCombined()) {
                        s = 17;
                    } else {
                        s = 18;
                    }
                    in.seek(index1_6);
                    if (s >= 0) {
                        return s;
                    }
                    break;
                case 6:
                    in.LA(1);
                    int index1_7 = in.index();
                    in.rewind();
                    s = -1;
                    if (synpred1_ManchesterOWLSyntaxAutoCompleteCombined()) {
                        s = 15;
                    } else if (synpred2_ManchesterOWLSyntaxAutoCompleteCombined()) {
                        s = 16;
                    } else if (synpred3_ManchesterOWLSyntaxAutoCompleteCombined()) {
                        s = 17;
                    } else {
                        s = 18;
                    }
                    in.seek(index1_7);
                    if (s >= 0) {
                        return s;
                    }
                    break;
                case 7:
                    in.LA(1);
                    int index1_8 = in.index();
                    in.rewind();
                    s = -1;
                    if (synpred1_ManchesterOWLSyntaxAutoCompleteCombined()) {
                        s = 15;
                    } else if (synpred2_ManchesterOWLSyntaxAutoCompleteCombined()) {
                        s = 16;
                    }
                    in.seek(index1_8);
                    if (s >= 0) {
                        return s;
                    }
                    break;
                case 8:
                    in.LA(1);
                    int index1_9 = in.index();
                    in.rewind();
                    s = -1;
                    if (synpred1_ManchesterOWLSyntaxAutoCompleteCombined()) {
                        s = 15;
                    } else if (synpred2_ManchesterOWLSyntaxAutoCompleteCombined()) {
                        s = 16;
                    }
                    in.seek(index1_9);
                    if (s >= 0) {
                        return s;
                    }
                    break;
                case 9:
                    in.LA(1);
                    int index1_10 = in.index();
                    in.rewind();
                    s = -1;
                    if (synpred1_ManchesterOWLSyntaxAutoCompleteCombined()) {
                        s = 15;
                    } else if (synpred2_ManchesterOWLSyntaxAutoCompleteCombined()) {
                        s = 16;
                    }
                    in.seek(index1_10);
                    if (s >= 0) {
                        return s;
                    }
                    break;
                case 10:
                    in.LA(1);
                    int index1_11 = in.index();
                    in.rewind();
                    s = -1;
                    if (synpred1_ManchesterOWLSyntaxAutoCompleteCombined()) {
                        s = 15;
                    } else if (synpred2_ManchesterOWLSyntaxAutoCompleteCombined()) {
                        s = 16;
                    }
                    in.seek(index1_11);
                    if (s >= 0) {
                        return s;
                    }
                    break;
                case 11:
                    in.LA(1);
                    int index1_12 = in.index();
                    in.rewind();
                    s = -1;
                    if (synpred1_ManchesterOWLSyntaxAutoCompleteCombined()) {
                        s = 15;
                    } else if (synpred2_ManchesterOWLSyntaxAutoCompleteCombined()) {
                        s = 16;
                    }
                    in.seek(index1_12);
                    if (s >= 0) {
                        return s;
                    }
                    break;
                case 12:
                    in.LA(1);
                    int index1_13 = in.index();
                    in.rewind();
                    s = -1;
                    if (synpred1_ManchesterOWLSyntaxAutoCompleteCombined()) {
                        s = 15;
                    } else if (synpred2_ManchesterOWLSyntaxAutoCompleteCombined()) {
                        s = 16;
                    }
                    in.seek(index1_13);
                    if (s >= 0) {
                        return s;
                    }
                    break;
                case 13:
                    in.LA(1);
                    int index1_14 = in.index();
                    in.rewind();
                    s = -1;
                    if (synpred1_ManchesterOWLSyntaxAutoCompleteCombined()) {
                        s = 15;
                    } else if (synpred2_ManchesterOWLSyntaxAutoCompleteCombined()) {
                        s = 16;
                    }
                    in.seek(index1_14);
                    if (s >= 0) {
                        return s;
                    }
                    break;
            }
            if (state.backtracking > 0) {
                state.failed = true;
                return -1;
            }
            NoViableAltException nvae = new NoViableAltException(getDescription(), 1, _s,
                    in);
            error(nvae);
            throw nvae;
        }
    }

    public static final BitSet FOLLOW_axiom_in_main125 = new BitSet(
            new long[] { 0x0000000000000002L });
    public static final BitSet FOLLOW_incompleteAxiom_in_main136 = new BitSet(
            new long[] { 0x0000000000000002L });
    public static final BitSet FOLLOW_incompleteExpression_in_main147 = new BitSet(
            new long[] { 0x0000000000000002L });
    public static final BitSet FOLLOW_standaloneExpression_in_main164 = new BitSet(
            new long[] { 0x0000000000000002L });
    public static final BitSet FOLLOW_axiom_in_synpred1_ManchesterOWLSyntaxAutoCompleteCombined125 = new BitSet(
            new long[] { 0x0000000000000002L });
    public static final BitSet FOLLOW_incompleteAxiom_in_synpred2_ManchesterOWLSyntaxAutoCompleteCombined136 = new BitSet(
            new long[] { 0x0000000000000002L });
    public static final BitSet FOLLOW_incompleteExpression_in_synpred3_ManchesterOWLSyntaxAutoCompleteCombined147 = new BitSet(
            new long[] { 0x0000000000000002L });
}
