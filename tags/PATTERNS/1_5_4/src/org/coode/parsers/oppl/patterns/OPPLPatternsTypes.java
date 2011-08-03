// $ANTLR 3.2 Sep 23, 2009 12:02:23 /Users/luigi/Documents/workspace/Parsers/src/OPPLPatternsTypes.g 2011-01-10 16:38:26

  package org.coode.parsers.oppl.patterns;
  import org.coode.parsers.ErrorListener;
  import org.coode.patterns.PatternModel;
  import org.coode.patterns.PatternConstraintSystem;
  import org.coode.patterns.AbstractPatternModelFactory;
  import org.coode.parsers.oppl.OPPLSyntaxTree;
  import org.coode.oppl.OPPLScript;
  import org.coode.oppl.Variable;
  import org.coode.patterns.UnsuitableOPPLScriptException;


import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
public class OPPLPatternsTypes extends TreeFilter {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "COMPOSITION", "OPEN_PARENTHESYS", "OPEN_CURLY_BRACES", "CLOSED_CURLY_BRACES", "CLOSED_PARENTHESYS", "WHITESPACE", "AND", "OR", "NOT", "SOME", "ONLY", "MIN", "MAX", "EXACTLY", "VALUE", "INVERSE", "SUBCLASS_OF", "SUB_PROPERTY_OF", "EQUIVALENT_TO", "SAME_AS", "DIFFERENT_FROM", "INVERSE_OF", "DISJOINT_WITH", "DOMAIN", "RANGE", "FUNCTIONAL", "SYMMETRIC", "ANTI_SYMMETRIC", "REFLEXIVE", "IRREFLEXIVE", "TRANSITIVE", "INVERSE_FUNCTIONAL", "POW", "COMMA", "INSTANCE_OF", "TYPES", "DBLQUOTE", "DIGIT", "INTEGER", "LETTER", "IDENTIFIER", "ENTITY_REFERENCE", "QUESTION_MARK", "Tokens", "SUB_CLASS_AXIOM", "EQUIVALENT_TO_AXIOM", "DISJOINT_WITH_AXIOM", "SUB_PROPERTY_AXIOM", "SAME_AS_AXIOM", "DIFFERENT_FROM_AXIOM", "UNARY_AXIOM", "DISJUNCTION", "CONJUNCTION", "PROPERTY_CHAIN", "NEGATED_EXPRESSION", "NEGATED_ASSERTION", "INVERSE_PROPERTY", "SOME_RESTRICTION", "ALL_RESTRICTION", "VALUE_RESTRICTION", "CARDINALITY_RESTRICTION", "ONE_OF", "TYPE_ASSERTION", "ROLE_ASSERTION", "INVERSE_OBJECT_PROPERTY_EXPRESSION", "EXPRESSION", "CONSTANT", "WHERE", "NOT_EQUAL", "EQUAL", "IN", "SELECT", "ASSERTED", "COLON", "DOT", "PLUS", "CREATE", "CREATE_INTERSECTION", "CREATE_DISJUNCTION", "BEGIN", "END", "OPEN_SQUARE_BRACKET", "CLOSED_SQUARE_BRACKET", "SUPER_CLASS_OF", "SUPER_PROPERTY_OF", "VARIABLE_TYPE", "ADD", "REMOVE", "ASSERTED_CLAUSE", "PLAIN_CLAUSE", "INEQUALITY_CONSTRAINT", "IN_SET_CONSTRAINT", "INPUT_VARIABLE_DEFINITION", "GENERATED_VARIABLE_DEFINITION", "CREATE_OPPL_FUNCTION", "VARIABLE_ATTRIBUTE", "OPPL_FUNCTION", "ACTIONS", "VARIABLE_DEFINITIONS", "QUERY", "VARIABLE_SCOPE", "SUBPROPERTY_OF", "VARIABLE_IDENTIFIER", "OPPL_STATEMENT", "HAS_KEY", "IRI", "ANNOTATION_ASSERTION", "IRI_ATTRIBUTE_NAME", "ARGUMENT", "AT", "ESCLAMATION_MARK", "CREATE_IDENTIFIER", "PLAIN_IDENTIFIER", "MATCH", "ATTRIBUTE_SELECTOR", "VALUES", "RENDERING", "GROUPS", "STRING_OPERATION", "DOLLAR", "RETURN", "THIS_CLASS", "ARGUMENTS", "OPPL_PATTERN", "PATTERN_REFERENCE", "SEMICOLON", "VARIABLE_NAME", "REGEXP_CONSTRAINT", "FAIL", "NAF_CONSTRAINT"
    };
    public static final int COMMA=37;
    public static final int ASSERTED=76;
    public static final int VARIABLE_DEFINITIONS=102;
    public static final int REGEXP_CONSTRAINT=465;
    public static final int END=84;
    public static final int HYPHEN=465;
    public static final int DIFFERENT_FROM=24;
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
    public static final int AT=114;
    public static final int RANGE=28;
    public static final int ARGUMENTS=417;
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
    public static final int ARGUMENT=113;
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
    // delegators


        public OPPLPatternsTypes(TreeNodeStream input) {
            this(input, new RecognizerSharedState());
        }
        public OPPLPatternsTypes(TreeNodeStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return OPPLPatternsTypes.tokenNames; }
    public String getGrammarFileName() { return "/Users/luigi/Documents/workspace/Parsers/src/OPPLPatternsTypes.g"; }


      private  OPPLPatternsSymbolTable symtab;
      private  ErrorListener errorListener;
      private PatternConstraintSystem constraintSystem;
      private AbstractPatternModelFactory patternModelFactory;
      
      public OPPLPatternsTypes(TreeNodeStream input, OPPLPatternsSymbolTable symtab, ErrorListener errorListener, PatternConstraintSystem constraintSystem, AbstractPatternModelFactory patternModelFactory) {
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
        if(patternModelFactory == null){
          throw new NullPointerException("The OPPL Pattern Factory cannot be null");
        }
        this.symtab = symtab;
        this.errorListener = errorListener;
        this.patternModelFactory = patternModelFactory;
        this.constraintSystem = constraintSystem;
        
      }
      
      public ErrorListener getErrorListener(){
      	return this.errorListener;
      }
      
      public PatternConstraintSystem getConstraintSystem(){
        return this.constraintSystem;
      }
      
      public OPPLPatternsSymbolTable getSymbolTable(){
      	return this.symtab;
      }
      
      public AbstractPatternModelFactory getPatternModelFactory(){
        return this.patternModelFactory;
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
    // /Users/luigi/Documents/workspace/Parsers/src/OPPLPatternsTypes.g:95:1: bottomup : pattern ;
    public final void bottomup() throws RecognitionException {
        try {
            // /Users/luigi/Documents/workspace/Parsers/src/OPPLPatternsTypes.g:96:5: ( pattern )
            // /Users/luigi/Documents/workspace/Parsers/src/OPPLPatternsTypes.g:97:6: pattern
            {
            pushFollow(FOLLOW_pattern_in_bottomup81);
            pattern();

            state._fsp--;
            if (state.failed) return ;

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

    public static class pattern_return extends TreeRuleReturnScope {
    };

    // $ANTLR start "pattern"
    // /Users/luigi/Documents/workspace/Parsers/src/OPPLPatternsTypes.g:101:1: pattern : ^( OPPL_PATTERN ^(s= OPPL_STATEMENT ( . )* ) (ren= rendering )? (rc= returnClause )? ) ;
    public final OPPLPatternsTypes.pattern_return pattern() throws RecognitionException {
        OPPLPatternsTypes.pattern_return retval = new OPPLPatternsTypes.pattern_return();
        retval.start = input.LT(1);

        OPPLSyntaxTree s=null;
        String ren = null;

        Variable rc = null;


        try {
            // /Users/luigi/Documents/workspace/Parsers/src/OPPLPatternsTypes.g:102:2: ( ^( OPPL_PATTERN ^(s= OPPL_STATEMENT ( . )* ) (ren= rendering )? (rc= returnClause )? ) )
            // /Users/luigi/Documents/workspace/Parsers/src/OPPLPatternsTypes.g:103:3: ^( OPPL_PATTERN ^(s= OPPL_STATEMENT ( . )* ) (ren= rendering )? (rc= returnClause )? )
            {
            match(input,OPPL_PATTERN,FOLLOW_OPPL_PATTERN_in_pattern99); if (state.failed) return retval;

            match(input, Token.DOWN, null); if (state.failed) return retval;
            s=(OPPLSyntaxTree)match(input,OPPL_STATEMENT,FOLLOW_OPPL_STATEMENT_in_pattern106); if (state.failed) return retval;

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); if (state.failed) return retval;
                // /Users/luigi/Documents/workspace/Parsers/src/OPPLPatternsTypes.g:103:39: ( . )*
                loop1:
                do {
                    int alt1=2;
                    int LA1_0 = input.LA(1);

                    if ( ((LA1_0>=COMPOSITION && LA1_0<=NAF_CONSTRAINT)) ) {
                        alt1=1;
                    }
                    else if ( (LA1_0==UP) ) {
                        alt1=2;
                    }


                    switch (alt1) {
                	case 1 :
                	    // /Users/luigi/Documents/workspace/Parsers/src/OPPLPatternsTypes.g:103:39: .
                	    {
                	    matchAny(input); if (state.failed) return retval;

                	    }
                	    break;

                	default :
                	    break loop1;
                    }
                } while (true);


                match(input, Token.UP, null); if (state.failed) return retval;
            }
            // /Users/luigi/Documents/workspace/Parsers/src/OPPLPatternsTypes.g:103:47: (ren= rendering )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==RENDERING) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // /Users/luigi/Documents/workspace/Parsers/src/OPPLPatternsTypes.g:103:47: ren= rendering
                    {
                    pushFollow(FOLLOW_rendering_in_pattern116);
                    ren=rendering();

                    state._fsp--;
                    if (state.failed) return retval;

                    }
                    break;

            }

            // /Users/luigi/Documents/workspace/Parsers/src/OPPLPatternsTypes.g:103:63: (rc= returnClause )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==RETURN) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // /Users/luigi/Documents/workspace/Parsers/src/OPPLPatternsTypes.g:103:63: rc= returnClause
                    {
                    pushFollow(FOLLOW_returnClause_in_pattern123);
                    rc=returnClause();

                    state._fsp--;
                    if (state.failed) return retval;

                    }
                    break;

            }


            match(input, Token.UP, null); if (state.failed) return retval;
            if ( state.backtracking==1 ) {

              		  if(s.getOPPLContent() instanceof OPPLScript){
              		    try {
                        PatternModel patternModel = this.getPatternModelFactory().createPatternModel(
                                              (OPPLScript) s.getOPPLContent());
                        if(rc!=null){                                
                          patternModel.setReturnVariable(rc);
                        }
                        if(ren!=null){
                          patternModel.setRendering(ren);
                        }
                        ((OPPLSyntaxTree)retval.start).setOPPLContent(patternModel);
                      } catch (UnsuitableOPPLScriptException e) {
                        getErrorListener().illegalToken(s, "Unsuitable OPPL statement for a pattern "+e.getMessage());              
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
    // $ANTLR end "pattern"


    // $ANTLR start "rendering"
    // /Users/luigi/Documents/workspace/Parsers/src/OPPLPatternsTypes.g:123:1: rendering returns [String string] : ^( RENDERING ( renderingPart )+ ) ;
    public final String rendering() throws RecognitionException {
        String string = null;

        OPPLSyntaxTree RENDERING1=null;

        try {
            // /Users/luigi/Documents/workspace/Parsers/src/OPPLPatternsTypes.g:124:3: ( ^( RENDERING ( renderingPart )+ ) )
            // /Users/luigi/Documents/workspace/Parsers/src/OPPLPatternsTypes.g:125:5: ^( RENDERING ( renderingPart )+ )
            {
            RENDERING1=(OPPLSyntaxTree)match(input,RENDERING,FOLLOW_RENDERING_in_rendering153); if (state.failed) return string;

            match(input, Token.DOWN, null); if (state.failed) return string;
            // /Users/luigi/Documents/workspace/Parsers/src/OPPLPatternsTypes.g:125:17: ( renderingPart )+
            int cnt4=0;
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==IDENTIFIER||LA4_0==THIS_CLASS||(LA4_0>=VARIABLE_NAME && LA4_0<=REGEXP_CONSTRAINT)) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // /Users/luigi/Documents/workspace/Parsers/src/OPPLPatternsTypes.g:125:17: renderingPart
            	    {
            	    pushFollow(FOLLOW_renderingPart_in_rendering155);
            	    renderingPart();

            	    state._fsp--;
            	    if (state.failed) return string;

            	    }
            	    break;

            	default :
            	    if ( cnt4 >= 1 ) break loop4;
            	    if (state.backtracking>0) {state.failed=true; return string;}
                        EarlyExitException eee =
                            new EarlyExitException(4, input);
                        throw eee;
                }
                cnt4++;
            } while (true);


            match(input, Token.UP, null); if (state.failed) return string;
            if ( state.backtracking==1 ) {

                    string = RENDERING1.getText();
                  
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
        return string;
    }
    // $ANTLR end "rendering"


    // $ANTLR start "renderingPart"
    // /Users/luigi/Documents/workspace/Parsers/src/OPPLPatternsTypes.g:131:1: renderingPart : ( IDENTIFIER | VARIABLE_NAME | THIS_CLASS | HYPHEN );
    public final void renderingPart() throws RecognitionException {
        OPPLSyntaxTree VARIABLE_NAME2=null;

        try {
            // /Users/luigi/Documents/workspace/Parsers/src/OPPLPatternsTypes.g:132:3: ( IDENTIFIER | VARIABLE_NAME | THIS_CLASS | HYPHEN )
            int alt5=4;
            switch ( input.LA(1) ) {
            case IDENTIFIER:
                {
                alt5=1;
                }
                break;
            case VARIABLE_NAME:
                {
                alt5=2;
                }
                break;
            case THIS_CLASS:
                {
                alt5=3;
                }
                break;
            case REGEXP_CONSTRAINT:
                {
                alt5=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }

            switch (alt5) {
                case 1 :
                    // /Users/luigi/Documents/workspace/Parsers/src/OPPLPatternsTypes.g:133:7: IDENTIFIER
                    {
                    match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_renderingPart182); if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // /Users/luigi/Documents/workspace/Parsers/src/OPPLPatternsTypes.g:134:7: VARIABLE_NAME
                    {
                    VARIABLE_NAME2=(OPPLSyntaxTree)match(input,VARIABLE_NAME,FOLLOW_VARIABLE_NAME_in_renderingPart190); if (state.failed) return ;
                    if ( state.backtracking==1 ) {

                              Variable variable = getConstraintSystem().getVariable(VARIABLE_NAME2.getText());
                              if(variable==null){
                                if(getErrorListener()!=null){
                                  getErrorListener().illegalToken(VARIABLE_NAME2, "Undefined variable");
                                }
                              }
                            
                    }

                    }
                    break;
                case 3 :
                    // /Users/luigi/Documents/workspace/Parsers/src/OPPLPatternsTypes.g:143:7: THIS_CLASS
                    {
                    match(input,THIS_CLASS,FOLLOW_THIS_CLASS_in_renderingPart206); if (state.failed) return ;

                    }
                    break;
                case 4 :
                    // /Users/luigi/Documents/workspace/Parsers/src/OPPLPatternsTypes.g:144:7: HYPHEN
                    {
                    match(input,REGEXP_CONSTRAINT,FOLLOW_REGEXP_CONSTRAINT_in_renderingPart214); if (state.failed) return ;

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
    // $ANTLR end "renderingPart"


    // $ANTLR start "returnClause"
    // /Users/luigi/Documents/workspace/Parsers/src/OPPLPatternsTypes.g:147:1: returnClause returns [Variable variable] : ( ^( RETURN VARIABLE_NAME ) | ^( RETURN THIS_CLASS ) );
    public final Variable returnClause() throws RecognitionException {
        Variable variable = null;

        OPPLSyntaxTree VARIABLE_NAME3=null;

        try {
            // /Users/luigi/Documents/workspace/Parsers/src/OPPLPatternsTypes.g:148:3: ( ^( RETURN VARIABLE_NAME ) | ^( RETURN THIS_CLASS ) )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==RETURN) ) {
                int LA6_1 = input.LA(2);

                if ( (LA6_1==DOWN) ) {
                    int LA6_2 = input.LA(3);

                    if ( (LA6_2==VARIABLE_NAME) ) {
                        alt6=1;
                    }
                    else if ( (LA6_2==THIS_CLASS) ) {
                        alt6=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return variable;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 6, 2, input);

                        throw nvae;
                    }
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return variable;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 6, 1, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return variable;}
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // /Users/luigi/Documents/workspace/Parsers/src/OPPLPatternsTypes.g:149:7: ^( RETURN VARIABLE_NAME )
                    {
                    match(input,RETURN,FOLLOW_RETURN_in_returnClause242); if (state.failed) return variable;

                    match(input, Token.DOWN, null); if (state.failed) return variable;
                    VARIABLE_NAME3=(OPPLSyntaxTree)match(input,VARIABLE_NAME,FOLLOW_VARIABLE_NAME_in_returnClause244); if (state.failed) return variable;

                    match(input, Token.UP, null); if (state.failed) return variable;
                    if ( state.backtracking==1 ) {

                              variable = getConstraintSystem().getVariable(VARIABLE_NAME3.getText());
                              if(variable==null){
                                if(getErrorListener()!=null){
                                  getErrorListener().illegalToken(VARIABLE_NAME3, "Undefined variable");
                                }
                              }
                            
                    }

                    }
                    break;
                case 2 :
                    // /Users/luigi/Documents/workspace/Parsers/src/OPPLPatternsTypes.g:158:7: ^( RETURN THIS_CLASS )
                    {
                    match(input,RETURN,FOLLOW_RETURN_in_returnClause262); if (state.failed) return variable;

                    match(input, Token.DOWN, null); if (state.failed) return variable;
                    match(input,THIS_CLASS,FOLLOW_THIS_CLASS_in_returnClause264); if (state.failed) return variable;

                    match(input, Token.UP, null); if (state.failed) return variable;
                    if ( state.backtracking==1 ) {

                              variable = getConstraintSystem().getThisClassVariable();
                            
                    }

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
        return variable;
    }
    // $ANTLR end "returnClause"

    // Delegated rules


 

    public static final BitSet FOLLOW_pattern_in_bottomup81 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OPPL_PATTERN_in_pattern99 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_OPPL_STATEMENT_in_pattern106 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rendering_in_pattern116 = new BitSet(new long[]{0x0000000000000008L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000080000000L});
    public static final BitSet FOLLOW_returnClause_in_pattern123 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_RENDERING_in_rendering153 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_renderingPart_in_rendering155 = new BitSet(new long[]{0x0000100000000008L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000100000000L,0x0000000000030000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_renderingPart182 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_VARIABLE_NAME_in_renderingPart190 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_THIS_CLASS_in_renderingPart206 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_REGEXP_CONSTRAINT_in_renderingPart214 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RETURN_in_returnClause242 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_VARIABLE_NAME_in_returnClause244 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_RETURN_in_returnClause262 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_THIS_CLASS_in_returnClause264 = new BitSet(new long[]{0x0000000000000008L});

}