// $ANTLR 3.2 Sep 23, 2009 12:02:23 /Users/luigi/Documents/workspace/PARSERS/src/OPPLTestCaseTypes.g 2010-08-30 18:43:17

  package org.coode.parsers.oppl.testcase;
  import org.coode.parsers.ErrorListener;
  import org.coode.parsers.oppl.OPPLSyntaxTree;
  import org.coode.oppl.OPPLScript;
  import org.coode.oppl.Variable;
  import org.coode.oppl.ConstraintSystem;
  import org.coode.parsers.oppl.testcase.OPPLTestCaseSymbolTable;
  import org.semanticweb.owlapi.model.OWLAxiomChange;
  import java.util.Collections;
  import org.coode.oppl.OPPLQuery;


import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
public class OPPLTestCaseTypes extends TreeFilter {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "COMPOSITION", "OPEN_PARENTHESYS", "OPEN_CURLY_BRACES", "CLOSED_CURLY_BRACES", "CLOSED_PARENTHESYS", "WHITESPACE", "AND", "OR", "NOT", "SOME", "ONLY", "MIN", "MAX", "EXACTLY", "VALUE", "INVERSE", "SUBCLASS_OF", "SUB_PROPERTY_OF", "EQUIVALENT_TO", "SAME_AS", "DIFFERENT_FROM", "INVERSE_OF", "DISJOINT_WITH", "DOMAIN", "RANGE", "FUNCTIONAL", "SYMMETRIC", "ANTI_SYMMETRIC", "REFLEXIVE", "IRREFLEXIVE", "TRANSITIVE", "INVERSE_FUNCTIONAL", "POW", "COMMA", "INSTANCE_OF", "TYPES", "DBLQUOTE", "DIGIT", "INTEGER", "LETTER", "IDENTIFIER", "ENTITY_REFERENCE", "QUESTION_MARK", "Tokens", "SUB_CLASS_AXIOM", "EQUIVALENT_TO_AXIOM", "DISJOINT_WITH_AXIOM", "SUB_PROPERTY_AXIOM", "SAME_AS_AXIOM", "DIFFERENT_FROM_AXIOM", "UNARY_AXIOM", "DISJUNCTION", "CONJUNCTION", "PROPERTY_CHAIN", "NEGATED_EXPRESSION", "NEGATED_ASSERTION", "INVERSE_PROPERTY", "SOME_RESTRICTION", "ALL_RESTRICTION", "VALUE_RESTRICTION", "CARDINALITY_RESTRICTION", "ONE_OF", "TYPE_ASSERTION", "ROLE_ASSERTION", "INVERSE_OBJECT_PROPERTY_EXPRESSION", "EXPRESSION", "CONSTANT", "WHERE", "NOT_EQUAL", "EQUAL", "IN", "SELECT", "ASSERTED", "COLON", "DOT", "PLUS", "CREATE", "CREATE_INTERSECTION", "CREATE_DISJUNCTION", "BEGIN", "END", "OPEN_SQUARE_BRACKET", "CLOSED_SQUARE_BRACKET", "SUPER_CLASS_OF", "SUPER_PROPERTY_OF", "VARIABLE_TYPE", "ADD", "REMOVE", "ASSERTED_CLAUSE", "PLAIN_CLAUSE", "INEQUALITY_CONSTRAINT", "IN_SET_CONSTRAINT", "INPUT_VARIABLE_DEFINITION", "GENERATED_VARIABLE_DEFINITION", "CREATE_OPPL_FUNCTION", "VARIABLE_ATTRIBUTE", "OPPL_FUNCTION", "ACTIONS", "VARIABLE_DEFINITIONS", "QUERY", "VARIABLE_SCOPE", "SUBPROPERTY_OF", "VARIABLE_IDENTIFIER", "OPPL_STATEMENT", "ESCLAMATION_MARK", "MATCH", "ATTRIBUTE_SELECTOR", "VALUES", "RENDERING", "GROUPS", "STRING_OPERATION", "VARIABLE_NAME", "REGEXP_CONSTRAINT", "FAIL", "NAF_CONSTRAINT", "COUNT", "SEMICOLON", "INFERENCE", "CONTAINS", "OPPL_TEST_CASE", "MESSAGE", "TEST", "ASSERT_EQUAL", "ASSERT_NOT_EQUAL", "ASSERT_TRUE", "ASSERT_FALSE", "TEXT", "ASSERT"
    };
    public static final int VALUE_RESTRICTION=63;
    public static final int LETTER=43;
    public static final int CONTAINS=471;
    public static final int ASSERT_TRUE=478;
    public static final int REMOVE=91;
    public static final int ASSERT_FALSE=479;
    public static final int TYPES=39;
    public static final int SAME_AS_AXIOM=52;
    public static final int COUNT=468;
    public static final int INVERSE_OF=25;
    public static final int NOT=12;
    public static final int SUBCLASS_OF=20;
    public static final int EOF=-1;
    public static final int ESCLAMATION_MARK=149;
    public static final int ACTIONS=101;
    public static final int CREATE=80;
    public static final int POW=36;
    public static final int INPUT_VARIABLE_DEFINITION=96;
    public static final int NOT_EQUAL=72;
    public static final int INVERSE_OBJECT_PROPERTY_EXPRESSION=68;
    public static final int INSTANCE_OF=38;
    public static final int BEGIN=83;
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
    public static final int INFERENCE=470;
    public static final int ALL_RESTRICTION=62;
    public static final int CONJUNCTION=56;
    public static final int OPPL_STATEMENT=107;
    public static final int NEGATED_ASSERTION=59;
    public static final int WHITESPACE=9;
    public static final int MATCH=176;
    public static final int IN_SET_CONSTRAINT=95;
    public static final int SEMICOLON=469;
    public static final int VALUE=18;
    public static final int ASSERT=481;
    public static final int FAIL=466;
    public static final int GROUPS=356;
    public static final int OPEN_CURLY_BRACES=6;
    public static final int ASSERT_EQUAL=476;
    public static final int DISJUNCTION=55;
    public static final int INVERSE=19;
    public static final int ASSERT_NOT_EQUAL=477;
    public static final int NAF_CONSTRAINT=467;
    public static final int DBLQUOTE=40;
    public static final int STRING_OPERATION=394;
    public static final int OR=11;
    public static final int TEST=475;
    public static final int CONSTANT=70;
    public static final int QUERY=103;
    public static final int ENTITY_REFERENCE=45;
    public static final int END=84;
    public static final int COMPOSITION=4;
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
    public static final int MESSAGE=474;
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
    public static final int TEXT=480;
    public static final int PLAIN_CLAUSE=93;
    public static final int OPPL_TEST_CASE=473;
    public static final int Tokens=47;
    public static final int DOMAIN=27;
    public static final int SUBPROPERTY_OF=105;
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


        public OPPLTestCaseTypes(TreeNodeStream input) {
            this(input, new RecognizerSharedState());
        }
        public OPPLTestCaseTypes(TreeNodeStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return OPPLTestCaseTypes.tokenNames; }
    public String getGrammarFileName() { return "/Users/luigi/Documents/workspace/PARSERS/src/OPPLTestCaseTypes.g"; }


      private OPPLTestCaseSymbolTable symtab;
      private ErrorListener errorListener;
      private ConstraintSystem constraintSystem;
      private AbstractOPPLTestCaseFactory testCaseFactory;
      
      public OPPLTestCaseTypes(TreeNodeStream input, OPPLTestCaseSymbolTable symtab, ErrorListener errorListener, ConstraintSystem constraintSystem, AbstractOPPLTestCaseFactory testCaseFactory) {
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
        if(testCaseFactory == null){
          throw new NullPointerException("The OPPL Lint Factory cannot be null");
        }
        this.symtab = symtab;
        this.errorListener = errorListener;
        this.testCaseFactory = testCaseFactory;
        this.constraintSystem = constraintSystem;
        
      }
      
      public ErrorListener getErrorListener(){
      	return this.errorListener;
      }
      
      public ConstraintSystem getConstraintSystem(){
        return this.constraintSystem;
      }
      
      public OPPLTestCaseSymbolTable getSymbolTable(){
      	return this.symtab;
      }
      
      public AbstractOPPLTestCaseFactory getTestCaseFactory(){
        return this.testCaseFactory;
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
    // /Users/luigi/Documents/workspace/PARSERS/src/OPPLTestCaseTypes.g:96:1: bottomup : ( testCase | textVariableRef );
    public final void bottomup() throws RecognitionException {
        try {
            // /Users/luigi/Documents/workspace/PARSERS/src/OPPLTestCaseTypes.g:97:5: ( testCase | textVariableRef )
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==OPPL_TEST_CASE) ) {
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
                    // /Users/luigi/Documents/workspace/PARSERS/src/OPPLTestCaseTypes.g:98:6: testCase
                    {
                    pushFollow(FOLLOW_testCase_in_bottomup81);
                    testCase();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // /Users/luigi/Documents/workspace/PARSERS/src/OPPLTestCaseTypes.g:99:8: textVariableRef
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

    public static class testCase_return extends TreeRuleReturnScope {
    };

    // $ANTLR start "testCase"
    // /Users/luigi/Documents/workspace/PARSERS/src/OPPLTestCaseTypes.g:103:1: testCase : ^( OPPL_TEST_CASE (inference= INFERENCE )? s= statement ) ;
    public final OPPLTestCaseTypes.testCase_return testCase() throws RecognitionException {
        OPPLTestCaseTypes.testCase_return retval = new OPPLTestCaseTypes.testCase_return();
        retval.start = input.LT(1);

        OPPLSyntaxTree inference=null;
        OPPLTestCaseTypes.statement_return s = null;


        try {
            // /Users/luigi/Documents/workspace/PARSERS/src/OPPLTestCaseTypes.g:104:2: ( ^( OPPL_TEST_CASE (inference= INFERENCE )? s= statement ) )
            // /Users/luigi/Documents/workspace/PARSERS/src/OPPLTestCaseTypes.g:105:3: ^( OPPL_TEST_CASE (inference= INFERENCE )? s= statement )
            {
            match(input,OPPL_TEST_CASE,FOLLOW_OPPL_TEST_CASE_in_testCase108); if (state.failed) return retval;

            match(input, Token.DOWN, null); if (state.failed) return retval;
            // /Users/luigi/Documents/workspace/PARSERS/src/OPPLTestCaseTypes.g:105:31: (inference= INFERENCE )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==INFERENCE) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // /Users/luigi/Documents/workspace/PARSERS/src/OPPLTestCaseTypes.g:105:31: inference= INFERENCE
                    {
                    inference=(OPPLSyntaxTree)match(input,INFERENCE,FOLLOW_INFERENCE_in_testCase115); if (state.failed) return retval;

                    }
                    break;

            }

            pushFollow(FOLLOW_statement_in_testCase122);
            s=statement();

            state._fsp--;
            if (state.failed) return retval;

            match(input, Token.UP, null); if (state.failed) return retval;
            if ( state.backtracking==1 ) {

              		  if(s.statementTree.getOPPLContent() instanceof OPPLScript){
              			OPPLTestCase testCase = this.getTestCaseFactory().buildOPPLTestCase(
              			(OPPLScript) s.statementTree.getOPPLContent());
              			((OPPLSyntaxTree)retval.start).setOPPLContent(testCase);        
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
    // $ANTLR end "testCase"

    public static class statement_return extends TreeRuleReturnScope {
        public OPPLSyntaxTree statementTree;
    };

    // $ANTLR start "statement"
    // /Users/luigi/Documents/workspace/PARSERS/src/OPPLTestCaseTypes.g:115:1: statement returns [OPPLSyntaxTree statementTree] : ^( OPPL_STATEMENT ( ^(vd= VARIABLE_DEFINITIONS ( . )* ) )? ^(query= QUERY ( . )* ) ( ^(a= ACTIONS ( . )* ) )? ) ;
    public final OPPLTestCaseTypes.statement_return statement() throws RecognitionException {
        OPPLTestCaseTypes.statement_return retval = new OPPLTestCaseTypes.statement_return();
        retval.start = input.LT(1);

        OPPLSyntaxTree vd=null;
        OPPLSyntaxTree query=null;
        OPPLSyntaxTree a=null;


        	List<Variable> vds = new ArrayList<Variable>();
        	

        try {
            // /Users/luigi/Documents/workspace/PARSERS/src/OPPLTestCaseTypes.g:123:2: ( ^( OPPL_STATEMENT ( ^(vd= VARIABLE_DEFINITIONS ( . )* ) )? ^(query= QUERY ( . )* ) ( ^(a= ACTIONS ( . )* ) )? ) )
            // /Users/luigi/Documents/workspace/PARSERS/src/OPPLTestCaseTypes.g:124:3: ^( OPPL_STATEMENT ( ^(vd= VARIABLE_DEFINITIONS ( . )* ) )? ^(query= QUERY ( . )* ) ( ^(a= ACTIONS ( . )* ) )? )
            {
            match(input,OPPL_STATEMENT,FOLLOW_OPPL_STATEMENT_in_statement158); if (state.failed) return retval;

            match(input, Token.DOWN, null); if (state.failed) return retval;
            // /Users/luigi/Documents/workspace/PARSERS/src/OPPLTestCaseTypes.g:124:21: ( ^(vd= VARIABLE_DEFINITIONS ( . )* ) )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==VARIABLE_DEFINITIONS) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // /Users/luigi/Documents/workspace/PARSERS/src/OPPLTestCaseTypes.g:124:22: ^(vd= VARIABLE_DEFINITIONS ( . )* )
                    {
                    vd=(OPPLSyntaxTree)match(input,VARIABLE_DEFINITIONS,FOLLOW_VARIABLE_DEFINITIONS_in_statement167); if (state.failed) return retval;

                    if ( input.LA(1)==Token.DOWN ) {
                        match(input, Token.DOWN, null); if (state.failed) return retval;
                        // /Users/luigi/Documents/workspace/PARSERS/src/OPPLTestCaseTypes.g:124:50: ( . )*
                        loop3:
                        do {
                            int alt3=2;
                            int LA3_0 = input.LA(1);

                            if ( ((LA3_0>=COMPOSITION && LA3_0<=ASSERT)) ) {
                                alt3=1;
                            }
                            else if ( (LA3_0==UP) ) {
                                alt3=2;
                            }


                            switch (alt3) {
                        	case 1 :
                        	    // /Users/luigi/Documents/workspace/PARSERS/src/OPPLTestCaseTypes.g:124:50: .
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

                    }
                    break;

            }

            query=(OPPLSyntaxTree)match(input,QUERY,FOLLOW_QUERY_in_statement179); if (state.failed) return retval;

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); if (state.failed) return retval;
                // /Users/luigi/Documents/workspace/PARSERS/src/OPPLTestCaseTypes.g:124:71: ( . )*
                loop5:
                do {
                    int alt5=2;
                    int LA5_0 = input.LA(1);

                    if ( ((LA5_0>=COMPOSITION && LA5_0<=ASSERT)) ) {
                        alt5=1;
                    }
                    else if ( (LA5_0==UP) ) {
                        alt5=2;
                    }


                    switch (alt5) {
                	case 1 :
                	    // /Users/luigi/Documents/workspace/PARSERS/src/OPPLTestCaseTypes.g:124:71: .
                	    {
                	    matchAny(input); if (state.failed) return retval;

                	    }
                	    break;

                	default :
                	    break loop5;
                    }
                } while (true);


                match(input, Token.UP, null); if (state.failed) return retval;
            }
            // /Users/luigi/Documents/workspace/PARSERS/src/OPPLTestCaseTypes.g:124:76: ( ^(a= ACTIONS ( . )* ) )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==ACTIONS) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // /Users/luigi/Documents/workspace/PARSERS/src/OPPLTestCaseTypes.g:124:77: ^(a= ACTIONS ( . )* )
                    {
                    a=(OPPLSyntaxTree)match(input,ACTIONS,FOLLOW_ACTIONS_in_statement192); if (state.failed) return retval;

                    if ( input.LA(1)==Token.DOWN ) {
                        match(input, Token.DOWN, null); if (state.failed) return retval;
                        // /Users/luigi/Documents/workspace/PARSERS/src/OPPLTestCaseTypes.g:124:91: ( . )*
                        loop6:
                        do {
                            int alt6=2;
                            int LA6_0 = input.LA(1);

                            if ( ((LA6_0>=COMPOSITION && LA6_0<=ASSERT)) ) {
                                alt6=1;
                            }
                            else if ( (LA6_0==UP) ) {
                                alt6=2;
                            }


                            switch (alt6) {
                        	case 1 :
                        	    // /Users/luigi/Documents/workspace/PARSERS/src/OPPLTestCaseTypes.g:124:91: .
                        	    {
                        	    matchAny(input); if (state.failed) return retval;

                        	    }
                        	    break;

                        	default :
                        	    break loop6;
                            }
                        } while (true);


                        match(input, Token.UP, null); if (state.failed) return retval;
                    }

                    }
                    break;

            }


            match(input, Token.UP, null); if (state.failed) return retval;
            if ( state.backtracking==1 ) {

              				if(vd!=null){
              				vds.addAll((List<Variable>)vd.getOPPLContent());
              			}
              			
              			 if(query.getOPPLContent()!=null){
              			    ((OPPLSyntaxTree)retval.start).setOPPLContent(getTestCaseFactory().getOPPLFactory().buildOPPLScript(getConstraintSystem(),
              				    					vds,(OPPLQuery) query.getOPPLContent(),
              					    				Collections.<OWLAxiomChange>emptyList()));
              			 }else{
              			    getErrorListener().illegalToken(((OPPLSyntaxTree)retval.start),"Invalid query content");
              			 }		  
              		
            }

            }

            if ( state.backtracking==1 ) {

              	retval.statementTree = ((OPPLSyntaxTree)retval.start);

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
    // $ANTLR end "statement"


    // $ANTLR start "textVariableRef"
    // /Users/luigi/Documents/workspace/PARSERS/src/OPPLTestCaseTypes.g:143:2: textVariableRef : ^( TEXT VARIABLE_NAME ) ;
    public final void textVariableRef() throws RecognitionException {
        OPPLSyntaxTree VARIABLE_NAME1=null;

        try {
            // /Users/luigi/Documents/workspace/PARSERS/src/OPPLTestCaseTypes.g:144:3: ( ^( TEXT VARIABLE_NAME ) )
            // /Users/luigi/Documents/workspace/PARSERS/src/OPPLTestCaseTypes.g:145:4: ^( TEXT VARIABLE_NAME )
            {
            match(input,TEXT,FOLLOW_TEXT_in_textVariableRef226); if (state.failed) return ;

            match(input, Token.DOWN, null); if (state.failed) return ;
            VARIABLE_NAME1=(OPPLSyntaxTree)match(input,VARIABLE_NAME,FOLLOW_VARIABLE_NAME_in_textVariableRef229); if (state.failed) return ;

            match(input, Token.UP, null); if (state.failed) return ;
            if ( state.backtracking==1 ) {

               	 Variable variable = getConstraintSystem().getVariable(VARIABLE_NAME1.getText());
                      if(variable==null){
                        if(getErrorListener()!=null){
                          getErrorListener().illegalToken(VARIABLE_NAME1, "Undefined variable");
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


 

    public static final BitSet FOLLOW_testCase_in_bottomup81 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_textVariableRef_in_bottomup90 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OPPL_TEST_CASE_in_testCase108 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_INFERENCE_in_testCase115 = new BitSet(new long[]{0x0000000000000000L,0x0000080000000000L});
    public static final BitSet FOLLOW_statement_in_testCase122 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_OPPL_STATEMENT_in_statement158 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_VARIABLE_DEFINITIONS_in_statement167 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_QUERY_in_statement179 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ACTIONS_in_statement192 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_TEXT_in_textVariableRef226 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_VARIABLE_NAME_in_textVariableRef229 = new BitSet(new long[]{0x0000000000000008L});

}