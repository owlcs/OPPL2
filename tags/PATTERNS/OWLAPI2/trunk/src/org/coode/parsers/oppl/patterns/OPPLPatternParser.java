package org.coode.parsers.oppl.patterns;

// $ANTLR 3.2 Sep 23, 2009 12:02:23 /Users/luigi/Documents/workspace/Parsers_OWL_API_2/src/OPPLPatternParser.g 2010-08-27 12:09:15
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
import org.antlr.runtime.tree.RewriteRuleSubtreeStream;
import org.antlr.runtime.tree.RewriteRuleTokenStream;
import org.antlr.runtime.tree.TreeAdaptor;
import org.coode.parsers.oppl.OPPLSyntaxTree;

public class OPPLPatternParser extends Parser {
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
			"ESCLAMATION_MARK", "CREATE_IDENTIFIER", "PLAIN_IDENTIFIER",
			"MATCH", "ATTRIBUTE_SELECTOR", "VALUES", "RENDERING", "GROUPS",
			"STRING_OPERATION", "DOLLAR", "RETURN", "THIS_CLASS", "ARGUMENTS",
			"OPPL_PATTERN", "PATTERN_REFERENCE", "SEMICOLON", "VARIABLE_NAME",
			"REGEXP_CONSTRAINT", "FAIL", "NAF_CONSTRAINT", "468", "469", "470",
			"471", "472", "473", "474", "475", "476", "477", "478", "479",
			"480", "481", "482", "483", "484", "485", "486", "487", "488",
			"489", "490", "491", "492", "493", "494", "495", "496", "497",
			"498", "499", "500", "501", "502", "503", "504", "505", "506",
			"507", "508", "509", "510", "511", "512", "513", "514", "515",
			"516", "517", "518", "519", "520", "521", "522", "523", "524",
			"525", "526", "527", "528", "529", "530", "531", "532", "533",
			"534", "535", "536", "537", "538", "539", "540", "541", "542",
			"543", "544", "545", "546", "547", "548", "549", "550", "551",
			"552", "553", "554", "555", "556", "557", "558", "559", "560",
			"561", "562", "563", "564", "565", "566", "567", "568", "569",
			"570", "571", "572", "573", "574", "575" };
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
	public OPPLPatternParser_OPPLParser gOPPLParser;

	// delegators
	public OPPLPatternParser(TokenStream input) {
		this(input, new RecognizerSharedState());
	}

	public OPPLPatternParser(TokenStream input, RecognizerSharedState state) {
		super(input, state);
		this.gOPPLParser = new OPPLPatternParser_OPPLParser(input, state, this);
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
		return OPPLPatternParser.tokenNames;
	}

	@Override
	public String getGrammarFileName() {
		return "/Users/luigi/Documents/workspace/Parsers_OWL_API_2/src/OPPLPatternParser.g";
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

	public static class atomic_return extends ParserRuleReturnScope {
		OPPLSyntaxTree tree;

		@Override
		public Object getTree() {
			return this.tree;
		}
	};

	// $ANTLR start "atomic"
	// /Users/luigi/Documents/workspace/Parsers_OWL_API_2/src/OPPLPatternParser.g:32:2:
	// atomic : ( IDENTIFIER | ENTITY_REFERENCE -> ^( ENTITY_REFERENCE ) |
	// VARIABLE_NAME -> ^( IDENTIFIER[$VARIABLE_NAME] ) | createIdentifier -> ^(
	// createIdentifier ) | variableAttributeReference -> ^(
	// variableAttributeReference ) | THIS_CLASS -> ^( IDENTIFIER[$THIS_CLASS]
	// THIS_CLASS ) | patternReference -> ^( patternReference ) );
	public final OPPLPatternParser.atomic_return atomic()
			throws RecognitionException {
		OPPLPatternParser.atomic_return retval = new OPPLPatternParser.atomic_return();
		retval.start = this.input.LT(1);
		OPPLSyntaxTree root_0 = null;
		Token IDENTIFIER1 = null;
		Token ENTITY_REFERENCE2 = null;
		Token VARIABLE_NAME3 = null;
		Token THIS_CLASS6 = null;
		OPPLPatternParser_OPPLParser.createIdentifier_return createIdentifier4 = null;
		OPPLPatternParser_OPPLParser.variableAttributeReference_return variableAttributeReference5 = null;
		OPPLPatternParser.patternReference_return patternReference7 = null;
		OPPLSyntaxTree IDENTIFIER1_tree = null;
		OPPLSyntaxTree ENTITY_REFERENCE2_tree = null;
		OPPLSyntaxTree VARIABLE_NAME3_tree = null;
		OPPLSyntaxTree THIS_CLASS6_tree = null;
		RewriteRuleTokenStream stream_THIS_CLASS = new RewriteRuleTokenStream(
				this.adaptor, "token THIS_CLASS");
		RewriteRuleTokenStream stream_VARIABLE_NAME = new RewriteRuleTokenStream(
				this.adaptor, "token VARIABLE_NAME");
		RewriteRuleTokenStream stream_ENTITY_REFERENCE = new RewriteRuleTokenStream(
				this.adaptor, "token ENTITY_REFERENCE");
		RewriteRuleSubtreeStream stream_patternReference = new RewriteRuleSubtreeStream(
				this.adaptor, "rule patternReference");
		RewriteRuleSubtreeStream stream_variableAttributeReference = new RewriteRuleSubtreeStream(
				this.adaptor, "rule variableAttributeReference");
		RewriteRuleSubtreeStream stream_createIdentifier = new RewriteRuleSubtreeStream(
				this.adaptor, "rule createIdentifier");
		try {
			// /Users/luigi/Documents/workspace/Parsers_OWL_API_2/src/OPPLPatternParser.g:32:16:
			// ( IDENTIFIER | ENTITY_REFERENCE -> ^( ENTITY_REFERENCE ) |
			// VARIABLE_NAME -> ^( IDENTIFIER[$VARIABLE_NAME] ) |
			// createIdentifier -> ^( createIdentifier ) |
			// variableAttributeReference -> ^( variableAttributeReference ) |
			// THIS_CLASS -> ^( IDENTIFIER[$THIS_CLASS] THIS_CLASS ) |
			// patternReference -> ^( patternReference ) )
			int alt1 = 7;
			switch (this.input.LA(1)) {
			case IDENTIFIER: {
				alt1 = 1;
			}
				break;
			case ENTITY_REFERENCE: {
				alt1 = 2;
			}
				break;
			case VARIABLE_NAME: {
				int LA1_3 = this.input.LA(2);
				if (LA1_3 == DOT) {
					alt1 = 5;
				} else if (LA1_3 == EOF || LA1_3 == COMPOSITION
						|| LA1_3 >= CLOSED_CURLY_BRACES
						&& LA1_3 <= CLOSED_PARENTHESYS || LA1_3 >= AND
						&& LA1_3 <= OR || LA1_3 >= SOME && LA1_3 <= RANGE
						|| LA1_3 >= COMMA && LA1_3 <= DBLQUOTE
						|| LA1_3 >= IDENTIFIER && LA1_3 <= ENTITY_REFERENCE
						|| LA1_3 == WHERE || LA1_3 == END
						|| LA1_3 == CLOSED_SQUARE_BRACKET
						|| LA1_3 == ESCLAMATION_MARK || LA1_3 == DOLLAR
						|| LA1_3 == THIS_CLASS || LA1_3 == VARIABLE_NAME) {
					alt1 = 3;
				} else {
					if (this.state.backtracking > 0) {
						this.state.failed = true;
						return retval;
					}
					NoViableAltException nvae = new NoViableAltException("", 1,
							3, this.input);
					throw nvae;
				}
			}
				break;
			case ESCLAMATION_MARK: {
				alt1 = 4;
			}
				break;
			case THIS_CLASS: {
				alt1 = 6;
			}
				break;
			case DOLLAR: {
				alt1 = 7;
			}
				break;
			default:
				if (this.state.backtracking > 0) {
					this.state.failed = true;
					return retval;
				}
				NoViableAltException nvae = new NoViableAltException("", 1, 0,
						this.input);
				throw nvae;
			}
			switch (alt1) {
			case 1:
				// /Users/luigi/Documents/workspace/Parsers_OWL_API_2/src/OPPLPatternParser.g:33:3:
				// IDENTIFIER
			{
				root_0 = (OPPLSyntaxTree) this.adaptor.nil();
				IDENTIFIER1 = (Token) this.match(this.input, IDENTIFIER,
						FOLLOW_IDENTIFIER_in_atomic104);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					IDENTIFIER1_tree = (OPPLSyntaxTree) this.adaptor
							.create(IDENTIFIER1);
					this.adaptor.addChild(root_0, IDENTIFIER1_tree);
				}
			}
				break;
			case 2:
				// /Users/luigi/Documents/workspace/Parsers_OWL_API_2/src/OPPLPatternParser.g:34:5:
				// ENTITY_REFERENCE
			{
				ENTITY_REFERENCE2 = (Token) this.match(this.input,
						ENTITY_REFERENCE, FOLLOW_ENTITY_REFERENCE_in_atomic111);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_ENTITY_REFERENCE.add(ENTITY_REFERENCE2);
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
					// 34:22: -> ^( ENTITY_REFERENCE )
					{
						// /Users/luigi/Documents/workspace/Parsers_OWL_API_2/src/OPPLPatternParser.g:34:25:
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
				// /Users/luigi/Documents/workspace/Parsers_OWL_API_2/src/OPPLPatternParser.g:35:5:
				// VARIABLE_NAME
			{
				VARIABLE_NAME3 = (Token) this.match(this.input, VARIABLE_NAME,
						FOLLOW_VARIABLE_NAME_in_atomic123);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_VARIABLE_NAME.add(VARIABLE_NAME3);
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
					// 35:19: -> ^( IDENTIFIER[$VARIABLE_NAME] )
					{
						// /Users/luigi/Documents/workspace/Parsers_OWL_API_2/src/OPPLPatternParser.g:35:22:
						// ^( IDENTIFIER[$VARIABLE_NAME] )
						{
							OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor
									.nil();
							root_1 = (OPPLSyntaxTree) this.adaptor
									.becomeRoot(
											(OPPLSyntaxTree) this.adaptor
													.create(IDENTIFIER,
															VARIABLE_NAME3),
											root_1);
							this.adaptor.addChild(root_0, root_1);
						}
					}
					retval.tree = root_0;
				}
			}
				break;
			case 4:
				// /Users/luigi/Documents/workspace/Parsers_OWL_API_2/src/OPPLPatternParser.g:36:8:
				// createIdentifier
			{
				this.pushFollow(FOLLOW_createIdentifier_in_atomic144);
				createIdentifier4 = this.createIdentifier();
				this.state._fsp--;
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_createIdentifier.add(createIdentifier4.getTree());
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
					// 36:25: -> ^( createIdentifier )
					{
						// /Users/luigi/Documents/workspace/Parsers_OWL_API_2/src/OPPLPatternParser.g:36:28:
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
				// /Users/luigi/Documents/workspace/Parsers_OWL_API_2/src/OPPLPatternParser.g:37:5:
				// variableAttributeReference
			{
				this.pushFollow(FOLLOW_variableAttributeReference_in_atomic156);
				variableAttributeReference5 = this.variableAttributeReference();
				this.state._fsp--;
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_variableAttributeReference
							.add(variableAttributeReference5.getTree());
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
					// 37:32: -> ^( variableAttributeReference )
					{
						// /Users/luigi/Documents/workspace/Parsers_OWL_API_2/src/OPPLPatternParser.g:37:35:
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
			case 6:
				// /Users/luigi/Documents/workspace/Parsers_OWL_API_2/src/OPPLPatternParser.g:38:5:
				// THIS_CLASS
			{
				THIS_CLASS6 = (Token) this.match(this.input, THIS_CLASS,
						FOLLOW_THIS_CLASS_in_atomic169);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_THIS_CLASS.add(THIS_CLASS6);
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
							this.adaptor, "rule retval",
							retval != null ? retval.tree : null);
					root_0 = (OPPLSyntaxTree) this.adaptor.nil();
					// 38:16: -> ^( IDENTIFIER[$THIS_CLASS] THIS_CLASS )
					{
						// /Users/luigi/Documents/workspace/Parsers_OWL_API_2/src/OPPLPatternParser.g:38:19:
						// ^( IDENTIFIER[$THIS_CLASS] THIS_CLASS )
						{
							OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor
									.nil();
							root_1 = (OPPLSyntaxTree) this.adaptor.becomeRoot(
									(OPPLSyntaxTree) this.adaptor.create(
											IDENTIFIER, THIS_CLASS6), root_1);
							this.adaptor.addChild(root_1, stream_THIS_CLASS
									.nextNode());
							this.adaptor.addChild(root_0, root_1);
						}
					}
					retval.tree = root_0;
				}
			}
				break;
			case 7:
				// /Users/luigi/Documents/workspace/Parsers_OWL_API_2/src/OPPLPatternParser.g:39:12:
				// patternReference
			{
				this.pushFollow(FOLLOW_patternReference_in_atomic191);
				patternReference7 = this.patternReference();
				this.state._fsp--;
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_patternReference.add(patternReference7.getTree());
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
							this.adaptor, "rule retval",
							retval != null ? retval.tree : null);
					root_0 = (OPPLSyntaxTree) this.adaptor.nil();
					// 39:29: -> ^( patternReference )
					{
						// /Users/luigi/Documents/workspace/Parsers_OWL_API_2/src/OPPLPatternParser.g:39:32:
						// ^( patternReference )
						{
							OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor
									.nil();
							root_1 = (OPPLSyntaxTree) this.adaptor.becomeRoot(
									stream_patternReference.nextNode(), root_1);
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
	public static class patternReference_return extends ParserRuleReturnScope {
		OPPLSyntaxTree tree;

		@Override
		public Object getTree() {
			return this.tree;
		}
	};

	// $ANTLR start "patternReference"
	// /Users/luigi/Documents/workspace/Parsers_OWL_API_2/src/OPPLPatternParser.g:43:1:
	// patternReference : DOLLAR name= IDENTIFIER arguments -> ^(
	// IDENTIFIER[$DOLLAR.getText() + name.getText() + $arguments.argsString]
	// PATTERN_REFERENCE[name.getText()] arguments ) ;
	public final OPPLPatternParser.patternReference_return patternReference()
			throws RecognitionException {
		OPPLPatternParser.patternReference_return retval = new OPPLPatternParser.patternReference_return();
		retval.start = this.input.LT(1);
		OPPLSyntaxTree root_0 = null;
		Token name = null;
		Token DOLLAR8 = null;
		OPPLPatternParser.arguments_return arguments9 = null;
		OPPLSyntaxTree name_tree = null;
		OPPLSyntaxTree DOLLAR8_tree = null;
		RewriteRuleTokenStream stream_DOLLAR = new RewriteRuleTokenStream(
				this.adaptor, "token DOLLAR");
		RewriteRuleTokenStream stream_IDENTIFIER = new RewriteRuleTokenStream(
				this.adaptor, "token IDENTIFIER");
		RewriteRuleSubtreeStream stream_arguments = new RewriteRuleSubtreeStream(
				this.adaptor, "rule arguments");
		try {
			// /Users/luigi/Documents/workspace/Parsers_OWL_API_2/src/OPPLPatternParser.g:44:2:
			// ( DOLLAR name= IDENTIFIER arguments -> ^(
			// IDENTIFIER[$DOLLAR.getText() + name.getText() +
			// $arguments.argsString] PATTERN_REFERENCE[name.getText()]
			// arguments ) )
			// /Users/luigi/Documents/workspace/Parsers_OWL_API_2/src/OPPLPatternParser.g:45:3:
			// DOLLAR name= IDENTIFIER arguments
			{
				DOLLAR8 = (Token) this.match(this.input, DOLLAR,
						FOLLOW_DOLLAR_in_patternReference214);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_DOLLAR.add(DOLLAR8);
				}
				name = (Token) this.match(this.input, IDENTIFIER,
						FOLLOW_IDENTIFIER_in_patternReference220);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_IDENTIFIER.add(name);
				}
				this.pushFollow(FOLLOW_arguments_in_patternReference224);
				arguments9 = this.arguments();
				this.state._fsp--;
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_arguments.add(arguments9.getTree());
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
							this.adaptor, "rule retval",
							retval != null ? retval.tree : null);
					root_0 = (OPPLSyntaxTree) this.adaptor.nil();
					// 46:3: -> ^( IDENTIFIER[$DOLLAR.getText() + name.getText()
					// + $arguments.argsString]
					// PATTERN_REFERENCE[name.getText()] arguments )
					{
						// /Users/luigi/Documents/workspace/Parsers_OWL_API_2/src/OPPLPatternParser.g:46:6:
						// ^( IDENTIFIER[$DOLLAR.getText() + name.getText() +
						// $arguments.argsString]
						// PATTERN_REFERENCE[name.getText()] arguments )
						{
							OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor
									.nil();
							root_1 = (OPPLSyntaxTree) this.adaptor
									.becomeRoot(
											(OPPLSyntaxTree) this.adaptor
													.create(
															IDENTIFIER,
															DOLLAR8.getText()
																	+ name
																			.getText()
																	+ (arguments9 != null ? arguments9.argsString
																			: null)),
											root_1);
							this.adaptor.addChild(root_1,
									(OPPLSyntaxTree) this.adaptor.create(
											PATTERN_REFERENCE, name.getText()));
							this.adaptor.addChild(root_1, stream_arguments
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
		} catch (RecognitionException e) {
			throw e;
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
	// /Users/luigi/Documents/workspace/Parsers_OWL_API_2/src/OPPLPatternParser.g:49:1:
	// arguments returns [String argsString] : OPEN_PARENTHESYS (a= atomic (
	// COMMA a= atomic )* )? CLOSED_PARENTHESYS -> ^( ARGUMENTS ( atomic )* ) ;
	public final OPPLPatternParser.arguments_return arguments()
			throws RecognitionException {
		OPPLPatternParser.arguments_return retval = new OPPLPatternParser.arguments_return();
		retval.start = this.input.LT(1);
		OPPLSyntaxTree root_0 = null;
		Token OPEN_PARENTHESYS10 = null;
		Token COMMA11 = null;
		Token CLOSED_PARENTHESYS12 = null;
		OPPLPatternParser.atomic_return a = null;
		OPPLSyntaxTree OPEN_PARENTHESYS10_tree = null;
		OPPLSyntaxTree COMMA11_tree = null;
		OPPLSyntaxTree CLOSED_PARENTHESYS12_tree = null;
		RewriteRuleTokenStream stream_COMMA = new RewriteRuleTokenStream(
				this.adaptor, "token COMMA");
		RewriteRuleTokenStream stream_CLOSED_PARENTHESYS = new RewriteRuleTokenStream(
				this.adaptor, "token CLOSED_PARENTHESYS");
		RewriteRuleTokenStream stream_OPEN_PARENTHESYS = new RewriteRuleTokenStream(
				this.adaptor, "token OPEN_PARENTHESYS");
		RewriteRuleSubtreeStream stream_atomic = new RewriteRuleSubtreeStream(
				this.adaptor, "rule atomic");
		StringBuilder builder = new StringBuilder();
		try {
			// /Users/luigi/Documents/workspace/Parsers_OWL_API_2/src/OPPLPatternParser.g:54:3:
			// ( OPEN_PARENTHESYS (a= atomic ( COMMA a= atomic )* )?
			// CLOSED_PARENTHESYS -> ^( ARGUMENTS ( atomic )* ) )
			// /Users/luigi/Documents/workspace/Parsers_OWL_API_2/src/OPPLPatternParser.g:55:6:
			// OPEN_PARENTHESYS (a= atomic ( COMMA a= atomic )* )?
			// CLOSED_PARENTHESYS
			{
				OPEN_PARENTHESYS10 = (Token) this.match(this.input,
						OPEN_PARENTHESYS,
						FOLLOW_OPEN_PARENTHESYS_in_arguments267);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_OPEN_PARENTHESYS.add(OPEN_PARENTHESYS10);
				}
				if (this.state.backtracking == 0) {
					builder.append(OPEN_PARENTHESYS10.getText());
				}
				// /Users/luigi/Documents/workspace/Parsers_OWL_API_2/src/OPPLPatternParser.g:59:6:
				// (a= atomic ( COMMA a= atomic )* )?
				int alt3 = 2;
				int LA3_0 = this.input.LA(1);
				if (LA3_0 >= IDENTIFIER && LA3_0 <= ENTITY_REFERENCE
						|| LA3_0 == ESCLAMATION_MARK || LA3_0 == DOLLAR
						|| LA3_0 == THIS_CLASS || LA3_0 == VARIABLE_NAME) {
					alt3 = 1;
				}
				switch (alt3) {
				case 1:
					// /Users/luigi/Documents/workspace/Parsers_OWL_API_2/src/OPPLPatternParser.g:59:7:
					// a= atomic ( COMMA a= atomic )*
				{
					this.pushFollow(FOLLOW_atomic_in_arguments287);
					a = this.atomic();
					this.state._fsp--;
					if (this.state.failed) {
						return retval;
					}
					if (this.state.backtracking == 0) {
						stream_atomic.add(a.getTree());
					}
					if (this.state.backtracking == 0) {
						builder.append((a != null ? this.input.toString(
								a.start, a.stop) : null));
					}
					// /Users/luigi/Documents/workspace/Parsers_OWL_API_2/src/OPPLPatternParser.g:63:6:
					// ( COMMA a= atomic )*
					loop2: do {
						int alt2 = 2;
						int LA2_0 = this.input.LA(1);
						if (LA2_0 == COMMA) {
							alt2 = 1;
						}
						switch (alt2) {
						case 1:
							// /Users/luigi/Documents/workspace/Parsers_OWL_API_2/src/OPPLPatternParser.g:63:7:
							// COMMA a= atomic
						{
							COMMA11 = (Token) this.match(this.input, COMMA,
									FOLLOW_COMMA_in_arguments303);
							if (this.state.failed) {
								return retval;
							}
							if (this.state.backtracking == 0) {
								stream_COMMA.add(COMMA11);
							}
							this.pushFollow(FOLLOW_atomic_in_arguments309);
							a = this.atomic();
							this.state._fsp--;
							if (this.state.failed) {
								return retval;
							}
							if (this.state.backtracking == 0) {
								stream_atomic.add(a.getTree());
							}
							if (this.state.backtracking == 0) {
								builder.append((a != null ? this.input
										.toString(a.start, a.stop) : null));
							}
						}
							break;
						default:
							break loop2;
						}
					} while (true);
				}
					break;
				}
				CLOSED_PARENTHESYS12 = (Token) this.match(this.input,
						CLOSED_PARENTHESYS,
						FOLLOW_CLOSED_PARENTHESYS_in_arguments334);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_CLOSED_PARENTHESYS.add(CLOSED_PARENTHESYS12);
				}
				if (this.state.backtracking == 0) {
					builder.append(CLOSED_PARENTHESYS12.getText());
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
							this.adaptor, "rule retval",
							retval != null ? retval.tree : null);
					root_0 = (OPPLSyntaxTree) this.adaptor.nil();
					// 73:7: -> ^( ARGUMENTS ( atomic )* )
					{
						// /Users/luigi/Documents/workspace/Parsers_OWL_API_2/src/OPPLPatternParser.g:73:10:
						// ^( ARGUMENTS ( atomic )* )
						{
							OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor
									.nil();
							root_1 = (OPPLSyntaxTree) this.adaptor.becomeRoot(
									(OPPLSyntaxTree) this.adaptor.create(
											ARGUMENTS, "ARGUMENTS"), root_1);
							// /Users/luigi/Documents/workspace/Parsers_OWL_API_2/src/OPPLPatternParser.g:73:22:
							// ( atomic )*
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

	// $ANTLR end "arguments"
	// Delegated rules
	public OPPLPatternParser_OPPLParser_MOWLParser.cardinalityRestriction_return cardinalityRestriction()
			throws RecognitionException {
		return this.gMOWLParser.cardinalityRestriction();
	}

	public OPPLPatternParser_OPPLParser.action_return action()
			throws RecognitionException {
		return this.gOPPLParser.action();
	}

	public OPPLPatternParser_OPPLParser_MOWLParser.value_return value()
			throws RecognitionException {
		return this.gMOWLParser.value();
	}

	public OPPLPatternParser_OPPLParser_MOWLParser.qualifiedRestriction_return qualifiedRestriction()
			throws RecognitionException {
		return this.gMOWLParser.qualifiedRestriction();
	}

	public OPPLPatternParser_OPPLParser_MOWLParser.axiom_return axiom()
			throws RecognitionException {
		return this.gMOWLParser.axiom();
	}

	public OPPLPatternParser_OPPLParser.stringExpression_return stringExpression()
			throws RecognitionException {
		return this.gOPPLParser.stringExpression();
	}

	public OPPLPatternParser_OPPLParser_MOWLParser.conjunction_return conjunction()
			throws RecognitionException {
		return this.gMOWLParser.conjunction();
	}

	public OPPLPatternParser_OPPLParser.stringOperation_return stringOperation()
			throws RecognitionException {
		return this.gOPPLParser.stringOperation();
	}

	public OPPLPatternParser_OPPLParser_MOWLParser.unary_return unary()
			throws RecognitionException {
		return this.gMOWLParser.unary();
	}

	public OPPLPatternParser_OPPLParser.variableDefinitions_return variableDefinitions()
			throws RecognitionException {
		return this.gOPPLParser.variableDefinitions();
	}

	public OPPLPatternParser_OPPLParser.actions_return actions()
			throws RecognitionException {
		return this.gOPPLParser.actions();
	}

	public OPPLPatternParser_OPPLParser.query_return query()
			throws RecognitionException {
		return this.gOPPLParser.query();
	}

	public OPPLPatternParser_OPPLParser.createIdentifier_return createIdentifier()
			throws RecognitionException {
		return this.gOPPLParser.createIdentifier();
	}

	public OPPLPatternParser_OPPLParser_MOWLParser.propertyExpression_return propertyExpression()
			throws RecognitionException {
		return this.gMOWLParser.propertyExpression();
	}

	public OPPLPatternParser_OPPLParser_MOWLParser.complexPropertyExpression_return complexPropertyExpression()
			throws RecognitionException {
		return this.gMOWLParser.complexPropertyExpression();
	}

	public OPPLPatternParser_OPPLParser_MOWLParser.valueRestriction_return valueRestriction()
			throws RecognitionException {
		return this.gMOWLParser.valueRestriction();
	}

	public OPPLPatternParser_OPPLParser.variableDefinition_return variableDefinition()
			throws RecognitionException {
		return this.gOPPLParser.variableDefinition();
	}

	public OPPLPatternParser_OPPLParser.selectClause_return selectClause()
			throws RecognitionException {
		return this.gOPPLParser.selectClause();
	}

	public OPPLPatternParser_OPPLParser_MOWLParser.unaryAxiom_return unaryAxiom()
			throws RecognitionException {
		return this.gMOWLParser.unaryAxiom();
	}

	public OPPLPatternParser_OPPLParser.variableAttributeReference_return variableAttributeReference()
			throws RecognitionException {
		return this.gOPPLParser.variableAttributeReference();
	}

	public OPPLPatternParser_OPPLParser_MOWLParser.restrictionKind_return restrictionKind()
			throws RecognitionException {
		return this.gMOWLParser.restrictionKind();
	}

	public OPPLPatternParser_OPPLParser_MOWLParser.assertionAxiom_return assertionAxiom()
			throws RecognitionException {
		return this.gMOWLParser.assertionAxiom();
	}

	public OPPLPatternParser_OPPLParser.opplFunction_return opplFunction()
			throws RecognitionException {
		return this.gOPPLParser.opplFunction();
	}

	public OPPLPatternParser_OPPLParser_MOWLParser.constant_return constant()
			throws RecognitionException {
		return this.gMOWLParser.constant();
	}

	public OPPLPatternParser_OPPLParser.variableScope_return variableScope()
			throws RecognitionException {
		return this.gOPPLParser.variableScope();
	}

	public OPPLPatternParser_OPPLParser_MOWLParser.expression_return expression()
			throws RecognitionException {
		return this.gMOWLParser.expression();
	}

	public OPPLPatternParser_OPPLParser.constraint_return constraint()
			throws RecognitionException {
		return this.gOPPLParser.constraint();
	}

	public OPPLPatternParser_OPPLParser_MOWLParser.oneOf_return oneOf()
			throws RecognitionException {
		return this.gMOWLParser.oneOf();
	}

	public OPPLPatternParser_OPPLParser_MOWLParser.binaryAxiom_return binaryAxiom()
			throws RecognitionException {
		return this.gMOWLParser.binaryAxiom();
	}

	public OPPLPatternParser_OPPLParser_MOWLParser.unaryCharacteristic_return unaryCharacteristic()
			throws RecognitionException {
		return this.gMOWLParser.unaryCharacteristic();
	}

	public OPPLPatternParser_OPPLParser.attributeSelector_return attributeSelector()
			throws RecognitionException {
		return this.gOPPLParser.attributeSelector();
	}

	public OPPLPatternParser_OPPLParser.regexp_return regexp()
			throws RecognitionException {
		return this.gOPPLParser.regexp();
	}

	public static final BitSet FOLLOW_IDENTIFIER_in_atomic104 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_ENTITY_REFERENCE_in_atomic111 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_VARIABLE_NAME_in_atomic123 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_createIdentifier_in_atomic144 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_variableAttributeReference_in_atomic156 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_THIS_CLASS_in_atomic169 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_patternReference_in_atomic191 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_DOLLAR_in_patternReference214 = new BitSet(
			new long[] { 0x0000100000000000L });
	public static final BitSet FOLLOW_IDENTIFIER_in_patternReference220 = new BitSet(
			new long[] { 0x0000000000000020L });
	public static final BitSet FOLLOW_arguments_in_patternReference224 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_OPEN_PARENTHESYS_in_arguments267 = new BitSet(
			new long[] { 0x0000300000000100L, 0x0000000000000000L,
					0x0000000000200000L, 0x0000000000000000L,
					0x0000000000000000L, 0x0000000000000000L,
					0x0000000100010000L, 0x0000000000010000L });
	public static final BitSet FOLLOW_atomic_in_arguments287 = new BitSet(
			new long[] { 0x0000002000000100L });
	public static final BitSet FOLLOW_COMMA_in_arguments303 = new BitSet(
			new long[] { 0x0000300000000000L, 0x0000000000000000L,
					0x0000000000200000L, 0x0000000000000000L,
					0x0000000000000000L, 0x0000000000000000L,
					0x0000000100010000L, 0x0000000000010000L });
	public static final BitSet FOLLOW_atomic_in_arguments309 = new BitSet(
			new long[] { 0x0000002000000100L });
	public static final BitSet FOLLOW_CLOSED_PARENTHESYS_in_arguments334 = new BitSet(
			new long[] { 0x0000000000000002L });
}