// $ANTLR 3.2 Sep 23, 2009 12:02:23 /Users/luigi/Documents/workspace/Parsers/src/OPPLScript.g 2011-07-22 11:03:23
package org.coode.parsers.oppl;

import static org.coode.oppl.utils.ArgCheck.checkNotNull;

import org.antlr.runtime.*;
import org.antlr.runtime.tree.CommonTreeAdaptor;
import org.antlr.runtime.tree.RewriteEmptyStreamException;
import org.antlr.runtime.tree.RewriteRuleSubtreeStream;
import org.antlr.runtime.tree.TreeAdaptor;
import org.coode.parsers.ErrorListener;

@SuppressWarnings({ "javadoc", "incomplete-switch" })
public class OPPLScriptParser extends Parser {

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
        "OPPL_STATEMENT", "HAS_KEY", "IRI", "ANNOTATION_ASSERTION",
        "IRI_ATTRIBUTE_NAME", "AT", "SET", "DISJOINT_CLASSES", "DISJOINT_PROPERTIES",
        "SAME_INDIVIDUAL", "DIFFERENT_INDIVIDUALS", "TO_LOWER_CASE", "TO_UPPER_CASE",
        "ESCLAMATION_MARK", "MATCH", "ATTRIBUTE_SELECTOR", "VALUES", "RENDERING",
        "GROUPS", "STRING_OPERATION", "VARIABLE_NAME", "REGEXP_CONSTRAINT", "FAIL",
        "NAF_CONSTRAINT", "LESS_THAN", "LESS_THAN_EQUAL", "GREATER_THAN",
        "GREATER_THAN_EQUAL", "DATA_RANGE", "591", "592", "593", "594", "595", "596",
        "597", "598", "599", "600", "601", "602", "603", "604", "605", "606", "607",
        "608", "609", "610", "611", "612", "613", "614", "615", "616" };
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
    public static final int CREATE = 80;
    public static final int POW = 36;
    public static final int INPUT_VARIABLE_DEFINITION = 96;
    public static final int NOT_EQUAL = 72;
    public static final int INVERSE_OBJECT_PROPERTY_EXPRESSION = 68;
    public static final int INSTANCE_OF = 38;
    public static final int BEGIN = 83;
    public static final int VARIABLE_SCOPE = 104;
    public static final int INEQUALITY_CONSTRAINT = 94;
    public static final int QUESTION_MARK = 46;
    public static final int DISJOINT_PROPERTIES = 117;
    public static final int SYMMETRIC = 30;
    public static final int CARDINALITY_RESTRICTION = 64;
    public static final int SELECT = 75;
    public static final int ROLE_ASSERTION = 67;
    public static final int DIFFERENT_FROM_AXIOM = 53;
    public static final int TO_LOWER_CASE = 120;
    public static final int CREATE_OPPL_FUNCTION = 98;
    public static final int TRANSITIVE = 34;
    public static final int ANTI_SYMMETRIC = 31;
    public static final int GREATER_THAN_EQUAL = 486;
    public static final int ALL_RESTRICTION = 62;
    public static final int CONJUNCTION = 56;
    public static final int OPPL_STATEMENT = 107;
    public static final int NEGATED_ASSERTION = 59;
    public static final int WHITESPACE = 9;
    public static final int MATCH = 176;
    public static final int IN_SET_CONSTRAINT = 95;
    public static final int VALUE = 18;
    public static final int FAIL = 466;
    public static final int GROUPS = 356;
    public static final int OPEN_CURLY_BRACES = 6;
    public static final int DISJUNCTION = 55;
    public static final int INVERSE = 19;
    public static final int NAF_CONSTRAINT = 467;
    public static final int DBLQUOTE = 40;
    public static final int STRING_OPERATION = 394;
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
    public static final int DIFFERENT_INDIVIDUALS = 119;
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
    public static final int TO_UPPER_CASE = 121;
    public static final int CREATE_DISJUNCTION = 82;
    public static final int AND = 10;
    public static final int ASSERTED_CLAUSE = 92;
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
    public static final int GENERATED_VARIABLE_DEFINITION = 97;
    public static final int EXACTLY = 17;
    public static final int SUB_PROPERTY_AXIOM = 51;
    public static final int OPEN_SQUARE_BRACKET = 85;
    public static final int VALUES = 354;
    public static final int REGEXP_CONSTRAINT = 465;
    public static final int RANGE = 28;
    public static final int DATA_RANGE = 590;
    public static final int SET = 115;
    public static final int ONE_OF = 65;
    public static final int VARIABLE_DEFINITIONS = 102;
    public static final int MIN = 15;
    public static final int SUB_CLASS_AXIOM = 48;
    public static final int PLAIN_CLAUSE = 93;
    public static final int Tokens = 47;
    public static final int DOMAIN = 27;
    public static final int SUBPROPERTY_OF = 105;
    public static final int OPPL_FUNCTION = 100;
    public static final int COLON = 77;
    public static final int DISJOINT_WITH_AXIOM = 50;
    public static final int CREATE_INTERSECTION = 81;
    public static final int INVERSE_FUNCTIONAL = 35;
    public static final int RENDERING = 355;
    public static final int VARIABLE_IDENTIFIER = 106;
    public static final int IRI_ATTRIBUTE_NAME = 112;
    public static final int IRREFLEXIVE = 33;
    public static final int LESS_THAN_EQUAL = 484;
    public static final int VARIABLE_ATTRIBUTE = 99;
    public static final int ASSERTED = 76;
    public static final int FUNCTIONAL = 29;
    public static final int PROPERTY_CHAIN = 57;
    public static final int TYPE_ASSERTION = 66;
    public static final int DISJOINT_CLASSES = 116;
    // delegates
    public OPPLScript_OPPLParser_MOWLParser gMOWLParser;
    public OPPLScript_OPPLParser gOPPLParser;

    // delegators
    public OPPLScriptParser(TokenStream input) {
        this(input, new RecognizerSharedState());
    }

    public OPPLScriptParser(TokenStream input, RecognizerSharedState state) {
        super(input, state);
        gOPPLParser = new OPPLScript_OPPLParser(input, state, this);
        gMOWLParser = gOPPLParser.gMOWLParser;
    }

    protected TreeAdaptor adaptor = new CommonTreeAdaptor();

    public void setTreeAdaptor(TreeAdaptor adaptor) {
        this.adaptor = adaptor;
        gOPPLParser.setTreeAdaptor(this.adaptor);
    }

    public TreeAdaptor getTreeAdaptor() {
        return adaptor;
    }

    @Override
    public String[] getTokenNames() {
        return OPPLScriptParser.tokenNames;
    }

    @Override
    public String getGrammarFileName() {
        return "/Users/luigi/Documents/workspace/Parsers/src/OPPLScript.g";
    }

    private ErrorListener errorListener;

    public OPPLScriptParser(TokenStream input, ErrorListener errorListener) {
        this(input);
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

    public static class statement_return extends ParserRuleReturnScope {

        OPPLSyntaxTree tree;

        @Override
        public Object getTree() {
            return tree;
        }
    }

    // $ANTLR start "statement"
    // /Users/luigi/Documents/workspace/Parsers/src/OPPLScript.g:77:1: statement
    // : ( variableDefinitions )? ( query )? actions -> ^( OPPL_STATEMENT (
    // variableDefinitions )? ( query )? actions ) ;
    public final OPPLScriptParser.statement_return statement() {
        OPPLScriptParser.statement_return retval = new OPPLScriptParser.statement_return();
        retval.start = input.LT(1);
        OPPLSyntaxTree root_0 = null;
        OPPLScript_OPPLParser.variableDefinitions_return variableDefinitions1 = null;
        OPPLScript_OPPLParser.query_return query2 = null;
        OPPLScript_OPPLParser.actions_return actions3 = null;
        RewriteRuleSubtreeStream stream_query = new RewriteRuleSubtreeStream(adaptor,
            "rule query");
        RewriteRuleSubtreeStream stream_variableDefinitions = new RewriteRuleSubtreeStream(
            adaptor, "rule variableDefinitions");
        RewriteRuleSubtreeStream stream_actions = new RewriteRuleSubtreeStream(adaptor,
            "rule actions");
        try {
            // /Users/luigi/Documents/workspace/Parsers/src/OPPLScript.g:78:3: (
            // ( variableDefinitions )? ( query )? actions -> ^( OPPL_STATEMENT
            // ( variableDefinitions )? ( query )? actions ) )
            // /Users/luigi/Documents/workspace/Parsers/src/OPPLScript.g:79:5: (
            // variableDefinitions )? ( query )? actions
            {
                // /Users/luigi/Documents/workspace/Parsers/src/OPPLScript.g:79:5:
                // ( variableDefinitions )?
                int alt1 = 2;
                int LA1_0 = input.LA(1);
                if (LA1_0 == VARIABLE_NAME) {
                    alt1 = 1;
                }
                switch (alt1) {
                    case 1:
                    // /Users/luigi/Documents/workspace/Parsers/src/OPPLScript.g:0:0:
                    // variableDefinitions
                    {
                        pushFollow(FOLLOW_variableDefinitions_in_statement112);
                        variableDefinitions1 = variableDefinitions();
                        state._fsp--;
                        if (state.failed) {
                            return retval;
                        }
                        if (state.backtracking == 0) {
                            stream_variableDefinitions
                                .add(variableDefinitions1.getTree());
                        }
                    }
                        break;
                }
                // /Users/luigi/Documents/workspace/Parsers/src/OPPLScript.g:79:26:
                // ( query )?
                int alt2 = 2;
                int LA2_0 = input.LA(1);
                if (LA2_0 == SELECT) {
                    alt2 = 1;
                }
                switch (alt2) {
                    case 1:
                    // /Users/luigi/Documents/workspace/Parsers/src/OPPLScript.g:0:0:
                    // query
                    {
                        pushFollow(FOLLOW_query_in_statement115);
                        query2 = query();
                        state._fsp--;
                        if (state.failed) {
                            return retval;
                        }
                        if (state.backtracking == 0) {
                            stream_query.add(query2.getTree());
                        }
                    }
                        break;
                }
                pushFollow(FOLLOW_actions_in_statement118);
                actions3 = actions();
                state._fsp--;
                if (state.failed) {
                    return retval;
                }
                if (state.backtracking == 0) {
                    stream_actions.add(actions3.getTree());
                }
                // AST REWRITE
                // elements: variableDefinitions, actions, query
                // token labels:
                // rule labels: retval
                // token list labels:
                // rule list labels:
                // wildcard labels:
                if (state.backtracking == 0) {
                    retval.tree = root_0;
                    root_0 = (OPPLSyntaxTree) adaptor.nil();
                    // 79:41: -> ^( OPPL_STATEMENT ( variableDefinitions )? (
                    // query )? actions )
                    {
                        // /Users/luigi/Documents/workspace/Parsers/src/OPPLScript.g:79:44:
                        // ^( OPPL_STATEMENT ( variableDefinitions )? ( query )?
                        // actions )
                        {
                            OPPLSyntaxTree root_1 = (OPPLSyntaxTree) adaptor.nil();
                            root_1 = (OPPLSyntaxTree) adaptor.becomeRoot(
                                adaptor.create(OPPL_STATEMENT, "OPPL_STATEMENT"),
                                root_1);
                            // /Users/luigi/Documents/workspace/Parsers/src/OPPLScript.g:79:61:
                            // ( variableDefinitions )?
                            if (stream_variableDefinitions.hasNext()) {
                                adaptor.addChild(root_1,
                                    stream_variableDefinitions.nextTree());
                            }
                            stream_variableDefinitions.reset();
                            // /Users/luigi/Documents/workspace/Parsers/src/OPPLScript.g:79:82:
                            // ( query )?
                            if (stream_query.hasNext()) {
                                adaptor.addChild(root_1, stream_query.nextTree());
                            }
                            stream_query.reset();
                            adaptor.addChild(root_1, stream_actions.nextTree());
                            adaptor.addChild(root_0, root_1);
                        }
                    }
                    retval.tree = root_0;
                }
            }
            retval.stop = input.LT(-1);
            if (state.backtracking == 0) {
                retval.tree = (OPPLSyntaxTree) adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        } catch (RecognitionException exception) {
            if (errorListener != null) {
                errorListener.recognitionException(exception);
            }
        } catch (RewriteEmptyStreamException exception) {
            if (errorListener != null) {
                errorListener.rewriteEmptyStreamException(exception);
            }
        }
        return retval;
    }

    // $ANTLR end "statement"
    // Delegated rules
    public OPPLScript_OPPLParser.iri_return iri() throws RecognitionException {
        return gOPPLParser.iri();
    }

    public OPPLScript_OPPLParser_MOWLParser.annotationAssertionAxiom_return annotationAssertionAxiom()
        throws RecognitionException {
        return gMOWLParser.annotationAssertionAxiom();
    }

    public OPPLScript_OPPLParser_MOWLParser.binaryAxiom_return binaryAxiom()
        throws RecognitionException {
        return gMOWLParser.binaryAxiom();
    }

    public OPPLScript_OPPLParser.stringOperation_return stringOperation()
        throws RecognitionException {
        return gOPPLParser.stringOperation();
    }

    public OPPLScript_OPPLParser_MOWLParser.constant_return constant()
        throws RecognitionException {
        return gMOWLParser.constant();
    }

    public OPPLScript_OPPLParser_MOWLParser.cardinalityRestriction_return cardinalityRestriction()
        throws RecognitionException {
        return gMOWLParser.cardinalityRestriction();
    }

    public OPPLScript_OPPLParser_MOWLParser.unary_return unary()
        throws RecognitionException {
        return gMOWLParser.unary();
    }

    public OPPLScript_OPPLParser_MOWLParser.unaryAxiom_return unaryAxiom()
        throws RecognitionException {
        return gMOWLParser.unaryAxiom();
    }

    public OPPLScript_OPPLParser_MOWLParser.expression_return expression()
        throws RecognitionException {
        return gMOWLParser.expression();
    }

    public OPPLScript_OPPLParser_MOWLParser.conjunction_return conjunction()
        throws RecognitionException {
        return gMOWLParser.conjunction();
    }

    public OPPLScript_OPPLParser_MOWLParser.oneOf_return oneOf()
        throws RecognitionException {
        return gMOWLParser.oneOf();
    }

    public OPPLScript_OPPLParser_MOWLParser.assertionAxiom_return assertionAxiom()
        throws RecognitionException {
        return gMOWLParser.assertionAxiom();
    }

    public OPPLScript_OPPLParser.variableScope_return variableScope()
        throws RecognitionException {
        return gOPPLParser.variableScope();
    }

    public OPPLScript_OPPLParser.simpleStringExpression_return simpleStringExpression()
        throws RecognitionException {
        return gOPPLParser.simpleStringExpression();
    }

    public OPPLScript_OPPLParser.createIdentifier_return createIdentifier()
        throws RecognitionException {
        return gOPPLParser.createIdentifier();
    }

    public OPPLScript_OPPLParser.variableDefinition_return variableDefinition()
        throws RecognitionException {
        return gOPPLParser.variableDefinition();
    }

    public OPPLScript_OPPLParser.opplFunction_return opplFunction()
        throws RecognitionException {
        return gOPPLParser.opplFunction();
    }

    public OPPLScript_OPPLParser.constraint_return constraint()
        throws RecognitionException {
        return gOPPLParser.constraint();
    }

    public OPPLScript_OPPLParser.variableAttributeReference_return variableAttributeReference()
        throws RecognitionException {
        return gOPPLParser.variableAttributeReference();
    }

    public OPPLScript_OPPLParser.action_return action() throws RecognitionException {
        return gOPPLParser.action();
    }

    public OPPLScript_OPPLParser.actions_return actions() throws RecognitionException {
        return gOPPLParser.actions();
    }

    public OPPLScript_OPPLParser.query_return query() throws RecognitionException {
        return gOPPLParser.query();
    }

    public OPPLScript_OPPLParser.axiom_return axiom() throws RecognitionException {
        return gOPPLParser.axiom();
    }

    public OPPLScript_OPPLParser_MOWLParser.hasKeyAxiom_return hasKeyAxiom()
        throws RecognitionException {
        return gMOWLParser.hasKeyAxiom();
    }

    public OPPLScript_OPPLParser.atomic_return atomic() throws RecognitionException {
        return gOPPLParser.atomic();
    }

    public OPPLScript_OPPLParser.nAryAxiom_return nAryAxiom() throws RecognitionException {
        return gOPPLParser.nAryAxiom();
    }

    public OPPLScript_OPPLParser_MOWLParser.restrictionKind_return restrictionKind()
        throws RecognitionException {
        return gMOWLParser.restrictionKind();
    }

    public OPPLScript_OPPLParser.lowerUpperCase_return lowerUpperCase()
        throws RecognitionException {
        return gOPPLParser.lowerUpperCase();
    }

    public OPPLScript_OPPLParser_MOWLParser.disjunction_return disjunction()
        throws RecognitionException {
        return gMOWLParser.disjunction();
    }

    public OPPLScript_OPPLParser.stringExpression_return stringExpression()
        throws RecognitionException {
        return gOPPLParser.stringExpression();
    }

    public OPPLScript_OPPLParser.attributeSelector_return attributeSelector()
        throws RecognitionException {
        return gOPPLParser.attributeSelector();
    }

    public OPPLScript_OPPLParser.regexp_return regexp() throws RecognitionException {
        return gOPPLParser.regexp();
    }

    public OPPLScript_OPPLParser_MOWLParser.valueRestriction_return valueRestriction()
        throws RecognitionException {
        return gMOWLParser.valueRestriction();
    }

    public OPPLScript_OPPLParser.selectClause_return selectClause()
        throws RecognitionException {
        return gOPPLParser.selectClause();
    }

    public OPPLScript_OPPLParser_MOWLParser.qualifiedRestriction_return qualifiedRestriction()
        throws RecognitionException {
        return gMOWLParser.qualifiedRestriction();
    }

    public OPPLScript_OPPLParser_MOWLParser.unaryCharacteristic_return unaryCharacteristic()
        throws RecognitionException {
        return gMOWLParser.unaryCharacteristic();
    }

    public OPPLScript_OPPLParser_MOWLParser.dataRange_return dataRange()
        throws RecognitionException {
        return gMOWLParser.dataRange();
    }

    public OPPLScript_OPPLParser_MOWLParser.value_return value()
        throws RecognitionException {
        return gMOWLParser.value();
    }

    public OPPLScript_OPPLParser_MOWLParser.complexPropertyExpression_return complexPropertyExpression()
        throws RecognitionException {
        return gMOWLParser.complexPropertyExpression();
    }

    public OPPLScript_OPPLParser_MOWLParser.propertyExpression_return propertyExpression() throws RecognitionException {
        return gMOWLParser.propertyExpression();
    }

    public OPPLScript_OPPLParser.variableDefinitions_return variableDefinitions()
        throws RecognitionException {
        return gOPPLParser.variableDefinitions();
    }

    public OPPLScript_OPPLParser_MOWLParser.dataRangeFacet_return dataRangeFacet()
        throws RecognitionException {
        return gMOWLParser.dataRangeFacet();
    }

    public static final BitSet FOLLOW_variableDefinitions_in_statement112 = new BitSet(
        new long[] { 0x0000000000000000L, 0x0000000000080800L });
    public static final BitSet FOLLOW_query_in_statement115 = new BitSet(new long[] {
        0x0000000000000000L, 0x0000000000080800L });
    public static final BitSet FOLLOW_actions_in_statement118 = new BitSet(
        new long[] { 0x0000000000000002L });
}
