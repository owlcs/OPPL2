// $ANTLR 3.2 Sep 23, 2009 12:02:23 MOWLParser.g 2011-02-03 18:49:27
package org.coode.parsers;

import java.util.ArrayList;
import java.util.List;

import org.antlr.runtime.BaseRecognizer;
import org.antlr.runtime.BitSet;
import org.antlr.runtime.DFA;
import org.antlr.runtime.EarlyExitException;
import org.antlr.runtime.IntStream;
import org.antlr.runtime.NoViableAltException;
import org.antlr.runtime.Parser;
import org.antlr.runtime.ParserRuleReturnScope;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.RecognizerSharedState;
import org.antlr.runtime.RuleReturnScope;
import org.antlr.runtime.Token;
import org.antlr.runtime.TokenStream;
import org.antlr.runtime.tree.CommonTreeAdaptor;
import org.antlr.runtime.tree.RewriteEarlyExitException;
import org.antlr.runtime.tree.RewriteEmptyStreamException;
import org.antlr.runtime.tree.RewriteRuleSubtreeStream;
import org.antlr.runtime.tree.RewriteRuleTokenStream;
import org.antlr.runtime.tree.TreeAdaptor;
import org.coode.oppl.log.Logger;
import org.coode.oppl.log.Logging;

public class ManchesterOWLSyntax_MOWLParser extends Parser {
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
    // delegators
    public ManchesterOWLSyntaxParser gManchesterOWLSyntax;
    public ManchesterOWLSyntaxParser gParent;

    public ManchesterOWLSyntax_MOWLParser(TokenStream input,
            ManchesterOWLSyntaxParser gManchesterOWLSyntax) {
        this(input, new RecognizerSharedState(), gManchesterOWLSyntax);
    }

    public ManchesterOWLSyntax_MOWLParser(TokenStream input, RecognizerSharedState state,
            ManchesterOWLSyntaxParser gManchesterOWLSyntax) {
        super(input, state);
        this.gManchesterOWLSyntax = gManchesterOWLSyntax;
        gParent = gManchesterOWLSyntax;
    }

    protected TreeAdaptor adaptor = new CommonTreeAdaptor();

    public void setTreeAdaptor(TreeAdaptor adaptor) {
        this.adaptor = adaptor;
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
        return "MOWLParser.g";
    }

    @Override
    public void displayRecognitionError(String[] tokenNames, RecognitionException e) {}

    public static class axiom_return extends ParserRuleReturnScope {
        ManchesterOWLSyntaxTree tree;

        @Override
        public Object getTree() {
            return tree;
        }
    };

    // $ANTLR start "axiom"
    // MOWLParser.g:64:1: axiom options {backtrack=true; } : ( binaryAxiom -> ^(
    // binaryAxiom ) | unaryAxiom -> ^( unaryAxiom ) | assertionAxiom -> ^(
    // assertionAxiom ) | hasKeyAxiom -> ^( hasKeyAxiom ) |
    // annotationAssertionAxiom -> ^( annotationAssertionAxiom ) );
    public final ManchesterOWLSyntax_MOWLParser.axiom_return axiom()
            throws RecognitionException {
        ManchesterOWLSyntax_MOWLParser.axiom_return retval = new ManchesterOWLSyntax_MOWLParser.axiom_return();
        retval.start = input.LT(1);
        ManchesterOWLSyntaxTree root_0 = null;
        ManchesterOWLSyntax_MOWLParser.binaryAxiom_return binaryAxiom1 = null;
        ManchesterOWLSyntax_MOWLParser.unaryAxiom_return unaryAxiom2 = null;
        ManchesterOWLSyntax_MOWLParser.assertionAxiom_return assertionAxiom3 = null;
        ManchesterOWLSyntax_MOWLParser.hasKeyAxiom_return hasKeyAxiom4 = null;
        ManchesterOWLSyntax_MOWLParser.annotationAssertionAxiom_return annotationAssertionAxiom5 = null;
        RewriteRuleSubtreeStream stream_binaryAxiom = new RewriteRuleSubtreeStream(
                adaptor, "rule binaryAxiom");
        RewriteRuleSubtreeStream stream_unaryAxiom = new RewriteRuleSubtreeStream(
                adaptor, "rule unaryAxiom");
        RewriteRuleSubtreeStream stream_annotationAssertionAxiom = new RewriteRuleSubtreeStream(
                adaptor, "rule annotationAssertionAxiom");
        RewriteRuleSubtreeStream stream_hasKeyAxiom = new RewriteRuleSubtreeStream(
                adaptor, "rule hasKeyAxiom");
        RewriteRuleSubtreeStream stream_assertionAxiom = new RewriteRuleSubtreeStream(
                adaptor, "rule assertionAxiom");
        try {
            // MOWLParser.g:64:37: ( binaryAxiom -> ^( binaryAxiom ) |
            // unaryAxiom -> ^( unaryAxiom ) | assertionAxiom -> ^(
            // assertionAxiom ) | hasKeyAxiom -> ^( hasKeyAxiom ) |
            // annotationAssertionAxiom -> ^( annotationAssertionAxiom ) )
            int alt1 = 5;
            alt1 = dfa1.predict(input);
            switch (alt1) {
                case 1:
                // MOWLParser.g:65:3: binaryAxiom
                {
                    pushFollow(FOLLOW_binaryAxiom_in_axiom232);
                    binaryAxiom1 = binaryAxiom();
                    state._fsp--;
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        stream_binaryAxiom.add(binaryAxiom1.getTree());
                    }
                    // AST REWRITE
                    // elements: binaryAxiom
                    // token labels:
                    // rule labels: retval
                    // token list labels:
                    // rule list labels:
                    // wildcard labels:
                    if (state.backtracking == 0) {
                        retval.tree = root_0;
                        RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(
                                adaptor, "rule retval", retval != null ? retval.tree
                                        : null);
                        root_0 = (ManchesterOWLSyntaxTree) adaptor.nil();
                        // 65:15: -> ^( binaryAxiom )
                        {
                            // MOWLParser.g:65:18: ^( binaryAxiom )
                            {
                                ManchesterOWLSyntaxTree root_1 = (ManchesterOWLSyntaxTree) adaptor
                                        .nil();
                                root_1 = (ManchesterOWLSyntaxTree) adaptor.becomeRoot(
                                        stream_binaryAxiom.nextNode(), root_1);
                                adaptor.addChild(root_0, root_1);
                            }
                        }
                        retval.tree = root_0;
                    }
                }
                    break;
                case 2:
                // MOWLParser.g:66:5: unaryAxiom
                {
                    pushFollow(FOLLOW_unaryAxiom_in_axiom244);
                    unaryAxiom2 = unaryAxiom();
                    state._fsp--;
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        stream_unaryAxiom.add(unaryAxiom2.getTree());
                    }
                    // AST REWRITE
                    // elements: unaryAxiom
                    // token labels:
                    // rule labels: retval
                    // token list labels:
                    // rule list labels:
                    // wildcard labels:
                    if (state.backtracking == 0) {
                        retval.tree = root_0;
                        RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(
                                adaptor, "rule retval", retval != null ? retval.tree
                                        : null);
                        root_0 = (ManchesterOWLSyntaxTree) adaptor.nil();
                        // 66:16: -> ^( unaryAxiom )
                        {
                            // MOWLParser.g:66:19: ^( unaryAxiom )
                            {
                                ManchesterOWLSyntaxTree root_1 = (ManchesterOWLSyntaxTree) adaptor
                                        .nil();
                                root_1 = (ManchesterOWLSyntaxTree) adaptor.becomeRoot(
                                        stream_unaryAxiom.nextNode(), root_1);
                                adaptor.addChild(root_0, root_1);
                            }
                        }
                        retval.tree = root_0;
                    }
                }
                    break;
                case 3:
                // MOWLParser.g:67:5: assertionAxiom
                {
                    pushFollow(FOLLOW_assertionAxiom_in_axiom256);
                    assertionAxiom3 = assertionAxiom();
                    state._fsp--;
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        stream_assertionAxiom.add(assertionAxiom3.getTree());
                    }
                    // AST REWRITE
                    // elements: assertionAxiom
                    // token labels:
                    // rule labels: retval
                    // token list labels:
                    // rule list labels:
                    // wildcard labels:
                    if (state.backtracking == 0) {
                        retval.tree = root_0;
                        RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(
                                adaptor, "rule retval", retval != null ? retval.tree
                                        : null);
                        root_0 = (ManchesterOWLSyntaxTree) adaptor.nil();
                        // 67:20: -> ^( assertionAxiom )
                        {
                            // MOWLParser.g:67:23: ^( assertionAxiom )
                            {
                                ManchesterOWLSyntaxTree root_1 = (ManchesterOWLSyntaxTree) adaptor
                                        .nil();
                                root_1 = (ManchesterOWLSyntaxTree) adaptor.becomeRoot(
                                        stream_assertionAxiom.nextNode(), root_1);
                                adaptor.addChild(root_0, root_1);
                            }
                        }
                        retval.tree = root_0;
                    }
                }
                    break;
                case 4:
                // MOWLParser.g:68:5: hasKeyAxiom
                {
                    pushFollow(FOLLOW_hasKeyAxiom_in_axiom268);
                    hasKeyAxiom4 = hasKeyAxiom();
                    state._fsp--;
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        stream_hasKeyAxiom.add(hasKeyAxiom4.getTree());
                    }
                    // AST REWRITE
                    // elements: hasKeyAxiom
                    // token labels:
                    // rule labels: retval
                    // token list labels:
                    // rule list labels:
                    // wildcard labels:
                    if (state.backtracking == 0) {
                        retval.tree = root_0;
                        RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(
                                adaptor, "rule retval", retval != null ? retval.tree
                                        : null);
                        root_0 = (ManchesterOWLSyntaxTree) adaptor.nil();
                        // 68:17: -> ^( hasKeyAxiom )
                        {
                            // MOWLParser.g:68:19: ^( hasKeyAxiom )
                            {
                                ManchesterOWLSyntaxTree root_1 = (ManchesterOWLSyntaxTree) adaptor
                                        .nil();
                                root_1 = (ManchesterOWLSyntaxTree) adaptor.becomeRoot(
                                        stream_hasKeyAxiom.nextNode(), root_1);
                                adaptor.addChild(root_0, root_1);
                            }
                        }
                        retval.tree = root_0;
                    }
                }
                    break;
                case 5:
                // MOWLParser.g:69:5: annotationAssertionAxiom
                {
                    pushFollow(FOLLOW_annotationAssertionAxiom_in_axiom279);
                    annotationAssertionAxiom5 = annotationAssertionAxiom();
                    state._fsp--;
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        stream_annotationAssertionAxiom.add(annotationAssertionAxiom5
                                .getTree());
                    }
                    // AST REWRITE
                    // elements: annotationAssertionAxiom
                    // token labels:
                    // rule labels: retval
                    // token list labels:
                    // rule list labels:
                    // wildcard labels:
                    if (state.backtracking == 0) {
                        retval.tree = root_0;
                        RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(
                                adaptor, "rule retval", retval != null ? retval.tree
                                        : null);
                        root_0 = (ManchesterOWLSyntaxTree) adaptor.nil();
                        // 69:30: -> ^( annotationAssertionAxiom )
                        {
                            // MOWLParser.g:69:32: ^( annotationAssertionAxiom )
                            {
                                ManchesterOWLSyntaxTree root_1 = (ManchesterOWLSyntaxTree) adaptor
                                        .nil();
                                root_1 = (ManchesterOWLSyntaxTree) adaptor.becomeRoot(
                                        stream_annotationAssertionAxiom.nextNode(),
                                        root_1);
                                adaptor.addChild(root_0, root_1);
                            }
                        }
                        retval.tree = root_0;
                    }
                }
                    break;
            }
            retval.stop = input.LT(-1);
            if (state.backtracking == 0) {
                retval.tree = (ManchesterOWLSyntaxTree) adaptor
                        .rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        } catch (RecognitionException e) {
            throw e;
        } catch (RewriteEmptyStreamException e) {
            throw e;
        } finally {}
        return retval;
    }

    // $ANTLR end "axiom"
    public static class annotationAssertionAxiom_return extends ParserRuleReturnScope {
        ManchesterOWLSyntaxTree tree;

        @Override
        public Object getTree() {
            return tree;
        }
    };

    // $ANTLR start "annotationAssertionAxiom"
    // MOWLParser.g:72:1: annotationAssertionAxiom options {backtrack=true; } :
    // ( iri p= atomic o= constant -> ^( ANNOTATION_ASSERTION iri ^( EXPRESSION
    // $p) ^( EXPRESSION $o) ) | iri p= atomic a= atomic -> ^(
    // ANNOTATION_ASSERTION iri ^( EXPRESSION $p) ^( EXPRESSION $a) ) |
    // subjectIRI= iri p= atomic objectIRI= iri -> ^( ANNOTATION_ASSERTION
    // $subjectIRI ^( EXPRESSION $p) ^( EXPRESSION $objectIRI) ) );
    public final ManchesterOWLSyntax_MOWLParser.annotationAssertionAxiom_return
            annotationAssertionAxiom() throws RecognitionException {
        ManchesterOWLSyntax_MOWLParser.annotationAssertionAxiom_return retval = new ManchesterOWLSyntax_MOWLParser.annotationAssertionAxiom_return();
        retval.start = input.LT(1);
        ManchesterOWLSyntaxTree root_0 = null;
        ManchesterOWLSyntax_MOWLParser.atomic_return p = null;
        ManchesterOWLSyntax_MOWLParser.constant_return o = null;
        ManchesterOWLSyntax_MOWLParser.atomic_return a = null;
        ManchesterOWLSyntax_MOWLParser.iri_return subjectIRI = null;
        ManchesterOWLSyntax_MOWLParser.iri_return objectIRI = null;
        ManchesterOWLSyntax_MOWLParser.iri_return iri6 = null;
        ManchesterOWLSyntax_MOWLParser.iri_return iri7 = null;
        RewriteRuleSubtreeStream stream_constant = new RewriteRuleSubtreeStream(adaptor,
                "rule constant");
        RewriteRuleSubtreeStream stream_iri = new RewriteRuleSubtreeStream(adaptor,
                "rule iri");
        RewriteRuleSubtreeStream stream_atomic = new RewriteRuleSubtreeStream(adaptor,
                "rule atomic");
        try {
            // MOWLParser.g:73:32: ( iri p= atomic o= constant -> ^(
            // ANNOTATION_ASSERTION iri ^( EXPRESSION $p) ^( EXPRESSION $o) ) |
            // iri p= atomic a= atomic -> ^( ANNOTATION_ASSERTION iri ^(
            // EXPRESSION $p) ^( EXPRESSION $a) ) | subjectIRI= iri p= atomic
            // objectIRI= iri -> ^( ANNOTATION_ASSERTION $subjectIRI ^(
            // EXPRESSION $p) ^( EXPRESSION $objectIRI) ) )
            int alt2 = 3;
            int LA2_0 = input.LA(1);
            if (LA2_0 == IRI) {
                int LA2_1 = input.LA(2);
                if (LA2_1 == IDENTIFIER) {
                    switch (input.LA(3)) {
                        case DBLQUOTE: {
                            alt2 = 1;
                        }
                            break;
                        case IRI: {
                            alt2 = 3;
                        }
                            break;
                        case IDENTIFIER:
                        case ENTITY_REFERENCE: {
                            alt2 = 2;
                        }
                            break;
                        default:
                            if (state.backtracking > 0) {
                                state.failed = true;
                                return retval;
                            }
                            NoViableAltException nvae = new NoViableAltException("", 2,
                                    2, input);
                            throw nvae;
                    }
                } else if (LA2_1 == ENTITY_REFERENCE) {
                    switch (input.LA(3)) {
                        case IRI: {
                            alt2 = 3;
                        }
                            break;
                        case DBLQUOTE: {
                            alt2 = 1;
                        }
                            break;
                        case IDENTIFIER:
                        case ENTITY_REFERENCE: {
                            alt2 = 2;
                        }
                            break;
                        default:
                            if (state.backtracking > 0) {
                                state.failed = true;
                                return retval;
                            }
                            NoViableAltException nvae = new NoViableAltException("", 2,
                                    3, input);
                            throw nvae;
                    }
                } else {
                    if (state.backtracking > 0) {
                        state.failed = true;
                        return retval;
                    }
                    NoViableAltException nvae = new NoViableAltException("", 2, 1, input);
                    throw nvae;
                }
            } else {
                if (state.backtracking > 0) {
                    state.failed = true;
                    return retval;
                }
                NoViableAltException nvae = new NoViableAltException("", 2, 0, input);
                throw nvae;
            }
            switch (alt2) {
                case 1:
                // MOWLParser.g:74:3: iri p= atomic o= constant
                {
                    pushFollow(FOLLOW_iri_in_annotationAssertionAxiom311);
                    iri6 = iri();
                    state._fsp--;
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        stream_iri.add(iri6.getTree());
                    }
                    pushFollow(FOLLOW_atomic_in_annotationAssertionAxiom316);
                    p = atomic();
                    state._fsp--;
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        stream_atomic.add(p.getTree());
                    }
                    pushFollow(FOLLOW_constant_in_annotationAssertionAxiom322);
                    o = constant();
                    state._fsp--;
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        stream_constant.add(o.getTree());
                    }
                    // AST REWRITE
                    // elements: o, p, iri
                    // token labels:
                    // rule labels: retval, p, o
                    // token list labels:
                    // rule list labels:
                    // wildcard labels:
                    if (state.backtracking == 0) {
                        retval.tree = root_0;
                        RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(
                                adaptor, "rule retval", retval != null ? retval.tree
                                        : null);
                        RewriteRuleSubtreeStream stream_p = new RewriteRuleSubtreeStream(
                                adaptor, "rule p", p != null ? p.tree : null);
                        RewriteRuleSubtreeStream stream_o = new RewriteRuleSubtreeStream(
                                adaptor, "rule o", o != null ? o.tree : null);
                        root_0 = (ManchesterOWLSyntaxTree) adaptor.nil();
                        // 74:30: -> ^( ANNOTATION_ASSERTION iri ^( EXPRESSION
                        // $p) ^( EXPRESSION $o) )
                        {
                            // MOWLParser.g:74:33: ^( ANNOTATION_ASSERTION iri
                            // ^( EXPRESSION $p) ^( EXPRESSION $o) )
                            {
                                ManchesterOWLSyntaxTree root_1 = (ManchesterOWLSyntaxTree) adaptor
                                        .nil();
                                root_1 = (ManchesterOWLSyntaxTree) adaptor.becomeRoot(
                                        adaptor.create(ANNOTATION_ASSERTION,
                                                "ANNOTATION_ASSERTION"), root_1);
                                adaptor.addChild(root_1, stream_iri.nextTree());
                                // MOWLParser.g:74:60: ^( EXPRESSION $p)
                                {
                                    ManchesterOWLSyntaxTree root_2 = (ManchesterOWLSyntaxTree) adaptor
                                            .nil();
                                    root_2 = (ManchesterOWLSyntaxTree) adaptor
                                            .becomeRoot(adaptor.create(EXPRESSION,
                                                    "EXPRESSION"), root_2);
                                    adaptor.addChild(root_2, stream_p.nextTree());
                                    adaptor.addChild(root_1, root_2);
                                }
                                // MOWLParser.g:74:77: ^( EXPRESSION $o)
                                {
                                    ManchesterOWLSyntaxTree root_2 = (ManchesterOWLSyntaxTree) adaptor
                                            .nil();
                                    root_2 = (ManchesterOWLSyntaxTree) adaptor
                                            .becomeRoot(adaptor.create(EXPRESSION,
                                                    "EXPRESSION"), root_2);
                                    adaptor.addChild(root_2, stream_o.nextTree());
                                    adaptor.addChild(root_1, root_2);
                                }
                                adaptor.addChild(root_0, root_1);
                            }
                        }
                        retval.tree = root_0;
                    }
                }
                    break;
                case 2:
                // MOWLParser.g:75:5: iri p= atomic a= atomic
                {
                    pushFollow(FOLLOW_iri_in_annotationAssertionAxiom350);
                    iri7 = iri();
                    state._fsp--;
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        stream_iri.add(iri7.getTree());
                    }
                    pushFollow(FOLLOW_atomic_in_annotationAssertionAxiom355);
                    p = atomic();
                    state._fsp--;
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        stream_atomic.add(p.getTree());
                    }
                    pushFollow(FOLLOW_atomic_in_annotationAssertionAxiom361);
                    a = atomic();
                    state._fsp--;
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        stream_atomic.add(a.getTree());
                    }
                    // AST REWRITE
                    // elements: p, iri, a
                    // token labels:
                    // rule labels: retval, a, p
                    // token list labels:
                    // rule list labels:
                    // wildcard labels:
                    if (state.backtracking == 0) {
                        retval.tree = root_0;
                        RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(
                                adaptor, "rule retval", retval != null ? retval.tree
                                        : null);
                        RewriteRuleSubtreeStream stream_a = new RewriteRuleSubtreeStream(
                                adaptor, "rule a", a != null ? a.tree : null);
                        RewriteRuleSubtreeStream stream_p = new RewriteRuleSubtreeStream(
                                adaptor, "rule p", p != null ? p.tree : null);
                        root_0 = (ManchesterOWLSyntaxTree) adaptor.nil();
                        // 75:30: -> ^( ANNOTATION_ASSERTION iri ^( EXPRESSION
                        // $p) ^( EXPRESSION $a) )
                        {
                            // MOWLParser.g:75:33: ^( ANNOTATION_ASSERTION iri
                            // ^( EXPRESSION $p) ^( EXPRESSION $a) )
                            {
                                ManchesterOWLSyntaxTree root_1 = (ManchesterOWLSyntaxTree) adaptor
                                        .nil();
                                root_1 = (ManchesterOWLSyntaxTree) adaptor.becomeRoot(
                                        adaptor.create(ANNOTATION_ASSERTION,
                                                "ANNOTATION_ASSERTION"), root_1);
                                adaptor.addChild(root_1, stream_iri.nextTree());
                                // MOWLParser.g:75:60: ^( EXPRESSION $p)
                                {
                                    ManchesterOWLSyntaxTree root_2 = (ManchesterOWLSyntaxTree) adaptor
                                            .nil();
                                    root_2 = (ManchesterOWLSyntaxTree) adaptor
                                            .becomeRoot(adaptor.create(EXPRESSION,
                                                    "EXPRESSION"), root_2);
                                    adaptor.addChild(root_2, stream_p.nextTree());
                                    adaptor.addChild(root_1, root_2);
                                }
                                // MOWLParser.g:75:77: ^( EXPRESSION $a)
                                {
                                    ManchesterOWLSyntaxTree root_2 = (ManchesterOWLSyntaxTree) adaptor
                                            .nil();
                                    root_2 = (ManchesterOWLSyntaxTree) adaptor
                                            .becomeRoot(adaptor.create(EXPRESSION,
                                                    "EXPRESSION"), root_2);
                                    adaptor.addChild(root_2, stream_a.nextTree());
                                    adaptor.addChild(root_1, root_2);
                                }
                                adaptor.addChild(root_0, root_1);
                            }
                        }
                        retval.tree = root_0;
                    }
                }
                    break;
                case 3:
                // MOWLParser.g:76:5: subjectIRI= iri p= atomic objectIRI= iri
                {
                    pushFollow(FOLLOW_iri_in_annotationAssertionAxiom393);
                    subjectIRI = iri();
                    state._fsp--;
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        stream_iri.add(subjectIRI.getTree());
                    }
                    pushFollow(FOLLOW_atomic_in_annotationAssertionAxiom398);
                    p = atomic();
                    state._fsp--;
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        stream_atomic.add(p.getTree());
                    }
                    pushFollow(FOLLOW_iri_in_annotationAssertionAxiom404);
                    objectIRI = iri();
                    state._fsp--;
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        stream_iri.add(objectIRI.getTree());
                    }
                    // AST REWRITE
                    // elements: objectIRI, subjectIRI, p
                    // token labels:
                    // rule labels: objectIRI, retval, subjectIRI, p
                    // token list labels:
                    // rule list labels:
                    // wildcard labels:
                    if (state.backtracking == 0) {
                        retval.tree = root_0;
                        RewriteRuleSubtreeStream stream_objectIRI = new RewriteRuleSubtreeStream(
                                adaptor, "rule objectIRI",
                                objectIRI != null ? objectIRI.tree : null);
                        RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(
                                adaptor, "rule retval", retval != null ? retval.tree
                                        : null);
                        RewriteRuleSubtreeStream stream_subjectIRI = new RewriteRuleSubtreeStream(
                                adaptor, "rule subjectIRI",
                                subjectIRI != null ? subjectIRI.tree : null);
                        RewriteRuleSubtreeStream stream_p = new RewriteRuleSubtreeStream(
                                adaptor, "rule p", p != null ? p.tree : null);
                        root_0 = (ManchesterOWLSyntaxTree) adaptor.nil();
                        // 76:48: -> ^( ANNOTATION_ASSERTION $subjectIRI ^(
                        // EXPRESSION $p) ^( EXPRESSION $objectIRI) )
                        {
                            // MOWLParser.g:76:51: ^( ANNOTATION_ASSERTION
                            // $subjectIRI ^( EXPRESSION $p) ^( EXPRESSION
                            // $objectIRI) )
                            {
                                ManchesterOWLSyntaxTree root_1 = (ManchesterOWLSyntaxTree) adaptor
                                        .nil();
                                root_1 = (ManchesterOWLSyntaxTree) adaptor.becomeRoot(
                                        adaptor.create(ANNOTATION_ASSERTION,
                                                "ANNOTATION_ASSERTION"), root_1);
                                adaptor.addChild(root_1, stream_subjectIRI.nextTree());
                                // MOWLParser.g:76:86: ^( EXPRESSION $p)
                                {
                                    ManchesterOWLSyntaxTree root_2 = (ManchesterOWLSyntaxTree) adaptor
                                            .nil();
                                    root_2 = (ManchesterOWLSyntaxTree) adaptor
                                            .becomeRoot(adaptor.create(EXPRESSION,
                                                    "EXPRESSION"), root_2);
                                    adaptor.addChild(root_2, stream_p.nextTree());
                                    adaptor.addChild(root_1, root_2);
                                }
                                // MOWLParser.g:76:103: ^( EXPRESSION
                                // $objectIRI)
                                {
                                    ManchesterOWLSyntaxTree root_2 = (ManchesterOWLSyntaxTree) adaptor
                                            .nil();
                                    root_2 = (ManchesterOWLSyntaxTree) adaptor
                                            .becomeRoot(adaptor.create(EXPRESSION,
                                                    "EXPRESSION"), root_2);
                                    adaptor.addChild(root_2, stream_objectIRI.nextTree());
                                    adaptor.addChild(root_1, root_2);
                                }
                                adaptor.addChild(root_0, root_1);
                            }
                        }
                        retval.tree = root_0;
                    }
                }
                    break;
            }
            retval.stop = input.LT(-1);
            if (state.backtracking == 0) {
                retval.tree = (ManchesterOWLSyntaxTree) adaptor
                        .rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        } catch (RecognitionException e) {
            throw e;
        } catch (RewriteEmptyStreamException e) {
            throw e;
        } finally {}
        return retval;
    }

    // $ANTLR end "annotationAssertionAxiom"
    public static class iri_return extends ParserRuleReturnScope {
        ManchesterOWLSyntaxTree tree;

        @Override
        public Object getTree() {
            return tree;
        }
    };

    // $ANTLR start "iri"
    // MOWLParser.g:80:1: iri : IRI -> IRI ;
    public final ManchesterOWLSyntax_MOWLParser.iri_return iri()
            throws RecognitionException {
        ManchesterOWLSyntax_MOWLParser.iri_return retval = new ManchesterOWLSyntax_MOWLParser.iri_return();
        retval.start = input.LT(1);
        ManchesterOWLSyntaxTree root_0 = null;
        Token IRI8 = null;
        ManchesterOWLSyntaxTree IRI8_tree = null;
        RewriteRuleTokenStream stream_IRI = new RewriteRuleTokenStream(adaptor,
                "token IRI");
        try {
            // MOWLParser.g:81:2: ( IRI -> IRI )
            // MOWLParser.g:82:2: IRI
            {
                IRI8 = (Token) match(input, IRI, FOLLOW_IRI_in_iri440);
                if (state.failed) {
                    return retval;
                }
                if (state.backtracking == 0) {
                    stream_IRI.add(IRI8);
                }
                // AST REWRITE
                // elements: IRI
                // token labels:
                // rule labels: retval
                // token list labels:
                // rule list labels:
                // wildcard labels:
                if (state.backtracking == 0) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(
                            adaptor, "rule retval", retval != null ? retval.tree : null);
                    root_0 = (ManchesterOWLSyntaxTree) adaptor.nil();
                    // 82:6: -> IRI
                    {
                        adaptor.addChild(root_0, stream_IRI.nextNode());
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
            throw e;
        } catch (RewriteEmptyStreamException e) {
            throw e;
        } finally {}
        return retval;
    }

    // $ANTLR end "iri"
    public static class hasKeyAxiom_return extends ParserRuleReturnScope {
        ManchesterOWLSyntaxTree tree;

        @Override
        public Object getTree() {
            return tree;
        }
    };

    // $ANTLR start "hasKeyAxiom"
    // MOWLParser.g:85:1: hasKeyAxiom : exp= disjunction HAS_KEY
    // propertyExpression ( COMMA propertyExpression )* -> ^( HAS_KEY ^(
    // EXPRESSION $exp) ( ^( EXPRESSION propertyExpression ) )+ ) ;
    public final ManchesterOWLSyntax_MOWLParser.hasKeyAxiom_return hasKeyAxiom()
            throws RecognitionException {
        ManchesterOWLSyntax_MOWLParser.hasKeyAxiom_return retval = new ManchesterOWLSyntax_MOWLParser.hasKeyAxiom_return();
        retval.start = input.LT(1);
        ManchesterOWLSyntaxTree root_0 = null;
        Token HAS_KEY9 = null;
        Token COMMA11 = null;
        ManchesterOWLSyntax_MOWLParser.disjunction_return exp = null;
        ManchesterOWLSyntax_MOWLParser.propertyExpression_return propertyExpression10 = null;
        ManchesterOWLSyntax_MOWLParser.propertyExpression_return propertyExpression12 = null;
        ManchesterOWLSyntaxTree HAS_KEY9_tree = null;
        ManchesterOWLSyntaxTree COMMA11_tree = null;
        RewriteRuleTokenStream stream_HAS_KEY = new RewriteRuleTokenStream(adaptor,
                "token HAS_KEY");
        RewriteRuleTokenStream stream_COMMA = new RewriteRuleTokenStream(adaptor,
                "token COMMA");
        RewriteRuleSubtreeStream stream_disjunction = new RewriteRuleSubtreeStream(
                adaptor, "rule disjunction");
        RewriteRuleSubtreeStream stream_propertyExpression = new RewriteRuleSubtreeStream(
                adaptor, "rule propertyExpression");
        try {
            // MOWLParser.g:86:2: (exp= disjunction HAS_KEY propertyExpression (
            // COMMA propertyExpression )* -> ^( HAS_KEY ^( EXPRESSION $exp) (
            // ^( EXPRESSION propertyExpression ) )+ ) )
            // MOWLParser.g:87:2: exp= disjunction HAS_KEY propertyExpression (
            // COMMA propertyExpression )*
            {
                pushFollow(FOLLOW_disjunction_in_hasKeyAxiom462);
                exp = disjunction();
                state._fsp--;
                if (state.failed) {
                    return retval;
                }
                if (state.backtracking == 0) {
                    stream_disjunction.add(exp.getTree());
                }
                HAS_KEY9 = (Token) match(input, HAS_KEY, FOLLOW_HAS_KEY_in_hasKeyAxiom464);
                if (state.failed) {
                    return retval;
                }
                if (state.backtracking == 0) {
                    stream_HAS_KEY.add(HAS_KEY9);
                }
                pushFollow(FOLLOW_propertyExpression_in_hasKeyAxiom466);
                propertyExpression10 = propertyExpression();
                state._fsp--;
                if (state.failed) {
                    return retval;
                }
                if (state.backtracking == 0) {
                    stream_propertyExpression.add(propertyExpression10.getTree());
                }
                // MOWLParser.g:87:47: ( COMMA propertyExpression )*
                loop3: do {
                    int alt3 = 2;
                    int LA3_0 = input.LA(1);
                    if (LA3_0 == COMMA) {
                        alt3 = 1;
                    }
                    switch (alt3) {
                        case 1:
                        // MOWLParser.g:87:48: COMMA propertyExpression
                        {
                            COMMA11 = (Token) match(input, COMMA,
                                    FOLLOW_COMMA_in_hasKeyAxiom469);
                            if (state.failed) {
                                return retval;
                            }
                            if (state.backtracking == 0) {
                                stream_COMMA.add(COMMA11);
                            }
                            pushFollow(FOLLOW_propertyExpression_in_hasKeyAxiom471);
                            propertyExpression12 = propertyExpression();
                            state._fsp--;
                            if (state.failed) {
                                return retval;
                            }
                            if (state.backtracking == 0) {
                                stream_propertyExpression.add(propertyExpression12
                                        .getTree());
                            }
                        }
                            break;
                        default:
                            break loop3;
                    }
                } while (true);
                // AST REWRITE
                // elements: propertyExpression, HAS_KEY, exp
                // token labels:
                // rule labels: exp, retval
                // token list labels:
                // rule list labels:
                // wildcard labels:
                if (state.backtracking == 0) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_exp = new RewriteRuleSubtreeStream(
                            adaptor, "rule exp", exp != null ? exp.tree : null);
                    RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(
                            adaptor, "rule retval", retval != null ? retval.tree : null);
                    root_0 = (ManchesterOWLSyntaxTree) adaptor.nil();
                    // 87:75: -> ^( HAS_KEY ^( EXPRESSION $exp) ( ^( EXPRESSION
                    // propertyExpression ) )+ )
                    {
                        // MOWLParser.g:87:78: ^( HAS_KEY ^( EXPRESSION $exp) (
                        // ^( EXPRESSION propertyExpression ) )+ )
                        {
                            ManchesterOWLSyntaxTree root_1 = (ManchesterOWLSyntaxTree) adaptor
                                    .nil();
                            root_1 = (ManchesterOWLSyntaxTree) adaptor.becomeRoot(
                                    stream_HAS_KEY.nextNode(), root_1);
                            // MOWLParser.g:87:88: ^( EXPRESSION $exp)
                            {
                                ManchesterOWLSyntaxTree root_2 = (ManchesterOWLSyntaxTree) adaptor
                                        .nil();
                                root_2 = (ManchesterOWLSyntaxTree) adaptor.becomeRoot(
                                        adaptor.create(EXPRESSION, "EXPRESSION"), root_2);
                                adaptor.addChild(root_2, stream_exp.nextTree());
                                adaptor.addChild(root_1, root_2);
                            }
                            if (!stream_propertyExpression.hasNext()) {
                                throw new RewriteEarlyExitException();
                            }
                            while (stream_propertyExpression.hasNext()) {
                                // MOWLParser.g:87:108: ^( EXPRESSION
                                // propertyExpression )
                                {
                                    ManchesterOWLSyntaxTree root_2 = (ManchesterOWLSyntaxTree) adaptor
                                            .nil();
                                    root_2 = (ManchesterOWLSyntaxTree) adaptor
                                            .becomeRoot(adaptor.create(EXPRESSION,
                                                    "EXPRESSION"), root_2);
                                    adaptor.addChild(root_2,
                                            stream_propertyExpression.nextTree());
                                    adaptor.addChild(root_1, root_2);
                                }
                            }
                            stream_propertyExpression.reset();
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
            throw e;
        } catch (RewriteEmptyStreamException e) {
            throw e;
        } finally {}
        return retval;
    }

    // $ANTLR end "hasKeyAxiom"
    public static class assertionAxiom_return extends ParserRuleReturnScope {
        ManchesterOWLSyntaxTree tree;

        @Override
        public Object getTree() {
            return tree;
        }
    };

    // $ANTLR start "assertionAxiom"
    // MOWLParser.g:92:1: assertionAxiom options {backtrack=true; } : (i= atomic
    // ( INSTANCE_OF | TYPES ) expression -> ^( TYPE_ASSERTION ^( EXPRESSION
    // expression ) ^( EXPRESSION $i) ) | subject= atomic propertyExpression
    // value -> ^( ROLE_ASSERTION ^( EXPRESSION $subject) ^( EXPRESSION
    // propertyExpression ) ^( EXPRESSION value ) ) | NOT assertionAxiom -> ^(
    // NEGATED_ASSERTION assertionAxiom ) );
    public final ManchesterOWLSyntax_MOWLParser.assertionAxiom_return assertionAxiom()
            throws RecognitionException {
        ManchesterOWLSyntax_MOWLParser.assertionAxiom_return retval = new ManchesterOWLSyntax_MOWLParser.assertionAxiom_return();
        retval.start = input.LT(1);
        ManchesterOWLSyntaxTree root_0 = null;
        Token INSTANCE_OF13 = null;
        Token TYPES14 = null;
        Token NOT18 = null;
        ManchesterOWLSyntax_MOWLParser.atomic_return i = null;
        ManchesterOWLSyntax_MOWLParser.atomic_return subject = null;
        ManchesterOWLSyntax_MOWLParser.expression_return expression15 = null;
        ManchesterOWLSyntax_MOWLParser.propertyExpression_return propertyExpression16 = null;
        ManchesterOWLSyntax_MOWLParser.value_return value17 = null;
        ManchesterOWLSyntax_MOWLParser.assertionAxiom_return assertionAxiom19 = null;
        ManchesterOWLSyntaxTree INSTANCE_OF13_tree = null;
        ManchesterOWLSyntaxTree TYPES14_tree = null;
        ManchesterOWLSyntaxTree NOT18_tree = null;
        RewriteRuleTokenStream stream_TYPES = new RewriteRuleTokenStream(adaptor,
                "token TYPES");
        RewriteRuleTokenStream stream_NOT = new RewriteRuleTokenStream(adaptor,
                "token NOT");
        RewriteRuleTokenStream stream_INSTANCE_OF = new RewriteRuleTokenStream(adaptor,
                "token INSTANCE_OF");
        RewriteRuleSubtreeStream stream_expression = new RewriteRuleSubtreeStream(
                adaptor, "rule expression");
        RewriteRuleSubtreeStream stream_propertyExpression = new RewriteRuleSubtreeStream(
                adaptor, "rule propertyExpression");
        RewriteRuleSubtreeStream stream_value = new RewriteRuleSubtreeStream(adaptor,
                "rule value");
        RewriteRuleSubtreeStream stream_assertionAxiom = new RewriteRuleSubtreeStream(
                adaptor, "rule assertionAxiom");
        RewriteRuleSubtreeStream stream_atomic = new RewriteRuleSubtreeStream(adaptor,
                "rule atomic");
        try {
            // MOWLParser.g:92:41: (i= atomic ( INSTANCE_OF | TYPES ) expression
            // -> ^( TYPE_ASSERTION ^( EXPRESSION expression ) ^( EXPRESSION $i)
            // ) | subject= atomic propertyExpression value -> ^( ROLE_ASSERTION
            // ^( EXPRESSION $subject) ^( EXPRESSION propertyExpression ) ^(
            // EXPRESSION value ) ) | NOT assertionAxiom -> ^( NEGATED_ASSERTION
            // assertionAxiom ) )
            int alt5 = 3;
            switch (input.LA(1)) {
                case IDENTIFIER: {
                    int LA5_1 = input.LA(2);
                    if (LA5_1 == INVERSE || LA5_1 >= IDENTIFIER
                            && LA5_1 <= ENTITY_REFERENCE) {
                        alt5 = 2;
                    } else if (LA5_1 >= INSTANCE_OF && LA5_1 <= TYPES) {
                        alt5 = 1;
                    } else {
                        if (state.backtracking > 0) {
                            state.failed = true;
                            return retval;
                        }
                        NoViableAltException nvae = new NoViableAltException("", 5, 1,
                                input);
                        throw nvae;
                    }
                }
                    break;
                case ENTITY_REFERENCE: {
                    int LA5_2 = input.LA(2);
                    if (LA5_2 == INVERSE || LA5_2 >= IDENTIFIER
                            && LA5_2 <= ENTITY_REFERENCE) {
                        alt5 = 2;
                    } else if (LA5_2 >= INSTANCE_OF && LA5_2 <= TYPES) {
                        alt5 = 1;
                    } else {
                        if (state.backtracking > 0) {
                            state.failed = true;
                            return retval;
                        }
                        NoViableAltException nvae = new NoViableAltException("", 5, 2,
                                input);
                        throw nvae;
                    }
                }
                    break;
                case NOT: {
                    alt5 = 3;
                }
                    break;
                default:
                    if (state.backtracking > 0) {
                        state.failed = true;
                        return retval;
                    }
                    NoViableAltException nvae = new NoViableAltException("", 5, 0, input);
                    throw nvae;
            }
            switch (alt5) {
                case 1:
                // MOWLParser.g:93:3: i= atomic ( INSTANCE_OF | TYPES )
                // expression
                {
                    pushFollow(FOLLOW_atomic_in_assertionAxiom520);
                    i = atomic();
                    state._fsp--;
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        stream_atomic.add(i.getTree());
                    }
                    // MOWLParser.g:93:14: ( INSTANCE_OF | TYPES )
                    int alt4 = 2;
                    int LA4_0 = input.LA(1);
                    if (LA4_0 == INSTANCE_OF) {
                        alt4 = 1;
                    } else if (LA4_0 == TYPES) {
                        alt4 = 2;
                    } else {
                        if (state.backtracking > 0) {
                            state.failed = true;
                            return retval;
                        }
                        NoViableAltException nvae = new NoViableAltException("", 4, 0,
                                input);
                        throw nvae;
                    }
                    switch (alt4) {
                        case 1:
                        // MOWLParser.g:93:15: INSTANCE_OF
                        {
                            INSTANCE_OF13 = (Token) match(input, INSTANCE_OF,
                                    FOLLOW_INSTANCE_OF_in_assertionAxiom523);
                            if (state.failed) {
                                return retval;
                            }
                            if (state.backtracking == 0) {
                                stream_INSTANCE_OF.add(INSTANCE_OF13);
                            }
                        }
                            break;
                        case 2:
                        // MOWLParser.g:93:29: TYPES
                        {
                            TYPES14 = (Token) match(input, TYPES,
                                    FOLLOW_TYPES_in_assertionAxiom527);
                            if (state.failed) {
                                return retval;
                            }
                            if (state.backtracking == 0) {
                                stream_TYPES.add(TYPES14);
                            }
                        }
                            break;
                    }
                    pushFollow(FOLLOW_expression_in_assertionAxiom530);
                    expression15 = expression();
                    state._fsp--;
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        stream_expression.add(expression15.getTree());
                    }
                    // AST REWRITE
                    // elements: i, expression
                    // token labels:
                    // rule labels: retval, i
                    // token list labels:
                    // rule list labels:
                    // wildcard labels:
                    if (state.backtracking == 0) {
                        retval.tree = root_0;
                        RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(
                                adaptor, "rule retval", retval != null ? retval.tree
                                        : null);
                        RewriteRuleSubtreeStream stream_i = new RewriteRuleSubtreeStream(
                                adaptor, "rule i", i != null ? i.tree : null);
                        root_0 = (ManchesterOWLSyntaxTree) adaptor.nil();
                        // 93:47: -> ^( TYPE_ASSERTION ^( EXPRESSION expression
                        // ) ^( EXPRESSION $i) )
                        {
                            // MOWLParser.g:93:50: ^( TYPE_ASSERTION ^(
                            // EXPRESSION expression ) ^( EXPRESSION $i) )
                            {
                                ManchesterOWLSyntaxTree root_1 = (ManchesterOWLSyntaxTree) adaptor
                                        .nil();
                                root_1 = (ManchesterOWLSyntaxTree) adaptor.becomeRoot(
                                        adaptor.create(TYPE_ASSERTION, "TYPE_ASSERTION"),
                                        root_1);
                                // MOWLParser.g:93:67: ^( EXPRESSION expression
                                // )
                                {
                                    ManchesterOWLSyntaxTree root_2 = (ManchesterOWLSyntaxTree) adaptor
                                            .nil();
                                    root_2 = (ManchesterOWLSyntaxTree) adaptor
                                            .becomeRoot(adaptor.create(EXPRESSION,
                                                    "EXPRESSION"), root_2);
                                    adaptor.addChild(root_2, stream_expression.nextTree());
                                    adaptor.addChild(root_1, root_2);
                                }
                                // MOWLParser.g:93:92: ^( EXPRESSION $i)
                                {
                                    ManchesterOWLSyntaxTree root_2 = (ManchesterOWLSyntaxTree) adaptor
                                            .nil();
                                    root_2 = (ManchesterOWLSyntaxTree) adaptor
                                            .becomeRoot(adaptor.create(EXPRESSION,
                                                    "EXPRESSION"), root_2);
                                    adaptor.addChild(root_2, stream_i.nextTree());
                                    adaptor.addChild(root_1, root_2);
                                }
                                adaptor.addChild(root_0, root_1);
                            }
                        }
                        retval.tree = root_0;
                    }
                }
                    break;
                case 2:
                // MOWLParser.g:94:7: subject= atomic propertyExpression value
                {
                    pushFollow(FOLLOW_atomic_in_assertionAxiom561);
                    subject = atomic();
                    state._fsp--;
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        stream_atomic.add(subject.getTree());
                    }
                    pushFollow(FOLLOW_propertyExpression_in_assertionAxiom563);
                    propertyExpression16 = propertyExpression();
                    state._fsp--;
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        stream_propertyExpression.add(propertyExpression16.getTree());
                    }
                    pushFollow(FOLLOW_value_in_assertionAxiom566);
                    value17 = value();
                    state._fsp--;
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        stream_value.add(value17.getTree());
                    }
                    // AST REWRITE
                    // elements: value, propertyExpression, subject
                    // token labels:
                    // rule labels: retval, subject
                    // token list labels:
                    // rule list labels:
                    // wildcard labels:
                    if (state.backtracking == 0) {
                        retval.tree = root_0;
                        RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(
                                adaptor, "rule retval", retval != null ? retval.tree
                                        : null);
                        RewriteRuleSubtreeStream stream_subject = new RewriteRuleSubtreeStream(
                                adaptor, "rule subject", subject != null ? subject.tree
                                        : null);
                        root_0 = (ManchesterOWLSyntaxTree) adaptor.nil();
                        // 94:50: -> ^( ROLE_ASSERTION ^( EXPRESSION $subject)
                        // ^( EXPRESSION propertyExpression ) ^( EXPRESSION
                        // value ) )
                        {
                            // MOWLParser.g:94:53: ^( ROLE_ASSERTION ^(
                            // EXPRESSION $subject) ^( EXPRESSION
                            // propertyExpression ) ^( EXPRESSION value ) )
                            {
                                ManchesterOWLSyntaxTree root_1 = (ManchesterOWLSyntaxTree) adaptor
                                        .nil();
                                root_1 = (ManchesterOWLSyntaxTree) adaptor.becomeRoot(
                                        adaptor.create(ROLE_ASSERTION, "ROLE_ASSERTION"),
                                        root_1);
                                // MOWLParser.g:94:70: ^( EXPRESSION $subject)
                                {
                                    ManchesterOWLSyntaxTree root_2 = (ManchesterOWLSyntaxTree) adaptor
                                            .nil();
                                    root_2 = (ManchesterOWLSyntaxTree) adaptor
                                            .becomeRoot(adaptor.create(EXPRESSION,
                                                    "EXPRESSION"), root_2);
                                    adaptor.addChild(root_2, stream_subject.nextTree());
                                    adaptor.addChild(root_1, root_2);
                                }
                                // MOWLParser.g:94:93: ^( EXPRESSION
                                // propertyExpression )
                                {
                                    ManchesterOWLSyntaxTree root_2 = (ManchesterOWLSyntaxTree) adaptor
                                            .nil();
                                    root_2 = (ManchesterOWLSyntaxTree) adaptor
                                            .becomeRoot(adaptor.create(EXPRESSION,
                                                    "EXPRESSION"), root_2);
                                    adaptor.addChild(root_2,
                                            stream_propertyExpression.nextTree());
                                    adaptor.addChild(root_1, root_2);
                                }
                                // MOWLParser.g:94:126: ^( EXPRESSION value )
                                {
                                    ManchesterOWLSyntaxTree root_2 = (ManchesterOWLSyntaxTree) adaptor
                                            .nil();
                                    root_2 = (ManchesterOWLSyntaxTree) adaptor
                                            .becomeRoot(adaptor.create(EXPRESSION,
                                                    "EXPRESSION"), root_2);
                                    adaptor.addChild(root_2, stream_value.nextTree());
                                    adaptor.addChild(root_1, root_2);
                                }
                                adaptor.addChild(root_0, root_1);
                            }
                        }
                        retval.tree = root_0;
                    }
                }
                    break;
                case 3:
                // MOWLParser.g:96:5: NOT assertionAxiom
                {
                    NOT18 = (Token) match(input, NOT, FOLLOW_NOT_in_assertionAxiom600);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        stream_NOT.add(NOT18);
                    }
                    pushFollow(FOLLOW_assertionAxiom_in_assertionAxiom602);
                    assertionAxiom19 = assertionAxiom();
                    state._fsp--;
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        stream_assertionAxiom.add(assertionAxiom19.getTree());
                    }
                    // AST REWRITE
                    // elements: assertionAxiom
                    // token labels:
                    // rule labels: retval
                    // token list labels:
                    // rule list labels:
                    // wildcard labels:
                    if (state.backtracking == 0) {
                        retval.tree = root_0;
                        RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(
                                adaptor, "rule retval", retval != null ? retval.tree
                                        : null);
                        root_0 = (ManchesterOWLSyntaxTree) adaptor.nil();
                        // 96:24: -> ^( NEGATED_ASSERTION assertionAxiom )
                        {
                            // MOWLParser.g:96:27: ^( NEGATED_ASSERTION
                            // assertionAxiom )
                            {
                                ManchesterOWLSyntaxTree root_1 = (ManchesterOWLSyntaxTree) adaptor
                                        .nil();
                                root_1 = (ManchesterOWLSyntaxTree) adaptor.becomeRoot(
                                        adaptor.create(NEGATED_ASSERTION,
                                                "NEGATED_ASSERTION"), root_1);
                                adaptor.addChild(root_1, stream_assertionAxiom.nextTree());
                                adaptor.addChild(root_0, root_1);
                            }
                        }
                        retval.tree = root_0;
                    }
                }
                    break;
            }
            retval.stop = input.LT(-1);
            if (state.backtracking == 0) {
                retval.tree = (ManchesterOWLSyntaxTree) adaptor
                        .rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        } catch (RecognitionException e) {
            throw e;
        } catch (RewriteEmptyStreamException e) {
            throw e;
        } finally {}
        return retval;
    }

    // $ANTLR end "assertionAxiom"
    public static class binaryAxiom_return extends ParserRuleReturnScope {
        ManchesterOWLSyntaxTree tree;

        @Override
        public Object getTree() {
            return tree;
        }
    };

    // $ANTLR start "binaryAxiom"
    // MOWLParser.g:101:1: binaryAxiom options {backtrack=true; } : (lhs=
    // expression SUBCLASS_OF superClass= expression -> ^( SUB_CLASS_AXIOM ^(
    // EXPRESSION $lhs) ^( EXPRESSION $superClass) ) | lhs= expression
    // EQUIVALENT_TO rhs= expression -> ^( EQUIVALENT_TO_AXIOM ^( EXPRESSION
    // $lhs) ^( EXPRESSION $rhs) ) | lhs= expression DISJOINT_WITH disjoint=
    // expression -> ^( DISJOINT_WITH_AXIOM ^( EXPRESSION $lhs) ^( EXPRESSION
    // $disjoint) ) | lhs= expression SUB_PROPERTY_OF superProperty=
    // propertyExpression -> ^( SUB_PROPERTY_AXIOM ^( EXPRESSION $lhs) ^(
    // EXPRESSION $superProperty) ) | lhsID= atomic INVERSE_OF rhsAtomic= atomic
    // -> ^( INVERSE_OF ^( EXPRESSION $lhsID) ^( EXPRESSION $rhsAtomic) ) |
    // lhsID= atomic SAME_AS rhsID= atomic -> ^( SAME_AS_AXIOM ^( EXPRESSION
    // $lhsID) ^( EXPRESSION $rhsID) ) | lhsID= atomic DIFFERENT_FROM rhsID=
    // atomic -> ^( DIFFERENT_FROM_AXIOM ^( EXPRESSION $lhsID) ^( EXPRESSION
    // $rhsID) ) | lhsID= atomic DOMAIN expression -> ^( DOMAIN ^( EXPRESSION
    // $lhsID) ^( EXPRESSION expression ) ) | lhsID= atomic RANGE expression ->
    // ^( RANGE ^( EXPRESSION $lhsID) ^( EXPRESSION expression ) ) );
    public final ManchesterOWLSyntax_MOWLParser.binaryAxiom_return binaryAxiom()
            throws RecognitionException {
        ManchesterOWLSyntax_MOWLParser.binaryAxiom_return retval = new ManchesterOWLSyntax_MOWLParser.binaryAxiom_return();
        retval.start = input.LT(1);
        ManchesterOWLSyntaxTree root_0 = null;
        Token SUBCLASS_OF20 = null;
        Token EQUIVALENT_TO21 = null;
        Token DISJOINT_WITH22 = null;
        Token SUB_PROPERTY_OF23 = null;
        Token INVERSE_OF24 = null;
        Token SAME_AS25 = null;
        Token DIFFERENT_FROM26 = null;
        Token DOMAIN27 = null;
        Token RANGE29 = null;
        ManchesterOWLSyntax_MOWLParser.expression_return lhs = null;
        ManchesterOWLSyntax_MOWLParser.expression_return superClass = null;
        ManchesterOWLSyntax_MOWLParser.expression_return rhs = null;
        ManchesterOWLSyntax_MOWLParser.expression_return disjoint = null;
        ManchesterOWLSyntax_MOWLParser.propertyExpression_return superProperty = null;
        ManchesterOWLSyntax_MOWLParser.atomic_return lhsID = null;
        ManchesterOWLSyntax_MOWLParser.atomic_return rhsAtomic = null;
        ManchesterOWLSyntax_MOWLParser.atomic_return rhsID = null;
        ManchesterOWLSyntax_MOWLParser.expression_return expression28 = null;
        ManchesterOWLSyntax_MOWLParser.expression_return expression30 = null;
        ManchesterOWLSyntaxTree SUBCLASS_OF20_tree = null;
        ManchesterOWLSyntaxTree EQUIVALENT_TO21_tree = null;
        ManchesterOWLSyntaxTree DISJOINT_WITH22_tree = null;
        ManchesterOWLSyntaxTree SUB_PROPERTY_OF23_tree = null;
        ManchesterOWLSyntaxTree INVERSE_OF24_tree = null;
        ManchesterOWLSyntaxTree SAME_AS25_tree = null;
        ManchesterOWLSyntaxTree DIFFERENT_FROM26_tree = null;
        ManchesterOWLSyntaxTree DOMAIN27_tree = null;
        ManchesterOWLSyntaxTree RANGE29_tree = null;
        RewriteRuleTokenStream stream_RANGE = new RewriteRuleTokenStream(adaptor,
                "token RANGE");
        RewriteRuleTokenStream stream_SAME_AS = new RewriteRuleTokenStream(adaptor,
                "token SAME_AS");
        RewriteRuleTokenStream stream_DISJOINT_WITH = new RewriteRuleTokenStream(adaptor,
                "token DISJOINT_WITH");
        RewriteRuleTokenStream stream_INVERSE_OF = new RewriteRuleTokenStream(adaptor,
                "token INVERSE_OF");
        RewriteRuleTokenStream stream_DIFFERENT_FROM = new RewriteRuleTokenStream(
                adaptor, "token DIFFERENT_FROM");
        RewriteRuleTokenStream stream_EQUIVALENT_TO = new RewriteRuleTokenStream(adaptor,
                "token EQUIVALENT_TO");
        RewriteRuleTokenStream stream_SUBCLASS_OF = new RewriteRuleTokenStream(adaptor,
                "token SUBCLASS_OF");
        RewriteRuleTokenStream stream_DOMAIN = new RewriteRuleTokenStream(adaptor,
                "token DOMAIN");
        RewriteRuleTokenStream stream_SUB_PROPERTY_OF = new RewriteRuleTokenStream(
                adaptor, "token SUB_PROPERTY_OF");
        RewriteRuleSubtreeStream stream_expression = new RewriteRuleSubtreeStream(
                adaptor, "rule expression");
        RewriteRuleSubtreeStream stream_propertyExpression = new RewriteRuleSubtreeStream(
                adaptor, "rule propertyExpression");
        RewriteRuleSubtreeStream stream_atomic = new RewriteRuleSubtreeStream(adaptor,
                "rule atomic");
        try {
            // MOWLParser.g:102:26: (lhs= expression SUBCLASS_OF superClass=
            // expression -> ^( SUB_CLASS_AXIOM ^( EXPRESSION $lhs) ^(
            // EXPRESSION $superClass) ) | lhs= expression EQUIVALENT_TO rhs=
            // expression -> ^( EQUIVALENT_TO_AXIOM ^( EXPRESSION $lhs) ^(
            // EXPRESSION $rhs) ) | lhs= expression DISJOINT_WITH disjoint=
            // expression -> ^( DISJOINT_WITH_AXIOM ^( EXPRESSION $lhs) ^(
            // EXPRESSION $disjoint) ) | lhs= expression SUB_PROPERTY_OF
            // superProperty= propertyExpression -> ^( SUB_PROPERTY_AXIOM ^(
            // EXPRESSION $lhs) ^( EXPRESSION $superProperty) ) | lhsID= atomic
            // INVERSE_OF rhsAtomic= atomic -> ^( INVERSE_OF ^( EXPRESSION
            // $lhsID) ^( EXPRESSION $rhsAtomic) ) | lhsID= atomic SAME_AS
            // rhsID= atomic -> ^( SAME_AS_AXIOM ^( EXPRESSION $lhsID) ^(
            // EXPRESSION $rhsID) ) | lhsID= atomic DIFFERENT_FROM rhsID= atomic
            // -> ^( DIFFERENT_FROM_AXIOM ^( EXPRESSION $lhsID) ^( EXPRESSION
            // $rhsID) ) | lhsID= atomic DOMAIN expression -> ^( DOMAIN ^(
            // EXPRESSION $lhsID) ^( EXPRESSION expression ) ) | lhsID= atomic
            // RANGE expression -> ^( RANGE ^( EXPRESSION $lhsID) ^( EXPRESSION
            // expression ) ) )
            int alt6 = 9;
            alt6 = dfa6.predict(input);
            switch (alt6) {
                case 1:
                // MOWLParser.g:103:2: lhs= expression SUBCLASS_OF superClass=
                // expression
                {
                    pushFollow(FOLLOW_expression_in_binaryAxiom639);
                    lhs = expression();
                    state._fsp--;
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        stream_expression.add(lhs.getTree());
                    }
                    SUBCLASS_OF20 = (Token) match(input, SUBCLASS_OF,
                            FOLLOW_SUBCLASS_OF_in_binaryAxiom641);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        stream_SUBCLASS_OF.add(SUBCLASS_OF20);
                    }
                    pushFollow(FOLLOW_expression_in_binaryAxiom648);
                    superClass = expression();
                    state._fsp--;
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        stream_expression.add(superClass.getTree());
                    }
                    // AST REWRITE
                    // elements: superClass, lhs
                    // token labels:
                    // rule labels: retval, superClass, lhs
                    // token list labels:
                    // rule list labels:
                    // wildcard labels:
                    if (state.backtracking == 0) {
                        retval.tree = root_0;
                        RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(
                                adaptor, "rule retval", retval != null ? retval.tree
                                        : null);
                        RewriteRuleSubtreeStream stream_superClass = new RewriteRuleSubtreeStream(
                                adaptor, "rule superClass",
                                superClass != null ? superClass.tree : null);
                        RewriteRuleSubtreeStream stream_lhs = new RewriteRuleSubtreeStream(
                                adaptor, "rule lhs", lhs != null ? lhs.tree : null);
                        root_0 = (ManchesterOWLSyntaxTree) adaptor.nil();
                        // 103:57: -> ^( SUB_CLASS_AXIOM ^( EXPRESSION $lhs) ^(
                        // EXPRESSION $superClass) )
                        {
                            // MOWLParser.g:103:60: ^( SUB_CLASS_AXIOM ^(
                            // EXPRESSION $lhs) ^( EXPRESSION $superClass) )
                            {
                                ManchesterOWLSyntaxTree root_1 = (ManchesterOWLSyntaxTree) adaptor
                                        .nil();
                                root_1 = (ManchesterOWLSyntaxTree) adaptor
                                        .becomeRoot(adaptor.create(SUB_CLASS_AXIOM,
                                                "SUB_CLASS_AXIOM"), root_1);
                                // MOWLParser.g:103:79: ^( EXPRESSION $lhs)
                                {
                                    ManchesterOWLSyntaxTree root_2 = (ManchesterOWLSyntaxTree) adaptor
                                            .nil();
                                    root_2 = (ManchesterOWLSyntaxTree) adaptor
                                            .becomeRoot(adaptor.create(EXPRESSION,
                                                    "EXPRESSION"), root_2);
                                    adaptor.addChild(root_2, stream_lhs.nextTree());
                                    adaptor.addChild(root_1, root_2);
                                }
                                // MOWLParser.g:103:98: ^( EXPRESSION
                                // $superClass)
                                {
                                    ManchesterOWLSyntaxTree root_2 = (ManchesterOWLSyntaxTree) adaptor
                                            .nil();
                                    root_2 = (ManchesterOWLSyntaxTree) adaptor
                                            .becomeRoot(adaptor.create(EXPRESSION,
                                                    "EXPRESSION"), root_2);
                                    adaptor.addChild(root_2, stream_superClass.nextTree());
                                    adaptor.addChild(root_1, root_2);
                                }
                                adaptor.addChild(root_0, root_1);
                            }
                        }
                        retval.tree = root_0;
                    }
                }
                    break;
                case 2:
                // MOWLParser.g:104:11: lhs= expression EQUIVALENT_TO rhs=
                // expression
                {
                    pushFollow(FOLLOW_expression_in_binaryAxiom686);
                    lhs = expression();
                    state._fsp--;
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        stream_expression.add(lhs.getTree());
                    }
                    EQUIVALENT_TO21 = (Token) match(input, EQUIVALENT_TO,
                            FOLLOW_EQUIVALENT_TO_in_binaryAxiom688);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        stream_EQUIVALENT_TO.add(EQUIVALENT_TO21);
                    }
                    pushFollow(FOLLOW_expression_in_binaryAxiom694);
                    rhs = expression();
                    state._fsp--;
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        stream_expression.add(rhs.getTree());
                    }
                    // AST REWRITE
                    // elements: rhs, lhs
                    // token labels:
                    // rule labels: retval, rhs, lhs
                    // token list labels:
                    // rule list labels:
                    // wildcard labels:
                    if (state.backtracking == 0) {
                        retval.tree = root_0;
                        RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(
                                adaptor, "rule retval", retval != null ? retval.tree
                                        : null);
                        RewriteRuleSubtreeStream stream_rhs = new RewriteRuleSubtreeStream(
                                adaptor, "rule rhs", rhs != null ? rhs.tree : null);
                        RewriteRuleSubtreeStream stream_lhs = new RewriteRuleSubtreeStream(
                                adaptor, "rule lhs", lhs != null ? lhs.tree : null);
                        root_0 = (ManchesterOWLSyntaxTree) adaptor.nil();
                        // 104:60: -> ^( EQUIVALENT_TO_AXIOM ^( EXPRESSION $lhs)
                        // ^( EXPRESSION $rhs) )
                        {
                            // MOWLParser.g:104:63: ^( EQUIVALENT_TO_AXIOM ^(
                            // EXPRESSION $lhs) ^( EXPRESSION $rhs) )
                            {
                                ManchesterOWLSyntaxTree root_1 = (ManchesterOWLSyntaxTree) adaptor
                                        .nil();
                                root_1 = (ManchesterOWLSyntaxTree) adaptor.becomeRoot(
                                        adaptor.create(EQUIVALENT_TO_AXIOM,
                                                "EQUIVALENT_TO_AXIOM"), root_1);
                                // MOWLParser.g:104:85: ^( EXPRESSION $lhs)
                                {
                                    ManchesterOWLSyntaxTree root_2 = (ManchesterOWLSyntaxTree) adaptor
                                            .nil();
                                    root_2 = (ManchesterOWLSyntaxTree) adaptor
                                            .becomeRoot(adaptor.create(EXPRESSION,
                                                    "EXPRESSION"), root_2);
                                    adaptor.addChild(root_2, stream_lhs.nextTree());
                                    adaptor.addChild(root_1, root_2);
                                }
                                // MOWLParser.g:104:104: ^( EXPRESSION $rhs)
                                {
                                    ManchesterOWLSyntaxTree root_2 = (ManchesterOWLSyntaxTree) adaptor
                                            .nil();
                                    root_2 = (ManchesterOWLSyntaxTree) adaptor
                                            .becomeRoot(adaptor.create(EXPRESSION,
                                                    "EXPRESSION"), root_2);
                                    adaptor.addChild(root_2, stream_rhs.nextTree());
                                    adaptor.addChild(root_1, root_2);
                                }
                                adaptor.addChild(root_0, root_1);
                            }
                        }
                        retval.tree = root_0;
                    }
                }
                    break;
                case 3:
                // MOWLParser.g:105:11: lhs= expression DISJOINT_WITH disjoint=
                // expression
                {
                    pushFollow(FOLLOW_expression_in_binaryAxiom731);
                    lhs = expression();
                    state._fsp--;
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        stream_expression.add(lhs.getTree());
                    }
                    DISJOINT_WITH22 = (Token) match(input, DISJOINT_WITH,
                            FOLLOW_DISJOINT_WITH_in_binaryAxiom733);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        stream_DISJOINT_WITH.add(DISJOINT_WITH22);
                    }
                    pushFollow(FOLLOW_expression_in_binaryAxiom739);
                    disjoint = expression();
                    state._fsp--;
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        stream_expression.add(disjoint.getTree());
                    }
                    // AST REWRITE
                    // elements: disjoint, lhs
                    // token labels:
                    // rule labels: retval, disjoint, lhs
                    // token list labels:
                    // rule list labels:
                    // wildcard labels:
                    if (state.backtracking == 0) {
                        retval.tree = root_0;
                        RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(
                                adaptor, "rule retval", retval != null ? retval.tree
                                        : null);
                        RewriteRuleSubtreeStream stream_disjoint = new RewriteRuleSubtreeStream(
                                adaptor, "rule disjoint",
                                disjoint != null ? disjoint.tree : null);
                        RewriteRuleSubtreeStream stream_lhs = new RewriteRuleSubtreeStream(
                                adaptor, "rule lhs", lhs != null ? lhs.tree : null);
                        root_0 = (ManchesterOWLSyntaxTree) adaptor.nil();
                        // 105:65: -> ^( DISJOINT_WITH_AXIOM ^( EXPRESSION $lhs)
                        // ^( EXPRESSION $disjoint) )
                        {
                            // MOWLParser.g:105:68: ^( DISJOINT_WITH_AXIOM ^(
                            // EXPRESSION $lhs) ^( EXPRESSION $disjoint) )
                            {
                                ManchesterOWLSyntaxTree root_1 = (ManchesterOWLSyntaxTree) adaptor
                                        .nil();
                                root_1 = (ManchesterOWLSyntaxTree) adaptor.becomeRoot(
                                        adaptor.create(DISJOINT_WITH_AXIOM,
                                                "DISJOINT_WITH_AXIOM"), root_1);
                                // MOWLParser.g:105:90: ^( EXPRESSION $lhs)
                                {
                                    ManchesterOWLSyntaxTree root_2 = (ManchesterOWLSyntaxTree) adaptor
                                            .nil();
                                    root_2 = (ManchesterOWLSyntaxTree) adaptor
                                            .becomeRoot(adaptor.create(EXPRESSION,
                                                    "EXPRESSION"), root_2);
                                    adaptor.addChild(root_2, stream_lhs.nextTree());
                                    adaptor.addChild(root_1, root_2);
                                }
                                // MOWLParser.g:105:109: ^( EXPRESSION
                                // $disjoint)
                                {
                                    ManchesterOWLSyntaxTree root_2 = (ManchesterOWLSyntaxTree) adaptor
                                            .nil();
                                    root_2 = (ManchesterOWLSyntaxTree) adaptor
                                            .becomeRoot(adaptor.create(EXPRESSION,
                                                    "EXPRESSION"), root_2);
                                    adaptor.addChild(root_2, stream_disjoint.nextTree());
                                    adaptor.addChild(root_1, root_2);
                                }
                                adaptor.addChild(root_0, root_1);
                            }
                        }
                        retval.tree = root_0;
                    }
                }
                    break;
                case 4:
                // MOWLParser.g:106:11: lhs= expression SUB_PROPERTY_OF
                // superProperty= propertyExpression
                {
                    pushFollow(FOLLOW_expression_in_binaryAxiom776);
                    lhs = expression();
                    state._fsp--;
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        stream_expression.add(lhs.getTree());
                    }
                    SUB_PROPERTY_OF23 = (Token) match(input, SUB_PROPERTY_OF,
                            FOLLOW_SUB_PROPERTY_OF_in_binaryAxiom778);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        stream_SUB_PROPERTY_OF.add(SUB_PROPERTY_OF23);
                    }
                    pushFollow(FOLLOW_propertyExpression_in_binaryAxiom784);
                    superProperty = propertyExpression();
                    state._fsp--;
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        stream_propertyExpression.add(superProperty.getTree());
                    }
                    // AST REWRITE
                    // elements: lhs, superProperty
                    // token labels:
                    // rule labels: retval, superProperty, lhs
                    // token list labels:
                    // rule list labels:
                    // wildcard labels:
                    if (state.backtracking == 0) {
                        retval.tree = root_0;
                        RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(
                                adaptor, "rule retval", retval != null ? retval.tree
                                        : null);
                        RewriteRuleSubtreeStream stream_superProperty = new RewriteRuleSubtreeStream(
                                adaptor, "rule superProperty",
                                superProperty != null ? superProperty.tree : null);
                        RewriteRuleSubtreeStream stream_lhs = new RewriteRuleSubtreeStream(
                                adaptor, "rule lhs", lhs != null ? lhs.tree : null);
                        root_0 = (ManchesterOWLSyntaxTree) adaptor.nil();
                        // 106:80: -> ^( SUB_PROPERTY_AXIOM ^( EXPRESSION $lhs)
                        // ^( EXPRESSION $superProperty) )
                        {
                            // MOWLParser.g:106:83: ^( SUB_PROPERTY_AXIOM ^(
                            // EXPRESSION $lhs) ^( EXPRESSION $superProperty) )
                            {
                                ManchesterOWLSyntaxTree root_1 = (ManchesterOWLSyntaxTree) adaptor
                                        .nil();
                                root_1 = (ManchesterOWLSyntaxTree) adaptor.becomeRoot(
                                        adaptor.create(SUB_PROPERTY_AXIOM,
                                                "SUB_PROPERTY_AXIOM"), root_1);
                                // MOWLParser.g:106:104: ^( EXPRESSION $lhs)
                                {
                                    ManchesterOWLSyntaxTree root_2 = (ManchesterOWLSyntaxTree) adaptor
                                            .nil();
                                    root_2 = (ManchesterOWLSyntaxTree) adaptor
                                            .becomeRoot(adaptor.create(EXPRESSION,
                                                    "EXPRESSION"), root_2);
                                    adaptor.addChild(root_2, stream_lhs.nextTree());
                                    adaptor.addChild(root_1, root_2);
                                }
                                // MOWLParser.g:106:123: ^( EXPRESSION
                                // $superProperty)
                                {
                                    ManchesterOWLSyntaxTree root_2 = (ManchesterOWLSyntaxTree) adaptor
                                            .nil();
                                    root_2 = (ManchesterOWLSyntaxTree) adaptor
                                            .becomeRoot(adaptor.create(EXPRESSION,
                                                    "EXPRESSION"), root_2);
                                    adaptor.addChild(root_2,
                                            stream_superProperty.nextTree());
                                    adaptor.addChild(root_1, root_2);
                                }
                                adaptor.addChild(root_0, root_1);
                            }
                        }
                        retval.tree = root_0;
                    }
                }
                    break;
                case 5:
                // MOWLParser.g:107:11: lhsID= atomic INVERSE_OF rhsAtomic=
                // atomic
                {
                    pushFollow(FOLLOW_atomic_in_binaryAxiom821);
                    lhsID = atomic();
                    state._fsp--;
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        stream_atomic.add(lhsID.getTree());
                    }
                    INVERSE_OF24 = (Token) match(input, INVERSE_OF,
                            FOLLOW_INVERSE_OF_in_binaryAxiom823);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        stream_INVERSE_OF.add(INVERSE_OF24);
                    }
                    pushFollow(FOLLOW_atomic_in_binaryAxiom829);
                    rhsAtomic = atomic();
                    state._fsp--;
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        stream_atomic.add(rhsAtomic.getTree());
                    }
                    // AST REWRITE
                    // elements: INVERSE_OF, rhsAtomic, lhsID
                    // token labels:
                    // rule labels: lhsID, retval, rhsAtomic
                    // token list labels:
                    // rule list labels:
                    // wildcard labels:
                    if (state.backtracking == 0) {
                        retval.tree = root_0;
                        RewriteRuleSubtreeStream stream_lhsID = new RewriteRuleSubtreeStream(
                                adaptor, "rule lhsID", lhsID != null ? lhsID.tree : null);
                        RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(
                                adaptor, "rule retval", retval != null ? retval.tree
                                        : null);
                        RewriteRuleSubtreeStream stream_rhsAtomic = new RewriteRuleSubtreeStream(
                                adaptor, "rule rhsAtomic",
                                rhsAtomic != null ? rhsAtomic.tree : null);
                        root_0 = (ManchesterOWLSyntaxTree) adaptor.nil();
                        // 107:57: -> ^( INVERSE_OF ^( EXPRESSION $lhsID) ^(
                        // EXPRESSION $rhsAtomic) )
                        {
                            // MOWLParser.g:107:60: ^( INVERSE_OF ^( EXPRESSION
                            // $lhsID) ^( EXPRESSION $rhsAtomic) )
                            {
                                ManchesterOWLSyntaxTree root_1 = (ManchesterOWLSyntaxTree) adaptor
                                        .nil();
                                root_1 = (ManchesterOWLSyntaxTree) adaptor.becomeRoot(
                                        stream_INVERSE_OF.nextNode(), root_1);
                                // MOWLParser.g:107:73: ^( EXPRESSION $lhsID)
                                {
                                    ManchesterOWLSyntaxTree root_2 = (ManchesterOWLSyntaxTree) adaptor
                                            .nil();
                                    root_2 = (ManchesterOWLSyntaxTree) adaptor
                                            .becomeRoot(adaptor.create(EXPRESSION,
                                                    "EXPRESSION"), root_2);
                                    adaptor.addChild(root_2, stream_lhsID.nextTree());
                                    adaptor.addChild(root_1, root_2);
                                }
                                // MOWLParser.g:107:94: ^( EXPRESSION
                                // $rhsAtomic)
                                {
                                    ManchesterOWLSyntaxTree root_2 = (ManchesterOWLSyntaxTree) adaptor
                                            .nil();
                                    root_2 = (ManchesterOWLSyntaxTree) adaptor
                                            .becomeRoot(adaptor.create(EXPRESSION,
                                                    "EXPRESSION"), root_2);
                                    adaptor.addChild(root_2, stream_rhsAtomic.nextTree());
                                    adaptor.addChild(root_1, root_2);
                                }
                                adaptor.addChild(root_0, root_1);
                            }
                        }
                        retval.tree = root_0;
                    }
                }
                    break;
                case 6:
                // MOWLParser.g:108:3: lhsID= atomic SAME_AS rhsID= atomic
                {
                    pushFollow(FOLLOW_atomic_in_binaryAxiom860);
                    lhsID = atomic();
                    state._fsp--;
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        stream_atomic.add(lhsID.getTree());
                    }
                    SAME_AS25 = (Token) match(input, SAME_AS,
                            FOLLOW_SAME_AS_in_binaryAxiom862);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        stream_SAME_AS.add(SAME_AS25);
                    }
                    pushFollow(FOLLOW_atomic_in_binaryAxiom869);
                    rhsID = atomic();
                    state._fsp--;
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        stream_atomic.add(rhsID.getTree());
                    }
                    // AST REWRITE
                    // elements: rhsID, lhsID
                    // token labels:
                    // rule labels: lhsID, retval, rhsID
                    // token list labels:
                    // rule list labels:
                    // wildcard labels:
                    if (state.backtracking == 0) {
                        retval.tree = root_0;
                        RewriteRuleSubtreeStream stream_lhsID = new RewriteRuleSubtreeStream(
                                adaptor, "rule lhsID", lhsID != null ? lhsID.tree : null);
                        RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(
                                adaptor, "rule retval", retval != null ? retval.tree
                                        : null);
                        RewriteRuleSubtreeStream stream_rhsID = new RewriteRuleSubtreeStream(
                                adaptor, "rule rhsID", rhsID != null ? rhsID.tree : null);
                        root_0 = (ManchesterOWLSyntaxTree) adaptor.nil();
                        // 108:43: -> ^( SAME_AS_AXIOM ^( EXPRESSION $lhsID) ^(
                        // EXPRESSION $rhsID) )
                        {
                            // MOWLParser.g:108:46: ^( SAME_AS_AXIOM ^(
                            // EXPRESSION $lhsID) ^( EXPRESSION $rhsID) )
                            {
                                ManchesterOWLSyntaxTree root_1 = (ManchesterOWLSyntaxTree) adaptor
                                        .nil();
                                root_1 = (ManchesterOWLSyntaxTree) adaptor.becomeRoot(
                                        adaptor.create(SAME_AS_AXIOM, "SAME_AS_AXIOM"),
                                        root_1);
                                // MOWLParser.g:108:62: ^( EXPRESSION $lhsID)
                                {
                                    ManchesterOWLSyntaxTree root_2 = (ManchesterOWLSyntaxTree) adaptor
                                            .nil();
                                    root_2 = (ManchesterOWLSyntaxTree) adaptor
                                            .becomeRoot(adaptor.create(EXPRESSION,
                                                    "EXPRESSION"), root_2);
                                    adaptor.addChild(root_2, stream_lhsID.nextTree());
                                    adaptor.addChild(root_1, root_2);
                                }
                                // MOWLParser.g:108:84: ^( EXPRESSION $rhsID)
                                {
                                    ManchesterOWLSyntaxTree root_2 = (ManchesterOWLSyntaxTree) adaptor
                                            .nil();
                                    root_2 = (ManchesterOWLSyntaxTree) adaptor
                                            .becomeRoot(adaptor.create(EXPRESSION,
                                                    "EXPRESSION"), root_2);
                                    adaptor.addChild(root_2, stream_rhsID.nextTree());
                                    adaptor.addChild(root_1, root_2);
                                }
                                adaptor.addChild(root_0, root_1);
                            }
                        }
                        retval.tree = root_0;
                    }
                }
                    break;
                case 7:
                // MOWLParser.g:109:11: lhsID= atomic DIFFERENT_FROM rhsID=
                // atomic
                {
                    pushFollow(FOLLOW_atomic_in_binaryAxiom907);
                    lhsID = atomic();
                    state._fsp--;
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        stream_atomic.add(lhsID.getTree());
                    }
                    DIFFERENT_FROM26 = (Token) match(input, DIFFERENT_FROM,
                            FOLLOW_DIFFERENT_FROM_in_binaryAxiom909);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        stream_DIFFERENT_FROM.add(DIFFERENT_FROM26);
                    }
                    pushFollow(FOLLOW_atomic_in_binaryAxiom916);
                    rhsID = atomic();
                    state._fsp--;
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        stream_atomic.add(rhsID.getTree());
                    }
                    // AST REWRITE
                    // elements: rhsID, lhsID
                    // token labels:
                    // rule labels: lhsID, retval, rhsID
                    // token list labels:
                    // rule list labels:
                    // wildcard labels:
                    if (state.backtracking == 0) {
                        retval.tree = root_0;
                        RewriteRuleSubtreeStream stream_lhsID = new RewriteRuleSubtreeStream(
                                adaptor, "rule lhsID", lhsID != null ? lhsID.tree : null);
                        RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(
                                adaptor, "rule retval", retval != null ? retval.tree
                                        : null);
                        RewriteRuleSubtreeStream stream_rhsID = new RewriteRuleSubtreeStream(
                                adaptor, "rule rhsID", rhsID != null ? rhsID.tree : null);
                        root_0 = (ManchesterOWLSyntaxTree) adaptor.nil();
                        // 109:58: -> ^( DIFFERENT_FROM_AXIOM ^( EXPRESSION
                        // $lhsID) ^( EXPRESSION $rhsID) )
                        {
                            // MOWLParser.g:109:61: ^( DIFFERENT_FROM_AXIOM ^(
                            // EXPRESSION $lhsID) ^( EXPRESSION $rhsID) )
                            {
                                ManchesterOWLSyntaxTree root_1 = (ManchesterOWLSyntaxTree) adaptor
                                        .nil();
                                root_1 = (ManchesterOWLSyntaxTree) adaptor.becomeRoot(
                                        adaptor.create(DIFFERENT_FROM_AXIOM,
                                                "DIFFERENT_FROM_AXIOM"), root_1);
                                // MOWLParser.g:109:84: ^( EXPRESSION $lhsID)
                                {
                                    ManchesterOWLSyntaxTree root_2 = (ManchesterOWLSyntaxTree) adaptor
                                            .nil();
                                    root_2 = (ManchesterOWLSyntaxTree) adaptor
                                            .becomeRoot(adaptor.create(EXPRESSION,
                                                    "EXPRESSION"), root_2);
                                    adaptor.addChild(root_2, stream_lhsID.nextTree());
                                    adaptor.addChild(root_1, root_2);
                                }
                                // MOWLParser.g:109:105: ^( EXPRESSION $rhsID)
                                {
                                    ManchesterOWLSyntaxTree root_2 = (ManchesterOWLSyntaxTree) adaptor
                                            .nil();
                                    root_2 = (ManchesterOWLSyntaxTree) adaptor
                                            .becomeRoot(adaptor.create(EXPRESSION,
                                                    "EXPRESSION"), root_2);
                                    adaptor.addChild(root_2, stream_rhsID.nextTree());
                                    adaptor.addChild(root_1, root_2);
                                }
                                adaptor.addChild(root_0, root_1);
                            }
                        }
                        retval.tree = root_0;
                    }
                }
                    break;
                case 8:
                // MOWLParser.g:110:11: lhsID= atomic DOMAIN expression
                {
                    pushFollow(FOLLOW_atomic_in_binaryAxiom953);
                    lhsID = atomic();
                    state._fsp--;
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        stream_atomic.add(lhsID.getTree());
                    }
                    DOMAIN27 = (Token) match(input, DOMAIN,
                            FOLLOW_DOMAIN_in_binaryAxiom956);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        stream_DOMAIN.add(DOMAIN27);
                    }
                    pushFollow(FOLLOW_expression_in_binaryAxiom958);
                    expression28 = expression();
                    state._fsp--;
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        stream_expression.add(expression28.getTree());
                    }
                    // AST REWRITE
                    // elements: DOMAIN, expression, lhsID
                    // token labels:
                    // rule labels: lhsID, retval
                    // token list labels:
                    // rule list labels:
                    // wildcard labels:
                    if (state.backtracking == 0) {
                        retval.tree = root_0;
                        RewriteRuleSubtreeStream stream_lhsID = new RewriteRuleSubtreeStream(
                                adaptor, "rule lhsID", lhsID != null ? lhsID.tree : null);
                        RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(
                                adaptor, "rule retval", retval != null ? retval.tree
                                        : null);
                        root_0 = (ManchesterOWLSyntaxTree) adaptor.nil();
                        // 110:46: -> ^( DOMAIN ^( EXPRESSION $lhsID) ^(
                        // EXPRESSION expression ) )
                        {
                            // MOWLParser.g:110:49: ^( DOMAIN ^( EXPRESSION
                            // $lhsID) ^( EXPRESSION expression ) )
                            {
                                ManchesterOWLSyntaxTree root_1 = (ManchesterOWLSyntaxTree) adaptor
                                        .nil();
                                root_1 = (ManchesterOWLSyntaxTree) adaptor.becomeRoot(
                                        stream_DOMAIN.nextNode(), root_1);
                                // MOWLParser.g:110:58: ^( EXPRESSION $lhsID)
                                {
                                    ManchesterOWLSyntaxTree root_2 = (ManchesterOWLSyntaxTree) adaptor
                                            .nil();
                                    root_2 = (ManchesterOWLSyntaxTree) adaptor
                                            .becomeRoot(adaptor.create(EXPRESSION,
                                                    "EXPRESSION"), root_2);
                                    adaptor.addChild(root_2, stream_lhsID.nextTree());
                                    adaptor.addChild(root_1, root_2);
                                }
                                // MOWLParser.g:110:79: ^( EXPRESSION expression
                                // )
                                {
                                    ManchesterOWLSyntaxTree root_2 = (ManchesterOWLSyntaxTree) adaptor
                                            .nil();
                                    root_2 = (ManchesterOWLSyntaxTree) adaptor
                                            .becomeRoot(adaptor.create(EXPRESSION,
                                                    "EXPRESSION"), root_2);
                                    adaptor.addChild(root_2, stream_expression.nextTree());
                                    adaptor.addChild(root_1, root_2);
                                }
                                adaptor.addChild(root_0, root_1);
                            }
                        }
                        retval.tree = root_0;
                    }
                }
                    break;
                case 9:
                // MOWLParser.g:111:11: lhsID= atomic RANGE expression
                {
                    pushFollow(FOLLOW_atomic_in_binaryAxiom994);
                    lhsID = atomic();
                    state._fsp--;
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        stream_atomic.add(lhsID.getTree());
                    }
                    RANGE29 = (Token) match(input, RANGE, FOLLOW_RANGE_in_binaryAxiom996);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        stream_RANGE.add(RANGE29);
                    }
                    pushFollow(FOLLOW_expression_in_binaryAxiom998);
                    expression30 = expression();
                    state._fsp--;
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        stream_expression.add(expression30.getTree());
                    }
                    // AST REWRITE
                    // elements: lhsID, expression, RANGE
                    // token labels:
                    // rule labels: lhsID, retval
                    // token list labels:
                    // rule list labels:
                    // wildcard labels:
                    if (state.backtracking == 0) {
                        retval.tree = root_0;
                        RewriteRuleSubtreeStream stream_lhsID = new RewriteRuleSubtreeStream(
                                adaptor, "rule lhsID", lhsID != null ? lhsID.tree : null);
                        RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(
                                adaptor, "rule retval", retval != null ? retval.tree
                                        : null);
                        root_0 = (ManchesterOWLSyntaxTree) adaptor.nil();
                        // 111:44: -> ^( RANGE ^( EXPRESSION $lhsID) ^(
                        // EXPRESSION expression ) )
                        {
                            // MOWLParser.g:111:47: ^( RANGE ^( EXPRESSION
                            // $lhsID) ^( EXPRESSION expression ) )
                            {
                                ManchesterOWLSyntaxTree root_1 = (ManchesterOWLSyntaxTree) adaptor
                                        .nil();
                                root_1 = (ManchesterOWLSyntaxTree) adaptor.becomeRoot(
                                        stream_RANGE.nextNode(), root_1);
                                // MOWLParser.g:111:55: ^( EXPRESSION $lhsID)
                                {
                                    ManchesterOWLSyntaxTree root_2 = (ManchesterOWLSyntaxTree) adaptor
                                            .nil();
                                    root_2 = (ManchesterOWLSyntaxTree) adaptor
                                            .becomeRoot(adaptor.create(EXPRESSION,
                                                    "EXPRESSION"), root_2);
                                    adaptor.addChild(root_2, stream_lhsID.nextTree());
                                    adaptor.addChild(root_1, root_2);
                                }
                                // MOWLParser.g:111:76: ^( EXPRESSION expression
                                // )
                                {
                                    ManchesterOWLSyntaxTree root_2 = (ManchesterOWLSyntaxTree) adaptor
                                            .nil();
                                    root_2 = (ManchesterOWLSyntaxTree) adaptor
                                            .becomeRoot(adaptor.create(EXPRESSION,
                                                    "EXPRESSION"), root_2);
                                    adaptor.addChild(root_2, stream_expression.nextTree());
                                    adaptor.addChild(root_1, root_2);
                                }
                                adaptor.addChild(root_0, root_1);
                            }
                        }
                        retval.tree = root_0;
                    }
                }
                    break;
            }
            retval.stop = input.LT(-1);
            if (state.backtracking == 0) {
                retval.tree = (ManchesterOWLSyntaxTree) adaptor
                        .rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        } catch (RecognitionException e) {
            throw e;
        } catch (RewriteEmptyStreamException e) {
            throw e;
        } finally {}
        return retval;
    }

    // $ANTLR end "binaryAxiom"
    public static class unaryAxiom_return extends ParserRuleReturnScope {
        ManchesterOWLSyntaxTree tree;

        @Override
        public Object getTree() {
            return tree;
        }
    };

    // $ANTLR start "unaryAxiom"
    // MOWLParser.g:115:1: unaryAxiom : unaryCharacteristic unary -> ^(
    // UNARY_AXIOM unaryCharacteristic ^( EXPRESSION unary ) ) ;
    public final ManchesterOWLSyntax_MOWLParser.unaryAxiom_return unaryAxiom()
            throws RecognitionException {
        ManchesterOWLSyntax_MOWLParser.unaryAxiom_return retval = new ManchesterOWLSyntax_MOWLParser.unaryAxiom_return();
        retval.start = input.LT(1);
        ManchesterOWLSyntaxTree root_0 = null;
        ManchesterOWLSyntax_MOWLParser.unaryCharacteristic_return unaryCharacteristic31 = null;
        ManchesterOWLSyntax_MOWLParser.unary_return unary32 = null;
        RewriteRuleSubtreeStream stream_unary = new RewriteRuleSubtreeStream(adaptor,
                "rule unary");
        RewriteRuleSubtreeStream stream_unaryCharacteristic = new RewriteRuleSubtreeStream(
                adaptor, "rule unaryCharacteristic");
        try {
            // MOWLParser.g:115:13: ( unaryCharacteristic unary -> ^(
            // UNARY_AXIOM unaryCharacteristic ^( EXPRESSION unary ) ) )
            // MOWLParser.g:116:4: unaryCharacteristic unary
            {
                pushFollow(FOLLOW_unaryCharacteristic_in_unaryAxiom1072);
                unaryCharacteristic31 = unaryCharacteristic();
                state._fsp--;
                if (state.failed) {
                    return retval;
                }
                if (state.backtracking == 0) {
                    stream_unaryCharacteristic.add(unaryCharacteristic31.getTree());
                }
                pushFollow(FOLLOW_unary_in_unaryAxiom1076);
                unary32 = unary();
                state._fsp--;
                if (state.failed) {
                    return retval;
                }
                if (state.backtracking == 0) {
                    stream_unary.add(unary32.getTree());
                }
                // AST REWRITE
                // elements: unary, unaryCharacteristic
                // token labels:
                // rule labels: retval
                // token list labels:
                // rule list labels:
                // wildcard labels:
                if (state.backtracking == 0) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(
                            adaptor, "rule retval", retval != null ? retval.tree : null);
                    root_0 = (ManchesterOWLSyntaxTree) adaptor.nil();
                    // 116:32: -> ^( UNARY_AXIOM unaryCharacteristic ^(
                    // EXPRESSION unary ) )
                    {
                        // MOWLParser.g:116:35: ^( UNARY_AXIOM
                        // unaryCharacteristic ^( EXPRESSION unary ) )
                        {
                            ManchesterOWLSyntaxTree root_1 = (ManchesterOWLSyntaxTree) adaptor
                                    .nil();
                            root_1 = (ManchesterOWLSyntaxTree) adaptor.becomeRoot(
                                    adaptor.create(UNARY_AXIOM, "UNARY_AXIOM"), root_1);
                            adaptor.addChild(root_1,
                                    stream_unaryCharacteristic.nextTree());
                            // MOWLParser.g:116:69: ^( EXPRESSION unary )
                            {
                                ManchesterOWLSyntaxTree root_2 = (ManchesterOWLSyntaxTree) adaptor
                                        .nil();
                                root_2 = (ManchesterOWLSyntaxTree) adaptor.becomeRoot(
                                        adaptor.create(EXPRESSION, "EXPRESSION"), root_2);
                                adaptor.addChild(root_2, stream_unary.nextTree());
                                adaptor.addChild(root_1, root_2);
                            }
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
            throw e;
        } catch (RewriteEmptyStreamException e) {
            throw e;
        } finally {}
        return retval;
    }

    // $ANTLR end "unaryAxiom"
    public static class unaryCharacteristic_return extends ParserRuleReturnScope {
        ManchesterOWLSyntaxTree tree;

        @Override
        public Object getTree() {
            return tree;
        }
    };

    // $ANTLR start "unaryCharacteristic"
    // MOWLParser.g:119:1: unaryCharacteristic : ( FUNCTIONAL -> ^( FUNCTIONAL )
    // | INVERSE_FUNCTIONAL -> ^( INVERSE_FUNCTIONAL ) | SYMMETRIC -> ^(
    // SYMMETRIC ) | ANTI_SYMMETRIC -> ^( ANTI_SYMMETRIC ) | REFLEXIVE -> ^(
    // REFLEXIVE ) | IRREFLEXIVE -> ^( IRREFLEXIVE ) | TRANSITIVE -> ^(
    // TRANSITIVE ) );
    public final ManchesterOWLSyntax_MOWLParser.unaryCharacteristic_return
            unaryCharacteristic() throws RecognitionException {
        ManchesterOWLSyntax_MOWLParser.unaryCharacteristic_return retval = new ManchesterOWLSyntax_MOWLParser.unaryCharacteristic_return();
        retval.start = input.LT(1);
        ManchesterOWLSyntaxTree root_0 = null;
        Token FUNCTIONAL33 = null;
        Token INVERSE_FUNCTIONAL34 = null;
        Token SYMMETRIC35 = null;
        Token ANTI_SYMMETRIC36 = null;
        Token REFLEXIVE37 = null;
        Token IRREFLEXIVE38 = null;
        Token TRANSITIVE39 = null;
        ManchesterOWLSyntaxTree FUNCTIONAL33_tree = null;
        ManchesterOWLSyntaxTree INVERSE_FUNCTIONAL34_tree = null;
        ManchesterOWLSyntaxTree SYMMETRIC35_tree = null;
        ManchesterOWLSyntaxTree ANTI_SYMMETRIC36_tree = null;
        ManchesterOWLSyntaxTree REFLEXIVE37_tree = null;
        ManchesterOWLSyntaxTree IRREFLEXIVE38_tree = null;
        ManchesterOWLSyntaxTree TRANSITIVE39_tree = null;
        RewriteRuleTokenStream stream_REFLEXIVE = new RewriteRuleTokenStream(adaptor,
                "token REFLEXIVE");
        RewriteRuleTokenStream stream_SYMMETRIC = new RewriteRuleTokenStream(adaptor,
                "token SYMMETRIC");
        RewriteRuleTokenStream stream_FUNCTIONAL = new RewriteRuleTokenStream(adaptor,
                "token FUNCTIONAL");
        RewriteRuleTokenStream stream_TRANSITIVE = new RewriteRuleTokenStream(adaptor,
                "token TRANSITIVE");
        RewriteRuleTokenStream stream_ANTI_SYMMETRIC = new RewriteRuleTokenStream(
                adaptor, "token ANTI_SYMMETRIC");
        RewriteRuleTokenStream stream_INVERSE_FUNCTIONAL = new RewriteRuleTokenStream(
                adaptor, "token INVERSE_FUNCTIONAL");
        RewriteRuleTokenStream stream_IRREFLEXIVE = new RewriteRuleTokenStream(adaptor,
                "token IRREFLEXIVE");
        try {
            // MOWLParser.g:119:21: ( FUNCTIONAL -> ^( FUNCTIONAL ) |
            // INVERSE_FUNCTIONAL -> ^( INVERSE_FUNCTIONAL ) | SYMMETRIC -> ^(
            // SYMMETRIC ) | ANTI_SYMMETRIC -> ^( ANTI_SYMMETRIC ) | REFLEXIVE
            // -> ^( REFLEXIVE ) | IRREFLEXIVE -> ^( IRREFLEXIVE ) | TRANSITIVE
            // -> ^( TRANSITIVE ) )
            int alt7 = 7;
            switch (input.LA(1)) {
                case FUNCTIONAL: {
                    alt7 = 1;
                }
                    break;
                case INVERSE_FUNCTIONAL: {
                    alt7 = 2;
                }
                    break;
                case SYMMETRIC: {
                    alt7 = 3;
                }
                    break;
                case ANTI_SYMMETRIC: {
                    alt7 = 4;
                }
                    break;
                case REFLEXIVE: {
                    alt7 = 5;
                }
                    break;
                case IRREFLEXIVE: {
                    alt7 = 6;
                }
                    break;
                case TRANSITIVE: {
                    alt7 = 7;
                }
                    break;
                default:
                    if (state.backtracking > 0) {
                        state.failed = true;
                        return retval;
                    }
                    NoViableAltException nvae = new NoViableAltException("", 7, 0, input);
                    throw nvae;
            }
            switch (alt7) {
                case 1:
                // MOWLParser.g:120:5: FUNCTIONAL
                {
                    FUNCTIONAL33 = (Token) match(input, FUNCTIONAL,
                            FOLLOW_FUNCTIONAL_in_unaryCharacteristic1121);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        stream_FUNCTIONAL.add(FUNCTIONAL33);
                    }
                    // AST REWRITE
                    // elements: FUNCTIONAL
                    // token labels:
                    // rule labels: retval
                    // token list labels:
                    // rule list labels:
                    // wildcard labels:
                    if (state.backtracking == 0) {
                        retval.tree = root_0;
                        RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(
                                adaptor, "rule retval", retval != null ? retval.tree
                                        : null);
                        root_0 = (ManchesterOWLSyntaxTree) adaptor.nil();
                        // 120:16: -> ^( FUNCTIONAL )
                        {
                            // MOWLParser.g:120:19: ^( FUNCTIONAL )
                            {
                                ManchesterOWLSyntaxTree root_1 = (ManchesterOWLSyntaxTree) adaptor
                                        .nil();
                                root_1 = (ManchesterOWLSyntaxTree) adaptor.becomeRoot(
                                        stream_FUNCTIONAL.nextNode(), root_1);
                                adaptor.addChild(root_0, root_1);
                            }
                        }
                        retval.tree = root_0;
                    }
                }
                    break;
                case 2:
                // MOWLParser.g:121:7: INVERSE_FUNCTIONAL
                {
                    INVERSE_FUNCTIONAL34 = (Token) match(input, INVERSE_FUNCTIONAL,
                            FOLLOW_INVERSE_FUNCTIONAL_in_unaryCharacteristic1135);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        stream_INVERSE_FUNCTIONAL.add(INVERSE_FUNCTIONAL34);
                    }
                    // AST REWRITE
                    // elements: INVERSE_FUNCTIONAL
                    // token labels:
                    // rule labels: retval
                    // token list labels:
                    // rule list labels:
                    // wildcard labels:
                    if (state.backtracking == 0) {
                        retval.tree = root_0;
                        RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(
                                adaptor, "rule retval", retval != null ? retval.tree
                                        : null);
                        root_0 = (ManchesterOWLSyntaxTree) adaptor.nil();
                        // 121:26: -> ^( INVERSE_FUNCTIONAL )
                        {
                            // MOWLParser.g:121:29: ^( INVERSE_FUNCTIONAL )
                            {
                                ManchesterOWLSyntaxTree root_1 = (ManchesterOWLSyntaxTree) adaptor
                                        .nil();
                                root_1 = (ManchesterOWLSyntaxTree) adaptor.becomeRoot(
                                        stream_INVERSE_FUNCTIONAL.nextNode(), root_1);
                                adaptor.addChild(root_0, root_1);
                            }
                        }
                        retval.tree = root_0;
                    }
                }
                    break;
                case 3:
                // MOWLParser.g:122:7: SYMMETRIC
                {
                    SYMMETRIC35 = (Token) match(input, SYMMETRIC,
                            FOLLOW_SYMMETRIC_in_unaryCharacteristic1149);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        stream_SYMMETRIC.add(SYMMETRIC35);
                    }
                    // AST REWRITE
                    // elements: SYMMETRIC
                    // token labels:
                    // rule labels: retval
                    // token list labels:
                    // rule list labels:
                    // wildcard labels:
                    if (state.backtracking == 0) {
                        retval.tree = root_0;
                        RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(
                                adaptor, "rule retval", retval != null ? retval.tree
                                        : null);
                        root_0 = (ManchesterOWLSyntaxTree) adaptor.nil();
                        // 122:17: -> ^( SYMMETRIC )
                        {
                            // MOWLParser.g:122:20: ^( SYMMETRIC )
                            {
                                ManchesterOWLSyntaxTree root_1 = (ManchesterOWLSyntaxTree) adaptor
                                        .nil();
                                root_1 = (ManchesterOWLSyntaxTree) adaptor.becomeRoot(
                                        stream_SYMMETRIC.nextNode(), root_1);
                                adaptor.addChild(root_0, root_1);
                            }
                        }
                        retval.tree = root_0;
                    }
                }
                    break;
                case 4:
                // MOWLParser.g:123:7: ANTI_SYMMETRIC
                {
                    ANTI_SYMMETRIC36 = (Token) match(input, ANTI_SYMMETRIC,
                            FOLLOW_ANTI_SYMMETRIC_in_unaryCharacteristic1163);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        stream_ANTI_SYMMETRIC.add(ANTI_SYMMETRIC36);
                    }
                    // AST REWRITE
                    // elements: ANTI_SYMMETRIC
                    // token labels:
                    // rule labels: retval
                    // token list labels:
                    // rule list labels:
                    // wildcard labels:
                    if (state.backtracking == 0) {
                        retval.tree = root_0;
                        RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(
                                adaptor, "rule retval", retval != null ? retval.tree
                                        : null);
                        root_0 = (ManchesterOWLSyntaxTree) adaptor.nil();
                        // 123:22: -> ^( ANTI_SYMMETRIC )
                        {
                            // MOWLParser.g:123:25: ^( ANTI_SYMMETRIC )
                            {
                                ManchesterOWLSyntaxTree root_1 = (ManchesterOWLSyntaxTree) adaptor
                                        .nil();
                                root_1 = (ManchesterOWLSyntaxTree) adaptor.becomeRoot(
                                        stream_ANTI_SYMMETRIC.nextNode(), root_1);
                                adaptor.addChild(root_0, root_1);
                            }
                        }
                        retval.tree = root_0;
                    }
                }
                    break;
                case 5:
                // MOWLParser.g:124:7: REFLEXIVE
                {
                    REFLEXIVE37 = (Token) match(input, REFLEXIVE,
                            FOLLOW_REFLEXIVE_in_unaryCharacteristic1177);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        stream_REFLEXIVE.add(REFLEXIVE37);
                    }
                    // AST REWRITE
                    // elements: REFLEXIVE
                    // token labels:
                    // rule labels: retval
                    // token list labels:
                    // rule list labels:
                    // wildcard labels:
                    if (state.backtracking == 0) {
                        retval.tree = root_0;
                        RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(
                                adaptor, "rule retval", retval != null ? retval.tree
                                        : null);
                        root_0 = (ManchesterOWLSyntaxTree) adaptor.nil();
                        // 124:17: -> ^( REFLEXIVE )
                        {
                            // MOWLParser.g:124:20: ^( REFLEXIVE )
                            {
                                ManchesterOWLSyntaxTree root_1 = (ManchesterOWLSyntaxTree) adaptor
                                        .nil();
                                root_1 = (ManchesterOWLSyntaxTree) adaptor.becomeRoot(
                                        stream_REFLEXIVE.nextNode(), root_1);
                                adaptor.addChild(root_0, root_1);
                            }
                        }
                        retval.tree = root_0;
                    }
                }
                    break;
                case 6:
                // MOWLParser.g:125:7: IRREFLEXIVE
                {
                    IRREFLEXIVE38 = (Token) match(input, IRREFLEXIVE,
                            FOLLOW_IRREFLEXIVE_in_unaryCharacteristic1191);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        stream_IRREFLEXIVE.add(IRREFLEXIVE38);
                    }
                    // AST REWRITE
                    // elements: IRREFLEXIVE
                    // token labels:
                    // rule labels: retval
                    // token list labels:
                    // rule list labels:
                    // wildcard labels:
                    if (state.backtracking == 0) {
                        retval.tree = root_0;
                        RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(
                                adaptor, "rule retval", retval != null ? retval.tree
                                        : null);
                        root_0 = (ManchesterOWLSyntaxTree) adaptor.nil();
                        // 125:19: -> ^( IRREFLEXIVE )
                        {
                            // MOWLParser.g:125:22: ^( IRREFLEXIVE )
                            {
                                ManchesterOWLSyntaxTree root_1 = (ManchesterOWLSyntaxTree) adaptor
                                        .nil();
                                root_1 = (ManchesterOWLSyntaxTree) adaptor.becomeRoot(
                                        stream_IRREFLEXIVE.nextNode(), root_1);
                                adaptor.addChild(root_0, root_1);
                            }
                        }
                        retval.tree = root_0;
                    }
                }
                    break;
                case 7:
                // MOWLParser.g:126:7: TRANSITIVE
                {
                    TRANSITIVE39 = (Token) match(input, TRANSITIVE,
                            FOLLOW_TRANSITIVE_in_unaryCharacteristic1205);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        stream_TRANSITIVE.add(TRANSITIVE39);
                    }
                    // AST REWRITE
                    // elements: TRANSITIVE
                    // token labels:
                    // rule labels: retval
                    // token list labels:
                    // rule list labels:
                    // wildcard labels:
                    if (state.backtracking == 0) {
                        retval.tree = root_0;
                        RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(
                                adaptor, "rule retval", retval != null ? retval.tree
                                        : null);
                        root_0 = (ManchesterOWLSyntaxTree) adaptor.nil();
                        // 126:18: -> ^( TRANSITIVE )
                        {
                            // MOWLParser.g:126:21: ^( TRANSITIVE )
                            {
                                ManchesterOWLSyntaxTree root_1 = (ManchesterOWLSyntaxTree) adaptor
                                        .nil();
                                root_1 = (ManchesterOWLSyntaxTree) adaptor.becomeRoot(
                                        stream_TRANSITIVE.nextNode(), root_1);
                                adaptor.addChild(root_0, root_1);
                            }
                        }
                        retval.tree = root_0;
                    }
                }
                    break;
            }
            retval.stop = input.LT(-1);
            if (state.backtracking == 0) {
                retval.tree = (ManchesterOWLSyntaxTree) adaptor
                        .rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        } catch (RecognitionException e) {
            throw e;
        } catch (RewriteEmptyStreamException e) {
            throw e;
        } finally {}
        return retval;
    }

    // $ANTLR end "unaryCharacteristic"
    public static class expression_return extends ParserRuleReturnScope {
        ManchesterOWLSyntaxTree tree;

        @Override
        public Object getTree() {
            return tree;
        }
    };

    // $ANTLR start "expression"
    // MOWLParser.g:129:1: expression : ( options {backtrack=true; } :
    // disjunction -> ^( disjunction ) | complexPropertyExpression -> ^(
    // complexPropertyExpression ) | OPEN_PARENTHESYS expression
    // CLOSED_PARENTHESYS -> ^( expression ) ) ;
    public final ManchesterOWLSyntax_MOWLParser.expression_return expression()
            throws RecognitionException {
        ManchesterOWLSyntax_MOWLParser.expression_return retval = new ManchesterOWLSyntax_MOWLParser.expression_return();
        retval.start = input.LT(1);
        ManchesterOWLSyntaxTree root_0 = null;
        Token OPEN_PARENTHESYS42 = null;
        Token CLOSED_PARENTHESYS44 = null;
        ManchesterOWLSyntax_MOWLParser.disjunction_return disjunction40 = null;
        ManchesterOWLSyntax_MOWLParser.complexPropertyExpression_return complexPropertyExpression41 = null;
        ManchesterOWLSyntax_MOWLParser.expression_return expression43 = null;
        ManchesterOWLSyntaxTree OPEN_PARENTHESYS42_tree = null;
        ManchesterOWLSyntaxTree CLOSED_PARENTHESYS44_tree = null;
        RewriteRuleTokenStream stream_CLOSED_PARENTHESYS = new RewriteRuleTokenStream(
                adaptor, "token CLOSED_PARENTHESYS");
        RewriteRuleTokenStream stream_OPEN_PARENTHESYS = new RewriteRuleTokenStream(
                adaptor, "token OPEN_PARENTHESYS");
        RewriteRuleSubtreeStream stream_expression = new RewriteRuleSubtreeStream(
                adaptor, "rule expression");
        RewriteRuleSubtreeStream stream_disjunction = new RewriteRuleSubtreeStream(
                adaptor, "rule disjunction");
        RewriteRuleSubtreeStream stream_complexPropertyExpression = new RewriteRuleSubtreeStream(
                adaptor, "rule complexPropertyExpression");
        try {
            // MOWLParser.g:129:11: ( ( options {backtrack=true; } : disjunction
            // -> ^( disjunction ) | complexPropertyExpression -> ^(
            // complexPropertyExpression ) | OPEN_PARENTHESYS expression
            // CLOSED_PARENTHESYS -> ^( expression ) ) )
            // MOWLParser.g:130:5: ( options {backtrack=true; } : disjunction ->
            // ^( disjunction ) | complexPropertyExpression -> ^(
            // complexPropertyExpression ) | OPEN_PARENTHESYS expression
            // CLOSED_PARENTHESYS -> ^( expression ) )
            {
                // MOWLParser.g:130:5: ( options {backtrack=true; } :
                // disjunction -> ^( disjunction ) | complexPropertyExpression
                // -> ^( complexPropertyExpression ) | OPEN_PARENTHESYS
                // expression CLOSED_PARENTHESYS -> ^( expression ) )
                int alt8 = 3;
                switch (input.LA(1)) {
                    case OPEN_CURLY_BRACES:
                    case NOT:
                    case DBLQUOTE:
                    case IDENTIFIER:
                    case ENTITY_REFERENCE: {
                        alt8 = 1;
                    }
                        break;
                    case INVERSE: {
                        int LA8_3 = input.LA(2);
                        if (synpred17_MOWLParser()) {
                            alt8 = 1;
                        } else if (synpred18_MOWLParser()) {
                            alt8 = 2;
                        } else {
                            if (state.backtracking > 0) {
                                state.failed = true;
                                return retval;
                            }
                            NoViableAltException nvae = new NoViableAltException("", 8,
                                    3, input);
                            throw nvae;
                        }
                    }
                        break;
                    case OPEN_PARENTHESYS: {
                        alt8 = 3;
                    }
                        break;
                    default:
                        if (state.backtracking > 0) {
                            state.failed = true;
                            return retval;
                        }
                        NoViableAltException nvae = new NoViableAltException("", 8, 0,
                                input);
                        throw nvae;
                }
                switch (alt8) {
                    case 1:
                    // MOWLParser.g:132:5: disjunction
                    {
                        pushFollow(FOLLOW_disjunction_in_expression1247);
                        disjunction40 = disjunction();
                        state._fsp--;
                        if (state.failed) {
                            return retval;
                        }
                        if (state.backtracking == 0) {
                            stream_disjunction.add(disjunction40.getTree());
                        }
                        // AST REWRITE
                        // elements: disjunction
                        // token labels:
                        // rule labels: retval
                        // token list labels:
                        // rule list labels:
                        // wildcard labels:
                        if (state.backtracking == 0) {
                            retval.tree = root_0;
                            RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(
                                    adaptor, "rule retval", retval != null ? retval.tree
                                            : null);
                            root_0 = (ManchesterOWLSyntaxTree) adaptor.nil();
                            // 132:17: -> ^( disjunction )
                            {
                                // MOWLParser.g:132:20: ^( disjunction )
                                {
                                    ManchesterOWLSyntaxTree root_1 = (ManchesterOWLSyntaxTree) adaptor
                                            .nil();
                                    root_1 = (ManchesterOWLSyntaxTree) adaptor
                                            .becomeRoot(stream_disjunction.nextNode(),
                                                    root_1);
                                    adaptor.addChild(root_0, root_1);
                                }
                            }
                            retval.tree = root_0;
                        }
                    }
                        break;
                    case 2:
                    // MOWLParser.g:133:6: complexPropertyExpression
                    {
                        pushFollow(FOLLOW_complexPropertyExpression_in_expression1260);
                        complexPropertyExpression41 = complexPropertyExpression();
                        state._fsp--;
                        if (state.failed) {
                            return retval;
                        }
                        if (state.backtracking == 0) {
                            stream_complexPropertyExpression
                                    .add(complexPropertyExpression41.getTree());
                        }
                        // AST REWRITE
                        // elements: complexPropertyExpression
                        // token labels:
                        // rule labels: retval
                        // token list labels:
                        // rule list labels:
                        // wildcard labels:
                        if (state.backtracking == 0) {
                            retval.tree = root_0;
                            RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(
                                    adaptor, "rule retval", retval != null ? retval.tree
                                            : null);
                            root_0 = (ManchesterOWLSyntaxTree) adaptor.nil();
                            // 133:32: -> ^( complexPropertyExpression )
                            {
                                // MOWLParser.g:133:35: ^(
                                // complexPropertyExpression )
                                {
                                    ManchesterOWLSyntaxTree root_1 = (ManchesterOWLSyntaxTree) adaptor
                                            .nil();
                                    root_1 = (ManchesterOWLSyntaxTree) adaptor
                                            .becomeRoot(stream_complexPropertyExpression
                                                    .nextNode(), root_1);
                                    adaptor.addChild(root_0, root_1);
                                }
                            }
                            retval.tree = root_0;
                        }
                    }
                        break;
                    case 3:
                    // MOWLParser.g:134:6: OPEN_PARENTHESYS expression
                    // CLOSED_PARENTHESYS
                    {
                        OPEN_PARENTHESYS42 = (Token) match(input, OPEN_PARENTHESYS,
                                FOLLOW_OPEN_PARENTHESYS_in_expression1273);
                        if (state.failed) {
                            return retval;
                        }
                        if (state.backtracking == 0) {
                            stream_OPEN_PARENTHESYS.add(OPEN_PARENTHESYS42);
                        }
                        pushFollow(FOLLOW_expression_in_expression1275);
                        expression43 = expression();
                        state._fsp--;
                        if (state.failed) {
                            return retval;
                        }
                        if (state.backtracking == 0) {
                            stream_expression.add(expression43.getTree());
                        }
                        CLOSED_PARENTHESYS44 = (Token) match(input, CLOSED_PARENTHESYS,
                                FOLLOW_CLOSED_PARENTHESYS_in_expression1277);
                        if (state.failed) {
                            return retval;
                        }
                        if (state.backtracking == 0) {
                            stream_CLOSED_PARENTHESYS.add(CLOSED_PARENTHESYS44);
                        }
                        // AST REWRITE
                        // elements: expression
                        // token labels:
                        // rule labels: retval
                        // token list labels:
                        // rule list labels:
                        // wildcard labels:
                        if (state.backtracking == 0) {
                            retval.tree = root_0;
                            RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(
                                    adaptor, "rule retval", retval != null ? retval.tree
                                            : null);
                            root_0 = (ManchesterOWLSyntaxTree) adaptor.nil();
                            // 134:53: -> ^( expression )
                            {
                                // MOWLParser.g:134:56: ^( expression )
                                {
                                    ManchesterOWLSyntaxTree root_1 = (ManchesterOWLSyntaxTree) adaptor
                                            .nil();
                                    root_1 = (ManchesterOWLSyntaxTree) adaptor
                                            .becomeRoot(stream_expression.nextNode(),
                                                    root_1);
                                    adaptor.addChild(root_0, root_1);
                                }
                            }
                            retval.tree = root_0;
                        }
                    }
                        break;
                }
            }
            retval.stop = input.LT(-1);
            if (state.backtracking == 0) {
                retval.tree = (ManchesterOWLSyntaxTree) adaptor
                        .rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        } catch (RecognitionException e) {
            throw e;
        } catch (RewriteEmptyStreamException e) {
            throw e;
        } finally {}
        return retval;
    }

    // $ANTLR end "expression"
    public static class disjunction_return extends ParserRuleReturnScope {
        ManchesterOWLSyntaxTree tree;

        @Override
        public Object getTree() {
            return tree;
        }
    };

    // $ANTLR start "disjunction"
    // MOWLParser.g:141:1: disjunction : conjunction ( OR conjunction )* -> ^(
    // DISJUNCTION ( conjunction )+ ) ;
    public final ManchesterOWLSyntax_MOWLParser.disjunction_return disjunction()
            throws RecognitionException {
        ManchesterOWLSyntax_MOWLParser.disjunction_return retval = new ManchesterOWLSyntax_MOWLParser.disjunction_return();
        retval.start = input.LT(1);
        ManchesterOWLSyntaxTree root_0 = null;
        Token OR46 = null;
        ManchesterOWLSyntax_MOWLParser.conjunction_return conjunction45 = null;
        ManchesterOWLSyntax_MOWLParser.conjunction_return conjunction47 = null;
        ManchesterOWLSyntaxTree OR46_tree = null;
        RewriteRuleTokenStream stream_OR = new RewriteRuleTokenStream(adaptor, "token OR");
        RewriteRuleSubtreeStream stream_conjunction = new RewriteRuleSubtreeStream(
                adaptor, "rule conjunction");
        try {
            // MOWLParser.g:142:2: ( conjunction ( OR conjunction )* -> ^(
            // DISJUNCTION ( conjunction )+ ) )
            // MOWLParser.g:143:3: conjunction ( OR conjunction )*
            {
                pushFollow(FOLLOW_conjunction_in_disjunction1307);
                conjunction45 = conjunction();
                state._fsp--;
                if (state.failed) {
                    return retval;
                }
                if (state.backtracking == 0) {
                    stream_conjunction.add(conjunction45.getTree());
                }
                // MOWLParser.g:143:15: ( OR conjunction )*
                loop9: do {
                    int alt9 = 2;
                    int LA9_0 = input.LA(1);
                    if (LA9_0 == OR) {
                        alt9 = 1;
                    }
                    switch (alt9) {
                        case 1:
                        // MOWLParser.g:143:16: OR conjunction
                        {
                            OR46 = (Token) match(input, OR, FOLLOW_OR_in_disjunction1310);
                            if (state.failed) {
                                return retval;
                            }
                            if (state.backtracking == 0) {
                                stream_OR.add(OR46);
                            }
                            pushFollow(FOLLOW_conjunction_in_disjunction1312);
                            conjunction47 = conjunction();
                            state._fsp--;
                            if (state.failed) {
                                return retval;
                            }
                            if (state.backtracking == 0) {
                                stream_conjunction.add(conjunction47.getTree());
                            }
                        }
                            break;
                        default:
                            break loop9;
                    }
                } while (true);
                // AST REWRITE
                // elements: conjunction
                // token labels:
                // rule labels: retval
                // token list labels:
                // rule list labels:
                // wildcard labels:
                if (state.backtracking == 0) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(
                            adaptor, "rule retval", retval != null ? retval.tree : null);
                    root_0 = (ManchesterOWLSyntaxTree) adaptor.nil();
                    // 143:33: -> ^( DISJUNCTION ( conjunction )+ )
                    {
                        // MOWLParser.g:143:36: ^( DISJUNCTION ( conjunction )+
                        // )
                        {
                            ManchesterOWLSyntaxTree root_1 = (ManchesterOWLSyntaxTree) adaptor
                                    .nil();
                            root_1 = (ManchesterOWLSyntaxTree) adaptor.becomeRoot(
                                    adaptor.create(DISJUNCTION, "DISJUNCTION"), root_1);
                            if (!stream_conjunction.hasNext()) {
                                throw new RewriteEarlyExitException();
                            }
                            while (stream_conjunction.hasNext()) {
                                adaptor.addChild(root_1, stream_conjunction.nextTree());
                            }
                            stream_conjunction.reset();
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
            throw e;
        } catch (RewriteEmptyStreamException e) {
            throw e;
        } finally {}
        return retval;
    }

    // $ANTLR end "disjunction"
    public static class conjunction_return extends ParserRuleReturnScope {
        ManchesterOWLSyntaxTree tree;

        @Override
        public Object getTree() {
            return tree;
        }
    };

    // $ANTLR start "conjunction"
    // MOWLParser.g:146:1: conjunction : unary ( AND unary )* -> ^( CONJUNCTION
    // ( unary )+ ) ;
    public final ManchesterOWLSyntax_MOWLParser.conjunction_return conjunction()
            throws RecognitionException {
        ManchesterOWLSyntax_MOWLParser.conjunction_return retval = new ManchesterOWLSyntax_MOWLParser.conjunction_return();
        retval.start = input.LT(1);
        ManchesterOWLSyntaxTree root_0 = null;
        Token AND49 = null;
        ManchesterOWLSyntax_MOWLParser.unary_return unary48 = null;
        ManchesterOWLSyntax_MOWLParser.unary_return unary50 = null;
        ManchesterOWLSyntaxTree AND49_tree = null;
        RewriteRuleTokenStream stream_AND = new RewriteRuleTokenStream(adaptor,
                "token AND");
        RewriteRuleSubtreeStream stream_unary = new RewriteRuleSubtreeStream(adaptor,
                "rule unary");
        try {
            // MOWLParser.g:146:13: ( unary ( AND unary )* -> ^( CONJUNCTION (
            // unary )+ ) )
            // MOWLParser.g:147:5: unary ( AND unary )*
            {
                pushFollow(FOLLOW_unary_in_conjunction1339);
                unary48 = unary();
                state._fsp--;
                if (state.failed) {
                    return retval;
                }
                if (state.backtracking == 0) {
                    stream_unary.add(unary48.getTree());
                }
                // MOWLParser.g:147:11: ( AND unary )*
                loop10: do {
                    int alt10 = 2;
                    int LA10_0 = input.LA(1);
                    if (LA10_0 == AND) {
                        alt10 = 1;
                    }
                    switch (alt10) {
                        case 1:
                        // MOWLParser.g:147:12: AND unary
                        {
                            AND49 = (Token) match(input, AND,
                                    FOLLOW_AND_in_conjunction1342);
                            if (state.failed) {
                                return retval;
                            }
                            if (state.backtracking == 0) {
                                stream_AND.add(AND49);
                            }
                            pushFollow(FOLLOW_unary_in_conjunction1344);
                            unary50 = unary();
                            state._fsp--;
                            if (state.failed) {
                                return retval;
                            }
                            if (state.backtracking == 0) {
                                stream_unary.add(unary50.getTree());
                            }
                        }
                            break;
                        default:
                            break loop10;
                    }
                } while (true);
                // AST REWRITE
                // elements: unary
                // token labels:
                // rule labels: retval
                // token list labels:
                // rule list labels:
                // wildcard labels:
                if (state.backtracking == 0) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(
                            adaptor, "rule retval", retval != null ? retval.tree : null);
                    root_0 = (ManchesterOWLSyntaxTree) adaptor.nil();
                    // 147:24: -> ^( CONJUNCTION ( unary )+ )
                    {
                        // MOWLParser.g:147:27: ^( CONJUNCTION ( unary )+ )
                        {
                            ManchesterOWLSyntaxTree root_1 = (ManchesterOWLSyntaxTree) adaptor
                                    .nil();
                            root_1 = (ManchesterOWLSyntaxTree) adaptor.becomeRoot(
                                    adaptor.create(CONJUNCTION, "CONJUNCTION"), root_1);
                            if (!stream_unary.hasNext()) {
                                throw new RewriteEarlyExitException();
                            }
                            while (stream_unary.hasNext()) {
                                adaptor.addChild(root_1, stream_unary.nextTree());
                            }
                            stream_unary.reset();
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
            throw e;
        } catch (RewriteEmptyStreamException e) {
            throw e;
        } finally {}
        return retval;
    }

    // $ANTLR end "conjunction"
    public static class complexPropertyExpression_return extends ParserRuleReturnScope {
        ManchesterOWLSyntaxTree tree;

        @Override
        public Object getTree() {
            return tree;
        }
    };

    // $ANTLR start "complexPropertyExpression"
    // MOWLParser.g:150:1: complexPropertyExpression : INVERSE OPEN_PARENTHESYS
    // propertyExpression CLOSED_PARENTHESYS -> ^(
    // INVERSE_OBJECT_PROPERTY_EXPRESSION propertyExpression ) ;
    public final ManchesterOWLSyntax_MOWLParser.complexPropertyExpression_return
            complexPropertyExpression() throws RecognitionException {
        ManchesterOWLSyntax_MOWLParser.complexPropertyExpression_return retval = new ManchesterOWLSyntax_MOWLParser.complexPropertyExpression_return();
        retval.start = input.LT(1);
        ManchesterOWLSyntaxTree root_0 = null;
        Token INVERSE51 = null;
        Token OPEN_PARENTHESYS52 = null;
        Token CLOSED_PARENTHESYS54 = null;
        ManchesterOWLSyntax_MOWLParser.propertyExpression_return propertyExpression53 = null;
        ManchesterOWLSyntaxTree INVERSE51_tree = null;
        ManchesterOWLSyntaxTree OPEN_PARENTHESYS52_tree = null;
        ManchesterOWLSyntaxTree CLOSED_PARENTHESYS54_tree = null;
        RewriteRuleTokenStream stream_INVERSE = new RewriteRuleTokenStream(adaptor,
                "token INVERSE");
        RewriteRuleTokenStream stream_CLOSED_PARENTHESYS = new RewriteRuleTokenStream(
                adaptor, "token CLOSED_PARENTHESYS");
        RewriteRuleTokenStream stream_OPEN_PARENTHESYS = new RewriteRuleTokenStream(
                adaptor, "token OPEN_PARENTHESYS");
        RewriteRuleSubtreeStream stream_propertyExpression = new RewriteRuleSubtreeStream(
                adaptor, "rule propertyExpression");
        try {
            // MOWLParser.g:150:26: ( INVERSE OPEN_PARENTHESYS
            // propertyExpression CLOSED_PARENTHESYS -> ^(
            // INVERSE_OBJECT_PROPERTY_EXPRESSION propertyExpression ) )
            // MOWLParser.g:151:2: INVERSE OPEN_PARENTHESYS propertyExpression
            // CLOSED_PARENTHESYS
            {
                INVERSE51 = (Token) match(input, INVERSE,
                        FOLLOW_INVERSE_in_complexPropertyExpression1365);
                if (state.failed) {
                    return retval;
                }
                if (state.backtracking == 0) {
                    stream_INVERSE.add(INVERSE51);
                }
                OPEN_PARENTHESYS52 = (Token) match(input, OPEN_PARENTHESYS,
                        FOLLOW_OPEN_PARENTHESYS_in_complexPropertyExpression1367);
                if (state.failed) {
                    return retval;
                }
                if (state.backtracking == 0) {
                    stream_OPEN_PARENTHESYS.add(OPEN_PARENTHESYS52);
                }
                pushFollow(FOLLOW_propertyExpression_in_complexPropertyExpression1369);
                propertyExpression53 = propertyExpression();
                state._fsp--;
                if (state.failed) {
                    return retval;
                }
                if (state.backtracking == 0) {
                    stream_propertyExpression.add(propertyExpression53.getTree());
                }
                CLOSED_PARENTHESYS54 = (Token) match(input, CLOSED_PARENTHESYS,
                        FOLLOW_CLOSED_PARENTHESYS_in_complexPropertyExpression1371);
                if (state.failed) {
                    return retval;
                }
                if (state.backtracking == 0) {
                    stream_CLOSED_PARENTHESYS.add(CLOSED_PARENTHESYS54);
                }
                // AST REWRITE
                // elements: propertyExpression
                // token labels:
                // rule labels: retval
                // token list labels:
                // rule list labels:
                // wildcard labels:
                if (state.backtracking == 0) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(
                            adaptor, "rule retval", retval != null ? retval.tree : null);
                    root_0 = (ManchesterOWLSyntaxTree) adaptor.nil();
                    // 151:65: -> ^( INVERSE_OBJECT_PROPERTY_EXPRESSION
                    // propertyExpression )
                    {
                        // MOWLParser.g:151:68: ^(
                        // INVERSE_OBJECT_PROPERTY_EXPRESSION propertyExpression
                        // )
                        {
                            ManchesterOWLSyntaxTree root_1 = (ManchesterOWLSyntaxTree) adaptor
                                    .nil();
                            root_1 = (ManchesterOWLSyntaxTree) adaptor
                                    .becomeRoot(adaptor.create(
                                            INVERSE_OBJECT_PROPERTY_EXPRESSION,
                                            "INVERSE_OBJECT_PROPERTY_EXPRESSION"), root_1);
                            adaptor.addChild(root_1, stream_propertyExpression.nextTree());
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
            throw e;
        } catch (RewriteEmptyStreamException e) {
            throw e;
        } finally {}
        return retval;
    }

    // $ANTLR end "complexPropertyExpression"
    public static class unary_return extends ParserRuleReturnScope {
        ManchesterOWLSyntaxTree tree;

        @Override
        public Object getTree() {
            return tree;
        }
    };

    // $ANTLR start "unary"
    // MOWLParser.g:155:1: unary options {backtrack=true; } : (head=
    // propertyExpression ( COMPOSITION rest+= propertyExpression )+ -> ^(
    // PROPERTY_CHAIN $head $rest) | NOT OPEN_PARENTHESYS expression
    // CLOSED_PARENTHESYS -> ^( NEGATED_EXPRESSION expression ) | NOT atomic ->
    // ^( NEGATED_EXPRESSION atomic ) | qualifiedRestriction -> ^(
    // qualifiedRestriction ) | dataRange | constant | atomic );
    public final ManchesterOWLSyntax_MOWLParser.unary_return unary()
            throws RecognitionException {
        ManchesterOWLSyntax_MOWLParser.unary_return retval = new ManchesterOWLSyntax_MOWLParser.unary_return();
        retval.start = input.LT(1);
        ManchesterOWLSyntaxTree root_0 = null;
        Token COMPOSITION55 = null;
        Token NOT56 = null;
        Token OPEN_PARENTHESYS57 = null;
        Token CLOSED_PARENTHESYS59 = null;
        Token NOT60 = null;
        List list_rest = null;
        ManchesterOWLSyntax_MOWLParser.propertyExpression_return head = null;
        ManchesterOWLSyntax_MOWLParser.expression_return expression58 = null;
        ManchesterOWLSyntax_MOWLParser.atomic_return atomic61 = null;
        ManchesterOWLSyntax_MOWLParser.qualifiedRestriction_return qualifiedRestriction62 = null;
        ManchesterOWLSyntax_MOWLParser.dataRange_return dataRange63 = null;
        ManchesterOWLSyntax_MOWLParser.constant_return constant64 = null;
        ManchesterOWLSyntax_MOWLParser.atomic_return atomic65 = null;
        RuleReturnScope rest = null;
        ManchesterOWLSyntaxTree COMPOSITION55_tree = null;
        ManchesterOWLSyntaxTree NOT56_tree = null;
        ManchesterOWLSyntaxTree OPEN_PARENTHESYS57_tree = null;
        ManchesterOWLSyntaxTree CLOSED_PARENTHESYS59_tree = null;
        ManchesterOWLSyntaxTree NOT60_tree = null;
        RewriteRuleTokenStream stream_NOT = new RewriteRuleTokenStream(adaptor,
                "token NOT");
        RewriteRuleTokenStream stream_CLOSED_PARENTHESYS = new RewriteRuleTokenStream(
                adaptor, "token CLOSED_PARENTHESYS");
        RewriteRuleTokenStream stream_COMPOSITION = new RewriteRuleTokenStream(adaptor,
                "token COMPOSITION");
        RewriteRuleTokenStream stream_OPEN_PARENTHESYS = new RewriteRuleTokenStream(
                adaptor, "token OPEN_PARENTHESYS");
        RewriteRuleSubtreeStream stream_expression = new RewriteRuleSubtreeStream(
                adaptor, "rule expression");
        RewriteRuleSubtreeStream stream_qualifiedRestriction = new RewriteRuleSubtreeStream(
                adaptor, "rule qualifiedRestriction");
        RewriteRuleSubtreeStream stream_propertyExpression = new RewriteRuleSubtreeStream(
                adaptor, "rule propertyExpression");
        RewriteRuleSubtreeStream stream_atomic = new RewriteRuleSubtreeStream(adaptor,
                "rule atomic");
        try {
            // MOWLParser.g:155:34: (head= propertyExpression ( COMPOSITION
            // rest+= propertyExpression )+ -> ^( PROPERTY_CHAIN $head $rest) |
            // NOT OPEN_PARENTHESYS expression CLOSED_PARENTHESYS -> ^(
            // NEGATED_EXPRESSION expression ) | NOT atomic -> ^(
            // NEGATED_EXPRESSION atomic ) | qualifiedRestriction -> ^(
            // qualifiedRestriction ) | dataRange | constant | atomic )
            int alt12 = 7;
            alt12 = dfa12.predict(input);
            switch (alt12) {
                case 1:
                // MOWLParser.g:157:4: head= propertyExpression ( COMPOSITION
                // rest+= propertyExpression )+
                {
                    pushFollow(FOLLOW_propertyExpression_in_unary1411);
                    head = propertyExpression();
                    state._fsp--;
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        stream_propertyExpression.add(head.getTree());
                    }
                    // MOWLParser.g:157:30: ( COMPOSITION rest+=
                    // propertyExpression )+
                    int cnt11 = 0;
                    loop11: do {
                        int alt11 = 2;
                        int LA11_0 = input.LA(1);
                        if (LA11_0 == COMPOSITION) {
                            alt11 = 1;
                        }
                        switch (alt11) {
                            case 1:
                            // MOWLParser.g:157:31: COMPOSITION rest+=
                            // propertyExpression
                            {
                                COMPOSITION55 = (Token) match(input, COMPOSITION,
                                        FOLLOW_COMPOSITION_in_unary1414);
                                if (state.failed) {
                                    return retval;
                                }
                                if (state.backtracking == 0) {
                                    stream_COMPOSITION.add(COMPOSITION55);
                                }
                                pushFollow(FOLLOW_propertyExpression_in_unary1418);
                                rest = propertyExpression();
                                state._fsp--;
                                if (state.failed) {
                                    return retval;
                                }
                                if (state.backtracking == 0) {
                                    stream_propertyExpression.add(rest.getTree());
                                }
                                if (list_rest == null) {
                                    list_rest = new ArrayList();
                                }
                                list_rest.add(rest.getTree());
                            }
                                break;
                            default:
                                if (cnt11 >= 1) {
                                    break loop11;
                                }
                                if (state.backtracking > 0) {
                                    state.failed = true;
                                    return retval;
                                }
                                EarlyExitException eee = new EarlyExitException(11, input);
                                throw eee;
                        }
                        cnt11++;
                    } while (true);
                    // AST REWRITE
                    // elements: head, rest
                    // token labels:
                    // rule labels: retval, head
                    // token list labels:
                    // rule list labels: rest
                    // wildcard labels:
                    if (state.backtracking == 0) {
                        retval.tree = root_0;
                        RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(
                                adaptor, "rule retval", retval != null ? retval.tree
                                        : null);
                        RewriteRuleSubtreeStream stream_head = new RewriteRuleSubtreeStream(
                                adaptor, "rule head", head != null ? head.tree : null);
                        RewriteRuleSubtreeStream stream_rest = new RewriteRuleSubtreeStream(
                                adaptor, "token rest", list_rest);
                        root_0 = (ManchesterOWLSyntaxTree) adaptor.nil();
                        // 157:71: -> ^( PROPERTY_CHAIN $head $rest)
                        {
                            // MOWLParser.g:157:74: ^( PROPERTY_CHAIN $head
                            // $rest)
                            {
                                ManchesterOWLSyntaxTree root_1 = (ManchesterOWLSyntaxTree) adaptor
                                        .nil();
                                root_1 = (ManchesterOWLSyntaxTree) adaptor.becomeRoot(
                                        adaptor.create(PROPERTY_CHAIN, "PROPERTY_CHAIN"),
                                        root_1);
                                adaptor.addChild(root_1, stream_head.nextTree());
                                adaptor.addChild(root_1, stream_rest.nextTree());
                                adaptor.addChild(root_0, root_1);
                            }
                        }
                        retval.tree = root_0;
                    }
                }
                    break;
                case 2:
                // MOWLParser.g:158:5: NOT OPEN_PARENTHESYS expression
                // CLOSED_PARENTHESYS
                {
                    NOT56 = (Token) match(input, NOT, FOLLOW_NOT_in_unary1440);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        stream_NOT.add(NOT56);
                    }
                    OPEN_PARENTHESYS57 = (Token) match(input, OPEN_PARENTHESYS,
                            FOLLOW_OPEN_PARENTHESYS_in_unary1442);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        stream_OPEN_PARENTHESYS.add(OPEN_PARENTHESYS57);
                    }
                    pushFollow(FOLLOW_expression_in_unary1444);
                    expression58 = expression();
                    state._fsp--;
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        stream_expression.add(expression58.getTree());
                    }
                    CLOSED_PARENTHESYS59 = (Token) match(input, CLOSED_PARENTHESYS,
                            FOLLOW_CLOSED_PARENTHESYS_in_unary1446);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        stream_CLOSED_PARENTHESYS.add(CLOSED_PARENTHESYS59);
                    }
                    // AST REWRITE
                    // elements: expression
                    // token labels:
                    // rule labels: retval
                    // token list labels:
                    // rule list labels:
                    // wildcard labels:
                    if (state.backtracking == 0) {
                        retval.tree = root_0;
                        RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(
                                adaptor, "rule retval", retval != null ? retval.tree
                                        : null);
                        root_0 = (ManchesterOWLSyntaxTree) adaptor.nil();
                        // 158:56: -> ^( NEGATED_EXPRESSION expression )
                        {
                            // MOWLParser.g:158:59: ^( NEGATED_EXPRESSION
                            // expression )
                            {
                                ManchesterOWLSyntaxTree root_1 = (ManchesterOWLSyntaxTree) adaptor
                                        .nil();
                                root_1 = (ManchesterOWLSyntaxTree) adaptor.becomeRoot(
                                        adaptor.create(NEGATED_EXPRESSION,
                                                "NEGATED_EXPRESSION"), root_1);
                                adaptor.addChild(root_1, stream_expression.nextTree());
                                adaptor.addChild(root_0, root_1);
                            }
                        }
                        retval.tree = root_0;
                    }
                }
                    break;
                case 3:
                // MOWLParser.g:159:5: NOT atomic
                {
                    NOT60 = (Token) match(input, NOT, FOLLOW_NOT_in_unary1460);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        stream_NOT.add(NOT60);
                    }
                    pushFollow(FOLLOW_atomic_in_unary1462);
                    atomic61 = atomic();
                    state._fsp--;
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        stream_atomic.add(atomic61.getTree());
                    }
                    // AST REWRITE
                    // elements: atomic
                    // token labels:
                    // rule labels: retval
                    // token list labels:
                    // rule list labels:
                    // wildcard labels:
                    if (state.backtracking == 0) {
                        retval.tree = root_0;
                        RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(
                                adaptor, "rule retval", retval != null ? retval.tree
                                        : null);
                        root_0 = (ManchesterOWLSyntaxTree) adaptor.nil();
                        // 159:16: -> ^( NEGATED_EXPRESSION atomic )
                        {
                            // MOWLParser.g:159:19: ^( NEGATED_EXPRESSION atomic
                            // )
                            {
                                ManchesterOWLSyntaxTree root_1 = (ManchesterOWLSyntaxTree) adaptor
                                        .nil();
                                root_1 = (ManchesterOWLSyntaxTree) adaptor.becomeRoot(
                                        adaptor.create(NEGATED_EXPRESSION,
                                                "NEGATED_EXPRESSION"), root_1);
                                adaptor.addChild(root_1, stream_atomic.nextTree());
                                adaptor.addChild(root_0, root_1);
                            }
                        }
                        retval.tree = root_0;
                    }
                }
                    break;
                case 4:
                // MOWLParser.g:160:5: qualifiedRestriction
                {
                    pushFollow(FOLLOW_qualifiedRestriction_in_unary1485);
                    qualifiedRestriction62 = qualifiedRestriction();
                    state._fsp--;
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        stream_qualifiedRestriction.add(qualifiedRestriction62.getTree());
                    }
                    // AST REWRITE
                    // elements: qualifiedRestriction
                    // token labels:
                    // rule labels: retval
                    // token list labels:
                    // rule list labels:
                    // wildcard labels:
                    if (state.backtracking == 0) {
                        retval.tree = root_0;
                        RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(
                                adaptor, "rule retval", retval != null ? retval.tree
                                        : null);
                        root_0 = (ManchesterOWLSyntaxTree) adaptor.nil();
                        // 160:26: -> ^( qualifiedRestriction )
                        {
                            // MOWLParser.g:160:29: ^( qualifiedRestriction )
                            {
                                ManchesterOWLSyntaxTree root_1 = (ManchesterOWLSyntaxTree) adaptor
                                        .nil();
                                root_1 = (ManchesterOWLSyntaxTree) adaptor.becomeRoot(
                                        stream_qualifiedRestriction.nextNode(), root_1);
                                adaptor.addChild(root_0, root_1);
                            }
                        }
                        retval.tree = root_0;
                    }
                }
                    break;
                case 5:
                // MOWLParser.g:161:5: dataRange
                {
                    root_0 = (ManchesterOWLSyntaxTree) adaptor.nil();
                    pushFollow(FOLLOW_dataRange_in_unary1497);
                    dataRange63 = dataRange();
                    state._fsp--;
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        adaptor.addChild(root_0, dataRange63.getTree());
                    }
                }
                    break;
                case 6:
                // MOWLParser.g:162:5: constant
                {
                    root_0 = (ManchesterOWLSyntaxTree) adaptor.nil();
                    pushFollow(FOLLOW_constant_in_unary1503);
                    constant64 = constant();
                    state._fsp--;
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        adaptor.addChild(root_0, constant64.getTree());
                    }
                }
                    break;
                case 7:
                // MOWLParser.g:163:5: atomic
                {
                    root_0 = (ManchesterOWLSyntaxTree) adaptor.nil();
                    pushFollow(FOLLOW_atomic_in_unary1509);
                    atomic65 = atomic();
                    state._fsp--;
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        adaptor.addChild(root_0, atomic65.getTree());
                    }
                }
                    break;
            }
            retval.stop = input.LT(-1);
            if (state.backtracking == 0) {
                retval.tree = (ManchesterOWLSyntaxTree) adaptor
                        .rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        } catch (RecognitionException e) {
            throw e;
        } catch (RewriteEmptyStreamException e) {
            throw e;
        } finally {}
        return retval;
    }

    // $ANTLR end "unary"
    public static class dataRange_return extends ParserRuleReturnScope {
        ManchesterOWLSyntaxTree tree;

        @Override
        public Object getTree() {
            return tree;
        }
    };

    // $ANTLR start "dataRange"
    // MOWLParser.g:167:1: dataRange : IDENTIFIER OPEN_SQUARE_BRACKET
    // dataRangeFacet ( COMMA dataRangeFacet )* CLOSED_SQUARE_BRACKET -> ^(
    // DATA_RANGE IDENTIFIER ( dataRangeFacet )+ ) ;
    public final ManchesterOWLSyntax_MOWLParser.dataRange_return dataRange()
            throws RecognitionException {
        ManchesterOWLSyntax_MOWLParser.dataRange_return retval = new ManchesterOWLSyntax_MOWLParser.dataRange_return();
        retval.start = input.LT(1);
        ManchesterOWLSyntaxTree root_0 = null;
        Token IDENTIFIER66 = null;
        Token OPEN_SQUARE_BRACKET67 = null;
        Token COMMA69 = null;
        Token CLOSED_SQUARE_BRACKET71 = null;
        ManchesterOWLSyntax_MOWLParser.dataRangeFacet_return dataRangeFacet68 = null;
        ManchesterOWLSyntax_MOWLParser.dataRangeFacet_return dataRangeFacet70 = null;
        ManchesterOWLSyntaxTree IDENTIFIER66_tree = null;
        ManchesterOWLSyntaxTree OPEN_SQUARE_BRACKET67_tree = null;
        ManchesterOWLSyntaxTree COMMA69_tree = null;
        ManchesterOWLSyntaxTree CLOSED_SQUARE_BRACKET71_tree = null;
        RewriteRuleTokenStream stream_COMMA = new RewriteRuleTokenStream(adaptor,
                "token COMMA");
        RewriteRuleTokenStream stream_OPEN_SQUARE_BRACKET = new RewriteRuleTokenStream(
                adaptor, "token OPEN_SQUARE_BRACKET");
        RewriteRuleTokenStream stream_IDENTIFIER = new RewriteRuleTokenStream(adaptor,
                "token IDENTIFIER");
        RewriteRuleTokenStream stream_CLOSED_SQUARE_BRACKET = new RewriteRuleTokenStream(
                adaptor, "token CLOSED_SQUARE_BRACKET");
        RewriteRuleSubtreeStream stream_dataRangeFacet = new RewriteRuleSubtreeStream(
                adaptor, "rule dataRangeFacet");
        try {
            // MOWLParser.g:168:2: ( IDENTIFIER OPEN_SQUARE_BRACKET
            // dataRangeFacet ( COMMA dataRangeFacet )* CLOSED_SQUARE_BRACKET ->
            // ^( DATA_RANGE IDENTIFIER ( dataRangeFacet )+ ) )
            // MOWLParser.g:169:4: IDENTIFIER OPEN_SQUARE_BRACKET dataRangeFacet
            // ( COMMA dataRangeFacet )* CLOSED_SQUARE_BRACKET
            {
                IDENTIFIER66 = (Token) match(input, IDENTIFIER,
                        FOLLOW_IDENTIFIER_in_dataRange1526);
                if (state.failed) {
                    return retval;
                }
                if (state.backtracking == 0) {
                    stream_IDENTIFIER.add(IDENTIFIER66);
                }
                OPEN_SQUARE_BRACKET67 = (Token) match(input, OPEN_SQUARE_BRACKET,
                        FOLLOW_OPEN_SQUARE_BRACKET_in_dataRange1528);
                if (state.failed) {
                    return retval;
                }
                if (state.backtracking == 0) {
                    stream_OPEN_SQUARE_BRACKET.add(OPEN_SQUARE_BRACKET67);
                }
                pushFollow(FOLLOW_dataRangeFacet_in_dataRange1530);
                dataRangeFacet68 = dataRangeFacet();
                state._fsp--;
                if (state.failed) {
                    return retval;
                }
                if (state.backtracking == 0) {
                    stream_dataRangeFacet.add(dataRangeFacet68.getTree());
                }
                // MOWLParser.g:169:50: ( COMMA dataRangeFacet )*
                loop13: do {
                    int alt13 = 2;
                    int LA13_0 = input.LA(1);
                    if (LA13_0 == COMMA) {
                        alt13 = 1;
                    }
                    switch (alt13) {
                        case 1:
                        // MOWLParser.g:169:51: COMMA dataRangeFacet
                        {
                            COMMA69 = (Token) match(input, COMMA,
                                    FOLLOW_COMMA_in_dataRange1533);
                            if (state.failed) {
                                return retval;
                            }
                            if (state.backtracking == 0) {
                                stream_COMMA.add(COMMA69);
                            }
                            pushFollow(FOLLOW_dataRangeFacet_in_dataRange1535);
                            dataRangeFacet70 = dataRangeFacet();
                            state._fsp--;
                            if (state.failed) {
                                return retval;
                            }
                            if (state.backtracking == 0) {
                                stream_dataRangeFacet.add(dataRangeFacet70.getTree());
                            }
                        }
                            break;
                        default:
                            break loop13;
                    }
                } while (true);
                CLOSED_SQUARE_BRACKET71 = (Token) match(input, CLOSED_SQUARE_BRACKET,
                        FOLLOW_CLOSED_SQUARE_BRACKET_in_dataRange1539);
                if (state.failed) {
                    return retval;
                }
                if (state.backtracking == 0) {
                    stream_CLOSED_SQUARE_BRACKET.add(CLOSED_SQUARE_BRACKET71);
                }
                // AST REWRITE
                // elements: IDENTIFIER, dataRangeFacet
                // token labels:
                // rule labels: retval
                // token list labels:
                // rule list labels:
                // wildcard labels:
                if (state.backtracking == 0) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(
                            adaptor, "rule retval", retval != null ? retval.tree : null);
                    root_0 = (ManchesterOWLSyntaxTree) adaptor.nil();
                    // 169:96: -> ^( DATA_RANGE IDENTIFIER ( dataRangeFacet )+ )
                    {
                        // MOWLParser.g:169:99: ^( DATA_RANGE IDENTIFIER (
                        // dataRangeFacet )+ )
                        {
                            ManchesterOWLSyntaxTree root_1 = (ManchesterOWLSyntaxTree) adaptor
                                    .nil();
                            root_1 = (ManchesterOWLSyntaxTree) adaptor.becomeRoot(
                                    adaptor.create(DATA_RANGE, "DATA_RANGE"), root_1);
                            adaptor.addChild(root_1, stream_IDENTIFIER.nextNode());
                            if (!stream_dataRangeFacet.hasNext()) {
                                throw new RewriteEarlyExitException();
                            }
                            while (stream_dataRangeFacet.hasNext()) {
                                adaptor.addChild(root_1, stream_dataRangeFacet.nextTree());
                            }
                            stream_dataRangeFacet.reset();
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
            throw e;
        } catch (RewriteEmptyStreamException e) {
            throw e;
        } finally {}
        return retval;
    }

    // $ANTLR end "dataRange"
    public static class dataRangeFacet_return extends ParserRuleReturnScope {
        ManchesterOWLSyntaxTree tree;

        @Override
        public Object getTree() {
            return tree;
        }
    };

    // $ANTLR start "dataRangeFacet"
    // MOWLParser.g:172:1: dataRangeFacet : ( LESS_THAN constant -> ^( LESS_THAN
    // constant ) | LESS_THAN_EQUAL constant -> ^( LESS_THAN_EQUAL constant ) |
    // GREATER_THAN constant -> ^( GREATER_THAN constant ) | GREATER_THAN_EQUAL
    // constant -> ^( GREATER_THAN_EQUAL constant ) );
    public final ManchesterOWLSyntax_MOWLParser.dataRangeFacet_return dataRangeFacet()
            throws RecognitionException {
        ManchesterOWLSyntax_MOWLParser.dataRangeFacet_return retval = new ManchesterOWLSyntax_MOWLParser.dataRangeFacet_return();
        retval.start = input.LT(1);
        ManchesterOWLSyntaxTree root_0 = null;
        Token LESS_THAN72 = null;
        Token LESS_THAN_EQUAL74 = null;
        Token GREATER_THAN76 = null;
        Token GREATER_THAN_EQUAL78 = null;
        ManchesterOWLSyntax_MOWLParser.constant_return constant73 = null;
        ManchesterOWLSyntax_MOWLParser.constant_return constant75 = null;
        ManchesterOWLSyntax_MOWLParser.constant_return constant77 = null;
        ManchesterOWLSyntax_MOWLParser.constant_return constant79 = null;
        ManchesterOWLSyntaxTree LESS_THAN72_tree = null;
        ManchesterOWLSyntaxTree LESS_THAN_EQUAL74_tree = null;
        ManchesterOWLSyntaxTree GREATER_THAN76_tree = null;
        ManchesterOWLSyntaxTree GREATER_THAN_EQUAL78_tree = null;
        RewriteRuleTokenStream stream_LESS_THAN_EQUAL = new RewriteRuleTokenStream(
                adaptor, "token LESS_THAN_EQUAL");
        RewriteRuleTokenStream stream_GREATER_THAN_EQUAL = new RewriteRuleTokenStream(
                adaptor, "token GREATER_THAN_EQUAL");
        RewriteRuleTokenStream stream_GREATER_THAN = new RewriteRuleTokenStream(adaptor,
                "token GREATER_THAN");
        RewriteRuleTokenStream stream_LESS_THAN = new RewriteRuleTokenStream(adaptor,
                "token LESS_THAN");
        RewriteRuleSubtreeStream stream_constant = new RewriteRuleSubtreeStream(adaptor,
                "rule constant");
        try {
            // MOWLParser.g:173:2: ( LESS_THAN constant -> ^( LESS_THAN constant
            // ) | LESS_THAN_EQUAL constant -> ^( LESS_THAN_EQUAL constant ) |
            // GREATER_THAN constant -> ^( GREATER_THAN constant ) |
            // GREATER_THAN_EQUAL constant -> ^( GREATER_THAN_EQUAL constant ) )
            int alt14 = 4;
            switch (input.LA(1)) {
                case LESS_THAN: {
                    alt14 = 1;
                }
                    break;
                case LESS_THAN_EQUAL: {
                    alt14 = 2;
                }
                    break;
                case GREATER_THAN: {
                    alt14 = 3;
                }
                    break;
                case GREATER_THAN_EQUAL: {
                    alt14 = 4;
                }
                    break;
                default:
                    if (state.backtracking > 0) {
                        state.failed = true;
                        return retval;
                    }
                    NoViableAltException nvae = new NoViableAltException("", 14, 0, input);
                    throw nvae;
            }
            switch (alt14) {
                case 1:
                // MOWLParser.g:174:3: LESS_THAN constant
                {
                    LESS_THAN72 = (Token) match(input, LESS_THAN,
                            FOLLOW_LESS_THAN_in_dataRangeFacet1565);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        stream_LESS_THAN.add(LESS_THAN72);
                    }
                    pushFollow(FOLLOW_constant_in_dataRangeFacet1567);
                    constant73 = constant();
                    state._fsp--;
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        stream_constant.add(constant73.getTree());
                    }
                    // AST REWRITE
                    // elements: constant, LESS_THAN
                    // token labels:
                    // rule labels: retval
                    // token list labels:
                    // rule list labels:
                    // wildcard labels:
                    if (state.backtracking == 0) {
                        retval.tree = root_0;
                        RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(
                                adaptor, "rule retval", retval != null ? retval.tree
                                        : null);
                        root_0 = (ManchesterOWLSyntaxTree) adaptor.nil();
                        // 174:22: -> ^( LESS_THAN constant )
                        {
                            // MOWLParser.g:174:25: ^( LESS_THAN constant )
                            {
                                ManchesterOWLSyntaxTree root_1 = (ManchesterOWLSyntaxTree) adaptor
                                        .nil();
                                root_1 = (ManchesterOWLSyntaxTree) adaptor.becomeRoot(
                                        stream_LESS_THAN.nextNode(), root_1);
                                adaptor.addChild(root_1, stream_constant.nextTree());
                                adaptor.addChild(root_0, root_1);
                            }
                        }
                        retval.tree = root_0;
                    }
                }
                    break;
                case 2:
                // MOWLParser.g:175:5: LESS_THAN_EQUAL constant
                {
                    LESS_THAN_EQUAL74 = (Token) match(input, LESS_THAN_EQUAL,
                            FOLLOW_LESS_THAN_EQUAL_in_dataRangeFacet1581);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        stream_LESS_THAN_EQUAL.add(LESS_THAN_EQUAL74);
                    }
                    pushFollow(FOLLOW_constant_in_dataRangeFacet1583);
                    constant75 = constant();
                    state._fsp--;
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        stream_constant.add(constant75.getTree());
                    }
                    // AST REWRITE
                    // elements: constant, LESS_THAN_EQUAL
                    // token labels:
                    // rule labels: retval
                    // token list labels:
                    // rule list labels:
                    // wildcard labels:
                    if (state.backtracking == 0) {
                        retval.tree = root_0;
                        RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(
                                adaptor, "rule retval", retval != null ? retval.tree
                                        : null);
                        root_0 = (ManchesterOWLSyntaxTree) adaptor.nil();
                        // 175:31: -> ^( LESS_THAN_EQUAL constant )
                        {
                            // MOWLParser.g:175:34: ^( LESS_THAN_EQUAL constant
                            // )
                            {
                                ManchesterOWLSyntaxTree root_1 = (ManchesterOWLSyntaxTree) adaptor
                                        .nil();
                                root_1 = (ManchesterOWLSyntaxTree) adaptor.becomeRoot(
                                        stream_LESS_THAN_EQUAL.nextNode(), root_1);
                                adaptor.addChild(root_1, stream_constant.nextTree());
                                adaptor.addChild(root_0, root_1);
                            }
                        }
                        retval.tree = root_0;
                    }
                }
                    break;
                case 3:
                // MOWLParser.g:176:5: GREATER_THAN constant
                {
                    GREATER_THAN76 = (Token) match(input, GREATER_THAN,
                            FOLLOW_GREATER_THAN_in_dataRangeFacet1598);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        stream_GREATER_THAN.add(GREATER_THAN76);
                    }
                    pushFollow(FOLLOW_constant_in_dataRangeFacet1600);
                    constant77 = constant();
                    state._fsp--;
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        stream_constant.add(constant77.getTree());
                    }
                    // AST REWRITE
                    // elements: GREATER_THAN, constant
                    // token labels:
                    // rule labels: retval
                    // token list labels:
                    // rule list labels:
                    // wildcard labels:
                    if (state.backtracking == 0) {
                        retval.tree = root_0;
                        RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(
                                adaptor, "rule retval", retval != null ? retval.tree
                                        : null);
                        root_0 = (ManchesterOWLSyntaxTree) adaptor.nil();
                        // 176:27: -> ^( GREATER_THAN constant )
                        {
                            // MOWLParser.g:176:30: ^( GREATER_THAN constant )
                            {
                                ManchesterOWLSyntaxTree root_1 = (ManchesterOWLSyntaxTree) adaptor
                                        .nil();
                                root_1 = (ManchesterOWLSyntaxTree) adaptor.becomeRoot(
                                        stream_GREATER_THAN.nextNode(), root_1);
                                adaptor.addChild(root_1, stream_constant.nextTree());
                                adaptor.addChild(root_0, root_1);
                            }
                        }
                        retval.tree = root_0;
                    }
                }
                    break;
                case 4:
                // MOWLParser.g:177:5: GREATER_THAN_EQUAL constant
                {
                    GREATER_THAN_EQUAL78 = (Token) match(input, GREATER_THAN_EQUAL,
                            FOLLOW_GREATER_THAN_EQUAL_in_dataRangeFacet1614);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        stream_GREATER_THAN_EQUAL.add(GREATER_THAN_EQUAL78);
                    }
                    pushFollow(FOLLOW_constant_in_dataRangeFacet1616);
                    constant79 = constant();
                    state._fsp--;
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        stream_constant.add(constant79.getTree());
                    }
                    // AST REWRITE
                    // elements: GREATER_THAN_EQUAL, constant
                    // token labels:
                    // rule labels: retval
                    // token list labels:
                    // rule list labels:
                    // wildcard labels:
                    if (state.backtracking == 0) {
                        retval.tree = root_0;
                        RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(
                                adaptor, "rule retval", retval != null ? retval.tree
                                        : null);
                        root_0 = (ManchesterOWLSyntaxTree) adaptor.nil();
                        // 177:33: -> ^( GREATER_THAN_EQUAL constant )
                        {
                            // MOWLParser.g:177:36: ^( GREATER_THAN_EQUAL
                            // constant )
                            {
                                ManchesterOWLSyntaxTree root_1 = (ManchesterOWLSyntaxTree) adaptor
                                        .nil();
                                root_1 = (ManchesterOWLSyntaxTree) adaptor.becomeRoot(
                                        stream_GREATER_THAN_EQUAL.nextNode(), root_1);
                                adaptor.addChild(root_1, stream_constant.nextTree());
                                adaptor.addChild(root_0, root_1);
                            }
                        }
                        retval.tree = root_0;
                    }
                }
                    break;
            }
            retval.stop = input.LT(-1);
            if (state.backtracking == 0) {
                retval.tree = (ManchesterOWLSyntaxTree) adaptor
                        .rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        } catch (RecognitionException e) {
            throw e;
        } catch (RewriteEmptyStreamException e) {
            throw e;
        } finally {}
        return retval;
    }

    // $ANTLR end "dataRangeFacet"
    public static class atomic_return extends ParserRuleReturnScope {
        ManchesterOWLSyntaxTree tree;

        @Override
        public Object getTree() {
            return tree;
        }
    };

    // $ANTLR start "atomic"
    // MOWLParser.g:180:1: atomic : ( IDENTIFIER | ENTITY_REFERENCE -> ^(
    // ENTITY_REFERENCE ) );
    public final ManchesterOWLSyntax_MOWLParser.atomic_return atomic()
            throws RecognitionException {
        ManchesterOWLSyntax_MOWLParser.atomic_return retval = new ManchesterOWLSyntax_MOWLParser.atomic_return();
        retval.start = input.LT(1);
        ManchesterOWLSyntaxTree root_0 = null;
        Token IDENTIFIER80 = null;
        Token ENTITY_REFERENCE81 = null;
        ManchesterOWLSyntaxTree IDENTIFIER80_tree = null;
        ManchesterOWLSyntaxTree ENTITY_REFERENCE81_tree = null;
        RewriteRuleTokenStream stream_ENTITY_REFERENCE = new RewriteRuleTokenStream(
                adaptor, "token ENTITY_REFERENCE");
        try {
            // MOWLParser.g:180:8: ( IDENTIFIER | ENTITY_REFERENCE -> ^(
            // ENTITY_REFERENCE ) )
            int alt15 = 2;
            int LA15_0 = input.LA(1);
            if (LA15_0 == IDENTIFIER) {
                alt15 = 1;
            } else if (LA15_0 == ENTITY_REFERENCE) {
                alt15 = 2;
            } else {
                if (state.backtracking > 0) {
                    state.failed = true;
                    return retval;
                }
                NoViableAltException nvae = new NoViableAltException("", 15, 0, input);
                throw nvae;
            }
            switch (alt15) {
                case 1:
                // MOWLParser.g:181:3: IDENTIFIER
                {
                    root_0 = (ManchesterOWLSyntaxTree) adaptor.nil();
                    IDENTIFIER80 = (Token) match(input, IDENTIFIER,
                            FOLLOW_IDENTIFIER_in_atomic1637);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        IDENTIFIER80_tree = (ManchesterOWLSyntaxTree) adaptor
                                .create(IDENTIFIER80);
                        adaptor.addChild(root_0, IDENTIFIER80_tree);
                    }
                }
                    break;
                case 2:
                // MOWLParser.g:182:5: ENTITY_REFERENCE
                {
                    ENTITY_REFERENCE81 = (Token) match(input, ENTITY_REFERENCE,
                            FOLLOW_ENTITY_REFERENCE_in_atomic1644);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        stream_ENTITY_REFERENCE.add(ENTITY_REFERENCE81);
                    }
                    // AST REWRITE
                    // elements: ENTITY_REFERENCE
                    // token labels:
                    // rule labels: retval
                    // token list labels:
                    // rule list labels:
                    // wildcard labels:
                    if (state.backtracking == 0) {
                        retval.tree = root_0;
                        RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(
                                adaptor, "rule retval", retval != null ? retval.tree
                                        : null);
                        root_0 = (ManchesterOWLSyntaxTree) adaptor.nil();
                        // 182:22: -> ^( ENTITY_REFERENCE )
                        {
                            // MOWLParser.g:182:25: ^( ENTITY_REFERENCE )
                            {
                                ManchesterOWLSyntaxTree root_1 = (ManchesterOWLSyntaxTree) adaptor
                                        .nil();
                                root_1 = (ManchesterOWLSyntaxTree) adaptor.becomeRoot(
                                        stream_ENTITY_REFERENCE.nextNode(), root_1);
                                adaptor.addChild(root_0, root_1);
                            }
                        }
                        retval.tree = root_0;
                    }
                }
                    break;
            }
            retval.stop = input.LT(-1);
            if (state.backtracking == 0) {
                retval.tree = (ManchesterOWLSyntaxTree) adaptor
                        .rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        } catch (RecognitionException e) {
            throw e;
        } catch (RewriteEmptyStreamException e) {
            throw e;
        } finally {}
        return retval;
    }

    // $ANTLR end "atomic"
    public static class qualifiedRestriction_return extends ParserRuleReturnScope {
        ManchesterOWLSyntaxTree tree;

        @Override
        public Object getTree() {
            return tree;
        }
    };

    // $ANTLR start "qualifiedRestriction"
    // MOWLParser.g:185:1: qualifiedRestriction : ( options {backtrack=true; } :
    // propertyExpression SOME expression -> ^( SOME_RESTRICTION
    // propertyExpression expression ) | propertyExpression ONLY expression ->
    // ^( ALL_RESTRICTION propertyExpression expression ) |
    // cardinalityRestriction -> ^( cardinalityRestriction ) | oneOf -> ^( oneOf
    // ) | valueRestriction -> ^( valueRestriction ) ) ;
    public final ManchesterOWLSyntax_MOWLParser.qualifiedRestriction_return
            qualifiedRestriction() throws RecognitionException {
        ManchesterOWLSyntax_MOWLParser.qualifiedRestriction_return retval = new ManchesterOWLSyntax_MOWLParser.qualifiedRestriction_return();
        retval.start = input.LT(1);
        ManchesterOWLSyntaxTree root_0 = null;
        Token SOME83 = null;
        Token ONLY86 = null;
        ManchesterOWLSyntax_MOWLParser.propertyExpression_return propertyExpression82 = null;
        ManchesterOWLSyntax_MOWLParser.expression_return expression84 = null;
        ManchesterOWLSyntax_MOWLParser.propertyExpression_return propertyExpression85 = null;
        ManchesterOWLSyntax_MOWLParser.expression_return expression87 = null;
        ManchesterOWLSyntax_MOWLParser.cardinalityRestriction_return cardinalityRestriction88 = null;
        ManchesterOWLSyntax_MOWLParser.oneOf_return oneOf89 = null;
        ManchesterOWLSyntax_MOWLParser.valueRestriction_return valueRestriction90 = null;
        ManchesterOWLSyntaxTree SOME83_tree = null;
        ManchesterOWLSyntaxTree ONLY86_tree = null;
        RewriteRuleTokenStream stream_ONLY = new RewriteRuleTokenStream(adaptor,
                "token ONLY");
        RewriteRuleTokenStream stream_SOME = new RewriteRuleTokenStream(adaptor,
                "token SOME");
        RewriteRuleSubtreeStream stream_expression = new RewriteRuleSubtreeStream(
                adaptor, "rule expression");
        RewriteRuleSubtreeStream stream_oneOf = new RewriteRuleSubtreeStream(adaptor,
                "rule oneOf");
        RewriteRuleSubtreeStream stream_propertyExpression = new RewriteRuleSubtreeStream(
                adaptor, "rule propertyExpression");
        RewriteRuleSubtreeStream stream_cardinalityRestriction = new RewriteRuleSubtreeStream(
                adaptor, "rule cardinalityRestriction");
        RewriteRuleSubtreeStream stream_valueRestriction = new RewriteRuleSubtreeStream(
                adaptor, "rule valueRestriction");
        try {
            // MOWLParser.g:185:21: ( ( options {backtrack=true; } :
            // propertyExpression SOME expression -> ^( SOME_RESTRICTION
            // propertyExpression expression ) | propertyExpression ONLY
            // expression -> ^( ALL_RESTRICTION propertyExpression expression )
            // | cardinalityRestriction -> ^( cardinalityRestriction ) | oneOf
            // -> ^( oneOf ) | valueRestriction -> ^( valueRestriction ) ) )
            // MOWLParser.g:186:9: ( options {backtrack=true; } :
            // propertyExpression SOME expression -> ^( SOME_RESTRICTION
            // propertyExpression expression ) | propertyExpression ONLY
            // expression -> ^( ALL_RESTRICTION propertyExpression expression )
            // | cardinalityRestriction -> ^( cardinalityRestriction ) | oneOf
            // -> ^( oneOf ) | valueRestriction -> ^( valueRestriction ) )
            {
                // MOWLParser.g:186:9: ( options {backtrack=true; } :
                // propertyExpression SOME expression -> ^( SOME_RESTRICTION
                // propertyExpression expression ) | propertyExpression ONLY
                // expression -> ^( ALL_RESTRICTION propertyExpression
                // expression ) | cardinalityRestriction -> ^(
                // cardinalityRestriction ) | oneOf -> ^( oneOf ) |
                // valueRestriction -> ^( valueRestriction ) )
                int alt16 = 5;
                switch (input.LA(1)) {
                    case IDENTIFIER: {
                        int LA16_1 = input.LA(2);
                        if (synpred25_MOWLParser()) {
                            alt16 = 1;
                        } else if (synpred26_MOWLParser()) {
                            alt16 = 2;
                        } else if (synpred27_MOWLParser()) {
                            alt16 = 3;
                        } else if (true) {
                            alt16 = 5;
                        } else {
                            if (state.backtracking > 0) {
                                state.failed = true;
                                return retval;
                            }
                            NoViableAltException nvae = new NoViableAltException("", 16,
                                    1, input);
                            throw nvae;
                        }
                    }
                        break;
                    case ENTITY_REFERENCE: {
                        int LA16_2 = input.LA(2);
                        if (synpred25_MOWLParser()) {
                            alt16 = 1;
                        } else if (synpred26_MOWLParser()) {
                            alt16 = 2;
                        } else if (synpred27_MOWLParser()) {
                            alt16 = 3;
                        } else if (true) {
                            alt16 = 5;
                        } else {
                            if (state.backtracking > 0) {
                                state.failed = true;
                                return retval;
                            }
                            NoViableAltException nvae = new NoViableAltException("", 16,
                                    2, input);
                            throw nvae;
                        }
                    }
                        break;
                    case INVERSE: {
                        int LA16_3 = input.LA(2);
                        if (synpred25_MOWLParser()) {
                            alt16 = 1;
                        } else if (synpred26_MOWLParser()) {
                            alt16 = 2;
                        } else if (synpred27_MOWLParser()) {
                            alt16 = 3;
                        } else if (true) {
                            alt16 = 5;
                        } else {
                            if (state.backtracking > 0) {
                                state.failed = true;
                                return retval;
                            }
                            NoViableAltException nvae = new NoViableAltException("", 16,
                                    3, input);
                            throw nvae;
                        }
                    }
                        break;
                    case OPEN_CURLY_BRACES: {
                        alt16 = 4;
                    }
                        break;
                    default:
                        if (state.backtracking > 0) {
                            state.failed = true;
                            return retval;
                        }
                        NoViableAltException nvae = new NoViableAltException("", 16, 0,
                                input);
                        throw nvae;
                }
                switch (alt16) {
                    case 1:
                    // MOWLParser.g:188:7: propertyExpression SOME expression
                    {
                        pushFollow(FOLLOW_propertyExpression_in_qualifiedRestriction1696);
                        propertyExpression82 = propertyExpression();
                        state._fsp--;
                        if (state.failed) {
                            return retval;
                        }
                        if (state.backtracking == 0) {
                            stream_propertyExpression.add(propertyExpression82.getTree());
                        }
                        SOME83 = (Token) match(input, SOME,
                                FOLLOW_SOME_in_qualifiedRestriction1699);
                        if (state.failed) {
                            return retval;
                        }
                        if (state.backtracking == 0) {
                            stream_SOME.add(SOME83);
                        }
                        pushFollow(FOLLOW_expression_in_qualifiedRestriction1703);
                        expression84 = expression();
                        state._fsp--;
                        if (state.failed) {
                            return retval;
                        }
                        if (state.backtracking == 0) {
                            stream_expression.add(expression84.getTree());
                        }
                        // AST REWRITE
                        // elements: propertyExpression, expression
                        // token labels:
                        // rule labels: retval
                        // token list labels:
                        // rule list labels:
                        // wildcard labels:
                        if (state.backtracking == 0) {
                            retval.tree = root_0;
                            RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(
                                    adaptor, "rule retval", retval != null ? retval.tree
                                            : null);
                            root_0 = (ManchesterOWLSyntaxTree) adaptor.nil();
                            // 188:46: -> ^( SOME_RESTRICTION propertyExpression
                            // expression )
                            {
                                // MOWLParser.g:188:49: ^( SOME_RESTRICTION
                                // propertyExpression expression )
                                {
                                    ManchesterOWLSyntaxTree root_1 = (ManchesterOWLSyntaxTree) adaptor
                                            .nil();
                                    root_1 = (ManchesterOWLSyntaxTree) adaptor
                                            .becomeRoot(adaptor.create(SOME_RESTRICTION,
                                                    "SOME_RESTRICTION"), root_1);
                                    adaptor.addChild(root_1,
                                            stream_propertyExpression.nextTree());
                                    adaptor.addChild(root_1, stream_expression.nextTree());
                                    adaptor.addChild(root_0, root_1);
                                }
                            }
                            retval.tree = root_0;
                        }
                    }
                        break;
                    case 2:
                    // MOWLParser.g:189:7: propertyExpression ONLY expression
                    {
                        pushFollow(FOLLOW_propertyExpression_in_qualifiedRestriction1732);
                        propertyExpression85 = propertyExpression();
                        state._fsp--;
                        if (state.failed) {
                            return retval;
                        }
                        if (state.backtracking == 0) {
                            stream_propertyExpression.add(propertyExpression85.getTree());
                        }
                        ONLY86 = (Token) match(input, ONLY,
                                FOLLOW_ONLY_in_qualifiedRestriction1734);
                        if (state.failed) {
                            return retval;
                        }
                        if (state.backtracking == 0) {
                            stream_ONLY.add(ONLY86);
                        }
                        pushFollow(FOLLOW_expression_in_qualifiedRestriction1737);
                        expression87 = expression();
                        state._fsp--;
                        if (state.failed) {
                            return retval;
                        }
                        if (state.backtracking == 0) {
                            stream_expression.add(expression87.getTree());
                        }
                        // AST REWRITE
                        // elements: expression, propertyExpression
                        // token labels:
                        // rule labels: retval
                        // token list labels:
                        // rule list labels:
                        // wildcard labels:
                        if (state.backtracking == 0) {
                            retval.tree = root_0;
                            RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(
                                    adaptor, "rule retval", retval != null ? retval.tree
                                            : null);
                            root_0 = (ManchesterOWLSyntaxTree) adaptor.nil();
                            // 189:44: -> ^( ALL_RESTRICTION propertyExpression
                            // expression )
                            {
                                // MOWLParser.g:189:47: ^( ALL_RESTRICTION
                                // propertyExpression expression )
                                {
                                    ManchesterOWLSyntaxTree root_1 = (ManchesterOWLSyntaxTree) adaptor
                                            .nil();
                                    root_1 = (ManchesterOWLSyntaxTree) adaptor
                                            .becomeRoot(adaptor.create(ALL_RESTRICTION,
                                                    "ALL_RESTRICTION"), root_1);
                                    adaptor.addChild(root_1,
                                            stream_propertyExpression.nextTree());
                                    adaptor.addChild(root_1, stream_expression.nextTree());
                                    adaptor.addChild(root_0, root_1);
                                }
                            }
                            retval.tree = root_0;
                        }
                    }
                        break;
                    case 3:
                    // MOWLParser.g:190:7: cardinalityRestriction
                    {
                        pushFollow(FOLLOW_cardinalityRestriction_in_qualifiedRestriction1756);
                        cardinalityRestriction88 = cardinalityRestriction();
                        state._fsp--;
                        if (state.failed) {
                            return retval;
                        }
                        if (state.backtracking == 0) {
                            stream_cardinalityRestriction.add(cardinalityRestriction88
                                    .getTree());
                        }
                        // AST REWRITE
                        // elements: cardinalityRestriction
                        // token labels:
                        // rule labels: retval
                        // token list labels:
                        // rule list labels:
                        // wildcard labels:
                        if (state.backtracking == 0) {
                            retval.tree = root_0;
                            RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(
                                    adaptor, "rule retval", retval != null ? retval.tree
                                            : null);
                            root_0 = (ManchesterOWLSyntaxTree) adaptor.nil();
                            // 190:30: -> ^( cardinalityRestriction )
                            {
                                // MOWLParser.g:190:33: ^(
                                // cardinalityRestriction )
                                {
                                    ManchesterOWLSyntaxTree root_1 = (ManchesterOWLSyntaxTree) adaptor
                                            .nil();
                                    root_1 = (ManchesterOWLSyntaxTree) adaptor
                                            .becomeRoot(stream_cardinalityRestriction
                                                    .nextNode(), root_1);
                                    adaptor.addChild(root_0, root_1);
                                }
                            }
                            retval.tree = root_0;
                        }
                    }
                        break;
                    case 4:
                    // MOWLParser.g:191:7: oneOf
                    {
                        pushFollow(FOLLOW_oneOf_in_qualifiedRestriction1770);
                        oneOf89 = oneOf();
                        state._fsp--;
                        if (state.failed) {
                            return retval;
                        }
                        if (state.backtracking == 0) {
                            stream_oneOf.add(oneOf89.getTree());
                        }
                        // AST REWRITE
                        // elements: oneOf
                        // token labels:
                        // rule labels: retval
                        // token list labels:
                        // rule list labels:
                        // wildcard labels:
                        if (state.backtracking == 0) {
                            retval.tree = root_0;
                            RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(
                                    adaptor, "rule retval", retval != null ? retval.tree
                                            : null);
                            root_0 = (ManchesterOWLSyntaxTree) adaptor.nil();
                            // 191:13: -> ^( oneOf )
                            {
                                // MOWLParser.g:191:16: ^( oneOf )
                                {
                                    ManchesterOWLSyntaxTree root_1 = (ManchesterOWLSyntaxTree) adaptor
                                            .nil();
                                    root_1 = (ManchesterOWLSyntaxTree) adaptor
                                            .becomeRoot(stream_oneOf.nextNode(), root_1);
                                    adaptor.addChild(root_0, root_1);
                                }
                            }
                            retval.tree = root_0;
                        }
                    }
                        break;
                    case 5:
                    // MOWLParser.g:192:7: valueRestriction
                    {
                        pushFollow(FOLLOW_valueRestriction_in_qualifiedRestriction1784);
                        valueRestriction90 = valueRestriction();
                        state._fsp--;
                        if (state.failed) {
                            return retval;
                        }
                        if (state.backtracking == 0) {
                            stream_valueRestriction.add(valueRestriction90.getTree());
                        }
                        // AST REWRITE
                        // elements: valueRestriction
                        // token labels:
                        // rule labels: retval
                        // token list labels:
                        // rule list labels:
                        // wildcard labels:
                        if (state.backtracking == 0) {
                            retval.tree = root_0;
                            RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(
                                    adaptor, "rule retval", retval != null ? retval.tree
                                            : null);
                            root_0 = (ManchesterOWLSyntaxTree) adaptor.nil();
                            // 192:24: -> ^( valueRestriction )
                            {
                                // MOWLParser.g:192:27: ^( valueRestriction )
                                {
                                    ManchesterOWLSyntaxTree root_1 = (ManchesterOWLSyntaxTree) adaptor
                                            .nil();
                                    root_1 = (ManchesterOWLSyntaxTree) adaptor
                                            .becomeRoot(
                                                    stream_valueRestriction.nextNode(),
                                                    root_1);
                                    adaptor.addChild(root_0, root_1);
                                }
                            }
                            retval.tree = root_0;
                        }
                    }
                        break;
                }
            }
            retval.stop = input.LT(-1);
            if (state.backtracking == 0) {
                retval.tree = (ManchesterOWLSyntaxTree) adaptor
                        .rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        } catch (RecognitionException e) {
            throw e;
        } catch (RewriteEmptyStreamException e) {
            throw e;
        } finally {}
        return retval;
    }

    // $ANTLR end "qualifiedRestriction"
    public static class propertyExpression_return extends ParserRuleReturnScope {
        ManchesterOWLSyntaxTree tree;

        @Override
        public Object getTree() {
            return tree;
        }
    };

    // $ANTLR start "propertyExpression"
    // MOWLParser.g:196:1: propertyExpression : ( atomic -> ^( atomic ) |
    // complexPropertyExpression -> ^( complexPropertyExpression ) );
    public final ManchesterOWLSyntax_MOWLParser.propertyExpression_return
            propertyExpression() throws RecognitionException {
        ManchesterOWLSyntax_MOWLParser.propertyExpression_return retval = new ManchesterOWLSyntax_MOWLParser.propertyExpression_return();
        retval.start = input.LT(1);
        ManchesterOWLSyntaxTree root_0 = null;
        ManchesterOWLSyntax_MOWLParser.atomic_return atomic91 = null;
        ManchesterOWLSyntax_MOWLParser.complexPropertyExpression_return complexPropertyExpression92 = null;
        RewriteRuleSubtreeStream stream_complexPropertyExpression = new RewriteRuleSubtreeStream(
                adaptor, "rule complexPropertyExpression");
        RewriteRuleSubtreeStream stream_atomic = new RewriteRuleSubtreeStream(adaptor,
                "rule atomic");
        try {
            // MOWLParser.g:196:21: ( atomic -> ^( atomic ) |
            // complexPropertyExpression -> ^( complexPropertyExpression ) )
            int alt17 = 2;
            int LA17_0 = input.LA(1);
            if (LA17_0 >= IDENTIFIER && LA17_0 <= ENTITY_REFERENCE) {
                alt17 = 1;
            } else if (LA17_0 == INVERSE) {
                alt17 = 2;
            } else {
                if (state.backtracking > 0) {
                    state.failed = true;
                    return retval;
                }
                NoViableAltException nvae = new NoViableAltException("", 17, 0, input);
                throw nvae;
            }
            switch (alt17) {
                case 1:
                // MOWLParser.g:197:7: atomic
                {
                    pushFollow(FOLLOW_atomic_in_propertyExpression1816);
                    atomic91 = atomic();
                    state._fsp--;
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        stream_atomic.add(atomic91.getTree());
                    }
                    // AST REWRITE
                    // elements: atomic
                    // token labels:
                    // rule labels: retval
                    // token list labels:
                    // rule list labels:
                    // wildcard labels:
                    if (state.backtracking == 0) {
                        retval.tree = root_0;
                        RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(
                                adaptor, "rule retval", retval != null ? retval.tree
                                        : null);
                        root_0 = (ManchesterOWLSyntaxTree) adaptor.nil();
                        // 197:14: -> ^( atomic )
                        {
                            // MOWLParser.g:197:17: ^( atomic )
                            {
                                ManchesterOWLSyntaxTree root_1 = (ManchesterOWLSyntaxTree) adaptor
                                        .nil();
                                root_1 = (ManchesterOWLSyntaxTree) adaptor.becomeRoot(
                                        stream_atomic.nextNode(), root_1);
                                adaptor.addChild(root_0, root_1);
                            }
                        }
                        retval.tree = root_0;
                    }
                }
                    break;
                case 2:
                // MOWLParser.g:198:7: complexPropertyExpression
                {
                    pushFollow(FOLLOW_complexPropertyExpression_in_propertyExpression1830);
                    complexPropertyExpression92 = complexPropertyExpression();
                    state._fsp--;
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        stream_complexPropertyExpression.add(complexPropertyExpression92
                                .getTree());
                    }
                    // AST REWRITE
                    // elements: complexPropertyExpression
                    // token labels:
                    // rule labels: retval
                    // token list labels:
                    // rule list labels:
                    // wildcard labels:
                    if (state.backtracking == 0) {
                        retval.tree = root_0;
                        RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(
                                adaptor, "rule retval", retval != null ? retval.tree
                                        : null);
                        root_0 = (ManchesterOWLSyntaxTree) adaptor.nil();
                        // 198:33: -> ^( complexPropertyExpression )
                        {
                            // MOWLParser.g:198:36: ^( complexPropertyExpression
                            // )
                            {
                                ManchesterOWLSyntaxTree root_1 = (ManchesterOWLSyntaxTree) adaptor
                                        .nil();
                                root_1 = (ManchesterOWLSyntaxTree) adaptor.becomeRoot(
                                        stream_complexPropertyExpression.nextNode(),
                                        root_1);
                                adaptor.addChild(root_0, root_1);
                            }
                        }
                        retval.tree = root_0;
                    }
                }
                    break;
            }
            retval.stop = input.LT(-1);
            if (state.backtracking == 0) {
                retval.tree = (ManchesterOWLSyntaxTree) adaptor
                        .rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        } catch (RecognitionException e) {
            throw e;
        } catch (RewriteEmptyStreamException e) {
            throw e;
        } finally {}
        return retval;
    }

    // $ANTLR end "propertyExpression"
    public static class cardinalityRestriction_return extends ParserRuleReturnScope {
        ManchesterOWLSyntaxTree tree;

        @Override
        public Object getTree() {
            return tree;
        }
    };

    // $ANTLR start "cardinalityRestriction"
    // MOWLParser.g:201:1: cardinalityRestriction options {backtrack=true; } :
    // propertyExpression restrictionKind INTEGER ( unary )? -> ^(
    // CARDINALITY_RESTRICTION restrictionKind INTEGER propertyExpression (
    // unary )? ) ;
    public final ManchesterOWLSyntax_MOWLParser.cardinalityRestriction_return
            cardinalityRestriction() throws RecognitionException {
        ManchesterOWLSyntax_MOWLParser.cardinalityRestriction_return retval = new ManchesterOWLSyntax_MOWLParser.cardinalityRestriction_return();
        retval.start = input.LT(1);
        ManchesterOWLSyntaxTree root_0 = null;
        Token INTEGER95 = null;
        ManchesterOWLSyntax_MOWLParser.propertyExpression_return propertyExpression93 = null;
        ManchesterOWLSyntax_MOWLParser.restrictionKind_return restrictionKind94 = null;
        ManchesterOWLSyntax_MOWLParser.unary_return unary96 = null;
        ManchesterOWLSyntaxTree INTEGER95_tree = null;
        RewriteRuleTokenStream stream_INTEGER = new RewriteRuleTokenStream(adaptor,
                "token INTEGER");
        RewriteRuleSubtreeStream stream_unary = new RewriteRuleSubtreeStream(adaptor,
                "rule unary");
        RewriteRuleSubtreeStream stream_propertyExpression = new RewriteRuleSubtreeStream(
                adaptor, "rule propertyExpression");
        RewriteRuleSubtreeStream stream_restrictionKind = new RewriteRuleSubtreeStream(
                adaptor, "rule restrictionKind");
        try {
            // MOWLParser.g:202:28: ( propertyExpression restrictionKind INTEGER
            // ( unary )? -> ^( CARDINALITY_RESTRICTION restrictionKind INTEGER
            // propertyExpression ( unary )? ) )
            // MOWLParser.g:203:2: propertyExpression restrictionKind INTEGER (
            // unary )?
            {
                pushFollow(FOLLOW_propertyExpression_in_cardinalityRestriction1872);
                propertyExpression93 = propertyExpression();
                state._fsp--;
                if (state.failed) {
                    return retval;
                }
                if (state.backtracking == 0) {
                    stream_propertyExpression.add(propertyExpression93.getTree());
                }
                pushFollow(FOLLOW_restrictionKind_in_cardinalityRestriction1875);
                restrictionKind94 = restrictionKind();
                state._fsp--;
                if (state.failed) {
                    return retval;
                }
                if (state.backtracking == 0) {
                    stream_restrictionKind.add(restrictionKind94.getTree());
                }
                INTEGER95 = (Token) match(input, INTEGER,
                        FOLLOW_INTEGER_in_cardinalityRestriction1877);
                if (state.failed) {
                    return retval;
                }
                if (state.backtracking == 0) {
                    stream_INTEGER.add(INTEGER95);
                }
                // MOWLParser.g:203:46: ( unary )?
                int alt18 = 2;
                int LA18_0 = input.LA(1);
                if (LA18_0 == OPEN_CURLY_BRACES || LA18_0 == NOT || LA18_0 == INVERSE
                        || LA18_0 == DBLQUOTE || LA18_0 >= IDENTIFIER
                        && LA18_0 <= ENTITY_REFERENCE) {
                    alt18 = 1;
                }
                switch (alt18) {
                    case 1:
                    // MOWLParser.g:203:46: unary
                    {
                        pushFollow(FOLLOW_unary_in_cardinalityRestriction1879);
                        unary96 = unary();
                        state._fsp--;
                        if (state.failed) {
                            return retval;
                        }
                        if (state.backtracking == 0) {
                            stream_unary.add(unary96.getTree());
                        }
                    }
                        break;
                }
                // AST REWRITE
                // elements: propertyExpression, restrictionKind, unary, INTEGER
                // token labels:
                // rule labels: retval
                // token list labels:
                // rule list labels:
                // wildcard labels:
                if (state.backtracking == 0) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(
                            adaptor, "rule retval", retval != null ? retval.tree : null);
                    root_0 = (ManchesterOWLSyntaxTree) adaptor.nil();
                    // 203:53: -> ^( CARDINALITY_RESTRICTION restrictionKind
                    // INTEGER propertyExpression ( unary )? )
                    {
                        // MOWLParser.g:203:56: ^( CARDINALITY_RESTRICTION
                        // restrictionKind INTEGER propertyExpression ( unary )?
                        // )
                        {
                            ManchesterOWLSyntaxTree root_1 = (ManchesterOWLSyntaxTree) adaptor
                                    .nil();
                            root_1 = (ManchesterOWLSyntaxTree) adaptor.becomeRoot(adaptor
                                    .create(CARDINALITY_RESTRICTION,
                                            "CARDINALITY_RESTRICTION"), root_1);
                            adaptor.addChild(root_1, stream_restrictionKind.nextTree());
                            adaptor.addChild(root_1, stream_INTEGER.nextNode());
                            adaptor.addChild(root_1, stream_propertyExpression.nextTree());
                            // MOWLParser.g:203:127: ( unary )?
                            if (stream_unary.hasNext()) {
                                adaptor.addChild(root_1, stream_unary.nextTree());
                            }
                            stream_unary.reset();
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
            throw e;
        } catch (RewriteEmptyStreamException e) {
            throw e;
        } finally {}
        return retval;
    }

    // $ANTLR end "cardinalityRestriction"
    public static class restrictionKind_return extends ParserRuleReturnScope {
        ManchesterOWLSyntaxTree tree;

        @Override
        public Object getTree() {
            return tree;
        }
    };

    // $ANTLR start "restrictionKind"
    // MOWLParser.g:206:1: restrictionKind : ( MIN -> ^( MIN ) | MAX -> ^( MAX )
    // | EXACTLY -> ^( EXACTLY ) );
    public final ManchesterOWLSyntax_MOWLParser.restrictionKind_return restrictionKind()
            throws RecognitionException {
        ManchesterOWLSyntax_MOWLParser.restrictionKind_return retval = new ManchesterOWLSyntax_MOWLParser.restrictionKind_return();
        retval.start = input.LT(1);
        ManchesterOWLSyntaxTree root_0 = null;
        Token MIN97 = null;
        Token MAX98 = null;
        Token EXACTLY99 = null;
        ManchesterOWLSyntaxTree MIN97_tree = null;
        ManchesterOWLSyntaxTree MAX98_tree = null;
        ManchesterOWLSyntaxTree EXACTLY99_tree = null;
        RewriteRuleTokenStream stream_MAX = new RewriteRuleTokenStream(adaptor,
                "token MAX");
        RewriteRuleTokenStream stream_MIN = new RewriteRuleTokenStream(adaptor,
                "token MIN");
        RewriteRuleTokenStream stream_EXACTLY = new RewriteRuleTokenStream(adaptor,
                "token EXACTLY");
        try {
            // MOWLParser.g:206:17: ( MIN -> ^( MIN ) | MAX -> ^( MAX ) |
            // EXACTLY -> ^( EXACTLY ) )
            int alt19 = 3;
            switch (input.LA(1)) {
                case MIN: {
                    alt19 = 1;
                }
                    break;
                case MAX: {
                    alt19 = 2;
                }
                    break;
                case EXACTLY: {
                    alt19 = 3;
                }
                    break;
                default:
                    if (state.backtracking > 0) {
                        state.failed = true;
                        return retval;
                    }
                    NoViableAltException nvae = new NoViableAltException("", 19, 0, input);
                    throw nvae;
            }
            switch (alt19) {
                case 1:
                // MOWLParser.g:207:5: MIN
                {
                    MIN97 = (Token) match(input, MIN, FOLLOW_MIN_in_restrictionKind1912);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        stream_MIN.add(MIN97);
                    }
                    // AST REWRITE
                    // elements: MIN
                    // token labels:
                    // rule labels: retval
                    // token list labels:
                    // rule list labels:
                    // wildcard labels:
                    if (state.backtracking == 0) {
                        retval.tree = root_0;
                        RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(
                                adaptor, "rule retval", retval != null ? retval.tree
                                        : null);
                        root_0 = (ManchesterOWLSyntaxTree) adaptor.nil();
                        // 207:9: -> ^( MIN )
                        {
                            // MOWLParser.g:207:12: ^( MIN )
                            {
                                ManchesterOWLSyntaxTree root_1 = (ManchesterOWLSyntaxTree) adaptor
                                        .nil();
                                root_1 = (ManchesterOWLSyntaxTree) adaptor.becomeRoot(
                                        stream_MIN.nextNode(), root_1);
                                adaptor.addChild(root_0, root_1);
                            }
                        }
                        retval.tree = root_0;
                    }
                }
                    break;
                case 2:
                // MOWLParser.g:208:7: MAX
                {
                    MAX98 = (Token) match(input, MAX, FOLLOW_MAX_in_restrictionKind1926);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        stream_MAX.add(MAX98);
                    }
                    // AST REWRITE
                    // elements: MAX
                    // token labels:
                    // rule labels: retval
                    // token list labels:
                    // rule list labels:
                    // wildcard labels:
                    if (state.backtracking == 0) {
                        retval.tree = root_0;
                        RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(
                                adaptor, "rule retval", retval != null ? retval.tree
                                        : null);
                        root_0 = (ManchesterOWLSyntaxTree) adaptor.nil();
                        // 208:11: -> ^( MAX )
                        {
                            // MOWLParser.g:208:14: ^( MAX )
                            {
                                ManchesterOWLSyntaxTree root_1 = (ManchesterOWLSyntaxTree) adaptor
                                        .nil();
                                root_1 = (ManchesterOWLSyntaxTree) adaptor.becomeRoot(
                                        stream_MAX.nextNode(), root_1);
                                adaptor.addChild(root_0, root_1);
                            }
                        }
                        retval.tree = root_0;
                    }
                }
                    break;
                case 3:
                // MOWLParser.g:209:7: EXACTLY
                {
                    EXACTLY99 = (Token) match(input, EXACTLY,
                            FOLLOW_EXACTLY_in_restrictionKind1940);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        stream_EXACTLY.add(EXACTLY99);
                    }
                    // AST REWRITE
                    // elements: EXACTLY
                    // token labels:
                    // rule labels: retval
                    // token list labels:
                    // rule list labels:
                    // wildcard labels:
                    if (state.backtracking == 0) {
                        retval.tree = root_0;
                        RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(
                                adaptor, "rule retval", retval != null ? retval.tree
                                        : null);
                        root_0 = (ManchesterOWLSyntaxTree) adaptor.nil();
                        // 209:15: -> ^( EXACTLY )
                        {
                            // MOWLParser.g:209:18: ^( EXACTLY )
                            {
                                ManchesterOWLSyntaxTree root_1 = (ManchesterOWLSyntaxTree) adaptor
                                        .nil();
                                root_1 = (ManchesterOWLSyntaxTree) adaptor.becomeRoot(
                                        stream_EXACTLY.nextNode(), root_1);
                                adaptor.addChild(root_0, root_1);
                            }
                        }
                        retval.tree = root_0;
                    }
                }
                    break;
            }
            retval.stop = input.LT(-1);
            if (state.backtracking == 0) {
                retval.tree = (ManchesterOWLSyntaxTree) adaptor
                        .rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        } catch (RecognitionException e) {
            throw e;
        } catch (RewriteEmptyStreamException e) {
            throw e;
        } finally {}
        return retval;
    }

    // $ANTLR end "restrictionKind"
    public static class oneOf_return extends ParserRuleReturnScope {
        ManchesterOWLSyntaxTree tree;

        @Override
        public Object getTree() {
            return tree;
        }
    };

    // $ANTLR start "oneOf"
    // MOWLParser.g:213:1: oneOf : OPEN_CURLY_BRACES atomic ( COMMA atomic )*
    // CLOSED_CURLY_BRACES -> ^( ONE_OF ( atomic )+ ) ;
    public final ManchesterOWLSyntax_MOWLParser.oneOf_return oneOf()
            throws RecognitionException {
        ManchesterOWLSyntax_MOWLParser.oneOf_return retval = new ManchesterOWLSyntax_MOWLParser.oneOf_return();
        retval.start = input.LT(1);
        ManchesterOWLSyntaxTree root_0 = null;
        Token OPEN_CURLY_BRACES100 = null;
        Token COMMA102 = null;
        Token CLOSED_CURLY_BRACES104 = null;
        ManchesterOWLSyntax_MOWLParser.atomic_return atomic101 = null;
        ManchesterOWLSyntax_MOWLParser.atomic_return atomic103 = null;
        ManchesterOWLSyntaxTree OPEN_CURLY_BRACES100_tree = null;
        ManchesterOWLSyntaxTree COMMA102_tree = null;
        ManchesterOWLSyntaxTree CLOSED_CURLY_BRACES104_tree = null;
        RewriteRuleTokenStream stream_COMMA = new RewriteRuleTokenStream(adaptor,
                "token COMMA");
        RewriteRuleTokenStream stream_CLOSED_CURLY_BRACES = new RewriteRuleTokenStream(
                adaptor, "token CLOSED_CURLY_BRACES");
        RewriteRuleTokenStream stream_OPEN_CURLY_BRACES = new RewriteRuleTokenStream(
                adaptor, "token OPEN_CURLY_BRACES");
        RewriteRuleSubtreeStream stream_atomic = new RewriteRuleSubtreeStream(adaptor,
                "rule atomic");
        try {
            // MOWLParser.g:213:7: ( OPEN_CURLY_BRACES atomic ( COMMA atomic )*
            // CLOSED_CURLY_BRACES -> ^( ONE_OF ( atomic )+ ) )
            // MOWLParser.g:214:3: OPEN_CURLY_BRACES atomic ( COMMA atomic )*
            // CLOSED_CURLY_BRACES
            {
                OPEN_CURLY_BRACES100 = (Token) match(input, OPEN_CURLY_BRACES,
                        FOLLOW_OPEN_CURLY_BRACES_in_oneOf1962);
                if (state.failed) {
                    return retval;
                }
                if (state.backtracking == 0) {
                    stream_OPEN_CURLY_BRACES.add(OPEN_CURLY_BRACES100);
                }
                pushFollow(FOLLOW_atomic_in_oneOf1964);
                atomic101 = atomic();
                state._fsp--;
                if (state.failed) {
                    return retval;
                }
                if (state.backtracking == 0) {
                    stream_atomic.add(atomic101.getTree());
                }
                // MOWLParser.g:214:28: ( COMMA atomic )*
                loop20: do {
                    int alt20 = 2;
                    int LA20_0 = input.LA(1);
                    if (LA20_0 == COMMA) {
                        alt20 = 1;
                    }
                    switch (alt20) {
                        case 1:
                        // MOWLParser.g:214:29: COMMA atomic
                        {
                            COMMA102 = (Token) match(input, COMMA,
                                    FOLLOW_COMMA_in_oneOf1967);
                            if (state.failed) {
                                return retval;
                            }
                            if (state.backtracking == 0) {
                                stream_COMMA.add(COMMA102);
                            }
                            pushFollow(FOLLOW_atomic_in_oneOf1969);
                            atomic103 = atomic();
                            state._fsp--;
                            if (state.failed) {
                                return retval;
                            }
                            if (state.backtracking == 0) {
                                stream_atomic.add(atomic103.getTree());
                            }
                        }
                            break;
                        default:
                            break loop20;
                    }
                } while (true);
                CLOSED_CURLY_BRACES104 = (Token) match(input, CLOSED_CURLY_BRACES,
                        FOLLOW_CLOSED_CURLY_BRACES_in_oneOf1973);
                if (state.failed) {
                    return retval;
                }
                if (state.backtracking == 0) {
                    stream_CLOSED_CURLY_BRACES.add(CLOSED_CURLY_BRACES104);
                }
                // AST REWRITE
                // elements: atomic
                // token labels:
                // rule labels: retval
                // token list labels:
                // rule list labels:
                // wildcard labels:
                if (state.backtracking == 0) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(
                            adaptor, "rule retval", retval != null ? retval.tree : null);
                    root_0 = (ManchesterOWLSyntaxTree) adaptor.nil();
                    // 214:64: -> ^( ONE_OF ( atomic )+ )
                    {
                        // MOWLParser.g:214:67: ^( ONE_OF ( atomic )+ )
                        {
                            ManchesterOWLSyntaxTree root_1 = (ManchesterOWLSyntaxTree) adaptor
                                    .nil();
                            root_1 = (ManchesterOWLSyntaxTree) adaptor.becomeRoot(
                                    adaptor.create(ONE_OF, "ONE_OF"), root_1);
                            if (!stream_atomic.hasNext()) {
                                throw new RewriteEarlyExitException();
                            }
                            while (stream_atomic.hasNext()) {
                                adaptor.addChild(root_1, stream_atomic.nextTree());
                            }
                            stream_atomic.reset();
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
            throw e;
        } catch (RewriteEmptyStreamException e) {
            throw e;
        } finally {}
        return retval;
    }

    // $ANTLR end "oneOf"
    public static class valueRestriction_return extends ParserRuleReturnScope {
        ManchesterOWLSyntaxTree tree;

        @Override
        public Object getTree() {
            return tree;
        }
    };

    // $ANTLR start "valueRestriction"
    // MOWLParser.g:217:1: valueRestriction : propertyExpression VALUE value ->
    // ^( VALUE_RESTRICTION propertyExpression value ) ;
    public final ManchesterOWLSyntax_MOWLParser.valueRestriction_return
            valueRestriction() throws RecognitionException {
        ManchesterOWLSyntax_MOWLParser.valueRestriction_return retval = new ManchesterOWLSyntax_MOWLParser.valueRestriction_return();
        retval.start = input.LT(1);
        ManchesterOWLSyntaxTree root_0 = null;
        Token VALUE106 = null;
        ManchesterOWLSyntax_MOWLParser.propertyExpression_return propertyExpression105 = null;
        ManchesterOWLSyntax_MOWLParser.value_return value107 = null;
        ManchesterOWLSyntaxTree VALUE106_tree = null;
        RewriteRuleTokenStream stream_VALUE = new RewriteRuleTokenStream(adaptor,
                "token VALUE");
        RewriteRuleSubtreeStream stream_propertyExpression = new RewriteRuleSubtreeStream(
                adaptor, "rule propertyExpression");
        RewriteRuleSubtreeStream stream_value = new RewriteRuleSubtreeStream(adaptor,
                "rule value");
        try {
            // MOWLParser.g:217:18: ( propertyExpression VALUE value -> ^(
            // VALUE_RESTRICTION propertyExpression value ) )
            // MOWLParser.g:217:20: propertyExpression VALUE value
            {
                pushFollow(FOLLOW_propertyExpression_in_valueRestriction1993);
                propertyExpression105 = propertyExpression();
                state._fsp--;
                if (state.failed) {
                    return retval;
                }
                if (state.backtracking == 0) {
                    stream_propertyExpression.add(propertyExpression105.getTree());
                }
                VALUE106 = (Token) match(input, VALUE,
                        FOLLOW_VALUE_in_valueRestriction1995);
                if (state.failed) {
                    return retval;
                }
                if (state.backtracking == 0) {
                    stream_VALUE.add(VALUE106);
                }
                pushFollow(FOLLOW_value_in_valueRestriction1997);
                value107 = value();
                state._fsp--;
                if (state.failed) {
                    return retval;
                }
                if (state.backtracking == 0) {
                    stream_value.add(value107.getTree());
                }
                // AST REWRITE
                // elements: value, propertyExpression
                // token labels:
                // rule labels: retval
                // token list labels:
                // rule list labels:
                // wildcard labels:
                if (state.backtracking == 0) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(
                            adaptor, "rule retval", retval != null ? retval.tree : null);
                    root_0 = (ManchesterOWLSyntaxTree) adaptor.nil();
                    // 217:51: -> ^( VALUE_RESTRICTION propertyExpression value
                    // )
                    {
                        // MOWLParser.g:217:54: ^( VALUE_RESTRICTION
                        // propertyExpression value )
                        {
                            ManchesterOWLSyntaxTree root_1 = (ManchesterOWLSyntaxTree) adaptor
                                    .nil();
                            root_1 = (ManchesterOWLSyntaxTree) adaptor.becomeRoot(adaptor
                                    .create(VALUE_RESTRICTION, "VALUE_RESTRICTION"),
                                    root_1);
                            adaptor.addChild(root_1, stream_propertyExpression.nextTree());
                            adaptor.addChild(root_1, stream_value.nextTree());
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
            throw e;
        } catch (RewriteEmptyStreamException e) {
            throw e;
        } finally {}
        return retval;
    }

    // $ANTLR end "valueRestriction"
    public static class value_return extends ParserRuleReturnScope {
        ManchesterOWLSyntaxTree tree;

        @Override
        public Object getTree() {
            return tree;
        }
    };

    // $ANTLR start "value"
    // MOWLParser.g:220:1: value : ( atomic -> ^( atomic ) | constant -> ^(
    // constant ) );
    public final ManchesterOWLSyntax_MOWLParser.value_return value()
            throws RecognitionException {
        ManchesterOWLSyntax_MOWLParser.value_return retval = new ManchesterOWLSyntax_MOWLParser.value_return();
        retval.start = input.LT(1);
        ManchesterOWLSyntaxTree root_0 = null;
        ManchesterOWLSyntax_MOWLParser.atomic_return atomic108 = null;
        ManchesterOWLSyntax_MOWLParser.constant_return constant109 = null;
        RewriteRuleSubtreeStream stream_constant = new RewriteRuleSubtreeStream(adaptor,
                "rule constant");
        RewriteRuleSubtreeStream stream_atomic = new RewriteRuleSubtreeStream(adaptor,
                "rule atomic");
        try {
            // MOWLParser.g:220:6: ( atomic -> ^( atomic ) | constant -> ^(
            // constant ) )
            int alt21 = 2;
            int LA21_0 = input.LA(1);
            if (LA21_0 >= IDENTIFIER && LA21_0 <= ENTITY_REFERENCE) {
                alt21 = 1;
            } else if (LA21_0 == DBLQUOTE) {
                alt21 = 2;
            } else {
                if (state.backtracking > 0) {
                    state.failed = true;
                    return retval;
                }
                NoViableAltException nvae = new NoViableAltException("", 21, 0, input);
                throw nvae;
            }
            switch (alt21) {
                case 1:
                // MOWLParser.g:221:7: atomic
                {
                    pushFollow(FOLLOW_atomic_in_value2022);
                    atomic108 = atomic();
                    state._fsp--;
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        stream_atomic.add(atomic108.getTree());
                    }
                    // AST REWRITE
                    // elements: atomic
                    // token labels:
                    // rule labels: retval
                    // token list labels:
                    // rule list labels:
                    // wildcard labels:
                    if (state.backtracking == 0) {
                        retval.tree = root_0;
                        RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(
                                adaptor, "rule retval", retval != null ? retval.tree
                                        : null);
                        root_0 = (ManchesterOWLSyntaxTree) adaptor.nil();
                        // 221:14: -> ^( atomic )
                        {
                            // MOWLParser.g:221:17: ^( atomic )
                            {
                                ManchesterOWLSyntaxTree root_1 = (ManchesterOWLSyntaxTree) adaptor
                                        .nil();
                                root_1 = (ManchesterOWLSyntaxTree) adaptor.becomeRoot(
                                        stream_atomic.nextNode(), root_1);
                                adaptor.addChild(root_0, root_1);
                            }
                        }
                        retval.tree = root_0;
                    }
                }
                    break;
                case 2:
                // MOWLParser.g:222:7: constant
                {
                    pushFollow(FOLLOW_constant_in_value2037);
                    constant109 = constant();
                    state._fsp--;
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        stream_constant.add(constant109.getTree());
                    }
                    // AST REWRITE
                    // elements: constant
                    // token labels:
                    // rule labels: retval
                    // token list labels:
                    // rule list labels:
                    // wildcard labels:
                    if (state.backtracking == 0) {
                        retval.tree = root_0;
                        RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(
                                adaptor, "rule retval", retval != null ? retval.tree
                                        : null);
                        root_0 = (ManchesterOWLSyntaxTree) adaptor.nil();
                        // 222:16: -> ^( constant )
                        {
                            // MOWLParser.g:222:19: ^( constant )
                            {
                                ManchesterOWLSyntaxTree root_1 = (ManchesterOWLSyntaxTree) adaptor
                                        .nil();
                                root_1 = (ManchesterOWLSyntaxTree) adaptor.becomeRoot(
                                        stream_constant.nextNode(), root_1);
                                adaptor.addChild(root_0, root_1);
                            }
                        }
                        retval.tree = root_0;
                    }
                }
                    break;
            }
            retval.stop = input.LT(-1);
            if (state.backtracking == 0) {
                retval.tree = (ManchesterOWLSyntaxTree) adaptor
                        .rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        } catch (RecognitionException e) {
            throw e;
        } catch (RewriteEmptyStreamException e) {
            throw e;
        } finally {}
        return retval;
    }

    // $ANTLR end "value"
    public static class constant_return extends ParserRuleReturnScope {
        ManchesterOWLSyntaxTree tree;

        @Override
        public Object getTree() {
            return tree;
        }
    };

    // $ANTLR start "constant"
    // MOWLParser.g:225:1: constant : constantValue= DBLQUOTE ( AT language=
    // IDENTIFIER )? ( POW type= IDENTIFIER )? -> ^( CONSTANT $constantValue (
    // ^( AT $language) )? ( $type)? ) ;
    public final ManchesterOWLSyntax_MOWLParser.constant_return constant()
            throws RecognitionException {
        ManchesterOWLSyntax_MOWLParser.constant_return retval = new ManchesterOWLSyntax_MOWLParser.constant_return();
        retval.start = input.LT(1);
        ManchesterOWLSyntaxTree root_0 = null;
        Token constantValue = null;
        Token language = null;
        Token type = null;
        Token AT110 = null;
        Token POW111 = null;
        ManchesterOWLSyntaxTree constantValue_tree = null;
        ManchesterOWLSyntaxTree language_tree = null;
        ManchesterOWLSyntaxTree type_tree = null;
        ManchesterOWLSyntaxTree AT110_tree = null;
        ManchesterOWLSyntaxTree POW111_tree = null;
        RewriteRuleTokenStream stream_AT = new RewriteRuleTokenStream(adaptor, "token AT");
        RewriteRuleTokenStream stream_POW = new RewriteRuleTokenStream(adaptor,
                "token POW");
        RewriteRuleTokenStream stream_IDENTIFIER = new RewriteRuleTokenStream(adaptor,
                "token IDENTIFIER");
        RewriteRuleTokenStream stream_DBLQUOTE = new RewriteRuleTokenStream(adaptor,
                "token DBLQUOTE");
        try {
            // MOWLParser.g:225:11: (constantValue= DBLQUOTE ( AT language=
            // IDENTIFIER )? ( POW type= IDENTIFIER )? -> ^( CONSTANT
            // $constantValue ( ^( AT $language) )? ( $type)? ) )
            // MOWLParser.g:225:14: constantValue= DBLQUOTE ( AT language=
            // IDENTIFIER )? ( POW type= IDENTIFIER )?
            {
                constantValue = (Token) match(input, DBLQUOTE,
                        FOLLOW_DBLQUOTE_in_constant2062);
                if (state.failed) {
                    return retval;
                }
                if (state.backtracking == 0) {
                    stream_DBLQUOTE.add(constantValue);
                }
                // MOWLParser.g:225:39: ( AT language= IDENTIFIER )?
                int alt22 = 2;
                int LA22_0 = input.LA(1);
                if (LA22_0 == AT) {
                    alt22 = 1;
                }
                switch (alt22) {
                    case 1:
                    // MOWLParser.g:225:40: AT language= IDENTIFIER
                    {
                        AT110 = (Token) match(input, AT, FOLLOW_AT_in_constant2065);
                        if (state.failed) {
                            return retval;
                        }
                        if (state.backtracking == 0) {
                            stream_AT.add(AT110);
                        }
                        language = (Token) match(input, IDENTIFIER,
                                FOLLOW_IDENTIFIER_in_constant2071);
                        if (state.failed) {
                            return retval;
                        }
                        if (state.backtracking == 0) {
                            stream_IDENTIFIER.add(language);
                        }
                    }
                        break;
                }
                // MOWLParser.g:225:67: ( POW type= IDENTIFIER )?
                int alt23 = 2;
                int LA23_0 = input.LA(1);
                if (LA23_0 == POW) {
                    alt23 = 1;
                }
                switch (alt23) {
                    case 1:
                    // MOWLParser.g:225:69: POW type= IDENTIFIER
                    {
                        POW111 = (Token) match(input, POW, FOLLOW_POW_in_constant2077);
                        if (state.failed) {
                            return retval;
                        }
                        if (state.backtracking == 0) {
                            stream_POW.add(POW111);
                        }
                        type = (Token) match(input, IDENTIFIER,
                                FOLLOW_IDENTIFIER_in_constant2083);
                        if (state.failed) {
                            return retval;
                        }
                        if (state.backtracking == 0) {
                            stream_IDENTIFIER.add(type);
                        }
                    }
                        break;
                }
                // AST REWRITE
                // elements: AT, language, constantValue, type
                // token labels: constantValue, language, type
                // rule labels: retval
                // token list labels:
                // rule list labels:
                // wildcard labels:
                if (state.backtracking == 0) {
                    retval.tree = root_0;
                    RewriteRuleTokenStream stream_constantValue = new RewriteRuleTokenStream(
                            adaptor, "token constantValue", constantValue);
                    RewriteRuleTokenStream stream_language = new RewriteRuleTokenStream(
                            adaptor, "token language", language);
                    RewriteRuleTokenStream stream_type = new RewriteRuleTokenStream(
                            adaptor, "token type", type);
                    RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(
                            adaptor, "rule retval", retval != null ? retval.tree : null);
                    root_0 = (ManchesterOWLSyntaxTree) adaptor.nil();
                    // 225:93: -> ^( CONSTANT $constantValue ( ^( AT $language)
                    // )? ( $type)? )
                    {
                        // MOWLParser.g:225:95: ^( CONSTANT $constantValue ( ^(
                        // AT $language) )? ( $type)? )
                        {
                            ManchesterOWLSyntaxTree root_1 = (ManchesterOWLSyntaxTree) adaptor
                                    .nil();
                            root_1 = (ManchesterOWLSyntaxTree) adaptor.becomeRoot(
                                    adaptor.create(CONSTANT, "CONSTANT"), root_1);
                            adaptor.addChild(root_1, stream_constantValue.nextNode());
                            // MOWLParser.g:225:121: ( ^( AT $language) )?
                            if (stream_AT.hasNext() || stream_language.hasNext()) {
                                // MOWLParser.g:225:122: ^( AT $language)
                                {
                                    ManchesterOWLSyntaxTree root_2 = (ManchesterOWLSyntaxTree) adaptor
                                            .nil();
                                    root_2 = (ManchesterOWLSyntaxTree) adaptor
                                            .becomeRoot(stream_AT.nextNode(), root_2);
                                    adaptor.addChild(root_2, stream_language.nextNode());
                                    adaptor.addChild(root_1, root_2);
                                }
                            }
                            stream_AT.reset();
                            stream_language.reset();
                            // MOWLParser.g:225:140: ( $type)?
                            if (stream_type.hasNext()) {
                                adaptor.addChild(root_1, stream_type.nextNode());
                            }
                            stream_type.reset();
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
            throw e;
        } catch (RewriteEmptyStreamException e) {
            throw e;
        } finally {}
        return retval;
    }

    // $ANTLR end "constant"
    // $ANTLR start synpred1_MOWLParser
    public final void synpred1_MOWLParser_fragment() throws RecognitionException {
        // MOWLParser.g:65:3: ( binaryAxiom )
        // MOWLParser.g:65:3: binaryAxiom
        {
            pushFollow(FOLLOW_binaryAxiom_in_synpred1_MOWLParser232);
            binaryAxiom();
            state._fsp--;
            if (state.failed) {
                return;
            }
        }
    }

    // $ANTLR end synpred1_MOWLParser
    // $ANTLR start synpred3_MOWLParser
    public final void synpred3_MOWLParser_fragment() throws RecognitionException {
        // MOWLParser.g:67:5: ( assertionAxiom )
        // MOWLParser.g:67:5: assertionAxiom
        {
            pushFollow(FOLLOW_assertionAxiom_in_synpred3_MOWLParser256);
            assertionAxiom();
            state._fsp--;
            if (state.failed) {
                return;
            }
        }
    }

    // $ANTLR end synpred3_MOWLParser
    // $ANTLR start synpred4_MOWLParser
    public final void synpred4_MOWLParser_fragment() throws RecognitionException {
        // MOWLParser.g:68:5: ( hasKeyAxiom )
        // MOWLParser.g:68:5: hasKeyAxiom
        {
            pushFollow(FOLLOW_hasKeyAxiom_in_synpred4_MOWLParser268);
            hasKeyAxiom();
            state._fsp--;
            if (state.failed) {
                return;
            }
        }
    }

    // $ANTLR end synpred4_MOWLParser
    // $ANTLR start synpred9_MOWLParser
    public final void synpred9_MOWLParser_fragment() throws RecognitionException {
        ManchesterOWLSyntax_MOWLParser.expression_return lhs = null;
        ManchesterOWLSyntax_MOWLParser.expression_return superClass = null;
        // MOWLParser.g:103:2: (lhs= expression SUBCLASS_OF superClass=
        // expression )
        // MOWLParser.g:103:2: lhs= expression SUBCLASS_OF superClass=
        // expression
        {
            pushFollow(FOLLOW_expression_in_synpred9_MOWLParser639);
            lhs = expression();
            state._fsp--;
            if (state.failed) {
                return;
            }
            match(input, SUBCLASS_OF, FOLLOW_SUBCLASS_OF_in_synpred9_MOWLParser641);
            if (state.failed) {
                return;
            }
            pushFollow(FOLLOW_expression_in_synpred9_MOWLParser648);
            superClass = expression();
            state._fsp--;
            if (state.failed) {
                return;
            }
        }
    }

    // $ANTLR end synpred9_MOWLParser
    // $ANTLR start synpred10_MOWLParser
    public final void synpred10_MOWLParser_fragment() throws RecognitionException {
        ManchesterOWLSyntax_MOWLParser.expression_return lhs = null;
        ManchesterOWLSyntax_MOWLParser.expression_return rhs = null;
        // MOWLParser.g:104:11: (lhs= expression EQUIVALENT_TO rhs= expression )
        // MOWLParser.g:104:11: lhs= expression EQUIVALENT_TO rhs= expression
        {
            pushFollow(FOLLOW_expression_in_synpred10_MOWLParser686);
            lhs = expression();
            state._fsp--;
            if (state.failed) {
                return;
            }
            match(input, EQUIVALENT_TO, FOLLOW_EQUIVALENT_TO_in_synpred10_MOWLParser688);
            if (state.failed) {
                return;
            }
            pushFollow(FOLLOW_expression_in_synpred10_MOWLParser694);
            rhs = expression();
            state._fsp--;
            if (state.failed) {
                return;
            }
        }
    }

    // $ANTLR end synpred10_MOWLParser
    // $ANTLR start synpred11_MOWLParser
    public final void synpred11_MOWLParser_fragment() throws RecognitionException {
        ManchesterOWLSyntax_MOWLParser.expression_return lhs = null;
        ManchesterOWLSyntax_MOWLParser.expression_return disjoint = null;
        // MOWLParser.g:105:11: (lhs= expression DISJOINT_WITH disjoint=
        // expression )
        // MOWLParser.g:105:11: lhs= expression DISJOINT_WITH disjoint=
        // expression
        {
            pushFollow(FOLLOW_expression_in_synpred11_MOWLParser731);
            lhs = expression();
            state._fsp--;
            if (state.failed) {
                return;
            }
            match(input, DISJOINT_WITH, FOLLOW_DISJOINT_WITH_in_synpred11_MOWLParser733);
            if (state.failed) {
                return;
            }
            pushFollow(FOLLOW_expression_in_synpred11_MOWLParser739);
            disjoint = expression();
            state._fsp--;
            if (state.failed) {
                return;
            }
        }
    }

    // $ANTLR end synpred11_MOWLParser
    // $ANTLR start synpred12_MOWLParser
    public final void synpred12_MOWLParser_fragment() throws RecognitionException {
        ManchesterOWLSyntax_MOWLParser.expression_return lhs = null;
        ManchesterOWLSyntax_MOWLParser.propertyExpression_return superProperty = null;
        // MOWLParser.g:106:11: (lhs= expression SUB_PROPERTY_OF superProperty=
        // propertyExpression )
        // MOWLParser.g:106:11: lhs= expression SUB_PROPERTY_OF superProperty=
        // propertyExpression
        {
            pushFollow(FOLLOW_expression_in_synpred12_MOWLParser776);
            lhs = expression();
            state._fsp--;
            if (state.failed) {
                return;
            }
            match(input, SUB_PROPERTY_OF,
                    FOLLOW_SUB_PROPERTY_OF_in_synpred12_MOWLParser778);
            if (state.failed) {
                return;
            }
            pushFollow(FOLLOW_propertyExpression_in_synpred12_MOWLParser784);
            superProperty = propertyExpression();
            state._fsp--;
            if (state.failed) {
                return;
            }
        }
    }

    // $ANTLR end synpred12_MOWLParser
    // $ANTLR start synpred13_MOWLParser
    public final void synpred13_MOWLParser_fragment() throws RecognitionException {
        ManchesterOWLSyntax_MOWLParser.atomic_return lhsID = null;
        ManchesterOWLSyntax_MOWLParser.atomic_return rhsAtomic = null;
        // MOWLParser.g:107:11: (lhsID= atomic INVERSE_OF rhsAtomic= atomic )
        // MOWLParser.g:107:11: lhsID= atomic INVERSE_OF rhsAtomic= atomic
        {
            pushFollow(FOLLOW_atomic_in_synpred13_MOWLParser821);
            lhsID = atomic();
            state._fsp--;
            if (state.failed) {
                return;
            }
            match(input, INVERSE_OF, FOLLOW_INVERSE_OF_in_synpred13_MOWLParser823);
            if (state.failed) {
                return;
            }
            pushFollow(FOLLOW_atomic_in_synpred13_MOWLParser829);
            rhsAtomic = atomic();
            state._fsp--;
            if (state.failed) {
                return;
            }
        }
    }

    // $ANTLR end synpred13_MOWLParser
    // $ANTLR start synpred14_MOWLParser
    public final void synpred14_MOWLParser_fragment() throws RecognitionException {
        ManchesterOWLSyntax_MOWLParser.atomic_return lhsID = null;
        ManchesterOWLSyntax_MOWLParser.atomic_return rhsID = null;
        // MOWLParser.g:108:3: (lhsID= atomic SAME_AS rhsID= atomic )
        // MOWLParser.g:108:3: lhsID= atomic SAME_AS rhsID= atomic
        {
            pushFollow(FOLLOW_atomic_in_synpred14_MOWLParser860);
            lhsID = atomic();
            state._fsp--;
            if (state.failed) {
                return;
            }
            match(input, SAME_AS, FOLLOW_SAME_AS_in_synpred14_MOWLParser862);
            if (state.failed) {
                return;
            }
            pushFollow(FOLLOW_atomic_in_synpred14_MOWLParser869);
            rhsID = atomic();
            state._fsp--;
            if (state.failed) {
                return;
            }
        }
    }

    // $ANTLR end synpred14_MOWLParser
    // $ANTLR start synpred15_MOWLParser
    public final void synpred15_MOWLParser_fragment() throws RecognitionException {
        ManchesterOWLSyntax_MOWLParser.atomic_return lhsID = null;
        ManchesterOWLSyntax_MOWLParser.atomic_return rhsID = null;
        // MOWLParser.g:109:11: (lhsID= atomic DIFFERENT_FROM rhsID= atomic )
        // MOWLParser.g:109:11: lhsID= atomic DIFFERENT_FROM rhsID= atomic
        {
            pushFollow(FOLLOW_atomic_in_synpred15_MOWLParser907);
            lhsID = atomic();
            state._fsp--;
            if (state.failed) {
                return;
            }
            match(input, DIFFERENT_FROM, FOLLOW_DIFFERENT_FROM_in_synpred15_MOWLParser909);
            if (state.failed) {
                return;
            }
            pushFollow(FOLLOW_atomic_in_synpred15_MOWLParser916);
            rhsID = atomic();
            state._fsp--;
            if (state.failed) {
                return;
            }
        }
    }

    // $ANTLR end synpred15_MOWLParser
    // $ANTLR start synpred16_MOWLParser
    public final void synpred16_MOWLParser_fragment() throws RecognitionException {
        ManchesterOWLSyntax_MOWLParser.atomic_return lhsID = null;
        // MOWLParser.g:110:11: (lhsID= atomic DOMAIN expression )
        // MOWLParser.g:110:11: lhsID= atomic DOMAIN expression
        {
            pushFollow(FOLLOW_atomic_in_synpred16_MOWLParser953);
            lhsID = atomic();
            state._fsp--;
            if (state.failed) {
                return;
            }
            match(input, DOMAIN, FOLLOW_DOMAIN_in_synpred16_MOWLParser956);
            if (state.failed) {
                return;
            }
            pushFollow(FOLLOW_expression_in_synpred16_MOWLParser958);
            expression();
            state._fsp--;
            if (state.failed) {
                return;
            }
        }
    }

    // $ANTLR end synpred16_MOWLParser
    // $ANTLR start synpred17_MOWLParser
    public final void synpred17_MOWLParser_fragment() throws RecognitionException {
        // MOWLParser.g:132:5: ( disjunction )
        // MOWLParser.g:132:5: disjunction
        {
            pushFollow(FOLLOW_disjunction_in_synpred17_MOWLParser1247);
            disjunction();
            state._fsp--;
            if (state.failed) {
                return;
            }
        }
    }

    // $ANTLR end synpred17_MOWLParser
    // $ANTLR start synpred18_MOWLParser
    public final void synpred18_MOWLParser_fragment() throws RecognitionException {
        // MOWLParser.g:133:6: ( complexPropertyExpression )
        // MOWLParser.g:133:6: complexPropertyExpression
        {
            pushFollow(FOLLOW_complexPropertyExpression_in_synpred18_MOWLParser1260);
            complexPropertyExpression();
            state._fsp--;
            if (state.failed) {
                return;
            }
        }
    }

    // $ANTLR end synpred18_MOWLParser
    // $ANTLR start synpred19_MOWLParser
    public final void synpred19_MOWLParser_fragment() throws RecognitionException {
        List list_rest = null;
        ManchesterOWLSyntax_MOWLParser.propertyExpression_return head = null;
        RuleReturnScope rest = null;
        // MOWLParser.g:157:4: (head= propertyExpression ( COMPOSITION rest+=
        // propertyExpression )+ )
        // MOWLParser.g:157:4: head= propertyExpression ( COMPOSITION rest+=
        // propertyExpression )+
        {
            pushFollow(FOLLOW_propertyExpression_in_synpred19_MOWLParser1411);
            head = propertyExpression();
            state._fsp--;
            if (state.failed) {
                return;
            }
            // MOWLParser.g:157:30: ( COMPOSITION rest+= propertyExpression )+
            int cnt24 = 0;
            loop24: do {
                int alt24 = 2;
                int LA24_0 = input.LA(1);
                if (LA24_0 == COMPOSITION) {
                    alt24 = 1;
                }
                switch (alt24) {
                    case 1:
                    // MOWLParser.g:157:31: COMPOSITION rest+=
                    // propertyExpression
                    {
                        match(input, COMPOSITION,
                                FOLLOW_COMPOSITION_in_synpred19_MOWLParser1414);
                        if (state.failed) {
                            return;
                        }
                        pushFollow(FOLLOW_propertyExpression_in_synpred19_MOWLParser1418);
                        rest = propertyExpression();
                        state._fsp--;
                        if (state.failed) {
                            return;
                        }
                        if (list_rest == null) {
                            list_rest = new ArrayList();
                        }
                        list_rest.add(rest);
                    }
                        break;
                    default:
                        if (cnt24 >= 1) {
                            break loop24;
                        }
                        if (state.backtracking > 0) {
                            state.failed = true;
                            return;
                        }
                        EarlyExitException eee = new EarlyExitException(24, input);
                        throw eee;
                }
                cnt24++;
            } while (true);
        }
    }

    // $ANTLR end synpred19_MOWLParser
    // $ANTLR start synpred20_MOWLParser
    public final void synpred20_MOWLParser_fragment() throws RecognitionException {
        // MOWLParser.g:158:5: ( NOT OPEN_PARENTHESYS expression
        // CLOSED_PARENTHESYS )
        // MOWLParser.g:158:5: NOT OPEN_PARENTHESYS expression
        // CLOSED_PARENTHESYS
        {
            match(input, NOT, FOLLOW_NOT_in_synpred20_MOWLParser1440);
            if (state.failed) {
                return;
            }
            match(input, OPEN_PARENTHESYS,
                    FOLLOW_OPEN_PARENTHESYS_in_synpred20_MOWLParser1442);
            if (state.failed) {
                return;
            }
            pushFollow(FOLLOW_expression_in_synpred20_MOWLParser1444);
            expression();
            state._fsp--;
            if (state.failed) {
                return;
            }
            match(input, CLOSED_PARENTHESYS,
                    FOLLOW_CLOSED_PARENTHESYS_in_synpred20_MOWLParser1446);
            if (state.failed) {
                return;
            }
        }
    }

    // $ANTLR end synpred20_MOWLParser
    // $ANTLR start synpred21_MOWLParser
    public final void synpred21_MOWLParser_fragment() throws RecognitionException {
        // MOWLParser.g:159:5: ( NOT atomic )
        // MOWLParser.g:159:5: NOT atomic
        {
            match(input, NOT, FOLLOW_NOT_in_synpred21_MOWLParser1460);
            if (state.failed) {
                return;
            }
            pushFollow(FOLLOW_atomic_in_synpred21_MOWLParser1462);
            atomic();
            state._fsp--;
            if (state.failed) {
                return;
            }
        }
    }

    // $ANTLR end synpred21_MOWLParser
    // $ANTLR start synpred22_MOWLParser
    public final void synpred22_MOWLParser_fragment() throws RecognitionException {
        // MOWLParser.g:160:5: ( qualifiedRestriction )
        // MOWLParser.g:160:5: qualifiedRestriction
        {
            pushFollow(FOLLOW_qualifiedRestriction_in_synpred22_MOWLParser1485);
            qualifiedRestriction();
            state._fsp--;
            if (state.failed) {
                return;
            }
        }
    }

    // $ANTLR end synpred22_MOWLParser
    // $ANTLR start synpred23_MOWLParser
    public final void synpred23_MOWLParser_fragment() throws RecognitionException {
        // MOWLParser.g:161:5: ( dataRange )
        // MOWLParser.g:161:5: dataRange
        {
            pushFollow(FOLLOW_dataRange_in_synpred23_MOWLParser1497);
            dataRange();
            state._fsp--;
            if (state.failed) {
                return;
            }
        }
    }

    // $ANTLR end synpred23_MOWLParser
    // $ANTLR start synpred25_MOWLParser
    public final void synpred25_MOWLParser_fragment() throws RecognitionException {
        // MOWLParser.g:188:7: ( propertyExpression SOME expression )
        // MOWLParser.g:188:7: propertyExpression SOME expression
        {
            pushFollow(FOLLOW_propertyExpression_in_synpred25_MOWLParser1696);
            propertyExpression();
            state._fsp--;
            if (state.failed) {
                return;
            }
            match(input, SOME, FOLLOW_SOME_in_synpred25_MOWLParser1699);
            if (state.failed) {
                return;
            }
            pushFollow(FOLLOW_expression_in_synpred25_MOWLParser1703);
            expression();
            state._fsp--;
            if (state.failed) {
                return;
            }
        }
    }

    // $ANTLR end synpred25_MOWLParser
    // $ANTLR start synpred26_MOWLParser
    public final void synpred26_MOWLParser_fragment() throws RecognitionException {
        // MOWLParser.g:189:7: ( propertyExpression ONLY expression )
        // MOWLParser.g:189:7: propertyExpression ONLY expression
        {
            pushFollow(FOLLOW_propertyExpression_in_synpred26_MOWLParser1732);
            propertyExpression();
            state._fsp--;
            if (state.failed) {
                return;
            }
            match(input, ONLY, FOLLOW_ONLY_in_synpred26_MOWLParser1734);
            if (state.failed) {
                return;
            }
            pushFollow(FOLLOW_expression_in_synpred26_MOWLParser1737);
            expression();
            state._fsp--;
            if (state.failed) {
                return;
            }
        }
    }

    // $ANTLR end synpred26_MOWLParser
    // $ANTLR start synpred27_MOWLParser
    public final void synpred27_MOWLParser_fragment() throws RecognitionException {
        // MOWLParser.g:190:7: ( cardinalityRestriction )
        // MOWLParser.g:190:7: cardinalityRestriction
        {
            pushFollow(FOLLOW_cardinalityRestriction_in_synpred27_MOWLParser1756);
            cardinalityRestriction();
            state._fsp--;
            if (state.failed) {
                return;
            }
        }
    }

    Logger logger = Logging.getParseLogging();

    // $ANTLR end synpred27_MOWLParser
    // Delegated rules
    public final boolean synpred22_MOWLParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred22_MOWLParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            logger.info("impossible: ", re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed = false;
        return success;
    }

    public final boolean synpred21_MOWLParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred21_MOWLParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            logger.info("impossible: ", re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed = false;
        return success;
    }

    public final boolean synpred23_MOWLParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred23_MOWLParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            logger.info("impossible: ", re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed = false;
        return success;
    }

    public final boolean synpred25_MOWLParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred25_MOWLParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            logger.info("impossible: ", re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed = false;
        return success;
    }

    public final boolean synpred3_MOWLParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred3_MOWLParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            logger.info("impossible: ", re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed = false;
        return success;
    }

    public final boolean synpred17_MOWLParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred17_MOWLParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            logger.info("impossible: ", re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed = false;
        return success;
    }

    public final boolean synpred27_MOWLParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred27_MOWLParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            logger.info("impossible: ", re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed = false;
        return success;
    }

    public final boolean synpred1_MOWLParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred1_MOWLParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            logger.info("impossible: ", re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed = false;
        return success;
    }

    public final boolean synpred12_MOWLParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred12_MOWLParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            logger.info("impossible: ", re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed = false;
        return success;
    }

    public final boolean synpred19_MOWLParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred19_MOWLParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            logger.info("impossible: ", re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed = false;
        return success;
    }

    public final boolean synpred14_MOWLParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred14_MOWLParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            logger.info("impossible: ", re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed = false;
        return success;
    }

    public final boolean synpred16_MOWLParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred16_MOWLParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            logger.info("impossible: ", re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed = false;
        return success;
    }

    public final boolean synpred11_MOWLParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred11_MOWLParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            logger.info("impossible: ", re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed = false;
        return success;
    }

    public final boolean synpred15_MOWLParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred15_MOWLParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            logger.info("impossible: ", re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed = false;
        return success;
    }

    public final boolean synpred9_MOWLParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred9_MOWLParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            logger.info("impossible: ", re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed = false;
        return success;
    }

    public final boolean synpred4_MOWLParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred4_MOWLParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            logger.info("impossible: ", re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed = false;
        return success;
    }

    public final boolean synpred20_MOWLParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred20_MOWLParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            logger.info("impossible: ", re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed = false;
        return success;
    }

    public final boolean synpred18_MOWLParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred18_MOWLParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            logger.info("impossible: ", re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed = false;
        return success;
    }

    public final boolean synpred10_MOWLParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred10_MOWLParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            logger.info("impossible: ", re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed = false;
        return success;
    }

    public final boolean synpred26_MOWLParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred26_MOWLParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            logger.info("impossible: ", re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed = false;
        return success;
    }

    public final boolean synpred13_MOWLParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred13_MOWLParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            logger.info("impossible: ", re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed = false;
        return success;
    }

    protected DFA1 dfa1 = new DFA1(this);
    protected DFA6 dfa6 = new DFA6(this);
    protected DFA12 dfa12 = new DFA12(this);
    static final String DFA1_eotS = "\22\uffff";
    static final String DFA1_eofS = "\22\uffff";
    static final String DFA1_minS = "\1\5\6\0\13\uffff";
    static final String DFA1_maxS = "\1\156\6\0\13\uffff";
    static final String DFA1_acceptS = "\7\uffff\1\1\1\2\6\uffff\1\5\1\3\1\4";
    static final String DFA1_specialS = "\1\uffff\1\0\1\1\1\2\1\3\1\4\1\5\13\uffff}>";
    static final String[] DFA1_transitionS = {
            "\1\7\1\5\5\uffff\1\4\6\uffff\1\3\11\uffff\7\10\4\uffff\1\6\3"
                    + "\uffff\1\1\1\2\100\uffff\1\17", "\1\uffff", "\1\uffff",
            "\1\uffff", "\1\uffff", "\1\uffff", "\1\uffff", "", "", "", "", "", "", "",
            "", "", "", "" };
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
            decisionNumber = 1;
            eot = DFA1_eot;
            eof = DFA1_eof;
            min = DFA1_min;
            max = DFA1_max;
            accept = DFA1_accept;
            special = DFA1_special;
            transition = DFA1_transition;
        }

        @Override
        public String getDescription() {
            return "64:1: axiom options {backtrack=true; } : ( binaryAxiom -> ^( binaryAxiom ) | unaryAxiom -> ^( unaryAxiom ) | assertionAxiom -> ^( assertionAxiom ) | hasKeyAxiom -> ^( hasKeyAxiom ) | annotationAssertionAxiom -> ^( annotationAssertionAxiom ) );";
        }

        @Override
        public int specialStateTransition(int s, IntStream _input)
                throws NoViableAltException {
            TokenStream input = (TokenStream) _input;
            int _s = s;
            switch (s) {
                case 0:
                    int LA1_1 = input.LA(1);
                    int index1_1 = input.index();
                    input.rewind();
                    s = -1;
                    if (synpred1_MOWLParser()) {
                        s = 7;
                    } else if (synpred3_MOWLParser()) {
                        s = 16;
                    } else if (synpred4_MOWLParser()) {
                        s = 17;
                    }
                    input.seek(index1_1);
                    if (s >= 0) {
                        return s;
                    }
                    break;
                case 1:
                    int LA1_2 = input.LA(1);
                    int index1_2 = input.index();
                    input.rewind();
                    s = -1;
                    if (synpred1_MOWLParser()) {
                        s = 7;
                    } else if (synpred3_MOWLParser()) {
                        s = 16;
                    } else if (synpred4_MOWLParser()) {
                        s = 17;
                    }
                    input.seek(index1_2);
                    if (s >= 0) {
                        return s;
                    }
                    break;
                case 2:
                    int LA1_3 = input.LA(1);
                    int index1_3 = input.index();
                    input.rewind();
                    s = -1;
                    if (synpred1_MOWLParser()) {
                        s = 7;
                    } else if (synpred4_MOWLParser()) {
                        s = 17;
                    }
                    input.seek(index1_3);
                    if (s >= 0) {
                        return s;
                    }
                    break;
                case 3:
                    int LA1_4 = input.LA(1);
                    int index1_4 = input.index();
                    input.rewind();
                    s = -1;
                    if (synpred1_MOWLParser()) {
                        s = 7;
                    } else if (synpred3_MOWLParser()) {
                        s = 16;
                    } else if (synpred4_MOWLParser()) {
                        s = 17;
                    }
                    input.seek(index1_4);
                    if (s >= 0) {
                        return s;
                    }
                    break;
                case 4:
                    int LA1_5 = input.LA(1);
                    int index1_5 = input.index();
                    input.rewind();
                    s = -1;
                    if (synpred1_MOWLParser()) {
                        s = 7;
                    } else if (synpred4_MOWLParser()) {
                        s = 17;
                    }
                    input.seek(index1_5);
                    if (s >= 0) {
                        return s;
                    }
                    break;
                case 5:
                    int LA1_6 = input.LA(1);
                    int index1_6 = input.index();
                    input.rewind();
                    s = -1;
                    if (synpred1_MOWLParser()) {
                        s = 7;
                    } else if (synpred4_MOWLParser()) {
                        s = 17;
                    }
                    input.seek(index1_6);
                    if (s >= 0) {
                        return s;
                    }
                    break;
            }
            if (state.backtracking > 0) {
                state.failed = true;
                return -1;
            }
            NoViableAltException nvae = new NoViableAltException(getDescription(), 1, _s,
                    input);
            error(nvae);
            throw nvae;
        }
    }

    static final String DFA6_eotS = "\21\uffff";
    static final String DFA6_eofS = "\21\uffff";
    static final String DFA6_minS = "\1\5\7\0\11\uffff";
    static final String DFA6_maxS = "\1\55\7\0\11\uffff";
    static final String DFA6_acceptS = "\10\uffff\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11";
    static final String DFA6_specialS = "\1\uffff\1\0\1\1\1\2\1\3\1\4\1\5\1\6\11\uffff}>";
    static final String[] DFA6_transitionS = {
            "\1\7\1\5\5\uffff\1\4\6\uffff\1\3\24\uffff\1\6\3\uffff\1\1\1" + "\2",
            "\1\uffff", "\1\uffff", "\1\uffff", "\1\uffff", "\1\uffff", "\1\uffff",
            "\1\uffff", "", "", "", "", "", "", "", "", "" };
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
            decisionNumber = 6;
            eot = DFA6_eot;
            eof = DFA6_eof;
            min = DFA6_min;
            max = DFA6_max;
            accept = DFA6_accept;
            special = DFA6_special;
            transition = DFA6_transition;
        }

        @Override
        public String getDescription() {
            return "101:1: binaryAxiom options {backtrack=true; } : (lhs= expression SUBCLASS_OF superClass= expression -> ^( SUB_CLASS_AXIOM ^( EXPRESSION $lhs) ^( EXPRESSION $superClass) ) | lhs= expression EQUIVALENT_TO rhs= expression -> ^( EQUIVALENT_TO_AXIOM ^( EXPRESSION $lhs) ^( EXPRESSION $rhs) ) | lhs= expression DISJOINT_WITH disjoint= expression -> ^( DISJOINT_WITH_AXIOM ^( EXPRESSION $lhs) ^( EXPRESSION $disjoint) ) | lhs= expression SUB_PROPERTY_OF superProperty= propertyExpression -> ^( SUB_PROPERTY_AXIOM ^( EXPRESSION $lhs) ^( EXPRESSION $superProperty) ) | lhsID= atomic INVERSE_OF rhsAtomic= atomic -> ^( INVERSE_OF ^( EXPRESSION $lhsID) ^( EXPRESSION $rhsAtomic) ) | lhsID= atomic SAME_AS rhsID= atomic -> ^( SAME_AS_AXIOM ^( EXPRESSION $lhsID) ^( EXPRESSION $rhsID) ) | lhsID= atomic DIFFERENT_FROM rhsID= atomic -> ^( DIFFERENT_FROM_AXIOM ^( EXPRESSION $lhsID) ^( EXPRESSION $rhsID) ) | lhsID= atomic DOMAIN expression -> ^( DOMAIN ^( EXPRESSION $lhsID) ^( EXPRESSION expression ) ) | lhsID= atomic RANGE expression -> ^( RANGE ^( EXPRESSION $lhsID) ^( EXPRESSION expression ) ) );";
        }

        @Override
        public int specialStateTransition(int s, IntStream _input)
                throws NoViableAltException {
            TokenStream input = (TokenStream) _input;
            int _s = s;
            switch (s) {
                case 0:
                    int LA6_1 = input.LA(1);
                    int index6_1 = input.index();
                    input.rewind();
                    s = -1;
                    if (synpred9_MOWLParser()) {
                        s = 8;
                    } else if (synpred10_MOWLParser()) {
                        s = 9;
                    } else if (synpred11_MOWLParser()) {
                        s = 10;
                    } else if (synpred12_MOWLParser()) {
                        s = 11;
                    } else if (synpred13_MOWLParser()) {
                        s = 12;
                    } else if (synpred14_MOWLParser()) {
                        s = 13;
                    } else if (synpred15_MOWLParser()) {
                        s = 14;
                    } else if (synpred16_MOWLParser()) {
                        s = 15;
                    } else if (true) {
                        s = 16;
                    }
                    input.seek(index6_1);
                    if (s >= 0) {
                        return s;
                    }
                    break;
                case 1:
                    int LA6_2 = input.LA(1);
                    int index6_2 = input.index();
                    input.rewind();
                    s = -1;
                    if (synpred9_MOWLParser()) {
                        s = 8;
                    } else if (synpred10_MOWLParser()) {
                        s = 9;
                    } else if (synpred11_MOWLParser()) {
                        s = 10;
                    } else if (synpred12_MOWLParser()) {
                        s = 11;
                    } else if (synpred13_MOWLParser()) {
                        s = 12;
                    } else if (synpred14_MOWLParser()) {
                        s = 13;
                    } else if (synpred15_MOWLParser()) {
                        s = 14;
                    } else if (synpred16_MOWLParser()) {
                        s = 15;
                    } else if (true) {
                        s = 16;
                    }
                    input.seek(index6_2);
                    if (s >= 0) {
                        return s;
                    }
                    break;
                case 2:
                    int LA6_3 = input.LA(1);
                    int index6_3 = input.index();
                    input.rewind();
                    s = -1;
                    if (synpred9_MOWLParser()) {
                        s = 8;
                    } else if (synpred10_MOWLParser()) {
                        s = 9;
                    } else if (synpred11_MOWLParser()) {
                        s = 10;
                    } else if (synpred12_MOWLParser()) {
                        s = 11;
                    }
                    input.seek(index6_3);
                    if (s >= 0) {
                        return s;
                    }
                    break;
                case 3:
                    int LA6_4 = input.LA(1);
                    int index6_4 = input.index();
                    input.rewind();
                    s = -1;
                    if (synpred9_MOWLParser()) {
                        s = 8;
                    } else if (synpred10_MOWLParser()) {
                        s = 9;
                    } else if (synpred11_MOWLParser()) {
                        s = 10;
                    } else if (synpred12_MOWLParser()) {
                        s = 11;
                    }
                    input.seek(index6_4);
                    if (s >= 0) {
                        return s;
                    }
                    break;
                case 4:
                    int LA6_5 = input.LA(1);
                    int index6_5 = input.index();
                    input.rewind();
                    s = -1;
                    if (synpred9_MOWLParser()) {
                        s = 8;
                    } else if (synpred10_MOWLParser()) {
                        s = 9;
                    } else if (synpred11_MOWLParser()) {
                        s = 10;
                    } else if (synpred12_MOWLParser()) {
                        s = 11;
                    }
                    input.seek(index6_5);
                    if (s >= 0) {
                        return s;
                    }
                    break;
                case 5:
                    int LA6_6 = input.LA(1);
                    int index6_6 = input.index();
                    input.rewind();
                    s = -1;
                    if (synpred9_MOWLParser()) {
                        s = 8;
                    } else if (synpred10_MOWLParser()) {
                        s = 9;
                    } else if (synpred11_MOWLParser()) {
                        s = 10;
                    } else if (synpred12_MOWLParser()) {
                        s = 11;
                    }
                    input.seek(index6_6);
                    if (s >= 0) {
                        return s;
                    }
                    break;
                case 6:
                    int LA6_7 = input.LA(1);
                    int index6_7 = input.index();
                    input.rewind();
                    s = -1;
                    if (synpred9_MOWLParser()) {
                        s = 8;
                    } else if (synpred10_MOWLParser()) {
                        s = 9;
                    } else if (synpred11_MOWLParser()) {
                        s = 10;
                    } else if (synpred12_MOWLParser()) {
                        s = 11;
                    }
                    input.seek(index6_7);
                    if (s >= 0) {
                        return s;
                    }
                    break;
            }
            if (state.backtracking > 0) {
                state.failed = true;
                return -1;
            }
            NoViableAltException nvae = new NoViableAltException(getDescription(), 6, _s,
                    input);
            error(nvae);
            throw nvae;
        }
    }

    static final String DFA12_eotS = "\14\uffff";
    static final String DFA12_eofS = "\14\uffff";
    static final String DFA12_minS = "\1\6\4\0\7\uffff";
    static final String DFA12_maxS = "\1\55\4\0\7\uffff";
    static final String DFA12_acceptS = "\5\uffff\1\4\1\6\1\1\1\5\1\7\1\2\1\3";
    static final String DFA12_specialS = "\1\uffff\1\0\1\1\1\2\1\3\7\uffff}>";
    static final String[] DFA12_transitionS = {
            "\1\5\5\uffff\1\4\6\uffff\1\3\24\uffff\1\6\3\uffff\1\1\1\2", "\1\uffff",
            "\1\uffff", "\1\uffff", "\1\uffff", "", "", "", "", "", "", "" };
    static final short[] DFA12_eot = DFA.unpackEncodedString(DFA12_eotS);
    static final short[] DFA12_eof = DFA.unpackEncodedString(DFA12_eofS);
    static final char[] DFA12_min = DFA.unpackEncodedStringToUnsignedChars(DFA12_minS);
    static final char[] DFA12_max = DFA.unpackEncodedStringToUnsignedChars(DFA12_maxS);
    static final short[] DFA12_accept = DFA.unpackEncodedString(DFA12_acceptS);
    static final short[] DFA12_special = DFA.unpackEncodedString(DFA12_specialS);
    static final short[][] DFA12_transition;
    static {
        int numStates = DFA12_transitionS.length;
        DFA12_transition = new short[numStates][];
        for (int i = 0; i < numStates; i++) {
            DFA12_transition[i] = DFA.unpackEncodedString(DFA12_transitionS[i]);
        }
    }

    class DFA12 extends DFA {
        public DFA12(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            decisionNumber = 12;
            eot = DFA12_eot;
            eof = DFA12_eof;
            min = DFA12_min;
            max = DFA12_max;
            accept = DFA12_accept;
            special = DFA12_special;
            transition = DFA12_transition;
        }

        @Override
        public String getDescription() {
            return "155:1: unary options {backtrack=true; } : (head= propertyExpression ( COMPOSITION rest+= propertyExpression )+ -> ^( PROPERTY_CHAIN $head $rest) | NOT OPEN_PARENTHESYS expression CLOSED_PARENTHESYS -> ^( NEGATED_EXPRESSION expression ) | NOT atomic -> ^( NEGATED_EXPRESSION atomic ) | qualifiedRestriction -> ^( qualifiedRestriction ) | dataRange | constant | atomic );";
        }

        @Override
        public int specialStateTransition(int s, IntStream _input)
                throws NoViableAltException {
            TokenStream input = (TokenStream) _input;
            int _s = s;
            switch (s) {
                case 0:
                    int LA12_1 = input.LA(1);
                    int index12_1 = input.index();
                    input.rewind();
                    s = -1;
                    if (synpred19_MOWLParser()) {
                        s = 7;
                    } else if (synpred22_MOWLParser()) {
                        s = 5;
                    } else if (synpred23_MOWLParser()) {
                        s = 8;
                    } else if (true) {
                        s = 9;
                    }
                    input.seek(index12_1);
                    if (s >= 0) {
                        return s;
                    }
                    break;
                case 1:
                    int LA12_2 = input.LA(1);
                    int index12_2 = input.index();
                    input.rewind();
                    s = -1;
                    if (synpred19_MOWLParser()) {
                        s = 7;
                    } else if (synpred22_MOWLParser()) {
                        s = 5;
                    } else if (true) {
                        s = 9;
                    }
                    input.seek(index12_2);
                    if (s >= 0) {
                        return s;
                    }
                    break;
                case 2:
                    int LA12_3 = input.LA(1);
                    int index12_3 = input.index();
                    input.rewind();
                    s = -1;
                    if (synpred19_MOWLParser()) {
                        s = 7;
                    } else if (synpred22_MOWLParser()) {
                        s = 5;
                    }
                    input.seek(index12_3);
                    if (s >= 0) {
                        return s;
                    }
                    break;
                case 3:
                    int LA12_4 = input.LA(1);
                    int index12_4 = input.index();
                    input.rewind();
                    s = -1;
                    if (synpred20_MOWLParser()) {
                        s = 10;
                    } else if (synpred21_MOWLParser()) {
                        s = 11;
                    }
                    input.seek(index12_4);
                    if (s >= 0) {
                        return s;
                    }
                    break;
            }
            if (state.backtracking > 0) {
                state.failed = true;
                return -1;
            }
            NoViableAltException nvae = new NoViableAltException(getDescription(), 12,
                    _s, input);
            error(nvae);
            throw nvae;
        }
    }

    public static final BitSet FOLLOW_binaryAxiom_in_axiom232 = new BitSet(
            new long[] { 0x0000000000000002L });
    public static final BitSet FOLLOW_unaryAxiom_in_axiom244 = new BitSet(
            new long[] { 0x0000000000000002L });
    public static final BitSet FOLLOW_assertionAxiom_in_axiom256 = new BitSet(
            new long[] { 0x0000000000000002L });
    public static final BitSet FOLLOW_hasKeyAxiom_in_axiom268 = new BitSet(
            new long[] { 0x0000000000000002L });
    public static final BitSet FOLLOW_annotationAssertionAxiom_in_axiom279 = new BitSet(
            new long[] { 0x0000000000000002L });
    public static final BitSet FOLLOW_iri_in_annotationAssertionAxiom311 = new BitSet(
            new long[] { 0x0000300000000000L });
    public static final BitSet FOLLOW_atomic_in_annotationAssertionAxiom316 = new BitSet(
            new long[] { 0x0000010000000000L });
    public static final BitSet FOLLOW_constant_in_annotationAssertionAxiom322 = new BitSet(
            new long[] { 0x0000000000000002L });
    public static final BitSet FOLLOW_iri_in_annotationAssertionAxiom350 = new BitSet(
            new long[] { 0x0000300000000000L });
    public static final BitSet FOLLOW_atomic_in_annotationAssertionAxiom355 = new BitSet(
            new long[] { 0x0000300000000000L });
    public static final BitSet FOLLOW_atomic_in_annotationAssertionAxiom361 = new BitSet(
            new long[] { 0x0000000000000002L });
    public static final BitSet FOLLOW_iri_in_annotationAssertionAxiom393 = new BitSet(
            new long[] { 0x0000300000000000L });
    public static final BitSet FOLLOW_atomic_in_annotationAssertionAxiom398 = new BitSet(
            new long[] { 0x0000000000000000L, 0x0000400000000000L });
    public static final BitSet FOLLOW_iri_in_annotationAssertionAxiom404 = new BitSet(
            new long[] { 0x0000000000000002L });
    public static final BitSet FOLLOW_IRI_in_iri440 = new BitSet(
            new long[] { 0x0000000000000002L });
    public static final BitSet FOLLOW_disjunction_in_hasKeyAxiom462 = new BitSet(
            new long[] { 0x0000000000000000L, 0x0000200000000000L });
    public static final BitSet FOLLOW_HAS_KEY_in_hasKeyAxiom464 = new BitSet(
            new long[] { 0x0000300000080000L });
    public static final BitSet FOLLOW_propertyExpression_in_hasKeyAxiom466 = new BitSet(
            new long[] { 0x0000002000000002L });
    public static final BitSet FOLLOW_COMMA_in_hasKeyAxiom469 = new BitSet(
            new long[] { 0x0000300000080000L });
    public static final BitSet FOLLOW_propertyExpression_in_hasKeyAxiom471 = new BitSet(
            new long[] { 0x0000002000000002L });
    public static final BitSet FOLLOW_atomic_in_assertionAxiom520 = new BitSet(
            new long[] { 0x000000C000000000L });
    public static final BitSet FOLLOW_INSTANCE_OF_in_assertionAxiom523 = new BitSet(
            new long[] { 0x0000310000081060L });
    public static final BitSet FOLLOW_TYPES_in_assertionAxiom527 = new BitSet(
            new long[] { 0x0000310000081060L });
    public static final BitSet FOLLOW_expression_in_assertionAxiom530 = new BitSet(
            new long[] { 0x0000000000000002L });
    public static final BitSet FOLLOW_atomic_in_assertionAxiom561 = new BitSet(
            new long[] { 0x0000300000080000L });
    public static final BitSet FOLLOW_propertyExpression_in_assertionAxiom563 = new BitSet(
            new long[] { 0x0000310000000000L });
    public static final BitSet FOLLOW_value_in_assertionAxiom566 = new BitSet(
            new long[] { 0x0000000000000002L });
    public static final BitSet FOLLOW_NOT_in_assertionAxiom600 = new BitSet(
            new long[] { 0x0000300000001000L });
    public static final BitSet FOLLOW_assertionAxiom_in_assertionAxiom602 = new BitSet(
            new long[] { 0x0000000000000002L });
    public static final BitSet FOLLOW_expression_in_binaryAxiom639 = new BitSet(
            new long[] { 0x0000000000100000L });
    public static final BitSet FOLLOW_SUBCLASS_OF_in_binaryAxiom641 = new BitSet(
            new long[] { 0x0000310000081060L });
    public static final BitSet FOLLOW_expression_in_binaryAxiom648 = new BitSet(
            new long[] { 0x0000000000000002L });
    public static final BitSet FOLLOW_expression_in_binaryAxiom686 = new BitSet(
            new long[] { 0x0000000000400000L });
    public static final BitSet FOLLOW_EQUIVALENT_TO_in_binaryAxiom688 = new BitSet(
            new long[] { 0x0000310000081060L });
    public static final BitSet FOLLOW_expression_in_binaryAxiom694 = new BitSet(
            new long[] { 0x0000000000000002L });
    public static final BitSet FOLLOW_expression_in_binaryAxiom731 = new BitSet(
            new long[] { 0x0000000004000000L });
    public static final BitSet FOLLOW_DISJOINT_WITH_in_binaryAxiom733 = new BitSet(
            new long[] { 0x0000310000081060L });
    public static final BitSet FOLLOW_expression_in_binaryAxiom739 = new BitSet(
            new long[] { 0x0000000000000002L });
    public static final BitSet FOLLOW_expression_in_binaryAxiom776 = new BitSet(
            new long[] { 0x0000000000200000L });
    public static final BitSet FOLLOW_SUB_PROPERTY_OF_in_binaryAxiom778 = new BitSet(
            new long[] { 0x0000300000080000L });
    public static final BitSet FOLLOW_propertyExpression_in_binaryAxiom784 = new BitSet(
            new long[] { 0x0000000000000002L });
    public static final BitSet FOLLOW_atomic_in_binaryAxiom821 = new BitSet(
            new long[] { 0x0000000002000000L });
    public static final BitSet FOLLOW_INVERSE_OF_in_binaryAxiom823 = new BitSet(
            new long[] { 0x0000300000000000L });
    public static final BitSet FOLLOW_atomic_in_binaryAxiom829 = new BitSet(
            new long[] { 0x0000000000000002L });
    public static final BitSet FOLLOW_atomic_in_binaryAxiom860 = new BitSet(
            new long[] { 0x0000000000800000L });
    public static final BitSet FOLLOW_SAME_AS_in_binaryAxiom862 = new BitSet(
            new long[] { 0x0000300000000000L });
    public static final BitSet FOLLOW_atomic_in_binaryAxiom869 = new BitSet(
            new long[] { 0x0000000000000002L });
    public static final BitSet FOLLOW_atomic_in_binaryAxiom907 = new BitSet(
            new long[] { 0x0000000001000000L });
    public static final BitSet FOLLOW_DIFFERENT_FROM_in_binaryAxiom909 = new BitSet(
            new long[] { 0x0000300000000000L });
    public static final BitSet FOLLOW_atomic_in_binaryAxiom916 = new BitSet(
            new long[] { 0x0000000000000002L });
    public static final BitSet FOLLOW_atomic_in_binaryAxiom953 = new BitSet(
            new long[] { 0x0000000008000000L });
    public static final BitSet FOLLOW_DOMAIN_in_binaryAxiom956 = new BitSet(
            new long[] { 0x0000310000081060L });
    public static final BitSet FOLLOW_expression_in_binaryAxiom958 = new BitSet(
            new long[] { 0x0000000000000002L });
    public static final BitSet FOLLOW_atomic_in_binaryAxiom994 = new BitSet(
            new long[] { 0x0000000010000000L });
    public static final BitSet FOLLOW_RANGE_in_binaryAxiom996 = new BitSet(
            new long[] { 0x0000310000081060L });
    public static final BitSet FOLLOW_expression_in_binaryAxiom998 = new BitSet(
            new long[] { 0x0000000000000002L });
    public static final BitSet FOLLOW_unaryCharacteristic_in_unaryAxiom1072 = new BitSet(
            new long[] { 0x0000310000081040L });
    public static final BitSet FOLLOW_unary_in_unaryAxiom1076 = new BitSet(
            new long[] { 0x0000000000000002L });
    public static final BitSet FOLLOW_FUNCTIONAL_in_unaryCharacteristic1121 = new BitSet(
            new long[] { 0x0000000000000002L });
    public static final BitSet FOLLOW_INVERSE_FUNCTIONAL_in_unaryCharacteristic1135 = new BitSet(
            new long[] { 0x0000000000000002L });
    public static final BitSet FOLLOW_SYMMETRIC_in_unaryCharacteristic1149 = new BitSet(
            new long[] { 0x0000000000000002L });
    public static final BitSet FOLLOW_ANTI_SYMMETRIC_in_unaryCharacteristic1163 = new BitSet(
            new long[] { 0x0000000000000002L });
    public static final BitSet FOLLOW_REFLEXIVE_in_unaryCharacteristic1177 = new BitSet(
            new long[] { 0x0000000000000002L });
    public static final BitSet FOLLOW_IRREFLEXIVE_in_unaryCharacteristic1191 = new BitSet(
            new long[] { 0x0000000000000002L });
    public static final BitSet FOLLOW_TRANSITIVE_in_unaryCharacteristic1205 = new BitSet(
            new long[] { 0x0000000000000002L });
    public static final BitSet FOLLOW_disjunction_in_expression1247 = new BitSet(
            new long[] { 0x0000000000000002L });
    public static final BitSet FOLLOW_complexPropertyExpression_in_expression1260 = new BitSet(
            new long[] { 0x0000000000000002L });
    public static final BitSet FOLLOW_OPEN_PARENTHESYS_in_expression1273 = new BitSet(
            new long[] { 0x0000310000081060L });
    public static final BitSet FOLLOW_expression_in_expression1275 = new BitSet(
            new long[] { 0x0000000000000100L });
    public static final BitSet FOLLOW_CLOSED_PARENTHESYS_in_expression1277 = new BitSet(
            new long[] { 0x0000000000000002L });
    public static final BitSet FOLLOW_conjunction_in_disjunction1307 = new BitSet(
            new long[] { 0x0000000000000802L });
    public static final BitSet FOLLOW_OR_in_disjunction1310 = new BitSet(
            new long[] { 0x0000310000081040L });
    public static final BitSet FOLLOW_conjunction_in_disjunction1312 = new BitSet(
            new long[] { 0x0000000000000802L });
    public static final BitSet FOLLOW_unary_in_conjunction1339 = new BitSet(
            new long[] { 0x0000000000000402L });
    public static final BitSet FOLLOW_AND_in_conjunction1342 = new BitSet(
            new long[] { 0x0000310000081040L });
    public static final BitSet FOLLOW_unary_in_conjunction1344 = new BitSet(
            new long[] { 0x0000000000000402L });
    public static final BitSet FOLLOW_INVERSE_in_complexPropertyExpression1365 = new BitSet(
            new long[] { 0x0000000000000020L });
    public static final BitSet FOLLOW_OPEN_PARENTHESYS_in_complexPropertyExpression1367 = new BitSet(
            new long[] { 0x0000300000080000L });
    public static final BitSet FOLLOW_propertyExpression_in_complexPropertyExpression1369 = new BitSet(
            new long[] { 0x0000000000000100L });
    public static final BitSet FOLLOW_CLOSED_PARENTHESYS_in_complexPropertyExpression1371 = new BitSet(
            new long[] { 0x0000000000000002L });
    public static final BitSet FOLLOW_propertyExpression_in_unary1411 = new BitSet(
            new long[] { 0x0000000000000010L });
    public static final BitSet FOLLOW_COMPOSITION_in_unary1414 = new BitSet(
            new long[] { 0x0000300000080000L });
    public static final BitSet FOLLOW_propertyExpression_in_unary1418 = new BitSet(
            new long[] { 0x0000000000000012L });
    public static final BitSet FOLLOW_NOT_in_unary1440 = new BitSet(
            new long[] { 0x0000000000000020L });
    public static final BitSet FOLLOW_OPEN_PARENTHESYS_in_unary1442 = new BitSet(
            new long[] { 0x0000310000081060L });
    public static final BitSet FOLLOW_expression_in_unary1444 = new BitSet(
            new long[] { 0x0000000000000100L });
    public static final BitSet FOLLOW_CLOSED_PARENTHESYS_in_unary1446 = new BitSet(
            new long[] { 0x0000000000000002L });
    public static final BitSet FOLLOW_NOT_in_unary1460 = new BitSet(
            new long[] { 0x0000300000000000L });
    public static final BitSet FOLLOW_atomic_in_unary1462 = new BitSet(
            new long[] { 0x0000000000000002L });
    public static final BitSet FOLLOW_qualifiedRestriction_in_unary1485 = new BitSet(
            new long[] { 0x0000000000000002L });
    public static final BitSet FOLLOW_dataRange_in_unary1497 = new BitSet(
            new long[] { 0x0000000000000002L });
    public static final BitSet FOLLOW_constant_in_unary1503 = new BitSet(
            new long[] { 0x0000000000000002L });
    public static final BitSet FOLLOW_atomic_in_unary1509 = new BitSet(
            new long[] { 0x0000000000000002L });
    public static final BitSet FOLLOW_IDENTIFIER_in_dataRange1526 = new BitSet(
            new long[] { 0x0000000000000000L, 0x0000000000200000L });
    public static final BitSet FOLLOW_OPEN_SQUARE_BRACKET_in_dataRange1528 = new BitSet(
            new long[] { 0x0000000000000000L, 0x0000000000000000L, 0x0000000000000000L,
                    0x0000000000000000L, 0x0000000000000000L, 0x0000000000000000L,
                    0x0000000000000000L, 0x0000007800000000L });
    public static final BitSet FOLLOW_dataRangeFacet_in_dataRange1530 = new BitSet(
            new long[] { 0x0000002000000000L, 0x0000000000400000L });
    public static final BitSet FOLLOW_COMMA_in_dataRange1533 = new BitSet(new long[] {
            0x0000000000000000L, 0x0000000000000000L, 0x0000000000000000L,
            0x0000000000000000L, 0x0000000000000000L, 0x0000000000000000L,
            0x0000000000000000L, 0x0000007800000000L });
    public static final BitSet FOLLOW_dataRangeFacet_in_dataRange1535 = new BitSet(
            new long[] { 0x0000002000000000L, 0x0000000000400000L });
    public static final BitSet FOLLOW_CLOSED_SQUARE_BRACKET_in_dataRange1539 = new BitSet(
            new long[] { 0x0000000000000002L });
    public static final BitSet FOLLOW_LESS_THAN_in_dataRangeFacet1565 = new BitSet(
            new long[] { 0x0000010000000000L });
    public static final BitSet FOLLOW_constant_in_dataRangeFacet1567 = new BitSet(
            new long[] { 0x0000000000000002L });
    public static final BitSet FOLLOW_LESS_THAN_EQUAL_in_dataRangeFacet1581 = new BitSet(
            new long[] { 0x0000010000000000L });
    public static final BitSet FOLLOW_constant_in_dataRangeFacet1583 = new BitSet(
            new long[] { 0x0000000000000002L });
    public static final BitSet FOLLOW_GREATER_THAN_in_dataRangeFacet1598 = new BitSet(
            new long[] { 0x0000010000000000L });
    public static final BitSet FOLLOW_constant_in_dataRangeFacet1600 = new BitSet(
            new long[] { 0x0000000000000002L });
    public static final BitSet FOLLOW_GREATER_THAN_EQUAL_in_dataRangeFacet1614 = new BitSet(
            new long[] { 0x0000010000000000L });
    public static final BitSet FOLLOW_constant_in_dataRangeFacet1616 = new BitSet(
            new long[] { 0x0000000000000002L });
    public static final BitSet FOLLOW_IDENTIFIER_in_atomic1637 = new BitSet(
            new long[] { 0x0000000000000002L });
    public static final BitSet FOLLOW_ENTITY_REFERENCE_in_atomic1644 = new BitSet(
            new long[] { 0x0000000000000002L });
    public static final BitSet FOLLOW_propertyExpression_in_qualifiedRestriction1696 = new BitSet(
            new long[] { 0x0000000000002000L });
    public static final BitSet FOLLOW_SOME_in_qualifiedRestriction1699 = new BitSet(
            new long[] { 0x0000310000081060L });
    public static final BitSet FOLLOW_expression_in_qualifiedRestriction1703 = new BitSet(
            new long[] { 0x0000000000000002L });
    public static final BitSet FOLLOW_propertyExpression_in_qualifiedRestriction1732 = new BitSet(
            new long[] { 0x0000000000004000L });
    public static final BitSet FOLLOW_ONLY_in_qualifiedRestriction1734 = new BitSet(
            new long[] { 0x0000310000081060L });
    public static final BitSet FOLLOW_expression_in_qualifiedRestriction1737 = new BitSet(
            new long[] { 0x0000000000000002L });
    public static final BitSet FOLLOW_cardinalityRestriction_in_qualifiedRestriction1756 = new BitSet(
            new long[] { 0x0000000000000002L });
    public static final BitSet FOLLOW_oneOf_in_qualifiedRestriction1770 = new BitSet(
            new long[] { 0x0000000000000002L });
    public static final BitSet FOLLOW_valueRestriction_in_qualifiedRestriction1784 = new BitSet(
            new long[] { 0x0000000000000002L });
    public static final BitSet FOLLOW_atomic_in_propertyExpression1816 = new BitSet(
            new long[] { 0x0000000000000002L });
    public static final BitSet FOLLOW_complexPropertyExpression_in_propertyExpression1830 = new BitSet(
            new long[] { 0x0000000000000002L });
    public static final BitSet FOLLOW_propertyExpression_in_cardinalityRestriction1872 = new BitSet(
            new long[] { 0x0000000000038000L });
    public static final BitSet FOLLOW_restrictionKind_in_cardinalityRestriction1875 = new BitSet(
            new long[] { 0x0000040000000000L });
    public static final BitSet FOLLOW_INTEGER_in_cardinalityRestriction1877 = new BitSet(
            new long[] { 0x0000310000081042L });
    public static final BitSet FOLLOW_unary_in_cardinalityRestriction1879 = new BitSet(
            new long[] { 0x0000000000000002L });
    public static final BitSet FOLLOW_MIN_in_restrictionKind1912 = new BitSet(
            new long[] { 0x0000000000000002L });
    public static final BitSet FOLLOW_MAX_in_restrictionKind1926 = new BitSet(
            new long[] { 0x0000000000000002L });
    public static final BitSet FOLLOW_EXACTLY_in_restrictionKind1940 = new BitSet(
            new long[] { 0x0000000000000002L });
    public static final BitSet FOLLOW_OPEN_CURLY_BRACES_in_oneOf1962 = new BitSet(
            new long[] { 0x0000300000000000L });
    public static final BitSet FOLLOW_atomic_in_oneOf1964 = new BitSet(
            new long[] { 0x0000002000000080L });
    public static final BitSet FOLLOW_COMMA_in_oneOf1967 = new BitSet(
            new long[] { 0x0000300000000000L });
    public static final BitSet FOLLOW_atomic_in_oneOf1969 = new BitSet(
            new long[] { 0x0000002000000080L });
    public static final BitSet FOLLOW_CLOSED_CURLY_BRACES_in_oneOf1973 = new BitSet(
            new long[] { 0x0000000000000002L });
    public static final BitSet FOLLOW_propertyExpression_in_valueRestriction1993 = new BitSet(
            new long[] { 0x0000000000040000L });
    public static final BitSet FOLLOW_VALUE_in_valueRestriction1995 = new BitSet(
            new long[] { 0x0000310000000000L });
    public static final BitSet FOLLOW_value_in_valueRestriction1997 = new BitSet(
            new long[] { 0x0000000000000002L });
    public static final BitSet FOLLOW_atomic_in_value2022 = new BitSet(
            new long[] { 0x0000000000000002L });
    public static final BitSet FOLLOW_constant_in_value2037 = new BitSet(
            new long[] { 0x0000000000000002L });
    public static final BitSet FOLLOW_DBLQUOTE_in_constant2062 = new BitSet(new long[] {
            0x0000001000000002L, 0x0004000000000000L });
    public static final BitSet FOLLOW_AT_in_constant2065 = new BitSet(
            new long[] { 0x0000100000000000L });
    public static final BitSet FOLLOW_IDENTIFIER_in_constant2071 = new BitSet(
            new long[] { 0x0000001000000002L });
    public static final BitSet FOLLOW_POW_in_constant2077 = new BitSet(
            new long[] { 0x0000100000000000L });
    public static final BitSet FOLLOW_IDENTIFIER_in_constant2083 = new BitSet(
            new long[] { 0x0000000000000002L });
    public static final BitSet FOLLOW_binaryAxiom_in_synpred1_MOWLParser232 = new BitSet(
            new long[] { 0x0000000000000002L });
    public static final BitSet FOLLOW_assertionAxiom_in_synpred3_MOWLParser256 = new BitSet(
            new long[] { 0x0000000000000002L });
    public static final BitSet FOLLOW_hasKeyAxiom_in_synpred4_MOWLParser268 = new BitSet(
            new long[] { 0x0000000000000002L });
    public static final BitSet FOLLOW_expression_in_synpred9_MOWLParser639 = new BitSet(
            new long[] { 0x0000000000100000L });
    public static final BitSet FOLLOW_SUBCLASS_OF_in_synpred9_MOWLParser641 = new BitSet(
            new long[] { 0x0000310000081060L });
    public static final BitSet FOLLOW_expression_in_synpred9_MOWLParser648 = new BitSet(
            new long[] { 0x0000000000000002L });
    public static final BitSet FOLLOW_expression_in_synpred10_MOWLParser686 = new BitSet(
            new long[] { 0x0000000000400000L });
    public static final BitSet FOLLOW_EQUIVALENT_TO_in_synpred10_MOWLParser688 = new BitSet(
            new long[] { 0x0000310000081060L });
    public static final BitSet FOLLOW_expression_in_synpred10_MOWLParser694 = new BitSet(
            new long[] { 0x0000000000000002L });
    public static final BitSet FOLLOW_expression_in_synpred11_MOWLParser731 = new BitSet(
            new long[] { 0x0000000004000000L });
    public static final BitSet FOLLOW_DISJOINT_WITH_in_synpred11_MOWLParser733 = new BitSet(
            new long[] { 0x0000310000081060L });
    public static final BitSet FOLLOW_expression_in_synpred11_MOWLParser739 = new BitSet(
            new long[] { 0x0000000000000002L });
    public static final BitSet FOLLOW_expression_in_synpred12_MOWLParser776 = new BitSet(
            new long[] { 0x0000000000200000L });
    public static final BitSet FOLLOW_SUB_PROPERTY_OF_in_synpred12_MOWLParser778 = new BitSet(
            new long[] { 0x0000300000080000L });
    public static final BitSet FOLLOW_propertyExpression_in_synpred12_MOWLParser784 = new BitSet(
            new long[] { 0x0000000000000002L });
    public static final BitSet FOLLOW_atomic_in_synpred13_MOWLParser821 = new BitSet(
            new long[] { 0x0000000002000000L });
    public static final BitSet FOLLOW_INVERSE_OF_in_synpred13_MOWLParser823 = new BitSet(
            new long[] { 0x0000300000000000L });
    public static final BitSet FOLLOW_atomic_in_synpred13_MOWLParser829 = new BitSet(
            new long[] { 0x0000000000000002L });
    public static final BitSet FOLLOW_atomic_in_synpred14_MOWLParser860 = new BitSet(
            new long[] { 0x0000000000800000L });
    public static final BitSet FOLLOW_SAME_AS_in_synpred14_MOWLParser862 = new BitSet(
            new long[] { 0x0000300000000000L });
    public static final BitSet FOLLOW_atomic_in_synpred14_MOWLParser869 = new BitSet(
            new long[] { 0x0000000000000002L });
    public static final BitSet FOLLOW_atomic_in_synpred15_MOWLParser907 = new BitSet(
            new long[] { 0x0000000001000000L });
    public static final BitSet FOLLOW_DIFFERENT_FROM_in_synpred15_MOWLParser909 = new BitSet(
            new long[] { 0x0000300000000000L });
    public static final BitSet FOLLOW_atomic_in_synpred15_MOWLParser916 = new BitSet(
            new long[] { 0x0000000000000002L });
    public static final BitSet FOLLOW_atomic_in_synpred16_MOWLParser953 = new BitSet(
            new long[] { 0x0000000008000000L });
    public static final BitSet FOLLOW_DOMAIN_in_synpred16_MOWLParser956 = new BitSet(
            new long[] { 0x0000310000081060L });
    public static final BitSet FOLLOW_expression_in_synpred16_MOWLParser958 = new BitSet(
            new long[] { 0x0000000000000002L });
    public static final BitSet FOLLOW_disjunction_in_synpred17_MOWLParser1247 = new BitSet(
            new long[] { 0x0000000000000002L });
    public static final BitSet FOLLOW_complexPropertyExpression_in_synpred18_MOWLParser1260 = new BitSet(
            new long[] { 0x0000000000000002L });
    public static final BitSet FOLLOW_propertyExpression_in_synpred19_MOWLParser1411 = new BitSet(
            new long[] { 0x0000000000000010L });
    public static final BitSet FOLLOW_COMPOSITION_in_synpred19_MOWLParser1414 = new BitSet(
            new long[] { 0x0000300000080000L });
    public static final BitSet FOLLOW_propertyExpression_in_synpred19_MOWLParser1418 = new BitSet(
            new long[] { 0x0000000000000012L });
    public static final BitSet FOLLOW_NOT_in_synpred20_MOWLParser1440 = new BitSet(
            new long[] { 0x0000000000000020L });
    public static final BitSet FOLLOW_OPEN_PARENTHESYS_in_synpred20_MOWLParser1442 = new BitSet(
            new long[] { 0x0000310000081060L });
    public static final BitSet FOLLOW_expression_in_synpred20_MOWLParser1444 = new BitSet(
            new long[] { 0x0000000000000100L });
    public static final BitSet FOLLOW_CLOSED_PARENTHESYS_in_synpred20_MOWLParser1446 = new BitSet(
            new long[] { 0x0000000000000002L });
    public static final BitSet FOLLOW_NOT_in_synpred21_MOWLParser1460 = new BitSet(
            new long[] { 0x0000300000000000L });
    public static final BitSet FOLLOW_atomic_in_synpred21_MOWLParser1462 = new BitSet(
            new long[] { 0x0000000000000002L });
    public static final BitSet FOLLOW_qualifiedRestriction_in_synpred22_MOWLParser1485 = new BitSet(
            new long[] { 0x0000000000000002L });
    public static final BitSet FOLLOW_dataRange_in_synpred23_MOWLParser1497 = new BitSet(
            new long[] { 0x0000000000000002L });
    public static final BitSet FOLLOW_propertyExpression_in_synpred25_MOWLParser1696 = new BitSet(
            new long[] { 0x0000000000002000L });
    public static final BitSet FOLLOW_SOME_in_synpred25_MOWLParser1699 = new BitSet(
            new long[] { 0x0000310000081060L });
    public static final BitSet FOLLOW_expression_in_synpred25_MOWLParser1703 = new BitSet(
            new long[] { 0x0000000000000002L });
    public static final BitSet FOLLOW_propertyExpression_in_synpred26_MOWLParser1732 = new BitSet(
            new long[] { 0x0000000000004000L });
    public static final BitSet FOLLOW_ONLY_in_synpred26_MOWLParser1734 = new BitSet(
            new long[] { 0x0000310000081060L });
    public static final BitSet FOLLOW_expression_in_synpred26_MOWLParser1737 = new BitSet(
            new long[] { 0x0000000000000002L });
    public static final BitSet FOLLOW_cardinalityRestriction_in_synpred27_MOWLParser1756 = new BitSet(
            new long[] { 0x0000000000000002L });
}
