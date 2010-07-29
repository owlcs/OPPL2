package org.coode.parsers.oppl;

// $ANTLR 3.2 Sep 23, 2009 12:02:23 MOWLLexer.g 2010-07-29 13:13:44
import org.antlr.runtime.BaseRecognizer;
import org.antlr.runtime.CharStream;
import org.antlr.runtime.DFA;
import org.antlr.runtime.EarlyExitException;
import org.antlr.runtime.Lexer;
import org.antlr.runtime.MismatchedSetException;
import org.antlr.runtime.NoViableAltException;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.RecognizerSharedState;

public class OPPLLexer_MOWLLexer extends Lexer {
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
	// delegators
	public OPPLLexer gOPPLLexer;
	public OPPLLexer gParent;

	public OPPLLexer_MOWLLexer() {
		;
	}

	public OPPLLexer_MOWLLexer(CharStream input, OPPLLexer gOPPLLexer) {
		this(input, new RecognizerSharedState(), gOPPLLexer);
	}

	public OPPLLexer_MOWLLexer(CharStream input, RecognizerSharedState state, OPPLLexer gOPPLLexer) {
		super(input, state);
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
	// $ANTLR start "WHITESPACE"
	public final void mWHITESPACE() throws RecognitionException {
		try {
			int _type = WHITESPACE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// MOWLLexer.g:30:13: ( ( ' ' | '\\t' | '\\n' | '\\r' ) )
			// MOWLLexer.g:30:15: ( ' ' | '\\t' | '\\n' | '\\r' )
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
			// MOWLLexer.g:33:5: ( 'and' )
			// MOWLLexer.g:33:7: 'and'
			{
				this.match("and");
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
			// MOWLLexer.g:35:5: ( 'or' )
			// MOWLLexer.g:35:7: 'or'
			{
				this.match("or");
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
			// MOWLLexer.g:37:5: ( 'not' | 'NOT' | 'Not' )
			int alt1 = 3;
			int LA1_0 = this.input.LA(1);
			if (LA1_0 == 'n') {
				alt1 = 1;
			} else if (LA1_0 == 'N') {
				int LA1_2 = this.input.LA(2);
				if (LA1_2 == 'O') {
					alt1 = 2;
				} else if (LA1_2 == 'o') {
					alt1 = 3;
				} else {
					NoViableAltException nvae = new NoViableAltException("", 1, 2, this.input);
					throw nvae;
				}
			} else {
				NoViableAltException nvae = new NoViableAltException("", 1, 0, this.input);
				throw nvae;
			}
			switch (alt1) {
			case 1:
				// MOWLLexer.g:37:7: 'not'
			{
				this.match("not");
			}
				break;
			case 2:
				// MOWLLexer.g:37:15: 'NOT'
			{
				this.match("NOT");
			}
				break;
			case 3:
				// MOWLLexer.g:37:23: 'Not'
			{
				this.match("Not");
			}
				break;
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
			// MOWLLexer.g:39:7: ( 'some' )
			// MOWLLexer.g:39:9: 'some'
			{
				this.match("some");
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
			// MOWLLexer.g:41:7: ( 'only' )
			// MOWLLexer.g:41:9: 'only'
			{
				this.match("only");
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
			// MOWLLexer.g:43:7: ( 'min' )
			// MOWLLexer.g:43:9: 'min'
			{
				this.match("min");
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
			// MOWLLexer.g:45:7: ( 'max' )
			// MOWLLexer.g:45:9: 'max'
			{
				this.match("max");
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
			// MOWLLexer.g:47:11: ( 'exactly' )
			// MOWLLexer.g:47:13: 'exactly'
			{
				this.match("exactly");
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
			// MOWLLexer.g:49:7: ( 'value' )
			// MOWLLexer.g:49:9: 'value'
			{
				this.match("value");
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
			// MOWLLexer.g:51:9: ( 'INV' )
			// MOWLLexer.g:51:11: 'INV'
			{
				this.match("INV");
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
			// MOWLLexer.g:54:13: ( 'subClassOf' )
			// MOWLLexer.g:54:15: 'subClassOf'
			{
				this.match("subClassOf");
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
			// MOWLLexer.g:57:17: ( 'subPropertyOf' )
			// MOWLLexer.g:57:19: 'subPropertyOf'
			{
				this.match("subPropertyOf");
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
			// MOWLLexer.g:59:15: ( 'equivalentTo' )
			// MOWLLexer.g:59:17: 'equivalentTo'
			{
				this.match("equivalentTo");
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
			// MOWLLexer.g:62:9: ( 'sameAs' | 'SameAs' )
			int alt2 = 2;
			int LA2_0 = this.input.LA(1);
			if (LA2_0 == 's') {
				alt2 = 1;
			} else if (LA2_0 == 'S') {
				alt2 = 2;
			} else {
				NoViableAltException nvae = new NoViableAltException("", 2, 0, this.input);
				throw nvae;
			}
			switch (alt2) {
			case 1:
				// MOWLLexer.g:62:10: 'sameAs'
			{
				this.match("sameAs");
			}
				break;
			case 2:
				// MOWLLexer.g:62:21: 'SameAs'
			{
				this.match("SameAs");
			}
				break;
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
			// MOWLLexer.g:65:17: ( 'differentFrom' | 'DifferentFrom' )
			int alt3 = 2;
			int LA3_0 = this.input.LA(1);
			if (LA3_0 == 'd') {
				alt3 = 1;
			} else if (LA3_0 == 'D') {
				alt3 = 2;
			} else {
				NoViableAltException nvae = new NoViableAltException("", 3, 0, this.input);
				throw nvae;
			}
			switch (alt3) {
			case 1:
				// MOWLLexer.g:65:19: 'differentFrom'
			{
				this.match("differentFrom");
			}
				break;
			case 2:
				// MOWLLexer.g:65:37: 'DifferentFrom'
			{
				this.match("DifferentFrom");
			}
				break;
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
			// MOWLLexer.g:68:11: ( 'InverseOf' | 'inverseOf' )
			int alt4 = 2;
			int LA4_0 = this.input.LA(1);
			if (LA4_0 == 'I') {
				alt4 = 1;
			} else if (LA4_0 == 'i') {
				alt4 = 2;
			} else {
				NoViableAltException nvae = new NoViableAltException("", 4, 0, this.input);
				throw nvae;
			}
			switch (alt4) {
			case 1:
				// MOWLLexer.g:68:15: 'InverseOf'
			{
				this.match("InverseOf");
			}
				break;
			case 2:
				// MOWLLexer.g:68:29: 'inverseOf'
			{
				this.match("inverseOf");
			}
				break;
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
			// MOWLLexer.g:70:15: ( 'DisjointWith' | 'disjointWith' )
			int alt5 = 2;
			int LA5_0 = this.input.LA(1);
			if (LA5_0 == 'D') {
				alt5 = 1;
			} else if (LA5_0 == 'd') {
				alt5 = 2;
			} else {
				NoViableAltException nvae = new NoViableAltException("", 5, 0, this.input);
				throw nvae;
			}
			switch (alt5) {
			case 1:
				// MOWLLexer.g:70:17: 'DisjointWith'
			{
				this.match("DisjointWith");
			}
				break;
			case 2:
				// MOWLLexer.g:70:34: 'disjointWith'
			{
				this.match("disjointWith");
			}
				break;
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
			// MOWLLexer.g:73:9: ( 'Domain' | 'domain' )
			int alt6 = 2;
			int LA6_0 = this.input.LA(1);
			if (LA6_0 == 'D') {
				alt6 = 1;
			} else if (LA6_0 == 'd') {
				alt6 = 2;
			} else {
				NoViableAltException nvae = new NoViableAltException("", 6, 0, this.input);
				throw nvae;
			}
			switch (alt6) {
			case 1:
				// MOWLLexer.g:74:5: 'Domain'
			{
				this.match("Domain");
			}
				break;
			case 2:
				// MOWLLexer.g:74:16: 'domain'
			{
				this.match("domain");
			}
				break;
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
			// MOWLLexer.g:76:8: ( 'Range' | 'range' )
			int alt7 = 2;
			int LA7_0 = this.input.LA(1);
			if (LA7_0 == 'R') {
				alt7 = 1;
			} else if (LA7_0 == 'r') {
				alt7 = 2;
			} else {
				NoViableAltException nvae = new NoViableAltException("", 7, 0, this.input);
				throw nvae;
			}
			switch (alt7) {
			case 1:
				// MOWLLexer.g:77:5: 'Range'
			{
				this.match("Range");
			}
				break;
			case 2:
				// MOWLLexer.g:77:15: 'range'
			{
				this.match("range");
			}
				break;
			}
			this.state.type = _type;
			this.state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "RANGE"
	// $ANTLR start "FUNCTIONAL"
	public final void mFUNCTIONAL() throws RecognitionException {
		try {
			int _type = FUNCTIONAL;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// MOWLLexer.g:82:13: ( ( 'F' | 'f' ) 'unctional' ( ':' )? )
			// MOWLLexer.g:82:17: ( 'F' | 'f' ) 'unctional' ( ':' )?
			{
				if (this.input.LA(1) == 'F' || this.input.LA(1) == 'f') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				this.match("unctional");
				// MOWLLexer.g:82:37: ( ':' )?
				int alt8 = 2;
				int LA8_0 = this.input.LA(1);
				if (LA8_0 == ':') {
					alt8 = 1;
				}
				switch (alt8) {
				case 1:
					// MOWLLexer.g:82:37: ':'
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
			// MOWLLexer.g:84:12: ( ( 'S' | 's' ) 'ymmetric' ( ':' )? )
			// MOWLLexer.g:84:15: ( 'S' | 's' ) 'ymmetric' ( ':' )?
			{
				if (this.input.LA(1) == 'S' || this.input.LA(1) == 's') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				this.match("ymmetric");
				// MOWLLexer.g:84:34: ( ':' )?
				int alt9 = 2;
				int LA9_0 = this.input.LA(1);
				if (LA9_0 == ':') {
					alt9 = 1;
				}
				switch (alt9) {
				case 1:
					// MOWLLexer.g:84:34: ':'
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
			// MOWLLexer.g:87:17: ( ( 'A' | 'a' ) 'nti' ( 'S' | 's' ) 'ymmetric'
			// ( ':' )? )
			// MOWLLexer.g:87:19: ( 'A' | 'a' ) 'nti' ( 'S' | 's' ) 'ymmetric' (
			// ':' )?
			{
				if (this.input.LA(1) == 'A' || this.input.LA(1) == 'a') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				this.match("nti");
				if (this.input.LA(1) == 'S' || this.input.LA(1) == 's') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				this.match("ymmetric");
				// MOWLLexer.g:87:52: ( ':' )?
				int alt10 = 2;
				int LA10_0 = this.input.LA(1);
				if (LA10_0 == ':') {
					alt10 = 1;
				}
				switch (alt10) {
				case 1:
					// MOWLLexer.g:87:52: ':'
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
	// $ANTLR start "REFLEXIVE"
	public final void mREFLEXIVE() throws RecognitionException {
		try {
			int _type = REFLEXIVE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// MOWLLexer.g:90:12: ( ( 'R' | 'r' ) 'eflexive' ( ':' )? )
			// MOWLLexer.g:90:14: ( 'R' | 'r' ) 'eflexive' ( ':' )?
			{
				if (this.input.LA(1) == 'R' || this.input.LA(1) == 'r') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				this.match("eflexive");
				// MOWLLexer.g:90:33: ( ':' )?
				int alt11 = 2;
				int LA11_0 = this.input.LA(1);
				if (LA11_0 == ':') {
					alt11 = 1;
				}
				switch (alt11) {
				case 1:
					// MOWLLexer.g:90:33: ':'
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
			// MOWLLexer.g:92:14: ( ( 'I' | 'i' ) 'rreflexive' ( ':' )? )
			// MOWLLexer.g:92:16: ( 'I' | 'i' ) 'rreflexive' ( ':' )?
			{
				if (this.input.LA(1) == 'I' || this.input.LA(1) == 'i') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				this.match("rreflexive");
				// MOWLLexer.g:92:38: ( ':' )?
				int alt12 = 2;
				int LA12_0 = this.input.LA(1);
				if (LA12_0 == ':') {
					alt12 = 1;
				}
				switch (alt12) {
				case 1:
					// MOWLLexer.g:92:38: ':'
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
			// MOWLLexer.g:94:14: ( ( 'T' | 't' ) 'ransitive' ( ':' )? )
			// MOWLLexer.g:94:16: ( 'T' | 't' ) 'ransitive' ( ':' )?
			{
				if (this.input.LA(1) == 'T' || this.input.LA(1) == 't') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				this.match("ransitive");
				// MOWLLexer.g:94:36: ( ':' )?
				int alt13 = 2;
				int LA13_0 = this.input.LA(1);
				if (LA13_0 == ':') {
					alt13 = 1;
				}
				switch (alt13) {
				case 1:
					// MOWLLexer.g:94:36: ':'
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
			// MOWLLexer.g:97:19: ( ( 'I' | 'i' ) 'nverse' ( 'F' | 'f' )
			// 'unctional' ( ':' )? )
			// MOWLLexer.g:97:23: ( 'I' | 'i' ) 'nverse' ( 'F' | 'f' )
			// 'unctional' ( ':' )?
			{
				if (this.input.LA(1) == 'I' || this.input.LA(1) == 'i') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				this.match("nverse");
				if (this.input.LA(1) == 'F' || this.input.LA(1) == 'f') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				this.match("unctional");
				// MOWLLexer.g:97:60: ( ':' )?
				int alt14 = 2;
				int LA14_0 = this.input.LA(1);
				if (LA14_0 == ':') {
					alt14 = 1;
				}
				switch (alt14) {
				case 1:
					// MOWLLexer.g:97:60: ':'
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
	// $ANTLR start "POW"
	public final void mPOW() throws RecognitionException {
		try {
			int _type = POW;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// MOWLLexer.g:100:7: ( '^' )
			// MOWLLexer.g:100:9: '^'
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
			// MOWLLexer.g:103:7: ( ',' )
			// MOWLLexer.g:104:5: ','
			{
				this.match(',');
			}
			this.state.type = _type;
			this.state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "COMMA"
	// $ANTLR start "INSTANCE_OF"
	public final void mINSTANCE_OF() throws RecognitionException {
		try {
			int _type = INSTANCE_OF;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// MOWLLexer.g:107:13: ( ( 'I' | 'i' ) 'nstance' ( 'O' | 'o' ) 'f' )
			// MOWLLexer.g:107:15: ( 'I' | 'i' ) 'nstance' ( 'O' | 'o' ) 'f'
			{
				if (this.input.LA(1) == 'I' || this.input.LA(1) == 'i') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				this.match("nstance");
				if (this.input.LA(1) == 'O' || this.input.LA(1) == 'o') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				this.match('f');
			}
			this.state.type = _type;
			this.state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "INSTANCE_OF"
	// $ANTLR start "TYPES"
	public final void mTYPES() throws RecognitionException {
		try {
			int _type = TYPES;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// MOWLLexer.g:110:7: ( ( 'T' | 't' ) 'ypes' )
			// MOWLLexer.g:110:9: ( 'T' | 't' ) 'ypes'
			{
				if (this.input.LA(1) == 'T' || this.input.LA(1) == 't') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				this.match("ypes");
			}
			this.state.type = _type;
			this.state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "TYPES"
	// $ANTLR start "DBLQUOTE"
	public final void mDBLQUOTE() throws RecognitionException {
		try {
			int _type = DBLQUOTE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// MOWLLexer.g:116:10: ( '\"' (~ '\"' | '\"\"' )* '\"' )
			// MOWLLexer.g:117:7: '\"' (~ '\"' | '\"\"' )* '\"'
			{
				this.match('\"');
				// MOWLLexer.g:118:7: (~ '\"' | '\"\"' )*
				loop15: do {
					int alt15 = 3;
					int LA15_0 = this.input.LA(1);
					if (LA15_0 == '\"') {
						int LA15_1 = this.input.LA(2);
						if (LA15_1 == '\"') {
							alt15 = 2;
						}
					} else if (LA15_0 >= '\u0000' && LA15_0 <= '!' || LA15_0 >= '#'
							&& LA15_0 <= '\uFFFF') {
						alt15 = 1;
					}
					switch (alt15) {
					case 1:
						// MOWLLexer.g:118:8: ~ '\"'
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
						// MOWLLexer.g:118:15: '\"\"'
					{
						this.match("\"\"");
					}
						break;
					default:
						break loop15;
					}
				} while (true);
				this.match('\"');
				String quote, dblDblQuote, cont;
				char quoteChr = 34;
				quote = "\n";
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
	// $ANTLR start "INTEGER"
	public final void mINTEGER() throws RecognitionException {
		try {
			int _type = INTEGER;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// MOWLLexer.g:140:8: ( ( DIGIT )+ )
			// MOWLLexer.g:140:10: ( DIGIT )+
			{
				// MOWLLexer.g:140:10: ( DIGIT )+
				int cnt16 = 0;
				loop16: do {
					int alt16 = 2;
					int LA16_0 = this.input.LA(1);
					if (LA16_0 >= '0' && LA16_0 <= '9') {
						alt16 = 1;
					}
					switch (alt16) {
					case 1:
						// MOWLLexer.g:140:10: DIGIT
					{
						this.mDIGIT();
					}
						break;
					default:
						if (cnt16 >= 1) {
							break loop16;
						}
						EarlyExitException eee = new EarlyExitException(16, this.input);
						throw eee;
					}
					cnt16++;
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
			// MOWLLexer.g:141:17: ( ( 'a' .. 'z' | 'A' .. 'Z' ) )
			// MOWLLexer.g:141:19: ( 'a' .. 'z' | 'A' .. 'Z' )
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
			// MOWLLexer.g:142:15: ( '0' .. '9' )
			// MOWLLexer.g:142:17: '0' .. '9'
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
			// MOWLLexer.g:144:12: ( LETTER ( LETTER | DIGIT | '-' | '_' | ':'
			// )* )
			// MOWLLexer.g:144:14: LETTER ( LETTER | DIGIT | '-' | '_' | ':' )*
			{
				this.mLETTER();
				// MOWLLexer.g:144:21: ( LETTER | DIGIT | '-' | '_' | ':' )*
				loop17: do {
					int alt17 = 2;
					int LA17_0 = this.input.LA(1);
					if (LA17_0 == '-' || LA17_0 >= '0' && LA17_0 <= ':' || LA17_0 >= 'A'
							&& LA17_0 <= 'Z' || LA17_0 == '_' || LA17_0 >= 'a' && LA17_0 <= 'z') {
						alt17 = 1;
					}
					switch (alt17) {
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
						break loop17;
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
			// MOWLLexer.g:145:18: ( '\\'' ( IDENTIFIER )+ '\\'' )
			// MOWLLexer.g:146:5: '\\'' ( IDENTIFIER )+ '\\''
			{
				this.match('\'');
				// MOWLLexer.g:146:10: ( IDENTIFIER )+
				int cnt18 = 0;
				loop18: do {
					int alt18 = 2;
					int LA18_0 = this.input.LA(1);
					if (LA18_0 >= 'A' && LA18_0 <= 'Z' || LA18_0 >= 'a' && LA18_0 <= 'z') {
						alt18 = 1;
					}
					switch (alt18) {
					case 1:
						// MOWLLexer.g:146:10: IDENTIFIER
					{
						this.mIDENTIFIER();
					}
						break;
					default:
						if (cnt18 >= 1) {
							break loop18;
						}
						EarlyExitException eee = new EarlyExitException(18, this.input);
						throw eee;
					}
					cnt18++;
				} while (true);
				this.match('\'');
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
		// | CLOSED_CURLY_BRACES | CLOSED_PARENTHESYS | WHITESPACE | AND | OR |
		// NOT | SOME | ONLY | MIN | MAX | EXACTLY | VALUE | INVERSE |
		// SUBCLASS_OF | SUB_PROPERTY_OF | EQUIVALENT_TO | SAME_AS |
		// DIFFERENT_FROM | INVERSE_OF | DISJOINT_WITH | DOMAIN | RANGE |
		// FUNCTIONAL | SYMMETRIC | ANTI_SYMMETRIC | REFLEXIVE | IRREFLEXIVE |
		// TRANSITIVE | INVERSE_FUNCTIONAL | POW | COMMA | INSTANCE_OF | TYPES |
		// DBLQUOTE | INTEGER | IDENTIFIER | ENTITY_REFERENCE )
		int alt19 = 40;
		alt19 = this.dfa19.predict(this.input);
		switch (alt19) {
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
			// MOWLLexer.g:1:96: WHITESPACE
		{
			this.mWHITESPACE();
		}
			break;
		case 7:
			// MOWLLexer.g:1:107: AND
		{
			this.mAND();
		}
			break;
		case 8:
			// MOWLLexer.g:1:111: OR
		{
			this.mOR();
		}
			break;
		case 9:
			// MOWLLexer.g:1:114: NOT
		{
			this.mNOT();
		}
			break;
		case 10:
			// MOWLLexer.g:1:118: SOME
		{
			this.mSOME();
		}
			break;
		case 11:
			// MOWLLexer.g:1:123: ONLY
		{
			this.mONLY();
		}
			break;
		case 12:
			// MOWLLexer.g:1:128: MIN
		{
			this.mMIN();
		}
			break;
		case 13:
			// MOWLLexer.g:1:132: MAX
		{
			this.mMAX();
		}
			break;
		case 14:
			// MOWLLexer.g:1:136: EXACTLY
		{
			this.mEXACTLY();
		}
			break;
		case 15:
			// MOWLLexer.g:1:144: VALUE
		{
			this.mVALUE();
		}
			break;
		case 16:
			// MOWLLexer.g:1:150: INVERSE
		{
			this.mINVERSE();
		}
			break;
		case 17:
			// MOWLLexer.g:1:158: SUBCLASS_OF
		{
			this.mSUBCLASS_OF();
		}
			break;
		case 18:
			// MOWLLexer.g:1:170: SUB_PROPERTY_OF
		{
			this.mSUB_PROPERTY_OF();
		}
			break;
		case 19:
			// MOWLLexer.g:1:186: EQUIVALENT_TO
		{
			this.mEQUIVALENT_TO();
		}
			break;
		case 20:
			// MOWLLexer.g:1:200: SAME_AS
		{
			this.mSAME_AS();
		}
			break;
		case 21:
			// MOWLLexer.g:1:208: DIFFERENT_FROM
		{
			this.mDIFFERENT_FROM();
		}
			break;
		case 22:
			// MOWLLexer.g:1:223: INVERSE_OF
		{
			this.mINVERSE_OF();
		}
			break;
		case 23:
			// MOWLLexer.g:1:234: DISJOINT_WITH
		{
			this.mDISJOINT_WITH();
		}
			break;
		case 24:
			// MOWLLexer.g:1:248: DOMAIN
		{
			this.mDOMAIN();
		}
			break;
		case 25:
			// MOWLLexer.g:1:255: RANGE
		{
			this.mRANGE();
		}
			break;
		case 26:
			// MOWLLexer.g:1:261: FUNCTIONAL
		{
			this.mFUNCTIONAL();
		}
			break;
		case 27:
			// MOWLLexer.g:1:272: SYMMETRIC
		{
			this.mSYMMETRIC();
		}
			break;
		case 28:
			// MOWLLexer.g:1:282: ANTI_SYMMETRIC
		{
			this.mANTI_SYMMETRIC();
		}
			break;
		case 29:
			// MOWLLexer.g:1:297: REFLEXIVE
		{
			this.mREFLEXIVE();
		}
			break;
		case 30:
			// MOWLLexer.g:1:307: IRREFLEXIVE
		{
			this.mIRREFLEXIVE();
		}
			break;
		case 31:
			// MOWLLexer.g:1:319: TRANSITIVE
		{
			this.mTRANSITIVE();
		}
			break;
		case 32:
			// MOWLLexer.g:1:330: INVERSE_FUNCTIONAL
		{
			this.mINVERSE_FUNCTIONAL();
		}
			break;
		case 33:
			// MOWLLexer.g:1:349: POW
		{
			this.mPOW();
		}
			break;
		case 34:
			// MOWLLexer.g:1:353: COMMA
		{
			this.mCOMMA();
		}
			break;
		case 35:
			// MOWLLexer.g:1:359: INSTANCE_OF
		{
			this.mINSTANCE_OF();
		}
			break;
		case 36:
			// MOWLLexer.g:1:371: TYPES
		{
			this.mTYPES();
		}
			break;
		case 37:
			// MOWLLexer.g:1:377: DBLQUOTE
		{
			this.mDBLQUOTE();
		}
			break;
		case 38:
			// MOWLLexer.g:1:386: INTEGER
		{
			this.mINTEGER();
		}
			break;
		case 39:
			// MOWLLexer.g:1:394: IDENTIFIER
		{
			this.mIDENTIFIER();
		}
			break;
		case 40:
			// MOWLLexer.g:1:405: ENTITY_REFERENCE
		{
			this.mENTITY_REFERENCE();
		}
			break;
		}
	}

	protected DFA19 dfa19 = new DFA19(this);
	static final String DFA19_eotS = "\1\uffff\1\40\5\uffff\21\34\6\uffff\1\76\1\34\1\uffff\35\34\1\uffff"
			+ "\1\34\1\141\1\34\3\143\4\34\1\151\1\152\3\34\1\156\21\34\1\u0080"
			+ "\1\uffff\1\34\1\uffff\1\u0082\4\34\2\uffff\3\34\1\uffff\21\34\1"
			+ "\uffff\1\34\1\uffff\6\34\1\u00a2\13\34\1\u00ae\1\34\1\u00ae\2\34"
			+ "\1\u00b2\3\34\1\u00b6\3\34\1\uffff\3\34\1\u00b6\2\34\1\u00bf\2\34"
			+ "\1\u00bf\1\34\1\uffff\3\34\1\uffff\3\34\1\uffff\1\34\1\u00ca\6\34"
			+ "\1\uffff\12\34\1\uffff\20\34\1\u00ec\1\34\1\u00ef\7\34\1\u00ef\1"
			+ "\u00f8\3\34\1\u00fc\1\34\1\uffff\1\u00ec\1\34\1\uffff\1\34\1\u0100"
			+ "\5\34\1\u00f8\1\uffff\1\u0106\1\u0109\1\34\1\uffff\3\34\1\uffff"
			+ "\1\u010e\4\34\1\uffff\1\u0106\1\u0109\1\uffff\2\34\1\u0116\1\34"
			+ "\1\uffff\1\u010e\1\34\1\u0119\1\34\1\u0119\1\u011b\1\u011d\1\uffff"
			+ "\1\34\1\u011f\1\uffff\1\u011f\1\uffff\1\u011b\1\uffff\1\34\1\uffff"
			+ "\2\34\1\u0123\1\uffff\1\u0123";
	static final String DFA19_eofS = "\u0125\uffff";
	static final String DFA19_minS = "\1\11\1\55\5\uffff\1\156\1\157\1\117\2\141\1\161\1\141\1\116\1\141"
			+ "\2\151\1\156\2\141\1\165\1\156\1\162\6\uffff\1\55\1\154\1\uffff"
			+ "\1\144\1\164\1\124\1\164\1\155\1\142\2\155\1\156\1\170\1\141\1\165"
			+ "\1\154\1\126\1\163\1\162\1\155\1\146\1\155\1\146\1\155\1\163\1\156"
			+ "\1\146\2\156\1\164\1\141\1\160\1\uffff\1\171\1\55\1\151\3\55\1\145"
			+ "\1\103\1\145\1\155\2\55\1\143\1\151\1\165\1\55\1\145\1\164\2\145"
			+ "\1\146\1\152\1\141\1\146\1\152\1\141\1\145\1\147\1\154\1\147\1\143"
			+ "\1\156\1\145\1\55\1\uffff\1\123\1\uffff\1\55\1\154\1\162\1\101\1"
			+ "\145\2\uffff\1\164\1\166\1\145\1\uffff\1\162\1\141\1\146\1\101\1"
			+ "\145\1\157\1\151\1\145\1\157\1\151\1\162\3\145\1\164\2\163\1\uffff"
			+ "\1\171\1\uffff\1\141\1\157\1\163\1\164\1\154\1\141\1\55\1\163\1"
			+ "\156\1\154\1\163\1\162\1\151\1\156\1\162\1\151\1\156\1\163\1\55"
			+ "\1\170\1\55\2\151\1\55\1\155\1\163\1\160\1\55\1\162\1\171\1\154"
			+ "\1\uffff\1\145\1\143\1\145\1\55\1\145\1\156\1\55\1\145\1\156\1\55"
			+ "\1\145\1\uffff\1\151\1\157\1\164\1\uffff\1\155\1\163\1\145\1\uffff"
			+ "\1\151\1\55\1\145\1\106\1\145\1\170\1\156\1\164\1\uffff\1\156\1"
			+ "\164\1\106\1\166\1\156\1\151\1\145\1\117\1\162\1\143\1\uffff\1\156"
			+ "\1\146\1\165\1\117\1\151\1\164\1\127\1\164\1\127\1\146\1\145\1\141"
			+ "\1\166\1\164\1\146\1\164\1\55\1\164\1\55\1\156\1\146\1\166\1\106"
			+ "\1\151\1\106\1\151\2\55\1\154\1\145\1\162\1\55\1\171\1\uffff\1\55"
			+ "\1\124\1\uffff\1\143\1\55\1\145\1\162\1\164\1\162\1\164\1\55\1\uffff"
			+ "\2\55\1\151\1\uffff\1\117\1\157\1\164\1\uffff\1\55\1\157\1\150\1"
			+ "\157\1\150\1\uffff\2\55\1\uffff\1\143\1\146\1\55\1\151\1\uffff\1"
			+ "\55\1\155\1\55\1\155\3\55\1\uffff\1\157\1\55\1\uffff\1\55\1\uffff"
			+ "\1\55\1\uffff\1\156\1\uffff\1\141\1\154\1\55\1\uffff\1\55";
	static final String DFA19_maxS = "\1\175\1\172\5\uffff\1\156\2\157\1\171\1\151\1\170\1\141\1\162\1"
			+ "\171\2\157\1\162\2\145\1\165\1\156\1\171\6\uffff\1\172\1\154\1\uffff"
			+ "\2\164\1\124\1\164\1\155\1\142\2\155\1\156\1\170\1\141\1\165\1\154"
			+ "\1\126\1\166\1\162\1\155\1\163\1\155\1\163\1\155\1\166\1\156\1\146"
			+ "\2\156\1\164\1\141\1\160\1\uffff\1\171\1\172\1\151\3\172\1\145\1"
			+ "\120\1\145\1\155\2\172\1\143\1\151\1\165\1\172\1\145\1\164\2\145"
			+ "\1\146\1\152\1\141\1\146\1\152\1\141\1\145\1\147\1\154\1\147\1\143"
			+ "\1\156\1\145\1\172\1\uffff\1\163\1\uffff\1\172\1\154\1\162\1\101"
			+ "\1\145\2\uffff\1\164\1\166\1\145\1\uffff\1\162\1\141\1\146\1\101"
			+ "\1\145\1\157\1\151\1\145\1\157\1\151\1\162\3\145\1\164\2\163\1\uffff"
			+ "\1\171\1\uffff\1\141\1\157\1\163\1\164\1\154\1\141\1\172\1\163\1"
			+ "\156\1\154\1\163\1\162\1\151\1\156\1\162\1\151\1\156\1\163\1\172"
			+ "\1\170\1\172\2\151\1\172\1\155\1\163\1\160\1\172\1\162\1\171\1\154"
			+ "\1\uffff\1\145\1\143\1\145\1\172\1\145\1\156\1\172\1\145\1\156\1"
			+ "\172\1\145\1\uffff\1\151\1\157\1\164\1\uffff\1\155\1\163\1\145\1"
			+ "\uffff\1\151\1\172\1\145\1\146\1\145\1\170\1\156\1\164\1\uffff\1"
			+ "\156\1\164\1\146\1\166\1\156\1\151\1\145\1\117\1\162\1\143\1\uffff"
			+ "\1\156\1\146\1\165\1\157\1\151\1\164\1\127\1\164\1\127\1\146\1\145"
			+ "\1\141\1\166\1\164\1\146\1\164\1\172\1\164\1\172\1\156\1\146\1\166"
			+ "\1\106\1\151\1\106\1\151\2\172\1\154\1\145\1\162\1\172\1\171\1\uffff"
			+ "\1\172\1\124\1\uffff\1\143\1\172\1\145\1\162\1\164\1\162\1\164\1"
			+ "\172\1\uffff\2\172\1\151\1\uffff\1\117\1\157\1\164\1\uffff\1\172"
			+ "\1\157\1\150\1\157\1\150\1\uffff\2\172\1\uffff\1\143\1\146\1\172"
			+ "\1\151\1\uffff\1\172\1\155\1\172\1\155\3\172\1\uffff\1\157\1\172"
			+ "\1\uffff\1\172\1\uffff\1\172\1\uffff\1\156\1\uffff\1\141\1\154\1"
			+ "\172\1\uffff\1\172";
	static final String DFA19_acceptS = "\2\uffff\1\2\1\3\1\4\1\5\1\6\21\uffff\1\41\1\42\1\45\1\46\1\47\1"
			+ "\50\2\uffff\1\1\35\uffff\1\10\42\uffff\1\7\1\uffff\1\11\5\uffff"
			+ "\1\14\1\15\3\uffff\1\20\21\uffff\1\13\1\uffff\1\12\37\uffff\1\17"
			+ "\13\uffff\1\31\3\uffff\1\44\3\uffff\1\24\10\uffff\1\30\12\uffff"
			+ "\1\16\41\uffff\1\33\2\uffff\1\26\10\uffff\1\35\3\uffff\1\21\3\uffff"
			+ "\1\43\5\uffff\1\32\2\uffff\1\37\4\uffff\1\36\7\uffff\1\23\2\uffff"
			+ "\1\27\1\uffff\1\34\1\uffff\1\22\1\uffff\1\25\3\uffff\1\40\1\uffff";
	static final String DFA19_specialS = "\u0125\uffff}>";
	static final String[] DFA19_transitionS = {
			"\2\6\2\uffff\1\6\22\uffff\1\6\1\uffff\1\32\4\uffff\1\35\1\2"
					+ "\1\5\2\uffff\1\31\3\uffff\12\33\7\uffff\1\26\2\34\1\21\1\34"
					+ "\1\25\2\34\1\16\4\34\1\11\3\34\1\23\1\17\1\27\6\34\3\uffff\1"
					+ "\30\2\uffff\1\7\2\34\1\20\1\14\1\25\2\34\1\22\3\34\1\13\1\10"
					+ "\1\1\2\34\1\24\1\12\1\27\1\34\1\15\4\34\1\3\1\uffff\1\4",
			"\1\34\2\uffff\13\34\6\uffff\32\34\4\uffff\1\34\1\uffff\15\34"
					+ "\1\37\3\34\1\36\10\34", "", "", "", "", "", "\1\41", "\1\42",
			"\1\43\37\uffff\1\44", "\1\47\15\uffff\1\45\5\uffff\1\46\3\uffff\1\50",
			"\1\52\7\uffff\1\51", "\1\54\6\uffff\1\53", "\1\55",
			"\1\56\37\uffff\1\57\3\uffff\1\60", "\1\61\27\uffff\1\50", "\1\62\5\uffff\1\63",
			"\1\64\5\uffff\1\65", "\1\66\3\uffff\1\60", "\1\67\3\uffff\1\70", "\1\71\3\uffff\1\70",
			"\1\72", "\1\73", "\1\74\6\uffff\1\75", "", "", "", "", "", "",
			"\1\34\2\uffff\13\34\6\uffff\32\34\4\uffff\1\34\1\uffff\32\34", "\1\77", "",
			"\1\100\17\uffff\1\101", "\1\102", "\1\103", "\1\104", "\1\105", "\1\106", "\1\107",
			"\1\110", "\1\111", "\1\112", "\1\113", "\1\114", "\1\115", "\1\116",
			"\1\120\2\uffff\1\117", "\1\121", "\1\122", "\1\123\14\uffff\1\124", "\1\125",
			"\1\126\14\uffff\1\127", "\1\130", "\1\120\2\uffff\1\131", "\1\132", "\1\133",
			"\1\134", "\1\135", "\1\101", "\1\136", "\1\137", "", "\1\140",
			"\1\34\2\uffff\13\34\6\uffff\32\34\4\uffff\1\34\1\uffff\32\34", "\1\142",
			"\1\34\2\uffff\13\34\6\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
			"\1\34\2\uffff\13\34\6\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
			"\1\34\2\uffff\13\34\6\uffff\32\34\4\uffff\1\34\1\uffff\32\34", "\1\144",
			"\1\145\14\uffff\1\146", "\1\147", "\1\150",
			"\1\34\2\uffff\13\34\6\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
			"\1\34\2\uffff\13\34\6\uffff\32\34\4\uffff\1\34\1\uffff\32\34", "\1\153", "\1\154",
			"\1\155", "\1\34\2\uffff\13\34\6\uffff\32\34\4\uffff\1\34\1\uffff\32\34", "\1\157",
			"\1\160", "\1\161", "\1\162", "\1\163", "\1\164", "\1\165", "\1\166", "\1\167",
			"\1\170", "\1\171", "\1\172", "\1\173", "\1\174", "\1\175", "\1\176", "\1\177",
			"\1\34\2\uffff\13\34\6\uffff\32\34\4\uffff\1\34\1\uffff\32\34", "",
			"\1\u0081\37\uffff\1\u0081", "",
			"\1\34\2\uffff\13\34\6\uffff\32\34\4\uffff\1\34\1\uffff\32\34", "\1\u0083", "\1\u0084",
			"\1\u0085", "\1\u0086", "", "", "\1\u0087", "\1\u0088", "\1\u0089", "", "\1\u008a",
			"\1\u008b", "\1\u008c", "\1\u008d", "\1\u008e", "\1\u008f", "\1\u0090", "\1\u0091",
			"\1\u0092", "\1\u0093", "\1\u0094", "\1\u0095", "\1\u0096", "\1\u0097", "\1\u0098",
			"\1\u0099", "\1\u009a", "", "\1\u009b", "", "\1\u009c", "\1\u009d", "\1\u009e",
			"\1\u009f", "\1\u00a0", "\1\u00a1",
			"\1\34\2\uffff\13\34\6\uffff\32\34\4\uffff\1\34\1\uffff\32\34", "\1\u00a3", "\1\u00a4",
			"\1\u00a5", "\1\u00a6", "\1\u00a7", "\1\u00a8", "\1\u00a9", "\1\u00aa", "\1\u00ab",
			"\1\u00ac", "\1\u00ad", "\1\34\2\uffff\13\34\6\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
			"\1\u00af", "\1\34\2\uffff\13\34\6\uffff\32\34\4\uffff\1\34\1\uffff\32\34", "\1\u00b0",
			"\1\u00b1", "\1\34\2\uffff\13\34\6\uffff\32\34\4\uffff\1\34\1\uffff\32\34", "\1\u00b3",
			"\1\u00b4", "\1\u00b5", "\1\34\2\uffff\13\34\6\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
			"\1\u00b7", "\1\u00b8", "\1\u00b9", "", "\1\u00ba", "\1\u00bb", "\1\u00bc",
			"\1\34\2\uffff\13\34\6\uffff\32\34\4\uffff\1\34\1\uffff\32\34", "\1\u00bd", "\1\u00be",
			"\1\34\2\uffff\13\34\6\uffff\32\34\4\uffff\1\34\1\uffff\32\34", "\1\u00c0", "\1\u00c1",
			"\1\34\2\uffff\13\34\6\uffff\32\34\4\uffff\1\34\1\uffff\32\34", "\1\u00c2", "",
			"\1\u00c3", "\1\u00c4", "\1\u00c5", "", "\1\u00c6", "\1\u00c7", "\1\u00c8", "",
			"\1\u00c9", "\1\34\2\uffff\13\34\6\uffff\32\34\4\uffff\1\34\1\uffff\32\34", "\1\u00cb",
			"\1\u00cd\10\uffff\1\u00cc\26\uffff\1\u00cd", "\1\u00ce", "\1\u00cf", "\1\u00d0",
			"\1\u00d1", "", "\1\u00d2", "\1\u00d3", "\1\u00cd\10\uffff\1\u00d4\26\uffff\1\u00cd",
			"\1\u00d5", "\1\u00d6", "\1\u00d7", "\1\u00d8", "\1\u00d9", "\1\u00da", "\1\u00db", "",
			"\1\u00dc", "\1\u00dd", "\1\u00de", "\1\u00df\37\uffff\1\u00df", "\1\u00e0",
			"\1\u00e1", "\1\u00e2", "\1\u00e3", "\1\u00e4", "\1\u00e5", "\1\u00e6", "\1\u00e7",
			"\1\u00e8", "\1\u00e9", "\1\u00ea", "\1\u00eb",
			"\1\34\2\uffff\12\34\1\u00ed\6\uffff\32\34\4\uffff\1\34\1\uffff" + "\32\34",
			"\1\u00ee", "\1\34\2\uffff\13\34\6\uffff\32\34\4\uffff\1\34\1\uffff\32\34", "\1\u00f0",
			"\1\u00f1", "\1\u00f2", "\1\u00f3", "\1\u00f4", "\1\u00f5", "\1\u00f6",
			"\1\34\2\uffff\13\34\6\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
			"\1\34\2\uffff\12\34\1\u00f7\6\uffff\32\34\4\uffff\1\34\1\uffff" + "\32\34",
			"\1\u00f9", "\1\u00fa", "\1\u00fb",
			"\1\34\2\uffff\13\34\6\uffff\32\34\4\uffff\1\34\1\uffff\32\34", "\1\u00fd", "",
			"\1\34\2\uffff\13\34\6\uffff\32\34\4\uffff\1\34\1\uffff\32\34", "\1\u00fe", "",
			"\1\u00ff", "\1\34\2\uffff\13\34\6\uffff\32\34\4\uffff\1\34\1\uffff\32\34", "\1\u0101",
			"\1\u0102", "\1\u0103", "\1\u0104", "\1\u0105",
			"\1\34\2\uffff\13\34\6\uffff\32\34\4\uffff\1\34\1\uffff\32\34", "",
			"\1\34\2\uffff\12\34\1\u0107\6\uffff\32\34\4\uffff\1\34\1\uffff" + "\32\34",
			"\1\34\2\uffff\12\34\1\u0108\6\uffff\32\34\4\uffff\1\34\1\uffff" + "\32\34",
			"\1\u010a", "", "\1\u010b", "\1\u010c", "\1\u010d", "",
			"\1\34\2\uffff\12\34\1\u010f\6\uffff\32\34\4\uffff\1\34\1\uffff" + "\32\34",
			"\1\u0110", "\1\u0111", "\1\u0112", "\1\u0113", "",
			"\1\34\2\uffff\13\34\6\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
			"\1\34\2\uffff\13\34\6\uffff\32\34\4\uffff\1\34\1\uffff\32\34", "", "\1\u0114",
			"\1\u0115", "\1\34\2\uffff\13\34\6\uffff\32\34\4\uffff\1\34\1\uffff\32\34", "\1\u0117",
			"", "\1\34\2\uffff\13\34\6\uffff\32\34\4\uffff\1\34\1\uffff\32\34", "\1\u0118",
			"\1\34\2\uffff\13\34\6\uffff\32\34\4\uffff\1\34\1\uffff\32\34", "\1\u011a",
			"\1\34\2\uffff\13\34\6\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
			"\1\34\2\uffff\12\34\1\u011c\6\uffff\32\34\4\uffff\1\34\1\uffff" + "\32\34",
			"\1\34\2\uffff\13\34\6\uffff\32\34\4\uffff\1\34\1\uffff\32\34", "", "\1\u011e",
			"\1\34\2\uffff\13\34\6\uffff\32\34\4\uffff\1\34\1\uffff\32\34", "",
			"\1\34\2\uffff\13\34\6\uffff\32\34\4\uffff\1\34\1\uffff\32\34", "",
			"\1\34\2\uffff\13\34\6\uffff\32\34\4\uffff\1\34\1\uffff\32\34", "", "\1\u0120", "",
			"\1\u0121", "\1\u0122",
			"\1\34\2\uffff\12\34\1\u0124\6\uffff\32\34\4\uffff\1\34\1\uffff" + "\32\34", "",
			"\1\34\2\uffff\13\34\6\uffff\32\34\4\uffff\1\34\1\uffff\32\34" };
	static final short[] DFA19_eot = DFA.unpackEncodedString(DFA19_eotS);
	static final short[] DFA19_eof = DFA.unpackEncodedString(DFA19_eofS);
	static final char[] DFA19_min = DFA.unpackEncodedStringToUnsignedChars(DFA19_minS);
	static final char[] DFA19_max = DFA.unpackEncodedStringToUnsignedChars(DFA19_maxS);
	static final short[] DFA19_accept = DFA.unpackEncodedString(DFA19_acceptS);
	static final short[] DFA19_special = DFA.unpackEncodedString(DFA19_specialS);
	static final short[][] DFA19_transition;
	static {
		int numStates = DFA19_transitionS.length;
		DFA19_transition = new short[numStates][];
		for (int i = 0; i < numStates; i++) {
			DFA19_transition[i] = DFA.unpackEncodedString(DFA19_transitionS[i]);
		}
	}

	class DFA19 extends DFA {
		public DFA19(BaseRecognizer recognizer) {
			this.recognizer = recognizer;
			this.decisionNumber = 19;
			this.eot = DFA19_eot;
			this.eof = DFA19_eof;
			this.min = DFA19_min;
			this.max = DFA19_max;
			this.accept = DFA19_accept;
			this.special = DFA19_special;
			this.transition = DFA19_transition;
		}

		@Override
		public String getDescription() {
			return "1:1: Tokens : ( COMPOSITION | OPEN_PARENTHESYS | OPEN_CURLY_BRACES | CLOSED_CURLY_BRACES | CLOSED_PARENTHESYS | WHITESPACE | AND | OR | NOT | SOME | ONLY | MIN | MAX | EXACTLY | VALUE | INVERSE | SUBCLASS_OF | SUB_PROPERTY_OF | EQUIVALENT_TO | SAME_AS | DIFFERENT_FROM | INVERSE_OF | DISJOINT_WITH | DOMAIN | RANGE | FUNCTIONAL | SYMMETRIC | ANTI_SYMMETRIC | REFLEXIVE | IRREFLEXIVE | TRANSITIVE | INVERSE_FUNCTIONAL | POW | COMMA | INSTANCE_OF | TYPES | DBLQUOTE | INTEGER | IDENTIFIER | ENTITY_REFERENCE );";
		}
	}
}