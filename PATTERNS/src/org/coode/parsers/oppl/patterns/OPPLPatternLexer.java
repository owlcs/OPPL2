package org.coode.parsers.oppl.patterns;

// $ANTLR 3.2 Sep 23, 2009 12:02:23 /Users/luigi/Documents/workspace/Parsers/src/OPPLPatternLexer.g 2010-11-22 10:25:29
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
	static final String DFA1_eotS = "\1\uffff\1\63\1\67\2\uffff\1\67\5\uffff\21\67\5\uffff\2\67\1\uffff"
			+ "\2\67\1\uffff\3\67\1\uffff\7\67\2\uffff\3\67\1\uffff\52\67\3\uffff"
			+ "\4\67\1\uffff\73\67\2\uffff\3\67\1\uffff\153\67\1\u013c\45\67\1" + "\uffff\u00b7\67";
	static final String DFA1_eofS = "\u01f4\uffff";
	static final String DFA1_minS = "\1\11\1\164\1\55\2\uffff\1\55\5\uffff\21\55\5\uffff\1\0\1\75\1\0"
			+ "\1\60\1\55\1\0\3\55\1\uffff\7\55\2\uffff\3\55\1\uffff\51\55\2\0"
			+ "\1\uffff\1\0\1\42\3\55\1\0\1\47\72\55\1\uffff\1\0\3\55\1\0\u0091"
			+ "\55\1\uffff\u00b7\55";
	static final String DFA1_maxS = "\1\175\1\164\1\172\2\uffff\1\172\5\uffff\21\172\5\uffff\1\uffff"
			+ "\1\75\1\uffff\1\71\1\172\1\uffff\3\172\1\uffff\7\172\2\uffff\3\172"
			+ "\1\uffff\51\172\2\uffff\1\uffff\1\uffff\1\42\3\172\1\uffff\1\47"
			+ "\72\172\1\uffff\1\uffff\3\172\1\uffff\u0091\172\1\uffff\u00b7\172";
	static final String DFA1_acceptS = "\3\uffff\1\4\1\5\1\uffff\5\6\21\uffff\5\6\11\uffff\1\7\7\uffff\1"
			+ "\1\1\2\3\uffff\1\6\53\uffff\1\6\101\uffff\1\6\u0096\uffff\1\3\u00b7" + "\uffff";
	static final String DFA1_specialS = "\41\uffff\1\1\1\uffff\1\5\2\uffff\1\3\72\uffff\1\7\1\10\1\uffff"
			+ "\1\4\4\uffff\1\2\74\uffff\1\0\3\uffff\1\6\u0149\uffff}>";
	static final String[] DFA1_transitionS = {
			"\2\12\2\uffff\1\12\22\uffff\1\12\1\52\1\43\1\uffff\1\1\2\uffff"
					+ "\1\46\1\6\1\11\1\uffff\1\52\1\35\1\4\1\52\1\uffff\12\44\1\52"
					+ "\1\3\1\41\1\40\1\42\1\52\1\uffff\1\32\1\53\1\45\1\25\1\54\1"
					+ "\31\1\60\1\30\1\22\3\61\1\55\1\15\1\47\2\61\1\2\1\23\1\33\1"
					+ "\61\1\56\1\50\3\61\1\36\1\uffff\1\37\1\34\2\uffff\1\13\1\61"
					+ "\1\51\1\24\1\20\1\57\1\61\1\30\1\26\3\61\1\17\1\14\1\5\2\61"
					+ "\1\27\1\16\1\33\1\61\1\21\4\61\1\7\1\uffff\1\10",
			"\1\62",
			"\1\70\2\uffff\13\70\6\uffff\4\70\1\64\25\70\4\uffff\1\70\1"
					+ "\uffff\1\65\3\70\1\66\25\70",
			"",
			"",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\15\70"
					+ "\1\72\3\70\1\71\10\70",
			"",
			"",
			"",
			"",
			"",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\15\70" + "\1\73\14\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\16\70" + "\1\74\13\70",
			"\1\70\2\uffff\13\70\6\uffff\16\70\1\75\13\70\4\uffff\1\70\1"
					+ "\uffff\16\70\1\76\13\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\1\101"
					+ "\15\70\1\77\5\70\1\100\3\70\1\102\1\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\1\104" + "\7\70\1\103\21\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\20\70"
					+ "\1\106\6\70\1\105\2\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\1\107" + "\31\70",
			"\1\70\2\uffff\13\70\6\uffff\15\70\1\111\3\70\1\113\10\70\4"
					+ "\uffff\1\70\1\uffff\15\70\1\110\3\70\1\112\10\70",
			"\1\70\2\uffff\13\70\6\uffff\4\70\1\116\25\70\4\uffff\1\70\1"
					+ "\uffff\1\115\23\70\1\114\3\70\1\102\1\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\10\70"
					+ "\1\117\5\70\1\120\13\70",
			"\1\70\2\uffff\13\70\6\uffff\1\123\31\70\4\uffff\1\70\1\uffff"
					+ "\10\70\1\121\5\70\1\122\13\70",
			"\1\70\2\uffff\13\70\6\uffff\15\70\1\125\14\70\4\uffff\1\70"
					+ "\1\uffff\15\70\1\124\3\70\1\112\10\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\1\126" + "\3\70\1\66\25\70",
			"\1\70\2\uffff\13\70\6\uffff\1\127\31\70\4\uffff\1\70\1\uffff" + "\1\127\31\70",
			"\1\70\2\uffff\13\70\6\uffff\1\131\31\70\4\uffff\1\70\1\uffff"
					+ "\1\132\23\70\1\130\5\70",
			"\1\70\2\uffff\13\70\6\uffff\3\70\1\135\11\70\1\134\4\70\1\136"
					+ "\7\70\4\uffff\1\70\1\uffff\15\70\1\133\14\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\21\70"
					+ "\1\137\6\70\1\140\1\70",
			"",
			"",
			"",
			"",
			"",
			"\75\142\1\141\1\uffff\uffc1\142",
			"\1\143",
			"\42\144\1\145\uffdd\144",
			"\12\44",
			"\1\70\2\uffff\13\70\6\uffff\13\70\1\146\2\70\1\147\13\70\4"
					+ "\uffff\1\70\1\uffff\21\70\1\150\10\70",
			"\47\151\1\152\uffd8\151",
			"\1\70\2\uffff\13\70\6\uffff\1\70\1\153\30\70\4\uffff\1\70\1" + "\uffff\32\70",
			"\1\70\2\uffff\13\70\6\uffff\7\70\1\154\22\70\4\uffff\1\70\1" + "\uffff\32\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\21\70" + "\1\155\10\70",
			"",
			"\1\70\2\uffff\13\70\6\uffff\4\70\1\156\25\70\4\uffff\1\70\1" + "\uffff\32\70",
			"\1\70\2\uffff\13\70\6\uffff\15\70\1\157\14\70\4\uffff\1\70" + "\1\uffff\32\70",
			"\1\70\2\uffff\13\70\6\uffff\1\160\31\70\4\uffff\1\70\1\uffff" + "\1\161\31\70",
			"\1\70\2\uffff\13\70\6\uffff\1\162\31\70\4\uffff\1\70\1\uffff" + "\32\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\1\163" + "\23\70\1\130\5\70",
			"\1\70\2\uffff\13\70\6\uffff\21\70\1\164\10\70\4\uffff\1\70" + "\1\uffff\32\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
			"",
			"",
			"\1\70\2\uffff\13\70\6\uffff\14\70\1\166\1\167\5\70\1\165\6"
					+ "\70\4\uffff\1\70\1\uffff\32\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\15\70" + "\1\170\14\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\5\70" + "\1\171\24\70",
			"",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\13\70" + "\1\172\16\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\3\70"
					+ "\1\173\17\70\1\174\6\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\23\70" + "\1\175\6\70",
			"\1\70\2\uffff\13\70\6\uffff\23\70\1\176\6\70\4\uffff\1\70\1" + "\uffff\32\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\23\70" + "\1\177\6\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\14\70" + "\1\u0080\15\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\1\70"
					+ "\1\u0081\15\70\1\u0082\12\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\14\70" + "\1\u0083\15\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\14\70" + "\1\u0084\15\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\15\70" + "\1\u0085\14\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\27\70" + "\1\u0086\2\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\1\u0087" + "\31\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\24\70" + "\1\u0088\5\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\13\70" + "\1\u0089\16\70",
			"\1\70\2\uffff\13\70\6\uffff\25\70\1\u008b\4\70\4\uffff\1\70"
					+ "\1\uffff\22\70\1\u008c\2\70\1\u008a\4\70",
			"\1\70\2\uffff\13\70\6\uffff\3\70\1\u008d\21\70\1\u008b\4\70"
					+ "\4\uffff\1\70\1\uffff\25\70\1\u008b\4\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\21\70" + "\1\u008e\10\70",
			"\1\70\2\uffff\13\70\6\uffff\10\70\1\u008f\21\70\4\uffff\1\70" + "\1\uffff\32\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\1\70" + "\1\u0090\30\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\14\70" + "\1\u0091\15\70",
			"\1\70\2\uffff\13\70\6\uffff\13\70\1\u0092\16\70\4\uffff\1\70" + "\1\uffff\32\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\5\70"
					+ "\1\u0093\14\70\1\u0094\7\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\14\70" + "\1\u0095\15\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\5\70"
					+ "\1\u0096\14\70\1\u0097\7\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\14\70" + "\1\u0098\15\70",
			"\1\70\2\uffff\13\70\6\uffff\23\70\1\u0099\6\70\4\uffff\1\70" + "\1\uffff\32\70",
			"\1\70\2\uffff\13\70\6\uffff\25\70\1\u008b\4\70\4\uffff\1\70"
					+ "\1\uffff\22\70\1\u008c\2\70\1\u009a\4\70",
			"\1\70\2\uffff\13\70\6\uffff\25\70\1\u008b\4\70\4\uffff\1\70"
					+ "\1\uffff\25\70\1\u008b\4\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\15\70" + "\1\u009b\14\70",
			"\1\70\2\uffff\13\70\6\uffff\22\70\1\u009c\7\70\4\uffff\1\70"
					+ "\1\uffff\22\70\1\u009c\7\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\15\70" + "\1\u009d\14\70",
			"\1\70\2\uffff\13\70\6\uffff\10\70\1\u009e\21\70\4\uffff\1\70" + "\1\uffff\32\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\10\70" + "\1\u009f\21\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\23\70" + "\1\174\6\70",
			"\1\70\2\uffff\13\70\6\uffff\15\70\1\u00a0\14\70\4\uffff\1\70" + "\1\uffff\32\70",
			"\1\70\2\uffff\13\70\6\uffff\3\70\1\u00a1\26\70\4\uffff\1\70" + "\1\uffff\32\70",
			"\1\70\2\uffff\13\70\6\uffff\22\70\1\u00a2\7\70\4\uffff\1\70" + "\1\uffff\32\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\1\u00a3" + "\31\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\17\70" + "\1\u00a4\12\70",
			"\76\142\1\u00a5\uffc1\142",
			"\76\142\1\u00a5\uffc1\142",
			"",
			"\42\144\1\145\uffdd\144",
			"\1\u00a6",
			"\1\70\2\uffff\13\70\6\uffff\1\u00a7\31\70\4\uffff\1\70\1\uffff" + "\32\70",
			"\1\70\2\uffff\13\70\6\uffff\15\70\1\u00a8\14\70\4\uffff\1\70" + "\1\uffff\32\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\4\70" + "\1\u00a9\25\70",
			"\47\151\1\152\uffd8\151",
			"\1\u00aa",
			"\1\70\2\uffff\13\70\6\uffff\11\70\1\u00ab\20\70\4\uffff\1\70" + "\1\uffff\32\70",
			"\1\70\2\uffff\13\70\6\uffff\4\70\1\u00ac\25\70\4\uffff\1\70" + "\1\uffff\32\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\4\70" + "\1\u00ad\25\70",
			"\1\70\2\uffff\13\70\6\uffff\6\70\1\u00ae\23\70\4\uffff\1\70" + "\1\uffff\32\70",
			"\1\70\2\uffff\13\70\6\uffff\3\70\1\u00af\26\70\4\uffff\1\70" + "\1\uffff\32\70",
			"\1\70\2\uffff\13\70\6\uffff\23\70\1\u00b0\6\70\4\uffff\1\70" + "\1\uffff\32\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\23\70" + "\1\u00b1\6\70",
			"\1\70\2\uffff\13\70\6\uffff\13\70\1\u00b2\16\70\4\uffff\1\70" + "\1\uffff\32\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\10\70" + "\1\u00b3\21\70",
			"\1\70\2\uffff\13\70\6\uffff\16\70\1\u00b4\13\70\4\uffff\1\70" + "\1\uffff\32\70",
			"\1\70\2\uffff\13\70\6\uffff\24\70\1\u00b5\5\70\4\uffff\1\70" + "\1\uffff\32\70",
			"\1\70\2\uffff\13\70\6\uffff\16\70\1\u00b6\13\70\4\uffff\1\70" + "\1\uffff\32\70",
			"\1\70\2\uffff\13\70\6\uffff\3\70\1\u00b7\26\70\4\uffff\1\70" + "\1\uffff\32\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\6\70" + "\1\u00b8\23\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\13\70" + "\1\u00b9\16\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\30\70" + "\1\u00ba\1\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\10\70" + "\1\u00bb\21\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\4\70" + "\1\u00bc\25\70",
			"\1\70\2\uffff\13\70\6\uffff\2\70\1\u00bd\14\70\1\u00be\12\70"
					+ "\4\uffff\1\70\1\uffff\32\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\4\70" + "\1\u00bf\25\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\4\70" + "\1\u00c0\25\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\14\70" + "\1\u00c1\15\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\2\70" + "\1\u00c2\27\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\10\70" + "\1\u00c3\21\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\24\70" + "\1\u00c4\5\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\4\70" + "\1\u00c5\25\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\23\70" + "\1\u00c6\6\70",
			"\1\70\2\uffff\13\70\6\uffff\10\70\1\u00c7\21\70\4\uffff\1\70" + "\1\uffff\32\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\4\70" + "\1\u00c8\25\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
			"\1\70\2\uffff\13\70\6\uffff\2\70\1\u00bd\27\70\4\uffff\1\70" + "\1\uffff\32\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\4\70" + "\1\u00c9\25\70",
			"\1\70\2\uffff\13\70\6\uffff\4\70\1\u00ca\25\70\4\uffff\1\70" + "\1\uffff\32\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\5\70" + "\1\u00cb\24\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\11\70" + "\1\u00cc\20\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\1\u00cd" + "\31\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\5\70" + "\1\u00ce\24\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\11\70" + "\1\u00cf\20\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\1\u00d0" + "\31\70",
			"\1\70\2\uffff\13\70\6\uffff\1\u00d1\31\70\4\uffff\1\70\1\uffff" + "\32\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\4\70" + "\1\u00d2\25\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\6\70" + "\1\u00d3\23\70",
			"\1\70\2\uffff\13\70\6\uffff\12\70\1\u00d4\17\70\4\uffff\1\70"
					+ "\1\uffff\12\70\1\u00d4\17\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\2\70" + "\1\u00d5\27\70",
			"\1\70\2\uffff\13\70\6\uffff\13\70\1\u00d6\16\70\4\uffff\1\70" + "\1\uffff\32\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\13\70" + "\1\u00d7\16\70",
			"\1\70\2\uffff\13\70\6\uffff\16\70\1\u00d8\13\70\4\uffff\1\70" + "\1\uffff\32\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
			"\1\70\2\uffff\13\70\6\uffff\4\70\1\u00d9\25\70\4\uffff\1\70" + "\1\uffff\32\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\15\70" + "\1\u00da\14\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\4\70" + "\1\u00db\25\70",
			"",
			"\42\144\1\145\uffdd\144",
			"\1\70\2\uffff\13\70\6\uffff\22\70\1\u00dc\7\70\4\uffff\1\70" + "\1\uffff\32\70",
			"\1\70\2\uffff\13\70\6\uffff\22\70\1\u00dd\7\70\4\uffff\1\70" + "\1\uffff\32\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\1\u00de" + "\31\70",
			"\47\151\1\152\uffd8\151",
			"\1\70\2\uffff\13\70\6\uffff\4\70\1\u00df\25\70\4\uffff\1\70" + "\1\uffff\32\70",
			"\1\70\2\uffff\13\70\6\uffff\21\70\1\u00e0\10\70\4\uffff\1\70" + "\1\uffff\32\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\1\u00e1" + "\31\70",
			"\1\70\2\uffff\13\70\6\uffff\10\70\1\u00e2\21\70\4\uffff\1\70" + "\1\uffff\32\70",
			"\1\70\2\uffff\13\70\1\52\5\uffff\32\70\4\uffff\1\70\1\uffff" + "\32\70",
			"\1\70\2\uffff\13\70\6\uffff\2\70\1\u00e3\27\70\4\uffff\1\70" + "\1\uffff\32\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\2\70" + "\1\u00e4\27\70",
			"\1\70\2\uffff\13\70\6\uffff\24\70\1\u00e5\5\70\4\uffff\1\70" + "\1\uffff\32\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\13\70" + "\1\u00e6\16\70",
			"\1\70\2\uffff\13\70\6\uffff\24\70\1\u00e7\5\70\4\uffff\1\70" + "\1\uffff\32\70",
			"\1\70\2\uffff\13\70\6\uffff\21\70\1\u00e8\10\70\4\uffff\1\70" + "\1\uffff\32\70",
			"\1\70\2\uffff\13\70\6\uffff\25\70\1\u00e9\4\70\4\uffff\1\70" + "\1\uffff\32\70",
			"\1\70\2\uffff\13\70\6\uffff\4\70\1\u00ea\25\70\4\uffff\1\70" + "\1\uffff\32\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\4\70" + "\1\u00eb\25\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\4\70" + "\1\u00ec\25\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
			"\1\70\2\uffff\13\70\6\uffff\22\70\1\u00ed\7\70\4\uffff\1\70"
					+ "\1\uffff\22\70\1\u00ed\7\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\13\70" + "\1\u00ee\16\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\21\70" + "\1\u00ef\10\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\21\70" + "\1\u00f0\10\70",
			"\1\70\2\uffff\13\70\6\uffff\1\u00f1\31\70\4\uffff\1\70\1\uffff" + "\32\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\4\70" + "\1\u00f2\25\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\23\70" + "\1\u00f3\6\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\25\70" + "\1\u00f4\4\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\4\70" + "\1\u00f5\25\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\21\70" + "\1\u00f6\10\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\1\u00f7" + "\31\70",
			"\1\70\2\uffff\13\70\6\uffff\25\70\1\u00f8\4\70\4\uffff\1\70" + "\1\uffff\32\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\5\70" + "\1\u00f9\24\70",
			"\1\70\2\uffff\13\70\6\uffff\1\u00fa\31\70\4\uffff\1\70\1\uffff" + "\32\70",
			"\1\70\2\uffff\13\70\6\uffff\2\70\1\u00fb\27\70\4\uffff\1\70" + "\1\uffff\32\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\4\70" + "\1\u00fc\25\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\16\70" + "\1\u00fd\13\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\10\70" + "\1\u00fe\21\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\4\70" + "\1\u00ff\25\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\16\70" + "\1\u0100\13\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\10\70" + "\1\u0101\21\70",
			"\1\70\2\uffff\13\70\6\uffff\17\70\1\u0102\12\70\4\uffff\1\70" + "\1\uffff\32\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\21\70" + "\1\u0103\10\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\4\70" + "\1\u0104\25\70",
			"\1\70\2\uffff\13\70\6\uffff\4\70\1\u0105\25\70\4\uffff\1\70"
					+ "\1\uffff\4\70\1\u0105\25\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\23\70" + "\1\u0106\6\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
			"\1\70\2\uffff\13\70\6\uffff\23\70\1\u0107\6\70\4\uffff\1\70" + "\1\uffff\32\70",
			"\1\70\2\uffff\13\70\6\uffff\21\70\1\u0108\10\70\4\uffff\1\70" + "\1\uffff\32\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\22\70" + "\1\u0109\7\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\22\70" + "\1\u010a\7\70",
			"\1\70\2\uffff\13\70\6\uffff\22\70\1\u010b\7\70\4\uffff\1\70" + "\1\uffff\32\70",
			"\1\70\2\uffff\13\70\6\uffff\23\70\1\u010c\6\70\4\uffff\1\70" + "\1\uffff\32\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\23\70" + "\1\u010d\6\70",
			"\1\70\2\uffff\13\70\6\uffff\2\70\1\u010e\27\70\4\uffff\1\70" + "\1\uffff\32\70",
			"\1\70\2\uffff\13\70\6\uffff\4\70\1\u010f\25\70\4\uffff\1\70" + "\1\uffff\32\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\23\70" + "\1\u0110\6\70",
			"\1\70\2\uffff\13\70\6\uffff\15\70\1\u0111\14\70\4\uffff\1\70" + "\1\uffff\32\70",
			"\1\70\2\uffff\13\70\6\uffff\7\70\1\u0112\22\70\4\uffff\1\70" + "\1\uffff\32\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\7\70" + "\1\u0113\22\70",
			"\1\70\2\uffff\13\70\6\uffff\4\70\1\u0114\25\70\4\uffff\1\70" + "\1\uffff\32\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
			"\1\70\2\uffff\13\70\6\uffff\17\70\1\u0115\12\70\4\uffff\1\70" + "\1\uffff\32\70",
			"\1\70\2\uffff\13\70\6\uffff\15\70\1\u0116\14\70\4\uffff\1\70" + "\1\uffff\32\70",
			"\1\70\2\uffff\13\70\6\uffff\4\70\1\u0117\25\70\4\uffff\1\70" + "\1\uffff\32\70",
			"\1\70\2\uffff\13\70\6\uffff\21\70\1\u0118\10\70\4\uffff\1\70" + "\1\uffff\32\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\27\70" + "\1\u0119\2\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\30\70" + "\1\u011a\1\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\1\u011b" + "\31\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\16\70" + "\1\u011c\13\70",
			"\1\70\2\uffff\13\70\6\uffff\2\70\1\u011d\14\70\1\u011e\12\70"
					+ "\4\uffff\1\70\1\uffff\32\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\22\70" + "\1\u011f\7\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\23\70" + "\1\u0120\6\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\13\70" + "\1\u0121\16\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\1\u0122" + "\31\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\22\70" + "\1\u0123\7\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\15\70" + "\1\u0124\14\70",
			"\1\70\2\uffff\13\70\6\uffff\10\70\1\u0125\21\70\4\uffff\1\70" + "\1\uffff\32\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\13\70" + "\1\u0126\16\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\22\70" + "\1\u0127\7\70",
			"\1\70\2\uffff\13\70\6\uffff\23\70\1\u0128\6\70\4\uffff\1\70" + "\1\uffff\32\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\21\70" + "\1\u0129\10\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\10\70" + "\1\u012a\21\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\15\70" + "\1\u012b\14\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\21\70" + "\1\u012c\10\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\10\70" + "\1\u012d\21\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\15\70" + "\1\u012e\14\70",
			"\1\70\2\uffff\13\70\6\uffff\21\70\1\u012f\10\70\4\uffff\1\70" + "\1\uffff\32\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\22\70" + "\1\u0130\7\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
			"\1\70\2\uffff\13\70\6\uffff\30\70\1\u0131\1\70\4\uffff\1\70"
					+ "\1\uffff\30\70\1\u0131\1\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\10\70" + "\1\u0132\21\70",
			"\1\70\2\uffff\13\70\6\uffff\1\u0133\31\70\4\uffff\1\70\1\uffff" + "\32\70",
			"\1\70\2\uffff\13\70\6\uffff\23\70\1\u0134\6\70\4\uffff\1\70" + "\1\uffff\32\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\10\70" + "\1\u0135\21\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
			"\1\70\2\uffff\13\70\6\uffff\1\u0136\31\70\4\uffff\1\70\1\uffff" + "\32\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\4\70" + "\1\u0137\25\70",
			"\1\70\2\uffff\13\70\6\uffff\23\70\1\u0138\6\70\4\uffff\1\70" + "\1\uffff\32\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\4\70" + "\1\u0139\25\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
			"\1\70\2\uffff\13\70\6\uffff\22\70\1\u013a\7\70\4\uffff\1\70" + "\1\uffff\32\70",
			"\1\70\2\uffff\13\70\6\uffff\22\70\1\u013b\7\70\4\uffff\1\70" + "\1\uffff\32\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
			"\1\70\2\uffff\13\70\6\uffff\10\70\1\u013d\21\70\4\uffff\1\70" + "\1\uffff\32\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\10\70" + "\1\u013e\21\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\14\70" + "\1\u013f\15\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\22\70" + "\1\u0140\7\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\17\70" + "\1\u0141\12\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\13\70" + "\1\u0142\16\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\21\70" + "\1\u0143\10\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\21\70" + "\1\u0144\10\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\30\70" + "\1\u0145\1\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\13\70" + "\1\u0146\16\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\4\70" + "\1\u0147\25\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\2\70" + "\1\u0148\27\70",
			"\1\70\2\uffff\13\70\6\uffff\3\70\1\u0149\26\70\4\uffff\1\70" + "\1\uffff\32\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\4\70" + "\1\u014a\25\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\4\70" + "\1\u014b\25\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\15\70" + "\1\u014c\14\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\4\70" + "\1\u014d\25\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\15\70" + "\1\u014e\14\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
			"\1\70\2\uffff\13\70\6\uffff\16\70\1\u014f\13\70\4\uffff\1\70" + "\1\uffff\32\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\4\70" + "\1\u0150\25\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\16\70" + "\1\u0151\13\70",
			"\1\70\2\uffff\13\70\6\uffff\23\70\1\u0152\6\70\4\uffff\1\70" + "\1\uffff\32\70",
			"\1\70\2\uffff\13\70\6\uffff\4\70\1\u0153\25\70\4\uffff\1\70" + "\1\uffff\32\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\23\70" + "\1\u0154\6\70",
			"\1\70\2\uffff\13\70\6\uffff\15\70\1\u0155\14\70\4\uffff\1\70" + "\1\uffff\32\70",
			"\1\70\2\uffff\13\70\6\uffff\10\70\1\u0156\13\70\1\u0157\5\70"
					+ "\4\uffff\1\70\1\uffff\32\70",
			"\1\70\2\uffff\13\70\6\uffff\17\70\1\u0158\12\70\4\uffff\1\70" + "\1\uffff\32\70",
			"\1\70\2\uffff\13\70\6\uffff\10\70\1\u0159\13\70\1\u015a\5\70"
					+ "\4\uffff\1\70\1\uffff\32\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
			"",
			"\1\70\2\uffff\13\70\6\uffff\15\70\1\u015b\14\70\4\uffff\1\70" + "\1\uffff\32\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\25\70" + "\1\u015c\4\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\14\70" + "\1\u015d\15\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\22\70" + "\1\u015e\7\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\4\70" + "\1\u015f\25\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\1\u0160" + "\31\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\16\70" + "\1\u0161\13\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\10\70" + "\1\u0162\21\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\4\70" + "\1\u0163\25\70",
			"\1\70\2\uffff\13\70\6\uffff\5\70\1\u0165\10\70\1\u0164\13\70"
					+ "\4\uffff\1\70\1\uffff\5\70\1\u0165\24\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\4\70" + "\1\u0166\25\70",
			"\1\70\2\uffff\13\70\6\uffff\24\70\1\u0167\5\70\4\uffff\1\70" + "\1\uffff\32\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\27\70" + "\1\u0168\2\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\15\70" + "\1\u0169\14\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\23\70" + "\1\u016a\6\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\15\70" + "\1\u016b\14\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\23\70" + "\1\u016c\6\70",
			"\1\70\2\uffff\13\70\6\uffff\17\70\1\u016d\12\70\4\uffff\1\70" + "\1\uffff\32\70",
			"\1\70\2\uffff\13\70\6\uffff\5\70\1\u0165\10\70\1\u016e\13\70"
					+ "\4\uffff\1\70\1\uffff\5\70\1\u0165\24\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\15\70" + "\1\u016f\14\70",
			"\1\70\2\uffff\13\70\6\uffff\10\70\1\u0170\21\70\4\uffff\1\70" + "\1\uffff\32\70",
			"\1\70\2\uffff\13\70\6\uffff\3\70\1\u0171\26\70\4\uffff\1\70" + "\1\uffff\32\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\10\70" + "\1\u0172\21\70",
			"\1\70\2\uffff\13\70\6\uffff\23\70\1\u0173\6\70\4\uffff\1\70" + "\1\uffff\32\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\15\70" + "\1\u0174\14\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\15\70" + "\1\u0175\14\70",
			"\1\70\2\uffff\13\70\6\uffff\21\70\1\u0176\10\70\4\uffff\1\70" + "\1\uffff\32\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\15\70" + "\1\u0177\14\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\15\70" + "\1\u0178\14\70",
			"\1\70\2\uffff\13\70\6\uffff\6\70\1\u0179\23\70\4\uffff\1\70" + "\1\uffff\32\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\4\70" + "\1\u017a\25\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\4\70" + "\1\u017b\25\70",
			"\1\70\2\uffff\13\70\6\uffff\16\70\1\u017c\13\70\4\uffff\1\70" + "\1\uffff\32\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\21\70" + "\1\u017d\10\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\22\70" + "\1\u017e\7\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\17\70" + "\1\u017f\12\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\2\70" + "\1\u0180\27\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\15\70" + "\1\u0181\14\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\5\70" + "\1\u0182\24\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\24\70" + "\1\u0183\5\70",
			"\1\70\2\uffff\13\70\6\uffff\16\70\1\u0184\13\70\4\uffff\1\70"
					+ "\1\uffff\16\70\1\u0184\13\70",
			"\1\70\2\uffff\13\70\6\uffff\1\u0185\31\70\4\uffff\1\70\1\uffff" + "\32\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\10\70" + "\1\u0186\21\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\23\70" + "\1\u0187\6\70",
			"\1\70\2\uffff\13\70\6\uffff\26\70\1\u0188\3\70\4\uffff\1\70" + "\1\uffff\32\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\23\70" + "\1\u0189\6\70",
			"\1\70\2\uffff\13\70\6\uffff\26\70\1\u018a\3\70\4\uffff\1\70" + "\1\uffff\32\70",
			"\1\70\2\uffff\13\70\6\uffff\4\70\1\u018b\25\70\4\uffff\1\70" + "\1\uffff\32\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\5\70" + "\1\u018c\24\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\1\u018d" + "\31\70",
			"\1\70\2\uffff\13\70\6\uffff\16\70\1\u018e\13\70\4\uffff\1\70" + "\1\uffff\32\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\25\70" + "\1\u018f\4\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\23\70" + "\1\u0190\6\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\10\70" + "\1\u0191\21\70",
			"\1\70\2\uffff\13\70\6\uffff\16\70\1\u0192\13\70\4\uffff\1\70" + "\1\uffff\32\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\23\70" + "\1\u0193\6\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\10\70" + "\1\u0194\21\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
			"\1\70\2\uffff\12\70\1\u0195\6\uffff\32\70\4\uffff\1\70\1\uffff" + "\32\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\23\70" + "\1\u0196\6\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\5\70" + "\1\u0197\24\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\23\70" + "\1\u0198\6\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\22\70" + "\1\u0199\7\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\4\70" + "\1\u019a\25\70",
			"\1\70\2\uffff\12\70\1\u019b\6\uffff\32\70\4\uffff\1\70\1\uffff" + "\32\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\23\70" + "\1\u019c\6\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\15\70" + "\1\u019d\14\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\5\70" + "\1\u019e\24\70",
			"\1\70\2\uffff\13\70\6\uffff\13\70\1\u019f\16\70\4\uffff\1\70" + "\1\uffff\32\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\25\70" + "\1\u01a0\4\70",
			"\1\70\2\uffff\13\70\6\uffff\5\70\1\u01a1\24\70\4\uffff\1\70" + "\1\uffff\32\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\10\70" + "\1\u01a2\21\70",
			"\1\70\2\uffff\13\70\6\uffff\5\70\1\u01a3\24\70\4\uffff\1\70" + "\1\uffff\32\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\10\70" + "\1\u01a4\21\70",
			"\1\70\2\uffff\13\70\6\uffff\21\70\1\u01a5\10\70\4\uffff\1\70" + "\1\uffff\32\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\13\70" + "\1\u01a6\16\70",
			"\1\70\2\uffff\13\70\6\uffff\15\70\1\u01a7\14\70\4\uffff\1\70" + "\1\uffff\32\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\4\70" + "\1\u01a8\25\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\4\70" + "\1\u01a9\25\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\16\70" + "\1\u01aa\13\70",
			"\1\70\2\uffff\13\70\6\uffff\17\70\1\u01ab\12\70\4\uffff\1\70" + "\1\uffff\32\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\4\70" + "\1\u01ac\25\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\16\70" + "\1\u01ad\13\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\21\70" + "\1\u01ae\10\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\30\70" + "\1\u01af\1\70",
			"\1\70\2\uffff\13\70\6\uffff\16\70\1\u01b0\13\70\4\uffff\1\70" + "\1\uffff\32\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\21\70" + "\1\u01b1\10\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
			"\1\70\2\uffff\13\70\6\uffff\23\70\1\u01b2\6\70\4\uffff\1\70" + "\1\uffff\32\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\2\70" + "\1\u01b3\27\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\4\70" + "\1\u01b4\25\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\21\70" + "\1\u01b5\10\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\23\70" + "\1\u01b6\6\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\21\70" + "\1\u01b7\10\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\23\70" + "\1\u01b8\6\70",
			"\1\70\2\uffff\13\70\6\uffff\23\70\1\u01b9\6\70\4\uffff\1\70" + "\1\uffff\32\70",
			"\1\70\2\uffff\12\70\1\u01ba\6\uffff\32\70\4\uffff\1\70\1\uffff" + "\32\70",
			"\1\70\2\uffff\13\70\6\uffff\17\70\1\u01bb\12\70\4\uffff\1\70" + "\1\uffff\32\70",
			"\1\70\2\uffff\12\70\1\u01bc\6\uffff\32\70\4\uffff\1\70\1\uffff" + "\32\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\21\70" + "\1\u01bd\10\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\15\70" + "\1\u01be\14\70",
			"\1\70\2\uffff\13\70\6\uffff\4\70\1\u01bf\25\70\4\uffff\1\70" + "\1\uffff\32\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\21\70" + "\1\u01c0\10\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\15\70" + "\1\u01c1\14\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\10\70" + "\1\u01c2\21\70",
			"\1\70\2\uffff\13\70\6\uffff\16\70\1\u01c3\13\70\4\uffff\1\70" + "\1\uffff\32\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\5\70" + "\1\u01c4\24\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\23\70" + "\1\u01c5\6\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\16\70" + "\1\u01c6\13\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\23\70" + "\1\u01c7\6\70",
			"\1\70\2\uffff\12\70\1\u01c8\6\uffff\32\70\4\uffff\1\70\1\uffff" + "\32\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\16\70" + "\1\u01c9\13\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\7\70" + "\1\u01ca\22\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\16\70" + "\1\u01cb\13\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\7\70" + "\1\u01cc\22\70",
			"\1\70\2\uffff\13\70\6\uffff\30\70\1\u01cd\1\70\4\uffff\1\70" + "\1\uffff\32\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
			"\1\70\2\uffff\13\70\6\uffff\21\70\1\u01ce\10\70\4\uffff\1\70" + "\1\uffff\32\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\22\70" + "\1\u01cf\7\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
			"\1\70\2\uffff\13\70\6\uffff\21\70\1\u01d0\10\70\4\uffff\1\70" + "\1\uffff\32\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\22\70" + "\1\u01d1\7\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\2\70" + "\1\u01d2\27\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\5\70" + "\1\u01d3\24\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\30\70" + "\1\u01d4\1\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\10\70" + "\1\u01d5\21\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\14\70" + "\1\u01d6\15\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\14\70" + "\1\u01d7\15\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
			"\1\70\2\uffff\13\70\6\uffff\16\70\1\u01d8\13\70\4\uffff\1\70" + "\1\uffff\32\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\4\70" + "\1\u01d9\25\70",
			"\1\70\2\uffff\13\70\6\uffff\23\70\1\u01da\6\70\4\uffff\1\70" + "\1\uffff\32\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\4\70" + "\1\u01db\25\70",
			"\1\70\2\uffff\12\70\1\u01dc\6\uffff\32\70\4\uffff\1\70\1\uffff" + "\32\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
			"\1\70\2\uffff\13\70\6\uffff\16\70\1\u01dd\13\70\4\uffff\1\70" + "\1\uffff\32\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\16\70" + "\1\u01de\13\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
			"\1\70\2\uffff\13\70\6\uffff\17\70\1\u01df\12\70\4\uffff\1\70" + "\1\uffff\32\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\2\70" + "\1\u01e0\27\70",
			"\1\70\2\uffff\13\70\6\uffff\30\70\1\u01e1\1\70\4\uffff\1\70" + "\1\uffff\32\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\2\70" + "\1\u01e2\27\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\5\70" + "\1\u01e3\24\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\15\70" + "\1\u01e4\14\70",
			"\1\70\2\uffff\13\70\6\uffff\4\70\1\u01e5\25\70\4\uffff\1\70" + "\1\uffff\32\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\23\70" + "\1\u01e6\6\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\23\70" + "\1\u01e7\6\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\1\u01e8" + "\31\70",
			"\1\70\2\uffff\13\70\6\uffff\21\70\1\u01e9\10\70\4\uffff\1\70" + "\1\uffff\32\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\10\70" + "\1\u01ea\21\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\10\70" + "\1\u01eb\21\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\13\70" + "\1\u01ec\16\70",
			"\1\70\2\uffff\13\70\6\uffff\23\70\1\u01ed\6\70\4\uffff\1\70" + "\1\uffff\32\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\16\70" + "\1\u01ee\13\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\16\70" + "\1\u01ef\13\70",
			"\1\70\2\uffff\12\70\1\u01f0\6\uffff\32\70\4\uffff\1\70\1\uffff" + "\32\70",
			"\1\70\2\uffff\13\70\6\uffff\30\70\1\u01f1\1\70\4\uffff\1\70" + "\1\uffff\32\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\15\70" + "\1\u01f2\14\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\15\70" + "\1\u01f3\14\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
			"\1\70\2\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\32\70" };
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
				int LA1_166 = input.LA(1);
				s = -1;
				if (LA1_166 == '\"') {
					s = 101;
				} else if (LA1_166 >= '\u0000' && LA1_166 <= '!' || LA1_166 >= '#'
						&& LA1_166 <= '\uFFFF') {
					s = 100;
				}
				if (s >= 0) {
					return s;
				}
				break;
			case 1:
				int LA1_33 = input.LA(1);
				s = -1;
				if (LA1_33 == '=') {
					s = 97;
				} else if (LA1_33 >= '\u0000' && LA1_33 <= '<' || LA1_33 >= '?'
						&& LA1_33 <= '\uFFFF') {
					s = 98;
				} else {
					s = 55;
				}
				if (s >= 0) {
					return s;
				}
				break;
			case 2:
				int LA1_105 = input.LA(1);
				s = -1;
				if (LA1_105 == '\'') {
					s = 106;
				} else if (LA1_105 >= '\u0000' && LA1_105 <= '&' || LA1_105 >= '('
						&& LA1_105 <= '\uFFFF') {
					s = 105;
				}
				if (s >= 0) {
					return s;
				}
				break;
			case 3:
				int LA1_38 = input.LA(1);
				s = -1;
				if (LA1_38 >= '\u0000' && LA1_38 <= '&' || LA1_38 >= '(' && LA1_38 <= '\uFFFF') {
					s = 105;
				} else if (LA1_38 == '\'') {
					s = 106;
				}
				if (s >= 0) {
					return s;
				}
				break;
			case 4:
				int LA1_100 = input.LA(1);
				s = -1;
				if (LA1_100 == '\"') {
					s = 101;
				} else if (LA1_100 >= '\u0000' && LA1_100 <= '!' || LA1_100 >= '#'
						&& LA1_100 <= '\uFFFF') {
					s = 100;
				}
				if (s >= 0) {
					return s;
				}
				break;
			case 5:
				int LA1_35 = input.LA(1);
				s = -1;
				if (LA1_35 >= '\u0000' && LA1_35 <= '!' || LA1_35 >= '#' && LA1_35 <= '\uFFFF') {
					s = 100;
				} else if (LA1_35 == '\"') {
					s = 101;
				}
				if (s >= 0) {
					return s;
				}
				break;
			case 6:
				int LA1_170 = input.LA(1);
				s = -1;
				if (LA1_170 == '\'') {
					s = 106;
				} else if (LA1_170 >= '\u0000' && LA1_170 <= '&' || LA1_170 >= '('
						&& LA1_170 <= '\uFFFF') {
					s = 105;
				}
				if (s >= 0) {
					return s;
				}
				break;
			case 7:
				int LA1_97 = input.LA(1);
				s = -1;
				if (LA1_97 == '>') {
					s = 165;
				} else if (LA1_97 >= '\u0000' && LA1_97 <= '=' || LA1_97 >= '?'
						&& LA1_97 <= '\uFFFF') {
					s = 98;
				} else {
					s = 55;
				}
				if (s >= 0) {
					return s;
				}
				break;
			case 8:
				int LA1_98 = input.LA(1);
				s = -1;
				if (LA1_98 == '>') {
					s = 165;
				} else if (LA1_98 >= '\u0000' && LA1_98 <= '=' || LA1_98 >= '?'
						&& LA1_98 <= '\uFFFF') {
					s = 98;
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