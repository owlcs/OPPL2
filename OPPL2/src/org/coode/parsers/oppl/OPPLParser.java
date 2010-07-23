package org.coode.parsers.oppl;

// $ANTLR 3.2 Sep 23, 2009 12:02:23 /Users/luigi/Documents/workspace/PARSERS/src/OPPLParser.g 2010-07-23 22:26:04
import org.antlr.runtime.BitSet;
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
import org.antlr.runtime.tree.RewriteRuleSubtreeStream;
import org.antlr.runtime.tree.RewriteRuleTokenStream;
import org.antlr.runtime.tree.TreeAdaptor;

public class OPPLParser extends Parser {
	public static final String[] tokenNames = new String[] { "<invalid>",
			"<EOR>", "<DOWN>", "<UP>", "SUB_CLASS_AXIOM",
			"EQUIVALENT_TO_AXIOM", "DISJOINT_WITH_AXIOM", "SUB_PROPERTY_AXIOM",
			"SAME_AS_AXIOM", "DIFFERENT_FROM_AXIOM", "UNARY_AXIOM",
			"DISJUNCTION", "CONJUNCTION", "PROPERTY_CHAIN",
			"NEGATED_EXPRESSION", "NEGATED_ASSERTION", "INVERSE_PROPERTY",
			"SOME_RESTRICTION", "ALL_RESTRICTION", "VALUE_RESTRICTION",
			"CARDINALITY_RESTRICTION", "ONE_OF", "TYPE_ASSERTION",
			"ROLE_ASSERTION", "INVERSE_OBJECT_PROPERTY_EXPRESSION",
			"EXPRESSION", "CONSTANT", "INSTANCE_OF", "TYPES", "NOT",
			"SUBCLASS_OF", "EQUIVALENT_TO", "DISJOINT_WITH", "SUB_PROPERTY_OF",
			"INVERSE_OF", "SAME_AS", "DIFFERENT_FROM", "DOMAIN", "RANGE",
			"FUNCTIONAL", "INVERSE_FUNCTIONAL", "SYMMETRIC", "ANTI_SYMMETRIC",
			"REFLEXIVE", "IRREFLEXIVE", "TRANSITIVE", "OR", "OPEN_PARENTHESYS",
			"CLOSED_PARENTHESYS", "AND", "INVERSE", "COMPOSITION",
			"IDENTIFIER", "ENTITY_REFERENCE", "SOME", "ONLY", "INTEGER", "MIN",
			"MAX", "EXACTLY", "OPEN_CURLY_BRACES", "COMMA",
			"CLOSED_CURLY_BRACES", "VALUE", "DBLQUOTE", "POW",
			"ASSERTED_CLAUSE", "PLAIN_CLAUSE", "INEQUALITY_CONSTRAINT",
			"IN_SET_CONSTRAINT", "NAF_CONSTRAINT", "REGEXP_CONSTRAINT",
			"INPUT_VARIABLE_DEFINITION", "GENERATED_VARIABLE_DEFINITION",
			"CREATE_OPPL_FUNCTION", "VARIABLE_ATTRIBUTE", "OPPL_FUNCTION",
			"ACTIONS", "VARIABLE_DEFINITIONS", "QUERY", "VARIABLE_SCOPE",
			"ATTRIBUTE_SELECTOR", "STRING_OPERATION", "VARIABLE_NAME", "COLON",
			"VARIABLE_TYPE", "EQUAL", "MATCH", "OPEN_SQUARE_BRACKET",
			"SUBPROPERTY_OF", "SUPER_CLASS_OF", "SUPER_PROPERTY_OF",
			"CLOSED_SQUARE_BRACKET", "SELECT", "WHERE", "ASSERTED",
			"NOT_EQUAL", "IN", "FAIL", "BEGIN", "END", "ADD", "REMOVE",
			"CREATE", "CREATE_INTERSECTION", "CREATE_DISJUNCTION", "PLUS",
			"ESCLAMATION_MARK", "DOT", "VALUES", "RENDERING", "GROUPS" };
	public static final int VALUE_RESTRICTION = 19;
	public static final int REMOVE = 102;
	public static final int TYPES = 28;
	public static final int SAME_AS_AXIOM = 8;
	public static final int INVERSE_OF = 34;
	public static final int NOT = 29;
	public static final int SUBCLASS_OF = 30;
	public static final int EOF = -1;
	public static final int ESCLAMATION_MARK = 107;
	public static final int ACTIONS = 77;
	public static final int CREATE = 103;
	public static final int POW = 65;
	public static final int NOT_EQUAL = 96;
	public static final int INPUT_VARIABLE_DEFINITION = 72;
	public static final int INVERSE_OBJECT_PROPERTY_EXPRESSION = 24;
	public static final int INSTANCE_OF = 27;
	public static final int BEGIN = 99;
	public static final int INEQUALITY_CONSTRAINT = 68;
	public static final int VARIABLE_SCOPE = 80;
	public static final int SYMMETRIC = 41;
	public static final int CARDINALITY_RESTRICTION = 20;
	public static final int SELECT = 93;
	public static final int ROLE_ASSERTION = 23;
	public static final int DIFFERENT_FROM_AXIOM = 9;
	public static final int CREATE_OPPL_FUNCTION = 74;
	public static final int ANTI_SYMMETRIC = 42;
	public static final int TRANSITIVE = 45;
	public static final int ALL_RESTRICTION = 18;
	public static final int CONJUNCTION = 12;
	public static final int NEGATED_ASSERTION = 15;
	public static final int IN_SET_CONSTRAINT = 69;
	public static final int MATCH = 87;
	public static final int VALUE = 63;
	public static final int GROUPS = 111;
	public static final int FAIL = 98;
	public static final int OPEN_CURLY_BRACES = 60;
	public static final int DISJUNCTION = 11;
	public static final int INVERSE = 50;
	public static final int NAF_CONSTRAINT = 70;
	public static final int DBLQUOTE = 64;
	public static final int STRING_OPERATION = 82;
	public static final int OR = 46;
	public static final int CONSTANT = 26;
	public static final int QUERY = 79;
	public static final int ENTITY_REFERENCE = 53;
	public static final int END = 100;
	public static final int COMPOSITION = 51;
	public static final int CLOSED_SQUARE_BRACKET = 92;
	public static final int WHERE = 94;
	public static final int SAME_AS = 35;
	public static final int DISJOINT_WITH = 32;
	public static final int SUPER_PROPERTY_OF = 91;
	public static final int VARIABLE_TYPE = 85;
	public static final int CLOSED_PARENTHESYS = 48;
	public static final int ATTRIBUTE_SELECTOR = 81;
	public static final int EQUIVALENT_TO_AXIOM = 5;
	public static final int ONLY = 55;
	public static final int SUB_PROPERTY_OF = 33;
	public static final int NEGATED_EXPRESSION = 14;
	public static final int MAX = 58;
	public static final int CREATE_DISJUNCTION = 105;
	public static final int AND = 49;
	public static final int ASSERTED_CLAUSE = 66;
	public static final int INVERSE_PROPERTY = 16;
	public static final int VARIABLE_NAME = 83;
	public static final int IN = 97;
	public static final int DIFFERENT_FROM = 36;
	public static final int EQUIVALENT_TO = 31;
	public static final int UNARY_AXIOM = 10;
	public static final int COMMA = 61;
	public static final int CLOSED_CURLY_BRACES = 62;
	public static final int IDENTIFIER = 52;
	public static final int SOME = 54;
	public static final int EQUAL = 86;
	public static final int OPEN_PARENTHESYS = 47;
	public static final int REFLEXIVE = 43;
	public static final int PLUS = 106;
	public static final int DOT = 108;
	public static final int SUPER_CLASS_OF = 90;
	public static final int EXPRESSION = 25;
	public static final int SOME_RESTRICTION = 17;
	public static final int ADD = 101;
	public static final int INTEGER = 56;
	public static final int GENERATED_VARIABLE_DEFINITION = 73;
	public static final int SUB_PROPERTY_AXIOM = 7;
	public static final int EXACTLY = 59;
	public static final int OPEN_SQUARE_BRACKET = 88;
	public static final int VALUES = 109;
	public static final int REGEXP_CONSTRAINT = 71;
	public static final int RANGE = 38;
	public static final int ONE_OF = 21;
	public static final int VARIABLE_DEFINITIONS = 78;
	public static final int SUB_CLASS_AXIOM = 4;
	public static final int MIN = 57;
	public static final int PLAIN_CLAUSE = 67;
	public static final int DOMAIN = 37;
	public static final int SUBPROPERTY_OF = 89;
	public static final int OPPL_FUNCTION = 76;
	public static final int COLON = 84;
	public static final int DISJOINT_WITH_AXIOM = 6;
	public static final int CREATE_INTERSECTION = 104;
	public static final int INVERSE_FUNCTIONAL = 40;
	public static final int RENDERING = 110;
	public static final int IRREFLEXIVE = 44;
	public static final int ASSERTED = 95;
	public static final int VARIABLE_ATTRIBUTE = 75;
	public static final int FUNCTIONAL = 39;
	public static final int PROPERTY_CHAIN = 13;
	public static final int TYPE_ASSERTION = 22;
	// delegates
	public OPPLParser_MOWLParser gMOWLParser;

	// delegators
	public OPPLParser(TokenStream input) {
		this(input, new RecognizerSharedState());
	}

	public OPPLParser(TokenStream input, RecognizerSharedState state) {
		super(input, state);
		this.gMOWLParser = new OPPLParser_MOWLParser(input, state, this);
	}

	protected TreeAdaptor adaptor = new CommonTreeAdaptor();

	public void setTreeAdaptor(TreeAdaptor adaptor) {
		this.adaptor = adaptor;
		this.gMOWLParser.setTreeAdaptor(this.adaptor);
	}

	public TreeAdaptor getTreeAdaptor() {
		return this.adaptor;
	}

	@Override
	public String[] getTokenNames() {
		return OPPLParser.tokenNames;
	}

	@Override
	public String getGrammarFileName() {
		return "/Users/luigi/Documents/workspace/PARSERS/src/OPPLParser.g";
	}

	@Override
	public Object recoverFromMismatchedSet(IntStream input,
			RecognitionException e, BitSet follow) throws RecognitionException {
		throw e;
	}

	protected void mismatch(IntStream input, int ttype, BitSet follow)
			throws RecognitionException {
		throw new MismatchedTokenException(ttype, input);
	}

	public static class variableDefinitions_return extends
			ParserRuleReturnScope {
		OPPLSyntaxTree tree;

		@Override
		public Object getTree() {
			return this.tree;
		}
	};

	// $ANTLR start "variableDefinitions"
	// /Users/luigi/Documents/workspace/PARSERS/src/OPPLParser.g:45:2:
	// variableDefinitions : variableDefinition ( COMMA variableDefinition )* ->
	// ^( VARIABLE_DEFINITIONS ( variableDefinition )+ ) ;
	public final OPPLParser.variableDefinitions_return variableDefinitions()
			throws RecognitionException {
		OPPLParser.variableDefinitions_return retval = new OPPLParser.variableDefinitions_return();
		retval.start = this.input.LT(1);
		OPPLSyntaxTree root_0 = null;
		Token COMMA2 = null;
		OPPLParser.variableDefinition_return variableDefinition1 = null;
		OPPLParser.variableDefinition_return variableDefinition3 = null;
		OPPLSyntaxTree COMMA2_tree = null;
		RewriteRuleTokenStream stream_COMMA = new RewriteRuleTokenStream(
				this.adaptor, "token COMMA");
		RewriteRuleSubtreeStream stream_variableDefinition = new RewriteRuleSubtreeStream(
				this.adaptor, "rule variableDefinition");
		try {
			// /Users/luigi/Documents/workspace/PARSERS/src/OPPLParser.g:46:3: (
			// variableDefinition ( COMMA variableDefinition )* -> ^(
			// VARIABLE_DEFINITIONS ( variableDefinition )+ ) )
			// /Users/luigi/Documents/workspace/PARSERS/src/OPPLParser.g:47:5:
			// variableDefinition ( COMMA variableDefinition )*
			{
				this
						.pushFollow(FOLLOW_variableDefinition_in_variableDefinitions216);
				variableDefinition1 = this.variableDefinition();
				this.state._fsp--;
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_variableDefinition
							.add(variableDefinition1.getTree());
				}
				// /Users/luigi/Documents/workspace/PARSERS/src/OPPLParser.g:47:24:
				// ( COMMA variableDefinition )*
				loop1: do {
					int alt1 = 2;
					int LA1_0 = this.input.LA(1);
					if (LA1_0 == COMMA) {
						alt1 = 1;
					}
					switch (alt1) {
					case 1:
						// /Users/luigi/Documents/workspace/PARSERS/src/OPPLParser.g:47:25:
						// COMMA variableDefinition
					{
						COMMA2 = (Token) this.match(this.input, COMMA,
								FOLLOW_COMMA_in_variableDefinitions219);
						if (this.state.failed) {
							return retval;
						}
						if (this.state.backtracking == 0) {
							stream_COMMA.add(COMMA2);
						}
						this
								.pushFollow(FOLLOW_variableDefinition_in_variableDefinitions221);
						variableDefinition3 = this.variableDefinition();
						this.state._fsp--;
						if (this.state.failed) {
							return retval;
						}
						if (this.state.backtracking == 0) {
							stream_variableDefinition.add(variableDefinition3
									.getTree());
						}
					}
						break;
					default:
						break loop1;
					}
				} while (true);
				// AST REWRITE
				// elements: variableDefinition
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
					// 47:52: -> ^( VARIABLE_DEFINITIONS ( variableDefinition )+
					// )
					{
						// /Users/luigi/Documents/workspace/PARSERS/src/OPPLParser.g:47:55:
						// ^( VARIABLE_DEFINITIONS ( variableDefinition )+ )
						{
							OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor
									.nil();
							root_1 = (OPPLSyntaxTree) this.adaptor.becomeRoot(
									this.adaptor.create(VARIABLE_DEFINITIONS,
											"VARIABLE_DEFINITIONS"), root_1);
							if (!stream_variableDefinition.hasNext()) {
								throw new RewriteEarlyExitException();
							}
							while (stream_variableDefinition.hasNext()) {
								this.adaptor.addChild(root_1,
										stream_variableDefinition.nextTree());
							}
							stream_variableDefinition.reset();
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
		} catch (RecognitionException e) {
			throw e;
		} finally {
		}
		return retval;
	}

	// $ANTLR end "variableDefinitions"
	public static class variableDefinition_return extends ParserRuleReturnScope {
		OPPLSyntaxTree tree;

		@Override
		public Object getTree() {
			return this.tree;
		}
	};

	// $ANTLR start "variableDefinition"
	// /Users/luigi/Documents/workspace/PARSERS/src/OPPLParser.g:50:2:
	// variableDefinition : ( VARIABLE_NAME COLON VARIABLE_TYPE EQUAL
	// opplFunction -> ^( GENERATED_VARIABLE_DEFINITION VARIABLE_NAME
	// VARIABLE_TYPE ^( opplFunction ) ) | VARIABLE_NAME COLON VARIABLE_TYPE
	// EQUAL expression -> ^( GENERATED_VARIABLE_DEFINITION VARIABLE_NAME
	// VARIABLE_TYPE ^( EXPRESSION expression ) ) | VARIABLE_NAME COLON
	// VARIABLE_TYPE EQUAL MATCH OPEN_PARENTHESYS stringOperation
	// CLOSED_PARENTHESYS -> ^( GENERATED_VARIABLE_DEFINITION VARIABLE_NAME
	// VARIABLE_TYPE ^( MATCH stringOperation ) ) | VARIABLE_NAME COLON
	// VARIABLE_TYPE ( variableScope )? -> ^( INPUT_VARIABLE_DEFINITION
	// VARIABLE_NAME VARIABLE_TYPE ( variableScope )? ) );
	public final OPPLParser.variableDefinition_return variableDefinition()
			throws RecognitionException {
		OPPLParser.variableDefinition_return retval = new OPPLParser.variableDefinition_return();
		retval.start = this.input.LT(1);
		OPPLSyntaxTree root_0 = null;
		Token VARIABLE_NAME4 = null;
		Token COLON5 = null;
		Token VARIABLE_TYPE6 = null;
		Token EQUAL7 = null;
		Token VARIABLE_NAME9 = null;
		Token COLON10 = null;
		Token VARIABLE_TYPE11 = null;
		Token EQUAL12 = null;
		Token VARIABLE_NAME14 = null;
		Token COLON15 = null;
		Token VARIABLE_TYPE16 = null;
		Token EQUAL17 = null;
		Token MATCH18 = null;
		Token OPEN_PARENTHESYS19 = null;
		Token CLOSED_PARENTHESYS21 = null;
		Token VARIABLE_NAME22 = null;
		Token COLON23 = null;
		Token VARIABLE_TYPE24 = null;
		OPPLParser.opplFunction_return opplFunction8 = null;
		OPPLParser_MOWLParser.expression_return expression13 = null;
		OPPLParser.stringOperation_return stringOperation20 = null;
		OPPLParser.variableScope_return variableScope25 = null;
		OPPLSyntaxTree VARIABLE_NAME4_tree = null;
		OPPLSyntaxTree COLON5_tree = null;
		OPPLSyntaxTree VARIABLE_TYPE6_tree = null;
		OPPLSyntaxTree EQUAL7_tree = null;
		OPPLSyntaxTree VARIABLE_NAME9_tree = null;
		OPPLSyntaxTree COLON10_tree = null;
		OPPLSyntaxTree VARIABLE_TYPE11_tree = null;
		OPPLSyntaxTree EQUAL12_tree = null;
		OPPLSyntaxTree VARIABLE_NAME14_tree = null;
		OPPLSyntaxTree COLON15_tree = null;
		OPPLSyntaxTree VARIABLE_TYPE16_tree = null;
		OPPLSyntaxTree EQUAL17_tree = null;
		OPPLSyntaxTree MATCH18_tree = null;
		OPPLSyntaxTree OPEN_PARENTHESYS19_tree = null;
		OPPLSyntaxTree CLOSED_PARENTHESYS21_tree = null;
		OPPLSyntaxTree VARIABLE_NAME22_tree = null;
		OPPLSyntaxTree COLON23_tree = null;
		OPPLSyntaxTree VARIABLE_TYPE24_tree = null;
		RewriteRuleTokenStream stream_COLON = new RewriteRuleTokenStream(
				this.adaptor, "token COLON");
		RewriteRuleTokenStream stream_MATCH = new RewriteRuleTokenStream(
				this.adaptor, "token MATCH");
		RewriteRuleTokenStream stream_VARIABLE_NAME = new RewriteRuleTokenStream(
				this.adaptor, "token VARIABLE_NAME");
		RewriteRuleTokenStream stream_VARIABLE_TYPE = new RewriteRuleTokenStream(
				this.adaptor, "token VARIABLE_TYPE");
		RewriteRuleTokenStream stream_CLOSED_PARENTHESYS = new RewriteRuleTokenStream(
				this.adaptor, "token CLOSED_PARENTHESYS");
		RewriteRuleTokenStream stream_EQUAL = new RewriteRuleTokenStream(
				this.adaptor, "token EQUAL");
		RewriteRuleTokenStream stream_OPEN_PARENTHESYS = new RewriteRuleTokenStream(
				this.adaptor, "token OPEN_PARENTHESYS");
		RewriteRuleSubtreeStream stream_expression = new RewriteRuleSubtreeStream(
				this.adaptor, "rule expression");
		RewriteRuleSubtreeStream stream_variableScope = new RewriteRuleSubtreeStream(
				this.adaptor, "rule variableScope");
		RewriteRuleSubtreeStream stream_opplFunction = new RewriteRuleSubtreeStream(
				this.adaptor, "rule opplFunction");
		RewriteRuleSubtreeStream stream_stringOperation = new RewriteRuleSubtreeStream(
				this.adaptor, "rule stringOperation");
		try {
			// /Users/luigi/Documents/workspace/PARSERS/src/OPPLParser.g:51:3: (
			// VARIABLE_NAME COLON VARIABLE_TYPE EQUAL opplFunction -> ^(
			// GENERATED_VARIABLE_DEFINITION VARIABLE_NAME VARIABLE_TYPE ^(
			// opplFunction ) ) | VARIABLE_NAME COLON VARIABLE_TYPE EQUAL
			// expression -> ^( GENERATED_VARIABLE_DEFINITION VARIABLE_NAME
			// VARIABLE_TYPE ^( EXPRESSION expression ) ) | VARIABLE_NAME COLON
			// VARIABLE_TYPE EQUAL MATCH OPEN_PARENTHESYS stringOperation
			// CLOSED_PARENTHESYS -> ^( GENERATED_VARIABLE_DEFINITION
			// VARIABLE_NAME VARIABLE_TYPE ^( MATCH stringOperation ) ) |
			// VARIABLE_NAME COLON VARIABLE_TYPE ( variableScope )? -> ^(
			// INPUT_VARIABLE_DEFINITION VARIABLE_NAME VARIABLE_TYPE (
			// variableScope )? ) )
			int alt3 = 4;
			int LA3_0 = this.input.LA(1);
			if (LA3_0 == VARIABLE_NAME) {
				int LA3_1 = this.input.LA(2);
				if (LA3_1 == COLON) {
					int LA3_2 = this.input.LA(3);
					if (LA3_2 == VARIABLE_TYPE) {
						int LA3_3 = this.input.LA(4);
						if (LA3_3 == EQUAL) {
							switch (this.input.LA(5)) {
							case MATCH: {
								alt3 = 3;
							}
								break;
							case EOF:
							case NOT:
							case OPEN_PARENTHESYS:
							case INVERSE:
							case IDENTIFIER:
							case ENTITY_REFERENCE:
							case OPEN_CURLY_BRACES:
							case COMMA:
							case DBLQUOTE:
							case VARIABLE_NAME:
							case ESCLAMATION_MARK: {
								alt3 = 2;
							}
								break;
							case CREATE:
							case CREATE_INTERSECTION:
							case CREATE_DISJUNCTION: {
								alt3 = 1;
							}
								break;
							default:
								if (this.state.backtracking > 0) {
									this.state.failed = true;
									return retval;
								}
								NoViableAltException nvae = new NoViableAltException(
										"", 3, 4, this.input);
								throw nvae;
							}
						} else if (LA3_3 == EOF || LA3_3 == COMMA
								|| LA3_3 == OPEN_SQUARE_BRACKET) {
							alt3 = 4;
						} else {
							if (this.state.backtracking > 0) {
								this.state.failed = true;
								return retval;
							}
							NoViableAltException nvae = new NoViableAltException(
									"", 3, 3, this.input);
							throw nvae;
						}
					} else {
						if (this.state.backtracking > 0) {
							this.state.failed = true;
							return retval;
						}
						NoViableAltException nvae = new NoViableAltException(
								"", 3, 2, this.input);
						throw nvae;
					}
				} else {
					if (this.state.backtracking > 0) {
						this.state.failed = true;
						return retval;
					}
					NoViableAltException nvae = new NoViableAltException("", 3,
							1, this.input);
					throw nvae;
				}
			} else {
				if (this.state.backtracking > 0) {
					this.state.failed = true;
					return retval;
				}
				NoViableAltException nvae = new NoViableAltException("", 3, 0,
						this.input);
				throw nvae;
			}
			switch (alt3) {
			case 1:
				// /Users/luigi/Documents/workspace/PARSERS/src/OPPLParser.g:53:7:
				// VARIABLE_NAME COLON VARIABLE_TYPE EQUAL opplFunction
			{
				VARIABLE_NAME4 = (Token) this.match(this.input, VARIABLE_NAME,
						FOLLOW_VARIABLE_NAME_in_variableDefinition255);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_VARIABLE_NAME.add(VARIABLE_NAME4);
				}
				COLON5 = (Token) this.match(this.input, COLON,
						FOLLOW_COLON_in_variableDefinition257);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_COLON.add(COLON5);
				}
				VARIABLE_TYPE6 = (Token) this.match(this.input, VARIABLE_TYPE,
						FOLLOW_VARIABLE_TYPE_in_variableDefinition259);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_VARIABLE_TYPE.add(VARIABLE_TYPE6);
				}
				EQUAL7 = (Token) this.match(this.input, EQUAL,
						FOLLOW_EQUAL_in_variableDefinition262);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_EQUAL.add(EQUAL7);
				}
				this.pushFollow(FOLLOW_opplFunction_in_variableDefinition264);
				opplFunction8 = this.opplFunction();
				this.state._fsp--;
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_opplFunction.add(opplFunction8.getTree());
				}
				// AST REWRITE
				// elements: VARIABLE_NAME, VARIABLE_TYPE, opplFunction
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
					// 53:61: -> ^( GENERATED_VARIABLE_DEFINITION VARIABLE_NAME
					// VARIABLE_TYPE ^( opplFunction ) )
					{
						// /Users/luigi/Documents/workspace/PARSERS/src/OPPLParser.g:53:64:
						// ^( GENERATED_VARIABLE_DEFINITION VARIABLE_NAME
						// VARIABLE_TYPE ^( opplFunction ) )
						{
							OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor
									.nil();
							root_1 = (OPPLSyntaxTree) this.adaptor.becomeRoot(
									this.adaptor.create(
											GENERATED_VARIABLE_DEFINITION,
											"GENERATED_VARIABLE_DEFINITION"),
									root_1);
							this.adaptor.addChild(root_1, stream_VARIABLE_NAME
									.nextNode());
							this.adaptor.addChild(root_1, stream_VARIABLE_TYPE
									.nextNode());
							// /Users/luigi/Documents/workspace/PARSERS/src/OPPLParser.g:53:124:
							// ^( opplFunction )
							{
								OPPLSyntaxTree root_2 = (OPPLSyntaxTree) this.adaptor
										.nil();
								root_2 = (OPPLSyntaxTree) this.adaptor
										.becomeRoot(stream_opplFunction
												.nextNode(), root_2);
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
				// /Users/luigi/Documents/workspace/PARSERS/src/OPPLParser.g:54:7:
				// VARIABLE_NAME COLON VARIABLE_TYPE EQUAL expression
			{
				VARIABLE_NAME9 = (Token) this.match(this.input, VARIABLE_NAME,
						FOLLOW_VARIABLE_NAME_in_variableDefinition292);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_VARIABLE_NAME.add(VARIABLE_NAME9);
				}
				COLON10 = (Token) this.match(this.input, COLON,
						FOLLOW_COLON_in_variableDefinition294);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_COLON.add(COLON10);
				}
				VARIABLE_TYPE11 = (Token) this.match(this.input, VARIABLE_TYPE,
						FOLLOW_VARIABLE_TYPE_in_variableDefinition296);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_VARIABLE_TYPE.add(VARIABLE_TYPE11);
				}
				EQUAL12 = (Token) this.match(this.input, EQUAL,
						FOLLOW_EQUAL_in_variableDefinition299);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_EQUAL.add(EQUAL12);
				}
				this.pushFollow(FOLLOW_expression_in_variableDefinition301);
				expression13 = this.expression();
				this.state._fsp--;
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_expression.add(expression13.getTree());
				}
				// AST REWRITE
				// elements: expression, VARIABLE_TYPE, VARIABLE_NAME
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
					// 54:59: -> ^( GENERATED_VARIABLE_DEFINITION VARIABLE_NAME
					// VARIABLE_TYPE ^( EXPRESSION expression ) )
					{
						// /Users/luigi/Documents/workspace/PARSERS/src/OPPLParser.g:54:62:
						// ^( GENERATED_VARIABLE_DEFINITION VARIABLE_NAME
						// VARIABLE_TYPE ^( EXPRESSION expression ) )
						{
							OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor
									.nil();
							root_1 = (OPPLSyntaxTree) this.adaptor.becomeRoot(
									this.adaptor.create(
											GENERATED_VARIABLE_DEFINITION,
											"GENERATED_VARIABLE_DEFINITION"),
									root_1);
							this.adaptor.addChild(root_1, stream_VARIABLE_NAME
									.nextNode());
							this.adaptor.addChild(root_1, stream_VARIABLE_TYPE
									.nextNode());
							// /Users/luigi/Documents/workspace/PARSERS/src/OPPLParser.g:54:122:
							// ^( EXPRESSION expression )
							{
								OPPLSyntaxTree root_2 = (OPPLSyntaxTree) this.adaptor
										.nil();
								root_2 = (OPPLSyntaxTree) this.adaptor
										.becomeRoot(this.adaptor.create(
												EXPRESSION, "EXPRESSION"),
												root_2);
								this.adaptor.addChild(root_2, stream_expression
										.nextTree());
								this.adaptor.addChild(root_1, root_2);
							}
							this.adaptor.addChild(root_0, root_1);
						}
					}
					retval.tree = root_0;
				}
			}
				break;
			case 3:
				// /Users/luigi/Documents/workspace/PARSERS/src/OPPLParser.g:55:7:
				// VARIABLE_NAME COLON VARIABLE_TYPE EQUAL MATCH
				// OPEN_PARENTHESYS stringOperation CLOSED_PARENTHESYS
			{
				VARIABLE_NAME14 = (Token) this.match(this.input, VARIABLE_NAME,
						FOLLOW_VARIABLE_NAME_in_variableDefinition325);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_VARIABLE_NAME.add(VARIABLE_NAME14);
				}
				COLON15 = (Token) this.match(this.input, COLON,
						FOLLOW_COLON_in_variableDefinition327);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_COLON.add(COLON15);
				}
				VARIABLE_TYPE16 = (Token) this.match(this.input, VARIABLE_TYPE,
						FOLLOW_VARIABLE_TYPE_in_variableDefinition329);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_VARIABLE_TYPE.add(VARIABLE_TYPE16);
				}
				EQUAL17 = (Token) this.match(this.input, EQUAL,
						FOLLOW_EQUAL_in_variableDefinition332);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_EQUAL.add(EQUAL17);
				}
				MATCH18 = (Token) this.match(this.input, MATCH,
						FOLLOW_MATCH_in_variableDefinition334);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_MATCH.add(MATCH18);
				}
				OPEN_PARENTHESYS19 = (Token) this.match(this.input,
						OPEN_PARENTHESYS,
						FOLLOW_OPEN_PARENTHESYS_in_variableDefinition336);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_OPEN_PARENTHESYS.add(OPEN_PARENTHESYS19);
				}
				this
						.pushFollow(FOLLOW_stringOperation_in_variableDefinition338);
				stringOperation20 = this.stringOperation();
				this.state._fsp--;
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_stringOperation.add(stringOperation20.getTree());
				}
				CLOSED_PARENTHESYS21 = (Token) this.match(this.input,
						CLOSED_PARENTHESYS,
						FOLLOW_CLOSED_PARENTHESYS_in_variableDefinition340);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_CLOSED_PARENTHESYS.add(CLOSED_PARENTHESYS21);
				}
				// AST REWRITE
				// elements: MATCH, VARIABLE_TYPE, VARIABLE_NAME,
				// stringOperation
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
					// 55:106: -> ^( GENERATED_VARIABLE_DEFINITION VARIABLE_NAME
					// VARIABLE_TYPE ^( MATCH stringOperation ) )
					{
						// /Users/luigi/Documents/workspace/PARSERS/src/OPPLParser.g:55:109:
						// ^( GENERATED_VARIABLE_DEFINITION VARIABLE_NAME
						// VARIABLE_TYPE ^( MATCH stringOperation ) )
						{
							OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor
									.nil();
							root_1 = (OPPLSyntaxTree) this.adaptor.becomeRoot(
									this.adaptor.create(
											GENERATED_VARIABLE_DEFINITION,
											"GENERATED_VARIABLE_DEFINITION"),
									root_1);
							this.adaptor.addChild(root_1, stream_VARIABLE_NAME
									.nextNode());
							this.adaptor.addChild(root_1, stream_VARIABLE_TYPE
									.nextNode());
							// /Users/luigi/Documents/workspace/PARSERS/src/OPPLParser.g:55:169:
							// ^( MATCH stringOperation )
							{
								OPPLSyntaxTree root_2 = (OPPLSyntaxTree) this.adaptor
										.nil();
								root_2 = (OPPLSyntaxTree) this.adaptor
										.becomeRoot(stream_MATCH.nextNode(),
												root_2);
								this.adaptor.addChild(root_2,
										stream_stringOperation.nextTree());
								this.adaptor.addChild(root_1, root_2);
							}
							this.adaptor.addChild(root_0, root_1);
						}
					}
					retval.tree = root_0;
				}
			}
				break;
			case 4:
				// /Users/luigi/Documents/workspace/PARSERS/src/OPPLParser.g:56:7:
				// VARIABLE_NAME COLON VARIABLE_TYPE ( variableScope )?
			{
				VARIABLE_NAME22 = (Token) this.match(this.input, VARIABLE_NAME,
						FOLLOW_VARIABLE_NAME_in_variableDefinition364);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_VARIABLE_NAME.add(VARIABLE_NAME22);
				}
				COLON23 = (Token) this.match(this.input, COLON,
						FOLLOW_COLON_in_variableDefinition366);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_COLON.add(COLON23);
				}
				VARIABLE_TYPE24 = (Token) this.match(this.input, VARIABLE_TYPE,
						FOLLOW_VARIABLE_TYPE_in_variableDefinition368);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_VARIABLE_TYPE.add(VARIABLE_TYPE24);
				}
				// /Users/luigi/Documents/workspace/PARSERS/src/OPPLParser.g:56:41:
				// ( variableScope )?
				int alt2 = 2;
				int LA2_0 = this.input.LA(1);
				if (LA2_0 == OPEN_SQUARE_BRACKET) {
					alt2 = 1;
				}
				switch (alt2) {
				case 1:
					// /Users/luigi/Documents/workspace/PARSERS/src/OPPLParser.g:56:42:
					// variableScope
				{
					this
							.pushFollow(FOLLOW_variableScope_in_variableDefinition371);
					variableScope25 = this.variableScope();
					this.state._fsp--;
					if (this.state.failed) {
						return retval;
					}
					if (this.state.backtracking == 0) {
						stream_variableScope.add(variableScope25.getTree());
					}
				}
					break;
				}
				// AST REWRITE
				// elements: VARIABLE_TYPE, VARIABLE_NAME, variableScope
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
					// 56:58: -> ^( INPUT_VARIABLE_DEFINITION VARIABLE_NAME
					// VARIABLE_TYPE ( variableScope )? )
					{
						// /Users/luigi/Documents/workspace/PARSERS/src/OPPLParser.g:56:61:
						// ^( INPUT_VARIABLE_DEFINITION VARIABLE_NAME
						// VARIABLE_TYPE ( variableScope )? )
						{
							OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor
									.nil();
							root_1 = (OPPLSyntaxTree) this.adaptor.becomeRoot(
									this.adaptor.create(
											INPUT_VARIABLE_DEFINITION,
											"INPUT_VARIABLE_DEFINITION"),
									root_1);
							this.adaptor.addChild(root_1, stream_VARIABLE_NAME
									.nextNode());
							this.adaptor.addChild(root_1, stream_VARIABLE_TYPE
									.nextNode());
							// /Users/luigi/Documents/workspace/PARSERS/src/OPPLParser.g:56:117:
							// ( variableScope )?
							if (stream_variableScope.hasNext()) {
								this.adaptor.addChild(root_1,
										stream_variableScope.nextTree());
							}
							stream_variableScope.reset();
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
		} catch (RecognitionException e) {
			throw e;
		} finally {
		}
		return retval;
	}

	// $ANTLR end "variableDefinition"
	public static class variableScope_return extends ParserRuleReturnScope {
		OPPLSyntaxTree tree;

		@Override
		public Object getTree() {
			return this.tree;
		}
	};

	// $ANTLR start "variableScope"
	// /Users/luigi/Documents/workspace/PARSERS/src/OPPLParser.g:61:1:
	// variableScope : OPEN_SQUARE_BRACKET (variableScopeSpecification=
	// SUBCLASS_OF | variableScopeSpecification= SUBPROPERTY_OF |
	// variableScopeSpecification= SUPER_CLASS_OF | variableScopeSpecification=
	// SUPER_PROPERTY_OF | variableScopeSpecification= INSTANCE_OF |
	// variableScopeSpecification= TYPES ) expression CLOSED_SQUARE_BRACKET ->
	// ^( VARIABLE_SCOPE $variableScopeSpecification ^( EXPRESSION expression )
	// ) ;
	public final OPPLParser.variableScope_return variableScope()
			throws RecognitionException {
		OPPLParser.variableScope_return retval = new OPPLParser.variableScope_return();
		retval.start = this.input.LT(1);
		OPPLSyntaxTree root_0 = null;
		Token variableScopeSpecification = null;
		Token OPEN_SQUARE_BRACKET26 = null;
		Token CLOSED_SQUARE_BRACKET28 = null;
		OPPLParser_MOWLParser.expression_return expression27 = null;
		OPPLSyntaxTree variableScopeSpecification_tree = null;
		OPPLSyntaxTree OPEN_SQUARE_BRACKET26_tree = null;
		OPPLSyntaxTree CLOSED_SQUARE_BRACKET28_tree = null;
		RewriteRuleTokenStream stream_TYPES = new RewriteRuleTokenStream(
				this.adaptor, "token TYPES");
		RewriteRuleTokenStream stream_SUPER_PROPERTY_OF = new RewriteRuleTokenStream(
				this.adaptor, "token SUPER_PROPERTY_OF");
		RewriteRuleTokenStream stream_SUBCLASS_OF = new RewriteRuleTokenStream(
				this.adaptor, "token SUBCLASS_OF");
		RewriteRuleTokenStream stream_OPEN_SQUARE_BRACKET = new RewriteRuleTokenStream(
				this.adaptor, "token OPEN_SQUARE_BRACKET");
		RewriteRuleTokenStream stream_SUPER_CLASS_OF = new RewriteRuleTokenStream(
				this.adaptor, "token SUPER_CLASS_OF");
		RewriteRuleTokenStream stream_INSTANCE_OF = new RewriteRuleTokenStream(
				this.adaptor, "token INSTANCE_OF");
		RewriteRuleTokenStream stream_SUBPROPERTY_OF = new RewriteRuleTokenStream(
				this.adaptor, "token SUBPROPERTY_OF");
		RewriteRuleTokenStream stream_CLOSED_SQUARE_BRACKET = new RewriteRuleTokenStream(
				this.adaptor, "token CLOSED_SQUARE_BRACKET");
		RewriteRuleSubtreeStream stream_expression = new RewriteRuleSubtreeStream(
				this.adaptor, "rule expression");
		try {
			// /Users/luigi/Documents/workspace/PARSERS/src/OPPLParser.g:62:3: (
			// OPEN_SQUARE_BRACKET (variableScopeSpecification= SUBCLASS_OF |
			// variableScopeSpecification= SUBPROPERTY_OF |
			// variableScopeSpecification= SUPER_CLASS_OF |
			// variableScopeSpecification= SUPER_PROPERTY_OF |
			// variableScopeSpecification= INSTANCE_OF |
			// variableScopeSpecification= TYPES ) expression
			// CLOSED_SQUARE_BRACKET -> ^( VARIABLE_SCOPE
			// $variableScopeSpecification ^( EXPRESSION expression ) ) )
			// /Users/luigi/Documents/workspace/PARSERS/src/OPPLParser.g:63:5:
			// OPEN_SQUARE_BRACKET (variableScopeSpecification= SUBCLASS_OF |
			// variableScopeSpecification= SUBPROPERTY_OF |
			// variableScopeSpecification= SUPER_CLASS_OF |
			// variableScopeSpecification= SUPER_PROPERTY_OF |
			// variableScopeSpecification= INSTANCE_OF |
			// variableScopeSpecification= TYPES ) expression
			// CLOSED_SQUARE_BRACKET
			{
				OPEN_SQUARE_BRACKET26 = (Token) this.match(this.input,
						OPEN_SQUARE_BRACKET,
						FOLLOW_OPEN_SQUARE_BRACKET_in_variableScope411);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_OPEN_SQUARE_BRACKET.add(OPEN_SQUARE_BRACKET26);
				}
				// /Users/luigi/Documents/workspace/PARSERS/src/OPPLParser.g:63:25:
				// (variableScopeSpecification= SUBCLASS_OF |
				// variableScopeSpecification= SUBPROPERTY_OF |
				// variableScopeSpecification= SUPER_CLASS_OF |
				// variableScopeSpecification= SUPER_PROPERTY_OF |
				// variableScopeSpecification= INSTANCE_OF |
				// variableScopeSpecification= TYPES )
				int alt4 = 6;
				switch (this.input.LA(1)) {
				case SUBCLASS_OF: {
					alt4 = 1;
				}
					break;
				case SUBPROPERTY_OF: {
					alt4 = 2;
				}
					break;
				case SUPER_CLASS_OF: {
					alt4 = 3;
				}
					break;
				case SUPER_PROPERTY_OF: {
					alt4 = 4;
				}
					break;
				case INSTANCE_OF: {
					alt4 = 5;
				}
					break;
				case TYPES: {
					alt4 = 6;
				}
					break;
				default:
					if (this.state.backtracking > 0) {
						this.state.failed = true;
						return retval;
					}
					NoViableAltException nvae = new NoViableAltException("", 4,
							0, this.input);
					throw nvae;
				}
				switch (alt4) {
				case 1:
					// /Users/luigi/Documents/workspace/PARSERS/src/OPPLParser.g:63:26:
					// variableScopeSpecification= SUBCLASS_OF
				{
					variableScopeSpecification = (Token) this
							.match(this.input, SUBCLASS_OF,
									FOLLOW_SUBCLASS_OF_in_variableScope418);
					if (this.state.failed) {
						return retval;
					}
					if (this.state.backtracking == 0) {
						stream_SUBCLASS_OF.add(variableScopeSpecification);
					}
				}
					break;
				case 2:
					// /Users/luigi/Documents/workspace/PARSERS/src/OPPLParser.g:63:69:
					// variableScopeSpecification= SUBPROPERTY_OF
				{
					variableScopeSpecification = (Token) this.match(this.input,
							SUBPROPERTY_OF,
							FOLLOW_SUBPROPERTY_OF_in_variableScope426);
					if (this.state.failed) {
						return retval;
					}
					if (this.state.backtracking == 0) {
						stream_SUBPROPERTY_OF.add(variableScopeSpecification);
					}
				}
					break;
				case 3:
					// /Users/luigi/Documents/workspace/PARSERS/src/OPPLParser.g:63:115:
					// variableScopeSpecification= SUPER_CLASS_OF
				{
					variableScopeSpecification = (Token) this.match(this.input,
							SUPER_CLASS_OF,
							FOLLOW_SUPER_CLASS_OF_in_variableScope434);
					if (this.state.failed) {
						return retval;
					}
					if (this.state.backtracking == 0) {
						stream_SUPER_CLASS_OF.add(variableScopeSpecification);
					}
				}
					break;
				case 4:
					// /Users/luigi/Documents/workspace/PARSERS/src/OPPLParser.g:63:162:
					// variableScopeSpecification= SUPER_PROPERTY_OF
				{
					variableScopeSpecification = (Token) this.match(this.input,
							SUPER_PROPERTY_OF,
							FOLLOW_SUPER_PROPERTY_OF_in_variableScope442);
					if (this.state.failed) {
						return retval;
					}
					if (this.state.backtracking == 0) {
						stream_SUPER_PROPERTY_OF
								.add(variableScopeSpecification);
					}
				}
					break;
				case 5:
					// /Users/luigi/Documents/workspace/PARSERS/src/OPPLParser.g:63:211:
					// variableScopeSpecification= INSTANCE_OF
				{
					variableScopeSpecification = (Token) this
							.match(this.input, INSTANCE_OF,
									FOLLOW_INSTANCE_OF_in_variableScope451);
					if (this.state.failed) {
						return retval;
					}
					if (this.state.backtracking == 0) {
						stream_INSTANCE_OF.add(variableScopeSpecification);
					}
				}
					break;
				case 6:
					// /Users/luigi/Documents/workspace/PARSERS/src/OPPLParser.g:63:254:
					// variableScopeSpecification= TYPES
				{
					variableScopeSpecification = (Token) this.match(this.input,
							TYPES, FOLLOW_TYPES_in_variableScope459);
					if (this.state.failed) {
						return retval;
					}
					if (this.state.backtracking == 0) {
						stream_TYPES.add(variableScopeSpecification);
					}
				}
					break;
				}
				this.pushFollow(FOLLOW_expression_in_variableScope462);
				expression27 = this.expression();
				this.state._fsp--;
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_expression.add(expression27.getTree());
				}
				CLOSED_SQUARE_BRACKET28 = (Token) this.match(this.input,
						CLOSED_SQUARE_BRACKET,
						FOLLOW_CLOSED_SQUARE_BRACKET_in_variableScope464);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_CLOSED_SQUARE_BRACKET.add(CLOSED_SQUARE_BRACKET28);
				}
				// AST REWRITE
				// elements: expression, variableScopeSpecification
				// token labels: variableScopeSpecification
				// rule labels: retval
				// token list labels:
				// rule list labels:
				// wildcard labels:
				if (this.state.backtracking == 0) {
					retval.tree = root_0;
					RewriteRuleTokenStream stream_variableScopeSpecification = new RewriteRuleTokenStream(
							this.adaptor, "token variableScopeSpecification",
							variableScopeSpecification);
					RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(
							this.adaptor, "rule retval",
							retval != null ? retval.tree : null);
					root_0 = (OPPLSyntaxTree) this.adaptor.nil();
					// 63:323: -> ^( VARIABLE_SCOPE $variableScopeSpecification
					// ^( EXPRESSION expression ) )
					{
						// /Users/luigi/Documents/workspace/PARSERS/src/OPPLParser.g:63:326:
						// ^( VARIABLE_SCOPE $variableScopeSpecification ^(
						// EXPRESSION expression ) )
						{
							OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor
									.nil();
							root_1 = (OPPLSyntaxTree) this.adaptor.becomeRoot(
									this.adaptor.create(VARIABLE_SCOPE,
											"VARIABLE_SCOPE"), root_1);
							this.adaptor.addChild(root_1,
									stream_variableScopeSpecification
											.nextNode());
							// /Users/luigi/Documents/workspace/PARSERS/src/OPPLParser.g:63:371:
							// ^( EXPRESSION expression )
							{
								OPPLSyntaxTree root_2 = (OPPLSyntaxTree) this.adaptor
										.nil();
								root_2 = (OPPLSyntaxTree) this.adaptor
										.becomeRoot(this.adaptor.create(
												EXPRESSION, "EXPRESSION"),
												root_2);
								this.adaptor.addChild(root_2, stream_expression
										.nextTree());
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
				retval.tree = (OPPLSyntaxTree) this.adaptor
						.rulePostProcessing(root_0);
				this.adaptor.setTokenBoundaries(retval.tree, retval.start,
						retval.stop);
			}
		} catch (RecognitionException e) {
			throw e;
		} finally {
		}
		return retval;
	}

	// $ANTLR end "variableScope"
	public static class query_return extends ParserRuleReturnScope {
		OPPLSyntaxTree tree;

		@Override
		public Object getTree() {
			return this.tree;
		}
	};

	// $ANTLR start "query"
	// /Users/luigi/Documents/workspace/PARSERS/src/OPPLParser.g:68:2: query :
	// SELECT selectClause ( COMMA selectClause )* ( WHERE constraint ( COMMA
	// constraint )* )? -> ^( QUERY ( selectClause )+ ( constraint )* ) ;
	public final OPPLParser.query_return query() throws RecognitionException {
		OPPLParser.query_return retval = new OPPLParser.query_return();
		retval.start = this.input.LT(1);
		OPPLSyntaxTree root_0 = null;
		Token SELECT29 = null;
		Token COMMA31 = null;
		Token WHERE33 = null;
		Token COMMA35 = null;
		OPPLParser.selectClause_return selectClause30 = null;
		OPPLParser.selectClause_return selectClause32 = null;
		OPPLParser.constraint_return constraint34 = null;
		OPPLParser.constraint_return constraint36 = null;
		OPPLSyntaxTree SELECT29_tree = null;
		OPPLSyntaxTree COMMA31_tree = null;
		OPPLSyntaxTree WHERE33_tree = null;
		OPPLSyntaxTree COMMA35_tree = null;
		RewriteRuleTokenStream stream_WHERE = new RewriteRuleTokenStream(
				this.adaptor, "token WHERE");
		RewriteRuleTokenStream stream_COMMA = new RewriteRuleTokenStream(
				this.adaptor, "token COMMA");
		RewriteRuleTokenStream stream_SELECT = new RewriteRuleTokenStream(
				this.adaptor, "token SELECT");
		RewriteRuleSubtreeStream stream_constraint = new RewriteRuleSubtreeStream(
				this.adaptor, "rule constraint");
		RewriteRuleSubtreeStream stream_selectClause = new RewriteRuleSubtreeStream(
				this.adaptor, "rule selectClause");
		try {
			// /Users/luigi/Documents/workspace/PARSERS/src/OPPLParser.g:69:3: (
			// SELECT selectClause ( COMMA selectClause )* ( WHERE constraint (
			// COMMA constraint )* )? -> ^( QUERY ( selectClause )+ ( constraint
			// )* ) )
			// /Users/luigi/Documents/workspace/PARSERS/src/OPPLParser.g:70:5:
			// SELECT selectClause ( COMMA selectClause )* ( WHERE constraint (
			// COMMA constraint )* )?
			{
				SELECT29 = (Token) this.match(this.input, SELECT,
						FOLLOW_SELECT_in_query500);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_SELECT.add(SELECT29);
				}
				this.pushFollow(FOLLOW_selectClause_in_query502);
				selectClause30 = this.selectClause();
				this.state._fsp--;
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_selectClause.add(selectClause30.getTree());
				}
				// /Users/luigi/Documents/workspace/PARSERS/src/OPPLParser.g:70:25:
				// ( COMMA selectClause )*
				loop5: do {
					int alt5 = 2;
					int LA5_0 = this.input.LA(1);
					if (LA5_0 == COMMA) {
						alt5 = 1;
					}
					switch (alt5) {
					case 1:
						// /Users/luigi/Documents/workspace/PARSERS/src/OPPLParser.g:70:26:
						// COMMA selectClause
					{
						COMMA31 = (Token) this.match(this.input, COMMA,
								FOLLOW_COMMA_in_query505);
						if (this.state.failed) {
							return retval;
						}
						if (this.state.backtracking == 0) {
							stream_COMMA.add(COMMA31);
						}
						this.pushFollow(FOLLOW_selectClause_in_query507);
						selectClause32 = this.selectClause();
						this.state._fsp--;
						if (this.state.failed) {
							return retval;
						}
						if (this.state.backtracking == 0) {
							stream_selectClause.add(selectClause32.getTree());
						}
					}
						break;
					default:
						break loop5;
					}
				} while (true);
				// /Users/luigi/Documents/workspace/PARSERS/src/OPPLParser.g:70:47:
				// ( WHERE constraint ( COMMA constraint )* )?
				int alt7 = 2;
				int LA7_0 = this.input.LA(1);
				if (LA7_0 == WHERE) {
					alt7 = 1;
				}
				switch (alt7) {
				case 1:
					// /Users/luigi/Documents/workspace/PARSERS/src/OPPLParser.g:70:48:
					// WHERE constraint ( COMMA constraint )*
				{
					WHERE33 = (Token) this.match(this.input, WHERE,
							FOLLOW_WHERE_in_query512);
					if (this.state.failed) {
						return retval;
					}
					if (this.state.backtracking == 0) {
						stream_WHERE.add(WHERE33);
					}
					this.pushFollow(FOLLOW_constraint_in_query514);
					constraint34 = this.constraint();
					this.state._fsp--;
					if (this.state.failed) {
						return retval;
					}
					if (this.state.backtracking == 0) {
						stream_constraint.add(constraint34.getTree());
					}
					// /Users/luigi/Documents/workspace/PARSERS/src/OPPLParser.g:70:65:
					// ( COMMA constraint )*
					loop6: do {
						int alt6 = 2;
						int LA6_0 = this.input.LA(1);
						if (LA6_0 == COMMA) {
							alt6 = 1;
						}
						switch (alt6) {
						case 1:
							// /Users/luigi/Documents/workspace/PARSERS/src/OPPLParser.g:70:66:
							// COMMA constraint
						{
							COMMA35 = (Token) this.match(this.input, COMMA,
									FOLLOW_COMMA_in_query517);
							if (this.state.failed) {
								return retval;
							}
							if (this.state.backtracking == 0) {
								stream_COMMA.add(COMMA35);
							}
							this.pushFollow(FOLLOW_constraint_in_query519);
							constraint36 = this.constraint();
							this.state._fsp--;
							if (this.state.failed) {
								return retval;
							}
							if (this.state.backtracking == 0) {
								stream_constraint.add(constraint36.getTree());
							}
						}
							break;
						default:
							break loop6;
						}
					} while (true);
				}
					break;
				}
				// AST REWRITE
				// elements: constraint, selectClause
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
					// 70:87: -> ^( QUERY ( selectClause )+ ( constraint )* )
					{
						// /Users/luigi/Documents/workspace/PARSERS/src/OPPLParser.g:70:90:
						// ^( QUERY ( selectClause )+ ( constraint )* )
						{
							OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor
									.nil();
							root_1 = (OPPLSyntaxTree) this.adaptor
									.becomeRoot(this.adaptor.create(QUERY,
											"QUERY"), root_1);
							if (!stream_selectClause.hasNext()) {
								throw new RewriteEarlyExitException();
							}
							while (stream_selectClause.hasNext()) {
								this.adaptor.addChild(root_1,
										stream_selectClause.nextTree());
							}
							stream_selectClause.reset();
							// /Users/luigi/Documents/workspace/PARSERS/src/OPPLParser.g:70:112:
							// ( constraint )*
							while (stream_constraint.hasNext()) {
								this.adaptor.addChild(root_1, stream_constraint
										.nextTree());
							}
							stream_constraint.reset();
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
		} catch (RecognitionException e) {
			throw e;
		} finally {
		}
		return retval;
	}

	// $ANTLR end "query"
	public static class selectClause_return extends ParserRuleReturnScope {
		OPPLSyntaxTree tree;

		@Override
		public Object getTree() {
			return this.tree;
		}
	};

	// $ANTLR start "selectClause"
	// /Users/luigi/Documents/workspace/PARSERS/src/OPPLParser.g:73:2:
	// selectClause : ( ASSERTED axiom -> ^( ASSERTED_CLAUSE axiom ) | axiom ->
	// ^( PLAIN_CLAUSE axiom ) );
	public final OPPLParser.selectClause_return selectClause()
			throws RecognitionException {
		OPPLParser.selectClause_return retval = new OPPLParser.selectClause_return();
		retval.start = this.input.LT(1);
		OPPLSyntaxTree root_0 = null;
		Token ASSERTED37 = null;
		OPPLParser_MOWLParser.axiom_return axiom38 = null;
		OPPLParser_MOWLParser.axiom_return axiom39 = null;
		OPPLSyntaxTree ASSERTED37_tree = null;
		RewriteRuleTokenStream stream_ASSERTED = new RewriteRuleTokenStream(
				this.adaptor, "token ASSERTED");
		RewriteRuleSubtreeStream stream_axiom = new RewriteRuleSubtreeStream(
				this.adaptor, "rule axiom");
		try {
			// /Users/luigi/Documents/workspace/PARSERS/src/OPPLParser.g:74:3: (
			// ASSERTED axiom -> ^( ASSERTED_CLAUSE axiom ) | axiom -> ^(
			// PLAIN_CLAUSE axiom ) )
			int alt8 = 2;
			int LA8_0 = this.input.LA(1);
			if (LA8_0 == ASSERTED) {
				alt8 = 1;
			} else if (LA8_0 == EOF || LA8_0 >= NOT && LA8_0 <= SUB_PROPERTY_OF
					|| LA8_0 >= FUNCTIONAL && LA8_0 <= INVERSE
					|| LA8_0 >= IDENTIFIER && LA8_0 <= ENTITY_REFERENCE
					|| LA8_0 >= OPEN_CURLY_BRACES && LA8_0 <= COMMA
					|| LA8_0 == DBLQUOTE || LA8_0 == VARIABLE_NAME
					|| LA8_0 == CLOSED_SQUARE_BRACKET
					|| LA8_0 == ESCLAMATION_MARK) {
				alt8 = 2;
			} else {
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
				// /Users/luigi/Documents/workspace/PARSERS/src/OPPLParser.g:75:7:
				// ASSERTED axiom
			{
				ASSERTED37 = (Token) this.match(this.input, ASSERTED,
						FOLLOW_ASSERTED_in_selectClause556);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_ASSERTED.add(ASSERTED37);
				}
				this.pushFollow(FOLLOW_axiom_in_selectClause558);
				axiom38 = this.axiom();
				this.state._fsp--;
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_axiom.add(axiom38.getTree());
				}
				// AST REWRITE
				// elements: axiom
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
					// 75:22: -> ^( ASSERTED_CLAUSE axiom )
					{
						// /Users/luigi/Documents/workspace/PARSERS/src/OPPLParser.g:75:25:
						// ^( ASSERTED_CLAUSE axiom )
						{
							OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor
									.nil();
							root_1 = (OPPLSyntaxTree) this.adaptor.becomeRoot(
									this.adaptor.create(ASSERTED_CLAUSE,
											"ASSERTED_CLAUSE"), root_1);
							this.adaptor.addChild(root_1, stream_axiom
									.nextTree());
							this.adaptor.addChild(root_0, root_1);
						}
					}
					retval.tree = root_0;
				}
			}
				break;
			case 2:
				// /Users/luigi/Documents/workspace/PARSERS/src/OPPLParser.g:76:7:
				// axiom
			{
				this.pushFollow(FOLLOW_axiom_in_selectClause574);
				axiom39 = this.axiom();
				this.state._fsp--;
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_axiom.add(axiom39.getTree());
				}
				// AST REWRITE
				// elements: axiom
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
					// 76:13: -> ^( PLAIN_CLAUSE axiom )
					{
						// /Users/luigi/Documents/workspace/PARSERS/src/OPPLParser.g:76:16:
						// ^( PLAIN_CLAUSE axiom )
						{
							OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor
									.nil();
							root_1 = (OPPLSyntaxTree) this.adaptor.becomeRoot(
									this.adaptor.create(PLAIN_CLAUSE,
											"PLAIN_CLAUSE"), root_1);
							this.adaptor.addChild(root_1, stream_axiom
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
		} catch (RecognitionException e) {
			throw e;
		} finally {
		}
		return retval;
	}

	// $ANTLR end "selectClause"
	public static class constraint_return extends ParserRuleReturnScope {
		OPPLSyntaxTree tree;

		@Override
		public Object getTree() {
			return this.tree;
		}
	};

	// $ANTLR start "constraint"
	// /Users/luigi/Documents/workspace/PARSERS/src/OPPLParser.g:81:2:
	// constraint : (first= VARIABLE_NAME NOT_EQUAL second= expression -> ^(
	// INEQUALITY_CONSTRAINT IDENTIFIER[$first] ^( EXPRESSION $second) ) |
	// VARIABLE_NAME IN oneOf -> ^( IN_SET_CONSTRAINT IDENTIFIER[$VARIABLE_NAME]
	// oneOf ) | VARIABLE_NAME MATCH OPEN_PARENTHESYS stringOperation
	// CLOSED_PARENTHESYS -> ^( REGEXP_CONSTRAINT IDENTIFIER[$VARIABLE_NAME]
	// stringOperation ) | FAIL axiom -> ^( NAF_CONSTRAINT axiom ) );
	public final OPPLParser.constraint_return constraint()
			throws RecognitionException {
		OPPLParser.constraint_return retval = new OPPLParser.constraint_return();
		retval.start = this.input.LT(1);
		OPPLSyntaxTree root_0 = null;
		Token first = null;
		Token NOT_EQUAL40 = null;
		Token VARIABLE_NAME41 = null;
		Token IN42 = null;
		Token VARIABLE_NAME44 = null;
		Token MATCH45 = null;
		Token OPEN_PARENTHESYS46 = null;
		Token CLOSED_PARENTHESYS48 = null;
		Token FAIL49 = null;
		OPPLParser_MOWLParser.expression_return second = null;
		OPPLParser_MOWLParser.oneOf_return oneOf43 = null;
		OPPLParser.stringOperation_return stringOperation47 = null;
		OPPLParser_MOWLParser.axiom_return axiom50 = null;
		OPPLSyntaxTree first_tree = null;
		OPPLSyntaxTree NOT_EQUAL40_tree = null;
		OPPLSyntaxTree VARIABLE_NAME41_tree = null;
		OPPLSyntaxTree IN42_tree = null;
		OPPLSyntaxTree VARIABLE_NAME44_tree = null;
		OPPLSyntaxTree MATCH45_tree = null;
		OPPLSyntaxTree OPEN_PARENTHESYS46_tree = null;
		OPPLSyntaxTree CLOSED_PARENTHESYS48_tree = null;
		OPPLSyntaxTree FAIL49_tree = null;
		RewriteRuleTokenStream stream_MATCH = new RewriteRuleTokenStream(
				this.adaptor, "token MATCH");
		RewriteRuleTokenStream stream_VARIABLE_NAME = new RewriteRuleTokenStream(
				this.adaptor, "token VARIABLE_NAME");
		RewriteRuleTokenStream stream_IN = new RewriteRuleTokenStream(
				this.adaptor, "token IN");
		RewriteRuleTokenStream stream_CLOSED_PARENTHESYS = new RewriteRuleTokenStream(
				this.adaptor, "token CLOSED_PARENTHESYS");
		RewriteRuleTokenStream stream_NOT_EQUAL = new RewriteRuleTokenStream(
				this.adaptor, "token NOT_EQUAL");
		RewriteRuleTokenStream stream_FAIL = new RewriteRuleTokenStream(
				this.adaptor, "token FAIL");
		RewriteRuleTokenStream stream_OPEN_PARENTHESYS = new RewriteRuleTokenStream(
				this.adaptor, "token OPEN_PARENTHESYS");
		RewriteRuleSubtreeStream stream_expression = new RewriteRuleSubtreeStream(
				this.adaptor, "rule expression");
		RewriteRuleSubtreeStream stream_oneOf = new RewriteRuleSubtreeStream(
				this.adaptor, "rule oneOf");
		RewriteRuleSubtreeStream stream_axiom = new RewriteRuleSubtreeStream(
				this.adaptor, "rule axiom");
		RewriteRuleSubtreeStream stream_stringOperation = new RewriteRuleSubtreeStream(
				this.adaptor, "rule stringOperation");
		try {
			// /Users/luigi/Documents/workspace/PARSERS/src/OPPLParser.g:82:3:
			// (first= VARIABLE_NAME NOT_EQUAL second= expression -> ^(
			// INEQUALITY_CONSTRAINT IDENTIFIER[$first] ^( EXPRESSION $second) )
			// | VARIABLE_NAME IN oneOf -> ^( IN_SET_CONSTRAINT
			// IDENTIFIER[$VARIABLE_NAME] oneOf ) | VARIABLE_NAME MATCH
			// OPEN_PARENTHESYS stringOperation CLOSED_PARENTHESYS -> ^(
			// REGEXP_CONSTRAINT IDENTIFIER[$VARIABLE_NAME] stringOperation ) |
			// FAIL axiom -> ^( NAF_CONSTRAINT axiom ) )
			int alt9 = 4;
			int LA9_0 = this.input.LA(1);
			if (LA9_0 == VARIABLE_NAME) {
				switch (this.input.LA(2)) {
				case NOT_EQUAL: {
					alt9 = 1;
				}
					break;
				case IN: {
					alt9 = 2;
				}
					break;
				case MATCH: {
					alt9 = 3;
				}
					break;
				default:
					if (this.state.backtracking > 0) {
						this.state.failed = true;
						return retval;
					}
					NoViableAltException nvae = new NoViableAltException("", 9,
							1, this.input);
					throw nvae;
				}
			} else if (LA9_0 == FAIL) {
				alt9 = 4;
			} else {
				if (this.state.backtracking > 0) {
					this.state.failed = true;
					return retval;
				}
				NoViableAltException nvae = new NoViableAltException("", 9, 0,
						this.input);
				throw nvae;
			}
			switch (alt9) {
			case 1:
				// /Users/luigi/Documents/workspace/PARSERS/src/OPPLParser.g:83:8:
				// first= VARIABLE_NAME NOT_EQUAL second= expression
			{
				first = (Token) this.match(this.input, VARIABLE_NAME,
						FOLLOW_VARIABLE_NAME_in_constraint613);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_VARIABLE_NAME.add(first);
				}
				NOT_EQUAL40 = (Token) this.match(this.input, NOT_EQUAL,
						FOLLOW_NOT_EQUAL_in_constraint615);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_NOT_EQUAL.add(NOT_EQUAL40);
				}
				this.pushFollow(FOLLOW_expression_in_constraint621);
				second = this.expression();
				this.state._fsp--;
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_expression.add(second.getTree());
				}
				// AST REWRITE
				// elements: second
				// token labels:
				// rule labels: retval, second
				// token list labels:
				// rule list labels:
				// wildcard labels:
				if (this.state.backtracking == 0) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(
							this.adaptor, "rule retval",
							retval != null ? retval.tree : null);
					RewriteRuleSubtreeStream stream_second = new RewriteRuleSubtreeStream(
							this.adaptor, "rule second",
							second != null ? second.tree : null);
					root_0 = (OPPLSyntaxTree) this.adaptor.nil();
					// 83:60: -> ^( INEQUALITY_CONSTRAINT IDENTIFIER[$first] ^(
					// EXPRESSION $second) )
					{
						// /Users/luigi/Documents/workspace/PARSERS/src/OPPLParser.g:83:63:
						// ^( INEQUALITY_CONSTRAINT IDENTIFIER[$first] ^(
						// EXPRESSION $second) )
						{
							OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor
									.nil();
							root_1 = (OPPLSyntaxTree) this.adaptor.becomeRoot(
									this.adaptor.create(INEQUALITY_CONSTRAINT,
											"INEQUALITY_CONSTRAINT"), root_1);
							this.adaptor.addChild(root_1, this.adaptor.create(
									IDENTIFIER, first));
							// /Users/luigi/Documents/workspace/PARSERS/src/OPPLParser.g:83:106:
							// ^( EXPRESSION $second)
							{
								OPPLSyntaxTree root_2 = (OPPLSyntaxTree) this.adaptor
										.nil();
								root_2 = (OPPLSyntaxTree) this.adaptor
										.becomeRoot(this.adaptor.create(
												EXPRESSION, "EXPRESSION"),
												root_2);
								this.adaptor.addChild(root_2, stream_second
										.nextTree());
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
				// /Users/luigi/Documents/workspace/PARSERS/src/OPPLParser.g:84:8:
				// VARIABLE_NAME IN oneOf
			{
				VARIABLE_NAME41 = (Token) this.match(this.input, VARIABLE_NAME,
						FOLLOW_VARIABLE_NAME_in_constraint646);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_VARIABLE_NAME.add(VARIABLE_NAME41);
				}
				IN42 = (Token) this.match(this.input, IN,
						FOLLOW_IN_in_constraint648);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_IN.add(IN42);
				}
				this.pushFollow(FOLLOW_oneOf_in_constraint650);
				oneOf43 = this.oneOf();
				this.state._fsp--;
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_oneOf.add(oneOf43.getTree());
				}
				// AST REWRITE
				// elements: oneOf
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
					// 84:31: -> ^( IN_SET_CONSTRAINT IDENTIFIER[$VARIABLE_NAME]
					// oneOf )
					{
						// /Users/luigi/Documents/workspace/PARSERS/src/OPPLParser.g:84:34:
						// ^( IN_SET_CONSTRAINT IDENTIFIER[$VARIABLE_NAME] oneOf
						// )
						{
							OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor
									.nil();
							root_1 = (OPPLSyntaxTree) this.adaptor.becomeRoot(
									this.adaptor.create(IN_SET_CONSTRAINT,
											"IN_SET_CONSTRAINT"), root_1);
							this.adaptor.addChild(root_1, this.adaptor.create(
									IDENTIFIER, VARIABLE_NAME41));
							this.adaptor.addChild(root_1, stream_oneOf
									.nextTree());
							this.adaptor.addChild(root_0, root_1);
						}
					}
					retval.tree = root_0;
				}
			}
				break;
			case 3:
				// /Users/luigi/Documents/workspace/PARSERS/src/OPPLParser.g:85:8:
				// VARIABLE_NAME MATCH OPEN_PARENTHESYS stringOperation
				// CLOSED_PARENTHESYS
			{
				VARIABLE_NAME44 = (Token) this.match(this.input, VARIABLE_NAME,
						FOLLOW_VARIABLE_NAME_in_constraint670);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_VARIABLE_NAME.add(VARIABLE_NAME44);
				}
				MATCH45 = (Token) this.match(this.input, MATCH,
						FOLLOW_MATCH_in_constraint672);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_MATCH.add(MATCH45);
				}
				OPEN_PARENTHESYS46 = (Token) this.match(this.input,
						OPEN_PARENTHESYS,
						FOLLOW_OPEN_PARENTHESYS_in_constraint674);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_OPEN_PARENTHESYS.add(OPEN_PARENTHESYS46);
				}
				this.pushFollow(FOLLOW_stringOperation_in_constraint676);
				stringOperation47 = this.stringOperation();
				this.state._fsp--;
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_stringOperation.add(stringOperation47.getTree());
				}
				CLOSED_PARENTHESYS48 = (Token) this.match(this.input,
						CLOSED_PARENTHESYS,
						FOLLOW_CLOSED_PARENTHESYS_in_constraint678);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_CLOSED_PARENTHESYS.add(CLOSED_PARENTHESYS48);
				}
				// AST REWRITE
				// elements: stringOperation
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
					// 85:80: -> ^( REGEXP_CONSTRAINT IDENTIFIER[$VARIABLE_NAME]
					// stringOperation )
					{
						// /Users/luigi/Documents/workspace/PARSERS/src/OPPLParser.g:85:83:
						// ^( REGEXP_CONSTRAINT IDENTIFIER[$VARIABLE_NAME]
						// stringOperation )
						{
							OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor
									.nil();
							root_1 = (OPPLSyntaxTree) this.adaptor.becomeRoot(
									this.adaptor.create(REGEXP_CONSTRAINT,
											"REGEXP_CONSTRAINT"), root_1);
							this.adaptor.addChild(root_1, this.adaptor.create(
									IDENTIFIER, VARIABLE_NAME44));
							this.adaptor.addChild(root_1,
									stream_stringOperation.nextTree());
							this.adaptor.addChild(root_0, root_1);
						}
					}
					retval.tree = root_0;
				}
			}
				break;
			case 4:
				// /Users/luigi/Documents/workspace/PARSERS/src/OPPLParser.g:86:7:
				// FAIL axiom
			{
				FAIL49 = (Token) this.match(this.input, FAIL,
						FOLLOW_FAIL_in_constraint697);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_FAIL.add(FAIL49);
				}
				this.pushFollow(FOLLOW_axiom_in_constraint699);
				axiom50 = this.axiom();
				this.state._fsp--;
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_axiom.add(axiom50.getTree());
				}
				// AST REWRITE
				// elements: axiom
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
					// 86:18: -> ^( NAF_CONSTRAINT axiom )
					{
						// /Users/luigi/Documents/workspace/PARSERS/src/OPPLParser.g:86:21:
						// ^( NAF_CONSTRAINT axiom )
						{
							OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor
									.nil();
							root_1 = (OPPLSyntaxTree) this.adaptor.becomeRoot(
									this.adaptor.create(NAF_CONSTRAINT,
											"NAF_CONSTRAINT"), root_1);
							this.adaptor.addChild(root_1, stream_axiom
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
		} catch (RecognitionException e) {
			throw e;
		} finally {
		}
		return retval;
	}

	// $ANTLR end "constraint"
	public static class actions_return extends ParserRuleReturnScope {
		OPPLSyntaxTree tree;

		@Override
		public Object getTree() {
			return this.tree;
		}
	};

	// $ANTLR start "actions"
	// /Users/luigi/Documents/workspace/PARSERS/src/OPPLParser.g:89:2: actions :
	// BEGIN action ( COMMA action )* END -> ^( ACTIONS ( action )+ ) ;
	public final OPPLParser.actions_return actions()
			throws RecognitionException {
		OPPLParser.actions_return retval = new OPPLParser.actions_return();
		retval.start = this.input.LT(1);
		OPPLSyntaxTree root_0 = null;
		Token BEGIN51 = null;
		Token COMMA53 = null;
		Token END55 = null;
		OPPLParser.action_return action52 = null;
		OPPLParser.action_return action54 = null;
		OPPLSyntaxTree BEGIN51_tree = null;
		OPPLSyntaxTree COMMA53_tree = null;
		OPPLSyntaxTree END55_tree = null;
		RewriteRuleTokenStream stream_END = new RewriteRuleTokenStream(
				this.adaptor, "token END");
		RewriteRuleTokenStream stream_COMMA = new RewriteRuleTokenStream(
				this.adaptor, "token COMMA");
		RewriteRuleTokenStream stream_BEGIN = new RewriteRuleTokenStream(
				this.adaptor, "token BEGIN");
		RewriteRuleSubtreeStream stream_action = new RewriteRuleSubtreeStream(
				this.adaptor, "rule action");
		try {
			// /Users/luigi/Documents/workspace/PARSERS/src/OPPLParser.g:90:3: (
			// BEGIN action ( COMMA action )* END -> ^( ACTIONS ( action )+ ) )
			// /Users/luigi/Documents/workspace/PARSERS/src/OPPLParser.g:91:5:
			// BEGIN action ( COMMA action )* END
			{
				BEGIN51 = (Token) this.match(this.input, BEGIN,
						FOLLOW_BEGIN_in_actions727);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_BEGIN.add(BEGIN51);
				}
				this.pushFollow(FOLLOW_action_in_actions729);
				action52 = this.action();
				this.state._fsp--;
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_action.add(action52.getTree());
				}
				// /Users/luigi/Documents/workspace/PARSERS/src/OPPLParser.g:91:18:
				// ( COMMA action )*
				loop10: do {
					int alt10 = 2;
					int LA10_0 = this.input.LA(1);
					if (LA10_0 == COMMA) {
						alt10 = 1;
					}
					switch (alt10) {
					case 1:
						// /Users/luigi/Documents/workspace/PARSERS/src/OPPLParser.g:91:19:
						// COMMA action
					{
						COMMA53 = (Token) this.match(this.input, COMMA,
								FOLLOW_COMMA_in_actions732);
						if (this.state.failed) {
							return retval;
						}
						if (this.state.backtracking == 0) {
							stream_COMMA.add(COMMA53);
						}
						this.pushFollow(FOLLOW_action_in_actions734);
						action54 = this.action();
						this.state._fsp--;
						if (this.state.failed) {
							return retval;
						}
						if (this.state.backtracking == 0) {
							stream_action.add(action54.getTree());
						}
					}
						break;
					default:
						break loop10;
					}
				} while (true);
				END55 = (Token) this.match(this.input, END,
						FOLLOW_END_in_actions738);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_END.add(END55);
				}
				// AST REWRITE
				// elements: action
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
					// 91:38: -> ^( ACTIONS ( action )+ )
					{
						// /Users/luigi/Documents/workspace/PARSERS/src/OPPLParser.g:91:41:
						// ^( ACTIONS ( action )+ )
						{
							OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor
									.nil();
							root_1 = (OPPLSyntaxTree) this.adaptor.becomeRoot(
									this.adaptor.create(ACTIONS, "ACTIONS"),
									root_1);
							if (!stream_action.hasNext()) {
								throw new RewriteEarlyExitException();
							}
							while (stream_action.hasNext()) {
								this.adaptor.addChild(root_1, stream_action
										.nextTree());
							}
							stream_action.reset();
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
		} catch (RecognitionException e) {
			throw e;
		} finally {
		}
		return retval;
	}

	// $ANTLR end "actions"
	public static class action_return extends ParserRuleReturnScope {
		OPPLSyntaxTree tree;

		@Override
		public Object getTree() {
			return this.tree;
		}
	};

	// $ANTLR start "action"
	// /Users/luigi/Documents/workspace/PARSERS/src/OPPLParser.g:94:2: action :
	// ( ADD axiom -> ^( ADD axiom ) | REMOVE axiom -> ^( REMOVE axiom ) );
	public final OPPLParser.action_return action() throws RecognitionException {
		OPPLParser.action_return retval = new OPPLParser.action_return();
		retval.start = this.input.LT(1);
		OPPLSyntaxTree root_0 = null;
		Token ADD56 = null;
		Token REMOVE58 = null;
		OPPLParser_MOWLParser.axiom_return axiom57 = null;
		OPPLParser_MOWLParser.axiom_return axiom59 = null;
		OPPLSyntaxTree ADD56_tree = null;
		OPPLSyntaxTree REMOVE58_tree = null;
		RewriteRuleTokenStream stream_REMOVE = new RewriteRuleTokenStream(
				this.adaptor, "token REMOVE");
		RewriteRuleTokenStream stream_ADD = new RewriteRuleTokenStream(
				this.adaptor, "token ADD");
		RewriteRuleSubtreeStream stream_axiom = new RewriteRuleSubtreeStream(
				this.adaptor, "rule axiom");
		try {
			// /Users/luigi/Documents/workspace/PARSERS/src/OPPLParser.g:95:3: (
			// ADD axiom -> ^( ADD axiom ) | REMOVE axiom -> ^( REMOVE axiom ) )
			int alt11 = 2;
			int LA11_0 = this.input.LA(1);
			if (LA11_0 == ADD) {
				alt11 = 1;
			} else if (LA11_0 == REMOVE) {
				alt11 = 2;
			} else {
				if (this.state.backtracking > 0) {
					this.state.failed = true;
					return retval;
				}
				NoViableAltException nvae = new NoViableAltException("", 11, 0,
						this.input);
				throw nvae;
			}
			switch (alt11) {
			case 1:
				// /Users/luigi/Documents/workspace/PARSERS/src/OPPLParser.g:96:7:
				// ADD axiom
			{
				ADD56 = (Token) this.match(this.input, ADD,
						FOLLOW_ADD_in_action770);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_ADD.add(ADD56);
				}
				this.pushFollow(FOLLOW_axiom_in_action772);
				axiom57 = this.axiom();
				this.state._fsp--;
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_axiom.add(axiom57.getTree());
				}
				// AST REWRITE
				// elements: ADD, axiom
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
					// 96:17: -> ^( ADD axiom )
					{
						// /Users/luigi/Documents/workspace/PARSERS/src/OPPLParser.g:96:20:
						// ^( ADD axiom )
						{
							OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor
									.nil();
							root_1 = (OPPLSyntaxTree) this.adaptor.becomeRoot(
									stream_ADD.nextNode(), root_1);
							this.adaptor.addChild(root_1, stream_axiom
									.nextTree());
							this.adaptor.addChild(root_0, root_1);
						}
					}
					retval.tree = root_0;
				}
			}
				break;
			case 2:
				// /Users/luigi/Documents/workspace/PARSERS/src/OPPLParser.g:97:7:
				// REMOVE axiom
			{
				REMOVE58 = (Token) this.match(this.input, REMOVE,
						FOLLOW_REMOVE_in_action788);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_REMOVE.add(REMOVE58);
				}
				this.pushFollow(FOLLOW_axiom_in_action790);
				axiom59 = this.axiom();
				this.state._fsp--;
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_axiom.add(axiom59.getTree());
				}
				// AST REWRITE
				// elements: REMOVE, axiom
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
					// 97:20: -> ^( REMOVE axiom )
					{
						// /Users/luigi/Documents/workspace/PARSERS/src/OPPLParser.g:97:23:
						// ^( REMOVE axiom )
						{
							OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor
									.nil();
							root_1 = (OPPLSyntaxTree) this.adaptor.becomeRoot(
									stream_REMOVE.nextNode(), root_1);
							this.adaptor.addChild(root_1, stream_axiom
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
		} catch (RecognitionException e) {
			throw e;
		} finally {
		}
		return retval;
	}

	// $ANTLR end "action"
	public static class opplFunction_return extends ParserRuleReturnScope {
		OPPLSyntaxTree tree;

		@Override
		public Object getTree() {
			return this.tree;
		}
	};

	// $ANTLR start "opplFunction"
	// /Users/luigi/Documents/workspace/PARSERS/src/OPPLParser.g:103:1:
	// opplFunction : ( CREATE OPEN_PARENTHESYS stringOperation
	// CLOSED_PARENTHESYS -> ^( CREATE_OPPL_FUNCTION stringOperation ) |
	// CREATE_INTERSECTION OPEN_PARENTHESYS atomic CLOSED_PARENTHESYS -> ^(
	// CREATE_INTERSECTION atomic ) | CREATE_DISJUNCTION OPEN_PARENTHESYS atomic
	// CLOSED_PARENTHESYS -> ^( CREATE_INTERSECTION atomic ) );
	public final OPPLParser.opplFunction_return opplFunction()
			throws RecognitionException {
		OPPLParser.opplFunction_return retval = new OPPLParser.opplFunction_return();
		retval.start = this.input.LT(1);
		OPPLSyntaxTree root_0 = null;
		Token CREATE60 = null;
		Token OPEN_PARENTHESYS61 = null;
		Token CLOSED_PARENTHESYS63 = null;
		Token CREATE_INTERSECTION64 = null;
		Token OPEN_PARENTHESYS65 = null;
		Token CLOSED_PARENTHESYS67 = null;
		Token CREATE_DISJUNCTION68 = null;
		Token OPEN_PARENTHESYS69 = null;
		Token CLOSED_PARENTHESYS71 = null;
		OPPLParser.stringOperation_return stringOperation62 = null;
		OPPLParser.atomic_return atomic66 = null;
		OPPLParser.atomic_return atomic70 = null;
		OPPLSyntaxTree CREATE60_tree = null;
		OPPLSyntaxTree OPEN_PARENTHESYS61_tree = null;
		OPPLSyntaxTree CLOSED_PARENTHESYS63_tree = null;
		OPPLSyntaxTree CREATE_INTERSECTION64_tree = null;
		OPPLSyntaxTree OPEN_PARENTHESYS65_tree = null;
		OPPLSyntaxTree CLOSED_PARENTHESYS67_tree = null;
		OPPLSyntaxTree CREATE_DISJUNCTION68_tree = null;
		OPPLSyntaxTree OPEN_PARENTHESYS69_tree = null;
		OPPLSyntaxTree CLOSED_PARENTHESYS71_tree = null;
		RewriteRuleTokenStream stream_CREATE = new RewriteRuleTokenStream(
				this.adaptor, "token CREATE");
		RewriteRuleTokenStream stream_CREATE_DISJUNCTION = new RewriteRuleTokenStream(
				this.adaptor, "token CREATE_DISJUNCTION");
		RewriteRuleTokenStream stream_CREATE_INTERSECTION = new RewriteRuleTokenStream(
				this.adaptor, "token CREATE_INTERSECTION");
		RewriteRuleTokenStream stream_CLOSED_PARENTHESYS = new RewriteRuleTokenStream(
				this.adaptor, "token CLOSED_PARENTHESYS");
		RewriteRuleTokenStream stream_OPEN_PARENTHESYS = new RewriteRuleTokenStream(
				this.adaptor, "token OPEN_PARENTHESYS");
		RewriteRuleSubtreeStream stream_stringOperation = new RewriteRuleSubtreeStream(
				this.adaptor, "rule stringOperation");
		RewriteRuleSubtreeStream stream_atomic = new RewriteRuleSubtreeStream(
				this.adaptor, "rule atomic");
		try {
			// /Users/luigi/Documents/workspace/PARSERS/src/OPPLParser.g:104:3:
			// ( CREATE OPEN_PARENTHESYS stringOperation CLOSED_PARENTHESYS ->
			// ^( CREATE_OPPL_FUNCTION stringOperation ) | CREATE_INTERSECTION
			// OPEN_PARENTHESYS atomic CLOSED_PARENTHESYS -> ^(
			// CREATE_INTERSECTION atomic ) | CREATE_DISJUNCTION
			// OPEN_PARENTHESYS atomic CLOSED_PARENTHESYS -> ^(
			// CREATE_INTERSECTION atomic ) )
			int alt12 = 3;
			switch (this.input.LA(1)) {
			case CREATE: {
				alt12 = 1;
			}
				break;
			case CREATE_INTERSECTION: {
				alt12 = 2;
			}
				break;
			case CREATE_DISJUNCTION: {
				alt12 = 3;
			}
				break;
			default:
				if (this.state.backtracking > 0) {
					this.state.failed = true;
					return retval;
				}
				NoViableAltException nvae = new NoViableAltException("", 12, 0,
						this.input);
				throw nvae;
			}
			switch (alt12) {
			case 1:
				// /Users/luigi/Documents/workspace/PARSERS/src/OPPLParser.g:105:7:
				// CREATE OPEN_PARENTHESYS stringOperation CLOSED_PARENTHESYS
			{
				CREATE60 = (Token) this.match(this.input, CREATE,
						FOLLOW_CREATE_in_opplFunction823);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_CREATE.add(CREATE60);
				}
				OPEN_PARENTHESYS61 = (Token) this.match(this.input,
						OPEN_PARENTHESYS,
						FOLLOW_OPEN_PARENTHESYS_in_opplFunction825);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_OPEN_PARENTHESYS.add(OPEN_PARENTHESYS61);
				}
				this.pushFollow(FOLLOW_stringOperation_in_opplFunction827);
				stringOperation62 = this.stringOperation();
				this.state._fsp--;
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_stringOperation.add(stringOperation62.getTree());
				}
				CLOSED_PARENTHESYS63 = (Token) this.match(this.input,
						CLOSED_PARENTHESYS,
						FOLLOW_CLOSED_PARENTHESYS_in_opplFunction829);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_CLOSED_PARENTHESYS.add(CLOSED_PARENTHESYS63);
				}
				// AST REWRITE
				// elements: stringOperation
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
					// 105:66: -> ^( CREATE_OPPL_FUNCTION stringOperation )
					{
						// /Users/luigi/Documents/workspace/PARSERS/src/OPPLParser.g:105:69:
						// ^( CREATE_OPPL_FUNCTION stringOperation )
						{
							OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor
									.nil();
							root_1 = (OPPLSyntaxTree) this.adaptor.becomeRoot(
									this.adaptor.create(CREATE_OPPL_FUNCTION,
											"CREATE_OPPL_FUNCTION"), root_1);
							this.adaptor.addChild(root_1,
									stream_stringOperation.nextTree());
							this.adaptor.addChild(root_0, root_1);
						}
					}
					retval.tree = root_0;
				}
			}
				break;
			case 2:
				// /Users/luigi/Documents/workspace/PARSERS/src/OPPLParser.g:106:7:
				// CREATE_INTERSECTION OPEN_PARENTHESYS atomic
				// CLOSED_PARENTHESYS
			{
				CREATE_INTERSECTION64 = (Token) this.match(this.input,
						CREATE_INTERSECTION,
						FOLLOW_CREATE_INTERSECTION_in_opplFunction845);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_CREATE_INTERSECTION.add(CREATE_INTERSECTION64);
				}
				OPEN_PARENTHESYS65 = (Token) this.match(this.input,
						OPEN_PARENTHESYS,
						FOLLOW_OPEN_PARENTHESYS_in_opplFunction848);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_OPEN_PARENTHESYS.add(OPEN_PARENTHESYS65);
				}
				this.pushFollow(FOLLOW_atomic_in_opplFunction850);
				atomic66 = this.atomic();
				this.state._fsp--;
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_atomic.add(atomic66.getTree());
				}
				CLOSED_PARENTHESYS67 = (Token) this.match(this.input,
						CLOSED_PARENTHESYS,
						FOLLOW_CLOSED_PARENTHESYS_in_opplFunction853);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_CLOSED_PARENTHESYS.add(CLOSED_PARENTHESYS67);
				}
				// AST REWRITE
				// elements: atomic, CREATE_INTERSECTION
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
					// 106:72: -> ^( CREATE_INTERSECTION atomic )
					{
						// /Users/luigi/Documents/workspace/PARSERS/src/OPPLParser.g:106:75:
						// ^( CREATE_INTERSECTION atomic )
						{
							OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor
									.nil();
							root_1 = (OPPLSyntaxTree) this.adaptor.becomeRoot(
									stream_CREATE_INTERSECTION.nextNode(),
									root_1);
							this.adaptor.addChild(root_1, stream_atomic
									.nextTree());
							this.adaptor.addChild(root_0, root_1);
						}
					}
					retval.tree = root_0;
				}
			}
				break;
			case 3:
				// /Users/luigi/Documents/workspace/PARSERS/src/OPPLParser.g:107:7:
				// CREATE_DISJUNCTION OPEN_PARENTHESYS atomic CLOSED_PARENTHESYS
			{
				CREATE_DISJUNCTION68 = (Token) this.match(this.input,
						CREATE_DISJUNCTION,
						FOLLOW_CREATE_DISJUNCTION_in_opplFunction869);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_CREATE_DISJUNCTION.add(CREATE_DISJUNCTION68);
				}
				OPEN_PARENTHESYS69 = (Token) this.match(this.input,
						OPEN_PARENTHESYS,
						FOLLOW_OPEN_PARENTHESYS_in_opplFunction871);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_OPEN_PARENTHESYS.add(OPEN_PARENTHESYS69);
				}
				this.pushFollow(FOLLOW_atomic_in_opplFunction873);
				atomic70 = this.atomic();
				this.state._fsp--;
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_atomic.add(atomic70.getTree());
				}
				CLOSED_PARENTHESYS71 = (Token) this.match(this.input,
						CLOSED_PARENTHESYS,
						FOLLOW_CLOSED_PARENTHESYS_in_opplFunction875);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_CLOSED_PARENTHESYS.add(CLOSED_PARENTHESYS71);
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
							this.adaptor, "rule retval",
							retval != null ? retval.tree : null);
					root_0 = (OPPLSyntaxTree) this.adaptor.nil();
					// 107:69: -> ^( CREATE_INTERSECTION atomic )
					{
						// /Users/luigi/Documents/workspace/PARSERS/src/OPPLParser.g:107:72:
						// ^( CREATE_INTERSECTION atomic )
						{
							OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor
									.nil();
							root_1 = (OPPLSyntaxTree) this.adaptor.becomeRoot(
									this.adaptor.create(CREATE_INTERSECTION,
											"CREATE_INTERSECTION"), root_1);
							this.adaptor.addChild(root_1, stream_atomic
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
		} catch (RecognitionException e) {
			throw e;
		} finally {
		}
		return retval;
	}

	// $ANTLR end "opplFunction"
	public static class stringOperation_return extends ParserRuleReturnScope {
		OPPLSyntaxTree tree;

		@Override
		public Object getTree() {
			return this.tree;
		}
	};

	// $ANTLR start "stringOperation"
	// /Users/luigi/Documents/workspace/PARSERS/src/OPPLParser.g:110:1:
	// stringOperation : stringExpression ( PLUS stringExpression )* -> ^(
	// STRING_OPERATION ( stringExpression )+ ) ;
	public final OPPLParser.stringOperation_return stringOperation()
			throws RecognitionException {
		OPPLParser.stringOperation_return retval = new OPPLParser.stringOperation_return();
		retval.start = this.input.LT(1);
		OPPLSyntaxTree root_0 = null;
		Token PLUS73 = null;
		OPPLParser.stringExpression_return stringExpression72 = null;
		OPPLParser.stringExpression_return stringExpression74 = null;
		OPPLSyntaxTree PLUS73_tree = null;
		RewriteRuleTokenStream stream_PLUS = new RewriteRuleTokenStream(
				this.adaptor, "token PLUS");
		RewriteRuleSubtreeStream stream_stringExpression = new RewriteRuleSubtreeStream(
				this.adaptor, "rule stringExpression");
		try {
			// /Users/luigi/Documents/workspace/PARSERS/src/OPPLParser.g:111:3:
			// ( stringExpression ( PLUS stringExpression )* -> ^(
			// STRING_OPERATION ( stringExpression )+ ) )
			// /Users/luigi/Documents/workspace/PARSERS/src/OPPLParser.g:112:5:
			// stringExpression ( PLUS stringExpression )*
			{
				this.pushFollow(FOLLOW_stringExpression_in_stringOperation900);
				stringExpression72 = this.stringExpression();
				this.state._fsp--;
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_stringExpression.add(stringExpression72.getTree());
				}
				// /Users/luigi/Documents/workspace/PARSERS/src/OPPLParser.g:112:22:
				// ( PLUS stringExpression )*
				loop13: do {
					int alt13 = 2;
					int LA13_0 = this.input.LA(1);
					if (LA13_0 == PLUS) {
						alt13 = 1;
					}
					switch (alt13) {
					case 1:
						// /Users/luigi/Documents/workspace/PARSERS/src/OPPLParser.g:112:23:
						// PLUS stringExpression
					{
						PLUS73 = (Token) this.match(this.input, PLUS,
								FOLLOW_PLUS_in_stringOperation903);
						if (this.state.failed) {
							return retval;
						}
						if (this.state.backtracking == 0) {
							stream_PLUS.add(PLUS73);
						}
						this
								.pushFollow(FOLLOW_stringExpression_in_stringOperation905);
						stringExpression74 = this.stringExpression();
						this.state._fsp--;
						if (this.state.failed) {
							return retval;
						}
						if (this.state.backtracking == 0) {
							stream_stringExpression.add(stringExpression74
									.getTree());
						}
					}
						break;
					default:
						break loop13;
					}
				} while (true);
				// AST REWRITE
				// elements: stringExpression
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
					// 112:47: -> ^( STRING_OPERATION ( stringExpression )+ )
					{
						// /Users/luigi/Documents/workspace/PARSERS/src/OPPLParser.g:112:50:
						// ^( STRING_OPERATION ( stringExpression )+ )
						{
							OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor
									.nil();
							root_1 = (OPPLSyntaxTree) this.adaptor.becomeRoot(
									this.adaptor.create(STRING_OPERATION,
											"STRING_OPERATION"), root_1);
							if (!stream_stringExpression.hasNext()) {
								throw new RewriteEarlyExitException();
							}
							while (stream_stringExpression.hasNext()) {
								this.adaptor.addChild(root_1,
										stream_stringExpression.nextTree());
							}
							stream_stringExpression.reset();
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
		} catch (RecognitionException e) {
			throw e;
		} finally {
		}
		return retval;
	}

	// $ANTLR end "stringOperation"
	public static class stringExpression_return extends ParserRuleReturnScope {
		OPPLSyntaxTree tree;

		@Override
		public Object getTree() {
			return this.tree;
		}
	};

	// $ANTLR start "stringExpression"
	// /Users/luigi/Documents/workspace/PARSERS/src/OPPLParser.g:115:1:
	// stringExpression : ( DBLQUOTE -> ^( DBLQUOTE ) |
	// variableAttributeReference -> ^( variableAttributeReference ) );
	public final OPPLParser.stringExpression_return stringExpression()
			throws RecognitionException {
		OPPLParser.stringExpression_return retval = new OPPLParser.stringExpression_return();
		retval.start = this.input.LT(1);
		OPPLSyntaxTree root_0 = null;
		Token DBLQUOTE75 = null;
		OPPLParser.variableAttributeReference_return variableAttributeReference76 = null;
		OPPLSyntaxTree DBLQUOTE75_tree = null;
		RewriteRuleTokenStream stream_DBLQUOTE = new RewriteRuleTokenStream(
				this.adaptor, "token DBLQUOTE");
		RewriteRuleSubtreeStream stream_variableAttributeReference = new RewriteRuleSubtreeStream(
				this.adaptor, "rule variableAttributeReference");
		try {
			// /Users/luigi/Documents/workspace/PARSERS/src/OPPLParser.g:116:2:
			// ( DBLQUOTE -> ^( DBLQUOTE ) | variableAttributeReference -> ^(
			// variableAttributeReference ) )
			int alt14 = 2;
			int LA14_0 = this.input.LA(1);
			if (LA14_0 == DBLQUOTE) {
				alt14 = 1;
			} else if (LA14_0 == VARIABLE_NAME) {
				alt14 = 2;
			} else {
				if (this.state.backtracking > 0) {
					this.state.failed = true;
					return retval;
				}
				NoViableAltException nvae = new NoViableAltException("", 14, 0,
						this.input);
				throw nvae;
			}
			switch (alt14) {
			case 1:
				// /Users/luigi/Documents/workspace/PARSERS/src/OPPLParser.g:117:3:
				// DBLQUOTE
			{
				DBLQUOTE75 = (Token) this.match(this.input, DBLQUOTE,
						FOLLOW_DBLQUOTE_in_stringExpression932);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_DBLQUOTE.add(DBLQUOTE75);
				}
				// AST REWRITE
				// elements: DBLQUOTE
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
					// 117:12: -> ^( DBLQUOTE )
					{
						// /Users/luigi/Documents/workspace/PARSERS/src/OPPLParser.g:117:15:
						// ^( DBLQUOTE )
						{
							OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor
									.nil();
							root_1 = (OPPLSyntaxTree) this.adaptor.becomeRoot(
									stream_DBLQUOTE.nextNode(), root_1);
							this.adaptor.addChild(root_0, root_1);
						}
					}
					retval.tree = root_0;
				}
			}
				break;
			case 2:
				// /Users/luigi/Documents/workspace/PARSERS/src/OPPLParser.g:118:8:
				// variableAttributeReference
			{
				this
						.pushFollow(FOLLOW_variableAttributeReference_in_stringExpression947);
				variableAttributeReference76 = this
						.variableAttributeReference();
				this.state._fsp--;
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_variableAttributeReference
							.add(variableAttributeReference76.getTree());
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
							this.adaptor, "rule retval",
							retval != null ? retval.tree : null);
					root_0 = (OPPLSyntaxTree) this.adaptor.nil();
					// 118:35: -> ^( variableAttributeReference )
					{
						// /Users/luigi/Documents/workspace/PARSERS/src/OPPLParser.g:118:38:
						// ^( variableAttributeReference )
						{
							OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor
									.nil();
							root_1 = (OPPLSyntaxTree) this.adaptor.becomeRoot(
									stream_variableAttributeReference
											.nextNode(), root_1);
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
		} catch (RecognitionException e) {
			throw e;
		} finally {
		}
		return retval;
	}

	// $ANTLR end "stringExpression"
	public static class atomic_return extends ParserRuleReturnScope {
		OPPLSyntaxTree tree;

		@Override
		public Object getTree() {
			return this.tree;
		}
	};

	// $ANTLR start "atomic"
	// /Users/luigi/Documents/workspace/PARSERS/src/OPPLParser.g:122:1: atomic :
	// ( IDENTIFIER | ENTITY_REFERENCE -> ^( ENTITY_REFERENCE ) | VARIABLE_NAME
	// -> ^( IDENTIFIER[$VARIABLE_NAME] ) | createIdentifier -> ^(
	// createIdentifier ) | variableAttributeReference -> ^(
	// variableAttributeReference ) );
	public final OPPLParser.atomic_return atomic() throws RecognitionException {
		OPPLParser.atomic_return retval = new OPPLParser.atomic_return();
		retval.start = this.input.LT(1);
		OPPLSyntaxTree root_0 = null;
		Token IDENTIFIER77 = null;
		Token ENTITY_REFERENCE78 = null;
		Token VARIABLE_NAME79 = null;
		OPPLParser.createIdentifier_return createIdentifier80 = null;
		OPPLParser.variableAttributeReference_return variableAttributeReference81 = null;
		OPPLSyntaxTree IDENTIFIER77_tree = null;
		OPPLSyntaxTree ENTITY_REFERENCE78_tree = null;
		OPPLSyntaxTree VARIABLE_NAME79_tree = null;
		RewriteRuleTokenStream stream_VARIABLE_NAME = new RewriteRuleTokenStream(
				this.adaptor, "token VARIABLE_NAME");
		RewriteRuleTokenStream stream_ENTITY_REFERENCE = new RewriteRuleTokenStream(
				this.adaptor, "token ENTITY_REFERENCE");
		RewriteRuleSubtreeStream stream_variableAttributeReference = new RewriteRuleSubtreeStream(
				this.adaptor, "rule variableAttributeReference");
		RewriteRuleSubtreeStream stream_createIdentifier = new RewriteRuleSubtreeStream(
				this.adaptor, "rule createIdentifier");
		try {
			// /Users/luigi/Documents/workspace/PARSERS/src/OPPLParser.g:122:8:
			// ( IDENTIFIER | ENTITY_REFERENCE -> ^( ENTITY_REFERENCE ) |
			// VARIABLE_NAME -> ^( IDENTIFIER[$VARIABLE_NAME] ) |
			// createIdentifier -> ^( createIdentifier ) |
			// variableAttributeReference -> ^( variableAttributeReference ) )
			int alt15 = 5;
			switch (this.input.LA(1)) {
			case IDENTIFIER: {
				alt15 = 1;
			}
				break;
			case ENTITY_REFERENCE: {
				alt15 = 2;
			}
				break;
			case VARIABLE_NAME: {
				int LA15_3 = this.input.LA(2);
				if (LA15_3 == DOT) {
					alt15 = 5;
				} else if (LA15_3 == EOF || LA15_3 >= INSTANCE_OF
						&& LA15_3 <= TYPES || LA15_3 >= SUBCLASS_OF
						&& LA15_3 <= RANGE || LA15_3 == OR
						|| LA15_3 >= CLOSED_PARENTHESYS && LA15_3 <= ONLY
						|| LA15_3 >= MIN && LA15_3 <= EXACTLY
						|| LA15_3 == COMMA || LA15_3 >= VALUE
						&& LA15_3 <= DBLQUOTE || LA15_3 == VARIABLE_NAME
						|| LA15_3 == CLOSED_SQUARE_BRACKET || LA15_3 == WHERE
						|| LA15_3 == END || LA15_3 == ESCLAMATION_MARK) {
					alt15 = 3;
				} else {
					if (this.state.backtracking > 0) {
						this.state.failed = true;
						return retval;
					}
					NoViableAltException nvae = new NoViableAltException("",
							15, 3, this.input);
					throw nvae;
				}
			}
				break;
			case ESCLAMATION_MARK: {
				alt15 = 4;
			}
				break;
			default:
				if (this.state.backtracking > 0) {
					this.state.failed = true;
					return retval;
				}
				NoViableAltException nvae = new NoViableAltException("", 15, 0,
						this.input);
				throw nvae;
			}
			switch (alt15) {
			case 1:
				// /Users/luigi/Documents/workspace/PARSERS/src/OPPLParser.g:123:3:
				// IDENTIFIER
			{
				root_0 = (OPPLSyntaxTree) this.adaptor.nil();
				IDENTIFIER77 = (Token) this.match(this.input, IDENTIFIER,
						FOLLOW_IDENTIFIER_in_atomic966);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					IDENTIFIER77_tree = (OPPLSyntaxTree) this.adaptor
							.create(IDENTIFIER77);
					this.adaptor.addChild(root_0, IDENTIFIER77_tree);
				}
			}
				break;
			case 2:
				// /Users/luigi/Documents/workspace/PARSERS/src/OPPLParser.g:124:5:
				// ENTITY_REFERENCE
			{
				ENTITY_REFERENCE78 = (Token) this.match(this.input,
						ENTITY_REFERENCE, FOLLOW_ENTITY_REFERENCE_in_atomic973);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_ENTITY_REFERENCE.add(ENTITY_REFERENCE78);
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
							this.adaptor, "rule retval",
							retval != null ? retval.tree : null);
					root_0 = (OPPLSyntaxTree) this.adaptor.nil();
					// 124:22: -> ^( ENTITY_REFERENCE )
					{
						// /Users/luigi/Documents/workspace/PARSERS/src/OPPLParser.g:124:25:
						// ^( ENTITY_REFERENCE )
						{
							OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor
									.nil();
							root_1 = (OPPLSyntaxTree) this.adaptor.becomeRoot(
									stream_ENTITY_REFERENCE.nextNode(), root_1);
							this.adaptor.addChild(root_0, root_1);
						}
					}
					retval.tree = root_0;
				}
			}
				break;
			case 3:
				// /Users/luigi/Documents/workspace/PARSERS/src/OPPLParser.g:125:5:
				// VARIABLE_NAME
			{
				VARIABLE_NAME79 = (Token) this.match(this.input, VARIABLE_NAME,
						FOLLOW_VARIABLE_NAME_in_atomic985);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_VARIABLE_NAME.add(VARIABLE_NAME79);
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
					// 125:19: -> ^( IDENTIFIER[$VARIABLE_NAME] )
					{
						// /Users/luigi/Documents/workspace/PARSERS/src/OPPLParser.g:125:22:
						// ^( IDENTIFIER[$VARIABLE_NAME] )
						{
							OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor
									.nil();
							root_1 = (OPPLSyntaxTree) this.adaptor.becomeRoot(
									this.adaptor.create(IDENTIFIER,
											VARIABLE_NAME79), root_1);
							this.adaptor.addChild(root_0, root_1);
						}
					}
					retval.tree = root_0;
				}
			}
				break;
			case 4:
				// /Users/luigi/Documents/workspace/PARSERS/src/OPPLParser.g:126:8:
				// createIdentifier
			{
				this.pushFollow(FOLLOW_createIdentifier_in_atomic1006);
				createIdentifier80 = this.createIdentifier();
				this.state._fsp--;
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_createIdentifier.add(createIdentifier80.getTree());
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
							this.adaptor, "rule retval",
							retval != null ? retval.tree : null);
					root_0 = (OPPLSyntaxTree) this.adaptor.nil();
					// 126:25: -> ^( createIdentifier )
					{
						// /Users/luigi/Documents/workspace/PARSERS/src/OPPLParser.g:126:28:
						// ^( createIdentifier )
						{
							OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor
									.nil();
							root_1 = (OPPLSyntaxTree) this.adaptor.becomeRoot(
									stream_createIdentifier.nextNode(), root_1);
							this.adaptor.addChild(root_0, root_1);
						}
					}
					retval.tree = root_0;
				}
			}
				break;
			case 5:
				// /Users/luigi/Documents/workspace/PARSERS/src/OPPLParser.g:127:5:
				// variableAttributeReference
			{
				this
						.pushFollow(FOLLOW_variableAttributeReference_in_atomic1018);
				variableAttributeReference81 = this
						.variableAttributeReference();
				this.state._fsp--;
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_variableAttributeReference
							.add(variableAttributeReference81.getTree());
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
							this.adaptor, "rule retval",
							retval != null ? retval.tree : null);
					root_0 = (OPPLSyntaxTree) this.adaptor.nil();
					// 127:32: -> ^( variableAttributeReference )
					{
						// /Users/luigi/Documents/workspace/PARSERS/src/OPPLParser.g:127:35:
						// ^( variableAttributeReference )
						{
							OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor
									.nil();
							root_1 = (OPPLSyntaxTree) this.adaptor.becomeRoot(
									stream_variableAttributeReference
											.nextNode(), root_1);
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
		} catch (RecognitionException e) {
			throw e;
		} finally {
		}
		return retval;
	}

	// $ANTLR end "atomic"
	public static class createIdentifier_return extends ParserRuleReturnScope {
		OPPLSyntaxTree tree;

		@Override
		public Object getTree() {
			return this.tree;
		}
	};

	// $ANTLR start "createIdentifier"
	// /Users/luigi/Documents/workspace/PARSERS/src/OPPLParser.g:131:1:
	// createIdentifier : ESCLAMATION_MARK IDENTIFIER -> ^(
	// IDENTIFIER[$ESCLAMATION_MARK.getText()+ $IDENTIFIER.getText()] ) ;
	public final OPPLParser.createIdentifier_return createIdentifier()
			throws RecognitionException {
		OPPLParser.createIdentifier_return retval = new OPPLParser.createIdentifier_return();
		retval.start = this.input.LT(1);
		OPPLSyntaxTree root_0 = null;
		Token ESCLAMATION_MARK82 = null;
		Token IDENTIFIER83 = null;
		OPPLSyntaxTree ESCLAMATION_MARK82_tree = null;
		OPPLSyntaxTree IDENTIFIER83_tree = null;
		RewriteRuleTokenStream stream_ESCLAMATION_MARK = new RewriteRuleTokenStream(
				this.adaptor, "token ESCLAMATION_MARK");
		RewriteRuleTokenStream stream_IDENTIFIER = new RewriteRuleTokenStream(
				this.adaptor, "token IDENTIFIER");
		try {
			// /Users/luigi/Documents/workspace/PARSERS/src/OPPLParser.g:132:3:
			// ( ESCLAMATION_MARK IDENTIFIER -> ^(
			// IDENTIFIER[$ESCLAMATION_MARK.getText()+ $IDENTIFIER.getText()] )
			// )
			// /Users/luigi/Documents/workspace/PARSERS/src/OPPLParser.g:133:4:
			// ESCLAMATION_MARK IDENTIFIER
			{
				ESCLAMATION_MARK82 = (Token) this.match(this.input,
						ESCLAMATION_MARK,
						FOLLOW_ESCLAMATION_MARK_in_createIdentifier1042);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_ESCLAMATION_MARK.add(ESCLAMATION_MARK82);
				}
				IDENTIFIER83 = (Token) this.match(this.input, IDENTIFIER,
						FOLLOW_IDENTIFIER_in_createIdentifier1044);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_IDENTIFIER.add(IDENTIFIER83);
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
							this.adaptor, "rule retval",
							retval != null ? retval.tree : null);
					root_0 = (OPPLSyntaxTree) this.adaptor.nil();
					// 133:33: -> ^( IDENTIFIER[$ESCLAMATION_MARK.getText()+
					// $IDENTIFIER.getText()] )
					{
						// /Users/luigi/Documents/workspace/PARSERS/src/OPPLParser.g:133:36:
						// ^( IDENTIFIER[$ESCLAMATION_MARK.getText()+
						// $IDENTIFIER.getText()] )
						{
							OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor
									.nil();
							root_1 = (OPPLSyntaxTree) this.adaptor.becomeRoot(
									this.adaptor.create(IDENTIFIER,
											ESCLAMATION_MARK82.getText()
													+ IDENTIFIER83.getText()),
									root_1);
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
		} catch (RecognitionException e) {
			throw e;
		} finally {
		}
		return retval;
	}

	// $ANTLR end "createIdentifier"
	public static class variableAttributeReference_return extends
			ParserRuleReturnScope {
		OPPLSyntaxTree tree;

		@Override
		public Object getTree() {
			return this.tree;
		}
	};

	// $ANTLR start "variableAttributeReference"
	// /Users/luigi/Documents/workspace/PARSERS/src/OPPLParser.g:136:1:
	// variableAttributeReference : ( VARIABLE_NAME DOT (a= VALUES | a=
	// RENDERING ) -> ^( IDENTIFIER[$VARIABLE_NAME.getText()+$DOT.getText() +
	// $a.getText()] VARIABLE_NAME DOT $a) | VARIABLE_NAME DOT GROUPS
	// attributeSelector -> ^(
	// IDENTIFIER[$VARIABLE_NAME.getText()+$DOT.getText() +
	// $GROUPS.getText()+$attributeSelector.selectorText] VARIABLE_NAME DOT
	// GROUPS attributeSelector ) );
	public final OPPLParser.variableAttributeReference_return variableAttributeReference()
			throws RecognitionException {
		OPPLParser.variableAttributeReference_return retval = new OPPLParser.variableAttributeReference_return();
		retval.start = this.input.LT(1);
		OPPLSyntaxTree root_0 = null;
		Token a = null;
		Token VARIABLE_NAME84 = null;
		Token DOT85 = null;
		Token VARIABLE_NAME86 = null;
		Token DOT87 = null;
		Token GROUPS88 = null;
		OPPLParser.attributeSelector_return attributeSelector89 = null;
		OPPLSyntaxTree a_tree = null;
		OPPLSyntaxTree VARIABLE_NAME84_tree = null;
		OPPLSyntaxTree DOT85_tree = null;
		OPPLSyntaxTree VARIABLE_NAME86_tree = null;
		OPPLSyntaxTree DOT87_tree = null;
		OPPLSyntaxTree GROUPS88_tree = null;
		RewriteRuleTokenStream stream_VARIABLE_NAME = new RewriteRuleTokenStream(
				this.adaptor, "token VARIABLE_NAME");
		RewriteRuleTokenStream stream_DOT = new RewriteRuleTokenStream(
				this.adaptor, "token DOT");
		RewriteRuleTokenStream stream_RENDERING = new RewriteRuleTokenStream(
				this.adaptor, "token RENDERING");
		RewriteRuleTokenStream stream_GROUPS = new RewriteRuleTokenStream(
				this.adaptor, "token GROUPS");
		RewriteRuleTokenStream stream_VALUES = new RewriteRuleTokenStream(
				this.adaptor, "token VALUES");
		RewriteRuleSubtreeStream stream_attributeSelector = new RewriteRuleSubtreeStream(
				this.adaptor, "rule attributeSelector");
		try {
			// /Users/luigi/Documents/workspace/PARSERS/src/OPPLParser.g:137:3:
			// ( VARIABLE_NAME DOT (a= VALUES | a= RENDERING ) -> ^(
			// IDENTIFIER[$VARIABLE_NAME.getText()+$DOT.getText() +
			// $a.getText()] VARIABLE_NAME DOT $a) | VARIABLE_NAME DOT GROUPS
			// attributeSelector -> ^(
			// IDENTIFIER[$VARIABLE_NAME.getText()+$DOT.getText() +
			// $GROUPS.getText()+$attributeSelector.selectorText] VARIABLE_NAME
			// DOT GROUPS attributeSelector ) )
			int alt17 = 2;
			int LA17_0 = this.input.LA(1);
			if (LA17_0 == VARIABLE_NAME) {
				int LA17_1 = this.input.LA(2);
				if (LA17_1 == DOT) {
					int LA17_2 = this.input.LA(3);
					if (LA17_2 == GROUPS) {
						alt17 = 2;
					} else if (LA17_2 >= VALUES && LA17_2 <= RENDERING) {
						alt17 = 1;
					} else {
						if (this.state.backtracking > 0) {
							this.state.failed = true;
							return retval;
						}
						NoViableAltException nvae = new NoViableAltException(
								"", 17, 2, this.input);
						throw nvae;
					}
				} else {
					if (this.state.backtracking > 0) {
						this.state.failed = true;
						return retval;
					}
					NoViableAltException nvae = new NoViableAltException("",
							17, 1, this.input);
					throw nvae;
				}
			} else {
				if (this.state.backtracking > 0) {
					this.state.failed = true;
					return retval;
				}
				NoViableAltException nvae = new NoViableAltException("", 17, 0,
						this.input);
				throw nvae;
			}
			switch (alt17) {
			case 1:
				// /Users/luigi/Documents/workspace/PARSERS/src/OPPLParser.g:138:5:
				// VARIABLE_NAME DOT (a= VALUES | a= RENDERING )
			{
				VARIABLE_NAME84 = (Token) this.match(this.input, VARIABLE_NAME,
						FOLLOW_VARIABLE_NAME_in_variableAttributeReference1071);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_VARIABLE_NAME.add(VARIABLE_NAME84);
				}
				DOT85 = (Token) this.match(this.input, DOT,
						FOLLOW_DOT_in_variableAttributeReference1073);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_DOT.add(DOT85);
				}
				// /Users/luigi/Documents/workspace/PARSERS/src/OPPLParser.g:138:23:
				// (a= VALUES | a= RENDERING )
				int alt16 = 2;
				int LA16_0 = this.input.LA(1);
				if (LA16_0 == VALUES) {
					alt16 = 1;
				} else if (LA16_0 == RENDERING) {
					alt16 = 2;
				} else {
					if (this.state.backtracking > 0) {
						this.state.failed = true;
						return retval;
					}
					NoViableAltException nvae = new NoViableAltException("",
							16, 0, this.input);
					throw nvae;
				}
				switch (alt16) {
				case 1:
					// /Users/luigi/Documents/workspace/PARSERS/src/OPPLParser.g:138:24:
					// a= VALUES
				{
					a = (Token) this.match(this.input, VALUES,
							FOLLOW_VALUES_in_variableAttributeReference1080);
					if (this.state.failed) {
						return retval;
					}
					if (this.state.backtracking == 0) {
						stream_VALUES.add(a);
					}
				}
					break;
				case 2:
					// /Users/luigi/Documents/workspace/PARSERS/src/OPPLParser.g:138:37:
					// a= RENDERING
				{
					a = (Token) this.match(this.input, RENDERING,
							FOLLOW_RENDERING_in_variableAttributeReference1088);
					if (this.state.failed) {
						return retval;
					}
					if (this.state.backtracking == 0) {
						stream_RENDERING.add(a);
					}
				}
					break;
				}
				// AST REWRITE
				// elements: VARIABLE_NAME, DOT, a
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
					// 138:54: -> ^(
					// IDENTIFIER[$VARIABLE_NAME.getText()+$DOT.getText() +
					// $a.getText()] VARIABLE_NAME DOT $a)
					{
						// /Users/luigi/Documents/workspace/PARSERS/src/OPPLParser.g:138:56:
						// ^( IDENTIFIER[$VARIABLE_NAME.getText()+$DOT.getText()
						// + $a.getText()] VARIABLE_NAME DOT $a)
						{
							OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor
									.nil();
							root_1 = (OPPLSyntaxTree) this.adaptor.becomeRoot(
									this.adaptor.create(IDENTIFIER,
											VARIABLE_NAME84.getText()
													+ DOT85.getText()
													+ a.getText()), root_1);
							this.adaptor.addChild(root_1, stream_VARIABLE_NAME
									.nextNode());
							this.adaptor
									.addChild(root_1, stream_DOT.nextNode());
							this.adaptor.addChild(root_1, stream_a.nextNode());
							this.adaptor.addChild(root_0, root_1);
						}
					}
					retval.tree = root_0;
				}
			}
				break;
			case 2:
				// /Users/luigi/Documents/workspace/PARSERS/src/OPPLParser.g:139:7:
				// VARIABLE_NAME DOT GROUPS attributeSelector
			{
				VARIABLE_NAME86 = (Token) this.match(this.input, VARIABLE_NAME,
						FOLLOW_VARIABLE_NAME_in_variableAttributeReference1112);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_VARIABLE_NAME.add(VARIABLE_NAME86);
				}
				DOT87 = (Token) this.match(this.input, DOT,
						FOLLOW_DOT_in_variableAttributeReference1114);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_DOT.add(DOT87);
				}
				GROUPS88 = (Token) this.match(this.input, GROUPS,
						FOLLOW_GROUPS_in_variableAttributeReference1116);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_GROUPS.add(GROUPS88);
				}
				this
						.pushFollow(FOLLOW_attributeSelector_in_variableAttributeReference1118);
				attributeSelector89 = this.attributeSelector();
				this.state._fsp--;
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_attributeSelector.add(attributeSelector89.getTree());
				}
				// AST REWRITE
				// elements: DOT, VARIABLE_NAME, attributeSelector, GROUPS
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
					// 139:51: -> ^(
					// IDENTIFIER[$VARIABLE_NAME.getText()+$DOT.getText() +
					// $GROUPS.getText()+$attributeSelector.selectorText]
					// VARIABLE_NAME DOT GROUPS attributeSelector )
					{
						// /Users/luigi/Documents/workspace/PARSERS/src/OPPLParser.g:139:53:
						// ^( IDENTIFIER[$VARIABLE_NAME.getText()+$DOT.getText()
						// + $GROUPS.getText()+$attributeSelector.selectorText]
						// VARIABLE_NAME DOT GROUPS attributeSelector )
						{
							OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor
									.nil();
							root_1 = (OPPLSyntaxTree) this.adaptor
									.becomeRoot(
											this.adaptor
													.create(
															IDENTIFIER,
															VARIABLE_NAME86
																	.getText()
																	+ DOT87
																			.getText()
																	+ GROUPS88
																			.getText()
																	+ (attributeSelector89 != null ? attributeSelector89.selectorText
																			: null)),
											root_1);
							this.adaptor.addChild(root_1, stream_VARIABLE_NAME
									.nextNode());
							this.adaptor
									.addChild(root_1, stream_DOT.nextNode());
							this.adaptor.addChild(root_1, stream_GROUPS
									.nextNode());
							this.adaptor.addChild(root_1,
									stream_attributeSelector.nextTree());
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
		} catch (RecognitionException e) {
			throw e;
		} finally {
		}
		return retval;
	}

	// $ANTLR end "variableAttributeReference"
	public static class attributeSelector_return extends ParserRuleReturnScope {
		public String selectorText;
		OPPLSyntaxTree tree;

		@Override
		public Object getTree() {
			return this.tree;
		}
	};

	// $ANTLR start "attributeSelector"
	// /Users/luigi/Documents/workspace/PARSERS/src/OPPLParser.g:144:1:
	// attributeSelector returns [String selectorText] : OPEN_PARENTHESYS i=
	// INTEGER CLOSED_PARENTHESYS -> ^( ATTRIBUTE_SELECTOR INTEGER ) ;
	public final OPPLParser.attributeSelector_return attributeSelector()
			throws RecognitionException {
		OPPLParser.attributeSelector_return retval = new OPPLParser.attributeSelector_return();
		retval.start = this.input.LT(1);
		OPPLSyntaxTree root_0 = null;
		Token i = null;
		Token OPEN_PARENTHESYS90 = null;
		Token CLOSED_PARENTHESYS91 = null;
		OPPLSyntaxTree i_tree = null;
		OPPLSyntaxTree OPEN_PARENTHESYS90_tree = null;
		OPPLSyntaxTree CLOSED_PARENTHESYS91_tree = null;
		RewriteRuleTokenStream stream_INTEGER = new RewriteRuleTokenStream(
				this.adaptor, "token INTEGER");
		RewriteRuleTokenStream stream_CLOSED_PARENTHESYS = new RewriteRuleTokenStream(
				this.adaptor, "token CLOSED_PARENTHESYS");
		RewriteRuleTokenStream stream_OPEN_PARENTHESYS = new RewriteRuleTokenStream(
				this.adaptor, "token OPEN_PARENTHESYS");
		try {
			// /Users/luigi/Documents/workspace/PARSERS/src/OPPLParser.g:145:3:
			// ( OPEN_PARENTHESYS i= INTEGER CLOSED_PARENTHESYS -> ^(
			// ATTRIBUTE_SELECTOR INTEGER ) )
			// /Users/luigi/Documents/workspace/PARSERS/src/OPPLParser.g:146:5:
			// OPEN_PARENTHESYS i= INTEGER CLOSED_PARENTHESYS
			{
				OPEN_PARENTHESYS90 = (Token) this.match(this.input,
						OPEN_PARENTHESYS,
						FOLLOW_OPEN_PARENTHESYS_in_attributeSelector1167);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_OPEN_PARENTHESYS.add(OPEN_PARENTHESYS90);
				}
				i = (Token) this.match(this.input, INTEGER,
						FOLLOW_INTEGER_in_attributeSelector1173);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_INTEGER.add(i);
				}
				CLOSED_PARENTHESYS91 = (Token) this.match(this.input,
						CLOSED_PARENTHESYS,
						FOLLOW_CLOSED_PARENTHESYS_in_attributeSelector1175);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_CLOSED_PARENTHESYS.add(CLOSED_PARENTHESYS91);
				}
				if (this.state.backtracking == 0) {
					retval.selectorText = OPEN_PARENTHESYS90.getText()
							+ i.getText() + CLOSED_PARENTHESYS91.getText();
				}
				// AST REWRITE
				// elements: INTEGER
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
					// 150:5: -> ^( ATTRIBUTE_SELECTOR INTEGER )
					{
						// /Users/luigi/Documents/workspace/PARSERS/src/OPPLParser.g:150:9:
						// ^( ATTRIBUTE_SELECTOR INTEGER )
						{
							OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor
									.nil();
							root_1 = (OPPLSyntaxTree) this.adaptor.becomeRoot(
									this.adaptor.create(ATTRIBUTE_SELECTOR,
											"ATTRIBUTE_SELECTOR"), root_1);
							this.adaptor.addChild(root_1, stream_INTEGER
									.nextNode());
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
		} catch (RecognitionException e) {
			throw e;
		} finally {
		}
		return retval;
	}

	// $ANTLR end "attributeSelector"
	// Delegated rules
	public OPPLParser_MOWLParser.assertionAxiom_return assertionAxiom()
			throws RecognitionException {
		return this.gMOWLParser.assertionAxiom();
	}

	public OPPLParser_MOWLParser.unary_return unary()
			throws RecognitionException {
		return this.gMOWLParser.unary();
	}

	public OPPLParser_MOWLParser.valueRestriction_return valueRestriction()
			throws RecognitionException {
		return this.gMOWLParser.valueRestriction();
	}

	public OPPLParser_MOWLParser.value_return value()
			throws RecognitionException {
		return this.gMOWLParser.value();
	}

	public OPPLParser_MOWLParser.restrictionKind_return restrictionKind()
			throws RecognitionException {
		return this.gMOWLParser.restrictionKind();
	}

	public OPPLParser_MOWLParser.propertyExpression_return propertyExpression()
			throws RecognitionException {
		return this.gMOWLParser.propertyExpression();
	}

	public OPPLParser_MOWLParser.qualifiedRestriction_return qualifiedRestriction()
			throws RecognitionException {
		return this.gMOWLParser.qualifiedRestriction();
	}

	public OPPLParser_MOWLParser.axiom_return axiom()
			throws RecognitionException {
		return this.gMOWLParser.axiom();
	}

	public OPPLParser_MOWLParser.conjunction_return conjunction()
			throws RecognitionException {
		return this.gMOWLParser.conjunction();
	}

	public OPPLParser_MOWLParser.oneOf_return oneOf()
			throws RecognitionException {
		return this.gMOWLParser.oneOf();
	}

	public OPPLParser_MOWLParser.constant_return constant()
			throws RecognitionException {
		return this.gMOWLParser.constant();
	}

	public OPPLParser_MOWLParser.unaryAxiom_return unaryAxiom()
			throws RecognitionException {
		return this.gMOWLParser.unaryAxiom();
	}

	public OPPLParser_MOWLParser.unaryCharacteristic_return unaryCharacteristic()
			throws RecognitionException {
		return this.gMOWLParser.unaryCharacteristic();
	}

	public OPPLParser_MOWLParser.complexPropertyExpression_return complexPropertyExpression()
			throws RecognitionException {
		return this.gMOWLParser.complexPropertyExpression();
	}

	public OPPLParser_MOWLParser.expression_return expression()
			throws RecognitionException {
		return this.gMOWLParser.expression();
	}

	public OPPLParser_MOWLParser.binaryAxiom_return binaryAxiom()
			throws RecognitionException {
		return this.gMOWLParser.binaryAxiom();
	}

	public OPPLParser_MOWLParser.cardinalityRestriction_return cardinalityRestriction()
			throws RecognitionException {
		return this.gMOWLParser.cardinalityRestriction();
	}

	public static final BitSet FOLLOW_variableDefinition_in_variableDefinitions216 = new BitSet(
			new long[] { 0x2000000000000002L });
	public static final BitSet FOLLOW_COMMA_in_variableDefinitions219 = new BitSet(
			new long[] { 0x0000000000000000L, 0x0000000000080000L });
	public static final BitSet FOLLOW_variableDefinition_in_variableDefinitions221 = new BitSet(
			new long[] { 0x2000000000000002L });
	public static final BitSet FOLLOW_VARIABLE_NAME_in_variableDefinition255 = new BitSet(
			new long[] { 0x0000000000000000L, 0x0000000000100000L });
	public static final BitSet FOLLOW_COLON_in_variableDefinition257 = new BitSet(
			new long[] { 0x0000000000000000L, 0x0000000000200000L });
	public static final BitSet FOLLOW_VARIABLE_TYPE_in_variableDefinition259 = new BitSet(
			new long[] { 0x0000000000000000L, 0x0000000000400000L });
	public static final BitSet FOLLOW_EQUAL_in_variableDefinition262 = new BitSet(
			new long[] { 0x0000000000000000L, 0x0000038000000000L });
	public static final BitSet FOLLOW_opplFunction_in_variableDefinition264 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_VARIABLE_NAME_in_variableDefinition292 = new BitSet(
			new long[] { 0x0000000000000000L, 0x0000000000100000L });
	public static final BitSet FOLLOW_COLON_in_variableDefinition294 = new BitSet(
			new long[] { 0x0000000000000000L, 0x0000000000200000L });
	public static final BitSet FOLLOW_VARIABLE_TYPE_in_variableDefinition296 = new BitSet(
			new long[] { 0x0000000000000000L, 0x0000000000400000L });
	public static final BitSet FOLLOW_EQUAL_in_variableDefinition299 = new BitSet(
			new long[] { 0x1034800020000000L, 0x0000080000080001L });
	public static final BitSet FOLLOW_expression_in_variableDefinition301 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_VARIABLE_NAME_in_variableDefinition325 = new BitSet(
			new long[] { 0x0000000000000000L, 0x0000000000100000L });
	public static final BitSet FOLLOW_COLON_in_variableDefinition327 = new BitSet(
			new long[] { 0x0000000000000000L, 0x0000000000200000L });
	public static final BitSet FOLLOW_VARIABLE_TYPE_in_variableDefinition329 = new BitSet(
			new long[] { 0x0000000000000000L, 0x0000000000400000L });
	public static final BitSet FOLLOW_EQUAL_in_variableDefinition332 = new BitSet(
			new long[] { 0x0000000000000000L, 0x0000000000800000L });
	public static final BitSet FOLLOW_MATCH_in_variableDefinition334 = new BitSet(
			new long[] { 0x0000800000000000L });
	public static final BitSet FOLLOW_OPEN_PARENTHESYS_in_variableDefinition336 = new BitSet(
			new long[] { 0x0030000000000000L, 0x0000080000080001L });
	public static final BitSet FOLLOW_stringOperation_in_variableDefinition338 = new BitSet(
			new long[] { 0x0001000000000000L });
	public static final BitSet FOLLOW_CLOSED_PARENTHESYS_in_variableDefinition340 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_VARIABLE_NAME_in_variableDefinition364 = new BitSet(
			new long[] { 0x0000000000000000L, 0x0000000000100000L });
	public static final BitSet FOLLOW_COLON_in_variableDefinition366 = new BitSet(
			new long[] { 0x0000000000000000L, 0x0000000000200000L });
	public static final BitSet FOLLOW_VARIABLE_TYPE_in_variableDefinition368 = new BitSet(
			new long[] { 0x0000000000000002L, 0x0000000001000000L });
	public static final BitSet FOLLOW_variableScope_in_variableDefinition371 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_OPEN_SQUARE_BRACKET_in_variableScope411 = new BitSet(
			new long[] { 0x0000000058000000L, 0x000000000E000000L });
	public static final BitSet FOLLOW_SUBCLASS_OF_in_variableScope418 = new BitSet(
			new long[] { 0x1034800020000000L, 0x0000080010080001L });
	public static final BitSet FOLLOW_SUBPROPERTY_OF_in_variableScope426 = new BitSet(
			new long[] { 0x1034800020000000L, 0x0000080010080001L });
	public static final BitSet FOLLOW_SUPER_CLASS_OF_in_variableScope434 = new BitSet(
			new long[] { 0x1034800020000000L, 0x0000080010080001L });
	public static final BitSet FOLLOW_SUPER_PROPERTY_OF_in_variableScope442 = new BitSet(
			new long[] { 0x1034800020000000L, 0x0000080010080001L });
	public static final BitSet FOLLOW_INSTANCE_OF_in_variableScope451 = new BitSet(
			new long[] { 0x1034800020000000L, 0x0000080010080001L });
	public static final BitSet FOLLOW_TYPES_in_variableScope459 = new BitSet(
			new long[] { 0x1034800020000000L, 0x0000080010080001L });
	public static final BitSet FOLLOW_expression_in_variableScope462 = new BitSet(
			new long[] { 0x0000000000000000L, 0x0000000010000000L });
	public static final BitSet FOLLOW_CLOSED_SQUARE_BRACKET_in_variableScope464 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_SELECT_in_query500 = new BitSet(
			new long[] { 0x1034BF83E0000000L, 0x0000080080080001L });
	public static final BitSet FOLLOW_selectClause_in_query502 = new BitSet(
			new long[] { 0x2000000000000002L, 0x0000000040000000L });
	public static final BitSet FOLLOW_COMMA_in_query505 = new BitSet(
			new long[] { 0x1034BF83E0000000L, 0x0000080080080001L });
	public static final BitSet FOLLOW_selectClause_in_query507 = new BitSet(
			new long[] { 0x2000000000000002L, 0x0000000040000000L });
	public static final BitSet FOLLOW_WHERE_in_query512 = new BitSet(
			new long[] { 0x0000000000000000L, 0x0000000400080000L });
	public static final BitSet FOLLOW_constraint_in_query514 = new BitSet(
			new long[] { 0x2000000000000002L });
	public static final BitSet FOLLOW_COMMA_in_query517 = new BitSet(
			new long[] { 0x0000000000000000L, 0x0000000400080000L });
	public static final BitSet FOLLOW_constraint_in_query519 = new BitSet(
			new long[] { 0x2000000000000002L });
	public static final BitSet FOLLOW_ASSERTED_in_selectClause556 = new BitSet(
			new long[] { 0x1034BF83E0000000L, 0x0000080080080001L });
	public static final BitSet FOLLOW_axiom_in_selectClause558 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_axiom_in_selectClause574 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_VARIABLE_NAME_in_constraint613 = new BitSet(
			new long[] { 0x0000000000000000L, 0x0000000100000000L });
	public static final BitSet FOLLOW_NOT_EQUAL_in_constraint615 = new BitSet(
			new long[] { 0x1034800020000000L, 0x0000080000080001L });
	public static final BitSet FOLLOW_expression_in_constraint621 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_VARIABLE_NAME_in_constraint646 = new BitSet(
			new long[] { 0x0000000000000000L, 0x0000000200000000L });
	public static final BitSet FOLLOW_IN_in_constraint648 = new BitSet(
			new long[] { 0x1000000000000000L });
	public static final BitSet FOLLOW_oneOf_in_constraint650 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_VARIABLE_NAME_in_constraint670 = new BitSet(
			new long[] { 0x0000000000000000L, 0x0000000000800000L });
	public static final BitSet FOLLOW_MATCH_in_constraint672 = new BitSet(
			new long[] { 0x0000800000000000L });
	public static final BitSet FOLLOW_OPEN_PARENTHESYS_in_constraint674 = new BitSet(
			new long[] { 0x0030000000000000L, 0x0000080000080001L });
	public static final BitSet FOLLOW_stringOperation_in_constraint676 = new BitSet(
			new long[] { 0x0001000000000000L });
	public static final BitSet FOLLOW_CLOSED_PARENTHESYS_in_constraint678 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_FAIL_in_constraint697 = new BitSet(
			new long[] { 0x1034BF83E0000000L, 0x0000080080080001L });
	public static final BitSet FOLLOW_axiom_in_constraint699 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_BEGIN_in_actions727 = new BitSet(
			new long[] { 0x0000000000000000L, 0x0000006000000000L });
	public static final BitSet FOLLOW_action_in_actions729 = new BitSet(
			new long[] { 0x2000000000000000L, 0x0000001000000000L });
	public static final BitSet FOLLOW_COMMA_in_actions732 = new BitSet(
			new long[] { 0x0000000000000000L, 0x0000006000000000L });
	public static final BitSet FOLLOW_action_in_actions734 = new BitSet(
			new long[] { 0x2000000000000000L, 0x0000001000000000L });
	public static final BitSet FOLLOW_END_in_actions738 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_ADD_in_action770 = new BitSet(new long[] {
			0x1034BF83E0000000L, 0x0000080080080001L });
	public static final BitSet FOLLOW_axiom_in_action772 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_REMOVE_in_action788 = new BitSet(
			new long[] { 0x1034BF83E0000000L, 0x0000080080080001L });
	public static final BitSet FOLLOW_axiom_in_action790 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_CREATE_in_opplFunction823 = new BitSet(
			new long[] { 0x0000800000000000L });
	public static final BitSet FOLLOW_OPEN_PARENTHESYS_in_opplFunction825 = new BitSet(
			new long[] { 0x0030000000000000L, 0x0000080000080001L });
	public static final BitSet FOLLOW_stringOperation_in_opplFunction827 = new BitSet(
			new long[] { 0x0001000000000000L });
	public static final BitSet FOLLOW_CLOSED_PARENTHESYS_in_opplFunction829 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_CREATE_INTERSECTION_in_opplFunction845 = new BitSet(
			new long[] { 0x0000800000000000L });
	public static final BitSet FOLLOW_OPEN_PARENTHESYS_in_opplFunction848 = new BitSet(
			new long[] { 0x0030000000000000L, 0x0000080000080000L });
	public static final BitSet FOLLOW_atomic_in_opplFunction850 = new BitSet(
			new long[] { 0x0001000000000000L });
	public static final BitSet FOLLOW_CLOSED_PARENTHESYS_in_opplFunction853 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_CREATE_DISJUNCTION_in_opplFunction869 = new BitSet(
			new long[] { 0x0000800000000000L });
	public static final BitSet FOLLOW_OPEN_PARENTHESYS_in_opplFunction871 = new BitSet(
			new long[] { 0x0030000000000000L, 0x0000080000080000L });
	public static final BitSet FOLLOW_atomic_in_opplFunction873 = new BitSet(
			new long[] { 0x0001000000000000L });
	public static final BitSet FOLLOW_CLOSED_PARENTHESYS_in_opplFunction875 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_stringExpression_in_stringOperation900 = new BitSet(
			new long[] { 0x0000000000000002L, 0x0000040000000000L });
	public static final BitSet FOLLOW_PLUS_in_stringOperation903 = new BitSet(
			new long[] { 0x0030000000000000L, 0x0000080000080001L });
	public static final BitSet FOLLOW_stringExpression_in_stringOperation905 = new BitSet(
			new long[] { 0x0000000000000002L, 0x0000040000000000L });
	public static final BitSet FOLLOW_DBLQUOTE_in_stringExpression932 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_variableAttributeReference_in_stringExpression947 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_IDENTIFIER_in_atomic966 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_ENTITY_REFERENCE_in_atomic973 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_VARIABLE_NAME_in_atomic985 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_createIdentifier_in_atomic1006 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_variableAttributeReference_in_atomic1018 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_ESCLAMATION_MARK_in_createIdentifier1042 = new BitSet(
			new long[] { 0x0010000000000000L });
	public static final BitSet FOLLOW_IDENTIFIER_in_createIdentifier1044 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_VARIABLE_NAME_in_variableAttributeReference1071 = new BitSet(
			new long[] { 0x0000000000000000L, 0x0000100000000000L });
	public static final BitSet FOLLOW_DOT_in_variableAttributeReference1073 = new BitSet(
			new long[] { 0x0000000000000000L, 0x0000600000000000L });
	public static final BitSet FOLLOW_VALUES_in_variableAttributeReference1080 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_RENDERING_in_variableAttributeReference1088 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_VARIABLE_NAME_in_variableAttributeReference1112 = new BitSet(
			new long[] { 0x0000000000000000L, 0x0000100000000000L });
	public static final BitSet FOLLOW_DOT_in_variableAttributeReference1114 = new BitSet(
			new long[] { 0x0000000000000000L, 0x0000800000000000L });
	public static final BitSet FOLLOW_GROUPS_in_variableAttributeReference1116 = new BitSet(
			new long[] { 0x0000800000000000L });
	public static final BitSet FOLLOW_attributeSelector_in_variableAttributeReference1118 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_OPEN_PARENTHESYS_in_attributeSelector1167 = new BitSet(
			new long[] { 0x0100000000000000L });
	public static final BitSet FOLLOW_INTEGER_in_attributeSelector1173 = new BitSet(
			new long[] { 0x0001000000000000L });
	public static final BitSet FOLLOW_CLOSED_PARENTHESYS_in_attributeSelector1175 = new BitSet(
			new long[] { 0x0000000000000002L });
}