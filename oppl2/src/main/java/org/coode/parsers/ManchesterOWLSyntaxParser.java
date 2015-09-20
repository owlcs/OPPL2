// $ANTLR 3.2 Sep 23, 2009 12:02:23 /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntax.g 2011-02-03 18:49:27
package org.coode.parsers;

import static org.coode.oppl.utils.ArgCheck.checkNotNull;

import org.antlr.runtime.*;
import org.antlr.runtime.tree.CommonTreeAdaptor;
import org.antlr.runtime.tree.RewriteEmptyStreamException;
import org.antlr.runtime.tree.RewriteRuleSubtreeStream;
import org.antlr.runtime.tree.TreeAdaptor;

@SuppressWarnings("javadoc")
public class ManchesterOWLSyntaxParser extends Parser {

    public static final String[] tokenNames = new String[] { "<invalid>", "<EOR>",
        "<DOWN>", "<UP>", "COMPOSITION", "OPEN_PARENTHESYS", "OPEN_CURLY_BRACES",
        "CLOSED_CURLY_BRACES", "CLOSED_PARENTHESYS", "WHITESPACE", "AND", "OR",
        "NOT", "SOME", "ONLY", "MIN", "MAX", "EXACTLY", "VALUE", "INVERSE",
        "SUBCLASS_OF", "SUB_PROPERTY_OF", "EQUIVALENT_TO", "SAME_AS",
        "DIFFERENT_FROM", "INVERSE_OF", "DISJOINT_WITH", "DOMAIN", "RANGE",
        "FUNCTIONAL", "SYMMETRIC", "ANTI_SYMMETRIC", "REFLEXIVE", "IRREFLEXIVE",
        "TRANSITIVE", "INVERSE_FUNCTIONAL", "POW", "COMMA", "INSTANCE_OF", "TYPES",
        "DBLQUOTE", "DIGIT", "INTEGER", "LETTER", "IDENTIFIER", "ENTITY_REFERENCE",
        "QUESTION_MARK", "Tokens", "SUB_CLASS_AXIOM", "EQUIVALENT_TO_AXIOM",
        "DISJOINT_WITH_AXIOM", "SUB_PROPERTY_AXIOM", "SAME_AS_AXIOM",
        "DIFFERENT_FROM_AXIOM", "UNARY_AXIOM", "DISJUNCTION", "CONJUNCTION",
        "PROPERTY_CHAIN", "NEGATED_EXPRESSION", "NEGATED_ASSERTION",
        "INVERSE_PROPERTY", "SOME_RESTRICTION", "ALL_RESTRICTION",
        "VALUE_RESTRICTION", "CARDINALITY_RESTRICTION", "ONE_OF", "TYPE_ASSERTION",
        "ROLE_ASSERTION", "INVERSE_OBJECT_PROPERTY_EXPRESSION", "EXPRESSION",
        "CONSTANT", "WHERE", "NOT_EQUAL", "EQUAL", "IN", "SELECT", "ASSERTED",
        "COLON", "DOT", "PLUS", "CREATE", "CREATE_INTERSECTION",
        "CREATE_DISJUNCTION", "BEGIN", "END", "OPEN_SQUARE_BRACKET",
        "CLOSED_SQUARE_BRACKET", "SUPER_CLASS_OF", "SUPER_PROPERTY_OF",
        "VARIABLE_TYPE", "ADD", "REMOVE", "ASSERTED_CLAUSE", "PLAIN_CLAUSE",
        "INEQUALITY_CONSTRAINT", "IN_SET_CONSTRAINT", "INPUT_VARIABLE_DEFINITION",
        "GENERATED_VARIABLE_DEFINITION", "CREATE_OPPL_FUNCTION",
        "VARIABLE_ATTRIBUTE", "OPPL_FUNCTION", "ACTIONS", "VARIABLE_DEFINITIONS",
        "QUERY", "VARIABLE_SCOPE", "SUBPROPERTY_OF", "VARIABLE_IDENTIFIER",
        "OPPL_STATEMENT", "DATA_RANGE", "HAS_KEY", "IRI", "ANNOTATION_ASSERTION",
        "AT", "ESCLAMATION_MARK", "CREATE_IDENTIFIER", "PLAIN_IDENTIFIER", "MATCH",
        "ATTRIBUTE_SELECTOR", "LESS_THAN", "LESS_THAN_EQUAL", "GREATER_THAN",
        "GREATER_THAN_EQUAL", "487", "488", "489", "490", "491", "492", "493", "494",
        "495", "496", "497", "498", "499", "500", "501", "502", "503", "504", "505",
        "506", "507", "508", "509", "510", "511", "512", "513", "514", "515", "516",
        "517", "518", "519", "520", "521", "522", "523", "524", "525", "526", "527",
        "528", "529", "530", "531", "532", "533", "534", "535", "536", "537", "538",
        "539", "540", "541", "542", "543", "544", "545", "546", "547", "548", "549",
        "550", "551", "552", "553", "554", "555", "556", "557", "558", "559", "560",
        "561", "562", "563" };
    public static final int HAS_KEY = 109;
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
    public static final int ACTIONS = 101;
    public static final int CREATE_IDENTIFIER = 151;
    public static final int CREATE = 80;
    public static final int POW = 36;
    public static final int INPUT_VARIABLE_DEFINITION = 96;
    public static final int NOT_EQUAL = 72;
    public static final int INVERSE_OBJECT_PROPERTY_EXPRESSION = 68;
    public static final int INSTANCE_OF = 38;
    public static final int BEGIN = 83;
    public static final int QUESTION_MARK = 46;
    public static final int INEQUALITY_CONSTRAINT = 94;
    public static final int VARIABLE_SCOPE = 104;
    public static final int SYMMETRIC = 30;
    public static final int CARDINALITY_RESTRICTION = 64;
    public static final int SELECT = 75;
    public static final int ROLE_ASSERTION = 67;
    public static final int DIFFERENT_FROM_AXIOM = 53;
    public static final int CREATE_OPPL_FUNCTION = 98;
    public static final int ANTI_SYMMETRIC = 31;
    public static final int TRANSITIVE = 34;
    public static final int GREATER_THAN_EQUAL = 486;
    public static final int ALL_RESTRICTION = 62;
    public static final int CONJUNCTION = 56;
    public static final int OPPL_STATEMENT = 107;
    public static final int NEGATED_ASSERTION = 59;
    public static final int WHITESPACE = 9;
    public static final int IN_SET_CONSTRAINT = 95;
    public static final int MATCH = 176;
    public static final int VALUE = 18;
    public static final int OPEN_CURLY_BRACES = 6;
    public static final int DISJUNCTION = 55;
    public static final int INVERSE = 19;
    public static final int DBLQUOTE = 40;
    public static final int OR = 11;
    public static final int LESS_THAN = 483;
    public static final int CONSTANT = 70;
    public static final int QUERY = 103;
    public static final int ENTITY_REFERENCE = 45;
    public static final int END = 84;
    public static final int COMPOSITION = 4;
    public static final int ANNOTATION_ASSERTION = 111;
    public static final int CLOSED_SQUARE_BRACKET = 86;
    public static final int SAME_AS = 23;
    public static final int WHERE = 71;
    public static final int DISJOINT_WITH = 26;
    public static final int SUPER_PROPERTY_OF = 88;
    public static final int VARIABLE_TYPE = 89;
    public static final int ATTRIBUTE_SELECTOR = 283;
    public static final int CLOSED_PARENTHESYS = 8;
    public static final int ONLY = 14;
    public static final int EQUIVALENT_TO_AXIOM = 49;
    public static final int SUB_PROPERTY_OF = 21;
    public static final int NEGATED_EXPRESSION = 58;
    public static final int MAX = 16;
    public static final int CREATE_DISJUNCTION = 82;
    public static final int AND = 10;
    public static final int ASSERTED_CLAUSE = 92;
    public static final int INVERSE_PROPERTY = 60;
    public static final int AT = 114;
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
    public static final int GENERATED_VARIABLE_DEFINITION = 97;
    public static final int OPEN_SQUARE_BRACKET = 85;
    public static final int SUB_PROPERTY_AXIOM = 51;
    public static final int EXACTLY = 17;
    public static final int RANGE = 28;
    public static final int ONE_OF = 65;
    public static final int DATA_RANGE = 108;
    public static final int VARIABLE_DEFINITIONS = 102;
    public static final int SUB_CLASS_AXIOM = 48;
    public static final int MIN = 15;
    public static final int PLAIN_CLAUSE = 93;
    public static final int Tokens = 47;
    public static final int DOMAIN = 27;
    public static final int SUBPROPERTY_OF = 105;
    public static final int COLON = 77;
    public static final int OPPL_FUNCTION = 100;
    public static final int DISJOINT_WITH_AXIOM = 50;
    public static final int CREATE_INTERSECTION = 81;
    public static final int INVERSE_FUNCTIONAL = 35;
    public static final int VARIABLE_IDENTIFIER = 106;
    public static final int IRREFLEXIVE = 33;
    public static final int ASSERTED = 76;
    public static final int VARIABLE_ATTRIBUTE = 99;
    public static final int PLAIN_IDENTIFIER = 152;
    public static final int LESS_THAN_EQUAL = 484;
    public static final int PROPERTY_CHAIN = 57;
    public static final int FUNCTIONAL = 29;
    public static final int TYPE_ASSERTION = 66;
    // delegates
    public ManchesterOWLSyntax_MOWLParser gMOWLParser;

    // delegators
    public ManchesterOWLSyntaxParser(TokenStream input) {
        this(input, new RecognizerSharedState());
    }

    public ManchesterOWLSyntaxParser(TokenStream input, RecognizerSharedState state) {
        super(input, state);
        gMOWLParser = new ManchesterOWLSyntax_MOWLParser(input, state, this);
    }

    protected TreeAdaptor adaptor = new CommonTreeAdaptor();

    public void setTreeAdaptor(TreeAdaptor adaptor) {
        this.adaptor = adaptor;
        gMOWLParser.setTreeAdaptor(this.adaptor);
    }

    public TreeAdaptor getTreeAdaptor() {
        return adaptor;
    }

    @Override
    public String[] getTokenNames() {
        return ManchesterOWLSyntaxParser.tokenNames;
    }

    @Override
    public String getGrammarFileName() {
        return "/Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntax.g";
    }

    private ErrorListener errorListener;

    public ManchesterOWLSyntaxParser(TokenStream input, ErrorListener errorListener) {
        this(input, new RecognizerSharedState(), errorListener);
    }

    public ManchesterOWLSyntaxParser(TokenStream input, RecognizerSharedState state,
        ErrorListener errorListener) {
        this(input, state);
        this.errorListener = checkNotNull(errorListener, "errorListener");
    }

    public ErrorListener getErrorListener() {
        return errorListener;
    }

    @Override
    public void displayRecognitionError(String[] t, RecognitionException e) {
        getErrorListener().recognitionException(e, t);
    }

    protected void mismatch(IntStream in, int ttype,
        @SuppressWarnings("unused") BitSet follow) throws RecognitionException {
        throw new MismatchedTokenException(ttype, in);
    }

    @Override
    public Object recoverFromMismatchedSet(IntStream in, RecognitionException e,
        BitSet follow) throws RecognitionException {
        throw e;
    }

    public static class main_return extends ParserRuleReturnScope {

        ManchesterOWLSyntaxTree tree;

        @Override
        public Object getTree() {
            return tree;
        }
    }

    // $ANTLR start "main"
    // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntax.g:66:1:
    // main : axiom -> ^( axiom ) ;
    public final ManchesterOWLSyntaxParser.main_return main() {
        ManchesterOWLSyntaxParser.main_return retval = new ManchesterOWLSyntaxParser.main_return();
        retval.start = input.LT(1);
        ManchesterOWLSyntaxTree root_0 = null;
        ManchesterOWLSyntax_MOWLParser.axiom_return axiom1 = null;
        RewriteRuleSubtreeStream stream_axiom = new RewriteRuleSubtreeStream(adaptor,
            "rule axiom");
        try {
            // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntax.g:66:5:
            // ( axiom -> ^( axiom ) )
            // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntax.g:67:3:
            // axiom
            {
                pushFollow(FOLLOW_axiom_in_main100);
                axiom1 = axiom();
                state._fsp--;
                if (state.failed) {
                    return retval;
                }
                if (state.backtracking == 0) {
                    stream_axiom.add(axiom1.getTree());
                }
                // AST REWRITE
                // elements: axiom
                // token labels:
                // rule labels: retval
                // token list labels:
                // rule list labels:
                // wildcard labels:
                if (state.backtracking == 0) {
                    retval.tree = root_0;
                    root_0 = (ManchesterOWLSyntaxTree) adaptor.nil();
                    // 67:9: -> ^( axiom )
                    {
                        // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntax.g:67:11:
                        // ^( axiom )
                        {
                            ManchesterOWLSyntaxTree root_1 = (ManchesterOWLSyntaxTree) adaptor
                                .nil();
                            root_1 = (ManchesterOWLSyntaxTree) adaptor.becomeRoot(
                                stream_axiom.nextNode(), root_1);
                            adaptor.addChild(root_0, root_1);
                        }
                    }
                    retval.tree = root_0;
                }
            }
            retval.stop = input.LT(-1);
            if (state.backtracking == 0) {
                retval.tree = (ManchesterOWLSyntaxTree) adaptor
                    .rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        } catch (RecognitionException e) {
            if (errorListener != null) {
                errorListener.recognitionException(e);
            }
        } catch (RewriteEmptyStreamException e) {
            if (errorListener != null) {
                errorListener.rewriteEmptyStreamException(e);
            }
        }
        return retval;
    }

    // $ANTLR end "main"
    // Delegated rules
    public ManchesterOWLSyntax_MOWLParser.complexPropertyExpression_return complexPropertyExpression()
        throws RecognitionException {
        return gMOWLParser.complexPropertyExpression();
    }

    public ManchesterOWLSyntax_MOWLParser.qualifiedRestriction_return qualifiedRestriction()
        throws RecognitionException {
        return gMOWLParser.qualifiedRestriction();
    }

    public ManchesterOWLSyntax_MOWLParser.binaryAxiom_return binaryAxiom()
        throws RecognitionException {
        return gMOWLParser.binaryAxiom();
    }

    public ManchesterOWLSyntax_MOWLParser.oneOf_return oneOf()
        throws RecognitionException {
        return gMOWLParser.oneOf();
    }

    public ManchesterOWLSyntax_MOWLParser.hasKeyAxiom_return hasKeyAxiom()
        throws RecognitionException {
        return gMOWLParser.hasKeyAxiom();
    }

    public ManchesterOWLSyntax_MOWLParser.atomic_return atomic()
        throws RecognitionException {
        return gMOWLParser.atomic();
    }

    public ManchesterOWLSyntax_MOWLParser.disjunction_return disjunction()
        throws RecognitionException {
        return gMOWLParser.disjunction();
    }

    public ManchesterOWLSyntax_MOWLParser.assertionAxiom_return assertionAxiom()
        throws RecognitionException {
        return gMOWLParser.assertionAxiom();
    }

    public ManchesterOWLSyntax_MOWLParser.valueRestriction_return valueRestriction()
        throws RecognitionException {
        return gMOWLParser.valueRestriction();
    }

    public ManchesterOWLSyntax_MOWLParser.cardinalityRestriction_return cardinalityRestriction()
        throws RecognitionException {
        return gMOWLParser.cardinalityRestriction();
    }

    public ManchesterOWLSyntax_MOWLParser.unaryCharacteristic_return unaryCharacteristic() throws RecognitionException {
        return gMOWLParser.unaryCharacteristic();
    }

    public ManchesterOWLSyntax_MOWLParser.iri_return iri() throws RecognitionException {
        return gMOWLParser.iri();
    }

    public ManchesterOWLSyntax_MOWLParser.dataRangeFacet_return dataRangeFacet()
        throws RecognitionException {
        return gMOWLParser.dataRangeFacet();
    }

    public ManchesterOWLSyntax_MOWLParser.constant_return constant()
        throws RecognitionException {
        return gMOWLParser.constant();
    }

    public ManchesterOWLSyntax_MOWLParser.axiom_return axiom()
        throws RecognitionException {
        return gMOWLParser.axiom();
    }

    public ManchesterOWLSyntax_MOWLParser.expression_return expression()
        throws RecognitionException {
        return gMOWLParser.expression();
    }

    public ManchesterOWLSyntax_MOWLParser.restrictionKind_return restrictionKind()
        throws RecognitionException {
        return gMOWLParser.restrictionKind();
    }

    public ManchesterOWLSyntax_MOWLParser.propertyExpression_return propertyExpression()
        throws RecognitionException {
        return gMOWLParser.propertyExpression();
    }

    public ManchesterOWLSyntax_MOWLParser.value_return value()
        throws RecognitionException {
        return gMOWLParser.value();
    }

    public ManchesterOWLSyntax_MOWLParser.unary_return unary()
        throws RecognitionException {
        return gMOWLParser.unary();
    }

    public ManchesterOWLSyntax_MOWLParser.unaryAxiom_return unaryAxiom()
        throws RecognitionException {
        return gMOWLParser.unaryAxiom();
    }

    public ManchesterOWLSyntax_MOWLParser.dataRange_return dataRange()
        throws RecognitionException {
        return gMOWLParser.dataRange();
    }

    public ManchesterOWLSyntax_MOWLParser.annotationAssertionAxiom_return annotationAssertionAxiom()
        throws RecognitionException {
        return gMOWLParser.annotationAssertionAxiom();
    }

    public ManchesterOWLSyntax_MOWLParser.conjunction_return conjunction()
        throws RecognitionException {
        return gMOWLParser.conjunction();
    }

    public static final BitSet FOLLOW_axiom_in_main100 = new BitSet(
        new long[] { 0x0000000000000002L });
}
