package org.coode.parsers.oppl;

// $ANTLR 3.2 Sep 23, 2009 12:02:23 MOWLParser.g 2010-07-12 17:07:47
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
	public static final int REMOVE = 100;
	public static final int TYPES = 28;
	public static final int SAME_AS_AXIOM = 8;
	public static final int INVERSE_OF = 38;
	public static final int NOT = 29;
	public static final int SUBCLASS_OF = 30;
	public static final int EOF = -1;
	public static final int ESCLAMATION_MARK = 105;
	public static final int ACTIONS = 76;
	public static final int CREATE = 101;
	public static final int POW = 65;
	public static final int NOT_EQUAL = 95;
	public static final int INPUT_VARIABLE_DEFINITION = 71;
	public static final int INVERSE_OBJECT_PROPERTY_EXPRESSION = 24;
	public static final int INSTANCE_OF = 27;
	public static final int BEGIN = 97;
	public static final int INEQUALITY_CONSTRAINT = 68;
	public static final int VARIABLE_SCOPE = 79;
	public static final int SYMMETRIC = 41;
	public static final int CARDINALITY_RESTRICTION = 20;
	public static final int SELECT = 92;
	public static final int ROLE_ASSERTION = 23;
	public static final int DIFFERENT_FROM_AXIOM = 9;
	public static final int CREATE_OPPL_FUNCTION = 73;
	public static final int ANTI_SYMMETRIC = 42;
	public static final int TRANSITIVE = 45;
	public static final int ALL_RESTRICTION = 18;
	public static final int CONJUNCTION = 12;
	public static final int NEGATED_ASSERTION = 15;
	public static final int IN_SET_CONSTRAINT = 69;
	public static final int MATCH = 86;
	public static final int VALUE = 63;
	public static final int GROUPS = 109;
	public static final int OPEN_CURLY_BRACES = 60;
	public static final int DISJUNCTION = 11;
	public static final int INVERSE = 49;
	public static final int DBLQUOTE = 64;
	public static final int STRING_OPERATION = 81;
	public static final int OR = 47;
	public static final int CONSTANT = 26;
	public static final int QUERY = 78;
	public static final int ENTITY_REFERENCE = 53;
	public static final int END = 98;
	public static final int COMPOSITION = 46;
	public static final int CLOSED_SQUARE_BRACKET = 91;
	public static final int WHERE = 93;
	public static final int SAME_AS = 34;
	public static final int DISJOINT_WITH = 32;
	public static final int SUPER_PROPERTY_OF = 90;
	public static final int VARIABLE_TYPE = 84;
	public static final int CLOSED_PARENTHESYS = 51;
	public static final int ATTRIBUTE_SELECTOR = 80;
	public static final int EQUIVALENT_TO_AXIOM = 5;
	public static final int ONLY = 55;
	public static final int SUB_PROPERTY_OF = 33;
	public static final int NEGATED_EXPRESSION = 14;
	public static final int MAX = 58;
	public static final int CREATE_DISJUNCTION = 103;
	public static final int AND = 48;
	public static final int ASSERTED_CLAUSE = 66;
	public static final int INVERSE_PROPERTY = 16;
	public static final int VARIABLE_NAME = 82;
	public static final int IN = 96;
	public static final int DIFFERENT_FROM = 35;
	public static final int EQUIVALENT_TO = 31;
	public static final int UNARY_AXIOM = 10;
	public static final int COMMA = 61;
	public static final int CLOSED_CURLY_BRACES = 62;
	public static final int IDENTIFIER = 52;
	public static final int SOME = 54;
	public static final int EQUAL = 85;
	public static final int OPEN_PARENTHESYS = 50;
	public static final int REFLEXIVE = 43;
	public static final int PLUS = 104;
	public static final int DOT = 106;
	public static final int SUPER_CLASS_OF = 89;
	public static final int EXPRESSION = 25;
	public static final int SOME_RESTRICTION = 17;
	public static final int ADD = 99;
	public static final int INTEGER = 56;
	public static final int GENERATED_VARIABLE_DEFINITION = 72;
	public static final int SUB_PROPERTY_AXIOM = 7;
	public static final int EXACTLY = 59;
	public static final int OPEN_SQUARE_BRACKET = 87;
	public static final int VALUES = 107;
	public static final int REGEXP_CONSTRAINT = 70;
	public static final int RANGE = 37;
	public static final int ONE_OF = 21;
	public static final int VARIABLE_DEFINITIONS = 77;
	public static final int SUB_CLASS_AXIOM = 4;
	public static final int MIN = 57;
	public static final int PLAIN_CLAUSE = 67;
	public static final int DOMAIN = 36;
	public static final int SUBPROPERTY_OF = 88;
	public static final int OPPL_FUNCTION = 75;
	public static final int COLON = 83;
	public static final int DISJOINT_WITH_AXIOM = 6;
	public static final int CREATE_INTERSECTION = 102;
	public static final int INVERSE_FUNCTIONAL = 40;
	public static final int RENDERING = 108;
	public static final int IRREFLEXIVE = 44;
	public static final int ASSERTED = 94;
	public static final int VARIABLE_ATTRIBUTE = 74;
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

	public OPPLParser_MOWLParser(TokenStream input, RecognizerSharedState state,
			OPPLParser gOPPLParser) {
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
	public void displayRecognitionError(String[] tokenNames, RecognitionException e) {
	}

	public static class axiom_return extends ParserRuleReturnScope {
		OPPLSyntaxTree tree;

		@Override
		public Object getTree() {
			return this.tree;
		}
	};

	// $ANTLR start "axiom"
	// MOWLParser.g:63:1: axiom : ( binaryAxiom -> ^( binaryAxiom ) | unaryAxiom
	// -> ^( unaryAxiom ) | assertionAxiom -> ^( assertionAxiom ) );
	public final OPPLParser_MOWLParser.axiom_return axiom() throws RecognitionException {
		OPPLParser_MOWLParser.axiom_return retval = new OPPLParser_MOWLParser.axiom_return();
		retval.start = this.input.LT(1);
		OPPLSyntaxTree root_0 = null;
		OPPLParser_MOWLParser.binaryAxiom_return binaryAxiom1 = null;
		OPPLParser_MOWLParser.unaryAxiom_return unaryAxiom2 = null;
		OPPLParser_MOWLParser.assertionAxiom_return assertionAxiom3 = null;
		RewriteRuleSubtreeStream stream_binaryAxiom = new RewriteRuleSubtreeStream(this.adaptor,
				"rule binaryAxiom");
		RewriteRuleSubtreeStream stream_unaryAxiom = new RewriteRuleSubtreeStream(this.adaptor,
				"rule unaryAxiom");
		RewriteRuleSubtreeStream stream_assertionAxiom = new RewriteRuleSubtreeStream(this.adaptor,
				"rule assertionAxiom");
		try {
			// MOWLParser.g:63:7: ( binaryAxiom -> ^( binaryAxiom ) | unaryAxiom
			// -> ^( unaryAxiom ) | assertionAxiom -> ^( assertionAxiom ) )
			int alt1 = 3;
			alt1 = this.dfa1.predict(this.input);
			switch (alt1) {
			case 1:
				// MOWLParser.g:64:3: binaryAxiom
			{
				this.pushFollow(FOLLOW_binaryAxiom_in_axiom220);
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
					root_0 = (OPPLSyntaxTree) this.adaptor.nil();
					// 64:15: -> ^( binaryAxiom )
					{
						// MOWLParser.g:64:18: ^( binaryAxiom )
						{
							OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor.nil();
							root_1 = (OPPLSyntaxTree) this.adaptor.becomeRoot(
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
				// MOWLParser.g:65:5: unaryAxiom
			{
				this.pushFollow(FOLLOW_unaryAxiom_in_axiom232);
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
					root_0 = (OPPLSyntaxTree) this.adaptor.nil();
					// 65:16: -> ^( unaryAxiom )
					{
						// MOWLParser.g:65:19: ^( unaryAxiom )
						{
							OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor.nil();
							root_1 = (OPPLSyntaxTree) this.adaptor.becomeRoot(
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
				// MOWLParser.g:66:5: assertionAxiom
			{
				this.pushFollow(FOLLOW_assertionAxiom_in_axiom244);
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
					root_0 = (OPPLSyntaxTree) this.adaptor.nil();
					// 66:20: -> ^( assertionAxiom )
					{
						// MOWLParser.g:66:23: ^( assertionAxiom )
						{
							OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor.nil();
							root_1 = (OPPLSyntaxTree) this.adaptor.becomeRoot(
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
				retval.tree = (OPPLSyntaxTree) this.adaptor.rulePostProcessing(root_0);
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
	// EXPRESSION atomic ) ^( EXPRESSION propertyExpression ) ^( EXPRESSION
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
		RewriteRuleTokenStream stream_TYPES = new RewriteRuleTokenStream(this.adaptor,
				"token TYPES");
		RewriteRuleTokenStream stream_NOT = new RewriteRuleTokenStream(this.adaptor, "token NOT");
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
		RewriteRuleSubtreeStream stream_atomic = new RewriteRuleSubtreeStream(this.adaptor,
				"rule atomic");
		try {
			// MOWLParser.g:71:15: (i= atomic ( INSTANCE_OF | TYPES ) expression
			// -> ^( TYPE_ASSERTION ^( EXPRESSION expression ) ^( EXPRESSION $i)
			// ) | atomic propertyExpression value -> ^( ROLE_ASSERTION ^(
			// EXPRESSION atomic ) ^( EXPRESSION propertyExpression ) ^(
			// EXPRESSION value ) ) | NOT assertionAxiom -> ^( NEGATED_ASSERTION
			// assertionAxiom ) )
			int alt3 = 3;
			alt3 = this.dfa3.predict(this.input);
			switch (alt3) {
			case 1:
				// MOWLParser.g:72:3: i= atomic ( INSTANCE_OF | TYPES )
				// expression
			{
				this.pushFollow(FOLLOW_atomic_in_assertionAxiom267);
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
					NoViableAltException nvae = new NoViableAltException("", 2, 0, this.input);
					throw nvae;
				}
				switch (alt2) {
				case 1:
					// MOWLParser.g:72:15: INSTANCE_OF
				{
					INSTANCE_OF4 = (Token) this.match(
							this.input,
							INSTANCE_OF,
							FOLLOW_INSTANCE_OF_in_assertionAxiom270);
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
					TYPES5 = (Token) this.match(
							this.input,
							TYPES,
							FOLLOW_TYPES_in_assertionAxiom274);
					if (this.state.failed) {
						return retval;
					}
					if (this.state.backtracking == 0) {
						stream_TYPES.add(TYPES5);
					}
				}
					break;
				}
				this.pushFollow(FOLLOW_expression_in_assertionAxiom277);
				expression6 = this.expression();
				this.state._fsp--;
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_expression.add(expression6.getTree());
				}
				// AST REWRITE
				// elements: expression, i
				// token labels:
				// rule labels: retval, i
				// token list labels:
				// rule list labels:
				// wildcard labels:
				if (this.state.backtracking == 0) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(
							this.adaptor, "rule retval", retval != null ? retval.tree : null);
					RewriteRuleSubtreeStream stream_i = new RewriteRuleSubtreeStream(this.adaptor,
							"rule i", i != null ? i.tree : null);
					root_0 = (OPPLSyntaxTree) this.adaptor.nil();
					// 72:47: -> ^( TYPE_ASSERTION ^( EXPRESSION expression ) ^(
					// EXPRESSION $i) )
					{
						// MOWLParser.g:72:50: ^( TYPE_ASSERTION ^( EXPRESSION
						// expression ) ^( EXPRESSION $i) )
						{
							OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor.nil();
							root_1 = (OPPLSyntaxTree) this.adaptor.becomeRoot(
									this.adaptor.create(TYPE_ASSERTION, "TYPE_ASSERTION"),
									root_1);
							// MOWLParser.g:72:67: ^( EXPRESSION expression )
							{
								OPPLSyntaxTree root_2 = (OPPLSyntaxTree) this.adaptor.nil();
								root_2 = (OPPLSyntaxTree) this.adaptor.becomeRoot(
										this.adaptor.create(EXPRESSION, "EXPRESSION"),
										root_2);
								this.adaptor.addChild(root_2, stream_expression.nextTree());
								this.adaptor.addChild(root_1, root_2);
							}
							// MOWLParser.g:72:92: ^( EXPRESSION $i)
							{
								OPPLSyntaxTree root_2 = (OPPLSyntaxTree) this.adaptor.nil();
								root_2 = (OPPLSyntaxTree) this.adaptor.becomeRoot(
										this.adaptor.create(EXPRESSION, "EXPRESSION"),
										root_2);
								this.adaptor.addChild(root_2, stream_i.nextTree());
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
				this.pushFollow(FOLLOW_atomic_in_assertionAxiom303);
				atomic7 = this.gOPPLParser.atomic();
				this.state._fsp--;
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_atomic.add(atomic7.getTree());
				}
				this.pushFollow(FOLLOW_propertyExpression_in_assertionAxiom305);
				propertyExpression8 = this.propertyExpression();
				this.state._fsp--;
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_propertyExpression.add(propertyExpression8.getTree());
				}
				this.pushFollow(FOLLOW_value_in_assertionAxiom308);
				value9 = this.value();
				this.state._fsp--;
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_value.add(value9.getTree());
				}
				// AST REWRITE
				// elements: value, atomic, propertyExpression
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
					// 73:39: -> ^( ROLE_ASSERTION ^( EXPRESSION atomic ) ^(
					// EXPRESSION propertyExpression ) ^( EXPRESSION value ) )
					{
						// MOWLParser.g:73:42: ^( ROLE_ASSERTION ^( EXPRESSION
						// atomic ) ^( EXPRESSION propertyExpression ) ^(
						// EXPRESSION value ) )
						{
							OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor.nil();
							root_1 = (OPPLSyntaxTree) this.adaptor.becomeRoot(
									this.adaptor.create(ROLE_ASSERTION, "ROLE_ASSERTION"),
									root_1);
							// MOWLParser.g:73:59: ^( EXPRESSION atomic )
							{
								OPPLSyntaxTree root_2 = (OPPLSyntaxTree) this.adaptor.nil();
								root_2 = (OPPLSyntaxTree) this.adaptor.becomeRoot(
										this.adaptor.create(EXPRESSION, "EXPRESSION"),
										root_2);
								this.adaptor.addChild(root_2, stream_atomic.nextTree());
								this.adaptor.addChild(root_1, root_2);
							}
							// MOWLParser.g:73:80: ^( EXPRESSION
							// propertyExpression )
							{
								OPPLSyntaxTree root_2 = (OPPLSyntaxTree) this.adaptor.nil();
								root_2 = (OPPLSyntaxTree) this.adaptor.becomeRoot(
										this.adaptor.create(EXPRESSION, "EXPRESSION"),
										root_2);
								this.adaptor.addChild(root_2, stream_propertyExpression.nextTree());
								this.adaptor.addChild(root_1, root_2);
							}
							// MOWLParser.g:73:113: ^( EXPRESSION value )
							{
								OPPLSyntaxTree root_2 = (OPPLSyntaxTree) this.adaptor.nil();
								root_2 = (OPPLSyntaxTree) this.adaptor.becomeRoot(
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
				// MOWLParser.g:75:5: NOT assertionAxiom
			{
				NOT10 = (Token) this.match(this.input, NOT, FOLLOW_NOT_in_assertionAxiom341);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_NOT.add(NOT10);
				}
				this.pushFollow(FOLLOW_assertionAxiom_in_assertionAxiom343);
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
					root_0 = (OPPLSyntaxTree) this.adaptor.nil();
					// 75:24: -> ^( NEGATED_ASSERTION assertionAxiom )
					{
						// MOWLParser.g:75:27: ^( NEGATED_ASSERTION
						// assertionAxiom )
						{
							OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor.nil();
							root_1 = (OPPLSyntaxTree) this.adaptor.becomeRoot(
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
				retval.tree = (OPPLSyntaxTree) this.adaptor.rulePostProcessing(root_0);
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
		OPPLSyntaxTree tree;

		@Override
		public Object getTree() {
			return this.tree;
		}
	};

	// $ANTLR start "binaryAxiom"
	// MOWLParser.g:80:1: binaryAxiom : (lhs= expression ( SUBCLASS_OF
	// superClass= expression -> ^( SUB_CLASS_AXIOM ^( EXPRESSION $lhs) ^(
	// EXPRESSION $superClass) ) | EQUIVALENT_TO rhs= expression -> ^(
	// EQUIVALENT_TO_AXIOM ^( EXPRESSION $lhs) ^( EXPRESSION $rhs) ) |
	// DISJOINT_WITH disjoint= expression -> ^( DISJOINT_WITH_AXIOM ^(
	// EXPRESSION $lhs) ^( EXPRESSION $disjoint) ) | SUB_PROPERTY_OF
	// superProperty= propertyExpression -> ^( SUB_PROPERTY_AXIOM ^( EXPRESSION
	// $lhs) ^( EXPRESSION $superProperty) ) ) | lhsID= atomic ( SAME_AS rhsID=
	// atomic -> ^( SAME_AS_AXIOM ^( EXPRESSION $lhsID) ^( EXPRESSION $rhsID) )
	// | DIFFERENT_FROM rhsID= atomic -> ^( DIFFERENT_FROM_AXIOM ^( EXPRESSION
	// $lhsID) ^( EXPRESSION $rhsID) ) | DOMAIN expression -> ^( DOMAIN ^(
	// EXPRESSION $lhsID) ^( EXPRESSION expression ) ) | RANGE expression -> ^(
	// RANGE ^( EXPRESSION $lhsID) ^( EXPRESSION expression ) ) | INVERSE_OF
	// rhsID= atomic -> ^( INVERSE_OF ^( EXPRESSION $lhsID) ^( EXPRESSION
	// $rhsID) ) ) );
	public final OPPLParser_MOWLParser.binaryAxiom_return binaryAxiom() throws RecognitionException {
		OPPLParser_MOWLParser.binaryAxiom_return retval = new OPPLParser_MOWLParser.binaryAxiom_return();
		retval.start = this.input.LT(1);
		OPPLSyntaxTree root_0 = null;
		Token SUBCLASS_OF12 = null;
		Token EQUIVALENT_TO13 = null;
		Token DISJOINT_WITH14 = null;
		Token SUB_PROPERTY_OF15 = null;
		Token SAME_AS16 = null;
		Token DIFFERENT_FROM17 = null;
		Token DOMAIN18 = null;
		Token RANGE20 = null;
		Token INVERSE_OF22 = null;
		OPPLParser_MOWLParser.expression_return lhs = null;
		OPPLParser_MOWLParser.expression_return superClass = null;
		OPPLParser_MOWLParser.expression_return rhs = null;
		OPPLParser_MOWLParser.expression_return disjoint = null;
		OPPLParser_MOWLParser.propertyExpression_return superProperty = null;
		OPPLParser.atomic_return lhsID = null;
		OPPLParser.atomic_return rhsID = null;
		OPPLParser_MOWLParser.expression_return expression19 = null;
		OPPLParser_MOWLParser.expression_return expression21 = null;
		OPPLSyntaxTree SUBCLASS_OF12_tree = null;
		OPPLSyntaxTree EQUIVALENT_TO13_tree = null;
		OPPLSyntaxTree DISJOINT_WITH14_tree = null;
		OPPLSyntaxTree SUB_PROPERTY_OF15_tree = null;
		OPPLSyntaxTree SAME_AS16_tree = null;
		OPPLSyntaxTree DIFFERENT_FROM17_tree = null;
		OPPLSyntaxTree DOMAIN18_tree = null;
		OPPLSyntaxTree RANGE20_tree = null;
		OPPLSyntaxTree INVERSE_OF22_tree = null;
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
		RewriteRuleTokenStream stream_DOMAIN = new RewriteRuleTokenStream(this.adaptor,
				"token DOMAIN");
		RewriteRuleTokenStream stream_SUB_PROPERTY_OF = new RewriteRuleTokenStream(this.adaptor,
				"token SUB_PROPERTY_OF");
		RewriteRuleSubtreeStream stream_expression = new RewriteRuleSubtreeStream(this.adaptor,
				"rule expression");
		RewriteRuleSubtreeStream stream_propertyExpression = new RewriteRuleSubtreeStream(
				this.adaptor, "rule propertyExpression");
		RewriteRuleSubtreeStream stream_atomic = new RewriteRuleSubtreeStream(this.adaptor,
				"rule atomic");
		try {
			// MOWLParser.g:80:13: (lhs= expression ( SUBCLASS_OF superClass=
			// expression -> ^( SUB_CLASS_AXIOM ^( EXPRESSION $lhs) ^(
			// EXPRESSION $superClass) ) | EQUIVALENT_TO rhs= expression -> ^(
			// EQUIVALENT_TO_AXIOM ^( EXPRESSION $lhs) ^( EXPRESSION $rhs) ) |
			// DISJOINT_WITH disjoint= expression -> ^( DISJOINT_WITH_AXIOM ^(
			// EXPRESSION $lhs) ^( EXPRESSION $disjoint) ) | SUB_PROPERTY_OF
			// superProperty= propertyExpression -> ^( SUB_PROPERTY_AXIOM ^(
			// EXPRESSION $lhs) ^( EXPRESSION $superProperty) ) ) | lhsID=
			// atomic ( SAME_AS rhsID= atomic -> ^( SAME_AS_AXIOM ^( EXPRESSION
			// $lhsID) ^( EXPRESSION $rhsID) ) | DIFFERENT_FROM rhsID= atomic ->
			// ^( DIFFERENT_FROM_AXIOM ^( EXPRESSION $lhsID) ^( EXPRESSION
			// $rhsID) ) | DOMAIN expression -> ^( DOMAIN ^( EXPRESSION $lhsID)
			// ^( EXPRESSION expression ) ) | RANGE expression -> ^( RANGE ^(
			// EXPRESSION $lhsID) ^( EXPRESSION expression ) ) | INVERSE_OF
			// rhsID= atomic -> ^( INVERSE_OF ^( EXPRESSION $lhsID) ^(
			// EXPRESSION $rhsID) ) ) )
			int alt6 = 2;
			alt6 = this.dfa6.predict(this.input);
			switch (alt6) {
			case 1:
				// MOWLParser.g:81:5: lhs= expression ( SUBCLASS_OF superClass=
				// expression -> ^( SUB_CLASS_AXIOM ^( EXPRESSION $lhs) ^(
				// EXPRESSION $superClass) ) | EQUIVALENT_TO rhs= expression ->
				// ^( EQUIVALENT_TO_AXIOM ^( EXPRESSION $lhs) ^( EXPRESSION
				// $rhs) ) | DISJOINT_WITH disjoint= expression -> ^(
				// DISJOINT_WITH_AXIOM ^( EXPRESSION $lhs) ^( EXPRESSION
				// $disjoint) ) | SUB_PROPERTY_OF superProperty=
				// propertyExpression -> ^( SUB_PROPERTY_AXIOM ^( EXPRESSION
				// $lhs) ^( EXPRESSION $superProperty) ) )
			{
				this.pushFollow(FOLLOW_expression_in_binaryAxiom371);
				lhs = this.expression();
				this.state._fsp--;
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_expression.add(lhs.getTree());
				}
				// MOWLParser.g:83:17: ( SUBCLASS_OF superClass= expression ->
				// ^( SUB_CLASS_AXIOM ^( EXPRESSION $lhs) ^( EXPRESSION
				// $superClass) ) | EQUIVALENT_TO rhs= expression -> ^(
				// EQUIVALENT_TO_AXIOM ^( EXPRESSION $lhs) ^( EXPRESSION $rhs) )
				// | DISJOINT_WITH disjoint= expression -> ^(
				// DISJOINT_WITH_AXIOM ^( EXPRESSION $lhs) ^( EXPRESSION
				// $disjoint) ) | SUB_PROPERTY_OF superProperty=
				// propertyExpression -> ^( SUB_PROPERTY_AXIOM ^( EXPRESSION
				// $lhs) ^( EXPRESSION $superProperty) ) )
				int alt4 = 4;
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
					// MOWLParser.g:84:17: SUBCLASS_OF superClass= expression
				{
					SUBCLASS_OF12 = (Token) this.match(
							this.input,
							SUBCLASS_OF,
							FOLLOW_SUBCLASS_OF_in_binaryAxiom426);
					if (this.state.failed) {
						return retval;
					}
					if (this.state.backtracking == 0) {
						stream_SUBCLASS_OF.add(SUBCLASS_OF12);
					}
					this.pushFollow(FOLLOW_expression_in_binaryAxiom433);
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
								this.adaptor, "rule retval", retval != null ? retval.tree : null);
						RewriteRuleSubtreeStream stream_superClass = new RewriteRuleSubtreeStream(
								this.adaptor, "rule superClass",
								superClass != null ? superClass.tree : null);
						RewriteRuleSubtreeStream stream_lhs = new RewriteRuleSubtreeStream(
								this.adaptor, "rule lhs", lhs != null ? lhs.tree : null);
						root_0 = (OPPLSyntaxTree) this.adaptor.nil();
						// 84:54: -> ^( SUB_CLASS_AXIOM ^( EXPRESSION $lhs) ^(
						// EXPRESSION $superClass) )
						{
							// MOWLParser.g:84:57: ^( SUB_CLASS_AXIOM ^(
							// EXPRESSION $lhs) ^( EXPRESSION $superClass) )
							{
								OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor.nil();
								root_1 = (OPPLSyntaxTree) this.adaptor.becomeRoot(
										this.adaptor.create(SUB_CLASS_AXIOM, "SUB_CLASS_AXIOM"),
										root_1);
								// MOWLParser.g:84:76: ^( EXPRESSION $lhs)
								{
									OPPLSyntaxTree root_2 = (OPPLSyntaxTree) this.adaptor.nil();
									root_2 = (OPPLSyntaxTree) this.adaptor.becomeRoot(
											this.adaptor.create(EXPRESSION, "EXPRESSION"),
											root_2);
									this.adaptor.addChild(root_2, stream_lhs.nextTree());
									this.adaptor.addChild(root_1, root_2);
								}
								// MOWLParser.g:84:95: ^( EXPRESSION
								// $superClass)
								{
									OPPLSyntaxTree root_2 = (OPPLSyntaxTree) this.adaptor.nil();
									root_2 = (OPPLSyntaxTree) this.adaptor.becomeRoot(
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
					// MOWLParser.g:85:19: EQUIVALENT_TO rhs= expression
				{
					EQUIVALENT_TO13 = (Token) this.match(
							this.input,
							EQUIVALENT_TO,
							FOLLOW_EQUIVALENT_TO_in_binaryAxiom474);
					if (this.state.failed) {
						return retval;
					}
					if (this.state.backtracking == 0) {
						stream_EQUIVALENT_TO.add(EQUIVALENT_TO13);
					}
					this.pushFollow(FOLLOW_expression_in_binaryAxiom480);
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
						root_0 = (OPPLSyntaxTree) this.adaptor.nil();
						// 85:50: -> ^( EQUIVALENT_TO_AXIOM ^( EXPRESSION $lhs)
						// ^( EXPRESSION $rhs) )
						{
							// MOWLParser.g:85:53: ^( EQUIVALENT_TO_AXIOM ^(
							// EXPRESSION $lhs) ^( EXPRESSION $rhs) )
							{
								OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor.nil();
								root_1 = (OPPLSyntaxTree) this.adaptor.becomeRoot(
										this.adaptor.create(
												EQUIVALENT_TO_AXIOM,
												"EQUIVALENT_TO_AXIOM"),
										root_1);
								// MOWLParser.g:85:75: ^( EXPRESSION $lhs)
								{
									OPPLSyntaxTree root_2 = (OPPLSyntaxTree) this.adaptor.nil();
									root_2 = (OPPLSyntaxTree) this.adaptor.becomeRoot(
											this.adaptor.create(EXPRESSION, "EXPRESSION"),
											root_2);
									this.adaptor.addChild(root_2, stream_lhs.nextTree());
									this.adaptor.addChild(root_1, root_2);
								}
								// MOWLParser.g:85:94: ^( EXPRESSION $rhs)
								{
									OPPLSyntaxTree root_2 = (OPPLSyntaxTree) this.adaptor.nil();
									root_2 = (OPPLSyntaxTree) this.adaptor.becomeRoot(
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
					// MOWLParser.g:86:19: DISJOINT_WITH disjoint= expression
				{
					DISJOINT_WITH14 = (Token) this.match(
							this.input,
							DISJOINT_WITH,
							FOLLOW_DISJOINT_WITH_in_binaryAxiom520);
					if (this.state.failed) {
						return retval;
					}
					if (this.state.backtracking == 0) {
						stream_DISJOINT_WITH.add(DISJOINT_WITH14);
					}
					this.pushFollow(FOLLOW_expression_in_binaryAxiom526);
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
						root_0 = (OPPLSyntaxTree) this.adaptor.nil();
						// 86:55: -> ^( DISJOINT_WITH_AXIOM ^( EXPRESSION $lhs)
						// ^( EXPRESSION $disjoint) )
						{
							// MOWLParser.g:86:58: ^( DISJOINT_WITH_AXIOM ^(
							// EXPRESSION $lhs) ^( EXPRESSION $disjoint) )
							{
								OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor.nil();
								root_1 = (OPPLSyntaxTree) this.adaptor.becomeRoot(
										this.adaptor.create(
												DISJOINT_WITH_AXIOM,
												"DISJOINT_WITH_AXIOM"),
										root_1);
								// MOWLParser.g:86:80: ^( EXPRESSION $lhs)
								{
									OPPLSyntaxTree root_2 = (OPPLSyntaxTree) this.adaptor.nil();
									root_2 = (OPPLSyntaxTree) this.adaptor.becomeRoot(
											this.adaptor.create(EXPRESSION, "EXPRESSION"),
											root_2);
									this.adaptor.addChild(root_2, stream_lhs.nextTree());
									this.adaptor.addChild(root_1, root_2);
								}
								// MOWLParser.g:86:99: ^( EXPRESSION $disjoint)
								{
									OPPLSyntaxTree root_2 = (OPPLSyntaxTree) this.adaptor.nil();
									root_2 = (OPPLSyntaxTree) this.adaptor.becomeRoot(
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
					// MOWLParser.g:87:19: SUB_PROPERTY_OF superProperty=
					// propertyExpression
				{
					SUB_PROPERTY_OF15 = (Token) this.match(
							this.input,
							SUB_PROPERTY_OF,
							FOLLOW_SUB_PROPERTY_OF_in_binaryAxiom566);
					if (this.state.failed) {
						return retval;
					}
					if (this.state.backtracking == 0) {
						stream_SUB_PROPERTY_OF.add(SUB_PROPERTY_OF15);
					}
					this.pushFollow(FOLLOW_propertyExpression_in_binaryAxiom572);
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
						root_0 = (OPPLSyntaxTree) this.adaptor.nil();
						// 87:70: -> ^( SUB_PROPERTY_AXIOM ^( EXPRESSION $lhs)
						// ^( EXPRESSION $superProperty) )
						{
							// MOWLParser.g:87:73: ^( SUB_PROPERTY_AXIOM ^(
							// EXPRESSION $lhs) ^( EXPRESSION $superProperty) )
							{
								OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor.nil();
								root_1 = (OPPLSyntaxTree) this.adaptor.becomeRoot(
										this.adaptor.create(
												SUB_PROPERTY_AXIOM,
												"SUB_PROPERTY_AXIOM"),
										root_1);
								// MOWLParser.g:87:94: ^( EXPRESSION $lhs)
								{
									OPPLSyntaxTree root_2 = (OPPLSyntaxTree) this.adaptor.nil();
									root_2 = (OPPLSyntaxTree) this.adaptor.becomeRoot(
											this.adaptor.create(EXPRESSION, "EXPRESSION"),
											root_2);
									this.adaptor.addChild(root_2, stream_lhs.nextTree());
									this.adaptor.addChild(root_1, root_2);
								}
								// MOWLParser.g:87:113: ^( EXPRESSION
								// $superProperty)
								{
									OPPLSyntaxTree root_2 = (OPPLSyntaxTree) this.adaptor.nil();
									root_2 = (OPPLSyntaxTree) this.adaptor.becomeRoot(
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
				}
			}
				break;
			case 2:
				// MOWLParser.g:90:5: lhsID= atomic ( SAME_AS rhsID= atomic ->
				// ^( SAME_AS_AXIOM ^( EXPRESSION $lhsID) ^( EXPRESSION $rhsID)
				// ) | DIFFERENT_FROM rhsID= atomic -> ^( DIFFERENT_FROM_AXIOM
				// ^( EXPRESSION $lhsID) ^( EXPRESSION $rhsID) ) | DOMAIN
				// expression -> ^( DOMAIN ^( EXPRESSION $lhsID) ^( EXPRESSION
				// expression ) ) | RANGE expression -> ^( RANGE ^( EXPRESSION
				// $lhsID) ^( EXPRESSION expression ) ) | INVERSE_OF rhsID=
				// atomic -> ^( INVERSE_OF ^( EXPRESSION $lhsID) ^( EXPRESSION
				// $rhsID) ) )
			{
				this.pushFollow(FOLLOW_atomic_in_binaryAxiom642);
				lhsID = this.gOPPLParser.atomic();
				this.state._fsp--;
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_atomic.add(lhsID.getTree());
				}
				// MOWLParser.g:90:21: ( SAME_AS rhsID= atomic -> ^(
				// SAME_AS_AXIOM ^( EXPRESSION $lhsID) ^( EXPRESSION $rhsID) ) |
				// DIFFERENT_FROM rhsID= atomic -> ^( DIFFERENT_FROM_AXIOM ^(
				// EXPRESSION $lhsID) ^( EXPRESSION $rhsID) ) | DOMAIN
				// expression -> ^( DOMAIN ^( EXPRESSION $lhsID) ^( EXPRESSION
				// expression ) ) | RANGE expression -> ^( RANGE ^( EXPRESSION
				// $lhsID) ^( EXPRESSION expression ) ) | INVERSE_OF rhsID=
				// atomic -> ^( INVERSE_OF ^( EXPRESSION $lhsID) ^( EXPRESSION
				// $rhsID) ) )
				int alt5 = 5;
				switch (this.input.LA(1)) {
				case SAME_AS: {
					alt5 = 1;
				}
					break;
				case DIFFERENT_FROM: {
					alt5 = 2;
				}
					break;
				case DOMAIN: {
					alt5 = 3;
				}
					break;
				case RANGE: {
					alt5 = 4;
				}
					break;
				case INVERSE_OF: {
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
					// MOWLParser.g:91:21: SAME_AS rhsID= atomic
				{
					SAME_AS16 = (Token) this.match(
							this.input,
							SAME_AS,
							FOLLOW_SAME_AS_in_binaryAxiom667);
					if (this.state.failed) {
						return retval;
					}
					if (this.state.backtracking == 0) {
						stream_SAME_AS.add(SAME_AS16);
					}
					this.pushFollow(FOLLOW_atomic_in_binaryAxiom674);
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
								this.adaptor, "rule lhsID", lhsID != null ? lhsID.tree : null);
						RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(
								this.adaptor, "rule retval", retval != null ? retval.tree : null);
						RewriteRuleSubtreeStream stream_rhsID = new RewriteRuleSubtreeStream(
								this.adaptor, "rule rhsID", rhsID != null ? rhsID.tree : null);
						root_0 = (OPPLSyntaxTree) this.adaptor.nil();
						// 91:45: -> ^( SAME_AS_AXIOM ^( EXPRESSION $lhsID) ^(
						// EXPRESSION $rhsID) )
						{
							// MOWLParser.g:91:48: ^( SAME_AS_AXIOM ^(
							// EXPRESSION $lhsID) ^( EXPRESSION $rhsID) )
							{
								OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor.nil();
								root_1 = (OPPLSyntaxTree) this.adaptor.becomeRoot(
										this.adaptor.create(SAME_AS_AXIOM, "SAME_AS_AXIOM"),
										root_1);
								// MOWLParser.g:91:64: ^( EXPRESSION $lhsID)
								{
									OPPLSyntaxTree root_2 = (OPPLSyntaxTree) this.adaptor.nil();
									root_2 = (OPPLSyntaxTree) this.adaptor.becomeRoot(
											this.adaptor.create(EXPRESSION, "EXPRESSION"),
											root_2);
									this.adaptor.addChild(root_2, stream_lhsID.nextTree());
									this.adaptor.addChild(root_1, root_2);
								}
								// MOWLParser.g:91:86: ^( EXPRESSION $rhsID)
								{
									OPPLSyntaxTree root_2 = (OPPLSyntaxTree) this.adaptor.nil();
									root_2 = (OPPLSyntaxTree) this.adaptor.becomeRoot(
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
				case 2:
					// MOWLParser.g:92:21: DIFFERENT_FROM rhsID= atomic
				{
					DIFFERENT_FROM17 = (Token) this.match(
							this.input,
							DIFFERENT_FROM,
							FOLLOW_DIFFERENT_FROM_in_binaryAxiom717);
					if (this.state.failed) {
						return retval;
					}
					if (this.state.backtracking == 0) {
						stream_DIFFERENT_FROM.add(DIFFERENT_FROM17);
					}
					this.pushFollow(FOLLOW_atomic_in_binaryAxiom724);
					rhsID = this.gOPPLParser.atomic();
					this.state._fsp--;
					if (this.state.failed) {
						return retval;
					}
					if (this.state.backtracking == 0) {
						stream_atomic.add(rhsID.getTree());
					}
					// AST REWRITE
					// elements: lhsID, rhsID
					// token labels:
					// rule labels: lhsID, retval, rhsID
					// token list labels:
					// rule list labels:
					// wildcard labels:
					if (this.state.backtracking == 0) {
						retval.tree = root_0;
						RewriteRuleSubtreeStream stream_lhsID = new RewriteRuleSubtreeStream(
								this.adaptor, "rule lhsID", lhsID != null ? lhsID.tree : null);
						RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(
								this.adaptor, "rule retval", retval != null ? retval.tree : null);
						RewriteRuleSubtreeStream stream_rhsID = new RewriteRuleSubtreeStream(
								this.adaptor, "rule rhsID", rhsID != null ? rhsID.tree : null);
						root_0 = (OPPLSyntaxTree) this.adaptor.nil();
						// 92:52: -> ^( DIFFERENT_FROM_AXIOM ^( EXPRESSION
						// $lhsID) ^( EXPRESSION $rhsID) )
						{
							// MOWLParser.g:92:55: ^( DIFFERENT_FROM_AXIOM ^(
							// EXPRESSION $lhsID) ^( EXPRESSION $rhsID) )
							{
								OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor.nil();
								root_1 = (OPPLSyntaxTree) this.adaptor.becomeRoot(
										this.adaptor.create(
												DIFFERENT_FROM_AXIOM,
												"DIFFERENT_FROM_AXIOM"),
										root_1);
								// MOWLParser.g:92:78: ^( EXPRESSION $lhsID)
								{
									OPPLSyntaxTree root_2 = (OPPLSyntaxTree) this.adaptor.nil();
									root_2 = (OPPLSyntaxTree) this.adaptor.becomeRoot(
											this.adaptor.create(EXPRESSION, "EXPRESSION"),
											root_2);
									this.adaptor.addChild(root_2, stream_lhsID.nextTree());
									this.adaptor.addChild(root_1, root_2);
								}
								// MOWLParser.g:92:99: ^( EXPRESSION $rhsID)
								{
									OPPLSyntaxTree root_2 = (OPPLSyntaxTree) this.adaptor.nil();
									root_2 = (OPPLSyntaxTree) this.adaptor.becomeRoot(
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
				case 3:
					// MOWLParser.g:93:21: DOMAIN expression
				{
					DOMAIN18 = (Token) this.match(
							this.input,
							DOMAIN,
							FOLLOW_DOMAIN_in_binaryAxiom766);
					if (this.state.failed) {
						return retval;
					}
					if (this.state.backtracking == 0) {
						stream_DOMAIN.add(DOMAIN18);
					}
					this.pushFollow(FOLLOW_expression_in_binaryAxiom768);
					expression19 = this.expression();
					this.state._fsp--;
					if (this.state.failed) {
						return retval;
					}
					if (this.state.backtracking == 0) {
						stream_expression.add(expression19.getTree());
					}
					// AST REWRITE
					// elements: expression, DOMAIN, lhsID
					// token labels:
					// rule labels: lhsID, retval
					// token list labels:
					// rule list labels:
					// wildcard labels:
					if (this.state.backtracking == 0) {
						retval.tree = root_0;
						RewriteRuleSubtreeStream stream_lhsID = new RewriteRuleSubtreeStream(
								this.adaptor, "rule lhsID", lhsID != null ? lhsID.tree : null);
						RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(
								this.adaptor, "rule retval", retval != null ? retval.tree : null);
						root_0 = (OPPLSyntaxTree) this.adaptor.nil();
						// 93:39: -> ^( DOMAIN ^( EXPRESSION $lhsID) ^(
						// EXPRESSION expression ) )
						{
							// MOWLParser.g:93:42: ^( DOMAIN ^( EXPRESSION
							// $lhsID) ^( EXPRESSION expression ) )
							{
								OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor.nil();
								root_1 = (OPPLSyntaxTree) this.adaptor.becomeRoot(
										stream_DOMAIN.nextNode(),
										root_1);
								// MOWLParser.g:93:51: ^( EXPRESSION $lhsID)
								{
									OPPLSyntaxTree root_2 = (OPPLSyntaxTree) this.adaptor.nil();
									root_2 = (OPPLSyntaxTree) this.adaptor.becomeRoot(
											this.adaptor.create(EXPRESSION, "EXPRESSION"),
											root_2);
									this.adaptor.addChild(root_2, stream_lhsID.nextTree());
									this.adaptor.addChild(root_1, root_2);
								}
								// MOWLParser.g:93:72: ^( EXPRESSION expression
								// )
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
					break;
				case 4:
					// MOWLParser.g:94:21: RANGE expression
				{
					RANGE20 = (Token) this.match(this.input, RANGE, FOLLOW_RANGE_in_binaryAxiom809);
					if (this.state.failed) {
						return retval;
					}
					if (this.state.backtracking == 0) {
						stream_RANGE.add(RANGE20);
					}
					this.pushFollow(FOLLOW_expression_in_binaryAxiom811);
					expression21 = this.expression();
					this.state._fsp--;
					if (this.state.failed) {
						return retval;
					}
					if (this.state.backtracking == 0) {
						stream_expression.add(expression21.getTree());
					}
					// AST REWRITE
					// elements: RANGE, expression, lhsID
					// token labels:
					// rule labels: lhsID, retval
					// token list labels:
					// rule list labels:
					// wildcard labels:
					if (this.state.backtracking == 0) {
						retval.tree = root_0;
						RewriteRuleSubtreeStream stream_lhsID = new RewriteRuleSubtreeStream(
								this.adaptor, "rule lhsID", lhsID != null ? lhsID.tree : null);
						RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(
								this.adaptor, "rule retval", retval != null ? retval.tree : null);
						root_0 = (OPPLSyntaxTree) this.adaptor.nil();
						// 94:38: -> ^( RANGE ^( EXPRESSION $lhsID) ^(
						// EXPRESSION expression ) )
						{
							// MOWLParser.g:94:41: ^( RANGE ^( EXPRESSION
							// $lhsID) ^( EXPRESSION expression ) )
							{
								OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor.nil();
								root_1 = (OPPLSyntaxTree) this.adaptor.becomeRoot(
										stream_RANGE.nextNode(),
										root_1);
								// MOWLParser.g:94:49: ^( EXPRESSION $lhsID)
								{
									OPPLSyntaxTree root_2 = (OPPLSyntaxTree) this.adaptor.nil();
									root_2 = (OPPLSyntaxTree) this.adaptor.becomeRoot(
											this.adaptor.create(EXPRESSION, "EXPRESSION"),
											root_2);
									this.adaptor.addChild(root_2, stream_lhsID.nextTree());
									this.adaptor.addChild(root_1, root_2);
								}
								// MOWLParser.g:94:70: ^( EXPRESSION expression
								// )
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
					break;
				case 5:
					// MOWLParser.g:95:21: INVERSE_OF rhsID= atomic
				{
					INVERSE_OF22 = (Token) this.match(
							this.input,
							INVERSE_OF,
							FOLLOW_INVERSE_OF_in_binaryAxiom852);
					if (this.state.failed) {
						return retval;
					}
					if (this.state.backtracking == 0) {
						stream_INVERSE_OF.add(INVERSE_OF22);
					}
					this.pushFollow(FOLLOW_atomic_in_binaryAxiom858);
					rhsID = this.gOPPLParser.atomic();
					this.state._fsp--;
					if (this.state.failed) {
						return retval;
					}
					if (this.state.backtracking == 0) {
						stream_atomic.add(rhsID.getTree());
					}
					// AST REWRITE
					// elements: rhsID, lhsID, INVERSE_OF
					// token labels:
					// rule labels: lhsID, retval, rhsID
					// token list labels:
					// rule list labels:
					// wildcard labels:
					if (this.state.backtracking == 0) {
						retval.tree = root_0;
						RewriteRuleSubtreeStream stream_lhsID = new RewriteRuleSubtreeStream(
								this.adaptor, "rule lhsID", lhsID != null ? lhsID.tree : null);
						RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(
								this.adaptor, "rule retval", retval != null ? retval.tree : null);
						RewriteRuleSubtreeStream stream_rhsID = new RewriteRuleSubtreeStream(
								this.adaptor, "rule rhsID", rhsID != null ? rhsID.tree : null);
						root_0 = (OPPLSyntaxTree) this.adaptor.nil();
						// 95:47: -> ^( INVERSE_OF ^( EXPRESSION $lhsID) ^(
						// EXPRESSION $rhsID) )
						{
							// MOWLParser.g:95:50: ^( INVERSE_OF ^( EXPRESSION
							// $lhsID) ^( EXPRESSION $rhsID) )
							{
								OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor.nil();
								root_1 = (OPPLSyntaxTree) this.adaptor.becomeRoot(
										stream_INVERSE_OF.nextNode(),
										root_1);
								// MOWLParser.g:95:63: ^( EXPRESSION $lhsID)
								{
									OPPLSyntaxTree root_2 = (OPPLSyntaxTree) this.adaptor.nil();
									root_2 = (OPPLSyntaxTree) this.adaptor.becomeRoot(
											this.adaptor.create(EXPRESSION, "EXPRESSION"),
											root_2);
									this.adaptor.addChild(root_2, stream_lhsID.nextTree());
									this.adaptor.addChild(root_1, root_2);
								}
								// MOWLParser.g:95:84: ^( EXPRESSION $rhsID)
								{
									OPPLSyntaxTree root_2 = (OPPLSyntaxTree) this.adaptor.nil();
									root_2 = (OPPLSyntaxTree) this.adaptor.becomeRoot(
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
				}
			}
				break;
			}
			retval.stop = this.input.LT(-1);
			if (this.state.backtracking == 0) {
				retval.tree = (OPPLSyntaxTree) this.adaptor.rulePostProcessing(root_0);
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
		OPPLSyntaxTree tree;

		@Override
		public Object getTree() {
			return this.tree;
		}
	};

	// $ANTLR start "unaryAxiom"
	// MOWLParser.g:100:1: unaryAxiom : unaryCharacteristic atomic -> ^(
	// UNARY_AXIOM unaryCharacteristic ^( EXPRESSION atomic ) ) ;
	public final OPPLParser_MOWLParser.unaryAxiom_return unaryAxiom() throws RecognitionException {
		OPPLParser_MOWLParser.unaryAxiom_return retval = new OPPLParser_MOWLParser.unaryAxiom_return();
		retval.start = this.input.LT(1);
		OPPLSyntaxTree root_0 = null;
		OPPLParser_MOWLParser.unaryCharacteristic_return unaryCharacteristic23 = null;
		OPPLParser.atomic_return atomic24 = null;
		RewriteRuleSubtreeStream stream_unaryCharacteristic = new RewriteRuleSubtreeStream(
				this.adaptor, "rule unaryCharacteristic");
		RewriteRuleSubtreeStream stream_atomic = new RewriteRuleSubtreeStream(this.adaptor,
				"rule atomic");
		try {
			// MOWLParser.g:100:13: ( unaryCharacteristic atomic -> ^(
			// UNARY_AXIOM unaryCharacteristic ^( EXPRESSION atomic ) ) )
			// MOWLParser.g:101:4: unaryCharacteristic atomic
			{
				this.pushFollow(FOLLOW_unaryCharacteristic_in_unaryAxiom943);
				unaryCharacteristic23 = this.unaryCharacteristic();
				this.state._fsp--;
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_unaryCharacteristic.add(unaryCharacteristic23.getTree());
				}
				this.pushFollow(FOLLOW_atomic_in_unaryAxiom947);
				atomic24 = this.gOPPLParser.atomic();
				this.state._fsp--;
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_atomic.add(atomic24.getTree());
				}
				// AST REWRITE
				// elements: unaryCharacteristic, atomic
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
					// 101:33: -> ^( UNARY_AXIOM unaryCharacteristic ^(
					// EXPRESSION atomic ) )
					{
						// MOWLParser.g:101:36: ^( UNARY_AXIOM
						// unaryCharacteristic ^( EXPRESSION atomic ) )
						{
							OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor.nil();
							root_1 = (OPPLSyntaxTree) this.adaptor.becomeRoot(
									this.adaptor.create(UNARY_AXIOM, "UNARY_AXIOM"),
									root_1);
							this.adaptor.addChild(root_1, stream_unaryCharacteristic.nextTree());
							// MOWLParser.g:101:70: ^( EXPRESSION atomic )
							{
								OPPLSyntaxTree root_2 = (OPPLSyntaxTree) this.adaptor.nil();
								root_2 = (OPPLSyntaxTree) this.adaptor.becomeRoot(
										this.adaptor.create(EXPRESSION, "EXPRESSION"),
										root_2);
								this.adaptor.addChild(root_2, stream_atomic.nextTree());
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
		OPPLSyntaxTree tree;

		@Override
		public Object getTree() {
			return this.tree;
		}
	};

	// $ANTLR start "unaryCharacteristic"
	// MOWLParser.g:104:1: unaryCharacteristic : ( FUNCTIONAL -> ^( FUNCTIONAL )
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
			// MOWLParser.g:104:21: ( FUNCTIONAL -> ^( FUNCTIONAL ) |
			// INVERSE_FUNCTIONAL -> ^( INVERSE_FUNCTIONAL ) | SYMMETRIC -> ^(
			// SYMMETRIC ) | ANTI_SYMMETRIC -> ^( ANTI_SYMMETRIC ) | REFLEXIVE
			// -> ^( REFLEXIVE ) | IRREFLEXIVE -> ^( IRREFLEXIVE ) | TRANSITIVE
			// -> ^( TRANSITIVE ) )
			int alt7 = 7;
			switch (this.input.LA(1)) {
			case FUNCTIONAL: {
				alt7 = 1;
			}
				break;
			case INVERSE_FUNCTIONAL: {
				alt7 = 2;
			}
				break;
			case SYMMETRIC: {
				alt7 = 3;
			}
				break;
			case ANTI_SYMMETRIC: {
				alt7 = 4;
			}
				break;
			case REFLEXIVE: {
				alt7 = 5;
			}
				break;
			case IRREFLEXIVE: {
				alt7 = 6;
			}
				break;
			case TRANSITIVE: {
				alt7 = 7;
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
				// MOWLParser.g:105:5: FUNCTIONAL
			{
				FUNCTIONAL25 = (Token) this.match(
						this.input,
						FUNCTIONAL,
						FOLLOW_FUNCTIONAL_in_unaryCharacteristic992);
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
					root_0 = (OPPLSyntaxTree) this.adaptor.nil();
					// 105:16: -> ^( FUNCTIONAL )
					{
						// MOWLParser.g:105:19: ^( FUNCTIONAL )
						{
							OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor.nil();
							root_1 = (OPPLSyntaxTree) this.adaptor.becomeRoot(
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
				// MOWLParser.g:106:7: INVERSE_FUNCTIONAL
			{
				INVERSE_FUNCTIONAL26 = (Token) this.match(
						this.input,
						INVERSE_FUNCTIONAL,
						FOLLOW_INVERSE_FUNCTIONAL_in_unaryCharacteristic1006);
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
					root_0 = (OPPLSyntaxTree) this.adaptor.nil();
					// 106:26: -> ^( INVERSE_FUNCTIONAL )
					{
						// MOWLParser.g:106:29: ^( INVERSE_FUNCTIONAL )
						{
							OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor.nil();
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
				// MOWLParser.g:107:7: SYMMETRIC
			{
				SYMMETRIC27 = (Token) this.match(
						this.input,
						SYMMETRIC,
						FOLLOW_SYMMETRIC_in_unaryCharacteristic1020);
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
					root_0 = (OPPLSyntaxTree) this.adaptor.nil();
					// 107:17: -> ^( SYMMETRIC )
					{
						// MOWLParser.g:107:20: ^( SYMMETRIC )
						{
							OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor.nil();
							root_1 = (OPPLSyntaxTree) this.adaptor.becomeRoot(
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
				// MOWLParser.g:108:7: ANTI_SYMMETRIC
			{
				ANTI_SYMMETRIC28 = (Token) this.match(
						this.input,
						ANTI_SYMMETRIC,
						FOLLOW_ANTI_SYMMETRIC_in_unaryCharacteristic1034);
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
					root_0 = (OPPLSyntaxTree) this.adaptor.nil();
					// 108:22: -> ^( ANTI_SYMMETRIC )
					{
						// MOWLParser.g:108:25: ^( ANTI_SYMMETRIC )
						{
							OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor.nil();
							root_1 = (OPPLSyntaxTree) this.adaptor.becomeRoot(
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
				// MOWLParser.g:109:7: REFLEXIVE
			{
				REFLEXIVE29 = (Token) this.match(
						this.input,
						REFLEXIVE,
						FOLLOW_REFLEXIVE_in_unaryCharacteristic1048);
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
					root_0 = (OPPLSyntaxTree) this.adaptor.nil();
					// 109:17: -> ^( REFLEXIVE )
					{
						// MOWLParser.g:109:20: ^( REFLEXIVE )
						{
							OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor.nil();
							root_1 = (OPPLSyntaxTree) this.adaptor.becomeRoot(
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
				// MOWLParser.g:110:7: IRREFLEXIVE
			{
				IRREFLEXIVE30 = (Token) this.match(
						this.input,
						IRREFLEXIVE,
						FOLLOW_IRREFLEXIVE_in_unaryCharacteristic1062);
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
					root_0 = (OPPLSyntaxTree) this.adaptor.nil();
					// 110:19: -> ^( IRREFLEXIVE )
					{
						// MOWLParser.g:110:22: ^( IRREFLEXIVE )
						{
							OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor.nil();
							root_1 = (OPPLSyntaxTree) this.adaptor.becomeRoot(
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
				// MOWLParser.g:111:7: TRANSITIVE
			{
				TRANSITIVE31 = (Token) this.match(
						this.input,
						TRANSITIVE,
						FOLLOW_TRANSITIVE_in_unaryCharacteristic1076);
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
					root_0 = (OPPLSyntaxTree) this.adaptor.nil();
					// 111:18: -> ^( TRANSITIVE )
					{
						// MOWLParser.g:111:21: ^( TRANSITIVE )
						{
							OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor.nil();
							root_1 = (OPPLSyntaxTree) this.adaptor.becomeRoot(
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
				retval.tree = (OPPLSyntaxTree) this.adaptor.rulePostProcessing(root_0);
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
		OPPLSyntaxTree tree;

		@Override
		public Object getTree() {
			return this.tree;
		}
	};

	// $ANTLR start "expression"
	// MOWLParser.g:114:1: expression : ( options {backtrack=true; } : head=
	// propertyExpression ( COMPOSITION rest+= propertyExpression )+ -> ^(
	// PROPERTY_CHAIN $head $rest) | conjunction ( OR conjunction )* -> ^(
	// DISJUNCTION ( conjunction )+ ) | complexPropertyExpression -> ^(
	// complexPropertyExpression ) ) ;
	public final OPPLParser_MOWLParser.expression_return expression() throws RecognitionException {
		OPPLParser_MOWLParser.expression_return retval = new OPPLParser_MOWLParser.expression_return();
		retval.start = this.input.LT(1);
		OPPLSyntaxTree root_0 = null;
		Token COMPOSITION32 = null;
		Token OR34 = null;
		List list_rest = null;
		OPPLParser_MOWLParser.propertyExpression_return head = null;
		OPPLParser_MOWLParser.conjunction_return conjunction33 = null;
		OPPLParser_MOWLParser.conjunction_return conjunction35 = null;
		OPPLParser_MOWLParser.complexPropertyExpression_return complexPropertyExpression36 = null;
		RuleReturnScope rest = null;
		OPPLSyntaxTree COMPOSITION32_tree = null;
		OPPLSyntaxTree OR34_tree = null;
		RewriteRuleTokenStream stream_COMPOSITION = new RewriteRuleTokenStream(this.adaptor,
				"token COMPOSITION");
		RewriteRuleTokenStream stream_OR = new RewriteRuleTokenStream(this.adaptor, "token OR");
		RewriteRuleSubtreeStream stream_propertyExpression = new RewriteRuleSubtreeStream(
				this.adaptor, "rule propertyExpression");
		RewriteRuleSubtreeStream stream_conjunction = new RewriteRuleSubtreeStream(this.adaptor,
				"rule conjunction");
		RewriteRuleSubtreeStream stream_complexPropertyExpression = new RewriteRuleSubtreeStream(
				this.adaptor, "rule complexPropertyExpression");
		try {
			// MOWLParser.g:114:11: ( ( options {backtrack=true; } : head=
			// propertyExpression ( COMPOSITION rest+= propertyExpression )+ ->
			// ^( PROPERTY_CHAIN $head $rest) | conjunction ( OR conjunction )*
			// -> ^( DISJUNCTION ( conjunction )+ ) | complexPropertyExpression
			// -> ^( complexPropertyExpression ) ) )
			// MOWLParser.g:115:5: ( options {backtrack=true; } : head=
			// propertyExpression ( COMPOSITION rest+= propertyExpression )+ ->
			// ^( PROPERTY_CHAIN $head $rest) | conjunction ( OR conjunction )*
			// -> ^( DISJUNCTION ( conjunction )+ ) | complexPropertyExpression
			// -> ^( complexPropertyExpression ) )
			{
				// MOWLParser.g:115:5: ( options {backtrack=true; } : head=
				// propertyExpression ( COMPOSITION rest+= propertyExpression )+
				// -> ^( PROPERTY_CHAIN $head $rest) | conjunction ( OR
				// conjunction )* -> ^( DISJUNCTION ( conjunction )+ ) |
				// complexPropertyExpression -> ^( complexPropertyExpression ) )
				int alt10 = 3;
				alt10 = this.dfa10.predict(this.input);
				switch (alt10) {
				case 1:
					// MOWLParser.g:117:4: head= propertyExpression (
					// COMPOSITION rest+= propertyExpression )+
				{
					this.pushFollow(FOLLOW_propertyExpression_in_expression1121);
					head = this.propertyExpression();
					this.state._fsp--;
					if (this.state.failed) {
						return retval;
					}
					if (this.state.backtracking == 0) {
						stream_propertyExpression.add(head.getTree());
					}
					// MOWLParser.g:117:30: ( COMPOSITION rest+=
					// propertyExpression )+
					int cnt8 = 0;
					loop8: do {
						int alt8 = 2;
						int LA8_0 = this.input.LA(1);
						if (LA8_0 == COMPOSITION) {
							alt8 = 1;
						}
						switch (alt8) {
						case 1:
							// MOWLParser.g:117:31: COMPOSITION rest+=
							// propertyExpression
						{
							COMPOSITION32 = (Token) this.match(
									this.input,
									COMPOSITION,
									FOLLOW_COMPOSITION_in_expression1124);
							if (this.state.failed) {
								return retval;
							}
							if (this.state.backtracking == 0) {
								stream_COMPOSITION.add(COMPOSITION32);
							}
							this.pushFollow(FOLLOW_propertyExpression_in_expression1128);
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
						root_0 = (OPPLSyntaxTree) this.adaptor.nil();
						// 117:71: -> ^( PROPERTY_CHAIN $head $rest)
						{
							// MOWLParser.g:117:74: ^( PROPERTY_CHAIN $head
							// $rest)
							{
								OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor.nil();
								root_1 = (OPPLSyntaxTree) this.adaptor.becomeRoot(
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
				case 2:
					// MOWLParser.g:118:6: conjunction ( OR conjunction )*
				{
					this.pushFollow(FOLLOW_conjunction_in_expression1151);
					conjunction33 = this.conjunction();
					this.state._fsp--;
					if (this.state.failed) {
						return retval;
					}
					if (this.state.backtracking == 0) {
						stream_conjunction.add(conjunction33.getTree());
					}
					// MOWLParser.g:118:18: ( OR conjunction )*
					loop9: do {
						int alt9 = 2;
						int LA9_0 = this.input.LA(1);
						if (LA9_0 == OR) {
							alt9 = 1;
						}
						switch (alt9) {
						case 1:
							// MOWLParser.g:118:19: OR conjunction
						{
							OR34 = (Token) this.match(this.input, OR, FOLLOW_OR_in_expression1154);
							if (this.state.failed) {
								return retval;
							}
							if (this.state.backtracking == 0) {
								stream_OR.add(OR34);
							}
							this.pushFollow(FOLLOW_conjunction_in_expression1156);
							conjunction35 = this.conjunction();
							this.state._fsp--;
							if (this.state.failed) {
								return retval;
							}
							if (this.state.backtracking == 0) {
								stream_conjunction.add(conjunction35.getTree());
							}
						}
							break;
						default:
							break loop9;
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
						root_0 = (OPPLSyntaxTree) this.adaptor.nil();
						// 118:36: -> ^( DISJUNCTION ( conjunction )+ )
						{
							// MOWLParser.g:118:39: ^( DISJUNCTION ( conjunction
							// )+ )
							{
								OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor.nil();
								root_1 = (OPPLSyntaxTree) this.adaptor.becomeRoot(
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
					// MOWLParser.g:119:6: complexPropertyExpression
				{
					this.pushFollow(FOLLOW_complexPropertyExpression_in_expression1175);
					complexPropertyExpression36 = this.complexPropertyExpression();
					this.state._fsp--;
					if (this.state.failed) {
						return retval;
					}
					if (this.state.backtracking == 0) {
						stream_complexPropertyExpression.add(complexPropertyExpression36.getTree());
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
						root_0 = (OPPLSyntaxTree) this.adaptor.nil();
						// 119:32: -> ^( complexPropertyExpression )
						{
							// MOWLParser.g:119:35: ^( complexPropertyExpression
							// )
							{
								OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor.nil();
								root_1 = (OPPLSyntaxTree) this.adaptor.becomeRoot(
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
			}
			retval.stop = this.input.LT(-1);
			if (this.state.backtracking == 0) {
				retval.tree = (OPPLSyntaxTree) this.adaptor.rulePostProcessing(root_0);
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
		OPPLSyntaxTree tree;

		@Override
		public Object getTree() {
			return this.tree;
		}
	};

	// $ANTLR start "conjunction"
	// MOWLParser.g:126:1: conjunction : unary ( AND unary )* -> ^( CONJUNCTION
	// ( unary )+ ) ;
	public final OPPLParser_MOWLParser.conjunction_return conjunction() throws RecognitionException {
		OPPLParser_MOWLParser.conjunction_return retval = new OPPLParser_MOWLParser.conjunction_return();
		retval.start = this.input.LT(1);
		OPPLSyntaxTree root_0 = null;
		Token AND38 = null;
		OPPLParser_MOWLParser.unary_return unary37 = null;
		OPPLParser_MOWLParser.unary_return unary39 = null;
		OPPLSyntaxTree AND38_tree = null;
		RewriteRuleTokenStream stream_AND = new RewriteRuleTokenStream(this.adaptor, "token AND");
		RewriteRuleSubtreeStream stream_unary = new RewriteRuleSubtreeStream(this.adaptor,
				"rule unary");
		try {
			// MOWLParser.g:126:13: ( unary ( AND unary )* -> ^( CONJUNCTION (
			// unary )+ ) )
			// MOWLParser.g:127:5: unary ( AND unary )*
			{
				this.pushFollow(FOLLOW_unary_in_conjunction1207);
				unary37 = this.unary();
				this.state._fsp--;
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_unary.add(unary37.getTree());
				}
				// MOWLParser.g:127:11: ( AND unary )*
				loop11: do {
					int alt11 = 2;
					int LA11_0 = this.input.LA(1);
					if (LA11_0 == AND) {
						alt11 = 1;
					}
					switch (alt11) {
					case 1:
						// MOWLParser.g:127:12: AND unary
					{
						AND38 = (Token) this.match(this.input, AND, FOLLOW_AND_in_conjunction1210);
						if (this.state.failed) {
							return retval;
						}
						if (this.state.backtracking == 0) {
							stream_AND.add(AND38);
						}
						this.pushFollow(FOLLOW_unary_in_conjunction1212);
						unary39 = this.unary();
						this.state._fsp--;
						if (this.state.failed) {
							return retval;
						}
						if (this.state.backtracking == 0) {
							stream_unary.add(unary39.getTree());
						}
					}
						break;
					default:
						break loop11;
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
					root_0 = (OPPLSyntaxTree) this.adaptor.nil();
					// 127:24: -> ^( CONJUNCTION ( unary )+ )
					{
						// MOWLParser.g:127:27: ^( CONJUNCTION ( unary )+ )
						{
							OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor.nil();
							root_1 = (OPPLSyntaxTree) this.adaptor.becomeRoot(
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
				retval.tree = (OPPLSyntaxTree) this.adaptor.rulePostProcessing(root_0);
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
		OPPLSyntaxTree tree;

		@Override
		public Object getTree() {
			return this.tree;
		}
	};

	// $ANTLR start "complexPropertyExpression"
	// MOWLParser.g:130:1: complexPropertyExpression : ( INVERSE
	// OPEN_PARENTHESYS complexPropertyExpression CLOSED_PARENTHESYS -> ^(
	// INVERSE_OBJECT_PROPERTY_EXPRESSION complexPropertyExpression ) | INVERSE
	// OPEN_PARENTHESYS IDENTIFIER CLOSED_PARENTHESYS -> ^(
	// INVERSE_OBJECT_PROPERTY_EXPRESSION IDENTIFIER ) );
	public final OPPLParser_MOWLParser.complexPropertyExpression_return complexPropertyExpression()
			throws RecognitionException {
		OPPLParser_MOWLParser.complexPropertyExpression_return retval = new OPPLParser_MOWLParser.complexPropertyExpression_return();
		retval.start = this.input.LT(1);
		OPPLSyntaxTree root_0 = null;
		Token INVERSE40 = null;
		Token OPEN_PARENTHESYS41 = null;
		Token CLOSED_PARENTHESYS43 = null;
		Token INVERSE44 = null;
		Token OPEN_PARENTHESYS45 = null;
		Token IDENTIFIER46 = null;
		Token CLOSED_PARENTHESYS47 = null;
		OPPLParser_MOWLParser.complexPropertyExpression_return complexPropertyExpression42 = null;
		OPPLSyntaxTree INVERSE40_tree = null;
		OPPLSyntaxTree OPEN_PARENTHESYS41_tree = null;
		OPPLSyntaxTree CLOSED_PARENTHESYS43_tree = null;
		OPPLSyntaxTree INVERSE44_tree = null;
		OPPLSyntaxTree OPEN_PARENTHESYS45_tree = null;
		OPPLSyntaxTree IDENTIFIER46_tree = null;
		OPPLSyntaxTree CLOSED_PARENTHESYS47_tree = null;
		RewriteRuleTokenStream stream_INVERSE = new RewriteRuleTokenStream(this.adaptor,
				"token INVERSE");
		RewriteRuleTokenStream stream_CLOSED_PARENTHESYS = new RewriteRuleTokenStream(this.adaptor,
				"token CLOSED_PARENTHESYS");
		RewriteRuleTokenStream stream_IDENTIFIER = new RewriteRuleTokenStream(this.adaptor,
				"token IDENTIFIER");
		RewriteRuleTokenStream stream_OPEN_PARENTHESYS = new RewriteRuleTokenStream(this.adaptor,
				"token OPEN_PARENTHESYS");
		RewriteRuleSubtreeStream stream_complexPropertyExpression = new RewriteRuleSubtreeStream(
				this.adaptor, "rule complexPropertyExpression");
		try {
			// MOWLParser.g:130:26: ( INVERSE OPEN_PARENTHESYS
			// complexPropertyExpression CLOSED_PARENTHESYS -> ^(
			// INVERSE_OBJECT_PROPERTY_EXPRESSION complexPropertyExpression ) |
			// INVERSE OPEN_PARENTHESYS IDENTIFIER CLOSED_PARENTHESYS -> ^(
			// INVERSE_OBJECT_PROPERTY_EXPRESSION IDENTIFIER ) )
			int alt12 = 2;
			int LA12_0 = this.input.LA(1);
			if (LA12_0 == INVERSE) {
				int LA12_1 = this.input.LA(2);
				if (LA12_1 == OPEN_PARENTHESYS) {
					int LA12_2 = this.input.LA(3);
					if (LA12_2 == IDENTIFIER) {
						alt12 = 2;
					} else if (LA12_2 == INVERSE) {
						alt12 = 1;
					} else {
						if (this.state.backtracking > 0) {
							this.state.failed = true;
							return retval;
						}
						NoViableAltException nvae = new NoViableAltException("", 12, 2, this.input);
						throw nvae;
					}
				} else {
					if (this.state.backtracking > 0) {
						this.state.failed = true;
						return retval;
					}
					NoViableAltException nvae = new NoViableAltException("", 12, 1, this.input);
					throw nvae;
				}
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
				// MOWLParser.g:131:2: INVERSE OPEN_PARENTHESYS
				// complexPropertyExpression CLOSED_PARENTHESYS
			{
				INVERSE40 = (Token) this.match(
						this.input,
						INVERSE,
						FOLLOW_INVERSE_in_complexPropertyExpression1233);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_INVERSE.add(INVERSE40);
				}
				OPEN_PARENTHESYS41 = (Token) this.match(
						this.input,
						OPEN_PARENTHESYS,
						FOLLOW_OPEN_PARENTHESYS_in_complexPropertyExpression1235);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_OPEN_PARENTHESYS.add(OPEN_PARENTHESYS41);
				}
				this.pushFollow(FOLLOW_complexPropertyExpression_in_complexPropertyExpression1237);
				complexPropertyExpression42 = this.complexPropertyExpression();
				this.state._fsp--;
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_complexPropertyExpression.add(complexPropertyExpression42.getTree());
				}
				CLOSED_PARENTHESYS43 = (Token) this.match(
						this.input,
						CLOSED_PARENTHESYS,
						FOLLOW_CLOSED_PARENTHESYS_in_complexPropertyExpression1239);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_CLOSED_PARENTHESYS.add(CLOSED_PARENTHESYS43);
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
					root_0 = (OPPLSyntaxTree) this.adaptor.nil();
					// 131:72: -> ^( INVERSE_OBJECT_PROPERTY_EXPRESSION
					// complexPropertyExpression )
					{
						// MOWLParser.g:131:75: ^(
						// INVERSE_OBJECT_PROPERTY_EXPRESSION
						// complexPropertyExpression )
						{
							OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor.nil();
							root_1 = (OPPLSyntaxTree) this.adaptor.becomeRoot(this.adaptor.create(
									INVERSE_OBJECT_PROPERTY_EXPRESSION,
									"INVERSE_OBJECT_PROPERTY_EXPRESSION"), root_1);
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
				// MOWLParser.g:132:4: INVERSE OPEN_PARENTHESYS IDENTIFIER
				// CLOSED_PARENTHESYS
			{
				INVERSE44 = (Token) this.match(
						this.input,
						INVERSE,
						FOLLOW_INVERSE_in_complexPropertyExpression1252);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_INVERSE.add(INVERSE44);
				}
				OPEN_PARENTHESYS45 = (Token) this.match(
						this.input,
						OPEN_PARENTHESYS,
						FOLLOW_OPEN_PARENTHESYS_in_complexPropertyExpression1254);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_OPEN_PARENTHESYS.add(OPEN_PARENTHESYS45);
				}
				IDENTIFIER46 = (Token) this.match(
						this.input,
						IDENTIFIER,
						FOLLOW_IDENTIFIER_in_complexPropertyExpression1256);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_IDENTIFIER.add(IDENTIFIER46);
				}
				CLOSED_PARENTHESYS47 = (Token) this.match(
						this.input,
						CLOSED_PARENTHESYS,
						FOLLOW_CLOSED_PARENTHESYS_in_complexPropertyExpression1258);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_CLOSED_PARENTHESYS.add(CLOSED_PARENTHESYS47);
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
					// 132:58: -> ^( INVERSE_OBJECT_PROPERTY_EXPRESSION
					// IDENTIFIER )
					{
						// MOWLParser.g:132:61: ^(
						// INVERSE_OBJECT_PROPERTY_EXPRESSION IDENTIFIER )
						{
							OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor.nil();
							root_1 = (OPPLSyntaxTree) this.adaptor.becomeRoot(this.adaptor.create(
									INVERSE_OBJECT_PROPERTY_EXPRESSION,
									"INVERSE_OBJECT_PROPERTY_EXPRESSION"), root_1);
							this.adaptor.addChild(root_1, stream_IDENTIFIER.nextNode());
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
	// MOWLParser.g:135:1: unary : ( atomic | NOT OPEN_PARENTHESYS expression
	// CLOSED_PARENTHESYS -> ^( NEGATED_EXPRESSION expression ) | NOT atomic ->
	// ^( NEGATED_EXPRESSION atomic ) | qualifiedRestriction -> ^(
	// qualifiedRestriction ) | constant );
	public final OPPLParser_MOWLParser.unary_return unary() throws RecognitionException {
		OPPLParser_MOWLParser.unary_return retval = new OPPLParser_MOWLParser.unary_return();
		retval.start = this.input.LT(1);
		OPPLSyntaxTree root_0 = null;
		Token NOT49 = null;
		Token OPEN_PARENTHESYS50 = null;
		Token CLOSED_PARENTHESYS52 = null;
		Token NOT53 = null;
		OPPLParser.atomic_return atomic48 = null;
		OPPLParser_MOWLParser.expression_return expression51 = null;
		OPPLParser.atomic_return atomic54 = null;
		OPPLParser_MOWLParser.qualifiedRestriction_return qualifiedRestriction55 = null;
		OPPLParser_MOWLParser.constant_return constant56 = null;
		OPPLSyntaxTree NOT49_tree = null;
		OPPLSyntaxTree OPEN_PARENTHESYS50_tree = null;
		OPPLSyntaxTree CLOSED_PARENTHESYS52_tree = null;
		OPPLSyntaxTree NOT53_tree = null;
		RewriteRuleTokenStream stream_NOT = new RewriteRuleTokenStream(this.adaptor, "token NOT");
		RewriteRuleTokenStream stream_CLOSED_PARENTHESYS = new RewriteRuleTokenStream(this.adaptor,
				"token CLOSED_PARENTHESYS");
		RewriteRuleTokenStream stream_OPEN_PARENTHESYS = new RewriteRuleTokenStream(this.adaptor,
				"token OPEN_PARENTHESYS");
		RewriteRuleSubtreeStream stream_expression = new RewriteRuleSubtreeStream(this.adaptor,
				"rule expression");
		RewriteRuleSubtreeStream stream_qualifiedRestriction = new RewriteRuleSubtreeStream(
				this.adaptor, "rule qualifiedRestriction");
		RewriteRuleSubtreeStream stream_atomic = new RewriteRuleSubtreeStream(this.adaptor,
				"rule atomic");
		try {
			// MOWLParser.g:135:7: ( atomic | NOT OPEN_PARENTHESYS expression
			// CLOSED_PARENTHESYS -> ^( NEGATED_EXPRESSION expression ) | NOT
			// atomic -> ^( NEGATED_EXPRESSION atomic ) | qualifiedRestriction
			// -> ^( qualifiedRestriction ) | constant )
			int alt13 = 5;
			alt13 = this.dfa13.predict(this.input);
			switch (alt13) {
			case 1:
				// MOWLParser.g:136:3: atomic
			{
				root_0 = (OPPLSyntaxTree) this.adaptor.nil();
				this.pushFollow(FOLLOW_atomic_in_unary1278);
				atomic48 = this.gOPPLParser.atomic();
				this.state._fsp--;
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					this.adaptor.addChild(root_0, atomic48.getTree());
				}
			}
				break;
			case 2:
				// MOWLParser.g:137:5: NOT OPEN_PARENTHESYS expression
				// CLOSED_PARENTHESYS
			{
				NOT49 = (Token) this.match(this.input, NOT, FOLLOW_NOT_in_unary1284);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_NOT.add(NOT49);
				}
				OPEN_PARENTHESYS50 = (Token) this.match(
						this.input,
						OPEN_PARENTHESYS,
						FOLLOW_OPEN_PARENTHESYS_in_unary1286);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_OPEN_PARENTHESYS.add(OPEN_PARENTHESYS50);
				}
				this.pushFollow(FOLLOW_expression_in_unary1288);
				expression51 = this.expression();
				this.state._fsp--;
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_expression.add(expression51.getTree());
				}
				CLOSED_PARENTHESYS52 = (Token) this.match(
						this.input,
						CLOSED_PARENTHESYS,
						FOLLOW_CLOSED_PARENTHESYS_in_unary1290);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_CLOSED_PARENTHESYS.add(CLOSED_PARENTHESYS52);
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
					// 137:56: -> ^( NEGATED_EXPRESSION expression )
					{
						// MOWLParser.g:137:59: ^( NEGATED_EXPRESSION expression
						// )
						{
							OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor.nil();
							root_1 = (OPPLSyntaxTree) this.adaptor.becomeRoot(
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
			case 3:
				// MOWLParser.g:138:5: NOT atomic
			{
				NOT53 = (Token) this.match(this.input, NOT, FOLLOW_NOT_in_unary1304);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_NOT.add(NOT53);
				}
				this.pushFollow(FOLLOW_atomic_in_unary1306);
				atomic54 = this.gOPPLParser.atomic();
				this.state._fsp--;
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_atomic.add(atomic54.getTree());
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
					// 138:16: -> ^( NEGATED_EXPRESSION atomic )
					{
						// MOWLParser.g:138:19: ^( NEGATED_EXPRESSION atomic )
						{
							OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor.nil();
							root_1 = (OPPLSyntaxTree) this.adaptor.becomeRoot(
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
			case 4:
				// MOWLParser.g:139:5: qualifiedRestriction
			{
				this.pushFollow(FOLLOW_qualifiedRestriction_in_unary1327);
				qualifiedRestriction55 = this.qualifiedRestriction();
				this.state._fsp--;
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_qualifiedRestriction.add(qualifiedRestriction55.getTree());
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
					root_0 = (OPPLSyntaxTree) this.adaptor.nil();
					// 139:26: -> ^( qualifiedRestriction )
					{
						// MOWLParser.g:139:29: ^( qualifiedRestriction )
						{
							OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor.nil();
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
				// MOWLParser.g:140:5: constant
			{
				root_0 = (OPPLSyntaxTree) this.adaptor.nil();
				this.pushFollow(FOLLOW_constant_in_unary1339);
				constant56 = this.constant();
				this.state._fsp--;
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					this.adaptor.addChild(root_0, constant56.getTree());
				}
			}
				break;
			}
			retval.stop = this.input.LT(-1);
			if (this.state.backtracking == 0) {
				retval.tree = (OPPLSyntaxTree) this.adaptor.rulePostProcessing(root_0);
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
	public static class qualifiedRestriction_return extends ParserRuleReturnScope {
		OPPLSyntaxTree tree;

		@Override
		public Object getTree() {
			return this.tree;
		}
	};

	// $ANTLR start "qualifiedRestriction"
	// MOWLParser.g:148:1: qualifiedRestriction : ( options {backtrack=true; } :
	// propertyExpression SOME filler -> ^( SOME_RESTRICTION propertyExpression
	// filler ) | propertyExpression ONLY filler -> ^( ALL_RESTRICTION
	// propertyExpression filler ) | cardinalityRestriction -> ^(
	// cardinalityRestriction ) | oneOf -> ^( oneOf ) | valueRestriction -> ^(
	// valueRestriction ) ) ;
	public final OPPLParser_MOWLParser.qualifiedRestriction_return qualifiedRestriction()
			throws RecognitionException {
		OPPLParser_MOWLParser.qualifiedRestriction_return retval = new OPPLParser_MOWLParser.qualifiedRestriction_return();
		retval.start = this.input.LT(1);
		OPPLSyntaxTree root_0 = null;
		Token SOME58 = null;
		Token ONLY61 = null;
		OPPLParser_MOWLParser.propertyExpression_return propertyExpression57 = null;
		OPPLParser_MOWLParser.filler_return filler59 = null;
		OPPLParser_MOWLParser.propertyExpression_return propertyExpression60 = null;
		OPPLParser_MOWLParser.filler_return filler62 = null;
		OPPLParser_MOWLParser.cardinalityRestriction_return cardinalityRestriction63 = null;
		OPPLParser_MOWLParser.oneOf_return oneOf64 = null;
		OPPLParser_MOWLParser.valueRestriction_return valueRestriction65 = null;
		OPPLSyntaxTree SOME58_tree = null;
		OPPLSyntaxTree ONLY61_tree = null;
		RewriteRuleTokenStream stream_ONLY = new RewriteRuleTokenStream(this.adaptor, "token ONLY");
		RewriteRuleTokenStream stream_SOME = new RewriteRuleTokenStream(this.adaptor, "token SOME");
		RewriteRuleSubtreeStream stream_oneOf = new RewriteRuleSubtreeStream(this.adaptor,
				"rule oneOf");
		RewriteRuleSubtreeStream stream_propertyExpression = new RewriteRuleSubtreeStream(
				this.adaptor, "rule propertyExpression");
		RewriteRuleSubtreeStream stream_cardinalityRestriction = new RewriteRuleSubtreeStream(
				this.adaptor, "rule cardinalityRestriction");
		RewriteRuleSubtreeStream stream_filler = new RewriteRuleSubtreeStream(this.adaptor,
				"rule filler");
		RewriteRuleSubtreeStream stream_valueRestriction = new RewriteRuleSubtreeStream(
				this.adaptor, "rule valueRestriction");
		try {
			// MOWLParser.g:148:21: ( ( options {backtrack=true; } :
			// propertyExpression SOME filler -> ^( SOME_RESTRICTION
			// propertyExpression filler ) | propertyExpression ONLY filler ->
			// ^( ALL_RESTRICTION propertyExpression filler ) |
			// cardinalityRestriction -> ^( cardinalityRestriction ) | oneOf ->
			// ^( oneOf ) | valueRestriction -> ^( valueRestriction ) ) )
			// MOWLParser.g:149:9: ( options {backtrack=true; } :
			// propertyExpression SOME filler -> ^( SOME_RESTRICTION
			// propertyExpression filler ) | propertyExpression ONLY filler ->
			// ^( ALL_RESTRICTION propertyExpression filler ) |
			// cardinalityRestriction -> ^( cardinalityRestriction ) | oneOf ->
			// ^( oneOf ) | valueRestriction -> ^( valueRestriction ) )
			{
				// MOWLParser.g:149:9: ( options {backtrack=true; } :
				// propertyExpression SOME filler -> ^( SOME_RESTRICTION
				// propertyExpression filler ) | propertyExpression ONLY filler
				// -> ^( ALL_RESTRICTION propertyExpression filler ) |
				// cardinalityRestriction -> ^( cardinalityRestriction ) | oneOf
				// -> ^( oneOf ) | valueRestriction -> ^( valueRestriction ) )
				int alt15 = 5;
				alt15 = this.dfa15.predict(this.input);
				switch (alt15) {
				case 1:
					// MOWLParser.g:151:7: propertyExpression SOME filler
				{
					this.pushFollow(FOLLOW_propertyExpression_in_qualifiedRestriction1413);
					propertyExpression57 = this.propertyExpression();
					this.state._fsp--;
					if (this.state.failed) {
						return retval;
					}
					if (this.state.backtracking == 0) {
						stream_propertyExpression.add(propertyExpression57.getTree());
					}
					SOME58 = (Token) this.match(
							this.input,
							SOME,
							FOLLOW_SOME_in_qualifiedRestriction1416);
					if (this.state.failed) {
						return retval;
					}
					if (this.state.backtracking == 0) {
						stream_SOME.add(SOME58);
					}
					this.pushFollow(FOLLOW_filler_in_qualifiedRestriction1420);
					filler59 = this.filler();
					this.state._fsp--;
					if (this.state.failed) {
						return retval;
					}
					if (this.state.backtracking == 0) {
						stream_filler.add(filler59.getTree());
					}
					// AST REWRITE
					// elements: propertyExpression, filler
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
						// 151:42: -> ^( SOME_RESTRICTION propertyExpression
						// filler )
						{
							// MOWLParser.g:151:45: ^( SOME_RESTRICTION
							// propertyExpression filler )
							{
								OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor.nil();
								root_1 = (OPPLSyntaxTree) this.adaptor.becomeRoot(
										this.adaptor.create(SOME_RESTRICTION, "SOME_RESTRICTION"),
										root_1);
								this.adaptor.addChild(root_1, stream_propertyExpression.nextTree());
								this.adaptor.addChild(root_1, stream_filler.nextTree());
								this.adaptor.addChild(root_0, root_1);
							}
						}
						retval.tree = root_0;
					}
				}
					break;
				case 2:
					// MOWLParser.g:152:7: propertyExpression ONLY filler
				{
					this.pushFollow(FOLLOW_propertyExpression_in_qualifiedRestriction1449);
					propertyExpression60 = this.propertyExpression();
					this.state._fsp--;
					if (this.state.failed) {
						return retval;
					}
					if (this.state.backtracking == 0) {
						stream_propertyExpression.add(propertyExpression60.getTree());
					}
					ONLY61 = (Token) this.match(
							this.input,
							ONLY,
							FOLLOW_ONLY_in_qualifiedRestriction1451);
					if (this.state.failed) {
						return retval;
					}
					if (this.state.backtracking == 0) {
						stream_ONLY.add(ONLY61);
					}
					this.pushFollow(FOLLOW_filler_in_qualifiedRestriction1454);
					filler62 = this.filler();
					this.state._fsp--;
					if (this.state.failed) {
						return retval;
					}
					if (this.state.backtracking == 0) {
						stream_filler.add(filler62.getTree());
					}
					// AST REWRITE
					// elements: propertyExpression, filler
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
						// 152:40: -> ^( ALL_RESTRICTION propertyExpression
						// filler )
						{
							// MOWLParser.g:152:43: ^( ALL_RESTRICTION
							// propertyExpression filler )
							{
								OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor.nil();
								root_1 = (OPPLSyntaxTree) this.adaptor.becomeRoot(
										this.adaptor.create(ALL_RESTRICTION, "ALL_RESTRICTION"),
										root_1);
								this.adaptor.addChild(root_1, stream_propertyExpression.nextTree());
								this.adaptor.addChild(root_1, stream_filler.nextTree());
								this.adaptor.addChild(root_0, root_1);
							}
						}
						retval.tree = root_0;
					}
				}
					break;
				case 3:
					// MOWLParser.g:153:7: cardinalityRestriction
				{
					this.pushFollow(FOLLOW_cardinalityRestriction_in_qualifiedRestriction1473);
					cardinalityRestriction63 = this.cardinalityRestriction();
					this.state._fsp--;
					if (this.state.failed) {
						return retval;
					}
					if (this.state.backtracking == 0) {
						stream_cardinalityRestriction.add(cardinalityRestriction63.getTree());
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
						root_0 = (OPPLSyntaxTree) this.adaptor.nil();
						// 153:30: -> ^( cardinalityRestriction )
						{
							// MOWLParser.g:153:33: ^( cardinalityRestriction )
							{
								OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor.nil();
								root_1 = (OPPLSyntaxTree) this.adaptor.becomeRoot(
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
					// MOWLParser.g:154:7: oneOf
				{
					this.pushFollow(FOLLOW_oneOf_in_qualifiedRestriction1487);
					oneOf64 = this.oneOf();
					this.state._fsp--;
					if (this.state.failed) {
						return retval;
					}
					if (this.state.backtracking == 0) {
						stream_oneOf.add(oneOf64.getTree());
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
						root_0 = (OPPLSyntaxTree) this.adaptor.nil();
						// 154:13: -> ^( oneOf )
						{
							// MOWLParser.g:154:16: ^( oneOf )
							{
								OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor.nil();
								root_1 = (OPPLSyntaxTree) this.adaptor.becomeRoot(
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
					// MOWLParser.g:155:7: valueRestriction
				{
					this.pushFollow(FOLLOW_valueRestriction_in_qualifiedRestriction1501);
					valueRestriction65 = this.valueRestriction();
					this.state._fsp--;
					if (this.state.failed) {
						return retval;
					}
					if (this.state.backtracking == 0) {
						stream_valueRestriction.add(valueRestriction65.getTree());
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
						root_0 = (OPPLSyntaxTree) this.adaptor.nil();
						// 155:24: -> ^( valueRestriction )
						{
							// MOWLParser.g:155:27: ^( valueRestriction )
							{
								OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor.nil();
								root_1 = (OPPLSyntaxTree) this.adaptor.becomeRoot(
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
				retval.tree = (OPPLSyntaxTree) this.adaptor.rulePostProcessing(root_0);
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
		OPPLSyntaxTree tree;

		@Override
		public Object getTree() {
			return this.tree;
		}
	};

	// $ANTLR start "propertyExpression"
	// MOWLParser.g:159:1: propertyExpression : ( atomic -> ^( atomic ) |
	// complexPropertyExpression -> ^( complexPropertyExpression ) );
	public final OPPLParser_MOWLParser.propertyExpression_return propertyExpression()
			throws RecognitionException {
		OPPLParser_MOWLParser.propertyExpression_return retval = new OPPLParser_MOWLParser.propertyExpression_return();
		retval.start = this.input.LT(1);
		OPPLSyntaxTree root_0 = null;
		OPPLParser.atomic_return atomic66 = null;
		OPPLParser_MOWLParser.complexPropertyExpression_return complexPropertyExpression67 = null;
		RewriteRuleSubtreeStream stream_complexPropertyExpression = new RewriteRuleSubtreeStream(
				this.adaptor, "rule complexPropertyExpression");
		RewriteRuleSubtreeStream stream_atomic = new RewriteRuleSubtreeStream(this.adaptor,
				"rule atomic");
		try {
			// MOWLParser.g:159:21: ( atomic -> ^( atomic ) |
			// complexPropertyExpression -> ^( complexPropertyExpression ) )
			int alt16 = 2;
			int LA16_0 = this.input.LA(1);
			if (LA16_0 >= IDENTIFIER && LA16_0 <= ENTITY_REFERENCE || LA16_0 == VARIABLE_NAME
					|| LA16_0 == ESCLAMATION_MARK) {
				alt16 = 1;
			} else if (LA16_0 == INVERSE) {
				alt16 = 2;
			} else {
				if (this.state.backtracking > 0) {
					this.state.failed = true;
					return retval;
				}
				NoViableAltException nvae = new NoViableAltException("", 16, 0, this.input);
				throw nvae;
			}
			switch (alt16) {
			case 1:
				// MOWLParser.g:160:7: atomic
			{
				this.pushFollow(FOLLOW_atomic_in_propertyExpression1533);
				atomic66 = this.gOPPLParser.atomic();
				this.state._fsp--;
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_atomic.add(atomic66.getTree());
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
					// 160:14: -> ^( atomic )
					{
						// MOWLParser.g:160:17: ^( atomic )
						{
							OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor.nil();
							root_1 = (OPPLSyntaxTree) this.adaptor.becomeRoot(
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
				// MOWLParser.g:161:7: complexPropertyExpression
			{
				this.pushFollow(FOLLOW_complexPropertyExpression_in_propertyExpression1547);
				complexPropertyExpression67 = this.complexPropertyExpression();
				this.state._fsp--;
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_complexPropertyExpression.add(complexPropertyExpression67.getTree());
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
					root_0 = (OPPLSyntaxTree) this.adaptor.nil();
					// 161:33: -> ^( complexPropertyExpression )
					{
						// MOWLParser.g:161:36: ^( complexPropertyExpression )
						{
							OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor.nil();
							root_1 = (OPPLSyntaxTree) this.adaptor.becomeRoot(
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
				retval.tree = (OPPLSyntaxTree) this.adaptor.rulePostProcessing(root_0);
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
		OPPLSyntaxTree tree;

		@Override
		public Object getTree() {
			return this.tree;
		}
	};

	// $ANTLR start "cardinalityRestriction"
	// MOWLParser.g:164:1: cardinalityRestriction : propertyExpression
	// restrictionKind INTEGER ( filler )? -> ^( CARDINALITY_RESTRICTION
	// restrictionKind INTEGER propertyExpression ( filler )? ) ;
	public final OPPLParser_MOWLParser.cardinalityRestriction_return cardinalityRestriction()
			throws RecognitionException {
		OPPLParser_MOWLParser.cardinalityRestriction_return retval = new OPPLParser_MOWLParser.cardinalityRestriction_return();
		retval.start = this.input.LT(1);
		OPPLSyntaxTree root_0 = null;
		Token INTEGER70 = null;
		OPPLParser_MOWLParser.propertyExpression_return propertyExpression68 = null;
		OPPLParser_MOWLParser.restrictionKind_return restrictionKind69 = null;
		OPPLParser_MOWLParser.filler_return filler71 = null;
		OPPLSyntaxTree INTEGER70_tree = null;
		RewriteRuleTokenStream stream_INTEGER = new RewriteRuleTokenStream(this.adaptor,
				"token INTEGER");
		RewriteRuleSubtreeStream stream_propertyExpression = new RewriteRuleSubtreeStream(
				this.adaptor, "rule propertyExpression");
		RewriteRuleSubtreeStream stream_restrictionKind = new RewriteRuleSubtreeStream(
				this.adaptor, "rule restrictionKind");
		RewriteRuleSubtreeStream stream_filler = new RewriteRuleSubtreeStream(this.adaptor,
				"rule filler");
		try {
			// MOWLParser.g:164:24: ( propertyExpression restrictionKind INTEGER
			// ( filler )? -> ^( CARDINALITY_RESTRICTION restrictionKind INTEGER
			// propertyExpression ( filler )? ) )
			// MOWLParser.g:165:6: propertyExpression restrictionKind INTEGER (
			// filler )?
			{
				this.pushFollow(FOLLOW_propertyExpression_in_cardinalityRestriction1573);
				propertyExpression68 = this.propertyExpression();
				this.state._fsp--;
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_propertyExpression.add(propertyExpression68.getTree());
				}
				this.pushFollow(FOLLOW_restrictionKind_in_cardinalityRestriction1576);
				restrictionKind69 = this.restrictionKind();
				this.state._fsp--;
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_restrictionKind.add(restrictionKind69.getTree());
				}
				INTEGER70 = (Token) this.match(
						this.input,
						INTEGER,
						FOLLOW_INTEGER_in_cardinalityRestriction1578);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_INTEGER.add(INTEGER70);
				}
				// MOWLParser.g:165:50: ( filler )?
				int alt17 = 2;
				int LA17_0 = this.input.LA(1);
				if (LA17_0 == OPEN_PARENTHESYS || LA17_0 >= IDENTIFIER
						&& LA17_0 <= ENTITY_REFERENCE || LA17_0 == VARIABLE_NAME
						|| LA17_0 == ESCLAMATION_MARK) {
					alt17 = 1;
				}
				switch (alt17) {
				case 1:
					// MOWLParser.g:165:50: filler
				{
					this.pushFollow(FOLLOW_filler_in_cardinalityRestriction1580);
					filler71 = this.filler();
					this.state._fsp--;
					if (this.state.failed) {
						return retval;
					}
					if (this.state.backtracking == 0) {
						stream_filler.add(filler71.getTree());
					}
				}
					break;
				}
				// AST REWRITE
				// elements: filler, INTEGER, propertyExpression,
				// restrictionKind
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
					// 165:58: -> ^( CARDINALITY_RESTRICTION restrictionKind
					// INTEGER propertyExpression ( filler )? )
					{
						// MOWLParser.g:165:61: ^( CARDINALITY_RESTRICTION
						// restrictionKind INTEGER propertyExpression ( filler
						// )? )
						{
							OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor.nil();
							root_1 = (OPPLSyntaxTree) this.adaptor.becomeRoot(this.adaptor.create(
									CARDINALITY_RESTRICTION,
									"CARDINALITY_RESTRICTION"), root_1);
							this.adaptor.addChild(root_1, stream_restrictionKind.nextTree());
							this.adaptor.addChild(root_1, stream_INTEGER.nextNode());
							this.adaptor.addChild(root_1, stream_propertyExpression.nextTree());
							// MOWLParser.g:165:132: ( filler )?
							if (stream_filler.hasNext()) {
								this.adaptor.addChild(root_1, stream_filler.nextTree());
							}
							stream_filler.reset();
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
	// MOWLParser.g:168:1: restrictionKind : ( MIN -> ^( MIN ) | MAX -> ^( MAX )
	// | EXACTLY -> ^( EXACTLY ) );
	public final OPPLParser_MOWLParser.restrictionKind_return restrictionKind()
			throws RecognitionException {
		OPPLParser_MOWLParser.restrictionKind_return retval = new OPPLParser_MOWLParser.restrictionKind_return();
		retval.start = this.input.LT(1);
		OPPLSyntaxTree root_0 = null;
		Token MIN72 = null;
		Token MAX73 = null;
		Token EXACTLY74 = null;
		OPPLSyntaxTree MIN72_tree = null;
		OPPLSyntaxTree MAX73_tree = null;
		OPPLSyntaxTree EXACTLY74_tree = null;
		RewriteRuleTokenStream stream_MAX = new RewriteRuleTokenStream(this.adaptor, "token MAX");
		RewriteRuleTokenStream stream_MIN = new RewriteRuleTokenStream(this.adaptor, "token MIN");
		RewriteRuleTokenStream stream_EXACTLY = new RewriteRuleTokenStream(this.adaptor,
				"token EXACTLY");
		try {
			// MOWLParser.g:168:17: ( MIN -> ^( MIN ) | MAX -> ^( MAX ) |
			// EXACTLY -> ^( EXACTLY ) )
			int alt18 = 3;
			switch (this.input.LA(1)) {
			case MIN: {
				alt18 = 1;
			}
				break;
			case MAX: {
				alt18 = 2;
			}
				break;
			case EXACTLY: {
				alt18 = 3;
			}
				break;
			default:
				if (this.state.backtracking > 0) {
					this.state.failed = true;
					return retval;
				}
				NoViableAltException nvae = new NoViableAltException("", 18, 0, this.input);
				throw nvae;
			}
			switch (alt18) {
			case 1:
				// MOWLParser.g:169:5: MIN
			{
				MIN72 = (Token) this.match(this.input, MIN, FOLLOW_MIN_in_restrictionKind1615);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_MIN.add(MIN72);
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
					root_0 = (OPPLSyntaxTree) this.adaptor.nil();
					// 169:9: -> ^( MIN )
					{
						// MOWLParser.g:169:12: ^( MIN )
						{
							OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor.nil();
							root_1 = (OPPLSyntaxTree) this.adaptor.becomeRoot(
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
				// MOWLParser.g:170:7: MAX
			{
				MAX73 = (Token) this.match(this.input, MAX, FOLLOW_MAX_in_restrictionKind1629);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_MAX.add(MAX73);
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
					root_0 = (OPPLSyntaxTree) this.adaptor.nil();
					// 170:11: -> ^( MAX )
					{
						// MOWLParser.g:170:14: ^( MAX )
						{
							OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor.nil();
							root_1 = (OPPLSyntaxTree) this.adaptor.becomeRoot(
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
				// MOWLParser.g:171:7: EXACTLY
			{
				EXACTLY74 = (Token) this.match(
						this.input,
						EXACTLY,
						FOLLOW_EXACTLY_in_restrictionKind1643);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_EXACTLY.add(EXACTLY74);
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
					root_0 = (OPPLSyntaxTree) this.adaptor.nil();
					// 171:15: -> ^( EXACTLY )
					{
						// MOWLParser.g:171:18: ^( EXACTLY )
						{
							OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor.nil();
							root_1 = (OPPLSyntaxTree) this.adaptor.becomeRoot(
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
				retval.tree = (OPPLSyntaxTree) this.adaptor.rulePostProcessing(root_0);
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
	public static class filler_return extends ParserRuleReturnScope {
		OPPLSyntaxTree tree;

		@Override
		public Object getTree() {
			return this.tree;
		}
	};

	// $ANTLR start "filler"
	// MOWLParser.g:173:1: filler : ( atomic -> ^( atomic ) | OPEN_PARENTHESYS
	// expression CLOSED_PARENTHESYS -> ^( expression ) );
	public final OPPLParser_MOWLParser.filler_return filler() throws RecognitionException {
		OPPLParser_MOWLParser.filler_return retval = new OPPLParser_MOWLParser.filler_return();
		retval.start = this.input.LT(1);
		OPPLSyntaxTree root_0 = null;
		Token OPEN_PARENTHESYS76 = null;
		Token CLOSED_PARENTHESYS78 = null;
		OPPLParser.atomic_return atomic75 = null;
		OPPLParser_MOWLParser.expression_return expression77 = null;
		OPPLSyntaxTree OPEN_PARENTHESYS76_tree = null;
		OPPLSyntaxTree CLOSED_PARENTHESYS78_tree = null;
		RewriteRuleTokenStream stream_CLOSED_PARENTHESYS = new RewriteRuleTokenStream(this.adaptor,
				"token CLOSED_PARENTHESYS");
		RewriteRuleTokenStream stream_OPEN_PARENTHESYS = new RewriteRuleTokenStream(this.adaptor,
				"token OPEN_PARENTHESYS");
		RewriteRuleSubtreeStream stream_expression = new RewriteRuleSubtreeStream(this.adaptor,
				"rule expression");
		RewriteRuleSubtreeStream stream_atomic = new RewriteRuleSubtreeStream(this.adaptor,
				"rule atomic");
		try {
			// MOWLParser.g:173:7: ( atomic -> ^( atomic ) | OPEN_PARENTHESYS
			// expression CLOSED_PARENTHESYS -> ^( expression ) )
			int alt19 = 2;
			int LA19_0 = this.input.LA(1);
			if (LA19_0 >= IDENTIFIER && LA19_0 <= ENTITY_REFERENCE || LA19_0 == VARIABLE_NAME
					|| LA19_0 == ESCLAMATION_MARK) {
				alt19 = 1;
			} else if (LA19_0 == OPEN_PARENTHESYS) {
				alt19 = 2;
			} else {
				if (this.state.backtracking > 0) {
					this.state.failed = true;
					return retval;
				}
				NoViableAltException nvae = new NoViableAltException("", 19, 0, this.input);
				throw nvae;
			}
			switch (alt19) {
			case 1:
				// MOWLParser.g:174:5: atomic
			{
				this.pushFollow(FOLLOW_atomic_in_filler1665);
				atomic75 = this.gOPPLParser.atomic();
				this.state._fsp--;
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_atomic.add(atomic75.getTree());
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
					// 174:12: -> ^( atomic )
					{
						// MOWLParser.g:174:15: ^( atomic )
						{
							OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor.nil();
							root_1 = (OPPLSyntaxTree) this.adaptor.becomeRoot(
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
				// MOWLParser.g:175:7: OPEN_PARENTHESYS expression
				// CLOSED_PARENTHESYS
			{
				OPEN_PARENTHESYS76 = (Token) this.match(
						this.input,
						OPEN_PARENTHESYS,
						FOLLOW_OPEN_PARENTHESYS_in_filler1679);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_OPEN_PARENTHESYS.add(OPEN_PARENTHESYS76);
				}
				this.pushFollow(FOLLOW_expression_in_filler1681);
				expression77 = this.expression();
				this.state._fsp--;
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_expression.add(expression77.getTree());
				}
				CLOSED_PARENTHESYS78 = (Token) this.match(
						this.input,
						CLOSED_PARENTHESYS,
						FOLLOW_CLOSED_PARENTHESYS_in_filler1683);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_CLOSED_PARENTHESYS.add(CLOSED_PARENTHESYS78);
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
					// 175:54: -> ^( expression )
					{
						// MOWLParser.g:175:57: ^( expression )
						{
							OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor.nil();
							root_1 = (OPPLSyntaxTree) this.adaptor.becomeRoot(
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
			retval.stop = this.input.LT(-1);
			if (this.state.backtracking == 0) {
				retval.tree = (OPPLSyntaxTree) this.adaptor.rulePostProcessing(root_0);
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

	// $ANTLR end "filler"
	public static class oneOf_return extends ParserRuleReturnScope {
		OPPLSyntaxTree tree;

		@Override
		public Object getTree() {
			return this.tree;
		}
	};

	// $ANTLR start "oneOf"
	// MOWLParser.g:178:1: oneOf : OPEN_CURLY_BRACES atomic ( COMMA atomic )*
	// CLOSED_CURLY_BRACES -> ^( ONE_OF ( atomic )+ ) ;
	public final OPPLParser_MOWLParser.oneOf_return oneOf() throws RecognitionException {
		OPPLParser_MOWLParser.oneOf_return retval = new OPPLParser_MOWLParser.oneOf_return();
		retval.start = this.input.LT(1);
		OPPLSyntaxTree root_0 = null;
		Token OPEN_CURLY_BRACES79 = null;
		Token COMMA81 = null;
		Token CLOSED_CURLY_BRACES83 = null;
		OPPLParser.atomic_return atomic80 = null;
		OPPLParser.atomic_return atomic82 = null;
		OPPLSyntaxTree OPEN_CURLY_BRACES79_tree = null;
		OPPLSyntaxTree COMMA81_tree = null;
		OPPLSyntaxTree CLOSED_CURLY_BRACES83_tree = null;
		RewriteRuleTokenStream stream_COMMA = new RewriteRuleTokenStream(this.adaptor,
				"token COMMA");
		RewriteRuleTokenStream stream_CLOSED_CURLY_BRACES = new RewriteRuleTokenStream(
				this.adaptor, "token CLOSED_CURLY_BRACES");
		RewriteRuleTokenStream stream_OPEN_CURLY_BRACES = new RewriteRuleTokenStream(this.adaptor,
				"token OPEN_CURLY_BRACES");
		RewriteRuleSubtreeStream stream_atomic = new RewriteRuleSubtreeStream(this.adaptor,
				"rule atomic");
		try {
			// MOWLParser.g:178:7: ( OPEN_CURLY_BRACES atomic ( COMMA atomic )*
			// CLOSED_CURLY_BRACES -> ^( ONE_OF ( atomic )+ ) )
			// MOWLParser.g:179:3: OPEN_CURLY_BRACES atomic ( COMMA atomic )*
			// CLOSED_CURLY_BRACES
			{
				OPEN_CURLY_BRACES79 = (Token) this.match(
						this.input,
						OPEN_CURLY_BRACES,
						FOLLOW_OPEN_CURLY_BRACES_in_oneOf1701);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_OPEN_CURLY_BRACES.add(OPEN_CURLY_BRACES79);
				}
				this.pushFollow(FOLLOW_atomic_in_oneOf1703);
				atomic80 = this.gOPPLParser.atomic();
				this.state._fsp--;
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_atomic.add(atomic80.getTree());
				}
				// MOWLParser.g:179:28: ( COMMA atomic )*
				loop20: do {
					int alt20 = 2;
					int LA20_0 = this.input.LA(1);
					if (LA20_0 == COMMA) {
						alt20 = 1;
					}
					switch (alt20) {
					case 1:
						// MOWLParser.g:179:29: COMMA atomic
					{
						COMMA81 = (Token) this.match(this.input, COMMA, FOLLOW_COMMA_in_oneOf1706);
						if (this.state.failed) {
							return retval;
						}
						if (this.state.backtracking == 0) {
							stream_COMMA.add(COMMA81);
						}
						this.pushFollow(FOLLOW_atomic_in_oneOf1708);
						atomic82 = this.gOPPLParser.atomic();
						this.state._fsp--;
						if (this.state.failed) {
							return retval;
						}
						if (this.state.backtracking == 0) {
							stream_atomic.add(atomic82.getTree());
						}
					}
						break;
					default:
						break loop20;
					}
				} while (true);
				CLOSED_CURLY_BRACES83 = (Token) this.match(
						this.input,
						CLOSED_CURLY_BRACES,
						FOLLOW_CLOSED_CURLY_BRACES_in_oneOf1712);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_CLOSED_CURLY_BRACES.add(CLOSED_CURLY_BRACES83);
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
					// 179:64: -> ^( ONE_OF ( atomic )+ )
					{
						// MOWLParser.g:179:67: ^( ONE_OF ( atomic )+ )
						{
							OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor.nil();
							root_1 = (OPPLSyntaxTree) this.adaptor.becomeRoot(
									this.adaptor.create(ONE_OF, "ONE_OF"),
									root_1);
							if (!stream_atomic.hasNext()) {
								throw new RewriteEarlyExitException();
							}
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
	// MOWLParser.g:182:1: valueRestriction : propertyExpression VALUE value ->
	// ^( VALUE_RESTRICTION propertyExpression value ) ;
	public final OPPLParser_MOWLParser.valueRestriction_return valueRestriction()
			throws RecognitionException {
		OPPLParser_MOWLParser.valueRestriction_return retval = new OPPLParser_MOWLParser.valueRestriction_return();
		retval.start = this.input.LT(1);
		OPPLSyntaxTree root_0 = null;
		Token VALUE85 = null;
		OPPLParser_MOWLParser.propertyExpression_return propertyExpression84 = null;
		OPPLParser_MOWLParser.value_return value86 = null;
		OPPLSyntaxTree VALUE85_tree = null;
		RewriteRuleTokenStream stream_VALUE = new RewriteRuleTokenStream(this.adaptor,
				"token VALUE");
		RewriteRuleSubtreeStream stream_propertyExpression = new RewriteRuleSubtreeStream(
				this.adaptor, "rule propertyExpression");
		RewriteRuleSubtreeStream stream_value = new RewriteRuleSubtreeStream(this.adaptor,
				"rule value");
		try {
			// MOWLParser.g:182:18: ( propertyExpression VALUE value -> ^(
			// VALUE_RESTRICTION propertyExpression value ) )
			// MOWLParser.g:182:20: propertyExpression VALUE value
			{
				this.pushFollow(FOLLOW_propertyExpression_in_valueRestriction1732);
				propertyExpression84 = this.propertyExpression();
				this.state._fsp--;
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_propertyExpression.add(propertyExpression84.getTree());
				}
				VALUE85 = (Token) this.match(
						this.input,
						VALUE,
						FOLLOW_VALUE_in_valueRestriction1734);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_VALUE.add(VALUE85);
				}
				this.pushFollow(FOLLOW_value_in_valueRestriction1736);
				value86 = this.value();
				this.state._fsp--;
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_value.add(value86.getTree());
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
							this.adaptor, "rule retval", retval != null ? retval.tree : null);
					root_0 = (OPPLSyntaxTree) this.adaptor.nil();
					// 182:51: -> ^( VALUE_RESTRICTION propertyExpression value
					// )
					{
						// MOWLParser.g:182:54: ^( VALUE_RESTRICTION
						// propertyExpression value )
						{
							OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor.nil();
							root_1 = (OPPLSyntaxTree) this.adaptor.becomeRoot(
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
				retval.tree = (OPPLSyntaxTree) this.adaptor.rulePostProcessing(root_0);
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
		OPPLSyntaxTree tree;

		@Override
		public Object getTree() {
			return this.tree;
		}
	};

	// $ANTLR start "value"
	// MOWLParser.g:185:1: value : ( atomic -> ^( atomic ) | constant -> ^(
	// constant ) );
	public final OPPLParser_MOWLParser.value_return value() throws RecognitionException {
		OPPLParser_MOWLParser.value_return retval = new OPPLParser_MOWLParser.value_return();
		retval.start = this.input.LT(1);
		OPPLSyntaxTree root_0 = null;
		OPPLParser.atomic_return atomic87 = null;
		OPPLParser_MOWLParser.constant_return constant88 = null;
		RewriteRuleSubtreeStream stream_constant = new RewriteRuleSubtreeStream(this.adaptor,
				"rule constant");
		RewriteRuleSubtreeStream stream_atomic = new RewriteRuleSubtreeStream(this.adaptor,
				"rule atomic");
		try {
			// MOWLParser.g:185:6: ( atomic -> ^( atomic ) | constant -> ^(
			// constant ) )
			int alt21 = 2;
			int LA21_0 = this.input.LA(1);
			if (LA21_0 >= IDENTIFIER && LA21_0 <= ENTITY_REFERENCE || LA21_0 == VARIABLE_NAME
					|| LA21_0 == ESCLAMATION_MARK) {
				alt21 = 1;
			} else if (LA21_0 == DBLQUOTE) {
				alt21 = 2;
			} else {
				if (this.state.backtracking > 0) {
					this.state.failed = true;
					return retval;
				}
				NoViableAltException nvae = new NoViableAltException("", 21, 0, this.input);
				throw nvae;
			}
			switch (alt21) {
			case 1:
				// MOWLParser.g:186:7: atomic
			{
				this.pushFollow(FOLLOW_atomic_in_value1761);
				atomic87 = this.gOPPLParser.atomic();
				this.state._fsp--;
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_atomic.add(atomic87.getTree());
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
					// 186:14: -> ^( atomic )
					{
						// MOWLParser.g:186:17: ^( atomic )
						{
							OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor.nil();
							root_1 = (OPPLSyntaxTree) this.adaptor.becomeRoot(
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
				// MOWLParser.g:187:7: constant
			{
				this.pushFollow(FOLLOW_constant_in_value1776);
				constant88 = this.constant();
				this.state._fsp--;
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_constant.add(constant88.getTree());
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
					root_0 = (OPPLSyntaxTree) this.adaptor.nil();
					// 187:16: -> ^( constant )
					{
						// MOWLParser.g:187:19: ^( constant )
						{
							OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor.nil();
							root_1 = (OPPLSyntaxTree) this.adaptor.becomeRoot(
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
				retval.tree = (OPPLSyntaxTree) this.adaptor.rulePostProcessing(root_0);
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
		OPPLSyntaxTree tree;

		@Override
		public Object getTree() {
			return this.tree;
		}
	};

	// $ANTLR start "constant"
	// MOWLParser.g:190:1: constant : constantValue= DBLQUOTE ( POW type=
	// IDENTIFIER )? -> ^( CONSTANT $constantValue ( $type)? ) ;
	public final OPPLParser_MOWLParser.constant_return constant() throws RecognitionException {
		OPPLParser_MOWLParser.constant_return retval = new OPPLParser_MOWLParser.constant_return();
		retval.start = this.input.LT(1);
		OPPLSyntaxTree root_0 = null;
		Token constantValue = null;
		Token type = null;
		Token POW89 = null;
		OPPLSyntaxTree constantValue_tree = null;
		OPPLSyntaxTree type_tree = null;
		OPPLSyntaxTree POW89_tree = null;
		RewriteRuleTokenStream stream_POW = new RewriteRuleTokenStream(this.adaptor, "token POW");
		RewriteRuleTokenStream stream_IDENTIFIER = new RewriteRuleTokenStream(this.adaptor,
				"token IDENTIFIER");
		RewriteRuleTokenStream stream_DBLQUOTE = new RewriteRuleTokenStream(this.adaptor,
				"token DBLQUOTE");
		try {
			// MOWLParser.g:190:11: (constantValue= DBLQUOTE ( POW type=
			// IDENTIFIER )? -> ^( CONSTANT $constantValue ( $type)? ) )
			// MOWLParser.g:190:14: constantValue= DBLQUOTE ( POW type=
			// IDENTIFIER )?
			{
				constantValue = (Token) this.match(
						this.input,
						DBLQUOTE,
						FOLLOW_DBLQUOTE_in_constant1801);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 0) {
					stream_DBLQUOTE.add(constantValue);
				}
				// MOWLParser.g:190:39: ( POW type= IDENTIFIER )?
				int alt22 = 2;
				int LA22_0 = this.input.LA(1);
				if (LA22_0 == POW) {
					alt22 = 1;
				}
				switch (alt22) {
				case 1:
					// MOWLParser.g:190:41: POW type= IDENTIFIER
				{
					POW89 = (Token) this.match(this.input, POW, FOLLOW_POW_in_constant1805);
					if (this.state.failed) {
						return retval;
					}
					if (this.state.backtracking == 0) {
						stream_POW.add(POW89);
					}
					type = (Token) this.match(
							this.input,
							IDENTIFIER,
							FOLLOW_IDENTIFIER_in_constant1811);
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
					RewriteRuleTokenStream stream_type = new RewriteRuleTokenStream(this.adaptor,
							"token type", type);
					RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(
							this.adaptor, "rule retval", retval != null ? retval.tree : null);
					root_0 = (OPPLSyntaxTree) this.adaptor.nil();
					// 190:65: -> ^( CONSTANT $constantValue ( $type)? )
					{
						// MOWLParser.g:190:67: ^( CONSTANT $constantValue (
						// $type)? )
						{
							OPPLSyntaxTree root_1 = (OPPLSyntaxTree) this.adaptor.nil();
							root_1 = (OPPLSyntaxTree) this.adaptor.becomeRoot(
									this.adaptor.create(CONSTANT, "CONSTANT"),
									root_1);
							this.adaptor.addChild(root_1, stream_constantValue.nextNode());
							// MOWLParser.g:190:93: ( $type)?
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
				retval.tree = (OPPLSyntaxTree) this.adaptor.rulePostProcessing(root_0);
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
	// $ANTLR start synpred1_MOWLParser
	public final void synpred1_MOWLParser_fragment() throws RecognitionException {
		List list_rest = null;
		OPPLParser_MOWLParser.propertyExpression_return head = null;
		RuleReturnScope rest = null;
		// MOWLParser.g:117:4: (head= propertyExpression ( COMPOSITION rest+=
		// propertyExpression )+ )
		// MOWLParser.g:117:4: head= propertyExpression ( COMPOSITION rest+=
		// propertyExpression )+
		{
			this.pushFollow(FOLLOW_propertyExpression_in_synpred1_MOWLParser1121);
			head = this.propertyExpression();
			this.state._fsp--;
			if (this.state.failed) {
				return;
			}
			// MOWLParser.g:117:30: ( COMPOSITION rest+= propertyExpression )+
			int cnt23 = 0;
			loop23: do {
				int alt23 = 2;
				int LA23_0 = this.input.LA(1);
				if (LA23_0 == COMPOSITION) {
					alt23 = 1;
				}
				switch (alt23) {
				case 1:
					// MOWLParser.g:117:31: COMPOSITION rest+=
					// propertyExpression
				{
					this.match(
							this.input,
							COMPOSITION,
							FOLLOW_COMPOSITION_in_synpred1_MOWLParser1124);
					if (this.state.failed) {
						return;
					}
					this.pushFollow(FOLLOW_propertyExpression_in_synpred1_MOWLParser1128);
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
					if (cnt23 >= 1) {
						break loop23;
					}
					if (this.state.backtracking > 0) {
						this.state.failed = true;
						return;
					}
					EarlyExitException eee = new EarlyExitException(23, this.input);
					throw eee;
				}
				cnt23++;
			} while (true);
		}
	}

	// $ANTLR end synpred1_MOWLParser
	// $ANTLR start synpred2_MOWLParser
	public final void synpred2_MOWLParser_fragment() throws RecognitionException {
		// MOWLParser.g:118:6: ( conjunction ( OR conjunction )* )
		// MOWLParser.g:118:6: conjunction ( OR conjunction )*
		{
			this.pushFollow(FOLLOW_conjunction_in_synpred2_MOWLParser1151);
			this.conjunction();
			this.state._fsp--;
			if (this.state.failed) {
				return;
			}
			// MOWLParser.g:118:18: ( OR conjunction )*
			loop24: do {
				int alt24 = 2;
				int LA24_0 = this.input.LA(1);
				if (LA24_0 == OR) {
					alt24 = 1;
				}
				switch (alt24) {
				case 1:
					// MOWLParser.g:118:19: OR conjunction
				{
					this.match(this.input, OR, FOLLOW_OR_in_synpred2_MOWLParser1154);
					if (this.state.failed) {
						return;
					}
					this.pushFollow(FOLLOW_conjunction_in_synpred2_MOWLParser1156);
					this.conjunction();
					this.state._fsp--;
					if (this.state.failed) {
						return;
					}
				}
					break;
				default:
					break loop24;
				}
			} while (true);
		}
	}

	// $ANTLR end synpred2_MOWLParser
	// $ANTLR start synpred3_MOWLParser
	public final void synpred3_MOWLParser_fragment() throws RecognitionException {
		// MOWLParser.g:151:7: ( propertyExpression SOME filler )
		// MOWLParser.g:151:7: propertyExpression SOME filler
		{
			this.pushFollow(FOLLOW_propertyExpression_in_synpred3_MOWLParser1413);
			this.propertyExpression();
			this.state._fsp--;
			if (this.state.failed) {
				return;
			}
			this.match(this.input, SOME, FOLLOW_SOME_in_synpred3_MOWLParser1416);
			if (this.state.failed) {
				return;
			}
			this.pushFollow(FOLLOW_filler_in_synpred3_MOWLParser1420);
			this.filler();
			this.state._fsp--;
			if (this.state.failed) {
				return;
			}
		}
	}

	// $ANTLR end synpred3_MOWLParser
	// $ANTLR start synpred4_MOWLParser
	public final void synpred4_MOWLParser_fragment() throws RecognitionException {
		// MOWLParser.g:152:7: ( propertyExpression ONLY filler )
		// MOWLParser.g:152:7: propertyExpression ONLY filler
		{
			this.pushFollow(FOLLOW_propertyExpression_in_synpred4_MOWLParser1449);
			this.propertyExpression();
			this.state._fsp--;
			if (this.state.failed) {
				return;
			}
			this.match(this.input, ONLY, FOLLOW_ONLY_in_synpred4_MOWLParser1451);
			if (this.state.failed) {
				return;
			}
			this.pushFollow(FOLLOW_filler_in_synpred4_MOWLParser1454);
			this.filler();
			this.state._fsp--;
			if (this.state.failed) {
				return;
			}
		}
	}

	// $ANTLR end synpred4_MOWLParser
	// $ANTLR start synpred5_MOWLParser
	public final void synpred5_MOWLParser_fragment() throws RecognitionException {
		// MOWLParser.g:153:7: ( cardinalityRestriction )
		// MOWLParser.g:153:7: cardinalityRestriction
		{
			this.pushFollow(FOLLOW_cardinalityRestriction_in_synpred5_MOWLParser1473);
			this.cardinalityRestriction();
			this.state._fsp--;
			if (this.state.failed) {
				return;
			}
		}
	}

	// $ANTLR end synpred5_MOWLParser
	// Delegated rules
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

	public final boolean synpred2_MOWLParser() {
		this.state.backtracking++;
		int start = this.input.mark();
		try {
			this.synpred2_MOWLParser_fragment(); // can never throw exception
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

	public final boolean synpred1_MOWLParser() {
		this.state.backtracking++;
		int start = this.input.mark();
		try {
			this.synpred1_MOWLParser_fragment(); // can never throw exception
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

	protected DFA1 dfa1 = new DFA1(this);
	protected DFA3 dfa3 = new DFA3(this);
	protected DFA6 dfa6 = new DFA6(this);
	protected DFA10 dfa10 = new DFA10(this);
	protected DFA13 dfa13 = new DFA13(this);
	protected DFA15 dfa15 = new DFA15(this);
	static final String DFA1_eotS = "\35\uffff";
	static final String DFA1_eofS = "\35\uffff";
	static final String DFA1_minS = "\1\35\3\33\1\64\1\uffff\1\35\2\uffff\1\153\4\33\1\64\1\62\2\33\1"
			+ "\153\1\33\1\70\1\62\2\33\1\63\1\70\1\33\1\63\1\33";
	static final String DFA1_maxS = "\3\151\1\152\1\64\1\uffff\1\151\2\uffff\1\155\3\151\1\152\1\64\1"
			+ "\62\2\151\1\155\1\151\1\70\1\62\2\151\1\63\1\70\1\151\1\63\1\151";
	static final String DFA1_acceptS = "\5\uffff\1\1\1\uffff\1\2\1\3\24\uffff";
	static final String DFA1_specialS = "\35\uffff}>";
	static final String[] DFA1_transitionS = {
			"\1\6\11\uffff\7\7\3\uffff\1\5\2\uffff\1\1\1\2\6\uffff\1\5\3"
					+ "\uffff\1\5\21\uffff\1\3\26\uffff\1\4",
			"\2\10\1\uffff\11\5\7\uffff\3\5\1\10\2\uffff\2\10\2\5\1\uffff"
					+ "\3\5\3\uffff\1\5\22\uffff\1\10\26\uffff\1\10",
			"\2\10\1\uffff\11\5\7\uffff\3\5\1\10\2\uffff\2\10\2\5\1\uffff"
					+ "\3\5\3\uffff\1\5\22\uffff\1\10\26\uffff\1\10",
			"\2\10\1\uffff\11\5\7\uffff\3\5\1\10\2\uffff\2\10\2\5\1\uffff"
					+ "\3\5\3\uffff\1\5\22\uffff\1\10\26\uffff\1\10\1\11",
			"\1\12",
			"",
			"\1\10\24\uffff\1\5\1\uffff\1\13\1\14\34\uffff\1\15\26\uffff" + "\1\16",
			"",
			"",
			"\1\20\1\21\1\17",
			"\2\10\1\uffff\11\5\7\uffff\3\5\1\10\2\uffff\2\10\2\5\1\uffff"
					+ "\3\5\3\uffff\1\5\22\uffff\1\10\26\uffff\1\10",
			"\2\10\1\uffff\4\5\15\uffff\2\5\1\10\2\uffff\2\10\34\uffff\1" + "\10\26\uffff\1\10",
			"\2\10\1\uffff\4\5\15\uffff\2\5\1\10\2\uffff\2\10\34\uffff\1" + "\10\26\uffff\1\10",
			"\2\10\1\uffff\4\5\15\uffff\2\5\1\10\2\uffff\2\10\34\uffff\1"
					+ "\10\26\uffff\1\10\1\22",
			"\1\23",
			"\1\24",
			"\2\10\1\uffff\11\5\7\uffff\3\5\1\10\2\uffff\2\10\2\5\1\uffff"
					+ "\3\5\3\uffff\1\5\22\uffff\1\10\26\uffff\1\10",
			"\2\10\1\uffff\11\5\7\uffff\3\5\1\10\2\uffff\2\10\2\5\1\uffff"
					+ "\3\5\3\uffff\1\5\22\uffff\1\10\26\uffff\1\10",
			"\1\26\1\27\1\25",
			"\2\10\1\uffff\4\5\15\uffff\2\5\1\10\2\uffff\2\10\34\uffff\1" + "\10\26\uffff\1\10",
			"\1\30",
			"\1\31",
			"\2\10\1\uffff\4\5\15\uffff\2\5\1\10\2\uffff\2\10\34\uffff\1" + "\10\26\uffff\1\10",
			"\2\10\1\uffff\4\5\15\uffff\2\5\1\10\2\uffff\2\10\34\uffff\1" + "\10\26\uffff\1\10",
			"\1\32",
			"\1\33",
			"\2\10\1\uffff\11\5\7\uffff\3\5\1\10\2\uffff\2\10\2\5\1\uffff"
					+ "\3\5\3\uffff\1\5\22\uffff\1\10\26\uffff\1\10", "\1\34",
			"\2\10\1\uffff\4\5\15\uffff\2\5\1\10\2\uffff\2\10\34\uffff\1" + "\10\26\uffff\1\10" };
	static final short[] DFA1_eot = DFA.unpackEncodedString(DFA1_eotS);
	static final short[] DFA1_eof = DFA.unpackEncodedString(DFA1_eofS);
	static final char[] DFA1_min = DFA.unpackEncodedStringToUnsignedChars(DFA1_minS);
	static final char[] DFA1_max = DFA.unpackEncodedStringToUnsignedChars(DFA1_maxS);
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
			return "63:1: axiom : ( binaryAxiom -> ^( binaryAxiom ) | unaryAxiom -> ^( unaryAxiom ) | assertionAxiom -> ^( assertionAxiom ) );";
		}
	}

	static final String DFA3_eotS = "\20\uffff";
	static final String DFA3_eofS = "\20\uffff";
	static final String DFA3_minS = "\1\35\3\33\1\64\3\uffff\1\153\1\33\1\62\2\33\1\70\1\63\1\33";
	static final String DFA3_maxS = "\3\151\1\152\1\64\3\uffff\1\155\1\151\1\62\2\151\1\70\1\63\1\151";
	static final String DFA3_acceptS = "\5\uffff\1\3\1\1\1\2\10\uffff";
	static final String DFA3_specialS = "\20\uffff}>";
	static final String[] DFA3_transitionS = { "\1\5\26\uffff\1\1\1\2\34\uffff\1\3\26\uffff\1\4",
			"\2\6\24\uffff\1\7\2\uffff\2\7\34\uffff\1\7\26\uffff\1\7",
			"\2\6\24\uffff\1\7\2\uffff\2\7\34\uffff\1\7\26\uffff\1\7",
			"\2\6\24\uffff\1\7\2\uffff\2\7\34\uffff\1\7\26\uffff\1\7\1\10", "\1\11", "", "", "",
			"\1\13\1\14\1\12", "\2\6\24\uffff\1\7\2\uffff\2\7\34\uffff\1\7\26\uffff\1\7", "\1\15",
			"\2\6\24\uffff\1\7\2\uffff\2\7\34\uffff\1\7\26\uffff\1\7",
			"\2\6\24\uffff\1\7\2\uffff\2\7\34\uffff\1\7\26\uffff\1\7", "\1\16", "\1\17",
			"\2\6\24\uffff\1\7\2\uffff\2\7\34\uffff\1\7\26\uffff\1\7" };
	static final short[] DFA3_eot = DFA.unpackEncodedString(DFA3_eotS);
	static final short[] DFA3_eof = DFA.unpackEncodedString(DFA3_eofS);
	static final char[] DFA3_min = DFA.unpackEncodedStringToUnsignedChars(DFA3_minS);
	static final char[] DFA3_max = DFA.unpackEncodedStringToUnsignedChars(DFA3_maxS);
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
			return "71:1: assertionAxiom : (i= atomic ( INSTANCE_OF | TYPES ) expression -> ^( TYPE_ASSERTION ^( EXPRESSION expression ) ^( EXPRESSION $i) ) | atomic propertyExpression value -> ^( ROLE_ASSERTION ^( EXPRESSION atomic ) ^( EXPRESSION propertyExpression ) ^( EXPRESSION value ) ) | NOT assertionAxiom -> ^( NEGATED_ASSERTION assertionAxiom ) );";
		}
	}

	static final String DFA6_eotS = "\17\uffff";
	static final String DFA6_eofS = "\17\uffff";
	static final String DFA6_minS = "\1\35\3\36\1\64\2\uffff\1\153\1\36\1\62\2\36\1\70\1\63\1\36";
	static final String DFA6_maxS = "\1\151\2\77\1\152\1\64\2\uffff\1\155\1\77\1\62\2\77\1\70\1\63\1"
			+ "\77";
	static final String DFA6_acceptS = "\5\uffff\1\1\1\2\10\uffff";
	static final String DFA6_specialS = "\17\uffff}>";
	static final String[] DFA6_transitionS = {
			"\1\5\23\uffff\1\5\2\uffff\1\1\1\2\6\uffff\1\5\3\uffff\1\5\21"
					+ "\uffff\1\3\26\uffff\1\4",
			"\4\5\5\6\7\uffff\3\5\5\uffff\2\5\1\uffff\3\5\3\uffff\1\5",
			"\4\5\5\6\7\uffff\3\5\5\uffff\2\5\1\uffff\3\5\3\uffff\1\5",
			"\4\5\5\6\7\uffff\3\5\5\uffff\2\5\1\uffff\3\5\3\uffff\1\5\52" + "\uffff\1\7", "\1\10",
			"", "", "\1\12\1\13\1\11", "\4\5\5\6\7\uffff\3\5\5\uffff\2\5\1\uffff\3\5\3\uffff\1\5",
			"\1\14", "\4\5\5\6\7\uffff\3\5\5\uffff\2\5\1\uffff\3\5\3\uffff\1\5",
			"\4\5\5\6\7\uffff\3\5\5\uffff\2\5\1\uffff\3\5\3\uffff\1\5", "\1\15", "\1\16",
			"\4\5\5\6\7\uffff\3\5\5\uffff\2\5\1\uffff\3\5\3\uffff\1\5" };
	static final short[] DFA6_eot = DFA.unpackEncodedString(DFA6_eotS);
	static final short[] DFA6_eof = DFA.unpackEncodedString(DFA6_eofS);
	static final char[] DFA6_min = DFA.unpackEncodedStringToUnsignedChars(DFA6_minS);
	static final char[] DFA6_max = DFA.unpackEncodedStringToUnsignedChars(DFA6_maxS);
	static final short[] DFA6_accept = DFA.unpackEncodedString(DFA6_acceptS);
	static final short[] DFA6_special = DFA.unpackEncodedString(DFA6_specialS);
	static final short[][] DFA6_transition;
	static {
		int numStates = DFA6_transitionS.length;
		DFA6_transition = new short[numStates][];
		for (int i = 0; i < numStates; i++) {
			DFA6_transition[i] = DFA.unpackEncodedString(DFA6_transitionS[i]);
		}
	}

	class DFA6 extends DFA {
		public DFA6(BaseRecognizer recognizer) {
			this.recognizer = recognizer;
			this.decisionNumber = 6;
			this.eot = DFA6_eot;
			this.eof = DFA6_eof;
			this.min = DFA6_min;
			this.max = DFA6_max;
			this.accept = DFA6_accept;
			this.special = DFA6_special;
			this.transition = DFA6_transition;
		}

		@Override
		public String getDescription() {
			return "80:1: binaryAxiom : (lhs= expression ( SUBCLASS_OF superClass= expression -> ^( SUB_CLASS_AXIOM ^( EXPRESSION $lhs) ^( EXPRESSION $superClass) ) | EQUIVALENT_TO rhs= expression -> ^( EQUIVALENT_TO_AXIOM ^( EXPRESSION $lhs) ^( EXPRESSION $rhs) ) | DISJOINT_WITH disjoint= expression -> ^( DISJOINT_WITH_AXIOM ^( EXPRESSION $lhs) ^( EXPRESSION $disjoint) ) | SUB_PROPERTY_OF superProperty= propertyExpression -> ^( SUB_PROPERTY_AXIOM ^( EXPRESSION $lhs) ^( EXPRESSION $superProperty) ) ) | lhsID= atomic ( SAME_AS rhsID= atomic -> ^( SAME_AS_AXIOM ^( EXPRESSION $lhsID) ^( EXPRESSION $rhsID) ) | DIFFERENT_FROM rhsID= atomic -> ^( DIFFERENT_FROM_AXIOM ^( EXPRESSION $lhsID) ^( EXPRESSION $rhsID) ) | DOMAIN expression -> ^( DOMAIN ^( EXPRESSION $lhsID) ^( EXPRESSION expression ) ) | RANGE expression -> ^( RANGE ^( EXPRESSION $lhsID) ^( EXPRESSION expression ) ) | INVERSE_OF rhsID= atomic -> ^( INVERSE_OF ^( EXPRESSION $lhsID) ^( EXPRESSION $rhsID) ) ) );";
		}
	}

	static final String DFA10_eotS = "\13\uffff";
	static final String DFA10_eofS = "\13\uffff";
	static final String DFA10_minS = "\1\35\5\0\5\uffff";
	static final String DFA10_maxS = "\1\151\5\0\5\uffff";
	static final String DFA10_acceptS = "\6\uffff\1\2\2\uffff\1\1\1\3";
	static final String DFA10_specialS = "\1\uffff\1\0\1\1\1\2\1\3\1\4\5\uffff}>";
	static final String[] DFA10_transitionS = {
			"\1\6\23\uffff\1\5\2\uffff\1\1\1\2\6\uffff\1\6\3\uffff\1\6\21"
					+ "\uffff\1\3\26\uffff\1\4", "\1\uffff", "\1\uffff", "\1\uffff", "\1\uffff",
			"\1\uffff", "", "", "", "", "" };
	static final short[] DFA10_eot = DFA.unpackEncodedString(DFA10_eotS);
	static final short[] DFA10_eof = DFA.unpackEncodedString(DFA10_eofS);
	static final char[] DFA10_min = DFA.unpackEncodedStringToUnsignedChars(DFA10_minS);
	static final char[] DFA10_max = DFA.unpackEncodedStringToUnsignedChars(DFA10_maxS);
	static final short[] DFA10_accept = DFA.unpackEncodedString(DFA10_acceptS);
	static final short[] DFA10_special = DFA.unpackEncodedString(DFA10_specialS);
	static final short[][] DFA10_transition;
	static {
		int numStates = DFA10_transitionS.length;
		DFA10_transition = new short[numStates][];
		for (int i = 0; i < numStates; i++) {
			DFA10_transition[i] = DFA.unpackEncodedString(DFA10_transitionS[i]);
		}
	}

	class DFA10 extends DFA {
		public DFA10(BaseRecognizer recognizer) {
			this.recognizer = recognizer;
			this.decisionNumber = 10;
			this.eot = DFA10_eot;
			this.eof = DFA10_eof;
			this.min = DFA10_min;
			this.max = DFA10_max;
			this.accept = DFA10_accept;
			this.special = DFA10_special;
			this.transition = DFA10_transition;
		}

		@Override
		public String getDescription() {
			return "115:5: ( options {backtrack=true; } : head= propertyExpression ( COMPOSITION rest+= propertyExpression )+ -> ^( PROPERTY_CHAIN $head $rest) | conjunction ( OR conjunction )* -> ^( DISJUNCTION ( conjunction )+ ) | complexPropertyExpression -> ^( complexPropertyExpression ) )";
		}

		@Override
		public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
			TokenStream input = (TokenStream) _input;
			int _s = s;
			switch (s) {
			case 0:
				int LA10_1 = input.LA(1);
				int index10_1 = input.index();
				input.rewind();
				s = -1;
				if (OPPLParser_MOWLParser.this.synpred1_MOWLParser()) {
					s = 9;
				} else if (OPPLParser_MOWLParser.this.synpred2_MOWLParser()) {
					s = 6;
				}
				input.seek(index10_1);
				if (s >= 0) {
					return s;
				}
				break;
			case 1:
				int LA10_2 = input.LA(1);
				int index10_2 = input.index();
				input.rewind();
				s = -1;
				if (OPPLParser_MOWLParser.this.synpred1_MOWLParser()) {
					s = 9;
				} else if (OPPLParser_MOWLParser.this.synpred2_MOWLParser()) {
					s = 6;
				}
				input.seek(index10_2);
				if (s >= 0) {
					return s;
				}
				break;
			case 2:
				int LA10_3 = input.LA(1);
				int index10_3 = input.index();
				input.rewind();
				s = -1;
				if (OPPLParser_MOWLParser.this.synpred1_MOWLParser()) {
					s = 9;
				} else if (OPPLParser_MOWLParser.this.synpred2_MOWLParser()) {
					s = 6;
				}
				input.seek(index10_3);
				if (s >= 0) {
					return s;
				}
				break;
			case 3:
				int LA10_4 = input.LA(1);
				int index10_4 = input.index();
				input.rewind();
				s = -1;
				if (OPPLParser_MOWLParser.this.synpred1_MOWLParser()) {
					s = 9;
				} else if (OPPLParser_MOWLParser.this.synpred2_MOWLParser()) {
					s = 6;
				}
				input.seek(index10_4);
				if (s >= 0) {
					return s;
				}
				break;
			case 4:
				int LA10_5 = input.LA(1);
				int index10_5 = input.index();
				input.rewind();
				s = -1;
				if (OPPLParser_MOWLParser.this.synpred1_MOWLParser()) {
					s = 9;
				} else if (OPPLParser_MOWLParser.this.synpred2_MOWLParser()) {
					s = 6;
				} else if (true) {
					s = 10;
				}
				input.seek(index10_5);
				if (s >= 0) {
					return s;
				}
				break;
			}
			if (OPPLParser_MOWLParser.this.state.backtracking > 0) {
				OPPLParser_MOWLParser.this.state.failed = true;
				return -1;
			}
			NoViableAltException nvae = new NoViableAltException(this.getDescription(), 10, _s,
					input);
			this.error(nvae);
			throw nvae;
		}
	}

	static final String DFA13_eotS = "\23\uffff";
	static final String DFA13_eofS = "\1\uffff\3\10\6\uffff\1\10\3\uffff\2\10\2\uffff\1\10";
	static final String DFA13_minS = "\1\35\3\36\1\64\1\62\3\uffff\1\153\1\36\2\uffff\1\62\2\36\1\70\1"
			+ "\63\1\36";
	static final String DFA13_maxS = "\1\151\2\142\1\152\1\64\1\151\3\uffff\1\155\1\142\2\uffff\1\62\2"
			+ "\142\1\70\1\63\1\142";
	static final String DFA13_acceptS = "\6\uffff\1\4\1\5\1\1\2\uffff\1\2\1\3\6\uffff";
	static final String DFA13_specialS = "\23\uffff}>";
	static final String[] DFA13_transitionS = {
			"\1\5\23\uffff\1\6\2\uffff\1\1\1\2\6\uffff\1\6\3\uffff\1\7\21"
					+ "\uffff\1\3\26\uffff\1\4",
			"\4\10\15\uffff\2\10\2\uffff\1\10\2\uffff\2\6\1\uffff\3\6\1"
					+ "\uffff\1\10\1\uffff\1\6\33\uffff\1\10\1\uffff\1\10\4\uffff\1" + "\10",
			"\4\10\15\uffff\2\10\2\uffff\1\10\2\uffff\2\6\1\uffff\3\6\1"
					+ "\uffff\1\10\1\uffff\1\6\33\uffff\1\10\1\uffff\1\10\4\uffff\1" + "\10",
			"\4\10\15\uffff\2\10\2\uffff\1\10\2\uffff\2\6\1\uffff\3\6\1"
					+ "\uffff\1\10\1\uffff\1\6\33\uffff\1\10\1\uffff\1\10\4\uffff\1"
					+ "\10\7\uffff\1\11",
			"\1\12",
			"\1\13\1\uffff\2\14\34\uffff\1\14\26\uffff\1\14",
			"",
			"",
			"",
			"\1\16\1\17\1\15",
			"\4\10\15\uffff\2\10\2\uffff\1\10\2\uffff\2\6\1\uffff\3\6\1"
					+ "\uffff\1\10\1\uffff\1\6\33\uffff\1\10\1\uffff\1\10\4\uffff\1" + "\10",
			"",
			"",
			"\1\20",
			"\4\10\15\uffff\2\10\2\uffff\1\10\2\uffff\2\6\1\uffff\3\6\1"
					+ "\uffff\1\10\1\uffff\1\6\33\uffff\1\10\1\uffff\1\10\4\uffff\1" + "\10",
			"\4\10\15\uffff\2\10\2\uffff\1\10\2\uffff\2\6\1\uffff\3\6\1"
					+ "\uffff\1\10\1\uffff\1\6\33\uffff\1\10\1\uffff\1\10\4\uffff\1" + "\10",
			"\1\21",
			"\1\22",
			"\4\10\15\uffff\2\10\2\uffff\1\10\2\uffff\2\6\1\uffff\3\6\1"
					+ "\uffff\1\10\1\uffff\1\6\33\uffff\1\10\1\uffff\1\10\4\uffff\1" + "\10" };
	static final short[] DFA13_eot = DFA.unpackEncodedString(DFA13_eotS);
	static final short[] DFA13_eof = DFA.unpackEncodedString(DFA13_eofS);
	static final char[] DFA13_min = DFA.unpackEncodedStringToUnsignedChars(DFA13_minS);
	static final char[] DFA13_max = DFA.unpackEncodedStringToUnsignedChars(DFA13_maxS);
	static final short[] DFA13_accept = DFA.unpackEncodedString(DFA13_acceptS);
	static final short[] DFA13_special = DFA.unpackEncodedString(DFA13_specialS);
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
			return "135:1: unary : ( atomic | NOT OPEN_PARENTHESYS expression CLOSED_PARENTHESYS -> ^( NEGATED_EXPRESSION expression ) | NOT atomic -> ^( NEGATED_EXPRESSION atomic ) | qualifiedRestriction -> ^( qualifiedRestriction ) | constant );";
		}
	}

	static final String DFA15_eotS = "\13\uffff";
	static final String DFA15_eofS = "\13\uffff";
	static final String DFA15_minS = "\1\61\5\0\5\uffff";
	static final String DFA15_maxS = "\1\151\5\0\5\uffff";
	static final String DFA15_acceptS = "\6\uffff\1\4\1\1\1\2\1\3\1\5";
	static final String DFA15_specialS = "\1\uffff\1\0\1\1\1\2\1\3\1\4\5\uffff}>";
	static final String[] DFA15_transitionS = {
			"\1\5\2\uffff\1\1\1\2\6\uffff\1\6\25\uffff\1\3\26\uffff\1\4", "\1\uffff", "\1\uffff",
			"\1\uffff", "\1\uffff", "\1\uffff", "", "", "", "", "" };
	static final short[] DFA15_eot = DFA.unpackEncodedString(DFA15_eotS);
	static final short[] DFA15_eof = DFA.unpackEncodedString(DFA15_eofS);
	static final char[] DFA15_min = DFA.unpackEncodedStringToUnsignedChars(DFA15_minS);
	static final char[] DFA15_max = DFA.unpackEncodedStringToUnsignedChars(DFA15_maxS);
	static final short[] DFA15_accept = DFA.unpackEncodedString(DFA15_acceptS);
	static final short[] DFA15_special = DFA.unpackEncodedString(DFA15_specialS);
	static final short[][] DFA15_transition;
	static {
		int numStates = DFA15_transitionS.length;
		DFA15_transition = new short[numStates][];
		for (int i = 0; i < numStates; i++) {
			DFA15_transition[i] = DFA.unpackEncodedString(DFA15_transitionS[i]);
		}
	}

	class DFA15 extends DFA {
		public DFA15(BaseRecognizer recognizer) {
			this.recognizer = recognizer;
			this.decisionNumber = 15;
			this.eot = DFA15_eot;
			this.eof = DFA15_eof;
			this.min = DFA15_min;
			this.max = DFA15_max;
			this.accept = DFA15_accept;
			this.special = DFA15_special;
			this.transition = DFA15_transition;
		}

		@Override
		public String getDescription() {
			return "149:9: ( options {backtrack=true; } : propertyExpression SOME filler -> ^( SOME_RESTRICTION propertyExpression filler ) | propertyExpression ONLY filler -> ^( ALL_RESTRICTION propertyExpression filler ) | cardinalityRestriction -> ^( cardinalityRestriction ) | oneOf -> ^( oneOf ) | valueRestriction -> ^( valueRestriction ) )";
		}

		@Override
		public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
			TokenStream input = (TokenStream) _input;
			int _s = s;
			switch (s) {
			case 0:
				int LA15_1 = input.LA(1);
				int index15_1 = input.index();
				input.rewind();
				s = -1;
				if (OPPLParser_MOWLParser.this.synpred3_MOWLParser()) {
					s = 7;
				} else if (OPPLParser_MOWLParser.this.synpred4_MOWLParser()) {
					s = 8;
				} else if (OPPLParser_MOWLParser.this.synpred5_MOWLParser()) {
					s = 9;
				} else if (true) {
					s = 10;
				}
				input.seek(index15_1);
				if (s >= 0) {
					return s;
				}
				break;
			case 1:
				int LA15_2 = input.LA(1);
				int index15_2 = input.index();
				input.rewind();
				s = -1;
				if (OPPLParser_MOWLParser.this.synpred3_MOWLParser()) {
					s = 7;
				} else if (OPPLParser_MOWLParser.this.synpred4_MOWLParser()) {
					s = 8;
				} else if (OPPLParser_MOWLParser.this.synpred5_MOWLParser()) {
					s = 9;
				} else if (true) {
					s = 10;
				}
				input.seek(index15_2);
				if (s >= 0) {
					return s;
				}
				break;
			case 2:
				int LA15_3 = input.LA(1);
				int index15_3 = input.index();
				input.rewind();
				s = -1;
				if (OPPLParser_MOWLParser.this.synpred3_MOWLParser()) {
					s = 7;
				} else if (OPPLParser_MOWLParser.this.synpred4_MOWLParser()) {
					s = 8;
				} else if (OPPLParser_MOWLParser.this.synpred5_MOWLParser()) {
					s = 9;
				} else if (true) {
					s = 10;
				}
				input.seek(index15_3);
				if (s >= 0) {
					return s;
				}
				break;
			case 3:
				int LA15_4 = input.LA(1);
				int index15_4 = input.index();
				input.rewind();
				s = -1;
				if (OPPLParser_MOWLParser.this.synpred3_MOWLParser()) {
					s = 7;
				} else if (OPPLParser_MOWLParser.this.synpred4_MOWLParser()) {
					s = 8;
				} else if (OPPLParser_MOWLParser.this.synpred5_MOWLParser()) {
					s = 9;
				} else if (true) {
					s = 10;
				}
				input.seek(index15_4);
				if (s >= 0) {
					return s;
				}
				break;
			case 4:
				int LA15_5 = input.LA(1);
				int index15_5 = input.index();
				input.rewind();
				s = -1;
				if (OPPLParser_MOWLParser.this.synpred3_MOWLParser()) {
					s = 7;
				} else if (OPPLParser_MOWLParser.this.synpred4_MOWLParser()) {
					s = 8;
				} else if (OPPLParser_MOWLParser.this.synpred5_MOWLParser()) {
					s = 9;
				} else if (true) {
					s = 10;
				}
				input.seek(index15_5);
				if (s >= 0) {
					return s;
				}
				break;
			}
			if (OPPLParser_MOWLParser.this.state.backtracking > 0) {
				OPPLParser_MOWLParser.this.state.failed = true;
				return -1;
			}
			NoViableAltException nvae = new NoViableAltException(this.getDescription(), 15, _s,
					input);
			this.error(nvae);
			throw nvae;
		}
	}

	public static final BitSet FOLLOW_binaryAxiom_in_axiom220 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_unaryAxiom_in_axiom232 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_assertionAxiom_in_axiom244 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_atomic_in_assertionAxiom267 = new BitSet(
			new long[] { 0x0000000018000000L });
	public static final BitSet FOLLOW_INSTANCE_OF_in_assertionAxiom270 = new BitSet(new long[] {
			0x1032000020000000L, 0x0000020000040001L });
	public static final BitSet FOLLOW_TYPES_in_assertionAxiom274 = new BitSet(new long[] {
			0x1032000020000000L, 0x0000020000040001L });
	public static final BitSet FOLLOW_expression_in_assertionAxiom277 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_atomic_in_assertionAxiom303 = new BitSet(new long[] {
			0x0032000000000000L, 0x0000020000040000L });
	public static final BitSet FOLLOW_propertyExpression_in_assertionAxiom305 = new BitSet(
			new long[] { 0x1032000020000000L, 0x0000020000040001L });
	public static final BitSet FOLLOW_value_in_assertionAxiom308 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_NOT_in_assertionAxiom341 = new BitSet(new long[] {
			0x0030000020000000L, 0x0000020000040000L });
	public static final BitSet FOLLOW_assertionAxiom_in_assertionAxiom343 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_expression_in_binaryAxiom371 = new BitSet(
			new long[] { 0x00000003C0000000L });
	public static final BitSet FOLLOW_SUBCLASS_OF_in_binaryAxiom426 = new BitSet(new long[] {
			0x1032000020000000L, 0x0000020000040001L });
	public static final BitSet FOLLOW_expression_in_binaryAxiom433 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_EQUIVALENT_TO_in_binaryAxiom474 = new BitSet(new long[] {
			0x1032000020000000L, 0x0000020000040001L });
	public static final BitSet FOLLOW_expression_in_binaryAxiom480 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_DISJOINT_WITH_in_binaryAxiom520 = new BitSet(new long[] {
			0x1032000020000000L, 0x0000020000040001L });
	public static final BitSet FOLLOW_expression_in_binaryAxiom526 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_SUB_PROPERTY_OF_in_binaryAxiom566 = new BitSet(new long[] {
			0x0032000000000000L, 0x0000020000040000L });
	public static final BitSet FOLLOW_propertyExpression_in_binaryAxiom572 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_atomic_in_binaryAxiom642 = new BitSet(
			new long[] { 0x0000007C00000000L });
	public static final BitSet FOLLOW_SAME_AS_in_binaryAxiom667 = new BitSet(new long[] {
			0x0030000000000000L, 0x0000020000040000L });
	public static final BitSet FOLLOW_atomic_in_binaryAxiom674 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_DIFFERENT_FROM_in_binaryAxiom717 = new BitSet(new long[] {
			0x0030000000000000L, 0x0000020000040000L });
	public static final BitSet FOLLOW_atomic_in_binaryAxiom724 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_DOMAIN_in_binaryAxiom766 = new BitSet(new long[] {
			0x1032000020000000L, 0x0000020000040001L });
	public static final BitSet FOLLOW_expression_in_binaryAxiom768 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_RANGE_in_binaryAxiom809 = new BitSet(new long[] {
			0x1032000020000000L, 0x0000020000040001L });
	public static final BitSet FOLLOW_expression_in_binaryAxiom811 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_INVERSE_OF_in_binaryAxiom852 = new BitSet(new long[] {
			0x0030000000000000L, 0x0000020000040000L });
	public static final BitSet FOLLOW_atomic_in_binaryAxiom858 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_unaryCharacteristic_in_unaryAxiom943 = new BitSet(new long[] {
			0x0030000000000000L, 0x0000020000040000L });
	public static final BitSet FOLLOW_atomic_in_unaryAxiom947 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_FUNCTIONAL_in_unaryCharacteristic992 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_INVERSE_FUNCTIONAL_in_unaryCharacteristic1006 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_SYMMETRIC_in_unaryCharacteristic1020 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_ANTI_SYMMETRIC_in_unaryCharacteristic1034 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_REFLEXIVE_in_unaryCharacteristic1048 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_IRREFLEXIVE_in_unaryCharacteristic1062 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_TRANSITIVE_in_unaryCharacteristic1076 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_propertyExpression_in_expression1121 = new BitSet(
			new long[] { 0x0000400000000000L });
	public static final BitSet FOLLOW_COMPOSITION_in_expression1124 = new BitSet(new long[] {
			0x0032000000000000L, 0x0000020000040000L });
	public static final BitSet FOLLOW_propertyExpression_in_expression1128 = new BitSet(
			new long[] { 0x0000400000000002L });
	public static final BitSet FOLLOW_conjunction_in_expression1151 = new BitSet(
			new long[] { 0x0000800000000002L });
	public static final BitSet FOLLOW_OR_in_expression1154 = new BitSet(new long[] {
			0x1032000020000000L, 0x0000020000040001L });
	public static final BitSet FOLLOW_conjunction_in_expression1156 = new BitSet(
			new long[] { 0x0000800000000002L });
	public static final BitSet FOLLOW_complexPropertyExpression_in_expression1175 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_unary_in_conjunction1207 = new BitSet(
			new long[] { 0x0001000000000002L });
	public static final BitSet FOLLOW_AND_in_conjunction1210 = new BitSet(new long[] {
			0x1032000020000000L, 0x0000020000040001L });
	public static final BitSet FOLLOW_unary_in_conjunction1212 = new BitSet(
			new long[] { 0x0001000000000002L });
	public static final BitSet FOLLOW_INVERSE_in_complexPropertyExpression1233 = new BitSet(
			new long[] { 0x0004000000000000L });
	public static final BitSet FOLLOW_OPEN_PARENTHESYS_in_complexPropertyExpression1235 = new BitSet(
			new long[] { 0x0032000000000000L, 0x0000020000040000L });
	public static final BitSet FOLLOW_complexPropertyExpression_in_complexPropertyExpression1237 = new BitSet(
			new long[] { 0x0008000000000000L });
	public static final BitSet FOLLOW_CLOSED_PARENTHESYS_in_complexPropertyExpression1239 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_INVERSE_in_complexPropertyExpression1252 = new BitSet(
			new long[] { 0x0004000000000000L });
	public static final BitSet FOLLOW_OPEN_PARENTHESYS_in_complexPropertyExpression1254 = new BitSet(
			new long[] { 0x0010000000000000L });
	public static final BitSet FOLLOW_IDENTIFIER_in_complexPropertyExpression1256 = new BitSet(
			new long[] { 0x0008000000000000L });
	public static final BitSet FOLLOW_CLOSED_PARENTHESYS_in_complexPropertyExpression1258 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_atomic_in_unary1278 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_NOT_in_unary1284 = new BitSet(
			new long[] { 0x0004000000000000L });
	public static final BitSet FOLLOW_OPEN_PARENTHESYS_in_unary1286 = new BitSet(new long[] {
			0x1032000020000000L, 0x0000020000040001L });
	public static final BitSet FOLLOW_expression_in_unary1288 = new BitSet(
			new long[] { 0x0008000000000000L });
	public static final BitSet FOLLOW_CLOSED_PARENTHESYS_in_unary1290 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_NOT_in_unary1304 = new BitSet(new long[] {
			0x0030000000000000L, 0x0000020000040000L });
	public static final BitSet FOLLOW_atomic_in_unary1306 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_qualifiedRestriction_in_unary1327 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_constant_in_unary1339 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_propertyExpression_in_qualifiedRestriction1413 = new BitSet(
			new long[] { 0x0040000000000000L });
	public static final BitSet FOLLOW_SOME_in_qualifiedRestriction1416 = new BitSet(new long[] {
			0x0034000000000000L, 0x0000020000040000L });
	public static final BitSet FOLLOW_filler_in_qualifiedRestriction1420 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_propertyExpression_in_qualifiedRestriction1449 = new BitSet(
			new long[] { 0x0080000000000000L });
	public static final BitSet FOLLOW_ONLY_in_qualifiedRestriction1451 = new BitSet(new long[] {
			0x0034000000000000L, 0x0000020000040000L });
	public static final BitSet FOLLOW_filler_in_qualifiedRestriction1454 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_cardinalityRestriction_in_qualifiedRestriction1473 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_oneOf_in_qualifiedRestriction1487 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_valueRestriction_in_qualifiedRestriction1501 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_atomic_in_propertyExpression1533 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_complexPropertyExpression_in_propertyExpression1547 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_propertyExpression_in_cardinalityRestriction1573 = new BitSet(
			new long[] { 0x0E00000000000000L });
	public static final BitSet FOLLOW_restrictionKind_in_cardinalityRestriction1576 = new BitSet(
			new long[] { 0x0100000000000000L });
	public static final BitSet FOLLOW_INTEGER_in_cardinalityRestriction1578 = new BitSet(
			new long[] { 0x0034000000000002L, 0x0000020000040000L });
	public static final BitSet FOLLOW_filler_in_cardinalityRestriction1580 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_MIN_in_restrictionKind1615 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_MAX_in_restrictionKind1629 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_EXACTLY_in_restrictionKind1643 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_atomic_in_filler1665 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_OPEN_PARENTHESYS_in_filler1679 = new BitSet(new long[] {
			0x1032000020000000L, 0x0000020000040001L });
	public static final BitSet FOLLOW_expression_in_filler1681 = new BitSet(
			new long[] { 0x0008000000000000L });
	public static final BitSet FOLLOW_CLOSED_PARENTHESYS_in_filler1683 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_OPEN_CURLY_BRACES_in_oneOf1701 = new BitSet(new long[] {
			0x0030000000000000L, 0x0000020000040000L });
	public static final BitSet FOLLOW_atomic_in_oneOf1703 = new BitSet(
			new long[] { 0x6000000000000000L });
	public static final BitSet FOLLOW_COMMA_in_oneOf1706 = new BitSet(new long[] {
			0x0030000000000000L, 0x0000020000040000L });
	public static final BitSet FOLLOW_atomic_in_oneOf1708 = new BitSet(
			new long[] { 0x6000000000000000L });
	public static final BitSet FOLLOW_CLOSED_CURLY_BRACES_in_oneOf1712 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_propertyExpression_in_valueRestriction1732 = new BitSet(
			new long[] { 0x8000000000000000L });
	public static final BitSet FOLLOW_VALUE_in_valueRestriction1734 = new BitSet(new long[] {
			0x1032000020000000L, 0x0000020000040001L });
	public static final BitSet FOLLOW_value_in_valueRestriction1736 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_atomic_in_value1761 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_constant_in_value1776 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_DBLQUOTE_in_constant1801 = new BitSet(new long[] {
			0x0000000000000002L, 0x0000000000000002L });
	public static final BitSet FOLLOW_POW_in_constant1805 = new BitSet(
			new long[] { 0x0010000000000000L });
	public static final BitSet FOLLOW_IDENTIFIER_in_constant1811 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_propertyExpression_in_synpred1_MOWLParser1121 = new BitSet(
			new long[] { 0x0000400000000000L });
	public static final BitSet FOLLOW_COMPOSITION_in_synpred1_MOWLParser1124 = new BitSet(
			new long[] { 0x0032000000000000L, 0x0000020000040000L });
	public static final BitSet FOLLOW_propertyExpression_in_synpred1_MOWLParser1128 = new BitSet(
			new long[] { 0x0000400000000002L });
	public static final BitSet FOLLOW_conjunction_in_synpred2_MOWLParser1151 = new BitSet(
			new long[] { 0x0000800000000002L });
	public static final BitSet FOLLOW_OR_in_synpred2_MOWLParser1154 = new BitSet(new long[] {
			0x1032000020000000L, 0x0000020000040001L });
	public static final BitSet FOLLOW_conjunction_in_synpred2_MOWLParser1156 = new BitSet(
			new long[] { 0x0000800000000002L });
	public static final BitSet FOLLOW_propertyExpression_in_synpred3_MOWLParser1413 = new BitSet(
			new long[] { 0x0040000000000000L });
	public static final BitSet FOLLOW_SOME_in_synpred3_MOWLParser1416 = new BitSet(new long[] {
			0x0034000000000000L, 0x0000020000040000L });
	public static final BitSet FOLLOW_filler_in_synpred3_MOWLParser1420 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_propertyExpression_in_synpred4_MOWLParser1449 = new BitSet(
			new long[] { 0x0080000000000000L });
	public static final BitSet FOLLOW_ONLY_in_synpred4_MOWLParser1451 = new BitSet(new long[] {
			0x0034000000000000L, 0x0000020000040000L });
	public static final BitSet FOLLOW_filler_in_synpred4_MOWLParser1454 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_cardinalityRestriction_in_synpred5_MOWLParser1473 = new BitSet(
			new long[] { 0x0000000000000002L });
}