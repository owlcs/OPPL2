// $ANTLR 3.2 Sep 23, 2009 12:02:23 /Users/luigi/Documents/workspace/Parsers/src/OPPLTypes.g 2010-11-03 16:22:19
package org.coode.parsers.oppl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;

import org.antlr.runtime.BaseRecognizer;
import org.antlr.runtime.BitSet;
import org.antlr.runtime.DFA;
import org.antlr.runtime.EarlyExitException;
import org.antlr.runtime.IntStream;
import org.antlr.runtime.MismatchedSetException;
import org.antlr.runtime.MismatchedTokenException;
import org.antlr.runtime.NoViableAltException;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.RecognizerSharedState;
import org.antlr.runtime.Token;
import org.antlr.runtime.tree.RewriteEmptyStreamException;
import org.antlr.runtime.tree.TreeFilter;
import org.antlr.runtime.tree.TreeNodeStream;
import org.antlr.runtime.tree.TreeRuleReturnScope;
import org.coode.oppl.AbstractConstraint;
import org.coode.oppl.ConstraintSystem;
import org.coode.oppl.NAFConstraint;
import org.coode.oppl.OPPLAbstractFactory;
import org.coode.oppl.OPPLQuery;
import org.coode.oppl.RegExpConstraint;
import org.coode.oppl.Variable;
import org.coode.oppl.VariableScope;
import org.coode.oppl.VariableScopes;
import org.coode.oppl.exceptions.OPPLException;
import org.coode.oppl.function.Adapter;
import org.coode.oppl.function.Aggregandum;
import org.coode.oppl.function.Aggregation;
import org.coode.oppl.function.Constant;
import org.coode.oppl.function.OPPLFunction;
import org.coode.oppl.generated.GeneratedVariable;
import org.coode.oppl.generated.RegexpGeneratedVariable;
import org.coode.parsers.ErrorListener;
import org.coode.parsers.Type;
import org.coode.parsers.oppl.variableattribute.CollectionVariableAttributeSymbol;
import org.semanticweb.owlapi.model.AddAxiom;
import org.semanticweb.owlapi.model.OWLAxiom;
import org.semanticweb.owlapi.model.OWLAxiomChange;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLClassExpression;
import org.semanticweb.owlapi.model.OWLObject;
import org.semanticweb.owlapi.model.OWLPropertyExpression;
import org.semanticweb.owlapi.model.RemoveAxiom;

public class OPPLTypes extends TreeFilter {
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
			"ESCLAMATION_MARK", "MATCH", "ATTRIBUTE_SELECTOR", "VALUES", "RENDERING", "GROUPS",
			"STRING_OPERATION", "VARIABLE_NAME", "REGEXP_CONSTRAINT", "FAIL", "NAF_CONSTRAINT" };
	public static final int COMMA = 37;
	public static final int ASSERTED = 76;
	public static final int VARIABLE_DEFINITIONS = 102;
	public static final int REGEXP_CONSTRAINT = 465;
	public static final int END = 84;
	public static final int DIFFERENT_FROM = 24;
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
	public static final int AND = 10;
	public static final int EXPRESSION = 69;
	public static final int CONSTANT = 70;
	public static final int VALUE_RESTRICTION = 63;
	public static final int ONE_OF = 65;
	public static final int SUBPROPERTY_OF = 105;
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
	public static final int CLOSED_PARENTHESYS = 8;
	public static final int PROPERTY_CHAIN = 57;
	public static final int CREATE_INTERSECTION = 81;
	public static final int EQUIVALENT_TO_AXIOM = 49;
	public static final int OPEN_SQUARE_BRACKET = 85;
	public static final int NAF_CONSTRAINT = 467;
	public static final int SYMMETRIC = 30;
	public static final int DISJOINT_WITH = 26;
	public static final int VARIABLE_TYPE = 89;
	public static final int DISJUNCTION = 55;
	public static final int GROUPS = 356;
	public static final int NEGATED_EXPRESSION = 58;
	public static final int EQUAL = 73;
	public static final int DIFFERENT_FROM_AXIOM = 53;
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
	public static final int VALUE = 18;
	public static final int RENDERING = 355;
	public static final int INVERSE_FUNCTIONAL = 35;
	public static final int ATTRIBUTE_SELECTOR = 283;
	public static final int PLAIN_CLAUSE = 93;
	public static final int OR = 11;
	public static final int INTEGER = 42;
	public static final int INVERSE = 19;
	public static final int DISJOINT_WITH_AXIOM = 50;
	public static final int SUPER_CLASS_OF = 87;
	public static final int OPPL_FUNCTION = 100;
	public static final int DIGIT = 41;
	public static final int COMPOSITION = 4;
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
	public static final int WHITESPACE = 9;
	public static final int IN = 74;
	public static final int SUPER_PROPERTY_OF = 88;
	public static final int INEQUALITY_CONSTRAINT = 94;
	public static final int SOME = 13;
	public static final int EOF = -1;
	public static final int ANTI_SYMMETRIC = 31;
	public static final int Tokens = 47;
	public static final int CLOSED_CURLY_BRACES = 7;
	public static final int REFLEXIVE = 32;
	public static final int NOT = 12;
	public static final int STRING_OPERATION = 394;
	public static final int OPEN_PARENTHESYS = 5;
	public static final int VARIABLE_NAME = 464;
	public static final int IRREFLEXIVE = 33;

	// delegates
	// delegators
	public OPPLTypes(TreeNodeStream input) {
		this(input, new RecognizerSharedState());
	}

	public OPPLTypes(TreeNodeStream input, RecognizerSharedState state) {
		super(input, state);
	}

	@Override
	public String[] getTokenNames() {
		return OPPLTypes.tokenNames;
	}

	@Override
	public String getGrammarFileName() {
		return "/Users/luigi/Documents/workspace/Parsers/src/OPPLTypes.g";
	}

	private OPPLSymbolTable symtab;
	private ErrorListener errorListener;
	private ConstraintSystem constraintSystem;
	private OPPLAbstractFactory opplFactory;

	public OPPLTypes(TreeNodeStream input, OPPLSymbolTable symtab, ErrorListener errorListener,
			ConstraintSystem constraintSystem, OPPLAbstractFactory opplFactory) {
		this(input);
		if (symtab == null) {
			throw new NullPointerException("The symbol table cannot be null");
		}
		if (errorListener == null) {
			throw new NullPointerException("The error listener cannot be null");
		}
		if (constraintSystem == null) {
			throw new NullPointerException("The constraint system cannot be null");
		}
		if (opplFactory == null) {
			throw new NullPointerException("The OPPL Factory cannot be null");
		}
		this.symtab = symtab;
		this.errorListener = errorListener;
		this.opplFactory = opplFactory;
		this.constraintSystem = constraintSystem;
	}

	public ErrorListener getErrorListener() {
		return this.errorListener;
	}

	public ConstraintSystem getConstraintSystem() {
		return this.constraintSystem;
	}

	public OPPLSymbolTable getSymbolTable() {
		return this.symtab;
	}

	public OPPLAbstractFactory getOPPLFactory() {
		return this.opplFactory;
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

	// $ANTLR start "bottomup"
	// /Users/luigi/Documents/workspace/Parsers/src/OPPLTypes.g:120:1: bottomup
	// : statement ;
	@Override
	public final void bottomup() throws RecognitionException {
		try {
			// /Users/luigi/Documents/workspace/Parsers/src/OPPLTypes.g:121:5: (
			// statement )
			// /Users/luigi/Documents/workspace/Parsers/src/OPPLTypes.g:122:6:
			// statement
			{
				this.pushFollow(FOLLOW_statement_in_bottomup81);
				this.statement();
				this.state._fsp--;
				if (this.state.failed) {
					return;
				}
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
		return;
	}

	// $ANTLR end "bottomup"
	public static class statement_return extends TreeRuleReturnScope {
	};

	// $ANTLR start "statement"
	// /Users/luigi/Documents/workspace/Parsers/src/OPPLTypes.g:126:1: statement
	// : ^( OPPL_STATEMENT (vd= variableDefinitions )? (q= query )? actions ) ;
	public final OPPLTypes.statement_return statement() throws RecognitionException {
		OPPLTypes.statement_return retval = new OPPLTypes.statement_return();
		retval.start = this.input.LT(1);
		OPPLTypes.variableDefinitions_return vd = null;
		OPPLTypes.query_return q = null;
		OPPLTypes.actions_return actions1 = null;
		List<Variable> vds = new ArrayList<Variable>();
		try {
			// /Users/luigi/Documents/workspace/Parsers/src/OPPLTypes.g:130:2: (
			// ^( OPPL_STATEMENT (vd= variableDefinitions )? (q= query )?
			// actions ) )
			// /Users/luigi/Documents/workspace/Parsers/src/OPPLTypes.g:131:3:
			// ^( OPPL_STATEMENT (vd= variableDefinitions )? (q= query )?
			// actions )
			{
				this.match(this.input, OPPL_STATEMENT, FOLLOW_OPPL_STATEMENT_in_statement103);
				if (this.state.failed) {
					return retval;
				}
				this.match(this.input, Token.DOWN, null);
				if (this.state.failed) {
					return retval;
				}
				// /Users/luigi/Documents/workspace/Parsers/src/OPPLTypes.g:131:23:
				// (vd= variableDefinitions )?
				int alt1 = 2;
				int LA1_0 = this.input.LA(1);
				if (LA1_0 == VARIABLE_DEFINITIONS) {
					alt1 = 1;
				}
				switch (alt1) {
				case 1:
					// /Users/luigi/Documents/workspace/Parsers/src/OPPLTypes.g:131:23:
					// vd= variableDefinitions
				{
					this.pushFollow(FOLLOW_variableDefinitions_in_statement109);
					vd = this.variableDefinitions();
					this.state._fsp--;
					if (this.state.failed) {
						return retval;
					}
				}
					break;
				}
				// /Users/luigi/Documents/workspace/Parsers/src/OPPLTypes.g:131:47:
				// (q= query )?
				int alt2 = 2;
				int LA2_0 = this.input.LA(1);
				if (LA2_0 == QUERY) {
					alt2 = 1;
				}
				switch (alt2) {
				case 1:
					// /Users/luigi/Documents/workspace/Parsers/src/OPPLTypes.g:131:47:
					// q= query
				{
					this.pushFollow(FOLLOW_query_in_statement114);
					q = this.query();
					this.state._fsp--;
					if (this.state.failed) {
						return retval;
					}
				}
					break;
				}
				this.pushFollow(FOLLOW_actions_in_statement117);
				actions1 = this.actions();
				this.state._fsp--;
				if (this.state.failed) {
					return retval;
				}
				this.match(this.input, Token.UP, null);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 1) {
					if (vd != null) {
						vds.addAll((vd != null ? vd.variables : null));
					}
					if (!(actions1 != null ? actions1.actions : null).isEmpty()) {
						if (q != null) {
							((OPPLSyntaxTree) retval.start).setOPPLContent(this.getOPPLFactory().buildOPPLScript(
									this.getConstraintSystem(),
									vds,
									(q != null ? q.query : null),
									(actions1 != null ? actions1.actions : null)));
						} else {
							((OPPLSyntaxTree) retval.start).setOPPLContent(this.getOPPLFactory().buildOPPLScript(
									this.getConstraintSystem(),
									vds,
									null,
									(actions1 != null ? actions1.actions : null)));
						}
					}
				}
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
	public static class variableDefinitions_return extends TreeRuleReturnScope {
		public List<Variable> variables;
	};

	// $ANTLR start "variableDefinitions"
	// /Users/luigi/Documents/workspace/Parsers/src/OPPLTypes.g:150:1:
	// variableDefinitions returns [List<Variable> variables] : ^(
	// VARIABLE_DEFINITIONS (vd= variableDefinition )+ ) ;
	public final OPPLTypes.variableDefinitions_return variableDefinitions()
			throws RecognitionException {
		OPPLTypes.variableDefinitions_return retval = new OPPLTypes.variableDefinitions_return();
		retval.start = this.input.LT(1);
		OPPLTypes.variableDefinition_return vd = null;
		List<Variable> toReturn = new ArrayList<Variable>();
		try {
			// /Users/luigi/Documents/workspace/Parsers/src/OPPLTypes.g:158:2: (
			// ^( VARIABLE_DEFINITIONS (vd= variableDefinition )+ ) )
			// /Users/luigi/Documents/workspace/Parsers/src/OPPLTypes.g:159:3:
			// ^( VARIABLE_DEFINITIONS (vd= variableDefinition )+ )
			{
				this.match(
						this.input,
						VARIABLE_DEFINITIONS,
						FOLLOW_VARIABLE_DEFINITIONS_in_variableDefinitions148);
				if (this.state.failed) {
					return retval;
				}
				this.match(this.input, Token.DOWN, null);
				if (this.state.failed) {
					return retval;
				}
				// /Users/luigi/Documents/workspace/Parsers/src/OPPLTypes.g:159:26:
				// (vd= variableDefinition )+
				int cnt3 = 0;
				loop3: do {
					int alt3 = 2;
					int LA3_0 = this.input.LA(1);
					if (LA3_0 >= INPUT_VARIABLE_DEFINITION
							&& LA3_0 <= GENERATED_VARIABLE_DEFINITION) {
						alt3 = 1;
					}
					switch (alt3) {
					case 1:
						// /Users/luigi/Documents/workspace/Parsers/src/OPPLTypes.g:159:27:
						// vd= variableDefinition
					{
						this.pushFollow(FOLLOW_variableDefinition_in_variableDefinitions155);
						vd = this.variableDefinition();
						this.state._fsp--;
						if (this.state.failed) {
							return retval;
						}
						if (this.state.backtracking == 1) {
							toReturn.add(vd.variable);
						}
					}
						break;
					default:
						if (cnt3 >= 1) {
							break loop3;
						}
						if (this.state.backtracking > 0) {
							this.state.failed = true;
							return retval;
						}
						EarlyExitException eee = new EarlyExitException(3, this.input);
						throw eee;
					}
					cnt3++;
				} while (true);
				this.match(this.input, Token.UP, null);
				if (this.state.failed) {
					return retval;
				}
			}
			if (this.state.backtracking == 1) {
				retval.variables = toReturn;
				((OPPLSyntaxTree) retval.start).setOPPLContent(retval.variables);
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

	// $ANTLR end "variableDefinitions"
	public static class query_return extends TreeRuleReturnScope {
		public OPPLQuery query;
	};

	// $ANTLR start "query"
	// /Users/luigi/Documents/workspace/Parsers/src/OPPLTypes.g:162:1: query
	// returns [OPPLQuery query] : ^( QUERY ( selectClause )+ ( constraint )* )
	// ;
	public final OPPLTypes.query_return query() throws RecognitionException {
		OPPLTypes.query_return retval = new OPPLTypes.query_return();
		retval.start = this.input.LT(1);
		OPPLTypes.selectClause_return selectClause2 = null;
		OPPLTypes.constraint_return constraint3 = null;
		retval.query = this.getOPPLFactory().buildNewQuery(this.getConstraintSystem());
		try {
			// /Users/luigi/Documents/workspace/Parsers/src/OPPLTypes.g:173:2: (
			// ^( QUERY ( selectClause )+ ( constraint )* ) )
			// /Users/luigi/Documents/workspace/Parsers/src/OPPLTypes.g:174:3:
			// ^( QUERY ( selectClause )+ ( constraint )* )
			{
				this.match(this.input, QUERY, FOLLOW_QUERY_in_query189);
				if (this.state.failed) {
					return retval;
				}
				this.match(this.input, Token.DOWN, null);
				if (this.state.failed) {
					return retval;
				}
				// /Users/luigi/Documents/workspace/Parsers/src/OPPLTypes.g:174:11:
				// ( selectClause )+
				int cnt4 = 0;
				loop4: do {
					int alt4 = 2;
					int LA4_0 = this.input.LA(1);
					if (LA4_0 >= ASSERTED_CLAUSE && LA4_0 <= PLAIN_CLAUSE) {
						alt4 = 1;
					}
					switch (alt4) {
					case 1:
						// /Users/luigi/Documents/workspace/Parsers/src/OPPLTypes.g:174:12:
						// selectClause
					{
						this.pushFollow(FOLLOW_selectClause_in_query192);
						selectClause2 = this.selectClause();
						this.state._fsp--;
						if (this.state.failed) {
							return retval;
						}
						if (this.state.backtracking == 1) {
							if ((selectClause2 != null ? selectClause2.axiom : null) != null) {
								if (selectClause2 != null ? selectClause2.asserted : false) {
									retval.query.addAssertedAxiom((selectClause2 != null ? selectClause2.axiom
											: null));
								} else {
									retval.query.addAxiom((selectClause2 != null ? selectClause2.axiom
											: null));
								}
							}
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
				// /Users/luigi/Documents/workspace/Parsers/src/OPPLTypes.g:184:6:
				// ( constraint )*
				loop5: do {
					int alt5 = 2;
					int LA5_0 = this.input.LA(1);
					if (LA5_0 >= INEQUALITY_CONSTRAINT && LA5_0 <= IN_SET_CONSTRAINT
							|| LA5_0 == REGEXP_CONSTRAINT || LA5_0 == NAF_CONSTRAINT) {
						alt5 = 1;
					}
					switch (alt5) {
					case 1:
						// /Users/luigi/Documents/workspace/Parsers/src/OPPLTypes.g:184:7:
						// constraint
					{
						this.pushFollow(FOLLOW_constraint_in_query205);
						constraint3 = this.constraint();
						this.state._fsp--;
						if (this.state.failed) {
							return retval;
						}
						if (this.state.backtracking == 1) {
							if ((constraint3 != null ? constraint3.constraint : null) != null) {
								retval.query.addConstraint((constraint3 != null ? constraint3.constraint
										: null));
							}
						}
					}
						break;
					default:
						break loop5;
					}
				} while (true);
				this.match(this.input, Token.UP, null);
				if (this.state.failed) {
					return retval;
				}
			}
			if (this.state.backtracking == 1) {
				// No asserted axioms and plains axioms means no query at all.
				if (retval.query.getAssertedAxioms().isEmpty()
						&& retval.query.getAxioms().isEmpty()) {
					retval.query = null;
				}
				((OPPLSyntaxTree) retval.start).setOPPLContent(retval.query);
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

	// $ANTLR end "query"
	public static class selectClause_return extends TreeRuleReturnScope {
		public OWLAxiom axiom;
		public boolean asserted;
	};

	// $ANTLR start "selectClause"
	// /Users/luigi/Documents/workspace/Parsers/src/OPPLTypes.g:193:1:
	// selectClause returns [OWLAxiom axiom, boolean asserted] : ( ^(
	// ASSERTED_CLAUSE a= . ) | ^( PLAIN_CLAUSE a= . ) );
	public final OPPLTypes.selectClause_return selectClause() throws RecognitionException {
		OPPLTypes.selectClause_return retval = new OPPLTypes.selectClause_return();
		retval.start = this.input.LT(1);
		OPPLSyntaxTree a = null;
		try {
			// /Users/luigi/Documents/workspace/Parsers/src/OPPLTypes.g:194:2: (
			// ^( ASSERTED_CLAUSE a= . ) | ^( PLAIN_CLAUSE a= . ) )
			int alt6 = 2;
			int LA6_0 = this.input.LA(1);
			if (LA6_0 == ASSERTED_CLAUSE) {
				alt6 = 1;
			} else if (LA6_0 == PLAIN_CLAUSE) {
				alt6 = 2;
			} else {
				if (this.state.backtracking > 0) {
					this.state.failed = true;
					return retval;
				}
				NoViableAltException nvae = new NoViableAltException("", 6, 0, this.input);
				throw nvae;
			}
			switch (alt6) {
			case 1:
				// /Users/luigi/Documents/workspace/Parsers/src/OPPLTypes.g:195:3:
				// ^( ASSERTED_CLAUSE a= . )
			{
				this.match(this.input, ASSERTED_CLAUSE, FOLLOW_ASSERTED_CLAUSE_in_selectClause235);
				if (this.state.failed) {
					return retval;
				}
				this.match(this.input, Token.DOWN, null);
				if (this.state.failed) {
					return retval;
				}
				a = (OPPLSyntaxTree) this.input.LT(1);
				this.matchAny(this.input);
				if (this.state.failed) {
					return retval;
				}
				this.match(this.input, Token.UP, null);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 1) {
					OWLObject object = a.getOWLObject();
					if (object instanceof OWLAxiom) {
						retval.axiom = (OWLAxiom) a.getOWLObject();
					} else {
						this.getErrorListener().illegalToken(a, "OWL Axiom needed here");
					}
					retval.asserted = true;
				}
			}
				break;
			case 2:
				// /Users/luigi/Documents/workspace/Parsers/src/OPPLTypes.g:206:5:
				// ^( PLAIN_CLAUSE a= . )
			{
				this.match(this.input, PLAIN_CLAUSE, FOLLOW_PLAIN_CLAUSE_in_selectClause253);
				if (this.state.failed) {
					return retval;
				}
				this.match(this.input, Token.DOWN, null);
				if (this.state.failed) {
					return retval;
				}
				a = (OPPLSyntaxTree) this.input.LT(1);
				this.matchAny(this.input);
				if (this.state.failed) {
					return retval;
				}
				this.match(this.input, Token.UP, null);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 1) {
					OWLObject object = a.getOWLObject();
					if (object instanceof OWLAxiom) {
						retval.axiom = (OWLAxiom) a.getOWLObject();
					} else {
						this.getErrorListener().illegalToken(a, "OWL Axiom needed here");
					}
					retval.asserted = false;
				}
			}
				break;
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

	// $ANTLR end "selectClause"
	public static class actions_return extends TreeRuleReturnScope {
		public List<OWLAxiomChange> actions;
	};

	// $ANTLR start "actions"
	// /Users/luigi/Documents/workspace/Parsers/src/OPPLTypes.g:218:1: actions
	// returns [List<OWLAxiomChange> actions] : ^( ACTIONS ( action )+ ) ;
	public final OPPLTypes.actions_return actions() throws RecognitionException {
		OPPLTypes.actions_return retval = new OPPLTypes.actions_return();
		retval.start = this.input.LT(1);
		OWLAxiomChange action4 = null;
		retval.actions = new ArrayList<OWLAxiomChange>();
		try {
			// /Users/luigi/Documents/workspace/Parsers/src/OPPLTypes.g:225:2: (
			// ^( ACTIONS ( action )+ ) )
			// /Users/luigi/Documents/workspace/Parsers/src/OPPLTypes.g:226:3:
			// ^( ACTIONS ( action )+ )
			{
				this.match(this.input, ACTIONS, FOLLOW_ACTIONS_in_actions290);
				if (this.state.failed) {
					return retval;
				}
				this.match(this.input, Token.DOWN, null);
				if (this.state.failed) {
					return retval;
				}
				// /Users/luigi/Documents/workspace/Parsers/src/OPPLTypes.g:226:13:
				// ( action )+
				int cnt7 = 0;
				loop7: do {
					int alt7 = 2;
					int LA7_0 = this.input.LA(1);
					if (LA7_0 >= ADD && LA7_0 <= REMOVE) {
						alt7 = 1;
					}
					switch (alt7) {
					case 1:
						// /Users/luigi/Documents/workspace/Parsers/src/OPPLTypes.g:226:14:
						// action
					{
						this.pushFollow(FOLLOW_action_in_actions293);
						action4 = this.action();
						this.state._fsp--;
						if (this.state.failed) {
							return retval;
						}
						if (this.state.backtracking == 1) {
							if (action4 != null) {
								retval.actions.add(action4);
							}
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
						EarlyExitException eee = new EarlyExitException(7, this.input);
						throw eee;
					}
					cnt7++;
				} while (true);
				this.match(this.input, Token.UP, null);
				if (this.state.failed) {
					return retval;
				}
			}
			if (this.state.backtracking == 1) {
				((OPPLSyntaxTree) retval.start).setOPPLContent(retval.actions);
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

	// $ANTLR end "actions"
	// $ANTLR start "action"
	// /Users/luigi/Documents/workspace/Parsers/src/OPPLTypes.g:236:1: action
	// returns [OWLAxiomChange change] : ( ^( ADD a= . ) | ^( REMOVE a= . ) );
	public final OWLAxiomChange action() throws RecognitionException {
		OWLAxiomChange change = null;
		OPPLSyntaxTree a = null;
		try {
			// /Users/luigi/Documents/workspace/Parsers/src/OPPLTypes.g:237:2: (
			// ^( ADD a= . ) | ^( REMOVE a= . ) )
			int alt8 = 2;
			int LA8_0 = this.input.LA(1);
			if (LA8_0 == ADD) {
				alt8 = 1;
			} else if (LA8_0 == REMOVE) {
				alt8 = 2;
			} else {
				if (this.state.backtracking > 0) {
					this.state.failed = true;
					return change;
				}
				NoViableAltException nvae = new NoViableAltException("", 8, 0, this.input);
				throw nvae;
			}
			switch (alt8) {
			case 1:
				// /Users/luigi/Documents/workspace/Parsers/src/OPPLTypes.g:238:3:
				// ^( ADD a= . )
			{
				this.match(this.input, ADD, FOLLOW_ADD_in_action324);
				if (this.state.failed) {
					return change;
				}
				this.match(this.input, Token.DOWN, null);
				if (this.state.failed) {
					return change;
				}
				a = (OPPLSyntaxTree) this.input.LT(1);
				this.matchAny(this.input);
				if (this.state.failed) {
					return change;
				}
				this.match(this.input, Token.UP, null);
				if (this.state.failed) {
					return change;
				}
				if (this.state.backtracking == 1) {
					OWLObject object = a.getOWLObject();
					if (object instanceof OWLAxiom) {
						change = new AddAxiom(this.getConstraintSystem().getOntology(),
								(OWLAxiom) object);
					} else {
						this.getErrorListener().illegalToken(a, "OWL Axiom needed here");
					}
				}
			}
				break;
			case 2:
				// /Users/luigi/Documents/workspace/Parsers/src/OPPLTypes.g:246:5:
				// ^( REMOVE a= . )
			{
				this.match(this.input, REMOVE, FOLLOW_REMOVE_in_action339);
				if (this.state.failed) {
					return change;
				}
				this.match(this.input, Token.DOWN, null);
				if (this.state.failed) {
					return change;
				}
				a = (OPPLSyntaxTree) this.input.LT(1);
				this.matchAny(this.input);
				if (this.state.failed) {
					return change;
				}
				this.match(this.input, Token.UP, null);
				if (this.state.failed) {
					return change;
				}
				if (this.state.backtracking == 1) {
					OWLObject object = a.getOWLObject();
					if (object instanceof OWLAxiom) {
						change = new RemoveAxiom(this.getConstraintSystem().getOntology(),
								(OWLAxiom) object);
					} else {
						this.getErrorListener().illegalToken(a, "OWL Axiom needed here");
					}
				}
			}
				break;
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
		return change;
	}

	// $ANTLR end "action"
	public static class variableDefinition_return extends TreeRuleReturnScope {
		public Variable variable;
	};

	// $ANTLR start "variableDefinition"
	// /Users/luigi/Documents/workspace/Parsers/src/OPPLTypes.g:256:1:
	// variableDefinition returns [Variable variable] : ( ^(
	// INPUT_VARIABLE_DEFINITION VARIABLE_NAME VARIABLE_TYPE (vs= variableScope
	// )? ) | ^( GENERATED_VARIABLE_DEFINITION VARIABLE_NAME VARIABLE_TYPE
	// ^(expr= EXPRESSION ( . )* ) ) | ^( GENERATED_VARIABLE_DEFINITION
	// VARIABLE_NAME VARIABLE_TYPE ^( MATCH se= stringOperation ) ) | ^(
	// GENERATED_VARIABLE_DEFINITION VARIABLE_NAME VARIABLE_TYPE ^(
	// CREATE_OPPL_FUNCTION value= stringOperation ) ) | ^(
	// GENERATED_VARIABLE_DEFINITION name= VARIABLE_NAME VARIABLE_TYPE ^(
	// CREATE_INTERSECTION va= IDENTIFIER ) ) | ^( GENERATED_VARIABLE_DEFINITION
	// name= VARIABLE_NAME VARIABLE_TYPE ^( CREATE_DISJUNCTION va= IDENTIFIER )
	// ) );
	public final OPPLTypes.variableDefinition_return variableDefinition()
			throws RecognitionException {
		OPPLTypes.variableDefinition_return retval = new OPPLTypes.variableDefinition_return();
		retval.start = this.input.LT(1);
		OPPLSyntaxTree expr = null;
		OPPLSyntaxTree name = null;
		OPPLSyntaxTree va = null;
		OPPLSyntaxTree VARIABLE_NAME5 = null;
		OPPLSyntaxTree VARIABLE_TYPE6 = null;
		OPPLSyntaxTree INPUT_VARIABLE_DEFINITION7 = null;
		OPPLSyntaxTree VARIABLE_TYPE8 = null;
		OPPLSyntaxTree VARIABLE_NAME9 = null;
		OPPLSyntaxTree VARIABLE_TYPE10 = null;
		OPPLSyntaxTree VARIABLE_NAME11 = null;
		OPPLSyntaxTree VARIABLE_TYPE12 = null;
		OPPLSyntaxTree VARIABLE_NAME13 = null;
		OPPLSyntaxTree VARIABLE_TYPE14 = null;
		OPPLSyntaxTree VARIABLE_TYPE15 = null;
		OPPLTypes.variableScope_return vs = null;
		OPPLFunction<String> se = null;
		OPPLFunction<String> value = null;
		try {
			// /Users/luigi/Documents/workspace/Parsers/src/OPPLTypes.g:257:2: (
			// ^( INPUT_VARIABLE_DEFINITION VARIABLE_NAME VARIABLE_TYPE (vs=
			// variableScope )? ) | ^( GENERATED_VARIABLE_DEFINITION
			// VARIABLE_NAME VARIABLE_TYPE ^(expr= EXPRESSION ( . )* ) ) | ^(
			// GENERATED_VARIABLE_DEFINITION VARIABLE_NAME VARIABLE_TYPE ^(
			// MATCH se= stringOperation ) ) | ^( GENERATED_VARIABLE_DEFINITION
			// VARIABLE_NAME VARIABLE_TYPE ^( CREATE_OPPL_FUNCTION value=
			// stringOperation ) ) | ^( GENERATED_VARIABLE_DEFINITION name=
			// VARIABLE_NAME VARIABLE_TYPE ^( CREATE_INTERSECTION va= IDENTIFIER
			// ) ) | ^( GENERATED_VARIABLE_DEFINITION name= VARIABLE_NAME
			// VARIABLE_TYPE ^( CREATE_DISJUNCTION va= IDENTIFIER ) ) )
			int alt11 = 6;
			alt11 = this.dfa11.predict(this.input);
			switch (alt11) {
			case 1:
				// /Users/luigi/Documents/workspace/Parsers/src/OPPLTypes.g:258:5:
				// ^( INPUT_VARIABLE_DEFINITION VARIABLE_NAME VARIABLE_TYPE (vs=
				// variableScope )? )
			{
				INPUT_VARIABLE_DEFINITION7 = (OPPLSyntaxTree) this.match(
						this.input,
						INPUT_VARIABLE_DEFINITION,
						FOLLOW_INPUT_VARIABLE_DEFINITION_in_variableDefinition369);
				if (this.state.failed) {
					return retval;
				}
				this.match(this.input, Token.DOWN, null);
				if (this.state.failed) {
					return retval;
				}
				VARIABLE_NAME5 = (OPPLSyntaxTree) this.match(
						this.input,
						VARIABLE_NAME,
						FOLLOW_VARIABLE_NAME_in_variableDefinition371);
				if (this.state.failed) {
					return retval;
				}
				VARIABLE_TYPE6 = (OPPLSyntaxTree) this.match(
						this.input,
						VARIABLE_TYPE,
						FOLLOW_VARIABLE_TYPE_in_variableDefinition373);
				if (this.state.failed) {
					return retval;
				}
				// /Users/luigi/Documents/workspace/Parsers/src/OPPLTypes.g:258:64:
				// (vs= variableScope )?
				int alt9 = 2;
				int LA9_0 = this.input.LA(1);
				if (LA9_0 == VARIABLE_SCOPE) {
					alt9 = 1;
				}
				switch (alt9) {
				case 1:
					// /Users/luigi/Documents/workspace/Parsers/src/OPPLTypes.g:258:64:
					// vs= variableScope
				{
					this.pushFollow(FOLLOW_variableScope_in_variableDefinition379);
					vs = this.variableScope();
					this.state._fsp--;
					if (this.state.failed) {
						return retval;
					}
				}
					break;
				}
				this.match(this.input, Token.UP, null);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 1) {
					try {
						retval.variable = this.getConstraintSystem().createVariable(
								VARIABLE_NAME5.getToken().getText(),
								this.symtab.getVaribaleType(VARIABLE_TYPE6));
						if (vs != null) {
							retval.variable.setVariableScope(
									vs.variableScope,
									this.getOPPLFactory().getVariableScopeChecker());
						}
					} catch (OPPLException e) {
						this.getErrorListener().reportThrowable(
								e,
								INPUT_VARIABLE_DEFINITION7.token.getLine(),
								INPUT_VARIABLE_DEFINITION7.token.getCharPositionInLine(),
								INPUT_VARIABLE_DEFINITION7.token.getText().length());
					}
				}
			}
				break;
			case 2:
				// /Users/luigi/Documents/workspace/Parsers/src/OPPLTypes.g:269:7:
				// ^( GENERATED_VARIABLE_DEFINITION VARIABLE_NAME VARIABLE_TYPE
				// ^(expr= EXPRESSION ( . )* ) )
			{
				this.match(
						this.input,
						GENERATED_VARIABLE_DEFINITION,
						FOLLOW_GENERATED_VARIABLE_DEFINITION_in_variableDefinition396);
				if (this.state.failed) {
					return retval;
				}
				this.match(this.input, Token.DOWN, null);
				if (this.state.failed) {
					return retval;
				}
				VARIABLE_NAME9 = (OPPLSyntaxTree) this.match(
						this.input,
						VARIABLE_NAME,
						FOLLOW_VARIABLE_NAME_in_variableDefinition398);
				if (this.state.failed) {
					return retval;
				}
				VARIABLE_TYPE8 = (OPPLSyntaxTree) this.match(
						this.input,
						VARIABLE_TYPE,
						FOLLOW_VARIABLE_TYPE_in_variableDefinition400);
				if (this.state.failed) {
					return retval;
				}
				expr = (OPPLSyntaxTree) this.match(
						this.input,
						EXPRESSION,
						FOLLOW_EXPRESSION_in_variableDefinition408);
				if (this.state.failed) {
					return retval;
				}
				if (this.input.LA(1) == Token.DOWN) {
					this.match(this.input, Token.DOWN, null);
					if (this.state.failed) {
						return retval;
					}
					// /Users/luigi/Documents/workspace/Parsers/src/OPPLTypes.g:269:88:
					// ( . )*
					loop10: do {
						int alt10 = 2;
						int LA10_0 = this.input.LA(1);
						if (LA10_0 >= COMPOSITION && LA10_0 <= NAF_CONSTRAINT) {
							alt10 = 1;
						} else if (LA10_0 == UP) {
							alt10 = 2;
						}
						switch (alt10) {
						case 1:
							// /Users/luigi/Documents/workspace/Parsers/src/OPPLTypes.g:269:88:
							// .
						{
							this.matchAny(this.input);
							if (this.state.failed) {
								return retval;
							}
						}
							break;
						default:
							break loop10;
						}
					} while (true);
					this.match(this.input, Token.UP, null);
					if (this.state.failed) {
						return retval;
					}
				}
				this.match(this.input, Token.UP, null);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 1) {
					Type type = this.getSymbolTable().getExpressionGeneratedVariableType(
							((OPPLSyntaxTree) retval.start),
							VARIABLE_TYPE8,
							expr);
					if (type != null) {
						OWLObject expressionOWLObject = expr.getOWLObject();
						if (expressionOWLObject != null) {
							GeneratedVariable<?> v = this.getConstraintSystem().createExpressionGeneratedVariable(
									VARIABLE_NAME9.getText(),
									expressionOWLObject);
							if (v == null) {
								this.getErrorListener().illegalToken(
										expr,
										"Invalid expression to assign to a variable");
							}
							retval.variable = v;
						} else {
							this.getErrorListener().reportThrowable(
									new NullPointerException(
											"The type of the generated variable is null"),
									expr.token.getLine(),
									expr.token.getCharPositionInLine(),
									expr.token.getText().length());
						}
					} else {
						this.getErrorListener().reportThrowable(
								new NullPointerException(
										"The type of the generated variable is null"),
								((OPPLSyntaxTree) retval.start).token.getLine(),
								((OPPLSyntaxTree) retval.start).token.getCharPositionInLine(),
								((OPPLSyntaxTree) retval.start).token.getText().length());
					}
				}
			}
				break;
			case 3:
				// /Users/luigi/Documents/workspace/Parsers/src/OPPLTypes.g:287:7:
				// ^( GENERATED_VARIABLE_DEFINITION VARIABLE_NAME VARIABLE_TYPE
				// ^( MATCH se= stringOperation ) )
			{
				this.match(
						this.input,
						GENERATED_VARIABLE_DEFINITION,
						FOLLOW_GENERATED_VARIABLE_DEFINITION_in_variableDefinition430);
				if (this.state.failed) {
					return retval;
				}
				this.match(this.input, Token.DOWN, null);
				if (this.state.failed) {
					return retval;
				}
				VARIABLE_NAME11 = (OPPLSyntaxTree) this.match(
						this.input,
						VARIABLE_NAME,
						FOLLOW_VARIABLE_NAME_in_variableDefinition432);
				if (this.state.failed) {
					return retval;
				}
				VARIABLE_TYPE10 = (OPPLSyntaxTree) this.match(
						this.input,
						VARIABLE_TYPE,
						FOLLOW_VARIABLE_TYPE_in_variableDefinition434);
				if (this.state.failed) {
					return retval;
				}
				this.match(this.input, MATCH, FOLLOW_MATCH_in_variableDefinition437);
				if (this.state.failed) {
					return retval;
				}
				this.match(this.input, Token.DOWN, null);
				if (this.state.failed) {
					return retval;
				}
				this.pushFollow(FOLLOW_stringOperation_in_variableDefinition443);
				se = this.stringOperation();
				this.state._fsp--;
				if (this.state.failed) {
					return retval;
				}
				this.match(this.input, Token.UP, null);
				if (this.state.failed) {
					return retval;
				}
				this.match(this.input, Token.UP, null);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 1) {
					org.coode.oppl.VariableType type = org.coode.parsers.oppl.VariableType.getVariableType(
							VARIABLE_TYPE10.getText()).getOPPLVariableType();
					Pattern pattern = Pattern.compile(se.render(this.getConstraintSystem()));
					RegexpGeneratedVariable<?> v = this.getConstraintSystem().createRegexpGeneratedVariable(
							VARIABLE_NAME11.getText(),
							type,
							pattern);
					retval.variable = v;
				}
			}
				break;
			case 4:
				// /Users/luigi/Documents/workspace/Parsers/src/OPPLTypes.g:294:6:
				// ^( GENERATED_VARIABLE_DEFINITION VARIABLE_NAME VARIABLE_TYPE
				// ^( CREATE_OPPL_FUNCTION value= stringOperation ) )
			{
				this.match(
						this.input,
						GENERATED_VARIABLE_DEFINITION,
						FOLLOW_GENERATED_VARIABLE_DEFINITION_in_variableDefinition462);
				if (this.state.failed) {
					return retval;
				}
				this.match(this.input, Token.DOWN, null);
				if (this.state.failed) {
					return retval;
				}
				VARIABLE_NAME13 = (OPPLSyntaxTree) this.match(
						this.input,
						VARIABLE_NAME,
						FOLLOW_VARIABLE_NAME_in_variableDefinition464);
				if (this.state.failed) {
					return retval;
				}
				VARIABLE_TYPE12 = (OPPLSyntaxTree) this.match(
						this.input,
						VARIABLE_TYPE,
						FOLLOW_VARIABLE_TYPE_in_variableDefinition466);
				if (this.state.failed) {
					return retval;
				}
				this.match(
						this.input,
						CREATE_OPPL_FUNCTION,
						FOLLOW_CREATE_OPPL_FUNCTION_in_variableDefinition469);
				if (this.state.failed) {
					return retval;
				}
				this.match(this.input, Token.DOWN, null);
				if (this.state.failed) {
					return retval;
				}
				this.pushFollow(FOLLOW_stringOperation_in_variableDefinition476);
				value = this.stringOperation();
				this.state._fsp--;
				if (this.state.failed) {
					return retval;
				}
				this.match(this.input, Token.UP, null);
				if (this.state.failed) {
					return retval;
				}
				this.match(this.input, Token.UP, null);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 1) {
					org.coode.oppl.VariableType type = org.coode.parsers.oppl.VariableType.getVariableType(
							VARIABLE_TYPE12.getText()).getOPPLVariableType();
					retval.variable = this.constraintSystem.createStringGeneratedVariable(
							VARIABLE_NAME13.getText(),
							type,
							value);
				}
			}
				break;
			case 5:
				// /Users/luigi/Documents/workspace/Parsers/src/OPPLTypes.g:299:7:
				// ^( GENERATED_VARIABLE_DEFINITION name= VARIABLE_NAME
				// VARIABLE_TYPE ^( CREATE_INTERSECTION va= IDENTIFIER ) )
			{
				this.match(
						this.input,
						GENERATED_VARIABLE_DEFINITION,
						FOLLOW_GENERATED_VARIABLE_DEFINITION_in_variableDefinition495);
				if (this.state.failed) {
					return retval;
				}
				this.match(this.input, Token.DOWN, null);
				if (this.state.failed) {
					return retval;
				}
				name = (OPPLSyntaxTree) this.match(
						this.input,
						VARIABLE_NAME,
						FOLLOW_VARIABLE_NAME_in_variableDefinition501);
				if (this.state.failed) {
					return retval;
				}
				VARIABLE_TYPE14 = (OPPLSyntaxTree) this.match(
						this.input,
						VARIABLE_TYPE,
						FOLLOW_VARIABLE_TYPE_in_variableDefinition503);
				if (this.state.failed) {
					return retval;
				}
				this.match(
						this.input,
						CREATE_INTERSECTION,
						FOLLOW_CREATE_INTERSECTION_in_variableDefinition506);
				if (this.state.failed) {
					return retval;
				}
				this.match(this.input, Token.DOWN, null);
				if (this.state.failed) {
					return retval;
				}
				va = (OPPLSyntaxTree) this.match(
						this.input,
						IDENTIFIER,
						FOLLOW_IDENTIFIER_in_variableDefinition512);
				if (this.state.failed) {
					return retval;
				}
				this.match(this.input, Token.UP, null);
				if (this.state.failed) {
					return retval;
				}
				this.match(this.input, Token.UP, null);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 1) {
					org.coode.oppl.VariableType type = org.coode.parsers.oppl.VariableType.getVariableType(
							VARIABLE_TYPE14.getText()).getOPPLVariableType();
					CollectionVariableAttributeSymbol<?> symbol = this.getSymbolTable().getCollectionVariableAttributeSymbol(
							va);
					if (symbol != null) {
						retval.variable = this.getConstraintSystem().createIntersectionGeneratedVariable(
								name.getText(),
								type,
								Collections.singleton(symbol.getVariableAttribute()));
					} else {
						this.getErrorListener().illegalToken(va, "Unknown symbol");
					}
				}
			}
				break;
			case 6:
				// /Users/luigi/Documents/workspace/Parsers/src/OPPLTypes.g:310:9:
				// ^( GENERATED_VARIABLE_DEFINITION name= VARIABLE_NAME
				// VARIABLE_TYPE ^( CREATE_DISJUNCTION va= IDENTIFIER ) )
			{
				this.match(
						this.input,
						GENERATED_VARIABLE_DEFINITION,
						FOLLOW_GENERATED_VARIABLE_DEFINITION_in_variableDefinition534);
				if (this.state.failed) {
					return retval;
				}
				this.match(this.input, Token.DOWN, null);
				if (this.state.failed) {
					return retval;
				}
				name = (OPPLSyntaxTree) this.match(
						this.input,
						VARIABLE_NAME,
						FOLLOW_VARIABLE_NAME_in_variableDefinition540);
				if (this.state.failed) {
					return retval;
				}
				VARIABLE_TYPE15 = (OPPLSyntaxTree) this.match(
						this.input,
						VARIABLE_TYPE,
						FOLLOW_VARIABLE_TYPE_in_variableDefinition542);
				if (this.state.failed) {
					return retval;
				}
				this.match(
						this.input,
						CREATE_DISJUNCTION,
						FOLLOW_CREATE_DISJUNCTION_in_variableDefinition545);
				if (this.state.failed) {
					return retval;
				}
				this.match(this.input, Token.DOWN, null);
				if (this.state.failed) {
					return retval;
				}
				va = (OPPLSyntaxTree) this.match(
						this.input,
						IDENTIFIER,
						FOLLOW_IDENTIFIER_in_variableDefinition551);
				if (this.state.failed) {
					return retval;
				}
				this.match(this.input, Token.UP, null);
				if (this.state.failed) {
					return retval;
				}
				this.match(this.input, Token.UP, null);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 1) {
					org.coode.oppl.VariableType type = org.coode.parsers.oppl.VariableType.getVariableType(
							VARIABLE_TYPE15.getText()).getOPPLVariableType();
					AbstractCollectionGeneratedValue<OWLClass> collection = this.symtab.getCollection(
							((OPPLSyntaxTree) retval.start),
							va,
							this.getConstraintSystem());
					retval.variable = this.constraintSystem.createUnionGeneratedVariable(
							name.getText(),
							type,
							collection);
				}
			}
				break;
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

	// $ANTLR end "variableDefinition"
	// $ANTLR start "stringOperation"
	// /Users/luigi/Documents/workspace/Parsers/src/OPPLTypes.g:323:1:
	// stringOperation returns [OPPLFunction<String> value] : ^(
	// STRING_OPERATION (valuesToAggregate= stringExpression )+ ) ;
	public final OPPLFunction<String> stringOperation() throws RecognitionException {
		OPPLFunction<String> value = null;
		OPPLFunction<String> valuesToAggregate = null;
		List<Aggregandum<String>> values = new ArrayList<Aggregandum<String>>();
		try {
			// /Users/luigi/Documents/workspace/Parsers/src/OPPLTypes.g:328:3: (
			// ^( STRING_OPERATION (valuesToAggregate= stringExpression )+ ) )
			// /Users/luigi/Documents/workspace/Parsers/src/OPPLTypes.g:329:5:
			// ^( STRING_OPERATION (valuesToAggregate= stringExpression )+ )
			{
				this.match(
						this.input,
						STRING_OPERATION,
						FOLLOW_STRING_OPERATION_in_stringOperation610);
				if (this.state.failed) {
					return value;
				}
				this.match(this.input, Token.DOWN, null);
				if (this.state.failed) {
					return value;
				}
				// /Users/luigi/Documents/workspace/Parsers/src/OPPLTypes.g:329:25:
				// (valuesToAggregate= stringExpression )+
				int cnt12 = 0;
				loop12: do {
					int alt12 = 2;
					int LA12_0 = this.input.LA(1);
					if (LA12_0 == DBLQUOTE || LA12_0 == IDENTIFIER) {
						alt12 = 1;
					}
					switch (alt12) {
					case 1:
						// /Users/luigi/Documents/workspace/Parsers/src/OPPLTypes.g:329:26:
						// valuesToAggregate= stringExpression
					{
						this.pushFollow(FOLLOW_stringExpression_in_stringOperation617);
						valuesToAggregate = this.stringExpression();
						this.state._fsp--;
						if (this.state.failed) {
							return value;
						}
						if (this.state.backtracking == 1) {
							values.add(Adapter.buildSingletonAggregandum(valuesToAggregate));
						}
					}
						break;
					default:
						if (cnt12 >= 1) {
							break loop12;
						}
						if (this.state.backtracking > 0) {
							this.state.failed = true;
							return value;
						}
						EarlyExitException eee = new EarlyExitException(12, this.input);
						throw eee;
					}
					cnt12++;
				} while (true);
				this.match(this.input, Token.UP, null);
				if (this.state.failed) {
					return value;
				}
				if (this.state.backtracking == 1) {
					value = Aggregation.buildStringConcatenation(values);
				}
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
		return value;
	}

	// $ANTLR end "stringOperation"
	// $ANTLR start "stringExpression"
	// /Users/luigi/Documents/workspace/Parsers/src/OPPLTypes.g:336:1:
	// stringExpression returns [OPPLFunction<String> value] : ( DBLQUOTE |
	// IDENTIFIER );
	public final OPPLFunction<String> stringExpression() throws RecognitionException {
		OPPLFunction<String> value = null;
		OPPLSyntaxTree DBLQUOTE16 = null;
		OPPLSyntaxTree IDENTIFIER17 = null;
		try {
			// /Users/luigi/Documents/workspace/Parsers/src/OPPLTypes.g:337:3: (
			// DBLQUOTE | IDENTIFIER )
			int alt13 = 2;
			int LA13_0 = this.input.LA(1);
			if (LA13_0 == DBLQUOTE) {
				alt13 = 1;
			} else if (LA13_0 == IDENTIFIER) {
				alt13 = 2;
			} else {
				if (this.state.backtracking > 0) {
					this.state.failed = true;
					return value;
				}
				NoViableAltException nvae = new NoViableAltException("", 13, 0, this.input);
				throw nvae;
			}
			switch (alt13) {
			case 1:
				// /Users/luigi/Documents/workspace/Parsers/src/OPPLTypes.g:338:7:
				// DBLQUOTE
			{
				DBLQUOTE16 = (OPPLSyntaxTree) this.match(
						this.input,
						DBLQUOTE,
						FOLLOW_DBLQUOTE_in_stringExpression654);
				if (this.state.failed) {
					return value;
				}
				if (this.state.backtracking == 1) {
					value = new Constant<String>(DBLQUOTE16.getText());
				}
			}
				break;
			case 2:
				// /Users/luigi/Documents/workspace/Parsers/src/OPPLTypes.g:342:7:
				// IDENTIFIER
			{
				IDENTIFIER17 = (OPPLSyntaxTree) this.match(
						this.input,
						IDENTIFIER,
						FOLLOW_IDENTIFIER_in_stringExpression670);
				if (this.state.failed) {
					return value;
				}
				if (this.state.backtracking == 1) {
					value = this.symtab.getStringVariableAttribute(IDENTIFIER17);
				}
			}
				break;
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
		return value;
	}

	// $ANTLR end "stringExpression"
	public static class variableScope_return extends TreeRuleReturnScope {
		public Type type;
		public VariableScope variableScope;
	};

	// $ANTLR start "variableScope"
	// /Users/luigi/Documents/workspace/Parsers/src/OPPLTypes.g:354:1:
	// variableScope returns [Type type, VariableScope variableScope] : ( ^(
	// VARIABLE_SCOPE SUBCLASS_OF classExpression= . ) | ^( VARIABLE_SCOPE
	// SUPER_CLASS_OF classExpression= . ) | ^( VARIABLE_SCOPE SUPER_PROPERTY_OF
	// propertyExpression= . ) | ^( VARIABLE_SCOPE SUBPROPERTY_OF
	// propertyExpression= . ) | ^( VARIABLE_SCOPE ( INSTANCE_OF | TYPES )
	// individualExpression= . ) );
	public final OPPLTypes.variableScope_return variableScope() throws RecognitionException {
		OPPLTypes.variableScope_return retval = new OPPLTypes.variableScope_return();
		retval.start = this.input.LT(1);
		OPPLSyntaxTree classExpression = null;
		OPPLSyntaxTree propertyExpression = null;
		OPPLSyntaxTree individualExpression = null;
		try {
			// /Users/luigi/Documents/workspace/Parsers/src/OPPLTypes.g:359:2: (
			// ^( VARIABLE_SCOPE SUBCLASS_OF classExpression= . ) | ^(
			// VARIABLE_SCOPE SUPER_CLASS_OF classExpression= . ) | ^(
			// VARIABLE_SCOPE SUPER_PROPERTY_OF propertyExpression= . ) | ^(
			// VARIABLE_SCOPE SUBPROPERTY_OF propertyExpression= . ) | ^(
			// VARIABLE_SCOPE ( INSTANCE_OF | TYPES ) individualExpression= . )
			// )
			int alt14 = 5;
			int LA14_0 = this.input.LA(1);
			if (LA14_0 == VARIABLE_SCOPE) {
				int LA14_1 = this.input.LA(2);
				if (LA14_1 == DOWN) {
					switch (this.input.LA(3)) {
					case SUBCLASS_OF: {
						alt14 = 1;
					}
						break;
					case SUPER_CLASS_OF: {
						alt14 = 2;
					}
						break;
					case SUPER_PROPERTY_OF: {
						alt14 = 3;
					}
						break;
					case SUBPROPERTY_OF: {
						alt14 = 4;
					}
						break;
					case INSTANCE_OF:
					case TYPES: {
						alt14 = 5;
					}
						break;
					default:
						if (this.state.backtracking > 0) {
							this.state.failed = true;
							return retval;
						}
						NoViableAltException nvae = new NoViableAltException("", 14, 2, this.input);
						throw nvae;
					}
				} else {
					if (this.state.backtracking > 0) {
						this.state.failed = true;
						return retval;
					}
					NoViableAltException nvae = new NoViableAltException("", 14, 1, this.input);
					throw nvae;
				}
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
				// /Users/luigi/Documents/workspace/Parsers/src/OPPLTypes.g:360:5:
				// ^( VARIABLE_SCOPE SUBCLASS_OF classExpression= . )
			{
				this.match(this.input, VARIABLE_SCOPE, FOLLOW_VARIABLE_SCOPE_in_variableScope720);
				if (this.state.failed) {
					return retval;
				}
				this.match(this.input, Token.DOWN, null);
				if (this.state.failed) {
					return retval;
				}
				this.match(this.input, SUBCLASS_OF, FOLLOW_SUBCLASS_OF_in_variableScope722);
				if (this.state.failed) {
					return retval;
				}
				classExpression = (OPPLSyntaxTree) this.input.LT(1);
				this.matchAny(this.input);
				if (this.state.failed) {
					return retval;
				}
				this.match(this.input, Token.UP, null);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 1) {
					retval.type = this.symtab.getClassVariableScopeType(
							((OPPLSyntaxTree) retval.start),
							classExpression);
					retval.variableScope = VariableScopes.buildSubClassVariableScope((OWLClassExpression) classExpression.getOWLObject());
				}
			}
				break;
			case 2:
				// /Users/luigi/Documents/workspace/Parsers/src/OPPLTypes.g:365:7:
				// ^( VARIABLE_SCOPE SUPER_CLASS_OF classExpression= . )
			{
				this.match(this.input, VARIABLE_SCOPE, FOLLOW_VARIABLE_SCOPE_in_variableScope744);
				if (this.state.failed) {
					return retval;
				}
				this.match(this.input, Token.DOWN, null);
				if (this.state.failed) {
					return retval;
				}
				this.match(this.input, SUPER_CLASS_OF, FOLLOW_SUPER_CLASS_OF_in_variableScope746);
				if (this.state.failed) {
					return retval;
				}
				classExpression = (OPPLSyntaxTree) this.input.LT(1);
				this.matchAny(this.input);
				if (this.state.failed) {
					return retval;
				}
				this.match(this.input, Token.UP, null);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 1) {
					retval.type = this.symtab.getClassVariableScopeType(
							((OPPLSyntaxTree) retval.start),
							classExpression);
					retval.variableScope = VariableScopes.buildSuperClassVariableScope((OWLClassExpression) classExpression.getOWLObject());
				}
			}
				break;
			case 3:
				// /Users/luigi/Documents/workspace/Parsers/src/OPPLTypes.g:370:5:
				// ^( VARIABLE_SCOPE SUPER_PROPERTY_OF propertyExpression= . )
			{
				this.match(this.input, VARIABLE_SCOPE, FOLLOW_VARIABLE_SCOPE_in_variableScope770);
				if (this.state.failed) {
					return retval;
				}
				this.match(this.input, Token.DOWN, null);
				if (this.state.failed) {
					return retval;
				}
				this.match(
						this.input,
						SUPER_PROPERTY_OF,
						FOLLOW_SUPER_PROPERTY_OF_in_variableScope772);
				if (this.state.failed) {
					return retval;
				}
				propertyExpression = (OPPLSyntaxTree) this.input.LT(1);
				this.matchAny(this.input);
				if (this.state.failed) {
					return retval;
				}
				this.match(this.input, Token.UP, null);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 1) {
					retval.type = this.symtab.getPropertyVariableScopeType(
							((OPPLSyntaxTree) retval.start),
							propertyExpression);
					retval.variableScope = VariableScopes.buildSuperPropertyVariableScope((OWLPropertyExpression<?, ?>) propertyExpression.getOWLObject());
				}
			}
				break;
			case 4:
				// /Users/luigi/Documents/workspace/Parsers/src/OPPLTypes.g:375:6:
				// ^( VARIABLE_SCOPE SUBPROPERTY_OF propertyExpression= . )
			{
				this.match(this.input, VARIABLE_SCOPE, FOLLOW_VARIABLE_SCOPE_in_variableScope792);
				if (this.state.failed) {
					return retval;
				}
				this.match(this.input, Token.DOWN, null);
				if (this.state.failed) {
					return retval;
				}
				this.match(this.input, SUBPROPERTY_OF, FOLLOW_SUBPROPERTY_OF_in_variableScope794);
				if (this.state.failed) {
					return retval;
				}
				propertyExpression = (OPPLSyntaxTree) this.input.LT(1);
				this.matchAny(this.input);
				if (this.state.failed) {
					return retval;
				}
				this.match(this.input, Token.UP, null);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 1) {
					retval.type = this.symtab.getPropertyVariableScopeType(
							((OPPLSyntaxTree) retval.start),
							propertyExpression);
					retval.variableScope = VariableScopes.buildSubPropertyVariableScope((OWLPropertyExpression<?, ?>) propertyExpression.getOWLObject());
				}
			}
				break;
			case 5:
				// /Users/luigi/Documents/workspace/Parsers/src/OPPLTypes.g:380:6:
				// ^( VARIABLE_SCOPE ( INSTANCE_OF | TYPES )
				// individualExpression= . )
			{
				this.match(this.input, VARIABLE_SCOPE, FOLLOW_VARIABLE_SCOPE_in_variableScope819);
				if (this.state.failed) {
					return retval;
				}
				this.match(this.input, Token.DOWN, null);
				if (this.state.failed) {
					return retval;
				}
				if (this.input.LA(1) >= INSTANCE_OF && this.input.LA(1) <= TYPES) {
					this.input.consume();
					this.state.errorRecovery = false;
					this.state.failed = false;
				} else {
					if (this.state.backtracking > 0) {
						this.state.failed = true;
						return retval;
					}
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					throw mse;
				}
				individualExpression = (OPPLSyntaxTree) this.input.LT(1);
				this.matchAny(this.input);
				if (this.state.failed) {
					return retval;
				}
				this.match(this.input, Token.UP, null);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 1) {
					retval.type = this.symtab.getIndividualVariableScopeType(
							((OPPLSyntaxTree) retval.start),
							individualExpression);
					retval.variableScope = VariableScopes.buildIndividualVariableScope((OWLClassExpression) individualExpression.getOWLObject());
				}
			}
				break;
			}
			if (this.state.backtracking == 1) {
				((OPPLSyntaxTree) retval.start).setEvalType(retval.type);
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

	// $ANTLR end "variableScope"
	public static class constraint_return extends TreeRuleReturnScope {
		public AbstractConstraint constraint;
	};

	// $ANTLR start "constraint"
	// /Users/luigi/Documents/workspace/Parsers/src/OPPLTypes.g:389:1:
	// constraint returns [AbstractConstraint constraint] : ( ^(
	// INEQUALITY_CONSTRAINT IDENTIFIER ^( EXPRESSION expression= . ) ) | ^(
	// IN_SET_CONSTRAINT v= IDENTIFIER (i= IDENTIFIER )+ ) | ^(
	// REGEXP_CONSTRAINT IDENTIFIER se= stringOperation ) | ^( NAF_CONSTRAINT a=
	// . ) );
	public final OPPLTypes.constraint_return constraint() throws RecognitionException {
		OPPLTypes.constraint_return retval = new OPPLTypes.constraint_return();
		retval.start = this.input.LT(1);
		OPPLSyntaxTree v = null;
		OPPLSyntaxTree i = null;
		OPPLSyntaxTree IDENTIFIER18 = null;
		OPPLSyntaxTree IDENTIFIER19 = null;
		OPPLSyntaxTree expression = null;
		OPPLSyntaxTree a = null;
		OPPLFunction<String> se = null;
		List<OPPLSyntaxTree> identifiers = new ArrayList<OPPLSyntaxTree>();
		try {
			// /Users/luigi/Documents/workspace/Parsers/src/OPPLTypes.g:394:1: (
			// ^( INEQUALITY_CONSTRAINT IDENTIFIER ^( EXPRESSION expression= . )
			// ) | ^( IN_SET_CONSTRAINT v= IDENTIFIER (i= IDENTIFIER )+ ) | ^(
			// REGEXP_CONSTRAINT IDENTIFIER se= stringOperation ) | ^(
			// NAF_CONSTRAINT a= . ) )
			int alt16 = 4;
			switch (this.input.LA(1)) {
			case INEQUALITY_CONSTRAINT: {
				alt16 = 1;
			}
				break;
			case IN_SET_CONSTRAINT: {
				alt16 = 2;
			}
				break;
			case REGEXP_CONSTRAINT: {
				alt16 = 3;
			}
				break;
			case NAF_CONSTRAINT: {
				alt16 = 4;
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
				// /Users/luigi/Documents/workspace/Parsers/src/OPPLTypes.g:395:3:
				// ^( INEQUALITY_CONSTRAINT IDENTIFIER ^( EXPRESSION expression=
				// . ) )
			{
				this.match(
						this.input,
						INEQUALITY_CONSTRAINT,
						FOLLOW_INEQUALITY_CONSTRAINT_in_constraint868);
				if (this.state.failed) {
					return retval;
				}
				this.match(this.input, Token.DOWN, null);
				if (this.state.failed) {
					return retval;
				}
				IDENTIFIER18 = (OPPLSyntaxTree) this.match(
						this.input,
						IDENTIFIER,
						FOLLOW_IDENTIFIER_in_constraint870);
				if (this.state.failed) {
					return retval;
				}
				this.match(this.input, EXPRESSION, FOLLOW_EXPRESSION_in_constraint873);
				if (this.state.failed) {
					return retval;
				}
				this.match(this.input, Token.DOWN, null);
				if (this.state.failed) {
					return retval;
				}
				expression = (OPPLSyntaxTree) this.input.LT(1);
				this.matchAny(this.input);
				if (this.state.failed) {
					return retval;
				}
				this.match(this.input, Token.UP, null);
				if (this.state.failed) {
					return retval;
				}
				this.match(this.input, Token.UP, null);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 1) {
					retval.constraint = this.symtab.getInequalityConstraint(
							((OPPLSyntaxTree) retval.start),
							IDENTIFIER18,
							expression,
							this.getConstraintSystem());
				}
			}
				break;
			case 2:
				// /Users/luigi/Documents/workspace/Parsers/src/OPPLTypes.g:398:5:
				// ^( IN_SET_CONSTRAINT v= IDENTIFIER (i= IDENTIFIER )+ )
			{
				this.match(this.input, IN_SET_CONSTRAINT, FOLLOW_IN_SET_CONSTRAINT_in_constraint887);
				if (this.state.failed) {
					return retval;
				}
				this.match(this.input, Token.DOWN, null);
				if (this.state.failed) {
					return retval;
				}
				v = (OPPLSyntaxTree) this.match(
						this.input,
						IDENTIFIER,
						FOLLOW_IDENTIFIER_in_constraint893);
				if (this.state.failed) {
					return retval;
				}
				// /Users/luigi/Documents/workspace/Parsers/src/OPPLTypes.g:398:41:
				// (i= IDENTIFIER )+
				int cnt15 = 0;
				loop15: do {
					int alt15 = 2;
					int LA15_0 = this.input.LA(1);
					if (LA15_0 == IDENTIFIER) {
						alt15 = 1;
					}
					switch (alt15) {
					case 1:
						// /Users/luigi/Documents/workspace/Parsers/src/OPPLTypes.g:398:42:
						// i= IDENTIFIER
					{
						i = (OPPLSyntaxTree) this.match(
								this.input,
								IDENTIFIER,
								FOLLOW_IDENTIFIER_in_constraint901);
						if (this.state.failed) {
							return retval;
						}
						if (this.state.backtracking == 1) {
							identifiers.add(i);
						}
					}
						break;
					default:
						if (cnt15 >= 1) {
							break loop15;
						}
						if (this.state.backtracking > 0) {
							this.state.failed = true;
							return retval;
						}
						EarlyExitException eee = new EarlyExitException(15, this.input);
						throw eee;
					}
					cnt15++;
				} while (true);
				this.match(this.input, Token.UP, null);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 1) {
					retval.constraint = this.symtab.getInSetConstraint(
							((OPPLSyntaxTree) retval.start),
							v,
							this.constraintSystem,
							identifiers.toArray(new OPPLSyntaxTree[identifiers.size()]));
				}
			}
				break;
			case 3:
				// /Users/luigi/Documents/workspace/Parsers/src/OPPLTypes.g:401:5:
				// ^( REGEXP_CONSTRAINT IDENTIFIER se= stringOperation )
			{
				this.match(this.input, REGEXP_CONSTRAINT, FOLLOW_REGEXP_CONSTRAINT_in_constraint914);
				if (this.state.failed) {
					return retval;
				}
				this.match(this.input, Token.DOWN, null);
				if (this.state.failed) {
					return retval;
				}
				IDENTIFIER19 = (OPPLSyntaxTree) this.match(
						this.input,
						IDENTIFIER,
						FOLLOW_IDENTIFIER_in_constraint916);
				if (this.state.failed) {
					return retval;
				}
				this.pushFollow(FOLLOW_stringOperation_in_constraint922);
				se = this.stringOperation();
				this.state._fsp--;
				if (this.state.failed) {
					return retval;
				}
				this.match(this.input, Token.UP, null);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 1) {
					Variable variable = this.symtab.getVariable(
							IDENTIFIER19,
							this.getConstraintSystem());
					OPPLFunction<Pattern> adapted = Adapter.buildRegexpPatternAdapter(se);
					retval.constraint = new RegExpConstraint(variable, adapted,
							this.getConstraintSystem());
				}
			}
				break;
			case 4:
				// /Users/luigi/Documents/workspace/Parsers/src/OPPLTypes.g:407:5:
				// ^( NAF_CONSTRAINT a= . )
			{
				this.match(this.input, NAF_CONSTRAINT, FOLLOW_NAF_CONSTRAINT_in_constraint934);
				if (this.state.failed) {
					return retval;
				}
				this.match(this.input, Token.DOWN, null);
				if (this.state.failed) {
					return retval;
				}
				a = (OPPLSyntaxTree) this.input.LT(1);
				this.matchAny(this.input);
				if (this.state.failed) {
					return retval;
				}
				this.match(this.input, Token.UP, null);
				if (this.state.failed) {
					return retval;
				}
				if (this.state.backtracking == 1) {
					OWLObject axiom = a.getOWLObject();
					if (axiom instanceof OWLAxiom) {
						retval.constraint = new NAFConstraint((OWLAxiom) axiom,
								this.getConstraintSystem());
					}
				}
			}
				break;
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

	// $ANTLR end "constraint"
	// Delegated rules
	protected DFA11 dfa11 = new DFA11(this);
	static final String DFA11_eotS = "\13\uffff";
	static final String DFA11_eofS = "\13\uffff";
	static final String DFA11_minS = "\1\140\1\uffff\1\2\1\u01d0\1\131\1\105\5\uffff";
	static final String DFA11_maxS = "\1\141\1\uffff\1\2\1\u01d0\1\131\1\u00b0\5\uffff";
	static final String DFA11_acceptS = "\1\uffff\1\1\4\uffff\1\2\1\3\1\4\1\5\1\6";
	static final String DFA11_specialS = "\13\uffff}>";
	static final String[] DFA11_transitionS = { "\1\1\1\2", "", "\1\3", "\1\4", "\1\5",
			"\1\6\13\uffff\1\11\1\12\17\uffff\1\10\115\uffff\1\7", "", "", "", "", "" };
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
			return "256:1: variableDefinition returns [Variable variable] : ( ^( INPUT_VARIABLE_DEFINITION VARIABLE_NAME VARIABLE_TYPE (vs= variableScope )? ) | ^( GENERATED_VARIABLE_DEFINITION VARIABLE_NAME VARIABLE_TYPE ^(expr= EXPRESSION ( . )* ) ) | ^( GENERATED_VARIABLE_DEFINITION VARIABLE_NAME VARIABLE_TYPE ^( MATCH se= stringOperation ) ) | ^( GENERATED_VARIABLE_DEFINITION VARIABLE_NAME VARIABLE_TYPE ^( CREATE_OPPL_FUNCTION value= stringOperation ) ) | ^( GENERATED_VARIABLE_DEFINITION name= VARIABLE_NAME VARIABLE_TYPE ^( CREATE_INTERSECTION va= IDENTIFIER ) ) | ^( GENERATED_VARIABLE_DEFINITION name= VARIABLE_NAME VARIABLE_TYPE ^( CREATE_DISJUNCTION va= IDENTIFIER ) ) );";
		}
	}

	public static final BitSet FOLLOW_statement_in_bottomup81 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_OPPL_STATEMENT_in_statement103 = new BitSet(
			new long[] { 0x0000000000000004L });
	public static final BitSet FOLLOW_variableDefinitions_in_statement109 = new BitSet(new long[] {
			0x0000000000000000L, 0x000000A000000000L });
	public static final BitSet FOLLOW_query_in_statement114 = new BitSet(new long[] {
			0x0000000000000000L, 0x000000A000000000L });
	public static final BitSet FOLLOW_actions_in_statement117 = new BitSet(
			new long[] { 0x0000000000000008L });
	public static final BitSet FOLLOW_VARIABLE_DEFINITIONS_in_variableDefinitions148 = new BitSet(
			new long[] { 0x0000000000000004L });
	public static final BitSet FOLLOW_variableDefinition_in_variableDefinitions155 = new BitSet(
			new long[] { 0x0000000000000008L, 0x0000000300000000L });
	public static final BitSet FOLLOW_QUERY_in_query189 = new BitSet(
			new long[] { 0x0000000000000004L });
	public static final BitSet FOLLOW_selectClause_in_query192 = new BitSet(new long[] {
			0x0000000000000008L, 0x00000000F0000000L, 0x0000000000000000L, 0x0000000000000000L,
			0x0000000000000000L, 0x0000000000000000L, 0x0000000000000000L, 0x00000000000A0000L });
	public static final BitSet FOLLOW_constraint_in_query205 = new BitSet(new long[] {
			0x0000000000000008L, 0x00000000C0000000L, 0x0000000000000000L, 0x0000000000000000L,
			0x0000000000000000L, 0x0000000000000000L, 0x0000000000000000L, 0x00000000000A0000L });
	public static final BitSet FOLLOW_ASSERTED_CLAUSE_in_selectClause235 = new BitSet(
			new long[] { 0x0000000000000004L });
	public static final BitSet FOLLOW_PLAIN_CLAUSE_in_selectClause253 = new BitSet(
			new long[] { 0x0000000000000004L });
	public static final BitSet FOLLOW_ACTIONS_in_actions290 = new BitSet(
			new long[] { 0x0000000000000004L });
	public static final BitSet FOLLOW_action_in_actions293 = new BitSet(new long[] {
			0x0000000000000008L, 0x000000000C000000L });
	public static final BitSet FOLLOW_ADD_in_action324 = new BitSet(
			new long[] { 0x0000000000000004L });
	public static final BitSet FOLLOW_REMOVE_in_action339 = new BitSet(
			new long[] { 0x0000000000000004L });
	public static final BitSet FOLLOW_INPUT_VARIABLE_DEFINITION_in_variableDefinition369 = new BitSet(
			new long[] { 0x0000000000000004L });
	public static final BitSet FOLLOW_VARIABLE_NAME_in_variableDefinition371 = new BitSet(
			new long[] { 0x0000000000000000L, 0x0000000002000000L });
	public static final BitSet FOLLOW_VARIABLE_TYPE_in_variableDefinition373 = new BitSet(
			new long[] { 0x0000000000000008L, 0x0000010000000000L });
	public static final BitSet FOLLOW_variableScope_in_variableDefinition379 = new BitSet(
			new long[] { 0x0000000000000008L });
	public static final BitSet FOLLOW_GENERATED_VARIABLE_DEFINITION_in_variableDefinition396 = new BitSet(
			new long[] { 0x0000000000000004L });
	public static final BitSet FOLLOW_VARIABLE_NAME_in_variableDefinition398 = new BitSet(
			new long[] { 0x0000000000000000L, 0x0000000002000000L });
	public static final BitSet FOLLOW_VARIABLE_TYPE_in_variableDefinition400 = new BitSet(
			new long[] { 0x0000000000000000L, 0x0000000000000020L });
	public static final BitSet FOLLOW_EXPRESSION_in_variableDefinition408 = new BitSet(
			new long[] { 0x0000000000000004L });
	public static final BitSet FOLLOW_GENERATED_VARIABLE_DEFINITION_in_variableDefinition430 = new BitSet(
			new long[] { 0x0000000000000004L });
	public static final BitSet FOLLOW_VARIABLE_NAME_in_variableDefinition432 = new BitSet(
			new long[] { 0x0000000000000000L, 0x0000000002000000L });
	public static final BitSet FOLLOW_VARIABLE_TYPE_in_variableDefinition434 = new BitSet(
			new long[] { 0x0000000000000000L, 0x0000000000000000L, 0x0001000000000000L });
	public static final BitSet FOLLOW_MATCH_in_variableDefinition437 = new BitSet(
			new long[] { 0x0000000000000004L });
	public static final BitSet FOLLOW_stringOperation_in_variableDefinition443 = new BitSet(
			new long[] { 0x0000000000000008L });
	public static final BitSet FOLLOW_GENERATED_VARIABLE_DEFINITION_in_variableDefinition462 = new BitSet(
			new long[] { 0x0000000000000004L });
	public static final BitSet FOLLOW_VARIABLE_NAME_in_variableDefinition464 = new BitSet(
			new long[] { 0x0000000000000000L, 0x0000000002000000L });
	public static final BitSet FOLLOW_VARIABLE_TYPE_in_variableDefinition466 = new BitSet(
			new long[] { 0x0000000000000000L, 0x0000000400000000L });
	public static final BitSet FOLLOW_CREATE_OPPL_FUNCTION_in_variableDefinition469 = new BitSet(
			new long[] { 0x0000000000000004L });
	public static final BitSet FOLLOW_stringOperation_in_variableDefinition476 = new BitSet(
			new long[] { 0x0000000000000008L });
	public static final BitSet FOLLOW_GENERATED_VARIABLE_DEFINITION_in_variableDefinition495 = new BitSet(
			new long[] { 0x0000000000000004L });
	public static final BitSet FOLLOW_VARIABLE_NAME_in_variableDefinition501 = new BitSet(
			new long[] { 0x0000000000000000L, 0x0000000002000000L });
	public static final BitSet FOLLOW_VARIABLE_TYPE_in_variableDefinition503 = new BitSet(
			new long[] { 0x0000000000000000L, 0x0000000000020000L });
	public static final BitSet FOLLOW_CREATE_INTERSECTION_in_variableDefinition506 = new BitSet(
			new long[] { 0x0000000000000004L });
	public static final BitSet FOLLOW_IDENTIFIER_in_variableDefinition512 = new BitSet(
			new long[] { 0x0000000000000008L });
	public static final BitSet FOLLOW_GENERATED_VARIABLE_DEFINITION_in_variableDefinition534 = new BitSet(
			new long[] { 0x0000000000000004L });
	public static final BitSet FOLLOW_VARIABLE_NAME_in_variableDefinition540 = new BitSet(
			new long[] { 0x0000000000000000L, 0x0000000002000000L });
	public static final BitSet FOLLOW_VARIABLE_TYPE_in_variableDefinition542 = new BitSet(
			new long[] { 0x0000000000000000L, 0x0000000000040000L });
	public static final BitSet FOLLOW_CREATE_DISJUNCTION_in_variableDefinition545 = new BitSet(
			new long[] { 0x0000000000000004L });
	public static final BitSet FOLLOW_IDENTIFIER_in_variableDefinition551 = new BitSet(
			new long[] { 0x0000000000000008L });
	public static final BitSet FOLLOW_STRING_OPERATION_in_stringOperation610 = new BitSet(
			new long[] { 0x0000000000000004L });
	public static final BitSet FOLLOW_stringExpression_in_stringOperation617 = new BitSet(
			new long[] { 0x0000110000000008L });
	public static final BitSet FOLLOW_DBLQUOTE_in_stringExpression654 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_IDENTIFIER_in_stringExpression670 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_VARIABLE_SCOPE_in_variableScope720 = new BitSet(
			new long[] { 0x0000000000000004L });
	public static final BitSet FOLLOW_SUBCLASS_OF_in_variableScope722 = new BitSet(new long[] {
			0xFFFFFFFFFFFFFFF0L, 0xFFFFFFFFFFFFFFFFL, 0xFFFFFFFFFFFFFFFFL, 0xFFFFFFFFFFFFFFFFL,
			0xFFFFFFFFFFFFFFFFL, 0xFFFFFFFFFFFFFFFFL, 0xFFFFFFFFFFFFFFFFL, 0x00000000000FFFFFL });
	public static final BitSet FOLLOW_VARIABLE_SCOPE_in_variableScope744 = new BitSet(
			new long[] { 0x0000000000000004L });
	public static final BitSet FOLLOW_SUPER_CLASS_OF_in_variableScope746 = new BitSet(new long[] {
			0xFFFFFFFFFFFFFFF0L, 0xFFFFFFFFFFFFFFFFL, 0xFFFFFFFFFFFFFFFFL, 0xFFFFFFFFFFFFFFFFL,
			0xFFFFFFFFFFFFFFFFL, 0xFFFFFFFFFFFFFFFFL, 0xFFFFFFFFFFFFFFFFL, 0x00000000000FFFFFL });
	public static final BitSet FOLLOW_VARIABLE_SCOPE_in_variableScope770 = new BitSet(
			new long[] { 0x0000000000000004L });
	public static final BitSet FOLLOW_SUPER_PROPERTY_OF_in_variableScope772 = new BitSet(
			new long[] { 0xFFFFFFFFFFFFFFF0L, 0xFFFFFFFFFFFFFFFFL, 0xFFFFFFFFFFFFFFFFL,
					0xFFFFFFFFFFFFFFFFL, 0xFFFFFFFFFFFFFFFFL, 0xFFFFFFFFFFFFFFFFL,
					0xFFFFFFFFFFFFFFFFL, 0x00000000000FFFFFL });
	public static final BitSet FOLLOW_VARIABLE_SCOPE_in_variableScope792 = new BitSet(
			new long[] { 0x0000000000000004L });
	public static final BitSet FOLLOW_SUBPROPERTY_OF_in_variableScope794 = new BitSet(new long[] {
			0xFFFFFFFFFFFFFFF0L, 0xFFFFFFFFFFFFFFFFL, 0xFFFFFFFFFFFFFFFFL, 0xFFFFFFFFFFFFFFFFL,
			0xFFFFFFFFFFFFFFFFL, 0xFFFFFFFFFFFFFFFFL, 0xFFFFFFFFFFFFFFFFL, 0x00000000000FFFFFL });
	public static final BitSet FOLLOW_VARIABLE_SCOPE_in_variableScope819 = new BitSet(
			new long[] { 0x0000000000000004L });
	public static final BitSet FOLLOW_set_in_variableScope821 = new BitSet(new long[] {
			0xFFFFFFFFFFFFFFF0L, 0xFFFFFFFFFFFFFFFFL, 0xFFFFFFFFFFFFFFFFL, 0xFFFFFFFFFFFFFFFFL,
			0xFFFFFFFFFFFFFFFFL, 0xFFFFFFFFFFFFFFFFL, 0xFFFFFFFFFFFFFFFFL, 0x00000000000FFFFFL });
	public static final BitSet FOLLOW_INEQUALITY_CONSTRAINT_in_constraint868 = new BitSet(
			new long[] { 0x0000000000000004L });
	public static final BitSet FOLLOW_IDENTIFIER_in_constraint870 = new BitSet(new long[] {
			0x0000000000000000L, 0x0000000000000020L });
	public static final BitSet FOLLOW_EXPRESSION_in_constraint873 = new BitSet(
			new long[] { 0x0000000000000004L });
	public static final BitSet FOLLOW_IN_SET_CONSTRAINT_in_constraint887 = new BitSet(
			new long[] { 0x0000000000000004L });
	public static final BitSet FOLLOW_IDENTIFIER_in_constraint893 = new BitSet(
			new long[] { 0x0000100000000000L });
	public static final BitSet FOLLOW_IDENTIFIER_in_constraint901 = new BitSet(
			new long[] { 0x0000100000000008L });
	public static final BitSet FOLLOW_REGEXP_CONSTRAINT_in_constraint914 = new BitSet(
			new long[] { 0x0000000000000004L });
	public static final BitSet FOLLOW_IDENTIFIER_in_constraint916 = new BitSet(new long[] {
			0x0000000000000000L, 0x0000000000000000L, 0x0000000000000000L, 0x0000000000000000L,
			0x0000000000000000L, 0x0000000000000000L, 0x0000000000000400L });
	public static final BitSet FOLLOW_stringOperation_in_constraint922 = new BitSet(
			new long[] { 0x0000000000000008L });
	public static final BitSet FOLLOW_NAF_CONSTRAINT_in_constraint934 = new BitSet(
			new long[] { 0x0000000000000004L });
}