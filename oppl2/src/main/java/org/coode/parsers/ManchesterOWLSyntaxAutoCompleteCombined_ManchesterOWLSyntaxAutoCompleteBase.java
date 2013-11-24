// $ANTLR 3.2 Sep 23, 2009 12:02:23 ManchesterOWLSyntaxAutoCompleteBase.g 2011-01-10 16:18:12
package org.coode.parsers;

import java.util.ArrayList;
import java.util.List;

import org.antlr.runtime.BaseRecognizer;
import org.antlr.runtime.BitSet;
import org.antlr.runtime.DFA;
import org.antlr.runtime.EarlyExitException;
import org.antlr.runtime.IntStream;
import org.antlr.runtime.NoViableAltException;
import org.antlr.runtime.Parser;
import org.antlr.runtime.ParserRuleReturnScope;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.RecognizerSharedState;
import org.antlr.runtime.RuleReturnScope;
import org.antlr.runtime.Token;
import org.antlr.runtime.TokenStream;
import org.antlr.runtime.tree.CommonTreeAdaptor;
import org.antlr.runtime.tree.RewriteEarlyExitException;
import org.antlr.runtime.tree.RewriteRuleSubtreeStream;
import org.antlr.runtime.tree.RewriteRuleTokenStream;
import org.antlr.runtime.tree.TreeAdaptor;
import org.coode.oppl.log.Logger;
import org.coode.oppl.log.Logging;

@SuppressWarnings({ "javadoc", "incomplete-switch" })
public class ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase
        extends Parser {
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
    // delegators
    public ManchesterOWLSyntaxAutoCompleteCombinedParser gManchesterOWLSyntaxAutoCompleteCombined;
    public ManchesterOWLSyntaxAutoCompleteCombinedParser gParent;

    public ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase(
            TokenStream input,
            ManchesterOWLSyntaxAutoCompleteCombinedParser gManchesterOWLSyntaxAutoCompleteCombined) {
        this(input, new RecognizerSharedState(), gManchesterOWLSyntaxAutoCompleteCombined);
    }

    public ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase(
            TokenStream input,
            RecognizerSharedState state,
            ManchesterOWLSyntaxAutoCompleteCombinedParser gManchesterOWLSyntaxAutoCompleteCombined) {
        super(input, state);
        this.gManchesterOWLSyntaxAutoCompleteCombined = gManchesterOWLSyntaxAutoCompleteCombined;
        gMOWLParser = new ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase_MOWLParser(
                input, state, gManchesterOWLSyntaxAutoCompleteCombined, this);
        gParent = gManchesterOWLSyntaxAutoCompleteCombined;
    }

    protected TreeAdaptor adaptor = new CommonTreeAdaptor();

    public void setTreeAdaptor(TreeAdaptor adaptor) {
        this.adaptor = adaptor;
        gMOWLParser.setTreeAdaptor(this.adaptor);
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
        return "ManchesterOWLSyntaxAutoCompleteBase.g";
    }

    public static class standaloneExpression_return extends ParserRuleReturnScope {
        ManchesterOWLSyntaxTree tree;

        @Override
        public Object getTree() {
            return tree;
        }
    }

    // $ANTLR start "standaloneExpression"
    // ManchesterOWLSyntaxAutoCompleteBase.g:43:1: standaloneExpression : exp=
    // expression -> ^( STANDALONE_EXPRESSION ^( EXPRESSION $exp) ) ;
    public final
            ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase.standaloneExpression_return
            standaloneExpression() {
        ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase.standaloneExpression_return retval = new ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase.standaloneExpression_return();
        retval.start = input.LT(1);
        ManchesterOWLSyntaxTree root_0 = null;
        ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase_MOWLParser.expression_return exp = null;
        RewriteRuleSubtreeStream stream_expression = new RewriteRuleSubtreeStream(
                adaptor, "rule expression");
        try {
            // ManchesterOWLSyntaxAutoCompleteBase.g:44:2: (exp= expression ->
            // ^( STANDALONE_EXPRESSION ^( EXPRESSION $exp) ) )
            // ManchesterOWLSyntaxAutoCompleteBase.g:45:5: exp= expression
            {
                pushFollow(FOLLOW_expression_in_standaloneExpression190);
                exp = gManchesterOWLSyntaxAutoCompleteCombined.expression();
                state._fsp--;
                if (state.failed) {
                    return retval;
                }
                if (state.backtracking == 0) {
                    stream_expression.add(exp.getTree());
                }
                // AST REWRITE
                // elements: exp
                // token labels:
                // rule labels: exp, retval
                // token list labels:
                // rule list labels:
                // wildcard labels:
                if (state.backtracking == 0) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_exp = new RewriteRuleSubtreeStream(
                            adaptor, "rule exp", exp != null ? exp.tree : null);
                    root_0 = (ManchesterOWLSyntaxTree) adaptor.nil();
                    // 45:22: -> ^( STANDALONE_EXPRESSION ^( EXPRESSION $exp) )
                    {
                        // ManchesterOWLSyntaxAutoCompleteBase.g:45:25: ^(
                        // STANDALONE_EXPRESSION ^( EXPRESSION $exp) )
                        {
                            ManchesterOWLSyntaxTree root_1 = (ManchesterOWLSyntaxTree) adaptor
                                    .nil();
                            root_1 = (ManchesterOWLSyntaxTree) adaptor.becomeRoot(adaptor
                                    .create(STANDALONE_EXPRESSION,
                                            "STANDALONE_EXPRESSION"), root_1);
                            // ManchesterOWLSyntaxAutoCompleteBase.g:45:50: ^(
                            // EXPRESSION $exp)
                            {
                                ManchesterOWLSyntaxTree root_2 = (ManchesterOWLSyntaxTree) adaptor
                                        .nil();
                                root_2 = (ManchesterOWLSyntaxTree) adaptor.becomeRoot(
                                        adaptor.create(EXPRESSION, "EXPRESSION"), root_2);
                                adaptor.addChild(root_2, stream_exp.nextTree());
                                adaptor.addChild(root_1, root_2);
                            }
                            adaptor.addChild(root_0, root_1);
                        }
                    }
                    retval.tree = root_0;
                }
            }
            retval.stop = input.LT(-1);
            if (state.backtracking == 0) {
                retval.tree = (ManchesterOWLSyntaxTree) adaptor
                        .rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        } catch (RecognitionException re) {
            reportError(re);
            recover(input, re);
            retval.tree = (ManchesterOWLSyntaxTree) adaptor.errorNode(input,
                    retval.start, input.LT(-1), re);
        } finally {}
        return retval;
    }

    // $ANTLR end "standaloneExpression"
    public static class incompleteAxiom_return extends ParserRuleReturnScope {
        ManchesterOWLSyntaxTree tree;

        @Override
        public Object getTree() {
            return tree;
        }
    }

    // $ANTLR start "incompleteAxiom"
    // ManchesterOWLSyntaxAutoCompleteBase.g:49:1: incompleteAxiom : (
    // incompleteBinaryAxiom -> ^( incompleteBinaryAxiom ) |
    // incompleteUnaryAxiom -> ^( incompleteUnaryAxiom ) |
    // incompleteAssertionAxiom -> ^( incompleteAssertionAxiom ) );
    public final
            ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase.incompleteAxiom_return
            incompleteAxiom() {
        ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase.incompleteAxiom_return retval = new ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase.incompleteAxiom_return();
        retval.start = input.LT(1);
        ManchesterOWLSyntaxTree root_0 = null;
        ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase.incompleteBinaryAxiom_return incompleteBinaryAxiom1 = null;
        ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase.incompleteUnaryAxiom_return incompleteUnaryAxiom2 = null;
        ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase.incompleteAssertionAxiom_return incompleteAssertionAxiom3 = null;
        RewriteRuleSubtreeStream stream_incompleteAssertionAxiom = new RewriteRuleSubtreeStream(
                adaptor, "rule incompleteAssertionAxiom");
        RewriteRuleSubtreeStream stream_incompleteUnaryAxiom = new RewriteRuleSubtreeStream(
                adaptor, "rule incompleteUnaryAxiom");
        RewriteRuleSubtreeStream stream_incompleteBinaryAxiom = new RewriteRuleSubtreeStream(
                adaptor, "rule incompleteBinaryAxiom");
        try {
            // ManchesterOWLSyntaxAutoCompleteBase.g:49:17: (
            // incompleteBinaryAxiom -> ^( incompleteBinaryAxiom ) |
            // incompleteUnaryAxiom -> ^( incompleteUnaryAxiom ) |
            // incompleteAssertionAxiom -> ^( incompleteAssertionAxiom ) )
            int alt1 = 3;
            switch (input.LA(1)) {
                case IDENTIFIER: {
                    int LA1_1 = input.LA(2);
                    if (LA1_1 == COMPOSITION || LA1_1 >= AND && LA1_1 <= OR
                            || LA1_1 >= SOME && LA1_1 <= VALUE || LA1_1 >= SUBCLASS_OF
                            && LA1_1 <= RANGE || LA1_1 == OPEN_SQUARE_BRACKET) {
                        alt1 = 1;
                    } else if (LA1_1 >= INSTANCE_OF && LA1_1 <= TYPES) {
                        alt1 = 3;
                    } else {
                        if (state.backtracking > 0) {
                            state.failed = true;
                            return retval;
                        }
                        NoViableAltException nvae = new NoViableAltException("", 1, 1,
                                input);
                        throw nvae;
                    }
                }
                    break;
                case OPEN_PARENTHESYS:
                case OPEN_CURLY_BRACES:
                case NOT:
                case INVERSE:
                case DBLQUOTE:
                case ENTITY_REFERENCE: {
                    alt1 = 1;
                }
                    break;
                case FUNCTIONAL:
                case SYMMETRIC:
                case ANTI_SYMMETRIC:
                case REFLEXIVE:
                case IRREFLEXIVE:
                case TRANSITIVE:
                case INVERSE_FUNCTIONAL: {
                    alt1 = 2;
                }
                    break;
                default:
                    if (state.backtracking > 0) {
                        state.failed = true;
                        return retval;
                    }
                    NoViableAltException nvae = new NoViableAltException("", 1, 0, input);
                    throw nvae;
            }
            switch (alt1) {
                case 1:
                // ManchesterOWLSyntaxAutoCompleteBase.g:50:5:
                // incompleteBinaryAxiom
                {
                    pushFollow(FOLLOW_incompleteBinaryAxiom_in_incompleteAxiom219);
                    incompleteBinaryAxiom1 = incompleteBinaryAxiom();
                    state._fsp--;
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        stream_incompleteBinaryAxiom
                                .add(incompleteBinaryAxiom1.getTree());
                    }
                    // AST REWRITE
                    // elements: incompleteBinaryAxiom
                    // token labels:
                    // rule labels: retval
                    // token list labels:
                    // rule list labels:
                    // wildcard labels:
                    if (state.backtracking == 0) {
                        retval.tree = root_0;
                        root_0 = (ManchesterOWLSyntaxTree) adaptor.nil();
                        // 50:27: -> ^( incompleteBinaryAxiom )
                        {
                            // ManchesterOWLSyntaxAutoCompleteBase.g:50:30: ^(
                            // incompleteBinaryAxiom )
                            {
                                ManchesterOWLSyntaxTree root_1 = (ManchesterOWLSyntaxTree) adaptor
                                        .nil();
                                root_1 = (ManchesterOWLSyntaxTree) adaptor.becomeRoot(
                                        stream_incompleteBinaryAxiom.nextNode(), root_1);
                                adaptor.addChild(root_0, root_1);
                            }
                        }
                        retval.tree = root_0;
                    }
                }
                    break;
                case 2:
                // ManchesterOWLSyntaxAutoCompleteBase.g:51:7:
                // incompleteUnaryAxiom
                {
                    pushFollow(FOLLOW_incompleteUnaryAxiom_in_incompleteAxiom233);
                    incompleteUnaryAxiom2 = incompleteUnaryAxiom();
                    state._fsp--;
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        stream_incompleteUnaryAxiom.add(incompleteUnaryAxiom2.getTree());
                    }
                    // AST REWRITE
                    // elements: incompleteUnaryAxiom
                    // token labels:
                    // rule labels: retval
                    // token list labels:
                    // rule list labels:
                    // wildcard labels:
                    if (state.backtracking == 0) {
                        retval.tree = root_0;
                        root_0 = (ManchesterOWLSyntaxTree) adaptor.nil();
                        // 51:30: -> ^( incompleteUnaryAxiom )
                        {
                            // ManchesterOWLSyntaxAutoCompleteBase.g:51:33: ^(
                            // incompleteUnaryAxiom )
                            {
                                ManchesterOWLSyntaxTree root_1 = (ManchesterOWLSyntaxTree) adaptor
                                        .nil();
                                root_1 = (ManchesterOWLSyntaxTree) adaptor.becomeRoot(
                                        stream_incompleteUnaryAxiom.nextNode(), root_1);
                                adaptor.addChild(root_0, root_1);
                            }
                        }
                        retval.tree = root_0;
                    }
                }
                    break;
                case 3:
                // ManchesterOWLSyntaxAutoCompleteBase.g:52:7:
                // incompleteAssertionAxiom
                {
                    pushFollow(FOLLOW_incompleteAssertionAxiom_in_incompleteAxiom249);
                    incompleteAssertionAxiom3 = incompleteAssertionAxiom();
                    state._fsp--;
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        stream_incompleteAssertionAxiom.add(incompleteAssertionAxiom3
                                .getTree());
                    }
                    // AST REWRITE
                    // elements: incompleteAssertionAxiom
                    // token labels:
                    // rule labels: retval
                    // token list labels:
                    // rule list labels:
                    // wildcard labels:
                    if (state.backtracking == 0) {
                        retval.tree = root_0;
                        root_0 = (ManchesterOWLSyntaxTree) adaptor.nil();
                        // 52:32: -> ^( incompleteAssertionAxiom )
                        {
                            // ManchesterOWLSyntaxAutoCompleteBase.g:52:35: ^(
                            // incompleteAssertionAxiom )
                            {
                                ManchesterOWLSyntaxTree root_1 = (ManchesterOWLSyntaxTree) adaptor
                                        .nil();
                                root_1 = (ManchesterOWLSyntaxTree) adaptor.becomeRoot(
                                        stream_incompleteAssertionAxiom.nextNode(),
                                        root_1);
                                adaptor.addChild(root_0, root_1);
                            }
                        }
                        retval.tree = root_0;
                    }
                }
                    break;
            }
            retval.stop = input.LT(-1);
            if (state.backtracking == 0) {
                retval.tree = (ManchesterOWLSyntaxTree) adaptor
                        .rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        } catch (RecognitionException re) {
            reportError(re);
            recover(input, re);
            retval.tree = (ManchesterOWLSyntaxTree) adaptor.errorNode(input,
                    retval.start, input.LT(-1), re);
        } finally {}
        return retval;
    }

    // $ANTLR end "incompleteAxiom"
    public static class incompleteAssertionAxiom_return extends ParserRuleReturnScope {
        ManchesterOWLSyntaxTree tree;

        @Override
        public Object getTree() {
            return tree;
        }
    }

    // $ANTLR start "incompleteAssertionAxiom"
    // ManchesterOWLSyntaxAutoCompleteBase.g:55:1: incompleteAssertionAxiom : i=
    // IDENTIFIER ( INSTANCE_OF | TYPES ) -> ^( INCOMPLETE_TYPE_ASSERTION ^(
    // EXPRESSION $i) ) ;
    public final
            ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase.incompleteAssertionAxiom_return
            incompleteAssertionAxiom() {
        ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase.incompleteAssertionAxiom_return retval = new ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase.incompleteAssertionAxiom_return();
        retval.start = input.LT(1);
        ManchesterOWLSyntaxTree root_0 = null;
        Token i = null;
        Token INSTANCE_OF4 = null;
        Token TYPES5 = null;
        RewriteRuleTokenStream stream_TYPES = new RewriteRuleTokenStream(adaptor,
                "token TYPES");
        RewriteRuleTokenStream stream_IDENTIFIER = new RewriteRuleTokenStream(adaptor,
                "token IDENTIFIER");
        RewriteRuleTokenStream stream_INSTANCE_OF = new RewriteRuleTokenStream(adaptor,
                "token INSTANCE_OF");
        try {
            // ManchesterOWLSyntaxAutoCompleteBase.g:55:27: (i= IDENTIFIER (
            // INSTANCE_OF | TYPES ) -> ^( INCOMPLETE_TYPE_ASSERTION ^(
            // EXPRESSION $i) ) )
            // ManchesterOWLSyntaxAutoCompleteBase.g:56:3: i= IDENTIFIER (
            // INSTANCE_OF | TYPES )
            {
                i = (Token) match(input, IDENTIFIER,
                        FOLLOW_IDENTIFIER_in_incompleteAssertionAxiom273);
                if (state.failed) {
                    return retval;
                }
                if (state.backtracking == 0) {
                    stream_IDENTIFIER.add(i);
                }
                // ManchesterOWLSyntaxAutoCompleteBase.g:56:18: ( INSTANCE_OF |
                // TYPES )
                int alt2 = 2;
                int LA2_0 = input.LA(1);
                if (LA2_0 == INSTANCE_OF) {
                    alt2 = 1;
                } else if (LA2_0 == TYPES) {
                    alt2 = 2;
                } else {
                    if (state.backtracking > 0) {
                        state.failed = true;
                        return retval;
                    }
                    NoViableAltException nvae = new NoViableAltException("", 2, 0, input);
                    throw nvae;
                }
                switch (alt2) {
                    case 1:
                    // ManchesterOWLSyntaxAutoCompleteBase.g:56:19: INSTANCE_OF
                    {
                        INSTANCE_OF4 = (Token) match(input, INSTANCE_OF,
                                FOLLOW_INSTANCE_OF_in_incompleteAssertionAxiom276);
                        if (state.failed) {
                            return retval;
                        }
                        if (state.backtracking == 0) {
                            stream_INSTANCE_OF.add(INSTANCE_OF4);
                        }
                    }
                        break;
                    case 2:
                    // ManchesterOWLSyntaxAutoCompleteBase.g:56:33: TYPES
                    {
                        TYPES5 = (Token) match(input, TYPES,
                                FOLLOW_TYPES_in_incompleteAssertionAxiom280);
                        if (state.failed) {
                            return retval;
                        }
                        if (state.backtracking == 0) {
                            stream_TYPES.add(TYPES5);
                        }
                    }
                        break;
                }
                // AST REWRITE
                // elements: i
                // token labels: i
                // rule labels: retval
                // token list labels:
                // rule list labels:
                // wildcard labels:
                if (state.backtracking == 0) {
                    retval.tree = root_0;
                    RewriteRuleTokenStream stream_i = new RewriteRuleTokenStream(adaptor,
                            "token i", i);
                    root_0 = (ManchesterOWLSyntaxTree) adaptor.nil();
                    // 56:41: -> ^( INCOMPLETE_TYPE_ASSERTION ^( EXPRESSION $i)
                    // )
                    {
                        // ManchesterOWLSyntaxAutoCompleteBase.g:56:44: ^(
                        // INCOMPLETE_TYPE_ASSERTION ^( EXPRESSION $i) )
                        {
                            ManchesterOWLSyntaxTree root_1 = (ManchesterOWLSyntaxTree) adaptor
                                    .nil();
                            root_1 = (ManchesterOWLSyntaxTree) adaptor.becomeRoot(adaptor
                                    .create(INCOMPLETE_TYPE_ASSERTION,
                                            "INCOMPLETE_TYPE_ASSERTION"), root_1);
                            // ManchesterOWLSyntaxAutoCompleteBase.g:56:73: ^(
                            // EXPRESSION $i)
                            {
                                ManchesterOWLSyntaxTree root_2 = (ManchesterOWLSyntaxTree) adaptor
                                        .nil();
                                root_2 = (ManchesterOWLSyntaxTree) adaptor.becomeRoot(
                                        adaptor.create(EXPRESSION, "EXPRESSION"), root_2);
                                adaptor.addChild(root_2, stream_i.nextNode());
                                adaptor.addChild(root_1, root_2);
                            }
                            adaptor.addChild(root_0, root_1);
                        }
                    }
                    retval.tree = root_0;
                }
            }
            retval.stop = input.LT(-1);
            if (state.backtracking == 0) {
                retval.tree = (ManchesterOWLSyntaxTree) adaptor
                        .rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        } catch (RecognitionException re) {
            reportError(re);
            recover(input, re);
            retval.tree = (ManchesterOWLSyntaxTree) adaptor.errorNode(input,
                    retval.start, input.LT(-1), re);
        } finally {}
        return retval;
    }

    // $ANTLR end "incompleteAssertionAxiom"
    public static class incompleteUnaryAxiom_return extends ParserRuleReturnScope {
        ManchesterOWLSyntaxTree tree;

        @Override
        public Object getTree() {
            return tree;
        }
    }

    // $ANTLR start "incompleteUnaryAxiom"
    // ManchesterOWLSyntaxAutoCompleteBase.g:60:1: incompleteUnaryAxiom :
    // unaryCharacteristic -> ^( INCOMPLETE_UNARY_AXIOM unaryCharacteristic ) ;
    public final
            ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase.incompleteUnaryAxiom_return
            incompleteUnaryAxiom() {
        ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase.incompleteUnaryAxiom_return retval = new ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase.incompleteUnaryAxiom_return();
        retval.start = input.LT(1);
        ManchesterOWLSyntaxTree root_0 = null;
        ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase_MOWLParser.unaryCharacteristic_return unaryCharacteristic6 = null;
        RewriteRuleSubtreeStream stream_unaryCharacteristic = new RewriteRuleSubtreeStream(
                adaptor, "rule unaryCharacteristic");
        try {
            // ManchesterOWLSyntaxAutoCompleteBase.g:60:23: (
            // unaryCharacteristic -> ^( INCOMPLETE_UNARY_AXIOM
            // unaryCharacteristic ) )
            // ManchesterOWLSyntaxAutoCompleteBase.g:61:4: unaryCharacteristic
            {
                pushFollow(FOLLOW_unaryCharacteristic_in_incompleteUnaryAxiom318);
                unaryCharacteristic6 = gManchesterOWLSyntaxAutoCompleteCombined
                        .unaryCharacteristic();
                state._fsp--;
                if (state.failed) {
                    return retval;
                }
                if (state.backtracking == 0) {
                    stream_unaryCharacteristic.add(unaryCharacteristic6.getTree());
                }
                // AST REWRITE
                // elements: unaryCharacteristic
                // token labels:
                // rule labels: retval
                // token list labels:
                // rule list labels:
                // wildcard labels:
                if (state.backtracking == 0) {
                    retval.tree = root_0;
                    root_0 = (ManchesterOWLSyntaxTree) adaptor.nil();
                    // 61:25: -> ^( INCOMPLETE_UNARY_AXIOM unaryCharacteristic )
                    {
                        // ManchesterOWLSyntaxAutoCompleteBase.g:61:28: ^(
                        // INCOMPLETE_UNARY_AXIOM unaryCharacteristic )
                        {
                            ManchesterOWLSyntaxTree root_1 = (ManchesterOWLSyntaxTree) adaptor
                                    .nil();
                            root_1 = (ManchesterOWLSyntaxTree) adaptor.becomeRoot(adaptor
                                    .create(INCOMPLETE_UNARY_AXIOM,
                                            "INCOMPLETE_UNARY_AXIOM"), root_1);
                            adaptor.addChild(root_1,
                                    stream_unaryCharacteristic.nextTree());
                            adaptor.addChild(root_0, root_1);
                        }
                    }
                    retval.tree = root_0;
                }
            }
            retval.stop = input.LT(-1);
            if (state.backtracking == 0) {
                retval.tree = (ManchesterOWLSyntaxTree) adaptor
                        .rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        } catch (RecognitionException re) {
            reportError(re);
            recover(input, re);
            retval.tree = (ManchesterOWLSyntaxTree) adaptor.errorNode(input,
                    retval.start, input.LT(-1), re);
        } finally {}
        return retval;
    }

    // $ANTLR end "incompleteUnaryAxiom"
    public static class incompleteBinaryAxiom_return extends ParserRuleReturnScope {
        ManchesterOWLSyntaxTree tree;

        @Override
        public Object getTree() {
            return tree;
        }
    }

    // $ANTLR start "incompleteBinaryAxiom"
    // ManchesterOWLSyntaxAutoCompleteBase.g:65:1: incompleteBinaryAxiom : (lhs=
    // expression ( SUBCLASS_OF -> ^( INCOMPLETE_SUB_CLASS_AXIOM ^( EXPRESSION
    // $lhs) ) | SUBCLASS_OF superClass= incompleteExpression -> ^(
    // INCOMPLETE_SUB_CLASS_AXIOM ^( EXPRESSION $lhs) ^( INCOMPLETE_EXPRESSION
    // $superClass) ) | EQUIVALENT_TO -> ^( INCOMPLETE_EQUIVALENT_TO_AXIOM ^(
    // EXPRESSION $lhs) ) | EQUIVALENT_TO rhs= incompleteExpression -> ^(
    // EQUIVALENT_TO_AXIOM ^( EXPRESSION $lhs) ^( INCOMPLETE_EXPRESSION $rhs) )
    // | DISJOINT_WITH -> ^( INCOMPLETE_DISJOINT_WITH_AXIOM ^( EXPRESSION $lhs)
    // ) | DISJOINT_WITH disjoint= incompleteExpression -> ^(
    // DISJOINT_WITH_AXIOM ^( EXPRESSION $lhs) ^( INCOMPLETE_EXPRESSION
    // $disjoint) ) | SUB_PROPERTY_OF -> ^( INCOMPLETE_SUB_PROPERTY_AXIOM ^(
    // EXPRESSION $lhs) ) ) | lhsID= IDENTIFIER ( SAME_AS -> ^(
    // INCOMPLETE_SAME_AS_AXIOM ^( EXPRESSION $lhsID) ) | DIFFERENT_FROM -> ^(
    // INCOMPLETE_DIFFERENT_FROM_AXIOM ^( EXPRESSION $lhsID) ) | DOMAIN -> ^(
    // INCOMPLETE_DOMAIN ^( EXPRESSION $lhsID) ) | DOMAIN incompleteDomain=
    // incompleteExpression -> ^( INCOMPLETE_DOMAIN ^( EXPRESSION $lhsID) ^(
    // INCOMPLETE_EXPRESSION $incompleteDomain) ) | RANGE -> ^( INCOMPLETE_RANGE
    // ^( EXPRESSION $lhsID) ) | RANGE incompleteRange= incompleteExpression ->
    // ^( INCOMPLETE_RANGE ^( EXPRESSION $lhsID) ^( INCOMPLETE_EXPRESSION
    // $incompleteRange) ) | INVERSE_OF -> ^( INCOMPLETE_INVERSE_OF ^(
    // EXPRESSION $lhsID) ) ) );
    public final
            ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase.incompleteBinaryAxiom_return
            incompleteBinaryAxiom() {
        ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase.incompleteBinaryAxiom_return retval = new ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase.incompleteBinaryAxiom_return();
        retval.start = input.LT(1);
        ManchesterOWLSyntaxTree root_0 = null;
        Token lhsID = null;
        Token SUBCLASS_OF7 = null;
        Token SUBCLASS_OF8 = null;
        Token EQUIVALENT_TO9 = null;
        Token EQUIVALENT_TO10 = null;
        Token DISJOINT_WITH11 = null;
        Token DISJOINT_WITH12 = null;
        Token SUB_PROPERTY_OF13 = null;
        Token SAME_AS14 = null;
        Token DIFFERENT_FROM15 = null;
        Token DOMAIN16 = null;
        Token DOMAIN17 = null;
        Token RANGE18 = null;
        Token RANGE19 = null;
        Token INVERSE_OF20 = null;
        ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase_MOWLParser.expression_return lhs = null;
        ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase.incompleteExpression_return superClass = null;
        ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase.incompleteExpression_return rhs = null;
        ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase.incompleteExpression_return disjoint = null;
        ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase.incompleteExpression_return incompleteDomain = null;
        ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase.incompleteExpression_return incompleteRange = null;
        RewriteRuleTokenStream stream_RANGE = new RewriteRuleTokenStream(adaptor,
                "token RANGE");
        RewriteRuleTokenStream stream_DISJOINT_WITH = new RewriteRuleTokenStream(adaptor,
                "token DISJOINT_WITH");
        RewriteRuleTokenStream stream_SAME_AS = new RewriteRuleTokenStream(adaptor,
                "token SAME_AS");
        RewriteRuleTokenStream stream_IDENTIFIER = new RewriteRuleTokenStream(adaptor,
                "token IDENTIFIER");
        RewriteRuleTokenStream stream_SUBCLASS_OF = new RewriteRuleTokenStream(adaptor,
                "token SUBCLASS_OF");
        RewriteRuleTokenStream stream_DIFFERENT_FROM = new RewriteRuleTokenStream(
                adaptor, "token DIFFERENT_FROM");
        RewriteRuleTokenStream stream_INVERSE_OF = new RewriteRuleTokenStream(adaptor,
                "token INVERSE_OF");
        RewriteRuleTokenStream stream_EQUIVALENT_TO = new RewriteRuleTokenStream(adaptor,
                "token EQUIVALENT_TO");
        RewriteRuleTokenStream stream_DOMAIN = new RewriteRuleTokenStream(adaptor,
                "token DOMAIN");
        RewriteRuleTokenStream stream_SUB_PROPERTY_OF = new RewriteRuleTokenStream(
                adaptor, "token SUB_PROPERTY_OF");
        RewriteRuleSubtreeStream stream_incompleteExpression = new RewriteRuleSubtreeStream(
                adaptor, "rule incompleteExpression");
        RewriteRuleSubtreeStream stream_expression = new RewriteRuleSubtreeStream(
                adaptor, "rule expression");
        try {
            // ManchesterOWLSyntaxAutoCompleteBase.g:65:23: (lhs= expression (
            // SUBCLASS_OF -> ^( INCOMPLETE_SUB_CLASS_AXIOM ^( EXPRESSION $lhs)
            // ) | SUBCLASS_OF superClass= incompleteExpression -> ^(
            // INCOMPLETE_SUB_CLASS_AXIOM ^( EXPRESSION $lhs) ^(
            // INCOMPLETE_EXPRESSION $superClass) ) | EQUIVALENT_TO -> ^(
            // INCOMPLETE_EQUIVALENT_TO_AXIOM ^( EXPRESSION $lhs) ) |
            // EQUIVALENT_TO rhs= incompleteExpression -> ^( EQUIVALENT_TO_AXIOM
            // ^( EXPRESSION $lhs) ^( INCOMPLETE_EXPRESSION $rhs) ) |
            // DISJOINT_WITH -> ^( INCOMPLETE_DISJOINT_WITH_AXIOM ^( EXPRESSION
            // $lhs) ) | DISJOINT_WITH disjoint= incompleteExpression -> ^(
            // DISJOINT_WITH_AXIOM ^( EXPRESSION $lhs) ^( INCOMPLETE_EXPRESSION
            // $disjoint) ) | SUB_PROPERTY_OF -> ^(
            // INCOMPLETE_SUB_PROPERTY_AXIOM ^( EXPRESSION $lhs) ) ) | lhsID=
            // IDENTIFIER ( SAME_AS -> ^( INCOMPLETE_SAME_AS_AXIOM ^( EXPRESSION
            // $lhsID) ) | DIFFERENT_FROM -> ^( INCOMPLETE_DIFFERENT_FROM_AXIOM
            // ^( EXPRESSION $lhsID) ) | DOMAIN -> ^( INCOMPLETE_DOMAIN ^(
            // EXPRESSION $lhsID) ) | DOMAIN incompleteDomain=
            // incompleteExpression -> ^( INCOMPLETE_DOMAIN ^( EXPRESSION
            // $lhsID) ^( INCOMPLETE_EXPRESSION $incompleteDomain) ) | RANGE ->
            // ^( INCOMPLETE_RANGE ^( EXPRESSION $lhsID) ) | RANGE
            // incompleteRange= incompleteExpression -> ^( INCOMPLETE_RANGE ^(
            // EXPRESSION $lhsID) ^( INCOMPLETE_EXPRESSION $incompleteRange) ) |
            // INVERSE_OF -> ^( INCOMPLETE_INVERSE_OF ^( EXPRESSION $lhsID) ) )
            // )
            int alt5 = 2;
            int LA5_0 = input.LA(1);
            if (LA5_0 == IDENTIFIER) {
                int LA5_1 = input.LA(2);
                if (LA5_1 == COMPOSITION || LA5_1 >= AND && LA5_1 <= OR || LA5_1 >= SOME
                        && LA5_1 <= VALUE || LA5_1 >= SUBCLASS_OF
                        && LA5_1 <= EQUIVALENT_TO || LA5_1 == DISJOINT_WITH
                        || LA5_1 == OPEN_SQUARE_BRACKET) {
                    alt5 = 1;
                } else if (LA5_1 >= SAME_AS && LA5_1 <= INVERSE_OF || LA5_1 >= DOMAIN
                        && LA5_1 <= RANGE) {
                    alt5 = 2;
                } else {
                    if (state.backtracking > 0) {
                        state.failed = true;
                        return retval;
                    }
                    NoViableAltException nvae = new NoViableAltException("", 5, 1, input);
                    throw nvae;
                }
            } else if (LA5_0 >= OPEN_PARENTHESYS && LA5_0 <= OPEN_CURLY_BRACES
                    || LA5_0 == NOT || LA5_0 == INVERSE || LA5_0 == DBLQUOTE
                    || LA5_0 == ENTITY_REFERENCE) {
                alt5 = 1;
            } else {
                if (state.backtracking > 0) {
                    state.failed = true;
                    return retval;
                }
                NoViableAltException nvae = new NoViableAltException("", 5, 0, input);
                throw nvae;
            }
            switch (alt5) {
                case 1:
                // ManchesterOWLSyntaxAutoCompleteBase.g:66:5: lhs= expression (
                // SUBCLASS_OF -> ^( INCOMPLETE_SUB_CLASS_AXIOM ^( EXPRESSION
                // $lhs) ) | SUBCLASS_OF superClass= incompleteExpression -> ^(
                // INCOMPLETE_SUB_CLASS_AXIOM ^( EXPRESSION $lhs) ^(
                // INCOMPLETE_EXPRESSION $superClass) ) | EQUIVALENT_TO -> ^(
                // INCOMPLETE_EQUIVALENT_TO_AXIOM ^( EXPRESSION $lhs) ) |
                // EQUIVALENT_TO rhs= incompleteExpression -> ^(
                // EQUIVALENT_TO_AXIOM ^( EXPRESSION $lhs) ^(
                // INCOMPLETE_EXPRESSION $rhs) ) | DISJOINT_WITH -> ^(
                // INCOMPLETE_DISJOINT_WITH_AXIOM ^( EXPRESSION $lhs) ) |
                // DISJOINT_WITH disjoint= incompleteExpression -> ^(
                // DISJOINT_WITH_AXIOM ^( EXPRESSION $lhs) ^(
                // INCOMPLETE_EXPRESSION $disjoint) ) | SUB_PROPERTY_OF -> ^(
                // INCOMPLETE_SUB_PROPERTY_AXIOM ^( EXPRESSION $lhs) ) )
                {
                    pushFollow(FOLLOW_expression_in_incompleteBinaryAxiom366);
                    lhs = gManchesterOWLSyntaxAutoCompleteCombined.expression();
                    state._fsp--;
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        stream_expression.add(lhs.getTree());
                    }
                    // ManchesterOWLSyntaxAutoCompleteBase.g:68:17: (
                    // SUBCLASS_OF -> ^( INCOMPLETE_SUB_CLASS_AXIOM ^(
                    // EXPRESSION $lhs) ) | SUBCLASS_OF superClass=
                    // incompleteExpression -> ^( INCOMPLETE_SUB_CLASS_AXIOM ^(
                    // EXPRESSION $lhs) ^( INCOMPLETE_EXPRESSION $superClass) )
                    // | EQUIVALENT_TO -> ^( INCOMPLETE_EQUIVALENT_TO_AXIOM ^(
                    // EXPRESSION $lhs) ) | EQUIVALENT_TO rhs=
                    // incompleteExpression -> ^( EQUIVALENT_TO_AXIOM ^(
                    // EXPRESSION $lhs) ^( INCOMPLETE_EXPRESSION $rhs) ) |
                    // DISJOINT_WITH -> ^( INCOMPLETE_DISJOINT_WITH_AXIOM ^(
                    // EXPRESSION $lhs) ) | DISJOINT_WITH disjoint=
                    // incompleteExpression -> ^( DISJOINT_WITH_AXIOM ^(
                    // EXPRESSION $lhs) ^( INCOMPLETE_EXPRESSION $disjoint) ) |
                    // SUB_PROPERTY_OF -> ^( INCOMPLETE_SUB_PROPERTY_AXIOM ^(
                    // EXPRESSION $lhs) ) )
                    int alt3 = 7;
                    alt3 = dfa3.predict(input);
                    switch (alt3) {
                        case 1:
                        // ManchesterOWLSyntaxAutoCompleteBase.g:69:17:
                        // SUBCLASS_OF
                        {
                            SUBCLASS_OF7 = (Token) match(input, SUBCLASS_OF,
                                    FOLLOW_SUBCLASS_OF_in_incompleteBinaryAxiom421);
                            if (state.failed) {
                                return retval;
                            }
                            if (state.backtracking == 0) {
                                stream_SUBCLASS_OF.add(SUBCLASS_OF7);
                            }
                            // AST REWRITE
                            // elements: lhs
                            // token labels:
                            // rule labels: lhs, retval
                            // token list labels:
                            // rule list labels:
                            // wildcard labels:
                            if (state.backtracking == 0) {
                                retval.tree = root_0;
                                RewriteRuleSubtreeStream stream_lhs = new RewriteRuleSubtreeStream(
                                        adaptor, "rule lhs", lhs != null ? lhs.tree
                                                : null);
                                root_0 = (ManchesterOWLSyntaxTree) adaptor.nil();
                                // 69:31: -> ^( INCOMPLETE_SUB_CLASS_AXIOM ^(
                                // EXPRESSION $lhs) )
                                {
                                    // ManchesterOWLSyntaxAutoCompleteBase.g:69:34:
                                    // ^( INCOMPLETE_SUB_CLASS_AXIOM ^(
                                    // EXPRESSION $lhs) )
                                    {
                                        ManchesterOWLSyntaxTree root_1 = (ManchesterOWLSyntaxTree) adaptor
                                                .nil();
                                        root_1 = (ManchesterOWLSyntaxTree) adaptor
                                                .becomeRoot(adaptor.create(
                                                        INCOMPLETE_SUB_CLASS_AXIOM,
                                                        "INCOMPLETE_SUB_CLASS_AXIOM"),
                                                        root_1);
                                        // ManchesterOWLSyntaxAutoCompleteBase.g:69:64:
                                        // ^( EXPRESSION $lhs)
                                        {
                                            ManchesterOWLSyntaxTree root_2 = (ManchesterOWLSyntaxTree) adaptor
                                                    .nil();
                                            root_2 = (ManchesterOWLSyntaxTree) adaptor
                                                    .becomeRoot(adaptor.create(
                                                            EXPRESSION, "EXPRESSION"),
                                                            root_2);
                                            adaptor.addChild(root_2,
                                                    stream_lhs.nextTree());
                                            adaptor.addChild(root_1, root_2);
                                        }
                                        adaptor.addChild(root_0, root_1);
                                    }
                                }
                                retval.tree = root_0;
                            }
                        }
                            break;
                        case 2:
                        // ManchesterOWLSyntaxAutoCompleteBase.g:70:19:
                        // SUBCLASS_OF superClass= incompleteExpression
                        {
                            SUBCLASS_OF8 = (Token) match(input, SUBCLASS_OF,
                                    FOLLOW_SUBCLASS_OF_in_incompleteBinaryAxiom457);
                            if (state.failed) {
                                return retval;
                            }
                            if (state.backtracking == 0) {
                                stream_SUBCLASS_OF.add(SUBCLASS_OF8);
                            }
                            pushFollow(FOLLOW_incompleteExpression_in_incompleteBinaryAxiom463);
                            superClass = incompleteExpression();
                            state._fsp--;
                            if (state.failed) {
                                return retval;
                            }
                            if (state.backtracking == 0) {
                                stream_incompleteExpression.add(superClass.getTree());
                            }
                            // AST REWRITE
                            // elements: lhs, superClass
                            // token labels:
                            // rule labels: lhs, retval, superClass
                            // token list labels:
                            // rule list labels:
                            // wildcard labels:
                            if (state.backtracking == 0) {
                                retval.tree = root_0;
                                RewriteRuleSubtreeStream stream_lhs = new RewriteRuleSubtreeStream(
                                        adaptor, "rule lhs", lhs != null ? lhs.tree
                                                : null);
                                RewriteRuleSubtreeStream stream_superClass = new RewriteRuleSubtreeStream(
                                        adaptor, "rule superClass",
                                        superClass != null ? superClass.tree : null);
                                root_0 = (ManchesterOWLSyntaxTree) adaptor.nil();
                                // 70:65: -> ^( INCOMPLETE_SUB_CLASS_AXIOM ^(
                                // EXPRESSION $lhs) ^( INCOMPLETE_EXPRESSION
                                // $superClass) )
                                {
                                    // ManchesterOWLSyntaxAutoCompleteBase.g:70:68:
                                    // ^( INCOMPLETE_SUB_CLASS_AXIOM ^(
                                    // EXPRESSION $lhs) ^( INCOMPLETE_EXPRESSION
                                    // $superClass) )
                                    {
                                        ManchesterOWLSyntaxTree root_1 = (ManchesterOWLSyntaxTree) adaptor
                                                .nil();
                                        root_1 = (ManchesterOWLSyntaxTree) adaptor
                                                .becomeRoot(adaptor.create(
                                                        INCOMPLETE_SUB_CLASS_AXIOM,
                                                        "INCOMPLETE_SUB_CLASS_AXIOM"),
                                                        root_1);
                                        // ManchesterOWLSyntaxAutoCompleteBase.g:70:98:
                                        // ^( EXPRESSION $lhs)
                                        {
                                            ManchesterOWLSyntaxTree root_2 = (ManchesterOWLSyntaxTree) adaptor
                                                    .nil();
                                            root_2 = (ManchesterOWLSyntaxTree) adaptor
                                                    .becomeRoot(adaptor.create(
                                                            EXPRESSION, "EXPRESSION"),
                                                            root_2);
                                            adaptor.addChild(root_2,
                                                    stream_lhs.nextTree());
                                            adaptor.addChild(root_1, root_2);
                                        }
                                        // ManchesterOWLSyntaxAutoCompleteBase.g:70:117:
                                        // ^( INCOMPLETE_EXPRESSION $superClass)
                                        {
                                            ManchesterOWLSyntaxTree root_2 = (ManchesterOWLSyntaxTree) adaptor
                                                    .nil();
                                            root_2 = (ManchesterOWLSyntaxTree) adaptor
                                                    .becomeRoot(adaptor.create(
                                                            INCOMPLETE_EXPRESSION,
                                                            "INCOMPLETE_EXPRESSION"),
                                                            root_2);
                                            adaptor.addChild(root_2,
                                                    stream_superClass.nextTree());
                                            adaptor.addChild(root_1, root_2);
                                        }
                                        adaptor.addChild(root_0, root_1);
                                    }
                                }
                                retval.tree = root_0;
                            }
                        }
                            break;
                        case 3:
                        // ManchesterOWLSyntaxAutoCompleteBase.g:71:19:
                        // EQUIVALENT_TO
                        {
                            EQUIVALENT_TO9 = (Token) match(input, EQUIVALENT_TO,
                                    FOLLOW_EQUIVALENT_TO_in_incompleteBinaryAxiom504);
                            if (state.failed) {
                                return retval;
                            }
                            if (state.backtracking == 0) {
                                stream_EQUIVALENT_TO.add(EQUIVALENT_TO9);
                            }
                            // AST REWRITE
                            // elements: lhs
                            // token labels:
                            // rule labels: lhs, retval
                            // token list labels:
                            // rule list labels:
                            // wildcard labels:
                            if (state.backtracking == 0) {
                                retval.tree = root_0;
                                RewriteRuleSubtreeStream stream_lhs = new RewriteRuleSubtreeStream(
                                        adaptor, "rule lhs", lhs != null ? lhs.tree
                                                : null);
                                root_0 = (ManchesterOWLSyntaxTree) adaptor.nil();
                                // 71:34: -> ^( INCOMPLETE_EQUIVALENT_TO_AXIOM
                                // ^( EXPRESSION $lhs) )
                                {
                                    // ManchesterOWLSyntaxAutoCompleteBase.g:71:37:
                                    // ^( INCOMPLETE_EQUIVALENT_TO_AXIOM ^(
                                    // EXPRESSION $lhs) )
                                    {
                                        ManchesterOWLSyntaxTree root_1 = (ManchesterOWLSyntaxTree) adaptor
                                                .nil();
                                        root_1 = (ManchesterOWLSyntaxTree) adaptor
                                                .becomeRoot(
                                                        adaptor.create(
                                                                INCOMPLETE_EQUIVALENT_TO_AXIOM,
                                                                "INCOMPLETE_EQUIVALENT_TO_AXIOM"),
                                                        root_1);
                                        // ManchesterOWLSyntaxAutoCompleteBase.g:71:70:
                                        // ^( EXPRESSION $lhs)
                                        {
                                            ManchesterOWLSyntaxTree root_2 = (ManchesterOWLSyntaxTree) adaptor
                                                    .nil();
                                            root_2 = (ManchesterOWLSyntaxTree) adaptor
                                                    .becomeRoot(adaptor.create(
                                                            EXPRESSION, "EXPRESSION"),
                                                            root_2);
                                            adaptor.addChild(root_2,
                                                    stream_lhs.nextTree());
                                            adaptor.addChild(root_1, root_2);
                                        }
                                        adaptor.addChild(root_0, root_1);
                                    }
                                }
                                retval.tree = root_0;
                            }
                        }
                            break;
                        case 4:
                        // ManchesterOWLSyntaxAutoCompleteBase.g:72:19:
                        // EQUIVALENT_TO rhs= incompleteExpression
                        {
                            EQUIVALENT_TO10 = (Token) match(input, EQUIVALENT_TO,
                                    FOLLOW_EQUIVALENT_TO_in_incompleteBinaryAxiom538);
                            if (state.failed) {
                                return retval;
                            }
                            if (state.backtracking == 0) {
                                stream_EQUIVALENT_TO.add(EQUIVALENT_TO10);
                            }
                            pushFollow(FOLLOW_incompleteExpression_in_incompleteBinaryAxiom544);
                            rhs = incompleteExpression();
                            state._fsp--;
                            if (state.failed) {
                                return retval;
                            }
                            if (state.backtracking == 0) {
                                stream_incompleteExpression.add(rhs.getTree());
                            }
                            // AST REWRITE
                            // elements: lhs, rhs
                            // token labels:
                            // rule labels: lhs, retval, rhs
                            // token list labels:
                            // rule list labels:
                            // wildcard labels:
                            if (state.backtracking == 0) {
                                retval.tree = root_0;
                                RewriteRuleSubtreeStream stream_lhs = new RewriteRuleSubtreeStream(
                                        adaptor, "rule lhs", lhs != null ? lhs.tree
                                                : null);
                                RewriteRuleSubtreeStream stream_rhs = new RewriteRuleSubtreeStream(
                                        adaptor, "rule rhs", rhs != null ? rhs.tree
                                                : null);
                                root_0 = (ManchesterOWLSyntaxTree) adaptor.nil();
                                // 72:60: -> ^( EQUIVALENT_TO_AXIOM ^(
                                // EXPRESSION $lhs) ^( INCOMPLETE_EXPRESSION
                                // $rhs) )
                                {
                                    // ManchesterOWLSyntaxAutoCompleteBase.g:72:63:
                                    // ^( EQUIVALENT_TO_AXIOM ^( EXPRESSION
                                    // $lhs) ^( INCOMPLETE_EXPRESSION $rhs) )
                                    {
                                        ManchesterOWLSyntaxTree root_1 = (ManchesterOWLSyntaxTree) adaptor
                                                .nil();
                                        root_1 = (ManchesterOWLSyntaxTree) adaptor
                                                .becomeRoot(adaptor.create(
                                                        EQUIVALENT_TO_AXIOM,
                                                        "EQUIVALENT_TO_AXIOM"), root_1);
                                        // ManchesterOWLSyntaxAutoCompleteBase.g:72:85:
                                        // ^( EXPRESSION $lhs)
                                        {
                                            ManchesterOWLSyntaxTree root_2 = (ManchesterOWLSyntaxTree) adaptor
                                                    .nil();
                                            root_2 = (ManchesterOWLSyntaxTree) adaptor
                                                    .becomeRoot(adaptor.create(
                                                            EXPRESSION, "EXPRESSION"),
                                                            root_2);
                                            adaptor.addChild(root_2,
                                                    stream_lhs.nextTree());
                                            adaptor.addChild(root_1, root_2);
                                        }
                                        // ManchesterOWLSyntaxAutoCompleteBase.g:72:104:
                                        // ^( INCOMPLETE_EXPRESSION $rhs)
                                        {
                                            ManchesterOWLSyntaxTree root_2 = (ManchesterOWLSyntaxTree) adaptor
                                                    .nil();
                                            root_2 = (ManchesterOWLSyntaxTree) adaptor
                                                    .becomeRoot(adaptor.create(
                                                            INCOMPLETE_EXPRESSION,
                                                            "INCOMPLETE_EXPRESSION"),
                                                            root_2);
                                            adaptor.addChild(root_2,
                                                    stream_rhs.nextTree());
                                            adaptor.addChild(root_1, root_2);
                                        }
                                        adaptor.addChild(root_0, root_1);
                                    }
                                }
                                retval.tree = root_0;
                            }
                        }
                            break;
                        case 5:
                        // ManchesterOWLSyntaxAutoCompleteBase.g:73:19:
                        // DISJOINT_WITH
                        {
                            DISJOINT_WITH11 = (Token) match(input, DISJOINT_WITH,
                                    FOLLOW_DISJOINT_WITH_in_incompleteBinaryAxiom584);
                            if (state.failed) {
                                return retval;
                            }
                            if (state.backtracking == 0) {
                                stream_DISJOINT_WITH.add(DISJOINT_WITH11);
                            }
                            // AST REWRITE
                            // elements: lhs
                            // token labels:
                            // rule labels: lhs, retval
                            // token list labels:
                            // rule list labels:
                            // wildcard labels:
                            if (state.backtracking == 0) {
                                retval.tree = root_0;
                                RewriteRuleSubtreeStream stream_lhs = new RewriteRuleSubtreeStream(
                                        adaptor, "rule lhs", lhs != null ? lhs.tree
                                                : null);
                                root_0 = (ManchesterOWLSyntaxTree) adaptor.nil();
                                // 73:33: -> ^( INCOMPLETE_DISJOINT_WITH_AXIOM
                                // ^( EXPRESSION $lhs) )
                                {
                                    // ManchesterOWLSyntaxAutoCompleteBase.g:73:36:
                                    // ^( INCOMPLETE_DISJOINT_WITH_AXIOM ^(
                                    // EXPRESSION $lhs) )
                                    {
                                        ManchesterOWLSyntaxTree root_1 = (ManchesterOWLSyntaxTree) adaptor
                                                .nil();
                                        root_1 = (ManchesterOWLSyntaxTree) adaptor
                                                .becomeRoot(
                                                        adaptor.create(
                                                                INCOMPLETE_DISJOINT_WITH_AXIOM,
                                                                "INCOMPLETE_DISJOINT_WITH_AXIOM"),
                                                        root_1);
                                        // ManchesterOWLSyntaxAutoCompleteBase.g:73:69:
                                        // ^( EXPRESSION $lhs)
                                        {
                                            ManchesterOWLSyntaxTree root_2 = (ManchesterOWLSyntaxTree) adaptor
                                                    .nil();
                                            root_2 = (ManchesterOWLSyntaxTree) adaptor
                                                    .becomeRoot(adaptor.create(
                                                            EXPRESSION, "EXPRESSION"),
                                                            root_2);
                                            adaptor.addChild(root_2,
                                                    stream_lhs.nextTree());
                                            adaptor.addChild(root_1, root_2);
                                        }
                                        adaptor.addChild(root_0, root_1);
                                    }
                                }
                                retval.tree = root_0;
                            }
                        }
                            break;
                        case 6:
                        // ManchesterOWLSyntaxAutoCompleteBase.g:74:19:
                        // DISJOINT_WITH disjoint= incompleteExpression
                        {
                            DISJOINT_WITH12 = (Token) match(input, DISJOINT_WITH,
                                    FOLLOW_DISJOINT_WITH_in_incompleteBinaryAxiom617);
                            if (state.failed) {
                                return retval;
                            }
                            if (state.backtracking == 0) {
                                stream_DISJOINT_WITH.add(DISJOINT_WITH12);
                            }
                            pushFollow(FOLLOW_incompleteExpression_in_incompleteBinaryAxiom623);
                            disjoint = incompleteExpression();
                            state._fsp--;
                            if (state.failed) {
                                return retval;
                            }
                            if (state.backtracking == 0) {
                                stream_incompleteExpression.add(disjoint.getTree());
                            }
                            // AST REWRITE
                            // elements: lhs, disjoint
                            // token labels:
                            // rule labels: lhs, disjoint, retval
                            // token list labels:
                            // rule list labels:
                            // wildcard labels:
                            if (state.backtracking == 0) {
                                retval.tree = root_0;
                                RewriteRuleSubtreeStream stream_lhs = new RewriteRuleSubtreeStream(
                                        adaptor, "rule lhs", lhs != null ? lhs.tree
                                                : null);
                                RewriteRuleSubtreeStream stream_disjoint = new RewriteRuleSubtreeStream(
                                        adaptor, "rule disjoint",
                                        disjoint != null ? disjoint.tree : null);
                                root_0 = (ManchesterOWLSyntaxTree) adaptor.nil();
                                // 74:65: -> ^( DISJOINT_WITH_AXIOM ^(
                                // EXPRESSION $lhs) ^( INCOMPLETE_EXPRESSION
                                // $disjoint) )
                                {
                                    // ManchesterOWLSyntaxAutoCompleteBase.g:74:68:
                                    // ^( DISJOINT_WITH_AXIOM ^( EXPRESSION
                                    // $lhs) ^( INCOMPLETE_EXPRESSION $disjoint)
                                    // )
                                    {
                                        ManchesterOWLSyntaxTree root_1 = (ManchesterOWLSyntaxTree) adaptor
                                                .nil();
                                        root_1 = (ManchesterOWLSyntaxTree) adaptor
                                                .becomeRoot(adaptor.create(
                                                        DISJOINT_WITH_AXIOM,
                                                        "DISJOINT_WITH_AXIOM"), root_1);
                                        // ManchesterOWLSyntaxAutoCompleteBase.g:74:90:
                                        // ^( EXPRESSION $lhs)
                                        {
                                            ManchesterOWLSyntaxTree root_2 = (ManchesterOWLSyntaxTree) adaptor
                                                    .nil();
                                            root_2 = (ManchesterOWLSyntaxTree) adaptor
                                                    .becomeRoot(adaptor.create(
                                                            EXPRESSION, "EXPRESSION"),
                                                            root_2);
                                            adaptor.addChild(root_2,
                                                    stream_lhs.nextTree());
                                            adaptor.addChild(root_1, root_2);
                                        }
                                        // ManchesterOWLSyntaxAutoCompleteBase.g:74:109:
                                        // ^( INCOMPLETE_EXPRESSION $disjoint)
                                        {
                                            ManchesterOWLSyntaxTree root_2 = (ManchesterOWLSyntaxTree) adaptor
                                                    .nil();
                                            root_2 = (ManchesterOWLSyntaxTree) adaptor
                                                    .becomeRoot(adaptor.create(
                                                            INCOMPLETE_EXPRESSION,
                                                            "INCOMPLETE_EXPRESSION"),
                                                            root_2);
                                            adaptor.addChild(root_2,
                                                    stream_disjoint.nextTree());
                                            adaptor.addChild(root_1, root_2);
                                        }
                                        adaptor.addChild(root_0, root_1);
                                    }
                                }
                                retval.tree = root_0;
                            }
                        }
                            break;
                        case 7:
                        // ManchesterOWLSyntaxAutoCompleteBase.g:75:19:
                        // SUB_PROPERTY_OF
                        {
                            SUB_PROPERTY_OF13 = (Token) match(input, SUB_PROPERTY_OF,
                                    FOLLOW_SUB_PROPERTY_OF_in_incompleteBinaryAxiom663);
                            if (state.failed) {
                                return retval;
                            }
                            if (state.backtracking == 0) {
                                stream_SUB_PROPERTY_OF.add(SUB_PROPERTY_OF13);
                            }
                            // AST REWRITE
                            // elements: lhs
                            // token labels:
                            // rule labels: lhs, retval
                            // token list labels:
                            // rule list labels:
                            // wildcard labels:
                            if (state.backtracking == 0) {
                                retval.tree = root_0;
                                RewriteRuleSubtreeStream stream_lhs = new RewriteRuleSubtreeStream(
                                        adaptor, "rule lhs", lhs != null ? lhs.tree
                                                : null);
                                root_0 = (ManchesterOWLSyntaxTree) adaptor.nil();
                                // 75:36: -> ^( INCOMPLETE_SUB_PROPERTY_AXIOM ^(
                                // EXPRESSION $lhs) )
                                {
                                    // ManchesterOWLSyntaxAutoCompleteBase.g:75:39:
                                    // ^( INCOMPLETE_SUB_PROPERTY_AXIOM ^(
                                    // EXPRESSION $lhs) )
                                    {
                                        ManchesterOWLSyntaxTree root_1 = (ManchesterOWLSyntaxTree) adaptor
                                                .nil();
                                        root_1 = (ManchesterOWLSyntaxTree) adaptor
                                                .becomeRoot(adaptor.create(
                                                        INCOMPLETE_SUB_PROPERTY_AXIOM,
                                                        "INCOMPLETE_SUB_PROPERTY_AXIOM"),
                                                        root_1);
                                        // ManchesterOWLSyntaxAutoCompleteBase.g:75:71:
                                        // ^( EXPRESSION $lhs)
                                        {
                                            ManchesterOWLSyntaxTree root_2 = (ManchesterOWLSyntaxTree) adaptor
                                                    .nil();
                                            root_2 = (ManchesterOWLSyntaxTree) adaptor
                                                    .becomeRoot(adaptor.create(
                                                            EXPRESSION, "EXPRESSION"),
                                                            root_2);
                                            adaptor.addChild(root_2,
                                                    stream_lhs.nextTree());
                                            adaptor.addChild(root_1, root_2);
                                        }
                                        adaptor.addChild(root_0, root_1);
                                    }
                                }
                                retval.tree = root_0;
                            }
                        }
                            break;
                    }
                }
                    break;
                case 2:
                // ManchesterOWLSyntaxAutoCompleteBase.g:78:5: lhsID= IDENTIFIER
                // ( SAME_AS -> ^( INCOMPLETE_SAME_AS_AXIOM ^( EXPRESSION
                // $lhsID) ) | DIFFERENT_FROM -> ^(
                // INCOMPLETE_DIFFERENT_FROM_AXIOM ^( EXPRESSION $lhsID) ) |
                // DOMAIN -> ^( INCOMPLETE_DOMAIN ^( EXPRESSION $lhsID) ) |
                // DOMAIN incompleteDomain= incompleteExpression -> ^(
                // INCOMPLETE_DOMAIN ^( EXPRESSION $lhsID) ^(
                // INCOMPLETE_EXPRESSION $incompleteDomain) ) | RANGE -> ^(
                // INCOMPLETE_RANGE ^( EXPRESSION $lhsID) ) | RANGE
                // incompleteRange= incompleteExpression -> ^( INCOMPLETE_RANGE
                // ^( EXPRESSION $lhsID) ^( INCOMPLETE_EXPRESSION
                // $incompleteRange) ) | INVERSE_OF -> ^( INCOMPLETE_INVERSE_OF
                // ^( EXPRESSION $lhsID) ) )
                {
                    lhsID = (Token) match(input, IDENTIFIER,
                            FOLLOW_IDENTIFIER_in_incompleteBinaryAxiom734);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        stream_IDENTIFIER.add(lhsID);
                    }
                    // ManchesterOWLSyntaxAutoCompleteBase.g:78:25: ( SAME_AS ->
                    // ^( INCOMPLETE_SAME_AS_AXIOM ^( EXPRESSION $lhsID) ) |
                    // DIFFERENT_FROM -> ^( INCOMPLETE_DIFFERENT_FROM_AXIOM ^(
                    // EXPRESSION $lhsID) ) | DOMAIN -> ^( INCOMPLETE_DOMAIN ^(
                    // EXPRESSION $lhsID) ) | DOMAIN incompleteDomain=
                    // incompleteExpression -> ^( INCOMPLETE_DOMAIN ^(
                    // EXPRESSION $lhsID) ^( INCOMPLETE_EXPRESSION
                    // $incompleteDomain) ) | RANGE -> ^( INCOMPLETE_RANGE ^(
                    // EXPRESSION $lhsID) ) | RANGE incompleteRange=
                    // incompleteExpression -> ^( INCOMPLETE_RANGE ^( EXPRESSION
                    // $lhsID) ^( INCOMPLETE_EXPRESSION $incompleteRange) ) |
                    // INVERSE_OF -> ^( INCOMPLETE_INVERSE_OF ^( EXPRESSION
                    // $lhsID) ) )
                    int alt4 = 7;
                    alt4 = dfa4.predict(input);
                    switch (alt4) {
                        case 1:
                        // ManchesterOWLSyntaxAutoCompleteBase.g:79:21: SAME_AS
                        {
                            SAME_AS14 = (Token) match(input, SAME_AS,
                                    FOLLOW_SAME_AS_in_incompleteBinaryAxiom759);
                            if (state.failed) {
                                return retval;
                            }
                            if (state.backtracking == 0) {
                                stream_SAME_AS.add(SAME_AS14);
                            }
                            // AST REWRITE
                            // elements: lhsID
                            // token labels: lhsID
                            // rule labels: retval
                            // token list labels:
                            // rule list labels:
                            // wildcard labels:
                            if (state.backtracking == 0) {
                                retval.tree = root_0;
                                RewriteRuleTokenStream stream_lhsID = new RewriteRuleTokenStream(
                                        adaptor, "token lhsID", lhsID);
                                root_0 = (ManchesterOWLSyntaxTree) adaptor.nil();
                                // 79:31: -> ^( INCOMPLETE_SAME_AS_AXIOM ^(
                                // EXPRESSION $lhsID) )
                                {
                                    // ManchesterOWLSyntaxAutoCompleteBase.g:79:34:
                                    // ^( INCOMPLETE_SAME_AS_AXIOM ^( EXPRESSION
                                    // $lhsID) )
                                    {
                                        ManchesterOWLSyntaxTree root_1 = (ManchesterOWLSyntaxTree) adaptor
                                                .nil();
                                        root_1 = (ManchesterOWLSyntaxTree) adaptor
                                                .becomeRoot(adaptor.create(
                                                        INCOMPLETE_SAME_AS_AXIOM,
                                                        "INCOMPLETE_SAME_AS_AXIOM"),
                                                        root_1);
                                        // ManchesterOWLSyntaxAutoCompleteBase.g:79:61:
                                        // ^( EXPRESSION $lhsID)
                                        {
                                            ManchesterOWLSyntaxTree root_2 = (ManchesterOWLSyntaxTree) adaptor
                                                    .nil();
                                            root_2 = (ManchesterOWLSyntaxTree) adaptor
                                                    .becomeRoot(adaptor.create(
                                                            EXPRESSION, "EXPRESSION"),
                                                            root_2);
                                            adaptor.addChild(root_2,
                                                    stream_lhsID.nextNode());
                                            adaptor.addChild(root_1, root_2);
                                        }
                                        adaptor.addChild(root_0, root_1);
                                    }
                                }
                                retval.tree = root_0;
                            }
                        }
                            break;
                        case 2:
                        // ManchesterOWLSyntaxAutoCompleteBase.g:80:21:
                        // DIFFERENT_FROM
                        {
                            DIFFERENT_FROM15 = (Token) match(input, DIFFERENT_FROM,
                                    FOLLOW_DIFFERENT_FROM_in_incompleteBinaryAxiom797);
                            if (state.failed) {
                                return retval;
                            }
                            if (state.backtracking == 0) {
                                stream_DIFFERENT_FROM.add(DIFFERENT_FROM15);
                            }
                            // AST REWRITE
                            // elements: lhsID
                            // token labels: lhsID
                            // rule labels: retval
                            // token list labels:
                            // rule list labels:
                            // wildcard labels:
                            if (state.backtracking == 0) {
                                retval.tree = root_0;
                                RewriteRuleTokenStream stream_lhsID = new RewriteRuleTokenStream(
                                        adaptor, "token lhsID", lhsID);
                                root_0 = (ManchesterOWLSyntaxTree) adaptor.nil();
                                // 80:37: -> ^( INCOMPLETE_DIFFERENT_FROM_AXIOM
                                // ^( EXPRESSION $lhsID) )
                                {
                                    // ManchesterOWLSyntaxAutoCompleteBase.g:80:40:
                                    // ^( INCOMPLETE_DIFFERENT_FROM_AXIOM ^(
                                    // EXPRESSION $lhsID) )
                                    {
                                        ManchesterOWLSyntaxTree root_1 = (ManchesterOWLSyntaxTree) adaptor
                                                .nil();
                                        root_1 = (ManchesterOWLSyntaxTree) adaptor
                                                .becomeRoot(
                                                        adaptor.create(
                                                                INCOMPLETE_DIFFERENT_FROM_AXIOM,
                                                                "INCOMPLETE_DIFFERENT_FROM_AXIOM"),
                                                        root_1);
                                        // ManchesterOWLSyntaxAutoCompleteBase.g:80:74:
                                        // ^( EXPRESSION $lhsID)
                                        {
                                            ManchesterOWLSyntaxTree root_2 = (ManchesterOWLSyntaxTree) adaptor
                                                    .nil();
                                            root_2 = (ManchesterOWLSyntaxTree) adaptor
                                                    .becomeRoot(adaptor.create(
                                                            EXPRESSION, "EXPRESSION"),
                                                            root_2);
                                            adaptor.addChild(root_2,
                                                    stream_lhsID.nextNode());
                                            adaptor.addChild(root_1, root_2);
                                        }
                                        adaptor.addChild(root_0, root_1);
                                    }
                                }
                                retval.tree = root_0;
                            }
                        }
                            break;
                        case 3:
                        // ManchesterOWLSyntaxAutoCompleteBase.g:81:21: DOMAIN
                        {
                            DOMAIN16 = (Token) match(input, DOMAIN,
                                    FOLLOW_DOMAIN_in_incompleteBinaryAxiom833);
                            if (state.failed) {
                                return retval;
                            }
                            if (state.backtracking == 0) {
                                stream_DOMAIN.add(DOMAIN16);
                            }
                            // AST REWRITE
                            // elements: lhsID
                            // token labels: lhsID
                            // rule labels: retval
                            // token list labels:
                            // rule list labels:
                            // wildcard labels:
                            if (state.backtracking == 0) {
                                retval.tree = root_0;
                                RewriteRuleTokenStream stream_lhsID = new RewriteRuleTokenStream(
                                        adaptor, "token lhsID", lhsID);
                                root_0 = (ManchesterOWLSyntaxTree) adaptor.nil();
                                // 81:29: -> ^( INCOMPLETE_DOMAIN ^( EXPRESSION
                                // $lhsID) )
                                {
                                    // ManchesterOWLSyntaxAutoCompleteBase.g:81:32:
                                    // ^( INCOMPLETE_DOMAIN ^( EXPRESSION
                                    // $lhsID) )
                                    {
                                        ManchesterOWLSyntaxTree root_1 = (ManchesterOWLSyntaxTree) adaptor
                                                .nil();
                                        root_1 = (ManchesterOWLSyntaxTree) adaptor
                                                .becomeRoot(adaptor.create(
                                                        INCOMPLETE_DOMAIN,
                                                        "INCOMPLETE_DOMAIN"), root_1);
                                        // ManchesterOWLSyntaxAutoCompleteBase.g:81:52:
                                        // ^( EXPRESSION $lhsID)
                                        {
                                            ManchesterOWLSyntaxTree root_2 = (ManchesterOWLSyntaxTree) adaptor
                                                    .nil();
                                            root_2 = (ManchesterOWLSyntaxTree) adaptor
                                                    .becomeRoot(adaptor.create(
                                                            EXPRESSION, "EXPRESSION"),
                                                            root_2);
                                            adaptor.addChild(root_2,
                                                    stream_lhsID.nextNode());
                                            adaptor.addChild(root_1, root_2);
                                        }
                                        adaptor.addChild(root_0, root_1);
                                    }
                                }
                                retval.tree = root_0;
                            }
                        }
                            break;
                        case 4:
                        // ManchesterOWLSyntaxAutoCompleteBase.g:82:21: DOMAIN
                        // incompleteDomain= incompleteExpression
                        {
                            DOMAIN17 = (Token) match(input, DOMAIN,
                                    FOLLOW_DOMAIN_in_incompleteBinaryAxiom869);
                            if (state.failed) {
                                return retval;
                            }
                            if (state.backtracking == 0) {
                                stream_DOMAIN.add(DOMAIN17);
                            }
                            pushFollow(FOLLOW_incompleteExpression_in_incompleteBinaryAxiom875);
                            incompleteDomain = incompleteExpression();
                            state._fsp--;
                            if (state.failed) {
                                return retval;
                            }
                            if (state.backtracking == 0) {
                                stream_incompleteExpression.add(incompleteDomain
                                        .getTree());
                            }
                            // AST REWRITE
                            // elements: incompleteDomain, lhsID
                            // token labels: lhsID
                            // rule labels: incompleteDomain, retval
                            // token list labels:
                            // rule list labels:
                            // wildcard labels:
                            if (state.backtracking == 0) {
                                retval.tree = root_0;
                                RewriteRuleTokenStream stream_lhsID = new RewriteRuleTokenStream(
                                        adaptor, "token lhsID", lhsID);
                                RewriteRuleSubtreeStream stream_incompleteDomain = new RewriteRuleSubtreeStream(
                                        adaptor, "rule incompleteDomain",
                                        incompleteDomain != null ? incompleteDomain.tree
                                                : null);
                                root_0 = (ManchesterOWLSyntaxTree) adaptor.nil();
                                // 82:69: -> ^( INCOMPLETE_DOMAIN ^( EXPRESSION
                                // $lhsID) ^( INCOMPLETE_EXPRESSION
                                // $incompleteDomain) )
                                {
                                    // ManchesterOWLSyntaxAutoCompleteBase.g:82:72:
                                    // ^( INCOMPLETE_DOMAIN ^( EXPRESSION
                                    // $lhsID) ^( INCOMPLETE_EXPRESSION
                                    // $incompleteDomain) )
                                    {
                                        ManchesterOWLSyntaxTree root_1 = (ManchesterOWLSyntaxTree) adaptor
                                                .nil();
                                        root_1 = (ManchesterOWLSyntaxTree) adaptor
                                                .becomeRoot(adaptor.create(
                                                        INCOMPLETE_DOMAIN,
                                                        "INCOMPLETE_DOMAIN"), root_1);
                                        // ManchesterOWLSyntaxAutoCompleteBase.g:82:92:
                                        // ^( EXPRESSION $lhsID)
                                        {
                                            ManchesterOWLSyntaxTree root_2 = (ManchesterOWLSyntaxTree) adaptor
                                                    .nil();
                                            root_2 = (ManchesterOWLSyntaxTree) adaptor
                                                    .becomeRoot(adaptor.create(
                                                            EXPRESSION, "EXPRESSION"),
                                                            root_2);
                                            adaptor.addChild(root_2,
                                                    stream_lhsID.nextNode());
                                            adaptor.addChild(root_1, root_2);
                                        }
                                        // ManchesterOWLSyntaxAutoCompleteBase.g:82:113:
                                        // ^( INCOMPLETE_EXPRESSION
                                        // $incompleteDomain)
                                        {
                                            ManchesterOWLSyntaxTree root_2 = (ManchesterOWLSyntaxTree) adaptor
                                                    .nil();
                                            root_2 = (ManchesterOWLSyntaxTree) adaptor
                                                    .becomeRoot(adaptor.create(
                                                            INCOMPLETE_EXPRESSION,
                                                            "INCOMPLETE_EXPRESSION"),
                                                            root_2);
                                            adaptor.addChild(root_2,
                                                    stream_incompleteDomain.nextTree());
                                            adaptor.addChild(root_1, root_2);
                                        }
                                        adaptor.addChild(root_0, root_1);
                                    }
                                }
                                retval.tree = root_0;
                            }
                        }
                            break;
                        case 5:
                        // ManchesterOWLSyntaxAutoCompleteBase.g:83:21: RANGE
                        {
                            RANGE18 = (Token) match(input, RANGE,
                                    FOLLOW_RANGE_in_incompleteBinaryAxiom918);
                            if (state.failed) {
                                return retval;
                            }
                            if (state.backtracking == 0) {
                                stream_RANGE.add(RANGE18);
                            }
                            // AST REWRITE
                            // elements: lhsID
                            // token labels: lhsID
                            // rule labels: retval
                            // token list labels:
                            // rule list labels:
                            // wildcard labels:
                            if (state.backtracking == 0) {
                                retval.tree = root_0;
                                RewriteRuleTokenStream stream_lhsID = new RewriteRuleTokenStream(
                                        adaptor, "token lhsID", lhsID);
                                root_0 = (ManchesterOWLSyntaxTree) adaptor.nil();
                                // 83:28: -> ^( INCOMPLETE_RANGE ^( EXPRESSION
                                // $lhsID) )
                                {
                                    // ManchesterOWLSyntaxAutoCompleteBase.g:83:31:
                                    // ^( INCOMPLETE_RANGE ^( EXPRESSION $lhsID)
                                    // )
                                    {
                                        ManchesterOWLSyntaxTree root_1 = (ManchesterOWLSyntaxTree) adaptor
                                                .nil();
                                        root_1 = (ManchesterOWLSyntaxTree) adaptor
                                                .becomeRoot(adaptor.create(
                                                        INCOMPLETE_RANGE,
                                                        "INCOMPLETE_RANGE"), root_1);
                                        // ManchesterOWLSyntaxAutoCompleteBase.g:83:50:
                                        // ^( EXPRESSION $lhsID)
                                        {
                                            ManchesterOWLSyntaxTree root_2 = (ManchesterOWLSyntaxTree) adaptor
                                                    .nil();
                                            root_2 = (ManchesterOWLSyntaxTree) adaptor
                                                    .becomeRoot(adaptor.create(
                                                            EXPRESSION, "EXPRESSION"),
                                                            root_2);
                                            adaptor.addChild(root_2,
                                                    stream_lhsID.nextNode());
                                            adaptor.addChild(root_1, root_2);
                                        }
                                        adaptor.addChild(root_0, root_1);
                                    }
                                }
                                retval.tree = root_0;
                            }
                        }
                            break;
                        case 6:
                        // ManchesterOWLSyntaxAutoCompleteBase.g:84:21: RANGE
                        // incompleteRange= incompleteExpression
                        {
                            RANGE19 = (Token) match(input, RANGE,
                                    FOLLOW_RANGE_in_incompleteBinaryAxiom954);
                            if (state.failed) {
                                return retval;
                            }
                            if (state.backtracking == 0) {
                                stream_RANGE.add(RANGE19);
                            }
                            pushFollow(FOLLOW_incompleteExpression_in_incompleteBinaryAxiom961);
                            incompleteRange = incompleteExpression();
                            state._fsp--;
                            if (state.failed) {
                                return retval;
                            }
                            if (state.backtracking == 0) {
                                stream_incompleteExpression
                                        .add(incompleteRange.getTree());
                            }
                            // AST REWRITE
                            // elements: lhsID, incompleteRange
                            // token labels: lhsID
                            // rule labels: incompleteRange, retval
                            // token list labels:
                            // rule list labels:
                            // wildcard labels:
                            if (state.backtracking == 0) {
                                retval.tree = root_0;
                                RewriteRuleTokenStream stream_lhsID = new RewriteRuleTokenStream(
                                        adaptor, "token lhsID", lhsID);
                                RewriteRuleSubtreeStream stream_incompleteRange = new RewriteRuleSubtreeStream(
                                        adaptor, "rule incompleteRange",
                                        incompleteRange != null ? incompleteRange.tree
                                                : null);
                                root_0 = (ManchesterOWLSyntaxTree) adaptor.nil();
                                // 84:67: -> ^( INCOMPLETE_RANGE ^( EXPRESSION
                                // $lhsID) ^( INCOMPLETE_EXPRESSION
                                // $incompleteRange) )
                                {
                                    // ManchesterOWLSyntaxAutoCompleteBase.g:84:70:
                                    // ^( INCOMPLETE_RANGE ^( EXPRESSION $lhsID)
                                    // ^( INCOMPLETE_EXPRESSION
                                    // $incompleteRange) )
                                    {
                                        ManchesterOWLSyntaxTree root_1 = (ManchesterOWLSyntaxTree) adaptor
                                                .nil();
                                        root_1 = (ManchesterOWLSyntaxTree) adaptor
                                                .becomeRoot(adaptor.create(
                                                        INCOMPLETE_RANGE,
                                                        "INCOMPLETE_RANGE"), root_1);
                                        // ManchesterOWLSyntaxAutoCompleteBase.g:84:89:
                                        // ^( EXPRESSION $lhsID)
                                        {
                                            ManchesterOWLSyntaxTree root_2 = (ManchesterOWLSyntaxTree) adaptor
                                                    .nil();
                                            root_2 = (ManchesterOWLSyntaxTree) adaptor
                                                    .becomeRoot(adaptor.create(
                                                            EXPRESSION, "EXPRESSION"),
                                                            root_2);
                                            adaptor.addChild(root_2,
                                                    stream_lhsID.nextNode());
                                            adaptor.addChild(root_1, root_2);
                                        }
                                        // ManchesterOWLSyntaxAutoCompleteBase.g:84:110:
                                        // ^( INCOMPLETE_EXPRESSION
                                        // $incompleteRange)
                                        {
                                            ManchesterOWLSyntaxTree root_2 = (ManchesterOWLSyntaxTree) adaptor
                                                    .nil();
                                            root_2 = (ManchesterOWLSyntaxTree) adaptor
                                                    .becomeRoot(adaptor.create(
                                                            INCOMPLETE_EXPRESSION,
                                                            "INCOMPLETE_EXPRESSION"),
                                                            root_2);
                                            adaptor.addChild(root_2,
                                                    stream_incompleteRange.nextTree());
                                            adaptor.addChild(root_1, root_2);
                                        }
                                        adaptor.addChild(root_0, root_1);
                                    }
                                }
                                retval.tree = root_0;
                            }
                        }
                            break;
                        case 7:
                        // ManchesterOWLSyntaxAutoCompleteBase.g:85:21:
                        // INVERSE_OF
                        {
                            INVERSE_OF20 = (Token) match(input, INVERSE_OF,
                                    FOLLOW_INVERSE_OF_in_incompleteBinaryAxiom1003);
                            if (state.failed) {
                                return retval;
                            }
                            if (state.backtracking == 0) {
                                stream_INVERSE_OF.add(INVERSE_OF20);
                            }
                            // AST REWRITE
                            // elements: lhsID
                            // token labels: lhsID
                            // rule labels: retval
                            // token list labels:
                            // rule list labels:
                            // wildcard labels:
                            if (state.backtracking == 0) {
                                retval.tree = root_0;
                                RewriteRuleTokenStream stream_lhsID = new RewriteRuleTokenStream(
                                        adaptor, "token lhsID", lhsID);
                                root_0 = (ManchesterOWLSyntaxTree) adaptor.nil();
                                // 85:32: -> ^( INCOMPLETE_INVERSE_OF ^(
                                // EXPRESSION $lhsID) )
                                {
                                    // ManchesterOWLSyntaxAutoCompleteBase.g:85:35:
                                    // ^( INCOMPLETE_INVERSE_OF ^( EXPRESSION
                                    // $lhsID) )
                                    {
                                        ManchesterOWLSyntaxTree root_1 = (ManchesterOWLSyntaxTree) adaptor
                                                .nil();
                                        root_1 = (ManchesterOWLSyntaxTree) adaptor
                                                .becomeRoot(adaptor.create(
                                                        INCOMPLETE_INVERSE_OF,
                                                        "INCOMPLETE_INVERSE_OF"), root_1);
                                        // ManchesterOWLSyntaxAutoCompleteBase.g:85:59:
                                        // ^( EXPRESSION $lhsID)
                                        {
                                            ManchesterOWLSyntaxTree root_2 = (ManchesterOWLSyntaxTree) adaptor
                                                    .nil();
                                            root_2 = (ManchesterOWLSyntaxTree) adaptor
                                                    .becomeRoot(adaptor.create(
                                                            EXPRESSION, "EXPRESSION"),
                                                            root_2);
                                            adaptor.addChild(root_2,
                                                    stream_lhsID.nextNode());
                                            adaptor.addChild(root_1, root_2);
                                        }
                                        adaptor.addChild(root_0, root_1);
                                    }
                                }
                                retval.tree = root_0;
                            }
                        }
                            break;
                    }
                }
                    break;
            }
            retval.stop = input.LT(-1);
            if (state.backtracking == 0) {
                retval.tree = (ManchesterOWLSyntaxTree) adaptor
                        .rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        } catch (RecognitionException re) {
            reportError(re);
            recover(input, re);
            retval.tree = (ManchesterOWLSyntaxTree) adaptor.errorNode(input,
                    retval.start, input.LT(-1), re);
        } finally {}
        return retval;
    }

    // $ANTLR end "incompleteBinaryAxiom"
    public static class incompleteExpression_return extends ParserRuleReturnScope {
        ManchesterOWLSyntaxTree tree;

        @Override
        public Object getTree() {
            return tree;
        }
    }

    // $ANTLR start "incompleteExpression"
    // ManchesterOWLSyntaxAutoCompleteBase.g:90:1: incompleteExpression : (
    // options {backtrack=true; } : head= propertyExpression ( COMPOSITION
    // rest+= propertyExpression )+ COMPOSITION -> ^( INCOMPLETE_EXPRESSION ^(
    // INCOMPLETE_PROPERTY_CHAIN $head $rest) ) | ( conjunction ( OR . )* ) OR
    // incompleteConjunction -> ^( INCOMPLETE_EXPRESSION ^(
    // INCOMPLETE_DISJUNCTION incompleteConjunction ) ) | incompleteConjunction
    // -> ^( INCOMPLETE_EXPRESSION ^( INCOMPLETE_DISJUNCTION
    // incompleteConjunction ) ) | incompleteUnary -> ^( INCOMPLETE_EXPRESSION
    // incompleteUnary ) | expression IDENTIFIER -> ^( INCOMPLETE_EXPRESSION ^(
    // EXPRESSION expression ) IDENTIFIER ) ) ;
    public final
            ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase.incompleteExpression_return
            incompleteExpression() {
        ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase.incompleteExpression_return retval = new ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase.incompleteExpression_return();
        retval.start = input.LT(1);
        ManchesterOWLSyntaxTree root_0 = null;
        Token COMPOSITION21 = null;
        Token COMPOSITION22 = null;
        Token OR24 = null;
        Token wildcard25 = null;
        Token OR26 = null;
        Token IDENTIFIER31 = null;
        List<Object> list_rest = null;
        ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase_MOWLParser.propertyExpression_return head = null;
        ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase_MOWLParser.conjunction_return conjunction23 = null;
        ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase.incompleteConjunction_return incompleteConjunction27 = null;
        ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase.incompleteConjunction_return incompleteConjunction28 = null;
        ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase.incompleteUnary_return incompleteUnary29 = null;
        ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase_MOWLParser.expression_return expression30 = null;
        RuleReturnScope rest = null;
        ManchesterOWLSyntaxTree wildcard25_tree = null;
        RewriteRuleTokenStream stream_IDENTIFIER = new RewriteRuleTokenStream(adaptor,
                "token IDENTIFIER");
        RewriteRuleTokenStream stream_COMPOSITION = new RewriteRuleTokenStream(adaptor,
                "token COMPOSITION");
        RewriteRuleTokenStream stream_OR = new RewriteRuleTokenStream(adaptor, "token OR");
        RewriteRuleSubtreeStream stream_conjunction = new RewriteRuleSubtreeStream(
                adaptor, "rule conjunction");
        RewriteRuleSubtreeStream stream_propertyExpression = new RewriteRuleSubtreeStream(
                adaptor, "rule propertyExpression");
        RewriteRuleSubtreeStream stream_incompleteConjunction = new RewriteRuleSubtreeStream(
                adaptor, "rule incompleteConjunction");
        RewriteRuleSubtreeStream stream_incompleteUnary = new RewriteRuleSubtreeStream(
                adaptor, "rule incompleteUnary");
        RewriteRuleSubtreeStream stream_expression = new RewriteRuleSubtreeStream(
                adaptor, "rule expression");
        try {
            // ManchesterOWLSyntaxAutoCompleteBase.g:90:21: ( ( options
            // {backtrack=true; } : head= propertyExpression ( COMPOSITION
            // rest+= propertyExpression )+ COMPOSITION -> ^(
            // INCOMPLETE_EXPRESSION ^( INCOMPLETE_PROPERTY_CHAIN $head $rest) )
            // | ( conjunction ( OR . )* ) OR incompleteConjunction -> ^(
            // INCOMPLETE_EXPRESSION ^( INCOMPLETE_DISJUNCTION
            // incompleteConjunction ) ) | incompleteConjunction -> ^(
            // INCOMPLETE_EXPRESSION ^( INCOMPLETE_DISJUNCTION
            // incompleteConjunction ) ) | incompleteUnary -> ^(
            // INCOMPLETE_EXPRESSION incompleteUnary ) | expression IDENTIFIER
            // -> ^( INCOMPLETE_EXPRESSION ^( EXPRESSION expression ) IDENTIFIER
            // ) ) )
            // ManchesterOWLSyntaxAutoCompleteBase.g:91:5: ( options
            // {backtrack=true; } : head= propertyExpression ( COMPOSITION
            // rest+= propertyExpression )+ COMPOSITION -> ^(
            // INCOMPLETE_EXPRESSION ^( INCOMPLETE_PROPERTY_CHAIN $head $rest) )
            // | ( conjunction ( OR . )* ) OR incompleteConjunction -> ^(
            // INCOMPLETE_EXPRESSION ^( INCOMPLETE_DISJUNCTION
            // incompleteConjunction ) ) | incompleteConjunction -> ^(
            // INCOMPLETE_EXPRESSION ^( INCOMPLETE_DISJUNCTION
            // incompleteConjunction ) ) | incompleteUnary -> ^(
            // INCOMPLETE_EXPRESSION incompleteUnary ) | expression IDENTIFIER
            // -> ^( INCOMPLETE_EXPRESSION ^( EXPRESSION expression ) IDENTIFIER
            // ) )
            {
                // ManchesterOWLSyntaxAutoCompleteBase.g:91:5: ( options
                // {backtrack=true; } : head= propertyExpression ( COMPOSITION
                // rest+= propertyExpression )+ COMPOSITION -> ^(
                // INCOMPLETE_EXPRESSION ^( INCOMPLETE_PROPERTY_CHAIN $head
                // $rest) ) | ( conjunction ( OR . )* ) OR incompleteConjunction
                // -> ^( INCOMPLETE_EXPRESSION ^( INCOMPLETE_DISJUNCTION
                // incompleteConjunction ) ) | incompleteConjunction -> ^(
                // INCOMPLETE_EXPRESSION ^( INCOMPLETE_DISJUNCTION
                // incompleteConjunction ) ) | incompleteUnary -> ^(
                // INCOMPLETE_EXPRESSION incompleteUnary ) | expression
                // IDENTIFIER -> ^( INCOMPLETE_EXPRESSION ^( EXPRESSION
                // expression ) IDENTIFIER ) )
                int alt8 = 5;
                alt8 = dfa8.predict(input);
                switch (alt8) {
                    case 1:
                    // ManchesterOWLSyntaxAutoCompleteBase.g:93:7: head=
                    // propertyExpression ( COMPOSITION rest+=
                    // propertyExpression )+ COMPOSITION
                    {
                        pushFollow(FOLLOW_propertyExpression_in_incompleteExpression1121);
                        head = gManchesterOWLSyntaxAutoCompleteCombined
                                .propertyExpression();
                        state._fsp--;
                        if (state.failed) {
                            return retval;
                        }
                        if (state.backtracking == 0) {
                            stream_propertyExpression.add(head.getTree());
                        }
                        // ManchesterOWLSyntaxAutoCompleteBase.g:93:33: (
                        // COMPOSITION rest+= propertyExpression )+
                        int cnt6 = 0;
                        loop6: do {
                            int alt6 = 2;
                            int LA6_0 = input.LA(1);
                            if (LA6_0 == COMPOSITION) {
                                int LA6_1 = input.LA(2);
                                if (LA6_1 == INVERSE || LA6_1 >= IDENTIFIER
                                        && LA6_1 <= ENTITY_REFERENCE) {
                                    alt6 = 1;
                                }
                            }
                            switch (alt6) {
                                case 1:
                                // ManchesterOWLSyntaxAutoCompleteBase.g:93:34:
                                // COMPOSITION rest+= propertyExpression
                                {
                                    COMPOSITION21 = (Token) match(input, COMPOSITION,
                                            FOLLOW_COMPOSITION_in_incompleteExpression1124);
                                    if (state.failed) {
                                        return retval;
                                    }
                                    if (state.backtracking == 0) {
                                        stream_COMPOSITION.add(COMPOSITION21);
                                    }
                                    pushFollow(FOLLOW_propertyExpression_in_incompleteExpression1128);
                                    rest = gManchesterOWLSyntaxAutoCompleteCombined
                                            .propertyExpression();
                                    state._fsp--;
                                    if (state.failed) {
                                        return retval;
                                    }
                                    if (state.backtracking == 0) {
                                        stream_propertyExpression.add(rest.getTree());
                                    }
                                    if (list_rest == null) {
                                        list_rest = new ArrayList<Object>();
                                    }
                                    if (rest != null) {
                                        list_rest.add(rest.getTree());
                                    }
                                }
                                    break;
                                default:
                                    if (cnt6 >= 1) {
                                        break loop6;
                                    }
                                    if (state.backtracking > 0) {
                                        state.failed = true;
                                        return retval;
                                    }
                                    EarlyExitException eee = new EarlyExitException(6,
                                            input);
                                    throw eee;
                            }
                            cnt6++;
                        } while (true);
                        COMPOSITION22 = (Token) match(input, COMPOSITION,
                                FOLLOW_COMPOSITION_in_incompleteExpression1133);
                        if (state.failed) {
                            return retval;
                        }
                        if (state.backtracking == 0) {
                            stream_COMPOSITION.add(COMPOSITION22);
                        }
                        // AST REWRITE
                        // elements: rest, head
                        // token labels:
                        // rule labels: head, retval
                        // token list labels:
                        // rule list labels: rest
                        // wildcard labels:
                        if (state.backtracking == 0) {
                            retval.tree = root_0;
                            RewriteRuleSubtreeStream stream_head = new RewriteRuleSubtreeStream(
                                    adaptor, "rule head", head != null ? head.tree : null);
                            RewriteRuleSubtreeStream stream_rest = new RewriteRuleSubtreeStream(
                                    adaptor, "token rest", list_rest);
                            root_0 = (ManchesterOWLSyntaxTree) adaptor.nil();
                            // 93:87: -> ^( INCOMPLETE_EXPRESSION ^(
                            // INCOMPLETE_PROPERTY_CHAIN $head $rest) )
                            {
                                // ManchesterOWLSyntaxAutoCompleteBase.g:93:90:
                                // ^( INCOMPLETE_EXPRESSION ^(
                                // INCOMPLETE_PROPERTY_CHAIN $head $rest) )
                                {
                                    ManchesterOWLSyntaxTree root_1 = (ManchesterOWLSyntaxTree) adaptor
                                            .nil();
                                    root_1 = (ManchesterOWLSyntaxTree) adaptor
                                            .becomeRoot(adaptor.create(
                                                    INCOMPLETE_EXPRESSION,
                                                    "INCOMPLETE_EXPRESSION"), root_1);
                                    // ManchesterOWLSyntaxAutoCompleteBase.g:93:114:
                                    // ^( INCOMPLETE_PROPERTY_CHAIN $head $rest)
                                    {
                                        ManchesterOWLSyntaxTree root_2 = (ManchesterOWLSyntaxTree) adaptor
                                                .nil();
                                        root_2 = (ManchesterOWLSyntaxTree) adaptor
                                                .becomeRoot(adaptor.create(
                                                        INCOMPLETE_PROPERTY_CHAIN,
                                                        "INCOMPLETE_PROPERTY_CHAIN"),
                                                        root_2);
                                        adaptor.addChild(root_2, stream_head.nextTree());
                                        adaptor.addChild(root_2, stream_rest.nextTree());
                                        adaptor.addChild(root_1, root_2);
                                    }
                                    adaptor.addChild(root_0, root_1);
                                }
                            }
                            retval.tree = root_0;
                        }
                    }
                        break;
                    case 2:
                    // ManchesterOWLSyntaxAutoCompleteBase.g:94:9: ( conjunction
                    // ( OR . )* ) OR incompleteConjunction
                    {
                        // ManchesterOWLSyntaxAutoCompleteBase.g:94:9: (
                        // conjunction ( OR . )* )
                        // ManchesterOWLSyntaxAutoCompleteBase.g:94:10:
                        // conjunction ( OR . )*
                        {
                            pushFollow(FOLLOW_conjunction_in_incompleteExpression1162);
                            conjunction23 = gManchesterOWLSyntaxAutoCompleteCombined
                                    .conjunction();
                            state._fsp--;
                            if (state.failed) {
                                return retval;
                            }
                            if (state.backtracking == 0) {
                                stream_conjunction.add(conjunction23.getTree());
                            }
                            // ManchesterOWLSyntaxAutoCompleteBase.g:94:22: ( OR
                            // . )*
                            loop7: do {
                                int alt7 = 2;
                                alt7 = dfa7.predict(input);
                                switch (alt7) {
                                    case 1:
                                    // ManchesterOWLSyntaxAutoCompleteBase.g:94:23:
                                    // OR .
                                    {
                                        OR24 = (Token) match(input, OR,
                                                FOLLOW_OR_in_incompleteExpression1165);
                                        if (state.failed) {
                                            return retval;
                                        }
                                        if (state.backtracking == 0) {
                                            stream_OR.add(OR24);
                                        }
                                        wildcard25 = input.LT(1);
                                        matchAny(input);
                                        if (state.failed) {
                                            return retval;
                                        }
                                        if (state.backtracking == 0) {
                                            wildcard25_tree = (ManchesterOWLSyntaxTree) adaptor
                                                    .create(wildcard25);
                                            adaptor.addChild(root_0, wildcard25_tree);
                                        }
                                    }
                                        break;
                                    default:
                                        break loop7;
                                }
                            } while (true);
                        }
                        OR26 = (Token) match(input, OR,
                                FOLLOW_OR_in_incompleteExpression1172);
                        if (state.failed) {
                            return retval;
                        }
                        if (state.backtracking == 0) {
                            stream_OR.add(OR26);
                        }
                        pushFollow(FOLLOW_incompleteConjunction_in_incompleteExpression1175);
                        incompleteConjunction27 = incompleteConjunction();
                        state._fsp--;
                        if (state.failed) {
                            return retval;
                        }
                        if (state.backtracking == 0) {
                            stream_incompleteConjunction.add(incompleteConjunction27
                                    .getTree());
                        }
                        // AST REWRITE
                        // elements: incompleteConjunction
                        // token labels:
                        // rule labels: retval
                        // token list labels:
                        // rule list labels:
                        // wildcard labels:
                        if (state.backtracking == 0) {
                            retval.tree = root_0;
                            root_0 = (ManchesterOWLSyntaxTree) adaptor.nil();
                            // 94:58: -> ^( INCOMPLETE_EXPRESSION ^(
                            // INCOMPLETE_DISJUNCTION incompleteConjunction ) )
                            {
                                // ManchesterOWLSyntaxAutoCompleteBase.g:94:61:
                                // ^( INCOMPLETE_EXPRESSION ^(
                                // INCOMPLETE_DISJUNCTION incompleteConjunction
                                // ) )
                                {
                                    ManchesterOWLSyntaxTree root_1 = (ManchesterOWLSyntaxTree) adaptor
                                            .nil();
                                    root_1 = (ManchesterOWLSyntaxTree) adaptor
                                            .becomeRoot(adaptor.create(
                                                    INCOMPLETE_EXPRESSION,
                                                    "INCOMPLETE_EXPRESSION"), root_1);
                                    // ManchesterOWLSyntaxAutoCompleteBase.g:94:85:
                                    // ^( INCOMPLETE_DISJUNCTION
                                    // incompleteConjunction )
                                    {
                                        ManchesterOWLSyntaxTree root_2 = (ManchesterOWLSyntaxTree) adaptor
                                                .nil();
                                        root_2 = (ManchesterOWLSyntaxTree) adaptor
                                                .becomeRoot(adaptor.create(
                                                        INCOMPLETE_DISJUNCTION,
                                                        "INCOMPLETE_DISJUNCTION"), root_2);
                                        adaptor.addChild(root_2,
                                                stream_incompleteConjunction.nextTree());
                                        adaptor.addChild(root_1, root_2);
                                    }
                                    adaptor.addChild(root_0, root_1);
                                }
                            }
                            retval.tree = root_0;
                        }
                    }
                        break;
                    case 3:
                    // ManchesterOWLSyntaxAutoCompleteBase.g:95:9:
                    // incompleteConjunction
                    {
                        pushFollow(FOLLOW_incompleteConjunction_in_incompleteExpression1199);
                        incompleteConjunction28 = incompleteConjunction();
                        state._fsp--;
                        if (state.failed) {
                            return retval;
                        }
                        if (state.backtracking == 0) {
                            stream_incompleteConjunction.add(incompleteConjunction28
                                    .getTree());
                        }
                        // AST REWRITE
                        // elements: incompleteConjunction
                        // token labels:
                        // rule labels: retval
                        // token list labels:
                        // rule list labels:
                        // wildcard labels:
                        if (state.backtracking == 0) {
                            retval.tree = root_0;
                            root_0 = (ManchesterOWLSyntaxTree) adaptor.nil();
                            // 95:31: -> ^( INCOMPLETE_EXPRESSION ^(
                            // INCOMPLETE_DISJUNCTION incompleteConjunction ) )
                            {
                                // ManchesterOWLSyntaxAutoCompleteBase.g:95:34:
                                // ^( INCOMPLETE_EXPRESSION ^(
                                // INCOMPLETE_DISJUNCTION incompleteConjunction
                                // ) )
                                {
                                    ManchesterOWLSyntaxTree root_1 = (ManchesterOWLSyntaxTree) adaptor
                                            .nil();
                                    root_1 = (ManchesterOWLSyntaxTree) adaptor
                                            .becomeRoot(adaptor.create(
                                                    INCOMPLETE_EXPRESSION,
                                                    "INCOMPLETE_EXPRESSION"), root_1);
                                    // ManchesterOWLSyntaxAutoCompleteBase.g:95:58:
                                    // ^( INCOMPLETE_DISJUNCTION
                                    // incompleteConjunction )
                                    {
                                        ManchesterOWLSyntaxTree root_2 = (ManchesterOWLSyntaxTree) adaptor
                                                .nil();
                                        root_2 = (ManchesterOWLSyntaxTree) adaptor
                                                .becomeRoot(adaptor.create(
                                                        INCOMPLETE_DISJUNCTION,
                                                        "INCOMPLETE_DISJUNCTION"), root_2);
                                        adaptor.addChild(root_2,
                                                stream_incompleteConjunction.nextTree());
                                        adaptor.addChild(root_1, root_2);
                                    }
                                    adaptor.addChild(root_0, root_1);
                                }
                            }
                            retval.tree = root_0;
                        }
                    }
                        break;
                    case 4:
                    // ManchesterOWLSyntaxAutoCompleteBase.g:96:9:
                    // incompleteUnary
                    {
                        pushFollow(FOLLOW_incompleteUnary_in_incompleteExpression1223);
                        incompleteUnary29 = incompleteUnary();
                        state._fsp--;
                        if (state.failed) {
                            return retval;
                        }
                        if (state.backtracking == 0) {
                            stream_incompleteUnary.add(incompleteUnary29.getTree());
                        }
                        // AST REWRITE
                        // elements: incompleteUnary
                        // token labels:
                        // rule labels: retval
                        // token list labels:
                        // rule list labels:
                        // wildcard labels:
                        if (state.backtracking == 0) {
                            retval.tree = root_0;
                            root_0 = (ManchesterOWLSyntaxTree) adaptor.nil();
                            // 96:25: -> ^( INCOMPLETE_EXPRESSION
                            // incompleteUnary )
                            {
                                // ManchesterOWLSyntaxAutoCompleteBase.g:96:28:
                                // ^( INCOMPLETE_EXPRESSION incompleteUnary )
                                {
                                    ManchesterOWLSyntaxTree root_1 = (ManchesterOWLSyntaxTree) adaptor
                                            .nil();
                                    root_1 = (ManchesterOWLSyntaxTree) adaptor
                                            .becomeRoot(adaptor.create(
                                                    INCOMPLETE_EXPRESSION,
                                                    "INCOMPLETE_EXPRESSION"), root_1);
                                    adaptor.addChild(root_1,
                                            stream_incompleteUnary.nextTree());
                                    adaptor.addChild(root_0, root_1);
                                }
                            }
                            retval.tree = root_0;
                        }
                    }
                        break;
                    case 5:
                    // ManchesterOWLSyntaxAutoCompleteBase.g:97:9: expression
                    // IDENTIFIER
                    {
                        pushFollow(FOLLOW_expression_in_incompleteExpression1241);
                        expression30 = gManchesterOWLSyntaxAutoCompleteCombined
                                .expression();
                        state._fsp--;
                        if (state.failed) {
                            return retval;
                        }
                        if (state.backtracking == 0) {
                            stream_expression.add(expression30.getTree());
                        }
                        IDENTIFIER31 = (Token) match(input, IDENTIFIER,
                                FOLLOW_IDENTIFIER_in_incompleteExpression1243);
                        if (state.failed) {
                            return retval;
                        }
                        if (state.backtracking == 0) {
                            stream_IDENTIFIER.add(IDENTIFIER31);
                        }
                        // AST REWRITE
                        // elements: expression, IDENTIFIER
                        // token labels:
                        // rule labels: retval
                        // token list labels:
                        // rule list labels:
                        // wildcard labels:
                        if (state.backtracking == 0) {
                            retval.tree = root_0;
                            root_0 = (ManchesterOWLSyntaxTree) adaptor.nil();
                            // 97:31: -> ^( INCOMPLETE_EXPRESSION ^( EXPRESSION
                            // expression ) IDENTIFIER )
                            {
                                // ManchesterOWLSyntaxAutoCompleteBase.g:97:33:
                                // ^( INCOMPLETE_EXPRESSION ^( EXPRESSION
                                // expression ) IDENTIFIER )
                                {
                                    ManchesterOWLSyntaxTree root_1 = (ManchesterOWLSyntaxTree) adaptor
                                            .nil();
                                    root_1 = (ManchesterOWLSyntaxTree) adaptor
                                            .becomeRoot(adaptor.create(
                                                    INCOMPLETE_EXPRESSION,
                                                    "INCOMPLETE_EXPRESSION"), root_1);
                                    // ManchesterOWLSyntaxAutoCompleteBase.g:97:57:
                                    // ^( EXPRESSION expression )
                                    {
                                        ManchesterOWLSyntaxTree root_2 = (ManchesterOWLSyntaxTree) adaptor
                                                .nil();
                                        root_2 = (ManchesterOWLSyntaxTree) adaptor
                                                .becomeRoot(adaptor.create(EXPRESSION,
                                                        "EXPRESSION"), root_2);
                                        adaptor.addChild(root_2,
                                                stream_expression.nextTree());
                                        adaptor.addChild(root_1, root_2);
                                    }
                                    adaptor.addChild(root_1, stream_IDENTIFIER.nextNode());
                                    adaptor.addChild(root_0, root_1);
                                }
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
        } catch (RecognitionException re) {
            reportError(re);
            recover(input, re);
            retval.tree = (ManchesterOWLSyntaxTree) adaptor.errorNode(input,
                    retval.start, input.LT(-1), re);
        } finally {}
        return retval;
    }

    // $ANTLR end "incompleteExpression"
    public static class incompleteConjunction_return extends ParserRuleReturnScope {
        ManchesterOWLSyntaxTree tree;

        @Override
        public Object getTree() {
            return tree;
        }
    }

    // $ANTLR start "incompleteConjunction"
    // ManchesterOWLSyntaxAutoCompleteBase.g:101:1: incompleteConjunction : (
    // unary ( AND . )* ) AND ( incompleteUnary )? -> ^( INCOMPLETE_CONJUNCTION
    // ( ^( incompleteUnary ) )? ) ;
    public final
            ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase.incompleteConjunction_return
            incompleteConjunction() {
        ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase.incompleteConjunction_return retval = new ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase.incompleteConjunction_return();
        retval.start = input.LT(1);
        ManchesterOWLSyntaxTree root_0 = null;
        Token AND33 = null;
        Token wildcard34 = null;
        Token AND35 = null;
        ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase_MOWLParser.unary_return unary32 = null;
        ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase.incompleteUnary_return incompleteUnary36 = null;
        ManchesterOWLSyntaxTree wildcard34_tree = null;
        RewriteRuleTokenStream stream_AND = new RewriteRuleTokenStream(adaptor,
                "token AND");
        RewriteRuleSubtreeStream stream_incompleteUnary = new RewriteRuleSubtreeStream(
                adaptor, "rule incompleteUnary");
        RewriteRuleSubtreeStream stream_unary = new RewriteRuleSubtreeStream(adaptor,
                "rule unary");
        try {
            // ManchesterOWLSyntaxAutoCompleteBase.g:101:24: ( ( unary ( AND .
            // )* ) AND ( incompleteUnary )? -> ^( INCOMPLETE_CONJUNCTION ( ^(
            // incompleteUnary ) )? ) )
            // ManchesterOWLSyntaxAutoCompleteBase.g:102:9: ( unary ( AND . )* )
            // AND ( incompleteUnary )?
            {
                // ManchesterOWLSyntaxAutoCompleteBase.g:102:9: ( unary ( AND .
                // )* )
                // ManchesterOWLSyntaxAutoCompleteBase.g:102:10: unary ( AND .
                // )*
                {
                    pushFollow(FOLLOW_unary_in_incompleteConjunction1293);
                    unary32 = gManchesterOWLSyntaxAutoCompleteCombined.unary();
                    state._fsp--;
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        stream_unary.add(unary32.getTree());
                    }
                    // ManchesterOWLSyntaxAutoCompleteBase.g:102:16: ( AND . )*
                    loop9: do {
                        int alt9 = 2;
                        int LA9_0 = input.LA(1);
                        if (LA9_0 == AND) {
                            int LA9_1 = input.LA(2);
                            if (LA9_1 == NOT) {
                                int LA9_2 = input.LA(3);
                                if (LA9_2 == AND) {
                                    alt9 = 1;
                                }
                            } else if (LA9_1 == IDENTIFIER) {
                                int LA9_3 = input.LA(3);
                                if (LA9_3 == AND) {
                                    alt9 = 1;
                                }
                            } else if (LA9_1 == ENTITY_REFERENCE) {
                                int LA9_4 = input.LA(3);
                                if (LA9_4 == AND) {
                                    alt9 = 1;
                                }
                            } else if (LA9_1 == INVERSE) {
                                int LA9_5 = input.LA(3);
                                if (LA9_5 == AND) {
                                    alt9 = 1;
                                }
                            } else if (LA9_1 == OPEN_CURLY_BRACES) {
                                int LA9_6 = input.LA(3);
                                if (LA9_6 == AND) {
                                    alt9 = 1;
                                }
                            } else if (LA9_1 >= COMPOSITION && LA9_1 <= OPEN_PARENTHESYS
                                    || LA9_1 >= CLOSED_CURLY_BRACES && LA9_1 <= OR
                                    || LA9_1 >= SOME && LA9_1 <= VALUE
                                    || LA9_1 >= SUBCLASS_OF && LA9_1 <= LETTER
                                    || LA9_1 >= QUESTION_MARK && LA9_1 <= 724) {
                                alt9 = 1;
                            }
                        }
                        switch (alt9) {
                            case 1:
                            // ManchesterOWLSyntaxAutoCompleteBase.g:102:17: AND
                            // .
                            {
                                AND33 = (Token) match(input, AND,
                                        FOLLOW_AND_in_incompleteConjunction1296);
                                if (state.failed) {
                                    return retval;
                                }
                                if (state.backtracking == 0) {
                                    stream_AND.add(AND33);
                                }
                                wildcard34 = input.LT(1);
                                matchAny(input);
                                if (state.failed) {
                                    return retval;
                                }
                                if (state.backtracking == 0) {
                                    wildcard34_tree = (ManchesterOWLSyntaxTree) adaptor
                                            .create(wildcard34);
                                    adaptor.addChild(root_0, wildcard34_tree);
                                }
                            }
                                break;
                            default:
                                break loop9;
                        }
                    } while (true);
                }
                AND35 = (Token) match(input, AND, FOLLOW_AND_in_incompleteConjunction1305);
                if (state.failed) {
                    return retval;
                }
                if (state.backtracking == 0) {
                    stream_AND.add(AND35);
                }
                // ManchesterOWLSyntaxAutoCompleteBase.g:102:32: (
                // incompleteUnary )?
                int alt10 = 2;
                int LA10_0 = input.LA(1);
                if (LA10_0 == OPEN_CURLY_BRACES || LA10_0 == NOT || LA10_0 == INVERSE
                        || LA10_0 >= IDENTIFIER && LA10_0 <= ENTITY_REFERENCE) {
                    alt10 = 1;
                }
                switch (alt10) {
                    case 1:
                    // ManchesterOWLSyntaxAutoCompleteBase.g:102:32:
                    // incompleteUnary
                    {
                        pushFollow(FOLLOW_incompleteUnary_in_incompleteConjunction1307);
                        incompleteUnary36 = incompleteUnary();
                        state._fsp--;
                        if (state.failed) {
                            return retval;
                        }
                        if (state.backtracking == 0) {
                            stream_incompleteUnary.add(incompleteUnary36.getTree());
                        }
                    }
                        break;
                }
                // AST REWRITE
                // elements: incompleteUnary
                // token labels:
                // rule labels: retval
                // token list labels:
                // rule list labels:
                // wildcard labels:
                if (state.backtracking == 0) {
                    retval.tree = root_0;
                    root_0 = (ManchesterOWLSyntaxTree) adaptor.nil();
                    // 102:49: -> ^( INCOMPLETE_CONJUNCTION ( ^( incompleteUnary
                    // ) )? )
                    {
                        // ManchesterOWLSyntaxAutoCompleteBase.g:102:52: ^(
                        // INCOMPLETE_CONJUNCTION ( ^( incompleteUnary ) )? )
                        {
                            ManchesterOWLSyntaxTree root_1 = (ManchesterOWLSyntaxTree) adaptor
                                    .nil();
                            root_1 = (ManchesterOWLSyntaxTree) adaptor.becomeRoot(adaptor
                                    .create(INCOMPLETE_CONJUNCTION,
                                            "INCOMPLETE_CONJUNCTION"), root_1);
                            // ManchesterOWLSyntaxAutoCompleteBase.g:102:78: (
                            // ^( incompleteUnary ) )?
                            if (stream_incompleteUnary.hasNext()) {
                                // ManchesterOWLSyntaxAutoCompleteBase.g:102:78:
                                // ^( incompleteUnary )
                                {
                                    ManchesterOWLSyntaxTree root_2 = (ManchesterOWLSyntaxTree) adaptor
                                            .nil();
                                    root_2 = (ManchesterOWLSyntaxTree) adaptor
                                            .becomeRoot(
                                                    stream_incompleteUnary.nextNode(),
                                                    root_2);
                                    adaptor.addChild(root_1, root_2);
                                }
                            }
                            stream_incompleteUnary.reset();
                            adaptor.addChild(root_0, root_1);
                        }
                    }
                    retval.tree = root_0;
                }
            }
            retval.stop = input.LT(-1);
            if (state.backtracking == 0) {
                retval.tree = (ManchesterOWLSyntaxTree) adaptor
                        .rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        } catch (RecognitionException re) {
            reportError(re);
            recover(input, re);
            retval.tree = (ManchesterOWLSyntaxTree) adaptor.errorNode(input,
                    retval.start, input.LT(-1), re);
        } finally {}
        return retval;
    }

    // $ANTLR end "incompleteConjunction"
    public static class incompleteComplexPropertyExpression_return extends
            ParserRuleReturnScope {
        ManchesterOWLSyntaxTree tree;

        @Override
        public Object getTree() {
            return tree;
        }
    }

    // $ANTLR start "incompleteComplexPropertyExpression"
    // ManchesterOWLSyntaxAutoCompleteBase.g:105:1:
    // incompleteComplexPropertyExpression : INVERSE OPEN_PARENTHESYS -> ^(
    // INCOMPLETE_INVERSE_OBJECT_PROPERTY_EXPRESSION ) ;
    public final
            ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase.incompleteComplexPropertyExpression_return
            incompleteComplexPropertyExpression() {
        ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase.incompleteComplexPropertyExpression_return retval = new ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase.incompleteComplexPropertyExpression_return();
        retval.start = input.LT(1);
        ManchesterOWLSyntaxTree root_0 = null;
        Token INVERSE37 = null;
        Token OPEN_PARENTHESYS38 = null;
        RewriteRuleTokenStream stream_INVERSE = new RewriteRuleTokenStream(adaptor,
                "token INVERSE");
        RewriteRuleTokenStream stream_OPEN_PARENTHESYS = new RewriteRuleTokenStream(
                adaptor, "token OPEN_PARENTHESYS");
        try {
            // ManchesterOWLSyntaxAutoCompleteBase.g:105:36: ( INVERSE
            // OPEN_PARENTHESYS -> ^(
            // INCOMPLETE_INVERSE_OBJECT_PROPERTY_EXPRESSION ) )
            // ManchesterOWLSyntaxAutoCompleteBase.g:106:4: INVERSE
            // OPEN_PARENTHESYS
            {
                INVERSE37 = (Token) match(input, INVERSE,
                        FOLLOW_INVERSE_in_incompleteComplexPropertyExpression1342);
                if (state.failed) {
                    return retval;
                }
                if (state.backtracking == 0) {
                    stream_INVERSE.add(INVERSE37);
                }
                OPEN_PARENTHESYS38 = (Token) match(input, OPEN_PARENTHESYS,
                        FOLLOW_OPEN_PARENTHESYS_in_incompleteComplexPropertyExpression1344);
                if (state.failed) {
                    return retval;
                }
                if (state.backtracking == 0) {
                    stream_OPEN_PARENTHESYS.add(OPEN_PARENTHESYS38);
                }
                // AST REWRITE
                // elements:
                // token labels:
                // rule labels: retval
                // token list labels:
                // rule list labels:
                // wildcard labels:
                if (state.backtracking == 0) {
                    retval.tree = root_0;
                    root_0 = (ManchesterOWLSyntaxTree) adaptor.nil();
                    // 106:29: -> ^(
                    // INCOMPLETE_INVERSE_OBJECT_PROPERTY_EXPRESSION )
                    {
                        // ManchesterOWLSyntaxAutoCompleteBase.g:106:32: ^(
                        // INCOMPLETE_INVERSE_OBJECT_PROPERTY_EXPRESSION )
                        {
                            ManchesterOWLSyntaxTree root_1 = (ManchesterOWLSyntaxTree) adaptor
                                    .nil();
                            root_1 = (ManchesterOWLSyntaxTree) adaptor
                                    .becomeRoot(
                                            adaptor.create(
                                                    INCOMPLETE_INVERSE_OBJECT_PROPERTY_EXPRESSION,
                                                    "INCOMPLETE_INVERSE_OBJECT_PROPERTY_EXPRESSION"),
                                            root_1);
                            adaptor.addChild(root_0, root_1);
                        }
                    }
                    retval.tree = root_0;
                }
            }
            retval.stop = input.LT(-1);
            if (state.backtracking == 0) {
                retval.tree = (ManchesterOWLSyntaxTree) adaptor
                        .rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        } catch (RecognitionException re) {
            reportError(re);
            recover(input, re);
            retval.tree = (ManchesterOWLSyntaxTree) adaptor.errorNode(input,
                    retval.start, input.LT(-1), re);
        } finally {}
        return retval;
    }

    // $ANTLR end "incompleteComplexPropertyExpression"
    public static class incompleteUnary_return extends ParserRuleReturnScope {
        ManchesterOWLSyntaxTree tree;

        @Override
        public Object getTree() {
            return tree;
        }
    }

    // $ANTLR start "incompleteUnary"
    // ManchesterOWLSyntaxAutoCompleteBase.g:109:1: incompleteUnary : ( NOT
    // OPEN_PARENTHESYS -> ^( INCOMPLETE_NEGATED_EXPRESSION ) |
    // incompleteQualifiedRestriction -> incompleteQualifiedRestriction );
    public final
            ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase.incompleteUnary_return
            incompleteUnary() {
        ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase.incompleteUnary_return retval = new ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase.incompleteUnary_return();
        retval.start = input.LT(1);
        ManchesterOWLSyntaxTree root_0 = null;
        Token NOT39 = null;
        Token OPEN_PARENTHESYS40 = null;
        ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase.incompleteQualifiedRestriction_return incompleteQualifiedRestriction41 = null;
        RewriteRuleTokenStream stream_NOT = new RewriteRuleTokenStream(adaptor,
                "token NOT");
        RewriteRuleTokenStream stream_OPEN_PARENTHESYS = new RewriteRuleTokenStream(
                adaptor, "token OPEN_PARENTHESYS");
        RewriteRuleSubtreeStream stream_incompleteQualifiedRestriction = new RewriteRuleSubtreeStream(
                adaptor, "rule incompleteQualifiedRestriction");
        try {
            // ManchesterOWLSyntaxAutoCompleteBase.g:109:17: ( NOT
            // OPEN_PARENTHESYS -> ^( INCOMPLETE_NEGATED_EXPRESSION ) |
            // incompleteQualifiedRestriction -> incompleteQualifiedRestriction
            // )
            int alt11 = 2;
            int LA11_0 = input.LA(1);
            if (LA11_0 == NOT) {
                alt11 = 1;
            } else if (LA11_0 == OPEN_CURLY_BRACES || LA11_0 == INVERSE
                    || LA11_0 >= IDENTIFIER && LA11_0 <= ENTITY_REFERENCE) {
                alt11 = 2;
            } else {
                if (state.backtracking > 0) {
                    state.failed = true;
                    return retval;
                }
                NoViableAltException nvae = new NoViableAltException("", 11, 0, input);
                throw nvae;
            }
            switch (alt11) {
                case 1:
                // ManchesterOWLSyntaxAutoCompleteBase.g:110:5: NOT
                // OPEN_PARENTHESYS
                {
                    NOT39 = (Token) match(input, NOT, FOLLOW_NOT_in_incompleteUnary1371);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        stream_NOT.add(NOT39);
                    }
                    OPEN_PARENTHESYS40 = (Token) match(input, OPEN_PARENTHESYS,
                            FOLLOW_OPEN_PARENTHESYS_in_incompleteUnary1373);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        stream_OPEN_PARENTHESYS.add(OPEN_PARENTHESYS40);
                    }
                    // AST REWRITE
                    // elements:
                    // token labels:
                    // rule labels: retval
                    // token list labels:
                    // rule list labels:
                    // wildcard labels:
                    if (state.backtracking == 0) {
                        retval.tree = root_0;
                        root_0 = (ManchesterOWLSyntaxTree) adaptor.nil();
                        // 110:27: -> ^( INCOMPLETE_NEGATED_EXPRESSION )
                        {
                            // ManchesterOWLSyntaxAutoCompleteBase.g:110:30: ^(
                            // INCOMPLETE_NEGATED_EXPRESSION )
                            {
                                ManchesterOWLSyntaxTree root_1 = (ManchesterOWLSyntaxTree) adaptor
                                        .nil();
                                root_1 = (ManchesterOWLSyntaxTree) adaptor.becomeRoot(
                                        adaptor.create(INCOMPLETE_NEGATED_EXPRESSION,
                                                "INCOMPLETE_NEGATED_EXPRESSION"), root_1);
                                adaptor.addChild(root_0, root_1);
                            }
                        }
                        retval.tree = root_0;
                    }
                }
                    break;
                case 2:
                // ManchesterOWLSyntaxAutoCompleteBase.g:111:7:
                // incompleteQualifiedRestriction
                {
                    pushFollow(FOLLOW_incompleteQualifiedRestriction_in_incompleteUnary1406);
                    incompleteQualifiedRestriction41 = incompleteQualifiedRestriction();
                    state._fsp--;
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        stream_incompleteQualifiedRestriction
                                .add(incompleteQualifiedRestriction41.getTree());
                    }
                    // AST REWRITE
                    // elements: incompleteQualifiedRestriction
                    // token labels:
                    // rule labels: retval
                    // token list labels:
                    // rule list labels:
                    // wildcard labels:
                    if (state.backtracking == 0) {
                        retval.tree = root_0;
                        root_0 = (ManchesterOWLSyntaxTree) adaptor.nil();
                        // 111:38: -> incompleteQualifiedRestriction
                        {
                            adaptor.addChild(root_0,
                                    stream_incompleteQualifiedRestriction.nextTree());
                        }
                        retval.tree = root_0;
                    }
                }
                    break;
            }
            retval.stop = input.LT(-1);
            if (state.backtracking == 0) {
                retval.tree = (ManchesterOWLSyntaxTree) adaptor
                        .rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        } catch (RecognitionException re) {
            reportError(re);
            recover(input, re);
            retval.tree = (ManchesterOWLSyntaxTree) adaptor.errorNode(input,
                    retval.start, input.LT(-1), re);
        } finally {}
        return retval;
    }

    // $ANTLR end "incompleteUnary"
    public static class incompleteQualifiedRestriction_return extends
            ParserRuleReturnScope {
        ManchesterOWLSyntaxTree tree;

        @Override
        public Object getTree() {
            return tree;
        }
    }

    // $ANTLR start "incompleteQualifiedRestriction"
    // ManchesterOWLSyntaxAutoCompleteBase.g:114:1:
    // incompleteQualifiedRestriction : ( options {backtrack=true; } :
    // propertyExpression SOME -> ^( INCOMPLETE_SOME_RESTRICTION
    // propertyExpression ) | propertyExpression ONLY -> ^(
    // INCOMPLETE_ALL_RESTRICTION propertyExpression ) | incompleteOneOf -> ^(
    // incompleteOneOf ) | incompleteCardinalityRestriction ->
    // incompleteCardinalityRestriction | incompleteValueRestriction ->
    // incompleteValueRestriction ) ;
    public final
            ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase.incompleteQualifiedRestriction_return
            incompleteQualifiedRestriction() {
        ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase.incompleteQualifiedRestriction_return retval = new ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase.incompleteQualifiedRestriction_return();
        retval.start = input.LT(1);
        ManchesterOWLSyntaxTree root_0 = null;
        Token SOME43 = null;
        Token ONLY45 = null;
        ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase_MOWLParser.propertyExpression_return propertyExpression42 = null;
        ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase_MOWLParser.propertyExpression_return propertyExpression44 = null;
        ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase.incompleteOneOf_return incompleteOneOf46 = null;
        ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase.incompleteCardinalityRestriction_return incompleteCardinalityRestriction47 = null;
        ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase.incompleteValueRestriction_return incompleteValueRestriction48 = null;
        RewriteRuleTokenStream stream_SOME = new RewriteRuleTokenStream(adaptor,
                "token SOME");
        RewriteRuleTokenStream stream_ONLY = new RewriteRuleTokenStream(adaptor,
                "token ONLY");
        RewriteRuleSubtreeStream stream_propertyExpression = new RewriteRuleSubtreeStream(
                adaptor, "rule propertyExpression");
        RewriteRuleSubtreeStream stream_incompleteCardinalityRestriction = new RewriteRuleSubtreeStream(
                adaptor, "rule incompleteCardinalityRestriction");
        RewriteRuleSubtreeStream stream_incompleteOneOf = new RewriteRuleSubtreeStream(
                adaptor, "rule incompleteOneOf");
        RewriteRuleSubtreeStream stream_incompleteValueRestriction = new RewriteRuleSubtreeStream(
                adaptor, "rule incompleteValueRestriction");
        try {
            // ManchesterOWLSyntaxAutoCompleteBase.g:114:31: ( ( options
            // {backtrack=true; } : propertyExpression SOME -> ^(
            // INCOMPLETE_SOME_RESTRICTION propertyExpression ) |
            // propertyExpression ONLY -> ^( INCOMPLETE_ALL_RESTRICTION
            // propertyExpression ) | incompleteOneOf -> ^( incompleteOneOf ) |
            // incompleteCardinalityRestriction ->
            // incompleteCardinalityRestriction | incompleteValueRestriction ->
            // incompleteValueRestriction ) )
            // ManchesterOWLSyntaxAutoCompleteBase.g:115:1: ( options
            // {backtrack=true; } : propertyExpression SOME -> ^(
            // INCOMPLETE_SOME_RESTRICTION propertyExpression ) |
            // propertyExpression ONLY -> ^( INCOMPLETE_ALL_RESTRICTION
            // propertyExpression ) | incompleteOneOf -> ^( incompleteOneOf ) |
            // incompleteCardinalityRestriction ->
            // incompleteCardinalityRestriction | incompleteValueRestriction ->
            // incompleteValueRestriction )
            {
                // ManchesterOWLSyntaxAutoCompleteBase.g:115:1: ( options
                // {backtrack=true; } : propertyExpression SOME -> ^(
                // INCOMPLETE_SOME_RESTRICTION propertyExpression ) |
                // propertyExpression ONLY -> ^( INCOMPLETE_ALL_RESTRICTION
                // propertyExpression ) | incompleteOneOf -> ^( incompleteOneOf
                // ) | incompleteCardinalityRestriction ->
                // incompleteCardinalityRestriction | incompleteValueRestriction
                // -> incompleteValueRestriction )
                int alt12 = 5;
                switch (input.LA(1)) {
                    case IDENTIFIER: {
                        input.LA(2);
                        if (synpred5_ManchesterOWLSyntaxAutoCompleteBase()) {
                            alt12 = 1;
                        } else if (synpred6_ManchesterOWLSyntaxAutoCompleteBase()) {
                            alt12 = 2;
                        } else if (synpred8_ManchesterOWLSyntaxAutoCompleteBase()) {
                            alt12 = 4;
                        } else {
                            alt12 = 5;
                        }
                    }
                        break;
                    case ENTITY_REFERENCE: {
                        input.LA(2);
                        if (synpred5_ManchesterOWLSyntaxAutoCompleteBase()) {
                            alt12 = 1;
                        } else if (synpred6_ManchesterOWLSyntaxAutoCompleteBase()) {
                            alt12 = 2;
                        } else if (synpred8_ManchesterOWLSyntaxAutoCompleteBase()) {
                            alt12 = 4;
                        } else {
                            alt12 = 5;
                        }
                    }
                        break;
                    case INVERSE: {
                        input.LA(2);
                        if (synpred5_ManchesterOWLSyntaxAutoCompleteBase()) {
                            alt12 = 1;
                        } else if (synpred6_ManchesterOWLSyntaxAutoCompleteBase()) {
                            alt12 = 2;
                        } else if (synpred8_ManchesterOWLSyntaxAutoCompleteBase()) {
                            alt12 = 4;
                        } else {
                            alt12 = 5;
                        }
                    }
                        break;
                    case OPEN_CURLY_BRACES: {
                        alt12 = 3;
                    }
                        break;
                    default:
                        if (state.backtracking > 0) {
                            state.failed = true;
                            return retval;
                        }
                        NoViableAltException nvae = new NoViableAltException("", 12, 0,
                                input);
                        throw nvae;
                }
                switch (alt12) {
                    case 1:
                    // ManchesterOWLSyntaxAutoCompleteBase.g:116:11:
                    // propertyExpression SOME
                    {
                        pushFollow(FOLLOW_propertyExpression_in_incompleteQualifiedRestriction1448);
                        propertyExpression42 = gManchesterOWLSyntaxAutoCompleteCombined
                                .propertyExpression();
                        state._fsp--;
                        if (state.failed) {
                            return retval;
                        }
                        if (state.backtracking == 0) {
                            stream_propertyExpression.add(propertyExpression42.getTree());
                        }
                        SOME43 = (Token) match(input, SOME,
                                FOLLOW_SOME_in_incompleteQualifiedRestriction1451);
                        if (state.failed) {
                            return retval;
                        }
                        if (state.backtracking == 0) {
                            stream_SOME.add(SOME43);
                        }
                        // AST REWRITE
                        // elements: propertyExpression
                        // token labels:
                        // rule labels: retval
                        // token list labels:
                        // rule list labels:
                        // wildcard labels:
                        if (state.backtracking == 0) {
                            retval.tree = root_0;
                            root_0 = (ManchesterOWLSyntaxTree) adaptor.nil();
                            // 116:36: -> ^( INCOMPLETE_SOME_RESTRICTION
                            // propertyExpression )
                            {
                                // ManchesterOWLSyntaxAutoCompleteBase.g:116:39:
                                // ^( INCOMPLETE_SOME_RESTRICTION
                                // propertyExpression )
                                {
                                    ManchesterOWLSyntaxTree root_1 = (ManchesterOWLSyntaxTree) adaptor
                                            .nil();
                                    root_1 = (ManchesterOWLSyntaxTree) adaptor
                                            .becomeRoot(adaptor.create(
                                                    INCOMPLETE_SOME_RESTRICTION,
                                                    "INCOMPLETE_SOME_RESTRICTION"),
                                                    root_1);
                                    adaptor.addChild(root_1,
                                            stream_propertyExpression.nextTree());
                                    adaptor.addChild(root_0, root_1);
                                }
                            }
                            retval.tree = root_0;
                        }
                    }
                        break;
                    case 2:
                    // ManchesterOWLSyntaxAutoCompleteBase.g:117:11:
                    // propertyExpression ONLY
                    {
                        pushFollow(FOLLOW_propertyExpression_in_incompleteQualifiedRestriction1488);
                        propertyExpression44 = gManchesterOWLSyntaxAutoCompleteCombined
                                .propertyExpression();
                        state._fsp--;
                        if (state.failed) {
                            return retval;
                        }
                        if (state.backtracking == 0) {
                            stream_propertyExpression.add(propertyExpression44.getTree());
                        }
                        ONLY45 = (Token) match(input, ONLY,
                                FOLLOW_ONLY_in_incompleteQualifiedRestriction1490);
                        if (state.failed) {
                            return retval;
                        }
                        if (state.backtracking == 0) {
                            stream_ONLY.add(ONLY45);
                        }
                        // AST REWRITE
                        // elements: propertyExpression
                        // token labels:
                        // rule labels: retval
                        // token list labels:
                        // rule list labels:
                        // wildcard labels:
                        if (state.backtracking == 0) {
                            retval.tree = root_0;
                            root_0 = (ManchesterOWLSyntaxTree) adaptor.nil();
                            // 117:35: -> ^( INCOMPLETE_ALL_RESTRICTION
                            // propertyExpression )
                            {
                                // ManchesterOWLSyntaxAutoCompleteBase.g:117:38:
                                // ^( INCOMPLETE_ALL_RESTRICTION
                                // propertyExpression )
                                {
                                    ManchesterOWLSyntaxTree root_1 = (ManchesterOWLSyntaxTree) adaptor
                                            .nil();
                                    root_1 = (ManchesterOWLSyntaxTree) adaptor
                                            .becomeRoot(adaptor.create(
                                                    INCOMPLETE_ALL_RESTRICTION,
                                                    "INCOMPLETE_ALL_RESTRICTION"), root_1);
                                    adaptor.addChild(root_1,
                                            stream_propertyExpression.nextTree());
                                    adaptor.addChild(root_0, root_1);
                                }
                            }
                            retval.tree = root_0;
                        }
                    }
                        break;
                    case 3:
                    // ManchesterOWLSyntaxAutoCompleteBase.g:118:11:
                    // incompleteOneOf
                    {
                        pushFollow(FOLLOW_incompleteOneOf_in_incompleteQualifiedRestriction1510);
                        incompleteOneOf46 = incompleteOneOf();
                        state._fsp--;
                        if (state.failed) {
                            return retval;
                        }
                        if (state.backtracking == 0) {
                            stream_incompleteOneOf.add(incompleteOneOf46.getTree());
                        }
                        // AST REWRITE
                        // elements: incompleteOneOf
                        // token labels:
                        // rule labels: retval
                        // token list labels:
                        // rule list labels:
                        // wildcard labels:
                        if (state.backtracking == 0) {
                            retval.tree = root_0;
                            root_0 = (ManchesterOWLSyntaxTree) adaptor.nil();
                            // 118:27: -> ^( incompleteOneOf )
                            {
                                // ManchesterOWLSyntaxAutoCompleteBase.g:118:30:
                                // ^( incompleteOneOf )
                                {
                                    ManchesterOWLSyntaxTree root_1 = (ManchesterOWLSyntaxTree) adaptor
                                            .nil();
                                    root_1 = (ManchesterOWLSyntaxTree) adaptor
                                            .becomeRoot(
                                                    stream_incompleteOneOf.nextNode(),
                                                    root_1);
                                    adaptor.addChild(root_0, root_1);
                                }
                            }
                            retval.tree = root_0;
                        }
                    }
                        break;
                    case 4:
                    // ManchesterOWLSyntaxAutoCompleteBase.g:119:4:
                    // incompleteCardinalityRestriction
                    {
                        pushFollow(FOLLOW_incompleteCardinalityRestriction_in_incompleteQualifiedRestriction1521);
                        incompleteCardinalityRestriction47 = incompleteCardinalityRestriction();
                        state._fsp--;
                        if (state.failed) {
                            return retval;
                        }
                        if (state.backtracking == 0) {
                            stream_incompleteCardinalityRestriction
                                    .add(incompleteCardinalityRestriction47.getTree());
                        }
                        // AST REWRITE
                        // elements: incompleteCardinalityRestriction
                        // token labels:
                        // rule labels: retval
                        // token list labels:
                        // rule list labels:
                        // wildcard labels:
                        if (state.backtracking == 0) {
                            retval.tree = root_0;
                            root_0 = (ManchesterOWLSyntaxTree) adaptor.nil();
                            // 119:37: -> incompleteCardinalityRestriction
                            {
                                adaptor.addChild(root_0,
                                        stream_incompleteCardinalityRestriction
                                                .nextTree());
                            }
                            retval.tree = root_0;
                        }
                    }
                        break;
                    case 5:
                    // ManchesterOWLSyntaxAutoCompleteBase.g:120:11:
                    // incompleteValueRestriction
                    {
                        pushFollow(FOLLOW_incompleteValueRestriction_in_incompleteQualifiedRestriction1537);
                        incompleteValueRestriction48 = incompleteValueRestriction();
                        state._fsp--;
                        if (state.failed) {
                            return retval;
                        }
                        if (state.backtracking == 0) {
                            stream_incompleteValueRestriction
                                    .add(incompleteValueRestriction48.getTree());
                        }
                        // AST REWRITE
                        // elements: incompleteValueRestriction
                        // token labels:
                        // rule labels: retval
                        // token list labels:
                        // rule list labels:
                        // wildcard labels:
                        if (state.backtracking == 0) {
                            retval.tree = root_0;
                            root_0 = (ManchesterOWLSyntaxTree) adaptor.nil();
                            // 120:38: -> incompleteValueRestriction
                            {
                                adaptor.addChild(root_0,
                                        stream_incompleteValueRestriction.nextTree());
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
        } catch (RecognitionException re) {
            reportError(re);
            recover(input, re);
            retval.tree = (ManchesterOWLSyntaxTree) adaptor.errorNode(input,
                    retval.start, input.LT(-1), re);
        } finally {}
        return retval;
    }

    // $ANTLR end "incompleteQualifiedRestriction"
    public static class incompleteCardinalityRestriction_return extends
            ParserRuleReturnScope {
        ManchesterOWLSyntaxTree tree;

        @Override
        public Object getTree() {
            return tree;
        }
    }

    // $ANTLR start "incompleteCardinalityRestriction"
    // ManchesterOWLSyntaxAutoCompleteBase.g:126:1:
    // incompleteCardinalityRestriction : propertyExpression restrictionKind
    // INTEGER -> ^( INCOMPLETE_CARDINALITY_RESTRICTION restrictionKind INTEGER
    // propertyExpression ) ;
    public final
            ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase.incompleteCardinalityRestriction_return
            incompleteCardinalityRestriction() {
        ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase.incompleteCardinalityRestriction_return retval = new ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase.incompleteCardinalityRestriction_return();
        retval.start = input.LT(1);
        ManchesterOWLSyntaxTree root_0 = null;
        Token INTEGER51 = null;
        ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase_MOWLParser.propertyExpression_return propertyExpression49 = null;
        ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase_MOWLParser.restrictionKind_return restrictionKind50 = null;
        RewriteRuleTokenStream stream_INTEGER = new RewriteRuleTokenStream(adaptor,
                "token INTEGER");
        RewriteRuleSubtreeStream stream_propertyExpression = new RewriteRuleSubtreeStream(
                adaptor, "rule propertyExpression");
        RewriteRuleSubtreeStream stream_restrictionKind = new RewriteRuleSubtreeStream(
                adaptor, "rule restrictionKind");
        try {
            // ManchesterOWLSyntaxAutoCompleteBase.g:126:35: (
            // propertyExpression restrictionKind INTEGER -> ^(
            // INCOMPLETE_CARDINALITY_RESTRICTION restrictionKind INTEGER
            // propertyExpression ) )
            // ManchesterOWLSyntaxAutoCompleteBase.g:127:11: propertyExpression
            // restrictionKind INTEGER
            {
                pushFollow(FOLLOW_propertyExpression_in_incompleteCardinalityRestriction1570);
                propertyExpression49 = gManchesterOWLSyntaxAutoCompleteCombined
                        .propertyExpression();
                state._fsp--;
                if (state.failed) {
                    return retval;
                }
                if (state.backtracking == 0) {
                    stream_propertyExpression.add(propertyExpression49.getTree());
                }
                pushFollow(FOLLOW_restrictionKind_in_incompleteCardinalityRestriction1573);
                restrictionKind50 = gManchesterOWLSyntaxAutoCompleteCombined
                        .restrictionKind();
                state._fsp--;
                if (state.failed) {
                    return retval;
                }
                if (state.backtracking == 0) {
                    stream_restrictionKind.add(restrictionKind50.getTree());
                }
                INTEGER51 = (Token) match(input, INTEGER,
                        FOLLOW_INTEGER_in_incompleteCardinalityRestriction1575);
                if (state.failed) {
                    return retval;
                }
                if (state.backtracking == 0) {
                    stream_INTEGER.add(INTEGER51);
                }
                // AST REWRITE
                // elements: INTEGER, propertyExpression, restrictionKind
                // token labels:
                // rule labels: retval
                // token list labels:
                // rule list labels:
                // wildcard labels:
                if (state.backtracking == 0) {
                    retval.tree = root_0;
                    root_0 = (ManchesterOWLSyntaxTree) adaptor.nil();
                    // 127:56: -> ^( INCOMPLETE_CARDINALITY_RESTRICTION
                    // restrictionKind INTEGER propertyExpression )
                    {
                        // ManchesterOWLSyntaxAutoCompleteBase.g:127:59: ^(
                        // INCOMPLETE_CARDINALITY_RESTRICTION restrictionKind
                        // INTEGER propertyExpression )
                        {
                            ManchesterOWLSyntaxTree root_1 = (ManchesterOWLSyntaxTree) adaptor
                                    .nil();
                            root_1 = (ManchesterOWLSyntaxTree) adaptor
                                    .becomeRoot(adaptor.create(
                                            INCOMPLETE_CARDINALITY_RESTRICTION,
                                            "INCOMPLETE_CARDINALITY_RESTRICTION"), root_1);
                            adaptor.addChild(root_1, stream_restrictionKind.nextTree());
                            adaptor.addChild(root_1, stream_INTEGER.nextNode());
                            adaptor.addChild(root_1, stream_propertyExpression.nextTree());
                            adaptor.addChild(root_0, root_1);
                        }
                    }
                    retval.tree = root_0;
                }
            }
            retval.stop = input.LT(-1);
            if (state.backtracking == 0) {
                retval.tree = (ManchesterOWLSyntaxTree) adaptor
                        .rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        } catch (RecognitionException re) {
            reportError(re);
            recover(input, re);
            retval.tree = (ManchesterOWLSyntaxTree) adaptor.errorNode(input,
                    retval.start, input.LT(-1), re);
        } finally {}
        return retval;
    }

    // $ANTLR end "incompleteCardinalityRestriction"
    public static class incompleteOneOf_return extends ParserRuleReturnScope {
        ManchesterOWLSyntaxTree tree;

        @Override
        public Object getTree() {
            return tree;
        }
    }

    // $ANTLR start "incompleteOneOf"
    // ManchesterOWLSyntaxAutoCompleteBase.g:130:1: incompleteOneOf :
    // OPEN_CURLY_BRACES IDENTIFIER ( COMMA IDENTIFIER )* COMMA -> ^(
    // INCOMPLETE_ONE_OF ( IDENTIFIER )+ ) ;
    public final
            ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase.incompleteOneOf_return
            incompleteOneOf() {
        ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase.incompleteOneOf_return retval = new ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase.incompleteOneOf_return();
        retval.start = input.LT(1);
        ManchesterOWLSyntaxTree root_0 = null;
        Token OPEN_CURLY_BRACES52 = null;
        Token IDENTIFIER53 = null;
        Token COMMA54 = null;
        Token IDENTIFIER55 = null;
        Token COMMA56 = null;
        RewriteRuleTokenStream stream_COMMA = new RewriteRuleTokenStream(adaptor,
                "token COMMA");
        RewriteRuleTokenStream stream_OPEN_CURLY_BRACES = new RewriteRuleTokenStream(
                adaptor, "token OPEN_CURLY_BRACES");
        RewriteRuleTokenStream stream_IDENTIFIER = new RewriteRuleTokenStream(adaptor,
                "token IDENTIFIER");
        try {
            // ManchesterOWLSyntaxAutoCompleteBase.g:130:17: ( OPEN_CURLY_BRACES
            // IDENTIFIER ( COMMA IDENTIFIER )* COMMA -> ^( INCOMPLETE_ONE_OF (
            // IDENTIFIER )+ ) )
            // ManchesterOWLSyntaxAutoCompleteBase.g:131:5: OPEN_CURLY_BRACES
            // IDENTIFIER ( COMMA IDENTIFIER )* COMMA
            {
                OPEN_CURLY_BRACES52 = (Token) match(input, OPEN_CURLY_BRACES,
                        FOLLOW_OPEN_CURLY_BRACES_in_incompleteOneOf1606);
                if (state.failed) {
                    return retval;
                }
                if (state.backtracking == 0) {
                    stream_OPEN_CURLY_BRACES.add(OPEN_CURLY_BRACES52);
                }
                IDENTIFIER53 = (Token) match(input, IDENTIFIER,
                        FOLLOW_IDENTIFIER_in_incompleteOneOf1608);
                if (state.failed) {
                    return retval;
                }
                if (state.backtracking == 0) {
                    stream_IDENTIFIER.add(IDENTIFIER53);
                }
                // ManchesterOWLSyntaxAutoCompleteBase.g:131:34: ( COMMA
                // IDENTIFIER )*
                loop13: do {
                    int alt13 = 2;
                    int LA13_0 = input.LA(1);
                    if (LA13_0 == COMMA) {
                        int LA13_1 = input.LA(2);
                        if (LA13_1 == IDENTIFIER) {
                            alt13 = 1;
                        }
                    }
                    switch (alt13) {
                        case 1:
                        // ManchesterOWLSyntaxAutoCompleteBase.g:131:35: COMMA
                        // IDENTIFIER
                        {
                            COMMA54 = (Token) match(input, COMMA,
                                    FOLLOW_COMMA_in_incompleteOneOf1611);
                            if (state.failed) {
                                return retval;
                            }
                            if (state.backtracking == 0) {
                                stream_COMMA.add(COMMA54);
                            }
                            IDENTIFIER55 = (Token) match(input, IDENTIFIER,
                                    FOLLOW_IDENTIFIER_in_incompleteOneOf1613);
                            if (state.failed) {
                                return retval;
                            }
                            if (state.backtracking == 0) {
                                stream_IDENTIFIER.add(IDENTIFIER55);
                            }
                        }
                            break;
                        default:
                            break loop13;
                    }
                } while (true);
                COMMA56 = (Token) match(input, COMMA, FOLLOW_COMMA_in_incompleteOneOf1617);
                if (state.failed) {
                    return retval;
                }
                if (state.backtracking == 0) {
                    stream_COMMA.add(COMMA56);
                }
                // AST REWRITE
                // elements: IDENTIFIER
                // token labels:
                // rule labels: retval
                // token list labels:
                // rule list labels:
                // wildcard labels:
                if (state.backtracking == 0) {
                    retval.tree = root_0;
                    root_0 = (ManchesterOWLSyntaxTree) adaptor.nil();
                    // 131:60: -> ^( INCOMPLETE_ONE_OF ( IDENTIFIER )+ )
                    {
                        // ManchesterOWLSyntaxAutoCompleteBase.g:131:63: ^(
                        // INCOMPLETE_ONE_OF ( IDENTIFIER )+ )
                        {
                            ManchesterOWLSyntaxTree root_1 = (ManchesterOWLSyntaxTree) adaptor
                                    .nil();
                            root_1 = (ManchesterOWLSyntaxTree) adaptor.becomeRoot(adaptor
                                    .create(INCOMPLETE_ONE_OF, "INCOMPLETE_ONE_OF"),
                                    root_1);
                            if (!stream_IDENTIFIER.hasNext()) {
                                throw new RewriteEarlyExitException();
                            }
                            while (stream_IDENTIFIER.hasNext()) {
                                adaptor.addChild(root_1, stream_IDENTIFIER.nextNode());
                            }
                            stream_IDENTIFIER.reset();
                            adaptor.addChild(root_0, root_1);
                        }
                    }
                    retval.tree = root_0;
                }
            }
            retval.stop = input.LT(-1);
            if (state.backtracking == 0) {
                retval.tree = (ManchesterOWLSyntaxTree) adaptor
                        .rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        } catch (RecognitionException re) {
            reportError(re);
            recover(input, re);
            retval.tree = (ManchesterOWLSyntaxTree) adaptor.errorNode(input,
                    retval.start, input.LT(-1), re);
        } finally {}
        return retval;
    }

    // $ANTLR end "incompleteOneOf"
    public static class incompleteValueRestriction_return extends ParserRuleReturnScope {
        ManchesterOWLSyntaxTree tree;

        @Override
        public Object getTree() {
            return tree;
        }
    }

    // $ANTLR start "incompleteValueRestriction"
    // ManchesterOWLSyntaxAutoCompleteBase.g:134:1: incompleteValueRestriction :
    // propertyExpression VALUE -> ^( INCOMPLETE_VALUE_RESTRICTION
    // propertyExpression ) ;
    public final
            ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase.incompleteValueRestriction_return
            incompleteValueRestriction() {
        ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase.incompleteValueRestriction_return retval = new ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase.incompleteValueRestriction_return();
        retval.start = input.LT(1);
        ManchesterOWLSyntaxTree root_0 = null;
        Token VALUE58 = null;
        ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase_MOWLParser.propertyExpression_return propertyExpression57 = null;
        RewriteRuleTokenStream stream_VALUE = new RewriteRuleTokenStream(adaptor,
                "token VALUE");
        RewriteRuleSubtreeStream stream_propertyExpression = new RewriteRuleSubtreeStream(
                adaptor, "rule propertyExpression");
        try {
            // ManchesterOWLSyntaxAutoCompleteBase.g:134:29: (
            // propertyExpression VALUE -> ^( INCOMPLETE_VALUE_RESTRICTION
            // propertyExpression ) )
            // ManchesterOWLSyntaxAutoCompleteBase.g:134:31: propertyExpression
            // VALUE
            {
                pushFollow(FOLLOW_propertyExpression_in_incompleteValueRestriction1638);
                propertyExpression57 = gManchesterOWLSyntaxAutoCompleteCombined
                        .propertyExpression();
                state._fsp--;
                if (state.failed) {
                    return retval;
                }
                if (state.backtracking == 0) {
                    stream_propertyExpression.add(propertyExpression57.getTree());
                }
                VALUE58 = (Token) match(input, VALUE,
                        FOLLOW_VALUE_in_incompleteValueRestriction1640);
                if (state.failed) {
                    return retval;
                }
                if (state.backtracking == 0) {
                    stream_VALUE.add(VALUE58);
                }
                // AST REWRITE
                // elements: propertyExpression
                // token labels:
                // rule labels: retval
                // token list labels:
                // rule list labels:
                // wildcard labels:
                if (state.backtracking == 0) {
                    retval.tree = root_0;
                    root_0 = (ManchesterOWLSyntaxTree) adaptor.nil();
                    // 134:57: -> ^( INCOMPLETE_VALUE_RESTRICTION
                    // propertyExpression )
                    {
                        // ManchesterOWLSyntaxAutoCompleteBase.g:134:60: ^(
                        // INCOMPLETE_VALUE_RESTRICTION propertyExpression )
                        {
                            ManchesterOWLSyntaxTree root_1 = (ManchesterOWLSyntaxTree) adaptor
                                    .nil();
                            root_1 = (ManchesterOWLSyntaxTree) adaptor.becomeRoot(adaptor
                                    .create(INCOMPLETE_VALUE_RESTRICTION,
                                            "INCOMPLETE_VALUE_RESTRICTION"), root_1);
                            adaptor.addChild(root_1, stream_propertyExpression.nextTree());
                            adaptor.addChild(root_0, root_1);
                        }
                    }
                    retval.tree = root_0;
                }
            }
            retval.stop = input.LT(-1);
            if (state.backtracking == 0) {
                retval.tree = (ManchesterOWLSyntaxTree) adaptor
                        .rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        } catch (RecognitionException re) {
            reportError(re);
            recover(input, re);
            retval.tree = (ManchesterOWLSyntaxTree) adaptor.errorNode(input,
                    retval.start, input.LT(-1), re);
        } finally {}
        return retval;
    }

    // $ANTLR end "incompleteValueRestriction"
    // $ANTLR start synpred1_ManchesterOWLSyntaxAutoCompleteBase
    public final void synpred1_ManchesterOWLSyntaxAutoCompleteBase_fragment()
            throws RecognitionException {
        List<Object> list_rest = null;
        RuleReturnScope rest = null;
        // ManchesterOWLSyntaxAutoCompleteBase.g:93:7: (head= propertyExpression
        // ( COMPOSITION rest+= propertyExpression )+ COMPOSITION )
        // ManchesterOWLSyntaxAutoCompleteBase.g:93:7: head= propertyExpression
        // ( COMPOSITION rest+= propertyExpression )+ COMPOSITION
        {
            pushFollow(FOLLOW_propertyExpression_in_synpred1_ManchesterOWLSyntaxAutoCompleteBase1121);
            gManchesterOWLSyntaxAutoCompleteCombined.propertyExpression();
            state._fsp--;
            if (state.failed) {
                return;
            }
            // ManchesterOWLSyntaxAutoCompleteBase.g:93:33: ( COMPOSITION rest+=
            // propertyExpression )+
            int cnt14 = 0;
            loop14: do {
                int alt14 = 2;
                int LA14_0 = input.LA(1);
                if (LA14_0 == COMPOSITION) {
                    int LA14_1 = input.LA(2);
                    if (LA14_1 == INVERSE || LA14_1 >= IDENTIFIER
                            && LA14_1 <= ENTITY_REFERENCE) {
                        alt14 = 1;
                    }
                }
                switch (alt14) {
                    case 1:
                    // ManchesterOWLSyntaxAutoCompleteBase.g:93:34: COMPOSITION
                    // rest+= propertyExpression
                    {
                        match(input, COMPOSITION,
                                FOLLOW_COMPOSITION_in_synpred1_ManchesterOWLSyntaxAutoCompleteBase1124);
                        if (state.failed) {
                            return;
                        }
                        pushFollow(FOLLOW_propertyExpression_in_synpred1_ManchesterOWLSyntaxAutoCompleteBase1128);
                        rest = gManchesterOWLSyntaxAutoCompleteCombined
                                .propertyExpression();
                        state._fsp--;
                        if (state.failed) {
                            return;
                        }
                        if (list_rest == null) {
                            list_rest = new ArrayList<Object>();
                        }
                        list_rest.add(rest);
                    }
                        break;
                    default:
                        if (cnt14 >= 1) {
                            break loop14;
                        }
                        if (state.backtracking > 0) {
                            state.failed = true;
                            return;
                        }
                        EarlyExitException eee = new EarlyExitException(14, input);
                        throw eee;
                }
                cnt14++;
            } while (true);
            match(input, COMPOSITION,
                    FOLLOW_COMPOSITION_in_synpred1_ManchesterOWLSyntaxAutoCompleteBase1133);
            if (state.failed) {
                return;
            }
        }
    }

    // $ANTLR end synpred1_ManchesterOWLSyntaxAutoCompleteBase
    // $ANTLR start synpred2_ManchesterOWLSyntaxAutoCompleteBase
    public final void synpred2_ManchesterOWLSyntaxAutoCompleteBase_fragment()
            throws RecognitionException {
        // ManchesterOWLSyntaxAutoCompleteBase.g:94:9: ( ( conjunction ( OR . )*
        // ) OR incompleteConjunction )
        // ManchesterOWLSyntaxAutoCompleteBase.g:94:9: ( conjunction ( OR . )* )
        // OR incompleteConjunction
        {
            // ManchesterOWLSyntaxAutoCompleteBase.g:94:9: ( conjunction ( OR .
            // )* )
            // ManchesterOWLSyntaxAutoCompleteBase.g:94:10: conjunction ( OR .
            // )*
            {
                pushFollow(FOLLOW_conjunction_in_synpred2_ManchesterOWLSyntaxAutoCompleteBase1162);
                gManchesterOWLSyntaxAutoCompleteCombined.conjunction();
                state._fsp--;
                if (state.failed) {
                    return;
                }
                // ManchesterOWLSyntaxAutoCompleteBase.g:94:22: ( OR . )*
                loop15: do {
                    int alt15 = 2;
                    alt15 = dfa15.predict(input);
                    switch (alt15) {
                        case 1:
                        // ManchesterOWLSyntaxAutoCompleteBase.g:94:23: OR .
                        {
                            match(input, OR,
                                    FOLLOW_OR_in_synpred2_ManchesterOWLSyntaxAutoCompleteBase1165);
                            if (state.failed) {
                                return;
                            }
                            matchAny(input);
                            if (state.failed) {
                                return;
                            }
                        }
                            break;
                        default:
                            break loop15;
                    }
                } while (true);
            }
            match(input, OR,
                    FOLLOW_OR_in_synpred2_ManchesterOWLSyntaxAutoCompleteBase1172);
            if (state.failed) {
                return;
            }
            pushFollow(FOLLOW_incompleteConjunction_in_synpred2_ManchesterOWLSyntaxAutoCompleteBase1175);
            incompleteConjunction();
            state._fsp--;
            if (state.failed) {
                return;
            }
        }
    }

    // $ANTLR end synpred2_ManchesterOWLSyntaxAutoCompleteBase
    // $ANTLR start synpred3_ManchesterOWLSyntaxAutoCompleteBase
    public final void synpred3_ManchesterOWLSyntaxAutoCompleteBase_fragment() {
        // ManchesterOWLSyntaxAutoCompleteBase.g:95:9: ( incompleteConjunction )
        // ManchesterOWLSyntaxAutoCompleteBase.g:95:9: incompleteConjunction
        {
            pushFollow(FOLLOW_incompleteConjunction_in_synpred3_ManchesterOWLSyntaxAutoCompleteBase1199);
            incompleteConjunction();
            state._fsp--;
            if (state.failed) {
                return;
            }
        }
    }

    // $ANTLR end synpred3_ManchesterOWLSyntaxAutoCompleteBase
    // $ANTLR start synpred4_ManchesterOWLSyntaxAutoCompleteBase
    public final void synpred4_ManchesterOWLSyntaxAutoCompleteBase_fragment() {
        // ManchesterOWLSyntaxAutoCompleteBase.g:96:9: ( incompleteUnary )
        // ManchesterOWLSyntaxAutoCompleteBase.g:96:9: incompleteUnary
        {
            pushFollow(FOLLOW_incompleteUnary_in_synpred4_ManchesterOWLSyntaxAutoCompleteBase1223);
            incompleteUnary();
            state._fsp--;
            if (state.failed) {
                return;
            }
        }
    }

    // $ANTLR end synpred4_ManchesterOWLSyntaxAutoCompleteBase
    // $ANTLR start synpred5_ManchesterOWLSyntaxAutoCompleteBase
    public final void synpred5_ManchesterOWLSyntaxAutoCompleteBase_fragment()
            throws RecognitionException {
        // ManchesterOWLSyntaxAutoCompleteBase.g:116:11: ( propertyExpression
        // SOME )
        // ManchesterOWLSyntaxAutoCompleteBase.g:116:11: propertyExpression SOME
        {
            pushFollow(FOLLOW_propertyExpression_in_synpred5_ManchesterOWLSyntaxAutoCompleteBase1448);
            gManchesterOWLSyntaxAutoCompleteCombined.propertyExpression();
            state._fsp--;
            if (state.failed) {
                return;
            }
            match(input, SOME,
                    FOLLOW_SOME_in_synpred5_ManchesterOWLSyntaxAutoCompleteBase1451);
            if (state.failed) {
                return;
            }
        }
    }

    // $ANTLR end synpred5_ManchesterOWLSyntaxAutoCompleteBase
    // $ANTLR start synpred6_ManchesterOWLSyntaxAutoCompleteBase
    public final void synpred6_ManchesterOWLSyntaxAutoCompleteBase_fragment()
            throws RecognitionException {
        // ManchesterOWLSyntaxAutoCompleteBase.g:117:11: ( propertyExpression
        // ONLY )
        // ManchesterOWLSyntaxAutoCompleteBase.g:117:11: propertyExpression ONLY
        {
            pushFollow(FOLLOW_propertyExpression_in_synpred6_ManchesterOWLSyntaxAutoCompleteBase1488);
            gManchesterOWLSyntaxAutoCompleteCombined.propertyExpression();
            state._fsp--;
            if (state.failed) {
                return;
            }
            match(input, ONLY,
                    FOLLOW_ONLY_in_synpred6_ManchesterOWLSyntaxAutoCompleteBase1490);
            if (state.failed) {
                return;
            }
        }
    }

    // $ANTLR end synpred6_ManchesterOWLSyntaxAutoCompleteBase
    // $ANTLR start synpred8_ManchesterOWLSyntaxAutoCompleteBase
    public final void synpred8_ManchesterOWLSyntaxAutoCompleteBase_fragment() {
        // ManchesterOWLSyntaxAutoCompleteBase.g:119:4: (
        // incompleteCardinalityRestriction )
        // ManchesterOWLSyntaxAutoCompleteBase.g:119:4:
        // incompleteCardinalityRestriction
        {
            pushFollow(FOLLOW_incompleteCardinalityRestriction_in_synpred8_ManchesterOWLSyntaxAutoCompleteBase1521);
            incompleteCardinalityRestriction();
            state._fsp--;
            if (state.failed) {
                return;
            }
        }
    }

    Logger logger = Logging.getParseLogging();

    // $ANTLR end synpred8_ManchesterOWLSyntaxAutoCompleteBase
    // Delegated rules
    public final boolean synpred1_ManchesterOWLSyntaxAutoCompleteBase() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred1_ManchesterOWLSyntaxAutoCompleteBase_fragment();
        } catch (RecognitionException re) {
            logger.info("impossible: ", re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed = false;
        return success;
    }

    public final boolean synpred6_ManchesterOWLSyntaxAutoCompleteBase() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred6_ManchesterOWLSyntaxAutoCompleteBase_fragment();
        } catch (RecognitionException re) {
            logger.info("impossible: ", re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed = false;
        return success;
    }

    public final boolean synpred3_ManchesterOWLSyntaxAutoCompleteBase() {
        state.backtracking++;
        int start = input.mark();
        synpred3_ManchesterOWLSyntaxAutoCompleteBase_fragment();
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed = false;
        return success;
    }

    public final boolean synpred4_ManchesterOWLSyntaxAutoCompleteBase() {
        state.backtracking++;
        int start = input.mark();
        synpred4_ManchesterOWLSyntaxAutoCompleteBase_fragment();
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed = false;
        return success;
    }

    public final boolean synpred2_ManchesterOWLSyntaxAutoCompleteBase() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred2_ManchesterOWLSyntaxAutoCompleteBase_fragment();
        } catch (RecognitionException re) {
            logger.info("impossible: ", re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed = false;
        return success;
    }

    public final boolean synpred5_ManchesterOWLSyntaxAutoCompleteBase() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred5_ManchesterOWLSyntaxAutoCompleteBase_fragment();
        } catch (RecognitionException re) {
            logger.info("impossible: ", re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed = false;
        return success;
    }

    public final boolean synpred8_ManchesterOWLSyntaxAutoCompleteBase() {
        state.backtracking++;
        int start = input.mark();
        synpred8_ManchesterOWLSyntaxAutoCompleteBase_fragment();
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed = false;
        return success;
    }

    protected DFA3 dfa3 = new DFA3(this);
    protected DFA4 dfa4 = new DFA4(this);
    protected DFA8 dfa8 = new DFA8(this);
    protected DFA7 dfa7 = new DFA7(this);
    protected DFA15 dfa15 = new DFA15(this);
    static final String DFA3_eotS = "\13\uffff";
    static final String DFA3_eofS = "\1\uffff\1\5\1\10\1\11\7\uffff";
    static final String DFA3_minS = "\1\24\3\5\7\uffff";
    static final String DFA3_maxS = "\1\32\3\55\7\uffff";
    static final String DFA3_acceptS = "\4\uffff\1\7\1\1\1\2\1\4\1\3\1\5\1\6";
    static final String DFA3_specialS = "\13\uffff}>";
    static final String[] DFA3_transitionS = { "\1\1\1\4\1\2\3\uffff\1\3",
            "\2\6\5\uffff\1\6\6\uffff\1\6\24\uffff\1\6\3\uffff\2\6",
            "\2\7\5\uffff\1\7\6\uffff\1\7\24\uffff\1\7\3\uffff\2\7",
            "\2\12\5\uffff\1\12\6\uffff\1\12\24\uffff\1\12\3\uffff\2\12", "", "", "", "",
            "", "", "" };
    static final short[] DFA3_eot = DFA.unpackEncodedString(DFA3_eotS);
    static final short[] DFA3_eof = DFA.unpackEncodedString(DFA3_eofS);
    static final char[] DFA3_min = DFA.unpackEncodedStringToUnsignedChars(DFA3_minS);
    static final char[] DFA3_max = DFA.unpackEncodedStringToUnsignedChars(DFA3_maxS);
    static final short[] DFA3_accept = DFA.unpackEncodedString(DFA3_acceptS);
    static final short[] DFA3_special = DFA.unpackEncodedString(DFA3_specialS);
    static final short[][] DFA3_transition;
    static {
        int numStates = DFA3_transitionS.length;
        DFA3_transition = new short[numStates][];
        for (int i = 0; i < numStates; i++) {
            DFA3_transition[i] = DFA.unpackEncodedString(DFA3_transitionS[i]);
        }
    }

    class DFA3 extends DFA {
        public DFA3(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            decisionNumber = 3;
            eot = DFA3_eot;
            eof = DFA3_eof;
            min = DFA3_min;
            max = DFA3_max;
            accept = DFA3_accept;
            special = DFA3_special;
            transition = DFA3_transition;
        }

        @Override
        public String getDescription() {
            return "68:17: ( SUBCLASS_OF -> ^( INCOMPLETE_SUB_CLASS_AXIOM ^( EXPRESSION $lhs) ) | SUBCLASS_OF superClass= incompleteExpression -> ^( INCOMPLETE_SUB_CLASS_AXIOM ^( EXPRESSION $lhs) ^( INCOMPLETE_EXPRESSION $superClass) ) | EQUIVALENT_TO -> ^( INCOMPLETE_EQUIVALENT_TO_AXIOM ^( EXPRESSION $lhs) ) | EQUIVALENT_TO rhs= incompleteExpression -> ^( EQUIVALENT_TO_AXIOM ^( EXPRESSION $lhs) ^( INCOMPLETE_EXPRESSION $rhs) ) | DISJOINT_WITH -> ^( INCOMPLETE_DISJOINT_WITH_AXIOM ^( EXPRESSION $lhs) ) | DISJOINT_WITH disjoint= incompleteExpression -> ^( DISJOINT_WITH_AXIOM ^( EXPRESSION $lhs) ^( INCOMPLETE_EXPRESSION $disjoint) ) | SUB_PROPERTY_OF -> ^( INCOMPLETE_SUB_PROPERTY_AXIOM ^( EXPRESSION $lhs) ) )";
        }
    }

    static final String DFA4_eotS = "\12\uffff";
    static final String DFA4_eofS = "\3\uffff\1\7\1\10\5\uffff";
    static final String DFA4_minS = "\1\27\2\uffff\2\5\5\uffff";
    static final String DFA4_maxS = "\1\34\2\uffff\2\55\5\uffff";
    static final String DFA4_acceptS = "\1\uffff\1\1\1\2\2\uffff\1\7\1\4\1\3\1\5\1\6";
    static final String DFA4_specialS = "\12\uffff}>";
    static final String[] DFA4_transitionS = { "\1\1\1\2\1\5\1\uffff\1\3\1\4", "", "",
            "\2\6\5\uffff\1\6\6\uffff\1\6\24\uffff\1\6\3\uffff\2\6",
            "\2\11\5\uffff\1\11\6\uffff\1\11\24\uffff\1\11\3\uffff\2\11", "", "", "", "",
            "" };
    static final short[] DFA4_eot = DFA.unpackEncodedString(DFA4_eotS);
    static final short[] DFA4_eof = DFA.unpackEncodedString(DFA4_eofS);
    static final char[] DFA4_min = DFA.unpackEncodedStringToUnsignedChars(DFA4_minS);
    static final char[] DFA4_max = DFA.unpackEncodedStringToUnsignedChars(DFA4_maxS);
    static final short[] DFA4_accept = DFA.unpackEncodedString(DFA4_acceptS);
    static final short[] DFA4_special = DFA.unpackEncodedString(DFA4_specialS);
    static final short[][] DFA4_transition;
    static {
        int numStates = DFA4_transitionS.length;
        DFA4_transition = new short[numStates][];
        for (int i = 0; i < numStates; i++) {
            DFA4_transition[i] = DFA.unpackEncodedString(DFA4_transitionS[i]);
        }
    }

    class DFA4 extends DFA {
        public DFA4(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            decisionNumber = 4;
            eot = DFA4_eot;
            eof = DFA4_eof;
            min = DFA4_min;
            max = DFA4_max;
            accept = DFA4_accept;
            special = DFA4_special;
            transition = DFA4_transition;
        }

        @Override
        public String getDescription() {
            return "78:25: ( SAME_AS -> ^( INCOMPLETE_SAME_AS_AXIOM ^( EXPRESSION $lhsID) ) | DIFFERENT_FROM -> ^( INCOMPLETE_DIFFERENT_FROM_AXIOM ^( EXPRESSION $lhsID) ) | DOMAIN -> ^( INCOMPLETE_DOMAIN ^( EXPRESSION $lhsID) ) | DOMAIN incompleteDomain= incompleteExpression -> ^( INCOMPLETE_DOMAIN ^( EXPRESSION $lhsID) ^( INCOMPLETE_EXPRESSION $incompleteDomain) ) | RANGE -> ^( INCOMPLETE_RANGE ^( EXPRESSION $lhsID) ) | RANGE incompleteRange= incompleteExpression -> ^( INCOMPLETE_RANGE ^( EXPRESSION $lhsID) ^( INCOMPLETE_EXPRESSION $incompleteRange) ) | INVERSE_OF -> ^( INCOMPLETE_INVERSE_OF ^( EXPRESSION $lhsID) ) )";
        }
    }

    static final String DFA8_eotS = "\14\uffff";
    static final String DFA8_eofS = "\14\uffff";
    static final String DFA8_minS = "\1\5\6\0\5\uffff";
    static final String DFA8_maxS = "\1\55\6\0\5\uffff";
    static final String DFA8_acceptS = "\7\uffff\1\5\1\1\1\2\1\3\1\4";
    static final String DFA8_specialS = "\1\uffff\1\0\1\1\1\2\1\3\1\4\1\5\5\uffff}>";
    static final String[] DFA8_transitionS = {
            "\1\7\1\5\5\uffff\1\4\6\uffff\1\3\24\uffff\1\6\3\uffff\1\1\1" + "\2",
            "\1\uffff", "\1\uffff", "\1\uffff", "\1\uffff", "\1\uffff", "\1\uffff", "",
            "", "", "", "" };
    static final short[] DFA8_eot = DFA.unpackEncodedString(DFA8_eotS);
    static final short[] DFA8_eof = DFA.unpackEncodedString(DFA8_eofS);
    static final char[] DFA8_min = DFA.unpackEncodedStringToUnsignedChars(DFA8_minS);
    static final char[] DFA8_max = DFA.unpackEncodedStringToUnsignedChars(DFA8_maxS);
    static final short[] DFA8_accept = DFA.unpackEncodedString(DFA8_acceptS);
    static final short[] DFA8_special = DFA.unpackEncodedString(DFA8_specialS);
    static final short[][] DFA8_transition;
    static {
        int numStates = DFA8_transitionS.length;
        DFA8_transition = new short[numStates][];
        for (int i = 0; i < numStates; i++) {
            DFA8_transition[i] = DFA.unpackEncodedString(DFA8_transitionS[i]);
        }
    }

    class DFA8 extends DFA {
        public DFA8(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            decisionNumber = 8;
            eot = DFA8_eot;
            eof = DFA8_eof;
            min = DFA8_min;
            max = DFA8_max;
            accept = DFA8_accept;
            special = DFA8_special;
            transition = DFA8_transition;
        }

        @Override
        public String getDescription() {
            return "91:5: ( options {backtrack=true; } : head= propertyExpression ( COMPOSITION rest+= propertyExpression )+ COMPOSITION -> ^( INCOMPLETE_EXPRESSION ^( INCOMPLETE_PROPERTY_CHAIN $head $rest) ) | ( conjunction ( OR . )* ) OR incompleteConjunction -> ^( INCOMPLETE_EXPRESSION ^( INCOMPLETE_DISJUNCTION incompleteConjunction ) ) | incompleteConjunction -> ^( INCOMPLETE_EXPRESSION ^( INCOMPLETE_DISJUNCTION incompleteConjunction ) ) | incompleteUnary -> ^( INCOMPLETE_EXPRESSION incompleteUnary ) | expression IDENTIFIER -> ^( INCOMPLETE_EXPRESSION ^( EXPRESSION expression ) IDENTIFIER ) )";
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
                    int index8_1 = in.index();
                    in.rewind();
                    s = -1;
                    if (synpred1_ManchesterOWLSyntaxAutoCompleteBase()) {
                        s = 8;
                    } else if (synpred2_ManchesterOWLSyntaxAutoCompleteBase()) {
                        s = 9;
                    } else if (synpred3_ManchesterOWLSyntaxAutoCompleteBase()) {
                        s = 10;
                    } else if (synpred4_ManchesterOWLSyntaxAutoCompleteBase()) {
                        s = 11;
                    } else {
                        s = 7;
                    }
                    in.seek(index8_1);
                    if (s >= 0) {
                        return s;
                    }
                    break;
                case 1:
                    in.LA(1);
                    int index8_2 = in.index();
                    in.rewind();
                    s = -1;
                    if (synpred1_ManchesterOWLSyntaxAutoCompleteBase()) {
                        s = 8;
                    } else if (synpred2_ManchesterOWLSyntaxAutoCompleteBase()) {
                        s = 9;
                    } else if (synpred3_ManchesterOWLSyntaxAutoCompleteBase()) {
                        s = 10;
                    } else if (synpred4_ManchesterOWLSyntaxAutoCompleteBase()) {
                        s = 11;
                    } else {
                        s = 7;
                    }
                    in.seek(index8_2);
                    if (s >= 0) {
                        return s;
                    }
                    break;
                case 2:
                    in.LA(1);
                    int index8_3 = in.index();
                    in.rewind();
                    s = -1;
                    if (synpred1_ManchesterOWLSyntaxAutoCompleteBase()) {
                        s = 8;
                    } else if (synpred2_ManchesterOWLSyntaxAutoCompleteBase()) {
                        s = 9;
                    } else if (synpred3_ManchesterOWLSyntaxAutoCompleteBase()) {
                        s = 10;
                    } else if (synpred4_ManchesterOWLSyntaxAutoCompleteBase()) {
                        s = 11;
                    } else {
                        s = 7;
                    }
                    in.seek(index8_3);
                    if (s >= 0) {
                        return s;
                    }
                    break;
                case 3:
                    in.LA(1);
                    int index8_4 = in.index();
                    in.rewind();
                    s = -1;
                    if (synpred2_ManchesterOWLSyntaxAutoCompleteBase()) {
                        s = 9;
                    } else if (synpred3_ManchesterOWLSyntaxAutoCompleteBase()) {
                        s = 10;
                    } else if (synpred4_ManchesterOWLSyntaxAutoCompleteBase()) {
                        s = 11;
                    } else {
                        s = 7;
                    }
                    in.seek(index8_4);
                    if (s >= 0) {
                        return s;
                    }
                    break;
                case 4:
                    in.LA(1);
                    int index8_5 = in.index();
                    in.rewind();
                    s = -1;
                    if (synpred2_ManchesterOWLSyntaxAutoCompleteBase()) {
                        s = 9;
                    } else if (synpred3_ManchesterOWLSyntaxAutoCompleteBase()) {
                        s = 10;
                    } else if (synpred4_ManchesterOWLSyntaxAutoCompleteBase()) {
                        s = 11;
                    } else {
                        s = 7;
                    }
                    in.seek(index8_5);
                    if (s >= 0) {
                        return s;
                    }
                    break;
                case 5:
                    in.LA(1);
                    int index8_6 = in.index();
                    in.rewind();
                    s = -1;
                    if (synpred2_ManchesterOWLSyntaxAutoCompleteBase()) {
                        s = 9;
                    } else if (synpred3_ManchesterOWLSyntaxAutoCompleteBase()) {
                        s = 10;
                    } else {
                        s = 7;
                    }
                    in.seek(index8_6);
                    if (s >= 0) {
                        return s;
                    }
                    break;
            }
            if (state.backtracking > 0) {
                state.failed = true;
                return -1;
            }
            NoViableAltException nvae = new NoViableAltException(getDescription(), 8, _s,
                    in);
            error(nvae);
            throw nvae;
        }
    }

    static final String DFA7_eotS = "\12\uffff";
    static final String DFA7_eofS = "\12\uffff";
    static final String DFA7_minS = "\1\13\3\4\2\5\1\13\1\12\2\uffff";
    static final String DFA7_maxS = "\1\13\1\u02d4\1\u0296\1\22\1\13\1\55\1\54\1\u0275\2\uffff";
    static final String DFA7_acceptS = "\10\uffff\1\1\1\2";
    static final String DFA7_specialS = "\12\uffff}>";
    static final String[] DFA7_transitionS = { "\1\1",
            "\2\10\1\6\5\10\1\5\6\10\1\4\24\10\1\7\3\10\1\2\1\3\u02a7\10",
            "\1\11\5\uffff\1\11\1\10\1\uffff\6\11\u0283\uffff\1\11",
            "\1\11\5\uffff\1\11\1\10\1\uffff\6\11", "\1\11\5\uffff\1\10",
            "\1\11\5\uffff\1\10\40\uffff\2\11", "\1\10\40\uffff\1\11",
            "\1\11\1\10\30\uffff\1\11\u0250\uffff\1\11", "", "" };
    static final short[] DFA7_eot = DFA.unpackEncodedString(DFA7_eotS);
    static final short[] DFA7_eof = DFA.unpackEncodedString(DFA7_eofS);
    static final char[] DFA7_min = DFA.unpackEncodedStringToUnsignedChars(DFA7_minS);
    static final char[] DFA7_max = DFA.unpackEncodedStringToUnsignedChars(DFA7_maxS);
    static final short[] DFA7_accept = DFA.unpackEncodedString(DFA7_acceptS);
    static final short[] DFA7_special = DFA.unpackEncodedString(DFA7_specialS);
    static final short[][] DFA7_transition;
    static {
        int numStates = DFA7_transitionS.length;
        DFA7_transition = new short[numStates][];
        for (int i = 0; i < numStates; i++) {
            DFA7_transition[i] = DFA.unpackEncodedString(DFA7_transitionS[i]);
        }
    }

    class DFA7 extends DFA {
        public DFA7(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            decisionNumber = 7;
            eot = DFA7_eot;
            eof = DFA7_eof;
            min = DFA7_min;
            max = DFA7_max;
            accept = DFA7_accept;
            special = DFA7_special;
            transition = DFA7_transition;
        }

        @Override
        public String getDescription() {
            return "()* loopback of 94:22: ( OR . )*";
        }
    }

    static final String DFA15_eotS = "\12\uffff";
    static final String DFA15_eofS = "\12\uffff";
    static final String DFA15_minS = "\1\13\3\4\2\5\1\13\1\12\2\uffff";
    static final String DFA15_maxS = "\1\13\1\u02d4\1\u0296\1\22\1\13\1\55\1\54\1\u0275\2\uffff";
    static final String DFA15_acceptS = "\10\uffff\1\1\1\2";
    static final String DFA15_specialS = "\12\uffff}>";
    static final String[] DFA15_transitionS = { "\1\1",
            "\2\10\1\6\5\10\1\5\6\10\1\4\24\10\1\7\3\10\1\2\1\3\u02a7\10",
            "\1\11\5\uffff\1\11\1\10\1\uffff\6\11\u0283\uffff\1\11",
            "\1\11\5\uffff\1\11\1\10\1\uffff\6\11", "\1\11\5\uffff\1\10",
            "\1\11\5\uffff\1\10\40\uffff\2\11", "\1\10\40\uffff\1\11",
            "\1\11\1\10\30\uffff\1\11\u0250\uffff\1\11", "", "" };
    static final short[] DFA15_eot = DFA.unpackEncodedString(DFA15_eotS);
    static final short[] DFA15_eof = DFA.unpackEncodedString(DFA15_eofS);
    static final char[] DFA15_min = DFA.unpackEncodedStringToUnsignedChars(DFA15_minS);
    static final char[] DFA15_max = DFA.unpackEncodedStringToUnsignedChars(DFA15_maxS);
    static final short[] DFA15_accept = DFA.unpackEncodedString(DFA15_acceptS);
    static final short[] DFA15_special = DFA.unpackEncodedString(DFA15_specialS);
    static final short[][] DFA15_transition;
    static {
        int numStates = DFA15_transitionS.length;
        DFA15_transition = new short[numStates][];
        for (int i = 0; i < numStates; i++) {
            DFA15_transition[i] = DFA.unpackEncodedString(DFA15_transitionS[i]);
        }
    }

    class DFA15 extends DFA {
        public DFA15(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            decisionNumber = 15;
            eot = DFA15_eot;
            eof = DFA15_eof;
            min = DFA15_min;
            max = DFA15_max;
            accept = DFA15_accept;
            special = DFA15_special;
            transition = DFA15_transition;
        }

        @Override
        public String getDescription() {
            return "()* loopback of 94:22: ( OR . )*";
        }
    }

    public static final BitSet FOLLOW_expression_in_standaloneExpression190 = new BitSet(
            new long[] { 0x0000000000000002L });
    public static final BitSet FOLLOW_incompleteBinaryAxiom_in_incompleteAxiom219 = new BitSet(
            new long[] { 0x0000000000000002L });
    public static final BitSet FOLLOW_incompleteUnaryAxiom_in_incompleteAxiom233 = new BitSet(
            new long[] { 0x0000000000000002L });
    public static final BitSet FOLLOW_incompleteAssertionAxiom_in_incompleteAxiom249 = new BitSet(
            new long[] { 0x0000000000000002L });
    public static final BitSet FOLLOW_IDENTIFIER_in_incompleteAssertionAxiom273 = new BitSet(
            new long[] { 0x000000C000000000L });
    public static final BitSet FOLLOW_INSTANCE_OF_in_incompleteAssertionAxiom276 = new BitSet(
            new long[] { 0x0000000000000002L });
    public static final BitSet FOLLOW_TYPES_in_incompleteAssertionAxiom280 = new BitSet(
            new long[] { 0x0000000000000002L });
    public static final BitSet FOLLOW_unaryCharacteristic_in_incompleteUnaryAxiom318 = new BitSet(
            new long[] { 0x0000000000000002L });
    public static final BitSet FOLLOW_expression_in_incompleteBinaryAxiom366 = new BitSet(
            new long[] { 0x0000000004700000L });
    public static final BitSet FOLLOW_SUBCLASS_OF_in_incompleteBinaryAxiom421 = new BitSet(
            new long[] { 0x0000000000000002L });
    public static final BitSet FOLLOW_SUBCLASS_OF_in_incompleteBinaryAxiom457 = new BitSet(
            new long[] { 0x0000310000081060L });
    public static final BitSet FOLLOW_incompleteExpression_in_incompleteBinaryAxiom463 = new BitSet(
            new long[] { 0x0000000000000002L });
    public static final BitSet FOLLOW_EQUIVALENT_TO_in_incompleteBinaryAxiom504 = new BitSet(
            new long[] { 0x0000000000000002L });
    public static final BitSet FOLLOW_EQUIVALENT_TO_in_incompleteBinaryAxiom538 = new BitSet(
            new long[] { 0x0000310000081060L });
    public static final BitSet FOLLOW_incompleteExpression_in_incompleteBinaryAxiom544 = new BitSet(
            new long[] { 0x0000000000000002L });
    public static final BitSet FOLLOW_DISJOINT_WITH_in_incompleteBinaryAxiom584 = new BitSet(
            new long[] { 0x0000000000000002L });
    public static final BitSet FOLLOW_DISJOINT_WITH_in_incompleteBinaryAxiom617 = new BitSet(
            new long[] { 0x0000310000081060L });
    public static final BitSet FOLLOW_incompleteExpression_in_incompleteBinaryAxiom623 = new BitSet(
            new long[] { 0x0000000000000002L });
    public static final BitSet FOLLOW_SUB_PROPERTY_OF_in_incompleteBinaryAxiom663 = new BitSet(
            new long[] { 0x0000000000000002L });
    public static final BitSet FOLLOW_IDENTIFIER_in_incompleteBinaryAxiom734 = new BitSet(
            new long[] { 0x000000001B800000L });
    public static final BitSet FOLLOW_SAME_AS_in_incompleteBinaryAxiom759 = new BitSet(
            new long[] { 0x0000000000000002L });
    public static final BitSet FOLLOW_DIFFERENT_FROM_in_incompleteBinaryAxiom797 = new BitSet(
            new long[] { 0x0000000000000002L });
    public static final BitSet FOLLOW_DOMAIN_in_incompleteBinaryAxiom833 = new BitSet(
            new long[] { 0x0000000000000002L });
    public static final BitSet FOLLOW_DOMAIN_in_incompleteBinaryAxiom869 = new BitSet(
            new long[] { 0x0000310000081060L });
    public static final BitSet FOLLOW_incompleteExpression_in_incompleteBinaryAxiom875 = new BitSet(
            new long[] { 0x0000000000000002L });
    public static final BitSet FOLLOW_RANGE_in_incompleteBinaryAxiom918 = new BitSet(
            new long[] { 0x0000000000000002L });
    public static final BitSet FOLLOW_RANGE_in_incompleteBinaryAxiom954 = new BitSet(
            new long[] { 0x0000310000081060L });
    public static final BitSet FOLLOW_incompleteExpression_in_incompleteBinaryAxiom961 = new BitSet(
            new long[] { 0x0000000000000002L });
    public static final BitSet FOLLOW_INVERSE_OF_in_incompleteBinaryAxiom1003 = new BitSet(
            new long[] { 0x0000000000000002L });
    public static final BitSet FOLLOW_propertyExpression_in_incompleteExpression1121 = new BitSet(
            new long[] { 0x0000000000000010L });
    public static final BitSet FOLLOW_COMPOSITION_in_incompleteExpression1124 = new BitSet(
            new long[] { 0x0000300000080000L });
    public static final BitSet FOLLOW_propertyExpression_in_incompleteExpression1128 = new BitSet(
            new long[] { 0x0000000000000010L });
    public static final BitSet FOLLOW_COMPOSITION_in_incompleteExpression1133 = new BitSet(
            new long[] { 0x0000000000000002L });
    public static final BitSet FOLLOW_conjunction_in_incompleteExpression1162 = new BitSet(
            new long[] { 0x0000000000000800L });
    public static final BitSet FOLLOW_OR_in_incompleteExpression1165 = new BitSet(
            new long[] { 0xFFFFFFFFFFFFFFF0L, 0xFFFFFFFFFFFFFFFFL, 0xFFFFFFFFFFFFFFFFL,
                    0xFFFFFFFFFFFFFFFFL, 0xFFFFFFFFFFFFFFFFL, 0xFFFFFFFFFFFFFFFFL,
                    0xFFFFFFFFFFFFFFFFL, 0xFFFFFFFFFFFFFFFFL, 0xFFFFFFFFFFFFFFFFL,
                    0xFFFFFFFFFFFFFFFFL, 0xFFFFFFFFFFFFFFFFL, 0x00000000001FFFFFL });
    public static final BitSet FOLLOW_OR_in_incompleteExpression1172 = new BitSet(
            new long[] { 0x0000310000081040L });
    public static final BitSet FOLLOW_incompleteConjunction_in_incompleteExpression1175 = new BitSet(
            new long[] { 0x0000000000000002L });
    public static final BitSet FOLLOW_incompleteConjunction_in_incompleteExpression1199 = new BitSet(
            new long[] { 0x0000000000000002L });
    public static final BitSet FOLLOW_incompleteUnary_in_incompleteExpression1223 = new BitSet(
            new long[] { 0x0000000000000002L });
    public static final BitSet FOLLOW_expression_in_incompleteExpression1241 = new BitSet(
            new long[] { 0x0000100000000000L });
    public static final BitSet FOLLOW_IDENTIFIER_in_incompleteExpression1243 = new BitSet(
            new long[] { 0x0000000000000002L });
    public static final BitSet FOLLOW_unary_in_incompleteConjunction1293 = new BitSet(
            new long[] { 0x0000000000000400L });
    public static final BitSet FOLLOW_AND_in_incompleteConjunction1296 = new BitSet(
            new long[] { 0xFFFFFFFFFFFFFFF0L, 0xFFFFFFFFFFFFFFFFL, 0xFFFFFFFFFFFFFFFFL,
                    0xFFFFFFFFFFFFFFFFL, 0xFFFFFFFFFFFFFFFFL, 0xFFFFFFFFFFFFFFFFL,
                    0xFFFFFFFFFFFFFFFFL, 0xFFFFFFFFFFFFFFFFL, 0xFFFFFFFFFFFFFFFFL,
                    0xFFFFFFFFFFFFFFFFL, 0xFFFFFFFFFFFFFFFFL, 0x00000000001FFFFFL });
    public static final BitSet FOLLOW_AND_in_incompleteConjunction1305 = new BitSet(
            new long[] { 0x0000300000081042L });
    public static final BitSet FOLLOW_incompleteUnary_in_incompleteConjunction1307 = new BitSet(
            new long[] { 0x0000000000000002L });
    public static final BitSet FOLLOW_INVERSE_in_incompleteComplexPropertyExpression1342 = new BitSet(
            new long[] { 0x0000000000000020L });
    public static final BitSet FOLLOW_OPEN_PARENTHESYS_in_incompleteComplexPropertyExpression1344 = new BitSet(
            new long[] { 0x0000000000000002L });
    public static final BitSet FOLLOW_NOT_in_incompleteUnary1371 = new BitSet(
            new long[] { 0x0000000000000020L });
    public static final BitSet FOLLOW_OPEN_PARENTHESYS_in_incompleteUnary1373 = new BitSet(
            new long[] { 0x0000000000000002L });
    public static final BitSet FOLLOW_incompleteQualifiedRestriction_in_incompleteUnary1406 = new BitSet(
            new long[] { 0x0000000000000002L });
    public static final BitSet FOLLOW_propertyExpression_in_incompleteQualifiedRestriction1448 = new BitSet(
            new long[] { 0x0000000000002000L });
    public static final BitSet FOLLOW_SOME_in_incompleteQualifiedRestriction1451 = new BitSet(
            new long[] { 0x0000000000000002L });
    public static final BitSet FOLLOW_propertyExpression_in_incompleteQualifiedRestriction1488 = new BitSet(
            new long[] { 0x0000000000004000L });
    public static final BitSet FOLLOW_ONLY_in_incompleteQualifiedRestriction1490 = new BitSet(
            new long[] { 0x0000000000000002L });
    public static final BitSet FOLLOW_incompleteOneOf_in_incompleteQualifiedRestriction1510 = new BitSet(
            new long[] { 0x0000000000000002L });
    public static final BitSet FOLLOW_incompleteCardinalityRestriction_in_incompleteQualifiedRestriction1521 = new BitSet(
            new long[] { 0x0000000000000002L });
    public static final BitSet FOLLOW_incompleteValueRestriction_in_incompleteQualifiedRestriction1537 = new BitSet(
            new long[] { 0x0000000000000002L });
    public static final BitSet FOLLOW_propertyExpression_in_incompleteCardinalityRestriction1570 = new BitSet(
            new long[] { 0x0000000000038000L });
    public static final BitSet FOLLOW_restrictionKind_in_incompleteCardinalityRestriction1573 = new BitSet(
            new long[] { 0x0000040000000000L });
    public static final BitSet FOLLOW_INTEGER_in_incompleteCardinalityRestriction1575 = new BitSet(
            new long[] { 0x0000000000000002L });
    public static final BitSet FOLLOW_OPEN_CURLY_BRACES_in_incompleteOneOf1606 = new BitSet(
            new long[] { 0x0000100000000000L });
    public static final BitSet FOLLOW_IDENTIFIER_in_incompleteOneOf1608 = new BitSet(
            new long[] { 0x0000002000000000L });
    public static final BitSet FOLLOW_COMMA_in_incompleteOneOf1611 = new BitSet(
            new long[] { 0x0000100000000000L });
    public static final BitSet FOLLOW_IDENTIFIER_in_incompleteOneOf1613 = new BitSet(
            new long[] { 0x0000002000000000L });
    public static final BitSet FOLLOW_COMMA_in_incompleteOneOf1617 = new BitSet(
            new long[] { 0x0000000000000002L });
    public static final BitSet FOLLOW_propertyExpression_in_incompleteValueRestriction1638 = new BitSet(
            new long[] { 0x0000000000040000L });
    public static final BitSet FOLLOW_VALUE_in_incompleteValueRestriction1640 = new BitSet(
            new long[] { 0x0000000000000002L });
    public static final BitSet FOLLOW_propertyExpression_in_synpred1_ManchesterOWLSyntaxAutoCompleteBase1121 = new BitSet(
            new long[] { 0x0000000000000010L });
    public static final BitSet FOLLOW_COMPOSITION_in_synpred1_ManchesterOWLSyntaxAutoCompleteBase1124 = new BitSet(
            new long[] { 0x0000300000080000L });
    public static final BitSet FOLLOW_propertyExpression_in_synpred1_ManchesterOWLSyntaxAutoCompleteBase1128 = new BitSet(
            new long[] { 0x0000000000000010L });
    public static final BitSet FOLLOW_COMPOSITION_in_synpred1_ManchesterOWLSyntaxAutoCompleteBase1133 = new BitSet(
            new long[] { 0x0000000000000002L });
    public static final BitSet FOLLOW_conjunction_in_synpred2_ManchesterOWLSyntaxAutoCompleteBase1162 = new BitSet(
            new long[] { 0x0000000000000800L });
    public static final BitSet FOLLOW_OR_in_synpred2_ManchesterOWLSyntaxAutoCompleteBase1165 = new BitSet(
            new long[] { 0xFFFFFFFFFFFFFFF0L, 0xFFFFFFFFFFFFFFFFL, 0xFFFFFFFFFFFFFFFFL,
                    0xFFFFFFFFFFFFFFFFL, 0xFFFFFFFFFFFFFFFFL, 0xFFFFFFFFFFFFFFFFL,
                    0xFFFFFFFFFFFFFFFFL, 0xFFFFFFFFFFFFFFFFL, 0xFFFFFFFFFFFFFFFFL,
                    0xFFFFFFFFFFFFFFFFL, 0xFFFFFFFFFFFFFFFFL, 0x00000000001FFFFFL });
    public static final BitSet FOLLOW_OR_in_synpred2_ManchesterOWLSyntaxAutoCompleteBase1172 = new BitSet(
            new long[] { 0x0000310000081040L });
    public static final BitSet FOLLOW_incompleteConjunction_in_synpred2_ManchesterOWLSyntaxAutoCompleteBase1175 = new BitSet(
            new long[] { 0x0000000000000002L });
    public static final BitSet FOLLOW_incompleteConjunction_in_synpred3_ManchesterOWLSyntaxAutoCompleteBase1199 = new BitSet(
            new long[] { 0x0000000000000002L });
    public static final BitSet FOLLOW_incompleteUnary_in_synpred4_ManchesterOWLSyntaxAutoCompleteBase1223 = new BitSet(
            new long[] { 0x0000000000000002L });
    public static final BitSet FOLLOW_propertyExpression_in_synpred5_ManchesterOWLSyntaxAutoCompleteBase1448 = new BitSet(
            new long[] { 0x0000000000002000L });
    public static final BitSet FOLLOW_SOME_in_synpred5_ManchesterOWLSyntaxAutoCompleteBase1451 = new BitSet(
            new long[] { 0x0000000000000002L });
    public static final BitSet FOLLOW_propertyExpression_in_synpred6_ManchesterOWLSyntaxAutoCompleteBase1488 = new BitSet(
            new long[] { 0x0000000000004000L });
    public static final BitSet FOLLOW_ONLY_in_synpred6_ManchesterOWLSyntaxAutoCompleteBase1490 = new BitSet(
            new long[] { 0x0000000000000002L });
    public static final BitSet FOLLOW_incompleteCardinalityRestriction_in_synpred8_ManchesterOWLSyntaxAutoCompleteBase1521 = new BitSet(
            new long[] { 0x0000000000000002L });
}
