package org.coode.parsers.oppl.patterns;

// $ANTLR 3.2 Sep 23, 2009 12:02:23 /Users/luigi/Documents/workspace/Parsers/src/OPPLPatternLexer.g 2011-01-10 16:02:46
import org.antlr.runtime.BaseRecognizer;
import org.antlr.runtime.CharStream;
import org.antlr.runtime.DFA;
import org.antlr.runtime.IntStream;
import org.antlr.runtime.Lexer;
import org.antlr.runtime.NoViableAltException;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.RecognizerSharedState;

public class OPPLPatternLexer extends Lexer {
	public static final int COMMA = 37;
	public static final int GREATER_THAN = 509;
	public static final int ASSERTED = 76;
	public static final int END = 84;
	public static final int HYPHEN = 465;
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
	public static final int AT = 114;
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
	public static final int FAIL = 537;
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
	public OPPLPatternLexer_OPPLLexer gOPPLLexer;

	// delegators
	public OPPLPatternLexer() {
		;
	}

	public OPPLPatternLexer(CharStream input) {
		this(input, new RecognizerSharedState());
	}

	public OPPLPatternLexer(CharStream input, RecognizerSharedState state) {
		super(input, state);
		this.gOPPLLexer = new OPPLPatternLexer_OPPLLexer(input, state, this);
	}

	@Override
	public String getGrammarFileName() {
		return "/Users/luigi/Documents/workspace/Parsers/src/OPPLPatternLexer.g";
	}

	// $ANTLR start "THIS_CLASS"
	public final void mTHIS_CLASS() throws RecognitionException {
		try {
			int _type = THIS_CLASS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/luigi/Documents/workspace/Parsers/src/OPPLPatternLexer.g:24:3:
			// ( '$thisClass' )
			// /Users/luigi/Documents/workspace/Parsers/src/OPPLPatternLexer.g:25:5:
			// '$thisClass'
			{
				this.match("$thisClass");
			}
			this.state.type = _type;
			this.state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "THIS_CLASS"
	// $ANTLR start "DOLLAR"
	public final void mDOLLAR() throws RecognitionException {
		try {
			int _type = DOLLAR;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/luigi/Documents/workspace/Parsers/src/OPPLPatternLexer.g:29:3:
			// ( '$' )
			// /Users/luigi/Documents/workspace/Parsers/src/OPPLPatternLexer.g:30:5:
			// '$'
			{
				this.match('$');
			}
			this.state.type = _type;
			this.state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "DOLLAR"
	// $ANTLR start "RETURN"
	public final void mRETURN() throws RecognitionException {
		try {
			int _type = RETURN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/luigi/Documents/workspace/Parsers/src/OPPLPatternLexer.g:34:3:
			// ( 'RETURN' )
			// /Users/luigi/Documents/workspace/Parsers/src/OPPLPatternLexer.g:35:5:
			// 'RETURN'
			{
				this.match("RETURN");
			}
			this.state.type = _type;
			this.state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "RETURN"
	// $ANTLR start "SEMICOLON"
	public final void mSEMICOLON() throws RecognitionException {
		try {
			int _type = SEMICOLON;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/luigi/Documents/workspace/Parsers/src/OPPLPatternLexer.g:39:2:
			// ( ';' )
			// /Users/luigi/Documents/workspace/Parsers/src/OPPLPatternLexer.g:40:3:
			// ';'
			{
				this.match(';');
			}
			this.state.type = _type;
			this.state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "SEMICOLON"
	// $ANTLR start "HYPHEN"
	public final void mHYPHEN() throws RecognitionException {
		try {
			int _type = HYPHEN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/luigi/Documents/workspace/Parsers/src/OPPLPatternLexer.g:43:8:
			// ( '-' )
			// /Users/luigi/Documents/workspace/Parsers/src/OPPLPatternLexer.g:44:3:
			// '-'
			{
				this.match('-');
			}
			this.state.type = _type;
			this.state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "HYPHEN"
	@Override
	public void mTokens() throws RecognitionException {
		// /Users/luigi/Documents/workspace/Parsers/src/OPPLPatternLexer.g:1:8:
		// ( THIS_CLASS | DOLLAR | RETURN | SEMICOLON | HYPHEN | MOWLLexer.
		// Tokens | OPPLLexer. Tokens )
		int alt1 = 7;
		alt1 = this.dfa1.predict(this.input);
		switch (alt1) {
		case 1:
			// /Users/luigi/Documents/workspace/Parsers/src/OPPLPatternLexer.g:1:10:
			// THIS_CLASS
		{
			this.mTHIS_CLASS();
		}
			break;
		case 2:
			// /Users/luigi/Documents/workspace/Parsers/src/OPPLPatternLexer.g:1:21:
			// DOLLAR
		{
			this.mDOLLAR();
		}
			break;
		case 3:
			// /Users/luigi/Documents/workspace/Parsers/src/OPPLPatternLexer.g:1:28:
			// RETURN
		{
			this.mRETURN();
		}
			break;
		case 4:
			// /Users/luigi/Documents/workspace/Parsers/src/OPPLPatternLexer.g:1:35:
			// SEMICOLON
		{
			this.mSEMICOLON();
		}
			break;
		case 5:
			// /Users/luigi/Documents/workspace/Parsers/src/OPPLPatternLexer.g:1:45:
			// HYPHEN
		{
			this.mHYPHEN();
		}
			break;
		case 6:
		case 7:
			// /Users/luigi/Documents/workspace/Parsers/src/OPPLPatternLexer.g:1:69:
			// OPPLLexer. Tokens
		{
			this.gOPPLLexer.mTokens();
		}
			break;
		}
	}

	protected DFA1 dfa1 = new DFA1(this);
	static final String DFA1_eotS = "\1\uffff\1\64\1\70\2\uffff\1\70\6\uffff\21\70\5\uffff\2\70\1\uffff"
			+ "\2\70\1\uffff\3\70\1\uffff\7\70\2\uffff\3\70\1\uffff\52\70\3\uffff"
			+ "\4\70\1\uffff\73\70\2\uffff\3\70\1\uffff\153\70\1\u013d\45\70\1" + "\uffff\u00b7\70";
	static final String DFA1_eofS = "\u01f5\uffff";
	static final String DFA1_minS = "\1\11\1\164\1\55\2\uffff\1\55\6\uffff\21\55\5\uffff\1\0\1\75\1\0"
			+ "\1\60\1\55\1\0\3\55\1\uffff\7\55\2\uffff\3\55\1\uffff\51\55\2\0"
			+ "\1\uffff\1\0\1\42\3\55\1\0\1\47\72\55\1\uffff\1\0\3\55\1\0\u0091"
			+ "\55\1\uffff\u00b7\55";
	static final String DFA1_maxS = "\1\175\1\164\1\172\2\uffff\1\172\6\uffff\21\172\5\uffff\1\uffff"
			+ "\1\75\1\uffff\1\71\1\172\1\uffff\3\172\1\uffff\7\172\2\uffff\3\172"
			+ "\1\uffff\51\172\2\uffff\1\uffff\1\uffff\1\42\3\172\1\uffff\1\47"
			+ "\72\172\1\uffff\1\uffff\3\172\1\uffff\u0091\172\1\uffff\u00b7\172";
	static final String DFA1_acceptS = "\3\uffff\1\4\1\5\1\uffff\6\6\21\uffff\5\6\11\uffff\1\7\7\uffff\1"
			+ "\1\1\2\3\uffff\1\6\53\uffff\1\6\101\uffff\1\6\u0096\uffff\1\3\u00b7" + "\uffff";
	static final String DFA1_specialS = "\42\uffff\1\4\1\uffff\1\3\2\uffff\1\1\72\uffff\1\7\1\5\1\uffff\1"
			+ "\10\4\uffff\1\2\74\uffff\1\6\3\uffff\1\0\u0149\uffff}>";
	static final String[] DFA1_transitionS = {
			"\2\13\2\uffff\1\13\22\uffff\1\13\1\53\1\44\1\uffff\1\1\2\uffff"
					+ "\1\47\1\6\1\11\1\uffff\1\53\1\36\1\4\1\53\1\uffff\12\45\1\53"
					+ "\1\3\1\42\1\41\1\43\1\53\1\12\1\33\1\54\1\46\1\26\1\55\1\32"
					+ "\1\61\1\31\1\23\3\62\1\56\1\16\1\50\2\62\1\2\1\24\1\34\1\62"
					+ "\1\57\1\51\3\62\1\37\1\uffff\1\40\1\35\2\uffff\1\14\1\62\1\52"
					+ "\1\25\1\21\1\60\1\62\1\31\1\27\3\62\1\20\1\15\1\5\2\62\1\30"
					+ "\1\17\1\34\1\62\1\22\4\62\1\7\1\uffff\1\10",
			"\1\63",
			"\1\71\2\uffff\13\71\6\uffff\4\71\1\65\25\71\4\uffff\1\71\1"
					+ "\uffff\1\66\3\71\1\67\25\71",
			"",
			"",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\15\71"
					+ "\1\73\3\71\1\72\10\71",
			"",
			"",
			"",
			"",
			"",
			"",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\15\71" + "\1\74\14\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\16\71" + "\1\75\13\71",
			"\1\71\2\uffff\13\71\6\uffff\16\71\1\76\13\71\4\uffff\1\71\1"
					+ "\uffff\16\71\1\77\13\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\1\102"
					+ "\15\71\1\100\5\71\1\101\3\71\1\103\1\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\1\105" + "\7\71\1\104\21\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\20\71"
					+ "\1\107\6\71\1\106\2\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\1\110" + "\31\71",
			"\1\71\2\uffff\13\71\6\uffff\15\71\1\112\3\71\1\114\10\71\4"
					+ "\uffff\1\71\1\uffff\15\71\1\111\3\71\1\113\10\71",
			"\1\71\2\uffff\13\71\6\uffff\4\71\1\117\25\71\4\uffff\1\71\1"
					+ "\uffff\1\116\23\71\1\115\3\71\1\103\1\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\10\71"
					+ "\1\120\5\71\1\121\13\71",
			"\1\71\2\uffff\13\71\6\uffff\1\124\31\71\4\uffff\1\71\1\uffff"
					+ "\10\71\1\122\5\71\1\123\13\71",
			"\1\71\2\uffff\13\71\6\uffff\15\71\1\126\14\71\4\uffff\1\71"
					+ "\1\uffff\15\71\1\125\3\71\1\113\10\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\1\127" + "\3\71\1\67\25\71",
			"\1\71\2\uffff\13\71\6\uffff\1\130\31\71\4\uffff\1\71\1\uffff" + "\1\130\31\71",
			"\1\71\2\uffff\13\71\6\uffff\1\132\31\71\4\uffff\1\71\1\uffff"
					+ "\1\133\23\71\1\131\5\71",
			"\1\71\2\uffff\13\71\6\uffff\3\71\1\136\11\71\1\135\4\71\1\137"
					+ "\7\71\4\uffff\1\71\1\uffff\15\71\1\134\14\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\21\71"
					+ "\1\140\6\71\1\141\1\71",
			"",
			"",
			"",
			"",
			"",
			"\75\143\1\142\1\uffff\uffc1\143",
			"\1\144",
			"\42\145\1\146\uffdd\145",
			"\12\45",
			"\1\71\2\uffff\13\71\6\uffff\13\71\1\147\2\71\1\150\13\71\4"
					+ "\uffff\1\71\1\uffff\21\71\1\151\10\71",
			"\47\152\1\153\uffd8\152",
			"\1\71\2\uffff\13\71\6\uffff\1\71\1\154\30\71\4\uffff\1\71\1" + "\uffff\32\71",
			"\1\71\2\uffff\13\71\6\uffff\7\71\1\155\22\71\4\uffff\1\71\1" + "\uffff\32\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\21\71" + "\1\156\10\71",
			"",
			"\1\71\2\uffff\13\71\6\uffff\4\71\1\157\25\71\4\uffff\1\71\1" + "\uffff\32\71",
			"\1\71\2\uffff\13\71\6\uffff\15\71\1\160\14\71\4\uffff\1\71" + "\1\uffff\32\71",
			"\1\71\2\uffff\13\71\6\uffff\1\161\31\71\4\uffff\1\71\1\uffff" + "\1\162\31\71",
			"\1\71\2\uffff\13\71\6\uffff\1\163\31\71\4\uffff\1\71\1\uffff" + "\32\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\1\164" + "\23\71\1\131\5\71",
			"\1\71\2\uffff\13\71\6\uffff\21\71\1\165\10\71\4\uffff\1\71" + "\1\uffff\32\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\32\71",
			"",
			"",
			"\1\71\2\uffff\13\71\6\uffff\14\71\1\167\1\170\5\71\1\166\6"
					+ "\71\4\uffff\1\71\1\uffff\32\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\15\71" + "\1\171\14\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\5\71" + "\1\172\24\71",
			"",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\32\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\32\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\13\71" + "\1\173\16\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\3\71"
					+ "\1\174\17\71\1\175\6\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\23\71" + "\1\176\6\71",
			"\1\71\2\uffff\13\71\6\uffff\23\71\1\177\6\71\4\uffff\1\71\1" + "\uffff\32\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\23\71" + "\1\u0080\6\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\14\71" + "\1\u0081\15\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\1\71"
					+ "\1\u0082\15\71\1\u0083\12\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\14\71" + "\1\u0084\15\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\14\71" + "\1\u0085\15\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\15\71" + "\1\u0086\14\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\27\71" + "\1\u0087\2\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\1\u0088" + "\31\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\24\71" + "\1\u0089\5\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\13\71" + "\1\u008a\16\71",
			"\1\71\2\uffff\13\71\6\uffff\25\71\1\u008c\4\71\4\uffff\1\71"
					+ "\1\uffff\22\71\1\u008d\2\71\1\u008b\4\71",
			"\1\71\2\uffff\13\71\6\uffff\3\71\1\u008e\21\71\1\u008c\4\71"
					+ "\4\uffff\1\71\1\uffff\25\71\1\u008c\4\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\21\71" + "\1\u008f\10\71",
			"\1\71\2\uffff\13\71\6\uffff\10\71\1\u0090\21\71\4\uffff\1\71" + "\1\uffff\32\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\1\71" + "\1\u0091\30\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\14\71" + "\1\u0092\15\71",
			"\1\71\2\uffff\13\71\6\uffff\13\71\1\u0093\16\71\4\uffff\1\71" + "\1\uffff\32\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\5\71"
					+ "\1\u0094\14\71\1\u0095\7\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\14\71" + "\1\u0096\15\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\5\71"
					+ "\1\u0097\14\71\1\u0098\7\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\14\71" + "\1\u0099\15\71",
			"\1\71\2\uffff\13\71\6\uffff\23\71\1\u009a\6\71\4\uffff\1\71" + "\1\uffff\32\71",
			"\1\71\2\uffff\13\71\6\uffff\25\71\1\u008c\4\71\4\uffff\1\71"
					+ "\1\uffff\22\71\1\u008d\2\71\1\u009b\4\71",
			"\1\71\2\uffff\13\71\6\uffff\25\71\1\u008c\4\71\4\uffff\1\71"
					+ "\1\uffff\25\71\1\u008c\4\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\15\71" + "\1\u009c\14\71",
			"\1\71\2\uffff\13\71\6\uffff\22\71\1\u009d\7\71\4\uffff\1\71"
					+ "\1\uffff\22\71\1\u009d\7\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\15\71" + "\1\u009e\14\71",
			"\1\71\2\uffff\13\71\6\uffff\10\71\1\u009f\21\71\4\uffff\1\71" + "\1\uffff\32\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\10\71" + "\1\u00a0\21\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\23\71" + "\1\175\6\71",
			"\1\71\2\uffff\13\71\6\uffff\15\71\1\u00a1\14\71\4\uffff\1\71" + "\1\uffff\32\71",
			"\1\71\2\uffff\13\71\6\uffff\3\71\1\u00a2\26\71\4\uffff\1\71" + "\1\uffff\32\71",
			"\1\71\2\uffff\13\71\6\uffff\22\71\1\u00a3\7\71\4\uffff\1\71" + "\1\uffff\32\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\1\u00a4" + "\31\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\17\71" + "\1\u00a5\12\71",
			"\76\143\1\u00a6\uffc1\143",
			"\76\143\1\u00a6\uffc1\143",
			"",
			"\42\145\1\146\uffdd\145",
			"\1\u00a7",
			"\1\71\2\uffff\13\71\6\uffff\1\u00a8\31\71\4\uffff\1\71\1\uffff" + "\32\71",
			"\1\71\2\uffff\13\71\6\uffff\15\71\1\u00a9\14\71\4\uffff\1\71" + "\1\uffff\32\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\4\71" + "\1\u00aa\25\71",
			"\47\152\1\153\uffd8\152",
			"\1\u00ab",
			"\1\71\2\uffff\13\71\6\uffff\11\71\1\u00ac\20\71\4\uffff\1\71" + "\1\uffff\32\71",
			"\1\71\2\uffff\13\71\6\uffff\4\71\1\u00ad\25\71\4\uffff\1\71" + "\1\uffff\32\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\4\71" + "\1\u00ae\25\71",
			"\1\71\2\uffff\13\71\6\uffff\6\71\1\u00af\23\71\4\uffff\1\71" + "\1\uffff\32\71",
			"\1\71\2\uffff\13\71\6\uffff\3\71\1\u00b0\26\71\4\uffff\1\71" + "\1\uffff\32\71",
			"\1\71\2\uffff\13\71\6\uffff\23\71\1\u00b1\6\71\4\uffff\1\71" + "\1\uffff\32\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\23\71" + "\1\u00b2\6\71",
			"\1\71\2\uffff\13\71\6\uffff\13\71\1\u00b3\16\71\4\uffff\1\71" + "\1\uffff\32\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\10\71" + "\1\u00b4\21\71",
			"\1\71\2\uffff\13\71\6\uffff\16\71\1\u00b5\13\71\4\uffff\1\71" + "\1\uffff\32\71",
			"\1\71\2\uffff\13\71\6\uffff\24\71\1\u00b6\5\71\4\uffff\1\71" + "\1\uffff\32\71",
			"\1\71\2\uffff\13\71\6\uffff\16\71\1\u00b7\13\71\4\uffff\1\71" + "\1\uffff\32\71",
			"\1\71\2\uffff\13\71\6\uffff\3\71\1\u00b8\26\71\4\uffff\1\71" + "\1\uffff\32\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\6\71" + "\1\u00b9\23\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\13\71" + "\1\u00ba\16\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\30\71" + "\1\u00bb\1\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\32\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\10\71" + "\1\u00bc\21\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\32\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\32\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\32\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\4\71" + "\1\u00bd\25\71",
			"\1\71\2\uffff\13\71\6\uffff\2\71\1\u00be\14\71\1\u00bf\12\71"
					+ "\4\uffff\1\71\1\uffff\32\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\4\71" + "\1\u00c0\25\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\4\71" + "\1\u00c1\25\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\14\71" + "\1\u00c2\15\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\32\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\32\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\2\71" + "\1\u00c3\27\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\10\71" + "\1\u00c4\21\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\24\71" + "\1\u00c5\5\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\4\71" + "\1\u00c6\25\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\32\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\23\71" + "\1\u00c7\6\71",
			"\1\71\2\uffff\13\71\6\uffff\10\71\1\u00c8\21\71\4\uffff\1\71" + "\1\uffff\32\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\4\71" + "\1\u00c9\25\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\32\71",
			"\1\71\2\uffff\13\71\6\uffff\2\71\1\u00be\27\71\4\uffff\1\71" + "\1\uffff\32\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\4\71" + "\1\u00ca\25\71",
			"\1\71\2\uffff\13\71\6\uffff\4\71\1\u00cb\25\71\4\uffff\1\71" + "\1\uffff\32\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\5\71" + "\1\u00cc\24\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\11\71" + "\1\u00cd\20\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\1\u00ce" + "\31\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\5\71" + "\1\u00cf\24\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\11\71" + "\1\u00d0\20\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\1\u00d1" + "\31\71",
			"\1\71\2\uffff\13\71\6\uffff\1\u00d2\31\71\4\uffff\1\71\1\uffff" + "\32\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\4\71" + "\1\u00d3\25\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\6\71" + "\1\u00d4\23\71",
			"\1\71\2\uffff\13\71\6\uffff\12\71\1\u00d5\17\71\4\uffff\1\71"
					+ "\1\uffff\12\71\1\u00d5\17\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\2\71" + "\1\u00d6\27\71",
			"\1\71\2\uffff\13\71\6\uffff\13\71\1\u00d7\16\71\4\uffff\1\71" + "\1\uffff\32\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\13\71" + "\1\u00d8\16\71",
			"\1\71\2\uffff\13\71\6\uffff\16\71\1\u00d9\13\71\4\uffff\1\71" + "\1\uffff\32\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\32\71",
			"\1\71\2\uffff\13\71\6\uffff\4\71\1\u00da\25\71\4\uffff\1\71" + "\1\uffff\32\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\15\71" + "\1\u00db\14\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\4\71" + "\1\u00dc\25\71",
			"",
			"\42\145\1\146\uffdd\145",
			"\1\71\2\uffff\13\71\6\uffff\22\71\1\u00dd\7\71\4\uffff\1\71" + "\1\uffff\32\71",
			"\1\71\2\uffff\13\71\6\uffff\22\71\1\u00de\7\71\4\uffff\1\71" + "\1\uffff\32\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\1\u00df" + "\31\71",
			"\47\152\1\153\uffd8\152",
			"\1\71\2\uffff\13\71\6\uffff\4\71\1\u00e0\25\71\4\uffff\1\71" + "\1\uffff\32\71",
			"\1\71\2\uffff\13\71\6\uffff\21\71\1\u00e1\10\71\4\uffff\1\71" + "\1\uffff\32\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\1\u00e2" + "\31\71",
			"\1\71\2\uffff\13\71\6\uffff\10\71\1\u00e3\21\71\4\uffff\1\71" + "\1\uffff\32\71",
			"\1\71\2\uffff\13\71\1\53\5\uffff\32\71\4\uffff\1\71\1\uffff" + "\32\71",
			"\1\71\2\uffff\13\71\6\uffff\2\71\1\u00e4\27\71\4\uffff\1\71" + "\1\uffff\32\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\2\71" + "\1\u00e5\27\71",
			"\1\71\2\uffff\13\71\6\uffff\24\71\1\u00e6\5\71\4\uffff\1\71" + "\1\uffff\32\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\13\71" + "\1\u00e7\16\71",
			"\1\71\2\uffff\13\71\6\uffff\24\71\1\u00e8\5\71\4\uffff\1\71" + "\1\uffff\32\71",
			"\1\71\2\uffff\13\71\6\uffff\21\71\1\u00e9\10\71\4\uffff\1\71" + "\1\uffff\32\71",
			"\1\71\2\uffff\13\71\6\uffff\25\71\1\u00ea\4\71\4\uffff\1\71" + "\1\uffff\32\71",
			"\1\71\2\uffff\13\71\6\uffff\4\71\1\u00eb\25\71\4\uffff\1\71" + "\1\uffff\32\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\4\71" + "\1\u00ec\25\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\4\71" + "\1\u00ed\25\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\32\71",
			"\1\71\2\uffff\13\71\6\uffff\22\71\1\u00ee\7\71\4\uffff\1\71"
					+ "\1\uffff\22\71\1\u00ee\7\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\32\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\13\71" + "\1\u00ef\16\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\21\71" + "\1\u00f0\10\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\21\71" + "\1\u00f1\10\71",
			"\1\71\2\uffff\13\71\6\uffff\1\u00f2\31\71\4\uffff\1\71\1\uffff" + "\32\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\4\71" + "\1\u00f3\25\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\23\71" + "\1\u00f4\6\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\25\71" + "\1\u00f5\4\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\4\71" + "\1\u00f6\25\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\21\71" + "\1\u00f7\10\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\1\u00f8" + "\31\71",
			"\1\71\2\uffff\13\71\6\uffff\25\71\1\u00f9\4\71\4\uffff\1\71" + "\1\uffff\32\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\5\71" + "\1\u00fa\24\71",
			"\1\71\2\uffff\13\71\6\uffff\1\u00fb\31\71\4\uffff\1\71\1\uffff" + "\32\71",
			"\1\71\2\uffff\13\71\6\uffff\2\71\1\u00fc\27\71\4\uffff\1\71" + "\1\uffff\32\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\4\71" + "\1\u00fd\25\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\16\71" + "\1\u00fe\13\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\10\71" + "\1\u00ff\21\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\4\71" + "\1\u0100\25\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\16\71" + "\1\u0101\13\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\10\71" + "\1\u0102\21\71",
			"\1\71\2\uffff\13\71\6\uffff\17\71\1\u0103\12\71\4\uffff\1\71" + "\1\uffff\32\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\21\71" + "\1\u0104\10\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\4\71" + "\1\u0105\25\71",
			"\1\71\2\uffff\13\71\6\uffff\4\71\1\u0106\25\71\4\uffff\1\71"
					+ "\1\uffff\4\71\1\u0106\25\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\23\71" + "\1\u0107\6\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\32\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\32\71",
			"\1\71\2\uffff\13\71\6\uffff\23\71\1\u0108\6\71\4\uffff\1\71" + "\1\uffff\32\71",
			"\1\71\2\uffff\13\71\6\uffff\21\71\1\u0109\10\71\4\uffff\1\71" + "\1\uffff\32\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\22\71" + "\1\u010a\7\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\22\71" + "\1\u010b\7\71",
			"\1\71\2\uffff\13\71\6\uffff\22\71\1\u010c\7\71\4\uffff\1\71" + "\1\uffff\32\71",
			"\1\71\2\uffff\13\71\6\uffff\23\71\1\u010d\6\71\4\uffff\1\71" + "\1\uffff\32\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\23\71" + "\1\u010e\6\71",
			"\1\71\2\uffff\13\71\6\uffff\2\71\1\u010f\27\71\4\uffff\1\71" + "\1\uffff\32\71",
			"\1\71\2\uffff\13\71\6\uffff\4\71\1\u0110\25\71\4\uffff\1\71" + "\1\uffff\32\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\23\71" + "\1\u0111\6\71",
			"\1\71\2\uffff\13\71\6\uffff\15\71\1\u0112\14\71\4\uffff\1\71" + "\1\uffff\32\71",
			"\1\71\2\uffff\13\71\6\uffff\7\71\1\u0113\22\71\4\uffff\1\71" + "\1\uffff\32\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\7\71" + "\1\u0114\22\71",
			"\1\71\2\uffff\13\71\6\uffff\4\71\1\u0115\25\71\4\uffff\1\71" + "\1\uffff\32\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\32\71",
			"\1\71\2\uffff\13\71\6\uffff\17\71\1\u0116\12\71\4\uffff\1\71" + "\1\uffff\32\71",
			"\1\71\2\uffff\13\71\6\uffff\15\71\1\u0117\14\71\4\uffff\1\71" + "\1\uffff\32\71",
			"\1\71\2\uffff\13\71\6\uffff\4\71\1\u0118\25\71\4\uffff\1\71" + "\1\uffff\32\71",
			"\1\71\2\uffff\13\71\6\uffff\21\71\1\u0119\10\71\4\uffff\1\71" + "\1\uffff\32\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\32\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\27\71" + "\1\u011a\2\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\30\71" + "\1\u011b\1\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\1\u011c" + "\31\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\16\71" + "\1\u011d\13\71",
			"\1\71\2\uffff\13\71\6\uffff\2\71\1\u011e\14\71\1\u011f\12\71"
					+ "\4\uffff\1\71\1\uffff\32\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\22\71" + "\1\u0120\7\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\23\71" + "\1\u0121\6\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\13\71" + "\1\u0122\16\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\1\u0123" + "\31\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\32\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\22\71" + "\1\u0124\7\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\15\71" + "\1\u0125\14\71",
			"\1\71\2\uffff\13\71\6\uffff\10\71\1\u0126\21\71\4\uffff\1\71" + "\1\uffff\32\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\13\71" + "\1\u0127\16\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\22\71" + "\1\u0128\7\71",
			"\1\71\2\uffff\13\71\6\uffff\23\71\1\u0129\6\71\4\uffff\1\71" + "\1\uffff\32\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\21\71" + "\1\u012a\10\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\10\71" + "\1\u012b\21\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\15\71" + "\1\u012c\14\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\21\71" + "\1\u012d\10\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\10\71" + "\1\u012e\21\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\15\71" + "\1\u012f\14\71",
			"\1\71\2\uffff\13\71\6\uffff\21\71\1\u0130\10\71\4\uffff\1\71" + "\1\uffff\32\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\22\71" + "\1\u0131\7\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\32\71",
			"\1\71\2\uffff\13\71\6\uffff\30\71\1\u0132\1\71\4\uffff\1\71"
					+ "\1\uffff\30\71\1\u0132\1\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\10\71" + "\1\u0133\21\71",
			"\1\71\2\uffff\13\71\6\uffff\1\u0134\31\71\4\uffff\1\71\1\uffff" + "\32\71",
			"\1\71\2\uffff\13\71\6\uffff\23\71\1\u0135\6\71\4\uffff\1\71" + "\1\uffff\32\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\10\71" + "\1\u0136\21\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\32\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\32\71",
			"\1\71\2\uffff\13\71\6\uffff\1\u0137\31\71\4\uffff\1\71\1\uffff" + "\32\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\4\71" + "\1\u0138\25\71",
			"\1\71\2\uffff\13\71\6\uffff\23\71\1\u0139\6\71\4\uffff\1\71" + "\1\uffff\32\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\32\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\4\71" + "\1\u013a\25\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\32\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\32\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\32\71",
			"\1\71\2\uffff\13\71\6\uffff\22\71\1\u013b\7\71\4\uffff\1\71" + "\1\uffff\32\71",
			"\1\71\2\uffff\13\71\6\uffff\22\71\1\u013c\7\71\4\uffff\1\71" + "\1\uffff\32\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\32\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\32\71",
			"\1\71\2\uffff\13\71\6\uffff\10\71\1\u013e\21\71\4\uffff\1\71" + "\1\uffff\32\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\10\71" + "\1\u013f\21\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\14\71" + "\1\u0140\15\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\22\71" + "\1\u0141\7\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\17\71" + "\1\u0142\12\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\13\71" + "\1\u0143\16\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\21\71" + "\1\u0144\10\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\32\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\21\71" + "\1\u0145\10\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\30\71" + "\1\u0146\1\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\13\71" + "\1\u0147\16\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\4\71" + "\1\u0148\25\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\2\71" + "\1\u0149\27\71",
			"\1\71\2\uffff\13\71\6\uffff\3\71\1\u014a\26\71\4\uffff\1\71" + "\1\uffff\32\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\4\71" + "\1\u014b\25\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\32\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\32\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\4\71" + "\1\u014c\25\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\15\71" + "\1\u014d\14\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\32\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\4\71" + "\1\u014e\25\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\15\71" + "\1\u014f\14\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\32\71",
			"\1\71\2\uffff\13\71\6\uffff\16\71\1\u0150\13\71\4\uffff\1\71" + "\1\uffff\32\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\4\71" + "\1\u0151\25\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\32\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\16\71" + "\1\u0152\13\71",
			"\1\71\2\uffff\13\71\6\uffff\23\71\1\u0153\6\71\4\uffff\1\71" + "\1\uffff\32\71",
			"\1\71\2\uffff\13\71\6\uffff\4\71\1\u0154\25\71\4\uffff\1\71" + "\1\uffff\32\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\23\71" + "\1\u0155\6\71",
			"\1\71\2\uffff\13\71\6\uffff\15\71\1\u0156\14\71\4\uffff\1\71" + "\1\uffff\32\71",
			"\1\71\2\uffff\13\71\6\uffff\10\71\1\u0157\13\71\1\u0158\5\71"
					+ "\4\uffff\1\71\1\uffff\32\71",
			"\1\71\2\uffff\13\71\6\uffff\17\71\1\u0159\12\71\4\uffff\1\71" + "\1\uffff\32\71",
			"\1\71\2\uffff\13\71\6\uffff\10\71\1\u015a\13\71\1\u015b\5\71"
					+ "\4\uffff\1\71\1\uffff\32\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\32\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\32\71",
			"",
			"\1\71\2\uffff\13\71\6\uffff\15\71\1\u015c\14\71\4\uffff\1\71" + "\1\uffff\32\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\25\71" + "\1\u015d\4\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\14\71" + "\1\u015e\15\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\22\71" + "\1\u015f\7\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\4\71" + "\1\u0160\25\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\1\u0161" + "\31\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\16\71" + "\1\u0162\13\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\10\71" + "\1\u0163\21\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\32\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\4\71" + "\1\u0164\25\71",
			"\1\71\2\uffff\13\71\6\uffff\5\71\1\u0166\10\71\1\u0165\13\71"
					+ "\4\uffff\1\71\1\uffff\5\71\1\u0166\24\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\4\71" + "\1\u0167\25\71",
			"\1\71\2\uffff\13\71\6\uffff\24\71\1\u0168\5\71\4\uffff\1\71" + "\1\uffff\32\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\27\71" + "\1\u0169\2\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\15\71" + "\1\u016a\14\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\23\71" + "\1\u016b\6\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\15\71" + "\1\u016c\14\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\23\71" + "\1\u016d\6\71",
			"\1\71\2\uffff\13\71\6\uffff\17\71\1\u016e\12\71\4\uffff\1\71" + "\1\uffff\32\71",
			"\1\71\2\uffff\13\71\6\uffff\5\71\1\u0166\10\71\1\u016f\13\71"
					+ "\4\uffff\1\71\1\uffff\5\71\1\u0166\24\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\15\71" + "\1\u0170\14\71",
			"\1\71\2\uffff\13\71\6\uffff\10\71\1\u0171\21\71\4\uffff\1\71" + "\1\uffff\32\71",
			"\1\71\2\uffff\13\71\6\uffff\3\71\1\u0172\26\71\4\uffff\1\71" + "\1\uffff\32\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\10\71" + "\1\u0173\21\71",
			"\1\71\2\uffff\13\71\6\uffff\23\71\1\u0174\6\71\4\uffff\1\71" + "\1\uffff\32\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\15\71" + "\1\u0175\14\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\15\71" + "\1\u0176\14\71",
			"\1\71\2\uffff\13\71\6\uffff\21\71\1\u0177\10\71\4\uffff\1\71" + "\1\uffff\32\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\15\71" + "\1\u0178\14\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\15\71" + "\1\u0179\14\71",
			"\1\71\2\uffff\13\71\6\uffff\6\71\1\u017a\23\71\4\uffff\1\71" + "\1\uffff\32\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\4\71" + "\1\u017b\25\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\4\71" + "\1\u017c\25\71",
			"\1\71\2\uffff\13\71\6\uffff\16\71\1\u017d\13\71\4\uffff\1\71" + "\1\uffff\32\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\21\71" + "\1\u017e\10\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\22\71" + "\1\u017f\7\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\17\71" + "\1\u0180\12\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\2\71" + "\1\u0181\27\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\15\71" + "\1\u0182\14\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\5\71" + "\1\u0183\24\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\24\71" + "\1\u0184\5\71",
			"\1\71\2\uffff\13\71\6\uffff\16\71\1\u0185\13\71\4\uffff\1\71"
					+ "\1\uffff\16\71\1\u0185\13\71",
			"\1\71\2\uffff\13\71\6\uffff\1\u0186\31\71\4\uffff\1\71\1\uffff" + "\32\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\10\71" + "\1\u0187\21\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\23\71" + "\1\u0188\6\71",
			"\1\71\2\uffff\13\71\6\uffff\26\71\1\u0189\3\71\4\uffff\1\71" + "\1\uffff\32\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\23\71" + "\1\u018a\6\71",
			"\1\71\2\uffff\13\71\6\uffff\26\71\1\u018b\3\71\4\uffff\1\71" + "\1\uffff\32\71",
			"\1\71\2\uffff\13\71\6\uffff\4\71\1\u018c\25\71\4\uffff\1\71" + "\1\uffff\32\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\5\71" + "\1\u018d\24\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\1\u018e" + "\31\71",
			"\1\71\2\uffff\13\71\6\uffff\16\71\1\u018f\13\71\4\uffff\1\71" + "\1\uffff\32\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\32\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\25\71" + "\1\u0190\4\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\32\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\23\71" + "\1\u0191\6\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\10\71" + "\1\u0192\21\71",
			"\1\71\2\uffff\13\71\6\uffff\16\71\1\u0193\13\71\4\uffff\1\71" + "\1\uffff\32\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\23\71" + "\1\u0194\6\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\10\71" + "\1\u0195\21\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\32\71",
			"\1\71\2\uffff\12\71\1\u0196\6\uffff\32\71\4\uffff\1\71\1\uffff" + "\32\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\23\71" + "\1\u0197\6\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\5\71" + "\1\u0198\24\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\23\71" + "\1\u0199\6\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\22\71" + "\1\u019a\7\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\4\71" + "\1\u019b\25\71",
			"\1\71\2\uffff\12\71\1\u019c\6\uffff\32\71\4\uffff\1\71\1\uffff" + "\32\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\23\71" + "\1\u019d\6\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\32\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\15\71" + "\1\u019e\14\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\5\71" + "\1\u019f\24\71",
			"\1\71\2\uffff\13\71\6\uffff\13\71\1\u01a0\16\71\4\uffff\1\71" + "\1\uffff\32\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\25\71" + "\1\u01a1\4\71",
			"\1\71\2\uffff\13\71\6\uffff\5\71\1\u01a2\24\71\4\uffff\1\71" + "\1\uffff\32\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\10\71" + "\1\u01a3\21\71",
			"\1\71\2\uffff\13\71\6\uffff\5\71\1\u01a4\24\71\4\uffff\1\71" + "\1\uffff\32\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\10\71" + "\1\u01a5\21\71",
			"\1\71\2\uffff\13\71\6\uffff\21\71\1\u01a6\10\71\4\uffff\1\71" + "\1\uffff\32\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\32\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\13\71" + "\1\u01a7\16\71",
			"\1\71\2\uffff\13\71\6\uffff\15\71\1\u01a8\14\71\4\uffff\1\71" + "\1\uffff\32\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\4\71" + "\1\u01a9\25\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\4\71" + "\1\u01aa\25\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\16\71" + "\1\u01ab\13\71",
			"\1\71\2\uffff\13\71\6\uffff\17\71\1\u01ac\12\71\4\uffff\1\71" + "\1\uffff\32\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\4\71" + "\1\u01ad\25\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\16\71" + "\1\u01ae\13\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\32\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\21\71" + "\1\u01af\10\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\32\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\30\71" + "\1\u01b0\1\71",
			"\1\71\2\uffff\13\71\6\uffff\16\71\1\u01b1\13\71\4\uffff\1\71" + "\1\uffff\32\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\21\71" + "\1\u01b2\10\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\32\71",
			"\1\71\2\uffff\13\71\6\uffff\23\71\1\u01b3\6\71\4\uffff\1\71" + "\1\uffff\32\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\2\71" + "\1\u01b4\27\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\32\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\32\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\4\71" + "\1\u01b5\25\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\21\71" + "\1\u01b6\10\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\23\71" + "\1\u01b7\6\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\21\71" + "\1\u01b8\10\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\23\71" + "\1\u01b9\6\71",
			"\1\71\2\uffff\13\71\6\uffff\23\71\1\u01ba\6\71\4\uffff\1\71" + "\1\uffff\32\71",
			"\1\71\2\uffff\12\71\1\u01bb\6\uffff\32\71\4\uffff\1\71\1\uffff" + "\32\71",
			"\1\71\2\uffff\13\71\6\uffff\17\71\1\u01bc\12\71\4\uffff\1\71" + "\1\uffff\32\71",
			"\1\71\2\uffff\12\71\1\u01bd\6\uffff\32\71\4\uffff\1\71\1\uffff" + "\32\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\21\71" + "\1\u01be\10\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\15\71" + "\1\u01bf\14\71",
			"\1\71\2\uffff\13\71\6\uffff\4\71\1\u01c0\25\71\4\uffff\1\71" + "\1\uffff\32\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\21\71" + "\1\u01c1\10\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\15\71" + "\1\u01c2\14\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\10\71" + "\1\u01c3\21\71",
			"\1\71\2\uffff\13\71\6\uffff\16\71\1\u01c4\13\71\4\uffff\1\71" + "\1\uffff\32\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\5\71" + "\1\u01c5\24\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\23\71" + "\1\u01c6\6\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\16\71" + "\1\u01c7\13\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\23\71" + "\1\u01c8\6\71",
			"\1\71\2\uffff\12\71\1\u01c9\6\uffff\32\71\4\uffff\1\71\1\uffff" + "\32\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\16\71" + "\1\u01ca\13\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\7\71" + "\1\u01cb\22\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\16\71" + "\1\u01cc\13\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\7\71" + "\1\u01cd\22\71",
			"\1\71\2\uffff\13\71\6\uffff\30\71\1\u01ce\1\71\4\uffff\1\71" + "\1\uffff\32\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\32\71",
			"\1\71\2\uffff\13\71\6\uffff\21\71\1\u01cf\10\71\4\uffff\1\71" + "\1\uffff\32\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\32\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\22\71" + "\1\u01d0\7\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\32\71",
			"\1\71\2\uffff\13\71\6\uffff\21\71\1\u01d1\10\71\4\uffff\1\71" + "\1\uffff\32\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\22\71" + "\1\u01d2\7\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\32\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\2\71" + "\1\u01d3\27\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\5\71" + "\1\u01d4\24\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\32\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\30\71" + "\1\u01d5\1\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\32\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\10\71" + "\1\u01d6\21\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\32\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\14\71" + "\1\u01d7\15\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\32\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\14\71" + "\1\u01d8\15\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\32\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\32\71",
			"\1\71\2\uffff\13\71\6\uffff\16\71\1\u01d9\13\71\4\uffff\1\71" + "\1\uffff\32\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\4\71" + "\1\u01da\25\71",
			"\1\71\2\uffff\13\71\6\uffff\23\71\1\u01db\6\71\4\uffff\1\71" + "\1\uffff\32\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\4\71" + "\1\u01dc\25\71",
			"\1\71\2\uffff\12\71\1\u01dd\6\uffff\32\71\4\uffff\1\71\1\uffff" + "\32\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\32\71",
			"\1\71\2\uffff\13\71\6\uffff\16\71\1\u01de\13\71\4\uffff\1\71" + "\1\uffff\32\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\16\71" + "\1\u01df\13\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\32\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\32\71",
			"\1\71\2\uffff\13\71\6\uffff\17\71\1\u01e0\12\71\4\uffff\1\71" + "\1\uffff\32\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\2\71" + "\1\u01e1\27\71",
			"\1\71\2\uffff\13\71\6\uffff\30\71\1\u01e2\1\71\4\uffff\1\71" + "\1\uffff\32\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\2\71" + "\1\u01e3\27\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\32\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\5\71" + "\1\u01e4\24\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\15\71" + "\1\u01e5\14\71",
			"\1\71\2\uffff\13\71\6\uffff\4\71\1\u01e6\25\71\4\uffff\1\71" + "\1\uffff\32\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\23\71" + "\1\u01e7\6\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\32\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\23\71" + "\1\u01e8\6\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\32\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\1\u01e9" + "\31\71",
			"\1\71\2\uffff\13\71\6\uffff\21\71\1\u01ea\10\71\4\uffff\1\71" + "\1\uffff\32\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\10\71" + "\1\u01eb\21\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\10\71" + "\1\u01ec\21\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\13\71" + "\1\u01ed\16\71",
			"\1\71\2\uffff\13\71\6\uffff\23\71\1\u01ee\6\71\4\uffff\1\71" + "\1\uffff\32\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\16\71" + "\1\u01ef\13\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\16\71" + "\1\u01f0\13\71",
			"\1\71\2\uffff\12\71\1\u01f1\6\uffff\32\71\4\uffff\1\71\1\uffff" + "\32\71",
			"\1\71\2\uffff\13\71\6\uffff\30\71\1\u01f2\1\71\4\uffff\1\71" + "\1\uffff\32\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\15\71" + "\1\u01f3\14\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\15\71" + "\1\u01f4\14\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\32\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\32\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\32\71",
			"\1\71\2\uffff\13\71\6\uffff\32\71\4\uffff\1\71\1\uffff\32\71" };
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
			return "1:1: Tokens : ( THIS_CLASS | DOLLAR | RETURN | SEMICOLON | HYPHEN | MOWLLexer. Tokens | OPPLLexer. Tokens );";
		}

		@Override
		public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
			IntStream input = _input;
			int _s = s;
			switch (s) {
			case 0:
				int LA1_171 = input.LA(1);
				s = -1;
				if (LA1_171 == '\'') {
					s = 107;
				} else if (LA1_171 >= '\u0000' && LA1_171 <= '&' || LA1_171 >= '('
						&& LA1_171 <= '\uFFFF') {
					s = 106;
				}
				if (s >= 0) {
					return s;
				}
				break;
			case 1:
				int LA1_39 = input.LA(1);
				s = -1;
				if (LA1_39 >= '\u0000' && LA1_39 <= '&' || LA1_39 >= '(' && LA1_39 <= '\uFFFF') {
					s = 106;
				} else if (LA1_39 == '\'') {
					s = 107;
				}
				if (s >= 0) {
					return s;
				}
				break;
			case 2:
				int LA1_106 = input.LA(1);
				s = -1;
				if (LA1_106 == '\'') {
					s = 107;
				} else if (LA1_106 >= '\u0000' && LA1_106 <= '&' || LA1_106 >= '('
						&& LA1_106 <= '\uFFFF') {
					s = 106;
				}
				if (s >= 0) {
					return s;
				}
				break;
			case 3:
				int LA1_36 = input.LA(1);
				s = -1;
				if (LA1_36 >= '\u0000' && LA1_36 <= '!' || LA1_36 >= '#' && LA1_36 <= '\uFFFF') {
					s = 101;
				} else if (LA1_36 == '\"') {
					s = 102;
				}
				if (s >= 0) {
					return s;
				}
				break;
			case 4:
				int LA1_34 = input.LA(1);
				s = -1;
				if (LA1_34 == '=') {
					s = 98;
				} else if (LA1_34 >= '\u0000' && LA1_34 <= '<' || LA1_34 >= '?'
						&& LA1_34 <= '\uFFFF') {
					s = 99;
				} else {
					s = 56;
				}
				if (s >= 0) {
					return s;
				}
				break;
			case 5:
				int LA1_99 = input.LA(1);
				s = -1;
				if (LA1_99 == '>') {
					s = 166;
				} else if (LA1_99 >= '\u0000' && LA1_99 <= '=' || LA1_99 >= '?'
						&& LA1_99 <= '\uFFFF') {
					s = 99;
				}
				if (s >= 0) {
					return s;
				}
				break;
			case 6:
				int LA1_167 = input.LA(1);
				s = -1;
				if (LA1_167 == '\"') {
					s = 102;
				} else if (LA1_167 >= '\u0000' && LA1_167 <= '!' || LA1_167 >= '#'
						&& LA1_167 <= '\uFFFF') {
					s = 101;
				}
				if (s >= 0) {
					return s;
				}
				break;
			case 7:
				int LA1_98 = input.LA(1);
				s = -1;
				if (LA1_98 == '>') {
					s = 166;
				} else if (LA1_98 >= '\u0000' && LA1_98 <= '=' || LA1_98 >= '?'
						&& LA1_98 <= '\uFFFF') {
					s = 99;
				} else {
					s = 56;
				}
				if (s >= 0) {
					return s;
				}
				break;
			case 8:
				int LA1_101 = input.LA(1);
				s = -1;
				if (LA1_101 == '\"') {
					s = 102;
				} else if (LA1_101 >= '\u0000' && LA1_101 <= '!' || LA1_101 >= '#'
						&& LA1_101 <= '\uFFFF') {
					s = 101;
				}
				if (s >= 0) {
					return s;
				}
				break;
			}
			NoViableAltException nvae = new NoViableAltException(this.getDescription(), 1, _s,
					input);
			this.error(nvae);
			throw nvae;
		}
	}
}