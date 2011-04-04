package org.coode.parsers.oppl.testcase;

// $ANTLR 3.2 Sep 23, 2009 12:02:23 MOWLLexer.g 2011-04-04 14:27:55
import org.antlr.runtime.BaseRecognizer;
import org.antlr.runtime.CharStream;
import org.antlr.runtime.DFA;
import org.antlr.runtime.EarlyExitException;
import org.antlr.runtime.Lexer;
import org.antlr.runtime.MismatchedSetException;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.RecognizerSharedState;

public class OPPLTestCaseLexer_OPPLLexer_MOWLLexer extends Lexer {
	public static final int STAR = 482;
	public static final int HAS_KEY = 109;
	public static final int VALUE_RESTRICTION = 63;
	public static final int LETTER = 43;
	public static final int CONTAINS = 471;
	public static final int REMOVE = 91;
	public static final int TYPES = 39;
	public static final int SAME_AS_AXIOM = 52;
	public static final int COUNT = 468;
	public static final int INVERSE_OF = 25;
	public static final int NOT = 12;
	public static final int SUBCLASS_OF = 20;
	public static final int EOF = -1;
	public static final int ESCLAMATION_MARK = 149;
	public static final int CREATE = 80;
	public static final int POW = 36;
	public static final int NOT_EQUAL = 72;
	public static final int INVERSE_OBJECT_PROPERTY_EXPRESSION = 68;
	public static final int INSTANCE_OF = 38;
	public static final int BEGIN = 83;
	public static final int QUESTION_MARK = 46;
	public static final int DISJOINT_PROPERTIES = 117;
	public static final int SYMMETRIC = 30;
	public static final int CARDINALITY_RESTRICTION = 64;
	public static final int SELECT = 75;
	public static final int ROLE_ASSERTION = 67;
	public static final int DIFFERENT_FROM_AXIOM = 53;
	public static final int TRANSITIVE = 34;
	public static final int ANTI_SYMMETRIC = 31;
	public static final int GREATER_THAN_EQUAL = 486;
	public static final int INFERENCE = 470;
	public static final int ALL_RESTRICTION = 62;
	public static final int CONJUNCTION = 56;
	public static final int NEGATED_ASSERTION = 59;
	public static final int WHITESPACE = 9;
	public static final int MATCH = 176;
	public static final int SEMICOLON = 469;
	public static final int VALUE = 18;
	public static final int ASSERT = 481;
	public static final int FAIL = 466;
	public static final int GROUPS = 356;
	public static final int OPEN_CURLY_BRACES = 6;
	public static final int DISJUNCTION = 55;
	public static final int INVERSE = 19;
	public static final int DBLQUOTE = 40;
	public static final int OR = 11;
	public static final int LESS_THAN = 483;
	public static final int CONSTANT = 70;
	public static final int ENTITY_REFERENCE = 45;
	public static final int END = 84;
	public static final int COMPOSITION = 4;
	public static final int CLOSED_SQUARE_BRACKET = 86;
	public static final int SAME_AS = 23;
	public static final int WHERE = 71;
	public static final int DIFFERENT_INDIVIDUALS = 119;
	public static final int DISJOINT_WITH = 26;
	public static final int SUPER_PROPERTY_OF = 88;
	public static final int VARIABLE_TYPE = 89;
	public static final int CLOSED_PARENTHESYS = 8;
	public static final int ONLY = 14;
	public static final int EQUIVALENT_TO_AXIOM = 49;
	public static final int SUB_PROPERTY_OF = 21;
	public static final int NEGATED_EXPRESSION = 58;
	public static final int MAX = 16;
	public static final int CREATE_DISJUNCTION = 82;
	public static final int AND = 10;
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
	public static final int EXACTLY = 17;
	public static final int SUB_PROPERTY_AXIOM = 51;
	public static final int OPEN_SQUARE_BRACKET = 85;
	public static final int VALUES = 354;
	public static final int RANGE = 28;
	public static final int SET = 115;
	public static final int ONE_OF = 65;
	public static final int MIN = 15;
	public static final int SUB_CLASS_AXIOM = 48;
	public static final int Tokens = 47;
	public static final int DOMAIN = 27;
	public static final int SUBPROPERTY_OF = 105;
	public static final int COLON = 77;
	public static final int DISJOINT_WITH_AXIOM = 50;
	public static final int CREATE_INTERSECTION = 81;
	public static final int INVERSE_FUNCTIONAL = 35;
	public static final int RENDERING = 355;
	public static final int IRI_ATTRIBUTE_NAME = 112;
	public static final int IRREFLEXIVE = 33;
	public static final int LESS_THAN_EQUAL = 484;
	public static final int ASSERTED = 76;
	public static final int FUNCTIONAL = 29;
	public static final int PROPERTY_CHAIN = 57;
	public static final int TYPE_ASSERTION = 66;
	public static final int DISJOINT_CLASSES = 116;
	// delegates
	// delegators
	public OPPLTestCaseLexer gOPPLTestCaseLexer;
	public OPPLTestCaseLexer_OPPLLexer gOPPLLexer;
	public OPPLTestCaseLexer_OPPLLexer gParent;

	public OPPLTestCaseLexer_OPPLLexer_MOWLLexer() {
		;
	}

	public OPPLTestCaseLexer_OPPLLexer_MOWLLexer(CharStream input,
			OPPLTestCaseLexer gOPPLTestCaseLexer, OPPLTestCaseLexer_OPPLLexer gOPPLLexer) {
		this(input, new RecognizerSharedState(), gOPPLTestCaseLexer, gOPPLLexer);
	}

	public OPPLTestCaseLexer_OPPLLexer_MOWLLexer(CharStream input, RecognizerSharedState state,
			OPPLTestCaseLexer gOPPLTestCaseLexer, OPPLTestCaseLexer_OPPLLexer gOPPLLexer) {
		super(input, state);
		this.gOPPLTestCaseLexer = gOPPLTestCaseLexer;
		this.gOPPLLexer = gOPPLLexer;
		this.gParent = gOPPLLexer;
	}

	@Override
	public String getGrammarFileName() {
		return "MOWLLexer.g";
	}

	// $ANTLR start "COMPOSITION"
	public final void mCOMPOSITION() throws RecognitionException {
		try {
			int _type = COMPOSITION;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// MOWLLexer.g:10:13: ( 'o' )
			// MOWLLexer.g:11:3: 'o'
			{
				this.match('o');
			}
			this.state.type = _type;
			this.state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "COMPOSITION"
	// $ANTLR start "OPEN_PARENTHESYS"
	public final void mOPEN_PARENTHESYS() throws RecognitionException {
		try {
			int _type = OPEN_PARENTHESYS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// MOWLLexer.g:14:19: ( '(' )
			// MOWLLexer.g:15:3: '('
			{
				this.match('(');
			}
			this.state.type = _type;
			this.state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "OPEN_PARENTHESYS"
	// $ANTLR start "OPEN_CURLY_BRACES"
	public final void mOPEN_CURLY_BRACES() throws RecognitionException {
		try {
			int _type = OPEN_CURLY_BRACES;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// MOWLLexer.g:18:19: ( '{' )
			// MOWLLexer.g:19:5: '{'
			{
				this.match('{');
			}
			this.state.type = _type;
			this.state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "OPEN_CURLY_BRACES"
	// $ANTLR start "CLOSED_CURLY_BRACES"
	public final void mCLOSED_CURLY_BRACES() throws RecognitionException {
		try {
			int _type = CLOSED_CURLY_BRACES;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// MOWLLexer.g:22:21: ( '}' )
			// MOWLLexer.g:23:5: '}'
			{
				this.match('}');
			}
			this.state.type = _type;
			this.state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "CLOSED_CURLY_BRACES"
	// $ANTLR start "CLOSED_PARENTHESYS"
	public final void mCLOSED_PARENTHESYS() throws RecognitionException {
		try {
			int _type = CLOSED_PARENTHESYS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// MOWLLexer.g:26:21: ( ')' )
			// MOWLLexer.g:27:3: ')'
			{
				this.match(')');
			}
			this.state.type = _type;
			this.state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "CLOSED_PARENTHESYS"
	// $ANTLR start "AT"
	public final void mAT() throws RecognitionException {
		try {
			int _type = AT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// MOWLLexer.g:31:2: ( '@' )
			// MOWLLexer.g:32:3: '@'
			{
				this.match('@');
			}
			this.state.type = _type;
			this.state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "AT"
	// $ANTLR start "WHITESPACE"
	public final void mWHITESPACE() throws RecognitionException {
		try {
			int _type = WHITESPACE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// MOWLLexer.g:35:13: ( ( ' ' | '\\t' | '\\n' | '\\r' ) )
			// MOWLLexer.g:35:15: ( ' ' | '\\t' | '\\n' | '\\r' )
			{
				if (this.input.LA(1) >= '\t' && this.input.LA(1) <= '\n'
						|| this.input.LA(1) == '\r' || this.input.LA(1) == ' ') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				_channel = HIDDEN;
			}
			this.state.type = _type;
			this.state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "WHITESPACE"
	// $ANTLR start "AND"
	public final void mAND() throws RecognitionException {
		try {
			int _type = AND;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// MOWLLexer.g:38:5: ( ( 'A' | 'a' ) ( 'N' | 'n' ) ( 'D' | 'd' ) )
			// MOWLLexer.g:38:7: ( 'A' | 'a' ) ( 'N' | 'n' ) ( 'D' | 'd' )
			{
				if (this.input.LA(1) == 'A' || this.input.LA(1) == 'a') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				if (this.input.LA(1) == 'N' || this.input.LA(1) == 'n') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				if (this.input.LA(1) == 'D' || this.input.LA(1) == 'd') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
			}
			this.state.type = _type;
			this.state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "AND"
	// $ANTLR start "OR"
	public final void mOR() throws RecognitionException {
		try {
			int _type = OR;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// MOWLLexer.g:39:4: ( ( 'O' | 'o' ) ( 'R' | 'r' ) )
			// MOWLLexer.g:39:6: ( 'O' | 'o' ) ( 'R' | 'r' )
			{
				if (this.input.LA(1) == 'O' || this.input.LA(1) == 'o') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				if (this.input.LA(1) == 'R' || this.input.LA(1) == 'r') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
			}
			this.state.type = _type;
			this.state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "OR"
	// $ANTLR start "NOT"
	public final void mNOT() throws RecognitionException {
		try {
			int _type = NOT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// MOWLLexer.g:40:5: ( ( 'N' | 'n' ) ( 'O' | 'o' ) ( 'T' | 't' ) )
			// MOWLLexer.g:40:7: ( 'N' | 'n' ) ( 'O' | 'o' ) ( 'T' | 't' )
			{
				if (this.input.LA(1) == 'N' || this.input.LA(1) == 'n') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				if (this.input.LA(1) == 'O' || this.input.LA(1) == 'o') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				if (this.input.LA(1) == 'T' || this.input.LA(1) == 't') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
			}
			this.state.type = _type;
			this.state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "NOT"
	// $ANTLR start "SOME"
	public final void mSOME() throws RecognitionException {
		try {
			int _type = SOME;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// MOWLLexer.g:41:7: ( ( 'S' | 's' ) ( 'O' | 'o' ) ( 'M' | 'm' ) (
			// 'E' | 'e' ) )
			// MOWLLexer.g:41:9: ( 'S' | 's' ) ( 'O' | 'o' ) ( 'M' | 'm' ) ( 'E'
			// | 'e' )
			{
				if (this.input.LA(1) == 'S' || this.input.LA(1) == 's') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				if (this.input.LA(1) == 'O' || this.input.LA(1) == 'o') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				if (this.input.LA(1) == 'M' || this.input.LA(1) == 'm') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				if (this.input.LA(1) == 'E' || this.input.LA(1) == 'e') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
			}
			this.state.type = _type;
			this.state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "SOME"
	// $ANTLR start "ONLY"
	public final void mONLY() throws RecognitionException {
		try {
			int _type = ONLY;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// MOWLLexer.g:42:6: ( ( 'O' | 'o' ) ( 'N' | 'n' ) ( 'L' | 'l' ) (
			// 'Y' | 'y' ) )
			// MOWLLexer.g:42:8: ( 'O' | 'o' ) ( 'N' | 'n' ) ( 'L' | 'l' ) ( 'Y'
			// | 'y' )
			{
				if (this.input.LA(1) == 'O' || this.input.LA(1) == 'o') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				if (this.input.LA(1) == 'N' || this.input.LA(1) == 'n') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				if (this.input.LA(1) == 'L' || this.input.LA(1) == 'l') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				if (this.input.LA(1) == 'Y' || this.input.LA(1) == 'y') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
			}
			this.state.type = _type;
			this.state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "ONLY"
	// $ANTLR start "MIN"
	public final void mMIN() throws RecognitionException {
		try {
			int _type = MIN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// MOWLLexer.g:43:5: ( ( 'M' | 'm' ) ( 'I' | 'i' ) ( 'N' | 'n' ) )
			// MOWLLexer.g:43:7: ( 'M' | 'm' ) ( 'I' | 'i' ) ( 'N' | 'n' )
			{
				if (this.input.LA(1) == 'M' || this.input.LA(1) == 'm') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				if (this.input.LA(1) == 'I' || this.input.LA(1) == 'i') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				if (this.input.LA(1) == 'N' || this.input.LA(1) == 'n') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
			}
			this.state.type = _type;
			this.state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "MIN"
	// $ANTLR start "MAX"
	public final void mMAX() throws RecognitionException {
		try {
			int _type = MAX;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// MOWLLexer.g:44:5: ( ( 'M' | 'm' ) ( 'A' | 'a' ) ( 'X' | 'x' ) )
			// MOWLLexer.g:44:7: ( 'M' | 'm' ) ( 'A' | 'a' ) ( 'X' | 'x' )
			{
				if (this.input.LA(1) == 'M' || this.input.LA(1) == 'm') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				if (this.input.LA(1) == 'A' || this.input.LA(1) == 'a') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				if (this.input.LA(1) == 'X' || this.input.LA(1) == 'x') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
			}
			this.state.type = _type;
			this.state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "MAX"
	// $ANTLR start "EXACTLY"
	public final void mEXACTLY() throws RecognitionException {
		try {
			int _type = EXACTLY;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// MOWLLexer.g:45:9: ( ( 'E' | 'e' ) ( 'X' | 'x' ) ( 'A' | 'a' ) (
			// 'C' | 'c' ) ( 'T' | 't' ) ( 'L' | 'l' ) ( 'Y' | 'y' ) )
			// MOWLLexer.g:45:11: ( 'E' | 'e' ) ( 'X' | 'x' ) ( 'A' | 'a' ) (
			// 'C' | 'c' ) ( 'T' | 't' ) ( 'L' | 'l' ) ( 'Y' | 'y' )
			{
				if (this.input.LA(1) == 'E' || this.input.LA(1) == 'e') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				if (this.input.LA(1) == 'X' || this.input.LA(1) == 'x') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				if (this.input.LA(1) == 'A' || this.input.LA(1) == 'a') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				if (this.input.LA(1) == 'C' || this.input.LA(1) == 'c') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				if (this.input.LA(1) == 'T' || this.input.LA(1) == 't') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				if (this.input.LA(1) == 'L' || this.input.LA(1) == 'l') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				if (this.input.LA(1) == 'Y' || this.input.LA(1) == 'y') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
			}
			this.state.type = _type;
			this.state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "EXACTLY"
	// $ANTLR start "VALUE"
	public final void mVALUE() throws RecognitionException {
		try {
			int _type = VALUE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// MOWLLexer.g:46:7: ( ( 'V' | 'v' ) ( 'A' | 'a' ) ( 'L' | 'l' ) (
			// 'U' | 'u' ) ( 'E' | 'e' ) )
			// MOWLLexer.g:46:9: ( 'V' | 'v' ) ( 'A' | 'a' ) ( 'L' | 'l' ) ( 'U'
			// | 'u' ) ( 'E' | 'e' )
			{
				if (this.input.LA(1) == 'V' || this.input.LA(1) == 'v') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				if (this.input.LA(1) == 'A' || this.input.LA(1) == 'a') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				if (this.input.LA(1) == 'L' || this.input.LA(1) == 'l') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				if (this.input.LA(1) == 'U' || this.input.LA(1) == 'u') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				if (this.input.LA(1) == 'E' || this.input.LA(1) == 'e') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
			}
			this.state.type = _type;
			this.state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "VALUE"
	// $ANTLR start "INVERSE"
	public final void mINVERSE() throws RecognitionException {
		try {
			int _type = INVERSE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// MOWLLexer.g:47:9: ( ( 'I' | 'i' ) ( 'N' | 'n' ) ( 'V' | 'v' ) )
			// MOWLLexer.g:47:11: ( 'I' | 'i' ) ( 'N' | 'n' ) ( 'V' | 'v' )
			{
				if (this.input.LA(1) == 'I' || this.input.LA(1) == 'i') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				if (this.input.LA(1) == 'N' || this.input.LA(1) == 'n') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				if (this.input.LA(1) == 'V' || this.input.LA(1) == 'v') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
			}
			this.state.type = _type;
			this.state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "INVERSE"
	// $ANTLR start "SUBCLASS_OF"
	public final void mSUBCLASS_OF() throws RecognitionException {
		try {
			int _type = SUBCLASS_OF;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// MOWLLexer.g:48:13: ( ( 'S' | 's' ) ( 'U' | 'u' ) ( 'B' | 'b' ) (
			// 'C' | 'c' ) ( 'L' | 'l' ) ( 'A' | 'a' ) ( 'S' | 's' ) ( 'S' | 's'
			// ) ( 'O' | 'o' ) ( 'F' | 'f' ) )
			// MOWLLexer.g:48:15: ( 'S' | 's' ) ( 'U' | 'u' ) ( 'B' | 'b' ) (
			// 'C' | 'c' ) ( 'L' | 'l' ) ( 'A' | 'a' ) ( 'S' | 's' ) ( 'S' | 's'
			// ) ( 'O' | 'o' ) ( 'F' | 'f' )
			{
				if (this.input.LA(1) == 'S' || this.input.LA(1) == 's') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				if (this.input.LA(1) == 'U' || this.input.LA(1) == 'u') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				if (this.input.LA(1) == 'B' || this.input.LA(1) == 'b') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				if (this.input.LA(1) == 'C' || this.input.LA(1) == 'c') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				if (this.input.LA(1) == 'L' || this.input.LA(1) == 'l') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				if (this.input.LA(1) == 'A' || this.input.LA(1) == 'a') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				if (this.input.LA(1) == 'S' || this.input.LA(1) == 's') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				if (this.input.LA(1) == 'S' || this.input.LA(1) == 's') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				if (this.input.LA(1) == 'O' || this.input.LA(1) == 'o') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				if (this.input.LA(1) == 'F' || this.input.LA(1) == 'f') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
			}
			this.state.type = _type;
			this.state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "SUBCLASS_OF"
	// $ANTLR start "SUB_PROPERTY_OF"
	public final void mSUB_PROPERTY_OF() throws RecognitionException {
		try {
			int _type = SUB_PROPERTY_OF;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// MOWLLexer.g:49:17: ( ( 'S' | 's' ) ( 'U' | 'u' ) ( 'B' | 'b' ) (
			// 'P' | 'p' ) ( 'R' | 'r' ) ( 'O' | 'o' ) ( 'P' | 'p' ) ( 'E' | 'e'
			// ) ( 'R' | 'r' ) ( 'T' | 't' ) ( 'Y' | 'y' ) ( 'O' | 'o' ) ( 'F' |
			// 'f' ) )
			// MOWLLexer.g:49:19: ( 'S' | 's' ) ( 'U' | 'u' ) ( 'B' | 'b' ) (
			// 'P' | 'p' ) ( 'R' | 'r' ) ( 'O' | 'o' ) ( 'P' | 'p' ) ( 'E' | 'e'
			// ) ( 'R' | 'r' ) ( 'T' | 't' ) ( 'Y' | 'y' ) ( 'O' | 'o' ) ( 'F' |
			// 'f' )
			{
				if (this.input.LA(1) == 'S' || this.input.LA(1) == 's') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				if (this.input.LA(1) == 'U' || this.input.LA(1) == 'u') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				if (this.input.LA(1) == 'B' || this.input.LA(1) == 'b') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				if (this.input.LA(1) == 'P' || this.input.LA(1) == 'p') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				if (this.input.LA(1) == 'R' || this.input.LA(1) == 'r') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				if (this.input.LA(1) == 'O' || this.input.LA(1) == 'o') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				if (this.input.LA(1) == 'P' || this.input.LA(1) == 'p') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				if (this.input.LA(1) == 'E' || this.input.LA(1) == 'e') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				if (this.input.LA(1) == 'R' || this.input.LA(1) == 'r') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				if (this.input.LA(1) == 'T' || this.input.LA(1) == 't') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				if (this.input.LA(1) == 'Y' || this.input.LA(1) == 'y') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				if (this.input.LA(1) == 'O' || this.input.LA(1) == 'o') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				if (this.input.LA(1) == 'F' || this.input.LA(1) == 'f') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
			}
			this.state.type = _type;
			this.state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "SUB_PROPERTY_OF"
	// $ANTLR start "EQUIVALENT_TO"
	public final void mEQUIVALENT_TO() throws RecognitionException {
		try {
			int _type = EQUIVALENT_TO;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// MOWLLexer.g:50:15: ( ( 'E' | 'e' ) ( 'Q' | 'q' ) ( 'U' | 'u' ) (
			// 'I' | 'i' ) ( 'V' | 'v' ) ( 'A' | 'a' ) ( 'L' | 'l' ) ( 'E' | 'e'
			// ) ( 'N' | 'n' ) ( 'T' | 't' ) ( 'T' | 't' ) ( 'O' | 'o' ) )
			// MOWLLexer.g:50:17: ( 'E' | 'e' ) ( 'Q' | 'q' ) ( 'U' | 'u' ) (
			// 'I' | 'i' ) ( 'V' | 'v' ) ( 'A' | 'a' ) ( 'L' | 'l' ) ( 'E' | 'e'
			// ) ( 'N' | 'n' ) ( 'T' | 't' ) ( 'T' | 't' ) ( 'O' | 'o' )
			{
				if (this.input.LA(1) == 'E' || this.input.LA(1) == 'e') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				if (this.input.LA(1) == 'Q' || this.input.LA(1) == 'q') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				if (this.input.LA(1) == 'U' || this.input.LA(1) == 'u') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				if (this.input.LA(1) == 'I' || this.input.LA(1) == 'i') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				if (this.input.LA(1) == 'V' || this.input.LA(1) == 'v') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				if (this.input.LA(1) == 'A' || this.input.LA(1) == 'a') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				if (this.input.LA(1) == 'L' || this.input.LA(1) == 'l') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				if (this.input.LA(1) == 'E' || this.input.LA(1) == 'e') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				if (this.input.LA(1) == 'N' || this.input.LA(1) == 'n') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				if (this.input.LA(1) == 'T' || this.input.LA(1) == 't') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				if (this.input.LA(1) == 'T' || this.input.LA(1) == 't') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				if (this.input.LA(1) == 'O' || this.input.LA(1) == 'o') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
			}
			this.state.type = _type;
			this.state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "EQUIVALENT_TO"
	// $ANTLR start "SAME_AS"
	public final void mSAME_AS() throws RecognitionException {
		try {
			int _type = SAME_AS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// MOWLLexer.g:51:9: ( ( 'S' | 's' ) ( 'A' | 'a' ) ( 'M' | 'm' ) (
			// 'E' | 'e' ) ( 'A' | 'a' ) ( 'S' | 's' ) )
			// MOWLLexer.g:51:11: ( 'S' | 's' ) ( 'A' | 'a' ) ( 'M' | 'm' ) (
			// 'E' | 'e' ) ( 'A' | 'a' ) ( 'S' | 's' )
			{
				if (this.input.LA(1) == 'S' || this.input.LA(1) == 's') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				if (this.input.LA(1) == 'A' || this.input.LA(1) == 'a') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				if (this.input.LA(1) == 'M' || this.input.LA(1) == 'm') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				if (this.input.LA(1) == 'E' || this.input.LA(1) == 'e') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				if (this.input.LA(1) == 'A' || this.input.LA(1) == 'a') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				if (this.input.LA(1) == 'S' || this.input.LA(1) == 's') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
			}
			this.state.type = _type;
			this.state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "SAME_AS"
	// $ANTLR start "DIFFERENT_FROM"
	public final void mDIFFERENT_FROM() throws RecognitionException {
		try {
			int _type = DIFFERENT_FROM;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// MOWLLexer.g:52:17: ( ( 'D' | 'd' ) ( 'I' | 'i' ) ( 'F' | 'f' ) (
			// 'F' | 'f' ) ( 'E' | 'e' ) ( 'R' | 'r' ) ( 'E' | 'e' ) ( 'N' | 'n'
			// ) ( 'T' | 't' ) ( 'F' | 'f' ) ( 'R' | 'r' ) ( 'O' | 'o' ) ( 'M' |
			// 'm' ) )
			// MOWLLexer.g:52:19: ( 'D' | 'd' ) ( 'I' | 'i' ) ( 'F' | 'f' ) (
			// 'F' | 'f' ) ( 'E' | 'e' ) ( 'R' | 'r' ) ( 'E' | 'e' ) ( 'N' | 'n'
			// ) ( 'T' | 't' ) ( 'F' | 'f' ) ( 'R' | 'r' ) ( 'O' | 'o' ) ( 'M' |
			// 'm' )
			{
				if (this.input.LA(1) == 'D' || this.input.LA(1) == 'd') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				if (this.input.LA(1) == 'I' || this.input.LA(1) == 'i') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				if (this.input.LA(1) == 'F' || this.input.LA(1) == 'f') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				if (this.input.LA(1) == 'F' || this.input.LA(1) == 'f') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				if (this.input.LA(1) == 'E' || this.input.LA(1) == 'e') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				if (this.input.LA(1) == 'R' || this.input.LA(1) == 'r') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				if (this.input.LA(1) == 'E' || this.input.LA(1) == 'e') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				if (this.input.LA(1) == 'N' || this.input.LA(1) == 'n') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				if (this.input.LA(1) == 'T' || this.input.LA(1) == 't') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				if (this.input.LA(1) == 'F' || this.input.LA(1) == 'f') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				if (this.input.LA(1) == 'R' || this.input.LA(1) == 'r') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				if (this.input.LA(1) == 'O' || this.input.LA(1) == 'o') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				if (this.input.LA(1) == 'M' || this.input.LA(1) == 'm') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
			}
			this.state.type = _type;
			this.state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "DIFFERENT_FROM"
	// $ANTLR start "INVERSE_OF"
	public final void mINVERSE_OF() throws RecognitionException {
		try {
			int _type = INVERSE_OF;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// MOWLLexer.g:53:11: ( ( 'I' | 'i' ) ( 'N' | 'n' ) ( 'V' | 'v' ) (
			// 'E' | 'e' ) ( 'R' | 'r' ) ( 'S' | 's' ) ( 'E' | 'e' ) ( 'O' | 'o'
			// ) ( 'F' | 'f' ) )
			// MOWLLexer.g:53:15: ( 'I' | 'i' ) ( 'N' | 'n' ) ( 'V' | 'v' ) (
			// 'E' | 'e' ) ( 'R' | 'r' ) ( 'S' | 's' ) ( 'E' | 'e' ) ( 'O' | 'o'
			// ) ( 'F' | 'f' )
			{
				if (this.input.LA(1) == 'I' || this.input.LA(1) == 'i') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				if (this.input.LA(1) == 'N' || this.input.LA(1) == 'n') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				if (this.input.LA(1) == 'V' || this.input.LA(1) == 'v') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				if (this.input.LA(1) == 'E' || this.input.LA(1) == 'e') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				if (this.input.LA(1) == 'R' || this.input.LA(1) == 'r') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				if (this.input.LA(1) == 'S' || this.input.LA(1) == 's') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				if (this.input.LA(1) == 'E' || this.input.LA(1) == 'e') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				if (this.input.LA(1) == 'O' || this.input.LA(1) == 'o') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				if (this.input.LA(1) == 'F' || this.input.LA(1) == 'f') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
			}
			this.state.type = _type;
			this.state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "INVERSE_OF"
	// $ANTLR start "DISJOINT_WITH"
	public final void mDISJOINT_WITH() throws RecognitionException {
		try {
			int _type = DISJOINT_WITH;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// MOWLLexer.g:54:15: ( ( 'D' | 'd' ) ( 'I' | 'i' ) ( 'S' | 's' ) (
			// 'J' | 'j' ) ( 'O' | 'o' ) ( 'I' | 'i' ) ( 'N' | 'n' ) ( 'T' | 't'
			// ) ( 'W' | 'w' ) ( 'I' | 'i' ) ( 'T' | 't' ) ( 'H' | 'h' ) )
			// MOWLLexer.g:54:17: ( 'D' | 'd' ) ( 'I' | 'i' ) ( 'S' | 's' ) (
			// 'J' | 'j' ) ( 'O' | 'o' ) ( 'I' | 'i' ) ( 'N' | 'n' ) ( 'T' | 't'
			// ) ( 'W' | 'w' ) ( 'I' | 'i' ) ( 'T' | 't' ) ( 'H' | 'h' )
			{
				if (this.input.LA(1) == 'D' || this.input.LA(1) == 'd') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				if (this.input.LA(1) == 'I' || this.input.LA(1) == 'i') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				if (this.input.LA(1) == 'S' || this.input.LA(1) == 's') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				if (this.input.LA(1) == 'J' || this.input.LA(1) == 'j') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				if (this.input.LA(1) == 'O' || this.input.LA(1) == 'o') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				if (this.input.LA(1) == 'I' || this.input.LA(1) == 'i') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				if (this.input.LA(1) == 'N' || this.input.LA(1) == 'n') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				if (this.input.LA(1) == 'T' || this.input.LA(1) == 't') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				if (this.input.LA(1) == 'W' || this.input.LA(1) == 'w') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				if (this.input.LA(1) == 'I' || this.input.LA(1) == 'i') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				if (this.input.LA(1) == 'T' || this.input.LA(1) == 't') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				if (this.input.LA(1) == 'H' || this.input.LA(1) == 'h') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
			}
			this.state.type = _type;
			this.state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "DISJOINT_WITH"
	// $ANTLR start "DOMAIN"
	public final void mDOMAIN() throws RecognitionException {
		try {
			int _type = DOMAIN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// MOWLLexer.g:55:9: ( ( 'D' | 'd' ) ( 'O' | 'o' ) ( 'M' | 'm' ) (
			// 'A' | 'a' ) ( 'I' | 'i' ) ( 'N' | 'n' ) )
			// MOWLLexer.g:55:10: ( 'D' | 'd' ) ( 'O' | 'o' ) ( 'M' | 'm' ) (
			// 'A' | 'a' ) ( 'I' | 'i' ) ( 'N' | 'n' )
			{
				if (this.input.LA(1) == 'D' || this.input.LA(1) == 'd') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				if (this.input.LA(1) == 'O' || this.input.LA(1) == 'o') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				if (this.input.LA(1) == 'M' || this.input.LA(1) == 'm') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				if (this.input.LA(1) == 'A' || this.input.LA(1) == 'a') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				if (this.input.LA(1) == 'I' || this.input.LA(1) == 'i') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				if (this.input.LA(1) == 'N' || this.input.LA(1) == 'n') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
			}
			this.state.type = _type;
			this.state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "DOMAIN"
	// $ANTLR start "RANGE"
	public final void mRANGE() throws RecognitionException {
		try {
			int _type = RANGE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// MOWLLexer.g:56:8: ( ( 'R' | 'r' ) ( 'A' | 'a' ) ( 'N' | 'n' ) (
			// 'G' | 'g' ) ( 'E' | 'e' ) )
			// MOWLLexer.g:56:9: ( 'R' | 'r' ) ( 'A' | 'a' ) ( 'N' | 'n' ) ( 'G'
			// | 'g' ) ( 'E' | 'e' )
			{
				if (this.input.LA(1) == 'R' || this.input.LA(1) == 'r') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				if (this.input.LA(1) == 'A' || this.input.LA(1) == 'a') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				if (this.input.LA(1) == 'N' || this.input.LA(1) == 'n') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				if (this.input.LA(1) == 'G' || this.input.LA(1) == 'g') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				if (this.input.LA(1) == 'E' || this.input.LA(1) == 'e') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
			}
			this.state.type = _type;
			this.state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "RANGE"
	// $ANTLR start "HAS_KEY"
	public final void mHAS_KEY() throws RecognitionException {
		try {
			int _type = HAS_KEY;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// MOWLLexer.g:57:9: ( ( 'H' | 'h' ) ( 'A' | 'a' ) ( 'S' | 's' ) (
			// 'K' | 'k' ) ( 'E' | 'e' ) ( 'Y' | 'y' ) )
			// MOWLLexer.g:57:11: ( 'H' | 'h' ) ( 'A' | 'a' ) ( 'S' | 's' ) (
			// 'K' | 'k' ) ( 'E' | 'e' ) ( 'Y' | 'y' )
			{
				if (this.input.LA(1) == 'H' || this.input.LA(1) == 'h') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				if (this.input.LA(1) == 'A' || this.input.LA(1) == 'a') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				if (this.input.LA(1) == 'S' || this.input.LA(1) == 's') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				if (this.input.LA(1) == 'K' || this.input.LA(1) == 'k') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				if (this.input.LA(1) == 'E' || this.input.LA(1) == 'e') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				if (this.input.LA(1) == 'Y' || this.input.LA(1) == 'y') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
			}
			this.state.type = _type;
			this.state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "HAS_KEY"
	// $ANTLR start "FUNCTIONAL"
	public final void mFUNCTIONAL() throws RecognitionException {
		try {
			int _type = FUNCTIONAL;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// MOWLLexer.g:58:12: ( ( 'F' | 'f' ) ( 'U' | 'u' ) ( 'N' | 'n' ) (
			// 'C' | 'c' ) ( 'T' | 't' ) ( 'I' | 'i' ) ( 'O' | 'o' ) ( 'N' | 'n'
			// ) ( 'A' | 'a' ) ( 'L' | 'l' ) ( ':' )? )
			// MOWLLexer.g:58:14: ( 'F' | 'f' ) ( 'U' | 'u' ) ( 'N' | 'n' ) (
			// 'C' | 'c' ) ( 'T' | 't' ) ( 'I' | 'i' ) ( 'O' | 'o' ) ( 'N' | 'n'
			// ) ( 'A' | 'a' ) ( 'L' | 'l' ) ( ':' )?
			{
				if (this.input.LA(1) == 'F' || this.input.LA(1) == 'f') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				if (this.input.LA(1) == 'U' || this.input.LA(1) == 'u') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				if (this.input.LA(1) == 'N' || this.input.LA(1) == 'n') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				if (this.input.LA(1) == 'C' || this.input.LA(1) == 'c') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				if (this.input.LA(1) == 'T' || this.input.LA(1) == 't') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				if (this.input.LA(1) == 'I' || this.input.LA(1) == 'i') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				if (this.input.LA(1) == 'O' || this.input.LA(1) == 'o') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				if (this.input.LA(1) == 'N' || this.input.LA(1) == 'n') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				if (this.input.LA(1) == 'A' || this.input.LA(1) == 'a') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				if (this.input.LA(1) == 'L' || this.input.LA(1) == 'l') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				// MOWLLexer.g:58:104: ( ':' )?
				int alt1 = 2;
				int LA1_0 = this.input.LA(1);
				if (LA1_0 == ':') {
					alt1 = 1;
				}
				switch (alt1) {
				case 1:
					// MOWLLexer.g:58:104: ':'
				{
					this.match(':');
				}
					break;
				}
			}
			this.state.type = _type;
			this.state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "FUNCTIONAL"
	// $ANTLR start "SYMMETRIC"
	public final void mSYMMETRIC() throws RecognitionException {
		try {
			int _type = SYMMETRIC;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// MOWLLexer.g:59:11: ( ( 'S' | 's' ) ( 'Y' | 'y' ) ( 'M' | 'm' ) (
			// 'M' | 'm' ) ( 'E' | 'e' ) ( 'T' | 't' ) ( 'R' | 'r' ) ( 'I' | 'i'
			// ) ( 'C' | 'c' ) ( ':' )? )
			// MOWLLexer.g:59:13: ( 'S' | 's' ) ( 'Y' | 'y' ) ( 'M' | 'm' ) (
			// 'M' | 'm' ) ( 'E' | 'e' ) ( 'T' | 't' ) ( 'R' | 'r' ) ( 'I' | 'i'
			// ) ( 'C' | 'c' ) ( ':' )?
			{
				if (this.input.LA(1) == 'S' || this.input.LA(1) == 's') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				if (this.input.LA(1) == 'Y' || this.input.LA(1) == 'y') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				if (this.input.LA(1) == 'M' || this.input.LA(1) == 'm') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				if (this.input.LA(1) == 'M' || this.input.LA(1) == 'm') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				if (this.input.LA(1) == 'E' || this.input.LA(1) == 'e') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				if (this.input.LA(1) == 'T' || this.input.LA(1) == 't') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				if (this.input.LA(1) == 'R' || this.input.LA(1) == 'r') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				if (this.input.LA(1) == 'I' || this.input.LA(1) == 'i') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				if (this.input.LA(1) == 'C' || this.input.LA(1) == 'c') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				// MOWLLexer.g:59:94: ( ':' )?
				int alt2 = 2;
				int LA2_0 = this.input.LA(1);
				if (LA2_0 == ':') {
					alt2 = 1;
				}
				switch (alt2) {
				case 1:
					// MOWLLexer.g:59:94: ':'
				{
					this.match(':');
				}
					break;
				}
			}
			this.state.type = _type;
			this.state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "SYMMETRIC"
	// $ANTLR start "ANTI_SYMMETRIC"
	public final void mANTI_SYMMETRIC() throws RecognitionException {
		try {
			int _type = ANTI_SYMMETRIC;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// MOWLLexer.g:60:16: ( ( 'A' | 'a' ) ( 'nti' )? ( 'S' | 's' )
			// 'ymmetric' ( ':' )? )
			// MOWLLexer.g:60:18: ( 'A' | 'a' ) ( 'nti' )? ( 'S' | 's' )
			// 'ymmetric' ( ':' )?
			{
				if (this.input.LA(1) == 'A' || this.input.LA(1) == 'a') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				// MOWLLexer.g:60:27: ( 'nti' )?
				int alt3 = 2;
				int LA3_0 = this.input.LA(1);
				if (LA3_0 == 'n') {
					alt3 = 1;
				}
				switch (alt3) {
				case 1:
					// MOWLLexer.g:60:27: 'nti'
				{
					this.match("nti");
				}
					break;
				}
				if (this.input.LA(1) == 'S' || this.input.LA(1) == 's') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				this.match("ymmetric");
				// MOWLLexer.g:60:52: ( ':' )?
				int alt4 = 2;
				int LA4_0 = this.input.LA(1);
				if (LA4_0 == ':') {
					alt4 = 1;
				}
				switch (alt4) {
				case 1:
					// MOWLLexer.g:60:52: ':'
				{
					this.match(':');
				}
					break;
				}
			}
			this.state.type = _type;
			this.state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "ANTI_SYMMETRIC"
	// $ANTLR start "TYPES"
	public final void mTYPES() throws RecognitionException {
		try {
			int _type = TYPES;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// MOWLLexer.g:61:7: ( ( 'T' | 't' ) ( 'Y' | 'y' ) ( 'P' | 'p' ) (
			// 'E' | 'e' ) ( 'S' | 's' )? )
			// MOWLLexer.g:61:9: ( 'T' | 't' ) ( 'Y' | 'y' ) ( 'P' | 'p' ) ( 'E'
			// | 'e' ) ( 'S' | 's' )?
			{
				if (this.input.LA(1) == 'T' || this.input.LA(1) == 't') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				if (this.input.LA(1) == 'Y' || this.input.LA(1) == 'y') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				if (this.input.LA(1) == 'P' || this.input.LA(1) == 'p') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				if (this.input.LA(1) == 'E' || this.input.LA(1) == 'e') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				// MOWLLexer.g:61:45: ( 'S' | 's' )?
				int alt5 = 2;
				int LA5_0 = this.input.LA(1);
				if (LA5_0 == 'S' || LA5_0 == 's') {
					alt5 = 1;
				}
				switch (alt5) {
				case 1:
					// MOWLLexer.g:
				{
					if (this.input.LA(1) == 'S' || this.input.LA(1) == 's') {
						this.input.consume();
					} else {
						MismatchedSetException mse = new MismatchedSetException(null, this.input);
						this.recover(mse);
						throw mse;
					}
				}
					break;
				}
			}
			this.state.type = _type;
			this.state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "TYPES"
	// $ANTLR start "REFLEXIVE"
	public final void mREFLEXIVE() throws RecognitionException {
		try {
			int _type = REFLEXIVE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// MOWLLexer.g:62:11: ( ( 'R' | 'r' ) ( 'E' | 'e' ) ( 'F' | 'f' ) (
			// 'L' | 'l' ) ( 'E' | 'e' ) ( 'X' | 'x' ) ( 'I' | 'i' ) ( 'V' | 'v'
			// ) ( 'E' | 'e' ) ( ':' )? )
			// MOWLLexer.g:62:13: ( 'R' | 'r' ) ( 'E' | 'e' ) ( 'F' | 'f' ) (
			// 'L' | 'l' ) ( 'E' | 'e' ) ( 'X' | 'x' ) ( 'I' | 'i' ) ( 'V' | 'v'
			// ) ( 'E' | 'e' ) ( ':' )?
			{
				if (this.input.LA(1) == 'R' || this.input.LA(1) == 'r') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				if (this.input.LA(1) == 'E' || this.input.LA(1) == 'e') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				if (this.input.LA(1) == 'F' || this.input.LA(1) == 'f') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				if (this.input.LA(1) == 'L' || this.input.LA(1) == 'l') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				if (this.input.LA(1) == 'E' || this.input.LA(1) == 'e') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				if (this.input.LA(1) == 'X' || this.input.LA(1) == 'x') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				if (this.input.LA(1) == 'I' || this.input.LA(1) == 'i') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				if (this.input.LA(1) == 'V' || this.input.LA(1) == 'v') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				if (this.input.LA(1) == 'E' || this.input.LA(1) == 'e') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				// MOWLLexer.g:62:94: ( ':' )?
				int alt6 = 2;
				int LA6_0 = this.input.LA(1);
				if (LA6_0 == ':') {
					alt6 = 1;
				}
				switch (alt6) {
				case 1:
					// MOWLLexer.g:62:94: ':'
				{
					this.match(':');
				}
					break;
				}
			}
			this.state.type = _type;
			this.state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "REFLEXIVE"
	// $ANTLR start "IRREFLEXIVE"
	public final void mIRREFLEXIVE() throws RecognitionException {
		try {
			int _type = IRREFLEXIVE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// MOWLLexer.g:63:13: ( ( 'I' | 'i' ) ( 'R' | 'r' ) ( 'R' | 'r' ) (
			// 'E' | 'e' ) ( 'F' | 'f' ) ( 'L' | 'l' ) ( 'E' | 'e' ) ( 'X' | 'x'
			// ) ( 'I' | 'i' ) ( 'V' | 'v' ) ( 'E' | 'e' ) ( ':' )? )
			// MOWLLexer.g:63:15: ( 'I' | 'i' ) ( 'R' | 'r' ) ( 'R' | 'r' ) (
			// 'E' | 'e' ) ( 'F' | 'f' ) ( 'L' | 'l' ) ( 'E' | 'e' ) ( 'X' | 'x'
			// ) ( 'I' | 'i' ) ( 'V' | 'v' ) ( 'E' | 'e' ) ( ':' )?
			{
				if (this.input.LA(1) == 'I' || this.input.LA(1) == 'i') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				if (this.input.LA(1) == 'R' || this.input.LA(1) == 'r') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				if (this.input.LA(1) == 'R' || this.input.LA(1) == 'r') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				if (this.input.LA(1) == 'E' || this.input.LA(1) == 'e') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				if (this.input.LA(1) == 'F' || this.input.LA(1) == 'f') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				if (this.input.LA(1) == 'L' || this.input.LA(1) == 'l') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				if (this.input.LA(1) == 'E' || this.input.LA(1) == 'e') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				if (this.input.LA(1) == 'X' || this.input.LA(1) == 'x') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				if (this.input.LA(1) == 'I' || this.input.LA(1) == 'i') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				if (this.input.LA(1) == 'V' || this.input.LA(1) == 'v') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				if (this.input.LA(1) == 'E' || this.input.LA(1) == 'e') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				// MOWLLexer.g:63:114: ( ':' )?
				int alt7 = 2;
				int LA7_0 = this.input.LA(1);
				if (LA7_0 == ':') {
					alt7 = 1;
				}
				switch (alt7) {
				case 1:
					// MOWLLexer.g:63:114: ':'
				{
					this.match(':');
				}
					break;
				}
			}
			this.state.type = _type;
			this.state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "IRREFLEXIVE"
	// $ANTLR start "TRANSITIVE"
	public final void mTRANSITIVE() throws RecognitionException {
		try {
			int _type = TRANSITIVE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// MOWLLexer.g:64:13: ( ( 'T' | 't' ) ( 'R' | 'r' ) ( 'A' | 'a' ) (
			// 'N' | 'n' ) ( 'S' | 's' ) ( 'I' | 'i' ) ( 'T' | 't' ) ( 'I' | 'i'
			// ) ( 'V' | 'v' ) ( 'E' | 'e' ) ( ':' )? )
			// MOWLLexer.g:64:15: ( 'T' | 't' ) ( 'R' | 'r' ) ( 'A' | 'a' ) (
			// 'N' | 'n' ) ( 'S' | 's' ) ( 'I' | 'i' ) ( 'T' | 't' ) ( 'I' | 'i'
			// ) ( 'V' | 'v' ) ( 'E' | 'e' ) ( ':' )?
			{
				if (this.input.LA(1) == 'T' || this.input.LA(1) == 't') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				if (this.input.LA(1) == 'R' || this.input.LA(1) == 'r') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				if (this.input.LA(1) == 'A' || this.input.LA(1) == 'a') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				if (this.input.LA(1) == 'N' || this.input.LA(1) == 'n') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				if (this.input.LA(1) == 'S' || this.input.LA(1) == 's') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				if (this.input.LA(1) == 'I' || this.input.LA(1) == 'i') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				if (this.input.LA(1) == 'T' || this.input.LA(1) == 't') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				if (this.input.LA(1) == 'I' || this.input.LA(1) == 'i') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				if (this.input.LA(1) == 'V' || this.input.LA(1) == 'v') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				if (this.input.LA(1) == 'E' || this.input.LA(1) == 'e') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				// MOWLLexer.g:64:105: ( ':' )?
				int alt8 = 2;
				int LA8_0 = this.input.LA(1);
				if (LA8_0 == ':') {
					alt8 = 1;
				}
				switch (alt8) {
				case 1:
					// MOWLLexer.g:64:105: ':'
				{
					this.match(':');
				}
					break;
				}
			}
			this.state.type = _type;
			this.state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "TRANSITIVE"
	// $ANTLR start "INVERSE_FUNCTIONAL"
	public final void mINVERSE_FUNCTIONAL() throws RecognitionException {
		try {
			int _type = INVERSE_FUNCTIONAL;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// MOWLLexer.g:65:19: ( ( 'I' | 'i' ) ( 'N' | 'n' ) ( 'V' | 'v' ) (
			// 'E' | 'e' ) ( 'R' | 'r' ) ( 'S' | 's' ) ( 'E' | 'e' ) ( 'F' | 'f'
			// ) ( 'U' | 'u' ) ( 'N' | 'n' ) ( 'C' | 'c' ) ( 'T' | 't' ) ( 'I' |
			// 'i' ) ( 'O' | 'o' ) ( 'N' | 'n' ) ( 'A' | 'a' ) ( 'L' | 'l' ) (
			// ':' )? )
			// MOWLLexer.g:65:22: ( 'I' | 'i' ) ( 'N' | 'n' ) ( 'V' | 'v' ) (
			// 'E' | 'e' ) ( 'R' | 'r' ) ( 'S' | 's' ) ( 'E' | 'e' ) ( 'F' | 'f'
			// ) ( 'U' | 'u' ) ( 'N' | 'n' ) ( 'C' | 'c' ) ( 'T' | 't' ) ( 'I' |
			// 'i' ) ( 'O' | 'o' ) ( 'N' | 'n' ) ( 'A' | 'a' ) ( 'L' | 'l' ) (
			// ':' )?
			{
				if (this.input.LA(1) == 'I' || this.input.LA(1) == 'i') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				if (this.input.LA(1) == 'N' || this.input.LA(1) == 'n') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				if (this.input.LA(1) == 'V' || this.input.LA(1) == 'v') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				if (this.input.LA(1) == 'E' || this.input.LA(1) == 'e') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				if (this.input.LA(1) == 'R' || this.input.LA(1) == 'r') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				if (this.input.LA(1) == 'S' || this.input.LA(1) == 's') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				if (this.input.LA(1) == 'E' || this.input.LA(1) == 'e') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				if (this.input.LA(1) == 'F' || this.input.LA(1) == 'f') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				if (this.input.LA(1) == 'U' || this.input.LA(1) == 'u') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				if (this.input.LA(1) == 'N' || this.input.LA(1) == 'n') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				if (this.input.LA(1) == 'C' || this.input.LA(1) == 'c') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				if (this.input.LA(1) == 'T' || this.input.LA(1) == 't') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				if (this.input.LA(1) == 'I' || this.input.LA(1) == 'i') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				if (this.input.LA(1) == 'O' || this.input.LA(1) == 'o') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				if (this.input.LA(1) == 'N' || this.input.LA(1) == 'n') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				if (this.input.LA(1) == 'A' || this.input.LA(1) == 'a') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				if (this.input.LA(1) == 'L' || this.input.LA(1) == 'l') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				// MOWLLexer.g:65:175: ( ':' )?
				int alt9 = 2;
				int LA9_0 = this.input.LA(1);
				if (LA9_0 == ':') {
					alt9 = 1;
				}
				switch (alt9) {
				case 1:
					// MOWLLexer.g:65:175: ':'
				{
					this.match(':');
				}
					break;
				}
			}
			this.state.type = _type;
			this.state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "INVERSE_FUNCTIONAL"
	// $ANTLR start "INSTANCE_OF"
	public final void mINSTANCE_OF() throws RecognitionException {
		try {
			int _type = INSTANCE_OF;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// MOWLLexer.g:66:13: ( ( 'I' | 'i' ) ( 'N' | 'n' ) ( 'S' | 's' ) (
			// 'T' | 't' ) ( 'A' | 'a' ) ( 'N' | 'n' ) ( 'C' | 'c' ) ( 'E' | 'e'
			// ) ( 'O' | 'o' ) ( 'F' | 'f' ) )
			// MOWLLexer.g:66:15: ( 'I' | 'i' ) ( 'N' | 'n' ) ( 'S' | 's' ) (
			// 'T' | 't' ) ( 'A' | 'a' ) ( 'N' | 'n' ) ( 'C' | 'c' ) ( 'E' | 'e'
			// ) ( 'O' | 'o' ) ( 'F' | 'f' )
			{
				if (this.input.LA(1) == 'I' || this.input.LA(1) == 'i') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				if (this.input.LA(1) == 'N' || this.input.LA(1) == 'n') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				if (this.input.LA(1) == 'S' || this.input.LA(1) == 's') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				if (this.input.LA(1) == 'T' || this.input.LA(1) == 't') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				if (this.input.LA(1) == 'A' || this.input.LA(1) == 'a') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				if (this.input.LA(1) == 'N' || this.input.LA(1) == 'n') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				if (this.input.LA(1) == 'C' || this.input.LA(1) == 'c') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				if (this.input.LA(1) == 'E' || this.input.LA(1) == 'e') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				if (this.input.LA(1) == 'O' || this.input.LA(1) == 'o') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				if (this.input.LA(1) == 'F' || this.input.LA(1) == 'f') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
			}
			this.state.type = _type;
			this.state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "INSTANCE_OF"
	// $ANTLR start "POW"
	public final void mPOW() throws RecognitionException {
		try {
			int _type = POW;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// MOWLLexer.g:67:5: ( '^' )
			// MOWLLexer.g:67:7: '^'
			{
				this.match('^');
			}
			this.state.type = _type;
			this.state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "POW"
	// $ANTLR start "COMMA"
	public final void mCOMMA() throws RecognitionException {
		try {
			int _type = COMMA;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// MOWLLexer.g:70:7: ( ',' )
			// MOWLLexer.g:71:5: ','
			{
				this.match(',');
			}
			this.state.type = _type;
			this.state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "COMMA"
	// $ANTLR start "OPEN_SQUARE_BRACKET"
	public final void mOPEN_SQUARE_BRACKET() throws RecognitionException {
		try {
			int _type = OPEN_SQUARE_BRACKET;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// MOWLLexer.g:81:3: ( '[' )
			// MOWLLexer.g:82:5: '['
			{
				this.match('[');
			}
			this.state.type = _type;
			this.state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "OPEN_SQUARE_BRACKET"
	// $ANTLR start "CLOSED_SQUARE_BRACKET"
	public final void mCLOSED_SQUARE_BRACKET() throws RecognitionException {
		try {
			int _type = CLOSED_SQUARE_BRACKET;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// MOWLLexer.g:86:3: ( ']' )
			// MOWLLexer.g:87:5: ']'
			{
				this.match(']');
			}
			this.state.type = _type;
			this.state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "CLOSED_SQUARE_BRACKET"
	// $ANTLR start "EQUAL"
	public final void mEQUAL() throws RecognitionException {
		try {
			int _type = EQUAL;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// MOWLLexer.g:91:3: ( '=' )
			// MOWLLexer.g:92:5: '='
			{
				this.match('=');
			}
			this.state.type = _type;
			this.state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "EQUAL"
	// $ANTLR start "DBLQUOTE"
	public final void mDBLQUOTE() throws RecognitionException {
		try {
			int _type = DBLQUOTE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// MOWLLexer.g:98:10: ( '\"' (~ '\"' | '\"\"' )* '\"' )
			// MOWLLexer.g:99:7: '\"' (~ '\"' | '\"\"' )* '\"'
			{
				this.match('\"');
				// MOWLLexer.g:100:7: (~ '\"' | '\"\"' )*
				loop10: do {
					int alt10 = 3;
					int LA10_0 = this.input.LA(1);
					if (LA10_0 == '\"') {
						int LA10_1 = this.input.LA(2);
						if (LA10_1 == '\"') {
							alt10 = 2;
						}
					} else if (LA10_0 >= '\u0000' && LA10_0 <= '!' || LA10_0 >= '#'
							&& LA10_0 <= '\uFFFF') {
						alt10 = 1;
					}
					switch (alt10) {
					case 1:
						// MOWLLexer.g:100:8: ~ '\"'
					{
						if (this.input.LA(1) >= '\u0000' && this.input.LA(1) <= '!'
								|| this.input.LA(1) >= '#' && this.input.LA(1) <= '\uFFFF') {
							this.input.consume();
						} else {
							MismatchedSetException mse = new MismatchedSetException(null,
									this.input);
							this.recover(mse);
							throw mse;
						}
					}
						break;
					case 2:
						// MOWLLexer.g:100:15: '\"\"'
					{
						this.match("\"\"");
					}
						break;
					default:
						break loop10;
					}
				} while (true);
				this.match('\"');
				String txt = this.getText();
				// Remove first and last double-quote
				if (txt.startsWith("\"")) {
					txt = txt.substring(1);
				}
				if (txt.endsWith("\"")) {
					txt = txt.substring(0, txt.length() - 1);
				}
				this.setText(txt);
			}
			this.state.type = _type;
			this.state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "DBLQUOTE"
	// $ANTLR start "IRI"
	public final void mIRI() throws RecognitionException {
		try {
			int _type = IRI;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// MOWLLexer.g:118:2: ( LESS_THAN ( LETTER | DIGIT | '-' | '_' | ':'
			// | '/' | '#' | '\\\\' | '\\?' )+ GREATER_THAN )
			// MOWLLexer.g:119:2: LESS_THAN ( LETTER | DIGIT | '-' | '_' | ':' |
			// '/' | '#' | '\\\\' | '\\?' )+ GREATER_THAN
			{
				this.mLESS_THAN();
				// MOWLLexer.g:119:11: ( LETTER | DIGIT | '-' | '_' | ':' | '/'
				// | '#' | '\\\\' | '\\?' )+
				int cnt11 = 0;
				loop11: do {
					int alt11 = 2;
					int LA11_0 = this.input.LA(1);
					if (LA11_0 == '#' || LA11_0 == '-' || LA11_0 >= '/' && LA11_0 <= ':'
							|| LA11_0 == '?' || LA11_0 >= 'A' && LA11_0 <= 'Z' || LA11_0 == '\\'
							|| LA11_0 == '_' || LA11_0 >= 'a' && LA11_0 <= 'z') {
						alt11 = 1;
					}
					switch (alt11) {
					case 1:
						// MOWLLexer.g:
					{
						if (this.input.LA(1) == '#' || this.input.LA(1) == '-'
								|| this.input.LA(1) >= '/' && this.input.LA(1) <= ':'
								|| this.input.LA(1) == '?' || this.input.LA(1) >= 'A'
								&& this.input.LA(1) <= 'Z' || this.input.LA(1) == '\\'
								|| this.input.LA(1) == '_' || this.input.LA(1) >= 'a'
								&& this.input.LA(1) <= 'z') {
							this.input.consume();
						} else {
							MismatchedSetException mse = new MismatchedSetException(null,
									this.input);
							this.recover(mse);
							throw mse;
						}
					}
						break;
					default:
						if (cnt11 >= 1) {
							break loop11;
						}
						EarlyExitException eee = new EarlyExitException(11, this.input);
						throw eee;
					}
					cnt11++;
				} while (true);
				this.mGREATER_THAN();
				// Proper parsing of the IRI should happen elsewhere
				String txt = this.getText();
				// Remove delimiters
				if (txt.startsWith("<")) {
					txt = txt.substring(1);
				}
				if (txt.endsWith(">")) {
					txt = txt.substring(0, txt.length() - 1);
				}
				this.setText(txt);
			}
			this.state.type = _type;
			this.state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "IRI"
	// $ANTLR start "LESS_THAN_EQUAL"
	public final void mLESS_THAN_EQUAL() throws RecognitionException {
		try {
			int _type = LESS_THAN_EQUAL;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// MOWLLexer.g:136:2: ( LESS_THAN EQUAL )
			// MOWLLexer.g:137:3: LESS_THAN EQUAL
			{
				this.mLESS_THAN();
				this.mEQUAL();
			}
			this.state.type = _type;
			this.state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "LESS_THAN_EQUAL"
	// $ANTLR start "LESS_THAN"
	public final void mLESS_THAN() throws RecognitionException {
		try {
			int _type = LESS_THAN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// MOWLLexer.g:140:2: ( '<' )
			// MOWLLexer.g:141:3: '<'
			{
				this.match('<');
			}
			this.state.type = _type;
			this.state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "LESS_THAN"
	// $ANTLR start "GREATER_THAN_EQUAL"
	public final void mGREATER_THAN_EQUAL() throws RecognitionException {
		try {
			int _type = GREATER_THAN_EQUAL;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// MOWLLexer.g:145:2: ( GREATER_THAN EQUAL )
			// MOWLLexer.g:146:3: GREATER_THAN EQUAL
			{
				this.mGREATER_THAN();
				this.mEQUAL();
			}
			this.state.type = _type;
			this.state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "GREATER_THAN_EQUAL"
	// $ANTLR start "GREATER_THAN"
	public final void mGREATER_THAN() throws RecognitionException {
		try {
			int _type = GREATER_THAN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// MOWLLexer.g:149:2: ( '>' )
			// MOWLLexer.g:150:3: '>'
			{
				this.match('>');
			}
			this.state.type = _type;
			this.state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "GREATER_THAN"
	// $ANTLR start "INTEGER"
	public final void mINTEGER() throws RecognitionException {
		try {
			int _type = INTEGER;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// MOWLLexer.g:153:8: ( ( DIGIT )+ )
			// MOWLLexer.g:153:10: ( DIGIT )+
			{
				// MOWLLexer.g:153:10: ( DIGIT )+
				int cnt12 = 0;
				loop12: do {
					int alt12 = 2;
					int LA12_0 = this.input.LA(1);
					if (LA12_0 >= '0' && LA12_0 <= '9') {
						alt12 = 1;
					}
					switch (alt12) {
					case 1:
						// MOWLLexer.g:153:10: DIGIT
					{
						this.mDIGIT();
					}
						break;
					default:
						if (cnt12 >= 1) {
							break loop12;
						}
						EarlyExitException eee = new EarlyExitException(12, this.input);
						throw eee;
					}
					cnt12++;
				} while (true);
			}
			this.state.type = _type;
			this.state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "INTEGER"
	// $ANTLR start "LETTER"
	public final void mLETTER() throws RecognitionException {
		try {
			// MOWLLexer.g:154:17: ( ( 'a' .. 'z' | 'A' .. 'Z' ) )
			// MOWLLexer.g:154:19: ( 'a' .. 'z' | 'A' .. 'Z' )
			{
				if (this.input.LA(1) >= 'A' && this.input.LA(1) <= 'Z' || this.input.LA(1) >= 'a'
						&& this.input.LA(1) <= 'z') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
			}
		} finally {
		}
	}

	// $ANTLR end "LETTER"
	// $ANTLR start "DIGIT"
	public final void mDIGIT() throws RecognitionException {
		try {
			// MOWLLexer.g:155:15: ( '0' .. '9' )
			// MOWLLexer.g:155:17: '0' .. '9'
			{
				this.matchRange('0', '9');
			}
		} finally {
		}
	}

	// $ANTLR end "DIGIT"
	// $ANTLR start "IDENTIFIER"
	public final void mIDENTIFIER() throws RecognitionException {
		try {
			int _type = IDENTIFIER;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// MOWLLexer.g:157:12: ( LETTER ( LETTER | DIGIT | '-' | '_' | ':'
			// )* )
			// MOWLLexer.g:157:14: LETTER ( LETTER | DIGIT | '-' | '_' | ':' )*
			{
				this.mLETTER();
				// MOWLLexer.g:157:21: ( LETTER | DIGIT | '-' | '_' | ':' )*
				loop13: do {
					int alt13 = 2;
					int LA13_0 = this.input.LA(1);
					if (LA13_0 == '-' || LA13_0 >= '0' && LA13_0 <= ':' || LA13_0 >= 'A'
							&& LA13_0 <= 'Z' || LA13_0 == '_' || LA13_0 >= 'a' && LA13_0 <= 'z') {
						alt13 = 1;
					}
					switch (alt13) {
					case 1:
						// MOWLLexer.g:
					{
						if (this.input.LA(1) == '-' || this.input.LA(1) >= '0'
								&& this.input.LA(1) <= ':' || this.input.LA(1) >= 'A'
								&& this.input.LA(1) <= 'Z' || this.input.LA(1) == '_'
								|| this.input.LA(1) >= 'a' && this.input.LA(1) <= 'z') {
							this.input.consume();
						} else {
							MismatchedSetException mse = new MismatchedSetException(null,
									this.input);
							this.recover(mse);
							throw mse;
						}
					}
						break;
					default:
						break loop13;
					}
				} while (true);
			}
			this.state.type = _type;
			this.state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "IDENTIFIER"
	// $ANTLR start "ENTITY_REFERENCE"
	public final void mENTITY_REFERENCE() throws RecognitionException {
		try {
			int _type = ENTITY_REFERENCE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// MOWLLexer.g:158:18: ( '\\'' (~ '\\'' | '\\'\\'' )* '\\'' )
			// MOWLLexer.g:159:5: '\\'' (~ '\\'' | '\\'\\'' )* '\\''
			{
				this.match('\'');
				// MOWLLexer.g:159:10: (~ '\\'' | '\\'\\'' )*
				loop14: do {
					int alt14 = 3;
					int LA14_0 = this.input.LA(1);
					if (LA14_0 == '\'') {
						int LA14_1 = this.input.LA(2);
						if (LA14_1 == '\'') {
							alt14 = 2;
						}
					} else if (LA14_0 >= '\u0000' && LA14_0 <= '&' || LA14_0 >= '('
							&& LA14_0 <= '\uFFFF') {
						alt14 = 1;
					}
					switch (alt14) {
					case 1:
						// MOWLLexer.g:159:11: ~ '\\''
					{
						if (this.input.LA(1) >= '\u0000' && this.input.LA(1) <= '&'
								|| this.input.LA(1) >= '(' && this.input.LA(1) <= '\uFFFF') {
							this.input.consume();
						} else {
							MismatchedSetException mse = new MismatchedSetException(null,
									this.input);
							this.recover(mse);
							throw mse;
						}
					}
						break;
					case 2:
						// MOWLLexer.g:159:19: '\\'\\''
					{
						this.match("''");
					}
						break;
					default:
						break loop14;
					}
				} while (true);
				this.match('\'');
				String txt = this.getText();
				// Remove first and last quote
				if (txt.startsWith("'")) {
					txt = txt.substring(1);
				}
				if (txt.endsWith("'")) {
					txt = txt.substring(0, txt.length() - 1);
				}
				this.setText(txt);
			}
			this.state.type = _type;
			this.state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "ENTITY_REFERENCE"
	@Override
	public void mTokens() throws RecognitionException {
		// MOWLLexer.g:1:8: ( COMPOSITION | OPEN_PARENTHESYS | OPEN_CURLY_BRACES
		// | CLOSED_CURLY_BRACES | CLOSED_PARENTHESYS | AT | WHITESPACE | AND |
		// OR | NOT | SOME | ONLY | MIN | MAX | EXACTLY | VALUE | INVERSE |
		// SUBCLASS_OF | SUB_PROPERTY_OF | EQUIVALENT_TO | SAME_AS |
		// DIFFERENT_FROM | INVERSE_OF | DISJOINT_WITH | DOMAIN | RANGE |
		// HAS_KEY | FUNCTIONAL | SYMMETRIC | ANTI_SYMMETRIC | TYPES | REFLEXIVE
		// | IRREFLEXIVE | TRANSITIVE | INVERSE_FUNCTIONAL | INSTANCE_OF | POW |
		// COMMA | OPEN_SQUARE_BRACKET | CLOSED_SQUARE_BRACKET | EQUAL |
		// DBLQUOTE | IRI | LESS_THAN_EQUAL | LESS_THAN | GREATER_THAN_EQUAL |
		// GREATER_THAN | INTEGER | IDENTIFIER | ENTITY_REFERENCE )
		int alt15 = 50;
		alt15 = this.dfa15.predict(this.input);
		switch (alt15) {
		case 1:
			// MOWLLexer.g:1:10: COMPOSITION
		{
			this.mCOMPOSITION();
		}
			break;
		case 2:
			// MOWLLexer.g:1:22: OPEN_PARENTHESYS
		{
			this.mOPEN_PARENTHESYS();
		}
			break;
		case 3:
			// MOWLLexer.g:1:39: OPEN_CURLY_BRACES
		{
			this.mOPEN_CURLY_BRACES();
		}
			break;
		case 4:
			// MOWLLexer.g:1:57: CLOSED_CURLY_BRACES
		{
			this.mCLOSED_CURLY_BRACES();
		}
			break;
		case 5:
			// MOWLLexer.g:1:77: CLOSED_PARENTHESYS
		{
			this.mCLOSED_PARENTHESYS();
		}
			break;
		case 6:
			// MOWLLexer.g:1:96: AT
		{
			this.mAT();
		}
			break;
		case 7:
			// MOWLLexer.g:1:99: WHITESPACE
		{
			this.mWHITESPACE();
		}
			break;
		case 8:
			// MOWLLexer.g:1:110: AND
		{
			this.mAND();
		}
			break;
		case 9:
			// MOWLLexer.g:1:114: OR
		{
			this.mOR();
		}
			break;
		case 10:
			// MOWLLexer.g:1:117: NOT
		{
			this.mNOT();
		}
			break;
		case 11:
			// MOWLLexer.g:1:121: SOME
		{
			this.mSOME();
		}
			break;
		case 12:
			// MOWLLexer.g:1:126: ONLY
		{
			this.mONLY();
		}
			break;
		case 13:
			// MOWLLexer.g:1:131: MIN
		{
			this.mMIN();
		}
			break;
		case 14:
			// MOWLLexer.g:1:135: MAX
		{
			this.mMAX();
		}
			break;
		case 15:
			// MOWLLexer.g:1:139: EXACTLY
		{
			this.mEXACTLY();
		}
			break;
		case 16:
			// MOWLLexer.g:1:147: VALUE
		{
			this.mVALUE();
		}
			break;
		case 17:
			// MOWLLexer.g:1:153: INVERSE
		{
			this.mINVERSE();
		}
			break;
		case 18:
			// MOWLLexer.g:1:161: SUBCLASS_OF
		{
			this.mSUBCLASS_OF();
		}
			break;
		case 19:
			// MOWLLexer.g:1:173: SUB_PROPERTY_OF
		{
			this.mSUB_PROPERTY_OF();
		}
			break;
		case 20:
			// MOWLLexer.g:1:189: EQUIVALENT_TO
		{
			this.mEQUIVALENT_TO();
		}
			break;
		case 21:
			// MOWLLexer.g:1:203: SAME_AS
		{
			this.mSAME_AS();
		}
			break;
		case 22:
			// MOWLLexer.g:1:211: DIFFERENT_FROM
		{
			this.mDIFFERENT_FROM();
		}
			break;
		case 23:
			// MOWLLexer.g:1:226: INVERSE_OF
		{
			this.mINVERSE_OF();
		}
			break;
		case 24:
			// MOWLLexer.g:1:237: DISJOINT_WITH
		{
			this.mDISJOINT_WITH();
		}
			break;
		case 25:
			// MOWLLexer.g:1:251: DOMAIN
		{
			this.mDOMAIN();
		}
			break;
		case 26:
			// MOWLLexer.g:1:258: RANGE
		{
			this.mRANGE();
		}
			break;
		case 27:
			// MOWLLexer.g:1:264: HAS_KEY
		{
			this.mHAS_KEY();
		}
			break;
		case 28:
			// MOWLLexer.g:1:272: FUNCTIONAL
		{
			this.mFUNCTIONAL();
		}
			break;
		case 29:
			// MOWLLexer.g:1:283: SYMMETRIC
		{
			this.mSYMMETRIC();
		}
			break;
		case 30:
			// MOWLLexer.g:1:293: ANTI_SYMMETRIC
		{
			this.mANTI_SYMMETRIC();
		}
			break;
		case 31:
			// MOWLLexer.g:1:308: TYPES
		{
			this.mTYPES();
		}
			break;
		case 32:
			// MOWLLexer.g:1:314: REFLEXIVE
		{
			this.mREFLEXIVE();
		}
			break;
		case 33:
			// MOWLLexer.g:1:324: IRREFLEXIVE
		{
			this.mIRREFLEXIVE();
		}
			break;
		case 34:
			// MOWLLexer.g:1:336: TRANSITIVE
		{
			this.mTRANSITIVE();
		}
			break;
		case 35:
			// MOWLLexer.g:1:347: INVERSE_FUNCTIONAL
		{
			this.mINVERSE_FUNCTIONAL();
		}
			break;
		case 36:
			// MOWLLexer.g:1:366: INSTANCE_OF
		{
			this.mINSTANCE_OF();
		}
			break;
		case 37:
			// MOWLLexer.g:1:378: POW
		{
			this.mPOW();
		}
			break;
		case 38:
			// MOWLLexer.g:1:382: COMMA
		{
			this.mCOMMA();
		}
			break;
		case 39:
			// MOWLLexer.g:1:388: OPEN_SQUARE_BRACKET
		{
			this.mOPEN_SQUARE_BRACKET();
		}
			break;
		case 40:
			// MOWLLexer.g:1:408: CLOSED_SQUARE_BRACKET
		{
			this.mCLOSED_SQUARE_BRACKET();
		}
			break;
		case 41:
			// MOWLLexer.g:1:430: EQUAL
		{
			this.mEQUAL();
		}
			break;
		case 42:
			// MOWLLexer.g:1:436: DBLQUOTE
		{
			this.mDBLQUOTE();
		}
			break;
		case 43:
			// MOWLLexer.g:1:445: IRI
		{
			this.mIRI();
		}
			break;
		case 44:
			// MOWLLexer.g:1:449: LESS_THAN_EQUAL
		{
			this.mLESS_THAN_EQUAL();
		}
			break;
		case 45:
			// MOWLLexer.g:1:465: LESS_THAN
		{
			this.mLESS_THAN();
		}
			break;
		case 46:
			// MOWLLexer.g:1:475: GREATER_THAN_EQUAL
		{
			this.mGREATER_THAN_EQUAL();
		}
			break;
		case 47:
			// MOWLLexer.g:1:494: GREATER_THAN
		{
			this.mGREATER_THAN();
		}
			break;
		case 48:
			// MOWLLexer.g:1:507: INTEGER
		{
			this.mINTEGER();
		}
			break;
		case 49:
			// MOWLLexer.g:1:515: IDENTIFIER
		{
			this.mIDENTIFIER();
		}
			break;
		case 50:
			// MOWLLexer.g:1:526: ENTITY_REFERENCE
		{
			this.mENTITY_REFERENCE();
		}
			break;
		}
	}

	protected DFA15 dfa15 = new DFA15(this);
	static final String DFA15_eotS = "\1\uffff\1\42\6\uffff\15\36\6\uffff\1\72\1\75\3\uffff\1\77\1\36"
			+ "\1\uffff\27\36\6\uffff\1\36\1\133\2\36\1\136\4\36\1\144\1\145\3"
			+ "\36\1\152\13\36\1\166\1\uffff\2\36\1\uffff\1\170\4\36\2\uffff\4"
			+ "\36\1\uffff\11\36\1\u008a\1\36\1\uffff\1\36\1\uffff\6\36\1\u0094"
			+ "\6\36\1\u009b\3\36\1\uffff\1\u008a\4\36\1\u00a3\3\36\1\uffff\5\36"
			+ "\1\u00ac\1\uffff\1\36\1\u00ae\5\36\1\uffff\1\36\1\u00b5\6\36\1\uffff"
			+ "\1\36\1\uffff\6\36\1\uffff\15\36\1\u00d1\1\36\1\u00d4\5\36\1\u00db"
			+ "\2\36\1\u00de\1\u00e0\1\36\1\uffff\1\u00d1\1\36\1\uffff\1\36\1\u00e4"
			+ "\3\36\1\u00db\1\uffff\1\u00e8\1\u00ea\1\uffff\1\u00de\1\uffff\3"
			+ "\36\1\uffff\1\u00ef\2\36\1\uffff\1\u00e8\1\uffff\1\u00ea\1\36\1"
			+ "\u00f4\1\36\1\uffff\1\u00ef\1\36\1\u00f7\1\u00f8\1\uffff\1\36\1"
			+ "\u00fa\2\uffff\1\36\1\uffff\2\36\1\u00fe\1\uffff\1\u00fe";
	static final String DFA15_eofS = "\u0100\uffff";
	static final String DFA15_minS = "\1\11\1\55\6\uffff\2\116\1\117\2\101\1\121\1\101\1\116\1\111\2\101"
			+ "\1\125\1\122\6\uffff\1\43\1\75\3\uffff\1\55\1\114\1\uffff\1\104"
			+ "\1\171\1\104\1\124\1\115\1\102\2\115\1\116\1\130\1\101\1\125\1\114"
			+ "\1\123\1\122\1\106\1\115\1\116\1\106\1\123\1\116\1\120\1\101\6\uffff"
			+ "\1\131\1\55\1\151\1\155\1\55\1\105\1\103\1\105\1\115\2\55\1\103"
			+ "\1\111\1\125\1\55\1\124\1\105\1\106\1\112\1\101\1\107\1\114\1\113"
			+ "\1\103\1\105\1\116\1\55\1\uffff\1\123\1\155\1\uffff\1\55\1\114\1"
			+ "\122\1\101\1\105\2\uffff\1\124\1\126\1\105\1\122\1\uffff\1\101\1"
			+ "\106\1\105\1\117\1\111\3\105\1\124\1\55\1\123\1\uffff\1\145\1\uffff"
			+ "\1\101\1\117\1\123\1\124\1\114\1\101\1\55\1\123\1\116\1\114\1\122"
			+ "\1\111\1\116\1\55\1\130\1\131\1\111\1\uffff\1\55\1\111\1\164\1\123"
			+ "\1\120\1\55\1\122\1\131\1\114\1\uffff\1\105\1\103\2\105\1\116\1"
			+ "\55\1\uffff\1\111\1\55\1\117\1\124\1\162\1\123\1\105\1\uffff\1\111"
			+ "\1\55\1\105\1\106\1\105\1\130\1\116\1\124\1\uffff\1\126\1\uffff"
			+ "\1\116\1\111\1\151\1\117\1\122\1\103\1\uffff\1\116\1\106\1\125\1"
			+ "\117\1\111\1\124\1\127\1\105\1\101\1\126\1\143\1\106\1\124\1\55"
			+ "\1\124\1\55\1\116\1\106\1\126\1\106\1\111\1\55\1\114\1\105\2\55"
			+ "\1\131\1\uffff\1\55\1\124\1\uffff\1\103\1\55\1\105\1\122\1\124\1"
			+ "\55\1\uffff\2\55\1\uffff\1\55\1\uffff\2\117\1\124\1\uffff\1\55\1"
			+ "\117\1\110\1\uffff\1\55\1\uffff\1\55\1\106\1\55\1\111\1\uffff\1"
			+ "\55\1\115\2\55\1\uffff\1\117\1\55\2\uffff\1\116\1\uffff\1\101\1"
			+ "\114\1\55\1\uffff\1\55";
	static final String DFA15_maxS = "\1\175\1\172\6\uffff\1\163\1\162\1\157\1\171\1\151\1\170\1\141\1"
			+ "\162\1\157\1\145\1\141\1\165\1\171\6\uffff\1\172\1\75\3\uffff\1"
			+ "\172\1\154\1\uffff\1\164\1\171\1\144\1\164\1\155\1\142\2\155\1\156"
			+ "\1\170\1\141\1\165\1\154\1\166\1\162\1\163\1\155\1\156\1\146\1\163"
			+ "\1\156\1\160\1\141\6\uffff\1\171\1\172\1\151\1\155\1\172\1\145\1"
			+ "\160\1\145\1\155\2\172\1\143\1\151\1\165\1\172\1\164\1\145\1\146"
			+ "\1\152\1\141\1\147\1\154\1\153\1\143\1\145\1\156\1\172\1\uffff\1"
			+ "\163\1\155\1\uffff\1\172\1\154\1\162\1\141\1\145\2\uffff\1\164\1"
			+ "\166\1\145\1\162\1\uffff\1\141\1\146\1\145\1\157\1\151\3\145\1\164"
			+ "\1\172\1\163\1\uffff\1\145\1\uffff\1\141\1\157\1\163\1\164\1\154"
			+ "\1\141\1\172\1\163\1\156\1\154\1\162\1\151\1\156\1\172\1\170\1\171"
			+ "\1\151\1\uffff\1\172\1\151\1\164\1\163\1\160\1\172\1\162\1\171\1"
			+ "\154\1\uffff\1\145\1\143\2\145\1\156\1\172\1\uffff\1\151\1\172\1"
			+ "\157\1\164\1\162\1\163\1\145\1\uffff\1\151\1\172\1\145\1\157\1\145"
			+ "\1\170\1\156\1\164\1\uffff\1\166\1\uffff\1\156\2\151\1\157\1\162"
			+ "\1\143\1\uffff\1\156\1\146\1\165\1\157\1\151\1\164\1\167\1\145\1"
			+ "\141\1\166\1\143\1\146\1\164\1\172\1\164\1\172\1\156\1\146\1\166"
			+ "\1\146\1\151\1\172\1\154\1\145\2\172\1\171\1\uffff\1\172\1\164\1"
			+ "\uffff\1\143\1\172\1\145\1\162\1\164\1\172\1\uffff\2\172\1\uffff"
			+ "\1\172\1\uffff\2\157\1\164\1\uffff\1\172\1\157\1\150\1\uffff\1\172"
			+ "\1\uffff\1\172\1\146\1\172\1\151\1\uffff\1\172\1\155\2\172\1\uffff"
			+ "\1\157\1\172\2\uffff\1\156\1\uffff\1\141\1\154\1\172\1\uffff\1\172";
	static final String DFA15_acceptS = "\2\uffff\1\2\1\3\1\4\1\5\1\6\1\7\15\uffff\1\45\1\46\1\47\1\50\1"
			+ "\51\1\52\2\uffff\1\60\1\61\1\62\2\uffff\1\1\27\uffff\1\55\1\53\1"
			+ "\54\1\57\1\56\1\11\33\uffff\1\10\2\uffff\1\12\5\uffff\1\15\1\16"
			+ "\4\uffff\1\21\13\uffff\1\14\1\uffff\1\13\21\uffff\1\37\11\uffff"
			+ "\1\20\6\uffff\1\32\7\uffff\1\25\10\uffff\1\31\1\uffff\1\33\6\uffff"
			+ "\1\17\33\uffff\1\35\2\uffff\1\27\6\uffff\1\40\2\uffff\1\36\1\uffff"
			+ "\1\22\3\uffff\1\44\3\uffff\1\34\1\uffff\1\42\4\uffff\1\41\4\uffff"
			+ "\1\24\2\uffff\1\30\1\23\1\uffff\1\26\3\uffff\1\43\1\uffff";
	static final String DFA15_specialS = "\u0100\uffff}>";
	static final String[] DFA15_transitionS = {
			"\2\7\2\uffff\1\7\22\uffff\1\7\1\uffff\1\32\4\uffff\1\37\1\2"
					+ "\1\5\2\uffff\1\26\3\uffff\12\35\2\uffff\1\33\1\31\1\34\1\uffff"
					+ "\1\6\1\10\2\36\1\20\1\15\1\23\1\36\1\22\1\17\3\36\1\14\1\12"
					+ "\1\11\2\36\1\21\1\13\1\24\1\36\1\16\4\36\1\27\1\uffff\1\30\1"
					+ "\25\2\uffff\1\10\2\36\1\20\1\15\1\23\1\36\1\22\1\17\3\36\1\14"
					+ "\1\12\1\1\2\36\1\21\1\13\1\24\1\36\1\16\4\36\1\3\1\uffff\1\4",
			"\1\36\2\uffff\13\36\6\uffff\15\36\1\41\3\36\1\40\10\36\4\uffff"
					+ "\1\36\1\uffff\15\36\1\41\3\36\1\40\10\36",
			"",
			"",
			"",
			"",
			"",
			"",
			"\1\45\4\uffff\1\44\32\uffff\1\43\4\uffff\1\44",
			"\1\41\3\uffff\1\40\33\uffff\1\41\3\uffff\1\40",
			"\1\46\37\uffff\1\46",
			"\1\51\15\uffff\1\47\5\uffff\1\50\3\uffff\1\52\7\uffff\1\51"
					+ "\15\uffff\1\47\5\uffff\1\50\3\uffff\1\52",
			"\1\54\7\uffff\1\53\27\uffff\1\54\7\uffff\1\53",
			"\1\56\6\uffff\1\55\30\uffff\1\56\6\uffff\1\55",
			"\1\57\37\uffff\1\57",
			"\1\60\3\uffff\1\61\33\uffff\1\60\3\uffff\1\61",
			"\1\62\5\uffff\1\63\31\uffff\1\62\5\uffff\1\63",
			"\1\64\3\uffff\1\65\33\uffff\1\64\3\uffff\1\65",
			"\1\66\37\uffff\1\66",
			"\1\67\37\uffff\1\67",
			"\1\71\6\uffff\1\70\30\uffff\1\71\6\uffff\1\70",
			"",
			"",
			"",
			"",
			"",
			"",
			"\1\73\11\uffff\1\73\1\uffff\14\73\2\uffff\1\74\1\uffff\1\73"
					+ "\1\uffff\32\73\1\uffff\1\73\2\uffff\1\73\1\uffff\32\73",
			"\1\76",
			"",
			"",
			"",
			"\1\36\2\uffff\13\36\6\uffff\32\36\4\uffff\1\36\1\uffff\32\36",
			"\1\100\37\uffff\1\100",
			"",
			"\1\101\37\uffff\1\101\17\uffff\1\102",
			"\1\103",
			"\1\101\37\uffff\1\101",
			"\1\104\37\uffff\1\104",
			"\1\105\37\uffff\1\105",
			"\1\106\37\uffff\1\106",
			"\1\107\37\uffff\1\107",
			"\1\110\37\uffff\1\110",
			"\1\111\37\uffff\1\111",
			"\1\112\37\uffff\1\112",
			"\1\113\37\uffff\1\113",
			"\1\114\37\uffff\1\114",
			"\1\115\37\uffff\1\115",
			"\1\117\2\uffff\1\116\34\uffff\1\117\2\uffff\1\116",
			"\1\120\37\uffff\1\120",
			"\1\121\14\uffff\1\122\22\uffff\1\121\14\uffff\1\122",
			"\1\123\37\uffff\1\123",
			"\1\124\37\uffff\1\124",
			"\1\125\37\uffff\1\125",
			"\1\126\37\uffff\1\126",
			"\1\127\37\uffff\1\127",
			"\1\130\37\uffff\1\130",
			"\1\131\37\uffff\1\131",
			"",
			"",
			"",
			"",
			"",
			"",
			"\1\132\37\uffff\1\132",
			"\1\36\2\uffff\13\36\6\uffff\32\36\4\uffff\1\36\1\uffff\32\36",
			"\1\134",
			"\1\135",
			"\1\36\2\uffff\13\36\6\uffff\32\36\4\uffff\1\36\1\uffff\32\36",
			"\1\137\37\uffff\1\137",
			"\1\140\14\uffff\1\141\22\uffff\1\140\14\uffff\1\141",
			"\1\142\37\uffff\1\142",
			"\1\143\37\uffff\1\143",
			"\1\36\2\uffff\13\36\6\uffff\32\36\4\uffff\1\36\1\uffff\32\36",
			"\1\36\2\uffff\13\36\6\uffff\32\36\4\uffff\1\36\1\uffff\32\36",
			"\1\146\37\uffff\1\146",
			"\1\147\37\uffff\1\147",
			"\1\150\37\uffff\1\150",
			"\1\36\2\uffff\13\36\6\uffff\4\36\1\151\25\36\4\uffff\1\36\1"
					+ "\uffff\4\36\1\151\25\36",
			"\1\153\37\uffff\1\153",
			"\1\154\37\uffff\1\154",
			"\1\155\37\uffff\1\155",
			"\1\156\37\uffff\1\156",
			"\1\157\37\uffff\1\157",
			"\1\160\37\uffff\1\160",
			"\1\161\37\uffff\1\161",
			"\1\162\37\uffff\1\162",
			"\1\163\37\uffff\1\163",
			"\1\164\37\uffff\1\164",
			"\1\165\37\uffff\1\165",
			"\1\36\2\uffff\13\36\6\uffff\32\36\4\uffff\1\36\1\uffff\32\36",
			"",
			"\1\44\37\uffff\1\44",
			"\1\167",
			"",
			"\1\36\2\uffff\13\36\6\uffff\32\36\4\uffff\1\36\1\uffff\32\36",
			"\1\171\37\uffff\1\171",
			"\1\172\37\uffff\1\172",
			"\1\173\37\uffff\1\173",
			"\1\174\37\uffff\1\174",
			"",
			"",
			"\1\175\37\uffff\1\175",
			"\1\176\37\uffff\1\176",
			"\1\177\37\uffff\1\177",
			"\1\u0080\37\uffff\1\u0080",
			"",
			"\1\u0081\37\uffff\1\u0081",
			"\1\u0082\37\uffff\1\u0082",
			"\1\u0083\37\uffff\1\u0083",
			"\1\u0084\37\uffff\1\u0084",
			"\1\u0085\37\uffff\1\u0085",
			"\1\u0086\37\uffff\1\u0086",
			"\1\u0087\37\uffff\1\u0087",
			"\1\u0088\37\uffff\1\u0088",
			"\1\u0089\37\uffff\1\u0089",
			"\1\36\2\uffff\13\36\6\uffff\22\36\1\u008b\7\36\4\uffff\1\36"
					+ "\1\uffff\22\36\1\u008b\7\36", "\1\u008c\37\uffff\1\u008c", "", "\1\u008d",
			"", "\1\u008e\37\uffff\1\u008e", "\1\u008f\37\uffff\1\u008f",
			"\1\u0090\37\uffff\1\u0090", "\1\u0091\37\uffff\1\u0091", "\1\u0092\37\uffff\1\u0092",
			"\1\u0093\37\uffff\1\u0093",
			"\1\36\2\uffff\13\36\6\uffff\32\36\4\uffff\1\36\1\uffff\32\36",
			"\1\u0095\37\uffff\1\u0095", "\1\u0096\37\uffff\1\u0096", "\1\u0097\37\uffff\1\u0097",
			"\1\u0098\37\uffff\1\u0098", "\1\u0099\37\uffff\1\u0099", "\1\u009a\37\uffff\1\u009a",
			"\1\36\2\uffff\13\36\6\uffff\32\36\4\uffff\1\36\1\uffff\32\36",
			"\1\u009c\37\uffff\1\u009c", "\1\u009d\37\uffff\1\u009d", "\1\u009e\37\uffff\1\u009e",
			"", "\1\36\2\uffff\13\36\6\uffff\32\36\4\uffff\1\36\1\uffff\32\36",
			"\1\u009f\37\uffff\1\u009f", "\1\u00a0", "\1\u00a1\37\uffff\1\u00a1",
			"\1\u00a2\37\uffff\1\u00a2",
			"\1\36\2\uffff\13\36\6\uffff\32\36\4\uffff\1\36\1\uffff\32\36",
			"\1\u00a4\37\uffff\1\u00a4", "\1\u00a5\37\uffff\1\u00a5", "\1\u00a6\37\uffff\1\u00a6",
			"", "\1\u00a7\37\uffff\1\u00a7", "\1\u00a8\37\uffff\1\u00a8",
			"\1\u00a9\37\uffff\1\u00a9", "\1\u00aa\37\uffff\1\u00aa", "\1\u00ab\37\uffff\1\u00ab",
			"\1\36\2\uffff\13\36\6\uffff\32\36\4\uffff\1\36\1\uffff\32\36", "",
			"\1\u00ad\37\uffff\1\u00ad",
			"\1\36\2\uffff\13\36\6\uffff\32\36\4\uffff\1\36\1\uffff\32\36",
			"\1\u00af\37\uffff\1\u00af", "\1\u00b0\37\uffff\1\u00b0", "\1\u00b1",
			"\1\u00b2\37\uffff\1\u00b2", "\1\u00b3\37\uffff\1\u00b3", "",
			"\1\u00b4\37\uffff\1\u00b4",
			"\1\36\2\uffff\13\36\6\uffff\32\36\4\uffff\1\36\1\uffff\32\36",
			"\1\u00b6\37\uffff\1\u00b6",
			"\1\u00b8\10\uffff\1\u00b7\26\uffff\1\u00b8\10\uffff\1\u00b7",
			"\1\u00b9\37\uffff\1\u00b9", "\1\u00ba\37\uffff\1\u00ba", "\1\u00bb\37\uffff\1\u00bb",
			"\1\u00bc\37\uffff\1\u00bc", "", "\1\u00bd\37\uffff\1\u00bd", "",
			"\1\u00be\37\uffff\1\u00be", "\1\u00bf\37\uffff\1\u00bf", "\1\u00c0",
			"\1\u00c1\37\uffff\1\u00c1", "\1\u00c2\37\uffff\1\u00c2", "\1\u00c3\37\uffff\1\u00c3",
			"", "\1\u00c4\37\uffff\1\u00c4", "\1\u00c5\37\uffff\1\u00c5",
			"\1\u00c6\37\uffff\1\u00c6", "\1\u00c7\37\uffff\1\u00c7", "\1\u00c8\37\uffff\1\u00c8",
			"\1\u00c9\37\uffff\1\u00c9", "\1\u00ca\37\uffff\1\u00ca", "\1\u00cb\37\uffff\1\u00cb",
			"\1\u00cc\37\uffff\1\u00cc", "\1\u00cd\37\uffff\1\u00cd", "\1\u00ce",
			"\1\u00cf\37\uffff\1\u00cf", "\1\u00d0\37\uffff\1\u00d0",
			"\1\36\2\uffff\12\36\1\u00d2\6\uffff\32\36\4\uffff\1\36\1\uffff" + "\32\36",
			"\1\u00d3\37\uffff\1\u00d3",
			"\1\36\2\uffff\13\36\6\uffff\32\36\4\uffff\1\36\1\uffff\32\36",
			"\1\u00d5\37\uffff\1\u00d5", "\1\u00d6\37\uffff\1\u00d6", "\1\u00d7\37\uffff\1\u00d7",
			"\1\u00d8\37\uffff\1\u00d8", "\1\u00d9\37\uffff\1\u00d9",
			"\1\36\2\uffff\12\36\1\u00da\6\uffff\32\36\4\uffff\1\36\1\uffff" + "\32\36",
			"\1\u00dc\37\uffff\1\u00dc", "\1\u00dd\37\uffff\1\u00dd",
			"\1\36\2\uffff\12\36\1\u00df\6\uffff\32\36\4\uffff\1\36\1\uffff" + "\32\36",
			"\1\36\2\uffff\13\36\6\uffff\32\36\4\uffff\1\36\1\uffff\32\36",
			"\1\u00e1\37\uffff\1\u00e1", "",
			"\1\36\2\uffff\13\36\6\uffff\32\36\4\uffff\1\36\1\uffff\32\36",
			"\1\u00e2\37\uffff\1\u00e2", "", "\1\u00e3\37\uffff\1\u00e3",
			"\1\36\2\uffff\13\36\6\uffff\32\36\4\uffff\1\36\1\uffff\32\36",
			"\1\u00e5\37\uffff\1\u00e5", "\1\u00e6\37\uffff\1\u00e6", "\1\u00e7\37\uffff\1\u00e7",
			"\1\36\2\uffff\13\36\6\uffff\32\36\4\uffff\1\36\1\uffff\32\36", "",
			"\1\36\2\uffff\12\36\1\u00e9\6\uffff\32\36\4\uffff\1\36\1\uffff" + "\32\36",
			"\1\36\2\uffff\12\36\1\u00eb\6\uffff\32\36\4\uffff\1\36\1\uffff" + "\32\36", "",
			"\1\36\2\uffff\13\36\6\uffff\32\36\4\uffff\1\36\1\uffff\32\36", "",
			"\1\u00ec\37\uffff\1\u00ec", "\1\u00ed\37\uffff\1\u00ed", "\1\u00ee\37\uffff\1\u00ee",
			"", "\1\36\2\uffff\12\36\1\u00f0\6\uffff\32\36\4\uffff\1\36\1\uffff" + "\32\36",
			"\1\u00f1\37\uffff\1\u00f1", "\1\u00f2\37\uffff\1\u00f2", "",
			"\1\36\2\uffff\13\36\6\uffff\32\36\4\uffff\1\36\1\uffff\32\36", "",
			"\1\36\2\uffff\13\36\6\uffff\32\36\4\uffff\1\36\1\uffff\32\36",
			"\1\u00f3\37\uffff\1\u00f3",
			"\1\36\2\uffff\13\36\6\uffff\32\36\4\uffff\1\36\1\uffff\32\36",
			"\1\u00f5\37\uffff\1\u00f5", "",
			"\1\36\2\uffff\13\36\6\uffff\32\36\4\uffff\1\36\1\uffff\32\36",
			"\1\u00f6\37\uffff\1\u00f6",
			"\1\36\2\uffff\13\36\6\uffff\32\36\4\uffff\1\36\1\uffff\32\36",
			"\1\36\2\uffff\13\36\6\uffff\32\36\4\uffff\1\36\1\uffff\32\36", "",
			"\1\u00f9\37\uffff\1\u00f9",
			"\1\36\2\uffff\13\36\6\uffff\32\36\4\uffff\1\36\1\uffff\32\36", "", "",
			"\1\u00fb\37\uffff\1\u00fb", "", "\1\u00fc\37\uffff\1\u00fc",
			"\1\u00fd\37\uffff\1\u00fd",
			"\1\36\2\uffff\12\36\1\u00ff\6\uffff\32\36\4\uffff\1\36\1\uffff" + "\32\36", "",
			"\1\36\2\uffff\13\36\6\uffff\32\36\4\uffff\1\36\1\uffff\32\36" };
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
			return "1:1: Tokens : ( COMPOSITION | OPEN_PARENTHESYS | OPEN_CURLY_BRACES | CLOSED_CURLY_BRACES | CLOSED_PARENTHESYS | AT | WHITESPACE | AND | OR | NOT | SOME | ONLY | MIN | MAX | EXACTLY | VALUE | INVERSE | SUBCLASS_OF | SUB_PROPERTY_OF | EQUIVALENT_TO | SAME_AS | DIFFERENT_FROM | INVERSE_OF | DISJOINT_WITH | DOMAIN | RANGE | HAS_KEY | FUNCTIONAL | SYMMETRIC | ANTI_SYMMETRIC | TYPES | REFLEXIVE | IRREFLEXIVE | TRANSITIVE | INVERSE_FUNCTIONAL | INSTANCE_OF | POW | COMMA | OPEN_SQUARE_BRACKET | CLOSED_SQUARE_BRACKET | EQUAL | DBLQUOTE | IRI | LESS_THAN_EQUAL | LESS_THAN | GREATER_THAN_EQUAL | GREATER_THAN | INTEGER | IDENTIFIER | ENTITY_REFERENCE );";
		}
	}
}