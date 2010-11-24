// $ANTLR 3.2 Sep 23, 2009 12:02:23 /Users/luigi/Documents/workspace/Parsers/src/OPPLPatternScript.g 2010-11-24 13:02:18
package org.coode.parsers.oppl.patterns;

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

public class OPPLPatternScriptParser extends Parser {
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
			"IRI", "ANNOTATION_ASSERTION", "IRI_ATTRIBUTE_NAME", "ESCLAMATION_MARK",
			"CREATE_IDENTIFIER", "PLAIN_IDENTIFIER", "MATCH", "ATTRIBUTE_SELECTOR", "VALUES",
			"RENDERING", "GROUPS", "STRING_OPERATION", "DOLLAR", "RETURN", "THIS_CLASS",
			"ARGUMENTS", "OPPL_PATTERN", "PATTERN_REFERENCE", "SEMICOLON", "VARIABLE_NAME",
			"REGEXP_CONSTRAINT", "FAIL", "NAF_CONSTRAINT", "LESS_THAN", "LESS_THAN_EQUAL",
			"GREATER_THAN", "GREATER_THAN_EQUAL", "DATA_RANGE", "569", "570", "571", "572", "573",
			"574", "575", "576", "577", "578", "579", "580", "581", "582", "583", "584", "585",
			"586", "587", "588", "589", "590", "591", "592", "593", "594" };
	public static final int COMMA = 37;
	public static final int GREATER_THAN = 510;
	public static final int ASSERTED = 76;
	public static final int VARIABLE_DEFINITIONS = 102;
	public static final int REGEXP_CONSTRAINT = 465;
	public static final int END = 84;
	public static final int HYPHEN = 465;
	public static final int DIFFERENT_FROM = 24;
	public static final int LESS_THAN = 508;
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
	public static final int PLAIN_IDENTIFIER = 152;
	public static final int AND = 10;
	public static final int EXPRESSION = 69;
	public static final int CONSTANT = 70;
	public static final int VALUE_RESTRICTION = 63;
	public static final int ONE_OF = 65;
	public static final int SUBPROPERTY_OF = 105;
	public static final int THIS_CLASS = 416;
	public static final int SELECT = 75;
	public static final int CARDINALITY_RESTRICTION = 64;
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
	public static final int ARGUMENTS = 417;
	public static final int DATA_RANGE = 568;
	public static final int CLOSED_PARENTHESYS = 8;
	public static final int PROPERTY_CHAIN = 57;
	public static final int CREATE_INTERSECTION = 81;
	public static final int EQUIVALENT_TO_AXIOM = 49;
	public static final int OPEN_SQUARE_BRACKET = 85;
	public static final int NAF_CONSTRAINT = 467;
	public static final int SYMMETRIC = 30;
	public static final int DOLLAR = 400;
	public static final int DISJOINT_WITH = 26;
	public static final int VARIABLE_TYPE = 89;
	public static final int DISJUNCTION = 55;
	public static final int GROUPS = 356;
	public static final int NEGATED_EXPRESSION = 58;
	public static final int EQUAL = 73;
	public static final int SEMICOLON = 422;
	public static final int PATTERN_REFERENCE = 421;
	public static final int DIFFERENT_FROM_AXIOM = 53;
	public static final int GREATER_THAN_EQUAL = 511;
	public static final int ACTIONS = 101;
	public static final int EQUIVALENT_TO = 22;
	public static final int DOMAIN = 27;
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
	public static final int WHERE = 71;
	public static final int CREATE = 80;
	public static final int VARIABLE_SCOPE = 104;
	public static final int OPEN_CURLY_BRACES = 6;
	public static final int CLOSED_SQUARE_BRACKET = 86;
	public static final int INSTANCE_OF = 38;
	public static final int VALUES = 354;
	public static final int QUERY = 103;
	public static final int SOME_RESTRICTION = 61;
	public static final int IRI = 110;
	public static final int LESS_THAN_EQUAL = 509;
	public static final int VALUE = 18;
	public static final int RENDERING = 355;
	public static final int INVERSE_FUNCTIONAL = 35;
	public static final int ATTRIBUTE_SELECTOR = 283;
	public static final int PLAIN_CLAUSE = 93;
	public static final int OR = 11;
	public static final int INTEGER = 42;
	public static final int INVERSE = 19;
	public static final int HAS_KEY = 109;
	public static final int DISJOINT_WITH_AXIOM = 50;
	public static final int SUPER_CLASS_OF = 87;
	public static final int OPPL_FUNCTION = 100;
	public static final int DIGIT = 41;
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
	public static final int OPPL_PATTERN = 419;
	public static final int WHITESPACE = 9;
	public static final int IN = 74;
	public static final int SUPER_PROPERTY_OF = 88;
	public static final int INEQUALITY_CONSTRAINT = 94;
	public static final int SOME = 13;
	public static final int RETURN = 415;
	public static final int EOF = -1;
	public static final int CREATE_IDENTIFIER = 151;
	public static final int ANTI_SYMMETRIC = 31;
	public static final int Tokens = 47;
	public static final int CLOSED_CURLY_BRACES = 7;
	public static final int IRI_ATTRIBUTE_NAME = 112;
	public static final int REFLEXIVE = 32;
	public static final int NOT = 12;
	public static final int STRING_OPERATION = 394;
	public static final int OPEN_PARENTHESYS = 5;
	public static final int VARIABLE_NAME = 464;
	public static final int IRREFLEXIVE = 33;
	// delegates
	public OPPLPatternScript_OPPLParser_MOWLParser gMOWLParser;
	public OPPLPatternScript_OPPLParser gOPPLParser;

	// delegators
	public OPPLPatternScriptParser(TokenStream input) {
		this(input, new RecognizerSharedState());
	}

	public OPPLPatternScriptParser(TokenStream input, RecognizerSharedState state) {
		super(input, state);
		this.gOPPLParser = new OPPLPatternScript_OPPLParser(input, state, this);
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
		return OPPLPatternScriptParser.tokenNames;
	}

	@Override
	public String getGrammarFileName() {
		return "/Users/luigi/Documents/workspace/Parsers/src/OPPLPatternScript.g";
	}

	private ErrorListener errorListener;

	public OPPLPatternScriptParser(TokenStream input, ErrorListener errorListener) {
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

	public static class pattern_return extends ParserRuleReturnScope {
		OPPLSyntaxTree tree;

		@Override
		public Object getTree() {
			return this.tree;
		}
	};

	// $ANTLR start "pattern"
	// /Users/luigi/Documents/workspace/Parsers/src/OPPLPatternScript.g:71:1:
	// pattern : statement ( rendering )? ( SEMICOLON returnClause )? -> ^(
	// OPPL_PATTERN statement ( rendering )? ( returnClause )? ) ;
	public final OPPLPatternScriptParser.pattern_return pattern() throws RecognitionException {
		OPPLPatternScriptParser.pattern_return retval = new OPPLPatternScriptParser.pattern_return();
		retval.start = this.input.LT(1);
		OPPLSyntaxTree root_0 = null;
		Token SEMICOLON3 = null;
		OPPLPatternScriptParser.statement_return statement1 = null;
		OPPLPatternScriptParser.rendering_return rendering2 = null;
		OPPLPatternScriptParser.returnClause_return returnClause4 = null;
		OPPLSyntaxTree SEMICOLON3_tree = null;
		RewriteRuleTokenStream stream_SEMICOLON = new RewriteRuleTokenStream(this.adaptor,
				"token SEMICOLON");
		RewriteRuleSubtreeStream stream_statement = new RewriteRuleSubtreeStream(this.adaptor,
				"rule statement");
		RewriteRuleSubtreeStream stream_rendering = new RewriteRuleSubtreeStream(this.adaptor,
				"rule rendering");
		RewriteRuleSubtreeStream stream_returnClause = new RewriteRuleSubtreeStream(this.adaptor,
				"rule returnClause");
		try {
			// /Users/luigi/Documents/workspace/Parsers/src/OPPLPatternScript.g:72:3:
			// ( statement ( rendering )? ( SEMICOLON returnClause )? -> ^(
			// OPPL_PATTERN statement ( rendering )? ( returnClause )? ) )
			// /Users/luigi/Documents/workspace/Parsers/src/OPPLPatternScript.g:73:5:
			// statement ( rendering )? ( SEMICOLON returnClause )?
			{
				this.pushFollow(FOLLOW_statement_in_pattern120);
				statement1 = this.statement();
				this.state._fsp--;
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_statement.add(statement1.getTree());
				}
				// /Users/luigi/Documents/workspace/Parsers/src/OPPLPatternScript.g:73:16:
				// ( rendering )?
				int alt1 = 2;
				int LA1_0 = this.input.LA(1);
				if (LA1_0 >= IDENTIFIER && LA1_0 <= ENTITY_REFERENCE || LA1_0 == THIS_CLASS
						|| LA1_0 >= VARIABLE_NAME && LA1_0 <= REGEXP_CONSTRAINT) {
					alt1 = 1;
				}
				switch (alt1) {
				case 1:
					// /Users/luigi/Documents/workspace/Parsers/src/OPPLPatternScript.g:73:16:
					// rendering
				{
					this.pushFollow(FOLLOW_rendering_in_pattern123);
					rendering2 = this.rendering();
					this.state._fsp--;
					if (this.state.failed) {
						return retval;
					}
					if (this.state.backtracking == 0) {
						stream_rendering.add(rendering2.getTree());
					}
				}
					break;
				}
				// /Users/luigi/Documents/workspace/Parsers/src/OPPLPatternScript.g:73:29:
				// ( SEMICOLON returnClause )?
				int alt2 = 2;
				int LA2_0 = this.input.LA(1);
				if (LA2_0 == SEMICOLON) {
					alt2 = 1;
				}
				switch (alt2) {
				case 1:
					// /Users/luigi/Documents/workspace/Parsers/src/OPPLPatternScript.g:73:30:
					// SEMICOLON returnClause
				{
					SEMICOLON3 = (Token) this.match(
							this.input,
							SEMICOLON,
							FOLLOW_SEMICOLON_in_pattern129);
					if (this.state.failed) {
						return retval;
					}
					if (this.state.backtracking == 0) {
						stream_SEMICOLON.add(SEMICOLON3);
					}
					this.pushFollow(FOLLOW_returnClause_in_pattern131);
					returnClause4 = this.returnClause();
					this.state._fsp--;
					if (this.state.failed) {
						return retval;
					}
					if (this.state.backtracking == 0) {
						stream_returnClause.add(returnClause4.getTree());
					}
				}
					break;
				}
				// AST REWRITE
				// elements: returnClause, statement, rendering
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
					// 73:56: -> ^( OPPL_PATTERN statement ( rendering )? (
					// returnClause )? )
					{
						// /Users/luigi/Documents/workspace/Parsers/src/OPPLPatternScript.g:73:59:
						// ^( OPPL_PATTERN statement ( rendering )? (
						// returnClause )? )
						{
							OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor.nil();
							root_1 = (OPPLSyntaxTree) this.adaptor.becomeRoot(
									this.adaptor.create(OPPL_PATTERN, "OPPL_PATTERN"),
									root_1);
							this.adaptor.addChild(root_1, stream_statement.nextTree());
							// /Users/luigi/Documents/workspace/Parsers/src/OPPLPatternScript.g:73:84:
							// ( rendering )?
							if (stream_rendering.hasNext()) {
								this.adaptor.addChild(root_1, stream_rendering.nextTree());
							}
							stream_rendering.reset();
							// /Users/luigi/Documents/workspace/Parsers/src/OPPLPatternScript.g:73:95:
							// ( returnClause )?
							if (stream_returnClause.hasNext()) {
								this.adaptor.addChild(root_1, stream_returnClause.nextTree());
							}
							stream_returnClause.reset();
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

	// $ANTLR end "pattern"
	public static class statement_return extends ParserRuleReturnScope {
		OPPLSyntaxTree tree;

		@Override
		public Object getTree() {
			return this.tree;
		}
	};

	// $ANTLR start "statement"
	// /Users/luigi/Documents/workspace/Parsers/src/OPPLPatternScript.g:76:1:
	// statement : variableDefinitions actions -> ^( OPPL_STATEMENT
	// variableDefinitions actions ) ;
	public final OPPLPatternScriptParser.statement_return statement() throws RecognitionException {
		OPPLPatternScriptParser.statement_return retval = new OPPLPatternScriptParser.statement_return();
		retval.start = this.input.LT(1);
		OPPLSyntaxTree root_0 = null;
		OPPLPatternScript_OPPLParser.variableDefinitions_return variableDefinitions5 = null;
		OPPLPatternScript_OPPLParser.actions_return actions6 = null;
		RewriteRuleSubtreeStream stream_actions = new RewriteRuleSubtreeStream(this.adaptor,
				"rule actions");
		RewriteRuleSubtreeStream stream_variableDefinitions = new RewriteRuleSubtreeStream(
				this.adaptor, "rule variableDefinitions");
		try {
			// /Users/luigi/Documents/workspace/Parsers/src/OPPLPatternScript.g:77:3:
			// ( variableDefinitions actions -> ^( OPPL_STATEMENT
			// variableDefinitions actions ) )
			// /Users/luigi/Documents/workspace/Parsers/src/OPPLPatternScript.g:78:5:
			// variableDefinitions actions
			{
				this.pushFollow(FOLLOW_variableDefinitions_in_statement166);
				variableDefinitions5 = this.variableDefinitions();
				this.state._fsp--;
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_variableDefinitions.add(variableDefinitions5.getTree());
				}
				this.pushFollow(FOLLOW_actions_in_statement169);
				actions6 = this.actions();
				this.state._fsp--;
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_actions.add(actions6.getTree());
				}
				// AST REWRITE
				// elements: variableDefinitions, actions
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
					// 78:34: -> ^( OPPL_STATEMENT variableDefinitions actions )
					{
						// /Users/luigi/Documents/workspace/Parsers/src/OPPLPatternScript.g:78:37:
						// ^( OPPL_STATEMENT variableDefinitions actions )
						{
							OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor.nil();
							root_1 = (OPPLSyntaxTree) this.adaptor.becomeRoot(
									this.adaptor.create(OPPL_STATEMENT, "OPPL_STATEMENT"),
									root_1);
							this.adaptor.addChild(root_1, stream_variableDefinitions.nextTree());
							this.adaptor.addChild(root_1, stream_actions.nextTree());
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
	// /Users/luigi/Documents/workspace/Parsers/src/OPPLPatternScript.g:81:1:
	// returnClause : ( RETURN VARIABLE_NAME -> ^( RETURN ^(
	// IDENTIFIER[$VARIABLE_NAME] ) ) | RETURN THIS_CLASS -> ^( RETURN ^(
	// THIS_CLASS ) ) );
	public final OPPLPatternScriptParser.returnClause_return returnClause()
			throws RecognitionException {
		OPPLPatternScriptParser.returnClause_return retval = new OPPLPatternScriptParser.returnClause_return();
		retval.start = this.input.LT(1);
		OPPLSyntaxTree root_0 = null;
		Token RETURN7 = null;
		Token VARIABLE_NAME8 = null;
		Token RETURN9 = null;
		Token THIS_CLASS10 = null;
		OPPLSyntaxTree RETURN7_tree = null;
		OPPLSyntaxTree VARIABLE_NAME8_tree = null;
		OPPLSyntaxTree RETURN9_tree = null;
		OPPLSyntaxTree THIS_CLASS10_tree = null;
		RewriteRuleTokenStream stream_RETURN = new RewriteRuleTokenStream(this.adaptor,
				"token RETURN");
		RewriteRuleTokenStream stream_THIS_CLASS = new RewriteRuleTokenStream(this.adaptor,
				"token THIS_CLASS");
		RewriteRuleTokenStream stream_VARIABLE_NAME = new RewriteRuleTokenStream(this.adaptor,
				"token VARIABLE_NAME");
		try {
			// /Users/luigi/Documents/workspace/Parsers/src/OPPLPatternScript.g:82:3:
			// ( RETURN VARIABLE_NAME -> ^( RETURN ^( IDENTIFIER[$VARIABLE_NAME]
			// ) ) | RETURN THIS_CLASS -> ^( RETURN ^( THIS_CLASS ) ) )
			int alt3 = 2;
			int LA3_0 = this.input.LA(1);
			if (LA3_0 == RETURN) {
				int LA3_1 = this.input.LA(2);
				if (LA3_1 == VARIABLE_NAME) {
					alt3 = 1;
				} else if (LA3_1 == THIS_CLASS) {
					alt3 = 2;
				} else {
					if (this.state.backtracking > 0) {
						this.state.failed = true;
						return retval;
					}
					NoViableAltException nvae = new NoViableAltException("", 3, 1, this.input);
					throw nvae;
				}
			} else {
				if (this.state.backtracking > 0) {
					this.state.failed = true;
					return retval;
				}
				NoViableAltException nvae = new NoViableAltException("", 3, 0, this.input);
				throw nvae;
			}
			switch (alt3) {
			case 1:
				// /Users/luigi/Documents/workspace/Parsers/src/OPPLPatternScript.g:83:6:
				// RETURN VARIABLE_NAME
			{
				RETURN7 = (Token) this.match(this.input, RETURN, FOLLOW_RETURN_in_returnClause199);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_RETURN.add(RETURN7);
				}
				VARIABLE_NAME8 = (Token) this.match(
						this.input,
						VARIABLE_NAME,
						FOLLOW_VARIABLE_NAME_in_returnClause201);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_VARIABLE_NAME.add(VARIABLE_NAME8);
				}
				// AST REWRITE
				// elements: RETURN
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
					// 83:28: -> ^( RETURN ^( IDENTIFIER[$VARIABLE_NAME] ) )
					{
						// /Users/luigi/Documents/workspace/Parsers/src/OPPLPatternScript.g:83:30:
						// ^( RETURN ^( IDENTIFIER[$VARIABLE_NAME] ) )
						{
							OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor.nil();
							root_1 = (OPPLSyntaxTree) this.adaptor.becomeRoot(
									stream_RETURN.nextNode(),
									root_1);
							// /Users/luigi/Documents/workspace/Parsers/src/OPPLPatternScript.g:83:39:
							// ^( IDENTIFIER[$VARIABLE_NAME] )
							{
								OPPLSyntaxTree root_2 = (OPPLSyntaxTree) this.adaptor.nil();
								root_2 = (OPPLSyntaxTree) this.adaptor.becomeRoot(
										this.adaptor.create(IDENTIFIER, VARIABLE_NAME8),
										root_2);
								this.adaptor.addChild(root_1, root_2);
							}
							this.adaptor.addChild(root_0, root_1);
						}
					}
					retval.tree = root_0;
				}
			}
				break;
			case 2:
				// /Users/luigi/Documents/workspace/Parsers/src/OPPLPatternScript.g:84:7:
				// RETURN THIS_CLASS
			{
				RETURN9 = (Token) this.match(this.input, RETURN, FOLLOW_RETURN_in_returnClause220);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_RETURN.add(RETURN9);
				}
				THIS_CLASS10 = (Token) this.match(
						this.input,
						THIS_CLASS,
						FOLLOW_THIS_CLASS_in_returnClause222);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_THIS_CLASS.add(THIS_CLASS10);
				}
				// AST REWRITE
				// elements: RETURN, THIS_CLASS
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
					// 84:26: -> ^( RETURN ^( THIS_CLASS ) )
					{
						// /Users/luigi/Documents/workspace/Parsers/src/OPPLPatternScript.g:84:28:
						// ^( RETURN ^( THIS_CLASS ) )
						{
							OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor.nil();
							root_1 = (OPPLSyntaxTree) this.adaptor.becomeRoot(
									stream_RETURN.nextNode(),
									root_1);
							// /Users/luigi/Documents/workspace/Parsers/src/OPPLPatternScript.g:84:37:
							// ^( THIS_CLASS )
							{
								OPPLSyntaxTree root_2 = (OPPLSyntaxTree) this.adaptor.nil();
								root_2 = (OPPLSyntaxTree) this.adaptor.becomeRoot(
										stream_THIS_CLASS.nextNode(),
										root_2);
								this.adaptor.addChild(root_1, root_2);
							}
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

	// $ANTLR end "returnClause"
	public static class rendering_return extends ParserRuleReturnScope {
		OPPLSyntaxTree tree;

		@Override
		public Object getTree() {
			return this.tree;
		}
	};

	// $ANTLR start "rendering"
	// /Users/luigi/Documents/workspace/Parsers/src/OPPLPatternScript.g:89:1:
	// rendering : ( renderingPart )+ -> ^( RENDERING[builder.toString()] (
	// renderingPart )+ ) ;
	public final OPPLPatternScriptParser.rendering_return rendering() throws RecognitionException {
		OPPLPatternScriptParser.rendering_return retval = new OPPLPatternScriptParser.rendering_return();
		retval.start = this.input.LT(1);
		OPPLSyntaxTree root_0 = null;
		OPPLPatternScriptParser.renderingPart_return renderingPart11 = null;
		RewriteRuleSubtreeStream stream_renderingPart = new RewriteRuleSubtreeStream(this.adaptor,
				"rule renderingPart");
		StringBuilder builder = new StringBuilder();
		try {
			// /Users/luigi/Documents/workspace/Parsers/src/OPPLPatternScript.g:94:3:
			// ( ( renderingPart )+ -> ^( RENDERING[builder.toString()] (
			// renderingPart )+ ) )
			// /Users/luigi/Documents/workspace/Parsers/src/OPPLPatternScript.g:95:5:
			// ( renderingPart )+
			{
				// /Users/luigi/Documents/workspace/Parsers/src/OPPLPatternScript.g:95:5:
				// ( renderingPart )+
				int cnt4 = 0;
				loop4: do {
					int alt4 = 2;
					int LA4_0 = this.input.LA(1);
					if (LA4_0 >= IDENTIFIER && LA4_0 <= ENTITY_REFERENCE || LA4_0 == THIS_CLASS
							|| LA4_0 >= VARIABLE_NAME && LA4_0 <= REGEXP_CONSTRAINT) {
						alt4 = 1;
					}
					switch (alt4) {
					case 1:
						// /Users/luigi/Documents/workspace/Parsers/src/OPPLPatternScript.g:95:6:
						// renderingPart
					{
						this.pushFollow(FOLLOW_renderingPart_in_rendering260);
						renderingPart11 = this.renderingPart();
						this.state._fsp--;
						if (this.state.failed) {
							return retval;
						}
						if (this.state.backtracking == 0) {
							stream_renderingPart.add(renderingPart11.getTree());
						}
						if (this.state.backtracking == 0) {
							builder.append((renderingPart11 != null ? this.input.toString(
									renderingPart11.start,
									renderingPart11.stop) : null));
							builder.append(' ');
						}
					}
						break;
					default:
						if (cnt4 >= 1) {
							break loop4;
						}
						if (this.state.backtracking > 0) {
							this.state.failed = true;
							return retval;
						}
						EarlyExitException eee = new EarlyExitException(4, this.input);
						throw eee;
					}
					cnt4++;
				} while (true);
				// AST REWRITE
				// elements: renderingPart
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
					// 99:7: -> ^( RENDERING[builder.toString()] ( renderingPart
					// )+ )
					{
						// /Users/luigi/Documents/workspace/Parsers/src/OPPLPatternScript.g:99:9:
						// ^( RENDERING[builder.toString()] ( renderingPart )+ )
						{
							OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor.nil();
							root_1 = (OPPLSyntaxTree) this.adaptor.becomeRoot(
									this.adaptor.create(RENDERING, builder.toString()),
									root_1);
							if (!stream_renderingPart.hasNext()) {
								throw new RewriteEarlyExitException();
							}
							while (stream_renderingPart.hasNext()) {
								this.adaptor.addChild(root_1, stream_renderingPart.nextTree());
							}
							stream_renderingPart.reset();
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

	// $ANTLR end "rendering"
	public static class renderingPart_return extends ParserRuleReturnScope {
		OPPLSyntaxTree tree;

		@Override
		public Object getTree() {
			return this.tree;
		}
	};

	// $ANTLR start "renderingPart"
	// /Users/luigi/Documents/workspace/Parsers/src/OPPLPatternScript.g:102:1:
	// renderingPart : ( THIS_CLASS -> ^( IDENTIFIER[$THIS_CLASS] THIS_CLASS ) |
	// IDENTIFIER -> ^( IDENTIFIER ) | ENTITY_REFERENCE -> ^( ENTITY_REFERENCE )
	// | VARIABLE_NAME -> ^( IDENTIFIER[$VARIABLE_NAME] ) | HYPHEN -> ^( HYPHEN
	// ) );
	public final OPPLPatternScriptParser.renderingPart_return renderingPart()
			throws RecognitionException {
		OPPLPatternScriptParser.renderingPart_return retval = new OPPLPatternScriptParser.renderingPart_return();
		retval.start = this.input.LT(1);
		OPPLSyntaxTree root_0 = null;
		Token THIS_CLASS12 = null;
		Token IDENTIFIER13 = null;
		Token ENTITY_REFERENCE14 = null;
		Token VARIABLE_NAME15 = null;
		Token HYPHEN16 = null;
		OPPLSyntaxTree THIS_CLASS12_tree = null;
		OPPLSyntaxTree IDENTIFIER13_tree = null;
		OPPLSyntaxTree ENTITY_REFERENCE14_tree = null;
		OPPLSyntaxTree VARIABLE_NAME15_tree = null;
		OPPLSyntaxTree HYPHEN16_tree = null;
		RewriteRuleTokenStream stream_REGEXP_CONSTRAINT = new RewriteRuleTokenStream(this.adaptor,
				"token REGEXP_CONSTRAINT");
		RewriteRuleTokenStream stream_IDENTIFIER = new RewriteRuleTokenStream(this.adaptor,
				"token IDENTIFIER");
		RewriteRuleTokenStream stream_ENTITY_REFERENCE = new RewriteRuleTokenStream(this.adaptor,
				"token ENTITY_REFERENCE");
		RewriteRuleTokenStream stream_VARIABLE_NAME = new RewriteRuleTokenStream(this.adaptor,
				"token VARIABLE_NAME");
		RewriteRuleTokenStream stream_THIS_CLASS = new RewriteRuleTokenStream(this.adaptor,
				"token THIS_CLASS");
		try {
			// /Users/luigi/Documents/workspace/Parsers/src/OPPLPatternScript.g:104:2:
			// ( THIS_CLASS -> ^( IDENTIFIER[$THIS_CLASS] THIS_CLASS ) |
			// IDENTIFIER -> ^( IDENTIFIER ) | ENTITY_REFERENCE -> ^(
			// ENTITY_REFERENCE ) | VARIABLE_NAME -> ^(
			// IDENTIFIER[$VARIABLE_NAME] ) | HYPHEN -> ^( HYPHEN ) )
			int alt5 = 5;
			switch (this.input.LA(1)) {
			case THIS_CLASS: {
				alt5 = 1;
			}
				break;
			case IDENTIFIER: {
				alt5 = 2;
			}
				break;
			case ENTITY_REFERENCE: {
				alt5 = 3;
			}
				break;
			case VARIABLE_NAME: {
				alt5 = 4;
			}
				break;
			case REGEXP_CONSTRAINT: {
				alt5 = 5;
			}
				break;
			default:
				if (this.state.backtracking > 0) {
					this.state.failed = true;
					return retval;
				}
				NoViableAltException nvae = new NoViableAltException("", 5, 0, this.input);
				throw nvae;
			}
			switch (alt5) {
			case 1:
				// /Users/luigi/Documents/workspace/Parsers/src/OPPLPatternScript.g:105:7:
				// THIS_CLASS
			{
				THIS_CLASS12 = (Token) this.match(
						this.input,
						THIS_CLASS,
						FOLLOW_THIS_CLASS_in_renderingPart301);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_THIS_CLASS.add(THIS_CLASS12);
				}
				// AST REWRITE
				// elements: THIS_CLASS
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
					// 105:18: -> ^( IDENTIFIER[$THIS_CLASS] THIS_CLASS )
					{
						// /Users/luigi/Documents/workspace/Parsers/src/OPPLPatternScript.g:105:21:
						// ^( IDENTIFIER[$THIS_CLASS] THIS_CLASS )
						{
							OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor.nil();
							root_1 = (OPPLSyntaxTree) this.adaptor.becomeRoot(
									this.adaptor.create(IDENTIFIER, THIS_CLASS12),
									root_1);
							this.adaptor.addChild(root_1, stream_THIS_CLASS.nextNode());
							this.adaptor.addChild(root_0, root_1);
						}
					}
					retval.tree = root_0;
				}
			}
				break;
			case 2:
				// /Users/luigi/Documents/workspace/Parsers/src/OPPLPatternScript.g:106:7:
				// IDENTIFIER
			{
				IDENTIFIER13 = (Token) this.match(
						this.input,
						IDENTIFIER,
						FOLLOW_IDENTIFIER_in_renderingPart318);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_IDENTIFIER.add(IDENTIFIER13);
				}
				// AST REWRITE
				// elements: IDENTIFIER
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
					// 106:18: -> ^( IDENTIFIER )
					{
						// /Users/luigi/Documents/workspace/Parsers/src/OPPLPatternScript.g:106:21:
						// ^( IDENTIFIER )
						{
							OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor.nil();
							root_1 = (OPPLSyntaxTree) this.adaptor.becomeRoot(
									stream_IDENTIFIER.nextNode(),
									root_1);
							this.adaptor.addChild(root_0, root_1);
						}
					}
					retval.tree = root_0;
				}
			}
				break;
			case 3:
				// /Users/luigi/Documents/workspace/Parsers/src/OPPLPatternScript.g:107:7:
				// ENTITY_REFERENCE
			{
				ENTITY_REFERENCE14 = (Token) this.match(
						this.input,
						ENTITY_REFERENCE,
						FOLLOW_ENTITY_REFERENCE_in_renderingPart333);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_ENTITY_REFERENCE.add(ENTITY_REFERENCE14);
				}
				// AST REWRITE
				// elements: ENTITY_REFERENCE
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
					// 107:24: -> ^( ENTITY_REFERENCE )
					{
						// /Users/luigi/Documents/workspace/Parsers/src/OPPLPatternScript.g:107:27:
						// ^( ENTITY_REFERENCE )
						{
							OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor.nil();
							root_1 = (OPPLSyntaxTree) this.adaptor.becomeRoot(
									stream_ENTITY_REFERENCE.nextNode(),
									root_1);
							this.adaptor.addChild(root_0, root_1);
						}
					}
					retval.tree = root_0;
				}
			}
				break;
			case 4:
				// /Users/luigi/Documents/workspace/Parsers/src/OPPLPatternScript.g:108:7:
				// VARIABLE_NAME
			{
				VARIABLE_NAME15 = (Token) this.match(
						this.input,
						VARIABLE_NAME,
						FOLLOW_VARIABLE_NAME_in_renderingPart347);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_VARIABLE_NAME.add(VARIABLE_NAME15);
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
					// 108:21: -> ^( IDENTIFIER[$VARIABLE_NAME] )
					{
						// /Users/luigi/Documents/workspace/Parsers/src/OPPLPatternScript.g:108:24:
						// ^( IDENTIFIER[$VARIABLE_NAME] )
						{
							OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor.nil();
							root_1 = (OPPLSyntaxTree) this.adaptor.becomeRoot(
									this.adaptor.create(IDENTIFIER, VARIABLE_NAME15),
									root_1);
							this.adaptor.addChild(root_0, root_1);
						}
					}
					retval.tree = root_0;
				}
			}
				break;
			case 5:
				// /Users/luigi/Documents/workspace/Parsers/src/OPPLPatternScript.g:109:7:
				// HYPHEN
			{
				HYPHEN16 = (Token) this.match(
						this.input,
						REGEXP_CONSTRAINT,
						FOLLOW_REGEXP_CONSTRAINT_in_renderingPart367);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_REGEXP_CONSTRAINT.add(HYPHEN16);
				}
				// AST REWRITE
				// elements: REGEXP_CONSTRAINT
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
					// 109:14: -> ^( HYPHEN )
					{
						// /Users/luigi/Documents/workspace/Parsers/src/OPPLPatternScript.g:109:17:
						// ^( HYPHEN )
						{
							OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor.nil();
							root_1 = (OPPLSyntaxTree) this.adaptor.becomeRoot(
									stream_REGEXP_CONSTRAINT.nextNode(),
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

	// $ANTLR end "renderingPart"
	public static class atomic_return extends ParserRuleReturnScope {
		OPPLSyntaxTree tree;

		@Override
		public Object getTree() {
			return this.tree;
		}
	};

	// $ANTLR start "atomic"
	// /Users/luigi/Documents/workspace/Parsers/src/OPPLPatternScript.g:115:1:
	// atomic : ( THIS_CLASS -> ^( IDENTIFIER[$THIS_CLASS] THIS_CLASS ) |
	// IDENTIFIER -> ^( IDENTIFIER ) | ENTITY_REFERENCE -> ^( ENTITY_REFERENCE )
	// | VARIABLE_NAME -> ^( IDENTIFIER[$VARIABLE_NAME] ) | createIdentifier ->
	// ^( createIdentifier ) | variableAttributeReference -> ^(
	// variableAttributeReference ) | patternReference -> ^( patternReference )
	// );
	public final OPPLPatternScriptParser.atomic_return atomic() throws RecognitionException {
		OPPLPatternScriptParser.atomic_return retval = new OPPLPatternScriptParser.atomic_return();
		retval.start = this.input.LT(1);
		OPPLSyntaxTree root_0 = null;
		Token THIS_CLASS17 = null;
		Token IDENTIFIER18 = null;
		Token ENTITY_REFERENCE19 = null;
		Token VARIABLE_NAME20 = null;
		OPPLPatternScript_OPPLParser.createIdentifier_return createIdentifier21 = null;
		OPPLPatternScript_OPPLParser.variableAttributeReference_return variableAttributeReference22 = null;
		OPPLPatternScriptParser.patternReference_return patternReference23 = null;
		OPPLSyntaxTree THIS_CLASS17_tree = null;
		OPPLSyntaxTree IDENTIFIER18_tree = null;
		OPPLSyntaxTree ENTITY_REFERENCE19_tree = null;
		OPPLSyntaxTree VARIABLE_NAME20_tree = null;
		RewriteRuleTokenStream stream_IDENTIFIER = new RewriteRuleTokenStream(this.adaptor,
				"token IDENTIFIER");
		RewriteRuleTokenStream stream_ENTITY_REFERENCE = new RewriteRuleTokenStream(this.adaptor,
				"token ENTITY_REFERENCE");
		RewriteRuleTokenStream stream_VARIABLE_NAME = new RewriteRuleTokenStream(this.adaptor,
				"token VARIABLE_NAME");
		RewriteRuleTokenStream stream_THIS_CLASS = new RewriteRuleTokenStream(this.adaptor,
				"token THIS_CLASS");
		RewriteRuleSubtreeStream stream_patternReference = new RewriteRuleSubtreeStream(
				this.adaptor, "rule patternReference");
		RewriteRuleSubtreeStream stream_variableAttributeReference = new RewriteRuleSubtreeStream(
				this.adaptor, "rule variableAttributeReference");
		RewriteRuleSubtreeStream stream_createIdentifier = new RewriteRuleSubtreeStream(
				this.adaptor, "rule createIdentifier");
		try {
			// /Users/luigi/Documents/workspace/Parsers/src/OPPLPatternScript.g:116:3:
			// ( THIS_CLASS -> ^( IDENTIFIER[$THIS_CLASS] THIS_CLASS ) |
			// IDENTIFIER -> ^( IDENTIFIER ) | ENTITY_REFERENCE -> ^(
			// ENTITY_REFERENCE ) | VARIABLE_NAME -> ^(
			// IDENTIFIER[$VARIABLE_NAME] ) | createIdentifier -> ^(
			// createIdentifier ) | variableAttributeReference -> ^(
			// variableAttributeReference ) | patternReference -> ^(
			// patternReference ) )
			int alt6 = 7;
			switch (this.input.LA(1)) {
			case THIS_CLASS: {
				alt6 = 1;
			}
				break;
			case IDENTIFIER: {
				alt6 = 2;
			}
				break;
			case ENTITY_REFERENCE: {
				alt6 = 3;
			}
				break;
			case VARIABLE_NAME: {
				int LA6_4 = this.input.LA(2);
				if (LA6_4 == DOT) {
					alt6 = 6;
				} else if (LA6_4 == EOF || LA6_4 == COMPOSITION || LA6_4 >= CLOSED_CURLY_BRACES
						&& LA6_4 <= CLOSED_PARENTHESYS || LA6_4 >= AND && LA6_4 <= OR
						|| LA6_4 >= SOME && LA6_4 <= RANGE || LA6_4 >= COMMA && LA6_4 <= DBLQUOTE
						|| LA6_4 >= IDENTIFIER && LA6_4 <= ENTITY_REFERENCE || LA6_4 == WHERE
						|| LA6_4 >= BEGIN && LA6_4 <= END || LA6_4 == CLOSED_SQUARE_BRACKET
						|| LA6_4 >= HAS_KEY && LA6_4 <= IRI || LA6_4 == ESCLAMATION_MARK
						|| LA6_4 == DOLLAR || LA6_4 == THIS_CLASS || LA6_4 == VARIABLE_NAME) {
					alt6 = 4;
				} else {
					if (this.state.backtracking > 0) {
						this.state.failed = true;
						return retval;
					}
					NoViableAltException nvae = new NoViableAltException("", 6, 4, this.input);
					throw nvae;
				}
			}
				break;
			case ESCLAMATION_MARK: {
				alt6 = 5;
			}
				break;
			case DOLLAR: {
				alt6 = 7;
			}
				break;
			default:
				if (this.state.backtracking > 0) {
					this.state.failed = true;
					return retval;
				}
				NoViableAltException nvae = new NoViableAltException("", 6, 0, this.input);
				throw nvae;
			}
			switch (alt6) {
			case 1:
				// /Users/luigi/Documents/workspace/Parsers/src/OPPLPatternScript.g:117:5:
				// THIS_CLASS
			{
				THIS_CLASS17 = (Token) this.match(
						this.input,
						THIS_CLASS,
						FOLLOW_THIS_CLASS_in_atomic395);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_THIS_CLASS.add(THIS_CLASS17);
				}
				// AST REWRITE
				// elements: THIS_CLASS
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
					// 117:16: -> ^( IDENTIFIER[$THIS_CLASS] THIS_CLASS )
					{
						// /Users/luigi/Documents/workspace/Parsers/src/OPPLPatternScript.g:117:19:
						// ^( IDENTIFIER[$THIS_CLASS] THIS_CLASS )
						{
							OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor.nil();
							root_1 = (OPPLSyntaxTree) this.adaptor.becomeRoot(
									this.adaptor.create(IDENTIFIER, THIS_CLASS17),
									root_1);
							this.adaptor.addChild(root_1, stream_THIS_CLASS.nextNode());
							this.adaptor.addChild(root_0, root_1);
						}
					}
					retval.tree = root_0;
				}
			}
				break;
			case 2:
				// /Users/luigi/Documents/workspace/Parsers/src/OPPLPatternScript.g:118:4:
				// IDENTIFIER
			{
				IDENTIFIER18 = (Token) this.match(
						this.input,
						IDENTIFIER,
						FOLLOW_IDENTIFIER_in_atomic409);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_IDENTIFIER.add(IDENTIFIER18);
				}
				// AST REWRITE
				// elements: IDENTIFIER
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
					// 118:15: -> ^( IDENTIFIER )
					{
						// /Users/luigi/Documents/workspace/Parsers/src/OPPLPatternScript.g:118:18:
						// ^( IDENTIFIER )
						{
							OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor.nil();
							root_1 = (OPPLSyntaxTree) this.adaptor.becomeRoot(
									stream_IDENTIFIER.nextNode(),
									root_1);
							this.adaptor.addChild(root_0, root_1);
						}
					}
					retval.tree = root_0;
				}
			}
				break;
			case 3:
				// /Users/luigi/Documents/workspace/Parsers/src/OPPLPatternScript.g:119:7:
				// ENTITY_REFERENCE
			{
				ENTITY_REFERENCE19 = (Token) this.match(
						this.input,
						ENTITY_REFERENCE,
						FOLLOW_ENTITY_REFERENCE_in_atomic424);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_ENTITY_REFERENCE.add(ENTITY_REFERENCE19);
				}
				// AST REWRITE
				// elements: ENTITY_REFERENCE
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
					// 119:24: -> ^( ENTITY_REFERENCE )
					{
						// /Users/luigi/Documents/workspace/Parsers/src/OPPLPatternScript.g:119:27:
						// ^( ENTITY_REFERENCE )
						{
							OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor.nil();
							root_1 = (OPPLSyntaxTree) this.adaptor.becomeRoot(
									stream_ENTITY_REFERENCE.nextNode(),
									root_1);
							this.adaptor.addChild(root_0, root_1);
						}
					}
					retval.tree = root_0;
				}
			}
				break;
			case 4:
				// /Users/luigi/Documents/workspace/Parsers/src/OPPLPatternScript.g:120:7:
				// VARIABLE_NAME
			{
				VARIABLE_NAME20 = (Token) this.match(
						this.input,
						VARIABLE_NAME,
						FOLLOW_VARIABLE_NAME_in_atomic438);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_VARIABLE_NAME.add(VARIABLE_NAME20);
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
					// 120:21: -> ^( IDENTIFIER[$VARIABLE_NAME] )
					{
						// /Users/luigi/Documents/workspace/Parsers/src/OPPLPatternScript.g:120:24:
						// ^( IDENTIFIER[$VARIABLE_NAME] )
						{
							OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor.nil();
							root_1 = (OPPLSyntaxTree) this.adaptor.becomeRoot(
									this.adaptor.create(IDENTIFIER, VARIABLE_NAME20),
									root_1);
							this.adaptor.addChild(root_0, root_1);
						}
					}
					retval.tree = root_0;
				}
			}
				break;
			case 5:
				// /Users/luigi/Documents/workspace/Parsers/src/OPPLPatternScript.g:121:7:
				// createIdentifier
			{
				this.pushFollow(FOLLOW_createIdentifier_in_atomic458);
				createIdentifier21 = this.createIdentifier();
				this.state._fsp--;
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_createIdentifier.add(createIdentifier21.getTree());
				}
				// AST REWRITE
				// elements: createIdentifier
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
					// 121:24: -> ^( createIdentifier )
					{
						// /Users/luigi/Documents/workspace/Parsers/src/OPPLPatternScript.g:121:27:
						// ^( createIdentifier )
						{
							OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor.nil();
							root_1 = (OPPLSyntaxTree) this.adaptor.becomeRoot(
									stream_createIdentifier.nextNode(),
									root_1);
							this.adaptor.addChild(root_0, root_1);
						}
					}
					retval.tree = root_0;
				}
			}
				break;
			case 6:
				// /Users/luigi/Documents/workspace/Parsers/src/OPPLPatternScript.g:122:7:
				// variableAttributeReference
			{
				this.pushFollow(FOLLOW_variableAttributeReference_in_atomic472);
				variableAttributeReference22 = this.variableAttributeReference();
				this.state._fsp--;
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_variableAttributeReference.add(variableAttributeReference22.getTree());
				}
				// AST REWRITE
				// elements: variableAttributeReference
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
					// 122:34: -> ^( variableAttributeReference )
					{
						// /Users/luigi/Documents/workspace/Parsers/src/OPPLPatternScript.g:122:37:
						// ^( variableAttributeReference )
						{
							OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor.nil();
							root_1 = (OPPLSyntaxTree) this.adaptor.becomeRoot(
									stream_variableAttributeReference.nextNode(),
									root_1);
							this.adaptor.addChild(root_0, root_1);
						}
					}
					retval.tree = root_0;
				}
			}
				break;
			case 7:
				// /Users/luigi/Documents/workspace/Parsers/src/OPPLPatternScript.g:123:7:
				// patternReference
			{
				this.pushFollow(FOLLOW_patternReference_in_atomic491);
				patternReference23 = this.patternReference();
				this.state._fsp--;
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_patternReference.add(patternReference23.getTree());
				}
				// AST REWRITE
				// elements: patternReference
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
					// 123:24: -> ^( patternReference )
					{
						// /Users/luigi/Documents/workspace/Parsers/src/OPPLPatternScript.g:123:27:
						// ^( patternReference )
						{
							OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor.nil();
							root_1 = (OPPLSyntaxTree) this.adaptor.becomeRoot(
									stream_patternReference.nextNode(),
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

	// $ANTLR end "atomic"
	public static class patternReference_return extends ParserRuleReturnScope {
		OPPLSyntaxTree tree;

		@Override
		public Object getTree() {
			return this.tree;
		}
	};

	// $ANTLR start "patternReference"
	// /Users/luigi/Documents/workspace/Parsers/src/OPPLPatternScript.g:129:1:
	// patternReference : DOLLAR name= IDENTIFIER arguments -> ^(
	// IDENTIFIER[$DOLLAR.getText() + name.getText() + $arguments.argsString]
	// PATTERN_REFERENCE[name.getText()] arguments ) ;
	public final OPPLPatternScriptParser.patternReference_return patternReference()
			throws RecognitionException {
		OPPLPatternScriptParser.patternReference_return retval = new OPPLPatternScriptParser.patternReference_return();
		retval.start = this.input.LT(1);
		OPPLSyntaxTree root_0 = null;
		Token name = null;
		Token DOLLAR24 = null;
		OPPLPatternScriptParser.arguments_return arguments25 = null;
		OPPLSyntaxTree name_tree = null;
		OPPLSyntaxTree DOLLAR24_tree = null;
		RewriteRuleTokenStream stream_DOLLAR = new RewriteRuleTokenStream(this.adaptor,
				"token DOLLAR");
		RewriteRuleTokenStream stream_IDENTIFIER = new RewriteRuleTokenStream(this.adaptor,
				"token IDENTIFIER");
		RewriteRuleSubtreeStream stream_arguments = new RewriteRuleSubtreeStream(this.adaptor,
				"rule arguments");
		try {
			// /Users/luigi/Documents/workspace/Parsers/src/OPPLPatternScript.g:130:2:
			// ( DOLLAR name= IDENTIFIER arguments -> ^(
			// IDENTIFIER[$DOLLAR.getText() + name.getText() +
			// $arguments.argsString] PATTERN_REFERENCE[name.getText()]
			// arguments ) )
			// /Users/luigi/Documents/workspace/Parsers/src/OPPLPatternScript.g:131:3:
			// DOLLAR name= IDENTIFIER arguments
			{
				DOLLAR24 = (Token) this.match(
						this.input,
						DOLLAR,
						FOLLOW_DOLLAR_in_patternReference520);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_DOLLAR.add(DOLLAR24);
				}
				name = (Token) this.match(
						this.input,
						IDENTIFIER,
						FOLLOW_IDENTIFIER_in_patternReference526);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_IDENTIFIER.add(name);
				}
				this.pushFollow(FOLLOW_arguments_in_patternReference530);
				arguments25 = this.arguments();
				this.state._fsp--;
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_arguments.add(arguments25.getTree());
				}
				// AST REWRITE
				// elements: arguments, IDENTIFIER
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
					// 132:3: -> ^( IDENTIFIER[$DOLLAR.getText() +
					// name.getText() + $arguments.argsString]
					// PATTERN_REFERENCE[name.getText()] arguments )
					{
						// /Users/luigi/Documents/workspace/Parsers/src/OPPLPatternScript.g:132:6:
						// ^( IDENTIFIER[$DOLLAR.getText() + name.getText() +
						// $arguments.argsString]
						// PATTERN_REFERENCE[name.getText()] arguments )
						{
							OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor.nil();
							root_1 = (OPPLSyntaxTree) this.adaptor.becomeRoot(
									this.adaptor.create(
											IDENTIFIER,
											DOLLAR24.getText()
													+ name.getText()
													+ (arguments25 != null ? arguments25.argsString
															: null)),
									root_1);
							this.adaptor.addChild(
									root_1,
									this.adaptor.create(PATTERN_REFERENCE, name.getText()));
							this.adaptor.addChild(root_1, stream_arguments.nextTree());
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

	// $ANTLR end "patternReference"
	public static class arguments_return extends ParserRuleReturnScope {
		public String argsString;
		OPPLSyntaxTree tree;

		@Override
		public Object getTree() {
			return this.tree;
		}
	};

	// $ANTLR start "arguments"
	// /Users/luigi/Documents/workspace/Parsers/src/OPPLPatternScript.g:135:1:
	// arguments returns [String argsString] : OPEN_PARENTHESYS (a= atomic (
	// COMMA a= atomic )* )? CLOSED_PARENTHESYS -> ^( ARGUMENTS ( atomic )* ) ;
	public final OPPLPatternScriptParser.arguments_return arguments() throws RecognitionException {
		OPPLPatternScriptParser.arguments_return retval = new OPPLPatternScriptParser.arguments_return();
		retval.start = this.input.LT(1);
		OPPLSyntaxTree root_0 = null;
		Token OPEN_PARENTHESYS26 = null;
		Token COMMA27 = null;
		Token CLOSED_PARENTHESYS28 = null;
		OPPLPatternScriptParser.atomic_return a = null;
		OPPLSyntaxTree OPEN_PARENTHESYS26_tree = null;
		OPPLSyntaxTree COMMA27_tree = null;
		OPPLSyntaxTree CLOSED_PARENTHESYS28_tree = null;
		RewriteRuleTokenStream stream_COMMA = new RewriteRuleTokenStream(this.adaptor,
				"token COMMA");
		RewriteRuleTokenStream stream_CLOSED_PARENTHESYS = new RewriteRuleTokenStream(this.adaptor,
				"token CLOSED_PARENTHESYS");
		RewriteRuleTokenStream stream_OPEN_PARENTHESYS = new RewriteRuleTokenStream(this.adaptor,
				"token OPEN_PARENTHESYS");
		RewriteRuleSubtreeStream stream_atomic = new RewriteRuleSubtreeStream(this.adaptor,
				"rule atomic");
		StringBuilder builder = new StringBuilder();
		try {
			// /Users/luigi/Documents/workspace/Parsers/src/OPPLPatternScript.g:140:3:
			// ( OPEN_PARENTHESYS (a= atomic ( COMMA a= atomic )* )?
			// CLOSED_PARENTHESYS -> ^( ARGUMENTS ( atomic )* ) )
			// /Users/luigi/Documents/workspace/Parsers/src/OPPLPatternScript.g:141:6:
			// OPEN_PARENTHESYS (a= atomic ( COMMA a= atomic )* )?
			// CLOSED_PARENTHESYS
			{
				OPEN_PARENTHESYS26 = (Token) this.match(
						this.input,
						OPEN_PARENTHESYS,
						FOLLOW_OPEN_PARENTHESYS_in_arguments573);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_OPEN_PARENTHESYS.add(OPEN_PARENTHESYS26);
				}
				if (this.state.backtracking == 0) {
					builder.append(OPEN_PARENTHESYS26.getText());
				}
				// /Users/luigi/Documents/workspace/Parsers/src/OPPLPatternScript.g:145:6:
				// (a= atomic ( COMMA a= atomic )* )?
				int alt8 = 2;
				int LA8_0 = this.input.LA(1);
				if (LA8_0 >= IDENTIFIER && LA8_0 <= ENTITY_REFERENCE || LA8_0 == ESCLAMATION_MARK
						|| LA8_0 == DOLLAR || LA8_0 == THIS_CLASS || LA8_0 == VARIABLE_NAME) {
					alt8 = 1;
				}
				switch (alt8) {
				case 1:
					// /Users/luigi/Documents/workspace/Parsers/src/OPPLPatternScript.g:145:7:
					// a= atomic ( COMMA a= atomic )*
				{
					this.pushFollow(FOLLOW_atomic_in_arguments593);
					a = this.atomic();
					this.state._fsp--;
					if (this.state.failed) {
						return retval;
					}
					if (this.state.backtracking == 0) {
						stream_atomic.add(a.getTree());
					}
					if (this.state.backtracking == 0) {
						builder.append((a != null ? this.input.toString(a.start, a.stop) : null));
					}
					// /Users/luigi/Documents/workspace/Parsers/src/OPPLPatternScript.g:149:6:
					// ( COMMA a= atomic )*
					loop7: do {
						int alt7 = 2;
						int LA7_0 = this.input.LA(1);
						if (LA7_0 == COMMA) {
							alt7 = 1;
						}
						switch (alt7) {
						case 1:
							// /Users/luigi/Documents/workspace/Parsers/src/OPPLPatternScript.g:149:7:
							// COMMA a= atomic
						{
							COMMA27 = (Token) this.match(
									this.input,
									COMMA,
									FOLLOW_COMMA_in_arguments609);
							if (this.state.failed) {
								return retval;
							}
							if (this.state.backtracking == 0) {
								stream_COMMA.add(COMMA27);
							}
							this.pushFollow(FOLLOW_atomic_in_arguments615);
							a = this.atomic();
							this.state._fsp--;
							if (this.state.failed) {
								return retval;
							}
							if (this.state.backtracking == 0) {
								stream_atomic.add(a.getTree());
							}
							if (this.state.backtracking == 0) {
								builder.append((a != null ? this.input.toString(a.start, a.stop)
										: null));
							}
						}
							break;
						default:
							break loop7;
						}
					} while (true);
				}
					break;
				}
				CLOSED_PARENTHESYS28 = (Token) this.match(
						this.input,
						CLOSED_PARENTHESYS,
						FOLLOW_CLOSED_PARENTHESYS_in_arguments640);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_CLOSED_PARENTHESYS.add(CLOSED_PARENTHESYS28);
				}
				if (this.state.backtracking == 0) {
					builder.append(CLOSED_PARENTHESYS28.getText());
					retval.argsString = builder.toString();
				}
				// AST REWRITE
				// elements: atomic
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
					// 159:7: -> ^( ARGUMENTS ( atomic )* )
					{
						// /Users/luigi/Documents/workspace/Parsers/src/OPPLPatternScript.g:159:10:
						// ^( ARGUMENTS ( atomic )* )
						{
							OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor.nil();
							root_1 = (OPPLSyntaxTree) this.adaptor.becomeRoot(
									this.adaptor.create(ARGUMENTS, "ARGUMENTS"),
									root_1);
							// /Users/luigi/Documents/workspace/Parsers/src/OPPLPatternScript.g:159:22:
							// ( atomic )*
							while (stream_atomic.hasNext()) {
								this.adaptor.addChild(root_1, stream_atomic.nextTree());
							}
							stream_atomic.reset();
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

	// $ANTLR end "arguments"
	// Delegated rules
	public OPPLPatternScript_OPPLParser_MOWLParser.hasKeyAxiom_return hasKeyAxiom()
			throws RecognitionException {
		return this.gMOWLParser.hasKeyAxiom();
	}

	public OPPLPatternScript_OPPLParser.variableAttributeReference_return variableAttributeReference()
			throws RecognitionException {
		return this.gOPPLParser.variableAttributeReference();
	}

	public OPPLPatternScript_OPPLParser_MOWLParser.constant_return constant()
			throws RecognitionException {
		return this.gMOWLParser.constant();
	}

	public OPPLPatternScript_OPPLParser_MOWLParser.unaryAxiom_return unaryAxiom()
			throws RecognitionException {
		return this.gMOWLParser.unaryAxiom();
	}

	public OPPLPatternScript_OPPLParser_MOWLParser.cardinalityRestriction_return cardinalityRestriction()
			throws RecognitionException {
		return this.gMOWLParser.cardinalityRestriction();
	}

	public OPPLPatternScript_OPPLParser.action_return action() throws RecognitionException {
		return this.gOPPLParser.action();
	}

	public OPPLPatternScript_OPPLParser_MOWLParser.dataRangeFacet_return dataRangeFacet()
			throws RecognitionException {
		return this.gMOWLParser.dataRangeFacet();
	}

	public OPPLPatternScript_OPPLParser_MOWLParser.dataRange_return dataRange()
			throws RecognitionException {
		return this.gMOWLParser.dataRange();
	}

	public OPPLPatternScript_OPPLParser_MOWLParser.axiom_return axiom() throws RecognitionException {
		return this.gMOWLParser.axiom();
	}

	public OPPLPatternScript_OPPLParser.stringExpression_return stringExpression()
			throws RecognitionException {
		return this.gOPPLParser.stringExpression();
	}

	public OPPLPatternScript_OPPLParser_MOWLParser.binaryAxiom_return binaryAxiom()
			throws RecognitionException {
		return this.gMOWLParser.binaryAxiom();
	}

	public OPPLPatternScript_OPPLParser_MOWLParser.conjunction_return conjunction()
			throws RecognitionException {
		return this.gMOWLParser.conjunction();
	}

	public OPPLPatternScript_OPPLParser.attributeSelector_return attributeSelector()
			throws RecognitionException {
		return this.gOPPLParser.attributeSelector();
	}

	public OPPLPatternScript_OPPLParser_MOWLParser.assertionAxiom_return assertionAxiom()
			throws RecognitionException {
		return this.gMOWLParser.assertionAxiom();
	}

	public OPPLPatternScript_OPPLParser_MOWLParser.oneOf_return oneOf() throws RecognitionException {
		return this.gMOWLParser.oneOf();
	}

	public OPPLPatternScript_OPPLParser_MOWLParser.annotationAssertionAxiom_return annotationAssertionAxiom()
			throws RecognitionException {
		return this.gMOWLParser.annotationAssertionAxiom();
	}

	public OPPLPatternScript_OPPLParser_MOWLParser.unaryCharacteristic_return unaryCharacteristic()
			throws RecognitionException {
		return this.gMOWLParser.unaryCharacteristic();
	}

	public OPPLPatternScript_OPPLParser.actions_return actions() throws RecognitionException {
		return this.gOPPLParser.actions();
	}

	public OPPLPatternScript_OPPLParser.opplFunction_return opplFunction()
			throws RecognitionException {
		return this.gOPPLParser.opplFunction();
	}

	public OPPLPatternScript_OPPLParser.stringOperation_return stringOperation()
			throws RecognitionException {
		return this.gOPPLParser.stringOperation();
	}

	public OPPLPatternScript_OPPLParser.iri_return iri() throws RecognitionException {
		return this.gOPPLParser.iri();
	}

	public OPPLPatternScript_OPPLParser.variableDefinitions_return variableDefinitions()
			throws RecognitionException {
		return this.gOPPLParser.variableDefinitions();
	}

	public OPPLPatternScript_OPPLParser_MOWLParser.complexPropertyExpression_return complexPropertyExpression()
			throws RecognitionException {
		return this.gMOWLParser.complexPropertyExpression();
	}

	public OPPLPatternScript_OPPLParser_MOWLParser.restrictionKind_return restrictionKind()
			throws RecognitionException {
		return this.gMOWLParser.restrictionKind();
	}

	public OPPLPatternScript_OPPLParser_MOWLParser.propertyExpression_return propertyExpression()
			throws RecognitionException {
		return this.gMOWLParser.propertyExpression();
	}

	public OPPLPatternScript_OPPLParser.createIdentifier_return createIdentifier()
			throws RecognitionException {
		return this.gOPPLParser.createIdentifier();
	}

	public OPPLPatternScript_OPPLParser_MOWLParser.qualifiedRestriction_return qualifiedRestriction()
			throws RecognitionException {
		return this.gMOWLParser.qualifiedRestriction();
	}

	public OPPLPatternScript_OPPLParser.query_return query() throws RecognitionException {
		return this.gOPPLParser.query();
	}

	public OPPLPatternScript_OPPLParser_MOWLParser.value_return value() throws RecognitionException {
		return this.gMOWLParser.value();
	}

	public OPPLPatternScript_OPPLParser.selectClause_return selectClause()
			throws RecognitionException {
		return this.gOPPLParser.selectClause();
	}

	public OPPLPatternScript_OPPLParser.variableDefinition_return variableDefinition()
			throws RecognitionException {
		return this.gOPPLParser.variableDefinition();
	}

	public OPPLPatternScript_OPPLParser.variableScope_return variableScope()
			throws RecognitionException {
		return this.gOPPLParser.variableScope();
	}

	public OPPLPatternScript_OPPLParser_MOWLParser.expression_return expression()
			throws RecognitionException {
		return this.gMOWLParser.expression();
	}

	public OPPLPatternScript_OPPLParser.constraint_return constraint() throws RecognitionException {
		return this.gOPPLParser.constraint();
	}

	public OPPLPatternScript_OPPLParser_MOWLParser.unary_return unary() throws RecognitionException {
		return this.gMOWLParser.unary();
	}

	public OPPLPatternScript_OPPLParser.regexp_return regexp() throws RecognitionException {
		return this.gOPPLParser.regexp();
	}

	public OPPLPatternScript_OPPLParser_MOWLParser.valueRestriction_return valueRestriction()
			throws RecognitionException {
		return this.gMOWLParser.valueRestriction();
	}

	public static final BitSet FOLLOW_statement_in_pattern120 = new BitSet(new long[] {
			0x0000300000000002L, 0x0000000000000000L, 0x0000000000000000L, 0x0000000000000000L,
			0x0000000000000000L, 0x0000000000000000L, 0x0000004100000000L, 0x0000000000030000L });
	public static final BitSet FOLLOW_rendering_in_pattern123 = new BitSet(new long[] {
			0x0000000000000002L, 0x0000000000000000L, 0x0000000000000000L, 0x0000000000000000L,
			0x0000000000000000L, 0x0000000000000000L, 0x0000004000000000L });
	public static final BitSet FOLLOW_SEMICOLON_in_pattern129 = new BitSet(new long[] {
			0x0000000000000000L, 0x0000000000000000L, 0x0000000000000000L, 0x0000000000000000L,
			0x0000000000000000L, 0x0000000000000000L, 0x0000000080000000L });
	public static final BitSet FOLLOW_returnClause_in_pattern131 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_variableDefinitions_in_statement166 = new BitSet(new long[] {
			0x0000000000000000L, 0x0000000000080000L });
	public static final BitSet FOLLOW_actions_in_statement169 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_RETURN_in_returnClause199 = new BitSet(new long[] {
			0x0000000000000000L, 0x0000000000000000L, 0x0000000000000000L, 0x0000000000000000L,
			0x0000000000000000L, 0x0000000000000000L, 0x0000000000000000L, 0x0000000000010000L });
	public static final BitSet FOLLOW_VARIABLE_NAME_in_returnClause201 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_RETURN_in_returnClause220 = new BitSet(new long[] {
			0x0000000000000000L, 0x0000000000000000L, 0x0000000000000000L, 0x0000000000000000L,
			0x0000000000000000L, 0x0000000000000000L, 0x0000000100000000L });
	public static final BitSet FOLLOW_THIS_CLASS_in_returnClause222 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_renderingPart_in_rendering260 = new BitSet(new long[] {
			0x0000300000000002L, 0x0000000000000000L, 0x0000000000000000L, 0x0000000000000000L,
			0x0000000000000000L, 0x0000000000000000L, 0x0000000100000000L, 0x0000000000030000L });
	public static final BitSet FOLLOW_THIS_CLASS_in_renderingPart301 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_IDENTIFIER_in_renderingPart318 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_ENTITY_REFERENCE_in_renderingPart333 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_VARIABLE_NAME_in_renderingPart347 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_REGEXP_CONSTRAINT_in_renderingPart367 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_THIS_CLASS_in_atomic395 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_IDENTIFIER_in_atomic409 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_ENTITY_REFERENCE_in_atomic424 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_VARIABLE_NAME_in_atomic438 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_createIdentifier_in_atomic458 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_variableAttributeReference_in_atomic472 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_patternReference_in_atomic491 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_DOLLAR_in_patternReference520 = new BitSet(
			new long[] { 0x0000100000000000L });
	public static final BitSet FOLLOW_IDENTIFIER_in_patternReference526 = new BitSet(
			new long[] { 0x0000000000000020L });
	public static final BitSet FOLLOW_arguments_in_patternReference530 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_OPEN_PARENTHESYS_in_arguments573 = new BitSet(new long[] {
			0x0000300000000100L, 0x0000000000000000L, 0x0000000000200000L, 0x0000000000000000L,
			0x0000000000000000L, 0x0000000000000000L, 0x0000000100010000L, 0x0000000000010000L });
	public static final BitSet FOLLOW_atomic_in_arguments593 = new BitSet(
			new long[] { 0x0000002000000100L });
	public static final BitSet FOLLOW_COMMA_in_arguments609 = new BitSet(new long[] {
			0x0000300000000000L, 0x0000000000000000L, 0x0000000000200000L, 0x0000000000000000L,
			0x0000000000000000L, 0x0000000000000000L, 0x0000000100010000L, 0x0000000000010000L });
	public static final BitSet FOLLOW_atomic_in_arguments615 = new BitSet(
			new long[] { 0x0000002000000100L });
	public static final BitSet FOLLOW_CLOSED_PARENTHESYS_in_arguments640 = new BitSet(
			new long[] { 0x0000000000000002L });
}