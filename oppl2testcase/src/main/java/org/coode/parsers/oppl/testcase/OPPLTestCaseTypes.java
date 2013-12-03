// $ANTLR 3.2 Sep 23, 2009 12:02:23 /Users/luigi/Documents/workspace/Parsers/src/OPPLTestCaseTypes.g 2011-01-10 16:48:15
package org.coode.parsers.oppl.testcase;

import static org.coode.oppl.utils.ArgCheck.checkNotNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.antlr.runtime.BitSet;
import org.antlr.runtime.EarlyExitException;
import org.antlr.runtime.IntStream;
import org.antlr.runtime.MismatchedTokenException;
import org.antlr.runtime.NoViableAltException;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.RecognizerSharedState;
import org.antlr.runtime.Token;
import org.antlr.runtime.tree.RewriteEmptyStreamException;
import org.antlr.runtime.tree.TreeFilter;
import org.antlr.runtime.tree.TreeNodeStream;
import org.antlr.runtime.tree.TreeRuleReturnScope;
import org.coode.oppl.ConstraintSystem;
import org.coode.oppl.OPPLQuery;
import org.coode.oppl.OPPLScript;
import org.coode.oppl.Variable;
import org.coode.oppl.bindingtree.Assignment;
import org.coode.oppl.bindingtree.BindingNode;
import org.coode.oppl.exceptions.RuntimeExceptionHandler;
import org.coode.parsers.ErrorListener;
import org.coode.parsers.oppl.OPPLSyntaxTree;
import org.coode.parsers.oppl.testcase.assertions.Assertion;
import org.coode.parsers.oppl.testcase.assertions.AssertionExpression;
import org.semanticweb.owlapi.model.OWLAxiomChange;
import org.semanticweb.owlapi.model.OWLObject;

@SuppressWarnings({ "javadoc", "incomplete-switch" })
public class OPPLTestCaseTypes extends TreeFilter {
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
            "IRI_ATTRIBUTE_NAME", "AT", "ESCLAMATION_MARK", "MATCH",
            "ATTRIBUTE_SELECTOR", "VALUES", "RENDERING", "GROUPS", "STRING_OPERATION",
            "VARIABLE_NAME", "REGEXP_CONSTRAINT", "FAIL", "NAF_CONSTRAINT", "COUNT",
            "SEMICOLON", "INFERENCE", "CONTAINS", "OPPL_TEST_CASE", "MESSAGE", "TEST",
            "ASSERT_EQUAL", "ASSERT_NOT_EQUAL", "ASSERT_TRUE", "ASSERT_FALSE", "TEXT",
            "ASSERT", "STAR", "LESS_THAN", "LESS_THAN_EQUAL", "GREATER_THAN",
            "GREATER_THAN_EQUAL", "ASSERT_LESS_THAN", "ASSERT_LESS_THAN_EQUAL",
            "ASSERT_GREATER_THAN", "ASSERT_GREATER_THAN_EQUAL", "BINDING" };
    public static final int COMMA = 37;
    public static final int GREATER_THAN = 485;
    public static final int ASSERTED = 76;
    public static final int VARIABLE_DEFINITIONS = 102;
    public static final int REGEXP_CONSTRAINT = 465;
    public static final int END = 84;
    public static final int ASSERT_GREATER_THAN_EQUAL = 490;
    public static final int DIFFERENT_FROM = 24;
    public static final int LESS_THAN = 483;
    public static final int TYPE_ASSERTION = 66;
    public static final int SAME_AS_AXIOM = 52;
    public static final int TYPES = 39;
    public static final int ROLE_ASSERTION = 67;
    public static final int CREATE_OPPL_FUNCTION = 98;
    public static final int ESCLAMATION_MARK = 149;
    public static final int VARIABLE_IDENTIFIER = 106;
    public static final int ASSERTED_CLAUSE = 92;
    public static final int DOT = 78;
    public static final int ALL_RESTRICTION = 62;
    public static final int QUESTION_MARK = 46;
    public static final int AND = 10;
    public static final int EXPRESSION = 69;
    public static final int CONSTANT = 70;
    public static final int ASSERT_LESS_THAN = 487;
    public static final int VALUE_RESTRICTION = 63;
    public static final int BINDING = 491;
    public static final int ONE_OF = 65;
    public static final int SUBPROPERTY_OF = 105;
    public static final int SELECT = 75;
    public static final int CARDINALITY_RESTRICTION = 64;
    public static final int ASSERT_NOT_EQUAL = 477;
    public static final int ASSERT = 481;
    public static final int ASSERT_FALSE = 479;
    public static final int SAME_AS = 23;
    public static final int EXACTLY = 17;
    public static final int PLUS = 79;
    public static final int TRANSITIVE = 34;
    public static final int IN_SET_CONSTRAINT = 95;
    public static final int SUBCLASS_OF = 20;
    public static final int ENTITY_REFERENCE = 45;
    public static final int CONJUNCTION = 56;
    public static final int INVERSE_OF = 25;
    public static final int AT = 114;
    public static final int RANGE = 28;
    public static final int CLOSED_PARENTHESYS = 8;
    public static final int PROPERTY_CHAIN = 57;
    public static final int CREATE_INTERSECTION = 81;
    public static final int EQUIVALENT_TO_AXIOM = 49;
    public static final int OPEN_SQUARE_BRACKET = 85;
    public static final int NAF_CONSTRAINT = 467;
    public static final int SYMMETRIC = 30;
    public static final int DISJOINT_WITH = 26;
    public static final int MESSAGE = 474;
    public static final int VARIABLE_TYPE = 89;
    public static final int DISJUNCTION = 55;
    public static final int GROUPS = 356;
    public static final int NEGATED_EXPRESSION = 58;
    public static final int EQUAL = 73;
    public static final int SEMICOLON = 469;
    public static final int DIFFERENT_FROM_AXIOM = 53;
    public static final int GREATER_THAN_EQUAL = 486;
    public static final int ACTIONS = 101;
    public static final int COUNT = 468;
    public static final int EQUIVALENT_TO = 22;
    public static final int DOMAIN = 27;
    public static final int TEXT = 480;
    public static final int SUB_PROPERTY_OF = 21;
    public static final int INVERSE_OBJECT_PROPERTY_EXPRESSION = 68;
    public static final int INVERSE_PROPERTY = 60;
    public static final int COLON = 77;
    public static final int GENERATED_VARIABLE_DEFINITION = 97;
    public static final int VARIABLE_ATTRIBUTE = 99;
    public static final int SUB_CLASS_AXIOM = 48;
    public static final int SUB_PROPERTY_AXIOM = 51;
    public static final int IDENTIFIER = 44;
    public static final int UNARY_AXIOM = 54;
    public static final int ADD = 90;
    public static final int INFERENCE = 470;
    public static final int WHERE = 71;
    public static final int CREATE = 80;
    public static final int VARIABLE_SCOPE = 104;
    public static final int OPEN_CURLY_BRACES = 6;
    public static final int ASSERT_EQUAL = 476;
    public static final int CLOSED_SQUARE_BRACKET = 86;
    public static final int INSTANCE_OF = 38;
    public static final int VALUES = 354;
    public static final int QUERY = 103;
    public static final int SOME_RESTRICTION = 61;
    public static final int IRI = 110;
    public static final int LESS_THAN_EQUAL = 484;
    public static final int VALUE = 18;
    public static final int RENDERING = 355;
    public static final int INVERSE_FUNCTIONAL = 35;
    public static final int ATTRIBUTE_SELECTOR = 283;
    public static final int ASSERT_GREATER_THAN = 489;
    public static final int PLAIN_CLAUSE = 93;
    public static final int OR = 11;
    public static final int INTEGER = 42;
    public static final int INVERSE = 19;
    public static final int HAS_KEY = 109;
    public static final int DISJOINT_WITH_AXIOM = 50;
    public static final int SUPER_CLASS_OF = 87;
    public static final int CONTAINS = 471;
    public static final int OPPL_FUNCTION = 100;
    public static final int DIGIT = 41;
    public static final int ASSERT_TRUE = 478;
    public static final int COMPOSITION = 4;
    public static final int ANNOTATION_ASSERTION = 111;
    public static final int OPPL_STATEMENT = 107;
    public static final int FUNCTIONAL = 29;
    public static final int NOT_EQUAL = 72;
    public static final int LETTER = 43;
    public static final int MAX = 16;
    public static final int FAIL = 466;
    public static final int NEGATED_ASSERTION = 59;
    public static final int INPUT_VARIABLE_DEFINITION = 96;
    public static final int ONLY = 14;
    public static final int CREATE_DISJUNCTION = 82;
    public static final int REMOVE = 91;
    public static final int DBLQUOTE = 40;
    public static final int MIN = 15;
    public static final int POW = 36;
    public static final int MATCH = 176;
    public static final int BEGIN = 83;
    public static final int WHITESPACE = 9;
    public static final int IN = 74;
    public static final int SUPER_PROPERTY_OF = 88;
    public static final int INEQUALITY_CONSTRAINT = 94;
    public static final int SOME = 13;
    public static final int ASSERT_LESS_THAN_EQUAL = 488;
    public static final int EOF = -1;
    public static final int OPPL_TEST_CASE = 473;
    public static final int ANTI_SYMMETRIC = 31;
    public static final int Tokens = 47;
    public static final int CLOSED_CURLY_BRACES = 7;
    public static final int TEST = 475;
    public static final int STAR = 482;
    public static final int IRI_ATTRIBUTE_NAME = 112;
    public static final int REFLEXIVE = 32;
    public static final int NOT = 12;
    public static final int STRING_OPERATION = 394;
    public static final int OPEN_PARENTHESYS = 5;
    public static final int VARIABLE_NAME = 464;
    public static final int IRREFLEXIVE = 33;

    // delegates
    // delegators
    public OPPLTestCaseTypes(TreeNodeStream input) {
        this(input, new RecognizerSharedState());
    }

    public OPPLTestCaseTypes(TreeNodeStream input, RecognizerSharedState state) {
        super(input, state);
    }

    @Override
    public String[] getTokenNames() {
        return OPPLTestCaseTypes.tokenNames;
    }

    @Override
    public String getGrammarFileName() {
        return "/Users/luigi/Documents/workspace/Parsers/src/OPPLTestCaseTypes.g";
    }

    private OPPLTestCaseSymbolTable symtab;
    private ErrorListener errorListener;
    private ConstraintSystem constraintSystem;
    private AbstractOPPLTestCaseFactory testCaseFactory;
    private RuntimeExceptionHandler handler;

    public OPPLTestCaseTypes(TreeNodeStream input, OPPLTestCaseSymbolTable symtab,
            ErrorListener errorListener, ConstraintSystem constraintSystem,
            AbstractOPPLTestCaseFactory testCaseFactory, RuntimeExceptionHandler handler) {
        this(input);
        this.symtab = checkNotNull(symtab, "symtab");
        this.errorListener = checkNotNull(errorListener, "errorListener");
        this.constraintSystem = checkNotNull(constraintSystem, "constraintSystem");
        this.testCaseFactory = checkNotNull(testCaseFactory, "testCaseFactory");
        this.handler = checkNotNull(handler, "handler");
    }

    public ErrorListener getErrorListener() {
        return errorListener;
    }

    public RuntimeExceptionHandler getHandler() {
        return handler;
    }

    public ConstraintSystem getConstraintSystem() {
        return constraintSystem;
    }

    public OPPLTestCaseSymbolTable getSymbolTable() {
        return symtab;
    }

    public AbstractOPPLTestCaseFactory getTestCaseFactory() {
        return testCaseFactory;
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
    // /Users/luigi/Documents/workspace/Parsers/src/OPPLTestCaseTypes.g:110:1:
    // bottomup : ( testCase | textVariableRef );
    @Override
    public final void bottomup() throws RecognitionException {
        try {
            // /Users/luigi/Documents/workspace/Parsers/src/OPPLTestCaseTypes.g:111:5:
            // ( testCase | textVariableRef )
            int alt1 = 2;
            int LA1_0 = input.LA(1);
            if (LA1_0 == OPPL_TEST_CASE) {
                alt1 = 1;
            } else if (LA1_0 == TEXT) {
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
                // /Users/luigi/Documents/workspace/Parsers/src/OPPLTestCaseTypes.g:112:6:
                // testCase
                {
                    pushFollow(FOLLOW_testCase_in_bottomup81);
                    testCase();
                    state._fsp--;
                    if (state.failed) {
                        return;
                    }
                }
                    break;
                case 2:
                // /Users/luigi/Documents/workspace/Parsers/src/OPPLTestCaseTypes.g:113:8:
                // textVariableRef
                {
                    pushFollow(FOLLOW_textVariableRef_in_bottomup90);
                    textVariableRef();
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
    public static class testCase_return extends TreeRuleReturnScope {}

    // $ANTLR start "testCase"
    // /Users/luigi/Documents/workspace/Parsers/src/OPPLTestCaseTypes.g:117:1:
    // testCase : ^( OPPL_TEST_CASE IDENTIFIER ( INFERENCE )? s= statement
    // someTests= tests ) ;
    public final OPPLTestCaseTypes.testCase_return testCase() {
        OPPLTestCaseTypes.testCase_return retval = new OPPLTestCaseTypes.testCase_return();
        retval.start = input.LT(1);
        OPPLSyntaxTree IDENTIFIER1 = null;
        OPPLSyntaxTree INFERENCE2 = null;
        OPPLTestCaseTypes.statement_return s = null;
        List<OPPLTest> someTests = null;
        try {
            // /Users/luigi/Documents/workspace/Parsers/src/OPPLTestCaseTypes.g:118:2:
            // ( ^( OPPL_TEST_CASE IDENTIFIER ( INFERENCE )? s= statement
            // someTests= tests ) )
            // /Users/luigi/Documents/workspace/Parsers/src/OPPLTestCaseTypes.g:119:3:
            // ^( OPPL_TEST_CASE IDENTIFIER ( INFERENCE )? s= statement
            // someTests= tests )
            {
                match(input, OPPL_TEST_CASE, FOLLOW_OPPL_TEST_CASE_in_testCase108);
                if (state.failed) {
                    return retval;
                }
                match(input, Token.DOWN, null);
                if (state.failed) {
                    return retval;
                }
                IDENTIFIER1 = (OPPLSyntaxTree) match(input, IDENTIFIER,
                        FOLLOW_IDENTIFIER_in_testCase110);
                if (state.failed) {
                    return retval;
                }
                // /Users/luigi/Documents/workspace/Parsers/src/OPPLTestCaseTypes.g:119:31:
                // ( INFERENCE )?
                int alt2 = 2;
                int LA2_0 = input.LA(1);
                if (LA2_0 == INFERENCE) {
                    alt2 = 1;
                }
                switch (alt2) {
                    case 1:
                    // /Users/luigi/Documents/workspace/Parsers/src/OPPLTestCaseTypes.g:119:31:
                    // INFERENCE
                    {
                        INFERENCE2 = (OPPLSyntaxTree) match(input, INFERENCE,
                                FOLLOW_INFERENCE_in_testCase112);
                        if (state.failed) {
                            return retval;
                        }
                    }
                        break;
                }
                pushFollow(FOLLOW_statement_in_testCase119);
                s = statement();
                state._fsp--;
                if (state.failed) {
                    return retval;
                }
                pushFollow(FOLLOW_tests_in_testCase125);
                someTests = tests();
                state._fsp--;
                if (state.failed) {
                    return retval;
                }
                match(input, Token.UP, null);
                if (state.failed) {
                    return retval;
                }
                if (state.backtracking == 1) {
                    if (s.statementTree.getOPPLContent() instanceof OPPLScript) {
                        if (!someTests.isEmpty()) {
                            OPPLTestCase testCase = getTestCaseFactory()
                                    .buildOPPLTestCase(
                                            IDENTIFIER1 != null ? IDENTIFIER1.getText()
                                                    : null,
                                            (OPPLScript) s.statementTree.getOPPLContent(),
                                            someTests, INFERENCE2 != null);
                            ((OPPLSyntaxTree) retval.start).setOPPLContent(testCase);
                        } else {
                            getErrorListener().illegalToken(
                                    (OPPLSyntaxTree) retval.start, "No Valid Tests");
                        }
                    } else {
                        getErrorListener().illegalToken((OPPLSyntaxTree) retval.start,
                                "Invalid OPPL statement");
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

    // $ANTLR end "testCase"
    // $ANTLR start "tests"
    // /Users/luigi/Documents/workspace/Parsers/src/OPPLTestCaseTypes.g:135:1:
    // tests returns [List<Test> tests] : (t= test )+ ;
    public final List<OPPLTest> tests() {
        List<OPPLTest> tests = null;
        OPPLTest t = null;
        tests = new ArrayList<OPPLTest>();
        try {
            // /Users/luigi/Documents/workspace/Parsers/src/OPPLTestCaseTypes.g:140:2:
            // ( (t= test )+ )
            // /Users/luigi/Documents/workspace/Parsers/src/OPPLTestCaseTypes.g:141:3:
            // (t= test )+
            {
                // /Users/luigi/Documents/workspace/Parsers/src/OPPLTestCaseTypes.g:141:3:
                // (t= test )+
                int cnt3 = 0;
                loop3: do {
                    int alt3 = 2;
                    int LA3_0 = input.LA(1);
                    if (LA3_0 == TEST) {
                        alt3 = 1;
                    }
                    switch (alt3) {
                        case 1:
                        // /Users/luigi/Documents/workspace/Parsers/src/OPPLTestCaseTypes.g:141:5:
                        // t= test
                        {
                            pushFollow(FOLLOW_test_in_tests165);
                            t = test();
                            state._fsp--;
                            if (state.failed) {
                                return tests;
                            }
                            if (state.backtracking == 1) {
                                if (t != null) {
                                    tests.add(t);
                                }
                            }
                        }
                            break;
                        default:
                            if (cnt3 >= 1) {
                                break loop3;
                            }
                            if (state.backtracking > 0) {
                                state.failed = true;
                                return tests;
                            }
                            EarlyExitException eee = new EarlyExitException(3, input);
                            throw eee;
                    }
                    cnt3++;
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
        return tests;
    }

    // $ANTLR end "tests"
    public static class statement_return extends TreeRuleReturnScope {
        public OPPLSyntaxTree statementTree;
    }

    // $ANTLR start "statement"
    // /Users/luigi/Documents/workspace/Parsers/src/OPPLTestCaseTypes.g:148:1:
    // statement returns [OPPLSyntaxTree statementTree] : ^( OPPL_STATEMENT (
    // ^(vd= VARIABLE_DEFINITIONS ( . )* ) )? ^(query= QUERY ( . )* ) ) ;
    public final OPPLTestCaseTypes.statement_return statement() {
        OPPLTestCaseTypes.statement_return retval = new OPPLTestCaseTypes.statement_return();
        retval.start = input.LT(1);
        OPPLSyntaxTree vd = null;
        OPPLSyntaxTree query = null;
        List<Variable<?>> vds = new ArrayList<Variable<?>>();
        try {
            // /Users/luigi/Documents/workspace/Parsers/src/OPPLTestCaseTypes.g:156:2:
            // ( ^( OPPL_STATEMENT ( ^(vd= VARIABLE_DEFINITIONS ( . )* ) )?
            // ^(query= QUERY ( . )* ) ) )
            // /Users/luigi/Documents/workspace/Parsers/src/OPPLTestCaseTypes.g:157:3:
            // ^( OPPL_STATEMENT ( ^(vd= VARIABLE_DEFINITIONS ( . )* ) )?
            // ^(query= QUERY ( . )* ) )
            {
                match(input, OPPL_STATEMENT, FOLLOW_OPPL_STATEMENT_in_statement194);
                if (state.failed) {
                    return retval;
                }
                match(input, Token.DOWN, null);
                if (state.failed) {
                    return retval;
                }
                // /Users/luigi/Documents/workspace/Parsers/src/OPPLTestCaseTypes.g:157:21:
                // ( ^(vd= VARIABLE_DEFINITIONS ( . )* ) )?
                int alt5 = 2;
                int LA5_0 = input.LA(1);
                if (LA5_0 == VARIABLE_DEFINITIONS) {
                    alt5 = 1;
                }
                switch (alt5) {
                    case 1:
                    // /Users/luigi/Documents/workspace/Parsers/src/OPPLTestCaseTypes.g:157:22:
                    // ^(vd= VARIABLE_DEFINITIONS ( . )* )
                    {
                        vd = (OPPLSyntaxTree) match(input, VARIABLE_DEFINITIONS,
                                FOLLOW_VARIABLE_DEFINITIONS_in_statement203);
                        if (state.failed) {
                            return retval;
                        }
                        if (input.LA(1) == Token.DOWN) {
                            match(input, Token.DOWN, null);
                            if (state.failed) {
                                return retval;
                            }
                            // /Users/luigi/Documents/workspace/Parsers/src/OPPLTestCaseTypes.g:157:50:
                            // ( . )*
                            loop4: do {
                                int alt4 = 2;
                                int LA4_0 = input.LA(1);
                                if (LA4_0 >= COMPOSITION && LA4_0 <= BINDING) {
                                    alt4 = 1;
                                } else if (LA4_0 == UP) {
                                    alt4 = 2;
                                }
                                switch (alt4) {
                                    case 1:
                                    // /Users/luigi/Documents/workspace/Parsers/src/OPPLTestCaseTypes.g:157:50:
                                    // .
                                    {
                                        matchAny(input);
                                        if (state.failed) {
                                            return retval;
                                        }
                                    }
                                        break;
                                    default:
                                        break loop4;
                                }
                            } while (true);
                            match(input, Token.UP, null);
                            if (state.failed) {
                                return retval;
                            }
                        }
                    }
                        break;
                }
                query = (OPPLSyntaxTree) match(input, QUERY, FOLLOW_QUERY_in_statement215);
                if (state.failed) {
                    return retval;
                }
                if (input.LA(1) == Token.DOWN) {
                    match(input, Token.DOWN, null);
                    if (state.failed) {
                        return retval;
                    }
                    // /Users/luigi/Documents/workspace/Parsers/src/OPPLTestCaseTypes.g:157:71:
                    // ( . )*
                    loop6: do {
                        int alt6 = 2;
                        int LA6_0 = input.LA(1);
                        if (LA6_0 >= COMPOSITION && LA6_0 <= BINDING) {
                            alt6 = 1;
                        } else if (LA6_0 == UP) {
                            alt6 = 2;
                        }
                        switch (alt6) {
                            case 1:
                            // /Users/luigi/Documents/workspace/Parsers/src/OPPLTestCaseTypes.g:157:71:
                            // .
                            {
                                matchAny(input);
                                if (state.failed) {
                                    return retval;
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
                match(input, Token.UP, null);
                if (state.failed) {
                    return retval;
                }
                if (state.backtracking == 1) {
                    if (vd != null) {
                        vds.addAll((List<Variable<?>>) vd.getOPPLContent());
                    }
                    if (query.getOPPLContent() != null) {
                        ((OPPLSyntaxTree) retval.start)
                                .setOPPLContent(getTestCaseFactory().getOPPLFactory()
                                        .buildOPPLScript(getConstraintSystem(), vds,
                                                (OPPLQuery) query.getOPPLContent(),
                                                Collections.<OWLAxiomChange> emptyList()));
                    } else {
                        getErrorListener().illegalToken((OPPLSyntaxTree) retval.start,
                                "Invalid query content");
                    }
                }
            }
            if (state.backtracking == 1) {
                retval.statementTree = (OPPLSyntaxTree) retval.start;
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
    // $ANTLR start "test"
    // /Users/luigi/Documents/workspace/Parsers/src/OPPLTestCaseTypes.g:173:1:
    // test returns [Test t] : ^( TEST anAssertion= assertion ( ^( MESSAGE ( .
    // )* ) )? ) ;
    public final OPPLTest test() {
        OPPLTest t = null;
        OPPLSyntaxTree MESSAGE3 = null;
        OPPLTestCaseTypes.assertion_return anAssertion = null;
        try {
            // /Users/luigi/Documents/workspace/Parsers/src/OPPLTestCaseTypes.g:174:2:
            // ( ^( TEST anAssertion= assertion ( ^( MESSAGE ( . )* ) )? ) )
            // /Users/luigi/Documents/workspace/Parsers/src/OPPLTestCaseTypes.g:175:2:
            // ^( TEST anAssertion= assertion ( ^( MESSAGE ( . )* ) )? )
            {
                match(input, TEST, FOLLOW_TEST_in_test241);
                if (state.failed) {
                    return t;
                }
                match(input, Token.DOWN, null);
                if (state.failed) {
                    return t;
                }
                pushFollow(FOLLOW_assertion_in_test247);
                anAssertion = assertion();
                state._fsp--;
                if (state.failed) {
                    return t;
                }
                // /Users/luigi/Documents/workspace/Parsers/src/OPPLTestCaseTypes.g:175:33:
                // ( ^( MESSAGE ( . )* ) )?
                int alt8 = 2;
                int LA8_0 = input.LA(1);
                if (LA8_0 == MESSAGE) {
                    alt8 = 1;
                }
                switch (alt8) {
                    case 1:
                    // /Users/luigi/Documents/workspace/Parsers/src/OPPLTestCaseTypes.g:175:34:
                    // ^( MESSAGE ( . )* )
                    {
                        MESSAGE3 = (OPPLSyntaxTree) match(input, MESSAGE,
                                FOLLOW_MESSAGE_in_test251);
                        if (state.failed) {
                            return t;
                        }
                        if (input.LA(1) == Token.DOWN) {
                            match(input, Token.DOWN, null);
                            if (state.failed) {
                                return t;
                            }
                            // /Users/luigi/Documents/workspace/Parsers/src/OPPLTestCaseTypes.g:175:44:
                            // ( . )*
                            loop7: do {
                                int alt7 = 2;
                                int LA7_0 = input.LA(1);
                                if (LA7_0 >= COMPOSITION && LA7_0 <= BINDING) {
                                    alt7 = 1;
                                } else if (LA7_0 == UP) {
                                    alt7 = 2;
                                }
                                switch (alt7) {
                                    case 1:
                                    // /Users/luigi/Documents/workspace/Parsers/src/OPPLTestCaseTypes.g:175:44:
                                    // .
                                    {
                                        matchAny(input);
                                        if (state.failed) {
                                            return t;
                                        }
                                    }
                                        break;
                                    default:
                                        break loop7;
                                }
                            } while (true);
                            match(input, Token.UP, null);
                            if (state.failed) {
                                return t;
                            }
                        }
                    }
                        break;
                }
                match(input, Token.UP, null);
                if (state.failed) {
                    return t;
                }
                if (state.backtracking == 1) {
                    if (anAssertion.a != null) {
                        t = MESSAGE3 == null ? new OPPLTest(anAssertion.a)
                                : new OPPLTest(MESSAGE3.getText(), anAssertion.a);
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
        return t;
    }

    // $ANTLR end "test"
    public static class assertion_return extends TreeRuleReturnScope {
        public Assertion a;
    }

    // $ANTLR start "assertion"
    // /Users/luigi/Documents/workspace/Parsers/src/OPPLTestCaseTypes.g:184:1:
    // assertion returns [Assertion a] : ( ^( ASSERT_EQUAL left=
    // assertionExpression right= assertionExpression ) | ^( ASSERT_NOT_EQUAL
    // left= assertionExpression right= assertionExpression ) | ^(
    // ASSERT_LESS_THAN left= assertionExpression right= assertionExpression ) |
    // ^( ASSERT_LESS_THAN_EQUAL left= assertionExpression right=
    // assertionExpression ) | ^( ASSERT_GREATER_THAN left= assertionExpression
    // right= assertionExpression ) | ^( ASSERT_GREATER_THAN_EQUAL left=
    // assertionExpression right= assertionExpression ) | ^( CONTAINS
    // VARIABLE_NAME (expr= assertionExpression )+ ) | ^( NOT anAssertion=
    // assertion ) );
    public final OPPLTestCaseTypes.assertion_return assertion() {
        OPPLTestCaseTypes.assertion_return retval = new OPPLTestCaseTypes.assertion_return();
        retval.start = input.LT(1);
        OPPLSyntaxTree VARIABLE_NAME4 = null;
        OPPLTestCaseTypes.assertionExpression_return left = null;
        OPPLTestCaseTypes.assertionExpression_return right = null;
        OPPLTestCaseTypes.assertionExpression_return expr = null;
        OPPLTestCaseTypes.assertion_return anAssertion = null;
        List<OPPLSyntaxTree> containedAssertionExpressions = new ArrayList<OPPLSyntaxTree>();
        try {
            // /Users/luigi/Documents/workspace/Parsers/src/OPPLTestCaseTypes.g:188:2:
            // ( ^( ASSERT_EQUAL left= assertionExpression right=
            // assertionExpression ) | ^( ASSERT_NOT_EQUAL left=
            // assertionExpression right= assertionExpression ) | ^(
            // ASSERT_LESS_THAN left= assertionExpression right=
            // assertionExpression ) | ^( ASSERT_LESS_THAN_EQUAL left=
            // assertionExpression right= assertionExpression ) | ^(
            // ASSERT_GREATER_THAN left= assertionExpression right=
            // assertionExpression ) | ^( ASSERT_GREATER_THAN_EQUAL left=
            // assertionExpression right= assertionExpression ) | ^( CONTAINS
            // VARIABLE_NAME (expr= assertionExpression )+ ) | ^( NOT
            // anAssertion= assertion ) )
            int alt10 = 8;
            switch (input.LA(1)) {
                case ASSERT_EQUAL: {
                    alt10 = 1;
                }
                    break;
                case ASSERT_NOT_EQUAL: {
                    alt10 = 2;
                }
                    break;
                case ASSERT_LESS_THAN: {
                    alt10 = 3;
                }
                    break;
                case ASSERT_LESS_THAN_EQUAL: {
                    alt10 = 4;
                }
                    break;
                case ASSERT_GREATER_THAN: {
                    alt10 = 5;
                }
                    break;
                case ASSERT_GREATER_THAN_EQUAL: {
                    alt10 = 6;
                }
                    break;
                case CONTAINS: {
                    alt10 = 7;
                }
                    break;
                case NOT: {
                    alt10 = 8;
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
                // /Users/luigi/Documents/workspace/Parsers/src/OPPLTestCaseTypes.g:189:3:
                // ^( ASSERT_EQUAL left= assertionExpression right=
                // assertionExpression )
                {
                    match(input, ASSERT_EQUAL, FOLLOW_ASSERT_EQUAL_in_assertion285);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.DOWN, null);
                    if (state.failed) {
                        return retval;
                    }
                    pushFollow(FOLLOW_assertionExpression_in_assertion289);
                    left = assertionExpression();
                    state._fsp--;
                    if (state.failed) {
                        return retval;
                    }
                    pushFollow(FOLLOW_assertionExpression_in_assertion294);
                    right = assertionExpression();
                    state._fsp--;
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.UP, null);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 1) {
                        retval.a = getSymbolTable().getAssertEqual(left.ae, left.node,
                                right.ae, right.node, (OPPLSyntaxTree) retval.start);
                    }
                }
                    break;
                case 2:
                // /Users/luigi/Documents/workspace/Parsers/src/OPPLTestCaseTypes.g:192:5:
                // ^( ASSERT_NOT_EQUAL left= assertionExpression right=
                // assertionExpression )
                {
                    match(input, ASSERT_NOT_EQUAL,
                            FOLLOW_ASSERT_NOT_EQUAL_in_assertion303);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.DOWN, null);
                    if (state.failed) {
                        return retval;
                    }
                    pushFollow(FOLLOW_assertionExpression_in_assertion307);
                    left = assertionExpression();
                    state._fsp--;
                    if (state.failed) {
                        return retval;
                    }
                    pushFollow(FOLLOW_assertionExpression_in_assertion312);
                    right = assertionExpression();
                    state._fsp--;
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.UP, null);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 1) {
                        retval.a = getSymbolTable().getAssertNotEqual(left.ae, left.node,
                                right.ae, right.node, (OPPLSyntaxTree) retval.start);
                    }
                }
                    break;
                case 3:
                // /Users/luigi/Documents/workspace/Parsers/src/OPPLTestCaseTypes.g:195:5:
                // ^( ASSERT_LESS_THAN left= assertionExpression right=
                // assertionExpression )
                {
                    match(input, ASSERT_LESS_THAN,
                            FOLLOW_ASSERT_LESS_THAN_in_assertion321);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.DOWN, null);
                    if (state.failed) {
                        return retval;
                    }
                    pushFollow(FOLLOW_assertionExpression_in_assertion325);
                    left = assertionExpression();
                    state._fsp--;
                    if (state.failed) {
                        return retval;
                    }
                    pushFollow(FOLLOW_assertionExpression_in_assertion330);
                    right = assertionExpression();
                    state._fsp--;
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.UP, null);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 1) {
                        retval.a = getSymbolTable().getAssertLessThan(left.ae, left.node,
                                right.ae, right.node);
                    }
                }
                    break;
                case 4:
                // /Users/luigi/Documents/workspace/Parsers/src/OPPLTestCaseTypes.g:198:5:
                // ^( ASSERT_LESS_THAN_EQUAL left= assertionExpression right=
                // assertionExpression )
                {
                    match(input, ASSERT_LESS_THAN_EQUAL,
                            FOLLOW_ASSERT_LESS_THAN_EQUAL_in_assertion339);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.DOWN, null);
                    if (state.failed) {
                        return retval;
                    }
                    pushFollow(FOLLOW_assertionExpression_in_assertion343);
                    left = assertionExpression();
                    state._fsp--;
                    if (state.failed) {
                        return retval;
                    }
                    pushFollow(FOLLOW_assertionExpression_in_assertion348);
                    right = assertionExpression();
                    state._fsp--;
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.UP, null);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 1) {
                        retval.a = getSymbolTable().getAssertLessThanEqualtTo(left.ae,
                                left.node, right.ae, right.node);
                    }
                }
                    break;
                case 5:
                // /Users/luigi/Documents/workspace/Parsers/src/OPPLTestCaseTypes.g:201:5:
                // ^( ASSERT_GREATER_THAN left= assertionExpression right=
                // assertionExpression )
                {
                    match(input, ASSERT_GREATER_THAN,
                            FOLLOW_ASSERT_GREATER_THAN_in_assertion357);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.DOWN, null);
                    if (state.failed) {
                        return retval;
                    }
                    pushFollow(FOLLOW_assertionExpression_in_assertion361);
                    left = assertionExpression();
                    state._fsp--;
                    if (state.failed) {
                        return retval;
                    }
                    pushFollow(FOLLOW_assertionExpression_in_assertion366);
                    right = assertionExpression();
                    state._fsp--;
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.UP, null);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 1) {
                        retval.a = getSymbolTable().getAssertGreaterThan(left.ae,
                                left.node, right.ae, right.node);
                    }
                }
                    break;
                case 6:
                // /Users/luigi/Documents/workspace/Parsers/src/OPPLTestCaseTypes.g:204:5:
                // ^( ASSERT_GREATER_THAN_EQUAL left= assertionExpression right=
                // assertionExpression )
                {
                    match(input, ASSERT_GREATER_THAN_EQUAL,
                            FOLLOW_ASSERT_GREATER_THAN_EQUAL_in_assertion375);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.DOWN, null);
                    if (state.failed) {
                        return retval;
                    }
                    pushFollow(FOLLOW_assertionExpression_in_assertion379);
                    left = assertionExpression();
                    state._fsp--;
                    if (state.failed) {
                        return retval;
                    }
                    pushFollow(FOLLOW_assertionExpression_in_assertion384);
                    right = assertionExpression();
                    state._fsp--;
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.UP, null);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 1) {
                        retval.a = getSymbolTable().getAssertGreaterThanEqualTo(left.ae,
                                left.node, right.ae, right.node);
                    }
                }
                    break;
                case 7:
                // /Users/luigi/Documents/workspace/Parsers/src/OPPLTestCaseTypes.g:207:5:
                // ^( CONTAINS VARIABLE_NAME (expr= assertionExpression )+ )
                {
                    match(input, CONTAINS, FOLLOW_CONTAINS_in_assertion393);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.DOWN, null);
                    if (state.failed) {
                        return retval;
                    }
                    VARIABLE_NAME4 = (OPPLSyntaxTree) match(input, VARIABLE_NAME,
                            FOLLOW_VARIABLE_NAME_in_assertion395);
                    if (state.failed) {
                        return retval;
                    }
                    // /Users/luigi/Documents/workspace/Parsers/src/OPPLTestCaseTypes.g:207:30:
                    // (expr= assertionExpression )+
                    int cnt9 = 0;
                    loop9: do {
                        int alt9 = 2;
                        int LA9_0 = input.LA(1);
                        if (LA9_0 == INTEGER || LA9_0 == EXPRESSION || LA9_0 == COUNT) {
                            alt9 = 1;
                        }
                        switch (alt9) {
                            case 1:
                            // /Users/luigi/Documents/workspace/Parsers/src/OPPLTestCaseTypes.g:207:31:
                            // expr= assertionExpression
                            {
                                pushFollow(FOLLOW_assertionExpression_in_assertion401);
                                expr = assertionExpression();
                                state._fsp--;
                                if (state.failed) {
                                    return retval;
                                }
                                if (state.backtracking == 1) {
                                    containedAssertionExpressions.add(expr.node);
                                }
                            }
                                break;
                            default:
                                if (cnt9 >= 1) {
                                    break loop9;
                                }
                                if (state.backtracking > 0) {
                                    state.failed = true;
                                    return retval;
                                }
                                EarlyExitException eee = new EarlyExitException(9, input);
                                throw eee;
                        }
                        cnt9++;
                    } while (true);
                    match(input, Token.UP, null);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 1) {
                        retval.a = getSymbolTable().getAssertContains(VARIABLE_NAME4,
                                containedAssertionExpressions, getConstraintSystem(),
                                getTestCaseFactory(), (OPPLSyntaxTree) retval.start,
                                getHandler());
                    }
                }
                    break;
                case 8:
                // /Users/luigi/Documents/workspace/Parsers/src/OPPLTestCaseTypes.g:210:5:
                // ^( NOT anAssertion= assertion )
                {
                    match(input, NOT, FOLLOW_NOT_in_assertion414);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.DOWN, null);
                    if (state.failed) {
                        return retval;
                    }
                    pushFollow(FOLLOW_assertion_in_assertion419);
                    anAssertion = assertion();
                    state._fsp--;
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.UP, null);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 1) {
                        retval.a = getSymbolTable().getAssertionComplement(anAssertion.a);
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

    // $ANTLR end "assertion"
    public static class assertionExpression_return extends TreeRuleReturnScope {
        public AssertionExpression ae;
        public OPPLSyntaxTree node;
    }

    // $ANTLR start "assertionExpression"
    // /Users/luigi/Documents/workspace/Parsers/src/OPPLTestCaseTypes.g:216:1:
    // assertionExpression returns [AssertionExpression ae, OPPLSyntaxTree node]
    // : ( ^( COUNT VARIABLE_NAME ) | ^( COUNT STAR ) | ^( COUNT (bn=
    // bindingDescription )+ ) | INTEGER | ^( EXPRESSION ( . )* ) );
    public final OPPLTestCaseTypes.assertionExpression_return assertionExpression() {
        OPPLTestCaseTypes.assertionExpression_return retval = new OPPLTestCaseTypes.assertionExpression_return();
        retval.start = input.LT(1);
        OPPLSyntaxTree VARIABLE_NAME5 = null;
        OPPLSyntaxTree INTEGER6 = null;
        OPPLSyntaxTree EXPRESSION7 = null;
        OPPLTestCaseTypes.bindingDescription_return bn = null;
        BindingNode bindingNode = BindingNode.createNewEmptyBindingNode();
        boolean allFine = true;
        try {
            // /Users/luigi/Documents/workspace/Parsers/src/OPPLTestCaseTypes.g:224:2:
            // ( ^( COUNT VARIABLE_NAME ) | ^( COUNT STAR ) | ^( COUNT (bn=
            // bindingDescription )+ ) | INTEGER | ^( EXPRESSION ( . )* ) )
            int alt13 = 5;
            switch (input.LA(1)) {
                case COUNT: {
                    int LA13_1 = input.LA(2);
                    if (LA13_1 == DOWN) {
                        switch (input.LA(3)) {
                            case VARIABLE_NAME: {
                                alt13 = 1;
                            }
                                break;
                            case STAR: {
                                alt13 = 2;
                            }
                                break;
                            case BINDING: {
                                alt13 = 3;
                            }
                                break;
                            default:
                                if (state.backtracking > 0) {
                                    state.failed = true;
                                    return retval;
                                }
                                NoViableAltException nvae = new NoViableAltException("",
                                        13, 4, input);
                                throw nvae;
                        }
                    } else {
                        if (state.backtracking > 0) {
                            state.failed = true;
                            return retval;
                        }
                        NoViableAltException nvae = new NoViableAltException("", 13, 1,
                                input);
                        throw nvae;
                    }
                }
                    break;
                case INTEGER: {
                    alt13 = 4;
                }
                    break;
                case EXPRESSION: {
                    alt13 = 5;
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
                // /Users/luigi/Documents/workspace/Parsers/src/OPPLTestCaseTypes.g:225:3:
                // ^( COUNT VARIABLE_NAME )
                {
                    match(input, COUNT, FOLLOW_COUNT_in_assertionExpression452);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.DOWN, null);
                    if (state.failed) {
                        return retval;
                    }
                    VARIABLE_NAME5 = (OPPLSyntaxTree) match(input, VARIABLE_NAME,
                            FOLLOW_VARIABLE_NAME_in_assertionExpression454);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.UP, null);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 1) {
                        retval.ae = getSymbolTable().getCountAssertionExpression(
                                VARIABLE_NAME5, getConstraintSystem(), getHandler());
                    }
                }
                    break;
                case 2:
                // /Users/luigi/Documents/workspace/Parsers/src/OPPLTestCaseTypes.g:228:5:
                // ^( COUNT STAR )
                {
                    match(input, COUNT, FOLLOW_COUNT_in_assertionExpression463);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.DOWN, null);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, STAR, FOLLOW_STAR_in_assertionExpression465);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.UP, null);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 1) {
                        retval.ae = getSymbolTable().getCountStarAssertionExpression();
                    }
                }
                    break;
                case 3:
                // /Users/luigi/Documents/workspace/Parsers/src/OPPLTestCaseTypes.g:231:5:
                // ^( COUNT (bn= bindingDescription )+ )
                {
                    match(input, COUNT, FOLLOW_COUNT_in_assertionExpression474);
                    if (state.failed) {
                        return retval;
                    }
                    match(input, Token.DOWN, null);
                    if (state.failed) {
                        return retval;
                    }
                    // /Users/luigi/Documents/workspace/Parsers/src/OPPLTestCaseTypes.g:231:13:
                    // (bn= bindingDescription )+
                    int cnt11 = 0;
                    loop11: do {
                        int alt11 = 2;
                        int LA11_0 = input.LA(1);
                        if (LA11_0 == BINDING) {
                            alt11 = 1;
                        }
                        switch (alt11) {
                            case 1:
                            // /Users/luigi/Documents/workspace/Parsers/src/OPPLTestCaseTypes.g:231:14:
                            // bn= bindingDescription
                            {
                                pushFollow(FOLLOW_bindingDescription_in_assertionExpression481);
                                bn = bindingDescription();
                                state._fsp--;
                                if (state.failed) {
                                    return retval;
                                }
                                if (state.backtracking == 1) {
                                    if (bn.v != null && bn.exp != null) {
                                        bindingNode.addAssignment(new Assignment(bn.v,
                                                bn.exp));
                                    } else {
                                        allFine = false;
                                    }
                                }
                            }
                                break;
                            default:
                                if (cnt11 >= 1) {
                                    break loop11;
                                }
                                if (state.backtracking > 0) {
                                    state.failed = true;
                                    return retval;
                                }
                                EarlyExitException eee = new EarlyExitException(11, input);
                                throw eee;
                        }
                        cnt11++;
                    } while (true);
                    match(input, Token.UP, null);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 1) {
                        if (allFine) {
                            retval.ae = getSymbolTable().getBindingNodeCount(bindingNode,
                                    getConstraintSystem(), getTestCaseFactory());
                        }
                    }
                }
                    break;
                case 4:
                // /Users/luigi/Documents/workspace/Parsers/src/OPPLTestCaseTypes.g:242:5:
                // INTEGER
                {
                    INTEGER6 = (OPPLSyntaxTree) match(input, INTEGER,
                            FOLLOW_INTEGER_in_assertionExpression493);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 1) {
                        retval.ae = getSymbolTable().getIntegerAssertionExpression(
                                INTEGER6);
                    }
                }
                    break;
                case 5:
                // /Users/luigi/Documents/workspace/Parsers/src/OPPLTestCaseTypes.g:245:5:
                // ^( EXPRESSION ( . )* )
                {
                    EXPRESSION7 = (OPPLSyntaxTree) match(input, EXPRESSION,
                            FOLLOW_EXPRESSION_in_assertionExpression502);
                    if (state.failed) {
                        return retval;
                    }
                    if (input.LA(1) == Token.DOWN) {
                        match(input, Token.DOWN, null);
                        if (state.failed) {
                            return retval;
                        }
                        // /Users/luigi/Documents/workspace/Parsers/src/OPPLTestCaseTypes.g:245:18:
                        // ( . )*
                        loop12: do {
                            int alt12 = 2;
                            int LA12_0 = input.LA(1);
                            if (LA12_0 >= COMPOSITION && LA12_0 <= BINDING) {
                                alt12 = 1;
                            } else if (LA12_0 == UP) {
                                alt12 = 2;
                            }
                            switch (alt12) {
                                case 1:
                                // /Users/luigi/Documents/workspace/Parsers/src/OPPLTestCaseTypes.g:245:18:
                                // .
                                {
                                    matchAny(input);
                                    if (state.failed) {
                                        return retval;
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
                    }
                    if (state.backtracking == 1) {
                        retval.ae = getSymbolTable().getOWLExpressionAssertionExpression(
                                EXPRESSION7, getConstraintSystem(), getTestCaseFactory(),
                                getHandler());
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

    // $ANTLR end "assertionExpression"
    public static class bindingDescription_return extends TreeRuleReturnScope {
        public Variable<?> v;
        public OWLObject exp;
    }

    // $ANTLR start "bindingDescription"
    // /Users/luigi/Documents/workspace/Parsers/src/OPPLTestCaseTypes.g:250:1:
    // bindingDescription returns [Variable v, OWLObject exp] : ^( BINDING
    // VARIABLE_NAME ^( EXPRESSION ( . )* ) ) ;
    public final OPPLTestCaseTypes.bindingDescription_return bindingDescription() {
        OPPLTestCaseTypes.bindingDescription_return retval = new OPPLTestCaseTypes.bindingDescription_return();
        retval.start = input.LT(1);
        OPPLSyntaxTree VARIABLE_NAME8 = null;
        OPPLSyntaxTree EXPRESSION9 = null;
        try {
            // /Users/luigi/Documents/workspace/Parsers/src/OPPLTestCaseTypes.g:251:2:
            // ( ^( BINDING VARIABLE_NAME ^( EXPRESSION ( . )* ) ) )
            // /Users/luigi/Documents/workspace/Parsers/src/OPPLTestCaseTypes.g:252:3:
            // ^( BINDING VARIABLE_NAME ^( EXPRESSION ( . )* ) )
            {
                match(input, BINDING, FOLLOW_BINDING_in_bindingDescription526);
                if (state.failed) {
                    return retval;
                }
                match(input, Token.DOWN, null);
                if (state.failed) {
                    return retval;
                }
                VARIABLE_NAME8 = (OPPLSyntaxTree) match(input, VARIABLE_NAME,
                        FOLLOW_VARIABLE_NAME_in_bindingDescription528);
                if (state.failed) {
                    return retval;
                }
                EXPRESSION9 = (OPPLSyntaxTree) match(input, EXPRESSION,
                        FOLLOW_EXPRESSION_in_bindingDescription532);
                if (state.failed) {
                    return retval;
                }
                if (input.LA(1) == Token.DOWN) {
                    match(input, Token.DOWN, null);
                    if (state.failed) {
                        return retval;
                    }
                    // /Users/luigi/Documents/workspace/Parsers/src/OPPLTestCaseTypes.g:252:41:
                    // ( . )*
                    loop14: do {
                        int alt14 = 2;
                        int LA14_0 = input.LA(1);
                        if (LA14_0 >= COMPOSITION && LA14_0 <= BINDING) {
                            alt14 = 1;
                        } else if (LA14_0 == UP) {
                            alt14 = 2;
                        }
                        switch (alt14) {
                            case 1:
                            // /Users/luigi/Documents/workspace/Parsers/src/OPPLTestCaseTypes.g:252:41:
                            // .
                            {
                                matchAny(input);
                                if (state.failed) {
                                    return retval;
                                }
                            }
                                break;
                            default:
                                break loop14;
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
                    retval.v = getConstraintSystem()
                            .getVariable(VARIABLE_NAME8.getText());
                    if (retval.v == null) {
                        if (getErrorListener() != null) {
                            getErrorListener().illegalToken(VARIABLE_NAME8,
                                    "Undefined variable");
                        }
                    } else {
                        retval.exp = EXPRESSION9.getOWLObject();
                        if (retval.exp == null) {
                            if (getErrorListener() != null) {
                                getErrorListener().illegalToken(EXPRESSION9,
                                        "Null expression");
                            }
                        }
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

    // $ANTLR end "bindingDescription"
    // $ANTLR start "textVariableRef"
    // /Users/luigi/Documents/workspace/Parsers/src/OPPLTestCaseTypes.g:273:2:
    // textVariableRef : ^( TEXT VARIABLE_NAME ) ;
    public final void textVariableRef() {
        OPPLSyntaxTree VARIABLE_NAME10 = null;
        try {
            // /Users/luigi/Documents/workspace/Parsers/src/OPPLTestCaseTypes.g:274:3:
            // ( ^( TEXT VARIABLE_NAME ) )
            // /Users/luigi/Documents/workspace/Parsers/src/OPPLTestCaseTypes.g:275:4:
            // ^( TEXT VARIABLE_NAME )
            {
                match(input, TEXT, FOLLOW_TEXT_in_textVariableRef567);
                if (state.failed) {
                    return;
                }
                match(input, Token.DOWN, null);
                if (state.failed) {
                    return;
                }
                VARIABLE_NAME10 = (OPPLSyntaxTree) match(input, VARIABLE_NAME,
                        FOLLOW_VARIABLE_NAME_in_textVariableRef570);
                if (state.failed) {
                    return;
                }
                match(input, Token.UP, null);
                if (state.failed) {
                    return;
                }
                if (state.backtracking == 1) {
                    Variable<?> variable = getConstraintSystem().getVariable(
                            VARIABLE_NAME10.getText());
                    if (variable == null) {
                        if (getErrorListener() != null) {
                            getErrorListener().illegalToken(VARIABLE_NAME10,
                                    "Undefined variable");
                        }
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
        return;
    }

    // $ANTLR end "textVariableRef"
    // Delegated rules
    public static final BitSet FOLLOW_testCase_in_bottomup81 = new BitSet(
            new long[] { 0x0000000000000002L });
    public static final BitSet FOLLOW_textVariableRef_in_bottomup90 = new BitSet(
            new long[] { 0x0000000000000002L });
    public static final BitSet FOLLOW_OPPL_TEST_CASE_in_testCase108 = new BitSet(
            new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_IDENTIFIER_in_testCase110 = new BitSet(new long[] {
            0x0000000000000000L, 0x0000080000000000L, 0x0000000000000000L,
            0x0000000000000000L, 0x0000000000000000L, 0x0000000000000000L,
            0x0000000000000000L, 0x0000000000400000L });
    public static final BitSet FOLLOW_INFERENCE_in_testCase112 = new BitSet(new long[] {
            0x0000000000000000L, 0x0000080000000000L, 0x0000000000000000L,
            0x0000000000000000L, 0x0000000000000000L, 0x0000000000000000L,
            0x0000000000000000L, 0x0000000000400000L });
    public static final BitSet FOLLOW_statement_in_testCase119 = new BitSet(new long[] {
            0x0000000000000000L, 0x0000000000000000L, 0x0000000000000000L,
            0x0000000000000000L, 0x0000000000000000L, 0x0000000000000000L,
            0x0000000000000000L, 0x0000000008000000L });
    public static final BitSet FOLLOW_tests_in_testCase125 = new BitSet(
            new long[] { 0x0000000000000008L });
    public static final BitSet FOLLOW_test_in_tests165 = new BitSet(new long[] {
            0x0000000000000002L, 0x0000000000000000L, 0x0000000000000000L,
            0x0000000000000000L, 0x0000000000000000L, 0x0000000000000000L,
            0x0000000000000000L, 0x0000000008000000L });
    public static final BitSet FOLLOW_OPPL_STATEMENT_in_statement194 = new BitSet(
            new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_VARIABLE_DEFINITIONS_in_statement203 = new BitSet(
            new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_QUERY_in_statement215 = new BitSet(
            new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_TEST_in_test241 = new BitSet(
            new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_assertion_in_test247 = new BitSet(new long[] {
            0x0000000000000008L, 0x0000000000000000L, 0x0000000000000000L,
            0x0000000000000000L, 0x0000000000000000L, 0x0000000000000000L,
            0x0000000000000000L, 0x0000000004000000L });
    public static final BitSet FOLLOW_MESSAGE_in_test251 = new BitSet(
            new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_ASSERT_EQUAL_in_assertion285 = new BitSet(
            new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_assertionExpression_in_assertion289 = new BitSet(
            new long[] { 0x0000040000000000L, 0x0000000000000020L, 0x0000000000000000L,
                    0x0000000000000000L, 0x0000000000000000L, 0x0000000000000000L,
                    0x0000000000000000L, 0x0000000000100000L });
    public static final BitSet FOLLOW_assertionExpression_in_assertion294 = new BitSet(
            new long[] { 0x0000000000000008L });
    public static final BitSet FOLLOW_ASSERT_NOT_EQUAL_in_assertion303 = new BitSet(
            new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_assertionExpression_in_assertion307 = new BitSet(
            new long[] { 0x0000040000000000L, 0x0000000000000020L, 0x0000000000000000L,
                    0x0000000000000000L, 0x0000000000000000L, 0x0000000000000000L,
                    0x0000000000000000L, 0x0000000000100000L });
    public static final BitSet FOLLOW_assertionExpression_in_assertion312 = new BitSet(
            new long[] { 0x0000000000000008L });
    public static final BitSet FOLLOW_ASSERT_LESS_THAN_in_assertion321 = new BitSet(
            new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_assertionExpression_in_assertion325 = new BitSet(
            new long[] { 0x0000040000000000L, 0x0000000000000020L, 0x0000000000000000L,
                    0x0000000000000000L, 0x0000000000000000L, 0x0000000000000000L,
                    0x0000000000000000L, 0x0000000000100000L });
    public static final BitSet FOLLOW_assertionExpression_in_assertion330 = new BitSet(
            new long[] { 0x0000000000000008L });
    public static final BitSet FOLLOW_ASSERT_LESS_THAN_EQUAL_in_assertion339 = new BitSet(
            new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_assertionExpression_in_assertion343 = new BitSet(
            new long[] { 0x0000040000000000L, 0x0000000000000020L, 0x0000000000000000L,
                    0x0000000000000000L, 0x0000000000000000L, 0x0000000000000000L,
                    0x0000000000000000L, 0x0000000000100000L });
    public static final BitSet FOLLOW_assertionExpression_in_assertion348 = new BitSet(
            new long[] { 0x0000000000000008L });
    public static final BitSet FOLLOW_ASSERT_GREATER_THAN_in_assertion357 = new BitSet(
            new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_assertionExpression_in_assertion361 = new BitSet(
            new long[] { 0x0000040000000000L, 0x0000000000000020L, 0x0000000000000000L,
                    0x0000000000000000L, 0x0000000000000000L, 0x0000000000000000L,
                    0x0000000000000000L, 0x0000000000100000L });
    public static final BitSet FOLLOW_assertionExpression_in_assertion366 = new BitSet(
            new long[] { 0x0000000000000008L });
    public static final BitSet FOLLOW_ASSERT_GREATER_THAN_EQUAL_in_assertion375 = new BitSet(
            new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_assertionExpression_in_assertion379 = new BitSet(
            new long[] { 0x0000040000000000L, 0x0000000000000020L, 0x0000000000000000L,
                    0x0000000000000000L, 0x0000000000000000L, 0x0000000000000000L,
                    0x0000000000000000L, 0x0000000000100000L });
    public static final BitSet FOLLOW_assertionExpression_in_assertion384 = new BitSet(
            new long[] { 0x0000000000000008L });
    public static final BitSet FOLLOW_CONTAINS_in_assertion393 = new BitSet(
            new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_VARIABLE_NAME_in_assertion395 = new BitSet(
            new long[] { 0x0000040000000000L, 0x0000000000000020L, 0x0000000000000000L,
                    0x0000000000000000L, 0x0000000000000000L, 0x0000000000000000L,
                    0x0000000000000000L, 0x0000000000100000L });
    public static final BitSet FOLLOW_assertionExpression_in_assertion401 = new BitSet(
            new long[] { 0x0000040000000008L, 0x0000000000000020L, 0x0000000000000000L,
                    0x0000000000000000L, 0x0000000000000000L, 0x0000000000000000L,
                    0x0000000000000000L, 0x0000000000100000L });
    public static final BitSet FOLLOW_NOT_in_assertion414 = new BitSet(
            new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_assertion_in_assertion419 = new BitSet(
            new long[] { 0x0000000000000008L });
    public static final BitSet FOLLOW_COUNT_in_assertionExpression452 = new BitSet(
            new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_VARIABLE_NAME_in_assertionExpression454 = new BitSet(
            new long[] { 0x0000000000000008L });
    public static final BitSet FOLLOW_COUNT_in_assertionExpression463 = new BitSet(
            new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_STAR_in_assertionExpression465 = new BitSet(
            new long[] { 0x0000000000000008L });
    public static final BitSet FOLLOW_COUNT_in_assertionExpression474 = new BitSet(
            new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_bindingDescription_in_assertionExpression481 = new BitSet(
            new long[] { 0x0000000000000008L, 0x0000000000000000L, 0x0000000000000000L,
                    0x0000000000000000L, 0x0000000000000000L, 0x0000000000000000L,
                    0x0000000000000000L, 0x0000080000000000L });
    public static final BitSet FOLLOW_INTEGER_in_assertionExpression493 = new BitSet(
            new long[] { 0x0000000000000002L });
    public static final BitSet FOLLOW_EXPRESSION_in_assertionExpression502 = new BitSet(
            new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_BINDING_in_bindingDescription526 = new BitSet(
            new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_VARIABLE_NAME_in_bindingDescription528 = new BitSet(
            new long[] { 0x0000000000000000L, 0x0000000000000020L });
    public static final BitSet FOLLOW_EXPRESSION_in_bindingDescription532 = new BitSet(
            new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_TEXT_in_textVariableRef567 = new BitSet(
            new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_VARIABLE_NAME_in_textVariableRef570 = new BitSet(
            new long[] { 0x0000000000000008L });
}
