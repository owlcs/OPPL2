package org.coode.parsers.oppl.patterns;

// $ANTLR 3.2 Sep 23, 2009 12:02:23 OPPLLexer.g 2010-11-22 10:25:30
import org.antlr.runtime.BaseRecognizer;
import org.antlr.runtime.CharStream;
import org.antlr.runtime.DFA;
import org.antlr.runtime.Lexer;
import org.antlr.runtime.MismatchedSetException;
import org.antlr.runtime.NoViableAltException;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.RecognizerSharedState;

public class OPPLPatternLexer_OPPLLexer extends Lexer {
	public static final int COMMA = 37;
	public static final int GREATER_THAN = 508;
	public static final int ASSERTED = 76;
	public static final int END = 84;
	public static final int HYPHEN = 465;
	public static final int DIFFERENT_FROM = 24;
	public static final int LESS_THAN = 506;
	public static final int TYPE_ASSERTION = 66;
	public static final int SAME_AS_AXIOM = 52;
	public static final int TYPES = 39;
	public static final int ROLE_ASSERTION = 67;
	public static final int ESCLAMATION_MARK = 149;
	public static final int DOT = 78;
	public static final int ALL_RESTRICTION = 62;
	public static final int QUESTION_MARK = 46;
	public static final int AND = 10;
	public static final int EXPRESSION = 69;
	public static final int CONSTANT = 70;
	public static final int VALUE_RESTRICTION = 63;
	public static final int ONE_OF = 65;
	public static final int SUBPROPERTY_OF = 105;
	public static final int THIS_CLASS = 416;
	public static final int SELECT = 75;
	public static final int CARDINALITY_RESTRICTION = 64;
	public static final int SAME_AS = 23;
	public static final int EXACTLY = 17;
	public static final int PLUS = 79;
	public static final int TRANSITIVE = 34;
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
	public static final int SYMMETRIC = 30;
	public static final int DOLLAR = 400;
	public static final int DISJOINT_WITH = 26;
	public static final int VARIABLE_TYPE = 89;
	public static final int DISJUNCTION = 55;
	public static final int GROUPS = 356;
	public static final int NEGATED_EXPRESSION = 58;
	public static final int EQUAL = 73;
	public static final int SEMICOLON = 422;
	public static final int DIFFERENT_FROM_AXIOM = 53;
	public static final int GREATER_THAN_EQUAL = 509;
	public static final int EQUIVALENT_TO = 22;
	public static final int DOMAIN = 27;
	public static final int SUB_PROPERTY_OF = 21;
	public static final int INVERSE_OBJECT_PROPERTY_EXPRESSION = 68;
	public static final int INVERSE_PROPERTY = 60;
	public static final int COLON = 77;
	public static final int SUB_CLASS_AXIOM = 48;
	public static final int SUB_PROPERTY_AXIOM = 51;
	public static final int IDENTIFIER = 44;
	public static final int UNARY_AXIOM = 54;
	public static final int ADD = 90;
	public static final int WHERE = 71;
	public static final int CREATE = 80;
	public static final int OPEN_CURLY_BRACES = 6;
	public static final int CLOSED_SQUARE_BRACKET = 86;
	public static final int INSTANCE_OF = 38;
	public static final int VALUES = 354;
	public static final int SOME_RESTRICTION = 61;
	public static final int IRI = 110;
	public static final int LESS_THAN_EQUAL = 507;
	public static final int VALUE = 18;
	public static final int RENDERING = 355;
	public static final int INVERSE_FUNCTIONAL = 35;
	public static final int OR = 11;
	public static final int INTEGER = 42;
	public static final int INVERSE = 19;
	public static final int HAS_KEY = 109;
	public static final int DISJOINT_WITH_AXIOM = 50;
	public static final int SUPER_CLASS_OF = 87;
	public static final int DIGIT = 41;
	public static final int COMPOSITION = 4;
	public static final int FUNCTIONAL = 29;
	public static final int NOT_EQUAL = 72;
	public static final int LETTER = 43;
	public static final int MAX = 16;
	public static final int FAIL = 536;
	public static final int NEGATED_ASSERTION = 59;
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
	public static final int SOME = 13;
	public static final int RETURN = 415;
	public static final int EOF = -1;
	public static final int ANTI_SYMMETRIC = 31;
	public static final int Tokens = 47;
	public static final int CLOSED_CURLY_BRACES = 7;
	public static final int IRI_ATTRIBUTE_NAME = 112;
	public static final int REFLEXIVE = 32;
	public static final int NOT = 12;
	public static final int OPEN_PARENTHESYS = 5;
	public static final int VARIABLE_NAME = 464;
	public static final int IRREFLEXIVE = 33;
	// delegates
	public OPPLPatternLexer_OPPLLexer_MOWLLexer gMOWLLexer;
	// delegators
	public OPPLPatternLexer gOPPLPatternLexer;
	public OPPLPatternLexer gParent;

	public OPPLPatternLexer_OPPLLexer() {
		;
	}

	public OPPLPatternLexer_OPPLLexer(CharStream input, OPPLPatternLexer gOPPLPatternLexer) {
		this(input, new RecognizerSharedState(), gOPPLPatternLexer);
	}

	public OPPLPatternLexer_OPPLLexer(CharStream input, RecognizerSharedState state,
			OPPLPatternLexer gOPPLPatternLexer) {
		super(input, state);
		this.gMOWLLexer = new OPPLPatternLexer_OPPLLexer_MOWLLexer(input, state, gOPPLPatternLexer,
				this);
		this.gOPPLPatternLexer = gOPPLPatternLexer;
		this.gParent = gOPPLPatternLexer;
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
			// 'ANNOTATIONPROPERTY' | 'INDIVIDUAL' | 'CONSTANT' )
			int alt1 = 6;
			switch (this.input.LA(1)) {
			case 'C': {
				int LA1_1 = this.input.LA(2);
				if (LA1_1 == 'L') {
					alt1 = 1;
				} else if (LA1_1 == 'O') {
					alt1 = 6;
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
			case 'A': {
				alt1 = 4;
			}
				break;
			case 'I': {
				alt1 = 5;
			}
				break;
			default:
				NoViableAltException nvae = new NoViableAltException("", 1, 0, this.input);
				throw nvae;
			}
			switch (alt1) {
			case 1:
				// OPPLLexer.g:15:2: 'CLASS'
			{
				this.match("CLASS");
			}
				break;
			case 2:
				// OPPLLexer.g:16:4: 'OBJECTPROPERTY'
			{
				this.match("OBJECTPROPERTY");
			}
				break;
			case 3:
				// OPPLLexer.g:17:4: 'DATAPROPERTY'
			{
				this.match("DATAPROPERTY");
			}
				break;
			case 4:
				// OPPLLexer.g:18:4: 'ANNOTATIONPROPERTY'
			{
				this.match("ANNOTATIONPROPERTY");
			}
				break;
			case 5:
				// OPPLLexer.g:19:4: 'INDIVIDUAL'
			{
				this.match("INDIVIDUAL");
			}
				break;
			case 6:
				// OPPLLexer.g:20:4: 'CONSTANT'
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
			// OPPLLexer.g:29:3: ( 'ADD' )
			// OPPLLexer.g:30:5: 'ADD'
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
			// OPPLLexer.g:34:3: ( 'REMOVE' )
			// OPPLLexer.g:35:5: 'REMOVE'
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
			// OPPLLexer.g:39:3: ( 'WHERE' )
			// OPPLLexer.g:40:5: 'WHERE'
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
			// OPPLLexer.g:44:3: ( '!=' )
			// OPPLLexer.g:45:5: '!='
			{
				this.match("!=");
			}
			this.state.type = _type;
			this.state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "NOT_EQUAL"
	// $ANTLR start "IN"
	public final void mIN() throws RecognitionException {
		try {
			int _type = IN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// OPPLLexer.g:49:3: ( 'IN' )
			// OPPLLexer.g:50:5: 'IN'
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
			// OPPLLexer.g:54:3: ( 'SELECT' )
			// OPPLLexer.g:55:5: 'SELECT'
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
			// OPPLLexer.g:59:3: ( 'ASSERTED' )
			// OPPLLexer.g:60:5: 'ASSERTED'
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
			// OPPLLexer.g:64:3: ( ':' )
			// OPPLLexer.g:65:5: ':'
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
			// OPPLLexer.g:69:3: ( '.' )
			// OPPLLexer.g:70:5: '.'
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
			// OPPLLexer.g:76:3: ( '+' )
			// OPPLLexer.g:77:5: '+'
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
			// OPPLLexer.g:83:3: ( 'create' )
			// OPPLLexer.g:84:5: 'create'
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
			// OPPLLexer.g:88:3: ( 'createIntersection' | 'CreateIntersection' )
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
				// OPPLLexer.g:89:5: 'createIntersection'
			{
				this.match("createIntersection");
			}
				break;
			case 2:
				// OPPLLexer.g:89:28: 'CreateIntersection'
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
			// OPPLLexer.g:93:3: ( 'createUnion' | 'CreateUnion' )
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
				// OPPLLexer.g:94:5: 'createUnion'
			{
				this.match("createUnion");
			}
				break;
			case 2:
				// OPPLLexer.g:94:21: 'CreateUnion'
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
			// OPPLLexer.g:98:3: ( 'BEGIN' )
			// OPPLLexer.g:99:5: 'BEGIN'
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
			// OPPLLexer.g:103:3: ( 'END;' )
			// OPPLLexer.g:104:5: 'END;'
			{
				this.match("END;");
			}
			this.state.type = _type;
			this.state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "END"
	// $ANTLR start "SUPER_CLASS_OF"
	public final void mSUPER_CLASS_OF() throws RecognitionException {
		try {
			int _type = SUPER_CLASS_OF;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// OPPLLexer.g:110:3: ( 'superClassOf' )
			// OPPLLexer.g:111:5: 'superClassOf'
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
			// OPPLLexer.g:115:3: ( 'superPropertyOf' )
			// OPPLLexer.g:116:5: 'superPropertyOf'
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
			// OPPLLexer.g:120:3: ( 'MATCH' | 'Match' )
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
				// OPPLLexer.g:121:4: 'MATCH'
			{
				this.match("MATCH");
			}
				break;
			case 2:
				// OPPLLexer.g:122:6: 'Match'
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
			// OPPLLexer.g:126:2: ( 'FAIL' | 'fail' | 'Fail' )
			int alt5 = 3;
			int LA5_0 = this.input.LA(1);
			if (LA5_0 == 'F') {
				int LA5_1 = this.input.LA(2);
				if (LA5_1 == 'A') {
					alt5 = 1;
				} else if (LA5_1 == 'a') {
					alt5 = 3;
				} else {
					NoViableAltException nvae = new NoViableAltException("", 5, 1, this.input);
					throw nvae;
				}
			} else if (LA5_0 == 'f') {
				alt5 = 2;
			} else {
				NoViableAltException nvae = new NoViableAltException("", 5, 0, this.input);
				throw nvae;
			}
			switch (alt5) {
			case 1:
				// OPPLLexer.g:127:3: 'FAIL'
			{
				this.match("FAIL");
			}
				break;
			case 2:
				// OPPLLexer.g:128:5: 'fail'
			{
				this.match("fail");
			}
				break;
			case 3:
				// OPPLLexer.g:129:5: 'Fail'
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
			// OPPLLexer.g:133:3: ( 'VALUES' )
			// OPPLLexer.g:134:5: 'VALUES'
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
			// OPPLLexer.g:139:3: ( 'RENDERING' )
			// OPPLLexer.g:140:5: 'RENDERING'
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
			// OPPLLexer.g:145:3: ( 'GROUPS' )
			// OPPLLexer.g:146:5: 'GROUPS'
			{
				this.match("GROUPS");
			}
			this.state.type = _type;
			this.state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "GROUPS"
	// $ANTLR start "IRI_ATTRIBUTE_NAME"
	public final void mIRI_ATTRIBUTE_NAME() throws RecognitionException {
		try {
			int _type = IRI_ATTRIBUTE_NAME;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// OPPLLexer.g:150:2: ( 'IRI' )
			// OPPLLexer.g:151:3: 'IRI'
			{
				this.match("IRI");
			}
			this.state.type = _type;
			this.state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "IRI_ATTRIBUTE_NAME"
	// $ANTLR start "QUESTION_MARK"
	public final void mQUESTION_MARK() throws RecognitionException {
		try {
			// OPPLLexer.g:156:3: ( '?' )
			// OPPLLexer.g:157:5: '?'
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
			// OPPLLexer.g:161:3: ( '!' )
			// OPPLLexer.g:162:5: '!'
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
			// OPPLLexer.g:166:3: ( QUESTION_MARK LETTER ( LETTER | DIGIT | '-'
			// | '_' )* )
			// OPPLLexer.g:167:5: QUESTION_MARK LETTER ( LETTER | DIGIT | '-' |
			// '_' )*
			{
				this.mQUESTION_MARK();
				this.gMOWLLexer.mLETTER();
				// OPPLLexer.g:167:26: ( LETTER | DIGIT | '-' | '_' )*
				loop6: do {
					int alt6 = 2;
					int LA6_0 = this.input.LA(1);
					if (LA6_0 == '-' || LA6_0 >= '0' && LA6_0 <= '9' || LA6_0 >= 'A'
							&& LA6_0 <= 'Z' || LA6_0 == '_' || LA6_0 >= 'a' && LA6_0 <= 'z') {
						alt6 = 1;
					}
					switch (alt6) {
					case 1:
						// OPPLLexer.g:
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
		// IN | SELECT | ASSERTED | COLON | DOT | PLUS | CREATE |
		// CREATE_INTERSECTION | CREATE_DISJUNCTION | BEGIN | END |
		// SUPER_CLASS_OF | SUPER_PROPERTY_OF | MATCH | FAIL | VALUES |
		// RENDERING | GROUPS | IRI_ATTRIBUTE_NAME | ESCLAMATION_MARK |
		// VARIABLE_NAME | MOWLLexer. Tokens )
		int alt7 = 27;
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
			// OPPLLexer.g:1:51: IN
		{
			this.mIN();
		}
			break;
		case 7:
			// OPPLLexer.g:1:54: SELECT
		{
			this.mSELECT();
		}
			break;
		case 8:
			// OPPLLexer.g:1:61: ASSERTED
		{
			this.mASSERTED();
		}
			break;
		case 9:
			// OPPLLexer.g:1:70: COLON
		{
			this.mCOLON();
		}
			break;
		case 10:
			// OPPLLexer.g:1:76: DOT
		{
			this.mDOT();
		}
			break;
		case 11:
			// OPPLLexer.g:1:80: PLUS
		{
			this.mPLUS();
		}
			break;
		case 12:
			// OPPLLexer.g:1:85: CREATE
		{
			this.mCREATE();
		}
			break;
		case 13:
			// OPPLLexer.g:1:92: CREATE_INTERSECTION
		{
			this.mCREATE_INTERSECTION();
		}
			break;
		case 14:
			// OPPLLexer.g:1:112: CREATE_DISJUNCTION
		{
			this.mCREATE_DISJUNCTION();
		}
			break;
		case 15:
			// OPPLLexer.g:1:131: BEGIN
		{
			this.mBEGIN();
		}
			break;
		case 16:
			// OPPLLexer.g:1:137: END
		{
			this.mEND();
		}
			break;
		case 17:
			// OPPLLexer.g:1:141: SUPER_CLASS_OF
		{
			this.mSUPER_CLASS_OF();
		}
			break;
		case 18:
			// OPPLLexer.g:1:156: SUPER_PROPERTY_OF
		{
			this.mSUPER_PROPERTY_OF();
		}
			break;
		case 19:
			// OPPLLexer.g:1:174: MATCH
		{
			this.mMATCH();
		}
			break;
		case 20:
			// OPPLLexer.g:1:180: FAIL
		{
			this.mFAIL();
		}
			break;
		case 21:
			// OPPLLexer.g:1:185: VALUES
		{
			this.mVALUES();
		}
			break;
		case 22:
			// OPPLLexer.g:1:192: RENDERING
		{
			this.mRENDERING();
		}
			break;
		case 23:
			// OPPLLexer.g:1:202: GROUPS
		{
			this.mGROUPS();
		}
			break;
		case 24:
			// OPPLLexer.g:1:209: IRI_ATTRIBUTE_NAME
		{
			this.mIRI_ATTRIBUTE_NAME();
		}
			break;
		case 25:
			// OPPLLexer.g:1:228: ESCLAMATION_MARK
		{
			this.mESCLAMATION_MARK();
		}
			break;
		case 26:
			// OPPLLexer.g:1:245: VARIABLE_NAME
		{
			this.mVARIABLE_NAME();
		}
			break;
		case 27:
			// OPPLLexer.g:1:259: MOWLLexer. Tokens
		{
			this.gMOWLLexer.mTokens();
		}
			break;
		}
	}

	protected DFA7 dfa7 = new DFA7(this);
	static final String DFA7_eotS = "\1\uffff\7\27\1\45\1\27\3\uffff\11\27\2\uffff\10\27\1\73\3\27\2"
			+ "\uffff\22\27\1\122\2\27\1\uffff\1\125\25\27\1\uffff\2\27\1\uffff"
			+ "\6\27\1\uffff\3\27\3\166\2\27\1\171\11\27\1\u0083\2\27\1\u0086\1"
			+ "\27\2\u0089\1\uffff\2\27\1\uffff\7\27\1\u0094\1\27\1\uffff\1\u0096"
			+ "\1\u0099\1\uffff\2\27\1\uffff\1\u009c\1\u009d\10\27\1\uffff\1\27"
			+ "\1\uffff\2\27\1\uffff\2\27\2\uffff\1\171\5\27\1\u00b0\13\27\1\uffff"
			+ "\1\27\1\u00bd\11\27\1\171\1\uffff\5\27\1\u00cc\4\27\1\u00cc\3\27"
			+ "\1\uffff\1\27\1\171\2\27\1\u00d7\5\27\1\uffff\2\27\1\171\6\27\1"
			+ "\u00e5\3\27\1\uffff\3\27\1\u00ec\1\171\1\u00ec\1\uffff";
	static final String DFA7_eofS = "\u00ed\uffff";
	static final String DFA7_minS = "\1\11\1\114\1\102\1\101\1\104\1\116\1\105\1\110\1\75\1\105\3\uffff"
			+ "\1\162\1\105\1\116\1\165\2\101\1\141\1\101\1\122\2\uffff\1\101\1"
			+ "\116\1\145\1\112\1\124\1\116\1\104\1\123\1\55\1\111\1\115\1\105"
			+ "\2\uffff\1\114\1\145\1\107\1\104\1\160\1\124\1\164\1\111\2\151\1"
			+ "\114\1\117\2\123\1\141\1\105\1\101\1\117\1\55\1\105\1\111\1\uffff"
			+ "\1\55\1\117\1\104\1\122\1\105\1\141\1\111\1\73\1\145\1\103\1\143"
			+ "\1\114\2\154\2\125\1\123\1\124\1\164\1\103\1\120\1\124\1\uffff\1"
			+ "\122\1\126\1\uffff\1\126\2\105\1\103\1\164\1\116\1\uffff\1\162\1"
			+ "\110\1\150\3\55\1\105\1\120\1\55\1\101\1\145\1\124\1\122\1\101\1"
			+ "\124\1\111\1\105\1\122\1\55\1\124\1\145\1\55\1\103\2\55\1\uffff"
			+ "\2\123\1\uffff\1\116\1\111\1\120\1\117\1\124\1\105\1\104\1\55\1"
			+ "\111\1\uffff\2\55\1\uffff\1\154\1\162\1\uffff\2\55\1\124\2\156\1"
			+ "\122\1\120\1\111\1\104\1\125\1\uffff\1\116\1\uffff\2\156\1\uffff"
			+ "\1\141\1\157\2\uffff\1\55\1\164\1\151\1\117\1\105\1\117\1\55\1\101"
			+ "\1\107\1\164\1\151\1\163\1\160\1\145\1\157\1\120\1\122\1\116\1\uffff"
			+ "\1\114\1\55\1\145\1\157\1\163\1\145\1\162\1\156\1\105\1\124\1\120"
			+ "\1\55\1\uffff\1\162\1\156\1\117\1\162\1\163\1\55\1\122\1\131\1\122"
			+ "\1\163\1\55\1\146\1\164\1\145\1\uffff\1\124\1\55\1\117\1\145\1\55"
			+ "\1\171\1\143\1\131\1\120\1\143\1\uffff\1\117\1\164\1\55\1\105\1"
			+ "\164\1\146\1\151\1\122\1\151\1\55\1\157\1\124\1\157\1\uffff\1\156"
			+ "\1\131\1\156\3\55\1\uffff";
	static final String DFA7_maxS = "\1\175\1\162\1\102\1\101\1\123\1\122\1\105\1\110\1\75\1\105\3\uffff"
			+ "\1\162\1\105\1\116\1\165\3\141\1\101\1\122\2\uffff\1\101\1\116\1"
			+ "\145\1\112\1\124\1\116\1\104\1\123\1\172\1\111\1\116\1\105\2\uffff"
			+ "\1\114\1\145\1\107\1\104\1\160\1\124\1\164\1\111\2\151\1\114\1\117"
			+ "\2\123\1\141\1\105\1\101\1\117\1\172\1\105\1\111\1\uffff\1\172\1"
			+ "\117\1\104\1\122\1\105\1\141\1\111\1\73\1\145\1\103\1\143\1\114"
			+ "\2\154\2\125\1\123\1\124\1\164\1\103\1\120\1\124\1\uffff\1\122\1"
			+ "\126\1\uffff\1\126\2\105\1\103\1\164\1\116\1\uffff\1\162\1\110\1"
			+ "\150\3\172\1\105\1\120\1\172\1\101\1\145\1\124\1\122\1\101\1\124"
			+ "\1\111\1\105\1\122\1\172\1\124\1\145\1\172\1\120\2\172\1\uffff\2"
			+ "\123\1\uffff\1\116\1\125\1\120\1\117\1\124\1\105\1\104\1\172\1\111"
			+ "\1\uffff\2\172\1\uffff\1\154\1\162\1\uffff\2\172\1\124\2\156\1\122"
			+ "\1\120\1\111\1\104\1\125\1\uffff\1\116\1\uffff\2\156\1\uffff\1\141"
			+ "\1\157\2\uffff\1\172\1\164\1\151\1\117\1\105\1\117\1\172\1\101\1"
			+ "\107\1\164\1\151\1\163\1\160\1\145\1\157\1\120\1\122\1\116\1\uffff"
			+ "\1\114\1\172\1\145\1\157\1\163\1\145\1\162\1\156\1\105\1\124\1\120"
			+ "\1\172\1\uffff\1\162\1\156\1\117\1\162\1\163\1\172\1\122\1\131\1"
			+ "\122\1\163\1\172\1\146\1\164\1\145\1\uffff\1\124\1\172\1\117\1\145"
			+ "\1\172\1\171\1\143\1\131\1\120\1\143\1\uffff\1\117\1\164\1\172\1"
			+ "\105\1\164\1\146\1\151\1\122\1\151\1\172\1\157\1\124\1\157\1\uffff"
			+ "\1\156\1\131\1\156\3\172\1\uffff";
	static final String DFA7_acceptS = "\12\uffff\1\11\1\12\1\13\11\uffff\1\32\1\33\14\uffff\1\5\1\31\25"
			+ "\uffff\1\6\26\uffff\1\2\2\uffff\1\30\6\uffff\1\20\31\uffff\1\24"
			+ "\2\uffff\1\1\11\uffff\1\4\2\uffff\1\17\2\uffff\1\23\12\uffff\1\3"
			+ "\1\uffff\1\7\2\uffff\1\14\2\uffff\1\25\1\27\22\uffff\1\10\14\uffff"
			+ "\1\26\16\uffff\1\16\12\uffff\1\21\15\uffff\1\22\6\uffff\1\15";
	static final String DFA7_specialS = "\u00ed\uffff}>";
	static final String[] DFA7_transitionS = {
			"\2\27\2\uffff\1\27\22\uffff\1\27\1\10\1\27\4\uffff\3\27\1\uffff"
					+ "\1\14\1\27\1\uffff\1\13\1\uffff\12\27\1\12\1\uffff\3\27\1\26"
					+ "\1\uffff\1\4\1\16\1\1\1\3\1\17\1\22\1\25\1\27\1\5\3\27\1\21"
					+ "\1\27\1\2\2\27\1\6\1\11\2\27\1\24\1\7\4\27\1\uffff\2\27\2\uffff"
					+ "\2\27\1\15\2\27\1\23\14\27\1\20\10\27\1\uffff\1\27",
			"\1\30\2\uffff\1\31\42\uffff\1\32",
			"\1\33",
			"\1\34",
			"\1\36\11\uffff\1\35\4\uffff\1\37",
			"\1\40\3\uffff\1\41",
			"\1\42",
			"\1\43",
			"\1\44",
			"\1\46",
			"",
			"",
			"",
			"\1\47",
			"\1\50",
			"\1\51",
			"\1\52",
			"\1\53\37\uffff\1\54",
			"\1\55\37\uffff\1\56",
			"\1\57",
			"\1\60",
			"\1\61",
			"",
			"",
			"\1\62",
			"\1\63",
			"\1\64",
			"\1\65",
			"\1\66",
			"\1\67",
			"\1\70",
			"\1\71",
			"\1\27\2\uffff\13\27\6\uffff\3\27\1\72\26\27\4\uffff\1\27\1" + "\uffff\32\27",
			"\1\74",
			"\1\75\1\76",
			"\1\77",
			"",
			"",
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
			"\1\121",
			"\1\27\2\uffff\13\27\6\uffff\32\27\4\uffff\1\27\1\uffff\32\27",
			"\1\123",
			"\1\124",
			"",
			"\1\27\2\uffff\13\27\6\uffff\32\27\4\uffff\1\27\1\uffff\32\27",
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
			"\1\150",
			"\1\151",
			"\1\152",
			"",
			"\1\153",
			"\1\154",
			"",
			"\1\155",
			"\1\156",
			"\1\157",
			"\1\160",
			"\1\161",
			"\1\162",
			"",
			"\1\163",
			"\1\164",
			"\1\165",
			"\1\27\2\uffff\13\27\6\uffff\32\27\4\uffff\1\27\1\uffff\32\27",
			"\1\27\2\uffff\13\27\6\uffff\32\27\4\uffff\1\27\1\uffff\32\27",
			"\1\27\2\uffff\13\27\6\uffff\32\27\4\uffff\1\27\1\uffff\32\27",
			"\1\167",
			"\1\170",
			"\1\27\2\uffff\13\27\6\uffff\32\27\4\uffff\1\27\1\uffff\32\27",
			"\1\172",
			"\1\173",
			"\1\174",
			"\1\175",
			"\1\176",
			"\1\177",
			"\1\u0080",
			"\1\u0081",
			"\1\u0082",
			"\1\27\2\uffff\13\27\6\uffff\32\27\4\uffff\1\27\1\uffff\32\27",
			"\1\u0084",
			"\1\u0085",
			"\1\27\2\uffff\13\27\6\uffff\32\27\4\uffff\1\27\1\uffff\32\27",
			"\1\u0087\14\uffff\1\u0088",
			"\1\27\2\uffff\13\27\6\uffff\32\27\4\uffff\1\27\1\uffff\32\27",
			"\1\27\2\uffff\13\27\6\uffff\32\27\4\uffff\1\27\1\uffff\32\27",
			"",
			"\1\u008a",
			"\1\u008b",
			"",
			"\1\u008c",
			"\1\u008d\13\uffff\1\u008e",
			"\1\u008f",
			"\1\u0090",
			"\1\u0091",
			"\1\u0092",
			"\1\u0093",
			"\1\27\2\uffff\13\27\6\uffff\32\27\4\uffff\1\27\1\uffff\32\27",
			"\1\u0095",
			"",
			"\1\27\2\uffff\13\27\6\uffff\32\27\4\uffff\1\27\1\uffff\32\27",
			"\1\27\2\uffff\13\27\6\uffff\10\27\1\u0097\13\27\1\u0098\5\27"
					+ "\4\uffff\1\27\1\uffff\32\27", "", "\1\u009a", "\1\u009b", "",
			"\1\27\2\uffff\13\27\6\uffff\32\27\4\uffff\1\27\1\uffff\32\27",
			"\1\27\2\uffff\13\27\6\uffff\32\27\4\uffff\1\27\1\uffff\32\27", "\1\u009e", "\1\u009f",
			"\1\u00a0", "\1\u00a1", "\1\u00a2", "\1\u00a3", "\1\u00a4", "\1\u00a5", "", "\1\u00a6",
			"", "\1\u00a7", "\1\u00a8", "", "\1\u00a9", "\1\u00aa", "", "",
			"\1\27\2\uffff\13\27\6\uffff\32\27\4\uffff\1\27\1\uffff\32\27", "\1\u00ab", "\1\u00ac",
			"\1\u00ad", "\1\u00ae", "\1\u00af",
			"\1\27\2\uffff\13\27\6\uffff\32\27\4\uffff\1\27\1\uffff\32\27", "\1\u00b1", "\1\u00b2",
			"\1\u00b3", "\1\u00b4", "\1\u00b5", "\1\u00b6", "\1\u00b7", "\1\u00b8", "\1\u00b9",
			"\1\u00ba", "\1\u00bb", "", "\1\u00bc",
			"\1\27\2\uffff\13\27\6\uffff\32\27\4\uffff\1\27\1\uffff\32\27", "\1\u00be", "\1\u00bf",
			"\1\u00c0", "\1\u00c1", "\1\u00c2", "\1\u00c3", "\1\u00c4", "\1\u00c5", "\1\u00c6",
			"\1\27\2\uffff\13\27\6\uffff\32\27\4\uffff\1\27\1\uffff\32\27", "", "\1\u00c7",
			"\1\u00c8", "\1\u00c9", "\1\u00ca", "\1\u00cb",
			"\1\27\2\uffff\13\27\6\uffff\32\27\4\uffff\1\27\1\uffff\32\27", "\1\u00cd", "\1\u00ce",
			"\1\u00cf", "\1\u00d0", "\1\27\2\uffff\13\27\6\uffff\32\27\4\uffff\1\27\1\uffff\32\27",
			"\1\u00d1", "\1\u00d2", "\1\u00d3", "", "\1\u00d4",
			"\1\27\2\uffff\13\27\6\uffff\32\27\4\uffff\1\27\1\uffff\32\27", "\1\u00d5", "\1\u00d6",
			"\1\27\2\uffff\13\27\6\uffff\32\27\4\uffff\1\27\1\uffff\32\27", "\1\u00d8", "\1\u00d9",
			"\1\u00da", "\1\u00db", "\1\u00dc", "", "\1\u00dd", "\1\u00de",
			"\1\27\2\uffff\13\27\6\uffff\32\27\4\uffff\1\27\1\uffff\32\27", "\1\u00df", "\1\u00e0",
			"\1\u00e1", "\1\u00e2", "\1\u00e3", "\1\u00e4",
			"\1\27\2\uffff\13\27\6\uffff\32\27\4\uffff\1\27\1\uffff\32\27", "\1\u00e6", "\1\u00e7",
			"\1\u00e8", "", "\1\u00e9", "\1\u00ea", "\1\u00eb",
			"\1\27\2\uffff\13\27\6\uffff\32\27\4\uffff\1\27\1\uffff\32\27",
			"\1\27\2\uffff\13\27\6\uffff\32\27\4\uffff\1\27\1\uffff\32\27",
			"\1\27\2\uffff\13\27\6\uffff\32\27\4\uffff\1\27\1\uffff\32\27", "" };
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
			return "1:1: Tokens : ( VARIABLE_TYPE | ADD | REMOVE | WHERE | NOT_EQUAL | IN | SELECT | ASSERTED | COLON | DOT | PLUS | CREATE | CREATE_INTERSECTION | CREATE_DISJUNCTION | BEGIN | END | SUPER_CLASS_OF | SUPER_PROPERTY_OF | MATCH | FAIL | VALUES | RENDERING | GROUPS | IRI_ATTRIBUTE_NAME | ESCLAMATION_MARK | VARIABLE_NAME | MOWLLexer. Tokens );";
		}
	}
}