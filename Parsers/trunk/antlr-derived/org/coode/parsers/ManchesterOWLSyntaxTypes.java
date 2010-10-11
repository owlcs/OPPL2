// $ANTLR 3.2 Sep 23, 2009 12:02:23 /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxTypes.g 2010-10-11 16:46:59

  package org.coode.parsers;
  import org.semanticweb.owlapi.model.OWLObject;
  import org.semanticweb.owlapi.model.OWLAxiom;


import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
public class ManchesterOWLSyntaxTypes extends TreeFilter {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "COMPOSITION", "OPEN_PARENTHESYS", "OPEN_CURLY_BRACES", "CLOSED_CURLY_BRACES", "CLOSED_PARENTHESYS", "WHITESPACE", "AND", "OR", "NOT", "SOME", "ONLY", "MIN", "MAX", "EXACTLY", "VALUE", "INVERSE", "SUBCLASS_OF", "SUB_PROPERTY_OF", "EQUIVALENT_TO", "SAME_AS", "DIFFERENT_FROM", "INVERSE_OF", "DISJOINT_WITH", "DOMAIN", "RANGE", "FUNCTIONAL", "SYMMETRIC", "ANTI_SYMMETRIC", "REFLEXIVE", "IRREFLEXIVE", "TRANSITIVE", "INVERSE_FUNCTIONAL", "POW", "COMMA", "INSTANCE_OF", "TYPES", "DBLQUOTE", "DIGIT", "INTEGER", "LETTER", "IDENTIFIER", "ENTITY_REFERENCE", "QUESTION_MARK", "Tokens", "SUB_CLASS_AXIOM", "EQUIVALENT_TO_AXIOM", "DISJOINT_WITH_AXIOM", "SUB_PROPERTY_AXIOM", "SAME_AS_AXIOM", "DIFFERENT_FROM_AXIOM", "UNARY_AXIOM", "DISJUNCTION", "CONJUNCTION", "PROPERTY_CHAIN", "NEGATED_EXPRESSION", "NEGATED_ASSERTION", "INVERSE_PROPERTY", "SOME_RESTRICTION", "ALL_RESTRICTION", "VALUE_RESTRICTION", "CARDINALITY_RESTRICTION", "ONE_OF", "TYPE_ASSERTION", "ROLE_ASSERTION", "INVERSE_OBJECT_PROPERTY_EXPRESSION", "EXPRESSION", "CONSTANT", "WHERE", "NOT_EQUAL", "EQUAL", "IN", "SELECT", "ASSERTED", "COLON", "DOT", "PLUS", "CREATE", "CREATE_INTERSECTION", "CREATE_DISJUNCTION", "BEGIN", "END", "OPEN_SQUARE_BRACKET", "CLOSED_SQUARE_BRACKET", "SUPER_CLASS_OF", "SUPER_PROPERTY_OF", "VARIABLE_TYPE", "ADD", "REMOVE", "ASSERTED_CLAUSE", "PLAIN_CLAUSE", "INEQUALITY_CONSTRAINT", "IN_SET_CONSTRAINT", "INPUT_VARIABLE_DEFINITION", "GENERATED_VARIABLE_DEFINITION", "CREATE_OPPL_FUNCTION", "VARIABLE_ATTRIBUTE", "OPPL_FUNCTION", "ACTIONS", "VARIABLE_DEFINITIONS", "QUERY", "VARIABLE_SCOPE", "SUBPROPERTY_OF", "VARIABLE_IDENTIFIER", "OPPL_STATEMENT", "DATA_RANGE", "ESCLAMATION_MARK", "CREATE_IDENTIFIER", "PLAIN_IDENTIFIER", "MATCH", "ATTRIBUTE_SELECTOR", "LESS_THAN", "LESS_THAN_EQUAL", "GREATER_THAN", "GREATER_THAN_EQUAL"
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


        public ManchesterOWLSyntaxTypes(TreeNodeStream input) {
            this(input, new RecognizerSharedState());
        }
        public ManchesterOWLSyntaxTypes(TreeNodeStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return ManchesterOWLSyntaxTypes.tokenNames; }
    public String getGrammarFileName() { return "/Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxTypes.g"; }


      private  SymbolTable symtab;
      private  ErrorListener errorListener;
      public ManchesterOWLSyntaxTypes(TreeNodeStream input, SymbolTable symtab, ErrorListener errorListener) {
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
    // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxTypes.g:73:1: bottomup : ( expressionRoot | axiom );
    public final void bottomup() throws RecognitionException {
        try {
            // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxTypes.g:74:5: ( expressionRoot | axiom )
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==EXPRESSION) ) {
                alt1=1;
            }
            else if ( (LA1_0==INVERSE_OF||(LA1_0>=DOMAIN && LA1_0<=RANGE)||(LA1_0>=SUB_CLASS_AXIOM && LA1_0<=UNARY_AXIOM)||LA1_0==NEGATED_ASSERTION||(LA1_0>=TYPE_ASSERTION && LA1_0<=ROLE_ASSERTION)) ) {
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
                    // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxTypes.g:74:9: expressionRoot
                    {
                    pushFollow(FOLLOW_expressionRoot_in_bottomup81);
                    expressionRoot();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxTypes.g:75:8: axiom
                    {
                    pushFollow(FOLLOW_axiom_in_bottomup91);
                    axiom();

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


    // $ANTLR start "expressionRoot"
    // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxTypes.g:78:1: expressionRoot : ^( EXPRESSION expression ) ;
    public final void expressionRoot() throws RecognitionException {
        ManchesterOWLSyntaxTree EXPRESSION1=null;
        ManchesterOWLSyntaxTypes.expression_return expression2 = null;


        try {
            // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxTypes.g:79:5: ( ^( EXPRESSION expression ) )
            // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxTypes.g:79:9: ^( EXPRESSION expression )
            {
            EXPRESSION1=(ManchesterOWLSyntaxTree)match(input,EXPRESSION,FOLLOW_EXPRESSION_in_expressionRoot118); if (state.failed) return ;

            match(input, Token.DOWN, null); if (state.failed) return ;
            pushFollow(FOLLOW_expression_in_expressionRoot120);
            expression2=expression();

            state._fsp--;
            if (state.failed) return ;

            match(input, Token.UP, null); if (state.failed) return ;
            if ( state.backtracking==1 ) {

                  		EXPRESSION1.setEvalType((expression2!=null?expression2.type:null));
                  		EXPRESSION1.setOWLObject((expression2!=null?expression2.owlObject:null));
                  	
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
    // $ANTLR end "expressionRoot"

    public static class axiom_return extends TreeRuleReturnScope {
        public Type type;
        public ManchesterOWLSyntaxTree node;
        public OWLAxiom owlAxiom;
    };

    // $ANTLR start "axiom"
    // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxTypes.g:88:1: axiom returns [Type type, ManchesterOWLSyntaxTree node, OWLAxiom owlAxiom] : ( ^( SUB_CLASS_AXIOM ^( EXPRESSION subClass= expression ) ^( EXPRESSION superClass= expression ) ) | ^( EQUIVALENT_TO_AXIOM ^( EXPRESSION lhs= expression ) ^( EXPRESSION rhs= expression ) ) | ^( INVERSE_OF ^( EXPRESSION p= IDENTIFIER ) ^( EXPRESSION anotherProperty= IDENTIFIER ) ) | ^( DISJOINT_WITH_AXIOM ^( EXPRESSION lhs= expression ) ^( EXPRESSION rhs= expression ) ) | ^( SUB_PROPERTY_AXIOM ^( EXPRESSION subProperty= expression ) ^( EXPRESSION superProperty= unary ) ) | ^( ROLE_ASSERTION ^( EXPRESSION subject= IDENTIFIER ) ^( EXPRESSION predicate= propertyExpression ) ^( EXPRESSION object= unary ) ) | ^( TYPE_ASSERTION ^( EXPRESSION description= expression ) ^( EXPRESSION subject= IDENTIFIER ) ) | ^( DOMAIN ^( EXPRESSION p= IDENTIFIER ) ^( EXPRESSION domain= expression ) ) | ^( RANGE ^( EXPRESSION p= IDENTIFIER ) ^( EXPRESSION range= expression ) ) | ^( SAME_AS_AXIOM ^( EXPRESSION anIndividual= IDENTIFIER ) ^( EXPRESSION anotherIndividual= IDENTIFIER ) ) | ^( DIFFERENT_FROM_AXIOM ^( EXPRESSION anIndividual= IDENTIFIER ) ^( EXPRESSION anotherIndividual= IDENTIFIER ) ) | ^( UNARY_AXIOM FUNCTIONAL ^( EXPRESSION p= IDENTIFIER ) ) | ^( UNARY_AXIOM INVERSE_FUNCTIONAL ^( EXPRESSION p= IDENTIFIER ) ) | ^( UNARY_AXIOM IRREFLEXIVE ^( EXPRESSION p= IDENTIFIER ) ) | ^( UNARY_AXIOM REFLEXIVE ^( EXPRESSION p= IDENTIFIER ) ) | ^( UNARY_AXIOM SYMMETRIC ^( EXPRESSION p= IDENTIFIER ) ) | ^( UNARY_AXIOM TRANSITIVE ^( EXPRESSION p= IDENTIFIER ) ) | ^( NEGATED_ASSERTION a= axiom ) );
    public final ManchesterOWLSyntaxTypes.axiom_return axiom() throws RecognitionException {
        ManchesterOWLSyntaxTypes.axiom_return retval = new ManchesterOWLSyntaxTypes.axiom_return();
        retval.start = input.LT(1);

        ManchesterOWLSyntaxTree p=null;
        ManchesterOWLSyntaxTree anotherProperty=null;
        ManchesterOWLSyntaxTree subject=null;
        ManchesterOWLSyntaxTree anIndividual=null;
        ManchesterOWLSyntaxTree anotherIndividual=null;
        ManchesterOWLSyntaxTypes.expression_return subClass = null;

        ManchesterOWLSyntaxTypes.expression_return superClass = null;

        ManchesterOWLSyntaxTypes.expression_return lhs = null;

        ManchesterOWLSyntaxTypes.expression_return rhs = null;

        ManchesterOWLSyntaxTypes.expression_return subProperty = null;

        ManchesterOWLSyntaxTypes.unary_return superProperty = null;

        ManchesterOWLSyntaxTypes.propertyExpression_return predicate = null;

        ManchesterOWLSyntaxTypes.unary_return object = null;

        ManchesterOWLSyntaxTypes.expression_return description = null;

        ManchesterOWLSyntaxTypes.expression_return domain = null;

        ManchesterOWLSyntaxTypes.expression_return range = null;

        ManchesterOWLSyntaxTypes.axiom_return a = null;


        try {
            // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxTypes.g:95:1: ( ^( SUB_CLASS_AXIOM ^( EXPRESSION subClass= expression ) ^( EXPRESSION superClass= expression ) ) | ^( EQUIVALENT_TO_AXIOM ^( EXPRESSION lhs= expression ) ^( EXPRESSION rhs= expression ) ) | ^( INVERSE_OF ^( EXPRESSION p= IDENTIFIER ) ^( EXPRESSION anotherProperty= IDENTIFIER ) ) | ^( DISJOINT_WITH_AXIOM ^( EXPRESSION lhs= expression ) ^( EXPRESSION rhs= expression ) ) | ^( SUB_PROPERTY_AXIOM ^( EXPRESSION subProperty= expression ) ^( EXPRESSION superProperty= unary ) ) | ^( ROLE_ASSERTION ^( EXPRESSION subject= IDENTIFIER ) ^( EXPRESSION predicate= propertyExpression ) ^( EXPRESSION object= unary ) ) | ^( TYPE_ASSERTION ^( EXPRESSION description= expression ) ^( EXPRESSION subject= IDENTIFIER ) ) | ^( DOMAIN ^( EXPRESSION p= IDENTIFIER ) ^( EXPRESSION domain= expression ) ) | ^( RANGE ^( EXPRESSION p= IDENTIFIER ) ^( EXPRESSION range= expression ) ) | ^( SAME_AS_AXIOM ^( EXPRESSION anIndividual= IDENTIFIER ) ^( EXPRESSION anotherIndividual= IDENTIFIER ) ) | ^( DIFFERENT_FROM_AXIOM ^( EXPRESSION anIndividual= IDENTIFIER ) ^( EXPRESSION anotherIndividual= IDENTIFIER ) ) | ^( UNARY_AXIOM FUNCTIONAL ^( EXPRESSION p= IDENTIFIER ) ) | ^( UNARY_AXIOM INVERSE_FUNCTIONAL ^( EXPRESSION p= IDENTIFIER ) ) | ^( UNARY_AXIOM IRREFLEXIVE ^( EXPRESSION p= IDENTIFIER ) ) | ^( UNARY_AXIOM REFLEXIVE ^( EXPRESSION p= IDENTIFIER ) ) | ^( UNARY_AXIOM SYMMETRIC ^( EXPRESSION p= IDENTIFIER ) ) | ^( UNARY_AXIOM TRANSITIVE ^( EXPRESSION p= IDENTIFIER ) ) | ^( NEGATED_ASSERTION a= axiom ) )
            int alt2=18;
            alt2 = dfa2.predict(input);
            switch (alt2) {
                case 1 :
                    // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxTypes.g:96:3: ^( SUB_CLASS_AXIOM ^( EXPRESSION subClass= expression ) ^( EXPRESSION superClass= expression ) )
                    {
                    match(input,SUB_CLASS_AXIOM,FOLLOW_SUB_CLASS_AXIOM_in_axiom164); if (state.failed) return retval;

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    match(input,EXPRESSION,FOLLOW_EXPRESSION_in_axiom168); if (state.failed) return retval;

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    pushFollow(FOLLOW_expression_in_axiom175);
                    subClass=expression();

                    state._fsp--;
                    if (state.failed) return retval;

                    match(input, Token.UP, null); if (state.failed) return retval;
                    match(input,EXPRESSION,FOLLOW_EXPRESSION_in_axiom180); if (state.failed) return retval;

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    pushFollow(FOLLOW_expression_in_axiom187);
                    superClass=expression();

                    state._fsp--;
                    if (state.failed) return retval;

                    match(input, Token.UP, null); if (state.failed) return retval;

                    match(input, Token.UP, null); if (state.failed) return retval;
                    if ( state.backtracking==1 ) {

                      			retval.type = this.getSymbolTable().getSubClassAxiomType(((ManchesterOWLSyntaxTree)retval.start), subClass.node, superClass.node);
                      			retval.owlAxiom = this.getSymbolTable().getSubClassAxiom(((ManchesterOWLSyntaxTree)retval.start), subClass.node, superClass.node);
                      		
                    }

                    }
                    break;
                case 2 :
                    // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxTypes.g:101:5: ^( EQUIVALENT_TO_AXIOM ^( EXPRESSION lhs= expression ) ^( EXPRESSION rhs= expression ) )
                    {
                    match(input,EQUIVALENT_TO_AXIOM,FOLLOW_EQUIVALENT_TO_AXIOM_in_axiom200); if (state.failed) return retval;

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    match(input,EXPRESSION,FOLLOW_EXPRESSION_in_axiom203); if (state.failed) return retval;

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    pushFollow(FOLLOW_expression_in_axiom209);
                    lhs=expression();

                    state._fsp--;
                    if (state.failed) return retval;

                    match(input, Token.UP, null); if (state.failed) return retval;
                    match(input,EXPRESSION,FOLLOW_EXPRESSION_in_axiom213); if (state.failed) return retval;

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    pushFollow(FOLLOW_expression_in_axiom220);
                    rhs=expression();

                    state._fsp--;
                    if (state.failed) return retval;

                    match(input, Token.UP, null); if (state.failed) return retval;

                    match(input, Token.UP, null); if (state.failed) return retval;
                    if ( state.backtracking==1 ) {

                      	    retval.type = this.getSymbolTable().getEquivalentAxiomType(((ManchesterOWLSyntaxTree)retval.start), lhs.node, rhs.node);
                      	    retval.owlAxiom = this.getSymbolTable().getEquivalentAxiom(((ManchesterOWLSyntaxTree)retval.start), lhs.node, rhs.node);
                      	   
                    }

                    }
                    break;
                case 3 :
                    // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxTypes.g:106:4: ^( INVERSE_OF ^( EXPRESSION p= IDENTIFIER ) ^( EXPRESSION anotherProperty= IDENTIFIER ) )
                    {
                    match(input,INVERSE_OF,FOLLOW_INVERSE_OF_in_axiom235); if (state.failed) return retval;

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    match(input,EXPRESSION,FOLLOW_EXPRESSION_in_axiom238); if (state.failed) return retval;

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    p=(ManchesterOWLSyntaxTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_axiom244); if (state.failed) return retval;

                    match(input, Token.UP, null); if (state.failed) return retval;
                    match(input,EXPRESSION,FOLLOW_EXPRESSION_in_axiom248); if (state.failed) return retval;

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    anotherProperty=(ManchesterOWLSyntaxTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_axiom254); if (state.failed) return retval;

                    match(input, Token.UP, null); if (state.failed) return retval;

                    match(input, Token.UP, null); if (state.failed) return retval;
                    if ( state.backtracking==1 ) {

                      	   retval.type = this.getSymbolTable().getInverseOfAxiomType(((ManchesterOWLSyntaxTree)retval.start), p, anotherProperty);
                      	   retval.owlAxiom = this.getSymbolTable().getInverseOfAxiom(((ManchesterOWLSyntaxTree)retval.start), p, anotherProperty);
                      	
                    }

                    }
                    break;
                case 4 :
                    // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxTypes.g:111:5: ^( DISJOINT_WITH_AXIOM ^( EXPRESSION lhs= expression ) ^( EXPRESSION rhs= expression ) )
                    {
                    match(input,DISJOINT_WITH_AXIOM,FOLLOW_DISJOINT_WITH_AXIOM_in_axiom266); if (state.failed) return retval;

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    match(input,EXPRESSION,FOLLOW_EXPRESSION_in_axiom269); if (state.failed) return retval;

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    pushFollow(FOLLOW_expression_in_axiom276);
                    lhs=expression();

                    state._fsp--;
                    if (state.failed) return retval;

                    match(input, Token.UP, null); if (state.failed) return retval;
                    match(input,EXPRESSION,FOLLOW_EXPRESSION_in_axiom280); if (state.failed) return retval;

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    pushFollow(FOLLOW_expression_in_axiom286);
                    rhs=expression();

                    state._fsp--;
                    if (state.failed) return retval;

                    match(input, Token.UP, null); if (state.failed) return retval;

                    match(input, Token.UP, null); if (state.failed) return retval;
                    if ( state.backtracking==1 ) {

                           retval.type = this.getSymbolTable().getDisjointAxiomType(((ManchesterOWLSyntaxTree)retval.start), lhs.node, rhs.node);
                           retval.owlAxiom = this.getSymbolTable().getDisjointAxiom(((ManchesterOWLSyntaxTree)retval.start), lhs.node, rhs.node);
                        
                    }

                    }
                    break;
                case 5 :
                    // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxTypes.g:115:4: ^( SUB_PROPERTY_AXIOM ^( EXPRESSION subProperty= expression ) ^( EXPRESSION superProperty= unary ) )
                    {
                    match(input,SUB_PROPERTY_AXIOM,FOLLOW_SUB_PROPERTY_AXIOM_in_axiom298); if (state.failed) return retval;

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    match(input,EXPRESSION,FOLLOW_EXPRESSION_in_axiom301); if (state.failed) return retval;

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    pushFollow(FOLLOW_expression_in_axiom308);
                    subProperty=expression();

                    state._fsp--;
                    if (state.failed) return retval;

                    match(input, Token.UP, null); if (state.failed) return retval;
                    match(input,EXPRESSION,FOLLOW_EXPRESSION_in_axiom312); if (state.failed) return retval;

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    pushFollow(FOLLOW_unary_in_axiom318);
                    superProperty=unary();

                    state._fsp--;
                    if (state.failed) return retval;

                    match(input, Token.UP, null); if (state.failed) return retval;

                    match(input, Token.UP, null); if (state.failed) return retval;
                    if ( state.backtracking==1 ) {

                      			retval.type = this.getSymbolTable().getSubPropertyAxiomType(((ManchesterOWLSyntaxTree)retval.start), subProperty.node, superProperty.node);
                      			retval.owlAxiom = this.getSymbolTable().getSubPropertyAxiom(((ManchesterOWLSyntaxTree)retval.start), subProperty.node, superProperty.node);
                      		
                    }

                    }
                    break;
                case 6 :
                    // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxTypes.g:120:4: ^( ROLE_ASSERTION ^( EXPRESSION subject= IDENTIFIER ) ^( EXPRESSION predicate= propertyExpression ) ^( EXPRESSION object= unary ) )
                    {
                    match(input,ROLE_ASSERTION,FOLLOW_ROLE_ASSERTION_in_axiom332); if (state.failed) return retval;

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    match(input,EXPRESSION,FOLLOW_EXPRESSION_in_axiom335); if (state.failed) return retval;

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    subject=(ManchesterOWLSyntaxTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_axiom342); if (state.failed) return retval;

                    match(input, Token.UP, null); if (state.failed) return retval;
                    match(input,EXPRESSION,FOLLOW_EXPRESSION_in_axiom346); if (state.failed) return retval;

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    pushFollow(FOLLOW_propertyExpression_in_axiom353);
                    predicate=propertyExpression();

                    state._fsp--;
                    if (state.failed) return retval;

                    match(input, Token.UP, null); if (state.failed) return retval;
                    match(input,EXPRESSION,FOLLOW_EXPRESSION_in_axiom357); if (state.failed) return retval;

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    pushFollow(FOLLOW_unary_in_axiom363);
                    object=unary();

                    state._fsp--;
                    if (state.failed) return retval;

                    match(input, Token.UP, null); if (state.failed) return retval;

                    match(input, Token.UP, null); if (state.failed) return retval;
                    if ( state.backtracking==1 ) {

                      	   retval.type = this.getSymbolTable().getRoleAssertionAxiomType(((ManchesterOWLSyntaxTree)retval.start), subject, predicate.node, object.node);
                      	   retval.owlAxiom = this.getSymbolTable().getRoleAssertionAxiom(((ManchesterOWLSyntaxTree)retval.start), subject, predicate.node, object.node);
                      	 
                    }

                    }
                    break;
                case 7 :
                    // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxTypes.g:124:5: ^( TYPE_ASSERTION ^( EXPRESSION description= expression ) ^( EXPRESSION subject= IDENTIFIER ) )
                    {
                    match(input,TYPE_ASSERTION,FOLLOW_TYPE_ASSERTION_in_axiom373); if (state.failed) return retval;

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    match(input,EXPRESSION,FOLLOW_EXPRESSION_in_axiom376); if (state.failed) return retval;

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    pushFollow(FOLLOW_expression_in_axiom383);
                    description=expression();

                    state._fsp--;
                    if (state.failed) return retval;

                    match(input, Token.UP, null); if (state.failed) return retval;
                    match(input,EXPRESSION,FOLLOW_EXPRESSION_in_axiom387); if (state.failed) return retval;

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    subject=(ManchesterOWLSyntaxTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_axiom393); if (state.failed) return retval;

                    match(input, Token.UP, null); if (state.failed) return retval;

                    match(input, Token.UP, null); if (state.failed) return retval;
                    if ( state.backtracking==1 ) {

                      	   retval.type = this.getSymbolTable().getClassAssertionAxiomType(((ManchesterOWLSyntaxTree)retval.start),description.node, subject);
                      	   retval.owlAxiom = this.getSymbolTable().getClassAssertionAxiom(((ManchesterOWLSyntaxTree)retval.start),description.node, subject);
                      	
                    }

                    }
                    break;
                case 8 :
                    // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxTypes.g:129:4: ^( DOMAIN ^( EXPRESSION p= IDENTIFIER ) ^( EXPRESSION domain= expression ) )
                    {
                    match(input,DOMAIN,FOLLOW_DOMAIN_in_axiom405); if (state.failed) return retval;

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    match(input,EXPRESSION,FOLLOW_EXPRESSION_in_axiom408); if (state.failed) return retval;

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    p=(ManchesterOWLSyntaxTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_axiom414); if (state.failed) return retval;

                    match(input, Token.UP, null); if (state.failed) return retval;
                    match(input,EXPRESSION,FOLLOW_EXPRESSION_in_axiom418); if (state.failed) return retval;

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    pushFollow(FOLLOW_expression_in_axiom424);
                    domain=expression();

                    state._fsp--;
                    if (state.failed) return retval;

                    match(input, Token.UP, null); if (state.failed) return retval;

                    match(input, Token.UP, null); if (state.failed) return retval;
                    if ( state.backtracking==1 ) {

                      	   retval.type = this.getSymbolTable().getDomainAxiomType(((ManchesterOWLSyntaxTree)retval.start), p, domain.node);
                      	   retval.owlAxiom =  this.getSymbolTable().getDomainAxiom(((ManchesterOWLSyntaxTree)retval.start), p, domain.node);
                      	 
                    }

                    }
                    break;
                case 9 :
                    // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxTypes.g:134:5: ^( RANGE ^( EXPRESSION p= IDENTIFIER ) ^( EXPRESSION range= expression ) )
                    {
                    match(input,RANGE,FOLLOW_RANGE_in_axiom437); if (state.failed) return retval;

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    match(input,EXPRESSION,FOLLOW_EXPRESSION_in_axiom440); if (state.failed) return retval;

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    p=(ManchesterOWLSyntaxTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_axiom446); if (state.failed) return retval;

                    match(input, Token.UP, null); if (state.failed) return retval;
                    match(input,EXPRESSION,FOLLOW_EXPRESSION_in_axiom450); if (state.failed) return retval;

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    pushFollow(FOLLOW_expression_in_axiom456);
                    range=expression();

                    state._fsp--;
                    if (state.failed) return retval;

                    match(input, Token.UP, null); if (state.failed) return retval;

                    match(input, Token.UP, null); if (state.failed) return retval;
                    if ( state.backtracking==1 ) {

                           retval.type = this.getSymbolTable().getRangeAxiomType(((ManchesterOWLSyntaxTree)retval.start), p, range.node);
                           retval.owlAxiom =  this.getSymbolTable().getRangeAxiom(((ManchesterOWLSyntaxTree)retval.start), p, range.node);
                         
                    }

                    }
                    break;
                case 10 :
                    // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxTypes.g:139:6: ^( SAME_AS_AXIOM ^( EXPRESSION anIndividual= IDENTIFIER ) ^( EXPRESSION anotherIndividual= IDENTIFIER ) )
                    {
                    match(input,SAME_AS_AXIOM,FOLLOW_SAME_AS_AXIOM_in_axiom471); if (state.failed) return retval;

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    match(input,EXPRESSION,FOLLOW_EXPRESSION_in_axiom474); if (state.failed) return retval;

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    anIndividual=(ManchesterOWLSyntaxTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_axiom479); if (state.failed) return retval;

                    match(input, Token.UP, null); if (state.failed) return retval;
                    match(input,EXPRESSION,FOLLOW_EXPRESSION_in_axiom483); if (state.failed) return retval;

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    anotherIndividual=(ManchesterOWLSyntaxTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_axiom489); if (state.failed) return retval;

                    match(input, Token.UP, null); if (state.failed) return retval;

                    match(input, Token.UP, null); if (state.failed) return retval;
                    if ( state.backtracking==1 ) {

                          retval.type = this.getSymbolTable().getSameIndividualsAxiomType(((ManchesterOWLSyntaxTree)retval.start), anIndividual, anotherIndividual);
                          retval.owlAxiom =  this.getSymbolTable().getSameIndividualsAxiom(((ManchesterOWLSyntaxTree)retval.start), anIndividual, anotherIndividual);
                         
                    }

                    }
                    break;
                case 11 :
                    // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxTypes.g:144:7: ^( DIFFERENT_FROM_AXIOM ^( EXPRESSION anIndividual= IDENTIFIER ) ^( EXPRESSION anotherIndividual= IDENTIFIER ) )
                    {
                    match(input,DIFFERENT_FROM_AXIOM,FOLLOW_DIFFERENT_FROM_AXIOM_in_axiom505); if (state.failed) return retval;

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    match(input,EXPRESSION,FOLLOW_EXPRESSION_in_axiom508); if (state.failed) return retval;

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    anIndividual=(ManchesterOWLSyntaxTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_axiom513); if (state.failed) return retval;

                    match(input, Token.UP, null); if (state.failed) return retval;
                    match(input,EXPRESSION,FOLLOW_EXPRESSION_in_axiom517); if (state.failed) return retval;

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    anotherIndividual=(ManchesterOWLSyntaxTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_axiom523); if (state.failed) return retval;

                    match(input, Token.UP, null); if (state.failed) return retval;

                    match(input, Token.UP, null); if (state.failed) return retval;
                    if ( state.backtracking==1 ) {

                          retval.type = this.getSymbolTable().getDifferentIndividualsAxiomType(((ManchesterOWLSyntaxTree)retval.start), anIndividual, anotherIndividual);
                          retval.owlAxiom =  this.getSymbolTable().getDifferentIndividualsAxiom(((ManchesterOWLSyntaxTree)retval.start), anIndividual, anotherIndividual);
                         
                    }

                    }
                    break;
                case 12 :
                    // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxTypes.g:149:5: ^( UNARY_AXIOM FUNCTIONAL ^( EXPRESSION p= IDENTIFIER ) )
                    {
                    match(input,UNARY_AXIOM,FOLLOW_UNARY_AXIOM_in_axiom537); if (state.failed) return retval;

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    match(input,FUNCTIONAL,FOLLOW_FUNCTIONAL_in_axiom539); if (state.failed) return retval;
                    match(input,EXPRESSION,FOLLOW_EXPRESSION_in_axiom542); if (state.failed) return retval;

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    p=(ManchesterOWLSyntaxTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_axiom548); if (state.failed) return retval;

                    match(input, Token.UP, null); if (state.failed) return retval;

                    match(input, Token.UP, null); if (state.failed) return retval;
                    if ( state.backtracking==1 ) {

                      	   retval.type = this.getSymbolTable().getFunctionalPropertyType(((ManchesterOWLSyntaxTree)retval.start), p);
                      	   retval.owlAxiom =  this.getSymbolTable().getFunctionalProperty(((ManchesterOWLSyntaxTree)retval.start), p);
                      	 
                    }

                    }
                    break;
                case 13 :
                    // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxTypes.g:154:5: ^( UNARY_AXIOM INVERSE_FUNCTIONAL ^( EXPRESSION p= IDENTIFIER ) )
                    {
                    match(input,UNARY_AXIOM,FOLLOW_UNARY_AXIOM_in_axiom561); if (state.failed) return retval;

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    match(input,INVERSE_FUNCTIONAL,FOLLOW_INVERSE_FUNCTIONAL_in_axiom563); if (state.failed) return retval;
                    match(input,EXPRESSION,FOLLOW_EXPRESSION_in_axiom566); if (state.failed) return retval;

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    p=(ManchesterOWLSyntaxTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_axiom572); if (state.failed) return retval;

                    match(input, Token.UP, null); if (state.failed) return retval;

                    match(input, Token.UP, null); if (state.failed) return retval;
                    if ( state.backtracking==1 ) {

                           retval.type = this.getSymbolTable().getInverseFunctionalPropertyType(((ManchesterOWLSyntaxTree)retval.start), p);
                           retval.owlAxiom =  this.getSymbolTable().getInverseFunctionalProperty(((ManchesterOWLSyntaxTree)retval.start), p);
                         
                    }

                    }
                    break;
                case 14 :
                    // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxTypes.g:159:7: ^( UNARY_AXIOM IRREFLEXIVE ^( EXPRESSION p= IDENTIFIER ) )
                    {
                    match(input,UNARY_AXIOM,FOLLOW_UNARY_AXIOM_in_axiom588); if (state.failed) return retval;

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    match(input,IRREFLEXIVE,FOLLOW_IRREFLEXIVE_in_axiom590); if (state.failed) return retval;
                    match(input,EXPRESSION,FOLLOW_EXPRESSION_in_axiom593); if (state.failed) return retval;

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    p=(ManchesterOWLSyntaxTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_axiom599); if (state.failed) return retval;

                    match(input, Token.UP, null); if (state.failed) return retval;

                    match(input, Token.UP, null); if (state.failed) return retval;
                    if ( state.backtracking==1 ) {

                           retval.type = this.getSymbolTable().getIrreflexivePropertyType(((ManchesterOWLSyntaxTree)retval.start), p);
                           retval.owlAxiom =  this.getSymbolTable().getIrreflexiveProperty(((ManchesterOWLSyntaxTree)retval.start), p);
                         
                    }

                    }
                    break;
                case 15 :
                    // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxTypes.g:164:6: ^( UNARY_AXIOM REFLEXIVE ^( EXPRESSION p= IDENTIFIER ) )
                    {
                    match(input,UNARY_AXIOM,FOLLOW_UNARY_AXIOM_in_axiom614); if (state.failed) return retval;

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    match(input,REFLEXIVE,FOLLOW_REFLEXIVE_in_axiom616); if (state.failed) return retval;
                    match(input,EXPRESSION,FOLLOW_EXPRESSION_in_axiom619); if (state.failed) return retval;

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    p=(ManchesterOWLSyntaxTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_axiom625); if (state.failed) return retval;

                    match(input, Token.UP, null); if (state.failed) return retval;

                    match(input, Token.UP, null); if (state.failed) return retval;
                    if ( state.backtracking==1 ) {

                           retval.type = this.getSymbolTable().getReflexivePropertyType(((ManchesterOWLSyntaxTree)retval.start), p);
                           retval.owlAxiom =  this.getSymbolTable().getReflexiveProperty(((ManchesterOWLSyntaxTree)retval.start), p);
                         
                    }

                    }
                    break;
                case 16 :
                    // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxTypes.g:169:6: ^( UNARY_AXIOM SYMMETRIC ^( EXPRESSION p= IDENTIFIER ) )
                    {
                    match(input,UNARY_AXIOM,FOLLOW_UNARY_AXIOM_in_axiom640); if (state.failed) return retval;

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    match(input,SYMMETRIC,FOLLOW_SYMMETRIC_in_axiom642); if (state.failed) return retval;
                    match(input,EXPRESSION,FOLLOW_EXPRESSION_in_axiom645); if (state.failed) return retval;

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    p=(ManchesterOWLSyntaxTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_axiom651); if (state.failed) return retval;

                    match(input, Token.UP, null); if (state.failed) return retval;

                    match(input, Token.UP, null); if (state.failed) return retval;
                    if ( state.backtracking==1 ) {

                           retval.type = this.getSymbolTable().getSymmetricPropertyType(((ManchesterOWLSyntaxTree)retval.start), p);
                           retval.owlAxiom =  this.getSymbolTable().getSymmetricProperty(((ManchesterOWLSyntaxTree)retval.start), p);
                         
                    }

                    }
                    break;
                case 17 :
                    // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxTypes.g:174:7: ^( UNARY_AXIOM TRANSITIVE ^( EXPRESSION p= IDENTIFIER ) )
                    {
                    match(input,UNARY_AXIOM,FOLLOW_UNARY_AXIOM_in_axiom668); if (state.failed) return retval;

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    match(input,TRANSITIVE,FOLLOW_TRANSITIVE_in_axiom670); if (state.failed) return retval;
                    match(input,EXPRESSION,FOLLOW_EXPRESSION_in_axiom673); if (state.failed) return retval;

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    p=(ManchesterOWLSyntaxTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_axiom679); if (state.failed) return retval;

                    match(input, Token.UP, null); if (state.failed) return retval;

                    match(input, Token.UP, null); if (state.failed) return retval;
                    if ( state.backtracking==1 ) {

                           retval.type = this.getSymbolTable().getTransitivePropertyType(((ManchesterOWLSyntaxTree)retval.start), p);
                           retval.owlAxiom =  this.getSymbolTable().getTransitiveProperty(((ManchesterOWLSyntaxTree)retval.start), p);
                         
                    }

                    }
                    break;
                case 18 :
                    // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxTypes.g:179:6: ^( NEGATED_ASSERTION a= axiom )
                    {
                    match(input,NEGATED_ASSERTION,FOLLOW_NEGATED_ASSERTION_in_axiom694); if (state.failed) return retval;

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    pushFollow(FOLLOW_axiom_in_axiom699);
                    a=axiom();

                    state._fsp--;
                    if (state.failed) return retval;

                    match(input, Token.UP, null); if (state.failed) return retval;
                    if ( state.backtracking==1 ) {

                           retval.type = this.getSymbolTable().getNegatedAssertionType(((ManchesterOWLSyntaxTree)retval.start), a.node);
                           retval.owlAxiom =  this.getSymbolTable().getNegatedAssertion(((ManchesterOWLSyntaxTree)retval.start), a.node);
                         
                    }

                    }
                    break;

            }
            if ( state.backtracking==1 ) {

              				((ManchesterOWLSyntaxTree)retval.start).setEvalType(retval.type); 
              				retval.node = ((ManchesterOWLSyntaxTree)retval.start);
              				((ManchesterOWLSyntaxTree)retval.start).setOWLObject(retval.owlAxiom); 
              			
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
    // $ANTLR end "axiom"

    public static class expression_return extends TreeRuleReturnScope {
        public Type type;
        public ManchesterOWLSyntaxTree node;
        public OWLObject owlObject;
    };

    // $ANTLR start "expression"
    // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxTypes.g:185:1: expression returns [Type type, ManchesterOWLSyntaxTree node, OWLObject owlObject] : ( ^( DISJUNCTION (disjuncts+= conjunction )+ ) | ^( PROPERTY_CHAIN (chainItems+= expression )+ ) | conjunction | complexPropertyExpression );
    public final ManchesterOWLSyntaxTypes.expression_return expression() throws RecognitionException {
        ManchesterOWLSyntaxTypes.expression_return retval = new ManchesterOWLSyntaxTypes.expression_return();
        retval.start = input.LT(1);

        List list_disjuncts=null;
        List list_chainItems=null;
        ManchesterOWLSyntaxTypes.conjunction_return conjunction3 = null;

        ManchesterOWLSyntaxTypes.complexPropertyExpression_return complexPropertyExpression4 = null;

        RuleReturnScope disjuncts = null;
        RuleReturnScope chainItems = null;
        try {
            // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxTypes.g:192:2: ( ^( DISJUNCTION (disjuncts+= conjunction )+ ) | ^( PROPERTY_CHAIN (chainItems+= expression )+ ) | conjunction | complexPropertyExpression )
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
            case DATA_RANGE:
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
                    // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxTypes.g:193:4: ^( DISJUNCTION (disjuncts+= conjunction )+ )
                    {
                    match(input,DISJUNCTION,FOLLOW_DISJUNCTION_in_expression735); if (state.failed) return retval;

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxTypes.g:193:29: (disjuncts+= conjunction )+
                    int cnt3=0;
                    loop3:
                    do {
                        int alt3=2;
                        int LA3_0 = input.LA(1);

                        if ( ((LA3_0>=IDENTIFIER && LA3_0<=ENTITY_REFERENCE)||LA3_0==CONJUNCTION||LA3_0==NEGATED_EXPRESSION||(LA3_0>=SOME_RESTRICTION && LA3_0<=ONE_OF)||LA3_0==CONSTANT||LA3_0==DATA_RANGE) ) {
                            alt3=1;
                        }


                        switch (alt3) {
                    	case 1 :
                    	    // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxTypes.g:193:29: disjuncts+= conjunction
                    	    {
                    	    pushFollow(FOLLOW_conjunction_in_expression741);
                    	    disjuncts=conjunction();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if (list_disjuncts==null) list_disjuncts=new ArrayList();
                    	    list_disjuncts.add(disjuncts);


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
                    // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxTypes.g:202:6: ^( PROPERTY_CHAIN (chainItems+= expression )+ )
                    {
                    match(input,PROPERTY_CHAIN,FOLLOW_PROPERTY_CHAIN_in_expression757); if (state.failed) return retval;

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxTypes.g:202:34: (chainItems+= expression )+
                    int cnt4=0;
                    loop4:
                    do {
                        int alt4=2;
                        int LA4_0 = input.LA(1);

                        if ( ((LA4_0>=IDENTIFIER && LA4_0<=ENTITY_REFERENCE)||(LA4_0>=DISJUNCTION && LA4_0<=NEGATED_EXPRESSION)||(LA4_0>=SOME_RESTRICTION && LA4_0<=ONE_OF)||LA4_0==INVERSE_OBJECT_PROPERTY_EXPRESSION||LA4_0==CONSTANT||LA4_0==DATA_RANGE) ) {
                            alt4=1;
                        }


                        switch (alt4) {
                    	case 1 :
                    	    // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxTypes.g:202:34: chainItems+= expression
                    	    {
                    	    pushFollow(FOLLOW_expression_in_expression762);
                    	    chainItems=expression();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if (list_chainItems==null) list_chainItems=new ArrayList();
                    	    list_chainItems.add(chainItems);


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
                    // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxTypes.g:211:5: conjunction
                    {
                    pushFollow(FOLLOW_conjunction_in_expression776);
                    conjunction3=conjunction();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==1 ) {

                      			retval.type = (conjunction3!=null?conjunction3.type:null);
                      			retval.owlObject = (conjunction3!=null?conjunction3.owlObject:null);
                      		
                    }

                    }
                    break;
                case 4 :
                    // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxTypes.g:216:5: complexPropertyExpression
                    {
                    pushFollow(FOLLOW_complexPropertyExpression_in_expression788);
                    complexPropertyExpression4=complexPropertyExpression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==1 ) {

                      			retval.type = (complexPropertyExpression4!=null?complexPropertyExpression4.type:null);
                      			retval.owlObject = (complexPropertyExpression4!=null?complexPropertyExpression4.owlObject:null);
                      		
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
    // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxTypes.g:224:1: conjunction returns [Type type, ManchesterOWLSyntaxTree node, OWLObject owlObject] : ( ^( CONJUNCTION (conjuncts+= unary )+ ) | unary );
    public final ManchesterOWLSyntaxTypes.conjunction_return conjunction() throws RecognitionException {
        ManchesterOWLSyntaxTypes.conjunction_return retval = new ManchesterOWLSyntaxTypes.conjunction_return();
        retval.start = input.LT(1);

        List list_conjuncts=null;
        ManchesterOWLSyntaxTypes.unary_return unary5 = null;

        RuleReturnScope conjuncts = null;
        try {
            // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxTypes.g:231:2: ( ^( CONJUNCTION (conjuncts+= unary )+ ) | unary )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==CONJUNCTION) ) {
                alt7=1;
            }
            else if ( ((LA7_0>=IDENTIFIER && LA7_0<=ENTITY_REFERENCE)||LA7_0==NEGATED_EXPRESSION||(LA7_0>=SOME_RESTRICTION && LA7_0<=ONE_OF)||LA7_0==CONSTANT||LA7_0==DATA_RANGE) ) {
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
                    // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxTypes.g:232:2: ^( CONJUNCTION (conjuncts+= unary )+ )
                    {
                    match(input,CONJUNCTION,FOLLOW_CONJUNCTION_in_conjunction825); if (state.failed) return retval;

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxTypes.g:232:26: (conjuncts+= unary )+
                    int cnt6=0;
                    loop6:
                    do {
                        int alt6=2;
                        int LA6_0 = input.LA(1);

                        if ( ((LA6_0>=IDENTIFIER && LA6_0<=ENTITY_REFERENCE)||LA6_0==NEGATED_EXPRESSION||(LA6_0>=SOME_RESTRICTION && LA6_0<=ONE_OF)||LA6_0==CONSTANT||LA6_0==DATA_RANGE) ) {
                            alt6=1;
                        }


                        switch (alt6) {
                    	case 1 :
                    	    // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxTypes.g:232:26: conjuncts+= unary
                    	    {
                    	    pushFollow(FOLLOW_unary_in_conjunction830);
                    	    conjuncts=unary();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if (list_conjuncts==null) list_conjuncts=new ArrayList();
                    	    list_conjuncts.add(conjuncts);


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
                    // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxTypes.g:241:4: unary
                    {
                    pushFollow(FOLLOW_unary_in_conjunction841);
                    unary5=unary();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==1 ) {

                      		retval.type = (unary5!=null?unary5.type:null);
                      		retval.owlObject = (unary5!=null?unary5.owlObject:null);
                      	
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
    // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxTypes.g:247:1: unary returns [Type type, ManchesterOWLSyntaxTree node, OWLObject owlObject] : ( IDENTIFIER | ^( NEGATED_EXPRESSION e= expression ) | qualifiedRestriction | ENTITY_REFERENCE | ^( CONSTANT value= . (constantType= IDENTIFIER )? ) | dataRange );
    public final ManchesterOWLSyntaxTypes.unary_return unary() throws RecognitionException {
        ManchesterOWLSyntaxTypes.unary_return retval = new ManchesterOWLSyntaxTypes.unary_return();
        retval.start = input.LT(1);

        ManchesterOWLSyntaxTree constantType=null;
        ManchesterOWLSyntaxTree IDENTIFIER6=null;
        ManchesterOWLSyntaxTree ENTITY_REFERENCE8=null;
        ManchesterOWLSyntaxTree value=null;
        ManchesterOWLSyntaxTypes.expression_return e = null;

        ManchesterOWLSyntaxTypes.qualifiedRestriction_return qualifiedRestriction7 = null;

        ManchesterOWLSyntaxTypes.dataRange_return dataRange9 = null;


        try {
            // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxTypes.g:254:1: ( IDENTIFIER | ^( NEGATED_EXPRESSION e= expression ) | qualifiedRestriction | ENTITY_REFERENCE | ^( CONSTANT value= . (constantType= IDENTIFIER )? ) | dataRange )
            int alt9=6;
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
            case DATA_RANGE:
                {
                alt9=6;
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
                    // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxTypes.g:255:3: IDENTIFIER
                    {
                    IDENTIFIER6=(ManchesterOWLSyntaxTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_unary868); if (state.failed) return retval;
                    if ( state.backtracking==1 ) {

                      				Symbol symbol = this.getSymbolTable().resolve(IDENTIFIER6);
                      				retval.type = symbol==null ? null: symbol.getType();
                      				retval.owlObject = this.getSymbolTable().getOWLObject(IDENTIFIER6);
                      			
                    }

                    }
                    break;
                case 2 :
                    // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxTypes.g:261:5: ^( NEGATED_EXPRESSION e= expression )
                    {
                    match(input,NEGATED_EXPRESSION,FOLLOW_NEGATED_EXPRESSION_in_unary881); if (state.failed) return retval;

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    pushFollow(FOLLOW_expression_in_unary887);
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
                    // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxTypes.g:266:5: qualifiedRestriction
                    {
                    pushFollow(FOLLOW_qualifiedRestriction_in_unary901);
                    qualifiedRestriction7=qualifiedRestriction();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==1 ) {

                      				retval.type = (qualifiedRestriction7!=null?qualifiedRestriction7.type:null);
                      				retval.owlObject = (qualifiedRestriction7!=null?qualifiedRestriction7.owlObject:null);
                      			
                    }

                    }
                    break;
                case 4 :
                    // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxTypes.g:271:5: ENTITY_REFERENCE
                    {
                    ENTITY_REFERENCE8=(ManchesterOWLSyntaxTree)match(input,ENTITY_REFERENCE,FOLLOW_ENTITY_REFERENCE_in_unary915); if (state.failed) return retval;
                    if ( state.backtracking==1 ) {

                      				Symbol symbol = this.getSymbolTable().resolve(ENTITY_REFERENCE8);
                      				retval.type = symbol==null ? null: symbol.getType();
                      				retval.owlObject = this.getSymbolTable().getOWLObject(ENTITY_REFERENCE8);
                      			
                    }

                    }
                    break;
                case 5 :
                    // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxTypes.g:277:5: ^( CONSTANT value= . (constantType= IDENTIFIER )? )
                    {
                    match(input,CONSTANT,FOLLOW_CONSTANT_in_unary928); if (state.failed) return retval;

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    value=(ManchesterOWLSyntaxTree)input.LT(1);
                    matchAny(input); if (state.failed) return retval;
                    // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxTypes.g:277:38: (constantType= IDENTIFIER )?
                    int alt8=2;
                    int LA8_0 = input.LA(1);

                    if ( (LA8_0==IDENTIFIER) ) {
                        alt8=1;
                    }
                    switch (alt8) {
                        case 1 :
                            // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxTypes.g:277:38: constantType= IDENTIFIER
                            {
                            constantType=(ManchesterOWLSyntaxTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_unary939); if (state.failed) return retval;

                            }
                            break;

                    }


                    match(input, Token.UP, null); if (state.failed) return retval;
                    if ( state.backtracking==1 ) {

                      				retval.type = OWLType.OWL_CONSTANT;
                      				retval.owlObject = constantType ==null ? this.getSymbolTable().getOWLUntypedConstant(((ManchesterOWLSyntaxTree)retval.start),value) : this.getSymbolTable().getOWLTypedConstant(((ManchesterOWLSyntaxTree)retval.start),value, constantType);				
                      			
                    }

                    }
                    break;
                case 6 :
                    // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxTypes.g:281:5: dataRange
                    {
                    pushFollow(FOLLOW_dataRange_in_unary949);
                    dataRange9=dataRange();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==1 ) {

                      				retval.type = (dataRange9!=null?dataRange9.type:null);
                      				retval.owlObject = (dataRange9!=null?dataRange9.owlObject:null);
                      		
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

    public static class dataRange_return extends TreeRuleReturnScope {
        public Type type;
        public ManchesterOWLSyntaxTree node;
        public OWLObject owlObject;
    };

    // $ANTLR start "dataRange"
    // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxTypes.g:287:1: dataRange returns [Type type, ManchesterOWLSyntaxTree node, OWLObject owlObject] : ^( DATA_RANGE dataType= unary (f= facet )* ) ;
    public final ManchesterOWLSyntaxTypes.dataRange_return dataRange() throws RecognitionException {
        ManchesterOWLSyntaxTypes.dataRange_return retval = new ManchesterOWLSyntaxTypes.dataRange_return();
        retval.start = input.LT(1);

        ManchesterOWLSyntaxTypes.unary_return dataType = null;

        ManchesterOWLSyntaxTypes.facet_return f = null;



        	List<ManchesterOWLSyntaxTree> facets = new ArrayList<ManchesterOWLSyntaxTree>(); 

        try {
            // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxTypes.g:298:2: ( ^( DATA_RANGE dataType= unary (f= facet )* ) )
            // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxTypes.g:300:3: ^( DATA_RANGE dataType= unary (f= facet )* )
            {
            match(input,DATA_RANGE,FOLLOW_DATA_RANGE_in_dataRange986); if (state.failed) return retval;

            match(input, Token.DOWN, null); if (state.failed) return retval;
            pushFollow(FOLLOW_unary_in_dataRange992);
            dataType=unary();

            state._fsp--;
            if (state.failed) return retval;
            // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxTypes.g:300:33: (f= facet )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( ((LA10_0>=LESS_THAN && LA10_0<=GREATER_THAN_EQUAL)) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxTypes.g:300:34: f= facet
            	    {
            	    pushFollow(FOLLOW_facet_in_dataRange997);
            	    f=facet();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==1 ) {

            	      			facets.add(f.node);
            	      			
            	      		
            	    }

            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);


            match(input, Token.UP, null); if (state.failed) return retval;
            if ( state.backtracking==1 ) {

              			retval.type = getSymbolTable().getOWLDataRangeType((dataType!=null?dataType.node:null), ((ManchesterOWLSyntaxTree)retval.start), facets.toArray(new ManchesterOWLSyntaxTree[facets.size()]));
              			retval.owlObject = getSymbolTable().getOWLDataRange((dataType!=null?dataType.node:null), ((ManchesterOWLSyntaxTree)retval.start), facets.toArray(new ManchesterOWLSyntaxTree[facets.size()]));
              		
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
    // $ANTLR end "dataRange"

    public static class facet_return extends TreeRuleReturnScope {
        public Type type;
        public ManchesterOWLSyntaxTree node;
        public OWLObject owlObject;
    };

    // $ANTLR start "facet"
    // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxTypes.g:311:1: facet returns [Type type, ManchesterOWLSyntaxTree node, OWLObject owlObject] : ( ^(f= LESS_THAN value= unary ) | ^(f= LESS_THAN_EQUAL value= unary ) | ^(f= GREATER_THAN value= unary ) | ^(f= GREATER_THAN_EQUAL value= unary ) );
    public final ManchesterOWLSyntaxTypes.facet_return facet() throws RecognitionException {
        ManchesterOWLSyntaxTypes.facet_return retval = new ManchesterOWLSyntaxTypes.facet_return();
        retval.start = input.LT(1);

        ManchesterOWLSyntaxTree f=null;
        ManchesterOWLSyntaxTypes.unary_return value = null;


        try {
            // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxTypes.g:320:2: ( ^(f= LESS_THAN value= unary ) | ^(f= LESS_THAN_EQUAL value= unary ) | ^(f= GREATER_THAN value= unary ) | ^(f= GREATER_THAN_EQUAL value= unary ) )
            int alt11=4;
            switch ( input.LA(1) ) {
            case LESS_THAN:
                {
                alt11=1;
                }
                break;
            case LESS_THAN_EQUAL:
                {
                alt11=2;
                }
                break;
            case GREATER_THAN:
                {
                alt11=3;
                }
                break;
            case GREATER_THAN_EQUAL:
                {
                alt11=4;
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
                    // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxTypes.g:321:3: ^(f= LESS_THAN value= unary )
                    {
                    f=(ManchesterOWLSyntaxTree)match(input,LESS_THAN,FOLLOW_LESS_THAN_in_facet1040); if (state.failed) return retval;

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    pushFollow(FOLLOW_unary_in_facet1046);
                    value=unary();

                    state._fsp--;
                    if (state.failed) return retval;

                    match(input, Token.UP, null); if (state.failed) return retval;
                    if ( state.backtracking==1 ) {

                      			retval.type = getSymbolTable().getOWLFacetRestrictionType(f, (value!=null?value.node:null), ((ManchesterOWLSyntaxTree)retval.start));
                      			retval.owlObject = getSymbolTable().getOWLFacetRestriction(f, (value!=null?value.node:null), ((ManchesterOWLSyntaxTree)retval.start));
                      		
                    }

                    }
                    break;
                case 2 :
                    // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxTypes.g:325:5: ^(f= LESS_THAN_EQUAL value= unary )
                    {
                    f=(ManchesterOWLSyntaxTree)match(input,LESS_THAN_EQUAL,FOLLOW_LESS_THAN_EQUAL_in_facet1058); if (state.failed) return retval;

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    pushFollow(FOLLOW_unary_in_facet1064);
                    value=unary();

                    state._fsp--;
                    if (state.failed) return retval;

                    match(input, Token.UP, null); if (state.failed) return retval;
                    if ( state.backtracking==1 ) {

                      			retval.type = getSymbolTable().getOWLFacetRestrictionType(f, (value!=null?value.node:null), ((ManchesterOWLSyntaxTree)retval.start));
                      			retval.owlObject = getSymbolTable().getOWLFacetRestriction(f, (value!=null?value.node:null), ((ManchesterOWLSyntaxTree)retval.start));		
                    }

                    }
                    break;
                case 3 :
                    // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxTypes.g:328:5: ^(f= GREATER_THAN value= unary )
                    {
                    f=(ManchesterOWLSyntaxTree)match(input,GREATER_THAN,FOLLOW_GREATER_THAN_in_facet1077); if (state.failed) return retval;

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    pushFollow(FOLLOW_unary_in_facet1083);
                    value=unary();

                    state._fsp--;
                    if (state.failed) return retval;

                    match(input, Token.UP, null); if (state.failed) return retval;
                    if ( state.backtracking==1 ) {

                      			retval.type = getSymbolTable().getOWLFacetRestrictionType(f, (value!=null?value.node:null), ((ManchesterOWLSyntaxTree)retval.start));
                      			retval.owlObject = getSymbolTable().getOWLFacetRestriction(f, (value!=null?value.node:null), ((ManchesterOWLSyntaxTree)retval.start));
                      		
                    }

                    }
                    break;
                case 4 :
                    // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxTypes.g:332:5: ^(f= GREATER_THAN_EQUAL value= unary )
                    {
                    f=(ManchesterOWLSyntaxTree)match(input,GREATER_THAN_EQUAL,FOLLOW_GREATER_THAN_EQUAL_in_facet1096); if (state.failed) return retval;

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    pushFollow(FOLLOW_unary_in_facet1102);
                    value=unary();

                    state._fsp--;
                    if (state.failed) return retval;

                    match(input, Token.UP, null); if (state.failed) return retval;
                    if ( state.backtracking==1 ) {

                      			retval.type = getSymbolTable().getOWLFacetRestrictionType(f, (value!=null?value.node:null), ((ManchesterOWLSyntaxTree)retval.start));
                      			retval.owlObject = getSymbolTable().getOWLFacetRestriction(f, (value!=null?value.node:null), ((ManchesterOWLSyntaxTree)retval.start));
                      		
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
    // $ANTLR end "facet"

    public static class propertyExpression_return extends TreeRuleReturnScope {
        public Type type;
        public ManchesterOWLSyntaxTree node;
        public OWLObject owlObject;
    };

    // $ANTLR start "propertyExpression"
    // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxTypes.g:341:1: propertyExpression returns [Type type, ManchesterOWLSyntaxTree node, OWLObject owlObject] : ( IDENTIFIER | ENTITY_REFERENCE | complexPropertyExpression );
    public final ManchesterOWLSyntaxTypes.propertyExpression_return propertyExpression() throws RecognitionException {
        ManchesterOWLSyntaxTypes.propertyExpression_return retval = new ManchesterOWLSyntaxTypes.propertyExpression_return();
        retval.start = input.LT(1);

        ManchesterOWLSyntaxTree IDENTIFIER10=null;
        ManchesterOWLSyntaxTree ENTITY_REFERENCE11=null;
        ManchesterOWLSyntaxTypes.complexPropertyExpression_return complexPropertyExpression12 = null;


        try {
            // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxTypes.g:349:1: ( IDENTIFIER | ENTITY_REFERENCE | complexPropertyExpression )
            int alt12=3;
            switch ( input.LA(1) ) {
            case IDENTIFIER:
                {
                alt12=1;
                }
                break;
            case ENTITY_REFERENCE:
                {
                alt12=2;
                }
                break;
            case INVERSE_OBJECT_PROPERTY_EXPRESSION:
                {
                alt12=3;
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
                    // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxTypes.g:350:7: IDENTIFIER
                    {
                    IDENTIFIER10=(ManchesterOWLSyntaxTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_propertyExpression1141); if (state.failed) return retval;
                    if ( state.backtracking==1 ) {

                              Symbol symbol = this.getSymbolTable().resolve(IDENTIFIER10);
                              retval.type = symbol==null ? null: symbol.getType();
                              retval.owlObject = this.getSymbolTable().getOWLObject(IDENTIFIER10);
                            
                    }

                    }
                    break;
                case 2 :
                    // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxTypes.g:356:9: ENTITY_REFERENCE
                    {
                    ENTITY_REFERENCE11=(ManchesterOWLSyntaxTree)match(input,ENTITY_REFERENCE,FOLLOW_ENTITY_REFERENCE_in_propertyExpression1159); if (state.failed) return retval;
                    if ( state.backtracking==1 ) {

                      				Symbol symbol = this.getSymbolTable().resolve(ENTITY_REFERENCE11);
                      				retval.type = symbol==null ? null: symbol.getType();
                      				retval.owlObject = this.getSymbolTable().getOWLObject(ENTITY_REFERENCE11);
                      			
                    }

                    }
                    break;
                case 3 :
                    // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxTypes.g:362:7: complexPropertyExpression
                    {
                    pushFollow(FOLLOW_complexPropertyExpression_in_propertyExpression1173);
                    complexPropertyExpression12=complexPropertyExpression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==1 ) {

                              retval.type = (complexPropertyExpression12!=null?complexPropertyExpression12.type:null);
                              retval.owlObject = (complexPropertyExpression12!=null?complexPropertyExpression12.owlObject:null);
                            
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
    // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxTypes.g:369:1: complexPropertyExpression returns [Type type, ManchesterOWLSyntaxTree node, OWLObject owlObject] : ( ^( INVERSE_OBJECT_PROPERTY_EXPRESSION p= complexPropertyExpression ) | ^( INVERSE_OBJECT_PROPERTY_EXPRESSION IDENTIFIER ) | ^( INVERSE_OBJECT_PROPERTY_EXPRESSION ENTITY_REFERENCE ) );
    public final ManchesterOWLSyntaxTypes.complexPropertyExpression_return complexPropertyExpression() throws RecognitionException {
        ManchesterOWLSyntaxTypes.complexPropertyExpression_return retval = new ManchesterOWLSyntaxTypes.complexPropertyExpression_return();
        retval.start = input.LT(1);

        ManchesterOWLSyntaxTree IDENTIFIER13=null;
        ManchesterOWLSyntaxTree ENTITY_REFERENCE14=null;
        ManchesterOWLSyntaxTypes.complexPropertyExpression_return p = null;


        try {
            // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxTypes.g:376:1: ( ^( INVERSE_OBJECT_PROPERTY_EXPRESSION p= complexPropertyExpression ) | ^( INVERSE_OBJECT_PROPERTY_EXPRESSION IDENTIFIER ) | ^( INVERSE_OBJECT_PROPERTY_EXPRESSION ENTITY_REFERENCE ) )
            int alt13=3;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==INVERSE_OBJECT_PROPERTY_EXPRESSION) ) {
                int LA13_1 = input.LA(2);

                if ( (LA13_1==DOWN) ) {
                    switch ( input.LA(3) ) {
                    case IDENTIFIER:
                        {
                        alt13=2;
                        }
                        break;
                    case ENTITY_REFERENCE:
                        {
                        alt13=3;
                        }
                        break;
                    case INVERSE_OBJECT_PROPERTY_EXPRESSION:
                        {
                        alt13=1;
                        }
                        break;
                    default:
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 13, 2, input);

                        throw nvae;
                    }

                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 13, 1, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;
            }
            switch (alt13) {
                case 1 :
                    // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxTypes.g:377:2: ^( INVERSE_OBJECT_PROPERTY_EXPRESSION p= complexPropertyExpression )
                    {
                    match(input,INVERSE_OBJECT_PROPERTY_EXPRESSION,FOLLOW_INVERSE_OBJECT_PROPERTY_EXPRESSION_in_complexPropertyExpression1206); if (state.failed) return retval;

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    pushFollow(FOLLOW_complexPropertyExpression_in_complexPropertyExpression1212);
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
                    // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxTypes.g:382:4: ^( INVERSE_OBJECT_PROPERTY_EXPRESSION IDENTIFIER )
                    {
                    match(input,INVERSE_OBJECT_PROPERTY_EXPRESSION,FOLLOW_INVERSE_OBJECT_PROPERTY_EXPRESSION_in_complexPropertyExpression1222); if (state.failed) return retval;

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    IDENTIFIER13=(ManchesterOWLSyntaxTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_complexPropertyExpression1224); if (state.failed) return retval;

                    match(input, Token.UP, null); if (state.failed) return retval;
                    if ( state.backtracking==1 ) {

                      				Symbol symbol = this.getSymbolTable().resolve(IDENTIFIER13);
                      				retval.type = this.getSymbolTable().getInversePropertyType(((ManchesterOWLSyntaxTree)retval.start), IDENTIFIER13);
                      				retval.owlObject = this.getSymbolTable().getInverseProperty(((ManchesterOWLSyntaxTree)retval.start), IDENTIFIER13);
                      	
                    }

                    }
                    break;
                case 3 :
                    // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxTypes.g:388:4: ^( INVERSE_OBJECT_PROPERTY_EXPRESSION ENTITY_REFERENCE )
                    {
                    match(input,INVERSE_OBJECT_PROPERTY_EXPRESSION,FOLLOW_INVERSE_OBJECT_PROPERTY_EXPRESSION_in_complexPropertyExpression1234); if (state.failed) return retval;

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    ENTITY_REFERENCE14=(ManchesterOWLSyntaxTree)match(input,ENTITY_REFERENCE,FOLLOW_ENTITY_REFERENCE_in_complexPropertyExpression1236); if (state.failed) return retval;

                    match(input, Token.UP, null); if (state.failed) return retval;
                    if ( state.backtracking==1 ) {

                      				Symbol symbol = this.getSymbolTable().resolve(ENTITY_REFERENCE14);
                      				retval.type = this.getSymbolTable().getInversePropertyType(((ManchesterOWLSyntaxTree)retval.start), ENTITY_REFERENCE14);
                      				retval.owlObject = this.getSymbolTable().getInverseProperty(((ManchesterOWLSyntaxTree)retval.start), ENTITY_REFERENCE14);
                      	
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
    // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxTypes.g:396:1: qualifiedRestriction returns [Type type , ManchesterOWLSyntaxTree node, OWLObject owlObject] : ( ^( SOME_RESTRICTION p= propertyExpression f= expression ) | ^( ALL_RESTRICTION p= propertyExpression f= expression ) | cardinalityRestriction | oneOf | valueRestriction );
    public final ManchesterOWLSyntaxTypes.qualifiedRestriction_return qualifiedRestriction() throws RecognitionException {
        ManchesterOWLSyntaxTypes.qualifiedRestriction_return retval = new ManchesterOWLSyntaxTypes.qualifiedRestriction_return();
        retval.start = input.LT(1);

        ManchesterOWLSyntaxTypes.propertyExpression_return p = null;

        ManchesterOWLSyntaxTypes.expression_return f = null;

        ManchesterOWLSyntaxTypes.cardinalityRestriction_return cardinalityRestriction15 = null;

        ManchesterOWLSyntaxTypes.oneOf_return oneOf16 = null;

        ManchesterOWLSyntaxTypes.valueRestriction_return valueRestriction17 = null;


        try {
            // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxTypes.g:402:2: ( ^( SOME_RESTRICTION p= propertyExpression f= expression ) | ^( ALL_RESTRICTION p= propertyExpression f= expression ) | cardinalityRestriction | oneOf | valueRestriction )
            int alt14=5;
            switch ( input.LA(1) ) {
            case SOME_RESTRICTION:
                {
                alt14=1;
                }
                break;
            case ALL_RESTRICTION:
                {
                alt14=2;
                }
                break;
            case CARDINALITY_RESTRICTION:
                {
                alt14=3;
                }
                break;
            case ONE_OF:
                {
                alt14=4;
                }
                break;
            case VALUE_RESTRICTION:
                {
                alt14=5;
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
                    // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxTypes.g:403:6: ^( SOME_RESTRICTION p= propertyExpression f= expression )
                    {
                    match(input,SOME_RESTRICTION,FOLLOW_SOME_RESTRICTION_in_qualifiedRestriction1267); if (state.failed) return retval;

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    pushFollow(FOLLOW_propertyExpression_in_qualifiedRestriction1272);
                    p=propertyExpression();

                    state._fsp--;
                    if (state.failed) return retval;
                    pushFollow(FOLLOW_expression_in_qualifiedRestriction1278);
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
                    // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxTypes.g:408:7: ^( ALL_RESTRICTION p= propertyExpression f= expression )
                    {
                    match(input,ALL_RESTRICTION,FOLLOW_ALL_RESTRICTION_in_qualifiedRestriction1300); if (state.failed) return retval;

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    pushFollow(FOLLOW_propertyExpression_in_qualifiedRestriction1307);
                    p=propertyExpression();

                    state._fsp--;
                    if (state.failed) return retval;
                    pushFollow(FOLLOW_expression_in_qualifiedRestriction1312);
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
                    // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxTypes.g:413:7: cardinalityRestriction
                    {
                    pushFollow(FOLLOW_cardinalityRestriction_in_qualifiedRestriction1328);
                    cardinalityRestriction15=cardinalityRestriction();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==1 ) {

                      						retval.type = (cardinalityRestriction15!=null?cardinalityRestriction15.type:null);
                      						retval.owlObject = (cardinalityRestriction15!=null?cardinalityRestriction15.owlObject:null);
                      					
                    }

                    }
                    break;
                case 4 :
                    // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxTypes.g:418:7: oneOf
                    {
                    pushFollow(FOLLOW_oneOf_in_qualifiedRestriction1344);
                    oneOf16=oneOf();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==1 ) {

                      						retval.type = (oneOf16!=null?oneOf16.type:null);
                      						retval.owlObject = (oneOf16!=null?oneOf16.owlObject:null);
                      					
                    }

                    }
                    break;
                case 5 :
                    // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxTypes.g:423:7: valueRestriction
                    {
                    pushFollow(FOLLOW_valueRestriction_in_qualifiedRestriction1360);
                    valueRestriction17=valueRestriction();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==1 ) {

                      						retval.type = (valueRestriction17!=null?valueRestriction17.type:null);
                      						retval.owlObject = (valueRestriction17!=null?valueRestriction17.owlObject:null);
                      					
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
    // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxTypes.g:432:1: cardinalityRestriction returns [Type type , ManchesterOWLSyntaxTree node, OWLObject owlObject] : ( ^( CARDINALITY_RESTRICTION MIN i= INTEGER p= unary (filler= expression )? ) | ^( CARDINALITY_RESTRICTION MAX i= INTEGER p= unary (filler= expression )? ) | ^( CARDINALITY_RESTRICTION EXACTLY i= INTEGER p= unary (filler= expression )? ) );
    public final ManchesterOWLSyntaxTypes.cardinalityRestriction_return cardinalityRestriction() throws RecognitionException {
        ManchesterOWLSyntaxTypes.cardinalityRestriction_return retval = new ManchesterOWLSyntaxTypes.cardinalityRestriction_return();
        retval.start = input.LT(1);

        ManchesterOWLSyntaxTree i=null;
        ManchesterOWLSyntaxTypes.unary_return p = null;

        ManchesterOWLSyntaxTypes.expression_return filler = null;


        try {
            // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxTypes.g:438:1: ( ^( CARDINALITY_RESTRICTION MIN i= INTEGER p= unary (filler= expression )? ) | ^( CARDINALITY_RESTRICTION MAX i= INTEGER p= unary (filler= expression )? ) | ^( CARDINALITY_RESTRICTION EXACTLY i= INTEGER p= unary (filler= expression )? ) )
            int alt18=3;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==CARDINALITY_RESTRICTION) ) {
                int LA18_1 = input.LA(2);

                if ( (LA18_1==DOWN) ) {
                    switch ( input.LA(3) ) {
                    case MIN:
                        {
                        alt18=1;
                        }
                        break;
                    case MAX:
                        {
                        alt18=2;
                        }
                        break;
                    case EXACTLY:
                        {
                        alt18=3;
                        }
                        break;
                    default:
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 18, 2, input);

                        throw nvae;
                    }

                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 18, 1, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 18, 0, input);

                throw nvae;
            }
            switch (alt18) {
                case 1 :
                    // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxTypes.g:439:5: ^( CARDINALITY_RESTRICTION MIN i= INTEGER p= unary (filler= expression )? )
                    {
                    match(input,CARDINALITY_RESTRICTION,FOLLOW_CARDINALITY_RESTRICTION_in_cardinalityRestriction1397); if (state.failed) return retval;

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    match(input,MIN,FOLLOW_MIN_in_cardinalityRestriction1400); if (state.failed) return retval;
                    i=(ManchesterOWLSyntaxTree)match(input,INTEGER,FOLLOW_INTEGER_in_cardinalityRestriction1405); if (state.failed) return retval;
                    pushFollow(FOLLOW_unary_in_cardinalityRestriction1411);
                    p=unary();

                    state._fsp--;
                    if (state.failed) return retval;
                    // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxTypes.g:439:65: (filler= expression )?
                    int alt15=2;
                    int LA15_0 = input.LA(1);

                    if ( ((LA15_0>=IDENTIFIER && LA15_0<=ENTITY_REFERENCE)||(LA15_0>=DISJUNCTION && LA15_0<=NEGATED_EXPRESSION)||(LA15_0>=SOME_RESTRICTION && LA15_0<=ONE_OF)||LA15_0==INVERSE_OBJECT_PROPERTY_EXPRESSION||LA15_0==CONSTANT||LA15_0==DATA_RANGE) ) {
                        alt15=1;
                    }
                    switch (alt15) {
                        case 1 :
                            // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxTypes.g:439:65: filler= expression
                            {
                            pushFollow(FOLLOW_expression_in_cardinalityRestriction1418);
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
                    // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxTypes.g:446:6: ^( CARDINALITY_RESTRICTION MAX i= INTEGER p= unary (filler= expression )? )
                    {
                    match(input,CARDINALITY_RESTRICTION,FOLLOW_CARDINALITY_RESTRICTION_in_cardinalityRestriction1433); if (state.failed) return retval;

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    match(input,MAX,FOLLOW_MAX_in_cardinalityRestriction1436); if (state.failed) return retval;
                    i=(ManchesterOWLSyntaxTree)match(input,INTEGER,FOLLOW_INTEGER_in_cardinalityRestriction1440); if (state.failed) return retval;
                    pushFollow(FOLLOW_unary_in_cardinalityRestriction1446);
                    p=unary();

                    state._fsp--;
                    if (state.failed) return retval;
                    // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxTypes.g:446:65: (filler= expression )?
                    int alt16=2;
                    int LA16_0 = input.LA(1);

                    if ( ((LA16_0>=IDENTIFIER && LA16_0<=ENTITY_REFERENCE)||(LA16_0>=DISJUNCTION && LA16_0<=NEGATED_EXPRESSION)||(LA16_0>=SOME_RESTRICTION && LA16_0<=ONE_OF)||LA16_0==INVERSE_OBJECT_PROPERTY_EXPRESSION||LA16_0==CONSTANT||LA16_0==DATA_RANGE) ) {
                        alt16=1;
                    }
                    switch (alt16) {
                        case 1 :
                            // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxTypes.g:446:65: filler= expression
                            {
                            pushFollow(FOLLOW_expression_in_cardinalityRestriction1453);
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
                    // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxTypes.g:452:8: ^( CARDINALITY_RESTRICTION EXACTLY i= INTEGER p= unary (filler= expression )? )
                    {
                    match(input,CARDINALITY_RESTRICTION,FOLLOW_CARDINALITY_RESTRICTION_in_cardinalityRestriction1472); if (state.failed) return retval;

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    match(input,EXACTLY,FOLLOW_EXACTLY_in_cardinalityRestriction1475); if (state.failed) return retval;
                    i=(ManchesterOWLSyntaxTree)match(input,INTEGER,FOLLOW_INTEGER_in_cardinalityRestriction1480); if (state.failed) return retval;
                    pushFollow(FOLLOW_unary_in_cardinalityRestriction1487);
                    p=unary();

                    state._fsp--;
                    if (state.failed) return retval;
                    // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxTypes.g:452:73: (filler= expression )?
                    int alt17=2;
                    int LA17_0 = input.LA(1);

                    if ( ((LA17_0>=IDENTIFIER && LA17_0<=ENTITY_REFERENCE)||(LA17_0>=DISJUNCTION && LA17_0<=NEGATED_EXPRESSION)||(LA17_0>=SOME_RESTRICTION && LA17_0<=ONE_OF)||LA17_0==INVERSE_OBJECT_PROPERTY_EXPRESSION||LA17_0==CONSTANT||LA17_0==DATA_RANGE) ) {
                        alt17=1;
                    }
                    switch (alt17) {
                        case 1 :
                            // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxTypes.g:452:73: filler= expression
                            {
                            pushFollow(FOLLOW_expression_in_cardinalityRestriction1494);
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
    // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxTypes.g:460:1: oneOf returns [Type type , ManchesterOWLSyntaxTree node, OWLObject owlObject] : ^( ONE_OF (individuals+= unary )+ ) ;
    public final ManchesterOWLSyntaxTypes.oneOf_return oneOf() throws RecognitionException {
        ManchesterOWLSyntaxTypes.oneOf_return retval = new ManchesterOWLSyntaxTypes.oneOf_return();
        retval.start = input.LT(1);

        List list_individuals=null;
        RuleReturnScope individuals = null;
        try {
            // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxTypes.g:466:2: ( ^( ONE_OF (individuals+= unary )+ ) )
            // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxTypes.g:467:3: ^( ONE_OF (individuals+= unary )+ )
            {
            match(input,ONE_OF,FOLLOW_ONE_OF_in_oneOf1529); if (state.failed) return retval;

            match(input, Token.DOWN, null); if (state.failed) return retval;
            // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxTypes.g:467:23: (individuals+= unary )+
            int cnt19=0;
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( ((LA19_0>=IDENTIFIER && LA19_0<=ENTITY_REFERENCE)||LA19_0==NEGATED_EXPRESSION||(LA19_0>=SOME_RESTRICTION && LA19_0<=ONE_OF)||LA19_0==CONSTANT||LA19_0==DATA_RANGE) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxTypes.g:467:23: individuals+= unary
            	    {
            	    pushFollow(FOLLOW_unary_in_oneOf1533);
            	    individuals=unary();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if (list_individuals==null) list_individuals=new ArrayList();
            	    list_individuals.add(individuals);


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
    // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxTypes.g:480:1: valueRestriction returns [Type type , ManchesterOWLSyntaxTree node, OWLObject owlObject] : ^( VALUE_RESTRICTION p= unary value= unary ) ;
    public final ManchesterOWLSyntaxTypes.valueRestriction_return valueRestriction() throws RecognitionException {
        ManchesterOWLSyntaxTypes.valueRestriction_return retval = new ManchesterOWLSyntaxTypes.valueRestriction_return();
        retval.start = input.LT(1);

        ManchesterOWLSyntaxTypes.unary_return p = null;

        ManchesterOWLSyntaxTypes.unary_return value = null;


        try {
            // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxTypes.g:486:2: ( ^( VALUE_RESTRICTION p= unary value= unary ) )
            // /Users/luigi/Documents/workspace/PARSERS/src/ManchesterOWLSyntaxTypes.g:487:3: ^( VALUE_RESTRICTION p= unary value= unary )
            {
            match(input,VALUE_RESTRICTION,FOLLOW_VALUE_RESTRICTION_in_valueRestriction1566); if (state.failed) return retval;

            match(input, Token.DOWN, null); if (state.failed) return retval;
            pushFollow(FOLLOW_unary_in_valueRestriction1573);
            p=unary();

            state._fsp--;
            if (state.failed) return retval;
            pushFollow(FOLLOW_unary_in_valueRestriction1580);
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


    protected DFA2 dfa2 = new DFA2(this);
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
            return "88:1: axiom returns [Type type, ManchesterOWLSyntaxTree node, OWLAxiom owlAxiom] : ( ^( SUB_CLASS_AXIOM ^( EXPRESSION subClass= expression ) ^( EXPRESSION superClass= expression ) ) | ^( EQUIVALENT_TO_AXIOM ^( EXPRESSION lhs= expression ) ^( EXPRESSION rhs= expression ) ) | ^( INVERSE_OF ^( EXPRESSION p= IDENTIFIER ) ^( EXPRESSION anotherProperty= IDENTIFIER ) ) | ^( DISJOINT_WITH_AXIOM ^( EXPRESSION lhs= expression ) ^( EXPRESSION rhs= expression ) ) | ^( SUB_PROPERTY_AXIOM ^( EXPRESSION subProperty= expression ) ^( EXPRESSION superProperty= unary ) ) | ^( ROLE_ASSERTION ^( EXPRESSION subject= IDENTIFIER ) ^( EXPRESSION predicate= propertyExpression ) ^( EXPRESSION object= unary ) ) | ^( TYPE_ASSERTION ^( EXPRESSION description= expression ) ^( EXPRESSION subject= IDENTIFIER ) ) | ^( DOMAIN ^( EXPRESSION p= IDENTIFIER ) ^( EXPRESSION domain= expression ) ) | ^( RANGE ^( EXPRESSION p= IDENTIFIER ) ^( EXPRESSION range= expression ) ) | ^( SAME_AS_AXIOM ^( EXPRESSION anIndividual= IDENTIFIER ) ^( EXPRESSION anotherIndividual= IDENTIFIER ) ) | ^( DIFFERENT_FROM_AXIOM ^( EXPRESSION anIndividual= IDENTIFIER ) ^( EXPRESSION anotherIndividual= IDENTIFIER ) ) | ^( UNARY_AXIOM FUNCTIONAL ^( EXPRESSION p= IDENTIFIER ) ) | ^( UNARY_AXIOM INVERSE_FUNCTIONAL ^( EXPRESSION p= IDENTIFIER ) ) | ^( UNARY_AXIOM IRREFLEXIVE ^( EXPRESSION p= IDENTIFIER ) ) | ^( UNARY_AXIOM REFLEXIVE ^( EXPRESSION p= IDENTIFIER ) ) | ^( UNARY_AXIOM SYMMETRIC ^( EXPRESSION p= IDENTIFIER ) ) | ^( UNARY_AXIOM TRANSITIVE ^( EXPRESSION p= IDENTIFIER ) ) | ^( NEGATED_ASSERTION a= axiom ) );";
        }
    }
 

    public static final BitSet FOLLOW_expressionRoot_in_bottomup81 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_axiom_in_bottomup91 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_EXPRESSION_in_expressionRoot118 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_expressionRoot120 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_SUB_CLASS_AXIOM_in_axiom164 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_EXPRESSION_in_axiom168 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_axiom175 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_EXPRESSION_in_axiom180 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_axiom187 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_EQUIVALENT_TO_AXIOM_in_axiom200 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_EXPRESSION_in_axiom203 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_axiom209 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_EXPRESSION_in_axiom213 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_axiom220 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_INVERSE_OF_in_axiom235 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_EXPRESSION_in_axiom238 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENTIFIER_in_axiom244 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_EXPRESSION_in_axiom248 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENTIFIER_in_axiom254 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_DISJOINT_WITH_AXIOM_in_axiom266 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_EXPRESSION_in_axiom269 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_axiom276 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_EXPRESSION_in_axiom280 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_axiom286 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_SUB_PROPERTY_AXIOM_in_axiom298 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_EXPRESSION_in_axiom301 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_axiom308 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_EXPRESSION_in_axiom312 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_unary_in_axiom318 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ROLE_ASSERTION_in_axiom332 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_EXPRESSION_in_axiom335 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENTIFIER_in_axiom342 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_EXPRESSION_in_axiom346 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_propertyExpression_in_axiom353 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_EXPRESSION_in_axiom357 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_unary_in_axiom363 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_TYPE_ASSERTION_in_axiom373 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_EXPRESSION_in_axiom376 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_axiom383 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_EXPRESSION_in_axiom387 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENTIFIER_in_axiom393 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_DOMAIN_in_axiom405 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_EXPRESSION_in_axiom408 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENTIFIER_in_axiom414 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_EXPRESSION_in_axiom418 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_axiom424 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_RANGE_in_axiom437 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_EXPRESSION_in_axiom440 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENTIFIER_in_axiom446 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_EXPRESSION_in_axiom450 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_axiom456 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_SAME_AS_AXIOM_in_axiom471 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_EXPRESSION_in_axiom474 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENTIFIER_in_axiom479 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_EXPRESSION_in_axiom483 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENTIFIER_in_axiom489 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_DIFFERENT_FROM_AXIOM_in_axiom505 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_EXPRESSION_in_axiom508 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENTIFIER_in_axiom513 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_EXPRESSION_in_axiom517 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENTIFIER_in_axiom523 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_UNARY_AXIOM_in_axiom537 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_FUNCTIONAL_in_axiom539 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_EXPRESSION_in_axiom542 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENTIFIER_in_axiom548 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_UNARY_AXIOM_in_axiom561 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_INVERSE_FUNCTIONAL_in_axiom563 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_EXPRESSION_in_axiom566 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENTIFIER_in_axiom572 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_UNARY_AXIOM_in_axiom588 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IRREFLEXIVE_in_axiom590 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_EXPRESSION_in_axiom593 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENTIFIER_in_axiom599 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_UNARY_AXIOM_in_axiom614 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_REFLEXIVE_in_axiom616 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_EXPRESSION_in_axiom619 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENTIFIER_in_axiom625 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_UNARY_AXIOM_in_axiom640 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_SYMMETRIC_in_axiom642 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_EXPRESSION_in_axiom645 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENTIFIER_in_axiom651 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_UNARY_AXIOM_in_axiom668 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_TRANSITIVE_in_axiom670 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_EXPRESSION_in_axiom673 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENTIFIER_in_axiom679 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_NEGATED_ASSERTION_in_axiom694 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_axiom_in_axiom699 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_DISJUNCTION_in_expression735 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_conjunction_in_expression741 = new BitSet(new long[]{0xE500300000000008L,0x0000100000000043L});
    public static final BitSet FOLLOW_PROPERTY_CHAIN_in_expression757 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_expression762 = new BitSet(new long[]{0xE780300000000008L,0x0000100000000053L});
    public static final BitSet FOLLOW_conjunction_in_expression776 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_complexPropertyExpression_in_expression788 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CONJUNCTION_in_conjunction825 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_unary_in_conjunction830 = new BitSet(new long[]{0xE500300000000008L,0x0000100000000043L});
    public static final BitSet FOLLOW_unary_in_conjunction841 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_unary868 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NEGATED_EXPRESSION_in_unary881 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_unary887 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_qualifiedRestriction_in_unary901 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ENTITY_REFERENCE_in_unary915 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CONSTANT_in_unary928 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENTIFIER_in_unary939 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_dataRange_in_unary949 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DATA_RANGE_in_dataRange986 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_unary_in_dataRange992 = new BitSet(new long[]{0x0000000000000008L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000007800000000L});
    public static final BitSet FOLLOW_facet_in_dataRange997 = new BitSet(new long[]{0x0000000000000008L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000007800000000L});
    public static final BitSet FOLLOW_LESS_THAN_in_facet1040 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_unary_in_facet1046 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_LESS_THAN_EQUAL_in_facet1058 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_unary_in_facet1064 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_GREATER_THAN_in_facet1077 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_unary_in_facet1083 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_GREATER_THAN_EQUAL_in_facet1096 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_unary_in_facet1102 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_IDENTIFIER_in_propertyExpression1141 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ENTITY_REFERENCE_in_propertyExpression1159 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_complexPropertyExpression_in_propertyExpression1173 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INVERSE_OBJECT_PROPERTY_EXPRESSION_in_complexPropertyExpression1206 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_complexPropertyExpression_in_complexPropertyExpression1212 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_INVERSE_OBJECT_PROPERTY_EXPRESSION_in_complexPropertyExpression1222 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENTIFIER_in_complexPropertyExpression1224 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_INVERSE_OBJECT_PROPERTY_EXPRESSION_in_complexPropertyExpression1234 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ENTITY_REFERENCE_in_complexPropertyExpression1236 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_SOME_RESTRICTION_in_qualifiedRestriction1267 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_propertyExpression_in_qualifiedRestriction1272 = new BitSet(new long[]{0xE780300000000008L,0x0000100000000053L});
    public static final BitSet FOLLOW_expression_in_qualifiedRestriction1278 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ALL_RESTRICTION_in_qualifiedRestriction1300 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_propertyExpression_in_qualifiedRestriction1307 = new BitSet(new long[]{0xE780300000000008L,0x0000100000000053L});
    public static final BitSet FOLLOW_expression_in_qualifiedRestriction1312 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_cardinalityRestriction_in_qualifiedRestriction1328 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_oneOf_in_qualifiedRestriction1344 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_valueRestriction_in_qualifiedRestriction1360 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CARDINALITY_RESTRICTION_in_cardinalityRestriction1397 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_MIN_in_cardinalityRestriction1400 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_INTEGER_in_cardinalityRestriction1405 = new BitSet(new long[]{0xE500300000000008L,0x0000100000000043L});
    public static final BitSet FOLLOW_unary_in_cardinalityRestriction1411 = new BitSet(new long[]{0xE780300000000008L,0x0000100000000053L});
    public static final BitSet FOLLOW_expression_in_cardinalityRestriction1418 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_CARDINALITY_RESTRICTION_in_cardinalityRestriction1433 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_MAX_in_cardinalityRestriction1436 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_INTEGER_in_cardinalityRestriction1440 = new BitSet(new long[]{0xE500300000000008L,0x0000100000000043L});
    public static final BitSet FOLLOW_unary_in_cardinalityRestriction1446 = new BitSet(new long[]{0xE780300000000008L,0x0000100000000053L});
    public static final BitSet FOLLOW_expression_in_cardinalityRestriction1453 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_CARDINALITY_RESTRICTION_in_cardinalityRestriction1472 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_EXACTLY_in_cardinalityRestriction1475 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_INTEGER_in_cardinalityRestriction1480 = new BitSet(new long[]{0xE500300000000008L,0x0000100000000043L});
    public static final BitSet FOLLOW_unary_in_cardinalityRestriction1487 = new BitSet(new long[]{0xE780300000000008L,0x0000100000000053L});
    public static final BitSet FOLLOW_expression_in_cardinalityRestriction1494 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ONE_OF_in_oneOf1529 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_unary_in_oneOf1533 = new BitSet(new long[]{0xE500300000000008L,0x0000100000000043L});
    public static final BitSet FOLLOW_VALUE_RESTRICTION_in_valueRestriction1566 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_unary_in_valueRestriction1573 = new BitSet(new long[]{0xE500300000000008L,0x0000100000000043L});
    public static final BitSet FOLLOW_unary_in_valueRestriction1580 = new BitSet(new long[]{0x0000000000000008L});

}