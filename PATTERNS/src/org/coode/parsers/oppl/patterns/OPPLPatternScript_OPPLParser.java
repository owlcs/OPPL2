// $ANTLR 3.2 Sep 23, 2009 12:02:23 OPPLParser.g 2010-11-24 13:02:18

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

public class OPPLPatternScript_OPPLParser extends Parser {
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
    public OPPLPatternScript_OPPLParser_MOWLParser gMOWLParser;
    // delegators
    public OPPLPatternScriptParser gOPPLPatternScript;
    public OPPLPatternScriptParser gParent;


        public OPPLPatternScript_OPPLParser(TokenStream input, OPPLPatternScriptParser gOPPLPatternScript) {
            this(input, new RecognizerSharedState(), gOPPLPatternScript);
        }
        public OPPLPatternScript_OPPLParser(TokenStream input, RecognizerSharedState state, OPPLPatternScriptParser gOPPLPatternScript) {
            super(input, state);
            this.gOPPLPatternScript = gOPPLPatternScript;
            gMOWLParser = new OPPLPatternScript_OPPLParser_MOWLParser(input, state, gOPPLPatternScript, this);         
            gParent = gOPPLPatternScript;
        }
        
    protected TreeAdaptor adaptor = new CommonTreeAdaptor();

    public void setTreeAdaptor(TreeAdaptor adaptor) {
        this.adaptor = adaptor;
        gMOWLParser.setTreeAdaptor(this.adaptor);
    }
    public TreeAdaptor getTreeAdaptor() {
        return adaptor;
    }

    public String[] getTokenNames() { return OPPLPatternScriptParser.tokenNames; }
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
    public final OPPLPatternScript_OPPLParser.variableDefinitions_return variableDefinitions() throws RecognitionException {
        OPPLPatternScript_OPPLParser.variableDefinitions_return retval = new OPPLPatternScript_OPPLParser.variableDefinitions_return();
        retval.start = input.LT(1);

        OPPLSyntaxTree root_0 = null;

        Token COMMA2=null;
        OPPLPatternScript_OPPLParser.variableDefinition_return variableDefinition1 = null;

        OPPLPatternScript_OPPLParser.variableDefinition_return variableDefinition3 = null;


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
    public final OPPLPatternScript_OPPLParser.variableDefinition_return variableDefinition() throws RecognitionException {
        OPPLPatternScript_OPPLParser.variableDefinition_return retval = new OPPLPatternScript_OPPLParser.variableDefinition_return();
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
        OPPLPatternScript_OPPLParser.opplFunction_return opplFunction8 = null;

        OPPLPatternScript_OPPLParser_MOWLParser.expression_return expression13 = null;

        OPPLPatternScript_OPPLParser.regexp_return regexp18 = null;

        OPPLPatternScript_OPPLParser.variableScope_return variableScope22 = null;


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
                            case MATCH:
                                {
                                alt3=3;
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
                            case DOLLAR:
                            case THIS_CLASS:
                            case VARIABLE_NAME:
                                {
                                alt3=2;
                                }
                                break;
                            case CREATE:
                            case CREATE_INTERSECTION:
                            case CREATE_DISJUNCTION:
                                {
                                alt3=1;
                                }
                                break;
                            default:
                                if (state.backtracking>0) {state.failed=true; return retval;}
                                NoViableAltException nvae =
                                    new NoViableAltException("", 3, 4, input);

                                throw nvae;
                            }

                        }
                        else if ( (LA3_3==COMMA||LA3_3==BEGIN||LA3_3==OPEN_SQUARE_BRACKET) ) {
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
                    expression13=gOPPLPatternScript.expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_expression.add(expression13.getTree());


                    // AST REWRITE
                    // elements: VARIABLE_NAME, VARIABLE_TYPE, expression
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
                    // elements: VARIABLE_NAME, VARIABLE_TYPE, regexp
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
                    // elements: variableScope, VARIABLE_TYPE, VARIABLE_NAME
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
    public final OPPLPatternScript_OPPLParser.variableScope_return variableScope() throws RecognitionException {
        OPPLPatternScript_OPPLParser.variableScope_return retval = new OPPLPatternScript_OPPLParser.variableScope_return();
        retval.start = input.LT(1);

        OPPLSyntaxTree root_0 = null;

        Token variableScopeSpecification=null;
        Token OPEN_SQUARE_BRACKET23=null;
        Token CLOSED_SQUARE_BRACKET25=null;
        OPPLPatternScript_OPPLParser_MOWLParser.expression_return expression24 = null;


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
            expression24=gOPPLPatternScript.expression();

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
    public final OPPLPatternScript_OPPLParser.regexp_return regexp() throws RecognitionException {
        OPPLPatternScript_OPPLParser.regexp_return retval = new OPPLPatternScript_OPPLParser.regexp_return();
        retval.start = input.LT(1);

        OPPLSyntaxTree root_0 = null;

        Token MATCH26=null;
        Token OPEN_PARENTHESYS27=null;
        Token CLOSED_PARENTHESYS29=null;
        OPPLPatternScript_OPPLParser.stringOperation_return stringOperation28 = null;


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
    public final OPPLPatternScript_OPPLParser.query_return query() throws RecognitionException {
        OPPLPatternScript_OPPLParser.query_return retval = new OPPLPatternScript_OPPLParser.query_return();
        retval.start = input.LT(1);

        OPPLSyntaxTree root_0 = null;

        Token SELECT30=null;
        Token COMMA32=null;
        Token WHERE34=null;
        Token COMMA36=null;
        OPPLPatternScript_OPPLParser.selectClause_return selectClause31 = null;

        OPPLPatternScript_OPPLParser.selectClause_return selectClause33 = null;

        OPPLPatternScript_OPPLParser.constraint_return constraint35 = null;

        OPPLPatternScript_OPPLParser.constraint_return constraint37 = null;


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
            // elements: selectClause, constraint
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
    public final OPPLPatternScript_OPPLParser.selectClause_return selectClause() throws RecognitionException {
        OPPLPatternScript_OPPLParser.selectClause_return retval = new OPPLPatternScript_OPPLParser.selectClause_return();
        retval.start = input.LT(1);

        OPPLSyntaxTree root_0 = null;

        Token ASSERTED38=null;
        OPPLPatternScript_OPPLParser_MOWLParser.axiom_return axiom39 = null;

        OPPLPatternScript_OPPLParser_MOWLParser.axiom_return axiom40 = null;


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
            else if ( ((LA8_0>=OPEN_PARENTHESYS && LA8_0<=OPEN_CURLY_BRACES)||LA8_0==NOT||LA8_0==INVERSE||(LA8_0>=FUNCTIONAL && LA8_0<=INVERSE_FUNCTIONAL)||LA8_0==DBLQUOTE||(LA8_0>=IDENTIFIER && LA8_0<=ENTITY_REFERENCE)||LA8_0==IRI||LA8_0==ESCLAMATION_MARK||LA8_0==DOLLAR||LA8_0==THIS_CLASS||LA8_0==VARIABLE_NAME) ) {
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
                    axiom39=gOPPLPatternScript.axiom();

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
                    axiom40=gOPPLPatternScript.axiom();

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

    public static class constraint_return extends ParserRuleReturnScope {
        OPPLSyntaxTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "constraint"
    // OPPLParser.g:87:2: constraint : (first= VARIABLE_NAME NOT_EQUAL second= expression -> ^( INEQUALITY_CONSTRAINT IDENTIFIER[$first] ^( EXPRESSION $second) ) | VARIABLE_NAME IN OPEN_CURLY_BRACES atomic ( COMMA atomic )* CLOSED_CURLY_BRACES -> ^( IN_SET_CONSTRAINT IDENTIFIER[$VARIABLE_NAME] ( atomic )+ ) | VARIABLE_NAME MATCH OPEN_PARENTHESYS stringOperation CLOSED_PARENTHESYS -> ^( REGEXP_CONSTRAINT IDENTIFIER[$VARIABLE_NAME] stringOperation ) | FAIL axiom -> ^( NAF_CONSTRAINT axiom ) );
    public final OPPLPatternScript_OPPLParser.constraint_return constraint() throws RecognitionException {
        OPPLPatternScript_OPPLParser.constraint_return retval = new OPPLPatternScript_OPPLParser.constraint_return();
        retval.start = input.LT(1);

        OPPLSyntaxTree root_0 = null;

        Token first=null;
        Token NOT_EQUAL41=null;
        Token VARIABLE_NAME42=null;
        Token IN43=null;
        Token OPEN_CURLY_BRACES44=null;
        Token COMMA46=null;
        Token CLOSED_CURLY_BRACES48=null;
        Token VARIABLE_NAME49=null;
        Token MATCH50=null;
        Token OPEN_PARENTHESYS51=null;
        Token CLOSED_PARENTHESYS53=null;
        Token FAIL54=null;
        OPPLPatternScript_OPPLParser_MOWLParser.expression_return second = null;

        OPPLPatternScriptParser.atomic_return atomic45 = null;

        OPPLPatternScriptParser.atomic_return atomic47 = null;

        OPPLPatternScript_OPPLParser.stringOperation_return stringOperation52 = null;

        OPPLPatternScript_OPPLParser_MOWLParser.axiom_return axiom55 = null;


        OPPLSyntaxTree first_tree=null;
        OPPLSyntaxTree NOT_EQUAL41_tree=null;
        OPPLSyntaxTree VARIABLE_NAME42_tree=null;
        OPPLSyntaxTree IN43_tree=null;
        OPPLSyntaxTree OPEN_CURLY_BRACES44_tree=null;
        OPPLSyntaxTree COMMA46_tree=null;
        OPPLSyntaxTree CLOSED_CURLY_BRACES48_tree=null;
        OPPLSyntaxTree VARIABLE_NAME49_tree=null;
        OPPLSyntaxTree MATCH50_tree=null;
        OPPLSyntaxTree OPEN_PARENTHESYS51_tree=null;
        OPPLSyntaxTree CLOSED_PARENTHESYS53_tree=null;
        OPPLSyntaxTree FAIL54_tree=null;
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
            // OPPLParser.g:88:3: (first= VARIABLE_NAME NOT_EQUAL second= expression -> ^( INEQUALITY_CONSTRAINT IDENTIFIER[$first] ^( EXPRESSION $second) ) | VARIABLE_NAME IN OPEN_CURLY_BRACES atomic ( COMMA atomic )* CLOSED_CURLY_BRACES -> ^( IN_SET_CONSTRAINT IDENTIFIER[$VARIABLE_NAME] ( atomic )+ ) | VARIABLE_NAME MATCH OPEN_PARENTHESYS stringOperation CLOSED_PARENTHESYS -> ^( REGEXP_CONSTRAINT IDENTIFIER[$VARIABLE_NAME] stringOperation ) | FAIL axiom -> ^( NAF_CONSTRAINT axiom ) )
            int alt10=4;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==VARIABLE_NAME) ) {
                switch ( input.LA(2) ) {
                case NOT_EQUAL:
                    {
                    alt10=1;
                    }
                    break;
                case IN:
                    {
                    alt10=2;
                    }
                    break;
                case MATCH:
                    {
                    alt10=3;
                    }
                    break;
                default:
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 10, 1, input);

                    throw nvae;
                }

            }
            else if ( (LA10_0==FAIL) ) {
                alt10=4;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }
            switch (alt10) {
                case 1 :
                    // OPPLParser.g:89:8: first= VARIABLE_NAME NOT_EQUAL second= expression
                    {
                    first=(Token)match(input,VARIABLE_NAME,FOLLOW_VARIABLE_NAME_in_constraint628); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_VARIABLE_NAME.add(first);

                    NOT_EQUAL41=(Token)match(input,NOT_EQUAL,FOLLOW_NOT_EQUAL_in_constraint630); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_NOT_EQUAL.add(NOT_EQUAL41);

                    pushFollow(FOLLOW_expression_in_constraint636);
                    second=gOPPLPatternScript.expression();

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
                    // 89:60: -> ^( INEQUALITY_CONSTRAINT IDENTIFIER[$first] ^( EXPRESSION $second) )
                    {
                        // OPPLParser.g:89:63: ^( INEQUALITY_CONSTRAINT IDENTIFIER[$first] ^( EXPRESSION $second) )
                        {
                        OPPLSyntaxTree root_1 = (OPPLSyntaxTree)adaptor.nil();
                        root_1 = (OPPLSyntaxTree)adaptor.becomeRoot((OPPLSyntaxTree)adaptor.create(INEQUALITY_CONSTRAINT, "INEQUALITY_CONSTRAINT"), root_1);

                        adaptor.addChild(root_1, (OPPLSyntaxTree)adaptor.create(IDENTIFIER, first));
                        // OPPLParser.g:89:106: ^( EXPRESSION $second)
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
                    // OPPLParser.g:90:8: VARIABLE_NAME IN OPEN_CURLY_BRACES atomic ( COMMA atomic )* CLOSED_CURLY_BRACES
                    {
                    VARIABLE_NAME42=(Token)match(input,VARIABLE_NAME,FOLLOW_VARIABLE_NAME_in_constraint661); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_VARIABLE_NAME.add(VARIABLE_NAME42);

                    IN43=(Token)match(input,IN,FOLLOW_IN_in_constraint663); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_IN.add(IN43);

                    OPEN_CURLY_BRACES44=(Token)match(input,OPEN_CURLY_BRACES,FOLLOW_OPEN_CURLY_BRACES_in_constraint665); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_OPEN_CURLY_BRACES.add(OPEN_CURLY_BRACES44);

                    pushFollow(FOLLOW_atomic_in_constraint667);
                    atomic45=gOPPLPatternScript.atomic();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_atomic.add(atomic45.getTree());
                    // OPPLParser.g:90:50: ( COMMA atomic )*
                    loop9:
                    do {
                        int alt9=2;
                        int LA9_0 = input.LA(1);

                        if ( (LA9_0==COMMA) ) {
                            alt9=1;
                        }


                        switch (alt9) {
                    	case 1 :
                    	    // OPPLParser.g:90:51: COMMA atomic
                    	    {
                    	    COMMA46=(Token)match(input,COMMA,FOLLOW_COMMA_in_constraint670); if (state.failed) return retval; 
                    	    if ( state.backtracking==0 ) stream_COMMA.add(COMMA46);

                    	    pushFollow(FOLLOW_atomic_in_constraint672);
                    	    atomic47=gOPPLPatternScript.atomic();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) stream_atomic.add(atomic47.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop9;
                        }
                    } while (true);

                    CLOSED_CURLY_BRACES48=(Token)match(input,CLOSED_CURLY_BRACES,FOLLOW_CLOSED_CURLY_BRACES_in_constraint676); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_CLOSED_CURLY_BRACES.add(CLOSED_CURLY_BRACES48);



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
                    // 90:87: -> ^( IN_SET_CONSTRAINT IDENTIFIER[$VARIABLE_NAME] ( atomic )+ )
                    {
                        // OPPLParser.g:90:90: ^( IN_SET_CONSTRAINT IDENTIFIER[$VARIABLE_NAME] ( atomic )+ )
                        {
                        OPPLSyntaxTree root_1 = (OPPLSyntaxTree)adaptor.nil();
                        root_1 = (OPPLSyntaxTree)adaptor.becomeRoot((OPPLSyntaxTree)adaptor.create(IN_SET_CONSTRAINT, "IN_SET_CONSTRAINT"), root_1);

                        adaptor.addChild(root_1, (OPPLSyntaxTree)adaptor.create(IDENTIFIER, VARIABLE_NAME42));
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
                    // OPPLParser.g:91:8: VARIABLE_NAME MATCH OPEN_PARENTHESYS stringOperation CLOSED_PARENTHESYS
                    {
                    VARIABLE_NAME49=(Token)match(input,VARIABLE_NAME,FOLLOW_VARIABLE_NAME_in_constraint698); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_VARIABLE_NAME.add(VARIABLE_NAME49);

                    MATCH50=(Token)match(input,MATCH,FOLLOW_MATCH_in_constraint700); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_MATCH.add(MATCH50);

                    OPEN_PARENTHESYS51=(Token)match(input,OPEN_PARENTHESYS,FOLLOW_OPEN_PARENTHESYS_in_constraint702); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_OPEN_PARENTHESYS.add(OPEN_PARENTHESYS51);

                    pushFollow(FOLLOW_stringOperation_in_constraint704);
                    stringOperation52=stringOperation();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_stringOperation.add(stringOperation52.getTree());
                    CLOSED_PARENTHESYS53=(Token)match(input,CLOSED_PARENTHESYS,FOLLOW_CLOSED_PARENTHESYS_in_constraint706); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_CLOSED_PARENTHESYS.add(CLOSED_PARENTHESYS53);



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
                    // 91:80: -> ^( REGEXP_CONSTRAINT IDENTIFIER[$VARIABLE_NAME] stringOperation )
                    {
                        // OPPLParser.g:91:83: ^( REGEXP_CONSTRAINT IDENTIFIER[$VARIABLE_NAME] stringOperation )
                        {
                        OPPLSyntaxTree root_1 = (OPPLSyntaxTree)adaptor.nil();
                        root_1 = (OPPLSyntaxTree)adaptor.becomeRoot((OPPLSyntaxTree)adaptor.create(REGEXP_CONSTRAINT, "REGEXP_CONSTRAINT"), root_1);

                        adaptor.addChild(root_1, (OPPLSyntaxTree)adaptor.create(IDENTIFIER, VARIABLE_NAME49));
                        adaptor.addChild(root_1, stream_stringOperation.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 4 :
                    // OPPLParser.g:92:7: FAIL axiom
                    {
                    FAIL54=(Token)match(input,FAIL,FOLLOW_FAIL_in_constraint725); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_FAIL.add(FAIL54);

                    pushFollow(FOLLOW_axiom_in_constraint727);
                    axiom55=gOPPLPatternScript.axiom();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_axiom.add(axiom55.getTree());


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
                    // 92:18: -> ^( NAF_CONSTRAINT axiom )
                    {
                        // OPPLParser.g:92:21: ^( NAF_CONSTRAINT axiom )
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
    // OPPLParser.g:95:2: actions : BEGIN action ( COMMA action )* END -> ^( ACTIONS ( action )+ ) ;
    public final OPPLPatternScript_OPPLParser.actions_return actions() throws RecognitionException {
        OPPLPatternScript_OPPLParser.actions_return retval = new OPPLPatternScript_OPPLParser.actions_return();
        retval.start = input.LT(1);

        OPPLSyntaxTree root_0 = null;

        Token BEGIN56=null;
        Token COMMA58=null;
        Token END60=null;
        OPPLPatternScript_OPPLParser.action_return action57 = null;

        OPPLPatternScript_OPPLParser.action_return action59 = null;


        OPPLSyntaxTree BEGIN56_tree=null;
        OPPLSyntaxTree COMMA58_tree=null;
        OPPLSyntaxTree END60_tree=null;
        RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
        RewriteRuleTokenStream stream_END=new RewriteRuleTokenStream(adaptor,"token END");
        RewriteRuleTokenStream stream_BEGIN=new RewriteRuleTokenStream(adaptor,"token BEGIN");
        RewriteRuleSubtreeStream stream_action=new RewriteRuleSubtreeStream(adaptor,"rule action");
        try {
            // OPPLParser.g:96:3: ( BEGIN action ( COMMA action )* END -> ^( ACTIONS ( action )+ ) )
            // OPPLParser.g:97:5: BEGIN action ( COMMA action )* END
            {
            BEGIN56=(Token)match(input,BEGIN,FOLLOW_BEGIN_in_actions755); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_BEGIN.add(BEGIN56);

            pushFollow(FOLLOW_action_in_actions757);
            action57=action();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_action.add(action57.getTree());
            // OPPLParser.g:97:18: ( COMMA action )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==COMMA) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // OPPLParser.g:97:19: COMMA action
            	    {
            	    COMMA58=(Token)match(input,COMMA,FOLLOW_COMMA_in_actions760); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_COMMA.add(COMMA58);

            	    pushFollow(FOLLOW_action_in_actions762);
            	    action59=action();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_action.add(action59.getTree());

            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);

            END60=(Token)match(input,END,FOLLOW_END_in_actions766); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_END.add(END60);



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
            // 97:38: -> ^( ACTIONS ( action )+ )
            {
                // OPPLParser.g:97:41: ^( ACTIONS ( action )+ )
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
    // OPPLParser.g:100:2: action : ( ADD axiom -> ^( ADD axiom ) | REMOVE axiom -> ^( REMOVE axiom ) );
    public final OPPLPatternScript_OPPLParser.action_return action() throws RecognitionException {
        OPPLPatternScript_OPPLParser.action_return retval = new OPPLPatternScript_OPPLParser.action_return();
        retval.start = input.LT(1);

        OPPLSyntaxTree root_0 = null;

        Token ADD61=null;
        Token REMOVE63=null;
        OPPLPatternScript_OPPLParser_MOWLParser.axiom_return axiom62 = null;

        OPPLPatternScript_OPPLParser_MOWLParser.axiom_return axiom64 = null;


        OPPLSyntaxTree ADD61_tree=null;
        OPPLSyntaxTree REMOVE63_tree=null;
        RewriteRuleTokenStream stream_REMOVE=new RewriteRuleTokenStream(adaptor,"token REMOVE");
        RewriteRuleTokenStream stream_ADD=new RewriteRuleTokenStream(adaptor,"token ADD");
        RewriteRuleSubtreeStream stream_axiom=new RewriteRuleSubtreeStream(adaptor,"rule axiom");
        try {
            // OPPLParser.g:101:3: ( ADD axiom -> ^( ADD axiom ) | REMOVE axiom -> ^( REMOVE axiom ) )
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==ADD) ) {
                alt12=1;
            }
            else if ( (LA12_0==REMOVE) ) {
                alt12=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;
            }
            switch (alt12) {
                case 1 :
                    // OPPLParser.g:102:7: ADD axiom
                    {
                    ADD61=(Token)match(input,ADD,FOLLOW_ADD_in_action798); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_ADD.add(ADD61);

                    pushFollow(FOLLOW_axiom_in_action800);
                    axiom62=gOPPLPatternScript.axiom();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_axiom.add(axiom62.getTree());


                    // AST REWRITE
                    // elements: axiom, ADD
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (OPPLSyntaxTree)adaptor.nil();
                    // 102:17: -> ^( ADD axiom )
                    {
                        // OPPLParser.g:102:20: ^( ADD axiom )
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
                    // OPPLParser.g:103:7: REMOVE axiom
                    {
                    REMOVE63=(Token)match(input,REMOVE,FOLLOW_REMOVE_in_action816); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_REMOVE.add(REMOVE63);

                    pushFollow(FOLLOW_axiom_in_action818);
                    axiom64=gOPPLPatternScript.axiom();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_axiom.add(axiom64.getTree());


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
                    // 103:20: -> ^( REMOVE axiom )
                    {
                        // OPPLParser.g:103:23: ^( REMOVE axiom )
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
    // OPPLParser.g:109:1: opplFunction : ( CREATE OPEN_PARENTHESYS stringOperation CLOSED_PARENTHESYS -> ^( CREATE_OPPL_FUNCTION stringOperation ) | CREATE_INTERSECTION OPEN_PARENTHESYS atomic ( COMMA atomic )* CLOSED_PARENTHESYS -> ^( CREATE_INTERSECTION ( atomic )+ ) | CREATE_DISJUNCTION OPEN_PARENTHESYS atomic CLOSED_PARENTHESYS -> ^( CREATE_DISJUNCTION atomic ) );
    public final OPPLPatternScript_OPPLParser.opplFunction_return opplFunction() throws RecognitionException {
        OPPLPatternScript_OPPLParser.opplFunction_return retval = new OPPLPatternScript_OPPLParser.opplFunction_return();
        retval.start = input.LT(1);

        OPPLSyntaxTree root_0 = null;

        Token CREATE65=null;
        Token OPEN_PARENTHESYS66=null;
        Token CLOSED_PARENTHESYS68=null;
        Token CREATE_INTERSECTION69=null;
        Token OPEN_PARENTHESYS70=null;
        Token COMMA72=null;
        Token CLOSED_PARENTHESYS74=null;
        Token CREATE_DISJUNCTION75=null;
        Token OPEN_PARENTHESYS76=null;
        Token CLOSED_PARENTHESYS78=null;
        OPPLPatternScript_OPPLParser.stringOperation_return stringOperation67 = null;

        OPPLPatternScriptParser.atomic_return atomic71 = null;

        OPPLPatternScriptParser.atomic_return atomic73 = null;

        OPPLPatternScriptParser.atomic_return atomic77 = null;


        OPPLSyntaxTree CREATE65_tree=null;
        OPPLSyntaxTree OPEN_PARENTHESYS66_tree=null;
        OPPLSyntaxTree CLOSED_PARENTHESYS68_tree=null;
        OPPLSyntaxTree CREATE_INTERSECTION69_tree=null;
        OPPLSyntaxTree OPEN_PARENTHESYS70_tree=null;
        OPPLSyntaxTree COMMA72_tree=null;
        OPPLSyntaxTree CLOSED_PARENTHESYS74_tree=null;
        OPPLSyntaxTree CREATE_DISJUNCTION75_tree=null;
        OPPLSyntaxTree OPEN_PARENTHESYS76_tree=null;
        OPPLSyntaxTree CLOSED_PARENTHESYS78_tree=null;
        RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
        RewriteRuleTokenStream stream_CREATE_INTERSECTION=new RewriteRuleTokenStream(adaptor,"token CREATE_INTERSECTION");
        RewriteRuleTokenStream stream_CLOSED_PARENTHESYS=new RewriteRuleTokenStream(adaptor,"token CLOSED_PARENTHESYS");
        RewriteRuleTokenStream stream_OPEN_PARENTHESYS=new RewriteRuleTokenStream(adaptor,"token OPEN_PARENTHESYS");
        RewriteRuleTokenStream stream_CREATE_DISJUNCTION=new RewriteRuleTokenStream(adaptor,"token CREATE_DISJUNCTION");
        RewriteRuleTokenStream stream_CREATE=new RewriteRuleTokenStream(adaptor,"token CREATE");
        RewriteRuleSubtreeStream stream_stringOperation=new RewriteRuleSubtreeStream(adaptor,"rule stringOperation");
        RewriteRuleSubtreeStream stream_atomic=new RewriteRuleSubtreeStream(adaptor,"rule atomic");
        try {
            // OPPLParser.g:110:3: ( CREATE OPEN_PARENTHESYS stringOperation CLOSED_PARENTHESYS -> ^( CREATE_OPPL_FUNCTION stringOperation ) | CREATE_INTERSECTION OPEN_PARENTHESYS atomic ( COMMA atomic )* CLOSED_PARENTHESYS -> ^( CREATE_INTERSECTION ( atomic )+ ) | CREATE_DISJUNCTION OPEN_PARENTHESYS atomic CLOSED_PARENTHESYS -> ^( CREATE_DISJUNCTION atomic ) )
            int alt14=3;
            switch ( input.LA(1) ) {
            case CREATE:
                {
                alt14=1;
                }
                break;
            case CREATE_INTERSECTION:
                {
                alt14=2;
                }
                break;
            case CREATE_DISJUNCTION:
                {
                alt14=3;
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
                    // OPPLParser.g:111:7: CREATE OPEN_PARENTHESYS stringOperation CLOSED_PARENTHESYS
                    {
                    CREATE65=(Token)match(input,CREATE,FOLLOW_CREATE_in_opplFunction851); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_CREATE.add(CREATE65);

                    OPEN_PARENTHESYS66=(Token)match(input,OPEN_PARENTHESYS,FOLLOW_OPEN_PARENTHESYS_in_opplFunction853); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_OPEN_PARENTHESYS.add(OPEN_PARENTHESYS66);

                    pushFollow(FOLLOW_stringOperation_in_opplFunction855);
                    stringOperation67=stringOperation();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_stringOperation.add(stringOperation67.getTree());
                    CLOSED_PARENTHESYS68=(Token)match(input,CLOSED_PARENTHESYS,FOLLOW_CLOSED_PARENTHESYS_in_opplFunction857); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_CLOSED_PARENTHESYS.add(CLOSED_PARENTHESYS68);



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
                    // 111:66: -> ^( CREATE_OPPL_FUNCTION stringOperation )
                    {
                        // OPPLParser.g:111:69: ^( CREATE_OPPL_FUNCTION stringOperation )
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
                    // OPPLParser.g:112:7: CREATE_INTERSECTION OPEN_PARENTHESYS atomic ( COMMA atomic )* CLOSED_PARENTHESYS
                    {
                    CREATE_INTERSECTION69=(Token)match(input,CREATE_INTERSECTION,FOLLOW_CREATE_INTERSECTION_in_opplFunction873); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_CREATE_INTERSECTION.add(CREATE_INTERSECTION69);

                    OPEN_PARENTHESYS70=(Token)match(input,OPEN_PARENTHESYS,FOLLOW_OPEN_PARENTHESYS_in_opplFunction876); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_OPEN_PARENTHESYS.add(OPEN_PARENTHESYS70);

                    pushFollow(FOLLOW_atomic_in_opplFunction878);
                    atomic71=gOPPLPatternScript.atomic();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_atomic.add(atomic71.getTree());
                    // OPPLParser.g:112:52: ( COMMA atomic )*
                    loop13:
                    do {
                        int alt13=2;
                        int LA13_0 = input.LA(1);

                        if ( (LA13_0==COMMA) ) {
                            alt13=1;
                        }


                        switch (alt13) {
                    	case 1 :
                    	    // OPPLParser.g:112:53: COMMA atomic
                    	    {
                    	    COMMA72=(Token)match(input,COMMA,FOLLOW_COMMA_in_opplFunction881); if (state.failed) return retval; 
                    	    if ( state.backtracking==0 ) stream_COMMA.add(COMMA72);

                    	    pushFollow(FOLLOW_atomic_in_opplFunction883);
                    	    atomic73=gOPPLPatternScript.atomic();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) stream_atomic.add(atomic73.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop13;
                        }
                    } while (true);

                    CLOSED_PARENTHESYS74=(Token)match(input,CLOSED_PARENTHESYS,FOLLOW_CLOSED_PARENTHESYS_in_opplFunction888); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_CLOSED_PARENTHESYS.add(CLOSED_PARENTHESYS74);



                    // AST REWRITE
                    // elements: atomic, CREATE_INTERSECTION
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (OPPLSyntaxTree)adaptor.nil();
                    // 112:88: -> ^( CREATE_INTERSECTION ( atomic )+ )
                    {
                        // OPPLParser.g:112:91: ^( CREATE_INTERSECTION ( atomic )+ )
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
                    // OPPLParser.g:113:7: CREATE_DISJUNCTION OPEN_PARENTHESYS atomic CLOSED_PARENTHESYS
                    {
                    CREATE_DISJUNCTION75=(Token)match(input,CREATE_DISJUNCTION,FOLLOW_CREATE_DISJUNCTION_in_opplFunction905); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_CREATE_DISJUNCTION.add(CREATE_DISJUNCTION75);

                    OPEN_PARENTHESYS76=(Token)match(input,OPEN_PARENTHESYS,FOLLOW_OPEN_PARENTHESYS_in_opplFunction907); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_OPEN_PARENTHESYS.add(OPEN_PARENTHESYS76);

                    pushFollow(FOLLOW_atomic_in_opplFunction909);
                    atomic77=gOPPLPatternScript.atomic();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_atomic.add(atomic77.getTree());
                    CLOSED_PARENTHESYS78=(Token)match(input,CLOSED_PARENTHESYS,FOLLOW_CLOSED_PARENTHESYS_in_opplFunction911); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_CLOSED_PARENTHESYS.add(CLOSED_PARENTHESYS78);



                    // AST REWRITE
                    // elements: CREATE_DISJUNCTION, atomic
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (OPPLSyntaxTree)adaptor.nil();
                    // 113:69: -> ^( CREATE_DISJUNCTION atomic )
                    {
                        // OPPLParser.g:113:72: ^( CREATE_DISJUNCTION atomic )
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
    // OPPLParser.g:116:1: stringOperation : stringExpression ( PLUS stringExpression )* -> ^( STRING_OPERATION ( stringExpression )+ ) ;
    public final OPPLPatternScript_OPPLParser.stringOperation_return stringOperation() throws RecognitionException {
        OPPLPatternScript_OPPLParser.stringOperation_return retval = new OPPLPatternScript_OPPLParser.stringOperation_return();
        retval.start = input.LT(1);

        OPPLSyntaxTree root_0 = null;

        Token PLUS80=null;
        OPPLPatternScript_OPPLParser.stringExpression_return stringExpression79 = null;

        OPPLPatternScript_OPPLParser.stringExpression_return stringExpression81 = null;


        OPPLSyntaxTree PLUS80_tree=null;
        RewriteRuleTokenStream stream_PLUS=new RewriteRuleTokenStream(adaptor,"token PLUS");
        RewriteRuleSubtreeStream stream_stringExpression=new RewriteRuleSubtreeStream(adaptor,"rule stringExpression");
        try {
            // OPPLParser.g:117:3: ( stringExpression ( PLUS stringExpression )* -> ^( STRING_OPERATION ( stringExpression )+ ) )
            // OPPLParser.g:118:5: stringExpression ( PLUS stringExpression )*
            {
            pushFollow(FOLLOW_stringExpression_in_stringOperation936);
            stringExpression79=stringExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_stringExpression.add(stringExpression79.getTree());
            // OPPLParser.g:118:22: ( PLUS stringExpression )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==PLUS) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // OPPLParser.g:118:23: PLUS stringExpression
            	    {
            	    PLUS80=(Token)match(input,PLUS,FOLLOW_PLUS_in_stringOperation939); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_PLUS.add(PLUS80);

            	    pushFollow(FOLLOW_stringExpression_in_stringOperation941);
            	    stringExpression81=stringExpression();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_stringExpression.add(stringExpression81.getTree());

            	    }
            	    break;

            	default :
            	    break loop15;
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
            // 118:47: -> ^( STRING_OPERATION ( stringExpression )+ )
            {
                // OPPLParser.g:118:50: ^( STRING_OPERATION ( stringExpression )+ )
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
    // OPPLParser.g:121:1: stringExpression : ( DBLQUOTE -> ^( DBLQUOTE ) | variableAttributeReference -> ^( variableAttributeReference ) );
    public final OPPLPatternScript_OPPLParser.stringExpression_return stringExpression() throws RecognitionException {
        OPPLPatternScript_OPPLParser.stringExpression_return retval = new OPPLPatternScript_OPPLParser.stringExpression_return();
        retval.start = input.LT(1);

        OPPLSyntaxTree root_0 = null;

        Token DBLQUOTE82=null;
        OPPLPatternScript_OPPLParser.variableAttributeReference_return variableAttributeReference83 = null;


        OPPLSyntaxTree DBLQUOTE82_tree=null;
        RewriteRuleTokenStream stream_DBLQUOTE=new RewriteRuleTokenStream(adaptor,"token DBLQUOTE");
        RewriteRuleSubtreeStream stream_variableAttributeReference=new RewriteRuleSubtreeStream(adaptor,"rule variableAttributeReference");
        try {
            // OPPLParser.g:122:2: ( DBLQUOTE -> ^( DBLQUOTE ) | variableAttributeReference -> ^( variableAttributeReference ) )
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==DBLQUOTE) ) {
                alt16=1;
            }
            else if ( (LA16_0==VARIABLE_NAME) ) {
                alt16=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 16, 0, input);

                throw nvae;
            }
            switch (alt16) {
                case 1 :
                    // OPPLParser.g:123:3: DBLQUOTE
                    {
                    DBLQUOTE82=(Token)match(input,DBLQUOTE,FOLLOW_DBLQUOTE_in_stringExpression968); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_DBLQUOTE.add(DBLQUOTE82);



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
                    // 123:12: -> ^( DBLQUOTE )
                    {
                        // OPPLParser.g:123:15: ^( DBLQUOTE )
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
                    // OPPLParser.g:124:8: variableAttributeReference
                    {
                    pushFollow(FOLLOW_variableAttributeReference_in_stringExpression983);
                    variableAttributeReference83=variableAttributeReference();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_variableAttributeReference.add(variableAttributeReference83.getTree());


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
                    // 124:35: -> ^( variableAttributeReference )
                    {
                        // OPPLParser.g:124:38: ^( variableAttributeReference )
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

    public static class iri_return extends ParserRuleReturnScope {
        OPPLSyntaxTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "iri"
    // OPPLParser.g:136:1: iri : ( IRI -> IRI | VARIABLE_NAME DOT IRI_ATTRIBUTE_NAME -> ^( IRI[$VARIABLE_NAME.getText()+ $DOT.getText()+ $IRI_ATTRIBUTE_NAME.getText()] VARIABLE_NAME ) );
    public final OPPLPatternScript_OPPLParser.iri_return iri() throws RecognitionException {
        OPPLPatternScript_OPPLParser.iri_return retval = new OPPLPatternScript_OPPLParser.iri_return();
        retval.start = input.LT(1);

        OPPLSyntaxTree root_0 = null;

        Token IRI84=null;
        Token VARIABLE_NAME85=null;
        Token DOT86=null;
        Token IRI_ATTRIBUTE_NAME87=null;

        OPPLSyntaxTree IRI84_tree=null;
        OPPLSyntaxTree VARIABLE_NAME85_tree=null;
        OPPLSyntaxTree DOT86_tree=null;
        OPPLSyntaxTree IRI_ATTRIBUTE_NAME87_tree=null;
        RewriteRuleTokenStream stream_IRI=new RewriteRuleTokenStream(adaptor,"token IRI");
        RewriteRuleTokenStream stream_IRI_ATTRIBUTE_NAME=new RewriteRuleTokenStream(adaptor,"token IRI_ATTRIBUTE_NAME");
        RewriteRuleTokenStream stream_VARIABLE_NAME=new RewriteRuleTokenStream(adaptor,"token VARIABLE_NAME");
        RewriteRuleTokenStream stream_DOT=new RewriteRuleTokenStream(adaptor,"token DOT");

        try {
            // OPPLParser.g:137:2: ( IRI -> IRI | VARIABLE_NAME DOT IRI_ATTRIBUTE_NAME -> ^( IRI[$VARIABLE_NAME.getText()+ $DOT.getText()+ $IRI_ATTRIBUTE_NAME.getText()] VARIABLE_NAME ) )
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==IRI) ) {
                alt18=1;
            }
            else if ( (LA18_0==VARIABLE_NAME) ) {
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
                    // OPPLParser.g:138:2: IRI
                    {
                    IRI84=(Token)match(input,IRI,FOLLOW_IRI_in_iri1073); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_IRI.add(IRI84);



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
                    // 138:6: -> IRI
                    {
                        adaptor.addChild(root_0, stream_IRI.nextNode());

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 2 :
                    // OPPLParser.g:139:4: VARIABLE_NAME DOT IRI_ATTRIBUTE_NAME
                    {
                    VARIABLE_NAME85=(Token)match(input,VARIABLE_NAME,FOLLOW_VARIABLE_NAME_in_iri1082); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_VARIABLE_NAME.add(VARIABLE_NAME85);

                    DOT86=(Token)match(input,DOT,FOLLOW_DOT_in_iri1084); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_DOT.add(DOT86);

                    IRI_ATTRIBUTE_NAME87=(Token)match(input,IRI_ATTRIBUTE_NAME,FOLLOW_IRI_ATTRIBUTE_NAME_in_iri1086); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_IRI_ATTRIBUTE_NAME.add(IRI_ATTRIBUTE_NAME87);



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
                    // 139:41: -> ^( IRI[$VARIABLE_NAME.getText()+ $DOT.getText()+ $IRI_ATTRIBUTE_NAME.getText()] VARIABLE_NAME )
                    {
                        // OPPLParser.g:139:44: ^( IRI[$VARIABLE_NAME.getText()+ $DOT.getText()+ $IRI_ATTRIBUTE_NAME.getText()] VARIABLE_NAME )
                        {
                        OPPLSyntaxTree root_1 = (OPPLSyntaxTree)adaptor.nil();
                        root_1 = (OPPLSyntaxTree)adaptor.becomeRoot((OPPLSyntaxTree)adaptor.create(IRI, VARIABLE_NAME85.getText()+ DOT86.getText()+ IRI_ATTRIBUTE_NAME87.getText()), root_1);

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
    // OPPLParser.g:142:1: createIdentifier : ESCLAMATION_MARK IDENTIFIER -> ^( IDENTIFIER[$ESCLAMATION_MARK.getText()+ $IDENTIFIER.getText()] ) ;
    public final OPPLPatternScript_OPPLParser.createIdentifier_return createIdentifier() throws RecognitionException {
        OPPLPatternScript_OPPLParser.createIdentifier_return retval = new OPPLPatternScript_OPPLParser.createIdentifier_return();
        retval.start = input.LT(1);

        OPPLSyntaxTree root_0 = null;

        Token ESCLAMATION_MARK88=null;
        Token IDENTIFIER89=null;

        OPPLSyntaxTree ESCLAMATION_MARK88_tree=null;
        OPPLSyntaxTree IDENTIFIER89_tree=null;
        RewriteRuleTokenStream stream_IDENTIFIER=new RewriteRuleTokenStream(adaptor,"token IDENTIFIER");
        RewriteRuleTokenStream stream_ESCLAMATION_MARK=new RewriteRuleTokenStream(adaptor,"token ESCLAMATION_MARK");

        try {
            // OPPLParser.g:143:3: ( ESCLAMATION_MARK IDENTIFIER -> ^( IDENTIFIER[$ESCLAMATION_MARK.getText()+ $IDENTIFIER.getText()] ) )
            // OPPLParser.g:144:4: ESCLAMATION_MARK IDENTIFIER
            {
            ESCLAMATION_MARK88=(Token)match(input,ESCLAMATION_MARK,FOLLOW_ESCLAMATION_MARK_in_createIdentifier1110); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_ESCLAMATION_MARK.add(ESCLAMATION_MARK88);

            IDENTIFIER89=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_createIdentifier1112); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_IDENTIFIER.add(IDENTIFIER89);



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
            // 144:33: -> ^( IDENTIFIER[$ESCLAMATION_MARK.getText()+ $IDENTIFIER.getText()] )
            {
                // OPPLParser.g:144:36: ^( IDENTIFIER[$ESCLAMATION_MARK.getText()+ $IDENTIFIER.getText()] )
                {
                OPPLSyntaxTree root_1 = (OPPLSyntaxTree)adaptor.nil();
                root_1 = (OPPLSyntaxTree)adaptor.becomeRoot((OPPLSyntaxTree)adaptor.create(IDENTIFIER, ESCLAMATION_MARK88.getText()+ IDENTIFIER89.getText()), root_1);

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
    // OPPLParser.g:147:1: variableAttributeReference : ( VARIABLE_NAME DOT (a= VALUES | a= RENDERING ) -> ^( IDENTIFIER[$VARIABLE_NAME.getText()+$DOT.getText() + $a.getText()] VARIABLE_NAME DOT $a) | VARIABLE_NAME DOT GROUPS attributeSelector -> ^( IDENTIFIER[$VARIABLE_NAME.getText()+$DOT.getText() + $GROUPS.getText()+$attributeSelector.selectorText] VARIABLE_NAME DOT GROUPS attributeSelector ) );
    public final OPPLPatternScript_OPPLParser.variableAttributeReference_return variableAttributeReference() throws RecognitionException {
        OPPLPatternScript_OPPLParser.variableAttributeReference_return retval = new OPPLPatternScript_OPPLParser.variableAttributeReference_return();
        retval.start = input.LT(1);

        OPPLSyntaxTree root_0 = null;

        Token a=null;
        Token VARIABLE_NAME90=null;
        Token DOT91=null;
        Token VARIABLE_NAME92=null;
        Token DOT93=null;
        Token GROUPS94=null;
        OPPLPatternScript_OPPLParser.attributeSelector_return attributeSelector95 = null;


        OPPLSyntaxTree a_tree=null;
        OPPLSyntaxTree VARIABLE_NAME90_tree=null;
        OPPLSyntaxTree DOT91_tree=null;
        OPPLSyntaxTree VARIABLE_NAME92_tree=null;
        OPPLSyntaxTree DOT93_tree=null;
        OPPLSyntaxTree GROUPS94_tree=null;
        RewriteRuleTokenStream stream_VALUES=new RewriteRuleTokenStream(adaptor,"token VALUES");
        RewriteRuleTokenStream stream_GROUPS=new RewriteRuleTokenStream(adaptor,"token GROUPS");
        RewriteRuleTokenStream stream_RENDERING=new RewriteRuleTokenStream(adaptor,"token RENDERING");
        RewriteRuleTokenStream stream_VARIABLE_NAME=new RewriteRuleTokenStream(adaptor,"token VARIABLE_NAME");
        RewriteRuleTokenStream stream_DOT=new RewriteRuleTokenStream(adaptor,"token DOT");
        RewriteRuleSubtreeStream stream_attributeSelector=new RewriteRuleSubtreeStream(adaptor,"rule attributeSelector");
        try {
            // OPPLParser.g:148:3: ( VARIABLE_NAME DOT (a= VALUES | a= RENDERING ) -> ^( IDENTIFIER[$VARIABLE_NAME.getText()+$DOT.getText() + $a.getText()] VARIABLE_NAME DOT $a) | VARIABLE_NAME DOT GROUPS attributeSelector -> ^( IDENTIFIER[$VARIABLE_NAME.getText()+$DOT.getText() + $GROUPS.getText()+$attributeSelector.selectorText] VARIABLE_NAME DOT GROUPS attributeSelector ) )
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==VARIABLE_NAME) ) {
                int LA20_1 = input.LA(2);

                if ( (LA20_1==DOT) ) {
                    int LA20_2 = input.LA(3);

                    if ( (LA20_2==GROUPS) ) {
                        alt20=2;
                    }
                    else if ( ((LA20_2>=VALUES && LA20_2<=RENDERING)) ) {
                        alt20=1;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 20, 2, input);

                        throw nvae;
                    }
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 20, 1, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 20, 0, input);

                throw nvae;
            }
            switch (alt20) {
                case 1 :
                    // OPPLParser.g:149:5: VARIABLE_NAME DOT (a= VALUES | a= RENDERING )
                    {
                    VARIABLE_NAME90=(Token)match(input,VARIABLE_NAME,FOLLOW_VARIABLE_NAME_in_variableAttributeReference1139); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_VARIABLE_NAME.add(VARIABLE_NAME90);

                    DOT91=(Token)match(input,DOT,FOLLOW_DOT_in_variableAttributeReference1141); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_DOT.add(DOT91);

                    // OPPLParser.g:149:23: (a= VALUES | a= RENDERING )
                    int alt19=2;
                    int LA19_0 = input.LA(1);

                    if ( (LA19_0==VALUES) ) {
                        alt19=1;
                    }
                    else if ( (LA19_0==RENDERING) ) {
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
                            // OPPLParser.g:149:24: a= VALUES
                            {
                            a=(Token)match(input,VALUES,FOLLOW_VALUES_in_variableAttributeReference1148); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_VALUES.add(a);


                            }
                            break;
                        case 2 :
                            // OPPLParser.g:149:37: a= RENDERING
                            {
                            a=(Token)match(input,RENDERING,FOLLOW_RENDERING_in_variableAttributeReference1156); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_RENDERING.add(a);


                            }
                            break;

                    }



                    // AST REWRITE
                    // elements: VARIABLE_NAME, a, DOT
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
                    // 149:54: -> ^( IDENTIFIER[$VARIABLE_NAME.getText()+$DOT.getText() + $a.getText()] VARIABLE_NAME DOT $a)
                    {
                        // OPPLParser.g:149:56: ^( IDENTIFIER[$VARIABLE_NAME.getText()+$DOT.getText() + $a.getText()] VARIABLE_NAME DOT $a)
                        {
                        OPPLSyntaxTree root_1 = (OPPLSyntaxTree)adaptor.nil();
                        root_1 = (OPPLSyntaxTree)adaptor.becomeRoot((OPPLSyntaxTree)adaptor.create(IDENTIFIER, VARIABLE_NAME90.getText()+DOT91.getText() + a.getText()), root_1);

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
                    // OPPLParser.g:150:7: VARIABLE_NAME DOT GROUPS attributeSelector
                    {
                    VARIABLE_NAME92=(Token)match(input,VARIABLE_NAME,FOLLOW_VARIABLE_NAME_in_variableAttributeReference1180); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_VARIABLE_NAME.add(VARIABLE_NAME92);

                    DOT93=(Token)match(input,DOT,FOLLOW_DOT_in_variableAttributeReference1182); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_DOT.add(DOT93);

                    GROUPS94=(Token)match(input,GROUPS,FOLLOW_GROUPS_in_variableAttributeReference1184); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_GROUPS.add(GROUPS94);

                    pushFollow(FOLLOW_attributeSelector_in_variableAttributeReference1186);
                    attributeSelector95=attributeSelector();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_attributeSelector.add(attributeSelector95.getTree());


                    // AST REWRITE
                    // elements: VARIABLE_NAME, attributeSelector, GROUPS, DOT
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (OPPLSyntaxTree)adaptor.nil();
                    // 150:51: -> ^( IDENTIFIER[$VARIABLE_NAME.getText()+$DOT.getText() + $GROUPS.getText()+$attributeSelector.selectorText] VARIABLE_NAME DOT GROUPS attributeSelector )
                    {
                        // OPPLParser.g:150:53: ^( IDENTIFIER[$VARIABLE_NAME.getText()+$DOT.getText() + $GROUPS.getText()+$attributeSelector.selectorText] VARIABLE_NAME DOT GROUPS attributeSelector )
                        {
                        OPPLSyntaxTree root_1 = (OPPLSyntaxTree)adaptor.nil();
                        root_1 = (OPPLSyntaxTree)adaptor.becomeRoot((OPPLSyntaxTree)adaptor.create(IDENTIFIER, VARIABLE_NAME92.getText()+DOT93.getText() + GROUPS94.getText()+(attributeSelector95!=null?attributeSelector95.selectorText:null)), root_1);

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
    // OPPLParser.g:155:1: attributeSelector returns [String selectorText] : OPEN_PARENTHESYS i= INTEGER CLOSED_PARENTHESYS -> ^( ATTRIBUTE_SELECTOR INTEGER ) ;
    public final OPPLPatternScript_OPPLParser.attributeSelector_return attributeSelector() throws RecognitionException {
        OPPLPatternScript_OPPLParser.attributeSelector_return retval = new OPPLPatternScript_OPPLParser.attributeSelector_return();
        retval.start = input.LT(1);

        OPPLSyntaxTree root_0 = null;

        Token i=null;
        Token OPEN_PARENTHESYS96=null;
        Token CLOSED_PARENTHESYS97=null;

        OPPLSyntaxTree i_tree=null;
        OPPLSyntaxTree OPEN_PARENTHESYS96_tree=null;
        OPPLSyntaxTree CLOSED_PARENTHESYS97_tree=null;
        RewriteRuleTokenStream stream_INTEGER=new RewriteRuleTokenStream(adaptor,"token INTEGER");
        RewriteRuleTokenStream stream_CLOSED_PARENTHESYS=new RewriteRuleTokenStream(adaptor,"token CLOSED_PARENTHESYS");
        RewriteRuleTokenStream stream_OPEN_PARENTHESYS=new RewriteRuleTokenStream(adaptor,"token OPEN_PARENTHESYS");

        try {
            // OPPLParser.g:156:3: ( OPEN_PARENTHESYS i= INTEGER CLOSED_PARENTHESYS -> ^( ATTRIBUTE_SELECTOR INTEGER ) )
            // OPPLParser.g:157:5: OPEN_PARENTHESYS i= INTEGER CLOSED_PARENTHESYS
            {
            OPEN_PARENTHESYS96=(Token)match(input,OPEN_PARENTHESYS,FOLLOW_OPEN_PARENTHESYS_in_attributeSelector1235); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_OPEN_PARENTHESYS.add(OPEN_PARENTHESYS96);

            i=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_attributeSelector1241); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_INTEGER.add(i);

            CLOSED_PARENTHESYS97=(Token)match(input,CLOSED_PARENTHESYS,FOLLOW_CLOSED_PARENTHESYS_in_attributeSelector1243); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_CLOSED_PARENTHESYS.add(CLOSED_PARENTHESYS97);

            if ( state.backtracking==0 ) {

                    retval.selectorText = OPEN_PARENTHESYS96.getText() + i.getText() + CLOSED_PARENTHESYS97.getText();
                  
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
            // 161:5: -> ^( ATTRIBUTE_SELECTOR INTEGER )
            {
                // OPPLParser.g:161:9: ^( ATTRIBUTE_SELECTOR INTEGER )
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

    // Delegated rules


 

    public static final BitSet FOLLOW_variableDefinition_in_variableDefinitions216 = new BitSet(new long[]{0x0000002000000002L});
    public static final BitSet FOLLOW_COMMA_in_variableDefinitions219 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_variableDefinition_in_variableDefinitions221 = new BitSet(new long[]{0x0000002000000002L});
    public static final BitSet FOLLOW_VARIABLE_NAME_in_variableDefinition255 = new BitSet(new long[]{0x0000000000000000L,0x0000000000002000L});
    public static final BitSet FOLLOW_COLON_in_variableDefinition257 = new BitSet(new long[]{0x0000000000000000L,0x0000000002000000L});
    public static final BitSet FOLLOW_VARIABLE_TYPE_in_variableDefinition259 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_EQUAL_in_variableDefinition262 = new BitSet(new long[]{0x0000000000000000L,0x0000000000070000L});
    public static final BitSet FOLLOW_opplFunction_in_variableDefinition264 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_VARIABLE_NAME_in_variableDefinition292 = new BitSet(new long[]{0x0000000000000000L,0x0000000000002000L});
    public static final BitSet FOLLOW_COLON_in_variableDefinition294 = new BitSet(new long[]{0x0000000000000000L,0x0000000002000000L});
    public static final BitSet FOLLOW_VARIABLE_TYPE_in_variableDefinition296 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_EQUAL_in_variableDefinition299 = new BitSet(new long[]{0x0000310000081060L,0x0000000000000000L,0x0000000000200000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000100010000L,0x0000000000010000L});
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
    public static final BitSet FOLLOW_SUBCLASS_OF_in_variableScope408 = new BitSet(new long[]{0x0000310000081060L,0x0000000000000000L,0x0000000000200000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000100010000L,0x0000000000010000L});
    public static final BitSet FOLLOW_SUBPROPERTY_OF_in_variableScope416 = new BitSet(new long[]{0x0000310000081060L,0x0000000000000000L,0x0000000000200000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000100010000L,0x0000000000010000L});
    public static final BitSet FOLLOW_SUPER_CLASS_OF_in_variableScope424 = new BitSet(new long[]{0x0000310000081060L,0x0000000000000000L,0x0000000000200000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000100010000L,0x0000000000010000L});
    public static final BitSet FOLLOW_SUPER_PROPERTY_OF_in_variableScope432 = new BitSet(new long[]{0x0000310000081060L,0x0000000000000000L,0x0000000000200000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000100010000L,0x0000000000010000L});
    public static final BitSet FOLLOW_INSTANCE_OF_in_variableScope441 = new BitSet(new long[]{0x0000310000081060L,0x0000000000000000L,0x0000000000200000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000100010000L,0x0000000000010000L});
    public static final BitSet FOLLOW_TYPES_in_variableScope449 = new BitSet(new long[]{0x0000310000081060L,0x0000000000000000L,0x0000000000200000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000100010000L,0x0000000000010000L});
    public static final BitSet FOLLOW_expression_in_variableScope452 = new BitSet(new long[]{0x0000000000000000L,0x0000000000400000L});
    public static final BitSet FOLLOW_CLOSED_SQUARE_BRACKET_in_variableScope454 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MATCH_in_regexp484 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_OPEN_PARENTHESYS_in_regexp486 = new BitSet(new long[]{0x0000010000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_stringOperation_in_regexp488 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_CLOSED_PARENTHESYS_in_regexp490 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SELECT_in_query515 = new BitSet(new long[]{0x0000310FE0081060L,0x0000400000001000L,0x0000000000200000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000100010000L,0x0000000000010000L});
    public static final BitSet FOLLOW_selectClause_in_query517 = new BitSet(new long[]{0x0000002000000002L,0x0000000000000080L});
    public static final BitSet FOLLOW_COMMA_in_query520 = new BitSet(new long[]{0x0000310FE0081060L,0x0000400000001000L,0x0000000000200000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000100010000L,0x0000000000010000L});
    public static final BitSet FOLLOW_selectClause_in_query522 = new BitSet(new long[]{0x0000002000000002L,0x0000000000000080L});
    public static final BitSet FOLLOW_WHERE_in_query527 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000050000L});
    public static final BitSet FOLLOW_constraint_in_query529 = new BitSet(new long[]{0x0000002000000002L});
    public static final BitSet FOLLOW_COMMA_in_query532 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000050000L});
    public static final BitSet FOLLOW_constraint_in_query534 = new BitSet(new long[]{0x0000002000000002L});
    public static final BitSet FOLLOW_ASSERTED_in_selectClause571 = new BitSet(new long[]{0x0000310FE0081060L,0x0000400000001000L,0x0000000000200000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000100010000L,0x0000000000010000L});
    public static final BitSet FOLLOW_axiom_in_selectClause573 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_axiom_in_selectClause589 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_VARIABLE_NAME_in_constraint628 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_NOT_EQUAL_in_constraint630 = new BitSet(new long[]{0x0000310000081060L,0x0000000000000000L,0x0000000000200000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000100010000L,0x0000000000010000L});
    public static final BitSet FOLLOW_expression_in_constraint636 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_VARIABLE_NAME_in_constraint661 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000400L});
    public static final BitSet FOLLOW_IN_in_constraint663 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_OPEN_CURLY_BRACES_in_constraint665 = new BitSet(new long[]{0x0000300000000000L,0x0000000000000000L,0x0000000000200000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000100010000L,0x0000000000010000L});
    public static final BitSet FOLLOW_atomic_in_constraint667 = new BitSet(new long[]{0x0000002000000080L});
    public static final BitSet FOLLOW_COMMA_in_constraint670 = new BitSet(new long[]{0x0000300000000000L,0x0000000000000000L,0x0000000000200000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000100010000L,0x0000000000010000L});
    public static final BitSet FOLLOW_atomic_in_constraint672 = new BitSet(new long[]{0x0000002000000080L});
    public static final BitSet FOLLOW_CLOSED_CURLY_BRACES_in_constraint676 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_VARIABLE_NAME_in_constraint698 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0001000000000000L});
    public static final BitSet FOLLOW_MATCH_in_constraint700 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_OPEN_PARENTHESYS_in_constraint702 = new BitSet(new long[]{0x0000010000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_stringOperation_in_constraint704 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_CLOSED_PARENTHESYS_in_constraint706 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FAIL_in_constraint725 = new BitSet(new long[]{0x0000310FE0081060L,0x0000400000001000L,0x0000000000200000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000100010000L,0x0000000000010000L});
    public static final BitSet FOLLOW_axiom_in_constraint727 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BEGIN_in_actions755 = new BitSet(new long[]{0x0000000000000000L,0x000000000C000000L});
    public static final BitSet FOLLOW_action_in_actions757 = new BitSet(new long[]{0x0000002000000000L,0x0000000000100000L});
    public static final BitSet FOLLOW_COMMA_in_actions760 = new BitSet(new long[]{0x0000000000000000L,0x000000000C000000L});
    public static final BitSet FOLLOW_action_in_actions762 = new BitSet(new long[]{0x0000002000000000L,0x0000000000100000L});
    public static final BitSet FOLLOW_END_in_actions766 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ADD_in_action798 = new BitSet(new long[]{0x0000310FE0081060L,0x0000400000001000L,0x0000000000200000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000100010000L,0x0000000000010000L});
    public static final BitSet FOLLOW_axiom_in_action800 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_REMOVE_in_action816 = new BitSet(new long[]{0x0000310FE0081060L,0x0000400000001000L,0x0000000000200000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000100010000L,0x0000000000010000L});
    public static final BitSet FOLLOW_axiom_in_action818 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CREATE_in_opplFunction851 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_OPEN_PARENTHESYS_in_opplFunction853 = new BitSet(new long[]{0x0000010000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_stringOperation_in_opplFunction855 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_CLOSED_PARENTHESYS_in_opplFunction857 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CREATE_INTERSECTION_in_opplFunction873 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_OPEN_PARENTHESYS_in_opplFunction876 = new BitSet(new long[]{0x0000300000000000L,0x0000000000000000L,0x0000000000200000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000100010000L,0x0000000000010000L});
    public static final BitSet FOLLOW_atomic_in_opplFunction878 = new BitSet(new long[]{0x0000002000000100L});
    public static final BitSet FOLLOW_COMMA_in_opplFunction881 = new BitSet(new long[]{0x0000300000000000L,0x0000000000000000L,0x0000000000200000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000100010000L,0x0000000000010000L});
    public static final BitSet FOLLOW_atomic_in_opplFunction883 = new BitSet(new long[]{0x0000002000000100L});
    public static final BitSet FOLLOW_CLOSED_PARENTHESYS_in_opplFunction888 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CREATE_DISJUNCTION_in_opplFunction905 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_OPEN_PARENTHESYS_in_opplFunction907 = new BitSet(new long[]{0x0000300000000000L,0x0000000000000000L,0x0000000000200000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000100010000L,0x0000000000010000L});
    public static final BitSet FOLLOW_atomic_in_opplFunction909 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_CLOSED_PARENTHESYS_in_opplFunction911 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_stringExpression_in_stringOperation936 = new BitSet(new long[]{0x0000000000000002L,0x0000000000008000L});
    public static final BitSet FOLLOW_PLUS_in_stringOperation939 = new BitSet(new long[]{0x0000010000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_stringExpression_in_stringOperation941 = new BitSet(new long[]{0x0000000000000002L,0x0000000000008000L});
    public static final BitSet FOLLOW_DBLQUOTE_in_stringExpression968 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_variableAttributeReference_in_stringExpression983 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IRI_in_iri1073 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_VARIABLE_NAME_in_iri1082 = new BitSet(new long[]{0x0000000000000000L,0x0000000000004000L});
    public static final BitSet FOLLOW_DOT_in_iri1084 = new BitSet(new long[]{0x0000000000000000L,0x0001000000000000L});
    public static final BitSet FOLLOW_IRI_ATTRIBUTE_NAME_in_iri1086 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ESCLAMATION_MARK_in_createIdentifier1110 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_createIdentifier1112 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_VARIABLE_NAME_in_variableAttributeReference1139 = new BitSet(new long[]{0x0000000000000000L,0x0000000000004000L});
    public static final BitSet FOLLOW_DOT_in_variableAttributeReference1141 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000C00000000L});
    public static final BitSet FOLLOW_VALUES_in_variableAttributeReference1148 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RENDERING_in_variableAttributeReference1156 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_VARIABLE_NAME_in_variableAttributeReference1180 = new BitSet(new long[]{0x0000000000000000L,0x0000000000004000L});
    public static final BitSet FOLLOW_DOT_in_variableAttributeReference1182 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000001000000000L});
    public static final BitSet FOLLOW_GROUPS_in_variableAttributeReference1184 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_attributeSelector_in_variableAttributeReference1186 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OPEN_PARENTHESYS_in_attributeSelector1235 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_INTEGER_in_attributeSelector1241 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_CLOSED_PARENTHESYS_in_attributeSelector1243 = new BitSet(new long[]{0x0000000000000002L});

}