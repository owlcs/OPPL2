// $ANTLR 3.2 Sep 23, 2009 12:02:23 /Users/luigi/Documents/workspace/Parsers/src/OPPLTypeEnforcement.g 2011-08-19 11:44:19
package org.coode.parsers.oppl;

import static org.coode.oppl.utils.ArgCheck.checkNotNull;

import java.util.ArrayList;
import java.util.List;

import org.antlr.runtime.*;
import org.antlr.runtime.tree.RewriteEmptyStreamException;
import org.antlr.runtime.tree.TreeFilter;
import org.antlr.runtime.tree.TreeNodeStream;
import org.antlr.runtime.tree.TreeRuleReturnScope;
import org.coode.parsers.*;

@SuppressWarnings({ "javadoc", "incomplete-switch" })
public class OPPLTypeEnforcement extends TreeFilter {

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
        "CONSTANT", "WHERE", "NOT_EQUAL", "EQUAL", "IN", "SELECT", "ASSERTED",
        "COLON", "DOT", "PLUS", "CREATE", "CREATE_INTERSECTION",
        "CREATE_DISJUNCTION", "BEGIN", "END", "OPEN_SQUARE_BRACKET",
        "CLOSED_SQUARE_BRACKET", "SUPER_CLASS_OF", "SUPER_PROPERTY_OF",
        "VARIABLE_TYPE", "ADD", "REMOVE", "ASSERTED_CLAUSE", "PLAIN_CLAUSE",
        "INEQUALITY_CONSTRAINT", "IN_SET_CONSTRAINT", "INPUT_VARIABLE_DEFINITION",
        "GENERATED_VARIABLE_DEFINITION", "CREATE_OPPL_FUNCTION",
        "VARIABLE_ATTRIBUTE", "OPPL_FUNCTION", "ACTIONS", "VARIABLE_DEFINITIONS",
        "QUERY", "VARIABLE_SCOPE", "SUBPROPERTY_OF", "VARIABLE_IDENTIFIER",
        "OPPL_STATEMENT", "HAS_KEY", "IRI", "ANNOTATION_ASSERTION",
        "IRI_ATTRIBUTE_NAME", "AT", "SET", "DISJOINT_CLASSES", "DISJOINT_PROPERTIES",
        "SAME_INDIVIDUAL", "DIFFERENT_INDIVIDUALS", "TO_LOWER_CASE", "TO_UPPER_CASE",
        "ESCLAMATION_MARK", "MATCH", "ATTRIBUTE_SELECTOR", "VALUES", "RENDERING",
        "GROUPS", "STRING_OPERATION", "VARIABLE_NAME", "REGEXP_CONSTRAINT", "FAIL",
        "NAF_CONSTRAINT", "LESS_THAN", "LESS_THAN_EQUAL", "GREATER_THAN",
        "GREATER_THAN_EQUAL" };
    public static final int HAS_KEY = 109;
    public static final int VALUE_RESTRICTION = 63;
    public static final int LETTER = 43;
    public static final int REMOVE = 91;
    public static final int TYPES = 39;
    public static final int SAME_AS_AXIOM = 52;
    public static final int INVERSE_OF = 25;
    public static final int NOT = 12;
    public static final int SUBCLASS_OF = 20;
    public static final int EOF = -1;
    public static final int ESCLAMATION_MARK = 149;
    public static final int ACTIONS = 101;
    public static final int CREATE = 80;
    public static final int POW = 36;
    public static final int INPUT_VARIABLE_DEFINITION = 96;
    public static final int NOT_EQUAL = 72;
    public static final int INVERSE_OBJECT_PROPERTY_EXPRESSION = 68;
    public static final int INSTANCE_OF = 38;
    public static final int BEGIN = 83;
    public static final int VARIABLE_SCOPE = 104;
    public static final int INEQUALITY_CONSTRAINT = 94;
    public static final int QUESTION_MARK = 46;
    public static final int DISJOINT_PROPERTIES = 117;
    public static final int SYMMETRIC = 30;
    public static final int CARDINALITY_RESTRICTION = 64;
    public static final int SELECT = 75;
    public static final int ROLE_ASSERTION = 67;
    public static final int DIFFERENT_FROM_AXIOM = 53;
    public static final int TO_LOWER_CASE = 120;
    public static final int CREATE_OPPL_FUNCTION = 98;
    public static final int TRANSITIVE = 34;
    public static final int ANTI_SYMMETRIC = 31;
    public static final int GREATER_THAN_EQUAL = 486;
    public static final int ALL_RESTRICTION = 62;
    public static final int CONJUNCTION = 56;
    public static final int OPPL_STATEMENT = 107;
    public static final int NEGATED_ASSERTION = 59;
    public static final int WHITESPACE = 9;
    public static final int MATCH = 176;
    public static final int IN_SET_CONSTRAINT = 95;
    public static final int VALUE = 18;
    public static final int FAIL = 466;
    public static final int GROUPS = 356;
    public static final int OPEN_CURLY_BRACES = 6;
    public static final int DISJUNCTION = 55;
    public static final int INVERSE = 19;
    public static final int NAF_CONSTRAINT = 467;
    public static final int DBLQUOTE = 40;
    public static final int STRING_OPERATION = 394;
    public static final int OR = 11;
    public static final int LESS_THAN = 483;
    public static final int CONSTANT = 70;
    public static final int QUERY = 103;
    public static final int ENTITY_REFERENCE = 45;
    public static final int END = 84;
    public static final int COMPOSITION = 4;
    public static final int ANNOTATION_ASSERTION = 111;
    public static final int CLOSED_SQUARE_BRACKET = 86;
    public static final int SAME_AS = 23;
    public static final int WHERE = 71;
    public static final int DIFFERENT_INDIVIDUALS = 119;
    public static final int DISJOINT_WITH = 26;
    public static final int SUPER_PROPERTY_OF = 88;
    public static final int VARIABLE_TYPE = 89;
    public static final int ATTRIBUTE_SELECTOR = 283;
    public static final int CLOSED_PARENTHESYS = 8;
    public static final int ONLY = 14;
    public static final int EQUIVALENT_TO_AXIOM = 49;
    public static final int SUB_PROPERTY_OF = 21;
    public static final int NEGATED_EXPRESSION = 58;
    public static final int MAX = 16;
    public static final int TO_UPPER_CASE = 121;
    public static final int CREATE_DISJUNCTION = 82;
    public static final int AND = 10;
    public static final int ASSERTED_CLAUSE = 92;
    public static final int INVERSE_PROPERTY = 60;
    public static final int AT = 114;
    public static final int VARIABLE_NAME = 464;
    public static final int DIFFERENT_FROM = 24;
    public static final int IN = 74;
    public static final int EQUIVALENT_TO = 22;
    public static final int UNARY_AXIOM = 54;
    public static final int COMMA = 37;
    public static final int CLOSED_CURLY_BRACES = 7;
    public static final int IDENTIFIER = 44;
    public static final int IRI = 110;
    public static final int SOME = 13;
    public static final int EQUAL = 73;
    public static final int OPEN_PARENTHESYS = 5;
    public static final int SAME_INDIVIDUAL = 118;
    public static final int REFLEXIVE = 32;
    public static final int PLUS = 79;
    public static final int DIGIT = 41;
    public static final int DOT = 78;
    public static final int SUPER_CLASS_OF = 87;
    public static final int EXPRESSION = 69;
    public static final int SOME_RESTRICTION = 61;
    public static final int ADD = 90;
    public static final int INTEGER = 42;
    public static final int GREATER_THAN = 485;
    public static final int GENERATED_VARIABLE_DEFINITION = 97;
    public static final int EXACTLY = 17;
    public static final int SUB_PROPERTY_AXIOM = 51;
    public static final int OPEN_SQUARE_BRACKET = 85;
    public static final int VALUES = 354;
    public static final int REGEXP_CONSTRAINT = 465;
    public static final int RANGE = 28;
    public static final int SET = 115;
    public static final int ONE_OF = 65;
    public static final int VARIABLE_DEFINITIONS = 102;
    public static final int MIN = 15;
    public static final int SUB_CLASS_AXIOM = 48;
    public static final int PLAIN_CLAUSE = 93;
    public static final int Tokens = 47;
    public static final int DOMAIN = 27;
    public static final int SUBPROPERTY_OF = 105;
    public static final int OPPL_FUNCTION = 100;
    public static final int COLON = 77;
    public static final int DISJOINT_WITH_AXIOM = 50;
    public static final int CREATE_INTERSECTION = 81;
    public static final int INVERSE_FUNCTIONAL = 35;
    public static final int RENDERING = 355;
    public static final int VARIABLE_IDENTIFIER = 106;
    public static final int IRI_ATTRIBUTE_NAME = 112;
    public static final int IRREFLEXIVE = 33;
    public static final int LESS_THAN_EQUAL = 484;
    public static final int VARIABLE_ATTRIBUTE = 99;
    public static final int ASSERTED = 76;
    public static final int FUNCTIONAL = 29;
    public static final int PROPERTY_CHAIN = 57;
    public static final int TYPE_ASSERTION = 66;
    public static final int DISJOINT_CLASSES = 116;

    // delegates
    // delegators
    public OPPLTypeEnforcement(TreeNodeStream input) {
        this(input, new RecognizerSharedState());
    }

    public OPPLTypeEnforcement(TreeNodeStream input, RecognizerSharedState state) {
        super(input, state);
    }

    @Override
    public String[] getTokenNames() {
        return OPPLTypeEnforcement.tokenNames;
    }

    @Override
    public String getGrammarFileName() {
        return "/Users/luigi/Documents/workspace/Parsers/src/OPPLTypeEnforcement.g";
    }

    private SymbolTable symtab;
    private TypesEnforcer typesEnforcer;
    private ErrorListener errorListener;

    public OPPLTypeEnforcement(TreeNodeStream input, SymbolTable symtab,
        TypesEnforcer typesEnforcer, ErrorListener errorListener) {
        this(input);
        this.symtab = checkNotNull(symtab, "symtab");
        this.errorListener = checkNotNull(errorListener, "errorListener");
        this.typesEnforcer = checkNotNull(typesEnforcer, "typesEnforcer");
    }

    public TypesEnforcer getTypesEnforcer() {
        return typesEnforcer;
    }

    public ErrorListener getErrorListener() {
        return errorListener;
    }

    public SymbolTable getSymbolTable() {
        return symtab;
    }

    @Override
    public void displayRecognitionError(String[] t, RecognitionException e) {
        getErrorListener().recognitionException(e, t);
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

    // $ANTLR start "bottomup"
    // /Users/luigi/Documents/workspace/Parsers/src/OPPLTypeEnforcement.g:91:1:
    // bottomup : ( expressionRoot | axiom );
    @Override
    public final void bottomup() {
        try {
            // /Users/luigi/Documents/workspace/Parsers/src/OPPLTypeEnforcement.g:92:5:
            // ( expressionRoot | axiom )
            int alt1 = 2;
            int LA1_0 = input.LA(1);
            if (LA1_0 == EXPRESSION) {
                alt1 = 1;
            } else if (LA1_0 == INVERSE_OF || LA1_0 >= DOMAIN && LA1_0 <= RANGE
                || LA1_0 >= SUB_CLASS_AXIOM && LA1_0 <= UNARY_AXIOM
                || LA1_0 == NEGATED_ASSERTION || LA1_0 >= TYPE_ASSERTION
                    && LA1_0 <= ROLE_ASSERTION) {
                alt1 = 2;
            } else {
                if (state.backtracking > 0) {
                    state.failed = true;
                    return;
                }
                NoViableAltException nvae = new NoViableAltException("", 1, 0, input);
                throw nvae;
            }
            switch (alt1) {
                case 1:
                // /Users/luigi/Documents/workspace/Parsers/src/OPPLTypeEnforcement.g:92:9:
                // expressionRoot
                {
                    pushFollow(FOLLOW_expressionRoot_in_bottomup81);
                    expressionRoot();
                    state._fsp--;
                    if (state.failed) {
                        return;
                    }
                }
                    break;
                case 2:
                // /Users/luigi/Documents/workspace/Parsers/src/OPPLTypeEnforcement.g:93:8:
                // axiom
                {
                    pushFollow(FOLLOW_axiom_in_bottomup91);
                    axiom();
                    state._fsp--;
                    if (state.failed) {
                        return;
                    }
                }
                    break;
            }
        } catch (RecognitionException exception) {
            if (errorListener != null) {
                errorListener.recognitionException(exception);
            }
        } catch (RewriteEmptyStreamException exception) {
            if (errorListener != null) {
                errorListener.rewriteEmptyStreamException(exception);
            }
        }
        return;
    }

    // $ANTLR end "bottomup"
    // $ANTLR start "expressionRoot"
    // /Users/luigi/Documents/workspace/Parsers/src/OPPLTypeEnforcement.g:96:1:
    // expressionRoot : ^( EXPRESSION expression ) ;
    public final void expressionRoot() {
        OPPLSyntaxTree EXPRESSION1 = null;
        OPPLTypeEnforcement.expression_return expression2 = null;
        try {
            // /Users/luigi/Documents/workspace/Parsers/src/OPPLTypeEnforcement.g:97:5:
            // ( ^( EXPRESSION expression ) )
            // /Users/luigi/Documents/workspace/Parsers/src/OPPLTypeEnforcement.g:97:9:
            // ^( EXPRESSION expression )
            {
                EXPRESSION1 = (OPPLSyntaxTree) match(input, EXPRESSION,
                    FOLLOW_EXPRESSION_in_expressionRoot118);
                if (state.failed) {
                    return;
                }
                match(input, Token.DOWN, null);
                if (state.failed) {
                    return;
                }
                pushFollow(FOLLOW_expression_in_expressionRoot120);
                expression2 = expression();
                state._fsp--;
                if (state.failed) {
                    return;
                }
                match(input, Token.UP, null);
                if (state.failed) {
                    return;
                }
                if (state.backtracking == 1) {
                    EXPRESSION1
                        .setEvalType(expression2 != null ? expression2.type : null);
                }
            }
        } catch (RecognitionException exception) {
            if (errorListener != null) {
                errorListener.recognitionException(exception);
            }
        } catch (RewriteEmptyStreamException exception) {
            if (errorListener != null) {
                errorListener.rewriteEmptyStreamException(exception);
            }
        }
        return;
    }

    // $ANTLR end "expressionRoot"
    public static class axiom_return extends TreeRuleReturnScope {

        public Type type;
        public ManchesterOWLSyntaxTree node;
    }

    // $ANTLR start "axiom"
    // /Users/luigi/Documents/workspace/Parsers/src/OPPLTypeEnforcement.g:102:1:
    // axiom returns [Type type, ManchesterOWLSyntaxTree node] : ( ^(
    // SUB_CLASS_AXIOM ^( EXPRESSION subClass= expression ) ^( EXPRESSION
    // superClass= expression ) ) | ^( EQUIVALENT_TO_AXIOM ^( EXPRESSION lhs=
    // expression ) ^( EXPRESSION rhs= expression ) ) | ^( INVERSE_OF ^(
    // EXPRESSION p= IDENTIFIER ) ^( EXPRESSION anotherProperty= IDENTIFIER ) )
    // | ^( DISJOINT_WITH_AXIOM ^( EXPRESSION lhs= expression ) ^( EXPRESSION
    // rhs= expression ) ) | ^( SUB_PROPERTY_AXIOM ^( EXPRESSION subProperty=
    // expression ) ^( EXPRESSION superProperty= unary ) ) | ^( ROLE_ASSERTION
    // ^( EXPRESSION subject= IDENTIFIER ) ^( EXPRESSION predicate=
    // propertyExpression ) ^( EXPRESSION object= unary ) ) | ^( TYPE_ASSERTION
    // ^( EXPRESSION description= expression ) ^( EXPRESSION subject= IDENTIFIER
    // ) ) | ^( DOMAIN ^( EXPRESSION p= IDENTIFIER ) ^( EXPRESSION domain=
    // expression ) ) | ^( RANGE ^( EXPRESSION p= IDENTIFIER ) ^( EXPRESSION
    // range= expression ) ) | ^( SAME_AS_AXIOM ^( EXPRESSION anIndividual=
    // IDENTIFIER ) ^( EXPRESSION anotherIndividual= IDENTIFIER ) ) | ^(
    // DIFFERENT_FROM_AXIOM ^( EXPRESSION anIndividual= IDENTIFIER ) ^(
    // EXPRESSION anotherIndividual= IDENTIFIER ) ) | ^( UNARY_AXIOM FUNCTIONAL
    // ^( EXPRESSION p= IDENTIFIER ) ) | ^( UNARY_AXIOM INVERSE_FUNCTIONAL ^(
    // EXPRESSION p= IDENTIFIER ) ) | ^( UNARY_AXIOM IRREFLEXIVE ^( EXPRESSION
    // p= IDENTIFIER ) ) | ^( UNARY_AXIOM REFLEXIVE ^( EXPRESSION p= IDENTIFIER
    // ) ) | ^( UNARY_AXIOM SYMMETRIC ^( EXPRESSION p= IDENTIFIER ) ) | ^(
    // UNARY_AXIOM TRANSITIVE ^( EXPRESSION p= IDENTIFIER ) ) | ^(
    // NEGATED_ASSERTION a= axiom ) );
    public final OPPLTypeEnforcement.axiom_return axiom() {
        OPPLTypeEnforcement.axiom_return retval = new OPPLTypeEnforcement.axiom_return();
        retval.start = input.LT(1);
        OPPLSyntaxTree p = null;
        OPPLSyntaxTree anotherProperty = null;
        OPPLSyntaxTree subject = null;
        OPPLSyntaxTree anIndividual = null;
        OPPLSyntaxTree anotherIndividual = null;
        OPPLTypeEnforcement.expression_return subClass = null;
        OPPLTypeEnforcement.expression_return superClass = null;
        OPPLTypeEnforcement.expression_return lhs = null;
        OPPLTypeEnforcement.expression_return rhs = null;
        OPPLTypeEnforcement.expression_return subProperty = null;
        OPPLTypeEnforcement.unary_return superProperty = null;
        OPPLTypeEnforcement.propertyExpression_return predicate = null;
        OPPLTypeEnforcement.unary_return object = null;
        OPPLTypeEnforcement.expression_return description = null;
        OPPLTypeEnforcement.expression_return domain = null;
        OPPLTypeEnforcement.expression_return range = null;
        OPPLTypeEnforcement.axiom_return a = null;
        try {
            // /Users/luigi/Documents/workspace/Parsers/src/OPPLTypeEnforcement.g:108:1:
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
            int alt2 = 18;
            alt2 = dfa2.predict(input);
            switch (alt2) {
                case 1:
                // /Users/luigi/Documents/workspace/Parsers/src/OPPLTypeEnforcement.g:109:3:
                // ^( SUB_CLASS_AXIOM ^( EXPRESSION subClass= expression ) ^(
                // EXPRESSION superClass= expression ) )
                {
                    match(input, SUB_CLASS_AXIOM, FOLLOW_SUB_CLASS_AXIOM_in_axiom158);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.DOWN, null);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, EXPRESSION, FOLLOW_EXPRESSION_in_axiom162);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.DOWN, null);
                    if (state.failed) {
                        return retval;
                    }
                    pushFollow(FOLLOW_expression_in_axiom169);
                    subClass = expression();
                    state._fsp--;
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.UP, null);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, EXPRESSION, FOLLOW_EXPRESSION_in_axiom174);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.DOWN, null);
                    if (state.failed) {
                        return retval;
                    }
                    pushFollow(FOLLOW_expression_in_axiom181);
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
                        retval.type = getSymbolTable().getSubClassAxiomType(
                            (OPPLSyntaxTree) retval.start, subClass.node,
                            superClass.node);
                        getTypesEnforcer().enforceSubClassOfAxiomTypes(
                            (OPPLSyntaxTree) retval.start, subClass.node,
                            superClass.node);
                    }
                }
                    break;
                case 2:
                // /Users/luigi/Documents/workspace/Parsers/src/OPPLTypeEnforcement.g:114:5:
                // ^( EQUIVALENT_TO_AXIOM ^( EXPRESSION lhs= expression ) ^(
                // EXPRESSION rhs= expression ) )
                {
                    match(input, EQUIVALENT_TO_AXIOM,
                        FOLLOW_EQUIVALENT_TO_AXIOM_in_axiom194);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.DOWN, null);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, EXPRESSION, FOLLOW_EXPRESSION_in_axiom197);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.DOWN, null);
                    if (state.failed) {
                        return retval;
                    }
                    pushFollow(FOLLOW_expression_in_axiom203);
                    lhs = expression();
                    state._fsp--;
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.UP, null);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, EXPRESSION, FOLLOW_EXPRESSION_in_axiom207);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.DOWN, null);
                    if (state.failed) {
                        return retval;
                    }
                    pushFollow(FOLLOW_expression_in_axiom214);
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
                        retval.type = getSymbolTable().getEquivalentAxiomType(
                            (OPPLSyntaxTree) retval.start, lhs.node, rhs.node);
                        getTypesEnforcer().enforceEquivalentToAxiomTypes(
                            (OPPLSyntaxTree) retval.start, lhs.node, rhs.node);
                    }
                }
                    break;
                case 3:
                // /Users/luigi/Documents/workspace/Parsers/src/OPPLTypeEnforcement.g:119:4:
                // ^( INVERSE_OF ^( EXPRESSION p= IDENTIFIER ) ^( EXPRESSION
                // anotherProperty= IDENTIFIER ) )
                {
                    match(input, INVERSE_OF, FOLLOW_INVERSE_OF_in_axiom229);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.DOWN, null);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, EXPRESSION, FOLLOW_EXPRESSION_in_axiom232);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.DOWN, null);
                    if (state.failed) {
                        return retval;
                    }
                    p = (OPPLSyntaxTree) match(input, IDENTIFIER,
                        FOLLOW_IDENTIFIER_in_axiom238);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.UP, null);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, EXPRESSION, FOLLOW_EXPRESSION_in_axiom242);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.DOWN, null);
                    if (state.failed) {
                        return retval;
                    }
                    anotherProperty = (OPPLSyntaxTree) match(input, IDENTIFIER,
                        FOLLOW_IDENTIFIER_in_axiom248);
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
                        retval.type = getSymbolTable().getInverseOfAxiomType(
                            (OPPLSyntaxTree) retval.start, p, anotherProperty);
                        getTypesEnforcer().enforceIverserOfAxiomTypes(
                            (OPPLSyntaxTree) retval.start, p, anotherProperty);
                    }
                }
                    break;
                case 4:
                // /Users/luigi/Documents/workspace/Parsers/src/OPPLTypeEnforcement.g:124:5:
                // ^( DISJOINT_WITH_AXIOM ^( EXPRESSION lhs= expression ) ^(
                // EXPRESSION rhs= expression ) )
                {
                    match(input, DISJOINT_WITH_AXIOM,
                        FOLLOW_DISJOINT_WITH_AXIOM_in_axiom260);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.DOWN, null);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, EXPRESSION, FOLLOW_EXPRESSION_in_axiom263);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.DOWN, null);
                    if (state.failed) {
                        return retval;
                    }
                    pushFollow(FOLLOW_expression_in_axiom270);
                    lhs = expression();
                    state._fsp--;
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.UP, null);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, EXPRESSION, FOLLOW_EXPRESSION_in_axiom274);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.DOWN, null);
                    if (state.failed) {
                        return retval;
                    }
                    pushFollow(FOLLOW_expression_in_axiom280);
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
                        retval.type = getSymbolTable().getDisjointAxiomType(
                            (OPPLSyntaxTree) retval.start, lhs.node, rhs.node);
                        getTypesEnforcer().enforceDisjointWithAxiomTypes(
                            (OPPLSyntaxTree) retval.start, lhs.node, rhs.node);
                    }
                }
                    break;
                case 5:
                // /Users/luigi/Documents/workspace/Parsers/src/OPPLTypeEnforcement.g:128:4:
                // ^( SUB_PROPERTY_AXIOM ^( EXPRESSION subProperty= expression )
                // ^( EXPRESSION superProperty= unary ) )
                {
                    match(input, SUB_PROPERTY_AXIOM,
                        FOLLOW_SUB_PROPERTY_AXIOM_in_axiom292);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.DOWN, null);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, EXPRESSION, FOLLOW_EXPRESSION_in_axiom295);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.DOWN, null);
                    if (state.failed) {
                        return retval;
                    }
                    pushFollow(FOLLOW_expression_in_axiom302);
                    subProperty = expression();
                    state._fsp--;
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.UP, null);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, EXPRESSION, FOLLOW_EXPRESSION_in_axiom306);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.DOWN, null);
                    if (state.failed) {
                        return retval;
                    }
                    pushFollow(FOLLOW_unary_in_axiom312);
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
                        retval.type = getSymbolTable().getSubPropertyAxiomType(
                            (OPPLSyntaxTree) retval.start, subProperty.node,
                            superProperty.node);
                        getTypesEnforcer().enforceSubPropertyAxiomTypes(
                            (OPPLSyntaxTree) retval.start, subProperty.node,
                            superProperty.node);
                    }
                }
                    break;
                case 6:
                // /Users/luigi/Documents/workspace/Parsers/src/OPPLTypeEnforcement.g:133:4:
                // ^( ROLE_ASSERTION ^( EXPRESSION subject= IDENTIFIER ) ^(
                // EXPRESSION predicate= propertyExpression ) ^( EXPRESSION
                // object= unary ) )
                {
                    match(input, ROLE_ASSERTION, FOLLOW_ROLE_ASSERTION_in_axiom326);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.DOWN, null);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, EXPRESSION, FOLLOW_EXPRESSION_in_axiom329);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.DOWN, null);
                    if (state.failed) {
                        return retval;
                    }
                    subject = (OPPLSyntaxTree) match(input, IDENTIFIER,
                        FOLLOW_IDENTIFIER_in_axiom336);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.UP, null);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, EXPRESSION, FOLLOW_EXPRESSION_in_axiom340);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.DOWN, null);
                    if (state.failed) {
                        return retval;
                    }
                    pushFollow(FOLLOW_propertyExpression_in_axiom347);
                    predicate = propertyExpression();
                    state._fsp--;
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.UP, null);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, EXPRESSION, FOLLOW_EXPRESSION_in_axiom351);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.DOWN, null);
                    if (state.failed) {
                        return retval;
                    }
                    pushFollow(FOLLOW_unary_in_axiom357);
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
                        retval.type = getSymbolTable().getRoleAssertionAxiomType(
                            (OPPLSyntaxTree) retval.start, subject, predicate.node,
                            object.node);
                        getTypesEnforcer().enforceRoleAssertionAxiomTypes(
                            (OPPLSyntaxTree) retval.start, subject, predicate.node,
                            object.node);
                    }
                }
                    break;
                case 7:
                // /Users/luigi/Documents/workspace/Parsers/src/OPPLTypeEnforcement.g:137:5:
                // ^( TYPE_ASSERTION ^( EXPRESSION description= expression ) ^(
                // EXPRESSION subject= IDENTIFIER ) )
                {
                    match(input, TYPE_ASSERTION, FOLLOW_TYPE_ASSERTION_in_axiom367);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.DOWN, null);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, EXPRESSION, FOLLOW_EXPRESSION_in_axiom370);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.DOWN, null);
                    if (state.failed) {
                        return retval;
                    }
                    pushFollow(FOLLOW_expression_in_axiom377);
                    description = expression();
                    state._fsp--;
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.UP, null);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, EXPRESSION, FOLLOW_EXPRESSION_in_axiom381);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.DOWN, null);
                    if (state.failed) {
                        return retval;
                    }
                    subject = (OPPLSyntaxTree) match(input, IDENTIFIER,
                        FOLLOW_IDENTIFIER_in_axiom387);
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
                        retval.type = getSymbolTable().getClassAssertionAxiomType(
                            (OPPLSyntaxTree) retval.start, description.node, subject);
                        getTypesEnforcer().enforceTypeAssertionAxiomTypes(
                            (OPPLSyntaxTree) retval.start, description.node, subject);
                    }
                }
                    break;
                case 8:
                // /Users/luigi/Documents/workspace/Parsers/src/OPPLTypeEnforcement.g:142:4:
                // ^( DOMAIN ^( EXPRESSION p= IDENTIFIER ) ^( EXPRESSION domain=
                // expression ) )
                {
                    match(input, DOMAIN, FOLLOW_DOMAIN_in_axiom399);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.DOWN, null);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, EXPRESSION, FOLLOW_EXPRESSION_in_axiom402);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.DOWN, null);
                    if (state.failed) {
                        return retval;
                    }
                    p = (OPPLSyntaxTree) match(input, IDENTIFIER,
                        FOLLOW_IDENTIFIER_in_axiom408);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.UP, null);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, EXPRESSION, FOLLOW_EXPRESSION_in_axiom412);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.DOWN, null);
                    if (state.failed) {
                        return retval;
                    }
                    pushFollow(FOLLOW_expression_in_axiom418);
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
                        retval.type = getSymbolTable().getDomainAxiomType(
                            (OPPLSyntaxTree) retval.start, p, domain.node);
                        getTypesEnforcer().enforceDomainAxiomTypes(
                            (OPPLSyntaxTree) retval.start, p, domain.node);
                    }
                }
                    break;
                case 9:
                // /Users/luigi/Documents/workspace/Parsers/src/OPPLTypeEnforcement.g:147:5:
                // ^( RANGE ^( EXPRESSION p= IDENTIFIER ) ^( EXPRESSION range=
                // expression ) )
                {
                    match(input, RANGE, FOLLOW_RANGE_in_axiom431);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.DOWN, null);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, EXPRESSION, FOLLOW_EXPRESSION_in_axiom434);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.DOWN, null);
                    if (state.failed) {
                        return retval;
                    }
                    p = (OPPLSyntaxTree) match(input, IDENTIFIER,
                        FOLLOW_IDENTIFIER_in_axiom440);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.UP, null);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, EXPRESSION, FOLLOW_EXPRESSION_in_axiom444);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.DOWN, null);
                    if (state.failed) {
                        return retval;
                    }
                    pushFollow(FOLLOW_expression_in_axiom450);
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
                        retval.type = getSymbolTable().getRangeAxiomType(
                            (OPPLSyntaxTree) retval.start, p, range.node);
                        getTypesEnforcer().enforceRangeAxiomTypes(
                            (OPPLSyntaxTree) retval.start, p, range.node);
                    }
                }
                    break;
                case 10:
                // /Users/luigi/Documents/workspace/Parsers/src/OPPLTypeEnforcement.g:152:6:
                // ^( SAME_AS_AXIOM ^( EXPRESSION anIndividual= IDENTIFIER ) ^(
                // EXPRESSION anotherIndividual= IDENTIFIER ) )
                {
                    match(input, SAME_AS_AXIOM, FOLLOW_SAME_AS_AXIOM_in_axiom465);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.DOWN, null);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, EXPRESSION, FOLLOW_EXPRESSION_in_axiom468);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.DOWN, null);
                    if (state.failed) {
                        return retval;
                    }
                    anIndividual = (OPPLSyntaxTree) match(input, IDENTIFIER,
                        FOLLOW_IDENTIFIER_in_axiom473);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.UP, null);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, EXPRESSION, FOLLOW_EXPRESSION_in_axiom477);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.DOWN, null);
                    if (state.failed) {
                        return retval;
                    }
                    anotherIndividual = (OPPLSyntaxTree) match(input, IDENTIFIER,
                        FOLLOW_IDENTIFIER_in_axiom483);
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
                        retval.type = getSymbolTable().getSameIndividualsAxiomType(
                            (OPPLSyntaxTree) retval.start, anIndividual,
                            anotherIndividual);
                        getTypesEnforcer().enforceSameIndividualsAxiomTypes(
                            (OPPLSyntaxTree) retval.start, anIndividual,
                            anotherIndividual);
                    }
                }
                    break;
                case 11:
                // /Users/luigi/Documents/workspace/Parsers/src/OPPLTypeEnforcement.g:157:7:
                // ^( DIFFERENT_FROM_AXIOM ^( EXPRESSION anIndividual=
                // IDENTIFIER ) ^( EXPRESSION anotherIndividual= IDENTIFIER ) )
                {
                    match(input, DIFFERENT_FROM_AXIOM,
                        FOLLOW_DIFFERENT_FROM_AXIOM_in_axiom499);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.DOWN, null);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, EXPRESSION, FOLLOW_EXPRESSION_in_axiom502);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.DOWN, null);
                    if (state.failed) {
                        return retval;
                    }
                    anIndividual = (OPPLSyntaxTree) match(input, IDENTIFIER,
                        FOLLOW_IDENTIFIER_in_axiom507);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.UP, null);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, EXPRESSION, FOLLOW_EXPRESSION_in_axiom511);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.DOWN, null);
                    if (state.failed) {
                        return retval;
                    }
                    anotherIndividual = (OPPLSyntaxTree) match(input, IDENTIFIER,
                        FOLLOW_IDENTIFIER_in_axiom517);
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
                        retval.type = getSymbolTable().getDifferentIndividualsAxiomType(
                            (OPPLSyntaxTree) retval.start, anIndividual,
                            anotherIndividual);
                        getTypesEnforcer().enforceDifferentIndividualsAxiomTypes(
                            (OPPLSyntaxTree) retval.start, anIndividual,
                            anotherIndividual);
                    }
                }
                    break;
                case 12:
                // /Users/luigi/Documents/workspace/Parsers/src/OPPLTypeEnforcement.g:162:5:
                // ^( UNARY_AXIOM FUNCTIONAL ^( EXPRESSION p= IDENTIFIER ) )
                {
                    match(input, UNARY_AXIOM, FOLLOW_UNARY_AXIOM_in_axiom531);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.DOWN, null);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, FUNCTIONAL, FOLLOW_FUNCTIONAL_in_axiom533);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, EXPRESSION, FOLLOW_EXPRESSION_in_axiom536);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.DOWN, null);
                    if (state.failed) {
                        return retval;
                    }
                    p = (OPPLSyntaxTree) match(input, IDENTIFIER,
                        FOLLOW_IDENTIFIER_in_axiom542);
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
                        retval.type = getSymbolTable().getFunctionalPropertyType(
                            (OPPLSyntaxTree) retval.start, p);
                        getTypesEnforcer().enforceFunctionalPropertyAxiomTypes(
                            (OPPLSyntaxTree) retval.start, p);
                    }
                }
                    break;
                case 13:
                // /Users/luigi/Documents/workspace/Parsers/src/OPPLTypeEnforcement.g:167:5:
                // ^( UNARY_AXIOM INVERSE_FUNCTIONAL ^( EXPRESSION p= IDENTIFIER
                // ) )
                {
                    match(input, UNARY_AXIOM, FOLLOW_UNARY_AXIOM_in_axiom555);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.DOWN, null);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, INVERSE_FUNCTIONAL,
                        FOLLOW_INVERSE_FUNCTIONAL_in_axiom557);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, EXPRESSION, FOLLOW_EXPRESSION_in_axiom560);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.DOWN, null);
                    if (state.failed) {
                        return retval;
                    }
                    p = (OPPLSyntaxTree) match(input, IDENTIFIER,
                        FOLLOW_IDENTIFIER_in_axiom566);
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
                        retval.type = getSymbolTable().getInverseFunctionalPropertyType(
                            (OPPLSyntaxTree) retval.start, p);
                        getTypesEnforcer().enforceInverseFunctionalPropertyAxiomTypes(
                            (OPPLSyntaxTree) retval.start, p);
                    }
                }
                    break;
                case 14:
                // /Users/luigi/Documents/workspace/Parsers/src/OPPLTypeEnforcement.g:172:7:
                // ^( UNARY_AXIOM IRREFLEXIVE ^( EXPRESSION p= IDENTIFIER ) )
                {
                    match(input, UNARY_AXIOM, FOLLOW_UNARY_AXIOM_in_axiom582);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.DOWN, null);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, IRREFLEXIVE, FOLLOW_IRREFLEXIVE_in_axiom584);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, EXPRESSION, FOLLOW_EXPRESSION_in_axiom587);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.DOWN, null);
                    if (state.failed) {
                        return retval;
                    }
                    p = (OPPLSyntaxTree) match(input, IDENTIFIER,
                        FOLLOW_IDENTIFIER_in_axiom593);
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
                        retval.type = getSymbolTable().getIrreflexivePropertyType(
                            (OPPLSyntaxTree) retval.start, p);
                        getTypesEnforcer().enforceIrreflexivePropertyAxiomTypes(
                            (OPPLSyntaxTree) retval.start, p);
                    }
                }
                    break;
                case 15:
                // /Users/luigi/Documents/workspace/Parsers/src/OPPLTypeEnforcement.g:177:6:
                // ^( UNARY_AXIOM REFLEXIVE ^( EXPRESSION p= IDENTIFIER ) )
                {
                    match(input, UNARY_AXIOM, FOLLOW_UNARY_AXIOM_in_axiom608);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.DOWN, null);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, REFLEXIVE, FOLLOW_REFLEXIVE_in_axiom610);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, EXPRESSION, FOLLOW_EXPRESSION_in_axiom613);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.DOWN, null);
                    if (state.failed) {
                        return retval;
                    }
                    p = (OPPLSyntaxTree) match(input, IDENTIFIER,
                        FOLLOW_IDENTIFIER_in_axiom619);
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
                        retval.type = getSymbolTable().getReflexivePropertyType(
                            (OPPLSyntaxTree) retval.start, p);
                        getTypesEnforcer().enforceReflexivePropertyAxiomTypes(
                            (OPPLSyntaxTree) retval.start, p);
                    }
                }
                    break;
                case 16:
                // /Users/luigi/Documents/workspace/Parsers/src/OPPLTypeEnforcement.g:182:6:
                // ^( UNARY_AXIOM SYMMETRIC ^( EXPRESSION p= IDENTIFIER ) )
                {
                    match(input, UNARY_AXIOM, FOLLOW_UNARY_AXIOM_in_axiom634);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.DOWN, null);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, SYMMETRIC, FOLLOW_SYMMETRIC_in_axiom636);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, EXPRESSION, FOLLOW_EXPRESSION_in_axiom639);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.DOWN, null);
                    if (state.failed) {
                        return retval;
                    }
                    p = (OPPLSyntaxTree) match(input, IDENTIFIER,
                        FOLLOW_IDENTIFIER_in_axiom645);
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
                        retval.type = getSymbolTable().getSymmetricPropertyType(
                            (OPPLSyntaxTree) retval.start, p);
                        getTypesEnforcer().enforceSymmetricPropertyAxiomTypes(
                            (OPPLSyntaxTree) retval.start, p);
                    }
                }
                    break;
                case 17:
                // /Users/luigi/Documents/workspace/Parsers/src/OPPLTypeEnforcement.g:187:7:
                // ^( UNARY_AXIOM TRANSITIVE ^( EXPRESSION p= IDENTIFIER ) )
                {
                    match(input, UNARY_AXIOM, FOLLOW_UNARY_AXIOM_in_axiom662);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.DOWN, null);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, TRANSITIVE, FOLLOW_TRANSITIVE_in_axiom664);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, EXPRESSION, FOLLOW_EXPRESSION_in_axiom667);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.DOWN, null);
                    if (state.failed) {
                        return retval;
                    }
                    p = (OPPLSyntaxTree) match(input, IDENTIFIER,
                        FOLLOW_IDENTIFIER_in_axiom673);
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
                        retval.type = getSymbolTable().getTransitivePropertyType(
                            (OPPLSyntaxTree) retval.start, p);
                        getTypesEnforcer().enforceTransitivePropertyAxiomTypes(
                            (OPPLSyntaxTree) retval.start, p);
                    }
                }
                    break;
                case 18:
                // /Users/luigi/Documents/workspace/Parsers/src/OPPLTypeEnforcement.g:192:6:
                // ^( NEGATED_ASSERTION a= axiom )
                {
                    match(input, NEGATED_ASSERTION, FOLLOW_NEGATED_ASSERTION_in_axiom688);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.DOWN, null);
                    if (state.failed) {
                        return retval;
                    }
                    pushFollow(FOLLOW_axiom_in_axiom693);
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
                        retval.type = getSymbolTable().getNegatedAssertionType(
                            (OPPLSyntaxTree) retval.start, a.node);
                        getTypesEnforcer().enforceNegatedAssertionTypes(
                            (OPPLSyntaxTree) retval.start, a.node);
                    }
                }
                    break;
            }
            if (state.backtracking == 1) {
                ((OPPLSyntaxTree) retval.start).setEvalType(retval.type);
                retval.node = (OPPLSyntaxTree) retval.start;
            }
        } catch (RecognitionException exception) {
            if (errorListener != null) {
                errorListener.recognitionException(exception);
            }
        } catch (RewriteEmptyStreamException exception) {
            if (errorListener != null) {
                errorListener.rewriteEmptyStreamException(exception);
            }
        }
        return retval;
    }

    // $ANTLR end "axiom"
    public static class expression_return extends TreeRuleReturnScope {

        public Type type;
        public ManchesterOWLSyntaxTree node;
    }

    // $ANTLR start "expression"
    // /Users/luigi/Documents/workspace/Parsers/src/OPPLTypeEnforcement.g:198:1:
    // expression returns [Type type, ManchesterOWLSyntaxTree node] : ( ^(
    // DISJUNCTION (disjuncts+= conjunction )+ ) | ^( PROPERTY_CHAIN
    // (chainItems+= expression )+ ) | conjunction | complexPropertyExpression
    // );
    public final OPPLTypeEnforcement.expression_return expression() {
        OPPLTypeEnforcement.expression_return retval = new OPPLTypeEnforcement.expression_return();
        retval.start = input.LT(1);
        List<Object> list_disjuncts = new ArrayList<>();
        List<Object> list_chainItems = new ArrayList<>();
        OPPLTypeEnforcement.conjunction_return conjunction3 = null;
        OPPLTypeEnforcement.complexPropertyExpression_return complexPropertyExpression4 = null;
        RuleReturnScope disjuncts = null;
        RuleReturnScope chainItems = null;
        try {
            // /Users/luigi/Documents/workspace/Parsers/src/OPPLTypeEnforcement.g:205:2:
            // ( ^( DISJUNCTION (disjuncts+= conjunction )+ ) | ^(
            // PROPERTY_CHAIN (chainItems+= expression )+ ) | conjunction |
            // complexPropertyExpression )
            int alt5 = 4;
            switch (input.LA(1)) {
                case DISJUNCTION: {
                    alt5 = 1;
                }
                    break;
                case PROPERTY_CHAIN: {
                    alt5 = 2;
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
                case ONE_OF:
                case CONSTANT: {
                    alt5 = 3;
                }
                    break;
                case INVERSE_OBJECT_PROPERTY_EXPRESSION: {
                    alt5 = 4;
                }
                    break;
                default:
                    if (state.backtracking > 0) {
                        state.failed = true;
                        return retval;
                    }
                    NoViableAltException nvae = new NoViableAltException("", 5, 0, input);
                    throw nvae;
            }
            switch (alt5) {
                case 1:
                // /Users/luigi/Documents/workspace/Parsers/src/OPPLTypeEnforcement.g:206:4:
                // ^( DISJUNCTION (disjuncts+= conjunction )+ )
                {
                    match(input, DISJUNCTION, FOLLOW_DISJUNCTION_in_expression729);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.DOWN, null);
                    if (state.failed) {
                        return retval;
                    }
                    // /Users/luigi/Documents/workspace/Parsers/src/OPPLTypeEnforcement.g:206:29:
                    // (disjuncts+= conjunction )+
                    int cnt3 = 0;
                    loop3: do {
                        int alt3 = 2;
                        int LA3_0 = input.LA(1);
                        if (LA3_0 >= IDENTIFIER && LA3_0 <= ENTITY_REFERENCE
                            || LA3_0 == CONJUNCTION || LA3_0 == NEGATED_EXPRESSION
                            || LA3_0 >= SOME_RESTRICTION && LA3_0 <= ONE_OF
                            || LA3_0 == CONSTANT) {
                            alt3 = 1;
                        }
                        switch (alt3) {
                            case 1:
                            // /Users/luigi/Documents/workspace/Parsers/src/OPPLTypeEnforcement.g:206:29:
                            // disjuncts+= conjunction
                            {
                                pushFollow(FOLLOW_conjunction_in_expression735);
                                disjuncts = conjunction();
                                state._fsp--;
                                if (state.failed) {
                                    return retval;
                                }
                                list_disjuncts.add(disjuncts);
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
                    if (state.backtracking == 1) {
                        List<ManchesterOWLSyntaxTree> nodes = new ArrayList<>(
                            list_disjuncts.size());
                        for (Object node : list_disjuncts) {
                            nodes.add(((conjunction_return) node).node);
                        }
                        retval.type = getSymbolTable().getDisjunctionType(
                            (OPPLSyntaxTree) retval.start,
                            nodes.toArray(new ManchesterOWLSyntaxTree[nodes.size()]));
                        getTypesEnforcer().enforceDisjunctionTypes(
                            (OPPLSyntaxTree) retval.start,
                            nodes.toArray(new ManchesterOWLSyntaxTree[nodes.size()]));
                    }
                }
                    break;
                case 2:
                // /Users/luigi/Documents/workspace/Parsers/src/OPPLTypeEnforcement.g:215:6:
                // ^( PROPERTY_CHAIN (chainItems+= expression )+ )
                {
                    match(input, PROPERTY_CHAIN, FOLLOW_PROPERTY_CHAIN_in_expression751);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.DOWN, null);
                    if (state.failed) {
                        return retval;
                    }
                    // /Users/luigi/Documents/workspace/Parsers/src/OPPLTypeEnforcement.g:215:34:
                    // (chainItems+= expression )+
                    int cnt4 = 0;
                    loop4: do {
                        int alt4 = 2;
                        int LA4_0 = input.LA(1);
                        if (LA4_0 >= IDENTIFIER && LA4_0 <= ENTITY_REFERENCE
                            || LA4_0 >= DISJUNCTION && LA4_0 <= NEGATED_EXPRESSION
                            || LA4_0 >= SOME_RESTRICTION && LA4_0 <= ONE_OF
                            || LA4_0 == INVERSE_OBJECT_PROPERTY_EXPRESSION
                            || LA4_0 == CONSTANT) {
                            alt4 = 1;
                        }
                        switch (alt4) {
                            case 1:
                            // /Users/luigi/Documents/workspace/Parsers/src/OPPLTypeEnforcement.g:215:34:
                            // chainItems+= expression
                            {
                                pushFollow(FOLLOW_expression_in_expression756);
                                chainItems = expression();
                                state._fsp--;
                                if (state.failed) {
                                    return retval;
                                }
                                list_chainItems.add(chainItems);
                            }
                                break;
                            default:
                                if (cnt4 >= 1) {
                                    break loop4;
                                }
                                if (state.backtracking > 0) {
                                    state.failed = true;
                                    return retval;
                                }
                                EarlyExitException eee = new EarlyExitException(4, input);
                                throw eee;
                        }
                        cnt4++;
                    } while (true);
                    match(input, Token.UP, null);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 1) {
                        List<ManchesterOWLSyntaxTree> nodes = new ArrayList<>(
                            list_chainItems.size());
                        for (Object item : list_chainItems) {
                            nodes.add(((expression_return) item).node);
                        }
                        retval.type = getSymbolTable().getPropertyChainType(
                            (OPPLSyntaxTree) retval.start,
                            nodes.toArray(new ManchesterOWLSyntaxTree[nodes.size()]));
                        getTypesEnforcer().enforcePropertyChainTypes(
                            (OPPLSyntaxTree) retval.start,
                            nodes.toArray(new ManchesterOWLSyntaxTree[nodes.size()]));
                    }
                }
                    break;
                case 3:
                // /Users/luigi/Documents/workspace/Parsers/src/OPPLTypeEnforcement.g:224:5:
                // conjunction
                {
                    pushFollow(FOLLOW_conjunction_in_expression770);
                    conjunction3 = conjunction();
                    state._fsp--;
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 1) {
                        retval.type = conjunction3 != null ? conjunction3.type : null;
                    }
                }
                    break;
                case 4:
                // /Users/luigi/Documents/workspace/Parsers/src/OPPLTypeEnforcement.g:229:5:
                // complexPropertyExpression
                {
                    pushFollow(FOLLOW_complexPropertyExpression_in_expression782);
                    complexPropertyExpression4 = complexPropertyExpression();
                    state._fsp--;
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 1) {
                        retval.type = complexPropertyExpression4 != null ? complexPropertyExpression4.type
                            : null;
                    }
                }
                    break;
            }
            if (state.backtracking == 1) {
                ((OPPLSyntaxTree) retval.start).setEvalType(retval.type);
                retval.node = (OPPLSyntaxTree) retval.start;
            }
        } catch (RecognitionException exception) {
            if (errorListener != null) {
                errorListener.recognitionException(exception);
            }
        } catch (RewriteEmptyStreamException exception) {
            if (errorListener != null) {
                errorListener.rewriteEmptyStreamException(exception);
            }
        }
        return retval;
    }

    // $ANTLR end "expression"
    public static class conjunction_return extends TreeRuleReturnScope {

        public Type type;
        public ManchesterOWLSyntaxTree node;
    }

    // $ANTLR start "conjunction"
    // /Users/luigi/Documents/workspace/Parsers/src/OPPLTypeEnforcement.g:237:1:
    // conjunction returns [Type type, ManchesterOWLSyntaxTree node] : ( ^(
    // CONJUNCTION (conjuncts+= unary )+ ) | unary );
    public final OPPLTypeEnforcement.conjunction_return conjunction() {
        OPPLTypeEnforcement.conjunction_return retval = new OPPLTypeEnforcement.conjunction_return();
        retval.start = input.LT(1);
        List<Object> list_conjuncts = new ArrayList<>();
        OPPLTypeEnforcement.unary_return unary5 = null;
        RuleReturnScope conjuncts = null;
        try {
            // /Users/luigi/Documents/workspace/Parsers/src/OPPLTypeEnforcement.g:243:2:
            // ( ^( CONJUNCTION (conjuncts+= unary )+ ) | unary )
            int alt7 = 2;
            int LA7_0 = input.LA(1);
            if (LA7_0 == CONJUNCTION) {
                alt7 = 1;
            } else if (LA7_0 >= IDENTIFIER && LA7_0 <= ENTITY_REFERENCE
                || LA7_0 == NEGATED_EXPRESSION || LA7_0 >= SOME_RESTRICTION
                    && LA7_0 <= ONE_OF || LA7_0 == CONSTANT) {
                alt7 = 2;
            } else {
                if (state.backtracking > 0) {
                    state.failed = true;
                    return retval;
                }
                NoViableAltException nvae = new NoViableAltException("", 7, 0, input);
                throw nvae;
            }
            switch (alt7) {
                case 1:
                // /Users/luigi/Documents/workspace/Parsers/src/OPPLTypeEnforcement.g:244:2:
                // ^( CONJUNCTION (conjuncts+= unary )+ )
                {
                    match(input, CONJUNCTION, FOLLOW_CONJUNCTION_in_conjunction819);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.DOWN, null);
                    if (state.failed) {
                        return retval;
                    }
                    // /Users/luigi/Documents/workspace/Parsers/src/OPPLTypeEnforcement.g:244:26:
                    // (conjuncts+= unary )+
                    int cnt6 = 0;
                    loop6: do {
                        int alt6 = 2;
                        int LA6_0 = input.LA(1);
                        if (LA6_0 >= IDENTIFIER && LA6_0 <= ENTITY_REFERENCE
                            || LA6_0 == NEGATED_EXPRESSION
                            || LA6_0 >= SOME_RESTRICTION && LA6_0 <= ONE_OF
                            || LA6_0 == CONSTANT) {
                            alt6 = 1;
                        }
                        switch (alt6) {
                            case 1:
                            // /Users/luigi/Documents/workspace/Parsers/src/OPPLTypeEnforcement.g:244:26:
                            // conjuncts+= unary
                            {
                                pushFollow(FOLLOW_unary_in_conjunction824);
                                conjuncts = unary();
                                state._fsp--;
                                if (state.failed) {
                                    return retval;
                                }
                                list_conjuncts.add(conjuncts);
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
                                EarlyExitException eee = new EarlyExitException(6, input);
                                throw eee;
                        }
                        cnt6++;
                    } while (true);
                    match(input, Token.UP, null);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 1) {
                        List<ManchesterOWLSyntaxTree> nodes = new ArrayList<>(
                            list_conjuncts.size());
                        for (Object node : list_conjuncts) {
                            nodes.add(((unary_return) node).node);
                        }
                        retval.type = getSymbolTable().getConjunctionType(
                            (OPPLSyntaxTree) retval.start,
                            nodes.toArray(new ManchesterOWLSyntaxTree[nodes.size()]));
                        getTypesEnforcer().enforceConjunctionTypes(
                            (OPPLSyntaxTree) retval.start,
                            nodes.toArray(new ManchesterOWLSyntaxTree[nodes.size()]));
                    }
                }
                    break;
                case 2:
                // /Users/luigi/Documents/workspace/Parsers/src/OPPLTypeEnforcement.g:253:4:
                // unary
                {
                    pushFollow(FOLLOW_unary_in_conjunction835);
                    unary5 = unary();
                    state._fsp--;
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 1) {
                        retval.type = unary5 != null ? unary5.type : null;
                    }
                }
                    break;
            }
            if (state.backtracking == 1) {
                ((OPPLSyntaxTree) retval.start).setEvalType(retval.type);
                retval.node = (OPPLSyntaxTree) retval.start;
            }
        } catch (RecognitionException exception) {
            if (errorListener != null) {
                errorListener.recognitionException(exception);
            }
        } catch (RewriteEmptyStreamException exception) {
            if (errorListener != null) {
                errorListener.rewriteEmptyStreamException(exception);
            }
        }
        return retval;
    }

    // $ANTLR end "conjunction"
    public static class unary_return extends TreeRuleReturnScope {

        public Type type;
        public ManchesterOWLSyntaxTree node;
    }

    // $ANTLR start "unary"
    // /Users/luigi/Documents/workspace/Parsers/src/OPPLTypeEnforcement.g:259:1:
    // unary returns [Type type, ManchesterOWLSyntaxTree node] : ( IDENTIFIER |
    // ^( NEGATED_EXPRESSION e= expression ) | qualifiedRestriction |
    // ENTITY_REFERENCE | ^( CONSTANT value= . (constantType= IDENTIFIER )? ) );
    public final OPPLTypeEnforcement.unary_return unary() {
        OPPLTypeEnforcement.unary_return retval = new OPPLTypeEnforcement.unary_return();
        retval.start = input.LT(1);
        OPPLSyntaxTree IDENTIFIER6 = null;
        OPPLSyntaxTree ENTITY_REFERENCE8 = null;
        OPPLTypeEnforcement.expression_return e = null;
        OPPLTypeEnforcement.qualifiedRestriction_return qualifiedRestriction7 = null;
        try {
            // /Users/luigi/Documents/workspace/Parsers/src/OPPLTypeEnforcement.g:266:1:
            // ( IDENTIFIER | ^( NEGATED_EXPRESSION e= expression ) |
            // qualifiedRestriction | ENTITY_REFERENCE | ^( CONSTANT value= .
            // (constantType= IDENTIFIER )? ) )
            int alt9 = 5;
            switch (input.LA(1)) {
                case IDENTIFIER: {
                    alt9 = 1;
                }
                    break;
                case NEGATED_EXPRESSION: {
                    alt9 = 2;
                }
                    break;
                case SOME_RESTRICTION:
                case ALL_RESTRICTION:
                case VALUE_RESTRICTION:
                case CARDINALITY_RESTRICTION:
                case ONE_OF: {
                    alt9 = 3;
                }
                    break;
                case ENTITY_REFERENCE: {
                    alt9 = 4;
                }
                    break;
                case CONSTANT: {
                    alt9 = 5;
                }
                    break;
                default:
                    if (state.backtracking > 0) {
                        state.failed = true;
                        return retval;
                    }
                    NoViableAltException nvae = new NoViableAltException("", 9, 0, input);
                    throw nvae;
            }
            switch (alt9) {
                case 1:
                // /Users/luigi/Documents/workspace/Parsers/src/OPPLTypeEnforcement.g:267:3:
                // IDENTIFIER
                {
                    IDENTIFIER6 = (OPPLSyntaxTree) match(input, IDENTIFIER,
                        FOLLOW_IDENTIFIER_in_unary862);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 1) {
                        Symbol symbol = getSymbolTable().resolve(IDENTIFIER6);
                        retval.type = symbol == null ? null : symbol.getType();
                    }
                }
                    break;
                case 2:
                // /Users/luigi/Documents/workspace/Parsers/src/OPPLTypeEnforcement.g:273:5:
                // ^( NEGATED_EXPRESSION e= expression )
                {
                    match(input, NEGATED_EXPRESSION,
                        FOLLOW_NEGATED_EXPRESSION_in_unary875);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.DOWN, null);
                    if (state.failed) {
                        return retval;
                    }
                    pushFollow(FOLLOW_expression_in_unary881);
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
                        retval.type = getSymbolTable().getNegatedClassExpressionType(
                            (OPPLSyntaxTree) retval.start, e.node);
                        getTypesEnforcer().enforceNegatedClassExpression(
                            (OPPLSyntaxTree) retval.start, e.node);
                    }
                }
                    break;
                case 3:
                // /Users/luigi/Documents/workspace/Parsers/src/OPPLTypeEnforcement.g:278:5:
                // qualifiedRestriction
                {
                    pushFollow(FOLLOW_qualifiedRestriction_in_unary895);
                    qualifiedRestriction7 = qualifiedRestriction();
                    state._fsp--;
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 1) {
                        retval.type = qualifiedRestriction7 != null ? qualifiedRestriction7.type
                            : null;
                    }
                }
                    break;
                case 4:
                // /Users/luigi/Documents/workspace/Parsers/src/OPPLTypeEnforcement.g:283:5:
                // ENTITY_REFERENCE
                {
                    ENTITY_REFERENCE8 = (OPPLSyntaxTree) match(input, ENTITY_REFERENCE,
                        FOLLOW_ENTITY_REFERENCE_in_unary909);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 1) {
                        Symbol symbol = getSymbolTable().resolve(ENTITY_REFERENCE8);
                        retval.type = symbol == null ? null : symbol.getType();
                    }
                }
                    break;
                case 5:
                // /Users/luigi/Documents/workspace/Parsers/src/OPPLTypeEnforcement.g:289:5:
                // ^( CONSTANT value= . (constantType= IDENTIFIER )? )
                {
                    match(input, CONSTANT, FOLLOW_CONSTANT_in_unary922);
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
                    // /Users/luigi/Documents/workspace/Parsers/src/OPPLTypeEnforcement.g:289:38:
                    // (constantType= IDENTIFIER )?
                    int alt8 = 2;
                    int LA8_0 = input.LA(1);
                    if (LA8_0 == IDENTIFIER) {
                        alt8 = 1;
                    }
                    switch (alt8) {
                        case 1:
                        // /Users/luigi/Documents/workspace/Parsers/src/OPPLTypeEnforcement.g:289:38:
                        // constantType= IDENTIFIER
                        {
                            match(input, IDENTIFIER, FOLLOW_IDENTIFIER_in_unary933);
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
                        retval.type = OWLType.OWL_CONSTANT;
                    }
                }
                    break;
            }
            if (state.backtracking == 1) {
                ((OPPLSyntaxTree) retval.start).setEvalType(retval.type);
                retval.node = (OPPLSyntaxTree) retval.start;
            }
        } catch (RecognitionException exception) {
            if (errorListener != null) {
                errorListener.recognitionException(exception);
            }
        } catch (RewriteEmptyStreamException exception) {
            if (errorListener != null) {
                errorListener.rewriteEmptyStreamException(exception);
            }
        }
        return retval;
    }

    // $ANTLR end "unary"
    public static class propertyExpression_return extends TreeRuleReturnScope {

        public Type type;
        public ManchesterOWLSyntaxTree node;
    }

    // $ANTLR start "propertyExpression"
    // /Users/luigi/Documents/workspace/Parsers/src/OPPLTypeEnforcement.g:296:1:
    // propertyExpression returns [Type type, ManchesterOWLSyntaxTree node] : (
    // IDENTIFIER | complexPropertyExpression );
    public final OPPLTypeEnforcement.propertyExpression_return propertyExpression() {
        OPPLTypeEnforcement.propertyExpression_return retval = new OPPLTypeEnforcement.propertyExpression_return();
        retval.start = input.LT(1);
        OPPLSyntaxTree IDENTIFIER9 = null;
        OPPLTypeEnforcement.complexPropertyExpression_return complexPropertyExpression10 = null;
        try {
            // /Users/luigi/Documents/workspace/Parsers/src/OPPLTypeEnforcement.g:303:1:
            // ( IDENTIFIER | complexPropertyExpression )
            int alt10 = 2;
            int LA10_0 = input.LA(1);
            if (LA10_0 == IDENTIFIER) {
                alt10 = 1;
            } else if (LA10_0 == INVERSE_OBJECT_PROPERTY_EXPRESSION) {
                alt10 = 2;
            } else {
                if (state.backtracking > 0) {
                    state.failed = true;
                    return retval;
                }
                NoViableAltException nvae = new NoViableAltException("", 10, 0, input);
                throw nvae;
            }
            switch (alt10) {
                case 1:
                // /Users/luigi/Documents/workspace/Parsers/src/OPPLTypeEnforcement.g:304:7:
                // IDENTIFIER
                {
                    IDENTIFIER9 = (OPPLSyntaxTree) match(input, IDENTIFIER,
                        FOLLOW_IDENTIFIER_in_propertyExpression970);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 1) {
                        Symbol symbol = getSymbolTable().resolve(IDENTIFIER9);
                        retval.type = symbol == null ? null : symbol.getType();
                    }
                }
                    break;
                case 2:
                // /Users/luigi/Documents/workspace/Parsers/src/OPPLTypeEnforcement.g:310:7:
                // complexPropertyExpression
                {
                    pushFollow(FOLLOW_complexPropertyExpression_in_propertyExpression986);
                    complexPropertyExpression10 = complexPropertyExpression();
                    state._fsp--;
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 1) {
                        retval.type = complexPropertyExpression10 != null ? complexPropertyExpression10.type
                            : null;
                    }
                }
                    break;
            }
            if (state.backtracking == 1) {
                ((OPPLSyntaxTree) retval.start).setEvalType(retval.type);
                retval.node = (OPPLSyntaxTree) retval.start;
            }
        } catch (RecognitionException exception) {
            if (errorListener != null) {
                errorListener.recognitionException(exception);
            }
        } catch (RewriteEmptyStreamException exception) {
            if (errorListener != null) {
                errorListener.rewriteEmptyStreamException(exception);
            }
        }
        return retval;
    }

    // $ANTLR end "propertyExpression"
    public static class complexPropertyExpression_return extends TreeRuleReturnScope {

        public Type type;
        public ManchesterOWLSyntaxTree node;
    }

    // $ANTLR start "complexPropertyExpression"
    // /Users/luigi/Documents/workspace/Parsers/src/OPPLTypeEnforcement.g:317:1:
    // complexPropertyExpression returns [Type type, ManchesterOWLSyntaxTree
    // node] : ( ^( INVERSE_OBJECT_PROPERTY_EXPRESSION p=
    // complexPropertyExpression ) | ^( INVERSE_OBJECT_PROPERTY_EXPRESSION
    // IDENTIFIER ) );
    public final OPPLTypeEnforcement.complexPropertyExpression_return complexPropertyExpression() {
        OPPLTypeEnforcement.complexPropertyExpression_return retval = new OPPLTypeEnforcement.complexPropertyExpression_return();
        retval.start = input.LT(1);
        OPPLSyntaxTree IDENTIFIER11 = null;
        OPPLTypeEnforcement.complexPropertyExpression_return p = null;
        try {
            // /Users/luigi/Documents/workspace/Parsers/src/OPPLTypeEnforcement.g:323:1:
            // ( ^( INVERSE_OBJECT_PROPERTY_EXPRESSION p=
            // complexPropertyExpression ) | ^(
            // INVERSE_OBJECT_PROPERTY_EXPRESSION IDENTIFIER ) )
            int alt11 = 2;
            int LA11_0 = input.LA(1);
            if (LA11_0 == INVERSE_OBJECT_PROPERTY_EXPRESSION) {
                int LA11_1 = input.LA(2);
                if (LA11_1 == DOWN) {
                    int LA11_2 = input.LA(3);
                    if (LA11_2 == IDENTIFIER) {
                        alt11 = 2;
                    } else if (LA11_2 == INVERSE_OBJECT_PROPERTY_EXPRESSION) {
                        alt11 = 1;
                    } else {
                        if (state.backtracking > 0) {
                            state.failed = true;
                            return retval;
                        }
                        NoViableAltException nvae = new NoViableAltException("", 11, 2,
                            input);
                        throw nvae;
                    }
                } else {
                    if (state.backtracking > 0) {
                        state.failed = true;
                        return retval;
                    }
                    NoViableAltException nvae = new NoViableAltException("", 11, 1, input);
                    throw nvae;
                }
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
                // /Users/luigi/Documents/workspace/Parsers/src/OPPLTypeEnforcement.g:324:2:
                // ^( INVERSE_OBJECT_PROPERTY_EXPRESSION p=
                // complexPropertyExpression )
                {
                    match(input, INVERSE_OBJECT_PROPERTY_EXPRESSION,
                        FOLLOW_INVERSE_OBJECT_PROPERTY_EXPRESSION_in_complexPropertyExpression1019);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.DOWN, null);
                    if (state.failed) {
                        return retval;
                    }
                    pushFollow(FOLLOW_complexPropertyExpression_in_complexPropertyExpression1025);
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
                        retval.type = getSymbolTable().getInversePropertyType(
                            (OPPLSyntaxTree) retval.start, p.node);
                        getTypesEnforcer().enforceInverseObjectPropertyTypes(
                            (OPPLSyntaxTree) retval.start, p.node);
                    }
                }
                    break;
                case 2:
                // /Users/luigi/Documents/workspace/Parsers/src/OPPLTypeEnforcement.g:329:4:
                // ^( INVERSE_OBJECT_PROPERTY_EXPRESSION IDENTIFIER )
                {
                    match(input, INVERSE_OBJECT_PROPERTY_EXPRESSION,
                        FOLLOW_INVERSE_OBJECT_PROPERTY_EXPRESSION_in_complexPropertyExpression1035);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.DOWN, null);
                    if (state.failed) {
                        return retval;
                    }
                    IDENTIFIER11 = (OPPLSyntaxTree) match(input, IDENTIFIER,
                        FOLLOW_IDENTIFIER_in_complexPropertyExpression1037);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.UP, null);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 1) {
                        getSymbolTable().resolve(IDENTIFIER11);
                        retval.type = getSymbolTable().getInversePropertyType(
                            (OPPLSyntaxTree) retval.start, IDENTIFIER11);
                        getTypesEnforcer().enforceInverseObjectPropertyTypes(
                            (OPPLSyntaxTree) retval.start, IDENTIFIER11);
                    }
                }
                    break;
            }
            if (state.backtracking == 1) {
                ((OPPLSyntaxTree) retval.start).setEvalType(retval.type);
                retval.node = (OPPLSyntaxTree) retval.start;
            }
        } catch (RecognitionException exception) {
            if (errorListener != null) {
                errorListener.recognitionException(exception);
            }
        } catch (RewriteEmptyStreamException exception) {
            if (errorListener != null) {
                errorListener.rewriteEmptyStreamException(exception);
            }
        }
        return retval;
    }

    // $ANTLR end "complexPropertyExpression"
    public static class qualifiedRestriction_return extends TreeRuleReturnScope {

        public Type type;
        public ManchesterOWLSyntaxTree node;
    }

    // $ANTLR start "qualifiedRestriction"
    // /Users/luigi/Documents/workspace/Parsers/src/OPPLTypeEnforcement.g:337:1:
    // qualifiedRestriction returns [Type type , ManchesterOWLSyntaxTree node] :
    // ( ^( SOME_RESTRICTION p= propertyExpression f= expression ) | ^(
    // ALL_RESTRICTION p= propertyExpression f= expression ) |
    // cardinalityRestriction | oneOf | valueRestriction );
    public final OPPLTypeEnforcement.qualifiedRestriction_return qualifiedRestriction() {
        OPPLTypeEnforcement.qualifiedRestriction_return retval = new OPPLTypeEnforcement.qualifiedRestriction_return();
        retval.start = input.LT(1);
        OPPLTypeEnforcement.propertyExpression_return p = null;
        OPPLTypeEnforcement.expression_return f = null;
        OPPLTypeEnforcement.cardinalityRestriction_return cardinalityRestriction12 = null;
        OPPLTypeEnforcement.oneOf_return oneOf13 = null;
        OPPLTypeEnforcement.valueRestriction_return valueRestriction14 = null;
        try {
            // /Users/luigi/Documents/workspace/Parsers/src/OPPLTypeEnforcement.g:342:2:
            // ( ^( SOME_RESTRICTION p= propertyExpression f= expression ) | ^(
            // ALL_RESTRICTION p= propertyExpression f= expression ) |
            // cardinalityRestriction | oneOf | valueRestriction )
            int alt12 = 5;
            switch (input.LA(1)) {
                case SOME_RESTRICTION: {
                    alt12 = 1;
                }
                    break;
                case ALL_RESTRICTION: {
                    alt12 = 2;
                }
                    break;
                case CARDINALITY_RESTRICTION: {
                    alt12 = 3;
                }
                    break;
                case ONE_OF: {
                    alt12 = 4;
                }
                    break;
                case VALUE_RESTRICTION: {
                    alt12 = 5;
                }
                    break;
                default:
                    if (state.backtracking > 0) {
                        state.failed = true;
                        return retval;
                    }
                    NoViableAltException nvae = new NoViableAltException("", 12, 0, input);
                    throw nvae;
            }
            switch (alt12) {
                case 1:
                // /Users/luigi/Documents/workspace/Parsers/src/OPPLTypeEnforcement.g:343:6:
                // ^( SOME_RESTRICTION p= propertyExpression f= expression )
                {
                    match(input, SOME_RESTRICTION,
                        FOLLOW_SOME_RESTRICTION_in_qualifiedRestriction1068);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.DOWN, null);
                    if (state.failed) {
                        return retval;
                    }
                    pushFollow(FOLLOW_propertyExpression_in_qualifiedRestriction1073);
                    p = propertyExpression();
                    state._fsp--;
                    if (state.failed) {
                        return retval;
                    }
                    pushFollow(FOLLOW_expression_in_qualifiedRestriction1079);
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
                        retval.type = getSymbolTable().getSomeValueRestrictionType(
                            (OPPLSyntaxTree) retval.start, p.node, f.node);
                        getTypesEnforcer().enforceSomeValueRestrictionTypes(
                            (OPPLSyntaxTree) retval.start, p.node, f.node);
                    }
                }
                    break;
                case 2:
                // /Users/luigi/Documents/workspace/Parsers/src/OPPLTypeEnforcement.g:348:7:
                // ^( ALL_RESTRICTION p= propertyExpression f= expression )
                {
                    match(input, ALL_RESTRICTION,
                        FOLLOW_ALL_RESTRICTION_in_qualifiedRestriction1101);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.DOWN, null);
                    if (state.failed) {
                        return retval;
                    }
                    pushFollow(FOLLOW_propertyExpression_in_qualifiedRestriction1108);
                    p = propertyExpression();
                    state._fsp--;
                    if (state.failed) {
                        return retval;
                    }
                    pushFollow(FOLLOW_expression_in_qualifiedRestriction1113);
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
                        retval.type = getSymbolTable().getAllValueRestrictionType(
                            (OPPLSyntaxTree) retval.start, p.node, f.node);
                        getTypesEnforcer().enforceAllValueRestrictionTypes(
                            (OPPLSyntaxTree) retval.start, p.node, f.node);
                    }
                }
                    break;
                case 3:
                // /Users/luigi/Documents/workspace/Parsers/src/OPPLTypeEnforcement.g:353:7:
                // cardinalityRestriction
                {
                    pushFollow(FOLLOW_cardinalityRestriction_in_qualifiedRestriction1129);
                    cardinalityRestriction12 = cardinalityRestriction();
                    state._fsp--;
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 1) {
                        retval.type = cardinalityRestriction12 != null ? cardinalityRestriction12.type
                            : null;
                    }
                }
                    break;
                case 4:
                // /Users/luigi/Documents/workspace/Parsers/src/OPPLTypeEnforcement.g:357:7:
                // oneOf
                {
                    pushFollow(FOLLOW_oneOf_in_qualifiedRestriction1145);
                    oneOf13 = oneOf();
                    state._fsp--;
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 1) {
                        retval.type = oneOf13 != null ? oneOf13.type : null;
                    }
                }
                    break;
                case 5:
                // /Users/luigi/Documents/workspace/Parsers/src/OPPLTypeEnforcement.g:361:7:
                // valueRestriction
                {
                    pushFollow(FOLLOW_valueRestriction_in_qualifiedRestriction1161);
                    valueRestriction14 = valueRestriction();
                    state._fsp--;
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 1) {
                        retval.type = valueRestriction14 != null ? valueRestriction14.type
                            : null;
                    }
                }
                    break;
            }
            if (state.backtracking == 1) {
                ((OPPLSyntaxTree) retval.start).setEvalType(retval.type);
                retval.node = (OPPLSyntaxTree) retval.start;
            }
        } catch (RecognitionException exception) {
            if (errorListener != null) {
                errorListener.recognitionException(exception);
            }
        } catch (RewriteEmptyStreamException exception) {
            if (errorListener != null) {
                errorListener.rewriteEmptyStreamException(exception);
            }
        }
        return retval;
    }

    // $ANTLR end "qualifiedRestriction"
    public static class cardinalityRestriction_return extends TreeRuleReturnScope {

        public Type type;
        public ManchesterOWLSyntaxTree node;
    }

    // $ANTLR start "cardinalityRestriction"
    // /Users/luigi/Documents/workspace/Parsers/src/OPPLTypeEnforcement.g:369:1:
    // cardinalityRestriction returns [Type type , ManchesterOWLSyntaxTree node]
    // : ( ^( CARDINALITY_RESTRICTION MIN i= INTEGER p= unary (filler=
    // expression )? ) | ^( CARDINALITY_RESTRICTION MAX i= INTEGER p= unary
    // (filler= expression )? ) | ^( CARDINALITY_RESTRICTION EXACTLY i= INTEGER
    // p= unary (filler= expression )? ) );
    public final OPPLTypeEnforcement.cardinalityRestriction_return cardinalityRestriction() {
        OPPLTypeEnforcement.cardinalityRestriction_return retval = new OPPLTypeEnforcement.cardinalityRestriction_return();
        retval.start = input.LT(1);
        OPPLSyntaxTree i = null;
        OPPLTypeEnforcement.unary_return p = null;
        OPPLTypeEnforcement.expression_return filler = null;
        try {
            // /Users/luigi/Documents/workspace/Parsers/src/OPPLTypeEnforcement.g:374:1:
            // ( ^( CARDINALITY_RESTRICTION MIN i= INTEGER p= unary (filler=
            // expression )? ) | ^( CARDINALITY_RESTRICTION MAX i= INTEGER p=
            // unary (filler= expression )? ) | ^( CARDINALITY_RESTRICTION
            // EXACTLY i= INTEGER p= unary (filler= expression )? ) )
            int alt16 = 3;
            int LA16_0 = input.LA(1);
            if (LA16_0 == CARDINALITY_RESTRICTION) {
                int LA16_1 = input.LA(2);
                if (LA16_1 == DOWN) {
                    switch (input.LA(3)) {
                        case MIN: {
                            alt16 = 1;
                        }
                            break;
                        case MAX: {
                            alt16 = 2;
                        }
                            break;
                        case EXACTLY: {
                            alt16 = 3;
                        }
                            break;
                        default:
                            if (state.backtracking > 0) {
                                state.failed = true;
                                return retval;
                            }
                            NoViableAltException nvae = new NoViableAltException("", 16,
                                2, input);
                            throw nvae;
                    }
                } else {
                    if (state.backtracking > 0) {
                        state.failed = true;
                        return retval;
                    }
                    NoViableAltException nvae = new NoViableAltException("", 16, 1, input);
                    throw nvae;
                }
            } else {
                if (state.backtracking > 0) {
                    state.failed = true;
                    return retval;
                }
                NoViableAltException nvae = new NoViableAltException("", 16, 0, input);
                throw nvae;
            }
            switch (alt16) {
                case 1:
                // /Users/luigi/Documents/workspace/Parsers/src/OPPLTypeEnforcement.g:375:5:
                // ^( CARDINALITY_RESTRICTION MIN i= INTEGER p= unary (filler=
                // expression )? )
                {
                    match(input, CARDINALITY_RESTRICTION,
                        FOLLOW_CARDINALITY_RESTRICTION_in_cardinalityRestriction1198);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.DOWN, null);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, MIN, FOLLOW_MIN_in_cardinalityRestriction1201);
                    if (state.failed) {
                        return retval;
                    }
                    i = (OPPLSyntaxTree) match(input, INTEGER,
                        FOLLOW_INTEGER_in_cardinalityRestriction1206);
                    if (state.failed) {
                        return retval;
                    }
                    pushFollow(FOLLOW_unary_in_cardinalityRestriction1212);
                    p = unary();
                    state._fsp--;
                    if (state.failed) {
                        return retval;
                    }
                    // /Users/luigi/Documents/workspace/Parsers/src/OPPLTypeEnforcement.g:375:65:
                    // (filler= expression )?
                    int alt13 = 2;
                    int LA13_0 = input.LA(1);
                    if (LA13_0 >= IDENTIFIER && LA13_0 <= ENTITY_REFERENCE
                        || LA13_0 >= DISJUNCTION && LA13_0 <= NEGATED_EXPRESSION
                        || LA13_0 >= SOME_RESTRICTION && LA13_0 <= ONE_OF
                        || LA13_0 == INVERSE_OBJECT_PROPERTY_EXPRESSION
                        || LA13_0 == CONSTANT) {
                        alt13 = 1;
                    }
                    switch (alt13) {
                        case 1:
                        // /Users/luigi/Documents/workspace/Parsers/src/OPPLTypeEnforcement.g:375:65:
                        // filler= expression
                        {
                            pushFollow(FOLLOW_expression_in_cardinalityRestriction1219);
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
                        retval.type = getSymbolTable().getMinCardinalityRestrictionType(
                            (OPPLSyntaxTree) retval.start, p.node,
                            filler == null ? null : filler.node);
                        int cardinality = Integer.parseInt(i.token.getText());
                        getTypesEnforcer().enforceMinCardinalityRestrictionTypes(
                            (OPPLSyntaxTree) retval.start, p.node,
                            filler == null ? null : filler.node);
                    }
                }
                    break;
                case 2:
                // /Users/luigi/Documents/workspace/Parsers/src/OPPLTypeEnforcement.g:382:6:
                // ^( CARDINALITY_RESTRICTION MAX i= INTEGER p= unary (filler=
                // expression )? )
                {
                    match(input, CARDINALITY_RESTRICTION,
                        FOLLOW_CARDINALITY_RESTRICTION_in_cardinalityRestriction1234);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.DOWN, null);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, MAX, FOLLOW_MAX_in_cardinalityRestriction1237);
                    if (state.failed) {
                        return retval;
                    }
                    i = (OPPLSyntaxTree) match(input, INTEGER,
                        FOLLOW_INTEGER_in_cardinalityRestriction1241);
                    if (state.failed) {
                        return retval;
                    }
                    pushFollow(FOLLOW_unary_in_cardinalityRestriction1247);
                    p = unary();
                    state._fsp--;
                    if (state.failed) {
                        return retval;
                    }
                    // /Users/luigi/Documents/workspace/Parsers/src/OPPLTypeEnforcement.g:382:65:
                    // (filler= expression )?
                    int alt14 = 2;
                    int LA14_0 = input.LA(1);
                    if (LA14_0 >= IDENTIFIER && LA14_0 <= ENTITY_REFERENCE
                        || LA14_0 >= DISJUNCTION && LA14_0 <= NEGATED_EXPRESSION
                        || LA14_0 >= SOME_RESTRICTION && LA14_0 <= ONE_OF
                        || LA14_0 == INVERSE_OBJECT_PROPERTY_EXPRESSION
                        || LA14_0 == CONSTANT) {
                        alt14 = 1;
                    }
                    switch (alt14) {
                        case 1:
                        // /Users/luigi/Documents/workspace/Parsers/src/OPPLTypeEnforcement.g:382:65:
                        // filler= expression
                        {
                            pushFollow(FOLLOW_expression_in_cardinalityRestriction1254);
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
                        retval.type = getSymbolTable().getMaxCardinalityRestrictionType(
                            (OPPLSyntaxTree) retval.start, p.node,
                            filler == null ? null : filler.node);
                        int cardinality = Integer.parseInt(i.token.getText());
                        getTypesEnforcer().enforceMaxCardinalityRestrictionTypes(
                            (OPPLSyntaxTree) retval.start, p.node,
                            filler == null ? null : filler.node);
                    }
                }
                    break;
                case 3:
                // /Users/luigi/Documents/workspace/Parsers/src/OPPLTypeEnforcement.g:388:8:
                // ^( CARDINALITY_RESTRICTION EXACTLY i= INTEGER p= unary
                // (filler= expression )? )
                {
                    match(input, CARDINALITY_RESTRICTION,
                        FOLLOW_CARDINALITY_RESTRICTION_in_cardinalityRestriction1273);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.DOWN, null);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, EXACTLY, FOLLOW_EXACTLY_in_cardinalityRestriction1276);
                    if (state.failed) {
                        return retval;
                    }
                    i = (OPPLSyntaxTree) match(input, INTEGER,
                        FOLLOW_INTEGER_in_cardinalityRestriction1281);
                    if (state.failed) {
                        return retval;
                    }
                    pushFollow(FOLLOW_unary_in_cardinalityRestriction1288);
                    p = unary();
                    state._fsp--;
                    if (state.failed) {
                        return retval;
                    }
                    // /Users/luigi/Documents/workspace/Parsers/src/OPPLTypeEnforcement.g:388:73:
                    // (filler= expression )?
                    int alt15 = 2;
                    int LA15_0 = input.LA(1);
                    if (LA15_0 >= IDENTIFIER && LA15_0 <= ENTITY_REFERENCE
                        || LA15_0 >= DISJUNCTION && LA15_0 <= NEGATED_EXPRESSION
                        || LA15_0 >= SOME_RESTRICTION && LA15_0 <= ONE_OF
                        || LA15_0 == INVERSE_OBJECT_PROPERTY_EXPRESSION
                        || LA15_0 == CONSTANT) {
                        alt15 = 1;
                    }
                    switch (alt15) {
                        case 1:
                        // /Users/luigi/Documents/workspace/Parsers/src/OPPLTypeEnforcement.g:388:73:
                        // filler= expression
                        {
                            pushFollow(FOLLOW_expression_in_cardinalityRestriction1295);
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
                        retval.type = getSymbolTable()
                            .getExactCardinalityRestrictionType(
                                (OPPLSyntaxTree) retval.start, p.node,
                                filler == null ? null : filler.node);
                        int cardinality = Integer.parseInt(i.token.getText());
                        getTypesEnforcer().enforceExactCardinalityRestrictionTypes(
                            (OPPLSyntaxTree) retval.start, p.node,
                            filler == null ? null : filler.node);
                    }
                }
                    break;
            }
            if (state.backtracking == 1) {
                ((OPPLSyntaxTree) retval.start).setEvalType(retval.type);
                retval.node = (OPPLSyntaxTree) retval.start;
            }
        } catch (RecognitionException exception) {
            if (errorListener != null) {
                errorListener.recognitionException(exception);
            }
        } catch (RewriteEmptyStreamException exception) {
            if (errorListener != null) {
                errorListener.rewriteEmptyStreamException(exception);
            }
        }
        return retval;
    }

    // $ANTLR end "cardinalityRestriction"
    public static class oneOf_return extends TreeRuleReturnScope {

        public Type type;
        public ManchesterOWLSyntaxTree node;
    }

    // $ANTLR start "oneOf"
    // /Users/luigi/Documents/workspace/Parsers/src/OPPLTypeEnforcement.g:396:1:
    // oneOf returns [Type type , ManchesterOWLSyntaxTree node] : ^( ONE_OF
    // (individuals+= IDENTIFIER )+ ) ;
    public final OPPLTypeEnforcement.oneOf_return oneOf() {
        OPPLTypeEnforcement.oneOf_return retval = new OPPLTypeEnforcement.oneOf_return();
        retval.start = input.LT(1);
        OPPLSyntaxTree individuals = null;
        List<Object> list_individuals = new ArrayList<>();
        try {
            // /Users/luigi/Documents/workspace/Parsers/src/OPPLTypeEnforcement.g:401:2:
            // ( ^( ONE_OF (individuals+= IDENTIFIER )+ ) )
            // /Users/luigi/Documents/workspace/Parsers/src/OPPLTypeEnforcement.g:402:3:
            // ^( ONE_OF (individuals+= IDENTIFIER )+ )
            {
                match(input, ONE_OF, FOLLOW_ONE_OF_in_oneOf1330);
                if (state.failed) {
                    return retval;
                }
                match(input, Token.DOWN, null);
                if (state.failed) {
                    return retval;
                }
                // /Users/luigi/Documents/workspace/Parsers/src/OPPLTypeEnforcement.g:402:23:
                // (individuals+= IDENTIFIER )+
                int cnt17 = 0;
                loop17: do {
                    int alt17 = 2;
                    int LA17_0 = input.LA(1);
                    if (LA17_0 == IDENTIFIER) {
                        alt17 = 1;
                    }
                    switch (alt17) {
                        case 1:
                        // /Users/luigi/Documents/workspace/Parsers/src/OPPLTypeEnforcement.g:402:23:
                        // individuals+= IDENTIFIER
                        {
                            individuals = (OPPLSyntaxTree) match(input, IDENTIFIER,
                                FOLLOW_IDENTIFIER_in_oneOf1334);
                            if (state.failed) {
                                return retval;
                            }
                            list_individuals.add(individuals);
                        }
                            break;
                        default:
                            if (cnt17 >= 1) {
                                break loop17;
                            }
                            if (state.backtracking > 0) {
                                state.failed = true;
                                return retval;
                            }
                            EarlyExitException eee = new EarlyExitException(17, input);
                            throw eee;
                    }
                    cnt17++;
                } while (true);
                match(input, Token.UP, null);
                if (state.failed) {
                    return retval;
                }
                if (state.backtracking == 1) {
                    List<ManchesterOWLSyntaxTree> nodes = new ArrayList<>(
                        list_individuals.size());
                    for (Object node : list_individuals) {
                        nodes.add((ManchesterOWLSyntaxTree) node);
                    }
                    retval.type = getSymbolTable().getOneOfType(
                        (OPPLSyntaxTree) retval.start,
                        nodes.toArray(new ManchesterOWLSyntaxTree[nodes.size()]));
                    getTypesEnforcer().enforceOneOfTypes((OPPLSyntaxTree) retval.start,
                        nodes.toArray(new ManchesterOWLSyntaxTree[nodes.size()]));
                }
            }
            if (state.backtracking == 1) {
                ((OPPLSyntaxTree) retval.start).setEvalType(retval.type);
                retval.node = (OPPLSyntaxTree) retval.start;
            }
        } catch (RecognitionException exception) {
            if (errorListener != null) {
                errorListener.recognitionException(exception);
            }
        } catch (RewriteEmptyStreamException exception) {
            if (errorListener != null) {
                errorListener.rewriteEmptyStreamException(exception);
            }
        }
        return retval;
    }

    // $ANTLR end "oneOf"
    public static class valueRestriction_return extends TreeRuleReturnScope {

        public Type type;
        public ManchesterOWLSyntaxTree node;
    }

    // $ANTLR start "valueRestriction"
    // /Users/luigi/Documents/workspace/Parsers/src/OPPLTypeEnforcement.g:413:1:
    // valueRestriction returns [Type type , ManchesterOWLSyntaxTree node] : ^(
    // VALUE_RESTRICTION p= unary value= unary ) ;
    public final OPPLTypeEnforcement.valueRestriction_return valueRestriction() {
        OPPLTypeEnforcement.valueRestriction_return retval = new OPPLTypeEnforcement.valueRestriction_return();
        retval.start = input.LT(1);
        OPPLTypeEnforcement.unary_return p = null;
        OPPLTypeEnforcement.unary_return value = null;
        try {
            // /Users/luigi/Documents/workspace/Parsers/src/OPPLTypeEnforcement.g:418:2:
            // ( ^( VALUE_RESTRICTION p= unary value= unary ) )
            // /Users/luigi/Documents/workspace/Parsers/src/OPPLTypeEnforcement.g:419:3:
            // ^( VALUE_RESTRICTION p= unary value= unary )
            {
                match(input, VALUE_RESTRICTION,
                    FOLLOW_VALUE_RESTRICTION_in_valueRestriction1367);
                if (state.failed) {
                    return retval;
                }
                match(input, Token.DOWN, null);
                if (state.failed) {
                    return retval;
                }
                pushFollow(FOLLOW_unary_in_valueRestriction1374);
                p = unary();
                state._fsp--;
                if (state.failed) {
                    return retval;
                }
                pushFollow(FOLLOW_unary_in_valueRestriction1381);
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
                    retval.type = getSymbolTable().getValueRestrictionType(
                        (OPPLSyntaxTree) retval.start, p.node, value.node);
                    getTypesEnforcer().enforceValueRestrictionTypes(
                        (OPPLSyntaxTree) retval.start, p.node, value.node);
                }
            }
            if (state.backtracking == 1) {
                ((OPPLSyntaxTree) retval.start).setEvalType(retval.type);
                retval.node = (OPPLSyntaxTree) retval.start;
            }
        } catch (RecognitionException exception) {
            if (errorListener != null) {
                errorListener.recognitionException(exception);
            }
        } catch (RewriteEmptyStreamException exception) {
            if (errorListener != null) {
                errorListener.rewriteEmptyStreamException(exception);
            }
        }
        return retval;
    }

    // $ANTLR end "valueRestriction"
    // Delegated rules
    protected DFA2 dfa2 = new DFA2(this);
    static final String DFA2_eotS = "\25\uffff";
    static final String DFA2_eofS = "\25\uffff";
    static final String DFA2_minS = "\1\31\13\uffff\1\2\1\uffff\1\35\6\uffff";
    static final String DFA2_maxS = "\1\103\13\uffff\1\2\1\uffff\1\43\6\uffff";
    static final String DFA2_acceptS = "\1\uffff\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\13\1\uffff"
        + "\1\22\1\uffff\1\14\1\15\1\16\1\17\1\20\1\21";
    static final String DFA2_specialS = "\25\uffff}>";
    static final String[] DFA2_transitionS = {
        "\1\3\1\uffff\1\10\1\11\23\uffff\1\1\1\2\1\4\1\5\1\12\1\13\1"
            + "\14\4\uffff\1\15\6\uffff\1\7\1\6", "", "", "", "", "", "", "", "",
        "", "", "", "\1\16", "", "\1\17\1\23\1\uffff\1\22\1\21\1\24\1\20", "", "",
        "", "", "", "" };
    static final short[] DFA2_eot = DFA.unpackEncodedString(DFA2_eotS);
    static final short[] DFA2_eof = DFA.unpackEncodedString(DFA2_eofS);
    static final char[] DFA2_min = DFA.unpackEncodedStringToUnsignedChars(DFA2_minS);
    static final char[] DFA2_max = DFA.unpackEncodedStringToUnsignedChars(DFA2_maxS);
    static final short[] DFA2_accept = DFA.unpackEncodedString(DFA2_acceptS);
    static final short[] DFA2_special = DFA.unpackEncodedString(DFA2_specialS);
    static final short[][] DFA2_transition;

    static {
        int numStates = DFA2_transitionS.length;
        DFA2_transition = new short[numStates][];
        for (int i = 0; i < numStates; i++) {
            DFA2_transition[i] = DFA.unpackEncodedString(DFA2_transitionS[i]);
        }
    }

    class DFA2 extends DFA {

        public DFA2(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            decisionNumber = 2;
            eot = DFA2_eot;
            eof = DFA2_eof;
            min = DFA2_min;
            max = DFA2_max;
            accept = DFA2_accept;
            special = DFA2_special;
            transition = DFA2_transition;
        }

        @Override
        public String getDescription() {
            return "102:1: axiom returns [Type type, ManchesterOWLSyntaxTree node] : ( ^( SUB_CLASS_AXIOM ^( EXPRESSION subClass= expression ) ^( EXPRESSION superClass= expression ) ) | ^( EQUIVALENT_TO_AXIOM ^( EXPRESSION lhs= expression ) ^( EXPRESSION rhs= expression ) ) | ^( INVERSE_OF ^( EXPRESSION p= IDENTIFIER ) ^( EXPRESSION anotherProperty= IDENTIFIER ) ) | ^( DISJOINT_WITH_AXIOM ^( EXPRESSION lhs= expression ) ^( EXPRESSION rhs= expression ) ) | ^( SUB_PROPERTY_AXIOM ^( EXPRESSION subProperty= expression ) ^( EXPRESSION superProperty= unary ) ) | ^( ROLE_ASSERTION ^( EXPRESSION subject= IDENTIFIER ) ^( EXPRESSION predicate= propertyExpression ) ^( EXPRESSION object= unary ) ) | ^( TYPE_ASSERTION ^( EXPRESSION description= expression ) ^( EXPRESSION subject= IDENTIFIER ) ) | ^( DOMAIN ^( EXPRESSION p= IDENTIFIER ) ^( EXPRESSION domain= expression ) ) | ^( RANGE ^( EXPRESSION p= IDENTIFIER ) ^( EXPRESSION range= expression ) ) | ^( SAME_AS_AXIOM ^( EXPRESSION anIndividual= IDENTIFIER ) ^( EXPRESSION anotherIndividual= IDENTIFIER ) ) | ^( DIFFERENT_FROM_AXIOM ^( EXPRESSION anIndividual= IDENTIFIER ) ^( EXPRESSION anotherIndividual= IDENTIFIER ) ) | ^( UNARY_AXIOM FUNCTIONAL ^( EXPRESSION p= IDENTIFIER ) ) | ^( UNARY_AXIOM INVERSE_FUNCTIONAL ^( EXPRESSION p= IDENTIFIER ) ) | ^( UNARY_AXIOM IRREFLEXIVE ^( EXPRESSION p= IDENTIFIER ) ) | ^( UNARY_AXIOM REFLEXIVE ^( EXPRESSION p= IDENTIFIER ) ) | ^( UNARY_AXIOM SYMMETRIC ^( EXPRESSION p= IDENTIFIER ) ) | ^( UNARY_AXIOM TRANSITIVE ^( EXPRESSION p= IDENTIFIER ) ) | ^( NEGATED_ASSERTION a= axiom ) );";
        }
    }

    public static final BitSet FOLLOW_expressionRoot_in_bottomup81 = new BitSet(
        new long[] { 0x0000000000000002L });
    public static final BitSet FOLLOW_axiom_in_bottomup91 = new BitSet(
        new long[] { 0x0000000000000002L });
    public static final BitSet FOLLOW_EXPRESSION_in_expressionRoot118 = new BitSet(
        new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_expression_in_expressionRoot120 = new BitSet(
        new long[] { 0x0000000000000008L });
    public static final BitSet FOLLOW_SUB_CLASS_AXIOM_in_axiom158 = new BitSet(
        new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_EXPRESSION_in_axiom162 = new BitSet(
        new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_expression_in_axiom169 = new BitSet(
        new long[] { 0x0000000000000008L });
    public static final BitSet FOLLOW_EXPRESSION_in_axiom174 = new BitSet(
        new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_expression_in_axiom181 = new BitSet(
        new long[] { 0x0000000000000008L });
    public static final BitSet FOLLOW_EQUIVALENT_TO_AXIOM_in_axiom194 = new BitSet(
        new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_EXPRESSION_in_axiom197 = new BitSet(
        new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_expression_in_axiom203 = new BitSet(
        new long[] { 0x0000000000000008L });
    public static final BitSet FOLLOW_EXPRESSION_in_axiom207 = new BitSet(
        new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_expression_in_axiom214 = new BitSet(
        new long[] { 0x0000000000000008L });
    public static final BitSet FOLLOW_INVERSE_OF_in_axiom229 = new BitSet(
        new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_EXPRESSION_in_axiom232 = new BitSet(
        new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_IDENTIFIER_in_axiom238 = new BitSet(
        new long[] { 0x0000000000000008L });
    public static final BitSet FOLLOW_EXPRESSION_in_axiom242 = new BitSet(
        new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_IDENTIFIER_in_axiom248 = new BitSet(
        new long[] { 0x0000000000000008L });
    public static final BitSet FOLLOW_DISJOINT_WITH_AXIOM_in_axiom260 = new BitSet(
        new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_EXPRESSION_in_axiom263 = new BitSet(
        new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_expression_in_axiom270 = new BitSet(
        new long[] { 0x0000000000000008L });
    public static final BitSet FOLLOW_EXPRESSION_in_axiom274 = new BitSet(
        new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_expression_in_axiom280 = new BitSet(
        new long[] { 0x0000000000000008L });
    public static final BitSet FOLLOW_SUB_PROPERTY_AXIOM_in_axiom292 = new BitSet(
        new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_EXPRESSION_in_axiom295 = new BitSet(
        new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_expression_in_axiom302 = new BitSet(
        new long[] { 0x0000000000000008L });
    public static final BitSet FOLLOW_EXPRESSION_in_axiom306 = new BitSet(
        new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_unary_in_axiom312 = new BitSet(
        new long[] { 0x0000000000000008L });
    public static final BitSet FOLLOW_ROLE_ASSERTION_in_axiom326 = new BitSet(
        new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_EXPRESSION_in_axiom329 = new BitSet(
        new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_IDENTIFIER_in_axiom336 = new BitSet(
        new long[] { 0x0000000000000008L });
    public static final BitSet FOLLOW_EXPRESSION_in_axiom340 = new BitSet(
        new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_propertyExpression_in_axiom347 = new BitSet(
        new long[] { 0x0000000000000008L });
    public static final BitSet FOLLOW_EXPRESSION_in_axiom351 = new BitSet(
        new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_unary_in_axiom357 = new BitSet(
        new long[] { 0x0000000000000008L });
    public static final BitSet FOLLOW_TYPE_ASSERTION_in_axiom367 = new BitSet(
        new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_EXPRESSION_in_axiom370 = new BitSet(
        new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_expression_in_axiom377 = new BitSet(
        new long[] { 0x0000000000000008L });
    public static final BitSet FOLLOW_EXPRESSION_in_axiom381 = new BitSet(
        new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_IDENTIFIER_in_axiom387 = new BitSet(
        new long[] { 0x0000000000000008L });
    public static final BitSet FOLLOW_DOMAIN_in_axiom399 = new BitSet(
        new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_EXPRESSION_in_axiom402 = new BitSet(
        new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_IDENTIFIER_in_axiom408 = new BitSet(
        new long[] { 0x0000000000000008L });
    public static final BitSet FOLLOW_EXPRESSION_in_axiom412 = new BitSet(
        new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_expression_in_axiom418 = new BitSet(
        new long[] { 0x0000000000000008L });
    public static final BitSet FOLLOW_RANGE_in_axiom431 = new BitSet(
        new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_EXPRESSION_in_axiom434 = new BitSet(
        new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_IDENTIFIER_in_axiom440 = new BitSet(
        new long[] { 0x0000000000000008L });
    public static final BitSet FOLLOW_EXPRESSION_in_axiom444 = new BitSet(
        new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_expression_in_axiom450 = new BitSet(
        new long[] { 0x0000000000000008L });
    public static final BitSet FOLLOW_SAME_AS_AXIOM_in_axiom465 = new BitSet(
        new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_EXPRESSION_in_axiom468 = new BitSet(
        new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_IDENTIFIER_in_axiom473 = new BitSet(
        new long[] { 0x0000000000000008L });
    public static final BitSet FOLLOW_EXPRESSION_in_axiom477 = new BitSet(
        new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_IDENTIFIER_in_axiom483 = new BitSet(
        new long[] { 0x0000000000000008L });
    public static final BitSet FOLLOW_DIFFERENT_FROM_AXIOM_in_axiom499 = new BitSet(
        new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_EXPRESSION_in_axiom502 = new BitSet(
        new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_IDENTIFIER_in_axiom507 = new BitSet(
        new long[] { 0x0000000000000008L });
    public static final BitSet FOLLOW_EXPRESSION_in_axiom511 = new BitSet(
        new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_IDENTIFIER_in_axiom517 = new BitSet(
        new long[] { 0x0000000000000008L });
    public static final BitSet FOLLOW_UNARY_AXIOM_in_axiom531 = new BitSet(
        new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_FUNCTIONAL_in_axiom533 = new BitSet(new long[] {
        0x0000000000000000L, 0x0000000000000020L });
    public static final BitSet FOLLOW_EXPRESSION_in_axiom536 = new BitSet(
        new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_IDENTIFIER_in_axiom542 = new BitSet(
        new long[] { 0x0000000000000008L });
    public static final BitSet FOLLOW_UNARY_AXIOM_in_axiom555 = new BitSet(
        new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_INVERSE_FUNCTIONAL_in_axiom557 = new BitSet(
        new long[] { 0x0000000000000000L, 0x0000000000000020L });
    public static final BitSet FOLLOW_EXPRESSION_in_axiom560 = new BitSet(
        new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_IDENTIFIER_in_axiom566 = new BitSet(
        new long[] { 0x0000000000000008L });
    public static final BitSet FOLLOW_UNARY_AXIOM_in_axiom582 = new BitSet(
        new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_IRREFLEXIVE_in_axiom584 = new BitSet(new long[] {
        0x0000000000000000L, 0x0000000000000020L });
    public static final BitSet FOLLOW_EXPRESSION_in_axiom587 = new BitSet(
        new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_IDENTIFIER_in_axiom593 = new BitSet(
        new long[] { 0x0000000000000008L });
    public static final BitSet FOLLOW_UNARY_AXIOM_in_axiom608 = new BitSet(
        new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_REFLEXIVE_in_axiom610 = new BitSet(new long[] {
        0x0000000000000000L, 0x0000000000000020L });
    public static final BitSet FOLLOW_EXPRESSION_in_axiom613 = new BitSet(
        new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_IDENTIFIER_in_axiom619 = new BitSet(
        new long[] { 0x0000000000000008L });
    public static final BitSet FOLLOW_UNARY_AXIOM_in_axiom634 = new BitSet(
        new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_SYMMETRIC_in_axiom636 = new BitSet(new long[] {
        0x0000000000000000L, 0x0000000000000020L });
    public static final BitSet FOLLOW_EXPRESSION_in_axiom639 = new BitSet(
        new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_IDENTIFIER_in_axiom645 = new BitSet(
        new long[] { 0x0000000000000008L });
    public static final BitSet FOLLOW_UNARY_AXIOM_in_axiom662 = new BitSet(
        new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_TRANSITIVE_in_axiom664 = new BitSet(new long[] {
        0x0000000000000000L, 0x0000000000000020L });
    public static final BitSet FOLLOW_EXPRESSION_in_axiom667 = new BitSet(
        new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_IDENTIFIER_in_axiom673 = new BitSet(
        new long[] { 0x0000000000000008L });
    public static final BitSet FOLLOW_NEGATED_ASSERTION_in_axiom688 = new BitSet(
        new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_axiom_in_axiom693 = new BitSet(
        new long[] { 0x0000000000000008L });
    public static final BitSet FOLLOW_DISJUNCTION_in_expression729 = new BitSet(
        new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_conjunction_in_expression735 = new BitSet(
        new long[] { 0xE500300000000008L, 0x0000000000000043L });
    public static final BitSet FOLLOW_PROPERTY_CHAIN_in_expression751 = new BitSet(
        new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_expression_in_expression756 = new BitSet(
        new long[] { 0xE780300000000008L, 0x0000000000000053L });
    public static final BitSet FOLLOW_conjunction_in_expression770 = new BitSet(
        new long[] { 0x0000000000000002L });
    public static final BitSet FOLLOW_complexPropertyExpression_in_expression782 = new BitSet(
        new long[] { 0x0000000000000002L });
    public static final BitSet FOLLOW_CONJUNCTION_in_conjunction819 = new BitSet(
        new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_unary_in_conjunction824 = new BitSet(new long[] {
        0xE500300000000008L, 0x0000000000000043L });
    public static final BitSet FOLLOW_unary_in_conjunction835 = new BitSet(
        new long[] { 0x0000000000000002L });
    public static final BitSet FOLLOW_IDENTIFIER_in_unary862 = new BitSet(
        new long[] { 0x0000000000000002L });
    public static final BitSet FOLLOW_NEGATED_EXPRESSION_in_unary875 = new BitSet(
        new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_expression_in_unary881 = new BitSet(
        new long[] { 0x0000000000000008L });
    public static final BitSet FOLLOW_qualifiedRestriction_in_unary895 = new BitSet(
        new long[] { 0x0000000000000002L });
    public static final BitSet FOLLOW_ENTITY_REFERENCE_in_unary909 = new BitSet(
        new long[] { 0x0000000000000002L });
    public static final BitSet FOLLOW_CONSTANT_in_unary922 = new BitSet(
        new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_IDENTIFIER_in_unary933 = new BitSet(
        new long[] { 0x0000000000000008L });
    public static final BitSet FOLLOW_IDENTIFIER_in_propertyExpression970 = new BitSet(
        new long[] { 0x0000000000000002L });
    public static final BitSet FOLLOW_complexPropertyExpression_in_propertyExpression986 = new BitSet(
        new long[] { 0x0000000000000002L });
    public static final BitSet FOLLOW_INVERSE_OBJECT_PROPERTY_EXPRESSION_in_complexPropertyExpression1019 = new BitSet(
        new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_complexPropertyExpression_in_complexPropertyExpression1025 = new BitSet(
        new long[] { 0x0000000000000008L });
    public static final BitSet FOLLOW_INVERSE_OBJECT_PROPERTY_EXPRESSION_in_complexPropertyExpression1035 = new BitSet(
        new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_IDENTIFIER_in_complexPropertyExpression1037 = new BitSet(
        new long[] { 0x0000000000000008L });
    public static final BitSet FOLLOW_SOME_RESTRICTION_in_qualifiedRestriction1068 = new BitSet(
        new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_propertyExpression_in_qualifiedRestriction1073 = new BitSet(
        new long[] { 0xE780300000000008L, 0x0000000000000053L });
    public static final BitSet FOLLOW_expression_in_qualifiedRestriction1079 = new BitSet(
        new long[] { 0x0000000000000008L });
    public static final BitSet FOLLOW_ALL_RESTRICTION_in_qualifiedRestriction1101 = new BitSet(
        new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_propertyExpression_in_qualifiedRestriction1108 = new BitSet(
        new long[] { 0xE780300000000008L, 0x0000000000000053L });
    public static final BitSet FOLLOW_expression_in_qualifiedRestriction1113 = new BitSet(
        new long[] { 0x0000000000000008L });
    public static final BitSet FOLLOW_cardinalityRestriction_in_qualifiedRestriction1129 = new BitSet(
        new long[] { 0x0000000000000002L });
    public static final BitSet FOLLOW_oneOf_in_qualifiedRestriction1145 = new BitSet(
        new long[] { 0x0000000000000002L });
    public static final BitSet FOLLOW_valueRestriction_in_qualifiedRestriction1161 = new BitSet(
        new long[] { 0x0000000000000002L });
    public static final BitSet FOLLOW_CARDINALITY_RESTRICTION_in_cardinalityRestriction1198 = new BitSet(
        new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_MIN_in_cardinalityRestriction1201 = new BitSet(
        new long[] { 0x0000040000000000L });
    public static final BitSet FOLLOW_INTEGER_in_cardinalityRestriction1206 = new BitSet(
        new long[] { 0xE500300000000008L, 0x0000000000000043L });
    public static final BitSet FOLLOW_unary_in_cardinalityRestriction1212 = new BitSet(
        new long[] { 0xE780300000000008L, 0x0000000000000053L });
    public static final BitSet FOLLOW_expression_in_cardinalityRestriction1219 = new BitSet(
        new long[] { 0x0000000000000008L });
    public static final BitSet FOLLOW_CARDINALITY_RESTRICTION_in_cardinalityRestriction1234 = new BitSet(
        new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_MAX_in_cardinalityRestriction1237 = new BitSet(
        new long[] { 0x0000040000000000L });
    public static final BitSet FOLLOW_INTEGER_in_cardinalityRestriction1241 = new BitSet(
        new long[] { 0xE500300000000008L, 0x0000000000000043L });
    public static final BitSet FOLLOW_unary_in_cardinalityRestriction1247 = new BitSet(
        new long[] { 0xE780300000000008L, 0x0000000000000053L });
    public static final BitSet FOLLOW_expression_in_cardinalityRestriction1254 = new BitSet(
        new long[] { 0x0000000000000008L });
    public static final BitSet FOLLOW_CARDINALITY_RESTRICTION_in_cardinalityRestriction1273 = new BitSet(
        new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_EXACTLY_in_cardinalityRestriction1276 = new BitSet(
        new long[] { 0x0000040000000000L });
    public static final BitSet FOLLOW_INTEGER_in_cardinalityRestriction1281 = new BitSet(
        new long[] { 0xE500300000000008L, 0x0000000000000043L });
    public static final BitSet FOLLOW_unary_in_cardinalityRestriction1288 = new BitSet(
        new long[] { 0xE780300000000008L, 0x0000000000000053L });
    public static final BitSet FOLLOW_expression_in_cardinalityRestriction1295 = new BitSet(
        new long[] { 0x0000000000000008L });
    public static final BitSet FOLLOW_ONE_OF_in_oneOf1330 = new BitSet(
        new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_IDENTIFIER_in_oneOf1334 = new BitSet(
        new long[] { 0x0000100000000008L });
    public static final BitSet FOLLOW_VALUE_RESTRICTION_in_valueRestriction1367 = new BitSet(
        new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_unary_in_valueRestriction1374 = new BitSet(
        new long[] { 0xE500300000000008L, 0x0000000000000043L });
    public static final BitSet FOLLOW_unary_in_valueRestriction1381 = new BitSet(
        new long[] { 0x0000000000000008L });
}
