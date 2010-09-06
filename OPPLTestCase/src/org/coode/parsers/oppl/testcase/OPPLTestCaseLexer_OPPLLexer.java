package org.coode.parsers.oppl.testcase;

// $ANTLR 3.2 Sep 23, 2009 12:02:23 OPPLLexer.g 2010-09-03 11:32:02
import org.antlr.runtime.BaseRecognizer;
import org.antlr.runtime.CharStream;
import org.antlr.runtime.DFA;
import org.antlr.runtime.Lexer;
import org.antlr.runtime.MismatchedSetException;
import org.antlr.runtime.NoViableAltException;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.RecognizerSharedState;

public class OPPLTestCaseLexer_OPPLLexer extends Lexer {
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
	public static final int SYMMETRIC = 30;
	public static final int CARDINALITY_RESTRICTION = 64;
	public static final int SELECT = 75;
	public static final int ROLE_ASSERTION = 67;
	public static final int DIFFERENT_FROM_AXIOM = 53;
	public static final int TRANSITIVE = 34;
	public static final int ANTI_SYMMETRIC = 31;
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
	public OPPLTestCaseLexer_OPPLLexer_MOWLLexer gMOWLLexer;
	// delegators
	public OPPLTestCaseLexer gOPPLTestCaseLexer;
	public OPPLTestCaseLexer gParent;

	public OPPLTestCaseLexer_OPPLLexer() {
		;
	}

	public OPPLTestCaseLexer_OPPLLexer(CharStream input,
			OPPLTestCaseLexer gOPPLTestCaseLexer) {
		this(input, new RecognizerSharedState(), gOPPLTestCaseLexer);
	}

	public OPPLTestCaseLexer_OPPLLexer(CharStream input,
			RecognizerSharedState state, OPPLTestCaseLexer gOPPLTestCaseLexer) {
		super(input, state);
		this.gMOWLLexer = new OPPLTestCaseLexer_OPPLLexer_MOWLLexer(input,
				state, gOPPLTestCaseLexer, this);
		this.gOPPLTestCaseLexer = gOPPLTestCaseLexer;
		this.gParent = gOPPLTestCaseLexer;
	}

	@Override
	public String getGrammarFileName() {
		return "OPPLLexer.g";
	}

	// $ANTLR start "VARIABLE_TYPE"
	public final void mVARIABLE_TYPE() throws RecognitionException {
		try {
			int _type = VARIABLE_TYPE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// OPPLLexer.g:14:3: ( 'CLASS' | 'OBJECTPROPERTY' | 'DATAPROPERTY' |
			// 'INDIVIDUAL' | 'CONSTANT' )
			int alt1 = 5;
			switch (this.input.LA(1)) {
			case 'C': {
				int LA1_1 = this.input.LA(2);
				if (LA1_1 == 'L') {
					alt1 = 1;
				} else if (LA1_1 == 'O') {
					alt1 = 5;
				} else {
					NoViableAltException nvae = new NoViableAltException("", 1,
							1, this.input);
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
				NoViableAltException nvae = new NoViableAltException("", 1, 0,
						this.input);
				throw nvae;
			}
			switch (alt1) {
			case 1:
				// OPPLLexer.g:15:7: 'CLASS'
			{
				this.match("CLASS");
			}
				break;
			case 2:
				// OPPLLexer.g:16:7: 'OBJECTPROPERTY'
			{
				this.match("OBJECTPROPERTY");
			}
				break;
			case 3:
				// OPPLLexer.g:17:7: 'DATAPROPERTY'
			{
				this.match("DATAPROPERTY");
			}
				break;
			case 4:
				// OPPLLexer.g:18:7: 'INDIVIDUAL'
			{
				this.match("INDIVIDUAL");
			}
				break;
			case 5:
				// OPPLLexer.g:19:7: 'CONSTANT'
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
			// OPPLLexer.g:28:3: ( 'ADD' )
			// OPPLLexer.g:29:5: 'ADD'
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
			// OPPLLexer.g:33:3: ( 'REMOVE' )
			// OPPLLexer.g:34:5: 'REMOVE'
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
			// OPPLLexer.g:38:3: ( 'WHERE' )
			// OPPLLexer.g:39:5: 'WHERE'
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
			// OPPLLexer.g:43:3: ( '!=' )
			// OPPLLexer.g:44:5: '!='
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
			// OPPLLexer.g:48:3: ( '=' )
			// OPPLLexer.g:49:5: '='
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
			// OPPLLexer.g:53:3: ( 'IN' )
			// OPPLLexer.g:54:5: 'IN'
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
			// OPPLLexer.g:58:3: ( 'SELECT' )
			// OPPLLexer.g:59:5: 'SELECT'
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
			// OPPLLexer.g:63:3: ( 'ASSERTED' )
			// OPPLLexer.g:64:5: 'ASSERTED'
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
			// OPPLLexer.g:68:3: ( ':' )
			// OPPLLexer.g:69:5: ':'
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
			// OPPLLexer.g:73:3: ( '.' )
			// OPPLLexer.g:74:5: '.'
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
			// OPPLLexer.g:80:3: ( '+' )
			// OPPLLexer.g:81:5: '+'
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
			// OPPLLexer.g:87:3: ( 'create' )
			// OPPLLexer.g:88:5: 'create'
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
			// OPPLLexer.g:92:3: ( 'createIntersection' | 'CreateIntersection' )
			int alt2 = 2;
			int LA2_0 = this.input.LA(1);
			if (LA2_0 == 'c') {
				alt2 = 1;
			} else if (LA2_0 == 'C') {
				alt2 = 2;
			} else {
				NoViableAltException nvae = new NoViableAltException("", 2, 0,
						this.input);
				throw nvae;
			}
			switch (alt2) {
			case 1:
				// OPPLLexer.g:93:5: 'createIntersection'
			{
				this.match("createIntersection");
			}
				break;
			case 2:
				// OPPLLexer.g:93:28: 'CreateIntersection'
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
			// OPPLLexer.g:97:3: ( 'createUnion' | 'CreateUnion' )
			int alt3 = 2;
			int LA3_0 = this.input.LA(1);
			if (LA3_0 == 'c') {
				alt3 = 1;
			} else if (LA3_0 == 'C') {
				alt3 = 2;
			} else {
				NoViableAltException nvae = new NoViableAltException("", 3, 0,
						this.input);
				throw nvae;
			}
			switch (alt3) {
			case 1:
				// OPPLLexer.g:98:5: 'createUnion'
			{
				this.match("createUnion");
			}
				break;
			case 2:
				// OPPLLexer.g:98:21: 'CreateUnion'
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
			// OPPLLexer.g:102:3: ( 'BEGIN' )
			// OPPLLexer.g:103:5: 'BEGIN'
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
			// OPPLLexer.g:107:3: ( 'END;' )
			// OPPLLexer.g:108:5: 'END;'
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
			// OPPLLexer.g:112:3: ( '[' )
			// OPPLLexer.g:113:5: '['
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
			// OPPLLexer.g:117:3: ( ']' )
			// OPPLLexer.g:118:5: ']'
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
			// OPPLLexer.g:123:3: ( 'superClassOf' )
			// OPPLLexer.g:124:5: 'superClassOf'
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
			// OPPLLexer.g:128:3: ( 'superPropertyOf' )
			// OPPLLexer.g:129:5: 'superPropertyOf'
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
			// OPPLLexer.g:133:3: ( 'MATCH' | 'Match' )
			int alt4 = 2;
			int LA4_0 = this.input.LA(1);
			if (LA4_0 == 'M') {
				int LA4_1 = this.input.LA(2);
				if (LA4_1 == 'A') {
					alt4 = 1;
				} else if (LA4_1 == 'a') {
					alt4 = 2;
				} else {
					NoViableAltException nvae = new NoViableAltException("", 4,
							1, this.input);
					throw nvae;
				}
			} else {
				NoViableAltException nvae = new NoViableAltException("", 4, 0,
						this.input);
				throw nvae;
			}
			switch (alt4) {
			case 1:
				// OPPLLexer.g:134:4: 'MATCH'
			{
				this.match("MATCH");
			}
				break;
			case 2:
				// OPPLLexer.g:135:6: 'Match'
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
	// $ANTLR start "FAIL"
	public final void mFAIL() throws RecognitionException {
		try {
			int _type = FAIL;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// OPPLLexer.g:139:2: ( 'FAIL' | 'fail' | 'Fail' )
			int alt5 = 3;
			int LA5_0 = this.input.LA(1);
			if (LA5_0 == 'F') {
				int LA5_1 = this.input.LA(2);
				if (LA5_1 == 'A') {
					alt5 = 1;
				} else if (LA5_1 == 'a') {
					alt5 = 3;
				} else {
					NoViableAltException nvae = new NoViableAltException("", 5,
							1, this.input);
					throw nvae;
				}
			} else if (LA5_0 == 'f') {
				alt5 = 2;
			} else {
				NoViableAltException nvae = new NoViableAltException("", 5, 0,
						this.input);
				throw nvae;
			}
			switch (alt5) {
			case 1:
				// OPPLLexer.g:140:3: 'FAIL'
			{
				this.match("FAIL");
			}
				break;
			case 2:
				// OPPLLexer.g:141:5: 'fail'
			{
				this.match("fail");
			}
				break;
			case 3:
				// OPPLLexer.g:142:5: 'Fail'
			{
				this.match("Fail");
			}
				break;
			}
			this.state.type = _type;
			this.state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "FAIL"
	// $ANTLR start "VALUES"
	public final void mVALUES() throws RecognitionException {
		try {
			int _type = VALUES;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// OPPLLexer.g:146:3: ( 'VALUES' )
			// OPPLLexer.g:147:5: 'VALUES'
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
			// OPPLLexer.g:152:3: ( 'RENDERING' )
			// OPPLLexer.g:153:5: 'RENDERING'
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
			// OPPLLexer.g:158:3: ( 'GROUPS' )
			// OPPLLexer.g:159:5: 'GROUPS'
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
			// OPPLLexer.g:164:3: ( '?' )
			// OPPLLexer.g:165:5: '?'
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
			// OPPLLexer.g:169:3: ( '!' )
			// OPPLLexer.g:170:5: '!'
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
			// OPPLLexer.g:174:3: ( QUESTION_MARK LETTER ( LETTER | DIGIT | '-'
			// | '_' )* )
			// OPPLLexer.g:175:5: QUESTION_MARK LETTER ( LETTER | DIGIT | '-' |
			// '_' )*
			{
				this.mQUESTION_MARK();
				this.gMOWLLexer.mLETTER();
				// OPPLLexer.g:175:26: ( LETTER | DIGIT | '-' | '_' )*
				loop6: do {
					int alt6 = 2;
					int LA6_0 = this.input.LA(1);
					if (LA6_0 == '-' || LA6_0 >= '0' && LA6_0 <= '9'
							|| LA6_0 >= 'A' && LA6_0 <= 'Z' || LA6_0 == '_'
							|| LA6_0 >= 'a' && LA6_0 <= 'z') {
						alt6 = 1;
					}
					switch (alt6) {
					case 1:
						// OPPLLexer.g:
					{
						if (this.input.LA(1) == '-' || this.input.LA(1) >= '0'
								&& this.input.LA(1) <= '9'
								|| this.input.LA(1) >= 'A'
								&& this.input.LA(1) <= 'Z'
								|| this.input.LA(1) == '_'
								|| this.input.LA(1) >= 'a'
								&& this.input.LA(1) <= 'z') {
							this.input.consume();
						} else {
							MismatchedSetException mse = new MismatchedSetException(
									null, this.input);
							this.recover(mse);
							throw mse;
						}
					}
						break;
					default:
						break loop6;
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
		// OPPLLexer.g:1:8: ( VARIABLE_TYPE | ADD | REMOVE | WHERE | NOT_EQUAL |
		// EQUAL | IN | SELECT | ASSERTED | COLON | DOT | PLUS | CREATE |
		// CREATE_INTERSECTION | CREATE_DISJUNCTION | BEGIN | END |
		// OPEN_SQUARE_BRACKET | CLOSED_SQUARE_BRACKET | SUPER_CLASS_OF |
		// SUPER_PROPERTY_OF | MATCH | FAIL | VALUES | RENDERING | GROUPS |
		// ESCLAMATION_MARK | VARIABLE_NAME | MOWLLexer. Tokens )
		int alt7 = 29;
		alt7 = this.dfa7.predict(this.input);
		switch (alt7) {
		case 1:
			// OPPLLexer.g:1:10: VARIABLE_TYPE
		{
			this.mVARIABLE_TYPE();
		}
			break;
		case 2:
			// OPPLLexer.g:1:24: ADD
		{
			this.mADD();
		}
			break;
		case 3:
			// OPPLLexer.g:1:28: REMOVE
		{
			this.mREMOVE();
		}
			break;
		case 4:
			// OPPLLexer.g:1:35: WHERE
		{
			this.mWHERE();
		}
			break;
		case 5:
			// OPPLLexer.g:1:41: NOT_EQUAL
		{
			this.mNOT_EQUAL();
		}
			break;
		case 6:
			// OPPLLexer.g:1:51: EQUAL
		{
			this.mEQUAL();
		}
			break;
		case 7:
			// OPPLLexer.g:1:57: IN
		{
			this.mIN();
		}
			break;
		case 8:
			// OPPLLexer.g:1:60: SELECT
		{
			this.mSELECT();
		}
			break;
		case 9:
			// OPPLLexer.g:1:67: ASSERTED
		{
			this.mASSERTED();
		}
			break;
		case 10:
			// OPPLLexer.g:1:76: COLON
		{
			this.mCOLON();
		}
			break;
		case 11:
			// OPPLLexer.g:1:82: DOT
		{
			this.mDOT();
		}
			break;
		case 12:
			// OPPLLexer.g:1:86: PLUS
		{
			this.mPLUS();
		}
			break;
		case 13:
			// OPPLLexer.g:1:91: CREATE
		{
			this.mCREATE();
		}
			break;
		case 14:
			// OPPLLexer.g:1:98: CREATE_INTERSECTION
		{
			this.mCREATE_INTERSECTION();
		}
			break;
		case 15:
			// OPPLLexer.g:1:118: CREATE_DISJUNCTION
		{
			this.mCREATE_DISJUNCTION();
		}
			break;
		case 16:
			// OPPLLexer.g:1:137: BEGIN
		{
			this.mBEGIN();
		}
			break;
		case 17:
			// OPPLLexer.g:1:143: END
		{
			this.mEND();
		}
			break;
		case 18:
			// OPPLLexer.g:1:147: OPEN_SQUARE_BRACKET
		{
			this.mOPEN_SQUARE_BRACKET();
		}
			break;
		case 19:
			// OPPLLexer.g:1:167: CLOSED_SQUARE_BRACKET
		{
			this.mCLOSED_SQUARE_BRACKET();
		}
			break;
		case 20:
			// OPPLLexer.g:1:189: SUPER_CLASS_OF
		{
			this.mSUPER_CLASS_OF();
		}
			break;
		case 21:
			// OPPLLexer.g:1:204: SUPER_PROPERTY_OF
		{
			this.mSUPER_PROPERTY_OF();
		}
			break;
		case 22:
			// OPPLLexer.g:1:222: MATCH
		{
			this.mMATCH();
		}
			break;
		case 23:
			// OPPLLexer.g:1:228: FAIL
		{
			this.mFAIL();
		}
			break;
		case 24:
			// OPPLLexer.g:1:233: VALUES
		{
			this.mVALUES();
		}
			break;
		case 25:
			// OPPLLexer.g:1:240: RENDERING
		{
			this.mRENDERING();
		}
			break;
		case 26:
			// OPPLLexer.g:1:250: GROUPS
		{
			this.mGROUPS();
		}
			break;
		case 27:
			// OPPLLexer.g:1:257: ESCLAMATION_MARK
		{
			this.mESCLAMATION_MARK();
		}
			break;
		case 28:
			// OPPLLexer.g:1:274: VARIABLE_NAME
		{
			this.mVARIABLE_NAME();
		}
			break;
		case 29:
			// OPPLLexer.g:1:288: MOWLLexer. Tokens
		{
			this.gMOWLLexer.mTokens();
		}
			break;
		}
	}

	protected DFA7 dfa7 = new DFA7(this);
	static final String DFA7_eotS = "\1\uffff\7\32\1\46\1\uffff\1\32\3\uffff\3\32\2\uffff\6\32\2\uffff"
			+ "\5\32\1\71\4\32\2\uffff\22\32\1\uffff\1\121\26\32\1\uffff\7\32\1"
			+ "\uffff\3\32\3\162\2\32\1\165\10\32\1\176\2\32\1\u0081\1\32\2\u0084"
			+ "\1\uffff\2\32\1\uffff\6\32\1\u008e\1\32\1\uffff\1\u0090\1\u0093"
			+ "\1\uffff\2\32\1\uffff\1\u0096\1\u0097\7\32\1\uffff\1\32\1\uffff"
			+ "\2\32\1\uffff\2\32\2\uffff\1\165\5\32\1\u00a9\12\32\1\uffff\1\u00b4"
			+ "\10\32\1\165\1\uffff\5\32\1\u00c2\3\32\1\u00c2\3\32\1\uffff\1\32"
			+ "\1\165\1\32\1\u00cb\4\32\1\uffff\2\32\1\165\4\32\1\u00d6\2\32\1"
			+ "\uffff\2\32\2\u00db\1\uffff";
	static final String DFA7_eofS = "\u00dc\uffff";
	static final String DFA7_minS = "\1\11\1\114\1\102\1\101\1\116\1\104\1\105\1\110\1\75\1\uffff\1\105"
			+ "\3\uffff\1\162\1\105\1\116\2\uffff\1\165\2\101\1\141\1\101\1\122"
			+ "\2\uffff\1\101\1\116\1\145\1\112\1\124\1\55\1\104\1\123\1\115\1"
			+ "\105\2\uffff\1\114\1\145\1\107\1\104\1\160\1\124\1\164\1\111\2\151"
			+ "\1\114\1\117\2\123\1\141\1\105\1\101\1\111\1\uffff\1\55\1\105\1"
			+ "\117\1\104\1\122\1\105\1\141\1\111\1\73\1\145\1\103\1\143\1\114"
			+ "\2\154\2\125\1\123\1\124\1\164\1\103\1\120\1\126\1\uffff\1\122\1"
			+ "\126\2\105\1\103\1\164\1\116\1\uffff\1\162\1\110\1\150\3\55\1\105"
			+ "\1\120\1\55\1\101\1\145\1\124\1\122\1\111\1\124\1\105\1\122\1\55"
			+ "\1\124\1\145\1\55\1\103\2\55\1\uffff\2\123\1\uffff\1\116\1\111\1"
			+ "\120\1\117\1\104\1\105\1\55\1\111\1\uffff\2\55\1\uffff\1\154\1\162"
			+ "\1\uffff\2\55\1\124\2\156\1\122\1\120\1\125\1\104\1\uffff\1\116"
			+ "\1\uffff\2\156\1\uffff\1\141\1\157\2\uffff\1\55\1\164\1\151\1\117"
			+ "\1\105\1\101\1\55\1\107\1\164\1\151\1\163\1\160\1\145\1\157\1\120"
			+ "\1\122\1\114\1\uffff\1\55\1\145\1\157\1\163\1\145\1\162\1\156\1"
			+ "\105\1\124\1\55\1\uffff\1\162\1\156\1\117\1\162\1\163\1\55\1\122"
			+ "\1\131\1\163\1\55\1\146\1\164\1\145\1\uffff\1\124\1\55\1\145\1\55"
			+ "\1\171\1\143\1\131\1\143\1\uffff\1\117\1\164\1\55\1\164\1\146\2"
			+ "\151\1\55\2\157\1\uffff\2\156\2\55\1\uffff";
	static final String DFA7_maxS = "\1\175\1\162\1\102\1\101\1\116\1\123\1\105\1\110\1\75\1\uffff\1"
			+ "\105\3\uffff\1\162\1\105\1\116\2\uffff\1\165\3\141\1\101\1\122\2"
			+ "\uffff\1\101\1\116\1\145\1\112\1\124\1\172\1\104\1\123\1\116\1\105"
			+ "\2\uffff\1\114\1\145\1\107\1\104\1\160\1\124\1\164\1\111\2\151\1"
			+ "\114\1\117\2\123\1\141\1\105\1\101\1\111\1\uffff\1\172\1\105\1\117"
			+ "\1\104\1\122\1\105\1\141\1\111\1\73\1\145\1\103\1\143\1\114\2\154"
			+ "\2\125\1\123\1\124\1\164\1\103\1\120\1\126\1\uffff\1\122\1\126\2"
			+ "\105\1\103\1\164\1\116\1\uffff\1\162\1\110\1\150\3\172\1\105\1\120"
			+ "\1\172\1\101\1\145\1\124\1\122\1\111\1\124\1\105\1\122\1\172\1\124"
			+ "\1\145\1\172\1\120\2\172\1\uffff\2\123\1\uffff\1\116\1\125\1\120"
			+ "\1\117\1\104\1\105\1\172\1\111\1\uffff\2\172\1\uffff\1\154\1\162"
			+ "\1\uffff\2\172\1\124\2\156\1\122\1\120\1\125\1\104\1\uffff\1\116"
			+ "\1\uffff\2\156\1\uffff\1\141\1\157\2\uffff\1\172\1\164\1\151\1\117"
			+ "\1\105\1\101\1\172\1\107\1\164\1\151\1\163\1\160\1\145\1\157\1\120"
			+ "\1\122\1\114\1\uffff\1\172\1\145\1\157\1\163\1\145\1\162\1\156\1"
			+ "\105\1\124\1\172\1\uffff\1\162\1\156\1\117\1\162\1\163\1\172\1\122"
			+ "\1\131\1\163\1\172\1\146\1\164\1\145\1\uffff\1\124\1\172\1\145\1"
			+ "\172\1\171\1\143\1\131\1\143\1\uffff\1\117\1\164\1\172\1\164\1\146"
			+ "\2\151\1\172\2\157\1\uffff\2\156\2\172\1\uffff";
	static final String DFA7_acceptS = "\11\uffff\1\6\1\uffff\1\12\1\13\1\14\3\uffff\1\22\1\23\6\uffff\1"
			+ "\34\1\35\12\uffff\1\5\1\33\22\uffff\1\7\27\uffff\1\2\7\uffff\1\21"
			+ "\30\uffff\1\27\2\uffff\1\1\10\uffff\1\4\2\uffff\1\20\2\uffff\1\26"
			+ "\11\uffff\1\3\1\uffff\1\10\2\uffff\1\15\2\uffff\1\30\1\32\21\uffff"
			+ "\1\11\12\uffff\1\31\15\uffff\1\17\10\uffff\1\24\12\uffff\1\25\4"
			+ "\uffff\1\16";
	static final String DFA7_specialS = "\u00dc\uffff}>";
	static final String[] DFA7_transitionS = {
			"\2\32\2\uffff\1\32\22\uffff\1\32\1\10\1\32\4\uffff\3\32\1\uffff"
					+ "\1\15\1\32\1\uffff\1\14\1\uffff\12\32\1\13\2\uffff\1\11\1\uffff"
					+ "\1\31\1\uffff\1\5\1\17\1\1\1\3\1\20\1\25\1\30\1\32\1\4\3\32"
					+ "\1\24\1\32\1\2\2\32\1\6\1\12\2\32\1\27\1\7\3\32\1\21\1\uffff"
					+ "\1\22\1\32\2\uffff\2\32\1\16\2\32\1\26\14\32\1\23\10\32\1\uffff"
					+ "\1\32",
			"\1\33\2\uffff\1\34\42\uffff\1\35",
			"\1\36",
			"\1\37",
			"\1\40",
			"\1\41\16\uffff\1\42",
			"\1\43",
			"\1\44",
			"\1\45",
			"",
			"\1\47",
			"",
			"",
			"",
			"\1\50",
			"\1\51",
			"\1\52",
			"",
			"",
			"\1\53",
			"\1\54\37\uffff\1\55",
			"\1\56\37\uffff\1\57",
			"\1\60",
			"\1\61",
			"\1\62",
			"",
			"",
			"\1\63",
			"\1\64",
			"\1\65",
			"\1\66",
			"\1\67",
			"\1\32\2\uffff\13\32\6\uffff\3\32\1\70\26\32\4\uffff\1\32\1"
					+ "\uffff\32\32",
			"\1\72",
			"\1\73",
			"\1\74\1\75",
			"\1\76",
			"",
			"",
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
			"\1\111",
			"\1\112",
			"\1\113",
			"\1\114",
			"\1\115",
			"\1\116",
			"\1\117",
			"\1\120",
			"",
			"\1\32\2\uffff\13\32\6\uffff\32\32\4\uffff\1\32\1\uffff\32\32",
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
			"\1\135",
			"\1\136",
			"\1\137",
			"\1\140",
			"\1\141",
			"\1\142",
			"\1\143",
			"\1\144",
			"\1\145",
			"\1\146",
			"\1\147",
			"",
			"\1\150",
			"\1\151",
			"\1\152",
			"\1\153",
			"\1\154",
			"\1\155",
			"\1\156",
			"",
			"\1\157",
			"\1\160",
			"\1\161",
			"\1\32\2\uffff\13\32\6\uffff\32\32\4\uffff\1\32\1\uffff\32\32",
			"\1\32\2\uffff\13\32\6\uffff\32\32\4\uffff\1\32\1\uffff\32\32",
			"\1\32\2\uffff\13\32\6\uffff\32\32\4\uffff\1\32\1\uffff\32\32",
			"\1\163",
			"\1\164",
			"\1\32\2\uffff\13\32\6\uffff\32\32\4\uffff\1\32\1\uffff\32\32",
			"\1\166",
			"\1\167",
			"\1\170",
			"\1\171",
			"\1\172",
			"\1\173",
			"\1\174",
			"\1\175",
			"\1\32\2\uffff\13\32\6\uffff\32\32\4\uffff\1\32\1\uffff\32\32",
			"\1\177",
			"\1\u0080",
			"\1\32\2\uffff\13\32\6\uffff\32\32\4\uffff\1\32\1\uffff\32\32",
			"\1\u0082\14\uffff\1\u0083",
			"\1\32\2\uffff\13\32\6\uffff\32\32\4\uffff\1\32\1\uffff\32\32",
			"\1\32\2\uffff\13\32\6\uffff\32\32\4\uffff\1\32\1\uffff\32\32",
			"",
			"\1\u0085",
			"\1\u0086",
			"",
			"\1\u0087",
			"\1\u0088\13\uffff\1\u0089",
			"\1\u008a",
			"\1\u008b",
			"\1\u008c",
			"\1\u008d",
			"\1\32\2\uffff\13\32\6\uffff\32\32\4\uffff\1\32\1\uffff\32\32",
			"\1\u008f",
			"",
			"\1\32\2\uffff\13\32\6\uffff\32\32\4\uffff\1\32\1\uffff\32\32",
			"\1\32\2\uffff\13\32\6\uffff\10\32\1\u0091\13\32\1\u0092\5\32"
					+ "\4\uffff\1\32\1\uffff\32\32", "", "\1\u0094",
			"\1\u0095", "",
			"\1\32\2\uffff\13\32\6\uffff\32\32\4\uffff\1\32\1\uffff\32\32",
			"\1\32\2\uffff\13\32\6\uffff\32\32\4\uffff\1\32\1\uffff\32\32",
			"\1\u0098", "\1\u0099", "\1\u009a", "\1\u009b", "\1\u009c",
			"\1\u009d", "\1\u009e", "", "\1\u009f", "", "\1\u00a0", "\1\u00a1",
			"", "\1\u00a2", "\1\u00a3", "", "",
			"\1\32\2\uffff\13\32\6\uffff\32\32\4\uffff\1\32\1\uffff\32\32",
			"\1\u00a4", "\1\u00a5", "\1\u00a6", "\1\u00a7", "\1\u00a8",
			"\1\32\2\uffff\13\32\6\uffff\32\32\4\uffff\1\32\1\uffff\32\32",
			"\1\u00aa", "\1\u00ab", "\1\u00ac", "\1\u00ad", "\1\u00ae",
			"\1\u00af", "\1\u00b0", "\1\u00b1", "\1\u00b2", "\1\u00b3", "",
			"\1\32\2\uffff\13\32\6\uffff\32\32\4\uffff\1\32\1\uffff\32\32",
			"\1\u00b5", "\1\u00b6", "\1\u00b7", "\1\u00b8", "\1\u00b9",
			"\1\u00ba", "\1\u00bb", "\1\u00bc",
			"\1\32\2\uffff\13\32\6\uffff\32\32\4\uffff\1\32\1\uffff\32\32", "",
			"\1\u00bd", "\1\u00be", "\1\u00bf", "\1\u00c0", "\1\u00c1",
			"\1\32\2\uffff\13\32\6\uffff\32\32\4\uffff\1\32\1\uffff\32\32",
			"\1\u00c3", "\1\u00c4", "\1\u00c5",
			"\1\32\2\uffff\13\32\6\uffff\32\32\4\uffff\1\32\1\uffff\32\32",
			"\1\u00c6", "\1\u00c7", "\1\u00c8", "", "\1\u00c9",
			"\1\32\2\uffff\13\32\6\uffff\32\32\4\uffff\1\32\1\uffff\32\32",
			"\1\u00ca",
			"\1\32\2\uffff\13\32\6\uffff\32\32\4\uffff\1\32\1\uffff\32\32",
			"\1\u00cc", "\1\u00cd", "\1\u00ce", "\1\u00cf", "", "\1\u00d0",
			"\1\u00d1",
			"\1\32\2\uffff\13\32\6\uffff\32\32\4\uffff\1\32\1\uffff\32\32",
			"\1\u00d2", "\1\u00d3", "\1\u00d4", "\1\u00d5",
			"\1\32\2\uffff\13\32\6\uffff\32\32\4\uffff\1\32\1\uffff\32\32",
			"\1\u00d7", "\1\u00d8", "", "\1\u00d9", "\1\u00da",
			"\1\32\2\uffff\13\32\6\uffff\32\32\4\uffff\1\32\1\uffff\32\32",
			"\1\32\2\uffff\13\32\6\uffff\32\32\4\uffff\1\32\1\uffff\32\32", "" };
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
			return "1:1: Tokens : ( VARIABLE_TYPE | ADD | REMOVE | WHERE | NOT_EQUAL | EQUAL | IN | SELECT | ASSERTED | COLON | DOT | PLUS | CREATE | CREATE_INTERSECTION | CREATE_DISJUNCTION | BEGIN | END | OPEN_SQUARE_BRACKET | CLOSED_SQUARE_BRACKET | SUPER_CLASS_OF | SUPER_PROPERTY_OF | MATCH | FAIL | VALUES | RENDERING | GROUPS | ESCLAMATION_MARK | VARIABLE_NAME | MOWLLexer. Tokens );";
		}
	}
}