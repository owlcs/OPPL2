// $ANTLR 3.2 Sep 23, 2009 12:02:23 /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxAutoCompleteCombined.g 2010-09-03 10:41:44

  package org.coode.parsers;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

import org.antlr.runtime.tree.*;

public class ManchesterOWLSyntaxAutoCompleteCombinedParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "COMPOSITION", "OPEN_PARENTHESYS", "OPEN_CURLY_BRACES", "CLOSED_CURLY_BRACES", "CLOSED_PARENTHESYS", "WHITESPACE", "AND", "OR", "NOT", "SOME", "ONLY", "MIN", "MAX", "EXACTLY", "VALUE", "INVERSE", "SUBCLASS_OF", "SUB_PROPERTY_OF", "EQUIVALENT_TO", "SAME_AS", "DIFFERENT_FROM", "INVERSE_OF", "DISJOINT_WITH", "DOMAIN", "RANGE", "FUNCTIONAL", "SYMMETRIC", "ANTI_SYMMETRIC", "REFLEXIVE", "IRREFLEXIVE", "TRANSITIVE", "INVERSE_FUNCTIONAL", "POW", "COMMA", "INSTANCE_OF", "TYPES", "DBLQUOTE", "DIGIT", "INTEGER", "LETTER", "IDENTIFIER", "ENTITY_REFERENCE", "SUB_CLASS_AXIOM", "EQUIVALENT_TO_AXIOM", "DISJOINT_WITH_AXIOM", "SUB_PROPERTY_AXIOM", "SAME_AS_AXIOM", "DIFFERENT_FROM_AXIOM", "UNARY_AXIOM", "DISJUNCTION", "CONJUNCTION", "PROPERTY_CHAIN", "NEGATED_EXPRESSION", "NEGATED_ASSERTION", "INVERSE_PROPERTY", "SOME_RESTRICTION", "ALL_RESTRICTION", "VALUE_RESTRICTION", "CARDINALITY_RESTRICTION", "ONE_OF", "TYPE_ASSERTION", "ROLE_ASSERTION", "INVERSE_OBJECT_PROPERTY_EXPRESSION", "EXPRESSION", "CONSTANT", "STANDALONE_EXPRESSION", "INCOMPLETE_TYPE_ASSERTION", "INCOMPLETE_ROLE_ASSERTION", "INCOMPLETE_UNARY_AXIOM", "INCOMPLETE_SUB_CLASS_AXIOM", "INCOMPLETE_EQUIVALENT_TO_AXIOM", "INCOMPLETE_DISJOINT_WITH_AXIOM", "INCOMPLETE_SUB_PROPERTY_AXIOM", "INCOMPLETE_SAME_AS_AXIOM", "INCOMPLETE_DIFFERENT_FROM_AXIOM", "INCOMPLETE_DOMAIN", "INCOMPLETE_RANGE", "INCOMPLETE_INVERSE_OF", "INCOMPLETE_PROPERTY_CHAIN", "INCOMPLETE_DISJUNCTION", "INCOMPLETE_CONJUNCTION", "INCOMPLETE_INVERSE_OBJECT_PROPERTY_EXPRESSION", "INCOMPLETE_NEGATED_EXPRESSION", "INCOMPLETE_SOME_RESTRICTION", "INCOMPLETE_ALL_RESTRICTION", "INCOMPLETE_CARDINALITY_RESTRICTION", "INCOMPLETE_ONE_OF", "INCOMPLETE_VALUE_RESTRICTION", "INCOMPLETE_EXPRESSION"
    };
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
    public ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase_MOWLParser gMOWLParser;
    public ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase gManchesterOWLSyntaxAutoCompleteBase;
    // delegators


        public ManchesterOWLSyntaxAutoCompleteCombinedParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public ManchesterOWLSyntaxAutoCompleteCombinedParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
            gManchesterOWLSyntaxAutoCompleteBase = new ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase(input, state, this);         
            gMOWLParser = gManchesterOWLSyntaxAutoCompleteBase.gMOWLParser;
        }
        
    protected TreeAdaptor adaptor = new CommonTreeAdaptor();

    public void setTreeAdaptor(TreeAdaptor adaptor) {
        this.adaptor = adaptor;
        gManchesterOWLSyntaxAutoCompleteBase.setTreeAdaptor(this.adaptor);
    }
    public TreeAdaptor getTreeAdaptor() {
        return adaptor;
    }

    public String[] getTokenNames() { return ManchesterOWLSyntaxAutoCompleteCombinedParser.tokenNames; }
    public String getGrammarFileName() { return "/Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxAutoCompleteCombined.g"; }


    public static class main_return extends ParserRuleReturnScope {
        ManchesterOWLSyntaxTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "main"
    // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxAutoCompleteCombined.g:15:1: main : ( options {backtrack=true; } : expression -> ^( STANDALONE_EXPRESSION expression ) | axiom -> ^( axiom ) | incompleteAxiom -> ^( incompleteAxiom ) | incompleteExpression -> ^( incompleteExpression ) ) ;
    public final ManchesterOWLSyntaxAutoCompleteCombinedParser.main_return main() throws RecognitionException {
        ManchesterOWLSyntaxAutoCompleteCombinedParser.main_return retval = new ManchesterOWLSyntaxAutoCompleteCombinedParser.main_return();
        retval.start = input.LT(1);

        ManchesterOWLSyntaxTree root_0 = null;

        ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase_MOWLParser.expression_return expression1 = null;

        ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase_MOWLParser.axiom_return axiom2 = null;

        ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase.incompleteAxiom_return incompleteAxiom3 = null;

        ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase.incompleteExpression_return incompleteExpression4 = null;


        RewriteRuleSubtreeStream stream_expression=new RewriteRuleSubtreeStream(adaptor,"rule expression");
        RewriteRuleSubtreeStream stream_incompleteAxiom=new RewriteRuleSubtreeStream(adaptor,"rule incompleteAxiom");
        RewriteRuleSubtreeStream stream_incompleteExpression=new RewriteRuleSubtreeStream(adaptor,"rule incompleteExpression");
        RewriteRuleSubtreeStream stream_axiom=new RewriteRuleSubtreeStream(adaptor,"rule axiom");
        try {
            // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxAutoCompleteCombined.g:15:5: ( ( options {backtrack=true; } : expression -> ^( STANDALONE_EXPRESSION expression ) | axiom -> ^( axiom ) | incompleteAxiom -> ^( incompleteAxiom ) | incompleteExpression -> ^( incompleteExpression ) ) )
            // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxAutoCompleteCombined.g:16:1: ( options {backtrack=true; } : expression -> ^( STANDALONE_EXPRESSION expression ) | axiom -> ^( axiom ) | incompleteAxiom -> ^( incompleteAxiom ) | incompleteExpression -> ^( incompleteExpression ) )
            {
            // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxAutoCompleteCombined.g:16:1: ( options {backtrack=true; } : expression -> ^( STANDALONE_EXPRESSION expression ) | axiom -> ^( axiom ) | incompleteAxiom -> ^( incompleteAxiom ) | incompleteExpression -> ^( incompleteExpression ) )
            int alt1=4;
            alt1 = dfa1.predict(input);
            switch (alt1) {
                case 1 :
                    // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxAutoCompleteCombined.g:18:5: expression
                    {
                    pushFollow(FOLLOW_expression_in_main100);
                    expression1=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_expression.add(expression1.getTree());


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
                    // 18:16: -> ^( STANDALONE_EXPRESSION expression )
                    {
                        // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxAutoCompleteCombined.g:18:19: ^( STANDALONE_EXPRESSION expression )
                        {
                        ManchesterOWLSyntaxTree root_1 = (ManchesterOWLSyntaxTree)adaptor.nil();
                        root_1 = (ManchesterOWLSyntaxTree)adaptor.becomeRoot((ManchesterOWLSyntaxTree)adaptor.create(STANDALONE_EXPRESSION, "STANDALONE_EXPRESSION"), root_1);

                        adaptor.addChild(root_1, stream_expression.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 2 :
                    // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxAutoCompleteCombined.g:19:5: axiom
                    {
                    pushFollow(FOLLOW_axiom_in_main114);
                    axiom2=axiom();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_axiom.add(axiom2.getTree());


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

                    root_0 = (ManchesterOWLSyntaxTree)adaptor.nil();
                    // 19:12: -> ^( axiom )
                    {
                        // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxAutoCompleteCombined.g:19:15: ^( axiom )
                        {
                        ManchesterOWLSyntaxTree root_1 = (ManchesterOWLSyntaxTree)adaptor.nil();
                        root_1 = (ManchesterOWLSyntaxTree)adaptor.becomeRoot(stream_axiom.nextNode(), root_1);

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 3 :
                    // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxAutoCompleteCombined.g:20:5: incompleteAxiom
                    {
                    pushFollow(FOLLOW_incompleteAxiom_in_main127);
                    incompleteAxiom3=incompleteAxiom();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_incompleteAxiom.add(incompleteAxiom3.getTree());


                    // AST REWRITE
                    // elements: incompleteAxiom
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (ManchesterOWLSyntaxTree)adaptor.nil();
                    // 20:22: -> ^( incompleteAxiom )
                    {
                        // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxAutoCompleteCombined.g:20:25: ^( incompleteAxiom )
                        {
                        ManchesterOWLSyntaxTree root_1 = (ManchesterOWLSyntaxTree)adaptor.nil();
                        root_1 = (ManchesterOWLSyntaxTree)adaptor.becomeRoot(stream_incompleteAxiom.nextNode(), root_1);

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 4 :
                    // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxAutoCompleteCombined.g:21:5: incompleteExpression
                    {
                    pushFollow(FOLLOW_incompleteExpression_in_main140);
                    incompleteExpression4=incompleteExpression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_incompleteExpression.add(incompleteExpression4.getTree());


                    // AST REWRITE
                    // elements: incompleteExpression
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (ManchesterOWLSyntaxTree)adaptor.nil();
                    // 21:27: -> ^( incompleteExpression )
                    {
                        // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxAutoCompleteCombined.g:21:30: ^( incompleteExpression )
                        {
                        ManchesterOWLSyntaxTree root_1 = (ManchesterOWLSyntaxTree)adaptor.nil();
                        root_1 = (ManchesterOWLSyntaxTree)adaptor.becomeRoot(stream_incompleteExpression.nextNode(), root_1);

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
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (ManchesterOWLSyntaxTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "main"

    // $ANTLR start synpred1_ManchesterOWLSyntaxAutoCompleteCombined
    public final void synpred1_ManchesterOWLSyntaxAutoCompleteCombined_fragment() throws RecognitionException {   
        // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxAutoCompleteCombined.g:18:5: ( expression )
        // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxAutoCompleteCombined.g:18:5: expression
        {
        pushFollow(FOLLOW_expression_in_synpred1_ManchesterOWLSyntaxAutoCompleteCombined100);
        expression();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred1_ManchesterOWLSyntaxAutoCompleteCombined

    // $ANTLR start synpred2_ManchesterOWLSyntaxAutoCompleteCombined
    public final void synpred2_ManchesterOWLSyntaxAutoCompleteCombined_fragment() throws RecognitionException {   
        // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxAutoCompleteCombined.g:19:5: ( axiom )
        // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxAutoCompleteCombined.g:19:5: axiom
        {
        pushFollow(FOLLOW_axiom_in_synpred2_ManchesterOWLSyntaxAutoCompleteCombined114);
        axiom();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred2_ManchesterOWLSyntaxAutoCompleteCombined

    // $ANTLR start synpred3_ManchesterOWLSyntaxAutoCompleteCombined
    public final void synpred3_ManchesterOWLSyntaxAutoCompleteCombined_fragment() throws RecognitionException {   
        // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxAutoCompleteCombined.g:20:5: ( incompleteAxiom )
        // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxAutoCompleteCombined.g:20:5: incompleteAxiom
        {
        pushFollow(FOLLOW_incompleteAxiom_in_synpred3_ManchesterOWLSyntaxAutoCompleteCombined127);
        incompleteAxiom();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred3_ManchesterOWLSyntaxAutoCompleteCombined

    // Delegated rules
    public ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase.incompleteAxiom_return incompleteAxiom() throws RecognitionException { return gManchesterOWLSyntaxAutoCompleteBase.incompleteAxiom(); }
    public ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase_MOWLParser.cardinalityRestriction_return cardinalityRestriction() throws RecognitionException { return gMOWLParser.cardinalityRestriction(); }
    public ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase.incompleteUnary_return incompleteUnary() throws RecognitionException { return gManchesterOWLSyntaxAutoCompleteBase.incompleteUnary(); }
    public ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase_MOWLParser.assertionAxiom_return assertionAxiom() throws RecognitionException { return gMOWLParser.assertionAxiom(); }
    public ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase_MOWLParser.oneOf_return oneOf() throws RecognitionException { return gMOWLParser.oneOf(); }
    public ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase.incompleteBinaryAxiom_return incompleteBinaryAxiom() throws RecognitionException { return gManchesterOWLSyntaxAutoCompleteBase.incompleteBinaryAxiom(); }
    public ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase_MOWLParser.restrictionKind_return restrictionKind() throws RecognitionException { return gMOWLParser.restrictionKind(); }
    public ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase.incompleteConjunction_return incompleteConjunction() throws RecognitionException { return gManchesterOWLSyntaxAutoCompleteBase.incompleteConjunction(); }
    public ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase_MOWLParser.unary_return unary() throws RecognitionException { return gMOWLParser.unary(); }
    public ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase_MOWLParser.unaryCharacteristic_return unaryCharacteristic() throws RecognitionException { return gMOWLParser.unaryCharacteristic(); }
    public ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase.incompleteValueRestriction_return incompleteValueRestriction() throws RecognitionException { return gManchesterOWLSyntaxAutoCompleteBase.incompleteValueRestriction(); }
    public ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase_MOWLParser.axiom_return axiom() throws RecognitionException { return gMOWLParser.axiom(); }
    public ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase_MOWLParser.valueRestriction_return valueRestriction() throws RecognitionException { return gMOWLParser.valueRestriction(); }
    public ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase_MOWLParser.qualifiedRestriction_return qualifiedRestriction() throws RecognitionException { return gMOWLParser.qualifiedRestriction(); }
    public ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase.incompleteQualifiedRestriction_return incompleteQualifiedRestriction() throws RecognitionException { return gManchesterOWLSyntaxAutoCompleteBase.incompleteQualifiedRestriction(); }
    public ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase_MOWLParser.expression_return expression() throws RecognitionException { return gMOWLParser.expression(); }
    public ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase.incompleteAssertionAxiom_return incompleteAssertionAxiom() throws RecognitionException { return gManchesterOWLSyntaxAutoCompleteBase.incompleteAssertionAxiom(); }
    public ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase_MOWLParser.value_return value() throws RecognitionException { return gMOWLParser.value(); }
    public ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase.incompleteExpression_return incompleteExpression() throws RecognitionException { return gManchesterOWLSyntaxAutoCompleteBase.incompleteExpression(); }
    public ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase_MOWLParser.conjunction_return conjunction() throws RecognitionException { return gMOWLParser.conjunction(); }
    public ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase_MOWLParser.unaryAxiom_return unaryAxiom() throws RecognitionException { return gMOWLParser.unaryAxiom(); }
    public ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase_MOWLParser.constant_return constant() throws RecognitionException { return gMOWLParser.constant(); }
    public ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase.incompleteCardinalityRestriction_return incompleteCardinalityRestriction() throws RecognitionException { return gManchesterOWLSyntaxAutoCompleteBase.incompleteCardinalityRestriction(); }
    public ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase_MOWLParser.complexPropertyExpression_return complexPropertyExpression() throws RecognitionException { return gMOWLParser.complexPropertyExpression(); }
    public ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase.incompleteOneOf_return incompleteOneOf() throws RecognitionException { return gManchesterOWLSyntaxAutoCompleteBase.incompleteOneOf(); }
    public ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase_MOWLParser.propertyExpression_return propertyExpression() throws RecognitionException { return gMOWLParser.propertyExpression(); }
    public ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase.incompleteUnaryAxiom_return incompleteUnaryAxiom() throws RecognitionException { return gManchesterOWLSyntaxAutoCompleteBase.incompleteUnaryAxiom(); }
    public ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase_MOWLParser.binaryAxiom_return binaryAxiom() throws RecognitionException { return gMOWLParser.binaryAxiom(); }
    public ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase.incompleteComplexPropertyExpression_return incompleteComplexPropertyExpression() throws RecognitionException { return gManchesterOWLSyntaxAutoCompleteBase.incompleteComplexPropertyExpression(); }
    public ManchesterOWLSyntaxAutoCompleteCombined_ManchesterOWLSyntaxAutoCompleteBase_MOWLParser.atomic_return atomic() throws RecognitionException { return gMOWLParser.atomic(); }

    public final boolean synpred3_ManchesterOWLSyntaxAutoCompleteCombined() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred3_ManchesterOWLSyntaxAutoCompleteCombined_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred2_ManchesterOWLSyntaxAutoCompleteCombined() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred2_ManchesterOWLSyntaxAutoCompleteCombined_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred1_ManchesterOWLSyntaxAutoCompleteCombined() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred1_ManchesterOWLSyntaxAutoCompleteCombined_fragment(); // can never throw exception
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
    static final String DFA1_eotS =
        "\27\uffff";
    static final String DFA1_eofS =
        "\1\1\26\uffff";
    static final String DFA1_minS =
        "\1\5\1\uffff\22\0\3\uffff";
    static final String DFA1_maxS =
        "\1\55\1\uffff\22\0\3\uffff";
    static final String DFA1_acceptS =
        "\1\uffff\1\1\22\uffff\1\2\1\3\1\4";
    static final String DFA1_specialS =
        "\2\uffff\1\0\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\13\1\14"+
        "\1\15\1\16\1\17\1\20\1\21\3\uffff}>";
    static final String[] DFA1_transitionS = {
            "\1\10\1\6\5\uffff\1\5\6\uffff\1\4\1\11\1\14\1\12\3\uffff\1\13"+
            "\2\uffff\1\15\1\17\1\20\1\21\1\22\1\23\1\16\4\uffff\1\7\3\uffff"+
            "\1\2\1\3",
            "",
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
            "\1\uffff",
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
            return "16:1: ( options {backtrack=true; } : expression -> ^( STANDALONE_EXPRESSION expression ) | axiom -> ^( axiom ) | incompleteAxiom -> ^( incompleteAxiom ) | incompleteExpression -> ^( incompleteExpression ) )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA1_2 = input.LA(1);

                         
                        int index1_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred1_ManchesterOWLSyntaxAutoCompleteCombined()) ) {s = 1;}

                        else if ( (synpred2_ManchesterOWLSyntaxAutoCompleteCombined()) ) {s = 20;}

                        else if ( (synpred3_ManchesterOWLSyntaxAutoCompleteCombined()) ) {s = 21;}

                        else if ( (true) ) {s = 22;}

                         
                        input.seek(index1_2);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA1_3 = input.LA(1);

                         
                        int index1_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred1_ManchesterOWLSyntaxAutoCompleteCombined()) ) {s = 1;}

                        else if ( (synpred2_ManchesterOWLSyntaxAutoCompleteCombined()) ) {s = 20;}

                        else if ( (synpred3_ManchesterOWLSyntaxAutoCompleteCombined()) ) {s = 21;}

                        else if ( (true) ) {s = 22;}

                         
                        input.seek(index1_3);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA1_4 = input.LA(1);

                         
                        int index1_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred1_ManchesterOWLSyntaxAutoCompleteCombined()) ) {s = 1;}

                        else if ( (synpred2_ManchesterOWLSyntaxAutoCompleteCombined()) ) {s = 20;}

                        else if ( (synpred3_ManchesterOWLSyntaxAutoCompleteCombined()) ) {s = 21;}

                        else if ( (true) ) {s = 22;}

                         
                        input.seek(index1_4);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA1_5 = input.LA(1);

                         
                        int index1_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred1_ManchesterOWLSyntaxAutoCompleteCombined()) ) {s = 1;}

                        else if ( (synpred2_ManchesterOWLSyntaxAutoCompleteCombined()) ) {s = 20;}

                        else if ( (synpred3_ManchesterOWLSyntaxAutoCompleteCombined()) ) {s = 21;}

                        else if ( (true) ) {s = 22;}

                         
                        input.seek(index1_5);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA1_6 = input.LA(1);

                         
                        int index1_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred1_ManchesterOWLSyntaxAutoCompleteCombined()) ) {s = 1;}

                        else if ( (synpred2_ManchesterOWLSyntaxAutoCompleteCombined()) ) {s = 20;}

                        else if ( (synpred3_ManchesterOWLSyntaxAutoCompleteCombined()) ) {s = 21;}

                        else if ( (true) ) {s = 22;}

                         
                        input.seek(index1_6);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA1_7 = input.LA(1);

                         
                        int index1_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred1_ManchesterOWLSyntaxAutoCompleteCombined()) ) {s = 1;}

                        else if ( (synpred2_ManchesterOWLSyntaxAutoCompleteCombined()) ) {s = 20;}

                        else if ( (synpred3_ManchesterOWLSyntaxAutoCompleteCombined()) ) {s = 21;}

                        else if ( (true) ) {s = 22;}

                         
                        input.seek(index1_7);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA1_8 = input.LA(1);

                         
                        int index1_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred1_ManchesterOWLSyntaxAutoCompleteCombined()) ) {s = 1;}

                        else if ( (synpred2_ManchesterOWLSyntaxAutoCompleteCombined()) ) {s = 20;}

                        else if ( (synpred3_ManchesterOWLSyntaxAutoCompleteCombined()) ) {s = 21;}

                        else if ( (true) ) {s = 22;}

                         
                        input.seek(index1_8);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA1_9 = input.LA(1);

                         
                        int index1_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_ManchesterOWLSyntaxAutoCompleteCombined()) ) {s = 20;}

                        else if ( (synpred3_ManchesterOWLSyntaxAutoCompleteCombined()) ) {s = 21;}

                         
                        input.seek(index1_9);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA1_10 = input.LA(1);

                         
                        int index1_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_ManchesterOWLSyntaxAutoCompleteCombined()) ) {s = 20;}

                        else if ( (synpred3_ManchesterOWLSyntaxAutoCompleteCombined()) ) {s = 21;}

                         
                        input.seek(index1_10);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA1_11 = input.LA(1);

                         
                        int index1_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_ManchesterOWLSyntaxAutoCompleteCombined()) ) {s = 20;}

                        else if ( (synpred3_ManchesterOWLSyntaxAutoCompleteCombined()) ) {s = 21;}

                         
                        input.seek(index1_11);
                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA1_12 = input.LA(1);

                         
                        int index1_12 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_ManchesterOWLSyntaxAutoCompleteCombined()) ) {s = 20;}

                        else if ( (synpred3_ManchesterOWLSyntaxAutoCompleteCombined()) ) {s = 21;}

                         
                        input.seek(index1_12);
                        if ( s>=0 ) return s;
                        break;
                    case 11 : 
                        int LA1_13 = input.LA(1);

                         
                        int index1_13 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_ManchesterOWLSyntaxAutoCompleteCombined()) ) {s = 20;}

                        else if ( (synpred3_ManchesterOWLSyntaxAutoCompleteCombined()) ) {s = 21;}

                         
                        input.seek(index1_13);
                        if ( s>=0 ) return s;
                        break;
                    case 12 : 
                        int LA1_14 = input.LA(1);

                         
                        int index1_14 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_ManchesterOWLSyntaxAutoCompleteCombined()) ) {s = 20;}

                        else if ( (synpred3_ManchesterOWLSyntaxAutoCompleteCombined()) ) {s = 21;}

                         
                        input.seek(index1_14);
                        if ( s>=0 ) return s;
                        break;
                    case 13 : 
                        int LA1_15 = input.LA(1);

                         
                        int index1_15 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_ManchesterOWLSyntaxAutoCompleteCombined()) ) {s = 20;}

                        else if ( (synpred3_ManchesterOWLSyntaxAutoCompleteCombined()) ) {s = 21;}

                         
                        input.seek(index1_15);
                        if ( s>=0 ) return s;
                        break;
                    case 14 : 
                        int LA1_16 = input.LA(1);

                         
                        int index1_16 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_ManchesterOWLSyntaxAutoCompleteCombined()) ) {s = 20;}

                        else if ( (synpred3_ManchesterOWLSyntaxAutoCompleteCombined()) ) {s = 21;}

                         
                        input.seek(index1_16);
                        if ( s>=0 ) return s;
                        break;
                    case 15 : 
                        int LA1_17 = input.LA(1);

                         
                        int index1_17 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_ManchesterOWLSyntaxAutoCompleteCombined()) ) {s = 20;}

                        else if ( (synpred3_ManchesterOWLSyntaxAutoCompleteCombined()) ) {s = 21;}

                         
                        input.seek(index1_17);
                        if ( s>=0 ) return s;
                        break;
                    case 16 : 
                        int LA1_18 = input.LA(1);

                         
                        int index1_18 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_ManchesterOWLSyntaxAutoCompleteCombined()) ) {s = 20;}

                        else if ( (synpred3_ManchesterOWLSyntaxAutoCompleteCombined()) ) {s = 21;}

                         
                        input.seek(index1_18);
                        if ( s>=0 ) return s;
                        break;
                    case 17 : 
                        int LA1_19 = input.LA(1);

                         
                        int index1_19 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_ManchesterOWLSyntaxAutoCompleteCombined()) ) {s = 20;}

                        else if ( (synpred3_ManchesterOWLSyntaxAutoCompleteCombined()) ) {s = 21;}

                         
                        input.seek(index1_19);
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
 

    public static final BitSet FOLLOW_expression_in_main100 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_axiom_in_main114 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_incompleteAxiom_in_main127 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_incompleteExpression_in_main140 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_in_synpred1_ManchesterOWLSyntaxAutoCompleteCombined100 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_axiom_in_synpred2_ManchesterOWLSyntaxAutoCompleteCombined114 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_incompleteAxiom_in_synpred3_ManchesterOWLSyntaxAutoCompleteCombined127 = new BitSet(new long[]{0x0000000000000002L});

}