// $ANTLR 3.2 Sep 23, 2009 12:02:23 MOWLParser.g 2010-04-29 11:19:43

  package org.coode.parsers;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

import org.antlr.runtime.tree.*;

public class ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase_MOWLParser extends Parser {
    public static final int VALUE_RESTRICTION=61;
    public static final int LETTER=43;
    public static final int INCOMPLETE_INVERSE_OF=81;
    public static final int TYPES=39;
    public static final int SAME_AS_AXIOM=50;
    public static final int INVERSE_OF=25;
    public static final int NOT=12;
    public static final int SUBCLASS_OF=20;
    public static final int EOF=-1;
    public static final int INCOMPLETE_ONE_OF=90;
    public static final int POW=36;
    public static final int INCOMPLETE_INVERSE_OBJECT_PROPERTY_EXPRESSION=85;
    public static final int INVERSE_OBJECT_PROPERTY_EXPRESSION=66;
    public static final int INSTANCE_OF=38;
    public static final int INCOMPLETE_TYPE_ASSERTION=70;
    public static final int SYMMETRIC=30;
    public static final int INCOMPLETE_DIFFERENT_FROM_AXIOM=78;
    public static final int INCOMPLETE_NEGATED_EXPRESSION=86;
    public static final int INCOMPLETE_SUB_PROPERTY_AXIOM=76;
    public static final int CARDINALITY_RESTRICTION=62;
    public static final int ROLE_ASSERTION=65;
    public static final int DIFFERENT_FROM_AXIOM=51;
    public static final int INCOMPLETE_SUB_CLASS_AXIOM=73;
    public static final int INCOMPLETE_ALL_RESTRICTION=88;
    public static final int TRANSITIVE=34;
    public static final int ANTI_SYMMETRIC=31;
    public static final int ALL_RESTRICTION=60;
    public static final int CONJUNCTION=54;
    public static final int NEGATED_ASSERTION=57;
    public static final int WHITESPACE=9;
    public static final int VALUE=18;
    public static final int OPEN_CURLY_BRACES=6;
    public static final int DISJUNCTION=53;
    public static final int INVERSE=19;
    public static final int INCOMPLETE_ROLE_ASSERTION=71;
    public static final int INCOMPLETE_SOME_RESTRICTION=87;
    public static final int DBLQUOTE=40;
    public static final int OR=11;
    public static final int CONSTANT=68;
    public static final int INCOMPLETE_EXPRESSION=92;
    public static final int ENTITY_REFERENCE=45;
    public static final int COMPOSITION=4;
    public static final int INCOMPLETE_DISJOINT_WITH_AXIOM=75;
    public static final int INCOMPLETE_VALUE_RESTRICTION=91;
    public static final int SAME_AS=23;
    public static final int INCOMPLETE_CONJUNCTION=84;
    public static final int DISJOINT_WITH=26;
    public static final int CLOSED_PARENTHESYS=8;
    public static final int ONLY=14;
    public static final int EQUIVALENT_TO_AXIOM=47;
    public static final int INCOMPLETE_EQUIVALENT_TO_AXIOM=74;
    public static final int SUB_PROPERTY_OF=21;
    public static final int NEGATED_EXPRESSION=56;
    public static final int MAX=16;
    public static final int AND=10;
    public static final int INVERSE_PROPERTY=58;
    public static final int DIFFERENT_FROM=24;
    public static final int EQUIVALENT_TO=22;
    public static final int UNARY_AXIOM=52;
    public static final int COMMA=37;
    public static final int CLOSED_CURLY_BRACES=7;
    public static final int INCOMPLETE_CARDINALITY_RESTRICTION=89;
    public static final int IDENTIFIER=44;
    public static final int SOME=13;
    public static final int OPEN_PARENTHESYS=5;
    public static final int REFLEXIVE=32;
    public static final int DIGIT=41;
    public static final int EXPRESSION=67;
    public static final int SOME_RESTRICTION=59;
    public static final int INTEGER=42;
    public static final int INCOMPLETE_DISJUNCTION=83;
    public static final int INCOMPLETE_SAME_AS_AXIOM=77;
    public static final int INCOMPLETE_RANGE=80;
    public static final int EXACTLY=17;
    public static final int SUB_PROPERTY_AXIOM=49;
    public static final int RANGE=28;
    public static final int ONE_OF=63;
    public static final int MIN=15;
    public static final int SUB_CLASS_AXIOM=46;
    public static final int DOMAIN=27;
    public static final int DISJOINT_WITH_AXIOM=48;
    public static final int STANDALONE_EXPRESSION=69;
    public static final int INVERSE_FUNCTIONAL=35;
    public static final int IRREFLEXIVE=33;
    public static final int INCOMPLETE_PROPERTY_CHAIN=82;
    public static final int FUNCTIONAL=29;
    public static final int PROPERTY_CHAIN=55;
    public static final int INCOMPLETE_DOMAIN=79;
    public static final int INCOMPLETE_UNARY_AXIOM=72;
    public static final int TYPE_ASSERTION=64;

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
    // MOWLParser.g:63:1: axiom : ( binaryAxiom -> ^( binaryAxiom ) | unaryAxiom -> ^( unaryAxiom ) | assertionAxiom -> ^( assertionAxiom ) );
    public final ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase_MOWLParser.axiom_return axiom() throws RecognitionException {
        ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase_MOWLParser.axiom_return retval = new ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase_MOWLParser.axiom_return();
        retval.start = input.LT(1);

        ManchesterOWLSyntaxTree root_0 = null;

        ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase_MOWLParser.binaryAxiom_return binaryAxiom1 = null;

        ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase_MOWLParser.unaryAxiom_return unaryAxiom2 = null;

        ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase_MOWLParser.assertionAxiom_return assertionAxiom3 = null;


        RewriteRuleSubtreeStream stream_binaryAxiom=new RewriteRuleSubtreeStream(adaptor,"rule binaryAxiom");
        RewriteRuleSubtreeStream stream_unaryAxiom=new RewriteRuleSubtreeStream(adaptor,"rule unaryAxiom");
        RewriteRuleSubtreeStream stream_assertionAxiom=new RewriteRuleSubtreeStream(adaptor,"rule assertionAxiom");
        try {
            // MOWLParser.g:63:7: ( binaryAxiom -> ^( binaryAxiom ) | unaryAxiom -> ^( unaryAxiom ) | assertionAxiom -> ^( assertionAxiom ) )
            int alt1=3;
            switch ( input.LA(1) ) {
            case IDENTIFIER:
                {
                int LA1_1 = input.LA(2);

                if ( (LA1_1==COMPOSITION||(LA1_1>=AND && LA1_1<=OR)||(LA1_1>=SOME && LA1_1<=VALUE)||(LA1_1>=SUBCLASS_OF && LA1_1<=RANGE)) ) {
                    alt1=1;
                }
                else if ( (LA1_1==INVERSE||(LA1_1>=INSTANCE_OF && LA1_1<=TYPES)||LA1_1==IDENTIFIER) ) {
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
            case OPEN_CURLY_BRACES:
            case INVERSE:
            case DBLQUOTE:
            case ENTITY_REFERENCE:
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
                    int LA1_6 = input.LA(3);

                    if ( (LA1_6==INVERSE||(LA1_6>=INSTANCE_OF && LA1_6<=TYPES)||LA1_6==IDENTIFIER) ) {
                        alt1=3;
                    }
                    else if ( ((LA1_6>=AND && LA1_6<=OR)||(LA1_6>=SUBCLASS_OF && LA1_6<=EQUIVALENT_TO)||LA1_6==DISJOINT_WITH) ) {
                        alt1=1;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 1, 6, input);

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
                        new NoViableAltException("", 1, 3, input);

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
                    pushFollow(FOLLOW_binaryAxiom_in_axiom220);
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
                    pushFollow(FOLLOW_unaryAxiom_in_axiom232);
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
                    pushFollow(FOLLOW_assertionAxiom_in_axiom244);
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
    // MOWLParser.g:71:1: assertionAxiom : (i= IDENTIFIER ( INSTANCE_OF | TYPES ) expression -> ^( TYPE_ASSERTION ^( EXPRESSION expression ) ^( EXPRESSION $i) ) | IDENTIFIER propertyExpression value -> ^( ROLE_ASSERTION ^( EXPRESSION IDENTIFIER ) ^( EXPRESSION propertyExpression ) ^( EXPRESSION value ) ) | NOT assertionAxiom -> ^( NEGATED_ASSERTION assertionAxiom ) );
    public final ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase_MOWLParser.assertionAxiom_return assertionAxiom() throws RecognitionException {
        ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase_MOWLParser.assertionAxiom_return retval = new ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase_MOWLParser.assertionAxiom_return();
        retval.start = input.LT(1);

        ManchesterOWLSyntaxTree root_0 = null;

        Token i=null;
        Token INSTANCE_OF4=null;
        Token TYPES5=null;
        Token IDENTIFIER7=null;
        Token NOT10=null;
        ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase_MOWLParser.expression_return expression6 = null;

        ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase_MOWLParser.propertyExpression_return propertyExpression8 = null;

        ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase_MOWLParser.value_return value9 = null;

        ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase_MOWLParser.assertionAxiom_return assertionAxiom11 = null;


        ManchesterOWLSyntaxTree i_tree=null;
        ManchesterOWLSyntaxTree INSTANCE_OF4_tree=null;
        ManchesterOWLSyntaxTree TYPES5_tree=null;
        ManchesterOWLSyntaxTree IDENTIFIER7_tree=null;
        ManchesterOWLSyntaxTree NOT10_tree=null;
        RewriteRuleTokenStream stream_TYPES=new RewriteRuleTokenStream(adaptor,"token TYPES");
        RewriteRuleTokenStream stream_NOT=new RewriteRuleTokenStream(adaptor,"token NOT");
        RewriteRuleTokenStream stream_IDENTIFIER=new RewriteRuleTokenStream(adaptor,"token IDENTIFIER");
        RewriteRuleTokenStream stream_INSTANCE_OF=new RewriteRuleTokenStream(adaptor,"token INSTANCE_OF");
        RewriteRuleSubtreeStream stream_expression=new RewriteRuleSubtreeStream(adaptor,"rule expression");
        RewriteRuleSubtreeStream stream_propertyExpression=new RewriteRuleSubtreeStream(adaptor,"rule propertyExpression");
        RewriteRuleSubtreeStream stream_value=new RewriteRuleSubtreeStream(adaptor,"rule value");
        RewriteRuleSubtreeStream stream_assertionAxiom=new RewriteRuleSubtreeStream(adaptor,"rule assertionAxiom");
        try {
            // MOWLParser.g:71:15: (i= IDENTIFIER ( INSTANCE_OF | TYPES ) expression -> ^( TYPE_ASSERTION ^( EXPRESSION expression ) ^( EXPRESSION $i) ) | IDENTIFIER propertyExpression value -> ^( ROLE_ASSERTION ^( EXPRESSION IDENTIFIER ) ^( EXPRESSION propertyExpression ) ^( EXPRESSION value ) ) | NOT assertionAxiom -> ^( NEGATED_ASSERTION assertionAxiom ) )
            int alt3=3;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==IDENTIFIER) ) {
                int LA3_1 = input.LA(2);

                if ( ((LA3_1>=INSTANCE_OF && LA3_1<=TYPES)) ) {
                    alt3=1;
                }
                else if ( (LA3_1==INVERSE||LA3_1==IDENTIFIER) ) {
                    alt3=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 3, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA3_0==NOT) ) {
                alt3=3;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // MOWLParser.g:72:3: i= IDENTIFIER ( INSTANCE_OF | TYPES ) expression
                    {
                    i=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_assertionAxiom267); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_IDENTIFIER.add(i);

                    // MOWLParser.g:72:18: ( INSTANCE_OF | TYPES )
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
                            // MOWLParser.g:72:19: INSTANCE_OF
                            {
                            INSTANCE_OF4=(Token)match(input,INSTANCE_OF,FOLLOW_INSTANCE_OF_in_assertionAxiom270); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_INSTANCE_OF.add(INSTANCE_OF4);


                            }
                            break;
                        case 2 :
                            // MOWLParser.g:72:33: TYPES
                            {
                            TYPES5=(Token)match(input,TYPES,FOLLOW_TYPES_in_assertionAxiom274); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_TYPES.add(TYPES5);


                            }
                            break;

                    }

                    pushFollow(FOLLOW_expression_in_assertionAxiom277);
                    expression6=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_expression.add(expression6.getTree());


                    // AST REWRITE
                    // elements: expression, i
                    // token labels: i
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleTokenStream stream_i=new RewriteRuleTokenStream(adaptor,"token i",i);
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (ManchesterOWLSyntaxTree)adaptor.nil();
                    // 72:51: -> ^( TYPE_ASSERTION ^( EXPRESSION expression ) ^( EXPRESSION $i) )
                    {
                        // MOWLParser.g:72:54: ^( TYPE_ASSERTION ^( EXPRESSION expression ) ^( EXPRESSION $i) )
                        {
                        ManchesterOWLSyntaxTree root_1 = (ManchesterOWLSyntaxTree)adaptor.nil();
                        root_1 = (ManchesterOWLSyntaxTree)adaptor.becomeRoot((ManchesterOWLSyntaxTree)adaptor.create(TYPE_ASSERTION, "TYPE_ASSERTION"), root_1);

                        // MOWLParser.g:72:71: ^( EXPRESSION expression )
                        {
                        ManchesterOWLSyntaxTree root_2 = (ManchesterOWLSyntaxTree)adaptor.nil();
                        root_2 = (ManchesterOWLSyntaxTree)adaptor.becomeRoot((ManchesterOWLSyntaxTree)adaptor.create(EXPRESSION, "EXPRESSION"), root_2);

                        adaptor.addChild(root_2, stream_expression.nextTree());

                        adaptor.addChild(root_1, root_2);
                        }
                        // MOWLParser.g:72:96: ^( EXPRESSION $i)
                        {
                        ManchesterOWLSyntaxTree root_2 = (ManchesterOWLSyntaxTree)adaptor.nil();
                        root_2 = (ManchesterOWLSyntaxTree)adaptor.becomeRoot((ManchesterOWLSyntaxTree)adaptor.create(EXPRESSION, "EXPRESSION"), root_2);

                        adaptor.addChild(root_2, stream_i.nextNode());

                        adaptor.addChild(root_1, root_2);
                        }

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 2 :
                    // MOWLParser.g:73:6: IDENTIFIER propertyExpression value
                    {
                    IDENTIFIER7=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_assertionAxiom303); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_IDENTIFIER.add(IDENTIFIER7);

                    pushFollow(FOLLOW_propertyExpression_in_assertionAxiom305);
                    propertyExpression8=propertyExpression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_propertyExpression.add(propertyExpression8.getTree());
                    pushFollow(FOLLOW_value_in_assertionAxiom308);
                    value9=value();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_value.add(value9.getTree());


                    // AST REWRITE
                    // elements: value, propertyExpression, IDENTIFIER
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (ManchesterOWLSyntaxTree)adaptor.nil();
                    // 73:43: -> ^( ROLE_ASSERTION ^( EXPRESSION IDENTIFIER ) ^( EXPRESSION propertyExpression ) ^( EXPRESSION value ) )
                    {
                        // MOWLParser.g:73:46: ^( ROLE_ASSERTION ^( EXPRESSION IDENTIFIER ) ^( EXPRESSION propertyExpression ) ^( EXPRESSION value ) )
                        {
                        ManchesterOWLSyntaxTree root_1 = (ManchesterOWLSyntaxTree)adaptor.nil();
                        root_1 = (ManchesterOWLSyntaxTree)adaptor.becomeRoot((ManchesterOWLSyntaxTree)adaptor.create(ROLE_ASSERTION, "ROLE_ASSERTION"), root_1);

                        // MOWLParser.g:73:63: ^( EXPRESSION IDENTIFIER )
                        {
                        ManchesterOWLSyntaxTree root_2 = (ManchesterOWLSyntaxTree)adaptor.nil();
                        root_2 = (ManchesterOWLSyntaxTree)adaptor.becomeRoot((ManchesterOWLSyntaxTree)adaptor.create(EXPRESSION, "EXPRESSION"), root_2);

                        adaptor.addChild(root_2, stream_IDENTIFIER.nextNode());

                        adaptor.addChild(root_1, root_2);
                        }
                        // MOWLParser.g:73:88: ^( EXPRESSION propertyExpression )
                        {
                        ManchesterOWLSyntaxTree root_2 = (ManchesterOWLSyntaxTree)adaptor.nil();
                        root_2 = (ManchesterOWLSyntaxTree)adaptor.becomeRoot((ManchesterOWLSyntaxTree)adaptor.create(EXPRESSION, "EXPRESSION"), root_2);

                        adaptor.addChild(root_2, stream_propertyExpression.nextTree());

                        adaptor.addChild(root_1, root_2);
                        }
                        // MOWLParser.g:73:121: ^( EXPRESSION value )
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
                    NOT10=(Token)match(input,NOT,FOLLOW_NOT_in_assertionAxiom341); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_NOT.add(NOT10);

                    pushFollow(FOLLOW_assertionAxiom_in_assertionAxiom343);
                    assertionAxiom11=assertionAxiom();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_assertionAxiom.add(assertionAxiom11.getTree());


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
    // MOWLParser.g:80:1: binaryAxiom : (lhs= expression ( SUBCLASS_OF superClass= expression -> ^( SUB_CLASS_AXIOM ^( EXPRESSION $lhs) ^( EXPRESSION $superClass) ) | EQUIVALENT_TO rhs= expression -> ^( EQUIVALENT_TO_AXIOM ^( EXPRESSION $lhs) ^( EXPRESSION $rhs) ) | DISJOINT_WITH disjoint= expression -> ^( DISJOINT_WITH_AXIOM ^( EXPRESSION $lhs) ^( EXPRESSION $disjoint) ) | SUB_PROPERTY_OF superProperty= propertyExpression -> ^( SUB_PROPERTY_AXIOM ^( EXPRESSION $lhs) ^( EXPRESSION $superProperty) ) ) | lhsID= IDENTIFIER ( SAME_AS rhsID= IDENTIFIER -> ^( SAME_AS_AXIOM ^( EXPRESSION $lhsID) ^( EXPRESSION $rhsID) ) | DIFFERENT_FROM rhsID= IDENTIFIER -> ^( DIFFERENT_FROM_AXIOM ^( EXPRESSION $lhsID) ^( EXPRESSION $rhsID) ) | DOMAIN expression -> ^( DOMAIN ^( EXPRESSION $lhsID) ^( EXPRESSION expression ) ) | RANGE expression -> ^( RANGE ^( EXPRESSION $lhsID) ^( EXPRESSION expression ) ) | INVERSE_OF rhsID= IDENTIFIER -> ^( INVERSE_OF ^( EXPRESSION $lhsID) ^( EXPRESSION $rhsID) ) ) );
    public final ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase_MOWLParser.binaryAxiom_return binaryAxiom() throws RecognitionException {
        ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase_MOWLParser.binaryAxiom_return retval = new ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase_MOWLParser.binaryAxiom_return();
        retval.start = input.LT(1);

        ManchesterOWLSyntaxTree root_0 = null;

        Token lhsID=null;
        Token rhsID=null;
        Token SUBCLASS_OF12=null;
        Token EQUIVALENT_TO13=null;
        Token DISJOINT_WITH14=null;
        Token SUB_PROPERTY_OF15=null;
        Token SAME_AS16=null;
        Token DIFFERENT_FROM17=null;
        Token DOMAIN18=null;
        Token RANGE20=null;
        Token INVERSE_OF22=null;
        ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase_MOWLParser.expression_return lhs = null;

        ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase_MOWLParser.expression_return superClass = null;

        ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase_MOWLParser.expression_return rhs = null;

        ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase_MOWLParser.expression_return disjoint = null;

        ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase_MOWLParser.propertyExpression_return superProperty = null;

        ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase_MOWLParser.expression_return expression19 = null;

        ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase_MOWLParser.expression_return expression21 = null;


        ManchesterOWLSyntaxTree lhsID_tree=null;
        ManchesterOWLSyntaxTree rhsID_tree=null;
        ManchesterOWLSyntaxTree SUBCLASS_OF12_tree=null;
        ManchesterOWLSyntaxTree EQUIVALENT_TO13_tree=null;
        ManchesterOWLSyntaxTree DISJOINT_WITH14_tree=null;
        ManchesterOWLSyntaxTree SUB_PROPERTY_OF15_tree=null;
        ManchesterOWLSyntaxTree SAME_AS16_tree=null;
        ManchesterOWLSyntaxTree DIFFERENT_FROM17_tree=null;
        ManchesterOWLSyntaxTree DOMAIN18_tree=null;
        ManchesterOWLSyntaxTree RANGE20_tree=null;
        ManchesterOWLSyntaxTree INVERSE_OF22_tree=null;
        RewriteRuleTokenStream stream_SAME_AS=new RewriteRuleTokenStream(adaptor,"token SAME_AS");
        RewriteRuleTokenStream stream_RANGE=new RewriteRuleTokenStream(adaptor,"token RANGE");
        RewriteRuleTokenStream stream_DISJOINT_WITH=new RewriteRuleTokenStream(adaptor,"token DISJOINT_WITH");
        RewriteRuleTokenStream stream_INVERSE_OF=new RewriteRuleTokenStream(adaptor,"token INVERSE_OF");
        RewriteRuleTokenStream stream_DIFFERENT_FROM=new RewriteRuleTokenStream(adaptor,"token DIFFERENT_FROM");
        RewriteRuleTokenStream stream_EQUIVALENT_TO=new RewriteRuleTokenStream(adaptor,"token EQUIVALENT_TO");
        RewriteRuleTokenStream stream_SUBCLASS_OF=new RewriteRuleTokenStream(adaptor,"token SUBCLASS_OF");
        RewriteRuleTokenStream stream_IDENTIFIER=new RewriteRuleTokenStream(adaptor,"token IDENTIFIER");
        RewriteRuleTokenStream stream_DOMAIN=new RewriteRuleTokenStream(adaptor,"token DOMAIN");
        RewriteRuleTokenStream stream_SUB_PROPERTY_OF=new RewriteRuleTokenStream(adaptor,"token SUB_PROPERTY_OF");
        RewriteRuleSubtreeStream stream_expression=new RewriteRuleSubtreeStream(adaptor,"rule expression");
        RewriteRuleSubtreeStream stream_propertyExpression=new RewriteRuleSubtreeStream(adaptor,"rule propertyExpression");
        try {
            // MOWLParser.g:80:13: (lhs= expression ( SUBCLASS_OF superClass= expression -> ^( SUB_CLASS_AXIOM ^( EXPRESSION $lhs) ^( EXPRESSION $superClass) ) | EQUIVALENT_TO rhs= expression -> ^( EQUIVALENT_TO_AXIOM ^( EXPRESSION $lhs) ^( EXPRESSION $rhs) ) | DISJOINT_WITH disjoint= expression -> ^( DISJOINT_WITH_AXIOM ^( EXPRESSION $lhs) ^( EXPRESSION $disjoint) ) | SUB_PROPERTY_OF superProperty= propertyExpression -> ^( SUB_PROPERTY_AXIOM ^( EXPRESSION $lhs) ^( EXPRESSION $superProperty) ) ) | lhsID= IDENTIFIER ( SAME_AS rhsID= IDENTIFIER -> ^( SAME_AS_AXIOM ^( EXPRESSION $lhsID) ^( EXPRESSION $rhsID) ) | DIFFERENT_FROM rhsID= IDENTIFIER -> ^( DIFFERENT_FROM_AXIOM ^( EXPRESSION $lhsID) ^( EXPRESSION $rhsID) ) | DOMAIN expression -> ^( DOMAIN ^( EXPRESSION $lhsID) ^( EXPRESSION expression ) ) | RANGE expression -> ^( RANGE ^( EXPRESSION $lhsID) ^( EXPRESSION expression ) ) | INVERSE_OF rhsID= IDENTIFIER -> ^( INVERSE_OF ^( EXPRESSION $lhsID) ^( EXPRESSION $rhsID) ) ) )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==IDENTIFIER) ) {
                int LA6_1 = input.LA(2);

                if ( (LA6_1==COMPOSITION||(LA6_1>=AND && LA6_1<=OR)||(LA6_1>=SOME && LA6_1<=VALUE)||(LA6_1>=SUBCLASS_OF && LA6_1<=EQUIVALENT_TO)||LA6_1==DISJOINT_WITH) ) {
                    alt6=1;
                }
                else if ( ((LA6_1>=SAME_AS && LA6_1<=INVERSE_OF)||(LA6_1>=DOMAIN && LA6_1<=RANGE)) ) {
                    alt6=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 6, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA6_0==OPEN_CURLY_BRACES||LA6_0==NOT||LA6_0==INVERSE||LA6_0==DBLQUOTE||LA6_0==ENTITY_REFERENCE) ) {
                alt6=1;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // MOWLParser.g:81:5: lhs= expression ( SUBCLASS_OF superClass= expression -> ^( SUB_CLASS_AXIOM ^( EXPRESSION $lhs) ^( EXPRESSION $superClass) ) | EQUIVALENT_TO rhs= expression -> ^( EQUIVALENT_TO_AXIOM ^( EXPRESSION $lhs) ^( EXPRESSION $rhs) ) | DISJOINT_WITH disjoint= expression -> ^( DISJOINT_WITH_AXIOM ^( EXPRESSION $lhs) ^( EXPRESSION $disjoint) ) | SUB_PROPERTY_OF superProperty= propertyExpression -> ^( SUB_PROPERTY_AXIOM ^( EXPRESSION $lhs) ^( EXPRESSION $superProperty) ) )
                    {
                    pushFollow(FOLLOW_expression_in_binaryAxiom371);
                    lhs=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_expression.add(lhs.getTree());
                    // MOWLParser.g:83:17: ( SUBCLASS_OF superClass= expression -> ^( SUB_CLASS_AXIOM ^( EXPRESSION $lhs) ^( EXPRESSION $superClass) ) | EQUIVALENT_TO rhs= expression -> ^( EQUIVALENT_TO_AXIOM ^( EXPRESSION $lhs) ^( EXPRESSION $rhs) ) | DISJOINT_WITH disjoint= expression -> ^( DISJOINT_WITH_AXIOM ^( EXPRESSION $lhs) ^( EXPRESSION $disjoint) ) | SUB_PROPERTY_OF superProperty= propertyExpression -> ^( SUB_PROPERTY_AXIOM ^( EXPRESSION $lhs) ^( EXPRESSION $superProperty) ) )
                    int alt4=4;
                    switch ( input.LA(1) ) {
                    case SUBCLASS_OF:
                        {
                        alt4=1;
                        }
                        break;
                    case EQUIVALENT_TO:
                        {
                        alt4=2;
                        }
                        break;
                    case DISJOINT_WITH:
                        {
                        alt4=3;
                        }
                        break;
                    case SUB_PROPERTY_OF:
                        {
                        alt4=4;
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
                            // MOWLParser.g:84:17: SUBCLASS_OF superClass= expression
                            {
                            SUBCLASS_OF12=(Token)match(input,SUBCLASS_OF,FOLLOW_SUBCLASS_OF_in_binaryAxiom426); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_SUBCLASS_OF.add(SUBCLASS_OF12);

                            pushFollow(FOLLOW_expression_in_binaryAxiom433);
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
                            // 84:54: -> ^( SUB_CLASS_AXIOM ^( EXPRESSION $lhs) ^( EXPRESSION $superClass) )
                            {
                                // MOWLParser.g:84:57: ^( SUB_CLASS_AXIOM ^( EXPRESSION $lhs) ^( EXPRESSION $superClass) )
                                {
                                ManchesterOWLSyntaxTree root_1 = (ManchesterOWLSyntaxTree)adaptor.nil();
                                root_1 = (ManchesterOWLSyntaxTree)adaptor.becomeRoot((ManchesterOWLSyntaxTree)adaptor.create(SUB_CLASS_AXIOM, "SUB_CLASS_AXIOM"), root_1);

                                // MOWLParser.g:84:76: ^( EXPRESSION $lhs)
                                {
                                ManchesterOWLSyntaxTree root_2 = (ManchesterOWLSyntaxTree)adaptor.nil();
                                root_2 = (ManchesterOWLSyntaxTree)adaptor.becomeRoot((ManchesterOWLSyntaxTree)adaptor.create(EXPRESSION, "EXPRESSION"), root_2);

                                adaptor.addChild(root_2, stream_lhs.nextTree());

                                adaptor.addChild(root_1, root_2);
                                }
                                // MOWLParser.g:84:95: ^( EXPRESSION $superClass)
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
                            // MOWLParser.g:85:19: EQUIVALENT_TO rhs= expression
                            {
                            EQUIVALENT_TO13=(Token)match(input,EQUIVALENT_TO,FOLLOW_EQUIVALENT_TO_in_binaryAxiom474); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_EQUIVALENT_TO.add(EQUIVALENT_TO13);

                            pushFollow(FOLLOW_expression_in_binaryAxiom480);
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
                            // 85:50: -> ^( EQUIVALENT_TO_AXIOM ^( EXPRESSION $lhs) ^( EXPRESSION $rhs) )
                            {
                                // MOWLParser.g:85:53: ^( EQUIVALENT_TO_AXIOM ^( EXPRESSION $lhs) ^( EXPRESSION $rhs) )
                                {
                                ManchesterOWLSyntaxTree root_1 = (ManchesterOWLSyntaxTree)adaptor.nil();
                                root_1 = (ManchesterOWLSyntaxTree)adaptor.becomeRoot((ManchesterOWLSyntaxTree)adaptor.create(EQUIVALENT_TO_AXIOM, "EQUIVALENT_TO_AXIOM"), root_1);

                                // MOWLParser.g:85:75: ^( EXPRESSION $lhs)
                                {
                                ManchesterOWLSyntaxTree root_2 = (ManchesterOWLSyntaxTree)adaptor.nil();
                                root_2 = (ManchesterOWLSyntaxTree)adaptor.becomeRoot((ManchesterOWLSyntaxTree)adaptor.create(EXPRESSION, "EXPRESSION"), root_2);

                                adaptor.addChild(root_2, stream_lhs.nextTree());

                                adaptor.addChild(root_1, root_2);
                                }
                                // MOWLParser.g:85:94: ^( EXPRESSION $rhs)
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
                            // MOWLParser.g:86:19: DISJOINT_WITH disjoint= expression
                            {
                            DISJOINT_WITH14=(Token)match(input,DISJOINT_WITH,FOLLOW_DISJOINT_WITH_in_binaryAxiom520); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_DISJOINT_WITH.add(DISJOINT_WITH14);

                            pushFollow(FOLLOW_expression_in_binaryAxiom526);
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

                            root_0 = (ManchesterOWLSyntaxTree)adaptor.nil();
                            // 86:55: -> ^( DISJOINT_WITH_AXIOM ^( EXPRESSION $lhs) ^( EXPRESSION $disjoint) )
                            {
                                // MOWLParser.g:86:58: ^( DISJOINT_WITH_AXIOM ^( EXPRESSION $lhs) ^( EXPRESSION $disjoint) )
                                {
                                ManchesterOWLSyntaxTree root_1 = (ManchesterOWLSyntaxTree)adaptor.nil();
                                root_1 = (ManchesterOWLSyntaxTree)adaptor.becomeRoot((ManchesterOWLSyntaxTree)adaptor.create(DISJOINT_WITH_AXIOM, "DISJOINT_WITH_AXIOM"), root_1);

                                // MOWLParser.g:86:80: ^( EXPRESSION $lhs)
                                {
                                ManchesterOWLSyntaxTree root_2 = (ManchesterOWLSyntaxTree)adaptor.nil();
                                root_2 = (ManchesterOWLSyntaxTree)adaptor.becomeRoot((ManchesterOWLSyntaxTree)adaptor.create(EXPRESSION, "EXPRESSION"), root_2);

                                adaptor.addChild(root_2, stream_lhs.nextTree());

                                adaptor.addChild(root_1, root_2);
                                }
                                // MOWLParser.g:86:99: ^( EXPRESSION $disjoint)
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
                            // MOWLParser.g:87:19: SUB_PROPERTY_OF superProperty= propertyExpression
                            {
                            SUB_PROPERTY_OF15=(Token)match(input,SUB_PROPERTY_OF,FOLLOW_SUB_PROPERTY_OF_in_binaryAxiom566); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_SUB_PROPERTY_OF.add(SUB_PROPERTY_OF15);

                            pushFollow(FOLLOW_propertyExpression_in_binaryAxiom572);
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

                            root_0 = (ManchesterOWLSyntaxTree)adaptor.nil();
                            // 87:70: -> ^( SUB_PROPERTY_AXIOM ^( EXPRESSION $lhs) ^( EXPRESSION $superProperty) )
                            {
                                // MOWLParser.g:87:73: ^( SUB_PROPERTY_AXIOM ^( EXPRESSION $lhs) ^( EXPRESSION $superProperty) )
                                {
                                ManchesterOWLSyntaxTree root_1 = (ManchesterOWLSyntaxTree)adaptor.nil();
                                root_1 = (ManchesterOWLSyntaxTree)adaptor.becomeRoot((ManchesterOWLSyntaxTree)adaptor.create(SUB_PROPERTY_AXIOM, "SUB_PROPERTY_AXIOM"), root_1);

                                // MOWLParser.g:87:94: ^( EXPRESSION $lhs)
                                {
                                ManchesterOWLSyntaxTree root_2 = (ManchesterOWLSyntaxTree)adaptor.nil();
                                root_2 = (ManchesterOWLSyntaxTree)adaptor.becomeRoot((ManchesterOWLSyntaxTree)adaptor.create(EXPRESSION, "EXPRESSION"), root_2);

                                adaptor.addChild(root_2, stream_lhs.nextTree());

                                adaptor.addChild(root_1, root_2);
                                }
                                // MOWLParser.g:87:113: ^( EXPRESSION $superProperty)
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

                    }


                    }
                    break;
                case 2 :
                    // MOWLParser.g:90:5: lhsID= IDENTIFIER ( SAME_AS rhsID= IDENTIFIER -> ^( SAME_AS_AXIOM ^( EXPRESSION $lhsID) ^( EXPRESSION $rhsID) ) | DIFFERENT_FROM rhsID= IDENTIFIER -> ^( DIFFERENT_FROM_AXIOM ^( EXPRESSION $lhsID) ^( EXPRESSION $rhsID) ) | DOMAIN expression -> ^( DOMAIN ^( EXPRESSION $lhsID) ^( EXPRESSION expression ) ) | RANGE expression -> ^( RANGE ^( EXPRESSION $lhsID) ^( EXPRESSION expression ) ) | INVERSE_OF rhsID= IDENTIFIER -> ^( INVERSE_OF ^( EXPRESSION $lhsID) ^( EXPRESSION $rhsID) ) )
                    {
                    lhsID=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_binaryAxiom642); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_IDENTIFIER.add(lhsID);

                    // MOWLParser.g:90:25: ( SAME_AS rhsID= IDENTIFIER -> ^( SAME_AS_AXIOM ^( EXPRESSION $lhsID) ^( EXPRESSION $rhsID) ) | DIFFERENT_FROM rhsID= IDENTIFIER -> ^( DIFFERENT_FROM_AXIOM ^( EXPRESSION $lhsID) ^( EXPRESSION $rhsID) ) | DOMAIN expression -> ^( DOMAIN ^( EXPRESSION $lhsID) ^( EXPRESSION expression ) ) | RANGE expression -> ^( RANGE ^( EXPRESSION $lhsID) ^( EXPRESSION expression ) ) | INVERSE_OF rhsID= IDENTIFIER -> ^( INVERSE_OF ^( EXPRESSION $lhsID) ^( EXPRESSION $rhsID) ) )
                    int alt5=5;
                    switch ( input.LA(1) ) {
                    case SAME_AS:
                        {
                        alt5=1;
                        }
                        break;
                    case DIFFERENT_FROM:
                        {
                        alt5=2;
                        }
                        break;
                    case DOMAIN:
                        {
                        alt5=3;
                        }
                        break;
                    case RANGE:
                        {
                        alt5=4;
                        }
                        break;
                    case INVERSE_OF:
                        {
                        alt5=5;
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
                            // MOWLParser.g:91:21: SAME_AS rhsID= IDENTIFIER
                            {
                            SAME_AS16=(Token)match(input,SAME_AS,FOLLOW_SAME_AS_in_binaryAxiom667); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_SAME_AS.add(SAME_AS16);

                            rhsID=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_binaryAxiom674); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_IDENTIFIER.add(rhsID);



                            // AST REWRITE
                            // elements: lhsID, rhsID
                            // token labels: lhsID, rhsID
                            // rule labels: retval
                            // token list labels: 
                            // rule list labels: 
                            // wildcard labels: 
                            if ( state.backtracking==0 ) {
                            retval.tree = root_0;
                            RewriteRuleTokenStream stream_lhsID=new RewriteRuleTokenStream(adaptor,"token lhsID",lhsID);
                            RewriteRuleTokenStream stream_rhsID=new RewriteRuleTokenStream(adaptor,"token rhsID",rhsID);
                            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                            root_0 = (ManchesterOWLSyntaxTree)adaptor.nil();
                            // 91:49: -> ^( SAME_AS_AXIOM ^( EXPRESSION $lhsID) ^( EXPRESSION $rhsID) )
                            {
                                // MOWLParser.g:91:52: ^( SAME_AS_AXIOM ^( EXPRESSION $lhsID) ^( EXPRESSION $rhsID) )
                                {
                                ManchesterOWLSyntaxTree root_1 = (ManchesterOWLSyntaxTree)adaptor.nil();
                                root_1 = (ManchesterOWLSyntaxTree)adaptor.becomeRoot((ManchesterOWLSyntaxTree)adaptor.create(SAME_AS_AXIOM, "SAME_AS_AXIOM"), root_1);

                                // MOWLParser.g:91:68: ^( EXPRESSION $lhsID)
                                {
                                ManchesterOWLSyntaxTree root_2 = (ManchesterOWLSyntaxTree)adaptor.nil();
                                root_2 = (ManchesterOWLSyntaxTree)adaptor.becomeRoot((ManchesterOWLSyntaxTree)adaptor.create(EXPRESSION, "EXPRESSION"), root_2);

                                adaptor.addChild(root_2, stream_lhsID.nextNode());

                                adaptor.addChild(root_1, root_2);
                                }
                                // MOWLParser.g:91:90: ^( EXPRESSION $rhsID)
                                {
                                ManchesterOWLSyntaxTree root_2 = (ManchesterOWLSyntaxTree)adaptor.nil();
                                root_2 = (ManchesterOWLSyntaxTree)adaptor.becomeRoot((ManchesterOWLSyntaxTree)adaptor.create(EXPRESSION, "EXPRESSION"), root_2);

                                adaptor.addChild(root_2, stream_rhsID.nextNode());

                                adaptor.addChild(root_1, root_2);
                                }

                                adaptor.addChild(root_0, root_1);
                                }

                            }

                            retval.tree = root_0;}
                            }
                            break;
                        case 2 :
                            // MOWLParser.g:92:21: DIFFERENT_FROM rhsID= IDENTIFIER
                            {
                            DIFFERENT_FROM17=(Token)match(input,DIFFERENT_FROM,FOLLOW_DIFFERENT_FROM_in_binaryAxiom717); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_DIFFERENT_FROM.add(DIFFERENT_FROM17);

                            rhsID=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_binaryAxiom724); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_IDENTIFIER.add(rhsID);



                            // AST REWRITE
                            // elements: lhsID, rhsID
                            // token labels: lhsID, rhsID
                            // rule labels: retval
                            // token list labels: 
                            // rule list labels: 
                            // wildcard labels: 
                            if ( state.backtracking==0 ) {
                            retval.tree = root_0;
                            RewriteRuleTokenStream stream_lhsID=new RewriteRuleTokenStream(adaptor,"token lhsID",lhsID);
                            RewriteRuleTokenStream stream_rhsID=new RewriteRuleTokenStream(adaptor,"token rhsID",rhsID);
                            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                            root_0 = (ManchesterOWLSyntaxTree)adaptor.nil();
                            // 92:56: -> ^( DIFFERENT_FROM_AXIOM ^( EXPRESSION $lhsID) ^( EXPRESSION $rhsID) )
                            {
                                // MOWLParser.g:92:59: ^( DIFFERENT_FROM_AXIOM ^( EXPRESSION $lhsID) ^( EXPRESSION $rhsID) )
                                {
                                ManchesterOWLSyntaxTree root_1 = (ManchesterOWLSyntaxTree)adaptor.nil();
                                root_1 = (ManchesterOWLSyntaxTree)adaptor.becomeRoot((ManchesterOWLSyntaxTree)adaptor.create(DIFFERENT_FROM_AXIOM, "DIFFERENT_FROM_AXIOM"), root_1);

                                // MOWLParser.g:92:82: ^( EXPRESSION $lhsID)
                                {
                                ManchesterOWLSyntaxTree root_2 = (ManchesterOWLSyntaxTree)adaptor.nil();
                                root_2 = (ManchesterOWLSyntaxTree)adaptor.becomeRoot((ManchesterOWLSyntaxTree)adaptor.create(EXPRESSION, "EXPRESSION"), root_2);

                                adaptor.addChild(root_2, stream_lhsID.nextNode());

                                adaptor.addChild(root_1, root_2);
                                }
                                // MOWLParser.g:92:103: ^( EXPRESSION $rhsID)
                                {
                                ManchesterOWLSyntaxTree root_2 = (ManchesterOWLSyntaxTree)adaptor.nil();
                                root_2 = (ManchesterOWLSyntaxTree)adaptor.becomeRoot((ManchesterOWLSyntaxTree)adaptor.create(EXPRESSION, "EXPRESSION"), root_2);

                                adaptor.addChild(root_2, stream_rhsID.nextNode());

                                adaptor.addChild(root_1, root_2);
                                }

                                adaptor.addChild(root_0, root_1);
                                }

                            }

                            retval.tree = root_0;}
                            }
                            break;
                        case 3 :
                            // MOWLParser.g:93:21: DOMAIN expression
                            {
                            DOMAIN18=(Token)match(input,DOMAIN,FOLLOW_DOMAIN_in_binaryAxiom766); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_DOMAIN.add(DOMAIN18);

                            pushFollow(FOLLOW_expression_in_binaryAxiom768);
                            expression19=expression();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) stream_expression.add(expression19.getTree());


                            // AST REWRITE
                            // elements: expression, DOMAIN, lhsID
                            // token labels: lhsID
                            // rule labels: retval
                            // token list labels: 
                            // rule list labels: 
                            // wildcard labels: 
                            if ( state.backtracking==0 ) {
                            retval.tree = root_0;
                            RewriteRuleTokenStream stream_lhsID=new RewriteRuleTokenStream(adaptor,"token lhsID",lhsID);
                            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                            root_0 = (ManchesterOWLSyntaxTree)adaptor.nil();
                            // 93:39: -> ^( DOMAIN ^( EXPRESSION $lhsID) ^( EXPRESSION expression ) )
                            {
                                // MOWLParser.g:93:42: ^( DOMAIN ^( EXPRESSION $lhsID) ^( EXPRESSION expression ) )
                                {
                                ManchesterOWLSyntaxTree root_1 = (ManchesterOWLSyntaxTree)adaptor.nil();
                                root_1 = (ManchesterOWLSyntaxTree)adaptor.becomeRoot(stream_DOMAIN.nextNode(), root_1);

                                // MOWLParser.g:93:51: ^( EXPRESSION $lhsID)
                                {
                                ManchesterOWLSyntaxTree root_2 = (ManchesterOWLSyntaxTree)adaptor.nil();
                                root_2 = (ManchesterOWLSyntaxTree)adaptor.becomeRoot((ManchesterOWLSyntaxTree)adaptor.create(EXPRESSION, "EXPRESSION"), root_2);

                                adaptor.addChild(root_2, stream_lhsID.nextNode());

                                adaptor.addChild(root_1, root_2);
                                }
                                // MOWLParser.g:93:72: ^( EXPRESSION expression )
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
                        case 4 :
                            // MOWLParser.g:94:21: RANGE expression
                            {
                            RANGE20=(Token)match(input,RANGE,FOLLOW_RANGE_in_binaryAxiom809); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_RANGE.add(RANGE20);

                            pushFollow(FOLLOW_expression_in_binaryAxiom811);
                            expression21=expression();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) stream_expression.add(expression21.getTree());


                            // AST REWRITE
                            // elements: expression, lhsID, RANGE
                            // token labels: lhsID
                            // rule labels: retval
                            // token list labels: 
                            // rule list labels: 
                            // wildcard labels: 
                            if ( state.backtracking==0 ) {
                            retval.tree = root_0;
                            RewriteRuleTokenStream stream_lhsID=new RewriteRuleTokenStream(adaptor,"token lhsID",lhsID);
                            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                            root_0 = (ManchesterOWLSyntaxTree)adaptor.nil();
                            // 94:38: -> ^( RANGE ^( EXPRESSION $lhsID) ^( EXPRESSION expression ) )
                            {
                                // MOWLParser.g:94:41: ^( RANGE ^( EXPRESSION $lhsID) ^( EXPRESSION expression ) )
                                {
                                ManchesterOWLSyntaxTree root_1 = (ManchesterOWLSyntaxTree)adaptor.nil();
                                root_1 = (ManchesterOWLSyntaxTree)adaptor.becomeRoot(stream_RANGE.nextNode(), root_1);

                                // MOWLParser.g:94:49: ^( EXPRESSION $lhsID)
                                {
                                ManchesterOWLSyntaxTree root_2 = (ManchesterOWLSyntaxTree)adaptor.nil();
                                root_2 = (ManchesterOWLSyntaxTree)adaptor.becomeRoot((ManchesterOWLSyntaxTree)adaptor.create(EXPRESSION, "EXPRESSION"), root_2);

                                adaptor.addChild(root_2, stream_lhsID.nextNode());

                                adaptor.addChild(root_1, root_2);
                                }
                                // MOWLParser.g:94:70: ^( EXPRESSION expression )
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
                        case 5 :
                            // MOWLParser.g:95:21: INVERSE_OF rhsID= IDENTIFIER
                            {
                            INVERSE_OF22=(Token)match(input,INVERSE_OF,FOLLOW_INVERSE_OF_in_binaryAxiom852); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_INVERSE_OF.add(INVERSE_OF22);

                            rhsID=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_binaryAxiom858); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_IDENTIFIER.add(rhsID);



                            // AST REWRITE
                            // elements: INVERSE_OF, lhsID, rhsID
                            // token labels: lhsID, rhsID
                            // rule labels: retval
                            // token list labels: 
                            // rule list labels: 
                            // wildcard labels: 
                            if ( state.backtracking==0 ) {
                            retval.tree = root_0;
                            RewriteRuleTokenStream stream_lhsID=new RewriteRuleTokenStream(adaptor,"token lhsID",lhsID);
                            RewriteRuleTokenStream stream_rhsID=new RewriteRuleTokenStream(adaptor,"token rhsID",rhsID);
                            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                            root_0 = (ManchesterOWLSyntaxTree)adaptor.nil();
                            // 95:51: -> ^( INVERSE_OF ^( EXPRESSION $lhsID) ^( EXPRESSION $rhsID) )
                            {
                                // MOWLParser.g:95:54: ^( INVERSE_OF ^( EXPRESSION $lhsID) ^( EXPRESSION $rhsID) )
                                {
                                ManchesterOWLSyntaxTree root_1 = (ManchesterOWLSyntaxTree)adaptor.nil();
                                root_1 = (ManchesterOWLSyntaxTree)adaptor.becomeRoot(stream_INVERSE_OF.nextNode(), root_1);

                                // MOWLParser.g:95:67: ^( EXPRESSION $lhsID)
                                {
                                ManchesterOWLSyntaxTree root_2 = (ManchesterOWLSyntaxTree)adaptor.nil();
                                root_2 = (ManchesterOWLSyntaxTree)adaptor.becomeRoot((ManchesterOWLSyntaxTree)adaptor.create(EXPRESSION, "EXPRESSION"), root_2);

                                adaptor.addChild(root_2, stream_lhsID.nextNode());

                                adaptor.addChild(root_1, root_2);
                                }
                                // MOWLParser.g:95:88: ^( EXPRESSION $rhsID)
                                {
                                ManchesterOWLSyntaxTree root_2 = (ManchesterOWLSyntaxTree)adaptor.nil();
                                root_2 = (ManchesterOWLSyntaxTree)adaptor.becomeRoot((ManchesterOWLSyntaxTree)adaptor.create(EXPRESSION, "EXPRESSION"), root_2);

                                adaptor.addChild(root_2, stream_rhsID.nextNode());

                                adaptor.addChild(root_1, root_2);
                                }

                                adaptor.addChild(root_0, root_1);
                                }

                            }

                            retval.tree = root_0;}
                            }
                            break;

                    }


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
    // MOWLParser.g:100:1: unaryAxiom : unaryCharacteristic IDENTIFIER -> ^( UNARY_AXIOM unaryCharacteristic ^( EXPRESSION IDENTIFIER ) ) ;
    public final ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase_MOWLParser.unaryAxiom_return unaryAxiom() throws RecognitionException {
        ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase_MOWLParser.unaryAxiom_return retval = new ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase_MOWLParser.unaryAxiom_return();
        retval.start = input.LT(1);

        ManchesterOWLSyntaxTree root_0 = null;

        Token IDENTIFIER24=null;
        ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase_MOWLParser.unaryCharacteristic_return unaryCharacteristic23 = null;


        ManchesterOWLSyntaxTree IDENTIFIER24_tree=null;
        RewriteRuleTokenStream stream_IDENTIFIER=new RewriteRuleTokenStream(adaptor,"token IDENTIFIER");
        RewriteRuleSubtreeStream stream_unaryCharacteristic=new RewriteRuleSubtreeStream(adaptor,"rule unaryCharacteristic");
        try {
            // MOWLParser.g:100:13: ( unaryCharacteristic IDENTIFIER -> ^( UNARY_AXIOM unaryCharacteristic ^( EXPRESSION IDENTIFIER ) ) )
            // MOWLParser.g:101:4: unaryCharacteristic IDENTIFIER
            {
            pushFollow(FOLLOW_unaryCharacteristic_in_unaryAxiom943);
            unaryCharacteristic23=unaryCharacteristic();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_unaryCharacteristic.add(unaryCharacteristic23.getTree());
            IDENTIFIER24=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_unaryAxiom947); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_IDENTIFIER.add(IDENTIFIER24);



            // AST REWRITE
            // elements: IDENTIFIER, unaryCharacteristic
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (ManchesterOWLSyntaxTree)adaptor.nil();
            // 101:37: -> ^( UNARY_AXIOM unaryCharacteristic ^( EXPRESSION IDENTIFIER ) )
            {
                // MOWLParser.g:101:40: ^( UNARY_AXIOM unaryCharacteristic ^( EXPRESSION IDENTIFIER ) )
                {
                ManchesterOWLSyntaxTree root_1 = (ManchesterOWLSyntaxTree)adaptor.nil();
                root_1 = (ManchesterOWLSyntaxTree)adaptor.becomeRoot((ManchesterOWLSyntaxTree)adaptor.create(UNARY_AXIOM, "UNARY_AXIOM"), root_1);

                adaptor.addChild(root_1, stream_unaryCharacteristic.nextTree());
                // MOWLParser.g:101:74: ^( EXPRESSION IDENTIFIER )
                {
                ManchesterOWLSyntaxTree root_2 = (ManchesterOWLSyntaxTree)adaptor.nil();
                root_2 = (ManchesterOWLSyntaxTree)adaptor.becomeRoot((ManchesterOWLSyntaxTree)adaptor.create(EXPRESSION, "EXPRESSION"), root_2);

                adaptor.addChild(root_2, stream_IDENTIFIER.nextNode());

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
    // MOWLParser.g:104:1: unaryCharacteristic : ( FUNCTIONAL -> ^( FUNCTIONAL ) | INVERSE_FUNCTIONAL -> ^( INVERSE_FUNCTIONAL ) | SYMMETRIC -> ^( SYMMETRIC ) | ANTI_SYMMETRIC -> ^( ANTI_SYMMETRIC ) | REFLEXIVE -> ^( REFLEXIVE ) | IRREFLEXIVE -> ^( IRREFLEXIVE ) | TRANSITIVE -> ^( TRANSITIVE ) );
    public final ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase_MOWLParser.unaryCharacteristic_return unaryCharacteristic() throws RecognitionException {
        ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase_MOWLParser.unaryCharacteristic_return retval = new ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase_MOWLParser.unaryCharacteristic_return();
        retval.start = input.LT(1);

        ManchesterOWLSyntaxTree root_0 = null;

        Token FUNCTIONAL25=null;
        Token INVERSE_FUNCTIONAL26=null;
        Token SYMMETRIC27=null;
        Token ANTI_SYMMETRIC28=null;
        Token REFLEXIVE29=null;
        Token IRREFLEXIVE30=null;
        Token TRANSITIVE31=null;

        ManchesterOWLSyntaxTree FUNCTIONAL25_tree=null;
        ManchesterOWLSyntaxTree INVERSE_FUNCTIONAL26_tree=null;
        ManchesterOWLSyntaxTree SYMMETRIC27_tree=null;
        ManchesterOWLSyntaxTree ANTI_SYMMETRIC28_tree=null;
        ManchesterOWLSyntaxTree REFLEXIVE29_tree=null;
        ManchesterOWLSyntaxTree IRREFLEXIVE30_tree=null;
        ManchesterOWLSyntaxTree TRANSITIVE31_tree=null;
        RewriteRuleTokenStream stream_REFLEXIVE=new RewriteRuleTokenStream(adaptor,"token REFLEXIVE");
        RewriteRuleTokenStream stream_SYMMETRIC=new RewriteRuleTokenStream(adaptor,"token SYMMETRIC");
        RewriteRuleTokenStream stream_FUNCTIONAL=new RewriteRuleTokenStream(adaptor,"token FUNCTIONAL");
        RewriteRuleTokenStream stream_TRANSITIVE=new RewriteRuleTokenStream(adaptor,"token TRANSITIVE");
        RewriteRuleTokenStream stream_ANTI_SYMMETRIC=new RewriteRuleTokenStream(adaptor,"token ANTI_SYMMETRIC");
        RewriteRuleTokenStream stream_INVERSE_FUNCTIONAL=new RewriteRuleTokenStream(adaptor,"token INVERSE_FUNCTIONAL");
        RewriteRuleTokenStream stream_IRREFLEXIVE=new RewriteRuleTokenStream(adaptor,"token IRREFLEXIVE");

        try {
            // MOWLParser.g:104:21: ( FUNCTIONAL -> ^( FUNCTIONAL ) | INVERSE_FUNCTIONAL -> ^( INVERSE_FUNCTIONAL ) | SYMMETRIC -> ^( SYMMETRIC ) | ANTI_SYMMETRIC -> ^( ANTI_SYMMETRIC ) | REFLEXIVE -> ^( REFLEXIVE ) | IRREFLEXIVE -> ^( IRREFLEXIVE ) | TRANSITIVE -> ^( TRANSITIVE ) )
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
                    // MOWLParser.g:105:5: FUNCTIONAL
                    {
                    FUNCTIONAL25=(Token)match(input,FUNCTIONAL,FOLLOW_FUNCTIONAL_in_unaryCharacteristic992); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_FUNCTIONAL.add(FUNCTIONAL25);



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
                    // 105:16: -> ^( FUNCTIONAL )
                    {
                        // MOWLParser.g:105:19: ^( FUNCTIONAL )
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
                    // MOWLParser.g:106:7: INVERSE_FUNCTIONAL
                    {
                    INVERSE_FUNCTIONAL26=(Token)match(input,INVERSE_FUNCTIONAL,FOLLOW_INVERSE_FUNCTIONAL_in_unaryCharacteristic1006); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_INVERSE_FUNCTIONAL.add(INVERSE_FUNCTIONAL26);



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
                    // 106:26: -> ^( INVERSE_FUNCTIONAL )
                    {
                        // MOWLParser.g:106:29: ^( INVERSE_FUNCTIONAL )
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
                    // MOWLParser.g:107:7: SYMMETRIC
                    {
                    SYMMETRIC27=(Token)match(input,SYMMETRIC,FOLLOW_SYMMETRIC_in_unaryCharacteristic1020); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_SYMMETRIC.add(SYMMETRIC27);



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
                    // 107:17: -> ^( SYMMETRIC )
                    {
                        // MOWLParser.g:107:20: ^( SYMMETRIC )
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
                    // MOWLParser.g:108:7: ANTI_SYMMETRIC
                    {
                    ANTI_SYMMETRIC28=(Token)match(input,ANTI_SYMMETRIC,FOLLOW_ANTI_SYMMETRIC_in_unaryCharacteristic1034); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_ANTI_SYMMETRIC.add(ANTI_SYMMETRIC28);



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
                    // 108:22: -> ^( ANTI_SYMMETRIC )
                    {
                        // MOWLParser.g:108:25: ^( ANTI_SYMMETRIC )
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
                    // MOWLParser.g:109:7: REFLEXIVE
                    {
                    REFLEXIVE29=(Token)match(input,REFLEXIVE,FOLLOW_REFLEXIVE_in_unaryCharacteristic1048); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_REFLEXIVE.add(REFLEXIVE29);



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
                    // 109:17: -> ^( REFLEXIVE )
                    {
                        // MOWLParser.g:109:20: ^( REFLEXIVE )
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
                    // MOWLParser.g:110:7: IRREFLEXIVE
                    {
                    IRREFLEXIVE30=(Token)match(input,IRREFLEXIVE,FOLLOW_IRREFLEXIVE_in_unaryCharacteristic1062); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_IRREFLEXIVE.add(IRREFLEXIVE30);



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
                    // 110:19: -> ^( IRREFLEXIVE )
                    {
                        // MOWLParser.g:110:22: ^( IRREFLEXIVE )
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
                    // MOWLParser.g:111:7: TRANSITIVE
                    {
                    TRANSITIVE31=(Token)match(input,TRANSITIVE,FOLLOW_TRANSITIVE_in_unaryCharacteristic1076); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_TRANSITIVE.add(TRANSITIVE31);



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
                    // 111:18: -> ^( TRANSITIVE )
                    {
                        // MOWLParser.g:111:21: ^( TRANSITIVE )
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
    // MOWLParser.g:114:1: expression : ( options {backtrack=true; } : head= propertyExpression ( COMPOSITION rest+= propertyExpression )+ -> ^( PROPERTY_CHAIN $head $rest) | conjunction ( OR conjunction )* -> ^( DISJUNCTION ( conjunction )+ ) | complexPropertyExpression -> ^( complexPropertyExpression ) ) ;
    public final ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase_MOWLParser.expression_return expression() throws RecognitionException {
        ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase_MOWLParser.expression_return retval = new ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase_MOWLParser.expression_return();
        retval.start = input.LT(1);

        ManchesterOWLSyntaxTree root_0 = null;

        Token COMPOSITION32=null;
        Token OR34=null;
        List list_rest=null;
        ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase_MOWLParser.propertyExpression_return head = null;

        ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase_MOWLParser.conjunction_return conjunction33 = null;

        ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase_MOWLParser.conjunction_return conjunction35 = null;

        ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase_MOWLParser.complexPropertyExpression_return complexPropertyExpression36 = null;

        RuleReturnScope rest = null;
        ManchesterOWLSyntaxTree COMPOSITION32_tree=null;
        ManchesterOWLSyntaxTree OR34_tree=null;
        RewriteRuleTokenStream stream_COMPOSITION=new RewriteRuleTokenStream(adaptor,"token COMPOSITION");
        RewriteRuleTokenStream stream_OR=new RewriteRuleTokenStream(adaptor,"token OR");
        RewriteRuleSubtreeStream stream_propertyExpression=new RewriteRuleSubtreeStream(adaptor,"rule propertyExpression");
        RewriteRuleSubtreeStream stream_conjunction=new RewriteRuleSubtreeStream(adaptor,"rule conjunction");
        RewriteRuleSubtreeStream stream_complexPropertyExpression=new RewriteRuleSubtreeStream(adaptor,"rule complexPropertyExpression");
        try {
            // MOWLParser.g:114:11: ( ( options {backtrack=true; } : head= propertyExpression ( COMPOSITION rest+= propertyExpression )+ -> ^( PROPERTY_CHAIN $head $rest) | conjunction ( OR conjunction )* -> ^( DISJUNCTION ( conjunction )+ ) | complexPropertyExpression -> ^( complexPropertyExpression ) ) )
            // MOWLParser.g:115:5: ( options {backtrack=true; } : head= propertyExpression ( COMPOSITION rest+= propertyExpression )+ -> ^( PROPERTY_CHAIN $head $rest) | conjunction ( OR conjunction )* -> ^( DISJUNCTION ( conjunction )+ ) | complexPropertyExpression -> ^( complexPropertyExpression ) )
            {
            // MOWLParser.g:115:5: ( options {backtrack=true; } : head= propertyExpression ( COMPOSITION rest+= propertyExpression )+ -> ^( PROPERTY_CHAIN $head $rest) | conjunction ( OR conjunction )* -> ^( DISJUNCTION ( conjunction )+ ) | complexPropertyExpression -> ^( complexPropertyExpression ) )
            int alt10=3;
            switch ( input.LA(1) ) {
            case IDENTIFIER:
                {
                int LA10_1 = input.LA(2);

                if ( (synpred1_MOWLParser()) ) {
                    alt10=1;
                }
                else if ( (synpred2_MOWLParser()) ) {
                    alt10=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 10, 1, input);

                    throw nvae;
                }
                }
                break;
            case INVERSE:
                {
                int LA10_2 = input.LA(2);

                if ( (synpred1_MOWLParser()) ) {
                    alt10=1;
                }
                else if ( (synpred2_MOWLParser()) ) {
                    alt10=2;
                }
                else if ( (true) ) {
                    alt10=3;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 10, 2, input);

                    throw nvae;
                }
                }
                break;
            case OPEN_CURLY_BRACES:
            case NOT:
            case DBLQUOTE:
            case ENTITY_REFERENCE:
                {
                alt10=2;
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
                    // MOWLParser.g:117:4: head= propertyExpression ( COMPOSITION rest+= propertyExpression )+
                    {
                    pushFollow(FOLLOW_propertyExpression_in_expression1121);
                    head=propertyExpression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_propertyExpression.add(head.getTree());
                    // MOWLParser.g:117:30: ( COMPOSITION rest+= propertyExpression )+
                    int cnt8=0;
                    loop8:
                    do {
                        int alt8=2;
                        int LA8_0 = input.LA(1);

                        if ( (LA8_0==COMPOSITION) ) {
                            alt8=1;
                        }


                        switch (alt8) {
                    	case 1 :
                    	    // MOWLParser.g:117:31: COMPOSITION rest+= propertyExpression
                    	    {
                    	    COMPOSITION32=(Token)match(input,COMPOSITION,FOLLOW_COMPOSITION_in_expression1124); if (state.failed) return retval; 
                    	    if ( state.backtracking==0 ) stream_COMPOSITION.add(COMPOSITION32);

                    	    pushFollow(FOLLOW_propertyExpression_in_expression1128);
                    	    rest=propertyExpression();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) stream_propertyExpression.add(rest.getTree());
                    	    if (list_rest==null) list_rest=new ArrayList();
                    	    list_rest.add(rest.getTree());


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt8 >= 1 ) break loop8;
                    	    if (state.backtracking>0) {state.failed=true; return retval;}
                                EarlyExitException eee =
                                    new EarlyExitException(8, input);
                                throw eee;
                        }
                        cnt8++;
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
                    root_0 = (ManchesterOWLSyntaxTree)adaptor.nil();
                    // 117:71: -> ^( PROPERTY_CHAIN $head $rest)
                    {
                        // MOWLParser.g:117:74: ^( PROPERTY_CHAIN $head $rest)
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
                    // MOWLParser.g:118:6: conjunction ( OR conjunction )*
                    {
                    pushFollow(FOLLOW_conjunction_in_expression1151);
                    conjunction33=conjunction();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_conjunction.add(conjunction33.getTree());
                    // MOWLParser.g:118:18: ( OR conjunction )*
                    loop9:
                    do {
                        int alt9=2;
                        int LA9_0 = input.LA(1);

                        if ( (LA9_0==OR) ) {
                            alt9=1;
                        }


                        switch (alt9) {
                    	case 1 :
                    	    // MOWLParser.g:118:19: OR conjunction
                    	    {
                    	    OR34=(Token)match(input,OR,FOLLOW_OR_in_expression1154); if (state.failed) return retval; 
                    	    if ( state.backtracking==0 ) stream_OR.add(OR34);

                    	    pushFollow(FOLLOW_conjunction_in_expression1156);
                    	    conjunction35=conjunction();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) stream_conjunction.add(conjunction35.getTree());

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

                    root_0 = (ManchesterOWLSyntaxTree)adaptor.nil();
                    // 118:36: -> ^( DISJUNCTION ( conjunction )+ )
                    {
                        // MOWLParser.g:118:39: ^( DISJUNCTION ( conjunction )+ )
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
                case 3 :
                    // MOWLParser.g:119:6: complexPropertyExpression
                    {
                    pushFollow(FOLLOW_complexPropertyExpression_in_expression1175);
                    complexPropertyExpression36=complexPropertyExpression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_complexPropertyExpression.add(complexPropertyExpression36.getTree());


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
                    // 119:32: -> ^( complexPropertyExpression )
                    {
                        // MOWLParser.g:119:35: ^( complexPropertyExpression )
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
    // MOWLParser.g:126:1: conjunction : unary ( AND unary )* -> ^( CONJUNCTION ( unary )+ ) ;
    public final ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase_MOWLParser.conjunction_return conjunction() throws RecognitionException {
        ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase_MOWLParser.conjunction_return retval = new ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase_MOWLParser.conjunction_return();
        retval.start = input.LT(1);

        ManchesterOWLSyntaxTree root_0 = null;

        Token AND38=null;
        ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase_MOWLParser.unary_return unary37 = null;

        ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase_MOWLParser.unary_return unary39 = null;


        ManchesterOWLSyntaxTree AND38_tree=null;
        RewriteRuleTokenStream stream_AND=new RewriteRuleTokenStream(adaptor,"token AND");
        RewriteRuleSubtreeStream stream_unary=new RewriteRuleSubtreeStream(adaptor,"rule unary");
        try {
            // MOWLParser.g:126:13: ( unary ( AND unary )* -> ^( CONJUNCTION ( unary )+ ) )
            // MOWLParser.g:127:5: unary ( AND unary )*
            {
            pushFollow(FOLLOW_unary_in_conjunction1207);
            unary37=unary();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_unary.add(unary37.getTree());
            // MOWLParser.g:127:11: ( AND unary )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==AND) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // MOWLParser.g:127:12: AND unary
            	    {
            	    AND38=(Token)match(input,AND,FOLLOW_AND_in_conjunction1210); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_AND.add(AND38);

            	    pushFollow(FOLLOW_unary_in_conjunction1212);
            	    unary39=unary();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_unary.add(unary39.getTree());

            	    }
            	    break;

            	default :
            	    break loop11;
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
            // 127:24: -> ^( CONJUNCTION ( unary )+ )
            {
                // MOWLParser.g:127:27: ^( CONJUNCTION ( unary )+ )
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
    // MOWLParser.g:130:1: complexPropertyExpression : ( INVERSE OPEN_PARENTHESYS complexPropertyExpression CLOSED_PARENTHESYS -> ^( INVERSE_OBJECT_PROPERTY_EXPRESSION complexPropertyExpression ) | INVERSE OPEN_PARENTHESYS IDENTIFIER CLOSED_PARENTHESYS -> ^( INVERSE_OBJECT_PROPERTY_EXPRESSION IDENTIFIER ) );
    public final ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase_MOWLParser.complexPropertyExpression_return complexPropertyExpression() throws RecognitionException {
        ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase_MOWLParser.complexPropertyExpression_return retval = new ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase_MOWLParser.complexPropertyExpression_return();
        retval.start = input.LT(1);

        ManchesterOWLSyntaxTree root_0 = null;

        Token INVERSE40=null;
        Token OPEN_PARENTHESYS41=null;
        Token CLOSED_PARENTHESYS43=null;
        Token INVERSE44=null;
        Token OPEN_PARENTHESYS45=null;
        Token IDENTIFIER46=null;
        Token CLOSED_PARENTHESYS47=null;
        ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase_MOWLParser.complexPropertyExpression_return complexPropertyExpression42 = null;


        ManchesterOWLSyntaxTree INVERSE40_tree=null;
        ManchesterOWLSyntaxTree OPEN_PARENTHESYS41_tree=null;
        ManchesterOWLSyntaxTree CLOSED_PARENTHESYS43_tree=null;
        ManchesterOWLSyntaxTree INVERSE44_tree=null;
        ManchesterOWLSyntaxTree OPEN_PARENTHESYS45_tree=null;
        ManchesterOWLSyntaxTree IDENTIFIER46_tree=null;
        ManchesterOWLSyntaxTree CLOSED_PARENTHESYS47_tree=null;
        RewriteRuleTokenStream stream_INVERSE=new RewriteRuleTokenStream(adaptor,"token INVERSE");
        RewriteRuleTokenStream stream_CLOSED_PARENTHESYS=new RewriteRuleTokenStream(adaptor,"token CLOSED_PARENTHESYS");
        RewriteRuleTokenStream stream_IDENTIFIER=new RewriteRuleTokenStream(adaptor,"token IDENTIFIER");
        RewriteRuleTokenStream stream_OPEN_PARENTHESYS=new RewriteRuleTokenStream(adaptor,"token OPEN_PARENTHESYS");
        RewriteRuleSubtreeStream stream_complexPropertyExpression=new RewriteRuleSubtreeStream(adaptor,"rule complexPropertyExpression");
        try {
            // MOWLParser.g:130:26: ( INVERSE OPEN_PARENTHESYS complexPropertyExpression CLOSED_PARENTHESYS -> ^( INVERSE_OBJECT_PROPERTY_EXPRESSION complexPropertyExpression ) | INVERSE OPEN_PARENTHESYS IDENTIFIER CLOSED_PARENTHESYS -> ^( INVERSE_OBJECT_PROPERTY_EXPRESSION IDENTIFIER ) )
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==INVERSE) ) {
                int LA12_1 = input.LA(2);

                if ( (LA12_1==OPEN_PARENTHESYS) ) {
                    int LA12_2 = input.LA(3);

                    if ( (LA12_2==IDENTIFIER) ) {
                        alt12=2;
                    }
                    else if ( (LA12_2==INVERSE) ) {
                        alt12=1;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 12, 2, input);

                        throw nvae;
                    }
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 12, 1, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;
            }
            switch (alt12) {
                case 1 :
                    // MOWLParser.g:131:2: INVERSE OPEN_PARENTHESYS complexPropertyExpression CLOSED_PARENTHESYS
                    {
                    INVERSE40=(Token)match(input,INVERSE,FOLLOW_INVERSE_in_complexPropertyExpression1233); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_INVERSE.add(INVERSE40);

                    OPEN_PARENTHESYS41=(Token)match(input,OPEN_PARENTHESYS,FOLLOW_OPEN_PARENTHESYS_in_complexPropertyExpression1235); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_OPEN_PARENTHESYS.add(OPEN_PARENTHESYS41);

                    pushFollow(FOLLOW_complexPropertyExpression_in_complexPropertyExpression1237);
                    complexPropertyExpression42=complexPropertyExpression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_complexPropertyExpression.add(complexPropertyExpression42.getTree());
                    CLOSED_PARENTHESYS43=(Token)match(input,CLOSED_PARENTHESYS,FOLLOW_CLOSED_PARENTHESYS_in_complexPropertyExpression1239); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_CLOSED_PARENTHESYS.add(CLOSED_PARENTHESYS43);



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
                    // 131:72: -> ^( INVERSE_OBJECT_PROPERTY_EXPRESSION complexPropertyExpression )
                    {
                        // MOWLParser.g:131:75: ^( INVERSE_OBJECT_PROPERTY_EXPRESSION complexPropertyExpression )
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
                    // MOWLParser.g:132:4: INVERSE OPEN_PARENTHESYS IDENTIFIER CLOSED_PARENTHESYS
                    {
                    INVERSE44=(Token)match(input,INVERSE,FOLLOW_INVERSE_in_complexPropertyExpression1252); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_INVERSE.add(INVERSE44);

                    OPEN_PARENTHESYS45=(Token)match(input,OPEN_PARENTHESYS,FOLLOW_OPEN_PARENTHESYS_in_complexPropertyExpression1254); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_OPEN_PARENTHESYS.add(OPEN_PARENTHESYS45);

                    IDENTIFIER46=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_complexPropertyExpression1256); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_IDENTIFIER.add(IDENTIFIER46);

                    CLOSED_PARENTHESYS47=(Token)match(input,CLOSED_PARENTHESYS,FOLLOW_CLOSED_PARENTHESYS_in_complexPropertyExpression1258); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_CLOSED_PARENTHESYS.add(CLOSED_PARENTHESYS47);



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
                    // 132:58: -> ^( INVERSE_OBJECT_PROPERTY_EXPRESSION IDENTIFIER )
                    {
                        // MOWLParser.g:132:61: ^( INVERSE_OBJECT_PROPERTY_EXPRESSION IDENTIFIER )
                        {
                        ManchesterOWLSyntaxTree root_1 = (ManchesterOWLSyntaxTree)adaptor.nil();
                        root_1 = (ManchesterOWLSyntaxTree)adaptor.becomeRoot((ManchesterOWLSyntaxTree)adaptor.create(INVERSE_OBJECT_PROPERTY_EXPRESSION, "INVERSE_OBJECT_PROPERTY_EXPRESSION"), root_1);

                        adaptor.addChild(root_1, stream_IDENTIFIER.nextNode());

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
    // MOWLParser.g:135:1: unary : ( IDENTIFIER | NOT OPEN_PARENTHESYS expression CLOSED_PARENTHESYS -> ^( NEGATED_EXPRESSION expression ) | NOT IDENTIFIER -> ^( NEGATED_EXPRESSION IDENTIFIER ) | ENTITY_REFERENCE -> ^( ENTITY_REFERENCE ) | qualifiedRestriction -> ^( qualifiedRestriction ) | constant );
    public final ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase_MOWLParser.unary_return unary() throws RecognitionException {
        ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase_MOWLParser.unary_return retval = new ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase_MOWLParser.unary_return();
        retval.start = input.LT(1);

        ManchesterOWLSyntaxTree root_0 = null;

        Token IDENTIFIER48=null;
        Token NOT49=null;
        Token OPEN_PARENTHESYS50=null;
        Token CLOSED_PARENTHESYS52=null;
        Token NOT53=null;
        Token IDENTIFIER54=null;
        Token ENTITY_REFERENCE55=null;
        ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase_MOWLParser.expression_return expression51 = null;

        ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase_MOWLParser.qualifiedRestriction_return qualifiedRestriction56 = null;

        ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase_MOWLParser.constant_return constant57 = null;


        ManchesterOWLSyntaxTree IDENTIFIER48_tree=null;
        ManchesterOWLSyntaxTree NOT49_tree=null;
        ManchesterOWLSyntaxTree OPEN_PARENTHESYS50_tree=null;
        ManchesterOWLSyntaxTree CLOSED_PARENTHESYS52_tree=null;
        ManchesterOWLSyntaxTree NOT53_tree=null;
        ManchesterOWLSyntaxTree IDENTIFIER54_tree=null;
        ManchesterOWLSyntaxTree ENTITY_REFERENCE55_tree=null;
        RewriteRuleTokenStream stream_ENTITY_REFERENCE=new RewriteRuleTokenStream(adaptor,"token ENTITY_REFERENCE");
        RewriteRuleTokenStream stream_NOT=new RewriteRuleTokenStream(adaptor,"token NOT");
        RewriteRuleTokenStream stream_CLOSED_PARENTHESYS=new RewriteRuleTokenStream(adaptor,"token CLOSED_PARENTHESYS");
        RewriteRuleTokenStream stream_IDENTIFIER=new RewriteRuleTokenStream(adaptor,"token IDENTIFIER");
        RewriteRuleTokenStream stream_OPEN_PARENTHESYS=new RewriteRuleTokenStream(adaptor,"token OPEN_PARENTHESYS");
        RewriteRuleSubtreeStream stream_expression=new RewriteRuleSubtreeStream(adaptor,"rule expression");
        RewriteRuleSubtreeStream stream_qualifiedRestriction=new RewriteRuleSubtreeStream(adaptor,"rule qualifiedRestriction");
        try {
            // MOWLParser.g:135:7: ( IDENTIFIER | NOT OPEN_PARENTHESYS expression CLOSED_PARENTHESYS -> ^( NEGATED_EXPRESSION expression ) | NOT IDENTIFIER -> ^( NEGATED_EXPRESSION IDENTIFIER ) | ENTITY_REFERENCE -> ^( ENTITY_REFERENCE ) | qualifiedRestriction -> ^( qualifiedRestriction ) | constant )
            int alt13=6;
            switch ( input.LA(1) ) {
            case IDENTIFIER:
                {
                int LA13_1 = input.LA(2);

                if ( ((LA13_1>=SOME && LA13_1<=VALUE)) ) {
                    alt13=5;
                }
                else if ( (LA13_1==EOF||LA13_1==CLOSED_PARENTHESYS||(LA13_1>=AND && LA13_1<=OR)||(LA13_1>=SUBCLASS_OF && LA13_1<=EQUIVALENT_TO)||LA13_1==DISJOINT_WITH||LA13_1==IDENTIFIER) ) {
                    alt13=1;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 13, 1, input);

                    throw nvae;
                }
                }
                break;
            case NOT:
                {
                int LA13_2 = input.LA(2);

                if ( (LA13_2==OPEN_PARENTHESYS) ) {
                    alt13=2;
                }
                else if ( (LA13_2==IDENTIFIER) ) {
                    alt13=3;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 13, 2, input);

                    throw nvae;
                }
                }
                break;
            case ENTITY_REFERENCE:
                {
                alt13=4;
                }
                break;
            case OPEN_CURLY_BRACES:
            case INVERSE:
                {
                alt13=5;
                }
                break;
            case DBLQUOTE:
                {
                alt13=6;
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
                    // MOWLParser.g:136:3: IDENTIFIER
                    {
                    root_0 = (ManchesterOWLSyntaxTree)adaptor.nil();

                    IDENTIFIER48=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_unary1278); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDENTIFIER48_tree = (ManchesterOWLSyntaxTree)adaptor.create(IDENTIFIER48);
                    adaptor.addChild(root_0, IDENTIFIER48_tree);
                    }

                    }
                    break;
                case 2 :
                    // MOWLParser.g:137:5: NOT OPEN_PARENTHESYS expression CLOSED_PARENTHESYS
                    {
                    NOT49=(Token)match(input,NOT,FOLLOW_NOT_in_unary1285); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_NOT.add(NOT49);

                    OPEN_PARENTHESYS50=(Token)match(input,OPEN_PARENTHESYS,FOLLOW_OPEN_PARENTHESYS_in_unary1287); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_OPEN_PARENTHESYS.add(OPEN_PARENTHESYS50);

                    pushFollow(FOLLOW_expression_in_unary1289);
                    expression51=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_expression.add(expression51.getTree());
                    CLOSED_PARENTHESYS52=(Token)match(input,CLOSED_PARENTHESYS,FOLLOW_CLOSED_PARENTHESYS_in_unary1291); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_CLOSED_PARENTHESYS.add(CLOSED_PARENTHESYS52);



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
                    // 137:56: -> ^( NEGATED_EXPRESSION expression )
                    {
                        // MOWLParser.g:137:59: ^( NEGATED_EXPRESSION expression )
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
                    // MOWLParser.g:138:5: NOT IDENTIFIER
                    {
                    NOT53=(Token)match(input,NOT,FOLLOW_NOT_in_unary1305); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_NOT.add(NOT53);

                    IDENTIFIER54=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_unary1307); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_IDENTIFIER.add(IDENTIFIER54);



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
                    // 138:20: -> ^( NEGATED_EXPRESSION IDENTIFIER )
                    {
                        // MOWLParser.g:138:23: ^( NEGATED_EXPRESSION IDENTIFIER )
                        {
                        ManchesterOWLSyntaxTree root_1 = (ManchesterOWLSyntaxTree)adaptor.nil();
                        root_1 = (ManchesterOWLSyntaxTree)adaptor.becomeRoot((ManchesterOWLSyntaxTree)adaptor.create(NEGATED_EXPRESSION, "NEGATED_EXPRESSION"), root_1);

                        adaptor.addChild(root_1, stream_IDENTIFIER.nextNode());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 4 :
                    // MOWLParser.g:139:5: ENTITY_REFERENCE
                    {
                    ENTITY_REFERENCE55=(Token)match(input,ENTITY_REFERENCE,FOLLOW_ENTITY_REFERENCE_in_unary1328); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_ENTITY_REFERENCE.add(ENTITY_REFERENCE55);



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
                    // 139:22: -> ^( ENTITY_REFERENCE )
                    {
                        // MOWLParser.g:139:25: ^( ENTITY_REFERENCE )
                        {
                        ManchesterOWLSyntaxTree root_1 = (ManchesterOWLSyntaxTree)adaptor.nil();
                        root_1 = (ManchesterOWLSyntaxTree)adaptor.becomeRoot(stream_ENTITY_REFERENCE.nextNode(), root_1);

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 5 :
                    // MOWLParser.g:140:5: qualifiedRestriction
                    {
                    pushFollow(FOLLOW_qualifiedRestriction_in_unary1340);
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
                    // 140:26: -> ^( qualifiedRestriction )
                    {
                        // MOWLParser.g:140:29: ^( qualifiedRestriction )
                        {
                        ManchesterOWLSyntaxTree root_1 = (ManchesterOWLSyntaxTree)adaptor.nil();
                        root_1 = (ManchesterOWLSyntaxTree)adaptor.becomeRoot(stream_qualifiedRestriction.nextNode(), root_1);

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 6 :
                    // MOWLParser.g:141:5: constant
                    {
                    root_0 = (ManchesterOWLSyntaxTree)adaptor.nil();

                    pushFollow(FOLLOW_constant_in_unary1352);
                    constant57=constant();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, constant57.getTree());

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

    public static class qualifiedRestriction_return extends ParserRuleReturnScope {
        ManchesterOWLSyntaxTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "qualifiedRestriction"
    // MOWLParser.g:144:1: qualifiedRestriction : ( options {backtrack=true; } : propertyExpression SOME filler -> ^( SOME_RESTRICTION propertyExpression filler ) | propertyExpression ONLY filler -> ^( ALL_RESTRICTION propertyExpression filler ) | cardinalityRestriction -> ^( cardinalityRestriction ) | oneOf -> ^( oneOf ) | valueRestriction -> ^( valueRestriction ) ) ;
    public final ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase_MOWLParser.qualifiedRestriction_return qualifiedRestriction() throws RecognitionException {
        ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase_MOWLParser.qualifiedRestriction_return retval = new ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase_MOWLParser.qualifiedRestriction_return();
        retval.start = input.LT(1);

        ManchesterOWLSyntaxTree root_0 = null;

        Token SOME59=null;
        Token ONLY62=null;
        ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase_MOWLParser.propertyExpression_return propertyExpression58 = null;

        ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase_MOWLParser.filler_return filler60 = null;

        ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase_MOWLParser.propertyExpression_return propertyExpression61 = null;

        ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase_MOWLParser.filler_return filler63 = null;

        ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase_MOWLParser.cardinalityRestriction_return cardinalityRestriction64 = null;

        ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase_MOWLParser.oneOf_return oneOf65 = null;

        ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase_MOWLParser.valueRestriction_return valueRestriction66 = null;


        ManchesterOWLSyntaxTree SOME59_tree=null;
        ManchesterOWLSyntaxTree ONLY62_tree=null;
        RewriteRuleTokenStream stream_ONLY=new RewriteRuleTokenStream(adaptor,"token ONLY");
        RewriteRuleTokenStream stream_SOME=new RewriteRuleTokenStream(adaptor,"token SOME");
        RewriteRuleSubtreeStream stream_oneOf=new RewriteRuleSubtreeStream(adaptor,"rule oneOf");
        RewriteRuleSubtreeStream stream_propertyExpression=new RewriteRuleSubtreeStream(adaptor,"rule propertyExpression");
        RewriteRuleSubtreeStream stream_cardinalityRestriction=new RewriteRuleSubtreeStream(adaptor,"rule cardinalityRestriction");
        RewriteRuleSubtreeStream stream_filler=new RewriteRuleSubtreeStream(adaptor,"rule filler");
        RewriteRuleSubtreeStream stream_valueRestriction=new RewriteRuleSubtreeStream(adaptor,"rule valueRestriction");
        try {
            // MOWLParser.g:144:21: ( ( options {backtrack=true; } : propertyExpression SOME filler -> ^( SOME_RESTRICTION propertyExpression filler ) | propertyExpression ONLY filler -> ^( ALL_RESTRICTION propertyExpression filler ) | cardinalityRestriction -> ^( cardinalityRestriction ) | oneOf -> ^( oneOf ) | valueRestriction -> ^( valueRestriction ) ) )
            // MOWLParser.g:145:9: ( options {backtrack=true; } : propertyExpression SOME filler -> ^( SOME_RESTRICTION propertyExpression filler ) | propertyExpression ONLY filler -> ^( ALL_RESTRICTION propertyExpression filler ) | cardinalityRestriction -> ^( cardinalityRestriction ) | oneOf -> ^( oneOf ) | valueRestriction -> ^( valueRestriction ) )
            {
            // MOWLParser.g:145:9: ( options {backtrack=true; } : propertyExpression SOME filler -> ^( SOME_RESTRICTION propertyExpression filler ) | propertyExpression ONLY filler -> ^( ALL_RESTRICTION propertyExpression filler ) | cardinalityRestriction -> ^( cardinalityRestriction ) | oneOf -> ^( oneOf ) | valueRestriction -> ^( valueRestriction ) )
            int alt14=5;
            switch ( input.LA(1) ) {
            case IDENTIFIER:
                {
                int LA14_1 = input.LA(2);

                if ( (synpred3_MOWLParser()) ) {
                    alt14=1;
                }
                else if ( (synpred4_MOWLParser()) ) {
                    alt14=2;
                }
                else if ( (synpred5_MOWLParser()) ) {
                    alt14=3;
                }
                else if ( (true) ) {
                    alt14=5;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 14, 1, input);

                    throw nvae;
                }
                }
                break;
            case INVERSE:
                {
                int LA14_2 = input.LA(2);

                if ( (synpred3_MOWLParser()) ) {
                    alt14=1;
                }
                else if ( (synpred4_MOWLParser()) ) {
                    alt14=2;
                }
                else if ( (synpred5_MOWLParser()) ) {
                    alt14=3;
                }
                else if ( (true) ) {
                    alt14=5;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 14, 2, input);

                    throw nvae;
                }
                }
                break;
            case OPEN_CURLY_BRACES:
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
                    // MOWLParser.g:147:7: propertyExpression SOME filler
                    {
                    pushFollow(FOLLOW_propertyExpression_in_qualifiedRestriction1400);
                    propertyExpression58=propertyExpression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_propertyExpression.add(propertyExpression58.getTree());
                    SOME59=(Token)match(input,SOME,FOLLOW_SOME_in_qualifiedRestriction1403); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_SOME.add(SOME59);

                    pushFollow(FOLLOW_filler_in_qualifiedRestriction1407);
                    filler60=filler();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_filler.add(filler60.getTree());


                    // AST REWRITE
                    // elements: propertyExpression, filler
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (ManchesterOWLSyntaxTree)adaptor.nil();
                    // 147:42: -> ^( SOME_RESTRICTION propertyExpression filler )
                    {
                        // MOWLParser.g:147:45: ^( SOME_RESTRICTION propertyExpression filler )
                        {
                        ManchesterOWLSyntaxTree root_1 = (ManchesterOWLSyntaxTree)adaptor.nil();
                        root_1 = (ManchesterOWLSyntaxTree)adaptor.becomeRoot((ManchesterOWLSyntaxTree)adaptor.create(SOME_RESTRICTION, "SOME_RESTRICTION"), root_1);

                        adaptor.addChild(root_1, stream_propertyExpression.nextTree());
                        adaptor.addChild(root_1, stream_filler.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 2 :
                    // MOWLParser.g:148:7: propertyExpression ONLY filler
                    {
                    pushFollow(FOLLOW_propertyExpression_in_qualifiedRestriction1436);
                    propertyExpression61=propertyExpression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_propertyExpression.add(propertyExpression61.getTree());
                    ONLY62=(Token)match(input,ONLY,FOLLOW_ONLY_in_qualifiedRestriction1438); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_ONLY.add(ONLY62);

                    pushFollow(FOLLOW_filler_in_qualifiedRestriction1441);
                    filler63=filler();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_filler.add(filler63.getTree());


                    // AST REWRITE
                    // elements: filler, propertyExpression
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (ManchesterOWLSyntaxTree)adaptor.nil();
                    // 148:40: -> ^( ALL_RESTRICTION propertyExpression filler )
                    {
                        // MOWLParser.g:148:43: ^( ALL_RESTRICTION propertyExpression filler )
                        {
                        ManchesterOWLSyntaxTree root_1 = (ManchesterOWLSyntaxTree)adaptor.nil();
                        root_1 = (ManchesterOWLSyntaxTree)adaptor.becomeRoot((ManchesterOWLSyntaxTree)adaptor.create(ALL_RESTRICTION, "ALL_RESTRICTION"), root_1);

                        adaptor.addChild(root_1, stream_propertyExpression.nextTree());
                        adaptor.addChild(root_1, stream_filler.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 3 :
                    // MOWLParser.g:149:7: cardinalityRestriction
                    {
                    pushFollow(FOLLOW_cardinalityRestriction_in_qualifiedRestriction1460);
                    cardinalityRestriction64=cardinalityRestriction();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_cardinalityRestriction.add(cardinalityRestriction64.getTree());


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
                    // 149:30: -> ^( cardinalityRestriction )
                    {
                        // MOWLParser.g:149:33: ^( cardinalityRestriction )
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
                    // MOWLParser.g:150:7: oneOf
                    {
                    pushFollow(FOLLOW_oneOf_in_qualifiedRestriction1474);
                    oneOf65=oneOf();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_oneOf.add(oneOf65.getTree());


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
                    // 150:13: -> ^( oneOf )
                    {
                        // MOWLParser.g:150:16: ^( oneOf )
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
                    // MOWLParser.g:151:7: valueRestriction
                    {
                    pushFollow(FOLLOW_valueRestriction_in_qualifiedRestriction1488);
                    valueRestriction66=valueRestriction();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_valueRestriction.add(valueRestriction66.getTree());


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
                    // 151:24: -> ^( valueRestriction )
                    {
                        // MOWLParser.g:151:27: ^( valueRestriction )
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
    // MOWLParser.g:155:1: propertyExpression : ( IDENTIFIER -> ^( IDENTIFIER ) | complexPropertyExpression -> ^( complexPropertyExpression ) );
    public final ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase_MOWLParser.propertyExpression_return propertyExpression() throws RecognitionException {
        ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase_MOWLParser.propertyExpression_return retval = new ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase_MOWLParser.propertyExpression_return();
        retval.start = input.LT(1);

        ManchesterOWLSyntaxTree root_0 = null;

        Token IDENTIFIER67=null;
        ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase_MOWLParser.complexPropertyExpression_return complexPropertyExpression68 = null;


        ManchesterOWLSyntaxTree IDENTIFIER67_tree=null;
        RewriteRuleTokenStream stream_IDENTIFIER=new RewriteRuleTokenStream(adaptor,"token IDENTIFIER");
        RewriteRuleSubtreeStream stream_complexPropertyExpression=new RewriteRuleSubtreeStream(adaptor,"rule complexPropertyExpression");
        try {
            // MOWLParser.g:155:21: ( IDENTIFIER -> ^( IDENTIFIER ) | complexPropertyExpression -> ^( complexPropertyExpression ) )
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==IDENTIFIER) ) {
                alt15=1;
            }
            else if ( (LA15_0==INVERSE) ) {
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
                    // MOWLParser.g:156:7: IDENTIFIER
                    {
                    IDENTIFIER67=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_propertyExpression1520); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_IDENTIFIER.add(IDENTIFIER67);



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
                    // 156:18: -> ^( IDENTIFIER )
                    {
                        // MOWLParser.g:156:21: ^( IDENTIFIER )
                        {
                        ManchesterOWLSyntaxTree root_1 = (ManchesterOWLSyntaxTree)adaptor.nil();
                        root_1 = (ManchesterOWLSyntaxTree)adaptor.becomeRoot(stream_IDENTIFIER.nextNode(), root_1);

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 2 :
                    // MOWLParser.g:157:7: complexPropertyExpression
                    {
                    pushFollow(FOLLOW_complexPropertyExpression_in_propertyExpression1534);
                    complexPropertyExpression68=complexPropertyExpression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_complexPropertyExpression.add(complexPropertyExpression68.getTree());


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
                    // 157:33: -> ^( complexPropertyExpression )
                    {
                        // MOWLParser.g:157:36: ^( complexPropertyExpression )
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
    // MOWLParser.g:160:1: cardinalityRestriction : propertyExpression restrictionKind INTEGER ( filler )? -> ^( CARDINALITY_RESTRICTION restrictionKind INTEGER propertyExpression ( filler )? ) ;
    public final ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase_MOWLParser.cardinalityRestriction_return cardinalityRestriction() throws RecognitionException {
        ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase_MOWLParser.cardinalityRestriction_return retval = new ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase_MOWLParser.cardinalityRestriction_return();
        retval.start = input.LT(1);

        ManchesterOWLSyntaxTree root_0 = null;

        Token INTEGER71=null;
        ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase_MOWLParser.propertyExpression_return propertyExpression69 = null;

        ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase_MOWLParser.restrictionKind_return restrictionKind70 = null;

        ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase_MOWLParser.filler_return filler72 = null;


        ManchesterOWLSyntaxTree INTEGER71_tree=null;
        RewriteRuleTokenStream stream_INTEGER=new RewriteRuleTokenStream(adaptor,"token INTEGER");
        RewriteRuleSubtreeStream stream_propertyExpression=new RewriteRuleSubtreeStream(adaptor,"rule propertyExpression");
        RewriteRuleSubtreeStream stream_restrictionKind=new RewriteRuleSubtreeStream(adaptor,"rule restrictionKind");
        RewriteRuleSubtreeStream stream_filler=new RewriteRuleSubtreeStream(adaptor,"rule filler");
        try {
            // MOWLParser.g:160:24: ( propertyExpression restrictionKind INTEGER ( filler )? -> ^( CARDINALITY_RESTRICTION restrictionKind INTEGER propertyExpression ( filler )? ) )
            // MOWLParser.g:161:6: propertyExpression restrictionKind INTEGER ( filler )?
            {
            pushFollow(FOLLOW_propertyExpression_in_cardinalityRestriction1560);
            propertyExpression69=propertyExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_propertyExpression.add(propertyExpression69.getTree());
            pushFollow(FOLLOW_restrictionKind_in_cardinalityRestriction1563);
            restrictionKind70=restrictionKind();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_restrictionKind.add(restrictionKind70.getTree());
            INTEGER71=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_cardinalityRestriction1565); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_INTEGER.add(INTEGER71);

            // MOWLParser.g:161:50: ( filler )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==IDENTIFIER) ) {
                int LA16_1 = input.LA(2);

                if ( ((LA16_1>=AND && LA16_1<=OR)) ) {
                    alt16=1;
                }
                else if ( (LA16_1==EOF||LA16_1==CLOSED_PARENTHESYS||(LA16_1>=SUBCLASS_OF && LA16_1<=EQUIVALENT_TO)||LA16_1==DISJOINT_WITH||LA16_1==IDENTIFIER) ) {
                    alt16=1;
                }
            }
            else if ( (LA16_0==OPEN_PARENTHESYS) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // MOWLParser.g:161:50: filler
                    {
                    pushFollow(FOLLOW_filler_in_cardinalityRestriction1567);
                    filler72=filler();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_filler.add(filler72.getTree());

                    }
                    break;

            }



            // AST REWRITE
            // elements: INTEGER, restrictionKind, propertyExpression, filler
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (ManchesterOWLSyntaxTree)adaptor.nil();
            // 161:58: -> ^( CARDINALITY_RESTRICTION restrictionKind INTEGER propertyExpression ( filler )? )
            {
                // MOWLParser.g:161:61: ^( CARDINALITY_RESTRICTION restrictionKind INTEGER propertyExpression ( filler )? )
                {
                ManchesterOWLSyntaxTree root_1 = (ManchesterOWLSyntaxTree)adaptor.nil();
                root_1 = (ManchesterOWLSyntaxTree)adaptor.becomeRoot((ManchesterOWLSyntaxTree)adaptor.create(CARDINALITY_RESTRICTION, "CARDINALITY_RESTRICTION"), root_1);

                adaptor.addChild(root_1, stream_restrictionKind.nextTree());
                adaptor.addChild(root_1, stream_INTEGER.nextNode());
                adaptor.addChild(root_1, stream_propertyExpression.nextTree());
                // MOWLParser.g:161:132: ( filler )?
                if ( stream_filler.hasNext() ) {
                    adaptor.addChild(root_1, stream_filler.nextTree());

                }
                stream_filler.reset();

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
    // MOWLParser.g:164:1: restrictionKind : ( MIN -> ^( MIN ) | MAX -> ^( MAX ) | EXACTLY -> ^( EXACTLY ) );
    public final ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase_MOWLParser.restrictionKind_return restrictionKind() throws RecognitionException {
        ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase_MOWLParser.restrictionKind_return retval = new ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase_MOWLParser.restrictionKind_return();
        retval.start = input.LT(1);

        ManchesterOWLSyntaxTree root_0 = null;

        Token MIN73=null;
        Token MAX74=null;
        Token EXACTLY75=null;

        ManchesterOWLSyntaxTree MIN73_tree=null;
        ManchesterOWLSyntaxTree MAX74_tree=null;
        ManchesterOWLSyntaxTree EXACTLY75_tree=null;
        RewriteRuleTokenStream stream_MAX=new RewriteRuleTokenStream(adaptor,"token MAX");
        RewriteRuleTokenStream stream_MIN=new RewriteRuleTokenStream(adaptor,"token MIN");
        RewriteRuleTokenStream stream_EXACTLY=new RewriteRuleTokenStream(adaptor,"token EXACTLY");

        try {
            // MOWLParser.g:164:17: ( MIN -> ^( MIN ) | MAX -> ^( MAX ) | EXACTLY -> ^( EXACTLY ) )
            int alt17=3;
            switch ( input.LA(1) ) {
            case MIN:
                {
                alt17=1;
                }
                break;
            case MAX:
                {
                alt17=2;
                }
                break;
            case EXACTLY:
                {
                alt17=3;
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
                    // MOWLParser.g:165:5: MIN
                    {
                    MIN73=(Token)match(input,MIN,FOLLOW_MIN_in_restrictionKind1602); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_MIN.add(MIN73);



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
                    // 165:9: -> ^( MIN )
                    {
                        // MOWLParser.g:165:12: ^( MIN )
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
                    // MOWLParser.g:166:7: MAX
                    {
                    MAX74=(Token)match(input,MAX,FOLLOW_MAX_in_restrictionKind1616); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_MAX.add(MAX74);



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
                    // 166:11: -> ^( MAX )
                    {
                        // MOWLParser.g:166:14: ^( MAX )
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
                    // MOWLParser.g:167:7: EXACTLY
                    {
                    EXACTLY75=(Token)match(input,EXACTLY,FOLLOW_EXACTLY_in_restrictionKind1630); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_EXACTLY.add(EXACTLY75);



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
                    // 167:15: -> ^( EXACTLY )
                    {
                        // MOWLParser.g:167:18: ^( EXACTLY )
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

    public static class filler_return extends ParserRuleReturnScope {
        ManchesterOWLSyntaxTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "filler"
    // MOWLParser.g:169:1: filler : ( IDENTIFIER -> ^( IDENTIFIER ) | OPEN_PARENTHESYS expression CLOSED_PARENTHESYS -> ^( expression ) );
    public final ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase_MOWLParser.filler_return filler() throws RecognitionException {
        ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase_MOWLParser.filler_return retval = new ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase_MOWLParser.filler_return();
        retval.start = input.LT(1);

        ManchesterOWLSyntaxTree root_0 = null;

        Token IDENTIFIER76=null;
        Token OPEN_PARENTHESYS77=null;
        Token CLOSED_PARENTHESYS79=null;
        ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase_MOWLParser.expression_return expression78 = null;


        ManchesterOWLSyntaxTree IDENTIFIER76_tree=null;
        ManchesterOWLSyntaxTree OPEN_PARENTHESYS77_tree=null;
        ManchesterOWLSyntaxTree CLOSED_PARENTHESYS79_tree=null;
        RewriteRuleTokenStream stream_CLOSED_PARENTHESYS=new RewriteRuleTokenStream(adaptor,"token CLOSED_PARENTHESYS");
        RewriteRuleTokenStream stream_IDENTIFIER=new RewriteRuleTokenStream(adaptor,"token IDENTIFIER");
        RewriteRuleTokenStream stream_OPEN_PARENTHESYS=new RewriteRuleTokenStream(adaptor,"token OPEN_PARENTHESYS");
        RewriteRuleSubtreeStream stream_expression=new RewriteRuleSubtreeStream(adaptor,"rule expression");
        try {
            // MOWLParser.g:169:7: ( IDENTIFIER -> ^( IDENTIFIER ) | OPEN_PARENTHESYS expression CLOSED_PARENTHESYS -> ^( expression ) )
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==IDENTIFIER) ) {
                alt18=1;
            }
            else if ( (LA18_0==OPEN_PARENTHESYS) ) {
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
                    // MOWLParser.g:170:5: IDENTIFIER
                    {
                    IDENTIFIER76=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_filler1652); if (state.failed) return retval; 
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

                    root_0 = (ManchesterOWLSyntaxTree)adaptor.nil();
                    // 170:16: -> ^( IDENTIFIER )
                    {
                        // MOWLParser.g:170:19: ^( IDENTIFIER )
                        {
                        ManchesterOWLSyntaxTree root_1 = (ManchesterOWLSyntaxTree)adaptor.nil();
                        root_1 = (ManchesterOWLSyntaxTree)adaptor.becomeRoot(stream_IDENTIFIER.nextNode(), root_1);

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 2 :
                    // MOWLParser.g:171:7: OPEN_PARENTHESYS expression CLOSED_PARENTHESYS
                    {
                    OPEN_PARENTHESYS77=(Token)match(input,OPEN_PARENTHESYS,FOLLOW_OPEN_PARENTHESYS_in_filler1666); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_OPEN_PARENTHESYS.add(OPEN_PARENTHESYS77);

                    pushFollow(FOLLOW_expression_in_filler1668);
                    expression78=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_expression.add(expression78.getTree());
                    CLOSED_PARENTHESYS79=(Token)match(input,CLOSED_PARENTHESYS,FOLLOW_CLOSED_PARENTHESYS_in_filler1670); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_CLOSED_PARENTHESYS.add(CLOSED_PARENTHESYS79);



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
                    // 171:54: -> ^( expression )
                    {
                        // MOWLParser.g:171:57: ^( expression )
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
    // $ANTLR end "filler"

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

        Token OPEN_CURLY_BRACES80=null;
        Token IDENTIFIER81=null;
        Token COMMA82=null;
        Token IDENTIFIER83=null;
        Token CLOSED_CURLY_BRACES84=null;

        ManchesterOWLSyntaxTree OPEN_CURLY_BRACES80_tree=null;
        ManchesterOWLSyntaxTree IDENTIFIER81_tree=null;
        ManchesterOWLSyntaxTree COMMA82_tree=null;
        ManchesterOWLSyntaxTree IDENTIFIER83_tree=null;
        ManchesterOWLSyntaxTree CLOSED_CURLY_BRACES84_tree=null;
        RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
        RewriteRuleTokenStream stream_CLOSED_CURLY_BRACES=new RewriteRuleTokenStream(adaptor,"token CLOSED_CURLY_BRACES");
        RewriteRuleTokenStream stream_IDENTIFIER=new RewriteRuleTokenStream(adaptor,"token IDENTIFIER");
        RewriteRuleTokenStream stream_OPEN_CURLY_BRACES=new RewriteRuleTokenStream(adaptor,"token OPEN_CURLY_BRACES");

        try {
            // MOWLParser.g:174:7: ( OPEN_CURLY_BRACES IDENTIFIER ( COMMA IDENTIFIER )* CLOSED_CURLY_BRACES -> ^( ONE_OF ( IDENTIFIER )+ ) )
            // MOWLParser.g:175:3: OPEN_CURLY_BRACES IDENTIFIER ( COMMA IDENTIFIER )* CLOSED_CURLY_BRACES
            {
            OPEN_CURLY_BRACES80=(Token)match(input,OPEN_CURLY_BRACES,FOLLOW_OPEN_CURLY_BRACES_in_oneOf1688); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_OPEN_CURLY_BRACES.add(OPEN_CURLY_BRACES80);

            IDENTIFIER81=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_oneOf1690); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_IDENTIFIER.add(IDENTIFIER81);

            // MOWLParser.g:175:32: ( COMMA IDENTIFIER )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( (LA19_0==COMMA) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // MOWLParser.g:175:33: COMMA IDENTIFIER
            	    {
            	    COMMA82=(Token)match(input,COMMA,FOLLOW_COMMA_in_oneOf1693); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_COMMA.add(COMMA82);

            	    IDENTIFIER83=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_oneOf1695); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_IDENTIFIER.add(IDENTIFIER83);


            	    }
            	    break;

            	default :
            	    break loop19;
                }
            } while (true);

            CLOSED_CURLY_BRACES84=(Token)match(input,CLOSED_CURLY_BRACES,FOLLOW_CLOSED_CURLY_BRACES_in_oneOf1699); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_CLOSED_CURLY_BRACES.add(CLOSED_CURLY_BRACES84);



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

        Token VALUE86=null;
        ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase_MOWLParser.propertyExpression_return propertyExpression85 = null;

        ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase_MOWLParser.value_return value87 = null;


        ManchesterOWLSyntaxTree VALUE86_tree=null;
        RewriteRuleTokenStream stream_VALUE=new RewriteRuleTokenStream(adaptor,"token VALUE");
        RewriteRuleSubtreeStream stream_propertyExpression=new RewriteRuleSubtreeStream(adaptor,"rule propertyExpression");
        RewriteRuleSubtreeStream stream_value=new RewriteRuleSubtreeStream(adaptor,"rule value");
        try {
            // MOWLParser.g:178:18: ( propertyExpression VALUE value -> ^( VALUE_RESTRICTION propertyExpression value ) )
            // MOWLParser.g:178:20: propertyExpression VALUE value
            {
            pushFollow(FOLLOW_propertyExpression_in_valueRestriction1719);
            propertyExpression85=propertyExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_propertyExpression.add(propertyExpression85.getTree());
            VALUE86=(Token)match(input,VALUE,FOLLOW_VALUE_in_valueRestriction1721); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_VALUE.add(VALUE86);

            pushFollow(FOLLOW_value_in_valueRestriction1723);
            value87=value();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_value.add(value87.getTree());


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
    // MOWLParser.g:181:1: value : ( IDENTIFIER -> ^( IDENTIFIER ) | constant -> ^( constant ) );
    public final ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase_MOWLParser.value_return value() throws RecognitionException {
        ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase_MOWLParser.value_return retval = new ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase_MOWLParser.value_return();
        retval.start = input.LT(1);

        ManchesterOWLSyntaxTree root_0 = null;

        Token IDENTIFIER88=null;
        ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase_MOWLParser.constant_return constant89 = null;


        ManchesterOWLSyntaxTree IDENTIFIER88_tree=null;
        RewriteRuleTokenStream stream_IDENTIFIER=new RewriteRuleTokenStream(adaptor,"token IDENTIFIER");
        RewriteRuleSubtreeStream stream_constant=new RewriteRuleSubtreeStream(adaptor,"rule constant");
        try {
            // MOWLParser.g:181:6: ( IDENTIFIER -> ^( IDENTIFIER ) | constant -> ^( constant ) )
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==IDENTIFIER) ) {
                alt20=1;
            }
            else if ( (LA20_0==DBLQUOTE) ) {
                alt20=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 20, 0, input);

                throw nvae;
            }
            switch (alt20) {
                case 1 :
                    // MOWLParser.g:182:7: IDENTIFIER
                    {
                    IDENTIFIER88=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_value1748); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_IDENTIFIER.add(IDENTIFIER88);



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
                    // 182:18: -> ^( IDENTIFIER )
                    {
                        // MOWLParser.g:182:21: ^( IDENTIFIER )
                        {
                        ManchesterOWLSyntaxTree root_1 = (ManchesterOWLSyntaxTree)adaptor.nil();
                        root_1 = (ManchesterOWLSyntaxTree)adaptor.becomeRoot(stream_IDENTIFIER.nextNode(), root_1);

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 2 :
                    // MOWLParser.g:183:7: constant
                    {
                    pushFollow(FOLLOW_constant_in_value1763);
                    constant89=constant();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_constant.add(constant89.getTree());


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
        Token POW90=null;

        ManchesterOWLSyntaxTree constantValue_tree=null;
        ManchesterOWLSyntaxTree type_tree=null;
        ManchesterOWLSyntaxTree POW90_tree=null;
        RewriteRuleTokenStream stream_POW=new RewriteRuleTokenStream(adaptor,"token POW");
        RewriteRuleTokenStream stream_IDENTIFIER=new RewriteRuleTokenStream(adaptor,"token IDENTIFIER");
        RewriteRuleTokenStream stream_DBLQUOTE=new RewriteRuleTokenStream(adaptor,"token DBLQUOTE");

        try {
            // MOWLParser.g:186:11: (constantValue= DBLQUOTE ( POW type= IDENTIFIER )? -> ^( CONSTANT $constantValue ( $type)? ) )
            // MOWLParser.g:186:14: constantValue= DBLQUOTE ( POW type= IDENTIFIER )?
            {
            constantValue=(Token)match(input,DBLQUOTE,FOLLOW_DBLQUOTE_in_constant1788); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_DBLQUOTE.add(constantValue);

            // MOWLParser.g:186:39: ( POW type= IDENTIFIER )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==POW) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // MOWLParser.g:186:41: POW type= IDENTIFIER
                    {
                    POW90=(Token)match(input,POW,FOLLOW_POW_in_constant1792); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_POW.add(POW90);

                    type=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_constant1798); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_IDENTIFIER.add(type);


                    }
                    break;

            }



            // AST REWRITE
            // elements: type, constantValue
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

    // $ANTLR start synpred1_MOWLParser
    public final void synpred1_MOWLParser_fragment() throws RecognitionException {   
        List list_rest=null;
        ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase_MOWLParser.propertyExpression_return head = null;

        RuleReturnScope rest = null;
        // MOWLParser.g:117:4: (head= propertyExpression ( COMPOSITION rest+= propertyExpression )+ )
        // MOWLParser.g:117:4: head= propertyExpression ( COMPOSITION rest+= propertyExpression )+
        {
        pushFollow(FOLLOW_propertyExpression_in_synpred1_MOWLParser1121);
        head=propertyExpression();

        state._fsp--;
        if (state.failed) return ;
        // MOWLParser.g:117:30: ( COMPOSITION rest+= propertyExpression )+
        int cnt22=0;
        loop22:
        do {
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==COMPOSITION) ) {
                alt22=1;
            }


            switch (alt22) {
        	case 1 :
        	    // MOWLParser.g:117:31: COMPOSITION rest+= propertyExpression
        	    {
        	    match(input,COMPOSITION,FOLLOW_COMPOSITION_in_synpred1_MOWLParser1124); if (state.failed) return ;
        	    pushFollow(FOLLOW_propertyExpression_in_synpred1_MOWLParser1128);
        	    rest=propertyExpression();

        	    state._fsp--;
        	    if (state.failed) return ;
        	    if (list_rest==null) list_rest=new ArrayList();
        	    list_rest.add(rest);


        	    }
        	    break;

        	default :
        	    if ( cnt22 >= 1 ) break loop22;
        	    if (state.backtracking>0) {state.failed=true; return ;}
                    EarlyExitException eee =
                        new EarlyExitException(22, input);
                    throw eee;
            }
            cnt22++;
        } while (true);


        }
    }
    // $ANTLR end synpred1_MOWLParser

    // $ANTLR start synpred2_MOWLParser
    public final void synpred2_MOWLParser_fragment() throws RecognitionException {   
        // MOWLParser.g:118:6: ( conjunction ( OR conjunction )* )
        // MOWLParser.g:118:6: conjunction ( OR conjunction )*
        {
        pushFollow(FOLLOW_conjunction_in_synpred2_MOWLParser1151);
        conjunction();

        state._fsp--;
        if (state.failed) return ;
        // MOWLParser.g:118:18: ( OR conjunction )*
        loop23:
        do {
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==OR) ) {
                alt23=1;
            }


            switch (alt23) {
        	case 1 :
        	    // MOWLParser.g:118:19: OR conjunction
        	    {
        	    match(input,OR,FOLLOW_OR_in_synpred2_MOWLParser1154); if (state.failed) return ;
        	    pushFollow(FOLLOW_conjunction_in_synpred2_MOWLParser1156);
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
    // $ANTLR end synpred2_MOWLParser

    // $ANTLR start synpred3_MOWLParser
    public final void synpred3_MOWLParser_fragment() throws RecognitionException {   
        // MOWLParser.g:147:7: ( propertyExpression SOME filler )
        // MOWLParser.g:147:7: propertyExpression SOME filler
        {
        pushFollow(FOLLOW_propertyExpression_in_synpred3_MOWLParser1400);
        propertyExpression();

        state._fsp--;
        if (state.failed) return ;
        match(input,SOME,FOLLOW_SOME_in_synpred3_MOWLParser1403); if (state.failed) return ;
        pushFollow(FOLLOW_filler_in_synpred3_MOWLParser1407);
        filler();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred3_MOWLParser

    // $ANTLR start synpred4_MOWLParser
    public final void synpred4_MOWLParser_fragment() throws RecognitionException {   
        // MOWLParser.g:148:7: ( propertyExpression ONLY filler )
        // MOWLParser.g:148:7: propertyExpression ONLY filler
        {
        pushFollow(FOLLOW_propertyExpression_in_synpred4_MOWLParser1436);
        propertyExpression();

        state._fsp--;
        if (state.failed) return ;
        match(input,ONLY,FOLLOW_ONLY_in_synpred4_MOWLParser1438); if (state.failed) return ;
        pushFollow(FOLLOW_filler_in_synpred4_MOWLParser1441);
        filler();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred4_MOWLParser

    // $ANTLR start synpred5_MOWLParser
    public final void synpred5_MOWLParser_fragment() throws RecognitionException {   
        // MOWLParser.g:149:7: ( cardinalityRestriction )
        // MOWLParser.g:149:7: cardinalityRestriction
        {
        pushFollow(FOLLOW_cardinalityRestriction_in_synpred5_MOWLParser1460);
        cardinalityRestriction();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred5_MOWLParser

    // Delegated rules

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
    public final boolean synpred2_MOWLParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred2_MOWLParser_fragment(); // can never throw exception
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


 

    public static final BitSet FOLLOW_binaryAxiom_in_axiom220 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_unaryAxiom_in_axiom232 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_assertionAxiom_in_axiom244 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_assertionAxiom267 = new BitSet(new long[]{0x000000C000000000L});
    public static final BitSet FOLLOW_INSTANCE_OF_in_assertionAxiom270 = new BitSet(new long[]{0x0000310000081040L});
    public static final BitSet FOLLOW_TYPES_in_assertionAxiom274 = new BitSet(new long[]{0x0000310000081040L});
    public static final BitSet FOLLOW_expression_in_assertionAxiom277 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_assertionAxiom303 = new BitSet(new long[]{0x0000100000080000L});
    public static final BitSet FOLLOW_propertyExpression_in_assertionAxiom305 = new BitSet(new long[]{0x0000310000081040L});
    public static final BitSet FOLLOW_value_in_assertionAxiom308 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NOT_in_assertionAxiom341 = new BitSet(new long[]{0x0000100000001000L});
    public static final BitSet FOLLOW_assertionAxiom_in_assertionAxiom343 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_in_binaryAxiom371 = new BitSet(new long[]{0x0000000004700000L});
    public static final BitSet FOLLOW_SUBCLASS_OF_in_binaryAxiom426 = new BitSet(new long[]{0x0000310000081040L});
    public static final BitSet FOLLOW_expression_in_binaryAxiom433 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_EQUIVALENT_TO_in_binaryAxiom474 = new BitSet(new long[]{0x0000310000081040L});
    public static final BitSet FOLLOW_expression_in_binaryAxiom480 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DISJOINT_WITH_in_binaryAxiom520 = new BitSet(new long[]{0x0000310000081040L});
    public static final BitSet FOLLOW_expression_in_binaryAxiom526 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SUB_PROPERTY_OF_in_binaryAxiom566 = new BitSet(new long[]{0x0000100000080000L});
    public static final BitSet FOLLOW_propertyExpression_in_binaryAxiom572 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_binaryAxiom642 = new BitSet(new long[]{0x000000001B800000L});
    public static final BitSet FOLLOW_SAME_AS_in_binaryAxiom667 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_binaryAxiom674 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DIFFERENT_FROM_in_binaryAxiom717 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_binaryAxiom724 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOMAIN_in_binaryAxiom766 = new BitSet(new long[]{0x0000310000081040L});
    public static final BitSet FOLLOW_expression_in_binaryAxiom768 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RANGE_in_binaryAxiom809 = new BitSet(new long[]{0x0000310000081040L});
    public static final BitSet FOLLOW_expression_in_binaryAxiom811 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INVERSE_OF_in_binaryAxiom852 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_binaryAxiom858 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_unaryCharacteristic_in_unaryAxiom943 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_unaryAxiom947 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FUNCTIONAL_in_unaryCharacteristic992 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INVERSE_FUNCTIONAL_in_unaryCharacteristic1006 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SYMMETRIC_in_unaryCharacteristic1020 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ANTI_SYMMETRIC_in_unaryCharacteristic1034 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_REFLEXIVE_in_unaryCharacteristic1048 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IRREFLEXIVE_in_unaryCharacteristic1062 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TRANSITIVE_in_unaryCharacteristic1076 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_propertyExpression_in_expression1121 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_COMPOSITION_in_expression1124 = new BitSet(new long[]{0x0000100000080000L});
    public static final BitSet FOLLOW_propertyExpression_in_expression1128 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_conjunction_in_expression1151 = new BitSet(new long[]{0x0000000000000802L});
    public static final BitSet FOLLOW_OR_in_expression1154 = new BitSet(new long[]{0x0000310000081040L});
    public static final BitSet FOLLOW_conjunction_in_expression1156 = new BitSet(new long[]{0x0000000000000802L});
    public static final BitSet FOLLOW_complexPropertyExpression_in_expression1175 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_unary_in_conjunction1207 = new BitSet(new long[]{0x0000000000000402L});
    public static final BitSet FOLLOW_AND_in_conjunction1210 = new BitSet(new long[]{0x0000310000081040L});
    public static final BitSet FOLLOW_unary_in_conjunction1212 = new BitSet(new long[]{0x0000000000000402L});
    public static final BitSet FOLLOW_INVERSE_in_complexPropertyExpression1233 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_OPEN_PARENTHESYS_in_complexPropertyExpression1235 = new BitSet(new long[]{0x0000100000080000L});
    public static final BitSet FOLLOW_complexPropertyExpression_in_complexPropertyExpression1237 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_CLOSED_PARENTHESYS_in_complexPropertyExpression1239 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INVERSE_in_complexPropertyExpression1252 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_OPEN_PARENTHESYS_in_complexPropertyExpression1254 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_complexPropertyExpression1256 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_CLOSED_PARENTHESYS_in_complexPropertyExpression1258 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_unary1278 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NOT_in_unary1285 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_OPEN_PARENTHESYS_in_unary1287 = new BitSet(new long[]{0x0000310000081040L});
    public static final BitSet FOLLOW_expression_in_unary1289 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_CLOSED_PARENTHESYS_in_unary1291 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NOT_in_unary1305 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_unary1307 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ENTITY_REFERENCE_in_unary1328 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_qualifiedRestriction_in_unary1340 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_constant_in_unary1352 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_propertyExpression_in_qualifiedRestriction1400 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_SOME_in_qualifiedRestriction1403 = new BitSet(new long[]{0x0000100000000020L});
    public static final BitSet FOLLOW_filler_in_qualifiedRestriction1407 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_propertyExpression_in_qualifiedRestriction1436 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_ONLY_in_qualifiedRestriction1438 = new BitSet(new long[]{0x0000100000000020L});
    public static final BitSet FOLLOW_filler_in_qualifiedRestriction1441 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_cardinalityRestriction_in_qualifiedRestriction1460 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_oneOf_in_qualifiedRestriction1474 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_valueRestriction_in_qualifiedRestriction1488 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_propertyExpression1520 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_complexPropertyExpression_in_propertyExpression1534 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_propertyExpression_in_cardinalityRestriction1560 = new BitSet(new long[]{0x0000000000038000L});
    public static final BitSet FOLLOW_restrictionKind_in_cardinalityRestriction1563 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_INTEGER_in_cardinalityRestriction1565 = new BitSet(new long[]{0x0000100000000022L});
    public static final BitSet FOLLOW_filler_in_cardinalityRestriction1567 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MIN_in_restrictionKind1602 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MAX_in_restrictionKind1616 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_EXACTLY_in_restrictionKind1630 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_filler1652 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OPEN_PARENTHESYS_in_filler1666 = new BitSet(new long[]{0x0000310000081040L});
    public static final BitSet FOLLOW_expression_in_filler1668 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_CLOSED_PARENTHESYS_in_filler1670 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OPEN_CURLY_BRACES_in_oneOf1688 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_oneOf1690 = new BitSet(new long[]{0x0000002000000080L});
    public static final BitSet FOLLOW_COMMA_in_oneOf1693 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_oneOf1695 = new BitSet(new long[]{0x0000002000000080L});
    public static final BitSet FOLLOW_CLOSED_CURLY_BRACES_in_oneOf1699 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_propertyExpression_in_valueRestriction1719 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_VALUE_in_valueRestriction1721 = new BitSet(new long[]{0x0000310000081040L});
    public static final BitSet FOLLOW_value_in_valueRestriction1723 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_value1748 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_constant_in_value1763 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DBLQUOTE_in_constant1788 = new BitSet(new long[]{0x0000001000000002L});
    public static final BitSet FOLLOW_POW_in_constant1792 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_constant1798 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_propertyExpression_in_synpred1_MOWLParser1121 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_COMPOSITION_in_synpred1_MOWLParser1124 = new BitSet(new long[]{0x0000100000080000L});
    public static final BitSet FOLLOW_propertyExpression_in_synpred1_MOWLParser1128 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_conjunction_in_synpred2_MOWLParser1151 = new BitSet(new long[]{0x0000000000000802L});
    public static final BitSet FOLLOW_OR_in_synpred2_MOWLParser1154 = new BitSet(new long[]{0x0000310000081040L});
    public static final BitSet FOLLOW_conjunction_in_synpred2_MOWLParser1156 = new BitSet(new long[]{0x0000000000000802L});
    public static final BitSet FOLLOW_propertyExpression_in_synpred3_MOWLParser1400 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_SOME_in_synpred3_MOWLParser1403 = new BitSet(new long[]{0x0000100000000020L});
    public static final BitSet FOLLOW_filler_in_synpred3_MOWLParser1407 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_propertyExpression_in_synpred4_MOWLParser1436 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_ONLY_in_synpred4_MOWLParser1438 = new BitSet(new long[]{0x0000100000000020L});
    public static final BitSet FOLLOW_filler_in_synpred4_MOWLParser1441 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_cardinalityRestriction_in_synpred5_MOWLParser1460 = new BitSet(new long[]{0x0000000000000002L});

}