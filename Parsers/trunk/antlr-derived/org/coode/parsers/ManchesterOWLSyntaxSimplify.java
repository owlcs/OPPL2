// $ANTLR 3.2 Sep 23, 2009 12:02:23 /Users/luigi/Documents/workspace/Parsers/src/ManchesterOWLSyntaxSimplify.g 2011-08-04 16:00:36

  package org.coode.parsers;


import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class ManchesterOWLSyntaxSimplify extends TreeRewriter {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "COMPOSITION", "OPEN_PARENTHESYS", "OPEN_CURLY_BRACES", "CLOSED_CURLY_BRACES", "CLOSED_PARENTHESYS", "WHITESPACE", "AND", "OR", "NOT", "SOME", "ONLY", "MIN", "MAX", "EXACTLY", "VALUE", "INVERSE", "SUBCLASS_OF", "SUB_PROPERTY_OF", "EQUIVALENT_TO", "SAME_AS", "DIFFERENT_FROM", "INVERSE_OF", "DISJOINT_WITH", "DOMAIN", "RANGE", "FUNCTIONAL", "SYMMETRIC", "ANTI_SYMMETRIC", "REFLEXIVE", "IRREFLEXIVE", "TRANSITIVE", "INVERSE_FUNCTIONAL", "POW", "COMMA", "INSTANCE_OF", "TYPES", "DBLQUOTE", "DIGIT", "INTEGER", "LETTER", "IDENTIFIER", "ENTITY_REFERENCE", "QUESTION_MARK", "Tokens", "SUB_CLASS_AXIOM", "EQUIVALENT_TO_AXIOM", "DISJOINT_WITH_AXIOM", "SUB_PROPERTY_AXIOM", "SAME_AS_AXIOM", "DIFFERENT_FROM_AXIOM", "UNARY_AXIOM", "DISJUNCTION", "CONJUNCTION", "PROPERTY_CHAIN", "NEGATED_EXPRESSION", "NEGATED_ASSERTION", "INVERSE_PROPERTY", "SOME_RESTRICTION", "ALL_RESTRICTION", "VALUE_RESTRICTION", "CARDINALITY_RESTRICTION", "ONE_OF", "TYPE_ASSERTION", "ROLE_ASSERTION", "INVERSE_OBJECT_PROPERTY_EXPRESSION", "EXPRESSION", "CONSTANT", "WHERE", "NOT_EQUAL", "EQUAL", "IN", "SELECT", "ASSERTED", "COLON", "DOT", "PLUS", "CREATE", "CREATE_INTERSECTION", "CREATE_DISJUNCTION", "BEGIN", "END", "OPEN_SQUARE_BRACKET", "CLOSED_SQUARE_BRACKET", "SUPER_CLASS_OF", "SUPER_PROPERTY_OF", "VARIABLE_TYPE", "ADD", "REMOVE", "ASSERTED_CLAUSE", "PLAIN_CLAUSE", "INEQUALITY_CONSTRAINT", "IN_SET_CONSTRAINT", "INPUT_VARIABLE_DEFINITION", "GENERATED_VARIABLE_DEFINITION", "CREATE_OPPL_FUNCTION", "VARIABLE_ATTRIBUTE", "OPPL_FUNCTION", "ACTIONS", "VARIABLE_DEFINITIONS", "QUERY", "VARIABLE_SCOPE", "SUBPROPERTY_OF", "VARIABLE_IDENTIFIER", "OPPL_STATEMENT", "DATA_RANGE", "HAS_KEY", "IRI", "ANNOTATION_ASSERTION", "AT", "ESCLAMATION_MARK", "CREATE_IDENTIFIER", "PLAIN_IDENTIFIER", "MATCH", "ATTRIBUTE_SELECTOR", "LESS_THAN", "LESS_THAN_EQUAL", "GREATER_THAN", "GREATER_THAN_EQUAL"
    };
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
    public static final int AT=114;
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
    public String getGrammarFileName() { return "/Users/luigi/Documents/workspace/Parsers/src/ManchesterOWLSyntaxSimplify.g"; }


    public static class bottomup_return extends TreeRuleReturnScope {
        ManchesterOWLSyntaxTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "bottomup"
    // /Users/luigi/Documents/workspace/Parsers/src/ManchesterOWLSyntaxSimplify.g:15:1: bottomup : ( conjunction | disjunction );
    public final ManchesterOWLSyntaxSimplify.bottomup_return bottomup() throws RecognitionException {
        ManchesterOWLSyntaxSimplify.bottomup_return retval = new ManchesterOWLSyntaxSimplify.bottomup_return();
        retval.start = input.LT(1);

        ManchesterOWLSyntaxTree root_0 = null;

        ManchesterOWLSyntaxTree _first_0 = null;
        ManchesterOWLSyntaxTree _last = null;

        ManchesterOWLSyntaxSimplify.conjunction_return conjunction1 = null;

        ManchesterOWLSyntaxSimplify.disjunction_return disjunction2 = null;



        try {
            // /Users/luigi/Documents/workspace/Parsers/src/ManchesterOWLSyntaxSimplify.g:15:11: ( conjunction | disjunction )
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
                    // /Users/luigi/Documents/workspace/Parsers/src/ManchesterOWLSyntaxSimplify.g:16:5: conjunction
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
                    // /Users/luigi/Documents/workspace/Parsers/src/ManchesterOWLSyntaxSimplify.g:17:7: disjunction
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
    // /Users/luigi/Documents/workspace/Parsers/src/ManchesterOWLSyntaxSimplify.g:21:1: conjunction : ^( CONJUNCTION single= . ) -> $single;
    public final ManchesterOWLSyntaxSimplify.conjunction_return conjunction() throws RecognitionException {
        ManchesterOWLSyntaxSimplify.conjunction_return retval = new ManchesterOWLSyntaxSimplify.conjunction_return();
        retval.start = input.LT(1);

        ManchesterOWLSyntaxTree root_0 = null;

        ManchesterOWLSyntaxTree _first_0 = null;
        ManchesterOWLSyntaxTree _last = null;

        ManchesterOWLSyntaxTree CONJUNCTION3=null;
        ManchesterOWLSyntaxTree single=null;

        ManchesterOWLSyntaxTree CONJUNCTION3_tree=null;
        ManchesterOWLSyntaxTree single_tree=null;
        RewriteRuleNodeStream stream_CONJUNCTION=new RewriteRuleNodeStream(adaptor,"token CONJUNCTION");

        try {
            // /Users/luigi/Documents/workspace/Parsers/src/ManchesterOWLSyntaxSimplify.g:21:13: ( ^( CONJUNCTION single= . ) -> $single)
            // /Users/luigi/Documents/workspace/Parsers/src/ManchesterOWLSyntaxSimplify.g:22:3: ^( CONJUNCTION single= . )
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
            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (ManchesterOWLSyntaxTree)input.LT(1);
            single=(ManchesterOWLSyntaxTree)input.LT(1);
            matchAny(input); if (state.failed) return retval;
             
            if ( state.backtracking==1 )
            if ( _first_1==null ) _first_1 = single;

            match(input, Token.UP, null); if (state.failed) return retval;_last = _save_last_1;
            }



            // AST REWRITE
            // elements: single
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: single
            if ( state.backtracking==1 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_single=new RewriteRuleSubtreeStream(adaptor,"wildcard single",single);
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (ManchesterOWLSyntaxTree)adaptor.nil();
            // 22:28: -> $single
            {
                adaptor.addChild(root_0, stream_single.nextTree());

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
    // /Users/luigi/Documents/workspace/Parsers/src/ManchesterOWLSyntaxSimplify.g:25:1: disjunction : ^( DISJUNCTION single= . ) -> $single;
    public final ManchesterOWLSyntaxSimplify.disjunction_return disjunction() throws RecognitionException {
        ManchesterOWLSyntaxSimplify.disjunction_return retval = new ManchesterOWLSyntaxSimplify.disjunction_return();
        retval.start = input.LT(1);

        ManchesterOWLSyntaxTree root_0 = null;

        ManchesterOWLSyntaxTree _first_0 = null;
        ManchesterOWLSyntaxTree _last = null;

        ManchesterOWLSyntaxTree DISJUNCTION4=null;
        ManchesterOWLSyntaxTree single=null;

        ManchesterOWLSyntaxTree DISJUNCTION4_tree=null;
        ManchesterOWLSyntaxTree single_tree=null;
        RewriteRuleNodeStream stream_DISJUNCTION=new RewriteRuleNodeStream(adaptor,"token DISJUNCTION");

        try {
            // /Users/luigi/Documents/workspace/Parsers/src/ManchesterOWLSyntaxSimplify.g:25:14: ( ^( DISJUNCTION single= . ) -> $single)
            // /Users/luigi/Documents/workspace/Parsers/src/ManchesterOWLSyntaxSimplify.g:26:2: ^( DISJUNCTION single= . )
            {
            _last = (ManchesterOWLSyntaxTree)input.LT(1);
            {
            ManchesterOWLSyntaxTree _save_last_1 = _last;
            ManchesterOWLSyntaxTree _first_1 = null;
            _last = (ManchesterOWLSyntaxTree)input.LT(1);
            DISJUNCTION4=(ManchesterOWLSyntaxTree)match(input,DISJUNCTION,FOLLOW_DISJUNCTION_in_disjunction127); if (state.failed) return retval; 
            if ( state.backtracking==1 ) stream_DISJUNCTION.add(DISJUNCTION4);


            if ( state.backtracking==1 )
            if ( _first_0==null ) _first_0 = DISJUNCTION4;
            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (ManchesterOWLSyntaxTree)input.LT(1);
            single=(ManchesterOWLSyntaxTree)input.LT(1);
            matchAny(input); if (state.failed) return retval;
             
            if ( state.backtracking==1 )
            if ( _first_1==null ) _first_1 = single;

            match(input, Token.UP, null); if (state.failed) return retval;_last = _save_last_1;
            }



            // AST REWRITE
            // elements: single
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: single
            if ( state.backtracking==1 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_single=new RewriteRuleSubtreeStream(adaptor,"wildcard single",single);
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (ManchesterOWLSyntaxTree)adaptor.nil();
            // 26:27: -> $single
            {
                adaptor.addChild(root_0, stream_single.nextTree());

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

    // Delegated rules


 

    public static final BitSet FOLLOW_conjunction_in_bottomup72 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_disjunction_in_bottomup81 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CONJUNCTION_in_conjunction101 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_DISJUNCTION_in_disjunction127 = new BitSet(new long[]{0x0000000000000004L});

}