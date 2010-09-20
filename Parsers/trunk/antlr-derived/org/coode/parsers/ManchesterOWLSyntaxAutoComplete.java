// $ANTLR 3.2 Sep 23, 2009 12:02:23 /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxAutoComplete.g 2010-09-20 18:37:47

  package org.coode.parsers;
  import java.util.Collections;
  import org.semanticweb.owlapi.model.OWLObject;
  


import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
public class ManchesterOWLSyntaxAutoComplete extends TreeFilter {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "COMPOSITION", "OPEN_PARENTHESYS", "OPEN_CURLY_BRACES", "CLOSED_CURLY_BRACES", "CLOSED_PARENTHESYS", "WHITESPACE", "AND", "OR", "NOT", "SOME", "ONLY", "MIN", "MAX", "EXACTLY", "VALUE", "INVERSE", "SUBCLASS_OF", "SUB_PROPERTY_OF", "EQUIVALENT_TO", "SAME_AS", "DIFFERENT_FROM", "INVERSE_OF", "DISJOINT_WITH", "DOMAIN", "RANGE", "FUNCTIONAL", "SYMMETRIC", "ANTI_SYMMETRIC", "REFLEXIVE", "IRREFLEXIVE", "TRANSITIVE", "INVERSE_FUNCTIONAL", "POW", "COMMA", "INSTANCE_OF", "TYPES", "DBLQUOTE", "DIGIT", "INTEGER", "LETTER", "IDENTIFIER", "ENTITY_REFERENCE", "RULE", "Tokens", "SUB_CLASS_AXIOM", "EQUIVALENT_TO_AXIOM", "DISJOINT_WITH_AXIOM", "SUB_PROPERTY_AXIOM", "SAME_AS_AXIOM", "DIFFERENT_FROM_AXIOM", "UNARY_AXIOM", "DISJUNCTION", "CONJUNCTION", "PROPERTY_CHAIN", "NEGATED_EXPRESSION", "NEGATED_ASSERTION", "INVERSE_PROPERTY", "SOME_RESTRICTION", "ALL_RESTRICTION", "VALUE_RESTRICTION", "CARDINALITY_RESTRICTION", "ONE_OF", "TYPE_ASSERTION", "ROLE_ASSERTION", "INVERSE_OBJECT_PROPERTY_EXPRESSION", "EXPRESSION", "CONSTANT", "STANDALONE_EXPRESSION", "INCOMPLETE_TYPE_ASSERTION", "INCOMPLETE_ROLE_ASSERTION", "INCOMPLETE_UNARY_AXIOM", "INCOMPLETE_SUB_CLASS_AXIOM", "INCOMPLETE_EQUIVALENT_TO_AXIOM", "INCOMPLETE_DISJOINT_WITH_AXIOM", "INCOMPLETE_SUB_PROPERTY_AXIOM", "INCOMPLETE_SAME_AS_AXIOM", "INCOMPLETE_DIFFERENT_FROM_AXIOM", "INCOMPLETE_DOMAIN", "INCOMPLETE_RANGE", "INCOMPLETE_INVERSE_OF", "INCOMPLETE_PROPERTY_CHAIN", "INCOMPLETE_DISJUNCTION", "INCOMPLETE_CONJUNCTION", "INCOMPLETE_INVERSE_OBJECT_PROPERTY_EXPRESSION", "INCOMPLETE_NEGATED_EXPRESSION", "INCOMPLETE_SOME_RESTRICTION", "INCOMPLETE_ALL_RESTRICTION", "INCOMPLETE_CARDINALITY_RESTRICTION", "INCOMPLETE_ONE_OF", "INCOMPLETE_VALUE_RESTRICTION", "INCOMPLETE_EXPRESSION"
    };
    public static final int VALUE_RESTRICTION=63;
    public static final int INCOMPLETE_INVERSE_OF=83;
    public static final int LETTER=43;
    public static final int TYPES=39;
    public static final int SAME_AS_AXIOM=52;
    public static final int INVERSE_OF=25;
    public static final int NOT=12;
    public static final int SUBCLASS_OF=20;
    public static final int EOF=-1;
    public static final int INCOMPLETE_ONE_OF=92;
    public static final int POW=36;
    public static final int INCOMPLETE_INVERSE_OBJECT_PROPERTY_EXPRESSION=87;
    public static final int INVERSE_OBJECT_PROPERTY_EXPRESSION=68;
    public static final int INSTANCE_OF=38;
    public static final int INCOMPLETE_TYPE_ASSERTION=72;
    public static final int SYMMETRIC=30;
    public static final int INCOMPLETE_NEGATED_EXPRESSION=88;
    public static final int INCOMPLETE_DIFFERENT_FROM_AXIOM=80;
    public static final int INCOMPLETE_SUB_PROPERTY_AXIOM=78;
    public static final int CARDINALITY_RESTRICTION=64;
    public static final int ROLE_ASSERTION=67;
    public static final int DIFFERENT_FROM_AXIOM=53;
    public static final int INCOMPLETE_ALL_RESTRICTION=90;
    public static final int INCOMPLETE_SUB_CLASS_AXIOM=75;
    public static final int ANTI_SYMMETRIC=31;
    public static final int TRANSITIVE=34;
    public static final int RULE=46;
    public static final int ALL_RESTRICTION=62;
    public static final int CONJUNCTION=56;
    public static final int NEGATED_ASSERTION=59;
    public static final int WHITESPACE=9;
    public static final int VALUE=18;
    public static final int OPEN_CURLY_BRACES=6;
    public static final int DISJUNCTION=55;
    public static final int INVERSE=19;
    public static final int INCOMPLETE_ROLE_ASSERTION=73;
    public static final int INCOMPLETE_SOME_RESTRICTION=89;
    public static final int DBLQUOTE=40;
    public static final int OR=11;
    public static final int CONSTANT=70;
    public static final int INCOMPLETE_EXPRESSION=94;
    public static final int ENTITY_REFERENCE=45;
    public static final int COMPOSITION=4;
    public static final int INCOMPLETE_DISJOINT_WITH_AXIOM=77;
    public static final int INCOMPLETE_VALUE_RESTRICTION=93;
    public static final int SAME_AS=23;
    public static final int INCOMPLETE_CONJUNCTION=86;
    public static final int DISJOINT_WITH=26;
    public static final int CLOSED_PARENTHESYS=8;
    public static final int ONLY=14;
    public static final int EQUIVALENT_TO_AXIOM=49;
    public static final int INCOMPLETE_EQUIVALENT_TO_AXIOM=76;
    public static final int SUB_PROPERTY_OF=21;
    public static final int NEGATED_EXPRESSION=58;
    public static final int MAX=16;
    public static final int AND=10;
    public static final int INVERSE_PROPERTY=60;
    public static final int DIFFERENT_FROM=24;
    public static final int EQUIVALENT_TO=22;
    public static final int UNARY_AXIOM=54;
    public static final int COMMA=37;
    public static final int CLOSED_CURLY_BRACES=7;
    public static final int INCOMPLETE_CARDINALITY_RESTRICTION=91;
    public static final int IDENTIFIER=44;
    public static final int SOME=13;
    public static final int OPEN_PARENTHESYS=5;
    public static final int REFLEXIVE=32;
    public static final int DIGIT=41;
    public static final int EXPRESSION=69;
    public static final int SOME_RESTRICTION=61;
    public static final int INTEGER=42;
    public static final int INCOMPLETE_DISJUNCTION=85;
    public static final int INCOMPLETE_SAME_AS_AXIOM=79;
    public static final int INCOMPLETE_RANGE=82;
    public static final int EXACTLY=17;
    public static final int SUB_PROPERTY_AXIOM=51;
    public static final int RANGE=28;
    public static final int ONE_OF=65;
    public static final int MIN=15;
    public static final int SUB_CLASS_AXIOM=48;
    public static final int Tokens=47;
    public static final int DOMAIN=27;
    public static final int DISJOINT_WITH_AXIOM=50;
    public static final int STANDALONE_EXPRESSION=71;
    public static final int INVERSE_FUNCTIONAL=35;
    public static final int IRREFLEXIVE=33;
    public static final int INCOMPLETE_PROPERTY_CHAIN=84;
    public static final int INCOMPLETE_DOMAIN=81;
    public static final int FUNCTIONAL=29;
    public static final int PROPERTY_CHAIN=57;
    public static final int INCOMPLETE_UNARY_AXIOM=74;
    public static final int TYPE_ASSERTION=66;

    // delegates
    // delegators


        public ManchesterOWLSyntaxAutoComplete(TreeNodeStream input) {
            this(input, new RecognizerSharedState());
        }
        public ManchesterOWLSyntaxAutoComplete(TreeNodeStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return ManchesterOWLSyntaxAutoComplete.tokenNames; }
    public String getGrammarFileName() { return "/Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxAutoComplete.g"; }


      private  SymbolTable symtab;
      private boolean newWord= false;
      
      public ManchesterOWLSyntaxAutoComplete(TreeNodeStream input, SymbolTable symtab) {
        this(input);
        if(symtab==null){
        	throw new NullPointerException("The symbol table cannot be null");
        }
        
        this.symtab = symtab;
      
      }
      
      
      public boolean isNewWord(){
      	return this.newWord;
      }
      
      public void setNewWord(boolean b){
      	this.newWord = b;
      }
      
      public SymbolTable getSymbolTable(){
      	return this.symtab;
      }
       
      public void displayRecognitionError(String[] tokenNames, RecognitionException e) {
        
      }
      
      protected void mismatch (IntStream input, int ttype, BitSet follow) throws RecognitionException {
        
      }
      

      public Object recoverFromMismatchedSet(IntStream input, RecognitionException e, BitSet follow) throws RecognitionException{
        return null;
      }
      



    // $ANTLR start "bottomup"
    // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxAutoComplete.g:72:1: bottomup : ( axiom | standaloneExpression | expressionRoot | incompleteAxiom | incompleteExpression );
    public final void bottomup() throws RecognitionException {
        try {
            // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxAutoComplete.g:73:5: ( axiom | standaloneExpression | expressionRoot | incompleteAxiom | incompleteExpression )
            int alt1=5;
            switch ( input.LA(1) ) {
            case INVERSE_OF:
            case DOMAIN:
            case RANGE:
            case SUB_CLASS_AXIOM:
            case EQUIVALENT_TO_AXIOM:
            case DISJOINT_WITH_AXIOM:
            case SUB_PROPERTY_AXIOM:
            case SAME_AS_AXIOM:
            case DIFFERENT_FROM_AXIOM:
            case UNARY_AXIOM:
            case NEGATED_ASSERTION:
            case TYPE_ASSERTION:
            case ROLE_ASSERTION:
                {
                alt1=1;
                }
                break;
            case STANDALONE_EXPRESSION:
                {
                alt1=2;
                }
                break;
            case EXPRESSION:
                {
                alt1=3;
                }
                break;
            case INCOMPLETE_TYPE_ASSERTION:
            case INCOMPLETE_ROLE_ASSERTION:
            case INCOMPLETE_UNARY_AXIOM:
            case INCOMPLETE_SUB_CLASS_AXIOM:
            case INCOMPLETE_EQUIVALENT_TO_AXIOM:
            case INCOMPLETE_DISJOINT_WITH_AXIOM:
            case INCOMPLETE_SUB_PROPERTY_AXIOM:
            case INCOMPLETE_SAME_AS_AXIOM:
            case INCOMPLETE_DIFFERENT_FROM_AXIOM:
            case INCOMPLETE_DOMAIN:
            case INCOMPLETE_RANGE:
            case INCOMPLETE_INVERSE_OF:
                {
                alt1=4;
                }
                break;
            case INCOMPLETE_PROPERTY_CHAIN:
            case INCOMPLETE_DISJUNCTION:
            case INCOMPLETE_EXPRESSION:
                {
                alt1=5;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }

            switch (alt1) {
                case 1 :
                    // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxAutoComplete.g:73:9: axiom
                    {
                    pushFollow(FOLLOW_axiom_in_bottomup79);
                    axiom();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxAutoComplete.g:74:9: standaloneExpression
                    {
                    pushFollow(FOLLOW_standaloneExpression_in_bottomup89);
                    standaloneExpression();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 3 :
                    // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxAutoComplete.g:75:8: expressionRoot
                    {
                    pushFollow(FOLLOW_expressionRoot_in_bottomup98);
                    expressionRoot();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 4 :
                    // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxAutoComplete.g:76:9: incompleteAxiom
                    {
                    pushFollow(FOLLOW_incompleteAxiom_in_bottomup109);
                    incompleteAxiom();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 5 :
                    // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxAutoComplete.g:77:9: incompleteExpression
                    {
                    pushFollow(FOLLOW_incompleteExpression_in_bottomup119);
                    incompleteExpression();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }
        }

          catch(RecognitionException exception){
           
          }
          
          catch(RewriteEmptyStreamException exception){
          
          }
        finally {
        }
        return ;
    }
    // $ANTLR end "bottomup"


    // $ANTLR start "expressionRoot"
    // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxAutoComplete.g:80:1: expressionRoot : ^( EXPRESSION expression ) ;
    public final void expressionRoot() throws RecognitionException {
        ManchesterOWLSyntaxTree EXPRESSION1=null;
        ManchesterOWLSyntaxAutoComplete.expression_return expression2 = null;


        try {
            // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxAutoComplete.g:81:5: ( ^( EXPRESSION expression ) )
            // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxAutoComplete.g:81:9: ^( EXPRESSION expression )
            {
            EXPRESSION1=(ManchesterOWLSyntaxTree)match(input,EXPRESSION,FOLLOW_EXPRESSION_in_expressionRoot148); if (state.failed) return ;

            match(input, Token.DOWN, null); if (state.failed) return ;
            pushFollow(FOLLOW_expression_in_expressionRoot150);
            expression2=expression();

            state._fsp--;
            if (state.failed) return ;

            match(input, Token.UP, null); if (state.failed) return ;
            if ( state.backtracking==1 ) {
              EXPRESSION1.setCompletions((expression2!=null?expression2.completions:null));
            }

            }

        }

          catch(RecognitionException exception){
           
          }
          
          catch(RewriteEmptyStreamException exception){
          
          }
        finally {
        }
        return ;
    }
    // $ANTLR end "expressionRoot"


    // $ANTLR start "standaloneExpression"
    // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxAutoComplete.g:86:1: standaloneExpression : ^( STANDALONE_EXPRESSION ^( EXPRESSION expression ) ) ;
    public final void standaloneExpression() throws RecognitionException {
        ManchesterOWLSyntaxTree STANDALONE_EXPRESSION4=null;
        ManchesterOWLSyntaxAutoComplete.expression_return expression3 = null;


        try {
            // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxAutoComplete.g:87:3: ( ^( STANDALONE_EXPRESSION ^( EXPRESSION expression ) ) )
            // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxAutoComplete.g:87:5: ^( STANDALONE_EXPRESSION ^( EXPRESSION expression ) )
            {
            STANDALONE_EXPRESSION4=(ManchesterOWLSyntaxTree)match(input,STANDALONE_EXPRESSION,FOLLOW_STANDALONE_EXPRESSION_in_standaloneExpression172); if (state.failed) return ;

            match(input, Token.DOWN, null); if (state.failed) return ;
            match(input,EXPRESSION,FOLLOW_EXPRESSION_in_standaloneExpression175); if (state.failed) return ;

            match(input, Token.DOWN, null); if (state.failed) return ;
            pushFollow(FOLLOW_expression_in_standaloneExpression177);
            expression3=expression();

            state._fsp--;
            if (state.failed) return ;

            match(input, Token.UP, null); if (state.failed) return ;

            match(input, Token.UP, null); if (state.failed) return ;
            if ( state.backtracking==1 ) {
               
              			    List<String> completions = new ArrayList<String>();
              			    if(!isNewWord()){
              					   completions.addAll((expression3!=null?expression3.completions:null));
              					}else{
              					   if((expression3!=null?expression3.type:null)!=null){
              						    completions.addAll(AutoCompleteStrings.getStandaloneExpressionCompletions((expression3!=null?expression3.type:null)));
              					   }
              					}
              					STANDALONE_EXPRESSION4.setCompletions(completions);
              			
            }

            }

        }

          catch(RecognitionException exception){
           
          }
          
          catch(RewriteEmptyStreamException exception){
          
          }
        finally {
        }
        return ;
    }
    // $ANTLR end "standaloneExpression"

    public static class axiom_return extends TreeRuleReturnScope {
        public List<String> completions;
    };

    // $ANTLR start "axiom"
    // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxAutoComplete.g:101:1: axiom returns [List<String> completions] : ( ^( SUB_CLASS_AXIOM ^( EXPRESSION subClass= expression ) ^( EXPRESSION superClass= expression ) ) | ^( EQUIVALENT_TO_AXIOM ^( EXPRESSION lhs= expression ) ^( EXPRESSION rhs= expression ) ) | ^( INVERSE_OF ^( EXPRESSION p= IDENTIFIER ) ^( EXPRESSION anotherProperty= IDENTIFIER ) ) | ^( DISJOINT_WITH_AXIOM ^( EXPRESSION lhs= expression ) ^( EXPRESSION rhs= expression ) ) | ^( SUB_PROPERTY_AXIOM ^( EXPRESSION subProperty= expression ) ^( EXPRESSION superProperty= unary ) ) | ^( ROLE_ASSERTION ^( EXPRESSION subject= IDENTIFIER ) ^( EXPRESSION predicate= propertyExpression ) ^( EXPRESSION object= unary ) ) | ^( TYPE_ASSERTION ^( EXPRESSION description= expression ) ^( EXPRESSION subject= IDENTIFIER ) ) | ^( DOMAIN ^( EXPRESSION p= IDENTIFIER ) ^( EXPRESSION domain= expression ) ) | ^( RANGE ^( EXPRESSION p= IDENTIFIER ) ^( EXPRESSION range= expression ) ) | ^( SAME_AS_AXIOM ^( EXPRESSION anIndividual= IDENTIFIER ) ^( EXPRESSION anotherIndividual= IDENTIFIER ) ) | ^( DIFFERENT_FROM_AXIOM ^( EXPRESSION anIndividual= IDENTIFIER ) ^( EXPRESSION anotherIndividual= IDENTIFIER ) ) | ^( UNARY_AXIOM FUNCTIONAL ^( EXPRESSION p= IDENTIFIER ) ) | ^( UNARY_AXIOM INVERSE_FUNCTIONAL ^( EXPRESSION p= IDENTIFIER ) ) | ^( UNARY_AXIOM IRREFLEXIVE ^( EXPRESSION p= IDENTIFIER ) ) | ^( UNARY_AXIOM REFLEXIVE ^( EXPRESSION p= IDENTIFIER ) ) | ^( UNARY_AXIOM SYMMETRIC ^( EXPRESSION p= IDENTIFIER ) ) | ^( UNARY_AXIOM TRANSITIVE ^( EXPRESSION p= IDENTIFIER ) ) | ^( NEGATED_ASSERTION a= axiom ) );
    public final ManchesterOWLSyntaxAutoComplete.axiom_return axiom() throws RecognitionException {
        ManchesterOWLSyntaxAutoComplete.axiom_return retval = new ManchesterOWLSyntaxAutoComplete.axiom_return();
        retval.start = input.LT(1);

        ManchesterOWLSyntaxTree p=null;
        ManchesterOWLSyntaxTree anotherProperty=null;
        ManchesterOWLSyntaxTree subject=null;
        ManchesterOWLSyntaxTree anIndividual=null;
        ManchesterOWLSyntaxTree anotherIndividual=null;
        ManchesterOWLSyntaxAutoComplete.expression_return subClass = null;

        ManchesterOWLSyntaxAutoComplete.expression_return superClass = null;

        ManchesterOWLSyntaxAutoComplete.expression_return lhs = null;

        ManchesterOWLSyntaxAutoComplete.expression_return rhs = null;

        ManchesterOWLSyntaxAutoComplete.expression_return subProperty = null;

        ManchesterOWLSyntaxAutoComplete.unary_return superProperty = null;

        ManchesterOWLSyntaxAutoComplete.propertyExpression_return predicate = null;

        ManchesterOWLSyntaxAutoComplete.unary_return object = null;

        ManchesterOWLSyntaxAutoComplete.expression_return description = null;

        ManchesterOWLSyntaxAutoComplete.expression_return domain = null;

        ManchesterOWLSyntaxAutoComplete.expression_return range = null;

        ManchesterOWLSyntaxAutoComplete.axiom_return a = null;


        try {
            // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxAutoComplete.g:109:1: ( ^( SUB_CLASS_AXIOM ^( EXPRESSION subClass= expression ) ^( EXPRESSION superClass= expression ) ) | ^( EQUIVALENT_TO_AXIOM ^( EXPRESSION lhs= expression ) ^( EXPRESSION rhs= expression ) ) | ^( INVERSE_OF ^( EXPRESSION p= IDENTIFIER ) ^( EXPRESSION anotherProperty= IDENTIFIER ) ) | ^( DISJOINT_WITH_AXIOM ^( EXPRESSION lhs= expression ) ^( EXPRESSION rhs= expression ) ) | ^( SUB_PROPERTY_AXIOM ^( EXPRESSION subProperty= expression ) ^( EXPRESSION superProperty= unary ) ) | ^( ROLE_ASSERTION ^( EXPRESSION subject= IDENTIFIER ) ^( EXPRESSION predicate= propertyExpression ) ^( EXPRESSION object= unary ) ) | ^( TYPE_ASSERTION ^( EXPRESSION description= expression ) ^( EXPRESSION subject= IDENTIFIER ) ) | ^( DOMAIN ^( EXPRESSION p= IDENTIFIER ) ^( EXPRESSION domain= expression ) ) | ^( RANGE ^( EXPRESSION p= IDENTIFIER ) ^( EXPRESSION range= expression ) ) | ^( SAME_AS_AXIOM ^( EXPRESSION anIndividual= IDENTIFIER ) ^( EXPRESSION anotherIndividual= IDENTIFIER ) ) | ^( DIFFERENT_FROM_AXIOM ^( EXPRESSION anIndividual= IDENTIFIER ) ^( EXPRESSION anotherIndividual= IDENTIFIER ) ) | ^( UNARY_AXIOM FUNCTIONAL ^( EXPRESSION p= IDENTIFIER ) ) | ^( UNARY_AXIOM INVERSE_FUNCTIONAL ^( EXPRESSION p= IDENTIFIER ) ) | ^( UNARY_AXIOM IRREFLEXIVE ^( EXPRESSION p= IDENTIFIER ) ) | ^( UNARY_AXIOM REFLEXIVE ^( EXPRESSION p= IDENTIFIER ) ) | ^( UNARY_AXIOM SYMMETRIC ^( EXPRESSION p= IDENTIFIER ) ) | ^( UNARY_AXIOM TRANSITIVE ^( EXPRESSION p= IDENTIFIER ) ) | ^( NEGATED_ASSERTION a= axiom ) )
            int alt2=18;
            alt2 = dfa2.predict(input);
            switch (alt2) {
                case 1 :
                    // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxAutoComplete.g:110:3: ^( SUB_CLASS_AXIOM ^( EXPRESSION subClass= expression ) ^( EXPRESSION superClass= expression ) )
                    {
                    match(input,SUB_CLASS_AXIOM,FOLLOW_SUB_CLASS_AXIOM_in_axiom216); if (state.failed) return retval;

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    match(input,EXPRESSION,FOLLOW_EXPRESSION_in_axiom220); if (state.failed) return retval;

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    pushFollow(FOLLOW_expression_in_axiom227);
                    subClass=expression();

                    state._fsp--;
                    if (state.failed) return retval;

                    match(input, Token.UP, null); if (state.failed) return retval;
                    match(input,EXPRESSION,FOLLOW_EXPRESSION_in_axiom232); if (state.failed) return retval;

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    pushFollow(FOLLOW_expression_in_axiom239);
                    superClass=expression();

                    state._fsp--;
                    if (state.failed) return retval;

                    match(input, Token.UP, null); if (state.failed) return retval;

                    match(input, Token.UP, null); if (state.failed) return retval;
                    if ( state.backtracking==1 ) {
                      			
                      			if(!isNewWord()){
                      			 retval.completions = superClass.completions;
                      			}else{
                      			 retval.completions = Collections.<String>emptyList();
                      			}
                      		
                    }

                    }
                    break;
                case 2 :
                    // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxAutoComplete.g:118:5: ^( EQUIVALENT_TO_AXIOM ^( EXPRESSION lhs= expression ) ^( EXPRESSION rhs= expression ) )
                    {
                    match(input,EQUIVALENT_TO_AXIOM,FOLLOW_EQUIVALENT_TO_AXIOM_in_axiom252); if (state.failed) return retval;

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    match(input,EXPRESSION,FOLLOW_EXPRESSION_in_axiom255); if (state.failed) return retval;

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    pushFollow(FOLLOW_expression_in_axiom261);
                    lhs=expression();

                    state._fsp--;
                    if (state.failed) return retval;

                    match(input, Token.UP, null); if (state.failed) return retval;
                    match(input,EXPRESSION,FOLLOW_EXPRESSION_in_axiom265); if (state.failed) return retval;

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    pushFollow(FOLLOW_expression_in_axiom272);
                    rhs=expression();

                    state._fsp--;
                    if (state.failed) return retval;

                    match(input, Token.UP, null); if (state.failed) return retval;

                    match(input, Token.UP, null); if (state.failed) return retval;
                    if ( state.backtracking==1 ) {
                      	    
                      	    if(!isNewWord()){
                             retval.completions = rhs.completions;
                            }else{
                             retval.completions = Collections.<String>emptyList();
                            }
                      	   
                    }

                    }
                    break;
                case 3 :
                    // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxAutoComplete.g:126:4: ^( INVERSE_OF ^( EXPRESSION p= IDENTIFIER ) ^( EXPRESSION anotherProperty= IDENTIFIER ) )
                    {
                    match(input,INVERSE_OF,FOLLOW_INVERSE_OF_in_axiom287); if (state.failed) return retval;

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    match(input,EXPRESSION,FOLLOW_EXPRESSION_in_axiom290); if (state.failed) return retval;

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    p=(ManchesterOWLSyntaxTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_axiom296); if (state.failed) return retval;

                    match(input, Token.UP, null); if (state.failed) return retval;
                    match(input,EXPRESSION,FOLLOW_EXPRESSION_in_axiom300); if (state.failed) return retval;

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    anotherProperty=(ManchesterOWLSyntaxTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_axiom306); if (state.failed) return retval;

                    match(input, Token.UP, null); if (state.failed) return retval;

                    match(input, Token.UP, null); if (state.failed) return retval;
                    if ( state.backtracking==1 ) {
                      	   
                      	    if(!isNewWord()){
                             retval.completions = anotherProperty.getCompletions();
                            }else{
                             retval.completions = Collections.<String>emptyList();
                            }
                      	
                    }

                    }
                    break;
                case 4 :
                    // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxAutoComplete.g:134:5: ^( DISJOINT_WITH_AXIOM ^( EXPRESSION lhs= expression ) ^( EXPRESSION rhs= expression ) )
                    {
                    match(input,DISJOINT_WITH_AXIOM,FOLLOW_DISJOINT_WITH_AXIOM_in_axiom318); if (state.failed) return retval;

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    match(input,EXPRESSION,FOLLOW_EXPRESSION_in_axiom321); if (state.failed) return retval;

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    pushFollow(FOLLOW_expression_in_axiom328);
                    lhs=expression();

                    state._fsp--;
                    if (state.failed) return retval;

                    match(input, Token.UP, null); if (state.failed) return retval;
                    match(input,EXPRESSION,FOLLOW_EXPRESSION_in_axiom332); if (state.failed) return retval;

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    pushFollow(FOLLOW_expression_in_axiom338);
                    rhs=expression();

                    state._fsp--;
                    if (state.failed) return retval;

                    match(input, Token.UP, null); if (state.failed) return retval;

                    match(input, Token.UP, null); if (state.failed) return retval;
                    if ( state.backtracking==1 ) {
                           
                           if(!isNewWord()){
                             retval.completions = rhs.completions;
                            }else{
                             retval.completions = Collections.<String>emptyList();
                            }
                        
                    }

                    }
                    break;
                case 5 :
                    // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxAutoComplete.g:141:4: ^( SUB_PROPERTY_AXIOM ^( EXPRESSION subProperty= expression ) ^( EXPRESSION superProperty= unary ) )
                    {
                    match(input,SUB_PROPERTY_AXIOM,FOLLOW_SUB_PROPERTY_AXIOM_in_axiom350); if (state.failed) return retval;

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    match(input,EXPRESSION,FOLLOW_EXPRESSION_in_axiom353); if (state.failed) return retval;

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    pushFollow(FOLLOW_expression_in_axiom360);
                    subProperty=expression();

                    state._fsp--;
                    if (state.failed) return retval;

                    match(input, Token.UP, null); if (state.failed) return retval;
                    match(input,EXPRESSION,FOLLOW_EXPRESSION_in_axiom364); if (state.failed) return retval;

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    pushFollow(FOLLOW_unary_in_axiom370);
                    superProperty=unary();

                    state._fsp--;
                    if (state.failed) return retval;

                    match(input, Token.UP, null); if (state.failed) return retval;

                    match(input, Token.UP, null); if (state.failed) return retval;
                    if ( state.backtracking==1 ) {
                      			
                      			if(!isNewWord()){
                             retval.completions = superProperty.completions;
                            }else{
                             retval.completions = Collections.<String>emptyList();
                            }
                      		
                    }

                    }
                    break;
                case 6 :
                    // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxAutoComplete.g:149:4: ^( ROLE_ASSERTION ^( EXPRESSION subject= IDENTIFIER ) ^( EXPRESSION predicate= propertyExpression ) ^( EXPRESSION object= unary ) )
                    {
                    match(input,ROLE_ASSERTION,FOLLOW_ROLE_ASSERTION_in_axiom384); if (state.failed) return retval;

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    match(input,EXPRESSION,FOLLOW_EXPRESSION_in_axiom387); if (state.failed) return retval;

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    subject=(ManchesterOWLSyntaxTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_axiom394); if (state.failed) return retval;

                    match(input, Token.UP, null); if (state.failed) return retval;
                    match(input,EXPRESSION,FOLLOW_EXPRESSION_in_axiom398); if (state.failed) return retval;

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    pushFollow(FOLLOW_propertyExpression_in_axiom405);
                    predicate=propertyExpression();

                    state._fsp--;
                    if (state.failed) return retval;

                    match(input, Token.UP, null); if (state.failed) return retval;
                    match(input,EXPRESSION,FOLLOW_EXPRESSION_in_axiom409); if (state.failed) return retval;

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    pushFollow(FOLLOW_unary_in_axiom415);
                    object=unary();

                    state._fsp--;
                    if (state.failed) return retval;

                    match(input, Token.UP, null); if (state.failed) return retval;

                    match(input, Token.UP, null); if (state.failed) return retval;
                    if ( state.backtracking==1 ) {
                      	   
                      	   if(!isNewWord()){
                             retval.completions = object.completions;
                            }else{
                             retval.completions = Collections.<String>emptyList();
                            }
                      	 
                    }

                    }
                    break;
                case 7 :
                    // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxAutoComplete.g:156:5: ^( TYPE_ASSERTION ^( EXPRESSION description= expression ) ^( EXPRESSION subject= IDENTIFIER ) )
                    {
                    match(input,TYPE_ASSERTION,FOLLOW_TYPE_ASSERTION_in_axiom425); if (state.failed) return retval;

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    match(input,EXPRESSION,FOLLOW_EXPRESSION_in_axiom428); if (state.failed) return retval;

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    pushFollow(FOLLOW_expression_in_axiom435);
                    description=expression();

                    state._fsp--;
                    if (state.failed) return retval;

                    match(input, Token.UP, null); if (state.failed) return retval;
                    match(input,EXPRESSION,FOLLOW_EXPRESSION_in_axiom439); if (state.failed) return retval;

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    subject=(ManchesterOWLSyntaxTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_axiom445); if (state.failed) return retval;

                    match(input, Token.UP, null); if (state.failed) return retval;

                    match(input, Token.UP, null); if (state.failed) return retval;
                    if ( state.backtracking==1 ) {

                      	   if(!isNewWord()){
                             retval.completions = subject.getCompletions();
                            }else{
                             retval.completions = Collections.<String>emptyList();
                            }
                      	
                    }

                    }
                    break;
                case 8 :
                    // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxAutoComplete.g:164:4: ^( DOMAIN ^( EXPRESSION p= IDENTIFIER ) ^( EXPRESSION domain= expression ) )
                    {
                    match(input,DOMAIN,FOLLOW_DOMAIN_in_axiom457); if (state.failed) return retval;

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    match(input,EXPRESSION,FOLLOW_EXPRESSION_in_axiom460); if (state.failed) return retval;

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    p=(ManchesterOWLSyntaxTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_axiom466); if (state.failed) return retval;

                    match(input, Token.UP, null); if (state.failed) return retval;
                    match(input,EXPRESSION,FOLLOW_EXPRESSION_in_axiom470); if (state.failed) return retval;

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    pushFollow(FOLLOW_expression_in_axiom476);
                    domain=expression();

                    state._fsp--;
                    if (state.failed) return retval;

                    match(input, Token.UP, null); if (state.failed) return retval;

                    match(input, Token.UP, null); if (state.failed) return retval;
                    if ( state.backtracking==1 ) {

                      	    if(!isNewWord()){
                             retval.completions = domain.completions;
                            }else{
                             retval.completions = Collections.<String>emptyList();
                            }
                      	 
                    }

                    }
                    break;
                case 9 :
                    // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxAutoComplete.g:172:5: ^( RANGE ^( EXPRESSION p= IDENTIFIER ) ^( EXPRESSION range= expression ) )
                    {
                    match(input,RANGE,FOLLOW_RANGE_in_axiom489); if (state.failed) return retval;

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    match(input,EXPRESSION,FOLLOW_EXPRESSION_in_axiom492); if (state.failed) return retval;

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    p=(ManchesterOWLSyntaxTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_axiom498); if (state.failed) return retval;

                    match(input, Token.UP, null); if (state.failed) return retval;
                    match(input,EXPRESSION,FOLLOW_EXPRESSION_in_axiom502); if (state.failed) return retval;

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    pushFollow(FOLLOW_expression_in_axiom508);
                    range=expression();

                    state._fsp--;
                    if (state.failed) return retval;

                    match(input, Token.UP, null); if (state.failed) return retval;

                    match(input, Token.UP, null); if (state.failed) return retval;
                    if ( state.backtracking==1 ) {

                            if(!isNewWord()){
                             retval.completions = range.completions;
                            }else{
                             retval.completions = Collections.<String>emptyList();
                            }
                         
                    }

                    }
                    break;
                case 10 :
                    // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxAutoComplete.g:180:6: ^( SAME_AS_AXIOM ^( EXPRESSION anIndividual= IDENTIFIER ) ^( EXPRESSION anotherIndividual= IDENTIFIER ) )
                    {
                    match(input,SAME_AS_AXIOM,FOLLOW_SAME_AS_AXIOM_in_axiom523); if (state.failed) return retval;

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    match(input,EXPRESSION,FOLLOW_EXPRESSION_in_axiom526); if (state.failed) return retval;

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    anIndividual=(ManchesterOWLSyntaxTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_axiom531); if (state.failed) return retval;

                    match(input, Token.UP, null); if (state.failed) return retval;
                    match(input,EXPRESSION,FOLLOW_EXPRESSION_in_axiom535); if (state.failed) return retval;

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    anotherIndividual=(ManchesterOWLSyntaxTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_axiom541); if (state.failed) return retval;

                    match(input, Token.UP, null); if (state.failed) return retval;

                    match(input, Token.UP, null); if (state.failed) return retval;
                    if ( state.backtracking==1 ) {

                           if(!isNewWord()){
                             retval.completions = anotherIndividual.getCompletions();
                            }else{
                             retval.completions = Collections.<String>emptyList();
                            }
                         
                    }

                    }
                    break;
                case 11 :
                    // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxAutoComplete.g:188:7: ^( DIFFERENT_FROM_AXIOM ^( EXPRESSION anIndividual= IDENTIFIER ) ^( EXPRESSION anotherIndividual= IDENTIFIER ) )
                    {
                    match(input,DIFFERENT_FROM_AXIOM,FOLLOW_DIFFERENT_FROM_AXIOM_in_axiom557); if (state.failed) return retval;

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    match(input,EXPRESSION,FOLLOW_EXPRESSION_in_axiom560); if (state.failed) return retval;

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    anIndividual=(ManchesterOWLSyntaxTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_axiom565); if (state.failed) return retval;

                    match(input, Token.UP, null); if (state.failed) return retval;
                    match(input,EXPRESSION,FOLLOW_EXPRESSION_in_axiom569); if (state.failed) return retval;

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    anotherIndividual=(ManchesterOWLSyntaxTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_axiom575); if (state.failed) return retval;

                    match(input, Token.UP, null); if (state.failed) return retval;

                    match(input, Token.UP, null); if (state.failed) return retval;
                    if ( state.backtracking==1 ) {

                           if(!isNewWord()){
                             retval.completions = anotherIndividual.getCompletions();
                            }else{
                             retval.completions = Collections.<String>emptyList();
                            }
                         
                    }

                    }
                    break;
                case 12 :
                    // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxAutoComplete.g:196:5: ^( UNARY_AXIOM FUNCTIONAL ^( EXPRESSION p= IDENTIFIER ) )
                    {
                    match(input,UNARY_AXIOM,FOLLOW_UNARY_AXIOM_in_axiom589); if (state.failed) return retval;

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    match(input,FUNCTIONAL,FOLLOW_FUNCTIONAL_in_axiom591); if (state.failed) return retval;
                    match(input,EXPRESSION,FOLLOW_EXPRESSION_in_axiom594); if (state.failed) return retval;

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    p=(ManchesterOWLSyntaxTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_axiom600); if (state.failed) return retval;

                    match(input, Token.UP, null); if (state.failed) return retval;

                    match(input, Token.UP, null); if (state.failed) return retval;
                    if ( state.backtracking==1 ) {

                      	    if(!isNewWord()){
                             retval.completions = p.getCompletions();
                            }else{
                             retval.completions = Collections.<String>emptyList();
                            }
                      	 
                    }

                    }
                    break;
                case 13 :
                    // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxAutoComplete.g:204:5: ^( UNARY_AXIOM INVERSE_FUNCTIONAL ^( EXPRESSION p= IDENTIFIER ) )
                    {
                    match(input,UNARY_AXIOM,FOLLOW_UNARY_AXIOM_in_axiom613); if (state.failed) return retval;

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    match(input,INVERSE_FUNCTIONAL,FOLLOW_INVERSE_FUNCTIONAL_in_axiom615); if (state.failed) return retval;
                    match(input,EXPRESSION,FOLLOW_EXPRESSION_in_axiom618); if (state.failed) return retval;

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    p=(ManchesterOWLSyntaxTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_axiom624); if (state.failed) return retval;

                    match(input, Token.UP, null); if (state.failed) return retval;

                    match(input, Token.UP, null); if (state.failed) return retval;
                    if ( state.backtracking==1 ) {

                            if(!isNewWord()){
                             retval.completions = p.getCompletions();
                            }else{
                             retval.completions = Collections.<String>emptyList();
                            }
                         
                    }

                    }
                    break;
                case 14 :
                    // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxAutoComplete.g:212:7: ^( UNARY_AXIOM IRREFLEXIVE ^( EXPRESSION p= IDENTIFIER ) )
                    {
                    match(input,UNARY_AXIOM,FOLLOW_UNARY_AXIOM_in_axiom640); if (state.failed) return retval;

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    match(input,IRREFLEXIVE,FOLLOW_IRREFLEXIVE_in_axiom642); if (state.failed) return retval;
                    match(input,EXPRESSION,FOLLOW_EXPRESSION_in_axiom645); if (state.failed) return retval;

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    p=(ManchesterOWLSyntaxTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_axiom651); if (state.failed) return retval;

                    match(input, Token.UP, null); if (state.failed) return retval;

                    match(input, Token.UP, null); if (state.failed) return retval;
                    if ( state.backtracking==1 ) {
                           
                           if(!isNewWord()){
                             retval.completions = p.getCompletions();
                            }else{
                             retval.completions = Collections.<String>emptyList();
                            }
                         
                    }

                    }
                    break;
                case 15 :
                    // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxAutoComplete.g:220:6: ^( UNARY_AXIOM REFLEXIVE ^( EXPRESSION p= IDENTIFIER ) )
                    {
                    match(input,UNARY_AXIOM,FOLLOW_UNARY_AXIOM_in_axiom666); if (state.failed) return retval;

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    match(input,REFLEXIVE,FOLLOW_REFLEXIVE_in_axiom668); if (state.failed) return retval;
                    match(input,EXPRESSION,FOLLOW_EXPRESSION_in_axiom671); if (state.failed) return retval;

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    p=(ManchesterOWLSyntaxTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_axiom677); if (state.failed) return retval;

                    match(input, Token.UP, null); if (state.failed) return retval;

                    match(input, Token.UP, null); if (state.failed) return retval;
                    if ( state.backtracking==1 ) {

                      			if(!isNewWord()){
                             retval.completions = p.getCompletions();
                            }else{
                             retval.completions = Collections.<String>emptyList();
                            }   
                      	 
                    }

                    }
                    break;
                case 16 :
                    // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxAutoComplete.g:228:6: ^( UNARY_AXIOM SYMMETRIC ^( EXPRESSION p= IDENTIFIER ) )
                    {
                    match(input,UNARY_AXIOM,FOLLOW_UNARY_AXIOM_in_axiom692); if (state.failed) return retval;

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    match(input,SYMMETRIC,FOLLOW_SYMMETRIC_in_axiom694); if (state.failed) return retval;
                    match(input,EXPRESSION,FOLLOW_EXPRESSION_in_axiom697); if (state.failed) return retval;

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    p=(ManchesterOWLSyntaxTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_axiom703); if (state.failed) return retval;

                    match(input, Token.UP, null); if (state.failed) return retval;

                    match(input, Token.UP, null); if (state.failed) return retval;
                    if ( state.backtracking==1 ) {

                      			if(!isNewWord()){
                             retval.completions = p.getCompletions();
                            }else{
                             retval.completions = Collections.<String>emptyList();
                            }
                         
                    }

                    }
                    break;
                case 17 :
                    // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxAutoComplete.g:236:7: ^( UNARY_AXIOM TRANSITIVE ^( EXPRESSION p= IDENTIFIER ) )
                    {
                    match(input,UNARY_AXIOM,FOLLOW_UNARY_AXIOM_in_axiom720); if (state.failed) return retval;

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    match(input,TRANSITIVE,FOLLOW_TRANSITIVE_in_axiom722); if (state.failed) return retval;
                    match(input,EXPRESSION,FOLLOW_EXPRESSION_in_axiom725); if (state.failed) return retval;

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    p=(ManchesterOWLSyntaxTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_axiom731); if (state.failed) return retval;

                    match(input, Token.UP, null); if (state.failed) return retval;

                    match(input, Token.UP, null); if (state.failed) return retval;
                    if ( state.backtracking==1 ) {

                           if(!isNewWord()){
                             retval.completions = p.getCompletions();
                            }else{
                             retval.completions = Collections.<String>emptyList();
                            }
                         
                    }

                    }
                    break;
                case 18 :
                    // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxAutoComplete.g:244:6: ^( NEGATED_ASSERTION a= axiom )
                    {
                    match(input,NEGATED_ASSERTION,FOLLOW_NEGATED_ASSERTION_in_axiom746); if (state.failed) return retval;

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    pushFollow(FOLLOW_axiom_in_axiom751);
                    a=axiom();

                    state._fsp--;
                    if (state.failed) return retval;

                    match(input, Token.UP, null); if (state.failed) return retval;
                    if ( state.backtracking==1 ) {

                           if(!isNewWord()){
                             retval.completions = a.completions;
                            }else{
                             retval.completions = Collections.<String>emptyList();
                            }
                         
                    }

                    }
                    break;

            }
            if ( state.backtracking==1 ) {
               
                        if(retval.completions!=null){          
                          ((ManchesterOWLSyntaxTree)retval.start).setCompletions(retval.completions);
                        }
               
              			
            }
        }

          catch(RecognitionException exception){
           
          }
          
          catch(RewriteEmptyStreamException exception){
          
          }
        finally {
        }
        return retval;
    }
    // $ANTLR end "axiom"

    public static class expression_return extends TreeRuleReturnScope {
        public List<String> completions;
        public Type type;
    };

    // $ANTLR start "expression"
    // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxAutoComplete.g:253:1: expression returns [List<String> completions, Type type] : ( ^( DISJUNCTION (head+= . )+ lastDisjunct= conjunction ) | ^( PROPERTY_CHAIN ( . )* last= expression ) | conjunction | complexPropertyExpression );
    public final ManchesterOWLSyntaxAutoComplete.expression_return expression() throws RecognitionException {
        ManchesterOWLSyntaxAutoComplete.expression_return retval = new ManchesterOWLSyntaxAutoComplete.expression_return();
        retval.start = input.LT(1);

        ManchesterOWLSyntaxTree head=null;
        List list_head=null;
        ManchesterOWLSyntaxAutoComplete.conjunction_return lastDisjunct = null;

        ManchesterOWLSyntaxAutoComplete.expression_return last = null;

        ManchesterOWLSyntaxAutoComplete.conjunction_return conjunction5 = null;

        ManchesterOWLSyntaxAutoComplete.complexPropertyExpression_return complexPropertyExpression6 = null;


        try {
            // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxAutoComplete.g:262:2: ( ^( DISJUNCTION (head+= . )+ lastDisjunct= conjunction ) | ^( PROPERTY_CHAIN ( . )* last= expression ) | conjunction | complexPropertyExpression )
            int alt5=4;
            switch ( input.LA(1) ) {
            case DISJUNCTION:
                {
                alt5=1;
                }
                break;
            case PROPERTY_CHAIN:
                {
                alt5=2;
                }
                break;
            case IDENTIFIER:
            case ENTITY_REFERENCE:
            case CONJUNCTION:
            case NEGATED_EXPRESSION:
            case SOME_RESTRICTION:
            case ALL_RESTRICTION:
            case VALUE_RESTRICTION:
            case CARDINALITY_RESTRICTION:
            case ONE_OF:
            case CONSTANT:
                {
                alt5=3;
                }
                break;
            case INVERSE_OBJECT_PROPERTY_EXPRESSION:
                {
                alt5=4;
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
                    // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxAutoComplete.g:263:4: ^( DISJUNCTION (head+= . )+ lastDisjunct= conjunction )
                    {
                    match(input,DISJUNCTION,FOLLOW_DISJUNCTION_in_expression786); if (state.failed) return retval;

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxAutoComplete.g:263:23: (head+= . )+
                    int cnt3=0;
                    loop3:
                    do {
                        int alt3=2;
                        alt3 = dfa3.predict(input);
                        switch (alt3) {
                    	case 1 :
                    	    // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxAutoComplete.g:263:23: head+= .
                    	    {
                    	    head=(ManchesterOWLSyntaxTree)input.LT(1);
                    	    matchAny(input); if (state.failed) return retval;
                    	    if (list_head==null) list_head=new ArrayList();
                    	    list_head.add(head);


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt3 >= 1 ) break loop3;
                    	    if (state.backtracking>0) {state.failed=true; return retval;}
                                EarlyExitException eee =
                                    new EarlyExitException(3, input);
                                throw eee;
                        }
                        cnt3++;
                    } while (true);

                    pushFollow(FOLLOW_conjunction_in_expression799);
                    lastDisjunct=conjunction();

                    state._fsp--;
                    if (state.failed) return retval;

                    match(input, Token.UP, null); if (state.failed) return retval;
                    if ( state.backtracking==1 ) {
                      	
                      				retval.completions = lastDisjunct.completions;
                      		 	
                    }

                    }
                    break;
                case 2 :
                    // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxAutoComplete.g:267:6: ^( PROPERTY_CHAIN ( . )* last= expression )
                    {
                    match(input,PROPERTY_CHAIN,FOLLOW_PROPERTY_CHAIN_in_expression814); if (state.failed) return retval;

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxAutoComplete.g:267:24: ( . )*
                    loop4:
                    do {
                        int alt4=2;
                        int LA4_0 = input.LA(1);

                        if ( ((LA4_0>=IDENTIFIER && LA4_0<=ENTITY_REFERENCE)||(LA4_0>=DISJUNCTION && LA4_0<=NEGATED_EXPRESSION)||(LA4_0>=SOME_RESTRICTION && LA4_0<=ONE_OF)||LA4_0==INVERSE_OBJECT_PROPERTY_EXPRESSION||LA4_0==CONSTANT) ) {
                            int LA4_1 = input.LA(2);

                            if ( (true) ) {
                                alt4=1;
                            }
                            else if ( (true) ) {
                                alt4=2;
                            }


                        }
                        else if ( ((LA4_0>=COMPOSITION && LA4_0<=LETTER)||(LA4_0>=RULE && LA4_0<=UNARY_AXIOM)||(LA4_0>=NEGATED_ASSERTION && LA4_0<=INVERSE_PROPERTY)||(LA4_0>=TYPE_ASSERTION && LA4_0<=ROLE_ASSERTION)||LA4_0==EXPRESSION||(LA4_0>=STANDALONE_EXPRESSION && LA4_0<=INCOMPLETE_EXPRESSION)) ) {
                            alt4=1;
                        }


                        switch (alt4) {
                    	case 1 :
                    	    // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxAutoComplete.g:267:24: .
                    	    {
                    	    matchAny(input); if (state.failed) return retval;

                    	    }
                    	    break;

                    	default :
                    	    break loop4;
                        }
                    } while (true);

                    pushFollow(FOLLOW_expression_in_expression824);
                    last=expression();

                    state._fsp--;
                    if (state.failed) return retval;

                    match(input, Token.UP, null); if (state.failed) return retval;
                    if ( state.backtracking==1 ) {

                      		    retval.completions = last.completions;
                      		  
                    }

                    }
                    break;
                case 3 :
                    // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxAutoComplete.g:271:5: conjunction
                    {
                    pushFollow(FOLLOW_conjunction_in_expression837);
                    conjunction5=conjunction();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==1 ) {

                      			retval.completions = (conjunction5!=null?conjunction5.completions:null);
                      		
                    }

                    }
                    break;
                case 4 :
                    // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxAutoComplete.g:275:5: complexPropertyExpression
                    {
                    pushFollow(FOLLOW_complexPropertyExpression_in_expression849);
                    complexPropertyExpression6=complexPropertyExpression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==1 ) {

                      			retval.completions = (complexPropertyExpression6!=null?complexPropertyExpression6.completions:null);		
                      		
                    }

                    }
                    break;

            }
            if ( state.backtracking==1 ) {
               
                        if(retval.completions!=null){          
                          ((ManchesterOWLSyntaxTree)retval.start).setCompletions(retval.completions);
                        }

              			retval.type = ((ManchesterOWLSyntaxTree)retval.start).getEvalType();			
              		
            }
        }

          catch(RecognitionException exception){
           
          }
          
          catch(RewriteEmptyStreamException exception){
          
          }
        finally {
        }
        return retval;
    }
    // $ANTLR end "expression"

    public static class conjunction_return extends TreeRuleReturnScope {
        public List<String> completions;
        public Type type;
    };

    // $ANTLR start "conjunction"
    // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxAutoComplete.g:281:1: conjunction returns [List<String> completions, Type type] : ( ^( CONJUNCTION (head+= . )+ last= unary ) | unary );
    public final ManchesterOWLSyntaxAutoComplete.conjunction_return conjunction() throws RecognitionException {
        ManchesterOWLSyntaxAutoComplete.conjunction_return retval = new ManchesterOWLSyntaxAutoComplete.conjunction_return();
        retval.start = input.LT(1);

        ManchesterOWLSyntaxTree head=null;
        List list_head=null;
        ManchesterOWLSyntaxAutoComplete.unary_return last = null;

        ManchesterOWLSyntaxAutoComplete.unary_return unary7 = null;


        try {
            // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxAutoComplete.g:291:2: ( ^( CONJUNCTION (head+= . )+ last= unary ) | unary )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==CONJUNCTION) ) {
                alt7=1;
            }
            else if ( ((LA7_0>=IDENTIFIER && LA7_0<=ENTITY_REFERENCE)||LA7_0==NEGATED_EXPRESSION||(LA7_0>=SOME_RESTRICTION && LA7_0<=ONE_OF)||LA7_0==CONSTANT) ) {
                alt7=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxAutoComplete.g:292:2: ^( CONJUNCTION (head+= . )+ last= unary )
                    {
                    match(input,CONJUNCTION,FOLLOW_CONJUNCTION_in_conjunction882); if (state.failed) return retval;

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxAutoComplete.g:292:21: (head+= . )+
                    int cnt6=0;
                    loop6:
                    do {
                        int alt6=2;
                        alt6 = dfa6.predict(input);
                        switch (alt6) {
                    	case 1 :
                    	    // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxAutoComplete.g:292:21: head+= .
                    	    {
                    	    head=(ManchesterOWLSyntaxTree)input.LT(1);
                    	    matchAny(input); if (state.failed) return retval;
                    	    if (list_head==null) list_head=new ArrayList();
                    	    list_head.add(head);


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt6 >= 1 ) break loop6;
                    	    if (state.backtracking>0) {state.failed=true; return retval;}
                                EarlyExitException eee =
                                    new EarlyExitException(6, input);
                                throw eee;
                        }
                        cnt6++;
                    } while (true);

                    pushFollow(FOLLOW_unary_in_conjunction895);
                    last=unary();

                    state._fsp--;
                    if (state.failed) return retval;

                    match(input, Token.UP, null); if (state.failed) return retval;
                    if ( state.backtracking==1 ) {
                      	
                      	  List<String> c = new ArrayList<String>();
                          if(!isNewWord()){
                            c.addAll(last.completions);
                          }else{
                            if(last.type!=null){
                               c.addAll(AutoCompleteStrings.getStandaloneExpressionCompletions(last.type));
                            }
                          }           
                      		retval.completions = c;     
                      	
                    }

                    }
                    break;
                case 2 :
                    // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxAutoComplete.g:304:4: unary
                    {
                    pushFollow(FOLLOW_unary_in_conjunction905);
                    unary7=unary();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==1 ) {

                      		retval.completions = (unary7!=null?unary7.completions:null);
                      	
                    }

                    }
                    break;

            }
            if ( state.backtracking==1 ) {
               
                        if(retval.completions!=null){          
                          ((ManchesterOWLSyntaxTree)retval.start).setCompletions(retval.completions);
                        }

              				retval.type = ((ManchesterOWLSyntaxTree)retval.start).getEvalType();
              			
            }
        }

          catch(RecognitionException exception){
           
          }
          
          catch(RewriteEmptyStreamException exception){
          
          }
        finally {
        }
        return retval;
    }
    // $ANTLR end "conjunction"

    public static class unary_return extends TreeRuleReturnScope {
        public List<String> completions;
        public Type type;
    };

    // $ANTLR start "unary"
    // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxAutoComplete.g:312:1: unary returns [List<String> completions, Type type] : ( IDENTIFIER | ^( NEGATED_EXPRESSION e= expression ) | qualifiedRestriction | ENTITY_REFERENCE | ^( CONSTANT value= . (constantType= IDENTIFIER )? ) );
    public final ManchesterOWLSyntaxAutoComplete.unary_return unary() throws RecognitionException {
        ManchesterOWLSyntaxAutoComplete.unary_return retval = new ManchesterOWLSyntaxAutoComplete.unary_return();
        retval.start = input.LT(1);

        ManchesterOWLSyntaxTree constantType=null;
        ManchesterOWLSyntaxTree IDENTIFIER8=null;
        ManchesterOWLSyntaxTree ENTITY_REFERENCE10=null;
        ManchesterOWLSyntaxTree value=null;
        ManchesterOWLSyntaxAutoComplete.expression_return e = null;

        ManchesterOWLSyntaxAutoComplete.qualifiedRestriction_return qualifiedRestriction9 = null;


        try {
            // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxAutoComplete.g:321:1: ( IDENTIFIER | ^( NEGATED_EXPRESSION e= expression ) | qualifiedRestriction | ENTITY_REFERENCE | ^( CONSTANT value= . (constantType= IDENTIFIER )? ) )
            int alt9=5;
            switch ( input.LA(1) ) {
            case IDENTIFIER:
                {
                alt9=1;
                }
                break;
            case NEGATED_EXPRESSION:
                {
                alt9=2;
                }
                break;
            case SOME_RESTRICTION:
            case ALL_RESTRICTION:
            case VALUE_RESTRICTION:
            case CARDINALITY_RESTRICTION:
            case ONE_OF:
                {
                alt9=3;
                }
                break;
            case ENTITY_REFERENCE:
                {
                alt9=4;
                }
                break;
            case CONSTANT:
                {
                alt9=5;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }

            switch (alt9) {
                case 1 :
                    // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxAutoComplete.g:322:3: IDENTIFIER
                    {
                    IDENTIFIER8=(ManchesterOWLSyntaxTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_unary935); if (state.failed) return retval;
                    if ( state.backtracking==1 ) {

                      				
                      				retval.completions = new ArrayList<String>(this.getSymbolTable().match(IDENTIFIER8.getText()));
                      			
                    }

                    }
                    break;
                case 2 :
                    // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxAutoComplete.g:327:5: ^( NEGATED_EXPRESSION e= expression )
                    {
                    match(input,NEGATED_EXPRESSION,FOLLOW_NEGATED_EXPRESSION_in_unary948); if (state.failed) return retval;

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    pushFollow(FOLLOW_expression_in_unary954);
                    e=expression();

                    state._fsp--;
                    if (state.failed) return retval;

                    match(input, Token.UP, null); if (state.failed) return retval;
                    if ( state.backtracking==1 ) {

                      				retval.completions = e.completions;
                      			
                    }

                    }
                    break;
                case 3 :
                    // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxAutoComplete.g:331:5: qualifiedRestriction
                    {
                    pushFollow(FOLLOW_qualifiedRestriction_in_unary968);
                    qualifiedRestriction9=qualifiedRestriction();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==1 ) {

                      				retval.completions = (qualifiedRestriction9!=null?qualifiedRestriction9.completions:null);
                      			
                    }

                    }
                    break;
                case 4 :
                    // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxAutoComplete.g:335:5: ENTITY_REFERENCE
                    {
                    ENTITY_REFERENCE10=(ManchesterOWLSyntaxTree)match(input,ENTITY_REFERENCE,FOLLOW_ENTITY_REFERENCE_in_unary982); if (state.failed) return retval;
                    if ( state.backtracking==1 ) {

                      				
                      				retval.completions = new ArrayList<String>(this.getSymbolTable().match(ENTITY_REFERENCE10.getText()));
                      			
                    }

                    }
                    break;
                case 5 :
                    // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxAutoComplete.g:340:5: ^( CONSTANT value= . (constantType= IDENTIFIER )? )
                    {
                    match(input,CONSTANT,FOLLOW_CONSTANT_in_unary995); if (state.failed) return retval;

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    value=(ManchesterOWLSyntaxTree)input.LT(1);
                    matchAny(input); if (state.failed) return retval;
                    // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxAutoComplete.g:340:38: (constantType= IDENTIFIER )?
                    int alt8=2;
                    int LA8_0 = input.LA(1);

                    if ( (LA8_0==IDENTIFIER) ) {
                        alt8=1;
                    }
                    switch (alt8) {
                        case 1 :
                            // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxAutoComplete.g:340:38: constantType= IDENTIFIER
                            {
                            constantType=(ManchesterOWLSyntaxTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_unary1006); if (state.failed) return retval;

                            }
                            break;

                    }


                    match(input, Token.UP, null); if (state.failed) return retval;
                    if ( state.backtracking==1 ) {

                      		    if(constantType==null){
                      				  retval.completions = Collections.emptyList();
                      				}else{
                      				  retval.completions = new ArrayList<String>(this.getSymbolTable().match(constantType.getText()));
                      				}				
                      			
                    }

                    }
                    break;

            }
            if ( state.backtracking==1 ) {
               
                        if(retval.completions!=null){          
                          ((ManchesterOWLSyntaxTree)retval.start).setCompletions(retval.completions);
                        }

              				retval.type = ((ManchesterOWLSyntaxTree)retval.start).getEvalType();
              			
            }
        }

          catch(RecognitionException exception){
           
          }
          
          catch(RewriteEmptyStreamException exception){
          
          }
        finally {
        }
        return retval;
    }
    // $ANTLR end "unary"

    public static class propertyExpression_return extends TreeRuleReturnScope {
        public List<String> completions;
        public Type type;
    };

    // $ANTLR start "propertyExpression"
    // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxAutoComplete.g:350:1: propertyExpression returns [List<String> completions, Type type] : ( IDENTIFIER | complexPropertyExpression );
    public final ManchesterOWLSyntaxAutoComplete.propertyExpression_return propertyExpression() throws RecognitionException {
        ManchesterOWLSyntaxAutoComplete.propertyExpression_return retval = new ManchesterOWLSyntaxAutoComplete.propertyExpression_return();
        retval.start = input.LT(1);

        ManchesterOWLSyntaxTree IDENTIFIER11=null;
        ManchesterOWLSyntaxAutoComplete.complexPropertyExpression_return complexPropertyExpression12 = null;


        try {
            // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxAutoComplete.g:359:1: ( IDENTIFIER | complexPropertyExpression )
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==IDENTIFIER) ) {
                alt10=1;
            }
            else if ( (LA10_0==INVERSE_OBJECT_PROPERTY_EXPRESSION) ) {
                alt10=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }
            switch (alt10) {
                case 1 :
                    // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxAutoComplete.g:360:7: IDENTIFIER
                    {
                    IDENTIFIER11=(ManchesterOWLSyntaxTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_propertyExpression1042); if (state.failed) return retval;
                    if ( state.backtracking==1 ) {

                              
                              retval.completions = new ArrayList<String>(this.getSymbolTable().match(IDENTIFIER11.getText()));
                            
                    }

                    }
                    break;
                case 2 :
                    // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxAutoComplete.g:365:7: complexPropertyExpression
                    {
                    pushFollow(FOLLOW_complexPropertyExpression_in_propertyExpression1058);
                    complexPropertyExpression12=complexPropertyExpression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==1 ) {

                              retval.completions = (complexPropertyExpression12!=null?complexPropertyExpression12.completions:null);
                            
                    }

                    }
                    break;

            }
            if ( state.backtracking==1 ) {
               
                        if(retval.completions!=null){          
                          ((ManchesterOWLSyntaxTree)retval.start).setCompletions(retval.completions);
                        }

              				retval.type = ((ManchesterOWLSyntaxTree)retval.start).getEvalType();
              			
            }
        }

          catch(RecognitionException exception){
           
          }
          
          catch(RewriteEmptyStreamException exception){
          
          }
        finally {
        }
        return retval;
    }
    // $ANTLR end "propertyExpression"

    public static class complexPropertyExpression_return extends TreeRuleReturnScope {
        public List<String> completions;
        public Type type;
    };

    // $ANTLR start "complexPropertyExpression"
    // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxAutoComplete.g:371:1: complexPropertyExpression returns [List<String> completions, Type type] : ( ^( INVERSE_OBJECT_PROPERTY_EXPRESSION p= complexPropertyExpression ) | ^( INVERSE_OBJECT_PROPERTY_EXPRESSION IDENTIFIER ) );
    public final ManchesterOWLSyntaxAutoComplete.complexPropertyExpression_return complexPropertyExpression() throws RecognitionException {
        ManchesterOWLSyntaxAutoComplete.complexPropertyExpression_return retval = new ManchesterOWLSyntaxAutoComplete.complexPropertyExpression_return();
        retval.start = input.LT(1);

        ManchesterOWLSyntaxTree IDENTIFIER13=null;
        ManchesterOWLSyntaxAutoComplete.complexPropertyExpression_return p = null;


        try {
            // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxAutoComplete.g:379:1: ( ^( INVERSE_OBJECT_PROPERTY_EXPRESSION p= complexPropertyExpression ) | ^( INVERSE_OBJECT_PROPERTY_EXPRESSION IDENTIFIER ) )
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==INVERSE_OBJECT_PROPERTY_EXPRESSION) ) {
                int LA11_1 = input.LA(2);

                if ( (LA11_1==DOWN) ) {
                    int LA11_2 = input.LA(3);

                    if ( (LA11_2==IDENTIFIER) ) {
                        alt11=2;
                    }
                    else if ( (LA11_2==INVERSE_OBJECT_PROPERTY_EXPRESSION) ) {
                        alt11=1;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 11, 2, input);

                        throw nvae;
                    }
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 11, 1, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }
            switch (alt11) {
                case 1 :
                    // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxAutoComplete.g:380:2: ^( INVERSE_OBJECT_PROPERTY_EXPRESSION p= complexPropertyExpression )
                    {
                    match(input,INVERSE_OBJECT_PROPERTY_EXPRESSION,FOLLOW_INVERSE_OBJECT_PROPERTY_EXPRESSION_in_complexPropertyExpression1091); if (state.failed) return retval;

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    pushFollow(FOLLOW_complexPropertyExpression_in_complexPropertyExpression1097);
                    p=complexPropertyExpression();

                    state._fsp--;
                    if (state.failed) return retval;

                    match(input, Token.UP, null); if (state.failed) return retval;
                    if ( state.backtracking==1 ) {

                      		retval.completions = p.completions;
                      	
                    }

                    }
                    break;
                case 2 :
                    // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxAutoComplete.g:384:4: ^( INVERSE_OBJECT_PROPERTY_EXPRESSION IDENTIFIER )
                    {
                    match(input,INVERSE_OBJECT_PROPERTY_EXPRESSION,FOLLOW_INVERSE_OBJECT_PROPERTY_EXPRESSION_in_complexPropertyExpression1107); if (state.failed) return retval;

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    IDENTIFIER13=(ManchesterOWLSyntaxTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_complexPropertyExpression1109); if (state.failed) return retval;

                    match(input, Token.UP, null); if (state.failed) return retval;
                    if ( state.backtracking==1 ) {

                      								
                      				retval.completions = new ArrayList<String>(this.getSymbolTable().match(IDENTIFIER13.getText()));
                      	
                    }

                    }
                    break;

            }
            if ( state.backtracking==1 ) {
               
                        if(retval.completions!=null){          
                          ((ManchesterOWLSyntaxTree)retval.start).setCompletions(retval.completions);
                        }

                        	retval.type = ((ManchesterOWLSyntaxTree)retval.start).getEvalType();
                     
            }
        }

          catch(RecognitionException exception){
           
          }
          
          catch(RewriteEmptyStreamException exception){
          
          }
        finally {
        }
        return retval;
    }
    // $ANTLR end "complexPropertyExpression"

    public static class qualifiedRestriction_return extends TreeRuleReturnScope {
        public List<String> completions;
        public Type type;
    };

    // $ANTLR start "qualifiedRestriction"
    // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxAutoComplete.g:391:1: qualifiedRestriction returns [List<String> completions, Type type] : ( ^( SOME_RESTRICTION p= propertyExpression f= expression ) | ^( ALL_RESTRICTION p= propertyExpression f= expression ) | cardinalityRestriction | oneOf | valueRestriction );
    public final ManchesterOWLSyntaxAutoComplete.qualifiedRestriction_return qualifiedRestriction() throws RecognitionException {
        ManchesterOWLSyntaxAutoComplete.qualifiedRestriction_return retval = new ManchesterOWLSyntaxAutoComplete.qualifiedRestriction_return();
        retval.start = input.LT(1);

        ManchesterOWLSyntaxAutoComplete.propertyExpression_return p = null;

        ManchesterOWLSyntaxAutoComplete.expression_return f = null;

        ManchesterOWLSyntaxAutoComplete.cardinalityRestriction_return cardinalityRestriction14 = null;

        ManchesterOWLSyntaxAutoComplete.oneOf_return oneOf15 = null;

        ManchesterOWLSyntaxAutoComplete.valueRestriction_return valueRestriction16 = null;


        try {
            // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxAutoComplete.g:399:2: ( ^( SOME_RESTRICTION p= propertyExpression f= expression ) | ^( ALL_RESTRICTION p= propertyExpression f= expression ) | cardinalityRestriction | oneOf | valueRestriction )
            int alt12=5;
            switch ( input.LA(1) ) {
            case SOME_RESTRICTION:
                {
                alt12=1;
                }
                break;
            case ALL_RESTRICTION:
                {
                alt12=2;
                }
                break;
            case CARDINALITY_RESTRICTION:
                {
                alt12=3;
                }
                break;
            case ONE_OF:
                {
                alt12=4;
                }
                break;
            case VALUE_RESTRICTION:
                {
                alt12=5;
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
                    // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxAutoComplete.g:400:6: ^( SOME_RESTRICTION p= propertyExpression f= expression )
                    {
                    match(input,SOME_RESTRICTION,FOLLOW_SOME_RESTRICTION_in_qualifiedRestriction1140); if (state.failed) return retval;

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    pushFollow(FOLLOW_propertyExpression_in_qualifiedRestriction1145);
                    p=propertyExpression();

                    state._fsp--;
                    if (state.failed) return retval;
                    pushFollow(FOLLOW_expression_in_qualifiedRestriction1151);
                    f=expression();

                    state._fsp--;
                    if (state.failed) return retval;

                    match(input, Token.UP, null); if (state.failed) return retval;
                    if ( state.backtracking==1 ) {
                      						
                      						retval.completions = f.completions;
                      					
                    }

                    }
                    break;
                case 2 :
                    // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxAutoComplete.g:404:7: ^( ALL_RESTRICTION p= propertyExpression f= expression )
                    {
                    match(input,ALL_RESTRICTION,FOLLOW_ALL_RESTRICTION_in_qualifiedRestriction1173); if (state.failed) return retval;

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    pushFollow(FOLLOW_propertyExpression_in_qualifiedRestriction1180);
                    p=propertyExpression();

                    state._fsp--;
                    if (state.failed) return retval;
                    pushFollow(FOLLOW_expression_in_qualifiedRestriction1185);
                    f=expression();

                    state._fsp--;
                    if (state.failed) return retval;

                    match(input, Token.UP, null); if (state.failed) return retval;
                    if ( state.backtracking==1 ) {

                      					
                      					retval.completions = f.completions;
                      				
                    }

                    }
                    break;
                case 3 :
                    // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxAutoComplete.g:409:7: cardinalityRestriction
                    {
                    pushFollow(FOLLOW_cardinalityRestriction_in_qualifiedRestriction1201);
                    cardinalityRestriction14=cardinalityRestriction();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==1 ) {

                      						retval.completions = (cardinalityRestriction14!=null?cardinalityRestriction14.completions:null);
                      					
                    }

                    }
                    break;
                case 4 :
                    // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxAutoComplete.g:413:7: oneOf
                    {
                    pushFollow(FOLLOW_oneOf_in_qualifiedRestriction1217);
                    oneOf15=oneOf();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==1 ) {
                      						
                      						retval.completions = (oneOf15!=null?oneOf15.completions:null);
                      					
                    }

                    }
                    break;
                case 5 :
                    // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxAutoComplete.g:417:7: valueRestriction
                    {
                    pushFollow(FOLLOW_valueRestriction_in_qualifiedRestriction1233);
                    valueRestriction16=valueRestriction();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==1 ) {
                      						
                      						retval.completions = (valueRestriction16!=null?valueRestriction16.completions:null);
                      					
                    }

                    }
                    break;

            }
            if ( state.backtracking==1 ) {
               
                        if(retval.completions!=null){          
                          ((ManchesterOWLSyntaxTree)retval.start).setCompletions(retval.completions);
                        }

              				retval.type = ((ManchesterOWLSyntaxTree)retval.start).getEvalType();
                      
            }
        }

          catch(RecognitionException exception){
           
          }
          
          catch(RewriteEmptyStreamException exception){
          
          }
        finally {
        }
        return retval;
    }
    // $ANTLR end "qualifiedRestriction"

    public static class cardinalityRestriction_return extends TreeRuleReturnScope {
        public List<String> completions;
        public Type type;
    };

    // $ANTLR start "cardinalityRestriction"
    // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxAutoComplete.g:425:1: cardinalityRestriction returns [List<String> completions, Type type] : ( ^( CARDINALITY_RESTRICTION MIN i= INTEGER p= unary (filler= expression )? ) | ^( CARDINALITY_RESTRICTION MAX i= INTEGER p= unary (filler= expression )? ) | ^( CARDINALITY_RESTRICTION EXACTLY i= INTEGER p= unary (filler= expression )? ) );
    public final ManchesterOWLSyntaxAutoComplete.cardinalityRestriction_return cardinalityRestriction() throws RecognitionException {
        ManchesterOWLSyntaxAutoComplete.cardinalityRestriction_return retval = new ManchesterOWLSyntaxAutoComplete.cardinalityRestriction_return();
        retval.start = input.LT(1);

        ManchesterOWLSyntaxTree i=null;
        ManchesterOWLSyntaxAutoComplete.unary_return p = null;

        ManchesterOWLSyntaxAutoComplete.expression_return filler = null;


        try {
            // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxAutoComplete.g:433:1: ( ^( CARDINALITY_RESTRICTION MIN i= INTEGER p= unary (filler= expression )? ) | ^( CARDINALITY_RESTRICTION MAX i= INTEGER p= unary (filler= expression )? ) | ^( CARDINALITY_RESTRICTION EXACTLY i= INTEGER p= unary (filler= expression )? ) )
            int alt16=3;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==CARDINALITY_RESTRICTION) ) {
                int LA16_1 = input.LA(2);

                if ( (LA16_1==DOWN) ) {
                    switch ( input.LA(3) ) {
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
                            new NoViableAltException("", 16, 2, input);

                        throw nvae;
                    }

                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 16, 1, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 16, 0, input);

                throw nvae;
            }
            switch (alt16) {
                case 1 :
                    // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxAutoComplete.g:434:5: ^( CARDINALITY_RESTRICTION MIN i= INTEGER p= unary (filler= expression )? )
                    {
                    match(input,CARDINALITY_RESTRICTION,FOLLOW_CARDINALITY_RESTRICTION_in_cardinalityRestriction1270); if (state.failed) return retval;

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    match(input,MIN,FOLLOW_MIN_in_cardinalityRestriction1273); if (state.failed) return retval;
                    i=(ManchesterOWLSyntaxTree)match(input,INTEGER,FOLLOW_INTEGER_in_cardinalityRestriction1278); if (state.failed) return retval;
                    pushFollow(FOLLOW_unary_in_cardinalityRestriction1284);
                    p=unary();

                    state._fsp--;
                    if (state.failed) return retval;
                    // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxAutoComplete.g:434:65: (filler= expression )?
                    int alt13=2;
                    int LA13_0 = input.LA(1);

                    if ( ((LA13_0>=IDENTIFIER && LA13_0<=ENTITY_REFERENCE)||(LA13_0>=DISJUNCTION && LA13_0<=NEGATED_EXPRESSION)||(LA13_0>=SOME_RESTRICTION && LA13_0<=ONE_OF)||LA13_0==INVERSE_OBJECT_PROPERTY_EXPRESSION||LA13_0==CONSTANT) ) {
                        alt13=1;
                    }
                    switch (alt13) {
                        case 1 :
                            // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxAutoComplete.g:434:65: filler= expression
                            {
                            pushFollow(FOLLOW_expression_in_cardinalityRestriction1291);
                            filler=expression();

                            state._fsp--;
                            if (state.failed) return retval;

                            }
                            break;

                    }


                    match(input, Token.UP, null); if (state.failed) return retval;
                    if ( state.backtracking==1 ) {

                      			if(filler==null){
                            	retval.completions = (p!=null?p.completions:null);
                            }else{
                            	retval.completions = filler.completions;
                            }
                      		
                    }

                    }
                    break;
                case 2 :
                    // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxAutoComplete.g:442:6: ^( CARDINALITY_RESTRICTION MAX i= INTEGER p= unary (filler= expression )? )
                    {
                    match(input,CARDINALITY_RESTRICTION,FOLLOW_CARDINALITY_RESTRICTION_in_cardinalityRestriction1306); if (state.failed) return retval;

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    match(input,MAX,FOLLOW_MAX_in_cardinalityRestriction1309); if (state.failed) return retval;
                    i=(ManchesterOWLSyntaxTree)match(input,INTEGER,FOLLOW_INTEGER_in_cardinalityRestriction1313); if (state.failed) return retval;
                    pushFollow(FOLLOW_unary_in_cardinalityRestriction1319);
                    p=unary();

                    state._fsp--;
                    if (state.failed) return retval;
                    // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxAutoComplete.g:442:65: (filler= expression )?
                    int alt14=2;
                    int LA14_0 = input.LA(1);

                    if ( ((LA14_0>=IDENTIFIER && LA14_0<=ENTITY_REFERENCE)||(LA14_0>=DISJUNCTION && LA14_0<=NEGATED_EXPRESSION)||(LA14_0>=SOME_RESTRICTION && LA14_0<=ONE_OF)||LA14_0==INVERSE_OBJECT_PROPERTY_EXPRESSION||LA14_0==CONSTANT) ) {
                        alt14=1;
                    }
                    switch (alt14) {
                        case 1 :
                            // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxAutoComplete.g:442:65: filler= expression
                            {
                            pushFollow(FOLLOW_expression_in_cardinalityRestriction1326);
                            filler=expression();

                            state._fsp--;
                            if (state.failed) return retval;

                            }
                            break;

                    }


                    match(input, Token.UP, null); if (state.failed) return retval;
                    if ( state.backtracking==1 ) {

                            if(filler==null){
                            	retval.completions = (p!=null?p.completions:null);
                            }else{
                            	retval.completions = filler.completions;
                            }
                          
                    }

                    }
                    break;
                case 3 :
                    // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxAutoComplete.g:450:8: ^( CARDINALITY_RESTRICTION EXACTLY i= INTEGER p= unary (filler= expression )? )
                    {
                    match(input,CARDINALITY_RESTRICTION,FOLLOW_CARDINALITY_RESTRICTION_in_cardinalityRestriction1345); if (state.failed) return retval;

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    match(input,EXACTLY,FOLLOW_EXACTLY_in_cardinalityRestriction1348); if (state.failed) return retval;
                    i=(ManchesterOWLSyntaxTree)match(input,INTEGER,FOLLOW_INTEGER_in_cardinalityRestriction1353); if (state.failed) return retval;
                    pushFollow(FOLLOW_unary_in_cardinalityRestriction1360);
                    p=unary();

                    state._fsp--;
                    if (state.failed) return retval;
                    // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxAutoComplete.g:450:73: (filler= expression )?
                    int alt15=2;
                    int LA15_0 = input.LA(1);

                    if ( ((LA15_0>=IDENTIFIER && LA15_0<=ENTITY_REFERENCE)||(LA15_0>=DISJUNCTION && LA15_0<=NEGATED_EXPRESSION)||(LA15_0>=SOME_RESTRICTION && LA15_0<=ONE_OF)||LA15_0==INVERSE_OBJECT_PROPERTY_EXPRESSION||LA15_0==CONSTANT) ) {
                        alt15=1;
                    }
                    switch (alt15) {
                        case 1 :
                            // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxAutoComplete.g:450:73: filler= expression
                            {
                            pushFollow(FOLLOW_expression_in_cardinalityRestriction1367);
                            filler=expression();

                            state._fsp--;
                            if (state.failed) return retval;

                            }
                            break;

                    }


                    match(input, Token.UP, null); if (state.failed) return retval;
                    if ( state.backtracking==1 ) {

                            if(filler==null){
                            	retval.completions = (p!=null?p.completions:null);
                            }else{
                            	retval.completions = filler.completions;
                            }
                            
                          
                    }

                    }
                    break;

            }
            if ( state.backtracking==1 ) {
               
                        if(retval.completions!=null){          
                          ((ManchesterOWLSyntaxTree)retval.start).setCompletions(retval.completions);
                        }

              					retval.type = ((ManchesterOWLSyntaxTree)retval.start).getEvalType();
                      
            }
        }

          catch(RecognitionException exception){
           
          }
          
          catch(RewriteEmptyStreamException exception){
          
          }
        finally {
        }
        return retval;
    }
    // $ANTLR end "cardinalityRestriction"

    public static class oneOf_return extends TreeRuleReturnScope {
        public List<String> completions;
        public Type type;
    };

    // $ANTLR start "oneOf"
    // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxAutoComplete.g:461:1: oneOf returns [List<String> completions, Type type] : ^( ONE_OF (individuals+= IDENTIFIER )+ ) ;
    public final ManchesterOWLSyntaxAutoComplete.oneOf_return oneOf() throws RecognitionException {
        ManchesterOWLSyntaxAutoComplete.oneOf_return retval = new ManchesterOWLSyntaxAutoComplete.oneOf_return();
        retval.start = input.LT(1);

        ManchesterOWLSyntaxTree individuals=null;
        List list_individuals=null;

        try {
            // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxAutoComplete.g:469:2: ( ^( ONE_OF (individuals+= IDENTIFIER )+ ) )
            // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxAutoComplete.g:470:3: ^( ONE_OF (individuals+= IDENTIFIER )+ )
            {
            match(input,ONE_OF,FOLLOW_ONE_OF_in_oneOf1403); if (state.failed) return retval;

            match(input, Token.DOWN, null); if (state.failed) return retval;
            // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxAutoComplete.g:470:23: (individuals+= IDENTIFIER )+
            int cnt17=0;
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( (LA17_0==IDENTIFIER) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxAutoComplete.g:470:23: individuals+= IDENTIFIER
            	    {
            	    individuals=(ManchesterOWLSyntaxTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_oneOf1407); if (state.failed) return retval;
            	    if (list_individuals==null) list_individuals=new ArrayList();
            	    list_individuals.add(individuals);


            	    }
            	    break;

            	default :
            	    if ( cnt17 >= 1 ) break loop17;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(17, input);
                        throw eee;
                }
                cnt17++;
            } while (true);


            match(input, Token.UP, null); if (state.failed) return retval;
            if ( state.backtracking==1 ) {

              		    List<ManchesterOWLSyntaxTree> nodes = new ArrayList<ManchesterOWLSyntaxTree>(list_individuals.size());
                      for(Object node :list_individuals){
                        nodes.add((ManchesterOWLSyntaxTree)node);
                      }		    
              		    if(!nodes.isEmpty()){
                        retval.completions = nodes.get(nodes.size()-1).getCompletions();
                      }
              		
            }

            }

            if ( state.backtracking==1 ) {
               
                        if(retval.completions!=null){          
                          ((ManchesterOWLSyntaxTree)retval.start).setCompletions(retval.completions);
                        }

                        retval.type = ((ManchesterOWLSyntaxTree)retval.start).getEvalType();
                      
            }
        }

          catch(RecognitionException exception){
           
          }
          
          catch(RewriteEmptyStreamException exception){
          
          }
        finally {
        }
        return retval;
    }
    // $ANTLR end "oneOf"

    public static class valueRestriction_return extends TreeRuleReturnScope {
        public List<String> completions;
        public Type type;
    };

    // $ANTLR start "valueRestriction"
    // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxAutoComplete.g:482:1: valueRestriction returns [List<String> completions, Type type] : ^( VALUE_RESTRICTION p= unary value= unary ) ;
    public final ManchesterOWLSyntaxAutoComplete.valueRestriction_return valueRestriction() throws RecognitionException {
        ManchesterOWLSyntaxAutoComplete.valueRestriction_return retval = new ManchesterOWLSyntaxAutoComplete.valueRestriction_return();
        retval.start = input.LT(1);

        ManchesterOWLSyntaxAutoComplete.unary_return p = null;

        ManchesterOWLSyntaxAutoComplete.unary_return value = null;


        try {
            // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxAutoComplete.g:489:2: ( ^( VALUE_RESTRICTION p= unary value= unary ) )
            // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxAutoComplete.g:490:3: ^( VALUE_RESTRICTION p= unary value= unary )
            {
            match(input,VALUE_RESTRICTION,FOLLOW_VALUE_RESTRICTION_in_valueRestriction1440); if (state.failed) return retval;

            match(input, Token.DOWN, null); if (state.failed) return retval;
            pushFollow(FOLLOW_unary_in_valueRestriction1447);
            p=unary();

            state._fsp--;
            if (state.failed) return retval;
            pushFollow(FOLLOW_unary_in_valueRestriction1454);
            value=unary();

            state._fsp--;
            if (state.failed) return retval;

            match(input, Token.UP, null); if (state.failed) return retval;
            if ( state.backtracking==1 ) {

              		  retval.completions =(value!=null?value.completions:null);
              		 
            }

            }

            if ( state.backtracking==1 ) {
               
                        if(retval.completions!=null){          
                          ((ManchesterOWLSyntaxTree)retval.start).setCompletions(retval.completions);
                        }
                        retval.type = ((ManchesterOWLSyntaxTree)retval.start).getEvalType();
                      
            }
        }

          catch(RecognitionException exception){
           
          }
          
          catch(RewriteEmptyStreamException exception){
          
          }
        finally {
        }
        return retval;
    }
    // $ANTLR end "valueRestriction"

    public static class incompleteAxiom_return extends TreeRuleReturnScope {
        public List<String> completions;
    };

    // $ANTLR start "incompleteAxiom"
    // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxAutoComplete.g:498:1: incompleteAxiom returns [List<String> completions] : ( ^( INCOMPLETE_SUB_CLASS_AXIOM ^( EXPRESSION subClass= expression ) superClass= incompleteExpression ) | ^( INCOMPLETE_SUB_CLASS_AXIOM ^( EXPRESSION subClass= expression ) ) | ^( INCOMPLETE_EQUIVALENT_TO_AXIOM ^( EXPRESSION lhs= expression ) ^( INCOMPLETE_EXPRESSION rhs= incompleteExpression ) ) | ^( INCOMPLETE_INVERSE_OF ^( EXPRESSION p= IDENTIFIER ) ) | ^( INCOMPLETE_DISJOINT_WITH_AXIOM ^( EXPRESSION lhs= expression ) ^( INCOMPLETE_EXPRESSION rhs= incompleteExpression ) ) | ^( INCOMPLETE_SUB_PROPERTY_AXIOM ^( EXPRESSION subProperty= expression ) ) | ^( INCOMPLETE_ROLE_ASSERTION ^( EXPRESSION IDENTIFIER ) ^( EXPRESSION propertyExpression ) ) | ^( INCOMPLETE_TYPE_ASSERTION ^( EXPRESSION IDENTIFIER ) ) | ^( INCOMPLETE_DOMAIN ^( EXPRESSION p= IDENTIFIER ) ) | ^( INCOMPLETE_DOMAIN ^( EXPRESSION p= IDENTIFIER ) ^( INCOMPLETE_EXPRESSION domain= incompleteExpression ) ) | ^( INCOMPLETE_RANGE ^( EXPRESSION p= IDENTIFIER ) ) | ^( INCOMPLETE_RANGE ^( EXPRESSION p= IDENTIFIER ) ^( INCOMPLETE_EXPRESSION range= incompleteExpression ) ) | ^( INCOMPLETE_SAME_AS_AXIOM ^( EXPRESSION anIndividual= IDENTIFIER ) ) | ^( INCOMPLETE_DIFFERENT_FROM_AXIOM ^( EXPRESSION anIndividual= IDENTIFIER ) ) | ^( INCOMPLETE_UNARY_AXIOM FUNCTIONAL ) | ^( INCOMPLETE_UNARY_AXIOM INVERSE_FUNCTIONAL ) | ^( INCOMPLETE_UNARY_AXIOM IRREFLEXIVE ) | ^( INCOMPLETE_UNARY_AXIOM REFLEXIVE ) | ^( INCOMPLETE_UNARY_AXIOM SYMMETRIC ) | ^( INCOMPLETE_UNARY_AXIOM TRANSITIVE ) );
    public final ManchesterOWLSyntaxAutoComplete.incompleteAxiom_return incompleteAxiom() throws RecognitionException {
        ManchesterOWLSyntaxAutoComplete.incompleteAxiom_return retval = new ManchesterOWLSyntaxAutoComplete.incompleteAxiom_return();
        retval.start = input.LT(1);

        ManchesterOWLSyntaxTree p=null;
        ManchesterOWLSyntaxTree anIndividual=null;
        ManchesterOWLSyntaxAutoComplete.expression_return subClass = null;

        ManchesterOWLSyntaxAutoComplete.incompleteExpression_return superClass = null;

        ManchesterOWLSyntaxAutoComplete.expression_return lhs = null;

        ManchesterOWLSyntaxAutoComplete.incompleteExpression_return rhs = null;

        ManchesterOWLSyntaxAutoComplete.expression_return subProperty = null;

        ManchesterOWLSyntaxAutoComplete.incompleteExpression_return domain = null;

        ManchesterOWLSyntaxAutoComplete.incompleteExpression_return range = null;


        try {
            // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxAutoComplete.g:505:1: ( ^( INCOMPLETE_SUB_CLASS_AXIOM ^( EXPRESSION subClass= expression ) superClass= incompleteExpression ) | ^( INCOMPLETE_SUB_CLASS_AXIOM ^( EXPRESSION subClass= expression ) ) | ^( INCOMPLETE_EQUIVALENT_TO_AXIOM ^( EXPRESSION lhs= expression ) ^( INCOMPLETE_EXPRESSION rhs= incompleteExpression ) ) | ^( INCOMPLETE_INVERSE_OF ^( EXPRESSION p= IDENTIFIER ) ) | ^( INCOMPLETE_DISJOINT_WITH_AXIOM ^( EXPRESSION lhs= expression ) ^( INCOMPLETE_EXPRESSION rhs= incompleteExpression ) ) | ^( INCOMPLETE_SUB_PROPERTY_AXIOM ^( EXPRESSION subProperty= expression ) ) | ^( INCOMPLETE_ROLE_ASSERTION ^( EXPRESSION IDENTIFIER ) ^( EXPRESSION propertyExpression ) ) | ^( INCOMPLETE_TYPE_ASSERTION ^( EXPRESSION IDENTIFIER ) ) | ^( INCOMPLETE_DOMAIN ^( EXPRESSION p= IDENTIFIER ) ) | ^( INCOMPLETE_DOMAIN ^( EXPRESSION p= IDENTIFIER ) ^( INCOMPLETE_EXPRESSION domain= incompleteExpression ) ) | ^( INCOMPLETE_RANGE ^( EXPRESSION p= IDENTIFIER ) ) | ^( INCOMPLETE_RANGE ^( EXPRESSION p= IDENTIFIER ) ^( INCOMPLETE_EXPRESSION range= incompleteExpression ) ) | ^( INCOMPLETE_SAME_AS_AXIOM ^( EXPRESSION anIndividual= IDENTIFIER ) ) | ^( INCOMPLETE_DIFFERENT_FROM_AXIOM ^( EXPRESSION anIndividual= IDENTIFIER ) ) | ^( INCOMPLETE_UNARY_AXIOM FUNCTIONAL ) | ^( INCOMPLETE_UNARY_AXIOM INVERSE_FUNCTIONAL ) | ^( INCOMPLETE_UNARY_AXIOM IRREFLEXIVE ) | ^( INCOMPLETE_UNARY_AXIOM REFLEXIVE ) | ^( INCOMPLETE_UNARY_AXIOM SYMMETRIC ) | ^( INCOMPLETE_UNARY_AXIOM TRANSITIVE ) )
            int alt18=20;
            alt18 = dfa18.predict(input);
            switch (alt18) {
                case 1 :
                    // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxAutoComplete.g:506:4: ^( INCOMPLETE_SUB_CLASS_AXIOM ^( EXPRESSION subClass= expression ) superClass= incompleteExpression )
                    {
                    match(input,INCOMPLETE_SUB_CLASS_AXIOM,FOLLOW_INCOMPLETE_SUB_CLASS_AXIOM_in_incompleteAxiom1496); if (state.failed) return retval;

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    match(input,EXPRESSION,FOLLOW_EXPRESSION_in_incompleteAxiom1500); if (state.failed) return retval;

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    pushFollow(FOLLOW_expression_in_incompleteAxiom1507);
                    subClass=expression();

                    state._fsp--;
                    if (state.failed) return retval;

                    match(input, Token.UP, null); if (state.failed) return retval;
                    pushFollow(FOLLOW_incompleteExpression_in_incompleteAxiom1515);
                    superClass=incompleteExpression();

                    state._fsp--;
                    if (state.failed) return retval;

                    match(input, Token.UP, null); if (state.failed) return retval;
                    if ( state.backtracking==1 ) {
                           
                            retval.completions = superClass.completions;
                          
                    }

                    }
                    break;
                case 2 :
                    // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxAutoComplete.g:510:6: ^( INCOMPLETE_SUB_CLASS_AXIOM ^( EXPRESSION subClass= expression ) )
                    {
                    match(input,INCOMPLETE_SUB_CLASS_AXIOM,FOLLOW_INCOMPLETE_SUB_CLASS_AXIOM_in_incompleteAxiom1530); if (state.failed) return retval;

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    match(input,EXPRESSION,FOLLOW_EXPRESSION_in_incompleteAxiom1534); if (state.failed) return retval;

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    pushFollow(FOLLOW_expression_in_incompleteAxiom1541);
                    subClass=expression();

                    state._fsp--;
                    if (state.failed) return retval;

                    match(input, Token.UP, null); if (state.failed) return retval;

                    match(input, Token.UP, null); if (state.failed) return retval;
                    if ( state.backtracking==1 ) {
                           
                             // class expression completions
                           retval.completions = new ArrayList<String>(symtab.getOWLClassCompletions());
                          
                    }

                    }
                    break;
                case 3 :
                    // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxAutoComplete.g:515:6: ^( INCOMPLETE_EQUIVALENT_TO_AXIOM ^( EXPRESSION lhs= expression ) ^( INCOMPLETE_EXPRESSION rhs= incompleteExpression ) )
                    {
                    match(input,INCOMPLETE_EQUIVALENT_TO_AXIOM,FOLLOW_INCOMPLETE_EQUIVALENT_TO_AXIOM_in_incompleteAxiom1559); if (state.failed) return retval;

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    match(input,EXPRESSION,FOLLOW_EXPRESSION_in_incompleteAxiom1562); if (state.failed) return retval;

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    pushFollow(FOLLOW_expression_in_incompleteAxiom1568);
                    lhs=expression();

                    state._fsp--;
                    if (state.failed) return retval;

                    match(input, Token.UP, null); if (state.failed) return retval;
                    match(input,INCOMPLETE_EXPRESSION,FOLLOW_INCOMPLETE_EXPRESSION_in_incompleteAxiom1572); if (state.failed) return retval;

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    pushFollow(FOLLOW_incompleteExpression_in_incompleteAxiom1579);
                    rhs=incompleteExpression();

                    state._fsp--;
                    if (state.failed) return retval;

                    match(input, Token.UP, null); if (state.failed) return retval;

                    match(input, Token.UP, null); if (state.failed) return retval;
                    if ( state.backtracking==1 ) {
                            
                            retval.completions = rhs.completions;
                           
                    }

                    }
                    break;
                case 4 :
                    // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxAutoComplete.g:519:5: ^( INCOMPLETE_INVERSE_OF ^( EXPRESSION p= IDENTIFIER ) )
                    {
                    match(input,INCOMPLETE_INVERSE_OF,FOLLOW_INCOMPLETE_INVERSE_OF_in_incompleteAxiom1597); if (state.failed) return retval;

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    match(input,EXPRESSION,FOLLOW_EXPRESSION_in_incompleteAxiom1600); if (state.failed) return retval;

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    p=(ManchesterOWLSyntaxTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_incompleteAxiom1606); if (state.failed) return retval;

                    match(input, Token.UP, null); if (state.failed) return retval;

                    match(input, Token.UP, null); if (state.failed) return retval;
                    if ( state.backtracking==1 ) {
                          
                           // object property expression completions
                           retval.completions = new ArrayList<String>(symtab.getOWLObjectPropertyCompletions());
                        
                    }

                    }
                    break;
                case 5 :
                    // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxAutoComplete.g:524:5: ^( INCOMPLETE_DISJOINT_WITH_AXIOM ^( EXPRESSION lhs= expression ) ^( INCOMPLETE_EXPRESSION rhs= incompleteExpression ) )
                    {
                    match(input,INCOMPLETE_DISJOINT_WITH_AXIOM,FOLLOW_INCOMPLETE_DISJOINT_WITH_AXIOM_in_incompleteAxiom1619); if (state.failed) return retval;

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    match(input,EXPRESSION,FOLLOW_EXPRESSION_in_incompleteAxiom1622); if (state.failed) return retval;

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    pushFollow(FOLLOW_expression_in_incompleteAxiom1629);
                    lhs=expression();

                    state._fsp--;
                    if (state.failed) return retval;

                    match(input, Token.UP, null); if (state.failed) return retval;
                    match(input,INCOMPLETE_EXPRESSION,FOLLOW_INCOMPLETE_EXPRESSION_in_incompleteAxiom1633); if (state.failed) return retval;

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    pushFollow(FOLLOW_incompleteExpression_in_incompleteAxiom1639);
                    rhs=incompleteExpression();

                    state._fsp--;
                    if (state.failed) return retval;

                    match(input, Token.UP, null); if (state.failed) return retval;

                    match(input, Token.UP, null); if (state.failed) return retval;
                    if ( state.backtracking==1 ) {
                           
                           retval.completions = rhs.completions;
                        
                    }

                    }
                    break;
                case 6 :
                    // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxAutoComplete.g:527:5: ^( INCOMPLETE_SUB_PROPERTY_AXIOM ^( EXPRESSION subProperty= expression ) )
                    {
                    match(input,INCOMPLETE_SUB_PROPERTY_AXIOM,FOLLOW_INCOMPLETE_SUB_PROPERTY_AXIOM_in_incompleteAxiom1652); if (state.failed) return retval;

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    match(input,EXPRESSION,FOLLOW_EXPRESSION_in_incompleteAxiom1655); if (state.failed) return retval;

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    pushFollow(FOLLOW_expression_in_incompleteAxiom1662);
                    subProperty=expression();

                    state._fsp--;
                    if (state.failed) return retval;

                    match(input, Token.UP, null); if (state.failed) return retval;

                    match(input, Token.UP, null); if (state.failed) return retval;
                    if ( state.backtracking==1 ) {
                           
                            // property expression completions
                            Type type = subProperty.type;      
                            retval.completions = (type == null)? Collections.<String>emptyList() : new ArrayList<String>(symtab.getAllCompletions(type));
                          
                    }

                    }
                    break;
                case 7 :
                    // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxAutoComplete.g:533:5: ^( INCOMPLETE_ROLE_ASSERTION ^( EXPRESSION IDENTIFIER ) ^( EXPRESSION propertyExpression ) )
                    {
                    match(input,INCOMPLETE_ROLE_ASSERTION,FOLLOW_INCOMPLETE_ROLE_ASSERTION_in_incompleteAxiom1680); if (state.failed) return retval;

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    match(input,EXPRESSION,FOLLOW_EXPRESSION_in_incompleteAxiom1683); if (state.failed) return retval;

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_incompleteAxiom1685); if (state.failed) return retval;

                    match(input, Token.UP, null); if (state.failed) return retval;
                    match(input,EXPRESSION,FOLLOW_EXPRESSION_in_incompleteAxiom1689); if (state.failed) return retval;

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    pushFollow(FOLLOW_propertyExpression_in_incompleteAxiom1691);
                    propertyExpression();

                    state._fsp--;
                    if (state.failed) return retval;

                    match(input, Token.UP, null); if (state.failed) return retval;

                    match(input, Token.UP, null); if (state.failed) return retval;
                    if ( state.backtracking==1 ) {
                          
                           // individual expression completions
                           retval.completions = new ArrayList<String>(symtab.getOWLIndividualCompletions());
                         
                    }

                    }
                    break;
                case 8 :
                    // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxAutoComplete.g:537:6: ^( INCOMPLETE_TYPE_ASSERTION ^( EXPRESSION IDENTIFIER ) )
                    {
                    match(input,INCOMPLETE_TYPE_ASSERTION,FOLLOW_INCOMPLETE_TYPE_ASSERTION_in_incompleteAxiom1702); if (state.failed) return retval;

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    match(input,EXPRESSION,FOLLOW_EXPRESSION_in_incompleteAxiom1706); if (state.failed) return retval;

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_incompleteAxiom1708); if (state.failed) return retval;

                    match(input, Token.UP, null); if (state.failed) return retval;

                    match(input, Token.UP, null); if (state.failed) return retval;
                    if ( state.backtracking==1 ) {

                           // class expression completions
                           retval.completions = new ArrayList<String>(symtab.getOWLClassCompletions());
                        
                    }

                    }
                    break;
                case 9 :
                    // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxAutoComplete.g:542:5: ^( INCOMPLETE_DOMAIN ^( EXPRESSION p= IDENTIFIER ) )
                    {
                    match(input,INCOMPLETE_DOMAIN,FOLLOW_INCOMPLETE_DOMAIN_in_incompleteAxiom1721); if (state.failed) return retval;

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    match(input,EXPRESSION,FOLLOW_EXPRESSION_in_incompleteAxiom1724); if (state.failed) return retval;

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    p=(ManchesterOWLSyntaxTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_incompleteAxiom1730); if (state.failed) return retval;

                    match(input, Token.UP, null); if (state.failed) return retval;

                    match(input, Token.UP, null); if (state.failed) return retval;
                    if ( state.backtracking==1 ) {

                           // class expression completions
                           retval.completions = new ArrayList<String>(symtab.getOWLClassCompletions());
                         
                    }

                    }
                    break;
                case 10 :
                    // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxAutoComplete.g:547:5: ^( INCOMPLETE_DOMAIN ^( EXPRESSION p= IDENTIFIER ) ^( INCOMPLETE_EXPRESSION domain= incompleteExpression ) )
                    {
                    match(input,INCOMPLETE_DOMAIN,FOLLOW_INCOMPLETE_DOMAIN_in_incompleteAxiom1745); if (state.failed) return retval;

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    match(input,EXPRESSION,FOLLOW_EXPRESSION_in_incompleteAxiom1748); if (state.failed) return retval;

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    p=(ManchesterOWLSyntaxTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_incompleteAxiom1754); if (state.failed) return retval;

                    match(input, Token.UP, null); if (state.failed) return retval;
                    match(input,INCOMPLETE_EXPRESSION,FOLLOW_INCOMPLETE_EXPRESSION_in_incompleteAxiom1758); if (state.failed) return retval;

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    pushFollow(FOLLOW_incompleteExpression_in_incompleteAxiom1764);
                    domain=incompleteExpression();

                    state._fsp--;
                    if (state.failed) return retval;

                    match(input, Token.UP, null); if (state.failed) return retval;

                    match(input, Token.UP, null); if (state.failed) return retval;
                    if ( state.backtracking==1 ) {

                           retval.completions = domain.completions;
                         
                    }

                    }
                    break;
                case 11 :
                    // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxAutoComplete.g:551:6: ^( INCOMPLETE_RANGE ^( EXPRESSION p= IDENTIFIER ) )
                    {
                    match(input,INCOMPLETE_RANGE,FOLLOW_INCOMPLETE_RANGE_in_incompleteAxiom1779); if (state.failed) return retval;

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    match(input,EXPRESSION,FOLLOW_EXPRESSION_in_incompleteAxiom1782); if (state.failed) return retval;

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    p=(ManchesterOWLSyntaxTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_incompleteAxiom1788); if (state.failed) return retval;

                    match(input, Token.UP, null); if (state.failed) return retval;

                    match(input, Token.UP, null); if (state.failed) return retval;
                    if ( state.backtracking==1 ) {

                          // class expression completions
                          retval.completions = new ArrayList<String>(symtab.getOWLClassCompletions());
                         
                    }

                    }
                    break;
                case 12 :
                    // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxAutoComplete.g:555:6: ^( INCOMPLETE_RANGE ^( EXPRESSION p= IDENTIFIER ) ^( INCOMPLETE_EXPRESSION range= incompleteExpression ) )
                    {
                    match(input,INCOMPLETE_RANGE,FOLLOW_INCOMPLETE_RANGE_in_incompleteAxiom1799); if (state.failed) return retval;

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    match(input,EXPRESSION,FOLLOW_EXPRESSION_in_incompleteAxiom1802); if (state.failed) return retval;

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    p=(ManchesterOWLSyntaxTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_incompleteAxiom1808); if (state.failed) return retval;

                    match(input, Token.UP, null); if (state.failed) return retval;
                    match(input,INCOMPLETE_EXPRESSION,FOLLOW_INCOMPLETE_EXPRESSION_in_incompleteAxiom1812); if (state.failed) return retval;

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    pushFollow(FOLLOW_incompleteExpression_in_incompleteAxiom1818);
                    range=incompleteExpression();

                    state._fsp--;
                    if (state.failed) return retval;

                    match(input, Token.UP, null); if (state.failed) return retval;

                    match(input, Token.UP, null); if (state.failed) return retval;
                    if ( state.backtracking==1 ) {

                           retval.completions = range.completions;;
                         
                    }

                    }
                    break;
                case 13 :
                    // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxAutoComplete.g:559:6: ^( INCOMPLETE_SAME_AS_AXIOM ^( EXPRESSION anIndividual= IDENTIFIER ) )
                    {
                    match(input,INCOMPLETE_SAME_AS_AXIOM,FOLLOW_INCOMPLETE_SAME_AS_AXIOM_in_incompleteAxiom1833); if (state.failed) return retval;

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    match(input,EXPRESSION,FOLLOW_EXPRESSION_in_incompleteAxiom1836); if (state.failed) return retval;

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    anIndividual=(ManchesterOWLSyntaxTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_incompleteAxiom1841); if (state.failed) return retval;

                    match(input, Token.UP, null); if (state.failed) return retval;

                    match(input, Token.UP, null); if (state.failed) return retval;
                    if ( state.backtracking==1 ) {

                          // individual expression completions
                          retval.completions = new ArrayList<String>(symtab.getOWLIndividualCompletions());
                         
                    }

                    }
                    break;
                case 14 :
                    // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxAutoComplete.g:564:7: ^( INCOMPLETE_DIFFERENT_FROM_AXIOM ^( EXPRESSION anIndividual= IDENTIFIER ) )
                    {
                    match(input,INCOMPLETE_DIFFERENT_FROM_AXIOM,FOLLOW_INCOMPLETE_DIFFERENT_FROM_AXIOM_in_incompleteAxiom1857); if (state.failed) return retval;

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    match(input,EXPRESSION,FOLLOW_EXPRESSION_in_incompleteAxiom1860); if (state.failed) return retval;

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    anIndividual=(ManchesterOWLSyntaxTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_incompleteAxiom1865); if (state.failed) return retval;

                    match(input, Token.UP, null); if (state.failed) return retval;

                    match(input, Token.UP, null); if (state.failed) return retval;
                    if ( state.backtracking==1 ) {

                          // individual expression completions
                          retval.completions = new ArrayList<String>(symtab.getOWLIndividualCompletions());
                         
                    }

                    }
                    break;
                case 15 :
                    // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxAutoComplete.g:569:6: ^( INCOMPLETE_UNARY_AXIOM FUNCTIONAL )
                    {
                    match(input,INCOMPLETE_UNARY_AXIOM,FOLLOW_INCOMPLETE_UNARY_AXIOM_in_incompleteAxiom1880); if (state.failed) return retval;

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    match(input,FUNCTIONAL,FOLLOW_FUNCTIONAL_in_incompleteAxiom1882); if (state.failed) return retval;

                    match(input, Token.UP, null); if (state.failed) return retval;
                    if ( state.backtracking==1 ) {

                           // property expression completions
                           retval.completions =  new ArrayList<String>(symtab.getAllCompletions(OWLType.OWL_OBJECT_PROPERTY,OWLType.OWL_DATA_PROPERTY));
                         
                    }

                    }
                    break;
                case 16 :
                    // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxAutoComplete.g:574:6: ^( INCOMPLETE_UNARY_AXIOM INVERSE_FUNCTIONAL )
                    {
                    match(input,INCOMPLETE_UNARY_AXIOM,FOLLOW_INCOMPLETE_UNARY_AXIOM_in_incompleteAxiom1896); if (state.failed) return retval;

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    match(input,INVERSE_FUNCTIONAL,FOLLOW_INVERSE_FUNCTIONAL_in_incompleteAxiom1898); if (state.failed) return retval;

                    match(input, Token.UP, null); if (state.failed) return retval;
                    if ( state.backtracking==1 ) {

                           // object property expression completions
                           retval.completions = new ArrayList<String>(symtab.getOWLObjectPropertyCompletions());
                         
                    }

                    }
                    break;
                case 17 :
                    // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxAutoComplete.g:579:7: ^( INCOMPLETE_UNARY_AXIOM IRREFLEXIVE )
                    {
                    match(input,INCOMPLETE_UNARY_AXIOM,FOLLOW_INCOMPLETE_UNARY_AXIOM_in_incompleteAxiom1913); if (state.failed) return retval;

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    match(input,IRREFLEXIVE,FOLLOW_IRREFLEXIVE_in_incompleteAxiom1915); if (state.failed) return retval;

                    match(input, Token.UP, null); if (state.failed) return retval;
                    if ( state.backtracking==1 ) {
                           
                           // object property expression completions
                           retval.completions = new ArrayList<String>(symtab.getOWLObjectPropertyCompletions());
                         
                    }

                    }
                    break;
                case 18 :
                    // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxAutoComplete.g:584:6: ^( INCOMPLETE_UNARY_AXIOM REFLEXIVE )
                    {
                    match(input,INCOMPLETE_UNARY_AXIOM,FOLLOW_INCOMPLETE_UNARY_AXIOM_in_incompleteAxiom1929); if (state.failed) return retval;

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    match(input,REFLEXIVE,FOLLOW_REFLEXIVE_in_incompleteAxiom1931); if (state.failed) return retval;

                    match(input, Token.UP, null); if (state.failed) return retval;
                    if ( state.backtracking==1 ) {

                            // object property expression completions   
                            retval.completions = new ArrayList<String>(symtab.getOWLObjectPropertyCompletions());
                         
                    }

                    }
                    break;
                case 19 :
                    // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxAutoComplete.g:589:6: ^( INCOMPLETE_UNARY_AXIOM SYMMETRIC )
                    {
                    match(input,INCOMPLETE_UNARY_AXIOM,FOLLOW_INCOMPLETE_UNARY_AXIOM_in_incompleteAxiom1945); if (state.failed) return retval;

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    match(input,SYMMETRIC,FOLLOW_SYMMETRIC_in_incompleteAxiom1947); if (state.failed) return retval;

                    match(input, Token.UP, null); if (state.failed) return retval;
                    if ( state.backtracking==1 ) {

                            // object property expression completions
                            retval.completions = new ArrayList<String>(symtab.getOWLObjectPropertyCompletions());
                         
                    }

                    }
                    break;
                case 20 :
                    // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxAutoComplete.g:594:7: ^( INCOMPLETE_UNARY_AXIOM TRANSITIVE )
                    {
                    match(input,INCOMPLETE_UNARY_AXIOM,FOLLOW_INCOMPLETE_UNARY_AXIOM_in_incompleteAxiom1963); if (state.failed) return retval;

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    match(input,TRANSITIVE,FOLLOW_TRANSITIVE_in_incompleteAxiom1965); if (state.failed) return retval;

                    match(input, Token.UP, null); if (state.failed) return retval;
                    if ( state.backtracking==1 ) {

                           // object property expression completions
                           retval.completions = new ArrayList<String>(symtab.getOWLObjectPropertyCompletions());
                         
                    }

                    }
                    break;

            }
            if ( state.backtracking==1 ) {
               
                      if(retval.completions!=null){
                        ((ManchesterOWLSyntaxTree)retval.start).setCompletions(retval.completions);
                      }
                    
            }
        }

          catch(RecognitionException exception){
           
          }
          
          catch(RewriteEmptyStreamException exception){
          
          }
        finally {
        }
        return retval;
    }
    // $ANTLR end "incompleteAxiom"

    public static class incompleteExpression_return extends TreeRuleReturnScope {
        public List<String> completions;
    };

    // $ANTLR start "incompleteExpression"
    // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxAutoComplete.g:601:1: incompleteExpression returns [List<String> completions] : ( ^( INCOMPLETE_PROPERTY_CHAIN ( . )+ ) | ^( INCOMPLETE_DISJUNCTION (ic= incompleteConjunction )? ) | ^( INCOMPLETE_EXPRESSION ^( EXPRESSION e= expression ) IDENTIFIER ) );
    public final ManchesterOWLSyntaxAutoComplete.incompleteExpression_return incompleteExpression() throws RecognitionException {
        ManchesterOWLSyntaxAutoComplete.incompleteExpression_return retval = new ManchesterOWLSyntaxAutoComplete.incompleteExpression_return();
        retval.start = input.LT(1);

        ManchesterOWLSyntaxTree IDENTIFIER17=null;
        ManchesterOWLSyntaxAutoComplete.incompleteConjunction_return ic = null;

        ManchesterOWLSyntaxAutoComplete.expression_return e = null;


        try {
            // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxAutoComplete.g:608:1: ( ^( INCOMPLETE_PROPERTY_CHAIN ( . )+ ) | ^( INCOMPLETE_DISJUNCTION (ic= incompleteConjunction )? ) | ^( INCOMPLETE_EXPRESSION ^( EXPRESSION e= expression ) IDENTIFIER ) )
            int alt21=3;
            switch ( input.LA(1) ) {
            case INCOMPLETE_PROPERTY_CHAIN:
                {
                alt21=1;
                }
                break;
            case INCOMPLETE_DISJUNCTION:
                {
                alt21=2;
                }
                break;
            case INCOMPLETE_EXPRESSION:
                {
                alt21=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 21, 0, input);

                throw nvae;
            }

            switch (alt21) {
                case 1 :
                    // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxAutoComplete.g:609:3: ^( INCOMPLETE_PROPERTY_CHAIN ( . )+ )
                    {
                    match(input,INCOMPLETE_PROPERTY_CHAIN,FOLLOW_INCOMPLETE_PROPERTY_CHAIN_in_incompleteExpression2007); if (state.failed) return retval;

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxAutoComplete.g:609:32: ( . )+
                    int cnt19=0;
                    loop19:
                    do {
                        int alt19=2;
                        int LA19_0 = input.LA(1);

                        if ( ((LA19_0>=COMPOSITION && LA19_0<=INCOMPLETE_EXPRESSION)) ) {
                            alt19=1;
                        }
                        else if ( (LA19_0==UP) ) {
                            alt19=2;
                        }


                        switch (alt19) {
                    	case 1 :
                    	    // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxAutoComplete.g:609:32: .
                    	    {
                    	    matchAny(input); if (state.failed) return retval;

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt19 >= 1 ) break loop19;
                    	    if (state.backtracking>0) {state.failed=true; return retval;}
                                EarlyExitException eee =
                                    new EarlyExitException(19, input);
                                throw eee;
                        }
                        cnt19++;
                    } while (true);


                    match(input, Token.UP, null); if (state.failed) return retval;
                    if ( state.backtracking==1 ) {

                          // object property expression completions
                          retval.completions = new ArrayList<String>(symtab.getOWLObjectPropertyCompletions());
                        
                    }

                    }
                    break;
                case 2 :
                    // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxAutoComplete.g:615:5: ^( INCOMPLETE_DISJUNCTION (ic= incompleteConjunction )? )
                    {
                    match(input,INCOMPLETE_DISJUNCTION,FOLLOW_INCOMPLETE_DISJUNCTION_in_incompleteExpression2026); if (state.failed) return retval;

                    if ( input.LA(1)==Token.DOWN ) {
                        match(input, Token.DOWN, null); if (state.failed) return retval;
                        // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxAutoComplete.g:615:34: (ic= incompleteConjunction )?
                        int alt20=2;
                        int LA20_0 = input.LA(1);

                        if ( (LA20_0==INCOMPLETE_CONJUNCTION) ) {
                            alt20=1;
                        }
                        switch (alt20) {
                            case 1 :
                                // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxAutoComplete.g:615:34: ic= incompleteConjunction
                                {
                                pushFollow(FOLLOW_incompleteConjunction_in_incompleteExpression2033);
                                ic=incompleteConjunction();

                                state._fsp--;
                                if (state.failed) return retval;

                                }
                                break;

                        }


                        match(input, Token.UP, null); if (state.failed) return retval;
                    }
                    if ( state.backtracking==1 ) {

                            if(e!=null){
                            	retval.completions = ic.completions;
                            }else{
                            	retval.completions = new ArrayList<String>(symtab.getOWLClassCompletions());
                            }
                        
                    }

                    }
                    break;
                case 3 :
                    // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxAutoComplete.g:623:5: ^( INCOMPLETE_EXPRESSION ^( EXPRESSION e= expression ) IDENTIFIER )
                    {
                    match(input,INCOMPLETE_EXPRESSION,FOLLOW_INCOMPLETE_EXPRESSION_in_incompleteExpression2048); if (state.failed) return retval;

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    match(input,EXPRESSION,FOLLOW_EXPRESSION_in_incompleteExpression2051); if (state.failed) return retval;

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    pushFollow(FOLLOW_expression_in_incompleteExpression2058);
                    e=expression();

                    state._fsp--;
                    if (state.failed) return retval;

                    match(input, Token.UP, null); if (state.failed) return retval;
                    IDENTIFIER17=(ManchesterOWLSyntaxTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_incompleteExpression2061); if (state.failed) return retval;

                    match(input, Token.UP, null); if (state.failed) return retval;
                    if ( state.backtracking==1 ) {
                        
                        		Type type = e.type;
                        		retval.completions = type==null? Collections.<String>emptyList(): AutoCompleteStrings.getIncompleteExpressionCompletions((IDENTIFIER17!=null?IDENTIFIER17.getText():null), type);

                        
                    }

                    }
                    break;

            }
            if ( state.backtracking==1 ) {
               
                      if(retval.completions!=null){
                        ((ManchesterOWLSyntaxTree)retval.start).setCompletions(retval.completions);
                      }
                    
            }
        }

          catch(RecognitionException exception){
           
          }
          
          catch(RewriteEmptyStreamException exception){
          
          }
        finally {
        }
        return retval;
    }
    // $ANTLR end "incompleteExpression"

    public static class incompleteConjunction_return extends TreeRuleReturnScope {
        public List<String> completions;
    };

    // $ANTLR start "incompleteConjunction"
    // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxAutoComplete.g:631:1: incompleteConjunction returns [List<String> completions] : ^( INCOMPLETE_CONJUNCTION (e= incompleteUnary )? ) ;
    public final ManchesterOWLSyntaxAutoComplete.incompleteConjunction_return incompleteConjunction() throws RecognitionException {
        ManchesterOWLSyntaxAutoComplete.incompleteConjunction_return retval = new ManchesterOWLSyntaxAutoComplete.incompleteConjunction_return();
        retval.start = input.LT(1);

        ManchesterOWLSyntaxAutoComplete.incompleteUnary_return e = null;


        try {
            // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxAutoComplete.g:638:1: ( ^( INCOMPLETE_CONJUNCTION (e= incompleteUnary )? ) )
            // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxAutoComplete.g:639:5: ^( INCOMPLETE_CONJUNCTION (e= incompleteUnary )? )
            {
            match(input,INCOMPLETE_CONJUNCTION,FOLLOW_INCOMPLETE_CONJUNCTION_in_incompleteConjunction2099); if (state.failed) return retval;

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); if (state.failed) return retval;
                // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxAutoComplete.g:639:33: (e= incompleteUnary )?
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( ((LA22_0>=INCOMPLETE_NEGATED_EXPRESSION && LA22_0<=INCOMPLETE_VALUE_RESTRICTION)) ) {
                    alt22=1;
                }
                switch (alt22) {
                    case 1 :
                        // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxAutoComplete.g:639:33: e= incompleteUnary
                        {
                        pushFollow(FOLLOW_incompleteUnary_in_incompleteConjunction2106);
                        e=incompleteUnary();

                        state._fsp--;
                        if (state.failed) return retval;

                        }
                        break;

                }


                match(input, Token.UP, null); if (state.failed) return retval;
            }
            if ( state.backtracking==1 ) {

                  	if(e!=null){
                    	retval.completions = e.completions;
                    }else{
                    	retval.completions = new ArrayList<String>(symtab.getOWLClassCompletions());
                    } 
                  
            }

            }

            if ( state.backtracking==1 ) {
               
                      if(retval.completions!=null){
                        ((ManchesterOWLSyntaxTree)retval.start).setCompletions(retval.completions);
                      }
                    
            }
        }

          catch(RecognitionException exception){
           
          }
          
          catch(RewriteEmptyStreamException exception){
          
          }
        finally {
        }
        return retval;
    }
    // $ANTLR end "incompleteConjunction"

    public static class incompleteUnary_return extends TreeRuleReturnScope {
        public List<String> completions;
    };

    // $ANTLR start "incompleteUnary"
    // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxAutoComplete.g:649:1: incompleteUnary returns [List<String> completions] : ( ^( INCOMPLETE_NEGATED_EXPRESSION ( . )? ) | incompleteQualifiedRestriction );
    public final ManchesterOWLSyntaxAutoComplete.incompleteUnary_return incompleteUnary() throws RecognitionException {
        ManchesterOWLSyntaxAutoComplete.incompleteUnary_return retval = new ManchesterOWLSyntaxAutoComplete.incompleteUnary_return();
        retval.start = input.LT(1);

        ManchesterOWLSyntaxAutoComplete.incompleteQualifiedRestriction_return incompleteQualifiedRestriction18 = null;


        try {
            // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxAutoComplete.g:656:1: ( ^( INCOMPLETE_NEGATED_EXPRESSION ( . )? ) | incompleteQualifiedRestriction )
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==INCOMPLETE_NEGATED_EXPRESSION) ) {
                alt24=1;
            }
            else if ( ((LA24_0>=INCOMPLETE_SOME_RESTRICTION && LA24_0<=INCOMPLETE_VALUE_RESTRICTION)) ) {
                alt24=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 24, 0, input);

                throw nvae;
            }
            switch (alt24) {
                case 1 :
                    // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxAutoComplete.g:657:5: ^( INCOMPLETE_NEGATED_EXPRESSION ( . )? )
                    {
                    match(input,INCOMPLETE_NEGATED_EXPRESSION,FOLLOW_INCOMPLETE_NEGATED_EXPRESSION_in_incompleteUnary2151); if (state.failed) return retval;

                    if ( input.LA(1)==Token.DOWN ) {
                        match(input, Token.DOWN, null); if (state.failed) return retval;
                        // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxAutoComplete.g:657:37: ( . )?
                        int alt23=2;
                        int LA23_0 = input.LA(1);

                        if ( ((LA23_0>=COMPOSITION && LA23_0<=INCOMPLETE_EXPRESSION)) ) {
                            alt23=1;
                        }
                        switch (alt23) {
                            case 1 :
                                // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxAutoComplete.g:657:37: .
                                {
                                matchAny(input); if (state.failed) return retval;

                                }
                                break;

                        }


                        match(input, Token.UP, null); if (state.failed) return retval;
                    }
                    if ( state.backtracking==1 ) {

                            // class expression completions
                            retval.completions = new ArrayList<String>(symtab.getOWLClassCompletions());
                          
                    }

                    }
                    break;
                case 2 :
                    // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxAutoComplete.g:661:7: incompleteQualifiedRestriction
                    {
                    pushFollow(FOLLOW_incompleteQualifiedRestriction_in_incompleteUnary2182);
                    incompleteQualifiedRestriction18=incompleteQualifiedRestriction();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==1 ) {

                            retval.completions = (incompleteQualifiedRestriction18!=null?incompleteQualifiedRestriction18.completions:null);
                          
                    }

                    }
                    break;

            }
            if ( state.backtracking==1 ) {
               
                      if(retval.completions!=null){
                        ((ManchesterOWLSyntaxTree)retval.start).setCompletions(retval.completions);
                      }
                    
            }
        }

          catch(RecognitionException exception){
           
          }
          
          catch(RewriteEmptyStreamException exception){
          
          }
        finally {
        }
        return retval;
    }
    // $ANTLR end "incompleteUnary"

    public static class incompleteQualifiedRestriction_return extends TreeRuleReturnScope {
        public List<String> completions;
    };

    // $ANTLR start "incompleteQualifiedRestriction"
    // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxAutoComplete.g:667:1: incompleteQualifiedRestriction returns [List<String> completions] : ( ^( INCOMPLETE_SOME_RESTRICTION propertyExpression ) | ^( INCOMPLETE_ALL_RESTRICTION propertyExpression ) | incompleteCardinalityRestriction | incompleteOneOf | incompleteValueRestriction );
    public final ManchesterOWLSyntaxAutoComplete.incompleteQualifiedRestriction_return incompleteQualifiedRestriction() throws RecognitionException {
        ManchesterOWLSyntaxAutoComplete.incompleteQualifiedRestriction_return retval = new ManchesterOWLSyntaxAutoComplete.incompleteQualifiedRestriction_return();
        retval.start = input.LT(1);

        ManchesterOWLSyntaxAutoComplete.incompleteCardinalityRestriction_return incompleteCardinalityRestriction19 = null;

        ManchesterOWLSyntaxAutoComplete.incompleteOneOf_return incompleteOneOf20 = null;

        ManchesterOWLSyntaxAutoComplete.incompleteValueRestriction_return incompleteValueRestriction21 = null;


        try {
            // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxAutoComplete.g:674:1: ( ^( INCOMPLETE_SOME_RESTRICTION propertyExpression ) | ^( INCOMPLETE_ALL_RESTRICTION propertyExpression ) | incompleteCardinalityRestriction | incompleteOneOf | incompleteValueRestriction )
            int alt25=5;
            switch ( input.LA(1) ) {
            case INCOMPLETE_SOME_RESTRICTION:
                {
                alt25=1;
                }
                break;
            case INCOMPLETE_ALL_RESTRICTION:
                {
                alt25=2;
                }
                break;
            case INCOMPLETE_CARDINALITY_RESTRICTION:
                {
                alt25=3;
                }
                break;
            case INCOMPLETE_ONE_OF:
                {
                alt25=4;
                }
                break;
            case INCOMPLETE_VALUE_RESTRICTION:
                {
                alt25=5;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 25, 0, input);

                throw nvae;
            }

            switch (alt25) {
                case 1 :
                    // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxAutoComplete.g:675:11: ^( INCOMPLETE_SOME_RESTRICTION propertyExpression )
                    {
                    match(input,INCOMPLETE_SOME_RESTRICTION,FOLLOW_INCOMPLETE_SOME_RESTRICTION_in_incompleteQualifiedRestriction2240); if (state.failed) return retval;

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    pushFollow(FOLLOW_propertyExpression_in_incompleteQualifiedRestriction2242);
                    propertyExpression();

                    state._fsp--;
                    if (state.failed) return retval;

                    match(input, Token.UP, null); if (state.failed) return retval;
                    if ( state.backtracking==1 ) {

                                // class expression completions
                                retval.completions = new ArrayList<String>(symtab.getOWLClassCompletions());
                              
                    }

                    }
                    break;
                case 2 :
                    // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxAutoComplete.g:680:11: ^( INCOMPLETE_ALL_RESTRICTION propertyExpression )
                    {
                    match(input,INCOMPLETE_ALL_RESTRICTION,FOLLOW_INCOMPLETE_ALL_RESTRICTION_in_incompleteQualifiedRestriction2285); if (state.failed) return retval;

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    pushFollow(FOLLOW_propertyExpression_in_incompleteQualifiedRestriction2287);
                    propertyExpression();

                    state._fsp--;
                    if (state.failed) return retval;

                    match(input, Token.UP, null); if (state.failed) return retval;
                    if ( state.backtracking==1 ) {

                                // class expression completions
                                retval.completions = new ArrayList<String>(symtab.getOWLClassCompletions());
                              
                    }

                    }
                    break;
                case 3 :
                    // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxAutoComplete.g:685:11: incompleteCardinalityRestriction
                    {
                    pushFollow(FOLLOW_incompleteCardinalityRestriction_in_incompleteQualifiedRestriction2310);
                    incompleteCardinalityRestriction19=incompleteCardinalityRestriction();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==1 ) {

                                retval.completions = (incompleteCardinalityRestriction19!=null?incompleteCardinalityRestriction19.completions:null);
                              
                    }

                    }
                    break;
                case 4 :
                    // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxAutoComplete.g:689:11: incompleteOneOf
                    {
                    pushFollow(FOLLOW_incompleteOneOf_in_incompleteQualifiedRestriction2332);
                    incompleteOneOf20=incompleteOneOf();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==1 ) {

                                retval.completions = (incompleteOneOf20!=null?incompleteOneOf20.completions:null);
                              
                    }

                    }
                    break;
                case 5 :
                    // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxAutoComplete.g:693:11: incompleteValueRestriction
                    {
                    pushFollow(FOLLOW_incompleteValueRestriction_in_incompleteQualifiedRestriction2354);
                    incompleteValueRestriction21=incompleteValueRestriction();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==1 ) {

                                retval.completions = (incompleteValueRestriction21!=null?incompleteValueRestriction21.completions:null);
                              
                    }

                    }
                    break;

            }
            if ( state.backtracking==1 ) {
               
                      if(retval.completions!=null){
                        ((ManchesterOWLSyntaxTree)retval.start).setCompletions(retval.completions);
                      }
                    
            }
        }

          catch(RecognitionException exception){
           
          }
          
          catch(RewriteEmptyStreamException exception){
          
          }
        finally {
        }
        return retval;
    }
    // $ANTLR end "incompleteQualifiedRestriction"

    public static class incompleteCardinalityRestriction_return extends TreeRuleReturnScope {
        public List<String> completions;
    };

    // $ANTLR start "incompleteCardinalityRestriction"
    // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxAutoComplete.g:700:1: incompleteCardinalityRestriction returns [List<String> completions] : ^( INCOMPLETE_CARDINALITY_RESTRICTION . INTEGER propertyExpression ) ;
    public final ManchesterOWLSyntaxAutoComplete.incompleteCardinalityRestriction_return incompleteCardinalityRestriction() throws RecognitionException {
        ManchesterOWLSyntaxAutoComplete.incompleteCardinalityRestriction_return retval = new ManchesterOWLSyntaxAutoComplete.incompleteCardinalityRestriction_return();
        retval.start = input.LT(1);

        try {
            // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxAutoComplete.g:707:1: ( ^( INCOMPLETE_CARDINALITY_RESTRICTION . INTEGER propertyExpression ) )
            // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxAutoComplete.g:708:9: ^( INCOMPLETE_CARDINALITY_RESTRICTION . INTEGER propertyExpression )
            {
            match(input,INCOMPLETE_CARDINALITY_RESTRICTION,FOLLOW_INCOMPLETE_CARDINALITY_RESTRICTION_in_incompleteCardinalityRestriction2415); if (state.failed) return retval;

            match(input, Token.DOWN, null); if (state.failed) return retval;
            matchAny(input); if (state.failed) return retval;
            match(input,INTEGER,FOLLOW_INTEGER_in_incompleteCardinalityRestriction2420); if (state.failed) return retval;
            pushFollow(FOLLOW_propertyExpression_in_incompleteCardinalityRestriction2422);
            propertyExpression();

            state._fsp--;
            if (state.failed) return retval;

            match(input, Token.UP, null); if (state.failed) return retval;
            if ( state.backtracking==1 ) {

                        // class expression completions
                        retval.completions = new ArrayList<String>(symtab.getOWLClassCompletions());
                      
            }

            }

            if ( state.backtracking==1 ) {
               
                      if(retval.completions!=null){
                        ((ManchesterOWLSyntaxTree)retval.start).setCompletions(retval.completions);
                      }
                    
            }
        }

          catch(RecognitionException exception){
           
          }
          
          catch(RewriteEmptyStreamException exception){
          
          }
        finally {
        }
        return retval;
    }
    // $ANTLR end "incompleteCardinalityRestriction"

    public static class incompleteOneOf_return extends TreeRuleReturnScope {
        public List<String> completions;
    };

    // $ANTLR start "incompleteOneOf"
    // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxAutoComplete.g:716:1: incompleteOneOf returns [List<String> completions] : ^( INCOMPLETE_ONE_OF ( IDENTIFIER )+ ) ;
    public final ManchesterOWLSyntaxAutoComplete.incompleteOneOf_return incompleteOneOf() throws RecognitionException {
        ManchesterOWLSyntaxAutoComplete.incompleteOneOf_return retval = new ManchesterOWLSyntaxAutoComplete.incompleteOneOf_return();
        retval.start = input.LT(1);

        try {
            // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxAutoComplete.g:723:1: ( ^( INCOMPLETE_ONE_OF ( IDENTIFIER )+ ) )
            // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxAutoComplete.g:724:5: ^( INCOMPLETE_ONE_OF ( IDENTIFIER )+ )
            {
            match(input,INCOMPLETE_ONE_OF,FOLLOW_INCOMPLETE_ONE_OF_in_incompleteOneOf2468); if (state.failed) return retval;

            match(input, Token.DOWN, null); if (state.failed) return retval;
            // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxAutoComplete.g:724:25: ( IDENTIFIER )+
            int cnt26=0;
            loop26:
            do {
                int alt26=2;
                int LA26_0 = input.LA(1);

                if ( (LA26_0==IDENTIFIER) ) {
                    alt26=1;
                }


                switch (alt26) {
            	case 1 :
            	    // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxAutoComplete.g:724:25: IDENTIFIER
            	    {
            	    match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_incompleteOneOf2470); if (state.failed) return retval;

            	    }
            	    break;

            	default :
            	    if ( cnt26 >= 1 ) break loop26;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(26, input);
                        throw eee;
                }
                cnt26++;
            } while (true);


            match(input, Token.UP, null); if (state.failed) return retval;
            if ( state.backtracking==1 ) {

                    // individual expression completions
                    retval.completions = new ArrayList<String>(symtab.getOWLIndividualCompletions());  
                  
            }

            }

            if ( state.backtracking==1 ) {
               
                      if(retval.completions!=null){
                        ((ManchesterOWLSyntaxTree)retval.start).setCompletions(retval.completions);
                      }
                    
            }
        }

          catch(RecognitionException exception){
           
          }
          
          catch(RewriteEmptyStreamException exception){
          
          }
        finally {
        }
        return retval;
    }
    // $ANTLR end "incompleteOneOf"

    public static class incompleteValueRestriction_return extends TreeRuleReturnScope {
        public List<String> completions;
    };

    // $ANTLR start "incompleteValueRestriction"
    // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxAutoComplete.g:731:2: incompleteValueRestriction returns [List<String> completions] : ^( INCOMPLETE_VALUE_RESTRICTION p= propertyExpression ) ;
    public final ManchesterOWLSyntaxAutoComplete.incompleteValueRestriction_return incompleteValueRestriction() throws RecognitionException {
        ManchesterOWLSyntaxAutoComplete.incompleteValueRestriction_return retval = new ManchesterOWLSyntaxAutoComplete.incompleteValueRestriction_return();
        retval.start = input.LT(1);

        ManchesterOWLSyntaxAutoComplete.propertyExpression_return p = null;


        try {
            // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxAutoComplete.g:738:1: ( ^( INCOMPLETE_VALUE_RESTRICTION p= propertyExpression ) )
            // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxAutoComplete.g:739:7: ^( INCOMPLETE_VALUE_RESTRICTION p= propertyExpression )
            {
            match(input,INCOMPLETE_VALUE_RESTRICTION,FOLLOW_INCOMPLETE_VALUE_RESTRICTION_in_incompleteValueRestriction2518); if (state.failed) return retval;

            match(input, Token.DOWN, null); if (state.failed) return retval;
            pushFollow(FOLLOW_propertyExpression_in_incompleteValueRestriction2524);
            p=propertyExpression();

            state._fsp--;
            if (state.failed) return retval;

            match(input, Token.UP, null); if (state.failed) return retval;
            if ( state.backtracking==1 ) {

                      // individual expression completions
                      Type type = p.type;
                      if(OWLType.isObjectPropertyExpression(type)){
                      	retval.completions = new ArrayList<String>(symtab.getOWLIndividualCompletions());
                      }
                    
            }

            }

            if ( state.backtracking==1 ) {
               
                      if(retval.completions!=null){
                        ((ManchesterOWLSyntaxTree)retval.start).setCompletions(retval.completions);
                      }
                    
            }
        }

          catch(RecognitionException exception){
           
          }
          
          catch(RewriteEmptyStreamException exception){
          
          }
        finally {
        }
        return retval;
    }
    // $ANTLR end "incompleteValueRestriction"

    // Delegated rules


    protected DFA2 dfa2 = new DFA2(this);
    protected DFA3 dfa3 = new DFA3(this);
    protected DFA6 dfa6 = new DFA6(this);
    protected DFA18 dfa18 = new DFA18(this);
    static final String DFA2_eotS =
        "\25\uffff";
    static final String DFA2_eofS =
        "\25\uffff";
    static final String DFA2_minS =
        "\1\31\13\uffff\1\2\1\uffff\1\35\6\uffff";
    static final String DFA2_maxS =
        "\1\103\13\uffff\1\2\1\uffff\1\43\6\uffff";
    static final String DFA2_acceptS =
        "\1\uffff\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\13\1\uffff"+
        "\1\22\1\uffff\1\14\1\15\1\16\1\17\1\20\1\21";
    static final String DFA2_specialS =
        "\25\uffff}>";
    static final String[] DFA2_transitionS = {
            "\1\3\1\uffff\1\10\1\11\23\uffff\1\1\1\2\1\4\1\5\1\12\1\13\1"+
            "\14\4\uffff\1\15\6\uffff\1\7\1\6",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\16",
            "",
            "\1\17\1\23\1\uffff\1\22\1\21\1\24\1\20",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA2_eot = DFA.unpackEncodedString(DFA2_eotS);
    static final short[] DFA2_eof = DFA.unpackEncodedString(DFA2_eofS);
    static final char[] DFA2_min = DFA.unpackEncodedStringToUnsignedChars(DFA2_minS);
    static final char[] DFA2_max = DFA.unpackEncodedStringToUnsignedChars(DFA2_maxS);
    static final short[] DFA2_accept = DFA.unpackEncodedString(DFA2_acceptS);
    static final short[] DFA2_special = DFA.unpackEncodedString(DFA2_specialS);
    static final short[][] DFA2_transition;

    static {
        int numStates = DFA2_transitionS.length;
        DFA2_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA2_transition[i] = DFA.unpackEncodedString(DFA2_transitionS[i]);
        }
    }

    class DFA2 extends DFA {

        public DFA2(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 2;
            this.eot = DFA2_eot;
            this.eof = DFA2_eof;
            this.min = DFA2_min;
            this.max = DFA2_max;
            this.accept = DFA2_accept;
            this.special = DFA2_special;
            this.transition = DFA2_transition;
        }
        public String getDescription() {
            return "101:1: axiom returns [List<String> completions] : ( ^( SUB_CLASS_AXIOM ^( EXPRESSION subClass= expression ) ^( EXPRESSION superClass= expression ) ) | ^( EQUIVALENT_TO_AXIOM ^( EXPRESSION lhs= expression ) ^( EXPRESSION rhs= expression ) ) | ^( INVERSE_OF ^( EXPRESSION p= IDENTIFIER ) ^( EXPRESSION anotherProperty= IDENTIFIER ) ) | ^( DISJOINT_WITH_AXIOM ^( EXPRESSION lhs= expression ) ^( EXPRESSION rhs= expression ) ) | ^( SUB_PROPERTY_AXIOM ^( EXPRESSION subProperty= expression ) ^( EXPRESSION superProperty= unary ) ) | ^( ROLE_ASSERTION ^( EXPRESSION subject= IDENTIFIER ) ^( EXPRESSION predicate= propertyExpression ) ^( EXPRESSION object= unary ) ) | ^( TYPE_ASSERTION ^( EXPRESSION description= expression ) ^( EXPRESSION subject= IDENTIFIER ) ) | ^( DOMAIN ^( EXPRESSION p= IDENTIFIER ) ^( EXPRESSION domain= expression ) ) | ^( RANGE ^( EXPRESSION p= IDENTIFIER ) ^( EXPRESSION range= expression ) ) | ^( SAME_AS_AXIOM ^( EXPRESSION anIndividual= IDENTIFIER ) ^( EXPRESSION anotherIndividual= IDENTIFIER ) ) | ^( DIFFERENT_FROM_AXIOM ^( EXPRESSION anIndividual= IDENTIFIER ) ^( EXPRESSION anotherIndividual= IDENTIFIER ) ) | ^( UNARY_AXIOM FUNCTIONAL ^( EXPRESSION p= IDENTIFIER ) ) | ^( UNARY_AXIOM INVERSE_FUNCTIONAL ^( EXPRESSION p= IDENTIFIER ) ) | ^( UNARY_AXIOM IRREFLEXIVE ^( EXPRESSION p= IDENTIFIER ) ) | ^( UNARY_AXIOM REFLEXIVE ^( EXPRESSION p= IDENTIFIER ) ) | ^( UNARY_AXIOM SYMMETRIC ^( EXPRESSION p= IDENTIFIER ) ) | ^( UNARY_AXIOM TRANSITIVE ^( EXPRESSION p= IDENTIFIER ) ) | ^( NEGATED_ASSERTION a= axiom ) );";
        }
    }
    static final String DFA3_eotS =
        "\u00b1\uffff";
    static final String DFA3_eofS =
        "\u00b1\uffff";
    static final String DFA3_minS =
        "\1\4\12\2\1\uffff\1\4\1\uffff\7\4\4\2\1\3\6\2\1\3\2\2\1\3\1\2\1"+
        "\3\1\2\5\3\6\2\1\3\13\2\1\3\3\2\1\3\6\2\1\3\5\2\1\3\6\2\1\3\2\2"+
        "\5\3\6\2\1\3\1\2\6\3\6\2\1\3\1\2\1\3\6\2\1\3\1\2\1\3\6\2\1\3\1\2"+
        "\2\3\3\2\1\3\6\2\1\3\5\2\1\3\6\2\1\3\2\2\2\3\3\2\1\3\6\2\1\3\2\2";
    static final String DFA3_maxS =
        "\13\136\1\uffff\1\136\1\uffff\u00a3\136";
    static final String DFA3_acceptS =
        "\13\uffff\1\1\1\uffff\1\2\u00a3\uffff";
    static final String DFA3_specialS =
        "\u00b1\uffff}>";
    static final String[] DFA3_transitionS = {
            "\50\13\1\2\1\11\12\13\1\1\1\13\1\3\2\13\1\4\1\5\1\10\1\6\1\7"+
            "\4\13\1\12\30\13",
            "\1\14\1\uffff\133\13",
            "\1\13\1\15\133\13",
            "\1\16\1\uffff\133\13",
            "\1\17\1\uffff\133\13",
            "\1\20\1\uffff\133\13",
            "\1\21\1\uffff\133\13",
            "\1\22\1\uffff\133\13",
            "\1\23\1\uffff\133\13",
            "\1\13\1\15\133\13",
            "\1\24\1\uffff\133\13",
            "",
            "\133\25",
            "",
            "\50\13\1\31\1\40\11\13\1\26\1\30\1\27\1\32\2\13\1\33\1\34\1"+
            "\37\1\35\1\36\2\13\1\42\1\13\1\41\30\13",
            "\50\13\1\43\27\13\1\44\32\13",
            "\50\13\1\45\27\13\1\46\32\13",
            "\13\13\1\47\1\50\1\51\115\13",
            "\50\13\1\52\62\13",
            "\50\13\1\53\1\62\14\13\1\54\2\13\1\55\1\56\1\61\1\57\1\60\4"+
            "\13\1\63\30\13",
            "\133\64",
            "\1\15\1\13\50\25\1\65\1\74\14\25\1\66\2\25\1\67\1\70\1\73\1"+
            "\71\1\72\4\25\1\75\30\25",
            "\1\15\134\13",
            "\1\15\134\13",
            "\1\15\134\13",
            "\1\76\133\13",
            "\1\15\134\13",
            "\1\15\134\13",
            "\1\15\134\13",
            "\1\15\134\13",
            "\1\15\134\13",
            "\1\15\134\13",
            "\1\76\133\13",
            "\1\15\134\13",
            "\1\15\134\13",
            "\51\13\1\102\1\111\11\13\1\77\1\101\1\100\1\103\2\13\1\104"+
            "\1\105\1\110\1\106\1\107\2\13\1\113\1\13\1\112\30\13",
            "\1\15\134\13",
            "\51\13\1\117\1\126\11\13\1\114\1\116\1\115\1\120\2\13\1\121"+
            "\1\122\1\125\1\123\1\124\2\13\1\130\1\13\1\127\30\13",
            "\1\15\134\13",
            "\47\13\1\131\64\13",
            "\47\13\1\132\64\13",
            "\47\13\1\133\64\13",
            "\1\134\50\13\1\52\62\13",
            "\51\13\1\135\1\144\14\13\1\136\2\13\1\137\1\140\1\143\1\141"+
            "\1\142\4\13\1\145\30\13",
            "\1\15\134\13",
            "\1\15\134\13",
            "\1\15\134\13",
            "\1\15\134\13",
            "\1\15\134\13",
            "\1\15\134\13",
            "\51\13\1\135\1\144\14\13\1\136\2\13\1\137\1\140\1\143\1\141"+
            "\1\142\4\13\1\145\30\13",
            "\1\15\134\13",
            "\1\15\1\146\50\13\1\147\62\13",
            "\1\15\1\150\50\25\1\65\1\74\14\25\1\66\2\25\1\67\1\70\1\73"+
            "\1\71\1\72\4\25\1\75\30\25",
            "\1\15\1\13\50\25\1\65\1\74\14\25\1\66\2\25\1\67\1\70\1\73\1"+
            "\71\1\72\4\25\1\75\30\25",
            "\1\15\1\13\50\25\1\65\1\74\14\25\1\66\2\25\1\67\1\70\1\73\1"+
            "\71\1\72\4\25\1\75\30\25",
            "\1\15\1\13\50\25\1\65\1\74\14\25\1\66\2\25\1\67\1\70\1\73\1"+
            "\71\1\72\4\25\1\75\30\25",
            "\1\15\1\13\50\25\1\65\1\74\14\25\1\66\2\25\1\67\1\70\1\73\1"+
            "\71\1\72\4\25\1\75\30\25",
            "\1\15\1\13\50\25\1\65\1\74\14\25\1\66\2\25\1\67\1\70\1\73\1"+
            "\71\1\72\4\25\1\75\30\25",
            "\1\15\1\13\50\25\1\65\1\74\14\25\1\66\2\25\1\67\1\70\1\73\1"+
            "\71\1\72\4\25\1\75\30\25",
            "\1\15\1\150\50\25\1\65\1\74\14\25\1\66\2\25\1\67\1\70\1\73"+
            "\1\71\1\72\4\25\1\75\30\25",
            "\1\15\1\13\50\25\1\65\1\74\14\25\1\66\2\25\1\67\1\70\1\73\1"+
            "\71\1\72\4\25\1\75\30\25",
            "\1\15\133\13",
            "\1\15\134\13",
            "\1\15\134\13",
            "\1\15\134\13",
            "\1\151\133\13",
            "\1\15\134\13",
            "\1\15\134\13",
            "\1\15\134\13",
            "\1\15\134\13",
            "\1\15\134\13",
            "\1\15\134\13",
            "\1\151\133\13",
            "\1\15\134\13",
            "\1\15\134\13",
            "\1\15\134\13",
            "\1\15\134\13",
            "\1\15\134\13",
            "\1\152\133\13",
            "\1\15\134\13",
            "\1\15\134\13",
            "\1\15\134\13",
            "\1\15\134\13",
            "\1\15\134\13",
            "\1\15\134\13",
            "\1\152\133\13",
            "\1\15\134\13",
            "\1\15\134\13",
            "\51\13\1\153\1\162\14\13\1\154\2\13\1\155\1\156\1\161\1\157"+
            "\1\160\4\13\1\163\30\13",
            "\51\13\1\164\1\173\14\13\1\165\2\13\1\166\1\167\1\172\1\170"+
            "\1\171\4\13\1\174\30\13",
            "\51\13\1\175\1\u0084\14\13\1\176\2\13\1\177\1\u0080\1\u0083"+
            "\1\u0081\1\u0082\4\13\1\u0085\30\13",
            "\1\15\133\13",
            "\1\u0086\133\13",
            "\1\15\134\13",
            "\1\15\134\13",
            "\1\15\134\13",
            "\1\15\134\13",
            "\1\15\134\13",
            "\1\15\134\13",
            "\1\u0086\133\13",
            "\1\15\134\13",
            "\1\15\133\13",
            "\1\146\133\13",
            "\1\15\133\13",
            "\1\15\133\13",
            "\1\15\133\13",
            "\1\u0087\50\13\1\u008b\1\u0092\11\13\1\u0088\1\u008a\1\u0089"+
            "\1\u008c\2\13\1\u008d\1\u008e\1\u0091\1\u008f\1\u0090\2\13\1"+
            "\u0094\1\13\1\u0093\30\13",
            "\1\15\134\13",
            "\1\15\134\13",
            "\1\15\134\13",
            "\1\15\134\13",
            "\1\15\134\13",
            "\1\15\134\13",
            "\1\u0087\50\13\1\u008b\1\u0092\11\13\1\u0088\1\u008a\1\u0089"+
            "\1\u008c\2\13\1\u008d\1\u008e\1\u0091\1\u008f\1\u0090\2\13\1"+
            "\u0094\1\13\1\u0093\30\13",
            "\1\15\134\13",
            "\1\u00a2\50\13\1\u0098\1\u009f\11\13\1\u0095\1\u0097\1\u0096"+
            "\1\u0099\2\13\1\u009a\1\u009b\1\u009e\1\u009c\1\u009d\2\13\1"+
            "\u00a1\1\13\1\u00a0\30\13",
            "\1\15\134\13",
            "\1\15\134\13",
            "\1\15\134\13",
            "\1\15\134\13",
            "\1\15\134\13",
            "\1\15\134\13",
            "\1\u00a2\50\13\1\u0098\1\u009f\11\13\1\u0095\1\u0097\1\u0096"+
            "\1\u0099\2\13\1\u009a\1\u009b\1\u009e\1\u009c\1\u009d\2\13\1"+
            "\u00a1\1\13\1\u00a0\30\13",
            "\1\15\134\13",
            "\1\u00a3\50\13\1\u00a7\1\u00ae\11\13\1\u00a4\1\u00a6\1\u00a5"+
            "\1\u00a8\2\13\1\u00a9\1\u00aa\1\u00ad\1\u00ab\1\u00ac\2\13\1"+
            "\u00b0\1\13\1\u00af\30\13",
            "\1\15\134\13",
            "\1\15\134\13",
            "\1\15\134\13",
            "\1\15\134\13",
            "\1\15\134\13",
            "\1\15\134\13",
            "\1\u00a3\50\13\1\u00a7\1\u00ae\11\13\1\u00a4\1\u00a6\1\u00a5"+
            "\1\u00a8\2\13\1\u00a9\1\u00aa\1\u00ad\1\u00ab\1\u00ac\2\13\1"+
            "\u00b0\1\13\1\u00af\30\13",
            "\1\15\134\13",
            "\1\15\133\13",
            "\1\15\133\13",
            "\1\15\134\13",
            "\1\15\134\13",
            "\1\15\134\13",
            "\1\u0087\133\13",
            "\1\15\134\13",
            "\1\15\134\13",
            "\1\15\134\13",
            "\1\15\134\13",
            "\1\15\134\13",
            "\1\15\134\13",
            "\1\u0087\133\13",
            "\1\15\134\13",
            "\1\15\134\13",
            "\1\15\134\13",
            "\1\15\134\13",
            "\1\15\134\13",
            "\1\u00a2\133\13",
            "\1\15\134\13",
            "\1\15\134\13",
            "\1\15\134\13",
            "\1\15\134\13",
            "\1\15\134\13",
            "\1\15\134\13",
            "\1\u00a2\133\13",
            "\1\15\134\13",
            "\1\15\134\13",
            "\1\15\133\13",
            "\1\15\133\13",
            "\1\15\134\13",
            "\1\15\134\13",
            "\1\15\134\13",
            "\1\u00a3\133\13",
            "\1\15\134\13",
            "\1\15\134\13",
            "\1\15\134\13",
            "\1\15\134\13",
            "\1\15\134\13",
            "\1\15\134\13",
            "\1\u00a3\133\13",
            "\1\15\134\13",
            "\1\15\134\13"
    };

    static final short[] DFA3_eot = DFA.unpackEncodedString(DFA3_eotS);
    static final short[] DFA3_eof = DFA.unpackEncodedString(DFA3_eofS);
    static final char[] DFA3_min = DFA.unpackEncodedStringToUnsignedChars(DFA3_minS);
    static final char[] DFA3_max = DFA.unpackEncodedStringToUnsignedChars(DFA3_maxS);
    static final short[] DFA3_accept = DFA.unpackEncodedString(DFA3_acceptS);
    static final short[] DFA3_special = DFA.unpackEncodedString(DFA3_specialS);
    static final short[][] DFA3_transition;

    static {
        int numStates = DFA3_transitionS.length;
        DFA3_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA3_transition[i] = DFA.unpackEncodedString(DFA3_transitionS[i]);
        }
    }

    class DFA3 extends DFA {

        public DFA3(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 3;
            this.eot = DFA3_eot;
            this.eof = DFA3_eof;
            this.min = DFA3_min;
            this.max = DFA3_max;
            this.accept = DFA3_accept;
            this.special = DFA3_special;
            this.transition = DFA3_transition;
        }
        public String getDescription() {
            return "()+ loopback of 263:23: (head+= . )+";
        }
    }
    static final String DFA6_eotS =
        "\u00a4\uffff";
    static final String DFA6_eofS =
        "\u00a4\uffff";
    static final String DFA6_minS =
        "\1\4\11\2\2\uffff\7\4\3\2\1\3\6\2\1\3\2\2\1\3\1\2\1\3\1\2\5\3\6"+
        "\2\1\3\2\2\1\3\3\2\1\3\6\2\1\3\5\2\1\3\6\2\1\3\2\2\5\3\6\2\1\3\1"+
        "\2\5\3\6\2\1\3\1\2\1\3\6\2\1\3\1\2\1\3\6\2\1\3\1\2\1\3\3\2\1\3\6"+
        "\2\1\3\2\2\1\3\3\2\1\3\6\2\1\3\2\2\1\3\3\2\1\3\6\2\1\3\2\2\1\3";
    static final String DFA6_maxS =
        "\12\136\2\uffff\u0098\136";
    static final String DFA6_acceptS =
        "\12\uffff\1\1\1\2\u0098\uffff";
    static final String DFA6_specialS =
        "\u00a4\uffff}>";
    static final String[] DFA6_transitionS = {
            "\50\12\1\1\1\10\14\12\1\2\2\12\1\3\1\4\1\7\1\5\1\6\4\12\1\11"+
            "\30\12",
            "\1\12\1\13\133\12",
            "\1\14\1\uffff\133\12",
            "\1\15\1\uffff\133\12",
            "\1\16\1\uffff\133\12",
            "\1\17\1\uffff\133\12",
            "\1\20\1\uffff\133\12",
            "\1\21\1\uffff\133\12",
            "\1\12\1\13\133\12",
            "\1\22\1\uffff\133\12",
            "",
            "",
            "\50\12\1\26\1\35\11\12\1\23\1\25\1\24\1\27\2\12\1\30\1\31\1"+
            "\34\1\32\1\33\2\12\1\37\1\12\1\36\30\12",
            "\50\12\1\40\27\12\1\41\32\12",
            "\50\12\1\42\27\12\1\43\32\12",
            "\13\12\1\44\1\45\1\46\115\12",
            "\50\12\1\47\62\12",
            "\50\12\1\50\1\57\14\12\1\51\2\12\1\52\1\53\1\56\1\54\1\55\4"+
            "\12\1\60\30\12",
            "\133\61",
            "\1\13\134\12",
            "\1\13\134\12",
            "\1\13\134\12",
            "\1\62\133\12",
            "\1\13\134\12",
            "\1\13\134\12",
            "\1\13\134\12",
            "\1\13\134\12",
            "\1\13\134\12",
            "\1\13\134\12",
            "\1\62\133\12",
            "\1\13\134\12",
            "\1\13\134\12",
            "\51\12\1\66\1\75\11\12\1\63\1\65\1\64\1\67\2\12\1\70\1\71\1"+
            "\74\1\72\1\73\2\12\1\77\1\12\1\76\30\12",
            "\1\13\134\12",
            "\51\12\1\103\1\112\11\12\1\100\1\102\1\101\1\104\2\12\1\105"+
            "\1\106\1\111\1\107\1\110\2\12\1\114\1\12\1\113\30\12",
            "\1\13\134\12",
            "\47\12\1\115\64\12",
            "\47\12\1\116\64\12",
            "\47\12\1\117\64\12",
            "\1\120\50\12\1\47\62\12",
            "\51\12\1\121\1\130\14\12\1\122\2\12\1\123\1\124\1\127\1\125"+
            "\1\126\4\12\1\131\30\12",
            "\1\13\134\12",
            "\1\13\134\12",
            "\1\13\134\12",
            "\1\13\134\12",
            "\1\13\134\12",
            "\1\13\134\12",
            "\51\12\1\121\1\130\14\12\1\122\2\12\1\123\1\124\1\127\1\125"+
            "\1\126\4\12\1\131\30\12",
            "\1\13\134\12",
            "\1\13\1\133\50\12\1\132\62\12",
            "\1\13\133\12",
            "\1\13\134\12",
            "\1\13\134\12",
            "\1\13\134\12",
            "\1\134\133\12",
            "\1\13\134\12",
            "\1\13\134\12",
            "\1\13\134\12",
            "\1\13\134\12",
            "\1\13\134\12",
            "\1\13\134\12",
            "\1\134\133\12",
            "\1\13\134\12",
            "\1\13\134\12",
            "\1\13\134\12",
            "\1\13\134\12",
            "\1\13\134\12",
            "\1\135\133\12",
            "\1\13\134\12",
            "\1\13\134\12",
            "\1\13\134\12",
            "\1\13\134\12",
            "\1\13\134\12",
            "\1\13\134\12",
            "\1\135\133\12",
            "\1\13\134\12",
            "\1\13\134\12",
            "\51\12\1\136\1\145\14\12\1\137\2\12\1\140\1\141\1\144\1\142"+
            "\1\143\4\12\1\146\30\12",
            "\51\12\1\147\1\156\14\12\1\150\2\12\1\151\1\152\1\155\1\153"+
            "\1\154\4\12\1\157\30\12",
            "\51\12\1\160\1\167\14\12\1\161\2\12\1\162\1\163\1\166\1\164"+
            "\1\165\4\12\1\170\30\12",
            "\1\13\133\12",
            "\1\171\133\12",
            "\1\13\134\12",
            "\1\13\134\12",
            "\1\13\134\12",
            "\1\13\134\12",
            "\1\13\134\12",
            "\1\13\134\12",
            "\1\171\133\12",
            "\1\13\134\12",
            "\1\133\133\12",
            "\1\13\133\12",
            "\1\13\133\12",
            "\1\13\133\12",
            "\1\u0087\50\12\1\175\1\u0084\11\12\1\172\1\174\1\173\1\176"+
            "\2\12\1\177\1\u0080\1\u0083\1\u0081\1\u0082\2\12\1\u0086\1\12"+
            "\1\u0085\30\12",
            "\1\13\134\12",
            "\1\13\134\12",
            "\1\13\134\12",
            "\1\13\134\12",
            "\1\13\134\12",
            "\1\13\134\12",
            "\1\u0087\50\12\1\175\1\u0084\11\12\1\172\1\174\1\173\1\176"+
            "\2\12\1\177\1\u0080\1\u0083\1\u0081\1\u0082\2\12\1\u0086\1\12"+
            "\1\u0085\30\12",
            "\1\13\134\12",
            "\1\u0095\50\12\1\u008b\1\u0092\11\12\1\u0088\1\u008a\1\u0089"+
            "\1\u008c\2\12\1\u008d\1\u008e\1\u0091\1\u008f\1\u0090\2\12\1"+
            "\u0094\1\12\1\u0093\30\12",
            "\1\13\134\12",
            "\1\13\134\12",
            "\1\13\134\12",
            "\1\13\134\12",
            "\1\13\134\12",
            "\1\13\134\12",
            "\1\u0095\50\12\1\u008b\1\u0092\11\12\1\u0088\1\u008a\1\u0089"+
            "\1\u008c\2\12\1\u008d\1\u008e\1\u0091\1\u008f\1\u0090\2\12\1"+
            "\u0094\1\12\1\u0093\30\12",
            "\1\13\134\12",
            "\1\u00a3\50\12\1\u0099\1\u00a0\11\12\1\u0096\1\u0098\1\u0097"+
            "\1\u009a\2\12\1\u009b\1\u009c\1\u009f\1\u009d\1\u009e\2\12\1"+
            "\u00a2\1\12\1\u00a1\30\12",
            "\1\13\134\12",
            "\1\13\134\12",
            "\1\13\134\12",
            "\1\13\134\12",
            "\1\13\134\12",
            "\1\13\134\12",
            "\1\u00a3\50\12\1\u0099\1\u00a0\11\12\1\u0096\1\u0098\1\u0097"+
            "\1\u009a\2\12\1\u009b\1\u009c\1\u009f\1\u009d\1\u009e\2\12\1"+
            "\u00a2\1\12\1\u00a1\30\12",
            "\1\13\134\12",
            "\1\13\133\12",
            "\1\13\134\12",
            "\1\13\134\12",
            "\1\13\134\12",
            "\1\u0087\133\12",
            "\1\13\134\12",
            "\1\13\134\12",
            "\1\13\134\12",
            "\1\13\134\12",
            "\1\13\134\12",
            "\1\13\134\12",
            "\1\u0087\133\12",
            "\1\13\134\12",
            "\1\13\134\12",
            "\1\13\133\12",
            "\1\13\134\12",
            "\1\13\134\12",
            "\1\13\134\12",
            "\1\u0095\133\12",
            "\1\13\134\12",
            "\1\13\134\12",
            "\1\13\134\12",
            "\1\13\134\12",
            "\1\13\134\12",
            "\1\13\134\12",
            "\1\u0095\133\12",
            "\1\13\134\12",
            "\1\13\134\12",
            "\1\13\133\12",
            "\1\13\134\12",
            "\1\13\134\12",
            "\1\13\134\12",
            "\1\u00a3\133\12",
            "\1\13\134\12",
            "\1\13\134\12",
            "\1\13\134\12",
            "\1\13\134\12",
            "\1\13\134\12",
            "\1\13\134\12",
            "\1\u00a3\133\12",
            "\1\13\134\12",
            "\1\13\134\12",
            "\1\13\133\12"
    };

    static final short[] DFA6_eot = DFA.unpackEncodedString(DFA6_eotS);
    static final short[] DFA6_eof = DFA.unpackEncodedString(DFA6_eofS);
    static final char[] DFA6_min = DFA.unpackEncodedStringToUnsignedChars(DFA6_minS);
    static final char[] DFA6_max = DFA.unpackEncodedStringToUnsignedChars(DFA6_maxS);
    static final short[] DFA6_accept = DFA.unpackEncodedString(DFA6_acceptS);
    static final short[] DFA6_special = DFA.unpackEncodedString(DFA6_specialS);
    static final short[][] DFA6_transition;

    static {
        int numStates = DFA6_transitionS.length;
        DFA6_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA6_transition[i] = DFA.unpackEncodedString(DFA6_transitionS[i]);
        }
    }

    class DFA6 extends DFA {

        public DFA6(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 6;
            this.eot = DFA6_eot;
            this.eof = DFA6_eof;
            this.min = DFA6_min;
            this.max = DFA6_max;
            this.accept = DFA6_accept;
            this.special = DFA6_special;
            this.transition = DFA6_transition;
        }
        public String getDescription() {
            return "()+ loopback of 292:21: (head+= . )+";
        }
    }
    static final String DFA18_eotS =
        "\60\uffff";
    static final String DFA18_eofS =
        "\60\uffff";
    static final String DFA18_minS =
        "\1\110\1\2\6\uffff\2\2\2\uffff\1\2\3\105\1\35\3\2\6\uffff\3\54\3"+
        "\2\1\3\17\0";
    static final String DFA18_maxS =
        "\1\123\1\2\6\uffff\2\2\2\uffff\1\2\3\105\1\43\3\2\6\uffff\1\106"+
        "\2\54\3\2\1\3\17\0";
    static final String DFA18_acceptS =
        "\2\uffff\1\3\1\4\1\5\1\6\1\7\1\10\2\uffff\1\15\1\16\10\uffff\1\17"+
        "\1\20\1\21\1\22\1\23\1\24\26\uffff";
    static final String DFA18_specialS =
        "\60\uffff}>";
    static final String[] DFA18_transitionS = {
            "\1\7\1\6\1\14\1\1\1\2\1\4\1\5\1\12\1\13\1\10\1\11\1\3",
            "\1\15",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\16",
            "\1\17",
            "",
            "",
            "\1\20",
            "\1\21",
            "\1\22",
            "\1\23",
            "\1\24\1\30\1\uffff\1\27\1\26\1\31\1\25",
            "\1\32",
            "\1\33",
            "\1\34",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\40\1\47\11\uffff\1\35\1\37\1\36\1\41\2\uffff\1\42\1\43\1"+
            "\46\1\44\1\45\2\uffff\1\51\1\uffff\1\50",
            "\1\52",
            "\1\53",
            "\1\54",
            "\1\55",
            "\1\56",
            "\1\57",
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
            "\1\uffff"
    };

    static final short[] DFA18_eot = DFA.unpackEncodedString(DFA18_eotS);
    static final short[] DFA18_eof = DFA.unpackEncodedString(DFA18_eofS);
    static final char[] DFA18_min = DFA.unpackEncodedStringToUnsignedChars(DFA18_minS);
    static final char[] DFA18_max = DFA.unpackEncodedStringToUnsignedChars(DFA18_maxS);
    static final short[] DFA18_accept = DFA.unpackEncodedString(DFA18_acceptS);
    static final short[] DFA18_special = DFA.unpackEncodedString(DFA18_specialS);
    static final short[][] DFA18_transition;

    static {
        int numStates = DFA18_transitionS.length;
        DFA18_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA18_transition[i] = DFA.unpackEncodedString(DFA18_transitionS[i]);
        }
    }

    class DFA18 extends DFA {

        public DFA18(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 18;
            this.eot = DFA18_eot;
            this.eof = DFA18_eof;
            this.min = DFA18_min;
            this.max = DFA18_max;
            this.accept = DFA18_accept;
            this.special = DFA18_special;
            this.transition = DFA18_transition;
        }
        public String getDescription() {
            return "498:1: incompleteAxiom returns [List<String> completions] : ( ^( INCOMPLETE_SUB_CLASS_AXIOM ^( EXPRESSION subClass= expression ) superClass= incompleteExpression ) | ^( INCOMPLETE_SUB_CLASS_AXIOM ^( EXPRESSION subClass= expression ) ) | ^( INCOMPLETE_EQUIVALENT_TO_AXIOM ^( EXPRESSION lhs= expression ) ^( INCOMPLETE_EXPRESSION rhs= incompleteExpression ) ) | ^( INCOMPLETE_INVERSE_OF ^( EXPRESSION p= IDENTIFIER ) ) | ^( INCOMPLETE_DISJOINT_WITH_AXIOM ^( EXPRESSION lhs= expression ) ^( INCOMPLETE_EXPRESSION rhs= incompleteExpression ) ) | ^( INCOMPLETE_SUB_PROPERTY_AXIOM ^( EXPRESSION subProperty= expression ) ) | ^( INCOMPLETE_ROLE_ASSERTION ^( EXPRESSION IDENTIFIER ) ^( EXPRESSION propertyExpression ) ) | ^( INCOMPLETE_TYPE_ASSERTION ^( EXPRESSION IDENTIFIER ) ) | ^( INCOMPLETE_DOMAIN ^( EXPRESSION p= IDENTIFIER ) ) | ^( INCOMPLETE_DOMAIN ^( EXPRESSION p= IDENTIFIER ) ^( INCOMPLETE_EXPRESSION domain= incompleteExpression ) ) | ^( INCOMPLETE_RANGE ^( EXPRESSION p= IDENTIFIER ) ) | ^( INCOMPLETE_RANGE ^( EXPRESSION p= IDENTIFIER ) ^( INCOMPLETE_EXPRESSION range= incompleteExpression ) ) | ^( INCOMPLETE_SAME_AS_AXIOM ^( EXPRESSION anIndividual= IDENTIFIER ) ) | ^( INCOMPLETE_DIFFERENT_FROM_AXIOM ^( EXPRESSION anIndividual= IDENTIFIER ) ) | ^( INCOMPLETE_UNARY_AXIOM FUNCTIONAL ) | ^( INCOMPLETE_UNARY_AXIOM INVERSE_FUNCTIONAL ) | ^( INCOMPLETE_UNARY_AXIOM IRREFLEXIVE ) | ^( INCOMPLETE_UNARY_AXIOM REFLEXIVE ) | ^( INCOMPLETE_UNARY_AXIOM SYMMETRIC ) | ^( INCOMPLETE_UNARY_AXIOM TRANSITIVE ) );";
        }
    }
 

    public static final BitSet FOLLOW_axiom_in_bottomup79 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_standaloneExpression_in_bottomup89 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expressionRoot_in_bottomup98 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_incompleteAxiom_in_bottomup109 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_incompleteExpression_in_bottomup119 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_EXPRESSION_in_expressionRoot148 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_expressionRoot150 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_STANDALONE_EXPRESSION_in_standaloneExpression172 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_EXPRESSION_in_standaloneExpression175 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_standaloneExpression177 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_SUB_CLASS_AXIOM_in_axiom216 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_EXPRESSION_in_axiom220 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_axiom227 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_EXPRESSION_in_axiom232 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_axiom239 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_EQUIVALENT_TO_AXIOM_in_axiom252 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_EXPRESSION_in_axiom255 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_axiom261 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_EXPRESSION_in_axiom265 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_axiom272 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_INVERSE_OF_in_axiom287 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_EXPRESSION_in_axiom290 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENTIFIER_in_axiom296 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_EXPRESSION_in_axiom300 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENTIFIER_in_axiom306 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_DISJOINT_WITH_AXIOM_in_axiom318 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_EXPRESSION_in_axiom321 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_axiom328 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_EXPRESSION_in_axiom332 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_axiom338 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_SUB_PROPERTY_AXIOM_in_axiom350 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_EXPRESSION_in_axiom353 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_axiom360 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_EXPRESSION_in_axiom364 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_unary_in_axiom370 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ROLE_ASSERTION_in_axiom384 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_EXPRESSION_in_axiom387 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENTIFIER_in_axiom394 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_EXPRESSION_in_axiom398 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_propertyExpression_in_axiom405 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_EXPRESSION_in_axiom409 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_unary_in_axiom415 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_TYPE_ASSERTION_in_axiom425 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_EXPRESSION_in_axiom428 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_axiom435 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_EXPRESSION_in_axiom439 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENTIFIER_in_axiom445 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_DOMAIN_in_axiom457 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_EXPRESSION_in_axiom460 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENTIFIER_in_axiom466 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_EXPRESSION_in_axiom470 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_axiom476 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_RANGE_in_axiom489 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_EXPRESSION_in_axiom492 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENTIFIER_in_axiom498 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_EXPRESSION_in_axiom502 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_axiom508 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_SAME_AS_AXIOM_in_axiom523 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_EXPRESSION_in_axiom526 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENTIFIER_in_axiom531 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_EXPRESSION_in_axiom535 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENTIFIER_in_axiom541 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_DIFFERENT_FROM_AXIOM_in_axiom557 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_EXPRESSION_in_axiom560 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENTIFIER_in_axiom565 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_EXPRESSION_in_axiom569 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENTIFIER_in_axiom575 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_UNARY_AXIOM_in_axiom589 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_FUNCTIONAL_in_axiom591 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_EXPRESSION_in_axiom594 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENTIFIER_in_axiom600 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_UNARY_AXIOM_in_axiom613 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_INVERSE_FUNCTIONAL_in_axiom615 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_EXPRESSION_in_axiom618 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENTIFIER_in_axiom624 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_UNARY_AXIOM_in_axiom640 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IRREFLEXIVE_in_axiom642 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_EXPRESSION_in_axiom645 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENTIFIER_in_axiom651 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_UNARY_AXIOM_in_axiom666 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_REFLEXIVE_in_axiom668 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_EXPRESSION_in_axiom671 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENTIFIER_in_axiom677 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_UNARY_AXIOM_in_axiom692 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_SYMMETRIC_in_axiom694 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_EXPRESSION_in_axiom697 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENTIFIER_in_axiom703 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_UNARY_AXIOM_in_axiom720 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_TRANSITIVE_in_axiom722 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_EXPRESSION_in_axiom725 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENTIFIER_in_axiom731 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_NEGATED_ASSERTION_in_axiom746 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_axiom_in_axiom751 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_DISJUNCTION_in_expression786 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_conjunction_in_expression799 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_PROPERTY_CHAIN_in_expression814 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_expression824 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_conjunction_in_expression837 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_complexPropertyExpression_in_expression849 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CONJUNCTION_in_conjunction882 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_unary_in_conjunction895 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_unary_in_conjunction905 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_unary935 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NEGATED_EXPRESSION_in_unary948 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_unary954 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_qualifiedRestriction_in_unary968 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ENTITY_REFERENCE_in_unary982 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CONSTANT_in_unary995 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENTIFIER_in_unary1006 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_IDENTIFIER_in_propertyExpression1042 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_complexPropertyExpression_in_propertyExpression1058 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INVERSE_OBJECT_PROPERTY_EXPRESSION_in_complexPropertyExpression1091 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_complexPropertyExpression_in_complexPropertyExpression1097 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_INVERSE_OBJECT_PROPERTY_EXPRESSION_in_complexPropertyExpression1107 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENTIFIER_in_complexPropertyExpression1109 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_SOME_RESTRICTION_in_qualifiedRestriction1140 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_propertyExpression_in_qualifiedRestriction1145 = new BitSet(new long[]{0xE780300000000000L,0x0000000000000053L});
    public static final BitSet FOLLOW_expression_in_qualifiedRestriction1151 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ALL_RESTRICTION_in_qualifiedRestriction1173 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_propertyExpression_in_qualifiedRestriction1180 = new BitSet(new long[]{0xE780300000000000L,0x0000000000000053L});
    public static final BitSet FOLLOW_expression_in_qualifiedRestriction1185 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_cardinalityRestriction_in_qualifiedRestriction1201 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_oneOf_in_qualifiedRestriction1217 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_valueRestriction_in_qualifiedRestriction1233 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CARDINALITY_RESTRICTION_in_cardinalityRestriction1270 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_MIN_in_cardinalityRestriction1273 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_INTEGER_in_cardinalityRestriction1278 = new BitSet(new long[]{0xE500300000000000L,0x0000000000000043L});
    public static final BitSet FOLLOW_unary_in_cardinalityRestriction1284 = new BitSet(new long[]{0xE780300000000008L,0x0000000000000053L});
    public static final BitSet FOLLOW_expression_in_cardinalityRestriction1291 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_CARDINALITY_RESTRICTION_in_cardinalityRestriction1306 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_MAX_in_cardinalityRestriction1309 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_INTEGER_in_cardinalityRestriction1313 = new BitSet(new long[]{0xE500300000000000L,0x0000000000000043L});
    public static final BitSet FOLLOW_unary_in_cardinalityRestriction1319 = new BitSet(new long[]{0xE780300000000008L,0x0000000000000053L});
    public static final BitSet FOLLOW_expression_in_cardinalityRestriction1326 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_CARDINALITY_RESTRICTION_in_cardinalityRestriction1345 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_EXACTLY_in_cardinalityRestriction1348 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_INTEGER_in_cardinalityRestriction1353 = new BitSet(new long[]{0xE500300000000000L,0x0000000000000043L});
    public static final BitSet FOLLOW_unary_in_cardinalityRestriction1360 = new BitSet(new long[]{0xE780300000000008L,0x0000000000000053L});
    public static final BitSet FOLLOW_expression_in_cardinalityRestriction1367 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ONE_OF_in_oneOf1403 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENTIFIER_in_oneOf1407 = new BitSet(new long[]{0x0000100000000008L});
    public static final BitSet FOLLOW_VALUE_RESTRICTION_in_valueRestriction1440 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_unary_in_valueRestriction1447 = new BitSet(new long[]{0xE500300000000000L,0x0000000000000043L});
    public static final BitSet FOLLOW_unary_in_valueRestriction1454 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_INCOMPLETE_SUB_CLASS_AXIOM_in_incompleteAxiom1496 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_EXPRESSION_in_incompleteAxiom1500 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_incompleteAxiom1507 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_incompleteExpression_in_incompleteAxiom1515 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_INCOMPLETE_SUB_CLASS_AXIOM_in_incompleteAxiom1530 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_EXPRESSION_in_incompleteAxiom1534 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_incompleteAxiom1541 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_INCOMPLETE_EQUIVALENT_TO_AXIOM_in_incompleteAxiom1559 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_EXPRESSION_in_incompleteAxiom1562 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_incompleteAxiom1568 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_INCOMPLETE_EXPRESSION_in_incompleteAxiom1572 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_incompleteExpression_in_incompleteAxiom1579 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_INCOMPLETE_INVERSE_OF_in_incompleteAxiom1597 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_EXPRESSION_in_incompleteAxiom1600 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENTIFIER_in_incompleteAxiom1606 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_INCOMPLETE_DISJOINT_WITH_AXIOM_in_incompleteAxiom1619 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_EXPRESSION_in_incompleteAxiom1622 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_incompleteAxiom1629 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_INCOMPLETE_EXPRESSION_in_incompleteAxiom1633 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_incompleteExpression_in_incompleteAxiom1639 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_INCOMPLETE_SUB_PROPERTY_AXIOM_in_incompleteAxiom1652 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_EXPRESSION_in_incompleteAxiom1655 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_incompleteAxiom1662 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_INCOMPLETE_ROLE_ASSERTION_in_incompleteAxiom1680 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_EXPRESSION_in_incompleteAxiom1683 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENTIFIER_in_incompleteAxiom1685 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_EXPRESSION_in_incompleteAxiom1689 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_propertyExpression_in_incompleteAxiom1691 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_INCOMPLETE_TYPE_ASSERTION_in_incompleteAxiom1702 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_EXPRESSION_in_incompleteAxiom1706 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENTIFIER_in_incompleteAxiom1708 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_INCOMPLETE_DOMAIN_in_incompleteAxiom1721 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_EXPRESSION_in_incompleteAxiom1724 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENTIFIER_in_incompleteAxiom1730 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_INCOMPLETE_DOMAIN_in_incompleteAxiom1745 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_EXPRESSION_in_incompleteAxiom1748 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENTIFIER_in_incompleteAxiom1754 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_INCOMPLETE_EXPRESSION_in_incompleteAxiom1758 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_incompleteExpression_in_incompleteAxiom1764 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_INCOMPLETE_RANGE_in_incompleteAxiom1779 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_EXPRESSION_in_incompleteAxiom1782 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENTIFIER_in_incompleteAxiom1788 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_INCOMPLETE_RANGE_in_incompleteAxiom1799 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_EXPRESSION_in_incompleteAxiom1802 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENTIFIER_in_incompleteAxiom1808 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_INCOMPLETE_EXPRESSION_in_incompleteAxiom1812 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_incompleteExpression_in_incompleteAxiom1818 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_INCOMPLETE_SAME_AS_AXIOM_in_incompleteAxiom1833 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_EXPRESSION_in_incompleteAxiom1836 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENTIFIER_in_incompleteAxiom1841 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_INCOMPLETE_DIFFERENT_FROM_AXIOM_in_incompleteAxiom1857 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_EXPRESSION_in_incompleteAxiom1860 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENTIFIER_in_incompleteAxiom1865 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_INCOMPLETE_UNARY_AXIOM_in_incompleteAxiom1880 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_FUNCTIONAL_in_incompleteAxiom1882 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_INCOMPLETE_UNARY_AXIOM_in_incompleteAxiom1896 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_INVERSE_FUNCTIONAL_in_incompleteAxiom1898 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_INCOMPLETE_UNARY_AXIOM_in_incompleteAxiom1913 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IRREFLEXIVE_in_incompleteAxiom1915 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_INCOMPLETE_UNARY_AXIOM_in_incompleteAxiom1929 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_REFLEXIVE_in_incompleteAxiom1931 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_INCOMPLETE_UNARY_AXIOM_in_incompleteAxiom1945 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_SYMMETRIC_in_incompleteAxiom1947 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_INCOMPLETE_UNARY_AXIOM_in_incompleteAxiom1963 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_TRANSITIVE_in_incompleteAxiom1965 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_INCOMPLETE_PROPERTY_CHAIN_in_incompleteExpression2007 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_INCOMPLETE_DISJUNCTION_in_incompleteExpression2026 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_incompleteConjunction_in_incompleteExpression2033 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_INCOMPLETE_EXPRESSION_in_incompleteExpression2048 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_EXPRESSION_in_incompleteExpression2051 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_incompleteExpression2058 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_IDENTIFIER_in_incompleteExpression2061 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_INCOMPLETE_CONJUNCTION_in_incompleteConjunction2099 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_incompleteUnary_in_incompleteConjunction2106 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_INCOMPLETE_NEGATED_EXPRESSION_in_incompleteUnary2151 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_incompleteQualifiedRestriction_in_incompleteUnary2182 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INCOMPLETE_SOME_RESTRICTION_in_incompleteQualifiedRestriction2240 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_propertyExpression_in_incompleteQualifiedRestriction2242 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_INCOMPLETE_ALL_RESTRICTION_in_incompleteQualifiedRestriction2285 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_propertyExpression_in_incompleteQualifiedRestriction2287 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_incompleteCardinalityRestriction_in_incompleteQualifiedRestriction2310 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_incompleteOneOf_in_incompleteQualifiedRestriction2332 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_incompleteValueRestriction_in_incompleteQualifiedRestriction2354 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INCOMPLETE_CARDINALITY_RESTRICTION_in_incompleteCardinalityRestriction2415 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_INTEGER_in_incompleteCardinalityRestriction2420 = new BitSet(new long[]{0xE780300000000000L,0x0000000000000053L});
    public static final BitSet FOLLOW_propertyExpression_in_incompleteCardinalityRestriction2422 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_INCOMPLETE_ONE_OF_in_incompleteOneOf2468 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENTIFIER_in_incompleteOneOf2470 = new BitSet(new long[]{0x0000100000000008L});
    public static final BitSet FOLLOW_INCOMPLETE_VALUE_RESTRICTION_in_incompleteValueRestriction2518 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_propertyExpression_in_incompleteValueRestriction2524 = new BitSet(new long[]{0x0000000000000008L});

}