package org.coode.parsers.oppl;

// $ANTLR 3.2 Sep 23, 2009 12:02:23 MOWLParser.g 2010-07-23 22:26:04
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

public class OPPLParser_MOWLParser extends Parser {
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
	// delegators
	public OPPLParser gOPPLParser;
	public OPPLParser gParent;

	public OPPLParser_MOWLParser(TokenStream input, OPPLParser gOPPLParser) {
		this(input, new RecognizerSharedState(), gOPPLParser);
	}

	public OPPLParser_MOWLParser(TokenStream input,
			RecognizerSharedState state, OPPLParser gOPPLParser) {
		super(input, state);
		this.gOPPLParser = gOPPLParser;
		this.gParent = gOPPLParser;
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
		return OPPLParser.tokenNames;
	}

	@Override
	public String getGrammarFileName() {
		return "MOWLParser.g";
	}

	@Override
	public void displayRecognitionError(String[] tokenNames,
			RecognitionException e) {
	}

	public static class axiom_return extends ParserRuleReturnScope {
		OPPLSyntaxTree tree;

		@Override
		public Object getTree() {
			return this.tree;
		}
	};

	// $ANTLR start "axiom"
	// MOWLParser.g:63:1: axiom options {backtrack=true; } : ( binaryAxiom -> ^(
	// binaryAxiom ) | unaryAxiom -> ^( unaryAxiom ) | assertionAxiom -> ^(
	// assertionAxiom ) );
	public final OPPLParser_MOWLParser.axiom_return axiom()
			throws RecognitionException {
		OPPLParser_MOWLParser.axiom_return retval = new OPPLParser_MOWLParser.axiom_return();
		retval.start = this.input.LT(1);
		OPPLSyntaxTree root_0 = null;
		OPPLParser_MOWLParser.binaryAxiom_return binaryAxiom1 = null;
		OPPLParser_MOWLParser.unaryAxiom_return unaryAxiom2 = null;
		OPPLParser_MOWLParser.assertionAxiom_return assertionAxiom3 = null;
		RewriteRuleSubtreeStream stream_binaryAxiom = new RewriteRuleSubtreeStream(
				this.adaptor, "rule binaryAxiom");
		RewriteRuleSubtreeStream stream_unaryAxiom = new RewriteRuleSubtreeStream(
				this.adaptor, "rule unaryAxiom");
		RewriteRuleSubtreeStream stream_assertionAxiom = new RewriteRuleSubtreeStream(
				this.adaptor, "rule assertionAxiom");
		try {
			// MOWLParser.g:63:37: ( binaryAxiom -> ^( binaryAxiom ) |
			// unaryAxiom -> ^( unaryAxiom ) | assertionAxiom -> ^(
			// assertionAxiom ) )
			int alt1 = 3;
			alt1 = this.dfa1.predict(this.input);
			switch (alt1) {
			case 1:
				// MOWLParser.g:64:3: binaryAxiom
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
							this.adaptor, "rule retval",
							retval != null ? retval.tree : null);
					root_0 = (OPPLSyntaxTree) this.adaptor.nil();
					// 64:15: -> ^( binaryAxiom )
					{
						// MOWLParser.g:64:18: ^( binaryAxiom )
						{
							OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor
									.nil();
							root_1 = (OPPLSyntaxTree) this.adaptor.becomeRoot(
									stream_binaryAxiom.nextNode(), root_1);
							this.adaptor.addChild(root_0, root_1);
						}
					}
					retval.tree = root_0;
				}
			}
				break;
			case 2:
				// MOWLParser.g:65:5: unaryAxiom
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
							this.adaptor, "rule retval",
							retval != null ? retval.tree : null);
					root_0 = (OPPLSyntaxTree) this.adaptor.nil();
					// 65:16: -> ^( unaryAxiom )
					{
						// MOWLParser.g:65:19: ^( unaryAxiom )
						{
							OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor
									.nil();
							root_1 = (OPPLSyntaxTree) this.adaptor.becomeRoot(
									stream_unaryAxiom.nextNode(), root_1);
							this.adaptor.addChild(root_0, root_1);
						}
					}
					retval.tree = root_0;
				}
			}
				break;
			case 3:
				// MOWLParser.g:66:5: assertionAxiom
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
							this.adaptor, "rule retval",
							retval != null ? retval.tree : null);
					root_0 = (OPPLSyntaxTree) this.adaptor.nil();
					// 66:20: -> ^( assertionAxiom )
					{
						// MOWLParser.g:66:23: ^( assertionAxiom )
						{
							OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor
									.nil();
							root_1 = (OPPLSyntaxTree) this.adaptor.becomeRoot(
									stream_assertionAxiom.nextNode(), root_1);
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

	// $ANTLR end "axiom"
	public static class assertionAxiom_return extends ParserRuleReturnScope {
		OPPLSyntaxTree tree;

		@Override
		public Object getTree() {
			return this.tree;
		}
	};

	// $ANTLR start "assertionAxiom"
	// MOWLParser.g:71:1: assertionAxiom : (i= atomic ( INSTANCE_OF | TYPES )
	// expression -> ^( TYPE_ASSERTION ^( EXPRESSION expression ) ^( EXPRESSION
	// $i) ) | atomic propertyExpression value -> ^( ROLE_ASSERTION ^(
	// EXPRESSION IDENTIFIER ) ^( EXPRESSION propertyExpression ) ^( EXPRESSION
	// value ) ) | NOT assertionAxiom -> ^( NEGATED_ASSERTION assertionAxiom )
	// );
	public final OPPLParser_MOWLParser.assertionAxiom_return assertionAxiom()
			throws RecognitionException {
		OPPLParser_MOWLParser.assertionAxiom_return retval = new OPPLParser_MOWLParser.assertionAxiom_return();
		retval.start = this.input.LT(1);
		OPPLSyntaxTree root_0 = null;
		Token INSTANCE_OF4 = null;
		Token TYPES5 = null;
		Token NOT10 = null;
		OPPLParser.atomic_return i = null;
		OPPLParser_MOWLParser.expression_return expression6 = null;
		OPPLParser.atomic_return atomic7 = null;
		OPPLParser_MOWLParser.propertyExpression_return propertyExpression8 = null;
		OPPLParser_MOWLParser.value_return value9 = null;
		OPPLParser_MOWLParser.assertionAxiom_return assertionAxiom11 = null;
		OPPLSyntaxTree INSTANCE_OF4_tree = null;
		OPPLSyntaxTree TYPES5_tree = null;
		OPPLSyntaxTree NOT10_tree = null;
		RewriteRuleTokenStream stream_TYPES = new RewriteRuleTokenStream(
				this.adaptor, "token TYPES");
		RewriteRuleTokenStream stream_NOT = new RewriteRuleTokenStream(
				this.adaptor, "token NOT");
		RewriteRuleTokenStream stream_INSTANCE_OF = new RewriteRuleTokenStream(
				this.adaptor, "token INSTANCE_OF");
		RewriteRuleSubtreeStream stream_expression = new RewriteRuleSubtreeStream(
				this.adaptor, "rule expression");
		RewriteRuleSubtreeStream stream_propertyExpression = new RewriteRuleSubtreeStream(
				this.adaptor, "rule propertyExpression");
		RewriteRuleSubtreeStream stream_value = new RewriteRuleSubtreeStream(
				this.adaptor, "rule value");
		RewriteRuleSubtreeStream stream_assertionAxiom = new RewriteRuleSubtreeStream(
				this.adaptor, "rule assertionAxiom");
		RewriteRuleSubtreeStream stream_atomic = new RewriteRuleSubtreeStream(
				this.adaptor, "rule atomic");
		try {
			// MOWLParser.g:71:15: (i= atomic ( INSTANCE_OF | TYPES ) expression
			// -> ^( TYPE_ASSERTION ^( EXPRESSION expression ) ^( EXPRESSION $i)
			// ) | atomic propertyExpression value -> ^( ROLE_ASSERTION ^(
			// EXPRESSION IDENTIFIER ) ^( EXPRESSION propertyExpression ) ^(
			// EXPRESSION value ) ) | NOT assertionAxiom -> ^( NEGATED_ASSERTION
			// assertionAxiom ) )
			int alt3 = 3;
			alt3 = this.dfa3.predict(this.input);
			switch (alt3) {
			case 1:
				// MOWLParser.g:72:3: i= atomic ( INSTANCE_OF | TYPES )
				// expression
			{
				this.pushFollow(FOLLOW_atomic_in_assertionAxiom278);
				i = this.gOPPLParser.atomic();
				this.state._fsp--;
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_atomic.add(i.getTree());
				}
				// MOWLParser.g:72:14: ( INSTANCE_OF | TYPES )
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
					NoViableAltException nvae = new NoViableAltException("", 2,
							0, this.input);
					throw nvae;
				}
				switch (alt2) {
				case 1:
					// MOWLParser.g:72:15: INSTANCE_OF
				{
					INSTANCE_OF4 = (Token) this.match(this.input, INSTANCE_OF,
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
					// MOWLParser.g:72:29: TYPES
				{
					TYPES5 = (Token) this.match(this.input, TYPES,
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
				// token labels:
				// rule labels: retval, i
				// token list labels:
				// rule list labels:
				// wildcard labels:
				if (this.state.backtracking == 0) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(
							this.adaptor, "rule retval",
							retval != null ? retval.tree : null);
					RewriteRuleSubtreeStream stream_i = new RewriteRuleSubtreeStream(
							this.adaptor, "rule i", i != null ? i.tree : null);
					root_0 = (OPPLSyntaxTree) this.adaptor.nil();
					// 72:47: -> ^( TYPE_ASSERTION ^( EXPRESSION expression ) ^(
					// EXPRESSION $i) )
					{
						// MOWLParser.g:72:50: ^( TYPE_ASSERTION ^( EXPRESSION
						// expression ) ^( EXPRESSION $i) )
						{
							OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor
									.nil();
							root_1 = (OPPLSyntaxTree) this.adaptor.becomeRoot(
									this.adaptor.create(TYPE_ASSERTION,
											"TYPE_ASSERTION"), root_1);
							// MOWLParser.g:72:67: ^( EXPRESSION expression )
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
							// MOWLParser.g:72:92: ^( EXPRESSION $i)
							{
								OPPLSyntaxTree root_2 = (OPPLSyntaxTree) this.adaptor
										.nil();
								root_2 = (OPPLSyntaxTree) this.adaptor
										.becomeRoot(this.adaptor.create(
												EXPRESSION, "EXPRESSION"),
												root_2);
								this.adaptor.addChild(root_2, stream_i
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
				// MOWLParser.g:73:6: atomic propertyExpression value
			{
				this.pushFollow(FOLLOW_atomic_in_assertionAxiom314);
				atomic7 = this.gOPPLParser.atomic();
				this.state._fsp--;
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_atomic.add(atomic7.getTree());
				}
				this.pushFollow(FOLLOW_propertyExpression_in_assertionAxiom316);
				propertyExpression8 = this.propertyExpression();
				this.state._fsp--;
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_propertyExpression
							.add(propertyExpression8.getTree());
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
				// elements: value, propertyExpression
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
					// 73:39: -> ^( ROLE_ASSERTION ^( EXPRESSION IDENTIFIER ) ^(
					// EXPRESSION propertyExpression ) ^( EXPRESSION value ) )
					{
						// MOWLParser.g:73:42: ^( ROLE_ASSERTION ^( EXPRESSION
						// IDENTIFIER ) ^( EXPRESSION propertyExpression ) ^(
						// EXPRESSION value ) )
						{
							OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor
									.nil();
							root_1 = (OPPLSyntaxTree) this.adaptor.becomeRoot(
									this.adaptor.create(ROLE_ASSERTION,
											"ROLE_ASSERTION"), root_1);
							// MOWLParser.g:73:59: ^( EXPRESSION IDENTIFIER )
							{
								OPPLSyntaxTree root_2 = (OPPLSyntaxTree) this.adaptor
										.nil();
								root_2 = (OPPLSyntaxTree) this.adaptor
										.becomeRoot(this.adaptor.create(
												EXPRESSION, "EXPRESSION"),
												root_2);
								this.adaptor.addChild(root_2, this.adaptor
										.create(IDENTIFIER, "IDENTIFIER"));
								this.adaptor.addChild(root_1, root_2);
							}
							// MOWLParser.g:73:84: ^( EXPRESSION
							// propertyExpression )
							{
								OPPLSyntaxTree root_2 = (OPPLSyntaxTree) this.adaptor
										.nil();
								root_2 = (OPPLSyntaxTree) this.adaptor
										.becomeRoot(this.adaptor.create(
												EXPRESSION, "EXPRESSION"),
												root_2);
								this.adaptor.addChild(root_2,
										stream_propertyExpression.nextTree());
								this.adaptor.addChild(root_1, root_2);
							}
							// MOWLParser.g:73:117: ^( EXPRESSION value )
							{
								OPPLSyntaxTree root_2 = (OPPLSyntaxTree) this.adaptor
										.nil();
								root_2 = (OPPLSyntaxTree) this.adaptor
										.becomeRoot(this.adaptor.create(
												EXPRESSION, "EXPRESSION"),
												root_2);
								this.adaptor.addChild(root_2, stream_value
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
				// MOWLParser.g:75:5: NOT assertionAxiom
			{
				NOT10 = (Token) this.match(this.input, NOT,
						FOLLOW_NOT_in_assertionAxiom352);
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
							this.adaptor, "rule retval",
							retval != null ? retval.tree : null);
					root_0 = (OPPLSyntaxTree) this.adaptor.nil();
					// 75:24: -> ^( NEGATED_ASSERTION assertionAxiom )
					{
						// MOWLParser.g:75:27: ^( NEGATED_ASSERTION
						// assertionAxiom )
						{
							OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor
									.nil();
							root_1 = (OPPLSyntaxTree) this.adaptor.becomeRoot(
									this.adaptor.create(NEGATED_ASSERTION,
											"NEGATED_ASSERTION"), root_1);
							this.adaptor.addChild(root_1, stream_assertionAxiom
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

	// $ANTLR end "assertionAxiom"
	public static class binaryAxiom_return extends ParserRuleReturnScope {
		OPPLSyntaxTree tree;

		@Override
		public Object getTree() {
			return this.tree;
		}
	};

	// $ANTLR start "binaryAxiom"
	// MOWLParser.g:80:1: binaryAxiom options {backtrack=true; } : (lhs=
	// expression SUBCLASS_OF superClass= expression -> ^( SUB_CLASS_AXIOM ^(
	// EXPRESSION $lhs) ^( EXPRESSION $superClass) ) | lhs= expression
	// EQUIVALENT_TO rhs= expression -> ^( EQUIVALENT_TO_AXIOM ^( EXPRESSION
	// $lhs) ^( EXPRESSION $rhs) ) | lhs= expression DISJOINT_WITH disjoint=
	// expression -> ^( DISJOINT_WITH_AXIOM ^( EXPRESSION $lhs) ^( EXPRESSION
	// $disjoint) ) | lhs= expression SUB_PROPERTY_OF superProperty=
	// propertyExpression -> ^( SUB_PROPERTY_AXIOM ^( EXPRESSION $lhs) ^(
	// EXPRESSION $superProperty) ) | lhsID= atomic INVERSE_OF rhsAtomic= atomic
	// -> ^( INVERSE_OF ^( EXPRESSION $lhsID) ^( EXPRESSION $rhsAtomic) ) |
	// lhsID= atomic SAME_AS rhsID= atomic -> ^( SAME_AS_AXIOM ^( EXPRESSION
	// $lhsID) ^( EXPRESSION $rhsID) ) | lhsID= atomic DIFFERENT_FROM rhsID=
	// atomic -> ^( DIFFERENT_FROM_AXIOM ^( EXPRESSION $lhsID) ^( EXPRESSION
	// $rhsID) ) | lhsID= atomic DOMAIN expression -> ^( DOMAIN ^( EXPRESSION
	// $lhsID) ^( EXPRESSION expression ) ) | lhsID= atomic RANGE expression ->
	// ^( RANGE ^( EXPRESSION $lhsID) ^( EXPRESSION expression ) ) );
	public final OPPLParser_MOWLParser.binaryAxiom_return binaryAxiom()
			throws RecognitionException {
		OPPLParser_MOWLParser.binaryAxiom_return retval = new OPPLParser_MOWLParser.binaryAxiom_return();
		retval.start = this.input.LT(1);
		OPPLSyntaxTree root_0 = null;
		Token SUBCLASS_OF12 = null;
		Token EQUIVALENT_TO13 = null;
		Token DISJOINT_WITH14 = null;
		Token SUB_PROPERTY_OF15 = null;
		Token INVERSE_OF16 = null;
		Token SAME_AS17 = null;
		Token DIFFERENT_FROM18 = null;
		Token DOMAIN19 = null;
		Token RANGE21 = null;
		OPPLParser_MOWLParser.expression_return lhs = null;
		OPPLParser_MOWLParser.expression_return superClass = null;
		OPPLParser_MOWLParser.expression_return rhs = null;
		OPPLParser_MOWLParser.expression_return disjoint = null;
		OPPLParser_MOWLParser.propertyExpression_return superProperty = null;
		OPPLParser.atomic_return lhsID = null;
		OPPLParser.atomic_return rhsAtomic = null;
		OPPLParser.atomic_return rhsID = null;
		OPPLParser_MOWLParser.expression_return expression20 = null;
		OPPLParser_MOWLParser.expression_return expression22 = null;
		OPPLSyntaxTree SUBCLASS_OF12_tree = null;
		OPPLSyntaxTree EQUIVALENT_TO13_tree = null;
		OPPLSyntaxTree DISJOINT_WITH14_tree = null;
		OPPLSyntaxTree SUB_PROPERTY_OF15_tree = null;
		OPPLSyntaxTree INVERSE_OF16_tree = null;
		OPPLSyntaxTree SAME_AS17_tree = null;
		OPPLSyntaxTree DIFFERENT_FROM18_tree = null;
		OPPLSyntaxTree DOMAIN19_tree = null;
		OPPLSyntaxTree RANGE21_tree = null;
		RewriteRuleTokenStream stream_RANGE = new RewriteRuleTokenStream(
				this.adaptor, "token RANGE");
		RewriteRuleTokenStream stream_SAME_AS = new RewriteRuleTokenStream(
				this.adaptor, "token SAME_AS");
		RewriteRuleTokenStream stream_DISJOINT_WITH = new RewriteRuleTokenStream(
				this.adaptor, "token DISJOINT_WITH");
		RewriteRuleTokenStream stream_INVERSE_OF = new RewriteRuleTokenStream(
				this.adaptor, "token INVERSE_OF");
		RewriteRuleTokenStream stream_DIFFERENT_FROM = new RewriteRuleTokenStream(
				this.adaptor, "token DIFFERENT_FROM");
		RewriteRuleTokenStream stream_EQUIVALENT_TO = new RewriteRuleTokenStream(
				this.adaptor, "token EQUIVALENT_TO");
		RewriteRuleTokenStream stream_SUBCLASS_OF = new RewriteRuleTokenStream(
				this.adaptor, "token SUBCLASS_OF");
		RewriteRuleTokenStream stream_DOMAIN = new RewriteRuleTokenStream(
				this.adaptor, "token DOMAIN");
		RewriteRuleTokenStream stream_SUB_PROPERTY_OF = new RewriteRuleTokenStream(
				this.adaptor, "token SUB_PROPERTY_OF");
		RewriteRuleSubtreeStream stream_expression = new RewriteRuleSubtreeStream(
				this.adaptor, "rule expression");
		RewriteRuleSubtreeStream stream_propertyExpression = new RewriteRuleSubtreeStream(
				this.adaptor, "rule propertyExpression");
		RewriteRuleSubtreeStream stream_atomic = new RewriteRuleSubtreeStream(
				this.adaptor, "rule atomic");
		try {
			// MOWLParser.g:82:26: (lhs= expression SUBCLASS_OF superClass=
			// expression -> ^( SUB_CLASS_AXIOM ^( EXPRESSION $lhs) ^(
			// EXPRESSION $superClass) ) | lhs= expression EQUIVALENT_TO rhs=
			// expression -> ^( EQUIVALENT_TO_AXIOM ^( EXPRESSION $lhs) ^(
			// EXPRESSION $rhs) ) | lhs= expression DISJOINT_WITH disjoint=
			// expression -> ^( DISJOINT_WITH_AXIOM ^( EXPRESSION $lhs) ^(
			// EXPRESSION $disjoint) ) | lhs= expression SUB_PROPERTY_OF
			// superProperty= propertyExpression -> ^( SUB_PROPERTY_AXIOM ^(
			// EXPRESSION $lhs) ^( EXPRESSION $superProperty) ) | lhsID= atomic
			// INVERSE_OF rhsAtomic= atomic -> ^( INVERSE_OF ^( EXPRESSION
			// $lhsID) ^( EXPRESSION $rhsAtomic) ) | lhsID= atomic SAME_AS
			// rhsID= atomic -> ^( SAME_AS_AXIOM ^( EXPRESSION $lhsID) ^(
			// EXPRESSION $rhsID) ) | lhsID= atomic DIFFERENT_FROM rhsID= atomic
			// -> ^( DIFFERENT_FROM_AXIOM ^( EXPRESSION $lhsID) ^( EXPRESSION
			// $rhsID) ) | lhsID= atomic DOMAIN expression -> ^( DOMAIN ^(
			// EXPRESSION $lhsID) ^( EXPRESSION expression ) ) | lhsID= atomic
			// RANGE expression -> ^( RANGE ^( EXPRESSION $lhsID) ^( EXPRESSION
			// expression ) ) )
			int alt4 = 9;
			alt4 = this.dfa4.predict(this.input);
			switch (alt4) {
			case 1:
				// MOWLParser.g:83:2: lhs= expression SUBCLASS_OF superClass=
				// expression
			{
				this.pushFollow(FOLLOW_expression_in_binaryAxiom393);
				lhs = this.expression();
				this.state._fsp--;
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_expression.add(lhs.getTree());
				}
				SUBCLASS_OF12 = (Token) this.match(this.input, SUBCLASS_OF,
						FOLLOW_SUBCLASS_OF_in_binaryAxiom395);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_SUBCLASS_OF.add(SUBCLASS_OF12);
				}
				this.pushFollow(FOLLOW_expression_in_binaryAxiom402);
				superClass = this.expression();
				this.state._fsp--;
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_expression.add(superClass.getTree());
				}
				// AST REWRITE
				// elements: lhs, superClass
				// token labels:
				// rule labels: retval, superClass, lhs
				// token list labels:
				// rule list labels:
				// wildcard labels:
				if (this.state.backtracking == 0) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(
							this.adaptor, "rule retval",
							retval != null ? retval.tree : null);
					RewriteRuleSubtreeStream stream_superClass = new RewriteRuleSubtreeStream(
							this.adaptor, "rule superClass",
							superClass != null ? superClass.tree : null);
					RewriteRuleSubtreeStream stream_lhs = new RewriteRuleSubtreeStream(
							this.adaptor, "rule lhs", lhs != null ? lhs.tree
									: null);
					root_0 = (OPPLSyntaxTree) this.adaptor.nil();
					// 83:57: -> ^( SUB_CLASS_AXIOM ^( EXPRESSION $lhs) ^(
					// EXPRESSION $superClass) )
					{
						// MOWLParser.g:83:60: ^( SUB_CLASS_AXIOM ^( EXPRESSION
						// $lhs) ^( EXPRESSION $superClass) )
						{
							OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor
									.nil();
							root_1 = (OPPLSyntaxTree) this.adaptor.becomeRoot(
									this.adaptor.create(SUB_CLASS_AXIOM,
											"SUB_CLASS_AXIOM"), root_1);
							// MOWLParser.g:83:79: ^( EXPRESSION $lhs)
							{
								OPPLSyntaxTree root_2 = (OPPLSyntaxTree) this.adaptor
										.nil();
								root_2 = (OPPLSyntaxTree) this.adaptor
										.becomeRoot(this.adaptor.create(
												EXPRESSION, "EXPRESSION"),
												root_2);
								this.adaptor.addChild(root_2, stream_lhs
										.nextTree());
								this.adaptor.addChild(root_1, root_2);
							}
							// MOWLParser.g:83:98: ^( EXPRESSION $superClass)
							{
								OPPLSyntaxTree root_2 = (OPPLSyntaxTree) this.adaptor
										.nil();
								root_2 = (OPPLSyntaxTree) this.adaptor
										.becomeRoot(this.adaptor.create(
												EXPRESSION, "EXPRESSION"),
												root_2);
								this.adaptor.addChild(root_2, stream_superClass
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
				// MOWLParser.g:84:11: lhs= expression EQUIVALENT_TO rhs=
				// expression
			{
				this.pushFollow(FOLLOW_expression_in_binaryAxiom440);
				lhs = this.expression();
				this.state._fsp--;
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_expression.add(lhs.getTree());
				}
				EQUIVALENT_TO13 = (Token) this.match(this.input, EQUIVALENT_TO,
						FOLLOW_EQUIVALENT_TO_in_binaryAxiom442);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_EQUIVALENT_TO.add(EQUIVALENT_TO13);
				}
				this.pushFollow(FOLLOW_expression_in_binaryAxiom448);
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
							this.adaptor, "rule retval",
							retval != null ? retval.tree : null);
					RewriteRuleSubtreeStream stream_rhs = new RewriteRuleSubtreeStream(
							this.adaptor, "rule rhs", rhs != null ? rhs.tree
									: null);
					RewriteRuleSubtreeStream stream_lhs = new RewriteRuleSubtreeStream(
							this.adaptor, "rule lhs", lhs != null ? lhs.tree
									: null);
					root_0 = (OPPLSyntaxTree) this.adaptor.nil();
					// 84:60: -> ^( EQUIVALENT_TO_AXIOM ^( EXPRESSION $lhs) ^(
					// EXPRESSION $rhs) )
					{
						// MOWLParser.g:84:63: ^( EQUIVALENT_TO_AXIOM ^(
						// EXPRESSION $lhs) ^( EXPRESSION $rhs) )
						{
							OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor
									.nil();
							root_1 = (OPPLSyntaxTree) this.adaptor.becomeRoot(
									this.adaptor.create(EQUIVALENT_TO_AXIOM,
											"EQUIVALENT_TO_AXIOM"), root_1);
							// MOWLParser.g:84:85: ^( EXPRESSION $lhs)
							{
								OPPLSyntaxTree root_2 = (OPPLSyntaxTree) this.adaptor
										.nil();
								root_2 = (OPPLSyntaxTree) this.adaptor
										.becomeRoot(this.adaptor.create(
												EXPRESSION, "EXPRESSION"),
												root_2);
								this.adaptor.addChild(root_2, stream_lhs
										.nextTree());
								this.adaptor.addChild(root_1, root_2);
							}
							// MOWLParser.g:84:104: ^( EXPRESSION $rhs)
							{
								OPPLSyntaxTree root_2 = (OPPLSyntaxTree) this.adaptor
										.nil();
								root_2 = (OPPLSyntaxTree) this.adaptor
										.becomeRoot(this.adaptor.create(
												EXPRESSION, "EXPRESSION"),
												root_2);
								this.adaptor.addChild(root_2, stream_rhs
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
				// MOWLParser.g:85:11: lhs= expression DISJOINT_WITH disjoint=
				// expression
			{
				this.pushFollow(FOLLOW_expression_in_binaryAxiom485);
				lhs = this.expression();
				this.state._fsp--;
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_expression.add(lhs.getTree());
				}
				DISJOINT_WITH14 = (Token) this.match(this.input, DISJOINT_WITH,
						FOLLOW_DISJOINT_WITH_in_binaryAxiom487);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_DISJOINT_WITH.add(DISJOINT_WITH14);
				}
				this.pushFollow(FOLLOW_expression_in_binaryAxiom493);
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
							this.adaptor, "rule retval",
							retval != null ? retval.tree : null);
					RewriteRuleSubtreeStream stream_disjoint = new RewriteRuleSubtreeStream(
							this.adaptor, "rule disjoint",
							disjoint != null ? disjoint.tree : null);
					RewriteRuleSubtreeStream stream_lhs = new RewriteRuleSubtreeStream(
							this.adaptor, "rule lhs", lhs != null ? lhs.tree
									: null);
					root_0 = (OPPLSyntaxTree) this.adaptor.nil();
					// 85:65: -> ^( DISJOINT_WITH_AXIOM ^( EXPRESSION $lhs) ^(
					// EXPRESSION $disjoint) )
					{
						// MOWLParser.g:85:68: ^( DISJOINT_WITH_AXIOM ^(
						// EXPRESSION $lhs) ^( EXPRESSION $disjoint) )
						{
							OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor
									.nil();
							root_1 = (OPPLSyntaxTree) this.adaptor.becomeRoot(
									this.adaptor.create(DISJOINT_WITH_AXIOM,
											"DISJOINT_WITH_AXIOM"), root_1);
							// MOWLParser.g:85:90: ^( EXPRESSION $lhs)
							{
								OPPLSyntaxTree root_2 = (OPPLSyntaxTree) this.adaptor
										.nil();
								root_2 = (OPPLSyntaxTree) this.adaptor
										.becomeRoot(this.adaptor.create(
												EXPRESSION, "EXPRESSION"),
												root_2);
								this.adaptor.addChild(root_2, stream_lhs
										.nextTree());
								this.adaptor.addChild(root_1, root_2);
							}
							// MOWLParser.g:85:109: ^( EXPRESSION $disjoint)
							{
								OPPLSyntaxTree root_2 = (OPPLSyntaxTree) this.adaptor
										.nil();
								root_2 = (OPPLSyntaxTree) this.adaptor
										.becomeRoot(this.adaptor.create(
												EXPRESSION, "EXPRESSION"),
												root_2);
								this.adaptor.addChild(root_2, stream_disjoint
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
			case 4:
				// MOWLParser.g:86:11: lhs= expression SUB_PROPERTY_OF
				// superProperty= propertyExpression
			{
				this.pushFollow(FOLLOW_expression_in_binaryAxiom530);
				lhs = this.expression();
				this.state._fsp--;
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_expression.add(lhs.getTree());
				}
				SUB_PROPERTY_OF15 = (Token) this.match(this.input,
						SUB_PROPERTY_OF,
						FOLLOW_SUB_PROPERTY_OF_in_binaryAxiom532);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_SUB_PROPERTY_OF.add(SUB_PROPERTY_OF15);
				}
				this.pushFollow(FOLLOW_propertyExpression_in_binaryAxiom538);
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
							this.adaptor, "rule retval",
							retval != null ? retval.tree : null);
					RewriteRuleSubtreeStream stream_superProperty = new RewriteRuleSubtreeStream(
							this.adaptor, "rule superProperty",
							superProperty != null ? superProperty.tree : null);
					RewriteRuleSubtreeStream stream_lhs = new RewriteRuleSubtreeStream(
							this.adaptor, "rule lhs", lhs != null ? lhs.tree
									: null);
					root_0 = (OPPLSyntaxTree) this.adaptor.nil();
					// 86:80: -> ^( SUB_PROPERTY_AXIOM ^( EXPRESSION $lhs) ^(
					// EXPRESSION $superProperty) )
					{
						// MOWLParser.g:86:83: ^( SUB_PROPERTY_AXIOM ^(
						// EXPRESSION $lhs) ^( EXPRESSION $superProperty) )
						{
							OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor
									.nil();
							root_1 = (OPPLSyntaxTree) this.adaptor.becomeRoot(
									this.adaptor.create(SUB_PROPERTY_AXIOM,
											"SUB_PROPERTY_AXIOM"), root_1);
							// MOWLParser.g:86:104: ^( EXPRESSION $lhs)
							{
								OPPLSyntaxTree root_2 = (OPPLSyntaxTree) this.adaptor
										.nil();
								root_2 = (OPPLSyntaxTree) this.adaptor
										.becomeRoot(this.adaptor.create(
												EXPRESSION, "EXPRESSION"),
												root_2);
								this.adaptor.addChild(root_2, stream_lhs
										.nextTree());
								this.adaptor.addChild(root_1, root_2);
							}
							// MOWLParser.g:86:123: ^( EXPRESSION
							// $superProperty)
							{
								OPPLSyntaxTree root_2 = (OPPLSyntaxTree) this.adaptor
										.nil();
								root_2 = (OPPLSyntaxTree) this.adaptor
										.becomeRoot(this.adaptor.create(
												EXPRESSION, "EXPRESSION"),
												root_2);
								this.adaptor.addChild(root_2,
										stream_superProperty.nextTree());
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
				// MOWLParser.g:87:11: lhsID= atomic INVERSE_OF rhsAtomic=
				// atomic
			{
				this.pushFollow(FOLLOW_atomic_in_binaryAxiom575);
				lhsID = this.gOPPLParser.atomic();
				this.state._fsp--;
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_atomic.add(lhsID.getTree());
				}
				INVERSE_OF16 = (Token) this.match(this.input, INVERSE_OF,
						FOLLOW_INVERSE_OF_in_binaryAxiom577);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_INVERSE_OF.add(INVERSE_OF16);
				}
				this.pushFollow(FOLLOW_atomic_in_binaryAxiom583);
				rhsAtomic = this.gOPPLParser.atomic();
				this.state._fsp--;
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_atomic.add(rhsAtomic.getTree());
				}
				// AST REWRITE
				// elements: rhsAtomic, INVERSE_OF, lhsID
				// token labels:
				// rule labels: lhsID, retval, rhsAtomic
				// token list labels:
				// rule list labels:
				// wildcard labels:
				if (this.state.backtracking == 0) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_lhsID = new RewriteRuleSubtreeStream(
							this.adaptor, "rule lhsID",
							lhsID != null ? lhsID.tree : null);
					RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(
							this.adaptor, "rule retval",
							retval != null ? retval.tree : null);
					RewriteRuleSubtreeStream stream_rhsAtomic = new RewriteRuleSubtreeStream(
							this.adaptor, "rule rhsAtomic",
							rhsAtomic != null ? rhsAtomic.tree : null);
					root_0 = (OPPLSyntaxTree) this.adaptor.nil();
					// 87:57: -> ^( INVERSE_OF ^( EXPRESSION $lhsID) ^(
					// EXPRESSION $rhsAtomic) )
					{
						// MOWLParser.g:87:60: ^( INVERSE_OF ^( EXPRESSION
						// $lhsID) ^( EXPRESSION $rhsAtomic) )
						{
							OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor
									.nil();
							root_1 = (OPPLSyntaxTree) this.adaptor.becomeRoot(
									stream_INVERSE_OF.nextNode(), root_1);
							// MOWLParser.g:87:73: ^( EXPRESSION $lhsID)
							{
								OPPLSyntaxTree root_2 = (OPPLSyntaxTree) this.adaptor
										.nil();
								root_2 = (OPPLSyntaxTree) this.adaptor
										.becomeRoot(this.adaptor.create(
												EXPRESSION, "EXPRESSION"),
												root_2);
								this.adaptor.addChild(root_2, stream_lhsID
										.nextTree());
								this.adaptor.addChild(root_1, root_2);
							}
							// MOWLParser.g:87:94: ^( EXPRESSION $rhsAtomic)
							{
								OPPLSyntaxTree root_2 = (OPPLSyntaxTree) this.adaptor
										.nil();
								root_2 = (OPPLSyntaxTree) this.adaptor
										.becomeRoot(this.adaptor.create(
												EXPRESSION, "EXPRESSION"),
												root_2);
								this.adaptor.addChild(root_2, stream_rhsAtomic
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
			case 6:
				// MOWLParser.g:88:3: lhsID= atomic SAME_AS rhsID= atomic
			{
				this.pushFollow(FOLLOW_atomic_in_binaryAxiom614);
				lhsID = this.gOPPLParser.atomic();
				this.state._fsp--;
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_atomic.add(lhsID.getTree());
				}
				SAME_AS17 = (Token) this.match(this.input, SAME_AS,
						FOLLOW_SAME_AS_in_binaryAxiom616);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_SAME_AS.add(SAME_AS17);
				}
				this.pushFollow(FOLLOW_atomic_in_binaryAxiom623);
				rhsID = this.gOPPLParser.atomic();
				this.state._fsp--;
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_atomic.add(rhsID.getTree());
				}
				// AST REWRITE
				// elements: rhsID, lhsID
				// token labels:
				// rule labels: lhsID, retval, rhsID
				// token list labels:
				// rule list labels:
				// wildcard labels:
				if (this.state.backtracking == 0) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_lhsID = new RewriteRuleSubtreeStream(
							this.adaptor, "rule lhsID",
							lhsID != null ? lhsID.tree : null);
					RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(
							this.adaptor, "rule retval",
							retval != null ? retval.tree : null);
					RewriteRuleSubtreeStream stream_rhsID = new RewriteRuleSubtreeStream(
							this.adaptor, "rule rhsID",
							rhsID != null ? rhsID.tree : null);
					root_0 = (OPPLSyntaxTree) this.adaptor.nil();
					// 88:43: -> ^( SAME_AS_AXIOM ^( EXPRESSION $lhsID) ^(
					// EXPRESSION $rhsID) )
					{
						// MOWLParser.g:88:46: ^( SAME_AS_AXIOM ^( EXPRESSION
						// $lhsID) ^( EXPRESSION $rhsID) )
						{
							OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor
									.nil();
							root_1 = (OPPLSyntaxTree) this.adaptor.becomeRoot(
									this.adaptor.create(SAME_AS_AXIOM,
											"SAME_AS_AXIOM"), root_1);
							// MOWLParser.g:88:62: ^( EXPRESSION $lhsID)
							{
								OPPLSyntaxTree root_2 = (OPPLSyntaxTree) this.adaptor
										.nil();
								root_2 = (OPPLSyntaxTree) this.adaptor
										.becomeRoot(this.adaptor.create(
												EXPRESSION, "EXPRESSION"),
												root_2);
								this.adaptor.addChild(root_2, stream_lhsID
										.nextTree());
								this.adaptor.addChild(root_1, root_2);
							}
							// MOWLParser.g:88:84: ^( EXPRESSION $rhsID)
							{
								OPPLSyntaxTree root_2 = (OPPLSyntaxTree) this.adaptor
										.nil();
								root_2 = (OPPLSyntaxTree) this.adaptor
										.becomeRoot(this.adaptor.create(
												EXPRESSION, "EXPRESSION"),
												root_2);
								this.adaptor.addChild(root_2, stream_rhsID
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
			case 7:
				// MOWLParser.g:89:11: lhsID= atomic DIFFERENT_FROM rhsID=
				// atomic
			{
				this.pushFollow(FOLLOW_atomic_in_binaryAxiom661);
				lhsID = this.gOPPLParser.atomic();
				this.state._fsp--;
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_atomic.add(lhsID.getTree());
				}
				DIFFERENT_FROM18 = (Token) this
						.match(this.input, DIFFERENT_FROM,
								FOLLOW_DIFFERENT_FROM_in_binaryAxiom663);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_DIFFERENT_FROM.add(DIFFERENT_FROM18);
				}
				this.pushFollow(FOLLOW_atomic_in_binaryAxiom670);
				rhsID = this.gOPPLParser.atomic();
				this.state._fsp--;
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_atomic.add(rhsID.getTree());
				}
				// AST REWRITE
				// elements: rhsID, lhsID
				// token labels:
				// rule labels: lhsID, retval, rhsID
				// token list labels:
				// rule list labels:
				// wildcard labels:
				if (this.state.backtracking == 0) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_lhsID = new RewriteRuleSubtreeStream(
							this.adaptor, "rule lhsID",
							lhsID != null ? lhsID.tree : null);
					RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(
							this.adaptor, "rule retval",
							retval != null ? retval.tree : null);
					RewriteRuleSubtreeStream stream_rhsID = new RewriteRuleSubtreeStream(
							this.adaptor, "rule rhsID",
							rhsID != null ? rhsID.tree : null);
					root_0 = (OPPLSyntaxTree) this.adaptor.nil();
					// 89:58: -> ^( DIFFERENT_FROM_AXIOM ^( EXPRESSION $lhsID)
					// ^( EXPRESSION $rhsID) )
					{
						// MOWLParser.g:89:61: ^( DIFFERENT_FROM_AXIOM ^(
						// EXPRESSION $lhsID) ^( EXPRESSION $rhsID) )
						{
							OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor
									.nil();
							root_1 = (OPPLSyntaxTree) this.adaptor.becomeRoot(
									this.adaptor.create(DIFFERENT_FROM_AXIOM,
											"DIFFERENT_FROM_AXIOM"), root_1);
							// MOWLParser.g:89:84: ^( EXPRESSION $lhsID)
							{
								OPPLSyntaxTree root_2 = (OPPLSyntaxTree) this.adaptor
										.nil();
								root_2 = (OPPLSyntaxTree) this.adaptor
										.becomeRoot(this.adaptor.create(
												EXPRESSION, "EXPRESSION"),
												root_2);
								this.adaptor.addChild(root_2, stream_lhsID
										.nextTree());
								this.adaptor.addChild(root_1, root_2);
							}
							// MOWLParser.g:89:105: ^( EXPRESSION $rhsID)
							{
								OPPLSyntaxTree root_2 = (OPPLSyntaxTree) this.adaptor
										.nil();
								root_2 = (OPPLSyntaxTree) this.adaptor
										.becomeRoot(this.adaptor.create(
												EXPRESSION, "EXPRESSION"),
												root_2);
								this.adaptor.addChild(root_2, stream_rhsID
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
			case 8:
				// MOWLParser.g:90:11: lhsID= atomic DOMAIN expression
			{
				this.pushFollow(FOLLOW_atomic_in_binaryAxiom707);
				lhsID = this.gOPPLParser.atomic();
				this.state._fsp--;
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_atomic.add(lhsID.getTree());
				}
				DOMAIN19 = (Token) this.match(this.input, DOMAIN,
						FOLLOW_DOMAIN_in_binaryAxiom710);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_DOMAIN.add(DOMAIN19);
				}
				this.pushFollow(FOLLOW_expression_in_binaryAxiom712);
				expression20 = this.expression();
				this.state._fsp--;
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_expression.add(expression20.getTree());
				}
				// AST REWRITE
				// elements: expression, lhsID, DOMAIN
				// token labels:
				// rule labels: lhsID, retval
				// token list labels:
				// rule list labels:
				// wildcard labels:
				if (this.state.backtracking == 0) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_lhsID = new RewriteRuleSubtreeStream(
							this.adaptor, "rule lhsID",
							lhsID != null ? lhsID.tree : null);
					RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(
							this.adaptor, "rule retval",
							retval != null ? retval.tree : null);
					root_0 = (OPPLSyntaxTree) this.adaptor.nil();
					// 90:46: -> ^( DOMAIN ^( EXPRESSION $lhsID) ^( EXPRESSION
					// expression ) )
					{
						// MOWLParser.g:90:49: ^( DOMAIN ^( EXPRESSION $lhsID)
						// ^( EXPRESSION expression ) )
						{
							OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor
									.nil();
							root_1 = (OPPLSyntaxTree) this.adaptor.becomeRoot(
									stream_DOMAIN.nextNode(), root_1);
							// MOWLParser.g:90:58: ^( EXPRESSION $lhsID)
							{
								OPPLSyntaxTree root_2 = (OPPLSyntaxTree) this.adaptor
										.nil();
								root_2 = (OPPLSyntaxTree) this.adaptor
										.becomeRoot(this.adaptor.create(
												EXPRESSION, "EXPRESSION"),
												root_2);
								this.adaptor.addChild(root_2, stream_lhsID
										.nextTree());
								this.adaptor.addChild(root_1, root_2);
							}
							// MOWLParser.g:90:79: ^( EXPRESSION expression )
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
			case 9:
				// MOWLParser.g:91:11: lhsID= atomic RANGE expression
			{
				this.pushFollow(FOLLOW_atomic_in_binaryAxiom748);
				lhsID = this.gOPPLParser.atomic();
				this.state._fsp--;
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_atomic.add(lhsID.getTree());
				}
				RANGE21 = (Token) this.match(this.input, RANGE,
						FOLLOW_RANGE_in_binaryAxiom750);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_RANGE.add(RANGE21);
				}
				this.pushFollow(FOLLOW_expression_in_binaryAxiom752);
				expression22 = this.expression();
				this.state._fsp--;
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_expression.add(expression22.getTree());
				}
				// AST REWRITE
				// elements: expression, RANGE, lhsID
				// token labels:
				// rule labels: lhsID, retval
				// token list labels:
				// rule list labels:
				// wildcard labels:
				if (this.state.backtracking == 0) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_lhsID = new RewriteRuleSubtreeStream(
							this.adaptor, "rule lhsID",
							lhsID != null ? lhsID.tree : null);
					RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(
							this.adaptor, "rule retval",
							retval != null ? retval.tree : null);
					root_0 = (OPPLSyntaxTree) this.adaptor.nil();
					// 91:44: -> ^( RANGE ^( EXPRESSION $lhsID) ^( EXPRESSION
					// expression ) )
					{
						// MOWLParser.g:91:47: ^( RANGE ^( EXPRESSION $lhsID) ^(
						// EXPRESSION expression ) )
						{
							OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor
									.nil();
							root_1 = (OPPLSyntaxTree) this.adaptor.becomeRoot(
									stream_RANGE.nextNode(), root_1);
							// MOWLParser.g:91:55: ^( EXPRESSION $lhsID)
							{
								OPPLSyntaxTree root_2 = (OPPLSyntaxTree) this.adaptor
										.nil();
								root_2 = (OPPLSyntaxTree) this.adaptor
										.becomeRoot(this.adaptor.create(
												EXPRESSION, "EXPRESSION"),
												root_2);
								this.adaptor.addChild(root_2, stream_lhsID
										.nextTree());
								this.adaptor.addChild(root_1, root_2);
							}
							// MOWLParser.g:91:76: ^( EXPRESSION expression )
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

	// $ANTLR end "binaryAxiom"
	public static class unaryAxiom_return extends ParserRuleReturnScope {
		OPPLSyntaxTree tree;

		@Override
		public Object getTree() {
			return this.tree;
		}
	};

	// $ANTLR start "unaryAxiom"
	// MOWLParser.g:95:1: unaryAxiom : unaryCharacteristic unary -> ^(
	// UNARY_AXIOM unaryCharacteristic ^( EXPRESSION unary ) ) ;
	public final OPPLParser_MOWLParser.unaryAxiom_return unaryAxiom()
			throws RecognitionException {
		OPPLParser_MOWLParser.unaryAxiom_return retval = new OPPLParser_MOWLParser.unaryAxiom_return();
		retval.start = this.input.LT(1);
		OPPLSyntaxTree root_0 = null;
		OPPLParser_MOWLParser.unaryCharacteristic_return unaryCharacteristic23 = null;
		OPPLParser_MOWLParser.unary_return unary24 = null;
		RewriteRuleSubtreeStream stream_unary = new RewriteRuleSubtreeStream(
				this.adaptor, "rule unary");
		RewriteRuleSubtreeStream stream_unaryCharacteristic = new RewriteRuleSubtreeStream(
				this.adaptor, "rule unaryCharacteristic");
		try {
			// MOWLParser.g:95:13: ( unaryCharacteristic unary -> ^( UNARY_AXIOM
			// unaryCharacteristic ^( EXPRESSION unary ) ) )
			// MOWLParser.g:96:4: unaryCharacteristic unary
			{
				this.pushFollow(FOLLOW_unaryCharacteristic_in_unaryAxiom826);
				unaryCharacteristic23 = this.unaryCharacteristic();
				this.state._fsp--;
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_unaryCharacteristic.add(unaryCharacteristic23
							.getTree());
				}
				this.pushFollow(FOLLOW_unary_in_unaryAxiom830);
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
							this.adaptor, "rule retval",
							retval != null ? retval.tree : null);
					root_0 = (OPPLSyntaxTree) this.adaptor.nil();
					// 96:32: -> ^( UNARY_AXIOM unaryCharacteristic ^(
					// EXPRESSION unary ) )
					{
						// MOWLParser.g:96:35: ^( UNARY_AXIOM
						// unaryCharacteristic ^( EXPRESSION unary ) )
						{
							OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor
									.nil();
							root_1 = (OPPLSyntaxTree) this.adaptor.becomeRoot(
									this.adaptor.create(UNARY_AXIOM,
											"UNARY_AXIOM"), root_1);
							this.adaptor.addChild(root_1,
									stream_unaryCharacteristic.nextTree());
							// MOWLParser.g:96:69: ^( EXPRESSION unary )
							{
								OPPLSyntaxTree root_2 = (OPPLSyntaxTree) this.adaptor
										.nil();
								root_2 = (OPPLSyntaxTree) this.adaptor
										.becomeRoot(this.adaptor.create(
												EXPRESSION, "EXPRESSION"),
												root_2);
								this.adaptor.addChild(root_2, stream_unary
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

	// $ANTLR end "unaryAxiom"
	public static class unaryCharacteristic_return extends
			ParserRuleReturnScope {
		OPPLSyntaxTree tree;

		@Override
		public Object getTree() {
			return this.tree;
		}
	};

	// $ANTLR start "unaryCharacteristic"
	// MOWLParser.g:99:1: unaryCharacteristic : ( FUNCTIONAL -> ^( FUNCTIONAL )
	// | INVERSE_FUNCTIONAL -> ^( INVERSE_FUNCTIONAL ) | SYMMETRIC -> ^(
	// SYMMETRIC ) | ANTI_SYMMETRIC -> ^( ANTI_SYMMETRIC ) | REFLEXIVE -> ^(
	// REFLEXIVE ) | IRREFLEXIVE -> ^( IRREFLEXIVE ) | TRANSITIVE -> ^(
	// TRANSITIVE ) );
	public final OPPLParser_MOWLParser.unaryCharacteristic_return unaryCharacteristic()
			throws RecognitionException {
		OPPLParser_MOWLParser.unaryCharacteristic_return retval = new OPPLParser_MOWLParser.unaryCharacteristic_return();
		retval.start = this.input.LT(1);
		OPPLSyntaxTree root_0 = null;
		Token FUNCTIONAL25 = null;
		Token INVERSE_FUNCTIONAL26 = null;
		Token SYMMETRIC27 = null;
		Token ANTI_SYMMETRIC28 = null;
		Token REFLEXIVE29 = null;
		Token IRREFLEXIVE30 = null;
		Token TRANSITIVE31 = null;
		OPPLSyntaxTree FUNCTIONAL25_tree = null;
		OPPLSyntaxTree INVERSE_FUNCTIONAL26_tree = null;
		OPPLSyntaxTree SYMMETRIC27_tree = null;
		OPPLSyntaxTree ANTI_SYMMETRIC28_tree = null;
		OPPLSyntaxTree REFLEXIVE29_tree = null;
		OPPLSyntaxTree IRREFLEXIVE30_tree = null;
		OPPLSyntaxTree TRANSITIVE31_tree = null;
		RewriteRuleTokenStream stream_REFLEXIVE = new RewriteRuleTokenStream(
				this.adaptor, "token REFLEXIVE");
		RewriteRuleTokenStream stream_SYMMETRIC = new RewriteRuleTokenStream(
				this.adaptor, "token SYMMETRIC");
		RewriteRuleTokenStream stream_FUNCTIONAL = new RewriteRuleTokenStream(
				this.adaptor, "token FUNCTIONAL");
		RewriteRuleTokenStream stream_TRANSITIVE = new RewriteRuleTokenStream(
				this.adaptor, "token TRANSITIVE");
		RewriteRuleTokenStream stream_ANTI_SYMMETRIC = new RewriteRuleTokenStream(
				this.adaptor, "token ANTI_SYMMETRIC");
		RewriteRuleTokenStream stream_INVERSE_FUNCTIONAL = new RewriteRuleTokenStream(
				this.adaptor, "token INVERSE_FUNCTIONAL");
		RewriteRuleTokenStream stream_IRREFLEXIVE = new RewriteRuleTokenStream(
				this.adaptor, "token IRREFLEXIVE");
		try {
			// MOWLParser.g:99:21: ( FUNCTIONAL -> ^( FUNCTIONAL ) |
			// INVERSE_FUNCTIONAL -> ^( INVERSE_FUNCTIONAL ) | SYMMETRIC -> ^(
			// SYMMETRIC ) | ANTI_SYMMETRIC -> ^( ANTI_SYMMETRIC ) | REFLEXIVE
			// -> ^( REFLEXIVE ) | IRREFLEXIVE -> ^( IRREFLEXIVE ) | TRANSITIVE
			// -> ^( TRANSITIVE ) )
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
				NoViableAltException nvae = new NoViableAltException("", 5, 0,
						this.input);
				throw nvae;
			}
			switch (alt5) {
			case 1:
				// MOWLParser.g:100:5: FUNCTIONAL
			{
				FUNCTIONAL25 = (Token) this.match(this.input, FUNCTIONAL,
						FOLLOW_FUNCTIONAL_in_unaryCharacteristic875);
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
							this.adaptor, "rule retval",
							retval != null ? retval.tree : null);
					root_0 = (OPPLSyntaxTree) this.adaptor.nil();
					// 100:16: -> ^( FUNCTIONAL )
					{
						// MOWLParser.g:100:19: ^( FUNCTIONAL )
						{
							OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor
									.nil();
							root_1 = (OPPLSyntaxTree) this.adaptor.becomeRoot(
									stream_FUNCTIONAL.nextNode(), root_1);
							this.adaptor.addChild(root_0, root_1);
						}
					}
					retval.tree = root_0;
				}
			}
				break;
			case 2:
				// MOWLParser.g:101:7: INVERSE_FUNCTIONAL
			{
				INVERSE_FUNCTIONAL26 = (Token) this.match(this.input,
						INVERSE_FUNCTIONAL,
						FOLLOW_INVERSE_FUNCTIONAL_in_unaryCharacteristic889);
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
							this.adaptor, "rule retval",
							retval != null ? retval.tree : null);
					root_0 = (OPPLSyntaxTree) this.adaptor.nil();
					// 101:26: -> ^( INVERSE_FUNCTIONAL )
					{
						// MOWLParser.g:101:29: ^( INVERSE_FUNCTIONAL )
						{
							OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor
									.nil();
							root_1 = (OPPLSyntaxTree) this.adaptor.becomeRoot(
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
				// MOWLParser.g:102:7: SYMMETRIC
			{
				SYMMETRIC27 = (Token) this.match(this.input, SYMMETRIC,
						FOLLOW_SYMMETRIC_in_unaryCharacteristic903);
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
							this.adaptor, "rule retval",
							retval != null ? retval.tree : null);
					root_0 = (OPPLSyntaxTree) this.adaptor.nil();
					// 102:17: -> ^( SYMMETRIC )
					{
						// MOWLParser.g:102:20: ^( SYMMETRIC )
						{
							OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor
									.nil();
							root_1 = (OPPLSyntaxTree) this.adaptor.becomeRoot(
									stream_SYMMETRIC.nextNode(), root_1);
							this.adaptor.addChild(root_0, root_1);
						}
					}
					retval.tree = root_0;
				}
			}
				break;
			case 4:
				// MOWLParser.g:103:7: ANTI_SYMMETRIC
			{
				ANTI_SYMMETRIC28 = (Token) this.match(this.input,
						ANTI_SYMMETRIC,
						FOLLOW_ANTI_SYMMETRIC_in_unaryCharacteristic917);
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
							this.adaptor, "rule retval",
							retval != null ? retval.tree : null);
					root_0 = (OPPLSyntaxTree) this.adaptor.nil();
					// 103:22: -> ^( ANTI_SYMMETRIC )
					{
						// MOWLParser.g:103:25: ^( ANTI_SYMMETRIC )
						{
							OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor
									.nil();
							root_1 = (OPPLSyntaxTree) this.adaptor.becomeRoot(
									stream_ANTI_SYMMETRIC.nextNode(), root_1);
							this.adaptor.addChild(root_0, root_1);
						}
					}
					retval.tree = root_0;
				}
			}
				break;
			case 5:
				// MOWLParser.g:104:7: REFLEXIVE
			{
				REFLEXIVE29 = (Token) this.match(this.input, REFLEXIVE,
						FOLLOW_REFLEXIVE_in_unaryCharacteristic931);
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
							this.adaptor, "rule retval",
							retval != null ? retval.tree : null);
					root_0 = (OPPLSyntaxTree) this.adaptor.nil();
					// 104:17: -> ^( REFLEXIVE )
					{
						// MOWLParser.g:104:20: ^( REFLEXIVE )
						{
							OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor
									.nil();
							root_1 = (OPPLSyntaxTree) this.adaptor.becomeRoot(
									stream_REFLEXIVE.nextNode(), root_1);
							this.adaptor.addChild(root_0, root_1);
						}
					}
					retval.tree = root_0;
				}
			}
				break;
			case 6:
				// MOWLParser.g:105:7: IRREFLEXIVE
			{
				IRREFLEXIVE30 = (Token) this.match(this.input, IRREFLEXIVE,
						FOLLOW_IRREFLEXIVE_in_unaryCharacteristic945);
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
							this.adaptor, "rule retval",
							retval != null ? retval.tree : null);
					root_0 = (OPPLSyntaxTree) this.adaptor.nil();
					// 105:19: -> ^( IRREFLEXIVE )
					{
						// MOWLParser.g:105:22: ^( IRREFLEXIVE )
						{
							OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor
									.nil();
							root_1 = (OPPLSyntaxTree) this.adaptor.becomeRoot(
									stream_IRREFLEXIVE.nextNode(), root_1);
							this.adaptor.addChild(root_0, root_1);
						}
					}
					retval.tree = root_0;
				}
			}
				break;
			case 7:
				// MOWLParser.g:106:7: TRANSITIVE
			{
				TRANSITIVE31 = (Token) this.match(this.input, TRANSITIVE,
						FOLLOW_TRANSITIVE_in_unaryCharacteristic959);
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
							this.adaptor, "rule retval",
							retval != null ? retval.tree : null);
					root_0 = (OPPLSyntaxTree) this.adaptor.nil();
					// 106:18: -> ^( TRANSITIVE )
					{
						// MOWLParser.g:106:21: ^( TRANSITIVE )
						{
							OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor
									.nil();
							root_1 = (OPPLSyntaxTree) this.adaptor.becomeRoot(
									stream_TRANSITIVE.nextNode(), root_1);
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

	// $ANTLR end "unaryCharacteristic"
	public static class expression_return extends ParserRuleReturnScope {
		OPPLSyntaxTree tree;

		@Override
		public Object getTree() {
			return this.tree;
		}
	};

	// $ANTLR start "expression"
	// MOWLParser.g:109:1: expression : ( options {backtrack=true; } : |
	// conjunction ( OR conjunction )* -> ^( DISJUNCTION ( conjunction )+ ) |
	// complexPropertyExpression -> ^( complexPropertyExpression ) |
	// OPEN_PARENTHESYS expression CLOSED_PARENTHESYS -> ^( expression ) ) ;
	public final OPPLParser_MOWLParser.expression_return expression()
			throws RecognitionException {
		OPPLParser_MOWLParser.expression_return retval = new OPPLParser_MOWLParser.expression_return();
		retval.start = this.input.LT(1);
		OPPLSyntaxTree root_0 = null;
		Token OR33 = null;
		Token OPEN_PARENTHESYS36 = null;
		Token CLOSED_PARENTHESYS38 = null;
		OPPLParser_MOWLParser.conjunction_return conjunction32 = null;
		OPPLParser_MOWLParser.conjunction_return conjunction34 = null;
		OPPLParser_MOWLParser.complexPropertyExpression_return complexPropertyExpression35 = null;
		OPPLParser_MOWLParser.expression_return expression37 = null;
		OPPLSyntaxTree OR33_tree = null;
		OPPLSyntaxTree OPEN_PARENTHESYS36_tree = null;
		OPPLSyntaxTree CLOSED_PARENTHESYS38_tree = null;
		RewriteRuleTokenStream stream_CLOSED_PARENTHESYS = new RewriteRuleTokenStream(
				this.adaptor, "token CLOSED_PARENTHESYS");
		RewriteRuleTokenStream stream_OR = new RewriteRuleTokenStream(
				this.adaptor, "token OR");
		RewriteRuleTokenStream stream_OPEN_PARENTHESYS = new RewriteRuleTokenStream(
				this.adaptor, "token OPEN_PARENTHESYS");
		RewriteRuleSubtreeStream stream_expression = new RewriteRuleSubtreeStream(
				this.adaptor, "rule expression");
		RewriteRuleSubtreeStream stream_conjunction = new RewriteRuleSubtreeStream(
				this.adaptor, "rule conjunction");
		RewriteRuleSubtreeStream stream_complexPropertyExpression = new RewriteRuleSubtreeStream(
				this.adaptor, "rule complexPropertyExpression");
		try {
			// MOWLParser.g:109:11: ( ( options {backtrack=true; } : |
			// conjunction ( OR conjunction )* -> ^( DISJUNCTION ( conjunction
			// )+ ) | complexPropertyExpression -> ^( complexPropertyExpression
			// ) | OPEN_PARENTHESYS expression CLOSED_PARENTHESYS -> ^(
			// expression ) ) )
			// MOWLParser.g:110:5: ( options {backtrack=true; } : | conjunction
			// ( OR conjunction )* -> ^( DISJUNCTION ( conjunction )+ ) |
			// complexPropertyExpression -> ^( complexPropertyExpression ) |
			// OPEN_PARENTHESYS expression CLOSED_PARENTHESYS -> ^( expression )
			// )
			{
				// MOWLParser.g:110:5: ( options {backtrack=true; } : |
				// conjunction ( OR conjunction )* -> ^( DISJUNCTION (
				// conjunction )+ ) | complexPropertyExpression -> ^(
				// complexPropertyExpression ) | OPEN_PARENTHESYS expression
				// CLOSED_PARENTHESYS -> ^( expression ) )
				int alt7 = 4;
				alt7 = this.dfa7.predict(this.input);
				switch (alt7) {
				case 1:
					// MOWLParser.g:112:4:
				{
				}
					break;
				case 2:
					// MOWLParser.g:112:6: conjunction ( OR conjunction )*
				{
					this.pushFollow(FOLLOW_conjunction_in_expression1002);
					conjunction32 = this.conjunction();
					this.state._fsp--;
					if (this.state.failed) {
						return retval;
					}
					if (this.state.backtracking == 0) {
						stream_conjunction.add(conjunction32.getTree());
					}
					// MOWLParser.g:112:18: ( OR conjunction )*
					loop6: do {
						int alt6 = 2;
						int LA6_0 = this.input.LA(1);
						if (LA6_0 == OR) {
							alt6 = 1;
						}
						switch (alt6) {
						case 1:
							// MOWLParser.g:112:19: OR conjunction
						{
							OR33 = (Token) this.match(this.input, OR,
									FOLLOW_OR_in_expression1005);
							if (this.state.failed) {
								return retval;
							}
							if (this.state.backtracking == 0) {
								stream_OR.add(OR33);
							}
							this
									.pushFollow(FOLLOW_conjunction_in_expression1007);
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
								this.adaptor, "rule retval",
								retval != null ? retval.tree : null);
						root_0 = (OPPLSyntaxTree) this.adaptor.nil();
						// 112:36: -> ^( DISJUNCTION ( conjunction )+ )
						{
							// MOWLParser.g:112:39: ^( DISJUNCTION ( conjunction
							// )+ )
							{
								OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor
										.nil();
								root_1 = (OPPLSyntaxTree) this.adaptor
										.becomeRoot(this.adaptor.create(
												DISJUNCTION, "DISJUNCTION"),
												root_1);
								if (!stream_conjunction.hasNext()) {
									throw new RewriteEarlyExitException();
								}
								while (stream_conjunction.hasNext()) {
									this.adaptor.addChild(root_1,
											stream_conjunction.nextTree());
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
					// MOWLParser.g:113:6: complexPropertyExpression
				{
					this
							.pushFollow(FOLLOW_complexPropertyExpression_in_expression1026);
					complexPropertyExpression35 = this
							.complexPropertyExpression();
					this.state._fsp--;
					if (this.state.failed) {
						return retval;
					}
					if (this.state.backtracking == 0) {
						stream_complexPropertyExpression
								.add(complexPropertyExpression35.getTree());
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
								this.adaptor, "rule retval",
								retval != null ? retval.tree : null);
						root_0 = (OPPLSyntaxTree) this.adaptor.nil();
						// 113:32: -> ^( complexPropertyExpression )
						{
							// MOWLParser.g:113:35: ^( complexPropertyExpression
							// )
							{
								OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor
										.nil();
								root_1 = (OPPLSyntaxTree) this.adaptor
										.becomeRoot(
												stream_complexPropertyExpression
														.nextNode(), root_1);
								this.adaptor.addChild(root_0, root_1);
							}
						}
						retval.tree = root_0;
					}
				}
					break;
				case 4:
					// MOWLParser.g:114:6: OPEN_PARENTHESYS expression
					// CLOSED_PARENTHESYS
				{
					OPEN_PARENTHESYS36 = (Token) this.match(this.input,
							OPEN_PARENTHESYS,
							FOLLOW_OPEN_PARENTHESYS_in_expression1039);
					if (this.state.failed) {
						return retval;
					}
					if (this.state.backtracking == 0) {
						stream_OPEN_PARENTHESYS.add(OPEN_PARENTHESYS36);
					}
					this.pushFollow(FOLLOW_expression_in_expression1041);
					expression37 = this.expression();
					this.state._fsp--;
					if (this.state.failed) {
						return retval;
					}
					if (this.state.backtracking == 0) {
						stream_expression.add(expression37.getTree());
					}
					CLOSED_PARENTHESYS38 = (Token) this.match(this.input,
							CLOSED_PARENTHESYS,
							FOLLOW_CLOSED_PARENTHESYS_in_expression1043);
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
								this.adaptor, "rule retval",
								retval != null ? retval.tree : null);
						root_0 = (OPPLSyntaxTree) this.adaptor.nil();
						// 114:53: -> ^( expression )
						{
							// MOWLParser.g:114:56: ^( expression )
							{
								OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor
										.nil();
								root_1 = (OPPLSyntaxTree) this.adaptor
										.becomeRoot(stream_expression
												.nextNode(), root_1);
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

	// $ANTLR end "expression"
	public static class conjunction_return extends ParserRuleReturnScope {
		OPPLSyntaxTree tree;

		@Override
		public Object getTree() {
			return this.tree;
		}
	};

	// $ANTLR start "conjunction"
	// MOWLParser.g:122:1: conjunction : unary ( AND unary )* -> ^( CONJUNCTION
	// ( unary )+ ) ;
	public final OPPLParser_MOWLParser.conjunction_return conjunction()
			throws RecognitionException {
		OPPLParser_MOWLParser.conjunction_return retval = new OPPLParser_MOWLParser.conjunction_return();
		retval.start = this.input.LT(1);
		OPPLSyntaxTree root_0 = null;
		Token AND40 = null;
		OPPLParser_MOWLParser.unary_return unary39 = null;
		OPPLParser_MOWLParser.unary_return unary41 = null;
		OPPLSyntaxTree AND40_tree = null;
		RewriteRuleTokenStream stream_AND = new RewriteRuleTokenStream(
				this.adaptor, "token AND");
		RewriteRuleSubtreeStream stream_unary = new RewriteRuleSubtreeStream(
				this.adaptor, "rule unary");
		try {
			// MOWLParser.g:122:13: ( unary ( AND unary )* -> ^( CONJUNCTION (
			// unary )+ ) )
			// MOWLParser.g:123:5: unary ( AND unary )*
			{
				this.pushFollow(FOLLOW_unary_in_conjunction1076);
				unary39 = this.unary();
				this.state._fsp--;
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_unary.add(unary39.getTree());
				}
				// MOWLParser.g:123:11: ( AND unary )*
				loop8: do {
					int alt8 = 2;
					int LA8_0 = this.input.LA(1);
					if (LA8_0 == AND) {
						alt8 = 1;
					}
					switch (alt8) {
					case 1:
						// MOWLParser.g:123:12: AND unary
					{
						AND40 = (Token) this.match(this.input, AND,
								FOLLOW_AND_in_conjunction1079);
						if (this.state.failed) {
							return retval;
						}
						if (this.state.backtracking == 0) {
							stream_AND.add(AND40);
						}
						this.pushFollow(FOLLOW_unary_in_conjunction1081);
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
							this.adaptor, "rule retval",
							retval != null ? retval.tree : null);
					root_0 = (OPPLSyntaxTree) this.adaptor.nil();
					// 123:24: -> ^( CONJUNCTION ( unary )+ )
					{
						// MOWLParser.g:123:27: ^( CONJUNCTION ( unary )+ )
						{
							OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor
									.nil();
							root_1 = (OPPLSyntaxTree) this.adaptor.becomeRoot(
									this.adaptor.create(CONJUNCTION,
											"CONJUNCTION"), root_1);
							if (!stream_unary.hasNext()) {
								throw new RewriteEarlyExitException();
							}
							while (stream_unary.hasNext()) {
								this.adaptor.addChild(root_1, stream_unary
										.nextTree());
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

	// $ANTLR end "conjunction"
	public static class complexPropertyExpression_return extends
			ParserRuleReturnScope {
		OPPLSyntaxTree tree;

		@Override
		public Object getTree() {
			return this.tree;
		}
	};

	// $ANTLR start "complexPropertyExpression"
	// MOWLParser.g:126:1: complexPropertyExpression : ( INVERSE
	// OPEN_PARENTHESYS complexPropertyExpression CLOSED_PARENTHESYS -> ^(
	// INVERSE_OBJECT_PROPERTY_EXPRESSION complexPropertyExpression ) | INVERSE
	// OPEN_PARENTHESYS atomic CLOSED_PARENTHESYS -> ^(
	// INVERSE_OBJECT_PROPERTY_EXPRESSION atomic ) );
	public final OPPLParser_MOWLParser.complexPropertyExpression_return complexPropertyExpression()
			throws RecognitionException {
		OPPLParser_MOWLParser.complexPropertyExpression_return retval = new OPPLParser_MOWLParser.complexPropertyExpression_return();
		retval.start = this.input.LT(1);
		OPPLSyntaxTree root_0 = null;
		Token INVERSE42 = null;
		Token OPEN_PARENTHESYS43 = null;
		Token CLOSED_PARENTHESYS45 = null;
		Token INVERSE46 = null;
		Token OPEN_PARENTHESYS47 = null;
		Token CLOSED_PARENTHESYS49 = null;
		OPPLParser_MOWLParser.complexPropertyExpression_return complexPropertyExpression44 = null;
		OPPLParser.atomic_return atomic48 = null;
		OPPLSyntaxTree INVERSE42_tree = null;
		OPPLSyntaxTree OPEN_PARENTHESYS43_tree = null;
		OPPLSyntaxTree CLOSED_PARENTHESYS45_tree = null;
		OPPLSyntaxTree INVERSE46_tree = null;
		OPPLSyntaxTree OPEN_PARENTHESYS47_tree = null;
		OPPLSyntaxTree CLOSED_PARENTHESYS49_tree = null;
		RewriteRuleTokenStream stream_INVERSE = new RewriteRuleTokenStream(
				this.adaptor, "token INVERSE");
		RewriteRuleTokenStream stream_CLOSED_PARENTHESYS = new RewriteRuleTokenStream(
				this.adaptor, "token CLOSED_PARENTHESYS");
		RewriteRuleTokenStream stream_OPEN_PARENTHESYS = new RewriteRuleTokenStream(
				this.adaptor, "token OPEN_PARENTHESYS");
		RewriteRuleSubtreeStream stream_complexPropertyExpression = new RewriteRuleSubtreeStream(
				this.adaptor, "rule complexPropertyExpression");
		RewriteRuleSubtreeStream stream_atomic = new RewriteRuleSubtreeStream(
				this.adaptor, "rule atomic");
		try {
			// MOWLParser.g:126:26: ( INVERSE OPEN_PARENTHESYS
			// complexPropertyExpression CLOSED_PARENTHESYS -> ^(
			// INVERSE_OBJECT_PROPERTY_EXPRESSION complexPropertyExpression ) |
			// INVERSE OPEN_PARENTHESYS atomic CLOSED_PARENTHESYS -> ^(
			// INVERSE_OBJECT_PROPERTY_EXPRESSION atomic ) )
			int alt9 = 2;
			int LA9_0 = this.input.LA(1);
			if (LA9_0 == INVERSE) {
				int LA9_1 = this.input.LA(2);
				if (LA9_1 == OPEN_PARENTHESYS) {
					int LA9_2 = this.input.LA(3);
					if (LA9_2 == INVERSE) {
						alt9 = 1;
					} else if (LA9_2 >= IDENTIFIER && LA9_2 <= ENTITY_REFERENCE
							|| LA9_2 == VARIABLE_NAME
							|| LA9_2 == ESCLAMATION_MARK) {
						alt9 = 2;
					} else {
						if (this.state.backtracking > 0) {
							this.state.failed = true;
							return retval;
						}
						NoViableAltException nvae = new NoViableAltException(
								"", 9, 2, this.input);
						throw nvae;
					}
				} else {
					if (this.state.backtracking > 0) {
						this.state.failed = true;
						return retval;
					}
					NoViableAltException nvae = new NoViableAltException("", 9,
							1, this.input);
					throw nvae;
				}
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
				// MOWLParser.g:127:2: INVERSE OPEN_PARENTHESYS
				// complexPropertyExpression CLOSED_PARENTHESYS
			{
				INVERSE42 = (Token) this.match(this.input, INVERSE,
						FOLLOW_INVERSE_in_complexPropertyExpression1102);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_INVERSE.add(INVERSE42);
				}
				OPEN_PARENTHESYS43 = (Token) this
						.match(this.input, OPEN_PARENTHESYS,
								FOLLOW_OPEN_PARENTHESYS_in_complexPropertyExpression1104);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_OPEN_PARENTHESYS.add(OPEN_PARENTHESYS43);
				}
				this
						.pushFollow(FOLLOW_complexPropertyExpression_in_complexPropertyExpression1106);
				complexPropertyExpression44 = this.complexPropertyExpression();
				this.state._fsp--;
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_complexPropertyExpression
							.add(complexPropertyExpression44.getTree());
				}
				CLOSED_PARENTHESYS45 = (Token) this
						.match(this.input, CLOSED_PARENTHESYS,
								FOLLOW_CLOSED_PARENTHESYS_in_complexPropertyExpression1108);
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
							this.adaptor, "rule retval",
							retval != null ? retval.tree : null);
					root_0 = (OPPLSyntaxTree) this.adaptor.nil();
					// 127:72: -> ^( INVERSE_OBJECT_PROPERTY_EXPRESSION
					// complexPropertyExpression )
					{
						// MOWLParser.g:127:75: ^(
						// INVERSE_OBJECT_PROPERTY_EXPRESSION
						// complexPropertyExpression )
						{
							OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor
									.nil();
							root_1 = (OPPLSyntaxTree) this.adaptor
									.becomeRoot(
											this.adaptor
													.create(
															INVERSE_OBJECT_PROPERTY_EXPRESSION,
															"INVERSE_OBJECT_PROPERTY_EXPRESSION"),
											root_1);
							this.adaptor
									.addChild(root_1,
											stream_complexPropertyExpression
													.nextTree());
							this.adaptor.addChild(root_0, root_1);
						}
					}
					retval.tree = root_0;
				}
			}
				break;
			case 2:
				// MOWLParser.g:128:4: INVERSE OPEN_PARENTHESYS atomic
				// CLOSED_PARENTHESYS
			{
				INVERSE46 = (Token) this.match(this.input, INVERSE,
						FOLLOW_INVERSE_in_complexPropertyExpression1121);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_INVERSE.add(INVERSE46);
				}
				OPEN_PARENTHESYS47 = (Token) this
						.match(this.input, OPEN_PARENTHESYS,
								FOLLOW_OPEN_PARENTHESYS_in_complexPropertyExpression1123);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_OPEN_PARENTHESYS.add(OPEN_PARENTHESYS47);
				}
				this.pushFollow(FOLLOW_atomic_in_complexPropertyExpression1125);
				atomic48 = this.gOPPLParser.atomic();
				this.state._fsp--;
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_atomic.add(atomic48.getTree());
				}
				CLOSED_PARENTHESYS49 = (Token) this
						.match(this.input, CLOSED_PARENTHESYS,
								FOLLOW_CLOSED_PARENTHESYS_in_complexPropertyExpression1127);
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
							this.adaptor, "rule retval",
							retval != null ? retval.tree : null);
					root_0 = (OPPLSyntaxTree) this.adaptor.nil();
					// 128:54: -> ^( INVERSE_OBJECT_PROPERTY_EXPRESSION atomic )
					{
						// MOWLParser.g:128:57: ^(
						// INVERSE_OBJECT_PROPERTY_EXPRESSION atomic )
						{
							OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor
									.nil();
							root_1 = (OPPLSyntaxTree) this.adaptor
									.becomeRoot(
											this.adaptor
													.create(
															INVERSE_OBJECT_PROPERTY_EXPRESSION,
															"INVERSE_OBJECT_PROPERTY_EXPRESSION"),
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

	// $ANTLR end "complexPropertyExpression"
	public static class unary_return extends ParserRuleReturnScope {
		OPPLSyntaxTree tree;

		@Override
		public Object getTree() {
			return this.tree;
		}
	};

	// $ANTLR start "unary"
	// MOWLParser.g:131:1: unary options {backtrack=true; } : (head=
	// propertyExpression ( COMPOSITION rest+= propertyExpression )+ -> ^(
	// PROPERTY_CHAIN $head $rest) | NOT OPEN_PARENTHESYS expression
	// CLOSED_PARENTHESYS -> ^( NEGATED_EXPRESSION expression ) | NOT atomic ->
	// ^( NEGATED_EXPRESSION atomic ) | qualifiedRestriction -> ^(
	// qualifiedRestriction ) | constant | atomic );
	public final OPPLParser_MOWLParser.unary_return unary()
			throws RecognitionException {
		OPPLParser_MOWLParser.unary_return retval = new OPPLParser_MOWLParser.unary_return();
		retval.start = this.input.LT(1);
		OPPLSyntaxTree root_0 = null;
		Token COMPOSITION50 = null;
		Token NOT51 = null;
		Token OPEN_PARENTHESYS52 = null;
		Token CLOSED_PARENTHESYS54 = null;
		Token NOT55 = null;
		List list_rest = null;
		OPPLParser_MOWLParser.propertyExpression_return head = null;
		OPPLParser_MOWLParser.expression_return expression53 = null;
		OPPLParser.atomic_return atomic56 = null;
		OPPLParser_MOWLParser.qualifiedRestriction_return qualifiedRestriction57 = null;
		OPPLParser_MOWLParser.constant_return constant58 = null;
		OPPLParser.atomic_return atomic59 = null;
		RuleReturnScope rest = null;
		OPPLSyntaxTree COMPOSITION50_tree = null;
		OPPLSyntaxTree NOT51_tree = null;
		OPPLSyntaxTree OPEN_PARENTHESYS52_tree = null;
		OPPLSyntaxTree CLOSED_PARENTHESYS54_tree = null;
		OPPLSyntaxTree NOT55_tree = null;
		RewriteRuleTokenStream stream_NOT = new RewriteRuleTokenStream(
				this.adaptor, "token NOT");
		RewriteRuleTokenStream stream_CLOSED_PARENTHESYS = new RewriteRuleTokenStream(
				this.adaptor, "token CLOSED_PARENTHESYS");
		RewriteRuleTokenStream stream_COMPOSITION = new RewriteRuleTokenStream(
				this.adaptor, "token COMPOSITION");
		RewriteRuleTokenStream stream_OPEN_PARENTHESYS = new RewriteRuleTokenStream(
				this.adaptor, "token OPEN_PARENTHESYS");
		RewriteRuleSubtreeStream stream_expression = new RewriteRuleSubtreeStream(
				this.adaptor, "rule expression");
		RewriteRuleSubtreeStream stream_qualifiedRestriction = new RewriteRuleSubtreeStream(
				this.adaptor, "rule qualifiedRestriction");
		RewriteRuleSubtreeStream stream_propertyExpression = new RewriteRuleSubtreeStream(
				this.adaptor, "rule propertyExpression");
		RewriteRuleSubtreeStream stream_atomic = new RewriteRuleSubtreeStream(
				this.adaptor, "rule atomic");
		try {
			// MOWLParser.g:131:34: (head= propertyExpression ( COMPOSITION
			// rest+= propertyExpression )+ -> ^( PROPERTY_CHAIN $head $rest) |
			// NOT OPEN_PARENTHESYS expression CLOSED_PARENTHESYS -> ^(
			// NEGATED_EXPRESSION expression ) | NOT atomic -> ^(
			// NEGATED_EXPRESSION atomic ) | qualifiedRestriction -> ^(
			// qualifiedRestriction ) | constant | atomic )
			int alt11 = 6;
			alt11 = this.dfa11.predict(this.input);
			switch (alt11) {
			case 1:
				// MOWLParser.g:133:4: head= propertyExpression ( COMPOSITION
				// rest+= propertyExpression )+
			{
				this.pushFollow(FOLLOW_propertyExpression_in_unary1164);
				head = this.propertyExpression();
				this.state._fsp--;
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_propertyExpression.add(head.getTree());
				}
				// MOWLParser.g:133:30: ( COMPOSITION rest+= propertyExpression
				// )+
				int cnt10 = 0;
				loop10: do {
					int alt10 = 2;
					int LA10_0 = this.input.LA(1);
					if (LA10_0 == COMPOSITION) {
						alt10 = 1;
					}
					switch (alt10) {
					case 1:
						// MOWLParser.g:133:31: COMPOSITION rest+=
						// propertyExpression
					{
						COMPOSITION50 = (Token) this.match(this.input,
								COMPOSITION, FOLLOW_COMPOSITION_in_unary1167);
						if (this.state.failed) {
							return retval;
						}
						if (this.state.backtracking == 0) {
							stream_COMPOSITION.add(COMPOSITION50);
						}
						this.pushFollow(FOLLOW_propertyExpression_in_unary1171);
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
						EarlyExitException eee = new EarlyExitException(10,
								this.input);
						throw eee;
					}
					cnt10++;
				} while (true);
				// AST REWRITE
				// elements: head, rest
				// token labels:
				// rule labels: retval, head
				// token list labels:
				// rule list labels: rest
				// wildcard labels:
				if (this.state.backtracking == 0) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(
							this.adaptor, "rule retval",
							retval != null ? retval.tree : null);
					RewriteRuleSubtreeStream stream_head = new RewriteRuleSubtreeStream(
							this.adaptor, "rule head", head != null ? head.tree
									: null);
					RewriteRuleSubtreeStream stream_rest = new RewriteRuleSubtreeStream(
							this.adaptor, "token rest", list_rest);
					root_0 = (OPPLSyntaxTree) this.adaptor.nil();
					// 133:71: -> ^( PROPERTY_CHAIN $head $rest)
					{
						// MOWLParser.g:133:74: ^( PROPERTY_CHAIN $head $rest)
						{
							OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor
									.nil();
							root_1 = (OPPLSyntaxTree) this.adaptor.becomeRoot(
									this.adaptor.create(PROPERTY_CHAIN,
											"PROPERTY_CHAIN"), root_1);
							this.adaptor.addChild(root_1, stream_head
									.nextTree());
							this.adaptor.addChild(root_1, stream_rest
									.nextTree());
							this.adaptor.addChild(root_0, root_1);
						}
					}
					retval.tree = root_0;
				}
			}
				break;
			case 2:
				// MOWLParser.g:134:5: NOT OPEN_PARENTHESYS expression
				// CLOSED_PARENTHESYS
			{
				NOT51 = (Token) this.match(this.input, NOT,
						FOLLOW_NOT_in_unary1193);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_NOT.add(NOT51);
				}
				OPEN_PARENTHESYS52 = (Token) this.match(this.input,
						OPEN_PARENTHESYS, FOLLOW_OPEN_PARENTHESYS_in_unary1195);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_OPEN_PARENTHESYS.add(OPEN_PARENTHESYS52);
				}
				this.pushFollow(FOLLOW_expression_in_unary1197);
				expression53 = this.expression();
				this.state._fsp--;
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_expression.add(expression53.getTree());
				}
				CLOSED_PARENTHESYS54 = (Token) this.match(this.input,
						CLOSED_PARENTHESYS,
						FOLLOW_CLOSED_PARENTHESYS_in_unary1199);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_CLOSED_PARENTHESYS.add(CLOSED_PARENTHESYS54);
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
					// 134:56: -> ^( NEGATED_EXPRESSION expression )
					{
						// MOWLParser.g:134:59: ^( NEGATED_EXPRESSION expression
						// )
						{
							OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor
									.nil();
							root_1 = (OPPLSyntaxTree) this.adaptor.becomeRoot(
									this.adaptor.create(NEGATED_EXPRESSION,
											"NEGATED_EXPRESSION"), root_1);
							this.adaptor.addChild(root_1, stream_expression
									.nextTree());
							this.adaptor.addChild(root_0, root_1);
						}
					}
					retval.tree = root_0;
				}
			}
				break;
			case 3:
				// MOWLParser.g:135:5: NOT atomic
			{
				NOT55 = (Token) this.match(this.input, NOT,
						FOLLOW_NOT_in_unary1213);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_NOT.add(NOT55);
				}
				this.pushFollow(FOLLOW_atomic_in_unary1215);
				atomic56 = this.gOPPLParser.atomic();
				this.state._fsp--;
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_atomic.add(atomic56.getTree());
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
					// 135:16: -> ^( NEGATED_EXPRESSION atomic )
					{
						// MOWLParser.g:135:19: ^( NEGATED_EXPRESSION atomic )
						{
							OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor
									.nil();
							root_1 = (OPPLSyntaxTree) this.adaptor.becomeRoot(
									this.adaptor.create(NEGATED_EXPRESSION,
											"NEGATED_EXPRESSION"), root_1);
							this.adaptor.addChild(root_1, stream_atomic
									.nextTree());
							this.adaptor.addChild(root_0, root_1);
						}
					}
					retval.tree = root_0;
				}
			}
				break;
			case 4:
				// MOWLParser.g:136:5: qualifiedRestriction
			{
				this.pushFollow(FOLLOW_qualifiedRestriction_in_unary1238);
				qualifiedRestriction57 = this.qualifiedRestriction();
				this.state._fsp--;
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_qualifiedRestriction.add(qualifiedRestriction57
							.getTree());
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
							this.adaptor, "rule retval",
							retval != null ? retval.tree : null);
					root_0 = (OPPLSyntaxTree) this.adaptor.nil();
					// 136:26: -> ^( qualifiedRestriction )
					{
						// MOWLParser.g:136:29: ^( qualifiedRestriction )
						{
							OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor
									.nil();
							root_1 = (OPPLSyntaxTree) this.adaptor.becomeRoot(
									stream_qualifiedRestriction.nextNode(),
									root_1);
							this.adaptor.addChild(root_0, root_1);
						}
					}
					retval.tree = root_0;
				}
			}
				break;
			case 5:
				// MOWLParser.g:137:5: constant
			{
				root_0 = (OPPLSyntaxTree) this.adaptor.nil();
				this.pushFollow(FOLLOW_constant_in_unary1250);
				constant58 = this.constant();
				this.state._fsp--;
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					this.adaptor.addChild(root_0, constant58.getTree());
				}
			}
				break;
			case 6:
				// MOWLParser.g:138:5: atomic
			{
				root_0 = (OPPLSyntaxTree) this.adaptor.nil();
				this.pushFollow(FOLLOW_atomic_in_unary1256);
				atomic59 = this.gOPPLParser.atomic();
				this.state._fsp--;
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					this.adaptor.addChild(root_0, atomic59.getTree());
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

	// $ANTLR end "unary"
	public static class qualifiedRestriction_return extends
			ParserRuleReturnScope {
		OPPLSyntaxTree tree;

		@Override
		public Object getTree() {
			return this.tree;
		}
	};

	// $ANTLR start "qualifiedRestriction"
	// MOWLParser.g:146:1: qualifiedRestriction : ( options {backtrack=true; } :
	// propertyExpression SOME expression -> ^( SOME_RESTRICTION
	// propertyExpression expression ) | propertyExpression ONLY expression ->
	// ^( ALL_RESTRICTION propertyExpression expression ) |
	// cardinalityRestriction -> ^( cardinalityRestriction ) | oneOf -> ^( oneOf
	// ) | valueRestriction -> ^( valueRestriction ) ) ;
	public final OPPLParser_MOWLParser.qualifiedRestriction_return qualifiedRestriction()
			throws RecognitionException {
		OPPLParser_MOWLParser.qualifiedRestriction_return retval = new OPPLParser_MOWLParser.qualifiedRestriction_return();
		retval.start = this.input.LT(1);
		OPPLSyntaxTree root_0 = null;
		Token SOME61 = null;
		Token ONLY64 = null;
		OPPLParser_MOWLParser.propertyExpression_return propertyExpression60 = null;
		OPPLParser_MOWLParser.expression_return expression62 = null;
		OPPLParser_MOWLParser.propertyExpression_return propertyExpression63 = null;
		OPPLParser_MOWLParser.expression_return expression65 = null;
		OPPLParser_MOWLParser.cardinalityRestriction_return cardinalityRestriction66 = null;
		OPPLParser_MOWLParser.oneOf_return oneOf67 = null;
		OPPLParser_MOWLParser.valueRestriction_return valueRestriction68 = null;
		OPPLSyntaxTree SOME61_tree = null;
		OPPLSyntaxTree ONLY64_tree = null;
		RewriteRuleTokenStream stream_ONLY = new RewriteRuleTokenStream(
				this.adaptor, "token ONLY");
		RewriteRuleTokenStream stream_SOME = new RewriteRuleTokenStream(
				this.adaptor, "token SOME");
		RewriteRuleSubtreeStream stream_expression = new RewriteRuleSubtreeStream(
				this.adaptor, "rule expression");
		RewriteRuleSubtreeStream stream_oneOf = new RewriteRuleSubtreeStream(
				this.adaptor, "rule oneOf");
		RewriteRuleSubtreeStream stream_propertyExpression = new RewriteRuleSubtreeStream(
				this.adaptor, "rule propertyExpression");
		RewriteRuleSubtreeStream stream_cardinalityRestriction = new RewriteRuleSubtreeStream(
				this.adaptor, "rule cardinalityRestriction");
		RewriteRuleSubtreeStream stream_valueRestriction = new RewriteRuleSubtreeStream(
				this.adaptor, "rule valueRestriction");
		try {
			// MOWLParser.g:146:21: ( ( options {backtrack=true; } :
			// propertyExpression SOME expression -> ^( SOME_RESTRICTION
			// propertyExpression expression ) | propertyExpression ONLY
			// expression -> ^( ALL_RESTRICTION propertyExpression expression )
			// | cardinalityRestriction -> ^( cardinalityRestriction ) | oneOf
			// -> ^( oneOf ) | valueRestriction -> ^( valueRestriction ) ) )
			// MOWLParser.g:147:9: ( options {backtrack=true; } :
			// propertyExpression SOME expression -> ^( SOME_RESTRICTION
			// propertyExpression expression ) | propertyExpression ONLY
			// expression -> ^( ALL_RESTRICTION propertyExpression expression )
			// | cardinalityRestriction -> ^( cardinalityRestriction ) | oneOf
			// -> ^( oneOf ) | valueRestriction -> ^( valueRestriction ) )
			{
				// MOWLParser.g:147:9: ( options {backtrack=true; } :
				// propertyExpression SOME expression -> ^( SOME_RESTRICTION
				// propertyExpression expression ) | propertyExpression ONLY
				// expression -> ^( ALL_RESTRICTION propertyExpression
				// expression ) | cardinalityRestriction -> ^(
				// cardinalityRestriction ) | oneOf -> ^( oneOf ) |
				// valueRestriction -> ^( valueRestriction ) )
				int alt13 = 5;
				alt13 = this.dfa13.predict(this.input);
				switch (alt13) {
				case 1:
					// MOWLParser.g:149:7: propertyExpression SOME expression
				{
					this
							.pushFollow(FOLLOW_propertyExpression_in_qualifiedRestriction1329);
					propertyExpression60 = this.propertyExpression();
					this.state._fsp--;
					if (this.state.failed) {
						return retval;
					}
					if (this.state.backtracking == 0) {
						stream_propertyExpression.add(propertyExpression60
								.getTree());
					}
					SOME61 = (Token) this.match(this.input, SOME,
							FOLLOW_SOME_in_qualifiedRestriction1332);
					if (this.state.failed) {
						return retval;
					}
					if (this.state.backtracking == 0) {
						stream_SOME.add(SOME61);
					}
					this
							.pushFollow(FOLLOW_expression_in_qualifiedRestriction1336);
					expression62 = this.expression();
					this.state._fsp--;
					if (this.state.failed) {
						return retval;
					}
					if (this.state.backtracking == 0) {
						stream_expression.add(expression62.getTree());
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
								this.adaptor, "rule retval",
								retval != null ? retval.tree : null);
						root_0 = (OPPLSyntaxTree) this.adaptor.nil();
						// 149:46: -> ^( SOME_RESTRICTION propertyExpression
						// expression )
						{
							// MOWLParser.g:149:49: ^( SOME_RESTRICTION
							// propertyExpression expression )
							{
								OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor
										.nil();
								root_1 = (OPPLSyntaxTree) this.adaptor
										.becomeRoot(this.adaptor.create(
												SOME_RESTRICTION,
												"SOME_RESTRICTION"), root_1);
								this.adaptor.addChild(root_1,
										stream_propertyExpression.nextTree());
								this.adaptor.addChild(root_1, stream_expression
										.nextTree());
								this.adaptor.addChild(root_0, root_1);
							}
						}
						retval.tree = root_0;
					}
				}
					break;
				case 2:
					// MOWLParser.g:150:7: propertyExpression ONLY expression
				{
					this
							.pushFollow(FOLLOW_propertyExpression_in_qualifiedRestriction1365);
					propertyExpression63 = this.propertyExpression();
					this.state._fsp--;
					if (this.state.failed) {
						return retval;
					}
					if (this.state.backtracking == 0) {
						stream_propertyExpression.add(propertyExpression63
								.getTree());
					}
					ONLY64 = (Token) this.match(this.input, ONLY,
							FOLLOW_ONLY_in_qualifiedRestriction1367);
					if (this.state.failed) {
						return retval;
					}
					if (this.state.backtracking == 0) {
						stream_ONLY.add(ONLY64);
					}
					this
							.pushFollow(FOLLOW_expression_in_qualifiedRestriction1370);
					expression65 = this.expression();
					this.state._fsp--;
					if (this.state.failed) {
						return retval;
					}
					if (this.state.backtracking == 0) {
						stream_expression.add(expression65.getTree());
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
								this.adaptor, "rule retval",
								retval != null ? retval.tree : null);
						root_0 = (OPPLSyntaxTree) this.adaptor.nil();
						// 150:44: -> ^( ALL_RESTRICTION propertyExpression
						// expression )
						{
							// MOWLParser.g:150:47: ^( ALL_RESTRICTION
							// propertyExpression expression )
							{
								OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor
										.nil();
								root_1 = (OPPLSyntaxTree) this.adaptor
										.becomeRoot(this.adaptor.create(
												ALL_RESTRICTION,
												"ALL_RESTRICTION"), root_1);
								this.adaptor.addChild(root_1,
										stream_propertyExpression.nextTree());
								this.adaptor.addChild(root_1, stream_expression
										.nextTree());
								this.adaptor.addChild(root_0, root_1);
							}
						}
						retval.tree = root_0;
					}
				}
					break;
				case 3:
					// MOWLParser.g:151:7: cardinalityRestriction
				{
					this
							.pushFollow(FOLLOW_cardinalityRestriction_in_qualifiedRestriction1389);
					cardinalityRestriction66 = this.cardinalityRestriction();
					this.state._fsp--;
					if (this.state.failed) {
						return retval;
					}
					if (this.state.backtracking == 0) {
						stream_cardinalityRestriction
								.add(cardinalityRestriction66.getTree());
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
								this.adaptor, "rule retval",
								retval != null ? retval.tree : null);
						root_0 = (OPPLSyntaxTree) this.adaptor.nil();
						// 151:30: -> ^( cardinalityRestriction )
						{
							// MOWLParser.g:151:33: ^( cardinalityRestriction )
							{
								OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor
										.nil();
								root_1 = (OPPLSyntaxTree) this.adaptor
										.becomeRoot(
												stream_cardinalityRestriction
														.nextNode(), root_1);
								this.adaptor.addChild(root_0, root_1);
							}
						}
						retval.tree = root_0;
					}
				}
					break;
				case 4:
					// MOWLParser.g:152:7: oneOf
				{
					this.pushFollow(FOLLOW_oneOf_in_qualifiedRestriction1403);
					oneOf67 = this.oneOf();
					this.state._fsp--;
					if (this.state.failed) {
						return retval;
					}
					if (this.state.backtracking == 0) {
						stream_oneOf.add(oneOf67.getTree());
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
						// 152:13: -> ^( oneOf )
						{
							// MOWLParser.g:152:16: ^( oneOf )
							{
								OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor
										.nil();
								root_1 = (OPPLSyntaxTree) this.adaptor
										.becomeRoot(stream_oneOf.nextNode(),
												root_1);
								this.adaptor.addChild(root_0, root_1);
							}
						}
						retval.tree = root_0;
					}
				}
					break;
				case 5:
					// MOWLParser.g:153:7: valueRestriction
				{
					this
							.pushFollow(FOLLOW_valueRestriction_in_qualifiedRestriction1417);
					valueRestriction68 = this.valueRestriction();
					this.state._fsp--;
					if (this.state.failed) {
						return retval;
					}
					if (this.state.backtracking == 0) {
						stream_valueRestriction.add(valueRestriction68
								.getTree());
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
								this.adaptor, "rule retval",
								retval != null ? retval.tree : null);
						root_0 = (OPPLSyntaxTree) this.adaptor.nil();
						// 153:24: -> ^( valueRestriction )
						{
							// MOWLParser.g:153:27: ^( valueRestriction )
							{
								OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor
										.nil();
								root_1 = (OPPLSyntaxTree) this.adaptor
										.becomeRoot(stream_valueRestriction
												.nextNode(), root_1);
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

	// $ANTLR end "qualifiedRestriction"
	public static class propertyExpression_return extends ParserRuleReturnScope {
		OPPLSyntaxTree tree;

		@Override
		public Object getTree() {
			return this.tree;
		}
	};

	// $ANTLR start "propertyExpression"
	// MOWLParser.g:157:1: propertyExpression : ( atomic -> ^( atomic ) |
	// complexPropertyExpression -> ^( complexPropertyExpression ) );
	public final OPPLParser_MOWLParser.propertyExpression_return propertyExpression()
			throws RecognitionException {
		OPPLParser_MOWLParser.propertyExpression_return retval = new OPPLParser_MOWLParser.propertyExpression_return();
		retval.start = this.input.LT(1);
		OPPLSyntaxTree root_0 = null;
		OPPLParser.atomic_return atomic69 = null;
		OPPLParser_MOWLParser.complexPropertyExpression_return complexPropertyExpression70 = null;
		RewriteRuleSubtreeStream stream_complexPropertyExpression = new RewriteRuleSubtreeStream(
				this.adaptor, "rule complexPropertyExpression");
		RewriteRuleSubtreeStream stream_atomic = new RewriteRuleSubtreeStream(
				this.adaptor, "rule atomic");
		try {
			// MOWLParser.g:157:21: ( atomic -> ^( atomic ) |
			// complexPropertyExpression -> ^( complexPropertyExpression ) )
			int alt14 = 2;
			int LA14_0 = this.input.LA(1);
			if (LA14_0 >= IDENTIFIER && LA14_0 <= ENTITY_REFERENCE
					|| LA14_0 == VARIABLE_NAME || LA14_0 == ESCLAMATION_MARK) {
				alt14 = 1;
			} else if (LA14_0 == INVERSE) {
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
				// MOWLParser.g:158:7: atomic
			{
				this.pushFollow(FOLLOW_atomic_in_propertyExpression1449);
				atomic69 = this.gOPPLParser.atomic();
				this.state._fsp--;
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_atomic.add(atomic69.getTree());
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
					// 158:14: -> ^( atomic )
					{
						// MOWLParser.g:158:17: ^( atomic )
						{
							OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor
									.nil();
							root_1 = (OPPLSyntaxTree) this.adaptor.becomeRoot(
									stream_atomic.nextNode(), root_1);
							this.adaptor.addChild(root_0, root_1);
						}
					}
					retval.tree = root_0;
				}
			}
				break;
			case 2:
				// MOWLParser.g:159:7: complexPropertyExpression
			{
				this
						.pushFollow(FOLLOW_complexPropertyExpression_in_propertyExpression1463);
				complexPropertyExpression70 = this.complexPropertyExpression();
				this.state._fsp--;
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_complexPropertyExpression
							.add(complexPropertyExpression70.getTree());
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
							this.adaptor, "rule retval",
							retval != null ? retval.tree : null);
					root_0 = (OPPLSyntaxTree) this.adaptor.nil();
					// 159:33: -> ^( complexPropertyExpression )
					{
						// MOWLParser.g:159:36: ^( complexPropertyExpression )
						{
							OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor
									.nil();
							root_1 = (OPPLSyntaxTree) this.adaptor
									.becomeRoot(
											stream_complexPropertyExpression
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

	// $ANTLR end "propertyExpression"
	public static class cardinalityRestriction_return extends
			ParserRuleReturnScope {
		OPPLSyntaxTree tree;

		@Override
		public Object getTree() {
			return this.tree;
		}
	};

	// $ANTLR start "cardinalityRestriction"
	// MOWLParser.g:162:1: cardinalityRestriction options {backtrack=true; } :
	// propertyExpression restrictionKind INTEGER ( unary )? -> ^(
	// CARDINALITY_RESTRICTION restrictionKind INTEGER propertyExpression (
	// unary )? ) ;
	public final OPPLParser_MOWLParser.cardinalityRestriction_return cardinalityRestriction()
			throws RecognitionException {
		OPPLParser_MOWLParser.cardinalityRestriction_return retval = new OPPLParser_MOWLParser.cardinalityRestriction_return();
		retval.start = this.input.LT(1);
		OPPLSyntaxTree root_0 = null;
		Token INTEGER73 = null;
		OPPLParser_MOWLParser.propertyExpression_return propertyExpression71 = null;
		OPPLParser_MOWLParser.restrictionKind_return restrictionKind72 = null;
		OPPLParser_MOWLParser.unary_return unary74 = null;
		OPPLSyntaxTree INTEGER73_tree = null;
		RewriteRuleTokenStream stream_INTEGER = new RewriteRuleTokenStream(
				this.adaptor, "token INTEGER");
		RewriteRuleSubtreeStream stream_unary = new RewriteRuleSubtreeStream(
				this.adaptor, "rule unary");
		RewriteRuleSubtreeStream stream_propertyExpression = new RewriteRuleSubtreeStream(
				this.adaptor, "rule propertyExpression");
		RewriteRuleSubtreeStream stream_restrictionKind = new RewriteRuleSubtreeStream(
				this.adaptor, "rule restrictionKind");
		try {
			// MOWLParser.g:163:28: ( propertyExpression restrictionKind INTEGER
			// ( unary )? -> ^( CARDINALITY_RESTRICTION restrictionKind INTEGER
			// propertyExpression ( unary )? ) )
			// MOWLParser.g:164:2: propertyExpression restrictionKind INTEGER (
			// unary )?
			{
				this
						.pushFollow(FOLLOW_propertyExpression_in_cardinalityRestriction1505);
				propertyExpression71 = this.propertyExpression();
				this.state._fsp--;
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_propertyExpression.add(propertyExpression71
							.getTree());
				}
				this
						.pushFollow(FOLLOW_restrictionKind_in_cardinalityRestriction1508);
				restrictionKind72 = this.restrictionKind();
				this.state._fsp--;
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_restrictionKind.add(restrictionKind72.getTree());
				}
				INTEGER73 = (Token) this.match(this.input, INTEGER,
						FOLLOW_INTEGER_in_cardinalityRestriction1510);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_INTEGER.add(INTEGER73);
				}
				// MOWLParser.g:164:46: ( unary )?
				int alt15 = 2;
				int LA15_0 = this.input.LA(1);
				if (LA15_0 == NOT || LA15_0 == INVERSE || LA15_0 >= IDENTIFIER
						&& LA15_0 <= ENTITY_REFERENCE
						|| LA15_0 == OPEN_CURLY_BRACES || LA15_0 == DBLQUOTE
						|| LA15_0 == VARIABLE_NAME
						|| LA15_0 == ESCLAMATION_MARK) {
					alt15 = 1;
				}
				switch (alt15) {
				case 1:
					// MOWLParser.g:164:46: unary
				{
					this.pushFollow(FOLLOW_unary_in_cardinalityRestriction1512);
					unary74 = this.unary();
					this.state._fsp--;
					if (this.state.failed) {
						return retval;
					}
					if (this.state.backtracking == 0) {
						stream_unary.add(unary74.getTree());
					}
				}
					break;
				}
				// AST REWRITE
				// elements: INTEGER, propertyExpression, restrictionKind, unary
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
					// 164:53: -> ^( CARDINALITY_RESTRICTION restrictionKind
					// INTEGER propertyExpression ( unary )? )
					{
						// MOWLParser.g:164:56: ^( CARDINALITY_RESTRICTION
						// restrictionKind INTEGER propertyExpression ( unary )?
						// )
						{
							OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor
									.nil();
							root_1 = (OPPLSyntaxTree) this.adaptor.becomeRoot(
									this.adaptor.create(
											CARDINALITY_RESTRICTION,
											"CARDINALITY_RESTRICTION"), root_1);
							this.adaptor.addChild(root_1,
									stream_restrictionKind.nextTree());
							this.adaptor.addChild(root_1, stream_INTEGER
									.nextNode());
							this.adaptor.addChild(root_1,
									stream_propertyExpression.nextTree());
							// MOWLParser.g:164:127: ( unary )?
							if (stream_unary.hasNext()) {
								this.adaptor.addChild(root_1, stream_unary
										.nextTree());
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

	// $ANTLR end "cardinalityRestriction"
	public static class restrictionKind_return extends ParserRuleReturnScope {
		OPPLSyntaxTree tree;

		@Override
		public Object getTree() {
			return this.tree;
		}
	};

	// $ANTLR start "restrictionKind"
	// MOWLParser.g:167:1: restrictionKind : ( MIN -> ^( MIN ) | MAX -> ^( MAX )
	// | EXACTLY -> ^( EXACTLY ) );
	public final OPPLParser_MOWLParser.restrictionKind_return restrictionKind()
			throws RecognitionException {
		OPPLParser_MOWLParser.restrictionKind_return retval = new OPPLParser_MOWLParser.restrictionKind_return();
		retval.start = this.input.LT(1);
		OPPLSyntaxTree root_0 = null;
		Token MIN75 = null;
		Token MAX76 = null;
		Token EXACTLY77 = null;
		OPPLSyntaxTree MIN75_tree = null;
		OPPLSyntaxTree MAX76_tree = null;
		OPPLSyntaxTree EXACTLY77_tree = null;
		RewriteRuleTokenStream stream_MAX = new RewriteRuleTokenStream(
				this.adaptor, "token MAX");
		RewriteRuleTokenStream stream_MIN = new RewriteRuleTokenStream(
				this.adaptor, "token MIN");
		RewriteRuleTokenStream stream_EXACTLY = new RewriteRuleTokenStream(
				this.adaptor, "token EXACTLY");
		try {
			// MOWLParser.g:167:17: ( MIN -> ^( MIN ) | MAX -> ^( MAX ) |
			// EXACTLY -> ^( EXACTLY ) )
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
				NoViableAltException nvae = new NoViableAltException("", 16, 0,
						this.input);
				throw nvae;
			}
			switch (alt16) {
			case 1:
				// MOWLParser.g:168:5: MIN
			{
				MIN75 = (Token) this.match(this.input, MIN,
						FOLLOW_MIN_in_restrictionKind1545);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_MIN.add(MIN75);
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
							this.adaptor, "rule retval",
							retval != null ? retval.tree : null);
					root_0 = (OPPLSyntaxTree) this.adaptor.nil();
					// 168:9: -> ^( MIN )
					{
						// MOWLParser.g:168:12: ^( MIN )
						{
							OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor
									.nil();
							root_1 = (OPPLSyntaxTree) this.adaptor.becomeRoot(
									stream_MIN.nextNode(), root_1);
							this.adaptor.addChild(root_0, root_1);
						}
					}
					retval.tree = root_0;
				}
			}
				break;
			case 2:
				// MOWLParser.g:169:7: MAX
			{
				MAX76 = (Token) this.match(this.input, MAX,
						FOLLOW_MAX_in_restrictionKind1559);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_MAX.add(MAX76);
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
							this.adaptor, "rule retval",
							retval != null ? retval.tree : null);
					root_0 = (OPPLSyntaxTree) this.adaptor.nil();
					// 169:11: -> ^( MAX )
					{
						// MOWLParser.g:169:14: ^( MAX )
						{
							OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor
									.nil();
							root_1 = (OPPLSyntaxTree) this.adaptor.becomeRoot(
									stream_MAX.nextNode(), root_1);
							this.adaptor.addChild(root_0, root_1);
						}
					}
					retval.tree = root_0;
				}
			}
				break;
			case 3:
				// MOWLParser.g:170:7: EXACTLY
			{
				EXACTLY77 = (Token) this.match(this.input, EXACTLY,
						FOLLOW_EXACTLY_in_restrictionKind1573);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_EXACTLY.add(EXACTLY77);
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
							this.adaptor, "rule retval",
							retval != null ? retval.tree : null);
					root_0 = (OPPLSyntaxTree) this.adaptor.nil();
					// 170:15: -> ^( EXACTLY )
					{
						// MOWLParser.g:170:18: ^( EXACTLY )
						{
							OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor
									.nil();
							root_1 = (OPPLSyntaxTree) this.adaptor.becomeRoot(
									stream_EXACTLY.nextNode(), root_1);
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

	// $ANTLR end "restrictionKind"
	public static class oneOf_return extends ParserRuleReturnScope {
		OPPLSyntaxTree tree;

		@Override
		public Object getTree() {
			return this.tree;
		}
	};

	// $ANTLR start "oneOf"
	// MOWLParser.g:174:1: oneOf : OPEN_CURLY_BRACES IDENTIFIER ( COMMA
	// IDENTIFIER )* CLOSED_CURLY_BRACES -> ^( ONE_OF ( IDENTIFIER )+ ) ;
	public final OPPLParser_MOWLParser.oneOf_return oneOf()
			throws RecognitionException {
		OPPLParser_MOWLParser.oneOf_return retval = new OPPLParser_MOWLParser.oneOf_return();
		retval.start = this.input.LT(1);
		OPPLSyntaxTree root_0 = null;
		Token OPEN_CURLY_BRACES78 = null;
		Token IDENTIFIER79 = null;
		Token COMMA80 = null;
		Token IDENTIFIER81 = null;
		Token CLOSED_CURLY_BRACES82 = null;
		OPPLSyntaxTree OPEN_CURLY_BRACES78_tree = null;
		OPPLSyntaxTree IDENTIFIER79_tree = null;
		OPPLSyntaxTree COMMA80_tree = null;
		OPPLSyntaxTree IDENTIFIER81_tree = null;
		OPPLSyntaxTree CLOSED_CURLY_BRACES82_tree = null;
		RewriteRuleTokenStream stream_COMMA = new RewriteRuleTokenStream(
				this.adaptor, "token COMMA");
		RewriteRuleTokenStream stream_CLOSED_CURLY_BRACES = new RewriteRuleTokenStream(
				this.adaptor, "token CLOSED_CURLY_BRACES");
		RewriteRuleTokenStream stream_IDENTIFIER = new RewriteRuleTokenStream(
				this.adaptor, "token IDENTIFIER");
		RewriteRuleTokenStream stream_OPEN_CURLY_BRACES = new RewriteRuleTokenStream(
				this.adaptor, "token OPEN_CURLY_BRACES");
		try {
			// MOWLParser.g:174:7: ( OPEN_CURLY_BRACES IDENTIFIER ( COMMA
			// IDENTIFIER )* CLOSED_CURLY_BRACES -> ^( ONE_OF ( IDENTIFIER )+ )
			// )
			// MOWLParser.g:175:3: OPEN_CURLY_BRACES IDENTIFIER ( COMMA
			// IDENTIFIER )* CLOSED_CURLY_BRACES
			{
				OPEN_CURLY_BRACES78 = (Token) this.match(this.input,
						OPEN_CURLY_BRACES,
						FOLLOW_OPEN_CURLY_BRACES_in_oneOf1595);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_OPEN_CURLY_BRACES.add(OPEN_CURLY_BRACES78);
				}
				IDENTIFIER79 = (Token) this.match(this.input, IDENTIFIER,
						FOLLOW_IDENTIFIER_in_oneOf1597);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_IDENTIFIER.add(IDENTIFIER79);
				}
				// MOWLParser.g:175:32: ( COMMA IDENTIFIER )*
				loop17: do {
					int alt17 = 2;
					int LA17_0 = this.input.LA(1);
					if (LA17_0 == COMMA) {
						alt17 = 1;
					}
					switch (alt17) {
					case 1:
						// MOWLParser.g:175:33: COMMA IDENTIFIER
					{
						COMMA80 = (Token) this.match(this.input, COMMA,
								FOLLOW_COMMA_in_oneOf1600);
						if (this.state.failed) {
							return retval;
						}
						if (this.state.backtracking == 0) {
							stream_COMMA.add(COMMA80);
						}
						IDENTIFIER81 = (Token) this.match(this.input,
								IDENTIFIER, FOLLOW_IDENTIFIER_in_oneOf1602);
						if (this.state.failed) {
							return retval;
						}
						if (this.state.backtracking == 0) {
							stream_IDENTIFIER.add(IDENTIFIER81);
						}
					}
						break;
					default:
						break loop17;
					}
				} while (true);
				CLOSED_CURLY_BRACES82 = (Token) this.match(this.input,
						CLOSED_CURLY_BRACES,
						FOLLOW_CLOSED_CURLY_BRACES_in_oneOf1606);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_CLOSED_CURLY_BRACES.add(CLOSED_CURLY_BRACES82);
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
					// 175:72: -> ^( ONE_OF ( IDENTIFIER )+ )
					{
						// MOWLParser.g:175:75: ^( ONE_OF ( IDENTIFIER )+ )
						{
							OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor
									.nil();
							root_1 = (OPPLSyntaxTree) this.adaptor.becomeRoot(
									this.adaptor.create(ONE_OF, "ONE_OF"),
									root_1);
							if (!stream_IDENTIFIER.hasNext()) {
								throw new RewriteEarlyExitException();
							}
							while (stream_IDENTIFIER.hasNext()) {
								this.adaptor.addChild(root_1, stream_IDENTIFIER
										.nextNode());
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

	// $ANTLR end "oneOf"
	public static class valueRestriction_return extends ParserRuleReturnScope {
		OPPLSyntaxTree tree;

		@Override
		public Object getTree() {
			return this.tree;
		}
	};

	// $ANTLR start "valueRestriction"
	// MOWLParser.g:178:1: valueRestriction : propertyExpression VALUE value ->
	// ^( VALUE_RESTRICTION propertyExpression value ) ;
	public final OPPLParser_MOWLParser.valueRestriction_return valueRestriction()
			throws RecognitionException {
		OPPLParser_MOWLParser.valueRestriction_return retval = new OPPLParser_MOWLParser.valueRestriction_return();
		retval.start = this.input.LT(1);
		OPPLSyntaxTree root_0 = null;
		Token VALUE84 = null;
		OPPLParser_MOWLParser.propertyExpression_return propertyExpression83 = null;
		OPPLParser_MOWLParser.value_return value85 = null;
		OPPLSyntaxTree VALUE84_tree = null;
		RewriteRuleTokenStream stream_VALUE = new RewriteRuleTokenStream(
				this.adaptor, "token VALUE");
		RewriteRuleSubtreeStream stream_propertyExpression = new RewriteRuleSubtreeStream(
				this.adaptor, "rule propertyExpression");
		RewriteRuleSubtreeStream stream_value = new RewriteRuleSubtreeStream(
				this.adaptor, "rule value");
		try {
			// MOWLParser.g:178:18: ( propertyExpression VALUE value -> ^(
			// VALUE_RESTRICTION propertyExpression value ) )
			// MOWLParser.g:178:20: propertyExpression VALUE value
			{
				this
						.pushFollow(FOLLOW_propertyExpression_in_valueRestriction1626);
				propertyExpression83 = this.propertyExpression();
				this.state._fsp--;
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_propertyExpression.add(propertyExpression83
							.getTree());
				}
				VALUE84 = (Token) this.match(this.input, VALUE,
						FOLLOW_VALUE_in_valueRestriction1628);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_VALUE.add(VALUE84);
				}
				this.pushFollow(FOLLOW_value_in_valueRestriction1630);
				value85 = this.value();
				this.state._fsp--;
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_value.add(value85.getTree());
				}
				// AST REWRITE
				// elements: value, propertyExpression
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
					// 178:51: -> ^( VALUE_RESTRICTION propertyExpression value
					// )
					{
						// MOWLParser.g:178:54: ^( VALUE_RESTRICTION
						// propertyExpression value )
						{
							OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor
									.nil();
							root_1 = (OPPLSyntaxTree) this.adaptor.becomeRoot(
									this.adaptor.create(VALUE_RESTRICTION,
											"VALUE_RESTRICTION"), root_1);
							this.adaptor.addChild(root_1,
									stream_propertyExpression.nextTree());
							this.adaptor.addChild(root_1, stream_value
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
		} catch (RewriteEmptyStreamException e) {
			throw e;
		} finally {
		}
		return retval;
	}

	// $ANTLR end "valueRestriction"
	public static class value_return extends ParserRuleReturnScope {
		OPPLSyntaxTree tree;

		@Override
		public Object getTree() {
			return this.tree;
		}
	};

	// $ANTLR start "value"
	// MOWLParser.g:181:1: value : ( atomic -> ^( atomic ) | constant -> ^(
	// constant ) );
	public final OPPLParser_MOWLParser.value_return value()
			throws RecognitionException {
		OPPLParser_MOWLParser.value_return retval = new OPPLParser_MOWLParser.value_return();
		retval.start = this.input.LT(1);
		OPPLSyntaxTree root_0 = null;
		OPPLParser.atomic_return atomic86 = null;
		OPPLParser_MOWLParser.constant_return constant87 = null;
		RewriteRuleSubtreeStream stream_constant = new RewriteRuleSubtreeStream(
				this.adaptor, "rule constant");
		RewriteRuleSubtreeStream stream_atomic = new RewriteRuleSubtreeStream(
				this.adaptor, "rule atomic");
		try {
			// MOWLParser.g:181:6: ( atomic -> ^( atomic ) | constant -> ^(
			// constant ) )
			int alt18 = 2;
			int LA18_0 = this.input.LA(1);
			if (LA18_0 >= IDENTIFIER && LA18_0 <= ENTITY_REFERENCE
					|| LA18_0 == VARIABLE_NAME || LA18_0 == ESCLAMATION_MARK) {
				alt18 = 1;
			} else if (LA18_0 == DBLQUOTE) {
				alt18 = 2;
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
				// MOWLParser.g:182:7: atomic
			{
				this.pushFollow(FOLLOW_atomic_in_value1655);
				atomic86 = this.gOPPLParser.atomic();
				this.state._fsp--;
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_atomic.add(atomic86.getTree());
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
					// 182:14: -> ^( atomic )
					{
						// MOWLParser.g:182:17: ^( atomic )
						{
							OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor
									.nil();
							root_1 = (OPPLSyntaxTree) this.adaptor.becomeRoot(
									stream_atomic.nextNode(), root_1);
							this.adaptor.addChild(root_0, root_1);
						}
					}
					retval.tree = root_0;
				}
			}
				break;
			case 2:
				// MOWLParser.g:183:7: constant
			{
				this.pushFollow(FOLLOW_constant_in_value1670);
				constant87 = this.constant();
				this.state._fsp--;
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_constant.add(constant87.getTree());
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
							this.adaptor, "rule retval",
							retval != null ? retval.tree : null);
					root_0 = (OPPLSyntaxTree) this.adaptor.nil();
					// 183:16: -> ^( constant )
					{
						// MOWLParser.g:183:19: ^( constant )
						{
							OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor
									.nil();
							root_1 = (OPPLSyntaxTree) this.adaptor.becomeRoot(
									stream_constant.nextNode(), root_1);
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

	// $ANTLR end "value"
	public static class constant_return extends ParserRuleReturnScope {
		OPPLSyntaxTree tree;

		@Override
		public Object getTree() {
			return this.tree;
		}
	};

	// $ANTLR start "constant"
	// MOWLParser.g:186:1: constant : constantValue= DBLQUOTE ( POW type=
	// IDENTIFIER )? -> ^( CONSTANT $constantValue ( $type)? ) ;
	public final OPPLParser_MOWLParser.constant_return constant()
			throws RecognitionException {
		OPPLParser_MOWLParser.constant_return retval = new OPPLParser_MOWLParser.constant_return();
		retval.start = this.input.LT(1);
		OPPLSyntaxTree root_0 = null;
		Token constantValue = null;
		Token type = null;
		Token POW88 = null;
		OPPLSyntaxTree constantValue_tree = null;
		OPPLSyntaxTree type_tree = null;
		OPPLSyntaxTree POW88_tree = null;
		RewriteRuleTokenStream stream_POW = new RewriteRuleTokenStream(
				this.adaptor, "token POW");
		RewriteRuleTokenStream stream_IDENTIFIER = new RewriteRuleTokenStream(
				this.adaptor, "token IDENTIFIER");
		RewriteRuleTokenStream stream_DBLQUOTE = new RewriteRuleTokenStream(
				this.adaptor, "token DBLQUOTE");
		try {
			// MOWLParser.g:186:11: (constantValue= DBLQUOTE ( POW type=
			// IDENTIFIER )? -> ^( CONSTANT $constantValue ( $type)? ) )
			// MOWLParser.g:186:14: constantValue= DBLQUOTE ( POW type=
			// IDENTIFIER )?
			{
				constantValue = (Token) this.match(this.input, DBLQUOTE,
						FOLLOW_DBLQUOTE_in_constant1695);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_DBLQUOTE.add(constantValue);
				}
				// MOWLParser.g:186:39: ( POW type= IDENTIFIER )?
				int alt19 = 2;
				int LA19_0 = this.input.LA(1);
				if (LA19_0 == POW) {
					alt19 = 1;
				}
				switch (alt19) {
				case 1:
					// MOWLParser.g:186:41: POW type= IDENTIFIER
				{
					POW88 = (Token) this.match(this.input, POW,
							FOLLOW_POW_in_constant1699);
					if (this.state.failed) {
						return retval;
					}
					if (this.state.backtracking == 0) {
						stream_POW.add(POW88);
					}
					type = (Token) this.match(this.input, IDENTIFIER,
							FOLLOW_IDENTIFIER_in_constant1705);
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
				// elements: constantValue, type
				// token labels: constantValue, type
				// rule labels: retval
				// token list labels:
				// rule list labels:
				// wildcard labels:
				if (this.state.backtracking == 0) {
					retval.tree = root_0;
					RewriteRuleTokenStream stream_constantValue = new RewriteRuleTokenStream(
							this.adaptor, "token constantValue", constantValue);
					RewriteRuleTokenStream stream_type = new RewriteRuleTokenStream(
							this.adaptor, "token type", type);
					RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(
							this.adaptor, "rule retval",
							retval != null ? retval.tree : null);
					root_0 = (OPPLSyntaxTree) this.adaptor.nil();
					// 186:65: -> ^( CONSTANT $constantValue ( $type)? )
					{
						// MOWLParser.g:186:67: ^( CONSTANT $constantValue (
						// $type)? )
						{
							OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor
									.nil();
							root_1 = (OPPLSyntaxTree) this.adaptor.becomeRoot(
									this.adaptor.create(CONSTANT, "CONSTANT"),
									root_1);
							this.adaptor.addChild(root_1, stream_constantValue
									.nextNode());
							// MOWLParser.g:186:93: ( $type)?
							if (stream_type.hasNext()) {
								this.adaptor.addChild(root_1, stream_type
										.nextNode());
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

	// $ANTLR end "constant"
	// $ANTLR start synpred3_MOWLParser
	public final void synpred3_MOWLParser_fragment()
			throws RecognitionException {
		OPPLParser_MOWLParser.expression_return lhs = null;
		OPPLParser_MOWLParser.expression_return superClass = null;
		// MOWLParser.g:83:2: (lhs= expression SUBCLASS_OF superClass=
		// expression )
		// MOWLParser.g:83:2: lhs= expression SUBCLASS_OF superClass= expression
		{
			this.pushFollow(FOLLOW_expression_in_synpred3_MOWLParser393);
			lhs = this.expression();
			this.state._fsp--;
			if (this.state.failed) {
				return;
			}
			this.match(this.input, SUBCLASS_OF,
					FOLLOW_SUBCLASS_OF_in_synpred3_MOWLParser395);
			if (this.state.failed) {
				return;
			}
			this.pushFollow(FOLLOW_expression_in_synpred3_MOWLParser402);
			superClass = this.expression();
			this.state._fsp--;
			if (this.state.failed) {
				return;
			}
		}
	}

	// $ANTLR end synpred3_MOWLParser
	// $ANTLR start synpred4_MOWLParser
	public final void synpred4_MOWLParser_fragment()
			throws RecognitionException {
		OPPLParser_MOWLParser.expression_return lhs = null;
		OPPLParser_MOWLParser.expression_return rhs = null;
		// MOWLParser.g:84:11: (lhs= expression EQUIVALENT_TO rhs= expression )
		// MOWLParser.g:84:11: lhs= expression EQUIVALENT_TO rhs= expression
		{
			this.pushFollow(FOLLOW_expression_in_synpred4_MOWLParser440);
			lhs = this.expression();
			this.state._fsp--;
			if (this.state.failed) {
				return;
			}
			this.match(this.input, EQUIVALENT_TO,
					FOLLOW_EQUIVALENT_TO_in_synpred4_MOWLParser442);
			if (this.state.failed) {
				return;
			}
			this.pushFollow(FOLLOW_expression_in_synpred4_MOWLParser448);
			rhs = this.expression();
			this.state._fsp--;
			if (this.state.failed) {
				return;
			}
		}
	}

	// $ANTLR end synpred4_MOWLParser
	// $ANTLR start synpred5_MOWLParser
	public final void synpred5_MOWLParser_fragment()
			throws RecognitionException {
		OPPLParser_MOWLParser.expression_return lhs = null;
		OPPLParser_MOWLParser.expression_return disjoint = null;
		// MOWLParser.g:85:11: (lhs= expression DISJOINT_WITH disjoint=
		// expression )
		// MOWLParser.g:85:11: lhs= expression DISJOINT_WITH disjoint=
		// expression
		{
			this.pushFollow(FOLLOW_expression_in_synpred5_MOWLParser485);
			lhs = this.expression();
			this.state._fsp--;
			if (this.state.failed) {
				return;
			}
			this.match(this.input, DISJOINT_WITH,
					FOLLOW_DISJOINT_WITH_in_synpred5_MOWLParser487);
			if (this.state.failed) {
				return;
			}
			this.pushFollow(FOLLOW_expression_in_synpred5_MOWLParser493);
			disjoint = this.expression();
			this.state._fsp--;
			if (this.state.failed) {
				return;
			}
		}
	}

	// $ANTLR end synpred5_MOWLParser
	// $ANTLR start synpred6_MOWLParser
	public final void synpred6_MOWLParser_fragment()
			throws RecognitionException {
		OPPLParser_MOWLParser.expression_return lhs = null;
		OPPLParser_MOWLParser.propertyExpression_return superProperty = null;
		// MOWLParser.g:86:11: (lhs= expression SUB_PROPERTY_OF superProperty=
		// propertyExpression )
		// MOWLParser.g:86:11: lhs= expression SUB_PROPERTY_OF superProperty=
		// propertyExpression
		{
			this.pushFollow(FOLLOW_expression_in_synpred6_MOWLParser530);
			lhs = this.expression();
			this.state._fsp--;
			if (this.state.failed) {
				return;
			}
			this.match(this.input, SUB_PROPERTY_OF,
					FOLLOW_SUB_PROPERTY_OF_in_synpred6_MOWLParser532);
			if (this.state.failed) {
				return;
			}
			this
					.pushFollow(FOLLOW_propertyExpression_in_synpred6_MOWLParser538);
			superProperty = this.propertyExpression();
			this.state._fsp--;
			if (this.state.failed) {
				return;
			}
		}
	}

	// $ANTLR end synpred6_MOWLParser
	// $ANTLR start synpred7_MOWLParser
	public final void synpred7_MOWLParser_fragment()
			throws RecognitionException {
		OPPLParser.atomic_return lhsID = null;
		OPPLParser.atomic_return rhsAtomic = null;
		// MOWLParser.g:87:11: (lhsID= atomic INVERSE_OF rhsAtomic= atomic )
		// MOWLParser.g:87:11: lhsID= atomic INVERSE_OF rhsAtomic= atomic
		{
			this.pushFollow(FOLLOW_atomic_in_synpred7_MOWLParser575);
			lhsID = this.gOPPLParser.atomic();
			this.state._fsp--;
			if (this.state.failed) {
				return;
			}
			this.match(this.input, INVERSE_OF,
					FOLLOW_INVERSE_OF_in_synpred7_MOWLParser577);
			if (this.state.failed) {
				return;
			}
			this.pushFollow(FOLLOW_atomic_in_synpred7_MOWLParser583);
			rhsAtomic = this.gOPPLParser.atomic();
			this.state._fsp--;
			if (this.state.failed) {
				return;
			}
		}
	}

	// $ANTLR end synpred7_MOWLParser
	// $ANTLR start synpred8_MOWLParser
	public final void synpred8_MOWLParser_fragment()
			throws RecognitionException {
		OPPLParser.atomic_return lhsID = null;
		OPPLParser.atomic_return rhsID = null;
		// MOWLParser.g:88:3: (lhsID= atomic SAME_AS rhsID= atomic )
		// MOWLParser.g:88:3: lhsID= atomic SAME_AS rhsID= atomic
		{
			this.pushFollow(FOLLOW_atomic_in_synpred8_MOWLParser614);
			lhsID = this.gOPPLParser.atomic();
			this.state._fsp--;
			if (this.state.failed) {
				return;
			}
			this.match(this.input, SAME_AS,
					FOLLOW_SAME_AS_in_synpred8_MOWLParser616);
			if (this.state.failed) {
				return;
			}
			this.pushFollow(FOLLOW_atomic_in_synpred8_MOWLParser623);
			rhsID = this.gOPPLParser.atomic();
			this.state._fsp--;
			if (this.state.failed) {
				return;
			}
		}
	}

	// $ANTLR end synpred8_MOWLParser
	// $ANTLR start synpred9_MOWLParser
	public final void synpred9_MOWLParser_fragment()
			throws RecognitionException {
		OPPLParser.atomic_return lhsID = null;
		OPPLParser.atomic_return rhsID = null;
		// MOWLParser.g:89:11: (lhsID= atomic DIFFERENT_FROM rhsID= atomic )
		// MOWLParser.g:89:11: lhsID= atomic DIFFERENT_FROM rhsID= atomic
		{
			this.pushFollow(FOLLOW_atomic_in_synpred9_MOWLParser661);
			lhsID = this.gOPPLParser.atomic();
			this.state._fsp--;
			if (this.state.failed) {
				return;
			}
			this.match(this.input, DIFFERENT_FROM,
					FOLLOW_DIFFERENT_FROM_in_synpred9_MOWLParser663);
			if (this.state.failed) {
				return;
			}
			this.pushFollow(FOLLOW_atomic_in_synpred9_MOWLParser670);
			rhsID = this.gOPPLParser.atomic();
			this.state._fsp--;
			if (this.state.failed) {
				return;
			}
		}
	}

	// $ANTLR end synpred9_MOWLParser
	// $ANTLR start synpred10_MOWLParser
	public final void synpred10_MOWLParser_fragment()
			throws RecognitionException {
		OPPLParser.atomic_return lhsID = null;
		// MOWLParser.g:90:11: (lhsID= atomic DOMAIN expression )
		// MOWLParser.g:90:11: lhsID= atomic DOMAIN expression
		{
			this.pushFollow(FOLLOW_atomic_in_synpred10_MOWLParser707);
			lhsID = this.gOPPLParser.atomic();
			this.state._fsp--;
			if (this.state.failed) {
				return;
			}
			this.match(this.input, DOMAIN,
					FOLLOW_DOMAIN_in_synpred10_MOWLParser710);
			if (this.state.failed) {
				return;
			}
			this.pushFollow(FOLLOW_expression_in_synpred10_MOWLParser712);
			this.expression();
			this.state._fsp--;
			if (this.state.failed) {
				return;
			}
		}
	}

	// $ANTLR end synpred10_MOWLParser
	// $ANTLR start synpred12_MOWLParser
	public final void synpred12_MOWLParser_fragment()
			throws RecognitionException {
		// MOWLParser.g:112:6: ( conjunction ( OR conjunction )* )
		// MOWLParser.g:112:6: conjunction ( OR conjunction )*
		{
			this.pushFollow(FOLLOW_conjunction_in_synpred12_MOWLParser1002);
			this.conjunction();
			this.state._fsp--;
			if (this.state.failed) {
				return;
			}
			// MOWLParser.g:112:18: ( OR conjunction )*
			loop20: do {
				int alt20 = 2;
				int LA20_0 = this.input.LA(1);
				if (LA20_0 == OR) {
					alt20 = 1;
				}
				switch (alt20) {
				case 1:
					// MOWLParser.g:112:19: OR conjunction
				{
					this.match(this.input, OR,
							FOLLOW_OR_in_synpred12_MOWLParser1005);
					if (this.state.failed) {
						return;
					}
					this
							.pushFollow(FOLLOW_conjunction_in_synpred12_MOWLParser1007);
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

	// $ANTLR end synpred12_MOWLParser
	// $ANTLR start synpred13_MOWLParser
	public final void synpred13_MOWLParser_fragment()
			throws RecognitionException {
		// MOWLParser.g:113:6: ( complexPropertyExpression )
		// MOWLParser.g:113:6: complexPropertyExpression
		{
			this
					.pushFollow(FOLLOW_complexPropertyExpression_in_synpred13_MOWLParser1026);
			this.complexPropertyExpression();
			this.state._fsp--;
			if (this.state.failed) {
				return;
			}
		}
	}

	// $ANTLR end synpred13_MOWLParser
	// $ANTLR start synpred14_MOWLParser
	public final void synpred14_MOWLParser_fragment()
			throws RecognitionException {
		List list_rest = null;
		OPPLParser_MOWLParser.propertyExpression_return head = null;
		RuleReturnScope rest = null;
		// MOWLParser.g:133:4: (head= propertyExpression ( COMPOSITION rest+=
		// propertyExpression )+ )
		// MOWLParser.g:133:4: head= propertyExpression ( COMPOSITION rest+=
		// propertyExpression )+
		{
			this
					.pushFollow(FOLLOW_propertyExpression_in_synpred14_MOWLParser1164);
			head = this.propertyExpression();
			this.state._fsp--;
			if (this.state.failed) {
				return;
			}
			// MOWLParser.g:133:30: ( COMPOSITION rest+= propertyExpression )+
			int cnt21 = 0;
			loop21: do {
				int alt21 = 2;
				int LA21_0 = this.input.LA(1);
				if (LA21_0 == COMPOSITION) {
					alt21 = 1;
				}
				switch (alt21) {
				case 1:
					// MOWLParser.g:133:31: COMPOSITION rest+=
					// propertyExpression
				{
					this.match(this.input, COMPOSITION,
							FOLLOW_COMPOSITION_in_synpred14_MOWLParser1167);
					if (this.state.failed) {
						return;
					}
					this
							.pushFollow(FOLLOW_propertyExpression_in_synpred14_MOWLParser1171);
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
					EarlyExitException eee = new EarlyExitException(21,
							this.input);
					throw eee;
				}
				cnt21++;
			} while (true);
		}
	}

	// $ANTLR end synpred14_MOWLParser
	// $ANTLR start synpred15_MOWLParser
	public final void synpred15_MOWLParser_fragment()
			throws RecognitionException {
		// MOWLParser.g:134:5: ( NOT OPEN_PARENTHESYS expression
		// CLOSED_PARENTHESYS )
		// MOWLParser.g:134:5: NOT OPEN_PARENTHESYS expression
		// CLOSED_PARENTHESYS
		{
			this.match(this.input, NOT, FOLLOW_NOT_in_synpred15_MOWLParser1193);
			if (this.state.failed) {
				return;
			}
			this.match(this.input, OPEN_PARENTHESYS,
					FOLLOW_OPEN_PARENTHESYS_in_synpred15_MOWLParser1195);
			if (this.state.failed) {
				return;
			}
			this.pushFollow(FOLLOW_expression_in_synpred15_MOWLParser1197);
			this.expression();
			this.state._fsp--;
			if (this.state.failed) {
				return;
			}
			this.match(this.input, CLOSED_PARENTHESYS,
					FOLLOW_CLOSED_PARENTHESYS_in_synpred15_MOWLParser1199);
			if (this.state.failed) {
				return;
			}
		}
	}

	// $ANTLR end synpred15_MOWLParser
	// $ANTLR start synpred16_MOWLParser
	public final void synpred16_MOWLParser_fragment()
			throws RecognitionException {
		// MOWLParser.g:135:5: ( NOT atomic )
		// MOWLParser.g:135:5: NOT atomic
		{
			this.match(this.input, NOT, FOLLOW_NOT_in_synpred16_MOWLParser1213);
			if (this.state.failed) {
				return;
			}
			this.pushFollow(FOLLOW_atomic_in_synpred16_MOWLParser1215);
			this.gOPPLParser.atomic();
			this.state._fsp--;
			if (this.state.failed) {
				return;
			}
		}
	}

	// $ANTLR end synpred16_MOWLParser
	// $ANTLR start synpred17_MOWLParser
	public final void synpred17_MOWLParser_fragment()
			throws RecognitionException {
		// MOWLParser.g:136:5: ( qualifiedRestriction )
		// MOWLParser.g:136:5: qualifiedRestriction
		{
			this
					.pushFollow(FOLLOW_qualifiedRestriction_in_synpred17_MOWLParser1238);
			this.qualifiedRestriction();
			this.state._fsp--;
			if (this.state.failed) {
				return;
			}
		}
	}

	// $ANTLR end synpred17_MOWLParser
	// $ANTLR start synpred19_MOWLParser
	public final void synpred19_MOWLParser_fragment()
			throws RecognitionException {
		// MOWLParser.g:149:7: ( propertyExpression SOME expression )
		// MOWLParser.g:149:7: propertyExpression SOME expression
		{
			this
					.pushFollow(FOLLOW_propertyExpression_in_synpred19_MOWLParser1329);
			this.propertyExpression();
			this.state._fsp--;
			if (this.state.failed) {
				return;
			}
			this.match(this.input, SOME,
					FOLLOW_SOME_in_synpred19_MOWLParser1332);
			if (this.state.failed) {
				return;
			}
			this.pushFollow(FOLLOW_expression_in_synpred19_MOWLParser1336);
			this.expression();
			this.state._fsp--;
			if (this.state.failed) {
				return;
			}
		}
	}

	// $ANTLR end synpred19_MOWLParser
	// $ANTLR start synpred20_MOWLParser
	public final void synpred20_MOWLParser_fragment()
			throws RecognitionException {
		// MOWLParser.g:150:7: ( propertyExpression ONLY expression )
		// MOWLParser.g:150:7: propertyExpression ONLY expression
		{
			this
					.pushFollow(FOLLOW_propertyExpression_in_synpred20_MOWLParser1365);
			this.propertyExpression();
			this.state._fsp--;
			if (this.state.failed) {
				return;
			}
			this.match(this.input, ONLY,
					FOLLOW_ONLY_in_synpred20_MOWLParser1367);
			if (this.state.failed) {
				return;
			}
			this.pushFollow(FOLLOW_expression_in_synpred20_MOWLParser1370);
			this.expression();
			this.state._fsp--;
			if (this.state.failed) {
				return;
			}
		}
	}

	// $ANTLR end synpred20_MOWLParser
	// $ANTLR start synpred21_MOWLParser
	public final void synpred21_MOWLParser_fragment()
			throws RecognitionException {
		// MOWLParser.g:151:7: ( cardinalityRestriction )
		// MOWLParser.g:151:7: cardinalityRestriction
		{
			this
					.pushFollow(FOLLOW_cardinalityRestriction_in_synpred21_MOWLParser1389);
			this.cardinalityRestriction();
			this.state._fsp--;
			if (this.state.failed) {
				return;
			}
		}
	}

	// $ANTLR end synpred21_MOWLParser
	// Delegated rules
	public final boolean synpred21_MOWLParser() {
		this.state.backtracking++;
		int start = this.input.mark();
		try {
			this.synpred21_MOWLParser_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: " + re);
		}
		boolean success = !this.state.failed;
		this.input.rewind(start);
		this.state.backtracking--;
		this.state.failed = false;
		return success;
	}

	public final boolean synpred3_MOWLParser() {
		this.state.backtracking++;
		int start = this.input.mark();
		try {
			this.synpred3_MOWLParser_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: " + re);
		}
		boolean success = !this.state.failed;
		this.input.rewind(start);
		this.state.backtracking--;
		this.state.failed = false;
		return success;
	}

	public final boolean synpred17_MOWLParser() {
		this.state.backtracking++;
		int start = this.input.mark();
		try {
			this.synpred17_MOWLParser_fragment(); // can never throw exception
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

	public final boolean synpred19_MOWLParser() {
		this.state.backtracking++;
		int start = this.input.mark();
		try {
			this.synpred19_MOWLParser_fragment(); // can never throw exception
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

	public final boolean synpred14_MOWLParser() {
		this.state.backtracking++;
		int start = this.input.mark();
		try {
			this.synpred14_MOWLParser_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: " + re);
		}
		boolean success = !this.state.failed;
		this.input.rewind(start);
		this.state.backtracking--;
		this.state.failed = false;
		return success;
	}

	public final boolean synpred16_MOWLParser() {
		this.state.backtracking++;
		int start = this.input.mark();
		try {
			this.synpred16_MOWLParser_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: " + re);
		}
		boolean success = !this.state.failed;
		this.input.rewind(start);
		this.state.backtracking--;
		this.state.failed = false;
		return success;
	}

	public final boolean synpred15_MOWLParser() {
		this.state.backtracking++;
		int start = this.input.mark();
		try {
			this.synpred15_MOWLParser_fragment(); // can never throw exception
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

	public final boolean synpred20_MOWLParser() {
		this.state.backtracking++;
		int start = this.input.mark();
		try {
			this.synpred20_MOWLParser_fragment(); // can never throw exception
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

	protected DFA1 dfa1 = new DFA1(this);
	protected DFA3 dfa3 = new DFA3(this);
	protected DFA4 dfa4 = new DFA4(this);
	protected DFA7 dfa7 = new DFA7(this);
	protected DFA11 dfa11 = new DFA11(this);
	protected DFA13 dfa13 = new DFA13(this);
	static final String DFA1_eotS = "\35\uffff";
	static final String DFA1_eofS = "\35\uffff";
	static final String DFA1_minS = "\1\35\1\uffff\3\33\1\64\1\35\2\uffff\1\155\4\33\1\64\1\57\2\33\1"
			+ "\155\1\33\1\70\1\57\2\33\1\60\1\70\1\33\1\60\1\33";
	static final String DFA1_maxS = "\1\153\1\uffff\2\153\1\154\1\64\1\153\2\uffff\1\157\3\153\1\154"
			+ "\1\64\1\57\2\153\1\157\1\153\1\70\1\57\2\153\1\60\1\70\1\153\1\60"
			+ "\1\153";
	static final String DFA1_acceptS = "\1\uffff\1\1\5\uffff\1\2\1\3\24\uffff";
	static final String DFA1_specialS = "\35\uffff}>";
	static final String[] DFA1_transitionS = {
			"\1\6\4\1\5\uffff\7\7\1\uffff\1\1\2\uffff\1\1\1\uffff\1\2\1\3"
					+ "\6\uffff\1\1\3\uffff\1\1\22\uffff\1\4\27\uffff\1\5",
			"",
			"\2\10\1\uffff\11\1\7\uffff\1\1\2\uffff\1\1\1\10\1\1\2\10\2"
					+ "\1\1\uffff\3\1\3\uffff\1\1\23\uffff\1\10\27\uffff\1\10",
			"\2\10\1\uffff\11\1\7\uffff\1\1\2\uffff\1\1\1\10\1\1\2\10\2"
					+ "\1\1\uffff\3\1\3\uffff\1\1\23\uffff\1\10\27\uffff\1\10",
			"\2\10\1\uffff\11\1\7\uffff\1\1\2\uffff\1\1\1\10\1\1\2\10\2"
					+ "\1\1\uffff\3\1\3\uffff\1\1\23\uffff\1\10\27\uffff\1\10\1\11",
			"\1\12",
			"\1\10\21\uffff\1\1\4\uffff\1\13\1\14\35\uffff\1\15\27\uffff"
					+ "\1\16",
			"",
			"",
			"\1\20\1\21\1\17",
			"\2\10\1\uffff\11\1\7\uffff\1\1\2\uffff\1\1\1\10\1\1\2\10\2"
					+ "\1\1\uffff\3\1\3\uffff\1\1\23\uffff\1\10\27\uffff\1\10",
			"\2\10\1\uffff\4\1\14\uffff\1\1\2\uffff\1\1\1\10\1\uffff\2\10"
					+ "\35\uffff\1\10\27\uffff\1\10",
			"\2\10\1\uffff\4\1\14\uffff\1\1\2\uffff\1\1\1\10\1\uffff\2\10"
					+ "\35\uffff\1\10\27\uffff\1\10",
			"\2\10\1\uffff\4\1\14\uffff\1\1\2\uffff\1\1\1\10\1\uffff\2\10"
					+ "\35\uffff\1\10\27\uffff\1\10\1\22",
			"\1\23",
			"\1\24",
			"\2\10\1\uffff\11\1\7\uffff\1\1\2\uffff\1\1\1\10\1\1\2\10\2"
					+ "\1\1\uffff\3\1\3\uffff\1\1\23\uffff\1\10\27\uffff\1\10",
			"\2\10\1\uffff\11\1\7\uffff\1\1\2\uffff\1\1\1\10\1\1\2\10\2"
					+ "\1\1\uffff\3\1\3\uffff\1\1\23\uffff\1\10\27\uffff\1\10",
			"\1\26\1\27\1\25",
			"\2\10\1\uffff\4\1\14\uffff\1\1\2\uffff\1\1\1\10\1\uffff\2\10"
					+ "\35\uffff\1\10\27\uffff\1\10",
			"\1\30",
			"\1\31",
			"\2\10\1\uffff\4\1\14\uffff\1\1\2\uffff\1\1\1\10\1\uffff\2\10"
					+ "\35\uffff\1\10\27\uffff\1\10",
			"\2\10\1\uffff\4\1\14\uffff\1\1\2\uffff\1\1\1\10\1\uffff\2\10"
					+ "\35\uffff\1\10\27\uffff\1\10",
			"\1\32",
			"\1\33",
			"\2\10\1\uffff\11\1\7\uffff\1\1\2\uffff\1\1\1\10\1\1\2\10\2"
					+ "\1\1\uffff\3\1\3\uffff\1\1\23\uffff\1\10\27\uffff\1\10",
			"\1\34",
			"\2\10\1\uffff\4\1\14\uffff\1\1\2\uffff\1\1\1\10\1\uffff\2\10"
					+ "\35\uffff\1\10\27\uffff\1\10" };
	static final short[] DFA1_eot = DFA.unpackEncodedString(DFA1_eotS);
	static final short[] DFA1_eof = DFA.unpackEncodedString(DFA1_eofS);
	static final char[] DFA1_min = DFA
			.unpackEncodedStringToUnsignedChars(DFA1_minS);
	static final char[] DFA1_max = DFA
			.unpackEncodedStringToUnsignedChars(DFA1_maxS);
	static final short[] DFA1_accept = DFA.unpackEncodedString(DFA1_acceptS);
	static final short[] DFA1_special = DFA.unpackEncodedString(DFA1_specialS);
	static final short[][] DFA1_transition;
	static {
		int numStates = DFA1_transitionS.length;
		DFA1_transition = new short[numStates][];
		for (int i = 0; i < numStates; i++) {
			DFA1_transition[i] = DFA.unpackEncodedString(DFA1_transitionS[i]);
		}
	}

	class DFA1 extends DFA {
		public DFA1(BaseRecognizer recognizer) {
			this.recognizer = recognizer;
			this.decisionNumber = 1;
			this.eot = DFA1_eot;
			this.eof = DFA1_eof;
			this.min = DFA1_min;
			this.max = DFA1_max;
			this.accept = DFA1_accept;
			this.special = DFA1_special;
			this.transition = DFA1_transition;
		}

		@Override
		public String getDescription() {
			return "63:1: axiom options {backtrack=true; } : ( binaryAxiom -> ^( binaryAxiom ) | unaryAxiom -> ^( unaryAxiom ) | assertionAxiom -> ^( assertionAxiom ) );";
		}
	}

	static final String DFA3_eotS = "\20\uffff";
	static final String DFA3_eofS = "\20\uffff";
	static final String DFA3_minS = "\1\35\3\33\1\64\3\uffff\1\155\1\33\1\57\2\33\1\70\1\60\1\33";
	static final String DFA3_maxS = "\3\153\1\154\1\64\3\uffff\1\157\1\153\1\57\2\153\1\70\1\60\1\153";
	static final String DFA3_acceptS = "\5\uffff\1\3\1\2\1\1\10\uffff";
	static final String DFA3_specialS = "\20\uffff}>";
	static final String[] DFA3_transitionS = {
			"\1\5\26\uffff\1\1\1\2\35\uffff\1\3\27\uffff\1\4",
			"\2\7\25\uffff\1\6\1\uffff\2\6\35\uffff\1\6\27\uffff\1\6",
			"\2\7\25\uffff\1\6\1\uffff\2\6\35\uffff\1\6\27\uffff\1\6",
			"\2\7\25\uffff\1\6\1\uffff\2\6\35\uffff\1\6\27\uffff\1\6\1\10",
			"\1\11", "", "", "", "\1\13\1\14\1\12",
			"\2\7\25\uffff\1\6\1\uffff\2\6\35\uffff\1\6\27\uffff\1\6", "\1\15",
			"\2\7\25\uffff\1\6\1\uffff\2\6\35\uffff\1\6\27\uffff\1\6",
			"\2\7\25\uffff\1\6\1\uffff\2\6\35\uffff\1\6\27\uffff\1\6", "\1\16",
			"\1\17", "\2\7\25\uffff\1\6\1\uffff\2\6\35\uffff\1\6\27\uffff\1\6" };
	static final short[] DFA3_eot = DFA.unpackEncodedString(DFA3_eotS);
	static final short[] DFA3_eof = DFA.unpackEncodedString(DFA3_eofS);
	static final char[] DFA3_min = DFA
			.unpackEncodedStringToUnsignedChars(DFA3_minS);
	static final char[] DFA3_max = DFA
			.unpackEncodedStringToUnsignedChars(DFA3_maxS);
	static final short[] DFA3_accept = DFA.unpackEncodedString(DFA3_acceptS);
	static final short[] DFA3_special = DFA.unpackEncodedString(DFA3_specialS);
	static final short[][] DFA3_transition;
	static {
		int numStates = DFA3_transitionS.length;
		DFA3_transition = new short[numStates][];
		for (int i = 0; i < numStates; i++) {
			DFA3_transition[i] = DFA.unpackEncodedString(DFA3_transitionS[i]);
		}
	}

	class DFA3 extends DFA {
		public DFA3(BaseRecognizer recognizer) {
			this.recognizer = recognizer;
			this.decisionNumber = 3;
			this.eot = DFA3_eot;
			this.eof = DFA3_eof;
			this.min = DFA3_min;
			this.max = DFA3_max;
			this.accept = DFA3_accept;
			this.special = DFA3_special;
			this.transition = DFA3_transition;
		}

		@Override
		public String getDescription() {
			return "71:1: assertionAxiom : (i= atomic ( INSTANCE_OF | TYPES ) expression -> ^( TYPE_ASSERTION ^( EXPRESSION expression ) ^( EXPRESSION $i) ) | atomic propertyExpression value -> ^( ROLE_ASSERTION ^( EXPRESSION IDENTIFIER ) ^( EXPRESSION propertyExpression ) ^( EXPRESSION value ) ) | NOT assertionAxiom -> ^( NEGATED_ASSERTION assertionAxiom ) );";
		}
	}

	static final String DFA4_eotS = "\23\uffff";
	static final String DFA4_eofS = "\23\uffff";
	static final String DFA4_minS = "\1\35\1\uffff\11\0\10\uffff";
	static final String DFA4_maxS = "\1\153\1\uffff\11\0\10\uffff";
	static final String DFA4_acceptS = "\1\uffff\1\1\11\uffff\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11";
	static final String DFA4_specialS = "\2\uffff\1\0\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\10\uffff}>";
	static final String[] DFA4_transitionS = {
			"\1\7\1\1\1\13\1\14\1\15\15\uffff\1\12\2\uffff\1\6\1\uffff\1"
					+ "\2\1\3\6\uffff\1\10\3\uffff\1\11\22\uffff\1\4\27\uffff\1\5",
			"", "\1\uffff", "\1\uffff", "\1\uffff", "\1\uffff", "\1\uffff",
			"\1\uffff", "\1\uffff", "\1\uffff", "\1\uffff", "", "", "", "", "",
			"", "", "" };
	static final short[] DFA4_eot = DFA.unpackEncodedString(DFA4_eotS);
	static final short[] DFA4_eof = DFA.unpackEncodedString(DFA4_eofS);
	static final char[] DFA4_min = DFA
			.unpackEncodedStringToUnsignedChars(DFA4_minS);
	static final char[] DFA4_max = DFA
			.unpackEncodedStringToUnsignedChars(DFA4_maxS);
	static final short[] DFA4_accept = DFA.unpackEncodedString(DFA4_acceptS);
	static final short[] DFA4_special = DFA.unpackEncodedString(DFA4_specialS);
	static final short[][] DFA4_transition;
	static {
		int numStates = DFA4_transitionS.length;
		DFA4_transition = new short[numStates][];
		for (int i = 0; i < numStates; i++) {
			DFA4_transition[i] = DFA.unpackEncodedString(DFA4_transitionS[i]);
		}
	}

	class DFA4 extends DFA {
		public DFA4(BaseRecognizer recognizer) {
			this.recognizer = recognizer;
			this.decisionNumber = 4;
			this.eot = DFA4_eot;
			this.eof = DFA4_eof;
			this.min = DFA4_min;
			this.max = DFA4_max;
			this.accept = DFA4_accept;
			this.special = DFA4_special;
			this.transition = DFA4_transition;
		}

		@Override
		public String getDescription() {
			return "80:1: binaryAxiom options {backtrack=true; } : (lhs= expression SUBCLASS_OF superClass= expression -> ^( SUB_CLASS_AXIOM ^( EXPRESSION $lhs) ^( EXPRESSION $superClass) ) | lhs= expression EQUIVALENT_TO rhs= expression -> ^( EQUIVALENT_TO_AXIOM ^( EXPRESSION $lhs) ^( EXPRESSION $rhs) ) | lhs= expression DISJOINT_WITH disjoint= expression -> ^( DISJOINT_WITH_AXIOM ^( EXPRESSION $lhs) ^( EXPRESSION $disjoint) ) | lhs= expression SUB_PROPERTY_OF superProperty= propertyExpression -> ^( SUB_PROPERTY_AXIOM ^( EXPRESSION $lhs) ^( EXPRESSION $superProperty) ) | lhsID= atomic INVERSE_OF rhsAtomic= atomic -> ^( INVERSE_OF ^( EXPRESSION $lhsID) ^( EXPRESSION $rhsAtomic) ) | lhsID= atomic SAME_AS rhsID= atomic -> ^( SAME_AS_AXIOM ^( EXPRESSION $lhsID) ^( EXPRESSION $rhsID) ) | lhsID= atomic DIFFERENT_FROM rhsID= atomic -> ^( DIFFERENT_FROM_AXIOM ^( EXPRESSION $lhsID) ^( EXPRESSION $rhsID) ) | lhsID= atomic DOMAIN expression -> ^( DOMAIN ^( EXPRESSION $lhsID) ^( EXPRESSION expression ) ) | lhsID= atomic RANGE expression -> ^( RANGE ^( EXPRESSION $lhsID) ^( EXPRESSION expression ) ) );";
		}

		@Override
		public int specialStateTransition(int s, IntStream _input)
				throws NoViableAltException {
			TokenStream input = (TokenStream) _input;
			int _s = s;
			switch (s) {
			case 0:
				int LA4_2 = input.LA(1);
				int index4_2 = input.index();
				input.rewind();
				s = -1;
				if (OPPLParser_MOWLParser.this.synpred3_MOWLParser()) {
					s = 1;
				} else if (OPPLParser_MOWLParser.this.synpred4_MOWLParser()) {
					s = 11;
				} else if (OPPLParser_MOWLParser.this.synpred5_MOWLParser()) {
					s = 12;
				} else if (OPPLParser_MOWLParser.this.synpred6_MOWLParser()) {
					s = 13;
				} else if (OPPLParser_MOWLParser.this.synpred7_MOWLParser()) {
					s = 14;
				} else if (OPPLParser_MOWLParser.this.synpred8_MOWLParser()) {
					s = 15;
				} else if (OPPLParser_MOWLParser.this.synpred9_MOWLParser()) {
					s = 16;
				} else if (OPPLParser_MOWLParser.this.synpred10_MOWLParser()) {
					s = 17;
				} else if (true) {
					s = 18;
				}
				input.seek(index4_2);
				if (s >= 0) {
					return s;
				}
				break;
			case 1:
				int LA4_3 = input.LA(1);
				int index4_3 = input.index();
				input.rewind();
				s = -1;
				if (OPPLParser_MOWLParser.this.synpred3_MOWLParser()) {
					s = 1;
				} else if (OPPLParser_MOWLParser.this.synpred4_MOWLParser()) {
					s = 11;
				} else if (OPPLParser_MOWLParser.this.synpred5_MOWLParser()) {
					s = 12;
				} else if (OPPLParser_MOWLParser.this.synpred6_MOWLParser()) {
					s = 13;
				} else if (OPPLParser_MOWLParser.this.synpred7_MOWLParser()) {
					s = 14;
				} else if (OPPLParser_MOWLParser.this.synpred8_MOWLParser()) {
					s = 15;
				} else if (OPPLParser_MOWLParser.this.synpred9_MOWLParser()) {
					s = 16;
				} else if (OPPLParser_MOWLParser.this.synpred10_MOWLParser()) {
					s = 17;
				} else if (true) {
					s = 18;
				}
				input.seek(index4_3);
				if (s >= 0) {
					return s;
				}
				break;
			case 2:
				int LA4_4 = input.LA(1);
				int index4_4 = input.index();
				input.rewind();
				s = -1;
				if (OPPLParser_MOWLParser.this.synpred3_MOWLParser()) {
					s = 1;
				} else if (OPPLParser_MOWLParser.this.synpred4_MOWLParser()) {
					s = 11;
				} else if (OPPLParser_MOWLParser.this.synpred5_MOWLParser()) {
					s = 12;
				} else if (OPPLParser_MOWLParser.this.synpred6_MOWLParser()) {
					s = 13;
				} else if (OPPLParser_MOWLParser.this.synpred7_MOWLParser()) {
					s = 14;
				} else if (OPPLParser_MOWLParser.this.synpred8_MOWLParser()) {
					s = 15;
				} else if (OPPLParser_MOWLParser.this.synpred9_MOWLParser()) {
					s = 16;
				} else if (OPPLParser_MOWLParser.this.synpred10_MOWLParser()) {
					s = 17;
				} else if (true) {
					s = 18;
				}
				input.seek(index4_4);
				if (s >= 0) {
					return s;
				}
				break;
			case 3:
				int LA4_5 = input.LA(1);
				int index4_5 = input.index();
				input.rewind();
				s = -1;
				if (OPPLParser_MOWLParser.this.synpred3_MOWLParser()) {
					s = 1;
				} else if (OPPLParser_MOWLParser.this.synpred4_MOWLParser()) {
					s = 11;
				} else if (OPPLParser_MOWLParser.this.synpred5_MOWLParser()) {
					s = 12;
				} else if (OPPLParser_MOWLParser.this.synpred6_MOWLParser()) {
					s = 13;
				} else if (OPPLParser_MOWLParser.this.synpred7_MOWLParser()) {
					s = 14;
				} else if (OPPLParser_MOWLParser.this.synpred8_MOWLParser()) {
					s = 15;
				} else if (OPPLParser_MOWLParser.this.synpred9_MOWLParser()) {
					s = 16;
				} else if (OPPLParser_MOWLParser.this.synpred10_MOWLParser()) {
					s = 17;
				} else if (true) {
					s = 18;
				}
				input.seek(index4_5);
				if (s >= 0) {
					return s;
				}
				break;
			case 4:
				int LA4_6 = input.LA(1);
				int index4_6 = input.index();
				input.rewind();
				s = -1;
				if (OPPLParser_MOWLParser.this.synpred3_MOWLParser()) {
					s = 1;
				} else if (OPPLParser_MOWLParser.this.synpred4_MOWLParser()) {
					s = 11;
				} else if (OPPLParser_MOWLParser.this.synpred5_MOWLParser()) {
					s = 12;
				} else if (OPPLParser_MOWLParser.this.synpred6_MOWLParser()) {
					s = 13;
				}
				input.seek(index4_6);
				if (s >= 0) {
					return s;
				}
				break;
			case 5:
				int LA4_7 = input.LA(1);
				int index4_7 = input.index();
				input.rewind();
				s = -1;
				if (OPPLParser_MOWLParser.this.synpred3_MOWLParser()) {
					s = 1;
				} else if (OPPLParser_MOWLParser.this.synpred4_MOWLParser()) {
					s = 11;
				} else if (OPPLParser_MOWLParser.this.synpred5_MOWLParser()) {
					s = 12;
				} else if (OPPLParser_MOWLParser.this.synpred6_MOWLParser()) {
					s = 13;
				}
				input.seek(index4_7);
				if (s >= 0) {
					return s;
				}
				break;
			case 6:
				int LA4_8 = input.LA(1);
				int index4_8 = input.index();
				input.rewind();
				s = -1;
				if (OPPLParser_MOWLParser.this.synpred3_MOWLParser()) {
					s = 1;
				} else if (OPPLParser_MOWLParser.this.synpred4_MOWLParser()) {
					s = 11;
				} else if (OPPLParser_MOWLParser.this.synpred5_MOWLParser()) {
					s = 12;
				} else if (OPPLParser_MOWLParser.this.synpred6_MOWLParser()) {
					s = 13;
				}
				input.seek(index4_8);
				if (s >= 0) {
					return s;
				}
				break;
			case 7:
				int LA4_9 = input.LA(1);
				int index4_9 = input.index();
				input.rewind();
				s = -1;
				if (OPPLParser_MOWLParser.this.synpred3_MOWLParser()) {
					s = 1;
				} else if (OPPLParser_MOWLParser.this.synpred4_MOWLParser()) {
					s = 11;
				} else if (OPPLParser_MOWLParser.this.synpred5_MOWLParser()) {
					s = 12;
				} else if (OPPLParser_MOWLParser.this.synpred6_MOWLParser()) {
					s = 13;
				}
				input.seek(index4_9);
				if (s >= 0) {
					return s;
				}
				break;
			case 8:
				int LA4_10 = input.LA(1);
				int index4_10 = input.index();
				input.rewind();
				s = -1;
				if (OPPLParser_MOWLParser.this.synpred3_MOWLParser()) {
					s = 1;
				} else if (OPPLParser_MOWLParser.this.synpred4_MOWLParser()) {
					s = 11;
				} else if (OPPLParser_MOWLParser.this.synpred5_MOWLParser()) {
					s = 12;
				} else if (OPPLParser_MOWLParser.this.synpred6_MOWLParser()) {
					s = 13;
				}
				input.seek(index4_10);
				if (s >= 0) {
					return s;
				}
				break;
			}
			if (OPPLParser_MOWLParser.this.state.backtracking > 0) {
				OPPLParser_MOWLParser.this.state.failed = true;
				return -1;
			}
			NoViableAltException nvae = new NoViableAltException(this
					.getDescription(), 4, _s, input);
			this.error(nvae);
			throw nvae;
		}
	}

	static final String DFA7_eotS = "\27\uffff";
	static final String DFA7_eofS = "\1\1\26\uffff";
	static final String DFA7_minS = "\1\35\20\uffff\1\0\5\uffff";
	static final String DFA7_maxS = "\1\153\20\uffff\1\0\5\uffff";
	static final String DFA7_acceptS = "\1\uffff\1\1\13\uffff\1\2\7\uffff\1\4\1\3";
	static final String DFA7_specialS = "\21\uffff\1\0\5\uffff}>";
	static final String[] DFA7_transitionS = {
			"\1\15\4\1\14\uffff\1\1\1\25\2\1\1\21\1\uffff\2\15\6\uffff\1"
					+ "\15\1\1\2\uffff\1\15\22\uffff\1\15\10\uffff\1\1\1\uffff\1\1"
					+ "\5\uffff\1\1\6\uffff\1\15", "", "", "", "", "", "", "",
			"", "", "", "", "", "", "", "", "", "\1\uffff", "", "", "", "", "" };
	static final short[] DFA7_eot = DFA.unpackEncodedString(DFA7_eotS);
	static final short[] DFA7_eof = DFA.unpackEncodedString(DFA7_eofS);
	static final char[] DFA7_min = DFA
			.unpackEncodedStringToUnsignedChars(DFA7_minS);
	static final char[] DFA7_max = DFA
			.unpackEncodedStringToUnsignedChars(DFA7_maxS);
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
			return "110:5: ( options {backtrack=true; } : | conjunction ( OR conjunction )* -> ^( DISJUNCTION ( conjunction )+ ) | complexPropertyExpression -> ^( complexPropertyExpression ) | OPEN_PARENTHESYS expression CLOSED_PARENTHESYS -> ^( expression ) )";
		}

		@Override
		public int specialStateTransition(int s, IntStream _input)
				throws NoViableAltException {
			TokenStream input = (TokenStream) _input;
			int _s = s;
			switch (s) {
			case 0:
				int LA7_17 = input.LA(1);
				int index7_17 = input.index();
				input.rewind();
				s = -1;
				if (OPPLParser_MOWLParser.this.synpred12_MOWLParser()) {
					s = 13;
				} else if (OPPLParser_MOWLParser.this.synpred13_MOWLParser()) {
					s = 22;
				}
				input.seek(index7_17);
				if (s >= 0) {
					return s;
				}
				break;
			}
			if (OPPLParser_MOWLParser.this.state.backtracking > 0) {
				OPPLParser_MOWLParser.this.state.failed = true;
				return -1;
			}
			NoViableAltException nvae = new NoViableAltException(this
					.getDescription(), 7, _s, input);
			this.error(nvae);
			throw nvae;
		}
	}

	static final String DFA11_eotS = "\15\uffff";
	static final String DFA11_eofS = "\15\uffff";
	static final String DFA11_minS = "\1\35\6\0\6\uffff";
	static final String DFA11_maxS = "\1\153\6\0\6\uffff";
	static final String DFA11_acceptS = "\7\uffff\1\4\1\5\1\1\1\6\1\2\1\3";
	static final String DFA11_specialS = "\1\uffff\1\0\1\1\1\2\1\3\1\4\1\5\6\uffff}>";
	static final String[] DFA11_transitionS = {
			"\1\6\24\uffff\1\5\1\uffff\1\1\1\2\6\uffff\1\7\3\uffff\1\10\22"
					+ "\uffff\1\3\27\uffff\1\4", "\1\uffff", "\1\uffff",
			"\1\uffff", "\1\uffff", "\1\uffff", "\1\uffff", "", "", "", "", "",
			"" };
	static final short[] DFA11_eot = DFA.unpackEncodedString(DFA11_eotS);
	static final short[] DFA11_eof = DFA.unpackEncodedString(DFA11_eofS);
	static final char[] DFA11_min = DFA
			.unpackEncodedStringToUnsignedChars(DFA11_minS);
	static final char[] DFA11_max = DFA
			.unpackEncodedStringToUnsignedChars(DFA11_maxS);
	static final short[] DFA11_accept = DFA.unpackEncodedString(DFA11_acceptS);
	static final short[] DFA11_special = DFA
			.unpackEncodedString(DFA11_specialS);
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
			return "131:1: unary options {backtrack=true; } : (head= propertyExpression ( COMPOSITION rest+= propertyExpression )+ -> ^( PROPERTY_CHAIN $head $rest) | NOT OPEN_PARENTHESYS expression CLOSED_PARENTHESYS -> ^( NEGATED_EXPRESSION expression ) | NOT atomic -> ^( NEGATED_EXPRESSION atomic ) | qualifiedRestriction -> ^( qualifiedRestriction ) | constant | atomic );";
		}

		@Override
		public int specialStateTransition(int s, IntStream _input)
				throws NoViableAltException {
			TokenStream input = (TokenStream) _input;
			int _s = s;
			switch (s) {
			case 0:
				int LA11_1 = input.LA(1);
				int index11_1 = input.index();
				input.rewind();
				s = -1;
				if (OPPLParser_MOWLParser.this.synpred14_MOWLParser()) {
					s = 9;
				} else if (OPPLParser_MOWLParser.this.synpred17_MOWLParser()) {
					s = 7;
				} else if (true) {
					s = 10;
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
				if (OPPLParser_MOWLParser.this.synpred14_MOWLParser()) {
					s = 9;
				} else if (OPPLParser_MOWLParser.this.synpred17_MOWLParser()) {
					s = 7;
				} else if (true) {
					s = 10;
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
				if (OPPLParser_MOWLParser.this.synpred14_MOWLParser()) {
					s = 9;
				} else if (OPPLParser_MOWLParser.this.synpred17_MOWLParser()) {
					s = 7;
				} else if (true) {
					s = 10;
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
				if (OPPLParser_MOWLParser.this.synpred14_MOWLParser()) {
					s = 9;
				} else if (OPPLParser_MOWLParser.this.synpred17_MOWLParser()) {
					s = 7;
				} else if (true) {
					s = 10;
				}
				input.seek(index11_4);
				if (s >= 0) {
					return s;
				}
				break;
			case 4:
				int LA11_5 = input.LA(1);
				int index11_5 = input.index();
				input.rewind();
				s = -1;
				if (OPPLParser_MOWLParser.this.synpred14_MOWLParser()) {
					s = 9;
				} else if (OPPLParser_MOWLParser.this.synpred17_MOWLParser()) {
					s = 7;
				}
				input.seek(index11_5);
				if (s >= 0) {
					return s;
				}
				break;
			case 5:
				int LA11_6 = input.LA(1);
				int index11_6 = input.index();
				input.rewind();
				s = -1;
				if (OPPLParser_MOWLParser.this.synpred15_MOWLParser()) {
					s = 11;
				} else if (OPPLParser_MOWLParser.this.synpred16_MOWLParser()) {
					s = 12;
				}
				input.seek(index11_6);
				if (s >= 0) {
					return s;
				}
				break;
			}
			if (OPPLParser_MOWLParser.this.state.backtracking > 0) {
				OPPLParser_MOWLParser.this.state.failed = true;
				return -1;
			}
			NoViableAltException nvae = new NoViableAltException(this
					.getDescription(), 11, _s, input);
			this.error(nvae);
			throw nvae;
		}
	}

	static final String DFA13_eotS = "\13\uffff";
	static final String DFA13_eofS = "\13\uffff";
	static final String DFA13_minS = "\1\62\5\0\5\uffff";
	static final String DFA13_maxS = "\1\153\5\0\5\uffff";
	static final String DFA13_acceptS = "\6\uffff\1\4\1\1\1\2\1\3\1\5";
	static final String DFA13_specialS = "\1\uffff\1\0\1\1\1\2\1\3\1\4\5\uffff}>";
	static final String[] DFA13_transitionS = {
			"\1\5\1\uffff\1\1\1\2\6\uffff\1\6\26\uffff\1\3\27\uffff\1\4",
			"\1\uffff", "\1\uffff", "\1\uffff", "\1\uffff", "\1\uffff", "", "",
			"", "", "" };
	static final short[] DFA13_eot = DFA.unpackEncodedString(DFA13_eotS);
	static final short[] DFA13_eof = DFA.unpackEncodedString(DFA13_eofS);
	static final char[] DFA13_min = DFA
			.unpackEncodedStringToUnsignedChars(DFA13_minS);
	static final char[] DFA13_max = DFA
			.unpackEncodedStringToUnsignedChars(DFA13_maxS);
	static final short[] DFA13_accept = DFA.unpackEncodedString(DFA13_acceptS);
	static final short[] DFA13_special = DFA
			.unpackEncodedString(DFA13_specialS);
	static final short[][] DFA13_transition;
	static {
		int numStates = DFA13_transitionS.length;
		DFA13_transition = new short[numStates][];
		for (int i = 0; i < numStates; i++) {
			DFA13_transition[i] = DFA.unpackEncodedString(DFA13_transitionS[i]);
		}
	}

	class DFA13 extends DFA {
		public DFA13(BaseRecognizer recognizer) {
			this.recognizer = recognizer;
			this.decisionNumber = 13;
			this.eot = DFA13_eot;
			this.eof = DFA13_eof;
			this.min = DFA13_min;
			this.max = DFA13_max;
			this.accept = DFA13_accept;
			this.special = DFA13_special;
			this.transition = DFA13_transition;
		}

		@Override
		public String getDescription() {
			return "147:9: ( options {backtrack=true; } : propertyExpression SOME expression -> ^( SOME_RESTRICTION propertyExpression expression ) | propertyExpression ONLY expression -> ^( ALL_RESTRICTION propertyExpression expression ) | cardinalityRestriction -> ^( cardinalityRestriction ) | oneOf -> ^( oneOf ) | valueRestriction -> ^( valueRestriction ) )";
		}

		@Override
		public int specialStateTransition(int s, IntStream _input)
				throws NoViableAltException {
			TokenStream input = (TokenStream) _input;
			int _s = s;
			switch (s) {
			case 0:
				int LA13_1 = input.LA(1);
				int index13_1 = input.index();
				input.rewind();
				s = -1;
				if (OPPLParser_MOWLParser.this.synpred19_MOWLParser()) {
					s = 7;
				} else if (OPPLParser_MOWLParser.this.synpred20_MOWLParser()) {
					s = 8;
				} else if (OPPLParser_MOWLParser.this.synpred21_MOWLParser()) {
					s = 9;
				} else if (true) {
					s = 10;
				}
				input.seek(index13_1);
				if (s >= 0) {
					return s;
				}
				break;
			case 1:
				int LA13_2 = input.LA(1);
				int index13_2 = input.index();
				input.rewind();
				s = -1;
				if (OPPLParser_MOWLParser.this.synpred19_MOWLParser()) {
					s = 7;
				} else if (OPPLParser_MOWLParser.this.synpred20_MOWLParser()) {
					s = 8;
				} else if (OPPLParser_MOWLParser.this.synpred21_MOWLParser()) {
					s = 9;
				} else if (true) {
					s = 10;
				}
				input.seek(index13_2);
				if (s >= 0) {
					return s;
				}
				break;
			case 2:
				int LA13_3 = input.LA(1);
				int index13_3 = input.index();
				input.rewind();
				s = -1;
				if (OPPLParser_MOWLParser.this.synpred19_MOWLParser()) {
					s = 7;
				} else if (OPPLParser_MOWLParser.this.synpred20_MOWLParser()) {
					s = 8;
				} else if (OPPLParser_MOWLParser.this.synpred21_MOWLParser()) {
					s = 9;
				} else if (true) {
					s = 10;
				}
				input.seek(index13_3);
				if (s >= 0) {
					return s;
				}
				break;
			case 3:
				int LA13_4 = input.LA(1);
				int index13_4 = input.index();
				input.rewind();
				s = -1;
				if (OPPLParser_MOWLParser.this.synpred19_MOWLParser()) {
					s = 7;
				} else if (OPPLParser_MOWLParser.this.synpred20_MOWLParser()) {
					s = 8;
				} else if (OPPLParser_MOWLParser.this.synpred21_MOWLParser()) {
					s = 9;
				} else if (true) {
					s = 10;
				}
				input.seek(index13_4);
				if (s >= 0) {
					return s;
				}
				break;
			case 4:
				int LA13_5 = input.LA(1);
				int index13_5 = input.index();
				input.rewind();
				s = -1;
				if (OPPLParser_MOWLParser.this.synpred19_MOWLParser()) {
					s = 7;
				} else if (OPPLParser_MOWLParser.this.synpred20_MOWLParser()) {
					s = 8;
				} else if (OPPLParser_MOWLParser.this.synpred21_MOWLParser()) {
					s = 9;
				} else if (true) {
					s = 10;
				}
				input.seek(index13_5);
				if (s >= 0) {
					return s;
				}
				break;
			}
			if (OPPLParser_MOWLParser.this.state.backtracking > 0) {
				OPPLParser_MOWLParser.this.state.failed = true;
				return -1;
			}
			NoViableAltException nvae = new NoViableAltException(this
					.getDescription(), 13, _s, input);
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
	public static final BitSet FOLLOW_atomic_in_assertionAxiom278 = new BitSet(
			new long[] { 0x0000000018000000L });
	public static final BitSet FOLLOW_INSTANCE_OF_in_assertionAxiom281 = new BitSet(
			new long[] { 0x1034800020000000L, 0x0000080000080001L });
	public static final BitSet FOLLOW_TYPES_in_assertionAxiom285 = new BitSet(
			new long[] { 0x1034800020000000L, 0x0000080000080001L });
	public static final BitSet FOLLOW_expression_in_assertionAxiom288 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_atomic_in_assertionAxiom314 = new BitSet(
			new long[] { 0x0034000000000000L, 0x0000080000080000L });
	public static final BitSet FOLLOW_propertyExpression_in_assertionAxiom316 = new BitSet(
			new long[] { 0x0030000000000000L, 0x0000080000080001L });
	public static final BitSet FOLLOW_value_in_assertionAxiom319 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_NOT_in_assertionAxiom352 = new BitSet(
			new long[] { 0x0030000020000000L, 0x0000080000080000L });
	public static final BitSet FOLLOW_assertionAxiom_in_assertionAxiom354 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_expression_in_binaryAxiom393 = new BitSet(
			new long[] { 0x0000000040000000L });
	public static final BitSet FOLLOW_SUBCLASS_OF_in_binaryAxiom395 = new BitSet(
			new long[] { 0x1034800020000000L, 0x0000080000080001L });
	public static final BitSet FOLLOW_expression_in_binaryAxiom402 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_expression_in_binaryAxiom440 = new BitSet(
			new long[] { 0x0000000080000000L });
	public static final BitSet FOLLOW_EQUIVALENT_TO_in_binaryAxiom442 = new BitSet(
			new long[] { 0x1034800020000000L, 0x0000080000080001L });
	public static final BitSet FOLLOW_expression_in_binaryAxiom448 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_expression_in_binaryAxiom485 = new BitSet(
			new long[] { 0x0000000100000000L });
	public static final BitSet FOLLOW_DISJOINT_WITH_in_binaryAxiom487 = new BitSet(
			new long[] { 0x1034800020000000L, 0x0000080000080001L });
	public static final BitSet FOLLOW_expression_in_binaryAxiom493 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_expression_in_binaryAxiom530 = new BitSet(
			new long[] { 0x0000000200000000L });
	public static final BitSet FOLLOW_SUB_PROPERTY_OF_in_binaryAxiom532 = new BitSet(
			new long[] { 0x0034000000000000L, 0x0000080000080000L });
	public static final BitSet FOLLOW_propertyExpression_in_binaryAxiom538 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_atomic_in_binaryAxiom575 = new BitSet(
			new long[] { 0x0000000400000000L });
	public static final BitSet FOLLOW_INVERSE_OF_in_binaryAxiom577 = new BitSet(
			new long[] { 0x0030000000000000L, 0x0000080000080000L });
	public static final BitSet FOLLOW_atomic_in_binaryAxiom583 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_atomic_in_binaryAxiom614 = new BitSet(
			new long[] { 0x0000000800000000L });
	public static final BitSet FOLLOW_SAME_AS_in_binaryAxiom616 = new BitSet(
			new long[] { 0x0030000000000000L, 0x0000080000080000L });
	public static final BitSet FOLLOW_atomic_in_binaryAxiom623 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_atomic_in_binaryAxiom661 = new BitSet(
			new long[] { 0x0000001000000000L });
	public static final BitSet FOLLOW_DIFFERENT_FROM_in_binaryAxiom663 = new BitSet(
			new long[] { 0x0030000000000000L, 0x0000080000080000L });
	public static final BitSet FOLLOW_atomic_in_binaryAxiom670 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_atomic_in_binaryAxiom707 = new BitSet(
			new long[] { 0x0000002000000000L });
	public static final BitSet FOLLOW_DOMAIN_in_binaryAxiom710 = new BitSet(
			new long[] { 0x1034800020000000L, 0x0000080000080001L });
	public static final BitSet FOLLOW_expression_in_binaryAxiom712 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_atomic_in_binaryAxiom748 = new BitSet(
			new long[] { 0x0000004000000000L });
	public static final BitSet FOLLOW_RANGE_in_binaryAxiom750 = new BitSet(
			new long[] { 0x1034800020000000L, 0x0000080000080001L });
	public static final BitSet FOLLOW_expression_in_binaryAxiom752 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_unaryCharacteristic_in_unaryAxiom826 = new BitSet(
			new long[] { 0x1034000020000000L, 0x0000080000080001L });
	public static final BitSet FOLLOW_unary_in_unaryAxiom830 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_FUNCTIONAL_in_unaryCharacteristic875 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_INVERSE_FUNCTIONAL_in_unaryCharacteristic889 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_SYMMETRIC_in_unaryCharacteristic903 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_ANTI_SYMMETRIC_in_unaryCharacteristic917 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_REFLEXIVE_in_unaryCharacteristic931 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_IRREFLEXIVE_in_unaryCharacteristic945 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_TRANSITIVE_in_unaryCharacteristic959 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_conjunction_in_expression1002 = new BitSet(
			new long[] { 0x0000400000000002L });
	public static final BitSet FOLLOW_OR_in_expression1005 = new BitSet(
			new long[] { 0x1034000020000000L, 0x0000080000080001L });
	public static final BitSet FOLLOW_conjunction_in_expression1007 = new BitSet(
			new long[] { 0x0000400000000002L });
	public static final BitSet FOLLOW_complexPropertyExpression_in_expression1026 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_OPEN_PARENTHESYS_in_expression1039 = new BitSet(
			new long[] { 0x1035800020000000L, 0x0000080000080001L });
	public static final BitSet FOLLOW_expression_in_expression1041 = new BitSet(
			new long[] { 0x0001000000000000L });
	public static final BitSet FOLLOW_CLOSED_PARENTHESYS_in_expression1043 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_unary_in_conjunction1076 = new BitSet(
			new long[] { 0x0002000000000002L });
	public static final BitSet FOLLOW_AND_in_conjunction1079 = new BitSet(
			new long[] { 0x1034000020000000L, 0x0000080000080001L });
	public static final BitSet FOLLOW_unary_in_conjunction1081 = new BitSet(
			new long[] { 0x0002000000000002L });
	public static final BitSet FOLLOW_INVERSE_in_complexPropertyExpression1102 = new BitSet(
			new long[] { 0x0000800000000000L });
	public static final BitSet FOLLOW_OPEN_PARENTHESYS_in_complexPropertyExpression1104 = new BitSet(
			new long[] { 0x0034000000000000L, 0x0000080000080000L });
	public static final BitSet FOLLOW_complexPropertyExpression_in_complexPropertyExpression1106 = new BitSet(
			new long[] { 0x0001000000000000L });
	public static final BitSet FOLLOW_CLOSED_PARENTHESYS_in_complexPropertyExpression1108 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_INVERSE_in_complexPropertyExpression1121 = new BitSet(
			new long[] { 0x0000800000000000L });
	public static final BitSet FOLLOW_OPEN_PARENTHESYS_in_complexPropertyExpression1123 = new BitSet(
			new long[] { 0x0030000000000000L, 0x0000080000080000L });
	public static final BitSet FOLLOW_atomic_in_complexPropertyExpression1125 = new BitSet(
			new long[] { 0x0001000000000000L });
	public static final BitSet FOLLOW_CLOSED_PARENTHESYS_in_complexPropertyExpression1127 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_propertyExpression_in_unary1164 = new BitSet(
			new long[] { 0x0008000000000000L });
	public static final BitSet FOLLOW_COMPOSITION_in_unary1167 = new BitSet(
			new long[] { 0x0034000000000000L, 0x0000080000080000L });
	public static final BitSet FOLLOW_propertyExpression_in_unary1171 = new BitSet(
			new long[] { 0x0008000000000002L });
	public static final BitSet FOLLOW_NOT_in_unary1193 = new BitSet(
			new long[] { 0x0000800000000000L });
	public static final BitSet FOLLOW_OPEN_PARENTHESYS_in_unary1195 = new BitSet(
			new long[] { 0x1035800020000000L, 0x0000080000080001L });
	public static final BitSet FOLLOW_expression_in_unary1197 = new BitSet(
			new long[] { 0x0001000000000000L });
	public static final BitSet FOLLOW_CLOSED_PARENTHESYS_in_unary1199 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_NOT_in_unary1213 = new BitSet(new long[] {
			0x0030000000000000L, 0x0000080000080000L });
	public static final BitSet FOLLOW_atomic_in_unary1215 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_qualifiedRestriction_in_unary1238 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_constant_in_unary1250 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_atomic_in_unary1256 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_propertyExpression_in_qualifiedRestriction1329 = new BitSet(
			new long[] { 0x0040000000000000L });
	public static final BitSet FOLLOW_SOME_in_qualifiedRestriction1332 = new BitSet(
			new long[] { 0x1034800020000000L, 0x0000080000080001L });
	public static final BitSet FOLLOW_expression_in_qualifiedRestriction1336 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_propertyExpression_in_qualifiedRestriction1365 = new BitSet(
			new long[] { 0x0080000000000000L });
	public static final BitSet FOLLOW_ONLY_in_qualifiedRestriction1367 = new BitSet(
			new long[] { 0x1034800020000000L, 0x0000080000080001L });
	public static final BitSet FOLLOW_expression_in_qualifiedRestriction1370 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_cardinalityRestriction_in_qualifiedRestriction1389 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_oneOf_in_qualifiedRestriction1403 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_valueRestriction_in_qualifiedRestriction1417 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_atomic_in_propertyExpression1449 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_complexPropertyExpression_in_propertyExpression1463 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_propertyExpression_in_cardinalityRestriction1505 = new BitSet(
			new long[] { 0x0E00000000000000L });
	public static final BitSet FOLLOW_restrictionKind_in_cardinalityRestriction1508 = new BitSet(
			new long[] { 0x0100000000000000L });
	public static final BitSet FOLLOW_INTEGER_in_cardinalityRestriction1510 = new BitSet(
			new long[] { 0x1034000020000002L, 0x0000080000080001L });
	public static final BitSet FOLLOW_unary_in_cardinalityRestriction1512 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_MIN_in_restrictionKind1545 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_MAX_in_restrictionKind1559 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_EXACTLY_in_restrictionKind1573 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_OPEN_CURLY_BRACES_in_oneOf1595 = new BitSet(
			new long[] { 0x0010000000000000L });
	public static final BitSet FOLLOW_IDENTIFIER_in_oneOf1597 = new BitSet(
			new long[] { 0x6000000000000000L });
	public static final BitSet FOLLOW_COMMA_in_oneOf1600 = new BitSet(
			new long[] { 0x0010000000000000L });
	public static final BitSet FOLLOW_IDENTIFIER_in_oneOf1602 = new BitSet(
			new long[] { 0x6000000000000000L });
	public static final BitSet FOLLOW_CLOSED_CURLY_BRACES_in_oneOf1606 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_propertyExpression_in_valueRestriction1626 = new BitSet(
			new long[] { 0x8000000000000000L });
	public static final BitSet FOLLOW_VALUE_in_valueRestriction1628 = new BitSet(
			new long[] { 0x0030000000000000L, 0x0000080000080001L });
	public static final BitSet FOLLOW_value_in_valueRestriction1630 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_atomic_in_value1655 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_constant_in_value1670 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_DBLQUOTE_in_constant1695 = new BitSet(
			new long[] { 0x0000000000000002L, 0x0000000000000002L });
	public static final BitSet FOLLOW_POW_in_constant1699 = new BitSet(
			new long[] { 0x0010000000000000L });
	public static final BitSet FOLLOW_IDENTIFIER_in_constant1705 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_expression_in_synpred3_MOWLParser393 = new BitSet(
			new long[] { 0x0000000040000000L });
	public static final BitSet FOLLOW_SUBCLASS_OF_in_synpred3_MOWLParser395 = new BitSet(
			new long[] { 0x1034800020000000L, 0x0000080000080001L });
	public static final BitSet FOLLOW_expression_in_synpred3_MOWLParser402 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_expression_in_synpred4_MOWLParser440 = new BitSet(
			new long[] { 0x0000000080000000L });
	public static final BitSet FOLLOW_EQUIVALENT_TO_in_synpred4_MOWLParser442 = new BitSet(
			new long[] { 0x1034800020000000L, 0x0000080000080001L });
	public static final BitSet FOLLOW_expression_in_synpred4_MOWLParser448 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_expression_in_synpred5_MOWLParser485 = new BitSet(
			new long[] { 0x0000000100000000L });
	public static final BitSet FOLLOW_DISJOINT_WITH_in_synpred5_MOWLParser487 = new BitSet(
			new long[] { 0x1034800020000000L, 0x0000080000080001L });
	public static final BitSet FOLLOW_expression_in_synpred5_MOWLParser493 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_expression_in_synpred6_MOWLParser530 = new BitSet(
			new long[] { 0x0000000200000000L });
	public static final BitSet FOLLOW_SUB_PROPERTY_OF_in_synpred6_MOWLParser532 = new BitSet(
			new long[] { 0x0034000000000000L, 0x0000080000080000L });
	public static final BitSet FOLLOW_propertyExpression_in_synpred6_MOWLParser538 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_atomic_in_synpred7_MOWLParser575 = new BitSet(
			new long[] { 0x0000000400000000L });
	public static final BitSet FOLLOW_INVERSE_OF_in_synpred7_MOWLParser577 = new BitSet(
			new long[] { 0x0030000000000000L, 0x0000080000080000L });
	public static final BitSet FOLLOW_atomic_in_synpred7_MOWLParser583 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_atomic_in_synpred8_MOWLParser614 = new BitSet(
			new long[] { 0x0000000800000000L });
	public static final BitSet FOLLOW_SAME_AS_in_synpred8_MOWLParser616 = new BitSet(
			new long[] { 0x0030000000000000L, 0x0000080000080000L });
	public static final BitSet FOLLOW_atomic_in_synpred8_MOWLParser623 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_atomic_in_synpred9_MOWLParser661 = new BitSet(
			new long[] { 0x0000001000000000L });
	public static final BitSet FOLLOW_DIFFERENT_FROM_in_synpred9_MOWLParser663 = new BitSet(
			new long[] { 0x0030000000000000L, 0x0000080000080000L });
	public static final BitSet FOLLOW_atomic_in_synpred9_MOWLParser670 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_atomic_in_synpred10_MOWLParser707 = new BitSet(
			new long[] { 0x0000002000000000L });
	public static final BitSet FOLLOW_DOMAIN_in_synpred10_MOWLParser710 = new BitSet(
			new long[] { 0x1034800020000000L, 0x0000080000080001L });
	public static final BitSet FOLLOW_expression_in_synpred10_MOWLParser712 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_conjunction_in_synpred12_MOWLParser1002 = new BitSet(
			new long[] { 0x0000400000000002L });
	public static final BitSet FOLLOW_OR_in_synpred12_MOWLParser1005 = new BitSet(
			new long[] { 0x1034000020000000L, 0x0000080000080001L });
	public static final BitSet FOLLOW_conjunction_in_synpred12_MOWLParser1007 = new BitSet(
			new long[] { 0x0000400000000002L });
	public static final BitSet FOLLOW_complexPropertyExpression_in_synpred13_MOWLParser1026 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_propertyExpression_in_synpred14_MOWLParser1164 = new BitSet(
			new long[] { 0x0008000000000000L });
	public static final BitSet FOLLOW_COMPOSITION_in_synpred14_MOWLParser1167 = new BitSet(
			new long[] { 0x0034000000000000L, 0x0000080000080000L });
	public static final BitSet FOLLOW_propertyExpression_in_synpred14_MOWLParser1171 = new BitSet(
			new long[] { 0x0008000000000002L });
	public static final BitSet FOLLOW_NOT_in_synpred15_MOWLParser1193 = new BitSet(
			new long[] { 0x0000800000000000L });
	public static final BitSet FOLLOW_OPEN_PARENTHESYS_in_synpred15_MOWLParser1195 = new BitSet(
			new long[] { 0x1035800020000000L, 0x0000080000080001L });
	public static final BitSet FOLLOW_expression_in_synpred15_MOWLParser1197 = new BitSet(
			new long[] { 0x0001000000000000L });
	public static final BitSet FOLLOW_CLOSED_PARENTHESYS_in_synpred15_MOWLParser1199 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_NOT_in_synpred16_MOWLParser1213 = new BitSet(
			new long[] { 0x0030000000000000L, 0x0000080000080000L });
	public static final BitSet FOLLOW_atomic_in_synpred16_MOWLParser1215 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_qualifiedRestriction_in_synpred17_MOWLParser1238 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_propertyExpression_in_synpred19_MOWLParser1329 = new BitSet(
			new long[] { 0x0040000000000000L });
	public static final BitSet FOLLOW_SOME_in_synpred19_MOWLParser1332 = new BitSet(
			new long[] { 0x1034800020000000L, 0x0000080000080001L });
	public static final BitSet FOLLOW_expression_in_synpred19_MOWLParser1336 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_propertyExpression_in_synpred20_MOWLParser1365 = new BitSet(
			new long[] { 0x0080000000000000L });
	public static final BitSet FOLLOW_ONLY_in_synpred20_MOWLParser1367 = new BitSet(
			new long[] { 0x1034800020000000L, 0x0000080000080001L });
	public static final BitSet FOLLOW_expression_in_synpred20_MOWLParser1370 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_cardinalityRestriction_in_synpred21_MOWLParser1389 = new BitSet(
			new long[] { 0x0000000000000002L });
}