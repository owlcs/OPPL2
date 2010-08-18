// $ANTLR 3.2 Sep 23, 2009 12:02:23 /Users/luigi/Documents/workspace/Parsers_OWL_API_2/src/OPPLLintCombined.g 2010-08-18 10:34:57
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
			"VARIABLE_IDENTIFIER", "OPPL_STATEMENT", "OPPL_LINT",
			"ESCLAMATION_MARK", "MATCH", "VALUES", "RENDERING", "GROUPS",
			"DOLLAR", "RETURN", "SEMICOLON", "VARIABLE_NAME", "FAIL",
			"NAF_CONSTRAINT", "DESCRIPTION", "EXPLANATION", "TEXT", "WS",
			"REGEXP_CONSTRAINT", "ATTRIBUTE_SELECTOR", "STRING_OPERATION",
			"SUBPROPERTY_OF" };
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
	public static final int SYMMETRIC = 30;
	public static final int CARDINALITY_RESTRICTION = 64;
	public static final int SELECT = 75;
	public static final int ROLE_ASSERTION = 67;
	public static final int DIFFERENT_FROM_AXIOM = 53;
	public static final int CREATE_OPPL_FUNCTION = 98;
	public static final int TRANSITIVE = 34;
	public static final int ANTI_SYMMETRIC = 31;
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
	public static final int WS = 546;
	public static final int NAF_CONSTRAINT = 467;
	public static final int OPPL_LINT = 119;
	public static final int DBLQUOTE = 40;
	public static final int STRING_OPERATION = 586;
	public static final int OR = 11;
	public static final int CONSTANT = 70;
	public static final int QUERY = 103;
	public static final int ENTITY_REFERENCE = 45;
	public static final int END = 84;
	public static final int COMPOSITION = 4;
	public static final int CLOSED_SQUARE_BRACKET = 86;
	public static final int DOLLAR = 400;
	public static final int SAME_AS = 23;
	public static final int WHERE = 71;
	public static final int DISJOINT_WITH = 26;
	public static final int SUPER_PROPERTY_OF = 88;
	public static final int VARIABLE_TYPE = 89;
	public static final int ATTRIBUTE_SELECTOR = 585;
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
	public static final int REFLEXIVE = 32;
	public static final int PLUS = 79;
	public static final int DIGIT = 41;
	public static final int DOT = 78;
	public static final int SUPER_CLASS_OF = 87;
	public static final int EXPRESSION = 69;
	public static final int SOME_RESTRICTION = 61;
	public static final int ADD = 90;
	public static final int INTEGER = 42;
	public static final int EXPLANATION = 469;
	public static final int GENERATED_VARIABLE_DEFINITION = 97;
	public static final int EXACTLY = 17;
	public static final int SUB_PROPERTY_AXIOM = 51;
	public static final int OPEN_SQUARE_BRACKET = 85;
	public static final int VALUES = 354;
	public static final int REGEXP_CONSTRAINT = 575;
	public static final int RANGE = 28;
	public static final int ONE_OF = 65;
	public static final int VARIABLE_DEFINITIONS = 102;
	public static final int MIN = 15;
	public static final int SUB_CLASS_AXIOM = 48;
	public static final int TEXT = 470;
	public static final int PLAIN_CLAUSE = 93;
	public static final int Tokens = 47;
	public static final int DOMAIN = 27;
	public static final int SUBPROPERTY_OF = 587;
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
		return "/Users/luigi/Documents/workspace/Parsers_OWL_API_2/src/OPPLLintCombined.g";
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

	public static class lint_return extends ParserRuleReturnScope {
		OPPLSyntaxTree tree;

		@Override
		public Object getTree() {
			return this.tree;
		}
	};

	// $ANTLR start "lint"
	// /Users/luigi/Documents/workspace/Parsers_OWL_API_2/src/OPPLLintCombined.g:72:1:
	// lint : name= text SEMICOLON statement returnClause SEMICOLON exp= text
	// SEMICOLON description -> ^( OPPL_LINT IDENTIFIER[$name.text] statement
	// returnClause ^( EXPLANATION[$exp.text] $exp) description ) ;
	public final OPPLLintCombinedParser.lint_return lint()
			throws RecognitionException {
		OPPLLintCombinedParser.lint_return retval = new OPPLLintCombinedParser.lint_return();
		retval.start = this.input.LT(1);
		OPPLSyntaxTree root_0 = null;
		Token SEMICOLON1 = null;
		Token SEMICOLON4 = null;
		Token SEMICOLON5 = null;
		OPPLLintCombinedParser.text_return name = null;
		OPPLLintCombinedParser.text_return exp = null;
		OPPLLintCombinedParser.statement_return statement2 = null;
		OPPLLintCombinedParser.returnClause_return returnClause3 = null;
		OPPLLintCombinedParser.description_return description6 = null;
		OPPLSyntaxTree SEMICOLON1_tree = null;
		OPPLSyntaxTree SEMICOLON4_tree = null;
		OPPLSyntaxTree SEMICOLON5_tree = null;
		RewriteRuleTokenStream stream_SEMICOLON = new RewriteRuleTokenStream(
				this.adaptor, "token SEMICOLON");
		RewriteRuleSubtreeStream stream_statement = new RewriteRuleSubtreeStream(
				this.adaptor, "rule statement");
		RewriteRuleSubtreeStream stream_text = new RewriteRuleSubtreeStream(
				this.adaptor, "rule text");
		RewriteRuleSubtreeStream stream_returnClause = new RewriteRuleSubtreeStream(
				this.adaptor, "rule returnClause");
		RewriteRuleSubtreeStream stream_description = new RewriteRuleSubtreeStream(
				this.adaptor, "rule description");
		try {
			// /Users/luigi/Documents/workspace/Parsers_OWL_API_2/src/OPPLLintCombined.g:73:3:
			// (name= text SEMICOLON statement returnClause SEMICOLON exp= text
			// SEMICOLON description -> ^( OPPL_LINT IDENTIFIER[$name.text]
			// statement returnClause ^( EXPLANATION[$exp.text] $exp)
			// description ) )
			// /Users/luigi/Documents/workspace/Parsers_OWL_API_2/src/OPPLLintCombined.g:74:5:
			// name= text SEMICOLON statement returnClause SEMICOLON exp= text
			// SEMICOLON description
			{
				this.pushFollow(FOLLOW_text_in_lint119);
				name = this.text();
				this.state._fsp--;
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_text.add(name.getTree());
				}
				SEMICOLON1 = (Token) this.match(this.input, SEMICOLON,
						FOLLOW_SEMICOLON_in_lint121);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_SEMICOLON.add(SEMICOLON1);
				}
				this.pushFollow(FOLLOW_statement_in_lint124);
				statement2 = this.statement();
				this.state._fsp--;
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_statement.add(statement2.getTree());
				}
				this.pushFollow(FOLLOW_returnClause_in_lint126);
				returnClause3 = this.returnClause();
				this.state._fsp--;
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_returnClause.add(returnClause3.getTree());
				}
				SEMICOLON4 = (Token) this.match(this.input, SEMICOLON,
						FOLLOW_SEMICOLON_in_lint129);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_SEMICOLON.add(SEMICOLON4);
				}
				this.pushFollow(FOLLOW_text_in_lint135);
				exp = this.text();
				this.state._fsp--;
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_text.add(exp.getTree());
				}
				SEMICOLON5 = (Token) this.match(this.input, SEMICOLON,
						FOLLOW_SEMICOLON_in_lint137);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_SEMICOLON.add(SEMICOLON5);
				}
				this.pushFollow(FOLLOW_description_in_lint139);
				description6 = this.description();
				this.state._fsp--;
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_description.add(description6.getTree());
				}
				// AST REWRITE
				// elements: returnClause, description, exp, statement
				// token labels:
				// rule labels: exp, retval
				// token list labels:
				// rule list labels:
				// wildcard labels:
				if (this.state.backtracking == 0) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_exp = new RewriteRuleSubtreeStream(
							this.adaptor, "rule exp", exp != null ? exp.tree
									: null);
					RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(
							this.adaptor, "rule retval",
							retval != null ? retval.tree : null);
					root_0 = (OPPLSyntaxTree) this.adaptor.nil();
					// 74:95: -> ^( OPPL_LINT IDENTIFIER[$name.text] statement
					// returnClause ^( EXPLANATION[$exp.text] $exp) description
					// )
					{
						// /Users/luigi/Documents/workspace/Parsers_OWL_API_2/src/OPPLLintCombined.g:74:97:
						// ^( OPPL_LINT IDENTIFIER[$name.text] statement
						// returnClause ^( EXPLANATION[$exp.text] $exp)
						// description )
						{
							OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor
									.nil();
							root_1 = (OPPLSyntaxTree) this.adaptor
									.becomeRoot(this.adaptor.create(OPPL_LINT,
											"OPPL_LINT"), root_1);
							this.adaptor.addChild(root_1, this.adaptor.create(
									IDENTIFIER, (name != null ? this.input
											.toString(name.start, name.stop)
											: null)));
							this.adaptor.addChild(root_1, stream_statement
									.nextTree());
							this.adaptor.addChild(root_1, stream_returnClause
									.nextTree());
							// /Users/luigi/Documents/workspace/Parsers_OWL_API_2/src/OPPLLintCombined.g:74:155:
							// ^( EXPLANATION[$exp.text] $exp)
							{
								OPPLSyntaxTree root_2 = (OPPLSyntaxTree) this.adaptor
										.nil();
								root_2 = (OPPLSyntaxTree) this.adaptor
										.becomeRoot(this.adaptor.create(
												EXPLANATION,
												(exp != null ? this.input
														.toString(exp.start,
																exp.stop)
														: null)), root_2);
								this.adaptor.addChild(root_2, stream_exp
										.nextTree());
								this.adaptor.addChild(root_1, root_2);
							}
							this.adaptor.addChild(root_1, stream_description
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

	// $ANTLR end "lint"
	public static class text_return extends ParserRuleReturnScope {
		OPPLSyntaxTree tree;

		@Override
		public Object getTree() {
			return this.tree;
		}
	};

	// $ANTLR start "text"
	// /Users/luigi/Documents/workspace/Parsers_OWL_API_2/src/OPPLLintCombined.g:77:1:
	// text : (t= textBit )+ -> ^( TEXT[builder.toString()] ( textBit )+ ) ;
	public final OPPLLintCombinedParser.text_return text()
			throws RecognitionException {
		OPPLLintCombinedParser.text_return retval = new OPPLLintCombinedParser.text_return();
		retval.start = this.input.LT(1);
		OPPLSyntaxTree root_0 = null;
		OPPLLintCombinedParser.textBit_return t = null;
		RewriteRuleSubtreeStream stream_textBit = new RewriteRuleSubtreeStream(
				this.adaptor, "rule textBit");
		StringBuilder builder = new StringBuilder();
		try {
			// /Users/luigi/Documents/workspace/Parsers_OWL_API_2/src/OPPLLintCombined.g:83:1:
			// ( (t= textBit )+ -> ^( TEXT[builder.toString()] ( textBit )+ ) )
			// /Users/luigi/Documents/workspace/Parsers_OWL_API_2/src/OPPLLintCombined.g:84:1:
			// (t= textBit )+
			{
				// /Users/luigi/Documents/workspace/Parsers_OWL_API_2/src/OPPLLintCombined.g:84:1:
				// (t= textBit )+
				int cnt1 = 0;
				loop1: do {
					int alt1 = 2;
					int LA1_0 = this.input.LA(1);
					if (LA1_0 >= FUNCTIONAL && LA1_0 <= INVERSE_FUNCTIONAL
							|| LA1_0 == IDENTIFIER || LA1_0 == VARIABLE_NAME) {
						alt1 = 1;
					}
					switch (alt1) {
					case 1:
						// /Users/luigi/Documents/workspace/Parsers_OWL_API_2/src/OPPLLintCombined.g:84:3:
						// t= textBit
					{
						this.pushFollow(FOLLOW_textBit_in_text186);
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
						if (cnt1 >= 1) {
							break loop1;
						}
						if (this.state.backtracking > 0) {
							this.state.failed = true;
							return retval;
						}
						EarlyExitException eee = new EarlyExitException(1,
								this.input);
						throw eee;
					}
					cnt1++;
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
					// 88:8: -> ^( TEXT[builder.toString()] ( textBit )+ )
					{
						// /Users/luigi/Documents/workspace/Parsers_OWL_API_2/src/OPPLLintCombined.g:88:11:
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
	// /Users/luigi/Documents/workspace/Parsers_OWL_API_2/src/OPPLLintCombined.g:91:1:
	// textBit : ( IDENTIFIER -> ^( TEXT[$IDENTIFIER.text] ) | VARIABLE_NAME ->
	// ^( TEXT VARIABLE_NAME ) | FUNCTIONAL -> ^( TEXT[$FUNCTIONAL.text] ) |
	// INVERSE_FUNCTIONAL -> ^( TEXT[$INVERSE_FUNCTIONAL.text] ) | SYMMETRIC ->
	// ^( TEXT[$SYMMETRIC.text] ) | ANTI_SYMMETRIC -> ^(
	// TEXT[$ANTI_SYMMETRIC.text] ) | REFLEXIVE -> ^( TEXT[$REFLEXIVE.text] ) |
	// IRREFLEXIVE -> ^( TEXT[$IRREFLEXIVE.text] ) | TRANSITIVE -> ^(
	// TEXT[$TRANSITIVE.text] ) );
	public final OPPLLintCombinedParser.textBit_return textBit()
			throws RecognitionException {
		OPPLLintCombinedParser.textBit_return retval = new OPPLLintCombinedParser.textBit_return();
		retval.start = this.input.LT(1);
		OPPLSyntaxTree root_0 = null;
		Token IDENTIFIER7 = null;
		Token VARIABLE_NAME8 = null;
		Token FUNCTIONAL9 = null;
		Token INVERSE_FUNCTIONAL10 = null;
		Token SYMMETRIC11 = null;
		Token ANTI_SYMMETRIC12 = null;
		Token REFLEXIVE13 = null;
		Token IRREFLEXIVE14 = null;
		Token TRANSITIVE15 = null;
		OPPLSyntaxTree IDENTIFIER7_tree = null;
		OPPLSyntaxTree VARIABLE_NAME8_tree = null;
		OPPLSyntaxTree FUNCTIONAL9_tree = null;
		OPPLSyntaxTree INVERSE_FUNCTIONAL10_tree = null;
		OPPLSyntaxTree SYMMETRIC11_tree = null;
		OPPLSyntaxTree ANTI_SYMMETRIC12_tree = null;
		OPPLSyntaxTree REFLEXIVE13_tree = null;
		OPPLSyntaxTree IRREFLEXIVE14_tree = null;
		OPPLSyntaxTree TRANSITIVE15_tree = null;
		RewriteRuleTokenStream stream_REFLEXIVE = new RewriteRuleTokenStream(
				this.adaptor, "token REFLEXIVE");
		RewriteRuleTokenStream stream_SYMMETRIC = new RewriteRuleTokenStream(
				this.adaptor, "token SYMMETRIC");
		RewriteRuleTokenStream stream_FUNCTIONAL = new RewriteRuleTokenStream(
				this.adaptor, "token FUNCTIONAL");
		RewriteRuleTokenStream stream_VARIABLE_NAME = new RewriteRuleTokenStream(
				this.adaptor, "token VARIABLE_NAME");
		RewriteRuleTokenStream stream_TRANSITIVE = new RewriteRuleTokenStream(
				this.adaptor, "token TRANSITIVE");
		RewriteRuleTokenStream stream_ANTI_SYMMETRIC = new RewriteRuleTokenStream(
				this.adaptor, "token ANTI_SYMMETRIC");
		RewriteRuleTokenStream stream_INVERSE_FUNCTIONAL = new RewriteRuleTokenStream(
				this.adaptor, "token INVERSE_FUNCTIONAL");
		RewriteRuleTokenStream stream_IDENTIFIER = new RewriteRuleTokenStream(
				this.adaptor, "token IDENTIFIER");
		RewriteRuleTokenStream stream_IRREFLEXIVE = new RewriteRuleTokenStream(
				this.adaptor, "token IRREFLEXIVE");
		try {
			// /Users/luigi/Documents/workspace/Parsers_OWL_API_2/src/OPPLLintCombined.g:92:2:
			// ( IDENTIFIER -> ^( TEXT[$IDENTIFIER.text] ) | VARIABLE_NAME -> ^(
			// TEXT VARIABLE_NAME ) | FUNCTIONAL -> ^( TEXT[$FUNCTIONAL.text] )
			// | INVERSE_FUNCTIONAL -> ^( TEXT[$INVERSE_FUNCTIONAL.text] ) |
			// SYMMETRIC -> ^( TEXT[$SYMMETRIC.text] ) | ANTI_SYMMETRIC -> ^(
			// TEXT[$ANTI_SYMMETRIC.text] ) | REFLEXIVE -> ^(
			// TEXT[$REFLEXIVE.text] ) | IRREFLEXIVE -> ^(
			// TEXT[$IRREFLEXIVE.text] ) | TRANSITIVE -> ^(
			// TEXT[$TRANSITIVE.text] ) )
			int alt2 = 9;
			switch (this.input.LA(1)) {
			case IDENTIFIER: {
				alt2 = 1;
			}
				break;
			case VARIABLE_NAME: {
				alt2 = 2;
			}
				break;
			case FUNCTIONAL: {
				alt2 = 3;
			}
				break;
			case INVERSE_FUNCTIONAL: {
				alt2 = 4;
			}
				break;
			case SYMMETRIC: {
				alt2 = 5;
			}
				break;
			case ANTI_SYMMETRIC: {
				alt2 = 6;
			}
				break;
			case REFLEXIVE: {
				alt2 = 7;
			}
				break;
			case IRREFLEXIVE: {
				alt2 = 8;
			}
				break;
			case TRANSITIVE: {
				alt2 = 9;
			}
				break;
			default:
				if (this.state.backtracking > 0) {
					this.state.failed = true;
					return retval;
				}
				NoViableAltException nvae = new NoViableAltException("", 2, 0,
						this.input);
				throw nvae;
			}
			switch (alt2) {
			case 1:
				// /Users/luigi/Documents/workspace/Parsers_OWL_API_2/src/OPPLLintCombined.g:93:2:
				// IDENTIFIER
			{
				IDENTIFIER7 = (Token) this.match(this.input, IDENTIFIER,
						FOLLOW_IDENTIFIER_in_textBit216);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_IDENTIFIER.add(IDENTIFIER7);
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
					// 93:13: -> ^( TEXT[$IDENTIFIER.text] )
					{
						// /Users/luigi/Documents/workspace/Parsers_OWL_API_2/src/OPPLLintCombined.g:93:16:
						// ^( TEXT[$IDENTIFIER.text] )
						{
							OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor
									.nil();
							root_1 = (OPPLSyntaxTree) this.adaptor
									.becomeRoot(this.adaptor.create(TEXT,
											(IDENTIFIER7 != null ? IDENTIFIER7
													.getText() : null)), root_1);
							this.adaptor.addChild(root_0, root_1);
						}
					}
					retval.tree = root_0;
				}
			}
				break;
			case 2:
				// /Users/luigi/Documents/workspace/Parsers_OWL_API_2/src/OPPLLintCombined.g:94:4:
				// VARIABLE_NAME
			{
				VARIABLE_NAME8 = (Token) this.match(this.input, VARIABLE_NAME,
						FOLLOW_VARIABLE_NAME_in_textBit229);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_VARIABLE_NAME.add(VARIABLE_NAME8);
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
					// 94:19: -> ^( TEXT VARIABLE_NAME )
					{
						// /Users/luigi/Documents/workspace/Parsers_OWL_API_2/src/OPPLLintCombined.g:94:22:
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
				// /Users/luigi/Documents/workspace/Parsers_OWL_API_2/src/OPPLLintCombined.g:95:4:
				// FUNCTIONAL
			{
				FUNCTIONAL9 = (Token) this.match(this.input, FUNCTIONAL,
						FOLLOW_FUNCTIONAL_in_textBit243);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_FUNCTIONAL.add(FUNCTIONAL9);
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
					// 95:15: -> ^( TEXT[$FUNCTIONAL.text] )
					{
						// /Users/luigi/Documents/workspace/Parsers_OWL_API_2/src/OPPLLintCombined.g:95:18:
						// ^( TEXT[$FUNCTIONAL.text] )
						{
							OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor
									.nil();
							root_1 = (OPPLSyntaxTree) this.adaptor
									.becomeRoot(this.adaptor.create(TEXT,
											(FUNCTIONAL9 != null ? FUNCTIONAL9
													.getText() : null)), root_1);
							this.adaptor.addChild(root_0, root_1);
						}
					}
					retval.tree = root_0;
				}
			}
				break;
			case 4:
				// /Users/luigi/Documents/workspace/Parsers_OWL_API_2/src/OPPLLintCombined.g:96:8:
				// INVERSE_FUNCTIONAL
			{
				INVERSE_FUNCTIONAL10 = (Token) this.match(this.input,
						INVERSE_FUNCTIONAL,
						FOLLOW_INVERSE_FUNCTIONAL_in_textBit260);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_INVERSE_FUNCTIONAL.add(INVERSE_FUNCTIONAL10);
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
					// 96:27: -> ^( TEXT[$INVERSE_FUNCTIONAL.text] )
					{
						// /Users/luigi/Documents/workspace/Parsers_OWL_API_2/src/OPPLLintCombined.g:96:30:
						// ^( TEXT[$INVERSE_FUNCTIONAL.text] )
						{
							OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor
									.nil();
							root_1 = (OPPLSyntaxTree) this.adaptor
									.becomeRoot(
											this.adaptor
													.create(
															TEXT,
															(INVERSE_FUNCTIONAL10 != null ? INVERSE_FUNCTIONAL10
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
				// /Users/luigi/Documents/workspace/Parsers_OWL_API_2/src/OPPLLintCombined.g:97:7:
				// SYMMETRIC
			{
				SYMMETRIC11 = (Token) this.match(this.input, SYMMETRIC,
						FOLLOW_SYMMETRIC_in_textBit276);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_SYMMETRIC.add(SYMMETRIC11);
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
					// 97:17: -> ^( TEXT[$SYMMETRIC.text] )
					{
						// /Users/luigi/Documents/workspace/Parsers_OWL_API_2/src/OPPLLintCombined.g:97:20:
						// ^( TEXT[$SYMMETRIC.text] )
						{
							OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor
									.nil();
							root_1 = (OPPLSyntaxTree) this.adaptor
									.becomeRoot(this.adaptor.create(TEXT,
											(SYMMETRIC11 != null ? SYMMETRIC11
													.getText() : null)), root_1);
							this.adaptor.addChild(root_0, root_1);
						}
					}
					retval.tree = root_0;
				}
			}
				break;
			case 6:
				// /Users/luigi/Documents/workspace/Parsers_OWL_API_2/src/OPPLLintCombined.g:98:7:
				// ANTI_SYMMETRIC
			{
				ANTI_SYMMETRIC12 = (Token) this.match(this.input,
						ANTI_SYMMETRIC, FOLLOW_ANTI_SYMMETRIC_in_textBit292);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_ANTI_SYMMETRIC.add(ANTI_SYMMETRIC12);
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
					// 98:22: -> ^( TEXT[$ANTI_SYMMETRIC.text] )
					{
						// /Users/luigi/Documents/workspace/Parsers_OWL_API_2/src/OPPLLintCombined.g:98:25:
						// ^( TEXT[$ANTI_SYMMETRIC.text] )
						{
							OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor
									.nil();
							root_1 = (OPPLSyntaxTree) this.adaptor
									.becomeRoot(
											this.adaptor
													.create(
															TEXT,
															(ANTI_SYMMETRIC12 != null ? ANTI_SYMMETRIC12
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
				// /Users/luigi/Documents/workspace/Parsers_OWL_API_2/src/OPPLLintCombined.g:99:7:
				// REFLEXIVE
			{
				REFLEXIVE13 = (Token) this.match(this.input, REFLEXIVE,
						FOLLOW_REFLEXIVE_in_textBit308);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_REFLEXIVE.add(REFLEXIVE13);
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
					// 99:17: -> ^( TEXT[$REFLEXIVE.text] )
					{
						// /Users/luigi/Documents/workspace/Parsers_OWL_API_2/src/OPPLLintCombined.g:99:20:
						// ^( TEXT[$REFLEXIVE.text] )
						{
							OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor
									.nil();
							root_1 = (OPPLSyntaxTree) this.adaptor
									.becomeRoot(this.adaptor.create(TEXT,
											(REFLEXIVE13 != null ? REFLEXIVE13
													.getText() : null)), root_1);
							this.adaptor.addChild(root_0, root_1);
						}
					}
					retval.tree = root_0;
				}
			}
				break;
			case 8:
				// /Users/luigi/Documents/workspace/Parsers_OWL_API_2/src/OPPLLintCombined.g:100:7:
				// IRREFLEXIVE
			{
				IRREFLEXIVE14 = (Token) this.match(this.input, IRREFLEXIVE,
						FOLLOW_IRREFLEXIVE_in_textBit324);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_IRREFLEXIVE.add(IRREFLEXIVE14);
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
					// 100:19: -> ^( TEXT[$IRREFLEXIVE.text] )
					{
						// /Users/luigi/Documents/workspace/Parsers_OWL_API_2/src/OPPLLintCombined.g:100:22:
						// ^( TEXT[$IRREFLEXIVE.text] )
						{
							OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor
									.nil();
							root_1 = (OPPLSyntaxTree) this.adaptor
									.becomeRoot(
											this.adaptor
													.create(
															TEXT,
															(IRREFLEXIVE14 != null ? IRREFLEXIVE14
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
				// /Users/luigi/Documents/workspace/Parsers_OWL_API_2/src/OPPLLintCombined.g:101:8:
				// TRANSITIVE
			{
				TRANSITIVE15 = (Token) this.match(this.input, TRANSITIVE,
						FOLLOW_TRANSITIVE_in_textBit341);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_TRANSITIVE.add(TRANSITIVE15);
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
					// 101:19: -> ^( TEXT[$TRANSITIVE.text] )
					{
						// /Users/luigi/Documents/workspace/Parsers_OWL_API_2/src/OPPLLintCombined.g:101:22:
						// ^( TEXT[$TRANSITIVE.text] )
						{
							OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor
									.nil();
							root_1 = (OPPLSyntaxTree) this.adaptor
									.becomeRoot(
											this.adaptor
													.create(
															TEXT,
															(TRANSITIVE15 != null ? TRANSITIVE15
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
	// /Users/luigi/Documents/workspace/Parsers_OWL_API_2/src/OPPLLintCombined.g:104:1:
	// statement : ( variableDefinitions )? query ( actions )? -> ^(
	// OPPL_STATEMENT ( variableDefinitions )? query ( actions )? ) ;
	public final OPPLLintCombinedParser.statement_return statement()
			throws RecognitionException {
		OPPLLintCombinedParser.statement_return retval = new OPPLLintCombinedParser.statement_return();
		retval.start = this.input.LT(1);
		OPPLSyntaxTree root_0 = null;
		OPPLLintCombined_OPPLParser.variableDefinitions_return variableDefinitions16 = null;
		OPPLLintCombined_OPPLParser.query_return query17 = null;
		OPPLLintCombined_OPPLParser.actions_return actions18 = null;
		RewriteRuleSubtreeStream stream_query = new RewriteRuleSubtreeStream(
				this.adaptor, "rule query");
		RewriteRuleSubtreeStream stream_variableDefinitions = new RewriteRuleSubtreeStream(
				this.adaptor, "rule variableDefinitions");
		RewriteRuleSubtreeStream stream_actions = new RewriteRuleSubtreeStream(
				this.adaptor, "rule actions");
		try {
			// /Users/luigi/Documents/workspace/Parsers_OWL_API_2/src/OPPLLintCombined.g:105:3:
			// ( ( variableDefinitions )? query ( actions )? -> ^(
			// OPPL_STATEMENT ( variableDefinitions )? query ( actions )? ) )
			// /Users/luigi/Documents/workspace/Parsers_OWL_API_2/src/OPPLLintCombined.g:106:5:
			// ( variableDefinitions )? query ( actions )?
			{
				// /Users/luigi/Documents/workspace/Parsers_OWL_API_2/src/OPPLLintCombined.g:106:5:
				// ( variableDefinitions )?
				int alt3 = 2;
				int LA3_0 = this.input.LA(1);
				if (LA3_0 == VARIABLE_NAME) {
					alt3 = 1;
				}
				switch (alt3) {
				case 1:
					// /Users/luigi/Documents/workspace/Parsers_OWL_API_2/src/OPPLLintCombined.g:106:5:
					// variableDefinitions
				{
					this.pushFollow(FOLLOW_variableDefinitions_in_statement365);
					variableDefinitions16 = this.variableDefinitions();
					this.state._fsp--;
					if (this.state.failed) {
						return retval;
					}
					if (this.state.backtracking == 0) {
						stream_variableDefinitions.add(variableDefinitions16
								.getTree());
					}
				}
					break;
				}
				this.pushFollow(FOLLOW_query_in_statement368);
				query17 = this.query();
				this.state._fsp--;
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_query.add(query17.getTree());
				}
				// /Users/luigi/Documents/workspace/Parsers_OWL_API_2/src/OPPLLintCombined.g:106:32:
				// ( actions )?
				int alt4 = 2;
				int LA4_0 = this.input.LA(1);
				if (LA4_0 == BEGIN) {
					alt4 = 1;
				}
				switch (alt4) {
				case 1:
					// /Users/luigi/Documents/workspace/Parsers_OWL_API_2/src/OPPLLintCombined.g:106:32:
					// actions
				{
					this.pushFollow(FOLLOW_actions_in_statement370);
					actions18 = this.actions();
					this.state._fsp--;
					if (this.state.failed) {
						return retval;
					}
					if (this.state.backtracking == 0) {
						stream_actions.add(actions18.getTree());
					}
				}
					break;
				}
				// AST REWRITE
				// elements: query, variableDefinitions, actions
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
					// 106:41: -> ^( OPPL_STATEMENT ( variableDefinitions )?
					// query ( actions )? )
					{
						// /Users/luigi/Documents/workspace/Parsers_OWL_API_2/src/OPPLLintCombined.g:106:44:
						// ^( OPPL_STATEMENT ( variableDefinitions )? query (
						// actions )? )
						{
							OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor
									.nil();
							root_1 = (OPPLSyntaxTree) this.adaptor.becomeRoot(
									this.adaptor.create(OPPL_STATEMENT,
											"OPPL_STATEMENT"), root_1);
							// /Users/luigi/Documents/workspace/Parsers_OWL_API_2/src/OPPLLintCombined.g:106:61:
							// ( variableDefinitions )?
							if (stream_variableDefinitions.hasNext()) {
								this.adaptor.addChild(root_1,
										stream_variableDefinitions.nextTree());
							}
							stream_variableDefinitions.reset();
							this.adaptor.addChild(root_1, stream_query
									.nextTree());
							// /Users/luigi/Documents/workspace/Parsers_OWL_API_2/src/OPPLLintCombined.g:106:88:
							// ( actions )?
							if (stream_actions.hasNext()) {
								this.adaptor.addChild(root_1, stream_actions
										.nextTree());
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
	public static class returnClause_return extends ParserRuleReturnScope {
		OPPLSyntaxTree tree;

		@Override
		public Object getTree() {
			return this.tree;
		}
	};

	// $ANTLR start "returnClause"
	// /Users/luigi/Documents/workspace/Parsers_OWL_API_2/src/OPPLLintCombined.g:111:1:
	// returnClause : RETURN returnValue -> ^( RETURN returnValue ) ;
	public final OPPLLintCombinedParser.returnClause_return returnClause()
			throws RecognitionException {
		OPPLLintCombinedParser.returnClause_return retval = new OPPLLintCombinedParser.returnClause_return();
		retval.start = this.input.LT(1);
		OPPLSyntaxTree root_0 = null;
		Token RETURN19 = null;
		OPPLLintCombinedParser.returnValue_return returnValue20 = null;
		OPPLSyntaxTree RETURN19_tree = null;
		RewriteRuleTokenStream stream_RETURN = new RewriteRuleTokenStream(
				this.adaptor, "token RETURN");
		RewriteRuleSubtreeStream stream_returnValue = new RewriteRuleSubtreeStream(
				this.adaptor, "rule returnValue");
		try {
			// /Users/luigi/Documents/workspace/Parsers_OWL_API_2/src/OPPLLintCombined.g:112:3:
			// ( RETURN returnValue -> ^( RETURN returnValue ) )
			// /Users/luigi/Documents/workspace/Parsers_OWL_API_2/src/OPPLLintCombined.g:113:5:
			// RETURN returnValue
			{
				RETURN19 = (Token) this.match(this.input, RETURN,
						FOLLOW_RETURN_in_returnClause406);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_RETURN.add(RETURN19);
				}
				this.pushFollow(FOLLOW_returnValue_in_returnClause408);
				returnValue20 = this.returnValue();
				this.state._fsp--;
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_returnValue.add(returnValue20.getTree());
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
							this.adaptor, "rule retval",
							retval != null ? retval.tree : null);
					root_0 = (OPPLSyntaxTree) this.adaptor.nil();
					// 113:25: -> ^( RETURN returnValue )
					{
						// /Users/luigi/Documents/workspace/Parsers_OWL_API_2/src/OPPLLintCombined.g:113:27:
						// ^( RETURN returnValue )
						{
							OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor
									.nil();
							root_1 = (OPPLSyntaxTree) this.adaptor.becomeRoot(
									stream_RETURN.nextNode(), root_1);
							this.adaptor.addChild(root_1, stream_returnValue
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

	// $ANTLR end "returnClause"
	public static class returnValue_return extends ParserRuleReturnScope {
		OPPLSyntaxTree tree;

		@Override
		public Object getTree() {
			return this.tree;
		}
	};

	// $ANTLR start "returnValue"
	// /Users/luigi/Documents/workspace/Parsers_OWL_API_2/src/OPPLLintCombined.g:116:1:
	// returnValue : VARIABLE_NAME -> VARIABLE_NAME ;
	public final OPPLLintCombinedParser.returnValue_return returnValue()
			throws RecognitionException {
		OPPLLintCombinedParser.returnValue_return retval = new OPPLLintCombinedParser.returnValue_return();
		retval.start = this.input.LT(1);
		OPPLSyntaxTree root_0 = null;
		Token VARIABLE_NAME21 = null;
		OPPLSyntaxTree VARIABLE_NAME21_tree = null;
		RewriteRuleTokenStream stream_VARIABLE_NAME = new RewriteRuleTokenStream(
				this.adaptor, "token VARIABLE_NAME");
		try {
			// /Users/luigi/Documents/workspace/Parsers_OWL_API_2/src/OPPLLintCombined.g:117:3:
			// ( VARIABLE_NAME -> VARIABLE_NAME )
			// /Users/luigi/Documents/workspace/Parsers_OWL_API_2/src/OPPLLintCombined.g:118:7:
			// VARIABLE_NAME
			{
				VARIABLE_NAME21 = (Token) this.match(this.input, VARIABLE_NAME,
						FOLLOW_VARIABLE_NAME_in_returnValue437);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_VARIABLE_NAME.add(VARIABLE_NAME21);
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
					// 118:21: -> VARIABLE_NAME
					{
						this.adaptor.addChild(root_0, stream_VARIABLE_NAME
								.nextNode());
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

	// $ANTLR end "returnValue"
	public static class description_return extends ParserRuleReturnScope {
		OPPLSyntaxTree tree;

		@Override
		public Object getTree() {
			return this.tree;
		}
	};

	// $ANTLR start "description"
	// /Users/luigi/Documents/workspace/Parsers_OWL_API_2/src/OPPLLintCombined.g:121:1:
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
			// /Users/luigi/Documents/workspace/Parsers_OWL_API_2/src/OPPLLintCombined.g:126:3:
			// ( (a= . )+ -> ^( DESCRIPTION[builder.toString()] ( $a)+ ) )
			// /Users/luigi/Documents/workspace/Parsers_OWL_API_2/src/OPPLLintCombined.g:127:5:
			// (a= . )+
			{
				// /Users/luigi/Documents/workspace/Parsers_OWL_API_2/src/OPPLLintCombined.g:127:5:
				// (a= . )+
				int cnt5 = 0;
				loop5: do {
					int alt5 = 2;
					int LA5_0 = this.input.LA(1);
					if (LA5_0 >= COMPOSITION && LA5_0 <= SUBPROPERTY_OF) {
						alt5 = 1;
					}
					switch (alt5) {
					case 1:
						// /Users/luigi/Documents/workspace/Parsers_OWL_API_2/src/OPPLLintCombined.g:127:6:
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
						if (cnt5 >= 1) {
							break loop5;
						}
						if (this.state.backtracking > 0) {
							this.state.failed = true;
							return retval;
						}
						EarlyExitException eee = new EarlyExitException(5,
								this.input);
						throw eee;
					}
					cnt5++;
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
					RewriteRuleTokenStream stream_a = new RewriteRuleTokenStream(
							this.adaptor, "token a", a);
					RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(
							this.adaptor, "rule retval",
							retval != null ? retval.tree : null);
					root_0 = (OPPLSyntaxTree) this.adaptor.nil();
					// 132:9: -> ^( DESCRIPTION[builder.toString()] ( $a)+ )
					{
						// /Users/luigi/Documents/workspace/Parsers_OWL_API_2/src/OPPLLintCombined.g:132:11:
						// ^( DESCRIPTION[builder.toString()] ( $a)+ )
						{
							OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor
									.nil();
							root_1 = (OPPLSyntaxTree) this.adaptor.becomeRoot(
									this.adaptor.create(DESCRIPTION, builder
											.toString()), root_1);
							if (!stream_a.hasNext()) {
								throw new RewriteEarlyExitException();
							}
							while (stream_a.hasNext()) {
								this.adaptor.addChild(root_1, stream_a
										.nextNode());
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

	// $ANTLR end "description"
	// Delegated rules
	public OPPLLintCombined_OPPLParser_MOWLParser.unaryCharacteristic_return unaryCharacteristic()
			throws RecognitionException {
		return this.gMOWLParser.unaryCharacteristic();
	}

	public OPPLLintCombined_OPPLParser.stringExpression_return stringExpression()
			throws RecognitionException {
		return this.gOPPLParser.stringExpression();
	}

	public OPPLLintCombined_OPPLParser_MOWLParser.assertionAxiom_return assertionAxiom()
			throws RecognitionException {
		return this.gMOWLParser.assertionAxiom();
	}

	public OPPLLintCombined_OPPLParser.atomic_return atomic()
			throws RecognitionException {
		return this.gOPPLParser.atomic();
	}

	public OPPLLintCombined_OPPLParser.variableDefinitions_return variableDefinitions()
			throws RecognitionException {
		return this.gOPPLParser.variableDefinitions();
	}

	public OPPLLintCombined_OPPLParser.variableDefinition_return variableDefinition()
			throws RecognitionException {
		return this.gOPPLParser.variableDefinition();
	}

	public OPPLLintCombined_OPPLParser.opplFunction_return opplFunction()
			throws RecognitionException {
		return this.gOPPLParser.opplFunction();
	}

	public OPPLLintCombined_OPPLParser_MOWLParser.constant_return constant()
			throws RecognitionException {
		return this.gMOWLParser.constant();
	}

	public OPPLLintCombined_OPPLParser.query_return query()
			throws RecognitionException {
		return this.gOPPLParser.query();
	}

	public OPPLLintCombined_OPPLParser_MOWLParser.cardinalityRestriction_return cardinalityRestriction()
			throws RecognitionException {
		return this.gMOWLParser.cardinalityRestriction();
	}

	public OPPLLintCombined_OPPLParser.regexp_return regexp()
			throws RecognitionException {
		return this.gOPPLParser.regexp();
	}

	public OPPLLintCombined_OPPLParser_MOWLParser.expression_return expression()
			throws RecognitionException {
		return this.gMOWLParser.expression();
	}

	public OPPLLintCombined_OPPLParser.variableScope_return variableScope()
			throws RecognitionException {
		return this.gOPPLParser.variableScope();
	}

	public OPPLLintCombined_OPPLParser_MOWLParser.axiom_return axiom()
			throws RecognitionException {
		return this.gMOWLParser.axiom();
	}

	public OPPLLintCombined_OPPLParser.constraint_return constraint()
			throws RecognitionException {
		return this.gOPPLParser.constraint();
	}

	public OPPLLintCombined_OPPLParser_MOWLParser.unaryAxiom_return unaryAxiom()
			throws RecognitionException {
		return this.gMOWLParser.unaryAxiom();
	}

	public OPPLLintCombined_OPPLParser_MOWLParser.propertyExpression_return propertyExpression()
			throws RecognitionException {
		return this.gMOWLParser.propertyExpression();
	}

	public OPPLLintCombined_OPPLParser_MOWLParser.value_return value()
			throws RecognitionException {
		return this.gMOWLParser.value();
	}

	public OPPLLintCombined_OPPLParser.selectClause_return selectClause()
			throws RecognitionException {
		return this.gOPPLParser.selectClause();
	}

	public OPPLLintCombined_OPPLParser.stringOperation_return stringOperation()
			throws RecognitionException {
		return this.gOPPLParser.stringOperation();
	}

	public OPPLLintCombined_OPPLParser_MOWLParser.conjunction_return conjunction()
			throws RecognitionException {
		return this.gMOWLParser.conjunction();
	}

	public OPPLLintCombined_OPPLParser_MOWLParser.oneOf_return oneOf()
			throws RecognitionException {
		return this.gMOWLParser.oneOf();
	}

	public OPPLLintCombined_OPPLParser_MOWLParser.restrictionKind_return restrictionKind()
			throws RecognitionException {
		return this.gMOWLParser.restrictionKind();
	}

	public OPPLLintCombined_OPPLParser_MOWLParser.binaryAxiom_return binaryAxiom()
			throws RecognitionException {
		return this.gMOWLParser.binaryAxiom();
	}

	public OPPLLintCombined_OPPLParser_MOWLParser.complexPropertyExpression_return complexPropertyExpression()
			throws RecognitionException {
		return this.gMOWLParser.complexPropertyExpression();
	}

	public OPPLLintCombined_OPPLParser_MOWLParser.valueRestriction_return valueRestriction()
			throws RecognitionException {
		return this.gMOWLParser.valueRestriction();
	}

	public OPPLLintCombined_OPPLParser.action_return action()
			throws RecognitionException {
		return this.gOPPLParser.action();
	}

	public OPPLLintCombined_OPPLParser.actions_return actions()
			throws RecognitionException {
		return this.gOPPLParser.actions();
	}

	public OPPLLintCombined_OPPLParser_MOWLParser.unary_return unary()
			throws RecognitionException {
		return this.gMOWLParser.unary();
	}

	public OPPLLintCombined_OPPLParser.createIdentifier_return createIdentifier()
			throws RecognitionException {
		return this.gOPPLParser.createIdentifier();
	}

	public OPPLLintCombined_OPPLParser.variableAttributeReference_return variableAttributeReference()
			throws RecognitionException {
		return this.gOPPLParser.variableAttributeReference();
	}

	public OPPLLintCombined_OPPLParser.attributeSelector_return attributeSelector()
			throws RecognitionException {
		return this.gOPPLParser.attributeSelector();
	}

	public OPPLLintCombined_OPPLParser_MOWLParser.qualifiedRestriction_return qualifiedRestriction()
			throws RecognitionException {
		return this.gMOWLParser.qualifiedRestriction();
	}

	public static final BitSet FOLLOW_text_in_lint119 = new BitSet(new long[] {
			0x0000000000000000L, 0x0000000000000000L, 0x0000000000000000L,
			0x0000000000000000L, 0x0000000000000000L, 0x0000000000000000L,
			0x0000004000000000L });
	public static final BitSet FOLLOW_SEMICOLON_in_lint121 = new BitSet(
			new long[] { 0x0000000000000000L, 0x0000000000000800L,
					0x0000000000000000L, 0x0000000000000000L,
					0x0000000000000000L, 0x0000000000000000L,
					0x0000000000000000L, 0x0000000000010000L });
	public static final BitSet FOLLOW_statement_in_lint124 = new BitSet(
			new long[] { 0x0000000000000000L, 0x0000000000000000L,
					0x0000000000000000L, 0x0000000000000000L,
					0x0000000000000000L, 0x0000000000000000L,
					0x0000000080000000L });
	public static final BitSet FOLLOW_returnClause_in_lint126 = new BitSet(
			new long[] { 0x0000000000000000L, 0x0000000000000000L,
					0x0000000000000000L, 0x0000000000000000L,
					0x0000000000000000L, 0x0000000000000000L,
					0x0000004000000000L });
	public static final BitSet FOLLOW_SEMICOLON_in_lint129 = new BitSet(
			new long[] { 0x0000100FE0000000L, 0x0000000000000000L,
					0x0000000000000000L, 0x0000000000000000L,
					0x0000000000000000L, 0x0000000000000000L,
					0x0000000000000000L, 0x0000000000010000L });
	public static final BitSet FOLLOW_text_in_lint135 = new BitSet(new long[] {
			0x0000000000000000L, 0x0000000000000000L, 0x0000000000000000L,
			0x0000000000000000L, 0x0000000000000000L, 0x0000000000000000L,
			0x0000004000000000L });
	public static final BitSet FOLLOW_SEMICOLON_in_lint137 = new BitSet(
			new long[] { 0xFFFFFFFFFFFFFFF0L, 0xFFFFFFFFFFFFFFFFL,
					0xFFFFFFFFFFFFFFFFL, 0xFFFFFFFFFFFFFFFFL,
					0xFFFFFFFFFFFFFFFFL, 0xFFFFFFFFFFFFFFFFL,
					0xFFFFFFFFFFFFFFFFL, 0xFFFFFFFFFFFFFFFFL,
					0xFFFFFFFFFFFFFFFFL, 0x0000000000000FFFL });
	public static final BitSet FOLLOW_description_in_lint139 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_textBit_in_text186 = new BitSet(
			new long[] { 0x0000100FE0000002L, 0x0000000000000000L,
					0x0000000000000000L, 0x0000000000000000L,
					0x0000000000000000L, 0x0000000000000000L,
					0x0000000000000000L, 0x0000000000010000L });
	public static final BitSet FOLLOW_IDENTIFIER_in_textBit216 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_VARIABLE_NAME_in_textBit229 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_FUNCTIONAL_in_textBit243 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_INVERSE_FUNCTIONAL_in_textBit260 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_SYMMETRIC_in_textBit276 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_ANTI_SYMMETRIC_in_textBit292 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_REFLEXIVE_in_textBit308 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_IRREFLEXIVE_in_textBit324 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_TRANSITIVE_in_textBit341 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_variableDefinitions_in_statement365 = new BitSet(
			new long[] { 0x0000000000000000L, 0x0000000000000800L,
					0x0000000000000000L, 0x0000000000000000L,
					0x0000000000000000L, 0x0000000000000000L,
					0x0000000000000000L, 0x0000000000010000L });
	public static final BitSet FOLLOW_query_in_statement368 = new BitSet(
			new long[] { 0x0000000000000002L, 0x0000000000080000L });
	public static final BitSet FOLLOW_actions_in_statement370 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_RETURN_in_returnClause406 = new BitSet(
			new long[] { 0x0000000000000000L, 0x0000000000000000L,
					0x0000000000000000L, 0x0000000000000000L,
					0x0000000000000000L, 0x0000000000000000L,
					0x0000000000000000L, 0x0000000000010000L });
	public static final BitSet FOLLOW_returnValue_in_returnClause408 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_VARIABLE_NAME_in_returnValue437 = new BitSet(
			new long[] { 0x0000000000000002L });
}