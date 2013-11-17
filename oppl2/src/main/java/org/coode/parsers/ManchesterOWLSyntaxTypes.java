// $ANTLR 3.2 Sep 23, 2009 12:02:23 /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxTypes.g 2011-11-04 10:50:52
package org.coode.parsers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.antlr.runtime.BaseRecognizer;
import org.antlr.runtime.BitSet;
import org.antlr.runtime.DFA;
import org.antlr.runtime.EarlyExitException;
import org.antlr.runtime.IntStream;
import org.antlr.runtime.MismatchedTokenException;
import org.antlr.runtime.NoViableAltException;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.RecognizerSharedState;
import org.antlr.runtime.RuleReturnScope;
import org.antlr.runtime.Token;
import org.antlr.runtime.tree.RewriteEmptyStreamException;
import org.antlr.runtime.tree.TreeFilter;
import org.antlr.runtime.tree.TreeNodeStream;
import org.antlr.runtime.tree.TreeRuleReturnScope;
import org.semanticweb.owlapi.model.OWLAxiom;
import org.semanticweb.owlapi.model.OWLObject;

public class ManchesterOWLSyntaxTypes extends TreeFilter {
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
            "OPPL_STATEMENT", "DATA_RANGE", "HAS_KEY", "IRI", "ANNOTATION_ASSERTION",
            "AT", "ESCLAMATION_MARK", "CREATE_IDENTIFIER", "PLAIN_IDENTIFIER", "MATCH",
            "ATTRIBUTE_SELECTOR", "LESS_THAN", "LESS_THAN_EQUAL", "GREATER_THAN",
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
    public static final int CREATE_IDENTIFIER = 151;
    public static final int CREATE = 80;
    public static final int POW = 36;
    public static final int INPUT_VARIABLE_DEFINITION = 96;
    public static final int NOT_EQUAL = 72;
    public static final int INVERSE_OBJECT_PROPERTY_EXPRESSION = 68;
    public static final int INSTANCE_OF = 38;
    public static final int BEGIN = 83;
    public static final int QUESTION_MARK = 46;
    public static final int INEQUALITY_CONSTRAINT = 94;
    public static final int VARIABLE_SCOPE = 104;
    public static final int SYMMETRIC = 30;
    public static final int CARDINALITY_RESTRICTION = 64;
    public static final int SELECT = 75;
    public static final int ROLE_ASSERTION = 67;
    public static final int DIFFERENT_FROM_AXIOM = 53;
    public static final int CREATE_OPPL_FUNCTION = 98;
    public static final int ANTI_SYMMETRIC = 31;
    public static final int TRANSITIVE = 34;
    public static final int GREATER_THAN_EQUAL = 486;
    public static final int ALL_RESTRICTION = 62;
    public static final int CONJUNCTION = 56;
    public static final int OPPL_STATEMENT = 107;
    public static final int NEGATED_ASSERTION = 59;
    public static final int WHITESPACE = 9;
    public static final int IN_SET_CONSTRAINT = 95;
    public static final int MATCH = 176;
    public static final int VALUE = 18;
    public static final int OPEN_CURLY_BRACES = 6;
    public static final int DISJUNCTION = 55;
    public static final int INVERSE = 19;
    public static final int DBLQUOTE = 40;
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
    public static final int CREATE_DISJUNCTION = 82;
    public static final int AND = 10;
    public static final int ASSERTED_CLAUSE = 92;
    public static final int INVERSE_PROPERTY = 60;
    public static final int AT = 114;
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
    public static final int OPEN_SQUARE_BRACKET = 85;
    public static final int SUB_PROPERTY_AXIOM = 51;
    public static final int EXACTLY = 17;
    public static final int RANGE = 28;
    public static final int ONE_OF = 65;
    public static final int DATA_RANGE = 108;
    public static final int VARIABLE_DEFINITIONS = 102;
    public static final int SUB_CLASS_AXIOM = 48;
    public static final int MIN = 15;
    public static final int PLAIN_CLAUSE = 93;
    public static final int Tokens = 47;
    public static final int DOMAIN = 27;
    public static final int SUBPROPERTY_OF = 105;
    public static final int COLON = 77;
    public static final int OPPL_FUNCTION = 100;
    public static final int DISJOINT_WITH_AXIOM = 50;
    public static final int CREATE_INTERSECTION = 81;
    public static final int INVERSE_FUNCTIONAL = 35;
    public static final int VARIABLE_IDENTIFIER = 106;
    public static final int IRREFLEXIVE = 33;
    public static final int ASSERTED = 76;
    public static final int VARIABLE_ATTRIBUTE = 99;
    public static final int PLAIN_IDENTIFIER = 152;
    public static final int LESS_THAN_EQUAL = 484;
    public static final int PROPERTY_CHAIN = 57;
    public static final int FUNCTIONAL = 29;
    public static final int TYPE_ASSERTION = 66;

    // delegates
    // delegators
    public ManchesterOWLSyntaxTypes(TreeNodeStream input) {
        this(input, new RecognizerSharedState());
    }

    public ManchesterOWLSyntaxTypes(TreeNodeStream input, RecognizerSharedState state) {
        super(input, state);
    }

    @Override
    public String[] getTokenNames() {
        return ManchesterOWLSyntaxTypes.tokenNames;
    }

    @Override
    public String getGrammarFileName() {
        return "/Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxTypes.g";
    }

    private SymbolTable symtab;
    private ErrorListener errorListener;

    public ManchesterOWLSyntaxTypes(TreeNodeStream input, SymbolTable symtab,
            ErrorListener errorListener) {
        this(input);
        if (symtab == null) {
            throw new NullPointerException("The symbol table cannot be null");
        }
        if (errorListener == null) {
            throw new NullPointerException("The error listener cannot be null");
        }
        this.symtab = symtab;
        this.errorListener = errorListener;
    }

    public ErrorListener getErrorListener() {
        return errorListener;
    }

    public SymbolTable getSymbolTable() {
        return symtab;
    }

    @Override
    public void displayRecognitionError(String[] tokenNames, RecognitionException e) {
        getErrorListener().recognitionException(e, tokenNames);
    }

    protected void mismatch(IntStream input, int ttype, BitSet follow)
            throws RecognitionException {
        throw new MismatchedTokenException(ttype, input);
    }

    @Override
    public Object recoverFromMismatchedSet(IntStream input, RecognitionException e,
            BitSet follow) throws RecognitionException {
        throw e;
    }

    // $ANTLR start "bottomup"
    // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxTypes.g:76:1:
    // bottomup : ( expressionRoot | axiom );
    @Override
    public final void bottomup() throws RecognitionException {
        try {
            // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxTypes.g:77:5:
            // ( expressionRoot | axiom )
            int alt1 = 2;
            int LA1_0 = input.LA(1);
            if (LA1_0 == EXPRESSION) {
                alt1 = 1;
            } else if (LA1_0 == INVERSE_OF || LA1_0 >= DOMAIN && LA1_0 <= RANGE
                    || LA1_0 >= SUB_CLASS_AXIOM && LA1_0 <= UNARY_AXIOM
                    || LA1_0 == NEGATED_ASSERTION || LA1_0 >= TYPE_ASSERTION
                    && LA1_0 <= ROLE_ASSERTION || LA1_0 == HAS_KEY
                    || LA1_0 == ANNOTATION_ASSERTION) {
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
                // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxTypes.g:77:9:
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
                // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxTypes.g:78:8:
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
        } finally {}
        return;
    }

    // $ANTLR end "bottomup"
    // $ANTLR start "expressionRoot"
    // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxTypes.g:81:1:
    // expressionRoot : ^( EXPRESSION expression ) ;
    public final void expressionRoot() throws RecognitionException {
        ManchesterOWLSyntaxTree EXPRESSION1 = null;
        ManchesterOWLSyntaxTypes.expression_return expression2 = null;
        try {
            // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxTypes.g:82:5:
            // ( ^( EXPRESSION expression ) )
            // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxTypes.g:82:9:
            // ^( EXPRESSION expression )
            {
                EXPRESSION1 = (ManchesterOWLSyntaxTree) match(input, EXPRESSION,
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
                    EXPRESSION1.setOWLObject(expression2 != null ? expression2.owlObject
                            : null);
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
        } finally {}
        return;
    }

    // $ANTLR end "expressionRoot"
    public static class axiom_return extends TreeRuleReturnScope {
        public Type type;
        public ManchesterOWLSyntaxTree node;
        public OWLAxiom owlAxiom;
    };

    // $ANTLR start "axiom"
    // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxTypes.g:91:1:
    // axiom returns [Type type, ManchesterOWLSyntaxTree node, OWLAxiom
    // owlAxiom] : ( ^( SUB_CLASS_AXIOM ^( EXPRESSION subClass= expression ) ^(
    // EXPRESSION superClass= expression ) ) | ^( EQUIVALENT_TO_AXIOM ^(
    // EXPRESSION lhs= expression ) ^( EXPRESSION rhs= expression ) ) | ^(
    // INVERSE_OF ^( EXPRESSION p= IDENTIFIER ) ^( EXPRESSION anotherProperty=
    // IDENTIFIER ) ) | ^( DISJOINT_WITH_AXIOM ^( EXPRESSION lhs= expression )
    // ^( EXPRESSION rhs= expression ) ) | ^( SUB_PROPERTY_AXIOM ^( EXPRESSION
    // subProperty= expression ) ^( EXPRESSION superProperty= unary ) ) | ^(
    // ROLE_ASSERTION ^( EXPRESSION subject= IDENTIFIER ) ^( EXPRESSION
    // predicate= propertyExpression ) ^( EXPRESSION object= unary ) ) | ^(
    // TYPE_ASSERTION ^( EXPRESSION description= expression ) ^( EXPRESSION
    // subject= IDENTIFIER ) ) | ^( DOMAIN ^( EXPRESSION p= IDENTIFIER ) ^(
    // EXPRESSION domain= expression ) ) | ^( RANGE ^( EXPRESSION p= IDENTIFIER
    // ) ^( EXPRESSION range= expression ) ) | ^( SAME_AS_AXIOM ^( EXPRESSION
    // anIndividual= IDENTIFIER ) ^( EXPRESSION anotherIndividual= IDENTIFIER )
    // ) | ^( DIFFERENT_FROM_AXIOM ^( EXPRESSION anIndividual= IDENTIFIER ) ^(
    // EXPRESSION anotherIndividual= IDENTIFIER ) ) | ^( UNARY_AXIOM FUNCTIONAL
    // ^( EXPRESSION p= IDENTIFIER ) ) | ^( UNARY_AXIOM INVERSE_FUNCTIONAL ^(
    // EXPRESSION p= IDENTIFIER ) ) | ^( UNARY_AXIOM IRREFLEXIVE ^( EXPRESSION
    // p= IDENTIFIER ) ) | ^( UNARY_AXIOM REFLEXIVE ^( EXPRESSION p= IDENTIFIER
    // ) ) | ^( UNARY_AXIOM SYMMETRIC ^( EXPRESSION p= IDENTIFIER ) ) | ^(
    // UNARY_AXIOM ANTI_SYMMETRIC ^( EXPRESSION p= IDENTIFIER ) ) | ^(
    // UNARY_AXIOM TRANSITIVE ^( EXPRESSION p= IDENTIFIER ) ) | ^(
    // NEGATED_ASSERTION a= axiom ) | ^( HAS_KEY ^( EXPRESSION exp= expression )
    // ( ^( EXPRESSION propertyExp= propertyExpression ) )+ ) | ^(
    // ANNOTATION_ASSERTION IRI ^( EXPRESSION annotationProperty= unary ) ^(
    // EXPRESSION annotationObject= expression ) ) );
    public final ManchesterOWLSyntaxTypes.axiom_return axiom()
            throws RecognitionException {
        ManchesterOWLSyntaxTypes.axiom_return retval = new ManchesterOWLSyntaxTypes.axiom_return();
        retval.start = input.LT(1);
        ManchesterOWLSyntaxTree p = null;
        ManchesterOWLSyntaxTree anotherProperty = null;
        ManchesterOWLSyntaxTree subject = null;
        ManchesterOWLSyntaxTree anIndividual = null;
        ManchesterOWLSyntaxTree anotherIndividual = null;
        ManchesterOWLSyntaxTree IRI3 = null;
        ManchesterOWLSyntaxTypes.expression_return subClass = null;
        ManchesterOWLSyntaxTypes.expression_return superClass = null;
        ManchesterOWLSyntaxTypes.expression_return lhs = null;
        ManchesterOWLSyntaxTypes.expression_return rhs = null;
        ManchesterOWLSyntaxTypes.expression_return subProperty = null;
        ManchesterOWLSyntaxTypes.unary_return superProperty = null;
        ManchesterOWLSyntaxTypes.propertyExpression_return predicate = null;
        ManchesterOWLSyntaxTypes.unary_return object = null;
        ManchesterOWLSyntaxTypes.expression_return description = null;
        ManchesterOWLSyntaxTypes.expression_return domain = null;
        ManchesterOWLSyntaxTypes.expression_return range = null;
        ManchesterOWLSyntaxTypes.axiom_return a = null;
        ManchesterOWLSyntaxTypes.expression_return exp = null;
        ManchesterOWLSyntaxTypes.propertyExpression_return propertyExp = null;
        ManchesterOWLSyntaxTypes.unary_return annotationProperty = null;
        ManchesterOWLSyntaxTypes.expression_return annotationObject = null;
        Set<ManchesterOWLSyntaxTree> propertyExpressions = new HashSet<ManchesterOWLSyntaxTree>();
        try {
            // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxTypes.g:102:1:
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
            // UNARY_AXIOM ANTI_SYMMETRIC ^( EXPRESSION p= IDENTIFIER ) ) | ^(
            // UNARY_AXIOM TRANSITIVE ^( EXPRESSION p= IDENTIFIER ) ) | ^(
            // NEGATED_ASSERTION a= axiom ) | ^( HAS_KEY ^( EXPRESSION exp=
            // expression ) ( ^( EXPRESSION propertyExp= propertyExpression ) )+
            // ) | ^( ANNOTATION_ASSERTION IRI ^( EXPRESSION annotationProperty=
            // unary ) ^( EXPRESSION annotationObject= expression ) ) )
            int alt3 = 21;
            alt3 = dfa3.predict(input);
            switch (alt3) {
                case 1:
                // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxTypes.g:103:3:
                // ^( SUB_CLASS_AXIOM ^( EXPRESSION subClass= expression ) ^(
                // EXPRESSION superClass= expression ) )
                {
                    match(input, SUB_CLASS_AXIOM, FOLLOW_SUB_CLASS_AXIOM_in_axiom170);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.DOWN, null);
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
                    subClass = expression();
                    state._fsp--;
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.UP, null);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, EXPRESSION, FOLLOW_EXPRESSION_in_axiom186);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.DOWN, null);
                    if (state.failed) {
                        return retval;
                    }
                    pushFollow(FOLLOW_expression_in_axiom193);
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
                                (ManchesterOWLSyntaxTree) retval.start, subClass.node,
                                superClass.node);
                        retval.owlAxiom = getSymbolTable().getSubClassAxiom(
                                (ManchesterOWLSyntaxTree) retval.start, subClass.node,
                                superClass.node);
                    }
                }
                    break;
                case 2:
                // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxTypes.g:108:5:
                // ^( EQUIVALENT_TO_AXIOM ^( EXPRESSION lhs= expression ) ^(
                // EXPRESSION rhs= expression ) )
                {
                    match(input, EQUIVALENT_TO_AXIOM,
                            FOLLOW_EQUIVALENT_TO_AXIOM_in_axiom206);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.DOWN, null);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, EXPRESSION, FOLLOW_EXPRESSION_in_axiom209);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.DOWN, null);
                    if (state.failed) {
                        return retval;
                    }
                    pushFollow(FOLLOW_expression_in_axiom215);
                    lhs = expression();
                    state._fsp--;
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.UP, null);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, EXPRESSION, FOLLOW_EXPRESSION_in_axiom219);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.DOWN, null);
                    if (state.failed) {
                        return retval;
                    }
                    pushFollow(FOLLOW_expression_in_axiom226);
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
                                (ManchesterOWLSyntaxTree) retval.start, lhs.node,
                                rhs.node);
                        retval.owlAxiom = getSymbolTable().getEquivalentAxiom(
                                (ManchesterOWLSyntaxTree) retval.start, lhs.node,
                                rhs.node);
                    }
                }
                    break;
                case 3:
                // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxTypes.g:113:4:
                // ^( INVERSE_OF ^( EXPRESSION p= IDENTIFIER ) ^( EXPRESSION
                // anotherProperty= IDENTIFIER ) )
                {
                    match(input, INVERSE_OF, FOLLOW_INVERSE_OF_in_axiom241);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.DOWN, null);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, EXPRESSION, FOLLOW_EXPRESSION_in_axiom244);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.DOWN, null);
                    if (state.failed) {
                        return retval;
                    }
                    p = (ManchesterOWLSyntaxTree) match(input, IDENTIFIER,
                            FOLLOW_IDENTIFIER_in_axiom250);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.UP, null);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, EXPRESSION, FOLLOW_EXPRESSION_in_axiom254);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.DOWN, null);
                    if (state.failed) {
                        return retval;
                    }
                    anotherProperty = (ManchesterOWLSyntaxTree) match(input, IDENTIFIER,
                            FOLLOW_IDENTIFIER_in_axiom260);
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
                                (ManchesterOWLSyntaxTree) retval.start, p,
                                anotherProperty);
                        retval.owlAxiom = getSymbolTable().getInverseOfAxiom(
                                (ManchesterOWLSyntaxTree) retval.start, p,
                                anotherProperty);
                    }
                }
                    break;
                case 4:
                // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxTypes.g:118:5:
                // ^( DISJOINT_WITH_AXIOM ^( EXPRESSION lhs= expression ) ^(
                // EXPRESSION rhs= expression ) )
                {
                    match(input, DISJOINT_WITH_AXIOM,
                            FOLLOW_DISJOINT_WITH_AXIOM_in_axiom272);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.DOWN, null);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, EXPRESSION, FOLLOW_EXPRESSION_in_axiom275);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.DOWN, null);
                    if (state.failed) {
                        return retval;
                    }
                    pushFollow(FOLLOW_expression_in_axiom282);
                    lhs = expression();
                    state._fsp--;
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.UP, null);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, EXPRESSION, FOLLOW_EXPRESSION_in_axiom286);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.DOWN, null);
                    if (state.failed) {
                        return retval;
                    }
                    pushFollow(FOLLOW_expression_in_axiom292);
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
                                (ManchesterOWLSyntaxTree) retval.start, lhs.node,
                                rhs.node);
                        retval.owlAxiom = getSymbolTable().getDisjointAxiom(
                                (ManchesterOWLSyntaxTree) retval.start, lhs.node,
                                rhs.node);
                    }
                }
                    break;
                case 5:
                // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxTypes.g:122:4:
                // ^( SUB_PROPERTY_AXIOM ^( EXPRESSION subProperty= expression )
                // ^( EXPRESSION superProperty= unary ) )
                {
                    match(input, SUB_PROPERTY_AXIOM,
                            FOLLOW_SUB_PROPERTY_AXIOM_in_axiom304);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.DOWN, null);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, EXPRESSION, FOLLOW_EXPRESSION_in_axiom307);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.DOWN, null);
                    if (state.failed) {
                        return retval;
                    }
                    pushFollow(FOLLOW_expression_in_axiom314);
                    subProperty = expression();
                    state._fsp--;
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.UP, null);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, EXPRESSION, FOLLOW_EXPRESSION_in_axiom318);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.DOWN, null);
                    if (state.failed) {
                        return retval;
                    }
                    pushFollow(FOLLOW_unary_in_axiom324);
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
                                (ManchesterOWLSyntaxTree) retval.start, subProperty.node,
                                superProperty.node);
                        retval.owlAxiom = getSymbolTable().getSubPropertyAxiom(
                                (ManchesterOWLSyntaxTree) retval.start, subProperty.node,
                                superProperty.node);
                    }
                }
                    break;
                case 6:
                // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxTypes.g:127:4:
                // ^( ROLE_ASSERTION ^( EXPRESSION subject= IDENTIFIER ) ^(
                // EXPRESSION predicate= propertyExpression ) ^( EXPRESSION
                // object= unary ) )
                {
                    match(input, ROLE_ASSERTION, FOLLOW_ROLE_ASSERTION_in_axiom338);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.DOWN, null);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, EXPRESSION, FOLLOW_EXPRESSION_in_axiom341);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.DOWN, null);
                    if (state.failed) {
                        return retval;
                    }
                    subject = (ManchesterOWLSyntaxTree) match(input, IDENTIFIER,
                            FOLLOW_IDENTIFIER_in_axiom348);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.UP, null);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, EXPRESSION, FOLLOW_EXPRESSION_in_axiom352);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.DOWN, null);
                    if (state.failed) {
                        return retval;
                    }
                    pushFollow(FOLLOW_propertyExpression_in_axiom359);
                    predicate = propertyExpression();
                    state._fsp--;
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.UP, null);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, EXPRESSION, FOLLOW_EXPRESSION_in_axiom363);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.DOWN, null);
                    if (state.failed) {
                        return retval;
                    }
                    pushFollow(FOLLOW_unary_in_axiom369);
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
                                (ManchesterOWLSyntaxTree) retval.start, subject,
                                predicate.node, object.node);
                        retval.owlAxiom = getSymbolTable().getRoleAssertionAxiom(
                                (ManchesterOWLSyntaxTree) retval.start, subject,
                                predicate.node, object.node);
                    }
                }
                    break;
                case 7:
                // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxTypes.g:131:5:
                // ^( TYPE_ASSERTION ^( EXPRESSION description= expression ) ^(
                // EXPRESSION subject= IDENTIFIER ) )
                {
                    match(input, TYPE_ASSERTION, FOLLOW_TYPE_ASSERTION_in_axiom379);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.DOWN, null);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, EXPRESSION, FOLLOW_EXPRESSION_in_axiom382);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.DOWN, null);
                    if (state.failed) {
                        return retval;
                    }
                    pushFollow(FOLLOW_expression_in_axiom389);
                    description = expression();
                    state._fsp--;
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.UP, null);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, EXPRESSION, FOLLOW_EXPRESSION_in_axiom393);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.DOWN, null);
                    if (state.failed) {
                        return retval;
                    }
                    subject = (ManchesterOWLSyntaxTree) match(input, IDENTIFIER,
                            FOLLOW_IDENTIFIER_in_axiom399);
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
                                (ManchesterOWLSyntaxTree) retval.start, description.node,
                                subject);
                        retval.owlAxiom = getSymbolTable().getClassAssertionAxiom(
                                (ManchesterOWLSyntaxTree) retval.start, description.node,
                                subject);
                    }
                }
                    break;
                case 8:
                // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxTypes.g:136:4:
                // ^( DOMAIN ^( EXPRESSION p= IDENTIFIER ) ^( EXPRESSION domain=
                // expression ) )
                {
                    match(input, DOMAIN, FOLLOW_DOMAIN_in_axiom411);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.DOWN, null);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, EXPRESSION, FOLLOW_EXPRESSION_in_axiom414);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.DOWN, null);
                    if (state.failed) {
                        return retval;
                    }
                    p = (ManchesterOWLSyntaxTree) match(input, IDENTIFIER,
                            FOLLOW_IDENTIFIER_in_axiom420);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.UP, null);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, EXPRESSION, FOLLOW_EXPRESSION_in_axiom424);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.DOWN, null);
                    if (state.failed) {
                        return retval;
                    }
                    pushFollow(FOLLOW_expression_in_axiom430);
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
                                (ManchesterOWLSyntaxTree) retval.start, p, domain.node);
                        retval.owlAxiom = getSymbolTable().getDomainAxiom(
                                (ManchesterOWLSyntaxTree) retval.start, p, domain.node);
                    }
                }
                    break;
                case 9:
                // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxTypes.g:141:5:
                // ^( RANGE ^( EXPRESSION p= IDENTIFIER ) ^( EXPRESSION range=
                // expression ) )
                {
                    match(input, RANGE, FOLLOW_RANGE_in_axiom443);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.DOWN, null);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, EXPRESSION, FOLLOW_EXPRESSION_in_axiom446);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.DOWN, null);
                    if (state.failed) {
                        return retval;
                    }
                    p = (ManchesterOWLSyntaxTree) match(input, IDENTIFIER,
                            FOLLOW_IDENTIFIER_in_axiom452);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.UP, null);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, EXPRESSION, FOLLOW_EXPRESSION_in_axiom456);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.DOWN, null);
                    if (state.failed) {
                        return retval;
                    }
                    pushFollow(FOLLOW_expression_in_axiom462);
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
                                (ManchesterOWLSyntaxTree) retval.start, p, range.node);
                        retval.owlAxiom = getSymbolTable().getRangeAxiom(
                                (ManchesterOWLSyntaxTree) retval.start, p, range.node);
                    }
                }
                    break;
                case 10:
                // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxTypes.g:146:6:
                // ^( SAME_AS_AXIOM ^( EXPRESSION anIndividual= IDENTIFIER ) ^(
                // EXPRESSION anotherIndividual= IDENTIFIER ) )
                {
                    match(input, SAME_AS_AXIOM, FOLLOW_SAME_AS_AXIOM_in_axiom477);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.DOWN, null);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, EXPRESSION, FOLLOW_EXPRESSION_in_axiom480);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.DOWN, null);
                    if (state.failed) {
                        return retval;
                    }
                    anIndividual = (ManchesterOWLSyntaxTree) match(input, IDENTIFIER,
                            FOLLOW_IDENTIFIER_in_axiom485);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.UP, null);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, EXPRESSION, FOLLOW_EXPRESSION_in_axiom489);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.DOWN, null);
                    if (state.failed) {
                        return retval;
                    }
                    anotherIndividual = (ManchesterOWLSyntaxTree) match(input,
                            IDENTIFIER, FOLLOW_IDENTIFIER_in_axiom495);
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
                                (ManchesterOWLSyntaxTree) retval.start, anIndividual,
                                anotherIndividual);
                        retval.owlAxiom = getSymbolTable().getSameIndividualsAxiom(
                                (ManchesterOWLSyntaxTree) retval.start, anIndividual,
                                anotherIndividual);
                    }
                }
                    break;
                case 11:
                // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxTypes.g:151:7:
                // ^( DIFFERENT_FROM_AXIOM ^( EXPRESSION anIndividual=
                // IDENTIFIER ) ^( EXPRESSION anotherIndividual= IDENTIFIER ) )
                {
                    match(input, DIFFERENT_FROM_AXIOM,
                            FOLLOW_DIFFERENT_FROM_AXIOM_in_axiom511);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.DOWN, null);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, EXPRESSION, FOLLOW_EXPRESSION_in_axiom514);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.DOWN, null);
                    if (state.failed) {
                        return retval;
                    }
                    anIndividual = (ManchesterOWLSyntaxTree) match(input, IDENTIFIER,
                            FOLLOW_IDENTIFIER_in_axiom519);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.UP, null);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, EXPRESSION, FOLLOW_EXPRESSION_in_axiom523);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.DOWN, null);
                    if (state.failed) {
                        return retval;
                    }
                    anotherIndividual = (ManchesterOWLSyntaxTree) match(input,
                            IDENTIFIER, FOLLOW_IDENTIFIER_in_axiom529);
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
                                (ManchesterOWLSyntaxTree) retval.start, anIndividual,
                                anotherIndividual);
                        retval.owlAxiom = getSymbolTable().getDifferentIndividualsAxiom(
                                (ManchesterOWLSyntaxTree) retval.start, anIndividual,
                                anotherIndividual);
                    }
                }
                    break;
                case 12:
                // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxTypes.g:156:5:
                // ^( UNARY_AXIOM FUNCTIONAL ^( EXPRESSION p= IDENTIFIER ) )
                {
                    match(input, UNARY_AXIOM, FOLLOW_UNARY_AXIOM_in_axiom543);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.DOWN, null);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, FUNCTIONAL, FOLLOW_FUNCTIONAL_in_axiom545);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, EXPRESSION, FOLLOW_EXPRESSION_in_axiom548);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.DOWN, null);
                    if (state.failed) {
                        return retval;
                    }
                    p = (ManchesterOWLSyntaxTree) match(input, IDENTIFIER,
                            FOLLOW_IDENTIFIER_in_axiom554);
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
                                (ManchesterOWLSyntaxTree) retval.start, p);
                        retval.owlAxiom = getSymbolTable().getFunctionalProperty(
                                (ManchesterOWLSyntaxTree) retval.start, p);
                    }
                }
                    break;
                case 13:
                // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxTypes.g:161:5:
                // ^( UNARY_AXIOM INVERSE_FUNCTIONAL ^( EXPRESSION p= IDENTIFIER
                // ) )
                {
                    match(input, UNARY_AXIOM, FOLLOW_UNARY_AXIOM_in_axiom567);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.DOWN, null);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, INVERSE_FUNCTIONAL,
                            FOLLOW_INVERSE_FUNCTIONAL_in_axiom569);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, EXPRESSION, FOLLOW_EXPRESSION_in_axiom572);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.DOWN, null);
                    if (state.failed) {
                        return retval;
                    }
                    p = (ManchesterOWLSyntaxTree) match(input, IDENTIFIER,
                            FOLLOW_IDENTIFIER_in_axiom578);
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
                                (ManchesterOWLSyntaxTree) retval.start, p);
                        retval.owlAxiom = getSymbolTable().getInverseFunctionalProperty(
                                (ManchesterOWLSyntaxTree) retval.start, p);
                    }
                }
                    break;
                case 14:
                // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxTypes.g:166:7:
                // ^( UNARY_AXIOM IRREFLEXIVE ^( EXPRESSION p= IDENTIFIER ) )
                {
                    match(input, UNARY_AXIOM, FOLLOW_UNARY_AXIOM_in_axiom594);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.DOWN, null);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, IRREFLEXIVE, FOLLOW_IRREFLEXIVE_in_axiom596);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, EXPRESSION, FOLLOW_EXPRESSION_in_axiom599);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.DOWN, null);
                    if (state.failed) {
                        return retval;
                    }
                    p = (ManchesterOWLSyntaxTree) match(input, IDENTIFIER,
                            FOLLOW_IDENTIFIER_in_axiom605);
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
                                (ManchesterOWLSyntaxTree) retval.start, p);
                        retval.owlAxiom = getSymbolTable().getIrreflexiveProperty(
                                (ManchesterOWLSyntaxTree) retval.start, p);
                    }
                }
                    break;
                case 15:
                // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxTypes.g:171:6:
                // ^( UNARY_AXIOM REFLEXIVE ^( EXPRESSION p= IDENTIFIER ) )
                {
                    match(input, UNARY_AXIOM, FOLLOW_UNARY_AXIOM_in_axiom620);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.DOWN, null);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, REFLEXIVE, FOLLOW_REFLEXIVE_in_axiom622);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, EXPRESSION, FOLLOW_EXPRESSION_in_axiom625);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.DOWN, null);
                    if (state.failed) {
                        return retval;
                    }
                    p = (ManchesterOWLSyntaxTree) match(input, IDENTIFIER,
                            FOLLOW_IDENTIFIER_in_axiom631);
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
                                (ManchesterOWLSyntaxTree) retval.start, p);
                        retval.owlAxiom = getSymbolTable().getReflexiveProperty(
                                (ManchesterOWLSyntaxTree) retval.start, p);
                    }
                }
                    break;
                case 16:
                // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxTypes.g:176:6:
                // ^( UNARY_AXIOM SYMMETRIC ^( EXPRESSION p= IDENTIFIER ) )
                {
                    match(input, UNARY_AXIOM, FOLLOW_UNARY_AXIOM_in_axiom646);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.DOWN, null);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, SYMMETRIC, FOLLOW_SYMMETRIC_in_axiom648);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, EXPRESSION, FOLLOW_EXPRESSION_in_axiom651);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.DOWN, null);
                    if (state.failed) {
                        return retval;
                    }
                    p = (ManchesterOWLSyntaxTree) match(input, IDENTIFIER,
                            FOLLOW_IDENTIFIER_in_axiom657);
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
                                (ManchesterOWLSyntaxTree) retval.start, p);
                        retval.owlAxiom = getSymbolTable().getSymmetricProperty(
                                (ManchesterOWLSyntaxTree) retval.start, p);
                    }
                }
                    break;
                case 17:
                // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxTypes.g:181:9:
                // ^( UNARY_AXIOM ANTI_SYMMETRIC ^( EXPRESSION p= IDENTIFIER ) )
                {
                    match(input, UNARY_AXIOM, FOLLOW_UNARY_AXIOM_in_axiom675);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.DOWN, null);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, ANTI_SYMMETRIC, FOLLOW_ANTI_SYMMETRIC_in_axiom677);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, EXPRESSION, FOLLOW_EXPRESSION_in_axiom680);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.DOWN, null);
                    if (state.failed) {
                        return retval;
                    }
                    p = (ManchesterOWLSyntaxTree) match(input, IDENTIFIER,
                            FOLLOW_IDENTIFIER_in_axiom686);
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
                                (ManchesterOWLSyntaxTree) retval.start, p);
                        retval.owlAxiom = getSymbolTable().getAsymmetricProperty(
                                (ManchesterOWLSyntaxTree) retval.start, p);
                    }
                }
                    break;
                case 18:
                // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxTypes.g:187:7:
                // ^( UNARY_AXIOM TRANSITIVE ^( EXPRESSION p= IDENTIFIER ) )
                {
                    match(input, UNARY_AXIOM, FOLLOW_UNARY_AXIOM_in_axiom707);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.DOWN, null);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, TRANSITIVE, FOLLOW_TRANSITIVE_in_axiom709);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, EXPRESSION, FOLLOW_EXPRESSION_in_axiom712);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.DOWN, null);
                    if (state.failed) {
                        return retval;
                    }
                    p = (ManchesterOWLSyntaxTree) match(input, IDENTIFIER,
                            FOLLOW_IDENTIFIER_in_axiom718);
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
                                (ManchesterOWLSyntaxTree) retval.start, p);
                        retval.owlAxiom = getSymbolTable().getTransitiveProperty(
                                (ManchesterOWLSyntaxTree) retval.start, p);
                    }
                }
                    break;
                case 19:
                // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxTypes.g:192:6:
                // ^( NEGATED_ASSERTION a= axiom )
                {
                    match(input, NEGATED_ASSERTION, FOLLOW_NEGATED_ASSERTION_in_axiom733);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.DOWN, null);
                    if (state.failed) {
                        return retval;
                    }
                    pushFollow(FOLLOW_axiom_in_axiom738);
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
                                (ManchesterOWLSyntaxTree) retval.start, a.node);
                        retval.owlAxiom = getSymbolTable().getNegatedAssertion(
                                (ManchesterOWLSyntaxTree) retval.start, a.node);
                    }
                }
                    break;
                case 20:
                // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxTypes.g:196:6:
                // ^( HAS_KEY ^( EXPRESSION exp= expression ) ( ^( EXPRESSION
                // propertyExp= propertyExpression ) )+ )
                {
                    match(input, HAS_KEY, FOLLOW_HAS_KEY_in_axiom748);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.DOWN, null);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, EXPRESSION, FOLLOW_EXPRESSION_in_axiom751);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.DOWN, null);
                    if (state.failed) {
                        return retval;
                    }
                    pushFollow(FOLLOW_expression_in_axiom756);
                    exp = expression();
                    state._fsp--;
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.UP, null);
                    if (state.failed) {
                        return retval;
                    }
                    // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxTypes.g:196:46:
                    // ( ^( EXPRESSION propertyExp= propertyExpression ) )+
                    int cnt2 = 0;
                    loop2: do {
                        int alt2 = 2;
                        int LA2_0 = input.LA(1);
                        if (LA2_0 == EXPRESSION) {
                            alt2 = 1;
                        }
                        switch (alt2) {
                            case 1:
                            // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxTypes.g:196:47:
                            // ^( EXPRESSION propertyExp= propertyExpression )
                            {
                                match(input, EXPRESSION, FOLLOW_EXPRESSION_in_axiom761);
                                if (state.failed) {
                                    return retval;
                                }
                                match(input, Token.DOWN, null);
                                if (state.failed) {
                                    return retval;
                                }
                                pushFollow(FOLLOW_propertyExpression_in_axiom767);
                                propertyExp = propertyExpression();
                                state._fsp--;
                                if (state.failed) {
                                    return retval;
                                }
                                match(input, Token.UP, null);
                                if (state.failed) {
                                    return retval;
                                }
                                if (state.backtracking == 1) {
                                    propertyExpressions.add(propertyExp.node);
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
                    if (state.backtracking == 1) {
                        retval.type = getSymbolTable().getHasKeyType(
                                (ManchesterOWLSyntaxTree) retval.start, exp.node,
                                propertyExpressions);
                        retval.owlAxiom = getSymbolTable().getHasKey(
                                (ManchesterOWLSyntaxTree) retval.start, exp.node,
                                propertyExpressions);
                    }
                }
                    break;
                case 21:
                // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxTypes.g:202:6:
                // ^( ANNOTATION_ASSERTION IRI ^( EXPRESSION annotationProperty=
                // unary ) ^( EXPRESSION annotationObject= expression ) )
                {
                    match(input, ANNOTATION_ASSERTION,
                            FOLLOW_ANNOTATION_ASSERTION_in_axiom781);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.DOWN, null);
                    if (state.failed) {
                        return retval;
                    }
                    IRI3 = (ManchesterOWLSyntaxTree) match(input, IRI,
                            FOLLOW_IRI_in_axiom783);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, EXPRESSION, FOLLOW_EXPRESSION_in_axiom786);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.DOWN, null);
                    if (state.failed) {
                        return retval;
                    }
                    pushFollow(FOLLOW_unary_in_axiom792);
                    annotationProperty = unary();
                    state._fsp--;
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.UP, null);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, EXPRESSION, FOLLOW_EXPRESSION_in_axiom796);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.DOWN, null);
                    if (state.failed) {
                        return retval;
                    }
                    pushFollow(FOLLOW_expression_in_axiom802);
                    annotationObject = expression();
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
                        retval.type = getSymbolTable().getAnnotationAssertionType(
                                (ManchesterOWLSyntaxTree) retval.start, IRI3,
                                annotationProperty.node, annotationObject.node);
                        retval.owlAxiom = getSymbolTable().getAnnotationAssertion(
                                (ManchesterOWLSyntaxTree) retval.start, IRI3,
                                annotationProperty.node, annotationObject.node);
                    }
                }
                    break;
            }
            if (state.backtracking == 1) {
                ((ManchesterOWLSyntaxTree) retval.start).setEvalType(retval.type);
                retval.node = (ManchesterOWLSyntaxTree) retval.start;
                ((ManchesterOWLSyntaxTree) retval.start).setOWLObject(retval.owlAxiom);
            }
        } catch (RecognitionException exception) {
            if (errorListener != null) {
                errorListener.recognitionException(exception);
            }
        } catch (RewriteEmptyStreamException exception) {
            if (errorListener != null) {
                errorListener.rewriteEmptyStreamException(exception);
            }
        } finally {}
        return retval;
    }

    // $ANTLR end "axiom"
    public static class expression_return extends TreeRuleReturnScope {
        public Type type;
        public ManchesterOWLSyntaxTree node;
        public OWLObject owlObject;
    };

    // $ANTLR start "expression"
    // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxTypes.g:209:1:
    // expression returns [Type type, ManchesterOWLSyntaxTree node, OWLObject
    // owlObject] : ( ^( DISJUNCTION (disjuncts+= conjunction )+ ) | ^(
    // PROPERTY_CHAIN (chainItems+= expression )+ ) | conjunction |
    // complexPropertyExpression );
    public final ManchesterOWLSyntaxTypes.expression_return expression()
            throws RecognitionException {
        ManchesterOWLSyntaxTypes.expression_return retval = new ManchesterOWLSyntaxTypes.expression_return();
        retval.start = input.LT(1);
        List list_disjuncts = null;
        List list_chainItems = null;
        ManchesterOWLSyntaxTypes.conjunction_return conjunction4 = null;
        ManchesterOWLSyntaxTypes.complexPropertyExpression_return complexPropertyExpression5 = null;
        RuleReturnScope disjuncts = null;
        RuleReturnScope chainItems = null;
        try {
            // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxTypes.g:216:2:
            // ( ^( DISJUNCTION (disjuncts+= conjunction )+ ) | ^(
            // PROPERTY_CHAIN (chainItems+= expression )+ ) | conjunction |
            // complexPropertyExpression )
            int alt6 = 4;
            switch (input.LA(1)) {
                case DISJUNCTION: {
                    alt6 = 1;
                }
                    break;
                case PROPERTY_CHAIN: {
                    alt6 = 2;
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
                case CONSTANT:
                case DATA_RANGE:
                case IRI: {
                    alt6 = 3;
                }
                    break;
                case INVERSE_OBJECT_PROPERTY_EXPRESSION: {
                    alt6 = 4;
                }
                    break;
                default:
                    if (state.backtracking > 0) {
                        state.failed = true;
                        return retval;
                    }
                    NoViableAltException nvae = new NoViableAltException("", 6, 0, input);
                    throw nvae;
            }
            switch (alt6) {
                case 1:
                // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxTypes.g:217:4:
                // ^( DISJUNCTION (disjuncts+= conjunction )+ )
                {
                    match(input, DISJUNCTION, FOLLOW_DISJUNCTION_in_expression845);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.DOWN, null);
                    if (state.failed) {
                        return retval;
                    }
                    // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxTypes.g:217:29:
                    // (disjuncts+= conjunction )+
                    int cnt4 = 0;
                    loop4: do {
                        int alt4 = 2;
                        int LA4_0 = input.LA(1);
                        if (LA4_0 >= IDENTIFIER && LA4_0 <= ENTITY_REFERENCE
                                || LA4_0 == CONJUNCTION || LA4_0 == NEGATED_EXPRESSION
                                || LA4_0 >= SOME_RESTRICTION && LA4_0 <= ONE_OF
                                || LA4_0 == CONSTANT || LA4_0 == DATA_RANGE
                                || LA4_0 == IRI) {
                            alt4 = 1;
                        }
                        switch (alt4) {
                            case 1:
                            // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxTypes.g:217:29:
                            // disjuncts+= conjunction
                            {
                                pushFollow(FOLLOW_conjunction_in_expression851);
                                disjuncts = conjunction();
                                state._fsp--;
                                if (state.failed) {
                                    return retval;
                                }
                                if (list_disjuncts == null) {
                                    list_disjuncts = new ArrayList();
                                }
                                list_disjuncts.add(disjuncts);
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
                        List<ManchesterOWLSyntaxTree> nodes = new ArrayList<ManchesterOWLSyntaxTree>(
                                list_disjuncts.size());
                        for (Object node : list_disjuncts) {
                            nodes.add(((conjunction_return) node).node);
                        }
                        retval.type = getSymbolTable().getDisjunctionType(
                                (ManchesterOWLSyntaxTree) retval.start,
                                nodes.toArray(new ManchesterOWLSyntaxTree[nodes.size()]));
                        retval.owlObject = getSymbolTable().getDisjunction(
                                (ManchesterOWLSyntaxTree) retval.start,
                                nodes.toArray(new ManchesterOWLSyntaxTree[nodes.size()]));
                    }
                }
                    break;
                case 2:
                // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxTypes.g:226:6:
                // ^( PROPERTY_CHAIN (chainItems+= expression )+ )
                {
                    match(input, PROPERTY_CHAIN, FOLLOW_PROPERTY_CHAIN_in_expression867);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.DOWN, null);
                    if (state.failed) {
                        return retval;
                    }
                    // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxTypes.g:226:34:
                    // (chainItems+= expression )+
                    int cnt5 = 0;
                    loop5: do {
                        int alt5 = 2;
                        int LA5_0 = input.LA(1);
                        if (LA5_0 >= IDENTIFIER && LA5_0 <= ENTITY_REFERENCE
                                || LA5_0 >= DISJUNCTION && LA5_0 <= NEGATED_EXPRESSION
                                || LA5_0 >= SOME_RESTRICTION && LA5_0 <= ONE_OF
                                || LA5_0 == INVERSE_OBJECT_PROPERTY_EXPRESSION
                                || LA5_0 == CONSTANT || LA5_0 == DATA_RANGE
                                || LA5_0 == IRI) {
                            alt5 = 1;
                        }
                        switch (alt5) {
                            case 1:
                            // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxTypes.g:226:34:
                            // chainItems+= expression
                            {
                                pushFollow(FOLLOW_expression_in_expression872);
                                chainItems = expression();
                                state._fsp--;
                                if (state.failed) {
                                    return retval;
                                }
                                if (list_chainItems == null) {
                                    list_chainItems = new ArrayList();
                                }
                                list_chainItems.add(chainItems);
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
                    if (state.backtracking == 1) {
                        List<ManchesterOWLSyntaxTree> nodes = new ArrayList<ManchesterOWLSyntaxTree>(
                                list_chainItems.size());
                        for (Object item : list_chainItems) {
                            nodes.add(((expression_return) item).node);
                        }
                        retval.type = getSymbolTable().getPropertyChainType(
                                (ManchesterOWLSyntaxTree) retval.start,
                                nodes.toArray(new ManchesterOWLSyntaxTree[nodes.size()]));
                        retval.owlObject = getSymbolTable().getPropertyChain(
                                (ManchesterOWLSyntaxTree) retval.start,
                                nodes.toArray(new ManchesterOWLSyntaxTree[nodes.size()]));
                    }
                }
                    break;
                case 3:
                // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxTypes.g:235:5:
                // conjunction
                {
                    pushFollow(FOLLOW_conjunction_in_expression886);
                    conjunction4 = conjunction();
                    state._fsp--;
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 1) {
                        retval.type = conjunction4 != null ? conjunction4.type : null;
                        retval.owlObject = conjunction4 != null ? conjunction4.owlObject
                                : null;
                    }
                }
                    break;
                case 4:
                // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxTypes.g:240:5:
                // complexPropertyExpression
                {
                    pushFollow(FOLLOW_complexPropertyExpression_in_expression898);
                    complexPropertyExpression5 = complexPropertyExpression();
                    state._fsp--;
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 1) {
                        retval.type = complexPropertyExpression5 != null ? complexPropertyExpression5.type
                                : null;
                        retval.owlObject = complexPropertyExpression5 != null ? complexPropertyExpression5.owlObject
                                : null;
                    }
                }
                    break;
            }
            if (state.backtracking == 1) {
                ((ManchesterOWLSyntaxTree) retval.start).setEvalType(retval.type);
                retval.node = (ManchesterOWLSyntaxTree) retval.start;
                ((ManchesterOWLSyntaxTree) retval.start).setOWLObject(retval.owlObject);
            }
        } catch (RecognitionException exception) {
            if (errorListener != null) {
                errorListener.recognitionException(exception);
            }
        } catch (RewriteEmptyStreamException exception) {
            if (errorListener != null) {
                errorListener.rewriteEmptyStreamException(exception);
            }
        } finally {}
        return retval;
    }

    // $ANTLR end "expression"
    public static class conjunction_return extends TreeRuleReturnScope {
        public Type type;
        public ManchesterOWLSyntaxTree node;
        public OWLObject owlObject;
    };

    // $ANTLR start "conjunction"
    // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxTypes.g:248:1:
    // conjunction returns [Type type, ManchesterOWLSyntaxTree node, OWLObject
    // owlObject] : ( ^( CONJUNCTION (conjuncts+= unary )+ ) | unary );
    public final ManchesterOWLSyntaxTypes.conjunction_return conjunction()
            throws RecognitionException {
        ManchesterOWLSyntaxTypes.conjunction_return retval = new ManchesterOWLSyntaxTypes.conjunction_return();
        retval.start = input.LT(1);
        List list_conjuncts = null;
        ManchesterOWLSyntaxTypes.unary_return unary6 = null;
        RuleReturnScope conjuncts = null;
        try {
            // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxTypes.g:255:2:
            // ( ^( CONJUNCTION (conjuncts+= unary )+ ) | unary )
            int alt8 = 2;
            int LA8_0 = input.LA(1);
            if (LA8_0 == CONJUNCTION) {
                alt8 = 1;
            } else if (LA8_0 >= IDENTIFIER && LA8_0 <= ENTITY_REFERENCE
                    || LA8_0 == NEGATED_EXPRESSION || LA8_0 >= SOME_RESTRICTION
                    && LA8_0 <= ONE_OF || LA8_0 == CONSTANT || LA8_0 == DATA_RANGE
                    || LA8_0 == IRI) {
                alt8 = 2;
            } else {
                if (state.backtracking > 0) {
                    state.failed = true;
                    return retval;
                }
                NoViableAltException nvae = new NoViableAltException("", 8, 0, input);
                throw nvae;
            }
            switch (alt8) {
                case 1:
                // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxTypes.g:256:2:
                // ^( CONJUNCTION (conjuncts+= unary )+ )
                {
                    match(input, CONJUNCTION, FOLLOW_CONJUNCTION_in_conjunction935);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.DOWN, null);
                    if (state.failed) {
                        return retval;
                    }
                    // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxTypes.g:256:26:
                    // (conjuncts+= unary )+
                    int cnt7 = 0;
                    loop7: do {
                        int alt7 = 2;
                        int LA7_0 = input.LA(1);
                        if (LA7_0 >= IDENTIFIER && LA7_0 <= ENTITY_REFERENCE
                                || LA7_0 == NEGATED_EXPRESSION
                                || LA7_0 >= SOME_RESTRICTION && LA7_0 <= ONE_OF
                                || LA7_0 == CONSTANT || LA7_0 == DATA_RANGE
                                || LA7_0 == IRI) {
                            alt7 = 1;
                        }
                        switch (alt7) {
                            case 1:
                            // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxTypes.g:256:26:
                            // conjuncts+= unary
                            {
                                pushFollow(FOLLOW_unary_in_conjunction940);
                                conjuncts = unary();
                                state._fsp--;
                                if (state.failed) {
                                    return retval;
                                }
                                if (list_conjuncts == null) {
                                    list_conjuncts = new ArrayList();
                                }
                                list_conjuncts.add(conjuncts);
                            }
                                break;
                            default:
                                if (cnt7 >= 1) {
                                    break loop7;
                                }
                                if (state.backtracking > 0) {
                                    state.failed = true;
                                    return retval;
                                }
                                EarlyExitException eee = new EarlyExitException(7, input);
                                throw eee;
                        }
                        cnt7++;
                    } while (true);
                    match(input, Token.UP, null);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 1) {
                        List<ManchesterOWLSyntaxTree> nodes = new ArrayList<ManchesterOWLSyntaxTree>(
                                list_conjuncts.size());
                        for (Object node : list_conjuncts) {
                            nodes.add(((unary_return) node).node);
                        }
                        retval.type = getSymbolTable().getConjunctionType(
                                (ManchesterOWLSyntaxTree) retval.start,
                                nodes.toArray(new ManchesterOWLSyntaxTree[nodes.size()]));
                        retval.owlObject = getSymbolTable().getConjunction(
                                (ManchesterOWLSyntaxTree) retval.start,
                                nodes.toArray(new ManchesterOWLSyntaxTree[nodes.size()]));
                    }
                }
                    break;
                case 2:
                // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxTypes.g:265:4:
                // unary
                {
                    pushFollow(FOLLOW_unary_in_conjunction951);
                    unary6 = unary();
                    state._fsp--;
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 1) {
                        retval.type = unary6 != null ? unary6.type : null;
                        retval.owlObject = unary6 != null ? unary6.owlObject : null;
                    }
                }
                    break;
            }
            if (state.backtracking == 1) {
                ((ManchesterOWLSyntaxTree) retval.start).setEvalType(retval.type);
                retval.node = (ManchesterOWLSyntaxTree) retval.start;
                ((ManchesterOWLSyntaxTree) retval.start).setOWLObject(retval.owlObject);
            }
        } catch (RecognitionException exception) {
            if (errorListener != null) {
                errorListener.recognitionException(exception);
            }
        } catch (RewriteEmptyStreamException exception) {
            if (errorListener != null) {
                errorListener.rewriteEmptyStreamException(exception);
            }
        } finally {}
        return retval;
    }

    // $ANTLR end "conjunction"
    public static class unary_return extends TreeRuleReturnScope {
        public Type type;
        public ManchesterOWLSyntaxTree node;
        public OWLObject owlObject;
    };

    // $ANTLR start "unary"
    // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxTypes.g:271:1:
    // unary returns [Type type, ManchesterOWLSyntaxTree node, OWLObject
    // owlObject] : ( IDENTIFIER | ^( NEGATED_EXPRESSION e= expression ) |
    // qualifiedRestriction | ENTITY_REFERENCE | IRI | ^( CONSTANT value= . ( ^(
    // AT language= IDENTIFIER ) )? (constantType= IDENTIFIER )? ) | dataRange
    // );
    public final ManchesterOWLSyntaxTypes.unary_return unary()
            throws RecognitionException {
        ManchesterOWLSyntaxTypes.unary_return retval = new ManchesterOWLSyntaxTypes.unary_return();
        retval.start = input.LT(1);
        ManchesterOWLSyntaxTree language = null;
        ManchesterOWLSyntaxTree constantType = null;
        ManchesterOWLSyntaxTree IDENTIFIER7 = null;
        ManchesterOWLSyntaxTree ENTITY_REFERENCE9 = null;
        ManchesterOWLSyntaxTree IRI10 = null;
        ManchesterOWLSyntaxTree value = null;
        ManchesterOWLSyntaxTypes.expression_return e = null;
        ManchesterOWLSyntaxTypes.qualifiedRestriction_return qualifiedRestriction8 = null;
        ManchesterOWLSyntaxTypes.dataRange_return dataRange11 = null;
        try {
            // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxTypes.g:278:1:
            // ( IDENTIFIER | ^( NEGATED_EXPRESSION e= expression ) |
            // qualifiedRestriction | ENTITY_REFERENCE | IRI | ^( CONSTANT
            // value= . ( ^( AT language= IDENTIFIER ) )? (constantType=
            // IDENTIFIER )? ) | dataRange )
            int alt11 = 7;
            switch (input.LA(1)) {
                case IDENTIFIER: {
                    alt11 = 1;
                }
                    break;
                case NEGATED_EXPRESSION: {
                    alt11 = 2;
                }
                    break;
                case SOME_RESTRICTION:
                case ALL_RESTRICTION:
                case VALUE_RESTRICTION:
                case CARDINALITY_RESTRICTION:
                case ONE_OF: {
                    alt11 = 3;
                }
                    break;
                case ENTITY_REFERENCE: {
                    alt11 = 4;
                }
                    break;
                case IRI: {
                    alt11 = 5;
                }
                    break;
                case CONSTANT: {
                    alt11 = 6;
                }
                    break;
                case DATA_RANGE: {
                    alt11 = 7;
                }
                    break;
                default:
                    if (state.backtracking > 0) {
                        state.failed = true;
                        return retval;
                    }
                    NoViableAltException nvae = new NoViableAltException("", 11, 0, input);
                    throw nvae;
            }
            switch (alt11) {
                case 1:
                // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxTypes.g:279:3:
                // IDENTIFIER
                {
                    IDENTIFIER7 = (ManchesterOWLSyntaxTree) match(input, IDENTIFIER,
                            FOLLOW_IDENTIFIER_in_unary978);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 1) {
                        Symbol symbol = getSymbolTable().resolve(IDENTIFIER7);
                        retval.type = symbol == null ? null : symbol.getType();
                        retval.owlObject = getSymbolTable().getOWLObject(IDENTIFIER7);
                    }
                }
                    break;
                case 2:
                // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxTypes.g:285:5:
                // ^( NEGATED_EXPRESSION e= expression )
                {
                    match(input, NEGATED_EXPRESSION,
                            FOLLOW_NEGATED_EXPRESSION_in_unary991);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.DOWN, null);
                    if (state.failed) {
                        return retval;
                    }
                    pushFollow(FOLLOW_expression_in_unary997);
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
                                (ManchesterOWLSyntaxTree) retval.start, e.node);
                        retval.owlObject = getSymbolTable().getNegatedClassExpression(
                                (ManchesterOWLSyntaxTree) retval.start, e.node);
                    }
                }
                    break;
                case 3:
                // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxTypes.g:290:5:
                // qualifiedRestriction
                {
                    pushFollow(FOLLOW_qualifiedRestriction_in_unary1011);
                    qualifiedRestriction8 = qualifiedRestriction();
                    state._fsp--;
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 1) {
                        retval.type = qualifiedRestriction8 != null ? qualifiedRestriction8.type
                                : null;
                        retval.owlObject = qualifiedRestriction8 != null ? qualifiedRestriction8.owlObject
                                : null;
                    }
                }
                    break;
                case 4:
                // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxTypes.g:295:5:
                // ENTITY_REFERENCE
                {
                    ENTITY_REFERENCE9 = (ManchesterOWLSyntaxTree) match(input,
                            ENTITY_REFERENCE, FOLLOW_ENTITY_REFERENCE_in_unary1025);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 1) {
                        Symbol symbol = getSymbolTable().resolve(ENTITY_REFERENCE9);
                        retval.type = symbol == null ? null : symbol.getType();
                        retval.owlObject = getSymbolTable().getOWLObject(
                                ENTITY_REFERENCE9);
                    }
                }
                    break;
                case 5:
                // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxTypes.g:301:5:
                // IRI
                {
                    IRI10 = (ManchesterOWLSyntaxTree) match(input, IRI,
                            FOLLOW_IRI_in_unary1037);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 1) {
                        Symbol symbol = getSymbolTable().resolveIRI(IRI10);
                        retval.type = symbol == null ? null : symbol.getType();
                        retval.owlObject = getSymbolTable().getOWLObject(IRI10);
                    }
                }
                    break;
                case 6:
                // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxTypes.g:308:5:
                // ^( CONSTANT value= . ( ^( AT language= IDENTIFIER ) )?
                // (constantType= IDENTIFIER )? )
                {
                    match(input, CONSTANT, FOLLOW_CONSTANT_in_unary1049);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.DOWN, null);
                    if (state.failed) {
                        return retval;
                    }
                    value = (ManchesterOWLSyntaxTree) input.LT(1);
                    matchAny(input);
                    if (state.failed) {
                        return retval;
                    }
                    // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxTypes.g:308:25:
                    // ( ^( AT language= IDENTIFIER ) )?
                    int alt9 = 2;
                    int LA9_0 = input.LA(1);
                    if (LA9_0 == AT) {
                        alt9 = 1;
                    }
                    switch (alt9) {
                        case 1:
                        // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxTypes.g:308:27:
                        // ^( AT language= IDENTIFIER )
                        {
                            match(input, AT, FOLLOW_AT_in_unary1059);
                            if (state.failed) {
                                return retval;
                            }
                            match(input, Token.DOWN, null);
                            if (state.failed) {
                                return retval;
                            }
                            language = (ManchesterOWLSyntaxTree) match(input, IDENTIFIER,
                                    FOLLOW_IDENTIFIER_in_unary1065);
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
                    // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxTypes.g:308:70:
                    // (constantType= IDENTIFIER )?
                    int alt10 = 2;
                    int LA10_0 = input.LA(1);
                    if (LA10_0 == IDENTIFIER) {
                        alt10 = 1;
                    }
                    switch (alt10) {
                        case 1:
                        // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxTypes.g:308:70:
                        // constantType= IDENTIFIER
                        {
                            constantType = (ManchesterOWLSyntaxTree) match(input,
                                    IDENTIFIER, FOLLOW_IDENTIFIER_in_unary1074);
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
                        retval.owlObject = constantType == null ? getSymbolTable()
                                .getOWLUntypedConstant(
                                        (ManchesterOWLSyntaxTree) retval.start, value,
                                        language) : getSymbolTable().getOWLTypedConstant(
                                (ManchesterOWLSyntaxTree) retval.start, value,
                                constantType);
                    }
                }
                    break;
                case 7:
                // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxTypes.g:312:5:
                // dataRange
                {
                    pushFollow(FOLLOW_dataRange_in_unary1084);
                    dataRange11 = dataRange();
                    state._fsp--;
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 1) {
                        retval.type = dataRange11 != null ? dataRange11.type : null;
                        retval.owlObject = dataRange11 != null ? dataRange11.owlObject
                                : null;
                    }
                }
                    break;
            }
            if (state.backtracking == 1) {
                ((ManchesterOWLSyntaxTree) retval.start).setEvalType(retval.type);
                retval.node = (ManchesterOWLSyntaxTree) retval.start;
                ((ManchesterOWLSyntaxTree) retval.start).setOWLObject(retval.owlObject);
            }
        } catch (RecognitionException exception) {
            if (errorListener != null) {
                errorListener.recognitionException(exception);
            }
        } catch (RewriteEmptyStreamException exception) {
            if (errorListener != null) {
                errorListener.rewriteEmptyStreamException(exception);
            }
        } finally {}
        return retval;
    }

    // $ANTLR end "unary"
    public static class dataRange_return extends TreeRuleReturnScope {
        public Type type;
        public ManchesterOWLSyntaxTree node;
        public OWLObject owlObject;
    };

    // $ANTLR start "dataRange"
    // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxTypes.g:318:1:
    // dataRange returns [Type type, ManchesterOWLSyntaxTree node, OWLObject
    // owlObject] : ^( DATA_RANGE dataType= unary (f= facet )* ) ;
    public final ManchesterOWLSyntaxTypes.dataRange_return dataRange()
            throws RecognitionException {
        ManchesterOWLSyntaxTypes.dataRange_return retval = new ManchesterOWLSyntaxTypes.dataRange_return();
        retval.start = input.LT(1);
        ManchesterOWLSyntaxTypes.unary_return dataType = null;
        ManchesterOWLSyntaxTypes.facet_return f = null;
        List<ManchesterOWLSyntaxTree> facets = new ArrayList<ManchesterOWLSyntaxTree>();
        try {
            // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxTypes.g:329:2:
            // ( ^( DATA_RANGE dataType= unary (f= facet )* ) )
            // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxTypes.g:331:3:
            // ^( DATA_RANGE dataType= unary (f= facet )* )
            {
                match(input, DATA_RANGE, FOLLOW_DATA_RANGE_in_dataRange1121);
                if (state.failed) {
                    return retval;
                }
                match(input, Token.DOWN, null);
                if (state.failed) {
                    return retval;
                }
                pushFollow(FOLLOW_unary_in_dataRange1127);
                dataType = unary();
                state._fsp--;
                if (state.failed) {
                    return retval;
                }
                // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxTypes.g:331:33:
                // (f= facet )*
                loop12: do {
                    int alt12 = 2;
                    int LA12_0 = input.LA(1);
                    if (LA12_0 >= LESS_THAN && LA12_0 <= GREATER_THAN_EQUAL) {
                        alt12 = 1;
                    }
                    switch (alt12) {
                        case 1:
                        // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxTypes.g:331:34:
                        // f= facet
                        {
                            pushFollow(FOLLOW_facet_in_dataRange1132);
                            f = facet();
                            state._fsp--;
                            if (state.failed) {
                                return retval;
                            }
                            if (state.backtracking == 1) {
                                facets.add(f.node);
                            }
                        }
                            break;
                        default:
                            break loop12;
                    }
                } while (true);
                match(input, Token.UP, null);
                if (state.failed) {
                    return retval;
                }
                if (state.backtracking == 1) {
                    retval.type = getSymbolTable().getOWLDataRangeType(
                            dataType != null ? dataType.node : null,
                            (ManchesterOWLSyntaxTree) retval.start,
                            facets.toArray(new ManchesterOWLSyntaxTree[facets.size()]));
                    retval.owlObject = getSymbolTable().getOWLDataRange(
                            dataType != null ? dataType.node : null,
                            (ManchesterOWLSyntaxTree) retval.start,
                            facets.toArray(new ManchesterOWLSyntaxTree[facets.size()]));
                }
            }
            if (state.backtracking == 1) {
                ((ManchesterOWLSyntaxTree) retval.start).setEvalType(retval.type);
                retval.node = (ManchesterOWLSyntaxTree) retval.start;
                ((ManchesterOWLSyntaxTree) retval.start).setOWLObject(retval.owlObject);
            }
        } catch (RecognitionException exception) {
            if (errorListener != null) {
                errorListener.recognitionException(exception);
            }
        } catch (RewriteEmptyStreamException exception) {
            if (errorListener != null) {
                errorListener.rewriteEmptyStreamException(exception);
            }
        } finally {}
        return retval;
    }

    // $ANTLR end "dataRange"
    public static class facet_return extends TreeRuleReturnScope {
        public Type type;
        public ManchesterOWLSyntaxTree node;
        public OWLObject owlObject;
    };

    // $ANTLR start "facet"
    // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxTypes.g:342:1:
    // facet returns [Type type, ManchesterOWLSyntaxTree node, OWLObject
    // owlObject] : ( ^(f= LESS_THAN value= unary ) | ^(f= LESS_THAN_EQUAL
    // value= unary ) | ^(f= GREATER_THAN value= unary ) | ^(f=
    // GREATER_THAN_EQUAL value= unary ) );
    public final ManchesterOWLSyntaxTypes.facet_return facet()
            throws RecognitionException {
        ManchesterOWLSyntaxTypes.facet_return retval = new ManchesterOWLSyntaxTypes.facet_return();
        retval.start = input.LT(1);
        ManchesterOWLSyntaxTree f = null;
        ManchesterOWLSyntaxTypes.unary_return value = null;
        try {
            // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxTypes.g:351:2:
            // ( ^(f= LESS_THAN value= unary ) | ^(f= LESS_THAN_EQUAL value=
            // unary ) | ^(f= GREATER_THAN value= unary ) | ^(f=
            // GREATER_THAN_EQUAL value= unary ) )
            int alt13 = 4;
            switch (input.LA(1)) {
                case LESS_THAN: {
                    alt13 = 1;
                }
                    break;
                case LESS_THAN_EQUAL: {
                    alt13 = 2;
                }
                    break;
                case GREATER_THAN: {
                    alt13 = 3;
                }
                    break;
                case GREATER_THAN_EQUAL: {
                    alt13 = 4;
                }
                    break;
                default:
                    if (state.backtracking > 0) {
                        state.failed = true;
                        return retval;
                    }
                    NoViableAltException nvae = new NoViableAltException("", 13, 0, input);
                    throw nvae;
            }
            switch (alt13) {
                case 1:
                // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxTypes.g:352:3:
                // ^(f= LESS_THAN value= unary )
                {
                    f = (ManchesterOWLSyntaxTree) match(input, LESS_THAN,
                            FOLLOW_LESS_THAN_in_facet1175);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.DOWN, null);
                    if (state.failed) {
                        return retval;
                    }
                    pushFollow(FOLLOW_unary_in_facet1181);
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
                        retval.type = getSymbolTable().getOWLFacetRestrictionType(f,
                                value != null ? value.node : null,
                                (ManchesterOWLSyntaxTree) retval.start);
                        retval.owlObject = getSymbolTable().getOWLFacetRestriction(f,
                                value != null ? value.node : null,
                                (ManchesterOWLSyntaxTree) retval.start);
                    }
                }
                    break;
                case 2:
                // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxTypes.g:356:5:
                // ^(f= LESS_THAN_EQUAL value= unary )
                {
                    f = (ManchesterOWLSyntaxTree) match(input, LESS_THAN_EQUAL,
                            FOLLOW_LESS_THAN_EQUAL_in_facet1193);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.DOWN, null);
                    if (state.failed) {
                        return retval;
                    }
                    pushFollow(FOLLOW_unary_in_facet1199);
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
                        retval.type = getSymbolTable().getOWLFacetRestrictionType(f,
                                value != null ? value.node : null,
                                (ManchesterOWLSyntaxTree) retval.start);
                        retval.owlObject = getSymbolTable().getOWLFacetRestriction(f,
                                value != null ? value.node : null,
                                (ManchesterOWLSyntaxTree) retval.start);
                    }
                }
                    break;
                case 3:
                // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxTypes.g:359:5:
                // ^(f= GREATER_THAN value= unary )
                {
                    f = (ManchesterOWLSyntaxTree) match(input, GREATER_THAN,
                            FOLLOW_GREATER_THAN_in_facet1212);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.DOWN, null);
                    if (state.failed) {
                        return retval;
                    }
                    pushFollow(FOLLOW_unary_in_facet1218);
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
                        retval.type = getSymbolTable().getOWLFacetRestrictionType(f,
                                value != null ? value.node : null,
                                (ManchesterOWLSyntaxTree) retval.start);
                        retval.owlObject = getSymbolTable().getOWLFacetRestriction(f,
                                value != null ? value.node : null,
                                (ManchesterOWLSyntaxTree) retval.start);
                    }
                }
                    break;
                case 4:
                // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxTypes.g:363:5:
                // ^(f= GREATER_THAN_EQUAL value= unary )
                {
                    f = (ManchesterOWLSyntaxTree) match(input, GREATER_THAN_EQUAL,
                            FOLLOW_GREATER_THAN_EQUAL_in_facet1231);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.DOWN, null);
                    if (state.failed) {
                        return retval;
                    }
                    pushFollow(FOLLOW_unary_in_facet1237);
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
                        retval.type = getSymbolTable().getOWLFacetRestrictionType(f,
                                value != null ? value.node : null,
                                (ManchesterOWLSyntaxTree) retval.start);
                        retval.owlObject = getSymbolTable().getOWLFacetRestriction(f,
                                value != null ? value.node : null,
                                (ManchesterOWLSyntaxTree) retval.start);
                    }
                }
                    break;
            }
            if (state.backtracking == 1) {
                ((ManchesterOWLSyntaxTree) retval.start).setEvalType(retval.type);
                retval.node = (ManchesterOWLSyntaxTree) retval.start;
                ((ManchesterOWLSyntaxTree) retval.start).setOWLObject(retval.owlObject);
            }
        } catch (RecognitionException exception) {
            if (errorListener != null) {
                errorListener.recognitionException(exception);
            }
        } catch (RewriteEmptyStreamException exception) {
            if (errorListener != null) {
                errorListener.rewriteEmptyStreamException(exception);
            }
        } finally {}
        return retval;
    }

    // $ANTLR end "facet"
    public static class propertyExpression_return extends TreeRuleReturnScope {
        public Type type;
        public ManchesterOWLSyntaxTree node;
        public OWLObject owlObject;
    };

    // $ANTLR start "propertyExpression"
    // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxTypes.g:372:1:
    // propertyExpression returns [Type type, ManchesterOWLSyntaxTree node,
    // OWLObject owlObject] : ( IDENTIFIER | ENTITY_REFERENCE |
    // complexPropertyExpression );
    public final ManchesterOWLSyntaxTypes.propertyExpression_return propertyExpression()
            throws RecognitionException {
        ManchesterOWLSyntaxTypes.propertyExpression_return retval = new ManchesterOWLSyntaxTypes.propertyExpression_return();
        retval.start = input.LT(1);
        ManchesterOWLSyntaxTree IDENTIFIER12 = null;
        ManchesterOWLSyntaxTree ENTITY_REFERENCE13 = null;
        ManchesterOWLSyntaxTypes.complexPropertyExpression_return complexPropertyExpression14 = null;
        try {
            // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxTypes.g:380:1:
            // ( IDENTIFIER | ENTITY_REFERENCE | complexPropertyExpression )
            int alt14 = 3;
            switch (input.LA(1)) {
                case IDENTIFIER: {
                    alt14 = 1;
                }
                    break;
                case ENTITY_REFERENCE: {
                    alt14 = 2;
                }
                    break;
                case INVERSE_OBJECT_PROPERTY_EXPRESSION: {
                    alt14 = 3;
                }
                    break;
                default:
                    if (state.backtracking > 0) {
                        state.failed = true;
                        return retval;
                    }
                    NoViableAltException nvae = new NoViableAltException("", 14, 0, input);
                    throw nvae;
            }
            switch (alt14) {
                case 1:
                // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxTypes.g:381:7:
                // IDENTIFIER
                {
                    IDENTIFIER12 = (ManchesterOWLSyntaxTree) match(input, IDENTIFIER,
                            FOLLOW_IDENTIFIER_in_propertyExpression1276);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 1) {
                        Symbol symbol = getSymbolTable().resolve(IDENTIFIER12);
                        retval.type = symbol == null ? null : symbol.getType();
                        retval.owlObject = getSymbolTable().getOWLObject(IDENTIFIER12);
                    }
                }
                    break;
                case 2:
                // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxTypes.g:387:9:
                // ENTITY_REFERENCE
                {
                    ENTITY_REFERENCE13 = (ManchesterOWLSyntaxTree) match(input,
                            ENTITY_REFERENCE,
                            FOLLOW_ENTITY_REFERENCE_in_propertyExpression1294);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 1) {
                        Symbol symbol = getSymbolTable().resolve(ENTITY_REFERENCE13);
                        retval.type = symbol == null ? null : symbol.getType();
                        retval.owlObject = getSymbolTable().getOWLObject(
                                ENTITY_REFERENCE13);
                    }
                }
                    break;
                case 3:
                // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxTypes.g:393:7:
                // complexPropertyExpression
                {
                    pushFollow(FOLLOW_complexPropertyExpression_in_propertyExpression1308);
                    complexPropertyExpression14 = complexPropertyExpression();
                    state._fsp--;
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 1) {
                        retval.type = complexPropertyExpression14 != null ? complexPropertyExpression14.type
                                : null;
                        retval.owlObject = complexPropertyExpression14 != null ? complexPropertyExpression14.owlObject
                                : null;
                    }
                }
                    break;
            }
            if (state.backtracking == 1) {
                ((ManchesterOWLSyntaxTree) retval.start).setEvalType(retval.type);
                retval.node = (ManchesterOWLSyntaxTree) retval.start;
                ((ManchesterOWLSyntaxTree) retval.start).setOWLObject(retval.owlObject);
            }
        } catch (RecognitionException exception) {
            if (errorListener != null) {
                errorListener.recognitionException(exception);
            }
        } catch (RewriteEmptyStreamException exception) {
            if (errorListener != null) {
                errorListener.rewriteEmptyStreamException(exception);
            }
        } finally {}
        return retval;
    }

    // $ANTLR end "propertyExpression"
    public static class complexPropertyExpression_return extends TreeRuleReturnScope {
        public Type type;
        public ManchesterOWLSyntaxTree node;
        public OWLObject owlObject;
    };

    // $ANTLR start "complexPropertyExpression"
    // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxTypes.g:400:1:
    // complexPropertyExpression returns [Type type, ManchesterOWLSyntaxTree
    // node, OWLObject owlObject] : ( ^( INVERSE_OBJECT_PROPERTY_EXPRESSION p=
    // complexPropertyExpression ) | ^( INVERSE_OBJECT_PROPERTY_EXPRESSION
    // IDENTIFIER ) | ^( INVERSE_OBJECT_PROPERTY_EXPRESSION ENTITY_REFERENCE )
    // );
    public final ManchesterOWLSyntaxTypes.complexPropertyExpression_return
            complexPropertyExpression() throws RecognitionException {
        ManchesterOWLSyntaxTypes.complexPropertyExpression_return retval = new ManchesterOWLSyntaxTypes.complexPropertyExpression_return();
        retval.start = input.LT(1);
        ManchesterOWLSyntaxTree IDENTIFIER15 = null;
        ManchesterOWLSyntaxTree ENTITY_REFERENCE16 = null;
        ManchesterOWLSyntaxTypes.complexPropertyExpression_return p = null;
        try {
            // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxTypes.g:407:1:
            // ( ^( INVERSE_OBJECT_PROPERTY_EXPRESSION p=
            // complexPropertyExpression ) | ^(
            // INVERSE_OBJECT_PROPERTY_EXPRESSION IDENTIFIER ) | ^(
            // INVERSE_OBJECT_PROPERTY_EXPRESSION ENTITY_REFERENCE ) )
            int alt15 = 3;
            int LA15_0 = input.LA(1);
            if (LA15_0 == INVERSE_OBJECT_PROPERTY_EXPRESSION) {
                int LA15_1 = input.LA(2);
                if (LA15_1 == DOWN) {
                    switch (input.LA(3)) {
                        case IDENTIFIER: {
                            alt15 = 2;
                        }
                            break;
                        case ENTITY_REFERENCE: {
                            alt15 = 3;
                        }
                            break;
                        case INVERSE_OBJECT_PROPERTY_EXPRESSION: {
                            alt15 = 1;
                        }
                            break;
                        default:
                            if (state.backtracking > 0) {
                                state.failed = true;
                                return retval;
                            }
                            NoViableAltException nvae = new NoViableAltException("", 15,
                                    2, input);
                            throw nvae;
                    }
                } else {
                    if (state.backtracking > 0) {
                        state.failed = true;
                        return retval;
                    }
                    NoViableAltException nvae = new NoViableAltException("", 15, 1, input);
                    throw nvae;
                }
            } else {
                if (state.backtracking > 0) {
                    state.failed = true;
                    return retval;
                }
                NoViableAltException nvae = new NoViableAltException("", 15, 0, input);
                throw nvae;
            }
            switch (alt15) {
                case 1:
                // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxTypes.g:408:2:
                // ^( INVERSE_OBJECT_PROPERTY_EXPRESSION p=
                // complexPropertyExpression )
                {
                    match(input, INVERSE_OBJECT_PROPERTY_EXPRESSION,
                            FOLLOW_INVERSE_OBJECT_PROPERTY_EXPRESSION_in_complexPropertyExpression1341);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.DOWN, null);
                    if (state.failed) {
                        return retval;
                    }
                    pushFollow(FOLLOW_complexPropertyExpression_in_complexPropertyExpression1347);
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
                                (ManchesterOWLSyntaxTree) retval.start, p.node);
                        retval.owlObject = getSymbolTable().getInverseProperty(
                                (ManchesterOWLSyntaxTree) retval.start, p.node);
                    }
                }
                    break;
                case 2:
                // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxTypes.g:413:4:
                // ^( INVERSE_OBJECT_PROPERTY_EXPRESSION IDENTIFIER )
                {
                    match(input, INVERSE_OBJECT_PROPERTY_EXPRESSION,
                            FOLLOW_INVERSE_OBJECT_PROPERTY_EXPRESSION_in_complexPropertyExpression1357);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.DOWN, null);
                    if (state.failed) {
                        return retval;
                    }
                    IDENTIFIER15 = (ManchesterOWLSyntaxTree) match(input, IDENTIFIER,
                            FOLLOW_IDENTIFIER_in_complexPropertyExpression1359);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.UP, null);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 1) {
                        Symbol symbol = getSymbolTable().resolve(IDENTIFIER15);
                        retval.type = getSymbolTable().getInversePropertyType(
                                (ManchesterOWLSyntaxTree) retval.start, IDENTIFIER15);
                        retval.owlObject = getSymbolTable().getInverseProperty(
                                (ManchesterOWLSyntaxTree) retval.start, IDENTIFIER15);
                    }
                }
                    break;
                case 3:
                // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxTypes.g:419:4:
                // ^( INVERSE_OBJECT_PROPERTY_EXPRESSION ENTITY_REFERENCE )
                {
                    match(input, INVERSE_OBJECT_PROPERTY_EXPRESSION,
                            FOLLOW_INVERSE_OBJECT_PROPERTY_EXPRESSION_in_complexPropertyExpression1369);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.DOWN, null);
                    if (state.failed) {
                        return retval;
                    }
                    ENTITY_REFERENCE16 = (ManchesterOWLSyntaxTree) match(input,
                            ENTITY_REFERENCE,
                            FOLLOW_ENTITY_REFERENCE_in_complexPropertyExpression1371);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.UP, null);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 1) {
                        Symbol symbol = getSymbolTable().resolve(ENTITY_REFERENCE16);
                        retval.type = getSymbolTable().getInversePropertyType(
                                (ManchesterOWLSyntaxTree) retval.start,
                                ENTITY_REFERENCE16);
                        retval.owlObject = getSymbolTable().getInverseProperty(
                                (ManchesterOWLSyntaxTree) retval.start,
                                ENTITY_REFERENCE16);
                    }
                }
                    break;
            }
            if (state.backtracking == 1) {
                ((ManchesterOWLSyntaxTree) retval.start).setEvalType(retval.type);
                retval.node = (ManchesterOWLSyntaxTree) retval.start;
                ((ManchesterOWLSyntaxTree) retval.start).setOWLObject(retval.owlObject);
            }
        } catch (RecognitionException exception) {
            if (errorListener != null) {
                errorListener.recognitionException(exception);
            }
        } catch (RewriteEmptyStreamException exception) {
            if (errorListener != null) {
                errorListener.rewriteEmptyStreamException(exception);
            }
        } finally {}
        return retval;
    }

    // $ANTLR end "complexPropertyExpression"
    public static class qualifiedRestriction_return extends TreeRuleReturnScope {
        public Type type;
        public ManchesterOWLSyntaxTree node;
        public OWLObject owlObject;
    };

    // $ANTLR start "qualifiedRestriction"
    // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxTypes.g:427:1:
    // qualifiedRestriction returns [Type type , ManchesterOWLSyntaxTree node,
    // OWLObject owlObject] : ( ^( SOME_RESTRICTION p= propertyExpression f=
    // expression ) | ^( ALL_RESTRICTION p= propertyExpression f= expression ) |
    // cardinalityRestriction | oneOf | valueRestriction );
    public final ManchesterOWLSyntaxTypes.qualifiedRestriction_return
            qualifiedRestriction() throws RecognitionException {
        ManchesterOWLSyntaxTypes.qualifiedRestriction_return retval = new ManchesterOWLSyntaxTypes.qualifiedRestriction_return();
        retval.start = input.LT(1);
        ManchesterOWLSyntaxTypes.propertyExpression_return p = null;
        ManchesterOWLSyntaxTypes.expression_return f = null;
        ManchesterOWLSyntaxTypes.cardinalityRestriction_return cardinalityRestriction17 = null;
        ManchesterOWLSyntaxTypes.oneOf_return oneOf18 = null;
        ManchesterOWLSyntaxTypes.valueRestriction_return valueRestriction19 = null;
        try {
            // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxTypes.g:433:2:
            // ( ^( SOME_RESTRICTION p= propertyExpression f= expression ) | ^(
            // ALL_RESTRICTION p= propertyExpression f= expression ) |
            // cardinalityRestriction | oneOf | valueRestriction )
            int alt16 = 5;
            switch (input.LA(1)) {
                case SOME_RESTRICTION: {
                    alt16 = 1;
                }
                    break;
                case ALL_RESTRICTION: {
                    alt16 = 2;
                }
                    break;
                case CARDINALITY_RESTRICTION: {
                    alt16 = 3;
                }
                    break;
                case ONE_OF: {
                    alt16 = 4;
                }
                    break;
                case VALUE_RESTRICTION: {
                    alt16 = 5;
                }
                    break;
                default:
                    if (state.backtracking > 0) {
                        state.failed = true;
                        return retval;
                    }
                    NoViableAltException nvae = new NoViableAltException("", 16, 0, input);
                    throw nvae;
            }
            switch (alt16) {
                case 1:
                // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxTypes.g:434:6:
                // ^( SOME_RESTRICTION p= propertyExpression f= expression )
                {
                    match(input, SOME_RESTRICTION,
                            FOLLOW_SOME_RESTRICTION_in_qualifiedRestriction1402);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.DOWN, null);
                    if (state.failed) {
                        return retval;
                    }
                    pushFollow(FOLLOW_propertyExpression_in_qualifiedRestriction1407);
                    p = propertyExpression();
                    state._fsp--;
                    if (state.failed) {
                        return retval;
                    }
                    pushFollow(FOLLOW_expression_in_qualifiedRestriction1413);
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
                                (ManchesterOWLSyntaxTree) retval.start, p.node, f.node);
                        retval.owlObject = getSymbolTable().getSomeValueRestriction(
                                (ManchesterOWLSyntaxTree) retval.start, p.node, f.node);
                    }
                }
                    break;
                case 2:
                // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxTypes.g:439:7:
                // ^( ALL_RESTRICTION p= propertyExpression f= expression )
                {
                    match(input, ALL_RESTRICTION,
                            FOLLOW_ALL_RESTRICTION_in_qualifiedRestriction1435);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.DOWN, null);
                    if (state.failed) {
                        return retval;
                    }
                    pushFollow(FOLLOW_propertyExpression_in_qualifiedRestriction1442);
                    p = propertyExpression();
                    state._fsp--;
                    if (state.failed) {
                        return retval;
                    }
                    pushFollow(FOLLOW_expression_in_qualifiedRestriction1447);
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
                                (ManchesterOWLSyntaxTree) retval.start, p.node, f.node);
                        retval.owlObject = getSymbolTable().getAllValueRestriction(
                                (ManchesterOWLSyntaxTree) retval.start, p.node, f.node);
                    }
                }
                    break;
                case 3:
                // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxTypes.g:444:7:
                // cardinalityRestriction
                {
                    pushFollow(FOLLOW_cardinalityRestriction_in_qualifiedRestriction1463);
                    cardinalityRestriction17 = cardinalityRestriction();
                    state._fsp--;
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 1) {
                        retval.type = cardinalityRestriction17 != null ? cardinalityRestriction17.type
                                : null;
                        retval.owlObject = cardinalityRestriction17 != null ? cardinalityRestriction17.owlObject
                                : null;
                    }
                }
                    break;
                case 4:
                // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxTypes.g:449:7:
                // oneOf
                {
                    pushFollow(FOLLOW_oneOf_in_qualifiedRestriction1479);
                    oneOf18 = oneOf();
                    state._fsp--;
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 1) {
                        retval.type = oneOf18 != null ? oneOf18.type : null;
                        retval.owlObject = oneOf18 != null ? oneOf18.owlObject : null;
                    }
                }
                    break;
                case 5:
                // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxTypes.g:454:7:
                // valueRestriction
                {
                    pushFollow(FOLLOW_valueRestriction_in_qualifiedRestriction1495);
                    valueRestriction19 = valueRestriction();
                    state._fsp--;
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 1) {
                        retval.type = valueRestriction19 != null ? valueRestriction19.type
                                : null;
                        retval.owlObject = valueRestriction19 != null ? valueRestriction19.owlObject
                                : null;
                    }
                }
                    break;
            }
            if (state.backtracking == 1) {
                ((ManchesterOWLSyntaxTree) retval.start).setEvalType(retval.type);
                retval.node = (ManchesterOWLSyntaxTree) retval.start;
                ((ManchesterOWLSyntaxTree) retval.start).setOWLObject(retval.owlObject);
            }
        } catch (RecognitionException exception) {
            if (errorListener != null) {
                errorListener.recognitionException(exception);
            }
        } catch (RewriteEmptyStreamException exception) {
            if (errorListener != null) {
                errorListener.rewriteEmptyStreamException(exception);
            }
        } finally {}
        return retval;
    }

    // $ANTLR end "qualifiedRestriction"
    public static class cardinalityRestriction_return extends TreeRuleReturnScope {
        public Type type;
        public ManchesterOWLSyntaxTree node;
        public OWLObject owlObject;
    };

    // $ANTLR start "cardinalityRestriction"
    // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxTypes.g:463:1:
    // cardinalityRestriction returns [Type type , ManchesterOWLSyntaxTree node,
    // OWLObject owlObject] : ( ^( CARDINALITY_RESTRICTION MIN i= INTEGER p=
    // unary (filler= expression )? ) | ^( CARDINALITY_RESTRICTION MAX i=
    // INTEGER p= unary (filler= expression )? ) | ^( CARDINALITY_RESTRICTION
    // EXACTLY i= INTEGER p= unary (filler= expression )? ) );
    public final ManchesterOWLSyntaxTypes.cardinalityRestriction_return
            cardinalityRestriction() throws RecognitionException {
        ManchesterOWLSyntaxTypes.cardinalityRestriction_return retval = new ManchesterOWLSyntaxTypes.cardinalityRestriction_return();
        retval.start = input.LT(1);
        ManchesterOWLSyntaxTree i = null;
        ManchesterOWLSyntaxTypes.unary_return p = null;
        ManchesterOWLSyntaxTypes.expression_return filler = null;
        try {
            // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxTypes.g:469:1:
            // ( ^( CARDINALITY_RESTRICTION MIN i= INTEGER p= unary (filler=
            // expression )? ) | ^( CARDINALITY_RESTRICTION MAX i= INTEGER p=
            // unary (filler= expression )? ) | ^( CARDINALITY_RESTRICTION
            // EXACTLY i= INTEGER p= unary (filler= expression )? ) )
            int alt20 = 3;
            int LA20_0 = input.LA(1);
            if (LA20_0 == CARDINALITY_RESTRICTION) {
                int LA20_1 = input.LA(2);
                if (LA20_1 == DOWN) {
                    switch (input.LA(3)) {
                        case MIN: {
                            alt20 = 1;
                        }
                            break;
                        case MAX: {
                            alt20 = 2;
                        }
                            break;
                        case EXACTLY: {
                            alt20 = 3;
                        }
                            break;
                        default:
                            if (state.backtracking > 0) {
                                state.failed = true;
                                return retval;
                            }
                            NoViableAltException nvae = new NoViableAltException("", 20,
                                    2, input);
                            throw nvae;
                    }
                } else {
                    if (state.backtracking > 0) {
                        state.failed = true;
                        return retval;
                    }
                    NoViableAltException nvae = new NoViableAltException("", 20, 1, input);
                    throw nvae;
                }
            } else {
                if (state.backtracking > 0) {
                    state.failed = true;
                    return retval;
                }
                NoViableAltException nvae = new NoViableAltException("", 20, 0, input);
                throw nvae;
            }
            switch (alt20) {
                case 1:
                // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxTypes.g:470:5:
                // ^( CARDINALITY_RESTRICTION MIN i= INTEGER p= unary (filler=
                // expression )? )
                {
                    match(input, CARDINALITY_RESTRICTION,
                            FOLLOW_CARDINALITY_RESTRICTION_in_cardinalityRestriction1532);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.DOWN, null);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, MIN, FOLLOW_MIN_in_cardinalityRestriction1535);
                    if (state.failed) {
                        return retval;
                    }
                    i = (ManchesterOWLSyntaxTree) match(input, INTEGER,
                            FOLLOW_INTEGER_in_cardinalityRestriction1540);
                    if (state.failed) {
                        return retval;
                    }
                    pushFollow(FOLLOW_unary_in_cardinalityRestriction1546);
                    p = unary();
                    state._fsp--;
                    if (state.failed) {
                        return retval;
                    }
                    // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxTypes.g:470:65:
                    // (filler= expression )?
                    int alt17 = 2;
                    int LA17_0 = input.LA(1);
                    if (LA17_0 >= IDENTIFIER && LA17_0 <= ENTITY_REFERENCE
                            || LA17_0 >= DISJUNCTION && LA17_0 <= NEGATED_EXPRESSION
                            || LA17_0 >= SOME_RESTRICTION && LA17_0 <= ONE_OF
                            || LA17_0 == INVERSE_OBJECT_PROPERTY_EXPRESSION
                            || LA17_0 == CONSTANT || LA17_0 == DATA_RANGE
                            || LA17_0 == IRI) {
                        alt17 = 1;
                    }
                    switch (alt17) {
                        case 1:
                        // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxTypes.g:470:65:
                        // filler= expression
                        {
                            pushFollow(FOLLOW_expression_in_cardinalityRestriction1553);
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
                                (ManchesterOWLSyntaxTree) retval.start, p.node,
                                filler == null ? null : filler.node);
                        int cardinality = Integer.parseInt(i.token.getText());
                        retval.owlObject = getSymbolTable().getMinCardinalityRestriction(
                                (ManchesterOWLSyntaxTree) retval.start, cardinality,
                                p.node, filler == null ? null : filler.node);
                    }
                }
                    break;
                case 2:
                // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxTypes.g:477:6:
                // ^( CARDINALITY_RESTRICTION MAX i= INTEGER p= unary (filler=
                // expression )? )
                {
                    match(input, CARDINALITY_RESTRICTION,
                            FOLLOW_CARDINALITY_RESTRICTION_in_cardinalityRestriction1568);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.DOWN, null);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, MAX, FOLLOW_MAX_in_cardinalityRestriction1571);
                    if (state.failed) {
                        return retval;
                    }
                    i = (ManchesterOWLSyntaxTree) match(input, INTEGER,
                            FOLLOW_INTEGER_in_cardinalityRestriction1575);
                    if (state.failed) {
                        return retval;
                    }
                    pushFollow(FOLLOW_unary_in_cardinalityRestriction1581);
                    p = unary();
                    state._fsp--;
                    if (state.failed) {
                        return retval;
                    }
                    // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxTypes.g:477:65:
                    // (filler= expression )?
                    int alt18 = 2;
                    int LA18_0 = input.LA(1);
                    if (LA18_0 >= IDENTIFIER && LA18_0 <= ENTITY_REFERENCE
                            || LA18_0 >= DISJUNCTION && LA18_0 <= NEGATED_EXPRESSION
                            || LA18_0 >= SOME_RESTRICTION && LA18_0 <= ONE_OF
                            || LA18_0 == INVERSE_OBJECT_PROPERTY_EXPRESSION
                            || LA18_0 == CONSTANT || LA18_0 == DATA_RANGE
                            || LA18_0 == IRI) {
                        alt18 = 1;
                    }
                    switch (alt18) {
                        case 1:
                        // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxTypes.g:477:65:
                        // filler= expression
                        {
                            pushFollow(FOLLOW_expression_in_cardinalityRestriction1588);
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
                                (ManchesterOWLSyntaxTree) retval.start, p.node,
                                filler == null ? null : filler.node);
                        int cardinality = Integer.parseInt(i.token.getText());
                        retval.owlObject = getSymbolTable().getMaxCardinalityRestriction(
                                (ManchesterOWLSyntaxTree) retval.start, cardinality,
                                p.node, filler == null ? null : filler.node);
                    }
                }
                    break;
                case 3:
                // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxTypes.g:483:8:
                // ^( CARDINALITY_RESTRICTION EXACTLY i= INTEGER p= unary
                // (filler= expression )? )
                {
                    match(input, CARDINALITY_RESTRICTION,
                            FOLLOW_CARDINALITY_RESTRICTION_in_cardinalityRestriction1607);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.DOWN, null);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, EXACTLY, FOLLOW_EXACTLY_in_cardinalityRestriction1610);
                    if (state.failed) {
                        return retval;
                    }
                    i = (ManchesterOWLSyntaxTree) match(input, INTEGER,
                            FOLLOW_INTEGER_in_cardinalityRestriction1615);
                    if (state.failed) {
                        return retval;
                    }
                    pushFollow(FOLLOW_unary_in_cardinalityRestriction1622);
                    p = unary();
                    state._fsp--;
                    if (state.failed) {
                        return retval;
                    }
                    // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxTypes.g:483:73:
                    // (filler= expression )?
                    int alt19 = 2;
                    int LA19_0 = input.LA(1);
                    if (LA19_0 >= IDENTIFIER && LA19_0 <= ENTITY_REFERENCE
                            || LA19_0 >= DISJUNCTION && LA19_0 <= NEGATED_EXPRESSION
                            || LA19_0 >= SOME_RESTRICTION && LA19_0 <= ONE_OF
                            || LA19_0 == INVERSE_OBJECT_PROPERTY_EXPRESSION
                            || LA19_0 == CONSTANT || LA19_0 == DATA_RANGE
                            || LA19_0 == IRI) {
                        alt19 = 1;
                    }
                    switch (alt19) {
                        case 1:
                        // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxTypes.g:483:73:
                        // filler= expression
                        {
                            pushFollow(FOLLOW_expression_in_cardinalityRestriction1629);
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
                                        (ManchesterOWLSyntaxTree) retval.start, p.node,
                                        filler == null ? null : filler.node);
                        int cardinality = Integer.parseInt(i.token.getText());
                        retval.owlObject = getSymbolTable()
                                .getExactCardinalityRestriction(
                                        (ManchesterOWLSyntaxTree) retval.start,
                                        cardinality, p.node,
                                        filler == null ? null : filler.node);
                    }
                }
                    break;
            }
            if (state.backtracking == 1) {
                ((ManchesterOWLSyntaxTree) retval.start).setEvalType(retval.type);
                retval.node = (ManchesterOWLSyntaxTree) retval.start;
                ((ManchesterOWLSyntaxTree) retval.start).setOWLObject(retval.owlObject);
            }
        } catch (RecognitionException exception) {
            if (errorListener != null) {
                errorListener.recognitionException(exception);
            }
        } catch (RewriteEmptyStreamException exception) {
            if (errorListener != null) {
                errorListener.rewriteEmptyStreamException(exception);
            }
        } finally {}
        return retval;
    }

    // $ANTLR end "cardinalityRestriction"
    public static class valueRestriction_return extends TreeRuleReturnScope {
        public Type type;
        public ManchesterOWLSyntaxTree node;
        public OWLObject owlObject;
    };

    // $ANTLR start "valueRestriction"
    // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxTypes.g:490:3:
    // valueRestriction returns [Type type , ManchesterOWLSyntaxTree node,
    // OWLObject owlObject] : ^( VALUE_RESTRICTION p= unary value= unary ) ;
    public final ManchesterOWLSyntaxTypes.valueRestriction_return valueRestriction()
            throws RecognitionException {
        ManchesterOWLSyntaxTypes.valueRestriction_return retval = new ManchesterOWLSyntaxTypes.valueRestriction_return();
        retval.start = input.LT(1);
        ManchesterOWLSyntaxTypes.unary_return p = null;
        ManchesterOWLSyntaxTypes.unary_return value = null;
        try {
            // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxTypes.g:496:2:
            // ( ^( VALUE_RESTRICTION p= unary value= unary ) )
            // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxTypes.g:497:3:
            // ^( VALUE_RESTRICTION p= unary value= unary )
            {
                match(input, VALUE_RESTRICTION,
                        FOLLOW_VALUE_RESTRICTION_in_valueRestriction1666);
                if (state.failed) {
                    return retval;
                }
                match(input, Token.DOWN, null);
                if (state.failed) {
                    return retval;
                }
                pushFollow(FOLLOW_unary_in_valueRestriction1673);
                p = unary();
                state._fsp--;
                if (state.failed) {
                    return retval;
                }
                pushFollow(FOLLOW_unary_in_valueRestriction1680);
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
                            (ManchesterOWLSyntaxTree) retval.start, p.node, value.node);
                    if (retval.type != null) {
                        retval.owlObject = getSymbolTable().getValueRestriction(
                                (ManchesterOWLSyntaxTree) retval.start, p.node,
                                value.node);
                    }
                }
            }
            if (state.backtracking == 1) {
                ((ManchesterOWLSyntaxTree) retval.start).setEvalType(retval.type);
                retval.node = (ManchesterOWLSyntaxTree) retval.start;
                ((ManchesterOWLSyntaxTree) retval.start).setOWLObject(retval.owlObject);
            }
        } catch (RecognitionException exception) {
            if (errorListener != null) {
                errorListener.recognitionException(exception);
            }
        } catch (RewriteEmptyStreamException exception) {
            if (errorListener != null) {
                errorListener.rewriteEmptyStreamException(exception);
            }
        } finally {}
        return retval;
    }

    // $ANTLR end "valueRestriction"
    public static class oneOf_return extends TreeRuleReturnScope {
        public Type type;
        public ManchesterOWLSyntaxTree node;
        public OWLObject owlObject;
    };

    // $ANTLR start "oneOf"
    // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxTypes.g:507:1:
    // oneOf returns [Type type , ManchesterOWLSyntaxTree node, OWLObject
    // owlObject] : ^( ONE_OF (individuals+= unary )+ ) ;
    public final ManchesterOWLSyntaxTypes.oneOf_return oneOf()
            throws RecognitionException {
        ManchesterOWLSyntaxTypes.oneOf_return retval = new ManchesterOWLSyntaxTypes.oneOf_return();
        retval.start = input.LT(1);
        List list_individuals = null;
        RuleReturnScope individuals = null;
        try {
            // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxTypes.g:513:2:
            // ( ^( ONE_OF (individuals+= unary )+ ) )
            // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxTypes.g:514:3:
            // ^( ONE_OF (individuals+= unary )+ )
            {
                match(input, ONE_OF, FOLLOW_ONE_OF_in_oneOf1712);
                if (state.failed) {
                    return retval;
                }
                match(input, Token.DOWN, null);
                if (state.failed) {
                    return retval;
                }
                // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxTypes.g:514:23:
                // (individuals+= unary )+
                int cnt21 = 0;
                loop21: do {
                    int alt21 = 2;
                    int LA21_0 = input.LA(1);
                    if (LA21_0 >= IDENTIFIER && LA21_0 <= ENTITY_REFERENCE
                            || LA21_0 == NEGATED_EXPRESSION || LA21_0 >= SOME_RESTRICTION
                            && LA21_0 <= ONE_OF || LA21_0 == CONSTANT
                            || LA21_0 == DATA_RANGE || LA21_0 == IRI) {
                        alt21 = 1;
                    }
                    switch (alt21) {
                        case 1:
                        // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxTypes.g:514:23:
                        // individuals+= unary
                        {
                            pushFollow(FOLLOW_unary_in_oneOf1716);
                            individuals = unary();
                            state._fsp--;
                            if (state.failed) {
                                return retval;
                            }
                            if (list_individuals == null) {
                                list_individuals = new ArrayList();
                            }
                            list_individuals.add(individuals);
                        }
                            break;
                        default:
                            if (cnt21 >= 1) {
                                break loop21;
                            }
                            if (state.backtracking > 0) {
                                state.failed = true;
                                return retval;
                            }
                            EarlyExitException eee = new EarlyExitException(21, input);
                            throw eee;
                    }
                    cnt21++;
                } while (true);
                match(input, Token.UP, null);
                if (state.failed) {
                    return retval;
                }
                if (state.backtracking == 1) {
                    List<ManchesterOWLSyntaxTree> nodes = new ArrayList<ManchesterOWLSyntaxTree>(
                            list_individuals.size());
                    for (Object node : list_individuals) {
                        nodes.add(((unary_return) node).node);
                    }
                    retval.type = getSymbolTable().getOneOfType(
                            (ManchesterOWLSyntaxTree) retval.start,
                            nodes.toArray(new ManchesterOWLSyntaxTree[nodes.size()]));
                    if (retval.type != null) {
                        retval.owlObject = getSymbolTable().getOneOf(
                                (ManchesterOWLSyntaxTree) retval.start,
                                nodes.toArray(new ManchesterOWLSyntaxTree[nodes.size()]));
                    }
                }
            }
            if (state.backtracking == 1) {
                ((ManchesterOWLSyntaxTree) retval.start).setEvalType(retval.type);
                retval.node = (ManchesterOWLSyntaxTree) retval.start;
                ((ManchesterOWLSyntaxTree) retval.start).setOWLObject(retval.owlObject);
            }
        } catch (RecognitionException exception) {
            if (errorListener != null) {
                errorListener.recognitionException(exception);
            }
        } catch (RewriteEmptyStreamException exception) {
            if (errorListener != null) {
                errorListener.rewriteEmptyStreamException(exception);
            }
        } finally {}
        return retval;
    }

    // $ANTLR end "oneOf"
    // Delegated rules
    protected DFA3 dfa3 = new DFA3(this);
    static final String DFA3_eotS = "\30\uffff";
    static final String DFA3_eofS = "\30\uffff";
    static final String DFA3_minS = "\1\31\13\uffff\1\2\3\uffff\1\35\7\uffff";
    static final String DFA3_maxS = "\1\157\13\uffff\1\2\3\uffff\1\43\7\uffff";
    static final String DFA3_acceptS = "\1\uffff\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\13\1\uffff"
            + "\1\23\1\24\1\25\1\uffff\1\14\1\15\1\16\1\17\1\20\1\21\1\22";
    static final String DFA3_specialS = "\30\uffff}>";
    static final String[] DFA3_transitionS = {
            "\1\3\1\uffff\1\10\1\11\23\uffff\1\1\1\2\1\4\1\5\1\12\1\13\1"
                    + "\14\4\uffff\1\15\6\uffff\1\7\1\6\51\uffff\1\16\1\uffff\1\17", "",
            "", "", "", "", "", "", "", "", "", "", "\1\20", "", "", "",
            "\1\21\1\25\1\26\1\24\1\23\1\27\1\22", "", "", "", "", "", "", "" };
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
            return "91:1: axiom returns [Type type, ManchesterOWLSyntaxTree node, OWLAxiom owlAxiom] : ( ^( SUB_CLASS_AXIOM ^( EXPRESSION subClass= expression ) ^( EXPRESSION superClass= expression ) ) | ^( EQUIVALENT_TO_AXIOM ^( EXPRESSION lhs= expression ) ^( EXPRESSION rhs= expression ) ) | ^( INVERSE_OF ^( EXPRESSION p= IDENTIFIER ) ^( EXPRESSION anotherProperty= IDENTIFIER ) ) | ^( DISJOINT_WITH_AXIOM ^( EXPRESSION lhs= expression ) ^( EXPRESSION rhs= expression ) ) | ^( SUB_PROPERTY_AXIOM ^( EXPRESSION subProperty= expression ) ^( EXPRESSION superProperty= unary ) ) | ^( ROLE_ASSERTION ^( EXPRESSION subject= IDENTIFIER ) ^( EXPRESSION predicate= propertyExpression ) ^( EXPRESSION object= unary ) ) | ^( TYPE_ASSERTION ^( EXPRESSION description= expression ) ^( EXPRESSION subject= IDENTIFIER ) ) | ^( DOMAIN ^( EXPRESSION p= IDENTIFIER ) ^( EXPRESSION domain= expression ) ) | ^( RANGE ^( EXPRESSION p= IDENTIFIER ) ^( EXPRESSION range= expression ) ) | ^( SAME_AS_AXIOM ^( EXPRESSION anIndividual= IDENTIFIER ) ^( EXPRESSION anotherIndividual= IDENTIFIER ) ) | ^( DIFFERENT_FROM_AXIOM ^( EXPRESSION anIndividual= IDENTIFIER ) ^( EXPRESSION anotherIndividual= IDENTIFIER ) ) | ^( UNARY_AXIOM FUNCTIONAL ^( EXPRESSION p= IDENTIFIER ) ) | ^( UNARY_AXIOM INVERSE_FUNCTIONAL ^( EXPRESSION p= IDENTIFIER ) ) | ^( UNARY_AXIOM IRREFLEXIVE ^( EXPRESSION p= IDENTIFIER ) ) | ^( UNARY_AXIOM REFLEXIVE ^( EXPRESSION p= IDENTIFIER ) ) | ^( UNARY_AXIOM SYMMETRIC ^( EXPRESSION p= IDENTIFIER ) ) | ^( UNARY_AXIOM ANTI_SYMMETRIC ^( EXPRESSION p= IDENTIFIER ) ) | ^( UNARY_AXIOM TRANSITIVE ^( EXPRESSION p= IDENTIFIER ) ) | ^( NEGATED_ASSERTION a= axiom ) | ^( HAS_KEY ^( EXPRESSION exp= expression ) ( ^( EXPRESSION propertyExp= propertyExpression ) )+ ) | ^( ANNOTATION_ASSERTION IRI ^( EXPRESSION annotationProperty= unary ) ^( EXPRESSION annotationObject= expression ) ) );";
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
    public static final BitSet FOLLOW_SUB_CLASS_AXIOM_in_axiom170 = new BitSet(
            new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_EXPRESSION_in_axiom174 = new BitSet(
            new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_expression_in_axiom181 = new BitSet(
            new long[] { 0x0000000000000008L });
    public static final BitSet FOLLOW_EXPRESSION_in_axiom186 = new BitSet(
            new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_expression_in_axiom193 = new BitSet(
            new long[] { 0x0000000000000008L });
    public static final BitSet FOLLOW_EQUIVALENT_TO_AXIOM_in_axiom206 = new BitSet(
            new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_EXPRESSION_in_axiom209 = new BitSet(
            new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_expression_in_axiom215 = new BitSet(
            new long[] { 0x0000000000000008L });
    public static final BitSet FOLLOW_EXPRESSION_in_axiom219 = new BitSet(
            new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_expression_in_axiom226 = new BitSet(
            new long[] { 0x0000000000000008L });
    public static final BitSet FOLLOW_INVERSE_OF_in_axiom241 = new BitSet(
            new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_EXPRESSION_in_axiom244 = new BitSet(
            new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_IDENTIFIER_in_axiom250 = new BitSet(
            new long[] { 0x0000000000000008L });
    public static final BitSet FOLLOW_EXPRESSION_in_axiom254 = new BitSet(
            new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_IDENTIFIER_in_axiom260 = new BitSet(
            new long[] { 0x0000000000000008L });
    public static final BitSet FOLLOW_DISJOINT_WITH_AXIOM_in_axiom272 = new BitSet(
            new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_EXPRESSION_in_axiom275 = new BitSet(
            new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_expression_in_axiom282 = new BitSet(
            new long[] { 0x0000000000000008L });
    public static final BitSet FOLLOW_EXPRESSION_in_axiom286 = new BitSet(
            new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_expression_in_axiom292 = new BitSet(
            new long[] { 0x0000000000000008L });
    public static final BitSet FOLLOW_SUB_PROPERTY_AXIOM_in_axiom304 = new BitSet(
            new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_EXPRESSION_in_axiom307 = new BitSet(
            new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_expression_in_axiom314 = new BitSet(
            new long[] { 0x0000000000000008L });
    public static final BitSet FOLLOW_EXPRESSION_in_axiom318 = new BitSet(
            new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_unary_in_axiom324 = new BitSet(
            new long[] { 0x0000000000000008L });
    public static final BitSet FOLLOW_ROLE_ASSERTION_in_axiom338 = new BitSet(
            new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_EXPRESSION_in_axiom341 = new BitSet(
            new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_IDENTIFIER_in_axiom348 = new BitSet(
            new long[] { 0x0000000000000008L });
    public static final BitSet FOLLOW_EXPRESSION_in_axiom352 = new BitSet(
            new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_propertyExpression_in_axiom359 = new BitSet(
            new long[] { 0x0000000000000008L });
    public static final BitSet FOLLOW_EXPRESSION_in_axiom363 = new BitSet(
            new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_unary_in_axiom369 = new BitSet(
            new long[] { 0x0000000000000008L });
    public static final BitSet FOLLOW_TYPE_ASSERTION_in_axiom379 = new BitSet(
            new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_EXPRESSION_in_axiom382 = new BitSet(
            new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_expression_in_axiom389 = new BitSet(
            new long[] { 0x0000000000000008L });
    public static final BitSet FOLLOW_EXPRESSION_in_axiom393 = new BitSet(
            new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_IDENTIFIER_in_axiom399 = new BitSet(
            new long[] { 0x0000000000000008L });
    public static final BitSet FOLLOW_DOMAIN_in_axiom411 = new BitSet(
            new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_EXPRESSION_in_axiom414 = new BitSet(
            new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_IDENTIFIER_in_axiom420 = new BitSet(
            new long[] { 0x0000000000000008L });
    public static final BitSet FOLLOW_EXPRESSION_in_axiom424 = new BitSet(
            new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_expression_in_axiom430 = new BitSet(
            new long[] { 0x0000000000000008L });
    public static final BitSet FOLLOW_RANGE_in_axiom443 = new BitSet(
            new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_EXPRESSION_in_axiom446 = new BitSet(
            new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_IDENTIFIER_in_axiom452 = new BitSet(
            new long[] { 0x0000000000000008L });
    public static final BitSet FOLLOW_EXPRESSION_in_axiom456 = new BitSet(
            new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_expression_in_axiom462 = new BitSet(
            new long[] { 0x0000000000000008L });
    public static final BitSet FOLLOW_SAME_AS_AXIOM_in_axiom477 = new BitSet(
            new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_EXPRESSION_in_axiom480 = new BitSet(
            new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_IDENTIFIER_in_axiom485 = new BitSet(
            new long[] { 0x0000000000000008L });
    public static final BitSet FOLLOW_EXPRESSION_in_axiom489 = new BitSet(
            new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_IDENTIFIER_in_axiom495 = new BitSet(
            new long[] { 0x0000000000000008L });
    public static final BitSet FOLLOW_DIFFERENT_FROM_AXIOM_in_axiom511 = new BitSet(
            new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_EXPRESSION_in_axiom514 = new BitSet(
            new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_IDENTIFIER_in_axiom519 = new BitSet(
            new long[] { 0x0000000000000008L });
    public static final BitSet FOLLOW_EXPRESSION_in_axiom523 = new BitSet(
            new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_IDENTIFIER_in_axiom529 = new BitSet(
            new long[] { 0x0000000000000008L });
    public static final BitSet FOLLOW_UNARY_AXIOM_in_axiom543 = new BitSet(
            new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_FUNCTIONAL_in_axiom545 = new BitSet(new long[] {
            0x0000000000000000L, 0x0000000000000020L });
    public static final BitSet FOLLOW_EXPRESSION_in_axiom548 = new BitSet(
            new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_IDENTIFIER_in_axiom554 = new BitSet(
            new long[] { 0x0000000000000008L });
    public static final BitSet FOLLOW_UNARY_AXIOM_in_axiom567 = new BitSet(
            new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_INVERSE_FUNCTIONAL_in_axiom569 = new BitSet(
            new long[] { 0x0000000000000000L, 0x0000000000000020L });
    public static final BitSet FOLLOW_EXPRESSION_in_axiom572 = new BitSet(
            new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_IDENTIFIER_in_axiom578 = new BitSet(
            new long[] { 0x0000000000000008L });
    public static final BitSet FOLLOW_UNARY_AXIOM_in_axiom594 = new BitSet(
            new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_IRREFLEXIVE_in_axiom596 = new BitSet(new long[] {
            0x0000000000000000L, 0x0000000000000020L });
    public static final BitSet FOLLOW_EXPRESSION_in_axiom599 = new BitSet(
            new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_IDENTIFIER_in_axiom605 = new BitSet(
            new long[] { 0x0000000000000008L });
    public static final BitSet FOLLOW_UNARY_AXIOM_in_axiom620 = new BitSet(
            new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_REFLEXIVE_in_axiom622 = new BitSet(new long[] {
            0x0000000000000000L, 0x0000000000000020L });
    public static final BitSet FOLLOW_EXPRESSION_in_axiom625 = new BitSet(
            new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_IDENTIFIER_in_axiom631 = new BitSet(
            new long[] { 0x0000000000000008L });
    public static final BitSet FOLLOW_UNARY_AXIOM_in_axiom646 = new BitSet(
            new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_SYMMETRIC_in_axiom648 = new BitSet(new long[] {
            0x0000000000000000L, 0x0000000000000020L });
    public static final BitSet FOLLOW_EXPRESSION_in_axiom651 = new BitSet(
            new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_IDENTIFIER_in_axiom657 = new BitSet(
            new long[] { 0x0000000000000008L });
    public static final BitSet FOLLOW_UNARY_AXIOM_in_axiom675 = new BitSet(
            new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_ANTI_SYMMETRIC_in_axiom677 = new BitSet(new long[] {
            0x0000000000000000L, 0x0000000000000020L });
    public static final BitSet FOLLOW_EXPRESSION_in_axiom680 = new BitSet(
            new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_IDENTIFIER_in_axiom686 = new BitSet(
            new long[] { 0x0000000000000008L });
    public static final BitSet FOLLOW_UNARY_AXIOM_in_axiom707 = new BitSet(
            new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_TRANSITIVE_in_axiom709 = new BitSet(new long[] {
            0x0000000000000000L, 0x0000000000000020L });
    public static final BitSet FOLLOW_EXPRESSION_in_axiom712 = new BitSet(
            new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_IDENTIFIER_in_axiom718 = new BitSet(
            new long[] { 0x0000000000000008L });
    public static final BitSet FOLLOW_NEGATED_ASSERTION_in_axiom733 = new BitSet(
            new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_axiom_in_axiom738 = new BitSet(
            new long[] { 0x0000000000000008L });
    public static final BitSet FOLLOW_HAS_KEY_in_axiom748 = new BitSet(
            new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_EXPRESSION_in_axiom751 = new BitSet(
            new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_expression_in_axiom756 = new BitSet(
            new long[] { 0x0000000000000008L });
    public static final BitSet FOLLOW_EXPRESSION_in_axiom761 = new BitSet(
            new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_propertyExpression_in_axiom767 = new BitSet(
            new long[] { 0x0000000000000008L });
    public static final BitSet FOLLOW_ANNOTATION_ASSERTION_in_axiom781 = new BitSet(
            new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_IRI_in_axiom783 = new BitSet(new long[] {
            0x0000000000000000L, 0x0000000000000020L });
    public static final BitSet FOLLOW_EXPRESSION_in_axiom786 = new BitSet(
            new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_unary_in_axiom792 = new BitSet(
            new long[] { 0x0000000000000008L });
    public static final BitSet FOLLOW_EXPRESSION_in_axiom796 = new BitSet(
            new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_expression_in_axiom802 = new BitSet(
            new long[] { 0x0000000000000008L });
    public static final BitSet FOLLOW_DISJUNCTION_in_expression845 = new BitSet(
            new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_conjunction_in_expression851 = new BitSet(
            new long[] { 0xE500300000000008L, 0x0000500000000043L });
    public static final BitSet FOLLOW_PROPERTY_CHAIN_in_expression867 = new BitSet(
            new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_expression_in_expression872 = new BitSet(
            new long[] { 0xE780300000000008L, 0x0000500000000053L });
    public static final BitSet FOLLOW_conjunction_in_expression886 = new BitSet(
            new long[] { 0x0000000000000002L });
    public static final BitSet FOLLOW_complexPropertyExpression_in_expression898 = new BitSet(
            new long[] { 0x0000000000000002L });
    public static final BitSet FOLLOW_CONJUNCTION_in_conjunction935 = new BitSet(
            new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_unary_in_conjunction940 = new BitSet(new long[] {
            0xE500300000000008L, 0x0000500000000043L });
    public static final BitSet FOLLOW_unary_in_conjunction951 = new BitSet(
            new long[] { 0x0000000000000002L });
    public static final BitSet FOLLOW_IDENTIFIER_in_unary978 = new BitSet(
            new long[] { 0x0000000000000002L });
    public static final BitSet FOLLOW_NEGATED_EXPRESSION_in_unary991 = new BitSet(
            new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_expression_in_unary997 = new BitSet(
            new long[] { 0x0000000000000008L });
    public static final BitSet FOLLOW_qualifiedRestriction_in_unary1011 = new BitSet(
            new long[] { 0x0000000000000002L });
    public static final BitSet FOLLOW_ENTITY_REFERENCE_in_unary1025 = new BitSet(
            new long[] { 0x0000000000000002L });
    public static final BitSet FOLLOW_IRI_in_unary1037 = new BitSet(
            new long[] { 0x0000000000000002L });
    public static final BitSet FOLLOW_CONSTANT_in_unary1049 = new BitSet(
            new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_AT_in_unary1059 = new BitSet(
            new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_IDENTIFIER_in_unary1065 = new BitSet(
            new long[] { 0x0000000000000008L });
    public static final BitSet FOLLOW_IDENTIFIER_in_unary1074 = new BitSet(
            new long[] { 0x0000000000000008L });
    public static final BitSet FOLLOW_dataRange_in_unary1084 = new BitSet(
            new long[] { 0x0000000000000002L });
    public static final BitSet FOLLOW_DATA_RANGE_in_dataRange1121 = new BitSet(
            new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_unary_in_dataRange1127 = new BitSet(new long[] {
            0x0000000000000008L, 0x0000000000000000L, 0x0000000000000000L,
            0x0000000000000000L, 0x0000000000000000L, 0x0000000000000000L,
            0x0000000000000000L, 0x0000007800000000L });
    public static final BitSet FOLLOW_facet_in_dataRange1132 = new BitSet(new long[] {
            0x0000000000000008L, 0x0000000000000000L, 0x0000000000000000L,
            0x0000000000000000L, 0x0000000000000000L, 0x0000000000000000L,
            0x0000000000000000L, 0x0000007800000000L });
    public static final BitSet FOLLOW_LESS_THAN_in_facet1175 = new BitSet(
            new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_unary_in_facet1181 = new BitSet(
            new long[] { 0x0000000000000008L });
    public static final BitSet FOLLOW_LESS_THAN_EQUAL_in_facet1193 = new BitSet(
            new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_unary_in_facet1199 = new BitSet(
            new long[] { 0x0000000000000008L });
    public static final BitSet FOLLOW_GREATER_THAN_in_facet1212 = new BitSet(
            new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_unary_in_facet1218 = new BitSet(
            new long[] { 0x0000000000000008L });
    public static final BitSet FOLLOW_GREATER_THAN_EQUAL_in_facet1231 = new BitSet(
            new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_unary_in_facet1237 = new BitSet(
            new long[] { 0x0000000000000008L });
    public static final BitSet FOLLOW_IDENTIFIER_in_propertyExpression1276 = new BitSet(
            new long[] { 0x0000000000000002L });
    public static final BitSet FOLLOW_ENTITY_REFERENCE_in_propertyExpression1294 = new BitSet(
            new long[] { 0x0000000000000002L });
    public static final BitSet FOLLOW_complexPropertyExpression_in_propertyExpression1308 = new BitSet(
            new long[] { 0x0000000000000002L });
    public static final BitSet FOLLOW_INVERSE_OBJECT_PROPERTY_EXPRESSION_in_complexPropertyExpression1341 = new BitSet(
            new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_complexPropertyExpression_in_complexPropertyExpression1347 = new BitSet(
            new long[] { 0x0000000000000008L });
    public static final BitSet FOLLOW_INVERSE_OBJECT_PROPERTY_EXPRESSION_in_complexPropertyExpression1357 = new BitSet(
            new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_IDENTIFIER_in_complexPropertyExpression1359 = new BitSet(
            new long[] { 0x0000000000000008L });
    public static final BitSet FOLLOW_INVERSE_OBJECT_PROPERTY_EXPRESSION_in_complexPropertyExpression1369 = new BitSet(
            new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_ENTITY_REFERENCE_in_complexPropertyExpression1371 = new BitSet(
            new long[] { 0x0000000000000008L });
    public static final BitSet FOLLOW_SOME_RESTRICTION_in_qualifiedRestriction1402 = new BitSet(
            new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_propertyExpression_in_qualifiedRestriction1407 = new BitSet(
            new long[] { 0xE780300000000008L, 0x0000500000000053L });
    public static final BitSet FOLLOW_expression_in_qualifiedRestriction1413 = new BitSet(
            new long[] { 0x0000000000000008L });
    public static final BitSet FOLLOW_ALL_RESTRICTION_in_qualifiedRestriction1435 = new BitSet(
            new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_propertyExpression_in_qualifiedRestriction1442 = new BitSet(
            new long[] { 0xE780300000000008L, 0x0000500000000053L });
    public static final BitSet FOLLOW_expression_in_qualifiedRestriction1447 = new BitSet(
            new long[] { 0x0000000000000008L });
    public static final BitSet FOLLOW_cardinalityRestriction_in_qualifiedRestriction1463 = new BitSet(
            new long[] { 0x0000000000000002L });
    public static final BitSet FOLLOW_oneOf_in_qualifiedRestriction1479 = new BitSet(
            new long[] { 0x0000000000000002L });
    public static final BitSet FOLLOW_valueRestriction_in_qualifiedRestriction1495 = new BitSet(
            new long[] { 0x0000000000000002L });
    public static final BitSet FOLLOW_CARDINALITY_RESTRICTION_in_cardinalityRestriction1532 = new BitSet(
            new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_MIN_in_cardinalityRestriction1535 = new BitSet(
            new long[] { 0x0000040000000000L });
    public static final BitSet FOLLOW_INTEGER_in_cardinalityRestriction1540 = new BitSet(
            new long[] { 0xE500300000000008L, 0x0000500000000043L });
    public static final BitSet FOLLOW_unary_in_cardinalityRestriction1546 = new BitSet(
            new long[] { 0xE780300000000008L, 0x0000500000000053L });
    public static final BitSet FOLLOW_expression_in_cardinalityRestriction1553 = new BitSet(
            new long[] { 0x0000000000000008L });
    public static final BitSet FOLLOW_CARDINALITY_RESTRICTION_in_cardinalityRestriction1568 = new BitSet(
            new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_MAX_in_cardinalityRestriction1571 = new BitSet(
            new long[] { 0x0000040000000000L });
    public static final BitSet FOLLOW_INTEGER_in_cardinalityRestriction1575 = new BitSet(
            new long[] { 0xE500300000000008L, 0x0000500000000043L });
    public static final BitSet FOLLOW_unary_in_cardinalityRestriction1581 = new BitSet(
            new long[] { 0xE780300000000008L, 0x0000500000000053L });
    public static final BitSet FOLLOW_expression_in_cardinalityRestriction1588 = new BitSet(
            new long[] { 0x0000000000000008L });
    public static final BitSet FOLLOW_CARDINALITY_RESTRICTION_in_cardinalityRestriction1607 = new BitSet(
            new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_EXACTLY_in_cardinalityRestriction1610 = new BitSet(
            new long[] { 0x0000040000000000L });
    public static final BitSet FOLLOW_INTEGER_in_cardinalityRestriction1615 = new BitSet(
            new long[] { 0xE500300000000008L, 0x0000500000000043L });
    public static final BitSet FOLLOW_unary_in_cardinalityRestriction1622 = new BitSet(
            new long[] { 0xE780300000000008L, 0x0000500000000053L });
    public static final BitSet FOLLOW_expression_in_cardinalityRestriction1629 = new BitSet(
            new long[] { 0x0000000000000008L });
    public static final BitSet FOLLOW_VALUE_RESTRICTION_in_valueRestriction1666 = new BitSet(
            new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_unary_in_valueRestriction1673 = new BitSet(
            new long[] { 0xE500300000000008L, 0x0000500000000043L });
    public static final BitSet FOLLOW_unary_in_valueRestriction1680 = new BitSet(
            new long[] { 0x0000000000000008L });
    public static final BitSet FOLLOW_ONE_OF_in_oneOf1712 = new BitSet(
            new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_unary_in_oneOf1716 = new BitSet(new long[] {
            0xE500300000000008L, 0x0000500000000043L });
}
