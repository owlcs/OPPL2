// $ANTLR 3.2 Sep 23, 2009 12:02:23 /Users/luigi/Documents/workspace/Parsers/src/OPPLTestCaseCombined.g 2010-12-02 17:35:11
package org.coode.parsers.oppl.testcase;

import org.antlr.runtime.BaseRecognizer;
import org.antlr.runtime.BitSet;
import org.antlr.runtime.DFA;
import org.antlr.runtime.EarlyExitException;
import org.antlr.runtime.IntStream;
import org.antlr.runtime.MismatchedTokenException;
import org.antlr.runtime.NoViableAltException;
import org.antlr.runtime.Parser;
import org.antlr.runtime.ParserRuleReturnScope;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.RecognizerSharedState;
import org.antlr.runtime.Token;
import org.antlr.runtime.TokenStream;
import org.antlr.runtime.tree.CommonTreeAdaptor;
import org.antlr.runtime.tree.RewriteEarlyExitException;
import org.antlr.runtime.tree.RewriteEmptyStreamException;
import org.antlr.runtime.tree.RewriteRuleSubtreeStream;
import org.antlr.runtime.tree.RewriteRuleTokenStream;
import org.antlr.runtime.tree.TreeAdaptor;
import org.coode.parsers.ErrorListener;
import org.coode.parsers.oppl.OPPLSyntaxTree;

public class OPPLTestCaseCombinedParser extends Parser {
	public static final String[] tokenNames = new String[] { "<invalid>", "<EOR>", "<DOWN>",
			"<UP>", "COMPOSITION", "OPEN_PARENTHESYS", "OPEN_CURLY_BRACES", "CLOSED_CURLY_BRACES",
			"CLOSED_PARENTHESYS", "WHITESPACE", "AND", "OR", "NOT", "SOME", "ONLY", "MIN", "MAX",
			"EXACTLY", "VALUE", "INVERSE", "SUBCLASS_OF", "SUB_PROPERTY_OF", "EQUIVALENT_TO",
			"SAME_AS", "DIFFERENT_FROM", "INVERSE_OF", "DISJOINT_WITH", "DOMAIN", "RANGE",
			"FUNCTIONAL", "SYMMETRIC", "ANTI_SYMMETRIC", "REFLEXIVE", "IRREFLEXIVE", "TRANSITIVE",
			"INVERSE_FUNCTIONAL", "POW", "COMMA", "INSTANCE_OF", "TYPES", "DBLQUOTE", "DIGIT",
			"INTEGER", "LETTER", "IDENTIFIER", "ENTITY_REFERENCE", "QUESTION_MARK", "Tokens",
			"SUB_CLASS_AXIOM", "EQUIVALENT_TO_AXIOM", "DISJOINT_WITH_AXIOM", "SUB_PROPERTY_AXIOM",
			"SAME_AS_AXIOM", "DIFFERENT_FROM_AXIOM", "UNARY_AXIOM", "DISJUNCTION", "CONJUNCTION",
			"PROPERTY_CHAIN", "NEGATED_EXPRESSION", "NEGATED_ASSERTION", "INVERSE_PROPERTY",
			"SOME_RESTRICTION", "ALL_RESTRICTION", "VALUE_RESTRICTION", "CARDINALITY_RESTRICTION",
			"ONE_OF", "TYPE_ASSERTION", "ROLE_ASSERTION", "INVERSE_OBJECT_PROPERTY_EXPRESSION",
			"EXPRESSION", "CONSTANT", "WHERE", "NOT_EQUAL", "EQUAL", "IN", "SELECT", "ASSERTED",
			"COLON", "DOT", "PLUS", "CREATE", "CREATE_INTERSECTION", "CREATE_DISJUNCTION", "BEGIN",
			"END", "OPEN_SQUARE_BRACKET", "CLOSED_SQUARE_BRACKET", "SUPER_CLASS_OF",
			"SUPER_PROPERTY_OF", "VARIABLE_TYPE", "ADD", "REMOVE", "ASSERTED_CLAUSE",
			"PLAIN_CLAUSE", "INEQUALITY_CONSTRAINT", "IN_SET_CONSTRAINT",
			"INPUT_VARIABLE_DEFINITION", "GENERATED_VARIABLE_DEFINITION", "CREATE_OPPL_FUNCTION",
			"VARIABLE_ATTRIBUTE", "OPPL_FUNCTION", "ACTIONS", "VARIABLE_DEFINITIONS", "QUERY",
			"VARIABLE_SCOPE", "SUBPROPERTY_OF", "VARIABLE_IDENTIFIER", "OPPL_STATEMENT", "HAS_KEY",
			"IRI", "ANNOTATION_ASSERTION", "IRI_ATTRIBUTE_NAME", "ESCLAMATION_MARK", "MATCH",
			"ATTRIBUTE_SELECTOR", "VALUES", "RENDERING", "GROUPS", "STRING_OPERATION",
			"VARIABLE_NAME", "REGEXP_CONSTRAINT", "FAIL", "NAF_CONSTRAINT", "COUNT", "SEMICOLON",
			"INFERENCE", "CONTAINS", "OPPL_TEST_CASE", "MESSAGE", "TEST", "ASSERT_EQUAL",
			"ASSERT_NOT_EQUAL", "ASSERT_TRUE", "ASSERT_FALSE", "TEXT", "ASSERT", "STAR",
			"LESS_THAN", "LESS_THAN_EQUAL", "GREATER_THAN", "GREATER_THAN_EQUAL",
			"ASSERT_LESS_THAN", "ASSERT_LESS_THAN_EQUAL", "ASSERT_GREATER_THAN",
			"ASSERT_GREATER_THAN_EQUAL", "BINDING", "DATA_RANGE", "594", "595", "596", "597",
			"598", "599", "600", "601", "602", "603", "604", "605", "606", "607", "608", "609",
			"610", "611", "612", "613", "614", "615", "616", "617", "618", "619" };
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
	public static final int RANGE = 28;
	public static final int DATA_RANGE = 593;
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
	public OPPLTestCaseCombined_OPPLParser_MOWLParser gMOWLParser;
	public OPPLTestCaseCombined_OPPLParser gOPPLParser;

	// delegators
	public OPPLTestCaseCombinedParser(TokenStream input) {
		this(input, new RecognizerSharedState());
	}

	public OPPLTestCaseCombinedParser(TokenStream input, RecognizerSharedState state) {
		super(input, state);
		this.gOPPLParser = new OPPLTestCaseCombined_OPPLParser(input, state, this);
		this.gMOWLParser = this.gOPPLParser.gMOWLParser;
	}

	protected TreeAdaptor adaptor = new CommonTreeAdaptor();

	public void setTreeAdaptor(TreeAdaptor adaptor) {
		this.adaptor = adaptor;
		this.gOPPLParser.setTreeAdaptor(this.adaptor);
	}

	public TreeAdaptor getTreeAdaptor() {
		return this.adaptor;
	}

	@Override
	public String[] getTokenNames() {
		return OPPLTestCaseCombinedParser.tokenNames;
	}

	@Override
	public String getGrammarFileName() {
		return "/Users/luigi/Documents/workspace/Parsers/src/OPPLTestCaseCombined.g";
	}

	private ErrorListener errorListener;

	public OPPLTestCaseCombinedParser(TokenStream input, ErrorListener errorListener) {
		this(input);
		if (errorListener == null) {
			throw new NullPointerException("The error listener cannot be null");
		}
		this.errorListener = errorListener;
	}

	public ErrorListener getErrorListener() {
		return this.errorListener;
	}

	@Override
	public void displayRecognitionError(String[] tokenNames, RecognitionException e) {
		this.getErrorListener().recognitionException(e, tokenNames);
	}

	protected void mismatch(IntStream input, int ttype, BitSet follow) throws RecognitionException {
		throw new MismatchedTokenException(ttype, input);
	}

	@Override
	public Object recoverFromMismatchedSet(IntStream input, RecognitionException e, BitSet follow)
			throws RecognitionException {
		throw e;
	}

	public static class testCase_return extends ParserRuleReturnScope {
		OPPLSyntaxTree tree;

		@Override
		public Object getTree() {
			return this.tree;
		}
	};

	// $ANTLR start "testCase"
	// /Users/luigi/Documents/workspace/Parsers/src/OPPLTestCaseCombined.g:82:1:
	// testCase : name= text SEMICOLON ( INFERENCE )? statement ( test )+ -> ^(
	// OPPL_TEST_CASE IDENTIFIER[$name.text] ( INFERENCE )? statement ( test )+
	// ) ;
	public final OPPLTestCaseCombinedParser.testCase_return testCase() throws RecognitionException {
		OPPLTestCaseCombinedParser.testCase_return retval = new OPPLTestCaseCombinedParser.testCase_return();
		retval.start = this.input.LT(1);
		OPPLSyntaxTree root_0 = null;
		Token SEMICOLON1 = null;
		Token INFERENCE2 = null;
		OPPLTestCaseCombinedParser.text_return name = null;
		OPPLTestCaseCombinedParser.statement_return statement3 = null;
		OPPLTestCaseCombinedParser.test_return test4 = null;
		OPPLSyntaxTree SEMICOLON1_tree = null;
		OPPLSyntaxTree INFERENCE2_tree = null;
		RewriteRuleTokenStream stream_SEMICOLON = new RewriteRuleTokenStream(this.adaptor,
				"token SEMICOLON");
		RewriteRuleTokenStream stream_INFERENCE = new RewriteRuleTokenStream(this.adaptor,
				"token INFERENCE");
		RewriteRuleSubtreeStream stream_text = new RewriteRuleSubtreeStream(this.adaptor,
				"rule text");
		RewriteRuleSubtreeStream stream_statement = new RewriteRuleSubtreeStream(this.adaptor,
				"rule statement");
		RewriteRuleSubtreeStream stream_test = new RewriteRuleSubtreeStream(this.adaptor,
				"rule test");
		try {
			// /Users/luigi/Documents/workspace/Parsers/src/OPPLTestCaseCombined.g:83:3:
			// (name= text SEMICOLON ( INFERENCE )? statement ( test )+ -> ^(
			// OPPL_TEST_CASE IDENTIFIER[$name.text] ( INFERENCE )? statement (
			// test )+ ) )
			// /Users/luigi/Documents/workspace/Parsers/src/OPPLTestCaseCombined.g:84:5:
			// name= text SEMICOLON ( INFERENCE )? statement ( test )+
			{
				this.pushFollow(FOLLOW_text_in_testCase169);
				name = this.text();
				this.state._fsp--;
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_text.add(name.getTree());
				}
				SEMICOLON1 = (Token) this.match(
						this.input,
						SEMICOLON,
						FOLLOW_SEMICOLON_in_testCase171);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_SEMICOLON.add(SEMICOLON1);
				}
				// /Users/luigi/Documents/workspace/Parsers/src/OPPLTestCaseCombined.g:84:27:
				// ( INFERENCE )?
				int alt1 = 2;
				int LA1_0 = this.input.LA(1);
				if (LA1_0 == INFERENCE) {
					alt1 = 1;
				}
				switch (alt1) {
				case 1:
					// /Users/luigi/Documents/workspace/Parsers/src/OPPLTestCaseCombined.g:84:27:
					// INFERENCE
				{
					INFERENCE2 = (Token) this.match(
							this.input,
							INFERENCE,
							FOLLOW_INFERENCE_in_testCase173);
					if (this.state.failed) {
						return retval;
					}
					if (this.state.backtracking == 0) {
						stream_INFERENCE.add(INFERENCE2);
					}
				}
					break;
				}
				this.pushFollow(FOLLOW_statement_in_testCase177);
				statement3 = this.statement();
				this.state._fsp--;
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_statement.add(statement3.getTree());
				}
				// /Users/luigi/Documents/workspace/Parsers/src/OPPLTestCaseCombined.g:84:50:
				// ( test )+
				int cnt2 = 0;
				loop2: do {
					int alt2 = 2;
					int LA2_0 = this.input.LA(1);
					if (LA2_0 == ASSERT) {
						alt2 = 1;
					}
					switch (alt2) {
					case 1:
						// /Users/luigi/Documents/workspace/Parsers/src/OPPLTestCaseCombined.g:84:50:
						// test
					{
						this.pushFollow(FOLLOW_test_in_testCase180);
						test4 = this.test();
						this.state._fsp--;
						if (this.state.failed) {
							return retval;
						}
						if (this.state.backtracking == 0) {
							stream_test.add(test4.getTree());
						}
					}
						break;
					default:
						if (cnt2 >= 1) {
							break loop2;
						}
						if (this.state.backtracking > 0) {
							this.state.failed = true;
							return retval;
						}
						EarlyExitException eee = new EarlyExitException(2, this.input);
						throw eee;
					}
					cnt2++;
				} while (true);
				// AST REWRITE
				// elements: INFERENCE, statement, test
				// token labels:
				// rule labels: retval
				// token list labels:
				// rule list labels:
				// wildcard labels:
				if (this.state.backtracking == 0) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(
							this.adaptor, "rule retval", retval != null ? retval.tree : null);
					root_0 = (OPPLSyntaxTree) this.adaptor.nil();
					// 84:55: -> ^( OPPL_TEST_CASE IDENTIFIER[$name.text] (
					// INFERENCE )? statement ( test )+ )
					{
						// /Users/luigi/Documents/workspace/Parsers/src/OPPLTestCaseCombined.g:84:57:
						// ^( OPPL_TEST_CASE IDENTIFIER[$name.text] ( INFERENCE
						// )? statement ( test )+ )
						{
							OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor.nil();
							root_1 = (OPPLSyntaxTree) this.adaptor.becomeRoot(
									this.adaptor.create(OPPL_TEST_CASE, "OPPL_TEST_CASE"),
									root_1);
							this.adaptor.addChild(root_1, this.adaptor.create(
									IDENTIFIER,
									(name != null ? this.input.toString(name.start, name.stop)
											: null)));
							// /Users/luigi/Documents/workspace/Parsers/src/OPPLTestCaseCombined.g:84:97:
							// ( INFERENCE )?
							if (stream_INFERENCE.hasNext()) {
								this.adaptor.addChild(root_1, stream_INFERENCE.nextNode());
							}
							stream_INFERENCE.reset();
							this.adaptor.addChild(root_1, stream_statement.nextTree());
							if (!stream_test.hasNext()) {
								throw new RewriteEarlyExitException();
							}
							while (stream_test.hasNext()) {
								this.adaptor.addChild(root_1, stream_test.nextTree());
							}
							stream_test.reset();
							this.adaptor.addChild(root_0, root_1);
						}
					}
					retval.tree = root_0;
				}
			}
			retval.stop = this.input.LT(-1);
			if (this.state.backtracking == 0) {
				retval.tree = (OPPLSyntaxTree) this.adaptor.rulePostProcessing(root_0);
				this.adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		} catch (RecognitionException exception) {
			if (this.errorListener != null) {
				this.errorListener.recognitionException(exception);
			}
		} catch (RewriteEmptyStreamException exception) {
			if (this.errorListener != null) {
				this.errorListener.rewriteEmptyStreamException(exception);
			}
		} finally {
		}
		return retval;
	}

	// $ANTLR end "testCase"
	public static class test_return extends ParserRuleReturnScope {
		OPPLSyntaxTree tree;

		@Override
		public Object getTree() {
			return this.tree;
		}
	};

	// $ANTLR start "test"
	// /Users/luigi/Documents/workspace/Parsers/src/OPPLTestCaseCombined.g:88:1:
	// test : ASSERT assertion ( SEMICOLON message= text )? -> ^( TEST assertion
	// ( ^( MESSAGE[$message.text] $message) )? ) ;
	public final OPPLTestCaseCombinedParser.test_return test() throws RecognitionException {
		OPPLTestCaseCombinedParser.test_return retval = new OPPLTestCaseCombinedParser.test_return();
		retval.start = this.input.LT(1);
		OPPLSyntaxTree root_0 = null;
		Token ASSERT5 = null;
		Token SEMICOLON7 = null;
		OPPLTestCaseCombinedParser.text_return message = null;
		OPPLTestCaseCombinedParser.assertion_return assertion6 = null;
		OPPLSyntaxTree ASSERT5_tree = null;
		OPPLSyntaxTree SEMICOLON7_tree = null;
		RewriteRuleTokenStream stream_ASSERT = new RewriteRuleTokenStream(this.adaptor,
				"token ASSERT");
		RewriteRuleTokenStream stream_SEMICOLON = new RewriteRuleTokenStream(this.adaptor,
				"token SEMICOLON");
		RewriteRuleSubtreeStream stream_text = new RewriteRuleSubtreeStream(this.adaptor,
				"rule text");
		RewriteRuleSubtreeStream stream_assertion = new RewriteRuleSubtreeStream(this.adaptor,
				"rule assertion");
		try {
			// /Users/luigi/Documents/workspace/Parsers/src/OPPLTestCaseCombined.g:89:2:
			// ( ASSERT assertion ( SEMICOLON message= text )? -> ^( TEST
			// assertion ( ^( MESSAGE[$message.text] $message) )? ) )
			// /Users/luigi/Documents/workspace/Parsers/src/OPPLTestCaseCombined.g:90:3:
			// ASSERT assertion ( SEMICOLON message= text )?
			{
				ASSERT5 = (Token) this.match(this.input, ASSERT, FOLLOW_ASSERT_in_test212);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_ASSERT.add(ASSERT5);
				}
				this.pushFollow(FOLLOW_assertion_in_test214);
				assertion6 = this.assertion();
				this.state._fsp--;
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_assertion.add(assertion6.getTree());
				}
				// /Users/luigi/Documents/workspace/Parsers/src/OPPLTestCaseCombined.g:90:20:
				// ( SEMICOLON message= text )?
				int alt3 = 2;
				int LA3_0 = this.input.LA(1);
				if (LA3_0 == SEMICOLON) {
					alt3 = 1;
				}
				switch (alt3) {
				case 1:
					// /Users/luigi/Documents/workspace/Parsers/src/OPPLTestCaseCombined.g:90:21:
					// SEMICOLON message= text
				{
					SEMICOLON7 = (Token) this.match(
							this.input,
							SEMICOLON,
							FOLLOW_SEMICOLON_in_test217);
					if (this.state.failed) {
						return retval;
					}
					if (this.state.backtracking == 0) {
						stream_SEMICOLON.add(SEMICOLON7);
					}
					this.pushFollow(FOLLOW_text_in_test222);
					message = this.text();
					this.state._fsp--;
					if (this.state.failed) {
						return retval;
					}
					if (this.state.backtracking == 0) {
						stream_text.add(message.getTree());
					}
				}
					break;
				}
				// AST REWRITE
				// elements: message, assertion
				// token labels:
				// rule labels: message, retval
				// token list labels:
				// rule list labels:
				// wildcard labels:
				if (this.state.backtracking == 0) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_message = new RewriteRuleSubtreeStream(
							this.adaptor, "rule message", message != null ? message.tree : null);
					RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(
							this.adaptor, "rule retval", retval != null ? retval.tree : null);
					root_0 = (OPPLSyntaxTree) this.adaptor.nil();
					// 90:47: -> ^( TEST assertion ( ^( MESSAGE[$message.text]
					// $message) )? )
					{
						// /Users/luigi/Documents/workspace/Parsers/src/OPPLTestCaseCombined.g:90:50:
						// ^( TEST assertion ( ^( MESSAGE[$message.text]
						// $message) )? )
						{
							OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor.nil();
							root_1 = (OPPLSyntaxTree) this.adaptor.becomeRoot(
									this.adaptor.create(TEST, "TEST"),
									root_1);
							this.adaptor.addChild(root_1, stream_assertion.nextTree());
							// /Users/luigi/Documents/workspace/Parsers/src/OPPLTestCaseCombined.g:90:67:
							// ( ^( MESSAGE[$message.text] $message) )?
							if (stream_message.hasNext()) {
								// /Users/luigi/Documents/workspace/Parsers/src/OPPLTestCaseCombined.g:90:67:
								// ^( MESSAGE[$message.text] $message)
								{
									OPPLSyntaxTree root_2 = (OPPLSyntaxTree) this.adaptor.nil();
									root_2 = (OPPLSyntaxTree) this.adaptor.becomeRoot(
											this.adaptor.create(
													MESSAGE,
													(message != null ? this.input.toString(
															message.start,
															message.stop) : null)),
											root_2);
									this.adaptor.addChild(root_2, stream_message.nextTree());
									this.adaptor.addChild(root_1, root_2);
								}
							}
							stream_message.reset();
							this.adaptor.addChild(root_0, root_1);
						}
					}
					retval.tree = root_0;
				}
			}
			retval.stop = this.input.LT(-1);
			if (this.state.backtracking == 0) {
				retval.tree = (OPPLSyntaxTree) this.adaptor.rulePostProcessing(root_0);
				this.adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		} catch (RecognitionException exception) {
			if (this.errorListener != null) {
				this.errorListener.recognitionException(exception);
			}
		} catch (RewriteEmptyStreamException exception) {
			if (this.errorListener != null) {
				this.errorListener.rewriteEmptyStreamException(exception);
			}
		} finally {
		}
		return retval;
	}

	// $ANTLR end "test"
	public static class assertion_return extends ParserRuleReturnScope {
		OPPLSyntaxTree tree;

		@Override
		public Object getTree() {
			return this.tree;
		}
	};

	// $ANTLR start "assertion"
	// /Users/luigi/Documents/workspace/Parsers/src/OPPLTestCaseCombined.g:94:1:
	// assertion options {backtrack=true; } : (left= assertionExpression EQUAL
	// right= assertionExpression -> ^( ASSERT_EQUAL $left $right) | left=
	// assertionExpression NOT_EQUAL right= assertionExpression -> ^(
	// ASSERT_NOT_EQUAL $left $right) | left= assertionExpression LESS_THAN
	// right= assertionExpression -> ^( ASSERT_LESS_THAN $left $right) | left=
	// assertionExpression LESS_THAN_EQUAL right= assertionExpression -> ^(
	// ASSERT_LESS_THAN_EQUAL $left $right) | left= assertionExpression
	// GREATER_THAN right= assertionExpression -> ^( ASSERT_GREATER_THAN $left
	// $right) | left= assertionExpression GREATER_THAN_EQUAL right=
	// assertionExpression -> ^( ASSERT_GREATER_THAN_EQUAL $left $right) |
	// VARIABLE_NAME CONTAINS assertionExpression ( COMMA assertionExpression )*
	// -> ^( CONTAINS VARIABLE_NAME ( assertionExpression )+ ) | NOT
	// OPEN_PARENTHESYS assertion CLOSED_PARENTHESYS -> ^( NOT assertion ) );
	public final OPPLTestCaseCombinedParser.assertion_return assertion()
			throws RecognitionException {
		OPPLTestCaseCombinedParser.assertion_return retval = new OPPLTestCaseCombinedParser.assertion_return();
		retval.start = this.input.LT(1);
		OPPLSyntaxTree root_0 = null;
		Token EQUAL8 = null;
		Token NOT_EQUAL9 = null;
		Token LESS_THAN10 = null;
		Token LESS_THAN_EQUAL11 = null;
		Token GREATER_THAN12 = null;
		Token GREATER_THAN_EQUAL13 = null;
		Token VARIABLE_NAME14 = null;
		Token CONTAINS15 = null;
		Token COMMA17 = null;
		Token NOT19 = null;
		Token OPEN_PARENTHESYS20 = null;
		Token CLOSED_PARENTHESYS22 = null;
		OPPLTestCaseCombinedParser.assertionExpression_return left = null;
		OPPLTestCaseCombinedParser.assertionExpression_return right = null;
		OPPLTestCaseCombinedParser.assertionExpression_return assertionExpression16 = null;
		OPPLTestCaseCombinedParser.assertionExpression_return assertionExpression18 = null;
		OPPLTestCaseCombinedParser.assertion_return assertion21 = null;
		OPPLSyntaxTree EQUAL8_tree = null;
		OPPLSyntaxTree NOT_EQUAL9_tree = null;
		OPPLSyntaxTree LESS_THAN10_tree = null;
		OPPLSyntaxTree LESS_THAN_EQUAL11_tree = null;
		OPPLSyntaxTree GREATER_THAN12_tree = null;
		OPPLSyntaxTree GREATER_THAN_EQUAL13_tree = null;
		OPPLSyntaxTree VARIABLE_NAME14_tree = null;
		OPPLSyntaxTree CONTAINS15_tree = null;
		OPPLSyntaxTree COMMA17_tree = null;
		OPPLSyntaxTree NOT19_tree = null;
		OPPLSyntaxTree OPEN_PARENTHESYS20_tree = null;
		OPPLSyntaxTree CLOSED_PARENTHESYS22_tree = null;
		RewriteRuleTokenStream stream_COMMA = new RewriteRuleTokenStream(this.adaptor,
				"token COMMA");
		RewriteRuleTokenStream stream_NOT_EQUAL = new RewriteRuleTokenStream(this.adaptor,
				"token NOT_EQUAL");
		RewriteRuleTokenStream stream_CONTAINS = new RewriteRuleTokenStream(this.adaptor,
				"token CONTAINS");
		RewriteRuleTokenStream stream_GREATER_THAN = new RewriteRuleTokenStream(this.adaptor,
				"token GREATER_THAN");
		RewriteRuleTokenStream stream_EQUAL = new RewriteRuleTokenStream(this.adaptor,
				"token EQUAL");
		RewriteRuleTokenStream stream_LESS_THAN_EQUAL = new RewriteRuleTokenStream(this.adaptor,
				"token LESS_THAN_EQUAL");
		RewriteRuleTokenStream stream_NOT = new RewriteRuleTokenStream(this.adaptor, "token NOT");
		RewriteRuleTokenStream stream_CLOSED_PARENTHESYS = new RewriteRuleTokenStream(this.adaptor,
				"token CLOSED_PARENTHESYS");
		RewriteRuleTokenStream stream_OPEN_PARENTHESYS = new RewriteRuleTokenStream(this.adaptor,
				"token OPEN_PARENTHESYS");
		RewriteRuleTokenStream stream_GREATER_THAN_EQUAL = new RewriteRuleTokenStream(this.adaptor,
				"token GREATER_THAN_EQUAL");
		RewriteRuleTokenStream stream_VARIABLE_NAME = new RewriteRuleTokenStream(this.adaptor,
				"token VARIABLE_NAME");
		RewriteRuleTokenStream stream_LESS_THAN = new RewriteRuleTokenStream(this.adaptor,
				"token LESS_THAN");
		RewriteRuleSubtreeStream stream_assertionExpression = new RewriteRuleSubtreeStream(
				this.adaptor, "rule assertionExpression");
		RewriteRuleSubtreeStream stream_assertion = new RewriteRuleSubtreeStream(this.adaptor,
				"rule assertion");
		try {
			// /Users/luigi/Documents/workspace/Parsers/src/OPPLTestCaseCombined.g:95:2:
			// (left= assertionExpression EQUAL right= assertionExpression -> ^(
			// ASSERT_EQUAL $left $right) | left= assertionExpression NOT_EQUAL
			// right= assertionExpression -> ^( ASSERT_NOT_EQUAL $left $right) |
			// left= assertionExpression LESS_THAN right= assertionExpression ->
			// ^( ASSERT_LESS_THAN $left $right) | left= assertionExpression
			// LESS_THAN_EQUAL right= assertionExpression -> ^(
			// ASSERT_LESS_THAN_EQUAL $left $right) | left= assertionExpression
			// GREATER_THAN right= assertionExpression -> ^( ASSERT_GREATER_THAN
			// $left $right) | left= assertionExpression GREATER_THAN_EQUAL
			// right= assertionExpression -> ^( ASSERT_GREATER_THAN_EQUAL $left
			// $right) | VARIABLE_NAME CONTAINS assertionExpression ( COMMA
			// assertionExpression )* -> ^( CONTAINS VARIABLE_NAME (
			// assertionExpression )+ ) | NOT OPEN_PARENTHESYS assertion
			// CLOSED_PARENTHESYS -> ^( NOT assertion ) )
			int alt5 = 8;
			alt5 = this.dfa5.predict(this.input);
			switch (alt5) {
			case 1:
				// /Users/luigi/Documents/workspace/Parsers/src/OPPLTestCaseCombined.g:96:3:
				// left= assertionExpression EQUAL right= assertionExpression
			{
				this.pushFollow(FOLLOW_assertionExpression_in_assertion269);
				left = this.assertionExpression();
				this.state._fsp--;
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_assertionExpression.add(left.getTree());
				}
				EQUAL8 = (Token) this.match(this.input, EQUAL, FOLLOW_EQUAL_in_assertion271);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_EQUAL.add(EQUAL8);
				}
				this.pushFollow(FOLLOW_assertionExpression_in_assertion276);
				right = this.assertionExpression();
				this.state._fsp--;
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_assertionExpression.add(right.getTree());
				}
				// AST REWRITE
				// elements: right, left
				// token labels:
				// rule labels: right, left, retval
				// token list labels:
				// rule list labels:
				// wildcard labels:
				if (this.state.backtracking == 0) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_right = new RewriteRuleSubtreeStream(
							this.adaptor, "rule right", right != null ? right.tree : null);
					RewriteRuleSubtreeStream stream_left = new RewriteRuleSubtreeStream(
							this.adaptor, "rule left", left != null ? left.tree : null);
					RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(
							this.adaptor, "rule retval", retval != null ? retval.tree : null);
					root_0 = (OPPLSyntaxTree) this.adaptor.nil();
					// 96:62: -> ^( ASSERT_EQUAL $left $right)
					{
						// /Users/luigi/Documents/workspace/Parsers/src/OPPLTestCaseCombined.g:96:65:
						// ^( ASSERT_EQUAL $left $right)
						{
							OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor.nil();
							root_1 = (OPPLSyntaxTree) this.adaptor.becomeRoot(
									this.adaptor.create(ASSERT_EQUAL, "ASSERT_EQUAL"),
									root_1);
							this.adaptor.addChild(root_1, stream_left.nextTree());
							this.adaptor.addChild(root_1, stream_right.nextTree());
							this.adaptor.addChild(root_0, root_1);
						}
					}
					retval.tree = root_0;
				}
			}
				break;
			case 2:
				// /Users/luigi/Documents/workspace/Parsers/src/OPPLTestCaseCombined.g:97:5:
				// left= assertionExpression NOT_EQUAL right=
				// assertionExpression
			{
				this.pushFollow(FOLLOW_assertionExpression_in_assertion297);
				left = this.assertionExpression();
				this.state._fsp--;
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_assertionExpression.add(left.getTree());
				}
				NOT_EQUAL9 = (Token) this.match(
						this.input,
						NOT_EQUAL,
						FOLLOW_NOT_EQUAL_in_assertion299);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_NOT_EQUAL.add(NOT_EQUAL9);
				}
				this.pushFollow(FOLLOW_assertionExpression_in_assertion304);
				right = this.assertionExpression();
				this.state._fsp--;
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_assertionExpression.add(right.getTree());
				}
				// AST REWRITE
				// elements: right, left
				// token labels:
				// rule labels: right, left, retval
				// token list labels:
				// rule list labels:
				// wildcard labels:
				if (this.state.backtracking == 0) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_right = new RewriteRuleSubtreeStream(
							this.adaptor, "rule right", right != null ? right.tree : null);
					RewriteRuleSubtreeStream stream_left = new RewriteRuleSubtreeStream(
							this.adaptor, "rule left", left != null ? left.tree : null);
					RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(
							this.adaptor, "rule retval", retval != null ? retval.tree : null);
					root_0 = (OPPLSyntaxTree) this.adaptor.nil();
					// 97:68: -> ^( ASSERT_NOT_EQUAL $left $right)
					{
						// /Users/luigi/Documents/workspace/Parsers/src/OPPLTestCaseCombined.g:97:71:
						// ^( ASSERT_NOT_EQUAL $left $right)
						{
							OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor.nil();
							root_1 = (OPPLSyntaxTree) this.adaptor.becomeRoot(
									this.adaptor.create(ASSERT_NOT_EQUAL, "ASSERT_NOT_EQUAL"),
									root_1);
							this.adaptor.addChild(root_1, stream_left.nextTree());
							this.adaptor.addChild(root_1, stream_right.nextTree());
							this.adaptor.addChild(root_0, root_1);
						}
					}
					retval.tree = root_0;
				}
			}
				break;
			case 3:
				// /Users/luigi/Documents/workspace/Parsers/src/OPPLTestCaseCombined.g:98:5:
				// left= assertionExpression LESS_THAN right=
				// assertionExpression
			{
				this.pushFollow(FOLLOW_assertionExpression_in_assertion325);
				left = this.assertionExpression();
				this.state._fsp--;
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_assertionExpression.add(left.getTree());
				}
				LESS_THAN10 = (Token) this.match(
						this.input,
						LESS_THAN,
						FOLLOW_LESS_THAN_in_assertion327);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_LESS_THAN.add(LESS_THAN10);
				}
				this.pushFollow(FOLLOW_assertionExpression_in_assertion332);
				right = this.assertionExpression();
				this.state._fsp--;
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_assertionExpression.add(right.getTree());
				}
				// AST REWRITE
				// elements: left, right
				// token labels:
				// rule labels: right, left, retval
				// token list labels:
				// rule list labels:
				// wildcard labels:
				if (this.state.backtracking == 0) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_right = new RewriteRuleSubtreeStream(
							this.adaptor, "rule right", right != null ? right.tree : null);
					RewriteRuleSubtreeStream stream_left = new RewriteRuleSubtreeStream(
							this.adaptor, "rule left", left != null ? left.tree : null);
					RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(
							this.adaptor, "rule retval", retval != null ? retval.tree : null);
					root_0 = (OPPLSyntaxTree) this.adaptor.nil();
					// 98:68: -> ^( ASSERT_LESS_THAN $left $right)
					{
						// /Users/luigi/Documents/workspace/Parsers/src/OPPLTestCaseCombined.g:98:71:
						// ^( ASSERT_LESS_THAN $left $right)
						{
							OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor.nil();
							root_1 = (OPPLSyntaxTree) this.adaptor.becomeRoot(
									this.adaptor.create(ASSERT_LESS_THAN, "ASSERT_LESS_THAN"),
									root_1);
							this.adaptor.addChild(root_1, stream_left.nextTree());
							this.adaptor.addChild(root_1, stream_right.nextTree());
							this.adaptor.addChild(root_0, root_1);
						}
					}
					retval.tree = root_0;
				}
			}
				break;
			case 4:
				// /Users/luigi/Documents/workspace/Parsers/src/OPPLTestCaseCombined.g:99:5:
				// left= assertionExpression LESS_THAN_EQUAL right=
				// assertionExpression
			{
				this.pushFollow(FOLLOW_assertionExpression_in_assertion353);
				left = this.assertionExpression();
				this.state._fsp--;
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_assertionExpression.add(left.getTree());
				}
				LESS_THAN_EQUAL11 = (Token) this.match(
						this.input,
						LESS_THAN_EQUAL,
						FOLLOW_LESS_THAN_EQUAL_in_assertion355);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_LESS_THAN_EQUAL.add(LESS_THAN_EQUAL11);
				}
				this.pushFollow(FOLLOW_assertionExpression_in_assertion360);
				right = this.assertionExpression();
				this.state._fsp--;
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_assertionExpression.add(right.getTree());
				}
				// AST REWRITE
				// elements: right, left
				// token labels:
				// rule labels: right, left, retval
				// token list labels:
				// rule list labels:
				// wildcard labels:
				if (this.state.backtracking == 0) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_right = new RewriteRuleSubtreeStream(
							this.adaptor, "rule right", right != null ? right.tree : null);
					RewriteRuleSubtreeStream stream_left = new RewriteRuleSubtreeStream(
							this.adaptor, "rule left", left != null ? left.tree : null);
					RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(
							this.adaptor, "rule retval", retval != null ? retval.tree : null);
					root_0 = (OPPLSyntaxTree) this.adaptor.nil();
					// 99:74: -> ^( ASSERT_LESS_THAN_EQUAL $left $right)
					{
						// /Users/luigi/Documents/workspace/Parsers/src/OPPLTestCaseCombined.g:99:77:
						// ^( ASSERT_LESS_THAN_EQUAL $left $right)
						{
							OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor.nil();
							root_1 = (OPPLSyntaxTree) this.adaptor.becomeRoot(this.adaptor.create(
									ASSERT_LESS_THAN_EQUAL,
									"ASSERT_LESS_THAN_EQUAL"), root_1);
							this.adaptor.addChild(root_1, stream_left.nextTree());
							this.adaptor.addChild(root_1, stream_right.nextTree());
							this.adaptor.addChild(root_0, root_1);
						}
					}
					retval.tree = root_0;
				}
			}
				break;
			case 5:
				// /Users/luigi/Documents/workspace/Parsers/src/OPPLTestCaseCombined.g:100:5:
				// left= assertionExpression GREATER_THAN right=
				// assertionExpression
			{
				this.pushFollow(FOLLOW_assertionExpression_in_assertion383);
				left = this.assertionExpression();
				this.state._fsp--;
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_assertionExpression.add(left.getTree());
				}
				GREATER_THAN12 = (Token) this.match(
						this.input,
						GREATER_THAN,
						FOLLOW_GREATER_THAN_in_assertion385);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_GREATER_THAN.add(GREATER_THAN12);
				}
				this.pushFollow(FOLLOW_assertionExpression_in_assertion390);
				right = this.assertionExpression();
				this.state._fsp--;
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_assertionExpression.add(right.getTree());
				}
				// AST REWRITE
				// elements: right, left
				// token labels:
				// rule labels: right, left, retval
				// token list labels:
				// rule list labels:
				// wildcard labels:
				if (this.state.backtracking == 0) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_right = new RewriteRuleSubtreeStream(
							this.adaptor, "rule right", right != null ? right.tree : null);
					RewriteRuleSubtreeStream stream_left = new RewriteRuleSubtreeStream(
							this.adaptor, "rule left", left != null ? left.tree : null);
					RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(
							this.adaptor, "rule retval", retval != null ? retval.tree : null);
					root_0 = (OPPLSyntaxTree) this.adaptor.nil();
					// 100:71: -> ^( ASSERT_GREATER_THAN $left $right)
					{
						// /Users/luigi/Documents/workspace/Parsers/src/OPPLTestCaseCombined.g:100:74:
						// ^( ASSERT_GREATER_THAN $left $right)
						{
							OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor.nil();
							root_1 = (OPPLSyntaxTree) this.adaptor.becomeRoot(
									this.adaptor.create(ASSERT_GREATER_THAN, "ASSERT_GREATER_THAN"),
									root_1);
							this.adaptor.addChild(root_1, stream_left.nextTree());
							this.adaptor.addChild(root_1, stream_right.nextTree());
							this.adaptor.addChild(root_0, root_1);
						}
					}
					retval.tree = root_0;
				}
			}
				break;
			case 6:
				// /Users/luigi/Documents/workspace/Parsers/src/OPPLTestCaseCombined.g:101:5:
				// left= assertionExpression GREATER_THAN_EQUAL right=
				// assertionExpression
			{
				this.pushFollow(FOLLOW_assertionExpression_in_assertion413);
				left = this.assertionExpression();
				this.state._fsp--;
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_assertionExpression.add(left.getTree());
				}
				GREATER_THAN_EQUAL13 = (Token) this.match(
						this.input,
						GREATER_THAN_EQUAL,
						FOLLOW_GREATER_THAN_EQUAL_in_assertion415);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_GREATER_THAN_EQUAL.add(GREATER_THAN_EQUAL13);
				}
				this.pushFollow(FOLLOW_assertionExpression_in_assertion420);
				right = this.assertionExpression();
				this.state._fsp--;
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_assertionExpression.add(right.getTree());
				}
				// AST REWRITE
				// elements: left, right
				// token labels:
				// rule labels: right, left, retval
				// token list labels:
				// rule list labels:
				// wildcard labels:
				if (this.state.backtracking == 0) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_right = new RewriteRuleSubtreeStream(
							this.adaptor, "rule right", right != null ? right.tree : null);
					RewriteRuleSubtreeStream stream_left = new RewriteRuleSubtreeStream(
							this.adaptor, "rule left", left != null ? left.tree : null);
					RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(
							this.adaptor, "rule retval", retval != null ? retval.tree : null);
					root_0 = (OPPLSyntaxTree) this.adaptor.nil();
					// 101:77: -> ^( ASSERT_GREATER_THAN_EQUAL $left $right)
					{
						// /Users/luigi/Documents/workspace/Parsers/src/OPPLTestCaseCombined.g:101:80:
						// ^( ASSERT_GREATER_THAN_EQUAL $left $right)
						{
							OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor.nil();
							root_1 = (OPPLSyntaxTree) this.adaptor.becomeRoot(this.adaptor.create(
									ASSERT_GREATER_THAN_EQUAL,
									"ASSERT_GREATER_THAN_EQUAL"), root_1);
							this.adaptor.addChild(root_1, stream_left.nextTree());
							this.adaptor.addChild(root_1, stream_right.nextTree());
							this.adaptor.addChild(root_0, root_1);
						}
					}
					retval.tree = root_0;
				}
			}
				break;
			case 7:
				// /Users/luigi/Documents/workspace/Parsers/src/OPPLTestCaseCombined.g:102:5:
				// VARIABLE_NAME CONTAINS assertionExpression ( COMMA
				// assertionExpression )*
			{
				VARIABLE_NAME14 = (Token) this.match(
						this.input,
						VARIABLE_NAME,
						FOLLOW_VARIABLE_NAME_in_assertion440);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_VARIABLE_NAME.add(VARIABLE_NAME14);
				}
				CONTAINS15 = (Token) this.match(
						this.input,
						CONTAINS,
						FOLLOW_CONTAINS_in_assertion443);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_CONTAINS.add(CONTAINS15);
				}
				this.pushFollow(FOLLOW_assertionExpression_in_assertion445);
				assertionExpression16 = this.assertionExpression();
				this.state._fsp--;
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_assertionExpression.add(assertionExpression16.getTree());
				}
				// /Users/luigi/Documents/workspace/Parsers/src/OPPLTestCaseCombined.g:102:49:
				// ( COMMA assertionExpression )*
				loop4: do {
					int alt4 = 2;
					int LA4_0 = this.input.LA(1);
					if (LA4_0 == COMMA) {
						alt4 = 1;
					}
					switch (alt4) {
					case 1:
						// /Users/luigi/Documents/workspace/Parsers/src/OPPLTestCaseCombined.g:102:50:
						// COMMA assertionExpression
					{
						COMMA17 = (Token) this.match(
								this.input,
								COMMA,
								FOLLOW_COMMA_in_assertion448);
						if (this.state.failed) {
							return retval;
						}
						if (this.state.backtracking == 0) {
							stream_COMMA.add(COMMA17);
						}
						this.pushFollow(FOLLOW_assertionExpression_in_assertion450);
						assertionExpression18 = this.assertionExpression();
						this.state._fsp--;
						if (this.state.failed) {
							return retval;
						}
						if (this.state.backtracking == 0) {
							stream_assertionExpression.add(assertionExpression18.getTree());
						}
					}
						break;
					default:
						break loop4;
					}
				} while (true);
				// AST REWRITE
				// elements: assertionExpression, VARIABLE_NAME, CONTAINS
				// token labels:
				// rule labels: retval
				// token list labels:
				// rule list labels:
				// wildcard labels:
				if (this.state.backtracking == 0) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(
							this.adaptor, "rule retval", retval != null ? retval.tree : null);
					root_0 = (OPPLSyntaxTree) this.adaptor.nil();
					// 102:78: -> ^( CONTAINS VARIABLE_NAME (
					// assertionExpression )+ )
					{
						// /Users/luigi/Documents/workspace/Parsers/src/OPPLTestCaseCombined.g:102:80:
						// ^( CONTAINS VARIABLE_NAME ( assertionExpression )+ )
						{
							OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor.nil();
							root_1 = (OPPLSyntaxTree) this.adaptor.becomeRoot(
									stream_CONTAINS.nextNode(),
									root_1);
							this.adaptor.addChild(root_1, stream_VARIABLE_NAME.nextNode());
							if (!stream_assertionExpression.hasNext()) {
								throw new RewriteEarlyExitException();
							}
							while (stream_assertionExpression.hasNext()) {
								this.adaptor.addChild(root_1, stream_assertionExpression.nextTree());
							}
							stream_assertionExpression.reset();
							this.adaptor.addChild(root_0, root_1);
						}
					}
					retval.tree = root_0;
				}
			}
				break;
			case 8:
				// /Users/luigi/Documents/workspace/Parsers/src/OPPLTestCaseCombined.g:103:5:
				// NOT OPEN_PARENTHESYS assertion CLOSED_PARENTHESYS
			{
				NOT19 = (Token) this.match(this.input, NOT, FOLLOW_NOT_in_assertion469);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_NOT.add(NOT19);
				}
				OPEN_PARENTHESYS20 = (Token) this.match(
						this.input,
						OPEN_PARENTHESYS,
						FOLLOW_OPEN_PARENTHESYS_in_assertion471);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_OPEN_PARENTHESYS.add(OPEN_PARENTHESYS20);
				}
				this.pushFollow(FOLLOW_assertion_in_assertion473);
				assertion21 = this.assertion();
				this.state._fsp--;
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_assertion.add(assertion21.getTree());
				}
				CLOSED_PARENTHESYS22 = (Token) this.match(
						this.input,
						CLOSED_PARENTHESYS,
						FOLLOW_CLOSED_PARENTHESYS_in_assertion475);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_CLOSED_PARENTHESYS.add(CLOSED_PARENTHESYS22);
				}
				// AST REWRITE
				// elements: assertion, NOT
				// token labels:
				// rule labels: retval
				// token list labels:
				// rule list labels:
				// wildcard labels:
				if (this.state.backtracking == 0) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(
							this.adaptor, "rule retval", retval != null ? retval.tree : null);
					root_0 = (OPPLSyntaxTree) this.adaptor.nil();
					// 103:55: -> ^( NOT assertion )
					{
						// /Users/luigi/Documents/workspace/Parsers/src/OPPLTestCaseCombined.g:103:57:
						// ^( NOT assertion )
						{
							OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor.nil();
							root_1 = (OPPLSyntaxTree) this.adaptor.becomeRoot(
									stream_NOT.nextNode(),
									root_1);
							this.adaptor.addChild(root_1, stream_assertion.nextTree());
							this.adaptor.addChild(root_0, root_1);
						}
					}
					retval.tree = root_0;
				}
			}
				break;
			}
			retval.stop = this.input.LT(-1);
			if (this.state.backtracking == 0) {
				retval.tree = (OPPLSyntaxTree) this.adaptor.rulePostProcessing(root_0);
				this.adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		} catch (RecognitionException exception) {
			if (this.errorListener != null) {
				this.errorListener.recognitionException(exception);
			}
		} catch (RewriteEmptyStreamException exception) {
			if (this.errorListener != null) {
				this.errorListener.rewriteEmptyStreamException(exception);
			}
		} finally {
		}
		return retval;
	}

	// $ANTLR end "assertion"
	public static class assertionExpression_return extends ParserRuleReturnScope {
		OPPLSyntaxTree tree;

		@Override
		public Object getTree() {
			return this.tree;
		}
	};

	// $ANTLR start "assertionExpression"
	// /Users/luigi/Documents/workspace/Parsers/src/OPPLTestCaseCombined.g:106:1:
	// assertionExpression : ( COUNT OPEN_PARENTHESYS bindingDescription ( COMMA
	// bindingDescription )* CLOSED_PARENTHESYS -> ^( COUNT ( bindingDescription
	// )+ ) | COUNT OPEN_PARENTHESYS VARIABLE_NAME CLOSED_PARENTHESYS -> ^(
	// COUNT VARIABLE_NAME ) | COUNT OPEN_PARENTHESYS STAR CLOSED_PARENTHESYS ->
	// ^( COUNT STAR ) | INTEGER | expression -> ^( EXPRESSION expression ) );
	public final OPPLTestCaseCombinedParser.assertionExpression_return assertionExpression()
			throws RecognitionException {
		OPPLTestCaseCombinedParser.assertionExpression_return retval = new OPPLTestCaseCombinedParser.assertionExpression_return();
		retval.start = this.input.LT(1);
		OPPLSyntaxTree root_0 = null;
		Token COUNT23 = null;
		Token OPEN_PARENTHESYS24 = null;
		Token COMMA26 = null;
		Token CLOSED_PARENTHESYS28 = null;
		Token COUNT29 = null;
		Token OPEN_PARENTHESYS30 = null;
		Token VARIABLE_NAME31 = null;
		Token CLOSED_PARENTHESYS32 = null;
		Token COUNT33 = null;
		Token OPEN_PARENTHESYS34 = null;
		Token STAR35 = null;
		Token CLOSED_PARENTHESYS36 = null;
		Token INTEGER37 = null;
		OPPLTestCaseCombinedParser.bindingDescription_return bindingDescription25 = null;
		OPPLTestCaseCombinedParser.bindingDescription_return bindingDescription27 = null;
		OPPLTestCaseCombined_OPPLParser_MOWLParser.expression_return expression38 = null;
		OPPLSyntaxTree COUNT23_tree = null;
		OPPLSyntaxTree OPEN_PARENTHESYS24_tree = null;
		OPPLSyntaxTree COMMA26_tree = null;
		OPPLSyntaxTree CLOSED_PARENTHESYS28_tree = null;
		OPPLSyntaxTree COUNT29_tree = null;
		OPPLSyntaxTree OPEN_PARENTHESYS30_tree = null;
		OPPLSyntaxTree VARIABLE_NAME31_tree = null;
		OPPLSyntaxTree CLOSED_PARENTHESYS32_tree = null;
		OPPLSyntaxTree COUNT33_tree = null;
		OPPLSyntaxTree OPEN_PARENTHESYS34_tree = null;
		OPPLSyntaxTree STAR35_tree = null;
		OPPLSyntaxTree CLOSED_PARENTHESYS36_tree = null;
		OPPLSyntaxTree INTEGER37_tree = null;
		RewriteRuleTokenStream stream_COMMA = new RewriteRuleTokenStream(this.adaptor,
				"token COMMA");
		RewriteRuleTokenStream stream_STAR = new RewriteRuleTokenStream(this.adaptor, "token STAR");
		RewriteRuleTokenStream stream_CLOSED_PARENTHESYS = new RewriteRuleTokenStream(this.adaptor,
				"token CLOSED_PARENTHESYS");
		RewriteRuleTokenStream stream_OPEN_PARENTHESYS = new RewriteRuleTokenStream(this.adaptor,
				"token OPEN_PARENTHESYS");
		RewriteRuleTokenStream stream_VARIABLE_NAME = new RewriteRuleTokenStream(this.adaptor,
				"token VARIABLE_NAME");
		RewriteRuleTokenStream stream_COUNT = new RewriteRuleTokenStream(this.adaptor,
				"token COUNT");
		RewriteRuleSubtreeStream stream_bindingDescription = new RewriteRuleSubtreeStream(
				this.adaptor, "rule bindingDescription");
		RewriteRuleSubtreeStream stream_expression = new RewriteRuleSubtreeStream(this.adaptor,
				"rule expression");
		try {
			// /Users/luigi/Documents/workspace/Parsers/src/OPPLTestCaseCombined.g:107:2:
			// ( COUNT OPEN_PARENTHESYS bindingDescription ( COMMA
			// bindingDescription )* CLOSED_PARENTHESYS -> ^( COUNT (
			// bindingDescription )+ ) | COUNT OPEN_PARENTHESYS VARIABLE_NAME
			// CLOSED_PARENTHESYS -> ^( COUNT VARIABLE_NAME ) | COUNT
			// OPEN_PARENTHESYS STAR CLOSED_PARENTHESYS -> ^( COUNT STAR ) |
			// INTEGER | expression -> ^( EXPRESSION expression ) )
			int alt7 = 5;
			switch (this.input.LA(1)) {
			case COUNT: {
				int LA7_1 = this.input.LA(2);
				if (LA7_1 == OPEN_PARENTHESYS) {
					int LA7_4 = this.input.LA(3);
					if (LA7_4 == VARIABLE_NAME) {
						int LA7_5 = this.input.LA(4);
						if (LA7_5 == CLOSED_PARENTHESYS) {
							alt7 = 2;
						} else if (LA7_5 == EQUAL) {
							alt7 = 1;
						} else {
							if (this.state.backtracking > 0) {
								this.state.failed = true;
								return retval;
							}
							NoViableAltException nvae = new NoViableAltException("", 7, 5,
									this.input);
							throw nvae;
						}
					} else if (LA7_4 == STAR) {
						alt7 = 3;
					} else {
						if (this.state.backtracking > 0) {
							this.state.failed = true;
							return retval;
						}
						NoViableAltException nvae = new NoViableAltException("", 7, 4, this.input);
						throw nvae;
					}
				} else {
					if (this.state.backtracking > 0) {
						this.state.failed = true;
						return retval;
					}
					NoViableAltException nvae = new NoViableAltException("", 7, 1, this.input);
					throw nvae;
				}
			}
				break;
			case INTEGER: {
				alt7 = 4;
			}
				break;
			case OPEN_PARENTHESYS:
			case OPEN_CURLY_BRACES:
			case NOT:
			case INVERSE:
			case DBLQUOTE:
			case IDENTIFIER:
			case ENTITY_REFERENCE:
			case ESCLAMATION_MARK:
			case VARIABLE_NAME: {
				alt7 = 5;
			}
				break;
			default:
				if (this.state.backtracking > 0) {
					this.state.failed = true;
					return retval;
				}
				NoViableAltException nvae = new NoViableAltException("", 7, 0, this.input);
				throw nvae;
			}
			switch (alt7) {
			case 1:
				// /Users/luigi/Documents/workspace/Parsers/src/OPPLTestCaseCombined.g:108:3:
				// COUNT OPEN_PARENTHESYS bindingDescription ( COMMA
				// bindingDescription )* CLOSED_PARENTHESYS
			{
				COUNT23 = (Token) this.match(
						this.input,
						COUNT,
						FOLLOW_COUNT_in_assertionExpression496);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_COUNT.add(COUNT23);
				}
				OPEN_PARENTHESYS24 = (Token) this.match(
						this.input,
						OPEN_PARENTHESYS,
						FOLLOW_OPEN_PARENTHESYS_in_assertionExpression498);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_OPEN_PARENTHESYS.add(OPEN_PARENTHESYS24);
				}
				this.pushFollow(FOLLOW_bindingDescription_in_assertionExpression500);
				bindingDescription25 = this.bindingDescription();
				this.state._fsp--;
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_bindingDescription.add(bindingDescription25.getTree());
				}
				// /Users/luigi/Documents/workspace/Parsers/src/OPPLTestCaseCombined.g:108:45:
				// ( COMMA bindingDescription )*
				loop6: do {
					int alt6 = 2;
					int LA6_0 = this.input.LA(1);
					if (LA6_0 == COMMA) {
						alt6 = 1;
					}
					switch (alt6) {
					case 1:
						// /Users/luigi/Documents/workspace/Parsers/src/OPPLTestCaseCombined.g:108:46:
						// COMMA bindingDescription
					{
						COMMA26 = (Token) this.match(
								this.input,
								COMMA,
								FOLLOW_COMMA_in_assertionExpression503);
						if (this.state.failed) {
							return retval;
						}
						if (this.state.backtracking == 0) {
							stream_COMMA.add(COMMA26);
						}
						this.pushFollow(FOLLOW_bindingDescription_in_assertionExpression505);
						bindingDescription27 = this.bindingDescription();
						this.state._fsp--;
						if (this.state.failed) {
							return retval;
						}
						if (this.state.backtracking == 0) {
							stream_bindingDescription.add(bindingDescription27.getTree());
						}
					}
						break;
					default:
						break loop6;
					}
				} while (true);
				CLOSED_PARENTHESYS28 = (Token) this.match(
						this.input,
						CLOSED_PARENTHESYS,
						FOLLOW_CLOSED_PARENTHESYS_in_assertionExpression509);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_CLOSED_PARENTHESYS.add(CLOSED_PARENTHESYS28);
				}
				// AST REWRITE
				// elements: COUNT, bindingDescription
				// token labels:
				// rule labels: retval
				// token list labels:
				// rule list labels:
				// wildcard labels:
				if (this.state.backtracking == 0) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(
							this.adaptor, "rule retval", retval != null ? retval.tree : null);
					root_0 = (OPPLSyntaxTree) this.adaptor.nil();
					// 108:92: -> ^( COUNT ( bindingDescription )+ )
					{
						// /Users/luigi/Documents/workspace/Parsers/src/OPPLTestCaseCombined.g:108:94:
						// ^( COUNT ( bindingDescription )+ )
						{
							OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor.nil();
							root_1 = (OPPLSyntaxTree) this.adaptor.becomeRoot(
									stream_COUNT.nextNode(),
									root_1);
							if (!stream_bindingDescription.hasNext()) {
								throw new RewriteEarlyExitException();
							}
							while (stream_bindingDescription.hasNext()) {
								this.adaptor.addChild(root_1, stream_bindingDescription.nextTree());
							}
							stream_bindingDescription.reset();
							this.adaptor.addChild(root_0, root_1);
						}
					}
					retval.tree = root_0;
				}
			}
				break;
			case 2:
				// /Users/luigi/Documents/workspace/Parsers/src/OPPLTestCaseCombined.g:109:5:
				// COUNT OPEN_PARENTHESYS VARIABLE_NAME CLOSED_PARENTHESYS
			{
				COUNT29 = (Token) this.match(
						this.input,
						COUNT,
						FOLLOW_COUNT_in_assertionExpression523);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_COUNT.add(COUNT29);
				}
				OPEN_PARENTHESYS30 = (Token) this.match(
						this.input,
						OPEN_PARENTHESYS,
						FOLLOW_OPEN_PARENTHESYS_in_assertionExpression525);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_OPEN_PARENTHESYS.add(OPEN_PARENTHESYS30);
				}
				VARIABLE_NAME31 = (Token) this.match(
						this.input,
						VARIABLE_NAME,
						FOLLOW_VARIABLE_NAME_in_assertionExpression527);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_VARIABLE_NAME.add(VARIABLE_NAME31);
				}
				CLOSED_PARENTHESYS32 = (Token) this.match(
						this.input,
						CLOSED_PARENTHESYS,
						FOLLOW_CLOSED_PARENTHESYS_in_assertionExpression529);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_CLOSED_PARENTHESYS.add(CLOSED_PARENTHESYS32);
				}
				// AST REWRITE
				// elements: VARIABLE_NAME, COUNT
				// token labels:
				// rule labels: retval
				// token list labels:
				// rule list labels:
				// wildcard labels:
				if (this.state.backtracking == 0) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(
							this.adaptor, "rule retval", retval != null ? retval.tree : null);
					root_0 = (OPPLSyntaxTree) this.adaptor.nil();
					// 109:61: -> ^( COUNT VARIABLE_NAME )
					{
						// /Users/luigi/Documents/workspace/Parsers/src/OPPLTestCaseCombined.g:109:63:
						// ^( COUNT VARIABLE_NAME )
						{
							OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor.nil();
							root_1 = (OPPLSyntaxTree) this.adaptor.becomeRoot(
									stream_COUNT.nextNode(),
									root_1);
							this.adaptor.addChild(root_1, stream_VARIABLE_NAME.nextNode());
							this.adaptor.addChild(root_0, root_1);
						}
					}
					retval.tree = root_0;
				}
			}
				break;
			case 3:
				// /Users/luigi/Documents/workspace/Parsers/src/OPPLTestCaseCombined.g:110:5:
				// COUNT OPEN_PARENTHESYS STAR CLOSED_PARENTHESYS
			{
				COUNT33 = (Token) this.match(
						this.input,
						COUNT,
						FOLLOW_COUNT_in_assertionExpression542);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_COUNT.add(COUNT33);
				}
				OPEN_PARENTHESYS34 = (Token) this.match(
						this.input,
						OPEN_PARENTHESYS,
						FOLLOW_OPEN_PARENTHESYS_in_assertionExpression544);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_OPEN_PARENTHESYS.add(OPEN_PARENTHESYS34);
				}
				STAR35 = (Token) this.match(this.input, STAR, FOLLOW_STAR_in_assertionExpression546);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_STAR.add(STAR35);
				}
				CLOSED_PARENTHESYS36 = (Token) this.match(
						this.input,
						CLOSED_PARENTHESYS,
						FOLLOW_CLOSED_PARENTHESYS_in_assertionExpression548);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_CLOSED_PARENTHESYS.add(CLOSED_PARENTHESYS36);
				}
				// AST REWRITE
				// elements: STAR, COUNT
				// token labels:
				// rule labels: retval
				// token list labels:
				// rule list labels:
				// wildcard labels:
				if (this.state.backtracking == 0) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(
							this.adaptor, "rule retval", retval != null ? retval.tree : null);
					root_0 = (OPPLSyntaxTree) this.adaptor.nil();
					// 110:52: -> ^( COUNT STAR )
					{
						// /Users/luigi/Documents/workspace/Parsers/src/OPPLTestCaseCombined.g:110:54:
						// ^( COUNT STAR )
						{
							OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor.nil();
							root_1 = (OPPLSyntaxTree) this.adaptor.becomeRoot(
									stream_COUNT.nextNode(),
									root_1);
							this.adaptor.addChild(root_1, stream_STAR.nextNode());
							this.adaptor.addChild(root_0, root_1);
						}
					}
					retval.tree = root_0;
				}
			}
				break;
			case 4:
				// /Users/luigi/Documents/workspace/Parsers/src/OPPLTestCaseCombined.g:111:5:
				// INTEGER
			{
				root_0 = (OPPLSyntaxTree) this.adaptor.nil();
				INTEGER37 = (Token) this.match(
						this.input,
						INTEGER,
						FOLLOW_INTEGER_in_assertionExpression561);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					INTEGER37_tree = (OPPLSyntaxTree) this.adaptor.create(INTEGER37);
					this.adaptor.addChild(root_0, INTEGER37_tree);
				}
			}
				break;
			case 5:
				// /Users/luigi/Documents/workspace/Parsers/src/OPPLTestCaseCombined.g:112:5:
				// expression
			{
				this.pushFollow(FOLLOW_expression_in_assertionExpression568);
				expression38 = this.expression();
				this.state._fsp--;
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_expression.add(expression38.getTree());
				}
				// AST REWRITE
				// elements: expression
				// token labels:
				// rule labels: retval
				// token list labels:
				// rule list labels:
				// wildcard labels:
				if (this.state.backtracking == 0) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(
							this.adaptor, "rule retval", retval != null ? retval.tree : null);
					root_0 = (OPPLSyntaxTree) this.adaptor.nil();
					// 112:16: -> ^( EXPRESSION expression )
					{
						// /Users/luigi/Documents/workspace/Parsers/src/OPPLTestCaseCombined.g:112:18:
						// ^( EXPRESSION expression )
						{
							OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor.nil();
							root_1 = (OPPLSyntaxTree) this.adaptor.becomeRoot(
									this.adaptor.create(EXPRESSION, "EXPRESSION"),
									root_1);
							this.adaptor.addChild(root_1, stream_expression.nextTree());
							this.adaptor.addChild(root_0, root_1);
						}
					}
					retval.tree = root_0;
				}
			}
				break;
			}
			retval.stop = this.input.LT(-1);
			if (this.state.backtracking == 0) {
				retval.tree = (OPPLSyntaxTree) this.adaptor.rulePostProcessing(root_0);
				this.adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		} catch (RecognitionException exception) {
			if (this.errorListener != null) {
				this.errorListener.recognitionException(exception);
			}
		} catch (RewriteEmptyStreamException exception) {
			if (this.errorListener != null) {
				this.errorListener.rewriteEmptyStreamException(exception);
			}
		} finally {
		}
		return retval;
	}

	// $ANTLR end "assertionExpression"
	public static class bindingDescription_return extends ParserRuleReturnScope {
		OPPLSyntaxTree tree;

		@Override
		public Object getTree() {
			return this.tree;
		}
	};

	// $ANTLR start "bindingDescription"
	// /Users/luigi/Documents/workspace/Parsers/src/OPPLTestCaseCombined.g:116:1:
	// bindingDescription : VARIABLE_NAME EQUAL expression -> ^( BINDING
	// VARIABLE_NAME ^( EXPRESSION expression ) ) ;
	public final OPPLTestCaseCombinedParser.bindingDescription_return bindingDescription()
			throws RecognitionException {
		OPPLTestCaseCombinedParser.bindingDescription_return retval = new OPPLTestCaseCombinedParser.bindingDescription_return();
		retval.start = this.input.LT(1);
		OPPLSyntaxTree root_0 = null;
		Token VARIABLE_NAME39 = null;
		Token EQUAL40 = null;
		OPPLTestCaseCombined_OPPLParser_MOWLParser.expression_return expression41 = null;
		OPPLSyntaxTree VARIABLE_NAME39_tree = null;
		OPPLSyntaxTree EQUAL40_tree = null;
		RewriteRuleTokenStream stream_EQUAL = new RewriteRuleTokenStream(this.adaptor,
				"token EQUAL");
		RewriteRuleTokenStream stream_VARIABLE_NAME = new RewriteRuleTokenStream(this.adaptor,
				"token VARIABLE_NAME");
		RewriteRuleSubtreeStream stream_expression = new RewriteRuleSubtreeStream(this.adaptor,
				"rule expression");
		try {
			// /Users/luigi/Documents/workspace/Parsers/src/OPPLTestCaseCombined.g:117:2:
			// ( VARIABLE_NAME EQUAL expression -> ^( BINDING VARIABLE_NAME ^(
			// EXPRESSION expression ) ) )
			// /Users/luigi/Documents/workspace/Parsers/src/OPPLTestCaseCombined.g:118:3:
			// VARIABLE_NAME EQUAL expression
			{
				VARIABLE_NAME39 = (Token) this.match(
						this.input,
						VARIABLE_NAME,
						FOLLOW_VARIABLE_NAME_in_bindingDescription591);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_VARIABLE_NAME.add(VARIABLE_NAME39);
				}
				EQUAL40 = (Token) this.match(
						this.input,
						EQUAL,
						FOLLOW_EQUAL_in_bindingDescription593);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_EQUAL.add(EQUAL40);
				}
				this.pushFollow(FOLLOW_expression_in_bindingDescription595);
				expression41 = this.expression();
				this.state._fsp--;
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_expression.add(expression41.getTree());
				}
				// AST REWRITE
				// elements: expression, VARIABLE_NAME
				// token labels:
				// rule labels: retval
				// token list labels:
				// rule list labels:
				// wildcard labels:
				if (this.state.backtracking == 0) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(
							this.adaptor, "rule retval", retval != null ? retval.tree : null);
					root_0 = (OPPLSyntaxTree) this.adaptor.nil();
					// 118:34: -> ^( BINDING VARIABLE_NAME ^( EXPRESSION
					// expression ) )
					{
						// /Users/luigi/Documents/workspace/Parsers/src/OPPLTestCaseCombined.g:118:37:
						// ^( BINDING VARIABLE_NAME ^( EXPRESSION expression ) )
						{
							OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor.nil();
							root_1 = (OPPLSyntaxTree) this.adaptor.becomeRoot(
									this.adaptor.create(BINDING, "BINDING"),
									root_1);
							this.adaptor.addChild(root_1, stream_VARIABLE_NAME.nextNode());
							// /Users/luigi/Documents/workspace/Parsers/src/OPPLTestCaseCombined.g:118:62:
							// ^( EXPRESSION expression )
							{
								OPPLSyntaxTree root_2 = (OPPLSyntaxTree) this.adaptor.nil();
								root_2 = (OPPLSyntaxTree) this.adaptor.becomeRoot(
										this.adaptor.create(EXPRESSION, "EXPRESSION"),
										root_2);
								this.adaptor.addChild(root_2, stream_expression.nextTree());
								this.adaptor.addChild(root_1, root_2);
							}
							this.adaptor.addChild(root_0, root_1);
						}
					}
					retval.tree = root_0;
				}
			}
			retval.stop = this.input.LT(-1);
			if (this.state.backtracking == 0) {
				retval.tree = (OPPLSyntaxTree) this.adaptor.rulePostProcessing(root_0);
				this.adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		} catch (RecognitionException exception) {
			if (this.errorListener != null) {
				this.errorListener.recognitionException(exception);
			}
		} catch (RewriteEmptyStreamException exception) {
			if (this.errorListener != null) {
				this.errorListener.rewriteEmptyStreamException(exception);
			}
		} finally {
		}
		return retval;
	}

	// $ANTLR end "bindingDescription"
	public static class text_return extends ParserRuleReturnScope {
		OPPLSyntaxTree tree;

		@Override
		public Object getTree() {
			return this.tree;
		}
	};

	// $ANTLR start "text"
	// /Users/luigi/Documents/workspace/Parsers/src/OPPLTestCaseCombined.g:123:1:
	// text : (t= textBit )+ -> ^( TEXT[builder.toString()] ( textBit )+ ) ;
	public final OPPLTestCaseCombinedParser.text_return text() throws RecognitionException {
		OPPLTestCaseCombinedParser.text_return retval = new OPPLTestCaseCombinedParser.text_return();
		retval.start = this.input.LT(1);
		OPPLSyntaxTree root_0 = null;
		OPPLTestCaseCombinedParser.textBit_return t = null;
		RewriteRuleSubtreeStream stream_textBit = new RewriteRuleSubtreeStream(this.adaptor,
				"rule textBit");
		StringBuilder builder = new StringBuilder();
		try {
			// /Users/luigi/Documents/workspace/Parsers/src/OPPLTestCaseCombined.g:129:1:
			// ( (t= textBit )+ -> ^( TEXT[builder.toString()] ( textBit )+ ) )
			// /Users/luigi/Documents/workspace/Parsers/src/OPPLTestCaseCombined.g:130:1:
			// (t= textBit )+
			{
				// /Users/luigi/Documents/workspace/Parsers/src/OPPLTestCaseCombined.g:130:1:
				// (t= textBit )+
				int cnt8 = 0;
				loop8: do {
					int alt8 = 2;
					int LA8_0 = this.input.LA(1);
					if (LA8_0 >= AND && LA8_0 <= INVERSE || LA8_0 >= DOMAIN
							&& LA8_0 <= INVERSE_FUNCTIONAL || LA8_0 == TYPES || LA8_0 == INTEGER
							|| LA8_0 == IDENTIFIER || LA8_0 == EQUAL || LA8_0 == VARIABLE_NAME
							|| LA8_0 == COUNT) {
						alt8 = 1;
					}
					switch (alt8) {
					case 1:
						// /Users/luigi/Documents/workspace/Parsers/src/OPPLTestCaseCombined.g:130:3:
						// t= textBit
					{
						this.pushFollow(FOLLOW_textBit_in_text634);
						t = this.textBit();
						this.state._fsp--;
						if (this.state.failed) {
							return retval;
						}
						if (this.state.backtracking == 0) {
							stream_textBit.add(t.getTree());
						}
						if (this.state.backtracking == 0) {
							builder.append((t != null ? this.input.toString(t.start, t.stop) : null));
							builder.append(" ");
						}
					}
						break;
					default:
						if (cnt8 >= 1) {
							break loop8;
						}
						if (this.state.backtracking > 0) {
							this.state.failed = true;
							return retval;
						}
						EarlyExitException eee = new EarlyExitException(8, this.input);
						throw eee;
					}
					cnt8++;
				} while (true);
				// AST REWRITE
				// elements: textBit
				// token labels:
				// rule labels: retval
				// token list labels:
				// rule list labels:
				// wildcard labels:
				if (this.state.backtracking == 0) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(
							this.adaptor, "rule retval", retval != null ? retval.tree : null);
					root_0 = (OPPLSyntaxTree) this.adaptor.nil();
					// 134:8: -> ^( TEXT[builder.toString()] ( textBit )+ )
					{
						// /Users/luigi/Documents/workspace/Parsers/src/OPPLTestCaseCombined.g:134:11:
						// ^( TEXT[builder.toString()] ( textBit )+ )
						{
							OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor.nil();
							root_1 = (OPPLSyntaxTree) this.adaptor.becomeRoot(
									this.adaptor.create(TEXT, builder.toString()),
									root_1);
							if (!stream_textBit.hasNext()) {
								throw new RewriteEarlyExitException();
							}
							while (stream_textBit.hasNext()) {
								this.adaptor.addChild(root_1, stream_textBit.nextTree());
							}
							stream_textBit.reset();
							this.adaptor.addChild(root_0, root_1);
						}
					}
					retval.tree = root_0;
				}
			}
			retval.stop = this.input.LT(-1);
			if (this.state.backtracking == 0) {
				retval.tree = (OPPLSyntaxTree) this.adaptor.rulePostProcessing(root_0);
				this.adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		} catch (RecognitionException exception) {
			if (this.errorListener != null) {
				this.errorListener.recognitionException(exception);
			}
		} catch (RewriteEmptyStreamException exception) {
			if (this.errorListener != null) {
				this.errorListener.rewriteEmptyStreamException(exception);
			}
		} finally {
		}
		return retval;
	}

	// $ANTLR end "text"
	public static class textBit_return extends ParserRuleReturnScope {
		OPPLSyntaxTree tree;

		@Override
		public Object getTree() {
			return this.tree;
		}
	};

	// $ANTLR start "textBit"
	// /Users/luigi/Documents/workspace/Parsers/src/OPPLTestCaseCombined.g:137:1:
	// textBit : ( IDENTIFIER -> ^( TEXT[$IDENTIFIER.text] ) | VARIABLE_NAME ->
	// ^( TEXT VARIABLE_NAME ) | FUNCTIONAL -> ^( TEXT[$FUNCTIONAL.text] ) |
	// INVERSE_FUNCTIONAL -> ^( TEXT[$INVERSE_FUNCTIONAL.text] ) | SYMMETRIC ->
	// ^( TEXT[$SYMMETRIC.text] ) | ANTI_SYMMETRIC -> ^(
	// TEXT[$ANTI_SYMMETRIC.text] ) | REFLEXIVE -> ^( TEXT[$REFLEXIVE.text] ) |
	// IRREFLEXIVE -> ^( TEXT[$IRREFLEXIVE.text] ) | TRANSITIVE -> ^(
	// TEXT[$TRANSITIVE.text] ) | NOT -> ^( TEXT[$NOT.text] ) | AND -> ^(
	// TEXT[$AND.text] ) | OR -> ^( TEXT[$OR.text] ) | SOME -> ^(
	// TEXT[$SOME.text] ) | ONLY -> ^( TEXT[$ONLY.text] ) | MIN -> ^(
	// TEXT[$MIN.text] ) | MAX -> ^( TEXT[$MAX.text] ) | EXACTLY -> ^(
	// TEXT[$EXACTLY.text] ) | VALUE -> ^( TEXT[$VALUE.text] ) | INVERSE -> ^(
	// TEXT[$INVERSE.text] ) | DOMAIN -> ^( TEXT[$DOMAIN.text] ) | RANGE -> ^(
	// TEXT[$RANGE.text] ) | TYPES -> ^( TEXT[$TYPES.text] ) | INTEGER -> ^(
	// TEXT[$INTEGER.text] ) | COUNT -> ^( TEXT[$COUNT.text] ) | EQUAL -> ^(
	// TEXT[$EQUAL.text] ) );
	public final OPPLTestCaseCombinedParser.textBit_return textBit() throws RecognitionException {
		OPPLTestCaseCombinedParser.textBit_return retval = new OPPLTestCaseCombinedParser.textBit_return();
		retval.start = this.input.LT(1);
		OPPLSyntaxTree root_0 = null;
		Token IDENTIFIER42 = null;
		Token VARIABLE_NAME43 = null;
		Token FUNCTIONAL44 = null;
		Token INVERSE_FUNCTIONAL45 = null;
		Token SYMMETRIC46 = null;
		Token ANTI_SYMMETRIC47 = null;
		Token REFLEXIVE48 = null;
		Token IRREFLEXIVE49 = null;
		Token TRANSITIVE50 = null;
		Token NOT51 = null;
		Token AND52 = null;
		Token OR53 = null;
		Token SOME54 = null;
		Token ONLY55 = null;
		Token MIN56 = null;
		Token MAX57 = null;
		Token EXACTLY58 = null;
		Token VALUE59 = null;
		Token INVERSE60 = null;
		Token DOMAIN61 = null;
		Token RANGE62 = null;
		Token TYPES63 = null;
		Token INTEGER64 = null;
		Token COUNT65 = null;
		Token EQUAL66 = null;
		OPPLSyntaxTree IDENTIFIER42_tree = null;
		OPPLSyntaxTree VARIABLE_NAME43_tree = null;
		OPPLSyntaxTree FUNCTIONAL44_tree = null;
		OPPLSyntaxTree INVERSE_FUNCTIONAL45_tree = null;
		OPPLSyntaxTree SYMMETRIC46_tree = null;
		OPPLSyntaxTree ANTI_SYMMETRIC47_tree = null;
		OPPLSyntaxTree REFLEXIVE48_tree = null;
		OPPLSyntaxTree IRREFLEXIVE49_tree = null;
		OPPLSyntaxTree TRANSITIVE50_tree = null;
		OPPLSyntaxTree NOT51_tree = null;
		OPPLSyntaxTree AND52_tree = null;
		OPPLSyntaxTree OR53_tree = null;
		OPPLSyntaxTree SOME54_tree = null;
		OPPLSyntaxTree ONLY55_tree = null;
		OPPLSyntaxTree MIN56_tree = null;
		OPPLSyntaxTree MAX57_tree = null;
		OPPLSyntaxTree EXACTLY58_tree = null;
		OPPLSyntaxTree VALUE59_tree = null;
		OPPLSyntaxTree INVERSE60_tree = null;
		OPPLSyntaxTree DOMAIN61_tree = null;
		OPPLSyntaxTree RANGE62_tree = null;
		OPPLSyntaxTree TYPES63_tree = null;
		OPPLSyntaxTree INTEGER64_tree = null;
		OPPLSyntaxTree COUNT65_tree = null;
		OPPLSyntaxTree EQUAL66_tree = null;
		RewriteRuleTokenStream stream_MAX = new RewriteRuleTokenStream(this.adaptor, "token MAX");
		RewriteRuleTokenStream stream_RANGE = new RewriteRuleTokenStream(this.adaptor,
				"token RANGE");
		RewriteRuleTokenStream stream_ONLY = new RewriteRuleTokenStream(this.adaptor, "token ONLY");
		RewriteRuleTokenStream stream_SYMMETRIC = new RewriteRuleTokenStream(this.adaptor,
				"token SYMMETRIC");
		RewriteRuleTokenStream stream_MIN = new RewriteRuleTokenStream(this.adaptor, "token MIN");
		RewriteRuleTokenStream stream_TYPES = new RewriteRuleTokenStream(this.adaptor,
				"token TYPES");
		RewriteRuleTokenStream stream_VALUE = new RewriteRuleTokenStream(this.adaptor,
				"token VALUE");
		RewriteRuleTokenStream stream_INVERSE_FUNCTIONAL = new RewriteRuleTokenStream(this.adaptor,
				"token INVERSE_FUNCTIONAL");
		RewriteRuleTokenStream stream_OR = new RewriteRuleTokenStream(this.adaptor, "token OR");
		RewriteRuleTokenStream stream_SOME = new RewriteRuleTokenStream(this.adaptor, "token SOME");
		RewriteRuleTokenStream stream_INTEGER = new RewriteRuleTokenStream(this.adaptor,
				"token INTEGER");
		RewriteRuleTokenStream stream_AND = new RewriteRuleTokenStream(this.adaptor, "token AND");
		RewriteRuleTokenStream stream_EQUAL = new RewriteRuleTokenStream(this.adaptor,
				"token EQUAL");
		RewriteRuleTokenStream stream_INVERSE = new RewriteRuleTokenStream(this.adaptor,
				"token INVERSE");
		RewriteRuleTokenStream stream_COUNT = new RewriteRuleTokenStream(this.adaptor,
				"token COUNT");
		RewriteRuleTokenStream stream_DOMAIN = new RewriteRuleTokenStream(this.adaptor,
				"token DOMAIN");
		RewriteRuleTokenStream stream_ANTI_SYMMETRIC = new RewriteRuleTokenStream(this.adaptor,
				"token ANTI_SYMMETRIC");
		RewriteRuleTokenStream stream_EXACTLY = new RewriteRuleTokenStream(this.adaptor,
				"token EXACTLY");
		RewriteRuleTokenStream stream_IDENTIFIER = new RewriteRuleTokenStream(this.adaptor,
				"token IDENTIFIER");
		RewriteRuleTokenStream stream_TRANSITIVE = new RewriteRuleTokenStream(this.adaptor,
				"token TRANSITIVE");
		RewriteRuleTokenStream stream_REFLEXIVE = new RewriteRuleTokenStream(this.adaptor,
				"token REFLEXIVE");
		RewriteRuleTokenStream stream_NOT = new RewriteRuleTokenStream(this.adaptor, "token NOT");
		RewriteRuleTokenStream stream_VARIABLE_NAME = new RewriteRuleTokenStream(this.adaptor,
				"token VARIABLE_NAME");
		RewriteRuleTokenStream stream_IRREFLEXIVE = new RewriteRuleTokenStream(this.adaptor,
				"token IRREFLEXIVE");
		RewriteRuleTokenStream stream_FUNCTIONAL = new RewriteRuleTokenStream(this.adaptor,
				"token FUNCTIONAL");
		try {
			// /Users/luigi/Documents/workspace/Parsers/src/OPPLTestCaseCombined.g:138:2:
			// ( IDENTIFIER -> ^( TEXT[$IDENTIFIER.text] ) | VARIABLE_NAME -> ^(
			// TEXT VARIABLE_NAME ) | FUNCTIONAL -> ^( TEXT[$FUNCTIONAL.text] )
			// | INVERSE_FUNCTIONAL -> ^( TEXT[$INVERSE_FUNCTIONAL.text] ) |
			// SYMMETRIC -> ^( TEXT[$SYMMETRIC.text] ) | ANTI_SYMMETRIC -> ^(
			// TEXT[$ANTI_SYMMETRIC.text] ) | REFLEXIVE -> ^(
			// TEXT[$REFLEXIVE.text] ) | IRREFLEXIVE -> ^(
			// TEXT[$IRREFLEXIVE.text] ) | TRANSITIVE -> ^(
			// TEXT[$TRANSITIVE.text] ) | NOT -> ^( TEXT[$NOT.text] ) | AND ->
			// ^( TEXT[$AND.text] ) | OR -> ^( TEXT[$OR.text] ) | SOME -> ^(
			// TEXT[$SOME.text] ) | ONLY -> ^( TEXT[$ONLY.text] ) | MIN -> ^(
			// TEXT[$MIN.text] ) | MAX -> ^( TEXT[$MAX.text] ) | EXACTLY -> ^(
			// TEXT[$EXACTLY.text] ) | VALUE -> ^( TEXT[$VALUE.text] ) | INVERSE
			// -> ^( TEXT[$INVERSE.text] ) | DOMAIN -> ^( TEXT[$DOMAIN.text] ) |
			// RANGE -> ^( TEXT[$RANGE.text] ) | TYPES -> ^( TEXT[$TYPES.text] )
			// | INTEGER -> ^( TEXT[$INTEGER.text] ) | COUNT -> ^(
			// TEXT[$COUNT.text] ) | EQUAL -> ^( TEXT[$EQUAL.text] ) )
			int alt9 = 25;
			switch (this.input.LA(1)) {
			case IDENTIFIER: {
				alt9 = 1;
			}
				break;
			case VARIABLE_NAME: {
				alt9 = 2;
			}
				break;
			case FUNCTIONAL: {
				alt9 = 3;
			}
				break;
			case INVERSE_FUNCTIONAL: {
				alt9 = 4;
			}
				break;
			case SYMMETRIC: {
				alt9 = 5;
			}
				break;
			case ANTI_SYMMETRIC: {
				alt9 = 6;
			}
				break;
			case REFLEXIVE: {
				alt9 = 7;
			}
				break;
			case IRREFLEXIVE: {
				alt9 = 8;
			}
				break;
			case TRANSITIVE: {
				alt9 = 9;
			}
				break;
			case NOT: {
				alt9 = 10;
			}
				break;
			case AND: {
				alt9 = 11;
			}
				break;
			case OR: {
				alt9 = 12;
			}
				break;
			case SOME: {
				alt9 = 13;
			}
				break;
			case ONLY: {
				alt9 = 14;
			}
				break;
			case MIN: {
				alt9 = 15;
			}
				break;
			case MAX: {
				alt9 = 16;
			}
				break;
			case EXACTLY: {
				alt9 = 17;
			}
				break;
			case VALUE: {
				alt9 = 18;
			}
				break;
			case INVERSE: {
				alt9 = 19;
			}
				break;
			case DOMAIN: {
				alt9 = 20;
			}
				break;
			case RANGE: {
				alt9 = 21;
			}
				break;
			case TYPES: {
				alt9 = 22;
			}
				break;
			case INTEGER: {
				alt9 = 23;
			}
				break;
			case COUNT: {
				alt9 = 24;
			}
				break;
			case EQUAL: {
				alt9 = 25;
			}
				break;
			default:
				if (this.state.backtracking > 0) {
					this.state.failed = true;
					return retval;
				}
				NoViableAltException nvae = new NoViableAltException("", 9, 0, this.input);
				throw nvae;
			}
			switch (alt9) {
			case 1:
				// /Users/luigi/Documents/workspace/Parsers/src/OPPLTestCaseCombined.g:139:4:
				// IDENTIFIER
			{
				IDENTIFIER42 = (Token) this.match(
						this.input,
						IDENTIFIER,
						FOLLOW_IDENTIFIER_in_textBit666);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_IDENTIFIER.add(IDENTIFIER42);
				}
				// AST REWRITE
				// elements:
				// token labels:
				// rule labels: retval
				// token list labels:
				// rule list labels:
				// wildcard labels:
				if (this.state.backtracking == 0) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(
							this.adaptor, "rule retval", retval != null ? retval.tree : null);
					root_0 = (OPPLSyntaxTree) this.adaptor.nil();
					// 139:15: -> ^( TEXT[$IDENTIFIER.text] )
					{
						// /Users/luigi/Documents/workspace/Parsers/src/OPPLTestCaseCombined.g:139:18:
						// ^( TEXT[$IDENTIFIER.text] )
						{
							OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor.nil();
							root_1 = (OPPLSyntaxTree) this.adaptor.becomeRoot(
									this.adaptor.create(
											TEXT,
											(IDENTIFIER42 != null ? IDENTIFIER42.getText() : null)),
									root_1);
							this.adaptor.addChild(root_0, root_1);
						}
					}
					retval.tree = root_0;
				}
			}
				break;
			case 2:
				// /Users/luigi/Documents/workspace/Parsers/src/OPPLTestCaseCombined.g:140:6:
				// VARIABLE_NAME
			{
				VARIABLE_NAME43 = (Token) this.match(
						this.input,
						VARIABLE_NAME,
						FOLLOW_VARIABLE_NAME_in_textBit681);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_VARIABLE_NAME.add(VARIABLE_NAME43);
				}
				// AST REWRITE
				// elements: VARIABLE_NAME
				// token labels:
				// rule labels: retval
				// token list labels:
				// rule list labels:
				// wildcard labels:
				if (this.state.backtracking == 0) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(
							this.adaptor, "rule retval", retval != null ? retval.tree : null);
					root_0 = (OPPLSyntaxTree) this.adaptor.nil();
					// 140:21: -> ^( TEXT VARIABLE_NAME )
					{
						// /Users/luigi/Documents/workspace/Parsers/src/OPPLTestCaseCombined.g:140:24:
						// ^( TEXT VARIABLE_NAME )
						{
							OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor.nil();
							root_1 = (OPPLSyntaxTree) this.adaptor.becomeRoot(
									this.adaptor.create(TEXT, "TEXT"),
									root_1);
							this.adaptor.addChild(root_1, stream_VARIABLE_NAME.nextNode());
							this.adaptor.addChild(root_0, root_1);
						}
					}
					retval.tree = root_0;
				}
			}
				break;
			case 3:
				// /Users/luigi/Documents/workspace/Parsers/src/OPPLTestCaseCombined.g:141:6:
				// FUNCTIONAL
			{
				FUNCTIONAL44 = (Token) this.match(
						this.input,
						FUNCTIONAL,
						FOLLOW_FUNCTIONAL_in_textBit697);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_FUNCTIONAL.add(FUNCTIONAL44);
				}
				// AST REWRITE
				// elements:
				// token labels:
				// rule labels: retval
				// token list labels:
				// rule list labels:
				// wildcard labels:
				if (this.state.backtracking == 0) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(
							this.adaptor, "rule retval", retval != null ? retval.tree : null);
					root_0 = (OPPLSyntaxTree) this.adaptor.nil();
					// 141:17: -> ^( TEXT[$FUNCTIONAL.text] )
					{
						// /Users/luigi/Documents/workspace/Parsers/src/OPPLTestCaseCombined.g:141:20:
						// ^( TEXT[$FUNCTIONAL.text] )
						{
							OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor.nil();
							root_1 = (OPPLSyntaxTree) this.adaptor.becomeRoot(
									this.adaptor.create(
											TEXT,
											(FUNCTIONAL44 != null ? FUNCTIONAL44.getText() : null)),
									root_1);
							this.adaptor.addChild(root_0, root_1);
						}
					}
					retval.tree = root_0;
				}
			}
				break;
			case 4:
				// /Users/luigi/Documents/workspace/Parsers/src/OPPLTestCaseCombined.g:142:6:
				// INVERSE_FUNCTIONAL
			{
				INVERSE_FUNCTIONAL45 = (Token) this.match(
						this.input,
						INVERSE_FUNCTIONAL,
						FOLLOW_INVERSE_FUNCTIONAL_in_textBit712);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_INVERSE_FUNCTIONAL.add(INVERSE_FUNCTIONAL45);
				}
				// AST REWRITE
				// elements:
				// token labels:
				// rule labels: retval
				// token list labels:
				// rule list labels:
				// wildcard labels:
				if (this.state.backtracking == 0) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(
							this.adaptor, "rule retval", retval != null ? retval.tree : null);
					root_0 = (OPPLSyntaxTree) this.adaptor.nil();
					// 142:25: -> ^( TEXT[$INVERSE_FUNCTIONAL.text] )
					{
						// /Users/luigi/Documents/workspace/Parsers/src/OPPLTestCaseCombined.g:142:28:
						// ^( TEXT[$INVERSE_FUNCTIONAL.text] )
						{
							OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor.nil();
							root_1 = (OPPLSyntaxTree) this.adaptor.becomeRoot(this.adaptor.create(
									TEXT,
									(INVERSE_FUNCTIONAL45 != null ? INVERSE_FUNCTIONAL45.getText()
											: null)), root_1);
							this.adaptor.addChild(root_0, root_1);
						}
					}
					retval.tree = root_0;
				}
			}
				break;
			case 5:
				// /Users/luigi/Documents/workspace/Parsers/src/OPPLTestCaseCombined.g:143:6:
				// SYMMETRIC
			{
				SYMMETRIC46 = (Token) this.match(
						this.input,
						SYMMETRIC,
						FOLLOW_SYMMETRIC_in_textBit727);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_SYMMETRIC.add(SYMMETRIC46);
				}
				// AST REWRITE
				// elements:
				// token labels:
				// rule labels: retval
				// token list labels:
				// rule list labels:
				// wildcard labels:
				if (this.state.backtracking == 0) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(
							this.adaptor, "rule retval", retval != null ? retval.tree : null);
					root_0 = (OPPLSyntaxTree) this.adaptor.nil();
					// 143:16: -> ^( TEXT[$SYMMETRIC.text] )
					{
						// /Users/luigi/Documents/workspace/Parsers/src/OPPLTestCaseCombined.g:143:19:
						// ^( TEXT[$SYMMETRIC.text] )
						{
							OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor.nil();
							root_1 = (OPPLSyntaxTree) this.adaptor.becomeRoot(
									this.adaptor.create(
											TEXT,
											(SYMMETRIC46 != null ? SYMMETRIC46.getText() : null)),
									root_1);
							this.adaptor.addChild(root_0, root_1);
						}
					}
					retval.tree = root_0;
				}
			}
				break;
			case 6:
				// /Users/luigi/Documents/workspace/Parsers/src/OPPLTestCaseCombined.g:144:6:
				// ANTI_SYMMETRIC
			{
				ANTI_SYMMETRIC47 = (Token) this.match(
						this.input,
						ANTI_SYMMETRIC,
						FOLLOW_ANTI_SYMMETRIC_in_textBit742);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_ANTI_SYMMETRIC.add(ANTI_SYMMETRIC47);
				}
				// AST REWRITE
				// elements:
				// token labels:
				// rule labels: retval
				// token list labels:
				// rule list labels:
				// wildcard labels:
				if (this.state.backtracking == 0) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(
							this.adaptor, "rule retval", retval != null ? retval.tree : null);
					root_0 = (OPPLSyntaxTree) this.adaptor.nil();
					// 144:21: -> ^( TEXT[$ANTI_SYMMETRIC.text] )
					{
						// /Users/luigi/Documents/workspace/Parsers/src/OPPLTestCaseCombined.g:144:24:
						// ^( TEXT[$ANTI_SYMMETRIC.text] )
						{
							OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor.nil();
							root_1 = (OPPLSyntaxTree) this.adaptor.becomeRoot(
									this.adaptor.create(
											TEXT,
											(ANTI_SYMMETRIC47 != null ? ANTI_SYMMETRIC47.getText()
													: null)),
									root_1);
							this.adaptor.addChild(root_0, root_1);
						}
					}
					retval.tree = root_0;
				}
			}
				break;
			case 7:
				// /Users/luigi/Documents/workspace/Parsers/src/OPPLTestCaseCombined.g:145:6:
				// REFLEXIVE
			{
				REFLEXIVE48 = (Token) this.match(
						this.input,
						REFLEXIVE,
						FOLLOW_REFLEXIVE_in_textBit757);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_REFLEXIVE.add(REFLEXIVE48);
				}
				// AST REWRITE
				// elements:
				// token labels:
				// rule labels: retval
				// token list labels:
				// rule list labels:
				// wildcard labels:
				if (this.state.backtracking == 0) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(
							this.adaptor, "rule retval", retval != null ? retval.tree : null);
					root_0 = (OPPLSyntaxTree) this.adaptor.nil();
					// 145:16: -> ^( TEXT[$REFLEXIVE.text] )
					{
						// /Users/luigi/Documents/workspace/Parsers/src/OPPLTestCaseCombined.g:145:19:
						// ^( TEXT[$REFLEXIVE.text] )
						{
							OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor.nil();
							root_1 = (OPPLSyntaxTree) this.adaptor.becomeRoot(
									this.adaptor.create(
											TEXT,
											(REFLEXIVE48 != null ? REFLEXIVE48.getText() : null)),
									root_1);
							this.adaptor.addChild(root_0, root_1);
						}
					}
					retval.tree = root_0;
				}
			}
				break;
			case 8:
				// /Users/luigi/Documents/workspace/Parsers/src/OPPLTestCaseCombined.g:146:6:
				// IRREFLEXIVE
			{
				IRREFLEXIVE49 = (Token) this.match(
						this.input,
						IRREFLEXIVE,
						FOLLOW_IRREFLEXIVE_in_textBit772);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_IRREFLEXIVE.add(IRREFLEXIVE49);
				}
				// AST REWRITE
				// elements:
				// token labels:
				// rule labels: retval
				// token list labels:
				// rule list labels:
				// wildcard labels:
				if (this.state.backtracking == 0) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(
							this.adaptor, "rule retval", retval != null ? retval.tree : null);
					root_0 = (OPPLSyntaxTree) this.adaptor.nil();
					// 146:18: -> ^( TEXT[$IRREFLEXIVE.text] )
					{
						// /Users/luigi/Documents/workspace/Parsers/src/OPPLTestCaseCombined.g:146:21:
						// ^( TEXT[$IRREFLEXIVE.text] )
						{
							OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor.nil();
							root_1 = (OPPLSyntaxTree) this.adaptor.becomeRoot(
									this.adaptor.create(
											TEXT,
											(IRREFLEXIVE49 != null ? IRREFLEXIVE49.getText() : null)),
									root_1);
							this.adaptor.addChild(root_0, root_1);
						}
					}
					retval.tree = root_0;
				}
			}
				break;
			case 9:
				// /Users/luigi/Documents/workspace/Parsers/src/OPPLTestCaseCombined.g:147:7:
				// TRANSITIVE
			{
				TRANSITIVE50 = (Token) this.match(
						this.input,
						TRANSITIVE,
						FOLLOW_TRANSITIVE_in_textBit788);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_TRANSITIVE.add(TRANSITIVE50);
				}
				// AST REWRITE
				// elements:
				// token labels:
				// rule labels: retval
				// token list labels:
				// rule list labels:
				// wildcard labels:
				if (this.state.backtracking == 0) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(
							this.adaptor, "rule retval", retval != null ? retval.tree : null);
					root_0 = (OPPLSyntaxTree) this.adaptor.nil();
					// 147:18: -> ^( TEXT[$TRANSITIVE.text] )
					{
						// /Users/luigi/Documents/workspace/Parsers/src/OPPLTestCaseCombined.g:147:21:
						// ^( TEXT[$TRANSITIVE.text] )
						{
							OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor.nil();
							root_1 = (OPPLSyntaxTree) this.adaptor.becomeRoot(
									this.adaptor.create(
											TEXT,
											(TRANSITIVE50 != null ? TRANSITIVE50.getText() : null)),
									root_1);
							this.adaptor.addChild(root_0, root_1);
						}
					}
					retval.tree = root_0;
				}
			}
				break;
			case 10:
				// /Users/luigi/Documents/workspace/Parsers/src/OPPLTestCaseCombined.g:148:6:
				// NOT
			{
				NOT51 = (Token) this.match(this.input, NOT, FOLLOW_NOT_in_textBit803);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_NOT.add(NOT51);
				}
				// AST REWRITE
				// elements:
				// token labels:
				// rule labels: retval
				// token list labels:
				// rule list labels:
				// wildcard labels:
				if (this.state.backtracking == 0) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(
							this.adaptor, "rule retval", retval != null ? retval.tree : null);
					root_0 = (OPPLSyntaxTree) this.adaptor.nil();
					// 148:10: -> ^( TEXT[$NOT.text] )
					{
						// /Users/luigi/Documents/workspace/Parsers/src/OPPLTestCaseCombined.g:148:13:
						// ^( TEXT[$NOT.text] )
						{
							OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor.nil();
							root_1 = (OPPLSyntaxTree) this.adaptor.becomeRoot(this.adaptor.create(
									TEXT,
									(NOT51 != null ? NOT51.getText() : null)), root_1);
							this.adaptor.addChild(root_0, root_1);
						}
					}
					retval.tree = root_0;
				}
			}
				break;
			case 11:
				// /Users/luigi/Documents/workspace/Parsers/src/OPPLTestCaseCombined.g:149:6:
				// AND
			{
				AND52 = (Token) this.match(this.input, AND, FOLLOW_AND_in_textBit818);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_AND.add(AND52);
				}
				// AST REWRITE
				// elements:
				// token labels:
				// rule labels: retval
				// token list labels:
				// rule list labels:
				// wildcard labels:
				if (this.state.backtracking == 0) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(
							this.adaptor, "rule retval", retval != null ? retval.tree : null);
					root_0 = (OPPLSyntaxTree) this.adaptor.nil();
					// 149:10: -> ^( TEXT[$AND.text] )
					{
						// /Users/luigi/Documents/workspace/Parsers/src/OPPLTestCaseCombined.g:149:13:
						// ^( TEXT[$AND.text] )
						{
							OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor.nil();
							root_1 = (OPPLSyntaxTree) this.adaptor.becomeRoot(this.adaptor.create(
									TEXT,
									(AND52 != null ? AND52.getText() : null)), root_1);
							this.adaptor.addChild(root_0, root_1);
						}
					}
					retval.tree = root_0;
				}
			}
				break;
			case 12:
				// /Users/luigi/Documents/workspace/Parsers/src/OPPLTestCaseCombined.g:150:6:
				// OR
			{
				OR53 = (Token) this.match(this.input, OR, FOLLOW_OR_in_textBit833);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_OR.add(OR53);
				}
				// AST REWRITE
				// elements:
				// token labels:
				// rule labels: retval
				// token list labels:
				// rule list labels:
				// wildcard labels:
				if (this.state.backtracking == 0) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(
							this.adaptor, "rule retval", retval != null ? retval.tree : null);
					root_0 = (OPPLSyntaxTree) this.adaptor.nil();
					// 150:9: -> ^( TEXT[$OR.text] )
					{
						// /Users/luigi/Documents/workspace/Parsers/src/OPPLTestCaseCombined.g:150:12:
						// ^( TEXT[$OR.text] )
						{
							OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor.nil();
							root_1 = (OPPLSyntaxTree) this.adaptor.becomeRoot(this.adaptor.create(
									TEXT,
									(OR53 != null ? OR53.getText() : null)), root_1);
							this.adaptor.addChild(root_0, root_1);
						}
					}
					retval.tree = root_0;
				}
			}
				break;
			case 13:
				// /Users/luigi/Documents/workspace/Parsers/src/OPPLTestCaseCombined.g:151:6:
				// SOME
			{
				SOME54 = (Token) this.match(this.input, SOME, FOLLOW_SOME_in_textBit848);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_SOME.add(SOME54);
				}
				// AST REWRITE
				// elements:
				// token labels:
				// rule labels: retval
				// token list labels:
				// rule list labels:
				// wildcard labels:
				if (this.state.backtracking == 0) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(
							this.adaptor, "rule retval", retval != null ? retval.tree : null);
					root_0 = (OPPLSyntaxTree) this.adaptor.nil();
					// 151:11: -> ^( TEXT[$SOME.text] )
					{
						// /Users/luigi/Documents/workspace/Parsers/src/OPPLTestCaseCombined.g:151:14:
						// ^( TEXT[$SOME.text] )
						{
							OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor.nil();
							root_1 = (OPPLSyntaxTree) this.adaptor.becomeRoot(this.adaptor.create(
									TEXT,
									(SOME54 != null ? SOME54.getText() : null)), root_1);
							this.adaptor.addChild(root_0, root_1);
						}
					}
					retval.tree = root_0;
				}
			}
				break;
			case 14:
				// /Users/luigi/Documents/workspace/Parsers/src/OPPLTestCaseCombined.g:152:6:
				// ONLY
			{
				ONLY55 = (Token) this.match(this.input, ONLY, FOLLOW_ONLY_in_textBit863);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_ONLY.add(ONLY55);
				}
				// AST REWRITE
				// elements:
				// token labels:
				// rule labels: retval
				// token list labels:
				// rule list labels:
				// wildcard labels:
				if (this.state.backtracking == 0) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(
							this.adaptor, "rule retval", retval != null ? retval.tree : null);
					root_0 = (OPPLSyntaxTree) this.adaptor.nil();
					// 152:11: -> ^( TEXT[$ONLY.text] )
					{
						// /Users/luigi/Documents/workspace/Parsers/src/OPPLTestCaseCombined.g:152:14:
						// ^( TEXT[$ONLY.text] )
						{
							OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor.nil();
							root_1 = (OPPLSyntaxTree) this.adaptor.becomeRoot(this.adaptor.create(
									TEXT,
									(ONLY55 != null ? ONLY55.getText() : null)), root_1);
							this.adaptor.addChild(root_0, root_1);
						}
					}
					retval.tree = root_0;
				}
			}
				break;
			case 15:
				// /Users/luigi/Documents/workspace/Parsers/src/OPPLTestCaseCombined.g:153:6:
				// MIN
			{
				MIN56 = (Token) this.match(this.input, MIN, FOLLOW_MIN_in_textBit878);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_MIN.add(MIN56);
				}
				// AST REWRITE
				// elements:
				// token labels:
				// rule labels: retval
				// token list labels:
				// rule list labels:
				// wildcard labels:
				if (this.state.backtracking == 0) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(
							this.adaptor, "rule retval", retval != null ? retval.tree : null);
					root_0 = (OPPLSyntaxTree) this.adaptor.nil();
					// 153:10: -> ^( TEXT[$MIN.text] )
					{
						// /Users/luigi/Documents/workspace/Parsers/src/OPPLTestCaseCombined.g:153:13:
						// ^( TEXT[$MIN.text] )
						{
							OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor.nil();
							root_1 = (OPPLSyntaxTree) this.adaptor.becomeRoot(this.adaptor.create(
									TEXT,
									(MIN56 != null ? MIN56.getText() : null)), root_1);
							this.adaptor.addChild(root_0, root_1);
						}
					}
					retval.tree = root_0;
				}
			}
				break;
			case 16:
				// /Users/luigi/Documents/workspace/Parsers/src/OPPLTestCaseCombined.g:154:6:
				// MAX
			{
				MAX57 = (Token) this.match(this.input, MAX, FOLLOW_MAX_in_textBit893);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_MAX.add(MAX57);
				}
				// AST REWRITE
				// elements:
				// token labels:
				// rule labels: retval
				// token list labels:
				// rule list labels:
				// wildcard labels:
				if (this.state.backtracking == 0) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(
							this.adaptor, "rule retval", retval != null ? retval.tree : null);
					root_0 = (OPPLSyntaxTree) this.adaptor.nil();
					// 154:10: -> ^( TEXT[$MAX.text] )
					{
						// /Users/luigi/Documents/workspace/Parsers/src/OPPLTestCaseCombined.g:154:13:
						// ^( TEXT[$MAX.text] )
						{
							OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor.nil();
							root_1 = (OPPLSyntaxTree) this.adaptor.becomeRoot(this.adaptor.create(
									TEXT,
									(MAX57 != null ? MAX57.getText() : null)), root_1);
							this.adaptor.addChild(root_0, root_1);
						}
					}
					retval.tree = root_0;
				}
			}
				break;
			case 17:
				// /Users/luigi/Documents/workspace/Parsers/src/OPPLTestCaseCombined.g:155:6:
				// EXACTLY
			{
				EXACTLY58 = (Token) this.match(this.input, EXACTLY, FOLLOW_EXACTLY_in_textBit911);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_EXACTLY.add(EXACTLY58);
				}
				// AST REWRITE
				// elements:
				// token labels:
				// rule labels: retval
				// token list labels:
				// rule list labels:
				// wildcard labels:
				if (this.state.backtracking == 0) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(
							this.adaptor, "rule retval", retval != null ? retval.tree : null);
					root_0 = (OPPLSyntaxTree) this.adaptor.nil();
					// 155:14: -> ^( TEXT[$EXACTLY.text] )
					{
						// /Users/luigi/Documents/workspace/Parsers/src/OPPLTestCaseCombined.g:155:17:
						// ^( TEXT[$EXACTLY.text] )
						{
							OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor.nil();
							root_1 = (OPPLSyntaxTree) this.adaptor.becomeRoot(
									this.adaptor.create(
											TEXT,
											(EXACTLY58 != null ? EXACTLY58.getText() : null)),
									root_1);
							this.adaptor.addChild(root_0, root_1);
						}
					}
					retval.tree = root_0;
				}
			}
				break;
			case 18:
				// /Users/luigi/Documents/workspace/Parsers/src/OPPLTestCaseCombined.g:156:6:
				// VALUE
			{
				VALUE59 = (Token) this.match(this.input, VALUE, FOLLOW_VALUE_in_textBit929);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_VALUE.add(VALUE59);
				}
				// AST REWRITE
				// elements:
				// token labels:
				// rule labels: retval
				// token list labels:
				// rule list labels:
				// wildcard labels:
				if (this.state.backtracking == 0) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(
							this.adaptor, "rule retval", retval != null ? retval.tree : null);
					root_0 = (OPPLSyntaxTree) this.adaptor.nil();
					// 156:12: -> ^( TEXT[$VALUE.text] )
					{
						// /Users/luigi/Documents/workspace/Parsers/src/OPPLTestCaseCombined.g:156:15:
						// ^( TEXT[$VALUE.text] )
						{
							OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor.nil();
							root_1 = (OPPLSyntaxTree) this.adaptor.becomeRoot(this.adaptor.create(
									TEXT,
									(VALUE59 != null ? VALUE59.getText() : null)), root_1);
							this.adaptor.addChild(root_0, root_1);
						}
					}
					retval.tree = root_0;
				}
			}
				break;
			case 19:
				// /Users/luigi/Documents/workspace/Parsers/src/OPPLTestCaseCombined.g:157:6:
				// INVERSE
			{
				INVERSE60 = (Token) this.match(this.input, INVERSE, FOLLOW_INVERSE_in_textBit947);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_INVERSE.add(INVERSE60);
				}
				// AST REWRITE
				// elements:
				// token labels:
				// rule labels: retval
				// token list labels:
				// rule list labels:
				// wildcard labels:
				if (this.state.backtracking == 0) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(
							this.adaptor, "rule retval", retval != null ? retval.tree : null);
					root_0 = (OPPLSyntaxTree) this.adaptor.nil();
					// 157:14: -> ^( TEXT[$INVERSE.text] )
					{
						// /Users/luigi/Documents/workspace/Parsers/src/OPPLTestCaseCombined.g:157:17:
						// ^( TEXT[$INVERSE.text] )
						{
							OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor.nil();
							root_1 = (OPPLSyntaxTree) this.adaptor.becomeRoot(
									this.adaptor.create(
											TEXT,
											(INVERSE60 != null ? INVERSE60.getText() : null)),
									root_1);
							this.adaptor.addChild(root_0, root_1);
						}
					}
					retval.tree = root_0;
				}
			}
				break;
			case 20:
				// /Users/luigi/Documents/workspace/Parsers/src/OPPLTestCaseCombined.g:158:6:
				// DOMAIN
			{
				DOMAIN61 = (Token) this.match(this.input, DOMAIN, FOLLOW_DOMAIN_in_textBit965);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_DOMAIN.add(DOMAIN61);
				}
				// AST REWRITE
				// elements:
				// token labels:
				// rule labels: retval
				// token list labels:
				// rule list labels:
				// wildcard labels:
				if (this.state.backtracking == 0) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(
							this.adaptor, "rule retval", retval != null ? retval.tree : null);
					root_0 = (OPPLSyntaxTree) this.adaptor.nil();
					// 158:13: -> ^( TEXT[$DOMAIN.text] )
					{
						// /Users/luigi/Documents/workspace/Parsers/src/OPPLTestCaseCombined.g:158:16:
						// ^( TEXT[$DOMAIN.text] )
						{
							OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor.nil();
							root_1 = (OPPLSyntaxTree) this.adaptor.becomeRoot(
									this.adaptor.create(
											TEXT,
											(DOMAIN61 != null ? DOMAIN61.getText() : null)),
									root_1);
							this.adaptor.addChild(root_0, root_1);
						}
					}
					retval.tree = root_0;
				}
			}
				break;
			case 21:
				// /Users/luigi/Documents/workspace/Parsers/src/OPPLTestCaseCombined.g:159:6:
				// RANGE
			{
				RANGE62 = (Token) this.match(this.input, RANGE, FOLLOW_RANGE_in_textBit983);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_RANGE.add(RANGE62);
				}
				// AST REWRITE
				// elements:
				// token labels:
				// rule labels: retval
				// token list labels:
				// rule list labels:
				// wildcard labels:
				if (this.state.backtracking == 0) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(
							this.adaptor, "rule retval", retval != null ? retval.tree : null);
					root_0 = (OPPLSyntaxTree) this.adaptor.nil();
					// 159:12: -> ^( TEXT[$RANGE.text] )
					{
						// /Users/luigi/Documents/workspace/Parsers/src/OPPLTestCaseCombined.g:159:15:
						// ^( TEXT[$RANGE.text] )
						{
							OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor.nil();
							root_1 = (OPPLSyntaxTree) this.adaptor.becomeRoot(this.adaptor.create(
									TEXT,
									(RANGE62 != null ? RANGE62.getText() : null)), root_1);
							this.adaptor.addChild(root_0, root_1);
						}
					}
					retval.tree = root_0;
				}
			}
				break;
			case 22:
				// /Users/luigi/Documents/workspace/Parsers/src/OPPLTestCaseCombined.g:160:6:
				// TYPES
			{
				TYPES63 = (Token) this.match(this.input, TYPES, FOLLOW_TYPES_in_textBit998);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_TYPES.add(TYPES63);
				}
				// AST REWRITE
				// elements:
				// token labels:
				// rule labels: retval
				// token list labels:
				// rule list labels:
				// wildcard labels:
				if (this.state.backtracking == 0) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(
							this.adaptor, "rule retval", retval != null ? retval.tree : null);
					root_0 = (OPPLSyntaxTree) this.adaptor.nil();
					// 160:12: -> ^( TEXT[$TYPES.text] )
					{
						// /Users/luigi/Documents/workspace/Parsers/src/OPPLTestCaseCombined.g:160:15:
						// ^( TEXT[$TYPES.text] )
						{
							OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor.nil();
							root_1 = (OPPLSyntaxTree) this.adaptor.becomeRoot(this.adaptor.create(
									TEXT,
									(TYPES63 != null ? TYPES63.getText() : null)), root_1);
							this.adaptor.addChild(root_0, root_1);
						}
					}
					retval.tree = root_0;
				}
			}
				break;
			case 23:
				// /Users/luigi/Documents/workspace/Parsers/src/OPPLTestCaseCombined.g:161:6:
				// INTEGER
			{
				INTEGER64 = (Token) this.match(this.input, INTEGER, FOLLOW_INTEGER_in_textBit1019);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_INTEGER.add(INTEGER64);
				}
				// AST REWRITE
				// elements:
				// token labels:
				// rule labels: retval
				// token list labels:
				// rule list labels:
				// wildcard labels:
				if (this.state.backtracking == 0) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(
							this.adaptor, "rule retval", retval != null ? retval.tree : null);
					root_0 = (OPPLSyntaxTree) this.adaptor.nil();
					// 161:14: -> ^( TEXT[$INTEGER.text] )
					{
						// /Users/luigi/Documents/workspace/Parsers/src/OPPLTestCaseCombined.g:161:17:
						// ^( TEXT[$INTEGER.text] )
						{
							OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor.nil();
							root_1 = (OPPLSyntaxTree) this.adaptor.becomeRoot(
									this.adaptor.create(
											TEXT,
											(INTEGER64 != null ? INTEGER64.getText() : null)),
									root_1);
							this.adaptor.addChild(root_0, root_1);
						}
					}
					retval.tree = root_0;
				}
			}
				break;
			case 24:
				// /Users/luigi/Documents/workspace/Parsers/src/OPPLTestCaseCombined.g:162:6:
				// COUNT
			{
				COUNT65 = (Token) this.match(this.input, COUNT, FOLLOW_COUNT_in_textBit1040);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_COUNT.add(COUNT65);
				}
				// AST REWRITE
				// elements:
				// token labels:
				// rule labels: retval
				// token list labels:
				// rule list labels:
				// wildcard labels:
				if (this.state.backtracking == 0) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(
							this.adaptor, "rule retval", retval != null ? retval.tree : null);
					root_0 = (OPPLSyntaxTree) this.adaptor.nil();
					// 162:12: -> ^( TEXT[$COUNT.text] )
					{
						// /Users/luigi/Documents/workspace/Parsers/src/OPPLTestCaseCombined.g:162:15:
						// ^( TEXT[$COUNT.text] )
						{
							OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor.nil();
							root_1 = (OPPLSyntaxTree) this.adaptor.becomeRoot(this.adaptor.create(
									TEXT,
									(COUNT65 != null ? COUNT65.getText() : null)), root_1);
							this.adaptor.addChild(root_0, root_1);
						}
					}
					retval.tree = root_0;
				}
			}
				break;
			case 25:
				// /Users/luigi/Documents/workspace/Parsers/src/OPPLTestCaseCombined.g:163:6:
				// EQUAL
			{
				EQUAL66 = (Token) this.match(this.input, EQUAL, FOLLOW_EQUAL_in_textBit1058);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_EQUAL.add(EQUAL66);
				}
				// AST REWRITE
				// elements:
				// token labels:
				// rule labels: retval
				// token list labels:
				// rule list labels:
				// wildcard labels:
				if (this.state.backtracking == 0) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(
							this.adaptor, "rule retval", retval != null ? retval.tree : null);
					root_0 = (OPPLSyntaxTree) this.adaptor.nil();
					// 163:12: -> ^( TEXT[$EQUAL.text] )
					{
						// /Users/luigi/Documents/workspace/Parsers/src/OPPLTestCaseCombined.g:163:15:
						// ^( TEXT[$EQUAL.text] )
						{
							OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor.nil();
							root_1 = (OPPLSyntaxTree) this.adaptor.becomeRoot(this.adaptor.create(
									TEXT,
									(EQUAL66 != null ? EQUAL66.getText() : null)), root_1);
							this.adaptor.addChild(root_0, root_1);
						}
					}
					retval.tree = root_0;
				}
			}
				break;
			}
			retval.stop = this.input.LT(-1);
			if (this.state.backtracking == 0) {
				retval.tree = (OPPLSyntaxTree) this.adaptor.rulePostProcessing(root_0);
				this.adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		} catch (RecognitionException exception) {
			if (this.errorListener != null) {
				this.errorListener.recognitionException(exception);
			}
		} catch (RewriteEmptyStreamException exception) {
			if (this.errorListener != null) {
				this.errorListener.rewriteEmptyStreamException(exception);
			}
		} finally {
		}
		return retval;
	}

	// $ANTLR end "textBit"
	public static class statement_return extends ParserRuleReturnScope {
		OPPLSyntaxTree tree;

		@Override
		public Object getTree() {
			return this.tree;
		}
	};

	// $ANTLR start "statement"
	// /Users/luigi/Documents/workspace/Parsers/src/OPPLTestCaseCombined.g:166:1:
	// statement : ( variableDefinitions )? query -> ^( OPPL_STATEMENT (
	// variableDefinitions )? query ) ;
	public final OPPLTestCaseCombinedParser.statement_return statement()
			throws RecognitionException {
		OPPLTestCaseCombinedParser.statement_return retval = new OPPLTestCaseCombinedParser.statement_return();
		retval.start = this.input.LT(1);
		OPPLSyntaxTree root_0 = null;
		OPPLTestCaseCombined_OPPLParser.variableDefinitions_return variableDefinitions67 = null;
		OPPLTestCaseCombined_OPPLParser.query_return query68 = null;
		RewriteRuleSubtreeStream stream_query = new RewriteRuleSubtreeStream(this.adaptor,
				"rule query");
		RewriteRuleSubtreeStream stream_variableDefinitions = new RewriteRuleSubtreeStream(
				this.adaptor, "rule variableDefinitions");
		try {
			// /Users/luigi/Documents/workspace/Parsers/src/OPPLTestCaseCombined.g:167:3:
			// ( ( variableDefinitions )? query -> ^( OPPL_STATEMENT (
			// variableDefinitions )? query ) )
			// /Users/luigi/Documents/workspace/Parsers/src/OPPLTestCaseCombined.g:168:5:
			// ( variableDefinitions )? query
			{
				// /Users/luigi/Documents/workspace/Parsers/src/OPPLTestCaseCombined.g:168:5:
				// ( variableDefinitions )?
				int alt10 = 2;
				int LA10_0 = this.input.LA(1);
				if (LA10_0 == VARIABLE_NAME) {
					alt10 = 1;
				}
				switch (alt10) {
				case 1:
					// /Users/luigi/Documents/workspace/Parsers/src/OPPLTestCaseCombined.g:168:5:
					// variableDefinitions
				{
					this.pushFollow(FOLLOW_variableDefinitions_in_statement1087);
					variableDefinitions67 = this.variableDefinitions();
					this.state._fsp--;
					if (this.state.failed) {
						return retval;
					}
					if (this.state.backtracking == 0) {
						stream_variableDefinitions.add(variableDefinitions67.getTree());
					}
				}
					break;
				}
				this.pushFollow(FOLLOW_query_in_statement1090);
				query68 = this.query();
				this.state._fsp--;
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_query.add(query68.getTree());
				}
				// AST REWRITE
				// elements: query, variableDefinitions
				// token labels:
				// rule labels: retval
				// token list labels:
				// rule list labels:
				// wildcard labels:
				if (this.state.backtracking == 0) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(
							this.adaptor, "rule retval", retval != null ? retval.tree : null);
					root_0 = (OPPLSyntaxTree) this.adaptor.nil();
					// 168:33: -> ^( OPPL_STATEMENT ( variableDefinitions )?
					// query )
					{
						// /Users/luigi/Documents/workspace/Parsers/src/OPPLTestCaseCombined.g:168:36:
						// ^( OPPL_STATEMENT ( variableDefinitions )? query )
						{
							OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor.nil();
							root_1 = (OPPLSyntaxTree) this.adaptor.becomeRoot(
									this.adaptor.create(OPPL_STATEMENT, "OPPL_STATEMENT"),
									root_1);
							// /Users/luigi/Documents/workspace/Parsers/src/OPPLTestCaseCombined.g:168:53:
							// ( variableDefinitions )?
							if (stream_variableDefinitions.hasNext()) {
								this.adaptor.addChild(root_1, stream_variableDefinitions.nextTree());
							}
							stream_variableDefinitions.reset();
							this.adaptor.addChild(root_1, stream_query.nextTree());
							this.adaptor.addChild(root_0, root_1);
						}
					}
					retval.tree = root_0;
				}
			}
			retval.stop = this.input.LT(-1);
			if (this.state.backtracking == 0) {
				retval.tree = (OPPLSyntaxTree) this.adaptor.rulePostProcessing(root_0);
				this.adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		} catch (RecognitionException exception) {
			if (this.errorListener != null) {
				this.errorListener.recognitionException(exception);
			}
		} catch (RewriteEmptyStreamException exception) {
			if (this.errorListener != null) {
				this.errorListener.rewriteEmptyStreamException(exception);
			}
		} finally {
		}
		return retval;
	}

	// $ANTLR end "statement"
	// $ANTLR start synpred1_OPPLTestCaseCombined
	public final void synpred1_OPPLTestCaseCombined_fragment() throws RecognitionException {
		OPPLTestCaseCombinedParser.assertionExpression_return left = null;
		OPPLTestCaseCombinedParser.assertionExpression_return right = null;
		// /Users/luigi/Documents/workspace/Parsers/src/OPPLTestCaseCombined.g:96:3:
		// (left= assertionExpression EQUAL right= assertionExpression )
		// /Users/luigi/Documents/workspace/Parsers/src/OPPLTestCaseCombined.g:96:3:
		// left= assertionExpression EQUAL right= assertionExpression
		{
			this.pushFollow(FOLLOW_assertionExpression_in_synpred1_OPPLTestCaseCombined269);
			left = this.assertionExpression();
			this.state._fsp--;
			if (this.state.failed) {
				return;
			}
			this.match(this.input, EQUAL, FOLLOW_EQUAL_in_synpred1_OPPLTestCaseCombined271);
			if (this.state.failed) {
				return;
			}
			this.pushFollow(FOLLOW_assertionExpression_in_synpred1_OPPLTestCaseCombined276);
			right = this.assertionExpression();
			this.state._fsp--;
			if (this.state.failed) {
				return;
			}
		}
	}

	// $ANTLR end synpred1_OPPLTestCaseCombined
	// $ANTLR start synpred2_OPPLTestCaseCombined
	public final void synpred2_OPPLTestCaseCombined_fragment() throws RecognitionException {
		OPPLTestCaseCombinedParser.assertionExpression_return left = null;
		OPPLTestCaseCombinedParser.assertionExpression_return right = null;
		// /Users/luigi/Documents/workspace/Parsers/src/OPPLTestCaseCombined.g:97:5:
		// (left= assertionExpression NOT_EQUAL right= assertionExpression )
		// /Users/luigi/Documents/workspace/Parsers/src/OPPLTestCaseCombined.g:97:5:
		// left= assertionExpression NOT_EQUAL right= assertionExpression
		{
			this.pushFollow(FOLLOW_assertionExpression_in_synpred2_OPPLTestCaseCombined297);
			left = this.assertionExpression();
			this.state._fsp--;
			if (this.state.failed) {
				return;
			}
			this.match(this.input, NOT_EQUAL, FOLLOW_NOT_EQUAL_in_synpred2_OPPLTestCaseCombined299);
			if (this.state.failed) {
				return;
			}
			this.pushFollow(FOLLOW_assertionExpression_in_synpred2_OPPLTestCaseCombined304);
			right = this.assertionExpression();
			this.state._fsp--;
			if (this.state.failed) {
				return;
			}
		}
	}

	// $ANTLR end synpred2_OPPLTestCaseCombined
	// $ANTLR start synpred3_OPPLTestCaseCombined
	public final void synpred3_OPPLTestCaseCombined_fragment() throws RecognitionException {
		OPPLTestCaseCombinedParser.assertionExpression_return left = null;
		OPPLTestCaseCombinedParser.assertionExpression_return right = null;
		// /Users/luigi/Documents/workspace/Parsers/src/OPPLTestCaseCombined.g:98:5:
		// (left= assertionExpression LESS_THAN right= assertionExpression )
		// /Users/luigi/Documents/workspace/Parsers/src/OPPLTestCaseCombined.g:98:5:
		// left= assertionExpression LESS_THAN right= assertionExpression
		{
			this.pushFollow(FOLLOW_assertionExpression_in_synpred3_OPPLTestCaseCombined325);
			left = this.assertionExpression();
			this.state._fsp--;
			if (this.state.failed) {
				return;
			}
			this.match(this.input, LESS_THAN, FOLLOW_LESS_THAN_in_synpred3_OPPLTestCaseCombined327);
			if (this.state.failed) {
				return;
			}
			this.pushFollow(FOLLOW_assertionExpression_in_synpred3_OPPLTestCaseCombined332);
			right = this.assertionExpression();
			this.state._fsp--;
			if (this.state.failed) {
				return;
			}
		}
	}

	// $ANTLR end synpred3_OPPLTestCaseCombined
	// $ANTLR start synpred4_OPPLTestCaseCombined
	public final void synpred4_OPPLTestCaseCombined_fragment() throws RecognitionException {
		OPPLTestCaseCombinedParser.assertionExpression_return left = null;
		OPPLTestCaseCombinedParser.assertionExpression_return right = null;
		// /Users/luigi/Documents/workspace/Parsers/src/OPPLTestCaseCombined.g:99:5:
		// (left= assertionExpression LESS_THAN_EQUAL right= assertionExpression
		// )
		// /Users/luigi/Documents/workspace/Parsers/src/OPPLTestCaseCombined.g:99:5:
		// left= assertionExpression LESS_THAN_EQUAL right= assertionExpression
		{
			this.pushFollow(FOLLOW_assertionExpression_in_synpred4_OPPLTestCaseCombined353);
			left = this.assertionExpression();
			this.state._fsp--;
			if (this.state.failed) {
				return;
			}
			this.match(
					this.input,
					LESS_THAN_EQUAL,
					FOLLOW_LESS_THAN_EQUAL_in_synpred4_OPPLTestCaseCombined355);
			if (this.state.failed) {
				return;
			}
			this.pushFollow(FOLLOW_assertionExpression_in_synpred4_OPPLTestCaseCombined360);
			right = this.assertionExpression();
			this.state._fsp--;
			if (this.state.failed) {
				return;
			}
		}
	}

	// $ANTLR end synpred4_OPPLTestCaseCombined
	// $ANTLR start synpred5_OPPLTestCaseCombined
	public final void synpred5_OPPLTestCaseCombined_fragment() throws RecognitionException {
		OPPLTestCaseCombinedParser.assertionExpression_return left = null;
		OPPLTestCaseCombinedParser.assertionExpression_return right = null;
		// /Users/luigi/Documents/workspace/Parsers/src/OPPLTestCaseCombined.g:100:5:
		// (left= assertionExpression GREATER_THAN right= assertionExpression )
		// /Users/luigi/Documents/workspace/Parsers/src/OPPLTestCaseCombined.g:100:5:
		// left= assertionExpression GREATER_THAN right= assertionExpression
		{
			this.pushFollow(FOLLOW_assertionExpression_in_synpred5_OPPLTestCaseCombined383);
			left = this.assertionExpression();
			this.state._fsp--;
			if (this.state.failed) {
				return;
			}
			this.match(
					this.input,
					GREATER_THAN,
					FOLLOW_GREATER_THAN_in_synpred5_OPPLTestCaseCombined385);
			if (this.state.failed) {
				return;
			}
			this.pushFollow(FOLLOW_assertionExpression_in_synpred5_OPPLTestCaseCombined390);
			right = this.assertionExpression();
			this.state._fsp--;
			if (this.state.failed) {
				return;
			}
		}
	}

	// $ANTLR end synpred5_OPPLTestCaseCombined
	// $ANTLR start synpred6_OPPLTestCaseCombined
	public final void synpred6_OPPLTestCaseCombined_fragment() throws RecognitionException {
		OPPLTestCaseCombinedParser.assertionExpression_return left = null;
		OPPLTestCaseCombinedParser.assertionExpression_return right = null;
		// /Users/luigi/Documents/workspace/Parsers/src/OPPLTestCaseCombined.g:101:5:
		// (left= assertionExpression GREATER_THAN_EQUAL right=
		// assertionExpression )
		// /Users/luigi/Documents/workspace/Parsers/src/OPPLTestCaseCombined.g:101:5:
		// left= assertionExpression GREATER_THAN_EQUAL right=
		// assertionExpression
		{
			this.pushFollow(FOLLOW_assertionExpression_in_synpred6_OPPLTestCaseCombined413);
			left = this.assertionExpression();
			this.state._fsp--;
			if (this.state.failed) {
				return;
			}
			this.match(
					this.input,
					GREATER_THAN_EQUAL,
					FOLLOW_GREATER_THAN_EQUAL_in_synpred6_OPPLTestCaseCombined415);
			if (this.state.failed) {
				return;
			}
			this.pushFollow(FOLLOW_assertionExpression_in_synpred6_OPPLTestCaseCombined420);
			right = this.assertionExpression();
			this.state._fsp--;
			if (this.state.failed) {
				return;
			}
		}
	}

	// $ANTLR end synpred6_OPPLTestCaseCombined
	// $ANTLR start synpred7_OPPLTestCaseCombined
	public final void synpred7_OPPLTestCaseCombined_fragment() throws RecognitionException {
		// /Users/luigi/Documents/workspace/Parsers/src/OPPLTestCaseCombined.g:102:5:
		// ( VARIABLE_NAME CONTAINS assertionExpression ( COMMA
		// assertionExpression )* )
		// /Users/luigi/Documents/workspace/Parsers/src/OPPLTestCaseCombined.g:102:5:
		// VARIABLE_NAME CONTAINS assertionExpression ( COMMA
		// assertionExpression )*
		{
			this.match(
					this.input,
					VARIABLE_NAME,
					FOLLOW_VARIABLE_NAME_in_synpred7_OPPLTestCaseCombined440);
			if (this.state.failed) {
				return;
			}
			this.match(this.input, CONTAINS, FOLLOW_CONTAINS_in_synpred7_OPPLTestCaseCombined443);
			if (this.state.failed) {
				return;
			}
			this.pushFollow(FOLLOW_assertionExpression_in_synpred7_OPPLTestCaseCombined445);
			this.assertionExpression();
			this.state._fsp--;
			if (this.state.failed) {
				return;
			}
			// /Users/luigi/Documents/workspace/Parsers/src/OPPLTestCaseCombined.g:102:49:
			// ( COMMA assertionExpression )*
			loop11: do {
				int alt11 = 2;
				int LA11_0 = this.input.LA(1);
				if (LA11_0 == COMMA) {
					alt11 = 1;
				}
				switch (alt11) {
				case 1:
					// /Users/luigi/Documents/workspace/Parsers/src/OPPLTestCaseCombined.g:102:50:
					// COMMA assertionExpression
				{
					this.match(this.input, COMMA, FOLLOW_COMMA_in_synpred7_OPPLTestCaseCombined448);
					if (this.state.failed) {
						return;
					}
					this.pushFollow(FOLLOW_assertionExpression_in_synpred7_OPPLTestCaseCombined450);
					this.assertionExpression();
					this.state._fsp--;
					if (this.state.failed) {
						return;
					}
				}
					break;
				default:
					break loop11;
				}
			} while (true);
		}
	}

	// $ANTLR end synpred7_OPPLTestCaseCombined
	// Delegated rules
	public OPPLTestCaseCombined_OPPLParser_MOWLParser.oneOf_return oneOf()
			throws RecognitionException {
		return this.gMOWLParser.oneOf();
	}

	public OPPLTestCaseCombined_OPPLParser_MOWLParser.cardinalityRestriction_return cardinalityRestriction()
			throws RecognitionException {
		return this.gMOWLParser.cardinalityRestriction();
	}

	public OPPLTestCaseCombined_OPPLParser_MOWLParser.unary_return unary()
			throws RecognitionException {
		return this.gMOWLParser.unary();
	}

	public OPPLTestCaseCombined_OPPLParser.stringOperation_return stringOperation()
			throws RecognitionException {
		return this.gOPPLParser.stringOperation();
	}

	public OPPLTestCaseCombined_OPPLParser.stringExpression_return stringExpression()
			throws RecognitionException {
		return this.gOPPLParser.stringExpression();
	}

	public OPPLTestCaseCombined_OPPLParser_MOWLParser.annotationAssertionAxiom_return annotationAssertionAxiom()
			throws RecognitionException {
		return this.gMOWLParser.annotationAssertionAxiom();
	}

	public OPPLTestCaseCombined_OPPLParser_MOWLParser.constant_return constant()
			throws RecognitionException {
		return this.gMOWLParser.constant();
	}

	public OPPLTestCaseCombined_OPPLParser.atomic_return atomic() throws RecognitionException {
		return this.gOPPLParser.atomic();
	}

	public OPPLTestCaseCombined_OPPLParser_MOWLParser.expression_return expression()
			throws RecognitionException {
		return this.gMOWLParser.expression();
	}

	public OPPLTestCaseCombined_OPPLParser_MOWLParser.valueRestriction_return valueRestriction()
			throws RecognitionException {
		return this.gMOWLParser.valueRestriction();
	}

	public OPPLTestCaseCombined_OPPLParser_MOWLParser.propertyExpression_return propertyExpression()
			throws RecognitionException {
		return this.gMOWLParser.propertyExpression();
	}

	public OPPLTestCaseCombined_OPPLParser_MOWLParser.qualifiedRestriction_return qualifiedRestriction()
			throws RecognitionException {
		return this.gMOWLParser.qualifiedRestriction();
	}

	public OPPLTestCaseCombined_OPPLParser_MOWLParser.value_return value()
			throws RecognitionException {
		return this.gMOWLParser.value();
	}

	public OPPLTestCaseCombined_OPPLParser.regexp_return regexp() throws RecognitionException {
		return this.gOPPLParser.regexp();
	}

	public OPPLTestCaseCombined_OPPLParser.variableAttributeReference_return variableAttributeReference()
			throws RecognitionException {
		return this.gOPPLParser.variableAttributeReference();
	}

	public OPPLTestCaseCombined_OPPLParser.createIdentifier_return createIdentifier()
			throws RecognitionException {
		return this.gOPPLParser.createIdentifier();
	}

	public OPPLTestCaseCombined_OPPLParser.selectClause_return selectClause()
			throws RecognitionException {
		return this.gOPPLParser.selectClause();
	}

	public OPPLTestCaseCombined_OPPLParser_MOWLParser.axiom_return axiom()
			throws RecognitionException {
		return this.gMOWLParser.axiom();
	}

	public OPPLTestCaseCombined_OPPLParser.variableScope_return variableScope()
			throws RecognitionException {
		return this.gOPPLParser.variableScope();
	}

	public OPPLTestCaseCombined_OPPLParser.opplFunction_return opplFunction()
			throws RecognitionException {
		return this.gOPPLParser.opplFunction();
	}

	public OPPLTestCaseCombined_OPPLParser.iri_return iri() throws RecognitionException {
		return this.gOPPLParser.iri();
	}

	public OPPLTestCaseCombined_OPPLParser_MOWLParser.unaryCharacteristic_return unaryCharacteristic()
			throws RecognitionException {
		return this.gMOWLParser.unaryCharacteristic();
	}

	public OPPLTestCaseCombined_OPPLParser_MOWLParser.restrictionKind_return restrictionKind()
			throws RecognitionException {
		return this.gMOWLParser.restrictionKind();
	}

	public OPPLTestCaseCombined_OPPLParser_MOWLParser.binaryAxiom_return binaryAxiom()
			throws RecognitionException {
		return this.gMOWLParser.binaryAxiom();
	}

	public OPPLTestCaseCombined_OPPLParser_MOWLParser.unaryAxiom_return unaryAxiom()
			throws RecognitionException {
		return this.gMOWLParser.unaryAxiom();
	}

	public OPPLTestCaseCombined_OPPLParser.variableDefinition_return variableDefinition()
			throws RecognitionException {
		return this.gOPPLParser.variableDefinition();
	}

	public OPPLTestCaseCombined_OPPLParser.constraint_return constraint()
			throws RecognitionException {
		return this.gOPPLParser.constraint();
	}

	public OPPLTestCaseCombined_OPPLParser.query_return query() throws RecognitionException {
		return this.gOPPLParser.query();
	}

	public OPPLTestCaseCombined_OPPLParser_MOWLParser.assertionAxiom_return assertionAxiom()
			throws RecognitionException {
		return this.gMOWLParser.assertionAxiom();
	}

	public OPPLTestCaseCombined_OPPLParser.actions_return actions() throws RecognitionException {
		return this.gOPPLParser.actions();
	}

	public OPPLTestCaseCombined_OPPLParser_MOWLParser.hasKeyAxiom_return hasKeyAxiom()
			throws RecognitionException {
		return this.gMOWLParser.hasKeyAxiom();
	}

	public OPPLTestCaseCombined_OPPLParser_MOWLParser.dataRangeFacet_return dataRangeFacet()
			throws RecognitionException {
		return this.gMOWLParser.dataRangeFacet();
	}

	public OPPLTestCaseCombined_OPPLParser.action_return action() throws RecognitionException {
		return this.gOPPLParser.action();
	}

	public OPPLTestCaseCombined_OPPLParser.attributeSelector_return attributeSelector()
			throws RecognitionException {
		return this.gOPPLParser.attributeSelector();
	}

	public OPPLTestCaseCombined_OPPLParser_MOWLParser.complexPropertyExpression_return complexPropertyExpression()
			throws RecognitionException {
		return this.gMOWLParser.complexPropertyExpression();
	}

	public OPPLTestCaseCombined_OPPLParser.variableDefinitions_return variableDefinitions()
			throws RecognitionException {
		return this.gOPPLParser.variableDefinitions();
	}

	public OPPLTestCaseCombined_OPPLParser_MOWLParser.dataRange_return dataRange()
			throws RecognitionException {
		return this.gMOWLParser.dataRange();
	}

	public OPPLTestCaseCombined_OPPLParser_MOWLParser.conjunction_return conjunction()
			throws RecognitionException {
		return this.gMOWLParser.conjunction();
	}

	public final boolean synpred2_OPPLTestCaseCombined() {
		this.state.backtracking++;
		int start = this.input.mark();
		try {
			this.synpred2_OPPLTestCaseCombined_fragment(); // can never throw
															// exception
		} catch (RecognitionException re) {
			System.err.println("impossible: " + re);
		}
		boolean success = !this.state.failed;
		this.input.rewind(start);
		this.state.backtracking--;
		this.state.failed = false;
		return success;
	}

	public final boolean synpred3_OPPLTestCaseCombined() {
		this.state.backtracking++;
		int start = this.input.mark();
		try {
			this.synpred3_OPPLTestCaseCombined_fragment(); // can never throw
															// exception
		} catch (RecognitionException re) {
			System.err.println("impossible: " + re);
		}
		boolean success = !this.state.failed;
		this.input.rewind(start);
		this.state.backtracking--;
		this.state.failed = false;
		return success;
	}

	public final boolean synpred1_OPPLTestCaseCombined() {
		this.state.backtracking++;
		int start = this.input.mark();
		try {
			this.synpred1_OPPLTestCaseCombined_fragment(); // can never throw
															// exception
		} catch (RecognitionException re) {
			System.err.println("impossible: " + re);
		}
		boolean success = !this.state.failed;
		this.input.rewind(start);
		this.state.backtracking--;
		this.state.failed = false;
		return success;
	}

	public final boolean synpred5_OPPLTestCaseCombined() {
		this.state.backtracking++;
		int start = this.input.mark();
		try {
			this.synpred5_OPPLTestCaseCombined_fragment(); // can never throw
															// exception
		} catch (RecognitionException re) {
			System.err.println("impossible: " + re);
		}
		boolean success = !this.state.failed;
		this.input.rewind(start);
		this.state.backtracking--;
		this.state.failed = false;
		return success;
	}

	public final boolean synpred7_OPPLTestCaseCombined() {
		this.state.backtracking++;
		int start = this.input.mark();
		try {
			this.synpred7_OPPLTestCaseCombined_fragment(); // can never throw
															// exception
		} catch (RecognitionException re) {
			System.err.println("impossible: " + re);
		}
		boolean success = !this.state.failed;
		this.input.rewind(start);
		this.state.backtracking--;
		this.state.failed = false;
		return success;
	}

	public final boolean synpred6_OPPLTestCaseCombined() {
		this.state.backtracking++;
		int start = this.input.mark();
		try {
			this.synpred6_OPPLTestCaseCombined_fragment(); // can never throw
															// exception
		} catch (RecognitionException re) {
			System.err.println("impossible: " + re);
		}
		boolean success = !this.state.failed;
		this.input.rewind(start);
		this.state.backtracking--;
		this.state.failed = false;
		return success;
	}

	public final boolean synpred4_OPPLTestCaseCombined() {
		this.state.backtracking++;
		int start = this.input.mark();
		try {
			this.synpred4_OPPLTestCaseCombined_fragment(); // can never throw
															// exception
		} catch (RecognitionException re) {
			System.err.println("impossible: " + re);
		}
		boolean success = !this.state.failed;
		this.input.rewind(start);
		this.state.backtracking--;
		this.state.failed = false;
		return success;
	}

	protected DFA5 dfa5 = new DFA5(this);
	static final String DFA5_eotS = "\24\uffff";
	static final String DFA5_eofS = "\24\uffff";
	static final String DFA5_minS = "\1\5\13\0\10\uffff";
	static final String DFA5_maxS = "\1\u01d4\13\0\10\uffff";
	static final String DFA5_acceptS = "\14\uffff\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10";
	static final String DFA5_specialS = "\1\uffff\1\0\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\10\uffff}>";
	static final String[] DFA5_transitionS = {
			"\1\13\1\11\5\uffff\1\10\6\uffff\1\7\24\uffff\1\12\1\uffff\1"
					+ "\2\1\uffff\1\3\1\4\147\uffff\1\6\u013a\uffff\1\5\3\uffff\1\1", "\1\uffff",
			"\1\uffff", "\1\uffff", "\1\uffff", "\1\uffff", "\1\uffff", "\1\uffff", "\1\uffff",
			"\1\uffff", "\1\uffff", "\1\uffff", "", "", "", "", "", "", "", "" };
	static final short[] DFA5_eot = DFA.unpackEncodedString(DFA5_eotS);
	static final short[] DFA5_eof = DFA.unpackEncodedString(DFA5_eofS);
	static final char[] DFA5_min = DFA.unpackEncodedStringToUnsignedChars(DFA5_minS);
	static final char[] DFA5_max = DFA.unpackEncodedStringToUnsignedChars(DFA5_maxS);
	static final short[] DFA5_accept = DFA.unpackEncodedString(DFA5_acceptS);
	static final short[] DFA5_special = DFA.unpackEncodedString(DFA5_specialS);
	static final short[][] DFA5_transition;
	static {
		int numStates = DFA5_transitionS.length;
		DFA5_transition = new short[numStates][];
		for (int i = 0; i < numStates; i++) {
			DFA5_transition[i] = DFA.unpackEncodedString(DFA5_transitionS[i]);
		}
	}

	class DFA5 extends DFA {
		public DFA5(BaseRecognizer recognizer) {
			this.recognizer = recognizer;
			this.decisionNumber = 5;
			this.eot = DFA5_eot;
			this.eof = DFA5_eof;
			this.min = DFA5_min;
			this.max = DFA5_max;
			this.accept = DFA5_accept;
			this.special = DFA5_special;
			this.transition = DFA5_transition;
		}

		@Override
		public String getDescription() {
			return "94:1: assertion options {backtrack=true; } : (left= assertionExpression EQUAL right= assertionExpression -> ^( ASSERT_EQUAL $left $right) | left= assertionExpression NOT_EQUAL right= assertionExpression -> ^( ASSERT_NOT_EQUAL $left $right) | left= assertionExpression LESS_THAN right= assertionExpression -> ^( ASSERT_LESS_THAN $left $right) | left= assertionExpression LESS_THAN_EQUAL right= assertionExpression -> ^( ASSERT_LESS_THAN_EQUAL $left $right) | left= assertionExpression GREATER_THAN right= assertionExpression -> ^( ASSERT_GREATER_THAN $left $right) | left= assertionExpression GREATER_THAN_EQUAL right= assertionExpression -> ^( ASSERT_GREATER_THAN_EQUAL $left $right) | VARIABLE_NAME CONTAINS assertionExpression ( COMMA assertionExpression )* -> ^( CONTAINS VARIABLE_NAME ( assertionExpression )+ ) | NOT OPEN_PARENTHESYS assertion CLOSED_PARENTHESYS -> ^( NOT assertion ) );";
		}

		@Override
		public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
			TokenStream input = (TokenStream) _input;
			int _s = s;
			switch (s) {
			case 0:
				int LA5_1 = input.LA(1);
				int index5_1 = input.index();
				input.rewind();
				s = -1;
				if (OPPLTestCaseCombinedParser.this.synpred1_OPPLTestCaseCombined()) {
					s = 12;
				} else if (OPPLTestCaseCombinedParser.this.synpred2_OPPLTestCaseCombined()) {
					s = 13;
				} else if (OPPLTestCaseCombinedParser.this.synpred3_OPPLTestCaseCombined()) {
					s = 14;
				} else if (OPPLTestCaseCombinedParser.this.synpred4_OPPLTestCaseCombined()) {
					s = 15;
				} else if (OPPLTestCaseCombinedParser.this.synpred5_OPPLTestCaseCombined()) {
					s = 16;
				} else if (OPPLTestCaseCombinedParser.this.synpred6_OPPLTestCaseCombined()) {
					s = 17;
				}
				input.seek(index5_1);
				if (s >= 0) {
					return s;
				}
				break;
			case 1:
				int LA5_2 = input.LA(1);
				int index5_2 = input.index();
				input.rewind();
				s = -1;
				if (OPPLTestCaseCombinedParser.this.synpred1_OPPLTestCaseCombined()) {
					s = 12;
				} else if (OPPLTestCaseCombinedParser.this.synpred2_OPPLTestCaseCombined()) {
					s = 13;
				} else if (OPPLTestCaseCombinedParser.this.synpred3_OPPLTestCaseCombined()) {
					s = 14;
				} else if (OPPLTestCaseCombinedParser.this.synpred4_OPPLTestCaseCombined()) {
					s = 15;
				} else if (OPPLTestCaseCombinedParser.this.synpred5_OPPLTestCaseCombined()) {
					s = 16;
				} else if (OPPLTestCaseCombinedParser.this.synpred6_OPPLTestCaseCombined()) {
					s = 17;
				}
				input.seek(index5_2);
				if (s >= 0) {
					return s;
				}
				break;
			case 2:
				int LA5_3 = input.LA(1);
				int index5_3 = input.index();
				input.rewind();
				s = -1;
				if (OPPLTestCaseCombinedParser.this.synpred1_OPPLTestCaseCombined()) {
					s = 12;
				} else if (OPPLTestCaseCombinedParser.this.synpred2_OPPLTestCaseCombined()) {
					s = 13;
				} else if (OPPLTestCaseCombinedParser.this.synpred3_OPPLTestCaseCombined()) {
					s = 14;
				} else if (OPPLTestCaseCombinedParser.this.synpred4_OPPLTestCaseCombined()) {
					s = 15;
				} else if (OPPLTestCaseCombinedParser.this.synpred5_OPPLTestCaseCombined()) {
					s = 16;
				} else if (OPPLTestCaseCombinedParser.this.synpred6_OPPLTestCaseCombined()) {
					s = 17;
				}
				input.seek(index5_3);
				if (s >= 0) {
					return s;
				}
				break;
			case 3:
				int LA5_4 = input.LA(1);
				int index5_4 = input.index();
				input.rewind();
				s = -1;
				if (OPPLTestCaseCombinedParser.this.synpred1_OPPLTestCaseCombined()) {
					s = 12;
				} else if (OPPLTestCaseCombinedParser.this.synpred2_OPPLTestCaseCombined()) {
					s = 13;
				} else if (OPPLTestCaseCombinedParser.this.synpred3_OPPLTestCaseCombined()) {
					s = 14;
				} else if (OPPLTestCaseCombinedParser.this.synpred4_OPPLTestCaseCombined()) {
					s = 15;
				} else if (OPPLTestCaseCombinedParser.this.synpred5_OPPLTestCaseCombined()) {
					s = 16;
				} else if (OPPLTestCaseCombinedParser.this.synpred6_OPPLTestCaseCombined()) {
					s = 17;
				}
				input.seek(index5_4);
				if (s >= 0) {
					return s;
				}
				break;
			case 4:
				int LA5_5 = input.LA(1);
				int index5_5 = input.index();
				input.rewind();
				s = -1;
				if (OPPLTestCaseCombinedParser.this.synpred1_OPPLTestCaseCombined()) {
					s = 12;
				} else if (OPPLTestCaseCombinedParser.this.synpred2_OPPLTestCaseCombined()) {
					s = 13;
				} else if (OPPLTestCaseCombinedParser.this.synpred3_OPPLTestCaseCombined()) {
					s = 14;
				} else if (OPPLTestCaseCombinedParser.this.synpred4_OPPLTestCaseCombined()) {
					s = 15;
				} else if (OPPLTestCaseCombinedParser.this.synpred5_OPPLTestCaseCombined()) {
					s = 16;
				} else if (OPPLTestCaseCombinedParser.this.synpred6_OPPLTestCaseCombined()) {
					s = 17;
				} else if (OPPLTestCaseCombinedParser.this.synpred7_OPPLTestCaseCombined()) {
					s = 18;
				}
				input.seek(index5_5);
				if (s >= 0) {
					return s;
				}
				break;
			case 5:
				int LA5_6 = input.LA(1);
				int index5_6 = input.index();
				input.rewind();
				s = -1;
				if (OPPLTestCaseCombinedParser.this.synpred1_OPPLTestCaseCombined()) {
					s = 12;
				} else if (OPPLTestCaseCombinedParser.this.synpred2_OPPLTestCaseCombined()) {
					s = 13;
				} else if (OPPLTestCaseCombinedParser.this.synpred3_OPPLTestCaseCombined()) {
					s = 14;
				} else if (OPPLTestCaseCombinedParser.this.synpred4_OPPLTestCaseCombined()) {
					s = 15;
				} else if (OPPLTestCaseCombinedParser.this.synpred5_OPPLTestCaseCombined()) {
					s = 16;
				} else if (OPPLTestCaseCombinedParser.this.synpred6_OPPLTestCaseCombined()) {
					s = 17;
				}
				input.seek(index5_6);
				if (s >= 0) {
					return s;
				}
				break;
			case 6:
				int LA5_7 = input.LA(1);
				int index5_7 = input.index();
				input.rewind();
				s = -1;
				if (OPPLTestCaseCombinedParser.this.synpred1_OPPLTestCaseCombined()) {
					s = 12;
				} else if (OPPLTestCaseCombinedParser.this.synpred2_OPPLTestCaseCombined()) {
					s = 13;
				} else if (OPPLTestCaseCombinedParser.this.synpred3_OPPLTestCaseCombined()) {
					s = 14;
				} else if (OPPLTestCaseCombinedParser.this.synpred4_OPPLTestCaseCombined()) {
					s = 15;
				} else if (OPPLTestCaseCombinedParser.this.synpred5_OPPLTestCaseCombined()) {
					s = 16;
				} else if (OPPLTestCaseCombinedParser.this.synpred6_OPPLTestCaseCombined()) {
					s = 17;
				}
				input.seek(index5_7);
				if (s >= 0) {
					return s;
				}
				break;
			case 7:
				int LA5_8 = input.LA(1);
				int index5_8 = input.index();
				input.rewind();
				s = -1;
				if (OPPLTestCaseCombinedParser.this.synpred1_OPPLTestCaseCombined()) {
					s = 12;
				} else if (OPPLTestCaseCombinedParser.this.synpred2_OPPLTestCaseCombined()) {
					s = 13;
				} else if (OPPLTestCaseCombinedParser.this.synpred3_OPPLTestCaseCombined()) {
					s = 14;
				} else if (OPPLTestCaseCombinedParser.this.synpred4_OPPLTestCaseCombined()) {
					s = 15;
				} else if (OPPLTestCaseCombinedParser.this.synpred5_OPPLTestCaseCombined()) {
					s = 16;
				} else if (OPPLTestCaseCombinedParser.this.synpred6_OPPLTestCaseCombined()) {
					s = 17;
				} else if (true) {
					s = 19;
				}
				input.seek(index5_8);
				if (s >= 0) {
					return s;
				}
				break;
			case 8:
				int LA5_9 = input.LA(1);
				int index5_9 = input.index();
				input.rewind();
				s = -1;
				if (OPPLTestCaseCombinedParser.this.synpred1_OPPLTestCaseCombined()) {
					s = 12;
				} else if (OPPLTestCaseCombinedParser.this.synpred2_OPPLTestCaseCombined()) {
					s = 13;
				} else if (OPPLTestCaseCombinedParser.this.synpred3_OPPLTestCaseCombined()) {
					s = 14;
				} else if (OPPLTestCaseCombinedParser.this.synpred4_OPPLTestCaseCombined()) {
					s = 15;
				} else if (OPPLTestCaseCombinedParser.this.synpred5_OPPLTestCaseCombined()) {
					s = 16;
				} else if (OPPLTestCaseCombinedParser.this.synpred6_OPPLTestCaseCombined()) {
					s = 17;
				}
				input.seek(index5_9);
				if (s >= 0) {
					return s;
				}
				break;
			case 9:
				int LA5_10 = input.LA(1);
				int index5_10 = input.index();
				input.rewind();
				s = -1;
				if (OPPLTestCaseCombinedParser.this.synpred1_OPPLTestCaseCombined()) {
					s = 12;
				} else if (OPPLTestCaseCombinedParser.this.synpred2_OPPLTestCaseCombined()) {
					s = 13;
				} else if (OPPLTestCaseCombinedParser.this.synpred3_OPPLTestCaseCombined()) {
					s = 14;
				} else if (OPPLTestCaseCombinedParser.this.synpred4_OPPLTestCaseCombined()) {
					s = 15;
				} else if (OPPLTestCaseCombinedParser.this.synpred5_OPPLTestCaseCombined()) {
					s = 16;
				} else if (OPPLTestCaseCombinedParser.this.synpred6_OPPLTestCaseCombined()) {
					s = 17;
				}
				input.seek(index5_10);
				if (s >= 0) {
					return s;
				}
				break;
			case 10:
				int LA5_11 = input.LA(1);
				int index5_11 = input.index();
				input.rewind();
				s = -1;
				if (OPPLTestCaseCombinedParser.this.synpred1_OPPLTestCaseCombined()) {
					s = 12;
				} else if (OPPLTestCaseCombinedParser.this.synpred2_OPPLTestCaseCombined()) {
					s = 13;
				} else if (OPPLTestCaseCombinedParser.this.synpred3_OPPLTestCaseCombined()) {
					s = 14;
				} else if (OPPLTestCaseCombinedParser.this.synpred4_OPPLTestCaseCombined()) {
					s = 15;
				} else if (OPPLTestCaseCombinedParser.this.synpred5_OPPLTestCaseCombined()) {
					s = 16;
				} else if (OPPLTestCaseCombinedParser.this.synpred6_OPPLTestCaseCombined()) {
					s = 17;
				}
				input.seek(index5_11);
				if (s >= 0) {
					return s;
				}
				break;
			}
			if (OPPLTestCaseCombinedParser.this.state.backtracking > 0) {
				OPPLTestCaseCombinedParser.this.state.failed = true;
				return -1;
			}
			NoViableAltException nvae = new NoViableAltException(this.getDescription(), 5, _s,
					input);
			this.error(nvae);
			throw nvae;
		}
	}

	public static final BitSet FOLLOW_text_in_testCase169 = new BitSet(new long[] {
			0x0000000000000000L, 0x0000000000000000L, 0x0000000000000000L, 0x0000000000000000L,
			0x0000000000000000L, 0x0000000000000000L, 0x0000000000000000L, 0x0000000000200000L });
	public static final BitSet FOLLOW_SEMICOLON_in_testCase171 = new BitSet(new long[] {
			0x0000000000000000L, 0x0000000000000800L, 0x0000000000000000L, 0x0000000000000000L,
			0x0000000000000000L, 0x0000000000000000L, 0x0000000000000000L, 0x0000000000410000L });
	public static final BitSet FOLLOW_INFERENCE_in_testCase173 = new BitSet(new long[] {
			0x0000000000000000L, 0x0000000000000800L, 0x0000000000000000L, 0x0000000000000000L,
			0x0000000000000000L, 0x0000000000000000L, 0x0000000000000000L, 0x0000000000410000L });
	public static final BitSet FOLLOW_statement_in_testCase177 = new BitSet(new long[] {
			0x0000000000000000L, 0x0000000000000000L, 0x0000000000000000L, 0x0000000000000000L,
			0x0000000000000000L, 0x0000000000000000L, 0x0000000000000000L, 0x0000000200000000L });
	public static final BitSet FOLLOW_test_in_testCase180 = new BitSet(new long[] {
			0x0000000000000002L, 0x0000000000000000L, 0x0000000000000000L, 0x0000000000000000L,
			0x0000000000000000L, 0x0000000000000000L, 0x0000000000000000L, 0x0000000200000000L });
	public static final BitSet FOLLOW_ASSERT_in_test212 = new BitSet(new long[] {
			0x0000350000081060L, 0x0000000000000000L, 0x0000000000200000L, 0x0000000000000000L,
			0x0000000000000000L, 0x0000000000000000L, 0x0000000000000000L, 0x0000000000110000L });
	public static final BitSet FOLLOW_assertion_in_test214 = new BitSet(new long[] {
			0x0000000000000002L, 0x0000000000000000L, 0x0000000000000000L, 0x0000000000000000L,
			0x0000000000000000L, 0x0000000000000000L, 0x0000000000000000L, 0x0000000000200000L });
	public static final BitSet FOLLOW_SEMICOLON_in_test217 = new BitSet(new long[] {
			0x0000148FF80FFC00L, 0x0000000000000200L, 0x0000000000000000L, 0x0000000000000000L,
			0x0000000000000000L, 0x0000000000000000L, 0x0000000000000000L, 0x0000000000110000L });
	public static final BitSet FOLLOW_text_in_test222 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_assertionExpression_in_assertion269 = new BitSet(new long[] {
			0x0000000000000000L, 0x0000000000000200L });
	public static final BitSet FOLLOW_EQUAL_in_assertion271 = new BitSet(new long[] {
			0x0000350000081060L, 0x0000000000000000L, 0x0000000000200000L, 0x0000000000000000L,
			0x0000000000000000L, 0x0000000000000000L, 0x0000000000000000L, 0x0000000000110000L });
	public static final BitSet FOLLOW_assertionExpression_in_assertion276 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_assertionExpression_in_assertion297 = new BitSet(new long[] {
			0x0000000000000000L, 0x0000000000000100L });
	public static final BitSet FOLLOW_NOT_EQUAL_in_assertion299 = new BitSet(new long[] {
			0x0000350000081060L, 0x0000000000000000L, 0x0000000000200000L, 0x0000000000000000L,
			0x0000000000000000L, 0x0000000000000000L, 0x0000000000000000L, 0x0000000000110000L });
	public static final BitSet FOLLOW_assertionExpression_in_assertion304 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_assertionExpression_in_assertion325 = new BitSet(new long[] {
			0x0000000000000000L, 0x0000000000000000L, 0x0000000000000000L, 0x0000000000000000L,
			0x0000000000000000L, 0x0000000000000000L, 0x0000000000000000L, 0x0000000800000000L });
	public static final BitSet FOLLOW_LESS_THAN_in_assertion327 = new BitSet(new long[] {
			0x0000350000081060L, 0x0000000000000000L, 0x0000000000200000L, 0x0000000000000000L,
			0x0000000000000000L, 0x0000000000000000L, 0x0000000000000000L, 0x0000000000110000L });
	public static final BitSet FOLLOW_assertionExpression_in_assertion332 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_assertionExpression_in_assertion353 = new BitSet(new long[] {
			0x0000000000000000L, 0x0000000000000000L, 0x0000000000000000L, 0x0000000000000000L,
			0x0000000000000000L, 0x0000000000000000L, 0x0000000000000000L, 0x0000001000000000L });
	public static final BitSet FOLLOW_LESS_THAN_EQUAL_in_assertion355 = new BitSet(new long[] {
			0x0000350000081060L, 0x0000000000000000L, 0x0000000000200000L, 0x0000000000000000L,
			0x0000000000000000L, 0x0000000000000000L, 0x0000000000000000L, 0x0000000000110000L });
	public static final BitSet FOLLOW_assertionExpression_in_assertion360 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_assertionExpression_in_assertion383 = new BitSet(new long[] {
			0x0000000000000000L, 0x0000000000000000L, 0x0000000000000000L, 0x0000000000000000L,
			0x0000000000000000L, 0x0000000000000000L, 0x0000000000000000L, 0x0000002000000000L });
	public static final BitSet FOLLOW_GREATER_THAN_in_assertion385 = new BitSet(new long[] {
			0x0000350000081060L, 0x0000000000000000L, 0x0000000000200000L, 0x0000000000000000L,
			0x0000000000000000L, 0x0000000000000000L, 0x0000000000000000L, 0x0000000000110000L });
	public static final BitSet FOLLOW_assertionExpression_in_assertion390 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_assertionExpression_in_assertion413 = new BitSet(new long[] {
			0x0000000000000000L, 0x0000000000000000L, 0x0000000000000000L, 0x0000000000000000L,
			0x0000000000000000L, 0x0000000000000000L, 0x0000000000000000L, 0x0000004000000000L });
	public static final BitSet FOLLOW_GREATER_THAN_EQUAL_in_assertion415 = new BitSet(new long[] {
			0x0000350000081060L, 0x0000000000000000L, 0x0000000000200000L, 0x0000000000000000L,
			0x0000000000000000L, 0x0000000000000000L, 0x0000000000000000L, 0x0000000000110000L });
	public static final BitSet FOLLOW_assertionExpression_in_assertion420 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_VARIABLE_NAME_in_assertion440 = new BitSet(new long[] {
			0x0000000000000000L, 0x0000000000000000L, 0x0000000000000000L, 0x0000000000000000L,
			0x0000000000000000L, 0x0000000000000000L, 0x0000000000000000L, 0x0000000000800000L });
	public static final BitSet FOLLOW_CONTAINS_in_assertion443 = new BitSet(new long[] {
			0x0000350000081060L, 0x0000000000000000L, 0x0000000000200000L, 0x0000000000000000L,
			0x0000000000000000L, 0x0000000000000000L, 0x0000000000000000L, 0x0000000000110000L });
	public static final BitSet FOLLOW_assertionExpression_in_assertion445 = new BitSet(
			new long[] { 0x0000002000000002L });
	public static final BitSet FOLLOW_COMMA_in_assertion448 = new BitSet(new long[] {
			0x0000350000081060L, 0x0000000000000000L, 0x0000000000200000L, 0x0000000000000000L,
			0x0000000000000000L, 0x0000000000000000L, 0x0000000000000000L, 0x0000000000110000L });
	public static final BitSet FOLLOW_assertionExpression_in_assertion450 = new BitSet(
			new long[] { 0x0000002000000002L });
	public static final BitSet FOLLOW_NOT_in_assertion469 = new BitSet(
			new long[] { 0x0000000000000020L });
	public static final BitSet FOLLOW_OPEN_PARENTHESYS_in_assertion471 = new BitSet(new long[] {
			0x0000350000081060L, 0x0000000000000000L, 0x0000000000200000L, 0x0000000000000000L,
			0x0000000000000000L, 0x0000000000000000L, 0x0000000000000000L, 0x0000000000110000L });
	public static final BitSet FOLLOW_assertion_in_assertion473 = new BitSet(
			new long[] { 0x0000000000000100L });
	public static final BitSet FOLLOW_CLOSED_PARENTHESYS_in_assertion475 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_COUNT_in_assertionExpression496 = new BitSet(
			new long[] { 0x0000000000000020L });
	public static final BitSet FOLLOW_OPEN_PARENTHESYS_in_assertionExpression498 = new BitSet(
			new long[] { 0x0000000000000000L, 0x0000000000000000L, 0x0000000000000000L,
					0x0000000000000000L, 0x0000000000000000L, 0x0000000000000000L,
					0x0000000000000000L, 0x0000000000010000L });
	public static final BitSet FOLLOW_bindingDescription_in_assertionExpression500 = new BitSet(
			new long[] { 0x0000002000000100L });
	public static final BitSet FOLLOW_COMMA_in_assertionExpression503 = new BitSet(new long[] {
			0x0000000000000000L, 0x0000000000000000L, 0x0000000000000000L, 0x0000000000000000L,
			0x0000000000000000L, 0x0000000000000000L, 0x0000000000000000L, 0x0000000000010000L });
	public static final BitSet FOLLOW_bindingDescription_in_assertionExpression505 = new BitSet(
			new long[] { 0x0000002000000100L });
	public static final BitSet FOLLOW_CLOSED_PARENTHESYS_in_assertionExpression509 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_COUNT_in_assertionExpression523 = new BitSet(
			new long[] { 0x0000000000000020L });
	public static final BitSet FOLLOW_OPEN_PARENTHESYS_in_assertionExpression525 = new BitSet(
			new long[] { 0x0000000000000000L, 0x0000000000000000L, 0x0000000000000000L,
					0x0000000000000000L, 0x0000000000000000L, 0x0000000000000000L,
					0x0000000000000000L, 0x0000000000010000L });
	public static final BitSet FOLLOW_VARIABLE_NAME_in_assertionExpression527 = new BitSet(
			new long[] { 0x0000000000000100L });
	public static final BitSet FOLLOW_CLOSED_PARENTHESYS_in_assertionExpression529 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_COUNT_in_assertionExpression542 = new BitSet(
			new long[] { 0x0000000000000020L });
	public static final BitSet FOLLOW_OPEN_PARENTHESYS_in_assertionExpression544 = new BitSet(
			new long[] { 0x0000000000000000L, 0x0000000000000000L, 0x0000000000000000L,
					0x0000000000000000L, 0x0000000000000000L, 0x0000000000000000L,
					0x0000000000000000L, 0x0000000400000000L });
	public static final BitSet FOLLOW_STAR_in_assertionExpression546 = new BitSet(
			new long[] { 0x0000000000000100L });
	public static final BitSet FOLLOW_CLOSED_PARENTHESYS_in_assertionExpression548 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_INTEGER_in_assertionExpression561 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_expression_in_assertionExpression568 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_VARIABLE_NAME_in_bindingDescription591 = new BitSet(
			new long[] { 0x0000000000000000L, 0x0000000000000200L });
	public static final BitSet FOLLOW_EQUAL_in_bindingDescription593 = new BitSet(new long[] {
			0x0000350000081060L, 0x0000000000000000L, 0x0000000000200000L, 0x0000000000000000L,
			0x0000000000000000L, 0x0000000000000000L, 0x0000000000000000L, 0x0000000000110000L });
	public static final BitSet FOLLOW_expression_in_bindingDescription595 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_textBit_in_text634 = new BitSet(new long[] {
			0x0000148FF80FFC02L, 0x0000000000000200L, 0x0000000000000000L, 0x0000000000000000L,
			0x0000000000000000L, 0x0000000000000000L, 0x0000000000000000L, 0x0000000000110000L });
	public static final BitSet FOLLOW_IDENTIFIER_in_textBit666 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_VARIABLE_NAME_in_textBit681 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_FUNCTIONAL_in_textBit697 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_INVERSE_FUNCTIONAL_in_textBit712 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_SYMMETRIC_in_textBit727 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_ANTI_SYMMETRIC_in_textBit742 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_REFLEXIVE_in_textBit757 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_IRREFLEXIVE_in_textBit772 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_TRANSITIVE_in_textBit788 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_NOT_in_textBit803 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_AND_in_textBit818 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_OR_in_textBit833 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_SOME_in_textBit848 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_ONLY_in_textBit863 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_MIN_in_textBit878 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_MAX_in_textBit893 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_EXACTLY_in_textBit911 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_VALUE_in_textBit929 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_INVERSE_in_textBit947 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_DOMAIN_in_textBit965 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_RANGE_in_textBit983 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_TYPES_in_textBit998 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_INTEGER_in_textBit1019 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_COUNT_in_textBit1040 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_EQUAL_in_textBit1058 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_variableDefinitions_in_statement1087 = new BitSet(new long[] {
			0x0000000000000000L, 0x0000000000000800L, 0x0000000000000000L, 0x0000000000000000L,
			0x0000000000000000L, 0x0000000000000000L, 0x0000000000000000L, 0x0000000000410000L });
	public static final BitSet FOLLOW_query_in_statement1090 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_assertionExpression_in_synpred1_OPPLTestCaseCombined269 = new BitSet(
			new long[] { 0x0000000000000000L, 0x0000000000000200L });
	public static final BitSet FOLLOW_EQUAL_in_synpred1_OPPLTestCaseCombined271 = new BitSet(
			new long[] { 0x0000350000081060L, 0x0000000000000000L, 0x0000000000200000L,
					0x0000000000000000L, 0x0000000000000000L, 0x0000000000000000L,
					0x0000000000000000L, 0x0000000000110000L });
	public static final BitSet FOLLOW_assertionExpression_in_synpred1_OPPLTestCaseCombined276 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_assertionExpression_in_synpred2_OPPLTestCaseCombined297 = new BitSet(
			new long[] { 0x0000000000000000L, 0x0000000000000100L });
	public static final BitSet FOLLOW_NOT_EQUAL_in_synpred2_OPPLTestCaseCombined299 = new BitSet(
			new long[] { 0x0000350000081060L, 0x0000000000000000L, 0x0000000000200000L,
					0x0000000000000000L, 0x0000000000000000L, 0x0000000000000000L,
					0x0000000000000000L, 0x0000000000110000L });
	public static final BitSet FOLLOW_assertionExpression_in_synpred2_OPPLTestCaseCombined304 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_assertionExpression_in_synpred3_OPPLTestCaseCombined325 = new BitSet(
			new long[] { 0x0000000000000000L, 0x0000000000000000L, 0x0000000000000000L,
					0x0000000000000000L, 0x0000000000000000L, 0x0000000000000000L,
					0x0000000000000000L, 0x0000000800000000L });
	public static final BitSet FOLLOW_LESS_THAN_in_synpred3_OPPLTestCaseCombined327 = new BitSet(
			new long[] { 0x0000350000081060L, 0x0000000000000000L, 0x0000000000200000L,
					0x0000000000000000L, 0x0000000000000000L, 0x0000000000000000L,
					0x0000000000000000L, 0x0000000000110000L });
	public static final BitSet FOLLOW_assertionExpression_in_synpred3_OPPLTestCaseCombined332 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_assertionExpression_in_synpred4_OPPLTestCaseCombined353 = new BitSet(
			new long[] { 0x0000000000000000L, 0x0000000000000000L, 0x0000000000000000L,
					0x0000000000000000L, 0x0000000000000000L, 0x0000000000000000L,
					0x0000000000000000L, 0x0000001000000000L });
	public static final BitSet FOLLOW_LESS_THAN_EQUAL_in_synpred4_OPPLTestCaseCombined355 = new BitSet(
			new long[] { 0x0000350000081060L, 0x0000000000000000L, 0x0000000000200000L,
					0x0000000000000000L, 0x0000000000000000L, 0x0000000000000000L,
					0x0000000000000000L, 0x0000000000110000L });
	public static final BitSet FOLLOW_assertionExpression_in_synpred4_OPPLTestCaseCombined360 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_assertionExpression_in_synpred5_OPPLTestCaseCombined383 = new BitSet(
			new long[] { 0x0000000000000000L, 0x0000000000000000L, 0x0000000000000000L,
					0x0000000000000000L, 0x0000000000000000L, 0x0000000000000000L,
					0x0000000000000000L, 0x0000002000000000L });
	public static final BitSet FOLLOW_GREATER_THAN_in_synpred5_OPPLTestCaseCombined385 = new BitSet(
			new long[] { 0x0000350000081060L, 0x0000000000000000L, 0x0000000000200000L,
					0x0000000000000000L, 0x0000000000000000L, 0x0000000000000000L,
					0x0000000000000000L, 0x0000000000110000L });
	public static final BitSet FOLLOW_assertionExpression_in_synpred5_OPPLTestCaseCombined390 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_assertionExpression_in_synpred6_OPPLTestCaseCombined413 = new BitSet(
			new long[] { 0x0000000000000000L, 0x0000000000000000L, 0x0000000000000000L,
					0x0000000000000000L, 0x0000000000000000L, 0x0000000000000000L,
					0x0000000000000000L, 0x0000004000000000L });
	public static final BitSet FOLLOW_GREATER_THAN_EQUAL_in_synpred6_OPPLTestCaseCombined415 = new BitSet(
			new long[] { 0x0000350000081060L, 0x0000000000000000L, 0x0000000000200000L,
					0x0000000000000000L, 0x0000000000000000L, 0x0000000000000000L,
					0x0000000000000000L, 0x0000000000110000L });
	public static final BitSet FOLLOW_assertionExpression_in_synpred6_OPPLTestCaseCombined420 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_VARIABLE_NAME_in_synpred7_OPPLTestCaseCombined440 = new BitSet(
			new long[] { 0x0000000000000000L, 0x0000000000000000L, 0x0000000000000000L,
					0x0000000000000000L, 0x0000000000000000L, 0x0000000000000000L,
					0x0000000000000000L, 0x0000000000800000L });
	public static final BitSet FOLLOW_CONTAINS_in_synpred7_OPPLTestCaseCombined443 = new BitSet(
			new long[] { 0x0000350000081060L, 0x0000000000000000L, 0x0000000000200000L,
					0x0000000000000000L, 0x0000000000000000L, 0x0000000000000000L,
					0x0000000000000000L, 0x0000000000110000L });
	public static final BitSet FOLLOW_assertionExpression_in_synpred7_OPPLTestCaseCombined445 = new BitSet(
			new long[] { 0x0000002000000002L });
	public static final BitSet FOLLOW_COMMA_in_synpred7_OPPLTestCaseCombined448 = new BitSet(
			new long[] { 0x0000350000081060L, 0x0000000000000000L, 0x0000000000200000L,
					0x0000000000000000L, 0x0000000000000000L, 0x0000000000000000L,
					0x0000000000000000L, 0x0000000000110000L });
	public static final BitSet FOLLOW_assertionExpression_in_synpred7_OPPLTestCaseCombined450 = new BitSet(
			new long[] { 0x0000002000000002L });
}