// $ANTLR 3.2 Sep 23, 2009 12:02:23 MOWLParser.g 2010-11-24 13:02:18

  package org.coode.parsers.oppl.patterns;
  import org.coode.parsers.oppl.OPPLSyntaxTree;  
  import org.coode.parsers.ErrorListener;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

import org.antlr.runtime.tree.*;

public class OPPLPatternScript_OPPLParser_MOWLParser extends Parser {
    public static final int COMMA=37;
    public static final int GREATER_THAN=510;
    public static final int ASSERTED=76;
    public static final int VARIABLE_DEFINITIONS=102;
    public static final int REGEXP_CONSTRAINT=465;
    public static final int END=84;
    public static final int HYPHEN=465;
    public static final int DIFFERENT_FROM=24;
    public static final int LESS_THAN=508;
    public static final int TYPE_ASSERTION=66;
    public static final int SAME_AS_AXIOM=52;
    public static final int TYPES=39;
    public static final int ROLE_ASSERTION=67;
    public static final int CREATE_OPPL_FUNCTION=98;
    public static final int ESCLAMATION_MARK=149;
    public static final int VARIABLE_IDENTIFIER=106;
    public static final int ASSERTED_CLAUSE=92;
    public static final int DOT=78;
    public static final int ALL_RESTRICTION=62;
    public static final int QUESTION_MARK=46;
    public static final int PLAIN_IDENTIFIER=152;
    public static final int AND=10;
    public static final int EXPRESSION=69;
    public static final int CONSTANT=70;
    public static final int VALUE_RESTRICTION=63;
    public static final int ONE_OF=65;
    public static final int SUBPROPERTY_OF=105;
    public static final int THIS_CLASS=416;
    public static final int SELECT=75;
    public static final int CARDINALITY_RESTRICTION=64;
    public static final int SAME_AS=23;
    public static final int EXACTLY=17;
    public static final int PLUS=79;
    public static final int TRANSITIVE=34;
    public static final int IN_SET_CONSTRAINT=95;
    public static final int SUBCLASS_OF=20;
    public static final int ENTITY_REFERENCE=45;
    public static final int CONJUNCTION=56;
    public static final int INVERSE_OF=25;
    public static final int RANGE=28;
    public static final int ARGUMENTS=417;
    public static final int DATA_RANGE=568;
    public static final int CLOSED_PARENTHESYS=8;
    public static final int PROPERTY_CHAIN=57;
    public static final int CREATE_INTERSECTION=81;
    public static final int EQUIVALENT_TO_AXIOM=49;
    public static final int OPEN_SQUARE_BRACKET=85;
    public static final int NAF_CONSTRAINT=467;
    public static final int SYMMETRIC=30;
    public static final int DOLLAR=400;
    public static final int DISJOINT_WITH=26;
    public static final int VARIABLE_TYPE=89;
    public static final int DISJUNCTION=55;
    public static final int GROUPS=356;
    public static final int NEGATED_EXPRESSION=58;
    public static final int EQUAL=73;
    public static final int SEMICOLON=422;
    public static final int PATTERN_REFERENCE=421;
    public static final int DIFFERENT_FROM_AXIOM=53;
    public static final int GREATER_THAN_EQUAL=511;
    public static final int ACTIONS=101;
    public static final int EQUIVALENT_TO=22;
    public static final int DOMAIN=27;
    public static final int SUB_PROPERTY_OF=21;
    public static final int INVERSE_OBJECT_PROPERTY_EXPRESSION=68;
    public static final int INVERSE_PROPERTY=60;
    public static final int COLON=77;
    public static final int GENERATED_VARIABLE_DEFINITION=97;
    public static final int VARIABLE_ATTRIBUTE=99;
    public static final int SUB_CLASS_AXIOM=48;
    public static final int SUB_PROPERTY_AXIOM=51;
    public static final int IDENTIFIER=44;
    public static final int UNARY_AXIOM=54;
    public static final int ADD=90;
    public static final int WHERE=71;
    public static final int CREATE=80;
    public static final int VARIABLE_SCOPE=104;
    public static final int OPEN_CURLY_BRACES=6;
    public static final int CLOSED_SQUARE_BRACKET=86;
    public static final int INSTANCE_OF=38;
    public static final int VALUES=354;
    public static final int QUERY=103;
    public static final int SOME_RESTRICTION=61;
    public static final int IRI=110;
    public static final int LESS_THAN_EQUAL=509;
    public static final int VALUE=18;
    public static final int RENDERING=355;
    public static final int INVERSE_FUNCTIONAL=35;
    public static final int ATTRIBUTE_SELECTOR=283;
    public static final int PLAIN_CLAUSE=93;
    public static final int OR=11;
    public static final int INTEGER=42;
    public static final int INVERSE=19;
    public static final int HAS_KEY=109;
    public static final int DISJOINT_WITH_AXIOM=50;
    public static final int SUPER_CLASS_OF=87;
    public static final int OPPL_FUNCTION=100;
    public static final int DIGIT=41;
    public static final int COMPOSITION=4;
    public static final int ANNOTATION_ASSERTION=111;
    public static final int OPPL_STATEMENT=107;
    public static final int FUNCTIONAL=29;
    public static final int NOT_EQUAL=72;
    public static final int LETTER=43;
    public static final int MAX=16;
    public static final int FAIL=466;
    public static final int NEGATED_ASSERTION=59;
    public static final int INPUT_VARIABLE_DEFINITION=96;
    public static final int ONLY=14;
    public static final int CREATE_DISJUNCTION=82;
    public static final int REMOVE=91;
    public static final int DBLQUOTE=40;
    public static final int MIN=15;
    public static final int POW=36;
    public static final int MATCH=176;
    public static final int BEGIN=83;
    public static final int OPPL_PATTERN=419;
    public static final int WHITESPACE=9;
    public static final int IN=74;
    public static final int SUPER_PROPERTY_OF=88;
    public static final int INEQUALITY_CONSTRAINT=94;
    public static final int SOME=13;
    public static final int RETURN=415;
    public static final int EOF=-1;
    public static final int CREATE_IDENTIFIER=151;
    public static final int ANTI_SYMMETRIC=31;
    public static final int Tokens=47;
    public static final int CLOSED_CURLY_BRACES=7;
    public static final int IRI_ATTRIBUTE_NAME=112;
    public static final int REFLEXIVE=32;
    public static final int NOT=12;
    public static final int STRING_OPERATION=394;
    public static final int OPEN_PARENTHESYS=5;
    public static final int VARIABLE_NAME=464;
    public static final int IRREFLEXIVE=33;

    // delegates
    // delegators
    public OPPLPatternScriptParser gOPPLPatternScript;
    public OPPLPatternScript_OPPLParser gOPPLParser;
    public OPPLPatternScript_OPPLParser gParent;


        public OPPLPatternScript_OPPLParser_MOWLParser(TokenStream input, OPPLPatternScriptParser gOPPLPatternScript, OPPLPatternScript_OPPLParser gOPPLParser) {
            this(input, new RecognizerSharedState(), gOPPLPatternScript, gOPPLParser);
        }
        public OPPLPatternScript_OPPLParser_MOWLParser(TokenStream input, RecognizerSharedState state, OPPLPatternScriptParser gOPPLPatternScript, OPPLPatternScript_OPPLParser gOPPLParser) {
            super(input, state);
            this.gOPPLPatternScript = gOPPLPatternScript;
            this.gOPPLParser = gOPPLParser;
             
            gParent = gOPPLParser;
        }
        
    protected TreeAdaptor adaptor = new CommonTreeAdaptor();

    public void setTreeAdaptor(TreeAdaptor adaptor) {
        this.adaptor = adaptor;
    }
    public TreeAdaptor getTreeAdaptor() {
        return adaptor;
    }

    public String[] getTokenNames() { return OPPLPatternScriptParser.tokenNames; }
    public String getGrammarFileName() { return "MOWLParser.g"; }


    public void displayRecognitionError(String[] tokenNames,
    										RecognitionException e){
    	}
    	


    public static class axiom_return extends ParserRuleReturnScope {
        OPPLSyntaxTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "axiom"
    // MOWLParser.g:64:1: axiom options {backtrack=true; } : ( binaryAxiom -> ^( binaryAxiom ) | unaryAxiom -> ^( unaryAxiom ) | assertionAxiom -> ^( assertionAxiom ) | hasKeyAxiom -> ^( hasKeyAxiom ) | annotationAssertionAxiom -> ^( annotationAssertionAxiom ) );
    public final OPPLPatternScript_OPPLParser_MOWLParser.axiom_return axiom() throws RecognitionException {
        OPPLPatternScript_OPPLParser_MOWLParser.axiom_return retval = new OPPLPatternScript_OPPLParser_MOWLParser.axiom_return();
        retval.start = input.LT(1);

        OPPLSyntaxTree root_0 = null;

        OPPLPatternScript_OPPLParser_MOWLParser.binaryAxiom_return binaryAxiom1 = null;

        OPPLPatternScript_OPPLParser_MOWLParser.unaryAxiom_return unaryAxiom2 = null;

        OPPLPatternScript_OPPLParser_MOWLParser.assertionAxiom_return assertionAxiom3 = null;

        OPPLPatternScript_OPPLParser_MOWLParser.hasKeyAxiom_return hasKeyAxiom4 = null;

        OPPLPatternScript_OPPLParser_MOWLParser.annotationAssertionAxiom_return annotationAssertionAxiom5 = null;


        RewriteRuleSubtreeStream stream_assertionAxiom=new RewriteRuleSubtreeStream(adaptor,"rule assertionAxiom");
        RewriteRuleSubtreeStream stream_binaryAxiom=new RewriteRuleSubtreeStream(adaptor,"rule binaryAxiom");
        RewriteRuleSubtreeStream stream_hasKeyAxiom=new RewriteRuleSubtreeStream(adaptor,"rule hasKeyAxiom");
        RewriteRuleSubtreeStream stream_annotationAssertionAxiom=new RewriteRuleSubtreeStream(adaptor,"rule annotationAssertionAxiom");
        RewriteRuleSubtreeStream stream_unaryAxiom=new RewriteRuleSubtreeStream(adaptor,"rule unaryAxiom");
        try {
            // MOWLParser.g:64:37: ( binaryAxiom -> ^( binaryAxiom ) | unaryAxiom -> ^( unaryAxiom ) | assertionAxiom -> ^( assertionAxiom ) | hasKeyAxiom -> ^( hasKeyAxiom ) | annotationAssertionAxiom -> ^( annotationAssertionAxiom ) )
            int alt1=5;
            alt1 = dfa1.predict(input);
            switch (alt1) {
                case 1 :
                    // MOWLParser.g:65:3: binaryAxiom
                    {
                    pushFollow(FOLLOW_binaryAxiom_in_axiom232);
                    binaryAxiom1=binaryAxiom();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_binaryAxiom.add(binaryAxiom1.getTree());


                    // AST REWRITE
                    // elements: binaryAxiom
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (OPPLSyntaxTree)adaptor.nil();
                    // 65:15: -> ^( binaryAxiom )
                    {
                        // MOWLParser.g:65:18: ^( binaryAxiom )
                        {
                        OPPLSyntaxTree root_1 = (OPPLSyntaxTree)adaptor.nil();
                        root_1 = (OPPLSyntaxTree)adaptor.becomeRoot(stream_binaryAxiom.nextNode(), root_1);

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 2 :
                    // MOWLParser.g:66:5: unaryAxiom
                    {
                    pushFollow(FOLLOW_unaryAxiom_in_axiom244);
                    unaryAxiom2=unaryAxiom();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_unaryAxiom.add(unaryAxiom2.getTree());


                    // AST REWRITE
                    // elements: unaryAxiom
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (OPPLSyntaxTree)adaptor.nil();
                    // 66:16: -> ^( unaryAxiom )
                    {
                        // MOWLParser.g:66:19: ^( unaryAxiom )
                        {
                        OPPLSyntaxTree root_1 = (OPPLSyntaxTree)adaptor.nil();
                        root_1 = (OPPLSyntaxTree)adaptor.becomeRoot(stream_unaryAxiom.nextNode(), root_1);

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 3 :
                    // MOWLParser.g:67:5: assertionAxiom
                    {
                    pushFollow(FOLLOW_assertionAxiom_in_axiom256);
                    assertionAxiom3=assertionAxiom();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_assertionAxiom.add(assertionAxiom3.getTree());


                    // AST REWRITE
                    // elements: assertionAxiom
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (OPPLSyntaxTree)adaptor.nil();
                    // 67:20: -> ^( assertionAxiom )
                    {
                        // MOWLParser.g:67:23: ^( assertionAxiom )
                        {
                        OPPLSyntaxTree root_1 = (OPPLSyntaxTree)adaptor.nil();
                        root_1 = (OPPLSyntaxTree)adaptor.becomeRoot(stream_assertionAxiom.nextNode(), root_1);

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 4 :
                    // MOWLParser.g:68:5: hasKeyAxiom
                    {
                    pushFollow(FOLLOW_hasKeyAxiom_in_axiom268);
                    hasKeyAxiom4=hasKeyAxiom();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_hasKeyAxiom.add(hasKeyAxiom4.getTree());


                    // AST REWRITE
                    // elements: hasKeyAxiom
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (OPPLSyntaxTree)adaptor.nil();
                    // 68:17: -> ^( hasKeyAxiom )
                    {
                        // MOWLParser.g:68:19: ^( hasKeyAxiom )
                        {
                        OPPLSyntaxTree root_1 = (OPPLSyntaxTree)adaptor.nil();
                        root_1 = (OPPLSyntaxTree)adaptor.becomeRoot(stream_hasKeyAxiom.nextNode(), root_1);

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 5 :
                    // MOWLParser.g:69:5: annotationAssertionAxiom
                    {
                    pushFollow(FOLLOW_annotationAssertionAxiom_in_axiom279);
                    annotationAssertionAxiom5=annotationAssertionAxiom();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_annotationAssertionAxiom.add(annotationAssertionAxiom5.getTree());


                    // AST REWRITE
                    // elements: annotationAssertionAxiom
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (OPPLSyntaxTree)adaptor.nil();
                    // 69:30: -> ^( annotationAssertionAxiom )
                    {
                        // MOWLParser.g:69:32: ^( annotationAssertionAxiom )
                        {
                        OPPLSyntaxTree root_1 = (OPPLSyntaxTree)adaptor.nil();
                        root_1 = (OPPLSyntaxTree)adaptor.becomeRoot(stream_annotationAssertionAxiom.nextNode(), root_1);

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (OPPLSyntaxTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

          catch(RecognitionException e){
            throw e;
          }
          
          catch(RewriteEmptyStreamException e){
            throw e;
          }
        finally {
        }
        return retval;
    }
    // $ANTLR end "axiom"

    public static class annotationAssertionAxiom_return extends ParserRuleReturnScope {
        OPPLSyntaxTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "annotationAssertionAxiom"
    // MOWLParser.g:72:1: annotationAssertionAxiom options {backtrack=true; } : ( iri p= atomic o= constant -> ^( ANNOTATION_ASSERTION iri ^( EXPRESSION $p) ^( EXPRESSION $o) ) | subjectIRI= iri p= atomic objectIRI= iri -> ^( ANNOTATION_ASSERTION $subjectIRI ^( EXPRESSION $p) ^( EXPRESSION $objectIRI) ) );
    public final OPPLPatternScript_OPPLParser_MOWLParser.annotationAssertionAxiom_return annotationAssertionAxiom() throws RecognitionException {
        OPPLPatternScript_OPPLParser_MOWLParser.annotationAssertionAxiom_return retval = new OPPLPatternScript_OPPLParser_MOWLParser.annotationAssertionAxiom_return();
        retval.start = input.LT(1);

        OPPLSyntaxTree root_0 = null;

        OPPLPatternScriptParser.atomic_return p = null;

        OPPLPatternScript_OPPLParser_MOWLParser.constant_return o = null;

        OPPLPatternScript_OPPLParser.iri_return subjectIRI = null;

        OPPLPatternScript_OPPLParser.iri_return objectIRI = null;

        OPPLPatternScript_OPPLParser.iri_return iri6 = null;


        RewriteRuleSubtreeStream stream_iri=new RewriteRuleSubtreeStream(adaptor,"rule iri");
        RewriteRuleSubtreeStream stream_atomic=new RewriteRuleSubtreeStream(adaptor,"rule atomic");
        RewriteRuleSubtreeStream stream_constant=new RewriteRuleSubtreeStream(adaptor,"rule constant");
        try {
            // MOWLParser.g:73:32: ( iri p= atomic o= constant -> ^( ANNOTATION_ASSERTION iri ^( EXPRESSION $p) ^( EXPRESSION $o) ) | subjectIRI= iri p= atomic objectIRI= iri -> ^( ANNOTATION_ASSERTION $subjectIRI ^( EXPRESSION $p) ^( EXPRESSION $objectIRI) ) )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==IRI) ) {
                int LA2_1 = input.LA(2);

                if ( (synpred5_MOWLParser()) ) {
                    alt2=1;
                }
                else if ( (true) ) {
                    alt2=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 2, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA2_0==VARIABLE_NAME) ) {
                int LA2_2 = input.LA(2);

                if ( (synpred5_MOWLParser()) ) {
                    alt2=1;
                }
                else if ( (true) ) {
                    alt2=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 2, 2, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // MOWLParser.g:74:3: iri p= atomic o= constant
                    {
                    pushFollow(FOLLOW_iri_in_annotationAssertionAxiom311);
                    iri6=gOPPLParser.iri();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_iri.add(iri6.getTree());
                    pushFollow(FOLLOW_atomic_in_annotationAssertionAxiom316);
                    p=gOPPLPatternScript.atomic();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_atomic.add(p.getTree());
                    pushFollow(FOLLOW_constant_in_annotationAssertionAxiom322);
                    o=constant();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_constant.add(o.getTree());


                    // AST REWRITE
                    // elements: iri, o, p
                    // token labels: 
                    // rule labels: o, p, retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_o=new RewriteRuleSubtreeStream(adaptor,"rule o",o!=null?o.tree:null);
                    RewriteRuleSubtreeStream stream_p=new RewriteRuleSubtreeStream(adaptor,"rule p",p!=null?p.tree:null);
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (OPPLSyntaxTree)adaptor.nil();
                    // 74:30: -> ^( ANNOTATION_ASSERTION iri ^( EXPRESSION $p) ^( EXPRESSION $o) )
                    {
                        // MOWLParser.g:74:33: ^( ANNOTATION_ASSERTION iri ^( EXPRESSION $p) ^( EXPRESSION $o) )
                        {
                        OPPLSyntaxTree root_1 = (OPPLSyntaxTree)adaptor.nil();
                        root_1 = (OPPLSyntaxTree)adaptor.becomeRoot((OPPLSyntaxTree)adaptor.create(ANNOTATION_ASSERTION, "ANNOTATION_ASSERTION"), root_1);

                        adaptor.addChild(root_1, stream_iri.nextTree());
                        // MOWLParser.g:74:60: ^( EXPRESSION $p)
                        {
                        OPPLSyntaxTree root_2 = (OPPLSyntaxTree)adaptor.nil();
                        root_2 = (OPPLSyntaxTree)adaptor.becomeRoot((OPPLSyntaxTree)adaptor.create(EXPRESSION, "EXPRESSION"), root_2);

                        adaptor.addChild(root_2, stream_p.nextTree());

                        adaptor.addChild(root_1, root_2);
                        }
                        // MOWLParser.g:74:77: ^( EXPRESSION $o)
                        {
                        OPPLSyntaxTree root_2 = (OPPLSyntaxTree)adaptor.nil();
                        root_2 = (OPPLSyntaxTree)adaptor.becomeRoot((OPPLSyntaxTree)adaptor.create(EXPRESSION, "EXPRESSION"), root_2);

                        adaptor.addChild(root_2, stream_o.nextTree());

                        adaptor.addChild(root_1, root_2);
                        }

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 2 :
                    // MOWLParser.g:75:5: subjectIRI= iri p= atomic objectIRI= iri
                    {
                    pushFollow(FOLLOW_iri_in_annotationAssertionAxiom354);
                    subjectIRI=gOPPLParser.iri();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_iri.add(subjectIRI.getTree());
                    pushFollow(FOLLOW_atomic_in_annotationAssertionAxiom359);
                    p=gOPPLPatternScript.atomic();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_atomic.add(p.getTree());
                    pushFollow(FOLLOW_iri_in_annotationAssertionAxiom365);
                    objectIRI=gOPPLParser.iri();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_iri.add(objectIRI.getTree());


                    // AST REWRITE
                    // elements: objectIRI, p, subjectIRI
                    // token labels: 
                    // rule labels: subjectIRI, objectIRI, p, retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_subjectIRI=new RewriteRuleSubtreeStream(adaptor,"rule subjectIRI",subjectIRI!=null?subjectIRI.tree:null);
                    RewriteRuleSubtreeStream stream_objectIRI=new RewriteRuleSubtreeStream(adaptor,"rule objectIRI",objectIRI!=null?objectIRI.tree:null);
                    RewriteRuleSubtreeStream stream_p=new RewriteRuleSubtreeStream(adaptor,"rule p",p!=null?p.tree:null);
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (OPPLSyntaxTree)adaptor.nil();
                    // 75:48: -> ^( ANNOTATION_ASSERTION $subjectIRI ^( EXPRESSION $p) ^( EXPRESSION $objectIRI) )
                    {
                        // MOWLParser.g:75:51: ^( ANNOTATION_ASSERTION $subjectIRI ^( EXPRESSION $p) ^( EXPRESSION $objectIRI) )
                        {
                        OPPLSyntaxTree root_1 = (OPPLSyntaxTree)adaptor.nil();
                        root_1 = (OPPLSyntaxTree)adaptor.becomeRoot((OPPLSyntaxTree)adaptor.create(ANNOTATION_ASSERTION, "ANNOTATION_ASSERTION"), root_1);

                        adaptor.addChild(root_1, stream_subjectIRI.nextTree());
                        // MOWLParser.g:75:86: ^( EXPRESSION $p)
                        {
                        OPPLSyntaxTree root_2 = (OPPLSyntaxTree)adaptor.nil();
                        root_2 = (OPPLSyntaxTree)adaptor.becomeRoot((OPPLSyntaxTree)adaptor.create(EXPRESSION, "EXPRESSION"), root_2);

                        adaptor.addChild(root_2, stream_p.nextTree());

                        adaptor.addChild(root_1, root_2);
                        }
                        // MOWLParser.g:75:103: ^( EXPRESSION $objectIRI)
                        {
                        OPPLSyntaxTree root_2 = (OPPLSyntaxTree)adaptor.nil();
                        root_2 = (OPPLSyntaxTree)adaptor.becomeRoot((OPPLSyntaxTree)adaptor.create(EXPRESSION, "EXPRESSION"), root_2);

                        adaptor.addChild(root_2, stream_objectIRI.nextTree());

                        adaptor.addChild(root_1, root_2);
                        }

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (OPPLSyntaxTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

          catch(RecognitionException e){
            throw e;
          }
          
          catch(RewriteEmptyStreamException e){
            throw e;
          }
        finally {
        }
        return retval;
    }
    // $ANTLR end "annotationAssertionAxiom"

    public static class hasKeyAxiom_return extends ParserRuleReturnScope {
        OPPLSyntaxTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "hasKeyAxiom"
    // MOWLParser.g:84:1: hasKeyAxiom : exp= expression HAS_KEY propertyExpression ( COMMA propertyExpression )* -> ^( HAS_KEY ^( EXPRESSION $exp) ( ^( EXPRESSION propertyExpression ) )+ ) ;
    public final OPPLPatternScript_OPPLParser_MOWLParser.hasKeyAxiom_return hasKeyAxiom() throws RecognitionException {
        OPPLPatternScript_OPPLParser_MOWLParser.hasKeyAxiom_return retval = new OPPLPatternScript_OPPLParser_MOWLParser.hasKeyAxiom_return();
        retval.start = input.LT(1);

        OPPLSyntaxTree root_0 = null;

        Token HAS_KEY7=null;
        Token COMMA9=null;
        OPPLPatternScript_OPPLParser_MOWLParser.expression_return exp = null;

        OPPLPatternScript_OPPLParser_MOWLParser.propertyExpression_return propertyExpression8 = null;

        OPPLPatternScript_OPPLParser_MOWLParser.propertyExpression_return propertyExpression10 = null;


        OPPLSyntaxTree HAS_KEY7_tree=null;
        OPPLSyntaxTree COMMA9_tree=null;
        RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
        RewriteRuleTokenStream stream_HAS_KEY=new RewriteRuleTokenStream(adaptor,"token HAS_KEY");
        RewriteRuleSubtreeStream stream_propertyExpression=new RewriteRuleSubtreeStream(adaptor,"rule propertyExpression");
        RewriteRuleSubtreeStream stream_expression=new RewriteRuleSubtreeStream(adaptor,"rule expression");
        try {
            // MOWLParser.g:85:2: (exp= expression HAS_KEY propertyExpression ( COMMA propertyExpression )* -> ^( HAS_KEY ^( EXPRESSION $exp) ( ^( EXPRESSION propertyExpression ) )+ ) )
            // MOWLParser.g:86:3: exp= expression HAS_KEY propertyExpression ( COMMA propertyExpression )*
            {
            pushFollow(FOLLOW_expression_in_hasKeyAxiom422);
            exp=expression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_expression.add(exp.getTree());
            HAS_KEY7=(Token)match(input,HAS_KEY,FOLLOW_HAS_KEY_in_hasKeyAxiom424); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_HAS_KEY.add(HAS_KEY7);

            pushFollow(FOLLOW_propertyExpression_in_hasKeyAxiom426);
            propertyExpression8=propertyExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_propertyExpression.add(propertyExpression8.getTree());
            // MOWLParser.g:86:47: ( COMMA propertyExpression )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==COMMA) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // MOWLParser.g:86:48: COMMA propertyExpression
            	    {
            	    COMMA9=(Token)match(input,COMMA,FOLLOW_COMMA_in_hasKeyAxiom429); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_COMMA.add(COMMA9);

            	    pushFollow(FOLLOW_propertyExpression_in_hasKeyAxiom431);
            	    propertyExpression10=propertyExpression();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_propertyExpression.add(propertyExpression10.getTree());

            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);



            // AST REWRITE
            // elements: HAS_KEY, exp, propertyExpression
            // token labels: 
            // rule labels: exp, retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_exp=new RewriteRuleSubtreeStream(adaptor,"rule exp",exp!=null?exp.tree:null);
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (OPPLSyntaxTree)adaptor.nil();
            // 86:75: -> ^( HAS_KEY ^( EXPRESSION $exp) ( ^( EXPRESSION propertyExpression ) )+ )
            {
                // MOWLParser.g:86:78: ^( HAS_KEY ^( EXPRESSION $exp) ( ^( EXPRESSION propertyExpression ) )+ )
                {
                OPPLSyntaxTree root_1 = (OPPLSyntaxTree)adaptor.nil();
                root_1 = (OPPLSyntaxTree)adaptor.becomeRoot(stream_HAS_KEY.nextNode(), root_1);

                // MOWLParser.g:86:88: ^( EXPRESSION $exp)
                {
                OPPLSyntaxTree root_2 = (OPPLSyntaxTree)adaptor.nil();
                root_2 = (OPPLSyntaxTree)adaptor.becomeRoot((OPPLSyntaxTree)adaptor.create(EXPRESSION, "EXPRESSION"), root_2);

                adaptor.addChild(root_2, stream_exp.nextTree());

                adaptor.addChild(root_1, root_2);
                }
                if ( !(stream_propertyExpression.hasNext()) ) {
                    throw new RewriteEarlyExitException();
                }
                while ( stream_propertyExpression.hasNext() ) {
                    // MOWLParser.g:86:108: ^( EXPRESSION propertyExpression )
                    {
                    OPPLSyntaxTree root_2 = (OPPLSyntaxTree)adaptor.nil();
                    root_2 = (OPPLSyntaxTree)adaptor.becomeRoot((OPPLSyntaxTree)adaptor.create(EXPRESSION, "EXPRESSION"), root_2);

                    adaptor.addChild(root_2, stream_propertyExpression.nextTree());

                    adaptor.addChild(root_1, root_2);
                    }

                }
                stream_propertyExpression.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (OPPLSyntaxTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

          catch(RecognitionException e){
            throw e;
          }
          
          catch(RewriteEmptyStreamException e){
            throw e;
          }
        finally {
        }
        return retval;
    }
    // $ANTLR end "hasKeyAxiom"

    public static class assertionAxiom_return extends ParserRuleReturnScope {
        OPPLSyntaxTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "assertionAxiom"
    // MOWLParser.g:91:1: assertionAxiom options {backtrack=true; } : (i= atomic ( INSTANCE_OF | TYPES ) expression -> ^( TYPE_ASSERTION ^( EXPRESSION expression ) ^( EXPRESSION $i) ) | subject= atomic propertyExpression value -> ^( ROLE_ASSERTION ^( EXPRESSION $subject) ^( EXPRESSION propertyExpression ) ^( EXPRESSION value ) ) | NOT assertionAxiom -> ^( NEGATED_ASSERTION assertionAxiom ) );
    public final OPPLPatternScript_OPPLParser_MOWLParser.assertionAxiom_return assertionAxiom() throws RecognitionException {
        OPPLPatternScript_OPPLParser_MOWLParser.assertionAxiom_return retval = new OPPLPatternScript_OPPLParser_MOWLParser.assertionAxiom_return();
        retval.start = input.LT(1);

        OPPLSyntaxTree root_0 = null;

        Token INSTANCE_OF11=null;
        Token TYPES12=null;
        Token NOT16=null;
        OPPLPatternScriptParser.atomic_return i = null;

        OPPLPatternScriptParser.atomic_return subject = null;

        OPPLPatternScript_OPPLParser_MOWLParser.expression_return expression13 = null;

        OPPLPatternScript_OPPLParser_MOWLParser.propertyExpression_return propertyExpression14 = null;

        OPPLPatternScript_OPPLParser_MOWLParser.value_return value15 = null;

        OPPLPatternScript_OPPLParser_MOWLParser.assertionAxiom_return assertionAxiom17 = null;


        OPPLSyntaxTree INSTANCE_OF11_tree=null;
        OPPLSyntaxTree TYPES12_tree=null;
        OPPLSyntaxTree NOT16_tree=null;
        RewriteRuleTokenStream stream_TYPES=new RewriteRuleTokenStream(adaptor,"token TYPES");
        RewriteRuleTokenStream stream_NOT=new RewriteRuleTokenStream(adaptor,"token NOT");
        RewriteRuleTokenStream stream_INSTANCE_OF=new RewriteRuleTokenStream(adaptor,"token INSTANCE_OF");
        RewriteRuleSubtreeStream stream_propertyExpression=new RewriteRuleSubtreeStream(adaptor,"rule propertyExpression");
        RewriteRuleSubtreeStream stream_value=new RewriteRuleSubtreeStream(adaptor,"rule value");
        RewriteRuleSubtreeStream stream_assertionAxiom=new RewriteRuleSubtreeStream(adaptor,"rule assertionAxiom");
        RewriteRuleSubtreeStream stream_atomic=new RewriteRuleSubtreeStream(adaptor,"rule atomic");
        RewriteRuleSubtreeStream stream_expression=new RewriteRuleSubtreeStream(adaptor,"rule expression");
        try {
            // MOWLParser.g:91:41: (i= atomic ( INSTANCE_OF | TYPES ) expression -> ^( TYPE_ASSERTION ^( EXPRESSION expression ) ^( EXPRESSION $i) ) | subject= atomic propertyExpression value -> ^( ROLE_ASSERTION ^( EXPRESSION $subject) ^( EXPRESSION propertyExpression ) ^( EXPRESSION value ) ) | NOT assertionAxiom -> ^( NEGATED_ASSERTION assertionAxiom ) )
            int alt5=3;
            alt5 = dfa5.predict(input);
            switch (alt5) {
                case 1 :
                    // MOWLParser.g:92:3: i= atomic ( INSTANCE_OF | TYPES ) expression
                    {
                    pushFollow(FOLLOW_atomic_in_assertionAxiom479);
                    i=gOPPLPatternScript.atomic();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_atomic.add(i.getTree());
                    // MOWLParser.g:92:14: ( INSTANCE_OF | TYPES )
                    int alt4=2;
                    int LA4_0 = input.LA(1);

                    if ( (LA4_0==INSTANCE_OF) ) {
                        alt4=1;
                    }
                    else if ( (LA4_0==TYPES) ) {
                        alt4=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 4, 0, input);

                        throw nvae;
                    }
                    switch (alt4) {
                        case 1 :
                            // MOWLParser.g:92:15: INSTANCE_OF
                            {
                            INSTANCE_OF11=(Token)match(input,INSTANCE_OF,FOLLOW_INSTANCE_OF_in_assertionAxiom482); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_INSTANCE_OF.add(INSTANCE_OF11);


                            }
                            break;
                        case 2 :
                            // MOWLParser.g:92:29: TYPES
                            {
                            TYPES12=(Token)match(input,TYPES,FOLLOW_TYPES_in_assertionAxiom486); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_TYPES.add(TYPES12);


                            }
                            break;

                    }

                    pushFollow(FOLLOW_expression_in_assertionAxiom489);
                    expression13=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_expression.add(expression13.getTree());


                    // AST REWRITE
                    // elements: expression, i
                    // token labels: 
                    // rule labels: i, retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_i=new RewriteRuleSubtreeStream(adaptor,"rule i",i!=null?i.tree:null);
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (OPPLSyntaxTree)adaptor.nil();
                    // 92:47: -> ^( TYPE_ASSERTION ^( EXPRESSION expression ) ^( EXPRESSION $i) )
                    {
                        // MOWLParser.g:92:50: ^( TYPE_ASSERTION ^( EXPRESSION expression ) ^( EXPRESSION $i) )
                        {
                        OPPLSyntaxTree root_1 = (OPPLSyntaxTree)adaptor.nil();
                        root_1 = (OPPLSyntaxTree)adaptor.becomeRoot((OPPLSyntaxTree)adaptor.create(TYPE_ASSERTION, "TYPE_ASSERTION"), root_1);

                        // MOWLParser.g:92:67: ^( EXPRESSION expression )
                        {
                        OPPLSyntaxTree root_2 = (OPPLSyntaxTree)adaptor.nil();
                        root_2 = (OPPLSyntaxTree)adaptor.becomeRoot((OPPLSyntaxTree)adaptor.create(EXPRESSION, "EXPRESSION"), root_2);

                        adaptor.addChild(root_2, stream_expression.nextTree());

                        adaptor.addChild(root_1, root_2);
                        }
                        // MOWLParser.g:92:92: ^( EXPRESSION $i)
                        {
                        OPPLSyntaxTree root_2 = (OPPLSyntaxTree)adaptor.nil();
                        root_2 = (OPPLSyntaxTree)adaptor.becomeRoot((OPPLSyntaxTree)adaptor.create(EXPRESSION, "EXPRESSION"), root_2);

                        adaptor.addChild(root_2, stream_i.nextTree());

                        adaptor.addChild(root_1, root_2);
                        }

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 2 :
                    // MOWLParser.g:93:7: subject= atomic propertyExpression value
                    {
                    pushFollow(FOLLOW_atomic_in_assertionAxiom520);
                    subject=gOPPLPatternScript.atomic();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_atomic.add(subject.getTree());
                    pushFollow(FOLLOW_propertyExpression_in_assertionAxiom522);
                    propertyExpression14=propertyExpression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_propertyExpression.add(propertyExpression14.getTree());
                    pushFollow(FOLLOW_value_in_assertionAxiom525);
                    value15=value();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_value.add(value15.getTree());


                    // AST REWRITE
                    // elements: value, propertyExpression, subject
                    // token labels: 
                    // rule labels: retval, subject
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
                    RewriteRuleSubtreeStream stream_subject=new RewriteRuleSubtreeStream(adaptor,"rule subject",subject!=null?subject.tree:null);

                    root_0 = (OPPLSyntaxTree)adaptor.nil();
                    // 93:50: -> ^( ROLE_ASSERTION ^( EXPRESSION $subject) ^( EXPRESSION propertyExpression ) ^( EXPRESSION value ) )
                    {
                        // MOWLParser.g:93:53: ^( ROLE_ASSERTION ^( EXPRESSION $subject) ^( EXPRESSION propertyExpression ) ^( EXPRESSION value ) )
                        {
                        OPPLSyntaxTree root_1 = (OPPLSyntaxTree)adaptor.nil();
                        root_1 = (OPPLSyntaxTree)adaptor.becomeRoot((OPPLSyntaxTree)adaptor.create(ROLE_ASSERTION, "ROLE_ASSERTION"), root_1);

                        // MOWLParser.g:93:70: ^( EXPRESSION $subject)
                        {
                        OPPLSyntaxTree root_2 = (OPPLSyntaxTree)adaptor.nil();
                        root_2 = (OPPLSyntaxTree)adaptor.becomeRoot((OPPLSyntaxTree)adaptor.create(EXPRESSION, "EXPRESSION"), root_2);

                        adaptor.addChild(root_2, stream_subject.nextTree());

                        adaptor.addChild(root_1, root_2);
                        }
                        // MOWLParser.g:93:93: ^( EXPRESSION propertyExpression )
                        {
                        OPPLSyntaxTree root_2 = (OPPLSyntaxTree)adaptor.nil();
                        root_2 = (OPPLSyntaxTree)adaptor.becomeRoot((OPPLSyntaxTree)adaptor.create(EXPRESSION, "EXPRESSION"), root_2);

                        adaptor.addChild(root_2, stream_propertyExpression.nextTree());

                        adaptor.addChild(root_1, root_2);
                        }
                        // MOWLParser.g:93:126: ^( EXPRESSION value )
                        {
                        OPPLSyntaxTree root_2 = (OPPLSyntaxTree)adaptor.nil();
                        root_2 = (OPPLSyntaxTree)adaptor.becomeRoot((OPPLSyntaxTree)adaptor.create(EXPRESSION, "EXPRESSION"), root_2);

                        adaptor.addChild(root_2, stream_value.nextTree());

                        adaptor.addChild(root_1, root_2);
                        }

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 3 :
                    // MOWLParser.g:95:5: NOT assertionAxiom
                    {
                    NOT16=(Token)match(input,NOT,FOLLOW_NOT_in_assertionAxiom559); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_NOT.add(NOT16);

                    pushFollow(FOLLOW_assertionAxiom_in_assertionAxiom561);
                    assertionAxiom17=assertionAxiom();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_assertionAxiom.add(assertionAxiom17.getTree());


                    // AST REWRITE
                    // elements: assertionAxiom
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (OPPLSyntaxTree)adaptor.nil();
                    // 95:24: -> ^( NEGATED_ASSERTION assertionAxiom )
                    {
                        // MOWLParser.g:95:27: ^( NEGATED_ASSERTION assertionAxiom )
                        {
                        OPPLSyntaxTree root_1 = (OPPLSyntaxTree)adaptor.nil();
                        root_1 = (OPPLSyntaxTree)adaptor.becomeRoot((OPPLSyntaxTree)adaptor.create(NEGATED_ASSERTION, "NEGATED_ASSERTION"), root_1);

                        adaptor.addChild(root_1, stream_assertionAxiom.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (OPPLSyntaxTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

          catch(RecognitionException e){
            throw e;
          }
          
          catch(RewriteEmptyStreamException e){
            throw e;
          }
        finally {
        }
        return retval;
    }
    // $ANTLR end "assertionAxiom"

    public static class binaryAxiom_return extends ParserRuleReturnScope {
        OPPLSyntaxTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "binaryAxiom"
    // MOWLParser.g:100:1: binaryAxiom options {backtrack=true; } : (lhs= expression SUBCLASS_OF superClass= expression -> ^( SUB_CLASS_AXIOM ^( EXPRESSION $lhs) ^( EXPRESSION $superClass) ) | lhs= expression EQUIVALENT_TO rhs= expression -> ^( EQUIVALENT_TO_AXIOM ^( EXPRESSION $lhs) ^( EXPRESSION $rhs) ) | lhs= expression DISJOINT_WITH disjoint= expression -> ^( DISJOINT_WITH_AXIOM ^( EXPRESSION $lhs) ^( EXPRESSION $disjoint) ) | lhs= expression SUB_PROPERTY_OF superProperty= propertyExpression -> ^( SUB_PROPERTY_AXIOM ^( EXPRESSION $lhs) ^( EXPRESSION $superProperty) ) | lhsID= atomic INVERSE_OF rhsAtomic= atomic -> ^( INVERSE_OF ^( EXPRESSION $lhsID) ^( EXPRESSION $rhsAtomic) ) | lhsID= atomic SAME_AS rhsID= atomic -> ^( SAME_AS_AXIOM ^( EXPRESSION $lhsID) ^( EXPRESSION $rhsID) ) | lhsID= atomic DIFFERENT_FROM rhsID= atomic -> ^( DIFFERENT_FROM_AXIOM ^( EXPRESSION $lhsID) ^( EXPRESSION $rhsID) ) | lhsID= atomic DOMAIN expression -> ^( DOMAIN ^( EXPRESSION $lhsID) ^( EXPRESSION expression ) ) | lhsID= atomic RANGE expression -> ^( RANGE ^( EXPRESSION $lhsID) ^( EXPRESSION expression ) ) );
    public final OPPLPatternScript_OPPLParser_MOWLParser.binaryAxiom_return binaryAxiom() throws RecognitionException {
        OPPLPatternScript_OPPLParser_MOWLParser.binaryAxiom_return retval = new OPPLPatternScript_OPPLParser_MOWLParser.binaryAxiom_return();
        retval.start = input.LT(1);

        OPPLSyntaxTree root_0 = null;

        Token SUBCLASS_OF18=null;
        Token EQUIVALENT_TO19=null;
        Token DISJOINT_WITH20=null;
        Token SUB_PROPERTY_OF21=null;
        Token INVERSE_OF22=null;
        Token SAME_AS23=null;
        Token DIFFERENT_FROM24=null;
        Token DOMAIN25=null;
        Token RANGE27=null;
        OPPLPatternScript_OPPLParser_MOWLParser.expression_return lhs = null;

        OPPLPatternScript_OPPLParser_MOWLParser.expression_return superClass = null;

        OPPLPatternScript_OPPLParser_MOWLParser.expression_return rhs = null;

        OPPLPatternScript_OPPLParser_MOWLParser.expression_return disjoint = null;

        OPPLPatternScript_OPPLParser_MOWLParser.propertyExpression_return superProperty = null;

        OPPLPatternScriptParser.atomic_return lhsID = null;

        OPPLPatternScriptParser.atomic_return rhsAtomic = null;

        OPPLPatternScriptParser.atomic_return rhsID = null;

        OPPLPatternScript_OPPLParser_MOWLParser.expression_return expression26 = null;

        OPPLPatternScript_OPPLParser_MOWLParser.expression_return expression28 = null;


        OPPLSyntaxTree SUBCLASS_OF18_tree=null;
        OPPLSyntaxTree EQUIVALENT_TO19_tree=null;
        OPPLSyntaxTree DISJOINT_WITH20_tree=null;
        OPPLSyntaxTree SUB_PROPERTY_OF21_tree=null;
        OPPLSyntaxTree INVERSE_OF22_tree=null;
        OPPLSyntaxTree SAME_AS23_tree=null;
        OPPLSyntaxTree DIFFERENT_FROM24_tree=null;
        OPPLSyntaxTree DOMAIN25_tree=null;
        OPPLSyntaxTree RANGE27_tree=null;
        RewriteRuleTokenStream stream_RANGE=new RewriteRuleTokenStream(adaptor,"token RANGE");
        RewriteRuleTokenStream stream_DISJOINT_WITH=new RewriteRuleTokenStream(adaptor,"token DISJOINT_WITH");
        RewriteRuleTokenStream stream_SAME_AS=new RewriteRuleTokenStream(adaptor,"token SAME_AS");
        RewriteRuleTokenStream stream_SUBCLASS_OF=new RewriteRuleTokenStream(adaptor,"token SUBCLASS_OF");
        RewriteRuleTokenStream stream_DIFFERENT_FROM=new RewriteRuleTokenStream(adaptor,"token DIFFERENT_FROM");
        RewriteRuleTokenStream stream_INVERSE_OF=new RewriteRuleTokenStream(adaptor,"token INVERSE_OF");
        RewriteRuleTokenStream stream_EQUIVALENT_TO=new RewriteRuleTokenStream(adaptor,"token EQUIVALENT_TO");
        RewriteRuleTokenStream stream_DOMAIN=new RewriteRuleTokenStream(adaptor,"token DOMAIN");
        RewriteRuleTokenStream stream_SUB_PROPERTY_OF=new RewriteRuleTokenStream(adaptor,"token SUB_PROPERTY_OF");
        RewriteRuleSubtreeStream stream_propertyExpression=new RewriteRuleSubtreeStream(adaptor,"rule propertyExpression");
        RewriteRuleSubtreeStream stream_atomic=new RewriteRuleSubtreeStream(adaptor,"rule atomic");
        RewriteRuleSubtreeStream stream_expression=new RewriteRuleSubtreeStream(adaptor,"rule expression");
        try {
            // MOWLParser.g:102:26: (lhs= expression SUBCLASS_OF superClass= expression -> ^( SUB_CLASS_AXIOM ^( EXPRESSION $lhs) ^( EXPRESSION $superClass) ) | lhs= expression EQUIVALENT_TO rhs= expression -> ^( EQUIVALENT_TO_AXIOM ^( EXPRESSION $lhs) ^( EXPRESSION $rhs) ) | lhs= expression DISJOINT_WITH disjoint= expression -> ^( DISJOINT_WITH_AXIOM ^( EXPRESSION $lhs) ^( EXPRESSION $disjoint) ) | lhs= expression SUB_PROPERTY_OF superProperty= propertyExpression -> ^( SUB_PROPERTY_AXIOM ^( EXPRESSION $lhs) ^( EXPRESSION $superProperty) ) | lhsID= atomic INVERSE_OF rhsAtomic= atomic -> ^( INVERSE_OF ^( EXPRESSION $lhsID) ^( EXPRESSION $rhsAtomic) ) | lhsID= atomic SAME_AS rhsID= atomic -> ^( SAME_AS_AXIOM ^( EXPRESSION $lhsID) ^( EXPRESSION $rhsID) ) | lhsID= atomic DIFFERENT_FROM rhsID= atomic -> ^( DIFFERENT_FROM_AXIOM ^( EXPRESSION $lhsID) ^( EXPRESSION $rhsID) ) | lhsID= atomic DOMAIN expression -> ^( DOMAIN ^( EXPRESSION $lhsID) ^( EXPRESSION expression ) ) | lhsID= atomic RANGE expression -> ^( RANGE ^( EXPRESSION $lhsID) ^( EXPRESSION expression ) ) )
            int alt6=9;
            alt6 = dfa6.predict(input);
            switch (alt6) {
                case 1 :
                    // MOWLParser.g:103:2: lhs= expression SUBCLASS_OF superClass= expression
                    {
                    pushFollow(FOLLOW_expression_in_binaryAxiom600);
                    lhs=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_expression.add(lhs.getTree());
                    SUBCLASS_OF18=(Token)match(input,SUBCLASS_OF,FOLLOW_SUBCLASS_OF_in_binaryAxiom602); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_SUBCLASS_OF.add(SUBCLASS_OF18);

                    pushFollow(FOLLOW_expression_in_binaryAxiom609);
                    superClass=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_expression.add(superClass.getTree());


                    // AST REWRITE
                    // elements: superClass, lhs
                    // token labels: 
                    // rule labels: lhs, retval, superClass
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_lhs=new RewriteRuleSubtreeStream(adaptor,"rule lhs",lhs!=null?lhs.tree:null);
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
                    RewriteRuleSubtreeStream stream_superClass=new RewriteRuleSubtreeStream(adaptor,"rule superClass",superClass!=null?superClass.tree:null);

                    root_0 = (OPPLSyntaxTree)adaptor.nil();
                    // 103:57: -> ^( SUB_CLASS_AXIOM ^( EXPRESSION $lhs) ^( EXPRESSION $superClass) )
                    {
                        // MOWLParser.g:103:60: ^( SUB_CLASS_AXIOM ^( EXPRESSION $lhs) ^( EXPRESSION $superClass) )
                        {
                        OPPLSyntaxTree root_1 = (OPPLSyntaxTree)adaptor.nil();
                        root_1 = (OPPLSyntaxTree)adaptor.becomeRoot((OPPLSyntaxTree)adaptor.create(SUB_CLASS_AXIOM, "SUB_CLASS_AXIOM"), root_1);

                        // MOWLParser.g:103:79: ^( EXPRESSION $lhs)
                        {
                        OPPLSyntaxTree root_2 = (OPPLSyntaxTree)adaptor.nil();
                        root_2 = (OPPLSyntaxTree)adaptor.becomeRoot((OPPLSyntaxTree)adaptor.create(EXPRESSION, "EXPRESSION"), root_2);

                        adaptor.addChild(root_2, stream_lhs.nextTree());

                        adaptor.addChild(root_1, root_2);
                        }
                        // MOWLParser.g:103:98: ^( EXPRESSION $superClass)
                        {
                        OPPLSyntaxTree root_2 = (OPPLSyntaxTree)adaptor.nil();
                        root_2 = (OPPLSyntaxTree)adaptor.becomeRoot((OPPLSyntaxTree)adaptor.create(EXPRESSION, "EXPRESSION"), root_2);

                        adaptor.addChild(root_2, stream_superClass.nextTree());

                        adaptor.addChild(root_1, root_2);
                        }

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 2 :
                    // MOWLParser.g:104:11: lhs= expression EQUIVALENT_TO rhs= expression
                    {
                    pushFollow(FOLLOW_expression_in_binaryAxiom647);
                    lhs=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_expression.add(lhs.getTree());
                    EQUIVALENT_TO19=(Token)match(input,EQUIVALENT_TO,FOLLOW_EQUIVALENT_TO_in_binaryAxiom649); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_EQUIVALENT_TO.add(EQUIVALENT_TO19);

                    pushFollow(FOLLOW_expression_in_binaryAxiom655);
                    rhs=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_expression.add(rhs.getTree());


                    // AST REWRITE
                    // elements: lhs, rhs
                    // token labels: 
                    // rule labels: lhs, retval, rhs
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_lhs=new RewriteRuleSubtreeStream(adaptor,"rule lhs",lhs!=null?lhs.tree:null);
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
                    RewriteRuleSubtreeStream stream_rhs=new RewriteRuleSubtreeStream(adaptor,"rule rhs",rhs!=null?rhs.tree:null);

                    root_0 = (OPPLSyntaxTree)adaptor.nil();
                    // 104:60: -> ^( EQUIVALENT_TO_AXIOM ^( EXPRESSION $lhs) ^( EXPRESSION $rhs) )
                    {
                        // MOWLParser.g:104:63: ^( EQUIVALENT_TO_AXIOM ^( EXPRESSION $lhs) ^( EXPRESSION $rhs) )
                        {
                        OPPLSyntaxTree root_1 = (OPPLSyntaxTree)adaptor.nil();
                        root_1 = (OPPLSyntaxTree)adaptor.becomeRoot((OPPLSyntaxTree)adaptor.create(EQUIVALENT_TO_AXIOM, "EQUIVALENT_TO_AXIOM"), root_1);

                        // MOWLParser.g:104:85: ^( EXPRESSION $lhs)
                        {
                        OPPLSyntaxTree root_2 = (OPPLSyntaxTree)adaptor.nil();
                        root_2 = (OPPLSyntaxTree)adaptor.becomeRoot((OPPLSyntaxTree)adaptor.create(EXPRESSION, "EXPRESSION"), root_2);

                        adaptor.addChild(root_2, stream_lhs.nextTree());

                        adaptor.addChild(root_1, root_2);
                        }
                        // MOWLParser.g:104:104: ^( EXPRESSION $rhs)
                        {
                        OPPLSyntaxTree root_2 = (OPPLSyntaxTree)adaptor.nil();
                        root_2 = (OPPLSyntaxTree)adaptor.becomeRoot((OPPLSyntaxTree)adaptor.create(EXPRESSION, "EXPRESSION"), root_2);

                        adaptor.addChild(root_2, stream_rhs.nextTree());

                        adaptor.addChild(root_1, root_2);
                        }

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 3 :
                    // MOWLParser.g:105:11: lhs= expression DISJOINT_WITH disjoint= expression
                    {
                    pushFollow(FOLLOW_expression_in_binaryAxiom692);
                    lhs=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_expression.add(lhs.getTree());
                    DISJOINT_WITH20=(Token)match(input,DISJOINT_WITH,FOLLOW_DISJOINT_WITH_in_binaryAxiom694); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_DISJOINT_WITH.add(DISJOINT_WITH20);

                    pushFollow(FOLLOW_expression_in_binaryAxiom700);
                    disjoint=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_expression.add(disjoint.getTree());


                    // AST REWRITE
                    // elements: lhs, disjoint
                    // token labels: 
                    // rule labels: lhs, disjoint, retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_lhs=new RewriteRuleSubtreeStream(adaptor,"rule lhs",lhs!=null?lhs.tree:null);
                    RewriteRuleSubtreeStream stream_disjoint=new RewriteRuleSubtreeStream(adaptor,"rule disjoint",disjoint!=null?disjoint.tree:null);
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (OPPLSyntaxTree)adaptor.nil();
                    // 105:65: -> ^( DISJOINT_WITH_AXIOM ^( EXPRESSION $lhs) ^( EXPRESSION $disjoint) )
                    {
                        // MOWLParser.g:105:68: ^( DISJOINT_WITH_AXIOM ^( EXPRESSION $lhs) ^( EXPRESSION $disjoint) )
                        {
                        OPPLSyntaxTree root_1 = (OPPLSyntaxTree)adaptor.nil();
                        root_1 = (OPPLSyntaxTree)adaptor.becomeRoot((OPPLSyntaxTree)adaptor.create(DISJOINT_WITH_AXIOM, "DISJOINT_WITH_AXIOM"), root_1);

                        // MOWLParser.g:105:90: ^( EXPRESSION $lhs)
                        {
                        OPPLSyntaxTree root_2 = (OPPLSyntaxTree)adaptor.nil();
                        root_2 = (OPPLSyntaxTree)adaptor.becomeRoot((OPPLSyntaxTree)adaptor.create(EXPRESSION, "EXPRESSION"), root_2);

                        adaptor.addChild(root_2, stream_lhs.nextTree());

                        adaptor.addChild(root_1, root_2);
                        }
                        // MOWLParser.g:105:109: ^( EXPRESSION $disjoint)
                        {
                        OPPLSyntaxTree root_2 = (OPPLSyntaxTree)adaptor.nil();
                        root_2 = (OPPLSyntaxTree)adaptor.becomeRoot((OPPLSyntaxTree)adaptor.create(EXPRESSION, "EXPRESSION"), root_2);

                        adaptor.addChild(root_2, stream_disjoint.nextTree());

                        adaptor.addChild(root_1, root_2);
                        }

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 4 :
                    // MOWLParser.g:106:11: lhs= expression SUB_PROPERTY_OF superProperty= propertyExpression
                    {
                    pushFollow(FOLLOW_expression_in_binaryAxiom737);
                    lhs=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_expression.add(lhs.getTree());
                    SUB_PROPERTY_OF21=(Token)match(input,SUB_PROPERTY_OF,FOLLOW_SUB_PROPERTY_OF_in_binaryAxiom739); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_SUB_PROPERTY_OF.add(SUB_PROPERTY_OF21);

                    pushFollow(FOLLOW_propertyExpression_in_binaryAxiom745);
                    superProperty=propertyExpression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_propertyExpression.add(superProperty.getTree());


                    // AST REWRITE
                    // elements: lhs, superProperty
                    // token labels: 
                    // rule labels: lhs, superProperty, retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_lhs=new RewriteRuleSubtreeStream(adaptor,"rule lhs",lhs!=null?lhs.tree:null);
                    RewriteRuleSubtreeStream stream_superProperty=new RewriteRuleSubtreeStream(adaptor,"rule superProperty",superProperty!=null?superProperty.tree:null);
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (OPPLSyntaxTree)adaptor.nil();
                    // 106:80: -> ^( SUB_PROPERTY_AXIOM ^( EXPRESSION $lhs) ^( EXPRESSION $superProperty) )
                    {
                        // MOWLParser.g:106:83: ^( SUB_PROPERTY_AXIOM ^( EXPRESSION $lhs) ^( EXPRESSION $superProperty) )
                        {
                        OPPLSyntaxTree root_1 = (OPPLSyntaxTree)adaptor.nil();
                        root_1 = (OPPLSyntaxTree)adaptor.becomeRoot((OPPLSyntaxTree)adaptor.create(SUB_PROPERTY_AXIOM, "SUB_PROPERTY_AXIOM"), root_1);

                        // MOWLParser.g:106:104: ^( EXPRESSION $lhs)
                        {
                        OPPLSyntaxTree root_2 = (OPPLSyntaxTree)adaptor.nil();
                        root_2 = (OPPLSyntaxTree)adaptor.becomeRoot((OPPLSyntaxTree)adaptor.create(EXPRESSION, "EXPRESSION"), root_2);

                        adaptor.addChild(root_2, stream_lhs.nextTree());

                        adaptor.addChild(root_1, root_2);
                        }
                        // MOWLParser.g:106:123: ^( EXPRESSION $superProperty)
                        {
                        OPPLSyntaxTree root_2 = (OPPLSyntaxTree)adaptor.nil();
                        root_2 = (OPPLSyntaxTree)adaptor.becomeRoot((OPPLSyntaxTree)adaptor.create(EXPRESSION, "EXPRESSION"), root_2);

                        adaptor.addChild(root_2, stream_superProperty.nextTree());

                        adaptor.addChild(root_1, root_2);
                        }

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 5 :
                    // MOWLParser.g:107:11: lhsID= atomic INVERSE_OF rhsAtomic= atomic
                    {
                    pushFollow(FOLLOW_atomic_in_binaryAxiom782);
                    lhsID=gOPPLPatternScript.atomic();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_atomic.add(lhsID.getTree());
                    INVERSE_OF22=(Token)match(input,INVERSE_OF,FOLLOW_INVERSE_OF_in_binaryAxiom784); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_INVERSE_OF.add(INVERSE_OF22);

                    pushFollow(FOLLOW_atomic_in_binaryAxiom790);
                    rhsAtomic=gOPPLPatternScript.atomic();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_atomic.add(rhsAtomic.getTree());


                    // AST REWRITE
                    // elements: lhsID, INVERSE_OF, rhsAtomic
                    // token labels: 
                    // rule labels: lhsID, rhsAtomic, retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_lhsID=new RewriteRuleSubtreeStream(adaptor,"rule lhsID",lhsID!=null?lhsID.tree:null);
                    RewriteRuleSubtreeStream stream_rhsAtomic=new RewriteRuleSubtreeStream(adaptor,"rule rhsAtomic",rhsAtomic!=null?rhsAtomic.tree:null);
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (OPPLSyntaxTree)adaptor.nil();
                    // 107:57: -> ^( INVERSE_OF ^( EXPRESSION $lhsID) ^( EXPRESSION $rhsAtomic) )
                    {
                        // MOWLParser.g:107:60: ^( INVERSE_OF ^( EXPRESSION $lhsID) ^( EXPRESSION $rhsAtomic) )
                        {
                        OPPLSyntaxTree root_1 = (OPPLSyntaxTree)adaptor.nil();
                        root_1 = (OPPLSyntaxTree)adaptor.becomeRoot(stream_INVERSE_OF.nextNode(), root_1);

                        // MOWLParser.g:107:73: ^( EXPRESSION $lhsID)
                        {
                        OPPLSyntaxTree root_2 = (OPPLSyntaxTree)adaptor.nil();
                        root_2 = (OPPLSyntaxTree)adaptor.becomeRoot((OPPLSyntaxTree)adaptor.create(EXPRESSION, "EXPRESSION"), root_2);

                        adaptor.addChild(root_2, stream_lhsID.nextTree());

                        adaptor.addChild(root_1, root_2);
                        }
                        // MOWLParser.g:107:94: ^( EXPRESSION $rhsAtomic)
                        {
                        OPPLSyntaxTree root_2 = (OPPLSyntaxTree)adaptor.nil();
                        root_2 = (OPPLSyntaxTree)adaptor.becomeRoot((OPPLSyntaxTree)adaptor.create(EXPRESSION, "EXPRESSION"), root_2);

                        adaptor.addChild(root_2, stream_rhsAtomic.nextTree());

                        adaptor.addChild(root_1, root_2);
                        }

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 6 :
                    // MOWLParser.g:108:3: lhsID= atomic SAME_AS rhsID= atomic
                    {
                    pushFollow(FOLLOW_atomic_in_binaryAxiom821);
                    lhsID=gOPPLPatternScript.atomic();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_atomic.add(lhsID.getTree());
                    SAME_AS23=(Token)match(input,SAME_AS,FOLLOW_SAME_AS_in_binaryAxiom823); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_SAME_AS.add(SAME_AS23);

                    pushFollow(FOLLOW_atomic_in_binaryAxiom830);
                    rhsID=gOPPLPatternScript.atomic();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_atomic.add(rhsID.getTree());


                    // AST REWRITE
                    // elements: rhsID, lhsID
                    // token labels: 
                    // rule labels: rhsID, lhsID, retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_rhsID=new RewriteRuleSubtreeStream(adaptor,"rule rhsID",rhsID!=null?rhsID.tree:null);
                    RewriteRuleSubtreeStream stream_lhsID=new RewriteRuleSubtreeStream(adaptor,"rule lhsID",lhsID!=null?lhsID.tree:null);
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (OPPLSyntaxTree)adaptor.nil();
                    // 108:43: -> ^( SAME_AS_AXIOM ^( EXPRESSION $lhsID) ^( EXPRESSION $rhsID) )
                    {
                        // MOWLParser.g:108:46: ^( SAME_AS_AXIOM ^( EXPRESSION $lhsID) ^( EXPRESSION $rhsID) )
                        {
                        OPPLSyntaxTree root_1 = (OPPLSyntaxTree)adaptor.nil();
                        root_1 = (OPPLSyntaxTree)adaptor.becomeRoot((OPPLSyntaxTree)adaptor.create(SAME_AS_AXIOM, "SAME_AS_AXIOM"), root_1);

                        // MOWLParser.g:108:62: ^( EXPRESSION $lhsID)
                        {
                        OPPLSyntaxTree root_2 = (OPPLSyntaxTree)adaptor.nil();
                        root_2 = (OPPLSyntaxTree)adaptor.becomeRoot((OPPLSyntaxTree)adaptor.create(EXPRESSION, "EXPRESSION"), root_2);

                        adaptor.addChild(root_2, stream_lhsID.nextTree());

                        adaptor.addChild(root_1, root_2);
                        }
                        // MOWLParser.g:108:84: ^( EXPRESSION $rhsID)
                        {
                        OPPLSyntaxTree root_2 = (OPPLSyntaxTree)adaptor.nil();
                        root_2 = (OPPLSyntaxTree)adaptor.becomeRoot((OPPLSyntaxTree)adaptor.create(EXPRESSION, "EXPRESSION"), root_2);

                        adaptor.addChild(root_2, stream_rhsID.nextTree());

                        adaptor.addChild(root_1, root_2);
                        }

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 7 :
                    // MOWLParser.g:109:11: lhsID= atomic DIFFERENT_FROM rhsID= atomic
                    {
                    pushFollow(FOLLOW_atomic_in_binaryAxiom868);
                    lhsID=gOPPLPatternScript.atomic();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_atomic.add(lhsID.getTree());
                    DIFFERENT_FROM24=(Token)match(input,DIFFERENT_FROM,FOLLOW_DIFFERENT_FROM_in_binaryAxiom870); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_DIFFERENT_FROM.add(DIFFERENT_FROM24);

                    pushFollow(FOLLOW_atomic_in_binaryAxiom877);
                    rhsID=gOPPLPatternScript.atomic();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_atomic.add(rhsID.getTree());


                    // AST REWRITE
                    // elements: lhsID, rhsID
                    // token labels: 
                    // rule labels: rhsID, lhsID, retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_rhsID=new RewriteRuleSubtreeStream(adaptor,"rule rhsID",rhsID!=null?rhsID.tree:null);
                    RewriteRuleSubtreeStream stream_lhsID=new RewriteRuleSubtreeStream(adaptor,"rule lhsID",lhsID!=null?lhsID.tree:null);
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (OPPLSyntaxTree)adaptor.nil();
                    // 109:58: -> ^( DIFFERENT_FROM_AXIOM ^( EXPRESSION $lhsID) ^( EXPRESSION $rhsID) )
                    {
                        // MOWLParser.g:109:61: ^( DIFFERENT_FROM_AXIOM ^( EXPRESSION $lhsID) ^( EXPRESSION $rhsID) )
                        {
                        OPPLSyntaxTree root_1 = (OPPLSyntaxTree)adaptor.nil();
                        root_1 = (OPPLSyntaxTree)adaptor.becomeRoot((OPPLSyntaxTree)adaptor.create(DIFFERENT_FROM_AXIOM, "DIFFERENT_FROM_AXIOM"), root_1);

                        // MOWLParser.g:109:84: ^( EXPRESSION $lhsID)
                        {
                        OPPLSyntaxTree root_2 = (OPPLSyntaxTree)adaptor.nil();
                        root_2 = (OPPLSyntaxTree)adaptor.becomeRoot((OPPLSyntaxTree)adaptor.create(EXPRESSION, "EXPRESSION"), root_2);

                        adaptor.addChild(root_2, stream_lhsID.nextTree());

                        adaptor.addChild(root_1, root_2);
                        }
                        // MOWLParser.g:109:105: ^( EXPRESSION $rhsID)
                        {
                        OPPLSyntaxTree root_2 = (OPPLSyntaxTree)adaptor.nil();
                        root_2 = (OPPLSyntaxTree)adaptor.becomeRoot((OPPLSyntaxTree)adaptor.create(EXPRESSION, "EXPRESSION"), root_2);

                        adaptor.addChild(root_2, stream_rhsID.nextTree());

                        adaptor.addChild(root_1, root_2);
                        }

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 8 :
                    // MOWLParser.g:110:11: lhsID= atomic DOMAIN expression
                    {
                    pushFollow(FOLLOW_atomic_in_binaryAxiom914);
                    lhsID=gOPPLPatternScript.atomic();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_atomic.add(lhsID.getTree());
                    DOMAIN25=(Token)match(input,DOMAIN,FOLLOW_DOMAIN_in_binaryAxiom917); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_DOMAIN.add(DOMAIN25);

                    pushFollow(FOLLOW_expression_in_binaryAxiom919);
                    expression26=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_expression.add(expression26.getTree());


                    // AST REWRITE
                    // elements: DOMAIN, expression, lhsID
                    // token labels: 
                    // rule labels: lhsID, retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_lhsID=new RewriteRuleSubtreeStream(adaptor,"rule lhsID",lhsID!=null?lhsID.tree:null);
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (OPPLSyntaxTree)adaptor.nil();
                    // 110:46: -> ^( DOMAIN ^( EXPRESSION $lhsID) ^( EXPRESSION expression ) )
                    {
                        // MOWLParser.g:110:49: ^( DOMAIN ^( EXPRESSION $lhsID) ^( EXPRESSION expression ) )
                        {
                        OPPLSyntaxTree root_1 = (OPPLSyntaxTree)adaptor.nil();
                        root_1 = (OPPLSyntaxTree)adaptor.becomeRoot(stream_DOMAIN.nextNode(), root_1);

                        // MOWLParser.g:110:58: ^( EXPRESSION $lhsID)
                        {
                        OPPLSyntaxTree root_2 = (OPPLSyntaxTree)adaptor.nil();
                        root_2 = (OPPLSyntaxTree)adaptor.becomeRoot((OPPLSyntaxTree)adaptor.create(EXPRESSION, "EXPRESSION"), root_2);

                        adaptor.addChild(root_2, stream_lhsID.nextTree());

                        adaptor.addChild(root_1, root_2);
                        }
                        // MOWLParser.g:110:79: ^( EXPRESSION expression )
                        {
                        OPPLSyntaxTree root_2 = (OPPLSyntaxTree)adaptor.nil();
                        root_2 = (OPPLSyntaxTree)adaptor.becomeRoot((OPPLSyntaxTree)adaptor.create(EXPRESSION, "EXPRESSION"), root_2);

                        adaptor.addChild(root_2, stream_expression.nextTree());

                        adaptor.addChild(root_1, root_2);
                        }

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 9 :
                    // MOWLParser.g:111:11: lhsID= atomic RANGE expression
                    {
                    pushFollow(FOLLOW_atomic_in_binaryAxiom955);
                    lhsID=gOPPLPatternScript.atomic();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_atomic.add(lhsID.getTree());
                    RANGE27=(Token)match(input,RANGE,FOLLOW_RANGE_in_binaryAxiom957); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_RANGE.add(RANGE27);

                    pushFollow(FOLLOW_expression_in_binaryAxiom959);
                    expression28=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_expression.add(expression28.getTree());


                    // AST REWRITE
                    // elements: expression, lhsID, RANGE
                    // token labels: 
                    // rule labels: lhsID, retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_lhsID=new RewriteRuleSubtreeStream(adaptor,"rule lhsID",lhsID!=null?lhsID.tree:null);
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (OPPLSyntaxTree)adaptor.nil();
                    // 111:44: -> ^( RANGE ^( EXPRESSION $lhsID) ^( EXPRESSION expression ) )
                    {
                        // MOWLParser.g:111:47: ^( RANGE ^( EXPRESSION $lhsID) ^( EXPRESSION expression ) )
                        {
                        OPPLSyntaxTree root_1 = (OPPLSyntaxTree)adaptor.nil();
                        root_1 = (OPPLSyntaxTree)adaptor.becomeRoot(stream_RANGE.nextNode(), root_1);

                        // MOWLParser.g:111:55: ^( EXPRESSION $lhsID)
                        {
                        OPPLSyntaxTree root_2 = (OPPLSyntaxTree)adaptor.nil();
                        root_2 = (OPPLSyntaxTree)adaptor.becomeRoot((OPPLSyntaxTree)adaptor.create(EXPRESSION, "EXPRESSION"), root_2);

                        adaptor.addChild(root_2, stream_lhsID.nextTree());

                        adaptor.addChild(root_1, root_2);
                        }
                        // MOWLParser.g:111:76: ^( EXPRESSION expression )
                        {
                        OPPLSyntaxTree root_2 = (OPPLSyntaxTree)adaptor.nil();
                        root_2 = (OPPLSyntaxTree)adaptor.becomeRoot((OPPLSyntaxTree)adaptor.create(EXPRESSION, "EXPRESSION"), root_2);

                        adaptor.addChild(root_2, stream_expression.nextTree());

                        adaptor.addChild(root_1, root_2);
                        }

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (OPPLSyntaxTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

          catch(RecognitionException e){
            throw e;
          }
          
          catch(RewriteEmptyStreamException e){
            throw e;
          }
        finally {
        }
        return retval;
    }
    // $ANTLR end "binaryAxiom"

    public static class unaryAxiom_return extends ParserRuleReturnScope {
        OPPLSyntaxTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "unaryAxiom"
    // MOWLParser.g:115:1: unaryAxiom : unaryCharacteristic unary -> ^( UNARY_AXIOM unaryCharacteristic ^( EXPRESSION unary ) ) ;
    public final OPPLPatternScript_OPPLParser_MOWLParser.unaryAxiom_return unaryAxiom() throws RecognitionException {
        OPPLPatternScript_OPPLParser_MOWLParser.unaryAxiom_return retval = new OPPLPatternScript_OPPLParser_MOWLParser.unaryAxiom_return();
        retval.start = input.LT(1);

        OPPLSyntaxTree root_0 = null;

        OPPLPatternScript_OPPLParser_MOWLParser.unaryCharacteristic_return unaryCharacteristic29 = null;

        OPPLPatternScript_OPPLParser_MOWLParser.unary_return unary30 = null;


        RewriteRuleSubtreeStream stream_unaryCharacteristic=new RewriteRuleSubtreeStream(adaptor,"rule unaryCharacteristic");
        RewriteRuleSubtreeStream stream_unary=new RewriteRuleSubtreeStream(adaptor,"rule unary");
        try {
            // MOWLParser.g:115:13: ( unaryCharacteristic unary -> ^( UNARY_AXIOM unaryCharacteristic ^( EXPRESSION unary ) ) )
            // MOWLParser.g:116:4: unaryCharacteristic unary
            {
            pushFollow(FOLLOW_unaryCharacteristic_in_unaryAxiom1033);
            unaryCharacteristic29=unaryCharacteristic();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_unaryCharacteristic.add(unaryCharacteristic29.getTree());
            pushFollow(FOLLOW_unary_in_unaryAxiom1037);
            unary30=unary();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_unary.add(unary30.getTree());


            // AST REWRITE
            // elements: unary, unaryCharacteristic
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (OPPLSyntaxTree)adaptor.nil();
            // 116:32: -> ^( UNARY_AXIOM unaryCharacteristic ^( EXPRESSION unary ) )
            {
                // MOWLParser.g:116:35: ^( UNARY_AXIOM unaryCharacteristic ^( EXPRESSION unary ) )
                {
                OPPLSyntaxTree root_1 = (OPPLSyntaxTree)adaptor.nil();
                root_1 = (OPPLSyntaxTree)adaptor.becomeRoot((OPPLSyntaxTree)adaptor.create(UNARY_AXIOM, "UNARY_AXIOM"), root_1);

                adaptor.addChild(root_1, stream_unaryCharacteristic.nextTree());
                // MOWLParser.g:116:69: ^( EXPRESSION unary )
                {
                OPPLSyntaxTree root_2 = (OPPLSyntaxTree)adaptor.nil();
                root_2 = (OPPLSyntaxTree)adaptor.becomeRoot((OPPLSyntaxTree)adaptor.create(EXPRESSION, "EXPRESSION"), root_2);

                adaptor.addChild(root_2, stream_unary.nextTree());

                adaptor.addChild(root_1, root_2);
                }

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (OPPLSyntaxTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

          catch(RecognitionException e){
            throw e;
          }
          
          catch(RewriteEmptyStreamException e){
            throw e;
          }
        finally {
        }
        return retval;
    }
    // $ANTLR end "unaryAxiom"

    public static class unaryCharacteristic_return extends ParserRuleReturnScope {
        OPPLSyntaxTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "unaryCharacteristic"
    // MOWLParser.g:119:1: unaryCharacteristic : ( FUNCTIONAL -> ^( FUNCTIONAL ) | INVERSE_FUNCTIONAL -> ^( INVERSE_FUNCTIONAL ) | SYMMETRIC -> ^( SYMMETRIC ) | ANTI_SYMMETRIC -> ^( ANTI_SYMMETRIC ) | REFLEXIVE -> ^( REFLEXIVE ) | IRREFLEXIVE -> ^( IRREFLEXIVE ) | TRANSITIVE -> ^( TRANSITIVE ) );
    public final OPPLPatternScript_OPPLParser_MOWLParser.unaryCharacteristic_return unaryCharacteristic() throws RecognitionException {
        OPPLPatternScript_OPPLParser_MOWLParser.unaryCharacteristic_return retval = new OPPLPatternScript_OPPLParser_MOWLParser.unaryCharacteristic_return();
        retval.start = input.LT(1);

        OPPLSyntaxTree root_0 = null;

        Token FUNCTIONAL31=null;
        Token INVERSE_FUNCTIONAL32=null;
        Token SYMMETRIC33=null;
        Token ANTI_SYMMETRIC34=null;
        Token REFLEXIVE35=null;
        Token IRREFLEXIVE36=null;
        Token TRANSITIVE37=null;

        OPPLSyntaxTree FUNCTIONAL31_tree=null;
        OPPLSyntaxTree INVERSE_FUNCTIONAL32_tree=null;
        OPPLSyntaxTree SYMMETRIC33_tree=null;
        OPPLSyntaxTree ANTI_SYMMETRIC34_tree=null;
        OPPLSyntaxTree REFLEXIVE35_tree=null;
        OPPLSyntaxTree IRREFLEXIVE36_tree=null;
        OPPLSyntaxTree TRANSITIVE37_tree=null;
        RewriteRuleTokenStream stream_ANTI_SYMMETRIC=new RewriteRuleTokenStream(adaptor,"token ANTI_SYMMETRIC");
        RewriteRuleTokenStream stream_SYMMETRIC=new RewriteRuleTokenStream(adaptor,"token SYMMETRIC");
        RewriteRuleTokenStream stream_TRANSITIVE=new RewriteRuleTokenStream(adaptor,"token TRANSITIVE");
        RewriteRuleTokenStream stream_REFLEXIVE=new RewriteRuleTokenStream(adaptor,"token REFLEXIVE");
        RewriteRuleTokenStream stream_INVERSE_FUNCTIONAL=new RewriteRuleTokenStream(adaptor,"token INVERSE_FUNCTIONAL");
        RewriteRuleTokenStream stream_IRREFLEXIVE=new RewriteRuleTokenStream(adaptor,"token IRREFLEXIVE");
        RewriteRuleTokenStream stream_FUNCTIONAL=new RewriteRuleTokenStream(adaptor,"token FUNCTIONAL");

        try {
            // MOWLParser.g:119:21: ( FUNCTIONAL -> ^( FUNCTIONAL ) | INVERSE_FUNCTIONAL -> ^( INVERSE_FUNCTIONAL ) | SYMMETRIC -> ^( SYMMETRIC ) | ANTI_SYMMETRIC -> ^( ANTI_SYMMETRIC ) | REFLEXIVE -> ^( REFLEXIVE ) | IRREFLEXIVE -> ^( IRREFLEXIVE ) | TRANSITIVE -> ^( TRANSITIVE ) )
            int alt7=7;
            switch ( input.LA(1) ) {
            case FUNCTIONAL:
                {
                alt7=1;
                }
                break;
            case INVERSE_FUNCTIONAL:
                {
                alt7=2;
                }
                break;
            case SYMMETRIC:
                {
                alt7=3;
                }
                break;
            case ANTI_SYMMETRIC:
                {
                alt7=4;
                }
                break;
            case REFLEXIVE:
                {
                alt7=5;
                }
                break;
            case IRREFLEXIVE:
                {
                alt7=6;
                }
                break;
            case TRANSITIVE:
                {
                alt7=7;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }

            switch (alt7) {
                case 1 :
                    // MOWLParser.g:120:5: FUNCTIONAL
                    {
                    FUNCTIONAL31=(Token)match(input,FUNCTIONAL,FOLLOW_FUNCTIONAL_in_unaryCharacteristic1082); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_FUNCTIONAL.add(FUNCTIONAL31);



                    // AST REWRITE
                    // elements: FUNCTIONAL
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (OPPLSyntaxTree)adaptor.nil();
                    // 120:16: -> ^( FUNCTIONAL )
                    {
                        // MOWLParser.g:120:19: ^( FUNCTIONAL )
                        {
                        OPPLSyntaxTree root_1 = (OPPLSyntaxTree)adaptor.nil();
                        root_1 = (OPPLSyntaxTree)adaptor.becomeRoot(stream_FUNCTIONAL.nextNode(), root_1);

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 2 :
                    // MOWLParser.g:121:7: INVERSE_FUNCTIONAL
                    {
                    INVERSE_FUNCTIONAL32=(Token)match(input,INVERSE_FUNCTIONAL,FOLLOW_INVERSE_FUNCTIONAL_in_unaryCharacteristic1096); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_INVERSE_FUNCTIONAL.add(INVERSE_FUNCTIONAL32);



                    // AST REWRITE
                    // elements: INVERSE_FUNCTIONAL
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (OPPLSyntaxTree)adaptor.nil();
                    // 121:26: -> ^( INVERSE_FUNCTIONAL )
                    {
                        // MOWLParser.g:121:29: ^( INVERSE_FUNCTIONAL )
                        {
                        OPPLSyntaxTree root_1 = (OPPLSyntaxTree)adaptor.nil();
                        root_1 = (OPPLSyntaxTree)adaptor.becomeRoot(stream_INVERSE_FUNCTIONAL.nextNode(), root_1);

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 3 :
                    // MOWLParser.g:122:7: SYMMETRIC
                    {
                    SYMMETRIC33=(Token)match(input,SYMMETRIC,FOLLOW_SYMMETRIC_in_unaryCharacteristic1110); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_SYMMETRIC.add(SYMMETRIC33);



                    // AST REWRITE
                    // elements: SYMMETRIC
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (OPPLSyntaxTree)adaptor.nil();
                    // 122:17: -> ^( SYMMETRIC )
                    {
                        // MOWLParser.g:122:20: ^( SYMMETRIC )
                        {
                        OPPLSyntaxTree root_1 = (OPPLSyntaxTree)adaptor.nil();
                        root_1 = (OPPLSyntaxTree)adaptor.becomeRoot(stream_SYMMETRIC.nextNode(), root_1);

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 4 :
                    // MOWLParser.g:123:7: ANTI_SYMMETRIC
                    {
                    ANTI_SYMMETRIC34=(Token)match(input,ANTI_SYMMETRIC,FOLLOW_ANTI_SYMMETRIC_in_unaryCharacteristic1124); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_ANTI_SYMMETRIC.add(ANTI_SYMMETRIC34);



                    // AST REWRITE
                    // elements: ANTI_SYMMETRIC
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (OPPLSyntaxTree)adaptor.nil();
                    // 123:22: -> ^( ANTI_SYMMETRIC )
                    {
                        // MOWLParser.g:123:25: ^( ANTI_SYMMETRIC )
                        {
                        OPPLSyntaxTree root_1 = (OPPLSyntaxTree)adaptor.nil();
                        root_1 = (OPPLSyntaxTree)adaptor.becomeRoot(stream_ANTI_SYMMETRIC.nextNode(), root_1);

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 5 :
                    // MOWLParser.g:124:7: REFLEXIVE
                    {
                    REFLEXIVE35=(Token)match(input,REFLEXIVE,FOLLOW_REFLEXIVE_in_unaryCharacteristic1138); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_REFLEXIVE.add(REFLEXIVE35);



                    // AST REWRITE
                    // elements: REFLEXIVE
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (OPPLSyntaxTree)adaptor.nil();
                    // 124:17: -> ^( REFLEXIVE )
                    {
                        // MOWLParser.g:124:20: ^( REFLEXIVE )
                        {
                        OPPLSyntaxTree root_1 = (OPPLSyntaxTree)adaptor.nil();
                        root_1 = (OPPLSyntaxTree)adaptor.becomeRoot(stream_REFLEXIVE.nextNode(), root_1);

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 6 :
                    // MOWLParser.g:125:7: IRREFLEXIVE
                    {
                    IRREFLEXIVE36=(Token)match(input,IRREFLEXIVE,FOLLOW_IRREFLEXIVE_in_unaryCharacteristic1152); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_IRREFLEXIVE.add(IRREFLEXIVE36);



                    // AST REWRITE
                    // elements: IRREFLEXIVE
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (OPPLSyntaxTree)adaptor.nil();
                    // 125:19: -> ^( IRREFLEXIVE )
                    {
                        // MOWLParser.g:125:22: ^( IRREFLEXIVE )
                        {
                        OPPLSyntaxTree root_1 = (OPPLSyntaxTree)adaptor.nil();
                        root_1 = (OPPLSyntaxTree)adaptor.becomeRoot(stream_IRREFLEXIVE.nextNode(), root_1);

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 7 :
                    // MOWLParser.g:126:7: TRANSITIVE
                    {
                    TRANSITIVE37=(Token)match(input,TRANSITIVE,FOLLOW_TRANSITIVE_in_unaryCharacteristic1166); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_TRANSITIVE.add(TRANSITIVE37);



                    // AST REWRITE
                    // elements: TRANSITIVE
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (OPPLSyntaxTree)adaptor.nil();
                    // 126:18: -> ^( TRANSITIVE )
                    {
                        // MOWLParser.g:126:21: ^( TRANSITIVE )
                        {
                        OPPLSyntaxTree root_1 = (OPPLSyntaxTree)adaptor.nil();
                        root_1 = (OPPLSyntaxTree)adaptor.becomeRoot(stream_TRANSITIVE.nextNode(), root_1);

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (OPPLSyntaxTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

          catch(RecognitionException e){
            throw e;
          }
          
          catch(RewriteEmptyStreamException e){
            throw e;
          }
        finally {
        }
        return retval;
    }
    // $ANTLR end "unaryCharacteristic"

    public static class expression_return extends ParserRuleReturnScope {
        OPPLSyntaxTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "expression"
    // MOWLParser.g:129:1: expression : ( options {backtrack=true; } : conjunction ( OR conjunction )* -> ^( DISJUNCTION ( conjunction )+ ) | complexPropertyExpression -> ^( complexPropertyExpression ) | OPEN_PARENTHESYS expression CLOSED_PARENTHESYS -> ^( expression ) ) ;
    public final OPPLPatternScript_OPPLParser_MOWLParser.expression_return expression() throws RecognitionException {
        OPPLPatternScript_OPPLParser_MOWLParser.expression_return retval = new OPPLPatternScript_OPPLParser_MOWLParser.expression_return();
        retval.start = input.LT(1);

        OPPLSyntaxTree root_0 = null;

        Token OR39=null;
        Token OPEN_PARENTHESYS42=null;
        Token CLOSED_PARENTHESYS44=null;
        OPPLPatternScript_OPPLParser_MOWLParser.conjunction_return conjunction38 = null;

        OPPLPatternScript_OPPLParser_MOWLParser.conjunction_return conjunction40 = null;

        OPPLPatternScript_OPPLParser_MOWLParser.complexPropertyExpression_return complexPropertyExpression41 = null;

        OPPLPatternScript_OPPLParser_MOWLParser.expression_return expression43 = null;


        OPPLSyntaxTree OR39_tree=null;
        OPPLSyntaxTree OPEN_PARENTHESYS42_tree=null;
        OPPLSyntaxTree CLOSED_PARENTHESYS44_tree=null;
        RewriteRuleTokenStream stream_CLOSED_PARENTHESYS=new RewriteRuleTokenStream(adaptor,"token CLOSED_PARENTHESYS");
        RewriteRuleTokenStream stream_OPEN_PARENTHESYS=new RewriteRuleTokenStream(adaptor,"token OPEN_PARENTHESYS");
        RewriteRuleTokenStream stream_OR=new RewriteRuleTokenStream(adaptor,"token OR");
        RewriteRuleSubtreeStream stream_conjunction=new RewriteRuleSubtreeStream(adaptor,"rule conjunction");
        RewriteRuleSubtreeStream stream_complexPropertyExpression=new RewriteRuleSubtreeStream(adaptor,"rule complexPropertyExpression");
        RewriteRuleSubtreeStream stream_expression=new RewriteRuleSubtreeStream(adaptor,"rule expression");
        try {
            // MOWLParser.g:129:11: ( ( options {backtrack=true; } : conjunction ( OR conjunction )* -> ^( DISJUNCTION ( conjunction )+ ) | complexPropertyExpression -> ^( complexPropertyExpression ) | OPEN_PARENTHESYS expression CLOSED_PARENTHESYS -> ^( expression ) ) )
            // MOWLParser.g:130:5: ( options {backtrack=true; } : conjunction ( OR conjunction )* -> ^( DISJUNCTION ( conjunction )+ ) | complexPropertyExpression -> ^( complexPropertyExpression ) | OPEN_PARENTHESYS expression CLOSED_PARENTHESYS -> ^( expression ) )
            {
            // MOWLParser.g:130:5: ( options {backtrack=true; } : conjunction ( OR conjunction )* -> ^( DISJUNCTION ( conjunction )+ ) | complexPropertyExpression -> ^( complexPropertyExpression ) | OPEN_PARENTHESYS expression CLOSED_PARENTHESYS -> ^( expression ) )
            int alt9=3;
            alt9 = dfa9.predict(input);
            switch (alt9) {
                case 1 :
                    // MOWLParser.g:132:5: conjunction ( OR conjunction )*
                    {
                    pushFollow(FOLLOW_conjunction_in_expression1208);
                    conjunction38=conjunction();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_conjunction.add(conjunction38.getTree());
                    // MOWLParser.g:132:17: ( OR conjunction )*
                    loop8:
                    do {
                        int alt8=2;
                        int LA8_0 = input.LA(1);

                        if ( (LA8_0==OR) ) {
                            alt8=1;
                        }


                        switch (alt8) {
                    	case 1 :
                    	    // MOWLParser.g:132:18: OR conjunction
                    	    {
                    	    OR39=(Token)match(input,OR,FOLLOW_OR_in_expression1211); if (state.failed) return retval; 
                    	    if ( state.backtracking==0 ) stream_OR.add(OR39);

                    	    pushFollow(FOLLOW_conjunction_in_expression1213);
                    	    conjunction40=conjunction();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) stream_conjunction.add(conjunction40.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop8;
                        }
                    } while (true);



                    // AST REWRITE
                    // elements: conjunction
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (OPPLSyntaxTree)adaptor.nil();
                    // 132:35: -> ^( DISJUNCTION ( conjunction )+ )
                    {
                        // MOWLParser.g:132:38: ^( DISJUNCTION ( conjunction )+ )
                        {
                        OPPLSyntaxTree root_1 = (OPPLSyntaxTree)adaptor.nil();
                        root_1 = (OPPLSyntaxTree)adaptor.becomeRoot((OPPLSyntaxTree)adaptor.create(DISJUNCTION, "DISJUNCTION"), root_1);

                        if ( !(stream_conjunction.hasNext()) ) {
                            throw new RewriteEarlyExitException();
                        }
                        while ( stream_conjunction.hasNext() ) {
                            adaptor.addChild(root_1, stream_conjunction.nextTree());

                        }
                        stream_conjunction.reset();

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 2 :
                    // MOWLParser.g:133:6: complexPropertyExpression
                    {
                    pushFollow(FOLLOW_complexPropertyExpression_in_expression1232);
                    complexPropertyExpression41=complexPropertyExpression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_complexPropertyExpression.add(complexPropertyExpression41.getTree());


                    // AST REWRITE
                    // elements: complexPropertyExpression
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (OPPLSyntaxTree)adaptor.nil();
                    // 133:32: -> ^( complexPropertyExpression )
                    {
                        // MOWLParser.g:133:35: ^( complexPropertyExpression )
                        {
                        OPPLSyntaxTree root_1 = (OPPLSyntaxTree)adaptor.nil();
                        root_1 = (OPPLSyntaxTree)adaptor.becomeRoot(stream_complexPropertyExpression.nextNode(), root_1);

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 3 :
                    // MOWLParser.g:134:6: OPEN_PARENTHESYS expression CLOSED_PARENTHESYS
                    {
                    OPEN_PARENTHESYS42=(Token)match(input,OPEN_PARENTHESYS,FOLLOW_OPEN_PARENTHESYS_in_expression1245); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_OPEN_PARENTHESYS.add(OPEN_PARENTHESYS42);

                    pushFollow(FOLLOW_expression_in_expression1247);
                    expression43=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_expression.add(expression43.getTree());
                    CLOSED_PARENTHESYS44=(Token)match(input,CLOSED_PARENTHESYS,FOLLOW_CLOSED_PARENTHESYS_in_expression1249); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_CLOSED_PARENTHESYS.add(CLOSED_PARENTHESYS44);



                    // AST REWRITE
                    // elements: expression
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (OPPLSyntaxTree)adaptor.nil();
                    // 134:53: -> ^( expression )
                    {
                        // MOWLParser.g:134:56: ^( expression )
                        {
                        OPPLSyntaxTree root_1 = (OPPLSyntaxTree)adaptor.nil();
                        root_1 = (OPPLSyntaxTree)adaptor.becomeRoot(stream_expression.nextNode(), root_1);

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (OPPLSyntaxTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

          catch(RecognitionException e){
            throw e;
          }
          
          catch(RewriteEmptyStreamException e){
            throw e;
          }
        finally {
        }
        return retval;
    }
    // $ANTLR end "expression"

    public static class conjunction_return extends ParserRuleReturnScope {
        OPPLSyntaxTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "conjunction"
    // MOWLParser.g:142:1: conjunction : unary ( AND unary )* -> ^( CONJUNCTION ( unary )+ ) ;
    public final OPPLPatternScript_OPPLParser_MOWLParser.conjunction_return conjunction() throws RecognitionException {
        OPPLPatternScript_OPPLParser_MOWLParser.conjunction_return retval = new OPPLPatternScript_OPPLParser_MOWLParser.conjunction_return();
        retval.start = input.LT(1);

        OPPLSyntaxTree root_0 = null;

        Token AND46=null;
        OPPLPatternScript_OPPLParser_MOWLParser.unary_return unary45 = null;

        OPPLPatternScript_OPPLParser_MOWLParser.unary_return unary47 = null;


        OPPLSyntaxTree AND46_tree=null;
        RewriteRuleTokenStream stream_AND=new RewriteRuleTokenStream(adaptor,"token AND");
        RewriteRuleSubtreeStream stream_unary=new RewriteRuleSubtreeStream(adaptor,"rule unary");
        try {
            // MOWLParser.g:142:13: ( unary ( AND unary )* -> ^( CONJUNCTION ( unary )+ ) )
            // MOWLParser.g:143:5: unary ( AND unary )*
            {
            pushFollow(FOLLOW_unary_in_conjunction1282);
            unary45=unary();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_unary.add(unary45.getTree());
            // MOWLParser.g:143:11: ( AND unary )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==AND) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // MOWLParser.g:143:12: AND unary
            	    {
            	    AND46=(Token)match(input,AND,FOLLOW_AND_in_conjunction1285); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_AND.add(AND46);

            	    pushFollow(FOLLOW_unary_in_conjunction1287);
            	    unary47=unary();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_unary.add(unary47.getTree());

            	    }
            	    break;

            	default :
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
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (OPPLSyntaxTree)adaptor.nil();
            // 143:24: -> ^( CONJUNCTION ( unary )+ )
            {
                // MOWLParser.g:143:27: ^( CONJUNCTION ( unary )+ )
                {
                OPPLSyntaxTree root_1 = (OPPLSyntaxTree)adaptor.nil();
                root_1 = (OPPLSyntaxTree)adaptor.becomeRoot((OPPLSyntaxTree)adaptor.create(CONJUNCTION, "CONJUNCTION"), root_1);

                if ( !(stream_unary.hasNext()) ) {
                    throw new RewriteEarlyExitException();
                }
                while ( stream_unary.hasNext() ) {
                    adaptor.addChild(root_1, stream_unary.nextTree());

                }
                stream_unary.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (OPPLSyntaxTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

          catch(RecognitionException e){
            throw e;
          }
          
          catch(RewriteEmptyStreamException e){
            throw e;
          }
        finally {
        }
        return retval;
    }
    // $ANTLR end "conjunction"

    public static class complexPropertyExpression_return extends ParserRuleReturnScope {
        OPPLSyntaxTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "complexPropertyExpression"
    // MOWLParser.g:146:1: complexPropertyExpression : ( INVERSE OPEN_PARENTHESYS complexPropertyExpression CLOSED_PARENTHESYS -> ^( INVERSE_OBJECT_PROPERTY_EXPRESSION complexPropertyExpression ) | INVERSE OPEN_PARENTHESYS atomic CLOSED_PARENTHESYS -> ^( INVERSE_OBJECT_PROPERTY_EXPRESSION atomic ) );
    public final OPPLPatternScript_OPPLParser_MOWLParser.complexPropertyExpression_return complexPropertyExpression() throws RecognitionException {
        OPPLPatternScript_OPPLParser_MOWLParser.complexPropertyExpression_return retval = new OPPLPatternScript_OPPLParser_MOWLParser.complexPropertyExpression_return();
        retval.start = input.LT(1);

        OPPLSyntaxTree root_0 = null;

        Token INVERSE48=null;
        Token OPEN_PARENTHESYS49=null;
        Token CLOSED_PARENTHESYS51=null;
        Token INVERSE52=null;
        Token OPEN_PARENTHESYS53=null;
        Token CLOSED_PARENTHESYS55=null;
        OPPLPatternScript_OPPLParser_MOWLParser.complexPropertyExpression_return complexPropertyExpression50 = null;

        OPPLPatternScriptParser.atomic_return atomic54 = null;


        OPPLSyntaxTree INVERSE48_tree=null;
        OPPLSyntaxTree OPEN_PARENTHESYS49_tree=null;
        OPPLSyntaxTree CLOSED_PARENTHESYS51_tree=null;
        OPPLSyntaxTree INVERSE52_tree=null;
        OPPLSyntaxTree OPEN_PARENTHESYS53_tree=null;
        OPPLSyntaxTree CLOSED_PARENTHESYS55_tree=null;
        RewriteRuleTokenStream stream_INVERSE=new RewriteRuleTokenStream(adaptor,"token INVERSE");
        RewriteRuleTokenStream stream_CLOSED_PARENTHESYS=new RewriteRuleTokenStream(adaptor,"token CLOSED_PARENTHESYS");
        RewriteRuleTokenStream stream_OPEN_PARENTHESYS=new RewriteRuleTokenStream(adaptor,"token OPEN_PARENTHESYS");
        RewriteRuleSubtreeStream stream_complexPropertyExpression=new RewriteRuleSubtreeStream(adaptor,"rule complexPropertyExpression");
        RewriteRuleSubtreeStream stream_atomic=new RewriteRuleSubtreeStream(adaptor,"rule atomic");
        try {
            // MOWLParser.g:146:26: ( INVERSE OPEN_PARENTHESYS complexPropertyExpression CLOSED_PARENTHESYS -> ^( INVERSE_OBJECT_PROPERTY_EXPRESSION complexPropertyExpression ) | INVERSE OPEN_PARENTHESYS atomic CLOSED_PARENTHESYS -> ^( INVERSE_OBJECT_PROPERTY_EXPRESSION atomic ) )
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==INVERSE) ) {
                int LA11_1 = input.LA(2);

                if ( (LA11_1==OPEN_PARENTHESYS) ) {
                    int LA11_2 = input.LA(3);

                    if ( (LA11_2==INVERSE) ) {
                        alt11=1;
                    }
                    else if ( ((LA11_2>=IDENTIFIER && LA11_2<=ENTITY_REFERENCE)||LA11_2==ESCLAMATION_MARK||LA11_2==DOLLAR||LA11_2==THIS_CLASS||LA11_2==VARIABLE_NAME) ) {
                        alt11=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 11, 2, input);

                        throw nvae;
                    }
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 11, 1, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }
            switch (alt11) {
                case 1 :
                    // MOWLParser.g:147:2: INVERSE OPEN_PARENTHESYS complexPropertyExpression CLOSED_PARENTHESYS
                    {
                    INVERSE48=(Token)match(input,INVERSE,FOLLOW_INVERSE_in_complexPropertyExpression1308); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_INVERSE.add(INVERSE48);

                    OPEN_PARENTHESYS49=(Token)match(input,OPEN_PARENTHESYS,FOLLOW_OPEN_PARENTHESYS_in_complexPropertyExpression1310); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_OPEN_PARENTHESYS.add(OPEN_PARENTHESYS49);

                    pushFollow(FOLLOW_complexPropertyExpression_in_complexPropertyExpression1312);
                    complexPropertyExpression50=complexPropertyExpression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_complexPropertyExpression.add(complexPropertyExpression50.getTree());
                    CLOSED_PARENTHESYS51=(Token)match(input,CLOSED_PARENTHESYS,FOLLOW_CLOSED_PARENTHESYS_in_complexPropertyExpression1314); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_CLOSED_PARENTHESYS.add(CLOSED_PARENTHESYS51);



                    // AST REWRITE
                    // elements: complexPropertyExpression
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (OPPLSyntaxTree)adaptor.nil();
                    // 147:72: -> ^( INVERSE_OBJECT_PROPERTY_EXPRESSION complexPropertyExpression )
                    {
                        // MOWLParser.g:147:75: ^( INVERSE_OBJECT_PROPERTY_EXPRESSION complexPropertyExpression )
                        {
                        OPPLSyntaxTree root_1 = (OPPLSyntaxTree)adaptor.nil();
                        root_1 = (OPPLSyntaxTree)adaptor.becomeRoot((OPPLSyntaxTree)adaptor.create(INVERSE_OBJECT_PROPERTY_EXPRESSION, "INVERSE_OBJECT_PROPERTY_EXPRESSION"), root_1);

                        adaptor.addChild(root_1, stream_complexPropertyExpression.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 2 :
                    // MOWLParser.g:148:4: INVERSE OPEN_PARENTHESYS atomic CLOSED_PARENTHESYS
                    {
                    INVERSE52=(Token)match(input,INVERSE,FOLLOW_INVERSE_in_complexPropertyExpression1327); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_INVERSE.add(INVERSE52);

                    OPEN_PARENTHESYS53=(Token)match(input,OPEN_PARENTHESYS,FOLLOW_OPEN_PARENTHESYS_in_complexPropertyExpression1329); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_OPEN_PARENTHESYS.add(OPEN_PARENTHESYS53);

                    pushFollow(FOLLOW_atomic_in_complexPropertyExpression1331);
                    atomic54=gOPPLPatternScript.atomic();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_atomic.add(atomic54.getTree());
                    CLOSED_PARENTHESYS55=(Token)match(input,CLOSED_PARENTHESYS,FOLLOW_CLOSED_PARENTHESYS_in_complexPropertyExpression1333); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_CLOSED_PARENTHESYS.add(CLOSED_PARENTHESYS55);



                    // AST REWRITE
                    // elements: atomic
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (OPPLSyntaxTree)adaptor.nil();
                    // 148:54: -> ^( INVERSE_OBJECT_PROPERTY_EXPRESSION atomic )
                    {
                        // MOWLParser.g:148:57: ^( INVERSE_OBJECT_PROPERTY_EXPRESSION atomic )
                        {
                        OPPLSyntaxTree root_1 = (OPPLSyntaxTree)adaptor.nil();
                        root_1 = (OPPLSyntaxTree)adaptor.becomeRoot((OPPLSyntaxTree)adaptor.create(INVERSE_OBJECT_PROPERTY_EXPRESSION, "INVERSE_OBJECT_PROPERTY_EXPRESSION"), root_1);

                        adaptor.addChild(root_1, stream_atomic.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (OPPLSyntaxTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

          catch(RecognitionException e){
            throw e;
          }
          
          catch(RewriteEmptyStreamException e){
            throw e;
          }
        finally {
        }
        return retval;
    }
    // $ANTLR end "complexPropertyExpression"

    public static class unary_return extends ParserRuleReturnScope {
        OPPLSyntaxTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "unary"
    // MOWLParser.g:151:1: unary options {backtrack=true; } : (head= propertyExpression ( COMPOSITION rest+= propertyExpression )+ -> ^( PROPERTY_CHAIN $head $rest) | NOT OPEN_PARENTHESYS expression CLOSED_PARENTHESYS -> ^( NEGATED_EXPRESSION expression ) | NOT atomic -> ^( NEGATED_EXPRESSION atomic ) | qualifiedRestriction -> ^( qualifiedRestriction ) | dataRange | constant | atomic );
    public final OPPLPatternScript_OPPLParser_MOWLParser.unary_return unary() throws RecognitionException {
        OPPLPatternScript_OPPLParser_MOWLParser.unary_return retval = new OPPLPatternScript_OPPLParser_MOWLParser.unary_return();
        retval.start = input.LT(1);

        OPPLSyntaxTree root_0 = null;

        Token COMPOSITION56=null;
        Token NOT57=null;
        Token OPEN_PARENTHESYS58=null;
        Token CLOSED_PARENTHESYS60=null;
        Token NOT61=null;
        List list_rest=null;
        OPPLPatternScript_OPPLParser_MOWLParser.propertyExpression_return head = null;

        OPPLPatternScript_OPPLParser_MOWLParser.expression_return expression59 = null;

        OPPLPatternScriptParser.atomic_return atomic62 = null;

        OPPLPatternScript_OPPLParser_MOWLParser.qualifiedRestriction_return qualifiedRestriction63 = null;

        OPPLPatternScript_OPPLParser_MOWLParser.dataRange_return dataRange64 = null;

        OPPLPatternScript_OPPLParser_MOWLParser.constant_return constant65 = null;

        OPPLPatternScriptParser.atomic_return atomic66 = null;

        RuleReturnScope rest = null;
        OPPLSyntaxTree COMPOSITION56_tree=null;
        OPPLSyntaxTree NOT57_tree=null;
        OPPLSyntaxTree OPEN_PARENTHESYS58_tree=null;
        OPPLSyntaxTree CLOSED_PARENTHESYS60_tree=null;
        OPPLSyntaxTree NOT61_tree=null;
        RewriteRuleTokenStream stream_NOT=new RewriteRuleTokenStream(adaptor,"token NOT");
        RewriteRuleTokenStream stream_CLOSED_PARENTHESYS=new RewriteRuleTokenStream(adaptor,"token CLOSED_PARENTHESYS");
        RewriteRuleTokenStream stream_COMPOSITION=new RewriteRuleTokenStream(adaptor,"token COMPOSITION");
        RewriteRuleTokenStream stream_OPEN_PARENTHESYS=new RewriteRuleTokenStream(adaptor,"token OPEN_PARENTHESYS");
        RewriteRuleSubtreeStream stream_propertyExpression=new RewriteRuleSubtreeStream(adaptor,"rule propertyExpression");
        RewriteRuleSubtreeStream stream_qualifiedRestriction=new RewriteRuleSubtreeStream(adaptor,"rule qualifiedRestriction");
        RewriteRuleSubtreeStream stream_atomic=new RewriteRuleSubtreeStream(adaptor,"rule atomic");
        RewriteRuleSubtreeStream stream_expression=new RewriteRuleSubtreeStream(adaptor,"rule expression");
        try {
            // MOWLParser.g:151:34: (head= propertyExpression ( COMPOSITION rest+= propertyExpression )+ -> ^( PROPERTY_CHAIN $head $rest) | NOT OPEN_PARENTHESYS expression CLOSED_PARENTHESYS -> ^( NEGATED_EXPRESSION expression ) | NOT atomic -> ^( NEGATED_EXPRESSION atomic ) | qualifiedRestriction -> ^( qualifiedRestriction ) | dataRange | constant | atomic )
            int alt13=7;
            alt13 = dfa13.predict(input);
            switch (alt13) {
                case 1 :
                    // MOWLParser.g:153:4: head= propertyExpression ( COMPOSITION rest+= propertyExpression )+
                    {
                    pushFollow(FOLLOW_propertyExpression_in_unary1370);
                    head=propertyExpression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_propertyExpression.add(head.getTree());
                    // MOWLParser.g:153:30: ( COMPOSITION rest+= propertyExpression )+
                    int cnt12=0;
                    loop12:
                    do {
                        int alt12=2;
                        int LA12_0 = input.LA(1);

                        if ( (LA12_0==COMPOSITION) ) {
                            alt12=1;
                        }


                        switch (alt12) {
                    	case 1 :
                    	    // MOWLParser.g:153:31: COMPOSITION rest+= propertyExpression
                    	    {
                    	    COMPOSITION56=(Token)match(input,COMPOSITION,FOLLOW_COMPOSITION_in_unary1373); if (state.failed) return retval; 
                    	    if ( state.backtracking==0 ) stream_COMPOSITION.add(COMPOSITION56);

                    	    pushFollow(FOLLOW_propertyExpression_in_unary1377);
                    	    rest=propertyExpression();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) stream_propertyExpression.add(rest.getTree());
                    	    if (list_rest==null) list_rest=new ArrayList();
                    	    list_rest.add(rest.getTree());


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt12 >= 1 ) break loop12;
                    	    if (state.backtracking>0) {state.failed=true; return retval;}
                                EarlyExitException eee =
                                    new EarlyExitException(12, input);
                                throw eee;
                        }
                        cnt12++;
                    } while (true);



                    // AST REWRITE
                    // elements: head, rest
                    // token labels: 
                    // rule labels: head, retval
                    // token list labels: 
                    // rule list labels: rest
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_head=new RewriteRuleSubtreeStream(adaptor,"rule head",head!=null?head.tree:null);
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
                    RewriteRuleSubtreeStream stream_rest=new RewriteRuleSubtreeStream(adaptor,"token rest",list_rest);
                    root_0 = (OPPLSyntaxTree)adaptor.nil();
                    // 153:71: -> ^( PROPERTY_CHAIN $head $rest)
                    {
                        // MOWLParser.g:153:74: ^( PROPERTY_CHAIN $head $rest)
                        {
                        OPPLSyntaxTree root_1 = (OPPLSyntaxTree)adaptor.nil();
                        root_1 = (OPPLSyntaxTree)adaptor.becomeRoot((OPPLSyntaxTree)adaptor.create(PROPERTY_CHAIN, "PROPERTY_CHAIN"), root_1);

                        adaptor.addChild(root_1, stream_head.nextTree());
                        adaptor.addChild(root_1, stream_rest.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 2 :
                    // MOWLParser.g:154:5: NOT OPEN_PARENTHESYS expression CLOSED_PARENTHESYS
                    {
                    NOT57=(Token)match(input,NOT,FOLLOW_NOT_in_unary1399); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_NOT.add(NOT57);

                    OPEN_PARENTHESYS58=(Token)match(input,OPEN_PARENTHESYS,FOLLOW_OPEN_PARENTHESYS_in_unary1401); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_OPEN_PARENTHESYS.add(OPEN_PARENTHESYS58);

                    pushFollow(FOLLOW_expression_in_unary1403);
                    expression59=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_expression.add(expression59.getTree());
                    CLOSED_PARENTHESYS60=(Token)match(input,CLOSED_PARENTHESYS,FOLLOW_CLOSED_PARENTHESYS_in_unary1405); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_CLOSED_PARENTHESYS.add(CLOSED_PARENTHESYS60);



                    // AST REWRITE
                    // elements: expression
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (OPPLSyntaxTree)adaptor.nil();
                    // 154:56: -> ^( NEGATED_EXPRESSION expression )
                    {
                        // MOWLParser.g:154:59: ^( NEGATED_EXPRESSION expression )
                        {
                        OPPLSyntaxTree root_1 = (OPPLSyntaxTree)adaptor.nil();
                        root_1 = (OPPLSyntaxTree)adaptor.becomeRoot((OPPLSyntaxTree)adaptor.create(NEGATED_EXPRESSION, "NEGATED_EXPRESSION"), root_1);

                        adaptor.addChild(root_1, stream_expression.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 3 :
                    // MOWLParser.g:155:5: NOT atomic
                    {
                    NOT61=(Token)match(input,NOT,FOLLOW_NOT_in_unary1419); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_NOT.add(NOT61);

                    pushFollow(FOLLOW_atomic_in_unary1421);
                    atomic62=gOPPLPatternScript.atomic();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_atomic.add(atomic62.getTree());


                    // AST REWRITE
                    // elements: atomic
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (OPPLSyntaxTree)adaptor.nil();
                    // 155:16: -> ^( NEGATED_EXPRESSION atomic )
                    {
                        // MOWLParser.g:155:19: ^( NEGATED_EXPRESSION atomic )
                        {
                        OPPLSyntaxTree root_1 = (OPPLSyntaxTree)adaptor.nil();
                        root_1 = (OPPLSyntaxTree)adaptor.becomeRoot((OPPLSyntaxTree)adaptor.create(NEGATED_EXPRESSION, "NEGATED_EXPRESSION"), root_1);

                        adaptor.addChild(root_1, stream_atomic.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 4 :
                    // MOWLParser.g:156:5: qualifiedRestriction
                    {
                    pushFollow(FOLLOW_qualifiedRestriction_in_unary1444);
                    qualifiedRestriction63=qualifiedRestriction();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_qualifiedRestriction.add(qualifiedRestriction63.getTree());


                    // AST REWRITE
                    // elements: qualifiedRestriction
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (OPPLSyntaxTree)adaptor.nil();
                    // 156:26: -> ^( qualifiedRestriction )
                    {
                        // MOWLParser.g:156:29: ^( qualifiedRestriction )
                        {
                        OPPLSyntaxTree root_1 = (OPPLSyntaxTree)adaptor.nil();
                        root_1 = (OPPLSyntaxTree)adaptor.becomeRoot(stream_qualifiedRestriction.nextNode(), root_1);

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 5 :
                    // MOWLParser.g:157:5: dataRange
                    {
                    root_0 = (OPPLSyntaxTree)adaptor.nil();

                    pushFollow(FOLLOW_dataRange_in_unary1456);
                    dataRange64=dataRange();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, dataRange64.getTree());

                    }
                    break;
                case 6 :
                    // MOWLParser.g:158:5: constant
                    {
                    root_0 = (OPPLSyntaxTree)adaptor.nil();

                    pushFollow(FOLLOW_constant_in_unary1462);
                    constant65=constant();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, constant65.getTree());

                    }
                    break;
                case 7 :
                    // MOWLParser.g:159:5: atomic
                    {
                    root_0 = (OPPLSyntaxTree)adaptor.nil();

                    pushFollow(FOLLOW_atomic_in_unary1468);
                    atomic66=gOPPLPatternScript.atomic();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, atomic66.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (OPPLSyntaxTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

          catch(RecognitionException e){
            throw e;
          }
          
          catch(RewriteEmptyStreamException e){
            throw e;
          }
        finally {
        }
        return retval;
    }
    // $ANTLR end "unary"

    public static class dataRange_return extends ParserRuleReturnScope {
        OPPLSyntaxTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "dataRange"
    // MOWLParser.g:163:1: dataRange : IDENTIFIER OPEN_SQUARE_BRACKET dataRangeFacet ( COMMA dataRangeFacet )* CLOSED_SQUARE_BRACKET -> ^( DATA_RANGE IDENTIFIER ( dataRangeFacet )+ ) ;
    public final OPPLPatternScript_OPPLParser_MOWLParser.dataRange_return dataRange() throws RecognitionException {
        OPPLPatternScript_OPPLParser_MOWLParser.dataRange_return retval = new OPPLPatternScript_OPPLParser_MOWLParser.dataRange_return();
        retval.start = input.LT(1);

        OPPLSyntaxTree root_0 = null;

        Token IDENTIFIER67=null;
        Token OPEN_SQUARE_BRACKET68=null;
        Token COMMA70=null;
        Token CLOSED_SQUARE_BRACKET72=null;
        OPPLPatternScript_OPPLParser_MOWLParser.dataRangeFacet_return dataRangeFacet69 = null;

        OPPLPatternScript_OPPLParser_MOWLParser.dataRangeFacet_return dataRangeFacet71 = null;


        OPPLSyntaxTree IDENTIFIER67_tree=null;
        OPPLSyntaxTree OPEN_SQUARE_BRACKET68_tree=null;
        OPPLSyntaxTree COMMA70_tree=null;
        OPPLSyntaxTree CLOSED_SQUARE_BRACKET72_tree=null;
        RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
        RewriteRuleTokenStream stream_IDENTIFIER=new RewriteRuleTokenStream(adaptor,"token IDENTIFIER");
        RewriteRuleTokenStream stream_OPEN_SQUARE_BRACKET=new RewriteRuleTokenStream(adaptor,"token OPEN_SQUARE_BRACKET");
        RewriteRuleTokenStream stream_CLOSED_SQUARE_BRACKET=new RewriteRuleTokenStream(adaptor,"token CLOSED_SQUARE_BRACKET");
        RewriteRuleSubtreeStream stream_dataRangeFacet=new RewriteRuleSubtreeStream(adaptor,"rule dataRangeFacet");
        try {
            // MOWLParser.g:164:2: ( IDENTIFIER OPEN_SQUARE_BRACKET dataRangeFacet ( COMMA dataRangeFacet )* CLOSED_SQUARE_BRACKET -> ^( DATA_RANGE IDENTIFIER ( dataRangeFacet )+ ) )
            // MOWLParser.g:165:4: IDENTIFIER OPEN_SQUARE_BRACKET dataRangeFacet ( COMMA dataRangeFacet )* CLOSED_SQUARE_BRACKET
            {
            IDENTIFIER67=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_dataRange1485); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_IDENTIFIER.add(IDENTIFIER67);

            OPEN_SQUARE_BRACKET68=(Token)match(input,OPEN_SQUARE_BRACKET,FOLLOW_OPEN_SQUARE_BRACKET_in_dataRange1487); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_OPEN_SQUARE_BRACKET.add(OPEN_SQUARE_BRACKET68);

            pushFollow(FOLLOW_dataRangeFacet_in_dataRange1489);
            dataRangeFacet69=dataRangeFacet();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_dataRangeFacet.add(dataRangeFacet69.getTree());
            // MOWLParser.g:165:50: ( COMMA dataRangeFacet )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==COMMA) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // MOWLParser.g:165:51: COMMA dataRangeFacet
            	    {
            	    COMMA70=(Token)match(input,COMMA,FOLLOW_COMMA_in_dataRange1492); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_COMMA.add(COMMA70);

            	    pushFollow(FOLLOW_dataRangeFacet_in_dataRange1494);
            	    dataRangeFacet71=dataRangeFacet();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_dataRangeFacet.add(dataRangeFacet71.getTree());

            	    }
            	    break;

            	default :
            	    break loop14;
                }
            } while (true);

            CLOSED_SQUARE_BRACKET72=(Token)match(input,CLOSED_SQUARE_BRACKET,FOLLOW_CLOSED_SQUARE_BRACKET_in_dataRange1498); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_CLOSED_SQUARE_BRACKET.add(CLOSED_SQUARE_BRACKET72);



            // AST REWRITE
            // elements: dataRangeFacet, IDENTIFIER
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (OPPLSyntaxTree)adaptor.nil();
            // 165:96: -> ^( DATA_RANGE IDENTIFIER ( dataRangeFacet )+ )
            {
                // MOWLParser.g:165:99: ^( DATA_RANGE IDENTIFIER ( dataRangeFacet )+ )
                {
                OPPLSyntaxTree root_1 = (OPPLSyntaxTree)adaptor.nil();
                root_1 = (OPPLSyntaxTree)adaptor.becomeRoot((OPPLSyntaxTree)adaptor.create(DATA_RANGE, "DATA_RANGE"), root_1);

                adaptor.addChild(root_1, stream_IDENTIFIER.nextNode());
                if ( !(stream_dataRangeFacet.hasNext()) ) {
                    throw new RewriteEarlyExitException();
                }
                while ( stream_dataRangeFacet.hasNext() ) {
                    adaptor.addChild(root_1, stream_dataRangeFacet.nextTree());

                }
                stream_dataRangeFacet.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (OPPLSyntaxTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

          catch(RecognitionException e){
            throw e;
          }
          
          catch(RewriteEmptyStreamException e){
            throw e;
          }
        finally {
        }
        return retval;
    }
    // $ANTLR end "dataRange"

    public static class dataRangeFacet_return extends ParserRuleReturnScope {
        OPPLSyntaxTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "dataRangeFacet"
    // MOWLParser.g:168:1: dataRangeFacet : ( LESS_THAN constant -> ^( LESS_THAN constant ) | LESS_THAN_EQUAL constant -> ^( LESS_THAN_EQUAL constant ) | GREATER_THAN constant -> ^( GREATER_THAN constant ) | GREATER_THAN_EQUAL constant -> ^( GREATER_THAN_EQUAL constant ) );
    public final OPPLPatternScript_OPPLParser_MOWLParser.dataRangeFacet_return dataRangeFacet() throws RecognitionException {
        OPPLPatternScript_OPPLParser_MOWLParser.dataRangeFacet_return retval = new OPPLPatternScript_OPPLParser_MOWLParser.dataRangeFacet_return();
        retval.start = input.LT(1);

        OPPLSyntaxTree root_0 = null;

        Token LESS_THAN73=null;
        Token LESS_THAN_EQUAL75=null;
        Token GREATER_THAN77=null;
        Token GREATER_THAN_EQUAL79=null;
        OPPLPatternScript_OPPLParser_MOWLParser.constant_return constant74 = null;

        OPPLPatternScript_OPPLParser_MOWLParser.constant_return constant76 = null;

        OPPLPatternScript_OPPLParser_MOWLParser.constant_return constant78 = null;

        OPPLPatternScript_OPPLParser_MOWLParser.constant_return constant80 = null;


        OPPLSyntaxTree LESS_THAN73_tree=null;
        OPPLSyntaxTree LESS_THAN_EQUAL75_tree=null;
        OPPLSyntaxTree GREATER_THAN77_tree=null;
        OPPLSyntaxTree GREATER_THAN_EQUAL79_tree=null;
        RewriteRuleTokenStream stream_GREATER_THAN=new RewriteRuleTokenStream(adaptor,"token GREATER_THAN");
        RewriteRuleTokenStream stream_LESS_THAN_EQUAL=new RewriteRuleTokenStream(adaptor,"token LESS_THAN_EQUAL");
        RewriteRuleTokenStream stream_GREATER_THAN_EQUAL=new RewriteRuleTokenStream(adaptor,"token GREATER_THAN_EQUAL");
        RewriteRuleTokenStream stream_LESS_THAN=new RewriteRuleTokenStream(adaptor,"token LESS_THAN");
        RewriteRuleSubtreeStream stream_constant=new RewriteRuleSubtreeStream(adaptor,"rule constant");
        try {
            // MOWLParser.g:169:2: ( LESS_THAN constant -> ^( LESS_THAN constant ) | LESS_THAN_EQUAL constant -> ^( LESS_THAN_EQUAL constant ) | GREATER_THAN constant -> ^( GREATER_THAN constant ) | GREATER_THAN_EQUAL constant -> ^( GREATER_THAN_EQUAL constant ) )
            int alt15=4;
            switch ( input.LA(1) ) {
            case LESS_THAN:
                {
                alt15=1;
                }
                break;
            case LESS_THAN_EQUAL:
                {
                alt15=2;
                }
                break;
            case GREATER_THAN:
                {
                alt15=3;
                }
                break;
            case GREATER_THAN_EQUAL:
                {
                alt15=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 15, 0, input);

                throw nvae;
            }

            switch (alt15) {
                case 1 :
                    // MOWLParser.g:170:3: LESS_THAN constant
                    {
                    LESS_THAN73=(Token)match(input,LESS_THAN,FOLLOW_LESS_THAN_in_dataRangeFacet1524); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_LESS_THAN.add(LESS_THAN73);

                    pushFollow(FOLLOW_constant_in_dataRangeFacet1526);
                    constant74=constant();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_constant.add(constant74.getTree());


                    // AST REWRITE
                    // elements: constant, LESS_THAN
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (OPPLSyntaxTree)adaptor.nil();
                    // 170:22: -> ^( LESS_THAN constant )
                    {
                        // MOWLParser.g:170:25: ^( LESS_THAN constant )
                        {
                        OPPLSyntaxTree root_1 = (OPPLSyntaxTree)adaptor.nil();
                        root_1 = (OPPLSyntaxTree)adaptor.becomeRoot(stream_LESS_THAN.nextNode(), root_1);

                        adaptor.addChild(root_1, stream_constant.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 2 :
                    // MOWLParser.g:171:5: LESS_THAN_EQUAL constant
                    {
                    LESS_THAN_EQUAL75=(Token)match(input,LESS_THAN_EQUAL,FOLLOW_LESS_THAN_EQUAL_in_dataRangeFacet1540); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_LESS_THAN_EQUAL.add(LESS_THAN_EQUAL75);

                    pushFollow(FOLLOW_constant_in_dataRangeFacet1542);
                    constant76=constant();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_constant.add(constant76.getTree());


                    // AST REWRITE
                    // elements: LESS_THAN_EQUAL, constant
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (OPPLSyntaxTree)adaptor.nil();
                    // 171:31: -> ^( LESS_THAN_EQUAL constant )
                    {
                        // MOWLParser.g:171:34: ^( LESS_THAN_EQUAL constant )
                        {
                        OPPLSyntaxTree root_1 = (OPPLSyntaxTree)adaptor.nil();
                        root_1 = (OPPLSyntaxTree)adaptor.becomeRoot(stream_LESS_THAN_EQUAL.nextNode(), root_1);

                        adaptor.addChild(root_1, stream_constant.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 3 :
                    // MOWLParser.g:172:5: GREATER_THAN constant
                    {
                    GREATER_THAN77=(Token)match(input,GREATER_THAN,FOLLOW_GREATER_THAN_in_dataRangeFacet1557); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_GREATER_THAN.add(GREATER_THAN77);

                    pushFollow(FOLLOW_constant_in_dataRangeFacet1559);
                    constant78=constant();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_constant.add(constant78.getTree());


                    // AST REWRITE
                    // elements: GREATER_THAN, constant
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (OPPLSyntaxTree)adaptor.nil();
                    // 172:27: -> ^( GREATER_THAN constant )
                    {
                        // MOWLParser.g:172:30: ^( GREATER_THAN constant )
                        {
                        OPPLSyntaxTree root_1 = (OPPLSyntaxTree)adaptor.nil();
                        root_1 = (OPPLSyntaxTree)adaptor.becomeRoot(stream_GREATER_THAN.nextNode(), root_1);

                        adaptor.addChild(root_1, stream_constant.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 4 :
                    // MOWLParser.g:173:5: GREATER_THAN_EQUAL constant
                    {
                    GREATER_THAN_EQUAL79=(Token)match(input,GREATER_THAN_EQUAL,FOLLOW_GREATER_THAN_EQUAL_in_dataRangeFacet1573); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_GREATER_THAN_EQUAL.add(GREATER_THAN_EQUAL79);

                    pushFollow(FOLLOW_constant_in_dataRangeFacet1575);
                    constant80=constant();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_constant.add(constant80.getTree());


                    // AST REWRITE
                    // elements: constant, GREATER_THAN_EQUAL
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (OPPLSyntaxTree)adaptor.nil();
                    // 173:33: -> ^( GREATER_THAN_EQUAL constant )
                    {
                        // MOWLParser.g:173:36: ^( GREATER_THAN_EQUAL constant )
                        {
                        OPPLSyntaxTree root_1 = (OPPLSyntaxTree)adaptor.nil();
                        root_1 = (OPPLSyntaxTree)adaptor.becomeRoot(stream_GREATER_THAN_EQUAL.nextNode(), root_1);

                        adaptor.addChild(root_1, stream_constant.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (OPPLSyntaxTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

          catch(RecognitionException e){
            throw e;
          }
          
          catch(RewriteEmptyStreamException e){
            throw e;
          }
        finally {
        }
        return retval;
    }
    // $ANTLR end "dataRangeFacet"

    public static class qualifiedRestriction_return extends ParserRuleReturnScope {
        OPPLSyntaxTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "qualifiedRestriction"
    // MOWLParser.g:181:1: qualifiedRestriction : ( options {backtrack=true; } : propertyExpression SOME expression -> ^( SOME_RESTRICTION propertyExpression expression ) | propertyExpression ONLY expression -> ^( ALL_RESTRICTION propertyExpression expression ) | cardinalityRestriction -> ^( cardinalityRestriction ) | oneOf -> ^( oneOf ) | valueRestriction -> ^( valueRestriction ) ) ;
    public final OPPLPatternScript_OPPLParser_MOWLParser.qualifiedRestriction_return qualifiedRestriction() throws RecognitionException {
        OPPLPatternScript_OPPLParser_MOWLParser.qualifiedRestriction_return retval = new OPPLPatternScript_OPPLParser_MOWLParser.qualifiedRestriction_return();
        retval.start = input.LT(1);

        OPPLSyntaxTree root_0 = null;

        Token SOME82=null;
        Token ONLY85=null;
        OPPLPatternScript_OPPLParser_MOWLParser.propertyExpression_return propertyExpression81 = null;

        OPPLPatternScript_OPPLParser_MOWLParser.expression_return expression83 = null;

        OPPLPatternScript_OPPLParser_MOWLParser.propertyExpression_return propertyExpression84 = null;

        OPPLPatternScript_OPPLParser_MOWLParser.expression_return expression86 = null;

        OPPLPatternScript_OPPLParser_MOWLParser.cardinalityRestriction_return cardinalityRestriction87 = null;

        OPPLPatternScript_OPPLParser_MOWLParser.oneOf_return oneOf88 = null;

        OPPLPatternScript_OPPLParser_MOWLParser.valueRestriction_return valueRestriction89 = null;


        OPPLSyntaxTree SOME82_tree=null;
        OPPLSyntaxTree ONLY85_tree=null;
        RewriteRuleTokenStream stream_SOME=new RewriteRuleTokenStream(adaptor,"token SOME");
        RewriteRuleTokenStream stream_ONLY=new RewriteRuleTokenStream(adaptor,"token ONLY");
        RewriteRuleSubtreeStream stream_cardinalityRestriction=new RewriteRuleSubtreeStream(adaptor,"rule cardinalityRestriction");
        RewriteRuleSubtreeStream stream_propertyExpression=new RewriteRuleSubtreeStream(adaptor,"rule propertyExpression");
        RewriteRuleSubtreeStream stream_oneOf=new RewriteRuleSubtreeStream(adaptor,"rule oneOf");
        RewriteRuleSubtreeStream stream_expression=new RewriteRuleSubtreeStream(adaptor,"rule expression");
        RewriteRuleSubtreeStream stream_valueRestriction=new RewriteRuleSubtreeStream(adaptor,"rule valueRestriction");
        try {
            // MOWLParser.g:181:21: ( ( options {backtrack=true; } : propertyExpression SOME expression -> ^( SOME_RESTRICTION propertyExpression expression ) | propertyExpression ONLY expression -> ^( ALL_RESTRICTION propertyExpression expression ) | cardinalityRestriction -> ^( cardinalityRestriction ) | oneOf -> ^( oneOf ) | valueRestriction -> ^( valueRestriction ) ) )
            // MOWLParser.g:182:9: ( options {backtrack=true; } : propertyExpression SOME expression -> ^( SOME_RESTRICTION propertyExpression expression ) | propertyExpression ONLY expression -> ^( ALL_RESTRICTION propertyExpression expression ) | cardinalityRestriction -> ^( cardinalityRestriction ) | oneOf -> ^( oneOf ) | valueRestriction -> ^( valueRestriction ) )
            {
            // MOWLParser.g:182:9: ( options {backtrack=true; } : propertyExpression SOME expression -> ^( SOME_RESTRICTION propertyExpression expression ) | propertyExpression ONLY expression -> ^( ALL_RESTRICTION propertyExpression expression ) | cardinalityRestriction -> ^( cardinalityRestriction ) | oneOf -> ^( oneOf ) | valueRestriction -> ^( valueRestriction ) )
            int alt17=5;
            alt17 = dfa17.predict(input);
            switch (alt17) {
                case 1 :
                    // MOWLParser.g:184:7: propertyExpression SOME expression
                    {
                    pushFollow(FOLLOW_propertyExpression_in_qualifiedRestriction1655);
                    propertyExpression81=propertyExpression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_propertyExpression.add(propertyExpression81.getTree());
                    SOME82=(Token)match(input,SOME,FOLLOW_SOME_in_qualifiedRestriction1658); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_SOME.add(SOME82);

                    pushFollow(FOLLOW_expression_in_qualifiedRestriction1662);
                    expression83=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_expression.add(expression83.getTree());


                    // AST REWRITE
                    // elements: propertyExpression, expression
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (OPPLSyntaxTree)adaptor.nil();
                    // 184:46: -> ^( SOME_RESTRICTION propertyExpression expression )
                    {
                        // MOWLParser.g:184:49: ^( SOME_RESTRICTION propertyExpression expression )
                        {
                        OPPLSyntaxTree root_1 = (OPPLSyntaxTree)adaptor.nil();
                        root_1 = (OPPLSyntaxTree)adaptor.becomeRoot((OPPLSyntaxTree)adaptor.create(SOME_RESTRICTION, "SOME_RESTRICTION"), root_1);

                        adaptor.addChild(root_1, stream_propertyExpression.nextTree());
                        adaptor.addChild(root_1, stream_expression.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 2 :
                    // MOWLParser.g:185:7: propertyExpression ONLY expression
                    {
                    pushFollow(FOLLOW_propertyExpression_in_qualifiedRestriction1691);
                    propertyExpression84=propertyExpression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_propertyExpression.add(propertyExpression84.getTree());
                    ONLY85=(Token)match(input,ONLY,FOLLOW_ONLY_in_qualifiedRestriction1693); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_ONLY.add(ONLY85);

                    pushFollow(FOLLOW_expression_in_qualifiedRestriction1696);
                    expression86=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_expression.add(expression86.getTree());


                    // AST REWRITE
                    // elements: propertyExpression, expression
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (OPPLSyntaxTree)adaptor.nil();
                    // 185:44: -> ^( ALL_RESTRICTION propertyExpression expression )
                    {
                        // MOWLParser.g:185:47: ^( ALL_RESTRICTION propertyExpression expression )
                        {
                        OPPLSyntaxTree root_1 = (OPPLSyntaxTree)adaptor.nil();
                        root_1 = (OPPLSyntaxTree)adaptor.becomeRoot((OPPLSyntaxTree)adaptor.create(ALL_RESTRICTION, "ALL_RESTRICTION"), root_1);

                        adaptor.addChild(root_1, stream_propertyExpression.nextTree());
                        adaptor.addChild(root_1, stream_expression.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 3 :
                    // MOWLParser.g:186:7: cardinalityRestriction
                    {
                    pushFollow(FOLLOW_cardinalityRestriction_in_qualifiedRestriction1715);
                    cardinalityRestriction87=cardinalityRestriction();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_cardinalityRestriction.add(cardinalityRestriction87.getTree());


                    // AST REWRITE
                    // elements: cardinalityRestriction
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (OPPLSyntaxTree)adaptor.nil();
                    // 186:30: -> ^( cardinalityRestriction )
                    {
                        // MOWLParser.g:186:33: ^( cardinalityRestriction )
                        {
                        OPPLSyntaxTree root_1 = (OPPLSyntaxTree)adaptor.nil();
                        root_1 = (OPPLSyntaxTree)adaptor.becomeRoot(stream_cardinalityRestriction.nextNode(), root_1);

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 4 :
                    // MOWLParser.g:187:7: oneOf
                    {
                    pushFollow(FOLLOW_oneOf_in_qualifiedRestriction1729);
                    oneOf88=oneOf();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_oneOf.add(oneOf88.getTree());


                    // AST REWRITE
                    // elements: oneOf
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (OPPLSyntaxTree)adaptor.nil();
                    // 187:13: -> ^( oneOf )
                    {
                        // MOWLParser.g:187:16: ^( oneOf )
                        {
                        OPPLSyntaxTree root_1 = (OPPLSyntaxTree)adaptor.nil();
                        root_1 = (OPPLSyntaxTree)adaptor.becomeRoot(stream_oneOf.nextNode(), root_1);

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 5 :
                    // MOWLParser.g:188:7: valueRestriction
                    {
                    pushFollow(FOLLOW_valueRestriction_in_qualifiedRestriction1743);
                    valueRestriction89=valueRestriction();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_valueRestriction.add(valueRestriction89.getTree());


                    // AST REWRITE
                    // elements: valueRestriction
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (OPPLSyntaxTree)adaptor.nil();
                    // 188:24: -> ^( valueRestriction )
                    {
                        // MOWLParser.g:188:27: ^( valueRestriction )
                        {
                        OPPLSyntaxTree root_1 = (OPPLSyntaxTree)adaptor.nil();
                        root_1 = (OPPLSyntaxTree)adaptor.becomeRoot(stream_valueRestriction.nextNode(), root_1);

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (OPPLSyntaxTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

          catch(RecognitionException e){
            throw e;
          }
          
          catch(RewriteEmptyStreamException e){
            throw e;
          }
        finally {
        }
        return retval;
    }
    // $ANTLR end "qualifiedRestriction"

    public static class propertyExpression_return extends ParserRuleReturnScope {
        OPPLSyntaxTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "propertyExpression"
    // MOWLParser.g:192:1: propertyExpression : ( atomic -> ^( atomic ) | complexPropertyExpression -> ^( complexPropertyExpression ) );
    public final OPPLPatternScript_OPPLParser_MOWLParser.propertyExpression_return propertyExpression() throws RecognitionException {
        OPPLPatternScript_OPPLParser_MOWLParser.propertyExpression_return retval = new OPPLPatternScript_OPPLParser_MOWLParser.propertyExpression_return();
        retval.start = input.LT(1);

        OPPLSyntaxTree root_0 = null;

        OPPLPatternScriptParser.atomic_return atomic90 = null;

        OPPLPatternScript_OPPLParser_MOWLParser.complexPropertyExpression_return complexPropertyExpression91 = null;


        RewriteRuleSubtreeStream stream_complexPropertyExpression=new RewriteRuleSubtreeStream(adaptor,"rule complexPropertyExpression");
        RewriteRuleSubtreeStream stream_atomic=new RewriteRuleSubtreeStream(adaptor,"rule atomic");
        try {
            // MOWLParser.g:192:21: ( atomic -> ^( atomic ) | complexPropertyExpression -> ^( complexPropertyExpression ) )
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( ((LA18_0>=IDENTIFIER && LA18_0<=ENTITY_REFERENCE)||LA18_0==ESCLAMATION_MARK||LA18_0==DOLLAR||LA18_0==THIS_CLASS||LA18_0==VARIABLE_NAME) ) {
                alt18=1;
            }
            else if ( (LA18_0==INVERSE) ) {
                alt18=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 18, 0, input);

                throw nvae;
            }
            switch (alt18) {
                case 1 :
                    // MOWLParser.g:193:7: atomic
                    {
                    pushFollow(FOLLOW_atomic_in_propertyExpression1775);
                    atomic90=gOPPLPatternScript.atomic();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_atomic.add(atomic90.getTree());


                    // AST REWRITE
                    // elements: atomic
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (OPPLSyntaxTree)adaptor.nil();
                    // 193:14: -> ^( atomic )
                    {
                        // MOWLParser.g:193:17: ^( atomic )
                        {
                        OPPLSyntaxTree root_1 = (OPPLSyntaxTree)adaptor.nil();
                        root_1 = (OPPLSyntaxTree)adaptor.becomeRoot(stream_atomic.nextNode(), root_1);

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 2 :
                    // MOWLParser.g:194:7: complexPropertyExpression
                    {
                    pushFollow(FOLLOW_complexPropertyExpression_in_propertyExpression1789);
                    complexPropertyExpression91=complexPropertyExpression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_complexPropertyExpression.add(complexPropertyExpression91.getTree());


                    // AST REWRITE
                    // elements: complexPropertyExpression
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (OPPLSyntaxTree)adaptor.nil();
                    // 194:33: -> ^( complexPropertyExpression )
                    {
                        // MOWLParser.g:194:36: ^( complexPropertyExpression )
                        {
                        OPPLSyntaxTree root_1 = (OPPLSyntaxTree)adaptor.nil();
                        root_1 = (OPPLSyntaxTree)adaptor.becomeRoot(stream_complexPropertyExpression.nextNode(), root_1);

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (OPPLSyntaxTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

          catch(RecognitionException e){
            throw e;
          }
          
          catch(RewriteEmptyStreamException e){
            throw e;
          }
        finally {
        }
        return retval;
    }
    // $ANTLR end "propertyExpression"

    public static class cardinalityRestriction_return extends ParserRuleReturnScope {
        OPPLSyntaxTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "cardinalityRestriction"
    // MOWLParser.g:197:1: cardinalityRestriction options {backtrack=true; } : propertyExpression restrictionKind INTEGER ( unary )? -> ^( CARDINALITY_RESTRICTION restrictionKind INTEGER propertyExpression ( unary )? ) ;
    public final OPPLPatternScript_OPPLParser_MOWLParser.cardinalityRestriction_return cardinalityRestriction() throws RecognitionException {
        OPPLPatternScript_OPPLParser_MOWLParser.cardinalityRestriction_return retval = new OPPLPatternScript_OPPLParser_MOWLParser.cardinalityRestriction_return();
        retval.start = input.LT(1);

        OPPLSyntaxTree root_0 = null;

        Token INTEGER94=null;
        OPPLPatternScript_OPPLParser_MOWLParser.propertyExpression_return propertyExpression92 = null;

        OPPLPatternScript_OPPLParser_MOWLParser.restrictionKind_return restrictionKind93 = null;

        OPPLPatternScript_OPPLParser_MOWLParser.unary_return unary95 = null;


        OPPLSyntaxTree INTEGER94_tree=null;
        RewriteRuleTokenStream stream_INTEGER=new RewriteRuleTokenStream(adaptor,"token INTEGER");
        RewriteRuleSubtreeStream stream_propertyExpression=new RewriteRuleSubtreeStream(adaptor,"rule propertyExpression");
        RewriteRuleSubtreeStream stream_restrictionKind=new RewriteRuleSubtreeStream(adaptor,"rule restrictionKind");
        RewriteRuleSubtreeStream stream_unary=new RewriteRuleSubtreeStream(adaptor,"rule unary");
        try {
            // MOWLParser.g:198:28: ( propertyExpression restrictionKind INTEGER ( unary )? -> ^( CARDINALITY_RESTRICTION restrictionKind INTEGER propertyExpression ( unary )? ) )
            // MOWLParser.g:199:2: propertyExpression restrictionKind INTEGER ( unary )?
            {
            pushFollow(FOLLOW_propertyExpression_in_cardinalityRestriction1831);
            propertyExpression92=propertyExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_propertyExpression.add(propertyExpression92.getTree());
            pushFollow(FOLLOW_restrictionKind_in_cardinalityRestriction1834);
            restrictionKind93=restrictionKind();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_restrictionKind.add(restrictionKind93.getTree());
            INTEGER94=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_cardinalityRestriction1836); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_INTEGER.add(INTEGER94);

            // MOWLParser.g:199:46: ( unary )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==OPEN_CURLY_BRACES||LA19_0==NOT||LA19_0==INVERSE||LA19_0==DBLQUOTE||(LA19_0>=IDENTIFIER && LA19_0<=ENTITY_REFERENCE)||LA19_0==ESCLAMATION_MARK||LA19_0==DOLLAR||LA19_0==THIS_CLASS||LA19_0==VARIABLE_NAME) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // MOWLParser.g:199:46: unary
                    {
                    pushFollow(FOLLOW_unary_in_cardinalityRestriction1838);
                    unary95=unary();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_unary.add(unary95.getTree());

                    }
                    break;

            }



            // AST REWRITE
            // elements: INTEGER, restrictionKind, propertyExpression, unary
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (OPPLSyntaxTree)adaptor.nil();
            // 199:53: -> ^( CARDINALITY_RESTRICTION restrictionKind INTEGER propertyExpression ( unary )? )
            {
                // MOWLParser.g:199:56: ^( CARDINALITY_RESTRICTION restrictionKind INTEGER propertyExpression ( unary )? )
                {
                OPPLSyntaxTree root_1 = (OPPLSyntaxTree)adaptor.nil();
                root_1 = (OPPLSyntaxTree)adaptor.becomeRoot((OPPLSyntaxTree)adaptor.create(CARDINALITY_RESTRICTION, "CARDINALITY_RESTRICTION"), root_1);

                adaptor.addChild(root_1, stream_restrictionKind.nextTree());
                adaptor.addChild(root_1, stream_INTEGER.nextNode());
                adaptor.addChild(root_1, stream_propertyExpression.nextTree());
                // MOWLParser.g:199:127: ( unary )?
                if ( stream_unary.hasNext() ) {
                    adaptor.addChild(root_1, stream_unary.nextTree());

                }
                stream_unary.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (OPPLSyntaxTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

          catch(RecognitionException e){
            throw e;
          }
          
          catch(RewriteEmptyStreamException e){
            throw e;
          }
        finally {
        }
        return retval;
    }
    // $ANTLR end "cardinalityRestriction"

    public static class restrictionKind_return extends ParserRuleReturnScope {
        OPPLSyntaxTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "restrictionKind"
    // MOWLParser.g:202:1: restrictionKind : ( MIN -> ^( MIN ) | MAX -> ^( MAX ) | EXACTLY -> ^( EXACTLY ) );
    public final OPPLPatternScript_OPPLParser_MOWLParser.restrictionKind_return restrictionKind() throws RecognitionException {
        OPPLPatternScript_OPPLParser_MOWLParser.restrictionKind_return retval = new OPPLPatternScript_OPPLParser_MOWLParser.restrictionKind_return();
        retval.start = input.LT(1);

        OPPLSyntaxTree root_0 = null;

        Token MIN96=null;
        Token MAX97=null;
        Token EXACTLY98=null;

        OPPLSyntaxTree MIN96_tree=null;
        OPPLSyntaxTree MAX97_tree=null;
        OPPLSyntaxTree EXACTLY98_tree=null;
        RewriteRuleTokenStream stream_MAX=new RewriteRuleTokenStream(adaptor,"token MAX");
        RewriteRuleTokenStream stream_MIN=new RewriteRuleTokenStream(adaptor,"token MIN");
        RewriteRuleTokenStream stream_EXACTLY=new RewriteRuleTokenStream(adaptor,"token EXACTLY");

        try {
            // MOWLParser.g:202:17: ( MIN -> ^( MIN ) | MAX -> ^( MAX ) | EXACTLY -> ^( EXACTLY ) )
            int alt20=3;
            switch ( input.LA(1) ) {
            case MIN:
                {
                alt20=1;
                }
                break;
            case MAX:
                {
                alt20=2;
                }
                break;
            case EXACTLY:
                {
                alt20=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 20, 0, input);

                throw nvae;
            }

            switch (alt20) {
                case 1 :
                    // MOWLParser.g:203:5: MIN
                    {
                    MIN96=(Token)match(input,MIN,FOLLOW_MIN_in_restrictionKind1871); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_MIN.add(MIN96);



                    // AST REWRITE
                    // elements: MIN
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (OPPLSyntaxTree)adaptor.nil();
                    // 203:9: -> ^( MIN )
                    {
                        // MOWLParser.g:203:12: ^( MIN )
                        {
                        OPPLSyntaxTree root_1 = (OPPLSyntaxTree)adaptor.nil();
                        root_1 = (OPPLSyntaxTree)adaptor.becomeRoot(stream_MIN.nextNode(), root_1);

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 2 :
                    // MOWLParser.g:204:7: MAX
                    {
                    MAX97=(Token)match(input,MAX,FOLLOW_MAX_in_restrictionKind1885); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_MAX.add(MAX97);



                    // AST REWRITE
                    // elements: MAX
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (OPPLSyntaxTree)adaptor.nil();
                    // 204:11: -> ^( MAX )
                    {
                        // MOWLParser.g:204:14: ^( MAX )
                        {
                        OPPLSyntaxTree root_1 = (OPPLSyntaxTree)adaptor.nil();
                        root_1 = (OPPLSyntaxTree)adaptor.becomeRoot(stream_MAX.nextNode(), root_1);

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 3 :
                    // MOWLParser.g:205:7: EXACTLY
                    {
                    EXACTLY98=(Token)match(input,EXACTLY,FOLLOW_EXACTLY_in_restrictionKind1899); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_EXACTLY.add(EXACTLY98);



                    // AST REWRITE
                    // elements: EXACTLY
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (OPPLSyntaxTree)adaptor.nil();
                    // 205:15: -> ^( EXACTLY )
                    {
                        // MOWLParser.g:205:18: ^( EXACTLY )
                        {
                        OPPLSyntaxTree root_1 = (OPPLSyntaxTree)adaptor.nil();
                        root_1 = (OPPLSyntaxTree)adaptor.becomeRoot(stream_EXACTLY.nextNode(), root_1);

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (OPPLSyntaxTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

          catch(RecognitionException e){
            throw e;
          }
          
          catch(RewriteEmptyStreamException e){
            throw e;
          }
        finally {
        }
        return retval;
    }
    // $ANTLR end "restrictionKind"

    public static class oneOf_return extends ParserRuleReturnScope {
        OPPLSyntaxTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "oneOf"
    // MOWLParser.g:209:1: oneOf : OPEN_CURLY_BRACES IDENTIFIER ( COMMA IDENTIFIER )* CLOSED_CURLY_BRACES -> ^( ONE_OF ( IDENTIFIER )+ ) ;
    public final OPPLPatternScript_OPPLParser_MOWLParser.oneOf_return oneOf() throws RecognitionException {
        OPPLPatternScript_OPPLParser_MOWLParser.oneOf_return retval = new OPPLPatternScript_OPPLParser_MOWLParser.oneOf_return();
        retval.start = input.LT(1);

        OPPLSyntaxTree root_0 = null;

        Token OPEN_CURLY_BRACES99=null;
        Token IDENTIFIER100=null;
        Token COMMA101=null;
        Token IDENTIFIER102=null;
        Token CLOSED_CURLY_BRACES103=null;

        OPPLSyntaxTree OPEN_CURLY_BRACES99_tree=null;
        OPPLSyntaxTree IDENTIFIER100_tree=null;
        OPPLSyntaxTree COMMA101_tree=null;
        OPPLSyntaxTree IDENTIFIER102_tree=null;
        OPPLSyntaxTree CLOSED_CURLY_BRACES103_tree=null;
        RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
        RewriteRuleTokenStream stream_OPEN_CURLY_BRACES=new RewriteRuleTokenStream(adaptor,"token OPEN_CURLY_BRACES");
        RewriteRuleTokenStream stream_CLOSED_CURLY_BRACES=new RewriteRuleTokenStream(adaptor,"token CLOSED_CURLY_BRACES");
        RewriteRuleTokenStream stream_IDENTIFIER=new RewriteRuleTokenStream(adaptor,"token IDENTIFIER");

        try {
            // MOWLParser.g:209:7: ( OPEN_CURLY_BRACES IDENTIFIER ( COMMA IDENTIFIER )* CLOSED_CURLY_BRACES -> ^( ONE_OF ( IDENTIFIER )+ ) )
            // MOWLParser.g:210:3: OPEN_CURLY_BRACES IDENTIFIER ( COMMA IDENTIFIER )* CLOSED_CURLY_BRACES
            {
            OPEN_CURLY_BRACES99=(Token)match(input,OPEN_CURLY_BRACES,FOLLOW_OPEN_CURLY_BRACES_in_oneOf1921); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_OPEN_CURLY_BRACES.add(OPEN_CURLY_BRACES99);

            IDENTIFIER100=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_oneOf1923); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_IDENTIFIER.add(IDENTIFIER100);

            // MOWLParser.g:210:32: ( COMMA IDENTIFIER )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==COMMA) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // MOWLParser.g:210:33: COMMA IDENTIFIER
            	    {
            	    COMMA101=(Token)match(input,COMMA,FOLLOW_COMMA_in_oneOf1926); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_COMMA.add(COMMA101);

            	    IDENTIFIER102=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_oneOf1928); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_IDENTIFIER.add(IDENTIFIER102);


            	    }
            	    break;

            	default :
            	    break loop21;
                }
            } while (true);

            CLOSED_CURLY_BRACES103=(Token)match(input,CLOSED_CURLY_BRACES,FOLLOW_CLOSED_CURLY_BRACES_in_oneOf1932); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_CLOSED_CURLY_BRACES.add(CLOSED_CURLY_BRACES103);



            // AST REWRITE
            // elements: IDENTIFIER
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (OPPLSyntaxTree)adaptor.nil();
            // 210:72: -> ^( ONE_OF ( IDENTIFIER )+ )
            {
                // MOWLParser.g:210:75: ^( ONE_OF ( IDENTIFIER )+ )
                {
                OPPLSyntaxTree root_1 = (OPPLSyntaxTree)adaptor.nil();
                root_1 = (OPPLSyntaxTree)adaptor.becomeRoot((OPPLSyntaxTree)adaptor.create(ONE_OF, "ONE_OF"), root_1);

                if ( !(stream_IDENTIFIER.hasNext()) ) {
                    throw new RewriteEarlyExitException();
                }
                while ( stream_IDENTIFIER.hasNext() ) {
                    adaptor.addChild(root_1, stream_IDENTIFIER.nextNode());

                }
                stream_IDENTIFIER.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (OPPLSyntaxTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

          catch(RecognitionException e){
            throw e;
          }
          
          catch(RewriteEmptyStreamException e){
            throw e;
          }
        finally {
        }
        return retval;
    }
    // $ANTLR end "oneOf"

    public static class valueRestriction_return extends ParserRuleReturnScope {
        OPPLSyntaxTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "valueRestriction"
    // MOWLParser.g:213:1: valueRestriction : propertyExpression VALUE value -> ^( VALUE_RESTRICTION propertyExpression value ) ;
    public final OPPLPatternScript_OPPLParser_MOWLParser.valueRestriction_return valueRestriction() throws RecognitionException {
        OPPLPatternScript_OPPLParser_MOWLParser.valueRestriction_return retval = new OPPLPatternScript_OPPLParser_MOWLParser.valueRestriction_return();
        retval.start = input.LT(1);

        OPPLSyntaxTree root_0 = null;

        Token VALUE105=null;
        OPPLPatternScript_OPPLParser_MOWLParser.propertyExpression_return propertyExpression104 = null;

        OPPLPatternScript_OPPLParser_MOWLParser.value_return value106 = null;


        OPPLSyntaxTree VALUE105_tree=null;
        RewriteRuleTokenStream stream_VALUE=new RewriteRuleTokenStream(adaptor,"token VALUE");
        RewriteRuleSubtreeStream stream_propertyExpression=new RewriteRuleSubtreeStream(adaptor,"rule propertyExpression");
        RewriteRuleSubtreeStream stream_value=new RewriteRuleSubtreeStream(adaptor,"rule value");
        try {
            // MOWLParser.g:213:18: ( propertyExpression VALUE value -> ^( VALUE_RESTRICTION propertyExpression value ) )
            // MOWLParser.g:213:20: propertyExpression VALUE value
            {
            pushFollow(FOLLOW_propertyExpression_in_valueRestriction1952);
            propertyExpression104=propertyExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_propertyExpression.add(propertyExpression104.getTree());
            VALUE105=(Token)match(input,VALUE,FOLLOW_VALUE_in_valueRestriction1954); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_VALUE.add(VALUE105);

            pushFollow(FOLLOW_value_in_valueRestriction1956);
            value106=value();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_value.add(value106.getTree());


            // AST REWRITE
            // elements: value, propertyExpression
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (OPPLSyntaxTree)adaptor.nil();
            // 213:51: -> ^( VALUE_RESTRICTION propertyExpression value )
            {
                // MOWLParser.g:213:54: ^( VALUE_RESTRICTION propertyExpression value )
                {
                OPPLSyntaxTree root_1 = (OPPLSyntaxTree)adaptor.nil();
                root_1 = (OPPLSyntaxTree)adaptor.becomeRoot((OPPLSyntaxTree)adaptor.create(VALUE_RESTRICTION, "VALUE_RESTRICTION"), root_1);

                adaptor.addChild(root_1, stream_propertyExpression.nextTree());
                adaptor.addChild(root_1, stream_value.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (OPPLSyntaxTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

          catch(RecognitionException e){
            throw e;
          }
          
          catch(RewriteEmptyStreamException e){
            throw e;
          }
        finally {
        }
        return retval;
    }
    // $ANTLR end "valueRestriction"

    public static class value_return extends ParserRuleReturnScope {
        OPPLSyntaxTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "value"
    // MOWLParser.g:216:1: value : ( atomic -> ^( atomic ) | constant -> ^( constant ) );
    public final OPPLPatternScript_OPPLParser_MOWLParser.value_return value() throws RecognitionException {
        OPPLPatternScript_OPPLParser_MOWLParser.value_return retval = new OPPLPatternScript_OPPLParser_MOWLParser.value_return();
        retval.start = input.LT(1);

        OPPLSyntaxTree root_0 = null;

        OPPLPatternScriptParser.atomic_return atomic107 = null;

        OPPLPatternScript_OPPLParser_MOWLParser.constant_return constant108 = null;


        RewriteRuleSubtreeStream stream_atomic=new RewriteRuleSubtreeStream(adaptor,"rule atomic");
        RewriteRuleSubtreeStream stream_constant=new RewriteRuleSubtreeStream(adaptor,"rule constant");
        try {
            // MOWLParser.g:216:6: ( atomic -> ^( atomic ) | constant -> ^( constant ) )
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( ((LA22_0>=IDENTIFIER && LA22_0<=ENTITY_REFERENCE)||LA22_0==ESCLAMATION_MARK||LA22_0==DOLLAR||LA22_0==THIS_CLASS||LA22_0==VARIABLE_NAME) ) {
                alt22=1;
            }
            else if ( (LA22_0==DBLQUOTE) ) {
                alt22=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 22, 0, input);

                throw nvae;
            }
            switch (alt22) {
                case 1 :
                    // MOWLParser.g:217:7: atomic
                    {
                    pushFollow(FOLLOW_atomic_in_value1981);
                    atomic107=gOPPLPatternScript.atomic();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_atomic.add(atomic107.getTree());


                    // AST REWRITE
                    // elements: atomic
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (OPPLSyntaxTree)adaptor.nil();
                    // 217:14: -> ^( atomic )
                    {
                        // MOWLParser.g:217:17: ^( atomic )
                        {
                        OPPLSyntaxTree root_1 = (OPPLSyntaxTree)adaptor.nil();
                        root_1 = (OPPLSyntaxTree)adaptor.becomeRoot(stream_atomic.nextNode(), root_1);

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 2 :
                    // MOWLParser.g:218:7: constant
                    {
                    pushFollow(FOLLOW_constant_in_value1996);
                    constant108=constant();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_constant.add(constant108.getTree());


                    // AST REWRITE
                    // elements: constant
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (OPPLSyntaxTree)adaptor.nil();
                    // 218:16: -> ^( constant )
                    {
                        // MOWLParser.g:218:19: ^( constant )
                        {
                        OPPLSyntaxTree root_1 = (OPPLSyntaxTree)adaptor.nil();
                        root_1 = (OPPLSyntaxTree)adaptor.becomeRoot(stream_constant.nextNode(), root_1);

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (OPPLSyntaxTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

          catch(RecognitionException e){
            throw e;
          }
          
          catch(RewriteEmptyStreamException e){
            throw e;
          }
        finally {
        }
        return retval;
    }
    // $ANTLR end "value"

    public static class constant_return extends ParserRuleReturnScope {
        OPPLSyntaxTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "constant"
    // MOWLParser.g:221:1: constant : constantValue= DBLQUOTE ( POW type= IDENTIFIER )? -> ^( CONSTANT $constantValue ( $type)? ) ;
    public final OPPLPatternScript_OPPLParser_MOWLParser.constant_return constant() throws RecognitionException {
        OPPLPatternScript_OPPLParser_MOWLParser.constant_return retval = new OPPLPatternScript_OPPLParser_MOWLParser.constant_return();
        retval.start = input.LT(1);

        OPPLSyntaxTree root_0 = null;

        Token constantValue=null;
        Token type=null;
        Token POW109=null;

        OPPLSyntaxTree constantValue_tree=null;
        OPPLSyntaxTree type_tree=null;
        OPPLSyntaxTree POW109_tree=null;
        RewriteRuleTokenStream stream_DBLQUOTE=new RewriteRuleTokenStream(adaptor,"token DBLQUOTE");
        RewriteRuleTokenStream stream_POW=new RewriteRuleTokenStream(adaptor,"token POW");
        RewriteRuleTokenStream stream_IDENTIFIER=new RewriteRuleTokenStream(adaptor,"token IDENTIFIER");

        try {
            // MOWLParser.g:221:11: (constantValue= DBLQUOTE ( POW type= IDENTIFIER )? -> ^( CONSTANT $constantValue ( $type)? ) )
            // MOWLParser.g:221:14: constantValue= DBLQUOTE ( POW type= IDENTIFIER )?
            {
            constantValue=(Token)match(input,DBLQUOTE,FOLLOW_DBLQUOTE_in_constant2021); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_DBLQUOTE.add(constantValue);

            // MOWLParser.g:221:39: ( POW type= IDENTIFIER )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==POW) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // MOWLParser.g:221:41: POW type= IDENTIFIER
                    {
                    POW109=(Token)match(input,POW,FOLLOW_POW_in_constant2025); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_POW.add(POW109);

                    type=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_constant2031); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_IDENTIFIER.add(type);


                    }
                    break;

            }



            // AST REWRITE
            // elements: type, constantValue
            // token labels: type, constantValue
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleTokenStream stream_type=new RewriteRuleTokenStream(adaptor,"token type",type);
            RewriteRuleTokenStream stream_constantValue=new RewriteRuleTokenStream(adaptor,"token constantValue",constantValue);
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (OPPLSyntaxTree)adaptor.nil();
            // 221:65: -> ^( CONSTANT $constantValue ( $type)? )
            {
                // MOWLParser.g:221:67: ^( CONSTANT $constantValue ( $type)? )
                {
                OPPLSyntaxTree root_1 = (OPPLSyntaxTree)adaptor.nil();
                root_1 = (OPPLSyntaxTree)adaptor.becomeRoot((OPPLSyntaxTree)adaptor.create(CONSTANT, "CONSTANT"), root_1);

                adaptor.addChild(root_1, stream_constantValue.nextNode());
                // MOWLParser.g:221:93: ( $type)?
                if ( stream_type.hasNext() ) {
                    adaptor.addChild(root_1, stream_type.nextNode());

                }
                stream_type.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (OPPLSyntaxTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

          catch(RecognitionException e){
            throw e;
          }
          
          catch(RewriteEmptyStreamException e){
            throw e;
          }
        finally {
        }
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
        if (state.failed) return ;

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
        if (state.failed) return ;

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
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred4_MOWLParser

    // $ANTLR start synpred5_MOWLParser
    public final void synpred5_MOWLParser_fragment() throws RecognitionException {   
        OPPLPatternScriptParser.atomic_return p = null;

        OPPLPatternScript_OPPLParser_MOWLParser.constant_return o = null;


        // MOWLParser.g:74:3: ( iri p= atomic o= constant )
        // MOWLParser.g:74:3: iri p= atomic o= constant
        {
        pushFollow(FOLLOW_iri_in_synpred5_MOWLParser311);
        gOPPLParser.iri();

        state._fsp--;
        if (state.failed) return ;
        pushFollow(FOLLOW_atomic_in_synpred5_MOWLParser316);
        p=gOPPLPatternScript.atomic();

        state._fsp--;
        if (state.failed) return ;
        pushFollow(FOLLOW_constant_in_synpred5_MOWLParser322);
        o=constant();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred5_MOWLParser

    // $ANTLR start synpred6_MOWLParser
    public final void synpred6_MOWLParser_fragment() throws RecognitionException {   
        OPPLPatternScriptParser.atomic_return i = null;


        // MOWLParser.g:92:3: (i= atomic ( INSTANCE_OF | TYPES ) expression )
        // MOWLParser.g:92:3: i= atomic ( INSTANCE_OF | TYPES ) expression
        {
        pushFollow(FOLLOW_atomic_in_synpred6_MOWLParser479);
        i=gOPPLPatternScript.atomic();

        state._fsp--;
        if (state.failed) return ;
        if ( (input.LA(1)>=INSTANCE_OF && input.LA(1)<=TYPES) ) {
            input.consume();
            state.errorRecovery=false;state.failed=false;
        }
        else {
            if (state.backtracking>0) {state.failed=true; return ;}
            MismatchedSetException mse = new MismatchedSetException(null,input);
            throw mse;
        }

        pushFollow(FOLLOW_expression_in_synpred6_MOWLParser489);
        expression();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred6_MOWLParser

    // $ANTLR start synpred7_MOWLParser
    public final void synpred7_MOWLParser_fragment() throws RecognitionException {   
        OPPLPatternScriptParser.atomic_return subject = null;


        // MOWLParser.g:93:7: (subject= atomic propertyExpression value )
        // MOWLParser.g:93:7: subject= atomic propertyExpression value
        {
        pushFollow(FOLLOW_atomic_in_synpred7_MOWLParser520);
        subject=gOPPLPatternScript.atomic();

        state._fsp--;
        if (state.failed) return ;
        pushFollow(FOLLOW_propertyExpression_in_synpred7_MOWLParser522);
        propertyExpression();

        state._fsp--;
        if (state.failed) return ;
        pushFollow(FOLLOW_value_in_synpred7_MOWLParser525);
        value();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred7_MOWLParser

    // $ANTLR start synpred8_MOWLParser
    public final void synpred8_MOWLParser_fragment() throws RecognitionException {   
        OPPLPatternScript_OPPLParser_MOWLParser.expression_return lhs = null;

        OPPLPatternScript_OPPLParser_MOWLParser.expression_return superClass = null;


        // MOWLParser.g:103:2: (lhs= expression SUBCLASS_OF superClass= expression )
        // MOWLParser.g:103:2: lhs= expression SUBCLASS_OF superClass= expression
        {
        pushFollow(FOLLOW_expression_in_synpred8_MOWLParser600);
        lhs=expression();

        state._fsp--;
        if (state.failed) return ;
        match(input,SUBCLASS_OF,FOLLOW_SUBCLASS_OF_in_synpred8_MOWLParser602); if (state.failed) return ;
        pushFollow(FOLLOW_expression_in_synpred8_MOWLParser609);
        superClass=expression();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred8_MOWLParser

    // $ANTLR start synpred9_MOWLParser
    public final void synpred9_MOWLParser_fragment() throws RecognitionException {   
        OPPLPatternScript_OPPLParser_MOWLParser.expression_return lhs = null;

        OPPLPatternScript_OPPLParser_MOWLParser.expression_return rhs = null;


        // MOWLParser.g:104:11: (lhs= expression EQUIVALENT_TO rhs= expression )
        // MOWLParser.g:104:11: lhs= expression EQUIVALENT_TO rhs= expression
        {
        pushFollow(FOLLOW_expression_in_synpred9_MOWLParser647);
        lhs=expression();

        state._fsp--;
        if (state.failed) return ;
        match(input,EQUIVALENT_TO,FOLLOW_EQUIVALENT_TO_in_synpred9_MOWLParser649); if (state.failed) return ;
        pushFollow(FOLLOW_expression_in_synpred9_MOWLParser655);
        rhs=expression();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred9_MOWLParser

    // $ANTLR start synpred10_MOWLParser
    public final void synpred10_MOWLParser_fragment() throws RecognitionException {   
        OPPLPatternScript_OPPLParser_MOWLParser.expression_return lhs = null;

        OPPLPatternScript_OPPLParser_MOWLParser.expression_return disjoint = null;


        // MOWLParser.g:105:11: (lhs= expression DISJOINT_WITH disjoint= expression )
        // MOWLParser.g:105:11: lhs= expression DISJOINT_WITH disjoint= expression
        {
        pushFollow(FOLLOW_expression_in_synpred10_MOWLParser692);
        lhs=expression();

        state._fsp--;
        if (state.failed) return ;
        match(input,DISJOINT_WITH,FOLLOW_DISJOINT_WITH_in_synpred10_MOWLParser694); if (state.failed) return ;
        pushFollow(FOLLOW_expression_in_synpred10_MOWLParser700);
        disjoint=expression();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred10_MOWLParser

    // $ANTLR start synpred11_MOWLParser
    public final void synpred11_MOWLParser_fragment() throws RecognitionException {   
        OPPLPatternScript_OPPLParser_MOWLParser.expression_return lhs = null;

        OPPLPatternScript_OPPLParser_MOWLParser.propertyExpression_return superProperty = null;


        // MOWLParser.g:106:11: (lhs= expression SUB_PROPERTY_OF superProperty= propertyExpression )
        // MOWLParser.g:106:11: lhs= expression SUB_PROPERTY_OF superProperty= propertyExpression
        {
        pushFollow(FOLLOW_expression_in_synpred11_MOWLParser737);
        lhs=expression();

        state._fsp--;
        if (state.failed) return ;
        match(input,SUB_PROPERTY_OF,FOLLOW_SUB_PROPERTY_OF_in_synpred11_MOWLParser739); if (state.failed) return ;
        pushFollow(FOLLOW_propertyExpression_in_synpred11_MOWLParser745);
        superProperty=propertyExpression();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred11_MOWLParser

    // $ANTLR start synpred12_MOWLParser
    public final void synpred12_MOWLParser_fragment() throws RecognitionException {   
        OPPLPatternScriptParser.atomic_return lhsID = null;

        OPPLPatternScriptParser.atomic_return rhsAtomic = null;


        // MOWLParser.g:107:11: (lhsID= atomic INVERSE_OF rhsAtomic= atomic )
        // MOWLParser.g:107:11: lhsID= atomic INVERSE_OF rhsAtomic= atomic
        {
        pushFollow(FOLLOW_atomic_in_synpred12_MOWLParser782);
        lhsID=gOPPLPatternScript.atomic();

        state._fsp--;
        if (state.failed) return ;
        match(input,INVERSE_OF,FOLLOW_INVERSE_OF_in_synpred12_MOWLParser784); if (state.failed) return ;
        pushFollow(FOLLOW_atomic_in_synpred12_MOWLParser790);
        rhsAtomic=gOPPLPatternScript.atomic();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred12_MOWLParser

    // $ANTLR start synpred13_MOWLParser
    public final void synpred13_MOWLParser_fragment() throws RecognitionException {   
        OPPLPatternScriptParser.atomic_return lhsID = null;

        OPPLPatternScriptParser.atomic_return rhsID = null;


        // MOWLParser.g:108:3: (lhsID= atomic SAME_AS rhsID= atomic )
        // MOWLParser.g:108:3: lhsID= atomic SAME_AS rhsID= atomic
        {
        pushFollow(FOLLOW_atomic_in_synpred13_MOWLParser821);
        lhsID=gOPPLPatternScript.atomic();

        state._fsp--;
        if (state.failed) return ;
        match(input,SAME_AS,FOLLOW_SAME_AS_in_synpred13_MOWLParser823); if (state.failed) return ;
        pushFollow(FOLLOW_atomic_in_synpred13_MOWLParser830);
        rhsID=gOPPLPatternScript.atomic();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred13_MOWLParser

    // $ANTLR start synpred14_MOWLParser
    public final void synpred14_MOWLParser_fragment() throws RecognitionException {   
        OPPLPatternScriptParser.atomic_return lhsID = null;

        OPPLPatternScriptParser.atomic_return rhsID = null;


        // MOWLParser.g:109:11: (lhsID= atomic DIFFERENT_FROM rhsID= atomic )
        // MOWLParser.g:109:11: lhsID= atomic DIFFERENT_FROM rhsID= atomic
        {
        pushFollow(FOLLOW_atomic_in_synpred14_MOWLParser868);
        lhsID=gOPPLPatternScript.atomic();

        state._fsp--;
        if (state.failed) return ;
        match(input,DIFFERENT_FROM,FOLLOW_DIFFERENT_FROM_in_synpred14_MOWLParser870); if (state.failed) return ;
        pushFollow(FOLLOW_atomic_in_synpred14_MOWLParser877);
        rhsID=gOPPLPatternScript.atomic();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred14_MOWLParser

    // $ANTLR start synpred15_MOWLParser
    public final void synpred15_MOWLParser_fragment() throws RecognitionException {   
        OPPLPatternScriptParser.atomic_return lhsID = null;


        // MOWLParser.g:110:11: (lhsID= atomic DOMAIN expression )
        // MOWLParser.g:110:11: lhsID= atomic DOMAIN expression
        {
        pushFollow(FOLLOW_atomic_in_synpred15_MOWLParser914);
        lhsID=gOPPLPatternScript.atomic();

        state._fsp--;
        if (state.failed) return ;
        match(input,DOMAIN,FOLLOW_DOMAIN_in_synpred15_MOWLParser917); if (state.failed) return ;
        pushFollow(FOLLOW_expression_in_synpred15_MOWLParser919);
        expression();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred15_MOWLParser

    // $ANTLR start synpred16_MOWLParser
    public final void synpred16_MOWLParser_fragment() throws RecognitionException {   
        // MOWLParser.g:132:5: ( conjunction ( OR conjunction )* )
        // MOWLParser.g:132:5: conjunction ( OR conjunction )*
        {
        pushFollow(FOLLOW_conjunction_in_synpred16_MOWLParser1208);
        conjunction();

        state._fsp--;
        if (state.failed) return ;
        // MOWLParser.g:132:17: ( OR conjunction )*
        loop24:
        do {
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==OR) ) {
                alt24=1;
            }


            switch (alt24) {
        	case 1 :
        	    // MOWLParser.g:132:18: OR conjunction
        	    {
        	    match(input,OR,FOLLOW_OR_in_synpred16_MOWLParser1211); if (state.failed) return ;
        	    pushFollow(FOLLOW_conjunction_in_synpred16_MOWLParser1213);
        	    conjunction();

        	    state._fsp--;
        	    if (state.failed) return ;

        	    }
        	    break;

        	default :
        	    break loop24;
            }
        } while (true);


        }
    }
    // $ANTLR end synpred16_MOWLParser

    // $ANTLR start synpred17_MOWLParser
    public final void synpred17_MOWLParser_fragment() throws RecognitionException {   
        // MOWLParser.g:133:6: ( complexPropertyExpression )
        // MOWLParser.g:133:6: complexPropertyExpression
        {
        pushFollow(FOLLOW_complexPropertyExpression_in_synpred17_MOWLParser1232);
        complexPropertyExpression();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred17_MOWLParser

    // $ANTLR start synpred18_MOWLParser
    public final void synpred18_MOWLParser_fragment() throws RecognitionException {   
        List list_rest=null;
        OPPLPatternScript_OPPLParser_MOWLParser.propertyExpression_return head = null;

        RuleReturnScope rest = null;
        // MOWLParser.g:153:4: (head= propertyExpression ( COMPOSITION rest+= propertyExpression )+ )
        // MOWLParser.g:153:4: head= propertyExpression ( COMPOSITION rest+= propertyExpression )+
        {
        pushFollow(FOLLOW_propertyExpression_in_synpred18_MOWLParser1370);
        head=propertyExpression();

        state._fsp--;
        if (state.failed) return ;
        // MOWLParser.g:153:30: ( COMPOSITION rest+= propertyExpression )+
        int cnt25=0;
        loop25:
        do {
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==COMPOSITION) ) {
                alt25=1;
            }


            switch (alt25) {
        	case 1 :
        	    // MOWLParser.g:153:31: COMPOSITION rest+= propertyExpression
        	    {
        	    match(input,COMPOSITION,FOLLOW_COMPOSITION_in_synpred18_MOWLParser1373); if (state.failed) return ;
        	    pushFollow(FOLLOW_propertyExpression_in_synpred18_MOWLParser1377);
        	    rest=propertyExpression();

        	    state._fsp--;
        	    if (state.failed) return ;
        	    if (list_rest==null) list_rest=new ArrayList();
        	    list_rest.add(rest);


        	    }
        	    break;

        	default :
        	    if ( cnt25 >= 1 ) break loop25;
        	    if (state.backtracking>0) {state.failed=true; return ;}
                    EarlyExitException eee =
                        new EarlyExitException(25, input);
                    throw eee;
            }
            cnt25++;
        } while (true);


        }
    }
    // $ANTLR end synpred18_MOWLParser

    // $ANTLR start synpred19_MOWLParser
    public final void synpred19_MOWLParser_fragment() throws RecognitionException {   
        // MOWLParser.g:154:5: ( NOT OPEN_PARENTHESYS expression CLOSED_PARENTHESYS )
        // MOWLParser.g:154:5: NOT OPEN_PARENTHESYS expression CLOSED_PARENTHESYS
        {
        match(input,NOT,FOLLOW_NOT_in_synpred19_MOWLParser1399); if (state.failed) return ;
        match(input,OPEN_PARENTHESYS,FOLLOW_OPEN_PARENTHESYS_in_synpred19_MOWLParser1401); if (state.failed) return ;
        pushFollow(FOLLOW_expression_in_synpred19_MOWLParser1403);
        expression();

        state._fsp--;
        if (state.failed) return ;
        match(input,CLOSED_PARENTHESYS,FOLLOW_CLOSED_PARENTHESYS_in_synpred19_MOWLParser1405); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred19_MOWLParser

    // $ANTLR start synpred20_MOWLParser
    public final void synpred20_MOWLParser_fragment() throws RecognitionException {   
        // MOWLParser.g:155:5: ( NOT atomic )
        // MOWLParser.g:155:5: NOT atomic
        {
        match(input,NOT,FOLLOW_NOT_in_synpred20_MOWLParser1419); if (state.failed) return ;
        pushFollow(FOLLOW_atomic_in_synpred20_MOWLParser1421);
        gOPPLPatternScript.atomic();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred20_MOWLParser

    // $ANTLR start synpred21_MOWLParser
    public final void synpred21_MOWLParser_fragment() throws RecognitionException {   
        // MOWLParser.g:156:5: ( qualifiedRestriction )
        // MOWLParser.g:156:5: qualifiedRestriction
        {
        pushFollow(FOLLOW_qualifiedRestriction_in_synpred21_MOWLParser1444);
        qualifiedRestriction();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred21_MOWLParser

    // $ANTLR start synpred22_MOWLParser
    public final void synpred22_MOWLParser_fragment() throws RecognitionException {   
        // MOWLParser.g:157:5: ( dataRange )
        // MOWLParser.g:157:5: dataRange
        {
        pushFollow(FOLLOW_dataRange_in_synpred22_MOWLParser1456);
        dataRange();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred22_MOWLParser

    // $ANTLR start synpred24_MOWLParser
    public final void synpred24_MOWLParser_fragment() throws RecognitionException {   
        // MOWLParser.g:184:7: ( propertyExpression SOME expression )
        // MOWLParser.g:184:7: propertyExpression SOME expression
        {
        pushFollow(FOLLOW_propertyExpression_in_synpred24_MOWLParser1655);
        propertyExpression();

        state._fsp--;
        if (state.failed) return ;
        match(input,SOME,FOLLOW_SOME_in_synpred24_MOWLParser1658); if (state.failed) return ;
        pushFollow(FOLLOW_expression_in_synpred24_MOWLParser1662);
        expression();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred24_MOWLParser

    // $ANTLR start synpred25_MOWLParser
    public final void synpred25_MOWLParser_fragment() throws RecognitionException {   
        // MOWLParser.g:185:7: ( propertyExpression ONLY expression )
        // MOWLParser.g:185:7: propertyExpression ONLY expression
        {
        pushFollow(FOLLOW_propertyExpression_in_synpred25_MOWLParser1691);
        propertyExpression();

        state._fsp--;
        if (state.failed) return ;
        match(input,ONLY,FOLLOW_ONLY_in_synpred25_MOWLParser1693); if (state.failed) return ;
        pushFollow(FOLLOW_expression_in_synpred25_MOWLParser1696);
        expression();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred25_MOWLParser

    // $ANTLR start synpred26_MOWLParser
    public final void synpred26_MOWLParser_fragment() throws RecognitionException {   
        // MOWLParser.g:186:7: ( cardinalityRestriction )
        // MOWLParser.g:186:7: cardinalityRestriction
        {
        pushFollow(FOLLOW_cardinalityRestriction_in_synpred26_MOWLParser1715);
        cardinalityRestriction();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred26_MOWLParser

    // Delegated rules

    public final boolean synpred22_MOWLParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred22_MOWLParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred1_MOWLParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred1_MOWLParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred9_MOWLParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred9_MOWLParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred26_MOWLParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred26_MOWLParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred25_MOWLParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred25_MOWLParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred24_MOWLParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred24_MOWLParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred14_MOWLParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred14_MOWLParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred6_MOWLParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred6_MOWLParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred10_MOWLParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred10_MOWLParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred16_MOWLParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred16_MOWLParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred3_MOWLParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred3_MOWLParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred8_MOWLParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred8_MOWLParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred12_MOWLParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred12_MOWLParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred20_MOWLParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred20_MOWLParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred4_MOWLParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred4_MOWLParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred11_MOWLParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred11_MOWLParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred15_MOWLParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred15_MOWLParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred13_MOWLParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred13_MOWLParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred19_MOWLParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred19_MOWLParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred18_MOWLParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred18_MOWLParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred17_MOWLParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred17_MOWLParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred21_MOWLParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred21_MOWLParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred5_MOWLParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred5_MOWLParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred7_MOWLParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred7_MOWLParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


    protected DFA1 dfa1 = new DFA1(this);
    protected DFA5 dfa5 = new DFA5(this);
    protected DFA6 dfa6 = new DFA6(this);
    protected DFA9 dfa9 = new DFA9(this);
    protected DFA13 dfa13 = new DFA13(this);
    protected DFA17 dfa17 = new DFA17(this);
    static final String DFA1_eotS =
        "\27\uffff";
    static final String DFA1_eofS =
        "\27\uffff";
    static final String DFA1_minS =
        "\1\5\13\0\13\uffff";
    static final String DFA1_maxS =
        "\1\u01d0\13\0\13\uffff";
    static final String DFA1_acceptS =
        "\14\uffff\1\2\6\uffff\1\5\1\1\1\3\1\4";
    static final String DFA1_specialS =
        "\1\uffff\1\0\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\13\uffff}>";
    static final String[] DFA1_transitionS = {
            "\1\13\1\11\5\uffff\1\10\6\uffff\1\7\11\uffff\7\14\4\uffff\1"+
            "\12\3\uffff\1\2\1\3\100\uffff\1\23\46\uffff\1\5\u00fa\uffff"+
            "\1\6\17\uffff\1\1\57\uffff\1\4",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

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
        for (int i=0; i<numStates; i++) {
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
        public String getDescription() {
            return "64:1: axiom options {backtrack=true; } : ( binaryAxiom -> ^( binaryAxiom ) | unaryAxiom -> ^( unaryAxiom ) | assertionAxiom -> ^( assertionAxiom ) | hasKeyAxiom -> ^( hasKeyAxiom ) | annotationAssertionAxiom -> ^( annotationAssertionAxiom ) );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA1_1 = input.LA(1);

                         
                        int index1_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred1_MOWLParser()) ) {s = 20;}

                        else if ( (synpred3_MOWLParser()) ) {s = 21;}

                        else if ( (synpred4_MOWLParser()) ) {s = 22;}

                         
                        input.seek(index1_1);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA1_2 = input.LA(1);

                         
                        int index1_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred1_MOWLParser()) ) {s = 20;}

                        else if ( (synpred3_MOWLParser()) ) {s = 21;}

                        else if ( (synpred4_MOWLParser()) ) {s = 22;}

                         
                        input.seek(index1_2);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA1_3 = input.LA(1);

                         
                        int index1_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred1_MOWLParser()) ) {s = 20;}

                        else if ( (synpred3_MOWLParser()) ) {s = 21;}

                        else if ( (synpred4_MOWLParser()) ) {s = 22;}

                         
                        input.seek(index1_3);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA1_4 = input.LA(1);

                         
                        int index1_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred1_MOWLParser()) ) {s = 20;}

                        else if ( (synpred3_MOWLParser()) ) {s = 21;}

                        else if ( (synpred4_MOWLParser()) ) {s = 22;}

                        else if ( (true) ) {s = 19;}

                         
                        input.seek(index1_4);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA1_5 = input.LA(1);

                         
                        int index1_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred1_MOWLParser()) ) {s = 20;}

                        else if ( (synpred3_MOWLParser()) ) {s = 21;}

                        else if ( (synpred4_MOWLParser()) ) {s = 22;}

                         
                        input.seek(index1_5);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA1_6 = input.LA(1);

                         
                        int index1_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred1_MOWLParser()) ) {s = 20;}

                        else if ( (synpred3_MOWLParser()) ) {s = 21;}

                        else if ( (synpred4_MOWLParser()) ) {s = 22;}

                         
                        input.seek(index1_6);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA1_7 = input.LA(1);

                         
                        int index1_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred1_MOWLParser()) ) {s = 20;}

                        else if ( (synpred4_MOWLParser()) ) {s = 22;}

                         
                        input.seek(index1_7);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA1_8 = input.LA(1);

                         
                        int index1_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred1_MOWLParser()) ) {s = 20;}

                        else if ( (synpred3_MOWLParser()) ) {s = 21;}

                        else if ( (synpred4_MOWLParser()) ) {s = 22;}

                         
                        input.seek(index1_8);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA1_9 = input.LA(1);

                         
                        int index1_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred1_MOWLParser()) ) {s = 20;}

                        else if ( (synpred4_MOWLParser()) ) {s = 22;}

                         
                        input.seek(index1_9);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA1_10 = input.LA(1);

                         
                        int index1_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred1_MOWLParser()) ) {s = 20;}

                        else if ( (synpred4_MOWLParser()) ) {s = 22;}

                         
                        input.seek(index1_10);
                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA1_11 = input.LA(1);

                         
                        int index1_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred1_MOWLParser()) ) {s = 20;}

                        else if ( (synpred4_MOWLParser()) ) {s = 22;}

                         
                        input.seek(index1_11);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 1, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA5_eotS =
        "\12\uffff";
    static final String DFA5_eofS =
        "\12\uffff";
    static final String DFA5_minS =
        "\1\14\6\0\3\uffff";
    static final String DFA5_maxS =
        "\1\u01d0\6\0\3\uffff";
    static final String DFA5_acceptS =
        "\7\uffff\1\3\1\1\1\2";
    static final String DFA5_specialS =
        "\1\uffff\1\0\1\1\1\2\1\3\1\4\1\5\3\uffff}>";
    static final String[] DFA5_transitionS = {
            "\1\7\37\uffff\1\2\1\3\147\uffff\1\5\u00fa\uffff\1\6\17\uffff"+
            "\1\1\57\uffff\1\4",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "",
            "",
            ""
    };

    static final short[] DFA5_eot = DFA.unpackEncodedString(DFA5_eotS);
    static final short[] DFA5_eof = DFA.unpackEncodedString(DFA5_eofS);
    static final char[] DFA5_min = DFA.unpackEncodedStringToUnsignedChars(DFA5_minS);
    static final char[] DFA5_max = DFA.unpackEncodedStringToUnsignedChars(DFA5_maxS);
    static final short[] DFA5_accept = DFA.unpackEncodedString(DFA5_acceptS);
    static final short[] DFA5_special = DFA.unpackEncodedString(DFA5_specialS);
    static final short[][] DFA5_transition;

    static {
        int numStates = DFA5_transitionS.length;
        DFA5_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA5_transition[i] = DFA.unpackEncodedString(DFA5_transitionS[i]);
        }
    }

    class DFA5 extends DFA {

        public DFA5(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 5;
            this.eot = DFA5_eot;
            this.eof = DFA5_eof;
            this.min = DFA5_min;
            this.max = DFA5_max;
            this.accept = DFA5_accept;
            this.special = DFA5_special;
            this.transition = DFA5_transition;
        }
        public String getDescription() {
            return "91:1: assertionAxiom options {backtrack=true; } : (i= atomic ( INSTANCE_OF | TYPES ) expression -> ^( TYPE_ASSERTION ^( EXPRESSION expression ) ^( EXPRESSION $i) ) | subject= atomic propertyExpression value -> ^( ROLE_ASSERTION ^( EXPRESSION $subject) ^( EXPRESSION propertyExpression ) ^( EXPRESSION value ) ) | NOT assertionAxiom -> ^( NEGATED_ASSERTION assertionAxiom ) );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA5_1 = input.LA(1);

                         
                        int index5_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_MOWLParser()) ) {s = 8;}

                        else if ( (synpred7_MOWLParser()) ) {s = 9;}

                         
                        input.seek(index5_1);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA5_2 = input.LA(1);

                         
                        int index5_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_MOWLParser()) ) {s = 8;}

                        else if ( (synpred7_MOWLParser()) ) {s = 9;}

                         
                        input.seek(index5_2);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA5_3 = input.LA(1);

                         
                        int index5_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_MOWLParser()) ) {s = 8;}

                        else if ( (synpred7_MOWLParser()) ) {s = 9;}

                         
                        input.seek(index5_3);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA5_4 = input.LA(1);

                         
                        int index5_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_MOWLParser()) ) {s = 8;}

                        else if ( (synpred7_MOWLParser()) ) {s = 9;}

                         
                        input.seek(index5_4);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA5_5 = input.LA(1);

                         
                        int index5_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_MOWLParser()) ) {s = 8;}

                        else if ( (synpred7_MOWLParser()) ) {s = 9;}

                         
                        input.seek(index5_5);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA5_6 = input.LA(1);

                         
                        int index5_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_MOWLParser()) ) {s = 8;}

                        else if ( (synpred7_MOWLParser()) ) {s = 9;}

                         
                        input.seek(index5_6);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 5, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA6_eotS =
        "\25\uffff";
    static final String DFA6_eofS =
        "\25\uffff";
    static final String DFA6_minS =
        "\1\5\13\0\11\uffff";
    static final String DFA6_maxS =
        "\1\u01d0\13\0\11\uffff";
    static final String DFA6_acceptS =
        "\14\uffff\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11";
    static final String DFA6_specialS =
        "\1\uffff\1\0\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\11\uffff}>";
    static final String[] DFA6_transitionS = {
            "\1\13\1\11\5\uffff\1\10\6\uffff\1\7\24\uffff\1\12\3\uffff\1"+
            "\2\1\3\147\uffff\1\5\u00fa\uffff\1\6\17\uffff\1\1\57\uffff\1"+
            "\4",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

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
        for (int i=0; i<numStates; i++) {
            DFA6_transition[i] = DFA.unpackEncodedString(DFA6_transitionS[i]);
        }
    }

    class DFA6 extends DFA {

        public DFA6(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 6;
            this.eot = DFA6_eot;
            this.eof = DFA6_eof;
            this.min = DFA6_min;
            this.max = DFA6_max;
            this.accept = DFA6_accept;
            this.special = DFA6_special;
            this.transition = DFA6_transition;
        }
        public String getDescription() {
            return "100:1: binaryAxiom options {backtrack=true; } : (lhs= expression SUBCLASS_OF superClass= expression -> ^( SUB_CLASS_AXIOM ^( EXPRESSION $lhs) ^( EXPRESSION $superClass) ) | lhs= expression EQUIVALENT_TO rhs= expression -> ^( EQUIVALENT_TO_AXIOM ^( EXPRESSION $lhs) ^( EXPRESSION $rhs) ) | lhs= expression DISJOINT_WITH disjoint= expression -> ^( DISJOINT_WITH_AXIOM ^( EXPRESSION $lhs) ^( EXPRESSION $disjoint) ) | lhs= expression SUB_PROPERTY_OF superProperty= propertyExpression -> ^( SUB_PROPERTY_AXIOM ^( EXPRESSION $lhs) ^( EXPRESSION $superProperty) ) | lhsID= atomic INVERSE_OF rhsAtomic= atomic -> ^( INVERSE_OF ^( EXPRESSION $lhsID) ^( EXPRESSION $rhsAtomic) ) | lhsID= atomic SAME_AS rhsID= atomic -> ^( SAME_AS_AXIOM ^( EXPRESSION $lhsID) ^( EXPRESSION $rhsID) ) | lhsID= atomic DIFFERENT_FROM rhsID= atomic -> ^( DIFFERENT_FROM_AXIOM ^( EXPRESSION $lhsID) ^( EXPRESSION $rhsID) ) | lhsID= atomic DOMAIN expression -> ^( DOMAIN ^( EXPRESSION $lhsID) ^( EXPRESSION expression ) ) | lhsID= atomic RANGE expression -> ^( RANGE ^( EXPRESSION $lhsID) ^( EXPRESSION expression ) ) );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA6_1 = input.LA(1);

                         
                        int index6_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred8_MOWLParser()) ) {s = 12;}

                        else if ( (synpred9_MOWLParser()) ) {s = 13;}

                        else if ( (synpred10_MOWLParser()) ) {s = 14;}

                        else if ( (synpred11_MOWLParser()) ) {s = 15;}

                        else if ( (synpred12_MOWLParser()) ) {s = 16;}

                        else if ( (synpred13_MOWLParser()) ) {s = 17;}

                        else if ( (synpred14_MOWLParser()) ) {s = 18;}

                        else if ( (synpred15_MOWLParser()) ) {s = 19;}

                        else if ( (true) ) {s = 20;}

                         
                        input.seek(index6_1);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA6_2 = input.LA(1);

                         
                        int index6_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred8_MOWLParser()) ) {s = 12;}

                        else if ( (synpred9_MOWLParser()) ) {s = 13;}

                        else if ( (synpred10_MOWLParser()) ) {s = 14;}

                        else if ( (synpred11_MOWLParser()) ) {s = 15;}

                        else if ( (synpred12_MOWLParser()) ) {s = 16;}

                        else if ( (synpred13_MOWLParser()) ) {s = 17;}

                        else if ( (synpred14_MOWLParser()) ) {s = 18;}

                        else if ( (synpred15_MOWLParser()) ) {s = 19;}

                        else if ( (true) ) {s = 20;}

                         
                        input.seek(index6_2);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA6_3 = input.LA(1);

                         
                        int index6_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred8_MOWLParser()) ) {s = 12;}

                        else if ( (synpred9_MOWLParser()) ) {s = 13;}

                        else if ( (synpred10_MOWLParser()) ) {s = 14;}

                        else if ( (synpred11_MOWLParser()) ) {s = 15;}

                        else if ( (synpred12_MOWLParser()) ) {s = 16;}

                        else if ( (synpred13_MOWLParser()) ) {s = 17;}

                        else if ( (synpred14_MOWLParser()) ) {s = 18;}

                        else if ( (synpred15_MOWLParser()) ) {s = 19;}

                        else if ( (true) ) {s = 20;}

                         
                        input.seek(index6_3);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA6_4 = input.LA(1);

                         
                        int index6_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred8_MOWLParser()) ) {s = 12;}

                        else if ( (synpred9_MOWLParser()) ) {s = 13;}

                        else if ( (synpred10_MOWLParser()) ) {s = 14;}

                        else if ( (synpred11_MOWLParser()) ) {s = 15;}

                        else if ( (synpred12_MOWLParser()) ) {s = 16;}

                        else if ( (synpred13_MOWLParser()) ) {s = 17;}

                        else if ( (synpred14_MOWLParser()) ) {s = 18;}

                        else if ( (synpred15_MOWLParser()) ) {s = 19;}

                        else if ( (true) ) {s = 20;}

                         
                        input.seek(index6_4);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA6_5 = input.LA(1);

                         
                        int index6_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred8_MOWLParser()) ) {s = 12;}

                        else if ( (synpred9_MOWLParser()) ) {s = 13;}

                        else if ( (synpred10_MOWLParser()) ) {s = 14;}

                        else if ( (synpred11_MOWLParser()) ) {s = 15;}

                        else if ( (synpred12_MOWLParser()) ) {s = 16;}

                        else if ( (synpred13_MOWLParser()) ) {s = 17;}

                        else if ( (synpred14_MOWLParser()) ) {s = 18;}

                        else if ( (synpred15_MOWLParser()) ) {s = 19;}

                        else if ( (true) ) {s = 20;}

                         
                        input.seek(index6_5);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA6_6 = input.LA(1);

                         
                        int index6_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred8_MOWLParser()) ) {s = 12;}

                        else if ( (synpred9_MOWLParser()) ) {s = 13;}

                        else if ( (synpred10_MOWLParser()) ) {s = 14;}

                        else if ( (synpred11_MOWLParser()) ) {s = 15;}

                        else if ( (synpred12_MOWLParser()) ) {s = 16;}

                        else if ( (synpred13_MOWLParser()) ) {s = 17;}

                        else if ( (synpred14_MOWLParser()) ) {s = 18;}

                        else if ( (synpred15_MOWLParser()) ) {s = 19;}

                        else if ( (true) ) {s = 20;}

                         
                        input.seek(index6_6);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA6_7 = input.LA(1);

                         
                        int index6_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred8_MOWLParser()) ) {s = 12;}

                        else if ( (synpred9_MOWLParser()) ) {s = 13;}

                        else if ( (synpred10_MOWLParser()) ) {s = 14;}

                        else if ( (synpred11_MOWLParser()) ) {s = 15;}

                         
                        input.seek(index6_7);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA6_8 = input.LA(1);

                         
                        int index6_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred8_MOWLParser()) ) {s = 12;}

                        else if ( (synpred9_MOWLParser()) ) {s = 13;}

                        else if ( (synpred10_MOWLParser()) ) {s = 14;}

                        else if ( (synpred11_MOWLParser()) ) {s = 15;}

                         
                        input.seek(index6_8);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA6_9 = input.LA(1);

                         
                        int index6_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred8_MOWLParser()) ) {s = 12;}

                        else if ( (synpred9_MOWLParser()) ) {s = 13;}

                        else if ( (synpred10_MOWLParser()) ) {s = 14;}

                        else if ( (synpred11_MOWLParser()) ) {s = 15;}

                         
                        input.seek(index6_9);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA6_10 = input.LA(1);

                         
                        int index6_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred8_MOWLParser()) ) {s = 12;}

                        else if ( (synpred9_MOWLParser()) ) {s = 13;}

                        else if ( (synpred10_MOWLParser()) ) {s = 14;}

                        else if ( (synpred11_MOWLParser()) ) {s = 15;}

                         
                        input.seek(index6_10);
                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA6_11 = input.LA(1);

                         
                        int index6_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred8_MOWLParser()) ) {s = 12;}

                        else if ( (synpred9_MOWLParser()) ) {s = 13;}

                        else if ( (synpred10_MOWLParser()) ) {s = 14;}

                        else if ( (synpred11_MOWLParser()) ) {s = 15;}

                         
                        input.seek(index6_11);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 6, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA9_eotS =
        "\15\uffff";
    static final String DFA9_eofS =
        "\15\uffff";
    static final String DFA9_minS =
        "\1\5\6\uffff\1\0\5\uffff";
    static final String DFA9_maxS =
        "\1\u01d0\6\uffff\1\0\5\uffff";
    static final String DFA9_acceptS =
        "\1\uffff\1\1\11\uffff\1\3\1\2";
    static final String DFA9_specialS =
        "\7\uffff\1\0\5\uffff}>";
    static final String[] DFA9_transitionS = {
            "\1\13\1\1\5\uffff\1\1\6\uffff\1\7\24\uffff\1\1\3\uffff\2\1\147"+
            "\uffff\1\1\u00fa\uffff\1\1\17\uffff\1\1\57\uffff\1\1",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\uffff",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA9_eot = DFA.unpackEncodedString(DFA9_eotS);
    static final short[] DFA9_eof = DFA.unpackEncodedString(DFA9_eofS);
    static final char[] DFA9_min = DFA.unpackEncodedStringToUnsignedChars(DFA9_minS);
    static final char[] DFA9_max = DFA.unpackEncodedStringToUnsignedChars(DFA9_maxS);
    static final short[] DFA9_accept = DFA.unpackEncodedString(DFA9_acceptS);
    static final short[] DFA9_special = DFA.unpackEncodedString(DFA9_specialS);
    static final short[][] DFA9_transition;

    static {
        int numStates = DFA9_transitionS.length;
        DFA9_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA9_transition[i] = DFA.unpackEncodedString(DFA9_transitionS[i]);
        }
    }

    class DFA9 extends DFA {

        public DFA9(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 9;
            this.eot = DFA9_eot;
            this.eof = DFA9_eof;
            this.min = DFA9_min;
            this.max = DFA9_max;
            this.accept = DFA9_accept;
            this.special = DFA9_special;
            this.transition = DFA9_transition;
        }
        public String getDescription() {
            return "130:5: ( options {backtrack=true; } : conjunction ( OR conjunction )* -> ^( DISJUNCTION ( conjunction )+ ) | complexPropertyExpression -> ^( complexPropertyExpression ) | OPEN_PARENTHESYS expression CLOSED_PARENTHESYS -> ^( expression ) )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA9_7 = input.LA(1);

                         
                        int index9_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred16_MOWLParser()) ) {s = 1;}

                        else if ( (synpred17_MOWLParser()) ) {s = 12;}

                         
                        input.seek(index9_7);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 9, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA13_eotS =
        "\20\uffff";
    static final String DFA13_eofS =
        "\20\uffff";
    static final String DFA13_minS =
        "\1\6\10\0\7\uffff";
    static final String DFA13_maxS =
        "\1\u01d0\10\0\7\uffff";
    static final String DFA13_acceptS =
        "\11\uffff\1\4\1\6\1\1\1\7\1\5\1\2\1\3";
    static final String DFA13_specialS =
        "\1\uffff\1\0\1\1\1\2\1\3\1\4\1\5\1\6\1\7\7\uffff}>";
    static final String[] DFA13_transitionS = {
            "\1\11\5\uffff\1\10\6\uffff\1\7\24\uffff\1\12\3\uffff\1\2\1\3"+
            "\147\uffff\1\5\u00fa\uffff\1\6\17\uffff\1\1\57\uffff\1\4",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA13_eot = DFA.unpackEncodedString(DFA13_eotS);
    static final short[] DFA13_eof = DFA.unpackEncodedString(DFA13_eofS);
    static final char[] DFA13_min = DFA.unpackEncodedStringToUnsignedChars(DFA13_minS);
    static final char[] DFA13_max = DFA.unpackEncodedStringToUnsignedChars(DFA13_maxS);
    static final short[] DFA13_accept = DFA.unpackEncodedString(DFA13_acceptS);
    static final short[] DFA13_special = DFA.unpackEncodedString(DFA13_specialS);
    static final short[][] DFA13_transition;

    static {
        int numStates = DFA13_transitionS.length;
        DFA13_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA13_transition[i] = DFA.unpackEncodedString(DFA13_transitionS[i]);
        }
    }

    class DFA13 extends DFA {

        public DFA13(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 13;
            this.eot = DFA13_eot;
            this.eof = DFA13_eof;
            this.min = DFA13_min;
            this.max = DFA13_max;
            this.accept = DFA13_accept;
            this.special = DFA13_special;
            this.transition = DFA13_transition;
        }
        public String getDescription() {
            return "151:1: unary options {backtrack=true; } : (head= propertyExpression ( COMPOSITION rest+= propertyExpression )+ -> ^( PROPERTY_CHAIN $head $rest) | NOT OPEN_PARENTHESYS expression CLOSED_PARENTHESYS -> ^( NEGATED_EXPRESSION expression ) | NOT atomic -> ^( NEGATED_EXPRESSION atomic ) | qualifiedRestriction -> ^( qualifiedRestriction ) | dataRange | constant | atomic );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA13_1 = input.LA(1);

                         
                        int index13_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred18_MOWLParser()) ) {s = 11;}

                        else if ( (synpred21_MOWLParser()) ) {s = 9;}

                        else if ( (true) ) {s = 12;}

                         
                        input.seek(index13_1);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA13_2 = input.LA(1);

                         
                        int index13_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred18_MOWLParser()) ) {s = 11;}

                        else if ( (synpred21_MOWLParser()) ) {s = 9;}

                        else if ( (synpred22_MOWLParser()) ) {s = 13;}

                        else if ( (true) ) {s = 12;}

                         
                        input.seek(index13_2);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA13_3 = input.LA(1);

                         
                        int index13_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred18_MOWLParser()) ) {s = 11;}

                        else if ( (synpred21_MOWLParser()) ) {s = 9;}

                        else if ( (true) ) {s = 12;}

                         
                        input.seek(index13_3);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA13_4 = input.LA(1);

                         
                        int index13_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred18_MOWLParser()) ) {s = 11;}

                        else if ( (synpred21_MOWLParser()) ) {s = 9;}

                        else if ( (true) ) {s = 12;}

                         
                        input.seek(index13_4);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA13_5 = input.LA(1);

                         
                        int index13_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred18_MOWLParser()) ) {s = 11;}

                        else if ( (synpred21_MOWLParser()) ) {s = 9;}

                        else if ( (true) ) {s = 12;}

                         
                        input.seek(index13_5);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA13_6 = input.LA(1);

                         
                        int index13_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred18_MOWLParser()) ) {s = 11;}

                        else if ( (synpred21_MOWLParser()) ) {s = 9;}

                        else if ( (true) ) {s = 12;}

                         
                        input.seek(index13_6);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA13_7 = input.LA(1);

                         
                        int index13_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred18_MOWLParser()) ) {s = 11;}

                        else if ( (synpred21_MOWLParser()) ) {s = 9;}

                         
                        input.seek(index13_7);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA13_8 = input.LA(1);

                         
                        int index13_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred19_MOWLParser()) ) {s = 14;}

                        else if ( (synpred20_MOWLParser()) ) {s = 15;}

                         
                        input.seek(index13_8);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 13, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA17_eotS =
        "\15\uffff";
    static final String DFA17_eofS =
        "\15\uffff";
    static final String DFA17_minS =
        "\1\6\7\0\5\uffff";
    static final String DFA17_maxS =
        "\1\u01d0\7\0\5\uffff";
    static final String DFA17_acceptS =
        "\10\uffff\1\4\1\1\1\2\1\3\1\5";
    static final String DFA17_specialS =
        "\1\uffff\1\0\1\1\1\2\1\3\1\4\1\5\1\6\5\uffff}>";
    static final String[] DFA17_transitionS = {
            "\1\10\14\uffff\1\7\30\uffff\1\2\1\3\147\uffff\1\5\u00fa\uffff"+
            "\1\6\17\uffff\1\1\57\uffff\1\4",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA17_eot = DFA.unpackEncodedString(DFA17_eotS);
    static final short[] DFA17_eof = DFA.unpackEncodedString(DFA17_eofS);
    static final char[] DFA17_min = DFA.unpackEncodedStringToUnsignedChars(DFA17_minS);
    static final char[] DFA17_max = DFA.unpackEncodedStringToUnsignedChars(DFA17_maxS);
    static final short[] DFA17_accept = DFA.unpackEncodedString(DFA17_acceptS);
    static final short[] DFA17_special = DFA.unpackEncodedString(DFA17_specialS);
    static final short[][] DFA17_transition;

    static {
        int numStates = DFA17_transitionS.length;
        DFA17_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA17_transition[i] = DFA.unpackEncodedString(DFA17_transitionS[i]);
        }
    }

    class DFA17 extends DFA {

        public DFA17(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 17;
            this.eot = DFA17_eot;
            this.eof = DFA17_eof;
            this.min = DFA17_min;
            this.max = DFA17_max;
            this.accept = DFA17_accept;
            this.special = DFA17_special;
            this.transition = DFA17_transition;
        }
        public String getDescription() {
            return "182:9: ( options {backtrack=true; } : propertyExpression SOME expression -> ^( SOME_RESTRICTION propertyExpression expression ) | propertyExpression ONLY expression -> ^( ALL_RESTRICTION propertyExpression expression ) | cardinalityRestriction -> ^( cardinalityRestriction ) | oneOf -> ^( oneOf ) | valueRestriction -> ^( valueRestriction ) )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA17_1 = input.LA(1);

                         
                        int index17_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred24_MOWLParser()) ) {s = 9;}

                        else if ( (synpred25_MOWLParser()) ) {s = 10;}

                        else if ( (synpred26_MOWLParser()) ) {s = 11;}

                        else if ( (true) ) {s = 12;}

                         
                        input.seek(index17_1);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA17_2 = input.LA(1);

                         
                        int index17_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred24_MOWLParser()) ) {s = 9;}

                        else if ( (synpred25_MOWLParser()) ) {s = 10;}

                        else if ( (synpred26_MOWLParser()) ) {s = 11;}

                        else if ( (true) ) {s = 12;}

                         
                        input.seek(index17_2);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA17_3 = input.LA(1);

                         
                        int index17_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred24_MOWLParser()) ) {s = 9;}

                        else if ( (synpred25_MOWLParser()) ) {s = 10;}

                        else if ( (synpred26_MOWLParser()) ) {s = 11;}

                        else if ( (true) ) {s = 12;}

                         
                        input.seek(index17_3);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA17_4 = input.LA(1);

                         
                        int index17_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred24_MOWLParser()) ) {s = 9;}

                        else if ( (synpred25_MOWLParser()) ) {s = 10;}

                        else if ( (synpred26_MOWLParser()) ) {s = 11;}

                        else if ( (true) ) {s = 12;}

                         
                        input.seek(index17_4);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA17_5 = input.LA(1);

                         
                        int index17_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred24_MOWLParser()) ) {s = 9;}

                        else if ( (synpred25_MOWLParser()) ) {s = 10;}

                        else if ( (synpred26_MOWLParser()) ) {s = 11;}

                        else if ( (true) ) {s = 12;}

                         
                        input.seek(index17_5);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA17_6 = input.LA(1);

                         
                        int index17_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred24_MOWLParser()) ) {s = 9;}

                        else if ( (synpred25_MOWLParser()) ) {s = 10;}

                        else if ( (synpred26_MOWLParser()) ) {s = 11;}

                        else if ( (true) ) {s = 12;}

                         
                        input.seek(index17_6);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA17_7 = input.LA(1);

                         
                        int index17_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred24_MOWLParser()) ) {s = 9;}

                        else if ( (synpred25_MOWLParser()) ) {s = 10;}

                        else if ( (synpred26_MOWLParser()) ) {s = 11;}

                        else if ( (true) ) {s = 12;}

                         
                        input.seek(index17_7);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 17, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

    public static final BitSet FOLLOW_binaryAxiom_in_axiom232 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_unaryAxiom_in_axiom244 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_assertionAxiom_in_axiom256 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_hasKeyAxiom_in_axiom268 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_annotationAssertionAxiom_in_axiom279 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_iri_in_annotationAssertionAxiom311 = new BitSet(new long[]{0x0000300000000000L,0x0000000000000000L,0x0000000000200000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000100010000L,0x0000000000010000L});
    public static final BitSet FOLLOW_atomic_in_annotationAssertionAxiom316 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_constant_in_annotationAssertionAxiom322 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_iri_in_annotationAssertionAxiom354 = new BitSet(new long[]{0x0000300000000000L,0x0000000000000000L,0x0000000000200000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000100010000L,0x0000000000010000L});
    public static final BitSet FOLLOW_atomic_in_annotationAssertionAxiom359 = new BitSet(new long[]{0x0000000000000000L,0x0000400000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_iri_in_annotationAssertionAxiom365 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_in_hasKeyAxiom422 = new BitSet(new long[]{0x0000000000000000L,0x0000200000000000L});
    public static final BitSet FOLLOW_HAS_KEY_in_hasKeyAxiom424 = new BitSet(new long[]{0x0000300000080000L,0x0000000000000000L,0x0000000000200000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000100010000L,0x0000000000010000L});
    public static final BitSet FOLLOW_propertyExpression_in_hasKeyAxiom426 = new BitSet(new long[]{0x0000002000000002L});
    public static final BitSet FOLLOW_COMMA_in_hasKeyAxiom429 = new BitSet(new long[]{0x0000300000080000L,0x0000000000000000L,0x0000000000200000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000100010000L,0x0000000000010000L});
    public static final BitSet FOLLOW_propertyExpression_in_hasKeyAxiom431 = new BitSet(new long[]{0x0000002000000002L});
    public static final BitSet FOLLOW_atomic_in_assertionAxiom479 = new BitSet(new long[]{0x000000C000000000L});
    public static final BitSet FOLLOW_INSTANCE_OF_in_assertionAxiom482 = new BitSet(new long[]{0x0000310000081060L,0x0000000000000000L,0x0000000000200000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000100010000L,0x0000000000010000L});
    public static final BitSet FOLLOW_TYPES_in_assertionAxiom486 = new BitSet(new long[]{0x0000310000081060L,0x0000000000000000L,0x0000000000200000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000100010000L,0x0000000000010000L});
    public static final BitSet FOLLOW_expression_in_assertionAxiom489 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_atomic_in_assertionAxiom520 = new BitSet(new long[]{0x0000300000080000L,0x0000000000000000L,0x0000000000200000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000100010000L,0x0000000000010000L});
    public static final BitSet FOLLOW_propertyExpression_in_assertionAxiom522 = new BitSet(new long[]{0x0000310000000000L,0x0000000000000000L,0x0000000000200000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000100010000L,0x0000000000010000L});
    public static final BitSet FOLLOW_value_in_assertionAxiom525 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NOT_in_assertionAxiom559 = new BitSet(new long[]{0x0000300000001000L,0x0000000000000000L,0x0000000000200000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000100010000L,0x0000000000010000L});
    public static final BitSet FOLLOW_assertionAxiom_in_assertionAxiom561 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_in_binaryAxiom600 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_SUBCLASS_OF_in_binaryAxiom602 = new BitSet(new long[]{0x0000310000081060L,0x0000000000000000L,0x0000000000200000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000100010000L,0x0000000000010000L});
    public static final BitSet FOLLOW_expression_in_binaryAxiom609 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_in_binaryAxiom647 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_EQUIVALENT_TO_in_binaryAxiom649 = new BitSet(new long[]{0x0000310000081060L,0x0000000000000000L,0x0000000000200000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000100010000L,0x0000000000010000L});
    public static final BitSet FOLLOW_expression_in_binaryAxiom655 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_in_binaryAxiom692 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_DISJOINT_WITH_in_binaryAxiom694 = new BitSet(new long[]{0x0000310000081060L,0x0000000000000000L,0x0000000000200000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000100010000L,0x0000000000010000L});
    public static final BitSet FOLLOW_expression_in_binaryAxiom700 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_in_binaryAxiom737 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_SUB_PROPERTY_OF_in_binaryAxiom739 = new BitSet(new long[]{0x0000300000080000L,0x0000000000000000L,0x0000000000200000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000100010000L,0x0000000000010000L});
    public static final BitSet FOLLOW_propertyExpression_in_binaryAxiom745 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_atomic_in_binaryAxiom782 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_INVERSE_OF_in_binaryAxiom784 = new BitSet(new long[]{0x0000300000000000L,0x0000000000000000L,0x0000000000200000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000100010000L,0x0000000000010000L});
    public static final BitSet FOLLOW_atomic_in_binaryAxiom790 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_atomic_in_binaryAxiom821 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_SAME_AS_in_binaryAxiom823 = new BitSet(new long[]{0x0000300000000000L,0x0000000000000000L,0x0000000000200000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000100010000L,0x0000000000010000L});
    public static final BitSet FOLLOW_atomic_in_binaryAxiom830 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_atomic_in_binaryAxiom868 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_DIFFERENT_FROM_in_binaryAxiom870 = new BitSet(new long[]{0x0000300000000000L,0x0000000000000000L,0x0000000000200000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000100010000L,0x0000000000010000L});
    public static final BitSet FOLLOW_atomic_in_binaryAxiom877 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_atomic_in_binaryAxiom914 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_DOMAIN_in_binaryAxiom917 = new BitSet(new long[]{0x0000310000081060L,0x0000000000000000L,0x0000000000200000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000100010000L,0x0000000000010000L});
    public static final BitSet FOLLOW_expression_in_binaryAxiom919 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_atomic_in_binaryAxiom955 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_RANGE_in_binaryAxiom957 = new BitSet(new long[]{0x0000310000081060L,0x0000000000000000L,0x0000000000200000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000100010000L,0x0000000000010000L});
    public static final BitSet FOLLOW_expression_in_binaryAxiom959 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_unaryCharacteristic_in_unaryAxiom1033 = new BitSet(new long[]{0x0000310000081040L,0x0000000000000000L,0x0000000000200000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000100010000L,0x0000000000010000L});
    public static final BitSet FOLLOW_unary_in_unaryAxiom1037 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FUNCTIONAL_in_unaryCharacteristic1082 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INVERSE_FUNCTIONAL_in_unaryCharacteristic1096 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SYMMETRIC_in_unaryCharacteristic1110 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ANTI_SYMMETRIC_in_unaryCharacteristic1124 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_REFLEXIVE_in_unaryCharacteristic1138 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IRREFLEXIVE_in_unaryCharacteristic1152 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TRANSITIVE_in_unaryCharacteristic1166 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_conjunction_in_expression1208 = new BitSet(new long[]{0x0000000000000802L});
    public static final BitSet FOLLOW_OR_in_expression1211 = new BitSet(new long[]{0x0000310000081040L,0x0000000000000000L,0x0000000000200000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000100010000L,0x0000000000010000L});
    public static final BitSet FOLLOW_conjunction_in_expression1213 = new BitSet(new long[]{0x0000000000000802L});
    public static final BitSet FOLLOW_complexPropertyExpression_in_expression1232 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OPEN_PARENTHESYS_in_expression1245 = new BitSet(new long[]{0x0000310000081060L,0x0000000000000000L,0x0000000000200000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000100010000L,0x0000000000010000L});
    public static final BitSet FOLLOW_expression_in_expression1247 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_CLOSED_PARENTHESYS_in_expression1249 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_unary_in_conjunction1282 = new BitSet(new long[]{0x0000000000000402L});
    public static final BitSet FOLLOW_AND_in_conjunction1285 = new BitSet(new long[]{0x0000310000081040L,0x0000000000000000L,0x0000000000200000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000100010000L,0x0000000000010000L});
    public static final BitSet FOLLOW_unary_in_conjunction1287 = new BitSet(new long[]{0x0000000000000402L});
    public static final BitSet FOLLOW_INVERSE_in_complexPropertyExpression1308 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_OPEN_PARENTHESYS_in_complexPropertyExpression1310 = new BitSet(new long[]{0x0000300000080000L,0x0000000000000000L,0x0000000000200000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000100010000L,0x0000000000010000L});
    public static final BitSet FOLLOW_complexPropertyExpression_in_complexPropertyExpression1312 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_CLOSED_PARENTHESYS_in_complexPropertyExpression1314 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INVERSE_in_complexPropertyExpression1327 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_OPEN_PARENTHESYS_in_complexPropertyExpression1329 = new BitSet(new long[]{0x0000300000000000L,0x0000000000000000L,0x0000000000200000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000100010000L,0x0000000000010000L});
    public static final BitSet FOLLOW_atomic_in_complexPropertyExpression1331 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_CLOSED_PARENTHESYS_in_complexPropertyExpression1333 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_propertyExpression_in_unary1370 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_COMPOSITION_in_unary1373 = new BitSet(new long[]{0x0000300000080000L,0x0000000000000000L,0x0000000000200000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000100010000L,0x0000000000010000L});
    public static final BitSet FOLLOW_propertyExpression_in_unary1377 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_NOT_in_unary1399 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_OPEN_PARENTHESYS_in_unary1401 = new BitSet(new long[]{0x0000310000081060L,0x0000000000000000L,0x0000000000200000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000100010000L,0x0000000000010000L});
    public static final BitSet FOLLOW_expression_in_unary1403 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_CLOSED_PARENTHESYS_in_unary1405 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NOT_in_unary1419 = new BitSet(new long[]{0x0000300000000000L,0x0000000000000000L,0x0000000000200000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000100010000L,0x0000000000010000L});
    public static final BitSet FOLLOW_atomic_in_unary1421 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_qualifiedRestriction_in_unary1444 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_dataRange_in_unary1456 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_constant_in_unary1462 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_atomic_in_unary1468 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_dataRange1485 = new BitSet(new long[]{0x0000000000000000L,0x0000000000200000L});
    public static final BitSet FOLLOW_OPEN_SQUARE_BRACKET_in_dataRange1487 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0xF000000000000000L});
    public static final BitSet FOLLOW_dataRangeFacet_in_dataRange1489 = new BitSet(new long[]{0x0000002000000000L,0x0000000000400000L});
    public static final BitSet FOLLOW_COMMA_in_dataRange1492 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0xF000000000000000L});
    public static final BitSet FOLLOW_dataRangeFacet_in_dataRange1494 = new BitSet(new long[]{0x0000002000000000L,0x0000000000400000L});
    public static final BitSet FOLLOW_CLOSED_SQUARE_BRACKET_in_dataRange1498 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LESS_THAN_in_dataRangeFacet1524 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_constant_in_dataRangeFacet1526 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LESS_THAN_EQUAL_in_dataRangeFacet1540 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_constant_in_dataRangeFacet1542 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_GREATER_THAN_in_dataRangeFacet1557 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_constant_in_dataRangeFacet1559 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_GREATER_THAN_EQUAL_in_dataRangeFacet1573 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_constant_in_dataRangeFacet1575 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_propertyExpression_in_qualifiedRestriction1655 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_SOME_in_qualifiedRestriction1658 = new BitSet(new long[]{0x0000310000081060L,0x0000000000000000L,0x0000000000200000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000100010000L,0x0000000000010000L});
    public static final BitSet FOLLOW_expression_in_qualifiedRestriction1662 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_propertyExpression_in_qualifiedRestriction1691 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_ONLY_in_qualifiedRestriction1693 = new BitSet(new long[]{0x0000310000081060L,0x0000000000000000L,0x0000000000200000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000100010000L,0x0000000000010000L});
    public static final BitSet FOLLOW_expression_in_qualifiedRestriction1696 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_cardinalityRestriction_in_qualifiedRestriction1715 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_oneOf_in_qualifiedRestriction1729 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_valueRestriction_in_qualifiedRestriction1743 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_atomic_in_propertyExpression1775 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_complexPropertyExpression_in_propertyExpression1789 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_propertyExpression_in_cardinalityRestriction1831 = new BitSet(new long[]{0x0000000000038000L});
    public static final BitSet FOLLOW_restrictionKind_in_cardinalityRestriction1834 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_INTEGER_in_cardinalityRestriction1836 = new BitSet(new long[]{0x0000310000081042L,0x0000000000000000L,0x0000000000200000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000100010000L,0x0000000000010000L});
    public static final BitSet FOLLOW_unary_in_cardinalityRestriction1838 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MIN_in_restrictionKind1871 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MAX_in_restrictionKind1885 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_EXACTLY_in_restrictionKind1899 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OPEN_CURLY_BRACES_in_oneOf1921 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_oneOf1923 = new BitSet(new long[]{0x0000002000000080L});
    public static final BitSet FOLLOW_COMMA_in_oneOf1926 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_oneOf1928 = new BitSet(new long[]{0x0000002000000080L});
    public static final BitSet FOLLOW_CLOSED_CURLY_BRACES_in_oneOf1932 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_propertyExpression_in_valueRestriction1952 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_VALUE_in_valueRestriction1954 = new BitSet(new long[]{0x0000310000000000L,0x0000000000000000L,0x0000000000200000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000100010000L,0x0000000000010000L});
    public static final BitSet FOLLOW_value_in_valueRestriction1956 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_atomic_in_value1981 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_constant_in_value1996 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DBLQUOTE_in_constant2021 = new BitSet(new long[]{0x0000001000000002L});
    public static final BitSet FOLLOW_POW_in_constant2025 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_constant2031 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_binaryAxiom_in_synpred1_MOWLParser232 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_assertionAxiom_in_synpred3_MOWLParser256 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_hasKeyAxiom_in_synpred4_MOWLParser268 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_iri_in_synpred5_MOWLParser311 = new BitSet(new long[]{0x0000300000000000L,0x0000000000000000L,0x0000000000200000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000100010000L,0x0000000000010000L});
    public static final BitSet FOLLOW_atomic_in_synpred5_MOWLParser316 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_constant_in_synpred5_MOWLParser322 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_atomic_in_synpred6_MOWLParser479 = new BitSet(new long[]{0x000000C000000000L});
    public static final BitSet FOLLOW_set_in_synpred6_MOWLParser481 = new BitSet(new long[]{0x0000310000081060L,0x0000000000000000L,0x0000000000200000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000100010000L,0x0000000000010000L});
    public static final BitSet FOLLOW_expression_in_synpred6_MOWLParser489 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_atomic_in_synpred7_MOWLParser520 = new BitSet(new long[]{0x0000300000080000L,0x0000000000000000L,0x0000000000200000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000100010000L,0x0000000000010000L});
    public static final BitSet FOLLOW_propertyExpression_in_synpred7_MOWLParser522 = new BitSet(new long[]{0x0000310000000000L,0x0000000000000000L,0x0000000000200000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000100010000L,0x0000000000010000L});
    public static final BitSet FOLLOW_value_in_synpred7_MOWLParser525 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_in_synpred8_MOWLParser600 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_SUBCLASS_OF_in_synpred8_MOWLParser602 = new BitSet(new long[]{0x0000310000081060L,0x0000000000000000L,0x0000000000200000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000100010000L,0x0000000000010000L});
    public static final BitSet FOLLOW_expression_in_synpred8_MOWLParser609 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_in_synpred9_MOWLParser647 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_EQUIVALENT_TO_in_synpred9_MOWLParser649 = new BitSet(new long[]{0x0000310000081060L,0x0000000000000000L,0x0000000000200000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000100010000L,0x0000000000010000L});
    public static final BitSet FOLLOW_expression_in_synpred9_MOWLParser655 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_in_synpred10_MOWLParser692 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_DISJOINT_WITH_in_synpred10_MOWLParser694 = new BitSet(new long[]{0x0000310000081060L,0x0000000000000000L,0x0000000000200000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000100010000L,0x0000000000010000L});
    public static final BitSet FOLLOW_expression_in_synpred10_MOWLParser700 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_in_synpred11_MOWLParser737 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_SUB_PROPERTY_OF_in_synpred11_MOWLParser739 = new BitSet(new long[]{0x0000300000080000L,0x0000000000000000L,0x0000000000200000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000100010000L,0x0000000000010000L});
    public static final BitSet FOLLOW_propertyExpression_in_synpred11_MOWLParser745 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_atomic_in_synpred12_MOWLParser782 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_INVERSE_OF_in_synpred12_MOWLParser784 = new BitSet(new long[]{0x0000300000000000L,0x0000000000000000L,0x0000000000200000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000100010000L,0x0000000000010000L});
    public static final BitSet FOLLOW_atomic_in_synpred12_MOWLParser790 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_atomic_in_synpred13_MOWLParser821 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_SAME_AS_in_synpred13_MOWLParser823 = new BitSet(new long[]{0x0000300000000000L,0x0000000000000000L,0x0000000000200000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000100010000L,0x0000000000010000L});
    public static final BitSet FOLLOW_atomic_in_synpred13_MOWLParser830 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_atomic_in_synpred14_MOWLParser868 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_DIFFERENT_FROM_in_synpred14_MOWLParser870 = new BitSet(new long[]{0x0000300000000000L,0x0000000000000000L,0x0000000000200000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000100010000L,0x0000000000010000L});
    public static final BitSet FOLLOW_atomic_in_synpred14_MOWLParser877 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_atomic_in_synpred15_MOWLParser914 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_DOMAIN_in_synpred15_MOWLParser917 = new BitSet(new long[]{0x0000310000081060L,0x0000000000000000L,0x0000000000200000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000100010000L,0x0000000000010000L});
    public static final BitSet FOLLOW_expression_in_synpred15_MOWLParser919 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_conjunction_in_synpred16_MOWLParser1208 = new BitSet(new long[]{0x0000000000000802L});
    public static final BitSet FOLLOW_OR_in_synpred16_MOWLParser1211 = new BitSet(new long[]{0x0000310000081040L,0x0000000000000000L,0x0000000000200000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000100010000L,0x0000000000010000L});
    public static final BitSet FOLLOW_conjunction_in_synpred16_MOWLParser1213 = new BitSet(new long[]{0x0000000000000802L});
    public static final BitSet FOLLOW_complexPropertyExpression_in_synpred17_MOWLParser1232 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_propertyExpression_in_synpred18_MOWLParser1370 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_COMPOSITION_in_synpred18_MOWLParser1373 = new BitSet(new long[]{0x0000300000080000L,0x0000000000000000L,0x0000000000200000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000100010000L,0x0000000000010000L});
    public static final BitSet FOLLOW_propertyExpression_in_synpred18_MOWLParser1377 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_NOT_in_synpred19_MOWLParser1399 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_OPEN_PARENTHESYS_in_synpred19_MOWLParser1401 = new BitSet(new long[]{0x0000310000081060L,0x0000000000000000L,0x0000000000200000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000100010000L,0x0000000000010000L});
    public static final BitSet FOLLOW_expression_in_synpred19_MOWLParser1403 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_CLOSED_PARENTHESYS_in_synpred19_MOWLParser1405 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NOT_in_synpred20_MOWLParser1419 = new BitSet(new long[]{0x0000300000000000L,0x0000000000000000L,0x0000000000200000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000100010000L,0x0000000000010000L});
    public static final BitSet FOLLOW_atomic_in_synpred20_MOWLParser1421 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_qualifiedRestriction_in_synpred21_MOWLParser1444 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_dataRange_in_synpred22_MOWLParser1456 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_propertyExpression_in_synpred24_MOWLParser1655 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_SOME_in_synpred24_MOWLParser1658 = new BitSet(new long[]{0x0000310000081060L,0x0000000000000000L,0x0000000000200000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000100010000L,0x0000000000010000L});
    public static final BitSet FOLLOW_expression_in_synpred24_MOWLParser1662 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_propertyExpression_in_synpred25_MOWLParser1691 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_ONLY_in_synpred25_MOWLParser1693 = new BitSet(new long[]{0x0000310000081060L,0x0000000000000000L,0x0000000000200000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000100010000L,0x0000000000010000L});
    public static final BitSet FOLLOW_expression_in_synpred25_MOWLParser1696 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_cardinalityRestriction_in_synpred26_MOWLParser1715 = new BitSet(new long[]{0x0000000000000002L});

}