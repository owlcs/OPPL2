// $ANTLR 3.2 Sep 23, 2009 12:02:23 /Users/luigi/Documents/workspace/Parsers/src/ManchesterOWLSyntaxAutoComplete.g 2010-09-22 16:51:43
package org.coode.parsers;

import static org.coode.oppl.utils.ArgCheck.checkNotNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.antlr.runtime.*;
import org.antlr.runtime.tree.RewriteEmptyStreamException;
import org.antlr.runtime.tree.TreeFilter;
import org.antlr.runtime.tree.TreeNodeStream;
import org.antlr.runtime.tree.TreeRuleReturnScope;
import org.semanticweb.owlapi.model.OWLObject;

@SuppressWarnings({ "javadoc", "incomplete-switch" })
public class ManchesterOWLSyntaxAutoComplete extends TreeFilter {

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
        "CONSTANT", "STANDALONE_EXPRESSION", "INCOMPLETE_TYPE_ASSERTION",
        "INCOMPLETE_ROLE_ASSERTION", "INCOMPLETE_UNARY_AXIOM",
        "INCOMPLETE_SUB_CLASS_AXIOM", "INCOMPLETE_EQUIVALENT_TO_AXIOM",
        "INCOMPLETE_DISJOINT_WITH_AXIOM", "INCOMPLETE_SUB_PROPERTY_AXIOM",
        "INCOMPLETE_SAME_AS_AXIOM", "INCOMPLETE_DIFFERENT_FROM_AXIOM",
        "INCOMPLETE_DOMAIN", "INCOMPLETE_RANGE", "INCOMPLETE_INVERSE_OF",
        "INCOMPLETE_PROPERTY_CHAIN", "INCOMPLETE_DISJUNCTION",
        "INCOMPLETE_CONJUNCTION", "INCOMPLETE_INVERSE_OBJECT_PROPERTY_EXPRESSION",
        "INCOMPLETE_NEGATED_EXPRESSION", "INCOMPLETE_SOME_RESTRICTION",
        "INCOMPLETE_ALL_RESTRICTION", "INCOMPLETE_CARDINALITY_RESTRICTION",
        "INCOMPLETE_ONE_OF", "INCOMPLETE_VALUE_RESTRICTION", "INCOMPLETE_EXPRESSION" };
    public static final int COMMA = 37;
    public static final int DIFFERENT_FROM = 24;
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
    public static final int RANGE = 28;
    public static final int CLOSED_PARENTHESYS = 8;
    public static final int PROPERTY_CHAIN = 57;
    public static final int EQUIVALENT_TO_AXIOM = 49;
    public static final int INCOMPLETE_ALL_RESTRICTION = 619;
    public static final int SYMMETRIC = 30;
    public static final int DISJOINT_WITH = 26;
    public static final int INCOMPLETE_VALUE_RESTRICTION = 622;
    public static final int DISJUNCTION = 55;
    public static final int INCOMPLETE_CARDINALITY_RESTRICTION = 620;
    public static final int NEGATED_EXPRESSION = 58;
    public static final int DIFFERENT_FROM_AXIOM = 53;
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
    public static final int INSTANCE_OF = 38;
    public static final int INCOMPLETE_DISJUNCTION = 614;
    public static final int SOME_RESTRICTION = 61;
    public static final int INCOMPLETE_SUB_PROPERTY_AXIOM = 607;
    public static final int INCOMPLETE_INVERSE_OF = 612;
    public static final int INCOMPLETE_DOMAIN = 610;
    public static final int VALUE = 18;
    public static final int INCOMPLETE_UNARY_AXIOM = 603;
    public static final int INVERSE_FUNCTIONAL = 35;
    public static final int OR = 11;
    public static final int INCOMPLETE_EXPRESSION = 623;
    public static final int INTEGER = 42;
    public static final int INVERSE = 19;
    public static final int DISJOINT_WITH_AXIOM = 50;
    public static final int INCOMPLETE_DISJOINT_WITH_AXIOM = 606;
    public static final int DIGIT = 41;
    public static final int COMPOSITION = 4;
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
    // delegators
    public ManchesterOWLSyntaxAutoComplete(TreeNodeStream input) {
        this(input, new RecognizerSharedState());
    }

    public ManchesterOWLSyntaxAutoComplete(TreeNodeStream input,
        RecognizerSharedState state) {
        super(input, state);
    }

    @Override
    public String[] getTokenNames() {
        return ManchesterOWLSyntaxAutoComplete.tokenNames;
    }

    @Override
    public String getGrammarFileName() {
        return "/Users/luigi/Documents/workspace/Parsers/src/ManchesterOWLSyntaxAutoComplete.g";
    }

    private SymbolTable symtab;
    private boolean newWord = false;

    public ManchesterOWLSyntaxAutoComplete(TreeNodeStream input, SymbolTable symtab) {
        this(input);
        this.symtab = checkNotNull(symtab, "symtab");
    }

    public boolean isNewWord() {
        return newWord;
    }

    public void setNewWord(boolean b) {
        newWord = b;
    }

    public SymbolTable getSymbolTable() {
        return symtab;
    }

    @Override
    public void displayRecognitionError(String[] t, RecognitionException e) {}

    @SuppressWarnings("unused")
    protected void mismatch(IntStream in, int ttype, BitSet follow) {}

    @Override
    public Object recoverFromMismatchedSet(IntStream in, RecognitionException e,
        BitSet follow) {
        return null;
    }

    // $ANTLR start "bottomup"
    // /Users/luigi/Documents/workspace/Parsers/src/ManchesterOWLSyntaxAutoComplete.g:72:1:
    // bottomup : ( | standaloneExpression | expressionRoot | incompleteAxiom |
    // incompleteExpression | axiom );
    @Override
    public final void bottomup() {
        try {
            // /Users/luigi/Documents/workspace/Parsers/src/ManchesterOWLSyntaxAutoComplete.g:73:5:
            // ( | standaloneExpression | expressionRoot | incompleteAxiom |
            // incompleteExpression | axiom )
            int alt1 = 6;
            switch (input.LA(1)) {
                case EOF: {
                    alt1 = 1;
                }
                    break;
                case STANDALONE_EXPRESSION: {
                    alt1 = 2;
                }
                    break;
                case EXPRESSION: {
                    alt1 = 3;
                }
                    break;
                case INCOMPLETE_TYPE_ASSERTION:
                case INCOMPLETE_ROLE_ASSERTION:
                case INCOMPLETE_UNARY_AXIOM:
                case INCOMPLETE_SUB_CLASS_AXIOM:
                case INCOMPLETE_EQUIVALENT_TO_AXIOM:
                case INCOMPLETE_DISJOINT_WITH_AXIOM:
                case INCOMPLETE_SUB_PROPERTY_AXIOM:
                case INCOMPLETE_SAME_AS_AXIOM:
                case INCOMPLETE_DIFFERENT_FROM_AXIOM:
                case INCOMPLETE_DOMAIN:
                case INCOMPLETE_RANGE:
                case INCOMPLETE_INVERSE_OF: {
                    alt1 = 4;
                }
                    break;
                case INCOMPLETE_PROPERTY_CHAIN:
                case INCOMPLETE_DISJUNCTION:
                case INCOMPLETE_EXPRESSION: {
                    alt1 = 5;
                }
                    break;
                case INVERSE_OF:
                case DOMAIN:
                case RANGE:
                case SUB_CLASS_AXIOM:
                case EQUIVALENT_TO_AXIOM:
                case DISJOINT_WITH_AXIOM:
                case SUB_PROPERTY_AXIOM:
                case SAME_AS_AXIOM:
                case DIFFERENT_FROM_AXIOM:
                case UNARY_AXIOM:
                case NEGATED_ASSERTION:
                case TYPE_ASSERTION:
                case ROLE_ASSERTION: {
                    alt1 = 6;
                }
                    break;
                default:
                    if (state.backtracking > 0) {
                        state.failed = true;
                        return;
                    }
                    NoViableAltException nvae = new NoViableAltException("", 1, 0, input);
                    throw nvae;
            }
            switch (alt1) {
                case 1:
                // /Users/luigi/Documents/workspace/Parsers/src/ManchesterOWLSyntaxAutoComplete.g:74:5:
                {}
                    break;
                case 2:
                // /Users/luigi/Documents/workspace/Parsers/src/ManchesterOWLSyntaxAutoComplete.g:74:7:
                // standaloneExpression
                {
                    pushFollow(FOLLOW_standaloneExpression_in_bottomup87);
                    standaloneExpression();
                    state._fsp--;
                    if (state.failed) {
                        return;
                    }
                }
                    break;
                case 3:
                // /Users/luigi/Documents/workspace/Parsers/src/ManchesterOWLSyntaxAutoComplete.g:75:8:
                // expressionRoot
                {
                    pushFollow(FOLLOW_expressionRoot_in_bottomup96);
                    expressionRoot();
                    state._fsp--;
                    if (state.failed) {
                        return;
                    }
                }
                    break;
                case 4:
                // /Users/luigi/Documents/workspace/Parsers/src/ManchesterOWLSyntaxAutoComplete.g:76:9:
                // incompleteAxiom
                {
                    pushFollow(FOLLOW_incompleteAxiom_in_bottomup107);
                    incompleteAxiom();
                    state._fsp--;
                    if (state.failed) {
                        return;
                    }
                }
                    break;
                case 5:
                // /Users/luigi/Documents/workspace/Parsers/src/ManchesterOWLSyntaxAutoComplete.g:77:9:
                // incompleteExpression
                {
                    pushFollow(FOLLOW_incompleteExpression_in_bottomup117);
                    incompleteExpression();
                    state._fsp--;
                    if (state.failed) {
                        return;
                    }
                }
                    break;
                case 6:
                // /Users/luigi/Documents/workspace/Parsers/src/ManchesterOWLSyntaxAutoComplete.g:78:8:
                // axiom
                {
                    pushFollow(FOLLOW_axiom_in_bottomup126);
                    axiom();
                    state._fsp--;
                    if (state.failed) {
                        return;
                    }
                }
                    break;
            }
        } catch (@SuppressWarnings("unused") RecognitionException | RewriteEmptyStreamException exception) {}
        return;
    }

    // $ANTLR end "bottomup"
    // $ANTLR start "expressionRoot"
    // /Users/luigi/Documents/workspace/Parsers/src/ManchesterOWLSyntaxAutoComplete.g:81:1:
    // expressionRoot : ^( EXPRESSION e= expression ) ;
    public final void expressionRoot() {
        ManchesterOWLSyntaxTree EXPRESSION1 = null;
        ManchesterOWLSyntaxAutoComplete.expression_return e = null;
        try {
            // /Users/luigi/Documents/workspace/Parsers/src/ManchesterOWLSyntaxAutoComplete.g:82:5:
            // ( ^( EXPRESSION e= expression ) )
            // /Users/luigi/Documents/workspace/Parsers/src/ManchesterOWLSyntaxAutoComplete.g:82:9:
            // ^( EXPRESSION e= expression )
            {
                EXPRESSION1 = (ManchesterOWLSyntaxTree) match(input, EXPRESSION,
                    FOLLOW_EXPRESSION_in_expressionRoot155);
                if (state.failed) {
                    return;
                }
                match(input, Token.DOWN, null);
                if (state.failed) {
                    return;
                }
                pushFollow(FOLLOW_expression_in_expressionRoot161);
                e = expression();
                state._fsp--;
                if (state.failed) {
                    return;
                }
                match(input, Token.UP, null);
                if (state.failed) {
                    return;
                }
                if (state.backtracking == 1) {
                    EXPRESSION1.setCompletions(e.node.getCompletions());
                }
            }
        } catch (@SuppressWarnings("unused") RecognitionException | RewriteEmptyStreamException exception) {}
        return;
    }

    // $ANTLR end "expressionRoot"
    // $ANTLR start "standaloneExpression"
    // /Users/luigi/Documents/workspace/Parsers/src/ManchesterOWLSyntaxAutoComplete.g:87:1:
    // standaloneExpression : ^( STANDALONE_EXPRESSION ^( EXPRESSION e=
    // expression ) ) ;
    public final void standaloneExpression() {
        ManchesterOWLSyntaxTree STANDALONE_EXPRESSION2 = null;
        ManchesterOWLSyntaxAutoComplete.expression_return e = null;
        try {
            // /Users/luigi/Documents/workspace/Parsers/src/ManchesterOWLSyntaxAutoComplete.g:88:3:
            // ( ^( STANDALONE_EXPRESSION ^( EXPRESSION e= expression ) ) )
            // /Users/luigi/Documents/workspace/Parsers/src/ManchesterOWLSyntaxAutoComplete.g:88:5:
            // ^( STANDALONE_EXPRESSION ^( EXPRESSION e= expression ) )
            {
                STANDALONE_EXPRESSION2 = (ManchesterOWLSyntaxTree) match(input,
                    STANDALONE_EXPRESSION,
                    FOLLOW_STANDALONE_EXPRESSION_in_standaloneExpression183);
                if (state.failed) {
                    return;
                }
                match(input, Token.DOWN, null);
                if (state.failed) {
                    return;
                }
                match(input, EXPRESSION, FOLLOW_EXPRESSION_in_standaloneExpression186);
                if (state.failed) {
                    return;
                }
                match(input, Token.DOWN, null);
                if (state.failed) {
                    return;
                }
                pushFollow(FOLLOW_expression_in_standaloneExpression191);
                e = expression();
                state._fsp--;
                if (state.failed) {
                    return;
                }
                match(input, Token.UP, null);
                if (state.failed) {
                    return;
                }
                match(input, Token.UP, null);
                if (state.failed) {
                    return;
                }
                if (state.backtracking == 1) {
                    List<String> completions = new ArrayList<>();
                    if (!isNewWord()) {
                        completions.addAll(e.node.getCompletions());
                    } else {
                        if (e.node.getEvalType() != null) {
                            completions.addAll(AutoCompleteStrings
                                .getStandaloneExpressionCompletions(e.node
                                    .getEvalType()));
                        }
                    }
                    STANDALONE_EXPRESSION2.setCompletions(completions);
                }
            }
        } catch (@SuppressWarnings("unused") RecognitionException | RewriteEmptyStreamException exception) {}
        return;
    }

    // $ANTLR end "standaloneExpression"
    public static class expression_return extends TreeRuleReturnScope {

        public ManchesterOWLSyntaxTree node;
    }

    // $ANTLR start "expression"
    // /Users/luigi/Documents/workspace/Parsers/src/ManchesterOWLSyntaxAutoComplete.g:102:1:
    // expression returns [ManchesterOWLSyntaxTree node] : ( ^( DISJUNCTION (c=
    // conjunction )+ ) | ^( PROPERTY_CHAIN (chainItem= expression )+ ) | conj=
    // conjunction | cpe= complexPropertyExpression );
    public final ManchesterOWLSyntaxAutoComplete.expression_return expression() {
        ManchesterOWLSyntaxAutoComplete.expression_return retval = new ManchesterOWLSyntaxAutoComplete.expression_return();
        retval.start = input.LT(1);
        ManchesterOWLSyntaxAutoComplete.conjunction_return c = null;
        ManchesterOWLSyntaxAutoComplete.expression_return chainItem = null;
        ManchesterOWLSyntaxAutoComplete.conjunction_return conj = null;
        ManchesterOWLSyntaxAutoComplete.complexPropertyExpression_return cpe = null;
        try {
            // /Users/luigi/Documents/workspace/Parsers/src/ManchesterOWLSyntaxAutoComplete.g:106:2:
            // ( ^( DISJUNCTION (c= conjunction )+ ) | ^( PROPERTY_CHAIN
            // (chainItem= expression )+ ) | conj= conjunction | cpe=
            // complexPropertyExpression )
            int alt4 = 4;
            switch (input.LA(1)) {
                case DISJUNCTION: {
                    alt4 = 1;
                }
                    break;
                case PROPERTY_CHAIN: {
                    alt4 = 2;
                }
                    break;
                case IDENTIFIER:
                case ENTITY_REFERENCE:
                case CONJUNCTION:
                case NEGATED_EXPRESSION:
                case SOME_RESTRICTION:
                case ALL_RESTRICTION:
                case VALUE_RESTRICTION:
                case CARDINALITY_RESTRICTION:
                case ONE_OF: {
                    alt4 = 3;
                }
                    break;
                case INVERSE_OBJECT_PROPERTY_EXPRESSION: {
                    alt4 = 4;
                }
                    break;
                default:
                    if (state.backtracking > 0) {
                        state.failed = true;
                        return retval;
                    }
                    NoViableAltException nvae = new NoViableAltException("", 4, 0, input);
                    throw nvae;
            }
            switch (alt4) {
                case 1:
                // /Users/luigi/Documents/workspace/Parsers/src/ManchesterOWLSyntaxAutoComplete.g:107:4:
                // ^( DISJUNCTION (c= conjunction )+ )
                {
                    match(input, DISJUNCTION, FOLLOW_DISJUNCTION_in_expression226);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.DOWN, null);
                    if (state.failed) {
                        return retval;
                    }
                    // /Users/luigi/Documents/workspace/Parsers/src/ManchesterOWLSyntaxAutoComplete.g:107:19:
                    // (c= conjunction )+
                    int cnt2 = 0;
                    loop2: do {
                        int alt2 = 2;
                        int LA2_0 = input.LA(1);
                        if (LA2_0 >= IDENTIFIER && LA2_0 <= ENTITY_REFERENCE
                            || LA2_0 == CONJUNCTION || LA2_0 == NEGATED_EXPRESSION
                            || LA2_0 >= SOME_RESTRICTION && LA2_0 <= ONE_OF) {
                            alt2 = 1;
                        }
                        switch (alt2) {
                            case 1:
                            // /Users/luigi/Documents/workspace/Parsers/src/ManchesterOWLSyntaxAutoComplete.g:107:21:
                            // c= conjunction
                            {
                                pushFollow(FOLLOW_conjunction_in_expression235);
                                c = conjunction();
                                state._fsp--;
                                if (state.failed) {
                                    return retval;
                                }
                                if (state.backtracking == 1) {
                                    ((ManchesterOWLSyntaxTree) retval.start)
                                        .setCompletions(c.node.getCompletions());
                                }
                            }
                                break;
                            default:
                                if (cnt2 >= 1) {
                                    break loop2;
                                }
                                if (state.backtracking > 0) {
                                    state.failed = true;
                                    return retval;
                                }
                                EarlyExitException eee = new EarlyExitException(2, input);
                                throw eee;
                        }
                        cnt2++;
                    } while (true);
                    match(input, Token.UP, null);
                    if (state.failed) {
                        return retval;
                    }
                }
                    break;
                case 2:
                // /Users/luigi/Documents/workspace/Parsers/src/ManchesterOWLSyntaxAutoComplete.g:110:6:
                // ^( PROPERTY_CHAIN (chainItem= expression )+ )
                {
                    match(input, PROPERTY_CHAIN, FOLLOW_PROPERTY_CHAIN_in_expression248);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.DOWN, null);
                    if (state.failed) {
                        return retval;
                    }
                    // /Users/luigi/Documents/workspace/Parsers/src/ManchesterOWLSyntaxAutoComplete.g:110:24:
                    // (chainItem= expression )+
                    int cnt3 = 0;
                    loop3: do {
                        int alt3 = 2;
                        int LA3_0 = input.LA(1);
                        if (LA3_0 >= IDENTIFIER && LA3_0 <= ENTITY_REFERENCE
                            || LA3_0 >= DISJUNCTION && LA3_0 <= NEGATED_EXPRESSION
                            || LA3_0 >= SOME_RESTRICTION && LA3_0 <= ONE_OF
                            || LA3_0 == INVERSE_OBJECT_PROPERTY_EXPRESSION) {
                            alt3 = 1;
                        }
                        switch (alt3) {
                            case 1:
                            // /Users/luigi/Documents/workspace/Parsers/src/ManchesterOWLSyntaxAutoComplete.g:110:25:
                            // chainItem= expression
                            {
                                pushFollow(FOLLOW_expression_in_expression256);
                                chainItem = expression();
                                state._fsp--;
                                if (state.failed) {
                                    return retval;
                                }
                                if (state.backtracking == 1) {
                                    ((ManchesterOWLSyntaxTree) retval.start)
                                        .setCompletions(chainItem.node
                                            .getCompletions());
                                }
                            }
                                break;
                            default:
                                if (cnt3 >= 1) {
                                    break loop3;
                                }
                                if (state.backtracking > 0) {
                                    state.failed = true;
                                    return retval;
                                }
                                EarlyExitException eee = new EarlyExitException(3, input);
                                throw eee;
                        }
                        cnt3++;
                    } while (true);
                    match(input, Token.UP, null);
                    if (state.failed) {
                        return retval;
                    }
                }
                    break;
                case 3:
                // /Users/luigi/Documents/workspace/Parsers/src/ManchesterOWLSyntaxAutoComplete.g:114:5:
                // conj= conjunction
                {
                    pushFollow(FOLLOW_conjunction_in_expression276);
                    conj = conjunction();
                    state._fsp--;
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 1) {
                        ((ManchesterOWLSyntaxTree) retval.start).setCompletions(conj.node
                            .getCompletions());
                    }
                }
                    break;
                case 4:
                // /Users/luigi/Documents/workspace/Parsers/src/ManchesterOWLSyntaxAutoComplete.g:118:5:
                // cpe= complexPropertyExpression
                {
                    pushFollow(FOLLOW_complexPropertyExpression_in_expression291);
                    cpe = complexPropertyExpression();
                    state._fsp--;
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 1) {
                        ((ManchesterOWLSyntaxTree) retval.start).setCompletions(cpe.node
                            .getCompletions());
                    }
                }
                    break;
            }
            if (state.backtracking == 1) {
                retval.node = (ManchesterOWLSyntaxTree) retval.start;
            }
        } catch (@SuppressWarnings("unused") RecognitionException | RewriteEmptyStreamException exception) {}
        return retval;
    }

    // $ANTLR end "expression"
    public static class conjunction_return extends TreeRuleReturnScope {

        public ManchesterOWLSyntaxTree node;
    }

    // $ANTLR start "conjunction"
    // /Users/luigi/Documents/workspace/Parsers/src/ManchesterOWLSyntaxAutoComplete.g:125:1:
    // conjunction returns [ManchesterOWLSyntaxTree node] : ( ^( CONJUNCTION
    // (conjunct= unary )+ ) | u= unary );
    public final ManchesterOWLSyntaxAutoComplete.conjunction_return conjunction() {
        ManchesterOWLSyntaxAutoComplete.conjunction_return retval = new ManchesterOWLSyntaxAutoComplete.conjunction_return();
        retval.start = input.LT(1);
        ManchesterOWLSyntaxAutoComplete.unary_return conjunct = null;
        ManchesterOWLSyntaxAutoComplete.unary_return u = null;
        try {
            // /Users/luigi/Documents/workspace/Parsers/src/ManchesterOWLSyntaxAutoComplete.g:130:2:
            // ( ^( CONJUNCTION (conjunct= unary )+ ) | u= unary )
            int alt6 = 2;
            int LA6_0 = input.LA(1);
            if (LA6_0 == CONJUNCTION) {
                alt6 = 1;
            } else if (LA6_0 >= IDENTIFIER && LA6_0 <= ENTITY_REFERENCE
                || LA6_0 == NEGATED_EXPRESSION || LA6_0 >= SOME_RESTRICTION
                    && LA6_0 <= ONE_OF) {
                alt6 = 2;
            } else {
                if (state.backtracking > 0) {
                    state.failed = true;
                    return retval;
                }
                NoViableAltException nvae = new NoViableAltException("", 6, 0, input);
                throw nvae;
            }
            switch (alt6) {
                case 1:
                // /Users/luigi/Documents/workspace/Parsers/src/ManchesterOWLSyntaxAutoComplete.g:131:2:
                // ^( CONJUNCTION (conjunct= unary )+ )
                {
                    match(input, CONJUNCTION, FOLLOW_CONJUNCTION_in_conjunction328);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.DOWN, null);
                    if (state.failed) {
                        return retval;
                    }
                    // /Users/luigi/Documents/workspace/Parsers/src/ManchesterOWLSyntaxAutoComplete.g:131:17:
                    // (conjunct= unary )+
                    int cnt5 = 0;
                    loop5: do {
                        int alt5 = 2;
                        int LA5_0 = input.LA(1);
                        if (LA5_0 >= IDENTIFIER && LA5_0 <= ENTITY_REFERENCE
                            || LA5_0 == NEGATED_EXPRESSION
                            || LA5_0 >= SOME_RESTRICTION && LA5_0 <= ONE_OF) {
                            alt5 = 1;
                        }
                        switch (alt5) {
                            case 1:
                            // /Users/luigi/Documents/workspace/Parsers/src/ManchesterOWLSyntaxAutoComplete.g:131:18:
                            // conjunct= unary
                            {
                                pushFollow(FOLLOW_unary_in_conjunction334);
                                conjunct = unary();
                                state._fsp--;
                                if (state.failed) {
                                    return retval;
                                }
                                if (state.backtracking == 1) {
                                    ((ManchesterOWLSyntaxTree) retval.start)
                                        .setCompletions(conjunct.node
                                            .getCompletions());
                                }
                            }
                                break;
                            default:
                                if (cnt5 >= 1) {
                                    break loop5;
                                }
                                if (state.backtracking > 0) {
                                    state.failed = true;
                                    return retval;
                                }
                                EarlyExitException eee = new EarlyExitException(5, input);
                                throw eee;
                        }
                        cnt5++;
                    } while (true);
                    match(input, Token.UP, null);
                    if (state.failed) {
                        return retval;
                    }
                }
                    break;
                case 2:
                // /Users/luigi/Documents/workspace/Parsers/src/ManchesterOWLSyntaxAutoComplete.g:134:4:
                // u= unary
                {
                    pushFollow(FOLLOW_unary_in_conjunction349);
                    u = unary();
                    state._fsp--;
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 1) {
                        ((ManchesterOWLSyntaxTree) retval.start).setCompletions(u.node
                            .getCompletions());
                    }
                }
                    break;
            }
            if (state.backtracking == 1) {
                retval.node = (ManchesterOWLSyntaxTree) retval.start;
            }
        } catch (@SuppressWarnings("unused") RecognitionException | RewriteEmptyStreamException exception) {}
        return retval;
    }

    // $ANTLR end "conjunction"
    public static class unary_return extends TreeRuleReturnScope {

        public ManchesterOWLSyntaxTree node;
    }

    // $ANTLR start "unary"
    // /Users/luigi/Documents/workspace/Parsers/src/ManchesterOWLSyntaxAutoComplete.g:139:1:
    // unary returns [ManchesterOWLSyntaxTree node] : ( IDENTIFIER | ^(
    // NEGATED_EXPRESSION e= expression ) | qualifiedRestriction |
    // ENTITY_REFERENCE );
    public final ManchesterOWLSyntaxAutoComplete.unary_return unary() {
        ManchesterOWLSyntaxAutoComplete.unary_return retval = new ManchesterOWLSyntaxAutoComplete.unary_return();
        retval.start = input.LT(1);
        ManchesterOWLSyntaxTree IDENTIFIER3 = null;
        ManchesterOWLSyntaxTree ENTITY_REFERENCE5 = null;
        ManchesterOWLSyntaxAutoComplete.expression_return e = null;
        ManchesterOWLSyntaxAutoComplete.qualifiedRestriction_return qualifiedRestriction4 = null;
        try {
            // /Users/luigi/Documents/workspace/Parsers/src/ManchesterOWLSyntaxAutoComplete.g:144:1:
            // ( IDENTIFIER | ^( NEGATED_EXPRESSION e= expression ) |
            // qualifiedRestriction | ENTITY_REFERENCE )
            int alt7 = 4;
            switch (input.LA(1)) {
                case IDENTIFIER: {
                    alt7 = 1;
                }
                    break;
                case NEGATED_EXPRESSION: {
                    alt7 = 2;
                }
                    break;
                case SOME_RESTRICTION:
                case ALL_RESTRICTION:
                case VALUE_RESTRICTION:
                case CARDINALITY_RESTRICTION:
                case ONE_OF: {
                    alt7 = 3;
                }
                    break;
                case ENTITY_REFERENCE: {
                    alt7 = 4;
                }
                    break;
                default:
                    if (state.backtracking > 0) {
                        state.failed = true;
                        return retval;
                    }
                    NoViableAltException nvae = new NoViableAltException("", 7, 0, input);
                    throw nvae;
            }
            switch (alt7) {
                case 1:
                // /Users/luigi/Documents/workspace/Parsers/src/ManchesterOWLSyntaxAutoComplete.g:145:3:
                // IDENTIFIER
                {
                    IDENTIFIER3 = (ManchesterOWLSyntaxTree) match(input, IDENTIFIER,
                        FOLLOW_IDENTIFIER_in_unary376);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 1) {
                        ((ManchesterOWLSyntaxTree) retval.start)
                            .setCompletions(getSymbolTable().match(
                                IDENTIFIER3.getText()));
                    }
                }
                    break;
                case 2:
                // /Users/luigi/Documents/workspace/Parsers/src/ManchesterOWLSyntaxAutoComplete.g:150:5:
                // ^( NEGATED_EXPRESSION e= expression )
                {
                    match(input, NEGATED_EXPRESSION,
                        FOLLOW_NEGATED_EXPRESSION_in_unary389);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.DOWN, null);
                    if (state.failed) {
                        return retval;
                    }
                    pushFollow(FOLLOW_expression_in_unary395);
                    e = expression();
                    state._fsp--;
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.UP, null);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 1) {
                        ((ManchesterOWLSyntaxTree) retval.start).setCompletions(e.node
                            .getCompletions());
                    }
                }
                    break;
                case 3:
                // /Users/luigi/Documents/workspace/Parsers/src/ManchesterOWLSyntaxAutoComplete.g:154:5:
                // qualifiedRestriction
                {
                    pushFollow(FOLLOW_qualifiedRestriction_in_unary409);
                    qualifiedRestriction4 = qualifiedRestriction();
                    state._fsp--;
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 1) {
                        ((ManchesterOWLSyntaxTree) retval.start)
                            .setCompletions(qualifiedRestriction4.node
                                .getCompletions());
                    }
                }
                    break;
                case 4:
                // /Users/luigi/Documents/workspace/Parsers/src/ManchesterOWLSyntaxAutoComplete.g:158:5:
                // ENTITY_REFERENCE
                {
                    ENTITY_REFERENCE5 = (ManchesterOWLSyntaxTree) match(input,
                        ENTITY_REFERENCE, FOLLOW_ENTITY_REFERENCE_in_unary423);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 1) {
                        ((ManchesterOWLSyntaxTree) retval.start)
                            .setCompletions(getSymbolTable().match(
                                ENTITY_REFERENCE5.getText()));
                    }
                }
                    break;
            }
            if (state.backtracking == 1) {
                retval.node = (ManchesterOWLSyntaxTree) retval.start;
            }
        } catch (@SuppressWarnings("unused") RecognitionException | RewriteEmptyStreamException exception) {}
        return retval;
    }

    // $ANTLR end "unary"
    public static class propertyExpression_return extends TreeRuleReturnScope {

        public Type type;
        public ManchesterOWLSyntaxTree node;
        public OWLObject owlObject;
    }

    // $ANTLR start "propertyExpression"
    // /Users/luigi/Documents/workspace/Parsers/src/ManchesterOWLSyntaxAutoComplete.g:165:1:
    // propertyExpression returns [Type type, ManchesterOWLSyntaxTree node,
    // OWLObject owlObject] : ( IDENTIFIER | ENTITY_REFERENCE |
    // complexPropertyExpression );
    public final ManchesterOWLSyntaxAutoComplete.propertyExpression_return propertyExpression() {
        ManchesterOWLSyntaxAutoComplete.propertyExpression_return retval = new ManchesterOWLSyntaxAutoComplete.propertyExpression_return();
        retval.start = input.LT(1);
        ManchesterOWLSyntaxTree IDENTIFIER6 = null;
        ManchesterOWLSyntaxTree ENTITY_REFERENCE7 = null;
        ManchesterOWLSyntaxAutoComplete.complexPropertyExpression_return complexPropertyExpression8 = null;
        try {
            // /Users/luigi/Documents/workspace/Parsers/src/ManchesterOWLSyntaxAutoComplete.g:171:1:
            // ( IDENTIFIER | ENTITY_REFERENCE | complexPropertyExpression )
            int alt8 = 3;
            switch (input.LA(1)) {
                case IDENTIFIER: {
                    alt8 = 1;
                }
                    break;
                case ENTITY_REFERENCE: {
                    alt8 = 2;
                }
                    break;
                case INVERSE_OBJECT_PROPERTY_EXPRESSION: {
                    alt8 = 3;
                }
                    break;
                default:
                    if (state.backtracking > 0) {
                        state.failed = true;
                        return retval;
                    }
                    NoViableAltException nvae = new NoViableAltException("", 8, 0, input);
                    throw nvae;
            }
            switch (alt8) {
                case 1:
                // /Users/luigi/Documents/workspace/Parsers/src/ManchesterOWLSyntaxAutoComplete.g:172:7:
                // IDENTIFIER
                {
                    IDENTIFIER6 = (ManchesterOWLSyntaxTree) match(input, IDENTIFIER,
                        FOLLOW_IDENTIFIER_in_propertyExpression462);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 1) {
                        ((ManchesterOWLSyntaxTree) retval.start)
                            .setCompletions(getSymbolTable().match(
                                IDENTIFIER6.getText()));
                    }
                }
                    break;
                case 2:
                // /Users/luigi/Documents/workspace/Parsers/src/ManchesterOWLSyntaxAutoComplete.g:176:9:
                // ENTITY_REFERENCE
                {
                    ENTITY_REFERENCE7 = (ManchesterOWLSyntaxTree) match(input,
                        ENTITY_REFERENCE,
                        FOLLOW_ENTITY_REFERENCE_in_propertyExpression480);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 1) {
                        ((ManchesterOWLSyntaxTree) retval.start)
                            .setCompletions(getSymbolTable().match(
                                ENTITY_REFERENCE7.getText()));
                    }
                }
                    break;
                case 3:
                // /Users/luigi/Documents/workspace/Parsers/src/ManchesterOWLSyntaxAutoComplete.g:180:7:
                // complexPropertyExpression
                {
                    pushFollow(FOLLOW_complexPropertyExpression_in_propertyExpression494);
                    complexPropertyExpression8 = complexPropertyExpression();
                    state._fsp--;
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 1) {
                        ((ManchesterOWLSyntaxTree) retval.start)
                            .setCompletions(getSymbolTable()
                                .match(complexPropertyExpression8 != null ? complexPropertyExpression8.node
                                    .getText() : null));
                    }
                }
                    break;
            }
            if (state.backtracking == 1) {
                retval.node = (ManchesterOWLSyntaxTree) retval.start;
            }
        } catch (@SuppressWarnings("unused") RecognitionException | RewriteEmptyStreamException exception) {}
        return retval;
    }

    // $ANTLR end "propertyExpression"
    public static class complexPropertyExpression_return extends TreeRuleReturnScope {

        public ManchesterOWLSyntaxTree node;
    }

    // $ANTLR start "complexPropertyExpression"
    // /Users/luigi/Documents/workspace/Parsers/src/ManchesterOWLSyntaxAutoComplete.g:186:1:
    // complexPropertyExpression returns [ManchesterOWLSyntaxTree node] : ( ^(
    // INVERSE_OBJECT_PROPERTY_EXPRESSION p= complexPropertyExpression ) | ^(
    // INVERSE_OBJECT_PROPERTY_EXPRESSION IDENTIFIER ) | ^(
    // INVERSE_OBJECT_PROPERTY_EXPRESSION ENTITY_REFERENCE ) );
    public final ManchesterOWLSyntaxAutoComplete.complexPropertyExpression_return complexPropertyExpression() {
        ManchesterOWLSyntaxAutoComplete.complexPropertyExpression_return retval = new ManchesterOWLSyntaxAutoComplete.complexPropertyExpression_return();
        retval.start = input.LT(1);
        ManchesterOWLSyntaxTree IDENTIFIER9 = null;
        ManchesterOWLSyntaxTree ENTITY_REFERENCE10 = null;
        ManchesterOWLSyntaxAutoComplete.complexPropertyExpression_return p = null;
        try {
            // /Users/luigi/Documents/workspace/Parsers/src/ManchesterOWLSyntaxAutoComplete.g:190:1:
            // ( ^( INVERSE_OBJECT_PROPERTY_EXPRESSION p=
            // complexPropertyExpression ) | ^(
            // INVERSE_OBJECT_PROPERTY_EXPRESSION IDENTIFIER ) | ^(
            // INVERSE_OBJECT_PROPERTY_EXPRESSION ENTITY_REFERENCE ) )
            int alt9 = 3;
            int LA9_0 = input.LA(1);
            if (LA9_0 == INVERSE_OBJECT_PROPERTY_EXPRESSION) {
                int LA9_1 = input.LA(2);
                if (LA9_1 == DOWN) {
                    switch (input.LA(3)) {
                        case IDENTIFIER: {
                            alt9 = 2;
                        }
                            break;
                        case ENTITY_REFERENCE: {
                            alt9 = 3;
                        }
                            break;
                        case INVERSE_OBJECT_PROPERTY_EXPRESSION: {
                            alt9 = 1;
                        }
                            break;
                        default:
                            if (state.backtracking > 0) {
                                state.failed = true;
                                return retval;
                            }
                            NoViableAltException nvae = new NoViableAltException("", 9,
                                2, input);
                            throw nvae;
                    }
                } else {
                    if (state.backtracking > 0) {
                        state.failed = true;
                        return retval;
                    }
                    NoViableAltException nvae = new NoViableAltException("", 9, 1, input);
                    throw nvae;
                }
            } else {
                if (state.backtracking > 0) {
                    state.failed = true;
                    return retval;
                }
                NoViableAltException nvae = new NoViableAltException("", 9, 0, input);
                throw nvae;
            }
            switch (alt9) {
                case 1:
                // /Users/luigi/Documents/workspace/Parsers/src/ManchesterOWLSyntaxAutoComplete.g:191:2:
                // ^( INVERSE_OBJECT_PROPERTY_EXPRESSION p=
                // complexPropertyExpression )
                {
                    match(input, INVERSE_OBJECT_PROPERTY_EXPRESSION,
                        FOLLOW_INVERSE_OBJECT_PROPERTY_EXPRESSION_in_complexPropertyExpression528);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.DOWN, null);
                    if (state.failed) {
                        return retval;
                    }
                    pushFollow(FOLLOW_complexPropertyExpression_in_complexPropertyExpression534);
                    p = complexPropertyExpression();
                    state._fsp--;
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.UP, null);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 1) {
                        ((ManchesterOWLSyntaxTree) retval.start).setCompletions(p.node
                            .getCompletions());
                    }
                }
                    break;
                case 2:
                // /Users/luigi/Documents/workspace/Parsers/src/ManchesterOWLSyntaxAutoComplete.g:195:4:
                // ^( INVERSE_OBJECT_PROPERTY_EXPRESSION IDENTIFIER )
                {
                    match(input, INVERSE_OBJECT_PROPERTY_EXPRESSION,
                        FOLLOW_INVERSE_OBJECT_PROPERTY_EXPRESSION_in_complexPropertyExpression544);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.DOWN, null);
                    if (state.failed) {
                        return retval;
                    }
                    IDENTIFIER9 = (ManchesterOWLSyntaxTree) match(input, IDENTIFIER,
                        FOLLOW_IDENTIFIER_in_complexPropertyExpression546);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.UP, null);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 1) {
                        ((ManchesterOWLSyntaxTree) retval.start)
                            .setCompletions(getSymbolTable().match(
                                IDENTIFIER9.getText()));
                    }
                }
                    break;
                case 3:
                // /Users/luigi/Documents/workspace/Parsers/src/ManchesterOWLSyntaxAutoComplete.g:199:4:
                // ^( INVERSE_OBJECT_PROPERTY_EXPRESSION ENTITY_REFERENCE )
                {
                    match(input, INVERSE_OBJECT_PROPERTY_EXPRESSION,
                        FOLLOW_INVERSE_OBJECT_PROPERTY_EXPRESSION_in_complexPropertyExpression556);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.DOWN, null);
                    if (state.failed) {
                        return retval;
                    }
                    ENTITY_REFERENCE10 = (ManchesterOWLSyntaxTree) match(input,
                        ENTITY_REFERENCE,
                        FOLLOW_ENTITY_REFERENCE_in_complexPropertyExpression558);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.UP, null);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 1) {
                        ((ManchesterOWLSyntaxTree) retval.start)
                            .setCompletions(getSymbolTable().match(
                                ENTITY_REFERENCE10.getText()));
                    }
                }
                    break;
            }
            if (state.backtracking == 1) {
                retval.node = (ManchesterOWLSyntaxTree) retval.start;
            }
        } catch (@SuppressWarnings("unused") RecognitionException | RewriteEmptyStreamException exception) {}
        return retval;
    }

    // $ANTLR end "complexPropertyExpression"
    public static class qualifiedRestriction_return extends TreeRuleReturnScope {

        public ManchesterOWLSyntaxTree node;
    }

    // $ANTLR start "qualifiedRestriction"
    // /Users/luigi/Documents/workspace/Parsers/src/ManchesterOWLSyntaxAutoComplete.g:205:1:
    // qualifiedRestriction returns [ManchesterOWLSyntaxTree node] : ( ^(
    // SOME_RESTRICTION p= propertyExpression f= expression ) | ^(
    // ALL_RESTRICTION p= propertyExpression f= expression ) |
    // cardinalityRestriction | oneOf | valueRestriction );
    public final ManchesterOWLSyntaxAutoComplete.qualifiedRestriction_return qualifiedRestriction() {
        ManchesterOWLSyntaxAutoComplete.qualifiedRestriction_return retval = new ManchesterOWLSyntaxAutoComplete.qualifiedRestriction_return();
        retval.start = input.LT(1);
        ManchesterOWLSyntaxAutoComplete.expression_return f = null;
        ManchesterOWLSyntaxAutoComplete.cardinalityRestriction_return cardinalityRestriction11 = null;
        ManchesterOWLSyntaxAutoComplete.oneOf_return oneOf12 = null;
        ManchesterOWLSyntaxAutoComplete.valueRestriction_return valueRestriction13 = null;
        try {
            // /Users/luigi/Documents/workspace/Parsers/src/ManchesterOWLSyntaxAutoComplete.g:209:2:
            // ( ^( SOME_RESTRICTION p= propertyExpression f= expression ) | ^(
            // ALL_RESTRICTION p= propertyExpression f= expression ) |
            // cardinalityRestriction | oneOf | valueRestriction )
            int alt10 = 5;
            switch (input.LA(1)) {
                case SOME_RESTRICTION: {
                    alt10 = 1;
                }
                    break;
                case ALL_RESTRICTION: {
                    alt10 = 2;
                }
                    break;
                case CARDINALITY_RESTRICTION: {
                    alt10 = 3;
                }
                    break;
                case ONE_OF: {
                    alt10 = 4;
                }
                    break;
                case VALUE_RESTRICTION: {
                    alt10 = 5;
                }
                    break;
                default:
                    if (state.backtracking > 0) {
                        state.failed = true;
                        return retval;
                    }
                    NoViableAltException nvae = new NoViableAltException("", 10, 0, input);
                    throw nvae;
            }
            switch (alt10) {
                case 1:
                // /Users/luigi/Documents/workspace/Parsers/src/ManchesterOWLSyntaxAutoComplete.g:210:6:
                // ^( SOME_RESTRICTION p= propertyExpression f= expression )
                {
                    match(input, SOME_RESTRICTION,
                        FOLLOW_SOME_RESTRICTION_in_qualifiedRestriction589);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.DOWN, null);
                    if (state.failed) {
                        return retval;
                    }
                    pushFollow(FOLLOW_propertyExpression_in_qualifiedRestriction594);
                    propertyExpression();
                    state._fsp--;
                    if (state.failed) {
                        return retval;
                    }
                    pushFollow(FOLLOW_expression_in_qualifiedRestriction600);
                    f = expression();
                    state._fsp--;
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.UP, null);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 1) {
                        ((ManchesterOWLSyntaxTree) retval.start).setCompletions(f.node
                            .getCompletions());
                    }
                }
                    break;
                case 2:
                // /Users/luigi/Documents/workspace/Parsers/src/ManchesterOWLSyntaxAutoComplete.g:214:7:
                // ^( ALL_RESTRICTION p= propertyExpression f= expression )
                {
                    match(input, ALL_RESTRICTION,
                        FOLLOW_ALL_RESTRICTION_in_qualifiedRestriction622);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.DOWN, null);
                    if (state.failed) {
                        return retval;
                    }
                    pushFollow(FOLLOW_propertyExpression_in_qualifiedRestriction629);
                    propertyExpression();
                    state._fsp--;
                    if (state.failed) {
                        return retval;
                    }
                    pushFollow(FOLLOW_expression_in_qualifiedRestriction634);
                    f = expression();
                    state._fsp--;
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.UP, null);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 1) {
                        ((ManchesterOWLSyntaxTree) retval.start).setCompletions(f.node
                            .getCompletions());
                    }
                }
                    break;
                case 3:
                // /Users/luigi/Documents/workspace/Parsers/src/ManchesterOWLSyntaxAutoComplete.g:218:7:
                // cardinalityRestriction
                {
                    pushFollow(FOLLOW_cardinalityRestriction_in_qualifiedRestriction650);
                    cardinalityRestriction11 = cardinalityRestriction();
                    state._fsp--;
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 1) {
                        ((ManchesterOWLSyntaxTree) retval.start)
                            .setCompletions(cardinalityRestriction11 != null ? cardinalityRestriction11.node
                                .getCompletions() : null);
                    }
                }
                    break;
                case 4:
                // /Users/luigi/Documents/workspace/Parsers/src/ManchesterOWLSyntaxAutoComplete.g:222:7:
                // oneOf
                {
                    pushFollow(FOLLOW_oneOf_in_qualifiedRestriction666);
                    oneOf12 = oneOf();
                    state._fsp--;
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 1) {
                        ((ManchesterOWLSyntaxTree) retval.start)
                            .setCompletions(oneOf12 != null ? oneOf12.node
                                .getCompletions() : null);
                    }
                }
                    break;
                case 5:
                // /Users/luigi/Documents/workspace/Parsers/src/ManchesterOWLSyntaxAutoComplete.g:226:7:
                // valueRestriction
                {
                    pushFollow(FOLLOW_valueRestriction_in_qualifiedRestriction682);
                    valueRestriction13 = valueRestriction();
                    state._fsp--;
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 1) {
                        ((ManchesterOWLSyntaxTree) retval.start)
                            .setCompletions(valueRestriction13 != null ? valueRestriction13.node
                                .getCompletions() : null);
                    }
                }
                    break;
            }
            if (state.backtracking == 1) {
                retval.node = (ManchesterOWLSyntaxTree) retval.start;
            }
        } catch (@SuppressWarnings("unused") RecognitionException | RewriteEmptyStreamException exception) {}
        return retval;
    }

    // $ANTLR end "qualifiedRestriction"
    public static class cardinalityRestriction_return extends TreeRuleReturnScope {

        public ManchesterOWLSyntaxTree node;
    }

    // $ANTLR start "cardinalityRestriction"
    // /Users/luigi/Documents/workspace/Parsers/src/ManchesterOWLSyntaxAutoComplete.g:234:1:
    // cardinalityRestriction returns [ ManchesterOWLSyntaxTree node] : ( ^(
    // CARDINALITY_RESTRICTION MIN i= INTEGER p= unary (filler= expression )? )
    // | ^( CARDINALITY_RESTRICTION MAX i= INTEGER p= unary (filler= expression
    // )? ) | ^( CARDINALITY_RESTRICTION EXACTLY i= INTEGER p= unary (filler=
    // expression )? ) );
    public final ManchesterOWLSyntaxAutoComplete.cardinalityRestriction_return cardinalityRestriction() {
        ManchesterOWLSyntaxAutoComplete.cardinalityRestriction_return retval = new ManchesterOWLSyntaxAutoComplete.cardinalityRestriction_return();
        retval.start = input.LT(1);
        ManchesterOWLSyntaxAutoComplete.unary_return p = null;
        ManchesterOWLSyntaxAutoComplete.expression_return filler = null;
        try {
            // /Users/luigi/Documents/workspace/Parsers/src/ManchesterOWLSyntaxAutoComplete.g:238:1:
            // ( ^( CARDINALITY_RESTRICTION MIN i= INTEGER p= unary (filler=
            // expression )? ) | ^( CARDINALITY_RESTRICTION MAX i= INTEGER p=
            // unary (filler= expression )? ) | ^( CARDINALITY_RESTRICTION
            // EXACTLY i= INTEGER p= unary (filler= expression )? ) )
            int alt14 = 3;
            int LA14_0 = input.LA(1);
            if (LA14_0 == CARDINALITY_RESTRICTION) {
                int LA14_1 = input.LA(2);
                if (LA14_1 == DOWN) {
                    switch (input.LA(3)) {
                        case MIN: {
                            alt14 = 1;
                        }
                            break;
                        case MAX: {
                            alt14 = 2;
                        }
                            break;
                        case EXACTLY: {
                            alt14 = 3;
                        }
                            break;
                        default:
                            if (state.backtracking > 0) {
                                state.failed = true;
                                return retval;
                            }
                            NoViableAltException nvae = new NoViableAltException("", 14,
                                2, input);
                            throw nvae;
                    }
                } else {
                    if (state.backtracking > 0) {
                        state.failed = true;
                        return retval;
                    }
                    NoViableAltException nvae = new NoViableAltException("", 14, 1, input);
                    throw nvae;
                }
            } else {
                if (state.backtracking > 0) {
                    state.failed = true;
                    return retval;
                }
                NoViableAltException nvae = new NoViableAltException("", 14, 0, input);
                throw nvae;
            }
            switch (alt14) {
                case 1:
                // /Users/luigi/Documents/workspace/Parsers/src/ManchesterOWLSyntaxAutoComplete.g:239:5:
                // ^( CARDINALITY_RESTRICTION MIN i= INTEGER p= unary (filler=
                // expression )? )
                {
                    match(input, CARDINALITY_RESTRICTION,
                        FOLLOW_CARDINALITY_RESTRICTION_in_cardinalityRestriction719);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.DOWN, null);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, MIN, FOLLOW_MIN_in_cardinalityRestriction722);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, INTEGER, FOLLOW_INTEGER_in_cardinalityRestriction727);
                    if (state.failed) {
                        return retval;
                    }
                    pushFollow(FOLLOW_unary_in_cardinalityRestriction733);
                    p = unary();
                    state._fsp--;
                    if (state.failed) {
                        return retval;
                    }
                    // /Users/luigi/Documents/workspace/Parsers/src/ManchesterOWLSyntaxAutoComplete.g:239:65:
                    // (filler= expression )?
                    int alt11 = 2;
                    int LA11_0 = input.LA(1);
                    if (LA11_0 >= IDENTIFIER && LA11_0 <= ENTITY_REFERENCE
                        || LA11_0 >= DISJUNCTION && LA11_0 <= NEGATED_EXPRESSION
                        || LA11_0 >= SOME_RESTRICTION && LA11_0 <= ONE_OF
                        || LA11_0 == INVERSE_OBJECT_PROPERTY_EXPRESSION) {
                        alt11 = 1;
                    }
                    switch (alt11) {
                        case 1:
                        // /Users/luigi/Documents/workspace/Parsers/src/ManchesterOWLSyntaxAutoComplete.g:239:65:
                        // filler= expression
                        {
                            pushFollow(FOLLOW_expression_in_cardinalityRestriction740);
                            filler = expression();
                            state._fsp--;
                            if (state.failed) {
                                return retval;
                            }
                        }
                            break;
                    }
                    match(input, Token.UP, null);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 1) {
                        ((ManchesterOWLSyntaxTree) retval.start)
                            .setCompletions(filler == null ? p.node.getCompletions()
                                : filler.node.getCompletions());
                    }
                }
                    break;
                case 2:
                // /Users/luigi/Documents/workspace/Parsers/src/ManchesterOWLSyntaxAutoComplete.g:243:6:
                // ^( CARDINALITY_RESTRICTION MAX i= INTEGER p= unary (filler=
                // expression )? )
                {
                    match(input, CARDINALITY_RESTRICTION,
                        FOLLOW_CARDINALITY_RESTRICTION_in_cardinalityRestriction755);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.DOWN, null);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, MAX, FOLLOW_MAX_in_cardinalityRestriction758);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, INTEGER, FOLLOW_INTEGER_in_cardinalityRestriction762);
                    if (state.failed) {
                        return retval;
                    }
                    pushFollow(FOLLOW_unary_in_cardinalityRestriction768);
                    p = unary();
                    state._fsp--;
                    if (state.failed) {
                        return retval;
                    }
                    // /Users/luigi/Documents/workspace/Parsers/src/ManchesterOWLSyntaxAutoComplete.g:243:65:
                    // (filler= expression )?
                    int alt12 = 2;
                    int LA12_0 = input.LA(1);
                    if (LA12_0 >= IDENTIFIER && LA12_0 <= ENTITY_REFERENCE
                        || LA12_0 >= DISJUNCTION && LA12_0 <= NEGATED_EXPRESSION
                        || LA12_0 >= SOME_RESTRICTION && LA12_0 <= ONE_OF
                        || LA12_0 == INVERSE_OBJECT_PROPERTY_EXPRESSION) {
                        alt12 = 1;
                    }
                    switch (alt12) {
                        case 1:
                        // /Users/luigi/Documents/workspace/Parsers/src/ManchesterOWLSyntaxAutoComplete.g:243:65:
                        // filler= expression
                        {
                            pushFollow(FOLLOW_expression_in_cardinalityRestriction775);
                            filler = expression();
                            state._fsp--;
                            if (state.failed) {
                                return retval;
                            }
                        }
                            break;
                    }
                    match(input, Token.UP, null);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 1) {
                        ((ManchesterOWLSyntaxTree) retval.start)
                            .setCompletions(filler == null ? p.node.getCompletions()
                                : filler.node.getCompletions());
                    }
                }
                    break;
                case 3:
                // /Users/luigi/Documents/workspace/Parsers/src/ManchesterOWLSyntaxAutoComplete.g:247:6:
                // ^( CARDINALITY_RESTRICTION EXACTLY i= INTEGER p= unary
                // (filler= expression )? )
                {
                    match(input, CARDINALITY_RESTRICTION,
                        FOLLOW_CARDINALITY_RESTRICTION_in_cardinalityRestriction794);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.DOWN, null);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, EXACTLY, FOLLOW_EXACTLY_in_cardinalityRestriction797);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, INTEGER, FOLLOW_INTEGER_in_cardinalityRestriction802);
                    if (state.failed) {
                        return retval;
                    }
                    pushFollow(FOLLOW_unary_in_cardinalityRestriction809);
                    p = unary();
                    state._fsp--;
                    if (state.failed) {
                        return retval;
                    }
                    // /Users/luigi/Documents/workspace/Parsers/src/ManchesterOWLSyntaxAutoComplete.g:247:71:
                    // (filler= expression )?
                    int alt13 = 2;
                    int LA13_0 = input.LA(1);
                    if (LA13_0 >= IDENTIFIER && LA13_0 <= ENTITY_REFERENCE
                        || LA13_0 >= DISJUNCTION && LA13_0 <= NEGATED_EXPRESSION
                        || LA13_0 >= SOME_RESTRICTION && LA13_0 <= ONE_OF
                        || LA13_0 == INVERSE_OBJECT_PROPERTY_EXPRESSION) {
                        alt13 = 1;
                    }
                    switch (alt13) {
                        case 1:
                        // /Users/luigi/Documents/workspace/Parsers/src/ManchesterOWLSyntaxAutoComplete.g:247:71:
                        // filler= expression
                        {
                            pushFollow(FOLLOW_expression_in_cardinalityRestriction816);
                            filler = expression();
                            state._fsp--;
                            if (state.failed) {
                                return retval;
                            }
                        }
                            break;
                    }
                    match(input, Token.UP, null);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 1) {
                        ((ManchesterOWLSyntaxTree) retval.start)
                            .setCompletions(filler == null ? p.node.getCompletions()
                                : filler.node.getCompletions());
                    }
                }
                    break;
            }
            if (state.backtracking == 1) {
                retval.node = (ManchesterOWLSyntaxTree) retval.start;
            }
        } catch (@SuppressWarnings("unused") RecognitionException | RewriteEmptyStreamException exception) {}
        return retval;
    }

    // $ANTLR end "cardinalityRestriction"
    public static class oneOf_return extends TreeRuleReturnScope {

        public Type type;
        public ManchesterOWLSyntaxTree node;
        public OWLObject owlObject;
    }

    // $ANTLR start "oneOf"
    // /Users/luigi/Documents/workspace/Parsers/src/ManchesterOWLSyntaxAutoComplete.g:253:1:
    // oneOf returns [Type type , ManchesterOWLSyntaxTree node, OWLObject
    // owlObject] : ^( ONE_OF (individual= unary )+ ) ;
    public final ManchesterOWLSyntaxAutoComplete.oneOf_return oneOf() {
        ManchesterOWLSyntaxAutoComplete.oneOf_return retval = new ManchesterOWLSyntaxAutoComplete.oneOf_return();
        retval.start = input.LT(1);
        ManchesterOWLSyntaxAutoComplete.unary_return individual = null;
        try {
            // /Users/luigi/Documents/workspace/Parsers/src/ManchesterOWLSyntaxAutoComplete.g:257:2:
            // ( ^( ONE_OF (individual= unary )+ ) )
            // /Users/luigi/Documents/workspace/Parsers/src/ManchesterOWLSyntaxAutoComplete.g:258:3:
            // ^( ONE_OF (individual= unary )+ )
            {
                match(input, ONE_OF, FOLLOW_ONE_OF_in_oneOf849);
                if (state.failed) {
                    return retval;
                }
                match(input, Token.DOWN, null);
                if (state.failed) {
                    return retval;
                }
                // /Users/luigi/Documents/workspace/Parsers/src/ManchesterOWLSyntaxAutoComplete.g:258:12:
                // (individual= unary )+
                int cnt15 = 0;
                loop15: do {
                    int alt15 = 2;
                    int LA15_0 = input.LA(1);
                    if (LA15_0 >= IDENTIFIER && LA15_0 <= ENTITY_REFERENCE
                        || LA15_0 == NEGATED_EXPRESSION || LA15_0 >= SOME_RESTRICTION
                            && LA15_0 <= ONE_OF) {
                        alt15 = 1;
                    }
                    switch (alt15) {
                        case 1:
                        // /Users/luigi/Documents/workspace/Parsers/src/ManchesterOWLSyntaxAutoComplete.g:258:13:
                        // individual= unary
                        {
                            pushFollow(FOLLOW_unary_in_oneOf854);
                            individual = unary();
                            state._fsp--;
                            if (state.failed) {
                                return retval;
                            }
                            if (state.backtracking == 1) {
                                ((ManchesterOWLSyntaxTree) retval.start)
                                    .setCompletions(individual.node.getCompletions());
                            }
                        }
                            break;
                        default:
                            if (cnt15 >= 1) {
                                break loop15;
                            }
                            if (state.backtracking > 0) {
                                state.failed = true;
                                return retval;
                            }
                            EarlyExitException eee = new EarlyExitException(15, input);
                            throw eee;
                    }
                    cnt15++;
                } while (true);
                match(input, Token.UP, null);
                if (state.failed) {
                    return retval;
                }
            }
            if (state.backtracking == 1) {
                retval.node = (ManchesterOWLSyntaxTree) retval.start;
            }
        } catch (@SuppressWarnings("unused") RecognitionException | RewriteEmptyStreamException exception) {}
        return retval;
    }

    // $ANTLR end "oneOf"
    public static class valueRestriction_return extends TreeRuleReturnScope {

        public Type type;
        public ManchesterOWLSyntaxTree node;
        public OWLObject owlObject;
    }

    // $ANTLR start "valueRestriction"
    // /Users/luigi/Documents/workspace/Parsers/src/ManchesterOWLSyntaxAutoComplete.g:264:1:
    // valueRestriction returns [Type type , ManchesterOWLSyntaxTree node,
    // OWLObject owlObject] : ^( VALUE_RESTRICTION p= unary value= unary ) ;
    public final ManchesterOWLSyntaxAutoComplete.valueRestriction_return valueRestriction() {
        ManchesterOWLSyntaxAutoComplete.valueRestriction_return retval = new ManchesterOWLSyntaxAutoComplete.valueRestriction_return();
        retval.start = input.LT(1);
        ManchesterOWLSyntaxAutoComplete.unary_return value = null;
        try {
            // /Users/luigi/Documents/workspace/Parsers/src/ManchesterOWLSyntaxAutoComplete.g:268:2:
            // ( ^( VALUE_RESTRICTION p= unary value= unary ) )
            // /Users/luigi/Documents/workspace/Parsers/src/ManchesterOWLSyntaxAutoComplete.g:269:3:
            // ^( VALUE_RESTRICTION p= unary value= unary )
            {
                match(input, VALUE_RESTRICTION,
                    FOLLOW_VALUE_RESTRICTION_in_valueRestriction889);
                if (state.failed) {
                    return retval;
                }
                match(input, Token.DOWN, null);
                if (state.failed) {
                    return retval;
                }
                pushFollow(FOLLOW_unary_in_valueRestriction896);
                unary();
                state._fsp--;
                if (state.failed) {
                    return retval;
                }
                pushFollow(FOLLOW_unary_in_valueRestriction903);
                value = unary();
                state._fsp--;
                if (state.failed) {
                    return retval;
                }
                match(input, Token.UP, null);
                if (state.failed) {
                    return retval;
                }
                if (state.backtracking == 1) {
                    ((ManchesterOWLSyntaxTree) retval.start).setCompletions(value.node
                        .getCompletions());
                }
            }
            if (state.backtracking == 1) {
                retval.node = (ManchesterOWLSyntaxTree) retval.start;
            }
        } catch (@SuppressWarnings("unused") RecognitionException | RewriteEmptyStreamException exception) {}
        return retval;
    }

    // $ANTLR end "valueRestriction"
    public static class axiom_return extends TreeRuleReturnScope {

        public List<String> completions;
    }

    // $ANTLR start "axiom"
    // /Users/luigi/Documents/workspace/Parsers/src/ManchesterOWLSyntaxAutoComplete.g:277:1:
    // axiom returns [List<String> completions] : ( ^( SUB_CLASS_AXIOM ^(
    // EXPRESSION subClass= expression ) ^( EXPRESSION superClass= expression )
    // ) | ^( EQUIVALENT_TO_AXIOM ^( EXPRESSION lhs= expression ) ^( EXPRESSION
    // rhs= expression ) ) | ^( INVERSE_OF ^( EXPRESSION p= IDENTIFIER ) ^(
    // EXPRESSION anotherProperty= IDENTIFIER ) ) | ^( DISJOINT_WITH_AXIOM ^(
    // EXPRESSION lhs= expression ) ^( EXPRESSION rhs= expression ) ) | ^(
    // SUB_PROPERTY_AXIOM ^( EXPRESSION subProperty= expression ) ^( EXPRESSION
    // superProperty= unary ) ) | ^( ROLE_ASSERTION ^( EXPRESSION subject=
    // IDENTIFIER ) ^( EXPRESSION predicate= propertyExpression ) ^( EXPRESSION
    // object= unary ) ) | ^( TYPE_ASSERTION ^( EXPRESSION description=
    // expression ) ^( EXPRESSION subject= IDENTIFIER ) ) | ^( DOMAIN ^(
    // EXPRESSION p= IDENTIFIER ) ^( EXPRESSION domain= expression ) ) | ^(
    // RANGE ^( EXPRESSION p= IDENTIFIER ) ^( EXPRESSION range= expression ) ) |
    // ^( SAME_AS_AXIOM ^( EXPRESSION anIndividual= IDENTIFIER ) ^( EXPRESSION
    // anotherIndividual= IDENTIFIER ) ) | ^( DIFFERENT_FROM_AXIOM ^( EXPRESSION
    // anIndividual= IDENTIFIER ) ^( EXPRESSION anotherIndividual= IDENTIFIER )
    // ) | ^( UNARY_AXIOM FUNCTIONAL ^( EXPRESSION p= IDENTIFIER ) ) | ^(
    // UNARY_AXIOM INVERSE_FUNCTIONAL ^( EXPRESSION p= IDENTIFIER ) ) | ^(
    // UNARY_AXIOM IRREFLEXIVE ^( EXPRESSION p= IDENTIFIER ) ) | ^( UNARY_AXIOM
    // REFLEXIVE ^( EXPRESSION p= IDENTIFIER ) ) | ^( UNARY_AXIOM SYMMETRIC ^(
    // EXPRESSION p= IDENTIFIER ) ) | ^( UNARY_AXIOM TRANSITIVE ^( EXPRESSION p=
    // IDENTIFIER ) ) | ^( NEGATED_ASSERTION a= axiom ) );
    public final ManchesterOWLSyntaxAutoComplete.axiom_return axiom() {
        ManchesterOWLSyntaxAutoComplete.axiom_return retval = new ManchesterOWLSyntaxAutoComplete.axiom_return();
        retval.start = input.LT(1);
        ManchesterOWLSyntaxTree p = null;
        ManchesterOWLSyntaxTree anotherProperty = null;
        ManchesterOWLSyntaxTree subject = null;
        ManchesterOWLSyntaxTree anotherIndividual = null;
        ManchesterOWLSyntaxAutoComplete.expression_return superClass = null;
        ManchesterOWLSyntaxAutoComplete.expression_return rhs = null;
        ManchesterOWLSyntaxAutoComplete.unary_return superProperty = null;
        ManchesterOWLSyntaxAutoComplete.unary_return object = null;
        ManchesterOWLSyntaxAutoComplete.expression_return domain = null;
        ManchesterOWLSyntaxAutoComplete.expression_return range = null;
        ManchesterOWLSyntaxAutoComplete.axiom_return a = null;
        try {
            // /Users/luigi/Documents/workspace/Parsers/src/ManchesterOWLSyntaxAutoComplete.g:284:1:
            // ( ^( SUB_CLASS_AXIOM ^( EXPRESSION subClass= expression ) ^(
            // EXPRESSION superClass= expression ) ) | ^( EQUIVALENT_TO_AXIOM ^(
            // EXPRESSION lhs= expression ) ^( EXPRESSION rhs= expression ) ) |
            // ^( INVERSE_OF ^( EXPRESSION p= IDENTIFIER ) ^( EXPRESSION
            // anotherProperty= IDENTIFIER ) ) | ^( DISJOINT_WITH_AXIOM ^(
            // EXPRESSION lhs= expression ) ^( EXPRESSION rhs= expression ) ) |
            // ^( SUB_PROPERTY_AXIOM ^( EXPRESSION subProperty= expression ) ^(
            // EXPRESSION superProperty= unary ) ) | ^( ROLE_ASSERTION ^(
            // EXPRESSION subject= IDENTIFIER ) ^( EXPRESSION predicate=
            // propertyExpression ) ^( EXPRESSION object= unary ) ) | ^(
            // TYPE_ASSERTION ^( EXPRESSION description= expression ) ^(
            // EXPRESSION subject= IDENTIFIER ) ) | ^( DOMAIN ^( EXPRESSION p=
            // IDENTIFIER ) ^( EXPRESSION domain= expression ) ) | ^( RANGE ^(
            // EXPRESSION p= IDENTIFIER ) ^( EXPRESSION range= expression ) ) |
            // ^( SAME_AS_AXIOM ^( EXPRESSION anIndividual= IDENTIFIER ) ^(
            // EXPRESSION anotherIndividual= IDENTIFIER ) ) | ^(
            // DIFFERENT_FROM_AXIOM ^( EXPRESSION anIndividual= IDENTIFIER ) ^(
            // EXPRESSION anotherIndividual= IDENTIFIER ) ) | ^( UNARY_AXIOM
            // FUNCTIONAL ^( EXPRESSION p= IDENTIFIER ) ) | ^( UNARY_AXIOM
            // INVERSE_FUNCTIONAL ^( EXPRESSION p= IDENTIFIER ) ) | ^(
            // UNARY_AXIOM IRREFLEXIVE ^( EXPRESSION p= IDENTIFIER ) ) | ^(
            // UNARY_AXIOM REFLEXIVE ^( EXPRESSION p= IDENTIFIER ) ) | ^(
            // UNARY_AXIOM SYMMETRIC ^( EXPRESSION p= IDENTIFIER ) ) | ^(
            // UNARY_AXIOM TRANSITIVE ^( EXPRESSION p= IDENTIFIER ) ) | ^(
            // NEGATED_ASSERTION a= axiom ) )
            int alt16 = 18;
            alt16 = dfa16.predict(input);
            switch (alt16) {
                case 1:
                // /Users/luigi/Documents/workspace/Parsers/src/ManchesterOWLSyntaxAutoComplete.g:285:3:
                // ^( SUB_CLASS_AXIOM ^( EXPRESSION subClass= expression ) ^(
                // EXPRESSION superClass= expression ) )
                {
                    match(input, SUB_CLASS_AXIOM, FOLLOW_SUB_CLASS_AXIOM_in_axiom936);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.DOWN, null);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, EXPRESSION, FOLLOW_EXPRESSION_in_axiom940);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.DOWN, null);
                    if (state.failed) {
                        return retval;
                    }
                    pushFollow(FOLLOW_expression_in_axiom947);
                    expression();
                    state._fsp--;
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.UP, null);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, EXPRESSION, FOLLOW_EXPRESSION_in_axiom952);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.DOWN, null);
                    if (state.failed) {
                        return retval;
                    }
                    pushFollow(FOLLOW_expression_in_axiom959);
                    superClass = expression();
                    state._fsp--;
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.UP, null);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.UP, null);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 1) {
                        if (!isNewWord()) {
                            retval.completions = new ArrayList<>(
                                superClass.node.getCompletions());
                        } else {
                            retval.completions = new ArrayList<>(
                                AutoCompleteStrings
                                    .getStandaloneExpressionCompletions(superClass.node
                                        .getEvalType()));
                        }
                    }
                }
                    break;
                case 2:
                // /Users/luigi/Documents/workspace/Parsers/src/ManchesterOWLSyntaxAutoComplete.g:293:5:
                // ^( EQUIVALENT_TO_AXIOM ^( EXPRESSION lhs= expression ) ^(
                // EXPRESSION rhs= expression ) )
                {
                    match(input, EQUIVALENT_TO_AXIOM,
                        FOLLOW_EQUIVALENT_TO_AXIOM_in_axiom972);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.DOWN, null);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, EXPRESSION, FOLLOW_EXPRESSION_in_axiom975);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.DOWN, null);
                    if (state.failed) {
                        return retval;
                    }
                    pushFollow(FOLLOW_expression_in_axiom981);
                    expression();
                    state._fsp--;
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.UP, null);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, EXPRESSION, FOLLOW_EXPRESSION_in_axiom985);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.DOWN, null);
                    if (state.failed) {
                        return retval;
                    }
                    pushFollow(FOLLOW_expression_in_axiom992);
                    rhs = expression();
                    state._fsp--;
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.UP, null);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.UP, null);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 1) {
                        if (!isNewWord()) {
                            retval.completions = new ArrayList<>(
                                rhs.node.getCompletions());
                        } else {
                            retval.completions = Collections.<String> emptyList();
                        }
                    }
                }
                    break;
                case 3:
                // /Users/luigi/Documents/workspace/Parsers/src/ManchesterOWLSyntaxAutoComplete.g:301:4:
                // ^( INVERSE_OF ^( EXPRESSION p= IDENTIFIER ) ^( EXPRESSION
                // anotherProperty= IDENTIFIER ) )
                {
                    match(input, INVERSE_OF, FOLLOW_INVERSE_OF_in_axiom1007);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.DOWN, null);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, EXPRESSION, FOLLOW_EXPRESSION_in_axiom1010);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.DOWN, null);
                    if (state.failed) {
                        return retval;
                    }
                    p = (ManchesterOWLSyntaxTree) match(input, IDENTIFIER,
                        FOLLOW_IDENTIFIER_in_axiom1016);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.UP, null);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, EXPRESSION, FOLLOW_EXPRESSION_in_axiom1020);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.DOWN, null);
                    if (state.failed) {
                        return retval;
                    }
                    anotherProperty = (ManchesterOWLSyntaxTree) match(input, IDENTIFIER,
                        FOLLOW_IDENTIFIER_in_axiom1026);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.UP, null);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.UP, null);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 1) {
                        if (!isNewWord()) {
                            retval.completions = anotherProperty.getCompletions();
                        } else {
                            retval.completions = Collections.<String> emptyList();
                        }
                    }
                }
                    break;
                case 4:
                // /Users/luigi/Documents/workspace/Parsers/src/ManchesterOWLSyntaxAutoComplete.g:309:5:
                // ^( DISJOINT_WITH_AXIOM ^( EXPRESSION lhs= expression ) ^(
                // EXPRESSION rhs= expression ) )
                {
                    match(input, DISJOINT_WITH_AXIOM,
                        FOLLOW_DISJOINT_WITH_AXIOM_in_axiom1038);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.DOWN, null);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, EXPRESSION, FOLLOW_EXPRESSION_in_axiom1041);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.DOWN, null);
                    if (state.failed) {
                        return retval;
                    }
                    pushFollow(FOLLOW_expression_in_axiom1048);
                    expression();
                    state._fsp--;
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.UP, null);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, EXPRESSION, FOLLOW_EXPRESSION_in_axiom1052);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.DOWN, null);
                    if (state.failed) {
                        return retval;
                    }
                    pushFollow(FOLLOW_expression_in_axiom1058);
                    rhs = expression();
                    state._fsp--;
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.UP, null);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.UP, null);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 1) {
                        if (!isNewWord()) {
                            retval.completions = new ArrayList<>(
                                rhs.node.getCompletions());
                        } else {
                            retval.completions = Collections.<String> emptyList();
                        }
                    }
                }
                    break;
                case 5:
                // /Users/luigi/Documents/workspace/Parsers/src/ManchesterOWLSyntaxAutoComplete.g:316:4:
                // ^( SUB_PROPERTY_AXIOM ^( EXPRESSION subProperty= expression )
                // ^( EXPRESSION superProperty= unary ) )
                {
                    match(input, SUB_PROPERTY_AXIOM,
                        FOLLOW_SUB_PROPERTY_AXIOM_in_axiom1070);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.DOWN, null);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, EXPRESSION, FOLLOW_EXPRESSION_in_axiom1073);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.DOWN, null);
                    if (state.failed) {
                        return retval;
                    }
                    pushFollow(FOLLOW_expression_in_axiom1080);
                    expression();
                    state._fsp--;
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.UP, null);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, EXPRESSION, FOLLOW_EXPRESSION_in_axiom1084);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.DOWN, null);
                    if (state.failed) {
                        return retval;
                    }
                    pushFollow(FOLLOW_unary_in_axiom1090);
                    superProperty = unary();
                    state._fsp--;
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.UP, null);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.UP, null);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 1) {
                        if (!isNewWord()) {
                            retval.completions = new ArrayList<>(
                                superProperty.node.getCompletions());
                        } else {
                            retval.completions = Collections.<String> emptyList();
                        }
                    }
                }
                    break;
                case 6:
                // /Users/luigi/Documents/workspace/Parsers/src/ManchesterOWLSyntaxAutoComplete.g:324:4:
                // ^( ROLE_ASSERTION ^( EXPRESSION subject= IDENTIFIER ) ^(
                // EXPRESSION predicate= propertyExpression ) ^( EXPRESSION
                // object= unary ) )
                {
                    match(input, ROLE_ASSERTION, FOLLOW_ROLE_ASSERTION_in_axiom1104);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.DOWN, null);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, EXPRESSION, FOLLOW_EXPRESSION_in_axiom1107);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.DOWN, null);
                    if (state.failed) {
                        return retval;
                    }
                    subject = (ManchesterOWLSyntaxTree) match(input, IDENTIFIER,
                        FOLLOW_IDENTIFIER_in_axiom1114);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.UP, null);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, EXPRESSION, FOLLOW_EXPRESSION_in_axiom1118);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.DOWN, null);
                    if (state.failed) {
                        return retval;
                    }
                    pushFollow(FOLLOW_propertyExpression_in_axiom1125);
                    propertyExpression();
                    state._fsp--;
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.UP, null);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, EXPRESSION, FOLLOW_EXPRESSION_in_axiom1129);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.DOWN, null);
                    if (state.failed) {
                        return retval;
                    }
                    pushFollow(FOLLOW_unary_in_axiom1135);
                    object = unary();
                    state._fsp--;
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.UP, null);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.UP, null);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 1) {
                        if (!isNewWord()) {
                            retval.completions = new ArrayList<>(
                                object.node.getCompletions());
                        } else {
                            retval.completions = Collections.<String> emptyList();
                        }
                    }
                }
                    break;
                case 7:
                // /Users/luigi/Documents/workspace/Parsers/src/ManchesterOWLSyntaxAutoComplete.g:331:5:
                // ^( TYPE_ASSERTION ^( EXPRESSION description= expression ) ^(
                // EXPRESSION subject= IDENTIFIER ) )
                {
                    match(input, TYPE_ASSERTION, FOLLOW_TYPE_ASSERTION_in_axiom1145);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.DOWN, null);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, EXPRESSION, FOLLOW_EXPRESSION_in_axiom1148);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.DOWN, null);
                    if (state.failed) {
                        return retval;
                    }
                    pushFollow(FOLLOW_expression_in_axiom1155);
                    expression();
                    state._fsp--;
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.UP, null);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, EXPRESSION, FOLLOW_EXPRESSION_in_axiom1159);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.DOWN, null);
                    if (state.failed) {
                        return retval;
                    }
                    subject = (ManchesterOWLSyntaxTree) match(input, IDENTIFIER,
                        FOLLOW_IDENTIFIER_in_axiom1165);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.UP, null);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.UP, null);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 1) {
                        if (!isNewWord()) {
                            retval.completions = subject.getCompletions();
                        } else {
                            retval.completions = Collections.<String> emptyList();
                        }
                    }
                }
                    break;
                case 8:
                // /Users/luigi/Documents/workspace/Parsers/src/ManchesterOWLSyntaxAutoComplete.g:339:4:
                // ^( DOMAIN ^( EXPRESSION p= IDENTIFIER ) ^( EXPRESSION domain=
                // expression ) )
                {
                    match(input, DOMAIN, FOLLOW_DOMAIN_in_axiom1177);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.DOWN, null);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, EXPRESSION, FOLLOW_EXPRESSION_in_axiom1180);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.DOWN, null);
                    if (state.failed) {
                        return retval;
                    }
                    p = (ManchesterOWLSyntaxTree) match(input, IDENTIFIER,
                        FOLLOW_IDENTIFIER_in_axiom1186);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.UP, null);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, EXPRESSION, FOLLOW_EXPRESSION_in_axiom1190);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.DOWN, null);
                    if (state.failed) {
                        return retval;
                    }
                    pushFollow(FOLLOW_expression_in_axiom1196);
                    domain = expression();
                    state._fsp--;
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.UP, null);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.UP, null);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 1) {
                        if (!isNewWord()) {
                            retval.completions = new ArrayList<>(
                                domain.node.getCompletions());
                        } else {
                            retval.completions = Collections.<String> emptyList();
                        }
                    }
                }
                    break;
                case 9:
                // /Users/luigi/Documents/workspace/Parsers/src/ManchesterOWLSyntaxAutoComplete.g:347:5:
                // ^( RANGE ^( EXPRESSION p= IDENTIFIER ) ^( EXPRESSION range=
                // expression ) )
                {
                    match(input, RANGE, FOLLOW_RANGE_in_axiom1209);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.DOWN, null);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, EXPRESSION, FOLLOW_EXPRESSION_in_axiom1212);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.DOWN, null);
                    if (state.failed) {
                        return retval;
                    }
                    p = (ManchesterOWLSyntaxTree) match(input, IDENTIFIER,
                        FOLLOW_IDENTIFIER_in_axiom1218);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.UP, null);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, EXPRESSION, FOLLOW_EXPRESSION_in_axiom1222);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.DOWN, null);
                    if (state.failed) {
                        return retval;
                    }
                    pushFollow(FOLLOW_expression_in_axiom1228);
                    range = expression();
                    state._fsp--;
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.UP, null);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.UP, null);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 1) {
                        if (!isNewWord()) {
                            retval.completions = new ArrayList<>(
                                range.node.getCompletions());
                        } else {
                            retval.completions = Collections.<String> emptyList();
                        }
                    }
                }
                    break;
                case 10:
                // /Users/luigi/Documents/workspace/Parsers/src/ManchesterOWLSyntaxAutoComplete.g:355:6:
                // ^( SAME_AS_AXIOM ^( EXPRESSION anIndividual= IDENTIFIER ) ^(
                // EXPRESSION anotherIndividual= IDENTIFIER ) )
                {
                    match(input, SAME_AS_AXIOM, FOLLOW_SAME_AS_AXIOM_in_axiom1243);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.DOWN, null);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, EXPRESSION, FOLLOW_EXPRESSION_in_axiom1246);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.DOWN, null);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, IDENTIFIER, FOLLOW_IDENTIFIER_in_axiom1251);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.UP, null);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, EXPRESSION, FOLLOW_EXPRESSION_in_axiom1255);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.DOWN, null);
                    if (state.failed) {
                        return retval;
                    }
                    anotherIndividual = (ManchesterOWLSyntaxTree) match(input,
                        IDENTIFIER, FOLLOW_IDENTIFIER_in_axiom1261);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.UP, null);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.UP, null);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 1) {
                        if (!isNewWord()) {
                            retval.completions = anotherIndividual.getCompletions();
                        } else {
                            retval.completions = Collections.<String> emptyList();
                        }
                    }
                }
                    break;
                case 11:
                // /Users/luigi/Documents/workspace/Parsers/src/ManchesterOWLSyntaxAutoComplete.g:363:7:
                // ^( DIFFERENT_FROM_AXIOM ^( EXPRESSION anIndividual=
                // IDENTIFIER ) ^( EXPRESSION anotherIndividual= IDENTIFIER ) )
                {
                    match(input, DIFFERENT_FROM_AXIOM,
                        FOLLOW_DIFFERENT_FROM_AXIOM_in_axiom1277);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.DOWN, null);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, EXPRESSION, FOLLOW_EXPRESSION_in_axiom1280);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.DOWN, null);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, IDENTIFIER, FOLLOW_IDENTIFIER_in_axiom1285);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.UP, null);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, EXPRESSION, FOLLOW_EXPRESSION_in_axiom1289);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.DOWN, null);
                    if (state.failed) {
                        return retval;
                    }
                    anotherIndividual = (ManchesterOWLSyntaxTree) match(input,
                        IDENTIFIER, FOLLOW_IDENTIFIER_in_axiom1295);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.UP, null);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.UP, null);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 1) {
                        if (!isNewWord()) {
                            retval.completions = anotherIndividual.getCompletions();
                        } else {
                            retval.completions = Collections.<String> emptyList();
                        }
                    }
                }
                    break;
                case 12:
                // /Users/luigi/Documents/workspace/Parsers/src/ManchesterOWLSyntaxAutoComplete.g:371:5:
                // ^( UNARY_AXIOM FUNCTIONAL ^( EXPRESSION p= IDENTIFIER ) )
                {
                    match(input, UNARY_AXIOM, FOLLOW_UNARY_AXIOM_in_axiom1309);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.DOWN, null);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, FUNCTIONAL, FOLLOW_FUNCTIONAL_in_axiom1311);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, EXPRESSION, FOLLOW_EXPRESSION_in_axiom1314);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.DOWN, null);
                    if (state.failed) {
                        return retval;
                    }
                    p = (ManchesterOWLSyntaxTree) match(input, IDENTIFIER,
                        FOLLOW_IDENTIFIER_in_axiom1320);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.UP, null);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.UP, null);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 1) {
                        if (!isNewWord()) {
                            retval.completions = p.getCompletions();
                        } else {
                            retval.completions = Collections.<String> emptyList();
                        }
                    }
                }
                    break;
                case 13:
                // /Users/luigi/Documents/workspace/Parsers/src/ManchesterOWLSyntaxAutoComplete.g:379:5:
                // ^( UNARY_AXIOM INVERSE_FUNCTIONAL ^( EXPRESSION p= IDENTIFIER
                // ) )
                {
                    match(input, UNARY_AXIOM, FOLLOW_UNARY_AXIOM_in_axiom1333);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.DOWN, null);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, INVERSE_FUNCTIONAL,
                        FOLLOW_INVERSE_FUNCTIONAL_in_axiom1335);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, EXPRESSION, FOLLOW_EXPRESSION_in_axiom1338);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.DOWN, null);
                    if (state.failed) {
                        return retval;
                    }
                    p = (ManchesterOWLSyntaxTree) match(input, IDENTIFIER,
                        FOLLOW_IDENTIFIER_in_axiom1344);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.UP, null);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.UP, null);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 1) {
                        if (!isNewWord()) {
                            retval.completions = p.getCompletions();
                        } else {
                            retval.completions = Collections.<String> emptyList();
                        }
                    }
                }
                    break;
                case 14:
                // /Users/luigi/Documents/workspace/Parsers/src/ManchesterOWLSyntaxAutoComplete.g:387:7:
                // ^( UNARY_AXIOM IRREFLEXIVE ^( EXPRESSION p= IDENTIFIER ) )
                {
                    match(input, UNARY_AXIOM, FOLLOW_UNARY_AXIOM_in_axiom1360);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.DOWN, null);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, IRREFLEXIVE, FOLLOW_IRREFLEXIVE_in_axiom1362);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, EXPRESSION, FOLLOW_EXPRESSION_in_axiom1365);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.DOWN, null);
                    if (state.failed) {
                        return retval;
                    }
                    p = (ManchesterOWLSyntaxTree) match(input, IDENTIFIER,
                        FOLLOW_IDENTIFIER_in_axiom1371);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.UP, null);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.UP, null);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 1) {
                        if (!isNewWord()) {
                            retval.completions = p.getCompletions();
                        } else {
                            retval.completions = Collections.<String> emptyList();
                        }
                    }
                }
                    break;
                case 15:
                // /Users/luigi/Documents/workspace/Parsers/src/ManchesterOWLSyntaxAutoComplete.g:395:6:
                // ^( UNARY_AXIOM REFLEXIVE ^( EXPRESSION p= IDENTIFIER ) )
                {
                    match(input, UNARY_AXIOM, FOLLOW_UNARY_AXIOM_in_axiom1386);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.DOWN, null);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, REFLEXIVE, FOLLOW_REFLEXIVE_in_axiom1388);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, EXPRESSION, FOLLOW_EXPRESSION_in_axiom1391);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.DOWN, null);
                    if (state.failed) {
                        return retval;
                    }
                    p = (ManchesterOWLSyntaxTree) match(input, IDENTIFIER,
                        FOLLOW_IDENTIFIER_in_axiom1397);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.UP, null);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.UP, null);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 1) {
                        if (!isNewWord()) {
                            retval.completions = p.getCompletions();
                        } else {
                            retval.completions = Collections.<String> emptyList();
                        }
                    }
                }
                    break;
                case 16:
                // /Users/luigi/Documents/workspace/Parsers/src/ManchesterOWLSyntaxAutoComplete.g:403:6:
                // ^( UNARY_AXIOM SYMMETRIC ^( EXPRESSION p= IDENTIFIER ) )
                {
                    match(input, UNARY_AXIOM, FOLLOW_UNARY_AXIOM_in_axiom1412);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.DOWN, null);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, SYMMETRIC, FOLLOW_SYMMETRIC_in_axiom1414);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, EXPRESSION, FOLLOW_EXPRESSION_in_axiom1417);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.DOWN, null);
                    if (state.failed) {
                        return retval;
                    }
                    p = (ManchesterOWLSyntaxTree) match(input, IDENTIFIER,
                        FOLLOW_IDENTIFIER_in_axiom1423);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.UP, null);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.UP, null);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 1) {
                        if (!isNewWord()) {
                            retval.completions = p.getCompletions();
                        } else {
                            retval.completions = Collections.<String> emptyList();
                        }
                    }
                }
                    break;
                case 17:
                // /Users/luigi/Documents/workspace/Parsers/src/ManchesterOWLSyntaxAutoComplete.g:411:7:
                // ^( UNARY_AXIOM TRANSITIVE ^( EXPRESSION p= IDENTIFIER ) )
                {
                    match(input, UNARY_AXIOM, FOLLOW_UNARY_AXIOM_in_axiom1440);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.DOWN, null);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, TRANSITIVE, FOLLOW_TRANSITIVE_in_axiom1442);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, EXPRESSION, FOLLOW_EXPRESSION_in_axiom1445);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.DOWN, null);
                    if (state.failed) {
                        return retval;
                    }
                    p = (ManchesterOWLSyntaxTree) match(input, IDENTIFIER,
                        FOLLOW_IDENTIFIER_in_axiom1451);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.UP, null);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.UP, null);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 1) {
                        if (!isNewWord()) {
                            retval.completions = p.getCompletions();
                        } else {
                            retval.completions = Collections.<String> emptyList();
                        }
                    }
                }
                    break;
                case 18:
                // /Users/luigi/Documents/workspace/Parsers/src/ManchesterOWLSyntaxAutoComplete.g:419:6:
                // ^( NEGATED_ASSERTION a= axiom )
                {
                    match(input, NEGATED_ASSERTION, FOLLOW_NEGATED_ASSERTION_in_axiom1466);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.DOWN, null);
                    if (state.failed) {
                        return retval;
                    }
                    pushFollow(FOLLOW_axiom_in_axiom1471);
                    a = axiom();
                    state._fsp--;
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.UP, null);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 1) {
                        if (!isNewWord()) {
                            retval.completions = a.completions;
                        } else {
                            retval.completions = Collections.<String> emptyList();
                        }
                    }
                }
                    break;
            }
            if (state.backtracking == 1 && retval.completions != null) {
                ((ManchesterOWLSyntaxTree) retval.start)
                    .setCompletions(retval.completions);
            }
        } catch (@SuppressWarnings("unused") RecognitionException | RewriteEmptyStreamException exception) {}
        return retval;
    }

    // $ANTLR end "axiom"
    public static class incompleteAxiom_return extends TreeRuleReturnScope {

        public List<String> completions;
    }

    // $ANTLR start "incompleteAxiom"
    // /Users/luigi/Documents/workspace/Parsers/src/ManchesterOWLSyntaxAutoComplete.g:433:1:
    // incompleteAxiom returns [List<String> completions] : ( ^(
    // INCOMPLETE_SUB_CLASS_AXIOM ^( EXPRESSION subClass= . ) ( ^(
    // INCOMPLETE_EXPRESSION superClass= incompleteExpression ) )? ) | ^(
    // INCOMPLETE_EQUIVALENT_TO_AXIOM ^( EXPRESSION lhs= expression ) ( ^(
    // INCOMPLETE_EXPRESSION rhs= incompleteExpression ) )? ) | ^(
    // INCOMPLETE_INVERSE_OF ^( EXPRESSION p= IDENTIFIER ) ( ^(
    // INCOMPLETE_EXPRESSION q= incompleteExpression ) )? ) | ^(
    // INCOMPLETE_DISJOINT_WITH_AXIOM ^( EXPRESSION lhs= expression ) ( ^(
    // INCOMPLETE_EXPRESSION rhs= incompleteExpression ) )? ) | ^(
    // INCOMPLETE_SUB_PROPERTY_AXIOM ^( EXPRESSION subProperty= expression ) (
    // ^( INCOMPLETE_EXPRESSION superProperty= incompleteExpression ) )? ) | ^(
    // INCOMPLETE_ROLE_ASSERTION ^( EXPRESSION IDENTIFIER ) ^( EXPRESSION
    // propertyExpression ) ) | ^( INCOMPLETE_TYPE_ASSERTION ^( EXPRESSION
    // IDENTIFIER ) ) | ^( INCOMPLETE_DOMAIN ^( EXPRESSION p= IDENTIFIER ) ) |
    // ^( INCOMPLETE_DOMAIN ^( EXPRESSION p= IDENTIFIER ) ^(
    // INCOMPLETE_EXPRESSION domain= incompleteExpression ) ) | ^(
    // INCOMPLETE_RANGE ^( EXPRESSION p= IDENTIFIER ) ) | ^( INCOMPLETE_RANGE ^(
    // EXPRESSION p= IDENTIFIER ) ^( INCOMPLETE_EXPRESSION range=
    // incompleteExpression ) ) | ^( INCOMPLETE_SAME_AS_AXIOM ^( EXPRESSION
    // anIndividual= IDENTIFIER ) ) | ^( INCOMPLETE_DIFFERENT_FROM_AXIOM ^(
    // EXPRESSION anIndividual= IDENTIFIER ) ) | ^( INCOMPLETE_UNARY_AXIOM
    // FUNCTIONAL ) | ^( INCOMPLETE_UNARY_AXIOM INVERSE_FUNCTIONAL ) | ^(
    // INCOMPLETE_UNARY_AXIOM IRREFLEXIVE ) | ^( INCOMPLETE_UNARY_AXIOM
    // REFLEXIVE ) | ^( INCOMPLETE_UNARY_AXIOM SYMMETRIC ) | ^(
    // INCOMPLETE_UNARY_AXIOM TRANSITIVE ) );
    public final ManchesterOWLSyntaxAutoComplete.incompleteAxiom_return incompleteAxiom() {
        ManchesterOWLSyntaxAutoComplete.incompleteAxiom_return retval = new ManchesterOWLSyntaxAutoComplete.incompleteAxiom_return();
        retval.start = input.LT(1);
        ManchesterOWLSyntaxAutoComplete.incompleteExpression_return superClass = null;
        ManchesterOWLSyntaxAutoComplete.expression_return lhs = null;
        ManchesterOWLSyntaxAutoComplete.incompleteExpression_return rhs = null;
        ManchesterOWLSyntaxAutoComplete.incompleteExpression_return q = null;
        ManchesterOWLSyntaxAutoComplete.expression_return subProperty = null;
        ManchesterOWLSyntaxAutoComplete.incompleteExpression_return superProperty = null;
        ManchesterOWLSyntaxAutoComplete.incompleteExpression_return domain = null;
        ManchesterOWLSyntaxAutoComplete.incompleteExpression_return range = null;
        try {
            // /Users/luigi/Documents/workspace/Parsers/src/ManchesterOWLSyntaxAutoComplete.g:440:1:
            // ( ^( INCOMPLETE_SUB_CLASS_AXIOM ^( EXPRESSION subClass= . ) ( ^(
            // INCOMPLETE_EXPRESSION superClass= incompleteExpression ) )? ) |
            // ^( INCOMPLETE_EQUIVALENT_TO_AXIOM ^( EXPRESSION lhs= expression )
            // ( ^( INCOMPLETE_EXPRESSION rhs= incompleteExpression ) )? ) | ^(
            // INCOMPLETE_INVERSE_OF ^( EXPRESSION p= IDENTIFIER ) ( ^(
            // INCOMPLETE_EXPRESSION q= incompleteExpression ) )? ) | ^(
            // INCOMPLETE_DISJOINT_WITH_AXIOM ^( EXPRESSION lhs= expression ) (
            // ^( INCOMPLETE_EXPRESSION rhs= incompleteExpression ) )? ) | ^(
            // INCOMPLETE_SUB_PROPERTY_AXIOM ^( EXPRESSION subProperty=
            // expression ) ( ^( INCOMPLETE_EXPRESSION superProperty=
            // incompleteExpression ) )? ) | ^( INCOMPLETE_ROLE_ASSERTION ^(
            // EXPRESSION IDENTIFIER ) ^( EXPRESSION propertyExpression ) ) | ^(
            // INCOMPLETE_TYPE_ASSERTION ^( EXPRESSION IDENTIFIER ) ) | ^(
            // INCOMPLETE_DOMAIN ^( EXPRESSION p= IDENTIFIER ) ) | ^(
            // INCOMPLETE_DOMAIN ^( EXPRESSION p= IDENTIFIER ) ^(
            // INCOMPLETE_EXPRESSION domain= incompleteExpression ) ) | ^(
            // INCOMPLETE_RANGE ^( EXPRESSION p= IDENTIFIER ) ) | ^(
            // INCOMPLETE_RANGE ^( EXPRESSION p= IDENTIFIER ) ^(
            // INCOMPLETE_EXPRESSION range= incompleteExpression ) ) | ^(
            // INCOMPLETE_SAME_AS_AXIOM ^( EXPRESSION anIndividual= IDENTIFIER )
            // ) | ^( INCOMPLETE_DIFFERENT_FROM_AXIOM ^( EXPRESSION
            // anIndividual= IDENTIFIER ) ) | ^( INCOMPLETE_UNARY_AXIOM
            // FUNCTIONAL ) | ^( INCOMPLETE_UNARY_AXIOM INVERSE_FUNCTIONAL ) |
            // ^( INCOMPLETE_UNARY_AXIOM IRREFLEXIVE ) | ^(
            // INCOMPLETE_UNARY_AXIOM REFLEXIVE ) | ^( INCOMPLETE_UNARY_AXIOM
            // SYMMETRIC ) | ^( INCOMPLETE_UNARY_AXIOM TRANSITIVE ) )
            int alt22 = 19;
            alt22 = dfa22.predict(input);
            switch (alt22) {
                case 1:
                // /Users/luigi/Documents/workspace/Parsers/src/ManchesterOWLSyntaxAutoComplete.g:442:5:
                // ^( INCOMPLETE_SUB_CLASS_AXIOM ^( EXPRESSION subClass= . ) (
                // ^( INCOMPLETE_EXPRESSION superClass= incompleteExpression )
                // )? )
                {
                    match(input, INCOMPLETE_SUB_CLASS_AXIOM,
                        FOLLOW_INCOMPLETE_SUB_CLASS_AXIOM_in_incompleteAxiom1521);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.DOWN, null);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, EXPRESSION, FOLLOW_EXPRESSION_in_incompleteAxiom1525);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.DOWN, null);
                    if (state.failed) {
                        return retval;
                    }
                    input.LT(1);
                    matchAny(input);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.UP, null);
                    if (state.failed) {
                        return retval;
                    }
                    // /Users/luigi/Documents/workspace/Parsers/src/ManchesterOWLSyntaxAutoComplete.g:442:63:
                    // ( ^( INCOMPLETE_EXPRESSION superClass=
                    // incompleteExpression ) )?
                    int alt17 = 2;
                    int LA17_0 = input.LA(1);
                    if (LA17_0 == INCOMPLETE_EXPRESSION) {
                        alt17 = 1;
                    }
                    switch (alt17) {
                        case 1:
                        // /Users/luigi/Documents/workspace/Parsers/src/ManchesterOWLSyntaxAutoComplete.g:442:64:
                        // ^( INCOMPLETE_EXPRESSION superClass=
                        // incompleteExpression )
                        {
                            match(input, INCOMPLETE_EXPRESSION,
                                FOLLOW_INCOMPLETE_EXPRESSION_in_incompleteAxiom1537);
                            if (state.failed) {
                                return retval;
                            }
                            match(input, Token.DOWN, null);
                            if (state.failed) {
                                return retval;
                            }
                            pushFollow(FOLLOW_incompleteExpression_in_incompleteAxiom1543);
                            superClass = incompleteExpression();
                            state._fsp--;
                            if (state.failed) {
                                return retval;
                            }
                            match(input, Token.UP, null);
                            if (state.failed) {
                                return retval;
                            }
                        }
                            break;
                    }
                    match(input, Token.UP, null);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 1) {
                        // class expression completions
                        retval.completions = superClass == null ? new ArrayList<>(
                            symtab.getOWLClassCompletions()) : new ArrayList<>(
                                superClass.completions);
                    }
                }
                    break;
                case 2:
                // /Users/luigi/Documents/workspace/Parsers/src/ManchesterOWLSyntaxAutoComplete.g:447:6:
                // ^( INCOMPLETE_EQUIVALENT_TO_AXIOM ^( EXPRESSION lhs=
                // expression ) ( ^( INCOMPLETE_EXPRESSION rhs=
                // incompleteExpression ) )? )
                {
                    match(input, INCOMPLETE_EQUIVALENT_TO_AXIOM,
                        FOLLOW_INCOMPLETE_EQUIVALENT_TO_AXIOM_in_incompleteAxiom1563);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.DOWN, null);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, EXPRESSION, FOLLOW_EXPRESSION_in_incompleteAxiom1566);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.DOWN, null);
                    if (state.failed) {
                        return retval;
                    }
                    pushFollow(FOLLOW_expression_in_incompleteAxiom1572);
                    lhs = expression();
                    state._fsp--;
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.UP, null);
                    if (state.failed) {
                        return retval;
                    }
                    // /Users/luigi/Documents/workspace/Parsers/src/ManchesterOWLSyntaxAutoComplete.g:447:70:
                    // ( ^( INCOMPLETE_EXPRESSION rhs= incompleteExpression ) )?
                    int alt18 = 2;
                    int LA18_0 = input.LA(1);
                    if (LA18_0 == INCOMPLETE_EXPRESSION) {
                        alt18 = 1;
                    }
                    switch (alt18) {
                        case 1:
                        // /Users/luigi/Documents/workspace/Parsers/src/ManchesterOWLSyntaxAutoComplete.g:447:71:
                        // ^( INCOMPLETE_EXPRESSION rhs= incompleteExpression )
                        {
                            match(input, INCOMPLETE_EXPRESSION,
                                FOLLOW_INCOMPLETE_EXPRESSION_in_incompleteAxiom1577);
                            if (state.failed) {
                                return retval;
                            }
                            match(input, Token.DOWN, null);
                            if (state.failed) {
                                return retval;
                            }
                            pushFollow(FOLLOW_incompleteExpression_in_incompleteAxiom1584);
                            rhs = incompleteExpression();
                            state._fsp--;
                            if (state.failed) {
                                return retval;
                            }
                            match(input, Token.UP, null);
                            if (state.failed) {
                                return retval;
                            }
                        }
                            break;
                    }
                    match(input, Token.UP, null);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 1) {
                        retval.completions = rhs == null ? new ArrayList<>(
                            symtab.getCompletions(lhs.node.getEvalType()))
                            : new ArrayList<>(rhs.completions);
                    }
                }
                    break;
                case 3:
                // /Users/luigi/Documents/workspace/Parsers/src/ManchesterOWLSyntaxAutoComplete.g:451:5:
                // ^( INCOMPLETE_INVERSE_OF ^( EXPRESSION p= IDENTIFIER ) ( ^(
                // INCOMPLETE_EXPRESSION q= incompleteExpression ) )? )
                {
                    match(input, INCOMPLETE_INVERSE_OF,
                        FOLLOW_INCOMPLETE_INVERSE_OF_in_incompleteAxiom1604);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.DOWN, null);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, EXPRESSION, FOLLOW_EXPRESSION_in_incompleteAxiom1607);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.DOWN, null);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, IDENTIFIER, FOLLOW_IDENTIFIER_in_incompleteAxiom1613);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.UP, null);
                    if (state.failed) {
                        return retval;
                    }
                    // /Users/luigi/Documents/workspace/Parsers/src/ManchesterOWLSyntaxAutoComplete.g:451:58:
                    // ( ^( INCOMPLETE_EXPRESSION q= incompleteExpression ) )?
                    int alt19 = 2;
                    int LA19_0 = input.LA(1);
                    if (LA19_0 == INCOMPLETE_EXPRESSION) {
                        alt19 = 1;
                    }
                    switch (alt19) {
                        case 1:
                        // /Users/luigi/Documents/workspace/Parsers/src/ManchesterOWLSyntaxAutoComplete.g:451:59:
                        // ^( INCOMPLETE_EXPRESSION q= incompleteExpression )
                        {
                            match(input, INCOMPLETE_EXPRESSION,
                                FOLLOW_INCOMPLETE_EXPRESSION_in_incompleteAxiom1618);
                            if (state.failed) {
                                return retval;
                            }
                            match(input, Token.DOWN, null);
                            if (state.failed) {
                                return retval;
                            }
                            pushFollow(FOLLOW_incompleteExpression_in_incompleteAxiom1624);
                            q = incompleteExpression();
                            state._fsp--;
                            if (state.failed) {
                                return retval;
                            }
                            match(input, Token.UP, null);
                            if (state.failed) {
                                return retval;
                            }
                        }
                            break;
                    }
                    match(input, Token.UP, null);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 1) {
                        // object property expression completions
                        retval.completions = q == null ? new ArrayList<>(
                            symtab.getOWLObjectPropertyCompletions())
                            : new ArrayList<>(q.completions);
                    }
                }
                    break;
                case 4:
                // /Users/luigi/Documents/workspace/Parsers/src/ManchesterOWLSyntaxAutoComplete.g:456:5:
                // ^( INCOMPLETE_DISJOINT_WITH_AXIOM ^( EXPRESSION lhs=
                // expression ) ( ^( INCOMPLETE_EXPRESSION rhs=
                // incompleteExpression ) )? )
                {
                    match(input, INCOMPLETE_DISJOINT_WITH_AXIOM,
                        FOLLOW_INCOMPLETE_DISJOINT_WITH_AXIOM_in_incompleteAxiom1639);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.DOWN, null);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, EXPRESSION, FOLLOW_EXPRESSION_in_incompleteAxiom1642);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.DOWN, null);
                    if (state.failed) {
                        return retval;
                    }
                    pushFollow(FOLLOW_expression_in_incompleteAxiom1649);
                    lhs = expression();
                    state._fsp--;
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.UP, null);
                    if (state.failed) {
                        return retval;
                    }
                    // /Users/luigi/Documents/workspace/Parsers/src/ManchesterOWLSyntaxAutoComplete.g:456:70:
                    // ( ^( INCOMPLETE_EXPRESSION rhs= incompleteExpression ) )?
                    int alt20 = 2;
                    int LA20_0 = input.LA(1);
                    if (LA20_0 == INCOMPLETE_EXPRESSION) {
                        alt20 = 1;
                    }
                    switch (alt20) {
                        case 1:
                        // /Users/luigi/Documents/workspace/Parsers/src/ManchesterOWLSyntaxAutoComplete.g:456:71:
                        // ^( INCOMPLETE_EXPRESSION rhs= incompleteExpression )
                        {
                            match(input, INCOMPLETE_EXPRESSION,
                                FOLLOW_INCOMPLETE_EXPRESSION_in_incompleteAxiom1654);
                            if (state.failed) {
                                return retval;
                            }
                            match(input, Token.DOWN, null);
                            if (state.failed) {
                                return retval;
                            }
                            pushFollow(FOLLOW_incompleteExpression_in_incompleteAxiom1660);
                            rhs = incompleteExpression();
                            state._fsp--;
                            if (state.failed) {
                                return retval;
                            }
                            match(input, Token.UP, null);
                            if (state.failed) {
                                return retval;
                            }
                        }
                            break;
                    }
                    match(input, Token.UP, null);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 1) {
                        retval.completions = rhs == null ? new ArrayList<>(
                            symtab.getCompletions(lhs.node.getEvalType()))
                            : new ArrayList<>(rhs.completions);
                    }
                }
                    break;
                case 5:
                // /Users/luigi/Documents/workspace/Parsers/src/ManchesterOWLSyntaxAutoComplete.g:459:5:
                // ^( INCOMPLETE_SUB_PROPERTY_AXIOM ^( EXPRESSION subProperty=
                // expression ) ( ^( INCOMPLETE_EXPRESSION superProperty=
                // incompleteExpression ) )? )
                {
                    match(input, INCOMPLETE_SUB_PROPERTY_AXIOM,
                        FOLLOW_INCOMPLETE_SUB_PROPERTY_AXIOM_in_incompleteAxiom1675);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.DOWN, null);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, EXPRESSION, FOLLOW_EXPRESSION_in_incompleteAxiom1678);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.DOWN, null);
                    if (state.failed) {
                        return retval;
                    }
                    pushFollow(FOLLOW_expression_in_incompleteAxiom1685);
                    subProperty = expression();
                    state._fsp--;
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.UP, null);
                    if (state.failed) {
                        return retval;
                    }
                    // /Users/luigi/Documents/workspace/Parsers/src/ManchesterOWLSyntaxAutoComplete.g:459:77:
                    // ( ^( INCOMPLETE_EXPRESSION superProperty=
                    // incompleteExpression ) )?
                    int alt21 = 2;
                    int LA21_0 = input.LA(1);
                    if (LA21_0 == INCOMPLETE_EXPRESSION) {
                        alt21 = 1;
                    }
                    switch (alt21) {
                        case 1:
                        // /Users/luigi/Documents/workspace/Parsers/src/ManchesterOWLSyntaxAutoComplete.g:459:78:
                        // ^( INCOMPLETE_EXPRESSION superProperty=
                        // incompleteExpression )
                        {
                            match(input, INCOMPLETE_EXPRESSION,
                                FOLLOW_INCOMPLETE_EXPRESSION_in_incompleteAxiom1690);
                            if (state.failed) {
                                return retval;
                            }
                            match(input, Token.DOWN, null);
                            if (state.failed) {
                                return retval;
                            }
                            pushFollow(FOLLOW_incompleteExpression_in_incompleteAxiom1696);
                            superProperty = incompleteExpression();
                            state._fsp--;
                            if (state.failed) {
                                return retval;
                            }
                            match(input, Token.UP, null);
                            if (state.failed) {
                                return retval;
                            }
                        }
                            break;
                    }
                    match(input, Token.UP, null);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 1) {
                        // property expression completions
                        retval.completions = superProperty == null ? new ArrayList<>(
                            symtab.getOWLPropertyCompletions(subProperty.node
                                .getEvalType())) : new ArrayList<>(
                                    superProperty.completions);
                    }
                }
                    break;
                case 6:
                // /Users/luigi/Documents/workspace/Parsers/src/ManchesterOWLSyntaxAutoComplete.g:464:5:
                // ^( INCOMPLETE_ROLE_ASSERTION ^( EXPRESSION IDENTIFIER ) ^(
                // EXPRESSION propertyExpression ) )
                {
                    match(input, INCOMPLETE_ROLE_ASSERTION,
                        FOLLOW_INCOMPLETE_ROLE_ASSERTION_in_incompleteAxiom1716);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.DOWN, null);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, EXPRESSION, FOLLOW_EXPRESSION_in_incompleteAxiom1719);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.DOWN, null);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, IDENTIFIER, FOLLOW_IDENTIFIER_in_incompleteAxiom1721);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.UP, null);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, EXPRESSION, FOLLOW_EXPRESSION_in_incompleteAxiom1725);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.DOWN, null);
                    if (state.failed) {
                        return retval;
                    }
                    pushFollow(FOLLOW_propertyExpression_in_incompleteAxiom1727);
                    propertyExpression();
                    state._fsp--;
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.UP, null);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.UP, null);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 1) {
                        // individual expression completions
                        retval.completions = new ArrayList<>(
                            symtab.getOWLIndividualCompletions());
                    }
                }
                    break;
                case 7:
                // /Users/luigi/Documents/workspace/Parsers/src/ManchesterOWLSyntaxAutoComplete.g:468:6:
                // ^( INCOMPLETE_TYPE_ASSERTION ^( EXPRESSION IDENTIFIER ) )
                {
                    match(input, INCOMPLETE_TYPE_ASSERTION,
                        FOLLOW_INCOMPLETE_TYPE_ASSERTION_in_incompleteAxiom1738);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.DOWN, null);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, EXPRESSION, FOLLOW_EXPRESSION_in_incompleteAxiom1742);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.DOWN, null);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, IDENTIFIER, FOLLOW_IDENTIFIER_in_incompleteAxiom1744);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.UP, null);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.UP, null);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 1) {
                        // class expression completions
                        retval.completions = new ArrayList<>(
                            symtab.getOWLClassCompletions());
                    }
                }
                    break;
                case 8:
                // /Users/luigi/Documents/workspace/Parsers/src/ManchesterOWLSyntaxAutoComplete.g:473:5:
                // ^( INCOMPLETE_DOMAIN ^( EXPRESSION p= IDENTIFIER ) )
                {
                    match(input, INCOMPLETE_DOMAIN,
                        FOLLOW_INCOMPLETE_DOMAIN_in_incompleteAxiom1757);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.DOWN, null);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, EXPRESSION, FOLLOW_EXPRESSION_in_incompleteAxiom1760);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.DOWN, null);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, IDENTIFIER, FOLLOW_IDENTIFIER_in_incompleteAxiom1766);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.UP, null);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.UP, null);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 1) {
                        // class expression completions
                        retval.completions = new ArrayList<>(
                            symtab.getOWLClassCompletions());
                    }
                }
                    break;
                case 9:
                // /Users/luigi/Documents/workspace/Parsers/src/ManchesterOWLSyntaxAutoComplete.g:478:5:
                // ^( INCOMPLETE_DOMAIN ^( EXPRESSION p= IDENTIFIER ) ^(
                // INCOMPLETE_EXPRESSION domain= incompleteExpression ) )
                {
                    match(input, INCOMPLETE_DOMAIN,
                        FOLLOW_INCOMPLETE_DOMAIN_in_incompleteAxiom1781);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.DOWN, null);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, EXPRESSION, FOLLOW_EXPRESSION_in_incompleteAxiom1784);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.DOWN, null);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, IDENTIFIER, FOLLOW_IDENTIFIER_in_incompleteAxiom1790);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.UP, null);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, INCOMPLETE_EXPRESSION,
                        FOLLOW_INCOMPLETE_EXPRESSION_in_incompleteAxiom1794);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.DOWN, null);
                    if (state.failed) {
                        return retval;
                    }
                    pushFollow(FOLLOW_incompleteExpression_in_incompleteAxiom1800);
                    domain = incompleteExpression();
                    state._fsp--;
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.UP, null);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.UP, null);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 1) {
                        retval.completions = domain.completions;
                    }
                }
                    break;
                case 10:
                // /Users/luigi/Documents/workspace/Parsers/src/ManchesterOWLSyntaxAutoComplete.g:482:6:
                // ^( INCOMPLETE_RANGE ^( EXPRESSION p= IDENTIFIER ) )
                {
                    match(input, INCOMPLETE_RANGE,
                        FOLLOW_INCOMPLETE_RANGE_in_incompleteAxiom1815);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.DOWN, null);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, EXPRESSION, FOLLOW_EXPRESSION_in_incompleteAxiom1818);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.DOWN, null);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, IDENTIFIER, FOLLOW_IDENTIFIER_in_incompleteAxiom1824);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.UP, null);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.UP, null);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 1) {
                        // class expression completions
                        retval.completions = new ArrayList<>(
                            symtab.getOWLClassCompletions());
                    }
                }
                    break;
                case 11:
                // /Users/luigi/Documents/workspace/Parsers/src/ManchesterOWLSyntaxAutoComplete.g:486:6:
                // ^( INCOMPLETE_RANGE ^( EXPRESSION p= IDENTIFIER ) ^(
                // INCOMPLETE_EXPRESSION range= incompleteExpression ) )
                {
                    match(input, INCOMPLETE_RANGE,
                        FOLLOW_INCOMPLETE_RANGE_in_incompleteAxiom1835);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.DOWN, null);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, EXPRESSION, FOLLOW_EXPRESSION_in_incompleteAxiom1838);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.DOWN, null);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, IDENTIFIER, FOLLOW_IDENTIFIER_in_incompleteAxiom1844);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.UP, null);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, INCOMPLETE_EXPRESSION,
                        FOLLOW_INCOMPLETE_EXPRESSION_in_incompleteAxiom1848);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.DOWN, null);
                    if (state.failed) {
                        return retval;
                    }
                    pushFollow(FOLLOW_incompleteExpression_in_incompleteAxiom1854);
                    range = incompleteExpression();
                    state._fsp--;
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.UP, null);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.UP, null);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 1) {
                        retval.completions = range.completions;
                    }
                }
                    break;
                case 12:
                // /Users/luigi/Documents/workspace/Parsers/src/ManchesterOWLSyntaxAutoComplete.g:490:6:
                // ^( INCOMPLETE_SAME_AS_AXIOM ^( EXPRESSION anIndividual=
                // IDENTIFIER ) )
                {
                    match(input, INCOMPLETE_SAME_AS_AXIOM,
                        FOLLOW_INCOMPLETE_SAME_AS_AXIOM_in_incompleteAxiom1869);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.DOWN, null);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, EXPRESSION, FOLLOW_EXPRESSION_in_incompleteAxiom1872);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.DOWN, null);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, IDENTIFIER, FOLLOW_IDENTIFIER_in_incompleteAxiom1877);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.UP, null);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.UP, null);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 1) {
                        // individual expression completions
                        retval.completions = new ArrayList<>(
                            symtab.getOWLIndividualCompletions());
                    }
                }
                    break;
                case 13:
                // /Users/luigi/Documents/workspace/Parsers/src/ManchesterOWLSyntaxAutoComplete.g:495:7:
                // ^( INCOMPLETE_DIFFERENT_FROM_AXIOM ^( EXPRESSION
                // anIndividual= IDENTIFIER ) )
                {
                    match(input, INCOMPLETE_DIFFERENT_FROM_AXIOM,
                        FOLLOW_INCOMPLETE_DIFFERENT_FROM_AXIOM_in_incompleteAxiom1893);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.DOWN, null);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, EXPRESSION, FOLLOW_EXPRESSION_in_incompleteAxiom1896);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.DOWN, null);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, IDENTIFIER, FOLLOW_IDENTIFIER_in_incompleteAxiom1901);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.UP, null);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.UP, null);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 1) {
                        // individual expression completions
                        retval.completions = new ArrayList<>(
                            symtab.getOWLIndividualCompletions());
                    }
                }
                    break;
                case 14:
                // /Users/luigi/Documents/workspace/Parsers/src/ManchesterOWLSyntaxAutoComplete.g:500:6:
                // ^( INCOMPLETE_UNARY_AXIOM FUNCTIONAL )
                {
                    match(input, INCOMPLETE_UNARY_AXIOM,
                        FOLLOW_INCOMPLETE_UNARY_AXIOM_in_incompleteAxiom1916);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.DOWN, null);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, FUNCTIONAL, FOLLOW_FUNCTIONAL_in_incompleteAxiom1918);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.UP, null);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 1) {
                        // property expression completions
                        retval.completions = new ArrayList<>(
                            symtab.getAllCompletions(OWLType.OWL_OBJECT_PROPERTY,
                                OWLType.OWL_DATA_PROPERTY));
                    }
                }
                    break;
                case 15:
                // /Users/luigi/Documents/workspace/Parsers/src/ManchesterOWLSyntaxAutoComplete.g:505:6:
                // ^( INCOMPLETE_UNARY_AXIOM INVERSE_FUNCTIONAL )
                {
                    match(input, INCOMPLETE_UNARY_AXIOM,
                        FOLLOW_INCOMPLETE_UNARY_AXIOM_in_incompleteAxiom1932);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.DOWN, null);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, INVERSE_FUNCTIONAL,
                        FOLLOW_INVERSE_FUNCTIONAL_in_incompleteAxiom1934);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.UP, null);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 1) {
                        // object property expression completions
                        retval.completions = new ArrayList<>(
                            symtab.getOWLObjectPropertyCompletions());
                    }
                }
                    break;
                case 16:
                // /Users/luigi/Documents/workspace/Parsers/src/ManchesterOWLSyntaxAutoComplete.g:510:7:
                // ^( INCOMPLETE_UNARY_AXIOM IRREFLEXIVE )
                {
                    match(input, INCOMPLETE_UNARY_AXIOM,
                        FOLLOW_INCOMPLETE_UNARY_AXIOM_in_incompleteAxiom1949);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.DOWN, null);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, IRREFLEXIVE, FOLLOW_IRREFLEXIVE_in_incompleteAxiom1951);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.UP, null);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 1) {
                        // object property expression completions
                        retval.completions = new ArrayList<>(
                            symtab.getOWLObjectPropertyCompletions());
                    }
                }
                    break;
                case 17:
                // /Users/luigi/Documents/workspace/Parsers/src/ManchesterOWLSyntaxAutoComplete.g:515:6:
                // ^( INCOMPLETE_UNARY_AXIOM REFLEXIVE )
                {
                    match(input, INCOMPLETE_UNARY_AXIOM,
                        FOLLOW_INCOMPLETE_UNARY_AXIOM_in_incompleteAxiom1965);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.DOWN, null);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, REFLEXIVE, FOLLOW_REFLEXIVE_in_incompleteAxiom1967);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.UP, null);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 1) {
                        // object property expression completions
                        retval.completions = new ArrayList<>(
                            symtab.getOWLObjectPropertyCompletions());
                    }
                }
                    break;
                case 18:
                // /Users/luigi/Documents/workspace/Parsers/src/ManchesterOWLSyntaxAutoComplete.g:520:6:
                // ^( INCOMPLETE_UNARY_AXIOM SYMMETRIC )
                {
                    match(input, INCOMPLETE_UNARY_AXIOM,
                        FOLLOW_INCOMPLETE_UNARY_AXIOM_in_incompleteAxiom1981);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.DOWN, null);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, SYMMETRIC, FOLLOW_SYMMETRIC_in_incompleteAxiom1983);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.UP, null);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 1) {
                        // object property expression completions
                        retval.completions = new ArrayList<>(
                            symtab.getOWLObjectPropertyCompletions());
                    }
                }
                    break;
                case 19:
                // /Users/luigi/Documents/workspace/Parsers/src/ManchesterOWLSyntaxAutoComplete.g:525:7:
                // ^( INCOMPLETE_UNARY_AXIOM TRANSITIVE )
                {
                    match(input, INCOMPLETE_UNARY_AXIOM,
                        FOLLOW_INCOMPLETE_UNARY_AXIOM_in_incompleteAxiom1999);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.DOWN, null);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, TRANSITIVE, FOLLOW_TRANSITIVE_in_incompleteAxiom2001);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.UP, null);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 1) {
                        // object property expression completions
                        retval.completions = new ArrayList<>(
                            symtab.getOWLObjectPropertyCompletions());
                    }
                }
                    break;
            }
            if (state.backtracking == 1 && retval.completions != null) {
                ((ManchesterOWLSyntaxTree) retval.start)
                    .setCompletions(retval.completions);
            }
        } catch (@SuppressWarnings("unused") RecognitionException | RewriteEmptyStreamException exception) {}
        return retval;
    }

    // $ANTLR end "incompleteAxiom"
    public static class incompleteExpression_return extends TreeRuleReturnScope {

        public List<String> completions;
    }

    // $ANTLR start "incompleteExpression"
    // /Users/luigi/Documents/workspace/Parsers/src/ManchesterOWLSyntaxAutoComplete.g:532:1:
    // incompleteExpression returns [List<String> completions] : ( ^(
    // INCOMPLETE_PROPERTY_CHAIN ( . )+ ) | ^( INCOMPLETE_DISJUNCTION ic=
    // incompleteConjunction ) | ^( INCOMPLETE_EXPRESSION ^( EXPRESSION e=
    // expression ) IDENTIFIER ) | ^( INCOMPLETE_EXPRESSION iu= incompleteUnary
    // ) );
    public final ManchesterOWLSyntaxAutoComplete.incompleteExpression_return incompleteExpression() {
        ManchesterOWLSyntaxAutoComplete.incompleteExpression_return retval = new ManchesterOWLSyntaxAutoComplete.incompleteExpression_return();
        retval.start = input.LT(1);
        ManchesterOWLSyntaxTree IDENTIFIER14 = null;
        ManchesterOWLSyntaxAutoComplete.expression_return e = null;
        ManchesterOWLSyntaxAutoComplete.incompleteUnary_return iu = null;
        try {
            // /Users/luigi/Documents/workspace/Parsers/src/ManchesterOWLSyntaxAutoComplete.g:539:1:
            // ( ^( INCOMPLETE_PROPERTY_CHAIN ( . )+ ) | ^(
            // INCOMPLETE_DISJUNCTION ic= incompleteConjunction ) | ^(
            // INCOMPLETE_EXPRESSION ^( EXPRESSION e= expression ) IDENTIFIER )
            // | ^( INCOMPLETE_EXPRESSION iu= incompleteUnary ) )
            int alt24 = 4;
            switch (input.LA(1)) {
                case INCOMPLETE_PROPERTY_CHAIN: {
                    alt24 = 1;
                }
                    break;
                case INCOMPLETE_DISJUNCTION: {
                    alt24 = 2;
                }
                    break;
                case INCOMPLETE_EXPRESSION: {
                    int LA24_3 = input.LA(2);
                    if (LA24_3 == DOWN) {
                        int LA24_4 = input.LA(3);
                        if (LA24_4 == EXPRESSION) {
                            alt24 = 3;
                        } else if (LA24_4 >= INCOMPLETE_NEGATED_EXPRESSION
                            && LA24_4 <= INCOMPLETE_VALUE_RESTRICTION) {
                            alt24 = 4;
                        } else {
                            if (state.backtracking > 0) {
                                state.failed = true;
                                return retval;
                            }
                            NoViableAltException nvae = new NoViableAltException("", 24,
                                4, input);
                            throw nvae;
                        }
                    } else {
                        if (state.backtracking > 0) {
                            state.failed = true;
                            return retval;
                        }
                        NoViableAltException nvae = new NoViableAltException("", 24, 3,
                            input);
                        throw nvae;
                    }
                }
                    break;
                default:
                    if (state.backtracking > 0) {
                        state.failed = true;
                        return retval;
                    }
                    NoViableAltException nvae = new NoViableAltException("", 24, 0, input);
                    throw nvae;
            }
            switch (alt24) {
                case 1:
                // /Users/luigi/Documents/workspace/Parsers/src/ManchesterOWLSyntaxAutoComplete.g:540:3:
                // ^( INCOMPLETE_PROPERTY_CHAIN ( . )+ )
                {
                    match(input, INCOMPLETE_PROPERTY_CHAIN,
                        FOLLOW_INCOMPLETE_PROPERTY_CHAIN_in_incompleteExpression2043);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.DOWN, null);
                    if (state.failed) {
                        return retval;
                    }
                    // /Users/luigi/Documents/workspace/Parsers/src/ManchesterOWLSyntaxAutoComplete.g:540:32:
                    // ( . )+
                    int cnt23 = 0;
                    loop23: do {
                        int alt23 = 2;
                        int LA23_0 = input.LA(1);
                        if (LA23_0 >= COMPOSITION && LA23_0 <= INCOMPLETE_EXPRESSION) {
                            alt23 = 1;
                        } else if (LA23_0 == UP) {
                            alt23 = 2;
                        }
                        switch (alt23) {
                            case 1:
                            // /Users/luigi/Documents/workspace/Parsers/src/ManchesterOWLSyntaxAutoComplete.g:540:32:
                            // .
                            {
                                matchAny(input);
                                if (state.failed) {
                                    return retval;
                                }
                            }
                                break;
                            default:
                                if (cnt23 >= 1) {
                                    break loop23;
                                }
                                if (state.backtracking > 0) {
                                    state.failed = true;
                                    return retval;
                                }
                                EarlyExitException eee = new EarlyExitException(23, input);
                                throw eee;
                        }
                        cnt23++;
                    } while (true);
                    match(input, Token.UP, null);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 1) {
                        // object property expression completions
                        retval.completions = new ArrayList<>(
                            symtab.getOWLObjectPropertyCompletions());
                    }
                }
                    break;
                case 2:
                // /Users/luigi/Documents/workspace/Parsers/src/ManchesterOWLSyntaxAutoComplete.g:546:5:
                // ^( INCOMPLETE_DISJUNCTION ic= incompleteConjunction )
                {
                    match(input, INCOMPLETE_DISJUNCTION,
                        FOLLOW_INCOMPLETE_DISJUNCTION_in_incompleteExpression2062);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.DOWN, null);
                    if (state.failed) {
                        return retval;
                    }
                    pushFollow(FOLLOW_incompleteConjunction_in_incompleteExpression2069);
                    incompleteConjunction();
                    state._fsp--;
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.UP, null);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 1) {
                        retval.completions = new ArrayList<>(
                            symtab.getOWLClassCompletions());
                    }
                }
                    break;
                case 3:
                // /Users/luigi/Documents/workspace/Parsers/src/ManchesterOWLSyntaxAutoComplete.g:554:5:
                // ^( INCOMPLETE_EXPRESSION ^( EXPRESSION e= expression )
                // IDENTIFIER )
                {
                    match(input, INCOMPLETE_EXPRESSION,
                        FOLLOW_INCOMPLETE_EXPRESSION_in_incompleteExpression2083);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.DOWN, null);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, EXPRESSION,
                        FOLLOW_EXPRESSION_in_incompleteExpression2086);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.DOWN, null);
                    if (state.failed) {
                        return retval;
                    }
                    pushFollow(FOLLOW_expression_in_incompleteExpression2093);
                    e = expression();
                    state._fsp--;
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.UP, null);
                    if (state.failed) {
                        return retval;
                    }
                    IDENTIFIER14 = (ManchesterOWLSyntaxTree) match(input, IDENTIFIER,
                        FOLLOW_IDENTIFIER_in_incompleteExpression2096);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.UP, null);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 1) {
                        Type type = e.node.getEvalType();
                        retval.completions = type == null ? Collections
                            .<String> emptyList() : AutoCompleteStrings
                                .getIncompleteExpressionCompletions(
                                    IDENTIFIER14 != null ? IDENTIFIER14.getText()
                                        : null, type);
                    }
                }
                    break;
                case 4:
                // /Users/luigi/Documents/workspace/Parsers/src/ManchesterOWLSyntaxAutoComplete.g:558:5:
                // ^( INCOMPLETE_EXPRESSION iu= incompleteUnary )
                {
                    match(input, INCOMPLETE_EXPRESSION,
                        FOLLOW_INCOMPLETE_EXPRESSION_in_incompleteExpression2105);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.DOWN, null);
                    if (state.failed) {
                        return retval;
                    }
                    pushFollow(FOLLOW_incompleteUnary_in_incompleteExpression2112);
                    iu = incompleteUnary();
                    state._fsp--;
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.UP, null);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 1) {
                        retval.completions = new ArrayList<>(
                            iu != null ? iu.completions : null);
                    }
                }
                    break;
            }
            if (state.backtracking == 1 && retval.completions != null) {
                ((ManchesterOWLSyntaxTree) retval.start)
                    .setCompletions(retval.completions);
            }
        } catch (@SuppressWarnings("unused") RecognitionException | RewriteEmptyStreamException exception) {}
        return retval;
    }

    // $ANTLR end "incompleteExpression"
    public static class incompleteConjunction_return extends TreeRuleReturnScope {

        public List<String> completions;
    }

    // $ANTLR start "incompleteConjunction"
    // /Users/luigi/Documents/workspace/Parsers/src/ManchesterOWLSyntaxAutoComplete.g:566:1:
    // incompleteConjunction returns [List<String> completions] : ^(
    // INCOMPLETE_CONJUNCTION (e= incompleteUnary )? ) ;
    public final ManchesterOWLSyntaxAutoComplete.incompleteConjunction_return incompleteConjunction() {
        ManchesterOWLSyntaxAutoComplete.incompleteConjunction_return retval = new ManchesterOWLSyntaxAutoComplete.incompleteConjunction_return();
        retval.start = input.LT(1);
        ManchesterOWLSyntaxAutoComplete.incompleteUnary_return e = null;
        try {
            // /Users/luigi/Documents/workspace/Parsers/src/ManchesterOWLSyntaxAutoComplete.g:573:1:
            // ( ^( INCOMPLETE_CONJUNCTION (e= incompleteUnary )? ) )
            // /Users/luigi/Documents/workspace/Parsers/src/ManchesterOWLSyntaxAutoComplete.g:574:5:
            // ^( INCOMPLETE_CONJUNCTION (e= incompleteUnary )? )
            {
                match(input, INCOMPLETE_CONJUNCTION,
                    FOLLOW_INCOMPLETE_CONJUNCTION_in_incompleteConjunction2159);
                if (state.failed) {
                    return retval;
                }
                if (input.LA(1) == Token.DOWN) {
                    match(input, Token.DOWN, null);
                    if (state.failed) {
                        return retval;
                    }
                    // /Users/luigi/Documents/workspace/Parsers/src/ManchesterOWLSyntaxAutoComplete.g:574:33:
                    // (e= incompleteUnary )?
                    int alt25 = 2;
                    int LA25_0 = input.LA(1);
                    if (LA25_0 >= INCOMPLETE_NEGATED_EXPRESSION
                        && LA25_0 <= INCOMPLETE_VALUE_RESTRICTION) {
                        alt25 = 1;
                    }
                    switch (alt25) {
                        case 1:
                        // /Users/luigi/Documents/workspace/Parsers/src/ManchesterOWLSyntaxAutoComplete.g:574:33:
                        // e= incompleteUnary
                        {
                            pushFollow(FOLLOW_incompleteUnary_in_incompleteConjunction2166);
                            e = incompleteUnary();
                            state._fsp--;
                            if (state.failed) {
                                return retval;
                            }
                        }
                            break;
                    }
                    match(input, Token.UP, null);
                    if (state.failed) {
                        return retval;
                    }
                }
                if (state.backtracking == 1) {
                    if (e != null) {
                        retval.completions = e.completions;
                    } else {
                        retval.completions = new ArrayList<>(
                            symtab.getOWLClassCompletions());
                    }
                }
            }
            if (state.backtracking == 1 && retval.completions != null) {
                ((ManchesterOWLSyntaxTree) retval.start)
                    .setCompletions(retval.completions);
            }
        } catch (@SuppressWarnings("unused") RecognitionException | RewriteEmptyStreamException exception) {}
        return retval;
    }

    // $ANTLR end "incompleteConjunction"
    public static class incompleteUnary_return extends TreeRuleReturnScope {

        public List<String> completions;
    }

    // $ANTLR start "incompleteUnary"
    // /Users/luigi/Documents/workspace/Parsers/src/ManchesterOWLSyntaxAutoComplete.g:584:1:
    // incompleteUnary returns [List<String> completions] : ( ^(
    // INCOMPLETE_NEGATED_EXPRESSION ( . )? ) | incompleteQualifiedRestriction
    // );
    public final ManchesterOWLSyntaxAutoComplete.incompleteUnary_return incompleteUnary() {
        ManchesterOWLSyntaxAutoComplete.incompleteUnary_return retval = new ManchesterOWLSyntaxAutoComplete.incompleteUnary_return();
        retval.start = input.LT(1);
        ManchesterOWLSyntaxAutoComplete.incompleteQualifiedRestriction_return incompleteQualifiedRestriction15 = null;
        try {
            // /Users/luigi/Documents/workspace/Parsers/src/ManchesterOWLSyntaxAutoComplete.g:591:1:
            // ( ^( INCOMPLETE_NEGATED_EXPRESSION ( . )? ) |
            // incompleteQualifiedRestriction )
            int alt27 = 2;
            int LA27_0 = input.LA(1);
            if (LA27_0 == INCOMPLETE_NEGATED_EXPRESSION) {
                alt27 = 1;
            } else if (LA27_0 >= INCOMPLETE_SOME_RESTRICTION
                && LA27_0 <= INCOMPLETE_VALUE_RESTRICTION) {
                alt27 = 2;
            } else {
                if (state.backtracking > 0) {
                    state.failed = true;
                    return retval;
                }
                NoViableAltException nvae = new NoViableAltException("", 27, 0, input);
                throw nvae;
            }
            switch (alt27) {
                case 1:
                // /Users/luigi/Documents/workspace/Parsers/src/ManchesterOWLSyntaxAutoComplete.g:592:5:
                // ^( INCOMPLETE_NEGATED_EXPRESSION ( . )? )
                {
                    match(input, INCOMPLETE_NEGATED_EXPRESSION,
                        FOLLOW_INCOMPLETE_NEGATED_EXPRESSION_in_incompleteUnary2211);
                    if (state.failed) {
                        return retval;
                    }
                    if (input.LA(1) == Token.DOWN) {
                        match(input, Token.DOWN, null);
                        if (state.failed) {
                            return retval;
                        }
                        // /Users/luigi/Documents/workspace/Parsers/src/ManchesterOWLSyntaxAutoComplete.g:592:37:
                        // ( . )?
                        int alt26 = 2;
                        int LA26_0 = input.LA(1);
                        if (LA26_0 >= COMPOSITION && LA26_0 <= INCOMPLETE_EXPRESSION) {
                            alt26 = 1;
                        }
                        switch (alt26) {
                            case 1:
                            // /Users/luigi/Documents/workspace/Parsers/src/ManchesterOWLSyntaxAutoComplete.g:592:37:
                            // .
                            {
                                matchAny(input);
                                if (state.failed) {
                                    return retval;
                                }
                            }
                                break;
                        }
                        match(input, Token.UP, null);
                        if (state.failed) {
                            return retval;
                        }
                    }
                    if (state.backtracking == 1) {
                        // class expression completions
                        retval.completions = new ArrayList<>(
                            symtab.getOWLClassCompletions());
                    }
                }
                    break;
                case 2:
                // /Users/luigi/Documents/workspace/Parsers/src/ManchesterOWLSyntaxAutoComplete.g:596:7:
                // incompleteQualifiedRestriction
                {
                    pushFollow(FOLLOW_incompleteQualifiedRestriction_in_incompleteUnary2242);
                    incompleteQualifiedRestriction15 = incompleteQualifiedRestriction();
                    state._fsp--;
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 1) {
                        retval.completions = incompleteQualifiedRestriction15 != null
                            ? incompleteQualifiedRestriction15.completions
                            : null;
                    }
                }
                    break;
            }
            if (state.backtracking == 1 && retval.completions != null) {
                ((ManchesterOWLSyntaxTree) retval.start)
                    .setCompletions(retval.completions);
            }
        } catch (@SuppressWarnings("unused") RecognitionException | RewriteEmptyStreamException exception) {}
        return retval;
    }

    // $ANTLR end "incompleteUnary"
    public static class incompleteQualifiedRestriction_return extends TreeRuleReturnScope {

        public List<String> completions;
    }

    // $ANTLR start "incompleteQualifiedRestriction"
    // /Users/luigi/Documents/workspace/Parsers/src/ManchesterOWLSyntaxAutoComplete.g:602:1:
    // incompleteQualifiedRestriction returns [List<String> completions] : ( ^(
    // INCOMPLETE_SOME_RESTRICTION propertyExpression ) | ^(
    // INCOMPLETE_ALL_RESTRICTION propertyExpression ) |
    // incompleteCardinalityRestriction | incompleteOneOf |
    // incompleteValueRestriction );
    public final ManchesterOWLSyntaxAutoComplete.incompleteQualifiedRestriction_return incompleteQualifiedRestriction() {
        ManchesterOWLSyntaxAutoComplete.incompleteQualifiedRestriction_return retval = new ManchesterOWLSyntaxAutoComplete.incompleteQualifiedRestriction_return();
        retval.start = input.LT(1);
        ManchesterOWLSyntaxAutoComplete.incompleteCardinalityRestriction_return incompleteCardinalityRestriction16 = null;
        ManchesterOWLSyntaxAutoComplete.incompleteOneOf_return incompleteOneOf17 = null;
        ManchesterOWLSyntaxAutoComplete.incompleteValueRestriction_return incompleteValueRestriction18 = null;
        try {
            // /Users/luigi/Documents/workspace/Parsers/src/ManchesterOWLSyntaxAutoComplete.g:609:1:
            // ( ^( INCOMPLETE_SOME_RESTRICTION propertyExpression ) | ^(
            // INCOMPLETE_ALL_RESTRICTION propertyExpression ) |
            // incompleteCardinalityRestriction | incompleteOneOf |
            // incompleteValueRestriction )
            int alt28 = 5;
            switch (input.LA(1)) {
                case INCOMPLETE_SOME_RESTRICTION: {
                    alt28 = 1;
                }
                    break;
                case INCOMPLETE_ALL_RESTRICTION: {
                    alt28 = 2;
                }
                    break;
                case INCOMPLETE_CARDINALITY_RESTRICTION: {
                    alt28 = 3;
                }
                    break;
                case INCOMPLETE_ONE_OF: {
                    alt28 = 4;
                }
                    break;
                case INCOMPLETE_VALUE_RESTRICTION: {
                    alt28 = 5;
                }
                    break;
                default:
                    if (state.backtracking > 0) {
                        state.failed = true;
                        return retval;
                    }
                    NoViableAltException nvae = new NoViableAltException("", 28, 0, input);
                    throw nvae;
            }
            switch (alt28) {
                case 1:
                // /Users/luigi/Documents/workspace/Parsers/src/ManchesterOWLSyntaxAutoComplete.g:610:11:
                // ^( INCOMPLETE_SOME_RESTRICTION propertyExpression )
                {
                    match(input, INCOMPLETE_SOME_RESTRICTION,
                        FOLLOW_INCOMPLETE_SOME_RESTRICTION_in_incompleteQualifiedRestriction2300);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.DOWN, null);
                    if (state.failed) {
                        return retval;
                    }
                    pushFollow(FOLLOW_propertyExpression_in_incompleteQualifiedRestriction2302);
                    propertyExpression();
                    state._fsp--;
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.UP, null);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 1) {
                        // class expression completions
                        retval.completions = new ArrayList<>(
                            symtab.getOWLClassCompletions());
                    }
                }
                    break;
                case 2:
                // /Users/luigi/Documents/workspace/Parsers/src/ManchesterOWLSyntaxAutoComplete.g:615:11:
                // ^( INCOMPLETE_ALL_RESTRICTION propertyExpression )
                {
                    match(input, INCOMPLETE_ALL_RESTRICTION,
                        FOLLOW_INCOMPLETE_ALL_RESTRICTION_in_incompleteQualifiedRestriction2345);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.DOWN, null);
                    if (state.failed) {
                        return retval;
                    }
                    pushFollow(FOLLOW_propertyExpression_in_incompleteQualifiedRestriction2347);
                    propertyExpression();
                    state._fsp--;
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.UP, null);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 1) {
                        // class expression completions
                        retval.completions = new ArrayList<>(
                            symtab.getOWLClassCompletions());
                    }
                }
                    break;
                case 3:
                // /Users/luigi/Documents/workspace/Parsers/src/ManchesterOWLSyntaxAutoComplete.g:620:11:
                // incompleteCardinalityRestriction
                {
                    pushFollow(FOLLOW_incompleteCardinalityRestriction_in_incompleteQualifiedRestriction2370);
                    incompleteCardinalityRestriction16 = incompleteCardinalityRestriction();
                    state._fsp--;
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 1) {
                        retval.completions = incompleteCardinalityRestriction16 != null
                            ? incompleteCardinalityRestriction16.completions
                            : null;
                    }
                }
                    break;
                case 4:
                // /Users/luigi/Documents/workspace/Parsers/src/ManchesterOWLSyntaxAutoComplete.g:624:11:
                // incompleteOneOf
                {
                    pushFollow(FOLLOW_incompleteOneOf_in_incompleteQualifiedRestriction2392);
                    incompleteOneOf17 = incompleteOneOf();
                    state._fsp--;
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 1) {
                        retval.completions = incompleteOneOf17 != null ? incompleteOneOf17.completions
                            : null;
                    }
                }
                    break;
                case 5:
                // /Users/luigi/Documents/workspace/Parsers/src/ManchesterOWLSyntaxAutoComplete.g:628:11:
                // incompleteValueRestriction
                {
                    pushFollow(FOLLOW_incompleteValueRestriction_in_incompleteQualifiedRestriction2414);
                    incompleteValueRestriction18 = incompleteValueRestriction();
                    state._fsp--;
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 1) {
                        retval.completions = incompleteValueRestriction18 != null
                            ? incompleteValueRestriction18.completions
                            : null;
                    }
                }
                    break;
            }
            if (state.backtracking == 1 && retval.completions != null) {
                ((ManchesterOWLSyntaxTree) retval.start)
                    .setCompletions(retval.completions);
            }
        } catch (@SuppressWarnings("unused") RecognitionException | RewriteEmptyStreamException exception) {}
        return retval;
    }

    // $ANTLR end "incompleteQualifiedRestriction"
    public static class incompleteCardinalityRestriction_return extends
        TreeRuleReturnScope {

        public List<String> completions;
    }

    // $ANTLR start "incompleteCardinalityRestriction"
    // /Users/luigi/Documents/workspace/Parsers/src/ManchesterOWLSyntaxAutoComplete.g:635:1:
    // incompleteCardinalityRestriction returns [List<String> completions] : ^(
    // INCOMPLETE_CARDINALITY_RESTRICTION . INTEGER propertyExpression ) ;
    public final ManchesterOWLSyntaxAutoComplete.incompleteCardinalityRestriction_return incompleteCardinalityRestriction() {
        ManchesterOWLSyntaxAutoComplete.incompleteCardinalityRestriction_return retval = new ManchesterOWLSyntaxAutoComplete.incompleteCardinalityRestriction_return();
        retval.start = input.LT(1);
        try {
            // /Users/luigi/Documents/workspace/Parsers/src/ManchesterOWLSyntaxAutoComplete.g:642:1:
            // ( ^( INCOMPLETE_CARDINALITY_RESTRICTION . INTEGER
            // propertyExpression ) )
            // /Users/luigi/Documents/workspace/Parsers/src/ManchesterOWLSyntaxAutoComplete.g:643:9:
            // ^( INCOMPLETE_CARDINALITY_RESTRICTION . INTEGER
            // propertyExpression )
            {
                match(input, INCOMPLETE_CARDINALITY_RESTRICTION,
                    FOLLOW_INCOMPLETE_CARDINALITY_RESTRICTION_in_incompleteCardinalityRestriction2475);
                if (state.failed) {
                    return retval;
                }
                match(input, Token.DOWN, null);
                if (state.failed) {
                    return retval;
                }
                matchAny(input);
                if (state.failed) {
                    return retval;
                }
                match(input, INTEGER,
                    FOLLOW_INTEGER_in_incompleteCardinalityRestriction2480);
                if (state.failed) {
                    return retval;
                }
                pushFollow(FOLLOW_propertyExpression_in_incompleteCardinalityRestriction2482);
                propertyExpression();
                state._fsp--;
                if (state.failed) {
                    return retval;
                }
                match(input, Token.UP, null);
                if (state.failed) {
                    return retval;
                }
                if (state.backtracking == 1) {
                    // class expression completions
                    retval.completions = new ArrayList<>(
                        symtab.getOWLClassCompletions());
                }
            }
            if (state.backtracking == 1 && retval.completions != null) {
                ((ManchesterOWLSyntaxTree) retval.start)
                    .setCompletions(retval.completions);
            }
        } catch (@SuppressWarnings("unused") RecognitionException | RewriteEmptyStreamException exception) {}
        return retval;
    }

    // $ANTLR end "incompleteCardinalityRestriction"
    public static class incompleteOneOf_return extends TreeRuleReturnScope {

        public List<String> completions;
    }

    // $ANTLR start "incompleteOneOf"
    // /Users/luigi/Documents/workspace/Parsers/src/ManchesterOWLSyntaxAutoComplete.g:651:1:
    // incompleteOneOf returns [List<String> completions] : ^( INCOMPLETE_ONE_OF
    // ( IDENTIFIER )+ ) ;
    public final ManchesterOWLSyntaxAutoComplete.incompleteOneOf_return incompleteOneOf() {
        ManchesterOWLSyntaxAutoComplete.incompleteOneOf_return retval = new ManchesterOWLSyntaxAutoComplete.incompleteOneOf_return();
        retval.start = input.LT(1);
        try {
            // /Users/luigi/Documents/workspace/Parsers/src/ManchesterOWLSyntaxAutoComplete.g:658:1:
            // ( ^( INCOMPLETE_ONE_OF ( IDENTIFIER )+ ) )
            // /Users/luigi/Documents/workspace/Parsers/src/ManchesterOWLSyntaxAutoComplete.g:659:5:
            // ^( INCOMPLETE_ONE_OF ( IDENTIFIER )+ )
            {
                match(input, INCOMPLETE_ONE_OF,
                    FOLLOW_INCOMPLETE_ONE_OF_in_incompleteOneOf2528);
                if (state.failed) {
                    return retval;
                }
                match(input, Token.DOWN, null);
                if (state.failed) {
                    return retval;
                }
                // /Users/luigi/Documents/workspace/Parsers/src/ManchesterOWLSyntaxAutoComplete.g:659:25:
                // ( IDENTIFIER )+
                int cnt29 = 0;
                loop29: do {
                    int alt29 = 2;
                    int LA29_0 = input.LA(1);
                    if (LA29_0 == IDENTIFIER) {
                        alt29 = 1;
                    }
                    switch (alt29) {
                        case 1:
                        // /Users/luigi/Documents/workspace/Parsers/src/ManchesterOWLSyntaxAutoComplete.g:659:25:
                        // IDENTIFIER
                        {
                            match(input, IDENTIFIER,
                                FOLLOW_IDENTIFIER_in_incompleteOneOf2530);
                            if (state.failed) {
                                return retval;
                            }
                        }
                            break;
                        default:
                            if (cnt29 >= 1) {
                                break loop29;
                            }
                            if (state.backtracking > 0) {
                                state.failed = true;
                                return retval;
                            }
                            EarlyExitException eee = new EarlyExitException(29, input);
                            throw eee;
                    }
                    cnt29++;
                } while (true);
                match(input, Token.UP, null);
                if (state.failed) {
                    return retval;
                }
                if (state.backtracking == 1) {
                    // individual expression completions
                    retval.completions = new ArrayList<>(
                        symtab.getOWLIndividualCompletions());
                }
            }
            if (state.backtracking == 1 && retval.completions != null) {
                ((ManchesterOWLSyntaxTree) retval.start)
                    .setCompletions(retval.completions);
            }
        } catch (@SuppressWarnings("unused") RecognitionException | RewriteEmptyStreamException exception) {}
        return retval;
    }

    // $ANTLR end "incompleteOneOf"
    public static class incompleteValueRestriction_return extends TreeRuleReturnScope {

        public List<String> completions;
    }

    // $ANTLR start "incompleteValueRestriction"
    // /Users/luigi/Documents/workspace/Parsers/src/ManchesterOWLSyntaxAutoComplete.g:666:2:
    // incompleteValueRestriction returns [List<String> completions] : ^(
    // INCOMPLETE_VALUE_RESTRICTION p= propertyExpression ) ;
    public final ManchesterOWLSyntaxAutoComplete.incompleteValueRestriction_return incompleteValueRestriction() {
        ManchesterOWLSyntaxAutoComplete.incompleteValueRestriction_return retval = new ManchesterOWLSyntaxAutoComplete.incompleteValueRestriction_return();
        retval.start = input.LT(1);
        ManchesterOWLSyntaxAutoComplete.propertyExpression_return p = null;
        try {
            // /Users/luigi/Documents/workspace/Parsers/src/ManchesterOWLSyntaxAutoComplete.g:673:1:
            // ( ^( INCOMPLETE_VALUE_RESTRICTION p= propertyExpression ) )
            // /Users/luigi/Documents/workspace/Parsers/src/ManchesterOWLSyntaxAutoComplete.g:674:7:
            // ^( INCOMPLETE_VALUE_RESTRICTION p= propertyExpression )
            {
                match(input, INCOMPLETE_VALUE_RESTRICTION,
                    FOLLOW_INCOMPLETE_VALUE_RESTRICTION_in_incompleteValueRestriction2578);
                if (state.failed) {
                    return retval;
                }
                match(input, Token.DOWN, null);
                if (state.failed) {
                    return retval;
                }
                pushFollow(FOLLOW_propertyExpression_in_incompleteValueRestriction2584);
                p = propertyExpression();
                state._fsp--;
                if (state.failed) {
                    return retval;
                }
                match(input, Token.UP, null);
                if (state.failed) {
                    return retval;
                }
                if (state.backtracking == 1) {
                    // individual expression completions
                    Type type = p.type;
                    if (OWLType.isObjectPropertyExpression(type)) {
                        retval.completions = new ArrayList<>(
                            symtab.getOWLIndividualCompletions());
                    }
                }
            }
            if (state.backtracking == 1 && retval.completions != null) {
                ((ManchesterOWLSyntaxTree) retval.start)
                    .setCompletions(retval.completions);
            }
        } catch (@SuppressWarnings("unused") RecognitionException | RewriteEmptyStreamException exception) {}
        return retval;
    }

    // $ANTLR end "incompleteValueRestriction"
    // Delegated rules
    protected DFA16 dfa16 = new DFA16(this);
    protected DFA22 dfa22 = new DFA22(this);
    static final String DFA16_eotS = "\25\uffff";
    static final String DFA16_eofS = "\25\uffff";
    static final String DFA16_minS = "\1\31\13\uffff\1\2\1\uffff\1\35\6\uffff";
    static final String DFA16_maxS = "\1\103\13\uffff\1\2\1\uffff\1\43\6\uffff";
    static final String DFA16_acceptS = "\1\uffff\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\13\1\uffff"
        + "\1\22\1\uffff\1\14\1\15\1\16\1\17\1\20\1\21";
    static final String DFA16_specialS = "\25\uffff}>";
    static final String[] DFA16_transitionS = {
        "\1\3\1\uffff\1\10\1\11\23\uffff\1\1\1\2\1\4\1\5\1\12\1\13\1"
            + "\14\4\uffff\1\15\6\uffff\1\7\1\6", "", "", "", "", "", "", "", "",
        "", "", "", "\1\16", "", "\1\17\1\23\1\uffff\1\22\1\21\1\24\1\20", "", "",
        "", "", "", "" };
    static final short[] DFA16_eot = DFA.unpackEncodedString(DFA16_eotS);
    static final short[] DFA16_eof = DFA.unpackEncodedString(DFA16_eofS);
    static final char[] DFA16_min = DFA.unpackEncodedStringToUnsignedChars(DFA16_minS);
    static final char[] DFA16_max = DFA.unpackEncodedStringToUnsignedChars(DFA16_maxS);
    static final short[] DFA16_accept = DFA.unpackEncodedString(DFA16_acceptS);
    static final short[] DFA16_special = DFA.unpackEncodedString(DFA16_specialS);
    static final short[][] DFA16_transition;

    static {
        int numStates = DFA16_transitionS.length;
        DFA16_transition = new short[numStates][];
        for (int i = 0; i < numStates; i++) {
            DFA16_transition[i] = DFA.unpackEncodedString(DFA16_transitionS[i]);
        }
    }

    class DFA16 extends DFA {

        public DFA16(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            decisionNumber = 16;
            eot = DFA16_eot;
            eof = DFA16_eof;
            min = DFA16_min;
            max = DFA16_max;
            accept = DFA16_accept;
            special = DFA16_special;
            transition = DFA16_transition;
        }

        @Override
        public String getDescription() {
            return "277:1: axiom returns [List<String> completions] : ( ^( SUB_CLASS_AXIOM ^( EXPRESSION subClass= expression ) ^( EXPRESSION superClass= expression ) ) | ^( EQUIVALENT_TO_AXIOM ^( EXPRESSION lhs= expression ) ^( EXPRESSION rhs= expression ) ) | ^( INVERSE_OF ^( EXPRESSION p= IDENTIFIER ) ^( EXPRESSION anotherProperty= IDENTIFIER ) ) | ^( DISJOINT_WITH_AXIOM ^( EXPRESSION lhs= expression ) ^( EXPRESSION rhs= expression ) ) | ^( SUB_PROPERTY_AXIOM ^( EXPRESSION subProperty= expression ) ^( EXPRESSION superProperty= unary ) ) | ^( ROLE_ASSERTION ^( EXPRESSION subject= IDENTIFIER ) ^( EXPRESSION predicate= propertyExpression ) ^( EXPRESSION object= unary ) ) | ^( TYPE_ASSERTION ^( EXPRESSION description= expression ) ^( EXPRESSION subject= IDENTIFIER ) ) | ^( DOMAIN ^( EXPRESSION p= IDENTIFIER ) ^( EXPRESSION domain= expression ) ) | ^( RANGE ^( EXPRESSION p= IDENTIFIER ) ^( EXPRESSION range= expression ) ) | ^( SAME_AS_AXIOM ^( EXPRESSION anIndividual= IDENTIFIER ) ^( EXPRESSION anotherIndividual= IDENTIFIER ) ) | ^( DIFFERENT_FROM_AXIOM ^( EXPRESSION anIndividual= IDENTIFIER ) ^( EXPRESSION anotherIndividual= IDENTIFIER ) ) | ^( UNARY_AXIOM FUNCTIONAL ^( EXPRESSION p= IDENTIFIER ) ) | ^( UNARY_AXIOM INVERSE_FUNCTIONAL ^( EXPRESSION p= IDENTIFIER ) ) | ^( UNARY_AXIOM IRREFLEXIVE ^( EXPRESSION p= IDENTIFIER ) ) | ^( UNARY_AXIOM REFLEXIVE ^( EXPRESSION p= IDENTIFIER ) ) | ^( UNARY_AXIOM SYMMETRIC ^( EXPRESSION p= IDENTIFIER ) ) | ^( UNARY_AXIOM TRANSITIVE ^( EXPRESSION p= IDENTIFIER ) ) | ^( NEGATED_ASSERTION a= axiom ) );";
        }
    }

    static final String DFA22_eotS = "\42\uffff";
    static final String DFA22_eofS = "\42\uffff";
    static final String DFA22_minS = "\1\u0259\7\uffff\2\2\2\uffff\1\2\2\105\1\35\2\2\6\uffff\2\54\4\3"
        + "\4\uffff";
    static final String DFA22_maxS = "\1\u0264\7\uffff\2\2\2\uffff\1\2\2\105\1\43\2\2\6\uffff\2\54\2\3"
        + "\2\u026f\4\uffff";
    static final String DFA22_acceptS = "\1\uffff\1\1\1\2\1\3\1\4\1\5\1\6\1\7\2\uffff\1\14\1\15\6\uffff\1"
        + "\16\1\17\1\20\1\21\1\22\1\23\6\uffff\1\10\1\11\1\12\1\13";
    static final String DFA22_specialS = "\42\uffff}>";
    static final String[] DFA22_transitionS = {
        "\1\7\1\6\1\14\1\1\1\2\1\4\1\5\1\12\1\13\1\10\1\11\1\3", "", "", "", "", "",
        "", "", "\1\15", "\1\16", "", "", "\1\17", "\1\20", "\1\21",
        "\1\22\1\26\1\uffff\1\25\1\24\1\27\1\23", "\1\30", "\1\31", "", "", "", "",
        "", "", "\1\32", "\1\33", "\1\34", "\1\35", "\1\36\u026b\uffff\1\37",
        "\1\40\u026b\uffff\1\41", "", "", "", "" };
    static final short[] DFA22_eot = DFA.unpackEncodedString(DFA22_eotS);
    static final short[] DFA22_eof = DFA.unpackEncodedString(DFA22_eofS);
    static final char[] DFA22_min = DFA.unpackEncodedStringToUnsignedChars(DFA22_minS);
    static final char[] DFA22_max = DFA.unpackEncodedStringToUnsignedChars(DFA22_maxS);
    static final short[] DFA22_accept = DFA.unpackEncodedString(DFA22_acceptS);
    static final short[] DFA22_special = DFA.unpackEncodedString(DFA22_specialS);
    static final short[][] DFA22_transition;

    static {
        int numStates = DFA22_transitionS.length;
        DFA22_transition = new short[numStates][];
        for (int i = 0; i < numStates; i++) {
            DFA22_transition[i] = DFA.unpackEncodedString(DFA22_transitionS[i]);
        }
    }

    class DFA22 extends DFA {

        public DFA22(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            decisionNumber = 22;
            eot = DFA22_eot;
            eof = DFA22_eof;
            min = DFA22_min;
            max = DFA22_max;
            accept = DFA22_accept;
            special = DFA22_special;
            transition = DFA22_transition;
        }

        @Override
        public String getDescription() {
            return "433:1: incompleteAxiom returns [List<String> completions] : ( ^( INCOMPLETE_SUB_CLASS_AXIOM ^( EXPRESSION subClass= . ) ( ^( INCOMPLETE_EXPRESSION superClass= incompleteExpression ) )? ) | ^( INCOMPLETE_EQUIVALENT_TO_AXIOM ^( EXPRESSION lhs= expression ) ( ^( INCOMPLETE_EXPRESSION rhs= incompleteExpression ) )? ) | ^( INCOMPLETE_INVERSE_OF ^( EXPRESSION p= IDENTIFIER ) ( ^( INCOMPLETE_EXPRESSION q= incompleteExpression ) )? ) | ^( INCOMPLETE_DISJOINT_WITH_AXIOM ^( EXPRESSION lhs= expression ) ( ^( INCOMPLETE_EXPRESSION rhs= incompleteExpression ) )? ) | ^( INCOMPLETE_SUB_PROPERTY_AXIOM ^( EXPRESSION subProperty= expression ) ( ^( INCOMPLETE_EXPRESSION superProperty= incompleteExpression ) )? ) | ^( INCOMPLETE_ROLE_ASSERTION ^( EXPRESSION IDENTIFIER ) ^( EXPRESSION propertyExpression ) ) | ^( INCOMPLETE_TYPE_ASSERTION ^( EXPRESSION IDENTIFIER ) ) | ^( INCOMPLETE_DOMAIN ^( EXPRESSION p= IDENTIFIER ) ) | ^( INCOMPLETE_DOMAIN ^( EXPRESSION p= IDENTIFIER ) ^( INCOMPLETE_EXPRESSION domain= incompleteExpression ) ) | ^( INCOMPLETE_RANGE ^( EXPRESSION p= IDENTIFIER ) ) | ^( INCOMPLETE_RANGE ^( EXPRESSION p= IDENTIFIER ) ^( INCOMPLETE_EXPRESSION range= incompleteExpression ) ) | ^( INCOMPLETE_SAME_AS_AXIOM ^( EXPRESSION anIndividual= IDENTIFIER ) ) | ^( INCOMPLETE_DIFFERENT_FROM_AXIOM ^( EXPRESSION anIndividual= IDENTIFIER ) ) | ^( INCOMPLETE_UNARY_AXIOM FUNCTIONAL ) | ^( INCOMPLETE_UNARY_AXIOM INVERSE_FUNCTIONAL ) | ^( INCOMPLETE_UNARY_AXIOM IRREFLEXIVE ) | ^( INCOMPLETE_UNARY_AXIOM REFLEXIVE ) | ^( INCOMPLETE_UNARY_AXIOM SYMMETRIC ) | ^( INCOMPLETE_UNARY_AXIOM TRANSITIVE ) );";
        }
    }

    public static final BitSet FOLLOW_standaloneExpression_in_bottomup87 = new BitSet(
        new long[] { 0x0000000000000002L });
    public static final BitSet FOLLOW_expressionRoot_in_bottomup96 = new BitSet(
        new long[] { 0x0000000000000002L });
    public static final BitSet FOLLOW_incompleteAxiom_in_bottomup107 = new BitSet(
        new long[] { 0x0000000000000002L });
    public static final BitSet FOLLOW_incompleteExpression_in_bottomup117 = new BitSet(
        new long[] { 0x0000000000000002L });
    public static final BitSet FOLLOW_axiom_in_bottomup126 = new BitSet(
        new long[] { 0x0000000000000002L });
    public static final BitSet FOLLOW_EXPRESSION_in_expressionRoot155 = new BitSet(
        new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_expression_in_expressionRoot161 = new BitSet(
        new long[] { 0x0000000000000008L });
    public static final BitSet FOLLOW_STANDALONE_EXPRESSION_in_standaloneExpression183 = new BitSet(
        new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_EXPRESSION_in_standaloneExpression186 = new BitSet(
        new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_expression_in_standaloneExpression191 = new BitSet(
        new long[] { 0x0000000000000008L });
    public static final BitSet FOLLOW_DISJUNCTION_in_expression226 = new BitSet(
        new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_conjunction_in_expression235 = new BitSet(
        new long[] { 0xE500300000000008L, 0x0000000000000003L });
    public static final BitSet FOLLOW_PROPERTY_CHAIN_in_expression248 = new BitSet(
        new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_expression_in_expression256 = new BitSet(
        new long[] { 0xE780300000000008L, 0x0000000000000013L });
    public static final BitSet FOLLOW_conjunction_in_expression276 = new BitSet(
        new long[] { 0x0000000000000002L });
    public static final BitSet FOLLOW_complexPropertyExpression_in_expression291 = new BitSet(
        new long[] { 0x0000000000000002L });
    public static final BitSet FOLLOW_CONJUNCTION_in_conjunction328 = new BitSet(
        new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_unary_in_conjunction334 = new BitSet(new long[] {
        0xE500300000000008L, 0x0000000000000003L });
    public static final BitSet FOLLOW_unary_in_conjunction349 = new BitSet(
        new long[] { 0x0000000000000002L });
    public static final BitSet FOLLOW_IDENTIFIER_in_unary376 = new BitSet(
        new long[] { 0x0000000000000002L });
    public static final BitSet FOLLOW_NEGATED_EXPRESSION_in_unary389 = new BitSet(
        new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_expression_in_unary395 = new BitSet(
        new long[] { 0x0000000000000008L });
    public static final BitSet FOLLOW_qualifiedRestriction_in_unary409 = new BitSet(
        new long[] { 0x0000000000000002L });
    public static final BitSet FOLLOW_ENTITY_REFERENCE_in_unary423 = new BitSet(
        new long[] { 0x0000000000000002L });
    public static final BitSet FOLLOW_IDENTIFIER_in_propertyExpression462 = new BitSet(
        new long[] { 0x0000000000000002L });
    public static final BitSet FOLLOW_ENTITY_REFERENCE_in_propertyExpression480 = new BitSet(
        new long[] { 0x0000000000000002L });
    public static final BitSet FOLLOW_complexPropertyExpression_in_propertyExpression494 = new BitSet(
        new long[] { 0x0000000000000002L });
    public static final BitSet FOLLOW_INVERSE_OBJECT_PROPERTY_EXPRESSION_in_complexPropertyExpression528 = new BitSet(
        new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_complexPropertyExpression_in_complexPropertyExpression534 = new BitSet(
        new long[] { 0x0000000000000008L });
    public static final BitSet FOLLOW_INVERSE_OBJECT_PROPERTY_EXPRESSION_in_complexPropertyExpression544 = new BitSet(
        new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_IDENTIFIER_in_complexPropertyExpression546 = new BitSet(
        new long[] { 0x0000000000000008L });
    public static final BitSet FOLLOW_INVERSE_OBJECT_PROPERTY_EXPRESSION_in_complexPropertyExpression556 = new BitSet(
        new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_ENTITY_REFERENCE_in_complexPropertyExpression558 = new BitSet(
        new long[] { 0x0000000000000008L });
    public static final BitSet FOLLOW_SOME_RESTRICTION_in_qualifiedRestriction589 = new BitSet(
        new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_propertyExpression_in_qualifiedRestriction594 = new BitSet(
        new long[] { 0xE780300000000008L, 0x0000000000000013L });
    public static final BitSet FOLLOW_expression_in_qualifiedRestriction600 = new BitSet(
        new long[] { 0x0000000000000008L });
    public static final BitSet FOLLOW_ALL_RESTRICTION_in_qualifiedRestriction622 = new BitSet(
        new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_propertyExpression_in_qualifiedRestriction629 = new BitSet(
        new long[] { 0xE780300000000008L, 0x0000000000000013L });
    public static final BitSet FOLLOW_expression_in_qualifiedRestriction634 = new BitSet(
        new long[] { 0x0000000000000008L });
    public static final BitSet FOLLOW_cardinalityRestriction_in_qualifiedRestriction650 = new BitSet(
        new long[] { 0x0000000000000002L });
    public static final BitSet FOLLOW_oneOf_in_qualifiedRestriction666 = new BitSet(
        new long[] { 0x0000000000000002L });
    public static final BitSet FOLLOW_valueRestriction_in_qualifiedRestriction682 = new BitSet(
        new long[] { 0x0000000000000002L });
    public static final BitSet FOLLOW_CARDINALITY_RESTRICTION_in_cardinalityRestriction719 = new BitSet(
        new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_MIN_in_cardinalityRestriction722 = new BitSet(
        new long[] { 0x0000040000000000L });
    public static final BitSet FOLLOW_INTEGER_in_cardinalityRestriction727 = new BitSet(
        new long[] { 0xE500300000000008L, 0x0000000000000003L });
    public static final BitSet FOLLOW_unary_in_cardinalityRestriction733 = new BitSet(
        new long[] { 0xE780300000000008L, 0x0000000000000013L });
    public static final BitSet FOLLOW_expression_in_cardinalityRestriction740 = new BitSet(
        new long[] { 0x0000000000000008L });
    public static final BitSet FOLLOW_CARDINALITY_RESTRICTION_in_cardinalityRestriction755 = new BitSet(
        new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_MAX_in_cardinalityRestriction758 = new BitSet(
        new long[] { 0x0000040000000000L });
    public static final BitSet FOLLOW_INTEGER_in_cardinalityRestriction762 = new BitSet(
        new long[] { 0xE500300000000008L, 0x0000000000000003L });
    public static final BitSet FOLLOW_unary_in_cardinalityRestriction768 = new BitSet(
        new long[] { 0xE780300000000008L, 0x0000000000000013L });
    public static final BitSet FOLLOW_expression_in_cardinalityRestriction775 = new BitSet(
        new long[] { 0x0000000000000008L });
    public static final BitSet FOLLOW_CARDINALITY_RESTRICTION_in_cardinalityRestriction794 = new BitSet(
        new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_EXACTLY_in_cardinalityRestriction797 = new BitSet(
        new long[] { 0x0000040000000000L });
    public static final BitSet FOLLOW_INTEGER_in_cardinalityRestriction802 = new BitSet(
        new long[] { 0xE500300000000008L, 0x0000000000000003L });
    public static final BitSet FOLLOW_unary_in_cardinalityRestriction809 = new BitSet(
        new long[] { 0xE780300000000008L, 0x0000000000000013L });
    public static final BitSet FOLLOW_expression_in_cardinalityRestriction816 = new BitSet(
        new long[] { 0x0000000000000008L });
    public static final BitSet FOLLOW_ONE_OF_in_oneOf849 = new BitSet(
        new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_unary_in_oneOf854 = new BitSet(new long[] {
        0xE500300000000008L, 0x0000000000000003L });
    public static final BitSet FOLLOW_VALUE_RESTRICTION_in_valueRestriction889 = new BitSet(
        new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_unary_in_valueRestriction896 = new BitSet(
        new long[] { 0xE500300000000008L, 0x0000000000000003L });
    public static final BitSet FOLLOW_unary_in_valueRestriction903 = new BitSet(
        new long[] { 0x0000000000000008L });
    public static final BitSet FOLLOW_SUB_CLASS_AXIOM_in_axiom936 = new BitSet(
        new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_EXPRESSION_in_axiom940 = new BitSet(
        new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_expression_in_axiom947 = new BitSet(
        new long[] { 0x0000000000000008L });
    public static final BitSet FOLLOW_EXPRESSION_in_axiom952 = new BitSet(
        new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_expression_in_axiom959 = new BitSet(
        new long[] { 0x0000000000000008L });
    public static final BitSet FOLLOW_EQUIVALENT_TO_AXIOM_in_axiom972 = new BitSet(
        new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_EXPRESSION_in_axiom975 = new BitSet(
        new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_expression_in_axiom981 = new BitSet(
        new long[] { 0x0000000000000008L });
    public static final BitSet FOLLOW_EXPRESSION_in_axiom985 = new BitSet(
        new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_expression_in_axiom992 = new BitSet(
        new long[] { 0x0000000000000008L });
    public static final BitSet FOLLOW_INVERSE_OF_in_axiom1007 = new BitSet(
        new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_EXPRESSION_in_axiom1010 = new BitSet(
        new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_IDENTIFIER_in_axiom1016 = new BitSet(
        new long[] { 0x0000000000000008L });
    public static final BitSet FOLLOW_EXPRESSION_in_axiom1020 = new BitSet(
        new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_IDENTIFIER_in_axiom1026 = new BitSet(
        new long[] { 0x0000000000000008L });
    public static final BitSet FOLLOW_DISJOINT_WITH_AXIOM_in_axiom1038 = new BitSet(
        new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_EXPRESSION_in_axiom1041 = new BitSet(
        new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_expression_in_axiom1048 = new BitSet(
        new long[] { 0x0000000000000008L });
    public static final BitSet FOLLOW_EXPRESSION_in_axiom1052 = new BitSet(
        new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_expression_in_axiom1058 = new BitSet(
        new long[] { 0x0000000000000008L });
    public static final BitSet FOLLOW_SUB_PROPERTY_AXIOM_in_axiom1070 = new BitSet(
        new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_EXPRESSION_in_axiom1073 = new BitSet(
        new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_expression_in_axiom1080 = new BitSet(
        new long[] { 0x0000000000000008L });
    public static final BitSet FOLLOW_EXPRESSION_in_axiom1084 = new BitSet(
        new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_unary_in_axiom1090 = new BitSet(
        new long[] { 0x0000000000000008L });
    public static final BitSet FOLLOW_ROLE_ASSERTION_in_axiom1104 = new BitSet(
        new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_EXPRESSION_in_axiom1107 = new BitSet(
        new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_IDENTIFIER_in_axiom1114 = new BitSet(
        new long[] { 0x0000000000000008L });
    public static final BitSet FOLLOW_EXPRESSION_in_axiom1118 = new BitSet(
        new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_propertyExpression_in_axiom1125 = new BitSet(
        new long[] { 0x0000000000000008L });
    public static final BitSet FOLLOW_EXPRESSION_in_axiom1129 = new BitSet(
        new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_unary_in_axiom1135 = new BitSet(
        new long[] { 0x0000000000000008L });
    public static final BitSet FOLLOW_TYPE_ASSERTION_in_axiom1145 = new BitSet(
        new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_EXPRESSION_in_axiom1148 = new BitSet(
        new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_expression_in_axiom1155 = new BitSet(
        new long[] { 0x0000000000000008L });
    public static final BitSet FOLLOW_EXPRESSION_in_axiom1159 = new BitSet(
        new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_IDENTIFIER_in_axiom1165 = new BitSet(
        new long[] { 0x0000000000000008L });
    public static final BitSet FOLLOW_DOMAIN_in_axiom1177 = new BitSet(
        new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_EXPRESSION_in_axiom1180 = new BitSet(
        new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_IDENTIFIER_in_axiom1186 = new BitSet(
        new long[] { 0x0000000000000008L });
    public static final BitSet FOLLOW_EXPRESSION_in_axiom1190 = new BitSet(
        new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_expression_in_axiom1196 = new BitSet(
        new long[] { 0x0000000000000008L });
    public static final BitSet FOLLOW_RANGE_in_axiom1209 = new BitSet(
        new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_EXPRESSION_in_axiom1212 = new BitSet(
        new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_IDENTIFIER_in_axiom1218 = new BitSet(
        new long[] { 0x0000000000000008L });
    public static final BitSet FOLLOW_EXPRESSION_in_axiom1222 = new BitSet(
        new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_expression_in_axiom1228 = new BitSet(
        new long[] { 0x0000000000000008L });
    public static final BitSet FOLLOW_SAME_AS_AXIOM_in_axiom1243 = new BitSet(
        new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_EXPRESSION_in_axiom1246 = new BitSet(
        new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_IDENTIFIER_in_axiom1251 = new BitSet(
        new long[] { 0x0000000000000008L });
    public static final BitSet FOLLOW_EXPRESSION_in_axiom1255 = new BitSet(
        new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_IDENTIFIER_in_axiom1261 = new BitSet(
        new long[] { 0x0000000000000008L });
    public static final BitSet FOLLOW_DIFFERENT_FROM_AXIOM_in_axiom1277 = new BitSet(
        new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_EXPRESSION_in_axiom1280 = new BitSet(
        new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_IDENTIFIER_in_axiom1285 = new BitSet(
        new long[] { 0x0000000000000008L });
    public static final BitSet FOLLOW_EXPRESSION_in_axiom1289 = new BitSet(
        new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_IDENTIFIER_in_axiom1295 = new BitSet(
        new long[] { 0x0000000000000008L });
    public static final BitSet FOLLOW_UNARY_AXIOM_in_axiom1309 = new BitSet(
        new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_FUNCTIONAL_in_axiom1311 = new BitSet(new long[] {
        0x0000000000000000L, 0x0000000000000020L });
    public static final BitSet FOLLOW_EXPRESSION_in_axiom1314 = new BitSet(
        new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_IDENTIFIER_in_axiom1320 = new BitSet(
        new long[] { 0x0000000000000008L });
    public static final BitSet FOLLOW_UNARY_AXIOM_in_axiom1333 = new BitSet(
        new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_INVERSE_FUNCTIONAL_in_axiom1335 = new BitSet(
        new long[] { 0x0000000000000000L, 0x0000000000000020L });
    public static final BitSet FOLLOW_EXPRESSION_in_axiom1338 = new BitSet(
        new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_IDENTIFIER_in_axiom1344 = new BitSet(
        new long[] { 0x0000000000000008L });
    public static final BitSet FOLLOW_UNARY_AXIOM_in_axiom1360 = new BitSet(
        new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_IRREFLEXIVE_in_axiom1362 = new BitSet(new long[] {
        0x0000000000000000L, 0x0000000000000020L });
    public static final BitSet FOLLOW_EXPRESSION_in_axiom1365 = new BitSet(
        new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_IDENTIFIER_in_axiom1371 = new BitSet(
        new long[] { 0x0000000000000008L });
    public static final BitSet FOLLOW_UNARY_AXIOM_in_axiom1386 = new BitSet(
        new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_REFLEXIVE_in_axiom1388 = new BitSet(new long[] {
        0x0000000000000000L, 0x0000000000000020L });
    public static final BitSet FOLLOW_EXPRESSION_in_axiom1391 = new BitSet(
        new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_IDENTIFIER_in_axiom1397 = new BitSet(
        new long[] { 0x0000000000000008L });
    public static final BitSet FOLLOW_UNARY_AXIOM_in_axiom1412 = new BitSet(
        new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_SYMMETRIC_in_axiom1414 = new BitSet(new long[] {
        0x0000000000000000L, 0x0000000000000020L });
    public static final BitSet FOLLOW_EXPRESSION_in_axiom1417 = new BitSet(
        new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_IDENTIFIER_in_axiom1423 = new BitSet(
        new long[] { 0x0000000000000008L });
    public static final BitSet FOLLOW_UNARY_AXIOM_in_axiom1440 = new BitSet(
        new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_TRANSITIVE_in_axiom1442 = new BitSet(new long[] {
        0x0000000000000000L, 0x0000000000000020L });
    public static final BitSet FOLLOW_EXPRESSION_in_axiom1445 = new BitSet(
        new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_IDENTIFIER_in_axiom1451 = new BitSet(
        new long[] { 0x0000000000000008L });
    public static final BitSet FOLLOW_NEGATED_ASSERTION_in_axiom1466 = new BitSet(
        new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_axiom_in_axiom1471 = new BitSet(
        new long[] { 0x0000000000000008L });
    public static final BitSet FOLLOW_INCOMPLETE_SUB_CLASS_AXIOM_in_incompleteAxiom1521 = new BitSet(
        new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_EXPRESSION_in_incompleteAxiom1525 = new BitSet(
        new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_INCOMPLETE_EXPRESSION_in_incompleteAxiom1537 = new BitSet(
        new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_incompleteExpression_in_incompleteAxiom1543 = new BitSet(
        new long[] { 0x0000000000000008L });
    public static final BitSet FOLLOW_INCOMPLETE_EQUIVALENT_TO_AXIOM_in_incompleteAxiom1563 = new BitSet(
        new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_EXPRESSION_in_incompleteAxiom1566 = new BitSet(
        new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_expression_in_incompleteAxiom1572 = new BitSet(
        new long[] { 0x0000000000000008L });
    public static final BitSet FOLLOW_INCOMPLETE_EXPRESSION_in_incompleteAxiom1577 = new BitSet(
        new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_incompleteExpression_in_incompleteAxiom1584 = new BitSet(
        new long[] { 0x0000000000000008L });
    public static final BitSet FOLLOW_INCOMPLETE_INVERSE_OF_in_incompleteAxiom1604 = new BitSet(
        new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_EXPRESSION_in_incompleteAxiom1607 = new BitSet(
        new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_IDENTIFIER_in_incompleteAxiom1613 = new BitSet(
        new long[] { 0x0000000000000008L });
    public static final BitSet FOLLOW_INCOMPLETE_EXPRESSION_in_incompleteAxiom1618 = new BitSet(
        new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_incompleteExpression_in_incompleteAxiom1624 = new BitSet(
        new long[] { 0x0000000000000008L });
    public static final BitSet FOLLOW_INCOMPLETE_DISJOINT_WITH_AXIOM_in_incompleteAxiom1639 = new BitSet(
        new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_EXPRESSION_in_incompleteAxiom1642 = new BitSet(
        new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_expression_in_incompleteAxiom1649 = new BitSet(
        new long[] { 0x0000000000000008L });
    public static final BitSet FOLLOW_INCOMPLETE_EXPRESSION_in_incompleteAxiom1654 = new BitSet(
        new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_incompleteExpression_in_incompleteAxiom1660 = new BitSet(
        new long[] { 0x0000000000000008L });
    public static final BitSet FOLLOW_INCOMPLETE_SUB_PROPERTY_AXIOM_in_incompleteAxiom1675 = new BitSet(
        new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_EXPRESSION_in_incompleteAxiom1678 = new BitSet(
        new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_expression_in_incompleteAxiom1685 = new BitSet(
        new long[] { 0x0000000000000008L });
    public static final BitSet FOLLOW_INCOMPLETE_EXPRESSION_in_incompleteAxiom1690 = new BitSet(
        new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_incompleteExpression_in_incompleteAxiom1696 = new BitSet(
        new long[] { 0x0000000000000008L });
    public static final BitSet FOLLOW_INCOMPLETE_ROLE_ASSERTION_in_incompleteAxiom1716 = new BitSet(
        new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_EXPRESSION_in_incompleteAxiom1719 = new BitSet(
        new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_IDENTIFIER_in_incompleteAxiom1721 = new BitSet(
        new long[] { 0x0000000000000008L });
    public static final BitSet FOLLOW_EXPRESSION_in_incompleteAxiom1725 = new BitSet(
        new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_propertyExpression_in_incompleteAxiom1727 = new BitSet(
        new long[] { 0x0000000000000008L });
    public static final BitSet FOLLOW_INCOMPLETE_TYPE_ASSERTION_in_incompleteAxiom1738 = new BitSet(
        new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_EXPRESSION_in_incompleteAxiom1742 = new BitSet(
        new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_IDENTIFIER_in_incompleteAxiom1744 = new BitSet(
        new long[] { 0x0000000000000008L });
    public static final BitSet FOLLOW_INCOMPLETE_DOMAIN_in_incompleteAxiom1757 = new BitSet(
        new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_EXPRESSION_in_incompleteAxiom1760 = new BitSet(
        new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_IDENTIFIER_in_incompleteAxiom1766 = new BitSet(
        new long[] { 0x0000000000000008L });
    public static final BitSet FOLLOW_INCOMPLETE_DOMAIN_in_incompleteAxiom1781 = new BitSet(
        new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_EXPRESSION_in_incompleteAxiom1784 = new BitSet(
        new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_IDENTIFIER_in_incompleteAxiom1790 = new BitSet(
        new long[] { 0x0000000000000008L });
    public static final BitSet FOLLOW_INCOMPLETE_EXPRESSION_in_incompleteAxiom1794 = new BitSet(
        new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_incompleteExpression_in_incompleteAxiom1800 = new BitSet(
        new long[] { 0x0000000000000008L });
    public static final BitSet FOLLOW_INCOMPLETE_RANGE_in_incompleteAxiom1815 = new BitSet(
        new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_EXPRESSION_in_incompleteAxiom1818 = new BitSet(
        new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_IDENTIFIER_in_incompleteAxiom1824 = new BitSet(
        new long[] { 0x0000000000000008L });
    public static final BitSet FOLLOW_INCOMPLETE_RANGE_in_incompleteAxiom1835 = new BitSet(
        new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_EXPRESSION_in_incompleteAxiom1838 = new BitSet(
        new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_IDENTIFIER_in_incompleteAxiom1844 = new BitSet(
        new long[] { 0x0000000000000008L });
    public static final BitSet FOLLOW_INCOMPLETE_EXPRESSION_in_incompleteAxiom1848 = new BitSet(
        new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_incompleteExpression_in_incompleteAxiom1854 = new BitSet(
        new long[] { 0x0000000000000008L });
    public static final BitSet FOLLOW_INCOMPLETE_SAME_AS_AXIOM_in_incompleteAxiom1869 = new BitSet(
        new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_EXPRESSION_in_incompleteAxiom1872 = new BitSet(
        new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_IDENTIFIER_in_incompleteAxiom1877 = new BitSet(
        new long[] { 0x0000000000000008L });
    public static final BitSet FOLLOW_INCOMPLETE_DIFFERENT_FROM_AXIOM_in_incompleteAxiom1893 = new BitSet(
        new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_EXPRESSION_in_incompleteAxiom1896 = new BitSet(
        new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_IDENTIFIER_in_incompleteAxiom1901 = new BitSet(
        new long[] { 0x0000000000000008L });
    public static final BitSet FOLLOW_INCOMPLETE_UNARY_AXIOM_in_incompleteAxiom1916 = new BitSet(
        new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_FUNCTIONAL_in_incompleteAxiom1918 = new BitSet(
        new long[] { 0x0000000000000008L });
    public static final BitSet FOLLOW_INCOMPLETE_UNARY_AXIOM_in_incompleteAxiom1932 = new BitSet(
        new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_INVERSE_FUNCTIONAL_in_incompleteAxiom1934 = new BitSet(
        new long[] { 0x0000000000000008L });
    public static final BitSet FOLLOW_INCOMPLETE_UNARY_AXIOM_in_incompleteAxiom1949 = new BitSet(
        new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_IRREFLEXIVE_in_incompleteAxiom1951 = new BitSet(
        new long[] { 0x0000000000000008L });
    public static final BitSet FOLLOW_INCOMPLETE_UNARY_AXIOM_in_incompleteAxiom1965 = new BitSet(
        new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_REFLEXIVE_in_incompleteAxiom1967 = new BitSet(
        new long[] { 0x0000000000000008L });
    public static final BitSet FOLLOW_INCOMPLETE_UNARY_AXIOM_in_incompleteAxiom1981 = new BitSet(
        new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_SYMMETRIC_in_incompleteAxiom1983 = new BitSet(
        new long[] { 0x0000000000000008L });
    public static final BitSet FOLLOW_INCOMPLETE_UNARY_AXIOM_in_incompleteAxiom1999 = new BitSet(
        new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_TRANSITIVE_in_incompleteAxiom2001 = new BitSet(
        new long[] { 0x0000000000000008L });
    public static final BitSet FOLLOW_INCOMPLETE_PROPERTY_CHAIN_in_incompleteExpression2043 = new BitSet(
        new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_INCOMPLETE_DISJUNCTION_in_incompleteExpression2062 = new BitSet(
        new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_incompleteConjunction_in_incompleteExpression2069 = new BitSet(
        new long[] { 0x0000000000000008L });
    public static final BitSet FOLLOW_INCOMPLETE_EXPRESSION_in_incompleteExpression2083 = new BitSet(
        new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_EXPRESSION_in_incompleteExpression2086 = new BitSet(
        new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_expression_in_incompleteExpression2093 = new BitSet(
        new long[] { 0x0000000000000008L });
    public static final BitSet FOLLOW_IDENTIFIER_in_incompleteExpression2096 = new BitSet(
        new long[] { 0x0000000000000008L });
    public static final BitSet FOLLOW_INCOMPLETE_EXPRESSION_in_incompleteExpression2105 = new BitSet(
        new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_incompleteUnary_in_incompleteExpression2112 = new BitSet(
        new long[] { 0x0000000000000008L });
    public static final BitSet FOLLOW_INCOMPLETE_CONJUNCTION_in_incompleteConjunction2159 = new BitSet(
        new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_incompleteUnary_in_incompleteConjunction2166 = new BitSet(
        new long[] { 0x0000000000000008L });
    public static final BitSet FOLLOW_INCOMPLETE_NEGATED_EXPRESSION_in_incompleteUnary2211 = new BitSet(
        new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_incompleteQualifiedRestriction_in_incompleteUnary2242 = new BitSet(
        new long[] { 0x0000000000000002L });
    public static final BitSet FOLLOW_INCOMPLETE_SOME_RESTRICTION_in_incompleteQualifiedRestriction2300 = new BitSet(
        new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_propertyExpression_in_incompleteQualifiedRestriction2302 = new BitSet(
        new long[] { 0x0000000000000008L });
    public static final BitSet FOLLOW_INCOMPLETE_ALL_RESTRICTION_in_incompleteQualifiedRestriction2345 = new BitSet(
        new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_propertyExpression_in_incompleteQualifiedRestriction2347 = new BitSet(
        new long[] { 0x0000000000000008L });
    public static final BitSet FOLLOW_incompleteCardinalityRestriction_in_incompleteQualifiedRestriction2370 = new BitSet(
        new long[] { 0x0000000000000002L });
    public static final BitSet FOLLOW_incompleteOneOf_in_incompleteQualifiedRestriction2392 = new BitSet(
        new long[] { 0x0000000000000002L });
    public static final BitSet FOLLOW_incompleteValueRestriction_in_incompleteQualifiedRestriction2414 = new BitSet(
        new long[] { 0x0000000000000002L });
    public static final BitSet FOLLOW_INCOMPLETE_CARDINALITY_RESTRICTION_in_incompleteCardinalityRestriction2475 = new BitSet(
        new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_INTEGER_in_incompleteCardinalityRestriction2480 = new BitSet(
        new long[] { 0xE780300000000008L, 0x0000000000000013L });
    public static final BitSet FOLLOW_propertyExpression_in_incompleteCardinalityRestriction2482 = new BitSet(
        new long[] { 0x0000000000000008L });
    public static final BitSet FOLLOW_INCOMPLETE_ONE_OF_in_incompleteOneOf2528 = new BitSet(
        new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_IDENTIFIER_in_incompleteOneOf2530 = new BitSet(
        new long[] { 0x0000100000000008L });
    public static final BitSet FOLLOW_INCOMPLETE_VALUE_RESTRICTION_in_incompleteValueRestriction2578 = new BitSet(
        new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_propertyExpression_in_incompleteValueRestriction2584 = new BitSet(
        new long[] { 0x0000000000000008L });
}
