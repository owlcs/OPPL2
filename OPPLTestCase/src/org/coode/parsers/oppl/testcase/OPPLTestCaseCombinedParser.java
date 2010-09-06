// $ANTLR 3.2 Sep 23, 2009 12:02:23 /Users/luigi/Documents/workspace/PARSERS/src/OPPLTestCaseCombined.g 2010-09-03 16:18:24
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
	public static final String[] tokenNames = new String[] { "<invalid>",
			"<EOR>", "<DOWN>", "<UP>", "COMPOSITION", "OPEN_PARENTHESYS",
			"OPEN_CURLY_BRACES", "CLOSED_CURLY_BRACES", "CLOSED_PARENTHESYS",
			"WHITESPACE", "AND", "OR", "NOT", "SOME", "ONLY", "MIN", "MAX",
			"EXACTLY", "VALUE", "INVERSE", "SUBCLASS_OF", "SUB_PROPERTY_OF",
			"EQUIVALENT_TO", "SAME_AS", "DIFFERENT_FROM", "INVERSE_OF",
			"DISJOINT_WITH", "DOMAIN", "RANGE", "FUNCTIONAL", "SYMMETRIC",
			"ANTI_SYMMETRIC", "REFLEXIVE", "IRREFLEXIVE", "TRANSITIVE",
			"INVERSE_FUNCTIONAL", "POW", "COMMA", "INSTANCE_OF", "TYPES",
			"DBLQUOTE", "DIGIT", "INTEGER", "LETTER", "IDENTIFIER",
			"ENTITY_REFERENCE", "QUESTION_MARK", "Tokens", "SUB_CLASS_AXIOM",
			"EQUIVALENT_TO_AXIOM", "DISJOINT_WITH_AXIOM", "SUB_PROPERTY_AXIOM",
			"SAME_AS_AXIOM", "DIFFERENT_FROM_AXIOM", "UNARY_AXIOM",
			"DISJUNCTION", "CONJUNCTION", "PROPERTY_CHAIN",
			"NEGATED_EXPRESSION", "NEGATED_ASSERTION", "INVERSE_PROPERTY",
			"SOME_RESTRICTION", "ALL_RESTRICTION", "VALUE_RESTRICTION",
			"CARDINALITY_RESTRICTION", "ONE_OF", "TYPE_ASSERTION",
			"ROLE_ASSERTION", "INVERSE_OBJECT_PROPERTY_EXPRESSION",
			"EXPRESSION", "CONSTANT", "WHERE", "NOT_EQUAL", "EQUAL", "IN",
			"SELECT", "ASSERTED", "COLON", "DOT", "PLUS", "CREATE",
			"CREATE_INTERSECTION", "CREATE_DISJUNCTION", "BEGIN", "END",
			"OPEN_SQUARE_BRACKET", "CLOSED_SQUARE_BRACKET", "SUPER_CLASS_OF",
			"SUPER_PROPERTY_OF", "VARIABLE_TYPE", "ADD", "REMOVE",
			"ASSERTED_CLAUSE", "PLAIN_CLAUSE", "INEQUALITY_CONSTRAINT",
			"IN_SET_CONSTRAINT", "INPUT_VARIABLE_DEFINITION",
			"GENERATED_VARIABLE_DEFINITION", "CREATE_OPPL_FUNCTION",
			"VARIABLE_ATTRIBUTE", "OPPL_FUNCTION", "ACTIONS",
			"VARIABLE_DEFINITIONS", "QUERY", "VARIABLE_SCOPE",
			"SUBPROPERTY_OF", "VARIABLE_IDENTIFIER", "OPPL_STATEMENT",
			"ESCLAMATION_MARK", "MATCH", "ATTRIBUTE_SELECTOR", "VALUES",
			"RENDERING", "GROUPS", "STRING_OPERATION", "VARIABLE_NAME",
			"REGEXP_CONSTRAINT", "FAIL", "NAF_CONSTRAINT", "COUNT",
			"SEMICOLON", "INFERENCE", "CONTAINS", "OPPL_TEST_CASE", "MESSAGE",
			"TEST", "ASSERT_EQUAL", "ASSERT_NOT_EQUAL", "ASSERT_TRUE",
			"ASSERT_FALSE", "TEXT", "ASSERT", "482", "483", "484", "485",
			"486", "487", "488", "489", "490", "491", "492", "493", "494",
			"495", "496", "497", "498", "499", "500", "501", "502", "503",
			"504", "505", "506", "507", "508", "509", "510", "511", "512",
			"513", "514", "515", "516", "517", "518", "519", "520", "521",
			"522", "523", "524", "525", "526", "527", "528", "529", "530",
			"531", "532", "533", "534", "535", "536", "537", "538", "539",
			"540", "541", "542", "543", "544", "545", "546", "547", "548",
			"549", "550", "551", "552", "553", "554", "555", "556", "557",
			"558", "559", "560", "561", "562", "563", "564", "565", "566",
			"567", "568", "569", "570", "571", "572", "573", "574", "575",
			"576", "577", "578", "579", "580", "581", "582", "583", "584",
			"585", "586", "587", "588", "589", "590", "591", "592", "593",
			"594", "595", "596", "597", "598", "599" };
	public static final int VALUE_RESTRICTION = 63;
	public static final int LETTER = 43;
	public static final int CONTAINS = 471;
	public static final int ASSERT_TRUE = 478;
	public static final int REMOVE = 91;
	public static final int ASSERT_FALSE = 479;
	public static final int TYPES = 39;
	public static final int SAME_AS_AXIOM = 52;
	public static final int COUNT = 468;
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
	public static final int SYMMETRIC = 30;
	public static final int CARDINALITY_RESTRICTION = 64;
	public static final int SELECT = 75;
	public static final int ROLE_ASSERTION = 67;
	public static final int DIFFERENT_FROM_AXIOM = 53;
	public static final int CREATE_OPPL_FUNCTION = 98;
	public static final int TRANSITIVE = 34;
	public static final int ANTI_SYMMETRIC = 31;
	public static final int INFERENCE = 470;
	public static final int ALL_RESTRICTION = 62;
	public static final int CONJUNCTION = 56;
	public static final int OPPL_STATEMENT = 107;
	public static final int NEGATED_ASSERTION = 59;
	public static final int WHITESPACE = 9;
	public static final int MATCH = 176;
	public static final int IN_SET_CONSTRAINT = 95;
	public static final int SEMICOLON = 469;
	public static final int VALUE = 18;
	public static final int ASSERT = 481;
	public static final int FAIL = 466;
	public static final int GROUPS = 356;
	public static final int OPEN_CURLY_BRACES = 6;
	public static final int ASSERT_EQUAL = 476;
	public static final int DISJUNCTION = 55;
	public static final int INVERSE = 19;
	public static final int ASSERT_NOT_EQUAL = 477;
	public static final int NAF_CONSTRAINT = 467;
	public static final int DBLQUOTE = 40;
	public static final int STRING_OPERATION = 394;
	public static final int OR = 11;
	public static final int TEST = 475;
	public static final int CONSTANT = 70;
	public static final int QUERY = 103;
	public static final int ENTITY_REFERENCE = 45;
	public static final int END = 84;
	public static final int COMPOSITION = 4;
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
	public static final int VARIABLE_NAME = 464;
	public static final int DIFFERENT_FROM = 24;
	public static final int IN = 74;
	public static final int EQUIVALENT_TO = 22;
	public static final int UNARY_AXIOM = 54;
	public static final int COMMA = 37;
	public static final int CLOSED_CURLY_BRACES = 7;
	public static final int IDENTIFIER = 44;
	public static final int SOME = 13;
	public static final int EQUAL = 73;
	public static final int OPEN_PARENTHESYS = 5;
	public static final int MESSAGE = 474;
	public static final int REFLEXIVE = 32;
	public static final int PLUS = 79;
	public static final int DIGIT = 41;
	public static final int DOT = 78;
	public static final int SUPER_CLASS_OF = 87;
	public static final int EXPRESSION = 69;
	public static final int SOME_RESTRICTION = 61;
	public static final int ADD = 90;
	public static final int INTEGER = 42;
	public static final int GENERATED_VARIABLE_DEFINITION = 97;
	public static final int EXACTLY = 17;
	public static final int SUB_PROPERTY_AXIOM = 51;
	public static final int OPEN_SQUARE_BRACKET = 85;
	public static final int VALUES = 354;
	public static final int REGEXP_CONSTRAINT = 465;
	public static final int RANGE = 28;
	public static final int ONE_OF = 65;
	public static final int VARIABLE_DEFINITIONS = 102;
	public static final int MIN = 15;
	public static final int SUB_CLASS_AXIOM = 48;
	public static final int TEXT = 480;
	public static final int PLAIN_CLAUSE = 93;
	public static final int OPPL_TEST_CASE = 473;
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
	public static final int IRREFLEXIVE = 33;
	public static final int VARIABLE_ATTRIBUTE = 99;
	public static final int ASSERTED = 76;
	public static final int FUNCTIONAL = 29;
	public static final int PROPERTY_CHAIN = 57;
	public static final int TYPE_ASSERTION = 66;
	// delegates
	public OPPLTestCaseCombined_OPPLParser_MOWLParser gMOWLParser;
	public OPPLTestCaseCombined_OPPLParser gOPPLParser;

	// delegators
	public OPPLTestCaseCombinedParser(TokenStream input) {
		this(input, new RecognizerSharedState());
	}

	public OPPLTestCaseCombinedParser(TokenStream input,
			RecognizerSharedState state) {
		super(input, state);
		this.gOPPLParser = new OPPLTestCaseCombined_OPPLParser(input, state,
				this);
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
		return "/Users/luigi/Documents/workspace/PARSERS/src/OPPLTestCaseCombined.g";
	}

	private ErrorListener errorListener;

	public OPPLTestCaseCombinedParser(TokenStream input,
			ErrorListener errorListener) {
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
	public void displayRecognitionError(String[] tokenNames,
			RecognitionException e) {
		this.getErrorListener().recognitionException(e, tokenNames);
	}

	protected void mismatch(IntStream input, int ttype, BitSet follow)
			throws RecognitionException {
		throw new MismatchedTokenException(ttype, input);
	}

	@Override
	public Object recoverFromMismatchedSet(IntStream input,
			RecognitionException e, BitSet follow) throws RecognitionException {
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
	// /Users/luigi/Documents/workspace/PARSERS/src/OPPLTestCaseCombined.g:77:1:
	// testCase : name= text SEMICOLON ( INFERENCE )? statement ( test )+ -> ^(
	// OPPL_TEST_CASE IDENTIFIER[$name.text] ( INFERENCE )? statement ( test )+
	// ) ;
	public final OPPLTestCaseCombinedParser.testCase_return testCase()
			throws RecognitionException {
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
		RewriteRuleTokenStream stream_SEMICOLON = new RewriteRuleTokenStream(
				this.adaptor, "token SEMICOLON");
		RewriteRuleTokenStream stream_INFERENCE = new RewriteRuleTokenStream(
				this.adaptor, "token INFERENCE");
		RewriteRuleSubtreeStream stream_statement = new RewriteRuleSubtreeStream(
				this.adaptor, "rule statement");
		RewriteRuleSubtreeStream stream_text = new RewriteRuleSubtreeStream(
				this.adaptor, "rule text");
		RewriteRuleSubtreeStream stream_test = new RewriteRuleSubtreeStream(
				this.adaptor, "rule test");
		try {
			// /Users/luigi/Documents/workspace/PARSERS/src/OPPLTestCaseCombined.g:78:3:
			// (name= text SEMICOLON ( INFERENCE )? statement ( test )+ -> ^(
			// OPPL_TEST_CASE IDENTIFIER[$name.text] ( INFERENCE )? statement (
			// test )+ ) )
			// /Users/luigi/Documents/workspace/PARSERS/src/OPPLTestCaseCombined.g:79:5:
			// name= text SEMICOLON ( INFERENCE )? statement ( test )+
			{
				this.pushFollow(FOLLOW_text_in_testCase144);
				name = this.text();
				this.state._fsp--;
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_text.add(name.getTree());
				}
				SEMICOLON1 = (Token) this.match(this.input, SEMICOLON,
						FOLLOW_SEMICOLON_in_testCase146);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_SEMICOLON.add(SEMICOLON1);
				}
				// /Users/luigi/Documents/workspace/PARSERS/src/OPPLTestCaseCombined.g:79:27:
				// ( INFERENCE )?
				int alt1 = 2;
				int LA1_0 = this.input.LA(1);
				if (LA1_0 == INFERENCE) {
					alt1 = 1;
				}
				switch (alt1) {
				case 1:
					// /Users/luigi/Documents/workspace/PARSERS/src/OPPLTestCaseCombined.g:79:27:
					// INFERENCE
				{
					INFERENCE2 = (Token) this.match(this.input, INFERENCE,
							FOLLOW_INFERENCE_in_testCase148);
					if (this.state.failed) {
						return retval;
					}
					if (this.state.backtracking == 0) {
						stream_INFERENCE.add(INFERENCE2);
					}
				}
					break;
				}
				this.pushFollow(FOLLOW_statement_in_testCase152);
				statement3 = this.statement();
				this.state._fsp--;
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_statement.add(statement3.getTree());
				}
				// /Users/luigi/Documents/workspace/PARSERS/src/OPPLTestCaseCombined.g:79:50:
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
						// /Users/luigi/Documents/workspace/PARSERS/src/OPPLTestCaseCombined.g:79:50:
						// test
					{
						this.pushFollow(FOLLOW_test_in_testCase155);
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
						EarlyExitException eee = new EarlyExitException(2,
								this.input);
						throw eee;
					}
					cnt2++;
				} while (true);
				// AST REWRITE
				// elements: statement, test, INFERENCE
				// token labels:
				// rule labels: retval
				// token list labels:
				// rule list labels:
				// wildcard labels:
				if (this.state.backtracking == 0) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(
							this.adaptor, "rule retval",
							retval != null ? retval.tree : null);
					root_0 = (OPPLSyntaxTree) this.adaptor.nil();
					// 79:55: -> ^( OPPL_TEST_CASE IDENTIFIER[$name.text] (
					// INFERENCE )? statement ( test )+ )
					{
						// /Users/luigi/Documents/workspace/PARSERS/src/OPPLTestCaseCombined.g:79:57:
						// ^( OPPL_TEST_CASE IDENTIFIER[$name.text] ( INFERENCE
						// )? statement ( test )+ )
						{
							OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor
									.nil();
							root_1 = (OPPLSyntaxTree) this.adaptor.becomeRoot(
									this.adaptor.create(OPPL_TEST_CASE,
											"OPPL_TEST_CASE"), root_1);
							this.adaptor.addChild(root_1, this.adaptor.create(
									IDENTIFIER, (name != null ? this.input
											.toString(name.start, name.stop)
											: null)));
							// /Users/luigi/Documents/workspace/PARSERS/src/OPPLTestCaseCombined.g:79:97:
							// ( INFERENCE )?
							if (stream_INFERENCE.hasNext()) {
								this.adaptor.addChild(root_1, stream_INFERENCE
										.nextNode());
							}
							stream_INFERENCE.reset();
							this.adaptor.addChild(root_1, stream_statement
									.nextTree());
							if (!stream_test.hasNext()) {
								throw new RewriteEarlyExitException();
							}
							while (stream_test.hasNext()) {
								this.adaptor.addChild(root_1, stream_test
										.nextTree());
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
				retval.tree = (OPPLSyntaxTree) this.adaptor
						.rulePostProcessing(root_0);
				this.adaptor.setTokenBoundaries(retval.tree, retval.start,
						retval.stop);
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
	// /Users/luigi/Documents/workspace/PARSERS/src/OPPLTestCaseCombined.g:83:1:
	// test : ASSERT assertion ( SEMICOLON message= text )? -> ^( TEST assertion
	// ( ^( MESSAGE[$message.text] $message) )? ) ;
	public final OPPLTestCaseCombinedParser.test_return test()
			throws RecognitionException {
		OPPLTestCaseCombinedParser.test_return retval = new OPPLTestCaseCombinedParser.test_return();
		retval.start = this.input.LT(1);
		OPPLSyntaxTree root_0 = null;
		Token ASSERT5 = null;
		Token SEMICOLON7 = null;
		OPPLTestCaseCombinedParser.text_return message = null;
		OPPLTestCaseCombinedParser.assertion_return assertion6 = null;
		OPPLSyntaxTree ASSERT5_tree = null;
		OPPLSyntaxTree SEMICOLON7_tree = null;
		RewriteRuleTokenStream stream_SEMICOLON = new RewriteRuleTokenStream(
				this.adaptor, "token SEMICOLON");
		RewriteRuleTokenStream stream_ASSERT = new RewriteRuleTokenStream(
				this.adaptor, "token ASSERT");
		RewriteRuleSubtreeStream stream_text = new RewriteRuleSubtreeStream(
				this.adaptor, "rule text");
		RewriteRuleSubtreeStream stream_assertion = new RewriteRuleSubtreeStream(
				this.adaptor, "rule assertion");
		try {
			// /Users/luigi/Documents/workspace/PARSERS/src/OPPLTestCaseCombined.g:84:2:
			// ( ASSERT assertion ( SEMICOLON message= text )? -> ^( TEST
			// assertion ( ^( MESSAGE[$message.text] $message) )? ) )
			// /Users/luigi/Documents/workspace/PARSERS/src/OPPLTestCaseCombined.g:85:3:
			// ASSERT assertion ( SEMICOLON message= text )?
			{
				ASSERT5 = (Token) this.match(this.input, ASSERT,
						FOLLOW_ASSERT_in_test187);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_ASSERT.add(ASSERT5);
				}
				this.pushFollow(FOLLOW_assertion_in_test189);
				assertion6 = this.assertion();
				this.state._fsp--;
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_assertion.add(assertion6.getTree());
				}
				// /Users/luigi/Documents/workspace/PARSERS/src/OPPLTestCaseCombined.g:85:20:
				// ( SEMICOLON message= text )?
				int alt3 = 2;
				int LA3_0 = this.input.LA(1);
				if (LA3_0 == SEMICOLON) {
					alt3 = 1;
				}
				switch (alt3) {
				case 1:
					// /Users/luigi/Documents/workspace/PARSERS/src/OPPLTestCaseCombined.g:85:21:
					// SEMICOLON message= text
				{
					SEMICOLON7 = (Token) this.match(this.input, SEMICOLON,
							FOLLOW_SEMICOLON_in_test192);
					if (this.state.failed) {
						return retval;
					}
					if (this.state.backtracking == 0) {
						stream_SEMICOLON.add(SEMICOLON7);
					}
					this.pushFollow(FOLLOW_text_in_test197);
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
							this.adaptor, "rule message",
							message != null ? message.tree : null);
					RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(
							this.adaptor, "rule retval",
							retval != null ? retval.tree : null);
					root_0 = (OPPLSyntaxTree) this.adaptor.nil();
					// 85:47: -> ^( TEST assertion ( ^( MESSAGE[$message.text]
					// $message) )? )
					{
						// /Users/luigi/Documents/workspace/PARSERS/src/OPPLTestCaseCombined.g:85:50:
						// ^( TEST assertion ( ^( MESSAGE[$message.text]
						// $message) )? )
						{
							OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor
									.nil();
							root_1 = (OPPLSyntaxTree) this.adaptor.becomeRoot(
									this.adaptor.create(TEST, "TEST"), root_1);
							this.adaptor.addChild(root_1, stream_assertion
									.nextTree());
							// /Users/luigi/Documents/workspace/PARSERS/src/OPPLTestCaseCombined.g:85:67:
							// ( ^( MESSAGE[$message.text] $message) )?
							if (stream_message.hasNext()) {
								// /Users/luigi/Documents/workspace/PARSERS/src/OPPLTestCaseCombined.g:85:67:
								// ^( MESSAGE[$message.text] $message)
								{
									OPPLSyntaxTree root_2 = (OPPLSyntaxTree) this.adaptor
											.nil();
									root_2 = (OPPLSyntaxTree) this.adaptor
											.becomeRoot(
													this.adaptor
															.create(
																	MESSAGE,
																	(message != null ? this.input
																			.toString(
																					message.start,
																					message.stop)
																			: null)),
													root_2);
									this.adaptor.addChild(root_2,
											stream_message.nextTree());
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
				retval.tree = (OPPLSyntaxTree) this.adaptor
						.rulePostProcessing(root_0);
				this.adaptor.setTokenBoundaries(retval.tree, retval.start,
						retval.stop);
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
	// /Users/luigi/Documents/workspace/PARSERS/src/OPPLTestCaseCombined.g:89:1:
	// assertion options {backtrack=true; } : (left= assertionExpression EQUAL
	// right= assertionExpression -> ^( ASSERT_EQUAL $left $right) | left=
	// assertionExpression NOT_EQUAL right= assertionExpression -> ^(
	// ASSERT_NOT_EQUAL $left $right) | VARIABLE_NAME CONTAINS
	// assertionExpression ( COMMA assertionExpression )? -> ^( CONTAINS
	// VARIABLE_NAME ( assertionExpression )+ ) | NOT OPEN_PARENTHESYS assertion
	// CLOSED_PARENTHESYS -> ^( NOT assertion ) );
	public final OPPLTestCaseCombinedParser.assertion_return assertion()
			throws RecognitionException {
		OPPLTestCaseCombinedParser.assertion_return retval = new OPPLTestCaseCombinedParser.assertion_return();
		retval.start = this.input.LT(1);
		OPPLSyntaxTree root_0 = null;
		Token EQUAL8 = null;
		Token NOT_EQUAL9 = null;
		Token VARIABLE_NAME10 = null;
		Token CONTAINS11 = null;
		Token COMMA13 = null;
		Token NOT15 = null;
		Token OPEN_PARENTHESYS16 = null;
		Token CLOSED_PARENTHESYS18 = null;
		OPPLTestCaseCombinedParser.assertionExpression_return left = null;
		OPPLTestCaseCombinedParser.assertionExpression_return right = null;
		OPPLTestCaseCombinedParser.assertionExpression_return assertionExpression12 = null;
		OPPLTestCaseCombinedParser.assertionExpression_return assertionExpression14 = null;
		OPPLTestCaseCombinedParser.assertion_return assertion17 = null;
		OPPLSyntaxTree EQUAL8_tree = null;
		OPPLSyntaxTree NOT_EQUAL9_tree = null;
		OPPLSyntaxTree VARIABLE_NAME10_tree = null;
		OPPLSyntaxTree CONTAINS11_tree = null;
		OPPLSyntaxTree COMMA13_tree = null;
		OPPLSyntaxTree NOT15_tree = null;
		OPPLSyntaxTree OPEN_PARENTHESYS16_tree = null;
		OPPLSyntaxTree CLOSED_PARENTHESYS18_tree = null;
		RewriteRuleTokenStream stream_VARIABLE_NAME = new RewriteRuleTokenStream(
				this.adaptor, "token VARIABLE_NAME");
		RewriteRuleTokenStream stream_NOT = new RewriteRuleTokenStream(
				this.adaptor, "token NOT");
		RewriteRuleTokenStream stream_CLOSED_PARENTHESYS = new RewriteRuleTokenStream(
				this.adaptor, "token CLOSED_PARENTHESYS");
		RewriteRuleTokenStream stream_COMMA = new RewriteRuleTokenStream(
				this.adaptor, "token COMMA");
		RewriteRuleTokenStream stream_NOT_EQUAL = new RewriteRuleTokenStream(
				this.adaptor, "token NOT_EQUAL");
		RewriteRuleTokenStream stream_CONTAINS = new RewriteRuleTokenStream(
				this.adaptor, "token CONTAINS");
		RewriteRuleTokenStream stream_EQUAL = new RewriteRuleTokenStream(
				this.adaptor, "token EQUAL");
		RewriteRuleTokenStream stream_OPEN_PARENTHESYS = new RewriteRuleTokenStream(
				this.adaptor, "token OPEN_PARENTHESYS");
		RewriteRuleSubtreeStream stream_assertionExpression = new RewriteRuleSubtreeStream(
				this.adaptor, "rule assertionExpression");
		RewriteRuleSubtreeStream stream_assertion = new RewriteRuleSubtreeStream(
				this.adaptor, "rule assertion");
		try {
			// /Users/luigi/Documents/workspace/PARSERS/src/OPPLTestCaseCombined.g:90:2:
			// (left= assertionExpression EQUAL right= assertionExpression -> ^(
			// ASSERT_EQUAL $left $right) | left= assertionExpression NOT_EQUAL
			// right= assertionExpression -> ^( ASSERT_NOT_EQUAL $left $right) |
			// VARIABLE_NAME CONTAINS assertionExpression ( COMMA
			// assertionExpression )? -> ^( CONTAINS VARIABLE_NAME (
			// assertionExpression )+ ) | NOT OPEN_PARENTHESYS assertion
			// CLOSED_PARENTHESYS -> ^( NOT assertion ) )
			int alt5 = 4;
			alt5 = this.dfa5.predict(this.input);
			switch (alt5) {
			case 1:
				// /Users/luigi/Documents/workspace/PARSERS/src/OPPLTestCaseCombined.g:91:3:
				// left= assertionExpression EQUAL right= assertionExpression
			{
				this.pushFollow(FOLLOW_assertionExpression_in_assertion244);
				left = this.assertionExpression();
				this.state._fsp--;
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_assertionExpression.add(left.getTree());
				}
				EQUAL8 = (Token) this.match(this.input, EQUAL,
						FOLLOW_EQUAL_in_assertion246);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_EQUAL.add(EQUAL8);
				}
				this.pushFollow(FOLLOW_assertionExpression_in_assertion251);
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
				// rule labels: retval, left, right
				// token list labels:
				// rule list labels:
				// wildcard labels:
				if (this.state.backtracking == 0) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(
							this.adaptor, "rule retval",
							retval != null ? retval.tree : null);
					RewriteRuleSubtreeStream stream_left = new RewriteRuleSubtreeStream(
							this.adaptor, "rule left", left != null ? left.tree
									: null);
					RewriteRuleSubtreeStream stream_right = new RewriteRuleSubtreeStream(
							this.adaptor, "rule right",
							right != null ? right.tree : null);
					root_0 = (OPPLSyntaxTree) this.adaptor.nil();
					// 91:62: -> ^( ASSERT_EQUAL $left $right)
					{
						// /Users/luigi/Documents/workspace/PARSERS/src/OPPLTestCaseCombined.g:91:65:
						// ^( ASSERT_EQUAL $left $right)
						{
							OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor
									.nil();
							root_1 = (OPPLSyntaxTree) this.adaptor.becomeRoot(
									this.adaptor.create(ASSERT_EQUAL,
											"ASSERT_EQUAL"), root_1);
							this.adaptor.addChild(root_1, stream_left
									.nextTree());
							this.adaptor.addChild(root_1, stream_right
									.nextTree());
							this.adaptor.addChild(root_0, root_1);
						}
					}
					retval.tree = root_0;
				}
			}
				break;
			case 2:
				// /Users/luigi/Documents/workspace/PARSERS/src/OPPLTestCaseCombined.g:92:5:
				// left= assertionExpression NOT_EQUAL right=
				// assertionExpression
			{
				this.pushFollow(FOLLOW_assertionExpression_in_assertion272);
				left = this.assertionExpression();
				this.state._fsp--;
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_assertionExpression.add(left.getTree());
				}
				NOT_EQUAL9 = (Token) this.match(this.input, NOT_EQUAL,
						FOLLOW_NOT_EQUAL_in_assertion274);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_NOT_EQUAL.add(NOT_EQUAL9);
				}
				this.pushFollow(FOLLOW_assertionExpression_in_assertion279);
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
				// rule labels: retval, left, right
				// token list labels:
				// rule list labels:
				// wildcard labels:
				if (this.state.backtracking == 0) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(
							this.adaptor, "rule retval",
							retval != null ? retval.tree : null);
					RewriteRuleSubtreeStream stream_left = new RewriteRuleSubtreeStream(
							this.adaptor, "rule left", left != null ? left.tree
									: null);
					RewriteRuleSubtreeStream stream_right = new RewriteRuleSubtreeStream(
							this.adaptor, "rule right",
							right != null ? right.tree : null);
					root_0 = (OPPLSyntaxTree) this.adaptor.nil();
					// 92:68: -> ^( ASSERT_NOT_EQUAL $left $right)
					{
						// /Users/luigi/Documents/workspace/PARSERS/src/OPPLTestCaseCombined.g:92:71:
						// ^( ASSERT_NOT_EQUAL $left $right)
						{
							OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor
									.nil();
							root_1 = (OPPLSyntaxTree) this.adaptor.becomeRoot(
									this.adaptor.create(ASSERT_NOT_EQUAL,
											"ASSERT_NOT_EQUAL"), root_1);
							this.adaptor.addChild(root_1, stream_left
									.nextTree());
							this.adaptor.addChild(root_1, stream_right
									.nextTree());
							this.adaptor.addChild(root_0, root_1);
						}
					}
					retval.tree = root_0;
				}
			}
				break;
			case 3:
				// /Users/luigi/Documents/workspace/PARSERS/src/OPPLTestCaseCombined.g:93:5:
				// VARIABLE_NAME CONTAINS assertionExpression ( COMMA
				// assertionExpression )?
			{
				VARIABLE_NAME10 = (Token) this.match(this.input, VARIABLE_NAME,
						FOLLOW_VARIABLE_NAME_in_assertion297);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_VARIABLE_NAME.add(VARIABLE_NAME10);
				}
				CONTAINS11 = (Token) this.match(this.input, CONTAINS,
						FOLLOW_CONTAINS_in_assertion300);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_CONTAINS.add(CONTAINS11);
				}
				this.pushFollow(FOLLOW_assertionExpression_in_assertion302);
				assertionExpression12 = this.assertionExpression();
				this.state._fsp--;
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_assertionExpression.add(assertionExpression12
							.getTree());
				}
				// /Users/luigi/Documents/workspace/PARSERS/src/OPPLTestCaseCombined.g:93:49:
				// ( COMMA assertionExpression )?
				int alt4 = 2;
				int LA4_0 = this.input.LA(1);
				if (LA4_0 == COMMA) {
					alt4 = 1;
				}
				switch (alt4) {
				case 1:
					// /Users/luigi/Documents/workspace/PARSERS/src/OPPLTestCaseCombined.g:93:50:
					// COMMA assertionExpression
				{
					COMMA13 = (Token) this.match(this.input, COMMA,
							FOLLOW_COMMA_in_assertion305);
					if (this.state.failed) {
						return retval;
					}
					if (this.state.backtracking == 0) {
						stream_COMMA.add(COMMA13);
					}
					this.pushFollow(FOLLOW_assertionExpression_in_assertion307);
					assertionExpression14 = this.assertionExpression();
					this.state._fsp--;
					if (this.state.failed) {
						return retval;
					}
					if (this.state.backtracking == 0) {
						stream_assertionExpression.add(assertionExpression14
								.getTree());
					}
				}
					break;
				}
				// AST REWRITE
				// elements: CONTAINS, assertionExpression, VARIABLE_NAME
				// token labels:
				// rule labels: retval
				// token list labels:
				// rule list labels:
				// wildcard labels:
				if (this.state.backtracking == 0) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(
							this.adaptor, "rule retval",
							retval != null ? retval.tree : null);
					root_0 = (OPPLSyntaxTree) this.adaptor.nil();
					// 93:78: -> ^( CONTAINS VARIABLE_NAME ( assertionExpression
					// )+ )
					{
						// /Users/luigi/Documents/workspace/PARSERS/src/OPPLTestCaseCombined.g:93:80:
						// ^( CONTAINS VARIABLE_NAME ( assertionExpression )+ )
						{
							OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor
									.nil();
							root_1 = (OPPLSyntaxTree) this.adaptor.becomeRoot(
									stream_CONTAINS.nextNode(), root_1);
							this.adaptor.addChild(root_1, stream_VARIABLE_NAME
									.nextNode());
							if (!stream_assertionExpression.hasNext()) {
								throw new RewriteEarlyExitException();
							}
							while (stream_assertionExpression.hasNext()) {
								this.adaptor.addChild(root_1,
										stream_assertionExpression.nextTree());
							}
							stream_assertionExpression.reset();
							this.adaptor.addChild(root_0, root_1);
						}
					}
					retval.tree = root_0;
				}
			}
				break;
			case 4:
				// /Users/luigi/Documents/workspace/PARSERS/src/OPPLTestCaseCombined.g:94:5:
				// NOT OPEN_PARENTHESYS assertion CLOSED_PARENTHESYS
			{
				NOT15 = (Token) this.match(this.input, NOT,
						FOLLOW_NOT_in_assertion326);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_NOT.add(NOT15);
				}
				OPEN_PARENTHESYS16 = (Token) this.match(this.input,
						OPEN_PARENTHESYS,
						FOLLOW_OPEN_PARENTHESYS_in_assertion328);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_OPEN_PARENTHESYS.add(OPEN_PARENTHESYS16);
				}
				this.pushFollow(FOLLOW_assertion_in_assertion330);
				assertion17 = this.assertion();
				this.state._fsp--;
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_assertion.add(assertion17.getTree());
				}
				CLOSED_PARENTHESYS18 = (Token) this.match(this.input,
						CLOSED_PARENTHESYS,
						FOLLOW_CLOSED_PARENTHESYS_in_assertion332);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_CLOSED_PARENTHESYS.add(CLOSED_PARENTHESYS18);
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
							this.adaptor, "rule retval",
							retval != null ? retval.tree : null);
					root_0 = (OPPLSyntaxTree) this.adaptor.nil();
					// 94:55: -> ^( NOT assertion )
					{
						// /Users/luigi/Documents/workspace/PARSERS/src/OPPLTestCaseCombined.g:94:57:
						// ^( NOT assertion )
						{
							OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor
									.nil();
							root_1 = (OPPLSyntaxTree) this.adaptor.becomeRoot(
									stream_NOT.nextNode(), root_1);
							this.adaptor.addChild(root_1, stream_assertion
									.nextTree());
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
				retval.tree = (OPPLSyntaxTree) this.adaptor
						.rulePostProcessing(root_0);
				this.adaptor.setTokenBoundaries(retval.tree, retval.start,
						retval.stop);
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
	public static class assertionExpression_return extends
			ParserRuleReturnScope {
		OPPLSyntaxTree tree;

		@Override
		public Object getTree() {
			return this.tree;
		}
	};

	// $ANTLR start "assertionExpression"
	// /Users/luigi/Documents/workspace/PARSERS/src/OPPLTestCaseCombined.g:97:1:
	// assertionExpression : ( COUNT OPEN_PARENTHESYS VARIABLE_NAME
	// CLOSED_PARENTHESYS -> ^( COUNT VARIABLE_NAME ) | INTEGER | expression ->
	// ^( EXPRESSION expression ) );
	public final OPPLTestCaseCombinedParser.assertionExpression_return assertionExpression()
			throws RecognitionException {
		OPPLTestCaseCombinedParser.assertionExpression_return retval = new OPPLTestCaseCombinedParser.assertionExpression_return();
		retval.start = this.input.LT(1);
		OPPLSyntaxTree root_0 = null;
		Token COUNT19 = null;
		Token OPEN_PARENTHESYS20 = null;
		Token VARIABLE_NAME21 = null;
		Token CLOSED_PARENTHESYS22 = null;
		Token INTEGER23 = null;
		OPPLTestCaseCombined_OPPLParser_MOWLParser.expression_return expression24 = null;
		OPPLSyntaxTree COUNT19_tree = null;
		OPPLSyntaxTree OPEN_PARENTHESYS20_tree = null;
		OPPLSyntaxTree VARIABLE_NAME21_tree = null;
		OPPLSyntaxTree CLOSED_PARENTHESYS22_tree = null;
		OPPLSyntaxTree INTEGER23_tree = null;
		RewriteRuleTokenStream stream_COUNT = new RewriteRuleTokenStream(
				this.adaptor, "token COUNT");
		RewriteRuleTokenStream stream_VARIABLE_NAME = new RewriteRuleTokenStream(
				this.adaptor, "token VARIABLE_NAME");
		RewriteRuleTokenStream stream_CLOSED_PARENTHESYS = new RewriteRuleTokenStream(
				this.adaptor, "token CLOSED_PARENTHESYS");
		RewriteRuleTokenStream stream_OPEN_PARENTHESYS = new RewriteRuleTokenStream(
				this.adaptor, "token OPEN_PARENTHESYS");
		RewriteRuleSubtreeStream stream_expression = new RewriteRuleSubtreeStream(
				this.adaptor, "rule expression");
		try {
			// /Users/luigi/Documents/workspace/PARSERS/src/OPPLTestCaseCombined.g:98:2:
			// ( COUNT OPEN_PARENTHESYS VARIABLE_NAME CLOSED_PARENTHESYS -> ^(
			// COUNT VARIABLE_NAME ) | INTEGER | expression -> ^( EXPRESSION
			// expression ) )
			int alt6 = 3;
			switch (this.input.LA(1)) {
			case COUNT: {
				alt6 = 1;
			}
				break;
			case INTEGER: {
				alt6 = 2;
			}
				break;
			case EOF:
			case OPEN_PARENTHESYS:
			case OPEN_CURLY_BRACES:
			case CLOSED_PARENTHESYS:
			case AND:
			case OR:
			case NOT:
			case INVERSE:
			case SUBCLASS_OF:
			case SUB_PROPERTY_OF:
			case EQUIVALENT_TO:
			case DISJOINT_WITH:
			case COMMA:
			case DBLQUOTE:
			case IDENTIFIER:
			case ENTITY_REFERENCE:
			case NOT_EQUAL:
			case EQUAL:
			case CLOSED_SQUARE_BRACKET:
			case ESCLAMATION_MARK:
			case VARIABLE_NAME:
			case SEMICOLON:
			case ASSERT: {
				alt6 = 3;
			}
				break;
			default:
				if (this.state.backtracking > 0) {
					this.state.failed = true;
					return retval;
				}
				NoViableAltException nvae = new NoViableAltException("", 6, 0,
						this.input);
				throw nvae;
			}
			switch (alt6) {
			case 1:
				// /Users/luigi/Documents/workspace/PARSERS/src/OPPLTestCaseCombined.g:99:3:
				// COUNT OPEN_PARENTHESYS VARIABLE_NAME CLOSED_PARENTHESYS
			{
				COUNT19 = (Token) this.match(this.input, COUNT,
						FOLLOW_COUNT_in_assertionExpression353);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_COUNT.add(COUNT19);
				}
				OPEN_PARENTHESYS20 = (Token) this.match(this.input,
						OPEN_PARENTHESYS,
						FOLLOW_OPEN_PARENTHESYS_in_assertionExpression355);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_OPEN_PARENTHESYS.add(OPEN_PARENTHESYS20);
				}
				VARIABLE_NAME21 = (Token) this.match(this.input, VARIABLE_NAME,
						FOLLOW_VARIABLE_NAME_in_assertionExpression357);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_VARIABLE_NAME.add(VARIABLE_NAME21);
				}
				CLOSED_PARENTHESYS22 = (Token) this.match(this.input,
						CLOSED_PARENTHESYS,
						FOLLOW_CLOSED_PARENTHESYS_in_assertionExpression359);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_CLOSED_PARENTHESYS.add(CLOSED_PARENTHESYS22);
				}
				// AST REWRITE
				// elements: COUNT, VARIABLE_NAME
				// token labels:
				// rule labels: retval
				// token list labels:
				// rule list labels:
				// wildcard labels:
				if (this.state.backtracking == 0) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(
							this.adaptor, "rule retval",
							retval != null ? retval.tree : null);
					root_0 = (OPPLSyntaxTree) this.adaptor.nil();
					// 99:59: -> ^( COUNT VARIABLE_NAME )
					{
						// /Users/luigi/Documents/workspace/PARSERS/src/OPPLTestCaseCombined.g:99:61:
						// ^( COUNT VARIABLE_NAME )
						{
							OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor
									.nil();
							root_1 = (OPPLSyntaxTree) this.adaptor.becomeRoot(
									stream_COUNT.nextNode(), root_1);
							this.adaptor.addChild(root_1, stream_VARIABLE_NAME
									.nextNode());
							this.adaptor.addChild(root_0, root_1);
						}
					}
					retval.tree = root_0;
				}
			}
				break;
			case 2:
				// /Users/luigi/Documents/workspace/PARSERS/src/OPPLTestCaseCombined.g:100:5:
				// INTEGER
			{
				root_0 = (OPPLSyntaxTree) this.adaptor.nil();
				INTEGER23 = (Token) this.match(this.input, INTEGER,
						FOLLOW_INTEGER_in_assertionExpression372);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					INTEGER23_tree = (OPPLSyntaxTree) this.adaptor
							.create(INTEGER23);
					this.adaptor.addChild(root_0, INTEGER23_tree);
				}
			}
				break;
			case 3:
				// /Users/luigi/Documents/workspace/PARSERS/src/OPPLTestCaseCombined.g:101:5:
				// expression
			{
				this.pushFollow(FOLLOW_expression_in_assertionExpression379);
				expression24 = this.expression();
				this.state._fsp--;
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_expression.add(expression24.getTree());
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
							this.adaptor, "rule retval",
							retval != null ? retval.tree : null);
					root_0 = (OPPLSyntaxTree) this.adaptor.nil();
					// 101:16: -> ^( EXPRESSION expression )
					{
						// /Users/luigi/Documents/workspace/PARSERS/src/OPPLTestCaseCombined.g:101:18:
						// ^( EXPRESSION expression )
						{
							OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor
									.nil();
							root_1 = (OPPLSyntaxTree) this.adaptor.becomeRoot(
									this.adaptor.create(EXPRESSION,
											"EXPRESSION"), root_1);
							this.adaptor.addChild(root_1, stream_expression
									.nextTree());
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
				retval.tree = (OPPLSyntaxTree) this.adaptor
						.rulePostProcessing(root_0);
				this.adaptor.setTokenBoundaries(retval.tree, retval.start,
						retval.stop);
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
	public static class text_return extends ParserRuleReturnScope {
		OPPLSyntaxTree tree;

		@Override
		public Object getTree() {
			return this.tree;
		}
	};

	// $ANTLR start "text"
	// /Users/luigi/Documents/workspace/PARSERS/src/OPPLTestCaseCombined.g:107:1:
	// text : (t= textBit )+ -> ^( TEXT[builder.toString()] ( textBit )+ ) ;
	public final OPPLTestCaseCombinedParser.text_return text()
			throws RecognitionException {
		OPPLTestCaseCombinedParser.text_return retval = new OPPLTestCaseCombinedParser.text_return();
		retval.start = this.input.LT(1);
		OPPLSyntaxTree root_0 = null;
		OPPLTestCaseCombinedParser.textBit_return t = null;
		RewriteRuleSubtreeStream stream_textBit = new RewriteRuleSubtreeStream(
				this.adaptor, "rule textBit");
		StringBuilder builder = new StringBuilder();
		try {
			// /Users/luigi/Documents/workspace/PARSERS/src/OPPLTestCaseCombined.g:113:1:
			// ( (t= textBit )+ -> ^( TEXT[builder.toString()] ( textBit )+ ) )
			// /Users/luigi/Documents/workspace/PARSERS/src/OPPLTestCaseCombined.g:114:1:
			// (t= textBit )+
			{
				// /Users/luigi/Documents/workspace/PARSERS/src/OPPLTestCaseCombined.g:114:1:
				// (t= textBit )+
				int cnt7 = 0;
				loop7: do {
					int alt7 = 2;
					int LA7_0 = this.input.LA(1);
					if (LA7_0 >= AND && LA7_0 <= INVERSE || LA7_0 >= DOMAIN
							&& LA7_0 <= INVERSE_FUNCTIONAL || LA7_0 == TYPES
							|| LA7_0 == INTEGER || LA7_0 == IDENTIFIER
							|| LA7_0 == VARIABLE_NAME || LA7_0 == COUNT) {
						alt7 = 1;
					}
					switch (alt7) {
					case 1:
						// /Users/luigi/Documents/workspace/PARSERS/src/OPPLTestCaseCombined.g:114:3:
						// t= textBit
					{
						this.pushFollow(FOLLOW_textBit_in_text413);
						t = this.textBit();
						this.state._fsp--;
						if (this.state.failed) {
							return retval;
						}
						if (this.state.backtracking == 0) {
							stream_textBit.add(t.getTree());
						}
						if (this.state.backtracking == 0) {
							builder.append((t != null ? this.input.toString(
									t.start, t.stop) : null));
							builder.append(" ");
						}
					}
						break;
					default:
						if (cnt7 >= 1) {
							break loop7;
						}
						if (this.state.backtracking > 0) {
							this.state.failed = true;
							return retval;
						}
						EarlyExitException eee = new EarlyExitException(7,
								this.input);
						throw eee;
					}
					cnt7++;
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
							this.adaptor, "rule retval",
							retval != null ? retval.tree : null);
					root_0 = (OPPLSyntaxTree) this.adaptor.nil();
					// 118:8: -> ^( TEXT[builder.toString()] ( textBit )+ )
					{
						// /Users/luigi/Documents/workspace/PARSERS/src/OPPLTestCaseCombined.g:118:11:
						// ^( TEXT[builder.toString()] ( textBit )+ )
						{
							OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor
									.nil();
							root_1 = (OPPLSyntaxTree) this.adaptor.becomeRoot(
									this.adaptor.create(TEXT, builder
											.toString()), root_1);
							if (!stream_textBit.hasNext()) {
								throw new RewriteEarlyExitException();
							}
							while (stream_textBit.hasNext()) {
								this.adaptor.addChild(root_1, stream_textBit
										.nextTree());
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
				retval.tree = (OPPLSyntaxTree) this.adaptor
						.rulePostProcessing(root_0);
				this.adaptor.setTokenBoundaries(retval.tree, retval.start,
						retval.stop);
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
	// /Users/luigi/Documents/workspace/PARSERS/src/OPPLTestCaseCombined.g:121:1:
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
	// TEXT[$INTEGER.text] ) | COUNT -> ^( TEXT[$COUNT.text] ) );
	public final OPPLTestCaseCombinedParser.textBit_return textBit()
			throws RecognitionException {
		OPPLTestCaseCombinedParser.textBit_return retval = new OPPLTestCaseCombinedParser.textBit_return();
		retval.start = this.input.LT(1);
		OPPLSyntaxTree root_0 = null;
		Token IDENTIFIER25 = null;
		Token VARIABLE_NAME26 = null;
		Token FUNCTIONAL27 = null;
		Token INVERSE_FUNCTIONAL28 = null;
		Token SYMMETRIC29 = null;
		Token ANTI_SYMMETRIC30 = null;
		Token REFLEXIVE31 = null;
		Token IRREFLEXIVE32 = null;
		Token TRANSITIVE33 = null;
		Token NOT34 = null;
		Token AND35 = null;
		Token OR36 = null;
		Token SOME37 = null;
		Token ONLY38 = null;
		Token MIN39 = null;
		Token MAX40 = null;
		Token EXACTLY41 = null;
		Token VALUE42 = null;
		Token INVERSE43 = null;
		Token DOMAIN44 = null;
		Token RANGE45 = null;
		Token TYPES46 = null;
		Token INTEGER47 = null;
		Token COUNT48 = null;
		OPPLSyntaxTree IDENTIFIER25_tree = null;
		OPPLSyntaxTree VARIABLE_NAME26_tree = null;
		OPPLSyntaxTree FUNCTIONAL27_tree = null;
		OPPLSyntaxTree INVERSE_FUNCTIONAL28_tree = null;
		OPPLSyntaxTree SYMMETRIC29_tree = null;
		OPPLSyntaxTree ANTI_SYMMETRIC30_tree = null;
		OPPLSyntaxTree REFLEXIVE31_tree = null;
		OPPLSyntaxTree IRREFLEXIVE32_tree = null;
		OPPLSyntaxTree TRANSITIVE33_tree = null;
		OPPLSyntaxTree NOT34_tree = null;
		OPPLSyntaxTree AND35_tree = null;
		OPPLSyntaxTree OR36_tree = null;
		OPPLSyntaxTree SOME37_tree = null;
		OPPLSyntaxTree ONLY38_tree = null;
		OPPLSyntaxTree MIN39_tree = null;
		OPPLSyntaxTree MAX40_tree = null;
		OPPLSyntaxTree EXACTLY41_tree = null;
		OPPLSyntaxTree VALUE42_tree = null;
		OPPLSyntaxTree INVERSE43_tree = null;
		OPPLSyntaxTree DOMAIN44_tree = null;
		OPPLSyntaxTree RANGE45_tree = null;
		OPPLSyntaxTree TYPES46_tree = null;
		OPPLSyntaxTree INTEGER47_tree = null;
		OPPLSyntaxTree COUNT48_tree = null;
		RewriteRuleTokenStream stream_INTEGER = new RewriteRuleTokenStream(
				this.adaptor, "token INTEGER");
		RewriteRuleTokenStream stream_INVERSE = new RewriteRuleTokenStream(
				this.adaptor, "token INVERSE");
		RewriteRuleTokenStream stream_VARIABLE_NAME = new RewriteRuleTokenStream(
				this.adaptor, "token VARIABLE_NAME");
		RewriteRuleTokenStream stream_ANTI_SYMMETRIC = new RewriteRuleTokenStream(
				this.adaptor, "token ANTI_SYMMETRIC");
		RewriteRuleTokenStream stream_TRANSITIVE = new RewriteRuleTokenStream(
				this.adaptor, "token TRANSITIVE");
		RewriteRuleTokenStream stream_INVERSE_FUNCTIONAL = new RewriteRuleTokenStream(
				this.adaptor, "token INVERSE_FUNCTIONAL");
		RewriteRuleTokenStream stream_EXACTLY = new RewriteRuleTokenStream(
				this.adaptor, "token EXACTLY");
		RewriteRuleTokenStream stream_ONLY = new RewriteRuleTokenStream(
				this.adaptor, "token ONLY");
		RewriteRuleTokenStream stream_IDENTIFIER = new RewriteRuleTokenStream(
				this.adaptor, "token IDENTIFIER");
		RewriteRuleTokenStream stream_IRREFLEXIVE = new RewriteRuleTokenStream(
				this.adaptor, "token IRREFLEXIVE");
		RewriteRuleTokenStream stream_SOME = new RewriteRuleTokenStream(
				this.adaptor, "token SOME");
		RewriteRuleTokenStream stream_OR = new RewriteRuleTokenStream(
				this.adaptor, "token OR");
		RewriteRuleTokenStream stream_MAX = new RewriteRuleTokenStream(
				this.adaptor, "token MAX");
		RewriteRuleTokenStream stream_TYPES = new RewriteRuleTokenStream(
				this.adaptor, "token TYPES");
		RewriteRuleTokenStream stream_RANGE = new RewriteRuleTokenStream(
				this.adaptor, "token RANGE");
		RewriteRuleTokenStream stream_REFLEXIVE = new RewriteRuleTokenStream(
				this.adaptor, "token REFLEXIVE");
		RewriteRuleTokenStream stream_SYMMETRIC = new RewriteRuleTokenStream(
				this.adaptor, "token SYMMETRIC");
		RewriteRuleTokenStream stream_COUNT = new RewriteRuleTokenStream(
				this.adaptor, "token COUNT");
		RewriteRuleTokenStream stream_FUNCTIONAL = new RewriteRuleTokenStream(
				this.adaptor, "token FUNCTIONAL");
		RewriteRuleTokenStream stream_MIN = new RewriteRuleTokenStream(
				this.adaptor, "token MIN");
		RewriteRuleTokenStream stream_NOT = new RewriteRuleTokenStream(
				this.adaptor, "token NOT");
		RewriteRuleTokenStream stream_VALUE = new RewriteRuleTokenStream(
				this.adaptor, "token VALUE");
		RewriteRuleTokenStream stream_AND = new RewriteRuleTokenStream(
				this.adaptor, "token AND");
		RewriteRuleTokenStream stream_DOMAIN = new RewriteRuleTokenStream(
				this.adaptor, "token DOMAIN");
		try {
			// /Users/luigi/Documents/workspace/PARSERS/src/OPPLTestCaseCombined.g:122:2:
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
			// TEXT[$COUNT.text] ) )
			int alt8 = 24;
			switch (this.input.LA(1)) {
			case IDENTIFIER: {
				alt8 = 1;
			}
				break;
			case VARIABLE_NAME: {
				alt8 = 2;
			}
				break;
			case FUNCTIONAL: {
				alt8 = 3;
			}
				break;
			case INVERSE_FUNCTIONAL: {
				alt8 = 4;
			}
				break;
			case SYMMETRIC: {
				alt8 = 5;
			}
				break;
			case ANTI_SYMMETRIC: {
				alt8 = 6;
			}
				break;
			case REFLEXIVE: {
				alt8 = 7;
			}
				break;
			case IRREFLEXIVE: {
				alt8 = 8;
			}
				break;
			case TRANSITIVE: {
				alt8 = 9;
			}
				break;
			case NOT: {
				alt8 = 10;
			}
				break;
			case AND: {
				alt8 = 11;
			}
				break;
			case OR: {
				alt8 = 12;
			}
				break;
			case SOME: {
				alt8 = 13;
			}
				break;
			case ONLY: {
				alt8 = 14;
			}
				break;
			case MIN: {
				alt8 = 15;
			}
				break;
			case MAX: {
				alt8 = 16;
			}
				break;
			case EXACTLY: {
				alt8 = 17;
			}
				break;
			case VALUE: {
				alt8 = 18;
			}
				break;
			case INVERSE: {
				alt8 = 19;
			}
				break;
			case DOMAIN: {
				alt8 = 20;
			}
				break;
			case RANGE: {
				alt8 = 21;
			}
				break;
			case TYPES: {
				alt8 = 22;
			}
				break;
			case INTEGER: {
				alt8 = 23;
			}
				break;
			case COUNT: {
				alt8 = 24;
			}
				break;
			default:
				if (this.state.backtracking > 0) {
					this.state.failed = true;
					return retval;
				}
				NoViableAltException nvae = new NoViableAltException("", 8, 0,
						this.input);
				throw nvae;
			}
			switch (alt8) {
			case 1:
				// /Users/luigi/Documents/workspace/PARSERS/src/OPPLTestCaseCombined.g:123:4:
				// IDENTIFIER
			{
				IDENTIFIER25 = (Token) this.match(this.input, IDENTIFIER,
						FOLLOW_IDENTIFIER_in_textBit445);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_IDENTIFIER.add(IDENTIFIER25);
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
							this.adaptor, "rule retval",
							retval != null ? retval.tree : null);
					root_0 = (OPPLSyntaxTree) this.adaptor.nil();
					// 123:15: -> ^( TEXT[$IDENTIFIER.text] )
					{
						// /Users/luigi/Documents/workspace/PARSERS/src/OPPLTestCaseCombined.g:123:18:
						// ^( TEXT[$IDENTIFIER.text] )
						{
							OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor
									.nil();
							root_1 = (OPPLSyntaxTree) this.adaptor
									.becomeRoot(
											this.adaptor
													.create(
															TEXT,
															(IDENTIFIER25 != null ? IDENTIFIER25
																	.getText()
																	: null)),
											root_1);
							this.adaptor.addChild(root_0, root_1);
						}
					}
					retval.tree = root_0;
				}
			}
				break;
			case 2:
				// /Users/luigi/Documents/workspace/PARSERS/src/OPPLTestCaseCombined.g:124:6:
				// VARIABLE_NAME
			{
				VARIABLE_NAME26 = (Token) this.match(this.input, VARIABLE_NAME,
						FOLLOW_VARIABLE_NAME_in_textBit460);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_VARIABLE_NAME.add(VARIABLE_NAME26);
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
							this.adaptor, "rule retval",
							retval != null ? retval.tree : null);
					root_0 = (OPPLSyntaxTree) this.adaptor.nil();
					// 124:21: -> ^( TEXT VARIABLE_NAME )
					{
						// /Users/luigi/Documents/workspace/PARSERS/src/OPPLTestCaseCombined.g:124:24:
						// ^( TEXT VARIABLE_NAME )
						{
							OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor
									.nil();
							root_1 = (OPPLSyntaxTree) this.adaptor.becomeRoot(
									this.adaptor.create(TEXT, "TEXT"), root_1);
							this.adaptor.addChild(root_1, stream_VARIABLE_NAME
									.nextNode());
							this.adaptor.addChild(root_0, root_1);
						}
					}
					retval.tree = root_0;
				}
			}
				break;
			case 3:
				// /Users/luigi/Documents/workspace/PARSERS/src/OPPLTestCaseCombined.g:125:6:
				// FUNCTIONAL
			{
				FUNCTIONAL27 = (Token) this.match(this.input, FUNCTIONAL,
						FOLLOW_FUNCTIONAL_in_textBit476);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_FUNCTIONAL.add(FUNCTIONAL27);
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
							this.adaptor, "rule retval",
							retval != null ? retval.tree : null);
					root_0 = (OPPLSyntaxTree) this.adaptor.nil();
					// 125:17: -> ^( TEXT[$FUNCTIONAL.text] )
					{
						// /Users/luigi/Documents/workspace/PARSERS/src/OPPLTestCaseCombined.g:125:20:
						// ^( TEXT[$FUNCTIONAL.text] )
						{
							OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor
									.nil();
							root_1 = (OPPLSyntaxTree) this.adaptor
									.becomeRoot(
											this.adaptor
													.create(
															TEXT,
															(FUNCTIONAL27 != null ? FUNCTIONAL27
																	.getText()
																	: null)),
											root_1);
							this.adaptor.addChild(root_0, root_1);
						}
					}
					retval.tree = root_0;
				}
			}
				break;
			case 4:
				// /Users/luigi/Documents/workspace/PARSERS/src/OPPLTestCaseCombined.g:126:6:
				// INVERSE_FUNCTIONAL
			{
				INVERSE_FUNCTIONAL28 = (Token) this.match(this.input,
						INVERSE_FUNCTIONAL,
						FOLLOW_INVERSE_FUNCTIONAL_in_textBit491);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_INVERSE_FUNCTIONAL.add(INVERSE_FUNCTIONAL28);
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
							this.adaptor, "rule retval",
							retval != null ? retval.tree : null);
					root_0 = (OPPLSyntaxTree) this.adaptor.nil();
					// 126:25: -> ^( TEXT[$INVERSE_FUNCTIONAL.text] )
					{
						// /Users/luigi/Documents/workspace/PARSERS/src/OPPLTestCaseCombined.g:126:28:
						// ^( TEXT[$INVERSE_FUNCTIONAL.text] )
						{
							OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor
									.nil();
							root_1 = (OPPLSyntaxTree) this.adaptor
									.becomeRoot(
											this.adaptor
													.create(
															TEXT,
															(INVERSE_FUNCTIONAL28 != null ? INVERSE_FUNCTIONAL28
																	.getText()
																	: null)),
											root_1);
							this.adaptor.addChild(root_0, root_1);
						}
					}
					retval.tree = root_0;
				}
			}
				break;
			case 5:
				// /Users/luigi/Documents/workspace/PARSERS/src/OPPLTestCaseCombined.g:127:6:
				// SYMMETRIC
			{
				SYMMETRIC29 = (Token) this.match(this.input, SYMMETRIC,
						FOLLOW_SYMMETRIC_in_textBit506);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_SYMMETRIC.add(SYMMETRIC29);
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
							this.adaptor, "rule retval",
							retval != null ? retval.tree : null);
					root_0 = (OPPLSyntaxTree) this.adaptor.nil();
					// 127:16: -> ^( TEXT[$SYMMETRIC.text] )
					{
						// /Users/luigi/Documents/workspace/PARSERS/src/OPPLTestCaseCombined.g:127:19:
						// ^( TEXT[$SYMMETRIC.text] )
						{
							OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor
									.nil();
							root_1 = (OPPLSyntaxTree) this.adaptor
									.becomeRoot(this.adaptor.create(TEXT,
											(SYMMETRIC29 != null ? SYMMETRIC29
													.getText() : null)), root_1);
							this.adaptor.addChild(root_0, root_1);
						}
					}
					retval.tree = root_0;
				}
			}
				break;
			case 6:
				// /Users/luigi/Documents/workspace/PARSERS/src/OPPLTestCaseCombined.g:128:6:
				// ANTI_SYMMETRIC
			{
				ANTI_SYMMETRIC30 = (Token) this.match(this.input,
						ANTI_SYMMETRIC, FOLLOW_ANTI_SYMMETRIC_in_textBit521);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_ANTI_SYMMETRIC.add(ANTI_SYMMETRIC30);
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
							this.adaptor, "rule retval",
							retval != null ? retval.tree : null);
					root_0 = (OPPLSyntaxTree) this.adaptor.nil();
					// 128:21: -> ^( TEXT[$ANTI_SYMMETRIC.text] )
					{
						// /Users/luigi/Documents/workspace/PARSERS/src/OPPLTestCaseCombined.g:128:24:
						// ^( TEXT[$ANTI_SYMMETRIC.text] )
						{
							OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor
									.nil();
							root_1 = (OPPLSyntaxTree) this.adaptor
									.becomeRoot(
											this.adaptor
													.create(
															TEXT,
															(ANTI_SYMMETRIC30 != null ? ANTI_SYMMETRIC30
																	.getText()
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
				// /Users/luigi/Documents/workspace/PARSERS/src/OPPLTestCaseCombined.g:129:6:
				// REFLEXIVE
			{
				REFLEXIVE31 = (Token) this.match(this.input, REFLEXIVE,
						FOLLOW_REFLEXIVE_in_textBit536);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_REFLEXIVE.add(REFLEXIVE31);
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
							this.adaptor, "rule retval",
							retval != null ? retval.tree : null);
					root_0 = (OPPLSyntaxTree) this.adaptor.nil();
					// 129:16: -> ^( TEXT[$REFLEXIVE.text] )
					{
						// /Users/luigi/Documents/workspace/PARSERS/src/OPPLTestCaseCombined.g:129:19:
						// ^( TEXT[$REFLEXIVE.text] )
						{
							OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor
									.nil();
							root_1 = (OPPLSyntaxTree) this.adaptor
									.becomeRoot(this.adaptor.create(TEXT,
											(REFLEXIVE31 != null ? REFLEXIVE31
													.getText() : null)), root_1);
							this.adaptor.addChild(root_0, root_1);
						}
					}
					retval.tree = root_0;
				}
			}
				break;
			case 8:
				// /Users/luigi/Documents/workspace/PARSERS/src/OPPLTestCaseCombined.g:130:6:
				// IRREFLEXIVE
			{
				IRREFLEXIVE32 = (Token) this.match(this.input, IRREFLEXIVE,
						FOLLOW_IRREFLEXIVE_in_textBit551);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_IRREFLEXIVE.add(IRREFLEXIVE32);
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
							this.adaptor, "rule retval",
							retval != null ? retval.tree : null);
					root_0 = (OPPLSyntaxTree) this.adaptor.nil();
					// 130:18: -> ^( TEXT[$IRREFLEXIVE.text] )
					{
						// /Users/luigi/Documents/workspace/PARSERS/src/OPPLTestCaseCombined.g:130:21:
						// ^( TEXT[$IRREFLEXIVE.text] )
						{
							OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor
									.nil();
							root_1 = (OPPLSyntaxTree) this.adaptor
									.becomeRoot(
											this.adaptor
													.create(
															TEXT,
															(IRREFLEXIVE32 != null ? IRREFLEXIVE32
																	.getText()
																	: null)),
											root_1);
							this.adaptor.addChild(root_0, root_1);
						}
					}
					retval.tree = root_0;
				}
			}
				break;
			case 9:
				// /Users/luigi/Documents/workspace/PARSERS/src/OPPLTestCaseCombined.g:131:7:
				// TRANSITIVE
			{
				TRANSITIVE33 = (Token) this.match(this.input, TRANSITIVE,
						FOLLOW_TRANSITIVE_in_textBit567);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_TRANSITIVE.add(TRANSITIVE33);
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
							this.adaptor, "rule retval",
							retval != null ? retval.tree : null);
					root_0 = (OPPLSyntaxTree) this.adaptor.nil();
					// 131:18: -> ^( TEXT[$TRANSITIVE.text] )
					{
						// /Users/luigi/Documents/workspace/PARSERS/src/OPPLTestCaseCombined.g:131:21:
						// ^( TEXT[$TRANSITIVE.text] )
						{
							OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor
									.nil();
							root_1 = (OPPLSyntaxTree) this.adaptor
									.becomeRoot(
											this.adaptor
													.create(
															TEXT,
															(TRANSITIVE33 != null ? TRANSITIVE33
																	.getText()
																	: null)),
											root_1);
							this.adaptor.addChild(root_0, root_1);
						}
					}
					retval.tree = root_0;
				}
			}
				break;
			case 10:
				// /Users/luigi/Documents/workspace/PARSERS/src/OPPLTestCaseCombined.g:132:6:
				// NOT
			{
				NOT34 = (Token) this.match(this.input, NOT,
						FOLLOW_NOT_in_textBit582);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_NOT.add(NOT34);
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
							this.adaptor, "rule retval",
							retval != null ? retval.tree : null);
					root_0 = (OPPLSyntaxTree) this.adaptor.nil();
					// 132:10: -> ^( TEXT[$NOT.text] )
					{
						// /Users/luigi/Documents/workspace/PARSERS/src/OPPLTestCaseCombined.g:132:13:
						// ^( TEXT[$NOT.text] )
						{
							OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor
									.nil();
							root_1 = (OPPLSyntaxTree) this.adaptor.becomeRoot(
									this.adaptor.create(TEXT,
											(NOT34 != null ? NOT34.getText()
													: null)), root_1);
							this.adaptor.addChild(root_0, root_1);
						}
					}
					retval.tree = root_0;
				}
			}
				break;
			case 11:
				// /Users/luigi/Documents/workspace/PARSERS/src/OPPLTestCaseCombined.g:133:6:
				// AND
			{
				AND35 = (Token) this.match(this.input, AND,
						FOLLOW_AND_in_textBit597);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_AND.add(AND35);
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
							this.adaptor, "rule retval",
							retval != null ? retval.tree : null);
					root_0 = (OPPLSyntaxTree) this.adaptor.nil();
					// 133:10: -> ^( TEXT[$AND.text] )
					{
						// /Users/luigi/Documents/workspace/PARSERS/src/OPPLTestCaseCombined.g:133:13:
						// ^( TEXT[$AND.text] )
						{
							OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor
									.nil();
							root_1 = (OPPLSyntaxTree) this.adaptor.becomeRoot(
									this.adaptor.create(TEXT,
											(AND35 != null ? AND35.getText()
													: null)), root_1);
							this.adaptor.addChild(root_0, root_1);
						}
					}
					retval.tree = root_0;
				}
			}
				break;
			case 12:
				// /Users/luigi/Documents/workspace/PARSERS/src/OPPLTestCaseCombined.g:134:6:
				// OR
			{
				OR36 = (Token) this.match(this.input, OR,
						FOLLOW_OR_in_textBit612);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_OR.add(OR36);
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
							this.adaptor, "rule retval",
							retval != null ? retval.tree : null);
					root_0 = (OPPLSyntaxTree) this.adaptor.nil();
					// 134:9: -> ^( TEXT[$OR.text] )
					{
						// /Users/luigi/Documents/workspace/PARSERS/src/OPPLTestCaseCombined.g:134:12:
						// ^( TEXT[$OR.text] )
						{
							OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor
									.nil();
							root_1 = (OPPLSyntaxTree) this.adaptor.becomeRoot(
									this.adaptor.create(TEXT,
											(OR36 != null ? OR36.getText()
													: null)), root_1);
							this.adaptor.addChild(root_0, root_1);
						}
					}
					retval.tree = root_0;
				}
			}
				break;
			case 13:
				// /Users/luigi/Documents/workspace/PARSERS/src/OPPLTestCaseCombined.g:135:6:
				// SOME
			{
				SOME37 = (Token) this.match(this.input, SOME,
						FOLLOW_SOME_in_textBit627);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_SOME.add(SOME37);
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
							this.adaptor, "rule retval",
							retval != null ? retval.tree : null);
					root_0 = (OPPLSyntaxTree) this.adaptor.nil();
					// 135:11: -> ^( TEXT[$SOME.text] )
					{
						// /Users/luigi/Documents/workspace/PARSERS/src/OPPLTestCaseCombined.g:135:14:
						// ^( TEXT[$SOME.text] )
						{
							OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor
									.nil();
							root_1 = (OPPLSyntaxTree) this.adaptor.becomeRoot(
									this.adaptor.create(TEXT,
											(SOME37 != null ? SOME37.getText()
													: null)), root_1);
							this.adaptor.addChild(root_0, root_1);
						}
					}
					retval.tree = root_0;
				}
			}
				break;
			case 14:
				// /Users/luigi/Documents/workspace/PARSERS/src/OPPLTestCaseCombined.g:136:6:
				// ONLY
			{
				ONLY38 = (Token) this.match(this.input, ONLY,
						FOLLOW_ONLY_in_textBit642);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_ONLY.add(ONLY38);
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
							this.adaptor, "rule retval",
							retval != null ? retval.tree : null);
					root_0 = (OPPLSyntaxTree) this.adaptor.nil();
					// 136:11: -> ^( TEXT[$ONLY.text] )
					{
						// /Users/luigi/Documents/workspace/PARSERS/src/OPPLTestCaseCombined.g:136:14:
						// ^( TEXT[$ONLY.text] )
						{
							OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor
									.nil();
							root_1 = (OPPLSyntaxTree) this.adaptor.becomeRoot(
									this.adaptor.create(TEXT,
											(ONLY38 != null ? ONLY38.getText()
													: null)), root_1);
							this.adaptor.addChild(root_0, root_1);
						}
					}
					retval.tree = root_0;
				}
			}
				break;
			case 15:
				// /Users/luigi/Documents/workspace/PARSERS/src/OPPLTestCaseCombined.g:137:6:
				// MIN
			{
				MIN39 = (Token) this.match(this.input, MIN,
						FOLLOW_MIN_in_textBit657);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_MIN.add(MIN39);
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
							this.adaptor, "rule retval",
							retval != null ? retval.tree : null);
					root_0 = (OPPLSyntaxTree) this.adaptor.nil();
					// 137:10: -> ^( TEXT[$MIN.text] )
					{
						// /Users/luigi/Documents/workspace/PARSERS/src/OPPLTestCaseCombined.g:137:13:
						// ^( TEXT[$MIN.text] )
						{
							OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor
									.nil();
							root_1 = (OPPLSyntaxTree) this.adaptor.becomeRoot(
									this.adaptor.create(TEXT,
											(MIN39 != null ? MIN39.getText()
													: null)), root_1);
							this.adaptor.addChild(root_0, root_1);
						}
					}
					retval.tree = root_0;
				}
			}
				break;
			case 16:
				// /Users/luigi/Documents/workspace/PARSERS/src/OPPLTestCaseCombined.g:138:6:
				// MAX
			{
				MAX40 = (Token) this.match(this.input, MAX,
						FOLLOW_MAX_in_textBit672);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_MAX.add(MAX40);
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
							this.adaptor, "rule retval",
							retval != null ? retval.tree : null);
					root_0 = (OPPLSyntaxTree) this.adaptor.nil();
					// 138:10: -> ^( TEXT[$MAX.text] )
					{
						// /Users/luigi/Documents/workspace/PARSERS/src/OPPLTestCaseCombined.g:138:13:
						// ^( TEXT[$MAX.text] )
						{
							OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor
									.nil();
							root_1 = (OPPLSyntaxTree) this.adaptor.becomeRoot(
									this.adaptor.create(TEXT,
											(MAX40 != null ? MAX40.getText()
													: null)), root_1);
							this.adaptor.addChild(root_0, root_1);
						}
					}
					retval.tree = root_0;
				}
			}
				break;
			case 17:
				// /Users/luigi/Documents/workspace/PARSERS/src/OPPLTestCaseCombined.g:139:6:
				// EXACTLY
			{
				EXACTLY41 = (Token) this.match(this.input, EXACTLY,
						FOLLOW_EXACTLY_in_textBit690);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_EXACTLY.add(EXACTLY41);
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
							this.adaptor, "rule retval",
							retval != null ? retval.tree : null);
					root_0 = (OPPLSyntaxTree) this.adaptor.nil();
					// 139:14: -> ^( TEXT[$EXACTLY.text] )
					{
						// /Users/luigi/Documents/workspace/PARSERS/src/OPPLTestCaseCombined.g:139:17:
						// ^( TEXT[$EXACTLY.text] )
						{
							OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor
									.nil();
							root_1 = (OPPLSyntaxTree) this.adaptor
									.becomeRoot(this.adaptor.create(TEXT,
											(EXACTLY41 != null ? EXACTLY41
													.getText() : null)), root_1);
							this.adaptor.addChild(root_0, root_1);
						}
					}
					retval.tree = root_0;
				}
			}
				break;
			case 18:
				// /Users/luigi/Documents/workspace/PARSERS/src/OPPLTestCaseCombined.g:140:6:
				// VALUE
			{
				VALUE42 = (Token) this.match(this.input, VALUE,
						FOLLOW_VALUE_in_textBit708);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_VALUE.add(VALUE42);
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
							this.adaptor, "rule retval",
							retval != null ? retval.tree : null);
					root_0 = (OPPLSyntaxTree) this.adaptor.nil();
					// 140:12: -> ^( TEXT[$VALUE.text] )
					{
						// /Users/luigi/Documents/workspace/PARSERS/src/OPPLTestCaseCombined.g:140:15:
						// ^( TEXT[$VALUE.text] )
						{
							OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor
									.nil();
							root_1 = (OPPLSyntaxTree) this.adaptor
									.becomeRoot(this.adaptor.create(TEXT,
											(VALUE42 != null ? VALUE42
													.getText() : null)), root_1);
							this.adaptor.addChild(root_0, root_1);
						}
					}
					retval.tree = root_0;
				}
			}
				break;
			case 19:
				// /Users/luigi/Documents/workspace/PARSERS/src/OPPLTestCaseCombined.g:141:6:
				// INVERSE
			{
				INVERSE43 = (Token) this.match(this.input, INVERSE,
						FOLLOW_INVERSE_in_textBit726);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_INVERSE.add(INVERSE43);
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
							this.adaptor, "rule retval",
							retval != null ? retval.tree : null);
					root_0 = (OPPLSyntaxTree) this.adaptor.nil();
					// 141:14: -> ^( TEXT[$INVERSE.text] )
					{
						// /Users/luigi/Documents/workspace/PARSERS/src/OPPLTestCaseCombined.g:141:17:
						// ^( TEXT[$INVERSE.text] )
						{
							OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor
									.nil();
							root_1 = (OPPLSyntaxTree) this.adaptor
									.becomeRoot(this.adaptor.create(TEXT,
											(INVERSE43 != null ? INVERSE43
													.getText() : null)), root_1);
							this.adaptor.addChild(root_0, root_1);
						}
					}
					retval.tree = root_0;
				}
			}
				break;
			case 20:
				// /Users/luigi/Documents/workspace/PARSERS/src/OPPLTestCaseCombined.g:142:6:
				// DOMAIN
			{
				DOMAIN44 = (Token) this.match(this.input, DOMAIN,
						FOLLOW_DOMAIN_in_textBit744);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_DOMAIN.add(DOMAIN44);
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
							this.adaptor, "rule retval",
							retval != null ? retval.tree : null);
					root_0 = (OPPLSyntaxTree) this.adaptor.nil();
					// 142:13: -> ^( TEXT[$DOMAIN.text] )
					{
						// /Users/luigi/Documents/workspace/PARSERS/src/OPPLTestCaseCombined.g:142:16:
						// ^( TEXT[$DOMAIN.text] )
						{
							OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor
									.nil();
							root_1 = (OPPLSyntaxTree) this.adaptor
									.becomeRoot(this.adaptor.create(TEXT,
											(DOMAIN44 != null ? DOMAIN44
													.getText() : null)), root_1);
							this.adaptor.addChild(root_0, root_1);
						}
					}
					retval.tree = root_0;
				}
			}
				break;
			case 21:
				// /Users/luigi/Documents/workspace/PARSERS/src/OPPLTestCaseCombined.g:143:6:
				// RANGE
			{
				RANGE45 = (Token) this.match(this.input, RANGE,
						FOLLOW_RANGE_in_textBit762);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_RANGE.add(RANGE45);
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
							this.adaptor, "rule retval",
							retval != null ? retval.tree : null);
					root_0 = (OPPLSyntaxTree) this.adaptor.nil();
					// 143:12: -> ^( TEXT[$RANGE.text] )
					{
						// /Users/luigi/Documents/workspace/PARSERS/src/OPPLTestCaseCombined.g:143:15:
						// ^( TEXT[$RANGE.text] )
						{
							OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor
									.nil();
							root_1 = (OPPLSyntaxTree) this.adaptor
									.becomeRoot(this.adaptor.create(TEXT,
											(RANGE45 != null ? RANGE45
													.getText() : null)), root_1);
							this.adaptor.addChild(root_0, root_1);
						}
					}
					retval.tree = root_0;
				}
			}
				break;
			case 22:
				// /Users/luigi/Documents/workspace/PARSERS/src/OPPLTestCaseCombined.g:144:6:
				// TYPES
			{
				TYPES46 = (Token) this.match(this.input, TYPES,
						FOLLOW_TYPES_in_textBit777);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_TYPES.add(TYPES46);
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
							this.adaptor, "rule retval",
							retval != null ? retval.tree : null);
					root_0 = (OPPLSyntaxTree) this.adaptor.nil();
					// 144:12: -> ^( TEXT[$TYPES.text] )
					{
						// /Users/luigi/Documents/workspace/PARSERS/src/OPPLTestCaseCombined.g:144:15:
						// ^( TEXT[$TYPES.text] )
						{
							OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor
									.nil();
							root_1 = (OPPLSyntaxTree) this.adaptor
									.becomeRoot(this.adaptor.create(TEXT,
											(TYPES46 != null ? TYPES46
													.getText() : null)), root_1);
							this.adaptor.addChild(root_0, root_1);
						}
					}
					retval.tree = root_0;
				}
			}
				break;
			case 23:
				// /Users/luigi/Documents/workspace/PARSERS/src/OPPLTestCaseCombined.g:145:6:
				// INTEGER
			{
				INTEGER47 = (Token) this.match(this.input, INTEGER,
						FOLLOW_INTEGER_in_textBit798);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_INTEGER.add(INTEGER47);
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
							this.adaptor, "rule retval",
							retval != null ? retval.tree : null);
					root_0 = (OPPLSyntaxTree) this.adaptor.nil();
					// 145:14: -> ^( TEXT[$INTEGER.text] )
					{
						// /Users/luigi/Documents/workspace/PARSERS/src/OPPLTestCaseCombined.g:145:17:
						// ^( TEXT[$INTEGER.text] )
						{
							OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor
									.nil();
							root_1 = (OPPLSyntaxTree) this.adaptor
									.becomeRoot(this.adaptor.create(TEXT,
											(INTEGER47 != null ? INTEGER47
													.getText() : null)), root_1);
							this.adaptor.addChild(root_0, root_1);
						}
					}
					retval.tree = root_0;
				}
			}
				break;
			case 24:
				// /Users/luigi/Documents/workspace/PARSERS/src/OPPLTestCaseCombined.g:146:6:
				// COUNT
			{
				COUNT48 = (Token) this.match(this.input, COUNT,
						FOLLOW_COUNT_in_textBit819);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_COUNT.add(COUNT48);
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
							this.adaptor, "rule retval",
							retval != null ? retval.tree : null);
					root_0 = (OPPLSyntaxTree) this.adaptor.nil();
					// 146:12: -> ^( TEXT[$COUNT.text] )
					{
						// /Users/luigi/Documents/workspace/PARSERS/src/OPPLTestCaseCombined.g:146:15:
						// ^( TEXT[$COUNT.text] )
						{
							OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor
									.nil();
							root_1 = (OPPLSyntaxTree) this.adaptor
									.becomeRoot(this.adaptor.create(TEXT,
											(COUNT48 != null ? COUNT48
													.getText() : null)), root_1);
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
				retval.tree = (OPPLSyntaxTree) this.adaptor
						.rulePostProcessing(root_0);
				this.adaptor.setTokenBoundaries(retval.tree, retval.start,
						retval.stop);
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
	// /Users/luigi/Documents/workspace/PARSERS/src/OPPLTestCaseCombined.g:149:1:
	// statement : ( variableDefinitions )? query -> ^( OPPL_STATEMENT (
	// variableDefinitions )? query ) ;
	public final OPPLTestCaseCombinedParser.statement_return statement()
			throws RecognitionException {
		OPPLTestCaseCombinedParser.statement_return retval = new OPPLTestCaseCombinedParser.statement_return();
		retval.start = this.input.LT(1);
		OPPLSyntaxTree root_0 = null;
		OPPLTestCaseCombined_OPPLParser.variableDefinitions_return variableDefinitions49 = null;
		OPPLTestCaseCombined_OPPLParser.query_return query50 = null;
		RewriteRuleSubtreeStream stream_query = new RewriteRuleSubtreeStream(
				this.adaptor, "rule query");
		RewriteRuleSubtreeStream stream_variableDefinitions = new RewriteRuleSubtreeStream(
				this.adaptor, "rule variableDefinitions");
		try {
			// /Users/luigi/Documents/workspace/PARSERS/src/OPPLTestCaseCombined.g:150:3:
			// ( ( variableDefinitions )? query -> ^( OPPL_STATEMENT (
			// variableDefinitions )? query ) )
			// /Users/luigi/Documents/workspace/PARSERS/src/OPPLTestCaseCombined.g:151:5:
			// ( variableDefinitions )? query
			{
				// /Users/luigi/Documents/workspace/PARSERS/src/OPPLTestCaseCombined.g:151:5:
				// ( variableDefinitions )?
				int alt9 = 2;
				int LA9_0 = this.input.LA(1);
				if (LA9_0 == VARIABLE_NAME) {
					alt9 = 1;
				}
				switch (alt9) {
				case 1:
					// /Users/luigi/Documents/workspace/PARSERS/src/OPPLTestCaseCombined.g:151:5:
					// variableDefinitions
				{
					this.pushFollow(FOLLOW_variableDefinitions_in_statement848);
					variableDefinitions49 = this.variableDefinitions();
					this.state._fsp--;
					if (this.state.failed) {
						return retval;
					}
					if (this.state.backtracking == 0) {
						stream_variableDefinitions.add(variableDefinitions49
								.getTree());
					}
				}
					break;
				}
				this.pushFollow(FOLLOW_query_in_statement851);
				query50 = this.query();
				this.state._fsp--;
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_query.add(query50.getTree());
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
							this.adaptor, "rule retval",
							retval != null ? retval.tree : null);
					root_0 = (OPPLSyntaxTree) this.adaptor.nil();
					// 151:33: -> ^( OPPL_STATEMENT ( variableDefinitions )?
					// query )
					{
						// /Users/luigi/Documents/workspace/PARSERS/src/OPPLTestCaseCombined.g:151:36:
						// ^( OPPL_STATEMENT ( variableDefinitions )? query )
						{
							OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor
									.nil();
							root_1 = (OPPLSyntaxTree) this.adaptor.becomeRoot(
									this.adaptor.create(OPPL_STATEMENT,
											"OPPL_STATEMENT"), root_1);
							// /Users/luigi/Documents/workspace/PARSERS/src/OPPLTestCaseCombined.g:151:53:
							// ( variableDefinitions )?
							if (stream_variableDefinitions.hasNext()) {
								this.adaptor.addChild(root_1,
										stream_variableDefinitions.nextTree());
							}
							stream_variableDefinitions.reset();
							this.adaptor.addChild(root_1, stream_query
									.nextTree());
							this.adaptor.addChild(root_0, root_1);
						}
					}
					retval.tree = root_0;
				}
			}
			retval.stop = this.input.LT(-1);
			if (this.state.backtracking == 0) {
				retval.tree = (OPPLSyntaxTree) this.adaptor
						.rulePostProcessing(root_0);
				this.adaptor.setTokenBoundaries(retval.tree, retval.start,
						retval.stop);
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
	public final void synpred1_OPPLTestCaseCombined_fragment()
			throws RecognitionException {
		OPPLTestCaseCombinedParser.assertionExpression_return left = null;
		OPPLTestCaseCombinedParser.assertionExpression_return right = null;
		// /Users/luigi/Documents/workspace/PARSERS/src/OPPLTestCaseCombined.g:91:3:
		// (left= assertionExpression EQUAL right= assertionExpression )
		// /Users/luigi/Documents/workspace/PARSERS/src/OPPLTestCaseCombined.g:91:3:
		// left= assertionExpression EQUAL right= assertionExpression
		{
			this
					.pushFollow(FOLLOW_assertionExpression_in_synpred1_OPPLTestCaseCombined244);
			left = this.assertionExpression();
			this.state._fsp--;
			if (this.state.failed) {
				return;
			}
			this.match(this.input, EQUAL,
					FOLLOW_EQUAL_in_synpred1_OPPLTestCaseCombined246);
			if (this.state.failed) {
				return;
			}
			this
					.pushFollow(FOLLOW_assertionExpression_in_synpred1_OPPLTestCaseCombined251);
			right = this.assertionExpression();
			this.state._fsp--;
			if (this.state.failed) {
				return;
			}
		}
	}

	// $ANTLR end synpred1_OPPLTestCaseCombined
	// $ANTLR start synpred2_OPPLTestCaseCombined
	public final void synpred2_OPPLTestCaseCombined_fragment()
			throws RecognitionException {
		OPPLTestCaseCombinedParser.assertionExpression_return left = null;
		OPPLTestCaseCombinedParser.assertionExpression_return right = null;
		// /Users/luigi/Documents/workspace/PARSERS/src/OPPLTestCaseCombined.g:92:5:
		// (left= assertionExpression NOT_EQUAL right= assertionExpression )
		// /Users/luigi/Documents/workspace/PARSERS/src/OPPLTestCaseCombined.g:92:5:
		// left= assertionExpression NOT_EQUAL right= assertionExpression
		{
			this
					.pushFollow(FOLLOW_assertionExpression_in_synpred2_OPPLTestCaseCombined272);
			left = this.assertionExpression();
			this.state._fsp--;
			if (this.state.failed) {
				return;
			}
			this.match(this.input, NOT_EQUAL,
					FOLLOW_NOT_EQUAL_in_synpred2_OPPLTestCaseCombined274);
			if (this.state.failed) {
				return;
			}
			this
					.pushFollow(FOLLOW_assertionExpression_in_synpred2_OPPLTestCaseCombined279);
			right = this.assertionExpression();
			this.state._fsp--;
			if (this.state.failed) {
				return;
			}
		}
	}

	// $ANTLR end synpred2_OPPLTestCaseCombined
	// $ANTLR start synpred3_OPPLTestCaseCombined
	public final void synpred3_OPPLTestCaseCombined_fragment()
			throws RecognitionException {
		// /Users/luigi/Documents/workspace/PARSERS/src/OPPLTestCaseCombined.g:93:5:
		// ( VARIABLE_NAME CONTAINS assertionExpression ( COMMA
		// assertionExpression )? )
		// /Users/luigi/Documents/workspace/PARSERS/src/OPPLTestCaseCombined.g:93:5:
		// VARIABLE_NAME CONTAINS assertionExpression ( COMMA
		// assertionExpression )?
		{
			this.match(this.input, VARIABLE_NAME,
					FOLLOW_VARIABLE_NAME_in_synpred3_OPPLTestCaseCombined297);
			if (this.state.failed) {
				return;
			}
			this.match(this.input, CONTAINS,
					FOLLOW_CONTAINS_in_synpred3_OPPLTestCaseCombined300);
			if (this.state.failed) {
				return;
			}
			this
					.pushFollow(FOLLOW_assertionExpression_in_synpred3_OPPLTestCaseCombined302);
			this.assertionExpression();
			this.state._fsp--;
			if (this.state.failed) {
				return;
			}
			// /Users/luigi/Documents/workspace/PARSERS/src/OPPLTestCaseCombined.g:93:49:
			// ( COMMA assertionExpression )?
			int alt10 = 2;
			int LA10_0 = this.input.LA(1);
			if (LA10_0 == COMMA) {
				alt10 = 1;
			}
			switch (alt10) {
			case 1:
				// /Users/luigi/Documents/workspace/PARSERS/src/OPPLTestCaseCombined.g:93:50:
				// COMMA assertionExpression
			{
				this.match(this.input, COMMA,
						FOLLOW_COMMA_in_synpred3_OPPLTestCaseCombined305);
				if (this.state.failed) {
					return;
				}
				this
						.pushFollow(FOLLOW_assertionExpression_in_synpred3_OPPLTestCaseCombined307);
				this.assertionExpression();
				this.state._fsp--;
				if (this.state.failed) {
					return;
				}
			}
				break;
			}
		}
	}

	// $ANTLR end synpred3_OPPLTestCaseCombined
	// Delegated rules
	public OPPLTestCaseCombined_OPPLParser.variableDefinitions_return variableDefinitions()
			throws RecognitionException {
		return this.gOPPLParser.variableDefinitions();
	}

	public OPPLTestCaseCombined_OPPLParser_MOWLParser.value_return value()
			throws RecognitionException {
		return this.gMOWLParser.value();
	}

	public OPPLTestCaseCombined_OPPLParser.attributeSelector_return attributeSelector()
			throws RecognitionException {
		return this.gOPPLParser.attributeSelector();
	}

	public OPPLTestCaseCombined_OPPLParser.createIdentifier_return createIdentifier()
			throws RecognitionException {
		return this.gOPPLParser.createIdentifier();
	}

	public OPPLTestCaseCombined_OPPLParser.query_return query()
			throws RecognitionException {
		return this.gOPPLParser.query();
	}

	public OPPLTestCaseCombined_OPPLParser.atomic_return atomic()
			throws RecognitionException {
		return this.gOPPLParser.atomic();
	}

	public OPPLTestCaseCombined_OPPLParser_MOWLParser.qualifiedRestriction_return qualifiedRestriction()
			throws RecognitionException {
		return this.gMOWLParser.qualifiedRestriction();
	}

	public OPPLTestCaseCombined_OPPLParser_MOWLParser.valueRestriction_return valueRestriction()
			throws RecognitionException {
		return this.gMOWLParser.valueRestriction();
	}

	public OPPLTestCaseCombined_OPPLParser_MOWLParser.expression_return expression()
			throws RecognitionException {
		return this.gMOWLParser.expression();
	}

	public OPPLTestCaseCombined_OPPLParser_MOWLParser.unary_return unary()
			throws RecognitionException {
		return this.gMOWLParser.unary();
	}

	public OPPLTestCaseCombined_OPPLParser_MOWLParser.complexPropertyExpression_return complexPropertyExpression()
			throws RecognitionException {
		return this.gMOWLParser.complexPropertyExpression();
	}

	public OPPLTestCaseCombined_OPPLParser.variableAttributeReference_return variableAttributeReference()
			throws RecognitionException {
		return this.gOPPLParser.variableAttributeReference();
	}

	public OPPLTestCaseCombined_OPPLParser_MOWLParser.propertyExpression_return propertyExpression()
			throws RecognitionException {
		return this.gMOWLParser.propertyExpression();
	}

	public OPPLTestCaseCombined_OPPLParser.opplFunction_return opplFunction()
			throws RecognitionException {
		return this.gOPPLParser.opplFunction();
	}

	public OPPLTestCaseCombined_OPPLParser.stringExpression_return stringExpression()
			throws RecognitionException {
		return this.gOPPLParser.stringExpression();
	}

	public OPPLTestCaseCombined_OPPLParser_MOWLParser.oneOf_return oneOf()
			throws RecognitionException {
		return this.gMOWLParser.oneOf();
	}

	public OPPLTestCaseCombined_OPPLParser_MOWLParser.axiom_return axiom()
			throws RecognitionException {
		return this.gMOWLParser.axiom();
	}

	public OPPLTestCaseCombined_OPPLParser_MOWLParser.restrictionKind_return restrictionKind()
			throws RecognitionException {
		return this.gMOWLParser.restrictionKind();
	}

	public OPPLTestCaseCombined_OPPLParser.selectClause_return selectClause()
			throws RecognitionException {
		return this.gOPPLParser.selectClause();
	}

	public OPPLTestCaseCombined_OPPLParser.constraint_return constraint()
			throws RecognitionException {
		return this.gOPPLParser.constraint();
	}

	public OPPLTestCaseCombined_OPPLParser.stringOperation_return stringOperation()
			throws RecognitionException {
		return this.gOPPLParser.stringOperation();
	}

	public OPPLTestCaseCombined_OPPLParser.action_return action()
			throws RecognitionException {
		return this.gOPPLParser.action();
	}

	public OPPLTestCaseCombined_OPPLParser_MOWLParser.unaryCharacteristic_return unaryCharacteristic()
			throws RecognitionException {
		return this.gMOWLParser.unaryCharacteristic();
	}

	public OPPLTestCaseCombined_OPPLParser_MOWLParser.binaryAxiom_return binaryAxiom()
			throws RecognitionException {
		return this.gMOWLParser.binaryAxiom();
	}

	public OPPLTestCaseCombined_OPPLParser.variableScope_return variableScope()
			throws RecognitionException {
		return this.gOPPLParser.variableScope();
	}

	public OPPLTestCaseCombined_OPPLParser_MOWLParser.conjunction_return conjunction()
			throws RecognitionException {
		return this.gMOWLParser.conjunction();
	}

	public OPPLTestCaseCombined_OPPLParser_MOWLParser.assertionAxiom_return assertionAxiom()
			throws RecognitionException {
		return this.gMOWLParser.assertionAxiom();
	}

	public OPPLTestCaseCombined_OPPLParser_MOWLParser.constant_return constant()
			throws RecognitionException {
		return this.gMOWLParser.constant();
	}

	public OPPLTestCaseCombined_OPPLParser.variableDefinition_return variableDefinition()
			throws RecognitionException {
		return this.gOPPLParser.variableDefinition();
	}

	public OPPLTestCaseCombined_OPPLParser_MOWLParser.unaryAxiom_return unaryAxiom()
			throws RecognitionException {
		return this.gMOWLParser.unaryAxiom();
	}

	public OPPLTestCaseCombined_OPPLParser.actions_return actions()
			throws RecognitionException {
		return this.gOPPLParser.actions();
	}

	public OPPLTestCaseCombined_OPPLParser_MOWLParser.cardinalityRestriction_return cardinalityRestriction()
			throws RecognitionException {
		return this.gMOWLParser.cardinalityRestriction();
	}

	public OPPLTestCaseCombined_OPPLParser.regexp_return regexp()
			throws RecognitionException {
		return this.gOPPLParser.regexp();
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

	protected DFA5 dfa5 = new DFA5(this);
	static final String DFA5_eotS = "\20\uffff";
	static final String DFA5_eofS = "\20\uffff";
	static final String DFA5_minS = "\1\5\2\0\1\uffff\11\0\3\uffff";
	static final String DFA5_maxS = "\1\u01d4\2\0\1\uffff\11\0\3\uffff";
	static final String DFA5_acceptS = "\3\uffff\1\1\11\uffff\1\2\1\3\1\4";
	static final String DFA5_specialS = "\1\uffff\1\0\1\1\1\uffff\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12"
			+ "\3\uffff}>";
	static final String[] DFA5_transitionS = {
			"\1\14\1\12\5\uffff\1\11\6\uffff\1\10\24\uffff\1\13\1\uffff\1"
					+ "\2\1\uffff\1\4\1\5\32\uffff\1\15\1\3\113\uffff\1\7\u013a\uffff"
					+ "\1\6\3\uffff\1\1", "\1\uffff", "\1\uffff", "",
			"\1\uffff", "\1\uffff", "\1\uffff", "\1\uffff", "\1\uffff",
			"\1\uffff", "\1\uffff", "\1\uffff", "\1\uffff", "", "", "" };
	static final short[] DFA5_eot = DFA.unpackEncodedString(DFA5_eotS);
	static final short[] DFA5_eof = DFA.unpackEncodedString(DFA5_eofS);
	static final char[] DFA5_min = DFA
			.unpackEncodedStringToUnsignedChars(DFA5_minS);
	static final char[] DFA5_max = DFA
			.unpackEncodedStringToUnsignedChars(DFA5_maxS);
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
			return "89:1: assertion options {backtrack=true; } : (left= assertionExpression EQUAL right= assertionExpression -> ^( ASSERT_EQUAL $left $right) | left= assertionExpression NOT_EQUAL right= assertionExpression -> ^( ASSERT_NOT_EQUAL $left $right) | VARIABLE_NAME CONTAINS assertionExpression ( COMMA assertionExpression )? -> ^( CONTAINS VARIABLE_NAME ( assertionExpression )+ ) | NOT OPEN_PARENTHESYS assertion CLOSED_PARENTHESYS -> ^( NOT assertion ) );";
		}

		@Override
		public int specialStateTransition(int s, IntStream _input)
				throws NoViableAltException {
			TokenStream input = (TokenStream) _input;
			int _s = s;
			switch (s) {
			case 0:
				int LA5_1 = input.LA(1);
				int index5_1 = input.index();
				input.rewind();
				s = -1;
				if (OPPLTestCaseCombinedParser.this
						.synpred1_OPPLTestCaseCombined()) {
					s = 3;
				} else if (OPPLTestCaseCombinedParser.this
						.synpred2_OPPLTestCaseCombined()) {
					s = 13;
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
				if (OPPLTestCaseCombinedParser.this
						.synpred1_OPPLTestCaseCombined()) {
					s = 3;
				} else if (OPPLTestCaseCombinedParser.this
						.synpred2_OPPLTestCaseCombined()) {
					s = 13;
				}
				input.seek(index5_2);
				if (s >= 0) {
					return s;
				}
				break;
			case 2:
				int LA5_4 = input.LA(1);
				int index5_4 = input.index();
				input.rewind();
				s = -1;
				if (OPPLTestCaseCombinedParser.this
						.synpred1_OPPLTestCaseCombined()) {
					s = 3;
				} else if (OPPLTestCaseCombinedParser.this
						.synpred2_OPPLTestCaseCombined()) {
					s = 13;
				}
				input.seek(index5_4);
				if (s >= 0) {
					return s;
				}
				break;
			case 3:
				int LA5_5 = input.LA(1);
				int index5_5 = input.index();
				input.rewind();
				s = -1;
				if (OPPLTestCaseCombinedParser.this
						.synpred1_OPPLTestCaseCombined()) {
					s = 3;
				} else if (OPPLTestCaseCombinedParser.this
						.synpred2_OPPLTestCaseCombined()) {
					s = 13;
				}
				input.seek(index5_5);
				if (s >= 0) {
					return s;
				}
				break;
			case 4:
				int LA5_6 = input.LA(1);
				int index5_6 = input.index();
				input.rewind();
				s = -1;
				if (OPPLTestCaseCombinedParser.this
						.synpred1_OPPLTestCaseCombined()) {
					s = 3;
				} else if (OPPLTestCaseCombinedParser.this
						.synpred2_OPPLTestCaseCombined()) {
					s = 13;
				} else if (OPPLTestCaseCombinedParser.this
						.synpred3_OPPLTestCaseCombined()) {
					s = 14;
				}
				input.seek(index5_6);
				if (s >= 0) {
					return s;
				}
				break;
			case 5:
				int LA5_7 = input.LA(1);
				int index5_7 = input.index();
				input.rewind();
				s = -1;
				if (OPPLTestCaseCombinedParser.this
						.synpred1_OPPLTestCaseCombined()) {
					s = 3;
				} else if (OPPLTestCaseCombinedParser.this
						.synpred2_OPPLTestCaseCombined()) {
					s = 13;
				}
				input.seek(index5_7);
				if (s >= 0) {
					return s;
				}
				break;
			case 6:
				int LA5_8 = input.LA(1);
				int index5_8 = input.index();
				input.rewind();
				s = -1;
				if (OPPLTestCaseCombinedParser.this
						.synpred1_OPPLTestCaseCombined()) {
					s = 3;
				} else if (OPPLTestCaseCombinedParser.this
						.synpred2_OPPLTestCaseCombined()) {
					s = 13;
				}
				input.seek(index5_8);
				if (s >= 0) {
					return s;
				}
				break;
			case 7:
				int LA5_9 = input.LA(1);
				int index5_9 = input.index();
				input.rewind();
				s = -1;
				if (OPPLTestCaseCombinedParser.this
						.synpred1_OPPLTestCaseCombined()) {
					s = 3;
				} else if (OPPLTestCaseCombinedParser.this
						.synpred2_OPPLTestCaseCombined()) {
					s = 13;
				} else if (true) {
					s = 15;
				}
				input.seek(index5_9);
				if (s >= 0) {
					return s;
				}
				break;
			case 8:
				int LA5_10 = input.LA(1);
				int index5_10 = input.index();
				input.rewind();
				s = -1;
				if (OPPLTestCaseCombinedParser.this
						.synpred1_OPPLTestCaseCombined()) {
					s = 3;
				} else if (OPPLTestCaseCombinedParser.this
						.synpred2_OPPLTestCaseCombined()) {
					s = 13;
				}
				input.seek(index5_10);
				if (s >= 0) {
					return s;
				}
				break;
			case 9:
				int LA5_11 = input.LA(1);
				int index5_11 = input.index();
				input.rewind();
				s = -1;
				if (OPPLTestCaseCombinedParser.this
						.synpred1_OPPLTestCaseCombined()) {
					s = 3;
				} else if (OPPLTestCaseCombinedParser.this
						.synpred2_OPPLTestCaseCombined()) {
					s = 13;
				}
				input.seek(index5_11);
				if (s >= 0) {
					return s;
				}
				break;
			case 10:
				int LA5_12 = input.LA(1);
				int index5_12 = input.index();
				input.rewind();
				s = -1;
				if (OPPLTestCaseCombinedParser.this
						.synpred1_OPPLTestCaseCombined()) {
					s = 3;
				} else if (OPPLTestCaseCombinedParser.this
						.synpred2_OPPLTestCaseCombined()) {
					s = 13;
				}
				input.seek(index5_12);
				if (s >= 0) {
					return s;
				}
				break;
			}
			if (OPPLTestCaseCombinedParser.this.state.backtracking > 0) {
				OPPLTestCaseCombinedParser.this.state.failed = true;
				return -1;
			}
			NoViableAltException nvae = new NoViableAltException(this
					.getDescription(), 5, _s, input);
			this.error(nvae);
			throw nvae;
		}
	}

	public static final BitSet FOLLOW_text_in_testCase144 = new BitSet(
			new long[] { 0x0000000000000000L, 0x0000000000000000L,
					0x0000000000000000L, 0x0000000000000000L,
					0x0000000000000000L, 0x0000000000000000L,
					0x0000000000000000L, 0x0000000000200000L });
	public static final BitSet FOLLOW_SEMICOLON_in_testCase146 = new BitSet(
			new long[] { 0x0000000000000000L, 0x0000000000000800L,
					0x0000000000000000L, 0x0000000000000000L,
					0x0000000000000000L, 0x0000000000000000L,
					0x0000000000000000L, 0x0000000000410000L });
	public static final BitSet FOLLOW_INFERENCE_in_testCase148 = new BitSet(
			new long[] { 0x0000000000000000L, 0x0000000000000800L,
					0x0000000000000000L, 0x0000000000000000L,
					0x0000000000000000L, 0x0000000000000000L,
					0x0000000000000000L, 0x0000000000410000L });
	public static final BitSet FOLLOW_statement_in_testCase152 = new BitSet(
			new long[] { 0x0000000000000000L, 0x0000000000000000L,
					0x0000000000000000L, 0x0000000000000000L,
					0x0000000000000000L, 0x0000000000000000L,
					0x0000000000000000L, 0x0000000200000000L });
	public static final BitSet FOLLOW_test_in_testCase155 = new BitSet(
			new long[] { 0x0000000000000002L, 0x0000000000000000L,
					0x0000000000000000L, 0x0000000000000000L,
					0x0000000000000000L, 0x0000000000000000L,
					0x0000000000000000L, 0x0000000200000000L });
	public static final BitSet FOLLOW_ASSERT_in_test187 = new BitSet(
			new long[] { 0x0000350000081060L, 0x0000000000000000L,
					0x0000000000200000L, 0x0000000000000000L,
					0x0000000000000000L, 0x0000000000000000L,
					0x0000000000000000L, 0x0000000000110000L });
	public static final BitSet FOLLOW_assertion_in_test189 = new BitSet(
			new long[] { 0x0000000000000002L, 0x0000000000000000L,
					0x0000000000000000L, 0x0000000000000000L,
					0x0000000000000000L, 0x0000000000000000L,
					0x0000000000000000L, 0x0000000000200000L });
	public static final BitSet FOLLOW_SEMICOLON_in_test192 = new BitSet(
			new long[] { 0x0000148FF80FFC00L, 0x0000000000000000L,
					0x0000000000000000L, 0x0000000000000000L,
					0x0000000000000000L, 0x0000000000000000L,
					0x0000000000000000L, 0x0000000000110000L });
	public static final BitSet FOLLOW_text_in_test197 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_assertionExpression_in_assertion244 = new BitSet(
			new long[] { 0x0000000000000000L, 0x0000000000000200L });
	public static final BitSet FOLLOW_EQUAL_in_assertion246 = new BitSet(
			new long[] { 0x0000350000081060L, 0x0000000000000000L,
					0x0000000000200000L, 0x0000000000000000L,
					0x0000000000000000L, 0x0000000000000000L,
					0x0000000000000000L, 0x0000000000110000L });
	public static final BitSet FOLLOW_assertionExpression_in_assertion251 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_assertionExpression_in_assertion272 = new BitSet(
			new long[] { 0x0000000000000000L, 0x0000000000000100L });
	public static final BitSet FOLLOW_NOT_EQUAL_in_assertion274 = new BitSet(
			new long[] { 0x0000350000081060L, 0x0000000000000000L,
					0x0000000000200000L, 0x0000000000000000L,
					0x0000000000000000L, 0x0000000000000000L,
					0x0000000000000000L, 0x0000000000110000L });
	public static final BitSet FOLLOW_assertionExpression_in_assertion279 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_VARIABLE_NAME_in_assertion297 = new BitSet(
			new long[] { 0x0000000000000000L, 0x0000000000000000L,
					0x0000000000000000L, 0x0000000000000000L,
					0x0000000000000000L, 0x0000000000000000L,
					0x0000000000000000L, 0x0000000000800000L });
	public static final BitSet FOLLOW_CONTAINS_in_assertion300 = new BitSet(
			new long[] { 0x0000350000081060L, 0x0000000000000000L,
					0x0000000000200000L, 0x0000000000000000L,
					0x0000000000000000L, 0x0000000000000000L,
					0x0000000000000000L, 0x0000000000110000L });
	public static final BitSet FOLLOW_assertionExpression_in_assertion302 = new BitSet(
			new long[] { 0x0000002000000002L });
	public static final BitSet FOLLOW_COMMA_in_assertion305 = new BitSet(
			new long[] { 0x0000350000081060L, 0x0000000000000000L,
					0x0000000000200000L, 0x0000000000000000L,
					0x0000000000000000L, 0x0000000000000000L,
					0x0000000000000000L, 0x0000000000110000L });
	public static final BitSet FOLLOW_assertionExpression_in_assertion307 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_NOT_in_assertion326 = new BitSet(
			new long[] { 0x0000000000000020L });
	public static final BitSet FOLLOW_OPEN_PARENTHESYS_in_assertion328 = new BitSet(
			new long[] { 0x0000350000081060L, 0x0000000000000000L,
					0x0000000000200000L, 0x0000000000000000L,
					0x0000000000000000L, 0x0000000000000000L,
					0x0000000000000000L, 0x0000000000110000L });
	public static final BitSet FOLLOW_assertion_in_assertion330 = new BitSet(
			new long[] { 0x0000000000000100L });
	public static final BitSet FOLLOW_CLOSED_PARENTHESYS_in_assertion332 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_COUNT_in_assertionExpression353 = new BitSet(
			new long[] { 0x0000000000000020L });
	public static final BitSet FOLLOW_OPEN_PARENTHESYS_in_assertionExpression355 = new BitSet(
			new long[] { 0x0000000000000000L, 0x0000000000000000L,
					0x0000000000000000L, 0x0000000000000000L,
					0x0000000000000000L, 0x0000000000000000L,
					0x0000000000000000L, 0x0000000000010000L });
	public static final BitSet FOLLOW_VARIABLE_NAME_in_assertionExpression357 = new BitSet(
			new long[] { 0x0000000000000100L });
	public static final BitSet FOLLOW_CLOSED_PARENTHESYS_in_assertionExpression359 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_INTEGER_in_assertionExpression372 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_expression_in_assertionExpression379 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_textBit_in_text413 = new BitSet(
			new long[] { 0x0000148FF80FFC02L, 0x0000000000000000L,
					0x0000000000000000L, 0x0000000000000000L,
					0x0000000000000000L, 0x0000000000000000L,
					0x0000000000000000L, 0x0000000000110000L });
	public static final BitSet FOLLOW_IDENTIFIER_in_textBit445 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_VARIABLE_NAME_in_textBit460 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_FUNCTIONAL_in_textBit476 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_INVERSE_FUNCTIONAL_in_textBit491 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_SYMMETRIC_in_textBit506 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_ANTI_SYMMETRIC_in_textBit521 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_REFLEXIVE_in_textBit536 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_IRREFLEXIVE_in_textBit551 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_TRANSITIVE_in_textBit567 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_NOT_in_textBit582 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_AND_in_textBit597 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_OR_in_textBit612 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_SOME_in_textBit627 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_ONLY_in_textBit642 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_MIN_in_textBit657 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_MAX_in_textBit672 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_EXACTLY_in_textBit690 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_VALUE_in_textBit708 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_INVERSE_in_textBit726 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_DOMAIN_in_textBit744 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_RANGE_in_textBit762 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_TYPES_in_textBit777 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_INTEGER_in_textBit798 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_COUNT_in_textBit819 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_variableDefinitions_in_statement848 = new BitSet(
			new long[] { 0x0000000000000000L, 0x0000000000000800L,
					0x0000000000000000L, 0x0000000000000000L,
					0x0000000000000000L, 0x0000000000000000L,
					0x0000000000000000L, 0x0000000000410000L });
	public static final BitSet FOLLOW_query_in_statement851 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_assertionExpression_in_synpred1_OPPLTestCaseCombined244 = new BitSet(
			new long[] { 0x0000000000000000L, 0x0000000000000200L });
	public static final BitSet FOLLOW_EQUAL_in_synpred1_OPPLTestCaseCombined246 = new BitSet(
			new long[] { 0x0000350000081060L, 0x0000000000000000L,
					0x0000000000200000L, 0x0000000000000000L,
					0x0000000000000000L, 0x0000000000000000L,
					0x0000000000000000L, 0x0000000000110000L });
	public static final BitSet FOLLOW_assertionExpression_in_synpred1_OPPLTestCaseCombined251 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_assertionExpression_in_synpred2_OPPLTestCaseCombined272 = new BitSet(
			new long[] { 0x0000000000000000L, 0x0000000000000100L });
	public static final BitSet FOLLOW_NOT_EQUAL_in_synpred2_OPPLTestCaseCombined274 = new BitSet(
			new long[] { 0x0000350000081060L, 0x0000000000000000L,
					0x0000000000200000L, 0x0000000000000000L,
					0x0000000000000000L, 0x0000000000000000L,
					0x0000000000000000L, 0x0000000000110000L });
	public static final BitSet FOLLOW_assertionExpression_in_synpred2_OPPLTestCaseCombined279 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_VARIABLE_NAME_in_synpred3_OPPLTestCaseCombined297 = new BitSet(
			new long[] { 0x0000000000000000L, 0x0000000000000000L,
					0x0000000000000000L, 0x0000000000000000L,
					0x0000000000000000L, 0x0000000000000000L,
					0x0000000000000000L, 0x0000000000800000L });
	public static final BitSet FOLLOW_CONTAINS_in_synpred3_OPPLTestCaseCombined300 = new BitSet(
			new long[] { 0x0000350000081060L, 0x0000000000000000L,
					0x0000000000200000L, 0x0000000000000000L,
					0x0000000000000000L, 0x0000000000000000L,
					0x0000000000000000L, 0x0000000000110000L });
	public static final BitSet FOLLOW_assertionExpression_in_synpred3_OPPLTestCaseCombined302 = new BitSet(
			new long[] { 0x0000002000000002L });
	public static final BitSet FOLLOW_COMMA_in_synpred3_OPPLTestCaseCombined305 = new BitSet(
			new long[] { 0x0000350000081060L, 0x0000000000000000L,
					0x0000000000200000L, 0x0000000000000000L,
					0x0000000000000000L, 0x0000000000000000L,
					0x0000000000000000L, 0x0000000000110000L });
	public static final BitSet FOLLOW_assertionExpression_in_synpred3_OPPLTestCaseCombined307 = new BitSet(
			new long[] { 0x0000000000000002L });
}