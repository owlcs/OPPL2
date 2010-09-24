// $ANTLR 3.2 Sep 23, 2009 12:02:23 MOWLParser.g 2010-09-22 17:36:40

  package org.coode.parsers;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

import org.antlr.runtime.tree.*;

public class ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase_MOWLParser extends Parser {
    public static final int COMMA=37;
    public static final int DIFFERENT_FROM=24;
    public static final int TYPE_ASSERTION=66;
    public static final int INCOMPLETE_CONJUNCTION=615;
    public static final int SAME_AS_AXIOM=52;
    public static final int INCOMPLETE_SUB_CLASS_AXIOM=604;
    public static final int TYPES=39;
    public static final int ROLE_ASSERTION=67;
    public static final int ALL_RESTRICTION=62;
    public static final int QUESTION_MARK=46;
    public static final int AND=10;
    public static final int EXPRESSION=69;
    public static final int CONSTANT=70;
    public static final int VALUE_RESTRICTION=63;
    public static final int ONE_OF=65;
    public static final int CARDINALITY_RESTRICTION=64;
    public static final int SAME_AS=23;
    public static final int EXACTLY=17;
    public static final int TRANSITIVE=34;
    public static final int SUBCLASS_OF=20;
    public static final int ENTITY_REFERENCE=45;
    public static final int CONJUNCTION=56;
    public static final int INVERSE_OF=25;
    public static final int RANGE=28;
    public static final int CLOSED_PARENTHESYS=8;
    public static final int PROPERTY_CHAIN=57;
    public static final int EQUIVALENT_TO_AXIOM=49;
    public static final int INCOMPLETE_ALL_RESTRICTION=619;
    public static final int SYMMETRIC=30;
    public static final int DISJOINT_WITH=26;
    public static final int INCOMPLETE_VALUE_RESTRICTION=622;
    public static final int DISJUNCTION=55;
    public static final int INCOMPLETE_CARDINALITY_RESTRICTION=620;
    public static final int NEGATED_EXPRESSION=58;
    public static final int DIFFERENT_FROM_AXIOM=53;
    public static final int EQUIVALENT_TO=22;
    public static final int DOMAIN=27;
    public static final int SUB_PROPERTY_OF=21;
    public static final int INVERSE_OBJECT_PROPERTY_EXPRESSION=68;
    public static final int INVERSE_PROPERTY=60;
    public static final int SUB_CLASS_AXIOM=48;
    public static final int SUB_PROPERTY_AXIOM=51;
    public static final int INCOMPLETE_DIFFERENT_FROM_AXIOM=609;
    public static final int INCOMPLETE_INVERSE_OBJECT_PROPERTY_EXPRESSION=616;
    public static final int IDENTIFIER=44;
    public static final int UNARY_AXIOM=54;
    public static final int INCOMPLETE_PROPERTY_CHAIN=613;
    public static final int OPEN_CURLY_BRACES=6;
    public static final int STANDALONE_EXPRESSION=600;
    public static final int INSTANCE_OF=38;
    public static final int INCOMPLETE_DISJUNCTION=614;
    public static final int SOME_RESTRICTION=61;
    public static final int INCOMPLETE_SUB_PROPERTY_AXIOM=607;
    public static final int INCOMPLETE_INVERSE_OF=612;
    public static final int INCOMPLETE_DOMAIN=610;
    public static final int VALUE=18;
    public static final int INCOMPLETE_UNARY_AXIOM=603;
    public static final int INVERSE_FUNCTIONAL=35;
    public static final int OR=11;
    public static final int INCOMPLETE_EXPRESSION=623;
    public static final int INTEGER=42;
    public static final int INVERSE=19;
    public static final int DISJOINT_WITH_AXIOM=50;
    public static final int INCOMPLETE_DISJOINT_WITH_AXIOM=606;
    public static final int DIGIT=41;
    public static final int COMPOSITION=4;
    public static final int INCOMPLETE_RANGE=611;
    public static final int FUNCTIONAL=29;
    public static final int LETTER=43;
    public static final int MAX=16;
    public static final int INCOMPLETE_ROLE_ASSERTION=602;
    public static final int NEGATED_ASSERTION=59;
    public static final int ONLY=14;
    public static final int DBLQUOTE=40;
    public static final int MIN=15;
    public static final int POW=36;
    public static final int INCOMPLETE_TYPE_ASSERTION=601;
    public static final int INCOMPLETE_ONE_OF=621;
    public static final int INCOMPLETE_NEGATED_EXPRESSION=617;
    public static final int WHITESPACE=9;
    public static final int SOME=13;
    public static final int INCOMPLETE_SAME_AS_AXIOM=608;
    public static final int INCOMPLETE_EQUIVALENT_TO_AXIOM=605;
    public static final int EOF=-1;
    public static final int ANTI_SYMMETRIC=31;
    public static final int Tokens=47;
    public static final int CLOSED_CURLY_BRACES=7;
    public static final int INCOMPLETE_SOME_RESTRICTION=618;
    public static final int REFLEXIVE=32;
    public static final int NOT=12;
    public static final int OPEN_PARENTHESYS=5;
    public static final int IRREFLEXIVE=33;

    // delegates
    // delegators
    public ManchesterOWLSyntaxAutoCompleteCombinedParser gManchesterOWLSyntaxAutoCompleteCombined;
    public ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase gManchesterOWLSyntaxAutoCompleteBase;
    public ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase gParent;


        public ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase_MOWLParser(TokenStream input, ManchesterOWLSyntaxAutoCompleteCombinedParser gManchesterOWLSyntaxAutoCompleteCombined, ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase gManchesterOWLSyntaxAutoCompleteBase) {
            this(input, new RecognizerSharedState(), gManchesterOWLSyntaxAutoCompleteCombined, gManchesterOWLSyntaxAutoCompleteBase);
        }
        public ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase_MOWLParser(TokenStream input, RecognizerSharedState state, ManchesterOWLSyntaxAutoCompleteCombinedParser gManchesterOWLSyntaxAutoCompleteCombined, ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase gManchesterOWLSyntaxAutoCompleteBase) {
            super(input, state);
            this.gManchesterOWLSyntaxAutoCompleteCombined = gManchesterOWLSyntaxAutoCompleteCombined;
            this.gManchesterOWLSyntaxAutoCompleteBase = gManchesterOWLSyntaxAutoCompleteBase;
             
            gParent = gManchesterOWLSyntaxAutoCompleteBase;
        }
        
    protected TreeAdaptor adaptor = new CommonTreeAdaptor();

    public void setTreeAdaptor(TreeAdaptor adaptor) {
        this.adaptor = adaptor;
    }
    public TreeAdaptor getTreeAdaptor() {
        return adaptor;
    }

    public String[] getTokenNames() { return ManchesterOWLSyntaxAutoCompleteCombinedParser.tokenNames; }
    public String getGrammarFileName() { return "MOWLParser.g"; }


    public void displayRecognitionError(String[] tokenNames,
    										RecognitionException e){
    	}
    	


    public static class axiom_return extends ParserRuleReturnScope {
        ManchesterOWLSyntaxTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "axiom"
    // MOWLParser.g:63:1: axiom options {backtrack=true; } : ( binaryAxiom -> ^( binaryAxiom ) | unaryAxiom -> ^( unaryAxiom ) | assertionAxiom -> ^( assertionAxiom ) );
    public final ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase_MOWLParser.axiom_return axiom() throws RecognitionException {
        ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase_MOWLParser.axiom_return retval = new ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase_MOWLParser.axiom_return();
        retval.start = input.LT(1);

        ManchesterOWLSyntaxTree root_0 = null;

        ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase_MOWLParser.binaryAxiom_return binaryAxiom1 = null;

        ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase_MOWLParser.unaryAxiom_return unaryAxiom2 = null;

        ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase_MOWLParser.assertionAxiom_return assertionAxiom3 = null;


        RewriteRuleSubtreeStream stream_assertionAxiom=new RewriteRuleSubtreeStream(adaptor,"rule assertionAxiom");
        RewriteRuleSubtreeStream stream_binaryAxiom=new RewriteRuleSubtreeStream(adaptor,"rule binaryAxiom");
        RewriteRuleSubtreeStream stream_unaryAxiom=new RewriteRuleSubtreeStream(adaptor,"rule unaryAxiom");
        try {
            // MOWLParser.g:63:37: ( binaryAxiom -> ^( binaryAxiom ) | unaryAxiom -> ^( unaryAxiom ) | assertionAxiom -> ^( assertionAxiom ) )
            int alt1=3;
            switch ( input.LA(1) ) {
            case IDENTIFIER:
                {
                int LA1_1 = input.LA(2);

                if ( (LA1_1==COMPOSITION||(LA1_1>=AND && LA1_1<=OR)||(LA1_1>=SOME && LA1_1<=VALUE)||(LA1_1>=SUBCLASS_OF && LA1_1<=RANGE)) ) {
                    alt1=1;
                }
                else if ( (LA1_1==INVERSE||(LA1_1>=INSTANCE_OF && LA1_1<=TYPES)||(LA1_1>=IDENTIFIER && LA1_1<=ENTITY_REFERENCE)) ) {
                    alt1=3;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 1, 1, input);

                    throw nvae;
                }
                }
                break;
            case ENTITY_REFERENCE:
                {
                int LA1_2 = input.LA(2);

                if ( (LA1_2==COMPOSITION||(LA1_2>=AND && LA1_2<=OR)||(LA1_2>=SOME && LA1_2<=VALUE)||(LA1_2>=SUBCLASS_OF && LA1_2<=RANGE)) ) {
                    alt1=1;
                }
                else if ( (LA1_2==INVERSE||(LA1_2>=INSTANCE_OF && LA1_2<=TYPES)||(LA1_2>=IDENTIFIER && LA1_2<=ENTITY_REFERENCE)) ) {
                    alt1=3;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 1, 2, input);

                    throw nvae;
                }
                }
                break;
            case OPEN_PARENTHESYS:
            case OPEN_CURLY_BRACES:
            case INVERSE:
            case DBLQUOTE:
                {
                alt1=1;
                }
                break;
            case NOT:
                {
                switch ( input.LA(2) ) {
                case OPEN_PARENTHESYS:
                    {
                    alt1=1;
                    }
                    break;
                case IDENTIFIER:
                    {
                    int LA1_7 = input.LA(3);

                    if ( (LA1_7==INVERSE||(LA1_7>=INSTANCE_OF && LA1_7<=TYPES)||(LA1_7>=IDENTIFIER && LA1_7<=ENTITY_REFERENCE)) ) {
                        alt1=3;
                    }
                    else if ( ((LA1_7>=AND && LA1_7<=OR)||(LA1_7>=SUBCLASS_OF && LA1_7<=EQUIVALENT_TO)||LA1_7==DISJOINT_WITH) ) {
                        alt1=1;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 1, 7, input);

                        throw nvae;
                    }
                    }
                    break;
                case ENTITY_REFERENCE:
                    {
                    int LA1_8 = input.LA(3);

                    if ( ((LA1_8>=AND && LA1_8<=OR)||(LA1_8>=SUBCLASS_OF && LA1_8<=EQUIVALENT_TO)||LA1_8==DISJOINT_WITH) ) {
                        alt1=1;
                    }
                    else if ( (LA1_8==INVERSE||(LA1_8>=INSTANCE_OF && LA1_8<=TYPES)||(LA1_8>=IDENTIFIER && LA1_8<=ENTITY_REFERENCE)) ) {
                        alt1=3;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 1, 8, input);

                        throw nvae;
                    }
                    }
                    break;
                case NOT:
                    {
                    alt1=3;
                    }
                    break;
                default:
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 1, 4, input);

                    throw nvae;
                }

                }
                break;
            case FUNCTIONAL:
            case SYMMETRIC:
            case ANTI_SYMMETRIC:
            case REFLEXIVE:
            case IRREFLEXIVE:
            case TRANSITIVE:
            case INVERSE_FUNCTIONAL:
                {
                alt1=2;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }

            switch (alt1) {
                case 1 :
                    // MOWLParser.g:64:3: binaryAxiom
                    {
                    pushFollow(FOLLOW_binaryAxiom_in_axiom231);
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
                    // 64:15: -> ^( binaryAxiom )
                    {
                        // MOWLParser.g:64:18: ^( binaryAxiom )
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
                    // MOWLParser.g:65:5: unaryAxiom
                    {
                    pushFollow(FOLLOW_unaryAxiom_in_axiom243);
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
                    // 65:16: -> ^( unaryAxiom )
                    {
                        // MOWLParser.g:65:19: ^( unaryAxiom )
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
                    // MOWLParser.g:66:5: assertionAxiom
                    {
                    pushFollow(FOLLOW_assertionAxiom_in_axiom255);
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
                    // 66:20: -> ^( assertionAxiom )
                    {
                        // MOWLParser.g:66:23: ^( assertionAxiom )
                        {
                        ManchesterOWLSyntaxTree root_1 = (ManchesterOWLSyntaxTree)adaptor.nil();
                        root_1 = (ManchesterOWLSyntaxTree)adaptor.becomeRoot(stream_assertionAxiom.nextNode(), root_1);

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

    public static class assertionAxiom_return extends ParserRuleReturnScope {
        ManchesterOWLSyntaxTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "assertionAxiom"
    // MOWLParser.g:71:1: assertionAxiom options {backtrack=true; } : (i= atomic ( INSTANCE_OF | TYPES ) expression -> ^( TYPE_ASSERTION ^( EXPRESSION expression ) ^( EXPRESSION $i) ) | subject= atomic propertyExpression value -> ^( ROLE_ASSERTION ^( EXPRESSION $subject) ^( EXPRESSION propertyExpression ) ^( EXPRESSION value ) ) | NOT assertionAxiom -> ^( NEGATED_ASSERTION assertionAxiom ) );
    public final ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase_MOWLParser.assertionAxiom_return assertionAxiom() throws RecognitionException {
        ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase_MOWLParser.assertionAxiom_return retval = new ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase_MOWLParser.assertionAxiom_return();
        retval.start = input.LT(1);

        ManchesterOWLSyntaxTree root_0 = null;

        Token INSTANCE_OF4=null;
        Token TYPES5=null;
        Token NOT9=null;
        ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase_MOWLParser.atomic_return i = null;

        ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase_MOWLParser.atomic_return subject = null;

        ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase_MOWLParser.expression_return expression6 = null;

        ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase_MOWLParser.propertyExpression_return propertyExpression7 = null;

        ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase_MOWLParser.value_return value8 = null;

        ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase_MOWLParser.assertionAxiom_return assertionAxiom10 = null;


        ManchesterOWLSyntaxTree INSTANCE_OF4_tree=null;
        ManchesterOWLSyntaxTree TYPES5_tree=null;
        ManchesterOWLSyntaxTree NOT9_tree=null;
        RewriteRuleTokenStream stream_TYPES=new RewriteRuleTokenStream(adaptor,"token TYPES");
        RewriteRuleTokenStream stream_NOT=new RewriteRuleTokenStream(adaptor,"token NOT");
        RewriteRuleTokenStream stream_INSTANCE_OF=new RewriteRuleTokenStream(adaptor,"token INSTANCE_OF");
        RewriteRuleSubtreeStream stream_propertyExpression=new RewriteRuleSubtreeStream(adaptor,"rule propertyExpression");
        RewriteRuleSubtreeStream stream_value=new RewriteRuleSubtreeStream(adaptor,"rule value");
        RewriteRuleSubtreeStream stream_assertionAxiom=new RewriteRuleSubtreeStream(adaptor,"rule assertionAxiom");
        RewriteRuleSubtreeStream stream_atomic=new RewriteRuleSubtreeStream(adaptor,"rule atomic");
        RewriteRuleSubtreeStream stream_expression=new RewriteRuleSubtreeStream(adaptor,"rule expression");
        try {
            // MOWLParser.g:71:41: (i= atomic ( INSTANCE_OF | TYPES ) expression -> ^( TYPE_ASSERTION ^( EXPRESSION expression ) ^( EXPRESSION $i) ) | subject= atomic propertyExpression value -> ^( ROLE_ASSERTION ^( EXPRESSION $subject) ^( EXPRESSION propertyExpression ) ^( EXPRESSION value ) ) | NOT assertionAxiom -> ^( NEGATED_ASSERTION assertionAxiom ) )
            int alt3=3;
            switch ( input.LA(1) ) {
            case IDENTIFIER:
                {
                int LA3_1 = input.LA(2);

                if ( ((LA3_1>=INSTANCE_OF && LA3_1<=TYPES)) ) {
                    alt3=1;
                }
                else if ( (LA3_1==INVERSE||(LA3_1>=IDENTIFIER && LA3_1<=ENTITY_REFERENCE)) ) {
                    alt3=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 3, 1, input);

                    throw nvae;
                }
                }
                break;
            case ENTITY_REFERENCE:
                {
                int LA3_2 = input.LA(2);

                if ( ((LA3_2>=INSTANCE_OF && LA3_2<=TYPES)) ) {
                    alt3=1;
                }
                else if ( (LA3_2==INVERSE||(LA3_2>=IDENTIFIER && LA3_2<=ENTITY_REFERENCE)) ) {
                    alt3=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 3, 2, input);

                    throw nvae;
                }
                }
                break;
            case NOT:
                {
                alt3=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }

            switch (alt3) {
                case 1 :
                    // MOWLParser.g:72:3: i= atomic ( INSTANCE_OF | TYPES ) expression
                    {
                    pushFollow(FOLLOW_atomic_in_assertionAxiom285);
                    i=atomic();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_atomic.add(i.getTree());
                    // MOWLParser.g:72:14: ( INSTANCE_OF | TYPES )
                    int alt2=2;
                    int LA2_0 = input.LA(1);

                    if ( (LA2_0==INSTANCE_OF) ) {
                        alt2=1;
                    }
                    else if ( (LA2_0==TYPES) ) {
                        alt2=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 2, 0, input);

                        throw nvae;
                    }
                    switch (alt2) {
                        case 1 :
                            // MOWLParser.g:72:15: INSTANCE_OF
                            {
                            INSTANCE_OF4=(Token)match(input,INSTANCE_OF,FOLLOW_INSTANCE_OF_in_assertionAxiom288); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_INSTANCE_OF.add(INSTANCE_OF4);


                            }
                            break;
                        case 2 :
                            // MOWLParser.g:72:29: TYPES
                            {
                            TYPES5=(Token)match(input,TYPES,FOLLOW_TYPES_in_assertionAxiom292); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_TYPES.add(TYPES5);


                            }
                            break;

                    }

                    pushFollow(FOLLOW_expression_in_assertionAxiom295);
                    expression6=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_expression.add(expression6.getTree());


                    // AST REWRITE
                    // elements: i, expression
                    // token labels: 
                    // rule labels: i, retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_i=new RewriteRuleSubtreeStream(adaptor,"rule i",i!=null?i.tree:null);
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (ManchesterOWLSyntaxTree)adaptor.nil();
                    // 72:47: -> ^( TYPE_ASSERTION ^( EXPRESSION expression ) ^( EXPRESSION $i) )
                    {
                        // MOWLParser.g:72:50: ^( TYPE_ASSERTION ^( EXPRESSION expression ) ^( EXPRESSION $i) )
                        {
                        ManchesterOWLSyntaxTree root_1 = (ManchesterOWLSyntaxTree)adaptor.nil();
                        root_1 = (ManchesterOWLSyntaxTree)adaptor.becomeRoot((ManchesterOWLSyntaxTree)adaptor.create(TYPE_ASSERTION, "TYPE_ASSERTION"), root_1);

                        // MOWLParser.g:72:67: ^( EXPRESSION expression )
                        {
                        ManchesterOWLSyntaxTree root_2 = (ManchesterOWLSyntaxTree)adaptor.nil();
                        root_2 = (ManchesterOWLSyntaxTree)adaptor.becomeRoot((ManchesterOWLSyntaxTree)adaptor.create(EXPRESSION, "EXPRESSION"), root_2);

                        adaptor.addChild(root_2, stream_expression.nextTree());

                        adaptor.addChild(root_1, root_2);
                        }
                        // MOWLParser.g:72:92: ^( EXPRESSION $i)
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
                    // MOWLParser.g:73:7: subject= atomic propertyExpression value
                    {
                    pushFollow(FOLLOW_atomic_in_assertionAxiom326);
                    subject=atomic();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_atomic.add(subject.getTree());
                    pushFollow(FOLLOW_propertyExpression_in_assertionAxiom328);
                    propertyExpression7=propertyExpression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_propertyExpression.add(propertyExpression7.getTree());
                    pushFollow(FOLLOW_value_in_assertionAxiom331);
                    value8=value();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_value.add(value8.getTree());


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
                    // 73:50: -> ^( ROLE_ASSERTION ^( EXPRESSION $subject) ^( EXPRESSION propertyExpression ) ^( EXPRESSION value ) )
                    {
                        // MOWLParser.g:73:53: ^( ROLE_ASSERTION ^( EXPRESSION $subject) ^( EXPRESSION propertyExpression ) ^( EXPRESSION value ) )
                        {
                        ManchesterOWLSyntaxTree root_1 = (ManchesterOWLSyntaxTree)adaptor.nil();
                        root_1 = (ManchesterOWLSyntaxTree)adaptor.becomeRoot((ManchesterOWLSyntaxTree)adaptor.create(ROLE_ASSERTION, "ROLE_ASSERTION"), root_1);

                        // MOWLParser.g:73:70: ^( EXPRESSION $subject)
                        {
                        ManchesterOWLSyntaxTree root_2 = (ManchesterOWLSyntaxTree)adaptor.nil();
                        root_2 = (ManchesterOWLSyntaxTree)adaptor.becomeRoot((ManchesterOWLSyntaxTree)adaptor.create(EXPRESSION, "EXPRESSION"), root_2);

                        adaptor.addChild(root_2, stream_subject.nextTree());

                        adaptor.addChild(root_1, root_2);
                        }
                        // MOWLParser.g:73:93: ^( EXPRESSION propertyExpression )
                        {
                        ManchesterOWLSyntaxTree root_2 = (ManchesterOWLSyntaxTree)adaptor.nil();
                        root_2 = (ManchesterOWLSyntaxTree)adaptor.becomeRoot((ManchesterOWLSyntaxTree)adaptor.create(EXPRESSION, "EXPRESSION"), root_2);

                        adaptor.addChild(root_2, stream_propertyExpression.nextTree());

                        adaptor.addChild(root_1, root_2);
                        }
                        // MOWLParser.g:73:126: ^( EXPRESSION value )
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
                    // MOWLParser.g:75:5: NOT assertionAxiom
                    {
                    NOT9=(Token)match(input,NOT,FOLLOW_NOT_in_assertionAxiom365); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_NOT.add(NOT9);

                    pushFollow(FOLLOW_assertionAxiom_in_assertionAxiom367);
                    assertionAxiom10=assertionAxiom();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_assertionAxiom.add(assertionAxiom10.getTree());


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
                    // 75:24: -> ^( NEGATED_ASSERTION assertionAxiom )
                    {
                        // MOWLParser.g:75:27: ^( NEGATED_ASSERTION assertionAxiom )
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
    // MOWLParser.g:80:1: binaryAxiom options {backtrack=true; } : (lhs= expression SUBCLASS_OF superClass= expression -> ^( SUB_CLASS_AXIOM ^( EXPRESSION $lhs) ^( EXPRESSION $superClass) ) | lhs= expression EQUIVALENT_TO rhs= expression -> ^( EQUIVALENT_TO_AXIOM ^( EXPRESSION $lhs) ^( EXPRESSION $rhs) ) | lhs= expression DISJOINT_WITH disjoint= expression -> ^( DISJOINT_WITH_AXIOM ^( EXPRESSION $lhs) ^( EXPRESSION $disjoint) ) | lhs= expression SUB_PROPERTY_OF superProperty= propertyExpression -> ^( SUB_PROPERTY_AXIOM ^( EXPRESSION $lhs) ^( EXPRESSION $superProperty) ) | lhsID= atomic INVERSE_OF rhsAtomic= atomic -> ^( INVERSE_OF ^( EXPRESSION $lhsID) ^( EXPRESSION $rhsAtomic) ) | lhsID= atomic SAME_AS rhsID= atomic -> ^( SAME_AS_AXIOM ^( EXPRESSION $lhsID) ^( EXPRESSION $rhsID) ) | lhsID= atomic DIFFERENT_FROM rhsID= atomic -> ^( DIFFERENT_FROM_AXIOM ^( EXPRESSION $lhsID) ^( EXPRESSION $rhsID) ) | lhsID= atomic DOMAIN expression -> ^( DOMAIN ^( EXPRESSION $lhsID) ^( EXPRESSION expression ) ) | lhsID= atomic RANGE expression -> ^( RANGE ^( EXPRESSION $lhsID) ^( EXPRESSION expression ) ) );
    public final ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase_MOWLParser.binaryAxiom_return binaryAxiom() throws RecognitionException {
        ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase_MOWLParser.binaryAxiom_return retval = new ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase_MOWLParser.binaryAxiom_return();
        retval.start = input.LT(1);

        ManchesterOWLSyntaxTree root_0 = null;

        Token SUBCLASS_OF11=null;
        Token EQUIVALENT_TO12=null;
        Token DISJOINT_WITH13=null;
        Token SUB_PROPERTY_OF14=null;
        Token INVERSE_OF15=null;
        Token SAME_AS16=null;
        Token DIFFERENT_FROM17=null;
        Token DOMAIN18=null;
        Token RANGE20=null;
        ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase_MOWLParser.expression_return lhs = null;

        ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase_MOWLParser.expression_return superClass = null;

        ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase_MOWLParser.expression_return rhs = null;

        ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase_MOWLParser.expression_return disjoint = null;

        ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase_MOWLParser.propertyExpression_return superProperty = null;

        ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase_MOWLParser.atomic_return lhsID = null;

        ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase_MOWLParser.atomic_return rhsAtomic = null;

        ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase_MOWLParser.atomic_return rhsID = null;

        ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase_MOWLParser.expression_return expression19 = null;

        ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase_MOWLParser.expression_return expression21 = null;


        ManchesterOWLSyntaxTree SUBCLASS_OF11_tree=null;
        ManchesterOWLSyntaxTree EQUIVALENT_TO12_tree=null;
        ManchesterOWLSyntaxTree DISJOINT_WITH13_tree=null;
        ManchesterOWLSyntaxTree SUB_PROPERTY_OF14_tree=null;
        ManchesterOWLSyntaxTree INVERSE_OF15_tree=null;
        ManchesterOWLSyntaxTree SAME_AS16_tree=null;
        ManchesterOWLSyntaxTree DIFFERENT_FROM17_tree=null;
        ManchesterOWLSyntaxTree DOMAIN18_tree=null;
        ManchesterOWLSyntaxTree RANGE20_tree=null;
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
            // MOWLParser.g:82:26: (lhs= expression SUBCLASS_OF superClass= expression -> ^( SUB_CLASS_AXIOM ^( EXPRESSION $lhs) ^( EXPRESSION $superClass) ) | lhs= expression EQUIVALENT_TO rhs= expression -> ^( EQUIVALENT_TO_AXIOM ^( EXPRESSION $lhs) ^( EXPRESSION $rhs) ) | lhs= expression DISJOINT_WITH disjoint= expression -> ^( DISJOINT_WITH_AXIOM ^( EXPRESSION $lhs) ^( EXPRESSION $disjoint) ) | lhs= expression SUB_PROPERTY_OF superProperty= propertyExpression -> ^( SUB_PROPERTY_AXIOM ^( EXPRESSION $lhs) ^( EXPRESSION $superProperty) ) | lhsID= atomic INVERSE_OF rhsAtomic= atomic -> ^( INVERSE_OF ^( EXPRESSION $lhsID) ^( EXPRESSION $rhsAtomic) ) | lhsID= atomic SAME_AS rhsID= atomic -> ^( SAME_AS_AXIOM ^( EXPRESSION $lhsID) ^( EXPRESSION $rhsID) ) | lhsID= atomic DIFFERENT_FROM rhsID= atomic -> ^( DIFFERENT_FROM_AXIOM ^( EXPRESSION $lhsID) ^( EXPRESSION $rhsID) ) | lhsID= atomic DOMAIN expression -> ^( DOMAIN ^( EXPRESSION $lhsID) ^( EXPRESSION expression ) ) | lhsID= atomic RANGE expression -> ^( RANGE ^( EXPRESSION $lhsID) ^( EXPRESSION expression ) ) )
            int alt4=9;
            alt4 = dfa4.predict(input);
            switch (alt4) {
                case 1 :
                    // MOWLParser.g:83:2: lhs= expression SUBCLASS_OF superClass= expression
                    {
                    pushFollow(FOLLOW_expression_in_binaryAxiom406);
                    lhs=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_expression.add(lhs.getTree());
                    SUBCLASS_OF11=(Token)match(input,SUBCLASS_OF,FOLLOW_SUBCLASS_OF_in_binaryAxiom408); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_SUBCLASS_OF.add(SUBCLASS_OF11);

                    pushFollow(FOLLOW_expression_in_binaryAxiom415);
                    superClass=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_expression.add(superClass.getTree());


                    // AST REWRITE
                    // elements: lhs, superClass
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

                    root_0 = (ManchesterOWLSyntaxTree)adaptor.nil();
                    // 83:57: -> ^( SUB_CLASS_AXIOM ^( EXPRESSION $lhs) ^( EXPRESSION $superClass) )
                    {
                        // MOWLParser.g:83:60: ^( SUB_CLASS_AXIOM ^( EXPRESSION $lhs) ^( EXPRESSION $superClass) )
                        {
                        ManchesterOWLSyntaxTree root_1 = (ManchesterOWLSyntaxTree)adaptor.nil();
                        root_1 = (ManchesterOWLSyntaxTree)adaptor.becomeRoot((ManchesterOWLSyntaxTree)adaptor.create(SUB_CLASS_AXIOM, "SUB_CLASS_AXIOM"), root_1);

                        // MOWLParser.g:83:79: ^( EXPRESSION $lhs)
                        {
                        ManchesterOWLSyntaxTree root_2 = (ManchesterOWLSyntaxTree)adaptor.nil();
                        root_2 = (ManchesterOWLSyntaxTree)adaptor.becomeRoot((ManchesterOWLSyntaxTree)adaptor.create(EXPRESSION, "EXPRESSION"), root_2);

                        adaptor.addChild(root_2, stream_lhs.nextTree());

                        adaptor.addChild(root_1, root_2);
                        }
                        // MOWLParser.g:83:98: ^( EXPRESSION $superClass)
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
                    // MOWLParser.g:84:11: lhs= expression EQUIVALENT_TO rhs= expression
                    {
                    pushFollow(FOLLOW_expression_in_binaryAxiom453);
                    lhs=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_expression.add(lhs.getTree());
                    EQUIVALENT_TO12=(Token)match(input,EQUIVALENT_TO,FOLLOW_EQUIVALENT_TO_in_binaryAxiom455); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_EQUIVALENT_TO.add(EQUIVALENT_TO12);

                    pushFollow(FOLLOW_expression_in_binaryAxiom461);
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

                    root_0 = (ManchesterOWLSyntaxTree)adaptor.nil();
                    // 84:60: -> ^( EQUIVALENT_TO_AXIOM ^( EXPRESSION $lhs) ^( EXPRESSION $rhs) )
                    {
                        // MOWLParser.g:84:63: ^( EQUIVALENT_TO_AXIOM ^( EXPRESSION $lhs) ^( EXPRESSION $rhs) )
                        {
                        ManchesterOWLSyntaxTree root_1 = (ManchesterOWLSyntaxTree)adaptor.nil();
                        root_1 = (ManchesterOWLSyntaxTree)adaptor.becomeRoot((ManchesterOWLSyntaxTree)adaptor.create(EQUIVALENT_TO_AXIOM, "EQUIVALENT_TO_AXIOM"), root_1);

                        // MOWLParser.g:84:85: ^( EXPRESSION $lhs)
                        {
                        ManchesterOWLSyntaxTree root_2 = (ManchesterOWLSyntaxTree)adaptor.nil();
                        root_2 = (ManchesterOWLSyntaxTree)adaptor.becomeRoot((ManchesterOWLSyntaxTree)adaptor.create(EXPRESSION, "EXPRESSION"), root_2);

                        adaptor.addChild(root_2, stream_lhs.nextTree());

                        adaptor.addChild(root_1, root_2);
                        }
                        // MOWLParser.g:84:104: ^( EXPRESSION $rhs)
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
                    // MOWLParser.g:85:11: lhs= expression DISJOINT_WITH disjoint= expression
                    {
                    pushFollow(FOLLOW_expression_in_binaryAxiom498);
                    lhs=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_expression.add(lhs.getTree());
                    DISJOINT_WITH13=(Token)match(input,DISJOINT_WITH,FOLLOW_DISJOINT_WITH_in_binaryAxiom500); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_DISJOINT_WITH.add(DISJOINT_WITH13);

                    pushFollow(FOLLOW_expression_in_binaryAxiom506);
                    disjoint=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_expression.add(disjoint.getTree());


                    // AST REWRITE
                    // elements: disjoint, lhs
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

                    root_0 = (ManchesterOWLSyntaxTree)adaptor.nil();
                    // 85:65: -> ^( DISJOINT_WITH_AXIOM ^( EXPRESSION $lhs) ^( EXPRESSION $disjoint) )
                    {
                        // MOWLParser.g:85:68: ^( DISJOINT_WITH_AXIOM ^( EXPRESSION $lhs) ^( EXPRESSION $disjoint) )
                        {
                        ManchesterOWLSyntaxTree root_1 = (ManchesterOWLSyntaxTree)adaptor.nil();
                        root_1 = (ManchesterOWLSyntaxTree)adaptor.becomeRoot((ManchesterOWLSyntaxTree)adaptor.create(DISJOINT_WITH_AXIOM, "DISJOINT_WITH_AXIOM"), root_1);

                        // MOWLParser.g:85:90: ^( EXPRESSION $lhs)
                        {
                        ManchesterOWLSyntaxTree root_2 = (ManchesterOWLSyntaxTree)adaptor.nil();
                        root_2 = (ManchesterOWLSyntaxTree)adaptor.becomeRoot((ManchesterOWLSyntaxTree)adaptor.create(EXPRESSION, "EXPRESSION"), root_2);

                        adaptor.addChild(root_2, stream_lhs.nextTree());

                        adaptor.addChild(root_1, root_2);
                        }
                        // MOWLParser.g:85:109: ^( EXPRESSION $disjoint)
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
                    // MOWLParser.g:86:11: lhs= expression SUB_PROPERTY_OF superProperty= propertyExpression
                    {
                    pushFollow(FOLLOW_expression_in_binaryAxiom543);
                    lhs=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_expression.add(lhs.getTree());
                    SUB_PROPERTY_OF14=(Token)match(input,SUB_PROPERTY_OF,FOLLOW_SUB_PROPERTY_OF_in_binaryAxiom545); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_SUB_PROPERTY_OF.add(SUB_PROPERTY_OF14);

                    pushFollow(FOLLOW_propertyExpression_in_binaryAxiom551);
                    superProperty=propertyExpression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_propertyExpression.add(superProperty.getTree());


                    // AST REWRITE
                    // elements: superProperty, lhs
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

                    root_0 = (ManchesterOWLSyntaxTree)adaptor.nil();
                    // 86:80: -> ^( SUB_PROPERTY_AXIOM ^( EXPRESSION $lhs) ^( EXPRESSION $superProperty) )
                    {
                        // MOWLParser.g:86:83: ^( SUB_PROPERTY_AXIOM ^( EXPRESSION $lhs) ^( EXPRESSION $superProperty) )
                        {
                        ManchesterOWLSyntaxTree root_1 = (ManchesterOWLSyntaxTree)adaptor.nil();
                        root_1 = (ManchesterOWLSyntaxTree)adaptor.becomeRoot((ManchesterOWLSyntaxTree)adaptor.create(SUB_PROPERTY_AXIOM, "SUB_PROPERTY_AXIOM"), root_1);

                        // MOWLParser.g:86:104: ^( EXPRESSION $lhs)
                        {
                        ManchesterOWLSyntaxTree root_2 = (ManchesterOWLSyntaxTree)adaptor.nil();
                        root_2 = (ManchesterOWLSyntaxTree)adaptor.becomeRoot((ManchesterOWLSyntaxTree)adaptor.create(EXPRESSION, "EXPRESSION"), root_2);

                        adaptor.addChild(root_2, stream_lhs.nextTree());

                        adaptor.addChild(root_1, root_2);
                        }
                        // MOWLParser.g:86:123: ^( EXPRESSION $superProperty)
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
                    // MOWLParser.g:87:11: lhsID= atomic INVERSE_OF rhsAtomic= atomic
                    {
                    pushFollow(FOLLOW_atomic_in_binaryAxiom588);
                    lhsID=atomic();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_atomic.add(lhsID.getTree());
                    INVERSE_OF15=(Token)match(input,INVERSE_OF,FOLLOW_INVERSE_OF_in_binaryAxiom590); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_INVERSE_OF.add(INVERSE_OF15);

                    pushFollow(FOLLOW_atomic_in_binaryAxiom596);
                    rhsAtomic=atomic();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_atomic.add(rhsAtomic.getTree());


                    // AST REWRITE
                    // elements: rhsAtomic, lhsID, INVERSE_OF
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

                    root_0 = (ManchesterOWLSyntaxTree)adaptor.nil();
                    // 87:57: -> ^( INVERSE_OF ^( EXPRESSION $lhsID) ^( EXPRESSION $rhsAtomic) )
                    {
                        // MOWLParser.g:87:60: ^( INVERSE_OF ^( EXPRESSION $lhsID) ^( EXPRESSION $rhsAtomic) )
                        {
                        ManchesterOWLSyntaxTree root_1 = (ManchesterOWLSyntaxTree)adaptor.nil();
                        root_1 = (ManchesterOWLSyntaxTree)adaptor.becomeRoot(stream_INVERSE_OF.nextNode(), root_1);

                        // MOWLParser.g:87:73: ^( EXPRESSION $lhsID)
                        {
                        ManchesterOWLSyntaxTree root_2 = (ManchesterOWLSyntaxTree)adaptor.nil();
                        root_2 = (ManchesterOWLSyntaxTree)adaptor.becomeRoot((ManchesterOWLSyntaxTree)adaptor.create(EXPRESSION, "EXPRESSION"), root_2);

                        adaptor.addChild(root_2, stream_lhsID.nextTree());

                        adaptor.addChild(root_1, root_2);
                        }
                        // MOWLParser.g:87:94: ^( EXPRESSION $rhsAtomic)
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
                    // MOWLParser.g:88:3: lhsID= atomic SAME_AS rhsID= atomic
                    {
                    pushFollow(FOLLOW_atomic_in_binaryAxiom627);
                    lhsID=atomic();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_atomic.add(lhsID.getTree());
                    SAME_AS16=(Token)match(input,SAME_AS,FOLLOW_SAME_AS_in_binaryAxiom629); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_SAME_AS.add(SAME_AS16);

                    pushFollow(FOLLOW_atomic_in_binaryAxiom636);
                    rhsID=atomic();

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

                    root_0 = (ManchesterOWLSyntaxTree)adaptor.nil();
                    // 88:43: -> ^( SAME_AS_AXIOM ^( EXPRESSION $lhsID) ^( EXPRESSION $rhsID) )
                    {
                        // MOWLParser.g:88:46: ^( SAME_AS_AXIOM ^( EXPRESSION $lhsID) ^( EXPRESSION $rhsID) )
                        {
                        ManchesterOWLSyntaxTree root_1 = (ManchesterOWLSyntaxTree)adaptor.nil();
                        root_1 = (ManchesterOWLSyntaxTree)adaptor.becomeRoot((ManchesterOWLSyntaxTree)adaptor.create(SAME_AS_AXIOM, "SAME_AS_AXIOM"), root_1);

                        // MOWLParser.g:88:62: ^( EXPRESSION $lhsID)
                        {
                        ManchesterOWLSyntaxTree root_2 = (ManchesterOWLSyntaxTree)adaptor.nil();
                        root_2 = (ManchesterOWLSyntaxTree)adaptor.becomeRoot((ManchesterOWLSyntaxTree)adaptor.create(EXPRESSION, "EXPRESSION"), root_2);

                        adaptor.addChild(root_2, stream_lhsID.nextTree());

                        adaptor.addChild(root_1, root_2);
                        }
                        // MOWLParser.g:88:84: ^( EXPRESSION $rhsID)
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
                    // MOWLParser.g:89:11: lhsID= atomic DIFFERENT_FROM rhsID= atomic
                    {
                    pushFollow(FOLLOW_atomic_in_binaryAxiom674);
                    lhsID=atomic();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_atomic.add(lhsID.getTree());
                    DIFFERENT_FROM17=(Token)match(input,DIFFERENT_FROM,FOLLOW_DIFFERENT_FROM_in_binaryAxiom676); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_DIFFERENT_FROM.add(DIFFERENT_FROM17);

                    pushFollow(FOLLOW_atomic_in_binaryAxiom683);
                    rhsID=atomic();

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

                    root_0 = (ManchesterOWLSyntaxTree)adaptor.nil();
                    // 89:58: -> ^( DIFFERENT_FROM_AXIOM ^( EXPRESSION $lhsID) ^( EXPRESSION $rhsID) )
                    {
                        // MOWLParser.g:89:61: ^( DIFFERENT_FROM_AXIOM ^( EXPRESSION $lhsID) ^( EXPRESSION $rhsID) )
                        {
                        ManchesterOWLSyntaxTree root_1 = (ManchesterOWLSyntaxTree)adaptor.nil();
                        root_1 = (ManchesterOWLSyntaxTree)adaptor.becomeRoot((ManchesterOWLSyntaxTree)adaptor.create(DIFFERENT_FROM_AXIOM, "DIFFERENT_FROM_AXIOM"), root_1);

                        // MOWLParser.g:89:84: ^( EXPRESSION $lhsID)
                        {
                        ManchesterOWLSyntaxTree root_2 = (ManchesterOWLSyntaxTree)adaptor.nil();
                        root_2 = (ManchesterOWLSyntaxTree)adaptor.becomeRoot((ManchesterOWLSyntaxTree)adaptor.create(EXPRESSION, "EXPRESSION"), root_2);

                        adaptor.addChild(root_2, stream_lhsID.nextTree());

                        adaptor.addChild(root_1, root_2);
                        }
                        // MOWLParser.g:89:105: ^( EXPRESSION $rhsID)
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
                    // MOWLParser.g:90:11: lhsID= atomic DOMAIN expression
                    {
                    pushFollow(FOLLOW_atomic_in_binaryAxiom720);
                    lhsID=atomic();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_atomic.add(lhsID.getTree());
                    DOMAIN18=(Token)match(input,DOMAIN,FOLLOW_DOMAIN_in_binaryAxiom723); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_DOMAIN.add(DOMAIN18);

                    pushFollow(FOLLOW_expression_in_binaryAxiom725);
                    expression19=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_expression.add(expression19.getTree());


                    // AST REWRITE
                    // elements: lhsID, expression, DOMAIN
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
                    // 90:46: -> ^( DOMAIN ^( EXPRESSION $lhsID) ^( EXPRESSION expression ) )
                    {
                        // MOWLParser.g:90:49: ^( DOMAIN ^( EXPRESSION $lhsID) ^( EXPRESSION expression ) )
                        {
                        ManchesterOWLSyntaxTree root_1 = (ManchesterOWLSyntaxTree)adaptor.nil();
                        root_1 = (ManchesterOWLSyntaxTree)adaptor.becomeRoot(stream_DOMAIN.nextNode(), root_1);

                        // MOWLParser.g:90:58: ^( EXPRESSION $lhsID)
                        {
                        ManchesterOWLSyntaxTree root_2 = (ManchesterOWLSyntaxTree)adaptor.nil();
                        root_2 = (ManchesterOWLSyntaxTree)adaptor.becomeRoot((ManchesterOWLSyntaxTree)adaptor.create(EXPRESSION, "EXPRESSION"), root_2);

                        adaptor.addChild(root_2, stream_lhsID.nextTree());

                        adaptor.addChild(root_1, root_2);
                        }
                        // MOWLParser.g:90:79: ^( EXPRESSION expression )
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
                    // MOWLParser.g:91:11: lhsID= atomic RANGE expression
                    {
                    pushFollow(FOLLOW_atomic_in_binaryAxiom761);
                    lhsID=atomic();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_atomic.add(lhsID.getTree());
                    RANGE20=(Token)match(input,RANGE,FOLLOW_RANGE_in_binaryAxiom763); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_RANGE.add(RANGE20);

                    pushFollow(FOLLOW_expression_in_binaryAxiom765);
                    expression21=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_expression.add(expression21.getTree());


                    // AST REWRITE
                    // elements: RANGE, expression, lhsID
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
                    // 91:44: -> ^( RANGE ^( EXPRESSION $lhsID) ^( EXPRESSION expression ) )
                    {
                        // MOWLParser.g:91:47: ^( RANGE ^( EXPRESSION $lhsID) ^( EXPRESSION expression ) )
                        {
                        ManchesterOWLSyntaxTree root_1 = (ManchesterOWLSyntaxTree)adaptor.nil();
                        root_1 = (ManchesterOWLSyntaxTree)adaptor.becomeRoot(stream_RANGE.nextNode(), root_1);

                        // MOWLParser.g:91:55: ^( EXPRESSION $lhsID)
                        {
                        ManchesterOWLSyntaxTree root_2 = (ManchesterOWLSyntaxTree)adaptor.nil();
                        root_2 = (ManchesterOWLSyntaxTree)adaptor.becomeRoot((ManchesterOWLSyntaxTree)adaptor.create(EXPRESSION, "EXPRESSION"), root_2);

                        adaptor.addChild(root_2, stream_lhsID.nextTree());

                        adaptor.addChild(root_1, root_2);
                        }
                        // MOWLParser.g:91:76: ^( EXPRESSION expression )
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
    // MOWLParser.g:95:1: unaryAxiom : unaryCharacteristic unary -> ^( UNARY_AXIOM unaryCharacteristic ^( EXPRESSION unary ) ) ;
    public final ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase_MOWLParser.unaryAxiom_return unaryAxiom() throws RecognitionException {
        ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase_MOWLParser.unaryAxiom_return retval = new ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase_MOWLParser.unaryAxiom_return();
        retval.start = input.LT(1);

        ManchesterOWLSyntaxTree root_0 = null;

        ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase_MOWLParser.unaryCharacteristic_return unaryCharacteristic22 = null;

        ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase_MOWLParser.unary_return unary23 = null;


        RewriteRuleSubtreeStream stream_unaryCharacteristic=new RewriteRuleSubtreeStream(adaptor,"rule unaryCharacteristic");
        RewriteRuleSubtreeStream stream_unary=new RewriteRuleSubtreeStream(adaptor,"rule unary");
        try {
            // MOWLParser.g:95:13: ( unaryCharacteristic unary -> ^( UNARY_AXIOM unaryCharacteristic ^( EXPRESSION unary ) ) )
            // MOWLParser.g:96:4: unaryCharacteristic unary
            {
            pushFollow(FOLLOW_unaryCharacteristic_in_unaryAxiom839);
            unaryCharacteristic22=unaryCharacteristic();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_unaryCharacteristic.add(unaryCharacteristic22.getTree());
            pushFollow(FOLLOW_unary_in_unaryAxiom843);
            unary23=unary();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_unary.add(unary23.getTree());


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
            // 96:32: -> ^( UNARY_AXIOM unaryCharacteristic ^( EXPRESSION unary ) )
            {
                // MOWLParser.g:96:35: ^( UNARY_AXIOM unaryCharacteristic ^( EXPRESSION unary ) )
                {
                ManchesterOWLSyntaxTree root_1 = (ManchesterOWLSyntaxTree)adaptor.nil();
                root_1 = (ManchesterOWLSyntaxTree)adaptor.becomeRoot((ManchesterOWLSyntaxTree)adaptor.create(UNARY_AXIOM, "UNARY_AXIOM"), root_1);

                adaptor.addChild(root_1, stream_unaryCharacteristic.nextTree());
                // MOWLParser.g:96:69: ^( EXPRESSION unary )
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
    // MOWLParser.g:99:1: unaryCharacteristic : ( FUNCTIONAL -> ^( FUNCTIONAL ) | INVERSE_FUNCTIONAL -> ^( INVERSE_FUNCTIONAL ) | SYMMETRIC -> ^( SYMMETRIC ) | ANTI_SYMMETRIC -> ^( ANTI_SYMMETRIC ) | REFLEXIVE -> ^( REFLEXIVE ) | IRREFLEXIVE -> ^( IRREFLEXIVE ) | TRANSITIVE -> ^( TRANSITIVE ) );
    public final ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase_MOWLParser.unaryCharacteristic_return unaryCharacteristic() throws RecognitionException {
        ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase_MOWLParser.unaryCharacteristic_return retval = new ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase_MOWLParser.unaryCharacteristic_return();
        retval.start = input.LT(1);

        ManchesterOWLSyntaxTree root_0 = null;

        Token FUNCTIONAL24=null;
        Token INVERSE_FUNCTIONAL25=null;
        Token SYMMETRIC26=null;
        Token ANTI_SYMMETRIC27=null;
        Token REFLEXIVE28=null;
        Token IRREFLEXIVE29=null;
        Token TRANSITIVE30=null;

        ManchesterOWLSyntaxTree FUNCTIONAL24_tree=null;
        ManchesterOWLSyntaxTree INVERSE_FUNCTIONAL25_tree=null;
        ManchesterOWLSyntaxTree SYMMETRIC26_tree=null;
        ManchesterOWLSyntaxTree ANTI_SYMMETRIC27_tree=null;
        ManchesterOWLSyntaxTree REFLEXIVE28_tree=null;
        ManchesterOWLSyntaxTree IRREFLEXIVE29_tree=null;
        ManchesterOWLSyntaxTree TRANSITIVE30_tree=null;
        RewriteRuleTokenStream stream_ANTI_SYMMETRIC=new RewriteRuleTokenStream(adaptor,"token ANTI_SYMMETRIC");
        RewriteRuleTokenStream stream_SYMMETRIC=new RewriteRuleTokenStream(adaptor,"token SYMMETRIC");
        RewriteRuleTokenStream stream_TRANSITIVE=new RewriteRuleTokenStream(adaptor,"token TRANSITIVE");
        RewriteRuleTokenStream stream_REFLEXIVE=new RewriteRuleTokenStream(adaptor,"token REFLEXIVE");
        RewriteRuleTokenStream stream_INVERSE_FUNCTIONAL=new RewriteRuleTokenStream(adaptor,"token INVERSE_FUNCTIONAL");
        RewriteRuleTokenStream stream_IRREFLEXIVE=new RewriteRuleTokenStream(adaptor,"token IRREFLEXIVE");
        RewriteRuleTokenStream stream_FUNCTIONAL=new RewriteRuleTokenStream(adaptor,"token FUNCTIONAL");

        try {
            // MOWLParser.g:99:21: ( FUNCTIONAL -> ^( FUNCTIONAL ) | INVERSE_FUNCTIONAL -> ^( INVERSE_FUNCTIONAL ) | SYMMETRIC -> ^( SYMMETRIC ) | ANTI_SYMMETRIC -> ^( ANTI_SYMMETRIC ) | REFLEXIVE -> ^( REFLEXIVE ) | IRREFLEXIVE -> ^( IRREFLEXIVE ) | TRANSITIVE -> ^( TRANSITIVE ) )
            int alt5=7;
            switch ( input.LA(1) ) {
            case FUNCTIONAL:
                {
                alt5=1;
                }
                break;
            case INVERSE_FUNCTIONAL:
                {
                alt5=2;
                }
                break;
            case SYMMETRIC:
                {
                alt5=3;
                }
                break;
            case ANTI_SYMMETRIC:
                {
                alt5=4;
                }
                break;
            case REFLEXIVE:
                {
                alt5=5;
                }
                break;
            case IRREFLEXIVE:
                {
                alt5=6;
                }
                break;
            case TRANSITIVE:
                {
                alt5=7;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }

            switch (alt5) {
                case 1 :
                    // MOWLParser.g:100:5: FUNCTIONAL
                    {
                    FUNCTIONAL24=(Token)match(input,FUNCTIONAL,FOLLOW_FUNCTIONAL_in_unaryCharacteristic888); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_FUNCTIONAL.add(FUNCTIONAL24);



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
                    // 100:16: -> ^( FUNCTIONAL )
                    {
                        // MOWLParser.g:100:19: ^( FUNCTIONAL )
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
                    // MOWLParser.g:101:7: INVERSE_FUNCTIONAL
                    {
                    INVERSE_FUNCTIONAL25=(Token)match(input,INVERSE_FUNCTIONAL,FOLLOW_INVERSE_FUNCTIONAL_in_unaryCharacteristic902); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_INVERSE_FUNCTIONAL.add(INVERSE_FUNCTIONAL25);



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
                    // 101:26: -> ^( INVERSE_FUNCTIONAL )
                    {
                        // MOWLParser.g:101:29: ^( INVERSE_FUNCTIONAL )
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
                    // MOWLParser.g:102:7: SYMMETRIC
                    {
                    SYMMETRIC26=(Token)match(input,SYMMETRIC,FOLLOW_SYMMETRIC_in_unaryCharacteristic916); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_SYMMETRIC.add(SYMMETRIC26);



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
                    // 102:17: -> ^( SYMMETRIC )
                    {
                        // MOWLParser.g:102:20: ^( SYMMETRIC )
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
                    // MOWLParser.g:103:7: ANTI_SYMMETRIC
                    {
                    ANTI_SYMMETRIC27=(Token)match(input,ANTI_SYMMETRIC,FOLLOW_ANTI_SYMMETRIC_in_unaryCharacteristic930); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_ANTI_SYMMETRIC.add(ANTI_SYMMETRIC27);



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
                    // 103:22: -> ^( ANTI_SYMMETRIC )
                    {
                        // MOWLParser.g:103:25: ^( ANTI_SYMMETRIC )
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
                    // MOWLParser.g:104:7: REFLEXIVE
                    {
                    REFLEXIVE28=(Token)match(input,REFLEXIVE,FOLLOW_REFLEXIVE_in_unaryCharacteristic944); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_REFLEXIVE.add(REFLEXIVE28);



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
                    // 104:17: -> ^( REFLEXIVE )
                    {
                        // MOWLParser.g:104:20: ^( REFLEXIVE )
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
                    // MOWLParser.g:105:7: IRREFLEXIVE
                    {
                    IRREFLEXIVE29=(Token)match(input,IRREFLEXIVE,FOLLOW_IRREFLEXIVE_in_unaryCharacteristic958); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_IRREFLEXIVE.add(IRREFLEXIVE29);



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
                    // 105:19: -> ^( IRREFLEXIVE )
                    {
                        // MOWLParser.g:105:22: ^( IRREFLEXIVE )
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
                    // MOWLParser.g:106:7: TRANSITIVE
                    {
                    TRANSITIVE30=(Token)match(input,TRANSITIVE,FOLLOW_TRANSITIVE_in_unaryCharacteristic972); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_TRANSITIVE.add(TRANSITIVE30);



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
                    // 106:18: -> ^( TRANSITIVE )
                    {
                        // MOWLParser.g:106:21: ^( TRANSITIVE )
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
    // MOWLParser.g:109:1: expression : ( options {backtrack=true; } : conjunction ( OR conjunction )* -> ^( DISJUNCTION ( conjunction )+ ) | complexPropertyExpression -> ^( complexPropertyExpression ) | OPEN_PARENTHESYS expression CLOSED_PARENTHESYS -> ^( expression ) ) ;
    public final ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase_MOWLParser.expression_return expression() throws RecognitionException {
        ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase_MOWLParser.expression_return retval = new ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase_MOWLParser.expression_return();
        retval.start = input.LT(1);

        ManchesterOWLSyntaxTree root_0 = null;

        Token OR32=null;
        Token OPEN_PARENTHESYS35=null;
        Token CLOSED_PARENTHESYS37=null;
        ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase_MOWLParser.conjunction_return conjunction31 = null;

        ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase_MOWLParser.conjunction_return conjunction33 = null;

        ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase_MOWLParser.complexPropertyExpression_return complexPropertyExpression34 = null;

        ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase_MOWLParser.expression_return expression36 = null;


        ManchesterOWLSyntaxTree OR32_tree=null;
        ManchesterOWLSyntaxTree OPEN_PARENTHESYS35_tree=null;
        ManchesterOWLSyntaxTree CLOSED_PARENTHESYS37_tree=null;
        RewriteRuleTokenStream stream_CLOSED_PARENTHESYS=new RewriteRuleTokenStream(adaptor,"token CLOSED_PARENTHESYS");
        RewriteRuleTokenStream stream_OPEN_PARENTHESYS=new RewriteRuleTokenStream(adaptor,"token OPEN_PARENTHESYS");
        RewriteRuleTokenStream stream_OR=new RewriteRuleTokenStream(adaptor,"token OR");
        RewriteRuleSubtreeStream stream_conjunction=new RewriteRuleSubtreeStream(adaptor,"rule conjunction");
        RewriteRuleSubtreeStream stream_complexPropertyExpression=new RewriteRuleSubtreeStream(adaptor,"rule complexPropertyExpression");
        RewriteRuleSubtreeStream stream_expression=new RewriteRuleSubtreeStream(adaptor,"rule expression");
        try {
            // MOWLParser.g:109:11: ( ( options {backtrack=true; } : conjunction ( OR conjunction )* -> ^( DISJUNCTION ( conjunction )+ ) | complexPropertyExpression -> ^( complexPropertyExpression ) | OPEN_PARENTHESYS expression CLOSED_PARENTHESYS -> ^( expression ) ) )
            // MOWLParser.g:110:5: ( options {backtrack=true; } : conjunction ( OR conjunction )* -> ^( DISJUNCTION ( conjunction )+ ) | complexPropertyExpression -> ^( complexPropertyExpression ) | OPEN_PARENTHESYS expression CLOSED_PARENTHESYS -> ^( expression ) )
            {
            // MOWLParser.g:110:5: ( options {backtrack=true; } : conjunction ( OR conjunction )* -> ^( DISJUNCTION ( conjunction )+ ) | complexPropertyExpression -> ^( complexPropertyExpression ) | OPEN_PARENTHESYS expression CLOSED_PARENTHESYS -> ^( expression ) )
            int alt7=3;
            switch ( input.LA(1) ) {
            case OPEN_CURLY_BRACES:
            case NOT:
            case DBLQUOTE:
            case IDENTIFIER:
            case ENTITY_REFERENCE:
                {
                alt7=1;
                }
                break;
            case INVERSE:
                {
                int LA7_3 = input.LA(2);

                if ( (synpred13_MOWLParser()) ) {
                    alt7=1;
                }
                else if ( (synpred14_MOWLParser()) ) {
                    alt7=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 7, 3, input);

                    throw nvae;
                }
                }
                break;
            case OPEN_PARENTHESYS:
                {
                alt7=3;
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
                    // MOWLParser.g:112:5: conjunction ( OR conjunction )*
                    {
                    pushFollow(FOLLOW_conjunction_in_expression1014);
                    conjunction31=conjunction();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_conjunction.add(conjunction31.getTree());
                    // MOWLParser.g:112:17: ( OR conjunction )*
                    loop6:
                    do {
                        int alt6=2;
                        int LA6_0 = input.LA(1);

                        if ( (LA6_0==OR) ) {
                            alt6=1;
                        }


                        switch (alt6) {
                    	case 1 :
                    	    // MOWLParser.g:112:18: OR conjunction
                    	    {
                    	    OR32=(Token)match(input,OR,FOLLOW_OR_in_expression1017); if (state.failed) return retval; 
                    	    if ( state.backtracking==0 ) stream_OR.add(OR32);

                    	    pushFollow(FOLLOW_conjunction_in_expression1019);
                    	    conjunction33=conjunction();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) stream_conjunction.add(conjunction33.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop6;
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
                    // 112:35: -> ^( DISJUNCTION ( conjunction )+ )
                    {
                        // MOWLParser.g:112:38: ^( DISJUNCTION ( conjunction )+ )
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
                    // MOWLParser.g:113:6: complexPropertyExpression
                    {
                    pushFollow(FOLLOW_complexPropertyExpression_in_expression1038);
                    complexPropertyExpression34=complexPropertyExpression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_complexPropertyExpression.add(complexPropertyExpression34.getTree());


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
                    // 113:32: -> ^( complexPropertyExpression )
                    {
                        // MOWLParser.g:113:35: ^( complexPropertyExpression )
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
                    // MOWLParser.g:114:6: OPEN_PARENTHESYS expression CLOSED_PARENTHESYS
                    {
                    OPEN_PARENTHESYS35=(Token)match(input,OPEN_PARENTHESYS,FOLLOW_OPEN_PARENTHESYS_in_expression1051); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_OPEN_PARENTHESYS.add(OPEN_PARENTHESYS35);

                    pushFollow(FOLLOW_expression_in_expression1053);
                    expression36=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_expression.add(expression36.getTree());
                    CLOSED_PARENTHESYS37=(Token)match(input,CLOSED_PARENTHESYS,FOLLOW_CLOSED_PARENTHESYS_in_expression1055); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_CLOSED_PARENTHESYS.add(CLOSED_PARENTHESYS37);



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
                    // 114:53: -> ^( expression )
                    {
                        // MOWLParser.g:114:56: ^( expression )
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
    // MOWLParser.g:122:1: conjunction : unary ( AND unary )* -> ^( CONJUNCTION ( unary )+ ) ;
    public final ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase_MOWLParser.conjunction_return conjunction() throws RecognitionException {
        ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase_MOWLParser.conjunction_return retval = new ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase_MOWLParser.conjunction_return();
        retval.start = input.LT(1);

        ManchesterOWLSyntaxTree root_0 = null;

        Token AND39=null;
        ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase_MOWLParser.unary_return unary38 = null;

        ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase_MOWLParser.unary_return unary40 = null;


        ManchesterOWLSyntaxTree AND39_tree=null;
        RewriteRuleTokenStream stream_AND=new RewriteRuleTokenStream(adaptor,"token AND");
        RewriteRuleSubtreeStream stream_unary=new RewriteRuleSubtreeStream(adaptor,"rule unary");
        try {
            // MOWLParser.g:122:13: ( unary ( AND unary )* -> ^( CONJUNCTION ( unary )+ ) )
            // MOWLParser.g:123:5: unary ( AND unary )*
            {
            pushFollow(FOLLOW_unary_in_conjunction1088);
            unary38=unary();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_unary.add(unary38.getTree());
            // MOWLParser.g:123:11: ( AND unary )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==AND) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // MOWLParser.g:123:12: AND unary
            	    {
            	    AND39=(Token)match(input,AND,FOLLOW_AND_in_conjunction1091); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_AND.add(AND39);

            	    pushFollow(FOLLOW_unary_in_conjunction1093);
            	    unary40=unary();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_unary.add(unary40.getTree());

            	    }
            	    break;

            	default :
            	    break loop8;
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
            // 123:24: -> ^( CONJUNCTION ( unary )+ )
            {
                // MOWLParser.g:123:27: ^( CONJUNCTION ( unary )+ )
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
    // MOWLParser.g:126:1: complexPropertyExpression : ( INVERSE OPEN_PARENTHESYS complexPropertyExpression CLOSED_PARENTHESYS -> ^( INVERSE_OBJECT_PROPERTY_EXPRESSION complexPropertyExpression ) | INVERSE OPEN_PARENTHESYS atomic CLOSED_PARENTHESYS -> ^( INVERSE_OBJECT_PROPERTY_EXPRESSION atomic ) );
    public final ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase_MOWLParser.complexPropertyExpression_return complexPropertyExpression() throws RecognitionException {
        ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase_MOWLParser.complexPropertyExpression_return retval = new ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase_MOWLParser.complexPropertyExpression_return();
        retval.start = input.LT(1);

        ManchesterOWLSyntaxTree root_0 = null;

        Token INVERSE41=null;
        Token OPEN_PARENTHESYS42=null;
        Token CLOSED_PARENTHESYS44=null;
        Token INVERSE45=null;
        Token OPEN_PARENTHESYS46=null;
        Token CLOSED_PARENTHESYS48=null;
        ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase_MOWLParser.complexPropertyExpression_return complexPropertyExpression43 = null;

        ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase_MOWLParser.atomic_return atomic47 = null;


        ManchesterOWLSyntaxTree INVERSE41_tree=null;
        ManchesterOWLSyntaxTree OPEN_PARENTHESYS42_tree=null;
        ManchesterOWLSyntaxTree CLOSED_PARENTHESYS44_tree=null;
        ManchesterOWLSyntaxTree INVERSE45_tree=null;
        ManchesterOWLSyntaxTree OPEN_PARENTHESYS46_tree=null;
        ManchesterOWLSyntaxTree CLOSED_PARENTHESYS48_tree=null;
        RewriteRuleTokenStream stream_INVERSE=new RewriteRuleTokenStream(adaptor,"token INVERSE");
        RewriteRuleTokenStream stream_CLOSED_PARENTHESYS=new RewriteRuleTokenStream(adaptor,"token CLOSED_PARENTHESYS");
        RewriteRuleTokenStream stream_OPEN_PARENTHESYS=new RewriteRuleTokenStream(adaptor,"token OPEN_PARENTHESYS");
        RewriteRuleSubtreeStream stream_complexPropertyExpression=new RewriteRuleSubtreeStream(adaptor,"rule complexPropertyExpression");
        RewriteRuleSubtreeStream stream_atomic=new RewriteRuleSubtreeStream(adaptor,"rule atomic");
        try {
            // MOWLParser.g:126:26: ( INVERSE OPEN_PARENTHESYS complexPropertyExpression CLOSED_PARENTHESYS -> ^( INVERSE_OBJECT_PROPERTY_EXPRESSION complexPropertyExpression ) | INVERSE OPEN_PARENTHESYS atomic CLOSED_PARENTHESYS -> ^( INVERSE_OBJECT_PROPERTY_EXPRESSION atomic ) )
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==INVERSE) ) {
                int LA9_1 = input.LA(2);

                if ( (LA9_1==OPEN_PARENTHESYS) ) {
                    int LA9_2 = input.LA(3);

                    if ( ((LA9_2>=IDENTIFIER && LA9_2<=ENTITY_REFERENCE)) ) {
                        alt9=2;
                    }
                    else if ( (LA9_2==INVERSE) ) {
                        alt9=1;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 9, 2, input);

                        throw nvae;
                    }
                }
                else {
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
                    // MOWLParser.g:127:2: INVERSE OPEN_PARENTHESYS complexPropertyExpression CLOSED_PARENTHESYS
                    {
                    INVERSE41=(Token)match(input,INVERSE,FOLLOW_INVERSE_in_complexPropertyExpression1114); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_INVERSE.add(INVERSE41);

                    OPEN_PARENTHESYS42=(Token)match(input,OPEN_PARENTHESYS,FOLLOW_OPEN_PARENTHESYS_in_complexPropertyExpression1116); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_OPEN_PARENTHESYS.add(OPEN_PARENTHESYS42);

                    pushFollow(FOLLOW_complexPropertyExpression_in_complexPropertyExpression1118);
                    complexPropertyExpression43=complexPropertyExpression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_complexPropertyExpression.add(complexPropertyExpression43.getTree());
                    CLOSED_PARENTHESYS44=(Token)match(input,CLOSED_PARENTHESYS,FOLLOW_CLOSED_PARENTHESYS_in_complexPropertyExpression1120); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_CLOSED_PARENTHESYS.add(CLOSED_PARENTHESYS44);



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
                    // 127:72: -> ^( INVERSE_OBJECT_PROPERTY_EXPRESSION complexPropertyExpression )
                    {
                        // MOWLParser.g:127:75: ^( INVERSE_OBJECT_PROPERTY_EXPRESSION complexPropertyExpression )
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
                    // MOWLParser.g:128:4: INVERSE OPEN_PARENTHESYS atomic CLOSED_PARENTHESYS
                    {
                    INVERSE45=(Token)match(input,INVERSE,FOLLOW_INVERSE_in_complexPropertyExpression1133); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_INVERSE.add(INVERSE45);

                    OPEN_PARENTHESYS46=(Token)match(input,OPEN_PARENTHESYS,FOLLOW_OPEN_PARENTHESYS_in_complexPropertyExpression1135); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_OPEN_PARENTHESYS.add(OPEN_PARENTHESYS46);

                    pushFollow(FOLLOW_atomic_in_complexPropertyExpression1137);
                    atomic47=atomic();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_atomic.add(atomic47.getTree());
                    CLOSED_PARENTHESYS48=(Token)match(input,CLOSED_PARENTHESYS,FOLLOW_CLOSED_PARENTHESYS_in_complexPropertyExpression1139); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_CLOSED_PARENTHESYS.add(CLOSED_PARENTHESYS48);



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
                    // 128:54: -> ^( INVERSE_OBJECT_PROPERTY_EXPRESSION atomic )
                    {
                        // MOWLParser.g:128:57: ^( INVERSE_OBJECT_PROPERTY_EXPRESSION atomic )
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
    // MOWLParser.g:131:1: unary options {backtrack=true; } : (head= propertyExpression ( COMPOSITION rest+= propertyExpression )+ -> ^( PROPERTY_CHAIN $head $rest) | NOT OPEN_PARENTHESYS expression CLOSED_PARENTHESYS -> ^( NEGATED_EXPRESSION expression ) | NOT atomic -> ^( NEGATED_EXPRESSION atomic ) | qualifiedRestriction -> ^( qualifiedRestriction ) | constant | atomic );
    public final ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase_MOWLParser.unary_return unary() throws RecognitionException {
        ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase_MOWLParser.unary_return retval = new ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase_MOWLParser.unary_return();
        retval.start = input.LT(1);

        ManchesterOWLSyntaxTree root_0 = null;

        Token COMPOSITION49=null;
        Token NOT50=null;
        Token OPEN_PARENTHESYS51=null;
        Token CLOSED_PARENTHESYS53=null;
        Token NOT54=null;
        List list_rest=null;
        ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase_MOWLParser.propertyExpression_return head = null;

        ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase_MOWLParser.expression_return expression52 = null;

        ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase_MOWLParser.atomic_return atomic55 = null;

        ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase_MOWLParser.qualifiedRestriction_return qualifiedRestriction56 = null;

        ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase_MOWLParser.constant_return constant57 = null;

        ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase_MOWLParser.atomic_return atomic58 = null;

        RuleReturnScope rest = null;
        ManchesterOWLSyntaxTree COMPOSITION49_tree=null;
        ManchesterOWLSyntaxTree NOT50_tree=null;
        ManchesterOWLSyntaxTree OPEN_PARENTHESYS51_tree=null;
        ManchesterOWLSyntaxTree CLOSED_PARENTHESYS53_tree=null;
        ManchesterOWLSyntaxTree NOT54_tree=null;
        RewriteRuleTokenStream stream_NOT=new RewriteRuleTokenStream(adaptor,"token NOT");
        RewriteRuleTokenStream stream_CLOSED_PARENTHESYS=new RewriteRuleTokenStream(adaptor,"token CLOSED_PARENTHESYS");
        RewriteRuleTokenStream stream_COMPOSITION=new RewriteRuleTokenStream(adaptor,"token COMPOSITION");
        RewriteRuleTokenStream stream_OPEN_PARENTHESYS=new RewriteRuleTokenStream(adaptor,"token OPEN_PARENTHESYS");
        RewriteRuleSubtreeStream stream_propertyExpression=new RewriteRuleSubtreeStream(adaptor,"rule propertyExpression");
        RewriteRuleSubtreeStream stream_qualifiedRestriction=new RewriteRuleSubtreeStream(adaptor,"rule qualifiedRestriction");
        RewriteRuleSubtreeStream stream_atomic=new RewriteRuleSubtreeStream(adaptor,"rule atomic");
        RewriteRuleSubtreeStream stream_expression=new RewriteRuleSubtreeStream(adaptor,"rule expression");
        try {
            // MOWLParser.g:131:34: (head= propertyExpression ( COMPOSITION rest+= propertyExpression )+ -> ^( PROPERTY_CHAIN $head $rest) | NOT OPEN_PARENTHESYS expression CLOSED_PARENTHESYS -> ^( NEGATED_EXPRESSION expression ) | NOT atomic -> ^( NEGATED_EXPRESSION atomic ) | qualifiedRestriction -> ^( qualifiedRestriction ) | constant | atomic )
            int alt11=6;
            alt11 = dfa11.predict(input);
            switch (alt11) {
                case 1 :
                    // MOWLParser.g:133:4: head= propertyExpression ( COMPOSITION rest+= propertyExpression )+
                    {
                    pushFollow(FOLLOW_propertyExpression_in_unary1176);
                    head=propertyExpression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_propertyExpression.add(head.getTree());
                    // MOWLParser.g:133:30: ( COMPOSITION rest+= propertyExpression )+
                    int cnt10=0;
                    loop10:
                    do {
                        int alt10=2;
                        int LA10_0 = input.LA(1);

                        if ( (LA10_0==COMPOSITION) ) {
                            alt10=1;
                        }


                        switch (alt10) {
                    	case 1 :
                    	    // MOWLParser.g:133:31: COMPOSITION rest+= propertyExpression
                    	    {
                    	    COMPOSITION49=(Token)match(input,COMPOSITION,FOLLOW_COMPOSITION_in_unary1179); if (state.failed) return retval; 
                    	    if ( state.backtracking==0 ) stream_COMPOSITION.add(COMPOSITION49);

                    	    pushFollow(FOLLOW_propertyExpression_in_unary1183);
                    	    rest=propertyExpression();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) stream_propertyExpression.add(rest.getTree());
                    	    if (list_rest==null) list_rest=new ArrayList();
                    	    list_rest.add(rest.getTree());


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt10 >= 1 ) break loop10;
                    	    if (state.backtracking>0) {state.failed=true; return retval;}
                                EarlyExitException eee =
                                    new EarlyExitException(10, input);
                                throw eee;
                        }
                        cnt10++;
                    } while (true);



                    // AST REWRITE
                    // elements: rest, head
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
                    root_0 = (ManchesterOWLSyntaxTree)adaptor.nil();
                    // 133:71: -> ^( PROPERTY_CHAIN $head $rest)
                    {
                        // MOWLParser.g:133:74: ^( PROPERTY_CHAIN $head $rest)
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
                    // MOWLParser.g:134:5: NOT OPEN_PARENTHESYS expression CLOSED_PARENTHESYS
                    {
                    NOT50=(Token)match(input,NOT,FOLLOW_NOT_in_unary1205); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_NOT.add(NOT50);

                    OPEN_PARENTHESYS51=(Token)match(input,OPEN_PARENTHESYS,FOLLOW_OPEN_PARENTHESYS_in_unary1207); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_OPEN_PARENTHESYS.add(OPEN_PARENTHESYS51);

                    pushFollow(FOLLOW_expression_in_unary1209);
                    expression52=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_expression.add(expression52.getTree());
                    CLOSED_PARENTHESYS53=(Token)match(input,CLOSED_PARENTHESYS,FOLLOW_CLOSED_PARENTHESYS_in_unary1211); if (state.failed) return retval; 
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

                    root_0 = (ManchesterOWLSyntaxTree)adaptor.nil();
                    // 134:56: -> ^( NEGATED_EXPRESSION expression )
                    {
                        // MOWLParser.g:134:59: ^( NEGATED_EXPRESSION expression )
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
                    // MOWLParser.g:135:5: NOT atomic
                    {
                    NOT54=(Token)match(input,NOT,FOLLOW_NOT_in_unary1225); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_NOT.add(NOT54);

                    pushFollow(FOLLOW_atomic_in_unary1227);
                    atomic55=atomic();

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

                    root_0 = (ManchesterOWLSyntaxTree)adaptor.nil();
                    // 135:16: -> ^( NEGATED_EXPRESSION atomic )
                    {
                        // MOWLParser.g:135:19: ^( NEGATED_EXPRESSION atomic )
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
                    // MOWLParser.g:136:5: qualifiedRestriction
                    {
                    pushFollow(FOLLOW_qualifiedRestriction_in_unary1250);
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

                    root_0 = (ManchesterOWLSyntaxTree)adaptor.nil();
                    // 136:26: -> ^( qualifiedRestriction )
                    {
                        // MOWLParser.g:136:29: ^( qualifiedRestriction )
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
                    // MOWLParser.g:137:5: constant
                    {
                    root_0 = (ManchesterOWLSyntaxTree)adaptor.nil();

                    pushFollow(FOLLOW_constant_in_unary1262);
                    constant57=constant();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, constant57.getTree());

                    }
                    break;
                case 6 :
                    // MOWLParser.g:138:5: atomic
                    {
                    root_0 = (ManchesterOWLSyntaxTree)adaptor.nil();

                    pushFollow(FOLLOW_atomic_in_unary1268);
                    atomic58=atomic();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, atomic58.getTree());

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

    public static class atomic_return extends ParserRuleReturnScope {
        ManchesterOWLSyntaxTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "atomic"
    // MOWLParser.g:141:1: atomic : ( IDENTIFIER | ENTITY_REFERENCE -> ^( ENTITY_REFERENCE ) );
    public final ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase_MOWLParser.atomic_return atomic() throws RecognitionException {
        ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase_MOWLParser.atomic_return retval = new ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase_MOWLParser.atomic_return();
        retval.start = input.LT(1);

        ManchesterOWLSyntaxTree root_0 = null;

        Token IDENTIFIER59=null;
        Token ENTITY_REFERENCE60=null;

        ManchesterOWLSyntaxTree IDENTIFIER59_tree=null;
        ManchesterOWLSyntaxTree ENTITY_REFERENCE60_tree=null;
        RewriteRuleTokenStream stream_ENTITY_REFERENCE=new RewriteRuleTokenStream(adaptor,"token ENTITY_REFERENCE");

        try {
            // MOWLParser.g:141:8: ( IDENTIFIER | ENTITY_REFERENCE -> ^( ENTITY_REFERENCE ) )
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==IDENTIFIER) ) {
                alt12=1;
            }
            else if ( (LA12_0==ENTITY_REFERENCE) ) {
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
                    // MOWLParser.g:142:3: IDENTIFIER
                    {
                    root_0 = (ManchesterOWLSyntaxTree)adaptor.nil();

                    IDENTIFIER59=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_atomic1282); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDENTIFIER59_tree = (ManchesterOWLSyntaxTree)adaptor.create(IDENTIFIER59);
                    adaptor.addChild(root_0, IDENTIFIER59_tree);
                    }

                    }
                    break;
                case 2 :
                    // MOWLParser.g:143:5: ENTITY_REFERENCE
                    {
                    ENTITY_REFERENCE60=(Token)match(input,ENTITY_REFERENCE,FOLLOW_ENTITY_REFERENCE_in_atomic1289); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_ENTITY_REFERENCE.add(ENTITY_REFERENCE60);



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
                    // 143:22: -> ^( ENTITY_REFERENCE )
                    {
                        // MOWLParser.g:143:25: ^( ENTITY_REFERENCE )
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
    // MOWLParser.g:146:1: qualifiedRestriction : ( options {backtrack=true; } : propertyExpression SOME expression -> ^( SOME_RESTRICTION propertyExpression expression ) | propertyExpression ONLY expression -> ^( ALL_RESTRICTION propertyExpression expression ) | cardinalityRestriction -> ^( cardinalityRestriction ) | oneOf -> ^( oneOf ) | valueRestriction -> ^( valueRestriction ) ) ;
    public final ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase_MOWLParser.qualifiedRestriction_return qualifiedRestriction() throws RecognitionException {
        ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase_MOWLParser.qualifiedRestriction_return retval = new ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase_MOWLParser.qualifiedRestriction_return();
        retval.start = input.LT(1);

        ManchesterOWLSyntaxTree root_0 = null;

        Token SOME62=null;
        Token ONLY65=null;
        ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase_MOWLParser.propertyExpression_return propertyExpression61 = null;

        ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase_MOWLParser.expression_return expression63 = null;

        ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase_MOWLParser.propertyExpression_return propertyExpression64 = null;

        ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase_MOWLParser.expression_return expression66 = null;

        ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase_MOWLParser.cardinalityRestriction_return cardinalityRestriction67 = null;

        ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase_MOWLParser.oneOf_return oneOf68 = null;

        ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase_MOWLParser.valueRestriction_return valueRestriction69 = null;


        ManchesterOWLSyntaxTree SOME62_tree=null;
        ManchesterOWLSyntaxTree ONLY65_tree=null;
        RewriteRuleTokenStream stream_SOME=new RewriteRuleTokenStream(adaptor,"token SOME");
        RewriteRuleTokenStream stream_ONLY=new RewriteRuleTokenStream(adaptor,"token ONLY");
        RewriteRuleSubtreeStream stream_cardinalityRestriction=new RewriteRuleSubtreeStream(adaptor,"rule cardinalityRestriction");
        RewriteRuleSubtreeStream stream_propertyExpression=new RewriteRuleSubtreeStream(adaptor,"rule propertyExpression");
        RewriteRuleSubtreeStream stream_oneOf=new RewriteRuleSubtreeStream(adaptor,"rule oneOf");
        RewriteRuleSubtreeStream stream_expression=new RewriteRuleSubtreeStream(adaptor,"rule expression");
        RewriteRuleSubtreeStream stream_valueRestriction=new RewriteRuleSubtreeStream(adaptor,"rule valueRestriction");
        try {
            // MOWLParser.g:146:21: ( ( options {backtrack=true; } : propertyExpression SOME expression -> ^( SOME_RESTRICTION propertyExpression expression ) | propertyExpression ONLY expression -> ^( ALL_RESTRICTION propertyExpression expression ) | cardinalityRestriction -> ^( cardinalityRestriction ) | oneOf -> ^( oneOf ) | valueRestriction -> ^( valueRestriction ) ) )
            // MOWLParser.g:147:9: ( options {backtrack=true; } : propertyExpression SOME expression -> ^( SOME_RESTRICTION propertyExpression expression ) | propertyExpression ONLY expression -> ^( ALL_RESTRICTION propertyExpression expression ) | cardinalityRestriction -> ^( cardinalityRestriction ) | oneOf -> ^( oneOf ) | valueRestriction -> ^( valueRestriction ) )
            {
            // MOWLParser.g:147:9: ( options {backtrack=true; } : propertyExpression SOME expression -> ^( SOME_RESTRICTION propertyExpression expression ) | propertyExpression ONLY expression -> ^( ALL_RESTRICTION propertyExpression expression ) | cardinalityRestriction -> ^( cardinalityRestriction ) | oneOf -> ^( oneOf ) | valueRestriction -> ^( valueRestriction ) )
            int alt13=5;
            switch ( input.LA(1) ) {
            case IDENTIFIER:
                {
                int LA13_1 = input.LA(2);

                if ( (synpred20_MOWLParser()) ) {
                    alt13=1;
                }
                else if ( (synpred21_MOWLParser()) ) {
                    alt13=2;
                }
                else if ( (synpred22_MOWLParser()) ) {
                    alt13=3;
                }
                else if ( (true) ) {
                    alt13=5;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 13, 1, input);

                    throw nvae;
                }
                }
                break;
            case ENTITY_REFERENCE:
                {
                int LA13_2 = input.LA(2);

                if ( (synpred20_MOWLParser()) ) {
                    alt13=1;
                }
                else if ( (synpred21_MOWLParser()) ) {
                    alt13=2;
                }
                else if ( (synpred22_MOWLParser()) ) {
                    alt13=3;
                }
                else if ( (true) ) {
                    alt13=5;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 13, 2, input);

                    throw nvae;
                }
                }
                break;
            case INVERSE:
                {
                int LA13_3 = input.LA(2);

                if ( (synpred20_MOWLParser()) ) {
                    alt13=1;
                }
                else if ( (synpred21_MOWLParser()) ) {
                    alt13=2;
                }
                else if ( (synpred22_MOWLParser()) ) {
                    alt13=3;
                }
                else if ( (true) ) {
                    alt13=5;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 13, 3, input);

                    throw nvae;
                }
                }
                break;
            case OPEN_CURLY_BRACES:
                {
                alt13=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;
            }

            switch (alt13) {
                case 1 :
                    // MOWLParser.g:149:7: propertyExpression SOME expression
                    {
                    pushFollow(FOLLOW_propertyExpression_in_qualifiedRestriction1341);
                    propertyExpression61=propertyExpression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_propertyExpression.add(propertyExpression61.getTree());
                    SOME62=(Token)match(input,SOME,FOLLOW_SOME_in_qualifiedRestriction1344); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_SOME.add(SOME62);

                    pushFollow(FOLLOW_expression_in_qualifiedRestriction1348);
                    expression63=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_expression.add(expression63.getTree());


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

                    root_0 = (ManchesterOWLSyntaxTree)adaptor.nil();
                    // 149:46: -> ^( SOME_RESTRICTION propertyExpression expression )
                    {
                        // MOWLParser.g:149:49: ^( SOME_RESTRICTION propertyExpression expression )
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
                    // MOWLParser.g:150:7: propertyExpression ONLY expression
                    {
                    pushFollow(FOLLOW_propertyExpression_in_qualifiedRestriction1377);
                    propertyExpression64=propertyExpression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_propertyExpression.add(propertyExpression64.getTree());
                    ONLY65=(Token)match(input,ONLY,FOLLOW_ONLY_in_qualifiedRestriction1379); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_ONLY.add(ONLY65);

                    pushFollow(FOLLOW_expression_in_qualifiedRestriction1382);
                    expression66=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_expression.add(expression66.getTree());


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

                    root_0 = (ManchesterOWLSyntaxTree)adaptor.nil();
                    // 150:44: -> ^( ALL_RESTRICTION propertyExpression expression )
                    {
                        // MOWLParser.g:150:47: ^( ALL_RESTRICTION propertyExpression expression )
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
                    // MOWLParser.g:151:7: cardinalityRestriction
                    {
                    pushFollow(FOLLOW_cardinalityRestriction_in_qualifiedRestriction1401);
                    cardinalityRestriction67=cardinalityRestriction();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_cardinalityRestriction.add(cardinalityRestriction67.getTree());


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
                    // 151:30: -> ^( cardinalityRestriction )
                    {
                        // MOWLParser.g:151:33: ^( cardinalityRestriction )
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
                    // MOWLParser.g:152:7: oneOf
                    {
                    pushFollow(FOLLOW_oneOf_in_qualifiedRestriction1415);
                    oneOf68=oneOf();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_oneOf.add(oneOf68.getTree());


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
                    // 152:13: -> ^( oneOf )
                    {
                        // MOWLParser.g:152:16: ^( oneOf )
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
                    // MOWLParser.g:153:7: valueRestriction
                    {
                    pushFollow(FOLLOW_valueRestriction_in_qualifiedRestriction1429);
                    valueRestriction69=valueRestriction();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_valueRestriction.add(valueRestriction69.getTree());


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
                    // 153:24: -> ^( valueRestriction )
                    {
                        // MOWLParser.g:153:27: ^( valueRestriction )
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
    // MOWLParser.g:157:1: propertyExpression : ( atomic -> ^( atomic ) | complexPropertyExpression -> ^( complexPropertyExpression ) );
    public final ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase_MOWLParser.propertyExpression_return propertyExpression() throws RecognitionException {
        ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase_MOWLParser.propertyExpression_return retval = new ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase_MOWLParser.propertyExpression_return();
        retval.start = input.LT(1);

        ManchesterOWLSyntaxTree root_0 = null;

        ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase_MOWLParser.atomic_return atomic70 = null;

        ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase_MOWLParser.complexPropertyExpression_return complexPropertyExpression71 = null;


        RewriteRuleSubtreeStream stream_complexPropertyExpression=new RewriteRuleSubtreeStream(adaptor,"rule complexPropertyExpression");
        RewriteRuleSubtreeStream stream_atomic=new RewriteRuleSubtreeStream(adaptor,"rule atomic");
        try {
            // MOWLParser.g:157:21: ( atomic -> ^( atomic ) | complexPropertyExpression -> ^( complexPropertyExpression ) )
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( ((LA14_0>=IDENTIFIER && LA14_0<=ENTITY_REFERENCE)) ) {
                alt14=1;
            }
            else if ( (LA14_0==INVERSE) ) {
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
                    // MOWLParser.g:158:7: atomic
                    {
                    pushFollow(FOLLOW_atomic_in_propertyExpression1461);
                    atomic70=atomic();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_atomic.add(atomic70.getTree());


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
                    // 158:14: -> ^( atomic )
                    {
                        // MOWLParser.g:158:17: ^( atomic )
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
                    // MOWLParser.g:159:7: complexPropertyExpression
                    {
                    pushFollow(FOLLOW_complexPropertyExpression_in_propertyExpression1475);
                    complexPropertyExpression71=complexPropertyExpression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_complexPropertyExpression.add(complexPropertyExpression71.getTree());


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
                    // 159:33: -> ^( complexPropertyExpression )
                    {
                        // MOWLParser.g:159:36: ^( complexPropertyExpression )
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
    // MOWLParser.g:162:1: cardinalityRestriction options {backtrack=true; } : propertyExpression restrictionKind INTEGER ( unary )? -> ^( CARDINALITY_RESTRICTION restrictionKind INTEGER propertyExpression ( unary )? ) ;
    public final ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase_MOWLParser.cardinalityRestriction_return cardinalityRestriction() throws RecognitionException {
        ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase_MOWLParser.cardinalityRestriction_return retval = new ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase_MOWLParser.cardinalityRestriction_return();
        retval.start = input.LT(1);

        ManchesterOWLSyntaxTree root_0 = null;

        Token INTEGER74=null;
        ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase_MOWLParser.propertyExpression_return propertyExpression72 = null;

        ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase_MOWLParser.restrictionKind_return restrictionKind73 = null;

        ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase_MOWLParser.unary_return unary75 = null;


        ManchesterOWLSyntaxTree INTEGER74_tree=null;
        RewriteRuleTokenStream stream_INTEGER=new RewriteRuleTokenStream(adaptor,"token INTEGER");
        RewriteRuleSubtreeStream stream_propertyExpression=new RewriteRuleSubtreeStream(adaptor,"rule propertyExpression");
        RewriteRuleSubtreeStream stream_restrictionKind=new RewriteRuleSubtreeStream(adaptor,"rule restrictionKind");
        RewriteRuleSubtreeStream stream_unary=new RewriteRuleSubtreeStream(adaptor,"rule unary");
        try {
            // MOWLParser.g:163:28: ( propertyExpression restrictionKind INTEGER ( unary )? -> ^( CARDINALITY_RESTRICTION restrictionKind INTEGER propertyExpression ( unary )? ) )
            // MOWLParser.g:164:2: propertyExpression restrictionKind INTEGER ( unary )?
            {
            pushFollow(FOLLOW_propertyExpression_in_cardinalityRestriction1517);
            propertyExpression72=propertyExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_propertyExpression.add(propertyExpression72.getTree());
            pushFollow(FOLLOW_restrictionKind_in_cardinalityRestriction1520);
            restrictionKind73=restrictionKind();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_restrictionKind.add(restrictionKind73.getTree());
            INTEGER74=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_cardinalityRestriction1522); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_INTEGER.add(INTEGER74);

            // MOWLParser.g:164:46: ( unary )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==OPEN_CURLY_BRACES||LA15_0==NOT||LA15_0==INVERSE||LA15_0==DBLQUOTE||(LA15_0>=IDENTIFIER && LA15_0<=ENTITY_REFERENCE)) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // MOWLParser.g:164:46: unary
                    {
                    pushFollow(FOLLOW_unary_in_cardinalityRestriction1524);
                    unary75=unary();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_unary.add(unary75.getTree());

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

            root_0 = (ManchesterOWLSyntaxTree)adaptor.nil();
            // 164:53: -> ^( CARDINALITY_RESTRICTION restrictionKind INTEGER propertyExpression ( unary )? )
            {
                // MOWLParser.g:164:56: ^( CARDINALITY_RESTRICTION restrictionKind INTEGER propertyExpression ( unary )? )
                {
                ManchesterOWLSyntaxTree root_1 = (ManchesterOWLSyntaxTree)adaptor.nil();
                root_1 = (ManchesterOWLSyntaxTree)adaptor.becomeRoot((ManchesterOWLSyntaxTree)adaptor.create(CARDINALITY_RESTRICTION, "CARDINALITY_RESTRICTION"), root_1);

                adaptor.addChild(root_1, stream_restrictionKind.nextTree());
                adaptor.addChild(root_1, stream_INTEGER.nextNode());
                adaptor.addChild(root_1, stream_propertyExpression.nextTree());
                // MOWLParser.g:164:127: ( unary )?
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
    // MOWLParser.g:167:1: restrictionKind : ( MIN -> ^( MIN ) | MAX -> ^( MAX ) | EXACTLY -> ^( EXACTLY ) );
    public final ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase_MOWLParser.restrictionKind_return restrictionKind() throws RecognitionException {
        ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase_MOWLParser.restrictionKind_return retval = new ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase_MOWLParser.restrictionKind_return();
        retval.start = input.LT(1);

        ManchesterOWLSyntaxTree root_0 = null;

        Token MIN76=null;
        Token MAX77=null;
        Token EXACTLY78=null;

        ManchesterOWLSyntaxTree MIN76_tree=null;
        ManchesterOWLSyntaxTree MAX77_tree=null;
        ManchesterOWLSyntaxTree EXACTLY78_tree=null;
        RewriteRuleTokenStream stream_MAX=new RewriteRuleTokenStream(adaptor,"token MAX");
        RewriteRuleTokenStream stream_MIN=new RewriteRuleTokenStream(adaptor,"token MIN");
        RewriteRuleTokenStream stream_EXACTLY=new RewriteRuleTokenStream(adaptor,"token EXACTLY");

        try {
            // MOWLParser.g:167:17: ( MIN -> ^( MIN ) | MAX -> ^( MAX ) | EXACTLY -> ^( EXACTLY ) )
            int alt16=3;
            switch ( input.LA(1) ) {
            case MIN:
                {
                alt16=1;
                }
                break;
            case MAX:
                {
                alt16=2;
                }
                break;
            case EXACTLY:
                {
                alt16=3;
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
                    // MOWLParser.g:168:5: MIN
                    {
                    MIN76=(Token)match(input,MIN,FOLLOW_MIN_in_restrictionKind1557); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_MIN.add(MIN76);



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
                    // 168:9: -> ^( MIN )
                    {
                        // MOWLParser.g:168:12: ^( MIN )
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
                    // MOWLParser.g:169:7: MAX
                    {
                    MAX77=(Token)match(input,MAX,FOLLOW_MAX_in_restrictionKind1571); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_MAX.add(MAX77);



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
                    // 169:11: -> ^( MAX )
                    {
                        // MOWLParser.g:169:14: ^( MAX )
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
                    // MOWLParser.g:170:7: EXACTLY
                    {
                    EXACTLY78=(Token)match(input,EXACTLY,FOLLOW_EXACTLY_in_restrictionKind1585); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_EXACTLY.add(EXACTLY78);



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
                    // 170:15: -> ^( EXACTLY )
                    {
                        // MOWLParser.g:170:18: ^( EXACTLY )
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
    // MOWLParser.g:174:1: oneOf : OPEN_CURLY_BRACES IDENTIFIER ( COMMA IDENTIFIER )* CLOSED_CURLY_BRACES -> ^( ONE_OF ( IDENTIFIER )+ ) ;
    public final ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase_MOWLParser.oneOf_return oneOf() throws RecognitionException {
        ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase_MOWLParser.oneOf_return retval = new ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase_MOWLParser.oneOf_return();
        retval.start = input.LT(1);

        ManchesterOWLSyntaxTree root_0 = null;

        Token OPEN_CURLY_BRACES79=null;
        Token IDENTIFIER80=null;
        Token COMMA81=null;
        Token IDENTIFIER82=null;
        Token CLOSED_CURLY_BRACES83=null;

        ManchesterOWLSyntaxTree OPEN_CURLY_BRACES79_tree=null;
        ManchesterOWLSyntaxTree IDENTIFIER80_tree=null;
        ManchesterOWLSyntaxTree COMMA81_tree=null;
        ManchesterOWLSyntaxTree IDENTIFIER82_tree=null;
        ManchesterOWLSyntaxTree CLOSED_CURLY_BRACES83_tree=null;
        RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
        RewriteRuleTokenStream stream_OPEN_CURLY_BRACES=new RewriteRuleTokenStream(adaptor,"token OPEN_CURLY_BRACES");
        RewriteRuleTokenStream stream_CLOSED_CURLY_BRACES=new RewriteRuleTokenStream(adaptor,"token CLOSED_CURLY_BRACES");
        RewriteRuleTokenStream stream_IDENTIFIER=new RewriteRuleTokenStream(adaptor,"token IDENTIFIER");

        try {
            // MOWLParser.g:174:7: ( OPEN_CURLY_BRACES IDENTIFIER ( COMMA IDENTIFIER )* CLOSED_CURLY_BRACES -> ^( ONE_OF ( IDENTIFIER )+ ) )
            // MOWLParser.g:175:3: OPEN_CURLY_BRACES IDENTIFIER ( COMMA IDENTIFIER )* CLOSED_CURLY_BRACES
            {
            OPEN_CURLY_BRACES79=(Token)match(input,OPEN_CURLY_BRACES,FOLLOW_OPEN_CURLY_BRACES_in_oneOf1607); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_OPEN_CURLY_BRACES.add(OPEN_CURLY_BRACES79);

            IDENTIFIER80=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_oneOf1609); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_IDENTIFIER.add(IDENTIFIER80);

            // MOWLParser.g:175:32: ( COMMA IDENTIFIER )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( (LA17_0==COMMA) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // MOWLParser.g:175:33: COMMA IDENTIFIER
            	    {
            	    COMMA81=(Token)match(input,COMMA,FOLLOW_COMMA_in_oneOf1612); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_COMMA.add(COMMA81);

            	    IDENTIFIER82=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_oneOf1614); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_IDENTIFIER.add(IDENTIFIER82);


            	    }
            	    break;

            	default :
            	    break loop17;
                }
            } while (true);

            CLOSED_CURLY_BRACES83=(Token)match(input,CLOSED_CURLY_BRACES,FOLLOW_CLOSED_CURLY_BRACES_in_oneOf1618); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_CLOSED_CURLY_BRACES.add(CLOSED_CURLY_BRACES83);



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
            // 175:72: -> ^( ONE_OF ( IDENTIFIER )+ )
            {
                // MOWLParser.g:175:75: ^( ONE_OF ( IDENTIFIER )+ )
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
    // MOWLParser.g:178:1: valueRestriction : propertyExpression VALUE value -> ^( VALUE_RESTRICTION propertyExpression value ) ;
    public final ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase_MOWLParser.valueRestriction_return valueRestriction() throws RecognitionException {
        ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase_MOWLParser.valueRestriction_return retval = new ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase_MOWLParser.valueRestriction_return();
        retval.start = input.LT(1);

        ManchesterOWLSyntaxTree root_0 = null;

        Token VALUE85=null;
        ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase_MOWLParser.propertyExpression_return propertyExpression84 = null;

        ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase_MOWLParser.value_return value86 = null;


        ManchesterOWLSyntaxTree VALUE85_tree=null;
        RewriteRuleTokenStream stream_VALUE=new RewriteRuleTokenStream(adaptor,"token VALUE");
        RewriteRuleSubtreeStream stream_propertyExpression=new RewriteRuleSubtreeStream(adaptor,"rule propertyExpression");
        RewriteRuleSubtreeStream stream_value=new RewriteRuleSubtreeStream(adaptor,"rule value");
        try {
            // MOWLParser.g:178:18: ( propertyExpression VALUE value -> ^( VALUE_RESTRICTION propertyExpression value ) )
            // MOWLParser.g:178:20: propertyExpression VALUE value
            {
            pushFollow(FOLLOW_propertyExpression_in_valueRestriction1638);
            propertyExpression84=propertyExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_propertyExpression.add(propertyExpression84.getTree());
            VALUE85=(Token)match(input,VALUE,FOLLOW_VALUE_in_valueRestriction1640); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_VALUE.add(VALUE85);

            pushFollow(FOLLOW_value_in_valueRestriction1642);
            value86=value();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_value.add(value86.getTree());


            // AST REWRITE
            // elements: propertyExpression, value
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (ManchesterOWLSyntaxTree)adaptor.nil();
            // 178:51: -> ^( VALUE_RESTRICTION propertyExpression value )
            {
                // MOWLParser.g:178:54: ^( VALUE_RESTRICTION propertyExpression value )
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
    // MOWLParser.g:181:1: value : ( atomic -> ^( atomic ) | constant -> ^( constant ) );
    public final ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase_MOWLParser.value_return value() throws RecognitionException {
        ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase_MOWLParser.value_return retval = new ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase_MOWLParser.value_return();
        retval.start = input.LT(1);

        ManchesterOWLSyntaxTree root_0 = null;

        ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase_MOWLParser.atomic_return atomic87 = null;

        ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase_MOWLParser.constant_return constant88 = null;


        RewriteRuleSubtreeStream stream_atomic=new RewriteRuleSubtreeStream(adaptor,"rule atomic");
        RewriteRuleSubtreeStream stream_constant=new RewriteRuleSubtreeStream(adaptor,"rule constant");
        try {
            // MOWLParser.g:181:6: ( atomic -> ^( atomic ) | constant -> ^( constant ) )
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( ((LA18_0>=IDENTIFIER && LA18_0<=ENTITY_REFERENCE)) ) {
                alt18=1;
            }
            else if ( (LA18_0==DBLQUOTE) ) {
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
                    // MOWLParser.g:182:7: atomic
                    {
                    pushFollow(FOLLOW_atomic_in_value1667);
                    atomic87=atomic();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_atomic.add(atomic87.getTree());


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
                    // 182:14: -> ^( atomic )
                    {
                        // MOWLParser.g:182:17: ^( atomic )
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
                    // MOWLParser.g:183:7: constant
                    {
                    pushFollow(FOLLOW_constant_in_value1682);
                    constant88=constant();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_constant.add(constant88.getTree());


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
                    // 183:16: -> ^( constant )
                    {
                        // MOWLParser.g:183:19: ^( constant )
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
    // MOWLParser.g:186:1: constant : constantValue= DBLQUOTE ( POW type= IDENTIFIER )? -> ^( CONSTANT $constantValue ( $type)? ) ;
    public final ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase_MOWLParser.constant_return constant() throws RecognitionException {
        ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase_MOWLParser.constant_return retval = new ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase_MOWLParser.constant_return();
        retval.start = input.LT(1);

        ManchesterOWLSyntaxTree root_0 = null;

        Token constantValue=null;
        Token type=null;
        Token POW89=null;

        ManchesterOWLSyntaxTree constantValue_tree=null;
        ManchesterOWLSyntaxTree type_tree=null;
        ManchesterOWLSyntaxTree POW89_tree=null;
        RewriteRuleTokenStream stream_DBLQUOTE=new RewriteRuleTokenStream(adaptor,"token DBLQUOTE");
        RewriteRuleTokenStream stream_POW=new RewriteRuleTokenStream(adaptor,"token POW");
        RewriteRuleTokenStream stream_IDENTIFIER=new RewriteRuleTokenStream(adaptor,"token IDENTIFIER");

        try {
            // MOWLParser.g:186:11: (constantValue= DBLQUOTE ( POW type= IDENTIFIER )? -> ^( CONSTANT $constantValue ( $type)? ) )
            // MOWLParser.g:186:14: constantValue= DBLQUOTE ( POW type= IDENTIFIER )?
            {
            constantValue=(Token)match(input,DBLQUOTE,FOLLOW_DBLQUOTE_in_constant1707); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_DBLQUOTE.add(constantValue);

            // MOWLParser.g:186:39: ( POW type= IDENTIFIER )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==POW) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // MOWLParser.g:186:41: POW type= IDENTIFIER
                    {
                    POW89=(Token)match(input,POW,FOLLOW_POW_in_constant1711); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_POW.add(POW89);

                    type=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_constant1717); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_IDENTIFIER.add(type);


                    }
                    break;

            }



            // AST REWRITE
            // elements: constantValue, type
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

            root_0 = (ManchesterOWLSyntaxTree)adaptor.nil();
            // 186:65: -> ^( CONSTANT $constantValue ( $type)? )
            {
                // MOWLParser.g:186:67: ^( CONSTANT $constantValue ( $type)? )
                {
                ManchesterOWLSyntaxTree root_1 = (ManchesterOWLSyntaxTree)adaptor.nil();
                root_1 = (ManchesterOWLSyntaxTree)adaptor.becomeRoot((ManchesterOWLSyntaxTree)adaptor.create(CONSTANT, "CONSTANT"), root_1);

                adaptor.addChild(root_1, stream_constantValue.nextNode());
                // MOWLParser.g:186:93: ( $type)?
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

    // $ANTLR start synpred5_MOWLParser
    public final void synpred5_MOWLParser_fragment() throws RecognitionException {   
        ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase_MOWLParser.expression_return lhs = null;

        ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase_MOWLParser.expression_return superClass = null;


        // MOWLParser.g:83:2: (lhs= expression SUBCLASS_OF superClass= expression )
        // MOWLParser.g:83:2: lhs= expression SUBCLASS_OF superClass= expression
        {
        pushFollow(FOLLOW_expression_in_synpred5_MOWLParser406);
        lhs=expression();

        state._fsp--;
        if (state.failed) return ;
        match(input,SUBCLASS_OF,FOLLOW_SUBCLASS_OF_in_synpred5_MOWLParser408); if (state.failed) return ;
        pushFollow(FOLLOW_expression_in_synpred5_MOWLParser415);
        superClass=expression();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred5_MOWLParser

    // $ANTLR start synpred6_MOWLParser
    public final void synpred6_MOWLParser_fragment() throws RecognitionException {   
        ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase_MOWLParser.expression_return lhs = null;

        ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase_MOWLParser.expression_return rhs = null;


        // MOWLParser.g:84:11: (lhs= expression EQUIVALENT_TO rhs= expression )
        // MOWLParser.g:84:11: lhs= expression EQUIVALENT_TO rhs= expression
        {
        pushFollow(FOLLOW_expression_in_synpred6_MOWLParser453);
        lhs=expression();

        state._fsp--;
        if (state.failed) return ;
        match(input,EQUIVALENT_TO,FOLLOW_EQUIVALENT_TO_in_synpred6_MOWLParser455); if (state.failed) return ;
        pushFollow(FOLLOW_expression_in_synpred6_MOWLParser461);
        rhs=expression();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred6_MOWLParser

    // $ANTLR start synpred7_MOWLParser
    public final void synpred7_MOWLParser_fragment() throws RecognitionException {   
        ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase_MOWLParser.expression_return lhs = null;

        ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase_MOWLParser.expression_return disjoint = null;


        // MOWLParser.g:85:11: (lhs= expression DISJOINT_WITH disjoint= expression )
        // MOWLParser.g:85:11: lhs= expression DISJOINT_WITH disjoint= expression
        {
        pushFollow(FOLLOW_expression_in_synpred7_MOWLParser498);
        lhs=expression();

        state._fsp--;
        if (state.failed) return ;
        match(input,DISJOINT_WITH,FOLLOW_DISJOINT_WITH_in_synpred7_MOWLParser500); if (state.failed) return ;
        pushFollow(FOLLOW_expression_in_synpred7_MOWLParser506);
        disjoint=expression();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred7_MOWLParser

    // $ANTLR start synpred8_MOWLParser
    public final void synpred8_MOWLParser_fragment() throws RecognitionException {   
        ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase_MOWLParser.expression_return lhs = null;

        ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase_MOWLParser.propertyExpression_return superProperty = null;


        // MOWLParser.g:86:11: (lhs= expression SUB_PROPERTY_OF superProperty= propertyExpression )
        // MOWLParser.g:86:11: lhs= expression SUB_PROPERTY_OF superProperty= propertyExpression
        {
        pushFollow(FOLLOW_expression_in_synpred8_MOWLParser543);
        lhs=expression();

        state._fsp--;
        if (state.failed) return ;
        match(input,SUB_PROPERTY_OF,FOLLOW_SUB_PROPERTY_OF_in_synpred8_MOWLParser545); if (state.failed) return ;
        pushFollow(FOLLOW_propertyExpression_in_synpred8_MOWLParser551);
        superProperty=propertyExpression();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred8_MOWLParser

    // $ANTLR start synpred9_MOWLParser
    public final void synpred9_MOWLParser_fragment() throws RecognitionException {   
        ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase_MOWLParser.atomic_return lhsID = null;

        ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase_MOWLParser.atomic_return rhsAtomic = null;


        // MOWLParser.g:87:11: (lhsID= atomic INVERSE_OF rhsAtomic= atomic )
        // MOWLParser.g:87:11: lhsID= atomic INVERSE_OF rhsAtomic= atomic
        {
        pushFollow(FOLLOW_atomic_in_synpred9_MOWLParser588);
        lhsID=atomic();

        state._fsp--;
        if (state.failed) return ;
        match(input,INVERSE_OF,FOLLOW_INVERSE_OF_in_synpred9_MOWLParser590); if (state.failed) return ;
        pushFollow(FOLLOW_atomic_in_synpred9_MOWLParser596);
        rhsAtomic=atomic();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred9_MOWLParser

    // $ANTLR start synpred10_MOWLParser
    public final void synpred10_MOWLParser_fragment() throws RecognitionException {   
        ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase_MOWLParser.atomic_return lhsID = null;

        ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase_MOWLParser.atomic_return rhsID = null;


        // MOWLParser.g:88:3: (lhsID= atomic SAME_AS rhsID= atomic )
        // MOWLParser.g:88:3: lhsID= atomic SAME_AS rhsID= atomic
        {
        pushFollow(FOLLOW_atomic_in_synpred10_MOWLParser627);
        lhsID=atomic();

        state._fsp--;
        if (state.failed) return ;
        match(input,SAME_AS,FOLLOW_SAME_AS_in_synpred10_MOWLParser629); if (state.failed) return ;
        pushFollow(FOLLOW_atomic_in_synpred10_MOWLParser636);
        rhsID=atomic();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred10_MOWLParser

    // $ANTLR start synpred11_MOWLParser
    public final void synpred11_MOWLParser_fragment() throws RecognitionException {   
        ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase_MOWLParser.atomic_return lhsID = null;

        ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase_MOWLParser.atomic_return rhsID = null;


        // MOWLParser.g:89:11: (lhsID= atomic DIFFERENT_FROM rhsID= atomic )
        // MOWLParser.g:89:11: lhsID= atomic DIFFERENT_FROM rhsID= atomic
        {
        pushFollow(FOLLOW_atomic_in_synpred11_MOWLParser674);
        lhsID=atomic();

        state._fsp--;
        if (state.failed) return ;
        match(input,DIFFERENT_FROM,FOLLOW_DIFFERENT_FROM_in_synpred11_MOWLParser676); if (state.failed) return ;
        pushFollow(FOLLOW_atomic_in_synpred11_MOWLParser683);
        rhsID=atomic();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred11_MOWLParser

    // $ANTLR start synpred12_MOWLParser
    public final void synpred12_MOWLParser_fragment() throws RecognitionException {   
        ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase_MOWLParser.atomic_return lhsID = null;


        // MOWLParser.g:90:11: (lhsID= atomic DOMAIN expression )
        // MOWLParser.g:90:11: lhsID= atomic DOMAIN expression
        {
        pushFollow(FOLLOW_atomic_in_synpred12_MOWLParser720);
        lhsID=atomic();

        state._fsp--;
        if (state.failed) return ;
        match(input,DOMAIN,FOLLOW_DOMAIN_in_synpred12_MOWLParser723); if (state.failed) return ;
        pushFollow(FOLLOW_expression_in_synpred12_MOWLParser725);
        expression();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred12_MOWLParser

    // $ANTLR start synpred13_MOWLParser
    public final void synpred13_MOWLParser_fragment() throws RecognitionException {   
        // MOWLParser.g:112:5: ( conjunction ( OR conjunction )* )
        // MOWLParser.g:112:5: conjunction ( OR conjunction )*
        {
        pushFollow(FOLLOW_conjunction_in_synpred13_MOWLParser1014);
        conjunction();

        state._fsp--;
        if (state.failed) return ;
        // MOWLParser.g:112:17: ( OR conjunction )*
        loop20:
        do {
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==OR) ) {
                alt20=1;
            }


            switch (alt20) {
        	case 1 :
        	    // MOWLParser.g:112:18: OR conjunction
        	    {
        	    match(input,OR,FOLLOW_OR_in_synpred13_MOWLParser1017); if (state.failed) return ;
        	    pushFollow(FOLLOW_conjunction_in_synpred13_MOWLParser1019);
        	    conjunction();

        	    state._fsp--;
        	    if (state.failed) return ;

        	    }
        	    break;

        	default :
        	    break loop20;
            }
        } while (true);


        }
    }
    // $ANTLR end synpred13_MOWLParser

    // $ANTLR start synpred14_MOWLParser
    public final void synpred14_MOWLParser_fragment() throws RecognitionException {   
        // MOWLParser.g:113:6: ( complexPropertyExpression )
        // MOWLParser.g:113:6: complexPropertyExpression
        {
        pushFollow(FOLLOW_complexPropertyExpression_in_synpred14_MOWLParser1038);
        complexPropertyExpression();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred14_MOWLParser

    // $ANTLR start synpred15_MOWLParser
    public final void synpred15_MOWLParser_fragment() throws RecognitionException {   
        List list_rest=null;
        ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase_MOWLParser.propertyExpression_return head = null;

        RuleReturnScope rest = null;
        // MOWLParser.g:133:4: (head= propertyExpression ( COMPOSITION rest+= propertyExpression )+ )
        // MOWLParser.g:133:4: head= propertyExpression ( COMPOSITION rest+= propertyExpression )+
        {
        pushFollow(FOLLOW_propertyExpression_in_synpred15_MOWLParser1176);
        head=propertyExpression();

        state._fsp--;
        if (state.failed) return ;
        // MOWLParser.g:133:30: ( COMPOSITION rest+= propertyExpression )+
        int cnt21=0;
        loop21:
        do {
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==COMPOSITION) ) {
                alt21=1;
            }


            switch (alt21) {
        	case 1 :
        	    // MOWLParser.g:133:31: COMPOSITION rest+= propertyExpression
        	    {
        	    match(input,COMPOSITION,FOLLOW_COMPOSITION_in_synpred15_MOWLParser1179); if (state.failed) return ;
        	    pushFollow(FOLLOW_propertyExpression_in_synpred15_MOWLParser1183);
        	    rest=propertyExpression();

        	    state._fsp--;
        	    if (state.failed) return ;
        	    if (list_rest==null) list_rest=new ArrayList();
        	    list_rest.add(rest);


        	    }
        	    break;

        	default :
        	    if ( cnt21 >= 1 ) break loop21;
        	    if (state.backtracking>0) {state.failed=true; return ;}
                    EarlyExitException eee =
                        new EarlyExitException(21, input);
                    throw eee;
            }
            cnt21++;
        } while (true);


        }
    }
    // $ANTLR end synpred15_MOWLParser

    // $ANTLR start synpred16_MOWLParser
    public final void synpred16_MOWLParser_fragment() throws RecognitionException {   
        // MOWLParser.g:134:5: ( NOT OPEN_PARENTHESYS expression CLOSED_PARENTHESYS )
        // MOWLParser.g:134:5: NOT OPEN_PARENTHESYS expression CLOSED_PARENTHESYS
        {
        match(input,NOT,FOLLOW_NOT_in_synpred16_MOWLParser1205); if (state.failed) return ;
        match(input,OPEN_PARENTHESYS,FOLLOW_OPEN_PARENTHESYS_in_synpred16_MOWLParser1207); if (state.failed) return ;
        pushFollow(FOLLOW_expression_in_synpred16_MOWLParser1209);
        expression();

        state._fsp--;
        if (state.failed) return ;
        match(input,CLOSED_PARENTHESYS,FOLLOW_CLOSED_PARENTHESYS_in_synpred16_MOWLParser1211); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred16_MOWLParser

    // $ANTLR start synpred17_MOWLParser
    public final void synpred17_MOWLParser_fragment() throws RecognitionException {   
        // MOWLParser.g:135:5: ( NOT atomic )
        // MOWLParser.g:135:5: NOT atomic
        {
        match(input,NOT,FOLLOW_NOT_in_synpred17_MOWLParser1225); if (state.failed) return ;
        pushFollow(FOLLOW_atomic_in_synpred17_MOWLParser1227);
        atomic();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred17_MOWLParser

    // $ANTLR start synpred18_MOWLParser
    public final void synpred18_MOWLParser_fragment() throws RecognitionException {   
        // MOWLParser.g:136:5: ( qualifiedRestriction )
        // MOWLParser.g:136:5: qualifiedRestriction
        {
        pushFollow(FOLLOW_qualifiedRestriction_in_synpred18_MOWLParser1250);
        qualifiedRestriction();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred18_MOWLParser

    // $ANTLR start synpred20_MOWLParser
    public final void synpred20_MOWLParser_fragment() throws RecognitionException {   
        // MOWLParser.g:149:7: ( propertyExpression SOME expression )
        // MOWLParser.g:149:7: propertyExpression SOME expression
        {
        pushFollow(FOLLOW_propertyExpression_in_synpred20_MOWLParser1341);
        propertyExpression();

        state._fsp--;
        if (state.failed) return ;
        match(input,SOME,FOLLOW_SOME_in_synpred20_MOWLParser1344); if (state.failed) return ;
        pushFollow(FOLLOW_expression_in_synpred20_MOWLParser1348);
        expression();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred20_MOWLParser

    // $ANTLR start synpred21_MOWLParser
    public final void synpred21_MOWLParser_fragment() throws RecognitionException {   
        // MOWLParser.g:150:7: ( propertyExpression ONLY expression )
        // MOWLParser.g:150:7: propertyExpression ONLY expression
        {
        pushFollow(FOLLOW_propertyExpression_in_synpred21_MOWLParser1377);
        propertyExpression();

        state._fsp--;
        if (state.failed) return ;
        match(input,ONLY,FOLLOW_ONLY_in_synpred21_MOWLParser1379); if (state.failed) return ;
        pushFollow(FOLLOW_expression_in_synpred21_MOWLParser1382);
        expression();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred21_MOWLParser

    // $ANTLR start synpred22_MOWLParser
    public final void synpred22_MOWLParser_fragment() throws RecognitionException {   
        // MOWLParser.g:151:7: ( cardinalityRestriction )
        // MOWLParser.g:151:7: cardinalityRestriction
        {
        pushFollow(FOLLOW_cardinalityRestriction_in_synpred22_MOWLParser1401);
        cardinalityRestriction();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred22_MOWLParser

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


    protected DFA4 dfa4 = new DFA4(this);
    protected DFA11 dfa11 = new DFA11(this);
    static final String DFA4_eotS =
        "\21\uffff";
    static final String DFA4_eofS =
        "\21\uffff";
    static final String DFA4_minS =
        "\1\5\7\0\11\uffff";
    static final String DFA4_maxS =
        "\1\55\7\0\11\uffff";
    static final String DFA4_acceptS =
        "\10\uffff\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11";
    static final String DFA4_specialS =
        "\1\uffff\1\0\1\1\1\2\1\3\1\4\1\5\1\6\11\uffff}>";
    static final String[] DFA4_transitionS = {
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

    static final short[] DFA4_eot = DFA.unpackEncodedString(DFA4_eotS);
    static final short[] DFA4_eof = DFA.unpackEncodedString(DFA4_eofS);
    static final char[] DFA4_min = DFA.unpackEncodedStringToUnsignedChars(DFA4_minS);
    static final char[] DFA4_max = DFA.unpackEncodedStringToUnsignedChars(DFA4_maxS);
    static final short[] DFA4_accept = DFA.unpackEncodedString(DFA4_acceptS);
    static final short[] DFA4_special = DFA.unpackEncodedString(DFA4_specialS);
    static final short[][] DFA4_transition;

    static {
        int numStates = DFA4_transitionS.length;
        DFA4_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA4_transition[i] = DFA.unpackEncodedString(DFA4_transitionS[i]);
        }
    }

    class DFA4 extends DFA {

        public DFA4(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 4;
            this.eot = DFA4_eot;
            this.eof = DFA4_eof;
            this.min = DFA4_min;
            this.max = DFA4_max;
            this.accept = DFA4_accept;
            this.special = DFA4_special;
            this.transition = DFA4_transition;
        }
        public String getDescription() {
            return "80:1: binaryAxiom options {backtrack=true; } : (lhs= expression SUBCLASS_OF superClass= expression -> ^( SUB_CLASS_AXIOM ^( EXPRESSION $lhs) ^( EXPRESSION $superClass) ) | lhs= expression EQUIVALENT_TO rhs= expression -> ^( EQUIVALENT_TO_AXIOM ^( EXPRESSION $lhs) ^( EXPRESSION $rhs) ) | lhs= expression DISJOINT_WITH disjoint= expression -> ^( DISJOINT_WITH_AXIOM ^( EXPRESSION $lhs) ^( EXPRESSION $disjoint) ) | lhs= expression SUB_PROPERTY_OF superProperty= propertyExpression -> ^( SUB_PROPERTY_AXIOM ^( EXPRESSION $lhs) ^( EXPRESSION $superProperty) ) | lhsID= atomic INVERSE_OF rhsAtomic= atomic -> ^( INVERSE_OF ^( EXPRESSION $lhsID) ^( EXPRESSION $rhsAtomic) ) | lhsID= atomic SAME_AS rhsID= atomic -> ^( SAME_AS_AXIOM ^( EXPRESSION $lhsID) ^( EXPRESSION $rhsID) ) | lhsID= atomic DIFFERENT_FROM rhsID= atomic -> ^( DIFFERENT_FROM_AXIOM ^( EXPRESSION $lhsID) ^( EXPRESSION $rhsID) ) | lhsID= atomic DOMAIN expression -> ^( DOMAIN ^( EXPRESSION $lhsID) ^( EXPRESSION expression ) ) | lhsID= atomic RANGE expression -> ^( RANGE ^( EXPRESSION $lhsID) ^( EXPRESSION expression ) ) );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA4_1 = input.LA(1);

                         
                        int index4_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred5_MOWLParser()) ) {s = 8;}

                        else if ( (synpred6_MOWLParser()) ) {s = 9;}

                        else if ( (synpred7_MOWLParser()) ) {s = 10;}

                        else if ( (synpred8_MOWLParser()) ) {s = 11;}

                        else if ( (synpred9_MOWLParser()) ) {s = 12;}

                        else if ( (synpred10_MOWLParser()) ) {s = 13;}

                        else if ( (synpred11_MOWLParser()) ) {s = 14;}

                        else if ( (synpred12_MOWLParser()) ) {s = 15;}

                        else if ( (true) ) {s = 16;}

                         
                        input.seek(index4_1);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA4_2 = input.LA(1);

                         
                        int index4_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred5_MOWLParser()) ) {s = 8;}

                        else if ( (synpred6_MOWLParser()) ) {s = 9;}

                        else if ( (synpred7_MOWLParser()) ) {s = 10;}

                        else if ( (synpred8_MOWLParser()) ) {s = 11;}

                        else if ( (synpred9_MOWLParser()) ) {s = 12;}

                        else if ( (synpred10_MOWLParser()) ) {s = 13;}

                        else if ( (synpred11_MOWLParser()) ) {s = 14;}

                        else if ( (synpred12_MOWLParser()) ) {s = 15;}

                        else if ( (true) ) {s = 16;}

                         
                        input.seek(index4_2);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA4_3 = input.LA(1);

                         
                        int index4_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred5_MOWLParser()) ) {s = 8;}

                        else if ( (synpred6_MOWLParser()) ) {s = 9;}

                        else if ( (synpred7_MOWLParser()) ) {s = 10;}

                        else if ( (synpred8_MOWLParser()) ) {s = 11;}

                         
                        input.seek(index4_3);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA4_4 = input.LA(1);

                         
                        int index4_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred5_MOWLParser()) ) {s = 8;}

                        else if ( (synpred6_MOWLParser()) ) {s = 9;}

                        else if ( (synpred7_MOWLParser()) ) {s = 10;}

                        else if ( (synpred8_MOWLParser()) ) {s = 11;}

                         
                        input.seek(index4_4);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA4_5 = input.LA(1);

                         
                        int index4_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred5_MOWLParser()) ) {s = 8;}

                        else if ( (synpred6_MOWLParser()) ) {s = 9;}

                        else if ( (synpred7_MOWLParser()) ) {s = 10;}

                        else if ( (synpred8_MOWLParser()) ) {s = 11;}

                         
                        input.seek(index4_5);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA4_6 = input.LA(1);

                         
                        int index4_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred5_MOWLParser()) ) {s = 8;}

                        else if ( (synpred6_MOWLParser()) ) {s = 9;}

                        else if ( (synpred7_MOWLParser()) ) {s = 10;}

                        else if ( (synpred8_MOWLParser()) ) {s = 11;}

                         
                        input.seek(index4_6);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA4_7 = input.LA(1);

                         
                        int index4_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred5_MOWLParser()) ) {s = 8;}

                        else if ( (synpred6_MOWLParser()) ) {s = 9;}

                        else if ( (synpred7_MOWLParser()) ) {s = 10;}

                        else if ( (synpred8_MOWLParser()) ) {s = 11;}

                         
                        input.seek(index4_7);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 4, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA11_eotS =
        "\13\uffff";
    static final String DFA11_eofS =
        "\13\uffff";
    static final String DFA11_minS =
        "\1\6\4\0\6\uffff";
    static final String DFA11_maxS =
        "\1\55\4\0\6\uffff";
    static final String DFA11_acceptS =
        "\5\uffff\1\4\1\5\1\1\1\6\1\2\1\3";
    static final String DFA11_specialS =
        "\1\uffff\1\0\1\1\1\2\1\3\6\uffff}>";
    static final String[] DFA11_transitionS = {
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
            ""
    };

    static final short[] DFA11_eot = DFA.unpackEncodedString(DFA11_eotS);
    static final short[] DFA11_eof = DFA.unpackEncodedString(DFA11_eofS);
    static final char[] DFA11_min = DFA.unpackEncodedStringToUnsignedChars(DFA11_minS);
    static final char[] DFA11_max = DFA.unpackEncodedStringToUnsignedChars(DFA11_maxS);
    static final short[] DFA11_accept = DFA.unpackEncodedString(DFA11_acceptS);
    static final short[] DFA11_special = DFA.unpackEncodedString(DFA11_specialS);
    static final short[][] DFA11_transition;

    static {
        int numStates = DFA11_transitionS.length;
        DFA11_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA11_transition[i] = DFA.unpackEncodedString(DFA11_transitionS[i]);
        }
    }

    class DFA11 extends DFA {

        public DFA11(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 11;
            this.eot = DFA11_eot;
            this.eof = DFA11_eof;
            this.min = DFA11_min;
            this.max = DFA11_max;
            this.accept = DFA11_accept;
            this.special = DFA11_special;
            this.transition = DFA11_transition;
        }
        public String getDescription() {
            return "131:1: unary options {backtrack=true; } : (head= propertyExpression ( COMPOSITION rest+= propertyExpression )+ -> ^( PROPERTY_CHAIN $head $rest) | NOT OPEN_PARENTHESYS expression CLOSED_PARENTHESYS -> ^( NEGATED_EXPRESSION expression ) | NOT atomic -> ^( NEGATED_EXPRESSION atomic ) | qualifiedRestriction -> ^( qualifiedRestriction ) | constant | atomic );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA11_1 = input.LA(1);

                         
                        int index11_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred15_MOWLParser()) ) {s = 7;}

                        else if ( (synpred18_MOWLParser()) ) {s = 5;}

                        else if ( (true) ) {s = 8;}

                         
                        input.seek(index11_1);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA11_2 = input.LA(1);

                         
                        int index11_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred15_MOWLParser()) ) {s = 7;}

                        else if ( (synpred18_MOWLParser()) ) {s = 5;}

                        else if ( (true) ) {s = 8;}

                         
                        input.seek(index11_2);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA11_3 = input.LA(1);

                         
                        int index11_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred15_MOWLParser()) ) {s = 7;}

                        else if ( (synpred18_MOWLParser()) ) {s = 5;}

                         
                        input.seek(index11_3);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA11_4 = input.LA(1);

                         
                        int index11_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred16_MOWLParser()) ) {s = 9;}

                        else if ( (synpred17_MOWLParser()) ) {s = 10;}

                         
                        input.seek(index11_4);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 11, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

    public static final BitSet FOLLOW_binaryAxiom_in_axiom231 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_unaryAxiom_in_axiom243 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_assertionAxiom_in_axiom255 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_atomic_in_assertionAxiom285 = new BitSet(new long[]{0x000000C000000000L});
    public static final BitSet FOLLOW_INSTANCE_OF_in_assertionAxiom288 = new BitSet(new long[]{0x0000310000081060L});
    public static final BitSet FOLLOW_TYPES_in_assertionAxiom292 = new BitSet(new long[]{0x0000310000081060L});
    public static final BitSet FOLLOW_expression_in_assertionAxiom295 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_atomic_in_assertionAxiom326 = new BitSet(new long[]{0x0000300000080000L});
    public static final BitSet FOLLOW_propertyExpression_in_assertionAxiom328 = new BitSet(new long[]{0x0000310000000000L});
    public static final BitSet FOLLOW_value_in_assertionAxiom331 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NOT_in_assertionAxiom365 = new BitSet(new long[]{0x0000300000001000L});
    public static final BitSet FOLLOW_assertionAxiom_in_assertionAxiom367 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_in_binaryAxiom406 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_SUBCLASS_OF_in_binaryAxiom408 = new BitSet(new long[]{0x0000310000081060L});
    public static final BitSet FOLLOW_expression_in_binaryAxiom415 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_in_binaryAxiom453 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_EQUIVALENT_TO_in_binaryAxiom455 = new BitSet(new long[]{0x0000310000081060L});
    public static final BitSet FOLLOW_expression_in_binaryAxiom461 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_in_binaryAxiom498 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_DISJOINT_WITH_in_binaryAxiom500 = new BitSet(new long[]{0x0000310000081060L});
    public static final BitSet FOLLOW_expression_in_binaryAxiom506 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_in_binaryAxiom543 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_SUB_PROPERTY_OF_in_binaryAxiom545 = new BitSet(new long[]{0x0000300000080000L});
    public static final BitSet FOLLOW_propertyExpression_in_binaryAxiom551 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_atomic_in_binaryAxiom588 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_INVERSE_OF_in_binaryAxiom590 = new BitSet(new long[]{0x0000300000000000L});
    public static final BitSet FOLLOW_atomic_in_binaryAxiom596 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_atomic_in_binaryAxiom627 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_SAME_AS_in_binaryAxiom629 = new BitSet(new long[]{0x0000300000000000L});
    public static final BitSet FOLLOW_atomic_in_binaryAxiom636 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_atomic_in_binaryAxiom674 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_DIFFERENT_FROM_in_binaryAxiom676 = new BitSet(new long[]{0x0000300000000000L});
    public static final BitSet FOLLOW_atomic_in_binaryAxiom683 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_atomic_in_binaryAxiom720 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_DOMAIN_in_binaryAxiom723 = new BitSet(new long[]{0x0000310000081060L});
    public static final BitSet FOLLOW_expression_in_binaryAxiom725 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_atomic_in_binaryAxiom761 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_RANGE_in_binaryAxiom763 = new BitSet(new long[]{0x0000310000081060L});
    public static final BitSet FOLLOW_expression_in_binaryAxiom765 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_unaryCharacteristic_in_unaryAxiom839 = new BitSet(new long[]{0x0000310000081040L});
    public static final BitSet FOLLOW_unary_in_unaryAxiom843 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FUNCTIONAL_in_unaryCharacteristic888 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INVERSE_FUNCTIONAL_in_unaryCharacteristic902 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SYMMETRIC_in_unaryCharacteristic916 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ANTI_SYMMETRIC_in_unaryCharacteristic930 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_REFLEXIVE_in_unaryCharacteristic944 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IRREFLEXIVE_in_unaryCharacteristic958 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TRANSITIVE_in_unaryCharacteristic972 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_conjunction_in_expression1014 = new BitSet(new long[]{0x0000000000000802L});
    public static final BitSet FOLLOW_OR_in_expression1017 = new BitSet(new long[]{0x0000310000081040L});
    public static final BitSet FOLLOW_conjunction_in_expression1019 = new BitSet(new long[]{0x0000000000000802L});
    public static final BitSet FOLLOW_complexPropertyExpression_in_expression1038 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OPEN_PARENTHESYS_in_expression1051 = new BitSet(new long[]{0x0000310000081060L});
    public static final BitSet FOLLOW_expression_in_expression1053 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_CLOSED_PARENTHESYS_in_expression1055 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_unary_in_conjunction1088 = new BitSet(new long[]{0x0000000000000402L});
    public static final BitSet FOLLOW_AND_in_conjunction1091 = new BitSet(new long[]{0x0000310000081040L});
    public static final BitSet FOLLOW_unary_in_conjunction1093 = new BitSet(new long[]{0x0000000000000402L});
    public static final BitSet FOLLOW_INVERSE_in_complexPropertyExpression1114 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_OPEN_PARENTHESYS_in_complexPropertyExpression1116 = new BitSet(new long[]{0x0000300000080000L});
    public static final BitSet FOLLOW_complexPropertyExpression_in_complexPropertyExpression1118 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_CLOSED_PARENTHESYS_in_complexPropertyExpression1120 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INVERSE_in_complexPropertyExpression1133 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_OPEN_PARENTHESYS_in_complexPropertyExpression1135 = new BitSet(new long[]{0x0000300000000000L});
    public static final BitSet FOLLOW_atomic_in_complexPropertyExpression1137 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_CLOSED_PARENTHESYS_in_complexPropertyExpression1139 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_propertyExpression_in_unary1176 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_COMPOSITION_in_unary1179 = new BitSet(new long[]{0x0000300000080000L});
    public static final BitSet FOLLOW_propertyExpression_in_unary1183 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_NOT_in_unary1205 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_OPEN_PARENTHESYS_in_unary1207 = new BitSet(new long[]{0x0000310000081060L});
    public static final BitSet FOLLOW_expression_in_unary1209 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_CLOSED_PARENTHESYS_in_unary1211 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NOT_in_unary1225 = new BitSet(new long[]{0x0000300000000000L});
    public static final BitSet FOLLOW_atomic_in_unary1227 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_qualifiedRestriction_in_unary1250 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_constant_in_unary1262 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_atomic_in_unary1268 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_atomic1282 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ENTITY_REFERENCE_in_atomic1289 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_propertyExpression_in_qualifiedRestriction1341 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_SOME_in_qualifiedRestriction1344 = new BitSet(new long[]{0x0000310000081060L});
    public static final BitSet FOLLOW_expression_in_qualifiedRestriction1348 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_propertyExpression_in_qualifiedRestriction1377 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_ONLY_in_qualifiedRestriction1379 = new BitSet(new long[]{0x0000310000081060L});
    public static final BitSet FOLLOW_expression_in_qualifiedRestriction1382 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_cardinalityRestriction_in_qualifiedRestriction1401 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_oneOf_in_qualifiedRestriction1415 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_valueRestriction_in_qualifiedRestriction1429 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_atomic_in_propertyExpression1461 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_complexPropertyExpression_in_propertyExpression1475 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_propertyExpression_in_cardinalityRestriction1517 = new BitSet(new long[]{0x0000000000038000L});
    public static final BitSet FOLLOW_restrictionKind_in_cardinalityRestriction1520 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_INTEGER_in_cardinalityRestriction1522 = new BitSet(new long[]{0x0000310000081042L});
    public static final BitSet FOLLOW_unary_in_cardinalityRestriction1524 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MIN_in_restrictionKind1557 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MAX_in_restrictionKind1571 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_EXACTLY_in_restrictionKind1585 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OPEN_CURLY_BRACES_in_oneOf1607 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_oneOf1609 = new BitSet(new long[]{0x0000002000000080L});
    public static final BitSet FOLLOW_COMMA_in_oneOf1612 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_oneOf1614 = new BitSet(new long[]{0x0000002000000080L});
    public static final BitSet FOLLOW_CLOSED_CURLY_BRACES_in_oneOf1618 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_propertyExpression_in_valueRestriction1638 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_VALUE_in_valueRestriction1640 = new BitSet(new long[]{0x0000310000000000L});
    public static final BitSet FOLLOW_value_in_valueRestriction1642 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_atomic_in_value1667 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_constant_in_value1682 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DBLQUOTE_in_constant1707 = new BitSet(new long[]{0x0000001000000002L});
    public static final BitSet FOLLOW_POW_in_constant1711 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_constant1717 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_in_synpred5_MOWLParser406 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_SUBCLASS_OF_in_synpred5_MOWLParser408 = new BitSet(new long[]{0x0000310000081060L});
    public static final BitSet FOLLOW_expression_in_synpred5_MOWLParser415 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_in_synpred6_MOWLParser453 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_EQUIVALENT_TO_in_synpred6_MOWLParser455 = new BitSet(new long[]{0x0000310000081060L});
    public static final BitSet FOLLOW_expression_in_synpred6_MOWLParser461 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_in_synpred7_MOWLParser498 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_DISJOINT_WITH_in_synpred7_MOWLParser500 = new BitSet(new long[]{0x0000310000081060L});
    public static final BitSet FOLLOW_expression_in_synpred7_MOWLParser506 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_in_synpred8_MOWLParser543 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_SUB_PROPERTY_OF_in_synpred8_MOWLParser545 = new BitSet(new long[]{0x0000300000080000L});
    public static final BitSet FOLLOW_propertyExpression_in_synpred8_MOWLParser551 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_atomic_in_synpred9_MOWLParser588 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_INVERSE_OF_in_synpred9_MOWLParser590 = new BitSet(new long[]{0x0000300000000000L});
    public static final BitSet FOLLOW_atomic_in_synpred9_MOWLParser596 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_atomic_in_synpred10_MOWLParser627 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_SAME_AS_in_synpred10_MOWLParser629 = new BitSet(new long[]{0x0000300000000000L});
    public static final BitSet FOLLOW_atomic_in_synpred10_MOWLParser636 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_atomic_in_synpred11_MOWLParser674 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_DIFFERENT_FROM_in_synpred11_MOWLParser676 = new BitSet(new long[]{0x0000300000000000L});
    public static final BitSet FOLLOW_atomic_in_synpred11_MOWLParser683 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_atomic_in_synpred12_MOWLParser720 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_DOMAIN_in_synpred12_MOWLParser723 = new BitSet(new long[]{0x0000310000081060L});
    public static final BitSet FOLLOW_expression_in_synpred12_MOWLParser725 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_conjunction_in_synpred13_MOWLParser1014 = new BitSet(new long[]{0x0000000000000802L});
    public static final BitSet FOLLOW_OR_in_synpred13_MOWLParser1017 = new BitSet(new long[]{0x0000310000081040L});
    public static final BitSet FOLLOW_conjunction_in_synpred13_MOWLParser1019 = new BitSet(new long[]{0x0000000000000802L});
    public static final BitSet FOLLOW_complexPropertyExpression_in_synpred14_MOWLParser1038 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_propertyExpression_in_synpred15_MOWLParser1176 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_COMPOSITION_in_synpred15_MOWLParser1179 = new BitSet(new long[]{0x0000300000080000L});
    public static final BitSet FOLLOW_propertyExpression_in_synpred15_MOWLParser1183 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_NOT_in_synpred16_MOWLParser1205 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_OPEN_PARENTHESYS_in_synpred16_MOWLParser1207 = new BitSet(new long[]{0x0000310000081060L});
    public static final BitSet FOLLOW_expression_in_synpred16_MOWLParser1209 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_CLOSED_PARENTHESYS_in_synpred16_MOWLParser1211 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NOT_in_synpred17_MOWLParser1225 = new BitSet(new long[]{0x0000300000000000L});
    public static final BitSet FOLLOW_atomic_in_synpred17_MOWLParser1227 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_qualifiedRestriction_in_synpred18_MOWLParser1250 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_propertyExpression_in_synpred20_MOWLParser1341 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_SOME_in_synpred20_MOWLParser1344 = new BitSet(new long[]{0x0000310000081060L});
    public static final BitSet FOLLOW_expression_in_synpred20_MOWLParser1348 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_propertyExpression_in_synpred21_MOWLParser1377 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_ONLY_in_synpred21_MOWLParser1379 = new BitSet(new long[]{0x0000310000081060L});
    public static final BitSet FOLLOW_expression_in_synpred21_MOWLParser1382 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_cardinalityRestriction_in_synpred22_MOWLParser1401 = new BitSet(new long[]{0x0000000000000002L});

}