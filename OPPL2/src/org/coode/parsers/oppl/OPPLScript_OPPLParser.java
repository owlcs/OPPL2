// $ANTLR 3.2 Sep 23, 2009 12:02:23 OPPLParser.g 2011-02-01 11:38:38

  package org.coode.parsers.oppl;
  import org.coode.parsers.ErrorListener;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

import org.antlr.runtime.tree.*;

public class OPPLScript_OPPLParser extends Parser {
    public static final int COMMA=37;
    public static final int GREATER_THAN=511;
    public static final int ASSERTED=76;
    public static final int VARIABLE_DEFINITIONS=102;
    public static final int REGEXP_CONSTRAINT=465;
    public static final int END=84;
    public static final int DIFFERENT_FROM=24;
    public static final int LESS_THAN=509;
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
    public static final int AND=10;
    public static final int EXPRESSION=69;
    public static final int CONSTANT=70;
    public static final int VALUE_RESTRICTION=63;
    public static final int ONE_OF=65;
    public static final int SUBPROPERTY_OF=105;
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
    public static final int AT=114;
    public static final int RANGE=28;
    public static final int DATA_RANGE=569;
    public static final int CLOSED_PARENTHESYS=8;
    public static final int PROPERTY_CHAIN=57;
    public static final int CREATE_INTERSECTION=81;
    public static final int EQUIVALENT_TO_AXIOM=49;
    public static final int OPEN_SQUARE_BRACKET=85;
    public static final int NAF_CONSTRAINT=467;
    public static final int SYMMETRIC=30;
    public static final int DISJOINT_WITH=26;
    public static final int VARIABLE_TYPE=89;
    public static final int DISJUNCTION=55;
    public static final int GROUPS=356;
    public static final int NEGATED_EXPRESSION=58;
    public static final int DISJOINT_CLASSES=116;
    public static final int EQUAL=73;
    public static final int DIFFERENT_FROM_AXIOM=53;
    public static final int GREATER_THAN_EQUAL=512;
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
    public static final int SET=115;
    public static final int IDENTIFIER=44;
    public static final int UNARY_AXIOM=54;
    public static final int DISJOINT_PROPERTIES=117;
    public static final int ADD=90;
    public static final int WHERE=71;
    public static final int CREATE=80;
    public static final int VARIABLE_SCOPE=104;
    public static final int OPEN_CURLY_BRACES=6;
    public static final int DIFFERENT_INDIVIDUALS=119;
    public static final int CLOSED_SQUARE_BRACKET=86;
    public static final int INSTANCE_OF=38;
    public static final int VALUES=354;
    public static final int QUERY=103;
    public static final int SOME_RESTRICTION=61;
    public static final int IRI=110;
    public static final int LESS_THAN_EQUAL=510;
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
    public static final int SAME_INDIVIDUAL=118;
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
    public static final int WHITESPACE=9;
    public static final int IN=74;
    public static final int SUPER_PROPERTY_OF=88;
    public static final int INEQUALITY_CONSTRAINT=94;
    public static final int SOME=13;
    public static final int EOF=-1;
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
    public OPPLScript_OPPLParser_MOWLParser gMOWLParser;
    // delegators
    public OPPLScriptParser gOPPLScript;
    public OPPLScriptParser gParent;


        public OPPLScript_OPPLParser(TokenStream input, OPPLScriptParser gOPPLScript) {
            this(input, new RecognizerSharedState(), gOPPLScript);
        }
        public OPPLScript_OPPLParser(TokenStream input, RecognizerSharedState state, OPPLScriptParser gOPPLScript) {
            super(input, state);
            this.gOPPLScript = gOPPLScript;
            gMOWLParser = new OPPLScript_OPPLParser_MOWLParser(input, state, gOPPLScript, this);         
            gParent = gOPPLScript;
        }
        
    protected TreeAdaptor adaptor = new CommonTreeAdaptor();

    public void setTreeAdaptor(TreeAdaptor adaptor) {
        this.adaptor = adaptor;
        gMOWLParser.setTreeAdaptor(this.adaptor);
    }
    public TreeAdaptor getTreeAdaptor() {
        return adaptor;
    }

    public String[] getTokenNames() { return OPPLScriptParser.tokenNames; }
    public String getGrammarFileName() { return "OPPLParser.g"; }


       public Object recoverFromMismatchedSet(IntStream input, RecognitionException e, BitSet follow) throws RecognitionException{
        throw e;
      }
      
      protected void mismatch (IntStream input, int ttype, BitSet follow) throws RecognitionException {
        throw new MismatchedTokenException(ttype,input);
      }
     

    public static class variableDefinitions_return extends ParserRuleReturnScope {
        OPPLSyntaxTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "variableDefinitions"
    // OPPLParser.g:48:2: variableDefinitions : variableDefinition ( COMMA variableDefinition )* -> ^( VARIABLE_DEFINITIONS ( variableDefinition )+ ) ;
    public final OPPLScript_OPPLParser.variableDefinitions_return variableDefinitions() throws RecognitionException {
        OPPLScript_OPPLParser.variableDefinitions_return retval = new OPPLScript_OPPLParser.variableDefinitions_return();
        retval.start = input.LT(1);

        OPPLSyntaxTree root_0 = null;

        Token COMMA2=null;
        OPPLScript_OPPLParser.variableDefinition_return variableDefinition1 = null;

        OPPLScript_OPPLParser.variableDefinition_return variableDefinition3 = null;


        OPPLSyntaxTree COMMA2_tree=null;
        RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
        RewriteRuleSubtreeStream stream_variableDefinition=new RewriteRuleSubtreeStream(adaptor,"rule variableDefinition");
        try {
            // OPPLParser.g:49:3: ( variableDefinition ( COMMA variableDefinition )* -> ^( VARIABLE_DEFINITIONS ( variableDefinition )+ ) )
            // OPPLParser.g:50:5: variableDefinition ( COMMA variableDefinition )*
            {
            pushFollow(FOLLOW_variableDefinition_in_variableDefinitions216);
            variableDefinition1=variableDefinition();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_variableDefinition.add(variableDefinition1.getTree());
            // OPPLParser.g:50:24: ( COMMA variableDefinition )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==COMMA) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // OPPLParser.g:50:25: COMMA variableDefinition
            	    {
            	    COMMA2=(Token)match(input,COMMA,FOLLOW_COMMA_in_variableDefinitions219); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_COMMA.add(COMMA2);

            	    pushFollow(FOLLOW_variableDefinition_in_variableDefinitions221);
            	    variableDefinition3=variableDefinition();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_variableDefinition.add(variableDefinition3.getTree());

            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);



            // AST REWRITE
            // elements: variableDefinition
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (OPPLSyntaxTree)adaptor.nil();
            // 50:52: -> ^( VARIABLE_DEFINITIONS ( variableDefinition )+ )
            {
                // OPPLParser.g:50:55: ^( VARIABLE_DEFINITIONS ( variableDefinition )+ )
                {
                OPPLSyntaxTree root_1 = (OPPLSyntaxTree)adaptor.nil();
                root_1 = (OPPLSyntaxTree)adaptor.becomeRoot((OPPLSyntaxTree)adaptor.create(VARIABLE_DEFINITIONS, "VARIABLE_DEFINITIONS"), root_1);

                if ( !(stream_variableDefinition.hasNext()) ) {
                    throw new RewriteEarlyExitException();
                }
                while ( stream_variableDefinition.hasNext() ) {
                    adaptor.addChild(root_1, stream_variableDefinition.nextTree());

                }
                stream_variableDefinition.reset();

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
    // $ANTLR end "variableDefinitions"

    public static class variableDefinition_return extends ParserRuleReturnScope {
        OPPLSyntaxTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "variableDefinition"
    // OPPLParser.g:53:2: variableDefinition : ( VARIABLE_NAME COLON VARIABLE_TYPE EQUAL opplFunction -> ^( GENERATED_VARIABLE_DEFINITION VARIABLE_NAME VARIABLE_TYPE ^( opplFunction ) ) | VARIABLE_NAME COLON VARIABLE_TYPE EQUAL expression -> ^( GENERATED_VARIABLE_DEFINITION VARIABLE_NAME VARIABLE_TYPE ^( EXPRESSION expression ) ) | VARIABLE_NAME COLON VARIABLE_TYPE EQUAL regexp -> ^( GENERATED_VARIABLE_DEFINITION VARIABLE_NAME VARIABLE_TYPE regexp ) | VARIABLE_NAME COLON VARIABLE_TYPE ( variableScope )? -> ^( INPUT_VARIABLE_DEFINITION VARIABLE_NAME VARIABLE_TYPE ( variableScope )? ) );
    public final OPPLScript_OPPLParser.variableDefinition_return variableDefinition() throws RecognitionException {
        OPPLScript_OPPLParser.variableDefinition_return retval = new OPPLScript_OPPLParser.variableDefinition_return();
        retval.start = input.LT(1);

        OPPLSyntaxTree root_0 = null;

        Token VARIABLE_NAME4=null;
        Token COLON5=null;
        Token VARIABLE_TYPE6=null;
        Token EQUAL7=null;
        Token VARIABLE_NAME9=null;
        Token COLON10=null;
        Token VARIABLE_TYPE11=null;
        Token EQUAL12=null;
        Token VARIABLE_NAME14=null;
        Token COLON15=null;
        Token VARIABLE_TYPE16=null;
        Token EQUAL17=null;
        Token VARIABLE_NAME19=null;
        Token COLON20=null;
        Token VARIABLE_TYPE21=null;
        OPPLScript_OPPLParser.opplFunction_return opplFunction8 = null;

        OPPLScript_OPPLParser_MOWLParser.expression_return expression13 = null;

        OPPLScript_OPPLParser.regexp_return regexp18 = null;

        OPPLScript_OPPLParser.variableScope_return variableScope22 = null;


        OPPLSyntaxTree VARIABLE_NAME4_tree=null;
        OPPLSyntaxTree COLON5_tree=null;
        OPPLSyntaxTree VARIABLE_TYPE6_tree=null;
        OPPLSyntaxTree EQUAL7_tree=null;
        OPPLSyntaxTree VARIABLE_NAME9_tree=null;
        OPPLSyntaxTree COLON10_tree=null;
        OPPLSyntaxTree VARIABLE_TYPE11_tree=null;
        OPPLSyntaxTree EQUAL12_tree=null;
        OPPLSyntaxTree VARIABLE_NAME14_tree=null;
        OPPLSyntaxTree COLON15_tree=null;
        OPPLSyntaxTree VARIABLE_TYPE16_tree=null;
        OPPLSyntaxTree EQUAL17_tree=null;
        OPPLSyntaxTree VARIABLE_NAME19_tree=null;
        OPPLSyntaxTree COLON20_tree=null;
        OPPLSyntaxTree VARIABLE_TYPE21_tree=null;
        RewriteRuleTokenStream stream_COLON=new RewriteRuleTokenStream(adaptor,"token COLON");
        RewriteRuleTokenStream stream_EQUAL=new RewriteRuleTokenStream(adaptor,"token EQUAL");
        RewriteRuleTokenStream stream_VARIABLE_TYPE=new RewriteRuleTokenStream(adaptor,"token VARIABLE_TYPE");
        RewriteRuleTokenStream stream_VARIABLE_NAME=new RewriteRuleTokenStream(adaptor,"token VARIABLE_NAME");
        RewriteRuleSubtreeStream stream_opplFunction=new RewriteRuleSubtreeStream(adaptor,"rule opplFunction");
        RewriteRuleSubtreeStream stream_regexp=new RewriteRuleSubtreeStream(adaptor,"rule regexp");
        RewriteRuleSubtreeStream stream_variableScope=new RewriteRuleSubtreeStream(adaptor,"rule variableScope");
        RewriteRuleSubtreeStream stream_expression=new RewriteRuleSubtreeStream(adaptor,"rule expression");
        try {
            // OPPLParser.g:54:3: ( VARIABLE_NAME COLON VARIABLE_TYPE EQUAL opplFunction -> ^( GENERATED_VARIABLE_DEFINITION VARIABLE_NAME VARIABLE_TYPE ^( opplFunction ) ) | VARIABLE_NAME COLON VARIABLE_TYPE EQUAL expression -> ^( GENERATED_VARIABLE_DEFINITION VARIABLE_NAME VARIABLE_TYPE ^( EXPRESSION expression ) ) | VARIABLE_NAME COLON VARIABLE_TYPE EQUAL regexp -> ^( GENERATED_VARIABLE_DEFINITION VARIABLE_NAME VARIABLE_TYPE regexp ) | VARIABLE_NAME COLON VARIABLE_TYPE ( variableScope )? -> ^( INPUT_VARIABLE_DEFINITION VARIABLE_NAME VARIABLE_TYPE ( variableScope )? ) )
            int alt3=4;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==VARIABLE_NAME) ) {
                int LA3_1 = input.LA(2);

                if ( (LA3_1==COLON) ) {
                    int LA3_2 = input.LA(3);

                    if ( (LA3_2==VARIABLE_TYPE) ) {
                        int LA3_3 = input.LA(4);

                        if ( (LA3_3==EQUAL) ) {
                            switch ( input.LA(5) ) {
                            case CREATE:
                            case CREATE_INTERSECTION:
                            case CREATE_DISJUNCTION:
                            case SET:
                                {
                                alt3=1;
                                }
                                break;
                            case OPEN_PARENTHESYS:
                            case OPEN_CURLY_BRACES:
                            case NOT:
                            case INVERSE:
                            case DBLQUOTE:
                            case IDENTIFIER:
                            case ENTITY_REFERENCE:
                            case ESCLAMATION_MARK:
                            case VARIABLE_NAME:
                                {
                                alt3=2;
                                }
                                break;
                            case MATCH:
                                {
                                alt3=3;
                                }
                                break;
                            default:
                                if (state.backtracking>0) {state.failed=true; return retval;}
                                NoViableAltException nvae =
                                    new NoViableAltException("", 3, 4, input);

                                throw nvae;
                            }

                        }
                        else if ( (LA3_3==COMMA||LA3_3==SELECT||LA3_3==OPEN_SQUARE_BRACKET) ) {
                            alt3=4;
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return retval;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 3, 3, input);

                            throw nvae;
                        }
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 3, 2, input);

                        throw nvae;
                    }
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 3, 1, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // OPPLParser.g:56:7: VARIABLE_NAME COLON VARIABLE_TYPE EQUAL opplFunction
                    {
                    VARIABLE_NAME4=(Token)match(input,VARIABLE_NAME,FOLLOW_VARIABLE_NAME_in_variableDefinition255); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_VARIABLE_NAME.add(VARIABLE_NAME4);

                    COLON5=(Token)match(input,COLON,FOLLOW_COLON_in_variableDefinition257); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_COLON.add(COLON5);

                    VARIABLE_TYPE6=(Token)match(input,VARIABLE_TYPE,FOLLOW_VARIABLE_TYPE_in_variableDefinition259); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_VARIABLE_TYPE.add(VARIABLE_TYPE6);

                    EQUAL7=(Token)match(input,EQUAL,FOLLOW_EQUAL_in_variableDefinition262); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_EQUAL.add(EQUAL7);

                    pushFollow(FOLLOW_opplFunction_in_variableDefinition264);
                    opplFunction8=opplFunction();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_opplFunction.add(opplFunction8.getTree());


                    // AST REWRITE
                    // elements: VARIABLE_NAME, opplFunction, VARIABLE_TYPE
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (OPPLSyntaxTree)adaptor.nil();
                    // 56:61: -> ^( GENERATED_VARIABLE_DEFINITION VARIABLE_NAME VARIABLE_TYPE ^( opplFunction ) )
                    {
                        // OPPLParser.g:56:64: ^( GENERATED_VARIABLE_DEFINITION VARIABLE_NAME VARIABLE_TYPE ^( opplFunction ) )
                        {
                        OPPLSyntaxTree root_1 = (OPPLSyntaxTree)adaptor.nil();
                        root_1 = (OPPLSyntaxTree)adaptor.becomeRoot((OPPLSyntaxTree)adaptor.create(GENERATED_VARIABLE_DEFINITION, "GENERATED_VARIABLE_DEFINITION"), root_1);

                        adaptor.addChild(root_1, stream_VARIABLE_NAME.nextNode());
                        adaptor.addChild(root_1, stream_VARIABLE_TYPE.nextNode());
                        // OPPLParser.g:56:124: ^( opplFunction )
                        {
                        OPPLSyntaxTree root_2 = (OPPLSyntaxTree)adaptor.nil();
                        root_2 = (OPPLSyntaxTree)adaptor.becomeRoot(stream_opplFunction.nextNode(), root_2);

                        adaptor.addChild(root_1, root_2);
                        }

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 2 :
                    // OPPLParser.g:57:7: VARIABLE_NAME COLON VARIABLE_TYPE EQUAL expression
                    {
                    VARIABLE_NAME9=(Token)match(input,VARIABLE_NAME,FOLLOW_VARIABLE_NAME_in_variableDefinition292); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_VARIABLE_NAME.add(VARIABLE_NAME9);

                    COLON10=(Token)match(input,COLON,FOLLOW_COLON_in_variableDefinition294); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_COLON.add(COLON10);

                    VARIABLE_TYPE11=(Token)match(input,VARIABLE_TYPE,FOLLOW_VARIABLE_TYPE_in_variableDefinition296); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_VARIABLE_TYPE.add(VARIABLE_TYPE11);

                    EQUAL12=(Token)match(input,EQUAL,FOLLOW_EQUAL_in_variableDefinition299); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_EQUAL.add(EQUAL12);

                    pushFollow(FOLLOW_expression_in_variableDefinition301);
                    expression13=gOPPLScript.expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_expression.add(expression13.getTree());


                    // AST REWRITE
                    // elements: VARIABLE_TYPE, expression, VARIABLE_NAME
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (OPPLSyntaxTree)adaptor.nil();
                    // 57:59: -> ^( GENERATED_VARIABLE_DEFINITION VARIABLE_NAME VARIABLE_TYPE ^( EXPRESSION expression ) )
                    {
                        // OPPLParser.g:57:62: ^( GENERATED_VARIABLE_DEFINITION VARIABLE_NAME VARIABLE_TYPE ^( EXPRESSION expression ) )
                        {
                        OPPLSyntaxTree root_1 = (OPPLSyntaxTree)adaptor.nil();
                        root_1 = (OPPLSyntaxTree)adaptor.becomeRoot((OPPLSyntaxTree)adaptor.create(GENERATED_VARIABLE_DEFINITION, "GENERATED_VARIABLE_DEFINITION"), root_1);

                        adaptor.addChild(root_1, stream_VARIABLE_NAME.nextNode());
                        adaptor.addChild(root_1, stream_VARIABLE_TYPE.nextNode());
                        // OPPLParser.g:57:122: ^( EXPRESSION expression )
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
                case 3 :
                    // OPPLParser.g:58:7: VARIABLE_NAME COLON VARIABLE_TYPE EQUAL regexp
                    {
                    VARIABLE_NAME14=(Token)match(input,VARIABLE_NAME,FOLLOW_VARIABLE_NAME_in_variableDefinition325); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_VARIABLE_NAME.add(VARIABLE_NAME14);

                    COLON15=(Token)match(input,COLON,FOLLOW_COLON_in_variableDefinition327); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_COLON.add(COLON15);

                    VARIABLE_TYPE16=(Token)match(input,VARIABLE_TYPE,FOLLOW_VARIABLE_TYPE_in_variableDefinition329); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_VARIABLE_TYPE.add(VARIABLE_TYPE16);

                    EQUAL17=(Token)match(input,EQUAL,FOLLOW_EQUAL_in_variableDefinition332); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_EQUAL.add(EQUAL17);

                    pushFollow(FOLLOW_regexp_in_variableDefinition334);
                    regexp18=regexp();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_regexp.add(regexp18.getTree());


                    // AST REWRITE
                    // elements: VARIABLE_TYPE, regexp, VARIABLE_NAME
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (OPPLSyntaxTree)adaptor.nil();
                    // 58:55: -> ^( GENERATED_VARIABLE_DEFINITION VARIABLE_NAME VARIABLE_TYPE regexp )
                    {
                        // OPPLParser.g:58:58: ^( GENERATED_VARIABLE_DEFINITION VARIABLE_NAME VARIABLE_TYPE regexp )
                        {
                        OPPLSyntaxTree root_1 = (OPPLSyntaxTree)adaptor.nil();
                        root_1 = (OPPLSyntaxTree)adaptor.becomeRoot((OPPLSyntaxTree)adaptor.create(GENERATED_VARIABLE_DEFINITION, "GENERATED_VARIABLE_DEFINITION"), root_1);

                        adaptor.addChild(root_1, stream_VARIABLE_NAME.nextNode());
                        adaptor.addChild(root_1, stream_VARIABLE_TYPE.nextNode());
                        adaptor.addChild(root_1, stream_regexp.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 4 :
                    // OPPLParser.g:59:7: VARIABLE_NAME COLON VARIABLE_TYPE ( variableScope )?
                    {
                    VARIABLE_NAME19=(Token)match(input,VARIABLE_NAME,FOLLOW_VARIABLE_NAME_in_variableDefinition354); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_VARIABLE_NAME.add(VARIABLE_NAME19);

                    COLON20=(Token)match(input,COLON,FOLLOW_COLON_in_variableDefinition356); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_COLON.add(COLON20);

                    VARIABLE_TYPE21=(Token)match(input,VARIABLE_TYPE,FOLLOW_VARIABLE_TYPE_in_variableDefinition358); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_VARIABLE_TYPE.add(VARIABLE_TYPE21);

                    // OPPLParser.g:59:41: ( variableScope )?
                    int alt2=2;
                    int LA2_0 = input.LA(1);

                    if ( (LA2_0==OPEN_SQUARE_BRACKET) ) {
                        alt2=1;
                    }
                    switch (alt2) {
                        case 1 :
                            // OPPLParser.g:59:42: variableScope
                            {
                            pushFollow(FOLLOW_variableScope_in_variableDefinition361);
                            variableScope22=variableScope();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) stream_variableScope.add(variableScope22.getTree());

                            }
                            break;

                    }



                    // AST REWRITE
                    // elements: VARIABLE_NAME, VARIABLE_TYPE, variableScope
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (OPPLSyntaxTree)adaptor.nil();
                    // 59:58: -> ^( INPUT_VARIABLE_DEFINITION VARIABLE_NAME VARIABLE_TYPE ( variableScope )? )
                    {
                        // OPPLParser.g:59:61: ^( INPUT_VARIABLE_DEFINITION VARIABLE_NAME VARIABLE_TYPE ( variableScope )? )
                        {
                        OPPLSyntaxTree root_1 = (OPPLSyntaxTree)adaptor.nil();
                        root_1 = (OPPLSyntaxTree)adaptor.becomeRoot((OPPLSyntaxTree)adaptor.create(INPUT_VARIABLE_DEFINITION, "INPUT_VARIABLE_DEFINITION"), root_1);

                        adaptor.addChild(root_1, stream_VARIABLE_NAME.nextNode());
                        adaptor.addChild(root_1, stream_VARIABLE_TYPE.nextNode());
                        // OPPLParser.g:59:117: ( variableScope )?
                        if ( stream_variableScope.hasNext() ) {
                            adaptor.addChild(root_1, stream_variableScope.nextTree());

                        }
                        stream_variableScope.reset();

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
    // $ANTLR end "variableDefinition"

    public static class variableScope_return extends ParserRuleReturnScope {
        OPPLSyntaxTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "variableScope"
    // OPPLParser.g:64:1: variableScope : OPEN_SQUARE_BRACKET (variableScopeSpecification= SUBCLASS_OF | variableScopeSpecification= SUBPROPERTY_OF | variableScopeSpecification= SUPER_CLASS_OF | variableScopeSpecification= SUPER_PROPERTY_OF | variableScopeSpecification= INSTANCE_OF | variableScopeSpecification= TYPES ) expression CLOSED_SQUARE_BRACKET -> ^( VARIABLE_SCOPE $variableScopeSpecification ^( EXPRESSION expression ) ) ;
    public final OPPLScript_OPPLParser.variableScope_return variableScope() throws RecognitionException {
        OPPLScript_OPPLParser.variableScope_return retval = new OPPLScript_OPPLParser.variableScope_return();
        retval.start = input.LT(1);

        OPPLSyntaxTree root_0 = null;

        Token variableScopeSpecification=null;
        Token OPEN_SQUARE_BRACKET23=null;
        Token CLOSED_SQUARE_BRACKET25=null;
        OPPLScript_OPPLParser_MOWLParser.expression_return expression24 = null;


        OPPLSyntaxTree variableScopeSpecification_tree=null;
        OPPLSyntaxTree OPEN_SQUARE_BRACKET23_tree=null;
        OPPLSyntaxTree CLOSED_SQUARE_BRACKET25_tree=null;
        RewriteRuleTokenStream stream_TYPES=new RewriteRuleTokenStream(adaptor,"token TYPES");
        RewriteRuleTokenStream stream_SUBPROPERTY_OF=new RewriteRuleTokenStream(adaptor,"token SUBPROPERTY_OF");
        RewriteRuleTokenStream stream_SUBCLASS_OF=new RewriteRuleTokenStream(adaptor,"token SUBCLASS_OF");
        RewriteRuleTokenStream stream_OPEN_SQUARE_BRACKET=new RewriteRuleTokenStream(adaptor,"token OPEN_SQUARE_BRACKET");
        RewriteRuleTokenStream stream_SUPER_CLASS_OF=new RewriteRuleTokenStream(adaptor,"token SUPER_CLASS_OF");
        RewriteRuleTokenStream stream_CLOSED_SQUARE_BRACKET=new RewriteRuleTokenStream(adaptor,"token CLOSED_SQUARE_BRACKET");
        RewriteRuleTokenStream stream_INSTANCE_OF=new RewriteRuleTokenStream(adaptor,"token INSTANCE_OF");
        RewriteRuleTokenStream stream_SUPER_PROPERTY_OF=new RewriteRuleTokenStream(adaptor,"token SUPER_PROPERTY_OF");
        RewriteRuleSubtreeStream stream_expression=new RewriteRuleSubtreeStream(adaptor,"rule expression");
        try {
            // OPPLParser.g:65:3: ( OPEN_SQUARE_BRACKET (variableScopeSpecification= SUBCLASS_OF | variableScopeSpecification= SUBPROPERTY_OF | variableScopeSpecification= SUPER_CLASS_OF | variableScopeSpecification= SUPER_PROPERTY_OF | variableScopeSpecification= INSTANCE_OF | variableScopeSpecification= TYPES ) expression CLOSED_SQUARE_BRACKET -> ^( VARIABLE_SCOPE $variableScopeSpecification ^( EXPRESSION expression ) ) )
            // OPPLParser.g:66:5: OPEN_SQUARE_BRACKET (variableScopeSpecification= SUBCLASS_OF | variableScopeSpecification= SUBPROPERTY_OF | variableScopeSpecification= SUPER_CLASS_OF | variableScopeSpecification= SUPER_PROPERTY_OF | variableScopeSpecification= INSTANCE_OF | variableScopeSpecification= TYPES ) expression CLOSED_SQUARE_BRACKET
            {
            OPEN_SQUARE_BRACKET23=(Token)match(input,OPEN_SQUARE_BRACKET,FOLLOW_OPEN_SQUARE_BRACKET_in_variableScope401); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_OPEN_SQUARE_BRACKET.add(OPEN_SQUARE_BRACKET23);

            // OPPLParser.g:66:25: (variableScopeSpecification= SUBCLASS_OF | variableScopeSpecification= SUBPROPERTY_OF | variableScopeSpecification= SUPER_CLASS_OF | variableScopeSpecification= SUPER_PROPERTY_OF | variableScopeSpecification= INSTANCE_OF | variableScopeSpecification= TYPES )
            int alt4=6;
            switch ( input.LA(1) ) {
            case SUBCLASS_OF:
                {
                alt4=1;
                }
                break;
            case SUBPROPERTY_OF:
                {
                alt4=2;
                }
                break;
            case SUPER_CLASS_OF:
                {
                alt4=3;
                }
                break;
            case SUPER_PROPERTY_OF:
                {
                alt4=4;
                }
                break;
            case INSTANCE_OF:
                {
                alt4=5;
                }
                break;
            case TYPES:
                {
                alt4=6;
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
                    // OPPLParser.g:66:26: variableScopeSpecification= SUBCLASS_OF
                    {
                    variableScopeSpecification=(Token)match(input,SUBCLASS_OF,FOLLOW_SUBCLASS_OF_in_variableScope408); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_SUBCLASS_OF.add(variableScopeSpecification);


                    }
                    break;
                case 2 :
                    // OPPLParser.g:66:69: variableScopeSpecification= SUBPROPERTY_OF
                    {
                    variableScopeSpecification=(Token)match(input,SUBPROPERTY_OF,FOLLOW_SUBPROPERTY_OF_in_variableScope416); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_SUBPROPERTY_OF.add(variableScopeSpecification);


                    }
                    break;
                case 3 :
                    // OPPLParser.g:66:115: variableScopeSpecification= SUPER_CLASS_OF
                    {
                    variableScopeSpecification=(Token)match(input,SUPER_CLASS_OF,FOLLOW_SUPER_CLASS_OF_in_variableScope424); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_SUPER_CLASS_OF.add(variableScopeSpecification);


                    }
                    break;
                case 4 :
                    // OPPLParser.g:66:162: variableScopeSpecification= SUPER_PROPERTY_OF
                    {
                    variableScopeSpecification=(Token)match(input,SUPER_PROPERTY_OF,FOLLOW_SUPER_PROPERTY_OF_in_variableScope432); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_SUPER_PROPERTY_OF.add(variableScopeSpecification);


                    }
                    break;
                case 5 :
                    // OPPLParser.g:66:211: variableScopeSpecification= INSTANCE_OF
                    {
                    variableScopeSpecification=(Token)match(input,INSTANCE_OF,FOLLOW_INSTANCE_OF_in_variableScope441); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_INSTANCE_OF.add(variableScopeSpecification);


                    }
                    break;
                case 6 :
                    // OPPLParser.g:66:254: variableScopeSpecification= TYPES
                    {
                    variableScopeSpecification=(Token)match(input,TYPES,FOLLOW_TYPES_in_variableScope449); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_TYPES.add(variableScopeSpecification);


                    }
                    break;

            }

            pushFollow(FOLLOW_expression_in_variableScope452);
            expression24=gOPPLScript.expression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_expression.add(expression24.getTree());
            CLOSED_SQUARE_BRACKET25=(Token)match(input,CLOSED_SQUARE_BRACKET,FOLLOW_CLOSED_SQUARE_BRACKET_in_variableScope454); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_CLOSED_SQUARE_BRACKET.add(CLOSED_SQUARE_BRACKET25);



            // AST REWRITE
            // elements: expression, variableScopeSpecification
            // token labels: variableScopeSpecification
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleTokenStream stream_variableScopeSpecification=new RewriteRuleTokenStream(adaptor,"token variableScopeSpecification",variableScopeSpecification);
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (OPPLSyntaxTree)adaptor.nil();
            // 66:323: -> ^( VARIABLE_SCOPE $variableScopeSpecification ^( EXPRESSION expression ) )
            {
                // OPPLParser.g:66:326: ^( VARIABLE_SCOPE $variableScopeSpecification ^( EXPRESSION expression ) )
                {
                OPPLSyntaxTree root_1 = (OPPLSyntaxTree)adaptor.nil();
                root_1 = (OPPLSyntaxTree)adaptor.becomeRoot((OPPLSyntaxTree)adaptor.create(VARIABLE_SCOPE, "VARIABLE_SCOPE"), root_1);

                adaptor.addChild(root_1, stream_variableScopeSpecification.nextNode());
                // OPPLParser.g:66:371: ^( EXPRESSION expression )
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
    // $ANTLR end "variableScope"

    public static class regexp_return extends ParserRuleReturnScope {
        OPPLSyntaxTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "regexp"
    // OPPLParser.g:69:1: regexp : MATCH OPEN_PARENTHESYS stringOperation CLOSED_PARENTHESYS -> ^( MATCH stringOperation ) ;
    public final OPPLScript_OPPLParser.regexp_return regexp() throws RecognitionException {
        OPPLScript_OPPLParser.regexp_return retval = new OPPLScript_OPPLParser.regexp_return();
        retval.start = input.LT(1);

        OPPLSyntaxTree root_0 = null;

        Token MATCH26=null;
        Token OPEN_PARENTHESYS27=null;
        Token CLOSED_PARENTHESYS29=null;
        OPPLScript_OPPLParser.stringOperation_return stringOperation28 = null;


        OPPLSyntaxTree MATCH26_tree=null;
        OPPLSyntaxTree OPEN_PARENTHESYS27_tree=null;
        OPPLSyntaxTree CLOSED_PARENTHESYS29_tree=null;
        RewriteRuleTokenStream stream_MATCH=new RewriteRuleTokenStream(adaptor,"token MATCH");
        RewriteRuleTokenStream stream_CLOSED_PARENTHESYS=new RewriteRuleTokenStream(adaptor,"token CLOSED_PARENTHESYS");
        RewriteRuleTokenStream stream_OPEN_PARENTHESYS=new RewriteRuleTokenStream(adaptor,"token OPEN_PARENTHESYS");
        RewriteRuleSubtreeStream stream_stringOperation=new RewriteRuleSubtreeStream(adaptor,"rule stringOperation");
        try {
            // OPPLParser.g:70:2: ( MATCH OPEN_PARENTHESYS stringOperation CLOSED_PARENTHESYS -> ^( MATCH stringOperation ) )
            // OPPLParser.g:71:3: MATCH OPEN_PARENTHESYS stringOperation CLOSED_PARENTHESYS
            {
            MATCH26=(Token)match(input,MATCH,FOLLOW_MATCH_in_regexp484); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_MATCH.add(MATCH26);

            OPEN_PARENTHESYS27=(Token)match(input,OPEN_PARENTHESYS,FOLLOW_OPEN_PARENTHESYS_in_regexp486); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_OPEN_PARENTHESYS.add(OPEN_PARENTHESYS27);

            pushFollow(FOLLOW_stringOperation_in_regexp488);
            stringOperation28=stringOperation();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_stringOperation.add(stringOperation28.getTree());
            CLOSED_PARENTHESYS29=(Token)match(input,CLOSED_PARENTHESYS,FOLLOW_CLOSED_PARENTHESYS_in_regexp490); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_CLOSED_PARENTHESYS.add(CLOSED_PARENTHESYS29);



            // AST REWRITE
            // elements: MATCH, stringOperation
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (OPPLSyntaxTree)adaptor.nil();
            // 71:61: -> ^( MATCH stringOperation )
            {
                // OPPLParser.g:71:64: ^( MATCH stringOperation )
                {
                OPPLSyntaxTree root_1 = (OPPLSyntaxTree)adaptor.nil();
                root_1 = (OPPLSyntaxTree)adaptor.becomeRoot(stream_MATCH.nextNode(), root_1);

                adaptor.addChild(root_1, stream_stringOperation.nextTree());

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
    // $ANTLR end "regexp"

    public static class query_return extends ParserRuleReturnScope {
        OPPLSyntaxTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "query"
    // OPPLParser.g:74:2: query : SELECT selectClause ( COMMA selectClause )* ( WHERE constraint ( COMMA constraint )* )? -> ^( QUERY ( selectClause )+ ( constraint )* ) ;
    public final OPPLScript_OPPLParser.query_return query() throws RecognitionException {
        OPPLScript_OPPLParser.query_return retval = new OPPLScript_OPPLParser.query_return();
        retval.start = input.LT(1);

        OPPLSyntaxTree root_0 = null;

        Token SELECT30=null;
        Token COMMA32=null;
        Token WHERE34=null;
        Token COMMA36=null;
        OPPLScript_OPPLParser.selectClause_return selectClause31 = null;

        OPPLScript_OPPLParser.selectClause_return selectClause33 = null;

        OPPLScript_OPPLParser.constraint_return constraint35 = null;

        OPPLScript_OPPLParser.constraint_return constraint37 = null;


        OPPLSyntaxTree SELECT30_tree=null;
        OPPLSyntaxTree COMMA32_tree=null;
        OPPLSyntaxTree WHERE34_tree=null;
        OPPLSyntaxTree COMMA36_tree=null;
        RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
        RewriteRuleTokenStream stream_SELECT=new RewriteRuleTokenStream(adaptor,"token SELECT");
        RewriteRuleTokenStream stream_WHERE=new RewriteRuleTokenStream(adaptor,"token WHERE");
        RewriteRuleSubtreeStream stream_selectClause=new RewriteRuleSubtreeStream(adaptor,"rule selectClause");
        RewriteRuleSubtreeStream stream_constraint=new RewriteRuleSubtreeStream(adaptor,"rule constraint");
        try {
            // OPPLParser.g:75:3: ( SELECT selectClause ( COMMA selectClause )* ( WHERE constraint ( COMMA constraint )* )? -> ^( QUERY ( selectClause )+ ( constraint )* ) )
            // OPPLParser.g:76:5: SELECT selectClause ( COMMA selectClause )* ( WHERE constraint ( COMMA constraint )* )?
            {
            SELECT30=(Token)match(input,SELECT,FOLLOW_SELECT_in_query515); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_SELECT.add(SELECT30);

            pushFollow(FOLLOW_selectClause_in_query517);
            selectClause31=selectClause();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_selectClause.add(selectClause31.getTree());
            // OPPLParser.g:76:25: ( COMMA selectClause )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==COMMA) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // OPPLParser.g:76:26: COMMA selectClause
            	    {
            	    COMMA32=(Token)match(input,COMMA,FOLLOW_COMMA_in_query520); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_COMMA.add(COMMA32);

            	    pushFollow(FOLLOW_selectClause_in_query522);
            	    selectClause33=selectClause();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_selectClause.add(selectClause33.getTree());

            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);

            // OPPLParser.g:76:47: ( WHERE constraint ( COMMA constraint )* )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==WHERE) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // OPPLParser.g:76:48: WHERE constraint ( COMMA constraint )*
                    {
                    WHERE34=(Token)match(input,WHERE,FOLLOW_WHERE_in_query527); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_WHERE.add(WHERE34);

                    pushFollow(FOLLOW_constraint_in_query529);
                    constraint35=constraint();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_constraint.add(constraint35.getTree());
                    // OPPLParser.g:76:65: ( COMMA constraint )*
                    loop6:
                    do {
                        int alt6=2;
                        int LA6_0 = input.LA(1);

                        if ( (LA6_0==COMMA) ) {
                            alt6=1;
                        }


                        switch (alt6) {
                    	case 1 :
                    	    // OPPLParser.g:76:66: COMMA constraint
                    	    {
                    	    COMMA36=(Token)match(input,COMMA,FOLLOW_COMMA_in_query532); if (state.failed) return retval; 
                    	    if ( state.backtracking==0 ) stream_COMMA.add(COMMA36);

                    	    pushFollow(FOLLOW_constraint_in_query534);
                    	    constraint37=constraint();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) stream_constraint.add(constraint37.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop6;
                        }
                    } while (true);


                    }
                    break;

            }



            // AST REWRITE
            // elements: constraint, selectClause
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (OPPLSyntaxTree)adaptor.nil();
            // 76:87: -> ^( QUERY ( selectClause )+ ( constraint )* )
            {
                // OPPLParser.g:76:90: ^( QUERY ( selectClause )+ ( constraint )* )
                {
                OPPLSyntaxTree root_1 = (OPPLSyntaxTree)adaptor.nil();
                root_1 = (OPPLSyntaxTree)adaptor.becomeRoot((OPPLSyntaxTree)adaptor.create(QUERY, "QUERY"), root_1);

                if ( !(stream_selectClause.hasNext()) ) {
                    throw new RewriteEarlyExitException();
                }
                while ( stream_selectClause.hasNext() ) {
                    adaptor.addChild(root_1, stream_selectClause.nextTree());

                }
                stream_selectClause.reset();
                // OPPLParser.g:76:112: ( constraint )*
                while ( stream_constraint.hasNext() ) {
                    adaptor.addChild(root_1, stream_constraint.nextTree());

                }
                stream_constraint.reset();

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
    // $ANTLR end "query"

    public static class selectClause_return extends ParserRuleReturnScope {
        OPPLSyntaxTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "selectClause"
    // OPPLParser.g:79:2: selectClause : ( ASSERTED axiom -> ^( ASSERTED_CLAUSE axiom ) | axiom -> ^( PLAIN_CLAUSE axiom ) );
    public final OPPLScript_OPPLParser.selectClause_return selectClause() throws RecognitionException {
        OPPLScript_OPPLParser.selectClause_return retval = new OPPLScript_OPPLParser.selectClause_return();
        retval.start = input.LT(1);

        OPPLSyntaxTree root_0 = null;

        Token ASSERTED38=null;
        OPPLScript_OPPLParser.axiom_return axiom39 = null;

        OPPLScript_OPPLParser.axiom_return axiom40 = null;


        OPPLSyntaxTree ASSERTED38_tree=null;
        RewriteRuleTokenStream stream_ASSERTED=new RewriteRuleTokenStream(adaptor,"token ASSERTED");
        RewriteRuleSubtreeStream stream_axiom=new RewriteRuleSubtreeStream(adaptor,"rule axiom");
        try {
            // OPPLParser.g:80:3: ( ASSERTED axiom -> ^( ASSERTED_CLAUSE axiom ) | axiom -> ^( PLAIN_CLAUSE axiom ) )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==ASSERTED) ) {
                alt8=1;
            }
            else if ( ((LA8_0>=OPEN_PARENTHESYS && LA8_0<=OPEN_CURLY_BRACES)||LA8_0==NOT||LA8_0==INVERSE||(LA8_0>=FUNCTIONAL && LA8_0<=INVERSE_FUNCTIONAL)||LA8_0==DBLQUOTE||(LA8_0>=IDENTIFIER && LA8_0<=ENTITY_REFERENCE)||LA8_0==IRI||(LA8_0>=DISJOINT_CLASSES && LA8_0<=DIFFERENT_INDIVIDUALS)||LA8_0==ESCLAMATION_MARK||LA8_0==VARIABLE_NAME) ) {
                alt8=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }
            switch (alt8) {
                case 1 :
                    // OPPLParser.g:81:7: ASSERTED axiom
                    {
                    ASSERTED38=(Token)match(input,ASSERTED,FOLLOW_ASSERTED_in_selectClause571); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_ASSERTED.add(ASSERTED38);

                    pushFollow(FOLLOW_axiom_in_selectClause573);
                    axiom39=axiom();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_axiom.add(axiom39.getTree());


                    // AST REWRITE
                    // elements: axiom
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (OPPLSyntaxTree)adaptor.nil();
                    // 81:22: -> ^( ASSERTED_CLAUSE axiom )
                    {
                        // OPPLParser.g:81:25: ^( ASSERTED_CLAUSE axiom )
                        {
                        OPPLSyntaxTree root_1 = (OPPLSyntaxTree)adaptor.nil();
                        root_1 = (OPPLSyntaxTree)adaptor.becomeRoot((OPPLSyntaxTree)adaptor.create(ASSERTED_CLAUSE, "ASSERTED_CLAUSE"), root_1);

                        adaptor.addChild(root_1, stream_axiom.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 2 :
                    // OPPLParser.g:82:7: axiom
                    {
                    pushFollow(FOLLOW_axiom_in_selectClause589);
                    axiom40=axiom();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_axiom.add(axiom40.getTree());


                    // AST REWRITE
                    // elements: axiom
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (OPPLSyntaxTree)adaptor.nil();
                    // 82:13: -> ^( PLAIN_CLAUSE axiom )
                    {
                        // OPPLParser.g:82:16: ^( PLAIN_CLAUSE axiom )
                        {
                        OPPLSyntaxTree root_1 = (OPPLSyntaxTree)adaptor.nil();
                        root_1 = (OPPLSyntaxTree)adaptor.becomeRoot((OPPLSyntaxTree)adaptor.create(PLAIN_CLAUSE, "PLAIN_CLAUSE"), root_1);

                        adaptor.addChild(root_1, stream_axiom.nextTree());

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
    // $ANTLR end "selectClause"

    public static class axiom_return extends ParserRuleReturnScope {
        OPPLSyntaxTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "axiom"
    // OPPLParser.g:85:1: axiom options {backtrack=true; } : ( binaryAxiom -> ^( binaryAxiom ) | nAryAxiom -> ^( nAryAxiom ) | unaryAxiom -> ^( unaryAxiom ) | assertionAxiom -> ^( assertionAxiom ) | hasKeyAxiom -> ^( hasKeyAxiom ) | annotationAssertionAxiom -> ^( annotationAssertionAxiom ) );
    public final OPPLScript_OPPLParser.axiom_return axiom() throws RecognitionException {
        OPPLScript_OPPLParser.axiom_return retval = new OPPLScript_OPPLParser.axiom_return();
        retval.start = input.LT(1);

        OPPLSyntaxTree root_0 = null;

        OPPLScript_OPPLParser_MOWLParser.binaryAxiom_return binaryAxiom41 = null;

        OPPLScript_OPPLParser.nAryAxiom_return nAryAxiom42 = null;

        OPPLScript_OPPLParser_MOWLParser.unaryAxiom_return unaryAxiom43 = null;

        OPPLScript_OPPLParser_MOWLParser.assertionAxiom_return assertionAxiom44 = null;

        OPPLScript_OPPLParser_MOWLParser.hasKeyAxiom_return hasKeyAxiom45 = null;

        OPPLScript_OPPLParser_MOWLParser.annotationAssertionAxiom_return annotationAssertionAxiom46 = null;


        RewriteRuleSubtreeStream stream_assertionAxiom=new RewriteRuleSubtreeStream(adaptor,"rule assertionAxiom");
        RewriteRuleSubtreeStream stream_nAryAxiom=new RewriteRuleSubtreeStream(adaptor,"rule nAryAxiom");
        RewriteRuleSubtreeStream stream_binaryAxiom=new RewriteRuleSubtreeStream(adaptor,"rule binaryAxiom");
        RewriteRuleSubtreeStream stream_hasKeyAxiom=new RewriteRuleSubtreeStream(adaptor,"rule hasKeyAxiom");
        RewriteRuleSubtreeStream stream_annotationAssertionAxiom=new RewriteRuleSubtreeStream(adaptor,"rule annotationAssertionAxiom");
        RewriteRuleSubtreeStream stream_unaryAxiom=new RewriteRuleSubtreeStream(adaptor,"rule unaryAxiom");
        try {
            // OPPLParser.g:85:37: ( binaryAxiom -> ^( binaryAxiom ) | nAryAxiom -> ^( nAryAxiom ) | unaryAxiom -> ^( unaryAxiom ) | assertionAxiom -> ^( assertionAxiom ) | hasKeyAxiom -> ^( hasKeyAxiom ) | annotationAssertionAxiom -> ^( annotationAssertionAxiom ) )
            int alt9=6;
            alt9 = dfa9.predict(input);
            switch (alt9) {
                case 1 :
                    // OPPLParser.g:86:3: binaryAxiom
                    {
                    pushFollow(FOLLOW_binaryAxiom_in_axiom621);
                    binaryAxiom41=gOPPLScript.binaryAxiom();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_binaryAxiom.add(binaryAxiom41.getTree());


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
                    // 86:15: -> ^( binaryAxiom )
                    {
                        // OPPLParser.g:86:18: ^( binaryAxiom )
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
                    // OPPLParser.g:87:5: nAryAxiom
                    {
                    pushFollow(FOLLOW_nAryAxiom_in_axiom633);
                    nAryAxiom42=nAryAxiom();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_nAryAxiom.add(nAryAxiom42.getTree());


                    // AST REWRITE
                    // elements: nAryAxiom
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (OPPLSyntaxTree)adaptor.nil();
                    // 87:15: -> ^( nAryAxiom )
                    {
                        // OPPLParser.g:87:18: ^( nAryAxiom )
                        {
                        OPPLSyntaxTree root_1 = (OPPLSyntaxTree)adaptor.nil();
                        root_1 = (OPPLSyntaxTree)adaptor.becomeRoot(stream_nAryAxiom.nextNode(), root_1);

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 3 :
                    // OPPLParser.g:88:5: unaryAxiom
                    {
                    pushFollow(FOLLOW_unaryAxiom_in_axiom645);
                    unaryAxiom43=gOPPLScript.unaryAxiom();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_unaryAxiom.add(unaryAxiom43.getTree());


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
                    // 88:16: -> ^( unaryAxiom )
                    {
                        // OPPLParser.g:88:19: ^( unaryAxiom )
                        {
                        OPPLSyntaxTree root_1 = (OPPLSyntaxTree)adaptor.nil();
                        root_1 = (OPPLSyntaxTree)adaptor.becomeRoot(stream_unaryAxiom.nextNode(), root_1);

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 4 :
                    // OPPLParser.g:89:5: assertionAxiom
                    {
                    pushFollow(FOLLOW_assertionAxiom_in_axiom657);
                    assertionAxiom44=gOPPLScript.assertionAxiom();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_assertionAxiom.add(assertionAxiom44.getTree());


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
                    // 89:20: -> ^( assertionAxiom )
                    {
                        // OPPLParser.g:89:23: ^( assertionAxiom )
                        {
                        OPPLSyntaxTree root_1 = (OPPLSyntaxTree)adaptor.nil();
                        root_1 = (OPPLSyntaxTree)adaptor.becomeRoot(stream_assertionAxiom.nextNode(), root_1);

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 5 :
                    // OPPLParser.g:90:5: hasKeyAxiom
                    {
                    pushFollow(FOLLOW_hasKeyAxiom_in_axiom669);
                    hasKeyAxiom45=gOPPLScript.hasKeyAxiom();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_hasKeyAxiom.add(hasKeyAxiom45.getTree());


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
                    // 90:17: -> ^( hasKeyAxiom )
                    {
                        // OPPLParser.g:90:19: ^( hasKeyAxiom )
                        {
                        OPPLSyntaxTree root_1 = (OPPLSyntaxTree)adaptor.nil();
                        root_1 = (OPPLSyntaxTree)adaptor.becomeRoot(stream_hasKeyAxiom.nextNode(), root_1);

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 6 :
                    // OPPLParser.g:91:5: annotationAssertionAxiom
                    {
                    pushFollow(FOLLOW_annotationAssertionAxiom_in_axiom680);
                    annotationAssertionAxiom46=gOPPLScript.annotationAssertionAxiom();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_annotationAssertionAxiom.add(annotationAssertionAxiom46.getTree());


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
                    // 91:30: -> ^( annotationAssertionAxiom )
                    {
                        // OPPLParser.g:91:32: ^( annotationAssertionAxiom )
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

    public static class nAryAxiom_return extends ParserRuleReturnScope {
        OPPLSyntaxTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "nAryAxiom"
    // OPPLParser.g:96:1: nAryAxiom : ( DISJOINT_CLASSES opplFunction -> ^( DISJOINT_CLASSES opplFunction ) | DISJOINT_PROPERTIES opplFunction -> ^( DISJOINT_PROPERTIES opplFunction ) | SAME_INDIVIDUAL opplFunction -> ^( SAME_INDIVIDUAL opplFunction ) | DIFFERENT_INDIVIDUALS opplFunction -> ^( DIFFERENT_INDIVIDUALS opplFunction ) );
    public final OPPLScript_OPPLParser.nAryAxiom_return nAryAxiom() throws RecognitionException {
        OPPLScript_OPPLParser.nAryAxiom_return retval = new OPPLScript_OPPLParser.nAryAxiom_return();
        retval.start = input.LT(1);

        OPPLSyntaxTree root_0 = null;

        Token DISJOINT_CLASSES47=null;
        Token DISJOINT_PROPERTIES49=null;
        Token SAME_INDIVIDUAL51=null;
        Token DIFFERENT_INDIVIDUALS53=null;
        OPPLScript_OPPLParser.opplFunction_return opplFunction48 = null;

        OPPLScript_OPPLParser.opplFunction_return opplFunction50 = null;

        OPPLScript_OPPLParser.opplFunction_return opplFunction52 = null;

        OPPLScript_OPPLParser.opplFunction_return opplFunction54 = null;


        OPPLSyntaxTree DISJOINT_CLASSES47_tree=null;
        OPPLSyntaxTree DISJOINT_PROPERTIES49_tree=null;
        OPPLSyntaxTree SAME_INDIVIDUAL51_tree=null;
        OPPLSyntaxTree DIFFERENT_INDIVIDUALS53_tree=null;
        RewriteRuleTokenStream stream_SAME_INDIVIDUAL=new RewriteRuleTokenStream(adaptor,"token SAME_INDIVIDUAL");
        RewriteRuleTokenStream stream_DISJOINT_CLASSES=new RewriteRuleTokenStream(adaptor,"token DISJOINT_CLASSES");
        RewriteRuleTokenStream stream_DISJOINT_PROPERTIES=new RewriteRuleTokenStream(adaptor,"token DISJOINT_PROPERTIES");
        RewriteRuleTokenStream stream_DIFFERENT_INDIVIDUALS=new RewriteRuleTokenStream(adaptor,"token DIFFERENT_INDIVIDUALS");
        RewriteRuleSubtreeStream stream_opplFunction=new RewriteRuleSubtreeStream(adaptor,"rule opplFunction");
        try {
            // OPPLParser.g:97:2: ( DISJOINT_CLASSES opplFunction -> ^( DISJOINT_CLASSES opplFunction ) | DISJOINT_PROPERTIES opplFunction -> ^( DISJOINT_PROPERTIES opplFunction ) | SAME_INDIVIDUAL opplFunction -> ^( SAME_INDIVIDUAL opplFunction ) | DIFFERENT_INDIVIDUALS opplFunction -> ^( DIFFERENT_INDIVIDUALS opplFunction ) )
            int alt10=4;
            switch ( input.LA(1) ) {
            case DISJOINT_CLASSES:
                {
                alt10=1;
                }
                break;
            case DISJOINT_PROPERTIES:
                {
                alt10=2;
                }
                break;
            case SAME_INDIVIDUAL:
                {
                alt10=3;
                }
                break;
            case DIFFERENT_INDIVIDUALS:
                {
                alt10=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }

            switch (alt10) {
                case 1 :
                    // OPPLParser.g:98:3: DISJOINT_CLASSES opplFunction
                    {
                    DISJOINT_CLASSES47=(Token)match(input,DISJOINT_CLASSES,FOLLOW_DISJOINT_CLASSES_in_nAryAxiom702); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_DISJOINT_CLASSES.add(DISJOINT_CLASSES47);

                    pushFollow(FOLLOW_opplFunction_in_nAryAxiom704);
                    opplFunction48=opplFunction();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_opplFunction.add(opplFunction48.getTree());


                    // AST REWRITE
                    // elements: DISJOINT_CLASSES, opplFunction
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (OPPLSyntaxTree)adaptor.nil();
                    // 98:33: -> ^( DISJOINT_CLASSES opplFunction )
                    {
                        // OPPLParser.g:98:36: ^( DISJOINT_CLASSES opplFunction )
                        {
                        OPPLSyntaxTree root_1 = (OPPLSyntaxTree)adaptor.nil();
                        root_1 = (OPPLSyntaxTree)adaptor.becomeRoot(stream_DISJOINT_CLASSES.nextNode(), root_1);

                        adaptor.addChild(root_1, stream_opplFunction.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 2 :
                    // OPPLParser.g:99:5: DISJOINT_PROPERTIES opplFunction
                    {
                    DISJOINT_PROPERTIES49=(Token)match(input,DISJOINT_PROPERTIES,FOLLOW_DISJOINT_PROPERTIES_in_nAryAxiom718); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_DISJOINT_PROPERTIES.add(DISJOINT_PROPERTIES49);

                    pushFollow(FOLLOW_opplFunction_in_nAryAxiom720);
                    opplFunction50=opplFunction();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_opplFunction.add(opplFunction50.getTree());


                    // AST REWRITE
                    // elements: DISJOINT_PROPERTIES, opplFunction
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (OPPLSyntaxTree)adaptor.nil();
                    // 99:38: -> ^( DISJOINT_PROPERTIES opplFunction )
                    {
                        // OPPLParser.g:99:41: ^( DISJOINT_PROPERTIES opplFunction )
                        {
                        OPPLSyntaxTree root_1 = (OPPLSyntaxTree)adaptor.nil();
                        root_1 = (OPPLSyntaxTree)adaptor.becomeRoot(stream_DISJOINT_PROPERTIES.nextNode(), root_1);

                        adaptor.addChild(root_1, stream_opplFunction.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 3 :
                    // OPPLParser.g:100:5: SAME_INDIVIDUAL opplFunction
                    {
                    SAME_INDIVIDUAL51=(Token)match(input,SAME_INDIVIDUAL,FOLLOW_SAME_INDIVIDUAL_in_nAryAxiom734); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_SAME_INDIVIDUAL.add(SAME_INDIVIDUAL51);

                    pushFollow(FOLLOW_opplFunction_in_nAryAxiom736);
                    opplFunction52=opplFunction();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_opplFunction.add(opplFunction52.getTree());


                    // AST REWRITE
                    // elements: opplFunction, SAME_INDIVIDUAL
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (OPPLSyntaxTree)adaptor.nil();
                    // 100:34: -> ^( SAME_INDIVIDUAL opplFunction )
                    {
                        // OPPLParser.g:100:37: ^( SAME_INDIVIDUAL opplFunction )
                        {
                        OPPLSyntaxTree root_1 = (OPPLSyntaxTree)adaptor.nil();
                        root_1 = (OPPLSyntaxTree)adaptor.becomeRoot(stream_SAME_INDIVIDUAL.nextNode(), root_1);

                        adaptor.addChild(root_1, stream_opplFunction.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 4 :
                    // OPPLParser.g:101:5: DIFFERENT_INDIVIDUALS opplFunction
                    {
                    DIFFERENT_INDIVIDUALS53=(Token)match(input,DIFFERENT_INDIVIDUALS,FOLLOW_DIFFERENT_INDIVIDUALS_in_nAryAxiom750); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_DIFFERENT_INDIVIDUALS.add(DIFFERENT_INDIVIDUALS53);

                    pushFollow(FOLLOW_opplFunction_in_nAryAxiom752);
                    opplFunction54=opplFunction();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_opplFunction.add(opplFunction54.getTree());


                    // AST REWRITE
                    // elements: DIFFERENT_INDIVIDUALS, opplFunction
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (OPPLSyntaxTree)adaptor.nil();
                    // 101:40: -> ^( DIFFERENT_INDIVIDUALS opplFunction )
                    {
                        // OPPLParser.g:101:43: ^( DIFFERENT_INDIVIDUALS opplFunction )
                        {
                        OPPLSyntaxTree root_1 = (OPPLSyntaxTree)adaptor.nil();
                        root_1 = (OPPLSyntaxTree)adaptor.becomeRoot(stream_DIFFERENT_INDIVIDUALS.nextNode(), root_1);

                        adaptor.addChild(root_1, stream_opplFunction.nextTree());

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
    // $ANTLR end "nAryAxiom"

    public static class constraint_return extends ParserRuleReturnScope {
        OPPLSyntaxTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "constraint"
    // OPPLParser.g:105:2: constraint : (first= VARIABLE_NAME NOT_EQUAL second= expression -> ^( INEQUALITY_CONSTRAINT IDENTIFIER[$first] ^( EXPRESSION $second) ) | VARIABLE_NAME IN OPEN_CURLY_BRACES atomic ( COMMA atomic )* CLOSED_CURLY_BRACES -> ^( IN_SET_CONSTRAINT IDENTIFIER[$VARIABLE_NAME] ( atomic )+ ) | VARIABLE_NAME MATCH OPEN_PARENTHESYS stringOperation CLOSED_PARENTHESYS -> ^( REGEXP_CONSTRAINT IDENTIFIER[$VARIABLE_NAME] stringOperation ) | FAIL axiom -> ^( NAF_CONSTRAINT axiom ) );
    public final OPPLScript_OPPLParser.constraint_return constraint() throws RecognitionException {
        OPPLScript_OPPLParser.constraint_return retval = new OPPLScript_OPPLParser.constraint_return();
        retval.start = input.LT(1);

        OPPLSyntaxTree root_0 = null;

        Token first=null;
        Token NOT_EQUAL55=null;
        Token VARIABLE_NAME56=null;
        Token IN57=null;
        Token OPEN_CURLY_BRACES58=null;
        Token COMMA60=null;
        Token CLOSED_CURLY_BRACES62=null;
        Token VARIABLE_NAME63=null;
        Token MATCH64=null;
        Token OPEN_PARENTHESYS65=null;
        Token CLOSED_PARENTHESYS67=null;
        Token FAIL68=null;
        OPPLScript_OPPLParser_MOWLParser.expression_return second = null;

        OPPLScript_OPPLParser.atomic_return atomic59 = null;

        OPPLScript_OPPLParser.atomic_return atomic61 = null;

        OPPLScript_OPPLParser.stringOperation_return stringOperation66 = null;

        OPPLScript_OPPLParser.axiom_return axiom69 = null;


        OPPLSyntaxTree first_tree=null;
        OPPLSyntaxTree NOT_EQUAL55_tree=null;
        OPPLSyntaxTree VARIABLE_NAME56_tree=null;
        OPPLSyntaxTree IN57_tree=null;
        OPPLSyntaxTree OPEN_CURLY_BRACES58_tree=null;
        OPPLSyntaxTree COMMA60_tree=null;
        OPPLSyntaxTree CLOSED_CURLY_BRACES62_tree=null;
        OPPLSyntaxTree VARIABLE_NAME63_tree=null;
        OPPLSyntaxTree MATCH64_tree=null;
        OPPLSyntaxTree OPEN_PARENTHESYS65_tree=null;
        OPPLSyntaxTree CLOSED_PARENTHESYS67_tree=null;
        OPPLSyntaxTree FAIL68_tree=null;
        RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
        RewriteRuleTokenStream stream_NOT_EQUAL=new RewriteRuleTokenStream(adaptor,"token NOT_EQUAL");
        RewriteRuleTokenStream stream_OPEN_CURLY_BRACES=new RewriteRuleTokenStream(adaptor,"token OPEN_CURLY_BRACES");
        RewriteRuleTokenStream stream_CLOSED_CURLY_BRACES=new RewriteRuleTokenStream(adaptor,"token CLOSED_CURLY_BRACES");
        RewriteRuleTokenStream stream_FAIL=new RewriteRuleTokenStream(adaptor,"token FAIL");
        RewriteRuleTokenStream stream_MATCH=new RewriteRuleTokenStream(adaptor,"token MATCH");
        RewriteRuleTokenStream stream_CLOSED_PARENTHESYS=new RewriteRuleTokenStream(adaptor,"token CLOSED_PARENTHESYS");
        RewriteRuleTokenStream stream_OPEN_PARENTHESYS=new RewriteRuleTokenStream(adaptor,"token OPEN_PARENTHESYS");
        RewriteRuleTokenStream stream_VARIABLE_NAME=new RewriteRuleTokenStream(adaptor,"token VARIABLE_NAME");
        RewriteRuleTokenStream stream_IN=new RewriteRuleTokenStream(adaptor,"token IN");
        RewriteRuleSubtreeStream stream_stringOperation=new RewriteRuleSubtreeStream(adaptor,"rule stringOperation");
        RewriteRuleSubtreeStream stream_axiom=new RewriteRuleSubtreeStream(adaptor,"rule axiom");
        RewriteRuleSubtreeStream stream_atomic=new RewriteRuleSubtreeStream(adaptor,"rule atomic");
        RewriteRuleSubtreeStream stream_expression=new RewriteRuleSubtreeStream(adaptor,"rule expression");
        try {
            // OPPLParser.g:106:3: (first= VARIABLE_NAME NOT_EQUAL second= expression -> ^( INEQUALITY_CONSTRAINT IDENTIFIER[$first] ^( EXPRESSION $second) ) | VARIABLE_NAME IN OPEN_CURLY_BRACES atomic ( COMMA atomic )* CLOSED_CURLY_BRACES -> ^( IN_SET_CONSTRAINT IDENTIFIER[$VARIABLE_NAME] ( atomic )+ ) | VARIABLE_NAME MATCH OPEN_PARENTHESYS stringOperation CLOSED_PARENTHESYS -> ^( REGEXP_CONSTRAINT IDENTIFIER[$VARIABLE_NAME] stringOperation ) | FAIL axiom -> ^( NAF_CONSTRAINT axiom ) )
            int alt12=4;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==VARIABLE_NAME) ) {
                switch ( input.LA(2) ) {
                case NOT_EQUAL:
                    {
                    alt12=1;
                    }
                    break;
                case IN:
                    {
                    alt12=2;
                    }
                    break;
                case MATCH:
                    {
                    alt12=3;
                    }
                    break;
                default:
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 12, 1, input);

                    throw nvae;
                }

            }
            else if ( (LA12_0==FAIL) ) {
                alt12=4;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;
            }
            switch (alt12) {
                case 1 :
                    // OPPLParser.g:107:8: first= VARIABLE_NAME NOT_EQUAL second= expression
                    {
                    first=(Token)match(input,VARIABLE_NAME,FOLLOW_VARIABLE_NAME_in_constraint787); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_VARIABLE_NAME.add(first);

                    NOT_EQUAL55=(Token)match(input,NOT_EQUAL,FOLLOW_NOT_EQUAL_in_constraint789); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_NOT_EQUAL.add(NOT_EQUAL55);

                    pushFollow(FOLLOW_expression_in_constraint795);
                    second=gOPPLScript.expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_expression.add(second.getTree());


                    // AST REWRITE
                    // elements: second
                    // token labels: 
                    // rule labels: retval, second
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
                    RewriteRuleSubtreeStream stream_second=new RewriteRuleSubtreeStream(adaptor,"rule second",second!=null?second.tree:null);

                    root_0 = (OPPLSyntaxTree)adaptor.nil();
                    // 107:60: -> ^( INEQUALITY_CONSTRAINT IDENTIFIER[$first] ^( EXPRESSION $second) )
                    {
                        // OPPLParser.g:107:63: ^( INEQUALITY_CONSTRAINT IDENTIFIER[$first] ^( EXPRESSION $second) )
                        {
                        OPPLSyntaxTree root_1 = (OPPLSyntaxTree)adaptor.nil();
                        root_1 = (OPPLSyntaxTree)adaptor.becomeRoot((OPPLSyntaxTree)adaptor.create(INEQUALITY_CONSTRAINT, "INEQUALITY_CONSTRAINT"), root_1);

                        adaptor.addChild(root_1, (OPPLSyntaxTree)adaptor.create(IDENTIFIER, first));
                        // OPPLParser.g:107:106: ^( EXPRESSION $second)
                        {
                        OPPLSyntaxTree root_2 = (OPPLSyntaxTree)adaptor.nil();
                        root_2 = (OPPLSyntaxTree)adaptor.becomeRoot((OPPLSyntaxTree)adaptor.create(EXPRESSION, "EXPRESSION"), root_2);

                        adaptor.addChild(root_2, stream_second.nextTree());

                        adaptor.addChild(root_1, root_2);
                        }

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 2 :
                    // OPPLParser.g:108:8: VARIABLE_NAME IN OPEN_CURLY_BRACES atomic ( COMMA atomic )* CLOSED_CURLY_BRACES
                    {
                    VARIABLE_NAME56=(Token)match(input,VARIABLE_NAME,FOLLOW_VARIABLE_NAME_in_constraint820); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_VARIABLE_NAME.add(VARIABLE_NAME56);

                    IN57=(Token)match(input,IN,FOLLOW_IN_in_constraint822); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_IN.add(IN57);

                    OPEN_CURLY_BRACES58=(Token)match(input,OPEN_CURLY_BRACES,FOLLOW_OPEN_CURLY_BRACES_in_constraint824); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_OPEN_CURLY_BRACES.add(OPEN_CURLY_BRACES58);

                    pushFollow(FOLLOW_atomic_in_constraint826);
                    atomic59=atomic();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_atomic.add(atomic59.getTree());
                    // OPPLParser.g:108:50: ( COMMA atomic )*
                    loop11:
                    do {
                        int alt11=2;
                        int LA11_0 = input.LA(1);

                        if ( (LA11_0==COMMA) ) {
                            alt11=1;
                        }


                        switch (alt11) {
                    	case 1 :
                    	    // OPPLParser.g:108:51: COMMA atomic
                    	    {
                    	    COMMA60=(Token)match(input,COMMA,FOLLOW_COMMA_in_constraint829); if (state.failed) return retval; 
                    	    if ( state.backtracking==0 ) stream_COMMA.add(COMMA60);

                    	    pushFollow(FOLLOW_atomic_in_constraint831);
                    	    atomic61=atomic();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) stream_atomic.add(atomic61.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop11;
                        }
                    } while (true);

                    CLOSED_CURLY_BRACES62=(Token)match(input,CLOSED_CURLY_BRACES,FOLLOW_CLOSED_CURLY_BRACES_in_constraint835); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_CLOSED_CURLY_BRACES.add(CLOSED_CURLY_BRACES62);



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
                    // 108:87: -> ^( IN_SET_CONSTRAINT IDENTIFIER[$VARIABLE_NAME] ( atomic )+ )
                    {
                        // OPPLParser.g:108:90: ^( IN_SET_CONSTRAINT IDENTIFIER[$VARIABLE_NAME] ( atomic )+ )
                        {
                        OPPLSyntaxTree root_1 = (OPPLSyntaxTree)adaptor.nil();
                        root_1 = (OPPLSyntaxTree)adaptor.becomeRoot((OPPLSyntaxTree)adaptor.create(IN_SET_CONSTRAINT, "IN_SET_CONSTRAINT"), root_1);

                        adaptor.addChild(root_1, (OPPLSyntaxTree)adaptor.create(IDENTIFIER, VARIABLE_NAME56));
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
                    break;
                case 3 :
                    // OPPLParser.g:109:8: VARIABLE_NAME MATCH OPEN_PARENTHESYS stringOperation CLOSED_PARENTHESYS
                    {
                    VARIABLE_NAME63=(Token)match(input,VARIABLE_NAME,FOLLOW_VARIABLE_NAME_in_constraint857); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_VARIABLE_NAME.add(VARIABLE_NAME63);

                    MATCH64=(Token)match(input,MATCH,FOLLOW_MATCH_in_constraint859); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_MATCH.add(MATCH64);

                    OPEN_PARENTHESYS65=(Token)match(input,OPEN_PARENTHESYS,FOLLOW_OPEN_PARENTHESYS_in_constraint861); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_OPEN_PARENTHESYS.add(OPEN_PARENTHESYS65);

                    pushFollow(FOLLOW_stringOperation_in_constraint863);
                    stringOperation66=stringOperation();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_stringOperation.add(stringOperation66.getTree());
                    CLOSED_PARENTHESYS67=(Token)match(input,CLOSED_PARENTHESYS,FOLLOW_CLOSED_PARENTHESYS_in_constraint865); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_CLOSED_PARENTHESYS.add(CLOSED_PARENTHESYS67);



                    // AST REWRITE
                    // elements: stringOperation
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (OPPLSyntaxTree)adaptor.nil();
                    // 109:80: -> ^( REGEXP_CONSTRAINT IDENTIFIER[$VARIABLE_NAME] stringOperation )
                    {
                        // OPPLParser.g:109:83: ^( REGEXP_CONSTRAINT IDENTIFIER[$VARIABLE_NAME] stringOperation )
                        {
                        OPPLSyntaxTree root_1 = (OPPLSyntaxTree)adaptor.nil();
                        root_1 = (OPPLSyntaxTree)adaptor.becomeRoot((OPPLSyntaxTree)adaptor.create(REGEXP_CONSTRAINT, "REGEXP_CONSTRAINT"), root_1);

                        adaptor.addChild(root_1, (OPPLSyntaxTree)adaptor.create(IDENTIFIER, VARIABLE_NAME63));
                        adaptor.addChild(root_1, stream_stringOperation.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 4 :
                    // OPPLParser.g:110:7: FAIL axiom
                    {
                    FAIL68=(Token)match(input,FAIL,FOLLOW_FAIL_in_constraint884); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_FAIL.add(FAIL68);

                    pushFollow(FOLLOW_axiom_in_constraint886);
                    axiom69=axiom();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_axiom.add(axiom69.getTree());


                    // AST REWRITE
                    // elements: axiom
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (OPPLSyntaxTree)adaptor.nil();
                    // 110:18: -> ^( NAF_CONSTRAINT axiom )
                    {
                        // OPPLParser.g:110:21: ^( NAF_CONSTRAINT axiom )
                        {
                        OPPLSyntaxTree root_1 = (OPPLSyntaxTree)adaptor.nil();
                        root_1 = (OPPLSyntaxTree)adaptor.becomeRoot((OPPLSyntaxTree)adaptor.create(NAF_CONSTRAINT, "NAF_CONSTRAINT"), root_1);

                        adaptor.addChild(root_1, stream_axiom.nextTree());

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
    // $ANTLR end "constraint"

    public static class actions_return extends ParserRuleReturnScope {
        OPPLSyntaxTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "actions"
    // OPPLParser.g:113:2: actions : BEGIN action ( COMMA action )* END -> ^( ACTIONS ( action )+ ) ;
    public final OPPLScript_OPPLParser.actions_return actions() throws RecognitionException {
        OPPLScript_OPPLParser.actions_return retval = new OPPLScript_OPPLParser.actions_return();
        retval.start = input.LT(1);

        OPPLSyntaxTree root_0 = null;

        Token BEGIN70=null;
        Token COMMA72=null;
        Token END74=null;
        OPPLScript_OPPLParser.action_return action71 = null;

        OPPLScript_OPPLParser.action_return action73 = null;


        OPPLSyntaxTree BEGIN70_tree=null;
        OPPLSyntaxTree COMMA72_tree=null;
        OPPLSyntaxTree END74_tree=null;
        RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
        RewriteRuleTokenStream stream_END=new RewriteRuleTokenStream(adaptor,"token END");
        RewriteRuleTokenStream stream_BEGIN=new RewriteRuleTokenStream(adaptor,"token BEGIN");
        RewriteRuleSubtreeStream stream_action=new RewriteRuleSubtreeStream(adaptor,"rule action");
        try {
            // OPPLParser.g:114:3: ( BEGIN action ( COMMA action )* END -> ^( ACTIONS ( action )+ ) )
            // OPPLParser.g:115:5: BEGIN action ( COMMA action )* END
            {
            BEGIN70=(Token)match(input,BEGIN,FOLLOW_BEGIN_in_actions914); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_BEGIN.add(BEGIN70);

            pushFollow(FOLLOW_action_in_actions916);
            action71=action();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_action.add(action71.getTree());
            // OPPLParser.g:115:18: ( COMMA action )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==COMMA) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // OPPLParser.g:115:19: COMMA action
            	    {
            	    COMMA72=(Token)match(input,COMMA,FOLLOW_COMMA_in_actions919); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_COMMA.add(COMMA72);

            	    pushFollow(FOLLOW_action_in_actions921);
            	    action73=action();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_action.add(action73.getTree());

            	    }
            	    break;

            	default :
            	    break loop13;
                }
            } while (true);

            END74=(Token)match(input,END,FOLLOW_END_in_actions925); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_END.add(END74);



            // AST REWRITE
            // elements: action
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (OPPLSyntaxTree)adaptor.nil();
            // 115:38: -> ^( ACTIONS ( action )+ )
            {
                // OPPLParser.g:115:41: ^( ACTIONS ( action )+ )
                {
                OPPLSyntaxTree root_1 = (OPPLSyntaxTree)adaptor.nil();
                root_1 = (OPPLSyntaxTree)adaptor.becomeRoot((OPPLSyntaxTree)adaptor.create(ACTIONS, "ACTIONS"), root_1);

                if ( !(stream_action.hasNext()) ) {
                    throw new RewriteEarlyExitException();
                }
                while ( stream_action.hasNext() ) {
                    adaptor.addChild(root_1, stream_action.nextTree());

                }
                stream_action.reset();

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
    // $ANTLR end "actions"

    public static class action_return extends ParserRuleReturnScope {
        OPPLSyntaxTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "action"
    // OPPLParser.g:118:2: action : ( ADD axiom -> ^( ADD axiom ) | REMOVE axiom -> ^( REMOVE axiom ) );
    public final OPPLScript_OPPLParser.action_return action() throws RecognitionException {
        OPPLScript_OPPLParser.action_return retval = new OPPLScript_OPPLParser.action_return();
        retval.start = input.LT(1);

        OPPLSyntaxTree root_0 = null;

        Token ADD75=null;
        Token REMOVE77=null;
        OPPLScript_OPPLParser.axiom_return axiom76 = null;

        OPPLScript_OPPLParser.axiom_return axiom78 = null;


        OPPLSyntaxTree ADD75_tree=null;
        OPPLSyntaxTree REMOVE77_tree=null;
        RewriteRuleTokenStream stream_REMOVE=new RewriteRuleTokenStream(adaptor,"token REMOVE");
        RewriteRuleTokenStream stream_ADD=new RewriteRuleTokenStream(adaptor,"token ADD");
        RewriteRuleSubtreeStream stream_axiom=new RewriteRuleSubtreeStream(adaptor,"rule axiom");
        try {
            // OPPLParser.g:119:3: ( ADD axiom -> ^( ADD axiom ) | REMOVE axiom -> ^( REMOVE axiom ) )
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==ADD) ) {
                alt14=1;
            }
            else if ( (LA14_0==REMOVE) ) {
                alt14=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 14, 0, input);

                throw nvae;
            }
            switch (alt14) {
                case 1 :
                    // OPPLParser.g:120:7: ADD axiom
                    {
                    ADD75=(Token)match(input,ADD,FOLLOW_ADD_in_action957); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_ADD.add(ADD75);

                    pushFollow(FOLLOW_axiom_in_action959);
                    axiom76=axiom();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_axiom.add(axiom76.getTree());


                    // AST REWRITE
                    // elements: ADD, axiom
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (OPPLSyntaxTree)adaptor.nil();
                    // 120:17: -> ^( ADD axiom )
                    {
                        // OPPLParser.g:120:20: ^( ADD axiom )
                        {
                        OPPLSyntaxTree root_1 = (OPPLSyntaxTree)adaptor.nil();
                        root_1 = (OPPLSyntaxTree)adaptor.becomeRoot(stream_ADD.nextNode(), root_1);

                        adaptor.addChild(root_1, stream_axiom.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 2 :
                    // OPPLParser.g:121:7: REMOVE axiom
                    {
                    REMOVE77=(Token)match(input,REMOVE,FOLLOW_REMOVE_in_action975); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_REMOVE.add(REMOVE77);

                    pushFollow(FOLLOW_axiom_in_action977);
                    axiom78=axiom();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_axiom.add(axiom78.getTree());


                    // AST REWRITE
                    // elements: axiom, REMOVE
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (OPPLSyntaxTree)adaptor.nil();
                    // 121:20: -> ^( REMOVE axiom )
                    {
                        // OPPLParser.g:121:23: ^( REMOVE axiom )
                        {
                        OPPLSyntaxTree root_1 = (OPPLSyntaxTree)adaptor.nil();
                        root_1 = (OPPLSyntaxTree)adaptor.becomeRoot(stream_REMOVE.nextNode(), root_1);

                        adaptor.addChild(root_1, stream_axiom.nextTree());

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
    // $ANTLR end "action"

    public static class opplFunction_return extends ParserRuleReturnScope {
        OPPLSyntaxTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "opplFunction"
    // OPPLParser.g:127:1: opplFunction : ( CREATE OPEN_PARENTHESYS stringOperation CLOSED_PARENTHESYS -> ^( CREATE_OPPL_FUNCTION stringOperation ) | CREATE_INTERSECTION OPEN_PARENTHESYS atomic ( COMMA atomic )* CLOSED_PARENTHESYS -> ^( CREATE_INTERSECTION ( atomic )+ ) | CREATE_DISJUNCTION OPEN_PARENTHESYS atomic CLOSED_PARENTHESYS -> ^( CREATE_DISJUNCTION atomic ) | SET OPEN_PARENTHESYS atomic ( COMMA atomic )* CLOSED_PARENTHESYS -> ^( EXPRESSION ^( SET ( atomic )* ) ) );
    public final OPPLScript_OPPLParser.opplFunction_return opplFunction() throws RecognitionException {
        OPPLScript_OPPLParser.opplFunction_return retval = new OPPLScript_OPPLParser.opplFunction_return();
        retval.start = input.LT(1);

        OPPLSyntaxTree root_0 = null;

        Token CREATE79=null;
        Token OPEN_PARENTHESYS80=null;
        Token CLOSED_PARENTHESYS82=null;
        Token CREATE_INTERSECTION83=null;
        Token OPEN_PARENTHESYS84=null;
        Token COMMA86=null;
        Token CLOSED_PARENTHESYS88=null;
        Token CREATE_DISJUNCTION89=null;
        Token OPEN_PARENTHESYS90=null;
        Token CLOSED_PARENTHESYS92=null;
        Token SET93=null;
        Token OPEN_PARENTHESYS94=null;
        Token COMMA96=null;
        Token CLOSED_PARENTHESYS98=null;
        OPPLScript_OPPLParser.stringOperation_return stringOperation81 = null;

        OPPLScript_OPPLParser.atomic_return atomic85 = null;

        OPPLScript_OPPLParser.atomic_return atomic87 = null;

        OPPLScript_OPPLParser.atomic_return atomic91 = null;

        OPPLScript_OPPLParser.atomic_return atomic95 = null;

        OPPLScript_OPPLParser.atomic_return atomic97 = null;


        OPPLSyntaxTree CREATE79_tree=null;
        OPPLSyntaxTree OPEN_PARENTHESYS80_tree=null;
        OPPLSyntaxTree CLOSED_PARENTHESYS82_tree=null;
        OPPLSyntaxTree CREATE_INTERSECTION83_tree=null;
        OPPLSyntaxTree OPEN_PARENTHESYS84_tree=null;
        OPPLSyntaxTree COMMA86_tree=null;
        OPPLSyntaxTree CLOSED_PARENTHESYS88_tree=null;
        OPPLSyntaxTree CREATE_DISJUNCTION89_tree=null;
        OPPLSyntaxTree OPEN_PARENTHESYS90_tree=null;
        OPPLSyntaxTree CLOSED_PARENTHESYS92_tree=null;
        OPPLSyntaxTree SET93_tree=null;
        OPPLSyntaxTree OPEN_PARENTHESYS94_tree=null;
        OPPLSyntaxTree COMMA96_tree=null;
        OPPLSyntaxTree CLOSED_PARENTHESYS98_tree=null;
        RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
        RewriteRuleTokenStream stream_SET=new RewriteRuleTokenStream(adaptor,"token SET");
        RewriteRuleTokenStream stream_CREATE_INTERSECTION=new RewriteRuleTokenStream(adaptor,"token CREATE_INTERSECTION");
        RewriteRuleTokenStream stream_CLOSED_PARENTHESYS=new RewriteRuleTokenStream(adaptor,"token CLOSED_PARENTHESYS");
        RewriteRuleTokenStream stream_OPEN_PARENTHESYS=new RewriteRuleTokenStream(adaptor,"token OPEN_PARENTHESYS");
        RewriteRuleTokenStream stream_CREATE_DISJUNCTION=new RewriteRuleTokenStream(adaptor,"token CREATE_DISJUNCTION");
        RewriteRuleTokenStream stream_CREATE=new RewriteRuleTokenStream(adaptor,"token CREATE");
        RewriteRuleSubtreeStream stream_stringOperation=new RewriteRuleSubtreeStream(adaptor,"rule stringOperation");
        RewriteRuleSubtreeStream stream_atomic=new RewriteRuleSubtreeStream(adaptor,"rule atomic");
        try {
            // OPPLParser.g:128:3: ( CREATE OPEN_PARENTHESYS stringOperation CLOSED_PARENTHESYS -> ^( CREATE_OPPL_FUNCTION stringOperation ) | CREATE_INTERSECTION OPEN_PARENTHESYS atomic ( COMMA atomic )* CLOSED_PARENTHESYS -> ^( CREATE_INTERSECTION ( atomic )+ ) | CREATE_DISJUNCTION OPEN_PARENTHESYS atomic CLOSED_PARENTHESYS -> ^( CREATE_DISJUNCTION atomic ) | SET OPEN_PARENTHESYS atomic ( COMMA atomic )* CLOSED_PARENTHESYS -> ^( EXPRESSION ^( SET ( atomic )* ) ) )
            int alt17=4;
            switch ( input.LA(1) ) {
            case CREATE:
                {
                alt17=1;
                }
                break;
            case CREATE_INTERSECTION:
                {
                alt17=2;
                }
                break;
            case CREATE_DISJUNCTION:
                {
                alt17=3;
                }
                break;
            case SET:
                {
                alt17=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 17, 0, input);

                throw nvae;
            }

            switch (alt17) {
                case 1 :
                    // OPPLParser.g:129:7: CREATE OPEN_PARENTHESYS stringOperation CLOSED_PARENTHESYS
                    {
                    CREATE79=(Token)match(input,CREATE,FOLLOW_CREATE_in_opplFunction1010); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_CREATE.add(CREATE79);

                    OPEN_PARENTHESYS80=(Token)match(input,OPEN_PARENTHESYS,FOLLOW_OPEN_PARENTHESYS_in_opplFunction1012); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_OPEN_PARENTHESYS.add(OPEN_PARENTHESYS80);

                    pushFollow(FOLLOW_stringOperation_in_opplFunction1014);
                    stringOperation81=stringOperation();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_stringOperation.add(stringOperation81.getTree());
                    CLOSED_PARENTHESYS82=(Token)match(input,CLOSED_PARENTHESYS,FOLLOW_CLOSED_PARENTHESYS_in_opplFunction1016); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_CLOSED_PARENTHESYS.add(CLOSED_PARENTHESYS82);



                    // AST REWRITE
                    // elements: stringOperation
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (OPPLSyntaxTree)adaptor.nil();
                    // 129:66: -> ^( CREATE_OPPL_FUNCTION stringOperation )
                    {
                        // OPPLParser.g:129:69: ^( CREATE_OPPL_FUNCTION stringOperation )
                        {
                        OPPLSyntaxTree root_1 = (OPPLSyntaxTree)adaptor.nil();
                        root_1 = (OPPLSyntaxTree)adaptor.becomeRoot((OPPLSyntaxTree)adaptor.create(CREATE_OPPL_FUNCTION, "CREATE_OPPL_FUNCTION"), root_1);

                        adaptor.addChild(root_1, stream_stringOperation.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 2 :
                    // OPPLParser.g:130:7: CREATE_INTERSECTION OPEN_PARENTHESYS atomic ( COMMA atomic )* CLOSED_PARENTHESYS
                    {
                    CREATE_INTERSECTION83=(Token)match(input,CREATE_INTERSECTION,FOLLOW_CREATE_INTERSECTION_in_opplFunction1032); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_CREATE_INTERSECTION.add(CREATE_INTERSECTION83);

                    OPEN_PARENTHESYS84=(Token)match(input,OPEN_PARENTHESYS,FOLLOW_OPEN_PARENTHESYS_in_opplFunction1035); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_OPEN_PARENTHESYS.add(OPEN_PARENTHESYS84);

                    pushFollow(FOLLOW_atomic_in_opplFunction1037);
                    atomic85=atomic();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_atomic.add(atomic85.getTree());
                    // OPPLParser.g:130:52: ( COMMA atomic )*
                    loop15:
                    do {
                        int alt15=2;
                        int LA15_0 = input.LA(1);

                        if ( (LA15_0==COMMA) ) {
                            alt15=1;
                        }


                        switch (alt15) {
                    	case 1 :
                    	    // OPPLParser.g:130:53: COMMA atomic
                    	    {
                    	    COMMA86=(Token)match(input,COMMA,FOLLOW_COMMA_in_opplFunction1040); if (state.failed) return retval; 
                    	    if ( state.backtracking==0 ) stream_COMMA.add(COMMA86);

                    	    pushFollow(FOLLOW_atomic_in_opplFunction1042);
                    	    atomic87=atomic();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) stream_atomic.add(atomic87.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop15;
                        }
                    } while (true);

                    CLOSED_PARENTHESYS88=(Token)match(input,CLOSED_PARENTHESYS,FOLLOW_CLOSED_PARENTHESYS_in_opplFunction1047); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_CLOSED_PARENTHESYS.add(CLOSED_PARENTHESYS88);



                    // AST REWRITE
                    // elements: CREATE_INTERSECTION, atomic
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (OPPLSyntaxTree)adaptor.nil();
                    // 130:88: -> ^( CREATE_INTERSECTION ( atomic )+ )
                    {
                        // OPPLParser.g:130:91: ^( CREATE_INTERSECTION ( atomic )+ )
                        {
                        OPPLSyntaxTree root_1 = (OPPLSyntaxTree)adaptor.nil();
                        root_1 = (OPPLSyntaxTree)adaptor.becomeRoot(stream_CREATE_INTERSECTION.nextNode(), root_1);

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
                    break;
                case 3 :
                    // OPPLParser.g:131:7: CREATE_DISJUNCTION OPEN_PARENTHESYS atomic CLOSED_PARENTHESYS
                    {
                    CREATE_DISJUNCTION89=(Token)match(input,CREATE_DISJUNCTION,FOLLOW_CREATE_DISJUNCTION_in_opplFunction1064); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_CREATE_DISJUNCTION.add(CREATE_DISJUNCTION89);

                    OPEN_PARENTHESYS90=(Token)match(input,OPEN_PARENTHESYS,FOLLOW_OPEN_PARENTHESYS_in_opplFunction1066); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_OPEN_PARENTHESYS.add(OPEN_PARENTHESYS90);

                    pushFollow(FOLLOW_atomic_in_opplFunction1068);
                    atomic91=atomic();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_atomic.add(atomic91.getTree());
                    CLOSED_PARENTHESYS92=(Token)match(input,CLOSED_PARENTHESYS,FOLLOW_CLOSED_PARENTHESYS_in_opplFunction1070); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_CLOSED_PARENTHESYS.add(CLOSED_PARENTHESYS92);



                    // AST REWRITE
                    // elements: atomic, CREATE_DISJUNCTION
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (OPPLSyntaxTree)adaptor.nil();
                    // 131:69: -> ^( CREATE_DISJUNCTION atomic )
                    {
                        // OPPLParser.g:131:72: ^( CREATE_DISJUNCTION atomic )
                        {
                        OPPLSyntaxTree root_1 = (OPPLSyntaxTree)adaptor.nil();
                        root_1 = (OPPLSyntaxTree)adaptor.becomeRoot(stream_CREATE_DISJUNCTION.nextNode(), root_1);

                        adaptor.addChild(root_1, stream_atomic.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 4 :
                    // OPPLParser.g:132:7: SET OPEN_PARENTHESYS atomic ( COMMA atomic )* CLOSED_PARENTHESYS
                    {
                    SET93=(Token)match(input,SET,FOLLOW_SET_in_opplFunction1086); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_SET.add(SET93);

                    OPEN_PARENTHESYS94=(Token)match(input,OPEN_PARENTHESYS,FOLLOW_OPEN_PARENTHESYS_in_opplFunction1088); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_OPEN_PARENTHESYS.add(OPEN_PARENTHESYS94);

                    pushFollow(FOLLOW_atomic_in_opplFunction1090);
                    atomic95=atomic();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_atomic.add(atomic95.getTree());
                    // OPPLParser.g:132:35: ( COMMA atomic )*
                    loop16:
                    do {
                        int alt16=2;
                        int LA16_0 = input.LA(1);

                        if ( (LA16_0==COMMA) ) {
                            alt16=1;
                        }


                        switch (alt16) {
                    	case 1 :
                    	    // OPPLParser.g:132:36: COMMA atomic
                    	    {
                    	    COMMA96=(Token)match(input,COMMA,FOLLOW_COMMA_in_opplFunction1093); if (state.failed) return retval; 
                    	    if ( state.backtracking==0 ) stream_COMMA.add(COMMA96);

                    	    pushFollow(FOLLOW_atomic_in_opplFunction1095);
                    	    atomic97=atomic();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) stream_atomic.add(atomic97.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop16;
                        }
                    } while (true);

                    CLOSED_PARENTHESYS98=(Token)match(input,CLOSED_PARENTHESYS,FOLLOW_CLOSED_PARENTHESYS_in_opplFunction1099); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_CLOSED_PARENTHESYS.add(CLOSED_PARENTHESYS98);



                    // AST REWRITE
                    // elements: atomic, SET
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (OPPLSyntaxTree)adaptor.nil();
                    // 132:70: -> ^( EXPRESSION ^( SET ( atomic )* ) )
                    {
                        // OPPLParser.g:132:73: ^( EXPRESSION ^( SET ( atomic )* ) )
                        {
                        OPPLSyntaxTree root_1 = (OPPLSyntaxTree)adaptor.nil();
                        root_1 = (OPPLSyntaxTree)adaptor.becomeRoot((OPPLSyntaxTree)adaptor.create(EXPRESSION, "EXPRESSION"), root_1);

                        // OPPLParser.g:132:86: ^( SET ( atomic )* )
                        {
                        OPPLSyntaxTree root_2 = (OPPLSyntaxTree)adaptor.nil();
                        root_2 = (OPPLSyntaxTree)adaptor.becomeRoot(stream_SET.nextNode(), root_2);

                        // OPPLParser.g:132:92: ( atomic )*
                        while ( stream_atomic.hasNext() ) {
                            adaptor.addChild(root_2, stream_atomic.nextTree());

                        }
                        stream_atomic.reset();

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
    // $ANTLR end "opplFunction"

    public static class stringOperation_return extends ParserRuleReturnScope {
        OPPLSyntaxTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "stringOperation"
    // OPPLParser.g:135:1: stringOperation : stringExpression ( PLUS stringExpression )* -> ^( STRING_OPERATION ( stringExpression )+ ) ;
    public final OPPLScript_OPPLParser.stringOperation_return stringOperation() throws RecognitionException {
        OPPLScript_OPPLParser.stringOperation_return retval = new OPPLScript_OPPLParser.stringOperation_return();
        retval.start = input.LT(1);

        OPPLSyntaxTree root_0 = null;

        Token PLUS100=null;
        OPPLScript_OPPLParser.stringExpression_return stringExpression99 = null;

        OPPLScript_OPPLParser.stringExpression_return stringExpression101 = null;


        OPPLSyntaxTree PLUS100_tree=null;
        RewriteRuleTokenStream stream_PLUS=new RewriteRuleTokenStream(adaptor,"token PLUS");
        RewriteRuleSubtreeStream stream_stringExpression=new RewriteRuleSubtreeStream(adaptor,"rule stringExpression");
        try {
            // OPPLParser.g:136:3: ( stringExpression ( PLUS stringExpression )* -> ^( STRING_OPERATION ( stringExpression )+ ) )
            // OPPLParser.g:137:5: stringExpression ( PLUS stringExpression )*
            {
            pushFollow(FOLLOW_stringExpression_in_stringOperation1129);
            stringExpression99=stringExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_stringExpression.add(stringExpression99.getTree());
            // OPPLParser.g:137:22: ( PLUS stringExpression )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==PLUS) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // OPPLParser.g:137:23: PLUS stringExpression
            	    {
            	    PLUS100=(Token)match(input,PLUS,FOLLOW_PLUS_in_stringOperation1132); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_PLUS.add(PLUS100);

            	    pushFollow(FOLLOW_stringExpression_in_stringOperation1134);
            	    stringExpression101=stringExpression();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_stringExpression.add(stringExpression101.getTree());

            	    }
            	    break;

            	default :
            	    break loop18;
                }
            } while (true);



            // AST REWRITE
            // elements: stringExpression
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (OPPLSyntaxTree)adaptor.nil();
            // 137:47: -> ^( STRING_OPERATION ( stringExpression )+ )
            {
                // OPPLParser.g:137:50: ^( STRING_OPERATION ( stringExpression )+ )
                {
                OPPLSyntaxTree root_1 = (OPPLSyntaxTree)adaptor.nil();
                root_1 = (OPPLSyntaxTree)adaptor.becomeRoot((OPPLSyntaxTree)adaptor.create(STRING_OPERATION, "STRING_OPERATION"), root_1);

                if ( !(stream_stringExpression.hasNext()) ) {
                    throw new RewriteEarlyExitException();
                }
                while ( stream_stringExpression.hasNext() ) {
                    adaptor.addChild(root_1, stream_stringExpression.nextTree());

                }
                stream_stringExpression.reset();

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
    // $ANTLR end "stringOperation"

    public static class stringExpression_return extends ParserRuleReturnScope {
        OPPLSyntaxTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "stringExpression"
    // OPPLParser.g:140:1: stringExpression : ( DBLQUOTE -> ^( DBLQUOTE ) | variableAttributeReference -> ^( variableAttributeReference ) );
    public final OPPLScript_OPPLParser.stringExpression_return stringExpression() throws RecognitionException {
        OPPLScript_OPPLParser.stringExpression_return retval = new OPPLScript_OPPLParser.stringExpression_return();
        retval.start = input.LT(1);

        OPPLSyntaxTree root_0 = null;

        Token DBLQUOTE102=null;
        OPPLScript_OPPLParser.variableAttributeReference_return variableAttributeReference103 = null;


        OPPLSyntaxTree DBLQUOTE102_tree=null;
        RewriteRuleTokenStream stream_DBLQUOTE=new RewriteRuleTokenStream(adaptor,"token DBLQUOTE");
        RewriteRuleSubtreeStream stream_variableAttributeReference=new RewriteRuleSubtreeStream(adaptor,"rule variableAttributeReference");
        try {
            // OPPLParser.g:141:2: ( DBLQUOTE -> ^( DBLQUOTE ) | variableAttributeReference -> ^( variableAttributeReference ) )
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==DBLQUOTE) ) {
                alt19=1;
            }
            else if ( (LA19_0==VARIABLE_NAME) ) {
                alt19=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 19, 0, input);

                throw nvae;
            }
            switch (alt19) {
                case 1 :
                    // OPPLParser.g:142:3: DBLQUOTE
                    {
                    DBLQUOTE102=(Token)match(input,DBLQUOTE,FOLLOW_DBLQUOTE_in_stringExpression1161); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_DBLQUOTE.add(DBLQUOTE102);



                    // AST REWRITE
                    // elements: DBLQUOTE
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (OPPLSyntaxTree)adaptor.nil();
                    // 142:12: -> ^( DBLQUOTE )
                    {
                        // OPPLParser.g:142:15: ^( DBLQUOTE )
                        {
                        OPPLSyntaxTree root_1 = (OPPLSyntaxTree)adaptor.nil();
                        root_1 = (OPPLSyntaxTree)adaptor.becomeRoot(stream_DBLQUOTE.nextNode(), root_1);

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 2 :
                    // OPPLParser.g:143:8: variableAttributeReference
                    {
                    pushFollow(FOLLOW_variableAttributeReference_in_stringExpression1176);
                    variableAttributeReference103=variableAttributeReference();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_variableAttributeReference.add(variableAttributeReference103.getTree());


                    // AST REWRITE
                    // elements: variableAttributeReference
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (OPPLSyntaxTree)adaptor.nil();
                    // 143:35: -> ^( variableAttributeReference )
                    {
                        // OPPLParser.g:143:38: ^( variableAttributeReference )
                        {
                        OPPLSyntaxTree root_1 = (OPPLSyntaxTree)adaptor.nil();
                        root_1 = (OPPLSyntaxTree)adaptor.becomeRoot(stream_variableAttributeReference.nextNode(), root_1);

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
    // $ANTLR end "stringExpression"

    public static class atomic_return extends ParserRuleReturnScope {
        OPPLSyntaxTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "atomic"
    // OPPLParser.g:147:1: atomic : ( IDENTIFIER | ENTITY_REFERENCE -> ^( ENTITY_REFERENCE ) | VARIABLE_NAME -> ^( IDENTIFIER[$VARIABLE_NAME] ) | createIdentifier -> ^( createIdentifier ) | variableAttributeReference -> ^( variableAttributeReference ) );
    public final OPPLScript_OPPLParser.atomic_return atomic() throws RecognitionException {
        OPPLScript_OPPLParser.atomic_return retval = new OPPLScript_OPPLParser.atomic_return();
        retval.start = input.LT(1);

        OPPLSyntaxTree root_0 = null;

        Token IDENTIFIER104=null;
        Token ENTITY_REFERENCE105=null;
        Token VARIABLE_NAME106=null;
        OPPLScript_OPPLParser.createIdentifier_return createIdentifier107 = null;

        OPPLScript_OPPLParser.variableAttributeReference_return variableAttributeReference108 = null;


        OPPLSyntaxTree IDENTIFIER104_tree=null;
        OPPLSyntaxTree ENTITY_REFERENCE105_tree=null;
        OPPLSyntaxTree VARIABLE_NAME106_tree=null;
        RewriteRuleTokenStream stream_ENTITY_REFERENCE=new RewriteRuleTokenStream(adaptor,"token ENTITY_REFERENCE");
        RewriteRuleTokenStream stream_VARIABLE_NAME=new RewriteRuleTokenStream(adaptor,"token VARIABLE_NAME");
        RewriteRuleSubtreeStream stream_variableAttributeReference=new RewriteRuleSubtreeStream(adaptor,"rule variableAttributeReference");
        RewriteRuleSubtreeStream stream_createIdentifier=new RewriteRuleSubtreeStream(adaptor,"rule createIdentifier");
        try {
            // OPPLParser.g:147:8: ( IDENTIFIER | ENTITY_REFERENCE -> ^( ENTITY_REFERENCE ) | VARIABLE_NAME -> ^( IDENTIFIER[$VARIABLE_NAME] ) | createIdentifier -> ^( createIdentifier ) | variableAttributeReference -> ^( variableAttributeReference ) )
            int alt20=5;
            switch ( input.LA(1) ) {
            case IDENTIFIER:
                {
                alt20=1;
                }
                break;
            case ENTITY_REFERENCE:
                {
                alt20=2;
                }
                break;
            case VARIABLE_NAME:
                {
                int LA20_3 = input.LA(2);

                if ( (LA20_3==DOT) ) {
                    alt20=5;
                }
                else if ( (LA20_3==EOF||LA20_3==COMPOSITION||(LA20_3>=CLOSED_CURLY_BRACES && LA20_3<=CLOSED_PARENTHESYS)||(LA20_3>=AND && LA20_3<=OR)||(LA20_3>=SOME && LA20_3<=RANGE)||(LA20_3>=COMMA && LA20_3<=DBLQUOTE)||(LA20_3>=IDENTIFIER && LA20_3<=ENTITY_REFERENCE)||LA20_3==WHERE||LA20_3==SELECT||(LA20_3>=BEGIN && LA20_3<=END)||LA20_3==CLOSED_SQUARE_BRACKET||(LA20_3>=HAS_KEY && LA20_3<=IRI)||LA20_3==ESCLAMATION_MARK||LA20_3==VARIABLE_NAME) ) {
                    alt20=3;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 20, 3, input);

                    throw nvae;
                }
                }
                break;
            case ESCLAMATION_MARK:
                {
                alt20=4;
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
                    // OPPLParser.g:148:3: IDENTIFIER
                    {
                    root_0 = (OPPLSyntaxTree)adaptor.nil();

                    IDENTIFIER104=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_atomic1195); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDENTIFIER104_tree = (OPPLSyntaxTree)adaptor.create(IDENTIFIER104);
                    adaptor.addChild(root_0, IDENTIFIER104_tree);
                    }

                    }
                    break;
                case 2 :
                    // OPPLParser.g:149:5: ENTITY_REFERENCE
                    {
                    ENTITY_REFERENCE105=(Token)match(input,ENTITY_REFERENCE,FOLLOW_ENTITY_REFERENCE_in_atomic1202); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_ENTITY_REFERENCE.add(ENTITY_REFERENCE105);



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

                    root_0 = (OPPLSyntaxTree)adaptor.nil();
                    // 149:22: -> ^( ENTITY_REFERENCE )
                    {
                        // OPPLParser.g:149:25: ^( ENTITY_REFERENCE )
                        {
                        OPPLSyntaxTree root_1 = (OPPLSyntaxTree)adaptor.nil();
                        root_1 = (OPPLSyntaxTree)adaptor.becomeRoot(stream_ENTITY_REFERENCE.nextNode(), root_1);

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 3 :
                    // OPPLParser.g:150:5: VARIABLE_NAME
                    {
                    VARIABLE_NAME106=(Token)match(input,VARIABLE_NAME,FOLLOW_VARIABLE_NAME_in_atomic1214); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_VARIABLE_NAME.add(VARIABLE_NAME106);



                    // AST REWRITE
                    // elements: 
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (OPPLSyntaxTree)adaptor.nil();
                    // 150:19: -> ^( IDENTIFIER[$VARIABLE_NAME] )
                    {
                        // OPPLParser.g:150:22: ^( IDENTIFIER[$VARIABLE_NAME] )
                        {
                        OPPLSyntaxTree root_1 = (OPPLSyntaxTree)adaptor.nil();
                        root_1 = (OPPLSyntaxTree)adaptor.becomeRoot((OPPLSyntaxTree)adaptor.create(IDENTIFIER, VARIABLE_NAME106), root_1);

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 4 :
                    // OPPLParser.g:151:8: createIdentifier
                    {
                    pushFollow(FOLLOW_createIdentifier_in_atomic1235);
                    createIdentifier107=createIdentifier();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_createIdentifier.add(createIdentifier107.getTree());


                    // AST REWRITE
                    // elements: createIdentifier
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (OPPLSyntaxTree)adaptor.nil();
                    // 151:25: -> ^( createIdentifier )
                    {
                        // OPPLParser.g:151:28: ^( createIdentifier )
                        {
                        OPPLSyntaxTree root_1 = (OPPLSyntaxTree)adaptor.nil();
                        root_1 = (OPPLSyntaxTree)adaptor.becomeRoot(stream_createIdentifier.nextNode(), root_1);

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 5 :
                    // OPPLParser.g:152:5: variableAttributeReference
                    {
                    pushFollow(FOLLOW_variableAttributeReference_in_atomic1247);
                    variableAttributeReference108=variableAttributeReference();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_variableAttributeReference.add(variableAttributeReference108.getTree());


                    // AST REWRITE
                    // elements: variableAttributeReference
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (OPPLSyntaxTree)adaptor.nil();
                    // 152:32: -> ^( variableAttributeReference )
                    {
                        // OPPLParser.g:152:35: ^( variableAttributeReference )
                        {
                        OPPLSyntaxTree root_1 = (OPPLSyntaxTree)adaptor.nil();
                        root_1 = (OPPLSyntaxTree)adaptor.becomeRoot(stream_variableAttributeReference.nextNode(), root_1);

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
    // $ANTLR end "atomic"

    public static class iri_return extends ParserRuleReturnScope {
        OPPLSyntaxTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "iri"
    // OPPLParser.g:155:1: iri : ( IRI -> IRI | VARIABLE_NAME DOT IRI_ATTRIBUTE_NAME -> ^( IRI[$VARIABLE_NAME.getText()+ $DOT.getText()+ $IRI_ATTRIBUTE_NAME.getText()] VARIABLE_NAME ) );
    public final OPPLScript_OPPLParser.iri_return iri() throws RecognitionException {
        OPPLScript_OPPLParser.iri_return retval = new OPPLScript_OPPLParser.iri_return();
        retval.start = input.LT(1);

        OPPLSyntaxTree root_0 = null;

        Token IRI109=null;
        Token VARIABLE_NAME110=null;
        Token DOT111=null;
        Token IRI_ATTRIBUTE_NAME112=null;

        OPPLSyntaxTree IRI109_tree=null;
        OPPLSyntaxTree VARIABLE_NAME110_tree=null;
        OPPLSyntaxTree DOT111_tree=null;
        OPPLSyntaxTree IRI_ATTRIBUTE_NAME112_tree=null;
        RewriteRuleTokenStream stream_IRI=new RewriteRuleTokenStream(adaptor,"token IRI");
        RewriteRuleTokenStream stream_IRI_ATTRIBUTE_NAME=new RewriteRuleTokenStream(adaptor,"token IRI_ATTRIBUTE_NAME");
        RewriteRuleTokenStream stream_VARIABLE_NAME=new RewriteRuleTokenStream(adaptor,"token VARIABLE_NAME");
        RewriteRuleTokenStream stream_DOT=new RewriteRuleTokenStream(adaptor,"token DOT");

        try {
            // OPPLParser.g:156:2: ( IRI -> IRI | VARIABLE_NAME DOT IRI_ATTRIBUTE_NAME -> ^( IRI[$VARIABLE_NAME.getText()+ $DOT.getText()+ $IRI_ATTRIBUTE_NAME.getText()] VARIABLE_NAME ) )
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==IRI) ) {
                alt21=1;
            }
            else if ( (LA21_0==VARIABLE_NAME) ) {
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
                    // OPPLParser.g:157:2: IRI
                    {
                    IRI109=(Token)match(input,IRI,FOLLOW_IRI_in_iri1266); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_IRI.add(IRI109);



                    // AST REWRITE
                    // elements: IRI
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (OPPLSyntaxTree)adaptor.nil();
                    // 157:6: -> IRI
                    {
                        adaptor.addChild(root_0, stream_IRI.nextNode());

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 2 :
                    // OPPLParser.g:158:4: VARIABLE_NAME DOT IRI_ATTRIBUTE_NAME
                    {
                    VARIABLE_NAME110=(Token)match(input,VARIABLE_NAME,FOLLOW_VARIABLE_NAME_in_iri1275); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_VARIABLE_NAME.add(VARIABLE_NAME110);

                    DOT111=(Token)match(input,DOT,FOLLOW_DOT_in_iri1277); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_DOT.add(DOT111);

                    IRI_ATTRIBUTE_NAME112=(Token)match(input,IRI_ATTRIBUTE_NAME,FOLLOW_IRI_ATTRIBUTE_NAME_in_iri1279); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_IRI_ATTRIBUTE_NAME.add(IRI_ATTRIBUTE_NAME112);



                    // AST REWRITE
                    // elements: VARIABLE_NAME
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (OPPLSyntaxTree)adaptor.nil();
                    // 158:41: -> ^( IRI[$VARIABLE_NAME.getText()+ $DOT.getText()+ $IRI_ATTRIBUTE_NAME.getText()] VARIABLE_NAME )
                    {
                        // OPPLParser.g:158:44: ^( IRI[$VARIABLE_NAME.getText()+ $DOT.getText()+ $IRI_ATTRIBUTE_NAME.getText()] VARIABLE_NAME )
                        {
                        OPPLSyntaxTree root_1 = (OPPLSyntaxTree)adaptor.nil();
                        root_1 = (OPPLSyntaxTree)adaptor.becomeRoot((OPPLSyntaxTree)adaptor.create(IRI, VARIABLE_NAME110.getText()+ DOT111.getText()+ IRI_ATTRIBUTE_NAME112.getText()), root_1);

                        adaptor.addChild(root_1, stream_VARIABLE_NAME.nextNode());

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
    // $ANTLR end "iri"

    public static class createIdentifier_return extends ParserRuleReturnScope {
        OPPLSyntaxTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "createIdentifier"
    // OPPLParser.g:161:1: createIdentifier : ESCLAMATION_MARK IDENTIFIER -> ^( IDENTIFIER[$ESCLAMATION_MARK.getText()+ $IDENTIFIER.getText()] ) ;
    public final OPPLScript_OPPLParser.createIdentifier_return createIdentifier() throws RecognitionException {
        OPPLScript_OPPLParser.createIdentifier_return retval = new OPPLScript_OPPLParser.createIdentifier_return();
        retval.start = input.LT(1);

        OPPLSyntaxTree root_0 = null;

        Token ESCLAMATION_MARK113=null;
        Token IDENTIFIER114=null;

        OPPLSyntaxTree ESCLAMATION_MARK113_tree=null;
        OPPLSyntaxTree IDENTIFIER114_tree=null;
        RewriteRuleTokenStream stream_IDENTIFIER=new RewriteRuleTokenStream(adaptor,"token IDENTIFIER");
        RewriteRuleTokenStream stream_ESCLAMATION_MARK=new RewriteRuleTokenStream(adaptor,"token ESCLAMATION_MARK");

        try {
            // OPPLParser.g:162:3: ( ESCLAMATION_MARK IDENTIFIER -> ^( IDENTIFIER[$ESCLAMATION_MARK.getText()+ $IDENTIFIER.getText()] ) )
            // OPPLParser.g:163:4: ESCLAMATION_MARK IDENTIFIER
            {
            ESCLAMATION_MARK113=(Token)match(input,ESCLAMATION_MARK,FOLLOW_ESCLAMATION_MARK_in_createIdentifier1303); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_ESCLAMATION_MARK.add(ESCLAMATION_MARK113);

            IDENTIFIER114=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_createIdentifier1305); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_IDENTIFIER.add(IDENTIFIER114);



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
            // 163:33: -> ^( IDENTIFIER[$ESCLAMATION_MARK.getText()+ $IDENTIFIER.getText()] )
            {
                // OPPLParser.g:163:36: ^( IDENTIFIER[$ESCLAMATION_MARK.getText()+ $IDENTIFIER.getText()] )
                {
                OPPLSyntaxTree root_1 = (OPPLSyntaxTree)adaptor.nil();
                root_1 = (OPPLSyntaxTree)adaptor.becomeRoot((OPPLSyntaxTree)adaptor.create(IDENTIFIER, ESCLAMATION_MARK113.getText()+ IDENTIFIER114.getText()), root_1);

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
    // $ANTLR end "createIdentifier"

    public static class variableAttributeReference_return extends ParserRuleReturnScope {
        OPPLSyntaxTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "variableAttributeReference"
    // OPPLParser.g:166:1: variableAttributeReference : ( VARIABLE_NAME DOT (a= VALUES | a= RENDERING ) -> ^( IDENTIFIER[$VARIABLE_NAME.getText()+$DOT.getText() + $a.getText()] VARIABLE_NAME DOT $a) | VARIABLE_NAME DOT GROUPS attributeSelector -> ^( IDENTIFIER[$VARIABLE_NAME.getText()+$DOT.getText() + $GROUPS.getText()+$attributeSelector.selectorText] VARIABLE_NAME DOT GROUPS attributeSelector ) );
    public final OPPLScript_OPPLParser.variableAttributeReference_return variableAttributeReference() throws RecognitionException {
        OPPLScript_OPPLParser.variableAttributeReference_return retval = new OPPLScript_OPPLParser.variableAttributeReference_return();
        retval.start = input.LT(1);

        OPPLSyntaxTree root_0 = null;

        Token a=null;
        Token VARIABLE_NAME115=null;
        Token DOT116=null;
        Token VARIABLE_NAME117=null;
        Token DOT118=null;
        Token GROUPS119=null;
        OPPLScript_OPPLParser.attributeSelector_return attributeSelector120 = null;


        OPPLSyntaxTree a_tree=null;
        OPPLSyntaxTree VARIABLE_NAME115_tree=null;
        OPPLSyntaxTree DOT116_tree=null;
        OPPLSyntaxTree VARIABLE_NAME117_tree=null;
        OPPLSyntaxTree DOT118_tree=null;
        OPPLSyntaxTree GROUPS119_tree=null;
        RewriteRuleTokenStream stream_VALUES=new RewriteRuleTokenStream(adaptor,"token VALUES");
        RewriteRuleTokenStream stream_GROUPS=new RewriteRuleTokenStream(adaptor,"token GROUPS");
        RewriteRuleTokenStream stream_RENDERING=new RewriteRuleTokenStream(adaptor,"token RENDERING");
        RewriteRuleTokenStream stream_VARIABLE_NAME=new RewriteRuleTokenStream(adaptor,"token VARIABLE_NAME");
        RewriteRuleTokenStream stream_DOT=new RewriteRuleTokenStream(adaptor,"token DOT");
        RewriteRuleSubtreeStream stream_attributeSelector=new RewriteRuleSubtreeStream(adaptor,"rule attributeSelector");
        try {
            // OPPLParser.g:167:3: ( VARIABLE_NAME DOT (a= VALUES | a= RENDERING ) -> ^( IDENTIFIER[$VARIABLE_NAME.getText()+$DOT.getText() + $a.getText()] VARIABLE_NAME DOT $a) | VARIABLE_NAME DOT GROUPS attributeSelector -> ^( IDENTIFIER[$VARIABLE_NAME.getText()+$DOT.getText() + $GROUPS.getText()+$attributeSelector.selectorText] VARIABLE_NAME DOT GROUPS attributeSelector ) )
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==VARIABLE_NAME) ) {
                int LA23_1 = input.LA(2);

                if ( (LA23_1==DOT) ) {
                    int LA23_2 = input.LA(3);

                    if ( (LA23_2==GROUPS) ) {
                        alt23=2;
                    }
                    else if ( ((LA23_2>=VALUES && LA23_2<=RENDERING)) ) {
                        alt23=1;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 23, 2, input);

                        throw nvae;
                    }
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 23, 1, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 23, 0, input);

                throw nvae;
            }
            switch (alt23) {
                case 1 :
                    // OPPLParser.g:168:5: VARIABLE_NAME DOT (a= VALUES | a= RENDERING )
                    {
                    VARIABLE_NAME115=(Token)match(input,VARIABLE_NAME,FOLLOW_VARIABLE_NAME_in_variableAttributeReference1332); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_VARIABLE_NAME.add(VARIABLE_NAME115);

                    DOT116=(Token)match(input,DOT,FOLLOW_DOT_in_variableAttributeReference1334); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_DOT.add(DOT116);

                    // OPPLParser.g:168:23: (a= VALUES | a= RENDERING )
                    int alt22=2;
                    int LA22_0 = input.LA(1);

                    if ( (LA22_0==VALUES) ) {
                        alt22=1;
                    }
                    else if ( (LA22_0==RENDERING) ) {
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
                            // OPPLParser.g:168:24: a= VALUES
                            {
                            a=(Token)match(input,VALUES,FOLLOW_VALUES_in_variableAttributeReference1341); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_VALUES.add(a);


                            }
                            break;
                        case 2 :
                            // OPPLParser.g:168:37: a= RENDERING
                            {
                            a=(Token)match(input,RENDERING,FOLLOW_RENDERING_in_variableAttributeReference1349); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_RENDERING.add(a);


                            }
                            break;

                    }



                    // AST REWRITE
                    // elements: a, DOT, VARIABLE_NAME
                    // token labels: a
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleTokenStream stream_a=new RewriteRuleTokenStream(adaptor,"token a",a);
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (OPPLSyntaxTree)adaptor.nil();
                    // 168:54: -> ^( IDENTIFIER[$VARIABLE_NAME.getText()+$DOT.getText() + $a.getText()] VARIABLE_NAME DOT $a)
                    {
                        // OPPLParser.g:168:56: ^( IDENTIFIER[$VARIABLE_NAME.getText()+$DOT.getText() + $a.getText()] VARIABLE_NAME DOT $a)
                        {
                        OPPLSyntaxTree root_1 = (OPPLSyntaxTree)adaptor.nil();
                        root_1 = (OPPLSyntaxTree)adaptor.becomeRoot((OPPLSyntaxTree)adaptor.create(IDENTIFIER, VARIABLE_NAME115.getText()+DOT116.getText() + a.getText()), root_1);

                        adaptor.addChild(root_1, stream_VARIABLE_NAME.nextNode());
                        adaptor.addChild(root_1, stream_DOT.nextNode());
                        adaptor.addChild(root_1, stream_a.nextNode());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 2 :
                    // OPPLParser.g:169:7: VARIABLE_NAME DOT GROUPS attributeSelector
                    {
                    VARIABLE_NAME117=(Token)match(input,VARIABLE_NAME,FOLLOW_VARIABLE_NAME_in_variableAttributeReference1373); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_VARIABLE_NAME.add(VARIABLE_NAME117);

                    DOT118=(Token)match(input,DOT,FOLLOW_DOT_in_variableAttributeReference1375); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_DOT.add(DOT118);

                    GROUPS119=(Token)match(input,GROUPS,FOLLOW_GROUPS_in_variableAttributeReference1377); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_GROUPS.add(GROUPS119);

                    pushFollow(FOLLOW_attributeSelector_in_variableAttributeReference1379);
                    attributeSelector120=attributeSelector();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_attributeSelector.add(attributeSelector120.getTree());


                    // AST REWRITE
                    // elements: DOT, GROUPS, VARIABLE_NAME, attributeSelector
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (OPPLSyntaxTree)adaptor.nil();
                    // 169:51: -> ^( IDENTIFIER[$VARIABLE_NAME.getText()+$DOT.getText() + $GROUPS.getText()+$attributeSelector.selectorText] VARIABLE_NAME DOT GROUPS attributeSelector )
                    {
                        // OPPLParser.g:169:53: ^( IDENTIFIER[$VARIABLE_NAME.getText()+$DOT.getText() + $GROUPS.getText()+$attributeSelector.selectorText] VARIABLE_NAME DOT GROUPS attributeSelector )
                        {
                        OPPLSyntaxTree root_1 = (OPPLSyntaxTree)adaptor.nil();
                        root_1 = (OPPLSyntaxTree)adaptor.becomeRoot((OPPLSyntaxTree)adaptor.create(IDENTIFIER, VARIABLE_NAME117.getText()+DOT118.getText() + GROUPS119.getText()+(attributeSelector120!=null?attributeSelector120.selectorText:null)), root_1);

                        adaptor.addChild(root_1, stream_VARIABLE_NAME.nextNode());
                        adaptor.addChild(root_1, stream_DOT.nextNode());
                        adaptor.addChild(root_1, stream_GROUPS.nextNode());
                        adaptor.addChild(root_1, stream_attributeSelector.nextTree());

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
    // $ANTLR end "variableAttributeReference"

    public static class attributeSelector_return extends ParserRuleReturnScope {
        public String selectorText;
        OPPLSyntaxTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "attributeSelector"
    // OPPLParser.g:174:1: attributeSelector returns [String selectorText] : OPEN_PARENTHESYS i= INTEGER CLOSED_PARENTHESYS -> ^( ATTRIBUTE_SELECTOR INTEGER ) ;
    public final OPPLScript_OPPLParser.attributeSelector_return attributeSelector() throws RecognitionException {
        OPPLScript_OPPLParser.attributeSelector_return retval = new OPPLScript_OPPLParser.attributeSelector_return();
        retval.start = input.LT(1);

        OPPLSyntaxTree root_0 = null;

        Token i=null;
        Token OPEN_PARENTHESYS121=null;
        Token CLOSED_PARENTHESYS122=null;

        OPPLSyntaxTree i_tree=null;
        OPPLSyntaxTree OPEN_PARENTHESYS121_tree=null;
        OPPLSyntaxTree CLOSED_PARENTHESYS122_tree=null;
        RewriteRuleTokenStream stream_INTEGER=new RewriteRuleTokenStream(adaptor,"token INTEGER");
        RewriteRuleTokenStream stream_CLOSED_PARENTHESYS=new RewriteRuleTokenStream(adaptor,"token CLOSED_PARENTHESYS");
        RewriteRuleTokenStream stream_OPEN_PARENTHESYS=new RewriteRuleTokenStream(adaptor,"token OPEN_PARENTHESYS");

        try {
            // OPPLParser.g:175:3: ( OPEN_PARENTHESYS i= INTEGER CLOSED_PARENTHESYS -> ^( ATTRIBUTE_SELECTOR INTEGER ) )
            // OPPLParser.g:176:5: OPEN_PARENTHESYS i= INTEGER CLOSED_PARENTHESYS
            {
            OPEN_PARENTHESYS121=(Token)match(input,OPEN_PARENTHESYS,FOLLOW_OPEN_PARENTHESYS_in_attributeSelector1428); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_OPEN_PARENTHESYS.add(OPEN_PARENTHESYS121);

            i=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_attributeSelector1434); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_INTEGER.add(i);

            CLOSED_PARENTHESYS122=(Token)match(input,CLOSED_PARENTHESYS,FOLLOW_CLOSED_PARENTHESYS_in_attributeSelector1436); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_CLOSED_PARENTHESYS.add(CLOSED_PARENTHESYS122);

            if ( state.backtracking==0 ) {

                    retval.selectorText = OPEN_PARENTHESYS121.getText() + i.getText() + CLOSED_PARENTHESYS122.getText();
                  
            }


            // AST REWRITE
            // elements: INTEGER
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (OPPLSyntaxTree)adaptor.nil();
            // 180:5: -> ^( ATTRIBUTE_SELECTOR INTEGER )
            {
                // OPPLParser.g:180:9: ^( ATTRIBUTE_SELECTOR INTEGER )
                {
                OPPLSyntaxTree root_1 = (OPPLSyntaxTree)adaptor.nil();
                root_1 = (OPPLSyntaxTree)adaptor.becomeRoot((OPPLSyntaxTree)adaptor.create(ATTRIBUTE_SELECTOR, "ATTRIBUTE_SELECTOR"), root_1);

                adaptor.addChild(root_1, stream_INTEGER.nextNode());

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
    // $ANTLR end "attributeSelector"

    // $ANTLR start synpred1_OPPLParser
    public final void synpred1_OPPLParser_fragment() throws RecognitionException {   
        // OPPLParser.g:86:3: ( binaryAxiom )
        // OPPLParser.g:86:3: binaryAxiom
        {
        pushFollow(FOLLOW_binaryAxiom_in_synpred1_OPPLParser621);
        gOPPLScript.binaryAxiom();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred1_OPPLParser

    // $ANTLR start synpred4_OPPLParser
    public final void synpred4_OPPLParser_fragment() throws RecognitionException {   
        // OPPLParser.g:89:5: ( assertionAxiom )
        // OPPLParser.g:89:5: assertionAxiom
        {
        pushFollow(FOLLOW_assertionAxiom_in_synpred4_OPPLParser657);
        gOPPLScript.assertionAxiom();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred4_OPPLParser

    // $ANTLR start synpred5_OPPLParser
    public final void synpred5_OPPLParser_fragment() throws RecognitionException {   
        // OPPLParser.g:90:5: ( hasKeyAxiom )
        // OPPLParser.g:90:5: hasKeyAxiom
        {
        pushFollow(FOLLOW_hasKeyAxiom_in_synpred5_OPPLParser669);
        gOPPLScript.hasKeyAxiom();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred5_OPPLParser

    // Delegated rules

    public final boolean synpred4_OPPLParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred4_OPPLParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred5_OPPLParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred5_OPPLParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred1_OPPLParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred1_OPPLParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


    protected DFA9 dfa9 = new DFA9(this);
    static final String DFA9_eotS =
        "\31\uffff";
    static final String DFA9_eofS =
        "\31\uffff";
    static final String DFA9_minS =
        "\1\5\11\0\17\uffff";
    static final String DFA9_maxS =
        "\1\u01d0\11\0\17\uffff";
    static final String DFA9_acceptS =
        "\12\uffff\1\2\3\uffff\1\3\6\uffff\1\6\1\1\1\4\1\5";
    static final String DFA9_specialS =
        "\1\uffff\1\0\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\17\uffff}>";
    static final String[] DFA9_transitionS = {
            "\1\11\1\7\5\uffff\1\6\6\uffff\1\5\11\uffff\7\16\4\uffff\1\10"+
            "\3\uffff\1\1\1\2\100\uffff\1\25\5\uffff\4\12\35\uffff\1\4\u013a"+
            "\uffff\1\3",
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
            return "85:1: axiom options {backtrack=true; } : ( binaryAxiom -> ^( binaryAxiom ) | nAryAxiom -> ^( nAryAxiom ) | unaryAxiom -> ^( unaryAxiom ) | assertionAxiom -> ^( assertionAxiom ) | hasKeyAxiom -> ^( hasKeyAxiom ) | annotationAssertionAxiom -> ^( annotationAssertionAxiom ) );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA9_1 = input.LA(1);

                         
                        int index9_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred1_OPPLParser()) ) {s = 22;}

                        else if ( (synpred4_OPPLParser()) ) {s = 23;}

                        else if ( (synpred5_OPPLParser()) ) {s = 24;}

                         
                        input.seek(index9_1);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA9_2 = input.LA(1);

                         
                        int index9_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred1_OPPLParser()) ) {s = 22;}

                        else if ( (synpred4_OPPLParser()) ) {s = 23;}

                        else if ( (synpred5_OPPLParser()) ) {s = 24;}

                         
                        input.seek(index9_2);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA9_3 = input.LA(1);

                         
                        int index9_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred1_OPPLParser()) ) {s = 22;}

                        else if ( (synpred4_OPPLParser()) ) {s = 23;}

                        else if ( (synpred5_OPPLParser()) ) {s = 24;}

                        else if ( (true) ) {s = 21;}

                         
                        input.seek(index9_3);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA9_4 = input.LA(1);

                         
                        int index9_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred1_OPPLParser()) ) {s = 22;}

                        else if ( (synpred4_OPPLParser()) ) {s = 23;}

                        else if ( (synpred5_OPPLParser()) ) {s = 24;}

                         
                        input.seek(index9_4);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA9_5 = input.LA(1);

                         
                        int index9_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred1_OPPLParser()) ) {s = 22;}

                        else if ( (synpred5_OPPLParser()) ) {s = 24;}

                         
                        input.seek(index9_5);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA9_6 = input.LA(1);

                         
                        int index9_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred1_OPPLParser()) ) {s = 22;}

                        else if ( (synpred4_OPPLParser()) ) {s = 23;}

                        else if ( (synpred5_OPPLParser()) ) {s = 24;}

                         
                        input.seek(index9_6);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA9_7 = input.LA(1);

                         
                        int index9_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred1_OPPLParser()) ) {s = 22;}

                        else if ( (synpred5_OPPLParser()) ) {s = 24;}

                         
                        input.seek(index9_7);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA9_8 = input.LA(1);

                         
                        int index9_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred1_OPPLParser()) ) {s = 22;}

                        else if ( (synpred5_OPPLParser()) ) {s = 24;}

                         
                        input.seek(index9_8);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA9_9 = input.LA(1);

                         
                        int index9_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred1_OPPLParser()) ) {s = 22;}

                        else if ( (synpred5_OPPLParser()) ) {s = 24;}

                         
                        input.seek(index9_9);
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
 

    public static final BitSet FOLLOW_variableDefinition_in_variableDefinitions216 = new BitSet(new long[]{0x0000002000000002L});
    public static final BitSet FOLLOW_COMMA_in_variableDefinitions219 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_variableDefinition_in_variableDefinitions221 = new BitSet(new long[]{0x0000002000000002L});
    public static final BitSet FOLLOW_VARIABLE_NAME_in_variableDefinition255 = new BitSet(new long[]{0x0000000000000000L,0x0000000000002000L});
    public static final BitSet FOLLOW_COLON_in_variableDefinition257 = new BitSet(new long[]{0x0000000000000000L,0x0000000002000000L});
    public static final BitSet FOLLOW_VARIABLE_TYPE_in_variableDefinition259 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_EQUAL_in_variableDefinition262 = new BitSet(new long[]{0x0000000000000000L,0x0008000000070000L});
    public static final BitSet FOLLOW_opplFunction_in_variableDefinition264 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_VARIABLE_NAME_in_variableDefinition292 = new BitSet(new long[]{0x0000000000000000L,0x0000000000002000L});
    public static final BitSet FOLLOW_COLON_in_variableDefinition294 = new BitSet(new long[]{0x0000000000000000L,0x0000000002000000L});
    public static final BitSet FOLLOW_VARIABLE_TYPE_in_variableDefinition296 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_EQUAL_in_variableDefinition299 = new BitSet(new long[]{0x0000310000081060L,0x0000000000000000L,0x0000000000200000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_expression_in_variableDefinition301 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_VARIABLE_NAME_in_variableDefinition325 = new BitSet(new long[]{0x0000000000000000L,0x0000000000002000L});
    public static final BitSet FOLLOW_COLON_in_variableDefinition327 = new BitSet(new long[]{0x0000000000000000L,0x0000000002000000L});
    public static final BitSet FOLLOW_VARIABLE_TYPE_in_variableDefinition329 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_EQUAL_in_variableDefinition332 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0001000000000000L});
    public static final BitSet FOLLOW_regexp_in_variableDefinition334 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_VARIABLE_NAME_in_variableDefinition354 = new BitSet(new long[]{0x0000000000000000L,0x0000000000002000L});
    public static final BitSet FOLLOW_COLON_in_variableDefinition356 = new BitSet(new long[]{0x0000000000000000L,0x0000000002000000L});
    public static final BitSet FOLLOW_VARIABLE_TYPE_in_variableDefinition358 = new BitSet(new long[]{0x0000000000000002L,0x0000000000200000L});
    public static final BitSet FOLLOW_variableScope_in_variableDefinition361 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OPEN_SQUARE_BRACKET_in_variableScope401 = new BitSet(new long[]{0x000000C000100000L,0x0000020001800000L});
    public static final BitSet FOLLOW_SUBCLASS_OF_in_variableScope408 = new BitSet(new long[]{0x0000310000081060L,0x0000000000000000L,0x0000000000200000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_SUBPROPERTY_OF_in_variableScope416 = new BitSet(new long[]{0x0000310000081060L,0x0000000000000000L,0x0000000000200000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_SUPER_CLASS_OF_in_variableScope424 = new BitSet(new long[]{0x0000310000081060L,0x0000000000000000L,0x0000000000200000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_SUPER_PROPERTY_OF_in_variableScope432 = new BitSet(new long[]{0x0000310000081060L,0x0000000000000000L,0x0000000000200000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_INSTANCE_OF_in_variableScope441 = new BitSet(new long[]{0x0000310000081060L,0x0000000000000000L,0x0000000000200000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_TYPES_in_variableScope449 = new BitSet(new long[]{0x0000310000081060L,0x0000000000000000L,0x0000000000200000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_expression_in_variableScope452 = new BitSet(new long[]{0x0000000000000000L,0x0000000000400000L});
    public static final BitSet FOLLOW_CLOSED_SQUARE_BRACKET_in_variableScope454 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MATCH_in_regexp484 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_OPEN_PARENTHESYS_in_regexp486 = new BitSet(new long[]{0x0000310000000000L,0x0000000000000000L,0x0000000000200000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_stringOperation_in_regexp488 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_CLOSED_PARENTHESYS_in_regexp490 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SELECT_in_query515 = new BitSet(new long[]{0x0000310FE0081060L,0x00F0400000001000L,0x0000000000200000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_selectClause_in_query517 = new BitSet(new long[]{0x0000002000000002L,0x0000000000000080L});
    public static final BitSet FOLLOW_COMMA_in_query520 = new BitSet(new long[]{0x0000310FE0081060L,0x00F0400000001000L,0x0000000000200000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_selectClause_in_query522 = new BitSet(new long[]{0x0000002000000002L,0x0000000000000080L});
    public static final BitSet FOLLOW_WHERE_in_query527 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000050000L});
    public static final BitSet FOLLOW_constraint_in_query529 = new BitSet(new long[]{0x0000002000000002L});
    public static final BitSet FOLLOW_COMMA_in_query532 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000050000L});
    public static final BitSet FOLLOW_constraint_in_query534 = new BitSet(new long[]{0x0000002000000002L});
    public static final BitSet FOLLOW_ASSERTED_in_selectClause571 = new BitSet(new long[]{0x0000310FE0081060L,0x00F0400000001000L,0x0000000000200000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_axiom_in_selectClause573 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_axiom_in_selectClause589 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_binaryAxiom_in_axiom621 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nAryAxiom_in_axiom633 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_unaryAxiom_in_axiom645 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_assertionAxiom_in_axiom657 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_hasKeyAxiom_in_axiom669 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_annotationAssertionAxiom_in_axiom680 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DISJOINT_CLASSES_in_nAryAxiom702 = new BitSet(new long[]{0x0000000000000000L,0x0008000000070000L});
    public static final BitSet FOLLOW_opplFunction_in_nAryAxiom704 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DISJOINT_PROPERTIES_in_nAryAxiom718 = new BitSet(new long[]{0x0000000000000000L,0x0008000000070000L});
    public static final BitSet FOLLOW_opplFunction_in_nAryAxiom720 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SAME_INDIVIDUAL_in_nAryAxiom734 = new BitSet(new long[]{0x0000000000000000L,0x0008000000070000L});
    public static final BitSet FOLLOW_opplFunction_in_nAryAxiom736 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DIFFERENT_INDIVIDUALS_in_nAryAxiom750 = new BitSet(new long[]{0x0000000000000000L,0x0008000000070000L});
    public static final BitSet FOLLOW_opplFunction_in_nAryAxiom752 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_VARIABLE_NAME_in_constraint787 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_NOT_EQUAL_in_constraint789 = new BitSet(new long[]{0x0000310000081060L,0x0000000000000000L,0x0000000000200000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_expression_in_constraint795 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_VARIABLE_NAME_in_constraint820 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000400L});
    public static final BitSet FOLLOW_IN_in_constraint822 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_OPEN_CURLY_BRACES_in_constraint824 = new BitSet(new long[]{0x0000300000000000L,0x0000000000000000L,0x0000000000200000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_atomic_in_constraint826 = new BitSet(new long[]{0x0000002000000080L});
    public static final BitSet FOLLOW_COMMA_in_constraint829 = new BitSet(new long[]{0x0000300000000000L,0x0000000000000000L,0x0000000000200000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_atomic_in_constraint831 = new BitSet(new long[]{0x0000002000000080L});
    public static final BitSet FOLLOW_CLOSED_CURLY_BRACES_in_constraint835 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_VARIABLE_NAME_in_constraint857 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0001000000000000L});
    public static final BitSet FOLLOW_MATCH_in_constraint859 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_OPEN_PARENTHESYS_in_constraint861 = new BitSet(new long[]{0x0000310000000000L,0x0000000000000000L,0x0000000000200000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_stringOperation_in_constraint863 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_CLOSED_PARENTHESYS_in_constraint865 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FAIL_in_constraint884 = new BitSet(new long[]{0x0000310FE0081060L,0x00F0400000001000L,0x0000000000200000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_axiom_in_constraint886 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BEGIN_in_actions914 = new BitSet(new long[]{0x0000000000000000L,0x000000000C000000L});
    public static final BitSet FOLLOW_action_in_actions916 = new BitSet(new long[]{0x0000002000000000L,0x0000000000100000L});
    public static final BitSet FOLLOW_COMMA_in_actions919 = new BitSet(new long[]{0x0000000000000000L,0x000000000C000000L});
    public static final BitSet FOLLOW_action_in_actions921 = new BitSet(new long[]{0x0000002000000000L,0x0000000000100000L});
    public static final BitSet FOLLOW_END_in_actions925 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ADD_in_action957 = new BitSet(new long[]{0x0000310FE0081060L,0x00F0400000001000L,0x0000000000200000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_axiom_in_action959 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_REMOVE_in_action975 = new BitSet(new long[]{0x0000310FE0081060L,0x00F0400000001000L,0x0000000000200000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_axiom_in_action977 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CREATE_in_opplFunction1010 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_OPEN_PARENTHESYS_in_opplFunction1012 = new BitSet(new long[]{0x0000310000000000L,0x0000000000000000L,0x0000000000200000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_stringOperation_in_opplFunction1014 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_CLOSED_PARENTHESYS_in_opplFunction1016 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CREATE_INTERSECTION_in_opplFunction1032 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_OPEN_PARENTHESYS_in_opplFunction1035 = new BitSet(new long[]{0x0000300000000000L,0x0000000000000000L,0x0000000000200000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_atomic_in_opplFunction1037 = new BitSet(new long[]{0x0000002000000100L});
    public static final BitSet FOLLOW_COMMA_in_opplFunction1040 = new BitSet(new long[]{0x0000300000000000L,0x0000000000000000L,0x0000000000200000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_atomic_in_opplFunction1042 = new BitSet(new long[]{0x0000002000000100L});
    public static final BitSet FOLLOW_CLOSED_PARENTHESYS_in_opplFunction1047 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CREATE_DISJUNCTION_in_opplFunction1064 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_OPEN_PARENTHESYS_in_opplFunction1066 = new BitSet(new long[]{0x0000300000000000L,0x0000000000000000L,0x0000000000200000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_atomic_in_opplFunction1068 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_CLOSED_PARENTHESYS_in_opplFunction1070 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SET_in_opplFunction1086 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_OPEN_PARENTHESYS_in_opplFunction1088 = new BitSet(new long[]{0x0000300000000000L,0x0000000000000000L,0x0000000000200000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_atomic_in_opplFunction1090 = new BitSet(new long[]{0x0000002000000100L});
    public static final BitSet FOLLOW_COMMA_in_opplFunction1093 = new BitSet(new long[]{0x0000300000000000L,0x0000000000000000L,0x0000000000200000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_atomic_in_opplFunction1095 = new BitSet(new long[]{0x0000002000000100L});
    public static final BitSet FOLLOW_CLOSED_PARENTHESYS_in_opplFunction1099 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_stringExpression_in_stringOperation1129 = new BitSet(new long[]{0x0000000000000002L,0x0000000000008000L});
    public static final BitSet FOLLOW_PLUS_in_stringOperation1132 = new BitSet(new long[]{0x0000310000000000L,0x0000000000000000L,0x0000000000200000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_stringExpression_in_stringOperation1134 = new BitSet(new long[]{0x0000000000000002L,0x0000000000008000L});
    public static final BitSet FOLLOW_DBLQUOTE_in_stringExpression1161 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_variableAttributeReference_in_stringExpression1176 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_atomic1195 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ENTITY_REFERENCE_in_atomic1202 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_VARIABLE_NAME_in_atomic1214 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_createIdentifier_in_atomic1235 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_variableAttributeReference_in_atomic1247 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IRI_in_iri1266 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_VARIABLE_NAME_in_iri1275 = new BitSet(new long[]{0x0000000000000000L,0x0000000000004000L});
    public static final BitSet FOLLOW_DOT_in_iri1277 = new BitSet(new long[]{0x0000000000000000L,0x0001000000000000L});
    public static final BitSet FOLLOW_IRI_ATTRIBUTE_NAME_in_iri1279 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ESCLAMATION_MARK_in_createIdentifier1303 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_createIdentifier1305 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_VARIABLE_NAME_in_variableAttributeReference1332 = new BitSet(new long[]{0x0000000000000000L,0x0000000000004000L});
    public static final BitSet FOLLOW_DOT_in_variableAttributeReference1334 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000C00000000L});
    public static final BitSet FOLLOW_VALUES_in_variableAttributeReference1341 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RENDERING_in_variableAttributeReference1349 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_VARIABLE_NAME_in_variableAttributeReference1373 = new BitSet(new long[]{0x0000000000000000L,0x0000000000004000L});
    public static final BitSet FOLLOW_DOT_in_variableAttributeReference1375 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000001000000000L});
    public static final BitSet FOLLOW_GROUPS_in_variableAttributeReference1377 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_attributeSelector_in_variableAttributeReference1379 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OPEN_PARENTHESYS_in_attributeSelector1428 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_INTEGER_in_attributeSelector1434 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_CLOSED_PARENTHESYS_in_attributeSelector1436 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_binaryAxiom_in_synpred1_OPPLParser621 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_assertionAxiom_in_synpred4_OPPLParser657 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_hasKeyAxiom_in_synpred5_OPPLParser669 = new BitSet(new long[]{0x0000000000000002L});

}