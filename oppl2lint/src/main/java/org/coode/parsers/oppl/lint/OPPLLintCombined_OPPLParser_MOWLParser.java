// $ANTLR 3.2 Sep 23, 2009 12:02:23 MOWLParser.g 2011-08-02 17:13:32

  package org.coode.parsers.oppl.lint;
  import org.coode.oppl.log.Logger;
import org.coode.oppl.log.Logging;
import org.coode.parsers.oppl.OPPLSyntaxTree;
import org.coode.parsers.ErrorListener;
import org.antlr.runtime.*;

import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

import org.antlr.runtime.tree.*;
@SuppressWarnings("javadoc")
public class OPPLLintCombined_OPPLParser_MOWLParser extends Parser {
    public static final int HAS_KEY=109;
    public static final int VALUE_RESTRICTION=63;
    public static final int LETTER=43;
    public static final int REMOVE=91;
    public static final int TYPES=39;
    public static final int SAME_AS_AXIOM=52;
    public static final int INVERSE_OF=25;
    public static final int NOT=12;
    public static final int SUBCLASS_OF=20;
    public static final int EOF=-1;
    public static final int ESCLAMATION_MARK=149;
    public static final int ACTIONS=101;
    public static final int CREATE=80;
    public static final int DESCRIPTION=468;
    public static final int POW=36;
    public static final int INPUT_VARIABLE_DEFINITION=96;
    public static final int NOT_EQUAL=72;
    public static final int INVERSE_OBJECT_PROPERTY_EXPRESSION=68;
    public static final int INSTANCE_OF=38;
    public static final int BEGIN=83;
    public static final int RETURN=415;
    public static final int VARIABLE_SCOPE=104;
    public static final int INEQUALITY_CONSTRAINT=94;
    public static final int QUESTION_MARK=46;
    public static final int DISJOINT_PROPERTIES=117;
    public static final int SYMMETRIC=30;
    public static final int CARDINALITY_RESTRICTION=64;
    public static final int SELECT=75;
    public static final int ROLE_ASSERTION=67;
    public static final int DIFFERENT_FROM_AXIOM=53;
    public static final int TO_LOWER_CASE=120;
    public static final int CREATE_OPPL_FUNCTION=98;
    public static final int TRANSITIVE=34;
    public static final int ANTI_SYMMETRIC=31;
    public static final int GREATER_THAN_EQUAL=486;
    public static final int INFERENCE=471;
    public static final int ALL_RESTRICTION=62;
    public static final int CONJUNCTION=56;
    public static final int OPPL_STATEMENT=107;
    public static final int NEGATED_ASSERTION=59;
    public static final int WHITESPACE=9;
    public static final int MATCH=176;
    public static final int IN_SET_CONSTRAINT=95;
    public static final int SEMICOLON=422;
    public static final int VALUE=18;
    public static final int FAIL=466;
    public static final int GROUPS=356;
    public static final int OPEN_CURLY_BRACES=6;
    public static final int DISJUNCTION=55;
    public static final int INVERSE=19;
    public static final int WS=577;
    public static final int NAF_CONSTRAINT=467;
    public static final int OPPL_LINT=119;
    public static final int DBLQUOTE=40;
    public static final int STRING_OPERATION=620;
    public static final int OR=11;
    public static final int LESS_THAN=483;
    public static final int CONSTANT=70;
    public static final int QUERY=103;
    public static final int ENTITY_REFERENCE=45;
    public static final int END=84;
    public static final int COMPOSITION=4;
    public static final int ANNOTATION_ASSERTION=111;
    public static final int CLOSED_SQUARE_BRACKET=86;
    public static final int DOLLAR=400;
    public static final int SAME_AS=23;
    public static final int WHERE=71;
    public static final int DIFFERENT_INDIVIDUALS=119;
    public static final int DISJOINT_WITH=26;
    public static final int SUPER_PROPERTY_OF=88;
    public static final int VARIABLE_TYPE=89;
    public static final int ATTRIBUTE_SELECTOR=619;
    public static final int CLOSED_PARENTHESYS=8;
    public static final int ONLY=14;
    public static final int EQUIVALENT_TO_AXIOM=49;
    public static final int SUB_PROPERTY_OF=21;
    public static final int NEGATED_EXPRESSION=58;
    public static final int MAX=16;
    public static final int TO_UPPER_CASE=121;
    public static final int CREATE_DISJUNCTION=82;
    public static final int AND=10;
    public static final int ASSERTED_CLAUSE=92;
    public static final int INVERSE_PROPERTY=60;
    public static final int AT=114;
    public static final int VARIABLE_NAME=464;
    public static final int DIFFERENT_FROM=24;
    public static final int IN=74;
    public static final int EQUIVALENT_TO=22;
    public static final int UNARY_AXIOM=54;
    public static final int COMMA=37;
    public static final int CLOSED_CURLY_BRACES=7;
    public static final int IDENTIFIER=44;
    public static final int IRI=110;
    public static final int SOME=13;
    public static final int EQUAL=73;
    public static final int OPEN_PARENTHESYS=5;
    public static final int SAME_INDIVIDUAL=118;
    public static final int REFLEXIVE=32;
    public static final int PLUS=79;
    public static final int DIGIT=41;
    public static final int DOT=78;
    public static final int SUPER_CLASS_OF=87;
    public static final int EXPRESSION=69;
    public static final int SOME_RESTRICTION=61;
    public static final int ADD=90;
    public static final int INTEGER=42;
    public static final int GREATER_THAN=485;
    public static final int EXPLANATION=469;
    public static final int GENERATED_VARIABLE_DEFINITION=97;
    public static final int EXACTLY=17;
    public static final int SUB_PROPERTY_AXIOM=51;
    public static final int OPEN_SQUARE_BRACKET=85;
    public static final int VALUES=354;
    public static final int REGEXP_CONSTRAINT=609;
    public static final int RANGE=28;
    public static final int DATA_RANGE=595;
    public static final int SET=115;
    public static final int ONE_OF=65;
    public static final int VARIABLE_DEFINITIONS=102;
    public static final int MIN=15;
    public static final int SUB_CLASS_AXIOM=48;
    public static final int TEXT=470;
    public static final int PLAIN_CLAUSE=93;
    public static final int Tokens=47;
    public static final int DOMAIN=27;
    public static final int SUBPROPERTY_OF=621;
    public static final int OPPL_FUNCTION=100;
    public static final int COLON=77;
    public static final int DISJOINT_WITH_AXIOM=50;
    public static final int CREATE_INTERSECTION=81;
    public static final int INVERSE_FUNCTIONAL=35;
    public static final int RENDERING=355;
    public static final int VARIABLE_IDENTIFIER=106;
    public static final int IRI_ATTRIBUTE_NAME=567;
    public static final int IRREFLEXIVE=33;
    public static final int LESS_THAN_EQUAL=484;
    public static final int VARIABLE_ATTRIBUTE=99;
    public static final int ASSERTED=76;
    public static final int FUNCTIONAL=29;
    public static final int PROPERTY_CHAIN=57;
    public static final int TYPE_ASSERTION=66;
    public static final int DISJOINT_CLASSES=116;

    // delegates
    // delegators
    public OPPLLintCombinedParser gOPPLLintCombined;
    public OPPLLintCombined_OPPLParser gOPPLParser;
    public OPPLLintCombined_OPPLParser gParent;


        public OPPLLintCombined_OPPLParser_MOWLParser(TokenStream input, OPPLLintCombinedParser gOPPLLintCombined, OPPLLintCombined_OPPLParser gOPPLParser) {
            this(input, new RecognizerSharedState(), gOPPLLintCombined, gOPPLParser);
        }
        public OPPLLintCombined_OPPLParser_MOWLParser(TokenStream input, RecognizerSharedState state, OPPLLintCombinedParser gOPPLLintCombined, OPPLLintCombined_OPPLParser gOPPLParser) {
            super(input, state);
            this.gOPPLLintCombined = gOPPLLintCombined;
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

    public String[] getTokenNames() { return OPPLLintCombinedParser.tokenNames; }
    public String getGrammarFileName() { return "MOWLParser.g"; }


    public void displayRecognitionError(String[] tokenNames,
    										RecognitionException e){
    	}
    	


    public static class annotationAssertionAxiom_return extends ParserRuleReturnScope {
        OPPLSyntaxTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "annotationAssertionAxiom"
    // MOWLParser.g:72:1: annotationAssertionAxiom options {backtrack=true; } : ( iri p= atomic o= constant -> ^( ANNOTATION_ASSERTION iri ^( EXPRESSION $p) ^( EXPRESSION $o) ) | iri p= atomic a= atomic -> ^( ANNOTATION_ASSERTION iri ^( EXPRESSION $p) ^( EXPRESSION $a) ) | subjectIRI= iri p= atomic objectIRI= iri -> ^( ANNOTATION_ASSERTION $subjectIRI ^( EXPRESSION $p) ^( EXPRESSION $objectIRI) ) );
    public final OPPLLintCombined_OPPLParser_MOWLParser.annotationAssertionAxiom_return annotationAssertionAxiom() throws RecognitionException {
        OPPLLintCombined_OPPLParser_MOWLParser.annotationAssertionAxiom_return retval = new OPPLLintCombined_OPPLParser_MOWLParser.annotationAssertionAxiom_return();
        retval.start = input.LT(1);

        OPPLSyntaxTree root_0 = null;

        OPPLLintCombined_OPPLParser.atomic_return p = null;

        OPPLLintCombined_OPPLParser_MOWLParser.constant_return o = null;

        OPPLLintCombined_OPPLParser.atomic_return a = null;

        OPPLLintCombined_OPPLParser.iri_return subjectIRI = null;

        OPPLLintCombined_OPPLParser.iri_return objectIRI = null;

        OPPLLintCombined_OPPLParser.iri_return iri1 = null;

        OPPLLintCombined_OPPLParser.iri_return iri2 = null;


        RewriteRuleSubtreeStream stream_constant=new RewriteRuleSubtreeStream(adaptor,"rule constant");
        RewriteRuleSubtreeStream stream_iri=new RewriteRuleSubtreeStream(adaptor,"rule iri");
        RewriteRuleSubtreeStream stream_atomic=new RewriteRuleSubtreeStream(adaptor,"rule atomic");
        try {
            // MOWLParser.g:73:32: ( iri p= atomic o= constant -> ^( ANNOTATION_ASSERTION iri ^( EXPRESSION $p) ^( EXPRESSION $o) ) | iri p= atomic a= atomic -> ^( ANNOTATION_ASSERTION iri ^( EXPRESSION $p) ^( EXPRESSION $a) ) | subjectIRI= iri p= atomic objectIRI= iri -> ^( ANNOTATION_ASSERTION $subjectIRI ^( EXPRESSION $p) ^( EXPRESSION $objectIRI) ) )
            int alt2=3;
            alt2 = dfa2.predict(input);
            switch (alt2) {
                case 1 :
                    // MOWLParser.g:74:3: iri p= atomic o= constant
                    {
                    pushFollow(FOLLOW_iri_in_annotationAssertionAxiom311);
                    iri1=gOPPLParser.iri();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_iri.add(iri1.getTree());
                    pushFollow(FOLLOW_atomic_in_annotationAssertionAxiom316);
                    p=gOPPLParser.atomic();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_atomic.add(p.getTree());
                    pushFollow(FOLLOW_constant_in_annotationAssertionAxiom322);
                    o=constant();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_constant.add(o.getTree());


                    // AST REWRITE
                    // elements: o, p, iri
                    // token labels: 
                    // rule labels: retval, p, o
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
                    RewriteRuleSubtreeStream stream_p=new RewriteRuleSubtreeStream(adaptor,"rule p",p!=null?p.tree:null);
                    RewriteRuleSubtreeStream stream_o=new RewriteRuleSubtreeStream(adaptor,"rule o",o!=null?o.tree:null);

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
                    // MOWLParser.g:75:5: iri p= atomic a= atomic
                    {
                    pushFollow(FOLLOW_iri_in_annotationAssertionAxiom350);
                    iri2=gOPPLParser.iri();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_iri.add(iri2.getTree());
                    pushFollow(FOLLOW_atomic_in_annotationAssertionAxiom355);
                    p=gOPPLParser.atomic();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_atomic.add(p.getTree());
                    pushFollow(FOLLOW_atomic_in_annotationAssertionAxiom361);
                    a=gOPPLParser.atomic();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_atomic.add(a.getTree());


                    // AST REWRITE
                    // elements: a, iri, p
                    // token labels: 
                    // rule labels: retval, p, a
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
                    RewriteRuleSubtreeStream stream_p=new RewriteRuleSubtreeStream(adaptor,"rule p",p!=null?p.tree:null);
                    RewriteRuleSubtreeStream stream_a=new RewriteRuleSubtreeStream(adaptor,"rule a",a!=null?a.tree:null);

                    root_0 = (OPPLSyntaxTree)adaptor.nil();
                    // 75:30: -> ^( ANNOTATION_ASSERTION iri ^( EXPRESSION $p) ^( EXPRESSION $a) )
                    {
                        // MOWLParser.g:75:33: ^( ANNOTATION_ASSERTION iri ^( EXPRESSION $p) ^( EXPRESSION $a) )
                        {
                        OPPLSyntaxTree root_1 = (OPPLSyntaxTree)adaptor.nil();
                        root_1 = (OPPLSyntaxTree)adaptor.becomeRoot((OPPLSyntaxTree)adaptor.create(ANNOTATION_ASSERTION, "ANNOTATION_ASSERTION"), root_1);

                        adaptor.addChild(root_1, stream_iri.nextTree());
                        // MOWLParser.g:75:60: ^( EXPRESSION $p)
                        {
                        OPPLSyntaxTree root_2 = (OPPLSyntaxTree)adaptor.nil();
                        root_2 = (OPPLSyntaxTree)adaptor.becomeRoot((OPPLSyntaxTree)adaptor.create(EXPRESSION, "EXPRESSION"), root_2);

                        adaptor.addChild(root_2, stream_p.nextTree());

                        adaptor.addChild(root_1, root_2);
                        }
                        // MOWLParser.g:75:77: ^( EXPRESSION $a)
                        {
                        OPPLSyntaxTree root_2 = (OPPLSyntaxTree)adaptor.nil();
                        root_2 = (OPPLSyntaxTree)adaptor.becomeRoot((OPPLSyntaxTree)adaptor.create(EXPRESSION, "EXPRESSION"), root_2);

                        adaptor.addChild(root_2, stream_a.nextTree());

                        adaptor.addChild(root_1, root_2);
                        }

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 3 :
                    // MOWLParser.g:76:5: subjectIRI= iri p= atomic objectIRI= iri
                    {
                    pushFollow(FOLLOW_iri_in_annotationAssertionAxiom393);
                    subjectIRI=gOPPLParser.iri();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_iri.add(subjectIRI.getTree());
                    pushFollow(FOLLOW_atomic_in_annotationAssertionAxiom398);
                    p=gOPPLParser.atomic();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_atomic.add(p.getTree());
                    pushFollow(FOLLOW_iri_in_annotationAssertionAxiom404);
                    objectIRI=gOPPLParser.iri();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_iri.add(objectIRI.getTree());


                    // AST REWRITE
                    // elements: subjectIRI, objectIRI, p
                    // token labels: 
                    // rule labels: objectIRI, retval, subjectIRI, p
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_objectIRI=new RewriteRuleSubtreeStream(adaptor,"rule objectIRI",objectIRI!=null?objectIRI.tree:null);
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
                    RewriteRuleSubtreeStream stream_subjectIRI=new RewriteRuleSubtreeStream(adaptor,"rule subjectIRI",subjectIRI!=null?subjectIRI.tree:null);
                    RewriteRuleSubtreeStream stream_p=new RewriteRuleSubtreeStream(adaptor,"rule p",p!=null?p.tree:null);

                    root_0 = (OPPLSyntaxTree)adaptor.nil();
                    // 76:48: -> ^( ANNOTATION_ASSERTION $subjectIRI ^( EXPRESSION $p) ^( EXPRESSION $objectIRI) )
                    {
                        // MOWLParser.g:76:51: ^( ANNOTATION_ASSERTION $subjectIRI ^( EXPRESSION $p) ^( EXPRESSION $objectIRI) )
                        {
                        OPPLSyntaxTree root_1 = (OPPLSyntaxTree)adaptor.nil();
                        root_1 = (OPPLSyntaxTree)adaptor.becomeRoot((OPPLSyntaxTree)adaptor.create(ANNOTATION_ASSERTION, "ANNOTATION_ASSERTION"), root_1);

                        adaptor.addChild(root_1, stream_subjectIRI.nextTree());
                        // MOWLParser.g:76:86: ^( EXPRESSION $p)
                        {
                        OPPLSyntaxTree root_2 = (OPPLSyntaxTree)adaptor.nil();
                        root_2 = (OPPLSyntaxTree)adaptor.becomeRoot((OPPLSyntaxTree)adaptor.create(EXPRESSION, "EXPRESSION"), root_2);

                        adaptor.addChild(root_2, stream_p.nextTree());

                        adaptor.addChild(root_1, root_2);
                        }
                        // MOWLParser.g:76:103: ^( EXPRESSION $objectIRI)
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
    // MOWLParser.g:85:1: hasKeyAxiom : exp= disjunction HAS_KEY propertyExpression ( COMMA propertyExpression )* -> ^( HAS_KEY ^( EXPRESSION $exp) ( ^( EXPRESSION propertyExpression ) )+ ) ;
    public final OPPLLintCombined_OPPLParser_MOWLParser.hasKeyAxiom_return hasKeyAxiom() throws RecognitionException {
        OPPLLintCombined_OPPLParser_MOWLParser.hasKeyAxiom_return retval = new OPPLLintCombined_OPPLParser_MOWLParser.hasKeyAxiom_return();
        retval.start = input.LT(1);

        OPPLSyntaxTree root_0 = null;

        Token HAS_KEY3=null;
        Token COMMA5=null;
        OPPLLintCombined_OPPLParser_MOWLParser.disjunction_return exp = null;

        OPPLLintCombined_OPPLParser_MOWLParser.propertyExpression_return propertyExpression4 = null;

        OPPLLintCombined_OPPLParser_MOWLParser.propertyExpression_return propertyExpression6 = null;


        OPPLSyntaxTree HAS_KEY3_tree=null;
        OPPLSyntaxTree COMMA5_tree=null;
        RewriteRuleTokenStream stream_HAS_KEY=new RewriteRuleTokenStream(adaptor,"token HAS_KEY");
        RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
        RewriteRuleSubtreeStream stream_disjunction=new RewriteRuleSubtreeStream(adaptor,"rule disjunction");
        RewriteRuleSubtreeStream stream_propertyExpression=new RewriteRuleSubtreeStream(adaptor,"rule propertyExpression");
        try {
            // MOWLParser.g:86:2: (exp= disjunction HAS_KEY propertyExpression ( COMMA propertyExpression )* -> ^( HAS_KEY ^( EXPRESSION $exp) ( ^( EXPRESSION propertyExpression ) )+ ) )
            // MOWLParser.g:87:2: exp= disjunction HAS_KEY propertyExpression ( COMMA propertyExpression )*
            {
            pushFollow(FOLLOW_disjunction_in_hasKeyAxiom462);
            exp=disjunction();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_disjunction.add(exp.getTree());
            HAS_KEY3=(Token)match(input,HAS_KEY,FOLLOW_HAS_KEY_in_hasKeyAxiom464); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_HAS_KEY.add(HAS_KEY3);

            pushFollow(FOLLOW_propertyExpression_in_hasKeyAxiom466);
            propertyExpression4=propertyExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_propertyExpression.add(propertyExpression4.getTree());
            // MOWLParser.g:87:47: ( COMMA propertyExpression )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==COMMA) ) {
                    int LA3_2 = input.LA(2);

                    if ( (synpred7_MOWLParser()) ) {
                        alt3=1;
                    }


                }


                switch (alt3) {
            	case 1 :
            	    // MOWLParser.g:87:48: COMMA propertyExpression
            	    {
            	    COMMA5=(Token)match(input,COMMA,FOLLOW_COMMA_in_hasKeyAxiom469); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_COMMA.add(COMMA5);

            	    pushFollow(FOLLOW_propertyExpression_in_hasKeyAxiom471);
            	    propertyExpression6=propertyExpression();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_propertyExpression.add(propertyExpression6.getTree());

            	    }
            	    break;

            	default :
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
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_exp=new RewriteRuleSubtreeStream(adaptor,"rule exp",exp!=null?exp.tree:null);
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (OPPLSyntaxTree)adaptor.nil();
            // 87:75: -> ^( HAS_KEY ^( EXPRESSION $exp) ( ^( EXPRESSION propertyExpression ) )+ )
            {
                // MOWLParser.g:87:78: ^( HAS_KEY ^( EXPRESSION $exp) ( ^( EXPRESSION propertyExpression ) )+ )
                {
                OPPLSyntaxTree root_1 = (OPPLSyntaxTree)adaptor.nil();
                root_1 = (OPPLSyntaxTree)adaptor.becomeRoot(stream_HAS_KEY.nextNode(), root_1);

                // MOWLParser.g:87:88: ^( EXPRESSION $exp)
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
                    // MOWLParser.g:87:108: ^( EXPRESSION propertyExpression )
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
    // MOWLParser.g:92:1: assertionAxiom options {backtrack=true; } : (i= atomic ( INSTANCE_OF | TYPES ) expression -> ^( TYPE_ASSERTION ^( EXPRESSION expression ) ^( EXPRESSION $i) ) | subject= atomic propertyExpression value -> ^( ROLE_ASSERTION ^( EXPRESSION $subject) ^( EXPRESSION propertyExpression ) ^( EXPRESSION value ) ) | NOT assertionAxiom -> ^( NEGATED_ASSERTION assertionAxiom ) );
    public final OPPLLintCombined_OPPLParser_MOWLParser.assertionAxiom_return assertionAxiom() throws RecognitionException {
        OPPLLintCombined_OPPLParser_MOWLParser.assertionAxiom_return retval = new OPPLLintCombined_OPPLParser_MOWLParser.assertionAxiom_return();
        retval.start = input.LT(1);

        OPPLSyntaxTree root_0 = null;

        Token INSTANCE_OF7=null;
        Token TYPES8=null;
        Token NOT12=null;
        OPPLLintCombined_OPPLParser.atomic_return i = null;

        OPPLLintCombined_OPPLParser.atomic_return subject = null;

        OPPLLintCombined_OPPLParser_MOWLParser.expression_return expression9 = null;

        OPPLLintCombined_OPPLParser_MOWLParser.propertyExpression_return propertyExpression10 = null;

        OPPLLintCombined_OPPLParser_MOWLParser.value_return value11 = null;

        OPPLLintCombined_OPPLParser_MOWLParser.assertionAxiom_return assertionAxiom13 = null;


        OPPLSyntaxTree INSTANCE_OF7_tree=null;
        OPPLSyntaxTree TYPES8_tree=null;
        OPPLSyntaxTree NOT12_tree=null;
        RewriteRuleTokenStream stream_TYPES=new RewriteRuleTokenStream(adaptor,"token TYPES");
        RewriteRuleTokenStream stream_NOT=new RewriteRuleTokenStream(adaptor,"token NOT");
        RewriteRuleTokenStream stream_INSTANCE_OF=new RewriteRuleTokenStream(adaptor,"token INSTANCE_OF");
        RewriteRuleSubtreeStream stream_expression=new RewriteRuleSubtreeStream(adaptor,"rule expression");
        RewriteRuleSubtreeStream stream_propertyExpression=new RewriteRuleSubtreeStream(adaptor,"rule propertyExpression");
        RewriteRuleSubtreeStream stream_value=new RewriteRuleSubtreeStream(adaptor,"rule value");
        RewriteRuleSubtreeStream stream_assertionAxiom=new RewriteRuleSubtreeStream(adaptor,"rule assertionAxiom");
        RewriteRuleSubtreeStream stream_atomic=new RewriteRuleSubtreeStream(adaptor,"rule atomic");
        try {
            // MOWLParser.g:92:41: (i= atomic ( INSTANCE_OF | TYPES ) expression -> ^( TYPE_ASSERTION ^( EXPRESSION expression ) ^( EXPRESSION $i) ) | subject= atomic propertyExpression value -> ^( ROLE_ASSERTION ^( EXPRESSION $subject) ^( EXPRESSION propertyExpression ) ^( EXPRESSION value ) ) | NOT assertionAxiom -> ^( NEGATED_ASSERTION assertionAxiom ) )
            int alt5=3;
            alt5 = dfa5.predict(input);
            switch (alt5) {
                case 1 :
                    // MOWLParser.g:93:3: i= atomic ( INSTANCE_OF | TYPES ) expression
                    {
                    pushFollow(FOLLOW_atomic_in_assertionAxiom520);
                    i=gOPPLParser.atomic();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_atomic.add(i.getTree());
                    // MOWLParser.g:93:14: ( INSTANCE_OF | TYPES )
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
                            // MOWLParser.g:93:15: INSTANCE_OF
                            {
                            INSTANCE_OF7=(Token)match(input,INSTANCE_OF,FOLLOW_INSTANCE_OF_in_assertionAxiom523); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_INSTANCE_OF.add(INSTANCE_OF7);


                            }
                            break;
                        case 2 :
                            // MOWLParser.g:93:29: TYPES
                            {
                            TYPES8=(Token)match(input,TYPES,FOLLOW_TYPES_in_assertionAxiom527); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_TYPES.add(TYPES8);


                            }
                            break;

                    }

                    pushFollow(FOLLOW_expression_in_assertionAxiom530);
                    expression9=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_expression.add(expression9.getTree());


                    // AST REWRITE
                    // elements: expression, i
                    // token labels: 
                    // rule labels: retval, i
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
                    RewriteRuleSubtreeStream stream_i=new RewriteRuleSubtreeStream(adaptor,"rule i",i!=null?i.tree:null);

                    root_0 = (OPPLSyntaxTree)adaptor.nil();
                    // 93:47: -> ^( TYPE_ASSERTION ^( EXPRESSION expression ) ^( EXPRESSION $i) )
                    {
                        // MOWLParser.g:93:50: ^( TYPE_ASSERTION ^( EXPRESSION expression ) ^( EXPRESSION $i) )
                        {
                        OPPLSyntaxTree root_1 = (OPPLSyntaxTree)adaptor.nil();
                        root_1 = (OPPLSyntaxTree)adaptor.becomeRoot((OPPLSyntaxTree)adaptor.create(TYPE_ASSERTION, "TYPE_ASSERTION"), root_1);

                        // MOWLParser.g:93:67: ^( EXPRESSION expression )
                        {
                        OPPLSyntaxTree root_2 = (OPPLSyntaxTree)adaptor.nil();
                        root_2 = (OPPLSyntaxTree)adaptor.becomeRoot((OPPLSyntaxTree)adaptor.create(EXPRESSION, "EXPRESSION"), root_2);

                        adaptor.addChild(root_2, stream_expression.nextTree());

                        adaptor.addChild(root_1, root_2);
                        }
                        // MOWLParser.g:93:92: ^( EXPRESSION $i)
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
                    // MOWLParser.g:94:7: subject= atomic propertyExpression value
                    {
                    pushFollow(FOLLOW_atomic_in_assertionAxiom561);
                    subject=gOPPLParser.atomic();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_atomic.add(subject.getTree());
                    pushFollow(FOLLOW_propertyExpression_in_assertionAxiom563);
                    propertyExpression10=propertyExpression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_propertyExpression.add(propertyExpression10.getTree());
                    pushFollow(FOLLOW_value_in_assertionAxiom566);
                    value11=value();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_value.add(value11.getTree());


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
                    // 94:50: -> ^( ROLE_ASSERTION ^( EXPRESSION $subject) ^( EXPRESSION propertyExpression ) ^( EXPRESSION value ) )
                    {
                        // MOWLParser.g:94:53: ^( ROLE_ASSERTION ^( EXPRESSION $subject) ^( EXPRESSION propertyExpression ) ^( EXPRESSION value ) )
                        {
                        OPPLSyntaxTree root_1 = (OPPLSyntaxTree)adaptor.nil();
                        root_1 = (OPPLSyntaxTree)adaptor.becomeRoot((OPPLSyntaxTree)adaptor.create(ROLE_ASSERTION, "ROLE_ASSERTION"), root_1);

                        // MOWLParser.g:94:70: ^( EXPRESSION $subject)
                        {
                        OPPLSyntaxTree root_2 = (OPPLSyntaxTree)adaptor.nil();
                        root_2 = (OPPLSyntaxTree)adaptor.becomeRoot((OPPLSyntaxTree)adaptor.create(EXPRESSION, "EXPRESSION"), root_2);

                        adaptor.addChild(root_2, stream_subject.nextTree());

                        adaptor.addChild(root_1, root_2);
                        }
                        // MOWLParser.g:94:93: ^( EXPRESSION propertyExpression )
                        {
                        OPPLSyntaxTree root_2 = (OPPLSyntaxTree)adaptor.nil();
                        root_2 = (OPPLSyntaxTree)adaptor.becomeRoot((OPPLSyntaxTree)adaptor.create(EXPRESSION, "EXPRESSION"), root_2);

                        adaptor.addChild(root_2, stream_propertyExpression.nextTree());

                        adaptor.addChild(root_1, root_2);
                        }
                        // MOWLParser.g:94:126: ^( EXPRESSION value )
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
                    // MOWLParser.g:96:5: NOT assertionAxiom
                    {
                    NOT12=(Token)match(input,NOT,FOLLOW_NOT_in_assertionAxiom600); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_NOT.add(NOT12);

                    pushFollow(FOLLOW_assertionAxiom_in_assertionAxiom602);
                    assertionAxiom13=assertionAxiom();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_assertionAxiom.add(assertionAxiom13.getTree());


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
                    // 96:24: -> ^( NEGATED_ASSERTION assertionAxiom )
                    {
                        // MOWLParser.g:96:27: ^( NEGATED_ASSERTION assertionAxiom )
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
    // MOWLParser.g:101:1: binaryAxiom options {backtrack=true; } : (lhs= expression SUBCLASS_OF superClass= expression -> ^( SUB_CLASS_AXIOM ^( EXPRESSION $lhs) ^( EXPRESSION $superClass) ) | lhs= expression EQUIVALENT_TO rhs= expression -> ^( EQUIVALENT_TO_AXIOM ^( EXPRESSION $lhs) ^( EXPRESSION $rhs) ) | lhs= expression DISJOINT_WITH disjoint= expression -> ^( DISJOINT_WITH_AXIOM ^( EXPRESSION $lhs) ^( EXPRESSION $disjoint) ) | lhs= expression SUB_PROPERTY_OF superProperty= propertyExpression -> ^( SUB_PROPERTY_AXIOM ^( EXPRESSION $lhs) ^( EXPRESSION $superProperty) ) | lhsID= atomic INVERSE_OF rhsAtomic= atomic -> ^( INVERSE_OF ^( EXPRESSION $lhsID) ^( EXPRESSION $rhsAtomic) ) | lhsID= atomic SAME_AS rhsID= atomic -> ^( SAME_AS_AXIOM ^( EXPRESSION $lhsID) ^( EXPRESSION $rhsID) ) | lhsID= atomic DIFFERENT_FROM rhsID= atomic -> ^( DIFFERENT_FROM_AXIOM ^( EXPRESSION $lhsID) ^( EXPRESSION $rhsID) ) | lhsID= atomic DOMAIN expression -> ^( DOMAIN ^( EXPRESSION $lhsID) ^( EXPRESSION expression ) ) | lhsID= atomic RANGE expression -> ^( RANGE ^( EXPRESSION $lhsID) ^( EXPRESSION expression ) ) );
    public final OPPLLintCombined_OPPLParser_MOWLParser.binaryAxiom_return binaryAxiom() throws RecognitionException {
        OPPLLintCombined_OPPLParser_MOWLParser.binaryAxiom_return retval = new OPPLLintCombined_OPPLParser_MOWLParser.binaryAxiom_return();
        retval.start = input.LT(1);

        OPPLSyntaxTree root_0 = null;

        Token SUBCLASS_OF14=null;
        Token EQUIVALENT_TO15=null;
        Token DISJOINT_WITH16=null;
        Token SUB_PROPERTY_OF17=null;
        Token INVERSE_OF18=null;
        Token SAME_AS19=null;
        Token DIFFERENT_FROM20=null;
        Token DOMAIN21=null;
        Token RANGE23=null;
        OPPLLintCombined_OPPLParser_MOWLParser.expression_return lhs = null;

        OPPLLintCombined_OPPLParser_MOWLParser.expression_return superClass = null;

        OPPLLintCombined_OPPLParser_MOWLParser.expression_return rhs = null;

        OPPLLintCombined_OPPLParser_MOWLParser.expression_return disjoint = null;

        OPPLLintCombined_OPPLParser_MOWLParser.propertyExpression_return superProperty = null;

        OPPLLintCombined_OPPLParser.atomic_return lhsID = null;

        OPPLLintCombined_OPPLParser.atomic_return rhsAtomic = null;

        OPPLLintCombined_OPPLParser.atomic_return rhsID = null;

        OPPLLintCombined_OPPLParser_MOWLParser.expression_return expression22 = null;

        OPPLLintCombined_OPPLParser_MOWLParser.expression_return expression24 = null;


        OPPLSyntaxTree SUBCLASS_OF14_tree=null;
        OPPLSyntaxTree EQUIVALENT_TO15_tree=null;
        OPPLSyntaxTree DISJOINT_WITH16_tree=null;
        OPPLSyntaxTree SUB_PROPERTY_OF17_tree=null;
        OPPLSyntaxTree INVERSE_OF18_tree=null;
        OPPLSyntaxTree SAME_AS19_tree=null;
        OPPLSyntaxTree DIFFERENT_FROM20_tree=null;
        OPPLSyntaxTree DOMAIN21_tree=null;
        OPPLSyntaxTree RANGE23_tree=null;
        RewriteRuleTokenStream stream_RANGE=new RewriteRuleTokenStream(adaptor,"token RANGE");
        RewriteRuleTokenStream stream_SAME_AS=new RewriteRuleTokenStream(adaptor,"token SAME_AS");
        RewriteRuleTokenStream stream_DISJOINT_WITH=new RewriteRuleTokenStream(adaptor,"token DISJOINT_WITH");
        RewriteRuleTokenStream stream_INVERSE_OF=new RewriteRuleTokenStream(adaptor,"token INVERSE_OF");
        RewriteRuleTokenStream stream_DIFFERENT_FROM=new RewriteRuleTokenStream(adaptor,"token DIFFERENT_FROM");
        RewriteRuleTokenStream stream_EQUIVALENT_TO=new RewriteRuleTokenStream(adaptor,"token EQUIVALENT_TO");
        RewriteRuleTokenStream stream_SUBCLASS_OF=new RewriteRuleTokenStream(adaptor,"token SUBCLASS_OF");
        RewriteRuleTokenStream stream_DOMAIN=new RewriteRuleTokenStream(adaptor,"token DOMAIN");
        RewriteRuleTokenStream stream_SUB_PROPERTY_OF=new RewriteRuleTokenStream(adaptor,"token SUB_PROPERTY_OF");
        RewriteRuleSubtreeStream stream_expression=new RewriteRuleSubtreeStream(adaptor,"rule expression");
        RewriteRuleSubtreeStream stream_propertyExpression=new RewriteRuleSubtreeStream(adaptor,"rule propertyExpression");
        RewriteRuleSubtreeStream stream_atomic=new RewriteRuleSubtreeStream(adaptor,"rule atomic");
        try {
            // MOWLParser.g:102:26: (lhs= expression SUBCLASS_OF superClass= expression -> ^( SUB_CLASS_AXIOM ^( EXPRESSION $lhs) ^( EXPRESSION $superClass) ) | lhs= expression EQUIVALENT_TO rhs= expression -> ^( EQUIVALENT_TO_AXIOM ^( EXPRESSION $lhs) ^( EXPRESSION $rhs) ) | lhs= expression DISJOINT_WITH disjoint= expression -> ^( DISJOINT_WITH_AXIOM ^( EXPRESSION $lhs) ^( EXPRESSION $disjoint) ) | lhs= expression SUB_PROPERTY_OF superProperty= propertyExpression -> ^( SUB_PROPERTY_AXIOM ^( EXPRESSION $lhs) ^( EXPRESSION $superProperty) ) | lhsID= atomic INVERSE_OF rhsAtomic= atomic -> ^( INVERSE_OF ^( EXPRESSION $lhsID) ^( EXPRESSION $rhsAtomic) ) | lhsID= atomic SAME_AS rhsID= atomic -> ^( SAME_AS_AXIOM ^( EXPRESSION $lhsID) ^( EXPRESSION $rhsID) ) | lhsID= atomic DIFFERENT_FROM rhsID= atomic -> ^( DIFFERENT_FROM_AXIOM ^( EXPRESSION $lhsID) ^( EXPRESSION $rhsID) ) | lhsID= atomic DOMAIN expression -> ^( DOMAIN ^( EXPRESSION $lhsID) ^( EXPRESSION expression ) ) | lhsID= atomic RANGE expression -> ^( RANGE ^( EXPRESSION $lhsID) ^( EXPRESSION expression ) ) )
            int alt6=9;
            alt6 = dfa6.predict(input);
            switch (alt6) {
                case 1 :
                    // MOWLParser.g:103:2: lhs= expression SUBCLASS_OF superClass= expression
                    {
                    pushFollow(FOLLOW_expression_in_binaryAxiom639);
                    lhs=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_expression.add(lhs.getTree());
                    SUBCLASS_OF14=(Token)match(input,SUBCLASS_OF,FOLLOW_SUBCLASS_OF_in_binaryAxiom641); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_SUBCLASS_OF.add(SUBCLASS_OF14);

                    pushFollow(FOLLOW_expression_in_binaryAxiom648);
                    superClass=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_expression.add(superClass.getTree());


                    // AST REWRITE
                    // elements: superClass, lhs
                    // token labels: 
                    // rule labels: retval, superClass, lhs
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
                    RewriteRuleSubtreeStream stream_superClass=new RewriteRuleSubtreeStream(adaptor,"rule superClass",superClass!=null?superClass.tree:null);
                    RewriteRuleSubtreeStream stream_lhs=new RewriteRuleSubtreeStream(adaptor,"rule lhs",lhs!=null?lhs.tree:null);

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
                    pushFollow(FOLLOW_expression_in_binaryAxiom686);
                    lhs=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_expression.add(lhs.getTree());
                    EQUIVALENT_TO15=(Token)match(input,EQUIVALENT_TO,FOLLOW_EQUIVALENT_TO_in_binaryAxiom688); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_EQUIVALENT_TO.add(EQUIVALENT_TO15);

                    pushFollow(FOLLOW_expression_in_binaryAxiom694);
                    rhs=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_expression.add(rhs.getTree());


                    // AST REWRITE
                    // elements: lhs, rhs
                    // token labels: 
                    // rule labels: retval, rhs, lhs
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
                    RewriteRuleSubtreeStream stream_rhs=new RewriteRuleSubtreeStream(adaptor,"rule rhs",rhs!=null?rhs.tree:null);
                    RewriteRuleSubtreeStream stream_lhs=new RewriteRuleSubtreeStream(adaptor,"rule lhs",lhs!=null?lhs.tree:null);

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
                    pushFollow(FOLLOW_expression_in_binaryAxiom731);
                    lhs=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_expression.add(lhs.getTree());
                    DISJOINT_WITH16=(Token)match(input,DISJOINT_WITH,FOLLOW_DISJOINT_WITH_in_binaryAxiom733); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_DISJOINT_WITH.add(DISJOINT_WITH16);

                    pushFollow(FOLLOW_expression_in_binaryAxiom739);
                    disjoint=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_expression.add(disjoint.getTree());


                    // AST REWRITE
                    // elements: disjoint, lhs
                    // token labels: 
                    // rule labels: retval, disjoint, lhs
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
                    RewriteRuleSubtreeStream stream_disjoint=new RewriteRuleSubtreeStream(adaptor,"rule disjoint",disjoint!=null?disjoint.tree:null);
                    RewriteRuleSubtreeStream stream_lhs=new RewriteRuleSubtreeStream(adaptor,"rule lhs",lhs!=null?lhs.tree:null);

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
                    pushFollow(FOLLOW_expression_in_binaryAxiom776);
                    lhs=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_expression.add(lhs.getTree());
                    SUB_PROPERTY_OF17=(Token)match(input,SUB_PROPERTY_OF,FOLLOW_SUB_PROPERTY_OF_in_binaryAxiom778); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_SUB_PROPERTY_OF.add(SUB_PROPERTY_OF17);

                    pushFollow(FOLLOW_propertyExpression_in_binaryAxiom784);
                    superProperty=propertyExpression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_propertyExpression.add(superProperty.getTree());


                    // AST REWRITE
                    // elements: superProperty, lhs
                    // token labels: 
                    // rule labels: retval, superProperty, lhs
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
                    RewriteRuleSubtreeStream stream_superProperty=new RewriteRuleSubtreeStream(adaptor,"rule superProperty",superProperty!=null?superProperty.tree:null);
                    RewriteRuleSubtreeStream stream_lhs=new RewriteRuleSubtreeStream(adaptor,"rule lhs",lhs!=null?lhs.tree:null);

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
                    pushFollow(FOLLOW_atomic_in_binaryAxiom821);
                    lhsID=gOPPLParser.atomic();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_atomic.add(lhsID.getTree());
                    INVERSE_OF18=(Token)match(input,INVERSE_OF,FOLLOW_INVERSE_OF_in_binaryAxiom823); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_INVERSE_OF.add(INVERSE_OF18);

                    pushFollow(FOLLOW_atomic_in_binaryAxiom829);
                    rhsAtomic=gOPPLParser.atomic();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_atomic.add(rhsAtomic.getTree());


                    // AST REWRITE
                    // elements: rhsAtomic, lhsID, INVERSE_OF
                    // token labels: 
                    // rule labels: lhsID, retval, rhsAtomic
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_lhsID=new RewriteRuleSubtreeStream(adaptor,"rule lhsID",lhsID!=null?lhsID.tree:null);
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
                    RewriteRuleSubtreeStream stream_rhsAtomic=new RewriteRuleSubtreeStream(adaptor,"rule rhsAtomic",rhsAtomic!=null?rhsAtomic.tree:null);

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
                    pushFollow(FOLLOW_atomic_in_binaryAxiom860);
                    lhsID=gOPPLParser.atomic();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_atomic.add(lhsID.getTree());
                    SAME_AS19=(Token)match(input,SAME_AS,FOLLOW_SAME_AS_in_binaryAxiom862); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_SAME_AS.add(SAME_AS19);

                    pushFollow(FOLLOW_atomic_in_binaryAxiom869);
                    rhsID=gOPPLParser.atomic();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_atomic.add(rhsID.getTree());


                    // AST REWRITE
                    // elements: rhsID, lhsID
                    // token labels: 
                    // rule labels: lhsID, retval, rhsID
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_lhsID=new RewriteRuleSubtreeStream(adaptor,"rule lhsID",lhsID!=null?lhsID.tree:null);
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
                    RewriteRuleSubtreeStream stream_rhsID=new RewriteRuleSubtreeStream(adaptor,"rule rhsID",rhsID!=null?rhsID.tree:null);

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
                    pushFollow(FOLLOW_atomic_in_binaryAxiom907);
                    lhsID=gOPPLParser.atomic();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_atomic.add(lhsID.getTree());
                    DIFFERENT_FROM20=(Token)match(input,DIFFERENT_FROM,FOLLOW_DIFFERENT_FROM_in_binaryAxiom909); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_DIFFERENT_FROM.add(DIFFERENT_FROM20);

                    pushFollow(FOLLOW_atomic_in_binaryAxiom916);
                    rhsID=gOPPLParser.atomic();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_atomic.add(rhsID.getTree());


                    // AST REWRITE
                    // elements: rhsID, lhsID
                    // token labels: 
                    // rule labels: lhsID, retval, rhsID
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_lhsID=new RewriteRuleSubtreeStream(adaptor,"rule lhsID",lhsID!=null?lhsID.tree:null);
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
                    RewriteRuleSubtreeStream stream_rhsID=new RewriteRuleSubtreeStream(adaptor,"rule rhsID",rhsID!=null?rhsID.tree:null);

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
                    pushFollow(FOLLOW_atomic_in_binaryAxiom953);
                    lhsID=gOPPLParser.atomic();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_atomic.add(lhsID.getTree());
                    DOMAIN21=(Token)match(input,DOMAIN,FOLLOW_DOMAIN_in_binaryAxiom956); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_DOMAIN.add(DOMAIN21);

                    pushFollow(FOLLOW_expression_in_binaryAxiom958);
                    expression22=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_expression.add(expression22.getTree());


                    // AST REWRITE
                    // elements: expression, lhsID, DOMAIN
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
                    pushFollow(FOLLOW_atomic_in_binaryAxiom994);
                    lhsID=gOPPLParser.atomic();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_atomic.add(lhsID.getTree());
                    RANGE23=(Token)match(input,RANGE,FOLLOW_RANGE_in_binaryAxiom996); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_RANGE.add(RANGE23);

                    pushFollow(FOLLOW_expression_in_binaryAxiom998);
                    expression24=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_expression.add(expression24.getTree());


                    // AST REWRITE
                    // elements: expression, RANGE, lhsID
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
    public final OPPLLintCombined_OPPLParser_MOWLParser.unaryAxiom_return unaryAxiom() throws RecognitionException {
        OPPLLintCombined_OPPLParser_MOWLParser.unaryAxiom_return retval = new OPPLLintCombined_OPPLParser_MOWLParser.unaryAxiom_return();
        retval.start = input.LT(1);

        OPPLSyntaxTree root_0 = null;

        OPPLLintCombined_OPPLParser_MOWLParser.unaryCharacteristic_return unaryCharacteristic25 = null;

        OPPLLintCombined_OPPLParser_MOWLParser.unary_return unary26 = null;


        RewriteRuleSubtreeStream stream_unary=new RewriteRuleSubtreeStream(adaptor,"rule unary");
        RewriteRuleSubtreeStream stream_unaryCharacteristic=new RewriteRuleSubtreeStream(adaptor,"rule unaryCharacteristic");
        try {
            // MOWLParser.g:115:13: ( unaryCharacteristic unary -> ^( UNARY_AXIOM unaryCharacteristic ^( EXPRESSION unary ) ) )
            // MOWLParser.g:116:4: unaryCharacteristic unary
            {
            pushFollow(FOLLOW_unaryCharacteristic_in_unaryAxiom1072);
            unaryCharacteristic25=unaryCharacteristic();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_unaryCharacteristic.add(unaryCharacteristic25.getTree());
            pushFollow(FOLLOW_unary_in_unaryAxiom1076);
            unary26=unary();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_unary.add(unary26.getTree());


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
    public final OPPLLintCombined_OPPLParser_MOWLParser.unaryCharacteristic_return unaryCharacteristic() throws RecognitionException {
        OPPLLintCombined_OPPLParser_MOWLParser.unaryCharacteristic_return retval = new OPPLLintCombined_OPPLParser_MOWLParser.unaryCharacteristic_return();
        retval.start = input.LT(1);

        OPPLSyntaxTree root_0 = null;

        Token FUNCTIONAL27=null;
        Token INVERSE_FUNCTIONAL28=null;
        Token SYMMETRIC29=null;
        Token ANTI_SYMMETRIC30=null;
        Token REFLEXIVE31=null;
        Token IRREFLEXIVE32=null;
        Token TRANSITIVE33=null;

        OPPLSyntaxTree FUNCTIONAL27_tree=null;
        OPPLSyntaxTree INVERSE_FUNCTIONAL28_tree=null;
        OPPLSyntaxTree SYMMETRIC29_tree=null;
        OPPLSyntaxTree ANTI_SYMMETRIC30_tree=null;
        OPPLSyntaxTree REFLEXIVE31_tree=null;
        OPPLSyntaxTree IRREFLEXIVE32_tree=null;
        OPPLSyntaxTree TRANSITIVE33_tree=null;
        RewriteRuleTokenStream stream_REFLEXIVE=new RewriteRuleTokenStream(adaptor,"token REFLEXIVE");
        RewriteRuleTokenStream stream_SYMMETRIC=new RewriteRuleTokenStream(adaptor,"token SYMMETRIC");
        RewriteRuleTokenStream stream_FUNCTIONAL=new RewriteRuleTokenStream(adaptor,"token FUNCTIONAL");
        RewriteRuleTokenStream stream_TRANSITIVE=new RewriteRuleTokenStream(adaptor,"token TRANSITIVE");
        RewriteRuleTokenStream stream_ANTI_SYMMETRIC=new RewriteRuleTokenStream(adaptor,"token ANTI_SYMMETRIC");
        RewriteRuleTokenStream stream_INVERSE_FUNCTIONAL=new RewriteRuleTokenStream(adaptor,"token INVERSE_FUNCTIONAL");
        RewriteRuleTokenStream stream_IRREFLEXIVE=new RewriteRuleTokenStream(adaptor,"token IRREFLEXIVE");

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
                    FUNCTIONAL27=(Token)match(input,FUNCTIONAL,FOLLOW_FUNCTIONAL_in_unaryCharacteristic1121); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_FUNCTIONAL.add(FUNCTIONAL27);



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
                    INVERSE_FUNCTIONAL28=(Token)match(input,INVERSE_FUNCTIONAL,FOLLOW_INVERSE_FUNCTIONAL_in_unaryCharacteristic1135); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_INVERSE_FUNCTIONAL.add(INVERSE_FUNCTIONAL28);



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
                    SYMMETRIC29=(Token)match(input,SYMMETRIC,FOLLOW_SYMMETRIC_in_unaryCharacteristic1149); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_SYMMETRIC.add(SYMMETRIC29);



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
                    ANTI_SYMMETRIC30=(Token)match(input,ANTI_SYMMETRIC,FOLLOW_ANTI_SYMMETRIC_in_unaryCharacteristic1163); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_ANTI_SYMMETRIC.add(ANTI_SYMMETRIC30);



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
                    REFLEXIVE31=(Token)match(input,REFLEXIVE,FOLLOW_REFLEXIVE_in_unaryCharacteristic1177); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_REFLEXIVE.add(REFLEXIVE31);



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
                    IRREFLEXIVE32=(Token)match(input,IRREFLEXIVE,FOLLOW_IRREFLEXIVE_in_unaryCharacteristic1191); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_IRREFLEXIVE.add(IRREFLEXIVE32);



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
                    TRANSITIVE33=(Token)match(input,TRANSITIVE,FOLLOW_TRANSITIVE_in_unaryCharacteristic1205); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_TRANSITIVE.add(TRANSITIVE33);



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
    // MOWLParser.g:129:1: expression : ( options {backtrack=true; } : disjunction -> ^( disjunction ) | complexPropertyExpression -> ^( complexPropertyExpression ) | OPEN_PARENTHESYS expression CLOSED_PARENTHESYS -> ^( expression ) ) ;
    public final OPPLLintCombined_OPPLParser_MOWLParser.expression_return expression() throws RecognitionException {
        OPPLLintCombined_OPPLParser_MOWLParser.expression_return retval = new OPPLLintCombined_OPPLParser_MOWLParser.expression_return();
        retval.start = input.LT(1);

        OPPLSyntaxTree root_0 = null;

        Token OPEN_PARENTHESYS36=null;
        Token CLOSED_PARENTHESYS38=null;
        OPPLLintCombined_OPPLParser_MOWLParser.disjunction_return disjunction34 = null;

        OPPLLintCombined_OPPLParser_MOWLParser.complexPropertyExpression_return complexPropertyExpression35 = null;

        OPPLLintCombined_OPPLParser_MOWLParser.expression_return expression37 = null;


        OPPLSyntaxTree OPEN_PARENTHESYS36_tree=null;
        OPPLSyntaxTree CLOSED_PARENTHESYS38_tree=null;
        RewriteRuleTokenStream stream_CLOSED_PARENTHESYS=new RewriteRuleTokenStream(adaptor,"token CLOSED_PARENTHESYS");
        RewriteRuleTokenStream stream_OPEN_PARENTHESYS=new RewriteRuleTokenStream(adaptor,"token OPEN_PARENTHESYS");
        RewriteRuleSubtreeStream stream_expression=new RewriteRuleSubtreeStream(adaptor,"rule expression");
        RewriteRuleSubtreeStream stream_disjunction=new RewriteRuleSubtreeStream(adaptor,"rule disjunction");
        RewriteRuleSubtreeStream stream_complexPropertyExpression=new RewriteRuleSubtreeStream(adaptor,"rule complexPropertyExpression");
        try {
            // MOWLParser.g:129:11: ( ( options {backtrack=true; } : disjunction -> ^( disjunction ) | complexPropertyExpression -> ^( complexPropertyExpression ) | OPEN_PARENTHESYS expression CLOSED_PARENTHESYS -> ^( expression ) ) )
            // MOWLParser.g:130:5: ( options {backtrack=true; } : disjunction -> ^( disjunction ) | complexPropertyExpression -> ^( complexPropertyExpression ) | OPEN_PARENTHESYS expression CLOSED_PARENTHESYS -> ^( expression ) )
            {
            // MOWLParser.g:130:5: ( options {backtrack=true; } : disjunction -> ^( disjunction ) | complexPropertyExpression -> ^( complexPropertyExpression ) | OPEN_PARENTHESYS expression CLOSED_PARENTHESYS -> ^( expression ) )
            int alt8=3;
            alt8 = dfa8.predict(input);
            switch (alt8) {
                case 1 :
                    // MOWLParser.g:132:5: disjunction
                    {
                    pushFollow(FOLLOW_disjunction_in_expression1247);
                    disjunction34=disjunction();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_disjunction.add(disjunction34.getTree());


                    // AST REWRITE
                    // elements: disjunction
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (OPPLSyntaxTree)adaptor.nil();
                    // 132:17: -> ^( disjunction )
                    {
                        // MOWLParser.g:132:20: ^( disjunction )
                        {
                        OPPLSyntaxTree root_1 = (OPPLSyntaxTree)adaptor.nil();
                        root_1 = (OPPLSyntaxTree)adaptor.becomeRoot(stream_disjunction.nextNode(), root_1);

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 2 :
                    // MOWLParser.g:133:6: complexPropertyExpression
                    {
                    pushFollow(FOLLOW_complexPropertyExpression_in_expression1260);
                    complexPropertyExpression35=complexPropertyExpression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_complexPropertyExpression.add(complexPropertyExpression35.getTree());


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
                    OPEN_PARENTHESYS36=(Token)match(input,OPEN_PARENTHESYS,FOLLOW_OPEN_PARENTHESYS_in_expression1273); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_OPEN_PARENTHESYS.add(OPEN_PARENTHESYS36);

                    pushFollow(FOLLOW_expression_in_expression1275);
                    expression37=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_expression.add(expression37.getTree());
                    CLOSED_PARENTHESYS38=(Token)match(input,CLOSED_PARENTHESYS,FOLLOW_CLOSED_PARENTHESYS_in_expression1277); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_CLOSED_PARENTHESYS.add(CLOSED_PARENTHESYS38);



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

    public static class disjunction_return extends ParserRuleReturnScope {
        OPPLSyntaxTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "disjunction"
    // MOWLParser.g:141:1: disjunction : conjunction ( OR conjunction )* -> ^( DISJUNCTION ( conjunction )+ ) ;
    public final OPPLLintCombined_OPPLParser_MOWLParser.disjunction_return disjunction() throws RecognitionException {
        OPPLLintCombined_OPPLParser_MOWLParser.disjunction_return retval = new OPPLLintCombined_OPPLParser_MOWLParser.disjunction_return();
        retval.start = input.LT(1);

        OPPLSyntaxTree root_0 = null;

        Token OR40=null;
        OPPLLintCombined_OPPLParser_MOWLParser.conjunction_return conjunction39 = null;

        OPPLLintCombined_OPPLParser_MOWLParser.conjunction_return conjunction41 = null;


        OPPLSyntaxTree OR40_tree=null;
        RewriteRuleTokenStream stream_OR=new RewriteRuleTokenStream(adaptor,"token OR");
        RewriteRuleSubtreeStream stream_conjunction=new RewriteRuleSubtreeStream(adaptor,"rule conjunction");
        try {
            // MOWLParser.g:142:2: ( conjunction ( OR conjunction )* -> ^( DISJUNCTION ( conjunction )+ ) )
            // MOWLParser.g:143:3: conjunction ( OR conjunction )*
            {
            pushFollow(FOLLOW_conjunction_in_disjunction1307);
            conjunction39=conjunction();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_conjunction.add(conjunction39.getTree());
            // MOWLParser.g:143:15: ( OR conjunction )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==OR) ) {
                    int LA9_2 = input.LA(2);

                    if ( (synpred27_MOWLParser()) ) {
                        alt9=1;
                    }


                }


                switch (alt9) {
            	case 1 :
            	    // MOWLParser.g:143:16: OR conjunction
            	    {
            	    OR40=(Token)match(input,OR,FOLLOW_OR_in_disjunction1310); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_OR.add(OR40);

            	    pushFollow(FOLLOW_conjunction_in_disjunction1312);
            	    conjunction41=conjunction();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_conjunction.add(conjunction41.getTree());

            	    }
            	    break;

            	default :
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
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (OPPLSyntaxTree)adaptor.nil();
            // 143:33: -> ^( DISJUNCTION ( conjunction )+ )
            {
                // MOWLParser.g:143:36: ^( DISJUNCTION ( conjunction )+ )
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
    // $ANTLR end "disjunction"

    public static class conjunction_return extends ParserRuleReturnScope {
        OPPLSyntaxTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "conjunction"
    // MOWLParser.g:146:1: conjunction : unary ( AND unary )* -> ^( CONJUNCTION ( unary )+ ) ;
    public final OPPLLintCombined_OPPLParser_MOWLParser.conjunction_return conjunction() throws RecognitionException {
        OPPLLintCombined_OPPLParser_MOWLParser.conjunction_return retval = new OPPLLintCombined_OPPLParser_MOWLParser.conjunction_return();
        retval.start = input.LT(1);

        OPPLSyntaxTree root_0 = null;

        Token AND43=null;
        OPPLLintCombined_OPPLParser_MOWLParser.unary_return unary42 = null;

        OPPLLintCombined_OPPLParser_MOWLParser.unary_return unary44 = null;


        OPPLSyntaxTree AND43_tree=null;
        RewriteRuleTokenStream stream_AND=new RewriteRuleTokenStream(adaptor,"token AND");
        RewriteRuleSubtreeStream stream_unary=new RewriteRuleSubtreeStream(adaptor,"rule unary");
        try {
            // MOWLParser.g:146:13: ( unary ( AND unary )* -> ^( CONJUNCTION ( unary )+ ) )
            // MOWLParser.g:147:5: unary ( AND unary )*
            {
            pushFollow(FOLLOW_unary_in_conjunction1339);
            unary42=unary();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_unary.add(unary42.getTree());
            // MOWLParser.g:147:11: ( AND unary )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==AND) ) {
                    int LA10_2 = input.LA(2);

                    if ( (synpred28_MOWLParser()) ) {
                        alt10=1;
                    }


                }


                switch (alt10) {
            	case 1 :
            	    // MOWLParser.g:147:12: AND unary
            	    {
            	    AND43=(Token)match(input,AND,FOLLOW_AND_in_conjunction1342); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_AND.add(AND43);

            	    pushFollow(FOLLOW_unary_in_conjunction1344);
            	    unary44=unary();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_unary.add(unary44.getTree());

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
            // 147:24: -> ^( CONJUNCTION ( unary )+ )
            {
                // MOWLParser.g:147:27: ^( CONJUNCTION ( unary )+ )
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
    // MOWLParser.g:150:1: complexPropertyExpression : INVERSE OPEN_PARENTHESYS propertyExpression CLOSED_PARENTHESYS -> ^( INVERSE_OBJECT_PROPERTY_EXPRESSION propertyExpression ) ;
    public final OPPLLintCombined_OPPLParser_MOWLParser.complexPropertyExpression_return complexPropertyExpression() throws RecognitionException {
        OPPLLintCombined_OPPLParser_MOWLParser.complexPropertyExpression_return retval = new OPPLLintCombined_OPPLParser_MOWLParser.complexPropertyExpression_return();
        retval.start = input.LT(1);

        OPPLSyntaxTree root_0 = null;

        Token INVERSE45=null;
        Token OPEN_PARENTHESYS46=null;
        Token CLOSED_PARENTHESYS48=null;
        OPPLLintCombined_OPPLParser_MOWLParser.propertyExpression_return propertyExpression47 = null;


        OPPLSyntaxTree INVERSE45_tree=null;
        OPPLSyntaxTree OPEN_PARENTHESYS46_tree=null;
        OPPLSyntaxTree CLOSED_PARENTHESYS48_tree=null;
        RewriteRuleTokenStream stream_INVERSE=new RewriteRuleTokenStream(adaptor,"token INVERSE");
        RewriteRuleTokenStream stream_CLOSED_PARENTHESYS=new RewriteRuleTokenStream(adaptor,"token CLOSED_PARENTHESYS");
        RewriteRuleTokenStream stream_OPEN_PARENTHESYS=new RewriteRuleTokenStream(adaptor,"token OPEN_PARENTHESYS");
        RewriteRuleSubtreeStream stream_propertyExpression=new RewriteRuleSubtreeStream(adaptor,"rule propertyExpression");
        try {
            // MOWLParser.g:150:26: ( INVERSE OPEN_PARENTHESYS propertyExpression CLOSED_PARENTHESYS -> ^( INVERSE_OBJECT_PROPERTY_EXPRESSION propertyExpression ) )
            // MOWLParser.g:151:2: INVERSE OPEN_PARENTHESYS propertyExpression CLOSED_PARENTHESYS
            {
            INVERSE45=(Token)match(input,INVERSE,FOLLOW_INVERSE_in_complexPropertyExpression1365); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_INVERSE.add(INVERSE45);

            OPEN_PARENTHESYS46=(Token)match(input,OPEN_PARENTHESYS,FOLLOW_OPEN_PARENTHESYS_in_complexPropertyExpression1367); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_OPEN_PARENTHESYS.add(OPEN_PARENTHESYS46);

            pushFollow(FOLLOW_propertyExpression_in_complexPropertyExpression1369);
            propertyExpression47=propertyExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_propertyExpression.add(propertyExpression47.getTree());
            CLOSED_PARENTHESYS48=(Token)match(input,CLOSED_PARENTHESYS,FOLLOW_CLOSED_PARENTHESYS_in_complexPropertyExpression1371); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_CLOSED_PARENTHESYS.add(CLOSED_PARENTHESYS48);



            // AST REWRITE
            // elements: propertyExpression
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (OPPLSyntaxTree)adaptor.nil();
            // 151:65: -> ^( INVERSE_OBJECT_PROPERTY_EXPRESSION propertyExpression )
            {
                // MOWLParser.g:151:68: ^( INVERSE_OBJECT_PROPERTY_EXPRESSION propertyExpression )
                {
                OPPLSyntaxTree root_1 = (OPPLSyntaxTree)adaptor.nil();
                root_1 = (OPPLSyntaxTree)adaptor.becomeRoot((OPPLSyntaxTree)adaptor.create(INVERSE_OBJECT_PROPERTY_EXPRESSION, "INVERSE_OBJECT_PROPERTY_EXPRESSION"), root_1);

                adaptor.addChild(root_1, stream_propertyExpression.nextTree());

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
    // $ANTLR end "complexPropertyExpression"

    public static class unary_return extends ParserRuleReturnScope {
        OPPLSyntaxTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "unary"
    // MOWLParser.g:155:1: unary options {backtrack=true; } : (head= propertyExpression ( COMPOSITION rest+= propertyExpression )+ -> ^( PROPERTY_CHAIN $head $rest) | NOT OPEN_PARENTHESYS expression CLOSED_PARENTHESYS -> ^( NEGATED_EXPRESSION expression ) | NOT atomic -> ^( NEGATED_EXPRESSION atomic ) | qualifiedRestriction -> ^( qualifiedRestriction ) | dataRange | constant | atomic );
    public final OPPLLintCombined_OPPLParser_MOWLParser.unary_return unary() throws RecognitionException {
        OPPLLintCombined_OPPLParser_MOWLParser.unary_return retval = new OPPLLintCombined_OPPLParser_MOWLParser.unary_return();
        retval.start = input.LT(1);

        OPPLSyntaxTree root_0 = null;

        Token COMPOSITION49=null;
        Token NOT50=null;
        Token OPEN_PARENTHESYS51=null;
        Token CLOSED_PARENTHESYS53=null;
        Token NOT54=null;
        List list_rest=null;
        OPPLLintCombined_OPPLParser_MOWLParser.propertyExpression_return head = null;

        OPPLLintCombined_OPPLParser_MOWLParser.expression_return expression52 = null;

        OPPLLintCombined_OPPLParser.atomic_return atomic55 = null;

        OPPLLintCombined_OPPLParser_MOWLParser.qualifiedRestriction_return qualifiedRestriction56 = null;

        OPPLLintCombined_OPPLParser_MOWLParser.dataRange_return dataRange57 = null;

        OPPLLintCombined_OPPLParser_MOWLParser.constant_return constant58 = null;

        OPPLLintCombined_OPPLParser.atomic_return atomic59 = null;

        RuleReturnScope rest = null;
        OPPLSyntaxTree COMPOSITION49_tree=null;
        OPPLSyntaxTree NOT50_tree=null;
        OPPLSyntaxTree OPEN_PARENTHESYS51_tree=null;
        OPPLSyntaxTree CLOSED_PARENTHESYS53_tree=null;
        OPPLSyntaxTree NOT54_tree=null;
        RewriteRuleTokenStream stream_NOT=new RewriteRuleTokenStream(adaptor,"token NOT");
        RewriteRuleTokenStream stream_CLOSED_PARENTHESYS=new RewriteRuleTokenStream(adaptor,"token CLOSED_PARENTHESYS");
        RewriteRuleTokenStream stream_COMPOSITION=new RewriteRuleTokenStream(adaptor,"token COMPOSITION");
        RewriteRuleTokenStream stream_OPEN_PARENTHESYS=new RewriteRuleTokenStream(adaptor,"token OPEN_PARENTHESYS");
        RewriteRuleSubtreeStream stream_expression=new RewriteRuleSubtreeStream(adaptor,"rule expression");
        RewriteRuleSubtreeStream stream_qualifiedRestriction=new RewriteRuleSubtreeStream(adaptor,"rule qualifiedRestriction");
        RewriteRuleSubtreeStream stream_propertyExpression=new RewriteRuleSubtreeStream(adaptor,"rule propertyExpression");
        RewriteRuleSubtreeStream stream_atomic=new RewriteRuleSubtreeStream(adaptor,"rule atomic");
        try {
            // MOWLParser.g:155:34: (head= propertyExpression ( COMPOSITION rest+= propertyExpression )+ -> ^( PROPERTY_CHAIN $head $rest) | NOT OPEN_PARENTHESYS expression CLOSED_PARENTHESYS -> ^( NEGATED_EXPRESSION expression ) | NOT atomic -> ^( NEGATED_EXPRESSION atomic ) | qualifiedRestriction -> ^( qualifiedRestriction ) | dataRange | constant | atomic )
            int alt12=7;
            alt12 = dfa12.predict(input);
            switch (alt12) {
                case 1 :
                    // MOWLParser.g:157:4: head= propertyExpression ( COMPOSITION rest+= propertyExpression )+
                    {
                    pushFollow(FOLLOW_propertyExpression_in_unary1411);
                    head=propertyExpression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_propertyExpression.add(head.getTree());
                    // MOWLParser.g:157:30: ( COMPOSITION rest+= propertyExpression )+
                    int cnt11=0;
                    loop11:
                    do {
                        int alt11=2;
                        int LA11_0 = input.LA(1);

                        if ( (LA11_0==COMPOSITION) ) {
                            alt11=1;
                        }


                        switch (alt11) {
                    	case 1 :
                    	    // MOWLParser.g:157:31: COMPOSITION rest+= propertyExpression
                    	    {
                    	    COMPOSITION49=(Token)match(input,COMPOSITION,FOLLOW_COMPOSITION_in_unary1414); if (state.failed) return retval; 
                    	    if ( state.backtracking==0 ) stream_COMPOSITION.add(COMPOSITION49);

                    	    pushFollow(FOLLOW_propertyExpression_in_unary1418);
                    	    rest=propertyExpression();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) stream_propertyExpression.add(rest.getTree());
                    	    if (list_rest==null) list_rest=new ArrayList();
                    	    list_rest.add(rest.getTree());


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt11 >= 1 ) break loop11;
                    	    if (state.backtracking>0) {state.failed=true; return retval;}
                                EarlyExitException eee =
                                    new EarlyExitException(11, input);
                                throw eee;
                        }
                        cnt11++;
                    } while (true);



                    // AST REWRITE
                    // elements: rest, head
                    // token labels: 
                    // rule labels: retval, head
                    // token list labels: 
                    // rule list labels: rest
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
                    RewriteRuleSubtreeStream stream_head=new RewriteRuleSubtreeStream(adaptor,"rule head",head!=null?head.tree:null);
                    RewriteRuleSubtreeStream stream_rest=new RewriteRuleSubtreeStream(adaptor,"token rest",list_rest);
                    root_0 = (OPPLSyntaxTree)adaptor.nil();
                    // 157:71: -> ^( PROPERTY_CHAIN $head $rest)
                    {
                        // MOWLParser.g:157:74: ^( PROPERTY_CHAIN $head $rest)
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
                    // MOWLParser.g:158:5: NOT OPEN_PARENTHESYS expression CLOSED_PARENTHESYS
                    {
                    NOT50=(Token)match(input,NOT,FOLLOW_NOT_in_unary1440); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_NOT.add(NOT50);

                    OPEN_PARENTHESYS51=(Token)match(input,OPEN_PARENTHESYS,FOLLOW_OPEN_PARENTHESYS_in_unary1442); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_OPEN_PARENTHESYS.add(OPEN_PARENTHESYS51);

                    pushFollow(FOLLOW_expression_in_unary1444);
                    expression52=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_expression.add(expression52.getTree());
                    CLOSED_PARENTHESYS53=(Token)match(input,CLOSED_PARENTHESYS,FOLLOW_CLOSED_PARENTHESYS_in_unary1446); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_CLOSED_PARENTHESYS.add(CLOSED_PARENTHESYS53);



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
                    // 158:56: -> ^( NEGATED_EXPRESSION expression )
                    {
                        // MOWLParser.g:158:59: ^( NEGATED_EXPRESSION expression )
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
                    // MOWLParser.g:159:5: NOT atomic
                    {
                    NOT54=(Token)match(input,NOT,FOLLOW_NOT_in_unary1460); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_NOT.add(NOT54);

                    pushFollow(FOLLOW_atomic_in_unary1462);
                    atomic55=gOPPLParser.atomic();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_atomic.add(atomic55.getTree());


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
                    // 159:16: -> ^( NEGATED_EXPRESSION atomic )
                    {
                        // MOWLParser.g:159:19: ^( NEGATED_EXPRESSION atomic )
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
                    // MOWLParser.g:160:5: qualifiedRestriction
                    {
                    pushFollow(FOLLOW_qualifiedRestriction_in_unary1485);
                    qualifiedRestriction56=qualifiedRestriction();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_qualifiedRestriction.add(qualifiedRestriction56.getTree());


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
                    // 160:26: -> ^( qualifiedRestriction )
                    {
                        // MOWLParser.g:160:29: ^( qualifiedRestriction )
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
                    // MOWLParser.g:161:5: dataRange
                    {
                    root_0 = (OPPLSyntaxTree)adaptor.nil();

                    pushFollow(FOLLOW_dataRange_in_unary1497);
                    dataRange57=dataRange();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, dataRange57.getTree());

                    }
                    break;
                case 6 :
                    // MOWLParser.g:162:5: constant
                    {
                    root_0 = (OPPLSyntaxTree)adaptor.nil();

                    pushFollow(FOLLOW_constant_in_unary1503);
                    constant58=constant();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, constant58.getTree());

                    }
                    break;
                case 7 :
                    // MOWLParser.g:163:5: atomic
                    {
                    root_0 = (OPPLSyntaxTree)adaptor.nil();

                    pushFollow(FOLLOW_atomic_in_unary1509);
                    atomic59=gOPPLParser.atomic();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, atomic59.getTree());

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
    // MOWLParser.g:167:1: dataRange : IDENTIFIER OPEN_SQUARE_BRACKET dataRangeFacet ( COMMA dataRangeFacet )* CLOSED_SQUARE_BRACKET -> ^( DATA_RANGE IDENTIFIER ( dataRangeFacet )+ ) ;
    public final OPPLLintCombined_OPPLParser_MOWLParser.dataRange_return dataRange() throws RecognitionException {
        OPPLLintCombined_OPPLParser_MOWLParser.dataRange_return retval = new OPPLLintCombined_OPPLParser_MOWLParser.dataRange_return();
        retval.start = input.LT(1);

        OPPLSyntaxTree root_0 = null;

        Token IDENTIFIER60=null;
        Token OPEN_SQUARE_BRACKET61=null;
        Token COMMA63=null;
        Token CLOSED_SQUARE_BRACKET65=null;
        OPPLLintCombined_OPPLParser_MOWLParser.dataRangeFacet_return dataRangeFacet62 = null;

        OPPLLintCombined_OPPLParser_MOWLParser.dataRangeFacet_return dataRangeFacet64 = null;


        OPPLSyntaxTree IDENTIFIER60_tree=null;
        OPPLSyntaxTree OPEN_SQUARE_BRACKET61_tree=null;
        OPPLSyntaxTree COMMA63_tree=null;
        OPPLSyntaxTree CLOSED_SQUARE_BRACKET65_tree=null;
        RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
        RewriteRuleTokenStream stream_OPEN_SQUARE_BRACKET=new RewriteRuleTokenStream(adaptor,"token OPEN_SQUARE_BRACKET");
        RewriteRuleTokenStream stream_IDENTIFIER=new RewriteRuleTokenStream(adaptor,"token IDENTIFIER");
        RewriteRuleTokenStream stream_CLOSED_SQUARE_BRACKET=new RewriteRuleTokenStream(adaptor,"token CLOSED_SQUARE_BRACKET");
        RewriteRuleSubtreeStream stream_dataRangeFacet=new RewriteRuleSubtreeStream(adaptor,"rule dataRangeFacet");
        try {
            // MOWLParser.g:168:2: ( IDENTIFIER OPEN_SQUARE_BRACKET dataRangeFacet ( COMMA dataRangeFacet )* CLOSED_SQUARE_BRACKET -> ^( DATA_RANGE IDENTIFIER ( dataRangeFacet )+ ) )
            // MOWLParser.g:169:4: IDENTIFIER OPEN_SQUARE_BRACKET dataRangeFacet ( COMMA dataRangeFacet )* CLOSED_SQUARE_BRACKET
            {
            IDENTIFIER60=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_dataRange1526); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_IDENTIFIER.add(IDENTIFIER60);

            OPEN_SQUARE_BRACKET61=(Token)match(input,OPEN_SQUARE_BRACKET,FOLLOW_OPEN_SQUARE_BRACKET_in_dataRange1528); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_OPEN_SQUARE_BRACKET.add(OPEN_SQUARE_BRACKET61);

            pushFollow(FOLLOW_dataRangeFacet_in_dataRange1530);
            dataRangeFacet62=dataRangeFacet();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_dataRangeFacet.add(dataRangeFacet62.getTree());
            // MOWLParser.g:169:50: ( COMMA dataRangeFacet )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==COMMA) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // MOWLParser.g:169:51: COMMA dataRangeFacet
            	    {
            	    COMMA63=(Token)match(input,COMMA,FOLLOW_COMMA_in_dataRange1533); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_COMMA.add(COMMA63);

            	    pushFollow(FOLLOW_dataRangeFacet_in_dataRange1535);
            	    dataRangeFacet64=dataRangeFacet();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_dataRangeFacet.add(dataRangeFacet64.getTree());

            	    }
            	    break;

            	default :
            	    break loop13;
                }
            } while (true);

            CLOSED_SQUARE_BRACKET65=(Token)match(input,CLOSED_SQUARE_BRACKET,FOLLOW_CLOSED_SQUARE_BRACKET_in_dataRange1539); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_CLOSED_SQUARE_BRACKET.add(CLOSED_SQUARE_BRACKET65);



            // AST REWRITE
            // elements: IDENTIFIER, dataRangeFacet
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (OPPLSyntaxTree)adaptor.nil();
            // 169:96: -> ^( DATA_RANGE IDENTIFIER ( dataRangeFacet )+ )
            {
                // MOWLParser.g:169:99: ^( DATA_RANGE IDENTIFIER ( dataRangeFacet )+ )
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
    // MOWLParser.g:172:1: dataRangeFacet : ( LESS_THAN constant -> ^( LESS_THAN constant ) | LESS_THAN_EQUAL constant -> ^( LESS_THAN_EQUAL constant ) | GREATER_THAN constant -> ^( GREATER_THAN constant ) | GREATER_THAN_EQUAL constant -> ^( GREATER_THAN_EQUAL constant ) );
    public final OPPLLintCombined_OPPLParser_MOWLParser.dataRangeFacet_return dataRangeFacet() throws RecognitionException {
        OPPLLintCombined_OPPLParser_MOWLParser.dataRangeFacet_return retval = new OPPLLintCombined_OPPLParser_MOWLParser.dataRangeFacet_return();
        retval.start = input.LT(1);

        OPPLSyntaxTree root_0 = null;

        Token LESS_THAN66=null;
        Token LESS_THAN_EQUAL68=null;
        Token GREATER_THAN70=null;
        Token GREATER_THAN_EQUAL72=null;
        OPPLLintCombined_OPPLParser_MOWLParser.constant_return constant67 = null;

        OPPLLintCombined_OPPLParser_MOWLParser.constant_return constant69 = null;

        OPPLLintCombined_OPPLParser_MOWLParser.constant_return constant71 = null;

        OPPLLintCombined_OPPLParser_MOWLParser.constant_return constant73 = null;


        OPPLSyntaxTree LESS_THAN66_tree=null;
        OPPLSyntaxTree LESS_THAN_EQUAL68_tree=null;
        OPPLSyntaxTree GREATER_THAN70_tree=null;
        OPPLSyntaxTree GREATER_THAN_EQUAL72_tree=null;
        RewriteRuleTokenStream stream_LESS_THAN_EQUAL=new RewriteRuleTokenStream(adaptor,"token LESS_THAN_EQUAL");
        RewriteRuleTokenStream stream_GREATER_THAN_EQUAL=new RewriteRuleTokenStream(adaptor,"token GREATER_THAN_EQUAL");
        RewriteRuleTokenStream stream_GREATER_THAN=new RewriteRuleTokenStream(adaptor,"token GREATER_THAN");
        RewriteRuleTokenStream stream_LESS_THAN=new RewriteRuleTokenStream(adaptor,"token LESS_THAN");
        RewriteRuleSubtreeStream stream_constant=new RewriteRuleSubtreeStream(adaptor,"rule constant");
        try {
            // MOWLParser.g:173:2: ( LESS_THAN constant -> ^( LESS_THAN constant ) | LESS_THAN_EQUAL constant -> ^( LESS_THAN_EQUAL constant ) | GREATER_THAN constant -> ^( GREATER_THAN constant ) | GREATER_THAN_EQUAL constant -> ^( GREATER_THAN_EQUAL constant ) )
            int alt14=4;
            switch ( input.LA(1) ) {
            case LESS_THAN:
                {
                alt14=1;
                }
                break;
            case LESS_THAN_EQUAL:
                {
                alt14=2;
                }
                break;
            case GREATER_THAN:
                {
                alt14=3;
                }
                break;
            case GREATER_THAN_EQUAL:
                {
                alt14=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 14, 0, input);

                throw nvae;
            }

            switch (alt14) {
                case 1 :
                    // MOWLParser.g:174:3: LESS_THAN constant
                    {
                    LESS_THAN66=(Token)match(input,LESS_THAN,FOLLOW_LESS_THAN_in_dataRangeFacet1565); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_LESS_THAN.add(LESS_THAN66);

                    pushFollow(FOLLOW_constant_in_dataRangeFacet1567);
                    constant67=constant();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_constant.add(constant67.getTree());


                    // AST REWRITE
                    // elements: LESS_THAN, constant
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (OPPLSyntaxTree)adaptor.nil();
                    // 174:22: -> ^( LESS_THAN constant )
                    {
                        // MOWLParser.g:174:25: ^( LESS_THAN constant )
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
                    // MOWLParser.g:175:5: LESS_THAN_EQUAL constant
                    {
                    LESS_THAN_EQUAL68=(Token)match(input,LESS_THAN_EQUAL,FOLLOW_LESS_THAN_EQUAL_in_dataRangeFacet1581); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_LESS_THAN_EQUAL.add(LESS_THAN_EQUAL68);

                    pushFollow(FOLLOW_constant_in_dataRangeFacet1583);
                    constant69=constant();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_constant.add(constant69.getTree());


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
                    // 175:31: -> ^( LESS_THAN_EQUAL constant )
                    {
                        // MOWLParser.g:175:34: ^( LESS_THAN_EQUAL constant )
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
                    // MOWLParser.g:176:5: GREATER_THAN constant
                    {
                    GREATER_THAN70=(Token)match(input,GREATER_THAN,FOLLOW_GREATER_THAN_in_dataRangeFacet1598); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_GREATER_THAN.add(GREATER_THAN70);

                    pushFollow(FOLLOW_constant_in_dataRangeFacet1600);
                    constant71=constant();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_constant.add(constant71.getTree());


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
                    // 176:27: -> ^( GREATER_THAN constant )
                    {
                        // MOWLParser.g:176:30: ^( GREATER_THAN constant )
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
                    // MOWLParser.g:177:5: GREATER_THAN_EQUAL constant
                    {
                    GREATER_THAN_EQUAL72=(Token)match(input,GREATER_THAN_EQUAL,FOLLOW_GREATER_THAN_EQUAL_in_dataRangeFacet1614); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_GREATER_THAN_EQUAL.add(GREATER_THAN_EQUAL72);

                    pushFollow(FOLLOW_constant_in_dataRangeFacet1616);
                    constant73=constant();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_constant.add(constant73.getTree());


                    // AST REWRITE
                    // elements: GREATER_THAN_EQUAL, constant
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (OPPLSyntaxTree)adaptor.nil();
                    // 177:33: -> ^( GREATER_THAN_EQUAL constant )
                    {
                        // MOWLParser.g:177:36: ^( GREATER_THAN_EQUAL constant )
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
    // MOWLParser.g:185:1: qualifiedRestriction : ( options {backtrack=true; } : propertyExpression SOME expression -> ^( SOME_RESTRICTION propertyExpression expression ) | propertyExpression ONLY expression -> ^( ALL_RESTRICTION propertyExpression expression ) | cardinalityRestriction -> ^( cardinalityRestriction ) | oneOf -> ^( oneOf ) | valueRestriction -> ^( valueRestriction ) ) ;
    public final OPPLLintCombined_OPPLParser_MOWLParser.qualifiedRestriction_return qualifiedRestriction() throws RecognitionException {
        OPPLLintCombined_OPPLParser_MOWLParser.qualifiedRestriction_return retval = new OPPLLintCombined_OPPLParser_MOWLParser.qualifiedRestriction_return();
        retval.start = input.LT(1);

        OPPLSyntaxTree root_0 = null;

        Token SOME75=null;
        Token ONLY78=null;
        OPPLLintCombined_OPPLParser_MOWLParser.propertyExpression_return propertyExpression74 = null;

        OPPLLintCombined_OPPLParser_MOWLParser.expression_return expression76 = null;

        OPPLLintCombined_OPPLParser_MOWLParser.propertyExpression_return propertyExpression77 = null;

        OPPLLintCombined_OPPLParser_MOWLParser.expression_return expression79 = null;

        OPPLLintCombined_OPPLParser_MOWLParser.cardinalityRestriction_return cardinalityRestriction80 = null;

        OPPLLintCombined_OPPLParser_MOWLParser.oneOf_return oneOf81 = null;

        OPPLLintCombined_OPPLParser_MOWLParser.valueRestriction_return valueRestriction82 = null;


        OPPLSyntaxTree SOME75_tree=null;
        OPPLSyntaxTree ONLY78_tree=null;
        RewriteRuleTokenStream stream_ONLY=new RewriteRuleTokenStream(adaptor,"token ONLY");
        RewriteRuleTokenStream stream_SOME=new RewriteRuleTokenStream(adaptor,"token SOME");
        RewriteRuleSubtreeStream stream_expression=new RewriteRuleSubtreeStream(adaptor,"rule expression");
        RewriteRuleSubtreeStream stream_oneOf=new RewriteRuleSubtreeStream(adaptor,"rule oneOf");
        RewriteRuleSubtreeStream stream_propertyExpression=new RewriteRuleSubtreeStream(adaptor,"rule propertyExpression");
        RewriteRuleSubtreeStream stream_cardinalityRestriction=new RewriteRuleSubtreeStream(adaptor,"rule cardinalityRestriction");
        RewriteRuleSubtreeStream stream_valueRestriction=new RewriteRuleSubtreeStream(adaptor,"rule valueRestriction");
        try {
            // MOWLParser.g:185:21: ( ( options {backtrack=true; } : propertyExpression SOME expression -> ^( SOME_RESTRICTION propertyExpression expression ) | propertyExpression ONLY expression -> ^( ALL_RESTRICTION propertyExpression expression ) | cardinalityRestriction -> ^( cardinalityRestriction ) | oneOf -> ^( oneOf ) | valueRestriction -> ^( valueRestriction ) ) )
            // MOWLParser.g:186:9: ( options {backtrack=true; } : propertyExpression SOME expression -> ^( SOME_RESTRICTION propertyExpression expression ) | propertyExpression ONLY expression -> ^( ALL_RESTRICTION propertyExpression expression ) | cardinalityRestriction -> ^( cardinalityRestriction ) | oneOf -> ^( oneOf ) | valueRestriction -> ^( valueRestriction ) )
            {
            // MOWLParser.g:186:9: ( options {backtrack=true; } : propertyExpression SOME expression -> ^( SOME_RESTRICTION propertyExpression expression ) | propertyExpression ONLY expression -> ^( ALL_RESTRICTION propertyExpression expression ) | cardinalityRestriction -> ^( cardinalityRestriction ) | oneOf -> ^( oneOf ) | valueRestriction -> ^( valueRestriction ) )
            int alt16=5;
            alt16 = dfa16.predict(input);
            switch (alt16) {
                case 1 :
                    // MOWLParser.g:188:7: propertyExpression SOME expression
                    {
                    pushFollow(FOLLOW_propertyExpression_in_qualifiedRestriction1696);
                    propertyExpression74=propertyExpression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_propertyExpression.add(propertyExpression74.getTree());
                    SOME75=(Token)match(input,SOME,FOLLOW_SOME_in_qualifiedRestriction1699); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_SOME.add(SOME75);

                    pushFollow(FOLLOW_expression_in_qualifiedRestriction1703);
                    expression76=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_expression.add(expression76.getTree());


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
                    // 188:46: -> ^( SOME_RESTRICTION propertyExpression expression )
                    {
                        // MOWLParser.g:188:49: ^( SOME_RESTRICTION propertyExpression expression )
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
                    // MOWLParser.g:189:7: propertyExpression ONLY expression
                    {
                    pushFollow(FOLLOW_propertyExpression_in_qualifiedRestriction1732);
                    propertyExpression77=propertyExpression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_propertyExpression.add(propertyExpression77.getTree());
                    ONLY78=(Token)match(input,ONLY,FOLLOW_ONLY_in_qualifiedRestriction1734); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_ONLY.add(ONLY78);

                    pushFollow(FOLLOW_expression_in_qualifiedRestriction1737);
                    expression79=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_expression.add(expression79.getTree());


                    // AST REWRITE
                    // elements: expression, propertyExpression
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (OPPLSyntaxTree)adaptor.nil();
                    // 189:44: -> ^( ALL_RESTRICTION propertyExpression expression )
                    {
                        // MOWLParser.g:189:47: ^( ALL_RESTRICTION propertyExpression expression )
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
                    // MOWLParser.g:190:7: cardinalityRestriction
                    {
                    pushFollow(FOLLOW_cardinalityRestriction_in_qualifiedRestriction1756);
                    cardinalityRestriction80=cardinalityRestriction();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_cardinalityRestriction.add(cardinalityRestriction80.getTree());


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
                    // 190:30: -> ^( cardinalityRestriction )
                    {
                        // MOWLParser.g:190:33: ^( cardinalityRestriction )
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
                    // MOWLParser.g:191:7: oneOf
                    {
                    pushFollow(FOLLOW_oneOf_in_qualifiedRestriction1770);
                    oneOf81=oneOf();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_oneOf.add(oneOf81.getTree());


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
                    // 191:13: -> ^( oneOf )
                    {
                        // MOWLParser.g:191:16: ^( oneOf )
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
                    // MOWLParser.g:192:7: valueRestriction
                    {
                    pushFollow(FOLLOW_valueRestriction_in_qualifiedRestriction1784);
                    valueRestriction82=valueRestriction();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_valueRestriction.add(valueRestriction82.getTree());


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
                    // 192:24: -> ^( valueRestriction )
                    {
                        // MOWLParser.g:192:27: ^( valueRestriction )
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
    // MOWLParser.g:196:1: propertyExpression : ( atomic -> ^( atomic ) | complexPropertyExpression -> ^( complexPropertyExpression ) );
    public final OPPLLintCombined_OPPLParser_MOWLParser.propertyExpression_return propertyExpression() throws RecognitionException {
        OPPLLintCombined_OPPLParser_MOWLParser.propertyExpression_return retval = new OPPLLintCombined_OPPLParser_MOWLParser.propertyExpression_return();
        retval.start = input.LT(1);

        OPPLSyntaxTree root_0 = null;

        OPPLLintCombined_OPPLParser.atomic_return atomic83 = null;

        OPPLLintCombined_OPPLParser_MOWLParser.complexPropertyExpression_return complexPropertyExpression84 = null;


        RewriteRuleSubtreeStream stream_complexPropertyExpression=new RewriteRuleSubtreeStream(adaptor,"rule complexPropertyExpression");
        RewriteRuleSubtreeStream stream_atomic=new RewriteRuleSubtreeStream(adaptor,"rule atomic");
        try {
            // MOWLParser.g:196:21: ( atomic -> ^( atomic ) | complexPropertyExpression -> ^( complexPropertyExpression ) )
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( ((LA17_0>=IDENTIFIER && LA17_0<=ENTITY_REFERENCE)||LA17_0==ESCLAMATION_MARK||LA17_0==VARIABLE_NAME) ) {
                alt17=1;
            }
            else if ( (LA17_0==INVERSE) ) {
                alt17=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 17, 0, input);

                throw nvae;
            }
            switch (alt17) {
                case 1 :
                    // MOWLParser.g:197:7: atomic
                    {
                    pushFollow(FOLLOW_atomic_in_propertyExpression1816);
                    atomic83=gOPPLParser.atomic();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_atomic.add(atomic83.getTree());


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
                    // 197:14: -> ^( atomic )
                    {
                        // MOWLParser.g:197:17: ^( atomic )
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
                    // MOWLParser.g:198:7: complexPropertyExpression
                    {
                    pushFollow(FOLLOW_complexPropertyExpression_in_propertyExpression1830);
                    complexPropertyExpression84=complexPropertyExpression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_complexPropertyExpression.add(complexPropertyExpression84.getTree());


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
                    // 198:33: -> ^( complexPropertyExpression )
                    {
                        // MOWLParser.g:198:36: ^( complexPropertyExpression )
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
    // MOWLParser.g:201:1: cardinalityRestriction options {backtrack=true; } : propertyExpression restrictionKind INTEGER ( unary )? -> ^( CARDINALITY_RESTRICTION restrictionKind INTEGER propertyExpression ( unary )? ) ;
    public final OPPLLintCombined_OPPLParser_MOWLParser.cardinalityRestriction_return cardinalityRestriction() throws RecognitionException {
        OPPLLintCombined_OPPLParser_MOWLParser.cardinalityRestriction_return retval = new OPPLLintCombined_OPPLParser_MOWLParser.cardinalityRestriction_return();
        retval.start = input.LT(1);

        OPPLSyntaxTree root_0 = null;

        Token INTEGER87=null;
        OPPLLintCombined_OPPLParser_MOWLParser.propertyExpression_return propertyExpression85 = null;

        OPPLLintCombined_OPPLParser_MOWLParser.restrictionKind_return restrictionKind86 = null;

        OPPLLintCombined_OPPLParser_MOWLParser.unary_return unary88 = null;


        OPPLSyntaxTree INTEGER87_tree=null;
        RewriteRuleTokenStream stream_INTEGER=new RewriteRuleTokenStream(adaptor,"token INTEGER");
        RewriteRuleSubtreeStream stream_unary=new RewriteRuleSubtreeStream(adaptor,"rule unary");
        RewriteRuleSubtreeStream stream_propertyExpression=new RewriteRuleSubtreeStream(adaptor,"rule propertyExpression");
        RewriteRuleSubtreeStream stream_restrictionKind=new RewriteRuleSubtreeStream(adaptor,"rule restrictionKind");
        try {
            // MOWLParser.g:202:28: ( propertyExpression restrictionKind INTEGER ( unary )? -> ^( CARDINALITY_RESTRICTION restrictionKind INTEGER propertyExpression ( unary )? ) )
            // MOWLParser.g:203:2: propertyExpression restrictionKind INTEGER ( unary )?
            {
            pushFollow(FOLLOW_propertyExpression_in_cardinalityRestriction1872);
            propertyExpression85=propertyExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_propertyExpression.add(propertyExpression85.getTree());
            pushFollow(FOLLOW_restrictionKind_in_cardinalityRestriction1875);
            restrictionKind86=restrictionKind();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_restrictionKind.add(restrictionKind86.getTree());
            INTEGER87=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_cardinalityRestriction1877); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_INTEGER.add(INTEGER87);

            // MOWLParser.g:203:46: ( unary )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==OPEN_CURLY_BRACES||LA18_0==NOT||LA18_0==INVERSE||LA18_0==DBLQUOTE||(LA18_0>=IDENTIFIER && LA18_0<=ENTITY_REFERENCE)||LA18_0==ESCLAMATION_MARK||LA18_0==VARIABLE_NAME) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // MOWLParser.g:0:0: unary
                    {
                    pushFollow(FOLLOW_unary_in_cardinalityRestriction1879);
                    unary88=unary();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_unary.add(unary88.getTree());

                    }
                    break;

            }



            // AST REWRITE
            // elements: INTEGER, unary, propertyExpression, restrictionKind
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (OPPLSyntaxTree)adaptor.nil();
            // 203:53: -> ^( CARDINALITY_RESTRICTION restrictionKind INTEGER propertyExpression ( unary )? )
            {
                // MOWLParser.g:203:56: ^( CARDINALITY_RESTRICTION restrictionKind INTEGER propertyExpression ( unary )? )
                {
                OPPLSyntaxTree root_1 = (OPPLSyntaxTree)adaptor.nil();
                root_1 = (OPPLSyntaxTree)adaptor.becomeRoot((OPPLSyntaxTree)adaptor.create(CARDINALITY_RESTRICTION, "CARDINALITY_RESTRICTION"), root_1);

                adaptor.addChild(root_1, stream_restrictionKind.nextTree());
                adaptor.addChild(root_1, stream_INTEGER.nextNode());
                adaptor.addChild(root_1, stream_propertyExpression.nextTree());
                // MOWLParser.g:203:127: ( unary )?
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
    // MOWLParser.g:206:1: restrictionKind : ( MIN -> ^( MIN ) | MAX -> ^( MAX ) | EXACTLY -> ^( EXACTLY ) );
    public final OPPLLintCombined_OPPLParser_MOWLParser.restrictionKind_return restrictionKind() throws RecognitionException {
        OPPLLintCombined_OPPLParser_MOWLParser.restrictionKind_return retval = new OPPLLintCombined_OPPLParser_MOWLParser.restrictionKind_return();
        retval.start = input.LT(1);

        OPPLSyntaxTree root_0 = null;

        Token MIN89=null;
        Token MAX90=null;
        Token EXACTLY91=null;

        OPPLSyntaxTree MIN89_tree=null;
        OPPLSyntaxTree MAX90_tree=null;
        OPPLSyntaxTree EXACTLY91_tree=null;
        RewriteRuleTokenStream stream_MAX=new RewriteRuleTokenStream(adaptor,"token MAX");
        RewriteRuleTokenStream stream_MIN=new RewriteRuleTokenStream(adaptor,"token MIN");
        RewriteRuleTokenStream stream_EXACTLY=new RewriteRuleTokenStream(adaptor,"token EXACTLY");

        try {
            // MOWLParser.g:206:17: ( MIN -> ^( MIN ) | MAX -> ^( MAX ) | EXACTLY -> ^( EXACTLY ) )
            int alt19=3;
            switch ( input.LA(1) ) {
            case MIN:
                {
                alt19=1;
                }
                break;
            case MAX:
                {
                alt19=2;
                }
                break;
            case EXACTLY:
                {
                alt19=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 19, 0, input);

                throw nvae;
            }

            switch (alt19) {
                case 1 :
                    // MOWLParser.g:207:5: MIN
                    {
                    MIN89=(Token)match(input,MIN,FOLLOW_MIN_in_restrictionKind1912); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_MIN.add(MIN89);



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
                    // 207:9: -> ^( MIN )
                    {
                        // MOWLParser.g:207:12: ^( MIN )
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
                    // MOWLParser.g:208:7: MAX
                    {
                    MAX90=(Token)match(input,MAX,FOLLOW_MAX_in_restrictionKind1926); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_MAX.add(MAX90);



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
                    // 208:11: -> ^( MAX )
                    {
                        // MOWLParser.g:208:14: ^( MAX )
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
                    // MOWLParser.g:209:7: EXACTLY
                    {
                    EXACTLY91=(Token)match(input,EXACTLY,FOLLOW_EXACTLY_in_restrictionKind1940); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_EXACTLY.add(EXACTLY91);



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
                    // 209:15: -> ^( EXACTLY )
                    {
                        // MOWLParser.g:209:18: ^( EXACTLY )
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
    // MOWLParser.g:213:1: oneOf : OPEN_CURLY_BRACES atomic ( COMMA atomic )* CLOSED_CURLY_BRACES -> ^( ONE_OF ( atomic )+ ) ;
    public final OPPLLintCombined_OPPLParser_MOWLParser.oneOf_return oneOf() throws RecognitionException {
        OPPLLintCombined_OPPLParser_MOWLParser.oneOf_return retval = new OPPLLintCombined_OPPLParser_MOWLParser.oneOf_return();
        retval.start = input.LT(1);

        OPPLSyntaxTree root_0 = null;

        Token OPEN_CURLY_BRACES92=null;
        Token COMMA94=null;
        Token CLOSED_CURLY_BRACES96=null;
        OPPLLintCombined_OPPLParser.atomic_return atomic93 = null;

        OPPLLintCombined_OPPLParser.atomic_return atomic95 = null;


        OPPLSyntaxTree OPEN_CURLY_BRACES92_tree=null;
        OPPLSyntaxTree COMMA94_tree=null;
        OPPLSyntaxTree CLOSED_CURLY_BRACES96_tree=null;
        RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
        RewriteRuleTokenStream stream_CLOSED_CURLY_BRACES=new RewriteRuleTokenStream(adaptor,"token CLOSED_CURLY_BRACES");
        RewriteRuleTokenStream stream_OPEN_CURLY_BRACES=new RewriteRuleTokenStream(adaptor,"token OPEN_CURLY_BRACES");
        RewriteRuleSubtreeStream stream_atomic=new RewriteRuleSubtreeStream(adaptor,"rule atomic");
        try {
            // MOWLParser.g:213:7: ( OPEN_CURLY_BRACES atomic ( COMMA atomic )* CLOSED_CURLY_BRACES -> ^( ONE_OF ( atomic )+ ) )
            // MOWLParser.g:214:3: OPEN_CURLY_BRACES atomic ( COMMA atomic )* CLOSED_CURLY_BRACES
            {
            OPEN_CURLY_BRACES92=(Token)match(input,OPEN_CURLY_BRACES,FOLLOW_OPEN_CURLY_BRACES_in_oneOf1962); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_OPEN_CURLY_BRACES.add(OPEN_CURLY_BRACES92);

            pushFollow(FOLLOW_atomic_in_oneOf1964);
            atomic93=gOPPLParser.atomic();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_atomic.add(atomic93.getTree());
            // MOWLParser.g:214:28: ( COMMA atomic )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0==COMMA) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // MOWLParser.g:214:29: COMMA atomic
            	    {
            	    COMMA94=(Token)match(input,COMMA,FOLLOW_COMMA_in_oneOf1967); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_COMMA.add(COMMA94);

            	    pushFollow(FOLLOW_atomic_in_oneOf1969);
            	    atomic95=gOPPLParser.atomic();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_atomic.add(atomic95.getTree());

            	    }
            	    break;

            	default :
            	    break loop20;
                }
            } while (true);

            CLOSED_CURLY_BRACES96=(Token)match(input,CLOSED_CURLY_BRACES,FOLLOW_CLOSED_CURLY_BRACES_in_oneOf1973); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_CLOSED_CURLY_BRACES.add(CLOSED_CURLY_BRACES96);



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
            // 214:64: -> ^( ONE_OF ( atomic )+ )
            {
                // MOWLParser.g:214:67: ^( ONE_OF ( atomic )+ )
                {
                OPPLSyntaxTree root_1 = (OPPLSyntaxTree)adaptor.nil();
                root_1 = (OPPLSyntaxTree)adaptor.becomeRoot((OPPLSyntaxTree)adaptor.create(ONE_OF, "ONE_OF"), root_1);

                if ( !(stream_atomic.hasNext()) ) {
                    throw new RewriteEarlyExitException();
                }
                while ( stream_atomic.hasNext() ) {
                    adaptor.addChild(root_1, stream_atomic.nextTree());

                }
                stream_atomic.reset();

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
    // MOWLParser.g:217:1: valueRestriction : propertyExpression VALUE value -> ^( VALUE_RESTRICTION propertyExpression value ) ;
    public final OPPLLintCombined_OPPLParser_MOWLParser.valueRestriction_return valueRestriction() throws RecognitionException {
        OPPLLintCombined_OPPLParser_MOWLParser.valueRestriction_return retval = new OPPLLintCombined_OPPLParser_MOWLParser.valueRestriction_return();
        retval.start = input.LT(1);

        OPPLSyntaxTree root_0 = null;

        Token VALUE98=null;
        OPPLLintCombined_OPPLParser_MOWLParser.propertyExpression_return propertyExpression97 = null;

        OPPLLintCombined_OPPLParser_MOWLParser.value_return value99 = null;


        OPPLSyntaxTree VALUE98_tree=null;
        RewriteRuleTokenStream stream_VALUE=new RewriteRuleTokenStream(adaptor,"token VALUE");
        RewriteRuleSubtreeStream stream_propertyExpression=new RewriteRuleSubtreeStream(adaptor,"rule propertyExpression");
        RewriteRuleSubtreeStream stream_value=new RewriteRuleSubtreeStream(adaptor,"rule value");
        try {
            // MOWLParser.g:217:18: ( propertyExpression VALUE value -> ^( VALUE_RESTRICTION propertyExpression value ) )
            // MOWLParser.g:217:20: propertyExpression VALUE value
            {
            pushFollow(FOLLOW_propertyExpression_in_valueRestriction1993);
            propertyExpression97=propertyExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_propertyExpression.add(propertyExpression97.getTree());
            VALUE98=(Token)match(input,VALUE,FOLLOW_VALUE_in_valueRestriction1995); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_VALUE.add(VALUE98);

            pushFollow(FOLLOW_value_in_valueRestriction1997);
            value99=value();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_value.add(value99.getTree());


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
            // 217:51: -> ^( VALUE_RESTRICTION propertyExpression value )
            {
                // MOWLParser.g:217:54: ^( VALUE_RESTRICTION propertyExpression value )
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
    // MOWLParser.g:220:1: value : ( atomic -> ^( atomic ) | constant -> ^( constant ) );
    public final OPPLLintCombined_OPPLParser_MOWLParser.value_return value() throws RecognitionException {
        OPPLLintCombined_OPPLParser_MOWLParser.value_return retval = new OPPLLintCombined_OPPLParser_MOWLParser.value_return();
        retval.start = input.LT(1);

        OPPLSyntaxTree root_0 = null;

        OPPLLintCombined_OPPLParser.atomic_return atomic100 = null;

        OPPLLintCombined_OPPLParser_MOWLParser.constant_return constant101 = null;


        RewriteRuleSubtreeStream stream_constant=new RewriteRuleSubtreeStream(adaptor,"rule constant");
        RewriteRuleSubtreeStream stream_atomic=new RewriteRuleSubtreeStream(adaptor,"rule atomic");
        try {
            // MOWLParser.g:220:6: ( atomic -> ^( atomic ) | constant -> ^( constant ) )
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( ((LA21_0>=IDENTIFIER && LA21_0<=ENTITY_REFERENCE)||LA21_0==ESCLAMATION_MARK||LA21_0==VARIABLE_NAME) ) {
                alt21=1;
            }
            else if ( (LA21_0==DBLQUOTE) ) {
                alt21=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 21, 0, input);

                throw nvae;
            }
            switch (alt21) {
                case 1 :
                    // MOWLParser.g:221:7: atomic
                    {
                    pushFollow(FOLLOW_atomic_in_value2022);
                    atomic100=gOPPLParser.atomic();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_atomic.add(atomic100.getTree());


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
                    // 221:14: -> ^( atomic )
                    {
                        // MOWLParser.g:221:17: ^( atomic )
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
                    // MOWLParser.g:222:7: constant
                    {
                    pushFollow(FOLLOW_constant_in_value2037);
                    constant101=constant();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_constant.add(constant101.getTree());


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
                    // 222:16: -> ^( constant )
                    {
                        // MOWLParser.g:222:19: ^( constant )
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
    // MOWLParser.g:225:1: constant : constantValue= DBLQUOTE ( AT language= IDENTIFIER )? ( POW type= IDENTIFIER )? -> ^( CONSTANT $constantValue ( ^( AT $language) )? ( $type)? ) ;
    public final OPPLLintCombined_OPPLParser_MOWLParser.constant_return constant() throws RecognitionException {
        OPPLLintCombined_OPPLParser_MOWLParser.constant_return retval = new OPPLLintCombined_OPPLParser_MOWLParser.constant_return();
        retval.start = input.LT(1);

        OPPLSyntaxTree root_0 = null;

        Token constantValue=null;
        Token language=null;
        Token type=null;
        Token AT102=null;
        Token POW103=null;

        OPPLSyntaxTree constantValue_tree=null;
        OPPLSyntaxTree language_tree=null;
        OPPLSyntaxTree type_tree=null;
        OPPLSyntaxTree AT102_tree=null;
        OPPLSyntaxTree POW103_tree=null;
        RewriteRuleTokenStream stream_AT=new RewriteRuleTokenStream(adaptor,"token AT");
        RewriteRuleTokenStream stream_POW=new RewriteRuleTokenStream(adaptor,"token POW");
        RewriteRuleTokenStream stream_IDENTIFIER=new RewriteRuleTokenStream(adaptor,"token IDENTIFIER");
        RewriteRuleTokenStream stream_DBLQUOTE=new RewriteRuleTokenStream(adaptor,"token DBLQUOTE");

        try {
            // MOWLParser.g:225:11: (constantValue= DBLQUOTE ( AT language= IDENTIFIER )? ( POW type= IDENTIFIER )? -> ^( CONSTANT $constantValue ( ^( AT $language) )? ( $type)? ) )
            // MOWLParser.g:225:14: constantValue= DBLQUOTE ( AT language= IDENTIFIER )? ( POW type= IDENTIFIER )?
            {
            constantValue=(Token)match(input,DBLQUOTE,FOLLOW_DBLQUOTE_in_constant2062); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_DBLQUOTE.add(constantValue);

            // MOWLParser.g:225:39: ( AT language= IDENTIFIER )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==AT) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // MOWLParser.g:225:40: AT language= IDENTIFIER
                    {
                    AT102=(Token)match(input,AT,FOLLOW_AT_in_constant2065); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_AT.add(AT102);

                    language=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_constant2071); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_IDENTIFIER.add(language);


                    }
                    break;

            }

            // MOWLParser.g:225:67: ( POW type= IDENTIFIER )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==POW) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // MOWLParser.g:225:69: POW type= IDENTIFIER
                    {
                    POW103=(Token)match(input,POW,FOLLOW_POW_in_constant2077); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_POW.add(POW103);

                    type=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_constant2083); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_IDENTIFIER.add(type);


                    }
                    break;

            }



            // AST REWRITE
            // elements: type, language, AT, constantValue
            // token labels: constantValue, language, type
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleTokenStream stream_constantValue=new RewriteRuleTokenStream(adaptor,"token constantValue",constantValue);
            RewriteRuleTokenStream stream_language=new RewriteRuleTokenStream(adaptor,"token language",language);
            RewriteRuleTokenStream stream_type=new RewriteRuleTokenStream(adaptor,"token type",type);
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (OPPLSyntaxTree)adaptor.nil();
            // 225:93: -> ^( CONSTANT $constantValue ( ^( AT $language) )? ( $type)? )
            {
                // MOWLParser.g:225:95: ^( CONSTANT $constantValue ( ^( AT $language) )? ( $type)? )
                {
                OPPLSyntaxTree root_1 = (OPPLSyntaxTree)adaptor.nil();
                root_1 = (OPPLSyntaxTree)adaptor.becomeRoot((OPPLSyntaxTree)adaptor.create(CONSTANT, "CONSTANT"), root_1);

                adaptor.addChild(root_1, stream_constantValue.nextNode());
                // MOWLParser.g:225:121: ( ^( AT $language) )?
                if ( stream_language.hasNext()||stream_AT.hasNext() ) {
                    // MOWLParser.g:225:122: ^( AT $language)
                    {
                    OPPLSyntaxTree root_2 = (OPPLSyntaxTree)adaptor.nil();
                    root_2 = (OPPLSyntaxTree)adaptor.becomeRoot(stream_AT.nextNode(), root_2);

                    adaptor.addChild(root_2, stream_language.nextNode());

                    adaptor.addChild(root_1, root_2);
                    }

                }
                stream_language.reset();
                stream_AT.reset();
                // MOWLParser.g:225:140: ( $type)?
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

    // $ANTLR start synpred7_MOWLParser
    public final void synpred7_MOWLParser_fragment() throws RecognitionException {   
        // MOWLParser.g:87:48: ( COMMA propertyExpression )
        // MOWLParser.g:87:48: COMMA propertyExpression
        {
        match(input,COMMA,FOLLOW_COMMA_in_synpred7_MOWLParser469); if (state.failed) return ;
        pushFollow(FOLLOW_propertyExpression_in_synpred7_MOWLParser471);
        propertyExpression();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred7_MOWLParser

    // $ANTLR start synpred11_MOWLParser
    public final void synpred11_MOWLParser_fragment() throws RecognitionException {   
        OPPLLintCombined_OPPLParser_MOWLParser.expression_return lhs = null;

        OPPLLintCombined_OPPLParser_MOWLParser.expression_return superClass = null;


        // MOWLParser.g:103:2: (lhs= expression SUBCLASS_OF superClass= expression )
        // MOWLParser.g:103:2: lhs= expression SUBCLASS_OF superClass= expression
        {
        pushFollow(FOLLOW_expression_in_synpred11_MOWLParser639);
        lhs=expression();

        state._fsp--;
        if (state.failed) return ;
        match(input,SUBCLASS_OF,FOLLOW_SUBCLASS_OF_in_synpred11_MOWLParser641); if (state.failed) return ;
        pushFollow(FOLLOW_expression_in_synpred11_MOWLParser648);
        superClass=expression();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred11_MOWLParser

    // $ANTLR start synpred12_MOWLParser
    public final void synpred12_MOWLParser_fragment() throws RecognitionException {   
        OPPLLintCombined_OPPLParser_MOWLParser.expression_return lhs = null;

        OPPLLintCombined_OPPLParser_MOWLParser.expression_return rhs = null;


        // MOWLParser.g:104:11: (lhs= expression EQUIVALENT_TO rhs= expression )
        // MOWLParser.g:104:11: lhs= expression EQUIVALENT_TO rhs= expression
        {
        pushFollow(FOLLOW_expression_in_synpred12_MOWLParser686);
        lhs=expression();

        state._fsp--;
        if (state.failed) return ;
        match(input,EQUIVALENT_TO,FOLLOW_EQUIVALENT_TO_in_synpred12_MOWLParser688); if (state.failed) return ;
        pushFollow(FOLLOW_expression_in_synpred12_MOWLParser694);
        rhs=expression();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred12_MOWLParser

    // $ANTLR start synpred13_MOWLParser
    public final void synpred13_MOWLParser_fragment() throws RecognitionException {   
        OPPLLintCombined_OPPLParser_MOWLParser.expression_return lhs = null;

        OPPLLintCombined_OPPLParser_MOWLParser.expression_return disjoint = null;


        // MOWLParser.g:105:11: (lhs= expression DISJOINT_WITH disjoint= expression )
        // MOWLParser.g:105:11: lhs= expression DISJOINT_WITH disjoint= expression
        {
        pushFollow(FOLLOW_expression_in_synpred13_MOWLParser731);
        lhs=expression();

        state._fsp--;
        if (state.failed) return ;
        match(input,DISJOINT_WITH,FOLLOW_DISJOINT_WITH_in_synpred13_MOWLParser733); if (state.failed) return ;
        pushFollow(FOLLOW_expression_in_synpred13_MOWLParser739);
        disjoint=expression();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred13_MOWLParser

    // $ANTLR start synpred14_MOWLParser
    public final void synpred14_MOWLParser_fragment() throws RecognitionException {   
        OPPLLintCombined_OPPLParser_MOWLParser.expression_return lhs = null;

        OPPLLintCombined_OPPLParser_MOWLParser.propertyExpression_return superProperty = null;


        // MOWLParser.g:106:11: (lhs= expression SUB_PROPERTY_OF superProperty= propertyExpression )
        // MOWLParser.g:106:11: lhs= expression SUB_PROPERTY_OF superProperty= propertyExpression
        {
        pushFollow(FOLLOW_expression_in_synpred14_MOWLParser776);
        lhs=expression();

        state._fsp--;
        if (state.failed) return ;
        match(input,SUB_PROPERTY_OF,FOLLOW_SUB_PROPERTY_OF_in_synpred14_MOWLParser778); if (state.failed) return ;
        pushFollow(FOLLOW_propertyExpression_in_synpred14_MOWLParser784);
        superProperty=propertyExpression();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred14_MOWLParser

    // $ANTLR start synpred15_MOWLParser
    public final void synpred15_MOWLParser_fragment() throws RecognitionException {   
        OPPLLintCombined_OPPLParser.atomic_return lhsID = null;

        OPPLLintCombined_OPPLParser.atomic_return rhsAtomic = null;


        // MOWLParser.g:107:11: (lhsID= atomic INVERSE_OF rhsAtomic= atomic )
        // MOWLParser.g:107:11: lhsID= atomic INVERSE_OF rhsAtomic= atomic
        {
        pushFollow(FOLLOW_atomic_in_synpred15_MOWLParser821);
        lhsID=gOPPLParser.atomic();

        state._fsp--;
        if (state.failed) return ;
        match(input,INVERSE_OF,FOLLOW_INVERSE_OF_in_synpred15_MOWLParser823); if (state.failed) return ;
        pushFollow(FOLLOW_atomic_in_synpred15_MOWLParser829);
        rhsAtomic=gOPPLParser.atomic();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred15_MOWLParser

    // $ANTLR start synpred16_MOWLParser
    public final void synpred16_MOWLParser_fragment() throws RecognitionException {   
        OPPLLintCombined_OPPLParser.atomic_return lhsID = null;

        OPPLLintCombined_OPPLParser.atomic_return rhsID = null;


        // MOWLParser.g:108:3: (lhsID= atomic SAME_AS rhsID= atomic )
        // MOWLParser.g:108:3: lhsID= atomic SAME_AS rhsID= atomic
        {
        pushFollow(FOLLOW_atomic_in_synpred16_MOWLParser860);
        lhsID=gOPPLParser.atomic();

        state._fsp--;
        if (state.failed) return ;
        match(input,SAME_AS,FOLLOW_SAME_AS_in_synpred16_MOWLParser862); if (state.failed) return ;
        pushFollow(FOLLOW_atomic_in_synpred16_MOWLParser869);
        rhsID=gOPPLParser.atomic();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred16_MOWLParser

    // $ANTLR start synpred17_MOWLParser
    public final void synpred17_MOWLParser_fragment() throws RecognitionException {   
        OPPLLintCombined_OPPLParser.atomic_return lhsID = null;

        OPPLLintCombined_OPPLParser.atomic_return rhsID = null;


        // MOWLParser.g:109:11: (lhsID= atomic DIFFERENT_FROM rhsID= atomic )
        // MOWLParser.g:109:11: lhsID= atomic DIFFERENT_FROM rhsID= atomic
        {
        pushFollow(FOLLOW_atomic_in_synpred17_MOWLParser907);
        lhsID=gOPPLParser.atomic();

        state._fsp--;
        if (state.failed) return ;
        match(input,DIFFERENT_FROM,FOLLOW_DIFFERENT_FROM_in_synpred17_MOWLParser909); if (state.failed) return ;
        pushFollow(FOLLOW_atomic_in_synpred17_MOWLParser916);
        rhsID=gOPPLParser.atomic();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred17_MOWLParser

    // $ANTLR start synpred18_MOWLParser
    public final void synpred18_MOWLParser_fragment() throws RecognitionException {   
        OPPLLintCombined_OPPLParser.atomic_return lhsID = null;


        // MOWLParser.g:110:11: (lhsID= atomic DOMAIN expression )
        // MOWLParser.g:110:11: lhsID= atomic DOMAIN expression
        {
        pushFollow(FOLLOW_atomic_in_synpred18_MOWLParser953);
        lhsID=gOPPLParser.atomic();

        state._fsp--;
        if (state.failed) return ;
        match(input,DOMAIN,FOLLOW_DOMAIN_in_synpred18_MOWLParser956); if (state.failed) return ;
        pushFollow(FOLLOW_expression_in_synpred18_MOWLParser958);
        expression();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred18_MOWLParser

    // $ANTLR start synpred25_MOWLParser
    public final void synpred25_MOWLParser_fragment() throws RecognitionException {   
        // MOWLParser.g:132:5: ( disjunction )
        // MOWLParser.g:132:5: disjunction
        {
        pushFollow(FOLLOW_disjunction_in_synpred25_MOWLParser1247);
        disjunction();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred25_MOWLParser

    // $ANTLR start synpred26_MOWLParser
    public final void synpred26_MOWLParser_fragment() throws RecognitionException {   
        // MOWLParser.g:133:6: ( complexPropertyExpression )
        // MOWLParser.g:133:6: complexPropertyExpression
        {
        pushFollow(FOLLOW_complexPropertyExpression_in_synpred26_MOWLParser1260);
        complexPropertyExpression();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred26_MOWLParser

    // $ANTLR start synpred27_MOWLParser
    public final void synpred27_MOWLParser_fragment() throws RecognitionException {   
        // MOWLParser.g:143:16: ( OR conjunction )
        // MOWLParser.g:143:16: OR conjunction
        {
        match(input,OR,FOLLOW_OR_in_synpred27_MOWLParser1310); if (state.failed) return ;
        pushFollow(FOLLOW_conjunction_in_synpred27_MOWLParser1312);
        conjunction();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred27_MOWLParser

    // $ANTLR start synpred28_MOWLParser
    public final void synpred28_MOWLParser_fragment() throws RecognitionException {   
        // MOWLParser.g:147:12: ( AND unary )
        // MOWLParser.g:147:12: AND unary
        {
        match(input,AND,FOLLOW_AND_in_synpred28_MOWLParser1342); if (state.failed) return ;
        pushFollow(FOLLOW_unary_in_synpred28_MOWLParser1344);
        unary();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred28_MOWLParser

    // $ANTLR start synpred30_MOWLParser
    public final void synpred30_MOWLParser_fragment() throws RecognitionException {   
        List list_rest=null;
        OPPLLintCombined_OPPLParser_MOWLParser.propertyExpression_return head = null;

        RuleReturnScope rest = null;
        // MOWLParser.g:157:4: (head= propertyExpression ( COMPOSITION rest+= propertyExpression )+ )
        // MOWLParser.g:157:4: head= propertyExpression ( COMPOSITION rest+= propertyExpression )+
        {
        pushFollow(FOLLOW_propertyExpression_in_synpred30_MOWLParser1411);
        head=propertyExpression();

        state._fsp--;
        if (state.failed) return ;
        // MOWLParser.g:157:30: ( COMPOSITION rest+= propertyExpression )+
        int cnt24=0;
        loop24:
        do {
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==COMPOSITION) ) {
                alt24=1;
            }


            switch (alt24) {
        	case 1 :
        	    // MOWLParser.g:157:31: COMPOSITION rest+= propertyExpression
        	    {
        	    match(input,COMPOSITION,FOLLOW_COMPOSITION_in_synpred30_MOWLParser1414); if (state.failed) return ;
        	    pushFollow(FOLLOW_propertyExpression_in_synpred30_MOWLParser1418);
        	    rest=propertyExpression();

        	    state._fsp--;
        	    if (state.failed) return ;
        	    if (list_rest==null) list_rest=new ArrayList();
        	    list_rest.add(rest);


        	    }
        	    break;

        	default :
        	    if ( cnt24 >= 1 ) break loop24;
        	    if (state.backtracking>0) {state.failed=true; return ;}
                    EarlyExitException eee =
                        new EarlyExitException(24, input);
                    throw eee;
            }
            cnt24++;
        } while (true);


        }
    }
    // $ANTLR end synpred30_MOWLParser

    // $ANTLR start synpred31_MOWLParser
    public final void synpred31_MOWLParser_fragment() throws RecognitionException {   
        // MOWLParser.g:158:5: ( NOT OPEN_PARENTHESYS expression CLOSED_PARENTHESYS )
        // MOWLParser.g:158:5: NOT OPEN_PARENTHESYS expression CLOSED_PARENTHESYS
        {
        match(input,NOT,FOLLOW_NOT_in_synpred31_MOWLParser1440); if (state.failed) return ;
        match(input,OPEN_PARENTHESYS,FOLLOW_OPEN_PARENTHESYS_in_synpred31_MOWLParser1442); if (state.failed) return ;
        pushFollow(FOLLOW_expression_in_synpred31_MOWLParser1444);
        expression();

        state._fsp--;
        if (state.failed) return ;
        match(input,CLOSED_PARENTHESYS,FOLLOW_CLOSED_PARENTHESYS_in_synpred31_MOWLParser1446); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred31_MOWLParser

    // $ANTLR start synpred32_MOWLParser
    public final void synpred32_MOWLParser_fragment() throws RecognitionException {   
        // MOWLParser.g:159:5: ( NOT atomic )
        // MOWLParser.g:159:5: NOT atomic
        {
        match(input,NOT,FOLLOW_NOT_in_synpred32_MOWLParser1460); if (state.failed) return ;
        pushFollow(FOLLOW_atomic_in_synpred32_MOWLParser1462);
        gOPPLParser.atomic();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred32_MOWLParser

    // $ANTLR start synpred33_MOWLParser
    public final void synpred33_MOWLParser_fragment() throws RecognitionException {   
        // MOWLParser.g:160:5: ( qualifiedRestriction )
        // MOWLParser.g:160:5: qualifiedRestriction
        {
        pushFollow(FOLLOW_qualifiedRestriction_in_synpred33_MOWLParser1485);
        qualifiedRestriction();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred33_MOWLParser

    // $ANTLR start synpred34_MOWLParser
    public final void synpred34_MOWLParser_fragment() throws RecognitionException {   
        // MOWLParser.g:161:5: ( dataRange )
        // MOWLParser.g:161:5: dataRange
        {
        pushFollow(FOLLOW_dataRange_in_synpred34_MOWLParser1497);
        dataRange();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred34_MOWLParser

    // $ANTLR start synpred41_MOWLParser
    public final void synpred41_MOWLParser_fragment() throws RecognitionException {   
        // MOWLParser.g:188:7: ( propertyExpression SOME expression )
        // MOWLParser.g:188:7: propertyExpression SOME expression
        {
        pushFollow(FOLLOW_propertyExpression_in_synpred41_MOWLParser1696);
        propertyExpression();

        state._fsp--;
        if (state.failed) return ;
        match(input,SOME,FOLLOW_SOME_in_synpred41_MOWLParser1699); if (state.failed) return ;
        pushFollow(FOLLOW_expression_in_synpred41_MOWLParser1703);
        expression();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred41_MOWLParser

    // $ANTLR start synpred42_MOWLParser
    public final void synpred42_MOWLParser_fragment() throws RecognitionException {   
        // MOWLParser.g:189:7: ( propertyExpression ONLY expression )
        // MOWLParser.g:189:7: propertyExpression ONLY expression
        {
        pushFollow(FOLLOW_propertyExpression_in_synpred42_MOWLParser1732);
        propertyExpression();

        state._fsp--;
        if (state.failed) return ;
        match(input,ONLY,FOLLOW_ONLY_in_synpred42_MOWLParser1734); if (state.failed) return ;
        pushFollow(FOLLOW_expression_in_synpred42_MOWLParser1737);
        expression();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred42_MOWLParser

    // $ANTLR start synpred43_MOWLParser
    public final void synpred43_MOWLParser_fragment() throws RecognitionException {   
        // MOWLParser.g:190:7: ( cardinalityRestriction )
        // MOWLParser.g:190:7: cardinalityRestriction
        {
        pushFollow(FOLLOW_cardinalityRestriction_in_synpred43_MOWLParser1756);
        cardinalityRestriction();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    
    Logger logger=Logging.getParseLogging();

    // $ANTLR end synpred43_MOWLParser

    // Delegated rules

    public final boolean synpred3_MOWLParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred3_MOWLParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            logger.info("impossible: " , re);
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
            logger.info("impossible: " , re);
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
            logger.info("impossible: " , re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred27_MOWLParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred27_MOWLParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            logger.info("impossible: " , re);
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
            logger.info("impossible: " , re);
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
            logger.info("impossible: " , re);
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
            logger.info("impossible: " , re);
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
            logger.info("impossible: " , re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred31_MOWLParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred31_MOWLParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            logger.info("impossible: " , re);
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
            logger.info("impossible: " , re);
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
            logger.info("impossible: " , re);
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
            logger.info("impossible: " , re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred42_MOWLParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred42_MOWLParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            logger.info("impossible: " , re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred33_MOWLParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred33_MOWLParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            logger.info("impossible: " , re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred41_MOWLParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred41_MOWLParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            logger.info("impossible: " , re);
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
            logger.info("impossible: " , re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred32_MOWLParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred32_MOWLParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            logger.info("impossible: " , re);
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
            logger.info("impossible: " , re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred34_MOWLParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred34_MOWLParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            logger.info("impossible: " , re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred28_MOWLParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred28_MOWLParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            logger.info("impossible: " , re);
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
            logger.info("impossible: " , re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred30_MOWLParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred30_MOWLParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            logger.info("impossible: " , re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred43_MOWLParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred43_MOWLParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            logger.info("impossible: " , re);
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
            logger.info("impossible: " , re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


    protected DFA2 dfa2 = new DFA2(this);
    protected DFA5 dfa5 = new DFA5(this);
    protected DFA6 dfa6 = new DFA6(this);
    protected DFA8 dfa8 = new DFA8(this);
    protected DFA12 dfa12 = new DFA12(this);
    protected DFA16 dfa16 = new DFA16(this);
    static final String DFA2_eotS =
        "\26\uffff";
    static final String DFA2_eofS =
        "\11\uffff\1\13\14\uffff";
    static final String DFA2_minS =
        "\1\156\1\54\1\116\3\50\1\54\1\u0237\1\uffff\1\45\2\uffff\1\u0162"+
        "\1\50\1\54\1\u0162\1\5\2\50\1\52\1\10\1\50";
    static final String DFA2_maxS =
        "\2\u01d0\1\116\3\u01d0\1\54\1\u0237\1\uffff\1\u019f\2\uffff\1\u0164"+
        "\2\u01d0\1\u0237\1\5\2\u01d0\1\52\1\10\1\u01d0";
    static final String DFA2_acceptS =
        "\10\uffff\1\3\1\uffff\1\1\1\2\12\uffff";
    static final String DFA2_specialS =
        "\26\uffff}>";
    static final String[] DFA2_transitionS = {
            "\1\1\u0161\uffff\1\2",
            "\1\3\1\4\147\uffff\1\6\u013a\uffff\1\5",
            "\1\7",
            "\1\12\3\uffff\2\13\100\uffff\1\10\46\uffff\1\13\u013a\uffff"+
            "\1\11",
            "\1\12\3\uffff\2\13\100\uffff\1\10\46\uffff\1\13\u013a\uffff"+
            "\1\11",
            "\1\12\3\uffff\2\13\40\uffff\1\14\37\uffff\1\10\46\uffff\1\13"+
            "\u013a\uffff\1\11",
            "\1\15",
            "\1\16",
            "",
            "\1\13\41\uffff\1\13\6\uffff\1\17\4\uffff\2\13\u014a\uffff\1"+
            "\13",
            "",
            "",
            "\1\21\1\22\1\20",
            "\1\12\3\uffff\2\13\100\uffff\1\10\46\uffff\1\13\u013a\uffff"+
            "\1\11",
            "\1\3\1\4\147\uffff\1\6\u013a\uffff\1\5",
            "\3\13\u00d2\uffff\1\10",
            "\1\23",
            "\1\12\3\uffff\2\13\100\uffff\1\10\46\uffff\1\13\u013a\uffff"+
            "\1\11",
            "\1\12\3\uffff\2\13\100\uffff\1\10\46\uffff\1\13\u013a\uffff"+
            "\1\11",
            "\1\24",
            "\1\25",
            "\1\12\3\uffff\2\13\100\uffff\1\10\46\uffff\1\13\u013a\uffff"+
            "\1\11"
    };

    static final short[] DFA2_eot = DFA.unpackEncodedString(DFA2_eotS);
    static final short[] DFA2_eof = DFA.unpackEncodedString(DFA2_eofS);
    static final char[] DFA2_min = DFA.unpackEncodedStringToUnsignedChars(DFA2_minS);
    static final char[] DFA2_max = DFA.unpackEncodedStringToUnsignedChars(DFA2_maxS);
    static final short[] DFA2_accept = DFA.unpackEncodedString(DFA2_acceptS);
    static final short[] DFA2_special = DFA.unpackEncodedString(DFA2_specialS);
    static final short[][] DFA2_transition;

    static {
        int numStates = DFA2_transitionS.length;
        DFA2_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA2_transition[i] = DFA.unpackEncodedString(DFA2_transitionS[i]);
        }
    }

    class DFA2 extends DFA {

        public DFA2(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 2;
            this.eot = DFA2_eot;
            this.eof = DFA2_eof;
            this.min = DFA2_min;
            this.max = DFA2_max;
            this.accept = DFA2_accept;
            this.special = DFA2_special;
            this.transition = DFA2_transition;
        }
        public String getDescription() {
            return "72:1: annotationAssertionAxiom options {backtrack=true; } : ( iri p= atomic o= constant -> ^( ANNOTATION_ASSERTION iri ^( EXPRESSION $p) ^( EXPRESSION $o) ) | iri p= atomic a= atomic -> ^( ANNOTATION_ASSERTION iri ^( EXPRESSION $p) ^( EXPRESSION $a) ) | subjectIRI= iri p= atomic objectIRI= iri -> ^( ANNOTATION_ASSERTION $subjectIRI ^( EXPRESSION $p) ^( EXPRESSION $objectIRI) ) );";
        }
    }
    static final String DFA5_eotS =
        "\20\uffff";
    static final String DFA5_eofS =
        "\20\uffff";
    static final String DFA5_minS =
        "\1\14\3\23\1\54\3\uffff\1\u0162\1\23\1\5\2\23\1\52\1\10\1\23";
    static final String DFA5_maxS =
        "\4\u01d0\1\54\3\uffff\1\u0164\1\u01d0\1\5\2\u01d0\1\52\1\10\1\u01d0";
    static final String DFA5_acceptS =
        "\5\uffff\1\3\1\1\1\2\10\uffff";
    static final String DFA5_specialS =
        "\20\uffff}>";
    static final String[] DFA5_transitionS = {
            "\1\5\37\uffff\1\1\1\2\147\uffff\1\4\u013a\uffff\1\3",
            "\1\7\22\uffff\2\6\4\uffff\2\7\147\uffff\1\7\u013a\uffff\1\7",
            "\1\7\22\uffff\2\6\4\uffff\2\7\147\uffff\1\7\u013a\uffff\1\7",
            "\1\7\22\uffff\2\6\4\uffff\2\7\40\uffff\1\10\106\uffff\1\7\u013a"+
            "\uffff\1\7",
            "\1\11",
            "",
            "",
            "",
            "\1\13\1\14\1\12",
            "\1\7\22\uffff\2\6\4\uffff\2\7\147\uffff\1\7\u013a\uffff\1\7",
            "\1\15",
            "\1\7\22\uffff\2\6\4\uffff\2\7\147\uffff\1\7\u013a\uffff\1\7",
            "\1\7\22\uffff\2\6\4\uffff\2\7\147\uffff\1\7\u013a\uffff\1\7",
            "\1\16",
            "\1\17",
            "\1\7\22\uffff\2\6\4\uffff\2\7\147\uffff\1\7\u013a\uffff\1\7"
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
            return "92:1: assertionAxiom options {backtrack=true; } : (i= atomic ( INSTANCE_OF | TYPES ) expression -> ^( TYPE_ASSERTION ^( EXPRESSION expression ) ^( EXPRESSION $i) ) | subject= atomic propertyExpression value -> ^( ROLE_ASSERTION ^( EXPRESSION $subject) ^( EXPRESSION propertyExpression ) ^( EXPRESSION value ) ) | NOT assertionAxiom -> ^( NEGATED_ASSERTION assertionAxiom ) );";
        }
    }
    static final String DFA6_eotS =
        "\23\uffff";
    static final String DFA6_eofS =
        "\23\uffff";
    static final String DFA6_minS =
        "\1\5\11\0\11\uffff";
    static final String DFA6_maxS =
        "\1\u01d0\11\0\11\uffff";
    static final String DFA6_acceptS =
        "\12\uffff\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11";
    static final String DFA6_specialS =
        "\1\uffff\1\0\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\11\uffff}>";
    static final String[] DFA6_transitionS = {
            "\1\11\1\7\5\uffff\1\6\6\uffff\1\5\24\uffff\1\10\3\uffff\1\1"+
            "\1\2\147\uffff\1\4\u013a\uffff\1\3",
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
            return "101:1: binaryAxiom options {backtrack=true; } : (lhs= expression SUBCLASS_OF superClass= expression -> ^( SUB_CLASS_AXIOM ^( EXPRESSION $lhs) ^( EXPRESSION $superClass) ) | lhs= expression EQUIVALENT_TO rhs= expression -> ^( EQUIVALENT_TO_AXIOM ^( EXPRESSION $lhs) ^( EXPRESSION $rhs) ) | lhs= expression DISJOINT_WITH disjoint= expression -> ^( DISJOINT_WITH_AXIOM ^( EXPRESSION $lhs) ^( EXPRESSION $disjoint) ) | lhs= expression SUB_PROPERTY_OF superProperty= propertyExpression -> ^( SUB_PROPERTY_AXIOM ^( EXPRESSION $lhs) ^( EXPRESSION $superProperty) ) | lhsID= atomic INVERSE_OF rhsAtomic= atomic -> ^( INVERSE_OF ^( EXPRESSION $lhsID) ^( EXPRESSION $rhsAtomic) ) | lhsID= atomic SAME_AS rhsID= atomic -> ^( SAME_AS_AXIOM ^( EXPRESSION $lhsID) ^( EXPRESSION $rhsID) ) | lhsID= atomic DIFFERENT_FROM rhsID= atomic -> ^( DIFFERENT_FROM_AXIOM ^( EXPRESSION $lhsID) ^( EXPRESSION $rhsID) ) | lhsID= atomic DOMAIN expression -> ^( DOMAIN ^( EXPRESSION $lhsID) ^( EXPRESSION expression ) ) | lhsID= atomic RANGE expression -> ^( RANGE ^( EXPRESSION $lhsID) ^( EXPRESSION expression ) ) );";
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
                        if ( (synpred11_MOWLParser()) ) {s = 10;}

                        else if ( (synpred12_MOWLParser()) ) {s = 11;}

                        else if ( (synpred13_MOWLParser()) ) {s = 12;}

                        else if ( (synpred14_MOWLParser()) ) {s = 13;}

                        else if ( (synpred15_MOWLParser()) ) {s = 14;}

                        else if ( (synpred16_MOWLParser()) ) {s = 15;}

                        else if ( (synpred17_MOWLParser()) ) {s = 16;}

                        else if ( (synpred18_MOWLParser()) ) {s = 17;}

                        else if ( (true) ) {s = 18;}

                         
                        input.seek(index6_1);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA6_2 = input.LA(1);

                         
                        int index6_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred11_MOWLParser()) ) {s = 10;}

                        else if ( (synpred12_MOWLParser()) ) {s = 11;}

                        else if ( (synpred13_MOWLParser()) ) {s = 12;}

                        else if ( (synpred14_MOWLParser()) ) {s = 13;}

                        else if ( (synpred15_MOWLParser()) ) {s = 14;}

                        else if ( (synpred16_MOWLParser()) ) {s = 15;}

                        else if ( (synpred17_MOWLParser()) ) {s = 16;}

                        else if ( (synpred18_MOWLParser()) ) {s = 17;}

                        else if ( (true) ) {s = 18;}

                         
                        input.seek(index6_2);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA6_3 = input.LA(1);

                         
                        int index6_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred11_MOWLParser()) ) {s = 10;}

                        else if ( (synpred12_MOWLParser()) ) {s = 11;}

                        else if ( (synpred13_MOWLParser()) ) {s = 12;}

                        else if ( (synpred14_MOWLParser()) ) {s = 13;}

                        else if ( (synpred15_MOWLParser()) ) {s = 14;}

                        else if ( (synpred16_MOWLParser()) ) {s = 15;}

                        else if ( (synpred17_MOWLParser()) ) {s = 16;}

                        else if ( (synpred18_MOWLParser()) ) {s = 17;}

                        else if ( (true) ) {s = 18;}

                         
                        input.seek(index6_3);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA6_4 = input.LA(1);

                         
                        int index6_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred11_MOWLParser()) ) {s = 10;}

                        else if ( (synpred12_MOWLParser()) ) {s = 11;}

                        else if ( (synpred13_MOWLParser()) ) {s = 12;}

                        else if ( (synpred14_MOWLParser()) ) {s = 13;}

                        else if ( (synpred15_MOWLParser()) ) {s = 14;}

                        else if ( (synpred16_MOWLParser()) ) {s = 15;}

                        else if ( (synpred17_MOWLParser()) ) {s = 16;}

                        else if ( (synpred18_MOWLParser()) ) {s = 17;}

                        else if ( (true) ) {s = 18;}

                         
                        input.seek(index6_4);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA6_5 = input.LA(1);

                         
                        int index6_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred11_MOWLParser()) ) {s = 10;}

                        else if ( (synpred12_MOWLParser()) ) {s = 11;}

                        else if ( (synpred13_MOWLParser()) ) {s = 12;}

                        else if ( (synpred14_MOWLParser()) ) {s = 13;}

                         
                        input.seek(index6_5);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA6_6 = input.LA(1);

                         
                        int index6_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred11_MOWLParser()) ) {s = 10;}

                        else if ( (synpred12_MOWLParser()) ) {s = 11;}

                        else if ( (synpred13_MOWLParser()) ) {s = 12;}

                        else if ( (synpred14_MOWLParser()) ) {s = 13;}

                         
                        input.seek(index6_6);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA6_7 = input.LA(1);

                         
                        int index6_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred11_MOWLParser()) ) {s = 10;}

                        else if ( (synpred12_MOWLParser()) ) {s = 11;}

                        else if ( (synpred13_MOWLParser()) ) {s = 12;}

                        else if ( (synpred14_MOWLParser()) ) {s = 13;}

                         
                        input.seek(index6_7);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA6_8 = input.LA(1);

                         
                        int index6_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred11_MOWLParser()) ) {s = 10;}

                        else if ( (synpred12_MOWLParser()) ) {s = 11;}

                        else if ( (synpred13_MOWLParser()) ) {s = 12;}

                        else if ( (synpred14_MOWLParser()) ) {s = 13;}

                         
                        input.seek(index6_8);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA6_9 = input.LA(1);

                         
                        int index6_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred11_MOWLParser()) ) {s = 10;}

                        else if ( (synpred12_MOWLParser()) ) {s = 11;}

                        else if ( (synpred13_MOWLParser()) ) {s = 12;}

                        else if ( (synpred14_MOWLParser()) ) {s = 13;}

                         
                        input.seek(index6_9);
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
    static final String DFA8_eotS =
        "\13\uffff";
    static final String DFA8_eofS =
        "\13\uffff";
    static final String DFA8_minS =
        "\1\5\4\uffff\1\0\5\uffff";
    static final String DFA8_maxS =
        "\1\u01d0\4\uffff\1\0\5\uffff";
    static final String DFA8_acceptS =
        "\1\uffff\1\1\7\uffff\1\3\1\2";
    static final String DFA8_specialS =
        "\5\uffff\1\0\5\uffff}>";
    static final String[] DFA8_transitionS = {
            "\1\11\1\1\5\uffff\1\1\6\uffff\1\5\24\uffff\1\1\3\uffff\2\1\147"+
            "\uffff\1\1\u013a\uffff\1\1",
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

    static final short[] DFA8_eot = DFA.unpackEncodedString(DFA8_eotS);
    static final short[] DFA8_eof = DFA.unpackEncodedString(DFA8_eofS);
    static final char[] DFA8_min = DFA.unpackEncodedStringToUnsignedChars(DFA8_minS);
    static final char[] DFA8_max = DFA.unpackEncodedStringToUnsignedChars(DFA8_maxS);
    static final short[] DFA8_accept = DFA.unpackEncodedString(DFA8_acceptS);
    static final short[] DFA8_special = DFA.unpackEncodedString(DFA8_specialS);
    static final short[][] DFA8_transition;

    static {
        int numStates = DFA8_transitionS.length;
        DFA8_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA8_transition[i] = DFA.unpackEncodedString(DFA8_transitionS[i]);
        }
    }

    class DFA8 extends DFA {

        public DFA8(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 8;
            this.eot = DFA8_eot;
            this.eof = DFA8_eof;
            this.min = DFA8_min;
            this.max = DFA8_max;
            this.accept = DFA8_accept;
            this.special = DFA8_special;
            this.transition = DFA8_transition;
        }
        public String getDescription() {
            return "130:5: ( options {backtrack=true; } : disjunction -> ^( disjunction ) | complexPropertyExpression -> ^( complexPropertyExpression ) | OPEN_PARENTHESYS expression CLOSED_PARENTHESYS -> ^( expression ) )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA8_5 = input.LA(1);

                         
                        int index8_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred25_MOWLParser()) ) {s = 1;}

                        else if ( (synpred26_MOWLParser()) ) {s = 10;}

                         
                        input.seek(index8_5);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 8, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA12_eotS =
        "\16\uffff";
    static final String DFA12_eofS =
        "\16\uffff";
    static final String DFA12_minS =
        "\1\6\6\0\7\uffff";
    static final String DFA12_maxS =
        "\1\u01d0\6\0\7\uffff";
    static final String DFA12_acceptS =
        "\7\uffff\1\4\1\6\1\1\1\5\1\7\1\2\1\3";
    static final String DFA12_specialS =
        "\1\uffff\1\0\1\1\1\2\1\3\1\4\1\5\7\uffff}>";
    static final String[] DFA12_transitionS = {
            "\1\7\5\uffff\1\6\6\uffff\1\5\24\uffff\1\10\3\uffff\1\1\1\2\147"+
            "\uffff\1\4\u013a\uffff\1\3",
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
        for (int i=0; i<numStates; i++) {
            DFA12_transition[i] = DFA.unpackEncodedString(DFA12_transitionS[i]);
        }
    }

    class DFA12 extends DFA {

        public DFA12(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 12;
            this.eot = DFA12_eot;
            this.eof = DFA12_eof;
            this.min = DFA12_min;
            this.max = DFA12_max;
            this.accept = DFA12_accept;
            this.special = DFA12_special;
            this.transition = DFA12_transition;
        }
        public String getDescription() {
            return "155:1: unary options {backtrack=true; } : (head= propertyExpression ( COMPOSITION rest+= propertyExpression )+ -> ^( PROPERTY_CHAIN $head $rest) | NOT OPEN_PARENTHESYS expression CLOSED_PARENTHESYS -> ^( NEGATED_EXPRESSION expression ) | NOT atomic -> ^( NEGATED_EXPRESSION atomic ) | qualifiedRestriction -> ^( qualifiedRestriction ) | dataRange | constant | atomic );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA12_1 = input.LA(1);

                         
                        int index12_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred30_MOWLParser()) ) {s = 9;}

                        else if ( (synpred33_MOWLParser()) ) {s = 7;}

                        else if ( (synpred34_MOWLParser()) ) {s = 10;}

                        else if ( (true) ) {s = 11;}

                         
                        input.seek(index12_1);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA12_2 = input.LA(1);

                         
                        int index12_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred30_MOWLParser()) ) {s = 9;}

                        else if ( (synpred33_MOWLParser()) ) {s = 7;}

                        else if ( (true) ) {s = 11;}

                         
                        input.seek(index12_2);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA12_3 = input.LA(1);

                         
                        int index12_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred30_MOWLParser()) ) {s = 9;}

                        else if ( (synpred33_MOWLParser()) ) {s = 7;}

                        else if ( (true) ) {s = 11;}

                         
                        input.seek(index12_3);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA12_4 = input.LA(1);

                         
                        int index12_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred30_MOWLParser()) ) {s = 9;}

                        else if ( (synpred33_MOWLParser()) ) {s = 7;}

                        else if ( (true) ) {s = 11;}

                         
                        input.seek(index12_4);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA12_5 = input.LA(1);

                         
                        int index12_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred30_MOWLParser()) ) {s = 9;}

                        else if ( (synpred33_MOWLParser()) ) {s = 7;}

                         
                        input.seek(index12_5);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA12_6 = input.LA(1);

                         
                        int index12_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred31_MOWLParser()) ) {s = 12;}

                        else if ( (synpred32_MOWLParser()) ) {s = 13;}

                         
                        input.seek(index12_6);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 12, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA16_eotS =
        "\13\uffff";
    static final String DFA16_eofS =
        "\13\uffff";
    static final String DFA16_minS =
        "\1\6\5\0\5\uffff";
    static final String DFA16_maxS =
        "\1\u01d0\5\0\5\uffff";
    static final String DFA16_acceptS =
        "\6\uffff\1\4\1\1\1\2\1\3\1\5";
    static final String DFA16_specialS =
        "\1\uffff\1\0\1\1\1\2\1\3\1\4\5\uffff}>";
    static final String[] DFA16_transitionS = {
            "\1\6\14\uffff\1\5\30\uffff\1\1\1\2\147\uffff\1\4\u013a\uffff"+
            "\1\3",
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

    static final short[] DFA16_eot = DFA.unpackEncodedString(DFA16_eotS);
    static final short[] DFA16_eof = DFA.unpackEncodedString(DFA16_eofS);
    static final char[] DFA16_min = DFA.unpackEncodedStringToUnsignedChars(DFA16_minS);
    static final char[] DFA16_max = DFA.unpackEncodedStringToUnsignedChars(DFA16_maxS);
    static final short[] DFA16_accept = DFA.unpackEncodedString(DFA16_acceptS);
    static final short[] DFA16_special = DFA.unpackEncodedString(DFA16_specialS);
    static final short[][] DFA16_transition;

    static {
        int numStates = DFA16_transitionS.length;
        DFA16_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA16_transition[i] = DFA.unpackEncodedString(DFA16_transitionS[i]);
        }
    }

    class DFA16 extends DFA {

        public DFA16(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 16;
            this.eot = DFA16_eot;
            this.eof = DFA16_eof;
            this.min = DFA16_min;
            this.max = DFA16_max;
            this.accept = DFA16_accept;
            this.special = DFA16_special;
            this.transition = DFA16_transition;
        }
        public String getDescription() {
            return "186:9: ( options {backtrack=true; } : propertyExpression SOME expression -> ^( SOME_RESTRICTION propertyExpression expression ) | propertyExpression ONLY expression -> ^( ALL_RESTRICTION propertyExpression expression ) | cardinalityRestriction -> ^( cardinalityRestriction ) | oneOf -> ^( oneOf ) | valueRestriction -> ^( valueRestriction ) )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA16_1 = input.LA(1);

                         
                        int index16_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred41_MOWLParser()) ) {s = 7;}

                        else if ( (synpred42_MOWLParser()) ) {s = 8;}

                        else if ( (synpred43_MOWLParser()) ) {s = 9;}

                        else if ( (true) ) {s = 10;}

                         
                        input.seek(index16_1);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA16_2 = input.LA(1);

                         
                        int index16_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred41_MOWLParser()) ) {s = 7;}

                        else if ( (synpred42_MOWLParser()) ) {s = 8;}

                        else if ( (synpred43_MOWLParser()) ) {s = 9;}

                        else if ( (true) ) {s = 10;}

                         
                        input.seek(index16_2);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA16_3 = input.LA(1);

                         
                        int index16_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred41_MOWLParser()) ) {s = 7;}

                        else if ( (synpred42_MOWLParser()) ) {s = 8;}

                        else if ( (synpred43_MOWLParser()) ) {s = 9;}

                        else if ( (true) ) {s = 10;}

                         
                        input.seek(index16_3);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA16_4 = input.LA(1);

                         
                        int index16_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred41_MOWLParser()) ) {s = 7;}

                        else if ( (synpred42_MOWLParser()) ) {s = 8;}

                        else if ( (synpred43_MOWLParser()) ) {s = 9;}

                        else if ( (true) ) {s = 10;}

                         
                        input.seek(index16_4);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA16_5 = input.LA(1);

                         
                        int index16_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred41_MOWLParser()) ) {s = 7;}

                        else if ( (synpred42_MOWLParser()) ) {s = 8;}

                        else if ( (synpred43_MOWLParser()) ) {s = 9;}

                        else if ( (true) ) {s = 10;}

                         
                        input.seek(index16_5);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 16, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

    public static final BitSet FOLLOW_iri_in_annotationAssertionAxiom311 = new BitSet(new long[]{0x0000300000000000L,0x0000000000000000L,0x0000000000200000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_atomic_in_annotationAssertionAxiom316 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_constant_in_annotationAssertionAxiom322 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_iri_in_annotationAssertionAxiom350 = new BitSet(new long[]{0x0000300000000000L,0x0000000000000000L,0x0000000000200000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_atomic_in_annotationAssertionAxiom355 = new BitSet(new long[]{0x0000300000000000L,0x0000000000000000L,0x0000000000200000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_atomic_in_annotationAssertionAxiom361 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_iri_in_annotationAssertionAxiom393 = new BitSet(new long[]{0x0000300000000000L,0x0000000000000000L,0x0000000000200000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_atomic_in_annotationAssertionAxiom398 = new BitSet(new long[]{0x0000000000000000L,0x0000400000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_iri_in_annotationAssertionAxiom404 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_disjunction_in_hasKeyAxiom462 = new BitSet(new long[]{0x0000000000000000L,0x0000200000000000L});
    public static final BitSet FOLLOW_HAS_KEY_in_hasKeyAxiom464 = new BitSet(new long[]{0x0000300000080000L,0x0000000000000000L,0x0000000000200000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_propertyExpression_in_hasKeyAxiom466 = new BitSet(new long[]{0x0000002000000002L});
    public static final BitSet FOLLOW_COMMA_in_hasKeyAxiom469 = new BitSet(new long[]{0x0000300000080000L,0x0000000000000000L,0x0000000000200000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_propertyExpression_in_hasKeyAxiom471 = new BitSet(new long[]{0x0000002000000002L});
    public static final BitSet FOLLOW_atomic_in_assertionAxiom520 = new BitSet(new long[]{0x000000C000000000L});
    public static final BitSet FOLLOW_INSTANCE_OF_in_assertionAxiom523 = new BitSet(new long[]{0x0000310000081060L,0x0000000000000000L,0x0000000000200000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_TYPES_in_assertionAxiom527 = new BitSet(new long[]{0x0000310000081060L,0x0000000000000000L,0x0000000000200000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_expression_in_assertionAxiom530 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_atomic_in_assertionAxiom561 = new BitSet(new long[]{0x0000300000080000L,0x0000000000000000L,0x0000000000200000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_propertyExpression_in_assertionAxiom563 = new BitSet(new long[]{0x0000310000000000L,0x0000000000000000L,0x0000000000200000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_value_in_assertionAxiom566 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NOT_in_assertionAxiom600 = new BitSet(new long[]{0x0000300000001000L,0x0000000000000000L,0x0000000000200000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_assertionAxiom_in_assertionAxiom602 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_in_binaryAxiom639 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_SUBCLASS_OF_in_binaryAxiom641 = new BitSet(new long[]{0x0000310000081060L,0x0000000000000000L,0x0000000000200000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_expression_in_binaryAxiom648 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_in_binaryAxiom686 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_EQUIVALENT_TO_in_binaryAxiom688 = new BitSet(new long[]{0x0000310000081060L,0x0000000000000000L,0x0000000000200000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_expression_in_binaryAxiom694 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_in_binaryAxiom731 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_DISJOINT_WITH_in_binaryAxiom733 = new BitSet(new long[]{0x0000310000081060L,0x0000000000000000L,0x0000000000200000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_expression_in_binaryAxiom739 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_in_binaryAxiom776 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_SUB_PROPERTY_OF_in_binaryAxiom778 = new BitSet(new long[]{0x0000300000080000L,0x0000000000000000L,0x0000000000200000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_propertyExpression_in_binaryAxiom784 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_atomic_in_binaryAxiom821 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_INVERSE_OF_in_binaryAxiom823 = new BitSet(new long[]{0x0000300000000000L,0x0000000000000000L,0x0000000000200000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_atomic_in_binaryAxiom829 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_atomic_in_binaryAxiom860 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_SAME_AS_in_binaryAxiom862 = new BitSet(new long[]{0x0000300000000000L,0x0000000000000000L,0x0000000000200000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_atomic_in_binaryAxiom869 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_atomic_in_binaryAxiom907 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_DIFFERENT_FROM_in_binaryAxiom909 = new BitSet(new long[]{0x0000300000000000L,0x0000000000000000L,0x0000000000200000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_atomic_in_binaryAxiom916 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_atomic_in_binaryAxiom953 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_DOMAIN_in_binaryAxiom956 = new BitSet(new long[]{0x0000310000081060L,0x0000000000000000L,0x0000000000200000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_expression_in_binaryAxiom958 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_atomic_in_binaryAxiom994 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_RANGE_in_binaryAxiom996 = new BitSet(new long[]{0x0000310000081060L,0x0000000000000000L,0x0000000000200000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_expression_in_binaryAxiom998 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_unaryCharacteristic_in_unaryAxiom1072 = new BitSet(new long[]{0x0000310000081040L,0x0000000000000000L,0x0000000000200000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_unary_in_unaryAxiom1076 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FUNCTIONAL_in_unaryCharacteristic1121 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INVERSE_FUNCTIONAL_in_unaryCharacteristic1135 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SYMMETRIC_in_unaryCharacteristic1149 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ANTI_SYMMETRIC_in_unaryCharacteristic1163 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_REFLEXIVE_in_unaryCharacteristic1177 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IRREFLEXIVE_in_unaryCharacteristic1191 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TRANSITIVE_in_unaryCharacteristic1205 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_disjunction_in_expression1247 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_complexPropertyExpression_in_expression1260 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OPEN_PARENTHESYS_in_expression1273 = new BitSet(new long[]{0x0000310000081060L,0x0000000000000000L,0x0000000000200000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_expression_in_expression1275 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_CLOSED_PARENTHESYS_in_expression1277 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_conjunction_in_disjunction1307 = new BitSet(new long[]{0x0000000000000802L});
    public static final BitSet FOLLOW_OR_in_disjunction1310 = new BitSet(new long[]{0x0000310000081040L,0x0000000000000000L,0x0000000000200000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_conjunction_in_disjunction1312 = new BitSet(new long[]{0x0000000000000802L});
    public static final BitSet FOLLOW_unary_in_conjunction1339 = new BitSet(new long[]{0x0000000000000402L});
    public static final BitSet FOLLOW_AND_in_conjunction1342 = new BitSet(new long[]{0x0000310000081040L,0x0000000000000000L,0x0000000000200000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_unary_in_conjunction1344 = new BitSet(new long[]{0x0000000000000402L});
    public static final BitSet FOLLOW_INVERSE_in_complexPropertyExpression1365 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_OPEN_PARENTHESYS_in_complexPropertyExpression1367 = new BitSet(new long[]{0x0000300000080000L,0x0000000000000000L,0x0000000000200000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_propertyExpression_in_complexPropertyExpression1369 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_CLOSED_PARENTHESYS_in_complexPropertyExpression1371 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_propertyExpression_in_unary1411 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_COMPOSITION_in_unary1414 = new BitSet(new long[]{0x0000300000080000L,0x0000000000000000L,0x0000000000200000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_propertyExpression_in_unary1418 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_NOT_in_unary1440 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_OPEN_PARENTHESYS_in_unary1442 = new BitSet(new long[]{0x0000310000081060L,0x0000000000000000L,0x0000000000200000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_expression_in_unary1444 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_CLOSED_PARENTHESYS_in_unary1446 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NOT_in_unary1460 = new BitSet(new long[]{0x0000300000000000L,0x0000000000000000L,0x0000000000200000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_atomic_in_unary1462 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_qualifiedRestriction_in_unary1485 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_dataRange_in_unary1497 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_constant_in_unary1503 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_atomic_in_unary1509 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_dataRange1526 = new BitSet(new long[]{0x0000000000000000L,0x0000000000200000L});
    public static final BitSet FOLLOW_OPEN_SQUARE_BRACKET_in_dataRange1528 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000007800000000L});
    public static final BitSet FOLLOW_dataRangeFacet_in_dataRange1530 = new BitSet(new long[]{0x0000002000000000L,0x0000000000400000L});
    public static final BitSet FOLLOW_COMMA_in_dataRange1533 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000007800000000L});
    public static final BitSet FOLLOW_dataRangeFacet_in_dataRange1535 = new BitSet(new long[]{0x0000002000000000L,0x0000000000400000L});
    public static final BitSet FOLLOW_CLOSED_SQUARE_BRACKET_in_dataRange1539 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LESS_THAN_in_dataRangeFacet1565 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_constant_in_dataRangeFacet1567 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LESS_THAN_EQUAL_in_dataRangeFacet1581 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_constant_in_dataRangeFacet1583 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_GREATER_THAN_in_dataRangeFacet1598 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_constant_in_dataRangeFacet1600 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_GREATER_THAN_EQUAL_in_dataRangeFacet1614 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_constant_in_dataRangeFacet1616 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_propertyExpression_in_qualifiedRestriction1696 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_SOME_in_qualifiedRestriction1699 = new BitSet(new long[]{0x0000310000081060L,0x0000000000000000L,0x0000000000200000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_expression_in_qualifiedRestriction1703 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_propertyExpression_in_qualifiedRestriction1732 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_ONLY_in_qualifiedRestriction1734 = new BitSet(new long[]{0x0000310000081060L,0x0000000000000000L,0x0000000000200000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_expression_in_qualifiedRestriction1737 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_cardinalityRestriction_in_qualifiedRestriction1756 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_oneOf_in_qualifiedRestriction1770 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_valueRestriction_in_qualifiedRestriction1784 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_atomic_in_propertyExpression1816 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_complexPropertyExpression_in_propertyExpression1830 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_propertyExpression_in_cardinalityRestriction1872 = new BitSet(new long[]{0x0000000000038000L});
    public static final BitSet FOLLOW_restrictionKind_in_cardinalityRestriction1875 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_INTEGER_in_cardinalityRestriction1877 = new BitSet(new long[]{0x0000310000081042L,0x0000000000000000L,0x0000000000200000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_unary_in_cardinalityRestriction1879 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MIN_in_restrictionKind1912 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MAX_in_restrictionKind1926 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_EXACTLY_in_restrictionKind1940 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OPEN_CURLY_BRACES_in_oneOf1962 = new BitSet(new long[]{0x0000300000000000L,0x0000000000000000L,0x0000000000200000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_atomic_in_oneOf1964 = new BitSet(new long[]{0x0000002000000080L});
    public static final BitSet FOLLOW_COMMA_in_oneOf1967 = new BitSet(new long[]{0x0000300000000000L,0x0000000000000000L,0x0000000000200000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_atomic_in_oneOf1969 = new BitSet(new long[]{0x0000002000000080L});
    public static final BitSet FOLLOW_CLOSED_CURLY_BRACES_in_oneOf1973 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_propertyExpression_in_valueRestriction1993 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_VALUE_in_valueRestriction1995 = new BitSet(new long[]{0x0000310000000000L,0x0000000000000000L,0x0000000000200000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_value_in_valueRestriction1997 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_atomic_in_value2022 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_constant_in_value2037 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DBLQUOTE_in_constant2062 = new BitSet(new long[]{0x0000001000000002L,0x0004000000000000L});
    public static final BitSet FOLLOW_AT_in_constant2065 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_constant2071 = new BitSet(new long[]{0x0000001000000002L});
    public static final BitSet FOLLOW_POW_in_constant2077 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_constant2083 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_binaryAxiom_in_synpred1_MOWLParser232 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_assertionAxiom_in_synpred3_MOWLParser256 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_hasKeyAxiom_in_synpred4_MOWLParser268 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_COMMA_in_synpred7_MOWLParser469 = new BitSet(new long[]{0x0000300000080000L,0x0000000000000000L,0x0000000000200000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_propertyExpression_in_synpred7_MOWLParser471 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_in_synpred11_MOWLParser639 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_SUBCLASS_OF_in_synpred11_MOWLParser641 = new BitSet(new long[]{0x0000310000081060L,0x0000000000000000L,0x0000000000200000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_expression_in_synpred11_MOWLParser648 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_in_synpred12_MOWLParser686 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_EQUIVALENT_TO_in_synpred12_MOWLParser688 = new BitSet(new long[]{0x0000310000081060L,0x0000000000000000L,0x0000000000200000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_expression_in_synpred12_MOWLParser694 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_in_synpred13_MOWLParser731 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_DISJOINT_WITH_in_synpred13_MOWLParser733 = new BitSet(new long[]{0x0000310000081060L,0x0000000000000000L,0x0000000000200000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_expression_in_synpred13_MOWLParser739 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_in_synpred14_MOWLParser776 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_SUB_PROPERTY_OF_in_synpred14_MOWLParser778 = new BitSet(new long[]{0x0000300000080000L,0x0000000000000000L,0x0000000000200000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_propertyExpression_in_synpred14_MOWLParser784 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_atomic_in_synpred15_MOWLParser821 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_INVERSE_OF_in_synpred15_MOWLParser823 = new BitSet(new long[]{0x0000300000000000L,0x0000000000000000L,0x0000000000200000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_atomic_in_synpred15_MOWLParser829 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_atomic_in_synpred16_MOWLParser860 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_SAME_AS_in_synpred16_MOWLParser862 = new BitSet(new long[]{0x0000300000000000L,0x0000000000000000L,0x0000000000200000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_atomic_in_synpred16_MOWLParser869 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_atomic_in_synpred17_MOWLParser907 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_DIFFERENT_FROM_in_synpred17_MOWLParser909 = new BitSet(new long[]{0x0000300000000000L,0x0000000000000000L,0x0000000000200000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_atomic_in_synpred17_MOWLParser916 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_atomic_in_synpred18_MOWLParser953 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_DOMAIN_in_synpred18_MOWLParser956 = new BitSet(new long[]{0x0000310000081060L,0x0000000000000000L,0x0000000000200000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_expression_in_synpred18_MOWLParser958 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_disjunction_in_synpred25_MOWLParser1247 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_complexPropertyExpression_in_synpred26_MOWLParser1260 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OR_in_synpred27_MOWLParser1310 = new BitSet(new long[]{0x0000310000081040L,0x0000000000000000L,0x0000000000200000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_conjunction_in_synpred27_MOWLParser1312 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_AND_in_synpred28_MOWLParser1342 = new BitSet(new long[]{0x0000310000081040L,0x0000000000000000L,0x0000000000200000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_unary_in_synpred28_MOWLParser1344 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_propertyExpression_in_synpred30_MOWLParser1411 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_COMPOSITION_in_synpred30_MOWLParser1414 = new BitSet(new long[]{0x0000300000080000L,0x0000000000000000L,0x0000000000200000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_propertyExpression_in_synpred30_MOWLParser1418 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_NOT_in_synpred31_MOWLParser1440 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_OPEN_PARENTHESYS_in_synpred31_MOWLParser1442 = new BitSet(new long[]{0x0000310000081060L,0x0000000000000000L,0x0000000000200000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_expression_in_synpred31_MOWLParser1444 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_CLOSED_PARENTHESYS_in_synpred31_MOWLParser1446 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NOT_in_synpred32_MOWLParser1460 = new BitSet(new long[]{0x0000300000000000L,0x0000000000000000L,0x0000000000200000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_atomic_in_synpred32_MOWLParser1462 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_qualifiedRestriction_in_synpred33_MOWLParser1485 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_dataRange_in_synpred34_MOWLParser1497 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_propertyExpression_in_synpred41_MOWLParser1696 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_SOME_in_synpred41_MOWLParser1699 = new BitSet(new long[]{0x0000310000081060L,0x0000000000000000L,0x0000000000200000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_expression_in_synpred41_MOWLParser1703 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_propertyExpression_in_synpred42_MOWLParser1732 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_ONLY_in_synpred42_MOWLParser1734 = new BitSet(new long[]{0x0000310000081060L,0x0000000000000000L,0x0000000000200000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_expression_in_synpred42_MOWLParser1737 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_cardinalityRestriction_in_synpred43_MOWLParser1756 = new BitSet(new long[]{0x0000000000000002L});

}