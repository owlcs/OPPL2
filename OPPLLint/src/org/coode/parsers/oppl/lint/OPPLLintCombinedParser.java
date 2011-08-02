// $ANTLR 3.2 Sep 23, 2009 12:02:23 /Users/luigi/Documents/workspace/Parsers/src/OPPLLintCombined.g 2011-08-02 17:13:32
package org.coode.parsers.oppl.lint;

import org.antlr.runtime.BitSet;
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

public class OPPLLintCombinedParser extends Parser {
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
			"VARIABLE_SCOPE", "VARIABLE_IDENTIFIER", "OPPL_STATEMENT", "HAS_KEY", "IRI",
			"ANNOTATION_ASSERTION", "AT", "SET", "DISJOINT_CLASSES", "DISJOINT_PROPERTIES",
			"SAME_INDIVIDUAL", "DIFFERENT_INDIVIDUALS", "TO_LOWER_CASE", "TO_UPPER_CASE",
			"ESCLAMATION_MARK", "MATCH", "VALUES", "RENDERING", "GROUPS", "DOLLAR", "RETURN",
			"SEMICOLON", "VARIABLE_NAME", "FAIL", "NAF_CONSTRAINT", "DESCRIPTION", "EXPLANATION",
			"TEXT", "INFERENCE", "LESS_THAN", "LESS_THAN_EQUAL", "GREATER_THAN",
			"GREATER_THAN_EQUAL", "IRI_ATTRIBUTE_NAME", "WS", "DATA_RANGE", "REGEXP_CONSTRAINT",
			"ATTRIBUTE_SELECTOR", "STRING_OPERATION", "SUBPROPERTY_OF" };
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
	public static final int DESCRIPTION = 468;
	public static final int POW = 36;
	public static final int INPUT_VARIABLE_DEFINITION = 96;
	public static final int NOT_EQUAL = 72;
	public static final int INVERSE_OBJECT_PROPERTY_EXPRESSION = 68;
	public static final int INSTANCE_OF = 38;
	public static final int BEGIN = 83;
	public static final int RETURN = 415;
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
	public static final int INFERENCE = 471;
	public static final int ALL_RESTRICTION = 62;
	public static final int CONJUNCTION = 56;
	public static final int OPPL_STATEMENT = 107;
	public static final int NEGATED_ASSERTION = 59;
	public static final int WHITESPACE = 9;
	public static final int MATCH = 176;
	public static final int IN_SET_CONSTRAINT = 95;
	public static final int SEMICOLON = 422;
	public static final int VALUE = 18;
	public static final int FAIL = 466;
	public static final int GROUPS = 356;
	public static final int OPEN_CURLY_BRACES = 6;
	public static final int DISJUNCTION = 55;
	public static final int INVERSE = 19;
	public static final int WS = 577;
	public static final int NAF_CONSTRAINT = 467;
	public static final int OPPL_LINT = 119;
	public static final int DBLQUOTE = 40;
	public static final int STRING_OPERATION = 620;
	public static final int OR = 11;
	public static final int LESS_THAN = 483;
	public static final int CONSTANT = 70;
	public static final int QUERY = 103;
	public static final int ENTITY_REFERENCE = 45;
	public static final int END = 84;
	public static final int COMPOSITION = 4;
	public static final int ANNOTATION_ASSERTION = 111;
	public static final int CLOSED_SQUARE_BRACKET = 86;
	public static final int DOLLAR = 400;
	public static final int SAME_AS = 23;
	public static final int WHERE = 71;
	public static final int DIFFERENT_INDIVIDUALS = 119;
	public static final int DISJOINT_WITH = 26;
	public static final int SUPER_PROPERTY_OF = 88;
	public static final int VARIABLE_TYPE = 89;
	public static final int ATTRIBUTE_SELECTOR = 619;
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
	public static final int EXPLANATION = 469;
	public static final int GENERATED_VARIABLE_DEFINITION = 97;
	public static final int EXACTLY = 17;
	public static final int SUB_PROPERTY_AXIOM = 51;
	public static final int OPEN_SQUARE_BRACKET = 85;
	public static final int VALUES = 354;
	public static final int REGEXP_CONSTRAINT = 609;
	public static final int RANGE = 28;
	public static final int DATA_RANGE = 595;
	public static final int SET = 115;
	public static final int ONE_OF = 65;
	public static final int VARIABLE_DEFINITIONS = 102;
	public static final int MIN = 15;
	public static final int SUB_CLASS_AXIOM = 48;
	public static final int TEXT = 470;
	public static final int PLAIN_CLAUSE = 93;
	public static final int Tokens = 47;
	public static final int DOMAIN = 27;
	public static final int SUBPROPERTY_OF = 621;
	public static final int OPPL_FUNCTION = 100;
	public static final int COLON = 77;
	public static final int DISJOINT_WITH_AXIOM = 50;
	public static final int CREATE_INTERSECTION = 81;
	public static final int INVERSE_FUNCTIONAL = 35;
	public static final int RENDERING = 355;
	public static final int VARIABLE_IDENTIFIER = 106;
	public static final int IRI_ATTRIBUTE_NAME = 567;
	public static final int IRREFLEXIVE = 33;
	public static final int LESS_THAN_EQUAL = 484;
	public static final int VARIABLE_ATTRIBUTE = 99;
	public static final int ASSERTED = 76;
	public static final int FUNCTIONAL = 29;
	public static final int PROPERTY_CHAIN = 57;
	public static final int TYPE_ASSERTION = 66;
	public static final int DISJOINT_CLASSES = 116;
	// delegates
	public OPPLLintCombined_OPPLParser_MOWLParser gMOWLParser;
	public OPPLLintCombined_OPPLParser gOPPLParser;

	// delegators
	public OPPLLintCombinedParser(TokenStream input) {
		this(input, new RecognizerSharedState());
	}

	public OPPLLintCombinedParser(TokenStream input, RecognizerSharedState state) {
		super(input, state);
		this.gOPPLParser = new OPPLLintCombined_OPPLParser(input, state, this);
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
		return OPPLLintCombinedParser.tokenNames;
	}

	@Override
	public String getGrammarFileName() {
		return "/Users/luigi/Documents/workspace/Parsers/src/OPPLLintCombined.g";
	}

	private ErrorListener errorListener;

	public OPPLLintCombinedParser(TokenStream input, ErrorListener errorListener) {
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

	public static class lint_return extends ParserRuleReturnScope {
		OPPLSyntaxTree tree;

		@Override
		public Object getTree() {
			return this.tree;
		}
	};

	// $ANTLR start "lint"
	// /Users/luigi/Documents/workspace/Parsers/src/OPPLLintCombined.g:73:1:
	// lint : name= text SEMICOLON ( INFERENCE )? statement returnClause
	// SEMICOLON exp= text SEMICOLON description -> ^( OPPL_LINT
	// IDENTIFIER[$name.text] ( INFERENCE )? statement returnClause ^(
	// EXPLANATION[$exp.text] $exp) description ) ;
	public final OPPLLintCombinedParser.lint_return lint() throws RecognitionException {
		OPPLLintCombinedParser.lint_return retval = new OPPLLintCombinedParser.lint_return();
		retval.start = this.input.LT(1);
		OPPLSyntaxTree root_0 = null;
		Token SEMICOLON1 = null;
		Token INFERENCE2 = null;
		Token SEMICOLON5 = null;
		Token SEMICOLON6 = null;
		OPPLLintCombinedParser.text_return name = null;
		OPPLLintCombinedParser.text_return exp = null;
		OPPLLintCombinedParser.statement_return statement3 = null;
		OPPLLintCombinedParser.returnClause_return returnClause4 = null;
		OPPLLintCombinedParser.description_return description7 = null;
		OPPLSyntaxTree SEMICOLON1_tree = null;
		OPPLSyntaxTree INFERENCE2_tree = null;
		OPPLSyntaxTree SEMICOLON5_tree = null;
		OPPLSyntaxTree SEMICOLON6_tree = null;
		RewriteRuleTokenStream stream_SEMICOLON = new RewriteRuleTokenStream(this.adaptor,
				"token SEMICOLON");
		RewriteRuleTokenStream stream_INFERENCE = new RewriteRuleTokenStream(this.adaptor,
				"token INFERENCE");
		RewriteRuleSubtreeStream stream_statement = new RewriteRuleSubtreeStream(this.adaptor,
				"rule statement");
		RewriteRuleSubtreeStream stream_text = new RewriteRuleSubtreeStream(this.adaptor,
				"rule text");
		RewriteRuleSubtreeStream stream_returnClause = new RewriteRuleSubtreeStream(this.adaptor,
				"rule returnClause");
		RewriteRuleSubtreeStream stream_description = new RewriteRuleSubtreeStream(this.adaptor,
				"rule description");
		try {
			// /Users/luigi/Documents/workspace/Parsers/src/OPPLLintCombined.g:74:3:
			// (name= text SEMICOLON ( INFERENCE )? statement returnClause
			// SEMICOLON exp= text SEMICOLON description -> ^( OPPL_LINT
			// IDENTIFIER[$name.text] ( INFERENCE )? statement returnClause ^(
			// EXPLANATION[$exp.text] $exp) description ) )
			// /Users/luigi/Documents/workspace/Parsers/src/OPPLLintCombined.g:75:5:
			// name= text SEMICOLON ( INFERENCE )? statement returnClause
			// SEMICOLON exp= text SEMICOLON description
			{
				this.pushFollow(FOLLOW_text_in_lint128);
				name = this.text();
				this.state._fsp--;
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_text.add(name.getTree());
				}
				SEMICOLON1 = (Token) this.match(this.input, SEMICOLON, FOLLOW_SEMICOLON_in_lint130);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_SEMICOLON.add(SEMICOLON1);
				}
				// /Users/luigi/Documents/workspace/Parsers/src/OPPLLintCombined.g:75:27:
				// ( INFERENCE )?
				int alt1 = 2;
				int LA1_0 = this.input.LA(1);
				if (LA1_0 == INFERENCE) {
					alt1 = 1;
				}
				switch (alt1) {
				case 1:
					// /Users/luigi/Documents/workspace/Parsers/src/OPPLLintCombined.g:0:0:
					// INFERENCE
				{
					INFERENCE2 = (Token) this.match(
							this.input,
							INFERENCE,
							FOLLOW_INFERENCE_in_lint132);
					if (this.state.failed) {
						return retval;
					}
					if (this.state.backtracking == 0) {
						stream_INFERENCE.add(INFERENCE2);
					}
				}
					break;
				}
				this.pushFollow(FOLLOW_statement_in_lint135);
				statement3 = this.statement();
				this.state._fsp--;
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_statement.add(statement3.getTree());
				}
				this.pushFollow(FOLLOW_returnClause_in_lint137);
				returnClause4 = this.returnClause();
				this.state._fsp--;
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_returnClause.add(returnClause4.getTree());
				}
				SEMICOLON5 = (Token) this.match(this.input, SEMICOLON, FOLLOW_SEMICOLON_in_lint140);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_SEMICOLON.add(SEMICOLON5);
				}
				this.pushFollow(FOLLOW_text_in_lint146);
				exp = this.text();
				this.state._fsp--;
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_text.add(exp.getTree());
				}
				SEMICOLON6 = (Token) this.match(this.input, SEMICOLON, FOLLOW_SEMICOLON_in_lint148);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_SEMICOLON.add(SEMICOLON6);
				}
				this.pushFollow(FOLLOW_description_in_lint150);
				description7 = this.description();
				this.state._fsp--;
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_description.add(description7.getTree());
				}
				// AST REWRITE
				// elements: exp, INFERENCE, description, returnClause,
				// statement
				// token labels:
				// rule labels: exp, retval
				// token list labels:
				// rule list labels:
				// wildcard labels:
				if (this.state.backtracking == 0) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_exp = new RewriteRuleSubtreeStream(
							this.adaptor, "rule exp", exp != null ? exp.tree : null);
					RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(
							this.adaptor, "rule retval", retval != null ? retval.tree : null);
					root_0 = (OPPLSyntaxTree) this.adaptor.nil();
					// 75:105: -> ^( OPPL_LINT IDENTIFIER[$name.text] (
					// INFERENCE )? statement returnClause ^(
					// EXPLANATION[$exp.text] $exp) description )
					{
						// /Users/luigi/Documents/workspace/Parsers/src/OPPLLintCombined.g:75:107:
						// ^( OPPL_LINT IDENTIFIER[$name.text] ( INFERENCE )?
						// statement returnClause ^( EXPLANATION[$exp.text]
						// $exp) description )
						{
							OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor.nil();
							root_1 = (OPPLSyntaxTree) this.adaptor.becomeRoot(this.adaptor.create(
									DIFFERENT_INDIVIDUALS,
									"DIFFERENT_INDIVIDUALS"), root_1);
							this.adaptor.addChild(root_1, this.adaptor.create(
									IDENTIFIER,
									(name != null ? this.input.toString(name.start, name.stop)
											: null)));
							// /Users/luigi/Documents/workspace/Parsers/src/OPPLLintCombined.g:75:142:
							// ( INFERENCE )?
							if (stream_INFERENCE.hasNext()) {
								this.adaptor.addChild(root_1, stream_INFERENCE.nextNode());
							}
							stream_INFERENCE.reset();
							this.adaptor.addChild(root_1, stream_statement.nextTree());
							this.adaptor.addChild(root_1, stream_returnClause.nextTree());
							// /Users/luigi/Documents/workspace/Parsers/src/OPPLLintCombined.g:75:176:
							// ^( EXPLANATION[$exp.text] $exp)
							{
								OPPLSyntaxTree root_2 = (OPPLSyntaxTree) this.adaptor.nil();
								root_2 = (OPPLSyntaxTree) this.adaptor.becomeRoot(
										this.adaptor.create(
												EXPLANATION,
												(exp != null ? this.input.toString(
														exp.start,
														exp.stop) : null)),
										root_2);
								this.adaptor.addChild(root_2, stream_exp.nextTree());
								this.adaptor.addChild(root_1, root_2);
							}
							this.adaptor.addChild(root_1, stream_description.nextTree());
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

	// $ANTLR end "lint"
	public static class text_return extends ParserRuleReturnScope {
		OPPLSyntaxTree tree;

		@Override
		public Object getTree() {
			return this.tree;
		}
	};

	// $ANTLR start "text"
	// /Users/luigi/Documents/workspace/Parsers/src/OPPLLintCombined.g:78:1:
	// text : (t= textBit )+ -> ^( TEXT[builder.toString()] ( textBit )+ ) ;
	public final OPPLLintCombinedParser.text_return text() throws RecognitionException {
		OPPLLintCombinedParser.text_return retval = new OPPLLintCombinedParser.text_return();
		retval.start = this.input.LT(1);
		OPPLSyntaxTree root_0 = null;
		OPPLLintCombinedParser.textBit_return t = null;
		RewriteRuleSubtreeStream stream_textBit = new RewriteRuleSubtreeStream(this.adaptor,
				"rule textBit");
		StringBuilder builder = new StringBuilder();
		try {
			// /Users/luigi/Documents/workspace/Parsers/src/OPPLLintCombined.g:84:1:
			// ( (t= textBit )+ -> ^( TEXT[builder.toString()] ( textBit )+ ) )
			// /Users/luigi/Documents/workspace/Parsers/src/OPPLLintCombined.g:85:1:
			// (t= textBit )+
			{
				// /Users/luigi/Documents/workspace/Parsers/src/OPPLLintCombined.g:85:1:
				// (t= textBit )+
				int cnt2 = 0;
				loop2: do {
					int alt2 = 2;
					int LA2_0 = this.input.LA(1);
					if (LA2_0 >= AND && LA2_0 <= INVERSE || LA2_0 >= DOMAIN
							&& LA2_0 <= INVERSE_FUNCTIONAL || LA2_0 == TYPES || LA2_0 == IDENTIFIER
							|| LA2_0 == VARIABLE_NAME) {
						alt2 = 1;
					}
					switch (alt2) {
					case 1:
						// /Users/luigi/Documents/workspace/Parsers/src/OPPLLintCombined.g:85:3:
						// t= textBit
					{
						this.pushFollow(FOLLOW_textBit_in_text200);
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
					// 89:8: -> ^( TEXT[builder.toString()] ( textBit )+ )
					{
						// /Users/luigi/Documents/workspace/Parsers/src/OPPLLintCombined.g:89:11:
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
	// /Users/luigi/Documents/workspace/Parsers/src/OPPLLintCombined.g:92:1:
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
	// TEXT[$RANGE.text] ) | TYPES -> ^( TEXT[$TYPES.text] ) );
	public final OPPLLintCombinedParser.textBit_return textBit() throws RecognitionException {
		OPPLLintCombinedParser.textBit_return retval = new OPPLLintCombinedParser.textBit_return();
		retval.start = this.input.LT(1);
		OPPLSyntaxTree root_0 = null;
		Token IDENTIFIER8 = null;
		Token VARIABLE_NAME9 = null;
		Token FUNCTIONAL10 = null;
		Token INVERSE_FUNCTIONAL11 = null;
		Token SYMMETRIC12 = null;
		Token ANTI_SYMMETRIC13 = null;
		Token REFLEXIVE14 = null;
		Token IRREFLEXIVE15 = null;
		Token TRANSITIVE16 = null;
		Token NOT17 = null;
		Token AND18 = null;
		Token OR19 = null;
		Token SOME20 = null;
		Token ONLY21 = null;
		Token MIN22 = null;
		Token MAX23 = null;
		Token EXACTLY24 = null;
		Token VALUE25 = null;
		Token INVERSE26 = null;
		Token DOMAIN27 = null;
		Token RANGE28 = null;
		Token TYPES29 = null;
		OPPLSyntaxTree IDENTIFIER8_tree = null;
		OPPLSyntaxTree VARIABLE_NAME9_tree = null;
		OPPLSyntaxTree FUNCTIONAL10_tree = null;
		OPPLSyntaxTree INVERSE_FUNCTIONAL11_tree = null;
		OPPLSyntaxTree SYMMETRIC12_tree = null;
		OPPLSyntaxTree ANTI_SYMMETRIC13_tree = null;
		OPPLSyntaxTree REFLEXIVE14_tree = null;
		OPPLSyntaxTree IRREFLEXIVE15_tree = null;
		OPPLSyntaxTree TRANSITIVE16_tree = null;
		OPPLSyntaxTree NOT17_tree = null;
		OPPLSyntaxTree AND18_tree = null;
		OPPLSyntaxTree OR19_tree = null;
		OPPLSyntaxTree SOME20_tree = null;
		OPPLSyntaxTree ONLY21_tree = null;
		OPPLSyntaxTree MIN22_tree = null;
		OPPLSyntaxTree MAX23_tree = null;
		OPPLSyntaxTree EXACTLY24_tree = null;
		OPPLSyntaxTree VALUE25_tree = null;
		OPPLSyntaxTree INVERSE26_tree = null;
		OPPLSyntaxTree DOMAIN27_tree = null;
		OPPLSyntaxTree RANGE28_tree = null;
		OPPLSyntaxTree TYPES29_tree = null;
		RewriteRuleTokenStream stream_INVERSE = new RewriteRuleTokenStream(this.adaptor,
				"token INVERSE");
		RewriteRuleTokenStream stream_VARIABLE_NAME = new RewriteRuleTokenStream(this.adaptor,
				"token VARIABLE_NAME");
		RewriteRuleTokenStream stream_ANTI_SYMMETRIC = new RewriteRuleTokenStream(this.adaptor,
				"token ANTI_SYMMETRIC");
		RewriteRuleTokenStream stream_TRANSITIVE = new RewriteRuleTokenStream(this.adaptor,
				"token TRANSITIVE");
		RewriteRuleTokenStream stream_INVERSE_FUNCTIONAL = new RewriteRuleTokenStream(this.adaptor,
				"token INVERSE_FUNCTIONAL");
		RewriteRuleTokenStream stream_EXACTLY = new RewriteRuleTokenStream(this.adaptor,
				"token EXACTLY");
		RewriteRuleTokenStream stream_ONLY = new RewriteRuleTokenStream(this.adaptor, "token ONLY");
		RewriteRuleTokenStream stream_IDENTIFIER = new RewriteRuleTokenStream(this.adaptor,
				"token IDENTIFIER");
		RewriteRuleTokenStream stream_IRREFLEXIVE = new RewriteRuleTokenStream(this.adaptor,
				"token IRREFLEXIVE");
		RewriteRuleTokenStream stream_SOME = new RewriteRuleTokenStream(this.adaptor, "token SOME");
		RewriteRuleTokenStream stream_OR = new RewriteRuleTokenStream(this.adaptor, "token OR");
		RewriteRuleTokenStream stream_MAX = new RewriteRuleTokenStream(this.adaptor, "token MAX");
		RewriteRuleTokenStream stream_TYPES = new RewriteRuleTokenStream(this.adaptor,
				"token TYPES");
		RewriteRuleTokenStream stream_RANGE = new RewriteRuleTokenStream(this.adaptor,
				"token RANGE");
		RewriteRuleTokenStream stream_REFLEXIVE = new RewriteRuleTokenStream(this.adaptor,
				"token REFLEXIVE");
		RewriteRuleTokenStream stream_SYMMETRIC = new RewriteRuleTokenStream(this.adaptor,
				"token SYMMETRIC");
		RewriteRuleTokenStream stream_FUNCTIONAL = new RewriteRuleTokenStream(this.adaptor,
				"token FUNCTIONAL");
		RewriteRuleTokenStream stream_MIN = new RewriteRuleTokenStream(this.adaptor, "token MIN");
		RewriteRuleTokenStream stream_NOT = new RewriteRuleTokenStream(this.adaptor, "token NOT");
		RewriteRuleTokenStream stream_VALUE = new RewriteRuleTokenStream(this.adaptor,
				"token VALUE");
		RewriteRuleTokenStream stream_AND = new RewriteRuleTokenStream(this.adaptor, "token AND");
		RewriteRuleTokenStream stream_DOMAIN = new RewriteRuleTokenStream(this.adaptor,
				"token DOMAIN");
		try {
			// /Users/luigi/Documents/workspace/Parsers/src/OPPLLintCombined.g:93:2:
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
			// )
			int alt3 = 22;
			switch (this.input.LA(1)) {
			case IDENTIFIER: {
				alt3 = 1;
			}
				break;
			case VARIABLE_NAME: {
				alt3 = 2;
			}
				break;
			case FUNCTIONAL: {
				alt3 = 3;
			}
				break;
			case INVERSE_FUNCTIONAL: {
				alt3 = 4;
			}
				break;
			case SYMMETRIC: {
				alt3 = 5;
			}
				break;
			case ANTI_SYMMETRIC: {
				alt3 = 6;
			}
				break;
			case REFLEXIVE: {
				alt3 = 7;
			}
				break;
			case IRREFLEXIVE: {
				alt3 = 8;
			}
				break;
			case TRANSITIVE: {
				alt3 = 9;
			}
				break;
			case NOT: {
				alt3 = 10;
			}
				break;
			case AND: {
				alt3 = 11;
			}
				break;
			case OR: {
				alt3 = 12;
			}
				break;
			case SOME: {
				alt3 = 13;
			}
				break;
			case ONLY: {
				alt3 = 14;
			}
				break;
			case MIN: {
				alt3 = 15;
			}
				break;
			case MAX: {
				alt3 = 16;
			}
				break;
			case EXACTLY: {
				alt3 = 17;
			}
				break;
			case VALUE: {
				alt3 = 18;
			}
				break;
			case INVERSE: {
				alt3 = 19;
			}
				break;
			case DOMAIN: {
				alt3 = 20;
			}
				break;
			case RANGE: {
				alt3 = 21;
			}
				break;
			case TYPES: {
				alt3 = 22;
			}
				break;
			default:
				if (this.state.backtracking > 0) {
					this.state.failed = true;
					return retval;
				}
				NoViableAltException nvae = new NoViableAltException("", 3, 0, this.input);
				throw nvae;
			}
			switch (alt3) {
			case 1:
				// /Users/luigi/Documents/workspace/Parsers/src/OPPLLintCombined.g:94:4:
				// IDENTIFIER
			{
				IDENTIFIER8 = (Token) this.match(
						this.input,
						IDENTIFIER,
						FOLLOW_IDENTIFIER_in_textBit232);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_IDENTIFIER.add(IDENTIFIER8);
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
					// 94:15: -> ^( TEXT[$IDENTIFIER.text] )
					{
						// /Users/luigi/Documents/workspace/Parsers/src/OPPLLintCombined.g:94:18:
						// ^( TEXT[$IDENTIFIER.text] )
						{
							OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor.nil();
							root_1 = (OPPLSyntaxTree) this.adaptor.becomeRoot(
									this.adaptor.create(
											TEXT,
											(IDENTIFIER8 != null ? IDENTIFIER8.getText() : null)),
									root_1);
							this.adaptor.addChild(root_0, root_1);
						}
					}
					retval.tree = root_0;
				}
			}
				break;
			case 2:
				// /Users/luigi/Documents/workspace/Parsers/src/OPPLLintCombined.g:95:6:
				// VARIABLE_NAME
			{
				VARIABLE_NAME9 = (Token) this.match(
						this.input,
						VARIABLE_NAME,
						FOLLOW_VARIABLE_NAME_in_textBit247);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_VARIABLE_NAME.add(VARIABLE_NAME9);
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
					// 95:21: -> ^( TEXT VARIABLE_NAME )
					{
						// /Users/luigi/Documents/workspace/Parsers/src/OPPLLintCombined.g:95:24:
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
				// /Users/luigi/Documents/workspace/Parsers/src/OPPLLintCombined.g:96:6:
				// FUNCTIONAL
			{
				FUNCTIONAL10 = (Token) this.match(
						this.input,
						FUNCTIONAL,
						FOLLOW_FUNCTIONAL_in_textBit263);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_FUNCTIONAL.add(FUNCTIONAL10);
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
					// 96:17: -> ^( TEXT[$FUNCTIONAL.text] )
					{
						// /Users/luigi/Documents/workspace/Parsers/src/OPPLLintCombined.g:96:20:
						// ^( TEXT[$FUNCTIONAL.text] )
						{
							OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor.nil();
							root_1 = (OPPLSyntaxTree) this.adaptor.becomeRoot(
									this.adaptor.create(
											TEXT,
											(FUNCTIONAL10 != null ? FUNCTIONAL10.getText() : null)),
									root_1);
							this.adaptor.addChild(root_0, root_1);
						}
					}
					retval.tree = root_0;
				}
			}
				break;
			case 4:
				// /Users/luigi/Documents/workspace/Parsers/src/OPPLLintCombined.g:97:6:
				// INVERSE_FUNCTIONAL
			{
				INVERSE_FUNCTIONAL11 = (Token) this.match(
						this.input,
						INVERSE_FUNCTIONAL,
						FOLLOW_INVERSE_FUNCTIONAL_in_textBit278);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_INVERSE_FUNCTIONAL.add(INVERSE_FUNCTIONAL11);
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
					// 97:25: -> ^( TEXT[$INVERSE_FUNCTIONAL.text] )
					{
						// /Users/luigi/Documents/workspace/Parsers/src/OPPLLintCombined.g:97:28:
						// ^( TEXT[$INVERSE_FUNCTIONAL.text] )
						{
							OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor.nil();
							root_1 = (OPPLSyntaxTree) this.adaptor.becomeRoot(this.adaptor.create(
									TEXT,
									(INVERSE_FUNCTIONAL11 != null ? INVERSE_FUNCTIONAL11.getText()
											: null)), root_1);
							this.adaptor.addChild(root_0, root_1);
						}
					}
					retval.tree = root_0;
				}
			}
				break;
			case 5:
				// /Users/luigi/Documents/workspace/Parsers/src/OPPLLintCombined.g:98:6:
				// SYMMETRIC
			{
				SYMMETRIC12 = (Token) this.match(
						this.input,
						SYMMETRIC,
						FOLLOW_SYMMETRIC_in_textBit293);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_SYMMETRIC.add(SYMMETRIC12);
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
					// 98:16: -> ^( TEXT[$SYMMETRIC.text] )
					{
						// /Users/luigi/Documents/workspace/Parsers/src/OPPLLintCombined.g:98:19:
						// ^( TEXT[$SYMMETRIC.text] )
						{
							OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor.nil();
							root_1 = (OPPLSyntaxTree) this.adaptor.becomeRoot(
									this.adaptor.create(
											TEXT,
											(SYMMETRIC12 != null ? SYMMETRIC12.getText() : null)),
									root_1);
							this.adaptor.addChild(root_0, root_1);
						}
					}
					retval.tree = root_0;
				}
			}
				break;
			case 6:
				// /Users/luigi/Documents/workspace/Parsers/src/OPPLLintCombined.g:99:6:
				// ANTI_SYMMETRIC
			{
				ANTI_SYMMETRIC13 = (Token) this.match(
						this.input,
						ANTI_SYMMETRIC,
						FOLLOW_ANTI_SYMMETRIC_in_textBit308);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_ANTI_SYMMETRIC.add(ANTI_SYMMETRIC13);
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
					// 99:21: -> ^( TEXT[$ANTI_SYMMETRIC.text] )
					{
						// /Users/luigi/Documents/workspace/Parsers/src/OPPLLintCombined.g:99:24:
						// ^( TEXT[$ANTI_SYMMETRIC.text] )
						{
							OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor.nil();
							root_1 = (OPPLSyntaxTree) this.adaptor.becomeRoot(
									this.adaptor.create(
											TEXT,
											(ANTI_SYMMETRIC13 != null ? ANTI_SYMMETRIC13.getText()
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
				// /Users/luigi/Documents/workspace/Parsers/src/OPPLLintCombined.g:100:6:
				// REFLEXIVE
			{
				REFLEXIVE14 = (Token) this.match(
						this.input,
						REFLEXIVE,
						FOLLOW_REFLEXIVE_in_textBit323);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_REFLEXIVE.add(REFLEXIVE14);
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
					// 100:16: -> ^( TEXT[$REFLEXIVE.text] )
					{
						// /Users/luigi/Documents/workspace/Parsers/src/OPPLLintCombined.g:100:19:
						// ^( TEXT[$REFLEXIVE.text] )
						{
							OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor.nil();
							root_1 = (OPPLSyntaxTree) this.adaptor.becomeRoot(
									this.adaptor.create(
											TEXT,
											(REFLEXIVE14 != null ? REFLEXIVE14.getText() : null)),
									root_1);
							this.adaptor.addChild(root_0, root_1);
						}
					}
					retval.tree = root_0;
				}
			}
				break;
			case 8:
				// /Users/luigi/Documents/workspace/Parsers/src/OPPLLintCombined.g:101:6:
				// IRREFLEXIVE
			{
				IRREFLEXIVE15 = (Token) this.match(
						this.input,
						IRREFLEXIVE,
						FOLLOW_IRREFLEXIVE_in_textBit338);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_IRREFLEXIVE.add(IRREFLEXIVE15);
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
					// 101:18: -> ^( TEXT[$IRREFLEXIVE.text] )
					{
						// /Users/luigi/Documents/workspace/Parsers/src/OPPLLintCombined.g:101:21:
						// ^( TEXT[$IRREFLEXIVE.text] )
						{
							OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor.nil();
							root_1 = (OPPLSyntaxTree) this.adaptor.becomeRoot(
									this.adaptor.create(
											TEXT,
											(IRREFLEXIVE15 != null ? IRREFLEXIVE15.getText() : null)),
									root_1);
							this.adaptor.addChild(root_0, root_1);
						}
					}
					retval.tree = root_0;
				}
			}
				break;
			case 9:
				// /Users/luigi/Documents/workspace/Parsers/src/OPPLLintCombined.g:102:7:
				// TRANSITIVE
			{
				TRANSITIVE16 = (Token) this.match(
						this.input,
						TRANSITIVE,
						FOLLOW_TRANSITIVE_in_textBit354);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_TRANSITIVE.add(TRANSITIVE16);
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
					// 102:18: -> ^( TEXT[$TRANSITIVE.text] )
					{
						// /Users/luigi/Documents/workspace/Parsers/src/OPPLLintCombined.g:102:21:
						// ^( TEXT[$TRANSITIVE.text] )
						{
							OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor.nil();
							root_1 = (OPPLSyntaxTree) this.adaptor.becomeRoot(
									this.adaptor.create(
											TEXT,
											(TRANSITIVE16 != null ? TRANSITIVE16.getText() : null)),
									root_1);
							this.adaptor.addChild(root_0, root_1);
						}
					}
					retval.tree = root_0;
				}
			}
				break;
			case 10:
				// /Users/luigi/Documents/workspace/Parsers/src/OPPLLintCombined.g:103:6:
				// NOT
			{
				NOT17 = (Token) this.match(this.input, NOT, FOLLOW_NOT_in_textBit369);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_NOT.add(NOT17);
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
					// 103:10: -> ^( TEXT[$NOT.text] )
					{
						// /Users/luigi/Documents/workspace/Parsers/src/OPPLLintCombined.g:103:13:
						// ^( TEXT[$NOT.text] )
						{
							OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor.nil();
							root_1 = (OPPLSyntaxTree) this.adaptor.becomeRoot(this.adaptor.create(
									TEXT,
									(NOT17 != null ? NOT17.getText() : null)), root_1);
							this.adaptor.addChild(root_0, root_1);
						}
					}
					retval.tree = root_0;
				}
			}
				break;
			case 11:
				// /Users/luigi/Documents/workspace/Parsers/src/OPPLLintCombined.g:104:6:
				// AND
			{
				AND18 = (Token) this.match(this.input, AND, FOLLOW_AND_in_textBit384);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_AND.add(AND18);
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
					// 104:10: -> ^( TEXT[$AND.text] )
					{
						// /Users/luigi/Documents/workspace/Parsers/src/OPPLLintCombined.g:104:13:
						// ^( TEXT[$AND.text] )
						{
							OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor.nil();
							root_1 = (OPPLSyntaxTree) this.adaptor.becomeRoot(this.adaptor.create(
									TEXT,
									(AND18 != null ? AND18.getText() : null)), root_1);
							this.adaptor.addChild(root_0, root_1);
						}
					}
					retval.tree = root_0;
				}
			}
				break;
			case 12:
				// /Users/luigi/Documents/workspace/Parsers/src/OPPLLintCombined.g:105:6:
				// OR
			{
				OR19 = (Token) this.match(this.input, OR, FOLLOW_OR_in_textBit399);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_OR.add(OR19);
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
					// 105:9: -> ^( TEXT[$OR.text] )
					{
						// /Users/luigi/Documents/workspace/Parsers/src/OPPLLintCombined.g:105:12:
						// ^( TEXT[$OR.text] )
						{
							OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor.nil();
							root_1 = (OPPLSyntaxTree) this.adaptor.becomeRoot(this.adaptor.create(
									TEXT,
									(OR19 != null ? OR19.getText() : null)), root_1);
							this.adaptor.addChild(root_0, root_1);
						}
					}
					retval.tree = root_0;
				}
			}
				break;
			case 13:
				// /Users/luigi/Documents/workspace/Parsers/src/OPPLLintCombined.g:106:6:
				// SOME
			{
				SOME20 = (Token) this.match(this.input, SOME, FOLLOW_SOME_in_textBit414);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_SOME.add(SOME20);
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
					// 106:11: -> ^( TEXT[$SOME.text] )
					{
						// /Users/luigi/Documents/workspace/Parsers/src/OPPLLintCombined.g:106:14:
						// ^( TEXT[$SOME.text] )
						{
							OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor.nil();
							root_1 = (OPPLSyntaxTree) this.adaptor.becomeRoot(this.adaptor.create(
									TEXT,
									(SOME20 != null ? SOME20.getText() : null)), root_1);
							this.adaptor.addChild(root_0, root_1);
						}
					}
					retval.tree = root_0;
				}
			}
				break;
			case 14:
				// /Users/luigi/Documents/workspace/Parsers/src/OPPLLintCombined.g:107:6:
				// ONLY
			{
				ONLY21 = (Token) this.match(this.input, ONLY, FOLLOW_ONLY_in_textBit429);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_ONLY.add(ONLY21);
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
					// 107:11: -> ^( TEXT[$ONLY.text] )
					{
						// /Users/luigi/Documents/workspace/Parsers/src/OPPLLintCombined.g:107:14:
						// ^( TEXT[$ONLY.text] )
						{
							OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor.nil();
							root_1 = (OPPLSyntaxTree) this.adaptor.becomeRoot(this.adaptor.create(
									TEXT,
									(ONLY21 != null ? ONLY21.getText() : null)), root_1);
							this.adaptor.addChild(root_0, root_1);
						}
					}
					retval.tree = root_0;
				}
			}
				break;
			case 15:
				// /Users/luigi/Documents/workspace/Parsers/src/OPPLLintCombined.g:108:6:
				// MIN
			{
				MIN22 = (Token) this.match(this.input, MIN, FOLLOW_MIN_in_textBit444);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_MIN.add(MIN22);
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
					// 108:10: -> ^( TEXT[$MIN.text] )
					{
						// /Users/luigi/Documents/workspace/Parsers/src/OPPLLintCombined.g:108:13:
						// ^( TEXT[$MIN.text] )
						{
							OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor.nil();
							root_1 = (OPPLSyntaxTree) this.adaptor.becomeRoot(this.adaptor.create(
									TEXT,
									(MIN22 != null ? MIN22.getText() : null)), root_1);
							this.adaptor.addChild(root_0, root_1);
						}
					}
					retval.tree = root_0;
				}
			}
				break;
			case 16:
				// /Users/luigi/Documents/workspace/Parsers/src/OPPLLintCombined.g:109:6:
				// MAX
			{
				MAX23 = (Token) this.match(this.input, MAX, FOLLOW_MAX_in_textBit459);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_MAX.add(MAX23);
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
					// 109:10: -> ^( TEXT[$MAX.text] )
					{
						// /Users/luigi/Documents/workspace/Parsers/src/OPPLLintCombined.g:109:13:
						// ^( TEXT[$MAX.text] )
						{
							OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor.nil();
							root_1 = (OPPLSyntaxTree) this.adaptor.becomeRoot(this.adaptor.create(
									TEXT,
									(MAX23 != null ? MAX23.getText() : null)), root_1);
							this.adaptor.addChild(root_0, root_1);
						}
					}
					retval.tree = root_0;
				}
			}
				break;
			case 17:
				// /Users/luigi/Documents/workspace/Parsers/src/OPPLLintCombined.g:110:6:
				// EXACTLY
			{
				EXACTLY24 = (Token) this.match(this.input, EXACTLY, FOLLOW_EXACTLY_in_textBit477);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_EXACTLY.add(EXACTLY24);
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
					// 110:14: -> ^( TEXT[$EXACTLY.text] )
					{
						// /Users/luigi/Documents/workspace/Parsers/src/OPPLLintCombined.g:110:17:
						// ^( TEXT[$EXACTLY.text] )
						{
							OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor.nil();
							root_1 = (OPPLSyntaxTree) this.adaptor.becomeRoot(
									this.adaptor.create(
											TEXT,
											(EXACTLY24 != null ? EXACTLY24.getText() : null)),
									root_1);
							this.adaptor.addChild(root_0, root_1);
						}
					}
					retval.tree = root_0;
				}
			}
				break;
			case 18:
				// /Users/luigi/Documents/workspace/Parsers/src/OPPLLintCombined.g:111:6:
				// VALUE
			{
				VALUE25 = (Token) this.match(this.input, VALUE, FOLLOW_VALUE_in_textBit495);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_VALUE.add(VALUE25);
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
					// 111:12: -> ^( TEXT[$VALUE.text] )
					{
						// /Users/luigi/Documents/workspace/Parsers/src/OPPLLintCombined.g:111:15:
						// ^( TEXT[$VALUE.text] )
						{
							OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor.nil();
							root_1 = (OPPLSyntaxTree) this.adaptor.becomeRoot(this.adaptor.create(
									TEXT,
									(VALUE25 != null ? VALUE25.getText() : null)), root_1);
							this.adaptor.addChild(root_0, root_1);
						}
					}
					retval.tree = root_0;
				}
			}
				break;
			case 19:
				// /Users/luigi/Documents/workspace/Parsers/src/OPPLLintCombined.g:112:6:
				// INVERSE
			{
				INVERSE26 = (Token) this.match(this.input, INVERSE, FOLLOW_INVERSE_in_textBit513);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_INVERSE.add(INVERSE26);
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
					// 112:14: -> ^( TEXT[$INVERSE.text] )
					{
						// /Users/luigi/Documents/workspace/Parsers/src/OPPLLintCombined.g:112:17:
						// ^( TEXT[$INVERSE.text] )
						{
							OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor.nil();
							root_1 = (OPPLSyntaxTree) this.adaptor.becomeRoot(
									this.adaptor.create(
											TEXT,
											(INVERSE26 != null ? INVERSE26.getText() : null)),
									root_1);
							this.adaptor.addChild(root_0, root_1);
						}
					}
					retval.tree = root_0;
				}
			}
				break;
			case 20:
				// /Users/luigi/Documents/workspace/Parsers/src/OPPLLintCombined.g:113:6:
				// DOMAIN
			{
				DOMAIN27 = (Token) this.match(this.input, DOMAIN, FOLLOW_DOMAIN_in_textBit531);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_DOMAIN.add(DOMAIN27);
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
					// 113:13: -> ^( TEXT[$DOMAIN.text] )
					{
						// /Users/luigi/Documents/workspace/Parsers/src/OPPLLintCombined.g:113:16:
						// ^( TEXT[$DOMAIN.text] )
						{
							OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor.nil();
							root_1 = (OPPLSyntaxTree) this.adaptor.becomeRoot(
									this.adaptor.create(
											TEXT,
											(DOMAIN27 != null ? DOMAIN27.getText() : null)),
									root_1);
							this.adaptor.addChild(root_0, root_1);
						}
					}
					retval.tree = root_0;
				}
			}
				break;
			case 21:
				// /Users/luigi/Documents/workspace/Parsers/src/OPPLLintCombined.g:114:6:
				// RANGE
			{
				RANGE28 = (Token) this.match(this.input, RANGE, FOLLOW_RANGE_in_textBit549);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_RANGE.add(RANGE28);
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
					// 114:12: -> ^( TEXT[$RANGE.text] )
					{
						// /Users/luigi/Documents/workspace/Parsers/src/OPPLLintCombined.g:114:15:
						// ^( TEXT[$RANGE.text] )
						{
							OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor.nil();
							root_1 = (OPPLSyntaxTree) this.adaptor.becomeRoot(this.adaptor.create(
									TEXT,
									(RANGE28 != null ? RANGE28.getText() : null)), root_1);
							this.adaptor.addChild(root_0, root_1);
						}
					}
					retval.tree = root_0;
				}
			}
				break;
			case 22:
				// /Users/luigi/Documents/workspace/Parsers/src/OPPLLintCombined.g:115:6:
				// TYPES
			{
				TYPES29 = (Token) this.match(this.input, TYPES, FOLLOW_TYPES_in_textBit564);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_TYPES.add(TYPES29);
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
					// 115:12: -> ^( TEXT[$TYPES.text] )
					{
						// /Users/luigi/Documents/workspace/Parsers/src/OPPLLintCombined.g:115:15:
						// ^( TEXT[$TYPES.text] )
						{
							OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor.nil();
							root_1 = (OPPLSyntaxTree) this.adaptor.becomeRoot(this.adaptor.create(
									TEXT,
									(TYPES29 != null ? TYPES29.getText() : null)), root_1);
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
	// /Users/luigi/Documents/workspace/Parsers/src/OPPLLintCombined.g:118:1:
	// statement : ( variableDefinitions )? query ( actions )? -> ^(
	// OPPL_STATEMENT ( variableDefinitions )? query ( actions )? ) ;
	public final OPPLLintCombinedParser.statement_return statement() throws RecognitionException {
		OPPLLintCombinedParser.statement_return retval = new OPPLLintCombinedParser.statement_return();
		retval.start = this.input.LT(1);
		OPPLSyntaxTree root_0 = null;
		OPPLLintCombined_OPPLParser.variableDefinitions_return variableDefinitions30 = null;
		OPPLLintCombined_OPPLParser.query_return query31 = null;
		OPPLLintCombined_OPPLParser.actions_return actions32 = null;
		RewriteRuleSubtreeStream stream_query = new RewriteRuleSubtreeStream(this.adaptor,
				"rule query");
		RewriteRuleSubtreeStream stream_variableDefinitions = new RewriteRuleSubtreeStream(
				this.adaptor, "rule variableDefinitions");
		RewriteRuleSubtreeStream stream_actions = new RewriteRuleSubtreeStream(this.adaptor,
				"rule actions");
		try {
			// /Users/luigi/Documents/workspace/Parsers/src/OPPLLintCombined.g:119:3:
			// ( ( variableDefinitions )? query ( actions )? -> ^(
			// OPPL_STATEMENT ( variableDefinitions )? query ( actions )? ) )
			// /Users/luigi/Documents/workspace/Parsers/src/OPPLLintCombined.g:120:5:
			// ( variableDefinitions )? query ( actions )?
			{
				// /Users/luigi/Documents/workspace/Parsers/src/OPPLLintCombined.g:120:5:
				// ( variableDefinitions )?
				int alt4 = 2;
				int LA4_0 = this.input.LA(1);
				if (LA4_0 == VARIABLE_NAME) {
					alt4 = 1;
				}
				switch (alt4) {
				case 1:
					// /Users/luigi/Documents/workspace/Parsers/src/OPPLLintCombined.g:0:0:
					// variableDefinitions
				{
					this.pushFollow(FOLLOW_variableDefinitions_in_statement596);
					variableDefinitions30 = this.variableDefinitions();
					this.state._fsp--;
					if (this.state.failed) {
						return retval;
					}
					if (this.state.backtracking == 0) {
						stream_variableDefinitions.add(variableDefinitions30.getTree());
					}
				}
					break;
				}
				this.pushFollow(FOLLOW_query_in_statement599);
				query31 = this.query();
				this.state._fsp--;
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_query.add(query31.getTree());
				}
				// /Users/luigi/Documents/workspace/Parsers/src/OPPLLintCombined.g:120:32:
				// ( actions )?
				int alt5 = 2;
				int LA5_0 = this.input.LA(1);
				if (LA5_0 == BEGIN) {
					alt5 = 1;
				}
				switch (alt5) {
				case 1:
					// /Users/luigi/Documents/workspace/Parsers/src/OPPLLintCombined.g:0:0:
					// actions
				{
					this.pushFollow(FOLLOW_actions_in_statement601);
					actions32 = this.actions();
					this.state._fsp--;
					if (this.state.failed) {
						return retval;
					}
					if (this.state.backtracking == 0) {
						stream_actions.add(actions32.getTree());
					}
				}
					break;
				}
				// AST REWRITE
				// elements: variableDefinitions, query, actions
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
					// 120:41: -> ^( OPPL_STATEMENT ( variableDefinitions )?
					// query ( actions )? )
					{
						// /Users/luigi/Documents/workspace/Parsers/src/OPPLLintCombined.g:120:44:
						// ^( OPPL_STATEMENT ( variableDefinitions )? query (
						// actions )? )
						{
							OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor.nil();
							root_1 = (OPPLSyntaxTree) this.adaptor.becomeRoot(
									this.adaptor.create(OPPL_STATEMENT, "OPPL_STATEMENT"),
									root_1);
							// /Users/luigi/Documents/workspace/Parsers/src/OPPLLintCombined.g:120:61:
							// ( variableDefinitions )?
							if (stream_variableDefinitions.hasNext()) {
								this.adaptor.addChild(root_1, stream_variableDefinitions.nextTree());
							}
							stream_variableDefinitions.reset();
							this.adaptor.addChild(root_1, stream_query.nextTree());
							// /Users/luigi/Documents/workspace/Parsers/src/OPPLLintCombined.g:120:88:
							// ( actions )?
							if (stream_actions.hasNext()) {
								this.adaptor.addChild(root_1, stream_actions.nextTree());
							}
							stream_actions.reset();
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
	public static class returnClause_return extends ParserRuleReturnScope {
		OPPLSyntaxTree tree;

		@Override
		public Object getTree() {
			return this.tree;
		}
	};

	// $ANTLR start "returnClause"
	// /Users/luigi/Documents/workspace/Parsers/src/OPPLLintCombined.g:125:1:
	// returnClause : RETURN returnValue -> ^( RETURN returnValue ) ;
	public final OPPLLintCombinedParser.returnClause_return returnClause()
			throws RecognitionException {
		OPPLLintCombinedParser.returnClause_return retval = new OPPLLintCombinedParser.returnClause_return();
		retval.start = this.input.LT(1);
		OPPLSyntaxTree root_0 = null;
		Token RETURN33 = null;
		OPPLLintCombinedParser.returnValue_return returnValue34 = null;
		OPPLSyntaxTree RETURN33_tree = null;
		RewriteRuleTokenStream stream_RETURN = new RewriteRuleTokenStream(this.adaptor,
				"token RETURN");
		RewriteRuleSubtreeStream stream_returnValue = new RewriteRuleSubtreeStream(this.adaptor,
				"rule returnValue");
		try {
			// /Users/luigi/Documents/workspace/Parsers/src/OPPLLintCombined.g:126:3:
			// ( RETURN returnValue -> ^( RETURN returnValue ) )
			// /Users/luigi/Documents/workspace/Parsers/src/OPPLLintCombined.g:127:5:
			// RETURN returnValue
			{
				RETURN33 = (Token) this.match(this.input, RETURN, FOLLOW_RETURN_in_returnClause637);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_RETURN.add(RETURN33);
				}
				this.pushFollow(FOLLOW_returnValue_in_returnClause639);
				returnValue34 = this.returnValue();
				this.state._fsp--;
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_returnValue.add(returnValue34.getTree());
				}
				// AST REWRITE
				// elements: RETURN, returnValue
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
					// 127:25: -> ^( RETURN returnValue )
					{
						// /Users/luigi/Documents/workspace/Parsers/src/OPPLLintCombined.g:127:27:
						// ^( RETURN returnValue )
						{
							OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor.nil();
							root_1 = (OPPLSyntaxTree) this.adaptor.becomeRoot(
									stream_RETURN.nextNode(),
									root_1);
							this.adaptor.addChild(root_1, stream_returnValue.nextTree());
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

	// $ANTLR end "returnClause"
	public static class returnValue_return extends ParserRuleReturnScope {
		OPPLSyntaxTree tree;

		@Override
		public Object getTree() {
			return this.tree;
		}
	};

	// $ANTLR start "returnValue"
	// /Users/luigi/Documents/workspace/Parsers/src/OPPLLintCombined.g:130:1:
	// returnValue : VARIABLE_NAME -> VARIABLE_NAME ;
	public final OPPLLintCombinedParser.returnValue_return returnValue()
			throws RecognitionException {
		OPPLLintCombinedParser.returnValue_return retval = new OPPLLintCombinedParser.returnValue_return();
		retval.start = this.input.LT(1);
		OPPLSyntaxTree root_0 = null;
		Token VARIABLE_NAME35 = null;
		OPPLSyntaxTree VARIABLE_NAME35_tree = null;
		RewriteRuleTokenStream stream_VARIABLE_NAME = new RewriteRuleTokenStream(this.adaptor,
				"token VARIABLE_NAME");
		try {
			// /Users/luigi/Documents/workspace/Parsers/src/OPPLLintCombined.g:131:3:
			// ( VARIABLE_NAME -> VARIABLE_NAME )
			// /Users/luigi/Documents/workspace/Parsers/src/OPPLLintCombined.g:132:7:
			// VARIABLE_NAME
			{
				VARIABLE_NAME35 = (Token) this.match(
						this.input,
						VARIABLE_NAME,
						FOLLOW_VARIABLE_NAME_in_returnValue668);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_VARIABLE_NAME.add(VARIABLE_NAME35);
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
					// 132:21: -> VARIABLE_NAME
					{
						this.adaptor.addChild(root_0, stream_VARIABLE_NAME.nextNode());
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

	// $ANTLR end "returnValue"
	public static class description_return extends ParserRuleReturnScope {
		OPPLSyntaxTree tree;

		@Override
		public Object getTree() {
			return this.tree;
		}
	};

	// $ANTLR start "description"
	// /Users/luigi/Documents/workspace/Parsers/src/OPPLLintCombined.g:135:1:
	// description : (a= . )+ -> ^( DESCRIPTION[builder.toString()] ( $a)+ ) ;
	public final OPPLLintCombinedParser.description_return description()
			throws RecognitionException {
		OPPLLintCombinedParser.description_return retval = new OPPLLintCombinedParser.description_return();
		retval.start = this.input.LT(1);
		OPPLSyntaxTree root_0 = null;
		Token a = null;
		OPPLSyntaxTree a_tree = null;
		StringBuilder builder = new StringBuilder();
		try {
			// /Users/luigi/Documents/workspace/Parsers/src/OPPLLintCombined.g:140:3:
			// ( (a= . )+ -> ^( DESCRIPTION[builder.toString()] ( $a)+ ) )
			// /Users/luigi/Documents/workspace/Parsers/src/OPPLLintCombined.g:141:5:
			// (a= . )+
			{
				// /Users/luigi/Documents/workspace/Parsers/src/OPPLLintCombined.g:141:5:
				// (a= . )+
				int cnt6 = 0;
				loop6: do {
					int alt6 = 2;
					int LA6_0 = this.input.LA(1);
					if (LA6_0 >= COMPOSITION && LA6_0 <= SUBPROPERTY_OF) {
						alt6 = 1;
					}
					switch (alt6) {
					case 1:
						// /Users/luigi/Documents/workspace/Parsers/src/OPPLLintCombined.g:141:6:
						// a= .
					{
						a = this.input.LT(1);
						this.matchAny(this.input);
						if (this.state.failed) {
							return retval;
						}
						if (this.state.backtracking == 0) {
							a_tree = (OPPLSyntaxTree) this.adaptor.create(a);
							this.adaptor.addChild(root_0, a_tree);
						}
						if (this.state.backtracking == 0) {
							builder.append((a != null ? a.getText() : null));
							builder.append(" ");
						}
					}
						break;
					default:
						if (cnt6 >= 1) {
							break loop6;
						}
						if (this.state.backtracking > 0) {
							this.state.failed = true;
							return retval;
						}
						EarlyExitException eee = new EarlyExitException(6, this.input);
						throw eee;
					}
					cnt6++;
				} while (true);
				// AST REWRITE
				// elements: a
				// token labels: a
				// rule labels: retval
				// token list labels:
				// rule list labels:
				// wildcard labels:
				if (this.state.backtracking == 0) {
					retval.tree = root_0;
					RewriteRuleTokenStream stream_a = new RewriteRuleTokenStream(this.adaptor,
							"token a", a);
					RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(
							this.adaptor, "rule retval", retval != null ? retval.tree : null);
					root_0 = (OPPLSyntaxTree) this.adaptor.nil();
					// 146:9: -> ^( DESCRIPTION[builder.toString()] ( $a)+ )
					{
						// /Users/luigi/Documents/workspace/Parsers/src/OPPLLintCombined.g:146:11:
						// ^( DESCRIPTION[builder.toString()] ( $a)+ )
						{
							OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor.nil();
							root_1 = (OPPLSyntaxTree) this.adaptor.becomeRoot(
									this.adaptor.create(DESCRIPTION, builder.toString()),
									root_1);
							if (!stream_a.hasNext()) {
								throw new RewriteEarlyExitException();
							}
							while (stream_a.hasNext()) {
								this.adaptor.addChild(root_1, stream_a.nextNode());
							}
							stream_a.reset();
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

	// $ANTLR end "description"
	// Delegated rules
	public OPPLLintCombined_OPPLParser_MOWLParser.conjunction_return conjunction()
			throws RecognitionException {
		return this.gMOWLParser.conjunction();
	}

	public OPPLLintCombined_OPPLParser.query_return query() throws RecognitionException {
		return this.gOPPLParser.query();
	}

	public OPPLLintCombined_OPPLParser_MOWLParser.oneOf_return oneOf() throws RecognitionException {
		return this.gMOWLParser.oneOf();
	}

	public OPPLLintCombined_OPPLParser.variableDefinition_return variableDefinition()
			throws RecognitionException {
		return this.gOPPLParser.variableDefinition();
	}

	public OPPLLintCombined_OPPLParser.attributeSelector_return attributeSelector()
			throws RecognitionException {
		return this.gOPPLParser.attributeSelector();
	}

	public OPPLLintCombined_OPPLParser.opplFunction_return opplFunction()
			throws RecognitionException {
		return this.gOPPLParser.opplFunction();
	}

	public OPPLLintCombined_OPPLParser.variableScope_return variableScope()
			throws RecognitionException {
		return this.gOPPLParser.variableScope();
	}

	public OPPLLintCombined_OPPLParser_MOWLParser.propertyExpression_return propertyExpression()
			throws RecognitionException {
		return this.gMOWLParser.propertyExpression();
	}

	public OPPLLintCombined_OPPLParser_MOWLParser.unaryCharacteristic_return unaryCharacteristic()
			throws RecognitionException {
		return this.gMOWLParser.unaryCharacteristic();
	}

	public OPPLLintCombined_OPPLParser.axiom_return axiom() throws RecognitionException {
		return this.gOPPLParser.axiom();
	}

	public OPPLLintCombined_OPPLParser.atomic_return atomic() throws RecognitionException {
		return this.gOPPLParser.atomic();
	}

	public OPPLLintCombined_OPPLParser_MOWLParser.complexPropertyExpression_return complexPropertyExpression()
			throws RecognitionException {
		return this.gMOWLParser.complexPropertyExpression();
	}

	public OPPLLintCombined_OPPLParser_MOWLParser.dataRange_return dataRange()
			throws RecognitionException {
		return this.gMOWLParser.dataRange();
	}

	public OPPLLintCombined_OPPLParser_MOWLParser.unaryAxiom_return unaryAxiom()
			throws RecognitionException {
		return this.gMOWLParser.unaryAxiom();
	}

	public OPPLLintCombined_OPPLParser_MOWLParser.unary_return unary() throws RecognitionException {
		return this.gMOWLParser.unary();
	}

	public OPPLLintCombined_OPPLParser.actions_return actions() throws RecognitionException {
		return this.gOPPLParser.actions();
	}

	public OPPLLintCombined_OPPLParser.simpleStringExpression_return simpleStringExpression()
			throws RecognitionException {
		return this.gOPPLParser.simpleStringExpression();
	}

	public OPPLLintCombined_OPPLParser_MOWLParser.cardinalityRestriction_return cardinalityRestriction()
			throws RecognitionException {
		return this.gMOWLParser.cardinalityRestriction();
	}

	public OPPLLintCombined_OPPLParser.action_return action() throws RecognitionException {
		return this.gOPPLParser.action();
	}

	public OPPLLintCombined_OPPLParser.lowerUpperCase_return lowerUpperCase()
			throws RecognitionException {
		return this.gOPPLParser.lowerUpperCase();
	}

	public OPPLLintCombined_OPPLParser_MOWLParser.hasKeyAxiom_return hasKeyAxiom()
			throws RecognitionException {
		return this.gMOWLParser.hasKeyAxiom();
	}

	public OPPLLintCombined_OPPLParser_MOWLParser.expression_return expression()
			throws RecognitionException {
		return this.gMOWLParser.expression();
	}

	public OPPLLintCombined_OPPLParser_MOWLParser.value_return value() throws RecognitionException {
		return this.gMOWLParser.value();
	}

	public OPPLLintCombined_OPPLParser_MOWLParser.dataRangeFacet_return dataRangeFacet()
			throws RecognitionException {
		return this.gMOWLParser.dataRangeFacet();
	}

	public OPPLLintCombined_OPPLParser_MOWLParser.disjunction_return disjunction()
			throws RecognitionException {
		return this.gMOWLParser.disjunction();
	}

	public OPPLLintCombined_OPPLParser_MOWLParser.qualifiedRestriction_return qualifiedRestriction()
			throws RecognitionException {
		return this.gMOWLParser.qualifiedRestriction();
	}

	public OPPLLintCombined_OPPLParser.stringOperation_return stringOperation()
			throws RecognitionException {
		return this.gOPPLParser.stringOperation();
	}

	public OPPLLintCombined_OPPLParser_MOWLParser.valueRestriction_return valueRestriction()
			throws RecognitionException {
		return this.gMOWLParser.valueRestriction();
	}

	public OPPLLintCombined_OPPLParser.createIdentifier_return createIdentifier()
			throws RecognitionException {
		return this.gOPPLParser.createIdentifier();
	}

	public OPPLLintCombined_OPPLParser.selectClause_return selectClause()
			throws RecognitionException {
		return this.gOPPLParser.selectClause();
	}

	public OPPLLintCombined_OPPLParser.variableAttributeReference_return variableAttributeReference()
			throws RecognitionException {
		return this.gOPPLParser.variableAttributeReference();
	}

	public OPPLLintCombined_OPPLParser.regexp_return regexp() throws RecognitionException {
		return this.gOPPLParser.regexp();
	}

	public OPPLLintCombined_OPPLParser_MOWLParser.binaryAxiom_return binaryAxiom()
			throws RecognitionException {
		return this.gMOWLParser.binaryAxiom();
	}

	public OPPLLintCombined_OPPLParser_MOWLParser.annotationAssertionAxiom_return annotationAssertionAxiom()
			throws RecognitionException {
		return this.gMOWLParser.annotationAssertionAxiom();
	}

	public OPPLLintCombined_OPPLParser.nAryAxiom_return nAryAxiom() throws RecognitionException {
		return this.gOPPLParser.nAryAxiom();
	}

	public OPPLLintCombined_OPPLParser_MOWLParser.constant_return constant()
			throws RecognitionException {
		return this.gMOWLParser.constant();
	}

	public OPPLLintCombined_OPPLParser_MOWLParser.assertionAxiom_return assertionAxiom()
			throws RecognitionException {
		return this.gMOWLParser.assertionAxiom();
	}

	public OPPLLintCombined_OPPLParser_MOWLParser.restrictionKind_return restrictionKind()
			throws RecognitionException {
		return this.gMOWLParser.restrictionKind();
	}

	public OPPLLintCombined_OPPLParser.variableDefinitions_return variableDefinitions()
			throws RecognitionException {
		return this.gOPPLParser.variableDefinitions();
	}

	public OPPLLintCombined_OPPLParser.stringExpression_return stringExpression()
			throws RecognitionException {
		return this.gOPPLParser.stringExpression();
	}

	public OPPLLintCombined_OPPLParser.iri_return iri() throws RecognitionException {
		return this.gOPPLParser.iri();
	}

	public OPPLLintCombined_OPPLParser.constraint_return constraint() throws RecognitionException {
		return this.gOPPLParser.constraint();
	}

	public static final BitSet FOLLOW_text_in_lint128 = new BitSet(new long[] {
			0x0000000000000000L, 0x0000000000000000L, 0x0000000000000000L, 0x0000000000000000L,
			0x0000000000000000L, 0x0000000000000000L, 0x0000004000000000L });
	public static final BitSet FOLLOW_SEMICOLON_in_lint130 = new BitSet(new long[] {
			0x0000000000000000L, 0x0000000000000800L, 0x0000000000000000L, 0x0000000000000000L,
			0x0000000000000000L, 0x0000000000000000L, 0x0000000000000000L, 0x0000000000810000L });
	public static final BitSet FOLLOW_INFERENCE_in_lint132 = new BitSet(new long[] {
			0x0000000000000000L, 0x0000000000000800L, 0x0000000000000000L, 0x0000000000000000L,
			0x0000000000000000L, 0x0000000000000000L, 0x0000000000000000L, 0x0000000000810000L });
	public static final BitSet FOLLOW_statement_in_lint135 = new BitSet(new long[] {
			0x0000000000000000L, 0x0000000000000000L, 0x0000000000000000L, 0x0000000000000000L,
			0x0000000000000000L, 0x0000000000000000L, 0x0000000080000000L });
	public static final BitSet FOLLOW_returnClause_in_lint137 = new BitSet(new long[] {
			0x0000000000000000L, 0x0000000000000000L, 0x0000000000000000L, 0x0000000000000000L,
			0x0000000000000000L, 0x0000000000000000L, 0x0000004000000000L });
	public static final BitSet FOLLOW_SEMICOLON_in_lint140 = new BitSet(new long[] {
			0x0000108FF80FFC00L, 0x0000000000000000L, 0x0000000000000000L, 0x0000000000000000L,
			0x0000000000000000L, 0x0000000000000000L, 0x0000000000000000L, 0x0000000000010000L });
	public static final BitSet FOLLOW_text_in_lint146 = new BitSet(new long[] {
			0x0000000000000000L, 0x0000000000000000L, 0x0000000000000000L, 0x0000000000000000L,
			0x0000000000000000L, 0x0000000000000000L, 0x0000004000000000L });
	public static final BitSet FOLLOW_SEMICOLON_in_lint148 = new BitSet(new long[] {
			0xFFFFFFFFFFFFFFF0L, 0xFFFFFFFFFFFFFFFFL, 0xFFFFFFFFFFFFFFFFL, 0xFFFFFFFFFFFFFFFFL,
			0xFFFFFFFFFFFFFFFFL, 0xFFFFFFFFFFFFFFFFL, 0xFFFFFFFFFFFFFFFFL, 0xFFFFFFFFFFFFFFFFL,
			0xFFFFFFFFFFFFFFFFL, 0x00003FFFFFFFFFFFL });
	public static final BitSet FOLLOW_description_in_lint150 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_textBit_in_text200 = new BitSet(new long[] {
			0x0000108FF80FFC02L, 0x0000000000000000L, 0x0000000000000000L, 0x0000000000000000L,
			0x0000000000000000L, 0x0000000000000000L, 0x0000000000000000L, 0x0000000000010000L });
	public static final BitSet FOLLOW_IDENTIFIER_in_textBit232 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_VARIABLE_NAME_in_textBit247 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_FUNCTIONAL_in_textBit263 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_INVERSE_FUNCTIONAL_in_textBit278 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_SYMMETRIC_in_textBit293 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_ANTI_SYMMETRIC_in_textBit308 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_REFLEXIVE_in_textBit323 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_IRREFLEXIVE_in_textBit338 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_TRANSITIVE_in_textBit354 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_NOT_in_textBit369 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_AND_in_textBit384 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_OR_in_textBit399 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_SOME_in_textBit414 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_ONLY_in_textBit429 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_MIN_in_textBit444 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_MAX_in_textBit459 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_EXACTLY_in_textBit477 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_VALUE_in_textBit495 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_INVERSE_in_textBit513 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_DOMAIN_in_textBit531 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_RANGE_in_textBit549 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_TYPES_in_textBit564 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_variableDefinitions_in_statement596 = new BitSet(new long[] {
			0x0000000000000000L, 0x0000000000000800L, 0x0000000000000000L, 0x0000000000000000L,
			0x0000000000000000L, 0x0000000000000000L, 0x0000000000000000L, 0x0000000000810000L });
	public static final BitSet FOLLOW_query_in_statement599 = new BitSet(new long[] {
			0x0000000000000002L, 0x0000000000080000L });
	public static final BitSet FOLLOW_actions_in_statement601 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_RETURN_in_returnClause637 = new BitSet(new long[] {
			0x0000000000000000L, 0x0000000000000000L, 0x0000000000000000L, 0x0000000000000000L,
			0x0000000000000000L, 0x0000000000000000L, 0x0000000000000000L, 0x0000000000010000L });
	public static final BitSet FOLLOW_returnValue_in_returnClause639 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_VARIABLE_NAME_in_returnValue668 = new BitSet(
			new long[] { 0x0000000000000002L });
}