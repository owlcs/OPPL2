package org.coode.parsers.oppl.patterns;

// $ANTLR 3.2 Sep 23, 2009 12:02:23 OPPLParser.g 2010-08-27 12:09:15
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
import org.antlr.runtime.tree.RewriteEmptyStreamException;
import org.antlr.runtime.tree.RewriteRuleSubtreeStream;
import org.antlr.runtime.tree.RewriteRuleTokenStream;
import org.antlr.runtime.tree.TreeAdaptor;
import org.coode.parsers.oppl.OPPLSyntaxTree;

public class OPPLPatternParser_OPPLParser extends Parser {
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
	public static final int ARGUMENTS = 417;
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
	public static final int NAF_CONSTRAINT = 467;
	public static final int DBLQUOTE = 40;
	public static final int STRING_OPERATION = 394;
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
	public static final int OPPL_PATTERN = 419;
	public static final int VARIABLE_NAME = 464;
	public static final int THIS_CLASS = 416;
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
	public static final int PLAIN_CLAUSE = 93;
	public static final int Tokens = 47;
	public static final int DOMAIN = 27;
	public static final int SUBPROPERTY_OF = 105;
	public static final int OPPL_FUNCTION = 100;
	public static final int COLON = 77;
	public static final int DISJOINT_WITH_AXIOM = 50;
	public static final int CREATE_INTERSECTION = 81;
	public static final int HYPHEN = 465;
	public static final int INVERSE_FUNCTIONAL = 35;
	public static final int RENDERING = 355;
	public static final int VARIABLE_IDENTIFIER = 106;
	public static final int IRREFLEXIVE = 33;
	public static final int PLAIN_IDENTIFIER = 152;
	public static final int VARIABLE_ATTRIBUTE = 99;
	public static final int ASSERTED = 76;
	public static final int FUNCTIONAL = 29;
	public static final int PROPERTY_CHAIN = 57;
	public static final int PATTERN_REFERENCE = 421;
	public static final int TYPE_ASSERTION = 66;
	// delegates
	public OPPLPatternParser_OPPLParser_MOWLParser gMOWLParser;
	// delegators
	public OPPLPatternParser gOPPLPatternParser;
	public OPPLPatternParser gParent;

	public OPPLPatternParser_OPPLParser(TokenStream input,
			OPPLPatternParser gOPPLPatternParser) {
		this(input, new RecognizerSharedState(), gOPPLPatternParser);
	}

	public OPPLPatternParser_OPPLParser(TokenStream input,
			RecognizerSharedState state, OPPLPatternParser gOPPLPatternParser) {
		super(input, state);
		this.gOPPLPatternParser = gOPPLPatternParser;
		this.gMOWLParser = new OPPLPatternParser_OPPLParser_MOWLParser(input,
				state, gOPPLPatternParser, this);
		this.gParent = gOPPLPatternParser;
	}

	protected TreeAdaptor adaptor = new CommonTreeAdaptor();

	public void setTreeAdaptor(TreeAdaptor adaptor) {
		this.adaptor = adaptor;
		this.gMOWLParser.setTreeAdaptor(this.adaptor);
	}

	public TreeAdaptor getTreeAdaptor() {
		return this.adaptor;
	}

	public String[] getTokenNames() {
		return OPPLPatternParser.tokenNames;
	}

	public String getGrammarFileName() {
		return "OPPLParser.g";
	}

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

		public Object getTree() {
			return this.tree;
		}
	};

	// $ANTLR start "variableDefinitions"
	// OPPLParser.g:48:2: variableDefinitions : variableDefinition ( COMMA
	// variableDefinition )* -> ^( VARIABLE_DEFINITIONS ( variableDefinition )+
	// ) ;
	public final OPPLPatternParser_OPPLParser.variableDefinitions_return variableDefinitions()
			throws RecognitionException {
		OPPLPatternParser_OPPLParser.variableDefinitions_return retval = new OPPLPatternParser_OPPLParser.variableDefinitions_return();
		retval.start = this.input.LT(1);
		OPPLSyntaxTree root_0 = null;
		Token COMMA2 = null;
		OPPLPatternParser_OPPLParser.variableDefinition_return variableDefinition1 = null;
		OPPLPatternParser_OPPLParser.variableDefinition_return variableDefinition3 = null;
		OPPLSyntaxTree COMMA2_tree = null;
		RewriteRuleTokenStream stream_COMMA = new RewriteRuleTokenStream(
				this.adaptor, "token COMMA");
		RewriteRuleSubtreeStream stream_variableDefinition = new RewriteRuleSubtreeStream(
				this.adaptor, "rule variableDefinition");
		try {
			// OPPLParser.g:49:3: ( variableDefinition ( COMMA
			// variableDefinition )* -> ^( VARIABLE_DEFINITIONS (
			// variableDefinition )+ ) )
			// OPPLParser.g:50:5: variableDefinition ( COMMA variableDefinition
			// )*
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
				// OPPLParser.g:50:24: ( COMMA variableDefinition )*
				loop1: do {
					int alt1 = 2;
					int LA1_0 = this.input.LA(1);
					if (LA1_0 == COMMA) {
						alt1 = 1;
					}
					switch (alt1) {
					case 1:
						// OPPLParser.g:50:25: COMMA variableDefinition
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
					// 50:52: -> ^( VARIABLE_DEFINITIONS ( variableDefinition )+
					// )
					{
						// OPPLParser.g:50:55: ^( VARIABLE_DEFINITIONS (
						// variableDefinition )+ )
						{
							OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor
									.nil();
							root_1 = (OPPLSyntaxTree) this.adaptor.becomeRoot(
									(OPPLSyntaxTree) this.adaptor.create(
											VARIABLE_DEFINITIONS,
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
		} catch (RewriteEmptyStreamException e) {
			throw e;
		} finally {
		}
		return retval;
	}

	// $ANTLR end "variableDefinitions"
	public static class variableDefinition_return extends ParserRuleReturnScope {
		OPPLSyntaxTree tree;

		public Object getTree() {
			return this.tree;
		}
	};

	// $ANTLR start "variableDefinition"
	// OPPLParser.g:53:2: variableDefinition : ( VARIABLE_NAME COLON
	// VARIABLE_TYPE EQUAL opplFunction -> ^( GENERATED_VARIABLE_DEFINITION
	// VARIABLE_NAME VARIABLE_TYPE ^( opplFunction ) ) | VARIABLE_NAME COLON
	// VARIABLE_TYPE EQUAL expression -> ^( GENERATED_VARIABLE_DEFINITION
	// VARIABLE_NAME VARIABLE_TYPE ^( EXPRESSION expression ) ) | VARIABLE_NAME
	// COLON VARIABLE_TYPE EQUAL regexp -> ^( GENERATED_VARIABLE_DEFINITION
	// VARIABLE_NAME VARIABLE_TYPE regexp ) | VARIABLE_NAME COLON VARIABLE_TYPE
	// ( variableScope )? -> ^( INPUT_VARIABLE_DEFINITION VARIABLE_NAME
	// VARIABLE_TYPE ( variableScope )? ) );
	public final OPPLPatternParser_OPPLParser.variableDefinition_return variableDefinition()
			throws RecognitionException {
		OPPLPatternParser_OPPLParser.variableDefinition_return retval = new OPPLPatternParser_OPPLParser.variableDefinition_return();
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
		Token VARIABLE_NAME19 = null;
		Token COLON20 = null;
		Token VARIABLE_TYPE21 = null;
		OPPLPatternParser_OPPLParser.opplFunction_return opplFunction8 = null;
		OPPLPatternParser_OPPLParser_MOWLParser.expression_return expression13 = null;
		OPPLPatternParser_OPPLParser.regexp_return regexp18 = null;
		OPPLPatternParser_OPPLParser.variableScope_return variableScope22 = null;
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
		OPPLSyntaxTree VARIABLE_NAME19_tree = null;
		OPPLSyntaxTree COLON20_tree = null;
		OPPLSyntaxTree VARIABLE_TYPE21_tree = null;
		RewriteRuleTokenStream stream_COLON = new RewriteRuleTokenStream(
				this.adaptor, "token COLON");
		RewriteRuleTokenStream stream_VARIABLE_NAME = new RewriteRuleTokenStream(
				this.adaptor, "token VARIABLE_NAME");
		RewriteRuleTokenStream stream_VARIABLE_TYPE = new RewriteRuleTokenStream(
				this.adaptor, "token VARIABLE_TYPE");
		RewriteRuleTokenStream stream_EQUAL = new RewriteRuleTokenStream(
				this.adaptor, "token EQUAL");
		RewriteRuleSubtreeStream stream_expression = new RewriteRuleSubtreeStream(
				this.adaptor, "rule expression");
		RewriteRuleSubtreeStream stream_variableScope = new RewriteRuleSubtreeStream(
				this.adaptor, "rule variableScope");
		RewriteRuleSubtreeStream stream_opplFunction = new RewriteRuleSubtreeStream(
				this.adaptor, "rule opplFunction");
		RewriteRuleSubtreeStream stream_regexp = new RewriteRuleSubtreeStream(
				this.adaptor, "rule regexp");
		try {
			// OPPLParser.g:54:3: ( VARIABLE_NAME COLON VARIABLE_TYPE EQUAL
			// opplFunction -> ^( GENERATED_VARIABLE_DEFINITION VARIABLE_NAME
			// VARIABLE_TYPE ^( opplFunction ) ) | VARIABLE_NAME COLON
			// VARIABLE_TYPE EQUAL expression -> ^(
			// GENERATED_VARIABLE_DEFINITION VARIABLE_NAME VARIABLE_TYPE ^(
			// EXPRESSION expression ) ) | VARIABLE_NAME COLON VARIABLE_TYPE
			// EQUAL regexp -> ^( GENERATED_VARIABLE_DEFINITION VARIABLE_NAME
			// VARIABLE_TYPE regexp ) | VARIABLE_NAME COLON VARIABLE_TYPE (
			// variableScope )? -> ^( INPUT_VARIABLE_DEFINITION VARIABLE_NAME
			// VARIABLE_TYPE ( variableScope )? ) )
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
							case EOF:
							case OPEN_PARENTHESYS:
							case OPEN_CURLY_BRACES:
							case NOT:
							case INVERSE:
							case COMMA:
							case DBLQUOTE:
							case IDENTIFIER:
							case ENTITY_REFERENCE:
							case ESCLAMATION_MARK:
							case DOLLAR:
							case THIS_CLASS:
							case VARIABLE_NAME: {
								alt3 = 2;
							}
								break;
							case MATCH: {
								alt3 = 3;
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
				// OPPLParser.g:56:7: VARIABLE_NAME COLON VARIABLE_TYPE EQUAL
				// opplFunction
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
				// elements: opplFunction, VARIABLE_TYPE, VARIABLE_NAME
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
					// 56:61: -> ^( GENERATED_VARIABLE_DEFINITION VARIABLE_NAME
					// VARIABLE_TYPE ^( opplFunction ) )
					{
						// OPPLParser.g:56:64: ^( GENERATED_VARIABLE_DEFINITION
						// VARIABLE_NAME VARIABLE_TYPE ^( opplFunction ) )
						{
							OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor
									.nil();
							root_1 = (OPPLSyntaxTree) this.adaptor.becomeRoot(
									(OPPLSyntaxTree) this.adaptor.create(
											GENERATED_VARIABLE_DEFINITION,
											"GENERATED_VARIABLE_DEFINITION"),
									root_1);
							this.adaptor.addChild(root_1, stream_VARIABLE_NAME
									.nextNode());
							this.adaptor.addChild(root_1, stream_VARIABLE_TYPE
									.nextNode());
							// OPPLParser.g:56:124: ^( opplFunction )
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
				// OPPLParser.g:57:7: VARIABLE_NAME COLON VARIABLE_TYPE EQUAL
				// expression
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
				expression13 = this.gOPPLPatternParser.expression();
				this.state._fsp--;
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_expression.add(expression13.getTree());
				}
				// AST REWRITE
				// elements: VARIABLE_NAME, VARIABLE_TYPE, expression
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
					// 57:59: -> ^( GENERATED_VARIABLE_DEFINITION VARIABLE_NAME
					// VARIABLE_TYPE ^( EXPRESSION expression ) )
					{
						// OPPLParser.g:57:62: ^( GENERATED_VARIABLE_DEFINITION
						// VARIABLE_NAME VARIABLE_TYPE ^( EXPRESSION expression
						// ) )
						{
							OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor
									.nil();
							root_1 = (OPPLSyntaxTree) this.adaptor.becomeRoot(
									(OPPLSyntaxTree) this.adaptor.create(
											GENERATED_VARIABLE_DEFINITION,
											"GENERATED_VARIABLE_DEFINITION"),
									root_1);
							this.adaptor.addChild(root_1, stream_VARIABLE_NAME
									.nextNode());
							this.adaptor.addChild(root_1, stream_VARIABLE_TYPE
									.nextNode());
							// OPPLParser.g:57:122: ^( EXPRESSION expression )
							{
								OPPLSyntaxTree root_2 = (OPPLSyntaxTree) this.adaptor
										.nil();
								root_2 = (OPPLSyntaxTree) this.adaptor
										.becomeRoot(
												(OPPLSyntaxTree) this.adaptor
														.create(EXPRESSION,
																"EXPRESSION"),
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
				// OPPLParser.g:58:7: VARIABLE_NAME COLON VARIABLE_TYPE EQUAL
				// regexp
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
				this.pushFollow(FOLLOW_regexp_in_variableDefinition334);
				regexp18 = this.regexp();
				this.state._fsp--;
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_regexp.add(regexp18.getTree());
				}
				// AST REWRITE
				// elements: VARIABLE_TYPE, VARIABLE_NAME, regexp
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
					// 58:55: -> ^( GENERATED_VARIABLE_DEFINITION VARIABLE_NAME
					// VARIABLE_TYPE regexp )
					{
						// OPPLParser.g:58:58: ^( GENERATED_VARIABLE_DEFINITION
						// VARIABLE_NAME VARIABLE_TYPE regexp )
						{
							OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor
									.nil();
							root_1 = (OPPLSyntaxTree) this.adaptor.becomeRoot(
									(OPPLSyntaxTree) this.adaptor.create(
											GENERATED_VARIABLE_DEFINITION,
											"GENERATED_VARIABLE_DEFINITION"),
									root_1);
							this.adaptor.addChild(root_1, stream_VARIABLE_NAME
									.nextNode());
							this.adaptor.addChild(root_1, stream_VARIABLE_TYPE
									.nextNode());
							this.adaptor.addChild(root_1, stream_regexp
									.nextTree());
							this.adaptor.addChild(root_0, root_1);
						}
					}
					retval.tree = root_0;
				}
			}
				break;
			case 4:
				// OPPLParser.g:59:7: VARIABLE_NAME COLON VARIABLE_TYPE (
				// variableScope )?
			{
				VARIABLE_NAME19 = (Token) this.match(this.input, VARIABLE_NAME,
						FOLLOW_VARIABLE_NAME_in_variableDefinition354);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_VARIABLE_NAME.add(VARIABLE_NAME19);
				}
				COLON20 = (Token) this.match(this.input, COLON,
						FOLLOW_COLON_in_variableDefinition356);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_COLON.add(COLON20);
				}
				VARIABLE_TYPE21 = (Token) this.match(this.input, VARIABLE_TYPE,
						FOLLOW_VARIABLE_TYPE_in_variableDefinition358);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_VARIABLE_TYPE.add(VARIABLE_TYPE21);
				}
				// OPPLParser.g:59:41: ( variableScope )?
				int alt2 = 2;
				int LA2_0 = this.input.LA(1);
				if (LA2_0 == OPEN_SQUARE_BRACKET) {
					alt2 = 1;
				}
				switch (alt2) {
				case 1:
					// OPPLParser.g:59:42: variableScope
				{
					this
							.pushFollow(FOLLOW_variableScope_in_variableDefinition361);
					variableScope22 = this.variableScope();
					this.state._fsp--;
					if (this.state.failed) {
						return retval;
					}
					if (this.state.backtracking == 0) {
						stream_variableScope.add(variableScope22.getTree());
					}
				}
					break;
				}
				// AST REWRITE
				// elements: VARIABLE_NAME, variableScope, VARIABLE_TYPE
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
					// 59:58: -> ^( INPUT_VARIABLE_DEFINITION VARIABLE_NAME
					// VARIABLE_TYPE ( variableScope )? )
					{
						// OPPLParser.g:59:61: ^( INPUT_VARIABLE_DEFINITION
						// VARIABLE_NAME VARIABLE_TYPE ( variableScope )? )
						{
							OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor
									.nil();
							root_1 = (OPPLSyntaxTree) this.adaptor.becomeRoot(
									(OPPLSyntaxTree) this.adaptor.create(
											INPUT_VARIABLE_DEFINITION,
											"INPUT_VARIABLE_DEFINITION"),
									root_1);
							this.adaptor.addChild(root_1, stream_VARIABLE_NAME
									.nextNode());
							this.adaptor.addChild(root_1, stream_VARIABLE_TYPE
									.nextNode());
							// OPPLParser.g:59:117: ( variableScope )?
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
		} catch (RewriteEmptyStreamException e) {
			throw e;
		} finally {
		}
		return retval;
	}

	// $ANTLR end "variableDefinition"
	public static class variableScope_return extends ParserRuleReturnScope {
		OPPLSyntaxTree tree;

		public Object getTree() {
			return this.tree;
		}
	};

	// $ANTLR start "variableScope"
	// OPPLParser.g:64:1: variableScope : OPEN_SQUARE_BRACKET
	// (variableScopeSpecification= SUBCLASS_OF | variableScopeSpecification=
	// SUBPROPERTY_OF | variableScopeSpecification= SUPER_CLASS_OF |
	// variableScopeSpecification= SUPER_PROPERTY_OF |
	// variableScopeSpecification= INSTANCE_OF | variableScopeSpecification=
	// TYPES ) expression CLOSED_SQUARE_BRACKET -> ^( VARIABLE_SCOPE
	// $variableScopeSpecification ^( EXPRESSION expression ) ) ;
	public final OPPLPatternParser_OPPLParser.variableScope_return variableScope()
			throws RecognitionException {
		OPPLPatternParser_OPPLParser.variableScope_return retval = new OPPLPatternParser_OPPLParser.variableScope_return();
		retval.start = this.input.LT(1);
		OPPLSyntaxTree root_0 = null;
		Token variableScopeSpecification = null;
		Token OPEN_SQUARE_BRACKET23 = null;
		Token CLOSED_SQUARE_BRACKET25 = null;
		OPPLPatternParser_OPPLParser_MOWLParser.expression_return expression24 = null;
		OPPLSyntaxTree variableScopeSpecification_tree = null;
		OPPLSyntaxTree OPEN_SQUARE_BRACKET23_tree = null;
		OPPLSyntaxTree CLOSED_SQUARE_BRACKET25_tree = null;
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
			// OPPLParser.g:65:3: ( OPEN_SQUARE_BRACKET
			// (variableScopeSpecification= SUBCLASS_OF |
			// variableScopeSpecification= SUBPROPERTY_OF |
			// variableScopeSpecification= SUPER_CLASS_OF |
			// variableScopeSpecification= SUPER_PROPERTY_OF |
			// variableScopeSpecification= INSTANCE_OF |
			// variableScopeSpecification= TYPES ) expression
			// CLOSED_SQUARE_BRACKET -> ^( VARIABLE_SCOPE
			// $variableScopeSpecification ^( EXPRESSION expression ) ) )
			// OPPLParser.g:66:5: OPEN_SQUARE_BRACKET
			// (variableScopeSpecification= SUBCLASS_OF |
			// variableScopeSpecification= SUBPROPERTY_OF |
			// variableScopeSpecification= SUPER_CLASS_OF |
			// variableScopeSpecification= SUPER_PROPERTY_OF |
			// variableScopeSpecification= INSTANCE_OF |
			// variableScopeSpecification= TYPES ) expression
			// CLOSED_SQUARE_BRACKET
			{
				OPEN_SQUARE_BRACKET23 = (Token) this.match(this.input,
						OPEN_SQUARE_BRACKET,
						FOLLOW_OPEN_SQUARE_BRACKET_in_variableScope401);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_OPEN_SQUARE_BRACKET.add(OPEN_SQUARE_BRACKET23);
				}
				// OPPLParser.g:66:25: (variableScopeSpecification= SUBCLASS_OF
				// | variableScopeSpecification= SUBPROPERTY_OF |
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
					// OPPLParser.g:66:26: variableScopeSpecification=
					// SUBCLASS_OF
				{
					variableScopeSpecification = (Token) this
							.match(this.input, SUBCLASS_OF,
									FOLLOW_SUBCLASS_OF_in_variableScope408);
					if (this.state.failed) {
						return retval;
					}
					if (this.state.backtracking == 0) {
						stream_SUBCLASS_OF.add(variableScopeSpecification);
					}
				}
					break;
				case 2:
					// OPPLParser.g:66:69: variableScopeSpecification=
					// SUBPROPERTY_OF
				{
					variableScopeSpecification = (Token) this.match(this.input,
							SUBPROPERTY_OF,
							FOLLOW_SUBPROPERTY_OF_in_variableScope416);
					if (this.state.failed) {
						return retval;
					}
					if (this.state.backtracking == 0) {
						stream_SUBPROPERTY_OF.add(variableScopeSpecification);
					}
				}
					break;
				case 3:
					// OPPLParser.g:66:115: variableScopeSpecification=
					// SUPER_CLASS_OF
				{
					variableScopeSpecification = (Token) this.match(this.input,
							SUPER_CLASS_OF,
							FOLLOW_SUPER_CLASS_OF_in_variableScope424);
					if (this.state.failed) {
						return retval;
					}
					if (this.state.backtracking == 0) {
						stream_SUPER_CLASS_OF.add(variableScopeSpecification);
					}
				}
					break;
				case 4:
					// OPPLParser.g:66:162: variableScopeSpecification=
					// SUPER_PROPERTY_OF
				{
					variableScopeSpecification = (Token) this.match(this.input,
							SUPER_PROPERTY_OF,
							FOLLOW_SUPER_PROPERTY_OF_in_variableScope432);
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
					// OPPLParser.g:66:211: variableScopeSpecification=
					// INSTANCE_OF
				{
					variableScopeSpecification = (Token) this
							.match(this.input, INSTANCE_OF,
									FOLLOW_INSTANCE_OF_in_variableScope441);
					if (this.state.failed) {
						return retval;
					}
					if (this.state.backtracking == 0) {
						stream_INSTANCE_OF.add(variableScopeSpecification);
					}
				}
					break;
				case 6:
					// OPPLParser.g:66:254: variableScopeSpecification= TYPES
				{
					variableScopeSpecification = (Token) this.match(this.input,
							TYPES, FOLLOW_TYPES_in_variableScope449);
					if (this.state.failed) {
						return retval;
					}
					if (this.state.backtracking == 0) {
						stream_TYPES.add(variableScopeSpecification);
					}
				}
					break;
				}
				this.pushFollow(FOLLOW_expression_in_variableScope452);
				expression24 = this.gOPPLPatternParser.expression();
				this.state._fsp--;
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_expression.add(expression24.getTree());
				}
				CLOSED_SQUARE_BRACKET25 = (Token) this.match(this.input,
						CLOSED_SQUARE_BRACKET,
						FOLLOW_CLOSED_SQUARE_BRACKET_in_variableScope454);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_CLOSED_SQUARE_BRACKET.add(CLOSED_SQUARE_BRACKET25);
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
					// 66:323: -> ^( VARIABLE_SCOPE $variableScopeSpecification
					// ^( EXPRESSION expression ) )
					{
						// OPPLParser.g:66:326: ^( VARIABLE_SCOPE
						// $variableScopeSpecification ^( EXPRESSION expression
						// ) )
						{
							OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor
									.nil();
							root_1 = (OPPLSyntaxTree) this.adaptor.becomeRoot(
									(OPPLSyntaxTree) this.adaptor.create(
											VARIABLE_SCOPE, "VARIABLE_SCOPE"),
									root_1);
							this.adaptor.addChild(root_1,
									stream_variableScopeSpecification
											.nextNode());
							// OPPLParser.g:66:371: ^( EXPRESSION expression )
							{
								OPPLSyntaxTree root_2 = (OPPLSyntaxTree) this.adaptor
										.nil();
								root_2 = (OPPLSyntaxTree) this.adaptor
										.becomeRoot(
												(OPPLSyntaxTree) this.adaptor
														.create(EXPRESSION,
																"EXPRESSION"),
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
		} catch (RewriteEmptyStreamException e) {
			throw e;
		} finally {
		}
		return retval;
	}

	// $ANTLR end "variableScope"
	public static class regexp_return extends ParserRuleReturnScope {
		OPPLSyntaxTree tree;

		public Object getTree() {
			return this.tree;
		}
	};

	// $ANTLR start "regexp"
	// OPPLParser.g:69:1: regexp : MATCH OPEN_PARENTHESYS stringOperation
	// CLOSED_PARENTHESYS -> ^( MATCH stringOperation ) ;
	public final OPPLPatternParser_OPPLParser.regexp_return regexp()
			throws RecognitionException {
		OPPLPatternParser_OPPLParser.regexp_return retval = new OPPLPatternParser_OPPLParser.regexp_return();
		retval.start = this.input.LT(1);
		OPPLSyntaxTree root_0 = null;
		Token MATCH26 = null;
		Token OPEN_PARENTHESYS27 = null;
		Token CLOSED_PARENTHESYS29 = null;
		OPPLPatternParser_OPPLParser.stringOperation_return stringOperation28 = null;
		OPPLSyntaxTree MATCH26_tree = null;
		OPPLSyntaxTree OPEN_PARENTHESYS27_tree = null;
		OPPLSyntaxTree CLOSED_PARENTHESYS29_tree = null;
		RewriteRuleTokenStream stream_MATCH = new RewriteRuleTokenStream(
				this.adaptor, "token MATCH");
		RewriteRuleTokenStream stream_CLOSED_PARENTHESYS = new RewriteRuleTokenStream(
				this.adaptor, "token CLOSED_PARENTHESYS");
		RewriteRuleTokenStream stream_OPEN_PARENTHESYS = new RewriteRuleTokenStream(
				this.adaptor, "token OPEN_PARENTHESYS");
		RewriteRuleSubtreeStream stream_stringOperation = new RewriteRuleSubtreeStream(
				this.adaptor, "rule stringOperation");
		try {
			// OPPLParser.g:70:2: ( MATCH OPEN_PARENTHESYS stringOperation
			// CLOSED_PARENTHESYS -> ^( MATCH stringOperation ) )
			// OPPLParser.g:71:3: MATCH OPEN_PARENTHESYS stringOperation
			// CLOSED_PARENTHESYS
			{
				MATCH26 = (Token) this.match(this.input, MATCH,
						FOLLOW_MATCH_in_regexp484);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_MATCH.add(MATCH26);
				}
				OPEN_PARENTHESYS27 = (Token) this.match(this.input,
						OPEN_PARENTHESYS, FOLLOW_OPEN_PARENTHESYS_in_regexp486);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_OPEN_PARENTHESYS.add(OPEN_PARENTHESYS27);
				}
				this.pushFollow(FOLLOW_stringOperation_in_regexp488);
				stringOperation28 = this.stringOperation();
				this.state._fsp--;
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_stringOperation.add(stringOperation28.getTree());
				}
				CLOSED_PARENTHESYS29 = (Token) this.match(this.input,
						CLOSED_PARENTHESYS,
						FOLLOW_CLOSED_PARENTHESYS_in_regexp490);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_CLOSED_PARENTHESYS.add(CLOSED_PARENTHESYS29);
				}
				// AST REWRITE
				// elements: stringOperation, MATCH
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
					// 71:61: -> ^( MATCH stringOperation )
					{
						// OPPLParser.g:71:64: ^( MATCH stringOperation )
						{
							OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor
									.nil();
							root_1 = (OPPLSyntaxTree) this.adaptor.becomeRoot(
									stream_MATCH.nextNode(), root_1);
							this.adaptor.addChild(root_1,
									stream_stringOperation.nextTree());
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
		} catch (RewriteEmptyStreamException e) {
			throw e;
		} finally {
		}
		return retval;
	}

	// $ANTLR end "regexp"
	public static class query_return extends ParserRuleReturnScope {
		OPPLSyntaxTree tree;

		public Object getTree() {
			return this.tree;
		}
	};

	// $ANTLR start "query"
	// OPPLParser.g:74:2: query : SELECT selectClause ( COMMA selectClause )* (
	// WHERE constraint ( COMMA constraint )* )? -> ^( QUERY ( selectClause )+ (
	// constraint )* ) ;
	public final OPPLPatternParser_OPPLParser.query_return query()
			throws RecognitionException {
		OPPLPatternParser_OPPLParser.query_return retval = new OPPLPatternParser_OPPLParser.query_return();
		retval.start = this.input.LT(1);
		OPPLSyntaxTree root_0 = null;
		Token SELECT30 = null;
		Token COMMA32 = null;
		Token WHERE34 = null;
		Token COMMA36 = null;
		OPPLPatternParser_OPPLParser.selectClause_return selectClause31 = null;
		OPPLPatternParser_OPPLParser.selectClause_return selectClause33 = null;
		OPPLPatternParser_OPPLParser.constraint_return constraint35 = null;
		OPPLPatternParser_OPPLParser.constraint_return constraint37 = null;
		OPPLSyntaxTree SELECT30_tree = null;
		OPPLSyntaxTree COMMA32_tree = null;
		OPPLSyntaxTree WHERE34_tree = null;
		OPPLSyntaxTree COMMA36_tree = null;
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
			// OPPLParser.g:75:3: ( SELECT selectClause ( COMMA selectClause )*
			// ( WHERE constraint ( COMMA constraint )* )? -> ^( QUERY (
			// selectClause )+ ( constraint )* ) )
			// OPPLParser.g:76:5: SELECT selectClause ( COMMA selectClause )* (
			// WHERE constraint ( COMMA constraint )* )?
			{
				SELECT30 = (Token) this.match(this.input, SELECT,
						FOLLOW_SELECT_in_query515);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_SELECT.add(SELECT30);
				}
				this.pushFollow(FOLLOW_selectClause_in_query517);
				selectClause31 = this.selectClause();
				this.state._fsp--;
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_selectClause.add(selectClause31.getTree());
				}
				// OPPLParser.g:76:25: ( COMMA selectClause )*
				loop5: do {
					int alt5 = 2;
					int LA5_0 = this.input.LA(1);
					if (LA5_0 == COMMA) {
						alt5 = 1;
					}
					switch (alt5) {
					case 1:
						// OPPLParser.g:76:26: COMMA selectClause
					{
						COMMA32 = (Token) this.match(this.input, COMMA,
								FOLLOW_COMMA_in_query520);
						if (this.state.failed) {
							return retval;
						}
						if (this.state.backtracking == 0) {
							stream_COMMA.add(COMMA32);
						}
						this.pushFollow(FOLLOW_selectClause_in_query522);
						selectClause33 = this.selectClause();
						this.state._fsp--;
						if (this.state.failed) {
							return retval;
						}
						if (this.state.backtracking == 0) {
							stream_selectClause.add(selectClause33.getTree());
						}
					}
						break;
					default:
						break loop5;
					}
				} while (true);
				// OPPLParser.g:76:47: ( WHERE constraint ( COMMA constraint )*
				// )?
				int alt7 = 2;
				int LA7_0 = this.input.LA(1);
				if (LA7_0 == WHERE) {
					alt7 = 1;
				}
				switch (alt7) {
				case 1:
					// OPPLParser.g:76:48: WHERE constraint ( COMMA constraint
					// )*
				{
					WHERE34 = (Token) this.match(this.input, WHERE,
							FOLLOW_WHERE_in_query527);
					if (this.state.failed) {
						return retval;
					}
					if (this.state.backtracking == 0) {
						stream_WHERE.add(WHERE34);
					}
					this.pushFollow(FOLLOW_constraint_in_query529);
					constraint35 = this.constraint();
					this.state._fsp--;
					if (this.state.failed) {
						return retval;
					}
					if (this.state.backtracking == 0) {
						stream_constraint.add(constraint35.getTree());
					}
					// OPPLParser.g:76:65: ( COMMA constraint )*
					loop6: do {
						int alt6 = 2;
						int LA6_0 = this.input.LA(1);
						if (LA6_0 == COMMA) {
							alt6 = 1;
						}
						switch (alt6) {
						case 1:
							// OPPLParser.g:76:66: COMMA constraint
						{
							COMMA36 = (Token) this.match(this.input, COMMA,
									FOLLOW_COMMA_in_query532);
							if (this.state.failed) {
								return retval;
							}
							if (this.state.backtracking == 0) {
								stream_COMMA.add(COMMA36);
							}
							this.pushFollow(FOLLOW_constraint_in_query534);
							constraint37 = this.constraint();
							this.state._fsp--;
							if (this.state.failed) {
								return retval;
							}
							if (this.state.backtracking == 0) {
								stream_constraint.add(constraint37.getTree());
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
				// elements: selectClause, constraint
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
					// 76:87: -> ^( QUERY ( selectClause )+ ( constraint )* )
					{
						// OPPLParser.g:76:90: ^( QUERY ( selectClause )+ (
						// constraint )* )
						{
							OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor
									.nil();
							root_1 = (OPPLSyntaxTree) this.adaptor.becomeRoot(
									(OPPLSyntaxTree) this.adaptor.create(QUERY,
											"QUERY"), root_1);
							if (!stream_selectClause.hasNext()) {
								throw new RewriteEarlyExitException();
							}
							while (stream_selectClause.hasNext()) {
								this.adaptor.addChild(root_1,
										stream_selectClause.nextTree());
							}
							stream_selectClause.reset();
							// OPPLParser.g:76:112: ( constraint )*
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
		} catch (RewriteEmptyStreamException e) {
			throw e;
		} finally {
		}
		return retval;
	}

	// $ANTLR end "query"
	public static class selectClause_return extends ParserRuleReturnScope {
		OPPLSyntaxTree tree;

		public Object getTree() {
			return this.tree;
		}
	};

	// $ANTLR start "selectClause"
	// OPPLParser.g:79:2: selectClause : ( ASSERTED axiom -> ^( ASSERTED_CLAUSE
	// axiom ) | axiom -> ^( PLAIN_CLAUSE axiom ) );
	public final OPPLPatternParser_OPPLParser.selectClause_return selectClause()
			throws RecognitionException {
		OPPLPatternParser_OPPLParser.selectClause_return retval = new OPPLPatternParser_OPPLParser.selectClause_return();
		retval.start = this.input.LT(1);
		OPPLSyntaxTree root_0 = null;
		Token ASSERTED38 = null;
		OPPLPatternParser_OPPLParser_MOWLParser.axiom_return axiom39 = null;
		OPPLPatternParser_OPPLParser_MOWLParser.axiom_return axiom40 = null;
		OPPLSyntaxTree ASSERTED38_tree = null;
		RewriteRuleTokenStream stream_ASSERTED = new RewriteRuleTokenStream(
				this.adaptor, "token ASSERTED");
		RewriteRuleSubtreeStream stream_axiom = new RewriteRuleSubtreeStream(
				this.adaptor, "rule axiom");
		try {
			// OPPLParser.g:80:3: ( ASSERTED axiom -> ^( ASSERTED_CLAUSE axiom )
			// | axiom -> ^( PLAIN_CLAUSE axiom ) )
			int alt8 = 2;
			int LA8_0 = this.input.LA(1);
			if (LA8_0 == ASSERTED) {
				alt8 = 1;
			} else if (LA8_0 == EOF || LA8_0 >= OPEN_PARENTHESYS
					&& LA8_0 <= OPEN_CURLY_BRACES
					|| LA8_0 == CLOSED_PARENTHESYS || LA8_0 >= AND
					&& LA8_0 <= NOT || LA8_0 >= INVERSE
					&& LA8_0 <= EQUIVALENT_TO || LA8_0 == DISJOINT_WITH
					|| LA8_0 >= FUNCTIONAL && LA8_0 <= INVERSE_FUNCTIONAL
					|| LA8_0 == COMMA || LA8_0 == DBLQUOTE
					|| LA8_0 >= IDENTIFIER && LA8_0 <= ENTITY_REFERENCE
					|| LA8_0 == CLOSED_SQUARE_BRACKET
					|| LA8_0 == ESCLAMATION_MARK || LA8_0 == DOLLAR
					|| LA8_0 == THIS_CLASS || LA8_0 == VARIABLE_NAME) {
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
				// OPPLParser.g:81:7: ASSERTED axiom
			{
				ASSERTED38 = (Token) this.match(this.input, ASSERTED,
						FOLLOW_ASSERTED_in_selectClause571);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_ASSERTED.add(ASSERTED38);
				}
				this.pushFollow(FOLLOW_axiom_in_selectClause573);
				axiom39 = this.gOPPLPatternParser.axiom();
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
					// 81:22: -> ^( ASSERTED_CLAUSE axiom )
					{
						// OPPLParser.g:81:25: ^( ASSERTED_CLAUSE axiom )
						{
							OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor
									.nil();
							root_1 = (OPPLSyntaxTree) this.adaptor
									.becomeRoot((OPPLSyntaxTree) this.adaptor
											.create(ASSERTED_CLAUSE,
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
				// OPPLParser.g:82:7: axiom
			{
				this.pushFollow(FOLLOW_axiom_in_selectClause589);
				axiom40 = this.gOPPLPatternParser.axiom();
				this.state._fsp--;
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_axiom.add(axiom40.getTree());
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
					// 82:13: -> ^( PLAIN_CLAUSE axiom )
					{
						// OPPLParser.g:82:16: ^( PLAIN_CLAUSE axiom )
						{
							OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor
									.nil();
							root_1 = (OPPLSyntaxTree) this.adaptor.becomeRoot(
									(OPPLSyntaxTree) this.adaptor.create(
											PLAIN_CLAUSE, "PLAIN_CLAUSE"),
									root_1);
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
		} catch (RewriteEmptyStreamException e) {
			throw e;
		} finally {
		}
		return retval;
	}

	// $ANTLR end "selectClause"
	public static class constraint_return extends ParserRuleReturnScope {
		OPPLSyntaxTree tree;

		public Object getTree() {
			return this.tree;
		}
	};

	// $ANTLR start "constraint"
	// OPPLParser.g:87:2: constraint : (first= VARIABLE_NAME NOT_EQUAL second=
	// expression -> ^( INEQUALITY_CONSTRAINT IDENTIFIER[$first] ^( EXPRESSION
	// $second) ) | VARIABLE_NAME IN OPEN_CURLY_BRACES atomic ( COMMA atomic )*
	// CLOSED_CURLY_BRACES -> ^( IN_SET_CONSTRAINT IDENTIFIER[$VARIABLE_NAME] (
	// atomic )+ ) | VARIABLE_NAME MATCH OPEN_PARENTHESYS stringOperation
	// CLOSED_PARENTHESYS -> ^( REGEXP_CONSTRAINT IDENTIFIER[$VARIABLE_NAME]
	// stringOperation ) | FAIL axiom -> ^( NAF_CONSTRAINT axiom ) );
	public final OPPLPatternParser_OPPLParser.constraint_return constraint()
			throws RecognitionException {
		OPPLPatternParser_OPPLParser.constraint_return retval = new OPPLPatternParser_OPPLParser.constraint_return();
		retval.start = this.input.LT(1);
		OPPLSyntaxTree root_0 = null;
		Token first = null;
		Token NOT_EQUAL41 = null;
		Token VARIABLE_NAME42 = null;
		Token IN43 = null;
		Token OPEN_CURLY_BRACES44 = null;
		Token COMMA46 = null;
		Token CLOSED_CURLY_BRACES48 = null;
		Token VARIABLE_NAME49 = null;
		Token MATCH50 = null;
		Token OPEN_PARENTHESYS51 = null;
		Token CLOSED_PARENTHESYS53 = null;
		Token FAIL54 = null;
		OPPLPatternParser_OPPLParser_MOWLParser.expression_return second = null;
		OPPLPatternParser.atomic_return atomic45 = null;
		OPPLPatternParser.atomic_return atomic47 = null;
		OPPLPatternParser_OPPLParser.stringOperation_return stringOperation52 = null;
		OPPLPatternParser_OPPLParser_MOWLParser.axiom_return axiom55 = null;
		OPPLSyntaxTree first_tree = null;
		OPPLSyntaxTree NOT_EQUAL41_tree = null;
		OPPLSyntaxTree VARIABLE_NAME42_tree = null;
		OPPLSyntaxTree IN43_tree = null;
		OPPLSyntaxTree OPEN_CURLY_BRACES44_tree = null;
		OPPLSyntaxTree COMMA46_tree = null;
		OPPLSyntaxTree CLOSED_CURLY_BRACES48_tree = null;
		OPPLSyntaxTree VARIABLE_NAME49_tree = null;
		OPPLSyntaxTree MATCH50_tree = null;
		OPPLSyntaxTree OPEN_PARENTHESYS51_tree = null;
		OPPLSyntaxTree CLOSED_PARENTHESYS53_tree = null;
		OPPLSyntaxTree FAIL54_tree = null;
		RewriteRuleTokenStream stream_MATCH = new RewriteRuleTokenStream(
				this.adaptor, "token MATCH");
		RewriteRuleTokenStream stream_VARIABLE_NAME = new RewriteRuleTokenStream(
				this.adaptor, "token VARIABLE_NAME");
		RewriteRuleTokenStream stream_IN = new RewriteRuleTokenStream(
				this.adaptor, "token IN");
		RewriteRuleTokenStream stream_CLOSED_PARENTHESYS = new RewriteRuleTokenStream(
				this.adaptor, "token CLOSED_PARENTHESYS");
		RewriteRuleTokenStream stream_COMMA = new RewriteRuleTokenStream(
				this.adaptor, "token COMMA");
		RewriteRuleTokenStream stream_CLOSED_CURLY_BRACES = new RewriteRuleTokenStream(
				this.adaptor, "token CLOSED_CURLY_BRACES");
		RewriteRuleTokenStream stream_NOT_EQUAL = new RewriteRuleTokenStream(
				this.adaptor, "token NOT_EQUAL");
		RewriteRuleTokenStream stream_FAIL = new RewriteRuleTokenStream(
				this.adaptor, "token FAIL");
		RewriteRuleTokenStream stream_OPEN_CURLY_BRACES = new RewriteRuleTokenStream(
				this.adaptor, "token OPEN_CURLY_BRACES");
		RewriteRuleTokenStream stream_OPEN_PARENTHESYS = new RewriteRuleTokenStream(
				this.adaptor, "token OPEN_PARENTHESYS");
		RewriteRuleSubtreeStream stream_expression = new RewriteRuleSubtreeStream(
				this.adaptor, "rule expression");
		RewriteRuleSubtreeStream stream_axiom = new RewriteRuleSubtreeStream(
				this.adaptor, "rule axiom");
		RewriteRuleSubtreeStream stream_stringOperation = new RewriteRuleSubtreeStream(
				this.adaptor, "rule stringOperation");
		RewriteRuleSubtreeStream stream_atomic = new RewriteRuleSubtreeStream(
				this.adaptor, "rule atomic");
		try {
			// OPPLParser.g:88:3: (first= VARIABLE_NAME NOT_EQUAL second=
			// expression -> ^( INEQUALITY_CONSTRAINT IDENTIFIER[$first] ^(
			// EXPRESSION $second) ) | VARIABLE_NAME IN OPEN_CURLY_BRACES atomic
			// ( COMMA atomic )* CLOSED_CURLY_BRACES -> ^( IN_SET_CONSTRAINT
			// IDENTIFIER[$VARIABLE_NAME] ( atomic )+ ) | VARIABLE_NAME MATCH
			// OPEN_PARENTHESYS stringOperation CLOSED_PARENTHESYS -> ^(
			// REGEXP_CONSTRAINT IDENTIFIER[$VARIABLE_NAME] stringOperation ) |
			// FAIL axiom -> ^( NAF_CONSTRAINT axiom ) )
			int alt10 = 4;
			int LA10_0 = this.input.LA(1);
			if (LA10_0 == VARIABLE_NAME) {
				switch (this.input.LA(2)) {
				case NOT_EQUAL: {
					alt10 = 1;
				}
					break;
				case IN: {
					alt10 = 2;
				}
					break;
				case MATCH: {
					alt10 = 3;
				}
					break;
				default:
					if (this.state.backtracking > 0) {
						this.state.failed = true;
						return retval;
					}
					NoViableAltException nvae = new NoViableAltException("",
							10, 1, this.input);
					throw nvae;
				}
			} else if (LA10_0 == FAIL) {
				alt10 = 4;
			} else {
				if (this.state.backtracking > 0) {
					this.state.failed = true;
					return retval;
				}
				NoViableAltException nvae = new NoViableAltException("", 10, 0,
						this.input);
				throw nvae;
			}
			switch (alt10) {
			case 1:
				// OPPLParser.g:89:8: first= VARIABLE_NAME NOT_EQUAL second=
				// expression
			{
				first = (Token) this.match(this.input, VARIABLE_NAME,
						FOLLOW_VARIABLE_NAME_in_constraint628);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_VARIABLE_NAME.add(first);
				}
				NOT_EQUAL41 = (Token) this.match(this.input, NOT_EQUAL,
						FOLLOW_NOT_EQUAL_in_constraint630);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_NOT_EQUAL.add(NOT_EQUAL41);
				}
				this.pushFollow(FOLLOW_expression_in_constraint636);
				second = this.gOPPLPatternParser.expression();
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
					// 89:60: -> ^( INEQUALITY_CONSTRAINT IDENTIFIER[$first] ^(
					// EXPRESSION $second) )
					{
						// OPPLParser.g:89:63: ^( INEQUALITY_CONSTRAINT
						// IDENTIFIER[$first] ^( EXPRESSION $second) )
						{
							OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor
									.nil();
							root_1 = (OPPLSyntaxTree) this.adaptor.becomeRoot(
									(OPPLSyntaxTree) this.adaptor.create(
											INEQUALITY_CONSTRAINT,
											"INEQUALITY_CONSTRAINT"), root_1);
							this.adaptor.addChild(root_1,
									(OPPLSyntaxTree) this.adaptor.create(
											IDENTIFIER, first));
							// OPPLParser.g:89:106: ^( EXPRESSION $second)
							{
								OPPLSyntaxTree root_2 = (OPPLSyntaxTree) this.adaptor
										.nil();
								root_2 = (OPPLSyntaxTree) this.adaptor
										.becomeRoot(
												(OPPLSyntaxTree) this.adaptor
														.create(EXPRESSION,
																"EXPRESSION"),
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
				// OPPLParser.g:90:8: VARIABLE_NAME IN OPEN_CURLY_BRACES atomic
				// ( COMMA atomic )* CLOSED_CURLY_BRACES
			{
				VARIABLE_NAME42 = (Token) this.match(this.input, VARIABLE_NAME,
						FOLLOW_VARIABLE_NAME_in_constraint661);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_VARIABLE_NAME.add(VARIABLE_NAME42);
				}
				IN43 = (Token) this.match(this.input, IN,
						FOLLOW_IN_in_constraint663);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_IN.add(IN43);
				}
				OPEN_CURLY_BRACES44 = (Token) this.match(this.input,
						OPEN_CURLY_BRACES,
						FOLLOW_OPEN_CURLY_BRACES_in_constraint665);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_OPEN_CURLY_BRACES.add(OPEN_CURLY_BRACES44);
				}
				this.pushFollow(FOLLOW_atomic_in_constraint667);
				atomic45 = this.gOPPLPatternParser.atomic();
				this.state._fsp--;
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_atomic.add(atomic45.getTree());
				}
				// OPPLParser.g:90:50: ( COMMA atomic )*
				loop9: do {
					int alt9 = 2;
					int LA9_0 = this.input.LA(1);
					if (LA9_0 == COMMA) {
						alt9 = 1;
					}
					switch (alt9) {
					case 1:
						// OPPLParser.g:90:51: COMMA atomic
					{
						COMMA46 = (Token) this.match(this.input, COMMA,
								FOLLOW_COMMA_in_constraint670);
						if (this.state.failed) {
							return retval;
						}
						if (this.state.backtracking == 0) {
							stream_COMMA.add(COMMA46);
						}
						this.pushFollow(FOLLOW_atomic_in_constraint672);
						atomic47 = this.gOPPLPatternParser.atomic();
						this.state._fsp--;
						if (this.state.failed) {
							return retval;
						}
						if (this.state.backtracking == 0) {
							stream_atomic.add(atomic47.getTree());
						}
					}
						break;
					default:
						break loop9;
					}
				} while (true);
				CLOSED_CURLY_BRACES48 = (Token) this.match(this.input,
						CLOSED_CURLY_BRACES,
						FOLLOW_CLOSED_CURLY_BRACES_in_constraint676);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_CLOSED_CURLY_BRACES.add(CLOSED_CURLY_BRACES48);
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
					// 90:87: -> ^( IN_SET_CONSTRAINT IDENTIFIER[$VARIABLE_NAME]
					// ( atomic )+ )
					{
						// OPPLParser.g:90:90: ^( IN_SET_CONSTRAINT
						// IDENTIFIER[$VARIABLE_NAME] ( atomic )+ )
						{
							OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor
									.nil();
							root_1 = (OPPLSyntaxTree) this.adaptor.becomeRoot(
									(OPPLSyntaxTree) this.adaptor.create(
											IN_SET_CONSTRAINT,
											"IN_SET_CONSTRAINT"), root_1);
							this.adaptor.addChild(root_1,
									(OPPLSyntaxTree) this.adaptor.create(
											IDENTIFIER, VARIABLE_NAME42));
							if (!stream_atomic.hasNext()) {
								throw new RewriteEarlyExitException();
							}
							while (stream_atomic.hasNext()) {
								this.adaptor.addChild(root_1, stream_atomic
										.nextTree());
							}
							stream_atomic.reset();
							this.adaptor.addChild(root_0, root_1);
						}
					}
					retval.tree = root_0;
				}
			}
				break;
			case 3:
				// OPPLParser.g:91:8: VARIABLE_NAME MATCH OPEN_PARENTHESYS
				// stringOperation CLOSED_PARENTHESYS
			{
				VARIABLE_NAME49 = (Token) this.match(this.input, VARIABLE_NAME,
						FOLLOW_VARIABLE_NAME_in_constraint698);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_VARIABLE_NAME.add(VARIABLE_NAME49);
				}
				MATCH50 = (Token) this.match(this.input, MATCH,
						FOLLOW_MATCH_in_constraint700);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_MATCH.add(MATCH50);
				}
				OPEN_PARENTHESYS51 = (Token) this.match(this.input,
						OPEN_PARENTHESYS,
						FOLLOW_OPEN_PARENTHESYS_in_constraint702);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_OPEN_PARENTHESYS.add(OPEN_PARENTHESYS51);
				}
				this.pushFollow(FOLLOW_stringOperation_in_constraint704);
				stringOperation52 = this.stringOperation();
				this.state._fsp--;
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_stringOperation.add(stringOperation52.getTree());
				}
				CLOSED_PARENTHESYS53 = (Token) this.match(this.input,
						CLOSED_PARENTHESYS,
						FOLLOW_CLOSED_PARENTHESYS_in_constraint706);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_CLOSED_PARENTHESYS.add(CLOSED_PARENTHESYS53);
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
					// 91:80: -> ^( REGEXP_CONSTRAINT IDENTIFIER[$VARIABLE_NAME]
					// stringOperation )
					{
						// OPPLParser.g:91:83: ^( REGEXP_CONSTRAINT
						// IDENTIFIER[$VARIABLE_NAME] stringOperation )
						{
							OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor
									.nil();
							root_1 = (OPPLSyntaxTree) this.adaptor.becomeRoot(
									(OPPLSyntaxTree) this.adaptor.create(
											REGEXP_CONSTRAINT,
											"REGEXP_CONSTRAINT"), root_1);
							this.adaptor.addChild(root_1,
									(OPPLSyntaxTree) this.adaptor.create(
											IDENTIFIER, VARIABLE_NAME49));
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
				// OPPLParser.g:92:7: FAIL axiom
			{
				FAIL54 = (Token) this.match(this.input, FAIL,
						FOLLOW_FAIL_in_constraint725);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_FAIL.add(FAIL54);
				}
				this.pushFollow(FOLLOW_axiom_in_constraint727);
				axiom55 = this.gOPPLPatternParser.axiom();
				this.state._fsp--;
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_axiom.add(axiom55.getTree());
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
					// 92:18: -> ^( NAF_CONSTRAINT axiom )
					{
						// OPPLParser.g:92:21: ^( NAF_CONSTRAINT axiom )
						{
							OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor
									.nil();
							root_1 = (OPPLSyntaxTree) this.adaptor.becomeRoot(
									(OPPLSyntaxTree) this.adaptor.create(
											NAF_CONSTRAINT, "NAF_CONSTRAINT"),
									root_1);
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
		} catch (RewriteEmptyStreamException e) {
			throw e;
		} finally {
		}
		return retval;
	}

	// $ANTLR end "constraint"
	public static class actions_return extends ParserRuleReturnScope {
		OPPLSyntaxTree tree;

		public Object getTree() {
			return this.tree;
		}
	};

	// $ANTLR start "actions"
	// OPPLParser.g:95:2: actions : BEGIN action ( COMMA action )* END -> ^(
	// ACTIONS ( action )+ ) ;
	public final OPPLPatternParser_OPPLParser.actions_return actions()
			throws RecognitionException {
		OPPLPatternParser_OPPLParser.actions_return retval = new OPPLPatternParser_OPPLParser.actions_return();
		retval.start = this.input.LT(1);
		OPPLSyntaxTree root_0 = null;
		Token BEGIN56 = null;
		Token COMMA58 = null;
		Token END60 = null;
		OPPLPatternParser_OPPLParser.action_return action57 = null;
		OPPLPatternParser_OPPLParser.action_return action59 = null;
		OPPLSyntaxTree BEGIN56_tree = null;
		OPPLSyntaxTree COMMA58_tree = null;
		OPPLSyntaxTree END60_tree = null;
		RewriteRuleTokenStream stream_END = new RewriteRuleTokenStream(
				this.adaptor, "token END");
		RewriteRuleTokenStream stream_COMMA = new RewriteRuleTokenStream(
				this.adaptor, "token COMMA");
		RewriteRuleTokenStream stream_BEGIN = new RewriteRuleTokenStream(
				this.adaptor, "token BEGIN");
		RewriteRuleSubtreeStream stream_action = new RewriteRuleSubtreeStream(
				this.adaptor, "rule action");
		try {
			// OPPLParser.g:96:3: ( BEGIN action ( COMMA action )* END -> ^(
			// ACTIONS ( action )+ ) )
			// OPPLParser.g:97:5: BEGIN action ( COMMA action )* END
			{
				BEGIN56 = (Token) this.match(this.input, BEGIN,
						FOLLOW_BEGIN_in_actions755);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_BEGIN.add(BEGIN56);
				}
				this.pushFollow(FOLLOW_action_in_actions757);
				action57 = this.action();
				this.state._fsp--;
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_action.add(action57.getTree());
				}
				// OPPLParser.g:97:18: ( COMMA action )*
				loop11: do {
					int alt11 = 2;
					int LA11_0 = this.input.LA(1);
					if (LA11_0 == COMMA) {
						alt11 = 1;
					}
					switch (alt11) {
					case 1:
						// OPPLParser.g:97:19: COMMA action
					{
						COMMA58 = (Token) this.match(this.input, COMMA,
								FOLLOW_COMMA_in_actions760);
						if (this.state.failed) {
							return retval;
						}
						if (this.state.backtracking == 0) {
							stream_COMMA.add(COMMA58);
						}
						this.pushFollow(FOLLOW_action_in_actions762);
						action59 = this.action();
						this.state._fsp--;
						if (this.state.failed) {
							return retval;
						}
						if (this.state.backtracking == 0) {
							stream_action.add(action59.getTree());
						}
					}
						break;
					default:
						break loop11;
					}
				} while (true);
				END60 = (Token) this.match(this.input, END,
						FOLLOW_END_in_actions766);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_END.add(END60);
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
					// 97:38: -> ^( ACTIONS ( action )+ )
					{
						// OPPLParser.g:97:41: ^( ACTIONS ( action )+ )
						{
							OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor
									.nil();
							root_1 = (OPPLSyntaxTree) this.adaptor.becomeRoot(
									(OPPLSyntaxTree) this.adaptor.create(
											ACTIONS, "ACTIONS"), root_1);
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
		} catch (RewriteEmptyStreamException e) {
			throw e;
		} finally {
		}
		return retval;
	}

	// $ANTLR end "actions"
	public static class action_return extends ParserRuleReturnScope {
		OPPLSyntaxTree tree;

		public Object getTree() {
			return this.tree;
		}
	};

	// $ANTLR start "action"
	// OPPLParser.g:100:2: action : ( ADD axiom -> ^( ADD axiom ) | REMOVE axiom
	// -> ^( REMOVE axiom ) );
	public final OPPLPatternParser_OPPLParser.action_return action()
			throws RecognitionException {
		OPPLPatternParser_OPPLParser.action_return retval = new OPPLPatternParser_OPPLParser.action_return();
		retval.start = this.input.LT(1);
		OPPLSyntaxTree root_0 = null;
		Token ADD61 = null;
		Token REMOVE63 = null;
		OPPLPatternParser_OPPLParser_MOWLParser.axiom_return axiom62 = null;
		OPPLPatternParser_OPPLParser_MOWLParser.axiom_return axiom64 = null;
		OPPLSyntaxTree ADD61_tree = null;
		OPPLSyntaxTree REMOVE63_tree = null;
		RewriteRuleTokenStream stream_REMOVE = new RewriteRuleTokenStream(
				this.adaptor, "token REMOVE");
		RewriteRuleTokenStream stream_ADD = new RewriteRuleTokenStream(
				this.adaptor, "token ADD");
		RewriteRuleSubtreeStream stream_axiom = new RewriteRuleSubtreeStream(
				this.adaptor, "rule axiom");
		try {
			// OPPLParser.g:101:3: ( ADD axiom -> ^( ADD axiom ) | REMOVE axiom
			// -> ^( REMOVE axiom ) )
			int alt12 = 2;
			int LA12_0 = this.input.LA(1);
			if (LA12_0 == ADD) {
				alt12 = 1;
			} else if (LA12_0 == REMOVE) {
				alt12 = 2;
			} else {
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
				// OPPLParser.g:102:7: ADD axiom
			{
				ADD61 = (Token) this.match(this.input, ADD,
						FOLLOW_ADD_in_action798);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_ADD.add(ADD61);
				}
				this.pushFollow(FOLLOW_axiom_in_action800);
				axiom62 = this.gOPPLPatternParser.axiom();
				this.state._fsp--;
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_axiom.add(axiom62.getTree());
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
					// 102:17: -> ^( ADD axiom )
					{
						// OPPLParser.g:102:20: ^( ADD axiom )
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
				// OPPLParser.g:103:7: REMOVE axiom
			{
				REMOVE63 = (Token) this.match(this.input, REMOVE,
						FOLLOW_REMOVE_in_action816);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_REMOVE.add(REMOVE63);
				}
				this.pushFollow(FOLLOW_axiom_in_action818);
				axiom64 = this.gOPPLPatternParser.axiom();
				this.state._fsp--;
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_axiom.add(axiom64.getTree());
				}
				// AST REWRITE
				// elements: axiom, REMOVE
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
					// 103:20: -> ^( REMOVE axiom )
					{
						// OPPLParser.g:103:23: ^( REMOVE axiom )
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
		} catch (RewriteEmptyStreamException e) {
			throw e;
		} finally {
		}
		return retval;
	}

	// $ANTLR end "action"
	public static class opplFunction_return extends ParserRuleReturnScope {
		OPPLSyntaxTree tree;

		public Object getTree() {
			return this.tree;
		}
	};

	// $ANTLR start "opplFunction"
	// OPPLParser.g:109:1: opplFunction : ( CREATE OPEN_PARENTHESYS
	// stringOperation CLOSED_PARENTHESYS -> ^( CREATE_OPPL_FUNCTION
	// stringOperation ) | CREATE_INTERSECTION OPEN_PARENTHESYS atomic
	// CLOSED_PARENTHESYS -> ^( CREATE_INTERSECTION atomic ) |
	// CREATE_DISJUNCTION OPEN_PARENTHESYS atomic CLOSED_PARENTHESYS -> ^(
	// CREATE_INTERSECTION atomic ) );
	public final OPPLPatternParser_OPPLParser.opplFunction_return opplFunction()
			throws RecognitionException {
		OPPLPatternParser_OPPLParser.opplFunction_return retval = new OPPLPatternParser_OPPLParser.opplFunction_return();
		retval.start = this.input.LT(1);
		OPPLSyntaxTree root_0 = null;
		Token CREATE65 = null;
		Token OPEN_PARENTHESYS66 = null;
		Token CLOSED_PARENTHESYS68 = null;
		Token CREATE_INTERSECTION69 = null;
		Token OPEN_PARENTHESYS70 = null;
		Token CLOSED_PARENTHESYS72 = null;
		Token CREATE_DISJUNCTION73 = null;
		Token OPEN_PARENTHESYS74 = null;
		Token CLOSED_PARENTHESYS76 = null;
		OPPLPatternParser_OPPLParser.stringOperation_return stringOperation67 = null;
		OPPLPatternParser.atomic_return atomic71 = null;
		OPPLPatternParser.atomic_return atomic75 = null;
		OPPLSyntaxTree CREATE65_tree = null;
		OPPLSyntaxTree OPEN_PARENTHESYS66_tree = null;
		OPPLSyntaxTree CLOSED_PARENTHESYS68_tree = null;
		OPPLSyntaxTree CREATE_INTERSECTION69_tree = null;
		OPPLSyntaxTree OPEN_PARENTHESYS70_tree = null;
		OPPLSyntaxTree CLOSED_PARENTHESYS72_tree = null;
		OPPLSyntaxTree CREATE_DISJUNCTION73_tree = null;
		OPPLSyntaxTree OPEN_PARENTHESYS74_tree = null;
		OPPLSyntaxTree CLOSED_PARENTHESYS76_tree = null;
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
			// OPPLParser.g:110:3: ( CREATE OPEN_PARENTHESYS stringOperation
			// CLOSED_PARENTHESYS -> ^( CREATE_OPPL_FUNCTION stringOperation ) |
			// CREATE_INTERSECTION OPEN_PARENTHESYS atomic CLOSED_PARENTHESYS ->
			// ^( CREATE_INTERSECTION atomic ) | CREATE_DISJUNCTION
			// OPEN_PARENTHESYS atomic CLOSED_PARENTHESYS -> ^(
			// CREATE_INTERSECTION atomic ) )
			int alt13 = 3;
			switch (this.input.LA(1)) {
			case CREATE: {
				alt13 = 1;
			}
				break;
			case CREATE_INTERSECTION: {
				alt13 = 2;
			}
				break;
			case CREATE_DISJUNCTION: {
				alt13 = 3;
			}
				break;
			default:
				if (this.state.backtracking > 0) {
					this.state.failed = true;
					return retval;
				}
				NoViableAltException nvae = new NoViableAltException("", 13, 0,
						this.input);
				throw nvae;
			}
			switch (alt13) {
			case 1:
				// OPPLParser.g:111:7: CREATE OPEN_PARENTHESYS stringOperation
				// CLOSED_PARENTHESYS
			{
				CREATE65 = (Token) this.match(this.input, CREATE,
						FOLLOW_CREATE_in_opplFunction851);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_CREATE.add(CREATE65);
				}
				OPEN_PARENTHESYS66 = (Token) this.match(this.input,
						OPEN_PARENTHESYS,
						FOLLOW_OPEN_PARENTHESYS_in_opplFunction853);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_OPEN_PARENTHESYS.add(OPEN_PARENTHESYS66);
				}
				this.pushFollow(FOLLOW_stringOperation_in_opplFunction855);
				stringOperation67 = this.stringOperation();
				this.state._fsp--;
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_stringOperation.add(stringOperation67.getTree());
				}
				CLOSED_PARENTHESYS68 = (Token) this.match(this.input,
						CLOSED_PARENTHESYS,
						FOLLOW_CLOSED_PARENTHESYS_in_opplFunction857);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_CLOSED_PARENTHESYS.add(CLOSED_PARENTHESYS68);
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
					// 111:66: -> ^( CREATE_OPPL_FUNCTION stringOperation )
					{
						// OPPLParser.g:111:69: ^( CREATE_OPPL_FUNCTION
						// stringOperation )
						{
							OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor
									.nil();
							root_1 = (OPPLSyntaxTree) this.adaptor.becomeRoot(
									(OPPLSyntaxTree) this.adaptor.create(
											CREATE_OPPL_FUNCTION,
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
				// OPPLParser.g:112:7: CREATE_INTERSECTION OPEN_PARENTHESYS
				// atomic CLOSED_PARENTHESYS
			{
				CREATE_INTERSECTION69 = (Token) this.match(this.input,
						CREATE_INTERSECTION,
						FOLLOW_CREATE_INTERSECTION_in_opplFunction873);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_CREATE_INTERSECTION.add(CREATE_INTERSECTION69);
				}
				OPEN_PARENTHESYS70 = (Token) this.match(this.input,
						OPEN_PARENTHESYS,
						FOLLOW_OPEN_PARENTHESYS_in_opplFunction876);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_OPEN_PARENTHESYS.add(OPEN_PARENTHESYS70);
				}
				this.pushFollow(FOLLOW_atomic_in_opplFunction878);
				atomic71 = this.gOPPLPatternParser.atomic();
				this.state._fsp--;
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_atomic.add(atomic71.getTree());
				}
				CLOSED_PARENTHESYS72 = (Token) this.match(this.input,
						CLOSED_PARENTHESYS,
						FOLLOW_CLOSED_PARENTHESYS_in_opplFunction881);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_CLOSED_PARENTHESYS.add(CLOSED_PARENTHESYS72);
				}
				// AST REWRITE
				// elements: CREATE_INTERSECTION, atomic
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
					// 112:72: -> ^( CREATE_INTERSECTION atomic )
					{
						// OPPLParser.g:112:75: ^( CREATE_INTERSECTION atomic )
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
				// OPPLParser.g:113:7: CREATE_DISJUNCTION OPEN_PARENTHESYS
				// atomic CLOSED_PARENTHESYS
			{
				CREATE_DISJUNCTION73 = (Token) this.match(this.input,
						CREATE_DISJUNCTION,
						FOLLOW_CREATE_DISJUNCTION_in_opplFunction897);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_CREATE_DISJUNCTION.add(CREATE_DISJUNCTION73);
				}
				OPEN_PARENTHESYS74 = (Token) this.match(this.input,
						OPEN_PARENTHESYS,
						FOLLOW_OPEN_PARENTHESYS_in_opplFunction899);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_OPEN_PARENTHESYS.add(OPEN_PARENTHESYS74);
				}
				this.pushFollow(FOLLOW_atomic_in_opplFunction901);
				atomic75 = this.gOPPLPatternParser.atomic();
				this.state._fsp--;
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_atomic.add(atomic75.getTree());
				}
				CLOSED_PARENTHESYS76 = (Token) this.match(this.input,
						CLOSED_PARENTHESYS,
						FOLLOW_CLOSED_PARENTHESYS_in_opplFunction903);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_CLOSED_PARENTHESYS.add(CLOSED_PARENTHESYS76);
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
					// 113:69: -> ^( CREATE_INTERSECTION atomic )
					{
						// OPPLParser.g:113:72: ^( CREATE_INTERSECTION atomic )
						{
							OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor
									.nil();
							root_1 = (OPPLSyntaxTree) this.adaptor.becomeRoot(
									(OPPLSyntaxTree) this.adaptor.create(
											CREATE_INTERSECTION,
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
		} catch (RewriteEmptyStreamException e) {
			throw e;
		} finally {
		}
		return retval;
	}

	// $ANTLR end "opplFunction"
	public static class stringOperation_return extends ParserRuleReturnScope {
		OPPLSyntaxTree tree;

		public Object getTree() {
			return this.tree;
		}
	};

	// $ANTLR start "stringOperation"
	// OPPLParser.g:116:1: stringOperation : stringExpression ( PLUS
	// stringExpression )* -> ^( STRING_OPERATION ( stringExpression )+ ) ;
	public final OPPLPatternParser_OPPLParser.stringOperation_return stringOperation()
			throws RecognitionException {
		OPPLPatternParser_OPPLParser.stringOperation_return retval = new OPPLPatternParser_OPPLParser.stringOperation_return();
		retval.start = this.input.LT(1);
		OPPLSyntaxTree root_0 = null;
		Token PLUS78 = null;
		OPPLPatternParser_OPPLParser.stringExpression_return stringExpression77 = null;
		OPPLPatternParser_OPPLParser.stringExpression_return stringExpression79 = null;
		OPPLSyntaxTree PLUS78_tree = null;
		RewriteRuleTokenStream stream_PLUS = new RewriteRuleTokenStream(
				this.adaptor, "token PLUS");
		RewriteRuleSubtreeStream stream_stringExpression = new RewriteRuleSubtreeStream(
				this.adaptor, "rule stringExpression");
		try {
			// OPPLParser.g:117:3: ( stringExpression ( PLUS stringExpression )*
			// -> ^( STRING_OPERATION ( stringExpression )+ ) )
			// OPPLParser.g:118:5: stringExpression ( PLUS stringExpression )*
			{
				this.pushFollow(FOLLOW_stringExpression_in_stringOperation928);
				stringExpression77 = this.stringExpression();
				this.state._fsp--;
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_stringExpression.add(stringExpression77.getTree());
				}
				// OPPLParser.g:118:22: ( PLUS stringExpression )*
				loop14: do {
					int alt14 = 2;
					int LA14_0 = this.input.LA(1);
					if (LA14_0 == PLUS) {
						alt14 = 1;
					}
					switch (alt14) {
					case 1:
						// OPPLParser.g:118:23: PLUS stringExpression
					{
						PLUS78 = (Token) this.match(this.input, PLUS,
								FOLLOW_PLUS_in_stringOperation931);
						if (this.state.failed) {
							return retval;
						}
						if (this.state.backtracking == 0) {
							stream_PLUS.add(PLUS78);
						}
						this
								.pushFollow(FOLLOW_stringExpression_in_stringOperation933);
						stringExpression79 = this.stringExpression();
						this.state._fsp--;
						if (this.state.failed) {
							return retval;
						}
						if (this.state.backtracking == 0) {
							stream_stringExpression.add(stringExpression79
									.getTree());
						}
					}
						break;
					default:
						break loop14;
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
					// 118:47: -> ^( STRING_OPERATION ( stringExpression )+ )
					{
						// OPPLParser.g:118:50: ^( STRING_OPERATION (
						// stringExpression )+ )
						{
							OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor
									.nil();
							root_1 = (OPPLSyntaxTree) this.adaptor.becomeRoot(
									(OPPLSyntaxTree) this.adaptor.create(
											STRING_OPERATION,
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
		} catch (RewriteEmptyStreamException e) {
			throw e;
		} finally {
		}
		return retval;
	}

	// $ANTLR end "stringOperation"
	public static class stringExpression_return extends ParserRuleReturnScope {
		OPPLSyntaxTree tree;

		public Object getTree() {
			return this.tree;
		}
	};

	// $ANTLR start "stringExpression"
	// OPPLParser.g:121:1: stringExpression : ( DBLQUOTE -> ^( DBLQUOTE ) |
	// variableAttributeReference -> ^( variableAttributeReference ) );
	public final OPPLPatternParser_OPPLParser.stringExpression_return stringExpression()
			throws RecognitionException {
		OPPLPatternParser_OPPLParser.stringExpression_return retval = new OPPLPatternParser_OPPLParser.stringExpression_return();
		retval.start = this.input.LT(1);
		OPPLSyntaxTree root_0 = null;
		Token DBLQUOTE80 = null;
		OPPLPatternParser_OPPLParser.variableAttributeReference_return variableAttributeReference81 = null;
		OPPLSyntaxTree DBLQUOTE80_tree = null;
		RewriteRuleTokenStream stream_DBLQUOTE = new RewriteRuleTokenStream(
				this.adaptor, "token DBLQUOTE");
		RewriteRuleSubtreeStream stream_variableAttributeReference = new RewriteRuleSubtreeStream(
				this.adaptor, "rule variableAttributeReference");
		try {
			// OPPLParser.g:122:2: ( DBLQUOTE -> ^( DBLQUOTE ) |
			// variableAttributeReference -> ^( variableAttributeReference ) )
			int alt15 = 2;
			int LA15_0 = this.input.LA(1);
			if (LA15_0 == DBLQUOTE) {
				alt15 = 1;
			} else if (LA15_0 == VARIABLE_NAME) {
				alt15 = 2;
			} else {
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
				// OPPLParser.g:123:3: DBLQUOTE
			{
				DBLQUOTE80 = (Token) this.match(this.input, DBLQUOTE,
						FOLLOW_DBLQUOTE_in_stringExpression960);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_DBLQUOTE.add(DBLQUOTE80);
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
					// 123:12: -> ^( DBLQUOTE )
					{
						// OPPLParser.g:123:15: ^( DBLQUOTE )
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
				// OPPLParser.g:124:8: variableAttributeReference
			{
				this
						.pushFollow(FOLLOW_variableAttributeReference_in_stringExpression975);
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
					// 124:35: -> ^( variableAttributeReference )
					{
						// OPPLParser.g:124:38: ^( variableAttributeReference )
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
		} catch (RewriteEmptyStreamException e) {
			throw e;
		} finally {
		}
		return retval;
	}

	// $ANTLR end "stringExpression"
	public static class createIdentifier_return extends ParserRuleReturnScope {
		OPPLSyntaxTree tree;

		public Object getTree() {
			return this.tree;
		}
	};

	// $ANTLR start "createIdentifier"
	// OPPLParser.g:137:1: createIdentifier : ESCLAMATION_MARK IDENTIFIER -> ^(
	// IDENTIFIER[$ESCLAMATION_MARK.getText()+ $IDENTIFIER.getText()] ) ;
	public final OPPLPatternParser_OPPLParser.createIdentifier_return createIdentifier()
			throws RecognitionException {
		OPPLPatternParser_OPPLParser.createIdentifier_return retval = new OPPLPatternParser_OPPLParser.createIdentifier_return();
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
			// OPPLParser.g:138:3: ( ESCLAMATION_MARK IDENTIFIER -> ^(
			// IDENTIFIER[$ESCLAMATION_MARK.getText()+ $IDENTIFIER.getText()] )
			// )
			// OPPLParser.g:139:4: ESCLAMATION_MARK IDENTIFIER
			{
				ESCLAMATION_MARK82 = (Token) this.match(this.input,
						ESCLAMATION_MARK,
						FOLLOW_ESCLAMATION_MARK_in_createIdentifier1070);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_ESCLAMATION_MARK.add(ESCLAMATION_MARK82);
				}
				IDENTIFIER83 = (Token) this.match(this.input, IDENTIFIER,
						FOLLOW_IDENTIFIER_in_createIdentifier1072);
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
					// 139:33: -> ^( IDENTIFIER[$ESCLAMATION_MARK.getText()+
					// $IDENTIFIER.getText()] )
					{
						// OPPLParser.g:139:36: ^(
						// IDENTIFIER[$ESCLAMATION_MARK.getText()+
						// $IDENTIFIER.getText()] )
						{
							OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor
									.nil();
							root_1 = (OPPLSyntaxTree) this.adaptor.becomeRoot(
									(OPPLSyntaxTree) this.adaptor.create(
											IDENTIFIER, ESCLAMATION_MARK82
													.getText()
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
		} catch (RewriteEmptyStreamException e) {
			throw e;
		} finally {
		}
		return retval;
	}

	// $ANTLR end "createIdentifier"
	public static class variableAttributeReference_return extends
			ParserRuleReturnScope {
		OPPLSyntaxTree tree;

		public Object getTree() {
			return this.tree;
		}
	};

	// $ANTLR start "variableAttributeReference"
	// OPPLParser.g:142:1: variableAttributeReference : ( VARIABLE_NAME DOT (a=
	// VALUES | a= RENDERING ) -> ^(
	// IDENTIFIER[$VARIABLE_NAME.getText()+$DOT.getText() + $a.getText()]
	// VARIABLE_NAME DOT $a) | VARIABLE_NAME DOT GROUPS attributeSelector -> ^(
	// IDENTIFIER[$VARIABLE_NAME.getText()+$DOT.getText() +
	// $GROUPS.getText()+$attributeSelector.selectorText] VARIABLE_NAME DOT
	// GROUPS attributeSelector ) );
	public final OPPLPatternParser_OPPLParser.variableAttributeReference_return variableAttributeReference()
			throws RecognitionException {
		OPPLPatternParser_OPPLParser.variableAttributeReference_return retval = new OPPLPatternParser_OPPLParser.variableAttributeReference_return();
		retval.start = this.input.LT(1);
		OPPLSyntaxTree root_0 = null;
		Token a = null;
		Token VARIABLE_NAME84 = null;
		Token DOT85 = null;
		Token VARIABLE_NAME86 = null;
		Token DOT87 = null;
		Token GROUPS88 = null;
		OPPLPatternParser_OPPLParser.attributeSelector_return attributeSelector89 = null;
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
			// OPPLParser.g:143:3: ( VARIABLE_NAME DOT (a= VALUES | a= RENDERING
			// ) -> ^( IDENTIFIER[$VARIABLE_NAME.getText()+$DOT.getText() +
			// $a.getText()] VARIABLE_NAME DOT $a) | VARIABLE_NAME DOT GROUPS
			// attributeSelector -> ^(
			// IDENTIFIER[$VARIABLE_NAME.getText()+$DOT.getText() +
			// $GROUPS.getText()+$attributeSelector.selectorText] VARIABLE_NAME
			// DOT GROUPS attributeSelector ) )
			int alt18 = 2;
			int LA18_0 = this.input.LA(1);
			if (LA18_0 == VARIABLE_NAME) {
				int LA18_1 = this.input.LA(2);
				if (LA18_1 == DOT) {
					int LA18_2 = this.input.LA(3);
					if (LA18_2 == GROUPS) {
						alt18 = 2;
					} else if (LA18_2 >= VALUES && LA18_2 <= RENDERING) {
						alt18 = 1;
					} else {
						if (this.state.backtracking > 0) {
							this.state.failed = true;
							return retval;
						}
						NoViableAltException nvae = new NoViableAltException(
								"", 18, 2, this.input);
						throw nvae;
					}
				} else {
					if (this.state.backtracking > 0) {
						this.state.failed = true;
						return retval;
					}
					NoViableAltException nvae = new NoViableAltException("",
							18, 1, this.input);
					throw nvae;
				}
			} else {
				if (this.state.backtracking > 0) {
					this.state.failed = true;
					return retval;
				}
				NoViableAltException nvae = new NoViableAltException("", 18, 0,
						this.input);
				throw nvae;
			}
			switch (alt18) {
			case 1:
				// OPPLParser.g:144:5: VARIABLE_NAME DOT (a= VALUES | a=
				// RENDERING )
			{
				VARIABLE_NAME84 = (Token) this.match(this.input, VARIABLE_NAME,
						FOLLOW_VARIABLE_NAME_in_variableAttributeReference1099);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_VARIABLE_NAME.add(VARIABLE_NAME84);
				}
				DOT85 = (Token) this.match(this.input, DOT,
						FOLLOW_DOT_in_variableAttributeReference1101);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_DOT.add(DOT85);
				}
				// OPPLParser.g:144:23: (a= VALUES | a= RENDERING )
				int alt17 = 2;
				int LA17_0 = this.input.LA(1);
				if (LA17_0 == VALUES) {
					alt17 = 1;
				} else if (LA17_0 == RENDERING) {
					alt17 = 2;
				} else {
					if (this.state.backtracking > 0) {
						this.state.failed = true;
						return retval;
					}
					NoViableAltException nvae = new NoViableAltException("",
							17, 0, this.input);
					throw nvae;
				}
				switch (alt17) {
				case 1:
					// OPPLParser.g:144:24: a= VALUES
				{
					a = (Token) this.match(this.input, VALUES,
							FOLLOW_VALUES_in_variableAttributeReference1108);
					if (this.state.failed) {
						return retval;
					}
					if (this.state.backtracking == 0) {
						stream_VALUES.add(a);
					}
				}
					break;
				case 2:
					// OPPLParser.g:144:37: a= RENDERING
				{
					a = (Token) this.match(this.input, RENDERING,
							FOLLOW_RENDERING_in_variableAttributeReference1116);
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
				// elements: a, VARIABLE_NAME, DOT
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
					// 144:54: -> ^(
					// IDENTIFIER[$VARIABLE_NAME.getText()+$DOT.getText() +
					// $a.getText()] VARIABLE_NAME DOT $a)
					{
						// OPPLParser.g:144:56: ^(
						// IDENTIFIER[$VARIABLE_NAME.getText()+$DOT.getText() +
						// $a.getText()] VARIABLE_NAME DOT $a)
						{
							OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor
									.nil();
							root_1 = (OPPLSyntaxTree) this.adaptor.becomeRoot(
									(OPPLSyntaxTree) this.adaptor.create(
											IDENTIFIER, VARIABLE_NAME84
													.getText()
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
				// OPPLParser.g:145:7: VARIABLE_NAME DOT GROUPS
				// attributeSelector
			{
				VARIABLE_NAME86 = (Token) this.match(this.input, VARIABLE_NAME,
						FOLLOW_VARIABLE_NAME_in_variableAttributeReference1140);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_VARIABLE_NAME.add(VARIABLE_NAME86);
				}
				DOT87 = (Token) this.match(this.input, DOT,
						FOLLOW_DOT_in_variableAttributeReference1142);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_DOT.add(DOT87);
				}
				GROUPS88 = (Token) this.match(this.input, GROUPS,
						FOLLOW_GROUPS_in_variableAttributeReference1144);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_GROUPS.add(GROUPS88);
				}
				this
						.pushFollow(FOLLOW_attributeSelector_in_variableAttributeReference1146);
				attributeSelector89 = this.attributeSelector();
				this.state._fsp--;
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_attributeSelector.add(attributeSelector89.getTree());
				}
				// AST REWRITE
				// elements: GROUPS, VARIABLE_NAME, attributeSelector, DOT
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
					// 145:51: -> ^(
					// IDENTIFIER[$VARIABLE_NAME.getText()+$DOT.getText() +
					// $GROUPS.getText()+$attributeSelector.selectorText]
					// VARIABLE_NAME DOT GROUPS attributeSelector )
					{
						// OPPLParser.g:145:53: ^(
						// IDENTIFIER[$VARIABLE_NAME.getText()+$DOT.getText() +
						// $GROUPS.getText()+$attributeSelector.selectorText]
						// VARIABLE_NAME DOT GROUPS attributeSelector )
						{
							OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor
									.nil();
							root_1 = (OPPLSyntaxTree) this.adaptor
									.becomeRoot(
											(OPPLSyntaxTree) this.adaptor
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
		} catch (RewriteEmptyStreamException e) {
			throw e;
		} finally {
		}
		return retval;
	}

	// $ANTLR end "variableAttributeReference"
	public static class attributeSelector_return extends ParserRuleReturnScope {
		public String selectorText;
		OPPLSyntaxTree tree;

		public Object getTree() {
			return this.tree;
		}
	};

	// $ANTLR start "attributeSelector"
	// OPPLParser.g:150:1: attributeSelector returns [String selectorText] :
	// OPEN_PARENTHESYS i= INTEGER CLOSED_PARENTHESYS -> ^( ATTRIBUTE_SELECTOR
	// INTEGER ) ;
	public final OPPLPatternParser_OPPLParser.attributeSelector_return attributeSelector()
			throws RecognitionException {
		OPPLPatternParser_OPPLParser.attributeSelector_return retval = new OPPLPatternParser_OPPLParser.attributeSelector_return();
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
			// OPPLParser.g:151:3: ( OPEN_PARENTHESYS i= INTEGER
			// CLOSED_PARENTHESYS -> ^( ATTRIBUTE_SELECTOR INTEGER ) )
			// OPPLParser.g:152:5: OPEN_PARENTHESYS i= INTEGER
			// CLOSED_PARENTHESYS
			{
				OPEN_PARENTHESYS90 = (Token) this.match(this.input,
						OPEN_PARENTHESYS,
						FOLLOW_OPEN_PARENTHESYS_in_attributeSelector1195);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_OPEN_PARENTHESYS.add(OPEN_PARENTHESYS90);
				}
				i = (Token) this.match(this.input, INTEGER,
						FOLLOW_INTEGER_in_attributeSelector1201);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_INTEGER.add(i);
				}
				CLOSED_PARENTHESYS91 = (Token) this.match(this.input,
						CLOSED_PARENTHESYS,
						FOLLOW_CLOSED_PARENTHESYS_in_attributeSelector1203);
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
					// 156:5: -> ^( ATTRIBUTE_SELECTOR INTEGER )
					{
						// OPPLParser.g:156:9: ^( ATTRIBUTE_SELECTOR INTEGER )
						{
							OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor
									.nil();
							root_1 = (OPPLSyntaxTree) this.adaptor.becomeRoot(
									(OPPLSyntaxTree) this.adaptor.create(
											ATTRIBUTE_SELECTOR,
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
		} catch (RewriteEmptyStreamException e) {
			throw e;
		} finally {
		}
		return retval;
	}

	// $ANTLR end "attributeSelector"
	// Delegated rules
	public static final BitSet FOLLOW_variableDefinition_in_variableDefinitions216 = new BitSet(
			new long[] { 0x0000002000000002L });
	public static final BitSet FOLLOW_COMMA_in_variableDefinitions219 = new BitSet(
			new long[] { 0x0000000000000000L, 0x0000000000000000L,
					0x0000000000000000L, 0x0000000000000000L,
					0x0000000000000000L, 0x0000000000000000L,
					0x0000000000000000L, 0x0000000000010000L });
	public static final BitSet FOLLOW_variableDefinition_in_variableDefinitions221 = new BitSet(
			new long[] { 0x0000002000000002L });
	public static final BitSet FOLLOW_VARIABLE_NAME_in_variableDefinition255 = new BitSet(
			new long[] { 0x0000000000000000L, 0x0000000000002000L });
	public static final BitSet FOLLOW_COLON_in_variableDefinition257 = new BitSet(
			new long[] { 0x0000000000000000L, 0x0000000002000000L });
	public static final BitSet FOLLOW_VARIABLE_TYPE_in_variableDefinition259 = new BitSet(
			new long[] { 0x0000000000000000L, 0x0000000000000200L });
	public static final BitSet FOLLOW_EQUAL_in_variableDefinition262 = new BitSet(
			new long[] { 0x0000000000000000L, 0x0000000000070000L });
	public static final BitSet FOLLOW_opplFunction_in_variableDefinition264 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_VARIABLE_NAME_in_variableDefinition292 = new BitSet(
			new long[] { 0x0000000000000000L, 0x0000000000002000L });
	public static final BitSet FOLLOW_COLON_in_variableDefinition294 = new BitSet(
			new long[] { 0x0000000000000000L, 0x0000000002000000L });
	public static final BitSet FOLLOW_VARIABLE_TYPE_in_variableDefinition296 = new BitSet(
			new long[] { 0x0000000000000000L, 0x0000000000000200L });
	public static final BitSet FOLLOW_EQUAL_in_variableDefinition299 = new BitSet(
			new long[] { 0x0000310000081060L, 0x0000000000000000L,
					0x0000000000200000L, 0x0000000000000000L,
					0x0000000000000000L, 0x0000000000000000L,
					0x0000000100010000L, 0x0000000000010000L });
	public static final BitSet FOLLOW_expression_in_variableDefinition301 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_VARIABLE_NAME_in_variableDefinition325 = new BitSet(
			new long[] { 0x0000000000000000L, 0x0000000000002000L });
	public static final BitSet FOLLOW_COLON_in_variableDefinition327 = new BitSet(
			new long[] { 0x0000000000000000L, 0x0000000002000000L });
	public static final BitSet FOLLOW_VARIABLE_TYPE_in_variableDefinition329 = new BitSet(
			new long[] { 0x0000000000000000L, 0x0000000000000200L });
	public static final BitSet FOLLOW_EQUAL_in_variableDefinition332 = new BitSet(
			new long[] { 0x0000000000000000L, 0x0000000000000000L,
					0x0001000000000000L });
	public static final BitSet FOLLOW_regexp_in_variableDefinition334 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_VARIABLE_NAME_in_variableDefinition354 = new BitSet(
			new long[] { 0x0000000000000000L, 0x0000000000002000L });
	public static final BitSet FOLLOW_COLON_in_variableDefinition356 = new BitSet(
			new long[] { 0x0000000000000000L, 0x0000000002000000L });
	public static final BitSet FOLLOW_VARIABLE_TYPE_in_variableDefinition358 = new BitSet(
			new long[] { 0x0000000000000002L, 0x0000000000200000L });
	public static final BitSet FOLLOW_variableScope_in_variableDefinition361 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_OPEN_SQUARE_BRACKET_in_variableScope401 = new BitSet(
			new long[] { 0x000000C000100000L, 0x0000020001800000L });
	public static final BitSet FOLLOW_SUBCLASS_OF_in_variableScope408 = new BitSet(
			new long[] { 0x0000310000081060L, 0x0000000000400000L,
					0x0000000000200000L, 0x0000000000000000L,
					0x0000000000000000L, 0x0000000000000000L,
					0x0000000100010000L, 0x0000000000010000L });
	public static final BitSet FOLLOW_SUBPROPERTY_OF_in_variableScope416 = new BitSet(
			new long[] { 0x0000310000081060L, 0x0000000000400000L,
					0x0000000000200000L, 0x0000000000000000L,
					0x0000000000000000L, 0x0000000000000000L,
					0x0000000100010000L, 0x0000000000010000L });
	public static final BitSet FOLLOW_SUPER_CLASS_OF_in_variableScope424 = new BitSet(
			new long[] { 0x0000310000081060L, 0x0000000000400000L,
					0x0000000000200000L, 0x0000000000000000L,
					0x0000000000000000L, 0x0000000000000000L,
					0x0000000100010000L, 0x0000000000010000L });
	public static final BitSet FOLLOW_SUPER_PROPERTY_OF_in_variableScope432 = new BitSet(
			new long[] { 0x0000310000081060L, 0x0000000000400000L,
					0x0000000000200000L, 0x0000000000000000L,
					0x0000000000000000L, 0x0000000000000000L,
					0x0000000100010000L, 0x0000000000010000L });
	public static final BitSet FOLLOW_INSTANCE_OF_in_variableScope441 = new BitSet(
			new long[] { 0x0000310000081060L, 0x0000000000400000L,
					0x0000000000200000L, 0x0000000000000000L,
					0x0000000000000000L, 0x0000000000000000L,
					0x0000000100010000L, 0x0000000000010000L });
	public static final BitSet FOLLOW_TYPES_in_variableScope449 = new BitSet(
			new long[] { 0x0000310000081060L, 0x0000000000400000L,
					0x0000000000200000L, 0x0000000000000000L,
					0x0000000000000000L, 0x0000000000000000L,
					0x0000000100010000L, 0x0000000000010000L });
	public static final BitSet FOLLOW_expression_in_variableScope452 = new BitSet(
			new long[] { 0x0000000000000000L, 0x0000000000400000L });
	public static final BitSet FOLLOW_CLOSED_SQUARE_BRACKET_in_variableScope454 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_MATCH_in_regexp484 = new BitSet(
			new long[] { 0x0000000000000020L });
	public static final BitSet FOLLOW_OPEN_PARENTHESYS_in_regexp486 = new BitSet(
			new long[] { 0x0000010000000000L, 0x0000000000000000L,
					0x0000000000000000L, 0x0000000000000000L,
					0x0000000000000000L, 0x0000000000000000L,
					0x0000000000000000L, 0x0000000000010000L });
	public static final BitSet FOLLOW_stringOperation_in_regexp488 = new BitSet(
			new long[] { 0x0000000000000100L });
	public static final BitSet FOLLOW_CLOSED_PARENTHESYS_in_regexp490 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_SELECT_in_query515 = new BitSet(
			new long[] { 0x0000310FE4781060L, 0x0000000000001000L,
					0x0000000000200000L, 0x0000000000000000L,
					0x0000000000000000L, 0x0000000000000000L,
					0x0000000100010000L, 0x0000000000010000L });
	public static final BitSet FOLLOW_selectClause_in_query517 = new BitSet(
			new long[] { 0x0000002000000002L, 0x0000000000000080L });
	public static final BitSet FOLLOW_COMMA_in_query520 = new BitSet(
			new long[] { 0x0000310FE4781060L, 0x0000000000001000L,
					0x0000000000200000L, 0x0000000000000000L,
					0x0000000000000000L, 0x0000000000000000L,
					0x0000000100010000L, 0x0000000000010000L });
	public static final BitSet FOLLOW_selectClause_in_query522 = new BitSet(
			new long[] { 0x0000002000000002L, 0x0000000000000080L });
	public static final BitSet FOLLOW_WHERE_in_query527 = new BitSet(
			new long[] { 0x0000000000000000L, 0x0000000000000000L,
					0x0000000000000000L, 0x0000000000000000L,
					0x0000000000000000L, 0x0000000000000000L,
					0x0000000000000000L, 0x0000000000050000L });
	public static final BitSet FOLLOW_constraint_in_query529 = new BitSet(
			new long[] { 0x0000002000000002L });
	public static final BitSet FOLLOW_COMMA_in_query532 = new BitSet(
			new long[] { 0x0000000000000000L, 0x0000000000000000L,
					0x0000000000000000L, 0x0000000000000000L,
					0x0000000000000000L, 0x0000000000000000L,
					0x0000000000000000L, 0x0000000000050000L });
	public static final BitSet FOLLOW_constraint_in_query534 = new BitSet(
			new long[] { 0x0000002000000002L });
	public static final BitSet FOLLOW_ASSERTED_in_selectClause571 = new BitSet(
			new long[] { 0x0000310FE4781060L, 0x0000000000001000L,
					0x0000000000200000L, 0x0000000000000000L,
					0x0000000000000000L, 0x0000000000000000L,
					0x0000000100010000L, 0x0000000000010000L });
	public static final BitSet FOLLOW_axiom_in_selectClause573 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_axiom_in_selectClause589 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_VARIABLE_NAME_in_constraint628 = new BitSet(
			new long[] { 0x0000000000000000L, 0x0000000000000100L });
	public static final BitSet FOLLOW_NOT_EQUAL_in_constraint630 = new BitSet(
			new long[] { 0x0000310000081060L, 0x0000000000000000L,
					0x0000000000200000L, 0x0000000000000000L,
					0x0000000000000000L, 0x0000000000000000L,
					0x0000000100010000L, 0x0000000000010000L });
	public static final BitSet FOLLOW_expression_in_constraint636 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_VARIABLE_NAME_in_constraint661 = new BitSet(
			new long[] { 0x0000000000000000L, 0x0000000000000400L });
	public static final BitSet FOLLOW_IN_in_constraint663 = new BitSet(
			new long[] { 0x0000000000000040L });
	public static final BitSet FOLLOW_OPEN_CURLY_BRACES_in_constraint665 = new BitSet(
			new long[] { 0x0000300000000000L, 0x0000000000000000L,
					0x0000000000200000L, 0x0000000000000000L,
					0x0000000000000000L, 0x0000000000000000L,
					0x0000000100010000L, 0x0000000000010000L });
	public static final BitSet FOLLOW_atomic_in_constraint667 = new BitSet(
			new long[] { 0x0000002000000080L });
	public static final BitSet FOLLOW_COMMA_in_constraint670 = new BitSet(
			new long[] { 0x0000300000000000L, 0x0000000000000000L,
					0x0000000000200000L, 0x0000000000000000L,
					0x0000000000000000L, 0x0000000000000000L,
					0x0000000100010000L, 0x0000000000010000L });
	public static final BitSet FOLLOW_atomic_in_constraint672 = new BitSet(
			new long[] { 0x0000002000000080L });
	public static final BitSet FOLLOW_CLOSED_CURLY_BRACES_in_constraint676 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_VARIABLE_NAME_in_constraint698 = new BitSet(
			new long[] { 0x0000000000000000L, 0x0000000000000000L,
					0x0001000000000000L });
	public static final BitSet FOLLOW_MATCH_in_constraint700 = new BitSet(
			new long[] { 0x0000000000000020L });
	public static final BitSet FOLLOW_OPEN_PARENTHESYS_in_constraint702 = new BitSet(
			new long[] { 0x0000010000000000L, 0x0000000000000000L,
					0x0000000000000000L, 0x0000000000000000L,
					0x0000000000000000L, 0x0000000000000000L,
					0x0000000000000000L, 0x0000000000010000L });
	public static final BitSet FOLLOW_stringOperation_in_constraint704 = new BitSet(
			new long[] { 0x0000000000000100L });
	public static final BitSet FOLLOW_CLOSED_PARENTHESYS_in_constraint706 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_FAIL_in_constraint725 = new BitSet(
			new long[] { 0x0000310FE4781060L, 0x0000000000001000L,
					0x0000000000200000L, 0x0000000000000000L,
					0x0000000000000000L, 0x0000000000000000L,
					0x0000000100010000L, 0x0000000000010000L });
	public static final BitSet FOLLOW_axiom_in_constraint727 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_BEGIN_in_actions755 = new BitSet(
			new long[] { 0x0000000000000000L, 0x000000000C000000L });
	public static final BitSet FOLLOW_action_in_actions757 = new BitSet(
			new long[] { 0x0000002000000000L, 0x0000000000100000L });
	public static final BitSet FOLLOW_COMMA_in_actions760 = new BitSet(
			new long[] { 0x0000000000000000L, 0x000000000C000000L });
	public static final BitSet FOLLOW_action_in_actions762 = new BitSet(
			new long[] { 0x0000002000000000L, 0x0000000000100000L });
	public static final BitSet FOLLOW_END_in_actions766 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_ADD_in_action798 = new BitSet(new long[] {
			0x0000310FE4781060L, 0x0000000000001000L, 0x0000000000200000L,
			0x0000000000000000L, 0x0000000000000000L, 0x0000000000000000L,
			0x0000000100010000L, 0x0000000000010000L });
	public static final BitSet FOLLOW_axiom_in_action800 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_REMOVE_in_action816 = new BitSet(
			new long[] { 0x0000310FE4781060L, 0x0000000000001000L,
					0x0000000000200000L, 0x0000000000000000L,
					0x0000000000000000L, 0x0000000000000000L,
					0x0000000100010000L, 0x0000000000010000L });
	public static final BitSet FOLLOW_axiom_in_action818 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_CREATE_in_opplFunction851 = new BitSet(
			new long[] { 0x0000000000000020L });
	public static final BitSet FOLLOW_OPEN_PARENTHESYS_in_opplFunction853 = new BitSet(
			new long[] { 0x0000010000000000L, 0x0000000000000000L,
					0x0000000000000000L, 0x0000000000000000L,
					0x0000000000000000L, 0x0000000000000000L,
					0x0000000000000000L, 0x0000000000010000L });
	public static final BitSet FOLLOW_stringOperation_in_opplFunction855 = new BitSet(
			new long[] { 0x0000000000000100L });
	public static final BitSet FOLLOW_CLOSED_PARENTHESYS_in_opplFunction857 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_CREATE_INTERSECTION_in_opplFunction873 = new BitSet(
			new long[] { 0x0000000000000020L });
	public static final BitSet FOLLOW_OPEN_PARENTHESYS_in_opplFunction876 = new BitSet(
			new long[] { 0x0000300000000000L, 0x0000000000000000L,
					0x0000000000200000L, 0x0000000000000000L,
					0x0000000000000000L, 0x0000000000000000L,
					0x0000000100010000L, 0x0000000000010000L });
	public static final BitSet FOLLOW_atomic_in_opplFunction878 = new BitSet(
			new long[] { 0x0000000000000100L });
	public static final BitSet FOLLOW_CLOSED_PARENTHESYS_in_opplFunction881 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_CREATE_DISJUNCTION_in_opplFunction897 = new BitSet(
			new long[] { 0x0000000000000020L });
	public static final BitSet FOLLOW_OPEN_PARENTHESYS_in_opplFunction899 = new BitSet(
			new long[] { 0x0000300000000000L, 0x0000000000000000L,
					0x0000000000200000L, 0x0000000000000000L,
					0x0000000000000000L, 0x0000000000000000L,
					0x0000000100010000L, 0x0000000000010000L });
	public static final BitSet FOLLOW_atomic_in_opplFunction901 = new BitSet(
			new long[] { 0x0000000000000100L });
	public static final BitSet FOLLOW_CLOSED_PARENTHESYS_in_opplFunction903 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_stringExpression_in_stringOperation928 = new BitSet(
			new long[] { 0x0000000000000002L, 0x0000000000008000L });
	public static final BitSet FOLLOW_PLUS_in_stringOperation931 = new BitSet(
			new long[] { 0x0000010000000000L, 0x0000000000000000L,
					0x0000000000000000L, 0x0000000000000000L,
					0x0000000000000000L, 0x0000000000000000L,
					0x0000000000000000L, 0x0000000000010000L });
	public static final BitSet FOLLOW_stringExpression_in_stringOperation933 = new BitSet(
			new long[] { 0x0000000000000002L, 0x0000000000008000L });
	public static final BitSet FOLLOW_DBLQUOTE_in_stringExpression960 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_variableAttributeReference_in_stringExpression975 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_ESCLAMATION_MARK_in_createIdentifier1070 = new BitSet(
			new long[] { 0x0000100000000000L });
	public static final BitSet FOLLOW_IDENTIFIER_in_createIdentifier1072 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_VARIABLE_NAME_in_variableAttributeReference1099 = new BitSet(
			new long[] { 0x0000000000000000L, 0x0000000000004000L });
	public static final BitSet FOLLOW_DOT_in_variableAttributeReference1101 = new BitSet(
			new long[] { 0x0000000000000000L, 0x0000000000000000L,
					0x0000000000000000L, 0x0000000000000000L,
					0x0000000000000000L, 0x0000000C00000000L });
	public static final BitSet FOLLOW_VALUES_in_variableAttributeReference1108 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_RENDERING_in_variableAttributeReference1116 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_VARIABLE_NAME_in_variableAttributeReference1140 = new BitSet(
			new long[] { 0x0000000000000000L, 0x0000000000004000L });
	public static final BitSet FOLLOW_DOT_in_variableAttributeReference1142 = new BitSet(
			new long[] { 0x0000000000000000L, 0x0000000000000000L,
					0x0000000000000000L, 0x0000000000000000L,
					0x0000000000000000L, 0x0000001000000000L });
	public static final BitSet FOLLOW_GROUPS_in_variableAttributeReference1144 = new BitSet(
			new long[] { 0x0000000000000020L });
	public static final BitSet FOLLOW_attributeSelector_in_variableAttributeReference1146 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_OPEN_PARENTHESYS_in_attributeSelector1195 = new BitSet(
			new long[] { 0x0000040000000000L });
	public static final BitSet FOLLOW_INTEGER_in_attributeSelector1201 = new BitSet(
			new long[] { 0x0000000000000100L });
	public static final BitSet FOLLOW_CLOSED_PARENTHESYS_in_attributeSelector1203 = new BitSet(
			new long[] { 0x0000000000000002L });
}