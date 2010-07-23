package org.coode.parsers;

// $ANTLR 3.2 Sep 23, 2009 12:02:23 /Users/luigi/Documents/workspace/Parsers/src/MOWLParser.g 2010-07-15 15:56:24
import java.util.ArrayList;
import java.util.List;

import org.antlr.runtime.BaseRecognizer;
import org.antlr.runtime.BitSet;
import org.antlr.runtime.DFA;
import org.antlr.runtime.EarlyExitException;
import org.antlr.runtime.IntStream;
import org.antlr.runtime.NoViableAltException;
import org.antlr.runtime.Parser;
import org.antlr.runtime.ParserRuleReturnScope;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.RecognizerSharedState;
import org.antlr.runtime.RuleReturnScope;
import org.antlr.runtime.Token;
import org.antlr.runtime.TokenStream;
import org.antlr.runtime.tree.CommonTreeAdaptor;
import org.antlr.runtime.tree.RewriteEarlyExitException;
import org.antlr.runtime.tree.RewriteEmptyStreamException;
import org.antlr.runtime.tree.RewriteRuleSubtreeStream;
import org.antlr.runtime.tree.RewriteRuleTokenStream;
import org.antlr.runtime.tree.TreeAdaptor;

public class MOWLParser extends Parser {
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
			"VARIABLE_SCOPE", "SUBPROPERTY_OF", "VARIABLE_IDENTIFIER", "OPPL_STATEMENT",
			"ESCLAMATION_MARK", "CREATE_IDENTIFIER", "PLAIN_IDENTIFIER", "MATCH",
			"ATTRIBUTE_SELECTOR" };
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
	public static final int VALUE = 18;
	public static final int OPEN_CURLY_BRACES = 6;
	public static final int DISJUNCTION = 55;
	public static final int INVERSE = 19;
	public static final int DBLQUOTE = 40;
	public static final int OR = 11;
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
	public static final int INVERSE_FUNCTIONAL = 35;
	public static final int VARIABLE_IDENTIFIER = 106;
	public static final int IRREFLEXIVE = 33;
	public static final int PLAIN_IDENTIFIER = 152;
	public static final int VARIABLE_ATTRIBUTE = 99;
	public static final int ASSERTED = 76;
	public static final int FUNCTIONAL = 29;
	public static final int PROPERTY_CHAIN = 57;
	public static final int TYPE_ASSERTION = 66;

	// delegates
	// delegators
	public MOWLParser(TokenStream input) {
		this(input, new RecognizerSharedState());
	}

	public MOWLParser(TokenStream input, RecognizerSharedState state) {
		super(input, state);
	}

	protected TreeAdaptor adaptor = new CommonTreeAdaptor();

	public void setTreeAdaptor(TreeAdaptor adaptor) {
		this.adaptor = adaptor;
	}

	public TreeAdaptor getTreeAdaptor() {
		return this.adaptor;
	}

	@Override
	public String[] getTokenNames() {
		return MOWLParser.tokenNames;
	}

	@Override
	public String getGrammarFileName() {
		return "/Users/luigi/Documents/workspace/Parsers/src/MOWLParser.g";
	}

	@Override
	public void displayRecognitionError(String[] tokenNames, RecognitionException e) {
	}

	public static class axiom_return extends ParserRuleReturnScope {
		ManchesterOWLSyntaxTree tree;

		@Override
		public Object getTree() {
			return this.tree;
		}
	};

	// $ANTLR start "axiom"
	// /Users/luigi/Documents/workspace/Parsers/src/MOWLParser.g:63:1: axiom
	// options {backtrack=true; } : ( binaryAxiom -> ^( binaryAxiom ) |
	// unaryAxiom -> ^( unaryAxiom ) | assertionAxiom -> ^( assertionAxiom ) );
	public final MOWLParser.axiom_return axiom() throws RecognitionException {
		MOWLParser.axiom_return retval = new MOWLParser.axiom_return();
		retval.start = this.input.LT(1);
		ManchesterOWLSyntaxTree root_0 = null;
		MOWLParser.binaryAxiom_return binaryAxiom1 = null;
		MOWLParser.unaryAxiom_return unaryAxiom2 = null;
		MOWLParser.assertionAxiom_return assertionAxiom3 = null;
		RewriteRuleSubtreeStream stream_binaryAxiom = new RewriteRuleSubtreeStream(this.adaptor,
				"rule binaryAxiom");
		RewriteRuleSubtreeStream stream_unaryAxiom = new RewriteRuleSubtreeStream(this.adaptor,
				"rule unaryAxiom");
		RewriteRuleSubtreeStream stream_assertionAxiom = new RewriteRuleSubtreeStream(this.adaptor,
				"rule assertionAxiom");
		try {
			// /Users/luigi/Documents/workspace/Parsers/src/MOWLParser.g:63:37:
			// ( binaryAxiom -> ^( binaryAxiom ) | unaryAxiom -> ^( unaryAxiom )
			// | assertionAxiom -> ^( assertionAxiom ) )
			int alt1 = 3;
			switch (this.input.LA(1)) {
			case OPEN_PARENTHESYS:
			case OPEN_CURLY_BRACES:
			case INVERSE:
			case SUBCLASS_OF:
			case SUB_PROPERTY_OF:
			case EQUIVALENT_TO:
			case SAME_AS:
			case DIFFERENT_FROM:
			case INVERSE_OF:
			case DISJOINT_WITH:
			case DOMAIN:
			case RANGE:
			case DBLQUOTE:
			case ENTITY_REFERENCE: {
				alt1 = 1;
			}
				break;
			case IDENTIFIER: {
				int LA1_2 = this.input.LA(2);
				if (LA1_2 == COMPOSITION || LA1_2 >= AND && LA1_2 <= OR || LA1_2 >= SOME
						&& LA1_2 <= VALUE || LA1_2 >= SUBCLASS_OF && LA1_2 <= RANGE) {
					alt1 = 1;
				} else if (LA1_2 == INVERSE || LA1_2 >= INSTANCE_OF && LA1_2 <= TYPES
						|| LA1_2 >= IDENTIFIER && LA1_2 <= ENTITY_REFERENCE) {
					alt1 = 3;
				} else {
					if (this.state.backtracking > 0) {
						this.state.failed = true;
						return retval;
					}
					NoViableAltException nvae = new NoViableAltException("", 1, 2, this.input);
					throw nvae;
				}
			}
				break;
			case NOT: {
				switch (this.input.LA(2)) {
				case OPEN_PARENTHESYS:
				case ENTITY_REFERENCE: {
					alt1 = 1;
				}
					break;
				case IDENTIFIER: {
					int LA1_6 = this.input.LA(3);
					if (LA1_6 == INVERSE || LA1_6 >= INSTANCE_OF && LA1_6 <= TYPES
							|| LA1_6 >= IDENTIFIER && LA1_6 <= ENTITY_REFERENCE) {
						alt1 = 3;
					} else if (LA1_6 >= AND && LA1_6 <= OR || LA1_6 >= SUBCLASS_OF
							&& LA1_6 <= RANGE) {
						alt1 = 1;
					} else {
						if (this.state.backtracking > 0) {
							this.state.failed = true;
							return retval;
						}
						NoViableAltException nvae = new NoViableAltException("", 1, 6, this.input);
						throw nvae;
					}
				}
					break;
				case NOT: {
					alt1 = 3;
				}
					break;
				default:
					if (this.state.backtracking > 0) {
						this.state.failed = true;
						return retval;
					}
					NoViableAltException nvae = new NoViableAltException("", 1, 3, this.input);
					throw nvae;
				}
			}
				break;
			case FUNCTIONAL:
			case SYMMETRIC:
			case ANTI_SYMMETRIC:
			case REFLEXIVE:
			case IRREFLEXIVE:
			case TRANSITIVE:
			case INVERSE_FUNCTIONAL: {
				alt1 = 2;
			}
				break;
			default:
				if (this.state.backtracking > 0) {
					this.state.failed = true;
					return retval;
				}
				NoViableAltException nvae = new NoViableAltException("", 1, 0, this.input);
				throw nvae;
			}
			switch (alt1) {
			case 1:
				// /Users/luigi/Documents/workspace/Parsers/src/MOWLParser.g:64:3:
				// binaryAxiom
			{
				this.pushFollow(FOLLOW_binaryAxiom_in_axiom231);
				binaryAxiom1 = this.binaryAxiom();
				this.state._fsp--;
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_binaryAxiom.add(binaryAxiom1.getTree());
				}
				// AST REWRITE
				// elements: binaryAxiom
				// token labels:
				// rule labels: retval
				// token list labels:
				// rule list labels:
				// wildcard labels:
				if (this.state.backtracking == 0) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(
							this.adaptor, "rule retval", retval != null ? retval.tree : null);
					root_0 = (ManchesterOWLSyntaxTree) this.adaptor.nil();
					// 64:15: -> ^( binaryAxiom )
					{
						// /Users/luigi/Documents/workspace/Parsers/src/MOWLParser.g:64:18:
						// ^( binaryAxiom )
						{
							ManchesterOWLSyntaxTree root_1 = (ManchesterOWLSyntaxTree) this.adaptor.nil();
							root_1 = (ManchesterOWLSyntaxTree) this.adaptor.becomeRoot(
									stream_binaryAxiom.nextNode(),
									root_1);
							this.adaptor.addChild(root_0, root_1);
						}
					}
					retval.tree = root_0;
				}
			}
				break;
			case 2:
				// /Users/luigi/Documents/workspace/Parsers/src/MOWLParser.g:65:5:
				// unaryAxiom
			{
				this.pushFollow(FOLLOW_unaryAxiom_in_axiom243);
				unaryAxiom2 = this.unaryAxiom();
				this.state._fsp--;
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_unaryAxiom.add(unaryAxiom2.getTree());
				}
				// AST REWRITE
				// elements: unaryAxiom
				// token labels:
				// rule labels: retval
				// token list labels:
				// rule list labels:
				// wildcard labels:
				if (this.state.backtracking == 0) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(
							this.adaptor, "rule retval", retval != null ? retval.tree : null);
					root_0 = (ManchesterOWLSyntaxTree) this.adaptor.nil();
					// 65:16: -> ^( unaryAxiom )
					{
						// /Users/luigi/Documents/workspace/Parsers/src/MOWLParser.g:65:19:
						// ^( unaryAxiom )
						{
							ManchesterOWLSyntaxTree root_1 = (ManchesterOWLSyntaxTree) this.adaptor.nil();
							root_1 = (ManchesterOWLSyntaxTree) this.adaptor.becomeRoot(
									stream_unaryAxiom.nextNode(),
									root_1);
							this.adaptor.addChild(root_0, root_1);
						}
					}
					retval.tree = root_0;
				}
			}
				break;
			case 3:
				// /Users/luigi/Documents/workspace/Parsers/src/MOWLParser.g:66:5:
				// assertionAxiom
			{
				this.pushFollow(FOLLOW_assertionAxiom_in_axiom255);
				assertionAxiom3 = this.assertionAxiom();
				this.state._fsp--;
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_assertionAxiom.add(assertionAxiom3.getTree());
				}
				// AST REWRITE
				// elements: assertionAxiom
				// token labels:
				// rule labels: retval
				// token list labels:
				// rule list labels:
				// wildcard labels:
				if (this.state.backtracking == 0) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(
							this.adaptor, "rule retval", retval != null ? retval.tree : null);
					root_0 = (ManchesterOWLSyntaxTree) this.adaptor.nil();
					// 66:20: -> ^( assertionAxiom )
					{
						// /Users/luigi/Documents/workspace/Parsers/src/MOWLParser.g:66:23:
						// ^( assertionAxiom )
						{
							ManchesterOWLSyntaxTree root_1 = (ManchesterOWLSyntaxTree) this.adaptor.nil();
							root_1 = (ManchesterOWLSyntaxTree) this.adaptor.becomeRoot(
									stream_assertionAxiom.nextNode(),
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
				retval.tree = (ManchesterOWLSyntaxTree) this.adaptor.rulePostProcessing(root_0);
				this.adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		} catch (RecognitionException e) {
			throw e;
		} catch (RewriteEmptyStreamException e) {
			throw e;
		} finally {
		}
		return retval;
	}

	// $ANTLR end "axiom"
	public static class assertionAxiom_return extends ParserRuleReturnScope {
		ManchesterOWLSyntaxTree tree;

		@Override
		public Object getTree() {
			return this.tree;
		}
	};

	// $ANTLR start "assertionAxiom"
	// /Users/luigi/Documents/workspace/Parsers/src/MOWLParser.g:71:1:
	// assertionAxiom : (i= IDENTIFIER ( INSTANCE_OF | TYPES ) expression -> ^(
	// TYPE_ASSERTION ^( EXPRESSION expression ) ^( EXPRESSION $i) ) |
	// IDENTIFIER propertyExpression value -> ^( ROLE_ASSERTION ^( EXPRESSION
	// IDENTIFIER ) ^( EXPRESSION propertyExpression ) ^( EXPRESSION value ) ) |
	// NOT assertionAxiom -> ^( NEGATED_ASSERTION assertionAxiom ) );
	public final MOWLParser.assertionAxiom_return assertionAxiom() throws RecognitionException {
		MOWLParser.assertionAxiom_return retval = new MOWLParser.assertionAxiom_return();
		retval.start = this.input.LT(1);
		ManchesterOWLSyntaxTree root_0 = null;
		Token i = null;
		Token INSTANCE_OF4 = null;
		Token TYPES5 = null;
		Token IDENTIFIER7 = null;
		Token NOT10 = null;
		MOWLParser.expression_return expression6 = null;
		MOWLParser.propertyExpression_return propertyExpression8 = null;
		MOWLParser.value_return value9 = null;
		MOWLParser.assertionAxiom_return assertionAxiom11 = null;
		ManchesterOWLSyntaxTree i_tree = null;
		ManchesterOWLSyntaxTree INSTANCE_OF4_tree = null;
		ManchesterOWLSyntaxTree TYPES5_tree = null;
		ManchesterOWLSyntaxTree IDENTIFIER7_tree = null;
		ManchesterOWLSyntaxTree NOT10_tree = null;
		RewriteRuleTokenStream stream_TYPES = new RewriteRuleTokenStream(this.adaptor,
				"token TYPES");
		RewriteRuleTokenStream stream_NOT = new RewriteRuleTokenStream(this.adaptor, "token NOT");
		RewriteRuleTokenStream stream_IDENTIFIER = new RewriteRuleTokenStream(this.adaptor,
				"token IDENTIFIER");
		RewriteRuleTokenStream stream_INSTANCE_OF = new RewriteRuleTokenStream(this.adaptor,
				"token INSTANCE_OF");
		RewriteRuleSubtreeStream stream_expression = new RewriteRuleSubtreeStream(this.adaptor,
				"rule expression");
		RewriteRuleSubtreeStream stream_propertyExpression = new RewriteRuleSubtreeStream(
				this.adaptor, "rule propertyExpression");
		RewriteRuleSubtreeStream stream_value = new RewriteRuleSubtreeStream(this.adaptor,
				"rule value");
		RewriteRuleSubtreeStream stream_assertionAxiom = new RewriteRuleSubtreeStream(this.adaptor,
				"rule assertionAxiom");
		try {
			// /Users/luigi/Documents/workspace/Parsers/src/MOWLParser.g:71:15:
			// (i= IDENTIFIER ( INSTANCE_OF | TYPES ) expression -> ^(
			// TYPE_ASSERTION ^( EXPRESSION expression ) ^( EXPRESSION $i) ) |
			// IDENTIFIER propertyExpression value -> ^( ROLE_ASSERTION ^(
			// EXPRESSION IDENTIFIER ) ^( EXPRESSION propertyExpression ) ^(
			// EXPRESSION value ) ) | NOT assertionAxiom -> ^( NEGATED_ASSERTION
			// assertionAxiom ) )
			int alt3 = 3;
			int LA3_0 = this.input.LA(1);
			if (LA3_0 == IDENTIFIER) {
				int LA3_1 = this.input.LA(2);
				if (LA3_1 >= INSTANCE_OF && LA3_1 <= TYPES) {
					alt3 = 1;
				} else if (LA3_1 == INVERSE || LA3_1 >= IDENTIFIER && LA3_1 <= ENTITY_REFERENCE) {
					alt3 = 2;
				} else {
					if (this.state.backtracking > 0) {
						this.state.failed = true;
						return retval;
					}
					NoViableAltException nvae = new NoViableAltException("", 3, 1, this.input);
					throw nvae;
				}
			} else if (LA3_0 == NOT) {
				alt3 = 3;
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
				// /Users/luigi/Documents/workspace/Parsers/src/MOWLParser.g:72:3:
				// i= IDENTIFIER ( INSTANCE_OF | TYPES ) expression
			{
				i = (Token) this.match(
						this.input,
						IDENTIFIER,
						FOLLOW_IDENTIFIER_in_assertionAxiom278);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_IDENTIFIER.add(i);
				}
				// /Users/luigi/Documents/workspace/Parsers/src/MOWLParser.g:72:18:
				// ( INSTANCE_OF | TYPES )
				int alt2 = 2;
				int LA2_0 = this.input.LA(1);
				if (LA2_0 == INSTANCE_OF) {
					alt2 = 1;
				} else if (LA2_0 == TYPES) {
					alt2 = 2;
				} else {
					if (this.state.backtracking > 0) {
						this.state.failed = true;
						return retval;
					}
					NoViableAltException nvae = new NoViableAltException("", 2, 0, this.input);
					throw nvae;
				}
				switch (alt2) {
				case 1:
					// /Users/luigi/Documents/workspace/Parsers/src/MOWLParser.g:72:19:
					// INSTANCE_OF
				{
					INSTANCE_OF4 = (Token) this.match(
							this.input,
							INSTANCE_OF,
							FOLLOW_INSTANCE_OF_in_assertionAxiom281);
					if (this.state.failed) {
						return retval;
					}
					if (this.state.backtracking == 0) {
						stream_INSTANCE_OF.add(INSTANCE_OF4);
					}
				}
					break;
				case 2:
					// /Users/luigi/Documents/workspace/Parsers/src/MOWLParser.g:72:33:
					// TYPES
				{
					TYPES5 = (Token) this.match(
							this.input,
							TYPES,
							FOLLOW_TYPES_in_assertionAxiom285);
					if (this.state.failed) {
						return retval;
					}
					if (this.state.backtracking == 0) {
						stream_TYPES.add(TYPES5);
					}
				}
					break;
				}
				this.pushFollow(FOLLOW_expression_in_assertionAxiom288);
				expression6 = this.expression();
				this.state._fsp--;
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_expression.add(expression6.getTree());
				}
				// AST REWRITE
				// elements: i, expression
				// token labels: i
				// rule labels: retval
				// token list labels:
				// rule list labels:
				// wildcard labels:
				if (this.state.backtracking == 0) {
					retval.tree = root_0;
					RewriteRuleTokenStream stream_i = new RewriteRuleTokenStream(this.adaptor,
							"token i", i);
					RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(
							this.adaptor, "rule retval", retval != null ? retval.tree : null);
					root_0 = (ManchesterOWLSyntaxTree) this.adaptor.nil();
					// 72:51: -> ^( TYPE_ASSERTION ^( EXPRESSION expression ) ^(
					// EXPRESSION $i) )
					{
						// /Users/luigi/Documents/workspace/Parsers/src/MOWLParser.g:72:54:
						// ^( TYPE_ASSERTION ^( EXPRESSION expression ) ^(
						// EXPRESSION $i) )
						{
							ManchesterOWLSyntaxTree root_1 = (ManchesterOWLSyntaxTree) this.adaptor.nil();
							root_1 = (ManchesterOWLSyntaxTree) this.adaptor.becomeRoot(
									this.adaptor.create(TYPE_ASSERTION, "TYPE_ASSERTION"),
									root_1);
							// /Users/luigi/Documents/workspace/Parsers/src/MOWLParser.g:72:71:
							// ^( EXPRESSION expression )
							{
								ManchesterOWLSyntaxTree root_2 = (ManchesterOWLSyntaxTree) this.adaptor.nil();
								root_2 = (ManchesterOWLSyntaxTree) this.adaptor.becomeRoot(
										this.adaptor.create(EXPRESSION, "EXPRESSION"),
										root_2);
								this.adaptor.addChild(root_2, stream_expression.nextTree());
								this.adaptor.addChild(root_1, root_2);
							}
							// /Users/luigi/Documents/workspace/Parsers/src/MOWLParser.g:72:96:
							// ^( EXPRESSION $i)
							{
								ManchesterOWLSyntaxTree root_2 = (ManchesterOWLSyntaxTree) this.adaptor.nil();
								root_2 = (ManchesterOWLSyntaxTree) this.adaptor.becomeRoot(
										this.adaptor.create(EXPRESSION, "EXPRESSION"),
										root_2);
								this.adaptor.addChild(root_2, stream_i.nextNode());
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
				// /Users/luigi/Documents/workspace/Parsers/src/MOWLParser.g:73:6:
				// IDENTIFIER propertyExpression value
			{
				IDENTIFIER7 = (Token) this.match(
						this.input,
						IDENTIFIER,
						FOLLOW_IDENTIFIER_in_assertionAxiom314);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_IDENTIFIER.add(IDENTIFIER7);
				}
				this.pushFollow(FOLLOW_propertyExpression_in_assertionAxiom316);
				propertyExpression8 = this.propertyExpression();
				this.state._fsp--;
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_propertyExpression.add(propertyExpression8.getTree());
				}
				this.pushFollow(FOLLOW_value_in_assertionAxiom319);
				value9 = this.value();
				this.state._fsp--;
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_value.add(value9.getTree());
				}
				// AST REWRITE
				// elements: propertyExpression, IDENTIFIER, value
				// token labels:
				// rule labels: retval
				// token list labels:
				// rule list labels:
				// wildcard labels:
				if (this.state.backtracking == 0) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(
							this.adaptor, "rule retval", retval != null ? retval.tree : null);
					root_0 = (ManchesterOWLSyntaxTree) this.adaptor.nil();
					// 73:43: -> ^( ROLE_ASSERTION ^( EXPRESSION IDENTIFIER ) ^(
					// EXPRESSION propertyExpression ) ^( EXPRESSION value ) )
					{
						// /Users/luigi/Documents/workspace/Parsers/src/MOWLParser.g:73:46:
						// ^( ROLE_ASSERTION ^( EXPRESSION IDENTIFIER ) ^(
						// EXPRESSION propertyExpression ) ^( EXPRESSION value )
						// )
						{
							ManchesterOWLSyntaxTree root_1 = (ManchesterOWLSyntaxTree) this.adaptor.nil();
							root_1 = (ManchesterOWLSyntaxTree) this.adaptor.becomeRoot(
									this.adaptor.create(ROLE_ASSERTION, "ROLE_ASSERTION"),
									root_1);
							// /Users/luigi/Documents/workspace/Parsers/src/MOWLParser.g:73:63:
							// ^( EXPRESSION IDENTIFIER )
							{
								ManchesterOWLSyntaxTree root_2 = (ManchesterOWLSyntaxTree) this.adaptor.nil();
								root_2 = (ManchesterOWLSyntaxTree) this.adaptor.becomeRoot(
										this.adaptor.create(EXPRESSION, "EXPRESSION"),
										root_2);
								this.adaptor.addChild(root_2, stream_IDENTIFIER.nextNode());
								this.adaptor.addChild(root_1, root_2);
							}
							// /Users/luigi/Documents/workspace/Parsers/src/MOWLParser.g:73:88:
							// ^( EXPRESSION propertyExpression )
							{
								ManchesterOWLSyntaxTree root_2 = (ManchesterOWLSyntaxTree) this.adaptor.nil();
								root_2 = (ManchesterOWLSyntaxTree) this.adaptor.becomeRoot(
										this.adaptor.create(EXPRESSION, "EXPRESSION"),
										root_2);
								this.adaptor.addChild(root_2, stream_propertyExpression.nextTree());
								this.adaptor.addChild(root_1, root_2);
							}
							// /Users/luigi/Documents/workspace/Parsers/src/MOWLParser.g:73:121:
							// ^( EXPRESSION value )
							{
								ManchesterOWLSyntaxTree root_2 = (ManchesterOWLSyntaxTree) this.adaptor.nil();
								root_2 = (ManchesterOWLSyntaxTree) this.adaptor.becomeRoot(
										this.adaptor.create(EXPRESSION, "EXPRESSION"),
										root_2);
								this.adaptor.addChild(root_2, stream_value.nextTree());
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
				// /Users/luigi/Documents/workspace/Parsers/src/MOWLParser.g:75:5:
				// NOT assertionAxiom
			{
				NOT10 = (Token) this.match(this.input, NOT, FOLLOW_NOT_in_assertionAxiom352);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_NOT.add(NOT10);
				}
				this.pushFollow(FOLLOW_assertionAxiom_in_assertionAxiom354);
				assertionAxiom11 = this.assertionAxiom();
				this.state._fsp--;
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_assertionAxiom.add(assertionAxiom11.getTree());
				}
				// AST REWRITE
				// elements: assertionAxiom
				// token labels:
				// rule labels: retval
				// token list labels:
				// rule list labels:
				// wildcard labels:
				if (this.state.backtracking == 0) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(
							this.adaptor, "rule retval", retval != null ? retval.tree : null);
					root_0 = (ManchesterOWLSyntaxTree) this.adaptor.nil();
					// 75:24: -> ^( NEGATED_ASSERTION assertionAxiom )
					{
						// /Users/luigi/Documents/workspace/Parsers/src/MOWLParser.g:75:27:
						// ^( NEGATED_ASSERTION assertionAxiom )
						{
							ManchesterOWLSyntaxTree root_1 = (ManchesterOWLSyntaxTree) this.adaptor.nil();
							root_1 = (ManchesterOWLSyntaxTree) this.adaptor.becomeRoot(
									this.adaptor.create(NEGATED_ASSERTION, "NEGATED_ASSERTION"),
									root_1);
							this.adaptor.addChild(root_1, stream_assertionAxiom.nextTree());
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
				retval.tree = (ManchesterOWLSyntaxTree) this.adaptor.rulePostProcessing(root_0);
				this.adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		} catch (RecognitionException e) {
			throw e;
		} catch (RewriteEmptyStreamException e) {
			throw e;
		} finally {
		}
		return retval;
	}

	// $ANTLR end "assertionAxiom"
	public static class binaryAxiom_return extends ParserRuleReturnScope {
		ManchesterOWLSyntaxTree tree;

		@Override
		public Object getTree() {
			return this.tree;
		}
	};

	// $ANTLR start "binaryAxiom"
	// /Users/luigi/Documents/workspace/Parsers/src/MOWLParser.g:80:1:
	// binaryAxiom : lhs= expression ( SUBCLASS_OF superClass= expression -> ^(
	// SUB_CLASS_AXIOM ^( EXPRESSION $lhs) ^( EXPRESSION $superClass) ) |
	// EQUIVALENT_TO rhs= expression -> ^( EQUIVALENT_TO_AXIOM ^( EXPRESSION
	// $lhs) ^( EXPRESSION $rhs) ) | DISJOINT_WITH disjoint= expression -> ^(
	// DISJOINT_WITH_AXIOM ^( EXPRESSION $lhs) ^( EXPRESSION $disjoint) ) |
	// SUB_PROPERTY_OF superProperty= propertyExpression -> ^(
	// SUB_PROPERTY_AXIOM ^( EXPRESSION $lhs) ^( EXPRESSION $superProperty) ) |
	// INVERSE_OF rhsAtomic= atomic -> ^( INVERSE_OF ^( EXPRESSION $lhs) ^(
	// EXPRESSION $rhsAtomic) ) | SAME_AS rhsID= atomic -> ^( SAME_AS_AXIOM ^(
	// EXPRESSION $lhs) ^( EXPRESSION $rhsID) ) | DIFFERENT_FROM rhsID= atomic
	// -> ^( DIFFERENT_FROM_AXIOM ^( EXPRESSION $lhs) ^( EXPRESSION $rhsID) ) |
	// DOMAIN expression -> ^( DOMAIN ^( EXPRESSION $lhs) ^( EXPRESSION
	// expression ) ) | RANGE expression -> ^( RANGE ^( EXPRESSION $lhs) ^(
	// EXPRESSION expression ) ) ) ;
	public final MOWLParser.binaryAxiom_return binaryAxiom() throws RecognitionException {
		MOWLParser.binaryAxiom_return retval = new MOWLParser.binaryAxiom_return();
		retval.start = this.input.LT(1);
		ManchesterOWLSyntaxTree root_0 = null;
		Token SUBCLASS_OF12 = null;
		Token EQUIVALENT_TO13 = null;
		Token DISJOINT_WITH14 = null;
		Token SUB_PROPERTY_OF15 = null;
		Token INVERSE_OF16 = null;
		Token SAME_AS17 = null;
		Token DIFFERENT_FROM18 = null;
		Token DOMAIN19 = null;
		Token RANGE21 = null;
		MOWLParser.expression_return lhs = null;
		MOWLParser.expression_return superClass = null;
		MOWLParser.expression_return rhs = null;
		MOWLParser.expression_return disjoint = null;
		MOWLParser.propertyExpression_return superProperty = null;
		MOWLParser.atomic_return rhsAtomic = null;
		MOWLParser.atomic_return rhsID = null;
		MOWLParser.expression_return expression20 = null;
		MOWLParser.expression_return expression22 = null;
		ManchesterOWLSyntaxTree SUBCLASS_OF12_tree = null;
		ManchesterOWLSyntaxTree EQUIVALENT_TO13_tree = null;
		ManchesterOWLSyntaxTree DISJOINT_WITH14_tree = null;
		ManchesterOWLSyntaxTree SUB_PROPERTY_OF15_tree = null;
		ManchesterOWLSyntaxTree INVERSE_OF16_tree = null;
		ManchesterOWLSyntaxTree SAME_AS17_tree = null;
		ManchesterOWLSyntaxTree DIFFERENT_FROM18_tree = null;
		ManchesterOWLSyntaxTree DOMAIN19_tree = null;
		ManchesterOWLSyntaxTree RANGE21_tree = null;
		RewriteRuleTokenStream stream_SAME_AS = new RewriteRuleTokenStream(this.adaptor,
				"token SAME_AS");
		RewriteRuleTokenStream stream_RANGE = new RewriteRuleTokenStream(this.adaptor,
				"token RANGE");
		RewriteRuleTokenStream stream_DISJOINT_WITH = new RewriteRuleTokenStream(this.adaptor,
				"token DISJOINT_WITH");
		RewriteRuleTokenStream stream_INVERSE_OF = new RewriteRuleTokenStream(this.adaptor,
				"token INVERSE_OF");
		RewriteRuleTokenStream stream_DIFFERENT_FROM = new RewriteRuleTokenStream(this.adaptor,
				"token DIFFERENT_FROM");
		RewriteRuleTokenStream stream_EQUIVALENT_TO = new RewriteRuleTokenStream(this.adaptor,
				"token EQUIVALENT_TO");
		RewriteRuleTokenStream stream_SUBCLASS_OF = new RewriteRuleTokenStream(this.adaptor,
				"token SUBCLASS_OF");
		RewriteRuleTokenStream stream_SUB_PROPERTY_OF = new RewriteRuleTokenStream(this.adaptor,
				"token SUB_PROPERTY_OF");
		RewriteRuleTokenStream stream_DOMAIN = new RewriteRuleTokenStream(this.adaptor,
				"token DOMAIN");
		RewriteRuleSubtreeStream stream_expression = new RewriteRuleSubtreeStream(this.adaptor,
				"rule expression");
		RewriteRuleSubtreeStream stream_propertyExpression = new RewriteRuleSubtreeStream(
				this.adaptor, "rule propertyExpression");
		RewriteRuleSubtreeStream stream_atomic = new RewriteRuleSubtreeStream(this.adaptor,
				"rule atomic");
		try {
			// /Users/luigi/Documents/workspace/Parsers/src/MOWLParser.g:80:13:
			// (lhs= expression ( SUBCLASS_OF superClass= expression -> ^(
			// SUB_CLASS_AXIOM ^( EXPRESSION $lhs) ^( EXPRESSION $superClass) )
			// | EQUIVALENT_TO rhs= expression -> ^( EQUIVALENT_TO_AXIOM ^(
			// EXPRESSION $lhs) ^( EXPRESSION $rhs) ) | DISJOINT_WITH disjoint=
			// expression -> ^( DISJOINT_WITH_AXIOM ^( EXPRESSION $lhs) ^(
			// EXPRESSION $disjoint) ) | SUB_PROPERTY_OF superProperty=
			// propertyExpression -> ^( SUB_PROPERTY_AXIOM ^( EXPRESSION $lhs)
			// ^( EXPRESSION $superProperty) ) | INVERSE_OF rhsAtomic= atomic ->
			// ^( INVERSE_OF ^( EXPRESSION $lhs) ^( EXPRESSION $rhsAtomic) ) |
			// SAME_AS rhsID= atomic -> ^( SAME_AS_AXIOM ^( EXPRESSION $lhs) ^(
			// EXPRESSION $rhsID) ) | DIFFERENT_FROM rhsID= atomic -> ^(
			// DIFFERENT_FROM_AXIOM ^( EXPRESSION $lhs) ^( EXPRESSION $rhsID) )
			// | DOMAIN expression -> ^( DOMAIN ^( EXPRESSION $lhs) ^(
			// EXPRESSION expression ) ) | RANGE expression -> ^( RANGE ^(
			// EXPRESSION $lhs) ^( EXPRESSION expression ) ) ) )
			// /Users/luigi/Documents/workspace/Parsers/src/MOWLParser.g:84:2:
			// lhs= expression ( SUBCLASS_OF superClass= expression -> ^(
			// SUB_CLASS_AXIOM ^( EXPRESSION $lhs) ^( EXPRESSION $superClass) )
			// | EQUIVALENT_TO rhs= expression -> ^( EQUIVALENT_TO_AXIOM ^(
			// EXPRESSION $lhs) ^( EXPRESSION $rhs) ) | DISJOINT_WITH disjoint=
			// expression -> ^( DISJOINT_WITH_AXIOM ^( EXPRESSION $lhs) ^(
			// EXPRESSION $disjoint) ) | SUB_PROPERTY_OF superProperty=
			// propertyExpression -> ^( SUB_PROPERTY_AXIOM ^( EXPRESSION $lhs)
			// ^( EXPRESSION $superProperty) ) | INVERSE_OF rhsAtomic= atomic ->
			// ^( INVERSE_OF ^( EXPRESSION $lhs) ^( EXPRESSION $rhsAtomic) ) |
			// SAME_AS rhsID= atomic -> ^( SAME_AS_AXIOM ^( EXPRESSION $lhs) ^(
			// EXPRESSION $rhsID) ) | DIFFERENT_FROM rhsID= atomic -> ^(
			// DIFFERENT_FROM_AXIOM ^( EXPRESSION $lhs) ^( EXPRESSION $rhsID) )
			// | DOMAIN expression -> ^( DOMAIN ^( EXPRESSION $lhs) ^(
			// EXPRESSION expression ) ) | RANGE expression -> ^( RANGE ^(
			// EXPRESSION $lhs) ^( EXPRESSION expression ) ) )
			{
				this.pushFollow(FOLLOW_expression_in_binaryAxiom399);
				lhs = this.expression();
				this.state._fsp--;
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_expression.add(lhs.getTree());
				}
				// /Users/luigi/Documents/workspace/Parsers/src/MOWLParser.g:85:17:
				// ( SUBCLASS_OF superClass= expression -> ^( SUB_CLASS_AXIOM ^(
				// EXPRESSION $lhs) ^( EXPRESSION $superClass) ) | EQUIVALENT_TO
				// rhs= expression -> ^( EQUIVALENT_TO_AXIOM ^( EXPRESSION $lhs)
				// ^( EXPRESSION $rhs) ) | DISJOINT_WITH disjoint= expression ->
				// ^( DISJOINT_WITH_AXIOM ^( EXPRESSION $lhs) ^( EXPRESSION
				// $disjoint) ) | SUB_PROPERTY_OF superProperty=
				// propertyExpression -> ^( SUB_PROPERTY_AXIOM ^( EXPRESSION
				// $lhs) ^( EXPRESSION $superProperty) ) | INVERSE_OF rhsAtomic=
				// atomic -> ^( INVERSE_OF ^( EXPRESSION $lhs) ^( EXPRESSION
				// $rhsAtomic) ) | SAME_AS rhsID= atomic -> ^( SAME_AS_AXIOM ^(
				// EXPRESSION $lhs) ^( EXPRESSION $rhsID) ) | DIFFERENT_FROM
				// rhsID= atomic -> ^( DIFFERENT_FROM_AXIOM ^( EXPRESSION $lhs)
				// ^( EXPRESSION $rhsID) ) | DOMAIN expression -> ^( DOMAIN ^(
				// EXPRESSION $lhs) ^( EXPRESSION expression ) ) | RANGE
				// expression -> ^( RANGE ^( EXPRESSION $lhs) ^( EXPRESSION
				// expression ) ) )
				int alt4 = 9;
				switch (this.input.LA(1)) {
				case SUBCLASS_OF: {
					alt4 = 1;
				}
					break;
				case EQUIVALENT_TO: {
					alt4 = 2;
				}
					break;
				case DISJOINT_WITH: {
					alt4 = 3;
				}
					break;
				case SUB_PROPERTY_OF: {
					alt4 = 4;
				}
					break;
				case INVERSE_OF: {
					alt4 = 5;
				}
					break;
				case SAME_AS: {
					alt4 = 6;
				}
					break;
				case DIFFERENT_FROM: {
					alt4 = 7;
				}
					break;
				case DOMAIN: {
					alt4 = 8;
				}
					break;
				case RANGE: {
					alt4 = 9;
				}
					break;
				default:
					if (this.state.backtracking > 0) {
						this.state.failed = true;
						return retval;
					}
					NoViableAltException nvae = new NoViableAltException("", 4, 0, this.input);
					throw nvae;
				}
				switch (alt4) {
				case 1:
					// /Users/luigi/Documents/workspace/Parsers/src/MOWLParser.g:86:17:
					// SUBCLASS_OF superClass= expression
				{
					SUBCLASS_OF12 = (Token) this.match(
							this.input,
							SUBCLASS_OF,
							FOLLOW_SUBCLASS_OF_in_binaryAxiom453);
					if (this.state.failed) {
						return retval;
					}
					if (this.state.backtracking == 0) {
						stream_SUBCLASS_OF.add(SUBCLASS_OF12);
					}
					this.pushFollow(FOLLOW_expression_in_binaryAxiom460);
					superClass = this.expression();
					this.state._fsp--;
					if (this.state.failed) {
						return retval;
					}
					if (this.state.backtracking == 0) {
						stream_expression.add(superClass.getTree());
					}
					// AST REWRITE
					// elements: superClass, lhs
					// token labels:
					// rule labels: retval, superClass, lhs
					// token list labels:
					// rule list labels:
					// wildcard labels:
					if (this.state.backtracking == 0) {
						retval.tree = root_0;
						RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(
								this.adaptor, "rule retval", retval != null ? retval.tree : null);
						RewriteRuleSubtreeStream stream_superClass = new RewriteRuleSubtreeStream(
								this.adaptor, "rule superClass",
								superClass != null ? superClass.tree : null);
						RewriteRuleSubtreeStream stream_lhs = new RewriteRuleSubtreeStream(
								this.adaptor, "rule lhs", lhs != null ? lhs.tree : null);
						root_0 = (ManchesterOWLSyntaxTree) this.adaptor.nil();
						// 86:54: -> ^( SUB_CLASS_AXIOM ^( EXPRESSION $lhs) ^(
						// EXPRESSION $superClass) )
						{
							// /Users/luigi/Documents/workspace/Parsers/src/MOWLParser.g:86:57:
							// ^( SUB_CLASS_AXIOM ^( EXPRESSION $lhs) ^(
							// EXPRESSION $superClass) )
							{
								ManchesterOWLSyntaxTree root_1 = (ManchesterOWLSyntaxTree) this.adaptor.nil();
								root_1 = (ManchesterOWLSyntaxTree) this.adaptor.becomeRoot(
										this.adaptor.create(SUB_CLASS_AXIOM, "SUB_CLASS_AXIOM"),
										root_1);
								// /Users/luigi/Documents/workspace/Parsers/src/MOWLParser.g:86:76:
								// ^( EXPRESSION $lhs)
								{
									ManchesterOWLSyntaxTree root_2 = (ManchesterOWLSyntaxTree) this.adaptor.nil();
									root_2 = (ManchesterOWLSyntaxTree) this.adaptor.becomeRoot(
											this.adaptor.create(EXPRESSION, "EXPRESSION"),
											root_2);
									this.adaptor.addChild(root_2, stream_lhs.nextTree());
									this.adaptor.addChild(root_1, root_2);
								}
								// /Users/luigi/Documents/workspace/Parsers/src/MOWLParser.g:86:95:
								// ^( EXPRESSION $superClass)
								{
									ManchesterOWLSyntaxTree root_2 = (ManchesterOWLSyntaxTree) this.adaptor.nil();
									root_2 = (ManchesterOWLSyntaxTree) this.adaptor.becomeRoot(
											this.adaptor.create(EXPRESSION, "EXPRESSION"),
											root_2);
									this.adaptor.addChild(root_2, stream_superClass.nextTree());
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
					// /Users/luigi/Documents/workspace/Parsers/src/MOWLParser.g:87:19:
					// EQUIVALENT_TO rhs= expression
				{
					EQUIVALENT_TO13 = (Token) this.match(
							this.input,
							EQUIVALENT_TO,
							FOLLOW_EQUIVALENT_TO_in_binaryAxiom501);
					if (this.state.failed) {
						return retval;
					}
					if (this.state.backtracking == 0) {
						stream_EQUIVALENT_TO.add(EQUIVALENT_TO13);
					}
					this.pushFollow(FOLLOW_expression_in_binaryAxiom507);
					rhs = this.expression();
					this.state._fsp--;
					if (this.state.failed) {
						return retval;
					}
					if (this.state.backtracking == 0) {
						stream_expression.add(rhs.getTree());
					}
					// AST REWRITE
					// elements: rhs, lhs
					// token labels:
					// rule labels: retval, rhs, lhs
					// token list labels:
					// rule list labels:
					// wildcard labels:
					if (this.state.backtracking == 0) {
						retval.tree = root_0;
						RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(
								this.adaptor, "rule retval", retval != null ? retval.tree : null);
						RewriteRuleSubtreeStream stream_rhs = new RewriteRuleSubtreeStream(
								this.adaptor, "rule rhs", rhs != null ? rhs.tree : null);
						RewriteRuleSubtreeStream stream_lhs = new RewriteRuleSubtreeStream(
								this.adaptor, "rule lhs", lhs != null ? lhs.tree : null);
						root_0 = (ManchesterOWLSyntaxTree) this.adaptor.nil();
						// 87:50: -> ^( EQUIVALENT_TO_AXIOM ^( EXPRESSION $lhs)
						// ^( EXPRESSION $rhs) )
						{
							// /Users/luigi/Documents/workspace/Parsers/src/MOWLParser.g:87:53:
							// ^( EQUIVALENT_TO_AXIOM ^( EXPRESSION $lhs) ^(
							// EXPRESSION $rhs) )
							{
								ManchesterOWLSyntaxTree root_1 = (ManchesterOWLSyntaxTree) this.adaptor.nil();
								root_1 = (ManchesterOWLSyntaxTree) this.adaptor.becomeRoot(
										this.adaptor.create(
												EQUIVALENT_TO_AXIOM,
												"EQUIVALENT_TO_AXIOM"),
										root_1);
								// /Users/luigi/Documents/workspace/Parsers/src/MOWLParser.g:87:75:
								// ^( EXPRESSION $lhs)
								{
									ManchesterOWLSyntaxTree root_2 = (ManchesterOWLSyntaxTree) this.adaptor.nil();
									root_2 = (ManchesterOWLSyntaxTree) this.adaptor.becomeRoot(
											this.adaptor.create(EXPRESSION, "EXPRESSION"),
											root_2);
									this.adaptor.addChild(root_2, stream_lhs.nextTree());
									this.adaptor.addChild(root_1, root_2);
								}
								// /Users/luigi/Documents/workspace/Parsers/src/MOWLParser.g:87:94:
								// ^( EXPRESSION $rhs)
								{
									ManchesterOWLSyntaxTree root_2 = (ManchesterOWLSyntaxTree) this.adaptor.nil();
									root_2 = (ManchesterOWLSyntaxTree) this.adaptor.becomeRoot(
											this.adaptor.create(EXPRESSION, "EXPRESSION"),
											root_2);
									this.adaptor.addChild(root_2, stream_rhs.nextTree());
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
					// /Users/luigi/Documents/workspace/Parsers/src/MOWLParser.g:88:19:
					// DISJOINT_WITH disjoint= expression
				{
					DISJOINT_WITH14 = (Token) this.match(
							this.input,
							DISJOINT_WITH,
							FOLLOW_DISJOINT_WITH_in_binaryAxiom547);
					if (this.state.failed) {
						return retval;
					}
					if (this.state.backtracking == 0) {
						stream_DISJOINT_WITH.add(DISJOINT_WITH14);
					}
					this.pushFollow(FOLLOW_expression_in_binaryAxiom553);
					disjoint = this.expression();
					this.state._fsp--;
					if (this.state.failed) {
						return retval;
					}
					if (this.state.backtracking == 0) {
						stream_expression.add(disjoint.getTree());
					}
					// AST REWRITE
					// elements: lhs, disjoint
					// token labels:
					// rule labels: retval, disjoint, lhs
					// token list labels:
					// rule list labels:
					// wildcard labels:
					if (this.state.backtracking == 0) {
						retval.tree = root_0;
						RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(
								this.adaptor, "rule retval", retval != null ? retval.tree : null);
						RewriteRuleSubtreeStream stream_disjoint = new RewriteRuleSubtreeStream(
								this.adaptor, "rule disjoint", disjoint != null ? disjoint.tree
										: null);
						RewriteRuleSubtreeStream stream_lhs = new RewriteRuleSubtreeStream(
								this.adaptor, "rule lhs", lhs != null ? lhs.tree : null);
						root_0 = (ManchesterOWLSyntaxTree) this.adaptor.nil();
						// 88:55: -> ^( DISJOINT_WITH_AXIOM ^( EXPRESSION $lhs)
						// ^( EXPRESSION $disjoint) )
						{
							// /Users/luigi/Documents/workspace/Parsers/src/MOWLParser.g:88:58:
							// ^( DISJOINT_WITH_AXIOM ^( EXPRESSION $lhs) ^(
							// EXPRESSION $disjoint) )
							{
								ManchesterOWLSyntaxTree root_1 = (ManchesterOWLSyntaxTree) this.adaptor.nil();
								root_1 = (ManchesterOWLSyntaxTree) this.adaptor.becomeRoot(
										this.adaptor.create(
												DISJOINT_WITH_AXIOM,
												"DISJOINT_WITH_AXIOM"),
										root_1);
								// /Users/luigi/Documents/workspace/Parsers/src/MOWLParser.g:88:80:
								// ^( EXPRESSION $lhs)
								{
									ManchesterOWLSyntaxTree root_2 = (ManchesterOWLSyntaxTree) this.adaptor.nil();
									root_2 = (ManchesterOWLSyntaxTree) this.adaptor.becomeRoot(
											this.adaptor.create(EXPRESSION, "EXPRESSION"),
											root_2);
									this.adaptor.addChild(root_2, stream_lhs.nextTree());
									this.adaptor.addChild(root_1, root_2);
								}
								// /Users/luigi/Documents/workspace/Parsers/src/MOWLParser.g:88:99:
								// ^( EXPRESSION $disjoint)
								{
									ManchesterOWLSyntaxTree root_2 = (ManchesterOWLSyntaxTree) this.adaptor.nil();
									root_2 = (ManchesterOWLSyntaxTree) this.adaptor.becomeRoot(
											this.adaptor.create(EXPRESSION, "EXPRESSION"),
											root_2);
									this.adaptor.addChild(root_2, stream_disjoint.nextTree());
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
					// /Users/luigi/Documents/workspace/Parsers/src/MOWLParser.g:89:19:
					// SUB_PROPERTY_OF superProperty= propertyExpression
				{
					SUB_PROPERTY_OF15 = (Token) this.match(
							this.input,
							SUB_PROPERTY_OF,
							FOLLOW_SUB_PROPERTY_OF_in_binaryAxiom593);
					if (this.state.failed) {
						return retval;
					}
					if (this.state.backtracking == 0) {
						stream_SUB_PROPERTY_OF.add(SUB_PROPERTY_OF15);
					}
					this.pushFollow(FOLLOW_propertyExpression_in_binaryAxiom599);
					superProperty = this.propertyExpression();
					this.state._fsp--;
					if (this.state.failed) {
						return retval;
					}
					if (this.state.backtracking == 0) {
						stream_propertyExpression.add(superProperty.getTree());
					}
					// AST REWRITE
					// elements: superProperty, lhs
					// token labels:
					// rule labels: retval, superProperty, lhs
					// token list labels:
					// rule list labels:
					// wildcard labels:
					if (this.state.backtracking == 0) {
						retval.tree = root_0;
						RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(
								this.adaptor, "rule retval", retval != null ? retval.tree : null);
						RewriteRuleSubtreeStream stream_superProperty = new RewriteRuleSubtreeStream(
								this.adaptor, "rule superProperty",
								superProperty != null ? superProperty.tree : null);
						RewriteRuleSubtreeStream stream_lhs = new RewriteRuleSubtreeStream(
								this.adaptor, "rule lhs", lhs != null ? lhs.tree : null);
						root_0 = (ManchesterOWLSyntaxTree) this.adaptor.nil();
						// 89:70: -> ^( SUB_PROPERTY_AXIOM ^( EXPRESSION $lhs)
						// ^( EXPRESSION $superProperty) )
						{
							// /Users/luigi/Documents/workspace/Parsers/src/MOWLParser.g:89:73:
							// ^( SUB_PROPERTY_AXIOM ^( EXPRESSION $lhs) ^(
							// EXPRESSION $superProperty) )
							{
								ManchesterOWLSyntaxTree root_1 = (ManchesterOWLSyntaxTree) this.adaptor.nil();
								root_1 = (ManchesterOWLSyntaxTree) this.adaptor.becomeRoot(
										this.adaptor.create(
												SUB_PROPERTY_AXIOM,
												"SUB_PROPERTY_AXIOM"),
										root_1);
								// /Users/luigi/Documents/workspace/Parsers/src/MOWLParser.g:89:94:
								// ^( EXPRESSION $lhs)
								{
									ManchesterOWLSyntaxTree root_2 = (ManchesterOWLSyntaxTree) this.adaptor.nil();
									root_2 = (ManchesterOWLSyntaxTree) this.adaptor.becomeRoot(
											this.adaptor.create(EXPRESSION, "EXPRESSION"),
											root_2);
									this.adaptor.addChild(root_2, stream_lhs.nextTree());
									this.adaptor.addChild(root_1, root_2);
								}
								// /Users/luigi/Documents/workspace/Parsers/src/MOWLParser.g:89:113:
								// ^( EXPRESSION $superProperty)
								{
									ManchesterOWLSyntaxTree root_2 = (ManchesterOWLSyntaxTree) this.adaptor.nil();
									root_2 = (ManchesterOWLSyntaxTree) this.adaptor.becomeRoot(
											this.adaptor.create(EXPRESSION, "EXPRESSION"),
											root_2);
									this.adaptor.addChild(root_2, stream_superProperty.nextTree());
									this.adaptor.addChild(root_1, root_2);
								}
								this.adaptor.addChild(root_0, root_1);
							}
						}
						retval.tree = root_0;
					}
				}
					break;
				case 5:
					// /Users/luigi/Documents/workspace/Parsers/src/MOWLParser.g:90:19:
					// INVERSE_OF rhsAtomic= atomic
				{
					INVERSE_OF16 = (Token) this.match(
							this.input,
							INVERSE_OF,
							FOLLOW_INVERSE_OF_in_binaryAxiom639);
					if (this.state.failed) {
						return retval;
					}
					if (this.state.backtracking == 0) {
						stream_INVERSE_OF.add(INVERSE_OF16);
					}
					this.pushFollow(FOLLOW_atomic_in_binaryAxiom645);
					rhsAtomic = this.atomic();
					this.state._fsp--;
					if (this.state.failed) {
						return retval;
					}
					if (this.state.backtracking == 0) {
						stream_atomic.add(rhsAtomic.getTree());
					}
					// AST REWRITE
					// elements: rhsAtomic, INVERSE_OF, lhs
					// token labels:
					// rule labels: retval, lhs, rhsAtomic
					// token list labels:
					// rule list labels:
					// wildcard labels:
					if (this.state.backtracking == 0) {
						retval.tree = root_0;
						RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(
								this.adaptor, "rule retval", retval != null ? retval.tree : null);
						RewriteRuleSubtreeStream stream_lhs = new RewriteRuleSubtreeStream(
								this.adaptor, "rule lhs", lhs != null ? lhs.tree : null);
						RewriteRuleSubtreeStream stream_rhsAtomic = new RewriteRuleSubtreeStream(
								this.adaptor, "rule rhsAtomic", rhsAtomic != null ? rhsAtomic.tree
										: null);
						root_0 = (ManchesterOWLSyntaxTree) this.adaptor.nil();
						// 90:49: -> ^( INVERSE_OF ^( EXPRESSION $lhs) ^(
						// EXPRESSION $rhsAtomic) )
						{
							// /Users/luigi/Documents/workspace/Parsers/src/MOWLParser.g:90:52:
							// ^( INVERSE_OF ^( EXPRESSION $lhs) ^( EXPRESSION
							// $rhsAtomic) )
							{
								ManchesterOWLSyntaxTree root_1 = (ManchesterOWLSyntaxTree) this.adaptor.nil();
								root_1 = (ManchesterOWLSyntaxTree) this.adaptor.becomeRoot(
										stream_INVERSE_OF.nextNode(),
										root_1);
								// /Users/luigi/Documents/workspace/Parsers/src/MOWLParser.g:90:65:
								// ^( EXPRESSION $lhs)
								{
									ManchesterOWLSyntaxTree root_2 = (ManchesterOWLSyntaxTree) this.adaptor.nil();
									root_2 = (ManchesterOWLSyntaxTree) this.adaptor.becomeRoot(
											this.adaptor.create(EXPRESSION, "EXPRESSION"),
											root_2);
									this.adaptor.addChild(root_2, stream_lhs.nextTree());
									this.adaptor.addChild(root_1, root_2);
								}
								// /Users/luigi/Documents/workspace/Parsers/src/MOWLParser.g:90:84:
								// ^( EXPRESSION $rhsAtomic)
								{
									ManchesterOWLSyntaxTree root_2 = (ManchesterOWLSyntaxTree) this.adaptor.nil();
									root_2 = (ManchesterOWLSyntaxTree) this.adaptor.becomeRoot(
											this.adaptor.create(EXPRESSION, "EXPRESSION"),
											root_2);
									this.adaptor.addChild(root_2, stream_rhsAtomic.nextTree());
									this.adaptor.addChild(root_1, root_2);
								}
								this.adaptor.addChild(root_0, root_1);
							}
						}
						retval.tree = root_0;
					}
				}
					break;
				case 6:
					// /Users/luigi/Documents/workspace/Parsers/src/MOWLParser.g:91:5:
					// SAME_AS rhsID= atomic
				{
					SAME_AS17 = (Token) this.match(
							this.input,
							SAME_AS,
							FOLLOW_SAME_AS_in_binaryAxiom673);
					if (this.state.failed) {
						return retval;
					}
					if (this.state.backtracking == 0) {
						stream_SAME_AS.add(SAME_AS17);
					}
					this.pushFollow(FOLLOW_atomic_in_binaryAxiom680);
					rhsID = this.atomic();
					this.state._fsp--;
					if (this.state.failed) {
						return retval;
					}
					if (this.state.backtracking == 0) {
						stream_atomic.add(rhsID.getTree());
					}
					// AST REWRITE
					// elements: lhs, rhsID
					// token labels:
					// rule labels: retval, rhsID, lhs
					// token list labels:
					// rule list labels:
					// wildcard labels:
					if (this.state.backtracking == 0) {
						retval.tree = root_0;
						RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(
								this.adaptor, "rule retval", retval != null ? retval.tree : null);
						RewriteRuleSubtreeStream stream_rhsID = new RewriteRuleSubtreeStream(
								this.adaptor, "rule rhsID", rhsID != null ? rhsID.tree : null);
						RewriteRuleSubtreeStream stream_lhs = new RewriteRuleSubtreeStream(
								this.adaptor, "rule lhs", lhs != null ? lhs.tree : null);
						root_0 = (ManchesterOWLSyntaxTree) this.adaptor.nil();
						// 91:29: -> ^( SAME_AS_AXIOM ^( EXPRESSION $lhs) ^(
						// EXPRESSION $rhsID) )
						{
							// /Users/luigi/Documents/workspace/Parsers/src/MOWLParser.g:91:32:
							// ^( SAME_AS_AXIOM ^( EXPRESSION $lhs) ^(
							// EXPRESSION $rhsID) )
							{
								ManchesterOWLSyntaxTree root_1 = (ManchesterOWLSyntaxTree) this.adaptor.nil();
								root_1 = (ManchesterOWLSyntaxTree) this.adaptor.becomeRoot(
										this.adaptor.create(SAME_AS_AXIOM, "SAME_AS_AXIOM"),
										root_1);
								// /Users/luigi/Documents/workspace/Parsers/src/MOWLParser.g:91:48:
								// ^( EXPRESSION $lhs)
								{
									ManchesterOWLSyntaxTree root_2 = (ManchesterOWLSyntaxTree) this.adaptor.nil();
									root_2 = (ManchesterOWLSyntaxTree) this.adaptor.becomeRoot(
											this.adaptor.create(EXPRESSION, "EXPRESSION"),
											root_2);
									this.adaptor.addChild(root_2, stream_lhs.nextTree());
									this.adaptor.addChild(root_1, root_2);
								}
								// /Users/luigi/Documents/workspace/Parsers/src/MOWLParser.g:91:68:
								// ^( EXPRESSION $rhsID)
								{
									ManchesterOWLSyntaxTree root_2 = (ManchesterOWLSyntaxTree) this.adaptor.nil();
									root_2 = (ManchesterOWLSyntaxTree) this.adaptor.becomeRoot(
											this.adaptor.create(EXPRESSION, "EXPRESSION"),
											root_2);
									this.adaptor.addChild(root_2, stream_rhsID.nextTree());
									this.adaptor.addChild(root_1, root_2);
								}
								this.adaptor.addChild(root_0, root_1);
							}
						}
						retval.tree = root_0;
					}
				}
					break;
				case 7:
					// /Users/luigi/Documents/workspace/Parsers/src/MOWLParser.g:92:19:
					// DIFFERENT_FROM rhsID= atomic
				{
					DIFFERENT_FROM18 = (Token) this.match(
							this.input,
							DIFFERENT_FROM,
							FOLLOW_DIFFERENT_FROM_in_binaryAxiom721);
					if (this.state.failed) {
						return retval;
					}
					if (this.state.backtracking == 0) {
						stream_DIFFERENT_FROM.add(DIFFERENT_FROM18);
					}
					this.pushFollow(FOLLOW_atomic_in_binaryAxiom728);
					rhsID = this.atomic();
					this.state._fsp--;
					if (this.state.failed) {
						return retval;
					}
					if (this.state.backtracking == 0) {
						stream_atomic.add(rhsID.getTree());
					}
					// AST REWRITE
					// elements: lhs, rhsID
					// token labels:
					// rule labels: retval, rhsID, lhs
					// token list labels:
					// rule list labels:
					// wildcard labels:
					if (this.state.backtracking == 0) {
						retval.tree = root_0;
						RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(
								this.adaptor, "rule retval", retval != null ? retval.tree : null);
						RewriteRuleSubtreeStream stream_rhsID = new RewriteRuleSubtreeStream(
								this.adaptor, "rule rhsID", rhsID != null ? rhsID.tree : null);
						RewriteRuleSubtreeStream stream_lhs = new RewriteRuleSubtreeStream(
								this.adaptor, "rule lhs", lhs != null ? lhs.tree : null);
						root_0 = (ManchesterOWLSyntaxTree) this.adaptor.nil();
						// 92:50: -> ^( DIFFERENT_FROM_AXIOM ^( EXPRESSION $lhs)
						// ^( EXPRESSION $rhsID) )
						{
							// /Users/luigi/Documents/workspace/Parsers/src/MOWLParser.g:92:53:
							// ^( DIFFERENT_FROM_AXIOM ^( EXPRESSION $lhs) ^(
							// EXPRESSION $rhsID) )
							{
								ManchesterOWLSyntaxTree root_1 = (ManchesterOWLSyntaxTree) this.adaptor.nil();
								root_1 = (ManchesterOWLSyntaxTree) this.adaptor.becomeRoot(
										this.adaptor.create(
												DIFFERENT_FROM_AXIOM,
												"DIFFERENT_FROM_AXIOM"),
										root_1);
								// /Users/luigi/Documents/workspace/Parsers/src/MOWLParser.g:92:76:
								// ^( EXPRESSION $lhs)
								{
									ManchesterOWLSyntaxTree root_2 = (ManchesterOWLSyntaxTree) this.adaptor.nil();
									root_2 = (ManchesterOWLSyntaxTree) this.adaptor.becomeRoot(
											this.adaptor.create(EXPRESSION, "EXPRESSION"),
											root_2);
									this.adaptor.addChild(root_2, stream_lhs.nextTree());
									this.adaptor.addChild(root_1, root_2);
								}
								// /Users/luigi/Documents/workspace/Parsers/src/MOWLParser.g:92:95:
								// ^( EXPRESSION $rhsID)
								{
									ManchesterOWLSyntaxTree root_2 = (ManchesterOWLSyntaxTree) this.adaptor.nil();
									root_2 = (ManchesterOWLSyntaxTree) this.adaptor.becomeRoot(
											this.adaptor.create(EXPRESSION, "EXPRESSION"),
											root_2);
									this.adaptor.addChild(root_2, stream_rhsID.nextTree());
									this.adaptor.addChild(root_1, root_2);
								}
								this.adaptor.addChild(root_0, root_1);
							}
						}
						retval.tree = root_0;
					}
				}
					break;
				case 8:
					// /Users/luigi/Documents/workspace/Parsers/src/MOWLParser.g:93:19:
					// DOMAIN expression
				{
					DOMAIN19 = (Token) this.match(
							this.input,
							DOMAIN,
							FOLLOW_DOMAIN_in_binaryAxiom768);
					if (this.state.failed) {
						return retval;
					}
					if (this.state.backtracking == 0) {
						stream_DOMAIN.add(DOMAIN19);
					}
					this.pushFollow(FOLLOW_expression_in_binaryAxiom770);
					expression20 = this.expression();
					this.state._fsp--;
					if (this.state.failed) {
						return retval;
					}
					if (this.state.backtracking == 0) {
						stream_expression.add(expression20.getTree());
					}
					// AST REWRITE
					// elements: DOMAIN, expression, lhs
					// token labels:
					// rule labels: retval, lhs
					// token list labels:
					// rule list labels:
					// wildcard labels:
					if (this.state.backtracking == 0) {
						retval.tree = root_0;
						RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(
								this.adaptor, "rule retval", retval != null ? retval.tree : null);
						RewriteRuleSubtreeStream stream_lhs = new RewriteRuleSubtreeStream(
								this.adaptor, "rule lhs", lhs != null ? lhs.tree : null);
						root_0 = (ManchesterOWLSyntaxTree) this.adaptor.nil();
						// 93:37: -> ^( DOMAIN ^( EXPRESSION $lhs) ^( EXPRESSION
						// expression ) )
						{
							// /Users/luigi/Documents/workspace/Parsers/src/MOWLParser.g:93:40:
							// ^( DOMAIN ^( EXPRESSION $lhs) ^( EXPRESSION
							// expression ) )
							{
								ManchesterOWLSyntaxTree root_1 = (ManchesterOWLSyntaxTree) this.adaptor.nil();
								root_1 = (ManchesterOWLSyntaxTree) this.adaptor.becomeRoot(
										stream_DOMAIN.nextNode(),
										root_1);
								// /Users/luigi/Documents/workspace/Parsers/src/MOWLParser.g:93:49:
								// ^( EXPRESSION $lhs)
								{
									ManchesterOWLSyntaxTree root_2 = (ManchesterOWLSyntaxTree) this.adaptor.nil();
									root_2 = (ManchesterOWLSyntaxTree) this.adaptor.becomeRoot(
											this.adaptor.create(EXPRESSION, "EXPRESSION"),
											root_2);
									this.adaptor.addChild(root_2, stream_lhs.nextTree());
									this.adaptor.addChild(root_1, root_2);
								}
								// /Users/luigi/Documents/workspace/Parsers/src/MOWLParser.g:93:68:
								// ^( EXPRESSION expression )
								{
									ManchesterOWLSyntaxTree root_2 = (ManchesterOWLSyntaxTree) this.adaptor.nil();
									root_2 = (ManchesterOWLSyntaxTree) this.adaptor.becomeRoot(
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
					break;
				case 9:
					// /Users/luigi/Documents/workspace/Parsers/src/MOWLParser.g:94:19:
					// RANGE expression
				{
					RANGE21 = (Token) this.match(this.input, RANGE, FOLLOW_RANGE_in_binaryAxiom809);
					if (this.state.failed) {
						return retval;
					}
					if (this.state.backtracking == 0) {
						stream_RANGE.add(RANGE21);
					}
					this.pushFollow(FOLLOW_expression_in_binaryAxiom811);
					expression22 = this.expression();
					this.state._fsp--;
					if (this.state.failed) {
						return retval;
					}
					if (this.state.backtracking == 0) {
						stream_expression.add(expression22.getTree());
					}
					// AST REWRITE
					// elements: expression, lhs, RANGE
					// token labels:
					// rule labels: retval, lhs
					// token list labels:
					// rule list labels:
					// wildcard labels:
					if (this.state.backtracking == 0) {
						retval.tree = root_0;
						RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(
								this.adaptor, "rule retval", retval != null ? retval.tree : null);
						RewriteRuleSubtreeStream stream_lhs = new RewriteRuleSubtreeStream(
								this.adaptor, "rule lhs", lhs != null ? lhs.tree : null);
						root_0 = (ManchesterOWLSyntaxTree) this.adaptor.nil();
						// 94:36: -> ^( RANGE ^( EXPRESSION $lhs) ^( EXPRESSION
						// expression ) )
						{
							// /Users/luigi/Documents/workspace/Parsers/src/MOWLParser.g:94:39:
							// ^( RANGE ^( EXPRESSION $lhs) ^( EXPRESSION
							// expression ) )
							{
								ManchesterOWLSyntaxTree root_1 = (ManchesterOWLSyntaxTree) this.adaptor.nil();
								root_1 = (ManchesterOWLSyntaxTree) this.adaptor.becomeRoot(
										stream_RANGE.nextNode(),
										root_1);
								// /Users/luigi/Documents/workspace/Parsers/src/MOWLParser.g:94:47:
								// ^( EXPRESSION $lhs)
								{
									ManchesterOWLSyntaxTree root_2 = (ManchesterOWLSyntaxTree) this.adaptor.nil();
									root_2 = (ManchesterOWLSyntaxTree) this.adaptor.becomeRoot(
											this.adaptor.create(EXPRESSION, "EXPRESSION"),
											root_2);
									this.adaptor.addChild(root_2, stream_lhs.nextTree());
									this.adaptor.addChild(root_1, root_2);
								}
								// /Users/luigi/Documents/workspace/Parsers/src/MOWLParser.g:94:66:
								// ^( EXPRESSION expression )
								{
									ManchesterOWLSyntaxTree root_2 = (ManchesterOWLSyntaxTree) this.adaptor.nil();
									root_2 = (ManchesterOWLSyntaxTree) this.adaptor.becomeRoot(
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
					break;
				}
			}
			retval.stop = this.input.LT(-1);
			if (this.state.backtracking == 0) {
				retval.tree = (ManchesterOWLSyntaxTree) this.adaptor.rulePostProcessing(root_0);
				this.adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		} catch (RecognitionException e) {
			throw e;
		} catch (RewriteEmptyStreamException e) {
			throw e;
		} finally {
		}
		return retval;
	}

	// $ANTLR end "binaryAxiom"
	public static class unaryAxiom_return extends ParserRuleReturnScope {
		ManchesterOWLSyntaxTree tree;

		@Override
		public Object getTree() {
			return this.tree;
		}
	};

	// $ANTLR start "unaryAxiom"
	// /Users/luigi/Documents/workspace/Parsers/src/MOWLParser.g:100:1:
	// unaryAxiom : unaryCharacteristic unary -> ^( UNARY_AXIOM
	// unaryCharacteristic ^( EXPRESSION unary ) ) ;
	public final MOWLParser.unaryAxiom_return unaryAxiom() throws RecognitionException {
		MOWLParser.unaryAxiom_return retval = new MOWLParser.unaryAxiom_return();
		retval.start = this.input.LT(1);
		ManchesterOWLSyntaxTree root_0 = null;
		MOWLParser.unaryCharacteristic_return unaryCharacteristic23 = null;
		MOWLParser.unary_return unary24 = null;
		RewriteRuleSubtreeStream stream_unary = new RewriteRuleSubtreeStream(this.adaptor,
				"rule unary");
		RewriteRuleSubtreeStream stream_unaryCharacteristic = new RewriteRuleSubtreeStream(
				this.adaptor, "rule unaryCharacteristic");
		try {
			// /Users/luigi/Documents/workspace/Parsers/src/MOWLParser.g:100:13:
			// ( unaryCharacteristic unary -> ^( UNARY_AXIOM unaryCharacteristic
			// ^( EXPRESSION unary ) ) )
			// /Users/luigi/Documents/workspace/Parsers/src/MOWLParser.g:101:4:
			// unaryCharacteristic unary
			{
				this.pushFollow(FOLLOW_unaryCharacteristic_in_unaryAxiom911);
				unaryCharacteristic23 = this.unaryCharacteristic();
				this.state._fsp--;
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_unaryCharacteristic.add(unaryCharacteristic23.getTree());
				}
				this.pushFollow(FOLLOW_unary_in_unaryAxiom915);
				unary24 = this.unary();
				this.state._fsp--;
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_unary.add(unary24.getTree());
				}
				// AST REWRITE
				// elements: unary, unaryCharacteristic
				// token labels:
				// rule labels: retval
				// token list labels:
				// rule list labels:
				// wildcard labels:
				if (this.state.backtracking == 0) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(
							this.adaptor, "rule retval", retval != null ? retval.tree : null);
					root_0 = (ManchesterOWLSyntaxTree) this.adaptor.nil();
					// 101:32: -> ^( UNARY_AXIOM unaryCharacteristic ^(
					// EXPRESSION unary ) )
					{
						// /Users/luigi/Documents/workspace/Parsers/src/MOWLParser.g:101:35:
						// ^( UNARY_AXIOM unaryCharacteristic ^( EXPRESSION
						// unary ) )
						{
							ManchesterOWLSyntaxTree root_1 = (ManchesterOWLSyntaxTree) this.adaptor.nil();
							root_1 = (ManchesterOWLSyntaxTree) this.adaptor.becomeRoot(
									this.adaptor.create(UNARY_AXIOM, "UNARY_AXIOM"),
									root_1);
							this.adaptor.addChild(root_1, stream_unaryCharacteristic.nextTree());
							// /Users/luigi/Documents/workspace/Parsers/src/MOWLParser.g:101:69:
							// ^( EXPRESSION unary )
							{
								ManchesterOWLSyntaxTree root_2 = (ManchesterOWLSyntaxTree) this.adaptor.nil();
								root_2 = (ManchesterOWLSyntaxTree) this.adaptor.becomeRoot(
										this.adaptor.create(EXPRESSION, "EXPRESSION"),
										root_2);
								this.adaptor.addChild(root_2, stream_unary.nextTree());
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
				retval.tree = (ManchesterOWLSyntaxTree) this.adaptor.rulePostProcessing(root_0);
				this.adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		} catch (RecognitionException e) {
			throw e;
		} catch (RewriteEmptyStreamException e) {
			throw e;
		} finally {
		}
		return retval;
	}

	// $ANTLR end "unaryAxiom"
	public static class unaryCharacteristic_return extends ParserRuleReturnScope {
		ManchesterOWLSyntaxTree tree;

		@Override
		public Object getTree() {
			return this.tree;
		}
	};

	// $ANTLR start "unaryCharacteristic"
	// /Users/luigi/Documents/workspace/Parsers/src/MOWLParser.g:104:1:
	// unaryCharacteristic : ( FUNCTIONAL -> ^( FUNCTIONAL ) |
	// INVERSE_FUNCTIONAL -> ^( INVERSE_FUNCTIONAL ) | SYMMETRIC -> ^( SYMMETRIC
	// ) | ANTI_SYMMETRIC -> ^( ANTI_SYMMETRIC ) | REFLEXIVE -> ^( REFLEXIVE ) |
	// IRREFLEXIVE -> ^( IRREFLEXIVE ) | TRANSITIVE -> ^( TRANSITIVE ) );
	public final MOWLParser.unaryCharacteristic_return unaryCharacteristic()
			throws RecognitionException {
		MOWLParser.unaryCharacteristic_return retval = new MOWLParser.unaryCharacteristic_return();
		retval.start = this.input.LT(1);
		ManchesterOWLSyntaxTree root_0 = null;
		Token FUNCTIONAL25 = null;
		Token INVERSE_FUNCTIONAL26 = null;
		Token SYMMETRIC27 = null;
		Token ANTI_SYMMETRIC28 = null;
		Token REFLEXIVE29 = null;
		Token IRREFLEXIVE30 = null;
		Token TRANSITIVE31 = null;
		ManchesterOWLSyntaxTree FUNCTIONAL25_tree = null;
		ManchesterOWLSyntaxTree INVERSE_FUNCTIONAL26_tree = null;
		ManchesterOWLSyntaxTree SYMMETRIC27_tree = null;
		ManchesterOWLSyntaxTree ANTI_SYMMETRIC28_tree = null;
		ManchesterOWLSyntaxTree REFLEXIVE29_tree = null;
		ManchesterOWLSyntaxTree IRREFLEXIVE30_tree = null;
		ManchesterOWLSyntaxTree TRANSITIVE31_tree = null;
		RewriteRuleTokenStream stream_REFLEXIVE = new RewriteRuleTokenStream(this.adaptor,
				"token REFLEXIVE");
		RewriteRuleTokenStream stream_SYMMETRIC = new RewriteRuleTokenStream(this.adaptor,
				"token SYMMETRIC");
		RewriteRuleTokenStream stream_FUNCTIONAL = new RewriteRuleTokenStream(this.adaptor,
				"token FUNCTIONAL");
		RewriteRuleTokenStream stream_TRANSITIVE = new RewriteRuleTokenStream(this.adaptor,
				"token TRANSITIVE");
		RewriteRuleTokenStream stream_ANTI_SYMMETRIC = new RewriteRuleTokenStream(this.adaptor,
				"token ANTI_SYMMETRIC");
		RewriteRuleTokenStream stream_INVERSE_FUNCTIONAL = new RewriteRuleTokenStream(this.adaptor,
				"token INVERSE_FUNCTIONAL");
		RewriteRuleTokenStream stream_IRREFLEXIVE = new RewriteRuleTokenStream(this.adaptor,
				"token IRREFLEXIVE");
		try {
			// /Users/luigi/Documents/workspace/Parsers/src/MOWLParser.g:104:21:
			// ( FUNCTIONAL -> ^( FUNCTIONAL ) | INVERSE_FUNCTIONAL -> ^(
			// INVERSE_FUNCTIONAL ) | SYMMETRIC -> ^( SYMMETRIC ) |
			// ANTI_SYMMETRIC -> ^( ANTI_SYMMETRIC ) | REFLEXIVE -> ^( REFLEXIVE
			// ) | IRREFLEXIVE -> ^( IRREFLEXIVE ) | TRANSITIVE -> ^( TRANSITIVE
			// ) )
			int alt5 = 7;
			switch (this.input.LA(1)) {
			case FUNCTIONAL: {
				alt5 = 1;
			}
				break;
			case INVERSE_FUNCTIONAL: {
				alt5 = 2;
			}
				break;
			case SYMMETRIC: {
				alt5 = 3;
			}
				break;
			case ANTI_SYMMETRIC: {
				alt5 = 4;
			}
				break;
			case REFLEXIVE: {
				alt5 = 5;
			}
				break;
			case IRREFLEXIVE: {
				alt5 = 6;
			}
				break;
			case TRANSITIVE: {
				alt5 = 7;
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
				// /Users/luigi/Documents/workspace/Parsers/src/MOWLParser.g:105:5:
				// FUNCTIONAL
			{
				FUNCTIONAL25 = (Token) this.match(
						this.input,
						FUNCTIONAL,
						FOLLOW_FUNCTIONAL_in_unaryCharacteristic960);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_FUNCTIONAL.add(FUNCTIONAL25);
				}
				// AST REWRITE
				// elements: FUNCTIONAL
				// token labels:
				// rule labels: retval
				// token list labels:
				// rule list labels:
				// wildcard labels:
				if (this.state.backtracking == 0) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(
							this.adaptor, "rule retval", retval != null ? retval.tree : null);
					root_0 = (ManchesterOWLSyntaxTree) this.adaptor.nil();
					// 105:16: -> ^( FUNCTIONAL )
					{
						// /Users/luigi/Documents/workspace/Parsers/src/MOWLParser.g:105:19:
						// ^( FUNCTIONAL )
						{
							ManchesterOWLSyntaxTree root_1 = (ManchesterOWLSyntaxTree) this.adaptor.nil();
							root_1 = (ManchesterOWLSyntaxTree) this.adaptor.becomeRoot(
									stream_FUNCTIONAL.nextNode(),
									root_1);
							this.adaptor.addChild(root_0, root_1);
						}
					}
					retval.tree = root_0;
				}
			}
				break;
			case 2:
				// /Users/luigi/Documents/workspace/Parsers/src/MOWLParser.g:106:7:
				// INVERSE_FUNCTIONAL
			{
				INVERSE_FUNCTIONAL26 = (Token) this.match(
						this.input,
						INVERSE_FUNCTIONAL,
						FOLLOW_INVERSE_FUNCTIONAL_in_unaryCharacteristic974);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_INVERSE_FUNCTIONAL.add(INVERSE_FUNCTIONAL26);
				}
				// AST REWRITE
				// elements: INVERSE_FUNCTIONAL
				// token labels:
				// rule labels: retval
				// token list labels:
				// rule list labels:
				// wildcard labels:
				if (this.state.backtracking == 0) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(
							this.adaptor, "rule retval", retval != null ? retval.tree : null);
					root_0 = (ManchesterOWLSyntaxTree) this.adaptor.nil();
					// 106:26: -> ^( INVERSE_FUNCTIONAL )
					{
						// /Users/luigi/Documents/workspace/Parsers/src/MOWLParser.g:106:29:
						// ^( INVERSE_FUNCTIONAL )
						{
							ManchesterOWLSyntaxTree root_1 = (ManchesterOWLSyntaxTree) this.adaptor.nil();
							root_1 = (ManchesterOWLSyntaxTree) this.adaptor.becomeRoot(
									stream_INVERSE_FUNCTIONAL.nextNode(),
									root_1);
							this.adaptor.addChild(root_0, root_1);
						}
					}
					retval.tree = root_0;
				}
			}
				break;
			case 3:
				// /Users/luigi/Documents/workspace/Parsers/src/MOWLParser.g:107:7:
				// SYMMETRIC
			{
				SYMMETRIC27 = (Token) this.match(
						this.input,
						SYMMETRIC,
						FOLLOW_SYMMETRIC_in_unaryCharacteristic988);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_SYMMETRIC.add(SYMMETRIC27);
				}
				// AST REWRITE
				// elements: SYMMETRIC
				// token labels:
				// rule labels: retval
				// token list labels:
				// rule list labels:
				// wildcard labels:
				if (this.state.backtracking == 0) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(
							this.adaptor, "rule retval", retval != null ? retval.tree : null);
					root_0 = (ManchesterOWLSyntaxTree) this.adaptor.nil();
					// 107:17: -> ^( SYMMETRIC )
					{
						// /Users/luigi/Documents/workspace/Parsers/src/MOWLParser.g:107:20:
						// ^( SYMMETRIC )
						{
							ManchesterOWLSyntaxTree root_1 = (ManchesterOWLSyntaxTree) this.adaptor.nil();
							root_1 = (ManchesterOWLSyntaxTree) this.adaptor.becomeRoot(
									stream_SYMMETRIC.nextNode(),
									root_1);
							this.adaptor.addChild(root_0, root_1);
						}
					}
					retval.tree = root_0;
				}
			}
				break;
			case 4:
				// /Users/luigi/Documents/workspace/Parsers/src/MOWLParser.g:108:7:
				// ANTI_SYMMETRIC
			{
				ANTI_SYMMETRIC28 = (Token) this.match(
						this.input,
						ANTI_SYMMETRIC,
						FOLLOW_ANTI_SYMMETRIC_in_unaryCharacteristic1002);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_ANTI_SYMMETRIC.add(ANTI_SYMMETRIC28);
				}
				// AST REWRITE
				// elements: ANTI_SYMMETRIC
				// token labels:
				// rule labels: retval
				// token list labels:
				// rule list labels:
				// wildcard labels:
				if (this.state.backtracking == 0) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(
							this.adaptor, "rule retval", retval != null ? retval.tree : null);
					root_0 = (ManchesterOWLSyntaxTree) this.adaptor.nil();
					// 108:22: -> ^( ANTI_SYMMETRIC )
					{
						// /Users/luigi/Documents/workspace/Parsers/src/MOWLParser.g:108:25:
						// ^( ANTI_SYMMETRIC )
						{
							ManchesterOWLSyntaxTree root_1 = (ManchesterOWLSyntaxTree) this.adaptor.nil();
							root_1 = (ManchesterOWLSyntaxTree) this.adaptor.becomeRoot(
									stream_ANTI_SYMMETRIC.nextNode(),
									root_1);
							this.adaptor.addChild(root_0, root_1);
						}
					}
					retval.tree = root_0;
				}
			}
				break;
			case 5:
				// /Users/luigi/Documents/workspace/Parsers/src/MOWLParser.g:109:7:
				// REFLEXIVE
			{
				REFLEXIVE29 = (Token) this.match(
						this.input,
						REFLEXIVE,
						FOLLOW_REFLEXIVE_in_unaryCharacteristic1016);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_REFLEXIVE.add(REFLEXIVE29);
				}
				// AST REWRITE
				// elements: REFLEXIVE
				// token labels:
				// rule labels: retval
				// token list labels:
				// rule list labels:
				// wildcard labels:
				if (this.state.backtracking == 0) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(
							this.adaptor, "rule retval", retval != null ? retval.tree : null);
					root_0 = (ManchesterOWLSyntaxTree) this.adaptor.nil();
					// 109:17: -> ^( REFLEXIVE )
					{
						// /Users/luigi/Documents/workspace/Parsers/src/MOWLParser.g:109:20:
						// ^( REFLEXIVE )
						{
							ManchesterOWLSyntaxTree root_1 = (ManchesterOWLSyntaxTree) this.adaptor.nil();
							root_1 = (ManchesterOWLSyntaxTree) this.adaptor.becomeRoot(
									stream_REFLEXIVE.nextNode(),
									root_1);
							this.adaptor.addChild(root_0, root_1);
						}
					}
					retval.tree = root_0;
				}
			}
				break;
			case 6:
				// /Users/luigi/Documents/workspace/Parsers/src/MOWLParser.g:110:7:
				// IRREFLEXIVE
			{
				IRREFLEXIVE30 = (Token) this.match(
						this.input,
						IRREFLEXIVE,
						FOLLOW_IRREFLEXIVE_in_unaryCharacteristic1030);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_IRREFLEXIVE.add(IRREFLEXIVE30);
				}
				// AST REWRITE
				// elements: IRREFLEXIVE
				// token labels:
				// rule labels: retval
				// token list labels:
				// rule list labels:
				// wildcard labels:
				if (this.state.backtracking == 0) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(
							this.adaptor, "rule retval", retval != null ? retval.tree : null);
					root_0 = (ManchesterOWLSyntaxTree) this.adaptor.nil();
					// 110:19: -> ^( IRREFLEXIVE )
					{
						// /Users/luigi/Documents/workspace/Parsers/src/MOWLParser.g:110:22:
						// ^( IRREFLEXIVE )
						{
							ManchesterOWLSyntaxTree root_1 = (ManchesterOWLSyntaxTree) this.adaptor.nil();
							root_1 = (ManchesterOWLSyntaxTree) this.adaptor.becomeRoot(
									stream_IRREFLEXIVE.nextNode(),
									root_1);
							this.adaptor.addChild(root_0, root_1);
						}
					}
					retval.tree = root_0;
				}
			}
				break;
			case 7:
				// /Users/luigi/Documents/workspace/Parsers/src/MOWLParser.g:111:7:
				// TRANSITIVE
			{
				TRANSITIVE31 = (Token) this.match(
						this.input,
						TRANSITIVE,
						FOLLOW_TRANSITIVE_in_unaryCharacteristic1044);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_TRANSITIVE.add(TRANSITIVE31);
				}
				// AST REWRITE
				// elements: TRANSITIVE
				// token labels:
				// rule labels: retval
				// token list labels:
				// rule list labels:
				// wildcard labels:
				if (this.state.backtracking == 0) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(
							this.adaptor, "rule retval", retval != null ? retval.tree : null);
					root_0 = (ManchesterOWLSyntaxTree) this.adaptor.nil();
					// 111:18: -> ^( TRANSITIVE )
					{
						// /Users/luigi/Documents/workspace/Parsers/src/MOWLParser.g:111:21:
						// ^( TRANSITIVE )
						{
							ManchesterOWLSyntaxTree root_1 = (ManchesterOWLSyntaxTree) this.adaptor.nil();
							root_1 = (ManchesterOWLSyntaxTree) this.adaptor.becomeRoot(
									stream_TRANSITIVE.nextNode(),
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
				retval.tree = (ManchesterOWLSyntaxTree) this.adaptor.rulePostProcessing(root_0);
				this.adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		} catch (RecognitionException e) {
			throw e;
		} catch (RewriteEmptyStreamException e) {
			throw e;
		} finally {
		}
		return retval;
	}

	// $ANTLR end "unaryCharacteristic"
	public static class expression_return extends ParserRuleReturnScope {
		ManchesterOWLSyntaxTree tree;

		@Override
		public Object getTree() {
			return this.tree;
		}
	};

	// $ANTLR start "expression"
	// /Users/luigi/Documents/workspace/Parsers/src/MOWLParser.g:114:1:
	// expression : ( options {backtrack=true; } : | conjunction ( OR
	// conjunction )* -> ^( DISJUNCTION ( conjunction )+ ) |
	// complexPropertyExpression -> ^( complexPropertyExpression ) |
	// OPEN_PARENTHESYS expression CLOSED_PARENTHESYS -> ^( expression ) ) ;
	public final MOWLParser.expression_return expression() throws RecognitionException {
		MOWLParser.expression_return retval = new MOWLParser.expression_return();
		retval.start = this.input.LT(1);
		ManchesterOWLSyntaxTree root_0 = null;
		Token OR33 = null;
		Token OPEN_PARENTHESYS36 = null;
		Token CLOSED_PARENTHESYS38 = null;
		MOWLParser.conjunction_return conjunction32 = null;
		MOWLParser.conjunction_return conjunction34 = null;
		MOWLParser.complexPropertyExpression_return complexPropertyExpression35 = null;
		MOWLParser.expression_return expression37 = null;
		ManchesterOWLSyntaxTree OR33_tree = null;
		ManchesterOWLSyntaxTree OPEN_PARENTHESYS36_tree = null;
		ManchesterOWLSyntaxTree CLOSED_PARENTHESYS38_tree = null;
		RewriteRuleTokenStream stream_CLOSED_PARENTHESYS = new RewriteRuleTokenStream(this.adaptor,
				"token CLOSED_PARENTHESYS");
		RewriteRuleTokenStream stream_OR = new RewriteRuleTokenStream(this.adaptor, "token OR");
		RewriteRuleTokenStream stream_OPEN_PARENTHESYS = new RewriteRuleTokenStream(this.adaptor,
				"token OPEN_PARENTHESYS");
		RewriteRuleSubtreeStream stream_expression = new RewriteRuleSubtreeStream(this.adaptor,
				"rule expression");
		RewriteRuleSubtreeStream stream_conjunction = new RewriteRuleSubtreeStream(this.adaptor,
				"rule conjunction");
		RewriteRuleSubtreeStream stream_complexPropertyExpression = new RewriteRuleSubtreeStream(
				this.adaptor, "rule complexPropertyExpression");
		try {
			// /Users/luigi/Documents/workspace/Parsers/src/MOWLParser.g:114:11:
			// ( ( options {backtrack=true; } : | conjunction ( OR conjunction
			// )* -> ^( DISJUNCTION ( conjunction )+ ) |
			// complexPropertyExpression -> ^( complexPropertyExpression ) |
			// OPEN_PARENTHESYS expression CLOSED_PARENTHESYS -> ^( expression )
			// ) )
			// /Users/luigi/Documents/workspace/Parsers/src/MOWLParser.g:115:5:
			// ( options {backtrack=true; } : | conjunction ( OR conjunction )*
			// -> ^( DISJUNCTION ( conjunction )+ ) | complexPropertyExpression
			// -> ^( complexPropertyExpression ) | OPEN_PARENTHESYS expression
			// CLOSED_PARENTHESYS -> ^( expression ) )
			{
				// /Users/luigi/Documents/workspace/Parsers/src/MOWLParser.g:115:5:
				// ( options {backtrack=true; } : | conjunction ( OR conjunction
				// )* -> ^( DISJUNCTION ( conjunction )+ ) |
				// complexPropertyExpression -> ^( complexPropertyExpression ) |
				// OPEN_PARENTHESYS expression CLOSED_PARENTHESYS -> ^(
				// expression ) )
				int alt7 = 4;
				alt7 = this.dfa7.predict(this.input);
				switch (alt7) {
				case 1:
					// /Users/luigi/Documents/workspace/Parsers/src/MOWLParser.g:117:4:
				{
				}
					break;
				case 2:
					// /Users/luigi/Documents/workspace/Parsers/src/MOWLParser.g:117:6:
					// conjunction ( OR conjunction )*
				{
					this.pushFollow(FOLLOW_conjunction_in_expression1087);
					conjunction32 = this.conjunction();
					this.state._fsp--;
					if (this.state.failed) {
						return retval;
					}
					if (this.state.backtracking == 0) {
						stream_conjunction.add(conjunction32.getTree());
					}
					// /Users/luigi/Documents/workspace/Parsers/src/MOWLParser.g:117:18:
					// ( OR conjunction )*
					loop6: do {
						int alt6 = 2;
						int LA6_0 = this.input.LA(1);
						if (LA6_0 == OR) {
							alt6 = 1;
						}
						switch (alt6) {
						case 1:
							// /Users/luigi/Documents/workspace/Parsers/src/MOWLParser.g:117:19:
							// OR conjunction
						{
							OR33 = (Token) this.match(this.input, OR, FOLLOW_OR_in_expression1090);
							if (this.state.failed) {
								return retval;
							}
							if (this.state.backtracking == 0) {
								stream_OR.add(OR33);
							}
							this.pushFollow(FOLLOW_conjunction_in_expression1092);
							conjunction34 = this.conjunction();
							this.state._fsp--;
							if (this.state.failed) {
								return retval;
							}
							if (this.state.backtracking == 0) {
								stream_conjunction.add(conjunction34.getTree());
							}
						}
							break;
						default:
							break loop6;
						}
					} while (true);
					// AST REWRITE
					// elements: conjunction
					// token labels:
					// rule labels: retval
					// token list labels:
					// rule list labels:
					// wildcard labels:
					if (this.state.backtracking == 0) {
						retval.tree = root_0;
						RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(
								this.adaptor, "rule retval", retval != null ? retval.tree : null);
						root_0 = (ManchesterOWLSyntaxTree) this.adaptor.nil();
						// 117:36: -> ^( DISJUNCTION ( conjunction )+ )
						{
							// /Users/luigi/Documents/workspace/Parsers/src/MOWLParser.g:117:39:
							// ^( DISJUNCTION ( conjunction )+ )
							{
								ManchesterOWLSyntaxTree root_1 = (ManchesterOWLSyntaxTree) this.adaptor.nil();
								root_1 = (ManchesterOWLSyntaxTree) this.adaptor.becomeRoot(
										this.adaptor.create(DISJUNCTION, "DISJUNCTION"),
										root_1);
								if (!stream_conjunction.hasNext()) {
									throw new RewriteEarlyExitException();
								}
								while (stream_conjunction.hasNext()) {
									this.adaptor.addChild(root_1, stream_conjunction.nextTree());
								}
								stream_conjunction.reset();
								this.adaptor.addChild(root_0, root_1);
							}
						}
						retval.tree = root_0;
					}
				}
					break;
				case 3:
					// /Users/luigi/Documents/workspace/Parsers/src/MOWLParser.g:118:6:
					// complexPropertyExpression
				{
					this.pushFollow(FOLLOW_complexPropertyExpression_in_expression1111);
					complexPropertyExpression35 = this.complexPropertyExpression();
					this.state._fsp--;
					if (this.state.failed) {
						return retval;
					}
					if (this.state.backtracking == 0) {
						stream_complexPropertyExpression.add(complexPropertyExpression35.getTree());
					}
					// AST REWRITE
					// elements: complexPropertyExpression
					// token labels:
					// rule labels: retval
					// token list labels:
					// rule list labels:
					// wildcard labels:
					if (this.state.backtracking == 0) {
						retval.tree = root_0;
						RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(
								this.adaptor, "rule retval", retval != null ? retval.tree : null);
						root_0 = (ManchesterOWLSyntaxTree) this.adaptor.nil();
						// 118:32: -> ^( complexPropertyExpression )
						{
							// /Users/luigi/Documents/workspace/Parsers/src/MOWLParser.g:118:35:
							// ^( complexPropertyExpression )
							{
								ManchesterOWLSyntaxTree root_1 = (ManchesterOWLSyntaxTree) this.adaptor.nil();
								root_1 = (ManchesterOWLSyntaxTree) this.adaptor.becomeRoot(
										stream_complexPropertyExpression.nextNode(),
										root_1);
								this.adaptor.addChild(root_0, root_1);
							}
						}
						retval.tree = root_0;
					}
				}
					break;
				case 4:
					// /Users/luigi/Documents/workspace/Parsers/src/MOWLParser.g:119:6:
					// OPEN_PARENTHESYS expression CLOSED_PARENTHESYS
				{
					OPEN_PARENTHESYS36 = (Token) this.match(
							this.input,
							OPEN_PARENTHESYS,
							FOLLOW_OPEN_PARENTHESYS_in_expression1124);
					if (this.state.failed) {
						return retval;
					}
					if (this.state.backtracking == 0) {
						stream_OPEN_PARENTHESYS.add(OPEN_PARENTHESYS36);
					}
					this.pushFollow(FOLLOW_expression_in_expression1126);
					expression37 = this.expression();
					this.state._fsp--;
					if (this.state.failed) {
						return retval;
					}
					if (this.state.backtracking == 0) {
						stream_expression.add(expression37.getTree());
					}
					CLOSED_PARENTHESYS38 = (Token) this.match(
							this.input,
							CLOSED_PARENTHESYS,
							FOLLOW_CLOSED_PARENTHESYS_in_expression1128);
					if (this.state.failed) {
						return retval;
					}
					if (this.state.backtracking == 0) {
						stream_CLOSED_PARENTHESYS.add(CLOSED_PARENTHESYS38);
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
						root_0 = (ManchesterOWLSyntaxTree) this.adaptor.nil();
						// 119:53: -> ^( expression )
						{
							// /Users/luigi/Documents/workspace/Parsers/src/MOWLParser.g:119:56:
							// ^( expression )
							{
								ManchesterOWLSyntaxTree root_1 = (ManchesterOWLSyntaxTree) this.adaptor.nil();
								root_1 = (ManchesterOWLSyntaxTree) this.adaptor.becomeRoot(
										stream_expression.nextNode(),
										root_1);
								this.adaptor.addChild(root_0, root_1);
							}
						}
						retval.tree = root_0;
					}
				}
					break;
				}
			}
			retval.stop = this.input.LT(-1);
			if (this.state.backtracking == 0) {
				retval.tree = (ManchesterOWLSyntaxTree) this.adaptor.rulePostProcessing(root_0);
				this.adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		} catch (RecognitionException e) {
			throw e;
		} catch (RewriteEmptyStreamException e) {
			throw e;
		} finally {
		}
		return retval;
	}

	// $ANTLR end "expression"
	public static class conjunction_return extends ParserRuleReturnScope {
		ManchesterOWLSyntaxTree tree;

		@Override
		public Object getTree() {
			return this.tree;
		}
	};

	// $ANTLR start "conjunction"
	// /Users/luigi/Documents/workspace/Parsers/src/MOWLParser.g:126:1:
	// conjunction : unary ( AND unary )* -> ^( CONJUNCTION ( unary )+ ) ;
	public final MOWLParser.conjunction_return conjunction() throws RecognitionException {
		MOWLParser.conjunction_return retval = new MOWLParser.conjunction_return();
		retval.start = this.input.LT(1);
		ManchesterOWLSyntaxTree root_0 = null;
		Token AND40 = null;
		MOWLParser.unary_return unary39 = null;
		MOWLParser.unary_return unary41 = null;
		ManchesterOWLSyntaxTree AND40_tree = null;
		RewriteRuleTokenStream stream_AND = new RewriteRuleTokenStream(this.adaptor, "token AND");
		RewriteRuleSubtreeStream stream_unary = new RewriteRuleSubtreeStream(this.adaptor,
				"rule unary");
		try {
			// /Users/luigi/Documents/workspace/Parsers/src/MOWLParser.g:126:13:
			// ( unary ( AND unary )* -> ^( CONJUNCTION ( unary )+ ) )
			// /Users/luigi/Documents/workspace/Parsers/src/MOWLParser.g:127:5:
			// unary ( AND unary )*
			{
				this.pushFollow(FOLLOW_unary_in_conjunction1160);
				unary39 = this.unary();
				this.state._fsp--;
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_unary.add(unary39.getTree());
				}
				// /Users/luigi/Documents/workspace/Parsers/src/MOWLParser.g:127:11:
				// ( AND unary )*
				loop8: do {
					int alt8 = 2;
					int LA8_0 = this.input.LA(1);
					if (LA8_0 == AND) {
						alt8 = 1;
					}
					switch (alt8) {
					case 1:
						// /Users/luigi/Documents/workspace/Parsers/src/MOWLParser.g:127:12:
						// AND unary
					{
						AND40 = (Token) this.match(this.input, AND, FOLLOW_AND_in_conjunction1163);
						if (this.state.failed) {
							return retval;
						}
						if (this.state.backtracking == 0) {
							stream_AND.add(AND40);
						}
						this.pushFollow(FOLLOW_unary_in_conjunction1165);
						unary41 = this.unary();
						this.state._fsp--;
						if (this.state.failed) {
							return retval;
						}
						if (this.state.backtracking == 0) {
							stream_unary.add(unary41.getTree());
						}
					}
						break;
					default:
						break loop8;
					}
				} while (true);
				// AST REWRITE
				// elements: unary
				// token labels:
				// rule labels: retval
				// token list labels:
				// rule list labels:
				// wildcard labels:
				if (this.state.backtracking == 0) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(
							this.adaptor, "rule retval", retval != null ? retval.tree : null);
					root_0 = (ManchesterOWLSyntaxTree) this.adaptor.nil();
					// 127:24: -> ^( CONJUNCTION ( unary )+ )
					{
						// /Users/luigi/Documents/workspace/Parsers/src/MOWLParser.g:127:27:
						// ^( CONJUNCTION ( unary )+ )
						{
							ManchesterOWLSyntaxTree root_1 = (ManchesterOWLSyntaxTree) this.adaptor.nil();
							root_1 = (ManchesterOWLSyntaxTree) this.adaptor.becomeRoot(
									this.adaptor.create(CONJUNCTION, "CONJUNCTION"),
									root_1);
							if (!stream_unary.hasNext()) {
								throw new RewriteEarlyExitException();
							}
							while (stream_unary.hasNext()) {
								this.adaptor.addChild(root_1, stream_unary.nextTree());
							}
							stream_unary.reset();
							this.adaptor.addChild(root_0, root_1);
						}
					}
					retval.tree = root_0;
				}
			}
			retval.stop = this.input.LT(-1);
			if (this.state.backtracking == 0) {
				retval.tree = (ManchesterOWLSyntaxTree) this.adaptor.rulePostProcessing(root_0);
				this.adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		} catch (RecognitionException e) {
			throw e;
		} catch (RewriteEmptyStreamException e) {
			throw e;
		} finally {
		}
		return retval;
	}

	// $ANTLR end "conjunction"
	public static class complexPropertyExpression_return extends ParserRuleReturnScope {
		ManchesterOWLSyntaxTree tree;

		@Override
		public Object getTree() {
			return this.tree;
		}
	};

	// $ANTLR start "complexPropertyExpression"
	// /Users/luigi/Documents/workspace/Parsers/src/MOWLParser.g:130:1:
	// complexPropertyExpression : ( INVERSE OPEN_PARENTHESYS
	// complexPropertyExpression CLOSED_PARENTHESYS -> ^(
	// INVERSE_OBJECT_PROPERTY_EXPRESSION complexPropertyExpression ) | INVERSE
	// OPEN_PARENTHESYS atomic CLOSED_PARENTHESYS -> ^(
	// INVERSE_OBJECT_PROPERTY_EXPRESSION atomic ) );
	public final MOWLParser.complexPropertyExpression_return complexPropertyExpression()
			throws RecognitionException {
		MOWLParser.complexPropertyExpression_return retval = new MOWLParser.complexPropertyExpression_return();
		retval.start = this.input.LT(1);
		ManchesterOWLSyntaxTree root_0 = null;
		Token INVERSE42 = null;
		Token OPEN_PARENTHESYS43 = null;
		Token CLOSED_PARENTHESYS45 = null;
		Token INVERSE46 = null;
		Token OPEN_PARENTHESYS47 = null;
		Token CLOSED_PARENTHESYS49 = null;
		MOWLParser.complexPropertyExpression_return complexPropertyExpression44 = null;
		MOWLParser.atomic_return atomic48 = null;
		ManchesterOWLSyntaxTree INVERSE42_tree = null;
		ManchesterOWLSyntaxTree OPEN_PARENTHESYS43_tree = null;
		ManchesterOWLSyntaxTree CLOSED_PARENTHESYS45_tree = null;
		ManchesterOWLSyntaxTree INVERSE46_tree = null;
		ManchesterOWLSyntaxTree OPEN_PARENTHESYS47_tree = null;
		ManchesterOWLSyntaxTree CLOSED_PARENTHESYS49_tree = null;
		RewriteRuleTokenStream stream_INVERSE = new RewriteRuleTokenStream(this.adaptor,
				"token INVERSE");
		RewriteRuleTokenStream stream_CLOSED_PARENTHESYS = new RewriteRuleTokenStream(this.adaptor,
				"token CLOSED_PARENTHESYS");
		RewriteRuleTokenStream stream_OPEN_PARENTHESYS = new RewriteRuleTokenStream(this.adaptor,
				"token OPEN_PARENTHESYS");
		RewriteRuleSubtreeStream stream_complexPropertyExpression = new RewriteRuleSubtreeStream(
				this.adaptor, "rule complexPropertyExpression");
		RewriteRuleSubtreeStream stream_atomic = new RewriteRuleSubtreeStream(this.adaptor,
				"rule atomic");
		try {
			// /Users/luigi/Documents/workspace/Parsers/src/MOWLParser.g:130:26:
			// ( INVERSE OPEN_PARENTHESYS complexPropertyExpression
			// CLOSED_PARENTHESYS -> ^( INVERSE_OBJECT_PROPERTY_EXPRESSION
			// complexPropertyExpression ) | INVERSE OPEN_PARENTHESYS atomic
			// CLOSED_PARENTHESYS -> ^( INVERSE_OBJECT_PROPERTY_EXPRESSION
			// atomic ) )
			int alt9 = 2;
			int LA9_0 = this.input.LA(1);
			if (LA9_0 == INVERSE) {
				int LA9_1 = this.input.LA(2);
				if (LA9_1 == OPEN_PARENTHESYS) {
					int LA9_2 = this.input.LA(3);
					if (LA9_2 >= IDENTIFIER && LA9_2 <= ENTITY_REFERENCE) {
						alt9 = 2;
					} else if (LA9_2 == INVERSE) {
						alt9 = 1;
					} else {
						if (this.state.backtracking > 0) {
							this.state.failed = true;
							return retval;
						}
						NoViableAltException nvae = new NoViableAltException("", 9, 2, this.input);
						throw nvae;
					}
				} else {
					if (this.state.backtracking > 0) {
						this.state.failed = true;
						return retval;
					}
					NoViableAltException nvae = new NoViableAltException("", 9, 1, this.input);
					throw nvae;
				}
			} else {
				if (this.state.backtracking > 0) {
					this.state.failed = true;
					return retval;
				}
				NoViableAltException nvae = new NoViableAltException("", 9, 0, this.input);
				throw nvae;
			}
			switch (alt9) {
			case 1:
				// /Users/luigi/Documents/workspace/Parsers/src/MOWLParser.g:131:2:
				// INVERSE OPEN_PARENTHESYS complexPropertyExpression
				// CLOSED_PARENTHESYS
			{
				INVERSE42 = (Token) this.match(
						this.input,
						INVERSE,
						FOLLOW_INVERSE_in_complexPropertyExpression1186);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_INVERSE.add(INVERSE42);
				}
				OPEN_PARENTHESYS43 = (Token) this.match(
						this.input,
						OPEN_PARENTHESYS,
						FOLLOW_OPEN_PARENTHESYS_in_complexPropertyExpression1188);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_OPEN_PARENTHESYS.add(OPEN_PARENTHESYS43);
				}
				this.pushFollow(FOLLOW_complexPropertyExpression_in_complexPropertyExpression1190);
				complexPropertyExpression44 = this.complexPropertyExpression();
				this.state._fsp--;
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_complexPropertyExpression.add(complexPropertyExpression44.getTree());
				}
				CLOSED_PARENTHESYS45 = (Token) this.match(
						this.input,
						CLOSED_PARENTHESYS,
						FOLLOW_CLOSED_PARENTHESYS_in_complexPropertyExpression1192);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_CLOSED_PARENTHESYS.add(CLOSED_PARENTHESYS45);
				}
				// AST REWRITE
				// elements: complexPropertyExpression
				// token labels:
				// rule labels: retval
				// token list labels:
				// rule list labels:
				// wildcard labels:
				if (this.state.backtracking == 0) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(
							this.adaptor, "rule retval", retval != null ? retval.tree : null);
					root_0 = (ManchesterOWLSyntaxTree) this.adaptor.nil();
					// 131:72: -> ^( INVERSE_OBJECT_PROPERTY_EXPRESSION
					// complexPropertyExpression )
					{
						// /Users/luigi/Documents/workspace/Parsers/src/MOWLParser.g:131:75:
						// ^( INVERSE_OBJECT_PROPERTY_EXPRESSION
						// complexPropertyExpression )
						{
							ManchesterOWLSyntaxTree root_1 = (ManchesterOWLSyntaxTree) this.adaptor.nil();
							root_1 = (ManchesterOWLSyntaxTree) this.adaptor.becomeRoot(
									this.adaptor.create(
											INVERSE_OBJECT_PROPERTY_EXPRESSION,
											"INVERSE_OBJECT_PROPERTY_EXPRESSION"),
									root_1);
							this.adaptor.addChild(
									root_1,
									stream_complexPropertyExpression.nextTree());
							this.adaptor.addChild(root_0, root_1);
						}
					}
					retval.tree = root_0;
				}
			}
				break;
			case 2:
				// /Users/luigi/Documents/workspace/Parsers/src/MOWLParser.g:132:4:
				// INVERSE OPEN_PARENTHESYS atomic CLOSED_PARENTHESYS
			{
				INVERSE46 = (Token) this.match(
						this.input,
						INVERSE,
						FOLLOW_INVERSE_in_complexPropertyExpression1205);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_INVERSE.add(INVERSE46);
				}
				OPEN_PARENTHESYS47 = (Token) this.match(
						this.input,
						OPEN_PARENTHESYS,
						FOLLOW_OPEN_PARENTHESYS_in_complexPropertyExpression1207);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_OPEN_PARENTHESYS.add(OPEN_PARENTHESYS47);
				}
				this.pushFollow(FOLLOW_atomic_in_complexPropertyExpression1209);
				atomic48 = this.atomic();
				this.state._fsp--;
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_atomic.add(atomic48.getTree());
				}
				CLOSED_PARENTHESYS49 = (Token) this.match(
						this.input,
						CLOSED_PARENTHESYS,
						FOLLOW_CLOSED_PARENTHESYS_in_complexPropertyExpression1211);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_CLOSED_PARENTHESYS.add(CLOSED_PARENTHESYS49);
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
					root_0 = (ManchesterOWLSyntaxTree) this.adaptor.nil();
					// 132:54: -> ^( INVERSE_OBJECT_PROPERTY_EXPRESSION atomic )
					{
						// /Users/luigi/Documents/workspace/Parsers/src/MOWLParser.g:132:57:
						// ^( INVERSE_OBJECT_PROPERTY_EXPRESSION atomic )
						{
							ManchesterOWLSyntaxTree root_1 = (ManchesterOWLSyntaxTree) this.adaptor.nil();
							root_1 = (ManchesterOWLSyntaxTree) this.adaptor.becomeRoot(
									this.adaptor.create(
											INVERSE_OBJECT_PROPERTY_EXPRESSION,
											"INVERSE_OBJECT_PROPERTY_EXPRESSION"),
									root_1);
							this.adaptor.addChild(root_1, stream_atomic.nextTree());
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
				retval.tree = (ManchesterOWLSyntaxTree) this.adaptor.rulePostProcessing(root_0);
				this.adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		} catch (RecognitionException e) {
			throw e;
		} catch (RewriteEmptyStreamException e) {
			throw e;
		} finally {
		}
		return retval;
	}

	// $ANTLR end "complexPropertyExpression"
	public static class unary_return extends ParserRuleReturnScope {
		ManchesterOWLSyntaxTree tree;

		@Override
		public Object getTree() {
			return this.tree;
		}
	};

	// $ANTLR start "unary"
	// /Users/luigi/Documents/workspace/Parsers/src/MOWLParser.g:135:1: unary
	// options {backtrack=true; } : ( atomic | head= propertyExpression (
	// COMPOSITION rest+= propertyExpression )+ -> ^( PROPERTY_CHAIN $head
	// $rest) | NOT OPEN_PARENTHESYS expression CLOSED_PARENTHESYS -> ^(
	// NEGATED_EXPRESSION expression ) | NOT atomic -> ^( NEGATED_EXPRESSION
	// atomic ) | qualifiedRestriction -> ^( qualifiedRestriction ) | constant
	// );
	public final MOWLParser.unary_return unary() throws RecognitionException {
		MOWLParser.unary_return retval = new MOWLParser.unary_return();
		retval.start = this.input.LT(1);
		ManchesterOWLSyntaxTree root_0 = null;
		Token COMPOSITION51 = null;
		Token NOT52 = null;
		Token OPEN_PARENTHESYS53 = null;
		Token CLOSED_PARENTHESYS55 = null;
		Token NOT56 = null;
		List list_rest = null;
		MOWLParser.propertyExpression_return head = null;
		MOWLParser.atomic_return atomic50 = null;
		MOWLParser.expression_return expression54 = null;
		MOWLParser.atomic_return atomic57 = null;
		MOWLParser.qualifiedRestriction_return qualifiedRestriction58 = null;
		MOWLParser.constant_return constant59 = null;
		RuleReturnScope rest = null;
		ManchesterOWLSyntaxTree COMPOSITION51_tree = null;
		ManchesterOWLSyntaxTree NOT52_tree = null;
		ManchesterOWLSyntaxTree OPEN_PARENTHESYS53_tree = null;
		ManchesterOWLSyntaxTree CLOSED_PARENTHESYS55_tree = null;
		ManchesterOWLSyntaxTree NOT56_tree = null;
		RewriteRuleTokenStream stream_NOT = new RewriteRuleTokenStream(this.adaptor, "token NOT");
		RewriteRuleTokenStream stream_CLOSED_PARENTHESYS = new RewriteRuleTokenStream(this.adaptor,
				"token CLOSED_PARENTHESYS");
		RewriteRuleTokenStream stream_COMPOSITION = new RewriteRuleTokenStream(this.adaptor,
				"token COMPOSITION");
		RewriteRuleTokenStream stream_OPEN_PARENTHESYS = new RewriteRuleTokenStream(this.adaptor,
				"token OPEN_PARENTHESYS");
		RewriteRuleSubtreeStream stream_expression = new RewriteRuleSubtreeStream(this.adaptor,
				"rule expression");
		RewriteRuleSubtreeStream stream_qualifiedRestriction = new RewriteRuleSubtreeStream(
				this.adaptor, "rule qualifiedRestriction");
		RewriteRuleSubtreeStream stream_propertyExpression = new RewriteRuleSubtreeStream(
				this.adaptor, "rule propertyExpression");
		RewriteRuleSubtreeStream stream_atomic = new RewriteRuleSubtreeStream(this.adaptor,
				"rule atomic");
		try {
			// /Users/luigi/Documents/workspace/Parsers/src/MOWLParser.g:135:34:
			// ( atomic | head= propertyExpression ( COMPOSITION rest+=
			// propertyExpression )+ -> ^( PROPERTY_CHAIN $head $rest) | NOT
			// OPEN_PARENTHESYS expression CLOSED_PARENTHESYS -> ^(
			// NEGATED_EXPRESSION expression ) | NOT atomic -> ^(
			// NEGATED_EXPRESSION atomic ) | qualifiedRestriction -> ^(
			// qualifiedRestriction ) | constant )
			int alt11 = 6;
			alt11 = this.dfa11.predict(this.input);
			switch (alt11) {
			case 1:
				// /Users/luigi/Documents/workspace/Parsers/src/MOWLParser.g:136:3:
				// atomic
			{
				root_0 = (ManchesterOWLSyntaxTree) this.adaptor.nil();
				this.pushFollow(FOLLOW_atomic_in_unary1240);
				atomic50 = this.atomic();
				this.state._fsp--;
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					this.adaptor.addChild(root_0, atomic50.getTree());
				}
			}
				break;
			case 2:
				// /Users/luigi/Documents/workspace/Parsers/src/MOWLParser.g:137:5:
				// head= propertyExpression ( COMPOSITION rest+=
				// propertyExpression )+
			{
				this.pushFollow(FOLLOW_propertyExpression_in_unary1250);
				head = this.propertyExpression();
				this.state._fsp--;
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_propertyExpression.add(head.getTree());
				}
				// /Users/luigi/Documents/workspace/Parsers/src/MOWLParser.g:137:31:
				// ( COMPOSITION rest+= propertyExpression )+
				int cnt10 = 0;
				loop10: do {
					int alt10 = 2;
					int LA10_0 = this.input.LA(1);
					if (LA10_0 == COMPOSITION) {
						alt10 = 1;
					}
					switch (alt10) {
					case 1:
						// /Users/luigi/Documents/workspace/Parsers/src/MOWLParser.g:137:32:
						// COMPOSITION rest+= propertyExpression
					{
						COMPOSITION51 = (Token) this.match(
								this.input,
								COMPOSITION,
								FOLLOW_COMPOSITION_in_unary1253);
						if (this.state.failed) {
							return retval;
						}
						if (this.state.backtracking == 0) {
							stream_COMPOSITION.add(COMPOSITION51);
						}
						this.pushFollow(FOLLOW_propertyExpression_in_unary1257);
						rest = this.propertyExpression();
						this.state._fsp--;
						if (this.state.failed) {
							return retval;
						}
						if (this.state.backtracking == 0) {
							stream_propertyExpression.add(rest.getTree());
						}
						if (list_rest == null) {
							list_rest = new ArrayList();
						}
						list_rest.add(rest.getTree());
					}
						break;
					default:
						if (cnt10 >= 1) {
							break loop10;
						}
						if (this.state.backtracking > 0) {
							this.state.failed = true;
							return retval;
						}
						EarlyExitException eee = new EarlyExitException(10, this.input);
						throw eee;
					}
					cnt10++;
				} while (true);
				// AST REWRITE
				// elements: rest, head
				// token labels:
				// rule labels: retval, head
				// token list labels:
				// rule list labels: rest
				// wildcard labels:
				if (this.state.backtracking == 0) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(
							this.adaptor, "rule retval", retval != null ? retval.tree : null);
					RewriteRuleSubtreeStream stream_head = new RewriteRuleSubtreeStream(
							this.adaptor, "rule head", head != null ? head.tree : null);
					RewriteRuleSubtreeStream stream_rest = new RewriteRuleSubtreeStream(
							this.adaptor, "token rest", list_rest);
					root_0 = (ManchesterOWLSyntaxTree) this.adaptor.nil();
					// 137:72: -> ^( PROPERTY_CHAIN $head $rest)
					{
						// /Users/luigi/Documents/workspace/Parsers/src/MOWLParser.g:137:75:
						// ^( PROPERTY_CHAIN $head $rest)
						{
							ManchesterOWLSyntaxTree root_1 = (ManchesterOWLSyntaxTree) this.adaptor.nil();
							root_1 = (ManchesterOWLSyntaxTree) this.adaptor.becomeRoot(
									this.adaptor.create(PROPERTY_CHAIN, "PROPERTY_CHAIN"),
									root_1);
							this.adaptor.addChild(root_1, stream_head.nextTree());
							this.adaptor.addChild(root_1, stream_rest.nextTree());
							this.adaptor.addChild(root_0, root_1);
						}
					}
					retval.tree = root_0;
				}
			}
				break;
			case 3:
				// /Users/luigi/Documents/workspace/Parsers/src/MOWLParser.g:138:5:
				// NOT OPEN_PARENTHESYS expression CLOSED_PARENTHESYS
			{
				NOT52 = (Token) this.match(this.input, NOT, FOLLOW_NOT_in_unary1279);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_NOT.add(NOT52);
				}
				OPEN_PARENTHESYS53 = (Token) this.match(
						this.input,
						OPEN_PARENTHESYS,
						FOLLOW_OPEN_PARENTHESYS_in_unary1281);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_OPEN_PARENTHESYS.add(OPEN_PARENTHESYS53);
				}
				this.pushFollow(FOLLOW_expression_in_unary1283);
				expression54 = this.expression();
				this.state._fsp--;
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_expression.add(expression54.getTree());
				}
				CLOSED_PARENTHESYS55 = (Token) this.match(
						this.input,
						CLOSED_PARENTHESYS,
						FOLLOW_CLOSED_PARENTHESYS_in_unary1285);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_CLOSED_PARENTHESYS.add(CLOSED_PARENTHESYS55);
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
					root_0 = (ManchesterOWLSyntaxTree) this.adaptor.nil();
					// 138:56: -> ^( NEGATED_EXPRESSION expression )
					{
						// /Users/luigi/Documents/workspace/Parsers/src/MOWLParser.g:138:59:
						// ^( NEGATED_EXPRESSION expression )
						{
							ManchesterOWLSyntaxTree root_1 = (ManchesterOWLSyntaxTree) this.adaptor.nil();
							root_1 = (ManchesterOWLSyntaxTree) this.adaptor.becomeRoot(
									this.adaptor.create(NEGATED_EXPRESSION, "NEGATED_EXPRESSION"),
									root_1);
							this.adaptor.addChild(root_1, stream_expression.nextTree());
							this.adaptor.addChild(root_0, root_1);
						}
					}
					retval.tree = root_0;
				}
			}
				break;
			case 4:
				// /Users/luigi/Documents/workspace/Parsers/src/MOWLParser.g:139:5:
				// NOT atomic
			{
				NOT56 = (Token) this.match(this.input, NOT, FOLLOW_NOT_in_unary1299);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_NOT.add(NOT56);
				}
				this.pushFollow(FOLLOW_atomic_in_unary1301);
				atomic57 = this.atomic();
				this.state._fsp--;
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_atomic.add(atomic57.getTree());
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
					root_0 = (ManchesterOWLSyntaxTree) this.adaptor.nil();
					// 139:16: -> ^( NEGATED_EXPRESSION atomic )
					{
						// /Users/luigi/Documents/workspace/Parsers/src/MOWLParser.g:139:19:
						// ^( NEGATED_EXPRESSION atomic )
						{
							ManchesterOWLSyntaxTree root_1 = (ManchesterOWLSyntaxTree) this.adaptor.nil();
							root_1 = (ManchesterOWLSyntaxTree) this.adaptor.becomeRoot(
									this.adaptor.create(NEGATED_EXPRESSION, "NEGATED_EXPRESSION"),
									root_1);
							this.adaptor.addChild(root_1, stream_atomic.nextTree());
							this.adaptor.addChild(root_0, root_1);
						}
					}
					retval.tree = root_0;
				}
			}
				break;
			case 5:
				// /Users/luigi/Documents/workspace/Parsers/src/MOWLParser.g:140:5:
				// qualifiedRestriction
			{
				this.pushFollow(FOLLOW_qualifiedRestriction_in_unary1324);
				qualifiedRestriction58 = this.qualifiedRestriction();
				this.state._fsp--;
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_qualifiedRestriction.add(qualifiedRestriction58.getTree());
				}
				// AST REWRITE
				// elements: qualifiedRestriction
				// token labels:
				// rule labels: retval
				// token list labels:
				// rule list labels:
				// wildcard labels:
				if (this.state.backtracking == 0) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(
							this.adaptor, "rule retval", retval != null ? retval.tree : null);
					root_0 = (ManchesterOWLSyntaxTree) this.adaptor.nil();
					// 140:26: -> ^( qualifiedRestriction )
					{
						// /Users/luigi/Documents/workspace/Parsers/src/MOWLParser.g:140:29:
						// ^( qualifiedRestriction )
						{
							ManchesterOWLSyntaxTree root_1 = (ManchesterOWLSyntaxTree) this.adaptor.nil();
							root_1 = (ManchesterOWLSyntaxTree) this.adaptor.becomeRoot(
									stream_qualifiedRestriction.nextNode(),
									root_1);
							this.adaptor.addChild(root_0, root_1);
						}
					}
					retval.tree = root_0;
				}
			}
				break;
			case 6:
				// /Users/luigi/Documents/workspace/Parsers/src/MOWLParser.g:141:5:
				// constant
			{
				root_0 = (ManchesterOWLSyntaxTree) this.adaptor.nil();
				this.pushFollow(FOLLOW_constant_in_unary1336);
				constant59 = this.constant();
				this.state._fsp--;
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					this.adaptor.addChild(root_0, constant59.getTree());
				}
			}
				break;
			}
			retval.stop = this.input.LT(-1);
			if (this.state.backtracking == 0) {
				retval.tree = (ManchesterOWLSyntaxTree) this.adaptor.rulePostProcessing(root_0);
				this.adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		} catch (RecognitionException e) {
			throw e;
		} catch (RewriteEmptyStreamException e) {
			throw e;
		} finally {
		}
		return retval;
	}

	// $ANTLR end "unary"
	public static class atomic_return extends ParserRuleReturnScope {
		ManchesterOWLSyntaxTree tree;

		@Override
		public Object getTree() {
			return this.tree;
		}
	};

	// $ANTLR start "atomic"
	// /Users/luigi/Documents/workspace/Parsers/src/MOWLParser.g:144:1: atomic :
	// ( IDENTIFIER | ENTITY_REFERENCE -> ^( ENTITY_REFERENCE ) );
	public final MOWLParser.atomic_return atomic() throws RecognitionException {
		MOWLParser.atomic_return retval = new MOWLParser.atomic_return();
		retval.start = this.input.LT(1);
		ManchesterOWLSyntaxTree root_0 = null;
		Token IDENTIFIER60 = null;
		Token ENTITY_REFERENCE61 = null;
		ManchesterOWLSyntaxTree IDENTIFIER60_tree = null;
		ManchesterOWLSyntaxTree ENTITY_REFERENCE61_tree = null;
		RewriteRuleTokenStream stream_ENTITY_REFERENCE = new RewriteRuleTokenStream(this.adaptor,
				"token ENTITY_REFERENCE");
		try {
			// /Users/luigi/Documents/workspace/Parsers/src/MOWLParser.g:144:8:
			// ( IDENTIFIER | ENTITY_REFERENCE -> ^( ENTITY_REFERENCE ) )
			int alt12 = 2;
			int LA12_0 = this.input.LA(1);
			if (LA12_0 == IDENTIFIER) {
				alt12 = 1;
			} else if (LA12_0 == ENTITY_REFERENCE) {
				alt12 = 2;
			} else {
				if (this.state.backtracking > 0) {
					this.state.failed = true;
					return retval;
				}
				NoViableAltException nvae = new NoViableAltException("", 12, 0, this.input);
				throw nvae;
			}
			switch (alt12) {
			case 1:
				// /Users/luigi/Documents/workspace/Parsers/src/MOWLParser.g:145:3:
				// IDENTIFIER
			{
				root_0 = (ManchesterOWLSyntaxTree) this.adaptor.nil();
				IDENTIFIER60 = (Token) this.match(
						this.input,
						IDENTIFIER,
						FOLLOW_IDENTIFIER_in_atomic1350);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					IDENTIFIER60_tree = (ManchesterOWLSyntaxTree) this.adaptor.create(IDENTIFIER60);
					this.adaptor.addChild(root_0, IDENTIFIER60_tree);
				}
			}
				break;
			case 2:
				// /Users/luigi/Documents/workspace/Parsers/src/MOWLParser.g:146:5:
				// ENTITY_REFERENCE
			{
				ENTITY_REFERENCE61 = (Token) this.match(
						this.input,
						ENTITY_REFERENCE,
						FOLLOW_ENTITY_REFERENCE_in_atomic1357);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_ENTITY_REFERENCE.add(ENTITY_REFERENCE61);
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
					root_0 = (ManchesterOWLSyntaxTree) this.adaptor.nil();
					// 146:22: -> ^( ENTITY_REFERENCE )
					{
						// /Users/luigi/Documents/workspace/Parsers/src/MOWLParser.g:146:25:
						// ^( ENTITY_REFERENCE )
						{
							ManchesterOWLSyntaxTree root_1 = (ManchesterOWLSyntaxTree) this.adaptor.nil();
							root_1 = (ManchesterOWLSyntaxTree) this.adaptor.becomeRoot(
									stream_ENTITY_REFERENCE.nextNode(),
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
				retval.tree = (ManchesterOWLSyntaxTree) this.adaptor.rulePostProcessing(root_0);
				this.adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		} catch (RecognitionException e) {
			throw e;
		} catch (RewriteEmptyStreamException e) {
			throw e;
		} finally {
		}
		return retval;
	}

	// $ANTLR end "atomic"
	public static class qualifiedRestriction_return extends ParserRuleReturnScope {
		ManchesterOWLSyntaxTree tree;

		@Override
		public Object getTree() {
			return this.tree;
		}
	};

	// $ANTLR start "qualifiedRestriction"
	// /Users/luigi/Documents/workspace/Parsers/src/MOWLParser.g:149:1:
	// qualifiedRestriction : ( options {backtrack=true; } : propertyExpression
	// SOME expression -> ^( SOME_RESTRICTION propertyExpression expression ) |
	// propertyExpression ONLY expression -> ^( ALL_RESTRICTION
	// propertyExpression expression ) | cardinalityRestriction -> ^(
	// cardinalityRestriction ) | oneOf -> ^( oneOf ) | valueRestriction -> ^(
	// valueRestriction ) ) ;
	public final MOWLParser.qualifiedRestriction_return qualifiedRestriction()
			throws RecognitionException {
		MOWLParser.qualifiedRestriction_return retval = new MOWLParser.qualifiedRestriction_return();
		retval.start = this.input.LT(1);
		ManchesterOWLSyntaxTree root_0 = null;
		Token SOME63 = null;
		Token ONLY66 = null;
		MOWLParser.propertyExpression_return propertyExpression62 = null;
		MOWLParser.expression_return expression64 = null;
		MOWLParser.propertyExpression_return propertyExpression65 = null;
		MOWLParser.expression_return expression67 = null;
		MOWLParser.cardinalityRestriction_return cardinalityRestriction68 = null;
		MOWLParser.oneOf_return oneOf69 = null;
		MOWLParser.valueRestriction_return valueRestriction70 = null;
		ManchesterOWLSyntaxTree SOME63_tree = null;
		ManchesterOWLSyntaxTree ONLY66_tree = null;
		RewriteRuleTokenStream stream_ONLY = new RewriteRuleTokenStream(this.adaptor, "token ONLY");
		RewriteRuleTokenStream stream_SOME = new RewriteRuleTokenStream(this.adaptor, "token SOME");
		RewriteRuleSubtreeStream stream_expression = new RewriteRuleSubtreeStream(this.adaptor,
				"rule expression");
		RewriteRuleSubtreeStream stream_oneOf = new RewriteRuleSubtreeStream(this.adaptor,
				"rule oneOf");
		RewriteRuleSubtreeStream stream_propertyExpression = new RewriteRuleSubtreeStream(
				this.adaptor, "rule propertyExpression");
		RewriteRuleSubtreeStream stream_cardinalityRestriction = new RewriteRuleSubtreeStream(
				this.adaptor, "rule cardinalityRestriction");
		RewriteRuleSubtreeStream stream_valueRestriction = new RewriteRuleSubtreeStream(
				this.adaptor, "rule valueRestriction");
		try {
			// /Users/luigi/Documents/workspace/Parsers/src/MOWLParser.g:149:21:
			// ( ( options {backtrack=true; } : propertyExpression SOME
			// expression -> ^( SOME_RESTRICTION propertyExpression expression )
			// | propertyExpression ONLY expression -> ^( ALL_RESTRICTION
			// propertyExpression expression ) | cardinalityRestriction -> ^(
			// cardinalityRestriction ) | oneOf -> ^( oneOf ) | valueRestriction
			// -> ^( valueRestriction ) ) )
			// /Users/luigi/Documents/workspace/Parsers/src/MOWLParser.g:150:9:
			// ( options {backtrack=true; } : propertyExpression SOME expression
			// -> ^( SOME_RESTRICTION propertyExpression expression ) |
			// propertyExpression ONLY expression -> ^( ALL_RESTRICTION
			// propertyExpression expression ) | cardinalityRestriction -> ^(
			// cardinalityRestriction ) | oneOf -> ^( oneOf ) | valueRestriction
			// -> ^( valueRestriction ) )
			{
				// /Users/luigi/Documents/workspace/Parsers/src/MOWLParser.g:150:9:
				// ( options {backtrack=true; } : propertyExpression SOME
				// expression -> ^( SOME_RESTRICTION propertyExpression
				// expression ) | propertyExpression ONLY expression -> ^(
				// ALL_RESTRICTION propertyExpression expression ) |
				// cardinalityRestriction -> ^( cardinalityRestriction ) | oneOf
				// -> ^( oneOf ) | valueRestriction -> ^( valueRestriction ) )
				int alt13 = 5;
				switch (this.input.LA(1)) {
				case IDENTIFIER: {
					int LA13_1 = this.input.LA(2);
					if (this.synpred11_MOWLParser()) {
						alt13 = 1;
					} else if (this.synpred12_MOWLParser()) {
						alt13 = 2;
					} else if (this.synpred13_MOWLParser()) {
						alt13 = 3;
					} else if (true) {
						alt13 = 5;
					} else {
						if (this.state.backtracking > 0) {
							this.state.failed = true;
							return retval;
						}
						NoViableAltException nvae = new NoViableAltException("", 13, 1, this.input);
						throw nvae;
					}
				}
					break;
				case ENTITY_REFERENCE: {
					int LA13_2 = this.input.LA(2);
					if (this.synpred11_MOWLParser()) {
						alt13 = 1;
					} else if (this.synpred12_MOWLParser()) {
						alt13 = 2;
					} else if (this.synpred13_MOWLParser()) {
						alt13 = 3;
					} else if (true) {
						alt13 = 5;
					} else {
						if (this.state.backtracking > 0) {
							this.state.failed = true;
							return retval;
						}
						NoViableAltException nvae = new NoViableAltException("", 13, 2, this.input);
						throw nvae;
					}
				}
					break;
				case INVERSE: {
					int LA13_3 = this.input.LA(2);
					if (this.synpred11_MOWLParser()) {
						alt13 = 1;
					} else if (this.synpred12_MOWLParser()) {
						alt13 = 2;
					} else if (this.synpred13_MOWLParser()) {
						alt13 = 3;
					} else if (true) {
						alt13 = 5;
					} else {
						if (this.state.backtracking > 0) {
							this.state.failed = true;
							return retval;
						}
						NoViableAltException nvae = new NoViableAltException("", 13, 3, this.input);
						throw nvae;
					}
				}
					break;
				case OPEN_CURLY_BRACES: {
					alt13 = 4;
				}
					break;
				default:
					if (this.state.backtracking > 0) {
						this.state.failed = true;
						return retval;
					}
					NoViableAltException nvae = new NoViableAltException("", 13, 0, this.input);
					throw nvae;
				}
				switch (alt13) {
				case 1:
					// /Users/luigi/Documents/workspace/Parsers/src/MOWLParser.g:152:7:
					// propertyExpression SOME expression
				{
					this.pushFollow(FOLLOW_propertyExpression_in_qualifiedRestriction1409);
					propertyExpression62 = this.propertyExpression();
					this.state._fsp--;
					if (this.state.failed) {
						return retval;
					}
					if (this.state.backtracking == 0) {
						stream_propertyExpression.add(propertyExpression62.getTree());
					}
					SOME63 = (Token) this.match(
							this.input,
							SOME,
							FOLLOW_SOME_in_qualifiedRestriction1412);
					if (this.state.failed) {
						return retval;
					}
					if (this.state.backtracking == 0) {
						stream_SOME.add(SOME63);
					}
					this.pushFollow(FOLLOW_expression_in_qualifiedRestriction1416);
					expression64 = this.expression();
					this.state._fsp--;
					if (this.state.failed) {
						return retval;
					}
					if (this.state.backtracking == 0) {
						stream_expression.add(expression64.getTree());
					}
					// AST REWRITE
					// elements: propertyExpression, expression
					// token labels:
					// rule labels: retval
					// token list labels:
					// rule list labels:
					// wildcard labels:
					if (this.state.backtracking == 0) {
						retval.tree = root_0;
						RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(
								this.adaptor, "rule retval", retval != null ? retval.tree : null);
						root_0 = (ManchesterOWLSyntaxTree) this.adaptor.nil();
						// 152:46: -> ^( SOME_RESTRICTION propertyExpression
						// expression )
						{
							// /Users/luigi/Documents/workspace/Parsers/src/MOWLParser.g:152:49:
							// ^( SOME_RESTRICTION propertyExpression expression
							// )
							{
								ManchesterOWLSyntaxTree root_1 = (ManchesterOWLSyntaxTree) this.adaptor.nil();
								root_1 = (ManchesterOWLSyntaxTree) this.adaptor.becomeRoot(
										this.adaptor.create(SOME_RESTRICTION, "SOME_RESTRICTION"),
										root_1);
								this.adaptor.addChild(root_1, stream_propertyExpression.nextTree());
								this.adaptor.addChild(root_1, stream_expression.nextTree());
								this.adaptor.addChild(root_0, root_1);
							}
						}
						retval.tree = root_0;
					}
				}
					break;
				case 2:
					// /Users/luigi/Documents/workspace/Parsers/src/MOWLParser.g:153:7:
					// propertyExpression ONLY expression
				{
					this.pushFollow(FOLLOW_propertyExpression_in_qualifiedRestriction1445);
					propertyExpression65 = this.propertyExpression();
					this.state._fsp--;
					if (this.state.failed) {
						return retval;
					}
					if (this.state.backtracking == 0) {
						stream_propertyExpression.add(propertyExpression65.getTree());
					}
					ONLY66 = (Token) this.match(
							this.input,
							ONLY,
							FOLLOW_ONLY_in_qualifiedRestriction1447);
					if (this.state.failed) {
						return retval;
					}
					if (this.state.backtracking == 0) {
						stream_ONLY.add(ONLY66);
					}
					this.pushFollow(FOLLOW_expression_in_qualifiedRestriction1450);
					expression67 = this.expression();
					this.state._fsp--;
					if (this.state.failed) {
						return retval;
					}
					if (this.state.backtracking == 0) {
						stream_expression.add(expression67.getTree());
					}
					// AST REWRITE
					// elements: expression, propertyExpression
					// token labels:
					// rule labels: retval
					// token list labels:
					// rule list labels:
					// wildcard labels:
					if (this.state.backtracking == 0) {
						retval.tree = root_0;
						RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(
								this.adaptor, "rule retval", retval != null ? retval.tree : null);
						root_0 = (ManchesterOWLSyntaxTree) this.adaptor.nil();
						// 153:44: -> ^( ALL_RESTRICTION propertyExpression
						// expression )
						{
							// /Users/luigi/Documents/workspace/Parsers/src/MOWLParser.g:153:47:
							// ^( ALL_RESTRICTION propertyExpression expression
							// )
							{
								ManchesterOWLSyntaxTree root_1 = (ManchesterOWLSyntaxTree) this.adaptor.nil();
								root_1 = (ManchesterOWLSyntaxTree) this.adaptor.becomeRoot(
										this.adaptor.create(ALL_RESTRICTION, "ALL_RESTRICTION"),
										root_1);
								this.adaptor.addChild(root_1, stream_propertyExpression.nextTree());
								this.adaptor.addChild(root_1, stream_expression.nextTree());
								this.adaptor.addChild(root_0, root_1);
							}
						}
						retval.tree = root_0;
					}
				}
					break;
				case 3:
					// /Users/luigi/Documents/workspace/Parsers/src/MOWLParser.g:154:7:
					// cardinalityRestriction
				{
					this.pushFollow(FOLLOW_cardinalityRestriction_in_qualifiedRestriction1469);
					cardinalityRestriction68 = this.cardinalityRestriction();
					this.state._fsp--;
					if (this.state.failed) {
						return retval;
					}
					if (this.state.backtracking == 0) {
						stream_cardinalityRestriction.add(cardinalityRestriction68.getTree());
					}
					// AST REWRITE
					// elements: cardinalityRestriction
					// token labels:
					// rule labels: retval
					// token list labels:
					// rule list labels:
					// wildcard labels:
					if (this.state.backtracking == 0) {
						retval.tree = root_0;
						RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(
								this.adaptor, "rule retval", retval != null ? retval.tree : null);
						root_0 = (ManchesterOWLSyntaxTree) this.adaptor.nil();
						// 154:30: -> ^( cardinalityRestriction )
						{
							// /Users/luigi/Documents/workspace/Parsers/src/MOWLParser.g:154:33:
							// ^( cardinalityRestriction )
							{
								ManchesterOWLSyntaxTree root_1 = (ManchesterOWLSyntaxTree) this.adaptor.nil();
								root_1 = (ManchesterOWLSyntaxTree) this.adaptor.becomeRoot(
										stream_cardinalityRestriction.nextNode(),
										root_1);
								this.adaptor.addChild(root_0, root_1);
							}
						}
						retval.tree = root_0;
					}
				}
					break;
				case 4:
					// /Users/luigi/Documents/workspace/Parsers/src/MOWLParser.g:155:7:
					// oneOf
				{
					this.pushFollow(FOLLOW_oneOf_in_qualifiedRestriction1483);
					oneOf69 = this.oneOf();
					this.state._fsp--;
					if (this.state.failed) {
						return retval;
					}
					if (this.state.backtracking == 0) {
						stream_oneOf.add(oneOf69.getTree());
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
								this.adaptor, "rule retval", retval != null ? retval.tree : null);
						root_0 = (ManchesterOWLSyntaxTree) this.adaptor.nil();
						// 155:13: -> ^( oneOf )
						{
							// /Users/luigi/Documents/workspace/Parsers/src/MOWLParser.g:155:16:
							// ^( oneOf )
							{
								ManchesterOWLSyntaxTree root_1 = (ManchesterOWLSyntaxTree) this.adaptor.nil();
								root_1 = (ManchesterOWLSyntaxTree) this.adaptor.becomeRoot(
										stream_oneOf.nextNode(),
										root_1);
								this.adaptor.addChild(root_0, root_1);
							}
						}
						retval.tree = root_0;
					}
				}
					break;
				case 5:
					// /Users/luigi/Documents/workspace/Parsers/src/MOWLParser.g:156:7:
					// valueRestriction
				{
					this.pushFollow(FOLLOW_valueRestriction_in_qualifiedRestriction1497);
					valueRestriction70 = this.valueRestriction();
					this.state._fsp--;
					if (this.state.failed) {
						return retval;
					}
					if (this.state.backtracking == 0) {
						stream_valueRestriction.add(valueRestriction70.getTree());
					}
					// AST REWRITE
					// elements: valueRestriction
					// token labels:
					// rule labels: retval
					// token list labels:
					// rule list labels:
					// wildcard labels:
					if (this.state.backtracking == 0) {
						retval.tree = root_0;
						RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(
								this.adaptor, "rule retval", retval != null ? retval.tree : null);
						root_0 = (ManchesterOWLSyntaxTree) this.adaptor.nil();
						// 156:24: -> ^( valueRestriction )
						{
							// /Users/luigi/Documents/workspace/Parsers/src/MOWLParser.g:156:27:
							// ^( valueRestriction )
							{
								ManchesterOWLSyntaxTree root_1 = (ManchesterOWLSyntaxTree) this.adaptor.nil();
								root_1 = (ManchesterOWLSyntaxTree) this.adaptor.becomeRoot(
										stream_valueRestriction.nextNode(),
										root_1);
								this.adaptor.addChild(root_0, root_1);
							}
						}
						retval.tree = root_0;
					}
				}
					break;
				}
			}
			retval.stop = this.input.LT(-1);
			if (this.state.backtracking == 0) {
				retval.tree = (ManchesterOWLSyntaxTree) this.adaptor.rulePostProcessing(root_0);
				this.adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		} catch (RecognitionException e) {
			throw e;
		} catch (RewriteEmptyStreamException e) {
			throw e;
		} finally {
		}
		return retval;
	}

	// $ANTLR end "qualifiedRestriction"
	public static class propertyExpression_return extends ParserRuleReturnScope {
		ManchesterOWLSyntaxTree tree;

		@Override
		public Object getTree() {
			return this.tree;
		}
	};

	// $ANTLR start "propertyExpression"
	// /Users/luigi/Documents/workspace/Parsers/src/MOWLParser.g:160:1:
	// propertyExpression : ( atomic -> ^( atomic ) | complexPropertyExpression
	// -> ^( complexPropertyExpression ) );
	public final MOWLParser.propertyExpression_return propertyExpression()
			throws RecognitionException {
		MOWLParser.propertyExpression_return retval = new MOWLParser.propertyExpression_return();
		retval.start = this.input.LT(1);
		ManchesterOWLSyntaxTree root_0 = null;
		MOWLParser.atomic_return atomic71 = null;
		MOWLParser.complexPropertyExpression_return complexPropertyExpression72 = null;
		RewriteRuleSubtreeStream stream_complexPropertyExpression = new RewriteRuleSubtreeStream(
				this.adaptor, "rule complexPropertyExpression");
		RewriteRuleSubtreeStream stream_atomic = new RewriteRuleSubtreeStream(this.adaptor,
				"rule atomic");
		try {
			// /Users/luigi/Documents/workspace/Parsers/src/MOWLParser.g:160:21:
			// ( atomic -> ^( atomic ) | complexPropertyExpression -> ^(
			// complexPropertyExpression ) )
			int alt14 = 2;
			int LA14_0 = this.input.LA(1);
			if (LA14_0 >= IDENTIFIER && LA14_0 <= ENTITY_REFERENCE) {
				alt14 = 1;
			} else if (LA14_0 == INVERSE) {
				alt14 = 2;
			} else {
				if (this.state.backtracking > 0) {
					this.state.failed = true;
					return retval;
				}
				NoViableAltException nvae = new NoViableAltException("", 14, 0, this.input);
				throw nvae;
			}
			switch (alt14) {
			case 1:
				// /Users/luigi/Documents/workspace/Parsers/src/MOWLParser.g:161:7:
				// atomic
			{
				this.pushFollow(FOLLOW_atomic_in_propertyExpression1529);
				atomic71 = this.atomic();
				this.state._fsp--;
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_atomic.add(atomic71.getTree());
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
					root_0 = (ManchesterOWLSyntaxTree) this.adaptor.nil();
					// 161:14: -> ^( atomic )
					{
						// /Users/luigi/Documents/workspace/Parsers/src/MOWLParser.g:161:17:
						// ^( atomic )
						{
							ManchesterOWLSyntaxTree root_1 = (ManchesterOWLSyntaxTree) this.adaptor.nil();
							root_1 = (ManchesterOWLSyntaxTree) this.adaptor.becomeRoot(
									stream_atomic.nextNode(),
									root_1);
							this.adaptor.addChild(root_0, root_1);
						}
					}
					retval.tree = root_0;
				}
			}
				break;
			case 2:
				// /Users/luigi/Documents/workspace/Parsers/src/MOWLParser.g:162:7:
				// complexPropertyExpression
			{
				this.pushFollow(FOLLOW_complexPropertyExpression_in_propertyExpression1543);
				complexPropertyExpression72 = this.complexPropertyExpression();
				this.state._fsp--;
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_complexPropertyExpression.add(complexPropertyExpression72.getTree());
				}
				// AST REWRITE
				// elements: complexPropertyExpression
				// token labels:
				// rule labels: retval
				// token list labels:
				// rule list labels:
				// wildcard labels:
				if (this.state.backtracking == 0) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(
							this.adaptor, "rule retval", retval != null ? retval.tree : null);
					root_0 = (ManchesterOWLSyntaxTree) this.adaptor.nil();
					// 162:33: -> ^( complexPropertyExpression )
					{
						// /Users/luigi/Documents/workspace/Parsers/src/MOWLParser.g:162:36:
						// ^( complexPropertyExpression )
						{
							ManchesterOWLSyntaxTree root_1 = (ManchesterOWLSyntaxTree) this.adaptor.nil();
							root_1 = (ManchesterOWLSyntaxTree) this.adaptor.becomeRoot(
									stream_complexPropertyExpression.nextNode(),
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
				retval.tree = (ManchesterOWLSyntaxTree) this.adaptor.rulePostProcessing(root_0);
				this.adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		} catch (RecognitionException e) {
			throw e;
		} catch (RewriteEmptyStreamException e) {
			throw e;
		} finally {
		}
		return retval;
	}

	// $ANTLR end "propertyExpression"
	public static class cardinalityRestriction_return extends ParserRuleReturnScope {
		ManchesterOWLSyntaxTree tree;

		@Override
		public Object getTree() {
			return this.tree;
		}
	};

	// $ANTLR start "cardinalityRestriction"
	// /Users/luigi/Documents/workspace/Parsers/src/MOWLParser.g:165:1:
	// cardinalityRestriction options {backtrack=true; } : propertyExpression
	// restrictionKind INTEGER ( unary )? -> ^( CARDINALITY_RESTRICTION
	// restrictionKind INTEGER propertyExpression ( unary )? ) ;
	public final MOWLParser.cardinalityRestriction_return cardinalityRestriction()
			throws RecognitionException {
		MOWLParser.cardinalityRestriction_return retval = new MOWLParser.cardinalityRestriction_return();
		retval.start = this.input.LT(1);
		ManchesterOWLSyntaxTree root_0 = null;
		Token INTEGER75 = null;
		MOWLParser.propertyExpression_return propertyExpression73 = null;
		MOWLParser.restrictionKind_return restrictionKind74 = null;
		MOWLParser.unary_return unary76 = null;
		ManchesterOWLSyntaxTree INTEGER75_tree = null;
		RewriteRuleTokenStream stream_INTEGER = new RewriteRuleTokenStream(this.adaptor,
				"token INTEGER");
		RewriteRuleSubtreeStream stream_unary = new RewriteRuleSubtreeStream(this.adaptor,
				"rule unary");
		RewriteRuleSubtreeStream stream_propertyExpression = new RewriteRuleSubtreeStream(
				this.adaptor, "rule propertyExpression");
		RewriteRuleSubtreeStream stream_restrictionKind = new RewriteRuleSubtreeStream(
				this.adaptor, "rule restrictionKind");
		try {
			// /Users/luigi/Documents/workspace/Parsers/src/MOWLParser.g:166:28:
			// ( propertyExpression restrictionKind INTEGER ( unary )? -> ^(
			// CARDINALITY_RESTRICTION restrictionKind INTEGER
			// propertyExpression ( unary )? ) )
			// /Users/luigi/Documents/workspace/Parsers/src/MOWLParser.g:167:2:
			// propertyExpression restrictionKind INTEGER ( unary )?
			{
				this.pushFollow(FOLLOW_propertyExpression_in_cardinalityRestriction1585);
				propertyExpression73 = this.propertyExpression();
				this.state._fsp--;
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_propertyExpression.add(propertyExpression73.getTree());
				}
				this.pushFollow(FOLLOW_restrictionKind_in_cardinalityRestriction1588);
				restrictionKind74 = this.restrictionKind();
				this.state._fsp--;
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_restrictionKind.add(restrictionKind74.getTree());
				}
				INTEGER75 = (Token) this.match(
						this.input,
						INTEGER,
						FOLLOW_INTEGER_in_cardinalityRestriction1590);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_INTEGER.add(INTEGER75);
				}
				// /Users/luigi/Documents/workspace/Parsers/src/MOWLParser.g:167:46:
				// ( unary )?
				int alt15 = 2;
				int LA15_0 = this.input.LA(1);
				if (LA15_0 == OPEN_CURLY_BRACES || LA15_0 == NOT || LA15_0 == INVERSE
						|| LA15_0 == DBLQUOTE || LA15_0 >= IDENTIFIER && LA15_0 <= ENTITY_REFERENCE) {
					alt15 = 1;
				}
				switch (alt15) {
				case 1:
					// /Users/luigi/Documents/workspace/Parsers/src/MOWLParser.g:167:46:
					// unary
				{
					this.pushFollow(FOLLOW_unary_in_cardinalityRestriction1592);
					unary76 = this.unary();
					this.state._fsp--;
					if (this.state.failed) {
						return retval;
					}
					if (this.state.backtracking == 0) {
						stream_unary.add(unary76.getTree());
					}
				}
					break;
				}
				// AST REWRITE
				// elements: unary, INTEGER, propertyExpression, restrictionKind
				// token labels:
				// rule labels: retval
				// token list labels:
				// rule list labels:
				// wildcard labels:
				if (this.state.backtracking == 0) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(
							this.adaptor, "rule retval", retval != null ? retval.tree : null);
					root_0 = (ManchesterOWLSyntaxTree) this.adaptor.nil();
					// 167:53: -> ^( CARDINALITY_RESTRICTION restrictionKind
					// INTEGER propertyExpression ( unary )? )
					{
						// /Users/luigi/Documents/workspace/Parsers/src/MOWLParser.g:167:56:
						// ^( CARDINALITY_RESTRICTION restrictionKind INTEGER
						// propertyExpression ( unary )? )
						{
							ManchesterOWLSyntaxTree root_1 = (ManchesterOWLSyntaxTree) this.adaptor.nil();
							root_1 = (ManchesterOWLSyntaxTree) this.adaptor.becomeRoot(
									this.adaptor.create(
											CARDINALITY_RESTRICTION,
											"CARDINALITY_RESTRICTION"),
									root_1);
							this.adaptor.addChild(root_1, stream_restrictionKind.nextTree());
							this.adaptor.addChild(root_1, stream_INTEGER.nextNode());
							this.adaptor.addChild(root_1, stream_propertyExpression.nextTree());
							// /Users/luigi/Documents/workspace/Parsers/src/MOWLParser.g:167:127:
							// ( unary )?
							if (stream_unary.hasNext()) {
								this.adaptor.addChild(root_1, stream_unary.nextTree());
							}
							stream_unary.reset();
							this.adaptor.addChild(root_0, root_1);
						}
					}
					retval.tree = root_0;
				}
			}
			retval.stop = this.input.LT(-1);
			if (this.state.backtracking == 0) {
				retval.tree = (ManchesterOWLSyntaxTree) this.adaptor.rulePostProcessing(root_0);
				this.adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		} catch (RecognitionException e) {
			throw e;
		} catch (RewriteEmptyStreamException e) {
			throw e;
		} finally {
		}
		return retval;
	}

	// $ANTLR end "cardinalityRestriction"
	public static class restrictionKind_return extends ParserRuleReturnScope {
		ManchesterOWLSyntaxTree tree;

		@Override
		public Object getTree() {
			return this.tree;
		}
	};

	// $ANTLR start "restrictionKind"
	// /Users/luigi/Documents/workspace/Parsers/src/MOWLParser.g:170:1:
	// restrictionKind : ( MIN -> ^( MIN ) | MAX -> ^( MAX ) | EXACTLY -> ^(
	// EXACTLY ) );
	public final MOWLParser.restrictionKind_return restrictionKind() throws RecognitionException {
		MOWLParser.restrictionKind_return retval = new MOWLParser.restrictionKind_return();
		retval.start = this.input.LT(1);
		ManchesterOWLSyntaxTree root_0 = null;
		Token MIN77 = null;
		Token MAX78 = null;
		Token EXACTLY79 = null;
		ManchesterOWLSyntaxTree MIN77_tree = null;
		ManchesterOWLSyntaxTree MAX78_tree = null;
		ManchesterOWLSyntaxTree EXACTLY79_tree = null;
		RewriteRuleTokenStream stream_MAX = new RewriteRuleTokenStream(this.adaptor, "token MAX");
		RewriteRuleTokenStream stream_MIN = new RewriteRuleTokenStream(this.adaptor, "token MIN");
		RewriteRuleTokenStream stream_EXACTLY = new RewriteRuleTokenStream(this.adaptor,
				"token EXACTLY");
		try {
			// /Users/luigi/Documents/workspace/Parsers/src/MOWLParser.g:170:17:
			// ( MIN -> ^( MIN ) | MAX -> ^( MAX ) | EXACTLY -> ^( EXACTLY ) )
			int alt16 = 3;
			switch (this.input.LA(1)) {
			case MIN: {
				alt16 = 1;
			}
				break;
			case MAX: {
				alt16 = 2;
			}
				break;
			case EXACTLY: {
				alt16 = 3;
			}
				break;
			default:
				if (this.state.backtracking > 0) {
					this.state.failed = true;
					return retval;
				}
				NoViableAltException nvae = new NoViableAltException("", 16, 0, this.input);
				throw nvae;
			}
			switch (alt16) {
			case 1:
				// /Users/luigi/Documents/workspace/Parsers/src/MOWLParser.g:171:5:
				// MIN
			{
				MIN77 = (Token) this.match(this.input, MIN, FOLLOW_MIN_in_restrictionKind1625);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_MIN.add(MIN77);
				}
				// AST REWRITE
				// elements: MIN
				// token labels:
				// rule labels: retval
				// token list labels:
				// rule list labels:
				// wildcard labels:
				if (this.state.backtracking == 0) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(
							this.adaptor, "rule retval", retval != null ? retval.tree : null);
					root_0 = (ManchesterOWLSyntaxTree) this.adaptor.nil();
					// 171:9: -> ^( MIN )
					{
						// /Users/luigi/Documents/workspace/Parsers/src/MOWLParser.g:171:12:
						// ^( MIN )
						{
							ManchesterOWLSyntaxTree root_1 = (ManchesterOWLSyntaxTree) this.adaptor.nil();
							root_1 = (ManchesterOWLSyntaxTree) this.adaptor.becomeRoot(
									stream_MIN.nextNode(),
									root_1);
							this.adaptor.addChild(root_0, root_1);
						}
					}
					retval.tree = root_0;
				}
			}
				break;
			case 2:
				// /Users/luigi/Documents/workspace/Parsers/src/MOWLParser.g:172:7:
				// MAX
			{
				MAX78 = (Token) this.match(this.input, MAX, FOLLOW_MAX_in_restrictionKind1639);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_MAX.add(MAX78);
				}
				// AST REWRITE
				// elements: MAX
				// token labels:
				// rule labels: retval
				// token list labels:
				// rule list labels:
				// wildcard labels:
				if (this.state.backtracking == 0) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(
							this.adaptor, "rule retval", retval != null ? retval.tree : null);
					root_0 = (ManchesterOWLSyntaxTree) this.adaptor.nil();
					// 172:11: -> ^( MAX )
					{
						// /Users/luigi/Documents/workspace/Parsers/src/MOWLParser.g:172:14:
						// ^( MAX )
						{
							ManchesterOWLSyntaxTree root_1 = (ManchesterOWLSyntaxTree) this.adaptor.nil();
							root_1 = (ManchesterOWLSyntaxTree) this.adaptor.becomeRoot(
									stream_MAX.nextNode(),
									root_1);
							this.adaptor.addChild(root_0, root_1);
						}
					}
					retval.tree = root_0;
				}
			}
				break;
			case 3:
				// /Users/luigi/Documents/workspace/Parsers/src/MOWLParser.g:173:7:
				// EXACTLY
			{
				EXACTLY79 = (Token) this.match(
						this.input,
						EXACTLY,
						FOLLOW_EXACTLY_in_restrictionKind1653);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_EXACTLY.add(EXACTLY79);
				}
				// AST REWRITE
				// elements: EXACTLY
				// token labels:
				// rule labels: retval
				// token list labels:
				// rule list labels:
				// wildcard labels:
				if (this.state.backtracking == 0) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(
							this.adaptor, "rule retval", retval != null ? retval.tree : null);
					root_0 = (ManchesterOWLSyntaxTree) this.adaptor.nil();
					// 173:15: -> ^( EXACTLY )
					{
						// /Users/luigi/Documents/workspace/Parsers/src/MOWLParser.g:173:18:
						// ^( EXACTLY )
						{
							ManchesterOWLSyntaxTree root_1 = (ManchesterOWLSyntaxTree) this.adaptor.nil();
							root_1 = (ManchesterOWLSyntaxTree) this.adaptor.becomeRoot(
									stream_EXACTLY.nextNode(),
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
				retval.tree = (ManchesterOWLSyntaxTree) this.adaptor.rulePostProcessing(root_0);
				this.adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		} catch (RecognitionException e) {
			throw e;
		} catch (RewriteEmptyStreamException e) {
			throw e;
		} finally {
		}
		return retval;
	}

	// $ANTLR end "restrictionKind"
	public static class oneOf_return extends ParserRuleReturnScope {
		ManchesterOWLSyntaxTree tree;

		@Override
		public Object getTree() {
			return this.tree;
		}
	};

	// $ANTLR start "oneOf"
	// /Users/luigi/Documents/workspace/Parsers/src/MOWLParser.g:180:1: oneOf :
	// OPEN_CURLY_BRACES IDENTIFIER ( COMMA IDENTIFIER )* CLOSED_CURLY_BRACES ->
	// ^( ONE_OF ( IDENTIFIER )+ ) ;
	public final MOWLParser.oneOf_return oneOf() throws RecognitionException {
		MOWLParser.oneOf_return retval = new MOWLParser.oneOf_return();
		retval.start = this.input.LT(1);
		ManchesterOWLSyntaxTree root_0 = null;
		Token OPEN_CURLY_BRACES80 = null;
		Token IDENTIFIER81 = null;
		Token COMMA82 = null;
		Token IDENTIFIER83 = null;
		Token CLOSED_CURLY_BRACES84 = null;
		ManchesterOWLSyntaxTree OPEN_CURLY_BRACES80_tree = null;
		ManchesterOWLSyntaxTree IDENTIFIER81_tree = null;
		ManchesterOWLSyntaxTree COMMA82_tree = null;
		ManchesterOWLSyntaxTree IDENTIFIER83_tree = null;
		ManchesterOWLSyntaxTree CLOSED_CURLY_BRACES84_tree = null;
		RewriteRuleTokenStream stream_COMMA = new RewriteRuleTokenStream(this.adaptor,
				"token COMMA");
		RewriteRuleTokenStream stream_CLOSED_CURLY_BRACES = new RewriteRuleTokenStream(
				this.adaptor, "token CLOSED_CURLY_BRACES");
		RewriteRuleTokenStream stream_IDENTIFIER = new RewriteRuleTokenStream(this.adaptor,
				"token IDENTIFIER");
		RewriteRuleTokenStream stream_OPEN_CURLY_BRACES = new RewriteRuleTokenStream(this.adaptor,
				"token OPEN_CURLY_BRACES");
		try {
			// /Users/luigi/Documents/workspace/Parsers/src/MOWLParser.g:180:7:
			// ( OPEN_CURLY_BRACES IDENTIFIER ( COMMA IDENTIFIER )*
			// CLOSED_CURLY_BRACES -> ^( ONE_OF ( IDENTIFIER )+ ) )
			// /Users/luigi/Documents/workspace/Parsers/src/MOWLParser.g:181:3:
			// OPEN_CURLY_BRACES IDENTIFIER ( COMMA IDENTIFIER )*
			// CLOSED_CURLY_BRACES
			{
				OPEN_CURLY_BRACES80 = (Token) this.match(
						this.input,
						OPEN_CURLY_BRACES,
						FOLLOW_OPEN_CURLY_BRACES_in_oneOf1678);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_OPEN_CURLY_BRACES.add(OPEN_CURLY_BRACES80);
				}
				IDENTIFIER81 = (Token) this.match(
						this.input,
						IDENTIFIER,
						FOLLOW_IDENTIFIER_in_oneOf1680);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_IDENTIFIER.add(IDENTIFIER81);
				}
				// /Users/luigi/Documents/workspace/Parsers/src/MOWLParser.g:181:32:
				// ( COMMA IDENTIFIER )*
				loop17: do {
					int alt17 = 2;
					int LA17_0 = this.input.LA(1);
					if (LA17_0 == COMMA) {
						alt17 = 1;
					}
					switch (alt17) {
					case 1:
						// /Users/luigi/Documents/workspace/Parsers/src/MOWLParser.g:181:33:
						// COMMA IDENTIFIER
					{
						COMMA82 = (Token) this.match(this.input, COMMA, FOLLOW_COMMA_in_oneOf1683);
						if (this.state.failed) {
							return retval;
						}
						if (this.state.backtracking == 0) {
							stream_COMMA.add(COMMA82);
						}
						IDENTIFIER83 = (Token) this.match(
								this.input,
								IDENTIFIER,
								FOLLOW_IDENTIFIER_in_oneOf1685);
						if (this.state.failed) {
							return retval;
						}
						if (this.state.backtracking == 0) {
							stream_IDENTIFIER.add(IDENTIFIER83);
						}
					}
						break;
					default:
						break loop17;
					}
				} while (true);
				CLOSED_CURLY_BRACES84 = (Token) this.match(
						this.input,
						CLOSED_CURLY_BRACES,
						FOLLOW_CLOSED_CURLY_BRACES_in_oneOf1689);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_CLOSED_CURLY_BRACES.add(CLOSED_CURLY_BRACES84);
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
					root_0 = (ManchesterOWLSyntaxTree) this.adaptor.nil();
					// 181:72: -> ^( ONE_OF ( IDENTIFIER )+ )
					{
						// /Users/luigi/Documents/workspace/Parsers/src/MOWLParser.g:181:75:
						// ^( ONE_OF ( IDENTIFIER )+ )
						{
							ManchesterOWLSyntaxTree root_1 = (ManchesterOWLSyntaxTree) this.adaptor.nil();
							root_1 = (ManchesterOWLSyntaxTree) this.adaptor.becomeRoot(
									this.adaptor.create(ONE_OF, "ONE_OF"),
									root_1);
							if (!stream_IDENTIFIER.hasNext()) {
								throw new RewriteEarlyExitException();
							}
							while (stream_IDENTIFIER.hasNext()) {
								this.adaptor.addChild(root_1, stream_IDENTIFIER.nextNode());
							}
							stream_IDENTIFIER.reset();
							this.adaptor.addChild(root_0, root_1);
						}
					}
					retval.tree = root_0;
				}
			}
			retval.stop = this.input.LT(-1);
			if (this.state.backtracking == 0) {
				retval.tree = (ManchesterOWLSyntaxTree) this.adaptor.rulePostProcessing(root_0);
				this.adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		} catch (RecognitionException e) {
			throw e;
		} catch (RewriteEmptyStreamException e) {
			throw e;
		} finally {
		}
		return retval;
	}

	// $ANTLR end "oneOf"
	public static class valueRestriction_return extends ParserRuleReturnScope {
		ManchesterOWLSyntaxTree tree;

		@Override
		public Object getTree() {
			return this.tree;
		}
	};

	// $ANTLR start "valueRestriction"
	// /Users/luigi/Documents/workspace/Parsers/src/MOWLParser.g:184:1:
	// valueRestriction : propertyExpression VALUE value -> ^( VALUE_RESTRICTION
	// propertyExpression value ) ;
	public final MOWLParser.valueRestriction_return valueRestriction() throws RecognitionException {
		MOWLParser.valueRestriction_return retval = new MOWLParser.valueRestriction_return();
		retval.start = this.input.LT(1);
		ManchesterOWLSyntaxTree root_0 = null;
		Token VALUE86 = null;
		MOWLParser.propertyExpression_return propertyExpression85 = null;
		MOWLParser.value_return value87 = null;
		ManchesterOWLSyntaxTree VALUE86_tree = null;
		RewriteRuleTokenStream stream_VALUE = new RewriteRuleTokenStream(this.adaptor,
				"token VALUE");
		RewriteRuleSubtreeStream stream_propertyExpression = new RewriteRuleSubtreeStream(
				this.adaptor, "rule propertyExpression");
		RewriteRuleSubtreeStream stream_value = new RewriteRuleSubtreeStream(this.adaptor,
				"rule value");
		try {
			// /Users/luigi/Documents/workspace/Parsers/src/MOWLParser.g:184:18:
			// ( propertyExpression VALUE value -> ^( VALUE_RESTRICTION
			// propertyExpression value ) )
			// /Users/luigi/Documents/workspace/Parsers/src/MOWLParser.g:184:20:
			// propertyExpression VALUE value
			{
				this.pushFollow(FOLLOW_propertyExpression_in_valueRestriction1709);
				propertyExpression85 = this.propertyExpression();
				this.state._fsp--;
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_propertyExpression.add(propertyExpression85.getTree());
				}
				VALUE86 = (Token) this.match(
						this.input,
						VALUE,
						FOLLOW_VALUE_in_valueRestriction1711);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_VALUE.add(VALUE86);
				}
				this.pushFollow(FOLLOW_value_in_valueRestriction1713);
				value87 = this.value();
				this.state._fsp--;
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_value.add(value87.getTree());
				}
				// AST REWRITE
				// elements: propertyExpression, value
				// token labels:
				// rule labels: retval
				// token list labels:
				// rule list labels:
				// wildcard labels:
				if (this.state.backtracking == 0) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(
							this.adaptor, "rule retval", retval != null ? retval.tree : null);
					root_0 = (ManchesterOWLSyntaxTree) this.adaptor.nil();
					// 184:51: -> ^( VALUE_RESTRICTION propertyExpression value
					// )
					{
						// /Users/luigi/Documents/workspace/Parsers/src/MOWLParser.g:184:54:
						// ^( VALUE_RESTRICTION propertyExpression value )
						{
							ManchesterOWLSyntaxTree root_1 = (ManchesterOWLSyntaxTree) this.adaptor.nil();
							root_1 = (ManchesterOWLSyntaxTree) this.adaptor.becomeRoot(
									this.adaptor.create(VALUE_RESTRICTION, "VALUE_RESTRICTION"),
									root_1);
							this.adaptor.addChild(root_1, stream_propertyExpression.nextTree());
							this.adaptor.addChild(root_1, stream_value.nextTree());
							this.adaptor.addChild(root_0, root_1);
						}
					}
					retval.tree = root_0;
				}
			}
			retval.stop = this.input.LT(-1);
			if (this.state.backtracking == 0) {
				retval.tree = (ManchesterOWLSyntaxTree) this.adaptor.rulePostProcessing(root_0);
				this.adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		} catch (RecognitionException e) {
			throw e;
		} catch (RewriteEmptyStreamException e) {
			throw e;
		} finally {
		}
		return retval;
	}

	// $ANTLR end "valueRestriction"
	public static class value_return extends ParserRuleReturnScope {
		ManchesterOWLSyntaxTree tree;

		@Override
		public Object getTree() {
			return this.tree;
		}
	};

	// $ANTLR start "value"
	// /Users/luigi/Documents/workspace/Parsers/src/MOWLParser.g:187:1: value :
	// ( IDENTIFIER -> ^( IDENTIFIER ) | constant -> ^( constant ) );
	public final MOWLParser.value_return value() throws RecognitionException {
		MOWLParser.value_return retval = new MOWLParser.value_return();
		retval.start = this.input.LT(1);
		ManchesterOWLSyntaxTree root_0 = null;
		Token IDENTIFIER88 = null;
		MOWLParser.constant_return constant89 = null;
		ManchesterOWLSyntaxTree IDENTIFIER88_tree = null;
		RewriteRuleTokenStream stream_IDENTIFIER = new RewriteRuleTokenStream(this.adaptor,
				"token IDENTIFIER");
		RewriteRuleSubtreeStream stream_constant = new RewriteRuleSubtreeStream(this.adaptor,
				"rule constant");
		try {
			// /Users/luigi/Documents/workspace/Parsers/src/MOWLParser.g:187:6:
			// ( IDENTIFIER -> ^( IDENTIFIER ) | constant -> ^( constant ) )
			int alt18 = 2;
			int LA18_0 = this.input.LA(1);
			if (LA18_0 == IDENTIFIER) {
				alt18 = 1;
			} else if (LA18_0 == DBLQUOTE) {
				alt18 = 2;
			} else {
				if (this.state.backtracking > 0) {
					this.state.failed = true;
					return retval;
				}
				NoViableAltException nvae = new NoViableAltException("", 18, 0, this.input);
				throw nvae;
			}
			switch (alt18) {
			case 1:
				// /Users/luigi/Documents/workspace/Parsers/src/MOWLParser.g:188:7:
				// IDENTIFIER
			{
				IDENTIFIER88 = (Token) this.match(
						this.input,
						IDENTIFIER,
						FOLLOW_IDENTIFIER_in_value1738);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_IDENTIFIER.add(IDENTIFIER88);
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
					root_0 = (ManchesterOWLSyntaxTree) this.adaptor.nil();
					// 188:18: -> ^( IDENTIFIER )
					{
						// /Users/luigi/Documents/workspace/Parsers/src/MOWLParser.g:188:21:
						// ^( IDENTIFIER )
						{
							ManchesterOWLSyntaxTree root_1 = (ManchesterOWLSyntaxTree) this.adaptor.nil();
							root_1 = (ManchesterOWLSyntaxTree) this.adaptor.becomeRoot(
									stream_IDENTIFIER.nextNode(),
									root_1);
							this.adaptor.addChild(root_0, root_1);
						}
					}
					retval.tree = root_0;
				}
			}
				break;
			case 2:
				// /Users/luigi/Documents/workspace/Parsers/src/MOWLParser.g:189:7:
				// constant
			{
				this.pushFollow(FOLLOW_constant_in_value1753);
				constant89 = this.constant();
				this.state._fsp--;
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_constant.add(constant89.getTree());
				}
				// AST REWRITE
				// elements: constant
				// token labels:
				// rule labels: retval
				// token list labels:
				// rule list labels:
				// wildcard labels:
				if (this.state.backtracking == 0) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(
							this.adaptor, "rule retval", retval != null ? retval.tree : null);
					root_0 = (ManchesterOWLSyntaxTree) this.adaptor.nil();
					// 189:16: -> ^( constant )
					{
						// /Users/luigi/Documents/workspace/Parsers/src/MOWLParser.g:189:19:
						// ^( constant )
						{
							ManchesterOWLSyntaxTree root_1 = (ManchesterOWLSyntaxTree) this.adaptor.nil();
							root_1 = (ManchesterOWLSyntaxTree) this.adaptor.becomeRoot(
									stream_constant.nextNode(),
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
				retval.tree = (ManchesterOWLSyntaxTree) this.adaptor.rulePostProcessing(root_0);
				this.adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		} catch (RecognitionException e) {
			throw e;
		} catch (RewriteEmptyStreamException e) {
			throw e;
		} finally {
		}
		return retval;
	}

	// $ANTLR end "value"
	public static class constant_return extends ParserRuleReturnScope {
		ManchesterOWLSyntaxTree tree;

		@Override
		public Object getTree() {
			return this.tree;
		}
	};

	// $ANTLR start "constant"
	// /Users/luigi/Documents/workspace/Parsers/src/MOWLParser.g:192:1: constant
	// : constantValue= DBLQUOTE ( POW type= IDENTIFIER )? -> ^( CONSTANT
	// $constantValue ( $type)? ) ;
	public final MOWLParser.constant_return constant() throws RecognitionException {
		MOWLParser.constant_return retval = new MOWLParser.constant_return();
		retval.start = this.input.LT(1);
		ManchesterOWLSyntaxTree root_0 = null;
		Token constantValue = null;
		Token type = null;
		Token POW90 = null;
		ManchesterOWLSyntaxTree constantValue_tree = null;
		ManchesterOWLSyntaxTree type_tree = null;
		ManchesterOWLSyntaxTree POW90_tree = null;
		RewriteRuleTokenStream stream_POW = new RewriteRuleTokenStream(this.adaptor, "token POW");
		RewriteRuleTokenStream stream_IDENTIFIER = new RewriteRuleTokenStream(this.adaptor,
				"token IDENTIFIER");
		RewriteRuleTokenStream stream_DBLQUOTE = new RewriteRuleTokenStream(this.adaptor,
				"token DBLQUOTE");
		try {
			// /Users/luigi/Documents/workspace/Parsers/src/MOWLParser.g:192:11:
			// (constantValue= DBLQUOTE ( POW type= IDENTIFIER )? -> ^( CONSTANT
			// $constantValue ( $type)? ) )
			// /Users/luigi/Documents/workspace/Parsers/src/MOWLParser.g:192:14:
			// constantValue= DBLQUOTE ( POW type= IDENTIFIER )?
			{
				constantValue = (Token) this.match(
						this.input,
						DBLQUOTE,
						FOLLOW_DBLQUOTE_in_constant1778);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_DBLQUOTE.add(constantValue);
				}
				// /Users/luigi/Documents/workspace/Parsers/src/MOWLParser.g:192:39:
				// ( POW type= IDENTIFIER )?
				int alt19 = 2;
				int LA19_0 = this.input.LA(1);
				if (LA19_0 == POW) {
					alt19 = 1;
				}
				switch (alt19) {
				case 1:
					// /Users/luigi/Documents/workspace/Parsers/src/MOWLParser.g:192:41:
					// POW type= IDENTIFIER
				{
					POW90 = (Token) this.match(this.input, POW, FOLLOW_POW_in_constant1782);
					if (this.state.failed) {
						return retval;
					}
					if (this.state.backtracking == 0) {
						stream_POW.add(POW90);
					}
					type = (Token) this.match(
							this.input,
							IDENTIFIER,
							FOLLOW_IDENTIFIER_in_constant1788);
					if (this.state.failed) {
						return retval;
					}
					if (this.state.backtracking == 0) {
						stream_IDENTIFIER.add(type);
					}
				}
					break;
				}
				// AST REWRITE
				// elements: type, constantValue
				// token labels: constantValue, type
				// rule labels: retval
				// token list labels:
				// rule list labels:
				// wildcard labels:
				if (this.state.backtracking == 0) {
					retval.tree = root_0;
					RewriteRuleTokenStream stream_constantValue = new RewriteRuleTokenStream(
							this.adaptor, "token constantValue", constantValue);
					RewriteRuleTokenStream stream_type = new RewriteRuleTokenStream(this.adaptor,
							"token type", type);
					RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(
							this.adaptor, "rule retval", retval != null ? retval.tree : null);
					root_0 = (ManchesterOWLSyntaxTree) this.adaptor.nil();
					// 192:65: -> ^( CONSTANT $constantValue ( $type)? )
					{
						// /Users/luigi/Documents/workspace/Parsers/src/MOWLParser.g:192:67:
						// ^( CONSTANT $constantValue ( $type)? )
						{
							ManchesterOWLSyntaxTree root_1 = (ManchesterOWLSyntaxTree) this.adaptor.nil();
							root_1 = (ManchesterOWLSyntaxTree) this.adaptor.becomeRoot(
									this.adaptor.create(CONSTANT, "CONSTANT"),
									root_1);
							this.adaptor.addChild(root_1, stream_constantValue.nextNode());
							// /Users/luigi/Documents/workspace/Parsers/src/MOWLParser.g:192:93:
							// ( $type)?
							if (stream_type.hasNext()) {
								this.adaptor.addChild(root_1, stream_type.nextNode());
							}
							stream_type.reset();
							this.adaptor.addChild(root_0, root_1);
						}
					}
					retval.tree = root_0;
				}
			}
			retval.stop = this.input.LT(-1);
			if (this.state.backtracking == 0) {
				retval.tree = (ManchesterOWLSyntaxTree) this.adaptor.rulePostProcessing(root_0);
				this.adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		} catch (RecognitionException e) {
			throw e;
		} catch (RewriteEmptyStreamException e) {
			throw e;
		} finally {
		}
		return retval;
	}

	// $ANTLR end "constant"
	// $ANTLR start synpred4_MOWLParser
	public final void synpred4_MOWLParser_fragment() throws RecognitionException {
		// /Users/luigi/Documents/workspace/Parsers/src/MOWLParser.g:117:6: (
		// conjunction ( OR conjunction )* )
		// /Users/luigi/Documents/workspace/Parsers/src/MOWLParser.g:117:6:
		// conjunction ( OR conjunction )*
		{
			this.pushFollow(FOLLOW_conjunction_in_synpred4_MOWLParser1087);
			this.conjunction();
			this.state._fsp--;
			if (this.state.failed) {
				return;
			}
			// /Users/luigi/Documents/workspace/Parsers/src/MOWLParser.g:117:18:
			// ( OR conjunction )*
			loop20: do {
				int alt20 = 2;
				int LA20_0 = this.input.LA(1);
				if (LA20_0 == OR) {
					alt20 = 1;
				}
				switch (alt20) {
				case 1:
					// /Users/luigi/Documents/workspace/Parsers/src/MOWLParser.g:117:19:
					// OR conjunction
				{
					this.match(this.input, OR, FOLLOW_OR_in_synpred4_MOWLParser1090);
					if (this.state.failed) {
						return;
					}
					this.pushFollow(FOLLOW_conjunction_in_synpred4_MOWLParser1092);
					this.conjunction();
					this.state._fsp--;
					if (this.state.failed) {
						return;
					}
				}
					break;
				default:
					break loop20;
				}
			} while (true);
		}
	}

	// $ANTLR end synpred4_MOWLParser
	// $ANTLR start synpred5_MOWLParser
	public final void synpred5_MOWLParser_fragment() throws RecognitionException {
		// /Users/luigi/Documents/workspace/Parsers/src/MOWLParser.g:118:6: (
		// complexPropertyExpression )
		// /Users/luigi/Documents/workspace/Parsers/src/MOWLParser.g:118:6:
		// complexPropertyExpression
		{
			this.pushFollow(FOLLOW_complexPropertyExpression_in_synpred5_MOWLParser1111);
			this.complexPropertyExpression();
			this.state._fsp--;
			if (this.state.failed) {
				return;
			}
		}
	}

	// $ANTLR end synpred5_MOWLParser
	// $ANTLR start synpred6_MOWLParser
	public final void synpred6_MOWLParser_fragment() throws RecognitionException {
		// /Users/luigi/Documents/workspace/Parsers/src/MOWLParser.g:136:3: (
		// atomic )
		// /Users/luigi/Documents/workspace/Parsers/src/MOWLParser.g:136:3:
		// atomic
		{
			this.pushFollow(FOLLOW_atomic_in_synpred6_MOWLParser1240);
			this.atomic();
			this.state._fsp--;
			if (this.state.failed) {
				return;
			}
		}
	}

	// $ANTLR end synpred6_MOWLParser
	// $ANTLR start synpred7_MOWLParser
	public final void synpred7_MOWLParser_fragment() throws RecognitionException {
		List list_rest = null;
		MOWLParser.propertyExpression_return head = null;
		RuleReturnScope rest = null;
		// /Users/luigi/Documents/workspace/Parsers/src/MOWLParser.g:137:5:
		// (head= propertyExpression ( COMPOSITION rest+= propertyExpression )+
		// )
		// /Users/luigi/Documents/workspace/Parsers/src/MOWLParser.g:137:5:
		// head= propertyExpression ( COMPOSITION rest+= propertyExpression )+
		{
			this.pushFollow(FOLLOW_propertyExpression_in_synpred7_MOWLParser1250);
			head = this.propertyExpression();
			this.state._fsp--;
			if (this.state.failed) {
				return;
			}
			// /Users/luigi/Documents/workspace/Parsers/src/MOWLParser.g:137:31:
			// ( COMPOSITION rest+= propertyExpression )+
			int cnt21 = 0;
			loop21: do {
				int alt21 = 2;
				int LA21_0 = this.input.LA(1);
				if (LA21_0 == COMPOSITION) {
					alt21 = 1;
				}
				switch (alt21) {
				case 1:
					// /Users/luigi/Documents/workspace/Parsers/src/MOWLParser.g:137:32:
					// COMPOSITION rest+= propertyExpression
				{
					this.match(
							this.input,
							COMPOSITION,
							FOLLOW_COMPOSITION_in_synpred7_MOWLParser1253);
					if (this.state.failed) {
						return;
					}
					this.pushFollow(FOLLOW_propertyExpression_in_synpred7_MOWLParser1257);
					rest = this.propertyExpression();
					this.state._fsp--;
					if (this.state.failed) {
						return;
					}
					if (list_rest == null) {
						list_rest = new ArrayList();
					}
					list_rest.add(rest);
				}
					break;
				default:
					if (cnt21 >= 1) {
						break loop21;
					}
					if (this.state.backtracking > 0) {
						this.state.failed = true;
						return;
					}
					EarlyExitException eee = new EarlyExitException(21, this.input);
					throw eee;
				}
				cnt21++;
			} while (true);
		}
	}

	// $ANTLR end synpred7_MOWLParser
	// $ANTLR start synpred8_MOWLParser
	public final void synpred8_MOWLParser_fragment() throws RecognitionException {
		// /Users/luigi/Documents/workspace/Parsers/src/MOWLParser.g:138:5: (
		// NOT OPEN_PARENTHESYS expression CLOSED_PARENTHESYS )
		// /Users/luigi/Documents/workspace/Parsers/src/MOWLParser.g:138:5: NOT
		// OPEN_PARENTHESYS expression CLOSED_PARENTHESYS
		{
			this.match(this.input, NOT, FOLLOW_NOT_in_synpred8_MOWLParser1279);
			if (this.state.failed) {
				return;
			}
			this.match(
					this.input,
					OPEN_PARENTHESYS,
					FOLLOW_OPEN_PARENTHESYS_in_synpred8_MOWLParser1281);
			if (this.state.failed) {
				return;
			}
			this.pushFollow(FOLLOW_expression_in_synpred8_MOWLParser1283);
			this.expression();
			this.state._fsp--;
			if (this.state.failed) {
				return;
			}
			this.match(
					this.input,
					CLOSED_PARENTHESYS,
					FOLLOW_CLOSED_PARENTHESYS_in_synpred8_MOWLParser1285);
			if (this.state.failed) {
				return;
			}
		}
	}

	// $ANTLR end synpred8_MOWLParser
	// $ANTLR start synpred9_MOWLParser
	public final void synpred9_MOWLParser_fragment() throws RecognitionException {
		// /Users/luigi/Documents/workspace/Parsers/src/MOWLParser.g:139:5: (
		// NOT atomic )
		// /Users/luigi/Documents/workspace/Parsers/src/MOWLParser.g:139:5: NOT
		// atomic
		{
			this.match(this.input, NOT, FOLLOW_NOT_in_synpred9_MOWLParser1299);
			if (this.state.failed) {
				return;
			}
			this.pushFollow(FOLLOW_atomic_in_synpred9_MOWLParser1301);
			this.atomic();
			this.state._fsp--;
			if (this.state.failed) {
				return;
			}
		}
	}

	// $ANTLR end synpred9_MOWLParser
	// $ANTLR start synpred10_MOWLParser
	public final void synpred10_MOWLParser_fragment() throws RecognitionException {
		// /Users/luigi/Documents/workspace/Parsers/src/MOWLParser.g:140:5: (
		// qualifiedRestriction )
		// /Users/luigi/Documents/workspace/Parsers/src/MOWLParser.g:140:5:
		// qualifiedRestriction
		{
			this.pushFollow(FOLLOW_qualifiedRestriction_in_synpred10_MOWLParser1324);
			this.qualifiedRestriction();
			this.state._fsp--;
			if (this.state.failed) {
				return;
			}
		}
	}

	// $ANTLR end synpred10_MOWLParser
	// $ANTLR start synpred11_MOWLParser
	public final void synpred11_MOWLParser_fragment() throws RecognitionException {
		// /Users/luigi/Documents/workspace/Parsers/src/MOWLParser.g:152:7: (
		// propertyExpression SOME expression )
		// /Users/luigi/Documents/workspace/Parsers/src/MOWLParser.g:152:7:
		// propertyExpression SOME expression
		{
			this.pushFollow(FOLLOW_propertyExpression_in_synpred11_MOWLParser1409);
			this.propertyExpression();
			this.state._fsp--;
			if (this.state.failed) {
				return;
			}
			this.match(this.input, SOME, FOLLOW_SOME_in_synpred11_MOWLParser1412);
			if (this.state.failed) {
				return;
			}
			this.pushFollow(FOLLOW_expression_in_synpred11_MOWLParser1416);
			this.expression();
			this.state._fsp--;
			if (this.state.failed) {
				return;
			}
		}
	}

	// $ANTLR end synpred11_MOWLParser
	// $ANTLR start synpred12_MOWLParser
	public final void synpred12_MOWLParser_fragment() throws RecognitionException {
		// /Users/luigi/Documents/workspace/Parsers/src/MOWLParser.g:153:7: (
		// propertyExpression ONLY expression )
		// /Users/luigi/Documents/workspace/Parsers/src/MOWLParser.g:153:7:
		// propertyExpression ONLY expression
		{
			this.pushFollow(FOLLOW_propertyExpression_in_synpred12_MOWLParser1445);
			this.propertyExpression();
			this.state._fsp--;
			if (this.state.failed) {
				return;
			}
			this.match(this.input, ONLY, FOLLOW_ONLY_in_synpred12_MOWLParser1447);
			if (this.state.failed) {
				return;
			}
			this.pushFollow(FOLLOW_expression_in_synpred12_MOWLParser1450);
			this.expression();
			this.state._fsp--;
			if (this.state.failed) {
				return;
			}
		}
	}

	// $ANTLR end synpred12_MOWLParser
	// $ANTLR start synpred13_MOWLParser
	public final void synpred13_MOWLParser_fragment() throws RecognitionException {
		// /Users/luigi/Documents/workspace/Parsers/src/MOWLParser.g:154:7: (
		// cardinalityRestriction )
		// /Users/luigi/Documents/workspace/Parsers/src/MOWLParser.g:154:7:
		// cardinalityRestriction
		{
			this.pushFollow(FOLLOW_cardinalityRestriction_in_synpred13_MOWLParser1469);
			this.cardinalityRestriction();
			this.state._fsp--;
			if (this.state.failed) {
				return;
			}
		}
	}

	// $ANTLR end synpred13_MOWLParser
	// Delegated rules
	public final boolean synpred9_MOWLParser() {
		this.state.backtracking++;
		int start = this.input.mark();
		try {
			this.synpred9_MOWLParser_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: " + re);
		}
		boolean success = !this.state.failed;
		this.input.rewind(start);
		this.state.backtracking--;
		this.state.failed = false;
		return success;
	}

	public final boolean synpred6_MOWLParser() {
		this.state.backtracking++;
		int start = this.input.mark();
		try {
			this.synpred6_MOWLParser_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: " + re);
		}
		boolean success = !this.state.failed;
		this.input.rewind(start);
		this.state.backtracking--;
		this.state.failed = false;
		return success;
	}

	public final boolean synpred7_MOWLParser() {
		this.state.backtracking++;
		int start = this.input.mark();
		try {
			this.synpred7_MOWLParser_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: " + re);
		}
		boolean success = !this.state.failed;
		this.input.rewind(start);
		this.state.backtracking--;
		this.state.failed = false;
		return success;
	}

	public final boolean synpred4_MOWLParser() {
		this.state.backtracking++;
		int start = this.input.mark();
		try {
			this.synpred4_MOWLParser_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: " + re);
		}
		boolean success = !this.state.failed;
		this.input.rewind(start);
		this.state.backtracking--;
		this.state.failed = false;
		return success;
	}

	public final boolean synpred12_MOWLParser() {
		this.state.backtracking++;
		int start = this.input.mark();
		try {
			this.synpred12_MOWLParser_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: " + re);
		}
		boolean success = !this.state.failed;
		this.input.rewind(start);
		this.state.backtracking--;
		this.state.failed = false;
		return success;
	}

	public final boolean synpred10_MOWLParser() {
		this.state.backtracking++;
		int start = this.input.mark();
		try {
			this.synpred10_MOWLParser_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: " + re);
		}
		boolean success = !this.state.failed;
		this.input.rewind(start);
		this.state.backtracking--;
		this.state.failed = false;
		return success;
	}

	public final boolean synpred8_MOWLParser() {
		this.state.backtracking++;
		int start = this.input.mark();
		try {
			this.synpred8_MOWLParser_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: " + re);
		}
		boolean success = !this.state.failed;
		this.input.rewind(start);
		this.state.backtracking--;
		this.state.failed = false;
		return success;
	}

	public final boolean synpred11_MOWLParser() {
		this.state.backtracking++;
		int start = this.input.mark();
		try {
			this.synpred11_MOWLParser_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: " + re);
		}
		boolean success = !this.state.failed;
		this.input.rewind(start);
		this.state.backtracking--;
		this.state.failed = false;
		return success;
	}

	public final boolean synpred13_MOWLParser() {
		this.state.backtracking++;
		int start = this.input.mark();
		try {
			this.synpred13_MOWLParser_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: " + re);
		}
		boolean success = !this.state.failed;
		this.input.rewind(start);
		this.state.backtracking--;
		this.state.failed = false;
		return success;
	}

	public final boolean synpred5_MOWLParser() {
		this.state.backtracking++;
		int start = this.input.mark();
		try {
			this.synpred5_MOWLParser_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: " + re);
		}
		boolean success = !this.state.failed;
		this.input.rewind(start);
		this.state.backtracking--;
		this.state.failed = false;
		return success;
	}

	protected DFA7 dfa7 = new DFA7(this);
	protected DFA11 dfa11 = new DFA11(this);
	static final String DFA7_eotS = "\26\uffff";
	static final String DFA7_eofS = "\1\1\25\uffff";
	static final String DFA7_minS = "\1\5\17\uffff\1\0\5\uffff";
	static final String DFA7_maxS = "\1\55\17\uffff\1\0\5\uffff";
	static final String DFA7_acceptS = "\1\uffff\1\1\14\uffff\1\2\5\uffff\1\4\1\3";
	static final String DFA7_specialS = "\20\uffff\1\0\5\uffff}>";
	static final String[] DFA7_transitionS = {
			"\1\24\1\16\1\uffff\1\1\1\uffff\2\1\1\16\6\uffff\1\20\11\1\13"
					+ "\uffff\1\16\3\uffff\2\16", "", "", "", "", "", "", "", "", "", "", "", "",
			"", "", "", "\1\uffff", "", "", "", "", "" };
	static final short[] DFA7_eot = DFA.unpackEncodedString(DFA7_eotS);
	static final short[] DFA7_eof = DFA.unpackEncodedString(DFA7_eofS);
	static final char[] DFA7_min = DFA.unpackEncodedStringToUnsignedChars(DFA7_minS);
	static final char[] DFA7_max = DFA.unpackEncodedStringToUnsignedChars(DFA7_maxS);
	static final short[] DFA7_accept = DFA.unpackEncodedString(DFA7_acceptS);
	static final short[] DFA7_special = DFA.unpackEncodedString(DFA7_specialS);
	static final short[][] DFA7_transition;
	static {
		int numStates = DFA7_transitionS.length;
		DFA7_transition = new short[numStates][];
		for (int i = 0; i < numStates; i++) {
			DFA7_transition[i] = DFA.unpackEncodedString(DFA7_transitionS[i]);
		}
	}

	class DFA7 extends DFA {
		public DFA7(BaseRecognizer recognizer) {
			this.recognizer = recognizer;
			this.decisionNumber = 7;
			this.eot = DFA7_eot;
			this.eof = DFA7_eof;
			this.min = DFA7_min;
			this.max = DFA7_max;
			this.accept = DFA7_accept;
			this.special = DFA7_special;
			this.transition = DFA7_transition;
		}

		@Override
		public String getDescription() {
			return "115:5: ( options {backtrack=true; } : | conjunction ( OR conjunction )* -> ^( DISJUNCTION ( conjunction )+ ) | complexPropertyExpression -> ^( complexPropertyExpression ) | OPEN_PARENTHESYS expression CLOSED_PARENTHESYS -> ^( expression ) )";
		}

		@Override
		public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
			TokenStream input = (TokenStream) _input;
			int _s = s;
			switch (s) {
			case 0:
				int LA7_16 = input.LA(1);
				int index7_16 = input.index();
				input.rewind();
				s = -1;
				if (MOWLParser.this.synpred4_MOWLParser()) {
					s = 14;
				} else if (MOWLParser.this.synpred5_MOWLParser()) {
					s = 21;
				}
				input.seek(index7_16);
				if (s >= 0) {
					return s;
				}
				break;
			}
			if (MOWLParser.this.state.backtracking > 0) {
				MOWLParser.this.state.failed = true;
				return -1;
			}
			NoViableAltException nvae = new NoViableAltException(this.getDescription(), 7, _s,
					input);
			this.error(nvae);
			throw nvae;
		}
	}

	static final String DFA11_eotS = "\13\uffff";
	static final String DFA11_eofS = "\13\uffff";
	static final String DFA11_minS = "\1\6\4\0\6\uffff";
	static final String DFA11_maxS = "\1\55\4\0\6\uffff";
	static final String DFA11_acceptS = "\5\uffff\1\5\1\6\1\1\1\2\1\3\1\4";
	static final String DFA11_specialS = "\1\uffff\1\0\1\1\1\2\1\3\6\uffff}>";
	static final String[] DFA11_transitionS = {
			"\1\5\5\uffff\1\4\6\uffff\1\3\24\uffff\1\6\3\uffff\1\1\1\2", "\1\uffff", "\1\uffff",
			"\1\uffff", "\1\uffff", "", "", "", "", "", "" };
	static final short[] DFA11_eot = DFA.unpackEncodedString(DFA11_eotS);
	static final short[] DFA11_eof = DFA.unpackEncodedString(DFA11_eofS);
	static final char[] DFA11_min = DFA.unpackEncodedStringToUnsignedChars(DFA11_minS);
	static final char[] DFA11_max = DFA.unpackEncodedStringToUnsignedChars(DFA11_maxS);
	static final short[] DFA11_accept = DFA.unpackEncodedString(DFA11_acceptS);
	static final short[] DFA11_special = DFA.unpackEncodedString(DFA11_specialS);
	static final short[][] DFA11_transition;
	static {
		int numStates = DFA11_transitionS.length;
		DFA11_transition = new short[numStates][];
		for (int i = 0; i < numStates; i++) {
			DFA11_transition[i] = DFA.unpackEncodedString(DFA11_transitionS[i]);
		}
	}

	class DFA11 extends DFA {
		public DFA11(BaseRecognizer recognizer) {
			this.recognizer = recognizer;
			this.decisionNumber = 11;
			this.eot = DFA11_eot;
			this.eof = DFA11_eof;
			this.min = DFA11_min;
			this.max = DFA11_max;
			this.accept = DFA11_accept;
			this.special = DFA11_special;
			this.transition = DFA11_transition;
		}

		@Override
		public String getDescription() {
			return "135:1: unary options {backtrack=true; } : ( atomic | head= propertyExpression ( COMPOSITION rest+= propertyExpression )+ -> ^( PROPERTY_CHAIN $head $rest) | NOT OPEN_PARENTHESYS expression CLOSED_PARENTHESYS -> ^( NEGATED_EXPRESSION expression ) | NOT atomic -> ^( NEGATED_EXPRESSION atomic ) | qualifiedRestriction -> ^( qualifiedRestriction ) | constant );";
		}

		@Override
		public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
			TokenStream input = (TokenStream) _input;
			int _s = s;
			switch (s) {
			case 0:
				int LA11_1 = input.LA(1);
				int index11_1 = input.index();
				input.rewind();
				s = -1;
				if (MOWLParser.this.synpred6_MOWLParser()) {
					s = 7;
				} else if (MOWLParser.this.synpred7_MOWLParser()) {
					s = 8;
				} else if (MOWLParser.this.synpred10_MOWLParser()) {
					s = 5;
				}
				input.seek(index11_1);
				if (s >= 0) {
					return s;
				}
				break;
			case 1:
				int LA11_2 = input.LA(1);
				int index11_2 = input.index();
				input.rewind();
				s = -1;
				if (MOWLParser.this.synpred6_MOWLParser()) {
					s = 7;
				} else if (MOWLParser.this.synpred7_MOWLParser()) {
					s = 8;
				} else if (MOWLParser.this.synpred10_MOWLParser()) {
					s = 5;
				}
				input.seek(index11_2);
				if (s >= 0) {
					return s;
				}
				break;
			case 2:
				int LA11_3 = input.LA(1);
				int index11_3 = input.index();
				input.rewind();
				s = -1;
				if (MOWLParser.this.synpred7_MOWLParser()) {
					s = 8;
				} else if (MOWLParser.this.synpred10_MOWLParser()) {
					s = 5;
				}
				input.seek(index11_3);
				if (s >= 0) {
					return s;
				}
				break;
			case 3:
				int LA11_4 = input.LA(1);
				int index11_4 = input.index();
				input.rewind();
				s = -1;
				if (MOWLParser.this.synpred8_MOWLParser()) {
					s = 9;
				} else if (MOWLParser.this.synpred9_MOWLParser()) {
					s = 10;
				}
				input.seek(index11_4);
				if (s >= 0) {
					return s;
				}
				break;
			}
			if (MOWLParser.this.state.backtracking > 0) {
				MOWLParser.this.state.failed = true;
				return -1;
			}
			NoViableAltException nvae = new NoViableAltException(this.getDescription(), 11, _s,
					input);
			this.error(nvae);
			throw nvae;
		}
	}

	public static final BitSet FOLLOW_binaryAxiom_in_axiom231 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_unaryAxiom_in_axiom243 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_assertionAxiom_in_axiom255 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_IDENTIFIER_in_assertionAxiom278 = new BitSet(
			new long[] { 0x000000C000000000L });
	public static final BitSet FOLLOW_INSTANCE_OF_in_assertionAxiom281 = new BitSet(
			new long[] { 0x0000310000081060L });
	public static final BitSet FOLLOW_TYPES_in_assertionAxiom285 = new BitSet(
			new long[] { 0x0000310000081060L });
	public static final BitSet FOLLOW_expression_in_assertionAxiom288 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_IDENTIFIER_in_assertionAxiom314 = new BitSet(
			new long[] { 0x0000300000080000L });
	public static final BitSet FOLLOW_propertyExpression_in_assertionAxiom316 = new BitSet(
			new long[] { 0x0000310000081040L });
	public static final BitSet FOLLOW_value_in_assertionAxiom319 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_NOT_in_assertionAxiom352 = new BitSet(
			new long[] { 0x0000100000001000L });
	public static final BitSet FOLLOW_assertionAxiom_in_assertionAxiom354 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_expression_in_binaryAxiom399 = new BitSet(
			new long[] { 0x000000001FF00000L });
	public static final BitSet FOLLOW_SUBCLASS_OF_in_binaryAxiom453 = new BitSet(
			new long[] { 0x0000310000081060L });
	public static final BitSet FOLLOW_expression_in_binaryAxiom460 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_EQUIVALENT_TO_in_binaryAxiom501 = new BitSet(
			new long[] { 0x0000310000081060L });
	public static final BitSet FOLLOW_expression_in_binaryAxiom507 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_DISJOINT_WITH_in_binaryAxiom547 = new BitSet(
			new long[] { 0x0000310000081060L });
	public static final BitSet FOLLOW_expression_in_binaryAxiom553 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_SUB_PROPERTY_OF_in_binaryAxiom593 = new BitSet(
			new long[] { 0x0000300000080000L });
	public static final BitSet FOLLOW_propertyExpression_in_binaryAxiom599 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_INVERSE_OF_in_binaryAxiom639 = new BitSet(
			new long[] { 0x0000300000000000L });
	public static final BitSet FOLLOW_atomic_in_binaryAxiom645 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_SAME_AS_in_binaryAxiom673 = new BitSet(
			new long[] { 0x0000300000000000L });
	public static final BitSet FOLLOW_atomic_in_binaryAxiom680 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_DIFFERENT_FROM_in_binaryAxiom721 = new BitSet(
			new long[] { 0x0000300000000000L });
	public static final BitSet FOLLOW_atomic_in_binaryAxiom728 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_DOMAIN_in_binaryAxiom768 = new BitSet(
			new long[] { 0x0000310000081060L });
	public static final BitSet FOLLOW_expression_in_binaryAxiom770 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_RANGE_in_binaryAxiom809 = new BitSet(
			new long[] { 0x0000310000081060L });
	public static final BitSet FOLLOW_expression_in_binaryAxiom811 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_unaryCharacteristic_in_unaryAxiom911 = new BitSet(
			new long[] { 0x0000310000081040L });
	public static final BitSet FOLLOW_unary_in_unaryAxiom915 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_FUNCTIONAL_in_unaryCharacteristic960 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_INVERSE_FUNCTIONAL_in_unaryCharacteristic974 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_SYMMETRIC_in_unaryCharacteristic988 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_ANTI_SYMMETRIC_in_unaryCharacteristic1002 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_REFLEXIVE_in_unaryCharacteristic1016 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_IRREFLEXIVE_in_unaryCharacteristic1030 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_TRANSITIVE_in_unaryCharacteristic1044 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_conjunction_in_expression1087 = new BitSet(
			new long[] { 0x0000000000000802L });
	public static final BitSet FOLLOW_OR_in_expression1090 = new BitSet(
			new long[] { 0x0000310000081040L });
	public static final BitSet FOLLOW_conjunction_in_expression1092 = new BitSet(
			new long[] { 0x0000000000000802L });
	public static final BitSet FOLLOW_complexPropertyExpression_in_expression1111 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_OPEN_PARENTHESYS_in_expression1124 = new BitSet(
			new long[] { 0x0000310000081160L });
	public static final BitSet FOLLOW_expression_in_expression1126 = new BitSet(
			new long[] { 0x0000000000000100L });
	public static final BitSet FOLLOW_CLOSED_PARENTHESYS_in_expression1128 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_unary_in_conjunction1160 = new BitSet(
			new long[] { 0x0000000000000402L });
	public static final BitSet FOLLOW_AND_in_conjunction1163 = new BitSet(
			new long[] { 0x0000310000081040L });
	public static final BitSet FOLLOW_unary_in_conjunction1165 = new BitSet(
			new long[] { 0x0000000000000402L });
	public static final BitSet FOLLOW_INVERSE_in_complexPropertyExpression1186 = new BitSet(
			new long[] { 0x0000000000000020L });
	public static final BitSet FOLLOW_OPEN_PARENTHESYS_in_complexPropertyExpression1188 = new BitSet(
			new long[] { 0x0000300000080000L });
	public static final BitSet FOLLOW_complexPropertyExpression_in_complexPropertyExpression1190 = new BitSet(
			new long[] { 0x0000000000000100L });
	public static final BitSet FOLLOW_CLOSED_PARENTHESYS_in_complexPropertyExpression1192 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_INVERSE_in_complexPropertyExpression1205 = new BitSet(
			new long[] { 0x0000000000000020L });
	public static final BitSet FOLLOW_OPEN_PARENTHESYS_in_complexPropertyExpression1207 = new BitSet(
			new long[] { 0x0000300000000000L });
	public static final BitSet FOLLOW_atomic_in_complexPropertyExpression1209 = new BitSet(
			new long[] { 0x0000000000000100L });
	public static final BitSet FOLLOW_CLOSED_PARENTHESYS_in_complexPropertyExpression1211 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_atomic_in_unary1240 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_propertyExpression_in_unary1250 = new BitSet(
			new long[] { 0x0000000000000010L });
	public static final BitSet FOLLOW_COMPOSITION_in_unary1253 = new BitSet(
			new long[] { 0x0000300000080000L });
	public static final BitSet FOLLOW_propertyExpression_in_unary1257 = new BitSet(
			new long[] { 0x0000000000000012L });
	public static final BitSet FOLLOW_NOT_in_unary1279 = new BitSet(
			new long[] { 0x0000000000000020L });
	public static final BitSet FOLLOW_OPEN_PARENTHESYS_in_unary1281 = new BitSet(
			new long[] { 0x0000310000081160L });
	public static final BitSet FOLLOW_expression_in_unary1283 = new BitSet(
			new long[] { 0x0000000000000100L });
	public static final BitSet FOLLOW_CLOSED_PARENTHESYS_in_unary1285 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_NOT_in_unary1299 = new BitSet(
			new long[] { 0x0000300000000000L });
	public static final BitSet FOLLOW_atomic_in_unary1301 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_qualifiedRestriction_in_unary1324 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_constant_in_unary1336 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_IDENTIFIER_in_atomic1350 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_ENTITY_REFERENCE_in_atomic1357 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_propertyExpression_in_qualifiedRestriction1409 = new BitSet(
			new long[] { 0x0000000000002000L });
	public static final BitSet FOLLOW_SOME_in_qualifiedRestriction1412 = new BitSet(
			new long[] { 0x0000310000081060L });
	public static final BitSet FOLLOW_expression_in_qualifiedRestriction1416 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_propertyExpression_in_qualifiedRestriction1445 = new BitSet(
			new long[] { 0x0000000000004000L });
	public static final BitSet FOLLOW_ONLY_in_qualifiedRestriction1447 = new BitSet(
			new long[] { 0x0000310000081060L });
	public static final BitSet FOLLOW_expression_in_qualifiedRestriction1450 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_cardinalityRestriction_in_qualifiedRestriction1469 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_oneOf_in_qualifiedRestriction1483 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_valueRestriction_in_qualifiedRestriction1497 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_atomic_in_propertyExpression1529 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_complexPropertyExpression_in_propertyExpression1543 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_propertyExpression_in_cardinalityRestriction1585 = new BitSet(
			new long[] { 0x0000000000038000L });
	public static final BitSet FOLLOW_restrictionKind_in_cardinalityRestriction1588 = new BitSet(
			new long[] { 0x0000040000000000L });
	public static final BitSet FOLLOW_INTEGER_in_cardinalityRestriction1590 = new BitSet(
			new long[] { 0x0000310000081042L });
	public static final BitSet FOLLOW_unary_in_cardinalityRestriction1592 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_MIN_in_restrictionKind1625 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_MAX_in_restrictionKind1639 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_EXACTLY_in_restrictionKind1653 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_OPEN_CURLY_BRACES_in_oneOf1678 = new BitSet(
			new long[] { 0x0000100000000000L });
	public static final BitSet FOLLOW_IDENTIFIER_in_oneOf1680 = new BitSet(
			new long[] { 0x0000002000000080L });
	public static final BitSet FOLLOW_COMMA_in_oneOf1683 = new BitSet(
			new long[] { 0x0000100000000000L });
	public static final BitSet FOLLOW_IDENTIFIER_in_oneOf1685 = new BitSet(
			new long[] { 0x0000002000000080L });
	public static final BitSet FOLLOW_CLOSED_CURLY_BRACES_in_oneOf1689 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_propertyExpression_in_valueRestriction1709 = new BitSet(
			new long[] { 0x0000000000040000L });
	public static final BitSet FOLLOW_VALUE_in_valueRestriction1711 = new BitSet(
			new long[] { 0x0000310000081040L });
	public static final BitSet FOLLOW_value_in_valueRestriction1713 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_IDENTIFIER_in_value1738 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_constant_in_value1753 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_DBLQUOTE_in_constant1778 = new BitSet(
			new long[] { 0x0000001000000002L });
	public static final BitSet FOLLOW_POW_in_constant1782 = new BitSet(
			new long[] { 0x0000100000000000L });
	public static final BitSet FOLLOW_IDENTIFIER_in_constant1788 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_conjunction_in_synpred4_MOWLParser1087 = new BitSet(
			new long[] { 0x0000000000000802L });
	public static final BitSet FOLLOW_OR_in_synpred4_MOWLParser1090 = new BitSet(
			new long[] { 0x0000310000081040L });
	public static final BitSet FOLLOW_conjunction_in_synpred4_MOWLParser1092 = new BitSet(
			new long[] { 0x0000000000000802L });
	public static final BitSet FOLLOW_complexPropertyExpression_in_synpred5_MOWLParser1111 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_atomic_in_synpred6_MOWLParser1240 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_propertyExpression_in_synpred7_MOWLParser1250 = new BitSet(
			new long[] { 0x0000000000000010L });
	public static final BitSet FOLLOW_COMPOSITION_in_synpred7_MOWLParser1253 = new BitSet(
			new long[] { 0x0000300000080000L });
	public static final BitSet FOLLOW_propertyExpression_in_synpred7_MOWLParser1257 = new BitSet(
			new long[] { 0x0000000000000012L });
	public static final BitSet FOLLOW_NOT_in_synpred8_MOWLParser1279 = new BitSet(
			new long[] { 0x0000000000000020L });
	public static final BitSet FOLLOW_OPEN_PARENTHESYS_in_synpred8_MOWLParser1281 = new BitSet(
			new long[] { 0x0000310000081160L });
	public static final BitSet FOLLOW_expression_in_synpred8_MOWLParser1283 = new BitSet(
			new long[] { 0x0000000000000100L });
	public static final BitSet FOLLOW_CLOSED_PARENTHESYS_in_synpred8_MOWLParser1285 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_NOT_in_synpred9_MOWLParser1299 = new BitSet(
			new long[] { 0x0000300000000000L });
	public static final BitSet FOLLOW_atomic_in_synpred9_MOWLParser1301 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_qualifiedRestriction_in_synpred10_MOWLParser1324 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_propertyExpression_in_synpred11_MOWLParser1409 = new BitSet(
			new long[] { 0x0000000000002000L });
	public static final BitSet FOLLOW_SOME_in_synpred11_MOWLParser1412 = new BitSet(
			new long[] { 0x0000310000081060L });
	public static final BitSet FOLLOW_expression_in_synpred11_MOWLParser1416 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_propertyExpression_in_synpred12_MOWLParser1445 = new BitSet(
			new long[] { 0x0000000000004000L });
	public static final BitSet FOLLOW_ONLY_in_synpred12_MOWLParser1447 = new BitSet(
			new long[] { 0x0000310000081060L });
	public static final BitSet FOLLOW_expression_in_synpred12_MOWLParser1450 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_cardinalityRestriction_in_synpred13_MOWLParser1469 = new BitSet(
			new long[] { 0x0000000000000002L });
}