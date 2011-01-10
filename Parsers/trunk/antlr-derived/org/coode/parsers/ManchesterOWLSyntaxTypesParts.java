// $ANTLR 3.2 Sep 23, 2009 12:02:23 /Users/luigi/Documents/workspace/Parsers/src/ManchesterOWLSyntaxTypesParts.g 2011-01-10 15:08:31

  package org.coode.parsers;
  import org.semanticweb.owlapi.model.OWLObject;
  import org.semanticweb.owlapi.model.OWLAxiom;


import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
public class ManchesterOWLSyntaxTypesParts extends TreeFilter {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "COMPOSITION", "OPEN_PARENTHESYS", "OPEN_CURLY_BRACES", "CLOSED_CURLY_BRACES", "CLOSED_PARENTHESYS", "WHITESPACE", "AND", "OR", "NOT", "SOME", "ONLY", "MIN", "MAX", "EXACTLY", "VALUE", "INVERSE", "SUBCLASS_OF", "SUB_PROPERTY_OF", "EQUIVALENT_TO", "SAME_AS", "DIFFERENT_FROM", "INVERSE_OF", "DISJOINT_WITH", "DOMAIN", "RANGE", "FUNCTIONAL", "SYMMETRIC", "ANTI_SYMMETRIC", "REFLEXIVE", "IRREFLEXIVE", "TRANSITIVE", "INVERSE_FUNCTIONAL", "POW", "COMMA", "INSTANCE_OF", "TYPES", "DBLQUOTE", "DIGIT", "INTEGER", "LETTER", "IDENTIFIER", "ENTITY_REFERENCE", "QUESTION_MARK", "Tokens", "SUB_CLASS_AXIOM", "EQUIVALENT_TO_AXIOM", "DISJOINT_WITH_AXIOM", "SUB_PROPERTY_AXIOM", "SAME_AS_AXIOM", "DIFFERENT_FROM_AXIOM", "UNARY_AXIOM", "DISJUNCTION", "CONJUNCTION", "PROPERTY_CHAIN", "NEGATED_EXPRESSION", "NEGATED_ASSERTION", "INVERSE_PROPERTY", "SOME_RESTRICTION", "ALL_RESTRICTION", "VALUE_RESTRICTION", "CARDINALITY_RESTRICTION", "ONE_OF", "TYPE_ASSERTION", "ROLE_ASSERTION", "INVERSE_OBJECT_PROPERTY_EXPRESSION", "EXPRESSION", "CONSTANT", "WHERE", "NOT_EQUAL", "EQUAL", "IN", "SELECT", "ASSERTED", "COLON", "DOT", "PLUS", "CREATE", "CREATE_INTERSECTION", "CREATE_DISJUNCTION", "BEGIN", "END", "OPEN_SQUARE_BRACKET", "CLOSED_SQUARE_BRACKET", "SUPER_CLASS_OF", "SUPER_PROPERTY_OF", "VARIABLE_TYPE", "ADD", "REMOVE", "ASSERTED_CLAUSE", "PLAIN_CLAUSE", "INEQUALITY_CONSTRAINT", "IN_SET_CONSTRAINT", "INPUT_VARIABLE_DEFINITION", "GENERATED_VARIABLE_DEFINITION", "CREATE_OPPL_FUNCTION", "VARIABLE_ATTRIBUTE", "OPPL_FUNCTION", "ACTIONS", "VARIABLE_DEFINITIONS", "QUERY", "VARIABLE_SCOPE", "SUBPROPERTY_OF", "VARIABLE_IDENTIFIER", "OPPL_STATEMENT", "DATA_RANGE", "HAS_KEY", "IRI", "ANNOTATION_ASSERTION", "AT", "ESCLAMATION_MARK", "CREATE_IDENTIFIER", "PLAIN_IDENTIFIER", "MATCH", "ATTRIBUTE_SELECTOR", "LESS_THAN", "LESS_THAN_EQUAL", "GREATER_THAN", "GREATER_THAN_EQUAL"
    };
    public static final int COMMA=37;
    public static final int GREATER_THAN=485;
    public static final int ASSERTED=76;
    public static final int VARIABLE_DEFINITIONS=102;
    public static final int END=84;
    public static final int DIFFERENT_FROM=24;
    public static final int TYPE_ASSERTION=66;
    public static final int LESS_THAN=483;
    public static final int SAME_AS_AXIOM=52;
    public static final int ROLE_ASSERTION=67;
    public static final int TYPES=39;
    public static final int CREATE_OPPL_FUNCTION=98;
    public static final int VARIABLE_IDENTIFIER=106;
    public static final int ESCLAMATION_MARK=149;
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
    public static final int SELECT=75;
    public static final int CARDINALITY_RESTRICTION=64;
    public static final int EXACTLY=17;
    public static final int SAME_AS=23;
    public static final int PLUS=79;
    public static final int TRANSITIVE=34;
    public static final int IN_SET_CONSTRAINT=95;
    public static final int CONJUNCTION=56;
    public static final int SUBCLASS_OF=20;
    public static final int ENTITY_REFERENCE=45;
    public static final int INVERSE_OF=25;
    public static final int AT=114;
    public static final int RANGE=28;
    public static final int DATA_RANGE=108;
    public static final int PROPERTY_CHAIN=57;
    public static final int CREATE_INTERSECTION=81;
    public static final int CLOSED_PARENTHESYS=8;
    public static final int OPEN_SQUARE_BRACKET=85;
    public static final int EQUIVALENT_TO_AXIOM=49;
    public static final int SYMMETRIC=30;
    public static final int DISJOINT_WITH=26;
    public static final int VARIABLE_TYPE=89;
    public static final int DISJUNCTION=55;
    public static final int NEGATED_EXPRESSION=58;
    public static final int EQUAL=73;
    public static final int DIFFERENT_FROM_AXIOM=53;
    public static final int GREATER_THAN_EQUAL=486;
    public static final int ACTIONS=101;
    public static final int EQUIVALENT_TO=22;
    public static final int DOMAIN=27;
    public static final int INVERSE_OBJECT_PROPERTY_EXPRESSION=68;
    public static final int SUB_PROPERTY_OF=21;
    public static final int INVERSE_PROPERTY=60;
    public static final int COLON=77;
    public static final int GENERATED_VARIABLE_DEFINITION=97;
    public static final int VARIABLE_ATTRIBUTE=99;
    public static final int SUB_CLASS_AXIOM=48;
    public static final int SUB_PROPERTY_AXIOM=51;
    public static final int UNARY_AXIOM=54;
    public static final int IDENTIFIER=44;
    public static final int ADD=90;
    public static final int CREATE=80;
    public static final int WHERE=71;
    public static final int VARIABLE_SCOPE=104;
    public static final int OPEN_CURLY_BRACES=6;
    public static final int CLOSED_SQUARE_BRACKET=86;
    public static final int INSTANCE_OF=38;
    public static final int QUERY=103;
    public static final int SOME_RESTRICTION=61;
    public static final int IRI=110;
    public static final int LESS_THAN_EQUAL=484;
    public static final int VALUE=18;
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
    public static final int WHITESPACE=9;
    public static final int SUPER_PROPERTY_OF=88;
    public static final int IN=74;
    public static final int INEQUALITY_CONSTRAINT=94;
    public static final int SOME=13;
    public static final int EOF=-1;
    public static final int CREATE_IDENTIFIER=151;
    public static final int Tokens=47;
    public static final int ANTI_SYMMETRIC=31;
    public static final int CLOSED_CURLY_BRACES=7;
    public static final int REFLEXIVE=32;
    public static final int NOT=12;
    public static final int OPEN_PARENTHESYS=5;
    public static final int IRREFLEXIVE=33;

    // delegates
    // delegators


        public ManchesterOWLSyntaxTypesParts(TreeNodeStream input) {
            this(input, new RecognizerSharedState());
        }
        public ManchesterOWLSyntaxTypesParts(TreeNodeStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return ManchesterOWLSyntaxTypesParts.tokenNames; }
    public String getGrammarFileName() { return "/Users/luigi/Documents/workspace/Parsers/src/ManchesterOWLSyntaxTypesParts.g"; }


      private  SymbolTable symtab;
      private  ErrorListener errorListener;
      public ManchesterOWLSyntaxTypesParts(TreeNodeStream input, SymbolTable symtab, ErrorListener errorListener) {
        this(input);
        if(symtab==null){
        	throw new NullPointerException("The symbol table cannot be null");
        }
        if(errorListener == null){
        	throw new NullPointerException("The error listener cannot be null");
        }
        this.symtab = symtab;
        this.errorListener = errorListener;
      }
      
      public ErrorListener getErrorListener(){
      	return this.errorListener;
      }
      
      public SymbolTable getSymbolTable(){
      	return this.symtab;
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
    // /Users/luigi/Documents/workspace/Parsers/src/ManchesterOWLSyntaxTypesParts.g:73:1: bottomup : expression ;
    public final void bottomup() throws RecognitionException {
        try {
            // /Users/luigi/Documents/workspace/Parsers/src/ManchesterOWLSyntaxTypesParts.g:75:5: ( expression )
            // /Users/luigi/Documents/workspace/Parsers/src/ManchesterOWLSyntaxTypesParts.g:75:9: expression
            {
            pushFollow(FOLLOW_expression_in_bottomup82);
            expression();

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

    public static class expression_return extends TreeRuleReturnScope {
        public Type type;
        public ManchesterOWLSyntaxTree node;
        public OWLObject owlObject;
    };

    // $ANTLR start "expression"
    // /Users/luigi/Documents/workspace/Parsers/src/ManchesterOWLSyntaxTypesParts.g:83:1: expression returns [Type type, ManchesterOWLSyntaxTree node, OWLObject owlObject] : ( ^( DISJUNCTION (disjuncts+= conjunction )+ ) | ^( PROPERTY_CHAIN (chainItems+= expression )+ ) | conjunction | complexPropertyExpression );
    public final ManchesterOWLSyntaxTypesParts.expression_return expression() throws RecognitionException {
        ManchesterOWLSyntaxTypesParts.expression_return retval = new ManchesterOWLSyntaxTypesParts.expression_return();
        retval.start = input.LT(1);

        List list_disjuncts=null;
        List list_chainItems=null;
        ManchesterOWLSyntaxTypesParts.conjunction_return conjunction1 = null;

        ManchesterOWLSyntaxTypesParts.complexPropertyExpression_return complexPropertyExpression2 = null;

        RuleReturnScope disjuncts = null;
        RuleReturnScope chainItems = null;
        try {
            // /Users/luigi/Documents/workspace/Parsers/src/ManchesterOWLSyntaxTypesParts.g:90:2: ( ^( DISJUNCTION (disjuncts+= conjunction )+ ) | ^( PROPERTY_CHAIN (chainItems+= expression )+ ) | conjunction | complexPropertyExpression )
            int alt3=4;
            switch ( input.LA(1) ) {
            case DISJUNCTION:
                {
                alt3=1;
                }
                break;
            case PROPERTY_CHAIN:
                {
                alt3=2;
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
                alt3=3;
                }
                break;
            case INVERSE_OBJECT_PROPERTY_EXPRESSION:
                {
                alt3=4;
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
                    // /Users/luigi/Documents/workspace/Parsers/src/ManchesterOWLSyntaxTypesParts.g:91:4: ^( DISJUNCTION (disjuncts+= conjunction )+ )
                    {
                    match(input,DISJUNCTION,FOLLOW_DISJUNCTION_in_expression124); if (state.failed) return retval;

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    // /Users/luigi/Documents/workspace/Parsers/src/ManchesterOWLSyntaxTypesParts.g:91:29: (disjuncts+= conjunction )+
                    int cnt1=0;
                    loop1:
                    do {
                        int alt1=2;
                        int LA1_0 = input.LA(1);

                        if ( ((LA1_0>=IDENTIFIER && LA1_0<=ENTITY_REFERENCE)||LA1_0==CONJUNCTION||LA1_0==NEGATED_EXPRESSION||(LA1_0>=SOME_RESTRICTION && LA1_0<=ONE_OF)||LA1_0==CONSTANT) ) {
                            alt1=1;
                        }


                        switch (alt1) {
                    	case 1 :
                    	    // /Users/luigi/Documents/workspace/Parsers/src/ManchesterOWLSyntaxTypesParts.g:91:29: disjuncts+= conjunction
                    	    {
                    	    pushFollow(FOLLOW_conjunction_in_expression130);
                    	    disjuncts=conjunction();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if (list_disjuncts==null) list_disjuncts=new ArrayList();
                    	    list_disjuncts.add(disjuncts);


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt1 >= 1 ) break loop1;
                    	    if (state.backtracking>0) {state.failed=true; return retval;}
                                EarlyExitException eee =
                                    new EarlyExitException(1, input);
                                throw eee;
                        }
                        cnt1++;
                    } while (true);


                    match(input, Token.UP, null); if (state.failed) return retval;
                    if ( state.backtracking==1 ) {
                      	
                      		 		List<ManchesterOWLSyntaxTree> nodes = new ArrayList<ManchesterOWLSyntaxTree>(list_disjuncts.size());
                      		 	 	for(Object node :list_disjuncts){
                      		 	 		nodes.add(((conjunction_return) node).node);
                      		 	 	}
                      		 		retval.type = this.getSymbolTable().getDisjunctionType(((ManchesterOWLSyntaxTree)retval.start), nodes.toArray(new ManchesterOWLSyntaxTree[nodes.size()]));
                      		 		retval.owlObject = this.getSymbolTable().getDisjunction(((ManchesterOWLSyntaxTree)retval.start), nodes.toArray(new ManchesterOWLSyntaxTree[nodes.size()]));
                      		 	
                    }

                    }
                    break;
                case 2 :
                    // /Users/luigi/Documents/workspace/Parsers/src/ManchesterOWLSyntaxTypesParts.g:100:6: ^( PROPERTY_CHAIN (chainItems+= expression )+ )
                    {
                    match(input,PROPERTY_CHAIN,FOLLOW_PROPERTY_CHAIN_in_expression146); if (state.failed) return retval;

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    // /Users/luigi/Documents/workspace/Parsers/src/ManchesterOWLSyntaxTypesParts.g:100:34: (chainItems+= expression )+
                    int cnt2=0;
                    loop2:
                    do {
                        int alt2=2;
                        int LA2_0 = input.LA(1);

                        if ( ((LA2_0>=IDENTIFIER && LA2_0<=ENTITY_REFERENCE)||(LA2_0>=DISJUNCTION && LA2_0<=NEGATED_EXPRESSION)||(LA2_0>=SOME_RESTRICTION && LA2_0<=ONE_OF)||LA2_0==INVERSE_OBJECT_PROPERTY_EXPRESSION||LA2_0==CONSTANT) ) {
                            alt2=1;
                        }


                        switch (alt2) {
                    	case 1 :
                    	    // /Users/luigi/Documents/workspace/Parsers/src/ManchesterOWLSyntaxTypesParts.g:100:34: chainItems+= expression
                    	    {
                    	    pushFollow(FOLLOW_expression_in_expression151);
                    	    chainItems=expression();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if (list_chainItems==null) list_chainItems=new ArrayList();
                    	    list_chainItems.add(chainItems);


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt2 >= 1 ) break loop2;
                    	    if (state.backtracking>0) {state.failed=true; return retval;}
                                EarlyExitException eee =
                                    new EarlyExitException(2, input);
                                throw eee;
                        }
                        cnt2++;
                    } while (true);


                    match(input, Token.UP, null); if (state.failed) return retval;
                    if ( state.backtracking==1 ) {

                      		    List<ManchesterOWLSyntaxTree> nodes = new ArrayList<ManchesterOWLSyntaxTree>(list_chainItems.size());
                              for(Object item  :list_chainItems){
                                nodes.add(((expression_return) item).node);
                              }
                      		    retval.type = this.getSymbolTable().getPropertyChainType(((ManchesterOWLSyntaxTree)retval.start), nodes.toArray(new ManchesterOWLSyntaxTree[nodes.size()]));
                      		    retval.owlObject = this.getSymbolTable().getPropertyChain(((ManchesterOWLSyntaxTree)retval.start), nodes.toArray(new ManchesterOWLSyntaxTree[nodes.size()]));
                      		  
                    }

                    }
                    break;
                case 3 :
                    // /Users/luigi/Documents/workspace/Parsers/src/ManchesterOWLSyntaxTypesParts.g:109:5: conjunction
                    {
                    pushFollow(FOLLOW_conjunction_in_expression165);
                    conjunction1=conjunction();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==1 ) {

                      			retval.type = (conjunction1!=null?conjunction1.type:null);
                      			retval.owlObject = (conjunction1!=null?conjunction1.owlObject:null);
                      		
                    }

                    }
                    break;
                case 4 :
                    // /Users/luigi/Documents/workspace/Parsers/src/ManchesterOWLSyntaxTypesParts.g:114:5: complexPropertyExpression
                    {
                    pushFollow(FOLLOW_complexPropertyExpression_in_expression177);
                    complexPropertyExpression2=complexPropertyExpression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==1 ) {

                      			retval.type = (complexPropertyExpression2!=null?complexPropertyExpression2.type:null);
                      			retval.owlObject = (complexPropertyExpression2!=null?complexPropertyExpression2.owlObject:null);
                      		
                    }

                    }
                    break;

            }
            if ( state.backtracking==1 ) {
               
              			((ManchesterOWLSyntaxTree)retval.start).setEvalType(retval.type); 
              			retval.node = ((ManchesterOWLSyntaxTree)retval.start);
              			((ManchesterOWLSyntaxTree)retval.start).setOWLObject(retval.owlObject); 
              		
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
    // $ANTLR end "expression"

    public static class conjunction_return extends TreeRuleReturnScope {
        public Type type;
        public ManchesterOWLSyntaxTree node;
        public OWLObject owlObject;
    };

    // $ANTLR start "conjunction"
    // /Users/luigi/Documents/workspace/Parsers/src/ManchesterOWLSyntaxTypesParts.g:122:1: conjunction returns [Type type, ManchesterOWLSyntaxTree node, OWLObject owlObject] : ( ^( CONJUNCTION (conjuncts+= unary )+ ) | unary );
    public final ManchesterOWLSyntaxTypesParts.conjunction_return conjunction() throws RecognitionException {
        ManchesterOWLSyntaxTypesParts.conjunction_return retval = new ManchesterOWLSyntaxTypesParts.conjunction_return();
        retval.start = input.LT(1);

        List list_conjuncts=null;
        ManchesterOWLSyntaxTypesParts.unary_return unary3 = null;

        RuleReturnScope conjuncts = null;
        try {
            // /Users/luigi/Documents/workspace/Parsers/src/ManchesterOWLSyntaxTypesParts.g:129:2: ( ^( CONJUNCTION (conjuncts+= unary )+ ) | unary )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==CONJUNCTION) ) {
                alt5=1;
            }
            else if ( ((LA5_0>=IDENTIFIER && LA5_0<=ENTITY_REFERENCE)||LA5_0==NEGATED_EXPRESSION||(LA5_0>=SOME_RESTRICTION && LA5_0<=ONE_OF)||LA5_0==CONSTANT) ) {
                alt5=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // /Users/luigi/Documents/workspace/Parsers/src/ManchesterOWLSyntaxTypesParts.g:130:2: ^( CONJUNCTION (conjuncts+= unary )+ )
                    {
                    match(input,CONJUNCTION,FOLLOW_CONJUNCTION_in_conjunction214); if (state.failed) return retval;

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    // /Users/luigi/Documents/workspace/Parsers/src/ManchesterOWLSyntaxTypesParts.g:130:26: (conjuncts+= unary )+
                    int cnt4=0;
                    loop4:
                    do {
                        int alt4=2;
                        int LA4_0 = input.LA(1);

                        if ( ((LA4_0>=IDENTIFIER && LA4_0<=ENTITY_REFERENCE)||LA4_0==NEGATED_EXPRESSION||(LA4_0>=SOME_RESTRICTION && LA4_0<=ONE_OF)||LA4_0==CONSTANT) ) {
                            alt4=1;
                        }


                        switch (alt4) {
                    	case 1 :
                    	    // /Users/luigi/Documents/workspace/Parsers/src/ManchesterOWLSyntaxTypesParts.g:130:26: conjuncts+= unary
                    	    {
                    	    pushFollow(FOLLOW_unary_in_conjunction219);
                    	    conjuncts=unary();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if (list_conjuncts==null) list_conjuncts=new ArrayList();
                    	    list_conjuncts.add(conjuncts);


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt4 >= 1 ) break loop4;
                    	    if (state.backtracking>0) {state.failed=true; return retval;}
                                EarlyExitException eee =
                                    new EarlyExitException(4, input);
                                throw eee;
                        }
                        cnt4++;
                    } while (true);


                    match(input, Token.UP, null); if (state.failed) return retval;
                    if ( state.backtracking==1 ) {
                      	
                      		 		List<ManchesterOWLSyntaxTree> nodes = new ArrayList<ManchesterOWLSyntaxTree>(list_conjuncts.size());
                      		 	 	for(Object node :list_conjuncts){
                      		 	 		nodes.add(((unary_return) node).node);
                      		 	 	}
                      		 		retval.type = this.getSymbolTable().getConjunctionType(((ManchesterOWLSyntaxTree)retval.start), nodes.toArray(new ManchesterOWLSyntaxTree[nodes.size()]));
                      		 		retval.owlObject = this.getSymbolTable().getConjunction(((ManchesterOWLSyntaxTree)retval.start), nodes.toArray(new ManchesterOWLSyntaxTree[nodes.size()])); 
                      	
                    }

                    }
                    break;
                case 2 :
                    // /Users/luigi/Documents/workspace/Parsers/src/ManchesterOWLSyntaxTypesParts.g:139:4: unary
                    {
                    pushFollow(FOLLOW_unary_in_conjunction230);
                    unary3=unary();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==1 ) {

                      		retval.type = (unary3!=null?unary3.type:null);
                      		retval.owlObject = (unary3!=null?unary3.owlObject:null);
                      	
                    }

                    }
                    break;

            }
            if ( state.backtracking==1 ) {
               
              				((ManchesterOWLSyntaxTree)retval.start).setEvalType(retval.type); 
              				retval.node = ((ManchesterOWLSyntaxTree)retval.start);
              				((ManchesterOWLSyntaxTree)retval.start).setOWLObject(retval.owlObject);
              			
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
    // $ANTLR end "conjunction"

    public static class unary_return extends TreeRuleReturnScope {
        public Type type;
        public ManchesterOWLSyntaxTree node;
        public OWLObject owlObject;
    };

    // $ANTLR start "unary"
    // /Users/luigi/Documents/workspace/Parsers/src/ManchesterOWLSyntaxTypesParts.g:145:1: unary returns [Type type, ManchesterOWLSyntaxTree node, OWLObject owlObject] : ( IDENTIFIER | ^( NEGATED_EXPRESSION e= expression ) | qualifiedRestriction | ENTITY_REFERENCE | ^( CONSTANT value= . ( ^( AT language= IDENTIFIER ) )? (constantType= IDENTIFIER )? ) );
    public final ManchesterOWLSyntaxTypesParts.unary_return unary() throws RecognitionException {
        ManchesterOWLSyntaxTypesParts.unary_return retval = new ManchesterOWLSyntaxTypesParts.unary_return();
        retval.start = input.LT(1);

        ManchesterOWLSyntaxTree language=null;
        ManchesterOWLSyntaxTree constantType=null;
        ManchesterOWLSyntaxTree IDENTIFIER4=null;
        ManchesterOWLSyntaxTree ENTITY_REFERENCE6=null;
        ManchesterOWLSyntaxTree value=null;
        ManchesterOWLSyntaxTypesParts.expression_return e = null;

        ManchesterOWLSyntaxTypesParts.qualifiedRestriction_return qualifiedRestriction5 = null;


        try {
            // /Users/luigi/Documents/workspace/Parsers/src/ManchesterOWLSyntaxTypesParts.g:152:1: ( IDENTIFIER | ^( NEGATED_EXPRESSION e= expression ) | qualifiedRestriction | ENTITY_REFERENCE | ^( CONSTANT value= . ( ^( AT language= IDENTIFIER ) )? (constantType= IDENTIFIER )? ) )
            int alt8=5;
            switch ( input.LA(1) ) {
            case IDENTIFIER:
                {
                alt8=1;
                }
                break;
            case NEGATED_EXPRESSION:
                {
                alt8=2;
                }
                break;
            case SOME_RESTRICTION:
            case ALL_RESTRICTION:
            case VALUE_RESTRICTION:
            case CARDINALITY_RESTRICTION:
            case ONE_OF:
                {
                alt8=3;
                }
                break;
            case ENTITY_REFERENCE:
                {
                alt8=4;
                }
                break;
            case CONSTANT:
                {
                alt8=5;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }

            switch (alt8) {
                case 1 :
                    // /Users/luigi/Documents/workspace/Parsers/src/ManchesterOWLSyntaxTypesParts.g:153:3: IDENTIFIER
                    {
                    IDENTIFIER4=(ManchesterOWLSyntaxTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_unary257); if (state.failed) return retval;
                    if ( state.backtracking==1 ) {

                      				Symbol symbol = this.getSymbolTable().resolve(IDENTIFIER4);
                      				retval.type = symbol==null ? null: symbol.getType();
                      				retval.owlObject = this.getSymbolTable().getOWLObject(IDENTIFIER4);
                      			
                    }

                    }
                    break;
                case 2 :
                    // /Users/luigi/Documents/workspace/Parsers/src/ManchesterOWLSyntaxTypesParts.g:159:5: ^( NEGATED_EXPRESSION e= expression )
                    {
                    match(input,NEGATED_EXPRESSION,FOLLOW_NEGATED_EXPRESSION_in_unary270); if (state.failed) return retval;

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    pushFollow(FOLLOW_expression_in_unary276);
                    e=expression();

                    state._fsp--;
                    if (state.failed) return retval;

                    match(input, Token.UP, null); if (state.failed) return retval;
                    if ( state.backtracking==1 ) {

                      				retval.type = this.getSymbolTable().getNegatedClassExpressionType(((ManchesterOWLSyntaxTree)retval.start),e.node);
                      				retval.owlObject = this.getSymbolTable().getNegatedClassExpression(((ManchesterOWLSyntaxTree)retval.start),e.node);
                      			
                    }

                    }
                    break;
                case 3 :
                    // /Users/luigi/Documents/workspace/Parsers/src/ManchesterOWLSyntaxTypesParts.g:164:5: qualifiedRestriction
                    {
                    pushFollow(FOLLOW_qualifiedRestriction_in_unary290);
                    qualifiedRestriction5=qualifiedRestriction();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==1 ) {

                      				retval.type = (qualifiedRestriction5!=null?qualifiedRestriction5.type:null);
                      				retval.owlObject = (qualifiedRestriction5!=null?qualifiedRestriction5.owlObject:null);
                      			
                    }

                    }
                    break;
                case 4 :
                    // /Users/luigi/Documents/workspace/Parsers/src/ManchesterOWLSyntaxTypesParts.g:169:5: ENTITY_REFERENCE
                    {
                    ENTITY_REFERENCE6=(ManchesterOWLSyntaxTree)match(input,ENTITY_REFERENCE,FOLLOW_ENTITY_REFERENCE_in_unary304); if (state.failed) return retval;
                    if ( state.backtracking==1 ) {

                      				Symbol symbol = this.getSymbolTable().resolve(ENTITY_REFERENCE6);
                      				retval.type = symbol==null ? null: symbol.getType();
                      				retval.owlObject = this.getSymbolTable().getOWLObject(ENTITY_REFERENCE6);
                      			
                    }

                    }
                    break;
                case 5 :
                    // /Users/luigi/Documents/workspace/Parsers/src/ManchesterOWLSyntaxTypesParts.g:175:5: ^( CONSTANT value= . ( ^( AT language= IDENTIFIER ) )? (constantType= IDENTIFIER )? )
                    {
                    match(input,CONSTANT,FOLLOW_CONSTANT_in_unary317); if (state.failed) return retval;

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    value=(ManchesterOWLSyntaxTree)input.LT(1);
                    matchAny(input); if (state.failed) return retval;
                    // /Users/luigi/Documents/workspace/Parsers/src/ManchesterOWLSyntaxTypesParts.g:175:25: ( ^( AT language= IDENTIFIER ) )?
                    int alt6=2;
                    int LA6_0 = input.LA(1);

                    if ( (LA6_0==AT) ) {
                        alt6=1;
                    }
                    switch (alt6) {
                        case 1 :
                            // /Users/luigi/Documents/workspace/Parsers/src/ManchesterOWLSyntaxTypesParts.g:175:27: ^( AT language= IDENTIFIER )
                            {
                            match(input,AT,FOLLOW_AT_in_unary327); if (state.failed) return retval;

                            match(input, Token.DOWN, null); if (state.failed) return retval;
                            language=(ManchesterOWLSyntaxTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_unary333); if (state.failed) return retval;

                            match(input, Token.UP, null); if (state.failed) return retval;

                            }
                            break;

                    }

                    // /Users/luigi/Documents/workspace/Parsers/src/ManchesterOWLSyntaxTypesParts.g:175:70: (constantType= IDENTIFIER )?
                    int alt7=2;
                    int LA7_0 = input.LA(1);

                    if ( (LA7_0==IDENTIFIER) ) {
                        alt7=1;
                    }
                    switch (alt7) {
                        case 1 :
                            // /Users/luigi/Documents/workspace/Parsers/src/ManchesterOWLSyntaxTypesParts.g:175:70: constantType= IDENTIFIER
                            {
                            constantType=(ManchesterOWLSyntaxTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_unary342); if (state.failed) return retval;

                            }
                            break;

                    }


                    match(input, Token.UP, null); if (state.failed) return retval;
                    if ( state.backtracking==1 ) {

                      				retval.type = OWLType.OWL_CONSTANT;
                      				retval.owlObject = constantType ==null ? this.getSymbolTable().getOWLUntypedConstant(((ManchesterOWLSyntaxTree)retval.start),value, language) : this.getSymbolTable().getOWLTypedConstant(((ManchesterOWLSyntaxTree)retval.start),value, constantType);				
                      			
                    }

                    }
                    break;

            }
            if ( state.backtracking==1 ) {
               
              				((ManchesterOWLSyntaxTree)retval.start).setEvalType(retval.type); 
              				retval.node = ((ManchesterOWLSyntaxTree)retval.start);
              				((ManchesterOWLSyntaxTree)retval.start).setOWLObject(retval.owlObject);
              			
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
    // $ANTLR end "unary"

    public static class propertyExpression_return extends TreeRuleReturnScope {
        public Type type;
        public ManchesterOWLSyntaxTree node;
        public OWLObject owlObject;
    };

    // $ANTLR start "propertyExpression"
    // /Users/luigi/Documents/workspace/Parsers/src/ManchesterOWLSyntaxTypesParts.g:182:1: propertyExpression returns [Type type, ManchesterOWLSyntaxTree node, OWLObject owlObject] : ( IDENTIFIER | complexPropertyExpression );
    public final ManchesterOWLSyntaxTypesParts.propertyExpression_return propertyExpression() throws RecognitionException {
        ManchesterOWLSyntaxTypesParts.propertyExpression_return retval = new ManchesterOWLSyntaxTypesParts.propertyExpression_return();
        retval.start = input.LT(1);

        ManchesterOWLSyntaxTree IDENTIFIER7=null;
        ManchesterOWLSyntaxTypesParts.complexPropertyExpression_return complexPropertyExpression8 = null;


        try {
            // /Users/luigi/Documents/workspace/Parsers/src/ManchesterOWLSyntaxTypesParts.g:190:1: ( IDENTIFIER | complexPropertyExpression )
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==IDENTIFIER) ) {
                alt9=1;
            }
            else if ( (LA9_0==INVERSE_OBJECT_PROPERTY_EXPRESSION) ) {
                alt9=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }
            switch (alt9) {
                case 1 :
                    // /Users/luigi/Documents/workspace/Parsers/src/ManchesterOWLSyntaxTypesParts.g:191:7: IDENTIFIER
                    {
                    IDENTIFIER7=(ManchesterOWLSyntaxTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_propertyExpression379); if (state.failed) return retval;
                    if ( state.backtracking==1 ) {

                              Symbol symbol = this.getSymbolTable().resolve(IDENTIFIER7);
                              retval.type = symbol==null ? null: symbol.getType();
                              retval.owlObject = this.getSymbolTable().getOWLObject(IDENTIFIER7);
                            
                    }

                    }
                    break;
                case 2 :
                    // /Users/luigi/Documents/workspace/Parsers/src/ManchesterOWLSyntaxTypesParts.g:197:7: complexPropertyExpression
                    {
                    pushFollow(FOLLOW_complexPropertyExpression_in_propertyExpression395);
                    complexPropertyExpression8=complexPropertyExpression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==1 ) {

                              retval.type = (complexPropertyExpression8!=null?complexPropertyExpression8.type:null);
                              retval.owlObject = (complexPropertyExpression8!=null?complexPropertyExpression8.owlObject:null);
                            
                    }

                    }
                    break;

            }
            if ( state.backtracking==1 ) {
               
              				((ManchesterOWLSyntaxTree)retval.start).setEvalType(retval.type); 
              				retval.node = ((ManchesterOWLSyntaxTree)retval.start);
              				((ManchesterOWLSyntaxTree)retval.start).setOWLObject(retval.owlObject);
              			
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
    // $ANTLR end "propertyExpression"

    public static class complexPropertyExpression_return extends TreeRuleReturnScope {
        public Type type;
        public ManchesterOWLSyntaxTree node;
        public OWLObject owlObject;
    };

    // $ANTLR start "complexPropertyExpression"
    // /Users/luigi/Documents/workspace/Parsers/src/ManchesterOWLSyntaxTypesParts.g:204:1: complexPropertyExpression returns [Type type, ManchesterOWLSyntaxTree node, OWLObject owlObject] : ( ^( INVERSE_OBJECT_PROPERTY_EXPRESSION p= complexPropertyExpression ) | ^( INVERSE_OBJECT_PROPERTY_EXPRESSION IDENTIFIER ) );
    public final ManchesterOWLSyntaxTypesParts.complexPropertyExpression_return complexPropertyExpression() throws RecognitionException {
        ManchesterOWLSyntaxTypesParts.complexPropertyExpression_return retval = new ManchesterOWLSyntaxTypesParts.complexPropertyExpression_return();
        retval.start = input.LT(1);

        ManchesterOWLSyntaxTree IDENTIFIER9=null;
        ManchesterOWLSyntaxTypesParts.complexPropertyExpression_return p = null;


        try {
            // /Users/luigi/Documents/workspace/Parsers/src/ManchesterOWLSyntaxTypesParts.g:211:1: ( ^( INVERSE_OBJECT_PROPERTY_EXPRESSION p= complexPropertyExpression ) | ^( INVERSE_OBJECT_PROPERTY_EXPRESSION IDENTIFIER ) )
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==INVERSE_OBJECT_PROPERTY_EXPRESSION) ) {
                int LA10_1 = input.LA(2);

                if ( (LA10_1==DOWN) ) {
                    int LA10_2 = input.LA(3);

                    if ( (LA10_2==IDENTIFIER) ) {
                        alt10=2;
                    }
                    else if ( (LA10_2==INVERSE_OBJECT_PROPERTY_EXPRESSION) ) {
                        alt10=1;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 10, 2, input);

                        throw nvae;
                    }
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 10, 1, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }
            switch (alt10) {
                case 1 :
                    // /Users/luigi/Documents/workspace/Parsers/src/ManchesterOWLSyntaxTypesParts.g:212:2: ^( INVERSE_OBJECT_PROPERTY_EXPRESSION p= complexPropertyExpression )
                    {
                    match(input,INVERSE_OBJECT_PROPERTY_EXPRESSION,FOLLOW_INVERSE_OBJECT_PROPERTY_EXPRESSION_in_complexPropertyExpression428); if (state.failed) return retval;

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    pushFollow(FOLLOW_complexPropertyExpression_in_complexPropertyExpression434);
                    p=complexPropertyExpression();

                    state._fsp--;
                    if (state.failed) return retval;

                    match(input, Token.UP, null); if (state.failed) return retval;
                    if ( state.backtracking==1 ) {

                      		retval.type = this.getSymbolTable().getInversePropertyType(((ManchesterOWLSyntaxTree)retval.start), p.node);
                      		retval.owlObject = this.getSymbolTable().getInverseProperty(((ManchesterOWLSyntaxTree)retval.start), p.node);
                      	
                    }

                    }
                    break;
                case 2 :
                    // /Users/luigi/Documents/workspace/Parsers/src/ManchesterOWLSyntaxTypesParts.g:217:4: ^( INVERSE_OBJECT_PROPERTY_EXPRESSION IDENTIFIER )
                    {
                    match(input,INVERSE_OBJECT_PROPERTY_EXPRESSION,FOLLOW_INVERSE_OBJECT_PROPERTY_EXPRESSION_in_complexPropertyExpression444); if (state.failed) return retval;

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    IDENTIFIER9=(ManchesterOWLSyntaxTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_complexPropertyExpression446); if (state.failed) return retval;

                    match(input, Token.UP, null); if (state.failed) return retval;
                    if ( state.backtracking==1 ) {

                      				Symbol symbol = this.getSymbolTable().resolve(IDENTIFIER9);
                      				retval.type = this.getSymbolTable().getInversePropertyType(((ManchesterOWLSyntaxTree)retval.start), IDENTIFIER9);
                      				retval.owlObject = this.getSymbolTable().getInverseProperty(((ManchesterOWLSyntaxTree)retval.start), IDENTIFIER9);
                      	
                    }

                    }
                    break;

            }
            if ( state.backtracking==1 ) {
               
                        ((ManchesterOWLSyntaxTree)retval.start).setEvalType(retval.type); 
                        retval.node = ((ManchesterOWLSyntaxTree)retval.start);
                        ((ManchesterOWLSyntaxTree)retval.start).setOWLObject(retval.owlObject);
                     
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
    // $ANTLR end "complexPropertyExpression"

    public static class qualifiedRestriction_return extends TreeRuleReturnScope {
        public Type type;
        public ManchesterOWLSyntaxTree node;
        public OWLObject owlObject;
    };

    // $ANTLR start "qualifiedRestriction"
    // /Users/luigi/Documents/workspace/Parsers/src/ManchesterOWLSyntaxTypesParts.g:225:1: qualifiedRestriction returns [Type type , ManchesterOWLSyntaxTree node, OWLObject owlObject] : ( ^( SOME_RESTRICTION p= propertyExpression f= expression ) | ^( ALL_RESTRICTION p= propertyExpression f= expression ) | cardinalityRestriction | oneOf | valueRestriction );
    public final ManchesterOWLSyntaxTypesParts.qualifiedRestriction_return qualifiedRestriction() throws RecognitionException {
        ManchesterOWLSyntaxTypesParts.qualifiedRestriction_return retval = new ManchesterOWLSyntaxTypesParts.qualifiedRestriction_return();
        retval.start = input.LT(1);

        ManchesterOWLSyntaxTypesParts.propertyExpression_return p = null;

        ManchesterOWLSyntaxTypesParts.expression_return f = null;

        ManchesterOWLSyntaxTypesParts.cardinalityRestriction_return cardinalityRestriction10 = null;

        ManchesterOWLSyntaxTypesParts.oneOf_return oneOf11 = null;

        ManchesterOWLSyntaxTypesParts.valueRestriction_return valueRestriction12 = null;


        try {
            // /Users/luigi/Documents/workspace/Parsers/src/ManchesterOWLSyntaxTypesParts.g:231:2: ( ^( SOME_RESTRICTION p= propertyExpression f= expression ) | ^( ALL_RESTRICTION p= propertyExpression f= expression ) | cardinalityRestriction | oneOf | valueRestriction )
            int alt11=5;
            switch ( input.LA(1) ) {
            case SOME_RESTRICTION:
                {
                alt11=1;
                }
                break;
            case ALL_RESTRICTION:
                {
                alt11=2;
                }
                break;
            case CARDINALITY_RESTRICTION:
                {
                alt11=3;
                }
                break;
            case ONE_OF:
                {
                alt11=4;
                }
                break;
            case VALUE_RESTRICTION:
                {
                alt11=5;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }

            switch (alt11) {
                case 1 :
                    // /Users/luigi/Documents/workspace/Parsers/src/ManchesterOWLSyntaxTypesParts.g:232:6: ^( SOME_RESTRICTION p= propertyExpression f= expression )
                    {
                    match(input,SOME_RESTRICTION,FOLLOW_SOME_RESTRICTION_in_qualifiedRestriction477); if (state.failed) return retval;

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    pushFollow(FOLLOW_propertyExpression_in_qualifiedRestriction482);
                    p=propertyExpression();

                    state._fsp--;
                    if (state.failed) return retval;
                    pushFollow(FOLLOW_expression_in_qualifiedRestriction488);
                    f=expression();

                    state._fsp--;
                    if (state.failed) return retval;

                    match(input, Token.UP, null); if (state.failed) return retval;
                    if ( state.backtracking==1 ) {

                      						retval.type = this.getSymbolTable().getSomeValueRestrictionType(((ManchesterOWLSyntaxTree)retval.start),p.node,f.node);
                      						retval.owlObject = this.getSymbolTable().getSomeValueRestriction(((ManchesterOWLSyntaxTree)retval.start),p.node,f.node);
                      					
                    }

                    }
                    break;
                case 2 :
                    // /Users/luigi/Documents/workspace/Parsers/src/ManchesterOWLSyntaxTypesParts.g:237:7: ^( ALL_RESTRICTION p= propertyExpression f= expression )
                    {
                    match(input,ALL_RESTRICTION,FOLLOW_ALL_RESTRICTION_in_qualifiedRestriction510); if (state.failed) return retval;

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    pushFollow(FOLLOW_propertyExpression_in_qualifiedRestriction517);
                    p=propertyExpression();

                    state._fsp--;
                    if (state.failed) return retval;
                    pushFollow(FOLLOW_expression_in_qualifiedRestriction522);
                    f=expression();

                    state._fsp--;
                    if (state.failed) return retval;

                    match(input, Token.UP, null); if (state.failed) return retval;
                    if ( state.backtracking==1 ) {

                      					retval.type = this.getSymbolTable().getAllValueRestrictionType(((ManchesterOWLSyntaxTree)retval.start),p.node,f.node);
                      					retval.owlObject = this.getSymbolTable().getAllValueRestriction(((ManchesterOWLSyntaxTree)retval.start),p.node,f.node);
                      				
                    }

                    }
                    break;
                case 3 :
                    // /Users/luigi/Documents/workspace/Parsers/src/ManchesterOWLSyntaxTypesParts.g:242:7: cardinalityRestriction
                    {
                    pushFollow(FOLLOW_cardinalityRestriction_in_qualifiedRestriction538);
                    cardinalityRestriction10=cardinalityRestriction();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==1 ) {

                      						retval.type = (cardinalityRestriction10!=null?cardinalityRestriction10.type:null);
                      						retval.owlObject = (cardinalityRestriction10!=null?cardinalityRestriction10.owlObject:null);
                      					
                    }

                    }
                    break;
                case 4 :
                    // /Users/luigi/Documents/workspace/Parsers/src/ManchesterOWLSyntaxTypesParts.g:247:7: oneOf
                    {
                    pushFollow(FOLLOW_oneOf_in_qualifiedRestriction554);
                    oneOf11=oneOf();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==1 ) {

                      						retval.type = (oneOf11!=null?oneOf11.type:null);
                      						retval.owlObject = (oneOf11!=null?oneOf11.owlObject:null);
                      					
                    }

                    }
                    break;
                case 5 :
                    // /Users/luigi/Documents/workspace/Parsers/src/ManchesterOWLSyntaxTypesParts.g:252:7: valueRestriction
                    {
                    pushFollow(FOLLOW_valueRestriction_in_qualifiedRestriction570);
                    valueRestriction12=valueRestriction();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==1 ) {

                      						retval.type = (valueRestriction12!=null?valueRestriction12.type:null);
                      						retval.owlObject = (valueRestriction12!=null?valueRestriction12.owlObject:null);
                      					
                    }

                    }
                    break;

            }
            if ( state.backtracking==1 ) {
               
                        ((ManchesterOWLSyntaxTree)retval.start).setEvalType(retval.type); 
                        retval.node = ((ManchesterOWLSyntaxTree)retval.start);
                        ((ManchesterOWLSyntaxTree)retval.start).setOWLObject(retval.owlObject);
                      
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
    // $ANTLR end "qualifiedRestriction"

    public static class cardinalityRestriction_return extends TreeRuleReturnScope {
        public Type type;
        public ManchesterOWLSyntaxTree node;
        public OWLObject owlObject;
    };

    // $ANTLR start "cardinalityRestriction"
    // /Users/luigi/Documents/workspace/Parsers/src/ManchesterOWLSyntaxTypesParts.g:261:1: cardinalityRestriction returns [Type type , ManchesterOWLSyntaxTree node, OWLObject owlObject] : ( ^( CARDINALITY_RESTRICTION MIN i= INTEGER p= unary (filler= expression )? ) | ^( CARDINALITY_RESTRICTION MAX i= INTEGER p= unary (filler= expression )? ) | ^( CARDINALITY_RESTRICTION EXACTLY i= INTEGER p= unary (filler= expression )? ) );
    public final ManchesterOWLSyntaxTypesParts.cardinalityRestriction_return cardinalityRestriction() throws RecognitionException {
        ManchesterOWLSyntaxTypesParts.cardinalityRestriction_return retval = new ManchesterOWLSyntaxTypesParts.cardinalityRestriction_return();
        retval.start = input.LT(1);

        ManchesterOWLSyntaxTree i=null;
        ManchesterOWLSyntaxTypesParts.unary_return p = null;

        ManchesterOWLSyntaxTypesParts.expression_return filler = null;


        try {
            // /Users/luigi/Documents/workspace/Parsers/src/ManchesterOWLSyntaxTypesParts.g:267:1: ( ^( CARDINALITY_RESTRICTION MIN i= INTEGER p= unary (filler= expression )? ) | ^( CARDINALITY_RESTRICTION MAX i= INTEGER p= unary (filler= expression )? ) | ^( CARDINALITY_RESTRICTION EXACTLY i= INTEGER p= unary (filler= expression )? ) )
            int alt15=3;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==CARDINALITY_RESTRICTION) ) {
                int LA15_1 = input.LA(2);

                if ( (LA15_1==DOWN) ) {
                    switch ( input.LA(3) ) {
                    case MIN:
                        {
                        alt15=1;
                        }
                        break;
                    case MAX:
                        {
                        alt15=2;
                        }
                        break;
                    case EXACTLY:
                        {
                        alt15=3;
                        }
                        break;
                    default:
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 15, 2, input);

                        throw nvae;
                    }

                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 15, 1, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 15, 0, input);

                throw nvae;
            }
            switch (alt15) {
                case 1 :
                    // /Users/luigi/Documents/workspace/Parsers/src/ManchesterOWLSyntaxTypesParts.g:268:5: ^( CARDINALITY_RESTRICTION MIN i= INTEGER p= unary (filler= expression )? )
                    {
                    match(input,CARDINALITY_RESTRICTION,FOLLOW_CARDINALITY_RESTRICTION_in_cardinalityRestriction607); if (state.failed) return retval;

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    match(input,MIN,FOLLOW_MIN_in_cardinalityRestriction610); if (state.failed) return retval;
                    i=(ManchesterOWLSyntaxTree)match(input,INTEGER,FOLLOW_INTEGER_in_cardinalityRestriction615); if (state.failed) return retval;
                    pushFollow(FOLLOW_unary_in_cardinalityRestriction621);
                    p=unary();

                    state._fsp--;
                    if (state.failed) return retval;
                    // /Users/luigi/Documents/workspace/Parsers/src/ManchesterOWLSyntaxTypesParts.g:268:65: (filler= expression )?
                    int alt12=2;
                    int LA12_0 = input.LA(1);

                    if ( ((LA12_0>=IDENTIFIER && LA12_0<=ENTITY_REFERENCE)||(LA12_0>=DISJUNCTION && LA12_0<=NEGATED_EXPRESSION)||(LA12_0>=SOME_RESTRICTION && LA12_0<=ONE_OF)||LA12_0==INVERSE_OBJECT_PROPERTY_EXPRESSION||LA12_0==CONSTANT) ) {
                        alt12=1;
                    }
                    switch (alt12) {
                        case 1 :
                            // /Users/luigi/Documents/workspace/Parsers/src/ManchesterOWLSyntaxTypesParts.g:268:65: filler= expression
                            {
                            pushFollow(FOLLOW_expression_in_cardinalityRestriction628);
                            filler=expression();

                            state._fsp--;
                            if (state.failed) return retval;

                            }
                            break;

                    }


                    match(input, Token.UP, null); if (state.failed) return retval;
                    if ( state.backtracking==1 ) {

                      			retval.type =  this.getSymbolTable().getMinCardinalityRestrictionType(((ManchesterOWLSyntaxTree)retval.start),p.node, filler==null?null:filler.node);
                      			int cardinality = Integer.parseInt(i.token.getText());
                            retval.owlObject = this.getSymbolTable().getMinCardinalityRestriction(((ManchesterOWLSyntaxTree)retval.start),cardinality,p.node, filler==null?null:filler.node);
                      			
                      		
                    }

                    }
                    break;
                case 2 :
                    // /Users/luigi/Documents/workspace/Parsers/src/ManchesterOWLSyntaxTypesParts.g:275:6: ^( CARDINALITY_RESTRICTION MAX i= INTEGER p= unary (filler= expression )? )
                    {
                    match(input,CARDINALITY_RESTRICTION,FOLLOW_CARDINALITY_RESTRICTION_in_cardinalityRestriction643); if (state.failed) return retval;

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    match(input,MAX,FOLLOW_MAX_in_cardinalityRestriction646); if (state.failed) return retval;
                    i=(ManchesterOWLSyntaxTree)match(input,INTEGER,FOLLOW_INTEGER_in_cardinalityRestriction650); if (state.failed) return retval;
                    pushFollow(FOLLOW_unary_in_cardinalityRestriction656);
                    p=unary();

                    state._fsp--;
                    if (state.failed) return retval;
                    // /Users/luigi/Documents/workspace/Parsers/src/ManchesterOWLSyntaxTypesParts.g:275:65: (filler= expression )?
                    int alt13=2;
                    int LA13_0 = input.LA(1);

                    if ( ((LA13_0>=IDENTIFIER && LA13_0<=ENTITY_REFERENCE)||(LA13_0>=DISJUNCTION && LA13_0<=NEGATED_EXPRESSION)||(LA13_0>=SOME_RESTRICTION && LA13_0<=ONE_OF)||LA13_0==INVERSE_OBJECT_PROPERTY_EXPRESSION||LA13_0==CONSTANT) ) {
                        alt13=1;
                    }
                    switch (alt13) {
                        case 1 :
                            // /Users/luigi/Documents/workspace/Parsers/src/ManchesterOWLSyntaxTypesParts.g:275:65: filler= expression
                            {
                            pushFollow(FOLLOW_expression_in_cardinalityRestriction663);
                            filler=expression();

                            state._fsp--;
                            if (state.failed) return retval;

                            }
                            break;

                    }


                    match(input, Token.UP, null); if (state.failed) return retval;
                    if ( state.backtracking==1 ) {

                            retval.type = this.getSymbolTable().getMaxCardinalityRestrictionType(((ManchesterOWLSyntaxTree)retval.start),p.node, filler==null?null:filler.node);
                            int cardinality = Integer.parseInt(i.token.getText());
                            retval.owlObject = this.getSymbolTable().getMaxCardinalityRestriction(((ManchesterOWLSyntaxTree)retval.start),cardinality,p.node, filler==null?null:filler.node);
                          
                    }

                    }
                    break;
                case 3 :
                    // /Users/luigi/Documents/workspace/Parsers/src/ManchesterOWLSyntaxTypesParts.g:281:8: ^( CARDINALITY_RESTRICTION EXACTLY i= INTEGER p= unary (filler= expression )? )
                    {
                    match(input,CARDINALITY_RESTRICTION,FOLLOW_CARDINALITY_RESTRICTION_in_cardinalityRestriction682); if (state.failed) return retval;

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    match(input,EXACTLY,FOLLOW_EXACTLY_in_cardinalityRestriction685); if (state.failed) return retval;
                    i=(ManchesterOWLSyntaxTree)match(input,INTEGER,FOLLOW_INTEGER_in_cardinalityRestriction690); if (state.failed) return retval;
                    pushFollow(FOLLOW_unary_in_cardinalityRestriction697);
                    p=unary();

                    state._fsp--;
                    if (state.failed) return retval;
                    // /Users/luigi/Documents/workspace/Parsers/src/ManchesterOWLSyntaxTypesParts.g:281:73: (filler= expression )?
                    int alt14=2;
                    int LA14_0 = input.LA(1);

                    if ( ((LA14_0>=IDENTIFIER && LA14_0<=ENTITY_REFERENCE)||(LA14_0>=DISJUNCTION && LA14_0<=NEGATED_EXPRESSION)||(LA14_0>=SOME_RESTRICTION && LA14_0<=ONE_OF)||LA14_0==INVERSE_OBJECT_PROPERTY_EXPRESSION||LA14_0==CONSTANT) ) {
                        alt14=1;
                    }
                    switch (alt14) {
                        case 1 :
                            // /Users/luigi/Documents/workspace/Parsers/src/ManchesterOWLSyntaxTypesParts.g:281:73: filler= expression
                            {
                            pushFollow(FOLLOW_expression_in_cardinalityRestriction704);
                            filler=expression();

                            state._fsp--;
                            if (state.failed) return retval;

                            }
                            break;

                    }


                    match(input, Token.UP, null); if (state.failed) return retval;
                    if ( state.backtracking==1 ) {

                            retval.type = this.getSymbolTable().getExactCardinalityRestrictionType(((ManchesterOWLSyntaxTree)retval.start),p.node, filler==null?null:filler.node);
                            int cardinality = Integer.parseInt(i.token.getText());
                            retval.owlObject = this.getSymbolTable().getExactCardinalityRestriction(((ManchesterOWLSyntaxTree)retval.start),cardinality,p.node, filler==null?null:filler.node);
                          
                    }

                    }
                    break;

            }
            if ( state.backtracking==1 ) {
               
                        ((ManchesterOWLSyntaxTree)retval.start).setEvalType(retval.type); 
                        retval.node = ((ManchesterOWLSyntaxTree)retval.start); 
                        ((ManchesterOWLSyntaxTree)retval.start).setOWLObject(retval.owlObject);
                      
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
    // $ANTLR end "cardinalityRestriction"

    public static class oneOf_return extends TreeRuleReturnScope {
        public Type type;
        public ManchesterOWLSyntaxTree node;
        public OWLObject owlObject;
    };

    // $ANTLR start "oneOf"
    // /Users/luigi/Documents/workspace/Parsers/src/ManchesterOWLSyntaxTypesParts.g:289:1: oneOf returns [Type type , ManchesterOWLSyntaxTree node, OWLObject owlObject] : ^( ONE_OF (individuals+= IDENTIFIER )+ ) ;
    public final ManchesterOWLSyntaxTypesParts.oneOf_return oneOf() throws RecognitionException {
        ManchesterOWLSyntaxTypesParts.oneOf_return retval = new ManchesterOWLSyntaxTypesParts.oneOf_return();
        retval.start = input.LT(1);

        ManchesterOWLSyntaxTree individuals=null;
        List list_individuals=null;

        try {
            // /Users/luigi/Documents/workspace/Parsers/src/ManchesterOWLSyntaxTypesParts.g:295:2: ( ^( ONE_OF (individuals+= IDENTIFIER )+ ) )
            // /Users/luigi/Documents/workspace/Parsers/src/ManchesterOWLSyntaxTypesParts.g:296:3: ^( ONE_OF (individuals+= IDENTIFIER )+ )
            {
            match(input,ONE_OF,FOLLOW_ONE_OF_in_oneOf739); if (state.failed) return retval;

            match(input, Token.DOWN, null); if (state.failed) return retval;
            // /Users/luigi/Documents/workspace/Parsers/src/ManchesterOWLSyntaxTypesParts.g:296:23: (individuals+= IDENTIFIER )+
            int cnt16=0;
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==IDENTIFIER) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // /Users/luigi/Documents/workspace/Parsers/src/ManchesterOWLSyntaxTypesParts.g:296:23: individuals+= IDENTIFIER
            	    {
            	    individuals=(ManchesterOWLSyntaxTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_oneOf743); if (state.failed) return retval;
            	    if (list_individuals==null) list_individuals=new ArrayList();
            	    list_individuals.add(individuals);


            	    }
            	    break;

            	default :
            	    if ( cnt16 >= 1 ) break loop16;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(16, input);
                        throw eee;
                }
                cnt16++;
            } while (true);


            match(input, Token.UP, null); if (state.failed) return retval;
            if ( state.backtracking==1 ) {

              		    List<ManchesterOWLSyntaxTree> nodes = new ArrayList<ManchesterOWLSyntaxTree>(list_individuals.size());
                      for(Object node :list_individuals){
                        nodes.add((ManchesterOWLSyntaxTree)node);
                      }
              		    retval.type = this.getSymbolTable().getOneOfType(((ManchesterOWLSyntaxTree)retval.start), nodes.toArray(new ManchesterOWLSyntaxTree[nodes.size()]));
              		    if(retval.type!=null){
                        retval.owlObject = this.getSymbolTable().getOneOf(((ManchesterOWLSyntaxTree)retval.start), nodes.toArray(new ManchesterOWLSyntaxTree[nodes.size()]));
                      }
              		
            }

            }

            if ( state.backtracking==1 ) {
               
                        ((ManchesterOWLSyntaxTree)retval.start).setEvalType(retval.type); 
                        retval.node = ((ManchesterOWLSyntaxTree)retval.start);
                        ((ManchesterOWLSyntaxTree)retval.start).setOWLObject(retval.owlObject);
                      
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
    // $ANTLR end "oneOf"

    public static class valueRestriction_return extends TreeRuleReturnScope {
        public Type type;
        public ManchesterOWLSyntaxTree node;
        public OWLObject owlObject;
    };

    // $ANTLR start "valueRestriction"
    // /Users/luigi/Documents/workspace/Parsers/src/ManchesterOWLSyntaxTypesParts.g:309:1: valueRestriction returns [Type type , ManchesterOWLSyntaxTree node, OWLObject owlObject] : ^( VALUE_RESTRICTION p= unary value= unary ) ;
    public final ManchesterOWLSyntaxTypesParts.valueRestriction_return valueRestriction() throws RecognitionException {
        ManchesterOWLSyntaxTypesParts.valueRestriction_return retval = new ManchesterOWLSyntaxTypesParts.valueRestriction_return();
        retval.start = input.LT(1);

        ManchesterOWLSyntaxTypesParts.unary_return p = null;

        ManchesterOWLSyntaxTypesParts.unary_return value = null;


        try {
            // /Users/luigi/Documents/workspace/Parsers/src/ManchesterOWLSyntaxTypesParts.g:315:2: ( ^( VALUE_RESTRICTION p= unary value= unary ) )
            // /Users/luigi/Documents/workspace/Parsers/src/ManchesterOWLSyntaxTypesParts.g:316:3: ^( VALUE_RESTRICTION p= unary value= unary )
            {
            match(input,VALUE_RESTRICTION,FOLLOW_VALUE_RESTRICTION_in_valueRestriction776); if (state.failed) return retval;

            match(input, Token.DOWN, null); if (state.failed) return retval;
            pushFollow(FOLLOW_unary_in_valueRestriction783);
            p=unary();

            state._fsp--;
            if (state.failed) return retval;
            pushFollow(FOLLOW_unary_in_valueRestriction790);
            value=unary();

            state._fsp--;
            if (state.failed) return retval;

            match(input, Token.UP, null); if (state.failed) return retval;
            if ( state.backtracking==1 ) {

              		  retval.type = this.getSymbolTable().getValueRestrictionType(((ManchesterOWLSyntaxTree)retval.start),p.node, value.node);
              		  if(retval.type!=null){
              		    retval.owlObject = this.getSymbolTable().getValueRestriction(((ManchesterOWLSyntaxTree)retval.start),p.node, value.node);
              		   }
              		 
            }

            }

            if ( state.backtracking==1 ) {
               
                        ((ManchesterOWLSyntaxTree)retval.start).setEvalType(retval.type); 
                        retval.node = ((ManchesterOWLSyntaxTree)retval.start);
                        ((ManchesterOWLSyntaxTree)retval.start).setOWLObject(retval.owlObject);
                      
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
    // $ANTLR end "valueRestriction"

    // Delegated rules


 

    public static final BitSet FOLLOW_expression_in_bottomup82 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DISJUNCTION_in_expression124 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_conjunction_in_expression130 = new BitSet(new long[]{0xE500300000000008L,0x0000000000000043L});
    public static final BitSet FOLLOW_PROPERTY_CHAIN_in_expression146 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_expression151 = new BitSet(new long[]{0xE780300000000008L,0x0000000000000053L});
    public static final BitSet FOLLOW_conjunction_in_expression165 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_complexPropertyExpression_in_expression177 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CONJUNCTION_in_conjunction214 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_unary_in_conjunction219 = new BitSet(new long[]{0xE500300000000008L,0x0000000000000043L});
    public static final BitSet FOLLOW_unary_in_conjunction230 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_unary257 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NEGATED_EXPRESSION_in_unary270 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_unary276 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_qualifiedRestriction_in_unary290 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ENTITY_REFERENCE_in_unary304 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CONSTANT_in_unary317 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_AT_in_unary327 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENTIFIER_in_unary333 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_IDENTIFIER_in_unary342 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_IDENTIFIER_in_propertyExpression379 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_complexPropertyExpression_in_propertyExpression395 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INVERSE_OBJECT_PROPERTY_EXPRESSION_in_complexPropertyExpression428 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_complexPropertyExpression_in_complexPropertyExpression434 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_INVERSE_OBJECT_PROPERTY_EXPRESSION_in_complexPropertyExpression444 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENTIFIER_in_complexPropertyExpression446 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_SOME_RESTRICTION_in_qualifiedRestriction477 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_propertyExpression_in_qualifiedRestriction482 = new BitSet(new long[]{0xE780300000000008L,0x0000000000000053L});
    public static final BitSet FOLLOW_expression_in_qualifiedRestriction488 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ALL_RESTRICTION_in_qualifiedRestriction510 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_propertyExpression_in_qualifiedRestriction517 = new BitSet(new long[]{0xE780300000000008L,0x0000000000000053L});
    public static final BitSet FOLLOW_expression_in_qualifiedRestriction522 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_cardinalityRestriction_in_qualifiedRestriction538 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_oneOf_in_qualifiedRestriction554 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_valueRestriction_in_qualifiedRestriction570 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CARDINALITY_RESTRICTION_in_cardinalityRestriction607 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_MIN_in_cardinalityRestriction610 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_INTEGER_in_cardinalityRestriction615 = new BitSet(new long[]{0xE500300000000008L,0x0000000000000043L});
    public static final BitSet FOLLOW_unary_in_cardinalityRestriction621 = new BitSet(new long[]{0xE780300000000008L,0x0000000000000053L});
    public static final BitSet FOLLOW_expression_in_cardinalityRestriction628 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_CARDINALITY_RESTRICTION_in_cardinalityRestriction643 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_MAX_in_cardinalityRestriction646 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_INTEGER_in_cardinalityRestriction650 = new BitSet(new long[]{0xE500300000000008L,0x0000000000000043L});
    public static final BitSet FOLLOW_unary_in_cardinalityRestriction656 = new BitSet(new long[]{0xE780300000000008L,0x0000000000000053L});
    public static final BitSet FOLLOW_expression_in_cardinalityRestriction663 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_CARDINALITY_RESTRICTION_in_cardinalityRestriction682 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_EXACTLY_in_cardinalityRestriction685 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_INTEGER_in_cardinalityRestriction690 = new BitSet(new long[]{0xE500300000000008L,0x0000000000000043L});
    public static final BitSet FOLLOW_unary_in_cardinalityRestriction697 = new BitSet(new long[]{0xE780300000000008L,0x0000000000000053L});
    public static final BitSet FOLLOW_expression_in_cardinalityRestriction704 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ONE_OF_in_oneOf739 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENTIFIER_in_oneOf743 = new BitSet(new long[]{0x0000100000000008L});
    public static final BitSet FOLLOW_VALUE_RESTRICTION_in_valueRestriction776 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_unary_in_valueRestriction783 = new BitSet(new long[]{0xE500300000000008L,0x0000000000000043L});
    public static final BitSet FOLLOW_unary_in_valueRestriction790 = new BitSet(new long[]{0x0000000000000008L});

}