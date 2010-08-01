// $ANTLR 3.2 Sep 23, 2009 12:02:23 /Users/luigi/Documents/workspace/PARSERS/src/OPPLLintTypes.g 2010-07-31 00:48:46

  package org.coode.parsers.oppl.lint;
  import org.coode.parsers.ErrorListener;
  import org.coode.oppl.lint.OPPLLintAbstractFactory;
  import org.coode.oppl.lint.OPPLLintScript;
  import org.coode.parsers.oppl.OPPLSyntaxTree;
  import org.coode.oppl.OPPLScript;
  import org.coode.oppl.Variable;
  import org.coode.oppl.ConstraintSystem;
  import org.coode.parsers.oppl.OPPLSymbolTable;


import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
public class OPPLLintTypes extends TreeFilter {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "COMPOSITION", "OPEN_PARENTHESYS", "OPEN_CURLY_BRACES", "CLOSED_CURLY_BRACES", "CLOSED_PARENTHESYS", "WHITESPACE", "AND", "OR", "NOT", "SOME", "ONLY", "MIN", "MAX", "EXACTLY", "VALUE", "INVERSE", "SUBCLASS_OF", "SUB_PROPERTY_OF", "EQUIVALENT_TO", "SAME_AS", "DIFFERENT_FROM", "INVERSE_OF", "DISJOINT_WITH", "DOMAIN", "RANGE", "FUNCTIONAL", "SYMMETRIC", "ANTI_SYMMETRIC", "REFLEXIVE", "IRREFLEXIVE", "TRANSITIVE", "INVERSE_FUNCTIONAL", "POW", "COMMA", "INSTANCE_OF", "TYPES", "DBLQUOTE", "DIGIT", "INTEGER", "LETTER", "IDENTIFIER", "ENTITY_REFERENCE", "QUESTION_MARK", "Tokens", "SUB_CLASS_AXIOM", "EQUIVALENT_TO_AXIOM", "DISJOINT_WITH_AXIOM", "SUB_PROPERTY_AXIOM", "SAME_AS_AXIOM", "DIFFERENT_FROM_AXIOM", "UNARY_AXIOM", "DISJUNCTION", "CONJUNCTION", "PROPERTY_CHAIN", "NEGATED_EXPRESSION", "NEGATED_ASSERTION", "INVERSE_PROPERTY", "SOME_RESTRICTION", "ALL_RESTRICTION", "VALUE_RESTRICTION", "CARDINALITY_RESTRICTION", "ONE_OF", "TYPE_ASSERTION", "ROLE_ASSERTION", "INVERSE_OBJECT_PROPERTY_EXPRESSION", "EXPRESSION", "CONSTANT", "WHERE", "NOT_EQUAL", "EQUAL", "IN", "SELECT", "ASSERTED", "COLON", "DOT", "PLUS", "CREATE", "CREATE_INTERSECTION", "CREATE_DISJUNCTION", "BEGIN", "END", "OPEN_SQUARE_BRACKET", "CLOSED_SQUARE_BRACKET", "SUPER_CLASS_OF", "SUPER_PROPERTY_OF", "VARIABLE_TYPE", "ADD", "REMOVE", "ASSERTED_CLAUSE", "PLAIN_CLAUSE", "INEQUALITY_CONSTRAINT", "IN_SET_CONSTRAINT", "INPUT_VARIABLE_DEFINITION", "GENERATED_VARIABLE_DEFINITION", "CREATE_OPPL_FUNCTION", "VARIABLE_ATTRIBUTE", "OPPL_FUNCTION", "ACTIONS", "VARIABLE_DEFINITIONS", "QUERY", "VARIABLE_SCOPE", "VARIABLE_IDENTIFIER", "OPPL_STATEMENT", "OPPL_LINT", "ESCLAMATION_MARK", "MATCH", "VALUES", "RENDERING", "GROUPS", "DOLLAR", "RETURN", "SEMICOLON", "VARIABLE_NAME", "DESCRIPTION", "EXPLANATION", "TEXT"
    };
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
    public static final int SYMMETRIC=30;
    public static final int CARDINALITY_RESTRICTION=64;
    public static final int SELECT=75;
    public static final int ROLE_ASSERTION=67;
    public static final int DIFFERENT_FROM_AXIOM=53;
    public static final int CREATE_OPPL_FUNCTION=98;
    public static final int TRANSITIVE=34;
    public static final int ANTI_SYMMETRIC=31;
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
    public static final int OPPL_LINT=119;
    public static final int DBLQUOTE=40;
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
    public static final int VARIABLE_NAME=464;
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
    public static final int EXPLANATION=469;
    public static final int GENERATED_VARIABLE_DEFINITION=97;
    public static final int EXACTLY=17;
    public static final int SUB_PROPERTY_AXIOM=51;
    public static final int OPEN_SQUARE_BRACKET=85;
    public static final int VALUES=354;
    public static final int RANGE=28;
    public static final int ONE_OF=65;
    public static final int VARIABLE_DEFINITIONS=102;
    public static final int MIN=15;
    public static final int SUB_CLASS_AXIOM=48;
    public static final int TEXT=470;
    public static final int PLAIN_CLAUSE=93;
    public static final int Tokens=47;
    public static final int DOMAIN=27;
    public static final int OPPL_FUNCTION=100;
    public static final int COLON=77;
    public static final int DISJOINT_WITH_AXIOM=50;
    public static final int CREATE_INTERSECTION=81;
    public static final int INVERSE_FUNCTIONAL=35;
    public static final int RENDERING=355;
    public static final int VARIABLE_IDENTIFIER=106;
    public static final int IRREFLEXIVE=33;
    public static final int VARIABLE_ATTRIBUTE=99;
    public static final int ASSERTED=76;
    public static final int FUNCTIONAL=29;
    public static final int PROPERTY_CHAIN=57;
    public static final int TYPE_ASSERTION=66;

    // delegates
    // delegators


        public OPPLLintTypes(TreeNodeStream input) {
            this(input, new RecognizerSharedState());
        }
        public OPPLLintTypes(TreeNodeStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return OPPLLintTypes.tokenNames; }
    public String getGrammarFileName() { return "/Users/luigi/Documents/workspace/PARSERS/src/OPPLLintTypes.g"; }


      private OPPLSymbolTable symtab;
      private ErrorListener errorListener;
      private ConstraintSystem constraintSystem;
      private OPPLLintAbstractFactory lintModelFactory;
      
      public OPPLLintTypes(TreeNodeStream input, OPPLSymbolTable symtab, ErrorListener errorListener, ConstraintSystem constraintSystem, OPPLLintAbstractFactory lintModelFactory) {
        this(input);
        if(symtab==null){
        	throw new NullPointerException("The symbol table cannot be null");
        }
        if(errorListener == null){
        	throw new NullPointerException("The error listener cannot be null");
        }
        if(constraintSystem == null){
          throw new NullPointerException("The constraint system cannot be null");
        }
        if(lintModelFactory == null){
          throw new NullPointerException("The OPPL Lint Factory cannot be null");
        }
        this.symtab = symtab;
        this.errorListener = errorListener;
        this.lintModelFactory = lintModelFactory;
        this.constraintSystem = constraintSystem;
        
      }
      
      public ErrorListener getErrorListener(){
      	return this.errorListener;
      }
      
      public ConstraintSystem getConstraintSystem(){
        return this.constraintSystem;
      }
      
      public OPPLSymbolTable getSymbolTable(){
      	return this.symtab;
      }
      
      public OPPLLintAbstractFactory getLintModelFactory(){
        return this.lintModelFactory;
      }
      
      public void displayRecognitionError(String[] tokenNames, RecognitionException e) {
            getErrorListener().recognitionException(e, tokenNames);
      }
      
      protected void mismatch (IntStream input, int ttype, BitSet follow) throws RecognitionException {
        throw new MismatchedTokenException(ttype,input);
      }
      

      public Object recoverFromMismatchedSet(IntStream input, RecognitionException e, BitSet follow) throws RecognitionException{
        throw e;
      }
      



    // $ANTLR start "bottomup"
    // /Users/luigi/Documents/workspace/PARSERS/src/OPPLLintTypes.g:95:1: bottomup : ( lint | textVariableRef );
    public final void bottomup() throws RecognitionException {
        try {
            // /Users/luigi/Documents/workspace/PARSERS/src/OPPLLintTypes.g:96:5: ( lint | textVariableRef )
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==OPPL_LINT) ) {
                alt1=1;
            }
            else if ( (LA1_0==TEXT) ) {
                alt1=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // /Users/luigi/Documents/workspace/PARSERS/src/OPPLLintTypes.g:97:6: lint
                    {
                    pushFollow(FOLLOW_lint_in_bottomup81);
                    lint();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // /Users/luigi/Documents/workspace/PARSERS/src/OPPLLintTypes.g:98:8: textVariableRef
                    {
                    pushFollow(FOLLOW_textVariableRef_in_bottomup90);
                    textVariableRef();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }
        }

          catch(RecognitionException exception){
            if(errorListener!=null){
              errorListener.recognitionException(exception);
            }
          }
          
          catch(RewriteEmptyStreamException exception){
            if(errorListener!=null){
              errorListener.rewriteEmptyStreamException(exception);
            }
          }
        finally {
        }
        return ;
    }
    // $ANTLR end "bottomup"

    public static class lint_return extends TreeRuleReturnScope {
    };

    // $ANTLR start "lint"
    // /Users/luigi/Documents/workspace/PARSERS/src/OPPLLintTypes.g:102:1: lint : ^( OPPL_LINT IDENTIFIER ^(s= OPPL_STATEMENT ( . )* ) rc= returnClause ^( EXPLANATION ( . )* ) ^( DESCRIPTION ( . )* ) ) ;
    public final OPPLLintTypes.lint_return lint() throws RecognitionException {
        OPPLLintTypes.lint_return retval = new OPPLLintTypes.lint_return();
        retval.start = input.LT(1);

        OPPLSyntaxTree s=null;
        OPPLSyntaxTree IDENTIFIER1=null;
        OPPLSyntaxTree EXPLANATION2=null;
        OPPLSyntaxTree DESCRIPTION3=null;
        Variable rc = null;


        try {
            // /Users/luigi/Documents/workspace/PARSERS/src/OPPLLintTypes.g:103:2: ( ^( OPPL_LINT IDENTIFIER ^(s= OPPL_STATEMENT ( . )* ) rc= returnClause ^( EXPLANATION ( . )* ) ^( DESCRIPTION ( . )* ) ) )
            // /Users/luigi/Documents/workspace/PARSERS/src/OPPLLintTypes.g:104:3: ^( OPPL_LINT IDENTIFIER ^(s= OPPL_STATEMENT ( . )* ) rc= returnClause ^( EXPLANATION ( . )* ) ^( DESCRIPTION ( . )* ) )
            {
            match(input,OPPL_LINT,FOLLOW_OPPL_LINT_in_lint108); if (state.failed) return retval;

            match(input, Token.DOWN, null); if (state.failed) return retval;
            IDENTIFIER1=(OPPLSyntaxTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_lint110); if (state.failed) return retval;
            s=(OPPLSyntaxTree)match(input,OPPL_STATEMENT,FOLLOW_OPPL_STATEMENT_in_lint117); if (state.failed) return retval;

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); if (state.failed) return retval;
                // /Users/luigi/Documents/workspace/PARSERS/src/OPPLLintTypes.g:104:47: ( . )*
                loop2:
                do {
                    int alt2=2;
                    int LA2_0 = input.LA(1);

                    if ( ((LA2_0>=COMPOSITION && LA2_0<=TEXT)) ) {
                        alt2=1;
                    }
                    else if ( (LA2_0==UP) ) {
                        alt2=2;
                    }


                    switch (alt2) {
                	case 1 :
                	    // /Users/luigi/Documents/workspace/PARSERS/src/OPPLLintTypes.g:104:47: .
                	    {
                	    matchAny(input); if (state.failed) return retval;

                	    }
                	    break;

                	default :
                	    break loop2;
                    }
                } while (true);


                match(input, Token.UP, null); if (state.failed) return retval;
            }
            pushFollow(FOLLOW_returnClause_in_lint126);
            rc=returnClause();

            state._fsp--;
            if (state.failed) return retval;
            EXPLANATION2=(OPPLSyntaxTree)match(input,EXPLANATION,FOLLOW_EXPLANATION_in_lint129); if (state.failed) return retval;

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); if (state.failed) return retval;
                // /Users/luigi/Documents/workspace/PARSERS/src/OPPLLintTypes.g:104:82: ( . )*
                loop3:
                do {
                    int alt3=2;
                    int LA3_0 = input.LA(1);

                    if ( ((LA3_0>=COMPOSITION && LA3_0<=TEXT)) ) {
                        alt3=1;
                    }
                    else if ( (LA3_0==UP) ) {
                        alt3=2;
                    }


                    switch (alt3) {
                	case 1 :
                	    // /Users/luigi/Documents/workspace/PARSERS/src/OPPLLintTypes.g:104:82: .
                	    {
                	    matchAny(input); if (state.failed) return retval;

                	    }
                	    break;

                	default :
                	    break loop3;
                    }
                } while (true);


                match(input, Token.UP, null); if (state.failed) return retval;
            }
            DESCRIPTION3=(OPPLSyntaxTree)match(input,DESCRIPTION,FOLLOW_DESCRIPTION_in_lint136); if (state.failed) return retval;

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); if (state.failed) return retval;
                // /Users/luigi/Documents/workspace/PARSERS/src/OPPLLintTypes.g:104:100: ( . )*
                loop4:
                do {
                    int alt4=2;
                    int LA4_0 = input.LA(1);

                    if ( ((LA4_0>=COMPOSITION && LA4_0<=TEXT)) ) {
                        alt4=1;
                    }
                    else if ( (LA4_0==UP) ) {
                        alt4=2;
                    }


                    switch (alt4) {
                	case 1 :
                	    // /Users/luigi/Documents/workspace/PARSERS/src/OPPLLintTypes.g:104:100: .
                	    {
                	    matchAny(input); if (state.failed) return retval;

                	    }
                	    break;

                	default :
                	    break loop4;
                    }
                } while (true);


                match(input, Token.UP, null); if (state.failed) return retval;
            }

            match(input, Token.UP, null); if (state.failed) return retval;
            if ( state.backtracking==1 ) {

              		  if(s.getOPPLContent() instanceof OPPLScript){

              		     if(rc!=null){                                
                         		 Variable v = rc;
              			OPPLLintScript lint = this.getLintModelFactory().buildOPPLLintScript((IDENTIFIER1!=null?IDENTIFIER1.getText():null),
                                              (OPPLScript) s.getOPPLContent(),v, (EXPLANATION2!=null?EXPLANATION2.getText():null), (DESCRIPTION3!=null?DESCRIPTION3.getText():null));
                                      ((OPPLSyntaxTree)retval.start).setOPPLContent(lint);        
              	             }                    
              		  }  
              		
            }

            }

        }

          catch(RecognitionException exception){
            if(errorListener!=null){
              errorListener.recognitionException(exception);
            }
          }
          
          catch(RewriteEmptyStreamException exception){
            if(errorListener!=null){
              errorListener.rewriteEmptyStreamException(exception);
            }
          }
        finally {
        }
        return retval;
    }
    // $ANTLR end "lint"


    // $ANTLR start "returnClause"
    // /Users/luigi/Documents/workspace/PARSERS/src/OPPLLintTypes.g:118:1: returnClause returns [Variable variable] : ^( RETURN VARIABLE_NAME ) ;
    public final Variable returnClause() throws RecognitionException {
        Variable variable = null;

        OPPLSyntaxTree VARIABLE_NAME4=null;

        try {
            // /Users/luigi/Documents/workspace/PARSERS/src/OPPLLintTypes.g:119:3: ( ^( RETURN VARIABLE_NAME ) )
            // /Users/luigi/Documents/workspace/PARSERS/src/OPPLLintTypes.g:120:7: ^( RETURN VARIABLE_NAME )
            {
            match(input,RETURN,FOLLOW_RETURN_in_returnClause172); if (state.failed) return variable;

            match(input, Token.DOWN, null); if (state.failed) return variable;
            VARIABLE_NAME4=(OPPLSyntaxTree)match(input,VARIABLE_NAME,FOLLOW_VARIABLE_NAME_in_returnClause174); if (state.failed) return variable;

            match(input, Token.UP, null); if (state.failed) return variable;
            if ( state.backtracking==1 ) {

                      variable = getConstraintSystem().getVariable(VARIABLE_NAME4.getText());
                      if(variable==null){
                        if(getErrorListener()!=null){
                          getErrorListener().illegalToken(VARIABLE_NAME4, "Undefined variable");
                        }
                      }
                    
            }

            }

        }

          catch(RecognitionException exception){
            if(errorListener!=null){
              errorListener.recognitionException(exception);
            }
          }
          
          catch(RewriteEmptyStreamException exception){
            if(errorListener!=null){
              errorListener.rewriteEmptyStreamException(exception);
            }
          }
        finally {
        }
        return variable;
    }
    // $ANTLR end "returnClause"


    // $ANTLR start "textVariableRef"
    // /Users/luigi/Documents/workspace/PARSERS/src/OPPLLintTypes.g:131:2: textVariableRef : ^( TEXT VARIABLE_NAME ) ;
    public final void textVariableRef() throws RecognitionException {
        OPPLSyntaxTree VARIABLE_NAME5=null;

        try {
            // /Users/luigi/Documents/workspace/PARSERS/src/OPPLLintTypes.g:132:3: ( ^( TEXT VARIABLE_NAME ) )
            // /Users/luigi/Documents/workspace/PARSERS/src/OPPLLintTypes.g:133:4: ^( TEXT VARIABLE_NAME )
            {
            match(input,TEXT,FOLLOW_TEXT_in_textVariableRef204); if (state.failed) return ;

            match(input, Token.DOWN, null); if (state.failed) return ;
            VARIABLE_NAME5=(OPPLSyntaxTree)match(input,VARIABLE_NAME,FOLLOW_VARIABLE_NAME_in_textVariableRef207); if (state.failed) return ;

            match(input, Token.UP, null); if (state.failed) return ;
            if ( state.backtracking==1 ) {

               	 Variable variable = getConstraintSystem().getVariable(VARIABLE_NAME5.getText());
                      if(variable==null){
                        if(getErrorListener()!=null){
                          getErrorListener().illegalToken(VARIABLE_NAME5, "Undefined variable");
                        }
                      }
               		
            }

            }

        }

          catch(RecognitionException exception){
            if(errorListener!=null){
              errorListener.recognitionException(exception);
            }
          }
          
          catch(RewriteEmptyStreamException exception){
            if(errorListener!=null){
              errorListener.rewriteEmptyStreamException(exception);
            }
          }
        finally {
        }
        return ;
    }
    // $ANTLR end "textVariableRef"

    // Delegated rules


 

    public static final BitSet FOLLOW_lint_in_bottomup81 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_textVariableRef_in_bottomup90 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OPPL_LINT_in_lint108 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENTIFIER_in_lint110 = new BitSet(new long[]{0x0000000000000000L,0x0000080000000000L});
    public static final BitSet FOLLOW_OPPL_STATEMENT_in_lint117 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_returnClause_in_lint126 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000200000L});
    public static final BitSet FOLLOW_EXPLANATION_in_lint129 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_DESCRIPTION_in_lint136 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_RETURN_in_returnClause172 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_VARIABLE_NAME_in_returnClause174 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_TEXT_in_textVariableRef204 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_VARIABLE_NAME_in_textVariableRef207 = new BitSet(new long[]{0x0000000000000008L});

}