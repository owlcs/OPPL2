// $ANTLR 3.2 Sep 23, 2009 12:02:23 /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxSimplify.g 2010-10-11 10:58:10

  package org.coode.parsers;


import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class ManchesterOWLSyntaxSimplify extends TreeRewriter {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "COMPOSITION", "OPEN_PARENTHESYS", "OPEN_CURLY_BRACES", "CLOSED_CURLY_BRACES", "CLOSED_PARENTHESYS", "WHITESPACE", "AND", "OR", "NOT", "SOME", "ONLY", "MIN", "MAX", "EXACTLY", "VALUE", "INVERSE", "SUBCLASS_OF", "SUB_PROPERTY_OF", "EQUIVALENT_TO", "SAME_AS", "DIFFERENT_FROM", "INVERSE_OF", "DISJOINT_WITH", "DOMAIN", "RANGE", "FUNCTIONAL", "SYMMETRIC", "ANTI_SYMMETRIC", "REFLEXIVE", "IRREFLEXIVE", "TRANSITIVE", "INVERSE_FUNCTIONAL", "POW", "COMMA", "INSTANCE_OF", "TYPES", "DBLQUOTE", "DIGIT", "INTEGER", "LETTER", "IDENTIFIER", "ENTITY_REFERENCE", "QUESTION_MARK", "Tokens", "SUB_CLASS_AXIOM", "EQUIVALENT_TO_AXIOM", "DISJOINT_WITH_AXIOM", "SUB_PROPERTY_AXIOM", "SAME_AS_AXIOM", "DIFFERENT_FROM_AXIOM", "UNARY_AXIOM", "DISJUNCTION", "CONJUNCTION", "PROPERTY_CHAIN", "NEGATED_EXPRESSION", "NEGATED_ASSERTION", "INVERSE_PROPERTY", "SOME_RESTRICTION", "ALL_RESTRICTION", "VALUE_RESTRICTION", "CARDINALITY_RESTRICTION", "ONE_OF", "TYPE_ASSERTION", "ROLE_ASSERTION", "INVERSE_OBJECT_PROPERTY_EXPRESSION", "EXPRESSION", "CONSTANT", "EQUAL", "OPEN_SQUARE_BRACKET", "CLOSED_SQUARE_BRACKET", "LESS_THAN", "LESS_THAN_EQUAL", "GREATER_THAN", "GREATER_THAN_EQUAL"
    };
    public static final int SAME_AS=23;
    public static final int DISJOINT_WITH=26;
    public static final int VALUE_RESTRICTION=63;
    public static final int CLOSED_PARENTHESYS=8;
    public static final int LETTER=43;
    public static final int EQUIVALENT_TO_AXIOM=49;
    public static final int ONLY=14;
    public static final int SUB_PROPERTY_OF=21;
    public static final int NEGATED_EXPRESSION=58;
    public static final int MAX=16;
    public static final int SAME_AS_AXIOM=52;
    public static final int TYPES=39;
    public static final int INVERSE_OF=25;
    public static final int NOT=12;
    public static final int AND=10;
    public static final int SUBCLASS_OF=20;
    public static final int EOF=-1;
    public static final int INVERSE_PROPERTY=60;
    public static final int DIFFERENT_FROM=24;
    public static final int POW=36;
    public static final int EQUIVALENT_TO=22;
    public static final int UNARY_AXIOM=54;
    public static final int CLOSED_CURLY_BRACES=7;
    public static final int COMMA=37;
    public static final int INVERSE_OBJECT_PROPERTY_EXPRESSION=68;
    public static final int IDENTIFIER=44;
    public static final int SOME=13;
    public static final int INSTANCE_OF=38;
    public static final int EQUAL=73;
    public static final int QUESTION_MARK=46;
    public static final int OPEN_PARENTHESYS=5;
    public static final int REFLEXIVE=32;
    public static final int SYMMETRIC=30;
    public static final int DIGIT=41;
    public static final int CARDINALITY_RESTRICTION=64;
    public static final int EXPRESSION=69;
    public static final int ROLE_ASSERTION=67;
    public static final int DIFFERENT_FROM_AXIOM=53;
    public static final int SOME_RESTRICTION=61;
    public static final int INTEGER=42;
    public static final int ANTI_SYMMETRIC=31;
    public static final int TRANSITIVE=34;
    public static final int GREATER_THAN_EQUAL=486;
    public static final int GREATER_THAN=485;
    public static final int ALL_RESTRICTION=62;
    public static final int OPEN_SQUARE_BRACKET=85;
    public static final int SUB_PROPERTY_AXIOM=51;
    public static final int EXACTLY=17;
    public static final int CONJUNCTION=56;
    public static final int NEGATED_ASSERTION=59;
    public static final int WHITESPACE=9;
    public static final int RANGE=28;
    public static final int ONE_OF=65;
    public static final int SUB_CLASS_AXIOM=48;
    public static final int MIN=15;
    public static final int VALUE=18;
    public static final int Tokens=47;
    public static final int OPEN_CURLY_BRACES=6;
    public static final int DOMAIN=27;
    public static final int DISJUNCTION=55;
    public static final int DISJOINT_WITH_AXIOM=50;
    public static final int INVERSE=19;
    public static final int INVERSE_FUNCTIONAL=35;
    public static final int IRREFLEXIVE=33;
    public static final int DBLQUOTE=40;
    public static final int OR=11;
    public static final int LESS_THAN=483;
    public static final int CONSTANT=70;
    public static final int LESS_THAN_EQUAL=484;
    public static final int PROPERTY_CHAIN=57;
    public static final int FUNCTIONAL=29;
    public static final int ENTITY_REFERENCE=45;
    public static final int TYPE_ASSERTION=66;
    public static final int COMPOSITION=4;
    public static final int CLOSED_SQUARE_BRACKET=86;

    // delegates
    // delegators


        public ManchesterOWLSyntaxSimplify(TreeNodeStream input) {
            this(input, new RecognizerSharedState());
        }
        public ManchesterOWLSyntaxSimplify(TreeNodeStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        
    protected TreeAdaptor adaptor = new CommonTreeAdaptor();

    public void setTreeAdaptor(TreeAdaptor adaptor) {
        this.adaptor = adaptor;
    }
    public TreeAdaptor getTreeAdaptor() {
        return adaptor;
    }

    public String[] getTokenNames() { return ManchesterOWLSyntaxSimplify.tokenNames; }
    public String getGrammarFileName() { return "/Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxSimplify.g"; }


    public static class bottomup_return extends TreeRuleReturnScope {
        ManchesterOWLSyntaxTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "bottomup"
    // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxSimplify.g:15:1: bottomup : ( conjunction | disjunction );
    public final ManchesterOWLSyntaxSimplify.bottomup_return bottomup() throws RecognitionException {
        ManchesterOWLSyntaxSimplify.bottomup_return retval = new ManchesterOWLSyntaxSimplify.bottomup_return();
        retval.start = input.LT(1);

        ManchesterOWLSyntaxTree root_0 = null;

        ManchesterOWLSyntaxTree _first_0 = null;
        ManchesterOWLSyntaxTree _last = null;

        ManchesterOWLSyntaxSimplify.conjunction_return conjunction1 = null;

        ManchesterOWLSyntaxSimplify.disjunction_return disjunction2 = null;



        try {
            // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxSimplify.g:15:11: ( conjunction | disjunction )
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==CONJUNCTION) ) {
                alt1=1;
            }
            else if ( (LA1_0==DISJUNCTION) ) {
                alt1=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxSimplify.g:16:5: conjunction
                    {
                    _last = (ManchesterOWLSyntaxTree)input.LT(1);
                    pushFollow(FOLLOW_conjunction_in_bottomup72);
                    conjunction1=conjunction();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==1 ) 
                     
                    if ( _first_0==null ) _first_0 = conjunction1.tree;

                    if ( state.backtracking==1 ) {
                    retval.tree = (ManchesterOWLSyntaxTree)_first_0;
                    if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
                        retval.tree = (ManchesterOWLSyntaxTree)adaptor.getParent(retval.tree);}
                    }
                    break;
                case 2 :
                    // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxSimplify.g:17:7: disjunction
                    {
                    _last = (ManchesterOWLSyntaxTree)input.LT(1);
                    pushFollow(FOLLOW_disjunction_in_bottomup81);
                    disjunction2=disjunction();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==1 ) 
                     
                    if ( _first_0==null ) _first_0 = disjunction2.tree;

                    if ( state.backtracking==1 ) {
                    retval.tree = (ManchesterOWLSyntaxTree)_first_0;
                    if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
                        retval.tree = (ManchesterOWLSyntaxTree)adaptor.getParent(retval.tree);}
                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "bottomup"

    public static class conjunction_return extends TreeRuleReturnScope {
        ManchesterOWLSyntaxTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "conjunction"
    // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxSimplify.g:21:1: conjunction : ^( CONJUNCTION single= expression ) -> ^( $single) ;
    public final ManchesterOWLSyntaxSimplify.conjunction_return conjunction() throws RecognitionException {
        ManchesterOWLSyntaxSimplify.conjunction_return retval = new ManchesterOWLSyntaxSimplify.conjunction_return();
        retval.start = input.LT(1);

        ManchesterOWLSyntaxTree root_0 = null;

        ManchesterOWLSyntaxTree _first_0 = null;
        ManchesterOWLSyntaxTree _last = null;

        ManchesterOWLSyntaxTree CONJUNCTION3=null;
        ManchesterOWLSyntaxSimplify.expression_return single = null;


        ManchesterOWLSyntaxTree CONJUNCTION3_tree=null;
        RewriteRuleNodeStream stream_CONJUNCTION=new RewriteRuleNodeStream(adaptor,"token CONJUNCTION");
        RewriteRuleSubtreeStream stream_expression=new RewriteRuleSubtreeStream(adaptor,"rule expression");
        try {
            // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxSimplify.g:21:13: ( ^( CONJUNCTION single= expression ) -> ^( $single) )
            // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxSimplify.g:22:3: ^( CONJUNCTION single= expression )
            {
            _last = (ManchesterOWLSyntaxTree)input.LT(1);
            {
            ManchesterOWLSyntaxTree _save_last_1 = _last;
            ManchesterOWLSyntaxTree _first_1 = null;
            _last = (ManchesterOWLSyntaxTree)input.LT(1);
            CONJUNCTION3=(ManchesterOWLSyntaxTree)match(input,CONJUNCTION,FOLLOW_CONJUNCTION_in_conjunction101); if (state.failed) return retval; 
            if ( state.backtracking==1 ) stream_CONJUNCTION.add(CONJUNCTION3);


            if ( state.backtracking==1 )
            if ( _first_0==null ) _first_0 = CONJUNCTION3;
            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); if (state.failed) return retval;
                _last = (ManchesterOWLSyntaxTree)input.LT(1);
                pushFollow(FOLLOW_expression_in_conjunction106);
                single=expression();

                state._fsp--;
                if (state.failed) return retval;
                if ( state.backtracking==1 ) stream_expression.add(single.getTree());

                match(input, Token.UP, null); if (state.failed) return retval;
            }_last = _save_last_1;
            }



            // AST REWRITE
            // elements: single
            // token labels: 
            // rule labels: retval, single
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==1 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
            RewriteRuleSubtreeStream stream_single=new RewriteRuleSubtreeStream(adaptor,"rule single",single!=null?single.tree:null);

            root_0 = (ManchesterOWLSyntaxTree)adaptor.nil();
            // 22:37: -> ^( $single)
            {
                // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxSimplify.g:22:40: ^( $single)
                {
                ManchesterOWLSyntaxTree root_1 = (ManchesterOWLSyntaxTree)adaptor.nil();
                root_1 = (ManchesterOWLSyntaxTree)adaptor.becomeRoot(stream_single.nextNode(), root_1);

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = (ManchesterOWLSyntaxTree)adaptor.rulePostProcessing(root_0);
            input.replaceChildren(adaptor.getParent(retval.start),
                                  adaptor.getChildIndex(retval.start),
                                  adaptor.getChildIndex(_last),
                                  retval.tree);}
            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "conjunction"

    public static class disjunction_return extends TreeRuleReturnScope {
        ManchesterOWLSyntaxTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "disjunction"
    // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxSimplify.g:25:1: disjunction : ^( DISJUNCTION single= expression ) -> ^( $single) ;
    public final ManchesterOWLSyntaxSimplify.disjunction_return disjunction() throws RecognitionException {
        ManchesterOWLSyntaxSimplify.disjunction_return retval = new ManchesterOWLSyntaxSimplify.disjunction_return();
        retval.start = input.LT(1);

        ManchesterOWLSyntaxTree root_0 = null;

        ManchesterOWLSyntaxTree _first_0 = null;
        ManchesterOWLSyntaxTree _last = null;

        ManchesterOWLSyntaxTree DISJUNCTION4=null;
        ManchesterOWLSyntaxSimplify.expression_return single = null;


        ManchesterOWLSyntaxTree DISJUNCTION4_tree=null;
        RewriteRuleNodeStream stream_DISJUNCTION=new RewriteRuleNodeStream(adaptor,"token DISJUNCTION");
        RewriteRuleSubtreeStream stream_expression=new RewriteRuleSubtreeStream(adaptor,"rule expression");
        try {
            // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxSimplify.g:25:14: ( ^( DISJUNCTION single= expression ) -> ^( $single) )
            // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxSimplify.g:26:2: ^( DISJUNCTION single= expression )
            {
            _last = (ManchesterOWLSyntaxTree)input.LT(1);
            {
            ManchesterOWLSyntaxTree _save_last_1 = _last;
            ManchesterOWLSyntaxTree _first_1 = null;
            _last = (ManchesterOWLSyntaxTree)input.LT(1);
            DISJUNCTION4=(ManchesterOWLSyntaxTree)match(input,DISJUNCTION,FOLLOW_DISJUNCTION_in_disjunction129); if (state.failed) return retval; 
            if ( state.backtracking==1 ) stream_DISJUNCTION.add(DISJUNCTION4);


            if ( state.backtracking==1 )
            if ( _first_0==null ) _first_0 = DISJUNCTION4;
            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); if (state.failed) return retval;
                _last = (ManchesterOWLSyntaxTree)input.LT(1);
                pushFollow(FOLLOW_expression_in_disjunction134);
                single=expression();

                state._fsp--;
                if (state.failed) return retval;
                if ( state.backtracking==1 ) stream_expression.add(single.getTree());

                match(input, Token.UP, null); if (state.failed) return retval;
            }_last = _save_last_1;
            }



            // AST REWRITE
            // elements: single
            // token labels: 
            // rule labels: retval, single
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==1 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
            RewriteRuleSubtreeStream stream_single=new RewriteRuleSubtreeStream(adaptor,"rule single",single!=null?single.tree:null);

            root_0 = (ManchesterOWLSyntaxTree)adaptor.nil();
            // 26:36: -> ^( $single)
            {
                // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxSimplify.g:26:39: ^( $single)
                {
                ManchesterOWLSyntaxTree root_1 = (ManchesterOWLSyntaxTree)adaptor.nil();
                root_1 = (ManchesterOWLSyntaxTree)adaptor.becomeRoot(stream_single.nextNode(), root_1);

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = (ManchesterOWLSyntaxTree)adaptor.rulePostProcessing(root_0);
            input.replaceChildren(adaptor.getParent(retval.start),
                                  adaptor.getChildIndex(retval.start),
                                  adaptor.getChildIndex(_last),
                                  retval.tree);}
            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "disjunction"

    public static class expression_return extends TreeRuleReturnScope {
        ManchesterOWLSyntaxTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "expression"
    // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxSimplify.g:29:2: expression : ( . | );
    public final ManchesterOWLSyntaxSimplify.expression_return expression() throws RecognitionException {
        ManchesterOWLSyntaxSimplify.expression_return retval = new ManchesterOWLSyntaxSimplify.expression_return();
        retval.start = input.LT(1);

        ManchesterOWLSyntaxTree root_0 = null;

        ManchesterOWLSyntaxTree _first_0 = null;
        ManchesterOWLSyntaxTree _last = null;

        ManchesterOWLSyntaxTree wildcard5=null;

        ManchesterOWLSyntaxTree wildcard5_tree=null;

        try {
            // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxSimplify.g:29:13: ( . | )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( ((LA2_0>=COMPOSITION && LA2_0<=GREATER_THAN_EQUAL)) ) {
                alt2=1;
            }
            else if ( (LA2_0==UP) ) {
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
                    // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxSimplify.g:30:3: .
                    {
                    _last = (ManchesterOWLSyntaxTree)input.LT(1);
                    wildcard5=(ManchesterOWLSyntaxTree)input.LT(1);
                    matchAny(input); if (state.failed) return retval;
                     
                    if ( state.backtracking==1 )
                    if ( _first_0==null ) _first_0 = wildcard5;

                    if ( state.backtracking==1 ) {
                    retval.tree = (ManchesterOWLSyntaxTree)_first_0;
                    if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
                        retval.tree = (ManchesterOWLSyntaxTree)adaptor.getParent(retval.tree);}
                    }
                    break;
                case 2 :
                    // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxSimplify.g:31:3: 
                    {
                    if ( state.backtracking==1 ) {
                    retval.tree = (ManchesterOWLSyntaxTree)_first_0;
                    if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
                        retval.tree = (ManchesterOWLSyntaxTree)adaptor.getParent(retval.tree);}
                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "expression"

    // Delegated rules


 

    public static final BitSet FOLLOW_conjunction_in_bottomup72 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_disjunction_in_bottomup81 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CONJUNCTION_in_conjunction101 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_conjunction106 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_DISJUNCTION_in_disjunction129 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_disjunction134 = new BitSet(new long[]{0x0000000000000008L});

}