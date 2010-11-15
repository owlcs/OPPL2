package org.coode.parsers.oppl;

// $ANTLR 3.2 Sep 23, 2009 12:02:23 MOWLLexer.g 2010-11-15 15:11:00
import org.antlr.runtime.BaseRecognizer;
import org.antlr.runtime.CharStream;
import org.antlr.runtime.DFA;
import org.antlr.runtime.EarlyExitException;
import org.antlr.runtime.IntStream;
import org.antlr.runtime.Lexer;
import org.antlr.runtime.MismatchedSetException;
import org.antlr.runtime.NoViableAltException;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.RecognizerSharedState;

public class OPPLLexer_MOWLLexer extends Lexer {
	public static final int COMMA = 37;
	public static final int GREATER_THAN = 509;
	public static final int ASSERTED = 76;
	public static final int END = 84;
	public static final int DIFFERENT_FROM = 24;
	public static final int LESS_THAN = 507;
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
	public static final int DISJOINT_WITH = 26;
	public static final int VARIABLE_TYPE = 89;
	public static final int DISJUNCTION = 55;
	public static final int GROUPS = 356;
	public static final int NEGATED_EXPRESSION = 58;
	public static final int EQUAL = 73;
	public static final int DIFFERENT_FROM_AXIOM = 53;
	public static final int GREATER_THAN_EQUAL = 510;
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
	public static final int LESS_THAN_EQUAL = 508;
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
	public static final int FAIL = 466;
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
			// MOWLLexer.g:51:9: ( ( 'I' | 'i' ) ( 'N' | 'n' ) ( 'V' | 'v' ) )
			// MOWLLexer.g:51:11: ( 'I' | 'i' ) ( 'N' | 'n' ) ( 'V' | 'v' )
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
			// MOWLLexer.g:54:13: ( ( 'S' | 's' ) 'ubClassOf' )
			// MOWLLexer.g:54:15: ( 'S' | 's' ) 'ubClassOf'
			{
				if (this.input.LA(1) == 'S' || this.input.LA(1) == 's') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				this.match("ubClassOf");
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
	// $ANTLR start "HAS_KEY"
	public final void mHAS_KEY() throws RecognitionException {
		try {
			int _type = HAS_KEY;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// MOWLLexer.g:81:2: ( ( 'H' | 'h' ) ( 'A' | 'a' ) ( 'S' | 's' ) (
			// 'K' | 'k' ) ( 'E' | 'e' ) ( 'Y' | 'y' ) )
			// MOWLLexer.g:82:3: ( 'H' | 'h' ) ( 'A' | 'a' ) ( 'S' | 's' ) ( 'K'
			// | 'k' ) ( 'E' | 'e' ) ( 'Y' | 'y' )
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
			// MOWLLexer.g:85:13: ( ( 'F' | 'f' ) 'unctional' ( ':' )? )
			// MOWLLexer.g:85:17: ( 'F' | 'f' ) 'unctional' ( ':' )?
			{
				if (this.input.LA(1) == 'F' || this.input.LA(1) == 'f') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				this.match("unctional");
				// MOWLLexer.g:85:37: ( ':' )?
				int alt8 = 2;
				int LA8_0 = this.input.LA(1);
				if (LA8_0 == ':') {
					alt8 = 1;
				}
				switch (alt8) {
				case 1:
					// MOWLLexer.g:85:37: ':'
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
			// MOWLLexer.g:87:12: ( ( 'S' | 's' ) 'ymmetric' ( ':' )? )
			// MOWLLexer.g:87:15: ( 'S' | 's' ) 'ymmetric' ( ':' )?
			{
				if (this.input.LA(1) == 'S' || this.input.LA(1) == 's') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				this.match("ymmetric");
				// MOWLLexer.g:87:34: ( ':' )?
				int alt9 = 2;
				int LA9_0 = this.input.LA(1);
				if (LA9_0 == ':') {
					alt9 = 1;
				}
				switch (alt9) {
				case 1:
					// MOWLLexer.g:87:34: ':'
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
			// MOWLLexer.g:90:17: ( ( 'A' | 'a' ) 'nti' ( 'S' | 's' ) 'ymmetric'
			// ( ':' )? )
			// MOWLLexer.g:90:19: ( 'A' | 'a' ) 'nti' ( 'S' | 's' ) 'ymmetric' (
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
				// MOWLLexer.g:90:52: ( ':' )?
				int alt10 = 2;
				int LA10_0 = this.input.LA(1);
				if (LA10_0 == ':') {
					alt10 = 1;
				}
				switch (alt10) {
				case 1:
					// MOWLLexer.g:90:52: ':'
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
			// MOWLLexer.g:93:12: ( ( 'R' | 'r' ) 'eflexive' ( ':' )? )
			// MOWLLexer.g:93:14: ( 'R' | 'r' ) 'eflexive' ( ':' )?
			{
				if (this.input.LA(1) == 'R' || this.input.LA(1) == 'r') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				this.match("eflexive");
				// MOWLLexer.g:93:33: ( ':' )?
				int alt11 = 2;
				int LA11_0 = this.input.LA(1);
				if (LA11_0 == ':') {
					alt11 = 1;
				}
				switch (alt11) {
				case 1:
					// MOWLLexer.g:93:33: ':'
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
			// MOWLLexer.g:95:14: ( ( 'I' | 'i' ) 'rreflexive' ( ':' )? )
			// MOWLLexer.g:95:16: ( 'I' | 'i' ) 'rreflexive' ( ':' )?
			{
				if (this.input.LA(1) == 'I' || this.input.LA(1) == 'i') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				this.match("rreflexive");
				// MOWLLexer.g:95:38: ( ':' )?
				int alt12 = 2;
				int LA12_0 = this.input.LA(1);
				if (LA12_0 == ':') {
					alt12 = 1;
				}
				switch (alt12) {
				case 1:
					// MOWLLexer.g:95:38: ':'
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
			// MOWLLexer.g:97:14: ( ( 'T' | 't' ) 'ransitive' ( ':' )? )
			// MOWLLexer.g:97:16: ( 'T' | 't' ) 'ransitive' ( ':' )?
			{
				if (this.input.LA(1) == 'T' || this.input.LA(1) == 't') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				this.match("ransitive");
				// MOWLLexer.g:97:36: ( ':' )?
				int alt13 = 2;
				int LA13_0 = this.input.LA(1);
				if (LA13_0 == ':') {
					alt13 = 1;
				}
				switch (alt13) {
				case 1:
					// MOWLLexer.g:97:36: ':'
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
			// MOWLLexer.g:100:19: ( ( 'I' | 'i' ) 'nverse' ( 'F' | 'f' )
			// 'unctional' ( ':' )? )
			// MOWLLexer.g:100:23: ( 'I' | 'i' ) 'nverse' ( 'F' | 'f' )
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
				// MOWLLexer.g:100:60: ( ':' )?
				int alt14 = 2;
				int LA14_0 = this.input.LA(1);
				if (LA14_0 == ':') {
					alt14 = 1;
				}
				switch (alt14) {
				case 1:
					// MOWLLexer.g:100:60: ':'
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
			// MOWLLexer.g:103:7: ( '^' )
			// MOWLLexer.g:103:9: '^'
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
			// MOWLLexer.g:106:7: ( ',' )
			// MOWLLexer.g:107:5: ','
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
			// MOWLLexer.g:110:13: ( ( 'I' | 'i' ) 'nstance' ( 'O' | 'o' ) 'f' )
			// MOWLLexer.g:110:15: ( 'I' | 'i' ) 'nstance' ( 'O' | 'o' ) 'f'
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
			// MOWLLexer.g:113:7: ( ( 'T' | 't' ) 'ypes' )
			// MOWLLexer.g:113:9: ( 'T' | 't' ) 'ypes'
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
	// $ANTLR start "OPEN_SQUARE_BRACKET"
	public final void mOPEN_SQUARE_BRACKET() throws RecognitionException {
		try {
			int _type = OPEN_SQUARE_BRACKET;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// MOWLLexer.g:118:3: ( '[' )
			// MOWLLexer.g:119:5: '['
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
			// MOWLLexer.g:123:3: ( ']' )
			// MOWLLexer.g:124:5: ']'
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
			// MOWLLexer.g:128:3: ( '=' )
			// MOWLLexer.g:129:5: '='
			{
				this.match('=');
			}
			this.state.type = _type;
			this.state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "EQUAL"
	// $ANTLR start "LESS_THAN"
	public final void mLESS_THAN() throws RecognitionException {
		try {
			int _type = LESS_THAN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// MOWLLexer.g:133:2: ( '<' )
			// MOWLLexer.g:134:3: '<'
			{
				this.match('<');
			}
			this.state.type = _type;
			this.state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "LESS_THAN"
	// $ANTLR start "LESS_THAN_EQUAL"
	public final void mLESS_THAN_EQUAL() throws RecognitionException {
		try {
			int _type = LESS_THAN_EQUAL;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// MOWLLexer.g:137:2: ( LESS_THAN EQUAL )
			// MOWLLexer.g:138:3: LESS_THAN EQUAL
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
	// $ANTLR start "GREATER_THAN"
	public final void mGREATER_THAN() throws RecognitionException {
		try {
			int _type = GREATER_THAN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// MOWLLexer.g:141:2: ( '>' )
			// MOWLLexer.g:142:3: '>'
			{
				this.match('>');
			}
			this.state.type = _type;
			this.state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "GREATER_THAN"
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
	// $ANTLR start "DBLQUOTE"
	public final void mDBLQUOTE() throws RecognitionException {
		try {
			int _type = DBLQUOTE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// MOWLLexer.g:150:10: ( '\"' (~ '\"' | '\"\"' )* '\"' )
			// MOWLLexer.g:151:7: '\"' (~ '\"' | '\"\"' )* '\"'
			{
				this.match('\"');
				// MOWLLexer.g:152:7: (~ '\"' | '\"\"' )*
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
						// MOWLLexer.g:152:8: ~ '\"'
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
						// MOWLLexer.g:152:15: '\"\"'
					{
						this.match("\"\"");
					}
						break;
					default:
						break loop15;
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
			// MOWLLexer.g:170:2: ( LESS_THAN (~ GREATER_THAN )+ GREATER_THAN )
			// MOWLLexer.g:171:2: LESS_THAN (~ GREATER_THAN )+ GREATER_THAN
			{
				this.mLESS_THAN();
				// MOWLLexer.g:171:11: (~ GREATER_THAN )+
				int cnt16 = 0;
				loop16: do {
					int alt16 = 2;
					int LA16_0 = this.input.LA(1);
					if (LA16_0 >= '\u0000' && LA16_0 <= '=' || LA16_0 >= '?' && LA16_0 <= '\uFFFF') {
						alt16 = 1;
					}
					switch (alt16) {
					case 1:
						// MOWLLexer.g:171:12: ~ GREATER_THAN
					{
						if (this.input.LA(1) >= '\u0000' && this.input.LA(1) <= '\u01FC'
								|| this.input.LA(1) >= '\u01FE' && this.input.LA(1) <= '\uFFFF') {
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
						if (cnt16 >= 1) {
							break loop16;
						}
						EarlyExitException eee = new EarlyExitException(16, this.input);
						throw eee;
					}
					cnt16++;
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
	// $ANTLR start "INTEGER"
	public final void mINTEGER() throws RecognitionException {
		try {
			int _type = INTEGER;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// MOWLLexer.g:187:8: ( ( DIGIT )+ )
			// MOWLLexer.g:187:10: ( DIGIT )+
			{
				// MOWLLexer.g:187:10: ( DIGIT )+
				int cnt17 = 0;
				loop17: do {
					int alt17 = 2;
					int LA17_0 = this.input.LA(1);
					if (LA17_0 >= '0' && LA17_0 <= '9') {
						alt17 = 1;
					}
					switch (alt17) {
					case 1:
						// MOWLLexer.g:187:10: DIGIT
					{
						this.mDIGIT();
					}
						break;
					default:
						if (cnt17 >= 1) {
							break loop17;
						}
						EarlyExitException eee = new EarlyExitException(17, this.input);
						throw eee;
					}
					cnt17++;
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
			// MOWLLexer.g:188:17: ( ( 'a' .. 'z' | 'A' .. 'Z' ) )
			// MOWLLexer.g:188:19: ( 'a' .. 'z' | 'A' .. 'Z' )
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
			// MOWLLexer.g:189:15: ( '0' .. '9' )
			// MOWLLexer.g:189:17: '0' .. '9'
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
			// MOWLLexer.g:191:12: ( LETTER ( LETTER | DIGIT | '-' | '_' | ':'
			// )* )
			// MOWLLexer.g:191:14: LETTER ( LETTER | DIGIT | '-' | '_' | ':' )*
			{
				this.mLETTER();
				// MOWLLexer.g:191:21: ( LETTER | DIGIT | '-' | '_' | ':' )*
				loop18: do {
					int alt18 = 2;
					int LA18_0 = this.input.LA(1);
					if (LA18_0 == '-' || LA18_0 >= '0' && LA18_0 <= ':' || LA18_0 >= 'A'
							&& LA18_0 <= 'Z' || LA18_0 == '_' || LA18_0 >= 'a' && LA18_0 <= 'z') {
						alt18 = 1;
					}
					switch (alt18) {
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
						break loop18;
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
			// MOWLLexer.g:192:18: ( '\\'' (~ '\\'' | '\\'\\'' )* '\\'' )
			// MOWLLexer.g:193:5: '\\'' (~ '\\'' | '\\'\\'' )* '\\''
			{
				this.match('\'');
				// MOWLLexer.g:193:10: (~ '\\'' | '\\'\\'' )*
				loop19: do {
					int alt19 = 3;
					int LA19_0 = this.input.LA(1);
					if (LA19_0 == '\'') {
						int LA19_1 = this.input.LA(2);
						if (LA19_1 == '\'') {
							alt19 = 2;
						}
					} else if (LA19_0 >= '\u0000' && LA19_0 <= '&' || LA19_0 >= '('
							&& LA19_0 <= '\uFFFF') {
						alt19 = 1;
					}
					switch (alt19) {
					case 1:
						// MOWLLexer.g:193:11: ~ '\\''
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
						// MOWLLexer.g:193:19: '\\'\\''
					{
						this.match("''");
					}
						break;
					default:
						break loop19;
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
		// | CLOSED_CURLY_BRACES | CLOSED_PARENTHESYS | WHITESPACE | AND | OR |
		// NOT | SOME | ONLY | MIN | MAX | EXACTLY | VALUE | INVERSE |
		// SUBCLASS_OF | SUB_PROPERTY_OF | EQUIVALENT_TO | SAME_AS |
		// DIFFERENT_FROM | INVERSE_OF | DISJOINT_WITH | DOMAIN | RANGE |
		// HAS_KEY | FUNCTIONAL | SYMMETRIC | ANTI_SYMMETRIC | REFLEXIVE |
		// IRREFLEXIVE | TRANSITIVE | INVERSE_FUNCTIONAL | POW | COMMA |
		// INSTANCE_OF | TYPES | OPEN_SQUARE_BRACKET | CLOSED_SQUARE_BRACKET |
		// EQUAL | LESS_THAN | LESS_THAN_EQUAL | GREATER_THAN |
		// GREATER_THAN_EQUAL | DBLQUOTE | IRI | INTEGER | IDENTIFIER |
		// ENTITY_REFERENCE )
		int alt20 = 49;
		alt20 = this.dfa20.predict(this.input);
		switch (alt20) {
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
			// MOWLLexer.g:1:261: HAS_KEY
		{
			this.mHAS_KEY();
		}
			break;
		case 27:
			// MOWLLexer.g:1:269: FUNCTIONAL
		{
			this.mFUNCTIONAL();
		}
			break;
		case 28:
			// MOWLLexer.g:1:280: SYMMETRIC
		{
			this.mSYMMETRIC();
		}
			break;
		case 29:
			// MOWLLexer.g:1:290: ANTI_SYMMETRIC
		{
			this.mANTI_SYMMETRIC();
		}
			break;
		case 30:
			// MOWLLexer.g:1:305: REFLEXIVE
		{
			this.mREFLEXIVE();
		}
			break;
		case 31:
			// MOWLLexer.g:1:315: IRREFLEXIVE
		{
			this.mIRREFLEXIVE();
		}
			break;
		case 32:
			// MOWLLexer.g:1:327: TRANSITIVE
		{
			this.mTRANSITIVE();
		}
			break;
		case 33:
			// MOWLLexer.g:1:338: INVERSE_FUNCTIONAL
		{
			this.mINVERSE_FUNCTIONAL();
		}
			break;
		case 34:
			// MOWLLexer.g:1:357: POW
		{
			this.mPOW();
		}
			break;
		case 35:
			// MOWLLexer.g:1:361: COMMA
		{
			this.mCOMMA();
		}
			break;
		case 36:
			// MOWLLexer.g:1:367: INSTANCE_OF
		{
			this.mINSTANCE_OF();
		}
			break;
		case 37:
			// MOWLLexer.g:1:379: TYPES
		{
			this.mTYPES();
		}
			break;
		case 38:
			// MOWLLexer.g:1:385: OPEN_SQUARE_BRACKET
		{
			this.mOPEN_SQUARE_BRACKET();
		}
			break;
		case 39:
			// MOWLLexer.g:1:405: CLOSED_SQUARE_BRACKET
		{
			this.mCLOSED_SQUARE_BRACKET();
		}
			break;
		case 40:
			// MOWLLexer.g:1:427: EQUAL
		{
			this.mEQUAL();
		}
			break;
		case 41:
			// MOWLLexer.g:1:433: LESS_THAN
		{
			this.mLESS_THAN();
		}
			break;
		case 42:
			// MOWLLexer.g:1:443: LESS_THAN_EQUAL
		{
			this.mLESS_THAN_EQUAL();
		}
			break;
		case 43:
			// MOWLLexer.g:1:459: GREATER_THAN
		{
			this.mGREATER_THAN();
		}
			break;
		case 44:
			// MOWLLexer.g:1:472: GREATER_THAN_EQUAL
		{
			this.mGREATER_THAN_EQUAL();
		}
			break;
		case 45:
			// MOWLLexer.g:1:491: DBLQUOTE
		{
			this.mDBLQUOTE();
		}
			break;
		case 46:
			// MOWLLexer.g:1:500: IRI
		{
			this.mIRI();
		}
			break;
		case 47:
			// MOWLLexer.g:1:504: INTEGER
		{
			this.mINTEGER();
		}
			break;
		case 48:
			// MOWLLexer.g:1:512: IDENTIFIER
		{
			this.mIDENTIFIER();
		}
			break;
		case 49:
			// MOWLLexer.g:1:523: ENTITY_REFERENCE
		{
			this.mENTITY_REFERENCE();
		}
			break;
		}
	}

	protected DFA20 dfa20 = new DFA20(this);
	static final String DFA20_eotS = "\1\uffff\1\46\5\uffff\22\42\5\uffff\1\106\1\111\4\uffff\1\113\1"
			+ "\42\1\uffff\37\42\1\uffff\1\157\4\uffff\1\42\1\161\1\42\3\163\4"
			+ "\42\1\171\1\172\3\42\2\177\12\42\1\177\7\42\1\uffff\1\u0091\1\uffff"
			+ "\1\42\1\uffff\1\u0093\4\42\2\uffff\4\42\1\uffff\21\42\1\uffff\1"
			+ "\42\1\uffff\6\42\1\u00b4\13\42\1\u00c0\1\42\1\u00c0\3\42\1\u00c5"
			+ "\3\42\1\u00c9\3\42\1\uffff\3\42\1\u00c9\2\42\1\u00d2\2\42\1\u00d2"
			+ "\1\42\1\uffff\1\42\1\u00d7\2\42\1\uffff\3\42\1\uffff\1\42\1\u00de"
			+ "\6\42\1\uffff\4\42\1\uffff\6\42\1\uffff\20\42\1\u0101\1\42\1\u0103"
			+ "\7\42\1\u0103\1\u010c\3\42\1\u0110\1\42\1\u0101\1\uffff\1\42\1\uffff"
			+ "\1\42\1\u0114\5\42\1\u010c\1\uffff\1\u011b\1\u011c\1\42\1\uffff"
			+ "\3\42\1\uffff\1\u0123\4\42\1\u011b\2\uffff\1\u011c\2\42\1\u012a"
			+ "\1\42\1\u0123\1\uffff\1\42\1\u012d\1\42\1\u012d\1\u0130\1\u0131"
			+ "\1\uffff\1\42\1\u0133\1\uffff\1\u0133\1\u0130\2\uffff\1\42\1\uffff"
			+ "\2\42\2\u0138\1\uffff";
	static final String DFA20_eofS = "\u0139\uffff";
	static final String DFA20_minS = "\1\11\1\55\5\uffff\1\156\1\157\1\117\2\141\1\161\1\141\1\116\1\141"
			+ "\2\151\1\116\2\141\1\101\1\165\1\156\1\162\5\uffff\1\0\1\75\4\uffff"
			+ "\1\55\1\154\1\uffff\1\144\1\164\1\124\1\164\1\155\1\142\2\155\1"
			+ "\156\1\170\1\141\1\165\1\154\2\126\1\162\1\142\1\155\1\146\1\155"
			+ "\1\146\1\155\1\126\1\156\1\146\1\156\1\123\1\156\1\164\1\141\1\160"
			+ "\1\uffff\1\0\4\uffff\1\171\1\55\1\151\3\55\1\145\1\103\1\145\1\155"
			+ "\2\55\1\143\1\151\1\165\2\55\1\164\1\145\1\103\1\145\1\146\1\152"
			+ "\1\141\1\146\1\152\1\141\1\55\1\147\1\154\1\147\1\113\1\143\1\156"
			+ "\1\145\1\uffff\1\55\1\uffff\1\123\1\uffff\1\55\1\154\1\162\1\101"
			+ "\1\145\2\uffff\1\164\1\166\1\145\1\162\1\uffff\1\141\1\146\1\101"
			+ "\1\145\1\157\1\151\1\145\1\157\1\151\1\162\3\145\1\105\1\164\2\163"
			+ "\1\uffff\1\171\1\uffff\1\141\1\157\1\163\1\164\1\154\1\141\1\55"
			+ "\1\163\1\156\1\154\1\163\1\162\1\151\1\156\1\162\1\151\1\156\1\163"
			+ "\1\55\1\170\1\55\1\131\2\151\1\55\1\155\1\163\1\160\1\55\1\162\1"
			+ "\171\1\154\1\uffff\1\145\1\143\1\145\1\55\1\145\1\156\1\55\1\145"
			+ "\1\156\1\55\1\145\1\uffff\1\151\1\55\1\157\1\164\1\uffff\1\155\1"
			+ "\163\1\145\1\uffff\1\151\1\55\1\145\1\106\1\145\1\170\1\156\1\164"
			+ "\1\uffff\1\156\1\164\1\106\1\166\1\uffff\1\156\1\151\1\145\1\117"
			+ "\1\162\1\143\1\uffff\1\156\1\146\1\165\1\117\1\151\1\164\1\127\1"
			+ "\164\1\127\1\146\1\145\1\141\1\166\1\164\1\146\1\164\1\55\1\164"
			+ "\1\55\1\156\1\146\1\166\1\106\1\151\1\106\1\151\2\55\1\154\1\145"
			+ "\1\162\1\55\1\171\1\55\1\uffff\1\124\1\uffff\1\143\1\55\1\145\1"
			+ "\162\1\164\1\162\1\164\1\55\1\uffff\2\55\1\151\1\uffff\1\117\1\157"
			+ "\1\164\1\uffff\1\55\1\157\1\150\1\157\1\150\1\55\2\uffff\1\55\1"
			+ "\143\1\146\1\55\1\151\1\55\1\uffff\1\155\1\55\1\155\3\55\1\uffff"
			+ "\1\157\1\55\1\uffff\2\55\2\uffff\1\156\1\uffff\1\141\1\154\2\55" + "\1\uffff";
	static final String DFA20_maxS = "\1\175\1\172\5\uffff\1\156\2\157\1\171\1\151\1\170\1\141\1\162\1"
			+ "\171\2\157\1\162\2\145\1\141\1\165\1\156\1\171\5\uffff\1\uffff\1"
			+ "\75\4\uffff\1\172\1\154\1\uffff\2\164\1\124\1\164\1\155\1\142\2"
			+ "\155\1\156\1\170\1\141\1\165\1\154\2\166\1\162\1\142\1\155\1\163"
			+ "\1\155\1\163\1\155\1\166\1\156\1\146\1\156\1\163\1\156\1\164\1\141"
			+ "\1\160\1\uffff\1\uffff\4\uffff\1\171\1\172\1\151\3\172\1\145\1\120"
			+ "\1\145\1\155\2\172\1\143\1\151\1\165\2\172\1\164\1\145\1\103\1\145"
			+ "\1\146\1\152\1\141\1\146\1\152\1\141\1\172\1\147\1\154\1\147\1\153"
			+ "\1\143\1\156\1\145\1\uffff\1\172\1\uffff\1\163\1\uffff\1\172\1\154"
			+ "\1\162\1\101\1\145\2\uffff\1\164\1\166\1\145\1\162\1\uffff\1\141"
			+ "\1\146\1\101\1\145\1\157\1\151\1\145\1\157\1\151\1\162\4\145\1\164"
			+ "\2\163\1\uffff\1\171\1\uffff\1\141\1\157\1\163\1\164\1\154\1\141"
			+ "\1\172\1\163\1\156\1\154\1\163\1\162\1\151\1\156\1\162\1\151\1\156"
			+ "\1\163\1\172\1\170\1\172\1\171\2\151\1\172\1\155\1\163\1\160\1\172"
			+ "\1\162\1\171\1\154\1\uffff\1\145\1\143\1\145\1\172\1\145\1\156\1"
			+ "\172\1\145\1\156\1\172\1\145\1\uffff\1\151\1\172\1\157\1\164\1\uffff"
			+ "\1\155\1\163\1\145\1\uffff\1\151\1\172\1\145\1\146\1\145\1\170\1"
			+ "\156\1\164\1\uffff\1\156\1\164\1\146\1\166\1\uffff\1\156\1\151\1"
			+ "\145\1\117\1\162\1\143\1\uffff\1\156\1\146\1\165\1\157\1\151\1\164"
			+ "\1\127\1\164\1\127\1\146\1\145\1\141\1\166\1\164\1\146\1\164\1\172"
			+ "\1\164\1\172\1\156\1\146\1\166\1\106\1\151\1\106\1\151\2\172\1\154"
			+ "\1\145\1\162\1\172\1\171\1\172\1\uffff\1\124\1\uffff\1\143\1\172"
			+ "\1\145\1\162\1\164\1\162\1\164\1\172\1\uffff\2\172\1\151\1\uffff"
			+ "\1\117\1\157\1\164\1\uffff\1\172\1\157\1\150\1\157\1\150\1\172\2"
			+ "\uffff\1\172\1\143\1\146\1\172\1\151\1\172\1\uffff\1\155\1\172\1"
			+ "\155\3\172\1\uffff\1\157\1\172\1\uffff\2\172\2\uffff\1\156\1\uffff"
			+ "\1\141\1\154\2\172\1\uffff";
	static final String DFA20_acceptS = "\2\uffff\1\2\1\3\1\4\1\5\1\6\22\uffff\1\42\1\43\1\46\1\47\1\50\2"
			+ "\uffff\1\55\1\57\1\60\1\61\2\uffff\1\1\37\uffff\1\51\1\uffff\1\56"
			+ "\1\53\1\54\1\10\43\uffff\1\52\1\uffff\1\7\1\uffff\1\11\5\uffff\1"
			+ "\14\1\15\4\uffff\1\20\21\uffff\1\13\1\uffff\1\12\40\uffff\1\17\13"
			+ "\uffff\1\31\4\uffff\1\45\3\uffff\1\24\10\uffff\1\30\4\uffff\1\32"
			+ "\6\uffff\1\16\42\uffff\1\34\1\uffff\1\26\10\uffff\1\36\3\uffff\1"
			+ "\21\3\uffff\1\44\6\uffff\1\33\1\40\6\uffff\1\37\6\uffff\1\23\2\uffff"
			+ "\1\27\2\uffff\1\35\1\22\1\uffff\1\25\4\uffff\1\41";
	static final String DFA20_specialS = "\36\uffff\1\1\50\uffff\1\0\u00f1\uffff}>";
	static final String[] DFA20_transitionS = {
			"\2\6\2\uffff\1\6\22\uffff\1\6\1\uffff\1\40\4\uffff\1\43\1\2"
					+ "\1\5\2\uffff\1\32\3\uffff\12\41\2\uffff\1\36\1\35\1\37\2\uffff"
					+ "\1\27\2\42\1\21\1\42\1\26\1\42\1\25\1\16\4\42\1\11\3\42\1\23"
					+ "\1\17\1\30\6\42\1\33\1\uffff\1\34\1\31\2\uffff\1\7\2\42\1\20"
					+ "\1\14\1\26\1\42\1\25\1\22\3\42\1\13\1\10\1\1\2\42\1\24\1\12"
					+ "\1\30\1\42\1\15\4\42\1\3\1\uffff\1\4",
			"\1\42\2\uffff\13\42\6\uffff\32\42\4\uffff\1\42\1\uffff\15\42"
					+ "\1\45\3\42\1\44\10\42", "", "", "", "", "", "\1\47", "\1\50",
			"\1\51\37\uffff\1\52", "\1\55\15\uffff\1\53\5\uffff\1\54\3\uffff\1\56",
			"\1\60\7\uffff\1\57", "\1\62\6\uffff\1\61", "\1\63",
			"\1\65\37\uffff\1\64\3\uffff\1\66", "\1\70\23\uffff\1\67\3\uffff\1\56",
			"\1\71\5\uffff\1\72", "\1\73\5\uffff\1\74", "\1\65\37\uffff\1\75\3\uffff\1\66",
			"\1\76\3\uffff\1\77", "\1\100\3\uffff\1\77", "\1\101\37\uffff\1\101", "\1\102",
			"\1\103", "\1\104\6\uffff\1\105", "", "", "", "", "",
			"\75\110\1\107\1\uffff\uffc1\110", "\1\112", "", "", "", "",
			"\1\42\2\uffff\13\42\6\uffff\32\42\4\uffff\1\42\1\uffff\32\42", "\1\114", "",
			"\1\115\17\uffff\1\116", "\1\117", "\1\120", "\1\121", "\1\122", "\1\123", "\1\124",
			"\1\125", "\1\126", "\1\127", "\1\130", "\1\131", "\1\132",
			"\1\134\34\uffff\1\135\2\uffff\1\133", "\1\134\37\uffff\1\134", "\1\136", "\1\137",
			"\1\140", "\1\141\14\uffff\1\142", "\1\143", "\1\144\14\uffff\1\145", "\1\146",
			"\1\134\34\uffff\1\135\2\uffff\1\147", "\1\150", "\1\151", "\1\152",
			"\1\153\37\uffff\1\153", "\1\154", "\1\116", "\1\155", "\1\156", "", "\0\110", "", "",
			"", "", "\1\160", "\1\42\2\uffff\13\42\6\uffff\32\42\4\uffff\1\42\1\uffff\32\42",
			"\1\162", "\1\42\2\uffff\13\42\6\uffff\32\42\4\uffff\1\42\1\uffff\32\42",
			"\1\42\2\uffff\13\42\6\uffff\32\42\4\uffff\1\42\1\uffff\32\42",
			"\1\42\2\uffff\13\42\6\uffff\32\42\4\uffff\1\42\1\uffff\32\42", "\1\164",
			"\1\165\14\uffff\1\166", "\1\167", "\1\170",
			"\1\42\2\uffff\13\42\6\uffff\32\42\4\uffff\1\42\1\uffff\32\42",
			"\1\42\2\uffff\13\42\6\uffff\32\42\4\uffff\1\42\1\uffff\32\42", "\1\173", "\1\174",
			"\1\175",
			"\1\42\2\uffff\13\42\6\uffff\32\42\4\uffff\1\42\1\uffff\4\42" + "\1\176\25\42",
			"\1\42\2\uffff\13\42\6\uffff\32\42\4\uffff\1\42\1\uffff\32\42", "\1\u0080", "\1\u0081",
			"\1\165", "\1\u0082", "\1\u0083", "\1\u0084", "\1\u0085", "\1\u0086", "\1\u0087",
			"\1\u0088",
			"\1\42\2\uffff\13\42\6\uffff\32\42\4\uffff\1\42\1\uffff\4\42" + "\1\u0089\25\42",
			"\1\u008a", "\1\u008b", "\1\u008c", "\1\u008d\37\uffff\1\u008d", "\1\u008e",
			"\1\u008f", "\1\u0090", "",
			"\1\42\2\uffff\13\42\6\uffff\32\42\4\uffff\1\42\1\uffff\32\42", "",
			"\1\u0092\37\uffff\1\u0092", "",
			"\1\42\2\uffff\13\42\6\uffff\32\42\4\uffff\1\42\1\uffff\32\42", "\1\u0094", "\1\u0095",
			"\1\u0096", "\1\u0097", "", "", "\1\u0098", "\1\u0099", "\1\u009a", "\1\u009b", "",
			"\1\u009c", "\1\u009d", "\1\u009e", "\1\u009f", "\1\u00a0", "\1\u00a1", "\1\u00a2",
			"\1\u00a3", "\1\u00a4", "\1\u00a5", "\1\u00a6", "\1\u00a7", "\1\u00a8",
			"\1\u00a9\37\uffff\1\u00a9", "\1\u00aa", "\1\u00ab", "\1\u00ac", "", "\1\u00ad", "",
			"\1\u00ae", "\1\u00af", "\1\u00b0", "\1\u00b1", "\1\u00b2", "\1\u00b3",
			"\1\42\2\uffff\13\42\6\uffff\32\42\4\uffff\1\42\1\uffff\32\42", "\1\u00b5", "\1\u00b6",
			"\1\u00b7", "\1\u00b8", "\1\u00b9", "\1\u00ba", "\1\u00bb", "\1\u00bc", "\1\u00bd",
			"\1\u00be", "\1\u00bf", "\1\42\2\uffff\13\42\6\uffff\32\42\4\uffff\1\42\1\uffff\32\42",
			"\1\u00c1", "\1\42\2\uffff\13\42\6\uffff\32\42\4\uffff\1\42\1\uffff\32\42",
			"\1\u00c2\37\uffff\1\u00c2", "\1\u00c3", "\1\u00c4",
			"\1\42\2\uffff\13\42\6\uffff\32\42\4\uffff\1\42\1\uffff\32\42", "\1\u00c6", "\1\u00c7",
			"\1\u00c8", "\1\42\2\uffff\13\42\6\uffff\32\42\4\uffff\1\42\1\uffff\32\42", "\1\u00ca",
			"\1\u00cb", "\1\u00cc", "", "\1\u00cd", "\1\u00ce", "\1\u00cf",
			"\1\42\2\uffff\13\42\6\uffff\32\42\4\uffff\1\42\1\uffff\32\42", "\1\u00d0", "\1\u00d1",
			"\1\42\2\uffff\13\42\6\uffff\32\42\4\uffff\1\42\1\uffff\32\42", "\1\u00d3", "\1\u00d4",
			"\1\42\2\uffff\13\42\6\uffff\32\42\4\uffff\1\42\1\uffff\32\42", "\1\u00d5", "",
			"\1\u00d6", "\1\42\2\uffff\13\42\6\uffff\32\42\4\uffff\1\42\1\uffff\32\42", "\1\u00d8",
			"\1\u00d9", "", "\1\u00da", "\1\u00db", "\1\u00dc", "", "\1\u00dd",
			"\1\42\2\uffff\13\42\6\uffff\32\42\4\uffff\1\42\1\uffff\32\42", "\1\u00df",
			"\1\u00e1\10\uffff\1\u00e0\26\uffff\1\u00e1", "\1\u00e2", "\1\u00e3", "\1\u00e4",
			"\1\u00e5", "", "\1\u00e6", "\1\u00e7", "\1\u00e1\10\uffff\1\u00e8\26\uffff\1\u00e1",
			"\1\u00e9", "", "\1\u00ea", "\1\u00eb", "\1\u00ec", "\1\u00ed", "\1\u00ee", "\1\u00ef",
			"", "\1\u00f0", "\1\u00f1", "\1\u00f2", "\1\u00f3\37\uffff\1\u00f3", "\1\u00f4",
			"\1\u00f5", "\1\u00f6", "\1\u00f7", "\1\u00f8", "\1\u00f9", "\1\u00fa", "\1\u00fb",
			"\1\u00fc", "\1\u00fd", "\1\u00fe", "\1\u00ff",
			"\1\42\2\uffff\12\42\1\u0100\6\uffff\32\42\4\uffff\1\42\1\uffff" + "\32\42",
			"\1\u0102", "\1\42\2\uffff\13\42\6\uffff\32\42\4\uffff\1\42\1\uffff\32\42", "\1\u0104",
			"\1\u0105", "\1\u0106", "\1\u0107", "\1\u0108", "\1\u0109", "\1\u010a",
			"\1\42\2\uffff\13\42\6\uffff\32\42\4\uffff\1\42\1\uffff\32\42",
			"\1\42\2\uffff\12\42\1\u010b\6\uffff\32\42\4\uffff\1\42\1\uffff" + "\32\42",
			"\1\u010d", "\1\u010e", "\1\u010f",
			"\1\42\2\uffff\13\42\6\uffff\32\42\4\uffff\1\42\1\uffff\32\42", "\1\u0111",
			"\1\42\2\uffff\13\42\6\uffff\32\42\4\uffff\1\42\1\uffff\32\42", "", "\1\u0112", "",
			"\1\u0113", "\1\42\2\uffff\13\42\6\uffff\32\42\4\uffff\1\42\1\uffff\32\42", "\1\u0115",
			"\1\u0116", "\1\u0117", "\1\u0118", "\1\u0119",
			"\1\42\2\uffff\13\42\6\uffff\32\42\4\uffff\1\42\1\uffff\32\42", "",
			"\1\42\2\uffff\12\42\1\u011a\6\uffff\32\42\4\uffff\1\42\1\uffff" + "\32\42",
			"\1\42\2\uffff\12\42\1\u011d\6\uffff\32\42\4\uffff\1\42\1\uffff" + "\32\42",
			"\1\u011e", "", "\1\u011f", "\1\u0120", "\1\u0121", "",
			"\1\42\2\uffff\12\42\1\u0122\6\uffff\32\42\4\uffff\1\42\1\uffff" + "\32\42",
			"\1\u0124", "\1\u0125", "\1\u0126", "\1\u0127",
			"\1\42\2\uffff\13\42\6\uffff\32\42\4\uffff\1\42\1\uffff\32\42", "", "",
			"\1\42\2\uffff\13\42\6\uffff\32\42\4\uffff\1\42\1\uffff\32\42", "\1\u0128", "\1\u0129",
			"\1\42\2\uffff\13\42\6\uffff\32\42\4\uffff\1\42\1\uffff\32\42", "\1\u012b",
			"\1\42\2\uffff\13\42\6\uffff\32\42\4\uffff\1\42\1\uffff\32\42", "", "\1\u012c",
			"\1\42\2\uffff\13\42\6\uffff\32\42\4\uffff\1\42\1\uffff\32\42", "\1\u012e",
			"\1\42\2\uffff\13\42\6\uffff\32\42\4\uffff\1\42\1\uffff\32\42",
			"\1\42\2\uffff\12\42\1\u012f\6\uffff\32\42\4\uffff\1\42\1\uffff" + "\32\42",
			"\1\42\2\uffff\13\42\6\uffff\32\42\4\uffff\1\42\1\uffff\32\42", "", "\1\u0132",
			"\1\42\2\uffff\13\42\6\uffff\32\42\4\uffff\1\42\1\uffff\32\42", "",
			"\1\42\2\uffff\13\42\6\uffff\32\42\4\uffff\1\42\1\uffff\32\42",
			"\1\42\2\uffff\13\42\6\uffff\32\42\4\uffff\1\42\1\uffff\32\42", "", "", "\1\u0134", "",
			"\1\u0135", "\1\u0136",
			"\1\42\2\uffff\12\42\1\u0137\6\uffff\32\42\4\uffff\1\42\1\uffff" + "\32\42",
			"\1\42\2\uffff\13\42\6\uffff\32\42\4\uffff\1\42\1\uffff\32\42", "" };
	static final short[] DFA20_eot = DFA.unpackEncodedString(DFA20_eotS);
	static final short[] DFA20_eof = DFA.unpackEncodedString(DFA20_eofS);
	static final char[] DFA20_min = DFA.unpackEncodedStringToUnsignedChars(DFA20_minS);
	static final char[] DFA20_max = DFA.unpackEncodedStringToUnsignedChars(DFA20_maxS);
	static final short[] DFA20_accept = DFA.unpackEncodedString(DFA20_acceptS);
	static final short[] DFA20_special = DFA.unpackEncodedString(DFA20_specialS);
	static final short[][] DFA20_transition;
	static {
		int numStates = DFA20_transitionS.length;
		DFA20_transition = new short[numStates][];
		for (int i = 0; i < numStates; i++) {
			DFA20_transition[i] = DFA.unpackEncodedString(DFA20_transitionS[i]);
		}
	}

	class DFA20 extends DFA {
		public DFA20(BaseRecognizer recognizer) {
			this.recognizer = recognizer;
			this.decisionNumber = 20;
			this.eot = DFA20_eot;
			this.eof = DFA20_eof;
			this.min = DFA20_min;
			this.max = DFA20_max;
			this.accept = DFA20_accept;
			this.special = DFA20_special;
			this.transition = DFA20_transition;
		}

		@Override
		public String getDescription() {
			return "1:1: Tokens : ( COMPOSITION | OPEN_PARENTHESYS | OPEN_CURLY_BRACES | CLOSED_CURLY_BRACES | CLOSED_PARENTHESYS | WHITESPACE | AND | OR | NOT | SOME | ONLY | MIN | MAX | EXACTLY | VALUE | INVERSE | SUBCLASS_OF | SUB_PROPERTY_OF | EQUIVALENT_TO | SAME_AS | DIFFERENT_FROM | INVERSE_OF | DISJOINT_WITH | DOMAIN | RANGE | HAS_KEY | FUNCTIONAL | SYMMETRIC | ANTI_SYMMETRIC | REFLEXIVE | IRREFLEXIVE | TRANSITIVE | INVERSE_FUNCTIONAL | POW | COMMA | INSTANCE_OF | TYPES | OPEN_SQUARE_BRACKET | CLOSED_SQUARE_BRACKET | EQUAL | LESS_THAN | LESS_THAN_EQUAL | GREATER_THAN | GREATER_THAN_EQUAL | DBLQUOTE | IRI | INTEGER | IDENTIFIER | ENTITY_REFERENCE );";
		}

		@Override
		public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
			IntStream input = _input;
			int _s = s;
			switch (s) {
			case 0:
				int LA20_71 = input.LA(1);
				s = -1;
				if (LA20_71 >= '\u0000' && LA20_71 <= '\uFFFF') {
					s = 72;
				} else {
					s = 111;
				}
				if (s >= 0) {
					return s;
				}
				break;
			case 1:
				int LA20_30 = input.LA(1);
				s = -1;
				if (LA20_30 == '=') {
					s = 71;
				} else if (LA20_30 >= '\u0000' && LA20_30 <= '<' || LA20_30 >= '?'
						&& LA20_30 <= '\uFFFF') {
					s = 72;
				} else {
					s = 70;
				}
				if (s >= 0) {
					return s;
				}
				break;
			}
			NoViableAltException nvae = new NoViableAltException(this.getDescription(), 20, _s,
					input);
			this.error(nvae);
			throw nvae;
		}
	}
}