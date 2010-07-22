// $ANTLR 3.2 Sep 23, 2009 12:02:23 OPPLParser.g 2010-07-21 17:44:02

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
    public static final int RETURN=415;
    public static final int VARIABLE_SCOPE=104;
    public static final int INEQUALITY_CONSTRAINT=94;
    public static final int QUESTION_MARK=46;
    public static final int SYMMETRIC=30;
    public static final int CARDINALITY_RESTRICTION=64;
    public static final int SELECT=75;
    public static final int ROLE_ASSERTION=67;
    public static final int DIFFERENT_FROM_AXIOM=53;
    public static final int CREATE_OPPL_FUNCTION=98;
    public static final int TRANSITIVE=34;
    public static final int ANTI_SYMMETRIC=31;
    public static final int ARGUMENTS=417;
    public static final int ALL_RESTRICTION=62;
    public static final int CONJUNCTION=56;
    public static final int OPPL_STATEMENT=107;
    public static final int NEGATED_ASSERTION=59;
    public static final int WHITESPACE=9;
    public static final int MATCH=176;
    public static final int IN_SET_CONSTRAINT=95;
    public static final int SEMICOLON=422;
    public static final int VALUE=18;
    public static final int GROUPS=356;
    public static final int OPEN_CURLY_BRACES=6;
    public static final int DISJUNCTION=55;
    public static final int INVERSE=19;
    public static final int DBLQUOTE=40;
    public static final int STRING_OPERATION=394;
    public static final int OR=11;
    public static final int CONSTANT=70;
    public static final int QUERY=103;
    public static final int ENTITY_REFERENCE=45;
    public static final int END=84;
    public static final int COMPOSITION=4;
    public static final int CLOSED_SQUARE_BRACKET=86;
    public static final int DOLLAR=400;
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
    public static final int OPPL_PATTERN=419;
    public static final int VARIABLE_NAME=464;
    public static final int THIS_CLASS=416;
    public static final int DIFFERENT_FROM=24;
    public static final int IN=74;
    public static final int EQUIVALENT_TO=22;
    public static final int UNARY_AXIOM=54;
    public static final int COMMA=37;
    public static final int CLOSED_CURLY_BRACES=7;
    public static final int IDENTIFIER=44;
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
    public static final int GENERATED_VARIABLE_DEFINITION=97;
    public static final int EXACTLY=17;
    public static final int SUB_PROPERTY_AXIOM=51;
    public static final int OPEN_SQUARE_BRACKET=85;
    public static final int VALUES=354;
    public static final int REGEXP_CONSTRAINT=465;
    public static final int RANGE=28;
    public static final int ONE_OF=65;
    public static final int VARIABLE_DEFINITIONS=102;
    public static final int MIN=15;
    public static final int SUB_CLASS_AXIOM=48;
    public static final int PLAIN_CLAUSE=93;
    public static final int Tokens=47;
    public static final int DOMAIN=27;
    public static final int SUBPROPERTY_OF=105;
    public static final int OPPL_FUNCTION=100;
    public static final int COLON=77;
    public static final int DISJOINT_WITH_AXIOM=50;
    public static final int CREATE_INTERSECTION=81;
    public static final int HYPHEN=465;
    public static final int INVERSE_FUNCTIONAL=35;
    public static final int RENDERING=355;
    public static final int VARIABLE_IDENTIFIER=106;
    public static final int IRREFLEXIVE=33;
    public static final int PLAIN_IDENTIFIER=152;
    public static final int VARIABLE_ATTRIBUTE=99;
    public static final int ASSERTED=76;
    public static final int FUNCTIONAL=29;
    public static final int PROPERTY_CHAIN=57;
    public static final int PATTERN_REFERENCE=421;
    public static final int TYPE_ASSERTION=66;

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
    // OPPLParser.g:44:2: variableDefinitions : variableDefinition ( COMMA variableDefinition )* -> ^( VARIABLE_DEFINITIONS ( variableDefinition )+ ) ;
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
            // OPPLParser.g:45:3: ( variableDefinition ( COMMA variableDefinition )* -> ^( VARIABLE_DEFINITIONS ( variableDefinition )+ ) )
            // OPPLParser.g:46:5: variableDefinition ( COMMA variableDefinition )*
            {
            pushFollow(FOLLOW_variableDefinition_in_variableDefinitions205);
            variableDefinition1=variableDefinition();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_variableDefinition.add(variableDefinition1.getTree());
            // OPPLParser.g:46:24: ( COMMA variableDefinition )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==COMMA) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // OPPLParser.g:46:25: COMMA variableDefinition
            	    {
            	    COMMA2=(Token)match(input,COMMA,FOLLOW_COMMA_in_variableDefinitions208); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_COMMA.add(COMMA2);

            	    pushFollow(FOLLOW_variableDefinition_in_variableDefinitions210);
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
            // 46:52: -> ^( VARIABLE_DEFINITIONS ( variableDefinition )+ )
            {
                // OPPLParser.g:46:55: ^( VARIABLE_DEFINITIONS ( variableDefinition )+ )
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
    // OPPLParser.g:49:2: variableDefinition : ( VARIABLE_NAME COLON VARIABLE_TYPE EQUAL opplFunction -> ^( GENERATED_VARIABLE_DEFINITION VARIABLE_NAME VARIABLE_TYPE ^( opplFunction ) ) | VARIABLE_NAME COLON VARIABLE_TYPE EQUAL expression -> ^( GENERATED_VARIABLE_DEFINITION VARIABLE_NAME VARIABLE_TYPE ^( EXPRESSION expression ) ) | VARIABLE_NAME COLON VARIABLE_TYPE EQUAL MATCH OPEN_PARENTHESYS stringOperation CLOSED_PARENTHESYS -> ^( GENERATED_VARIABLE_DEFINITION VARIABLE_NAME VARIABLE_TYPE ^( MATCH stringOperation ) ) | VARIABLE_NAME COLON VARIABLE_TYPE ( variableScope )? -> ^( INPUT_VARIABLE_DEFINITION VARIABLE_NAME VARIABLE_TYPE ( variableScope )? ) );
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
        Token MATCH18=null;
        Token OPEN_PARENTHESYS19=null;
        Token CLOSED_PARENTHESYS21=null;
        Token VARIABLE_NAME22=null;
        Token COLON23=null;
        Token VARIABLE_TYPE24=null;
        OPPLPatternScript_OPPLParser.opplFunction_return opplFunction8 = null;

        OPPLPatternScript_OPPLParser_MOWLParser.expression_return expression13 = null;

        OPPLPatternScript_OPPLParser.stringOperation_return stringOperation20 = null;

        OPPLPatternScript_OPPLParser.variableScope_return variableScope25 = null;


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
        OPPLSyntaxTree MATCH18_tree=null;
        OPPLSyntaxTree OPEN_PARENTHESYS19_tree=null;
        OPPLSyntaxTree CLOSED_PARENTHESYS21_tree=null;
        OPPLSyntaxTree VARIABLE_NAME22_tree=null;
        OPPLSyntaxTree COLON23_tree=null;
        OPPLSyntaxTree VARIABLE_TYPE24_tree=null;
        RewriteRuleTokenStream stream_COLON=new RewriteRuleTokenStream(adaptor,"token COLON");
        RewriteRuleTokenStream stream_MATCH=new RewriteRuleTokenStream(adaptor,"token MATCH");
        RewriteRuleTokenStream stream_VARIABLE_NAME=new RewriteRuleTokenStream(adaptor,"token VARIABLE_NAME");
        RewriteRuleTokenStream stream_VARIABLE_TYPE=new RewriteRuleTokenStream(adaptor,"token VARIABLE_TYPE");
        RewriteRuleTokenStream stream_CLOSED_PARENTHESYS=new RewriteRuleTokenStream(adaptor,"token CLOSED_PARENTHESYS");
        RewriteRuleTokenStream stream_EQUAL=new RewriteRuleTokenStream(adaptor,"token EQUAL");
        RewriteRuleTokenStream stream_OPEN_PARENTHESYS=new RewriteRuleTokenStream(adaptor,"token OPEN_PARENTHESYS");
        RewriteRuleSubtreeStream stream_expression=new RewriteRuleSubtreeStream(adaptor,"rule expression");
        RewriteRuleSubtreeStream stream_variableScope=new RewriteRuleSubtreeStream(adaptor,"rule variableScope");
        RewriteRuleSubtreeStream stream_opplFunction=new RewriteRuleSubtreeStream(adaptor,"rule opplFunction");
        RewriteRuleSubtreeStream stream_stringOperation=new RewriteRuleSubtreeStream(adaptor,"rule stringOperation");
        try {
            // OPPLParser.g:50:3: ( VARIABLE_NAME COLON VARIABLE_TYPE EQUAL opplFunction -> ^( GENERATED_VARIABLE_DEFINITION VARIABLE_NAME VARIABLE_TYPE ^( opplFunction ) ) | VARIABLE_NAME COLON VARIABLE_TYPE EQUAL expression -> ^( GENERATED_VARIABLE_DEFINITION VARIABLE_NAME VARIABLE_TYPE ^( EXPRESSION expression ) ) | VARIABLE_NAME COLON VARIABLE_TYPE EQUAL MATCH OPEN_PARENTHESYS stringOperation CLOSED_PARENTHESYS -> ^( GENERATED_VARIABLE_DEFINITION VARIABLE_NAME VARIABLE_TYPE ^( MATCH stringOperation ) ) | VARIABLE_NAME COLON VARIABLE_TYPE ( variableScope )? -> ^( INPUT_VARIABLE_DEFINITION VARIABLE_NAME VARIABLE_TYPE ( variableScope )? ) )
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
                            case CREATE:
                            case CREATE_INTERSECTION:
                            case CREATE_DISJUNCTION:
                                {
                                alt3=1;
                                }
                                break;
                            case OPEN_PARENTHESYS:
                            case OPEN_CURLY_BRACES:
                            case NOT:
                            case INVERSE:
                            case COMMA:
                            case DBLQUOTE:
                            case IDENTIFIER:
                            case ENTITY_REFERENCE:
                            case BEGIN:
                            case ESCLAMATION_MARK:
                            case DOLLAR:
                            case THIS_CLASS:
                            case VARIABLE_NAME:
                                {
                                alt3=2;
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
                    // OPPLParser.g:52:7: VARIABLE_NAME COLON VARIABLE_TYPE EQUAL opplFunction
                    {
                    VARIABLE_NAME4=(Token)match(input,VARIABLE_NAME,FOLLOW_VARIABLE_NAME_in_variableDefinition244); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_VARIABLE_NAME.add(VARIABLE_NAME4);

                    COLON5=(Token)match(input,COLON,FOLLOW_COLON_in_variableDefinition246); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_COLON.add(COLON5);

                    VARIABLE_TYPE6=(Token)match(input,VARIABLE_TYPE,FOLLOW_VARIABLE_TYPE_in_variableDefinition248); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_VARIABLE_TYPE.add(VARIABLE_TYPE6);

                    EQUAL7=(Token)match(input,EQUAL,FOLLOW_EQUAL_in_variableDefinition251); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_EQUAL.add(EQUAL7);

                    pushFollow(FOLLOW_opplFunction_in_variableDefinition253);
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
                    // 52:61: -> ^( GENERATED_VARIABLE_DEFINITION VARIABLE_NAME VARIABLE_TYPE ^( opplFunction ) )
                    {
                        // OPPLParser.g:52:64: ^( GENERATED_VARIABLE_DEFINITION VARIABLE_NAME VARIABLE_TYPE ^( opplFunction ) )
                        {
                        OPPLSyntaxTree root_1 = (OPPLSyntaxTree)adaptor.nil();
                        root_1 = (OPPLSyntaxTree)adaptor.becomeRoot((OPPLSyntaxTree)adaptor.create(GENERATED_VARIABLE_DEFINITION, "GENERATED_VARIABLE_DEFINITION"), root_1);

                        adaptor.addChild(root_1, stream_VARIABLE_NAME.nextNode());
                        adaptor.addChild(root_1, stream_VARIABLE_TYPE.nextNode());
                        // OPPLParser.g:52:124: ^( opplFunction )
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
                    // OPPLParser.g:53:7: VARIABLE_NAME COLON VARIABLE_TYPE EQUAL expression
                    {
                    VARIABLE_NAME9=(Token)match(input,VARIABLE_NAME,FOLLOW_VARIABLE_NAME_in_variableDefinition281); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_VARIABLE_NAME.add(VARIABLE_NAME9);

                    COLON10=(Token)match(input,COLON,FOLLOW_COLON_in_variableDefinition283); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_COLON.add(COLON10);

                    VARIABLE_TYPE11=(Token)match(input,VARIABLE_TYPE,FOLLOW_VARIABLE_TYPE_in_variableDefinition285); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_VARIABLE_TYPE.add(VARIABLE_TYPE11);

                    EQUAL12=(Token)match(input,EQUAL,FOLLOW_EQUAL_in_variableDefinition288); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_EQUAL.add(EQUAL12);

                    pushFollow(FOLLOW_expression_in_variableDefinition290);
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
                    // 53:59: -> ^( GENERATED_VARIABLE_DEFINITION VARIABLE_NAME VARIABLE_TYPE ^( EXPRESSION expression ) )
                    {
                        // OPPLParser.g:53:62: ^( GENERATED_VARIABLE_DEFINITION VARIABLE_NAME VARIABLE_TYPE ^( EXPRESSION expression ) )
                        {
                        OPPLSyntaxTree root_1 = (OPPLSyntaxTree)adaptor.nil();
                        root_1 = (OPPLSyntaxTree)adaptor.becomeRoot((OPPLSyntaxTree)adaptor.create(GENERATED_VARIABLE_DEFINITION, "GENERATED_VARIABLE_DEFINITION"), root_1);

                        adaptor.addChild(root_1, stream_VARIABLE_NAME.nextNode());
                        adaptor.addChild(root_1, stream_VARIABLE_TYPE.nextNode());
                        // OPPLParser.g:53:122: ^( EXPRESSION expression )
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
                    // OPPLParser.g:54:7: VARIABLE_NAME COLON VARIABLE_TYPE EQUAL MATCH OPEN_PARENTHESYS stringOperation CLOSED_PARENTHESYS
                    {
                    VARIABLE_NAME14=(Token)match(input,VARIABLE_NAME,FOLLOW_VARIABLE_NAME_in_variableDefinition314); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_VARIABLE_NAME.add(VARIABLE_NAME14);

                    COLON15=(Token)match(input,COLON,FOLLOW_COLON_in_variableDefinition316); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_COLON.add(COLON15);

                    VARIABLE_TYPE16=(Token)match(input,VARIABLE_TYPE,FOLLOW_VARIABLE_TYPE_in_variableDefinition318); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_VARIABLE_TYPE.add(VARIABLE_TYPE16);

                    EQUAL17=(Token)match(input,EQUAL,FOLLOW_EQUAL_in_variableDefinition321); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_EQUAL.add(EQUAL17);

                    MATCH18=(Token)match(input,MATCH,FOLLOW_MATCH_in_variableDefinition323); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_MATCH.add(MATCH18);

                    OPEN_PARENTHESYS19=(Token)match(input,OPEN_PARENTHESYS,FOLLOW_OPEN_PARENTHESYS_in_variableDefinition325); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_OPEN_PARENTHESYS.add(OPEN_PARENTHESYS19);

                    pushFollow(FOLLOW_stringOperation_in_variableDefinition327);
                    stringOperation20=stringOperation();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_stringOperation.add(stringOperation20.getTree());
                    CLOSED_PARENTHESYS21=(Token)match(input,CLOSED_PARENTHESYS,FOLLOW_CLOSED_PARENTHESYS_in_variableDefinition329); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_CLOSED_PARENTHESYS.add(CLOSED_PARENTHESYS21);



                    // AST REWRITE
                    // elements: VARIABLE_TYPE, VARIABLE_NAME, MATCH, stringOperation
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (OPPLSyntaxTree)adaptor.nil();
                    // 54:106: -> ^( GENERATED_VARIABLE_DEFINITION VARIABLE_NAME VARIABLE_TYPE ^( MATCH stringOperation ) )
                    {
                        // OPPLParser.g:54:109: ^( GENERATED_VARIABLE_DEFINITION VARIABLE_NAME VARIABLE_TYPE ^( MATCH stringOperation ) )
                        {
                        OPPLSyntaxTree root_1 = (OPPLSyntaxTree)adaptor.nil();
                        root_1 = (OPPLSyntaxTree)adaptor.becomeRoot((OPPLSyntaxTree)adaptor.create(GENERATED_VARIABLE_DEFINITION, "GENERATED_VARIABLE_DEFINITION"), root_1);

                        adaptor.addChild(root_1, stream_VARIABLE_NAME.nextNode());
                        adaptor.addChild(root_1, stream_VARIABLE_TYPE.nextNode());
                        // OPPLParser.g:54:169: ^( MATCH stringOperation )
                        {
                        OPPLSyntaxTree root_2 = (OPPLSyntaxTree)adaptor.nil();
                        root_2 = (OPPLSyntaxTree)adaptor.becomeRoot(stream_MATCH.nextNode(), root_2);

                        adaptor.addChild(root_2, stream_stringOperation.nextTree());

                        adaptor.addChild(root_1, root_2);
                        }

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 4 :
                    // OPPLParser.g:55:7: VARIABLE_NAME COLON VARIABLE_TYPE ( variableScope )?
                    {
                    VARIABLE_NAME22=(Token)match(input,VARIABLE_NAME,FOLLOW_VARIABLE_NAME_in_variableDefinition353); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_VARIABLE_NAME.add(VARIABLE_NAME22);

                    COLON23=(Token)match(input,COLON,FOLLOW_COLON_in_variableDefinition355); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_COLON.add(COLON23);

                    VARIABLE_TYPE24=(Token)match(input,VARIABLE_TYPE,FOLLOW_VARIABLE_TYPE_in_variableDefinition357); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_VARIABLE_TYPE.add(VARIABLE_TYPE24);

                    // OPPLParser.g:55:41: ( variableScope )?
                    int alt2=2;
                    int LA2_0 = input.LA(1);

                    if ( (LA2_0==OPEN_SQUARE_BRACKET) ) {
                        alt2=1;
                    }
                    switch (alt2) {
                        case 1 :
                            // OPPLParser.g:55:42: variableScope
                            {
                            pushFollow(FOLLOW_variableScope_in_variableDefinition360);
                            variableScope25=variableScope();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) stream_variableScope.add(variableScope25.getTree());

                            }
                            break;

                    }



                    // AST REWRITE
                    // elements: VARIABLE_TYPE, VARIABLE_NAME, variableScope
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (OPPLSyntaxTree)adaptor.nil();
                    // 55:58: -> ^( INPUT_VARIABLE_DEFINITION VARIABLE_NAME VARIABLE_TYPE ( variableScope )? )
                    {
                        // OPPLParser.g:55:61: ^( INPUT_VARIABLE_DEFINITION VARIABLE_NAME VARIABLE_TYPE ( variableScope )? )
                        {
                        OPPLSyntaxTree root_1 = (OPPLSyntaxTree)adaptor.nil();
                        root_1 = (OPPLSyntaxTree)adaptor.becomeRoot((OPPLSyntaxTree)adaptor.create(INPUT_VARIABLE_DEFINITION, "INPUT_VARIABLE_DEFINITION"), root_1);

                        adaptor.addChild(root_1, stream_VARIABLE_NAME.nextNode());
                        adaptor.addChild(root_1, stream_VARIABLE_TYPE.nextNode());
                        // OPPLParser.g:55:117: ( variableScope )?
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
    // OPPLParser.g:60:1: variableScope : OPEN_SQUARE_BRACKET (variableScopeSpecification= SUBCLASS_OF | variableScopeSpecification= SUBPROPERTY_OF | variableScopeSpecification= SUPER_CLASS_OF | variableScopeSpecification= SUPER_PROPERTY_OF | variableScopeSpecification= INSTANCE_OF | variableScopeSpecification= TYPES ) expression CLOSED_SQUARE_BRACKET -> ^( VARIABLE_SCOPE $variableScopeSpecification ^( EXPRESSION expression ) ) ;
    public final OPPLPatternScript_OPPLParser.variableScope_return variableScope() throws RecognitionException {
        OPPLPatternScript_OPPLParser.variableScope_return retval = new OPPLPatternScript_OPPLParser.variableScope_return();
        retval.start = input.LT(1);

        OPPLSyntaxTree root_0 = null;

        Token variableScopeSpecification=null;
        Token OPEN_SQUARE_BRACKET26=null;
        Token CLOSED_SQUARE_BRACKET28=null;
        OPPLPatternScript_OPPLParser_MOWLParser.expression_return expression27 = null;


        OPPLSyntaxTree variableScopeSpecification_tree=null;
        OPPLSyntaxTree OPEN_SQUARE_BRACKET26_tree=null;
        OPPLSyntaxTree CLOSED_SQUARE_BRACKET28_tree=null;
        RewriteRuleTokenStream stream_TYPES=new RewriteRuleTokenStream(adaptor,"token TYPES");
        RewriteRuleTokenStream stream_SUPER_PROPERTY_OF=new RewriteRuleTokenStream(adaptor,"token SUPER_PROPERTY_OF");
        RewriteRuleTokenStream stream_SUBCLASS_OF=new RewriteRuleTokenStream(adaptor,"token SUBCLASS_OF");
        RewriteRuleTokenStream stream_OPEN_SQUARE_BRACKET=new RewriteRuleTokenStream(adaptor,"token OPEN_SQUARE_BRACKET");
        RewriteRuleTokenStream stream_SUPER_CLASS_OF=new RewriteRuleTokenStream(adaptor,"token SUPER_CLASS_OF");
        RewriteRuleTokenStream stream_INSTANCE_OF=new RewriteRuleTokenStream(adaptor,"token INSTANCE_OF");
        RewriteRuleTokenStream stream_SUBPROPERTY_OF=new RewriteRuleTokenStream(adaptor,"token SUBPROPERTY_OF");
        RewriteRuleTokenStream stream_CLOSED_SQUARE_BRACKET=new RewriteRuleTokenStream(adaptor,"token CLOSED_SQUARE_BRACKET");
        RewriteRuleSubtreeStream stream_expression=new RewriteRuleSubtreeStream(adaptor,"rule expression");
        try {
            // OPPLParser.g:61:3: ( OPEN_SQUARE_BRACKET (variableScopeSpecification= SUBCLASS_OF | variableScopeSpecification= SUBPROPERTY_OF | variableScopeSpecification= SUPER_CLASS_OF | variableScopeSpecification= SUPER_PROPERTY_OF | variableScopeSpecification= INSTANCE_OF | variableScopeSpecification= TYPES ) expression CLOSED_SQUARE_BRACKET -> ^( VARIABLE_SCOPE $variableScopeSpecification ^( EXPRESSION expression ) ) )
            // OPPLParser.g:62:5: OPEN_SQUARE_BRACKET (variableScopeSpecification= SUBCLASS_OF | variableScopeSpecification= SUBPROPERTY_OF | variableScopeSpecification= SUPER_CLASS_OF | variableScopeSpecification= SUPER_PROPERTY_OF | variableScopeSpecification= INSTANCE_OF | variableScopeSpecification= TYPES ) expression CLOSED_SQUARE_BRACKET
            {
            OPEN_SQUARE_BRACKET26=(Token)match(input,OPEN_SQUARE_BRACKET,FOLLOW_OPEN_SQUARE_BRACKET_in_variableScope400); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_OPEN_SQUARE_BRACKET.add(OPEN_SQUARE_BRACKET26);

            // OPPLParser.g:62:25: (variableScopeSpecification= SUBCLASS_OF | variableScopeSpecification= SUBPROPERTY_OF | variableScopeSpecification= SUPER_CLASS_OF | variableScopeSpecification= SUPER_PROPERTY_OF | variableScopeSpecification= INSTANCE_OF | variableScopeSpecification= TYPES )
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
                    // OPPLParser.g:62:26: variableScopeSpecification= SUBCLASS_OF
                    {
                    variableScopeSpecification=(Token)match(input,SUBCLASS_OF,FOLLOW_SUBCLASS_OF_in_variableScope407); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_SUBCLASS_OF.add(variableScopeSpecification);


                    }
                    break;
                case 2 :
                    // OPPLParser.g:62:69: variableScopeSpecification= SUBPROPERTY_OF
                    {
                    variableScopeSpecification=(Token)match(input,SUBPROPERTY_OF,FOLLOW_SUBPROPERTY_OF_in_variableScope415); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_SUBPROPERTY_OF.add(variableScopeSpecification);


                    }
                    break;
                case 3 :
                    // OPPLParser.g:62:115: variableScopeSpecification= SUPER_CLASS_OF
                    {
                    variableScopeSpecification=(Token)match(input,SUPER_CLASS_OF,FOLLOW_SUPER_CLASS_OF_in_variableScope423); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_SUPER_CLASS_OF.add(variableScopeSpecification);


                    }
                    break;
                case 4 :
                    // OPPLParser.g:62:162: variableScopeSpecification= SUPER_PROPERTY_OF
                    {
                    variableScopeSpecification=(Token)match(input,SUPER_PROPERTY_OF,FOLLOW_SUPER_PROPERTY_OF_in_variableScope431); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_SUPER_PROPERTY_OF.add(variableScopeSpecification);


                    }
                    break;
                case 5 :
                    // OPPLParser.g:62:211: variableScopeSpecification= INSTANCE_OF
                    {
                    variableScopeSpecification=(Token)match(input,INSTANCE_OF,FOLLOW_INSTANCE_OF_in_variableScope440); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_INSTANCE_OF.add(variableScopeSpecification);


                    }
                    break;
                case 6 :
                    // OPPLParser.g:62:254: variableScopeSpecification= TYPES
                    {
                    variableScopeSpecification=(Token)match(input,TYPES,FOLLOW_TYPES_in_variableScope448); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_TYPES.add(variableScopeSpecification);


                    }
                    break;

            }

            pushFollow(FOLLOW_expression_in_variableScope451);
            expression27=gOPPLPatternScript.expression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_expression.add(expression27.getTree());
            CLOSED_SQUARE_BRACKET28=(Token)match(input,CLOSED_SQUARE_BRACKET,FOLLOW_CLOSED_SQUARE_BRACKET_in_variableScope453); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_CLOSED_SQUARE_BRACKET.add(CLOSED_SQUARE_BRACKET28);



            // AST REWRITE
            // elements: variableScopeSpecification, expression
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
            // 62:323: -> ^( VARIABLE_SCOPE $variableScopeSpecification ^( EXPRESSION expression ) )
            {
                // OPPLParser.g:62:326: ^( VARIABLE_SCOPE $variableScopeSpecification ^( EXPRESSION expression ) )
                {
                OPPLSyntaxTree root_1 = (OPPLSyntaxTree)adaptor.nil();
                root_1 = (OPPLSyntaxTree)adaptor.becomeRoot((OPPLSyntaxTree)adaptor.create(VARIABLE_SCOPE, "VARIABLE_SCOPE"), root_1);

                adaptor.addChild(root_1, stream_variableScopeSpecification.nextNode());
                // OPPLParser.g:62:371: ^( EXPRESSION expression )
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
             finally {
        }
        return retval;
    }
    // $ANTLR end "variableScope"

    public static class query_return extends ParserRuleReturnScope {
        OPPLSyntaxTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "query"
    // OPPLParser.g:67:2: query : SELECT selectClause ( COMMA selectClause )* ( WHERE constraint ( COMMA constraint )* )? -> ^( QUERY ( selectClause )+ ( constraint )* ) ;
    public final OPPLPatternScript_OPPLParser.query_return query() throws RecognitionException {
        OPPLPatternScript_OPPLParser.query_return retval = new OPPLPatternScript_OPPLParser.query_return();
        retval.start = input.LT(1);

        OPPLSyntaxTree root_0 = null;

        Token SELECT29=null;
        Token COMMA31=null;
        Token WHERE33=null;
        Token COMMA35=null;
        OPPLPatternScript_OPPLParser.selectClause_return selectClause30 = null;

        OPPLPatternScript_OPPLParser.selectClause_return selectClause32 = null;

        OPPLPatternScript_OPPLParser.constraint_return constraint34 = null;

        OPPLPatternScript_OPPLParser.constraint_return constraint36 = null;


        OPPLSyntaxTree SELECT29_tree=null;
        OPPLSyntaxTree COMMA31_tree=null;
        OPPLSyntaxTree WHERE33_tree=null;
        OPPLSyntaxTree COMMA35_tree=null;
        RewriteRuleTokenStream stream_WHERE=new RewriteRuleTokenStream(adaptor,"token WHERE");
        RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
        RewriteRuleTokenStream stream_SELECT=new RewriteRuleTokenStream(adaptor,"token SELECT");
        RewriteRuleSubtreeStream stream_constraint=new RewriteRuleSubtreeStream(adaptor,"rule constraint");
        RewriteRuleSubtreeStream stream_selectClause=new RewriteRuleSubtreeStream(adaptor,"rule selectClause");
        try {
            // OPPLParser.g:68:3: ( SELECT selectClause ( COMMA selectClause )* ( WHERE constraint ( COMMA constraint )* )? -> ^( QUERY ( selectClause )+ ( constraint )* ) )
            // OPPLParser.g:69:5: SELECT selectClause ( COMMA selectClause )* ( WHERE constraint ( COMMA constraint )* )?
            {
            SELECT29=(Token)match(input,SELECT,FOLLOW_SELECT_in_query489); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_SELECT.add(SELECT29);

            pushFollow(FOLLOW_selectClause_in_query491);
            selectClause30=selectClause();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_selectClause.add(selectClause30.getTree());
            // OPPLParser.g:69:25: ( COMMA selectClause )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==COMMA) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // OPPLParser.g:69:26: COMMA selectClause
            	    {
            	    COMMA31=(Token)match(input,COMMA,FOLLOW_COMMA_in_query494); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_COMMA.add(COMMA31);

            	    pushFollow(FOLLOW_selectClause_in_query496);
            	    selectClause32=selectClause();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_selectClause.add(selectClause32.getTree());

            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);

            // OPPLParser.g:69:47: ( WHERE constraint ( COMMA constraint )* )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==WHERE) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // OPPLParser.g:69:48: WHERE constraint ( COMMA constraint )*
                    {
                    WHERE33=(Token)match(input,WHERE,FOLLOW_WHERE_in_query501); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_WHERE.add(WHERE33);

                    pushFollow(FOLLOW_constraint_in_query503);
                    constraint34=constraint();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_constraint.add(constraint34.getTree());
                    // OPPLParser.g:69:65: ( COMMA constraint )*
                    loop6:
                    do {
                        int alt6=2;
                        int LA6_0 = input.LA(1);

                        if ( (LA6_0==COMMA) ) {
                            alt6=1;
                        }


                        switch (alt6) {
                    	case 1 :
                    	    // OPPLParser.g:69:66: COMMA constraint
                    	    {
                    	    COMMA35=(Token)match(input,COMMA,FOLLOW_COMMA_in_query506); if (state.failed) return retval; 
                    	    if ( state.backtracking==0 ) stream_COMMA.add(COMMA35);

                    	    pushFollow(FOLLOW_constraint_in_query508);
                    	    constraint36=constraint();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) stream_constraint.add(constraint36.getTree());

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
            // 69:87: -> ^( QUERY ( selectClause )+ ( constraint )* )
            {
                // OPPLParser.g:69:90: ^( QUERY ( selectClause )+ ( constraint )* )
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
                // OPPLParser.g:69:112: ( constraint )*
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
    // OPPLParser.g:72:2: selectClause : ( ASSERTED axiom -> ^( ASSERTED_CLAUSE axiom ) | axiom -> ^( PLAIN_CLAUSE axiom ) );
    public final OPPLPatternScript_OPPLParser.selectClause_return selectClause() throws RecognitionException {
        OPPLPatternScript_OPPLParser.selectClause_return retval = new OPPLPatternScript_OPPLParser.selectClause_return();
        retval.start = input.LT(1);

        OPPLSyntaxTree root_0 = null;

        Token ASSERTED37=null;
        OPPLPatternScript_OPPLParser_MOWLParser.axiom_return axiom38 = null;

        OPPLPatternScript_OPPLParser_MOWLParser.axiom_return axiom39 = null;


        OPPLSyntaxTree ASSERTED37_tree=null;
        RewriteRuleTokenStream stream_ASSERTED=new RewriteRuleTokenStream(adaptor,"token ASSERTED");
        RewriteRuleSubtreeStream stream_axiom=new RewriteRuleSubtreeStream(adaptor,"rule axiom");
        try {
            // OPPLParser.g:73:3: ( ASSERTED axiom -> ^( ASSERTED_CLAUSE axiom ) | axiom -> ^( PLAIN_CLAUSE axiom ) )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==ASSERTED) ) {
                alt8=1;
            }
            else if ( (LA8_0==EOF||(LA8_0>=OPEN_PARENTHESYS && LA8_0<=OPEN_CURLY_BRACES)||LA8_0==CLOSED_PARENTHESYS||(LA8_0>=AND && LA8_0<=NOT)||(LA8_0>=INVERSE && LA8_0<=EQUIVALENT_TO)||LA8_0==DISJOINT_WITH||(LA8_0>=FUNCTIONAL && LA8_0<=INVERSE_FUNCTIONAL)||LA8_0==COMMA||LA8_0==DBLQUOTE||(LA8_0>=IDENTIFIER && LA8_0<=ENTITY_REFERENCE)||LA8_0==CLOSED_SQUARE_BRACKET||LA8_0==ESCLAMATION_MARK||LA8_0==DOLLAR||LA8_0==THIS_CLASS||LA8_0==VARIABLE_NAME) ) {
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
                    // OPPLParser.g:74:7: ASSERTED axiom
                    {
                    ASSERTED37=(Token)match(input,ASSERTED,FOLLOW_ASSERTED_in_selectClause545); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_ASSERTED.add(ASSERTED37);

                    pushFollow(FOLLOW_axiom_in_selectClause547);
                    axiom38=gOPPLPatternScript.axiom();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_axiom.add(axiom38.getTree());


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
                    // 74:22: -> ^( ASSERTED_CLAUSE axiom )
                    {
                        // OPPLParser.g:74:25: ^( ASSERTED_CLAUSE axiom )
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
                    // OPPLParser.g:75:7: axiom
                    {
                    pushFollow(FOLLOW_axiom_in_selectClause563);
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
                    // 75:13: -> ^( PLAIN_CLAUSE axiom )
                    {
                        // OPPLParser.g:75:16: ^( PLAIN_CLAUSE axiom )
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
    // OPPLParser.g:80:2: constraint : (first= VARIABLE_NAME NOT_EQUAL second= expression -> ^( INEQUALITY_CONSTRAINT IDENTIFIER[$first] ^( EXPRESSION $second) ) | VARIABLE_NAME IN oneOf -> ^( IN_SET_CONSTRAINT IDENTIFIER[$VARIABLE_NAME] oneOf ) | VARIABLE_NAME MATCH OPEN_PARENTHESYS stringOperation CLOSED_PARENTHESYS -> ^( REGEXP_CONSTRAINT IDENTIFIER[$VARIABLE_NAME] stringOperation ) );
    public final OPPLPatternScript_OPPLParser.constraint_return constraint() throws RecognitionException {
        OPPLPatternScript_OPPLParser.constraint_return retval = new OPPLPatternScript_OPPLParser.constraint_return();
        retval.start = input.LT(1);

        OPPLSyntaxTree root_0 = null;

        Token first=null;
        Token NOT_EQUAL40=null;
        Token VARIABLE_NAME41=null;
        Token IN42=null;
        Token VARIABLE_NAME44=null;
        Token MATCH45=null;
        Token OPEN_PARENTHESYS46=null;
        Token CLOSED_PARENTHESYS48=null;
        OPPLPatternScript_OPPLParser_MOWLParser.expression_return second = null;

        OPPLPatternScript_OPPLParser_MOWLParser.oneOf_return oneOf43 = null;

        OPPLPatternScript_OPPLParser.stringOperation_return stringOperation47 = null;


        OPPLSyntaxTree first_tree=null;
        OPPLSyntaxTree NOT_EQUAL40_tree=null;
        OPPLSyntaxTree VARIABLE_NAME41_tree=null;
        OPPLSyntaxTree IN42_tree=null;
        OPPLSyntaxTree VARIABLE_NAME44_tree=null;
        OPPLSyntaxTree MATCH45_tree=null;
        OPPLSyntaxTree OPEN_PARENTHESYS46_tree=null;
        OPPLSyntaxTree CLOSED_PARENTHESYS48_tree=null;
        RewriteRuleTokenStream stream_MATCH=new RewriteRuleTokenStream(adaptor,"token MATCH");
        RewriteRuleTokenStream stream_VARIABLE_NAME=new RewriteRuleTokenStream(adaptor,"token VARIABLE_NAME");
        RewriteRuleTokenStream stream_IN=new RewriteRuleTokenStream(adaptor,"token IN");
        RewriteRuleTokenStream stream_CLOSED_PARENTHESYS=new RewriteRuleTokenStream(adaptor,"token CLOSED_PARENTHESYS");
        RewriteRuleTokenStream stream_NOT_EQUAL=new RewriteRuleTokenStream(adaptor,"token NOT_EQUAL");
        RewriteRuleTokenStream stream_OPEN_PARENTHESYS=new RewriteRuleTokenStream(adaptor,"token OPEN_PARENTHESYS");
        RewriteRuleSubtreeStream stream_expression=new RewriteRuleSubtreeStream(adaptor,"rule expression");
        RewriteRuleSubtreeStream stream_oneOf=new RewriteRuleSubtreeStream(adaptor,"rule oneOf");
        RewriteRuleSubtreeStream stream_stringOperation=new RewriteRuleSubtreeStream(adaptor,"rule stringOperation");
        try {
            // OPPLParser.g:81:3: (first= VARIABLE_NAME NOT_EQUAL second= expression -> ^( INEQUALITY_CONSTRAINT IDENTIFIER[$first] ^( EXPRESSION $second) ) | VARIABLE_NAME IN oneOf -> ^( IN_SET_CONSTRAINT IDENTIFIER[$VARIABLE_NAME] oneOf ) | VARIABLE_NAME MATCH OPEN_PARENTHESYS stringOperation CLOSED_PARENTHESYS -> ^( REGEXP_CONSTRAINT IDENTIFIER[$VARIABLE_NAME] stringOperation ) )
            int alt9=3;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==VARIABLE_NAME) ) {
                switch ( input.LA(2) ) {
                case NOT_EQUAL:
                    {
                    alt9=1;
                    }
                    break;
                case IN:
                    {
                    alt9=2;
                    }
                    break;
                case MATCH:
                    {
                    alt9=3;
                    }
                    break;
                default:
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 9, 1, input);

                    throw nvae;
                }

            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }
            switch (alt9) {
                case 1 :
                    // OPPLParser.g:82:8: first= VARIABLE_NAME NOT_EQUAL second= expression
                    {
                    first=(Token)match(input,VARIABLE_NAME,FOLLOW_VARIABLE_NAME_in_constraint602); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_VARIABLE_NAME.add(first);

                    NOT_EQUAL40=(Token)match(input,NOT_EQUAL,FOLLOW_NOT_EQUAL_in_constraint604); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_NOT_EQUAL.add(NOT_EQUAL40);

                    pushFollow(FOLLOW_expression_in_constraint610);
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
                    // 82:60: -> ^( INEQUALITY_CONSTRAINT IDENTIFIER[$first] ^( EXPRESSION $second) )
                    {
                        // OPPLParser.g:82:63: ^( INEQUALITY_CONSTRAINT IDENTIFIER[$first] ^( EXPRESSION $second) )
                        {
                        OPPLSyntaxTree root_1 = (OPPLSyntaxTree)adaptor.nil();
                        root_1 = (OPPLSyntaxTree)adaptor.becomeRoot((OPPLSyntaxTree)adaptor.create(INEQUALITY_CONSTRAINT, "INEQUALITY_CONSTRAINT"), root_1);

                        adaptor.addChild(root_1, (OPPLSyntaxTree)adaptor.create(IDENTIFIER, first));
                        // OPPLParser.g:82:106: ^( EXPRESSION $second)
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
                    // OPPLParser.g:83:8: VARIABLE_NAME IN oneOf
                    {
                    VARIABLE_NAME41=(Token)match(input,VARIABLE_NAME,FOLLOW_VARIABLE_NAME_in_constraint635); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_VARIABLE_NAME.add(VARIABLE_NAME41);

                    IN42=(Token)match(input,IN,FOLLOW_IN_in_constraint637); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_IN.add(IN42);

                    pushFollow(FOLLOW_oneOf_in_constraint639);
                    oneOf43=gOPPLPatternScript.oneOf();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_oneOf.add(oneOf43.getTree());


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
                    // 83:31: -> ^( IN_SET_CONSTRAINT IDENTIFIER[$VARIABLE_NAME] oneOf )
                    {
                        // OPPLParser.g:83:34: ^( IN_SET_CONSTRAINT IDENTIFIER[$VARIABLE_NAME] oneOf )
                        {
                        OPPLSyntaxTree root_1 = (OPPLSyntaxTree)adaptor.nil();
                        root_1 = (OPPLSyntaxTree)adaptor.becomeRoot((OPPLSyntaxTree)adaptor.create(IN_SET_CONSTRAINT, "IN_SET_CONSTRAINT"), root_1);

                        adaptor.addChild(root_1, (OPPLSyntaxTree)adaptor.create(IDENTIFIER, VARIABLE_NAME41));
                        adaptor.addChild(root_1, stream_oneOf.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 3 :
                    // OPPLParser.g:84:8: VARIABLE_NAME MATCH OPEN_PARENTHESYS stringOperation CLOSED_PARENTHESYS
                    {
                    VARIABLE_NAME44=(Token)match(input,VARIABLE_NAME,FOLLOW_VARIABLE_NAME_in_constraint659); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_VARIABLE_NAME.add(VARIABLE_NAME44);

                    MATCH45=(Token)match(input,MATCH,FOLLOW_MATCH_in_constraint661); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_MATCH.add(MATCH45);

                    OPEN_PARENTHESYS46=(Token)match(input,OPEN_PARENTHESYS,FOLLOW_OPEN_PARENTHESYS_in_constraint663); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_OPEN_PARENTHESYS.add(OPEN_PARENTHESYS46);

                    pushFollow(FOLLOW_stringOperation_in_constraint665);
                    stringOperation47=stringOperation();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_stringOperation.add(stringOperation47.getTree());
                    CLOSED_PARENTHESYS48=(Token)match(input,CLOSED_PARENTHESYS,FOLLOW_CLOSED_PARENTHESYS_in_constraint667); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_CLOSED_PARENTHESYS.add(CLOSED_PARENTHESYS48);



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
                    // 84:80: -> ^( REGEXP_CONSTRAINT IDENTIFIER[$VARIABLE_NAME] stringOperation )
                    {
                        // OPPLParser.g:84:83: ^( REGEXP_CONSTRAINT IDENTIFIER[$VARIABLE_NAME] stringOperation )
                        {
                        OPPLSyntaxTree root_1 = (OPPLSyntaxTree)adaptor.nil();
                        root_1 = (OPPLSyntaxTree)adaptor.becomeRoot((OPPLSyntaxTree)adaptor.create(REGEXP_CONSTRAINT, "REGEXP_CONSTRAINT"), root_1);

                        adaptor.addChild(root_1, (OPPLSyntaxTree)adaptor.create(IDENTIFIER, VARIABLE_NAME44));
                        adaptor.addChild(root_1, stream_stringOperation.nextTree());

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
    // OPPLParser.g:87:2: actions : BEGIN action ( COMMA action )* END -> ^( ACTIONS ( action )+ ) ;
    public final OPPLPatternScript_OPPLParser.actions_return actions() throws RecognitionException {
        OPPLPatternScript_OPPLParser.actions_return retval = new OPPLPatternScript_OPPLParser.actions_return();
        retval.start = input.LT(1);

        OPPLSyntaxTree root_0 = null;

        Token BEGIN49=null;
        Token COMMA51=null;
        Token END53=null;
        OPPLPatternScript_OPPLParser.action_return action50 = null;

        OPPLPatternScript_OPPLParser.action_return action52 = null;


        OPPLSyntaxTree BEGIN49_tree=null;
        OPPLSyntaxTree COMMA51_tree=null;
        OPPLSyntaxTree END53_tree=null;
        RewriteRuleTokenStream stream_END=new RewriteRuleTokenStream(adaptor,"token END");
        RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
        RewriteRuleTokenStream stream_BEGIN=new RewriteRuleTokenStream(adaptor,"token BEGIN");
        RewriteRuleSubtreeStream stream_action=new RewriteRuleSubtreeStream(adaptor,"rule action");
        try {
            // OPPLParser.g:88:3: ( BEGIN action ( COMMA action )* END -> ^( ACTIONS ( action )+ ) )
            // OPPLParser.g:89:5: BEGIN action ( COMMA action )* END
            {
            BEGIN49=(Token)match(input,BEGIN,FOLLOW_BEGIN_in_actions698); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_BEGIN.add(BEGIN49);

            pushFollow(FOLLOW_action_in_actions700);
            action50=action();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_action.add(action50.getTree());
            // OPPLParser.g:89:18: ( COMMA action )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==COMMA) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // OPPLParser.g:89:19: COMMA action
            	    {
            	    COMMA51=(Token)match(input,COMMA,FOLLOW_COMMA_in_actions703); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_COMMA.add(COMMA51);

            	    pushFollow(FOLLOW_action_in_actions705);
            	    action52=action();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_action.add(action52.getTree());

            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);

            END53=(Token)match(input,END,FOLLOW_END_in_actions709); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_END.add(END53);



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
            // 89:38: -> ^( ACTIONS ( action )+ )
            {
                // OPPLParser.g:89:41: ^( ACTIONS ( action )+ )
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
    // OPPLParser.g:92:2: action : ( ADD axiom -> ^( ADD axiom ) | REMOVE axiom -> ^( REMOVE axiom ) );
    public final OPPLPatternScript_OPPLParser.action_return action() throws RecognitionException {
        OPPLPatternScript_OPPLParser.action_return retval = new OPPLPatternScript_OPPLParser.action_return();
        retval.start = input.LT(1);

        OPPLSyntaxTree root_0 = null;

        Token ADD54=null;
        Token REMOVE56=null;
        OPPLPatternScript_OPPLParser_MOWLParser.axiom_return axiom55 = null;

        OPPLPatternScript_OPPLParser_MOWLParser.axiom_return axiom57 = null;


        OPPLSyntaxTree ADD54_tree=null;
        OPPLSyntaxTree REMOVE56_tree=null;
        RewriteRuleTokenStream stream_REMOVE=new RewriteRuleTokenStream(adaptor,"token REMOVE");
        RewriteRuleTokenStream stream_ADD=new RewriteRuleTokenStream(adaptor,"token ADD");
        RewriteRuleSubtreeStream stream_axiom=new RewriteRuleSubtreeStream(adaptor,"rule axiom");
        try {
            // OPPLParser.g:93:3: ( ADD axiom -> ^( ADD axiom ) | REMOVE axiom -> ^( REMOVE axiom ) )
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==ADD) ) {
                alt11=1;
            }
            else if ( (LA11_0==REMOVE) ) {
                alt11=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }
            switch (alt11) {
                case 1 :
                    // OPPLParser.g:94:7: ADD axiom
                    {
                    ADD54=(Token)match(input,ADD,FOLLOW_ADD_in_action741); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_ADD.add(ADD54);

                    pushFollow(FOLLOW_axiom_in_action743);
                    axiom55=gOPPLPatternScript.axiom();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_axiom.add(axiom55.getTree());


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
                    // 94:17: -> ^( ADD axiom )
                    {
                        // OPPLParser.g:94:20: ^( ADD axiom )
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
                    // OPPLParser.g:95:7: REMOVE axiom
                    {
                    REMOVE56=(Token)match(input,REMOVE,FOLLOW_REMOVE_in_action759); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_REMOVE.add(REMOVE56);

                    pushFollow(FOLLOW_axiom_in_action761);
                    axiom57=gOPPLPatternScript.axiom();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_axiom.add(axiom57.getTree());


                    // AST REWRITE
                    // elements: REMOVE, axiom
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (OPPLSyntaxTree)adaptor.nil();
                    // 95:20: -> ^( REMOVE axiom )
                    {
                        // OPPLParser.g:95:23: ^( REMOVE axiom )
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
    // OPPLParser.g:101:1: opplFunction : ( CREATE OPEN_PARENTHESYS stringOperation CLOSED_PARENTHESYS -> ^( CREATE_OPPL_FUNCTION stringOperation ) | CREATE_INTERSECTION OPEN_PARENTHESYS atomic CLOSED_PARENTHESYS -> ^( CREATE_INTERSECTION atomic ) | CREATE_DISJUNCTION OPEN_PARENTHESYS atomic CLOSED_PARENTHESYS -> ^( CREATE_INTERSECTION atomic ) );
    public final OPPLPatternScript_OPPLParser.opplFunction_return opplFunction() throws RecognitionException {
        OPPLPatternScript_OPPLParser.opplFunction_return retval = new OPPLPatternScript_OPPLParser.opplFunction_return();
        retval.start = input.LT(1);

        OPPLSyntaxTree root_0 = null;

        Token CREATE58=null;
        Token OPEN_PARENTHESYS59=null;
        Token CLOSED_PARENTHESYS61=null;
        Token CREATE_INTERSECTION62=null;
        Token OPEN_PARENTHESYS63=null;
        Token CLOSED_PARENTHESYS65=null;
        Token CREATE_DISJUNCTION66=null;
        Token OPEN_PARENTHESYS67=null;
        Token CLOSED_PARENTHESYS69=null;
        OPPLPatternScript_OPPLParser.stringOperation_return stringOperation60 = null;

        OPPLPatternScriptParser.atomic_return atomic64 = null;

        OPPLPatternScriptParser.atomic_return atomic68 = null;


        OPPLSyntaxTree CREATE58_tree=null;
        OPPLSyntaxTree OPEN_PARENTHESYS59_tree=null;
        OPPLSyntaxTree CLOSED_PARENTHESYS61_tree=null;
        OPPLSyntaxTree CREATE_INTERSECTION62_tree=null;
        OPPLSyntaxTree OPEN_PARENTHESYS63_tree=null;
        OPPLSyntaxTree CLOSED_PARENTHESYS65_tree=null;
        OPPLSyntaxTree CREATE_DISJUNCTION66_tree=null;
        OPPLSyntaxTree OPEN_PARENTHESYS67_tree=null;
        OPPLSyntaxTree CLOSED_PARENTHESYS69_tree=null;
        RewriteRuleTokenStream stream_CREATE=new RewriteRuleTokenStream(adaptor,"token CREATE");
        RewriteRuleTokenStream stream_CREATE_DISJUNCTION=new RewriteRuleTokenStream(adaptor,"token CREATE_DISJUNCTION");
        RewriteRuleTokenStream stream_CREATE_INTERSECTION=new RewriteRuleTokenStream(adaptor,"token CREATE_INTERSECTION");
        RewriteRuleTokenStream stream_CLOSED_PARENTHESYS=new RewriteRuleTokenStream(adaptor,"token CLOSED_PARENTHESYS");
        RewriteRuleTokenStream stream_OPEN_PARENTHESYS=new RewriteRuleTokenStream(adaptor,"token OPEN_PARENTHESYS");
        RewriteRuleSubtreeStream stream_stringOperation=new RewriteRuleSubtreeStream(adaptor,"rule stringOperation");
        RewriteRuleSubtreeStream stream_atomic=new RewriteRuleSubtreeStream(adaptor,"rule atomic");
        try {
            // OPPLParser.g:102:3: ( CREATE OPEN_PARENTHESYS stringOperation CLOSED_PARENTHESYS -> ^( CREATE_OPPL_FUNCTION stringOperation ) | CREATE_INTERSECTION OPEN_PARENTHESYS atomic CLOSED_PARENTHESYS -> ^( CREATE_INTERSECTION atomic ) | CREATE_DISJUNCTION OPEN_PARENTHESYS atomic CLOSED_PARENTHESYS -> ^( CREATE_INTERSECTION atomic ) )
            int alt12=3;
            switch ( input.LA(1) ) {
            case CREATE:
                {
                alt12=1;
                }
                break;
            case CREATE_INTERSECTION:
                {
                alt12=2;
                }
                break;
            case CREATE_DISJUNCTION:
                {
                alt12=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;
            }

            switch (alt12) {
                case 1 :
                    // OPPLParser.g:103:7: CREATE OPEN_PARENTHESYS stringOperation CLOSED_PARENTHESYS
                    {
                    CREATE58=(Token)match(input,CREATE,FOLLOW_CREATE_in_opplFunction794); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_CREATE.add(CREATE58);

                    OPEN_PARENTHESYS59=(Token)match(input,OPEN_PARENTHESYS,FOLLOW_OPEN_PARENTHESYS_in_opplFunction796); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_OPEN_PARENTHESYS.add(OPEN_PARENTHESYS59);

                    pushFollow(FOLLOW_stringOperation_in_opplFunction798);
                    stringOperation60=stringOperation();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_stringOperation.add(stringOperation60.getTree());
                    CLOSED_PARENTHESYS61=(Token)match(input,CLOSED_PARENTHESYS,FOLLOW_CLOSED_PARENTHESYS_in_opplFunction800); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_CLOSED_PARENTHESYS.add(CLOSED_PARENTHESYS61);



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
                    // 103:66: -> ^( CREATE_OPPL_FUNCTION stringOperation )
                    {
                        // OPPLParser.g:103:69: ^( CREATE_OPPL_FUNCTION stringOperation )
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
                    // OPPLParser.g:104:7: CREATE_INTERSECTION OPEN_PARENTHESYS atomic CLOSED_PARENTHESYS
                    {
                    CREATE_INTERSECTION62=(Token)match(input,CREATE_INTERSECTION,FOLLOW_CREATE_INTERSECTION_in_opplFunction816); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_CREATE_INTERSECTION.add(CREATE_INTERSECTION62);

                    OPEN_PARENTHESYS63=(Token)match(input,OPEN_PARENTHESYS,FOLLOW_OPEN_PARENTHESYS_in_opplFunction819); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_OPEN_PARENTHESYS.add(OPEN_PARENTHESYS63);

                    pushFollow(FOLLOW_atomic_in_opplFunction821);
                    atomic64=gOPPLPatternScript.atomic();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_atomic.add(atomic64.getTree());
                    CLOSED_PARENTHESYS65=(Token)match(input,CLOSED_PARENTHESYS,FOLLOW_CLOSED_PARENTHESYS_in_opplFunction824); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_CLOSED_PARENTHESYS.add(CLOSED_PARENTHESYS65);



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
                    // 104:72: -> ^( CREATE_INTERSECTION atomic )
                    {
                        // OPPLParser.g:104:75: ^( CREATE_INTERSECTION atomic )
                        {
                        OPPLSyntaxTree root_1 = (OPPLSyntaxTree)adaptor.nil();
                        root_1 = (OPPLSyntaxTree)adaptor.becomeRoot(stream_CREATE_INTERSECTION.nextNode(), root_1);

                        adaptor.addChild(root_1, stream_atomic.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 3 :
                    // OPPLParser.g:105:7: CREATE_DISJUNCTION OPEN_PARENTHESYS atomic CLOSED_PARENTHESYS
                    {
                    CREATE_DISJUNCTION66=(Token)match(input,CREATE_DISJUNCTION,FOLLOW_CREATE_DISJUNCTION_in_opplFunction840); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_CREATE_DISJUNCTION.add(CREATE_DISJUNCTION66);

                    OPEN_PARENTHESYS67=(Token)match(input,OPEN_PARENTHESYS,FOLLOW_OPEN_PARENTHESYS_in_opplFunction842); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_OPEN_PARENTHESYS.add(OPEN_PARENTHESYS67);

                    pushFollow(FOLLOW_atomic_in_opplFunction844);
                    atomic68=gOPPLPatternScript.atomic();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_atomic.add(atomic68.getTree());
                    CLOSED_PARENTHESYS69=(Token)match(input,CLOSED_PARENTHESYS,FOLLOW_CLOSED_PARENTHESYS_in_opplFunction846); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_CLOSED_PARENTHESYS.add(CLOSED_PARENTHESYS69);



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
                    // 105:69: -> ^( CREATE_INTERSECTION atomic )
                    {
                        // OPPLParser.g:105:72: ^( CREATE_INTERSECTION atomic )
                        {
                        OPPLSyntaxTree root_1 = (OPPLSyntaxTree)adaptor.nil();
                        root_1 = (OPPLSyntaxTree)adaptor.becomeRoot((OPPLSyntaxTree)adaptor.create(CREATE_INTERSECTION, "CREATE_INTERSECTION"), root_1);

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
    // OPPLParser.g:108:1: stringOperation : stringExpression ( PLUS stringExpression )* -> ^( STRING_OPERATION ( stringExpression )+ ) ;
    public final OPPLPatternScript_OPPLParser.stringOperation_return stringOperation() throws RecognitionException {
        OPPLPatternScript_OPPLParser.stringOperation_return retval = new OPPLPatternScript_OPPLParser.stringOperation_return();
        retval.start = input.LT(1);

        OPPLSyntaxTree root_0 = null;

        Token PLUS71=null;
        OPPLPatternScript_OPPLParser.stringExpression_return stringExpression70 = null;

        OPPLPatternScript_OPPLParser.stringExpression_return stringExpression72 = null;


        OPPLSyntaxTree PLUS71_tree=null;
        RewriteRuleTokenStream stream_PLUS=new RewriteRuleTokenStream(adaptor,"token PLUS");
        RewriteRuleSubtreeStream stream_stringExpression=new RewriteRuleSubtreeStream(adaptor,"rule stringExpression");
        try {
            // OPPLParser.g:109:3: ( stringExpression ( PLUS stringExpression )* -> ^( STRING_OPERATION ( stringExpression )+ ) )
            // OPPLParser.g:110:5: stringExpression ( PLUS stringExpression )*
            {
            pushFollow(FOLLOW_stringExpression_in_stringOperation871);
            stringExpression70=stringExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_stringExpression.add(stringExpression70.getTree());
            // OPPLParser.g:110:22: ( PLUS stringExpression )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==PLUS) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // OPPLParser.g:110:23: PLUS stringExpression
            	    {
            	    PLUS71=(Token)match(input,PLUS,FOLLOW_PLUS_in_stringOperation874); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_PLUS.add(PLUS71);

            	    pushFollow(FOLLOW_stringExpression_in_stringOperation876);
            	    stringExpression72=stringExpression();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_stringExpression.add(stringExpression72.getTree());

            	    }
            	    break;

            	default :
            	    break loop13;
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
            // 110:47: -> ^( STRING_OPERATION ( stringExpression )+ )
            {
                // OPPLParser.g:110:50: ^( STRING_OPERATION ( stringExpression )+ )
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
    // OPPLParser.g:113:1: stringExpression : ( DBLQUOTE -> ^( DBLQUOTE ) | variableAttributeReference -> ^( variableAttributeReference ) );
    public final OPPLPatternScript_OPPLParser.stringExpression_return stringExpression() throws RecognitionException {
        OPPLPatternScript_OPPLParser.stringExpression_return retval = new OPPLPatternScript_OPPLParser.stringExpression_return();
        retval.start = input.LT(1);

        OPPLSyntaxTree root_0 = null;

        Token DBLQUOTE73=null;
        OPPLPatternScript_OPPLParser.variableAttributeReference_return variableAttributeReference74 = null;


        OPPLSyntaxTree DBLQUOTE73_tree=null;
        RewriteRuleTokenStream stream_DBLQUOTE=new RewriteRuleTokenStream(adaptor,"token DBLQUOTE");
        RewriteRuleSubtreeStream stream_variableAttributeReference=new RewriteRuleSubtreeStream(adaptor,"rule variableAttributeReference");
        try {
            // OPPLParser.g:114:2: ( DBLQUOTE -> ^( DBLQUOTE ) | variableAttributeReference -> ^( variableAttributeReference ) )
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==DBLQUOTE) ) {
                alt14=1;
            }
            else if ( (LA14_0==VARIABLE_NAME) ) {
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
                    // OPPLParser.g:115:3: DBLQUOTE
                    {
                    DBLQUOTE73=(Token)match(input,DBLQUOTE,FOLLOW_DBLQUOTE_in_stringExpression903); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_DBLQUOTE.add(DBLQUOTE73);



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
                    // 115:12: -> ^( DBLQUOTE )
                    {
                        // OPPLParser.g:115:15: ^( DBLQUOTE )
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
                    // OPPLParser.g:116:8: variableAttributeReference
                    {
                    pushFollow(FOLLOW_variableAttributeReference_in_stringExpression918);
                    variableAttributeReference74=variableAttributeReference();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_variableAttributeReference.add(variableAttributeReference74.getTree());


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
                    // 116:35: -> ^( variableAttributeReference )
                    {
                        // OPPLParser.g:116:38: ^( variableAttributeReference )
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
             finally {
        }
        return retval;
    }
    // $ANTLR end "stringExpression"

    public static class createIdentifier_return extends ParserRuleReturnScope {
        OPPLSyntaxTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "createIdentifier"
    // OPPLParser.g:129:1: createIdentifier : ESCLAMATION_MARK IDENTIFIER -> ^( IDENTIFIER[$ESCLAMATION_MARK.getText()+ $IDENTIFIER.getText()] ) ;
    public final OPPLPatternScript_OPPLParser.createIdentifier_return createIdentifier() throws RecognitionException {
        OPPLPatternScript_OPPLParser.createIdentifier_return retval = new OPPLPatternScript_OPPLParser.createIdentifier_return();
        retval.start = input.LT(1);

        OPPLSyntaxTree root_0 = null;

        Token ESCLAMATION_MARK75=null;
        Token IDENTIFIER76=null;

        OPPLSyntaxTree ESCLAMATION_MARK75_tree=null;
        OPPLSyntaxTree IDENTIFIER76_tree=null;
        RewriteRuleTokenStream stream_ESCLAMATION_MARK=new RewriteRuleTokenStream(adaptor,"token ESCLAMATION_MARK");
        RewriteRuleTokenStream stream_IDENTIFIER=new RewriteRuleTokenStream(adaptor,"token IDENTIFIER");

        try {
            // OPPLParser.g:130:3: ( ESCLAMATION_MARK IDENTIFIER -> ^( IDENTIFIER[$ESCLAMATION_MARK.getText()+ $IDENTIFIER.getText()] ) )
            // OPPLParser.g:131:4: ESCLAMATION_MARK IDENTIFIER
            {
            ESCLAMATION_MARK75=(Token)match(input,ESCLAMATION_MARK,FOLLOW_ESCLAMATION_MARK_in_createIdentifier1013); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_ESCLAMATION_MARK.add(ESCLAMATION_MARK75);

            IDENTIFIER76=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_createIdentifier1015); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_IDENTIFIER.add(IDENTIFIER76);



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
            // 131:33: -> ^( IDENTIFIER[$ESCLAMATION_MARK.getText()+ $IDENTIFIER.getText()] )
            {
                // OPPLParser.g:131:36: ^( IDENTIFIER[$ESCLAMATION_MARK.getText()+ $IDENTIFIER.getText()] )
                {
                OPPLSyntaxTree root_1 = (OPPLSyntaxTree)adaptor.nil();
                root_1 = (OPPLSyntaxTree)adaptor.becomeRoot((OPPLSyntaxTree)adaptor.create(IDENTIFIER, ESCLAMATION_MARK75.getText()+ IDENTIFIER76.getText()), root_1);

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
    // OPPLParser.g:134:1: variableAttributeReference : ( VARIABLE_NAME DOT (a= VALUES | a= RENDERING ) -> ^( IDENTIFIER[$VARIABLE_NAME.getText()+$DOT.getText() + $a.getText()] VARIABLE_NAME DOT $a) | VARIABLE_NAME DOT GROUPS attributeSelector -> ^( IDENTIFIER[$VARIABLE_NAME.getText()+$DOT.getText() + $GROUPS.getText()+$attributeSelector.selectorText] VARIABLE_NAME DOT GROUPS attributeSelector ) );
    public final OPPLPatternScript_OPPLParser.variableAttributeReference_return variableAttributeReference() throws RecognitionException {
        OPPLPatternScript_OPPLParser.variableAttributeReference_return retval = new OPPLPatternScript_OPPLParser.variableAttributeReference_return();
        retval.start = input.LT(1);

        OPPLSyntaxTree root_0 = null;

        Token a=null;
        Token VARIABLE_NAME77=null;
        Token DOT78=null;
        Token VARIABLE_NAME79=null;
        Token DOT80=null;
        Token GROUPS81=null;
        OPPLPatternScript_OPPLParser.attributeSelector_return attributeSelector82 = null;


        OPPLSyntaxTree a_tree=null;
        OPPLSyntaxTree VARIABLE_NAME77_tree=null;
        OPPLSyntaxTree DOT78_tree=null;
        OPPLSyntaxTree VARIABLE_NAME79_tree=null;
        OPPLSyntaxTree DOT80_tree=null;
        OPPLSyntaxTree GROUPS81_tree=null;
        RewriteRuleTokenStream stream_VARIABLE_NAME=new RewriteRuleTokenStream(adaptor,"token VARIABLE_NAME");
        RewriteRuleTokenStream stream_DOT=new RewriteRuleTokenStream(adaptor,"token DOT");
        RewriteRuleTokenStream stream_RENDERING=new RewriteRuleTokenStream(adaptor,"token RENDERING");
        RewriteRuleTokenStream stream_GROUPS=new RewriteRuleTokenStream(adaptor,"token GROUPS");
        RewriteRuleTokenStream stream_VALUES=new RewriteRuleTokenStream(adaptor,"token VALUES");
        RewriteRuleSubtreeStream stream_attributeSelector=new RewriteRuleSubtreeStream(adaptor,"rule attributeSelector");
        try {
            // OPPLParser.g:135:3: ( VARIABLE_NAME DOT (a= VALUES | a= RENDERING ) -> ^( IDENTIFIER[$VARIABLE_NAME.getText()+$DOT.getText() + $a.getText()] VARIABLE_NAME DOT $a) | VARIABLE_NAME DOT GROUPS attributeSelector -> ^( IDENTIFIER[$VARIABLE_NAME.getText()+$DOT.getText() + $GROUPS.getText()+$attributeSelector.selectorText] VARIABLE_NAME DOT GROUPS attributeSelector ) )
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==VARIABLE_NAME) ) {
                int LA17_1 = input.LA(2);

                if ( (LA17_1==DOT) ) {
                    int LA17_2 = input.LA(3);

                    if ( (LA17_2==GROUPS) ) {
                        alt17=2;
                    }
                    else if ( ((LA17_2>=VALUES && LA17_2<=RENDERING)) ) {
                        alt17=1;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 17, 2, input);

                        throw nvae;
                    }
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 17, 1, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 17, 0, input);

                throw nvae;
            }
            switch (alt17) {
                case 1 :
                    // OPPLParser.g:136:5: VARIABLE_NAME DOT (a= VALUES | a= RENDERING )
                    {
                    VARIABLE_NAME77=(Token)match(input,VARIABLE_NAME,FOLLOW_VARIABLE_NAME_in_variableAttributeReference1042); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_VARIABLE_NAME.add(VARIABLE_NAME77);

                    DOT78=(Token)match(input,DOT,FOLLOW_DOT_in_variableAttributeReference1044); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_DOT.add(DOT78);

                    // OPPLParser.g:136:23: (a= VALUES | a= RENDERING )
                    int alt16=2;
                    int LA16_0 = input.LA(1);

                    if ( (LA16_0==VALUES) ) {
                        alt16=1;
                    }
                    else if ( (LA16_0==RENDERING) ) {
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
                            // OPPLParser.g:136:24: a= VALUES
                            {
                            a=(Token)match(input,VALUES,FOLLOW_VALUES_in_variableAttributeReference1051); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_VALUES.add(a);


                            }
                            break;
                        case 2 :
                            // OPPLParser.g:136:37: a= RENDERING
                            {
                            a=(Token)match(input,RENDERING,FOLLOW_RENDERING_in_variableAttributeReference1059); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_RENDERING.add(a);


                            }
                            break;

                    }



                    // AST REWRITE
                    // elements: a, VARIABLE_NAME, DOT
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
                    // 136:54: -> ^( IDENTIFIER[$VARIABLE_NAME.getText()+$DOT.getText() + $a.getText()] VARIABLE_NAME DOT $a)
                    {
                        // OPPLParser.g:136:56: ^( IDENTIFIER[$VARIABLE_NAME.getText()+$DOT.getText() + $a.getText()] VARIABLE_NAME DOT $a)
                        {
                        OPPLSyntaxTree root_1 = (OPPLSyntaxTree)adaptor.nil();
                        root_1 = (OPPLSyntaxTree)adaptor.becomeRoot((OPPLSyntaxTree)adaptor.create(IDENTIFIER, VARIABLE_NAME77.getText()+DOT78.getText() + a.getText()), root_1);

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
                    // OPPLParser.g:137:7: VARIABLE_NAME DOT GROUPS attributeSelector
                    {
                    VARIABLE_NAME79=(Token)match(input,VARIABLE_NAME,FOLLOW_VARIABLE_NAME_in_variableAttributeReference1083); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_VARIABLE_NAME.add(VARIABLE_NAME79);

                    DOT80=(Token)match(input,DOT,FOLLOW_DOT_in_variableAttributeReference1085); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_DOT.add(DOT80);

                    GROUPS81=(Token)match(input,GROUPS,FOLLOW_GROUPS_in_variableAttributeReference1087); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_GROUPS.add(GROUPS81);

                    pushFollow(FOLLOW_attributeSelector_in_variableAttributeReference1089);
                    attributeSelector82=attributeSelector();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_attributeSelector.add(attributeSelector82.getTree());


                    // AST REWRITE
                    // elements: VARIABLE_NAME, GROUPS, DOT, attributeSelector
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (OPPLSyntaxTree)adaptor.nil();
                    // 137:51: -> ^( IDENTIFIER[$VARIABLE_NAME.getText()+$DOT.getText() + $GROUPS.getText()+$attributeSelector.selectorText] VARIABLE_NAME DOT GROUPS attributeSelector )
                    {
                        // OPPLParser.g:137:53: ^( IDENTIFIER[$VARIABLE_NAME.getText()+$DOT.getText() + $GROUPS.getText()+$attributeSelector.selectorText] VARIABLE_NAME DOT GROUPS attributeSelector )
                        {
                        OPPLSyntaxTree root_1 = (OPPLSyntaxTree)adaptor.nil();
                        root_1 = (OPPLSyntaxTree)adaptor.becomeRoot((OPPLSyntaxTree)adaptor.create(IDENTIFIER, VARIABLE_NAME79.getText()+DOT80.getText() + GROUPS81.getText()+(attributeSelector82!=null?attributeSelector82.selectorText:null)), root_1);

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
    // OPPLParser.g:142:1: attributeSelector returns [String selectorText] : OPEN_PARENTHESYS i= INTEGER CLOSED_PARENTHESYS -> ^( ATTRIBUTE_SELECTOR INTEGER ) ;
    public final OPPLPatternScript_OPPLParser.attributeSelector_return attributeSelector() throws RecognitionException {
        OPPLPatternScript_OPPLParser.attributeSelector_return retval = new OPPLPatternScript_OPPLParser.attributeSelector_return();
        retval.start = input.LT(1);

        OPPLSyntaxTree root_0 = null;

        Token i=null;
        Token OPEN_PARENTHESYS83=null;
        Token CLOSED_PARENTHESYS84=null;

        OPPLSyntaxTree i_tree=null;
        OPPLSyntaxTree OPEN_PARENTHESYS83_tree=null;
        OPPLSyntaxTree CLOSED_PARENTHESYS84_tree=null;
        RewriteRuleTokenStream stream_INTEGER=new RewriteRuleTokenStream(adaptor,"token INTEGER");
        RewriteRuleTokenStream stream_CLOSED_PARENTHESYS=new RewriteRuleTokenStream(adaptor,"token CLOSED_PARENTHESYS");
        RewriteRuleTokenStream stream_OPEN_PARENTHESYS=new RewriteRuleTokenStream(adaptor,"token OPEN_PARENTHESYS");

        try {
            // OPPLParser.g:143:3: ( OPEN_PARENTHESYS i= INTEGER CLOSED_PARENTHESYS -> ^( ATTRIBUTE_SELECTOR INTEGER ) )
            // OPPLParser.g:144:5: OPEN_PARENTHESYS i= INTEGER CLOSED_PARENTHESYS
            {
            OPEN_PARENTHESYS83=(Token)match(input,OPEN_PARENTHESYS,FOLLOW_OPEN_PARENTHESYS_in_attributeSelector1138); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_OPEN_PARENTHESYS.add(OPEN_PARENTHESYS83);

            i=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_attributeSelector1144); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_INTEGER.add(i);

            CLOSED_PARENTHESYS84=(Token)match(input,CLOSED_PARENTHESYS,FOLLOW_CLOSED_PARENTHESYS_in_attributeSelector1146); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_CLOSED_PARENTHESYS.add(CLOSED_PARENTHESYS84);

            if ( state.backtracking==0 ) {

                    retval.selectorText = OPEN_PARENTHESYS83.getText() + i.getText() + CLOSED_PARENTHESYS84.getText();
                  
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
            // 148:5: -> ^( ATTRIBUTE_SELECTOR INTEGER )
            {
                // OPPLParser.g:148:9: ^( ATTRIBUTE_SELECTOR INTEGER )
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
             finally {
        }
        return retval;
    }
    // $ANTLR end "attributeSelector"

    // Delegated rules


 

    public static final BitSet FOLLOW_variableDefinition_in_variableDefinitions205 = new BitSet(new long[]{0x0000002000000002L});
    public static final BitSet FOLLOW_COMMA_in_variableDefinitions208 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_variableDefinition_in_variableDefinitions210 = new BitSet(new long[]{0x0000002000000002L});
    public static final BitSet FOLLOW_VARIABLE_NAME_in_variableDefinition244 = new BitSet(new long[]{0x0000000000000000L,0x0000000000002000L});
    public static final BitSet FOLLOW_COLON_in_variableDefinition246 = new BitSet(new long[]{0x0000000000000000L,0x0000000002000000L});
    public static final BitSet FOLLOW_VARIABLE_TYPE_in_variableDefinition248 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_EQUAL_in_variableDefinition251 = new BitSet(new long[]{0x0000000000000000L,0x0000000000070000L});
    public static final BitSet FOLLOW_opplFunction_in_variableDefinition253 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_VARIABLE_NAME_in_variableDefinition281 = new BitSet(new long[]{0x0000000000000000L,0x0000000000002000L});
    public static final BitSet FOLLOW_COLON_in_variableDefinition283 = new BitSet(new long[]{0x0000000000000000L,0x0000000002000000L});
    public static final BitSet FOLLOW_VARIABLE_TYPE_in_variableDefinition285 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_EQUAL_in_variableDefinition288 = new BitSet(new long[]{0x0000310000081060L,0x0000000000000000L,0x0000000000200000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000100010000L,0x0000000000010000L});
    public static final BitSet FOLLOW_expression_in_variableDefinition290 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_VARIABLE_NAME_in_variableDefinition314 = new BitSet(new long[]{0x0000000000000000L,0x0000000000002000L});
    public static final BitSet FOLLOW_COLON_in_variableDefinition316 = new BitSet(new long[]{0x0000000000000000L,0x0000000002000000L});
    public static final BitSet FOLLOW_VARIABLE_TYPE_in_variableDefinition318 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_EQUAL_in_variableDefinition321 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0001000000000000L});
    public static final BitSet FOLLOW_MATCH_in_variableDefinition323 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_OPEN_PARENTHESYS_in_variableDefinition325 = new BitSet(new long[]{0x0000010000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_stringOperation_in_variableDefinition327 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_CLOSED_PARENTHESYS_in_variableDefinition329 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_VARIABLE_NAME_in_variableDefinition353 = new BitSet(new long[]{0x0000000000000000L,0x0000000000002000L});
    public static final BitSet FOLLOW_COLON_in_variableDefinition355 = new BitSet(new long[]{0x0000000000000000L,0x0000000002000000L});
    public static final BitSet FOLLOW_VARIABLE_TYPE_in_variableDefinition357 = new BitSet(new long[]{0x0000000000000002L,0x0000000000200000L});
    public static final BitSet FOLLOW_variableScope_in_variableDefinition360 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OPEN_SQUARE_BRACKET_in_variableScope400 = new BitSet(new long[]{0x000000C000100000L,0x0000020001800000L});
    public static final BitSet FOLLOW_SUBCLASS_OF_in_variableScope407 = new BitSet(new long[]{0x0000310000081060L,0x0000000000400000L,0x0000000000200000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000100010000L,0x0000000000010000L});
    public static final BitSet FOLLOW_SUBPROPERTY_OF_in_variableScope415 = new BitSet(new long[]{0x0000310000081060L,0x0000000000400000L,0x0000000000200000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000100010000L,0x0000000000010000L});
    public static final BitSet FOLLOW_SUPER_CLASS_OF_in_variableScope423 = new BitSet(new long[]{0x0000310000081060L,0x0000000000400000L,0x0000000000200000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000100010000L,0x0000000000010000L});
    public static final BitSet FOLLOW_SUPER_PROPERTY_OF_in_variableScope431 = new BitSet(new long[]{0x0000310000081060L,0x0000000000400000L,0x0000000000200000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000100010000L,0x0000000000010000L});
    public static final BitSet FOLLOW_INSTANCE_OF_in_variableScope440 = new BitSet(new long[]{0x0000310000081060L,0x0000000000400000L,0x0000000000200000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000100010000L,0x0000000000010000L});
    public static final BitSet FOLLOW_TYPES_in_variableScope448 = new BitSet(new long[]{0x0000310000081060L,0x0000000000400000L,0x0000000000200000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000100010000L,0x0000000000010000L});
    public static final BitSet FOLLOW_expression_in_variableScope451 = new BitSet(new long[]{0x0000000000000000L,0x0000000000400000L});
    public static final BitSet FOLLOW_CLOSED_SQUARE_BRACKET_in_variableScope453 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SELECT_in_query489 = new BitSet(new long[]{0x0000310FE4781060L,0x0000000000001000L,0x0000000000200000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000100010000L,0x0000000000010000L});
    public static final BitSet FOLLOW_selectClause_in_query491 = new BitSet(new long[]{0x0000002000000002L,0x0000000000000080L});
    public static final BitSet FOLLOW_COMMA_in_query494 = new BitSet(new long[]{0x0000310FE4781060L,0x0000000000001000L,0x0000000000200000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000100010000L,0x0000000000010000L});
    public static final BitSet FOLLOW_selectClause_in_query496 = new BitSet(new long[]{0x0000002000000002L,0x0000000000000080L});
    public static final BitSet FOLLOW_WHERE_in_query501 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_constraint_in_query503 = new BitSet(new long[]{0x0000002000000002L});
    public static final BitSet FOLLOW_COMMA_in_query506 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_constraint_in_query508 = new BitSet(new long[]{0x0000002000000002L});
    public static final BitSet FOLLOW_ASSERTED_in_selectClause545 = new BitSet(new long[]{0x0000310FE4781060L,0x0000000000001000L,0x0000000000200000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000100010000L,0x0000000000010000L});
    public static final BitSet FOLLOW_axiom_in_selectClause547 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_axiom_in_selectClause563 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_VARIABLE_NAME_in_constraint602 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_NOT_EQUAL_in_constraint604 = new BitSet(new long[]{0x0000310000081060L,0x0000000000000000L,0x0000000000200000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000100010000L,0x0000000000010000L});
    public static final BitSet FOLLOW_expression_in_constraint610 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_VARIABLE_NAME_in_constraint635 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000400L});
    public static final BitSet FOLLOW_IN_in_constraint637 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_oneOf_in_constraint639 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_VARIABLE_NAME_in_constraint659 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0001000000000000L});
    public static final BitSet FOLLOW_MATCH_in_constraint661 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_OPEN_PARENTHESYS_in_constraint663 = new BitSet(new long[]{0x0000010000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_stringOperation_in_constraint665 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_CLOSED_PARENTHESYS_in_constraint667 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BEGIN_in_actions698 = new BitSet(new long[]{0x0000000000000000L,0x000000000C000000L});
    public static final BitSet FOLLOW_action_in_actions700 = new BitSet(new long[]{0x0000002000000000L,0x0000000000100000L});
    public static final BitSet FOLLOW_COMMA_in_actions703 = new BitSet(new long[]{0x0000000000000000L,0x000000000C000000L});
    public static final BitSet FOLLOW_action_in_actions705 = new BitSet(new long[]{0x0000002000000000L,0x0000000000100000L});
    public static final BitSet FOLLOW_END_in_actions709 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ADD_in_action741 = new BitSet(new long[]{0x0000310FE4781060L,0x0000000000001000L,0x0000000000200000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000100010000L,0x0000000000010000L});
    public static final BitSet FOLLOW_axiom_in_action743 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_REMOVE_in_action759 = new BitSet(new long[]{0x0000310FE4781060L,0x0000000000001000L,0x0000000000200000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000100010000L,0x0000000000010000L});
    public static final BitSet FOLLOW_axiom_in_action761 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CREATE_in_opplFunction794 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_OPEN_PARENTHESYS_in_opplFunction796 = new BitSet(new long[]{0x0000010000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_stringOperation_in_opplFunction798 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_CLOSED_PARENTHESYS_in_opplFunction800 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CREATE_INTERSECTION_in_opplFunction816 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_OPEN_PARENTHESYS_in_opplFunction819 = new BitSet(new long[]{0x0000300000000000L,0x0000000000000000L,0x0000000000200000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000100010000L,0x0000000000010000L});
    public static final BitSet FOLLOW_atomic_in_opplFunction821 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_CLOSED_PARENTHESYS_in_opplFunction824 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CREATE_DISJUNCTION_in_opplFunction840 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_OPEN_PARENTHESYS_in_opplFunction842 = new BitSet(new long[]{0x0000300000000000L,0x0000000000000000L,0x0000000000200000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000100010000L,0x0000000000010000L});
    public static final BitSet FOLLOW_atomic_in_opplFunction844 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_CLOSED_PARENTHESYS_in_opplFunction846 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_stringExpression_in_stringOperation871 = new BitSet(new long[]{0x0000000000000002L,0x0000000000008000L});
    public static final BitSet FOLLOW_PLUS_in_stringOperation874 = new BitSet(new long[]{0x0000010000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_stringExpression_in_stringOperation876 = new BitSet(new long[]{0x0000000000000002L,0x0000000000008000L});
    public static final BitSet FOLLOW_DBLQUOTE_in_stringExpression903 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_variableAttributeReference_in_stringExpression918 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ESCLAMATION_MARK_in_createIdentifier1013 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_createIdentifier1015 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_VARIABLE_NAME_in_variableAttributeReference1042 = new BitSet(new long[]{0x0000000000000000L,0x0000000000004000L});
    public static final BitSet FOLLOW_DOT_in_variableAttributeReference1044 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000C00000000L});
    public static final BitSet FOLLOW_VALUES_in_variableAttributeReference1051 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RENDERING_in_variableAttributeReference1059 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_VARIABLE_NAME_in_variableAttributeReference1083 = new BitSet(new long[]{0x0000000000000000L,0x0000000000004000L});
    public static final BitSet FOLLOW_DOT_in_variableAttributeReference1085 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000001000000000L});
    public static final BitSet FOLLOW_GROUPS_in_variableAttributeReference1087 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_attributeSelector_in_variableAttributeReference1089 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OPEN_PARENTHESYS_in_attributeSelector1138 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_INTEGER_in_attributeSelector1144 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_CLOSED_PARENTHESYS_in_attributeSelector1146 = new BitSet(new long[]{0x0000000000000002L});

}