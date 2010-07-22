package org.coode.parsers.oppl;

// $ANTLR 3.2 Sep 23, 2009 12:02:23 /Users/luigi/Documents/workspace/Parsers/src/OPPLLexer.g 2010-07-13 16:39:00
import org.antlr.runtime.BaseRecognizer;
import org.antlr.runtime.CharStream;
import org.antlr.runtime.DFA;
import org.antlr.runtime.Lexer;
import org.antlr.runtime.MismatchedSetException;
import org.antlr.runtime.NoViableAltException;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.RecognizerSharedState;

public class OPPLLexer extends Lexer {
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
	public static final int CREATE = 80;
	public static final int POW = 36;
	public static final int NOT_EQUAL = 72;
	public static final int INVERSE_OBJECT_PROPERTY_EXPRESSION = 68;
	public static final int INSTANCE_OF = 38;
	public static final int BEGIN = 83;
	public static final int QUESTION_MARK = 46;
	public static final int SYMMETRIC = 30;
	public static final int CARDINALITY_RESTRICTION = 64;
	public static final int SELECT = 75;
	public static final int ROLE_ASSERTION = 67;
	public static final int DIFFERENT_FROM_AXIOM = 53;
	public static final int TRANSITIVE = 34;
	public static final int ANTI_SYMMETRIC = 31;
	public static final int ALL_RESTRICTION = 62;
	public static final int CONJUNCTION = 56;
	public static final int NEGATED_ASSERTION = 59;
	public static final int WHITESPACE = 9;
	public static final int MATCH = 176;
	public static final int VALUE = 18;
	public static final int GROUPS = 356;
	public static final int OPEN_CURLY_BRACES = 6;
	public static final int DISJUNCTION = 55;
	public static final int INVERSE = 19;
	public static final int DBLQUOTE = 40;
	public static final int OR = 11;
	public static final int CONSTANT = 70;
	public static final int ENTITY_REFERENCE = 45;
	public static final int END = 84;
	public static final int COMPOSITION = 4;
	public static final int CLOSED_SQUARE_BRACKET = 86;
	public static final int SAME_AS = 23;
	public static final int WHERE = 71;
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
	public static final int EXACTLY = 17;
	public static final int SUB_PROPERTY_AXIOM = 51;
	public static final int OPEN_SQUARE_BRACKET = 85;
	public static final int VALUES = 354;
	public static final int RANGE = 28;
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
	public static final int IRREFLEXIVE = 33;
	public static final int ASSERTED = 76;
	public static final int FUNCTIONAL = 29;
	public static final int PROPERTY_CHAIN = 57;
	public static final int TYPE_ASSERTION = 66;
	// delegates
	public OPPLLexer_MOWLLexer gMOWLLexer;

	// delegators
	public OPPLLexer() {
		;
	}

	public OPPLLexer(CharStream input) {
		this(input, new RecognizerSharedState());
	}

	public OPPLLexer(CharStream input, RecognizerSharedState state) {
		super(input, state);
		this.gMOWLLexer = new OPPLLexer_MOWLLexer(input, state, this);
	}

	@Override
	public String getGrammarFileName() {
		return "/Users/luigi/Documents/workspace/Parsers/src/OPPLLexer.g";
	}

	// $ANTLR start "VARIABLE_TYPE"
	public final void mVARIABLE_TYPE() throws RecognitionException {
		try {
			int _type = VARIABLE_TYPE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/luigi/Documents/workspace/Parsers/src/OPPLLexer.g:14:3: (
			// 'CLASS' | 'OBJECTPROPERTY' | 'DATAPROPERTY' | 'INDIVIDUAL' |
			// 'CONSTANT' )
			int alt1 = 5;
			switch (this.input.LA(1)) {
			case 'C': {
				int LA1_1 = this.input.LA(2);
				if (LA1_1 == 'L') {
					alt1 = 1;
				} else if (LA1_1 == 'O') {
					alt1 = 5;
				} else {
					NoViableAltException nvae = new NoViableAltException("", 1, 1, this.input);
					throw nvae;
				}
			}
				break;
			case 'O': {
				alt1 = 2;
			}
				break;
			case 'D': {
				alt1 = 3;
			}
				break;
			case 'I': {
				alt1 = 4;
			}
				break;
			default:
				NoViableAltException nvae = new NoViableAltException("", 1, 0, this.input);
				throw nvae;
			}
			switch (alt1) {
			case 1:
				// /Users/luigi/Documents/workspace/Parsers/src/OPPLLexer.g:15:7:
				// 'CLASS'
			{
				this.match("CLASS");
			}
				break;
			case 2:
				// /Users/luigi/Documents/workspace/Parsers/src/OPPLLexer.g:16:7:
				// 'OBJECTPROPERTY'
			{
				this.match("OBJECTPROPERTY");
			}
				break;
			case 3:
				// /Users/luigi/Documents/workspace/Parsers/src/OPPLLexer.g:17:7:
				// 'DATAPROPERTY'
			{
				this.match("DATAPROPERTY");
			}
				break;
			case 4:
				// /Users/luigi/Documents/workspace/Parsers/src/OPPLLexer.g:18:7:
				// 'INDIVIDUAL'
			{
				this.match("INDIVIDUAL");
			}
				break;
			case 5:
				// /Users/luigi/Documents/workspace/Parsers/src/OPPLLexer.g:19:7:
				// 'CONSTANT'
			{
				this.match("CONSTANT");
			}
				break;
			}
			this.state.type = _type;
			this.state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "VARIABLE_TYPE"
	// $ANTLR start "ADD"
	public final void mADD() throws RecognitionException {
		try {
			int _type = ADD;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/luigi/Documents/workspace/Parsers/src/OPPLLexer.g:28:3: (
			// 'ADD' )
			// /Users/luigi/Documents/workspace/Parsers/src/OPPLLexer.g:29:5:
			// 'ADD'
			{
				this.match("ADD");
			}
			this.state.type = _type;
			this.state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "ADD"
	// $ANTLR start "REMOVE"
	public final void mREMOVE() throws RecognitionException {
		try {
			int _type = REMOVE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/luigi/Documents/workspace/Parsers/src/OPPLLexer.g:33:3: (
			// 'REMOVE' )
			// /Users/luigi/Documents/workspace/Parsers/src/OPPLLexer.g:34:5:
			// 'REMOVE'
			{
				this.match("REMOVE");
			}
			this.state.type = _type;
			this.state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "REMOVE"
	// $ANTLR start "WHERE"
	public final void mWHERE() throws RecognitionException {
		try {
			int _type = WHERE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/luigi/Documents/workspace/Parsers/src/OPPLLexer.g:38:3: (
			// 'WHERE' )
			// /Users/luigi/Documents/workspace/Parsers/src/OPPLLexer.g:39:5:
			// 'WHERE'
			{
				this.match("WHERE");
			}
			this.state.type = _type;
			this.state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "WHERE"
	// $ANTLR start "NOT_EQUAL"
	public final void mNOT_EQUAL() throws RecognitionException {
		try {
			int _type = NOT_EQUAL;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/luigi/Documents/workspace/Parsers/src/OPPLLexer.g:43:3: (
			// '!=' )
			// /Users/luigi/Documents/workspace/Parsers/src/OPPLLexer.g:44:5:
			// '!='
			{
				this.match("!=");
			}
			this.state.type = _type;
			this.state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "NOT_EQUAL"
	// $ANTLR start "EQUAL"
	public final void mEQUAL() throws RecognitionException {
		try {
			int _type = EQUAL;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/luigi/Documents/workspace/Parsers/src/OPPLLexer.g:48:3: (
			// '=' )
			// /Users/luigi/Documents/workspace/Parsers/src/OPPLLexer.g:49:5:
			// '='
			{
				this.match('=');
			}
			this.state.type = _type;
			this.state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "EQUAL"
	// $ANTLR start "IN"
	public final void mIN() throws RecognitionException {
		try {
			int _type = IN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/luigi/Documents/workspace/Parsers/src/OPPLLexer.g:53:3: (
			// 'IN' )
			// /Users/luigi/Documents/workspace/Parsers/src/OPPLLexer.g:54:5:
			// 'IN'
			{
				this.match("IN");
			}
			this.state.type = _type;
			this.state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "IN"
	// $ANTLR start "SELECT"
	public final void mSELECT() throws RecognitionException {
		try {
			int _type = SELECT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/luigi/Documents/workspace/Parsers/src/OPPLLexer.g:58:3: (
			// 'SELECT' )
			// /Users/luigi/Documents/workspace/Parsers/src/OPPLLexer.g:59:5:
			// 'SELECT'
			{
				this.match("SELECT");
			}
			this.state.type = _type;
			this.state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "SELECT"
	// $ANTLR start "ASSERTED"
	public final void mASSERTED() throws RecognitionException {
		try {
			int _type = ASSERTED;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/luigi/Documents/workspace/Parsers/src/OPPLLexer.g:63:3: (
			// 'ASSERTED' )
			// /Users/luigi/Documents/workspace/Parsers/src/OPPLLexer.g:64:5:
			// 'ASSERTED'
			{
				this.match("ASSERTED");
			}
			this.state.type = _type;
			this.state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "ASSERTED"
	// $ANTLR start "COLON"
	public final void mCOLON() throws RecognitionException {
		try {
			int _type = COLON;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/luigi/Documents/workspace/Parsers/src/OPPLLexer.g:68:3: (
			// ':' )
			// /Users/luigi/Documents/workspace/Parsers/src/OPPLLexer.g:69:5:
			// ':'
			{
				this.match(':');
			}
			this.state.type = _type;
			this.state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "COLON"
	// $ANTLR start "DOT"
	public final void mDOT() throws RecognitionException {
		try {
			int _type = DOT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/luigi/Documents/workspace/Parsers/src/OPPLLexer.g:73:3: (
			// '.' )
			// /Users/luigi/Documents/workspace/Parsers/src/OPPLLexer.g:74:5:
			// '.'
			{
				this.match('.');
			}
			this.state.type = _type;
			this.state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "DOT"
	// $ANTLR start "PLUS"
	public final void mPLUS() throws RecognitionException {
		try {
			int _type = PLUS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/luigi/Documents/workspace/Parsers/src/OPPLLexer.g:80:3: (
			// '+' )
			// /Users/luigi/Documents/workspace/Parsers/src/OPPLLexer.g:81:5:
			// '+'
			{
				this.match('+');
			}
			this.state.type = _type;
			this.state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "PLUS"
	// $ANTLR start "CREATE"
	public final void mCREATE() throws RecognitionException {
		try {
			int _type = CREATE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/luigi/Documents/workspace/Parsers/src/OPPLLexer.g:87:3: (
			// 'create' )
			// /Users/luigi/Documents/workspace/Parsers/src/OPPLLexer.g:88:5:
			// 'create'
			{
				this.match("create");
			}
			this.state.type = _type;
			this.state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "CREATE"
	// $ANTLR start "CREATE_INTERSECTION"
	public final void mCREATE_INTERSECTION() throws RecognitionException {
		try {
			int _type = CREATE_INTERSECTION;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/luigi/Documents/workspace/Parsers/src/OPPLLexer.g:92:3: (
			// 'createIntersection' | 'CreateIntersection' )
			int alt2 = 2;
			int LA2_0 = this.input.LA(1);
			if (LA2_0 == 'c') {
				alt2 = 1;
			} else if (LA2_0 == 'C') {
				alt2 = 2;
			} else {
				NoViableAltException nvae = new NoViableAltException("", 2, 0, this.input);
				throw nvae;
			}
			switch (alt2) {
			case 1:
				// /Users/luigi/Documents/workspace/Parsers/src/OPPLLexer.g:93:5:
				// 'createIntersection'
			{
				this.match("createIntersection");
			}
				break;
			case 2:
				// /Users/luigi/Documents/workspace/Parsers/src/OPPLLexer.g:93:28:
				// 'CreateIntersection'
			{
				this.match("CreateIntersection");
			}
				break;
			}
			this.state.type = _type;
			this.state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "CREATE_INTERSECTION"
	// $ANTLR start "CREATE_DISJUNCTION"
	public final void mCREATE_DISJUNCTION() throws RecognitionException {
		try {
			int _type = CREATE_DISJUNCTION;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/luigi/Documents/workspace/Parsers/src/OPPLLexer.g:97:3: (
			// 'createUnion' | 'CreateUnion' )
			int alt3 = 2;
			int LA3_0 = this.input.LA(1);
			if (LA3_0 == 'c') {
				alt3 = 1;
			} else if (LA3_0 == 'C') {
				alt3 = 2;
			} else {
				NoViableAltException nvae = new NoViableAltException("", 3, 0, this.input);
				throw nvae;
			}
			switch (alt3) {
			case 1:
				// /Users/luigi/Documents/workspace/Parsers/src/OPPLLexer.g:98:5:
				// 'createUnion'
			{
				this.match("createUnion");
			}
				break;
			case 2:
				// /Users/luigi/Documents/workspace/Parsers/src/OPPLLexer.g:98:21:
				// 'CreateUnion'
			{
				this.match("CreateUnion");
			}
				break;
			}
			this.state.type = _type;
			this.state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "CREATE_DISJUNCTION"
	// $ANTLR start "BEGIN"
	public final void mBEGIN() throws RecognitionException {
		try {
			int _type = BEGIN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/luigi/Documents/workspace/Parsers/src/OPPLLexer.g:102:3: (
			// 'BEGIN' )
			// /Users/luigi/Documents/workspace/Parsers/src/OPPLLexer.g:103:5:
			// 'BEGIN'
			{
				this.match("BEGIN");
			}
			this.state.type = _type;
			this.state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "BEGIN"
	// $ANTLR start "END"
	public final void mEND() throws RecognitionException {
		try {
			int _type = END;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/luigi/Documents/workspace/Parsers/src/OPPLLexer.g:107:3: (
			// 'END;' )
			// /Users/luigi/Documents/workspace/Parsers/src/OPPLLexer.g:108:5:
			// 'END;'
			{
				this.match("END;");
			}
			this.state.type = _type;
			this.state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "END"
	// $ANTLR start "OPEN_SQUARE_BRACKET"
	public final void mOPEN_SQUARE_BRACKET() throws RecognitionException {
		try {
			int _type = OPEN_SQUARE_BRACKET;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/luigi/Documents/workspace/Parsers/src/OPPLLexer.g:112:3: (
			// '[' )
			// /Users/luigi/Documents/workspace/Parsers/src/OPPLLexer.g:113:5:
			// '['
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
			// /Users/luigi/Documents/workspace/Parsers/src/OPPLLexer.g:117:3: (
			// ']' )
			// /Users/luigi/Documents/workspace/Parsers/src/OPPLLexer.g:118:5:
			// ']'
			{
				this.match(']');
			}
			this.state.type = _type;
			this.state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "CLOSED_SQUARE_BRACKET"
	// $ANTLR start "SUPER_CLASS_OF"
	public final void mSUPER_CLASS_OF() throws RecognitionException {
		try {
			int _type = SUPER_CLASS_OF;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/luigi/Documents/workspace/Parsers/src/OPPLLexer.g:123:3: (
			// 'superClassOf' )
			// /Users/luigi/Documents/workspace/Parsers/src/OPPLLexer.g:124:5:
			// 'superClassOf'
			{
				this.match("superClassOf");
			}
			this.state.type = _type;
			this.state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "SUPER_CLASS_OF"
	// $ANTLR start "SUPER_PROPERTY_OF"
	public final void mSUPER_PROPERTY_OF() throws RecognitionException {
		try {
			int _type = SUPER_PROPERTY_OF;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/luigi/Documents/workspace/Parsers/src/OPPLLexer.g:128:3: (
			// 'superPropertyOf' )
			// /Users/luigi/Documents/workspace/Parsers/src/OPPLLexer.g:129:5:
			// 'superPropertyOf'
			{
				this.match("superPropertyOf");
			}
			this.state.type = _type;
			this.state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "SUPER_PROPERTY_OF"
	// $ANTLR start "MATCH"
	public final void mMATCH() throws RecognitionException {
		try {
			int _type = MATCH;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/luigi/Documents/workspace/Parsers/src/OPPLLexer.g:133:3: (
			// 'MATCH' | 'Match' )
			int alt4 = 2;
			int LA4_0 = this.input.LA(1);
			if (LA4_0 == 'M') {
				int LA4_1 = this.input.LA(2);
				if (LA4_1 == 'A') {
					alt4 = 1;
				} else if (LA4_1 == 'a') {
					alt4 = 2;
				} else {
					NoViableAltException nvae = new NoViableAltException("", 4, 1, this.input);
					throw nvae;
				}
			} else {
				NoViableAltException nvae = new NoViableAltException("", 4, 0, this.input);
				throw nvae;
			}
			switch (alt4) {
			case 1:
				// /Users/luigi/Documents/workspace/Parsers/src/OPPLLexer.g:134:4:
				// 'MATCH'
			{
				this.match("MATCH");
			}
				break;
			case 2:
				// /Users/luigi/Documents/workspace/Parsers/src/OPPLLexer.g:135:6:
				// 'Match'
			{
				this.match("Match");
			}
				break;
			}
			this.state.type = _type;
			this.state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "MATCH"
	// $ANTLR start "VALUES"
	public final void mVALUES() throws RecognitionException {
		try {
			int _type = VALUES;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/luigi/Documents/workspace/Parsers/src/OPPLLexer.g:140:3: (
			// 'VALUES' )
			// /Users/luigi/Documents/workspace/Parsers/src/OPPLLexer.g:141:5:
			// 'VALUES'
			{
				this.match("VALUES");
			}
			this.state.type = _type;
			this.state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "VALUES"
	// $ANTLR start "RENDERING"
	public final void mRENDERING() throws RecognitionException {
		try {
			int _type = RENDERING;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/luigi/Documents/workspace/Parsers/src/OPPLLexer.g:146:3: (
			// 'RENDERING' )
			// /Users/luigi/Documents/workspace/Parsers/src/OPPLLexer.g:147:5:
			// 'RENDERING'
			{
				this.match("RENDERING");
			}
			this.state.type = _type;
			this.state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "RENDERING"
	// $ANTLR start "GROUPS"
	public final void mGROUPS() throws RecognitionException {
		try {
			int _type = GROUPS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/luigi/Documents/workspace/Parsers/src/OPPLLexer.g:152:3: (
			// 'GROUPS' )
			// /Users/luigi/Documents/workspace/Parsers/src/OPPLLexer.g:153:5:
			// 'GROUPS'
			{
				this.match("GROUPS");
			}
			this.state.type = _type;
			this.state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "GROUPS"
	// $ANTLR start "QUESTION_MARK"
	public final void mQUESTION_MARK() throws RecognitionException {
		try {
			// /Users/luigi/Documents/workspace/Parsers/src/OPPLLexer.g:158:3: (
			// '?' )
			// /Users/luigi/Documents/workspace/Parsers/src/OPPLLexer.g:159:5:
			// '?'
			{
				this.match('?');
			}
		} finally {
		}
	}

	// $ANTLR end "QUESTION_MARK"
	// $ANTLR start "ESCLAMATION_MARK"
	public final void mESCLAMATION_MARK() throws RecognitionException {
		try {
			int _type = ESCLAMATION_MARK;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/luigi/Documents/workspace/Parsers/src/OPPLLexer.g:163:3: (
			// '!' )
			// /Users/luigi/Documents/workspace/Parsers/src/OPPLLexer.g:164:5:
			// '!'
			{
				this.match('!');
			}
			this.state.type = _type;
			this.state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "ESCLAMATION_MARK"
	// $ANTLR start "VARIABLE_NAME"
	public final void mVARIABLE_NAME() throws RecognitionException {
		try {
			int _type = VARIABLE_NAME;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/luigi/Documents/workspace/Parsers/src/OPPLLexer.g:168:3: (
			// QUESTION_MARK LETTER ( LETTER | DIGIT | '-' | '_' )* )
			// /Users/luigi/Documents/workspace/Parsers/src/OPPLLexer.g:169:5:
			// QUESTION_MARK LETTER ( LETTER | DIGIT | '-' | '_' )*
			{
				this.mQUESTION_MARK();
				this.gMOWLLexer.mLETTER();
				// /Users/luigi/Documents/workspace/Parsers/src/OPPLLexer.g:169:26:
				// ( LETTER | DIGIT | '-' | '_' )*
				loop5: do {
					int alt5 = 2;
					int LA5_0 = this.input.LA(1);
					if (LA5_0 == '-' || LA5_0 >= '0' && LA5_0 <= '9' || LA5_0 >= 'A'
							&& LA5_0 <= 'Z' || LA5_0 == '_' || LA5_0 >= 'a' && LA5_0 <= 'z') {
						alt5 = 1;
					}
					switch (alt5) {
					case 1:
						// /Users/luigi/Documents/workspace/Parsers/src/OPPLLexer.g:
					{
						if (this.input.LA(1) == '-' || this.input.LA(1) >= '0'
								&& this.input.LA(1) <= '9' || this.input.LA(1) >= 'A'
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
						break loop5;
					}
				} while (true);
			}
			this.state.type = _type;
			this.state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "VARIABLE_NAME"
	@Override
	public void mTokens() throws RecognitionException {
		// /Users/luigi/Documents/workspace/Parsers/src/OPPLLexer.g:1:8: (
		// VARIABLE_TYPE | ADD | REMOVE | WHERE | NOT_EQUAL | EQUAL | IN |
		// SELECT | ASSERTED | COLON | DOT | PLUS | CREATE | CREATE_INTERSECTION
		// | CREATE_DISJUNCTION | BEGIN | END | OPEN_SQUARE_BRACKET |
		// CLOSED_SQUARE_BRACKET | SUPER_CLASS_OF | SUPER_PROPERTY_OF | MATCH |
		// VALUES | RENDERING | GROUPS | ESCLAMATION_MARK | VARIABLE_NAME |
		// MOWLLexer. Tokens )
		int alt6 = 28;
		alt6 = this.dfa6.predict(this.input);
		switch (alt6) {
		case 1:
			// /Users/luigi/Documents/workspace/Parsers/src/OPPLLexer.g:1:10:
			// VARIABLE_TYPE
		{
			this.mVARIABLE_TYPE();
		}
			break;
		case 2:
			// /Users/luigi/Documents/workspace/Parsers/src/OPPLLexer.g:1:24:
			// ADD
		{
			this.mADD();
		}
			break;
		case 3:
			// /Users/luigi/Documents/workspace/Parsers/src/OPPLLexer.g:1:28:
			// REMOVE
		{
			this.mREMOVE();
		}
			break;
		case 4:
			// /Users/luigi/Documents/workspace/Parsers/src/OPPLLexer.g:1:35:
			// WHERE
		{
			this.mWHERE();
		}
			break;
		case 5:
			// /Users/luigi/Documents/workspace/Parsers/src/OPPLLexer.g:1:41:
			// NOT_EQUAL
		{
			this.mNOT_EQUAL();
		}
			break;
		case 6:
			// /Users/luigi/Documents/workspace/Parsers/src/OPPLLexer.g:1:51:
			// EQUAL
		{
			this.mEQUAL();
		}
			break;
		case 7:
			// /Users/luigi/Documents/workspace/Parsers/src/OPPLLexer.g:1:57: IN
		{
			this.mIN();
		}
			break;
		case 8:
			// /Users/luigi/Documents/workspace/Parsers/src/OPPLLexer.g:1:60:
			// SELECT
		{
			this.mSELECT();
		}
			break;
		case 9:
			// /Users/luigi/Documents/workspace/Parsers/src/OPPLLexer.g:1:67:
			// ASSERTED
		{
			this.mASSERTED();
		}
			break;
		case 10:
			// /Users/luigi/Documents/workspace/Parsers/src/OPPLLexer.g:1:76:
			// COLON
		{
			this.mCOLON();
		}
			break;
		case 11:
			// /Users/luigi/Documents/workspace/Parsers/src/OPPLLexer.g:1:82:
			// DOT
		{
			this.mDOT();
		}
			break;
		case 12:
			// /Users/luigi/Documents/workspace/Parsers/src/OPPLLexer.g:1:86:
			// PLUS
		{
			this.mPLUS();
		}
			break;
		case 13:
			// /Users/luigi/Documents/workspace/Parsers/src/OPPLLexer.g:1:91:
			// CREATE
		{
			this.mCREATE();
		}
			break;
		case 14:
			// /Users/luigi/Documents/workspace/Parsers/src/OPPLLexer.g:1:98:
			// CREATE_INTERSECTION
		{
			this.mCREATE_INTERSECTION();
		}
			break;
		case 15:
			// /Users/luigi/Documents/workspace/Parsers/src/OPPLLexer.g:1:118:
			// CREATE_DISJUNCTION
		{
			this.mCREATE_DISJUNCTION();
		}
			break;
		case 16:
			// /Users/luigi/Documents/workspace/Parsers/src/OPPLLexer.g:1:137:
			// BEGIN
		{
			this.mBEGIN();
		}
			break;
		case 17:
			// /Users/luigi/Documents/workspace/Parsers/src/OPPLLexer.g:1:143:
			// END
		{
			this.mEND();
		}
			break;
		case 18:
			// /Users/luigi/Documents/workspace/Parsers/src/OPPLLexer.g:1:147:
			// OPEN_SQUARE_BRACKET
		{
			this.mOPEN_SQUARE_BRACKET();
		}
			break;
		case 19:
			// /Users/luigi/Documents/workspace/Parsers/src/OPPLLexer.g:1:167:
			// CLOSED_SQUARE_BRACKET
		{
			this.mCLOSED_SQUARE_BRACKET();
		}
			break;
		case 20:
			// /Users/luigi/Documents/workspace/Parsers/src/OPPLLexer.g:1:189:
			// SUPER_CLASS_OF
		{
			this.mSUPER_CLASS_OF();
		}
			break;
		case 21:
			// /Users/luigi/Documents/workspace/Parsers/src/OPPLLexer.g:1:204:
			// SUPER_PROPERTY_OF
		{
			this.mSUPER_PROPERTY_OF();
		}
			break;
		case 22:
			// /Users/luigi/Documents/workspace/Parsers/src/OPPLLexer.g:1:222:
			// MATCH
		{
			this.mMATCH();
		}
			break;
		case 23:
			// /Users/luigi/Documents/workspace/Parsers/src/OPPLLexer.g:1:228:
			// VALUES
		{
			this.mVALUES();
		}
			break;
		case 24:
			// /Users/luigi/Documents/workspace/Parsers/src/OPPLLexer.g:1:235:
			// RENDERING
		{
			this.mRENDERING();
		}
			break;
		case 25:
			// /Users/luigi/Documents/workspace/Parsers/src/OPPLLexer.g:1:245:
			// GROUPS
		{
			this.mGROUPS();
		}
			break;
		case 26:
			// /Users/luigi/Documents/workspace/Parsers/src/OPPLLexer.g:1:252:
			// ESCLAMATION_MARK
		{
			this.mESCLAMATION_MARK();
		}
			break;
		case 27:
			// /Users/luigi/Documents/workspace/Parsers/src/OPPLLexer.g:1:269:
			// VARIABLE_NAME
		{
			this.mVARIABLE_NAME();
		}
			break;
		case 28:
			// /Users/luigi/Documents/workspace/Parsers/src/OPPLLexer.g:1:283:
			// MOWLLexer. Tokens
		{
			this.gMOWLLexer.mTokens();
		}
			break;
		}
	}

	protected DFA6 dfa6 = new DFA6(this);
	static final String DFA6_eotS = "\1\uffff\7\30\1\44\1\uffff\1\30\3\uffff\3\30\2\uffff\4\30\2\uffff"
			+ "\5\30\1\64\4\30\2\uffff\17\30\1\uffff\1\111\23\30\1\uffff\7\30\1"
			+ "\uffff\5\30\1\151\10\30\1\162\2\30\1\165\1\30\2\170\2\30\1\uffff"
			+ "\6\30\1\u0082\1\30\1\uffff\1\u0084\1\u0087\1\uffff\2\30\1\uffff"
			+ "\1\u008a\1\u008b\7\30\1\uffff\1\30\1\uffff\2\30\1\uffff\2\30\2\uffff"
			+ "\1\151\5\30\1\u009d\12\30\1\uffff\1\u00a8\10\30\1\151\1\uffff\5"
			+ "\30\1\u00b6\3\30\1\u00b6\3\30\1\uffff\1\30\1\151\1\30\1\u00bf\4"
			+ "\30\1\uffff\2\30\1\151\4\30\1\u00ca\2\30\1\uffff\2\30\2\u00cf\1" + "\uffff";
	static final String DFA6_eofS = "\u00d0\uffff";
	static final String DFA6_minS = "\1\11\1\114\1\102\1\101\1\116\1\104\1\105\1\110\1\75\1\uffff\1\105"
			+ "\3\uffff\1\162\1\105\1\116\2\uffff\1\165\2\101\1\122\2\uffff\1\101"
			+ "\1\116\1\145\1\112\1\124\1\55\1\104\1\123\1\115\1\105\2\uffff\1"
			+ "\114\1\145\1\107\1\104\1\160\1\124\1\164\1\114\1\117\2\123\1\141"
			+ "\1\105\1\101\1\111\1\uffff\1\55\1\105\1\117\1\104\1\122\1\105\1"
			+ "\141\1\111\1\73\1\145\1\103\1\143\2\125\1\123\1\124\1\164\1\103"
			+ "\1\120\1\126\1\uffff\1\122\1\126\2\105\1\103\1\164\1\116\1\uffff"
			+ "\1\162\1\110\1\150\1\105\1\120\1\55\1\101\1\145\1\124\1\122\1\111"
			+ "\1\124\1\105\1\122\1\55\1\124\1\145\1\55\1\103\2\55\2\123\1\uffff"
			+ "\1\116\1\111\1\120\1\117\1\104\1\105\1\55\1\111\1\uffff\2\55\1\uffff"
			+ "\1\154\1\162\1\uffff\2\55\1\124\2\156\1\122\1\120\1\125\1\104\1"
			+ "\uffff\1\116\1\uffff\2\156\1\uffff\1\141\1\157\2\uffff\1\55\1\164"
			+ "\1\151\1\117\1\105\1\101\1\55\1\107\1\164\1\151\1\163\1\160\1\145"
			+ "\1\157\1\120\1\122\1\114\1\uffff\1\55\1\145\1\157\1\163\1\145\1"
			+ "\162\1\156\1\105\1\124\1\55\1\uffff\1\162\1\156\1\117\1\162\1\163"
			+ "\1\55\1\122\1\131\1\163\1\55\1\146\1\164\1\145\1\uffff\1\124\1\55"
			+ "\1\145\1\55\1\171\1\143\1\131\1\143\1\uffff\1\117\1\164\1\55\1\164"
			+ "\1\146\2\151\1\55\2\157\1\uffff\2\156\2\55\1\uffff";
	static final String DFA6_maxS = "\1\175\1\162\1\102\1\101\1\116\1\123\1\105\1\110\1\75\1\uffff\1"
			+ "\105\3\uffff\1\162\1\105\1\116\2\uffff\1\165\1\141\1\101\1\122\2"
			+ "\uffff\1\101\1\116\1\145\1\112\1\124\1\172\1\104\1\123\1\116\1\105"
			+ "\2\uffff\1\114\1\145\1\107\1\104\1\160\1\124\1\164\1\114\1\117\2"
			+ "\123\1\141\1\105\1\101\1\111\1\uffff\1\172\1\105\1\117\1\104\1\122"
			+ "\1\105\1\141\1\111\1\73\1\145\1\103\1\143\2\125\1\123\1\124\1\164"
			+ "\1\103\1\120\1\126\1\uffff\1\122\1\126\2\105\1\103\1\164\1\116\1"
			+ "\uffff\1\162\1\110\1\150\1\105\1\120\1\172\1\101\1\145\1\124\1\122"
			+ "\1\111\1\124\1\105\1\122\1\172\1\124\1\145\1\172\1\120\2\172\2\123"
			+ "\1\uffff\1\116\1\125\1\120\1\117\1\104\1\105\1\172\1\111\1\uffff"
			+ "\2\172\1\uffff\1\154\1\162\1\uffff\2\172\1\124\2\156\1\122\1\120"
			+ "\1\125\1\104\1\uffff\1\116\1\uffff\2\156\1\uffff\1\141\1\157\2\uffff"
			+ "\1\172\1\164\1\151\1\117\1\105\1\101\1\172\1\107\1\164\1\151\1\163"
			+ "\1\160\1\145\1\157\1\120\1\122\1\114\1\uffff\1\172\1\145\1\157\1"
			+ "\163\1\145\1\162\1\156\1\105\1\124\1\172\1\uffff\1\162\1\156\1\117"
			+ "\1\162\1\163\1\172\1\122\1\131\1\163\1\172\1\146\1\164\1\145\1\uffff"
			+ "\1\124\1\172\1\145\1\172\1\171\1\143\1\131\1\143\1\uffff\1\117\1"
			+ "\164\1\172\1\164\1\146\2\151\1\172\2\157\1\uffff\2\156\2\172\1\uffff";
	static final String DFA6_acceptS = "\11\uffff\1\6\1\uffff\1\12\1\13\1\14\3\uffff\1\22\1\23\4\uffff\1"
			+ "\33\1\34\12\uffff\1\5\1\32\17\uffff\1\7\24\uffff\1\2\7\uffff\1\21"
			+ "\27\uffff\1\1\10\uffff\1\4\2\uffff\1\20\2\uffff\1\26\11\uffff\1"
			+ "\3\1\uffff\1\10\2\uffff\1\15\2\uffff\1\27\1\31\21\uffff\1\11\12"
			+ "\uffff\1\30\15\uffff\1\17\10\uffff\1\24\12\uffff\1\25\4\uffff\1" + "\16";
	static final String DFA6_specialS = "\u00d0\uffff}>";
	static final String[] DFA6_transitionS = {
			"\2\30\2\uffff\1\30\22\uffff\1\30\1\10\1\30\4\uffff\3\30\1\uffff"
					+ "\1\15\1\30\1\uffff\1\14\1\uffff\12\30\1\13\2\uffff\1\11\1\uffff"
					+ "\1\27\1\uffff\1\5\1\17\1\1\1\3\1\20\1\30\1\26\1\30\1\4\3\30"
					+ "\1\24\1\30\1\2\2\30\1\6\1\12\2\30\1\25\1\7\3\30\1\21\1\uffff"
					+ "\1\22\1\30\2\uffff\2\30\1\16\17\30\1\23\10\30\1\uffff\1\30",
			"\1\31\2\uffff\1\32\42\uffff\1\33",
			"\1\34",
			"\1\35",
			"\1\36",
			"\1\37\16\uffff\1\40",
			"\1\41",
			"\1\42",
			"\1\43",
			"",
			"\1\45",
			"",
			"",
			"",
			"\1\46",
			"\1\47",
			"\1\50",
			"",
			"",
			"\1\51",
			"\1\52\37\uffff\1\53",
			"\1\54",
			"\1\55",
			"",
			"",
			"\1\56",
			"\1\57",
			"\1\60",
			"\1\61",
			"\1\62",
			"\1\30\2\uffff\13\30\6\uffff\3\30\1\63\26\30\4\uffff\1\30\1" + "\uffff\32\30",
			"\1\65",
			"\1\66",
			"\1\67\1\70",
			"\1\71",
			"",
			"",
			"\1\72",
			"\1\73",
			"\1\74",
			"\1\75",
			"\1\76",
			"\1\77",
			"\1\100",
			"\1\101",
			"\1\102",
			"\1\103",
			"\1\104",
			"\1\105",
			"\1\106",
			"\1\107",
			"\1\110",
			"",
			"\1\30\2\uffff\13\30\6\uffff\32\30\4\uffff\1\30\1\uffff\32\30",
			"\1\112",
			"\1\113",
			"\1\114",
			"\1\115",
			"\1\116",
			"\1\117",
			"\1\120",
			"\1\121",
			"\1\122",
			"\1\123",
			"\1\124",
			"\1\125",
			"\1\126",
			"\1\127",
			"\1\130",
			"\1\131",
			"\1\132",
			"\1\133",
			"\1\134",
			"",
			"\1\135",
			"\1\136",
			"\1\137",
			"\1\140",
			"\1\141",
			"\1\142",
			"\1\143",
			"",
			"\1\144",
			"\1\145",
			"\1\146",
			"\1\147",
			"\1\150",
			"\1\30\2\uffff\13\30\6\uffff\32\30\4\uffff\1\30\1\uffff\32\30",
			"\1\152",
			"\1\153",
			"\1\154",
			"\1\155",
			"\1\156",
			"\1\157",
			"\1\160",
			"\1\161",
			"\1\30\2\uffff\13\30\6\uffff\32\30\4\uffff\1\30\1\uffff\32\30",
			"\1\163",
			"\1\164",
			"\1\30\2\uffff\13\30\6\uffff\32\30\4\uffff\1\30\1\uffff\32\30",
			"\1\166\14\uffff\1\167",
			"\1\30\2\uffff\13\30\6\uffff\32\30\4\uffff\1\30\1\uffff\32\30",
			"\1\30\2\uffff\13\30\6\uffff\32\30\4\uffff\1\30\1\uffff\32\30",
			"\1\171",
			"\1\172",
			"",
			"\1\173",
			"\1\174\13\uffff\1\175",
			"\1\176",
			"\1\177",
			"\1\u0080",
			"\1\u0081",
			"\1\30\2\uffff\13\30\6\uffff\32\30\4\uffff\1\30\1\uffff\32\30",
			"\1\u0083",
			"",
			"\1\30\2\uffff\13\30\6\uffff\32\30\4\uffff\1\30\1\uffff\32\30",
			"\1\30\2\uffff\13\30\6\uffff\10\30\1\u0085\13\30\1\u0086\5\30"
					+ "\4\uffff\1\30\1\uffff\32\30", "", "\1\u0088", "\1\u0089", "",
			"\1\30\2\uffff\13\30\6\uffff\32\30\4\uffff\1\30\1\uffff\32\30",
			"\1\30\2\uffff\13\30\6\uffff\32\30\4\uffff\1\30\1\uffff\32\30", "\1\u008c", "\1\u008d",
			"\1\u008e", "\1\u008f", "\1\u0090", "\1\u0091", "\1\u0092", "", "\1\u0093", "",
			"\1\u0094", "\1\u0095", "", "\1\u0096", "\1\u0097", "", "",
			"\1\30\2\uffff\13\30\6\uffff\32\30\4\uffff\1\30\1\uffff\32\30", "\1\u0098", "\1\u0099",
			"\1\u009a", "\1\u009b", "\1\u009c",
			"\1\30\2\uffff\13\30\6\uffff\32\30\4\uffff\1\30\1\uffff\32\30", "\1\u009e", "\1\u009f",
			"\1\u00a0", "\1\u00a1", "\1\u00a2", "\1\u00a3", "\1\u00a4", "\1\u00a5", "\1\u00a6",
			"\1\u00a7", "", "\1\30\2\uffff\13\30\6\uffff\32\30\4\uffff\1\30\1\uffff\32\30",
			"\1\u00a9", "\1\u00aa", "\1\u00ab", "\1\u00ac", "\1\u00ad", "\1\u00ae", "\1\u00af",
			"\1\u00b0", "\1\30\2\uffff\13\30\6\uffff\32\30\4\uffff\1\30\1\uffff\32\30", "",
			"\1\u00b1", "\1\u00b2", "\1\u00b3", "\1\u00b4", "\1\u00b5",
			"\1\30\2\uffff\13\30\6\uffff\32\30\4\uffff\1\30\1\uffff\32\30", "\1\u00b7", "\1\u00b8",
			"\1\u00b9", "\1\30\2\uffff\13\30\6\uffff\32\30\4\uffff\1\30\1\uffff\32\30", "\1\u00ba",
			"\1\u00bb", "\1\u00bc", "", "\1\u00bd",
			"\1\30\2\uffff\13\30\6\uffff\32\30\4\uffff\1\30\1\uffff\32\30", "\1\u00be",
			"\1\30\2\uffff\13\30\6\uffff\32\30\4\uffff\1\30\1\uffff\32\30", "\1\u00c0", "\1\u00c1",
			"\1\u00c2", "\1\u00c3", "", "\1\u00c4", "\1\u00c5",
			"\1\30\2\uffff\13\30\6\uffff\32\30\4\uffff\1\30\1\uffff\32\30", "\1\u00c6", "\1\u00c7",
			"\1\u00c8", "\1\u00c9", "\1\30\2\uffff\13\30\6\uffff\32\30\4\uffff\1\30\1\uffff\32\30",
			"\1\u00cb", "\1\u00cc", "", "\1\u00cd", "\1\u00ce",
			"\1\30\2\uffff\13\30\6\uffff\32\30\4\uffff\1\30\1\uffff\32\30",
			"\1\30\2\uffff\13\30\6\uffff\32\30\4\uffff\1\30\1\uffff\32\30", "" };
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
			return "1:1: Tokens : ( VARIABLE_TYPE | ADD | REMOVE | WHERE | NOT_EQUAL | EQUAL | IN | SELECT | ASSERTED | COLON | DOT | PLUS | CREATE | CREATE_INTERSECTION | CREATE_DISJUNCTION | BEGIN | END | OPEN_SQUARE_BRACKET | CLOSED_SQUARE_BRACKET | SUPER_CLASS_OF | SUPER_PROPERTY_OF | MATCH | VALUES | RENDERING | GROUPS | ESCLAMATION_MARK | VARIABLE_NAME | MOWLLexer. Tokens );";
		}
	}
}