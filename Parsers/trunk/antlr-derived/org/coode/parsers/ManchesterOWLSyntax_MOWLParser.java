// $ANTLR 3.2 Sep 23, 2009 12:02:23 MOWLParser.g 2010-11-12 23:43:24

  package org.coode.parsers;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

import org.antlr.runtime.tree.*;

public class ManchesterOWLSyntax_MOWLParser extends Parser {
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
    public static final int CREATE_IDENTIFIER=151;
    public static final int CREATE=80;
    public static final int POW=36;
    public static final int INPUT_VARIABLE_DEFINITION=96;
    public static final int NOT_EQUAL=72;
    public static final int INVERSE_OBJECT_PROPERTY_EXPRESSION=68;
    public static final int INSTANCE_OF=38;
    public static final int BEGIN=83;
    public static final int QUESTION_MARK=46;
    public static final int INEQUALITY_CONSTRAINT=94;
    public static final int VARIABLE_SCOPE=104;
    public static final int SYMMETRIC=30;
    public static final int CARDINALITY_RESTRICTION=64;
    public static final int SELECT=75;
    public static final int ROLE_ASSERTION=67;
    public static final int DIFFERENT_FROM_AXIOM=53;
    public static final int CREATE_OPPL_FUNCTION=98;
    public static final int ANTI_SYMMETRIC=31;
    public static final int TRANSITIVE=34;
    public static final int GREATER_THAN_EQUAL=486;
    public static final int ALL_RESTRICTION=62;
    public static final int CONJUNCTION=56;
    public static final int OPPL_STATEMENT=107;
    public static final int NEGATED_ASSERTION=59;
    public static final int WHITESPACE=9;
    public static final int IN_SET_CONSTRAINT=95;
    public static final int MATCH=176;
    public static final int VALUE=18;
    public static final int OPEN_CURLY_BRACES=6;
    public static final int DISJUNCTION=55;
    public static final int INVERSE=19;
    public static final int DBLQUOTE=40;
    public static final int OR=11;
    public static final int LESS_THAN=483;
    public static final int CONSTANT=70;
    public static final int QUERY=103;
    public static final int ENTITY_REFERENCE=45;
    public static final int END=84;
    public static final int COMPOSITION=4;
    public static final int ANNOTATION_ASSERTION=111;
    public static final int CLOSED_SQUARE_BRACKET=86;
    public static final int SAME_AS=23;
    public static final int WHERE=71;
    public static final int DISJOINT_WITH=26;
    public static final int SUPER_PROPERTY_OF=88;
    public static final int VARIABLE_TYPE=89;
    public static final int ATTRIBUTE_SELECTOR=283;
    public static final int CLOSED_PARENTHESYS=8;
    public static final int ONLY=14;
    public static final int EQUIVALENT_TO_AXIOM=49;
    public static final int SUB_PROPERTY_OF=21;
    public static final int NEGATED_EXPRESSION=58;
    public static final int MAX=16;
    public static final int CREATE_DISJUNCTION=82;
    public static final int AND=10;
    public static final int ASSERTED_CLAUSE=92;
    public static final int INVERSE_PROPERTY=60;
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
    public static final int GENERATED_VARIABLE_DEFINITION=97;
    public static final int OPEN_SQUARE_BRACKET=85;
    public static final int SUB_PROPERTY_AXIOM=51;
    public static final int EXACTLY=17;
    public static final int RANGE=28;
    public static final int ONE_OF=65;
    public static final int DATA_RANGE=108;
    public static final int VARIABLE_DEFINITIONS=102;
    public static final int SUB_CLASS_AXIOM=48;
    public static final int MIN=15;
    public static final int PLAIN_CLAUSE=93;
    public static final int Tokens=47;
    public static final int DOMAIN=27;
    public static final int SUBPROPERTY_OF=105;
    public static final int COLON=77;
    public static final int OPPL_FUNCTION=100;
    public static final int DISJOINT_WITH_AXIOM=50;
    public static final int CREATE_INTERSECTION=81;
    public static final int INVERSE_FUNCTIONAL=35;
    public static final int VARIABLE_IDENTIFIER=106;
    public static final int IRREFLEXIVE=33;
    public static final int ASSERTED=76;
    public static final int VARIABLE_ATTRIBUTE=99;
    public static final int PLAIN_IDENTIFIER=152;
    public static final int LESS_THAN_EQUAL=484;
    public static final int PROPERTY_CHAIN=57;
    public static final int FUNCTIONAL=29;
    public static final int TYPE_ASSERTION=66;

    // delegates
    // delegators
    public ManchesterOWLSyntaxParser gManchesterOWLSyntax;
    public ManchesterOWLSyntaxParser gParent;


        public ManchesterOWLSyntax_MOWLParser(TokenStream input, ManchesterOWLSyntaxParser gManchesterOWLSyntax) {
            this(input, new RecognizerSharedState(), gManchesterOWLSyntax);
        }
        public ManchesterOWLSyntax_MOWLParser(TokenStream input, RecognizerSharedState state, ManchesterOWLSyntaxParser gManchesterOWLSyntax) {
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

    public String[] getTokenNames() { return ManchesterOWLSyntaxParser.tokenNames; }
    public String getGrammarFileName() { return "MOWLParser.g"; }


    public void displayRecognitionError(String[] tokenNames,
    										RecognitionException e){
    	}
    	


    public static class axiom_return extends ParserRuleReturnScope {
        ManchesterOWLSyntaxTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "axiom"
    // MOWLParser.g:65:1: axiom options {backtrack=true; } : ( binaryAxiom -> ^( binaryAxiom ) | unaryAxiom -> ^( unaryAxiom ) | assertionAxiom -> ^( assertionAxiom ) | hasKeyAxiom -> ^( hasKeyAxiom ) | annotationAssertionAxiom -> ^( annotationAssertionAxiom ) );
    public final ManchesterOWLSyntax_MOWLParser.axiom_return axiom() throws RecognitionException {
        ManchesterOWLSyntax_MOWLParser.axiom_return retval = new ManchesterOWLSyntax_MOWLParser.axiom_return();
        retval.start = input.LT(1);

        ManchesterOWLSyntaxTree root_0 = null;

        ManchesterOWLSyntax_MOWLParser.binaryAxiom_return binaryAxiom1 = null;

        ManchesterOWLSyntax_MOWLParser.unaryAxiom_return unaryAxiom2 = null;

        ManchesterOWLSyntax_MOWLParser.assertionAxiom_return assertionAxiom3 = null;

        ManchesterOWLSyntax_MOWLParser.hasKeyAxiom_return hasKeyAxiom4 = null;

        ManchesterOWLSyntax_MOWLParser.annotationAssertionAxiom_return annotationAssertionAxiom5 = null;


        RewriteRuleSubtreeStream stream_binaryAxiom=new RewriteRuleSubtreeStream(adaptor,"rule binaryAxiom");
        RewriteRuleSubtreeStream stream_unaryAxiom=new RewriteRuleSubtreeStream(adaptor,"rule unaryAxiom");
        RewriteRuleSubtreeStream stream_annotationAssertionAxiom=new RewriteRuleSubtreeStream(adaptor,"rule annotationAssertionAxiom");
        RewriteRuleSubtreeStream stream_hasKeyAxiom=new RewriteRuleSubtreeStream(adaptor,"rule hasKeyAxiom");
        RewriteRuleSubtreeStream stream_assertionAxiom=new RewriteRuleSubtreeStream(adaptor,"rule assertionAxiom");
        try {
            // MOWLParser.g:65:37: ( binaryAxiom -> ^( binaryAxiom ) | unaryAxiom -> ^( unaryAxiom ) | assertionAxiom -> ^( assertionAxiom ) | hasKeyAxiom -> ^( hasKeyAxiom ) | annotationAssertionAxiom -> ^( annotationAssertionAxiom ) )
            int alt1=5;
            alt1 = dfa1.predict(input);
            switch (alt1) {
                case 1 :
                    // MOWLParser.g:66:3: binaryAxiom
                    {
                    pushFollow(FOLLOW_binaryAxiom_in_axiom241);
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

                    root_0 = (ManchesterOWLSyntaxTree)adaptor.nil();
                    // 66:15: -> ^( binaryAxiom )
                    {
                        // MOWLParser.g:66:18: ^( binaryAxiom )
                        {
                        ManchesterOWLSyntaxTree root_1 = (ManchesterOWLSyntaxTree)adaptor.nil();
                        root_1 = (ManchesterOWLSyntaxTree)adaptor.becomeRoot(stream_binaryAxiom.nextNode(), root_1);

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 2 :
                    // MOWLParser.g:67:5: unaryAxiom
                    {
                    pushFollow(FOLLOW_unaryAxiom_in_axiom253);
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

                    root_0 = (ManchesterOWLSyntaxTree)adaptor.nil();
                    // 67:16: -> ^( unaryAxiom )
                    {
                        // MOWLParser.g:67:19: ^( unaryAxiom )
                        {
                        ManchesterOWLSyntaxTree root_1 = (ManchesterOWLSyntaxTree)adaptor.nil();
                        root_1 = (ManchesterOWLSyntaxTree)adaptor.becomeRoot(stream_unaryAxiom.nextNode(), root_1);

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 3 :
                    // MOWLParser.g:68:5: assertionAxiom
                    {
                    pushFollow(FOLLOW_assertionAxiom_in_axiom265);
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

                    root_0 = (ManchesterOWLSyntaxTree)adaptor.nil();
                    // 68:20: -> ^( assertionAxiom )
                    {
                        // MOWLParser.g:68:23: ^( assertionAxiom )
                        {
                        ManchesterOWLSyntaxTree root_1 = (ManchesterOWLSyntaxTree)adaptor.nil();
                        root_1 = (ManchesterOWLSyntaxTree)adaptor.becomeRoot(stream_assertionAxiom.nextNode(), root_1);

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 4 :
                    // MOWLParser.g:69:5: hasKeyAxiom
                    {
                    pushFollow(FOLLOW_hasKeyAxiom_in_axiom277);
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

                    root_0 = (ManchesterOWLSyntaxTree)adaptor.nil();
                    // 69:17: -> ^( hasKeyAxiom )
                    {
                        // MOWLParser.g:69:19: ^( hasKeyAxiom )
                        {
                        ManchesterOWLSyntaxTree root_1 = (ManchesterOWLSyntaxTree)adaptor.nil();
                        root_1 = (ManchesterOWLSyntaxTree)adaptor.becomeRoot(stream_hasKeyAxiom.nextNode(), root_1);

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 5 :
                    // MOWLParser.g:70:5: annotationAssertionAxiom
                    {
                    pushFollow(FOLLOW_annotationAssertionAxiom_in_axiom288);
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

                    root_0 = (ManchesterOWLSyntaxTree)adaptor.nil();
                    // 70:30: -> ^( annotationAssertionAxiom )
                    {
                        // MOWLParser.g:70:32: ^( annotationAssertionAxiom )
                        {
                        ManchesterOWLSyntaxTree root_1 = (ManchesterOWLSyntaxTree)adaptor.nil();
                        root_1 = (ManchesterOWLSyntaxTree)adaptor.becomeRoot(stream_annotationAssertionAxiom.nextNode(), root_1);

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (ManchesterOWLSyntaxTree)adaptor.rulePostProcessing(root_0);
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
        ManchesterOWLSyntaxTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "annotationAssertionAxiom"
    // MOWLParser.g:73:1: annotationAssertionAxiom : IRI p= atomic o= constant -> ^( ANNOTATION_ASSERTION IRI ^( EXPRESSION $p) ^( EXPRESSION $o) ) ;
    public final ManchesterOWLSyntax_MOWLParser.annotationAssertionAxiom_return annotationAssertionAxiom() throws RecognitionException {
        ManchesterOWLSyntax_MOWLParser.annotationAssertionAxiom_return retval = new ManchesterOWLSyntax_MOWLParser.annotationAssertionAxiom_return();
        retval.start = input.LT(1);

        ManchesterOWLSyntaxTree root_0 = null;

        Token IRI6=null;
        ManchesterOWLSyntax_MOWLParser.atomic_return p = null;

        ManchesterOWLSyntax_MOWLParser.constant_return o = null;


        ManchesterOWLSyntaxTree IRI6_tree=null;
        RewriteRuleTokenStream stream_IRI=new RewriteRuleTokenStream(adaptor,"token IRI");
        RewriteRuleSubtreeStream stream_constant=new RewriteRuleSubtreeStream(adaptor,"rule constant");
        RewriteRuleSubtreeStream stream_atomic=new RewriteRuleSubtreeStream(adaptor,"rule atomic");
        try {
            // MOWLParser.g:74:2: ( IRI p= atomic o= constant -> ^( ANNOTATION_ASSERTION IRI ^( EXPRESSION $p) ^( EXPRESSION $o) ) )
            // MOWLParser.g:75:3: IRI p= atomic o= constant
            {
            IRI6=(Token)match(input,IRI,FOLLOW_IRI_in_annotationAssertionAxiom306); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_IRI.add(IRI6);

            pushFollow(FOLLOW_atomic_in_annotationAssertionAxiom311);
            p=atomic();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_atomic.add(p.getTree());
            pushFollow(FOLLOW_constant_in_annotationAssertionAxiom317);
            o=constant();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_constant.add(o.getTree());


            // AST REWRITE
            // elements: IRI, o, p
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

            root_0 = (ManchesterOWLSyntaxTree)adaptor.nil();
            // 75:30: -> ^( ANNOTATION_ASSERTION IRI ^( EXPRESSION $p) ^( EXPRESSION $o) )
            {
                // MOWLParser.g:75:33: ^( ANNOTATION_ASSERTION IRI ^( EXPRESSION $p) ^( EXPRESSION $o) )
                {
                ManchesterOWLSyntaxTree root_1 = (ManchesterOWLSyntaxTree)adaptor.nil();
                root_1 = (ManchesterOWLSyntaxTree)adaptor.becomeRoot((ManchesterOWLSyntaxTree)adaptor.create(ANNOTATION_ASSERTION, "ANNOTATION_ASSERTION"), root_1);

                adaptor.addChild(root_1, stream_IRI.nextNode());
                // MOWLParser.g:75:60: ^( EXPRESSION $p)
                {
                ManchesterOWLSyntaxTree root_2 = (ManchesterOWLSyntaxTree)adaptor.nil();
                root_2 = (ManchesterOWLSyntaxTree)adaptor.becomeRoot((ManchesterOWLSyntaxTree)adaptor.create(EXPRESSION, "EXPRESSION"), root_2);

                adaptor.addChild(root_2, stream_p.nextTree());

                adaptor.addChild(root_1, root_2);
                }
                // MOWLParser.g:75:77: ^( EXPRESSION $o)
                {
                ManchesterOWLSyntaxTree root_2 = (ManchesterOWLSyntaxTree)adaptor.nil();
                root_2 = (ManchesterOWLSyntaxTree)adaptor.becomeRoot((ManchesterOWLSyntaxTree)adaptor.create(EXPRESSION, "EXPRESSION"), root_2);

                adaptor.addChild(root_2, stream_o.nextTree());

                adaptor.addChild(root_1, root_2);
                }

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (ManchesterOWLSyntaxTree)adaptor.rulePostProcessing(root_0);
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
        ManchesterOWLSyntaxTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "hasKeyAxiom"
    // MOWLParser.g:78:1: hasKeyAxiom : exp= expression HAS_KEY propertyExpression ( COMMA propertyExpression )* -> ^( HAS_KEY ^( EXPRESSION $exp) ( ^( EXPRESSION propertyExpression ) )+ ) ;
    public final ManchesterOWLSyntax_MOWLParser.hasKeyAxiom_return hasKeyAxiom() throws RecognitionException {
        ManchesterOWLSyntax_MOWLParser.hasKeyAxiom_return retval = new ManchesterOWLSyntax_MOWLParser.hasKeyAxiom_return();
        retval.start = input.LT(1);

        ManchesterOWLSyntaxTree root_0 = null;

        Token HAS_KEY7=null;
        Token COMMA9=null;
        ManchesterOWLSyntax_MOWLParser.expression_return exp = null;

        ManchesterOWLSyntax_MOWLParser.propertyExpression_return propertyExpression8 = null;

        ManchesterOWLSyntax_MOWLParser.propertyExpression_return propertyExpression10 = null;


        ManchesterOWLSyntaxTree HAS_KEY7_tree=null;
        ManchesterOWLSyntaxTree COMMA9_tree=null;
        RewriteRuleTokenStream stream_HAS_KEY=new RewriteRuleTokenStream(adaptor,"token HAS_KEY");
        RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
        RewriteRuleSubtreeStream stream_expression=new RewriteRuleSubtreeStream(adaptor,"rule expression");
        RewriteRuleSubtreeStream stream_propertyExpression=new RewriteRuleSubtreeStream(adaptor,"rule propertyExpression");
        try {
            // MOWLParser.g:79:2: (exp= expression HAS_KEY propertyExpression ( COMMA propertyExpression )* -> ^( HAS_KEY ^( EXPRESSION $exp) ( ^( EXPRESSION propertyExpression ) )+ ) )
            // MOWLParser.g:80:3: exp= expression HAS_KEY propertyExpression ( COMMA propertyExpression )*
            {
            pushFollow(FOLLOW_expression_in_hasKeyAxiom356);
            exp=expression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_expression.add(exp.getTree());
            HAS_KEY7=(Token)match(input,HAS_KEY,FOLLOW_HAS_KEY_in_hasKeyAxiom358); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_HAS_KEY.add(HAS_KEY7);

            pushFollow(FOLLOW_propertyExpression_in_hasKeyAxiom360);
            propertyExpression8=propertyExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_propertyExpression.add(propertyExpression8.getTree());
            // MOWLParser.g:80:47: ( COMMA propertyExpression )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==COMMA) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // MOWLParser.g:80:48: COMMA propertyExpression
            	    {
            	    COMMA9=(Token)match(input,COMMA,FOLLOW_COMMA_in_hasKeyAxiom363); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_COMMA.add(COMMA9);

            	    pushFollow(FOLLOW_propertyExpression_in_hasKeyAxiom365);
            	    propertyExpression10=propertyExpression();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_propertyExpression.add(propertyExpression10.getTree());

            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);



            // AST REWRITE
            // elements: exp, propertyExpression, HAS_KEY
            // token labels: 
            // rule labels: exp, retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_exp=new RewriteRuleSubtreeStream(adaptor,"rule exp",exp!=null?exp.tree:null);
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (ManchesterOWLSyntaxTree)adaptor.nil();
            // 80:75: -> ^( HAS_KEY ^( EXPRESSION $exp) ( ^( EXPRESSION propertyExpression ) )+ )
            {
                // MOWLParser.g:80:78: ^( HAS_KEY ^( EXPRESSION $exp) ( ^( EXPRESSION propertyExpression ) )+ )
                {
                ManchesterOWLSyntaxTree root_1 = (ManchesterOWLSyntaxTree)adaptor.nil();
                root_1 = (ManchesterOWLSyntaxTree)adaptor.becomeRoot(stream_HAS_KEY.nextNode(), root_1);

                // MOWLParser.g:80:88: ^( EXPRESSION $exp)
                {
                ManchesterOWLSyntaxTree root_2 = (ManchesterOWLSyntaxTree)adaptor.nil();
                root_2 = (ManchesterOWLSyntaxTree)adaptor.becomeRoot((ManchesterOWLSyntaxTree)adaptor.create(EXPRESSION, "EXPRESSION"), root_2);

                adaptor.addChild(root_2, stream_exp.nextTree());

                adaptor.addChild(root_1, root_2);
                }
                if ( !(stream_propertyExpression.hasNext()) ) {
                    throw new RewriteEarlyExitException();
                }
                while ( stream_propertyExpression.hasNext() ) {
                    // MOWLParser.g:80:108: ^( EXPRESSION propertyExpression )
                    {
                    ManchesterOWLSyntaxTree root_2 = (ManchesterOWLSyntaxTree)adaptor.nil();
                    root_2 = (ManchesterOWLSyntaxTree)adaptor.becomeRoot((ManchesterOWLSyntaxTree)adaptor.create(EXPRESSION, "EXPRESSION"), root_2);

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

            retval.tree = (ManchesterOWLSyntaxTree)adaptor.rulePostProcessing(root_0);
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
        ManchesterOWLSyntaxTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "assertionAxiom"
    // MOWLParser.g:85:1: assertionAxiom options {backtrack=true; } : (i= atomic ( INSTANCE_OF | TYPES ) expression -> ^( TYPE_ASSERTION ^( EXPRESSION expression ) ^( EXPRESSION $i) ) | subject= atomic propertyExpression value -> ^( ROLE_ASSERTION ^( EXPRESSION $subject) ^( EXPRESSION propertyExpression ) ^( EXPRESSION value ) ) | NOT assertionAxiom -> ^( NEGATED_ASSERTION assertionAxiom ) );
    public final ManchesterOWLSyntax_MOWLParser.assertionAxiom_return assertionAxiom() throws RecognitionException {
        ManchesterOWLSyntax_MOWLParser.assertionAxiom_return retval = new ManchesterOWLSyntax_MOWLParser.assertionAxiom_return();
        retval.start = input.LT(1);

        ManchesterOWLSyntaxTree root_0 = null;

        Token INSTANCE_OF11=null;
        Token TYPES12=null;
        Token NOT16=null;
        ManchesterOWLSyntax_MOWLParser.atomic_return i = null;

        ManchesterOWLSyntax_MOWLParser.atomic_return subject = null;

        ManchesterOWLSyntax_MOWLParser.expression_return expression13 = null;

        ManchesterOWLSyntax_MOWLParser.propertyExpression_return propertyExpression14 = null;

        ManchesterOWLSyntax_MOWLParser.value_return value15 = null;

        ManchesterOWLSyntax_MOWLParser.assertionAxiom_return assertionAxiom17 = null;


        ManchesterOWLSyntaxTree INSTANCE_OF11_tree=null;
        ManchesterOWLSyntaxTree TYPES12_tree=null;
        ManchesterOWLSyntaxTree NOT16_tree=null;
        RewriteRuleTokenStream stream_TYPES=new RewriteRuleTokenStream(adaptor,"token TYPES");
        RewriteRuleTokenStream stream_NOT=new RewriteRuleTokenStream(adaptor,"token NOT");
        RewriteRuleTokenStream stream_INSTANCE_OF=new RewriteRuleTokenStream(adaptor,"token INSTANCE_OF");
        RewriteRuleSubtreeStream stream_expression=new RewriteRuleSubtreeStream(adaptor,"rule expression");
        RewriteRuleSubtreeStream stream_propertyExpression=new RewriteRuleSubtreeStream(adaptor,"rule propertyExpression");
        RewriteRuleSubtreeStream stream_value=new RewriteRuleSubtreeStream(adaptor,"rule value");
        RewriteRuleSubtreeStream stream_assertionAxiom=new RewriteRuleSubtreeStream(adaptor,"rule assertionAxiom");
        RewriteRuleSubtreeStream stream_atomic=new RewriteRuleSubtreeStream(adaptor,"rule atomic");
        try {
            // MOWLParser.g:85:41: (i= atomic ( INSTANCE_OF | TYPES ) expression -> ^( TYPE_ASSERTION ^( EXPRESSION expression ) ^( EXPRESSION $i) ) | subject= atomic propertyExpression value -> ^( ROLE_ASSERTION ^( EXPRESSION $subject) ^( EXPRESSION propertyExpression ) ^( EXPRESSION value ) ) | NOT assertionAxiom -> ^( NEGATED_ASSERTION assertionAxiom ) )
            int alt4=3;
            switch ( input.LA(1) ) {
            case IDENTIFIER:
                {
                int LA4_1 = input.LA(2);

                if ( (LA4_1==INVERSE||(LA4_1>=IDENTIFIER && LA4_1<=ENTITY_REFERENCE)) ) {
                    alt4=2;
                }
                else if ( ((LA4_1>=INSTANCE_OF && LA4_1<=TYPES)) ) {
                    alt4=1;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 4, 1, input);

                    throw nvae;
                }
                }
                break;
            case ENTITY_REFERENCE:
                {
                int LA4_2 = input.LA(2);

                if ( (LA4_2==INVERSE||(LA4_2>=IDENTIFIER && LA4_2<=ENTITY_REFERENCE)) ) {
                    alt4=2;
                }
                else if ( ((LA4_2>=INSTANCE_OF && LA4_2<=TYPES)) ) {
                    alt4=1;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 4, 2, input);

                    throw nvae;
                }
                }
                break;
            case NOT:
                {
                alt4=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }

            switch (alt4) {
                case 1 :
                    // MOWLParser.g:86:3: i= atomic ( INSTANCE_OF | TYPES ) expression
                    {
                    pushFollow(FOLLOW_atomic_in_assertionAxiom413);
                    i=atomic();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_atomic.add(i.getTree());
                    // MOWLParser.g:86:14: ( INSTANCE_OF | TYPES )
                    int alt3=2;
                    int LA3_0 = input.LA(1);

                    if ( (LA3_0==INSTANCE_OF) ) {
                        alt3=1;
                    }
                    else if ( (LA3_0==TYPES) ) {
                        alt3=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 3, 0, input);

                        throw nvae;
                    }
                    switch (alt3) {
                        case 1 :
                            // MOWLParser.g:86:15: INSTANCE_OF
                            {
                            INSTANCE_OF11=(Token)match(input,INSTANCE_OF,FOLLOW_INSTANCE_OF_in_assertionAxiom416); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_INSTANCE_OF.add(INSTANCE_OF11);


                            }
                            break;
                        case 2 :
                            // MOWLParser.g:86:29: TYPES
                            {
                            TYPES12=(Token)match(input,TYPES,FOLLOW_TYPES_in_assertionAxiom420); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_TYPES.add(TYPES12);


                            }
                            break;

                    }

                    pushFollow(FOLLOW_expression_in_assertionAxiom423);
                    expression13=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_expression.add(expression13.getTree());


                    // AST REWRITE
                    // elements: i, expression
                    // token labels: 
                    // rule labels: retval, i
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
                    RewriteRuleSubtreeStream stream_i=new RewriteRuleSubtreeStream(adaptor,"rule i",i!=null?i.tree:null);

                    root_0 = (ManchesterOWLSyntaxTree)adaptor.nil();
                    // 86:47: -> ^( TYPE_ASSERTION ^( EXPRESSION expression ) ^( EXPRESSION $i) )
                    {
                        // MOWLParser.g:86:50: ^( TYPE_ASSERTION ^( EXPRESSION expression ) ^( EXPRESSION $i) )
                        {
                        ManchesterOWLSyntaxTree root_1 = (ManchesterOWLSyntaxTree)adaptor.nil();
                        root_1 = (ManchesterOWLSyntaxTree)adaptor.becomeRoot((ManchesterOWLSyntaxTree)adaptor.create(TYPE_ASSERTION, "TYPE_ASSERTION"), root_1);

                        // MOWLParser.g:86:67: ^( EXPRESSION expression )
                        {
                        ManchesterOWLSyntaxTree root_2 = (ManchesterOWLSyntaxTree)adaptor.nil();
                        root_2 = (ManchesterOWLSyntaxTree)adaptor.becomeRoot((ManchesterOWLSyntaxTree)adaptor.create(EXPRESSION, "EXPRESSION"), root_2);

                        adaptor.addChild(root_2, stream_expression.nextTree());

                        adaptor.addChild(root_1, root_2);
                        }
                        // MOWLParser.g:86:92: ^( EXPRESSION $i)
                        {
                        ManchesterOWLSyntaxTree root_2 = (ManchesterOWLSyntaxTree)adaptor.nil();
                        root_2 = (ManchesterOWLSyntaxTree)adaptor.becomeRoot((ManchesterOWLSyntaxTree)adaptor.create(EXPRESSION, "EXPRESSION"), root_2);

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
                    // MOWLParser.g:87:7: subject= atomic propertyExpression value
                    {
                    pushFollow(FOLLOW_atomic_in_assertionAxiom454);
                    subject=atomic();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_atomic.add(subject.getTree());
                    pushFollow(FOLLOW_propertyExpression_in_assertionAxiom456);
                    propertyExpression14=propertyExpression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_propertyExpression.add(propertyExpression14.getTree());
                    pushFollow(FOLLOW_value_in_assertionAxiom459);
                    value15=value();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_value.add(value15.getTree());


                    // AST REWRITE
                    // elements: propertyExpression, subject, value
                    // token labels: 
                    // rule labels: retval, subject
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
                    RewriteRuleSubtreeStream stream_subject=new RewriteRuleSubtreeStream(adaptor,"rule subject",subject!=null?subject.tree:null);

                    root_0 = (ManchesterOWLSyntaxTree)adaptor.nil();
                    // 87:50: -> ^( ROLE_ASSERTION ^( EXPRESSION $subject) ^( EXPRESSION propertyExpression ) ^( EXPRESSION value ) )
                    {
                        // MOWLParser.g:87:53: ^( ROLE_ASSERTION ^( EXPRESSION $subject) ^( EXPRESSION propertyExpression ) ^( EXPRESSION value ) )
                        {
                        ManchesterOWLSyntaxTree root_1 = (ManchesterOWLSyntaxTree)adaptor.nil();
                        root_1 = (ManchesterOWLSyntaxTree)adaptor.becomeRoot((ManchesterOWLSyntaxTree)adaptor.create(ROLE_ASSERTION, "ROLE_ASSERTION"), root_1);

                        // MOWLParser.g:87:70: ^( EXPRESSION $subject)
                        {
                        ManchesterOWLSyntaxTree root_2 = (ManchesterOWLSyntaxTree)adaptor.nil();
                        root_2 = (ManchesterOWLSyntaxTree)adaptor.becomeRoot((ManchesterOWLSyntaxTree)adaptor.create(EXPRESSION, "EXPRESSION"), root_2);

                        adaptor.addChild(root_2, stream_subject.nextTree());

                        adaptor.addChild(root_1, root_2);
                        }
                        // MOWLParser.g:87:93: ^( EXPRESSION propertyExpression )
                        {
                        ManchesterOWLSyntaxTree root_2 = (ManchesterOWLSyntaxTree)adaptor.nil();
                        root_2 = (ManchesterOWLSyntaxTree)adaptor.becomeRoot((ManchesterOWLSyntaxTree)adaptor.create(EXPRESSION, "EXPRESSION"), root_2);

                        adaptor.addChild(root_2, stream_propertyExpression.nextTree());

                        adaptor.addChild(root_1, root_2);
                        }
                        // MOWLParser.g:87:126: ^( EXPRESSION value )
                        {
                        ManchesterOWLSyntaxTree root_2 = (ManchesterOWLSyntaxTree)adaptor.nil();
                        root_2 = (ManchesterOWLSyntaxTree)adaptor.becomeRoot((ManchesterOWLSyntaxTree)adaptor.create(EXPRESSION, "EXPRESSION"), root_2);

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
                    // MOWLParser.g:89:5: NOT assertionAxiom
                    {
                    NOT16=(Token)match(input,NOT,FOLLOW_NOT_in_assertionAxiom493); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_NOT.add(NOT16);

                    pushFollow(FOLLOW_assertionAxiom_in_assertionAxiom495);
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

                    root_0 = (ManchesterOWLSyntaxTree)adaptor.nil();
                    // 89:24: -> ^( NEGATED_ASSERTION assertionAxiom )
                    {
                        // MOWLParser.g:89:27: ^( NEGATED_ASSERTION assertionAxiom )
                        {
                        ManchesterOWLSyntaxTree root_1 = (ManchesterOWLSyntaxTree)adaptor.nil();
                        root_1 = (ManchesterOWLSyntaxTree)adaptor.becomeRoot((ManchesterOWLSyntaxTree)adaptor.create(NEGATED_ASSERTION, "NEGATED_ASSERTION"), root_1);

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

            retval.tree = (ManchesterOWLSyntaxTree)adaptor.rulePostProcessing(root_0);
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
        ManchesterOWLSyntaxTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "binaryAxiom"
    // MOWLParser.g:94:1: binaryAxiom options {backtrack=true; } : (lhs= expression SUBCLASS_OF superClass= expression -> ^( SUB_CLASS_AXIOM ^( EXPRESSION $lhs) ^( EXPRESSION $superClass) ) | lhs= expression EQUIVALENT_TO rhs= expression -> ^( EQUIVALENT_TO_AXIOM ^( EXPRESSION $lhs) ^( EXPRESSION $rhs) ) | lhs= expression DISJOINT_WITH disjoint= expression -> ^( DISJOINT_WITH_AXIOM ^( EXPRESSION $lhs) ^( EXPRESSION $disjoint) ) | lhs= expression SUB_PROPERTY_OF superProperty= propertyExpression -> ^( SUB_PROPERTY_AXIOM ^( EXPRESSION $lhs) ^( EXPRESSION $superProperty) ) | lhsID= atomic INVERSE_OF rhsAtomic= atomic -> ^( INVERSE_OF ^( EXPRESSION $lhsID) ^( EXPRESSION $rhsAtomic) ) | lhsID= atomic SAME_AS rhsID= atomic -> ^( SAME_AS_AXIOM ^( EXPRESSION $lhsID) ^( EXPRESSION $rhsID) ) | lhsID= atomic DIFFERENT_FROM rhsID= atomic -> ^( DIFFERENT_FROM_AXIOM ^( EXPRESSION $lhsID) ^( EXPRESSION $rhsID) ) | lhsID= atomic DOMAIN expression -> ^( DOMAIN ^( EXPRESSION $lhsID) ^( EXPRESSION expression ) ) | lhsID= atomic RANGE expression -> ^( RANGE ^( EXPRESSION $lhsID) ^( EXPRESSION expression ) ) );
    public final ManchesterOWLSyntax_MOWLParser.binaryAxiom_return binaryAxiom() throws RecognitionException {
        ManchesterOWLSyntax_MOWLParser.binaryAxiom_return retval = new ManchesterOWLSyntax_MOWLParser.binaryAxiom_return();
        retval.start = input.LT(1);

        ManchesterOWLSyntaxTree root_0 = null;

        Token SUBCLASS_OF18=null;
        Token EQUIVALENT_TO19=null;
        Token DISJOINT_WITH20=null;
        Token SUB_PROPERTY_OF21=null;
        Token INVERSE_OF22=null;
        Token SAME_AS23=null;
        Token DIFFERENT_FROM24=null;
        Token DOMAIN25=null;
        Token RANGE27=null;
        ManchesterOWLSyntax_MOWLParser.expression_return lhs = null;

        ManchesterOWLSyntax_MOWLParser.expression_return superClass = null;

        ManchesterOWLSyntax_MOWLParser.expression_return rhs = null;

        ManchesterOWLSyntax_MOWLParser.expression_return disjoint = null;

        ManchesterOWLSyntax_MOWLParser.propertyExpression_return superProperty = null;

        ManchesterOWLSyntax_MOWLParser.atomic_return lhsID = null;

        ManchesterOWLSyntax_MOWLParser.atomic_return rhsAtomic = null;

        ManchesterOWLSyntax_MOWLParser.atomic_return rhsID = null;

        ManchesterOWLSyntax_MOWLParser.expression_return expression26 = null;

        ManchesterOWLSyntax_MOWLParser.expression_return expression28 = null;


        ManchesterOWLSyntaxTree SUBCLASS_OF18_tree=null;
        ManchesterOWLSyntaxTree EQUIVALENT_TO19_tree=null;
        ManchesterOWLSyntaxTree DISJOINT_WITH20_tree=null;
        ManchesterOWLSyntaxTree SUB_PROPERTY_OF21_tree=null;
        ManchesterOWLSyntaxTree INVERSE_OF22_tree=null;
        ManchesterOWLSyntaxTree SAME_AS23_tree=null;
        ManchesterOWLSyntaxTree DIFFERENT_FROM24_tree=null;
        ManchesterOWLSyntaxTree DOMAIN25_tree=null;
        ManchesterOWLSyntaxTree RANGE27_tree=null;
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
            // MOWLParser.g:96:26: (lhs= expression SUBCLASS_OF superClass= expression -> ^( SUB_CLASS_AXIOM ^( EXPRESSION $lhs) ^( EXPRESSION $superClass) ) | lhs= expression EQUIVALENT_TO rhs= expression -> ^( EQUIVALENT_TO_AXIOM ^( EXPRESSION $lhs) ^( EXPRESSION $rhs) ) | lhs= expression DISJOINT_WITH disjoint= expression -> ^( DISJOINT_WITH_AXIOM ^( EXPRESSION $lhs) ^( EXPRESSION $disjoint) ) | lhs= expression SUB_PROPERTY_OF superProperty= propertyExpression -> ^( SUB_PROPERTY_AXIOM ^( EXPRESSION $lhs) ^( EXPRESSION $superProperty) ) | lhsID= atomic INVERSE_OF rhsAtomic= atomic -> ^( INVERSE_OF ^( EXPRESSION $lhsID) ^( EXPRESSION $rhsAtomic) ) | lhsID= atomic SAME_AS rhsID= atomic -> ^( SAME_AS_AXIOM ^( EXPRESSION $lhsID) ^( EXPRESSION $rhsID) ) | lhsID= atomic DIFFERENT_FROM rhsID= atomic -> ^( DIFFERENT_FROM_AXIOM ^( EXPRESSION $lhsID) ^( EXPRESSION $rhsID) ) | lhsID= atomic DOMAIN expression -> ^( DOMAIN ^( EXPRESSION $lhsID) ^( EXPRESSION expression ) ) | lhsID= atomic RANGE expression -> ^( RANGE ^( EXPRESSION $lhsID) ^( EXPRESSION expression ) ) )
            int alt5=9;
            alt5 = dfa5.predict(input);
            switch (alt5) {
                case 1 :
                    // MOWLParser.g:97:2: lhs= expression SUBCLASS_OF superClass= expression
                    {
                    pushFollow(FOLLOW_expression_in_binaryAxiom534);
                    lhs=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_expression.add(lhs.getTree());
                    SUBCLASS_OF18=(Token)match(input,SUBCLASS_OF,FOLLOW_SUBCLASS_OF_in_binaryAxiom536); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_SUBCLASS_OF.add(SUBCLASS_OF18);

                    pushFollow(FOLLOW_expression_in_binaryAxiom543);
                    superClass=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_expression.add(superClass.getTree());


                    // AST REWRITE
                    // elements: lhs, superClass
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

                    root_0 = (ManchesterOWLSyntaxTree)adaptor.nil();
                    // 97:57: -> ^( SUB_CLASS_AXIOM ^( EXPRESSION $lhs) ^( EXPRESSION $superClass) )
                    {
                        // MOWLParser.g:97:60: ^( SUB_CLASS_AXIOM ^( EXPRESSION $lhs) ^( EXPRESSION $superClass) )
                        {
                        ManchesterOWLSyntaxTree root_1 = (ManchesterOWLSyntaxTree)adaptor.nil();
                        root_1 = (ManchesterOWLSyntaxTree)adaptor.becomeRoot((ManchesterOWLSyntaxTree)adaptor.create(SUB_CLASS_AXIOM, "SUB_CLASS_AXIOM"), root_1);

                        // MOWLParser.g:97:79: ^( EXPRESSION $lhs)
                        {
                        ManchesterOWLSyntaxTree root_2 = (ManchesterOWLSyntaxTree)adaptor.nil();
                        root_2 = (ManchesterOWLSyntaxTree)adaptor.becomeRoot((ManchesterOWLSyntaxTree)adaptor.create(EXPRESSION, "EXPRESSION"), root_2);

                        adaptor.addChild(root_2, stream_lhs.nextTree());

                        adaptor.addChild(root_1, root_2);
                        }
                        // MOWLParser.g:97:98: ^( EXPRESSION $superClass)
                        {
                        ManchesterOWLSyntaxTree root_2 = (ManchesterOWLSyntaxTree)adaptor.nil();
                        root_2 = (ManchesterOWLSyntaxTree)adaptor.becomeRoot((ManchesterOWLSyntaxTree)adaptor.create(EXPRESSION, "EXPRESSION"), root_2);

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
                    // MOWLParser.g:98:11: lhs= expression EQUIVALENT_TO rhs= expression
                    {
                    pushFollow(FOLLOW_expression_in_binaryAxiom581);
                    lhs=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_expression.add(lhs.getTree());
                    EQUIVALENT_TO19=(Token)match(input,EQUIVALENT_TO,FOLLOW_EQUIVALENT_TO_in_binaryAxiom583); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_EQUIVALENT_TO.add(EQUIVALENT_TO19);

                    pushFollow(FOLLOW_expression_in_binaryAxiom589);
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

                    root_0 = (ManchesterOWLSyntaxTree)adaptor.nil();
                    // 98:60: -> ^( EQUIVALENT_TO_AXIOM ^( EXPRESSION $lhs) ^( EXPRESSION $rhs) )
                    {
                        // MOWLParser.g:98:63: ^( EQUIVALENT_TO_AXIOM ^( EXPRESSION $lhs) ^( EXPRESSION $rhs) )
                        {
                        ManchesterOWLSyntaxTree root_1 = (ManchesterOWLSyntaxTree)adaptor.nil();
                        root_1 = (ManchesterOWLSyntaxTree)adaptor.becomeRoot((ManchesterOWLSyntaxTree)adaptor.create(EQUIVALENT_TO_AXIOM, "EQUIVALENT_TO_AXIOM"), root_1);

                        // MOWLParser.g:98:85: ^( EXPRESSION $lhs)
                        {
                        ManchesterOWLSyntaxTree root_2 = (ManchesterOWLSyntaxTree)adaptor.nil();
                        root_2 = (ManchesterOWLSyntaxTree)adaptor.becomeRoot((ManchesterOWLSyntaxTree)adaptor.create(EXPRESSION, "EXPRESSION"), root_2);

                        adaptor.addChild(root_2, stream_lhs.nextTree());

                        adaptor.addChild(root_1, root_2);
                        }
                        // MOWLParser.g:98:104: ^( EXPRESSION $rhs)
                        {
                        ManchesterOWLSyntaxTree root_2 = (ManchesterOWLSyntaxTree)adaptor.nil();
                        root_2 = (ManchesterOWLSyntaxTree)adaptor.becomeRoot((ManchesterOWLSyntaxTree)adaptor.create(EXPRESSION, "EXPRESSION"), root_2);

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
                    // MOWLParser.g:99:11: lhs= expression DISJOINT_WITH disjoint= expression
                    {
                    pushFollow(FOLLOW_expression_in_binaryAxiom626);
                    lhs=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_expression.add(lhs.getTree());
                    DISJOINT_WITH20=(Token)match(input,DISJOINT_WITH,FOLLOW_DISJOINT_WITH_in_binaryAxiom628); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_DISJOINT_WITH.add(DISJOINT_WITH20);

                    pushFollow(FOLLOW_expression_in_binaryAxiom634);
                    disjoint=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_expression.add(disjoint.getTree());


                    // AST REWRITE
                    // elements: lhs, disjoint
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

                    root_0 = (ManchesterOWLSyntaxTree)adaptor.nil();
                    // 99:65: -> ^( DISJOINT_WITH_AXIOM ^( EXPRESSION $lhs) ^( EXPRESSION $disjoint) )
                    {
                        // MOWLParser.g:99:68: ^( DISJOINT_WITH_AXIOM ^( EXPRESSION $lhs) ^( EXPRESSION $disjoint) )
                        {
                        ManchesterOWLSyntaxTree root_1 = (ManchesterOWLSyntaxTree)adaptor.nil();
                        root_1 = (ManchesterOWLSyntaxTree)adaptor.becomeRoot((ManchesterOWLSyntaxTree)adaptor.create(DISJOINT_WITH_AXIOM, "DISJOINT_WITH_AXIOM"), root_1);

                        // MOWLParser.g:99:90: ^( EXPRESSION $lhs)
                        {
                        ManchesterOWLSyntaxTree root_2 = (ManchesterOWLSyntaxTree)adaptor.nil();
                        root_2 = (ManchesterOWLSyntaxTree)adaptor.becomeRoot((ManchesterOWLSyntaxTree)adaptor.create(EXPRESSION, "EXPRESSION"), root_2);

                        adaptor.addChild(root_2, stream_lhs.nextTree());

                        adaptor.addChild(root_1, root_2);
                        }
                        // MOWLParser.g:99:109: ^( EXPRESSION $disjoint)
                        {
                        ManchesterOWLSyntaxTree root_2 = (ManchesterOWLSyntaxTree)adaptor.nil();
                        root_2 = (ManchesterOWLSyntaxTree)adaptor.becomeRoot((ManchesterOWLSyntaxTree)adaptor.create(EXPRESSION, "EXPRESSION"), root_2);

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
                    // MOWLParser.g:100:11: lhs= expression SUB_PROPERTY_OF superProperty= propertyExpression
                    {
                    pushFollow(FOLLOW_expression_in_binaryAxiom671);
                    lhs=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_expression.add(lhs.getTree());
                    SUB_PROPERTY_OF21=(Token)match(input,SUB_PROPERTY_OF,FOLLOW_SUB_PROPERTY_OF_in_binaryAxiom673); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_SUB_PROPERTY_OF.add(SUB_PROPERTY_OF21);

                    pushFollow(FOLLOW_propertyExpression_in_binaryAxiom679);
                    superProperty=propertyExpression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_propertyExpression.add(superProperty.getTree());


                    // AST REWRITE
                    // elements: lhs, superProperty
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

                    root_0 = (ManchesterOWLSyntaxTree)adaptor.nil();
                    // 100:80: -> ^( SUB_PROPERTY_AXIOM ^( EXPRESSION $lhs) ^( EXPRESSION $superProperty) )
                    {
                        // MOWLParser.g:100:83: ^( SUB_PROPERTY_AXIOM ^( EXPRESSION $lhs) ^( EXPRESSION $superProperty) )
                        {
                        ManchesterOWLSyntaxTree root_1 = (ManchesterOWLSyntaxTree)adaptor.nil();
                        root_1 = (ManchesterOWLSyntaxTree)adaptor.becomeRoot((ManchesterOWLSyntaxTree)adaptor.create(SUB_PROPERTY_AXIOM, "SUB_PROPERTY_AXIOM"), root_1);

                        // MOWLParser.g:100:104: ^( EXPRESSION $lhs)
                        {
                        ManchesterOWLSyntaxTree root_2 = (ManchesterOWLSyntaxTree)adaptor.nil();
                        root_2 = (ManchesterOWLSyntaxTree)adaptor.becomeRoot((ManchesterOWLSyntaxTree)adaptor.create(EXPRESSION, "EXPRESSION"), root_2);

                        adaptor.addChild(root_2, stream_lhs.nextTree());

                        adaptor.addChild(root_1, root_2);
                        }
                        // MOWLParser.g:100:123: ^( EXPRESSION $superProperty)
                        {
                        ManchesterOWLSyntaxTree root_2 = (ManchesterOWLSyntaxTree)adaptor.nil();
                        root_2 = (ManchesterOWLSyntaxTree)adaptor.becomeRoot((ManchesterOWLSyntaxTree)adaptor.create(EXPRESSION, "EXPRESSION"), root_2);

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
                    // MOWLParser.g:101:11: lhsID= atomic INVERSE_OF rhsAtomic= atomic
                    {
                    pushFollow(FOLLOW_atomic_in_binaryAxiom716);
                    lhsID=atomic();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_atomic.add(lhsID.getTree());
                    INVERSE_OF22=(Token)match(input,INVERSE_OF,FOLLOW_INVERSE_OF_in_binaryAxiom718); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_INVERSE_OF.add(INVERSE_OF22);

                    pushFollow(FOLLOW_atomic_in_binaryAxiom724);
                    rhsAtomic=atomic();

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

                    root_0 = (ManchesterOWLSyntaxTree)adaptor.nil();
                    // 101:57: -> ^( INVERSE_OF ^( EXPRESSION $lhsID) ^( EXPRESSION $rhsAtomic) )
                    {
                        // MOWLParser.g:101:60: ^( INVERSE_OF ^( EXPRESSION $lhsID) ^( EXPRESSION $rhsAtomic) )
                        {
                        ManchesterOWLSyntaxTree root_1 = (ManchesterOWLSyntaxTree)adaptor.nil();
                        root_1 = (ManchesterOWLSyntaxTree)adaptor.becomeRoot(stream_INVERSE_OF.nextNode(), root_1);

                        // MOWLParser.g:101:73: ^( EXPRESSION $lhsID)
                        {
                        ManchesterOWLSyntaxTree root_2 = (ManchesterOWLSyntaxTree)adaptor.nil();
                        root_2 = (ManchesterOWLSyntaxTree)adaptor.becomeRoot((ManchesterOWLSyntaxTree)adaptor.create(EXPRESSION, "EXPRESSION"), root_2);

                        adaptor.addChild(root_2, stream_lhsID.nextTree());

                        adaptor.addChild(root_1, root_2);
                        }
                        // MOWLParser.g:101:94: ^( EXPRESSION $rhsAtomic)
                        {
                        ManchesterOWLSyntaxTree root_2 = (ManchesterOWLSyntaxTree)adaptor.nil();
                        root_2 = (ManchesterOWLSyntaxTree)adaptor.becomeRoot((ManchesterOWLSyntaxTree)adaptor.create(EXPRESSION, "EXPRESSION"), root_2);

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
                    // MOWLParser.g:102:3: lhsID= atomic SAME_AS rhsID= atomic
                    {
                    pushFollow(FOLLOW_atomic_in_binaryAxiom755);
                    lhsID=atomic();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_atomic.add(lhsID.getTree());
                    SAME_AS23=(Token)match(input,SAME_AS,FOLLOW_SAME_AS_in_binaryAxiom757); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_SAME_AS.add(SAME_AS23);

                    pushFollow(FOLLOW_atomic_in_binaryAxiom764);
                    rhsID=atomic();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_atomic.add(rhsID.getTree());


                    // AST REWRITE
                    // elements: lhsID, rhsID
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

                    root_0 = (ManchesterOWLSyntaxTree)adaptor.nil();
                    // 102:43: -> ^( SAME_AS_AXIOM ^( EXPRESSION $lhsID) ^( EXPRESSION $rhsID) )
                    {
                        // MOWLParser.g:102:46: ^( SAME_AS_AXIOM ^( EXPRESSION $lhsID) ^( EXPRESSION $rhsID) )
                        {
                        ManchesterOWLSyntaxTree root_1 = (ManchesterOWLSyntaxTree)adaptor.nil();
                        root_1 = (ManchesterOWLSyntaxTree)adaptor.becomeRoot((ManchesterOWLSyntaxTree)adaptor.create(SAME_AS_AXIOM, "SAME_AS_AXIOM"), root_1);

                        // MOWLParser.g:102:62: ^( EXPRESSION $lhsID)
                        {
                        ManchesterOWLSyntaxTree root_2 = (ManchesterOWLSyntaxTree)adaptor.nil();
                        root_2 = (ManchesterOWLSyntaxTree)adaptor.becomeRoot((ManchesterOWLSyntaxTree)adaptor.create(EXPRESSION, "EXPRESSION"), root_2);

                        adaptor.addChild(root_2, stream_lhsID.nextTree());

                        adaptor.addChild(root_1, root_2);
                        }
                        // MOWLParser.g:102:84: ^( EXPRESSION $rhsID)
                        {
                        ManchesterOWLSyntaxTree root_2 = (ManchesterOWLSyntaxTree)adaptor.nil();
                        root_2 = (ManchesterOWLSyntaxTree)adaptor.becomeRoot((ManchesterOWLSyntaxTree)adaptor.create(EXPRESSION, "EXPRESSION"), root_2);

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
                    // MOWLParser.g:103:11: lhsID= atomic DIFFERENT_FROM rhsID= atomic
                    {
                    pushFollow(FOLLOW_atomic_in_binaryAxiom802);
                    lhsID=atomic();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_atomic.add(lhsID.getTree());
                    DIFFERENT_FROM24=(Token)match(input,DIFFERENT_FROM,FOLLOW_DIFFERENT_FROM_in_binaryAxiom804); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_DIFFERENT_FROM.add(DIFFERENT_FROM24);

                    pushFollow(FOLLOW_atomic_in_binaryAxiom811);
                    rhsID=atomic();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_atomic.add(rhsID.getTree());


                    // AST REWRITE
                    // elements: lhsID, rhsID
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

                    root_0 = (ManchesterOWLSyntaxTree)adaptor.nil();
                    // 103:58: -> ^( DIFFERENT_FROM_AXIOM ^( EXPRESSION $lhsID) ^( EXPRESSION $rhsID) )
                    {
                        // MOWLParser.g:103:61: ^( DIFFERENT_FROM_AXIOM ^( EXPRESSION $lhsID) ^( EXPRESSION $rhsID) )
                        {
                        ManchesterOWLSyntaxTree root_1 = (ManchesterOWLSyntaxTree)adaptor.nil();
                        root_1 = (ManchesterOWLSyntaxTree)adaptor.becomeRoot((ManchesterOWLSyntaxTree)adaptor.create(DIFFERENT_FROM_AXIOM, "DIFFERENT_FROM_AXIOM"), root_1);

                        // MOWLParser.g:103:84: ^( EXPRESSION $lhsID)
                        {
                        ManchesterOWLSyntaxTree root_2 = (ManchesterOWLSyntaxTree)adaptor.nil();
                        root_2 = (ManchesterOWLSyntaxTree)adaptor.becomeRoot((ManchesterOWLSyntaxTree)adaptor.create(EXPRESSION, "EXPRESSION"), root_2);

                        adaptor.addChild(root_2, stream_lhsID.nextTree());

                        adaptor.addChild(root_1, root_2);
                        }
                        // MOWLParser.g:103:105: ^( EXPRESSION $rhsID)
                        {
                        ManchesterOWLSyntaxTree root_2 = (ManchesterOWLSyntaxTree)adaptor.nil();
                        root_2 = (ManchesterOWLSyntaxTree)adaptor.becomeRoot((ManchesterOWLSyntaxTree)adaptor.create(EXPRESSION, "EXPRESSION"), root_2);

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
                    // MOWLParser.g:104:11: lhsID= atomic DOMAIN expression
                    {
                    pushFollow(FOLLOW_atomic_in_binaryAxiom848);
                    lhsID=atomic();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_atomic.add(lhsID.getTree());
                    DOMAIN25=(Token)match(input,DOMAIN,FOLLOW_DOMAIN_in_binaryAxiom851); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_DOMAIN.add(DOMAIN25);

                    pushFollow(FOLLOW_expression_in_binaryAxiom853);
                    expression26=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_expression.add(expression26.getTree());


                    // AST REWRITE
                    // elements: lhsID, DOMAIN, expression
                    // token labels: 
                    // rule labels: lhsID, retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_lhsID=new RewriteRuleSubtreeStream(adaptor,"rule lhsID",lhsID!=null?lhsID.tree:null);
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (ManchesterOWLSyntaxTree)adaptor.nil();
                    // 104:46: -> ^( DOMAIN ^( EXPRESSION $lhsID) ^( EXPRESSION expression ) )
                    {
                        // MOWLParser.g:104:49: ^( DOMAIN ^( EXPRESSION $lhsID) ^( EXPRESSION expression ) )
                        {
                        ManchesterOWLSyntaxTree root_1 = (ManchesterOWLSyntaxTree)adaptor.nil();
                        root_1 = (ManchesterOWLSyntaxTree)adaptor.becomeRoot(stream_DOMAIN.nextNode(), root_1);

                        // MOWLParser.g:104:58: ^( EXPRESSION $lhsID)
                        {
                        ManchesterOWLSyntaxTree root_2 = (ManchesterOWLSyntaxTree)adaptor.nil();
                        root_2 = (ManchesterOWLSyntaxTree)adaptor.becomeRoot((ManchesterOWLSyntaxTree)adaptor.create(EXPRESSION, "EXPRESSION"), root_2);

                        adaptor.addChild(root_2, stream_lhsID.nextTree());

                        adaptor.addChild(root_1, root_2);
                        }
                        // MOWLParser.g:104:79: ^( EXPRESSION expression )
                        {
                        ManchesterOWLSyntaxTree root_2 = (ManchesterOWLSyntaxTree)adaptor.nil();
                        root_2 = (ManchesterOWLSyntaxTree)adaptor.becomeRoot((ManchesterOWLSyntaxTree)adaptor.create(EXPRESSION, "EXPRESSION"), root_2);

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
                    // MOWLParser.g:105:11: lhsID= atomic RANGE expression
                    {
                    pushFollow(FOLLOW_atomic_in_binaryAxiom889);
                    lhsID=atomic();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_atomic.add(lhsID.getTree());
                    RANGE27=(Token)match(input,RANGE,FOLLOW_RANGE_in_binaryAxiom891); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_RANGE.add(RANGE27);

                    pushFollow(FOLLOW_expression_in_binaryAxiom893);
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

                    root_0 = (ManchesterOWLSyntaxTree)adaptor.nil();
                    // 105:44: -> ^( RANGE ^( EXPRESSION $lhsID) ^( EXPRESSION expression ) )
                    {
                        // MOWLParser.g:105:47: ^( RANGE ^( EXPRESSION $lhsID) ^( EXPRESSION expression ) )
                        {
                        ManchesterOWLSyntaxTree root_1 = (ManchesterOWLSyntaxTree)adaptor.nil();
                        root_1 = (ManchesterOWLSyntaxTree)adaptor.becomeRoot(stream_RANGE.nextNode(), root_1);

                        // MOWLParser.g:105:55: ^( EXPRESSION $lhsID)
                        {
                        ManchesterOWLSyntaxTree root_2 = (ManchesterOWLSyntaxTree)adaptor.nil();
                        root_2 = (ManchesterOWLSyntaxTree)adaptor.becomeRoot((ManchesterOWLSyntaxTree)adaptor.create(EXPRESSION, "EXPRESSION"), root_2);

                        adaptor.addChild(root_2, stream_lhsID.nextTree());

                        adaptor.addChild(root_1, root_2);
                        }
                        // MOWLParser.g:105:76: ^( EXPRESSION expression )
                        {
                        ManchesterOWLSyntaxTree root_2 = (ManchesterOWLSyntaxTree)adaptor.nil();
                        root_2 = (ManchesterOWLSyntaxTree)adaptor.becomeRoot((ManchesterOWLSyntaxTree)adaptor.create(EXPRESSION, "EXPRESSION"), root_2);

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

            retval.tree = (ManchesterOWLSyntaxTree)adaptor.rulePostProcessing(root_0);
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
        ManchesterOWLSyntaxTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "unaryAxiom"
    // MOWLParser.g:109:1: unaryAxiom : unaryCharacteristic unary -> ^( UNARY_AXIOM unaryCharacteristic ^( EXPRESSION unary ) ) ;
    public final ManchesterOWLSyntax_MOWLParser.unaryAxiom_return unaryAxiom() throws RecognitionException {
        ManchesterOWLSyntax_MOWLParser.unaryAxiom_return retval = new ManchesterOWLSyntax_MOWLParser.unaryAxiom_return();
        retval.start = input.LT(1);

        ManchesterOWLSyntaxTree root_0 = null;

        ManchesterOWLSyntax_MOWLParser.unaryCharacteristic_return unaryCharacteristic29 = null;

        ManchesterOWLSyntax_MOWLParser.unary_return unary30 = null;


        RewriteRuleSubtreeStream stream_unary=new RewriteRuleSubtreeStream(adaptor,"rule unary");
        RewriteRuleSubtreeStream stream_unaryCharacteristic=new RewriteRuleSubtreeStream(adaptor,"rule unaryCharacteristic");
        try {
            // MOWLParser.g:109:13: ( unaryCharacteristic unary -> ^( UNARY_AXIOM unaryCharacteristic ^( EXPRESSION unary ) ) )
            // MOWLParser.g:110:4: unaryCharacteristic unary
            {
            pushFollow(FOLLOW_unaryCharacteristic_in_unaryAxiom967);
            unaryCharacteristic29=unaryCharacteristic();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_unaryCharacteristic.add(unaryCharacteristic29.getTree());
            pushFollow(FOLLOW_unary_in_unaryAxiom971);
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

            root_0 = (ManchesterOWLSyntaxTree)adaptor.nil();
            // 110:32: -> ^( UNARY_AXIOM unaryCharacteristic ^( EXPRESSION unary ) )
            {
                // MOWLParser.g:110:35: ^( UNARY_AXIOM unaryCharacteristic ^( EXPRESSION unary ) )
                {
                ManchesterOWLSyntaxTree root_1 = (ManchesterOWLSyntaxTree)adaptor.nil();
                root_1 = (ManchesterOWLSyntaxTree)adaptor.becomeRoot((ManchesterOWLSyntaxTree)adaptor.create(UNARY_AXIOM, "UNARY_AXIOM"), root_1);

                adaptor.addChild(root_1, stream_unaryCharacteristic.nextTree());
                // MOWLParser.g:110:69: ^( EXPRESSION unary )
                {
                ManchesterOWLSyntaxTree root_2 = (ManchesterOWLSyntaxTree)adaptor.nil();
                root_2 = (ManchesterOWLSyntaxTree)adaptor.becomeRoot((ManchesterOWLSyntaxTree)adaptor.create(EXPRESSION, "EXPRESSION"), root_2);

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

            retval.tree = (ManchesterOWLSyntaxTree)adaptor.rulePostProcessing(root_0);
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
        ManchesterOWLSyntaxTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "unaryCharacteristic"
    // MOWLParser.g:113:1: unaryCharacteristic : ( FUNCTIONAL -> ^( FUNCTIONAL ) | INVERSE_FUNCTIONAL -> ^( INVERSE_FUNCTIONAL ) | SYMMETRIC -> ^( SYMMETRIC ) | ANTI_SYMMETRIC -> ^( ANTI_SYMMETRIC ) | REFLEXIVE -> ^( REFLEXIVE ) | IRREFLEXIVE -> ^( IRREFLEXIVE ) | TRANSITIVE -> ^( TRANSITIVE ) );
    public final ManchesterOWLSyntax_MOWLParser.unaryCharacteristic_return unaryCharacteristic() throws RecognitionException {
        ManchesterOWLSyntax_MOWLParser.unaryCharacteristic_return retval = new ManchesterOWLSyntax_MOWLParser.unaryCharacteristic_return();
        retval.start = input.LT(1);

        ManchesterOWLSyntaxTree root_0 = null;

        Token FUNCTIONAL31=null;
        Token INVERSE_FUNCTIONAL32=null;
        Token SYMMETRIC33=null;
        Token ANTI_SYMMETRIC34=null;
        Token REFLEXIVE35=null;
        Token IRREFLEXIVE36=null;
        Token TRANSITIVE37=null;

        ManchesterOWLSyntaxTree FUNCTIONAL31_tree=null;
        ManchesterOWLSyntaxTree INVERSE_FUNCTIONAL32_tree=null;
        ManchesterOWLSyntaxTree SYMMETRIC33_tree=null;
        ManchesterOWLSyntaxTree ANTI_SYMMETRIC34_tree=null;
        ManchesterOWLSyntaxTree REFLEXIVE35_tree=null;
        ManchesterOWLSyntaxTree IRREFLEXIVE36_tree=null;
        ManchesterOWLSyntaxTree TRANSITIVE37_tree=null;
        RewriteRuleTokenStream stream_REFLEXIVE=new RewriteRuleTokenStream(adaptor,"token REFLEXIVE");
        RewriteRuleTokenStream stream_SYMMETRIC=new RewriteRuleTokenStream(adaptor,"token SYMMETRIC");
        RewriteRuleTokenStream stream_FUNCTIONAL=new RewriteRuleTokenStream(adaptor,"token FUNCTIONAL");
        RewriteRuleTokenStream stream_TRANSITIVE=new RewriteRuleTokenStream(adaptor,"token TRANSITIVE");
        RewriteRuleTokenStream stream_ANTI_SYMMETRIC=new RewriteRuleTokenStream(adaptor,"token ANTI_SYMMETRIC");
        RewriteRuleTokenStream stream_INVERSE_FUNCTIONAL=new RewriteRuleTokenStream(adaptor,"token INVERSE_FUNCTIONAL");
        RewriteRuleTokenStream stream_IRREFLEXIVE=new RewriteRuleTokenStream(adaptor,"token IRREFLEXIVE");

        try {
            // MOWLParser.g:113:21: ( FUNCTIONAL -> ^( FUNCTIONAL ) | INVERSE_FUNCTIONAL -> ^( INVERSE_FUNCTIONAL ) | SYMMETRIC -> ^( SYMMETRIC ) | ANTI_SYMMETRIC -> ^( ANTI_SYMMETRIC ) | REFLEXIVE -> ^( REFLEXIVE ) | IRREFLEXIVE -> ^( IRREFLEXIVE ) | TRANSITIVE -> ^( TRANSITIVE ) )
            int alt6=7;
            switch ( input.LA(1) ) {
            case FUNCTIONAL:
                {
                alt6=1;
                }
                break;
            case INVERSE_FUNCTIONAL:
                {
                alt6=2;
                }
                break;
            case SYMMETRIC:
                {
                alt6=3;
                }
                break;
            case ANTI_SYMMETRIC:
                {
                alt6=4;
                }
                break;
            case REFLEXIVE:
                {
                alt6=5;
                }
                break;
            case IRREFLEXIVE:
                {
                alt6=6;
                }
                break;
            case TRANSITIVE:
                {
                alt6=7;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }

            switch (alt6) {
                case 1 :
                    // MOWLParser.g:114:5: FUNCTIONAL
                    {
                    FUNCTIONAL31=(Token)match(input,FUNCTIONAL,FOLLOW_FUNCTIONAL_in_unaryCharacteristic1016); if (state.failed) return retval; 
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

                    root_0 = (ManchesterOWLSyntaxTree)adaptor.nil();
                    // 114:16: -> ^( FUNCTIONAL )
                    {
                        // MOWLParser.g:114:19: ^( FUNCTIONAL )
                        {
                        ManchesterOWLSyntaxTree root_1 = (ManchesterOWLSyntaxTree)adaptor.nil();
                        root_1 = (ManchesterOWLSyntaxTree)adaptor.becomeRoot(stream_FUNCTIONAL.nextNode(), root_1);

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 2 :
                    // MOWLParser.g:115:7: INVERSE_FUNCTIONAL
                    {
                    INVERSE_FUNCTIONAL32=(Token)match(input,INVERSE_FUNCTIONAL,FOLLOW_INVERSE_FUNCTIONAL_in_unaryCharacteristic1030); if (state.failed) return retval; 
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

                    root_0 = (ManchesterOWLSyntaxTree)adaptor.nil();
                    // 115:26: -> ^( INVERSE_FUNCTIONAL )
                    {
                        // MOWLParser.g:115:29: ^( INVERSE_FUNCTIONAL )
                        {
                        ManchesterOWLSyntaxTree root_1 = (ManchesterOWLSyntaxTree)adaptor.nil();
                        root_1 = (ManchesterOWLSyntaxTree)adaptor.becomeRoot(stream_INVERSE_FUNCTIONAL.nextNode(), root_1);

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 3 :
                    // MOWLParser.g:116:7: SYMMETRIC
                    {
                    SYMMETRIC33=(Token)match(input,SYMMETRIC,FOLLOW_SYMMETRIC_in_unaryCharacteristic1044); if (state.failed) return retval; 
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

                    root_0 = (ManchesterOWLSyntaxTree)adaptor.nil();
                    // 116:17: -> ^( SYMMETRIC )
                    {
                        // MOWLParser.g:116:20: ^( SYMMETRIC )
                        {
                        ManchesterOWLSyntaxTree root_1 = (ManchesterOWLSyntaxTree)adaptor.nil();
                        root_1 = (ManchesterOWLSyntaxTree)adaptor.becomeRoot(stream_SYMMETRIC.nextNode(), root_1);

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 4 :
                    // MOWLParser.g:117:7: ANTI_SYMMETRIC
                    {
                    ANTI_SYMMETRIC34=(Token)match(input,ANTI_SYMMETRIC,FOLLOW_ANTI_SYMMETRIC_in_unaryCharacteristic1058); if (state.failed) return retval; 
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

                    root_0 = (ManchesterOWLSyntaxTree)adaptor.nil();
                    // 117:22: -> ^( ANTI_SYMMETRIC )
                    {
                        // MOWLParser.g:117:25: ^( ANTI_SYMMETRIC )
                        {
                        ManchesterOWLSyntaxTree root_1 = (ManchesterOWLSyntaxTree)adaptor.nil();
                        root_1 = (ManchesterOWLSyntaxTree)adaptor.becomeRoot(stream_ANTI_SYMMETRIC.nextNode(), root_1);

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 5 :
                    // MOWLParser.g:118:7: REFLEXIVE
                    {
                    REFLEXIVE35=(Token)match(input,REFLEXIVE,FOLLOW_REFLEXIVE_in_unaryCharacteristic1072); if (state.failed) return retval; 
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

                    root_0 = (ManchesterOWLSyntaxTree)adaptor.nil();
                    // 118:17: -> ^( REFLEXIVE )
                    {
                        // MOWLParser.g:118:20: ^( REFLEXIVE )
                        {
                        ManchesterOWLSyntaxTree root_1 = (ManchesterOWLSyntaxTree)adaptor.nil();
                        root_1 = (ManchesterOWLSyntaxTree)adaptor.becomeRoot(stream_REFLEXIVE.nextNode(), root_1);

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 6 :
                    // MOWLParser.g:119:7: IRREFLEXIVE
                    {
                    IRREFLEXIVE36=(Token)match(input,IRREFLEXIVE,FOLLOW_IRREFLEXIVE_in_unaryCharacteristic1086); if (state.failed) return retval; 
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

                    root_0 = (ManchesterOWLSyntaxTree)adaptor.nil();
                    // 119:19: -> ^( IRREFLEXIVE )
                    {
                        // MOWLParser.g:119:22: ^( IRREFLEXIVE )
                        {
                        ManchesterOWLSyntaxTree root_1 = (ManchesterOWLSyntaxTree)adaptor.nil();
                        root_1 = (ManchesterOWLSyntaxTree)adaptor.becomeRoot(stream_IRREFLEXIVE.nextNode(), root_1);

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 7 :
                    // MOWLParser.g:120:7: TRANSITIVE
                    {
                    TRANSITIVE37=(Token)match(input,TRANSITIVE,FOLLOW_TRANSITIVE_in_unaryCharacteristic1100); if (state.failed) return retval; 
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

                    root_0 = (ManchesterOWLSyntaxTree)adaptor.nil();
                    // 120:18: -> ^( TRANSITIVE )
                    {
                        // MOWLParser.g:120:21: ^( TRANSITIVE )
                        {
                        ManchesterOWLSyntaxTree root_1 = (ManchesterOWLSyntaxTree)adaptor.nil();
                        root_1 = (ManchesterOWLSyntaxTree)adaptor.becomeRoot(stream_TRANSITIVE.nextNode(), root_1);

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (ManchesterOWLSyntaxTree)adaptor.rulePostProcessing(root_0);
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
        ManchesterOWLSyntaxTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "expression"
    // MOWLParser.g:123:1: expression : ( options {backtrack=true; } : conjunction ( OR conjunction )* -> ^( DISJUNCTION ( conjunction )+ ) | complexPropertyExpression -> ^( complexPropertyExpression ) | OPEN_PARENTHESYS expression CLOSED_PARENTHESYS -> ^( expression ) ) ;
    public final ManchesterOWLSyntax_MOWLParser.expression_return expression() throws RecognitionException {
        ManchesterOWLSyntax_MOWLParser.expression_return retval = new ManchesterOWLSyntax_MOWLParser.expression_return();
        retval.start = input.LT(1);

        ManchesterOWLSyntaxTree root_0 = null;

        Token OR39=null;
        Token OPEN_PARENTHESYS42=null;
        Token CLOSED_PARENTHESYS44=null;
        ManchesterOWLSyntax_MOWLParser.conjunction_return conjunction38 = null;

        ManchesterOWLSyntax_MOWLParser.conjunction_return conjunction40 = null;

        ManchesterOWLSyntax_MOWLParser.complexPropertyExpression_return complexPropertyExpression41 = null;

        ManchesterOWLSyntax_MOWLParser.expression_return expression43 = null;


        ManchesterOWLSyntaxTree OR39_tree=null;
        ManchesterOWLSyntaxTree OPEN_PARENTHESYS42_tree=null;
        ManchesterOWLSyntaxTree CLOSED_PARENTHESYS44_tree=null;
        RewriteRuleTokenStream stream_CLOSED_PARENTHESYS=new RewriteRuleTokenStream(adaptor,"token CLOSED_PARENTHESYS");
        RewriteRuleTokenStream stream_OR=new RewriteRuleTokenStream(adaptor,"token OR");
        RewriteRuleTokenStream stream_OPEN_PARENTHESYS=new RewriteRuleTokenStream(adaptor,"token OPEN_PARENTHESYS");
        RewriteRuleSubtreeStream stream_expression=new RewriteRuleSubtreeStream(adaptor,"rule expression");
        RewriteRuleSubtreeStream stream_conjunction=new RewriteRuleSubtreeStream(adaptor,"rule conjunction");
        RewriteRuleSubtreeStream stream_complexPropertyExpression=new RewriteRuleSubtreeStream(adaptor,"rule complexPropertyExpression");
        try {
            // MOWLParser.g:123:11: ( ( options {backtrack=true; } : conjunction ( OR conjunction )* -> ^( DISJUNCTION ( conjunction )+ ) | complexPropertyExpression -> ^( complexPropertyExpression ) | OPEN_PARENTHESYS expression CLOSED_PARENTHESYS -> ^( expression ) ) )
            // MOWLParser.g:124:5: ( options {backtrack=true; } : conjunction ( OR conjunction )* -> ^( DISJUNCTION ( conjunction )+ ) | complexPropertyExpression -> ^( complexPropertyExpression ) | OPEN_PARENTHESYS expression CLOSED_PARENTHESYS -> ^( expression ) )
            {
            // MOWLParser.g:124:5: ( options {backtrack=true; } : conjunction ( OR conjunction )* -> ^( DISJUNCTION ( conjunction )+ ) | complexPropertyExpression -> ^( complexPropertyExpression ) | OPEN_PARENTHESYS expression CLOSED_PARENTHESYS -> ^( expression ) )
            int alt8=3;
            switch ( input.LA(1) ) {
            case OPEN_CURLY_BRACES:
            case NOT:
            case DBLQUOTE:
            case IDENTIFIER:
            case ENTITY_REFERENCE:
                {
                alt8=1;
                }
                break;
            case INVERSE:
                {
                int LA8_3 = input.LA(2);

                if ( (synpred15_MOWLParser()) ) {
                    alt8=1;
                }
                else if ( (synpred16_MOWLParser()) ) {
                    alt8=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 8, 3, input);

                    throw nvae;
                }
                }
                break;
            case OPEN_PARENTHESYS:
                {
                alt8=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }

            switch (alt8) {
                case 1 :
                    // MOWLParser.g:126:5: conjunction ( OR conjunction )*
                    {
                    pushFollow(FOLLOW_conjunction_in_expression1142);
                    conjunction38=conjunction();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_conjunction.add(conjunction38.getTree());
                    // MOWLParser.g:126:17: ( OR conjunction )*
                    loop7:
                    do {
                        int alt7=2;
                        int LA7_0 = input.LA(1);

                        if ( (LA7_0==OR) ) {
                            alt7=1;
                        }


                        switch (alt7) {
                    	case 1 :
                    	    // MOWLParser.g:126:18: OR conjunction
                    	    {
                    	    OR39=(Token)match(input,OR,FOLLOW_OR_in_expression1145); if (state.failed) return retval; 
                    	    if ( state.backtracking==0 ) stream_OR.add(OR39);

                    	    pushFollow(FOLLOW_conjunction_in_expression1147);
                    	    conjunction40=conjunction();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) stream_conjunction.add(conjunction40.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop7;
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

                    root_0 = (ManchesterOWLSyntaxTree)adaptor.nil();
                    // 126:35: -> ^( DISJUNCTION ( conjunction )+ )
                    {
                        // MOWLParser.g:126:38: ^( DISJUNCTION ( conjunction )+ )
                        {
                        ManchesterOWLSyntaxTree root_1 = (ManchesterOWLSyntaxTree)adaptor.nil();
                        root_1 = (ManchesterOWLSyntaxTree)adaptor.becomeRoot((ManchesterOWLSyntaxTree)adaptor.create(DISJUNCTION, "DISJUNCTION"), root_1);

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
                    // MOWLParser.g:127:6: complexPropertyExpression
                    {
                    pushFollow(FOLLOW_complexPropertyExpression_in_expression1166);
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

                    root_0 = (ManchesterOWLSyntaxTree)adaptor.nil();
                    // 127:32: -> ^( complexPropertyExpression )
                    {
                        // MOWLParser.g:127:35: ^( complexPropertyExpression )
                        {
                        ManchesterOWLSyntaxTree root_1 = (ManchesterOWLSyntaxTree)adaptor.nil();
                        root_1 = (ManchesterOWLSyntaxTree)adaptor.becomeRoot(stream_complexPropertyExpression.nextNode(), root_1);

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 3 :
                    // MOWLParser.g:128:6: OPEN_PARENTHESYS expression CLOSED_PARENTHESYS
                    {
                    OPEN_PARENTHESYS42=(Token)match(input,OPEN_PARENTHESYS,FOLLOW_OPEN_PARENTHESYS_in_expression1179); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_OPEN_PARENTHESYS.add(OPEN_PARENTHESYS42);

                    pushFollow(FOLLOW_expression_in_expression1181);
                    expression43=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_expression.add(expression43.getTree());
                    CLOSED_PARENTHESYS44=(Token)match(input,CLOSED_PARENTHESYS,FOLLOW_CLOSED_PARENTHESYS_in_expression1183); if (state.failed) return retval; 
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

                    root_0 = (ManchesterOWLSyntaxTree)adaptor.nil();
                    // 128:53: -> ^( expression )
                    {
                        // MOWLParser.g:128:56: ^( expression )
                        {
                        ManchesterOWLSyntaxTree root_1 = (ManchesterOWLSyntaxTree)adaptor.nil();
                        root_1 = (ManchesterOWLSyntaxTree)adaptor.becomeRoot(stream_expression.nextNode(), root_1);

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

            retval.tree = (ManchesterOWLSyntaxTree)adaptor.rulePostProcessing(root_0);
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
        ManchesterOWLSyntaxTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "conjunction"
    // MOWLParser.g:136:1: conjunction : unary ( AND unary )* -> ^( CONJUNCTION ( unary )+ ) ;
    public final ManchesterOWLSyntax_MOWLParser.conjunction_return conjunction() throws RecognitionException {
        ManchesterOWLSyntax_MOWLParser.conjunction_return retval = new ManchesterOWLSyntax_MOWLParser.conjunction_return();
        retval.start = input.LT(1);

        ManchesterOWLSyntaxTree root_0 = null;

        Token AND46=null;
        ManchesterOWLSyntax_MOWLParser.unary_return unary45 = null;

        ManchesterOWLSyntax_MOWLParser.unary_return unary47 = null;


        ManchesterOWLSyntaxTree AND46_tree=null;
        RewriteRuleTokenStream stream_AND=new RewriteRuleTokenStream(adaptor,"token AND");
        RewriteRuleSubtreeStream stream_unary=new RewriteRuleSubtreeStream(adaptor,"rule unary");
        try {
            // MOWLParser.g:136:13: ( unary ( AND unary )* -> ^( CONJUNCTION ( unary )+ ) )
            // MOWLParser.g:137:5: unary ( AND unary )*
            {
            pushFollow(FOLLOW_unary_in_conjunction1216);
            unary45=unary();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_unary.add(unary45.getTree());
            // MOWLParser.g:137:11: ( AND unary )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==AND) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // MOWLParser.g:137:12: AND unary
            	    {
            	    AND46=(Token)match(input,AND,FOLLOW_AND_in_conjunction1219); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_AND.add(AND46);

            	    pushFollow(FOLLOW_unary_in_conjunction1221);
            	    unary47=unary();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_unary.add(unary47.getTree());

            	    }
            	    break;

            	default :
            	    break loop9;
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

            root_0 = (ManchesterOWLSyntaxTree)adaptor.nil();
            // 137:24: -> ^( CONJUNCTION ( unary )+ )
            {
                // MOWLParser.g:137:27: ^( CONJUNCTION ( unary )+ )
                {
                ManchesterOWLSyntaxTree root_1 = (ManchesterOWLSyntaxTree)adaptor.nil();
                root_1 = (ManchesterOWLSyntaxTree)adaptor.becomeRoot((ManchesterOWLSyntaxTree)adaptor.create(CONJUNCTION, "CONJUNCTION"), root_1);

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

            retval.tree = (ManchesterOWLSyntaxTree)adaptor.rulePostProcessing(root_0);
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
        ManchesterOWLSyntaxTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "complexPropertyExpression"
    // MOWLParser.g:140:1: complexPropertyExpression : ( INVERSE OPEN_PARENTHESYS complexPropertyExpression CLOSED_PARENTHESYS -> ^( INVERSE_OBJECT_PROPERTY_EXPRESSION complexPropertyExpression ) | INVERSE OPEN_PARENTHESYS atomic CLOSED_PARENTHESYS -> ^( INVERSE_OBJECT_PROPERTY_EXPRESSION atomic ) );
    public final ManchesterOWLSyntax_MOWLParser.complexPropertyExpression_return complexPropertyExpression() throws RecognitionException {
        ManchesterOWLSyntax_MOWLParser.complexPropertyExpression_return retval = new ManchesterOWLSyntax_MOWLParser.complexPropertyExpression_return();
        retval.start = input.LT(1);

        ManchesterOWLSyntaxTree root_0 = null;

        Token INVERSE48=null;
        Token OPEN_PARENTHESYS49=null;
        Token CLOSED_PARENTHESYS51=null;
        Token INVERSE52=null;
        Token OPEN_PARENTHESYS53=null;
        Token CLOSED_PARENTHESYS55=null;
        ManchesterOWLSyntax_MOWLParser.complexPropertyExpression_return complexPropertyExpression50 = null;

        ManchesterOWLSyntax_MOWLParser.atomic_return atomic54 = null;


        ManchesterOWLSyntaxTree INVERSE48_tree=null;
        ManchesterOWLSyntaxTree OPEN_PARENTHESYS49_tree=null;
        ManchesterOWLSyntaxTree CLOSED_PARENTHESYS51_tree=null;
        ManchesterOWLSyntaxTree INVERSE52_tree=null;
        ManchesterOWLSyntaxTree OPEN_PARENTHESYS53_tree=null;
        ManchesterOWLSyntaxTree CLOSED_PARENTHESYS55_tree=null;
        RewriteRuleTokenStream stream_INVERSE=new RewriteRuleTokenStream(adaptor,"token INVERSE");
        RewriteRuleTokenStream stream_CLOSED_PARENTHESYS=new RewriteRuleTokenStream(adaptor,"token CLOSED_PARENTHESYS");
        RewriteRuleTokenStream stream_OPEN_PARENTHESYS=new RewriteRuleTokenStream(adaptor,"token OPEN_PARENTHESYS");
        RewriteRuleSubtreeStream stream_complexPropertyExpression=new RewriteRuleSubtreeStream(adaptor,"rule complexPropertyExpression");
        RewriteRuleSubtreeStream stream_atomic=new RewriteRuleSubtreeStream(adaptor,"rule atomic");
        try {
            // MOWLParser.g:140:26: ( INVERSE OPEN_PARENTHESYS complexPropertyExpression CLOSED_PARENTHESYS -> ^( INVERSE_OBJECT_PROPERTY_EXPRESSION complexPropertyExpression ) | INVERSE OPEN_PARENTHESYS atomic CLOSED_PARENTHESYS -> ^( INVERSE_OBJECT_PROPERTY_EXPRESSION atomic ) )
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==INVERSE) ) {
                int LA10_1 = input.LA(2);

                if ( (LA10_1==OPEN_PARENTHESYS) ) {
                    int LA10_2 = input.LA(3);

                    if ( (LA10_2==INVERSE) ) {
                        alt10=1;
                    }
                    else if ( ((LA10_2>=IDENTIFIER && LA10_2<=ENTITY_REFERENCE)) ) {
                        alt10=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 10, 2, input);

                        throw nvae;
                    }
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 10, 1, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }
            switch (alt10) {
                case 1 :
                    // MOWLParser.g:141:2: INVERSE OPEN_PARENTHESYS complexPropertyExpression CLOSED_PARENTHESYS
                    {
                    INVERSE48=(Token)match(input,INVERSE,FOLLOW_INVERSE_in_complexPropertyExpression1242); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_INVERSE.add(INVERSE48);

                    OPEN_PARENTHESYS49=(Token)match(input,OPEN_PARENTHESYS,FOLLOW_OPEN_PARENTHESYS_in_complexPropertyExpression1244); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_OPEN_PARENTHESYS.add(OPEN_PARENTHESYS49);

                    pushFollow(FOLLOW_complexPropertyExpression_in_complexPropertyExpression1246);
                    complexPropertyExpression50=complexPropertyExpression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_complexPropertyExpression.add(complexPropertyExpression50.getTree());
                    CLOSED_PARENTHESYS51=(Token)match(input,CLOSED_PARENTHESYS,FOLLOW_CLOSED_PARENTHESYS_in_complexPropertyExpression1248); if (state.failed) return retval; 
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

                    root_0 = (ManchesterOWLSyntaxTree)adaptor.nil();
                    // 141:72: -> ^( INVERSE_OBJECT_PROPERTY_EXPRESSION complexPropertyExpression )
                    {
                        // MOWLParser.g:141:75: ^( INVERSE_OBJECT_PROPERTY_EXPRESSION complexPropertyExpression )
                        {
                        ManchesterOWLSyntaxTree root_1 = (ManchesterOWLSyntaxTree)adaptor.nil();
                        root_1 = (ManchesterOWLSyntaxTree)adaptor.becomeRoot((ManchesterOWLSyntaxTree)adaptor.create(INVERSE_OBJECT_PROPERTY_EXPRESSION, "INVERSE_OBJECT_PROPERTY_EXPRESSION"), root_1);

                        adaptor.addChild(root_1, stream_complexPropertyExpression.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 2 :
                    // MOWLParser.g:142:4: INVERSE OPEN_PARENTHESYS atomic CLOSED_PARENTHESYS
                    {
                    INVERSE52=(Token)match(input,INVERSE,FOLLOW_INVERSE_in_complexPropertyExpression1261); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_INVERSE.add(INVERSE52);

                    OPEN_PARENTHESYS53=(Token)match(input,OPEN_PARENTHESYS,FOLLOW_OPEN_PARENTHESYS_in_complexPropertyExpression1263); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_OPEN_PARENTHESYS.add(OPEN_PARENTHESYS53);

                    pushFollow(FOLLOW_atomic_in_complexPropertyExpression1265);
                    atomic54=atomic();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_atomic.add(atomic54.getTree());
                    CLOSED_PARENTHESYS55=(Token)match(input,CLOSED_PARENTHESYS,FOLLOW_CLOSED_PARENTHESYS_in_complexPropertyExpression1267); if (state.failed) return retval; 
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

                    root_0 = (ManchesterOWLSyntaxTree)adaptor.nil();
                    // 142:54: -> ^( INVERSE_OBJECT_PROPERTY_EXPRESSION atomic )
                    {
                        // MOWLParser.g:142:57: ^( INVERSE_OBJECT_PROPERTY_EXPRESSION atomic )
                        {
                        ManchesterOWLSyntaxTree root_1 = (ManchesterOWLSyntaxTree)adaptor.nil();
                        root_1 = (ManchesterOWLSyntaxTree)adaptor.becomeRoot((ManchesterOWLSyntaxTree)adaptor.create(INVERSE_OBJECT_PROPERTY_EXPRESSION, "INVERSE_OBJECT_PROPERTY_EXPRESSION"), root_1);

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

            retval.tree = (ManchesterOWLSyntaxTree)adaptor.rulePostProcessing(root_0);
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
        ManchesterOWLSyntaxTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "unary"
    // MOWLParser.g:145:1: unary options {backtrack=true; } : (head= propertyExpression ( COMPOSITION rest+= propertyExpression )+ -> ^( PROPERTY_CHAIN $head $rest) | NOT OPEN_PARENTHESYS expression CLOSED_PARENTHESYS -> ^( NEGATED_EXPRESSION expression ) | NOT atomic -> ^( NEGATED_EXPRESSION atomic ) | qualifiedRestriction -> ^( qualifiedRestriction ) | dataRange | constant | atomic );
    public final ManchesterOWLSyntax_MOWLParser.unary_return unary() throws RecognitionException {
        ManchesterOWLSyntax_MOWLParser.unary_return retval = new ManchesterOWLSyntax_MOWLParser.unary_return();
        retval.start = input.LT(1);

        ManchesterOWLSyntaxTree root_0 = null;

        Token COMPOSITION56=null;
        Token NOT57=null;
        Token OPEN_PARENTHESYS58=null;
        Token CLOSED_PARENTHESYS60=null;
        Token NOT61=null;
        List list_rest=null;
        ManchesterOWLSyntax_MOWLParser.propertyExpression_return head = null;

        ManchesterOWLSyntax_MOWLParser.expression_return expression59 = null;

        ManchesterOWLSyntax_MOWLParser.atomic_return atomic62 = null;

        ManchesterOWLSyntax_MOWLParser.qualifiedRestriction_return qualifiedRestriction63 = null;

        ManchesterOWLSyntax_MOWLParser.dataRange_return dataRange64 = null;

        ManchesterOWLSyntax_MOWLParser.constant_return constant65 = null;

        ManchesterOWLSyntax_MOWLParser.atomic_return atomic66 = null;

        RuleReturnScope rest = null;
        ManchesterOWLSyntaxTree COMPOSITION56_tree=null;
        ManchesterOWLSyntaxTree NOT57_tree=null;
        ManchesterOWLSyntaxTree OPEN_PARENTHESYS58_tree=null;
        ManchesterOWLSyntaxTree CLOSED_PARENTHESYS60_tree=null;
        ManchesterOWLSyntaxTree NOT61_tree=null;
        RewriteRuleTokenStream stream_NOT=new RewriteRuleTokenStream(adaptor,"token NOT");
        RewriteRuleTokenStream stream_CLOSED_PARENTHESYS=new RewriteRuleTokenStream(adaptor,"token CLOSED_PARENTHESYS");
        RewriteRuleTokenStream stream_COMPOSITION=new RewriteRuleTokenStream(adaptor,"token COMPOSITION");
        RewriteRuleTokenStream stream_OPEN_PARENTHESYS=new RewriteRuleTokenStream(adaptor,"token OPEN_PARENTHESYS");
        RewriteRuleSubtreeStream stream_expression=new RewriteRuleSubtreeStream(adaptor,"rule expression");
        RewriteRuleSubtreeStream stream_qualifiedRestriction=new RewriteRuleSubtreeStream(adaptor,"rule qualifiedRestriction");
        RewriteRuleSubtreeStream stream_propertyExpression=new RewriteRuleSubtreeStream(adaptor,"rule propertyExpression");
        RewriteRuleSubtreeStream stream_atomic=new RewriteRuleSubtreeStream(adaptor,"rule atomic");
        try {
            // MOWLParser.g:145:34: (head= propertyExpression ( COMPOSITION rest+= propertyExpression )+ -> ^( PROPERTY_CHAIN $head $rest) | NOT OPEN_PARENTHESYS expression CLOSED_PARENTHESYS -> ^( NEGATED_EXPRESSION expression ) | NOT atomic -> ^( NEGATED_EXPRESSION atomic ) | qualifiedRestriction -> ^( qualifiedRestriction ) | dataRange | constant | atomic )
            int alt12=7;
            alt12 = dfa12.predict(input);
            switch (alt12) {
                case 1 :
                    // MOWLParser.g:147:4: head= propertyExpression ( COMPOSITION rest+= propertyExpression )+
                    {
                    pushFollow(FOLLOW_propertyExpression_in_unary1304);
                    head=propertyExpression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_propertyExpression.add(head.getTree());
                    // MOWLParser.g:147:30: ( COMPOSITION rest+= propertyExpression )+
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
                    	    // MOWLParser.g:147:31: COMPOSITION rest+= propertyExpression
                    	    {
                    	    COMPOSITION56=(Token)match(input,COMPOSITION,FOLLOW_COMPOSITION_in_unary1307); if (state.failed) return retval; 
                    	    if ( state.backtracking==0 ) stream_COMPOSITION.add(COMPOSITION56);

                    	    pushFollow(FOLLOW_propertyExpression_in_unary1311);
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
                    // elements: head, rest
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
                    root_0 = (ManchesterOWLSyntaxTree)adaptor.nil();
                    // 147:71: -> ^( PROPERTY_CHAIN $head $rest)
                    {
                        // MOWLParser.g:147:74: ^( PROPERTY_CHAIN $head $rest)
                        {
                        ManchesterOWLSyntaxTree root_1 = (ManchesterOWLSyntaxTree)adaptor.nil();
                        root_1 = (ManchesterOWLSyntaxTree)adaptor.becomeRoot((ManchesterOWLSyntaxTree)adaptor.create(PROPERTY_CHAIN, "PROPERTY_CHAIN"), root_1);

                        adaptor.addChild(root_1, stream_head.nextTree());
                        adaptor.addChild(root_1, stream_rest.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 2 :
                    // MOWLParser.g:148:5: NOT OPEN_PARENTHESYS expression CLOSED_PARENTHESYS
                    {
                    NOT57=(Token)match(input,NOT,FOLLOW_NOT_in_unary1333); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_NOT.add(NOT57);

                    OPEN_PARENTHESYS58=(Token)match(input,OPEN_PARENTHESYS,FOLLOW_OPEN_PARENTHESYS_in_unary1335); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_OPEN_PARENTHESYS.add(OPEN_PARENTHESYS58);

                    pushFollow(FOLLOW_expression_in_unary1337);
                    expression59=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_expression.add(expression59.getTree());
                    CLOSED_PARENTHESYS60=(Token)match(input,CLOSED_PARENTHESYS,FOLLOW_CLOSED_PARENTHESYS_in_unary1339); if (state.failed) return retval; 
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

                    root_0 = (ManchesterOWLSyntaxTree)adaptor.nil();
                    // 148:56: -> ^( NEGATED_EXPRESSION expression )
                    {
                        // MOWLParser.g:148:59: ^( NEGATED_EXPRESSION expression )
                        {
                        ManchesterOWLSyntaxTree root_1 = (ManchesterOWLSyntaxTree)adaptor.nil();
                        root_1 = (ManchesterOWLSyntaxTree)adaptor.becomeRoot((ManchesterOWLSyntaxTree)adaptor.create(NEGATED_EXPRESSION, "NEGATED_EXPRESSION"), root_1);

                        adaptor.addChild(root_1, stream_expression.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 3 :
                    // MOWLParser.g:149:5: NOT atomic
                    {
                    NOT61=(Token)match(input,NOT,FOLLOW_NOT_in_unary1353); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_NOT.add(NOT61);

                    pushFollow(FOLLOW_atomic_in_unary1355);
                    atomic62=atomic();

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

                    root_0 = (ManchesterOWLSyntaxTree)adaptor.nil();
                    // 149:16: -> ^( NEGATED_EXPRESSION atomic )
                    {
                        // MOWLParser.g:149:19: ^( NEGATED_EXPRESSION atomic )
                        {
                        ManchesterOWLSyntaxTree root_1 = (ManchesterOWLSyntaxTree)adaptor.nil();
                        root_1 = (ManchesterOWLSyntaxTree)adaptor.becomeRoot((ManchesterOWLSyntaxTree)adaptor.create(NEGATED_EXPRESSION, "NEGATED_EXPRESSION"), root_1);

                        adaptor.addChild(root_1, stream_atomic.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 4 :
                    // MOWLParser.g:150:5: qualifiedRestriction
                    {
                    pushFollow(FOLLOW_qualifiedRestriction_in_unary1378);
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

                    root_0 = (ManchesterOWLSyntaxTree)adaptor.nil();
                    // 150:26: -> ^( qualifiedRestriction )
                    {
                        // MOWLParser.g:150:29: ^( qualifiedRestriction )
                        {
                        ManchesterOWLSyntaxTree root_1 = (ManchesterOWLSyntaxTree)adaptor.nil();
                        root_1 = (ManchesterOWLSyntaxTree)adaptor.becomeRoot(stream_qualifiedRestriction.nextNode(), root_1);

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 5 :
                    // MOWLParser.g:151:5: dataRange
                    {
                    root_0 = (ManchesterOWLSyntaxTree)adaptor.nil();

                    pushFollow(FOLLOW_dataRange_in_unary1390);
                    dataRange64=dataRange();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, dataRange64.getTree());

                    }
                    break;
                case 6 :
                    // MOWLParser.g:152:5: constant
                    {
                    root_0 = (ManchesterOWLSyntaxTree)adaptor.nil();

                    pushFollow(FOLLOW_constant_in_unary1396);
                    constant65=constant();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, constant65.getTree());

                    }
                    break;
                case 7 :
                    // MOWLParser.g:153:5: atomic
                    {
                    root_0 = (ManchesterOWLSyntaxTree)adaptor.nil();

                    pushFollow(FOLLOW_atomic_in_unary1402);
                    atomic66=atomic();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, atomic66.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (ManchesterOWLSyntaxTree)adaptor.rulePostProcessing(root_0);
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
        ManchesterOWLSyntaxTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "dataRange"
    // MOWLParser.g:157:1: dataRange : IDENTIFIER OPEN_SQUARE_BRACKET dataRangeFacet ( COMMA dataRangeFacet )* CLOSED_SQUARE_BRACKET -> ^( DATA_RANGE IDENTIFIER ( dataRangeFacet )+ ) ;
    public final ManchesterOWLSyntax_MOWLParser.dataRange_return dataRange() throws RecognitionException {
        ManchesterOWLSyntax_MOWLParser.dataRange_return retval = new ManchesterOWLSyntax_MOWLParser.dataRange_return();
        retval.start = input.LT(1);

        ManchesterOWLSyntaxTree root_0 = null;

        Token IDENTIFIER67=null;
        Token OPEN_SQUARE_BRACKET68=null;
        Token COMMA70=null;
        Token CLOSED_SQUARE_BRACKET72=null;
        ManchesterOWLSyntax_MOWLParser.dataRangeFacet_return dataRangeFacet69 = null;

        ManchesterOWLSyntax_MOWLParser.dataRangeFacet_return dataRangeFacet71 = null;


        ManchesterOWLSyntaxTree IDENTIFIER67_tree=null;
        ManchesterOWLSyntaxTree OPEN_SQUARE_BRACKET68_tree=null;
        ManchesterOWLSyntaxTree COMMA70_tree=null;
        ManchesterOWLSyntaxTree CLOSED_SQUARE_BRACKET72_tree=null;
        RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
        RewriteRuleTokenStream stream_OPEN_SQUARE_BRACKET=new RewriteRuleTokenStream(adaptor,"token OPEN_SQUARE_BRACKET");
        RewriteRuleTokenStream stream_IDENTIFIER=new RewriteRuleTokenStream(adaptor,"token IDENTIFIER");
        RewriteRuleTokenStream stream_CLOSED_SQUARE_BRACKET=new RewriteRuleTokenStream(adaptor,"token CLOSED_SQUARE_BRACKET");
        RewriteRuleSubtreeStream stream_dataRangeFacet=new RewriteRuleSubtreeStream(adaptor,"rule dataRangeFacet");
        try {
            // MOWLParser.g:158:2: ( IDENTIFIER OPEN_SQUARE_BRACKET dataRangeFacet ( COMMA dataRangeFacet )* CLOSED_SQUARE_BRACKET -> ^( DATA_RANGE IDENTIFIER ( dataRangeFacet )+ ) )
            // MOWLParser.g:159:4: IDENTIFIER OPEN_SQUARE_BRACKET dataRangeFacet ( COMMA dataRangeFacet )* CLOSED_SQUARE_BRACKET
            {
            IDENTIFIER67=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_dataRange1419); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_IDENTIFIER.add(IDENTIFIER67);

            OPEN_SQUARE_BRACKET68=(Token)match(input,OPEN_SQUARE_BRACKET,FOLLOW_OPEN_SQUARE_BRACKET_in_dataRange1421); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_OPEN_SQUARE_BRACKET.add(OPEN_SQUARE_BRACKET68);

            pushFollow(FOLLOW_dataRangeFacet_in_dataRange1423);
            dataRangeFacet69=dataRangeFacet();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_dataRangeFacet.add(dataRangeFacet69.getTree());
            // MOWLParser.g:159:50: ( COMMA dataRangeFacet )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==COMMA) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // MOWLParser.g:159:51: COMMA dataRangeFacet
            	    {
            	    COMMA70=(Token)match(input,COMMA,FOLLOW_COMMA_in_dataRange1426); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_COMMA.add(COMMA70);

            	    pushFollow(FOLLOW_dataRangeFacet_in_dataRange1428);
            	    dataRangeFacet71=dataRangeFacet();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_dataRangeFacet.add(dataRangeFacet71.getTree());

            	    }
            	    break;

            	default :
            	    break loop13;
                }
            } while (true);

            CLOSED_SQUARE_BRACKET72=(Token)match(input,CLOSED_SQUARE_BRACKET,FOLLOW_CLOSED_SQUARE_BRACKET_in_dataRange1432); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_CLOSED_SQUARE_BRACKET.add(CLOSED_SQUARE_BRACKET72);



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

            root_0 = (ManchesterOWLSyntaxTree)adaptor.nil();
            // 159:96: -> ^( DATA_RANGE IDENTIFIER ( dataRangeFacet )+ )
            {
                // MOWLParser.g:159:99: ^( DATA_RANGE IDENTIFIER ( dataRangeFacet )+ )
                {
                ManchesterOWLSyntaxTree root_1 = (ManchesterOWLSyntaxTree)adaptor.nil();
                root_1 = (ManchesterOWLSyntaxTree)adaptor.becomeRoot((ManchesterOWLSyntaxTree)adaptor.create(DATA_RANGE, "DATA_RANGE"), root_1);

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

            retval.tree = (ManchesterOWLSyntaxTree)adaptor.rulePostProcessing(root_0);
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
        ManchesterOWLSyntaxTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "dataRangeFacet"
    // MOWLParser.g:162:1: dataRangeFacet : ( LESS_THAN constant -> ^( LESS_THAN constant ) | LESS_THAN_EQUAL constant -> ^( LESS_THAN_EQUAL constant ) | GREATER_THAN constant -> ^( GREATER_THAN constant ) | GREATER_THAN_EQUAL constant -> ^( GREATER_THAN_EQUAL constant ) );
    public final ManchesterOWLSyntax_MOWLParser.dataRangeFacet_return dataRangeFacet() throws RecognitionException {
        ManchesterOWLSyntax_MOWLParser.dataRangeFacet_return retval = new ManchesterOWLSyntax_MOWLParser.dataRangeFacet_return();
        retval.start = input.LT(1);

        ManchesterOWLSyntaxTree root_0 = null;

        Token LESS_THAN73=null;
        Token LESS_THAN_EQUAL75=null;
        Token GREATER_THAN77=null;
        Token GREATER_THAN_EQUAL79=null;
        ManchesterOWLSyntax_MOWLParser.constant_return constant74 = null;

        ManchesterOWLSyntax_MOWLParser.constant_return constant76 = null;

        ManchesterOWLSyntax_MOWLParser.constant_return constant78 = null;

        ManchesterOWLSyntax_MOWLParser.constant_return constant80 = null;


        ManchesterOWLSyntaxTree LESS_THAN73_tree=null;
        ManchesterOWLSyntaxTree LESS_THAN_EQUAL75_tree=null;
        ManchesterOWLSyntaxTree GREATER_THAN77_tree=null;
        ManchesterOWLSyntaxTree GREATER_THAN_EQUAL79_tree=null;
        RewriteRuleTokenStream stream_LESS_THAN_EQUAL=new RewriteRuleTokenStream(adaptor,"token LESS_THAN_EQUAL");
        RewriteRuleTokenStream stream_GREATER_THAN_EQUAL=new RewriteRuleTokenStream(adaptor,"token GREATER_THAN_EQUAL");
        RewriteRuleTokenStream stream_GREATER_THAN=new RewriteRuleTokenStream(adaptor,"token GREATER_THAN");
        RewriteRuleTokenStream stream_LESS_THAN=new RewriteRuleTokenStream(adaptor,"token LESS_THAN");
        RewriteRuleSubtreeStream stream_constant=new RewriteRuleSubtreeStream(adaptor,"rule constant");
        try {
            // MOWLParser.g:163:2: ( LESS_THAN constant -> ^( LESS_THAN constant ) | LESS_THAN_EQUAL constant -> ^( LESS_THAN_EQUAL constant ) | GREATER_THAN constant -> ^( GREATER_THAN constant ) | GREATER_THAN_EQUAL constant -> ^( GREATER_THAN_EQUAL constant ) )
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
                    // MOWLParser.g:164:3: LESS_THAN constant
                    {
                    LESS_THAN73=(Token)match(input,LESS_THAN,FOLLOW_LESS_THAN_in_dataRangeFacet1458); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_LESS_THAN.add(LESS_THAN73);

                    pushFollow(FOLLOW_constant_in_dataRangeFacet1460);
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

                    root_0 = (ManchesterOWLSyntaxTree)adaptor.nil();
                    // 164:22: -> ^( LESS_THAN constant )
                    {
                        // MOWLParser.g:164:25: ^( LESS_THAN constant )
                        {
                        ManchesterOWLSyntaxTree root_1 = (ManchesterOWLSyntaxTree)adaptor.nil();
                        root_1 = (ManchesterOWLSyntaxTree)adaptor.becomeRoot(stream_LESS_THAN.nextNode(), root_1);

                        adaptor.addChild(root_1, stream_constant.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 2 :
                    // MOWLParser.g:165:5: LESS_THAN_EQUAL constant
                    {
                    LESS_THAN_EQUAL75=(Token)match(input,LESS_THAN_EQUAL,FOLLOW_LESS_THAN_EQUAL_in_dataRangeFacet1474); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_LESS_THAN_EQUAL.add(LESS_THAN_EQUAL75);

                    pushFollow(FOLLOW_constant_in_dataRangeFacet1476);
                    constant76=constant();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_constant.add(constant76.getTree());


                    // AST REWRITE
                    // elements: constant, LESS_THAN_EQUAL
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (ManchesterOWLSyntaxTree)adaptor.nil();
                    // 165:31: -> ^( LESS_THAN_EQUAL constant )
                    {
                        // MOWLParser.g:165:34: ^( LESS_THAN_EQUAL constant )
                        {
                        ManchesterOWLSyntaxTree root_1 = (ManchesterOWLSyntaxTree)adaptor.nil();
                        root_1 = (ManchesterOWLSyntaxTree)adaptor.becomeRoot(stream_LESS_THAN_EQUAL.nextNode(), root_1);

                        adaptor.addChild(root_1, stream_constant.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 3 :
                    // MOWLParser.g:166:5: GREATER_THAN constant
                    {
                    GREATER_THAN77=(Token)match(input,GREATER_THAN,FOLLOW_GREATER_THAN_in_dataRangeFacet1491); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_GREATER_THAN.add(GREATER_THAN77);

                    pushFollow(FOLLOW_constant_in_dataRangeFacet1493);
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

                    root_0 = (ManchesterOWLSyntaxTree)adaptor.nil();
                    // 166:27: -> ^( GREATER_THAN constant )
                    {
                        // MOWLParser.g:166:30: ^( GREATER_THAN constant )
                        {
                        ManchesterOWLSyntaxTree root_1 = (ManchesterOWLSyntaxTree)adaptor.nil();
                        root_1 = (ManchesterOWLSyntaxTree)adaptor.becomeRoot(stream_GREATER_THAN.nextNode(), root_1);

                        adaptor.addChild(root_1, stream_constant.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 4 :
                    // MOWLParser.g:167:5: GREATER_THAN_EQUAL constant
                    {
                    GREATER_THAN_EQUAL79=(Token)match(input,GREATER_THAN_EQUAL,FOLLOW_GREATER_THAN_EQUAL_in_dataRangeFacet1507); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_GREATER_THAN_EQUAL.add(GREATER_THAN_EQUAL79);

                    pushFollow(FOLLOW_constant_in_dataRangeFacet1509);
                    constant80=constant();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_constant.add(constant80.getTree());


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

                    root_0 = (ManchesterOWLSyntaxTree)adaptor.nil();
                    // 167:33: -> ^( GREATER_THAN_EQUAL constant )
                    {
                        // MOWLParser.g:167:36: ^( GREATER_THAN_EQUAL constant )
                        {
                        ManchesterOWLSyntaxTree root_1 = (ManchesterOWLSyntaxTree)adaptor.nil();
                        root_1 = (ManchesterOWLSyntaxTree)adaptor.becomeRoot(stream_GREATER_THAN_EQUAL.nextNode(), root_1);

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

            retval.tree = (ManchesterOWLSyntaxTree)adaptor.rulePostProcessing(root_0);
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

    public static class atomic_return extends ParserRuleReturnScope {
        ManchesterOWLSyntaxTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "atomic"
    // MOWLParser.g:170:1: atomic : ( IDENTIFIER | ENTITY_REFERENCE -> ^( ENTITY_REFERENCE ) );
    public final ManchesterOWLSyntax_MOWLParser.atomic_return atomic() throws RecognitionException {
        ManchesterOWLSyntax_MOWLParser.atomic_return retval = new ManchesterOWLSyntax_MOWLParser.atomic_return();
        retval.start = input.LT(1);

        ManchesterOWLSyntaxTree root_0 = null;

        Token IDENTIFIER81=null;
        Token ENTITY_REFERENCE82=null;

        ManchesterOWLSyntaxTree IDENTIFIER81_tree=null;
        ManchesterOWLSyntaxTree ENTITY_REFERENCE82_tree=null;
        RewriteRuleTokenStream stream_ENTITY_REFERENCE=new RewriteRuleTokenStream(adaptor,"token ENTITY_REFERENCE");

        try {
            // MOWLParser.g:170:8: ( IDENTIFIER | ENTITY_REFERENCE -> ^( ENTITY_REFERENCE ) )
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==IDENTIFIER) ) {
                alt15=1;
            }
            else if ( (LA15_0==ENTITY_REFERENCE) ) {
                alt15=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 15, 0, input);

                throw nvae;
            }
            switch (alt15) {
                case 1 :
                    // MOWLParser.g:171:3: IDENTIFIER
                    {
                    root_0 = (ManchesterOWLSyntaxTree)adaptor.nil();

                    IDENTIFIER81=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_atomic1530); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDENTIFIER81_tree = (ManchesterOWLSyntaxTree)adaptor.create(IDENTIFIER81);
                    adaptor.addChild(root_0, IDENTIFIER81_tree);
                    }

                    }
                    break;
                case 2 :
                    // MOWLParser.g:172:5: ENTITY_REFERENCE
                    {
                    ENTITY_REFERENCE82=(Token)match(input,ENTITY_REFERENCE,FOLLOW_ENTITY_REFERENCE_in_atomic1537); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_ENTITY_REFERENCE.add(ENTITY_REFERENCE82);



                    // AST REWRITE
                    // elements: ENTITY_REFERENCE
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (ManchesterOWLSyntaxTree)adaptor.nil();
                    // 172:22: -> ^( ENTITY_REFERENCE )
                    {
                        // MOWLParser.g:172:25: ^( ENTITY_REFERENCE )
                        {
                        ManchesterOWLSyntaxTree root_1 = (ManchesterOWLSyntaxTree)adaptor.nil();
                        root_1 = (ManchesterOWLSyntaxTree)adaptor.becomeRoot(stream_ENTITY_REFERENCE.nextNode(), root_1);

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (ManchesterOWLSyntaxTree)adaptor.rulePostProcessing(root_0);
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
    // $ANTLR end "atomic"

    public static class qualifiedRestriction_return extends ParserRuleReturnScope {
        ManchesterOWLSyntaxTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "qualifiedRestriction"
    // MOWLParser.g:175:1: qualifiedRestriction : ( options {backtrack=true; } : propertyExpression SOME expression -> ^( SOME_RESTRICTION propertyExpression expression ) | propertyExpression ONLY expression -> ^( ALL_RESTRICTION propertyExpression expression ) | cardinalityRestriction -> ^( cardinalityRestriction ) | oneOf -> ^( oneOf ) | valueRestriction -> ^( valueRestriction ) ) ;
    public final ManchesterOWLSyntax_MOWLParser.qualifiedRestriction_return qualifiedRestriction() throws RecognitionException {
        ManchesterOWLSyntax_MOWLParser.qualifiedRestriction_return retval = new ManchesterOWLSyntax_MOWLParser.qualifiedRestriction_return();
        retval.start = input.LT(1);

        ManchesterOWLSyntaxTree root_0 = null;

        Token SOME84=null;
        Token ONLY87=null;
        ManchesterOWLSyntax_MOWLParser.propertyExpression_return propertyExpression83 = null;

        ManchesterOWLSyntax_MOWLParser.expression_return expression85 = null;

        ManchesterOWLSyntax_MOWLParser.propertyExpression_return propertyExpression86 = null;

        ManchesterOWLSyntax_MOWLParser.expression_return expression88 = null;

        ManchesterOWLSyntax_MOWLParser.cardinalityRestriction_return cardinalityRestriction89 = null;

        ManchesterOWLSyntax_MOWLParser.oneOf_return oneOf90 = null;

        ManchesterOWLSyntax_MOWLParser.valueRestriction_return valueRestriction91 = null;


        ManchesterOWLSyntaxTree SOME84_tree=null;
        ManchesterOWLSyntaxTree ONLY87_tree=null;
        RewriteRuleTokenStream stream_ONLY=new RewriteRuleTokenStream(adaptor,"token ONLY");
        RewriteRuleTokenStream stream_SOME=new RewriteRuleTokenStream(adaptor,"token SOME");
        RewriteRuleSubtreeStream stream_expression=new RewriteRuleSubtreeStream(adaptor,"rule expression");
        RewriteRuleSubtreeStream stream_oneOf=new RewriteRuleSubtreeStream(adaptor,"rule oneOf");
        RewriteRuleSubtreeStream stream_propertyExpression=new RewriteRuleSubtreeStream(adaptor,"rule propertyExpression");
        RewriteRuleSubtreeStream stream_cardinalityRestriction=new RewriteRuleSubtreeStream(adaptor,"rule cardinalityRestriction");
        RewriteRuleSubtreeStream stream_valueRestriction=new RewriteRuleSubtreeStream(adaptor,"rule valueRestriction");
        try {
            // MOWLParser.g:175:21: ( ( options {backtrack=true; } : propertyExpression SOME expression -> ^( SOME_RESTRICTION propertyExpression expression ) | propertyExpression ONLY expression -> ^( ALL_RESTRICTION propertyExpression expression ) | cardinalityRestriction -> ^( cardinalityRestriction ) | oneOf -> ^( oneOf ) | valueRestriction -> ^( valueRestriction ) ) )
            // MOWLParser.g:176:9: ( options {backtrack=true; } : propertyExpression SOME expression -> ^( SOME_RESTRICTION propertyExpression expression ) | propertyExpression ONLY expression -> ^( ALL_RESTRICTION propertyExpression expression ) | cardinalityRestriction -> ^( cardinalityRestriction ) | oneOf -> ^( oneOf ) | valueRestriction -> ^( valueRestriction ) )
            {
            // MOWLParser.g:176:9: ( options {backtrack=true; } : propertyExpression SOME expression -> ^( SOME_RESTRICTION propertyExpression expression ) | propertyExpression ONLY expression -> ^( ALL_RESTRICTION propertyExpression expression ) | cardinalityRestriction -> ^( cardinalityRestriction ) | oneOf -> ^( oneOf ) | valueRestriction -> ^( valueRestriction ) )
            int alt16=5;
            switch ( input.LA(1) ) {
            case IDENTIFIER:
                {
                int LA16_1 = input.LA(2);

                if ( (synpred23_MOWLParser()) ) {
                    alt16=1;
                }
                else if ( (synpred24_MOWLParser()) ) {
                    alt16=2;
                }
                else if ( (synpred25_MOWLParser()) ) {
                    alt16=3;
                }
                else if ( (true) ) {
                    alt16=5;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 16, 1, input);

                    throw nvae;
                }
                }
                break;
            case ENTITY_REFERENCE:
                {
                int LA16_2 = input.LA(2);

                if ( (synpred23_MOWLParser()) ) {
                    alt16=1;
                }
                else if ( (synpred24_MOWLParser()) ) {
                    alt16=2;
                }
                else if ( (synpred25_MOWLParser()) ) {
                    alt16=3;
                }
                else if ( (true) ) {
                    alt16=5;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 16, 2, input);

                    throw nvae;
                }
                }
                break;
            case INVERSE:
                {
                int LA16_3 = input.LA(2);

                if ( (synpred23_MOWLParser()) ) {
                    alt16=1;
                }
                else if ( (synpred24_MOWLParser()) ) {
                    alt16=2;
                }
                else if ( (synpred25_MOWLParser()) ) {
                    alt16=3;
                }
                else if ( (true) ) {
                    alt16=5;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 16, 3, input);

                    throw nvae;
                }
                }
                break;
            case OPEN_CURLY_BRACES:
                {
                alt16=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 16, 0, input);

                throw nvae;
            }

            switch (alt16) {
                case 1 :
                    // MOWLParser.g:178:7: propertyExpression SOME expression
                    {
                    pushFollow(FOLLOW_propertyExpression_in_qualifiedRestriction1589);
                    propertyExpression83=propertyExpression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_propertyExpression.add(propertyExpression83.getTree());
                    SOME84=(Token)match(input,SOME,FOLLOW_SOME_in_qualifiedRestriction1592); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_SOME.add(SOME84);

                    pushFollow(FOLLOW_expression_in_qualifiedRestriction1596);
                    expression85=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_expression.add(expression85.getTree());


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

                    root_0 = (ManchesterOWLSyntaxTree)adaptor.nil();
                    // 178:46: -> ^( SOME_RESTRICTION propertyExpression expression )
                    {
                        // MOWLParser.g:178:49: ^( SOME_RESTRICTION propertyExpression expression )
                        {
                        ManchesterOWLSyntaxTree root_1 = (ManchesterOWLSyntaxTree)adaptor.nil();
                        root_1 = (ManchesterOWLSyntaxTree)adaptor.becomeRoot((ManchesterOWLSyntaxTree)adaptor.create(SOME_RESTRICTION, "SOME_RESTRICTION"), root_1);

                        adaptor.addChild(root_1, stream_propertyExpression.nextTree());
                        adaptor.addChild(root_1, stream_expression.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 2 :
                    // MOWLParser.g:179:7: propertyExpression ONLY expression
                    {
                    pushFollow(FOLLOW_propertyExpression_in_qualifiedRestriction1625);
                    propertyExpression86=propertyExpression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_propertyExpression.add(propertyExpression86.getTree());
                    ONLY87=(Token)match(input,ONLY,FOLLOW_ONLY_in_qualifiedRestriction1627); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_ONLY.add(ONLY87);

                    pushFollow(FOLLOW_expression_in_qualifiedRestriction1630);
                    expression88=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_expression.add(expression88.getTree());


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

                    root_0 = (ManchesterOWLSyntaxTree)adaptor.nil();
                    // 179:44: -> ^( ALL_RESTRICTION propertyExpression expression )
                    {
                        // MOWLParser.g:179:47: ^( ALL_RESTRICTION propertyExpression expression )
                        {
                        ManchesterOWLSyntaxTree root_1 = (ManchesterOWLSyntaxTree)adaptor.nil();
                        root_1 = (ManchesterOWLSyntaxTree)adaptor.becomeRoot((ManchesterOWLSyntaxTree)adaptor.create(ALL_RESTRICTION, "ALL_RESTRICTION"), root_1);

                        adaptor.addChild(root_1, stream_propertyExpression.nextTree());
                        adaptor.addChild(root_1, stream_expression.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 3 :
                    // MOWLParser.g:180:7: cardinalityRestriction
                    {
                    pushFollow(FOLLOW_cardinalityRestriction_in_qualifiedRestriction1649);
                    cardinalityRestriction89=cardinalityRestriction();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_cardinalityRestriction.add(cardinalityRestriction89.getTree());


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

                    root_0 = (ManchesterOWLSyntaxTree)adaptor.nil();
                    // 180:30: -> ^( cardinalityRestriction )
                    {
                        // MOWLParser.g:180:33: ^( cardinalityRestriction )
                        {
                        ManchesterOWLSyntaxTree root_1 = (ManchesterOWLSyntaxTree)adaptor.nil();
                        root_1 = (ManchesterOWLSyntaxTree)adaptor.becomeRoot(stream_cardinalityRestriction.nextNode(), root_1);

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 4 :
                    // MOWLParser.g:181:7: oneOf
                    {
                    pushFollow(FOLLOW_oneOf_in_qualifiedRestriction1663);
                    oneOf90=oneOf();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_oneOf.add(oneOf90.getTree());


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

                    root_0 = (ManchesterOWLSyntaxTree)adaptor.nil();
                    // 181:13: -> ^( oneOf )
                    {
                        // MOWLParser.g:181:16: ^( oneOf )
                        {
                        ManchesterOWLSyntaxTree root_1 = (ManchesterOWLSyntaxTree)adaptor.nil();
                        root_1 = (ManchesterOWLSyntaxTree)adaptor.becomeRoot(stream_oneOf.nextNode(), root_1);

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 5 :
                    // MOWLParser.g:182:7: valueRestriction
                    {
                    pushFollow(FOLLOW_valueRestriction_in_qualifiedRestriction1677);
                    valueRestriction91=valueRestriction();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_valueRestriction.add(valueRestriction91.getTree());


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

                    root_0 = (ManchesterOWLSyntaxTree)adaptor.nil();
                    // 182:24: -> ^( valueRestriction )
                    {
                        // MOWLParser.g:182:27: ^( valueRestriction )
                        {
                        ManchesterOWLSyntaxTree root_1 = (ManchesterOWLSyntaxTree)adaptor.nil();
                        root_1 = (ManchesterOWLSyntaxTree)adaptor.becomeRoot(stream_valueRestriction.nextNode(), root_1);

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

            retval.tree = (ManchesterOWLSyntaxTree)adaptor.rulePostProcessing(root_0);
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
        ManchesterOWLSyntaxTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "propertyExpression"
    // MOWLParser.g:186:1: propertyExpression : ( atomic -> ^( atomic ) | complexPropertyExpression -> ^( complexPropertyExpression ) );
    public final ManchesterOWLSyntax_MOWLParser.propertyExpression_return propertyExpression() throws RecognitionException {
        ManchesterOWLSyntax_MOWLParser.propertyExpression_return retval = new ManchesterOWLSyntax_MOWLParser.propertyExpression_return();
        retval.start = input.LT(1);

        ManchesterOWLSyntaxTree root_0 = null;

        ManchesterOWLSyntax_MOWLParser.atomic_return atomic92 = null;

        ManchesterOWLSyntax_MOWLParser.complexPropertyExpression_return complexPropertyExpression93 = null;


        RewriteRuleSubtreeStream stream_complexPropertyExpression=new RewriteRuleSubtreeStream(adaptor,"rule complexPropertyExpression");
        RewriteRuleSubtreeStream stream_atomic=new RewriteRuleSubtreeStream(adaptor,"rule atomic");
        try {
            // MOWLParser.g:186:21: ( atomic -> ^( atomic ) | complexPropertyExpression -> ^( complexPropertyExpression ) )
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( ((LA17_0>=IDENTIFIER && LA17_0<=ENTITY_REFERENCE)) ) {
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
                    // MOWLParser.g:187:7: atomic
                    {
                    pushFollow(FOLLOW_atomic_in_propertyExpression1709);
                    atomic92=atomic();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_atomic.add(atomic92.getTree());


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

                    root_0 = (ManchesterOWLSyntaxTree)adaptor.nil();
                    // 187:14: -> ^( atomic )
                    {
                        // MOWLParser.g:187:17: ^( atomic )
                        {
                        ManchesterOWLSyntaxTree root_1 = (ManchesterOWLSyntaxTree)adaptor.nil();
                        root_1 = (ManchesterOWLSyntaxTree)adaptor.becomeRoot(stream_atomic.nextNode(), root_1);

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 2 :
                    // MOWLParser.g:188:7: complexPropertyExpression
                    {
                    pushFollow(FOLLOW_complexPropertyExpression_in_propertyExpression1723);
                    complexPropertyExpression93=complexPropertyExpression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_complexPropertyExpression.add(complexPropertyExpression93.getTree());


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

                    root_0 = (ManchesterOWLSyntaxTree)adaptor.nil();
                    // 188:33: -> ^( complexPropertyExpression )
                    {
                        // MOWLParser.g:188:36: ^( complexPropertyExpression )
                        {
                        ManchesterOWLSyntaxTree root_1 = (ManchesterOWLSyntaxTree)adaptor.nil();
                        root_1 = (ManchesterOWLSyntaxTree)adaptor.becomeRoot(stream_complexPropertyExpression.nextNode(), root_1);

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (ManchesterOWLSyntaxTree)adaptor.rulePostProcessing(root_0);
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
        ManchesterOWLSyntaxTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "cardinalityRestriction"
    // MOWLParser.g:191:1: cardinalityRestriction options {backtrack=true; } : propertyExpression restrictionKind INTEGER ( unary )? -> ^( CARDINALITY_RESTRICTION restrictionKind INTEGER propertyExpression ( unary )? ) ;
    public final ManchesterOWLSyntax_MOWLParser.cardinalityRestriction_return cardinalityRestriction() throws RecognitionException {
        ManchesterOWLSyntax_MOWLParser.cardinalityRestriction_return retval = new ManchesterOWLSyntax_MOWLParser.cardinalityRestriction_return();
        retval.start = input.LT(1);

        ManchesterOWLSyntaxTree root_0 = null;

        Token INTEGER96=null;
        ManchesterOWLSyntax_MOWLParser.propertyExpression_return propertyExpression94 = null;

        ManchesterOWLSyntax_MOWLParser.restrictionKind_return restrictionKind95 = null;

        ManchesterOWLSyntax_MOWLParser.unary_return unary97 = null;


        ManchesterOWLSyntaxTree INTEGER96_tree=null;
        RewriteRuleTokenStream stream_INTEGER=new RewriteRuleTokenStream(adaptor,"token INTEGER");
        RewriteRuleSubtreeStream stream_unary=new RewriteRuleSubtreeStream(adaptor,"rule unary");
        RewriteRuleSubtreeStream stream_propertyExpression=new RewriteRuleSubtreeStream(adaptor,"rule propertyExpression");
        RewriteRuleSubtreeStream stream_restrictionKind=new RewriteRuleSubtreeStream(adaptor,"rule restrictionKind");
        try {
            // MOWLParser.g:192:28: ( propertyExpression restrictionKind INTEGER ( unary )? -> ^( CARDINALITY_RESTRICTION restrictionKind INTEGER propertyExpression ( unary )? ) )
            // MOWLParser.g:193:2: propertyExpression restrictionKind INTEGER ( unary )?
            {
            pushFollow(FOLLOW_propertyExpression_in_cardinalityRestriction1765);
            propertyExpression94=propertyExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_propertyExpression.add(propertyExpression94.getTree());
            pushFollow(FOLLOW_restrictionKind_in_cardinalityRestriction1768);
            restrictionKind95=restrictionKind();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_restrictionKind.add(restrictionKind95.getTree());
            INTEGER96=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_cardinalityRestriction1770); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_INTEGER.add(INTEGER96);

            // MOWLParser.g:193:46: ( unary )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==OPEN_CURLY_BRACES||LA18_0==NOT||LA18_0==INVERSE||LA18_0==DBLQUOTE||(LA18_0>=IDENTIFIER && LA18_0<=ENTITY_REFERENCE)) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // MOWLParser.g:193:46: unary
                    {
                    pushFollow(FOLLOW_unary_in_cardinalityRestriction1772);
                    unary97=unary();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_unary.add(unary97.getTree());

                    }
                    break;

            }



            // AST REWRITE
            // elements: restrictionKind, INTEGER, propertyExpression, unary
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (ManchesterOWLSyntaxTree)adaptor.nil();
            // 193:53: -> ^( CARDINALITY_RESTRICTION restrictionKind INTEGER propertyExpression ( unary )? )
            {
                // MOWLParser.g:193:56: ^( CARDINALITY_RESTRICTION restrictionKind INTEGER propertyExpression ( unary )? )
                {
                ManchesterOWLSyntaxTree root_1 = (ManchesterOWLSyntaxTree)adaptor.nil();
                root_1 = (ManchesterOWLSyntaxTree)adaptor.becomeRoot((ManchesterOWLSyntaxTree)adaptor.create(CARDINALITY_RESTRICTION, "CARDINALITY_RESTRICTION"), root_1);

                adaptor.addChild(root_1, stream_restrictionKind.nextTree());
                adaptor.addChild(root_1, stream_INTEGER.nextNode());
                adaptor.addChild(root_1, stream_propertyExpression.nextTree());
                // MOWLParser.g:193:127: ( unary )?
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

            retval.tree = (ManchesterOWLSyntaxTree)adaptor.rulePostProcessing(root_0);
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
        ManchesterOWLSyntaxTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "restrictionKind"
    // MOWLParser.g:196:1: restrictionKind : ( MIN -> ^( MIN ) | MAX -> ^( MAX ) | EXACTLY -> ^( EXACTLY ) );
    public final ManchesterOWLSyntax_MOWLParser.restrictionKind_return restrictionKind() throws RecognitionException {
        ManchesterOWLSyntax_MOWLParser.restrictionKind_return retval = new ManchesterOWLSyntax_MOWLParser.restrictionKind_return();
        retval.start = input.LT(1);

        ManchesterOWLSyntaxTree root_0 = null;

        Token MIN98=null;
        Token MAX99=null;
        Token EXACTLY100=null;

        ManchesterOWLSyntaxTree MIN98_tree=null;
        ManchesterOWLSyntaxTree MAX99_tree=null;
        ManchesterOWLSyntaxTree EXACTLY100_tree=null;
        RewriteRuleTokenStream stream_MAX=new RewriteRuleTokenStream(adaptor,"token MAX");
        RewriteRuleTokenStream stream_MIN=new RewriteRuleTokenStream(adaptor,"token MIN");
        RewriteRuleTokenStream stream_EXACTLY=new RewriteRuleTokenStream(adaptor,"token EXACTLY");

        try {
            // MOWLParser.g:196:17: ( MIN -> ^( MIN ) | MAX -> ^( MAX ) | EXACTLY -> ^( EXACTLY ) )
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
                    // MOWLParser.g:197:5: MIN
                    {
                    MIN98=(Token)match(input,MIN,FOLLOW_MIN_in_restrictionKind1805); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_MIN.add(MIN98);



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

                    root_0 = (ManchesterOWLSyntaxTree)adaptor.nil();
                    // 197:9: -> ^( MIN )
                    {
                        // MOWLParser.g:197:12: ^( MIN )
                        {
                        ManchesterOWLSyntaxTree root_1 = (ManchesterOWLSyntaxTree)adaptor.nil();
                        root_1 = (ManchesterOWLSyntaxTree)adaptor.becomeRoot(stream_MIN.nextNode(), root_1);

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 2 :
                    // MOWLParser.g:198:7: MAX
                    {
                    MAX99=(Token)match(input,MAX,FOLLOW_MAX_in_restrictionKind1819); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_MAX.add(MAX99);



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

                    root_0 = (ManchesterOWLSyntaxTree)adaptor.nil();
                    // 198:11: -> ^( MAX )
                    {
                        // MOWLParser.g:198:14: ^( MAX )
                        {
                        ManchesterOWLSyntaxTree root_1 = (ManchesterOWLSyntaxTree)adaptor.nil();
                        root_1 = (ManchesterOWLSyntaxTree)adaptor.becomeRoot(stream_MAX.nextNode(), root_1);

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 3 :
                    // MOWLParser.g:199:7: EXACTLY
                    {
                    EXACTLY100=(Token)match(input,EXACTLY,FOLLOW_EXACTLY_in_restrictionKind1833); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_EXACTLY.add(EXACTLY100);



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

                    root_0 = (ManchesterOWLSyntaxTree)adaptor.nil();
                    // 199:15: -> ^( EXACTLY )
                    {
                        // MOWLParser.g:199:18: ^( EXACTLY )
                        {
                        ManchesterOWLSyntaxTree root_1 = (ManchesterOWLSyntaxTree)adaptor.nil();
                        root_1 = (ManchesterOWLSyntaxTree)adaptor.becomeRoot(stream_EXACTLY.nextNode(), root_1);

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (ManchesterOWLSyntaxTree)adaptor.rulePostProcessing(root_0);
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
        ManchesterOWLSyntaxTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "oneOf"
    // MOWLParser.g:203:1: oneOf : OPEN_CURLY_BRACES IDENTIFIER ( COMMA IDENTIFIER )* CLOSED_CURLY_BRACES -> ^( ONE_OF ( IDENTIFIER )+ ) ;
    public final ManchesterOWLSyntax_MOWLParser.oneOf_return oneOf() throws RecognitionException {
        ManchesterOWLSyntax_MOWLParser.oneOf_return retval = new ManchesterOWLSyntax_MOWLParser.oneOf_return();
        retval.start = input.LT(1);

        ManchesterOWLSyntaxTree root_0 = null;

        Token OPEN_CURLY_BRACES101=null;
        Token IDENTIFIER102=null;
        Token COMMA103=null;
        Token IDENTIFIER104=null;
        Token CLOSED_CURLY_BRACES105=null;

        ManchesterOWLSyntaxTree OPEN_CURLY_BRACES101_tree=null;
        ManchesterOWLSyntaxTree IDENTIFIER102_tree=null;
        ManchesterOWLSyntaxTree COMMA103_tree=null;
        ManchesterOWLSyntaxTree IDENTIFIER104_tree=null;
        ManchesterOWLSyntaxTree CLOSED_CURLY_BRACES105_tree=null;
        RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
        RewriteRuleTokenStream stream_CLOSED_CURLY_BRACES=new RewriteRuleTokenStream(adaptor,"token CLOSED_CURLY_BRACES");
        RewriteRuleTokenStream stream_IDENTIFIER=new RewriteRuleTokenStream(adaptor,"token IDENTIFIER");
        RewriteRuleTokenStream stream_OPEN_CURLY_BRACES=new RewriteRuleTokenStream(adaptor,"token OPEN_CURLY_BRACES");

        try {
            // MOWLParser.g:203:7: ( OPEN_CURLY_BRACES IDENTIFIER ( COMMA IDENTIFIER )* CLOSED_CURLY_BRACES -> ^( ONE_OF ( IDENTIFIER )+ ) )
            // MOWLParser.g:204:3: OPEN_CURLY_BRACES IDENTIFIER ( COMMA IDENTIFIER )* CLOSED_CURLY_BRACES
            {
            OPEN_CURLY_BRACES101=(Token)match(input,OPEN_CURLY_BRACES,FOLLOW_OPEN_CURLY_BRACES_in_oneOf1855); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_OPEN_CURLY_BRACES.add(OPEN_CURLY_BRACES101);

            IDENTIFIER102=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_oneOf1857); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_IDENTIFIER.add(IDENTIFIER102);

            // MOWLParser.g:204:32: ( COMMA IDENTIFIER )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0==COMMA) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // MOWLParser.g:204:33: COMMA IDENTIFIER
            	    {
            	    COMMA103=(Token)match(input,COMMA,FOLLOW_COMMA_in_oneOf1860); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_COMMA.add(COMMA103);

            	    IDENTIFIER104=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_oneOf1862); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_IDENTIFIER.add(IDENTIFIER104);


            	    }
            	    break;

            	default :
            	    break loop20;
                }
            } while (true);

            CLOSED_CURLY_BRACES105=(Token)match(input,CLOSED_CURLY_BRACES,FOLLOW_CLOSED_CURLY_BRACES_in_oneOf1866); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_CLOSED_CURLY_BRACES.add(CLOSED_CURLY_BRACES105);



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

            root_0 = (ManchesterOWLSyntaxTree)adaptor.nil();
            // 204:72: -> ^( ONE_OF ( IDENTIFIER )+ )
            {
                // MOWLParser.g:204:75: ^( ONE_OF ( IDENTIFIER )+ )
                {
                ManchesterOWLSyntaxTree root_1 = (ManchesterOWLSyntaxTree)adaptor.nil();
                root_1 = (ManchesterOWLSyntaxTree)adaptor.becomeRoot((ManchesterOWLSyntaxTree)adaptor.create(ONE_OF, "ONE_OF"), root_1);

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

            retval.tree = (ManchesterOWLSyntaxTree)adaptor.rulePostProcessing(root_0);
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
        ManchesterOWLSyntaxTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "valueRestriction"
    // MOWLParser.g:207:1: valueRestriction : propertyExpression VALUE value -> ^( VALUE_RESTRICTION propertyExpression value ) ;
    public final ManchesterOWLSyntax_MOWLParser.valueRestriction_return valueRestriction() throws RecognitionException {
        ManchesterOWLSyntax_MOWLParser.valueRestriction_return retval = new ManchesterOWLSyntax_MOWLParser.valueRestriction_return();
        retval.start = input.LT(1);

        ManchesterOWLSyntaxTree root_0 = null;

        Token VALUE107=null;
        ManchesterOWLSyntax_MOWLParser.propertyExpression_return propertyExpression106 = null;

        ManchesterOWLSyntax_MOWLParser.value_return value108 = null;


        ManchesterOWLSyntaxTree VALUE107_tree=null;
        RewriteRuleTokenStream stream_VALUE=new RewriteRuleTokenStream(adaptor,"token VALUE");
        RewriteRuleSubtreeStream stream_propertyExpression=new RewriteRuleSubtreeStream(adaptor,"rule propertyExpression");
        RewriteRuleSubtreeStream stream_value=new RewriteRuleSubtreeStream(adaptor,"rule value");
        try {
            // MOWLParser.g:207:18: ( propertyExpression VALUE value -> ^( VALUE_RESTRICTION propertyExpression value ) )
            // MOWLParser.g:207:20: propertyExpression VALUE value
            {
            pushFollow(FOLLOW_propertyExpression_in_valueRestriction1886);
            propertyExpression106=propertyExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_propertyExpression.add(propertyExpression106.getTree());
            VALUE107=(Token)match(input,VALUE,FOLLOW_VALUE_in_valueRestriction1888); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_VALUE.add(VALUE107);

            pushFollow(FOLLOW_value_in_valueRestriction1890);
            value108=value();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_value.add(value108.getTree());


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

            root_0 = (ManchesterOWLSyntaxTree)adaptor.nil();
            // 207:51: -> ^( VALUE_RESTRICTION propertyExpression value )
            {
                // MOWLParser.g:207:54: ^( VALUE_RESTRICTION propertyExpression value )
                {
                ManchesterOWLSyntaxTree root_1 = (ManchesterOWLSyntaxTree)adaptor.nil();
                root_1 = (ManchesterOWLSyntaxTree)adaptor.becomeRoot((ManchesterOWLSyntaxTree)adaptor.create(VALUE_RESTRICTION, "VALUE_RESTRICTION"), root_1);

                adaptor.addChild(root_1, stream_propertyExpression.nextTree());
                adaptor.addChild(root_1, stream_value.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (ManchesterOWLSyntaxTree)adaptor.rulePostProcessing(root_0);
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
        ManchesterOWLSyntaxTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "value"
    // MOWLParser.g:210:1: value : ( atomic -> ^( atomic ) | constant -> ^( constant ) );
    public final ManchesterOWLSyntax_MOWLParser.value_return value() throws RecognitionException {
        ManchesterOWLSyntax_MOWLParser.value_return retval = new ManchesterOWLSyntax_MOWLParser.value_return();
        retval.start = input.LT(1);

        ManchesterOWLSyntaxTree root_0 = null;

        ManchesterOWLSyntax_MOWLParser.atomic_return atomic109 = null;

        ManchesterOWLSyntax_MOWLParser.constant_return constant110 = null;


        RewriteRuleSubtreeStream stream_constant=new RewriteRuleSubtreeStream(adaptor,"rule constant");
        RewriteRuleSubtreeStream stream_atomic=new RewriteRuleSubtreeStream(adaptor,"rule atomic");
        try {
            // MOWLParser.g:210:6: ( atomic -> ^( atomic ) | constant -> ^( constant ) )
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( ((LA21_0>=IDENTIFIER && LA21_0<=ENTITY_REFERENCE)) ) {
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
                    // MOWLParser.g:211:7: atomic
                    {
                    pushFollow(FOLLOW_atomic_in_value1915);
                    atomic109=atomic();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_atomic.add(atomic109.getTree());


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

                    root_0 = (ManchesterOWLSyntaxTree)adaptor.nil();
                    // 211:14: -> ^( atomic )
                    {
                        // MOWLParser.g:211:17: ^( atomic )
                        {
                        ManchesterOWLSyntaxTree root_1 = (ManchesterOWLSyntaxTree)adaptor.nil();
                        root_1 = (ManchesterOWLSyntaxTree)adaptor.becomeRoot(stream_atomic.nextNode(), root_1);

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 2 :
                    // MOWLParser.g:212:7: constant
                    {
                    pushFollow(FOLLOW_constant_in_value1930);
                    constant110=constant();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_constant.add(constant110.getTree());


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

                    root_0 = (ManchesterOWLSyntaxTree)adaptor.nil();
                    // 212:16: -> ^( constant )
                    {
                        // MOWLParser.g:212:19: ^( constant )
                        {
                        ManchesterOWLSyntaxTree root_1 = (ManchesterOWLSyntaxTree)adaptor.nil();
                        root_1 = (ManchesterOWLSyntaxTree)adaptor.becomeRoot(stream_constant.nextNode(), root_1);

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (ManchesterOWLSyntaxTree)adaptor.rulePostProcessing(root_0);
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
        ManchesterOWLSyntaxTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "constant"
    // MOWLParser.g:215:1: constant : constantValue= DBLQUOTE ( POW type= IDENTIFIER )? -> ^( CONSTANT $constantValue ( $type)? ) ;
    public final ManchesterOWLSyntax_MOWLParser.constant_return constant() throws RecognitionException {
        ManchesterOWLSyntax_MOWLParser.constant_return retval = new ManchesterOWLSyntax_MOWLParser.constant_return();
        retval.start = input.LT(1);

        ManchesterOWLSyntaxTree root_0 = null;

        Token constantValue=null;
        Token type=null;
        Token POW111=null;

        ManchesterOWLSyntaxTree constantValue_tree=null;
        ManchesterOWLSyntaxTree type_tree=null;
        ManchesterOWLSyntaxTree POW111_tree=null;
        RewriteRuleTokenStream stream_POW=new RewriteRuleTokenStream(adaptor,"token POW");
        RewriteRuleTokenStream stream_IDENTIFIER=new RewriteRuleTokenStream(adaptor,"token IDENTIFIER");
        RewriteRuleTokenStream stream_DBLQUOTE=new RewriteRuleTokenStream(adaptor,"token DBLQUOTE");

        try {
            // MOWLParser.g:215:11: (constantValue= DBLQUOTE ( POW type= IDENTIFIER )? -> ^( CONSTANT $constantValue ( $type)? ) )
            // MOWLParser.g:215:14: constantValue= DBLQUOTE ( POW type= IDENTIFIER )?
            {
            constantValue=(Token)match(input,DBLQUOTE,FOLLOW_DBLQUOTE_in_constant1955); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_DBLQUOTE.add(constantValue);

            // MOWLParser.g:215:39: ( POW type= IDENTIFIER )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==POW) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // MOWLParser.g:215:41: POW type= IDENTIFIER
                    {
                    POW111=(Token)match(input,POW,FOLLOW_POW_in_constant1959); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_POW.add(POW111);

                    type=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_constant1965); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_IDENTIFIER.add(type);


                    }
                    break;

            }



            // AST REWRITE
            // elements: constantValue, type
            // token labels: constantValue, type
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleTokenStream stream_constantValue=new RewriteRuleTokenStream(adaptor,"token constantValue",constantValue);
            RewriteRuleTokenStream stream_type=new RewriteRuleTokenStream(adaptor,"token type",type);
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (ManchesterOWLSyntaxTree)adaptor.nil();
            // 215:65: -> ^( CONSTANT $constantValue ( $type)? )
            {
                // MOWLParser.g:215:67: ^( CONSTANT $constantValue ( $type)? )
                {
                ManchesterOWLSyntaxTree root_1 = (ManchesterOWLSyntaxTree)adaptor.nil();
                root_1 = (ManchesterOWLSyntaxTree)adaptor.becomeRoot((ManchesterOWLSyntaxTree)adaptor.create(CONSTANT, "CONSTANT"), root_1);

                adaptor.addChild(root_1, stream_constantValue.nextNode());
                // MOWLParser.g:215:93: ( $type)?
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

            retval.tree = (ManchesterOWLSyntaxTree)adaptor.rulePostProcessing(root_0);
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
        // MOWLParser.g:66:3: ( binaryAxiom )
        // MOWLParser.g:66:3: binaryAxiom
        {
        pushFollow(FOLLOW_binaryAxiom_in_synpred1_MOWLParser241);
        binaryAxiom();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred1_MOWLParser

    // $ANTLR start synpred3_MOWLParser
    public final void synpred3_MOWLParser_fragment() throws RecognitionException {   
        // MOWLParser.g:68:5: ( assertionAxiom )
        // MOWLParser.g:68:5: assertionAxiom
        {
        pushFollow(FOLLOW_assertionAxiom_in_synpred3_MOWLParser265);
        assertionAxiom();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred3_MOWLParser

    // $ANTLR start synpred4_MOWLParser
    public final void synpred4_MOWLParser_fragment() throws RecognitionException {   
        // MOWLParser.g:69:5: ( hasKeyAxiom )
        // MOWLParser.g:69:5: hasKeyAxiom
        {
        pushFollow(FOLLOW_hasKeyAxiom_in_synpred4_MOWLParser277);
        hasKeyAxiom();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred4_MOWLParser

    // $ANTLR start synpred7_MOWLParser
    public final void synpred7_MOWLParser_fragment() throws RecognitionException {   
        ManchesterOWLSyntax_MOWLParser.expression_return lhs = null;

        ManchesterOWLSyntax_MOWLParser.expression_return superClass = null;


        // MOWLParser.g:97:2: (lhs= expression SUBCLASS_OF superClass= expression )
        // MOWLParser.g:97:2: lhs= expression SUBCLASS_OF superClass= expression
        {
        pushFollow(FOLLOW_expression_in_synpred7_MOWLParser534);
        lhs=expression();

        state._fsp--;
        if (state.failed) return ;
        match(input,SUBCLASS_OF,FOLLOW_SUBCLASS_OF_in_synpred7_MOWLParser536); if (state.failed) return ;
        pushFollow(FOLLOW_expression_in_synpred7_MOWLParser543);
        superClass=expression();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred7_MOWLParser

    // $ANTLR start synpred8_MOWLParser
    public final void synpred8_MOWLParser_fragment() throws RecognitionException {   
        ManchesterOWLSyntax_MOWLParser.expression_return lhs = null;

        ManchesterOWLSyntax_MOWLParser.expression_return rhs = null;


        // MOWLParser.g:98:11: (lhs= expression EQUIVALENT_TO rhs= expression )
        // MOWLParser.g:98:11: lhs= expression EQUIVALENT_TO rhs= expression
        {
        pushFollow(FOLLOW_expression_in_synpred8_MOWLParser581);
        lhs=expression();

        state._fsp--;
        if (state.failed) return ;
        match(input,EQUIVALENT_TO,FOLLOW_EQUIVALENT_TO_in_synpred8_MOWLParser583); if (state.failed) return ;
        pushFollow(FOLLOW_expression_in_synpred8_MOWLParser589);
        rhs=expression();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred8_MOWLParser

    // $ANTLR start synpred9_MOWLParser
    public final void synpred9_MOWLParser_fragment() throws RecognitionException {   
        ManchesterOWLSyntax_MOWLParser.expression_return lhs = null;

        ManchesterOWLSyntax_MOWLParser.expression_return disjoint = null;


        // MOWLParser.g:99:11: (lhs= expression DISJOINT_WITH disjoint= expression )
        // MOWLParser.g:99:11: lhs= expression DISJOINT_WITH disjoint= expression
        {
        pushFollow(FOLLOW_expression_in_synpred9_MOWLParser626);
        lhs=expression();

        state._fsp--;
        if (state.failed) return ;
        match(input,DISJOINT_WITH,FOLLOW_DISJOINT_WITH_in_synpred9_MOWLParser628); if (state.failed) return ;
        pushFollow(FOLLOW_expression_in_synpred9_MOWLParser634);
        disjoint=expression();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred9_MOWLParser

    // $ANTLR start synpred10_MOWLParser
    public final void synpred10_MOWLParser_fragment() throws RecognitionException {   
        ManchesterOWLSyntax_MOWLParser.expression_return lhs = null;

        ManchesterOWLSyntax_MOWLParser.propertyExpression_return superProperty = null;


        // MOWLParser.g:100:11: (lhs= expression SUB_PROPERTY_OF superProperty= propertyExpression )
        // MOWLParser.g:100:11: lhs= expression SUB_PROPERTY_OF superProperty= propertyExpression
        {
        pushFollow(FOLLOW_expression_in_synpred10_MOWLParser671);
        lhs=expression();

        state._fsp--;
        if (state.failed) return ;
        match(input,SUB_PROPERTY_OF,FOLLOW_SUB_PROPERTY_OF_in_synpred10_MOWLParser673); if (state.failed) return ;
        pushFollow(FOLLOW_propertyExpression_in_synpred10_MOWLParser679);
        superProperty=propertyExpression();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred10_MOWLParser

    // $ANTLR start synpred11_MOWLParser
    public final void synpred11_MOWLParser_fragment() throws RecognitionException {   
        ManchesterOWLSyntax_MOWLParser.atomic_return lhsID = null;

        ManchesterOWLSyntax_MOWLParser.atomic_return rhsAtomic = null;


        // MOWLParser.g:101:11: (lhsID= atomic INVERSE_OF rhsAtomic= atomic )
        // MOWLParser.g:101:11: lhsID= atomic INVERSE_OF rhsAtomic= atomic
        {
        pushFollow(FOLLOW_atomic_in_synpred11_MOWLParser716);
        lhsID=atomic();

        state._fsp--;
        if (state.failed) return ;
        match(input,INVERSE_OF,FOLLOW_INVERSE_OF_in_synpred11_MOWLParser718); if (state.failed) return ;
        pushFollow(FOLLOW_atomic_in_synpred11_MOWLParser724);
        rhsAtomic=atomic();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred11_MOWLParser

    // $ANTLR start synpred12_MOWLParser
    public final void synpred12_MOWLParser_fragment() throws RecognitionException {   
        ManchesterOWLSyntax_MOWLParser.atomic_return lhsID = null;

        ManchesterOWLSyntax_MOWLParser.atomic_return rhsID = null;


        // MOWLParser.g:102:3: (lhsID= atomic SAME_AS rhsID= atomic )
        // MOWLParser.g:102:3: lhsID= atomic SAME_AS rhsID= atomic
        {
        pushFollow(FOLLOW_atomic_in_synpred12_MOWLParser755);
        lhsID=atomic();

        state._fsp--;
        if (state.failed) return ;
        match(input,SAME_AS,FOLLOW_SAME_AS_in_synpred12_MOWLParser757); if (state.failed) return ;
        pushFollow(FOLLOW_atomic_in_synpred12_MOWLParser764);
        rhsID=atomic();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred12_MOWLParser

    // $ANTLR start synpred13_MOWLParser
    public final void synpred13_MOWLParser_fragment() throws RecognitionException {   
        ManchesterOWLSyntax_MOWLParser.atomic_return lhsID = null;

        ManchesterOWLSyntax_MOWLParser.atomic_return rhsID = null;


        // MOWLParser.g:103:11: (lhsID= atomic DIFFERENT_FROM rhsID= atomic )
        // MOWLParser.g:103:11: lhsID= atomic DIFFERENT_FROM rhsID= atomic
        {
        pushFollow(FOLLOW_atomic_in_synpred13_MOWLParser802);
        lhsID=atomic();

        state._fsp--;
        if (state.failed) return ;
        match(input,DIFFERENT_FROM,FOLLOW_DIFFERENT_FROM_in_synpred13_MOWLParser804); if (state.failed) return ;
        pushFollow(FOLLOW_atomic_in_synpred13_MOWLParser811);
        rhsID=atomic();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred13_MOWLParser

    // $ANTLR start synpred14_MOWLParser
    public final void synpred14_MOWLParser_fragment() throws RecognitionException {   
        ManchesterOWLSyntax_MOWLParser.atomic_return lhsID = null;


        // MOWLParser.g:104:11: (lhsID= atomic DOMAIN expression )
        // MOWLParser.g:104:11: lhsID= atomic DOMAIN expression
        {
        pushFollow(FOLLOW_atomic_in_synpred14_MOWLParser848);
        lhsID=atomic();

        state._fsp--;
        if (state.failed) return ;
        match(input,DOMAIN,FOLLOW_DOMAIN_in_synpred14_MOWLParser851); if (state.failed) return ;
        pushFollow(FOLLOW_expression_in_synpred14_MOWLParser853);
        expression();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred14_MOWLParser

    // $ANTLR start synpred15_MOWLParser
    public final void synpred15_MOWLParser_fragment() throws RecognitionException {   
        // MOWLParser.g:126:5: ( conjunction ( OR conjunction )* )
        // MOWLParser.g:126:5: conjunction ( OR conjunction )*
        {
        pushFollow(FOLLOW_conjunction_in_synpred15_MOWLParser1142);
        conjunction();

        state._fsp--;
        if (state.failed) return ;
        // MOWLParser.g:126:17: ( OR conjunction )*
        loop23:
        do {
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==OR) ) {
                alt23=1;
            }


            switch (alt23) {
        	case 1 :
        	    // MOWLParser.g:126:18: OR conjunction
        	    {
        	    match(input,OR,FOLLOW_OR_in_synpred15_MOWLParser1145); if (state.failed) return ;
        	    pushFollow(FOLLOW_conjunction_in_synpred15_MOWLParser1147);
        	    conjunction();

        	    state._fsp--;
        	    if (state.failed) return ;

        	    }
        	    break;

        	default :
        	    break loop23;
            }
        } while (true);


        }
    }
    // $ANTLR end synpred15_MOWLParser

    // $ANTLR start synpred16_MOWLParser
    public final void synpred16_MOWLParser_fragment() throws RecognitionException {   
        // MOWLParser.g:127:6: ( complexPropertyExpression )
        // MOWLParser.g:127:6: complexPropertyExpression
        {
        pushFollow(FOLLOW_complexPropertyExpression_in_synpred16_MOWLParser1166);
        complexPropertyExpression();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred16_MOWLParser

    // $ANTLR start synpred17_MOWLParser
    public final void synpred17_MOWLParser_fragment() throws RecognitionException {   
        List list_rest=null;
        ManchesterOWLSyntax_MOWLParser.propertyExpression_return head = null;

        RuleReturnScope rest = null;
        // MOWLParser.g:147:4: (head= propertyExpression ( COMPOSITION rest+= propertyExpression )+ )
        // MOWLParser.g:147:4: head= propertyExpression ( COMPOSITION rest+= propertyExpression )+
        {
        pushFollow(FOLLOW_propertyExpression_in_synpred17_MOWLParser1304);
        head=propertyExpression();

        state._fsp--;
        if (state.failed) return ;
        // MOWLParser.g:147:30: ( COMPOSITION rest+= propertyExpression )+
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
        	    // MOWLParser.g:147:31: COMPOSITION rest+= propertyExpression
        	    {
        	    match(input,COMPOSITION,FOLLOW_COMPOSITION_in_synpred17_MOWLParser1307); if (state.failed) return ;
        	    pushFollow(FOLLOW_propertyExpression_in_synpred17_MOWLParser1311);
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
    // $ANTLR end synpred17_MOWLParser

    // $ANTLR start synpred18_MOWLParser
    public final void synpred18_MOWLParser_fragment() throws RecognitionException {   
        // MOWLParser.g:148:5: ( NOT OPEN_PARENTHESYS expression CLOSED_PARENTHESYS )
        // MOWLParser.g:148:5: NOT OPEN_PARENTHESYS expression CLOSED_PARENTHESYS
        {
        match(input,NOT,FOLLOW_NOT_in_synpred18_MOWLParser1333); if (state.failed) return ;
        match(input,OPEN_PARENTHESYS,FOLLOW_OPEN_PARENTHESYS_in_synpred18_MOWLParser1335); if (state.failed) return ;
        pushFollow(FOLLOW_expression_in_synpred18_MOWLParser1337);
        expression();

        state._fsp--;
        if (state.failed) return ;
        match(input,CLOSED_PARENTHESYS,FOLLOW_CLOSED_PARENTHESYS_in_synpred18_MOWLParser1339); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred18_MOWLParser

    // $ANTLR start synpred19_MOWLParser
    public final void synpred19_MOWLParser_fragment() throws RecognitionException {   
        // MOWLParser.g:149:5: ( NOT atomic )
        // MOWLParser.g:149:5: NOT atomic
        {
        match(input,NOT,FOLLOW_NOT_in_synpred19_MOWLParser1353); if (state.failed) return ;
        pushFollow(FOLLOW_atomic_in_synpred19_MOWLParser1355);
        atomic();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred19_MOWLParser

    // $ANTLR start synpred20_MOWLParser
    public final void synpred20_MOWLParser_fragment() throws RecognitionException {   
        // MOWLParser.g:150:5: ( qualifiedRestriction )
        // MOWLParser.g:150:5: qualifiedRestriction
        {
        pushFollow(FOLLOW_qualifiedRestriction_in_synpred20_MOWLParser1378);
        qualifiedRestriction();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred20_MOWLParser

    // $ANTLR start synpred21_MOWLParser
    public final void synpred21_MOWLParser_fragment() throws RecognitionException {   
        // MOWLParser.g:151:5: ( dataRange )
        // MOWLParser.g:151:5: dataRange
        {
        pushFollow(FOLLOW_dataRange_in_synpred21_MOWLParser1390);
        dataRange();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred21_MOWLParser

    // $ANTLR start synpred23_MOWLParser
    public final void synpred23_MOWLParser_fragment() throws RecognitionException {   
        // MOWLParser.g:178:7: ( propertyExpression SOME expression )
        // MOWLParser.g:178:7: propertyExpression SOME expression
        {
        pushFollow(FOLLOW_propertyExpression_in_synpred23_MOWLParser1589);
        propertyExpression();

        state._fsp--;
        if (state.failed) return ;
        match(input,SOME,FOLLOW_SOME_in_synpred23_MOWLParser1592); if (state.failed) return ;
        pushFollow(FOLLOW_expression_in_synpred23_MOWLParser1596);
        expression();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred23_MOWLParser

    // $ANTLR start synpred24_MOWLParser
    public final void synpred24_MOWLParser_fragment() throws RecognitionException {   
        // MOWLParser.g:179:7: ( propertyExpression ONLY expression )
        // MOWLParser.g:179:7: propertyExpression ONLY expression
        {
        pushFollow(FOLLOW_propertyExpression_in_synpred24_MOWLParser1625);
        propertyExpression();

        state._fsp--;
        if (state.failed) return ;
        match(input,ONLY,FOLLOW_ONLY_in_synpred24_MOWLParser1627); if (state.failed) return ;
        pushFollow(FOLLOW_expression_in_synpred24_MOWLParser1630);
        expression();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred24_MOWLParser

    // $ANTLR start synpred25_MOWLParser
    public final void synpred25_MOWLParser_fragment() throws RecognitionException {   
        // MOWLParser.g:180:7: ( cardinalityRestriction )
        // MOWLParser.g:180:7: cardinalityRestriction
        {
        pushFollow(FOLLOW_cardinalityRestriction_in_synpred25_MOWLParser1649);
        cardinalityRestriction();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred25_MOWLParser

    // Delegated rules

    public final boolean synpred23_MOWLParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred23_MOWLParser_fragment(); // can never throw exception
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


    protected DFA1 dfa1 = new DFA1(this);
    protected DFA5 dfa5 = new DFA5(this);
    protected DFA12 dfa12 = new DFA12(this);
    static final String DFA1_eotS =
        "\23\uffff";
    static final String DFA1_eofS =
        "\23\uffff";
    static final String DFA1_minS =
        "\1\5\7\0\13\uffff";
    static final String DFA1_maxS =
        "\1\156\7\0\13\uffff";
    static final String DFA1_acceptS =
        "\10\uffff\1\2\6\uffff\1\5\1\1\1\3\1\4";
    static final String DFA1_specialS =
        "\1\uffff\1\0\1\1\1\2\1\3\1\4\1\5\1\6\13\uffff}>";
    static final String[] DFA1_transitionS = {
            "\1\7\1\5\5\uffff\1\4\6\uffff\1\3\11\uffff\7\10\4\uffff\1\6\3"+
            "\uffff\1\1\1\2\100\uffff\1\17",
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
            return "65:1: axiom options {backtrack=true; } : ( binaryAxiom -> ^( binaryAxiom ) | unaryAxiom -> ^( unaryAxiom ) | assertionAxiom -> ^( assertionAxiom ) | hasKeyAxiom -> ^( hasKeyAxiom ) | annotationAssertionAxiom -> ^( annotationAssertionAxiom ) );";
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
                        if ( (synpred1_MOWLParser()) ) {s = 16;}

                        else if ( (synpred3_MOWLParser()) ) {s = 17;}

                        else if ( (synpred4_MOWLParser()) ) {s = 18;}

                         
                        input.seek(index1_1);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA1_2 = input.LA(1);

                         
                        int index1_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred1_MOWLParser()) ) {s = 16;}

                        else if ( (synpred3_MOWLParser()) ) {s = 17;}

                        else if ( (synpred4_MOWLParser()) ) {s = 18;}

                         
                        input.seek(index1_2);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA1_3 = input.LA(1);

                         
                        int index1_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred1_MOWLParser()) ) {s = 16;}

                        else if ( (synpred4_MOWLParser()) ) {s = 18;}

                         
                        input.seek(index1_3);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA1_4 = input.LA(1);

                         
                        int index1_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred1_MOWLParser()) ) {s = 16;}

                        else if ( (synpred3_MOWLParser()) ) {s = 17;}

                        else if ( (synpred4_MOWLParser()) ) {s = 18;}

                         
                        input.seek(index1_4);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA1_5 = input.LA(1);

                         
                        int index1_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred1_MOWLParser()) ) {s = 16;}

                        else if ( (synpred4_MOWLParser()) ) {s = 18;}

                         
                        input.seek(index1_5);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA1_6 = input.LA(1);

                         
                        int index1_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred1_MOWLParser()) ) {s = 16;}

                        else if ( (synpred4_MOWLParser()) ) {s = 18;}

                         
                        input.seek(index1_6);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA1_7 = input.LA(1);

                         
                        int index1_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred1_MOWLParser()) ) {s = 16;}

                        else if ( (synpred4_MOWLParser()) ) {s = 18;}

                         
                        input.seek(index1_7);
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
        "\21\uffff";
    static final String DFA5_eofS =
        "\21\uffff";
    static final String DFA5_minS =
        "\1\5\7\0\11\uffff";
    static final String DFA5_maxS =
        "\1\55\7\0\11\uffff";
    static final String DFA5_acceptS =
        "\10\uffff\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11";
    static final String DFA5_specialS =
        "\1\uffff\1\0\1\1\1\2\1\3\1\4\1\5\1\6\11\uffff}>";
    static final String[] DFA5_transitionS = {
            "\1\7\1\5\5\uffff\1\4\6\uffff\1\3\24\uffff\1\6\3\uffff\1\1\1"+
            "\2",
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
            return "94:1: binaryAxiom options {backtrack=true; } : (lhs= expression SUBCLASS_OF superClass= expression -> ^( SUB_CLASS_AXIOM ^( EXPRESSION $lhs) ^( EXPRESSION $superClass) ) | lhs= expression EQUIVALENT_TO rhs= expression -> ^( EQUIVALENT_TO_AXIOM ^( EXPRESSION $lhs) ^( EXPRESSION $rhs) ) | lhs= expression DISJOINT_WITH disjoint= expression -> ^( DISJOINT_WITH_AXIOM ^( EXPRESSION $lhs) ^( EXPRESSION $disjoint) ) | lhs= expression SUB_PROPERTY_OF superProperty= propertyExpression -> ^( SUB_PROPERTY_AXIOM ^( EXPRESSION $lhs) ^( EXPRESSION $superProperty) ) | lhsID= atomic INVERSE_OF rhsAtomic= atomic -> ^( INVERSE_OF ^( EXPRESSION $lhsID) ^( EXPRESSION $rhsAtomic) ) | lhsID= atomic SAME_AS rhsID= atomic -> ^( SAME_AS_AXIOM ^( EXPRESSION $lhsID) ^( EXPRESSION $rhsID) ) | lhsID= atomic DIFFERENT_FROM rhsID= atomic -> ^( DIFFERENT_FROM_AXIOM ^( EXPRESSION $lhsID) ^( EXPRESSION $rhsID) ) | lhsID= atomic DOMAIN expression -> ^( DOMAIN ^( EXPRESSION $lhsID) ^( EXPRESSION expression ) ) | lhsID= atomic RANGE expression -> ^( RANGE ^( EXPRESSION $lhsID) ^( EXPRESSION expression ) ) );";
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
                        if ( (synpred7_MOWLParser()) ) {s = 8;}

                        else if ( (synpred8_MOWLParser()) ) {s = 9;}

                        else if ( (synpred9_MOWLParser()) ) {s = 10;}

                        else if ( (synpred10_MOWLParser()) ) {s = 11;}

                        else if ( (synpred11_MOWLParser()) ) {s = 12;}

                        else if ( (synpred12_MOWLParser()) ) {s = 13;}

                        else if ( (synpred13_MOWLParser()) ) {s = 14;}

                        else if ( (synpred14_MOWLParser()) ) {s = 15;}

                        else if ( (true) ) {s = 16;}

                         
                        input.seek(index5_1);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA5_2 = input.LA(1);

                         
                        int index5_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred7_MOWLParser()) ) {s = 8;}

                        else if ( (synpred8_MOWLParser()) ) {s = 9;}

                        else if ( (synpred9_MOWLParser()) ) {s = 10;}

                        else if ( (synpred10_MOWLParser()) ) {s = 11;}

                        else if ( (synpred11_MOWLParser()) ) {s = 12;}

                        else if ( (synpred12_MOWLParser()) ) {s = 13;}

                        else if ( (synpred13_MOWLParser()) ) {s = 14;}

                        else if ( (synpred14_MOWLParser()) ) {s = 15;}

                        else if ( (true) ) {s = 16;}

                         
                        input.seek(index5_2);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA5_3 = input.LA(1);

                         
                        int index5_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred7_MOWLParser()) ) {s = 8;}

                        else if ( (synpred8_MOWLParser()) ) {s = 9;}

                        else if ( (synpred9_MOWLParser()) ) {s = 10;}

                        else if ( (synpred10_MOWLParser()) ) {s = 11;}

                         
                        input.seek(index5_3);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA5_4 = input.LA(1);

                         
                        int index5_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred7_MOWLParser()) ) {s = 8;}

                        else if ( (synpred8_MOWLParser()) ) {s = 9;}

                        else if ( (synpred9_MOWLParser()) ) {s = 10;}

                        else if ( (synpred10_MOWLParser()) ) {s = 11;}

                         
                        input.seek(index5_4);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA5_5 = input.LA(1);

                         
                        int index5_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred7_MOWLParser()) ) {s = 8;}

                        else if ( (synpred8_MOWLParser()) ) {s = 9;}

                        else if ( (synpred9_MOWLParser()) ) {s = 10;}

                        else if ( (synpred10_MOWLParser()) ) {s = 11;}

                         
                        input.seek(index5_5);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA5_6 = input.LA(1);

                         
                        int index5_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred7_MOWLParser()) ) {s = 8;}

                        else if ( (synpred8_MOWLParser()) ) {s = 9;}

                        else if ( (synpred9_MOWLParser()) ) {s = 10;}

                        else if ( (synpred10_MOWLParser()) ) {s = 11;}

                         
                        input.seek(index5_6);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA5_7 = input.LA(1);

                         
                        int index5_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred7_MOWLParser()) ) {s = 8;}

                        else if ( (synpred8_MOWLParser()) ) {s = 9;}

                        else if ( (synpred9_MOWLParser()) ) {s = 10;}

                        else if ( (synpred10_MOWLParser()) ) {s = 11;}

                         
                        input.seek(index5_7);
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
    static final String DFA12_eotS =
        "\14\uffff";
    static final String DFA12_eofS =
        "\14\uffff";
    static final String DFA12_minS =
        "\1\6\4\0\7\uffff";
    static final String DFA12_maxS =
        "\1\55\4\0\7\uffff";
    static final String DFA12_acceptS =
        "\5\uffff\1\4\1\6\1\1\1\5\1\7\1\2\1\3";
    static final String DFA12_specialS =
        "\1\uffff\1\0\1\1\1\2\1\3\7\uffff}>";
    static final String[] DFA12_transitionS = {
            "\1\5\5\uffff\1\4\6\uffff\1\3\24\uffff\1\6\3\uffff\1\1\1\2",
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
            return "145:1: unary options {backtrack=true; } : (head= propertyExpression ( COMPOSITION rest+= propertyExpression )+ -> ^( PROPERTY_CHAIN $head $rest) | NOT OPEN_PARENTHESYS expression CLOSED_PARENTHESYS -> ^( NEGATED_EXPRESSION expression ) | NOT atomic -> ^( NEGATED_EXPRESSION atomic ) | qualifiedRestriction -> ^( qualifiedRestriction ) | dataRange | constant | atomic );";
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
                        if ( (synpred17_MOWLParser()) ) {s = 7;}

                        else if ( (synpred20_MOWLParser()) ) {s = 5;}

                        else if ( (synpred21_MOWLParser()) ) {s = 8;}

                        else if ( (true) ) {s = 9;}

                         
                        input.seek(index12_1);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA12_2 = input.LA(1);

                         
                        int index12_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred17_MOWLParser()) ) {s = 7;}

                        else if ( (synpred20_MOWLParser()) ) {s = 5;}

                        else if ( (true) ) {s = 9;}

                         
                        input.seek(index12_2);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA12_3 = input.LA(1);

                         
                        int index12_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred17_MOWLParser()) ) {s = 7;}

                        else if ( (synpred20_MOWLParser()) ) {s = 5;}

                         
                        input.seek(index12_3);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA12_4 = input.LA(1);

                         
                        int index12_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred18_MOWLParser()) ) {s = 10;}

                        else if ( (synpred19_MOWLParser()) ) {s = 11;}

                         
                        input.seek(index12_4);
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
 

    public static final BitSet FOLLOW_binaryAxiom_in_axiom241 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_unaryAxiom_in_axiom253 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_assertionAxiom_in_axiom265 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_hasKeyAxiom_in_axiom277 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_annotationAssertionAxiom_in_axiom288 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IRI_in_annotationAssertionAxiom306 = new BitSet(new long[]{0x0000300000000000L});
    public static final BitSet FOLLOW_atomic_in_annotationAssertionAxiom311 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_constant_in_annotationAssertionAxiom317 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_in_hasKeyAxiom356 = new BitSet(new long[]{0x0000000000000000L,0x0000200000000000L});
    public static final BitSet FOLLOW_HAS_KEY_in_hasKeyAxiom358 = new BitSet(new long[]{0x0000300000080000L});
    public static final BitSet FOLLOW_propertyExpression_in_hasKeyAxiom360 = new BitSet(new long[]{0x0000002000000002L});
    public static final BitSet FOLLOW_COMMA_in_hasKeyAxiom363 = new BitSet(new long[]{0x0000300000080000L});
    public static final BitSet FOLLOW_propertyExpression_in_hasKeyAxiom365 = new BitSet(new long[]{0x0000002000000002L});
    public static final BitSet FOLLOW_atomic_in_assertionAxiom413 = new BitSet(new long[]{0x000000C000000000L});
    public static final BitSet FOLLOW_INSTANCE_OF_in_assertionAxiom416 = new BitSet(new long[]{0x0000310000081060L});
    public static final BitSet FOLLOW_TYPES_in_assertionAxiom420 = new BitSet(new long[]{0x0000310000081060L});
    public static final BitSet FOLLOW_expression_in_assertionAxiom423 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_atomic_in_assertionAxiom454 = new BitSet(new long[]{0x0000300000080000L});
    public static final BitSet FOLLOW_propertyExpression_in_assertionAxiom456 = new BitSet(new long[]{0x0000310000000000L});
    public static final BitSet FOLLOW_value_in_assertionAxiom459 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NOT_in_assertionAxiom493 = new BitSet(new long[]{0x0000300000001000L});
    public static final BitSet FOLLOW_assertionAxiom_in_assertionAxiom495 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_in_binaryAxiom534 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_SUBCLASS_OF_in_binaryAxiom536 = new BitSet(new long[]{0x0000310000081060L});
    public static final BitSet FOLLOW_expression_in_binaryAxiom543 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_in_binaryAxiom581 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_EQUIVALENT_TO_in_binaryAxiom583 = new BitSet(new long[]{0x0000310000081060L});
    public static final BitSet FOLLOW_expression_in_binaryAxiom589 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_in_binaryAxiom626 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_DISJOINT_WITH_in_binaryAxiom628 = new BitSet(new long[]{0x0000310000081060L});
    public static final BitSet FOLLOW_expression_in_binaryAxiom634 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_in_binaryAxiom671 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_SUB_PROPERTY_OF_in_binaryAxiom673 = new BitSet(new long[]{0x0000300000080000L});
    public static final BitSet FOLLOW_propertyExpression_in_binaryAxiom679 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_atomic_in_binaryAxiom716 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_INVERSE_OF_in_binaryAxiom718 = new BitSet(new long[]{0x0000300000000000L});
    public static final BitSet FOLLOW_atomic_in_binaryAxiom724 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_atomic_in_binaryAxiom755 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_SAME_AS_in_binaryAxiom757 = new BitSet(new long[]{0x0000300000000000L});
    public static final BitSet FOLLOW_atomic_in_binaryAxiom764 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_atomic_in_binaryAxiom802 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_DIFFERENT_FROM_in_binaryAxiom804 = new BitSet(new long[]{0x0000300000000000L});
    public static final BitSet FOLLOW_atomic_in_binaryAxiom811 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_atomic_in_binaryAxiom848 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_DOMAIN_in_binaryAxiom851 = new BitSet(new long[]{0x0000310000081060L});
    public static final BitSet FOLLOW_expression_in_binaryAxiom853 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_atomic_in_binaryAxiom889 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_RANGE_in_binaryAxiom891 = new BitSet(new long[]{0x0000310000081060L});
    public static final BitSet FOLLOW_expression_in_binaryAxiom893 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_unaryCharacteristic_in_unaryAxiom967 = new BitSet(new long[]{0x0000310000081040L});
    public static final BitSet FOLLOW_unary_in_unaryAxiom971 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FUNCTIONAL_in_unaryCharacteristic1016 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INVERSE_FUNCTIONAL_in_unaryCharacteristic1030 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SYMMETRIC_in_unaryCharacteristic1044 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ANTI_SYMMETRIC_in_unaryCharacteristic1058 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_REFLEXIVE_in_unaryCharacteristic1072 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IRREFLEXIVE_in_unaryCharacteristic1086 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TRANSITIVE_in_unaryCharacteristic1100 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_conjunction_in_expression1142 = new BitSet(new long[]{0x0000000000000802L});
    public static final BitSet FOLLOW_OR_in_expression1145 = new BitSet(new long[]{0x0000310000081040L});
    public static final BitSet FOLLOW_conjunction_in_expression1147 = new BitSet(new long[]{0x0000000000000802L});
    public static final BitSet FOLLOW_complexPropertyExpression_in_expression1166 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OPEN_PARENTHESYS_in_expression1179 = new BitSet(new long[]{0x0000310000081060L});
    public static final BitSet FOLLOW_expression_in_expression1181 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_CLOSED_PARENTHESYS_in_expression1183 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_unary_in_conjunction1216 = new BitSet(new long[]{0x0000000000000402L});
    public static final BitSet FOLLOW_AND_in_conjunction1219 = new BitSet(new long[]{0x0000310000081040L});
    public static final BitSet FOLLOW_unary_in_conjunction1221 = new BitSet(new long[]{0x0000000000000402L});
    public static final BitSet FOLLOW_INVERSE_in_complexPropertyExpression1242 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_OPEN_PARENTHESYS_in_complexPropertyExpression1244 = new BitSet(new long[]{0x0000300000080000L});
    public static final BitSet FOLLOW_complexPropertyExpression_in_complexPropertyExpression1246 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_CLOSED_PARENTHESYS_in_complexPropertyExpression1248 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INVERSE_in_complexPropertyExpression1261 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_OPEN_PARENTHESYS_in_complexPropertyExpression1263 = new BitSet(new long[]{0x0000300000000000L});
    public static final BitSet FOLLOW_atomic_in_complexPropertyExpression1265 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_CLOSED_PARENTHESYS_in_complexPropertyExpression1267 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_propertyExpression_in_unary1304 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_COMPOSITION_in_unary1307 = new BitSet(new long[]{0x0000300000080000L});
    public static final BitSet FOLLOW_propertyExpression_in_unary1311 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_NOT_in_unary1333 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_OPEN_PARENTHESYS_in_unary1335 = new BitSet(new long[]{0x0000310000081060L});
    public static final BitSet FOLLOW_expression_in_unary1337 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_CLOSED_PARENTHESYS_in_unary1339 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NOT_in_unary1353 = new BitSet(new long[]{0x0000300000000000L});
    public static final BitSet FOLLOW_atomic_in_unary1355 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_qualifiedRestriction_in_unary1378 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_dataRange_in_unary1390 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_constant_in_unary1396 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_atomic_in_unary1402 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_dataRange1419 = new BitSet(new long[]{0x0000000000000000L,0x0000000000200000L});
    public static final BitSet FOLLOW_OPEN_SQUARE_BRACKET_in_dataRange1421 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000007800000000L});
    public static final BitSet FOLLOW_dataRangeFacet_in_dataRange1423 = new BitSet(new long[]{0x0000002000000000L,0x0000000000400000L});
    public static final BitSet FOLLOW_COMMA_in_dataRange1426 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000007800000000L});
    public static final BitSet FOLLOW_dataRangeFacet_in_dataRange1428 = new BitSet(new long[]{0x0000002000000000L,0x0000000000400000L});
    public static final BitSet FOLLOW_CLOSED_SQUARE_BRACKET_in_dataRange1432 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LESS_THAN_in_dataRangeFacet1458 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_constant_in_dataRangeFacet1460 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LESS_THAN_EQUAL_in_dataRangeFacet1474 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_constant_in_dataRangeFacet1476 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_GREATER_THAN_in_dataRangeFacet1491 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_constant_in_dataRangeFacet1493 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_GREATER_THAN_EQUAL_in_dataRangeFacet1507 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_constant_in_dataRangeFacet1509 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_atomic1530 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ENTITY_REFERENCE_in_atomic1537 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_propertyExpression_in_qualifiedRestriction1589 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_SOME_in_qualifiedRestriction1592 = new BitSet(new long[]{0x0000310000081060L});
    public static final BitSet FOLLOW_expression_in_qualifiedRestriction1596 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_propertyExpression_in_qualifiedRestriction1625 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_ONLY_in_qualifiedRestriction1627 = new BitSet(new long[]{0x0000310000081060L});
    public static final BitSet FOLLOW_expression_in_qualifiedRestriction1630 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_cardinalityRestriction_in_qualifiedRestriction1649 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_oneOf_in_qualifiedRestriction1663 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_valueRestriction_in_qualifiedRestriction1677 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_atomic_in_propertyExpression1709 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_complexPropertyExpression_in_propertyExpression1723 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_propertyExpression_in_cardinalityRestriction1765 = new BitSet(new long[]{0x0000000000038000L});
    public static final BitSet FOLLOW_restrictionKind_in_cardinalityRestriction1768 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_INTEGER_in_cardinalityRestriction1770 = new BitSet(new long[]{0x0000310000081042L});
    public static final BitSet FOLLOW_unary_in_cardinalityRestriction1772 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MIN_in_restrictionKind1805 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MAX_in_restrictionKind1819 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_EXACTLY_in_restrictionKind1833 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OPEN_CURLY_BRACES_in_oneOf1855 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_oneOf1857 = new BitSet(new long[]{0x0000002000000080L});
    public static final BitSet FOLLOW_COMMA_in_oneOf1860 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_oneOf1862 = new BitSet(new long[]{0x0000002000000080L});
    public static final BitSet FOLLOW_CLOSED_CURLY_BRACES_in_oneOf1866 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_propertyExpression_in_valueRestriction1886 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_VALUE_in_valueRestriction1888 = new BitSet(new long[]{0x0000310000000000L});
    public static final BitSet FOLLOW_value_in_valueRestriction1890 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_atomic_in_value1915 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_constant_in_value1930 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DBLQUOTE_in_constant1955 = new BitSet(new long[]{0x0000001000000002L});
    public static final BitSet FOLLOW_POW_in_constant1959 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_constant1965 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_binaryAxiom_in_synpred1_MOWLParser241 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_assertionAxiom_in_synpred3_MOWLParser265 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_hasKeyAxiom_in_synpred4_MOWLParser277 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_in_synpred7_MOWLParser534 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_SUBCLASS_OF_in_synpred7_MOWLParser536 = new BitSet(new long[]{0x0000310000081060L});
    public static final BitSet FOLLOW_expression_in_synpred7_MOWLParser543 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_in_synpred8_MOWLParser581 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_EQUIVALENT_TO_in_synpred8_MOWLParser583 = new BitSet(new long[]{0x0000310000081060L});
    public static final BitSet FOLLOW_expression_in_synpred8_MOWLParser589 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_in_synpred9_MOWLParser626 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_DISJOINT_WITH_in_synpred9_MOWLParser628 = new BitSet(new long[]{0x0000310000081060L});
    public static final BitSet FOLLOW_expression_in_synpred9_MOWLParser634 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_in_synpred10_MOWLParser671 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_SUB_PROPERTY_OF_in_synpred10_MOWLParser673 = new BitSet(new long[]{0x0000300000080000L});
    public static final BitSet FOLLOW_propertyExpression_in_synpred10_MOWLParser679 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_atomic_in_synpred11_MOWLParser716 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_INVERSE_OF_in_synpred11_MOWLParser718 = new BitSet(new long[]{0x0000300000000000L});
    public static final BitSet FOLLOW_atomic_in_synpred11_MOWLParser724 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_atomic_in_synpred12_MOWLParser755 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_SAME_AS_in_synpred12_MOWLParser757 = new BitSet(new long[]{0x0000300000000000L});
    public static final BitSet FOLLOW_atomic_in_synpred12_MOWLParser764 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_atomic_in_synpred13_MOWLParser802 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_DIFFERENT_FROM_in_synpred13_MOWLParser804 = new BitSet(new long[]{0x0000300000000000L});
    public static final BitSet FOLLOW_atomic_in_synpred13_MOWLParser811 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_atomic_in_synpred14_MOWLParser848 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_DOMAIN_in_synpred14_MOWLParser851 = new BitSet(new long[]{0x0000310000081060L});
    public static final BitSet FOLLOW_expression_in_synpred14_MOWLParser853 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_conjunction_in_synpred15_MOWLParser1142 = new BitSet(new long[]{0x0000000000000802L});
    public static final BitSet FOLLOW_OR_in_synpred15_MOWLParser1145 = new BitSet(new long[]{0x0000310000081040L});
    public static final BitSet FOLLOW_conjunction_in_synpred15_MOWLParser1147 = new BitSet(new long[]{0x0000000000000802L});
    public static final BitSet FOLLOW_complexPropertyExpression_in_synpred16_MOWLParser1166 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_propertyExpression_in_synpred17_MOWLParser1304 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_COMPOSITION_in_synpred17_MOWLParser1307 = new BitSet(new long[]{0x0000300000080000L});
    public static final BitSet FOLLOW_propertyExpression_in_synpred17_MOWLParser1311 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_NOT_in_synpred18_MOWLParser1333 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_OPEN_PARENTHESYS_in_synpred18_MOWLParser1335 = new BitSet(new long[]{0x0000310000081060L});
    public static final BitSet FOLLOW_expression_in_synpred18_MOWLParser1337 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_CLOSED_PARENTHESYS_in_synpred18_MOWLParser1339 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NOT_in_synpred19_MOWLParser1353 = new BitSet(new long[]{0x0000300000000000L});
    public static final BitSet FOLLOW_atomic_in_synpred19_MOWLParser1355 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_qualifiedRestriction_in_synpred20_MOWLParser1378 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_dataRange_in_synpred21_MOWLParser1390 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_propertyExpression_in_synpred23_MOWLParser1589 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_SOME_in_synpred23_MOWLParser1592 = new BitSet(new long[]{0x0000310000081060L});
    public static final BitSet FOLLOW_expression_in_synpred23_MOWLParser1596 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_propertyExpression_in_synpred24_MOWLParser1625 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_ONLY_in_synpred24_MOWLParser1627 = new BitSet(new long[]{0x0000310000081060L});
    public static final BitSet FOLLOW_expression_in_synpred24_MOWLParser1630 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_cardinalityRestriction_in_synpred25_MOWLParser1649 = new BitSet(new long[]{0x0000000000000002L});

}