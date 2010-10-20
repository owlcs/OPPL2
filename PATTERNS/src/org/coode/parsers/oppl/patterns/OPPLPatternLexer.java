package org.coode.parsers.oppl.patterns;

// $ANTLR 3.2 Sep 23, 2009 12:02:23 /Users/luigi/Documents/workspace/Parsers/src/OPPLPatternLexer.g 2010-10-20 10:06:49
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
	public static final int GREATER_THAN = 507;
	public static final int ASSERTED = 76;
	public static final int END = 84;
	public static final int HYPHEN = 465;
	public static final int DIFFERENT_FROM = 24;
	public static final int LESS_THAN = 505;
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
	public static final int GREATER_THAN_EQUAL = 508;
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
	public static final int LESS_THAN_EQUAL = 506;
	public static final int VALUE = 18;
	public static final int RENDERING = 355;
	public static final int INVERSE_FUNCTIONAL = 35;
	public static final int OR = 11;
	public static final int INTEGER = 42;
	public static final int INVERSE = 19;
	public static final int DISJOINT_WITH_AXIOM = 50;
	public static final int SUPER_CLASS_OF = 87;
	public static final int DIGIT = 41;
	public static final int COMPOSITION = 4;
	public static final int FUNCTIONAL = 29;
	public static final int NOT_EQUAL = 72;
	public static final int LETTER = 43;
	public static final int MAX = 16;
	public static final int FAIL = 534;
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
	static final String DFA1_eotS = "\1\uffff\1\62\1\66\2\uffff\1\66\5\uffff\20\66\5\uffff\2\66\1\uffff"
			+ "\2\66\1\uffff\3\66\1\uffff\7\66\2\uffff\3\66\1\uffff\45\66\3\uffff"
			+ "\4\66\1\uffff\70\66\1\uffff\3\66\1\uffff\147\66\1\u012c\43\66\1" + "\uffff\u00ab\66";
	static final String DFA1_eofS = "\u01d8\uffff";
	static final String DFA1_minS = "\1\11\1\164\1\55\2\uffff\1\55\5\uffff\20\55\5\uffff\2\75\1\0\1\60"
			+ "\1\55\1\0\3\55\1\uffff\7\55\2\uffff\3\55\1\uffff\45\55\2\uffff\1"
			+ "\0\1\42\3\55\1\0\1\47\67\55\1\0\3\55\1\0\u008b\55\1\uffff\u00ab" + "\55";
	static final String DFA1_maxS = "\1\175\1\164\1\172\2\uffff\1\172\5\uffff\20\172\5\uffff\2\75\1\uffff"
			+ "\1\71\1\172\1\uffff\3\172\1\uffff\7\172\2\uffff\3\172\1\uffff\45"
			+ "\172\2\uffff\1\uffff\1\42\3\172\1\uffff\1\47\67\172\1\uffff\3\172"
			+ "\1\uffff\u008b\172\1\uffff\u00ab\172";
	static final String DFA1_acceptS = "\3\uffff\1\4\1\5\1\uffff\5\6\20\uffff\5\6\11\uffff\1\7\7\uffff\1"
			+ "\1\1\2\3\uffff\1\6\45\uffff\2\6\u00ce\uffff\1\3\u00ab\uffff";
	static final String DFA1_specialS = "\42\uffff\1\3\2\uffff\1\5\70\uffff\1\4\4\uffff\1\1\70\uffff\1\2"
			+ "\3\uffff\1\0\u0137\uffff}>";
	static final String[] DFA1_transitionS = {
			"\2\12\2\uffff\1\12\22\uffff\1\12\1\51\1\42\1\uffff\1\1\2\uffff"
					+ "\1\45\1\6\1\11\1\uffff\1\51\1\34\1\4\1\51\1\uffff\12\43\1\51"
					+ "\1\3\1\40\1\37\1\41\1\51\1\uffff\1\31\1\52\1\44\1\25\1\53\1"
					+ "\30\1\57\1\60\1\22\3\60\1\54\1\15\1\46\2\60\1\2\1\23\1\32\1"
					+ "\60\1\55\1\47\3\60\1\35\1\uffff\1\36\1\33\2\uffff\1\13\1\60"
					+ "\1\50\1\24\1\20\1\56\2\60\1\26\3\60\1\17\1\14\1\5\2\60\1\27"
					+ "\1\16\1\32\1\60\1\21\4\60\1\7\1\uffff\1\10",
			"\1\61",
			"\1\67\2\uffff\13\67\6\uffff\4\67\1\63\25\67\4\uffff\1\67\1"
					+ "\uffff\1\64\3\67\1\65\25\67",
			"",
			"",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\15\67"
					+ "\1\71\3\67\1\70\10\67",
			"",
			"",
			"",
			"",
			"",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\15\67" + "\1\72\14\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\16\67" + "\1\73\13\67",
			"\1\67\2\uffff\13\67\6\uffff\16\67\1\74\13\67\4\uffff\1\67\1"
					+ "\uffff\16\67\1\75\13\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\1\100"
					+ "\15\67\1\76\5\67\1\77\3\67\1\101\1\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\1\103" + "\7\67\1\102\21\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\20\67"
					+ "\1\105\6\67\1\104\2\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\1\106" + "\31\67",
			"\1\67\2\uffff\13\67\6\uffff\15\67\1\107\14\67\4\uffff\1\67"
					+ "\1\uffff\15\67\1\110\3\67\1\111\10\67",
			"\1\67\2\uffff\13\67\6\uffff\4\67\1\114\25\67\4\uffff\1\67\1"
					+ "\uffff\1\113\23\67\1\112\3\67\1\101\1\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\10\67"
					+ "\1\115\5\67\1\116\13\67",
			"\1\67\2\uffff\13\67\6\uffff\1\121\31\67\4\uffff\1\67\1\uffff"
					+ "\10\67\1\117\5\67\1\120\13\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\15\67"
					+ "\1\122\3\67\1\111\10\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\1\123" + "\3\67\1\65\25\67",
			"\1\67\2\uffff\13\67\6\uffff\1\125\31\67\4\uffff\1\67\1\uffff"
					+ "\1\126\23\67\1\124\5\67",
			"\1\67\2\uffff\13\67\6\uffff\3\67\1\130\16\67\1\131\7\67\4\uffff"
					+ "\1\67\1\uffff\15\67\1\127\14\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\21\67"
					+ "\1\132\6\67\1\133\1\67",
			"",
			"",
			"",
			"",
			"",
			"\1\134",
			"\1\135",
			"\42\136\1\137\uffdd\136",
			"\12\43",
			"\1\67\2\uffff\13\67\6\uffff\13\67\1\140\2\67\1\141\13\67\4"
					+ "\uffff\1\67\1\uffff\21\67\1\142\10\67",
			"\47\143\1\144\uffd8\143",
			"\1\67\2\uffff\13\67\6\uffff\1\67\1\145\30\67\4\uffff\1\67\1" + "\uffff\32\67",
			"\1\67\2\uffff\13\67\6\uffff\7\67\1\146\22\67\4\uffff\1\67\1" + "\uffff\32\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\21\67" + "\1\147\10\67",
			"",
			"\1\67\2\uffff\13\67\6\uffff\4\67\1\150\25\67\4\uffff\1\67\1" + "\uffff\32\67",
			"\1\67\2\uffff\13\67\6\uffff\15\67\1\151\14\67\4\uffff\1\67" + "\1\uffff\32\67",
			"\1\67\2\uffff\13\67\6\uffff\1\152\31\67\4\uffff\1\67\1\uffff" + "\1\153\31\67",
			"\1\67\2\uffff\13\67\6\uffff\1\154\31\67\4\uffff\1\67\1\uffff" + "\32\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\1\155" + "\23\67\1\124\5\67",
			"\1\67\2\uffff\13\67\6\uffff\21\67\1\156\10\67\4\uffff\1\67" + "\1\uffff\32\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
			"",
			"",
			"\1\67\2\uffff\13\67\6\uffff\14\67\1\160\1\161\5\67\1\157\6"
					+ "\67\4\uffff\1\67\1\uffff\32\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\15\67" + "\1\162\14\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\5\67" + "\1\163\24\67",
			"",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\13\67" + "\1\164\16\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\3\67"
					+ "\1\165\17\67\1\166\6\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\23\67" + "\1\167\6\67",
			"\1\67\2\uffff\13\67\6\uffff\23\67\1\170\6\67\4\uffff\1\67\1" + "\uffff\32\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\23\67" + "\1\171\6\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\14\67" + "\1\172\15\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\1\67"
					+ "\1\173\15\67\1\174\12\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\14\67" + "\1\175\15\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\14\67" + "\1\176\15\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\15\67" + "\1\177\14\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\27\67" + "\1\u0080\2\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\1\u0081" + "\31\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\24\67" + "\1\u0082\5\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\13\67" + "\1\u0083\16\67",
			"\1\67\2\uffff\13\67\6\uffff\3\67\1\u0085\21\67\1\u0084\4\67"
					+ "\4\uffff\1\67\1\uffff\32\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\22\67"
					+ "\1\u0087\2\67\1\u0086\4\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\21\67" + "\1\u0088\10\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\1\67" + "\1\u0089\30\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\14\67" + "\1\u008a\15\67",
			"\1\67\2\uffff\13\67\6\uffff\13\67\1\u008b\16\67\4\uffff\1\67" + "\1\uffff\32\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\5\67"
					+ "\1\u008c\14\67\1\u008d\7\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\14\67" + "\1\u008e\15\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\5\67"
					+ "\1\u008f\14\67\1\u0090\7\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\14\67" + "\1\u0091\15\67",
			"\1\67\2\uffff\13\67\6\uffff\23\67\1\u0092\6\67\4\uffff\1\67" + "\1\uffff\32\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\22\67"
					+ "\1\u0087\2\67\1\u0093\4\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\15\67" + "\1\u0094\14\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\15\67" + "\1\u0095\14\67",
			"\1\67\2\uffff\13\67\6\uffff\10\67\1\u0096\21\67\4\uffff\1\67" + "\1\uffff\32\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\10\67" + "\1\u0097\21\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\23\67" + "\1\166\6\67",
			"\1\67\2\uffff\13\67\6\uffff\3\67\1\u0098\26\67\4\uffff\1\67" + "\1\uffff\32\67",
			"\1\67\2\uffff\13\67\6\uffff\22\67\1\u0099\7\67\4\uffff\1\67" + "\1\uffff\32\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\1\u009a" + "\31\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\17\67" + "\1\u009b\12\67",
			"",
			"",
			"\42\136\1\137\uffdd\136",
			"\1\u009c",
			"\1\67\2\uffff\13\67\6\uffff\1\u009d\31\67\4\uffff\1\67\1\uffff" + "\32\67",
			"\1\67\2\uffff\13\67\6\uffff\15\67\1\u009e\14\67\4\uffff\1\67" + "\1\uffff\32\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\4\67" + "\1\u009f\25\67",
			"\47\143\1\144\uffd8\143",
			"\1\u00a0",
			"\1\67\2\uffff\13\67\6\uffff\11\67\1\u00a1\20\67\4\uffff\1\67" + "\1\uffff\32\67",
			"\1\67\2\uffff\13\67\6\uffff\4\67\1\u00a2\25\67\4\uffff\1\67" + "\1\uffff\32\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\4\67" + "\1\u00a3\25\67",
			"\1\67\2\uffff\13\67\6\uffff\6\67\1\u00a4\23\67\4\uffff\1\67" + "\1\uffff\32\67",
			"\1\67\2\uffff\13\67\6\uffff\3\67\1\u00a5\26\67\4\uffff\1\67" + "\1\uffff\32\67",
			"\1\67\2\uffff\13\67\6\uffff\23\67\1\u00a6\6\67\4\uffff\1\67" + "\1\uffff\32\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\23\67" + "\1\u00a7\6\67",
			"\1\67\2\uffff\13\67\6\uffff\13\67\1\u00a8\16\67\4\uffff\1\67" + "\1\uffff\32\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\10\67" + "\1\u00a9\21\67",
			"\1\67\2\uffff\13\67\6\uffff\16\67\1\u00aa\13\67\4\uffff\1\67" + "\1\uffff\32\67",
			"\1\67\2\uffff\13\67\6\uffff\24\67\1\u00ab\5\67\4\uffff\1\67" + "\1\uffff\32\67",
			"\1\67\2\uffff\13\67\6\uffff\16\67\1\u00ac\13\67\4\uffff\1\67" + "\1\uffff\32\67",
			"\1\67\2\uffff\13\67\6\uffff\3\67\1\u00ad\26\67\4\uffff\1\67" + "\1\uffff\32\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\6\67" + "\1\u00ae\23\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\13\67" + "\1\u00af\16\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\30\67" + "\1\u00b0\1\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\10\67" + "\1\u00b1\21\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\4\67" + "\1\u00b2\25\67",
			"\1\67\2\uffff\13\67\6\uffff\2\67\1\u00b3\14\67\1\u00b4\12\67"
					+ "\4\uffff\1\67\1\uffff\32\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\4\67" + "\1\u00b5\25\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\4\67" + "\1\u00b6\25\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\14\67" + "\1\u00b7\15\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\2\67" + "\1\u00b8\27\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\10\67" + "\1\u00b9\21\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\24\67" + "\1\u00ba\5\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
			"\1\67\2\uffff\13\67\6\uffff\10\67\1\u00bb\21\67\4\uffff\1\67" + "\1\uffff\32\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\4\67" + "\1\u00bc\25\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\23\67" + "\1\u00bd\6\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\4\67" + "\1\u00be\25\67",
			"\1\67\2\uffff\13\67\6\uffff\2\67\1\u00b3\27\67\4\uffff\1\67" + "\1\uffff\32\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\4\67" + "\1\u00bf\25\67",
			"\1\67\2\uffff\13\67\6\uffff\4\67\1\u00c0\25\67\4\uffff\1\67" + "\1\uffff\32\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\5\67" + "\1\u00c1\24\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\11\67" + "\1\u00c2\20\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\1\u00c3" + "\31\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\5\67" + "\1\u00c4\24\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\11\67" + "\1\u00c5\20\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\1\u00c6" + "\31\67",
			"\1\67\2\uffff\13\67\6\uffff\1\u00c7\31\67\4\uffff\1\67\1\uffff" + "\32\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\4\67" + "\1\u00c8\25\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\6\67" + "\1\u00c9\23\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\2\67" + "\1\u00ca\27\67",
			"\1\67\2\uffff\13\67\6\uffff\13\67\1\u00cb\16\67\4\uffff\1\67" + "\1\uffff\32\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\13\67" + "\1\u00cc\16\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
			"\1\67\2\uffff\13\67\6\uffff\4\67\1\u00cd\25\67\4\uffff\1\67" + "\1\uffff\32\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\15\67" + "\1\u00ce\14\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\4\67" + "\1\u00cf\25\67",
			"\42\136\1\137\uffdd\136",
			"\1\67\2\uffff\13\67\6\uffff\22\67\1\u00d0\7\67\4\uffff\1\67" + "\1\uffff\32\67",
			"\1\67\2\uffff\13\67\6\uffff\22\67\1\u00d1\7\67\4\uffff\1\67" + "\1\uffff\32\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\1\u00d2" + "\31\67",
			"\47\143\1\144\uffd8\143",
			"\1\67\2\uffff\13\67\6\uffff\4\67\1\u00d3\25\67\4\uffff\1\67" + "\1\uffff\32\67",
			"\1\67\2\uffff\13\67\6\uffff\21\67\1\u00d4\10\67\4\uffff\1\67" + "\1\uffff\32\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\1\u00d5" + "\31\67",
			"\1\67\2\uffff\13\67\6\uffff\10\67\1\u00d6\21\67\4\uffff\1\67" + "\1\uffff\32\67",
			"\1\67\2\uffff\13\67\1\51\5\uffff\32\67\4\uffff\1\67\1\uffff" + "\32\67",
			"\1\67\2\uffff\13\67\6\uffff\2\67\1\u00d7\27\67\4\uffff\1\67" + "\1\uffff\32\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\2\67" + "\1\u00d8\27\67",
			"\1\67\2\uffff\13\67\6\uffff\24\67\1\u00d9\5\67\4\uffff\1\67" + "\1\uffff\32\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\13\67" + "\1\u00da\16\67",
			"\1\67\2\uffff\13\67\6\uffff\24\67\1\u00db\5\67\4\uffff\1\67" + "\1\uffff\32\67",
			"\1\67\2\uffff\13\67\6\uffff\21\67\1\u00dc\10\67\4\uffff\1\67" + "\1\uffff\32\67",
			"\1\67\2\uffff\13\67\6\uffff\25\67\1\u00dd\4\67\4\uffff\1\67" + "\1\uffff\32\67",
			"\1\67\2\uffff\13\67\6\uffff\4\67\1\u00de\25\67\4\uffff\1\67" + "\1\uffff\32\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\4\67" + "\1\u00df\25\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\4\67" + "\1\u00e0\25\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
			"\1\67\2\uffff\13\67\6\uffff\22\67\1\u00e1\7\67\4\uffff\1\67"
					+ "\1\uffff\22\67\1\u00e1\7\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\13\67" + "\1\u00e2\16\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\21\67" + "\1\u00e3\10\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\21\67" + "\1\u00e4\10\67",
			"\1\67\2\uffff\13\67\6\uffff\1\u00e5\31\67\4\uffff\1\67\1\uffff" + "\32\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\4\67" + "\1\u00e6\25\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\23\67" + "\1\u00e7\6\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\25\67" + "\1\u00e8\4\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\4\67" + "\1\u00e9\25\67",
			"\1\67\2\uffff\13\67\6\uffff\25\67\1\u00ea\4\67\4\uffff\1\67" + "\1\uffff\32\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\21\67" + "\1\u00eb\10\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\1\u00ec" + "\31\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\5\67" + "\1\u00ed\24\67",
			"\1\67\2\uffff\13\67\6\uffff\1\u00ee\31\67\4\uffff\1\67\1\uffff" + "\32\67",
			"\1\67\2\uffff\13\67\6\uffff\2\67\1\u00ef\27\67\4\uffff\1\67" + "\1\uffff\32\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\4\67" + "\1\u00f0\25\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\16\67" + "\1\u00f1\13\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\10\67" + "\1\u00f2\21\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\4\67" + "\1\u00f3\25\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\16\67" + "\1\u00f4\13\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\10\67" + "\1\u00f5\21\67",
			"\1\67\2\uffff\13\67\6\uffff\17\67\1\u00f6\12\67\4\uffff\1\67" + "\1\uffff\32\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\21\67" + "\1\u00f7\10\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\4\67" + "\1\u00f8\25\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\23\67" + "\1\u00f9\6\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
			"\1\67\2\uffff\13\67\6\uffff\21\67\1\u00fa\10\67\4\uffff\1\67" + "\1\uffff\32\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\22\67" + "\1\u00fb\7\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\22\67" + "\1\u00fc\7\67",
			"\1\67\2\uffff\13\67\6\uffff\22\67\1\u00fd\7\67\4\uffff\1\67" + "\1\uffff\32\67",
			"\1\67\2\uffff\13\67\6\uffff\23\67\1\u00fe\6\67\4\uffff\1\67" + "\1\uffff\32\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\23\67" + "\1\u00ff\6\67",
			"\1\67\2\uffff\13\67\6\uffff\2\67\1\u0100\27\67\4\uffff\1\67" + "\1\uffff\32\67",
			"\1\67\2\uffff\13\67\6\uffff\4\67\1\u0101\25\67\4\uffff\1\67" + "\1\uffff\32\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\23\67" + "\1\u0102\6\67",
			"\1\67\2\uffff\13\67\6\uffff\15\67\1\u0103\14\67\4\uffff\1\67" + "\1\uffff\32\67",
			"\1\67\2\uffff\13\67\6\uffff\7\67\1\u0104\22\67\4\uffff\1\67" + "\1\uffff\32\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\7\67" + "\1\u0105\22\67",
			"\1\67\2\uffff\13\67\6\uffff\4\67\1\u0106\25\67\4\uffff\1\67" + "\1\uffff\32\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
			"\1\67\2\uffff\13\67\6\uffff\17\67\1\u0107\12\67\4\uffff\1\67" + "\1\uffff\32\67",
			"\1\67\2\uffff\13\67\6\uffff\15\67\1\u0108\14\67\4\uffff\1\67" + "\1\uffff\32\67",
			"\1\67\2\uffff\13\67\6\uffff\4\67\1\u0109\25\67\4\uffff\1\67" + "\1\uffff\32\67",
			"\1\67\2\uffff\13\67\6\uffff\21\67\1\u010a\10\67\4\uffff\1\67" + "\1\uffff\32\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\27\67" + "\1\u010b\2\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\30\67" + "\1\u010c\1\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\1\u010d" + "\31\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\16\67" + "\1\u010e\13\67",
			"\1\67\2\uffff\13\67\6\uffff\2\67\1\u010f\14\67\1\u0110\12\67"
					+ "\4\uffff\1\67\1\uffff\32\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\22\67" + "\1\u0111\7\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\23\67" + "\1\u0112\6\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\13\67" + "\1\u0113\16\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\1\u0114" + "\31\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
			"\1\67\2\uffff\13\67\6\uffff\10\67\1\u0115\21\67\4\uffff\1\67" + "\1\uffff\32\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\22\67" + "\1\u0116\7\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\15\67" + "\1\u0117\14\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\13\67" + "\1\u0118\16\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\22\67" + "\1\u0119\7\67",
			"\1\67\2\uffff\13\67\6\uffff\23\67\1\u011a\6\67\4\uffff\1\67" + "\1\uffff\32\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\21\67" + "\1\u011b\10\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\10\67" + "\1\u011c\21\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\15\67" + "\1\u011d\14\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\21\67" + "\1\u011e\10\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\10\67" + "\1\u011f\21\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\15\67" + "\1\u0120\14\67",
			"\1\67\2\uffff\13\67\6\uffff\21\67\1\u0121\10\67\4\uffff\1\67" + "\1\uffff\32\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\22\67" + "\1\u0122\7\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\10\67" + "\1\u0123\21\67",
			"\1\67\2\uffff\13\67\6\uffff\23\67\1\u0124\6\67\4\uffff\1\67" + "\1\uffff\32\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\10\67" + "\1\u0125\21\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
			"\1\67\2\uffff\13\67\6\uffff\1\u0126\31\67\4\uffff\1\67\1\uffff" + "\32\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\4\67" + "\1\u0127\25\67",
			"\1\67\2\uffff\13\67\6\uffff\23\67\1\u0128\6\67\4\uffff\1\67" + "\1\uffff\32\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\4\67" + "\1\u0129\25\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
			"\1\67\2\uffff\13\67\6\uffff\22\67\1\u012a\7\67\4\uffff\1\67" + "\1\uffff\32\67",
			"\1\67\2\uffff\13\67\6\uffff\22\67\1\u012b\7\67\4\uffff\1\67" + "\1\uffff\32\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
			"\1\67\2\uffff\13\67\6\uffff\10\67\1\u012d\21\67\4\uffff\1\67" + "\1\uffff\32\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\10\67" + "\1\u012e\21\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\14\67" + "\1\u012f\15\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\22\67" + "\1\u0130\7\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\17\67" + "\1\u0131\12\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\13\67" + "\1\u0132\16\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\21\67" + "\1\u0133\10\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\21\67" + "\1\u0134\10\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\30\67" + "\1\u0135\1\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\13\67" + "\1\u0136\16\67",
			"\1\67\2\uffff\13\67\6\uffff\3\67\1\u0137\26\67\4\uffff\1\67" + "\1\uffff\32\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\4\67" + "\1\u0138\25\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\2\67" + "\1\u0139\27\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\4\67" + "\1\u013a\25\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\4\67" + "\1\u013b\25\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\15\67" + "\1\u013c\14\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\4\67" + "\1\u013d\25\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\15\67" + "\1\u013e\14\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
			"\1\67\2\uffff\13\67\6\uffff\16\67\1\u013f\13\67\4\uffff\1\67" + "\1\uffff\32\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\4\67" + "\1\u0140\25\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\16\67" + "\1\u0141\13\67",
			"\1\67\2\uffff\13\67\6\uffff\4\67\1\u0142\25\67\4\uffff\1\67" + "\1\uffff\32\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\23\67" + "\1\u0143\6\67",
			"\1\67\2\uffff\13\67\6\uffff\15\67\1\u0144\14\67\4\uffff\1\67" + "\1\uffff\32\67",
			"\1\67\2\uffff\13\67\6\uffff\10\67\1\u0145\13\67\1\u0146\5\67"
					+ "\4\uffff\1\67\1\uffff\32\67",
			"\1\67\2\uffff\13\67\6\uffff\17\67\1\u0147\12\67\4\uffff\1\67" + "\1\uffff\32\67",
			"\1\67\2\uffff\13\67\6\uffff\10\67\1\u0148\13\67\1\u0149\5\67"
					+ "\4\uffff\1\67\1\uffff\32\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
			"",
			"\1\67\2\uffff\13\67\6\uffff\15\67\1\u014a\14\67\4\uffff\1\67" + "\1\uffff\32\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\25\67" + "\1\u014b\4\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\14\67" + "\1\u014c\15\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\22\67" + "\1\u014d\7\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\4\67" + "\1\u014e\25\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\1\u014f" + "\31\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\16\67" + "\1\u0150\13\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\10\67" + "\1\u0151\21\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\4\67" + "\1\u0152\25\67",
			"\1\67\2\uffff\13\67\6\uffff\24\67\1\u0153\5\67\4\uffff\1\67" + "\1\uffff\32\67",
			"\1\67\2\uffff\13\67\6\uffff\5\67\1\u0155\10\67\1\u0154\13\67"
					+ "\4\uffff\1\67\1\uffff\5\67\1\u0155\24\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\4\67" + "\1\u0156\25\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\27\67" + "\1\u0157\2\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\15\67" + "\1\u0158\14\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\23\67" + "\1\u0159\6\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\15\67" + "\1\u015a\14\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\23\67" + "\1\u015b\6\67",
			"\1\67\2\uffff\13\67\6\uffff\17\67\1\u015c\12\67\4\uffff\1\67" + "\1\uffff\32\67",
			"\1\67\2\uffff\13\67\6\uffff\5\67\1\u0155\10\67\1\u015d\13\67"
					+ "\4\uffff\1\67\1\uffff\5\67\1\u0155\24\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\15\67" + "\1\u015e\14\67",
			"\1\67\2\uffff\13\67\6\uffff\3\67\1\u015f\26\67\4\uffff\1\67" + "\1\uffff\32\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\10\67" + "\1\u0160\21\67",
			"\1\67\2\uffff\13\67\6\uffff\23\67\1\u0161\6\67\4\uffff\1\67" + "\1\uffff\32\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\15\67" + "\1\u0162\14\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\15\67" + "\1\u0163\14\67",
			"\1\67\2\uffff\13\67\6\uffff\21\67\1\u0164\10\67\4\uffff\1\67" + "\1\uffff\32\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\15\67" + "\1\u0165\14\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\15\67" + "\1\u0166\14\67",
			"\1\67\2\uffff\13\67\6\uffff\6\67\1\u0167\23\67\4\uffff\1\67" + "\1\uffff\32\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\4\67" + "\1\u0168\25\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\4\67" + "\1\u0169\25\67",
			"\1\67\2\uffff\13\67\6\uffff\16\67\1\u016a\13\67\4\uffff\1\67" + "\1\uffff\32\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\21\67" + "\1\u016b\10\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\22\67" + "\1\u016c\7\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\17\67" + "\1\u016d\12\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\2\67" + "\1\u016e\27\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\15\67" + "\1\u016f\14\67",
			"\1\67\2\uffff\13\67\6\uffff\1\u0170\31\67\4\uffff\1\67\1\uffff" + "\32\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\5\67" + "\1\u0171\24\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\24\67" + "\1\u0172\5\67",
			"\1\67\2\uffff\13\67\6\uffff\16\67\1\u0173\13\67\4\uffff\1\67"
					+ "\1\uffff\16\67\1\u0173\13\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\10\67" + "\1\u0174\21\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\23\67" + "\1\u0175\6\67",
			"\1\67\2\uffff\13\67\6\uffff\26\67\1\u0176\3\67\4\uffff\1\67" + "\1\uffff\32\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\23\67" + "\1\u0177\6\67",
			"\1\67\2\uffff\13\67\6\uffff\26\67\1\u0178\3\67\4\uffff\1\67" + "\1\uffff\32\67",
			"\1\67\2\uffff\13\67\6\uffff\4\67\1\u0179\25\67\4\uffff\1\67" + "\1\uffff\32\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\5\67" + "\1\u017a\24\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\1\u017b" + "\31\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\25\67" + "\1\u017c\4\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\23\67" + "\1\u017d\6\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\10\67" + "\1\u017e\21\67",
			"\1\67\2\uffff\13\67\6\uffff\16\67\1\u017f\13\67\4\uffff\1\67" + "\1\uffff\32\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\23\67" + "\1\u0180\6\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\10\67" + "\1\u0181\21\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
			"\1\67\2\uffff\12\67\1\u0182\6\uffff\32\67\4\uffff\1\67\1\uffff" + "\32\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\23\67" + "\1\u0183\6\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\5\67" + "\1\u0184\24\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\23\67" + "\1\u0185\6\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\22\67" + "\1\u0186\7\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\4\67" + "\1\u0187\25\67",
			"\1\67\2\uffff\12\67\1\u0188\6\uffff\32\67\4\uffff\1\67\1\uffff" + "\32\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\23\67" + "\1\u0189\6\67",
			"\1\67\2\uffff\13\67\6\uffff\13\67\1\u018a\16\67\4\uffff\1\67" + "\1\uffff\32\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\15\67" + "\1\u018b\14\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\5\67" + "\1\u018c\24\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\25\67" + "\1\u018d\4\67",
			"\1\67\2\uffff\13\67\6\uffff\5\67\1\u018e\24\67\4\uffff\1\67" + "\1\uffff\32\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\10\67" + "\1\u018f\21\67",
			"\1\67\2\uffff\13\67\6\uffff\5\67\1\u0190\24\67\4\uffff\1\67" + "\1\uffff\32\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\10\67" + "\1\u0191\21\67",
			"\1\67\2\uffff\13\67\6\uffff\21\67\1\u0192\10\67\4\uffff\1\67" + "\1\uffff\32\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\13\67" + "\1\u0193\16\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\4\67" + "\1\u0194\25\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\4\67" + "\1\u0195\25\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\16\67" + "\1\u0196\13\67",
			"\1\67\2\uffff\13\67\6\uffff\17\67\1\u0197\12\67\4\uffff\1\67" + "\1\uffff\32\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\4\67" + "\1\u0198\25\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\16\67" + "\1\u0199\13\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\21\67" + "\1\u019a\10\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\30\67" + "\1\u019b\1\67",
			"\1\67\2\uffff\13\67\6\uffff\16\67\1\u019c\13\67\4\uffff\1\67" + "\1\uffff\32\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\21\67" + "\1\u019d\10\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
			"\1\67\2\uffff\13\67\6\uffff\23\67\1\u019e\6\67\4\uffff\1\67" + "\1\uffff\32\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\2\67" + "\1\u019f\27\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\4\67" + "\1\u01a0\25\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\21\67" + "\1\u01a1\10\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\23\67" + "\1\u01a2\6\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\21\67" + "\1\u01a3\10\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\23\67" + "\1\u01a4\6\67",
			"\1\67\2\uffff\13\67\6\uffff\23\67\1\u01a5\6\67\4\uffff\1\67" + "\1\uffff\32\67",
			"\1\67\2\uffff\12\67\1\u01a6\6\uffff\32\67\4\uffff\1\67\1\uffff" + "\32\67",
			"\1\67\2\uffff\12\67\1\u01a7\6\uffff\32\67\4\uffff\1\67\1\uffff" + "\32\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\21\67" + "\1\u01a8\10\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\15\67" + "\1\u01a9\14\67",
			"\1\67\2\uffff\13\67\6\uffff\4\67\1\u01aa\25\67\4\uffff\1\67" + "\1\uffff\32\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\21\67" + "\1\u01ab\10\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\15\67" + "\1\u01ac\14\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\10\67" + "\1\u01ad\21\67",
			"\1\67\2\uffff\13\67\6\uffff\16\67\1\u01ae\13\67\4\uffff\1\67" + "\1\uffff\32\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\5\67" + "\1\u01af\24\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\23\67" + "\1\u01b0\6\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\16\67" + "\1\u01b1\13\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\23\67" + "\1\u01b2\6\67",
			"\1\67\2\uffff\12\67\1\u01b3\6\uffff\32\67\4\uffff\1\67\1\uffff" + "\32\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\16\67" + "\1\u01b4\13\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\7\67" + "\1\u01b5\22\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\16\67" + "\1\u01b6\13\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\7\67" + "\1\u01b7\22\67",
			"\1\67\2\uffff\13\67\6\uffff\30\67\1\u01b8\1\67\4\uffff\1\67" + "\1\uffff\32\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\22\67" + "\1\u01b9\7\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
			"\1\67\2\uffff\13\67\6\uffff\21\67\1\u01ba\10\67\4\uffff\1\67" + "\1\uffff\32\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\22\67" + "\1\u01bb\7\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\2\67" + "\1\u01bc\27\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\5\67" + "\1\u01bd\24\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\30\67" + "\1\u01be\1\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\10\67" + "\1\u01bf\21\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\14\67" + "\1\u01c0\15\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\14\67" + "\1\u01c1\15\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\4\67" + "\1\u01c2\25\67",
			"\1\67\2\uffff\13\67\6\uffff\23\67\1\u01c3\6\67\4\uffff\1\67" + "\1\uffff\32\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\4\67" + "\1\u01c4\25\67",
			"\1\67\2\uffff\12\67\1\u01c5\6\uffff\32\67\4\uffff\1\67\1\uffff" + "\32\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
			"\1\67\2\uffff\13\67\6\uffff\16\67\1\u01c6\13\67\4\uffff\1\67" + "\1\uffff\32\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\16\67" + "\1\u01c7\13\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\2\67" + "\1\u01c8\27\67",
			"\1\67\2\uffff\13\67\6\uffff\30\67\1\u01c9\1\67\4\uffff\1\67" + "\1\uffff\32\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\2\67" + "\1\u01ca\27\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\5\67" + "\1\u01cb\24\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\15\67" + "\1\u01cc\14\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\23\67" + "\1\u01cd\6\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\23\67" + "\1\u01ce\6\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\1\u01cf" + "\31\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\10\67" + "\1\u01d0\21\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\10\67" + "\1\u01d1\21\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\13\67" + "\1\u01d2\16\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\16\67" + "\1\u01d3\13\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\16\67" + "\1\u01d4\13\67",
			"\1\67\2\uffff\12\67\1\u01d5\6\uffff\32\67\4\uffff\1\67\1\uffff" + "\32\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\15\67" + "\1\u01d6\14\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\15\67" + "\1\u01d7\14\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
			"\1\67\2\uffff\13\67\6\uffff\32\67\4\uffff\1\67\1\uffff\32\67" };
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
				int LA1_160 = input.LA(1);
				s = -1;
				if (LA1_160 == '\'') {
					s = 100;
				} else if (LA1_160 >= '\u0000' && LA1_160 <= '&' || LA1_160 >= '('
						&& LA1_160 <= '\uFFFF') {
					s = 99;
				}
				if (s >= 0) {
					return s;
				}
				break;
			case 1:
				int LA1_99 = input.LA(1);
				s = -1;
				if (LA1_99 == '\'') {
					s = 100;
				} else if (LA1_99 >= '\u0000' && LA1_99 <= '&' || LA1_99 >= '('
						&& LA1_99 <= '\uFFFF') {
					s = 99;
				}
				if (s >= 0) {
					return s;
				}
				break;
			case 2:
				int LA1_156 = input.LA(1);
				s = -1;
				if (LA1_156 == '\"') {
					s = 95;
				} else if (LA1_156 >= '\u0000' && LA1_156 <= '!' || LA1_156 >= '#'
						&& LA1_156 <= '\uFFFF') {
					s = 94;
				}
				if (s >= 0) {
					return s;
				}
				break;
			case 3:
				int LA1_34 = input.LA(1);
				s = -1;
				if (LA1_34 >= '\u0000' && LA1_34 <= '!' || LA1_34 >= '#' && LA1_34 <= '\uFFFF') {
					s = 94;
				} else if (LA1_34 == '\"') {
					s = 95;
				}
				if (s >= 0) {
					return s;
				}
				break;
			case 4:
				int LA1_94 = input.LA(1);
				s = -1;
				if (LA1_94 == '\"') {
					s = 95;
				} else if (LA1_94 >= '\u0000' && LA1_94 <= '!' || LA1_94 >= '#'
						&& LA1_94 <= '\uFFFF') {
					s = 94;
				}
				if (s >= 0) {
					return s;
				}
				break;
			case 5:
				int LA1_37 = input.LA(1);
				s = -1;
				if (LA1_37 >= '\u0000' && LA1_37 <= '&' || LA1_37 >= '(' && LA1_37 <= '\uFFFF') {
					s = 99;
				} else if (LA1_37 == '\'') {
					s = 100;
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