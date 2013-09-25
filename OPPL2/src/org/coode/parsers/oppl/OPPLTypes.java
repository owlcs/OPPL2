// $ANTLR 3.2 Sep 23, 2009 12:02:23 /Users/luigi/Documents/workspace/Parsers/src/OPPLTypes.g 2011-07-22 11:20:33
package org.coode.parsers.oppl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.regex.Pattern;

import org.antlr.runtime.BaseRecognizer;
import org.antlr.runtime.BitSet;
import org.antlr.runtime.DFA;
import org.antlr.runtime.EarlyExitException;
import org.antlr.runtime.IntStream;
import org.antlr.runtime.MismatchedSetException;
import org.antlr.runtime.MismatchedTokenException;
import org.antlr.runtime.NoViableAltException;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.RecognizerSharedState;
import org.antlr.runtime.Token;
import org.antlr.runtime.tree.RewriteEmptyStreamException;
import org.antlr.runtime.tree.TreeFilter;
import org.antlr.runtime.tree.TreeNodeStream;
import org.antlr.runtime.tree.TreeRuleReturnScope;
import org.coode.oppl.AbstractConstraint;
import org.coode.oppl.ConstraintSystem;
import org.coode.oppl.NAFConstraint;
import org.coode.oppl.OPPLAbstractFactory;
import org.coode.oppl.OPPLQuery;
import org.coode.oppl.RegExpConstraint;
import org.coode.oppl.Variable;
import org.coode.oppl.VariableScope;
import org.coode.oppl.VariableScopeChecker;
import org.coode.oppl.VariableScopes;
import org.coode.oppl.exceptions.OPPLException;
import org.coode.oppl.function.Adapter;
import org.coode.oppl.function.Aggregandum;
import org.coode.oppl.function.Aggregation;
import org.coode.oppl.function.Constant;
import org.coode.oppl.function.OPPLFunction;
import org.coode.oppl.function.ToLowerCaseStringManipulationOPPLFunction;
import org.coode.oppl.function.ToUpperCaseStringManipulationOPPLFunction;
import org.coode.oppl.generated.GeneratedVariable;
import org.coode.oppl.generated.RegexpGeneratedVariable;
import org.coode.oppl.variabletypes.VariableTypeFactory;
import org.coode.parsers.ErrorListener;
import org.coode.parsers.Symbol;
import org.coode.parsers.Type;
import org.semanticweb.owlapi.model.AddAxiom;
import org.semanticweb.owlapi.model.OWLAxiom;
import org.semanticweb.owlapi.model.OWLAxiomChange;
import org.semanticweb.owlapi.model.OWLClassExpression;
import org.semanticweb.owlapi.model.OWLObject;
import org.semanticweb.owlapi.model.OWLPropertyExpression;
import org.semanticweb.owlapi.model.RemoveAxiom;

@SuppressWarnings("javadoc")
public class OPPLTypes extends TreeFilter {
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
    public OPPLTypes(TreeNodeStream input) {
        this(input, new RecognizerSharedState());
    }

    public OPPLTypes(TreeNodeStream input, RecognizerSharedState state) {
        super(input, state);
    }

    @Override
    public String[] getTokenNames() {
        return OPPLTypes.tokenNames;
    }

    @Override
    public String getGrammarFileName() {
        return "/Users/luigi/Documents/workspace/Parsers/src/OPPLTypes.g";
    }

    private OPPLSymbolTable symtab;
    private ErrorListener errorListener;
    private ConstraintSystem constraintSystem;
    private OPPLAbstractFactory opplFactory;

    public OPPLTypes(TreeNodeStream input, OPPLSymbolTable symtab,
            ErrorListener errorListener, ConstraintSystem constraintSystem,
            OPPLAbstractFactory opplFactory) {
        this(input);
        if (symtab == null) {
            throw new NullPointerException("The symbol table cannot be null");
        }
        if (errorListener == null) {
            throw new NullPointerException("The error listener cannot be null");
        }
        if (constraintSystem == null) {
            throw new NullPointerException("The constraint system cannot be null");
        }
        if (opplFactory == null) {
            throw new NullPointerException("The OPPL Factory cannot be null");
        }
        this.symtab = symtab;
        this.errorListener = errorListener;
        this.opplFactory = opplFactory;
        this.constraintSystem = constraintSystem;
    }

    public ErrorListener getErrorListener() {
        return errorListener;
    }

    public ConstraintSystem getConstraintSystem() {
        return constraintSystem;
    }

    public OPPLSymbolTable getSymbolTable() {
        return symtab;
    }

    public OPPLAbstractFactory getOPPLFactory() {
        return opplFactory;
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
    // /Users/luigi/Documents/workspace/Parsers/src/OPPLTypes.g:129:1: bottomup
    // : ( opplAxioms | statement );
    @Override
    public final void bottomup() throws RecognitionException {
        try {
            // /Users/luigi/Documents/workspace/Parsers/src/OPPLTypes.g:130:5: (
            // opplAxioms | statement )
            int alt1 = 2;
            int LA1_0 = input.LA(1);
            if (LA1_0 >= DISJOINT_CLASSES && LA1_0 <= DIFFERENT_INDIVIDUALS) {
                alt1 = 1;
            } else if (LA1_0 == OPPL_STATEMENT) {
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
                // /Users/luigi/Documents/workspace/Parsers/src/OPPLTypes.g:131:6:
                // opplAxioms
                {
                    pushFollow(FOLLOW_opplAxioms_in_bottomup81);
                    opplAxioms();
                    state._fsp--;
                    if (state.failed) {
                        return;
                    }
                }
                    break;
                case 2:
                // /Users/luigi/Documents/workspace/Parsers/src/OPPLTypes.g:132:8:
                // statement
                {
                    pushFollow(FOLLOW_statement_in_bottomup90);
                    statement();
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
    public static class statement_return extends TreeRuleReturnScope {}

    // $ANTLR start "statement"
    // /Users/luigi/Documents/workspace/Parsers/src/OPPLTypes.g:136:1: statement
    // : ^( OPPL_STATEMENT (vd= variableDefinitions )? (q= query )? actions ) ;
    public final OPPLTypes.statement_return statement() throws RecognitionException {
        OPPLTypes.statement_return retval = new OPPLTypes.statement_return();
        retval.start = input.LT(1);
        OPPLTypes.variableDefinitions_return vd = null;
        OPPLTypes.query_return q = null;
        OPPLTypes.actions_return actions1 = null;
        List<Variable<?>> vds = new ArrayList<Variable<?>>();
        try {
            // /Users/luigi/Documents/workspace/Parsers/src/OPPLTypes.g:140:2: (
            // ^( OPPL_STATEMENT (vd= variableDefinitions )? (q= query )?
            // actions ) )
            // /Users/luigi/Documents/workspace/Parsers/src/OPPLTypes.g:141:3:
            // ^( OPPL_STATEMENT (vd= variableDefinitions )? (q= query )?
            // actions )
            {
                match(input, OPPL_STATEMENT, FOLLOW_OPPL_STATEMENT_in_statement112);
                if (state.failed) {
                    return retval;
                }
                match(input, Token.DOWN, null);
                if (state.failed) {
                    return retval;
                }
                // /Users/luigi/Documents/workspace/Parsers/src/OPPLTypes.g:141:23:
                // (vd= variableDefinitions )?
                int alt2 = 2;
                int LA2_0 = input.LA(1);
                if (LA2_0 == VARIABLE_DEFINITIONS) {
                    alt2 = 1;
                }
                switch (alt2) {
                    case 1:
                    // /Users/luigi/Documents/workspace/Parsers/src/OPPLTypes.g:141:23:
                    // vd= variableDefinitions
                    {
                        pushFollow(FOLLOW_variableDefinitions_in_statement118);
                        vd = variableDefinitions();
                        state._fsp--;
                        if (state.failed) {
                            return retval;
                        }
                    }
                        break;
                }
                // /Users/luigi/Documents/workspace/Parsers/src/OPPLTypes.g:141:47:
                // (q= query )?
                int alt3 = 2;
                int LA3_0 = input.LA(1);
                if (LA3_0 == QUERY) {
                    alt3 = 1;
                }
                switch (alt3) {
                    case 1:
                    // /Users/luigi/Documents/workspace/Parsers/src/OPPLTypes.g:141:47:
                    // q= query
                    {
                        pushFollow(FOLLOW_query_in_statement123);
                        q = query();
                        state._fsp--;
                        if (state.failed) {
                            return retval;
                        }
                    }
                        break;
                }
                pushFollow(FOLLOW_actions_in_statement126);
                actions1 = actions();
                state._fsp--;
                if (state.failed) {
                    return retval;
                }
                match(input, Token.UP, null);
                if (state.failed) {
                    return retval;
                }
                if (state.backtracking == 1) {
                    try {
                        if (vd != null) {
                            vds.addAll(vd != null ? vd.variables : null);
                        }
                        if (!(actions1 != null ? actions1.actions : null).isEmpty()) {
                            if (q != null) {
                                // If the query tree is not null but the
                                // returned query contains errors (hence it is
                                // null) the script should be null.
                                ((OPPLSyntaxTree) retval.start)
                                        .setOPPLContent((q != null ? q.query : null) == null ? null
                                                : getOPPLFactory()
                                                        .buildOPPLScript(
                                                                getConstraintSystem(),
                                                                vds,
                                                                q != null ? q.query
                                                                        : null,
                                                                actions1 != null ? actions1.actions
                                                                        : null));
                            } else {
                                ((OPPLSyntaxTree) retval.start)
                                        .setOPPLContent(getOPPLFactory().buildOPPLScript(
                                                getConstraintSystem(),
                                                vds,
                                                null,
                                                actions1 != null ? actions1.actions
                                                        : null));
                            }
                        }
                    } catch (IllegalArgumentException e) {
                        getErrorListener().reportThrowable(e,
                                ((OPPLSyntaxTree) retval.start).getLine(),
                                ((OPPLSyntaxTree) retval.start).getCharPositionInLine(),
                                ((OPPLSyntaxTree) retval.start).getText().length());
                    }
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
        return retval;
    }

    // $ANTLR end "statement"
    public static class variableDefinitions_return extends TreeRuleReturnScope {
        public List<Variable<?>> variables;
    }

    // $ANTLR start "variableDefinitions"
    // /Users/luigi/Documents/workspace/Parsers/src/OPPLTypes.g:163:1:
    // variableDefinitions returns [List<Variable<?>> variables] : ^(
    // VARIABLE_DEFINITIONS (vd= variableDefinition )+ ) ;
    public final OPPLTypes.variableDefinitions_return variableDefinitions()
            throws RecognitionException {
        OPPLTypes.variableDefinitions_return retval = new OPPLTypes.variableDefinitions_return();
        retval.start = input.LT(1);
        OPPLTypes.variableDefinition_return vd = null;
        List<Variable<?>> toReturn = new ArrayList<Variable<?>>();
        try {
            // /Users/luigi/Documents/workspace/Parsers/src/OPPLTypes.g:171:2: (
            // ^( VARIABLE_DEFINITIONS (vd= variableDefinition )+ ) )
            // /Users/luigi/Documents/workspace/Parsers/src/OPPLTypes.g:172:3:
            // ^( VARIABLE_DEFINITIONS (vd= variableDefinition )+ )
            {
                match(input, VARIABLE_DEFINITIONS,
                        FOLLOW_VARIABLE_DEFINITIONS_in_variableDefinitions157);
                if (state.failed) {
                    return retval;
                }
                match(input, Token.DOWN, null);
                if (state.failed) {
                    return retval;
                }
                // /Users/luigi/Documents/workspace/Parsers/src/OPPLTypes.g:172:26:
                // (vd= variableDefinition )+
                int cnt4 = 0;
                loop4: do {
                    int alt4 = 2;
                    int LA4_0 = input.LA(1);
                    if (LA4_0 >= INPUT_VARIABLE_DEFINITION
                            && LA4_0 <= GENERATED_VARIABLE_DEFINITION) {
                        alt4 = 1;
                    }
                    switch (alt4) {
                        case 1:
                        // /Users/luigi/Documents/workspace/Parsers/src/OPPLTypes.g:172:27:
                        // vd= variableDefinition
                        {
                            pushFollow(FOLLOW_variableDefinition_in_variableDefinitions164);
                            vd = variableDefinition();
                            state._fsp--;
                            if (state.failed) {
                                return retval;
                            }
                            if (state.backtracking == 1) {
                                toReturn.add(vd.variable);
                            }
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
            }
            if (state.backtracking == 1) {
                retval.variables = toReturn;
                ((OPPLSyntaxTree) retval.start).setOPPLContent(retval.variables);
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

    // $ANTLR end "variableDefinitions"
    public static class query_return extends TreeRuleReturnScope {
        public OPPLQuery query;
        public OPPLSyntaxTree node;
    }

    // $ANTLR start "query"
    // /Users/luigi/Documents/workspace/Parsers/src/OPPLTypes.g:175:1: query
    // returns [OPPLQuery query, OPPLSyntaxTree node] : ^( QUERY ( selectClause
    // )+ ( constraint )* ) ;
    public final OPPLTypes.query_return query() throws RecognitionException {
        OPPLTypes.query_return retval = new OPPLTypes.query_return();
        retval.start = input.LT(1);
        OPPLTypes.selectClause_return selectClause2 = null;
        OPPLTypes.constraint_return constraint3 = null;
        retval.query = getOPPLFactory().buildNewQuery(getConstraintSystem());
        try {
            // /Users/luigi/Documents/workspace/Parsers/src/OPPLTypes.g:187:2: (
            // ^( QUERY ( selectClause )+ ( constraint )* ) )
            // /Users/luigi/Documents/workspace/Parsers/src/OPPLTypes.g:188:3:
            // ^( QUERY ( selectClause )+ ( constraint )* )
            {
                match(input, QUERY, FOLLOW_QUERY_in_query198);
                if (state.failed) {
                    return retval;
                }
                match(input, Token.DOWN, null);
                if (state.failed) {
                    return retval;
                }
                // /Users/luigi/Documents/workspace/Parsers/src/OPPLTypes.g:188:11:
                // ( selectClause )+
                int cnt5 = 0;
                loop5: do {
                    int alt5 = 2;
                    int LA5_0 = input.LA(1);
                    if (LA5_0 >= ASSERTED_CLAUSE && LA5_0 <= PLAIN_CLAUSE) {
                        alt5 = 1;
                    }
                    switch (alt5) {
                        case 1:
                        // /Users/luigi/Documents/workspace/Parsers/src/OPPLTypes.g:188:12:
                        // selectClause
                        {
                            pushFollow(FOLLOW_selectClause_in_query201);
                            selectClause2 = selectClause();
                            state._fsp--;
                            if (state.failed) {
                                return retval;
                            }
                            if (state.backtracking == 1) {
                                if ((selectClause2 != null ? selectClause2.axiom : null) != null) {
                                    if (selectClause2 != null ? selectClause2.asserted
                                            : false) {
                                        retval.query
                                                .addAssertedAxiom(selectClause2 != null ? selectClause2.axiom
                                                        : null);
                                    } else {
                                        retval.query
                                                .addAxiom(selectClause2 != null ? selectClause2.axiom
                                                        : null);
                                    }
                                }
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
                // /Users/luigi/Documents/workspace/Parsers/src/OPPLTypes.g:198:6:
                // ( constraint )*
                loop6: do {
                    int alt6 = 2;
                    int LA6_0 = input.LA(1);
                    if (LA6_0 >= INEQUALITY_CONSTRAINT && LA6_0 <= IN_SET_CONSTRAINT
                            || LA6_0 == REGEXP_CONSTRAINT || LA6_0 == NAF_CONSTRAINT) {
                        alt6 = 1;
                    }
                    switch (alt6) {
                        case 1:
                        // /Users/luigi/Documents/workspace/Parsers/src/OPPLTypes.g:198:7:
                        // constraint
                        {
                            pushFollow(FOLLOW_constraint_in_query214);
                            constraint3 = constraint();
                            state._fsp--;
                            if (state.failed) {
                                return retval;
                            }
                            if (state.backtracking == 1) {
                                if ((constraint3 != null ? constraint3.constraint : null) != null) {
                                    retval.query
                                            .addConstraint(constraint3 != null ? constraint3.constraint
                                                    : null);
                                }
                            }
                        }
                            break;
                        default:
                            break loop6;
                    }
                } while (true);
                match(input, Token.UP, null);
                if (state.failed) {
                    return retval;
                }
            }
            if (state.backtracking == 1) {
                // No asserted axioms and plains axioms means no query at all.
                if (retval.query.getAssertedAxioms().isEmpty()
                        && retval.query.getAxioms().isEmpty()) {
                    retval.query = null;
                }
                ((OPPLSyntaxTree) retval.start).setOPPLContent(retval.query);
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
        } finally {}
        return retval;
    }

    // $ANTLR end "query"
    public static class selectClause_return extends TreeRuleReturnScope {
        public OWLAxiom axiom;
        public boolean asserted;
    }

    // $ANTLR start "selectClause"
    // /Users/luigi/Documents/workspace/Parsers/src/OPPLTypes.g:207:1:
    // selectClause returns [OWLAxiom axiom, boolean asserted] : ( ^(
    // ASSERTED_CLAUSE a= . ) | ^( PLAIN_CLAUSE a= . ) );
    public final OPPLTypes.selectClause_return selectClause() throws RecognitionException {
        OPPLTypes.selectClause_return retval = new OPPLTypes.selectClause_return();
        retval.start = input.LT(1);
        OPPLSyntaxTree a = null;
        try {
            // /Users/luigi/Documents/workspace/Parsers/src/OPPLTypes.g:208:2: (
            // ^( ASSERTED_CLAUSE a= . ) | ^( PLAIN_CLAUSE a= . ) )
            int alt7 = 2;
            int LA7_0 = input.LA(1);
            if (LA7_0 == ASSERTED_CLAUSE) {
                alt7 = 1;
            } else if (LA7_0 == PLAIN_CLAUSE) {
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
                // /Users/luigi/Documents/workspace/Parsers/src/OPPLTypes.g:209:3:
                // ^( ASSERTED_CLAUSE a= . )
                {
                    match(input, ASSERTED_CLAUSE,
                            FOLLOW_ASSERTED_CLAUSE_in_selectClause243);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.DOWN, null);
                    if (state.failed) {
                        return retval;
                    }
                    a = (OPPLSyntaxTree) input.LT(1);
                    matchAny(input);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.UP, null);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 1) {
                        OWLObject object = a.getOWLObject();
                        if (object instanceof OWLAxiom) {
                            retval.axiom = (OWLAxiom) a.getOWLObject();
                        } else {
                            getErrorListener().illegalToken(a, "OWL Axiom needed here");
                        }
                        retval.asserted = true;
                    }
                }
                    break;
                case 2:
                // /Users/luigi/Documents/workspace/Parsers/src/OPPLTypes.g:220:5:
                // ^( PLAIN_CLAUSE a= . )
                {
                    match(input, PLAIN_CLAUSE, FOLLOW_PLAIN_CLAUSE_in_selectClause261);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.DOWN, null);
                    if (state.failed) {
                        return retval;
                    }
                    a = (OPPLSyntaxTree) input.LT(1);
                    matchAny(input);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.UP, null);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 1) {
                        OWLObject object = a.getOWLObject();
                        if (object instanceof OWLAxiom) {
                            retval.axiom = (OWLAxiom) a.getOWLObject();
                        } else {
                            getErrorListener().illegalToken(a, "OWL Axiom needed here");
                        }
                        retval.asserted = false;
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
        return retval;
    }

    // $ANTLR end "selectClause"
    public static class actions_return extends TreeRuleReturnScope {
        public List<OWLAxiomChange> actions;
    }

    // $ANTLR start "actions"
    // /Users/luigi/Documents/workspace/Parsers/src/OPPLTypes.g:232:1: actions
    // returns [List<OWLAxiomChange> actions] : ^( ACTIONS ( action )+ ) ;
    public final OPPLTypes.actions_return actions() throws RecognitionException {
        OPPLTypes.actions_return retval = new OPPLTypes.actions_return();
        retval.start = input.LT(1);
        OWLAxiomChange action4 = null;
        retval.actions = new ArrayList<OWLAxiomChange>();
        try {
            // /Users/luigi/Documents/workspace/Parsers/src/OPPLTypes.g:239:2: (
            // ^( ACTIONS ( action )+ ) )
            // /Users/luigi/Documents/workspace/Parsers/src/OPPLTypes.g:240:3:
            // ^( ACTIONS ( action )+ )
            {
                match(input, ACTIONS, FOLLOW_ACTIONS_in_actions298);
                if (state.failed) {
                    return retval;
                }
                match(input, Token.DOWN, null);
                if (state.failed) {
                    return retval;
                }
                // /Users/luigi/Documents/workspace/Parsers/src/OPPLTypes.g:240:13:
                // ( action )+
                int cnt8 = 0;
                loop8: do {
                    int alt8 = 2;
                    int LA8_0 = input.LA(1);
                    if (LA8_0 >= ADD && LA8_0 <= REMOVE) {
                        alt8 = 1;
                    }
                    switch (alt8) {
                        case 1:
                        // /Users/luigi/Documents/workspace/Parsers/src/OPPLTypes.g:240:14:
                        // action
                        {
                            pushFollow(FOLLOW_action_in_actions301);
                            action4 = action();
                            state._fsp--;
                            if (state.failed) {
                                return retval;
                            }
                            if (state.backtracking == 1) {
                                if (action4 != null) {
                                    retval.actions.add(action4);
                                }
                            }
                        }
                            break;
                        default:
                            if (cnt8 >= 1) {
                                break loop8;
                            }
                            if (state.backtracking > 0) {
                                state.failed = true;
                                return retval;
                            }
                            EarlyExitException eee = new EarlyExitException(8, input);
                            throw eee;
                    }
                    cnt8++;
                } while (true);
                match(input, Token.UP, null);
                if (state.failed) {
                    return retval;
                }
            }
            if (state.backtracking == 1) {
                ((OPPLSyntaxTree) retval.start).setOPPLContent(retval.actions);
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

    // $ANTLR end "actions"
    // $ANTLR start "action"
    // /Users/luigi/Documents/workspace/Parsers/src/OPPLTypes.g:250:1: action
    // returns [OWLAxiomChange change] : ( ^( ADD a= . ) | ^( REMOVE a= . ) );
    public final OWLAxiomChange action() throws RecognitionException {
        OWLAxiomChange change = null;
        OPPLSyntaxTree a = null;
        try {
            // /Users/luigi/Documents/workspace/Parsers/src/OPPLTypes.g:251:2: (
            // ^( ADD a= . ) | ^( REMOVE a= . ) )
            int alt9 = 2;
            int LA9_0 = input.LA(1);
            if (LA9_0 == ADD) {
                alt9 = 1;
            } else if (LA9_0 == REMOVE) {
                alt9 = 2;
            } else {
                if (state.backtracking > 0) {
                    state.failed = true;
                    return change;
                }
                NoViableAltException nvae = new NoViableAltException("", 9, 0, input);
                throw nvae;
            }
            switch (alt9) {
                case 1:
                // /Users/luigi/Documents/workspace/Parsers/src/OPPLTypes.g:252:3:
                // ^( ADD a= . )
                {
                    match(input, ADD, FOLLOW_ADD_in_action332);
                    if (state.failed) {
                        return change;
                    }
                    match(input, Token.DOWN, null);
                    if (state.failed) {
                        return change;
                    }
                    a = (OPPLSyntaxTree) input.LT(1);
                    matchAny(input);
                    if (state.failed) {
                        return change;
                    }
                    match(input, Token.UP, null);
                    if (state.failed) {
                        return change;
                    }
                    if (state.backtracking == 1) {
                        OWLObject object = a.getOWLObject();
                        if (object instanceof OWLAxiom) {
                            change = new AddAxiom(getConstraintSystem().getOntology(),
                                    (OWLAxiom) object);
                        } else {
                            getErrorListener().illegalToken(a, "OWL Axiom needed here");
                        }
                    }
                }
                    break;
                case 2:
                // /Users/luigi/Documents/workspace/Parsers/src/OPPLTypes.g:260:5:
                // ^( REMOVE a= . )
                {
                    match(input, REMOVE, FOLLOW_REMOVE_in_action347);
                    if (state.failed) {
                        return change;
                    }
                    match(input, Token.DOWN, null);
                    if (state.failed) {
                        return change;
                    }
                    a = (OPPLSyntaxTree) input.LT(1);
                    matchAny(input);
                    if (state.failed) {
                        return change;
                    }
                    match(input, Token.UP, null);
                    if (state.failed) {
                        return change;
                    }
                    if (state.backtracking == 1) {
                        OWLObject object = a.getOWLObject();
                        if (object instanceof OWLAxiom) {
                            change = new RemoveAxiom(getConstraintSystem().getOntology(),
                                    (OWLAxiom) object);
                        } else {
                            getErrorListener().illegalToken(a, "OWL Axiom needed here");
                        }
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
        return change;
    }

    // $ANTLR end "action"
    public static class variableDefinition_return extends TreeRuleReturnScope {
        public Variable variable;
    }

    // $ANTLR start "variableDefinition"
    // /Users/luigi/Documents/workspace/Parsers/src/OPPLTypes.g:270:1:
    // variableDefinition returns [Variable variable] : ( ^(
    // INPUT_VARIABLE_DEFINITION VARIABLE_NAME VARIABLE_TYPE (vs= variableScope
    // )? ) | ^( GENERATED_VARIABLE_DEFINITION VARIABLE_NAME VARIABLE_TYPE
    // ^(expr= EXPRESSION ( . )* ) ) | ^( GENERATED_VARIABLE_DEFINITION
    // VARIABLE_NAME VARIABLE_TYPE ^( MATCH se= stringOperation ) ) | ^(
    // GENERATED_VARIABLE_DEFINITION VARIABLE_NAME VARIABLE_TYPE ^(
    // CREATE_OPPL_FUNCTION value= stringOperation ) ) | ^(
    // GENERATED_VARIABLE_DEFINITION name= VARIABLE_NAME VARIABLE_TYPE ^(
    // CREATE_INTERSECTION va= aggregandums ) ) | ^(
    // GENERATED_VARIABLE_DEFINITION name= VARIABLE_NAME VARIABLE_TYPE ^(
    // CREATE_DISJUNCTION va= aggregandums ) ) );
    public final OPPLTypes.variableDefinition_return variableDefinition()
            throws RecognitionException {
        OPPLTypes.variableDefinition_return retval = new OPPLTypes.variableDefinition_return();
        retval.start = input.LT(1);
        OPPLSyntaxTree expr = null;
        OPPLSyntaxTree name = null;
        OPPLSyntaxTree VARIABLE_NAME5 = null;
        OPPLSyntaxTree VARIABLE_TYPE6 = null;
        OPPLSyntaxTree INPUT_VARIABLE_DEFINITION7 = null;
        OPPLSyntaxTree VARIABLE_TYPE8 = null;
        OPPLSyntaxTree VARIABLE_NAME9 = null;
        OPPLSyntaxTree VARIABLE_TYPE10 = null;
        OPPLSyntaxTree VARIABLE_NAME11 = null;
        OPPLSyntaxTree VARIABLE_TYPE12 = null;
        OPPLSyntaxTree VARIABLE_NAME13 = null;
        OPPLSyntaxTree CREATE_INTERSECTION14 = null;
        OPPLSyntaxTree CREATE_DISJUNCTION15 = null;
        OPPLTypes.variableScope_return vs = null;
        OPPLFunction<String> se = null;
        OPPLFunction<String> value = null;
        OPPLTypes.aggregandums_return va = null;
        try {
            // /Users/luigi/Documents/workspace/Parsers/src/OPPLTypes.g:271:2: (
            // ^( INPUT_VARIABLE_DEFINITION VARIABLE_NAME VARIABLE_TYPE (vs=
            // variableScope )? ) | ^( GENERATED_VARIABLE_DEFINITION
            // VARIABLE_NAME VARIABLE_TYPE ^(expr= EXPRESSION ( . )* ) ) | ^(
            // GENERATED_VARIABLE_DEFINITION VARIABLE_NAME VARIABLE_TYPE ^(
            // MATCH se= stringOperation ) ) | ^( GENERATED_VARIABLE_DEFINITION
            // VARIABLE_NAME VARIABLE_TYPE ^( CREATE_OPPL_FUNCTION value=
            // stringOperation ) ) | ^( GENERATED_VARIABLE_DEFINITION name=
            // VARIABLE_NAME VARIABLE_TYPE ^( CREATE_INTERSECTION va=
            // aggregandums ) ) | ^( GENERATED_VARIABLE_DEFINITION name=
            // VARIABLE_NAME VARIABLE_TYPE ^( CREATE_DISJUNCTION va=
            // aggregandums ) ) )
            int alt12 = 6;
            alt12 = dfa12.predict(input);
            switch (alt12) {
                case 1:
                // /Users/luigi/Documents/workspace/Parsers/src/OPPLTypes.g:272:3:
                // ^( INPUT_VARIABLE_DEFINITION VARIABLE_NAME VARIABLE_TYPE (vs=
                // variableScope )? )
                {
                    INPUT_VARIABLE_DEFINITION7 = (OPPLSyntaxTree) match(input,
                            INPUT_VARIABLE_DEFINITION,
                            FOLLOW_INPUT_VARIABLE_DEFINITION_in_variableDefinition375);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.DOWN, null);
                    if (state.failed) {
                        return retval;
                    }
                    VARIABLE_NAME5 = (OPPLSyntaxTree) match(input, VARIABLE_NAME,
                            FOLLOW_VARIABLE_NAME_in_variableDefinition377);
                    if (state.failed) {
                        return retval;
                    }
                    VARIABLE_TYPE6 = (OPPLSyntaxTree) match(input, VARIABLE_TYPE,
                            FOLLOW_VARIABLE_TYPE_in_variableDefinition379);
                    if (state.failed) {
                        return retval;
                    }
                    // /Users/luigi/Documents/workspace/Parsers/src/OPPLTypes.g:272:62:
                    // (vs= variableScope )?
                    int alt10 = 2;
                    int LA10_0 = input.LA(1);
                    if (LA10_0 == VARIABLE_SCOPE) {
                        alt10 = 1;
                    }
                    switch (alt10) {
                        case 1:
                        // /Users/luigi/Documents/workspace/Parsers/src/OPPLTypes.g:272:62:
                        // vs= variableScope
                        {
                            pushFollow(FOLLOW_variableScope_in_variableDefinition385);
                            vs = variableScope();
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
                        try {
                            if (vs != null && vs.variableScope == null) {
                                getErrorListener().illegalToken(
                                        (OPPLSyntaxTree) retval.start,
                                        "Invalid variable scope");
                            } else {
                                retval.variable = getConstraintSystem().createVariable(
                                        VARIABLE_NAME5.getToken().getText(),
                                        symtab.getVaribaleType(VARIABLE_TYPE6),
                                        vs == null ? null : vs.variableScope);
                            }
                        } catch (OPPLException e) {
                            getErrorListener().reportThrowable(
                                    e,
                                    INPUT_VARIABLE_DEFINITION7.token.getLine(),
                                    INPUT_VARIABLE_DEFINITION7.token
                                            .getCharPositionInLine(),
                                    INPUT_VARIABLE_DEFINITION7.token.getText().length());
                        }
                    }
                }
                    break;
                case 2:
                // /Users/luigi/Documents/workspace/Parsers/src/OPPLTypes.g:284:7:
                // ^( GENERATED_VARIABLE_DEFINITION VARIABLE_NAME VARIABLE_TYPE
                // ^(expr= EXPRESSION ( . )* ) )
                {
                    match(input, GENERATED_VARIABLE_DEFINITION,
                            FOLLOW_GENERATED_VARIABLE_DEFINITION_in_variableDefinition400);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.DOWN, null);
                    if (state.failed) {
                        return retval;
                    }
                    VARIABLE_NAME9 = (OPPLSyntaxTree) match(input, VARIABLE_NAME,
                            FOLLOW_VARIABLE_NAME_in_variableDefinition402);
                    if (state.failed) {
                        return retval;
                    }
                    VARIABLE_TYPE8 = (OPPLSyntaxTree) match(input, VARIABLE_TYPE,
                            FOLLOW_VARIABLE_TYPE_in_variableDefinition404);
                    if (state.failed) {
                        return retval;
                    }
                    expr = (OPPLSyntaxTree) match(input, EXPRESSION,
                            FOLLOW_EXPRESSION_in_variableDefinition412);
                    if (state.failed) {
                        return retval;
                    }
                    if (input.LA(1) == Token.DOWN) {
                        match(input, Token.DOWN, null);
                        if (state.failed) {
                            return retval;
                        }
                        // /Users/luigi/Documents/workspace/Parsers/src/OPPLTypes.g:284:88:
                        // ( . )*
                        loop11: do {
                            int alt11 = 2;
                            int LA11_0 = input.LA(1);
                            if (LA11_0 >= COMPOSITION && LA11_0 <= GREATER_THAN_EQUAL) {
                                alt11 = 1;
                            } else if (LA11_0 == UP) {
                                alt11 = 2;
                            }
                            switch (alt11) {
                                case 1:
                                // /Users/luigi/Documents/workspace/Parsers/src/OPPLTypes.g:284:88:
                                // .
                                {
                                    matchAny(input);
                                    if (state.failed) {
                                        return retval;
                                    }
                                }
                                    break;
                                default:
                                    break loop11;
                            }
                        } while (true);
                        match(input, Token.UP, null);
                        if (state.failed) {
                            return retval;
                        }
                    }
                    match(input, Token.UP, null);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 1) {
                        Type type = getSymbolTable().getExpressionGeneratedVariableType(
                                (OPPLSyntaxTree) retval.start, VARIABLE_TYPE8, expr);
                        if (type != null) {
                            OWLObject expressionOWLObject = expr.getOWLObject();
                            if (expressionOWLObject != null) {
                                GeneratedVariable<?> v = getConstraintSystem()
                                        .createExpressionGeneratedVariable(
                                                VARIABLE_NAME9.getText(),
                                                expressionOWLObject);
                                if (v == null) {
                                    getErrorListener().illegalToken(expr,
                                            "Invalid expression to assign to a variable");
                                }
                                retval.variable = v;
                            } else {
                                getErrorListener()
                                        .reportThrowable(
                                                new NullPointerException(
                                                        "The type of the generated variable is null"),
                                                expr.token.getLine(),
                                                expr.token.getCharPositionInLine(),
                                                expr.token.getText().length());
                            }
                        } else {
                            getErrorListener()
                                    .reportThrowable(
                                            new NullPointerException(
                                                    "The type of the generated variable is null"),
                                            ((OPPLSyntaxTree) retval.start).token
                                                    .getLine(),
                                            ((OPPLSyntaxTree) retval.start).token
                                                    .getCharPositionInLine(),
                                            ((OPPLSyntaxTree) retval.start).token
                                                    .getText().length());
                        }
                    }
                }
                    break;
                case 3:
                // /Users/luigi/Documents/workspace/Parsers/src/OPPLTypes.g:302:5:
                // ^( GENERATED_VARIABLE_DEFINITION VARIABLE_NAME VARIABLE_TYPE
                // ^( MATCH se= stringOperation ) )
                {
                    match(input, GENERATED_VARIABLE_DEFINITION,
                            FOLLOW_GENERATED_VARIABLE_DEFINITION_in_variableDefinition432);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.DOWN, null);
                    if (state.failed) {
                        return retval;
                    }
                    VARIABLE_NAME11 = (OPPLSyntaxTree) match(input, VARIABLE_NAME,
                            FOLLOW_VARIABLE_NAME_in_variableDefinition434);
                    if (state.failed) {
                        return retval;
                    }
                    VARIABLE_TYPE10 = (OPPLSyntaxTree) match(input, VARIABLE_TYPE,
                            FOLLOW_VARIABLE_TYPE_in_variableDefinition436);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, MATCH, FOLLOW_MATCH_in_variableDefinition439);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.DOWN, null);
                    if (state.failed) {
                        return retval;
                    }
                    pushFollow(FOLLOW_stringOperation_in_variableDefinition445);
                    se = stringOperation();
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
                        org.coode.oppl.variabletypes.VariableType<?> type = org.coode.parsers.oppl.VariableType
                                .getVariableType(VARIABLE_TYPE10.getText())
                                .getOPPLVariableType();
                        RegexpGeneratedVariable<?> v = getConstraintSystem()
                                .createRegexpGeneratedVariable(VARIABLE_NAME11.getText(),
                                        type, Adapter.buildRegexpPatternAdapter(se));
                        retval.variable = v;
                    }
                }
                    break;
                case 4:
                // /Users/luigi/Documents/workspace/Parsers/src/OPPLTypes.g:308:5:
                // ^( GENERATED_VARIABLE_DEFINITION VARIABLE_NAME VARIABLE_TYPE
                // ^( CREATE_OPPL_FUNCTION value= stringOperation ) )
                {
                    match(input, GENERATED_VARIABLE_DEFINITION,
                            FOLLOW_GENERATED_VARIABLE_DEFINITION_in_variableDefinition459);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.DOWN, null);
                    if (state.failed) {
                        return retval;
                    }
                    VARIABLE_NAME13 = (OPPLSyntaxTree) match(input, VARIABLE_NAME,
                            FOLLOW_VARIABLE_NAME_in_variableDefinition461);
                    if (state.failed) {
                        return retval;
                    }
                    VARIABLE_TYPE12 = (OPPLSyntaxTree) match(input, VARIABLE_TYPE,
                            FOLLOW_VARIABLE_TYPE_in_variableDefinition463);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, CREATE_OPPL_FUNCTION,
                            FOLLOW_CREATE_OPPL_FUNCTION_in_variableDefinition466);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.DOWN, null);
                    if (state.failed) {
                        return retval;
                    }
                    pushFollow(FOLLOW_stringOperation_in_variableDefinition473);
                    value = stringOperation();
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
                        org.coode.oppl.variabletypes.VariableType type = org.coode.parsers.oppl.VariableType
                                .getVariableType(VARIABLE_TYPE12.getText())
                                .getOPPLVariableType();
                        retval.variable = constraintSystem.createStringGeneratedVariable(
                                VARIABLE_NAME13.getText(), type, value);
                    }
                }
                    break;
                case 5:
                // /Users/luigi/Documents/workspace/Parsers/src/OPPLTypes.g:313:5:
                // ^( GENERATED_VARIABLE_DEFINITION name= VARIABLE_NAME
                // VARIABLE_TYPE ^( CREATE_INTERSECTION va= aggregandums ) )
                {
                    match(input, GENERATED_VARIABLE_DEFINITION,
                            FOLLOW_GENERATED_VARIABLE_DEFINITION_in_variableDefinition486);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.DOWN, null);
                    if (state.failed) {
                        return retval;
                    }
                    name = (OPPLSyntaxTree) match(input, VARIABLE_NAME,
                            FOLLOW_VARIABLE_NAME_in_variableDefinition492);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, VARIABLE_TYPE,
                            FOLLOW_VARIABLE_TYPE_in_variableDefinition494);
                    if (state.failed) {
                        return retval;
                    }
                    CREATE_INTERSECTION14 = (OPPLSyntaxTree) match(input,
                            CREATE_INTERSECTION,
                            FOLLOW_CREATE_INTERSECTION_in_variableDefinition497);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.DOWN, null);
                    if (state.failed) {
                        return retval;
                    }
                    pushFollow(FOLLOW_aggregandums_in_variableDefinition503);
                    va = aggregandums();
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
                        Collection<? extends Aggregandum<Collection<? extends OWLClassExpression>>> aggregandumCollection = getSymbolTable()
                                .getAggregandumCollection(
                                        VariableTypeFactory.getCLASSVariableType(),
                                        va.list, va.tokenList, CREATE_INTERSECTION14);
                        if (aggregandumCollection != null) {
                            retval.variable = getConstraintSystem()
                                    .createIntersectionGeneratedVariable(name.getText(),
                                            VariableTypeFactory.getCLASSVariableType(),
                                            aggregandumCollection);
                        }
                    }
                }
                    break;
                case 6:
                // /Users/luigi/Documents/workspace/Parsers/src/OPPLTypes.g:325:5:
                // ^( GENERATED_VARIABLE_DEFINITION name= VARIABLE_NAME
                // VARIABLE_TYPE ^( CREATE_DISJUNCTION va= aggregandums ) )
                {
                    match(input, GENERATED_VARIABLE_DEFINITION,
                            FOLLOW_GENERATED_VARIABLE_DEFINITION_in_variableDefinition516);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.DOWN, null);
                    if (state.failed) {
                        return retval;
                    }
                    name = (OPPLSyntaxTree) match(input, VARIABLE_NAME,
                            FOLLOW_VARIABLE_NAME_in_variableDefinition522);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, VARIABLE_TYPE,
                            FOLLOW_VARIABLE_TYPE_in_variableDefinition524);
                    if (state.failed) {
                        return retval;
                    }
                    CREATE_DISJUNCTION15 = (OPPLSyntaxTree) match(input,
                            CREATE_DISJUNCTION,
                            FOLLOW_CREATE_DISJUNCTION_in_variableDefinition527);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.DOWN, null);
                    if (state.failed) {
                        return retval;
                    }
                    pushFollow(FOLLOW_aggregandums_in_variableDefinition533);
                    va = aggregandums();
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
                        Collection<? extends Aggregandum<Collection<? extends OWLClassExpression>>> aggregandumCollection = getSymbolTable()
                                .getAggregandumCollection(
                                        VariableTypeFactory.getCLASSVariableType(),
                                        va.list, va.tokenList, CREATE_DISJUNCTION15);
                        if (aggregandumCollection != null) {
                            retval.variable = getConstraintSystem()
                                    .createUnionGeneratedVariable(name.getText(),
                                            VariableTypeFactory.getCLASSVariableType(),
                                            aggregandumCollection);
                        }
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
        return retval;
    }

    // $ANTLR end "variableDefinition"
    // $ANTLR start "stringOperation"
    // /Users/luigi/Documents/workspace/Parsers/src/OPPLTypes.g:344:1:
    // stringOperation returns [OPPLFunction<String> value] : ^(
    // STRING_OPERATION (valuesToAggregate= stringExpression )+ ) ;
    public final OPPLFunction<String> stringOperation() throws RecognitionException {
        OPPLFunction<String> value = null;
        OPPLFunction<String> valuesToAggregate = null;
        List<Aggregandum<String>> values = new ArrayList<Aggregandum<String>>();
        try {
            // /Users/luigi/Documents/workspace/Parsers/src/OPPLTypes.g:349:3: (
            // ^( STRING_OPERATION (valuesToAggregate= stringExpression )+ ) )
            // /Users/luigi/Documents/workspace/Parsers/src/OPPLTypes.g:350:5:
            // ^( STRING_OPERATION (valuesToAggregate= stringExpression )+ )
            {
                match(input, STRING_OPERATION,
                        FOLLOW_STRING_OPERATION_in_stringOperation587);
                if (state.failed) {
                    return value;
                }
                match(input, Token.DOWN, null);
                if (state.failed) {
                    return value;
                }
                // /Users/luigi/Documents/workspace/Parsers/src/OPPLTypes.g:350:26:
                // (valuesToAggregate= stringExpression )+
                int cnt13 = 0;
                loop13: do {
                    int alt13 = 2;
                    int LA13_0 = input.LA(1);
                    if (LA13_0 == DBLQUOTE || LA13_0 == IDENTIFIER
                            || LA13_0 >= TO_LOWER_CASE && LA13_0 <= TO_UPPER_CASE) {
                        alt13 = 1;
                    }
                    switch (alt13) {
                        case 1:
                        // /Users/luigi/Documents/workspace/Parsers/src/OPPLTypes.g:350:27:
                        // valuesToAggregate= stringExpression
                        {
                            pushFollow(FOLLOW_stringExpression_in_stringOperation595);
                            valuesToAggregate = stringExpression();
                            state._fsp--;
                            if (state.failed) {
                                return value;
                            }
                            if (state.backtracking == 1) {
                                values.add(Adapter
                                        .buildSingletonAggregandum(valuesToAggregate));
                            }
                        }
                            break;
                        default:
                            if (cnt13 >= 1) {
                                break loop13;
                            }
                            if (state.backtracking > 0) {
                                state.failed = true;
                                return value;
                            }
                            EarlyExitException eee = new EarlyExitException(13, input);
                            throw eee;
                    }
                    cnt13++;
                } while (true);
                match(input, Token.UP, null);
                if (state.failed) {
                    return value;
                }
                if (state.backtracking == 1) {
                    value = Aggregation.buildStringConcatenation(values);
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
        return value;
    }

    // $ANTLR end "stringOperation"
    // $ANTLR start "stringExpression"
    // /Users/luigi/Documents/workspace/Parsers/src/OPPLTypes.g:360:1:
    // stringExpression returns [OPPLFunction<String> value] : ( DBLQUOTE | ^(
    // IDENTIFIER VARIABLE_NAME DOT GROUPS ^( ATTRIBUTE_SELECTOR INTEGER ) ) |
    // ^( IDENTIFIER VARIABLE_NAME DOT RENDERING ) | ^( TO_LOWER_CASE
    // expression= stringOperation ) | ^( TO_UPPER_CASE expression=
    // stringOperation ) | ^( TO_LOWER_CASE simpleExpression= stringExpression )
    // | ^( TO_UPPER_CASE simpleExpression= stringExpression ) );
    public final OPPLFunction<String> stringExpression() throws RecognitionException {
        OPPLFunction<String> value = null;
        OPPLSyntaxTree DBLQUOTE16 = null;
        OPPLSyntaxTree VARIABLE_NAME17 = null;
        OPPLSyntaxTree INTEGER18 = null;
        OPPLSyntaxTree VARIABLE_NAME19 = null;
        OPPLFunction<String> expression = null;
        OPPLFunction<String> simpleExpression = null;
        try {
            // /Users/luigi/Documents/workspace/Parsers/src/OPPLTypes.g:361:3: (
            // DBLQUOTE | ^( IDENTIFIER VARIABLE_NAME DOT GROUPS ^(
            // ATTRIBUTE_SELECTOR INTEGER ) ) | ^( IDENTIFIER VARIABLE_NAME DOT
            // RENDERING ) | ^( TO_LOWER_CASE expression= stringOperation ) | ^(
            // TO_UPPER_CASE expression= stringOperation ) | ^( TO_LOWER_CASE
            // simpleExpression= stringExpression ) | ^( TO_UPPER_CASE
            // simpleExpression= stringExpression ) )
            int alt14 = 7;
            alt14 = dfa14.predict(input);
            switch (alt14) {
                case 1:
                // /Users/luigi/Documents/workspace/Parsers/src/OPPLTypes.g:362:7:
                // DBLQUOTE
                {
                    DBLQUOTE16 = (OPPLSyntaxTree) match(input, DBLQUOTE,
                            FOLLOW_DBLQUOTE_in_stringExpression635);
                    if (state.failed) {
                        return value;
                    }
                    if (state.backtracking == 1) {
                        value = new Constant<String>(DBLQUOTE16.getText());
                    }
                }
                    break;
                case 2:
                // /Users/luigi/Documents/workspace/Parsers/src/OPPLTypes.g:366:10:
                // ^( IDENTIFIER VARIABLE_NAME DOT GROUPS ^( ATTRIBUTE_SELECTOR
                // INTEGER ) )
                {
                    match(input, IDENTIFIER, FOLLOW_IDENTIFIER_in_stringExpression655);
                    if (state.failed) {
                        return value;
                    }
                    match(input, Token.DOWN, null);
                    if (state.failed) {
                        return value;
                    }
                    VARIABLE_NAME17 = (OPPLSyntaxTree) match(input, VARIABLE_NAME,
                            FOLLOW_VARIABLE_NAME_in_stringExpression657);
                    if (state.failed) {
                        return value;
                    }
                    match(input, DOT, FOLLOW_DOT_in_stringExpression659);
                    if (state.failed) {
                        return value;
                    }
                    match(input, GROUPS, FOLLOW_GROUPS_in_stringExpression661);
                    if (state.failed) {
                        return value;
                    }
                    match(input, ATTRIBUTE_SELECTOR,
                            FOLLOW_ATTRIBUTE_SELECTOR_in_stringExpression664);
                    if (state.failed) {
                        return value;
                    }
                    match(input, Token.DOWN, null);
                    if (state.failed) {
                        return value;
                    }
                    INTEGER18 = (OPPLSyntaxTree) match(input, INTEGER,
                            FOLLOW_INTEGER_in_stringExpression666);
                    if (state.failed) {
                        return value;
                    }
                    match(input, Token.UP, null);
                    if (state.failed) {
                        return value;
                    }
                    match(input, Token.UP, null);
                    if (state.failed) {
                        return value;
                    }
                    if (state.backtracking == 1) {
                        value = getSymbolTable().defineGroupAttributeReferenceSymbol(
                                VARIABLE_NAME17, INTEGER18, getConstraintSystem());
                    }
                }
                    break;
                case 3:
                // /Users/luigi/Documents/workspace/Parsers/src/OPPLTypes.g:370:7:
                // ^( IDENTIFIER VARIABLE_NAME DOT RENDERING )
                {
                    match(input, IDENTIFIER, FOLLOW_IDENTIFIER_in_stringExpression685);
                    if (state.failed) {
                        return value;
                    }
                    match(input, Token.DOWN, null);
                    if (state.failed) {
                        return value;
                    }
                    VARIABLE_NAME19 = (OPPLSyntaxTree) match(input, VARIABLE_NAME,
                            FOLLOW_VARIABLE_NAME_in_stringExpression688);
                    if (state.failed) {
                        return value;
                    }
                    match(input, DOT, FOLLOW_DOT_in_stringExpression690);
                    if (state.failed) {
                        return value;
                    }
                    match(input, RENDERING, FOLLOW_RENDERING_in_stringExpression694);
                    if (state.failed) {
                        return value;
                    }
                    match(input, Token.UP, null);
                    if (state.failed) {
                        return value;
                    }
                    if (state.backtracking == 1) {
                        value = getSymbolTable().defineRenderingAttributeReferenceSymbol(
                                VARIABLE_NAME19, getConstraintSystem());
                    }
                }
                    break;
                case 4:
                // /Users/luigi/Documents/workspace/Parsers/src/OPPLTypes.g:374:6:
                // ^( TO_LOWER_CASE expression= stringOperation )
                {
                    match(input, TO_LOWER_CASE,
                            FOLLOW_TO_LOWER_CASE_in_stringExpression709);
                    if (state.failed) {
                        return value;
                    }
                    match(input, Token.DOWN, null);
                    if (state.failed) {
                        return value;
                    }
                    pushFollow(FOLLOW_stringOperation_in_stringExpression715);
                    expression = stringOperation();
                    state._fsp--;
                    if (state.failed) {
                        return value;
                    }
                    match(input, Token.UP, null);
                    if (state.failed) {
                        return value;
                    }
                    if (state.backtracking == 1) {
                        value = new ToLowerCaseStringManipulationOPPLFunction(expression);
                    }
                }
                    break;
                case 5:
                // /Users/luigi/Documents/workspace/Parsers/src/OPPLTypes.g:377:7:
                // ^( TO_UPPER_CASE expression= stringOperation )
                {
                    match(input, TO_UPPER_CASE,
                            FOLLOW_TO_UPPER_CASE_in_stringExpression726);
                    if (state.failed) {
                        return value;
                    }
                    match(input, Token.DOWN, null);
                    if (state.failed) {
                        return value;
                    }
                    pushFollow(FOLLOW_stringOperation_in_stringExpression732);
                    expression = stringOperation();
                    state._fsp--;
                    if (state.failed) {
                        return value;
                    }
                    match(input, Token.UP, null);
                    if (state.failed) {
                        return value;
                    }
                    if (state.backtracking == 1) {
                        value = new ToUpperCaseStringManipulationOPPLFunction(expression);
                    }
                }
                    break;
                case 6:
                // /Users/luigi/Documents/workspace/Parsers/src/OPPLTypes.g:380:6:
                // ^( TO_LOWER_CASE simpleExpression= stringExpression )
                {
                    match(input, TO_LOWER_CASE,
                            FOLLOW_TO_LOWER_CASE_in_stringExpression742);
                    if (state.failed) {
                        return value;
                    }
                    match(input, Token.DOWN, null);
                    if (state.failed) {
                        return value;
                    }
                    pushFollow(FOLLOW_stringExpression_in_stringExpression748);
                    simpleExpression = stringExpression();
                    state._fsp--;
                    if (state.failed) {
                        return value;
                    }
                    match(input, Token.UP, null);
                    if (state.failed) {
                        return value;
                    }
                    if (state.backtracking == 1) {
                        value = new ToLowerCaseStringManipulationOPPLFunction(
                                simpleExpression);
                    }
                }
                    break;
                case 7:
                // /Users/luigi/Documents/workspace/Parsers/src/OPPLTypes.g:383:7:
                // ^( TO_UPPER_CASE simpleExpression= stringExpression )
                {
                    match(input, TO_UPPER_CASE,
                            FOLLOW_TO_UPPER_CASE_in_stringExpression759);
                    if (state.failed) {
                        return value;
                    }
                    match(input, Token.DOWN, null);
                    if (state.failed) {
                        return value;
                    }
                    pushFollow(FOLLOW_stringExpression_in_stringExpression765);
                    simpleExpression = stringExpression();
                    state._fsp--;
                    if (state.failed) {
                        return value;
                    }
                    match(input, Token.UP, null);
                    if (state.failed) {
                        return value;
                    }
                    if (state.backtracking == 1) {
                        value = new ToUpperCaseStringManipulationOPPLFunction(
                                simpleExpression);
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
        return value;
    }

    // $ANTLR end "stringExpression"
    public static class variableScope_return extends TreeRuleReturnScope {
        public Type type;
        public VariableScope variableScope;
    }

    // $ANTLR start "variableScope"
    // /Users/luigi/Documents/workspace/Parsers/src/OPPLTypes.g:395:1:
    // variableScope returns [Type type, VariableScope variableScope] : ( ^(
    // VARIABLE_SCOPE SUBCLASS_OF classExpression= . ) | ^( VARIABLE_SCOPE
    // SUPER_CLASS_OF classExpression= . ) | ^( VARIABLE_SCOPE SUPER_PROPERTY_OF
    // propertyExpression= . ) | ^( VARIABLE_SCOPE SUBPROPERTY_OF
    // propertyExpression= . ) | ^( VARIABLE_SCOPE ( INSTANCE_OF | TYPES )
    // individualExpression= . ) );
    public final OPPLTypes.variableScope_return variableScope()
            throws RecognitionException {
        OPPLTypes.variableScope_return retval = new OPPLTypes.variableScope_return();
        retval.start = input.LT(1);
        OPPLSyntaxTree classExpression = null;
        OPPLSyntaxTree propertyExpression = null;
        OPPLSyntaxTree individualExpression = null;
        try {
            // /Users/luigi/Documents/workspace/Parsers/src/OPPLTypes.g:400:2: (
            // ^( VARIABLE_SCOPE SUBCLASS_OF classExpression= . ) | ^(
            // VARIABLE_SCOPE SUPER_CLASS_OF classExpression= . ) | ^(
            // VARIABLE_SCOPE SUPER_PROPERTY_OF propertyExpression= . ) | ^(
            // VARIABLE_SCOPE SUBPROPERTY_OF propertyExpression= . ) | ^(
            // VARIABLE_SCOPE ( INSTANCE_OF | TYPES ) individualExpression= . )
            // )
            int alt15 = 5;
            int LA15_0 = input.LA(1);
            if (LA15_0 == VARIABLE_SCOPE) {
                int LA15_1 = input.LA(2);
                if (LA15_1 == DOWN) {
                    switch (input.LA(3)) {
                        case SUBCLASS_OF: {
                            alt15 = 1;
                        }
                            break;
                        case SUPER_CLASS_OF: {
                            alt15 = 2;
                        }
                            break;
                        case SUPER_PROPERTY_OF: {
                            alt15 = 3;
                        }
                            break;
                        case SUBPROPERTY_OF: {
                            alt15 = 4;
                        }
                            break;
                        case INSTANCE_OF:
                        case TYPES: {
                            alt15 = 5;
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
                // /Users/luigi/Documents/workspace/Parsers/src/OPPLTypes.g:401:2:
                // ^( VARIABLE_SCOPE SUBCLASS_OF classExpression= . )
                {
                    match(input, VARIABLE_SCOPE,
                            FOLLOW_VARIABLE_SCOPE_in_variableScope807);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.DOWN, null);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, SUBCLASS_OF, FOLLOW_SUBCLASS_OF_in_variableScope809);
                    if (state.failed) {
                        return retval;
                    }
                    classExpression = (OPPLSyntaxTree) input.LT(1);
                    matchAny(input);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.UP, null);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 1) {
                        try {
                            VariableScopeChecker checker = getConstraintSystem()
                                    .getOPPLFactory().getVariableScopeChecker();
                            retval.type = symtab.getClassVariableScopeType(
                                    (OPPLSyntaxTree) retval.start, classExpression);
                            retval.variableScope = VariableScopes
                                    .buildSubClassVariableScope(
                                            (OWLClassExpression) classExpression
                                                    .getOWLObject(), checker);
                        } catch (OPPLException e) {
                            getErrorListener().reportThrowable(
                                    e,
                                    ((OPPLSyntaxTree) retval.start).getLine(),
                                    ((OPPLSyntaxTree) retval.start)
                                            .getCharPositionInLine(),
                                    ((OPPLSyntaxTree) retval.start).getText().length());
                        }
                    }
                }
                    break;
                case 2:
                // /Users/luigi/Documents/workspace/Parsers/src/OPPLTypes.g:411:5:
                // ^( VARIABLE_SCOPE SUPER_CLASS_OF classExpression= . )
                {
                    match(input, VARIABLE_SCOPE,
                            FOLLOW_VARIABLE_SCOPE_in_variableScope826);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.DOWN, null);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, SUPER_CLASS_OF,
                            FOLLOW_SUPER_CLASS_OF_in_variableScope828);
                    if (state.failed) {
                        return retval;
                    }
                    classExpression = (OPPLSyntaxTree) input.LT(1);
                    matchAny(input);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.UP, null);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 1) {
                        try {
                            VariableScopeChecker checker = getConstraintSystem()
                                    .getOPPLFactory().getVariableScopeChecker();
                            retval.type = symtab.getClassVariableScopeType(
                                    (OPPLSyntaxTree) retval.start, classExpression);
                            retval.variableScope = VariableScopes
                                    .buildSuperClassVariableScope(
                                            (OWLClassExpression) classExpression
                                                    .getOWLObject(), checker);
                        } catch (OPPLException e) {
                            getErrorListener().reportThrowable(
                                    e,
                                    ((OPPLSyntaxTree) retval.start).getLine(),
                                    ((OPPLSyntaxTree) retval.start)
                                            .getCharPositionInLine(),
                                    ((OPPLSyntaxTree) retval.start).getText().length());
                        }
                    }
                }
                    break;
                case 3:
                // /Users/luigi/Documents/workspace/Parsers/src/OPPLTypes.g:421:4:
                // ^( VARIABLE_SCOPE SUPER_PROPERTY_OF propertyExpression= . )
                {
                    match(input, VARIABLE_SCOPE,
                            FOLLOW_VARIABLE_SCOPE_in_variableScope847);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.DOWN, null);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, SUPER_PROPERTY_OF,
                            FOLLOW_SUPER_PROPERTY_OF_in_variableScope849);
                    if (state.failed) {
                        return retval;
                    }
                    propertyExpression = (OPPLSyntaxTree) input.LT(1);
                    matchAny(input);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.UP, null);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 1) {
                        try {
                            VariableScopeChecker checker = getConstraintSystem()
                                    .getOPPLFactory().getVariableScopeChecker();
                            retval.type = symtab.getPropertyVariableScopeType(
                                    (OPPLSyntaxTree) retval.start, propertyExpression);
                            retval.variableScope = VariableScopes
                                    .buildSuperPropertyVariableScope(
                                            (OWLPropertyExpression<?, ?>) propertyExpression
                                                    .getOWLObject(), checker);
                        } catch (OPPLException e) {
                            getErrorListener().reportThrowable(
                                    e,
                                    ((OPPLSyntaxTree) retval.start).getLine(),
                                    ((OPPLSyntaxTree) retval.start)
                                            .getCharPositionInLine(),
                                    ((OPPLSyntaxTree) retval.start).getText().length());
                        }
                    }
                }
                    break;
                case 4:
                // /Users/luigi/Documents/workspace/Parsers/src/OPPLTypes.g:431:4:
                // ^( VARIABLE_SCOPE SUBPROPERTY_OF propertyExpression= . )
                {
                    match(input, VARIABLE_SCOPE,
                            FOLLOW_VARIABLE_SCOPE_in_variableScope864);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.DOWN, null);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, SUBPROPERTY_OF,
                            FOLLOW_SUBPROPERTY_OF_in_variableScope866);
                    if (state.failed) {
                        return retval;
                    }
                    propertyExpression = (OPPLSyntaxTree) input.LT(1);
                    matchAny(input);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.UP, null);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 1) {
                        try {
                            VariableScopeChecker checker = getConstraintSystem()
                                    .getOPPLFactory().getVariableScopeChecker();
                            retval.type = symtab.getPropertyVariableScopeType(
                                    (OPPLSyntaxTree) retval.start, propertyExpression);
                            retval.variableScope = VariableScopes
                                    .buildSubPropertyVariableScope(
                                            (OWLPropertyExpression<?, ?>) propertyExpression
                                                    .getOWLObject(), checker);
                        } catch (OPPLException e) {
                            getErrorListener().reportThrowable(
                                    e,
                                    ((OPPLSyntaxTree) retval.start).getLine(),
                                    ((OPPLSyntaxTree) retval.start)
                                            .getCharPositionInLine(),
                                    ((OPPLSyntaxTree) retval.start).getText().length());
                        }
                    }
                }
                    break;
                case 5:
                // /Users/luigi/Documents/workspace/Parsers/src/OPPLTypes.g:441:4:
                // ^( VARIABLE_SCOPE ( INSTANCE_OF | TYPES )
                // individualExpression= . )
                {
                    match(input, VARIABLE_SCOPE,
                            FOLLOW_VARIABLE_SCOPE_in_variableScope885);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.DOWN, null);
                    if (state.failed) {
                        return retval;
                    }
                    if (input.LA(1) >= INSTANCE_OF && input.LA(1) <= TYPES) {
                        input.consume();
                        state.errorRecovery = false;
                        state.failed = false;
                    } else {
                        if (state.backtracking > 0) {
                            state.failed = true;
                            return retval;
                        }
                        MismatchedSetException mse = new MismatchedSetException(null,
                                input);
                        throw mse;
                    }
                    individualExpression = (OPPLSyntaxTree) input.LT(1);
                    matchAny(input);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.UP, null);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 1) {
                        try {
                            VariableScopeChecker checker = getConstraintSystem()
                                    .getOPPLFactory().getVariableScopeChecker();
                            retval.type = symtab.getIndividualVariableScopeType(
                                    (OPPLSyntaxTree) retval.start, individualExpression);
                            retval.variableScope = VariableScopes
                                    .buildIndividualVariableScope(
                                            (OWLClassExpression) individualExpression
                                                    .getOWLObject(), checker);
                        } catch (OPPLException e) {
                            getErrorListener().reportThrowable(
                                    e,
                                    ((OPPLSyntaxTree) retval.start).getLine(),
                                    ((OPPLSyntaxTree) retval.start)
                                            .getCharPositionInLine(),
                                    ((OPPLSyntaxTree) retval.start).getText().length());
                        }
                    }
                }
                    break;
            }
            if (state.backtracking == 1) {
                ((OPPLSyntaxTree) retval.start).setEvalType(retval.type);
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

    // $ANTLR end "variableScope"
    public static class constraint_return extends TreeRuleReturnScope {
        public AbstractConstraint constraint;
    }

    // $ANTLR start "constraint"
    // /Users/luigi/Documents/workspace/Parsers/src/OPPLTypes.g:455:1:
    // constraint returns [AbstractConstraint constraint] : ( ^(
    // INEQUALITY_CONSTRAINT IDENTIFIER ^( EXPRESSION expression= . ) ) | ^(
    // IN_SET_CONSTRAINT v= IDENTIFIER (i= IDENTIFIER )+ ) | ^(
    // REGEXP_CONSTRAINT IDENTIFIER se= stringOperation ) | ^( NAF_CONSTRAINT a=
    // . ) );
    public final OPPLTypes.constraint_return constraint() throws RecognitionException {
        OPPLTypes.constraint_return retval = new OPPLTypes.constraint_return();
        retval.start = input.LT(1);
        OPPLSyntaxTree v = null;
        OPPLSyntaxTree i = null;
        OPPLSyntaxTree IDENTIFIER20 = null;
        OPPLSyntaxTree IDENTIFIER21 = null;
        OPPLSyntaxTree expression = null;
        OPPLSyntaxTree a = null;
        OPPLFunction<String> se = null;
        List<OPPLSyntaxTree> identifiers = new ArrayList<OPPLSyntaxTree>();
        try {
            // /Users/luigi/Documents/workspace/Parsers/src/OPPLTypes.g:460:1: (
            // ^( INEQUALITY_CONSTRAINT IDENTIFIER ^( EXPRESSION expression= . )
            // ) | ^( IN_SET_CONSTRAINT v= IDENTIFIER (i= IDENTIFIER )+ ) | ^(
            // REGEXP_CONSTRAINT IDENTIFIER se= stringOperation ) | ^(
            // NAF_CONSTRAINT a= . ) )
            int alt17 = 4;
            switch (input.LA(1)) {
                case INEQUALITY_CONSTRAINT: {
                    alt17 = 1;
                }
                    break;
                case IN_SET_CONSTRAINT: {
                    alt17 = 2;
                }
                    break;
                case REGEXP_CONSTRAINT: {
                    alt17 = 3;
                }
                    break;
                case NAF_CONSTRAINT: {
                    alt17 = 4;
                }
                    break;
                default:
                    if (state.backtracking > 0) {
                        state.failed = true;
                        return retval;
                    }
                    NoViableAltException nvae = new NoViableAltException("", 17, 0, input);
                    throw nvae;
            }
            switch (alt17) {
                case 1:
                // /Users/luigi/Documents/workspace/Parsers/src/OPPLTypes.g:461:3:
                // ^( INEQUALITY_CONSTRAINT IDENTIFIER ^( EXPRESSION expression=
                // . ) )
                {
                    match(input, INEQUALITY_CONSTRAINT,
                            FOLLOW_INEQUALITY_CONSTRAINT_in_constraint930);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.DOWN, null);
                    if (state.failed) {
                        return retval;
                    }
                    IDENTIFIER20 = (OPPLSyntaxTree) match(input, IDENTIFIER,
                            FOLLOW_IDENTIFIER_in_constraint932);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, EXPRESSION, FOLLOW_EXPRESSION_in_constraint935);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.DOWN, null);
                    if (state.failed) {
                        return retval;
                    }
                    expression = (OPPLSyntaxTree) input.LT(1);
                    matchAny(input);
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
                        retval.constraint = symtab.getInequalityConstraint(
                                (OPPLSyntaxTree) retval.start, IDENTIFIER20, expression,
                                getConstraintSystem());
                    }
                }
                    break;
                case 2:
                // /Users/luigi/Documents/workspace/Parsers/src/OPPLTypes.g:464:5:
                // ^( IN_SET_CONSTRAINT v= IDENTIFIER (i= IDENTIFIER )+ )
                {
                    match(input, IN_SET_CONSTRAINT,
                            FOLLOW_IN_SET_CONSTRAINT_in_constraint949);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.DOWN, null);
                    if (state.failed) {
                        return retval;
                    }
                    v = (OPPLSyntaxTree) match(input, IDENTIFIER,
                            FOLLOW_IDENTIFIER_in_constraint955);
                    if (state.failed) {
                        return retval;
                    }
                    // /Users/luigi/Documents/workspace/Parsers/src/OPPLTypes.g:464:41:
                    // (i= IDENTIFIER )+
                    int cnt16 = 0;
                    loop16: do {
                        int alt16 = 2;
                        int LA16_0 = input.LA(1);
                        if (LA16_0 == IDENTIFIER) {
                            alt16 = 1;
                        }
                        switch (alt16) {
                            case 1:
                            // /Users/luigi/Documents/workspace/Parsers/src/OPPLTypes.g:464:42:
                            // i= IDENTIFIER
                            {
                                i = (OPPLSyntaxTree) match(input, IDENTIFIER,
                                        FOLLOW_IDENTIFIER_in_constraint963);
                                if (state.failed) {
                                    return retval;
                                }
                                if (state.backtracking == 1) {
                                    identifiers.add(i);
                                }
                            }
                                break;
                            default:
                                if (cnt16 >= 1) {
                                    break loop16;
                                }
                                if (state.backtracking > 0) {
                                    state.failed = true;
                                    return retval;
                                }
                                EarlyExitException eee = new EarlyExitException(16, input);
                                throw eee;
                        }
                        cnt16++;
                    } while (true);
                    match(input, Token.UP, null);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 1) {
                        retval.constraint = symtab
                                .getInSetConstraint((OPPLSyntaxTree) retval.start, v,
                                        constraintSystem, identifiers
                                                .toArray(new OPPLSyntaxTree[identifiers
                                                        .size()]));
                    }
                }
                    break;
                case 3:
                // /Users/luigi/Documents/workspace/Parsers/src/OPPLTypes.g:467:5:
                // ^( REGEXP_CONSTRAINT IDENTIFIER se= stringOperation )
                {
                    match(input, REGEXP_CONSTRAINT,
                            FOLLOW_REGEXP_CONSTRAINT_in_constraint976);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.DOWN, null);
                    if (state.failed) {
                        return retval;
                    }
                    IDENTIFIER21 = (OPPLSyntaxTree) match(input, IDENTIFIER,
                            FOLLOW_IDENTIFIER_in_constraint978);
                    if (state.failed) {
                        return retval;
                    }
                    pushFollow(FOLLOW_stringOperation_in_constraint984);
                    se = stringOperation();
                    state._fsp--;
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.UP, null);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 1) {
                        Variable variable = symtab.getVariable(IDENTIFIER21,
                                getConstraintSystem());
                        OPPLFunction<Pattern> adapted = Adapter
                                .buildRegexpPatternAdapter(se);
                        retval.constraint = new RegExpConstraint(variable, adapted,
                                getConstraintSystem());
                    }
                }
                    break;
                case 4:
                // /Users/luigi/Documents/workspace/Parsers/src/OPPLTypes.g:473:5:
                // ^( NAF_CONSTRAINT a= . )
                {
                    match(input, NAF_CONSTRAINT, FOLLOW_NAF_CONSTRAINT_in_constraint996);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.DOWN, null);
                    if (state.failed) {
                        return retval;
                    }
                    a = (OPPLSyntaxTree) input.LT(1);
                    matchAny(input);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.UP, null);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 1) {
                        OWLObject axiom = a.getOWLObject();
                        if (axiom instanceof OWLAxiom) {
                            retval.constraint = new NAFConstraint((OWLAxiom) axiom,
                                    getConstraintSystem());
                        }
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
        return retval;
    }

    // $ANTLR end "constraint"
    public static class aggregandums_return extends TreeRuleReturnScope {
        public List<Aggregandum<?>> list;
        public List<OPPLSyntaxTree> tokenList;
    }

    // $ANTLR start "aggregandums"
    // /Users/luigi/Documents/workspace/Parsers/src/OPPLTypes.g:484:1:
    // aggregandums returns [List<Aggregandum<?>> list, List<OPPLSyntaxTree>
    // tokenList] : (a= aggregandum )+ ;
    public final OPPLTypes.aggregandums_return aggregandums() throws RecognitionException {
        OPPLTypes.aggregandums_return retval = new OPPLTypes.aggregandums_return();
        retval.start = input.LT(1);
        OPPLTypes.aggregandum_return a = null;
        retval.list = new ArrayList<Aggregandum<?>>();
        retval.tokenList = new ArrayList<OPPLSyntaxTree>();
        try {
            // /Users/luigi/Documents/workspace/Parsers/src/OPPLTypes.g:490:2: (
            // (a= aggregandum )+ )
            // /Users/luigi/Documents/workspace/Parsers/src/OPPLTypes.g:491:3:
            // (a= aggregandum )+
            {
                // /Users/luigi/Documents/workspace/Parsers/src/OPPLTypes.g:491:3:
                // (a= aggregandum )+
                int cnt18 = 0;
                loop18: do {
                    int alt18 = 2;
                    int LA18_0 = input.LA(1);
                    if (LA18_0 == IDENTIFIER) {
                        alt18 = 1;
                    }
                    switch (alt18) {
                        case 1:
                        // /Users/luigi/Documents/workspace/Parsers/src/OPPLTypes.g:491:4:
                        // a= aggregandum
                        {
                            pushFollow(FOLLOW_aggregandum_in_aggregandums1032);
                            a = aggregandum();
                            state._fsp--;
                            if (state.failed) {
                                return retval;
                            }
                            if (state.backtracking == 1) {
                                retval.tokenList.add(a.node);
                                retval.list.add(a.a);
                            }
                        }
                            break;
                        default:
                            if (cnt18 >= 1) {
                                break loop18;
                            }
                            if (state.backtracking > 0) {
                                state.failed = true;
                                return retval;
                            }
                            EarlyExitException eee = new EarlyExitException(18, input);
                            throw eee;
                    }
                    cnt18++;
                } while (true);
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

    // $ANTLR end "aggregandums"
    public static class opplAxioms_return extends TreeRuleReturnScope {}

    // $ANTLR start "opplAxioms"
    // /Users/luigi/Documents/workspace/Parsers/src/OPPLTypes.g:499:1:
    // opplAxioms : ( ^( DISJOINT_CLASSES ^( EXPRESSION ^( SET va= aggregandums
    // ) ) ) | ^( DISJOINT_PROPERTIES ^( EXPRESSION ^( SET va= aggregandums ) )
    // ) | ^( DIFFERENT_INDIVIDUALS ^( EXPRESSION ^( SET va= aggregandums ) ) )
    // | ^( SAME_INDIVIDUAL ^( EXPRESSION ^( SET va= aggregandums ) ) ) );
    public final OPPLTypes.opplAxioms_return opplAxioms() throws RecognitionException {
        OPPLTypes.opplAxioms_return retval = new OPPLTypes.opplAxioms_return();
        retval.start = input.LT(1);
        OPPLTypes.aggregandums_return va = null;
        OWLAxiom axiom = null;
        try {
            // /Users/luigi/Documents/workspace/Parsers/src/OPPLTypes.g:507:2: (
            // ^( DISJOINT_CLASSES ^( EXPRESSION ^( SET va= aggregandums ) ) ) |
            // ^( DISJOINT_PROPERTIES ^( EXPRESSION ^( SET va= aggregandums ) )
            // ) | ^( DIFFERENT_INDIVIDUALS ^( EXPRESSION ^( SET va=
            // aggregandums ) ) ) | ^( SAME_INDIVIDUAL ^( EXPRESSION ^( SET va=
            // aggregandums ) ) ) )
            int alt19 = 4;
            switch (input.LA(1)) {
                case DISJOINT_CLASSES: {
                    alt19 = 1;
                }
                    break;
                case DISJOINT_PROPERTIES: {
                    alt19 = 2;
                }
                    break;
                case DIFFERENT_INDIVIDUALS: {
                    alt19 = 3;
                }
                    break;
                case SAME_INDIVIDUAL: {
                    alt19 = 4;
                }
                    break;
                default:
                    if (state.backtracking > 0) {
                        state.failed = true;
                        return retval;
                    }
                    NoViableAltException nvae = new NoViableAltException("", 19, 0, input);
                    throw nvae;
            }
            switch (alt19) {
                case 1:
                // /Users/luigi/Documents/workspace/Parsers/src/OPPLTypes.g:508:3:
                // ^( DISJOINT_CLASSES ^( EXPRESSION ^( SET va= aggregandums ) )
                // )
                {
                    match(input, DISJOINT_CLASSES,
                            FOLLOW_DISJOINT_CLASSES_in_opplAxioms1062);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.DOWN, null);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, EXPRESSION, FOLLOW_EXPRESSION_in_opplAxioms1065);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.DOWN, null);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, SET, FOLLOW_SET_in_opplAxioms1068);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.DOWN, null);
                    if (state.failed) {
                        return retval;
                    }
                    pushFollow(FOLLOW_aggregandums_in_opplAxioms1074);
                    va = aggregandums();
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
                    match(input, Token.UP, null);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 1) {
                        axiom = getSymbolTable().getDisjointAxiom(
                                (OPPLSyntaxTree) retval.start, va.list, va.tokenList,
                                getConstraintSystem());
                    }
                }
                    break;
                case 2:
                // /Users/luigi/Documents/workspace/Parsers/src/OPPLTypes.g:511:4:
                // ^( DISJOINT_PROPERTIES ^( EXPRESSION ^( SET va= aggregandums
                // ) ) )
                {
                    match(input, DISJOINT_PROPERTIES,
                            FOLLOW_DISJOINT_PROPERTIES_in_opplAxioms1084);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.DOWN, null);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, EXPRESSION, FOLLOW_EXPRESSION_in_opplAxioms1087);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.DOWN, null);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, SET, FOLLOW_SET_in_opplAxioms1090);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.DOWN, null);
                    if (state.failed) {
                        return retval;
                    }
                    pushFollow(FOLLOW_aggregandums_in_opplAxioms1096);
                    va = aggregandums();
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
                    match(input, Token.UP, null);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 1) {
                        axiom = getSymbolTable().getDisjointAxiom(
                                (OPPLSyntaxTree) retval.start, va.list, va.tokenList,
                                getConstraintSystem());
                    }
                }
                    break;
                case 3:
                // /Users/luigi/Documents/workspace/Parsers/src/OPPLTypes.g:514:5:
                // ^( DIFFERENT_INDIVIDUALS ^( EXPRESSION ^( SET va=
                // aggregandums ) ) )
                {
                    match(input, DIFFERENT_INDIVIDUALS,
                            FOLLOW_DIFFERENT_INDIVIDUALS_in_opplAxioms1107);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.DOWN, null);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, EXPRESSION, FOLLOW_EXPRESSION_in_opplAxioms1110);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.DOWN, null);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, SET, FOLLOW_SET_in_opplAxioms1113);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.DOWN, null);
                    if (state.failed) {
                        return retval;
                    }
                    pushFollow(FOLLOW_aggregandums_in_opplAxioms1119);
                    va = aggregandums();
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
                    match(input, Token.UP, null);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 1) {
                        axiom = getSymbolTable().getDifferentIndividualsAxiom(
                                (OPPLSyntaxTree) retval.start, va.list, va.tokenList,
                                getConstraintSystem());
                    }
                }
                    break;
                case 4:
                // /Users/luigi/Documents/workspace/Parsers/src/OPPLTypes.g:517:5:
                // ^( SAME_INDIVIDUAL ^( EXPRESSION ^( SET va= aggregandums ) )
                // )
                {
                    match(input, SAME_INDIVIDUAL,
                            FOLLOW_SAME_INDIVIDUAL_in_opplAxioms1130);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.DOWN, null);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, EXPRESSION, FOLLOW_EXPRESSION_in_opplAxioms1133);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.DOWN, null);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, SET, FOLLOW_SET_in_opplAxioms1136);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.DOWN, null);
                    if (state.failed) {
                        return retval;
                    }
                    pushFollow(FOLLOW_aggregandums_in_opplAxioms1142);
                    va = aggregandums();
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
                    match(input, Token.UP, null);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 1) {
                        axiom = getSymbolTable().getSameIndividualAxiom(
                                (OPPLSyntaxTree) retval.start, va.list, va.tokenList,
                                getConstraintSystem());
                    }
                }
                    break;
            }
            if (state.backtracking == 1) {
                ((OPPLSyntaxTree) retval.start).setOWLObject(axiom);
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

    // $ANTLR end "opplAxioms"
    public static class aggregandum_return extends TreeRuleReturnScope {
        public Aggregandum<?> a;
        public OPPLSyntaxTree node;
    }

    // $ANTLR start "aggregandum"
    // /Users/luigi/Documents/workspace/Parsers/src/OPPLTypes.g:523:1:
    // aggregandum returns [Aggregandum<?> a, OPPLSyntaxTree node] : ( ^(
    // IDENTIFIER VARIABLE_NAME DOT VALUES ) | IDENTIFIER );
    public final OPPLTypes.aggregandum_return aggregandum() throws RecognitionException {
        OPPLTypes.aggregandum_return retval = new OPPLTypes.aggregandum_return();
        retval.start = input.LT(1);
        OPPLSyntaxTree VARIABLE_NAME22 = null;
        OPPLSyntaxTree IDENTIFIER23 = null;
        try {
            // /Users/luigi/Documents/workspace/Parsers/src/OPPLTypes.g:528:2: (
            // ^( IDENTIFIER VARIABLE_NAME DOT VALUES ) | IDENTIFIER )
            int alt20 = 2;
            int LA20_0 = input.LA(1);
            if (LA20_0 == IDENTIFIER) {
                int LA20_1 = input.LA(2);
                if (LA20_1 == DOWN) {
                    alt20 = 1;
                } else if (LA20_1 == UP || LA20_1 == IDENTIFIER) {
                    alt20 = 2;
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
                // /Users/luigi/Documents/workspace/Parsers/src/OPPLTypes.g:529:2:
                // ^( IDENTIFIER VARIABLE_NAME DOT VALUES )
                {
                    match(input, IDENTIFIER, FOLLOW_IDENTIFIER_in_aggregandum1172);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.DOWN, null);
                    if (state.failed) {
                        return retval;
                    }
                    VARIABLE_NAME22 = (OPPLSyntaxTree) match(input, VARIABLE_NAME,
                            FOLLOW_VARIABLE_NAME_in_aggregandum1175);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, DOT, FOLLOW_DOT_in_aggregandum1177);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, VALUES, FOLLOW_VALUES_in_aggregandum1180);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.UP, null);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 1) {
                        retval.a = Adapter.buildSingletonAggregandum(getSymbolTable()
                                .defineValuesAttributeReferenceSymbol(VARIABLE_NAME22,
                                        getConstraintSystem()));
                    }
                }
                    break;
                case 2:
                // /Users/luigi/Documents/workspace/Parsers/src/OPPLTypes.g:533:8:
                // IDENTIFIER
                {
                    IDENTIFIER23 = (OPPLSyntaxTree) match(input, IDENTIFIER,
                            FOLLOW_IDENTIFIER_in_aggregandum1197);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 1) {
                        Symbol symbol = getSymbolTable().resolve(IDENTIFIER23);
                        if (symbol != null) {
                            retval.a = Adapter.buildAggregandumOfCollection(IDENTIFIER23
                                    .getOWLObject());
                        } else {
                            getErrorListener().unrecognisedSymbol(IDENTIFIER23);
                        }
                    }
                }
                    break;
            }
            if (state.backtracking == 1) {
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
        } finally {}
        return retval;
    }

    // $ANTLR end "aggregandum"
    // Delegated rules
    protected DFA12 dfa12 = new DFA12(this);
    protected DFA14 dfa14 = new DFA14(this);
    static final String DFA12_eotS = "\13\uffff";
    static final String DFA12_eofS = "\13\uffff";
    static final String DFA12_minS = "\1\140\1\uffff\1\2\1\u01d0\1\131\1\105\5\uffff";
    static final String DFA12_maxS = "\1\141\1\uffff\1\2\1\u01d0\1\131\1\u00b0\5\uffff";
    static final String DFA12_acceptS = "\1\uffff\1\1\4\uffff\1\2\1\3\1\4\1\5\1\6";
    static final String DFA12_specialS = "\13\uffff}>";
    static final String[] DFA12_transitionS = { "\1\1\1\2", "", "\1\3", "\1\4", "\1\5",
            "\1\6\13\uffff\1\11\1\12\17\uffff\1\10\115\uffff\1\7", "", "", "", "", "" };
    static final short[] DFA12_eot = DFA.unpackEncodedString(DFA12_eotS);
    static final short[] DFA12_eof = DFA.unpackEncodedString(DFA12_eofS);
    static final char[] DFA12_min = DFA.unpackEncodedStringToUnsignedChars(DFA12_minS);
    static final char[] DFA12_max = DFA.unpackEncodedStringToUnsignedChars(DFA12_maxS);
    static final short[] DFA12_accept = DFA.unpackEncodedString(DFA12_acceptS);
    static final short[] DFA12_special = DFA.unpackEncodedString(DFA12_specialS);
    static final short[][] DFA12_transition;
    static {
        int numStates = DFA12_transitionS.length;
        DFA12_transition = new short[numStates][];
        for (int i = 0; i < numStates; i++) {
            DFA12_transition[i] = DFA.unpackEncodedString(DFA12_transitionS[i]);
        }
    }

    class DFA12 extends DFA {
        public DFA12(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            decisionNumber = 12;
            eot = DFA12_eot;
            eof = DFA12_eof;
            min = DFA12_min;
            max = DFA12_max;
            accept = DFA12_accept;
            special = DFA12_special;
            transition = DFA12_transition;
        }

        @Override
        public String getDescription() {
            return "270:1: variableDefinition returns [Variable variable] : ( ^( INPUT_VARIABLE_DEFINITION VARIABLE_NAME VARIABLE_TYPE (vs= variableScope )? ) | ^( GENERATED_VARIABLE_DEFINITION VARIABLE_NAME VARIABLE_TYPE ^(expr= EXPRESSION ( . )* ) ) | ^( GENERATED_VARIABLE_DEFINITION VARIABLE_NAME VARIABLE_TYPE ^( MATCH se= stringOperation ) ) | ^( GENERATED_VARIABLE_DEFINITION VARIABLE_NAME VARIABLE_TYPE ^( CREATE_OPPL_FUNCTION value= stringOperation ) ) | ^( GENERATED_VARIABLE_DEFINITION name= VARIABLE_NAME VARIABLE_TYPE ^( CREATE_INTERSECTION va= aggregandums ) ) | ^( GENERATED_VARIABLE_DEFINITION name= VARIABLE_NAME VARIABLE_TYPE ^( CREATE_DISJUNCTION va= aggregandums ) ) );";
        }
    }

    static final String DFA14_eotS = "\20\uffff";
    static final String DFA14_eofS = "\20\uffff";
    static final String DFA14_minS = "\1\50\1\uffff\3\2\1\u01d0\2\50\1\116\4\uffff\1\u0163\2\uffff";
    static final String DFA14_maxS = "\1\171\1\uffff\3\2\1\u01d0\2\u018a\1\116\4\uffff\1\u0164\2\uffff";
    static final String DFA14_acceptS = "\1\uffff\1\1\7\uffff\1\4\1\6\1\5\1\7\1\uffff\1\2\1\3";
    static final String DFA14_specialS = "\20\uffff}>";
    static final String[] DFA14_transitionS = { "\1\1\3\uffff\1\2\113\uffff\1\3\1\4", "",
            "\1\5", "\1\6", "\1\7", "\1\10",
            "\1\12\3\uffff\1\12\113\uffff\2\12\u0110\uffff\1\11",
            "\1\14\3\uffff\1\14\113\uffff\2\14\u0110\uffff\1\13", "\1\15", "", "", "",
            "", "\1\17\1\16", "", "" };
    static final short[] DFA14_eot = DFA.unpackEncodedString(DFA14_eotS);
    static final short[] DFA14_eof = DFA.unpackEncodedString(DFA14_eofS);
    static final char[] DFA14_min = DFA.unpackEncodedStringToUnsignedChars(DFA14_minS);
    static final char[] DFA14_max = DFA.unpackEncodedStringToUnsignedChars(DFA14_maxS);
    static final short[] DFA14_accept = DFA.unpackEncodedString(DFA14_acceptS);
    static final short[] DFA14_special = DFA.unpackEncodedString(DFA14_specialS);
    static final short[][] DFA14_transition;
    static {
        int numStates = DFA14_transitionS.length;
        DFA14_transition = new short[numStates][];
        for (int i = 0; i < numStates; i++) {
            DFA14_transition[i] = DFA.unpackEncodedString(DFA14_transitionS[i]);
        }
    }

    class DFA14 extends DFA {
        public DFA14(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            decisionNumber = 14;
            eot = DFA14_eot;
            eof = DFA14_eof;
            min = DFA14_min;
            max = DFA14_max;
            accept = DFA14_accept;
            special = DFA14_special;
            transition = DFA14_transition;
        }

        @Override
        public String getDescription() {
            return "360:1: stringExpression returns [OPPLFunction<String> value] : ( DBLQUOTE | ^( IDENTIFIER VARIABLE_NAME DOT GROUPS ^( ATTRIBUTE_SELECTOR INTEGER ) ) | ^( IDENTIFIER VARIABLE_NAME DOT RENDERING ) | ^( TO_LOWER_CASE expression= stringOperation ) | ^( TO_UPPER_CASE expression= stringOperation ) | ^( TO_LOWER_CASE simpleExpression= stringExpression ) | ^( TO_UPPER_CASE simpleExpression= stringExpression ) );";
        }
    }

    public static final BitSet FOLLOW_opplAxioms_in_bottomup81 = new BitSet(
            new long[] { 0x0000000000000002L });
    public static final BitSet FOLLOW_statement_in_bottomup90 = new BitSet(
            new long[] { 0x0000000000000002L });
    public static final BitSet FOLLOW_OPPL_STATEMENT_in_statement112 = new BitSet(
            new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_variableDefinitions_in_statement118 = new BitSet(
            new long[] { 0x0000000000000000L, 0x000000A000000000L });
    public static final BitSet FOLLOW_query_in_statement123 = new BitSet(new long[] {
            0x0000000000000000L, 0x000000A000000000L });
    public static final BitSet FOLLOW_actions_in_statement126 = new BitSet(
            new long[] { 0x0000000000000008L });
    public static final BitSet FOLLOW_VARIABLE_DEFINITIONS_in_variableDefinitions157 = new BitSet(
            new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_variableDefinition_in_variableDefinitions164 = new BitSet(
            new long[] { 0x0000000000000008L, 0x0000000300000000L });
    public static final BitSet FOLLOW_QUERY_in_query198 = new BitSet(
            new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_selectClause_in_query201 = new BitSet(new long[] {
            0x0000000000000008L, 0x00000000F0000000L, 0x0000000000000000L,
            0x0000000000000000L, 0x0000000000000000L, 0x0000000000000000L,
            0x0000000000000000L, 0x00000000000A0000L });
    public static final BitSet FOLLOW_constraint_in_query214 = new BitSet(new long[] {
            0x0000000000000008L, 0x00000000C0000000L, 0x0000000000000000L,
            0x0000000000000000L, 0x0000000000000000L, 0x0000000000000000L,
            0x0000000000000000L, 0x00000000000A0000L });
    public static final BitSet FOLLOW_ASSERTED_CLAUSE_in_selectClause243 = new BitSet(
            new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_PLAIN_CLAUSE_in_selectClause261 = new BitSet(
            new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_ACTIONS_in_actions298 = new BitSet(
            new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_action_in_actions301 = new BitSet(new long[] {
            0x0000000000000008L, 0x000000000C000000L });
    public static final BitSet FOLLOW_ADD_in_action332 = new BitSet(
            new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_REMOVE_in_action347 = new BitSet(
            new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_INPUT_VARIABLE_DEFINITION_in_variableDefinition375 = new BitSet(
            new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_VARIABLE_NAME_in_variableDefinition377 = new BitSet(
            new long[] { 0x0000000000000000L, 0x0000000002000000L });
    public static final BitSet FOLLOW_VARIABLE_TYPE_in_variableDefinition379 = new BitSet(
            new long[] { 0x0000000000000008L, 0x0000010000000000L });
    public static final BitSet FOLLOW_variableScope_in_variableDefinition385 = new BitSet(
            new long[] { 0x0000000000000008L });
    public static final BitSet FOLLOW_GENERATED_VARIABLE_DEFINITION_in_variableDefinition400 = new BitSet(
            new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_VARIABLE_NAME_in_variableDefinition402 = new BitSet(
            new long[] { 0x0000000000000000L, 0x0000000002000000L });
    public static final BitSet FOLLOW_VARIABLE_TYPE_in_variableDefinition404 = new BitSet(
            new long[] { 0x0000000000000000L, 0x0000000000000020L });
    public static final BitSet FOLLOW_EXPRESSION_in_variableDefinition412 = new BitSet(
            new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_GENERATED_VARIABLE_DEFINITION_in_variableDefinition432 = new BitSet(
            new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_VARIABLE_NAME_in_variableDefinition434 = new BitSet(
            new long[] { 0x0000000000000000L, 0x0000000002000000L });
    public static final BitSet FOLLOW_VARIABLE_TYPE_in_variableDefinition436 = new BitSet(
            new long[] { 0x0000000000000000L, 0x0000000000000000L, 0x0001000000000000L });
    public static final BitSet FOLLOW_MATCH_in_variableDefinition439 = new BitSet(
            new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_stringOperation_in_variableDefinition445 = new BitSet(
            new long[] { 0x0000000000000008L });
    public static final BitSet FOLLOW_GENERATED_VARIABLE_DEFINITION_in_variableDefinition459 = new BitSet(
            new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_VARIABLE_NAME_in_variableDefinition461 = new BitSet(
            new long[] { 0x0000000000000000L, 0x0000000002000000L });
    public static final BitSet FOLLOW_VARIABLE_TYPE_in_variableDefinition463 = new BitSet(
            new long[] { 0x0000000000000000L, 0x0000000400000000L });
    public static final BitSet FOLLOW_CREATE_OPPL_FUNCTION_in_variableDefinition466 = new BitSet(
            new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_stringOperation_in_variableDefinition473 = new BitSet(
            new long[] { 0x0000000000000008L });
    public static final BitSet FOLLOW_GENERATED_VARIABLE_DEFINITION_in_variableDefinition486 = new BitSet(
            new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_VARIABLE_NAME_in_variableDefinition492 = new BitSet(
            new long[] { 0x0000000000000000L, 0x0000000002000000L });
    public static final BitSet FOLLOW_VARIABLE_TYPE_in_variableDefinition494 = new BitSet(
            new long[] { 0x0000000000000000L, 0x0000000000020000L });
    public static final BitSet FOLLOW_CREATE_INTERSECTION_in_variableDefinition497 = new BitSet(
            new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_aggregandums_in_variableDefinition503 = new BitSet(
            new long[] { 0x0000000000000008L });
    public static final BitSet FOLLOW_GENERATED_VARIABLE_DEFINITION_in_variableDefinition516 = new BitSet(
            new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_VARIABLE_NAME_in_variableDefinition522 = new BitSet(
            new long[] { 0x0000000000000000L, 0x0000000002000000L });
    public static final BitSet FOLLOW_VARIABLE_TYPE_in_variableDefinition524 = new BitSet(
            new long[] { 0x0000000000000000L, 0x0000000000040000L });
    public static final BitSet FOLLOW_CREATE_DISJUNCTION_in_variableDefinition527 = new BitSet(
            new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_aggregandums_in_variableDefinition533 = new BitSet(
            new long[] { 0x0000000000000008L });
    public static final BitSet FOLLOW_STRING_OPERATION_in_stringOperation587 = new BitSet(
            new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_stringExpression_in_stringOperation595 = new BitSet(
            new long[] { 0x0000110000000008L, 0x0300000000000000L });
    public static final BitSet FOLLOW_DBLQUOTE_in_stringExpression635 = new BitSet(
            new long[] { 0x0000000000000002L });
    public static final BitSet FOLLOW_IDENTIFIER_in_stringExpression655 = new BitSet(
            new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_VARIABLE_NAME_in_stringExpression657 = new BitSet(
            new long[] { 0x0000000000000000L, 0x0000000000004000L });
    public static final BitSet FOLLOW_DOT_in_stringExpression659 = new BitSet(new long[] {
            0x0000000000000000L, 0x0000000000000000L, 0x0000000000000000L,
            0x0000000000000000L, 0x0000000000000000L, 0x0000001000000000L });
    public static final BitSet FOLLOW_GROUPS_in_stringExpression661 = new BitSet(
            new long[] { 0x0000000000000000L, 0x0000000000000000L, 0x0000000000000000L,
                    0x0000000000000000L, 0x0000000008000000L });
    public static final BitSet FOLLOW_ATTRIBUTE_SELECTOR_in_stringExpression664 = new BitSet(
            new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_INTEGER_in_stringExpression666 = new BitSet(
            new long[] { 0x0000000000000008L });
    public static final BitSet FOLLOW_IDENTIFIER_in_stringExpression685 = new BitSet(
            new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_VARIABLE_NAME_in_stringExpression688 = new BitSet(
            new long[] { 0x0000000000000000L, 0x0000000000004000L });
    public static final BitSet FOLLOW_DOT_in_stringExpression690 = new BitSet(new long[] {
            0x0000000000000000L, 0x0000000000000000L, 0x0000000000000000L,
            0x0000000000000000L, 0x0000000000000000L, 0x0000000800000000L });
    public static final BitSet FOLLOW_RENDERING_in_stringExpression694 = new BitSet(
            new long[] { 0x0000000000000008L });
    public static final BitSet FOLLOW_TO_LOWER_CASE_in_stringExpression709 = new BitSet(
            new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_stringOperation_in_stringExpression715 = new BitSet(
            new long[] { 0x0000000000000008L });
    public static final BitSet FOLLOW_TO_UPPER_CASE_in_stringExpression726 = new BitSet(
            new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_stringOperation_in_stringExpression732 = new BitSet(
            new long[] { 0x0000000000000008L });
    public static final BitSet FOLLOW_TO_LOWER_CASE_in_stringExpression742 = new BitSet(
            new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_stringExpression_in_stringExpression748 = new BitSet(
            new long[] { 0x0000000000000008L });
    public static final BitSet FOLLOW_TO_UPPER_CASE_in_stringExpression759 = new BitSet(
            new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_stringExpression_in_stringExpression765 = new BitSet(
            new long[] { 0x0000000000000008L });
    public static final BitSet FOLLOW_VARIABLE_SCOPE_in_variableScope807 = new BitSet(
            new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_SUBCLASS_OF_in_variableScope809 = new BitSet(
            new long[] { 0xFFFFFFFFFFFFFFF0L, 0xFFFFFFFFFFFFFFFFL, 0xFFFFFFFFFFFFFFFFL,
                    0xFFFFFFFFFFFFFFFFL, 0xFFFFFFFFFFFFFFFFL, 0xFFFFFFFFFFFFFFFFL,
                    0xFFFFFFFFFFFFFFFFL, 0x0000007FFFFFFFFFL });
    public static final BitSet FOLLOW_VARIABLE_SCOPE_in_variableScope826 = new BitSet(
            new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_SUPER_CLASS_OF_in_variableScope828 = new BitSet(
            new long[] { 0xFFFFFFFFFFFFFFF0L, 0xFFFFFFFFFFFFFFFFL, 0xFFFFFFFFFFFFFFFFL,
                    0xFFFFFFFFFFFFFFFFL, 0xFFFFFFFFFFFFFFFFL, 0xFFFFFFFFFFFFFFFFL,
                    0xFFFFFFFFFFFFFFFFL, 0x0000007FFFFFFFFFL });
    public static final BitSet FOLLOW_VARIABLE_SCOPE_in_variableScope847 = new BitSet(
            new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_SUPER_PROPERTY_OF_in_variableScope849 = new BitSet(
            new long[] { 0xFFFFFFFFFFFFFFF0L, 0xFFFFFFFFFFFFFFFFL, 0xFFFFFFFFFFFFFFFFL,
                    0xFFFFFFFFFFFFFFFFL, 0xFFFFFFFFFFFFFFFFL, 0xFFFFFFFFFFFFFFFFL,
                    0xFFFFFFFFFFFFFFFFL, 0x0000007FFFFFFFFFL });
    public static final BitSet FOLLOW_VARIABLE_SCOPE_in_variableScope864 = new BitSet(
            new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_SUBPROPERTY_OF_in_variableScope866 = new BitSet(
            new long[] { 0xFFFFFFFFFFFFFFF0L, 0xFFFFFFFFFFFFFFFFL, 0xFFFFFFFFFFFFFFFFL,
                    0xFFFFFFFFFFFFFFFFL, 0xFFFFFFFFFFFFFFFFL, 0xFFFFFFFFFFFFFFFFL,
                    0xFFFFFFFFFFFFFFFFL, 0x0000007FFFFFFFFFL });
    public static final BitSet FOLLOW_VARIABLE_SCOPE_in_variableScope885 = new BitSet(
            new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_set_in_variableScope887 = new BitSet(new long[] {
            0xFFFFFFFFFFFFFFF0L, 0xFFFFFFFFFFFFFFFFL, 0xFFFFFFFFFFFFFFFFL,
            0xFFFFFFFFFFFFFFFFL, 0xFFFFFFFFFFFFFFFFL, 0xFFFFFFFFFFFFFFFFL,
            0xFFFFFFFFFFFFFFFFL, 0x0000007FFFFFFFFFL });
    public static final BitSet FOLLOW_INEQUALITY_CONSTRAINT_in_constraint930 = new BitSet(
            new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_IDENTIFIER_in_constraint932 = new BitSet(
            new long[] { 0x0000000000000000L, 0x0000000000000020L });
    public static final BitSet FOLLOW_EXPRESSION_in_constraint935 = new BitSet(
            new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_IN_SET_CONSTRAINT_in_constraint949 = new BitSet(
            new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_IDENTIFIER_in_constraint955 = new BitSet(
            new long[] { 0x0000100000000000L });
    public static final BitSet FOLLOW_IDENTIFIER_in_constraint963 = new BitSet(
            new long[] { 0x0000100000000008L });
    public static final BitSet FOLLOW_REGEXP_CONSTRAINT_in_constraint976 = new BitSet(
            new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_IDENTIFIER_in_constraint978 = new BitSet(
            new long[] { 0x0000000000000000L, 0x0000000000000000L, 0x0000000000000000L,
                    0x0000000000000000L, 0x0000000000000000L, 0x0000000000000000L,
                    0x0000000000000400L });
    public static final BitSet FOLLOW_stringOperation_in_constraint984 = new BitSet(
            new long[] { 0x0000000000000008L });
    public static final BitSet FOLLOW_NAF_CONSTRAINT_in_constraint996 = new BitSet(
            new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_aggregandum_in_aggregandums1032 = new BitSet(
            new long[] { 0x0000100000000002L });
    public static final BitSet FOLLOW_DISJOINT_CLASSES_in_opplAxioms1062 = new BitSet(
            new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_EXPRESSION_in_opplAxioms1065 = new BitSet(
            new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_SET_in_opplAxioms1068 = new BitSet(
            new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_aggregandums_in_opplAxioms1074 = new BitSet(
            new long[] { 0x0000000000000008L });
    public static final BitSet FOLLOW_DISJOINT_PROPERTIES_in_opplAxioms1084 = new BitSet(
            new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_EXPRESSION_in_opplAxioms1087 = new BitSet(
            new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_SET_in_opplAxioms1090 = new BitSet(
            new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_aggregandums_in_opplAxioms1096 = new BitSet(
            new long[] { 0x0000000000000008L });
    public static final BitSet FOLLOW_DIFFERENT_INDIVIDUALS_in_opplAxioms1107 = new BitSet(
            new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_EXPRESSION_in_opplAxioms1110 = new BitSet(
            new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_SET_in_opplAxioms1113 = new BitSet(
            new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_aggregandums_in_opplAxioms1119 = new BitSet(
            new long[] { 0x0000000000000008L });
    public static final BitSet FOLLOW_SAME_INDIVIDUAL_in_opplAxioms1130 = new BitSet(
            new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_EXPRESSION_in_opplAxioms1133 = new BitSet(
            new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_SET_in_opplAxioms1136 = new BitSet(
            new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_aggregandums_in_opplAxioms1142 = new BitSet(
            new long[] { 0x0000000000000008L });
    public static final BitSet FOLLOW_IDENTIFIER_in_aggregandum1172 = new BitSet(
            new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_VARIABLE_NAME_in_aggregandum1175 = new BitSet(
            new long[] { 0x0000000000000000L, 0x0000000000004000L });
    public static final BitSet FOLLOW_DOT_in_aggregandum1177 = new BitSet(new long[] {
            0x0000000000000000L, 0x0000000000000000L, 0x0000000000000000L,
            0x0000000000000000L, 0x0000000000000000L, 0x0000000400000000L });
    public static final BitSet FOLLOW_VALUES_in_aggregandum1180 = new BitSet(
            new long[] { 0x0000000000000008L });
    public static final BitSet FOLLOW_IDENTIFIER_in_aggregandum1197 = new BitSet(
            new long[] { 0x0000000000000002L });
}
