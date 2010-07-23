// $ANTLR 3.2 Sep 23, 2009 12:02:23 /Users/luigi/Documents/workspace/PARSERS/src/OPPLTypes.g 2010-07-23 22:40:45

  package org.coode.parsers.oppl;
     import org.coode.oppl.entity.OWLEntityRenderer;
  import org.coode.oppl.AbstractConstraint;
import org.coode.oppl.ConstraintSystem;
  import org.coode.oppl.OPPLQuery;
import org.coode.oppl.Variable;
import org.coode.oppl.VariableScope;
import org.coode.oppl.VariableScopes;
  import org.coode.oppl.exceptions.OPPLException;
  import org.coode.oppl.NAFConstraint;
import org.coode.oppl.generated.AbstractCollectionGeneratedValue;
import org.coode.oppl.generated.ConcatGeneratedValues;
import org.coode.oppl.generated.RegExpGenerated;
import org.coode.oppl.generated.RegExpGeneratedValue;
import org.coode.oppl.generated.SingleValueGeneratedValue;
import org.coode.oppl.generated.StringGeneratedValue;
import org.coode.oppl.generated.VariableExpressionGeneratedVariable;
  import org.coode.oppl.OPPLAbstractFactory;
  import org.coode.oppl.InCollectionRegExpConstraint;
  import org.semanticweb.owl.model.OWLAxiom;
  import org.semanticweb.owl.model.OWLObject;
  import org.semanticweb.owl.model.OWLClass;
  import org.semanticweb.owl.model.OWLAxiomChange;
  import org.semanticweb.owl.model.OWLPropertyExpression;
  import org.semanticweb.owl.model.OWLDescription;
  import org.semanticweb.owl.model.RemoveAxiom;
import org.semanticweb.owl.model.AddAxiom;    
  import org.coode.parsers.ErrorListener;
  import org.coode.parsers.Type;
  import org.coode.parsers.oppl.OPPLSymbolTable;
  import org.coode.parsers.ManchesterOWLSyntaxTree;
  import java.util.Set;


import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
public class OPPLTypes extends TreeFilter {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "COMPOSITION", "OPEN_PARENTHESYS", "OPEN_CURLY_BRACES", "CLOSED_CURLY_BRACES", "CLOSED_PARENTHESYS", "WHITESPACE", "AND", "OR", "NOT", "SOME", "ONLY", "MIN", "MAX", "EXACTLY", "VALUE", "INVERSE", "SUBCLASS_OF", "SUB_PROPERTY_OF", "EQUIVALENT_TO", "SAME_AS", "DIFFERENT_FROM", "INVERSE_OF", "DISJOINT_WITH", "DOMAIN", "RANGE", "FUNCTIONAL", "SYMMETRIC", "ANTI_SYMMETRIC", "REFLEXIVE", "IRREFLEXIVE", "TRANSITIVE", "INVERSE_FUNCTIONAL", "POW", "COMMA", "INSTANCE_OF", "TYPES", "DBLQUOTE", "DIGIT", "INTEGER", "LETTER", "IDENTIFIER", "ENTITY_REFERENCE", "QUESTION_MARK", "Tokens", "SUB_CLASS_AXIOM", "EQUIVALENT_TO_AXIOM", "DISJOINT_WITH_AXIOM", "SUB_PROPERTY_AXIOM", "SAME_AS_AXIOM", "DIFFERENT_FROM_AXIOM", "UNARY_AXIOM", "DISJUNCTION", "CONJUNCTION", "PROPERTY_CHAIN", "NEGATED_EXPRESSION", "NEGATED_ASSERTION", "INVERSE_PROPERTY", "SOME_RESTRICTION", "ALL_RESTRICTION", "VALUE_RESTRICTION", "CARDINALITY_RESTRICTION", "ONE_OF", "TYPE_ASSERTION", "ROLE_ASSERTION", "INVERSE_OBJECT_PROPERTY_EXPRESSION", "EXPRESSION", "CONSTANT", "WHERE", "NOT_EQUAL", "EQUAL", "IN", "SELECT", "ASSERTED", "COLON", "DOT", "PLUS", "CREATE", "CREATE_INTERSECTION", "CREATE_DISJUNCTION", "BEGIN", "END", "OPEN_SQUARE_BRACKET", "CLOSED_SQUARE_BRACKET", "SUPER_CLASS_OF", "SUPER_PROPERTY_OF", "VARIABLE_TYPE", "ADD", "REMOVE", "ASSERTED_CLAUSE", "PLAIN_CLAUSE", "INEQUALITY_CONSTRAINT", "IN_SET_CONSTRAINT", "INPUT_VARIABLE_DEFINITION", "GENERATED_VARIABLE_DEFINITION", "CREATE_OPPL_FUNCTION", "VARIABLE_ATTRIBUTE", "OPPL_FUNCTION", "ACTIONS", "VARIABLE_DEFINITIONS", "QUERY", "VARIABLE_SCOPE", "SUBPROPERTY_OF", "VARIABLE_IDENTIFIER", "OPPL_STATEMENT", "ESCLAMATION_MARK", "MATCH", "ATTRIBUTE_SELECTOR", "VALUES", "RENDERING", "GROUPS", "STRING_OPERATION", "VARIABLE_NAME", "REGEXP_CONSTRAINT", "FAIL", "NAF_CONSTRAINT", "CLASS", "OBJECTPROPERTY", "DATAPROPERTY", "INDIVIDUAL"
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
    public static final int ALL_RESTRICTION=62;
    public static final int CONJUNCTION=56;
    public static final int OPPL_STATEMENT=107;
    public static final int NEGATED_ASSERTION=59;
    public static final int WHITESPACE=9;
    public static final int MATCH=176;
    public static final int IN_SET_CONSTRAINT=95;
    public static final int VALUE=18;
    public static final int FAIL=466;
    public static final int GROUPS=356;
    public static final int OPEN_CURLY_BRACES=6;
    public static final int DISJUNCTION=55;
    public static final int INVERSE=19;
    public static final int NAF_CONSTRAINT=467;
    public static final int DBLQUOTE=40;
    public static final int STRING_OPERATION=394;
    public static final int OR=11;
    public static final int CONSTANT=70;
    public static final int QUERY=103;
    public static final int ENTITY_REFERENCE=45;
    public static final int END=84;
    public static final int COMPOSITION=4;
    public static final int CLOSED_SQUARE_BRACKET=86;
    public static final int SAME_AS=23;
    public static final int WHERE=71;
    public static final int CLASS=468;
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
    public static final int REFLEXIVE=32;
    public static final int PLUS=79;
    public static final int DIGIT=41;
    public static final int DATAPROPERTY=470;
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
    public static final int INDIVIDUAL=471;
    public static final int VALUES=354;
    public static final int REGEXP_CONSTRAINT=465;
    public static final int RANGE=28;
    public static final int ONE_OF=65;
    public static final int VARIABLE_DEFINITIONS=102;
    public static final int MIN=15;
    public static final int SUB_CLASS_AXIOM=48;
    public static final int PLAIN_CLAUSE=93;
    public static final int Tokens=47;
    public static final int DOMAIN=27;
    public static final int OBJECTPROPERTY=469;
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


        public OPPLTypes(TreeNodeStream input) {
            this(input, new RecognizerSharedState());
        }
        public OPPLTypes(TreeNodeStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return OPPLTypes.tokenNames; }
    public String getGrammarFileName() { return "/Users/luigi/Documents/workspace/PARSERS/src/OPPLTypes.g"; }


      private  OPPLSymbolTable symtab;
      private  ErrorListener errorListener;
      private ConstraintSystem constraintSystem;
      private OPPLAbstractFactory opplFactory;
      
      public OPPLTypes(TreeNodeStream input, OPPLSymbolTable symtab, ErrorListener errorListener, ConstraintSystem constraintSystem, OPPLAbstractFactory opplFactory) {
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
        if(opplFactory == null){
          throw new NullPointerException("The OPPL Factory cannot be null");
        }
        this.symtab = symtab;
        this.errorListener = errorListener;
        this.opplFactory = opplFactory;
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
      
      public OPPLAbstractFactory getOPPLFactory(){
        return this.opplFactory;
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
    // /Users/luigi/Documents/workspace/PARSERS/src/OPPLTypes.g:118:1: bottomup : statement ;
    public final void bottomup() throws RecognitionException {
        try {
            // /Users/luigi/Documents/workspace/PARSERS/src/OPPLTypes.g:119:5: ( statement )
            // /Users/luigi/Documents/workspace/PARSERS/src/OPPLTypes.g:120:6: statement
            {
            pushFollow(FOLLOW_statement_in_bottomup81);
            statement();

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

    public static class statement_return extends TreeRuleReturnScope {
    };

    // $ANTLR start "statement"
    // /Users/luigi/Documents/workspace/PARSERS/src/OPPLTypes.g:124:1: statement : ^( OPPL_STATEMENT (vd= variableDefinitions )? (q= query )? actions ) ;
    public final OPPLTypes.statement_return statement() throws RecognitionException {
        OPPLTypes.statement_return retval = new OPPLTypes.statement_return();
        retval.start = input.LT(1);

        List<Variable> vd = null;

        OPPLQuery q = null;

        List<OWLAxiomChange> actions1 = null;



        	List<Variable> vds = new ArrayList<Variable>();

        try {
            // /Users/luigi/Documents/workspace/PARSERS/src/OPPLTypes.g:128:2: ( ^( OPPL_STATEMENT (vd= variableDefinitions )? (q= query )? actions ) )
            // /Users/luigi/Documents/workspace/PARSERS/src/OPPLTypes.g:129:3: ^( OPPL_STATEMENT (vd= variableDefinitions )? (q= query )? actions )
            {
            match(input,OPPL_STATEMENT,FOLLOW_OPPL_STATEMENT_in_statement103); if (state.failed) return retval;

            match(input, Token.DOWN, null); if (state.failed) return retval;
            // /Users/luigi/Documents/workspace/PARSERS/src/OPPLTypes.g:129:23: (vd= variableDefinitions )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==VARIABLE_DEFINITIONS) ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // /Users/luigi/Documents/workspace/PARSERS/src/OPPLTypes.g:129:23: vd= variableDefinitions
                    {
                    pushFollow(FOLLOW_variableDefinitions_in_statement109);
                    vd=variableDefinitions();

                    state._fsp--;
                    if (state.failed) return retval;

                    }
                    break;

            }

            // /Users/luigi/Documents/workspace/PARSERS/src/OPPLTypes.g:129:47: (q= query )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==QUERY) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // /Users/luigi/Documents/workspace/PARSERS/src/OPPLTypes.g:129:47: q= query
                    {
                    pushFollow(FOLLOW_query_in_statement114);
                    q=query();

                    state._fsp--;
                    if (state.failed) return retval;

                    }
                    break;

            }

            pushFollow(FOLLOW_actions_in_statement117);
            actions1=actions();

            state._fsp--;
            if (state.failed) return retval;

            match(input, Token.UP, null); if (state.failed) return retval;
            if ( state.backtracking==1 ) {

              			if(vd!=null){
              				vds.addAll(vd);
              			}
              			if(!actions1.isEmpty()){
              			 if(q!=null){
              			    ((OPPLSyntaxTree)retval.start).setOPPLContent(getOPPLFactory().buildOPPLScript(getConstraintSystem(),
              				    					vds, q,
              					    				actions1));
              			 }else{
              			    ((OPPLSyntaxTree)retval.start).setOPPLContent(getOPPLFactory().buildOPPLScript(getConstraintSystem(),
                                  vds, null,
                                  actions1));
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
    // $ANTLR end "statement"


    // $ANTLR start "variableDefinitions"
    // /Users/luigi/Documents/workspace/PARSERS/src/OPPLTypes.g:148:1: variableDefinitions returns [List<Variable> variables] : ^( VARIABLE_DEFINITIONS (vd= variableDefinition )+ ) ;
    public final List<Variable> variableDefinitions() throws RecognitionException {
        List<Variable> variables = null;

        OPPLTypes.variableDefinition_return vd = null;



        	List<Variable> toReturn = new ArrayList<Variable>();

        try {
            // /Users/luigi/Documents/workspace/PARSERS/src/OPPLTypes.g:155:2: ( ^( VARIABLE_DEFINITIONS (vd= variableDefinition )+ ) )
            // /Users/luigi/Documents/workspace/PARSERS/src/OPPLTypes.g:156:3: ^( VARIABLE_DEFINITIONS (vd= variableDefinition )+ )
            {
            match(input,VARIABLE_DEFINITIONS,FOLLOW_VARIABLE_DEFINITIONS_in_variableDefinitions148); if (state.failed) return variables;

            match(input, Token.DOWN, null); if (state.failed) return variables;
            // /Users/luigi/Documents/workspace/PARSERS/src/OPPLTypes.g:156:26: (vd= variableDefinition )+
            int cnt3=0;
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0>=INPUT_VARIABLE_DEFINITION && LA3_0<=GENERATED_VARIABLE_DEFINITION)) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // /Users/luigi/Documents/workspace/PARSERS/src/OPPLTypes.g:156:27: vd= variableDefinition
            	    {
            	    pushFollow(FOLLOW_variableDefinition_in_variableDefinitions155);
            	    vd=variableDefinition();

            	    state._fsp--;
            	    if (state.failed) return variables;
            	    if ( state.backtracking==1 ) {
            	      toReturn.add(vd.variable);
            	    }

            	    }
            	    break;

            	default :
            	    if ( cnt3 >= 1 ) break loop3;
            	    if (state.backtracking>0) {state.failed=true; return variables;}
                        EarlyExitException eee =
                            new EarlyExitException(3, input);
                        throw eee;
                }
                cnt3++;
            } while (true);


            match(input, Token.UP, null); if (state.failed) return variables;

            }

            if ( state.backtracking==1 ) {

              	variables = toReturn;

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
        return variables;
    }
    // $ANTLR end "variableDefinitions"


    // $ANTLR start "query"
    // /Users/luigi/Documents/workspace/PARSERS/src/OPPLTypes.g:159:1: query returns [OPPLQuery query] : ^( QUERY ( selectClause )+ ( constraint )? ) ;
    public final OPPLQuery query() throws RecognitionException {
        OPPLQuery query = null;

        OPPLTypes.selectClause_return selectClause2 = null;

        OPPLTypes.constraint_return constraint3 = null;



        		query = getOPPLFactory().buildNewQuery(getConstraintSystem());

        try {
            // /Users/luigi/Documents/workspace/PARSERS/src/OPPLTypes.g:163:2: ( ^( QUERY ( selectClause )+ ( constraint )? ) )
            // /Users/luigi/Documents/workspace/PARSERS/src/OPPLTypes.g:164:3: ^( QUERY ( selectClause )+ ( constraint )? )
            {
            match(input,QUERY,FOLLOW_QUERY_in_query185); if (state.failed) return query;

            match(input, Token.DOWN, null); if (state.failed) return query;
            // /Users/luigi/Documents/workspace/PARSERS/src/OPPLTypes.g:164:11: ( selectClause )+
            int cnt4=0;
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( ((LA4_0>=ASSERTED_CLAUSE && LA4_0<=PLAIN_CLAUSE)) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // /Users/luigi/Documents/workspace/PARSERS/src/OPPLTypes.g:164:12: selectClause
            	    {
            	    pushFollow(FOLLOW_selectClause_in_query188);
            	    selectClause2=selectClause();

            	    state._fsp--;
            	    if (state.failed) return query;
            	    if ( state.backtracking==1 ) {

            	      		  if((selectClause2!=null?selectClause2.axiom:null)!=null){
            	      			   if((selectClause2!=null?selectClause2.asserted:false)){
            	      				  query.addAssertedAxiom((selectClause2!=null?selectClause2.axiom:null));
            	      			   }else{
            	      				  query.addAxiom((selectClause2!=null?selectClause2.axiom:null));
            	      			   }
            	      			}
            	      		
            	    }

            	    }
            	    break;

            	default :
            	    if ( cnt4 >= 1 ) break loop4;
            	    if (state.backtracking>0) {state.failed=true; return query;}
                        EarlyExitException eee =
                            new EarlyExitException(4, input);
                        throw eee;
                }
                cnt4++;
            } while (true);

            // /Users/luigi/Documents/workspace/PARSERS/src/OPPLTypes.g:174:6: ( constraint )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( ((LA5_0>=INEQUALITY_CONSTRAINT && LA5_0<=IN_SET_CONSTRAINT)||LA5_0==REGEXP_CONSTRAINT||LA5_0==NAF_CONSTRAINT) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // /Users/luigi/Documents/workspace/PARSERS/src/OPPLTypes.g:174:7: constraint
                    {
                    pushFollow(FOLLOW_constraint_in_query201);
                    constraint3=constraint();

                    state._fsp--;
                    if (state.failed) return query;
                    if ( state.backtracking==1 ) {

                      				  if((constraint3!=null?constraint3.constraint:null)!=null){
                      					 query.addConstraint((constraint3!=null?constraint3.constraint:null));
                      					}
                      				
                    }

                    }
                    break;

            }


            match(input, Token.UP, null); if (state.failed) return query;

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
        return query;
    }
    // $ANTLR end "query"

    public static class selectClause_return extends TreeRuleReturnScope {
        public OWLAxiom axiom;
        public boolean asserted;
    };

    // $ANTLR start "selectClause"
    // /Users/luigi/Documents/workspace/PARSERS/src/OPPLTypes.g:183:1: selectClause returns [OWLAxiom axiom, boolean asserted] : ( ^( ASSERTED_CLAUSE a= . ) | ^( PLAIN_CLAUSE a= . ) );
    public final OPPLTypes.selectClause_return selectClause() throws RecognitionException {
        OPPLTypes.selectClause_return retval = new OPPLTypes.selectClause_return();
        retval.start = input.LT(1);

        OPPLSyntaxTree a=null;

        try {
            // /Users/luigi/Documents/workspace/PARSERS/src/OPPLTypes.g:184:2: ( ^( ASSERTED_CLAUSE a= . ) | ^( PLAIN_CLAUSE a= . ) )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==ASSERTED_CLAUSE) ) {
                alt6=1;
            }
            else if ( (LA6_0==PLAIN_CLAUSE) ) {
                alt6=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // /Users/luigi/Documents/workspace/PARSERS/src/OPPLTypes.g:185:3: ^( ASSERTED_CLAUSE a= . )
                    {
                    match(input,ASSERTED_CLAUSE,FOLLOW_ASSERTED_CLAUSE_in_selectClause231); if (state.failed) return retval;

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    a=(OPPLSyntaxTree)input.LT(1);
                    matchAny(input); if (state.failed) return retval;

                    match(input, Token.UP, null); if (state.failed) return retval;
                    if ( state.backtracking==1 ) {

                      			OWLObject object = a.getOWLObject();
                      			if(object instanceof OWLAxiom){
                      				retval.axiom = (OWLAxiom) a.getOWLObject();
                      			}else{
                      				getErrorListener().illegalToken(a,"OWL Axiom needed here");
                      			}			
                      			
                      			retval.asserted = true;
                      		
                    }

                    }
                    break;
                case 2 :
                    // /Users/luigi/Documents/workspace/PARSERS/src/OPPLTypes.g:196:5: ^( PLAIN_CLAUSE a= . )
                    {
                    match(input,PLAIN_CLAUSE,FOLLOW_PLAIN_CLAUSE_in_selectClause249); if (state.failed) return retval;

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    a=(OPPLSyntaxTree)input.LT(1);
                    matchAny(input); if (state.failed) return retval;

                    match(input, Token.UP, null); if (state.failed) return retval;
                    if ( state.backtracking==1 ) {

                      			OWLObject object = a.getOWLObject();
                      			if(object instanceof OWLAxiom){
                      				retval.axiom = (OWLAxiom) a.getOWLObject();
                      			}else{
                      				getErrorListener().illegalToken(a,"OWL Axiom needed here");
                      			}
                      			retval.asserted = false;
                      		
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
        return retval;
    }
    // $ANTLR end "selectClause"


    // $ANTLR start "actions"
    // /Users/luigi/Documents/workspace/PARSERS/src/OPPLTypes.g:208:1: actions returns [List<OWLAxiomChange> actions] : ^( ACTIONS ( action )+ ) ;
    public final List<OWLAxiomChange> actions() throws RecognitionException {
        List<OWLAxiomChange> actions = null;

        OWLAxiomChange action4 = null;



        	actions = new ArrayList<OWLAxiomChange>();

        try {
            // /Users/luigi/Documents/workspace/PARSERS/src/OPPLTypes.g:212:2: ( ^( ACTIONS ( action )+ ) )
            // /Users/luigi/Documents/workspace/PARSERS/src/OPPLTypes.g:213:3: ^( ACTIONS ( action )+ )
            {
            match(input,ACTIONS,FOLLOW_ACTIONS_in_actions282); if (state.failed) return actions;

            match(input, Token.DOWN, null); if (state.failed) return actions;
            // /Users/luigi/Documents/workspace/PARSERS/src/OPPLTypes.g:213:13: ( action )+
            int cnt7=0;
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( ((LA7_0>=ADD && LA7_0<=REMOVE)) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // /Users/luigi/Documents/workspace/PARSERS/src/OPPLTypes.g:213:14: action
            	    {
            	    pushFollow(FOLLOW_action_in_actions285);
            	    action4=action();

            	    state._fsp--;
            	    if (state.failed) return actions;
            	    if ( state.backtracking==1 ) {

            	      		  if(action4!=null){
            	      		    actions.add(action4);
            	      		  }
            	      		
            	    }

            	    }
            	    break;

            	default :
            	    if ( cnt7 >= 1 ) break loop7;
            	    if (state.backtracking>0) {state.failed=true; return actions;}
                        EarlyExitException eee =
                            new EarlyExitException(7, input);
                        throw eee;
                }
                cnt7++;
            } while (true);


            match(input, Token.UP, null); if (state.failed) return actions;

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
        return actions;
    }
    // $ANTLR end "actions"


    // $ANTLR start "action"
    // /Users/luigi/Documents/workspace/PARSERS/src/OPPLTypes.g:223:1: action returns [OWLAxiomChange change] : ( ^( ADD a= . ) | ^( REMOVE a= . ) );
    public final OWLAxiomChange action() throws RecognitionException {
        OWLAxiomChange change = null;

        OPPLSyntaxTree a=null;

        try {
            // /Users/luigi/Documents/workspace/PARSERS/src/OPPLTypes.g:224:2: ( ^( ADD a= . ) | ^( REMOVE a= . ) )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==ADD) ) {
                alt8=1;
            }
            else if ( (LA8_0==REMOVE) ) {
                alt8=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return change;}
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }
            switch (alt8) {
                case 1 :
                    // /Users/luigi/Documents/workspace/PARSERS/src/OPPLTypes.g:225:3: ^( ADD a= . )
                    {
                    match(input,ADD,FOLLOW_ADD_in_action316); if (state.failed) return change;

                    match(input, Token.DOWN, null); if (state.failed) return change;
                    a=(OPPLSyntaxTree)input.LT(1);
                    matchAny(input); if (state.failed) return change;

                    match(input, Token.UP, null); if (state.failed) return change;
                    if ( state.backtracking==1 ) {

                      			OWLObject object = a.getOWLObject();
                      			if(object instanceof OWLAxiom){
                      				change = new AddAxiom(getConstraintSystem().getOntology(), (OWLAxiom)object);
                      			}else{
                      				getErrorListener().illegalToken(a,"OWL Axiom needed here");
                      			}	
                      		
                    }

                    }
                    break;
                case 2 :
                    // /Users/luigi/Documents/workspace/PARSERS/src/OPPLTypes.g:233:5: ^( REMOVE a= . )
                    {
                    match(input,REMOVE,FOLLOW_REMOVE_in_action331); if (state.failed) return change;

                    match(input, Token.DOWN, null); if (state.failed) return change;
                    a=(OPPLSyntaxTree)input.LT(1);
                    matchAny(input); if (state.failed) return change;

                    match(input, Token.UP, null); if (state.failed) return change;
                    if ( state.backtracking==1 ) {

                      			OWLObject object = a.getOWLObject();
                      			if(object instanceof OWLAxiom){
                      				change = new RemoveAxiom(getConstraintSystem().getOntology(), (OWLAxiom)object);
                      			}else{
                      				getErrorListener().illegalToken(a,"OWL Axiom needed here");
                      			}
                      		
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
        return change;
    }
    // $ANTLR end "action"

    public static class variableDefinition_return extends TreeRuleReturnScope {
        public Variable variable;
    };

    // $ANTLR start "variableDefinition"
    // /Users/luigi/Documents/workspace/PARSERS/src/OPPLTypes.g:243:1: variableDefinition returns [Variable variable] : ( ^( INPUT_VARIABLE_DEFINITION VARIABLE_NAME VARIABLE_TYPE (vs= variableScope )? ) | ^( GENERATED_VARIABLE_DEFINITION VARIABLE_NAME generatedVariableAssignment ) | ^( GENERATED_VARIABLE_DEFINITION VARIABLE_NAME VARIABLE_TYPE ^( MATCH se= stringOperation ) ) | ^( GENERATED_VARIABLE_DEFINITION VARIABLE_NAME VARIABLE_TYPE ^( CREATE_OPPL_FUNCTION value= stringOperation ) ) | ^( GENERATED_VARIABLE_DEFINITION name= VARIABLE_NAME VARIABLE_TYPE ^( CREATE_INTERSECTION va= IDENTIFIER ) ) | ^( GENERATED_VARIABLE_DEFINITION name= VARIABLE_NAME VARIABLE_TYPE ^( CREATE_DISJUNCTION va= IDENTIFIER ) ) );
    public final OPPLTypes.variableDefinition_return variableDefinition() throws RecognitionException {
        OPPLTypes.variableDefinition_return retval = new OPPLTypes.variableDefinition_return();
        retval.start = input.LT(1);

        OPPLSyntaxTree name=null;
        OPPLSyntaxTree va=null;
        OPPLSyntaxTree VARIABLE_NAME5=null;
        OPPLSyntaxTree VARIABLE_TYPE6=null;
        OPPLSyntaxTree INPUT_VARIABLE_DEFINITION7=null;
        OPPLSyntaxTree VARIABLE_NAME8=null;
        OPPLSyntaxTree VARIABLE_TYPE10=null;
        OPPLSyntaxTree VARIABLE_NAME11=null;
        OPPLSyntaxTree VARIABLE_TYPE12=null;
        OPPLSyntaxTree VARIABLE_NAME13=null;
        OPPLSyntaxTree VARIABLE_TYPE14=null;
        OPPLSyntaxTree VARIABLE_TYPE15=null;
        OPPLTypes.variableScope_return vs = null;

        SingleValueGeneratedValue<String> se = null;

        SingleValueGeneratedValue<String> value = null;

        OPPLTypes.generatedVariableAssignment_return generatedVariableAssignment9 = null;


        try {
            // /Users/luigi/Documents/workspace/PARSERS/src/OPPLTypes.g:244:2: ( ^( INPUT_VARIABLE_DEFINITION VARIABLE_NAME VARIABLE_TYPE (vs= variableScope )? ) | ^( GENERATED_VARIABLE_DEFINITION VARIABLE_NAME generatedVariableAssignment ) | ^( GENERATED_VARIABLE_DEFINITION VARIABLE_NAME VARIABLE_TYPE ^( MATCH se= stringOperation ) ) | ^( GENERATED_VARIABLE_DEFINITION VARIABLE_NAME VARIABLE_TYPE ^( CREATE_OPPL_FUNCTION value= stringOperation ) ) | ^( GENERATED_VARIABLE_DEFINITION name= VARIABLE_NAME VARIABLE_TYPE ^( CREATE_INTERSECTION va= IDENTIFIER ) ) | ^( GENERATED_VARIABLE_DEFINITION name= VARIABLE_NAME VARIABLE_TYPE ^( CREATE_DISJUNCTION va= IDENTIFIER ) ) )
            int alt10=6;
            alt10 = dfa10.predict(input);
            switch (alt10) {
                case 1 :
                    // /Users/luigi/Documents/workspace/PARSERS/src/OPPLTypes.g:245:5: ^( INPUT_VARIABLE_DEFINITION VARIABLE_NAME VARIABLE_TYPE (vs= variableScope )? )
                    {
                    INPUT_VARIABLE_DEFINITION7=(OPPLSyntaxTree)match(input,INPUT_VARIABLE_DEFINITION,FOLLOW_INPUT_VARIABLE_DEFINITION_in_variableDefinition361); if (state.failed) return retval;

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    VARIABLE_NAME5=(OPPLSyntaxTree)match(input,VARIABLE_NAME,FOLLOW_VARIABLE_NAME_in_variableDefinition363); if (state.failed) return retval;
                    VARIABLE_TYPE6=(OPPLSyntaxTree)match(input,VARIABLE_TYPE,FOLLOW_VARIABLE_TYPE_in_variableDefinition365); if (state.failed) return retval;
                    // /Users/luigi/Documents/workspace/PARSERS/src/OPPLTypes.g:245:64: (vs= variableScope )?
                    int alt9=2;
                    int LA9_0 = input.LA(1);

                    if ( (LA9_0==VARIABLE_SCOPE) ) {
                        alt9=1;
                    }
                    switch (alt9) {
                        case 1 :
                            // /Users/luigi/Documents/workspace/PARSERS/src/OPPLTypes.g:245:64: vs= variableScope
                            {
                            pushFollow(FOLLOW_variableScope_in_variableDefinition371);
                            vs=variableScope();

                            state._fsp--;
                            if (state.failed) return retval;

                            }
                            break;

                    }


                    match(input, Token.UP, null); if (state.failed) return retval;
                    if ( state.backtracking==1 ) {

                      		  try {
                      		      retval.variable = getConstraintSystem().createVariable(VARIABLE_NAME5.getToken().getText(), symtab.getVaribaleType(VARIABLE_TYPE6));
                      		      if(vs !=null){
                      		        retval.variable.setVariableScope(vs.variableScope, getOPPLFactory().getVariableScopeChecker());
                      		      }
                      		   } catch(OPPLException e){
                      		      getErrorListener().reportThrowable(e, INPUT_VARIABLE_DEFINITION7.token.getLine(), INPUT_VARIABLE_DEFINITION7.token.getCharPositionInLine(),INPUT_VARIABLE_DEFINITION7.token.getText().length());
                      		   }
                      		  
                    }

                    }
                    break;
                case 2 :
                    // /Users/luigi/Documents/workspace/PARSERS/src/OPPLTypes.g:256:6: ^( GENERATED_VARIABLE_DEFINITION VARIABLE_NAME generatedVariableAssignment )
                    {
                    match(input,GENERATED_VARIABLE_DEFINITION,FOLLOW_GENERATED_VARIABLE_DEFINITION_in_variableDefinition387); if (state.failed) return retval;

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    VARIABLE_NAME8=(OPPLSyntaxTree)match(input,VARIABLE_NAME,FOLLOW_VARIABLE_NAME_in_variableDefinition389); if (state.failed) return retval;
                    pushFollow(FOLLOW_generatedVariableAssignment_in_variableDefinition391);
                    generatedVariableAssignment9=generatedVariableAssignment();

                    state._fsp--;
                    if (state.failed) return retval;

                    match(input, Token.UP, null); if (state.failed) return retval;
                    if ( state.backtracking==1 ) {

                      	       VariableExpressionGeneratedVariable variableExpressionGeneratedVariable = new VariableExpressionGeneratedVariable(
                              VARIABLE_NAME8.getText(), (generatedVariableAssignment9!=null?generatedVariableAssignment9.owlObject:null), getConstraintSystem());
                              getConstraintSystem().importVariable(variableExpressionGeneratedVariable);
                              retval.variable = variableExpressionGeneratedVariable;
                      	    
                    }

                    }
                    break;
                case 3 :
                    // /Users/luigi/Documents/workspace/PARSERS/src/OPPLTypes.g:263:7: ^( GENERATED_VARIABLE_DEFINITION VARIABLE_NAME VARIABLE_TYPE ^( MATCH se= stringOperation ) )
                    {
                    match(input,GENERATED_VARIABLE_DEFINITION,FOLLOW_GENERATED_VARIABLE_DEFINITION_in_variableDefinition408); if (state.failed) return retval;

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    VARIABLE_NAME11=(OPPLSyntaxTree)match(input,VARIABLE_NAME,FOLLOW_VARIABLE_NAME_in_variableDefinition410); if (state.failed) return retval;
                    VARIABLE_TYPE10=(OPPLSyntaxTree)match(input,VARIABLE_TYPE,FOLLOW_VARIABLE_TYPE_in_variableDefinition412); if (state.failed) return retval;
                    match(input,MATCH,FOLLOW_MATCH_in_variableDefinition415); if (state.failed) return retval;

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    pushFollow(FOLLOW_stringOperation_in_variableDefinition421);
                    se=stringOperation();

                    state._fsp--;
                    if (state.failed) return retval;

                    match(input, Token.UP, null); if (state.failed) return retval;

                    match(input, Token.UP, null); if (state.failed) return retval;
                    if ( state.backtracking==1 ) {

                      	       org.coode.oppl.VariableType type = org.coode.parsers.oppl.VariableType.getVariableType(VARIABLE_TYPE10.getText()).getOPPLVariableType();

                                OWLEntityRenderer renderer = getOPPLFactory().getOWLEntityRenderer(getConstraintSystem());
                      	  RegExpGenerated<?> v = type.getRegExpGenerated(
                      							VARIABLE_NAME11.getText(),
                      							renderer,
                      							se,
                      							this.getConstraintSystem().getOntologyManager().getOntologies());
                      					this.constraintSystem.importVariable(v);
                                constraintSystem.importVariable(v);
                                retval.variable = v;
                      	     
                    }

                    }
                    break;
                case 4 :
                    // /Users/luigi/Documents/workspace/PARSERS/src/OPPLTypes.g:277:6: ^( GENERATED_VARIABLE_DEFINITION VARIABLE_NAME VARIABLE_TYPE ^( CREATE_OPPL_FUNCTION value= stringOperation ) )
                    {
                    match(input,GENERATED_VARIABLE_DEFINITION,FOLLOW_GENERATED_VARIABLE_DEFINITION_in_variableDefinition440); if (state.failed) return retval;

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    VARIABLE_NAME13=(OPPLSyntaxTree)match(input,VARIABLE_NAME,FOLLOW_VARIABLE_NAME_in_variableDefinition442); if (state.failed) return retval;
                    VARIABLE_TYPE12=(OPPLSyntaxTree)match(input,VARIABLE_TYPE,FOLLOW_VARIABLE_TYPE_in_variableDefinition444); if (state.failed) return retval;
                    match(input,CREATE_OPPL_FUNCTION,FOLLOW_CREATE_OPPL_FUNCTION_in_variableDefinition447); if (state.failed) return retval;

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    pushFollow(FOLLOW_stringOperation_in_variableDefinition454);
                    value=stringOperation();

                    state._fsp--;
                    if (state.failed) return retval;

                    match(input, Token.UP, null); if (state.failed) return retval;

                    match(input, Token.UP, null); if (state.failed) return retval;
                    if ( state.backtracking==1 ) {

                      	       org.coode.oppl.VariableType type = org.coode.parsers.oppl.VariableType.getVariableType(VARIABLE_TYPE12.getText()).getOPPLVariableType();
                      	       retval.variable = constraintSystem.createStringGeneratedVariable(VARIABLE_NAME13.getText(),type, value);
                      	     
                    }

                    }
                    break;
                case 5 :
                    // /Users/luigi/Documents/workspace/PARSERS/src/OPPLTypes.g:282:7: ^( GENERATED_VARIABLE_DEFINITION name= VARIABLE_NAME VARIABLE_TYPE ^( CREATE_INTERSECTION va= IDENTIFIER ) )
                    {
                    match(input,GENERATED_VARIABLE_DEFINITION,FOLLOW_GENERATED_VARIABLE_DEFINITION_in_variableDefinition473); if (state.failed) return retval;

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    name=(OPPLSyntaxTree)match(input,VARIABLE_NAME,FOLLOW_VARIABLE_NAME_in_variableDefinition479); if (state.failed) return retval;
                    VARIABLE_TYPE14=(OPPLSyntaxTree)match(input,VARIABLE_TYPE,FOLLOW_VARIABLE_TYPE_in_variableDefinition481); if (state.failed) return retval;
                    match(input,CREATE_INTERSECTION,FOLLOW_CREATE_INTERSECTION_in_variableDefinition484); if (state.failed) return retval;

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    va=(OPPLSyntaxTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_variableDefinition490); if (state.failed) return retval;

                    match(input, Token.UP, null); if (state.failed) return retval;

                    match(input, Token.UP, null); if (state.failed) return retval;
                    if ( state.backtracking==1 ) {

                               org.coode.oppl.VariableType type = org.coode.parsers.oppl.VariableType.getVariableType(VARIABLE_TYPE14.getText()).getOPPLVariableType();
                               AbstractCollectionGeneratedValue<OWLClass> collection = symtab.getCollection(((OPPLSyntaxTree)retval.start),va, getConstraintSystem());
                               retval.variable = constraintSystem.createIntersectionGeneratedVariable(name.getText(),type,collection);         
                             
                    }

                    }
                    break;
                case 6 :
                    // /Users/luigi/Documents/workspace/PARSERS/src/OPPLTypes.g:288:9: ^( GENERATED_VARIABLE_DEFINITION name= VARIABLE_NAME VARIABLE_TYPE ^( CREATE_DISJUNCTION va= IDENTIFIER ) )
                    {
                    match(input,GENERATED_VARIABLE_DEFINITION,FOLLOW_GENERATED_VARIABLE_DEFINITION_in_variableDefinition512); if (state.failed) return retval;

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    name=(OPPLSyntaxTree)match(input,VARIABLE_NAME,FOLLOW_VARIABLE_NAME_in_variableDefinition518); if (state.failed) return retval;
                    VARIABLE_TYPE15=(OPPLSyntaxTree)match(input,VARIABLE_TYPE,FOLLOW_VARIABLE_TYPE_in_variableDefinition520); if (state.failed) return retval;
                    match(input,CREATE_DISJUNCTION,FOLLOW_CREATE_DISJUNCTION_in_variableDefinition523); if (state.failed) return retval;

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    va=(OPPLSyntaxTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_variableDefinition529); if (state.failed) return retval;

                    match(input, Token.UP, null); if (state.failed) return retval;

                    match(input, Token.UP, null); if (state.failed) return retval;
                    if ( state.backtracking==1 ) {

                               org.coode.oppl.VariableType type = org.coode.parsers.oppl.VariableType.getVariableType(VARIABLE_TYPE15.getText()).getOPPLVariableType();
                               AbstractCollectionGeneratedValue<OWLClass> collection = symtab.getCollection(((OPPLSyntaxTree)retval.start),va, getConstraintSystem());
                               retval.variable = constraintSystem.createUnionGeneratedVariable(name.getText(),type,collection);         
                             
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
        return retval;
    }
    // $ANTLR end "variableDefinition"


    // $ANTLR start "stringOperation"
    // /Users/luigi/Documents/workspace/PARSERS/src/OPPLTypes.g:301:1: stringOperation returns [SingleValueGeneratedValue<String> value] : ^( STRING_OPERATION (valuesToAggregate= stringExpression )+ ) ;
    public final SingleValueGeneratedValue<String> stringOperation() throws RecognitionException {
        SingleValueGeneratedValue<String> value = null;

        SingleValueGeneratedValue<String> valuesToAggregate = null;



            List<SingleValueGeneratedValue<String>> values = new ArrayList<SingleValueGeneratedValue<String>>();
          
        try {
            // /Users/luigi/Documents/workspace/PARSERS/src/OPPLTypes.g:306:3: ( ^( STRING_OPERATION (valuesToAggregate= stringExpression )+ ) )
            // /Users/luigi/Documents/workspace/PARSERS/src/OPPLTypes.g:307:5: ^( STRING_OPERATION (valuesToAggregate= stringExpression )+ )
            {
            match(input,STRING_OPERATION,FOLLOW_STRING_OPERATION_in_stringOperation588); if (state.failed) return value;

            match(input, Token.DOWN, null); if (state.failed) return value;
            // /Users/luigi/Documents/workspace/PARSERS/src/OPPLTypes.g:307:25: (valuesToAggregate= stringExpression )+
            int cnt11=0;
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==DBLQUOTE||LA11_0==IDENTIFIER) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // /Users/luigi/Documents/workspace/PARSERS/src/OPPLTypes.g:307:26: valuesToAggregate= stringExpression
            	    {
            	    pushFollow(FOLLOW_stringExpression_in_stringOperation595);
            	    valuesToAggregate=stringExpression();

            	    state._fsp--;
            	    if (state.failed) return value;
            	    if ( state.backtracking==1 ) {
            	      values.add(valuesToAggregate);
            	    }

            	    }
            	    break;

            	default :
            	    if ( cnt11 >= 1 ) break loop11;
            	    if (state.backtracking>0) {state.failed=true; return value;}
                        EarlyExitException eee =
                            new EarlyExitException(11, input);
                        throw eee;
                }
                cnt11++;
            } while (true);


            match(input, Token.UP, null); if (state.failed) return value;
            if ( state.backtracking==1 ) {

                    value = new ConcatGeneratedValues(values); 
                  
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
        return value;
    }
    // $ANTLR end "stringOperation"


    // $ANTLR start "stringExpression"
    // /Users/luigi/Documents/workspace/PARSERS/src/OPPLTypes.g:314:1: stringExpression returns [SingleValueGeneratedValue<String> value] : ( DBLQUOTE | IDENTIFIER );
    public final SingleValueGeneratedValue<String> stringExpression() throws RecognitionException {
        SingleValueGeneratedValue<String> value = null;

        OPPLSyntaxTree DBLQUOTE16=null;
        OPPLSyntaxTree IDENTIFIER17=null;

        try {
            // /Users/luigi/Documents/workspace/PARSERS/src/OPPLTypes.g:315:3: ( DBLQUOTE | IDENTIFIER )
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==DBLQUOTE) ) {
                alt12=1;
            }
            else if ( (LA12_0==IDENTIFIER) ) {
                alt12=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return value;}
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;
            }
            switch (alt12) {
                case 1 :
                    // /Users/luigi/Documents/workspace/PARSERS/src/OPPLTypes.g:316:7: DBLQUOTE
                    {
                    DBLQUOTE16=(OPPLSyntaxTree)match(input,DBLQUOTE,FOLLOW_DBLQUOTE_in_stringExpression632); if (state.failed) return value;
                    if ( state.backtracking==1 ) {

                              value = new StringGeneratedValue(DBLQUOTE16.getText());
                            
                    }

                    }
                    break;
                case 2 :
                    // /Users/luigi/Documents/workspace/PARSERS/src/OPPLTypes.g:320:7: IDENTIFIER
                    {
                    IDENTIFIER17=(OPPLSyntaxTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_stringExpression648); if (state.failed) return value;
                    if ( state.backtracking==1 ) {

                              value =symtab.getStringGeneratedValue(IDENTIFIER17, getConstraintSystem());
                            
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
        return value;
    }
    // $ANTLR end "stringExpression"

    public static class generatedVariableAssignment_return extends TreeRuleReturnScope {
        public Type type;
        public OWLObject owlObject;
    };

    // $ANTLR start "generatedVariableAssignment"
    // /Users/luigi/Documents/workspace/PARSERS/src/OPPLTypes.g:329:1: generatedVariableAssignment returns [Type type, OWLObject owlObject] : ( ^( CLASS ^( EXPRESSION classExpression= . ) ) | ^( OBJECTPROPERTY ^( EXPRESSION objectPropertyExpression= . ) ) | ^( DATAPROPERTY ^( EXPRESSION dataPropertyExpression= . ) ) | ^( INDIVIDUAL ^( EXPRESSION individualExpression= . ) ) | ^( CONSTANT ^( EXPRESSION constantExpression= . ) ) );
    public final OPPLTypes.generatedVariableAssignment_return generatedVariableAssignment() throws RecognitionException {
        OPPLTypes.generatedVariableAssignment_return retval = new OPPLTypes.generatedVariableAssignment_return();
        retval.start = input.LT(1);

        OPPLSyntaxTree classExpression=null;
        OPPLSyntaxTree objectPropertyExpression=null;
        OPPLSyntaxTree dataPropertyExpression=null;
        OPPLSyntaxTree individualExpression=null;
        OPPLSyntaxTree constantExpression=null;

        try {
            // /Users/luigi/Documents/workspace/PARSERS/src/OPPLTypes.g:334:3: ( ^( CLASS ^( EXPRESSION classExpression= . ) ) | ^( OBJECTPROPERTY ^( EXPRESSION objectPropertyExpression= . ) ) | ^( DATAPROPERTY ^( EXPRESSION dataPropertyExpression= . ) ) | ^( INDIVIDUAL ^( EXPRESSION individualExpression= . ) ) | ^( CONSTANT ^( EXPRESSION constantExpression= . ) ) )
            int alt13=5;
            switch ( input.LA(1) ) {
            case CLASS:
                {
                alt13=1;
                }
                break;
            case OBJECTPROPERTY:
                {
                alt13=2;
                }
                break;
            case DATAPROPERTY:
                {
                alt13=3;
                }
                break;
            case INDIVIDUAL:
                {
                alt13=4;
                }
                break;
            case CONSTANT:
                {
                alt13=5;
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
                    // /Users/luigi/Documents/workspace/PARSERS/src/OPPLTypes.g:335:5: ^( CLASS ^( EXPRESSION classExpression= . ) )
                    {
                    match(input,CLASS,FOLLOW_CLASS_in_generatedVariableAssignment697); if (state.failed) return retval;

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    match(input,EXPRESSION,FOLLOW_EXPRESSION_in_generatedVariableAssignment700); if (state.failed) return retval;

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    classExpression=(OPPLSyntaxTree)input.LT(1);
                    matchAny(input); if (state.failed) return retval;

                    match(input, Token.UP, null); if (state.failed) return retval;

                    match(input, Token.UP, null); if (state.failed) return retval;
                    if ( state.backtracking==1 ) {

                            retval.type = symtab.getClassGeneratedVariable(((OPPLSyntaxTree)retval.start), classExpression);
                            retval.owlObject = classExpression.getOWLObject();
                          
                    }

                    }
                    break;
                case 2 :
                    // /Users/luigi/Documents/workspace/PARSERS/src/OPPLTypes.g:340:5: ^( OBJECTPROPERTY ^( EXPRESSION objectPropertyExpression= . ) )
                    {
                    match(input,OBJECTPROPERTY,FOLLOW_OBJECTPROPERTY_in_generatedVariableAssignment719); if (state.failed) return retval;

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    match(input,EXPRESSION,FOLLOW_EXPRESSION_in_generatedVariableAssignment722); if (state.failed) return retval;

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    objectPropertyExpression=(OPPLSyntaxTree)input.LT(1);
                    matchAny(input); if (state.failed) return retval;

                    match(input, Token.UP, null); if (state.failed) return retval;

                    match(input, Token.UP, null); if (state.failed) return retval;
                    if ( state.backtracking==1 ) {

                            retval.type = symtab.getObjectPropertyGeneratedVariable(((OPPLSyntaxTree)retval.start), objectPropertyExpression);
                            retval.owlObject = objectPropertyExpression.getOWLObject();
                          
                    }

                    }
                    break;
                case 3 :
                    // /Users/luigi/Documents/workspace/PARSERS/src/OPPLTypes.g:345:5: ^( DATAPROPERTY ^( EXPRESSION dataPropertyExpression= . ) )
                    {
                    match(input,DATAPROPERTY,FOLLOW_DATAPROPERTY_in_generatedVariableAssignment741); if (state.failed) return retval;

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    match(input,EXPRESSION,FOLLOW_EXPRESSION_in_generatedVariableAssignment744); if (state.failed) return retval;

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    dataPropertyExpression=(OPPLSyntaxTree)input.LT(1);
                    matchAny(input); if (state.failed) return retval;

                    match(input, Token.UP, null); if (state.failed) return retval;

                    match(input, Token.UP, null); if (state.failed) return retval;
                    if ( state.backtracking==1 ) {

                            retval.type = symtab.getDataPropertyGeneratedVariable(((OPPLSyntaxTree)retval.start), dataPropertyExpression);
                            retval.owlObject = dataPropertyExpression.getOWLObject();
                          
                    }

                    }
                    break;
                case 4 :
                    // /Users/luigi/Documents/workspace/PARSERS/src/OPPLTypes.g:350:5: ^( INDIVIDUAL ^( EXPRESSION individualExpression= . ) )
                    {
                    match(input,INDIVIDUAL,FOLLOW_INDIVIDUAL_in_generatedVariableAssignment763); if (state.failed) return retval;

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    match(input,EXPRESSION,FOLLOW_EXPRESSION_in_generatedVariableAssignment766); if (state.failed) return retval;

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    individualExpression=(OPPLSyntaxTree)input.LT(1);
                    matchAny(input); if (state.failed) return retval;

                    match(input, Token.UP, null); if (state.failed) return retval;

                    match(input, Token.UP, null); if (state.failed) return retval;
                    if ( state.backtracking==1 ) {

                            retval.type = symtab.getIndividualGeneratedVariable(((OPPLSyntaxTree)retval.start), individualExpression);
                            retval.owlObject = individualExpression.getOWLObject();
                          
                    }

                    }
                    break;
                case 5 :
                    // /Users/luigi/Documents/workspace/PARSERS/src/OPPLTypes.g:355:5: ^( CONSTANT ^( EXPRESSION constantExpression= . ) )
                    {
                    match(input,CONSTANT,FOLLOW_CONSTANT_in_generatedVariableAssignment785); if (state.failed) return retval;

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    match(input,EXPRESSION,FOLLOW_EXPRESSION_in_generatedVariableAssignment788); if (state.failed) return retval;

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    constantExpression=(OPPLSyntaxTree)input.LT(1);
                    matchAny(input); if (state.failed) return retval;

                    match(input, Token.UP, null); if (state.failed) return retval;

                    match(input, Token.UP, null); if (state.failed) return retval;
                    if ( state.backtracking==1 ) {

                            retval.type = symtab.getConstantGeneratedVariable(((OPPLSyntaxTree)retval.start), constantExpression);
                            retval.owlObject = constantExpression.getOWLObject();
                          
                    }

                    }
                    break;

            }
            if ( state.backtracking==1 ) {
               
                  ((OPPLSyntaxTree)retval.start).setEvalType(retval.type);     
                
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
    // $ANTLR end "generatedVariableAssignment"

    public static class variableScope_return extends TreeRuleReturnScope {
        public Type type;
        public VariableScope variableScope;
    };

    // $ANTLR start "variableScope"
    // /Users/luigi/Documents/workspace/PARSERS/src/OPPLTypes.g:363:1: variableScope returns [Type type, VariableScope variableScope] : ( ^( VARIABLE_SCOPE SUBCLASS_OF classExpression= . ) | ^( VARIABLE_SCOPE SUPER_CLASS_OF classExpression= . ) | ^( VARIABLE_SCOPE SUPER_PROPERTY_OF propertyExpression= . ) | ^( VARIABLE_SCOPE SUBPROPERTY_OF propertyExpression= . ) | ^( VARIABLE_SCOPE ( INSTANCE_OF | TYPES ) individualExpression= . ) );
    public final OPPLTypes.variableScope_return variableScope() throws RecognitionException {
        OPPLTypes.variableScope_return retval = new OPPLTypes.variableScope_return();
        retval.start = input.LT(1);

        OPPLSyntaxTree classExpression=null;
        OPPLSyntaxTree propertyExpression=null;
        OPPLSyntaxTree individualExpression=null;

        try {
            // /Users/luigi/Documents/workspace/PARSERS/src/OPPLTypes.g:368:2: ( ^( VARIABLE_SCOPE SUBCLASS_OF classExpression= . ) | ^( VARIABLE_SCOPE SUPER_CLASS_OF classExpression= . ) | ^( VARIABLE_SCOPE SUPER_PROPERTY_OF propertyExpression= . ) | ^( VARIABLE_SCOPE SUBPROPERTY_OF propertyExpression= . ) | ^( VARIABLE_SCOPE ( INSTANCE_OF | TYPES ) individualExpression= . ) )
            int alt14=5;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==VARIABLE_SCOPE) ) {
                int LA14_1 = input.LA(2);

                if ( (LA14_1==DOWN) ) {
                    switch ( input.LA(3) ) {
                    case SUBCLASS_OF:
                        {
                        alt14=1;
                        }
                        break;
                    case SUPER_CLASS_OF:
                        {
                        alt14=2;
                        }
                        break;
                    case SUPER_PROPERTY_OF:
                        {
                        alt14=3;
                        }
                        break;
                    case SUBPROPERTY_OF:
                        {
                        alt14=4;
                        }
                        break;
                    case INSTANCE_OF:
                    case TYPES:
                        {
                        alt14=5;
                        }
                        break;
                    default:
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 14, 2, input);

                        throw nvae;
                    }

                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 14, 1, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 14, 0, input);

                throw nvae;
            }
            switch (alt14) {
                case 1 :
                    // /Users/luigi/Documents/workspace/PARSERS/src/OPPLTypes.g:369:5: ^( VARIABLE_SCOPE SUBCLASS_OF classExpression= . )
                    {
                    match(input,VARIABLE_SCOPE,FOLLOW_VARIABLE_SCOPE_in_variableScope836); if (state.failed) return retval;

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    match(input,SUBCLASS_OF,FOLLOW_SUBCLASS_OF_in_variableScope838); if (state.failed) return retval;
                    classExpression=(OPPLSyntaxTree)input.LT(1);
                    matchAny(input); if (state.failed) return retval;

                    match(input, Token.UP, null); if (state.failed) return retval;
                    if ( state.backtracking==1 ) {

                      		   retval.type = symtab.getClassVariableScopeType(((OPPLSyntaxTree)retval.start), classExpression);
                      		   retval.variableScope = VariableScopes.buildSubClassVariableScope((OWLDescription)classExpression.getOWLObject());
                      	   
                    }

                    }
                    break;
                case 2 :
                    // /Users/luigi/Documents/workspace/PARSERS/src/OPPLTypes.g:374:7: ^( VARIABLE_SCOPE SUPER_CLASS_OF classExpression= . )
                    {
                    match(input,VARIABLE_SCOPE,FOLLOW_VARIABLE_SCOPE_in_variableScope860); if (state.failed) return retval;

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    match(input,SUPER_CLASS_OF,FOLLOW_SUPER_CLASS_OF_in_variableScope862); if (state.failed) return retval;
                    classExpression=(OPPLSyntaxTree)input.LT(1);
                    matchAny(input); if (state.failed) return retval;

                    match(input, Token.UP, null); if (state.failed) return retval;
                    if ( state.backtracking==1 ) {

                             retval.type = symtab.getClassVariableScopeType(((OPPLSyntaxTree)retval.start), classExpression);
                             retval.variableScope = VariableScopes.buildSuperClassVariableScope((OWLDescription)classExpression.getOWLObject());
                           
                    }

                    }
                    break;
                case 3 :
                    // /Users/luigi/Documents/workspace/PARSERS/src/OPPLTypes.g:379:5: ^( VARIABLE_SCOPE SUPER_PROPERTY_OF propertyExpression= . )
                    {
                    match(input,VARIABLE_SCOPE,FOLLOW_VARIABLE_SCOPE_in_variableScope886); if (state.failed) return retval;

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    match(input,SUPER_PROPERTY_OF,FOLLOW_SUPER_PROPERTY_OF_in_variableScope888); if (state.failed) return retval;
                    propertyExpression=(OPPLSyntaxTree)input.LT(1);
                    matchAny(input); if (state.failed) return retval;

                    match(input, Token.UP, null); if (state.failed) return retval;
                    if ( state.backtracking==1 ) {

                             retval.type = symtab.getPropertyVariableScopeType(((OPPLSyntaxTree)retval.start), propertyExpression);
                             retval.variableScope = VariableScopes.buildSuperPropertyVariableScope((OWLPropertyExpression<?,?>) propertyExpression.getOWLObject());
                           
                    }

                    }
                    break;
                case 4 :
                    // /Users/luigi/Documents/workspace/PARSERS/src/OPPLTypes.g:384:6: ^( VARIABLE_SCOPE SUBPROPERTY_OF propertyExpression= . )
                    {
                    match(input,VARIABLE_SCOPE,FOLLOW_VARIABLE_SCOPE_in_variableScope908); if (state.failed) return retval;

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    match(input,SUBPROPERTY_OF,FOLLOW_SUBPROPERTY_OF_in_variableScope910); if (state.failed) return retval;
                    propertyExpression=(OPPLSyntaxTree)input.LT(1);
                    matchAny(input); if (state.failed) return retval;

                    match(input, Token.UP, null); if (state.failed) return retval;
                    if ( state.backtracking==1 ) {

                             retval.type = symtab.getPropertyVariableScopeType(((OPPLSyntaxTree)retval.start), propertyExpression);
                             retval.variableScope = VariableScopes.buildSubPropertyVariableScope((OWLPropertyExpression<?,?>) propertyExpression.getOWLObject());
                           
                    }

                    }
                    break;
                case 5 :
                    // /Users/luigi/Documents/workspace/PARSERS/src/OPPLTypes.g:389:6: ^( VARIABLE_SCOPE ( INSTANCE_OF | TYPES ) individualExpression= . )
                    {
                    match(input,VARIABLE_SCOPE,FOLLOW_VARIABLE_SCOPE_in_variableScope935); if (state.failed) return retval;

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    if ( (input.LA(1)>=INSTANCE_OF && input.LA(1)<=TYPES) ) {
                        input.consume();
                        state.errorRecovery=false;state.failed=false;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        throw mse;
                    }

                    individualExpression=(OPPLSyntaxTree)input.LT(1);
                    matchAny(input); if (state.failed) return retval;

                    match(input, Token.UP, null); if (state.failed) return retval;
                    if ( state.backtracking==1 ) {

                             retval.type = symtab.getIndividualVariableScopeType(((OPPLSyntaxTree)retval.start), individualExpression);
                             retval.variableScope = VariableScopes.buildIndividualVariableScope((OWLDescription) individualExpression.getOWLObject());
                           
                    }

                    }
                    break;

            }
            if ( state.backtracking==1 ) {
               
              		((OPPLSyntaxTree)retval.start).setEvalType(retval.type); 
              	
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
    // $ANTLR end "variableScope"

    public static class constraint_return extends TreeRuleReturnScope {
        public AbstractConstraint constraint;
    };

    // $ANTLR start "constraint"
    // /Users/luigi/Documents/workspace/PARSERS/src/OPPLTypes.g:398:1: constraint returns [AbstractConstraint constraint] : ( ^( INEQUALITY_CONSTRAINT IDENTIFIER ^( EXPRESSION expression= . ) ) | ^( IN_SET_CONSTRAINT v= IDENTIFIER (i= IDENTIFIER )+ ) | ^( REGEXP_CONSTRAINT IDENTIFIER se= stringOperation ) | ^( NAF_CONSTRAINT a= . ) );
    public final OPPLTypes.constraint_return constraint() throws RecognitionException {
        OPPLTypes.constraint_return retval = new OPPLTypes.constraint_return();
        retval.start = input.LT(1);

        OPPLSyntaxTree v=null;
        OPPLSyntaxTree i=null;
        OPPLSyntaxTree IDENTIFIER18=null;
        OPPLSyntaxTree IDENTIFIER19=null;
        OPPLSyntaxTree expression=null;
        OPPLSyntaxTree a=null;
        SingleValueGeneratedValue<String> se = null;



            List<OPPLSyntaxTree> identifiers = new ArrayList<OPPLSyntaxTree>();
          
        try {
            // /Users/luigi/Documents/workspace/PARSERS/src/OPPLTypes.g:403:1: ( ^( INEQUALITY_CONSTRAINT IDENTIFIER ^( EXPRESSION expression= . ) ) | ^( IN_SET_CONSTRAINT v= IDENTIFIER (i= IDENTIFIER )+ ) | ^( REGEXP_CONSTRAINT IDENTIFIER se= stringOperation ) | ^( NAF_CONSTRAINT a= . ) )
            int alt16=4;
            switch ( input.LA(1) ) {
            case INEQUALITY_CONSTRAINT:
                {
                alt16=1;
                }
                break;
            case IN_SET_CONSTRAINT:
                {
                alt16=2;
                }
                break;
            case REGEXP_CONSTRAINT:
                {
                alt16=3;
                }
                break;
            case NAF_CONSTRAINT:
                {
                alt16=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 16, 0, input);

                throw nvae;
            }

            switch (alt16) {
                case 1 :
                    // /Users/luigi/Documents/workspace/PARSERS/src/OPPLTypes.g:404:3: ^( INEQUALITY_CONSTRAINT IDENTIFIER ^( EXPRESSION expression= . ) )
                    {
                    match(input,INEQUALITY_CONSTRAINT,FOLLOW_INEQUALITY_CONSTRAINT_in_constraint984); if (state.failed) return retval;

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    IDENTIFIER18=(OPPLSyntaxTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_constraint986); if (state.failed) return retval;
                    match(input,EXPRESSION,FOLLOW_EXPRESSION_in_constraint989); if (state.failed) return retval;

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    expression=(OPPLSyntaxTree)input.LT(1);
                    matchAny(input); if (state.failed) return retval;

                    match(input, Token.UP, null); if (state.failed) return retval;

                    match(input, Token.UP, null); if (state.failed) return retval;
                    if ( state.backtracking==1 ) {

                      			retval.constraint = symtab.getInequalityConstraint(((OPPLSyntaxTree)retval.start), IDENTIFIER18,expression, getConstraintSystem());
                      		
                    }

                    }
                    break;
                case 2 :
                    // /Users/luigi/Documents/workspace/PARSERS/src/OPPLTypes.g:407:5: ^( IN_SET_CONSTRAINT v= IDENTIFIER (i= IDENTIFIER )+ )
                    {
                    match(input,IN_SET_CONSTRAINT,FOLLOW_IN_SET_CONSTRAINT_in_constraint1003); if (state.failed) return retval;

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    v=(OPPLSyntaxTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_constraint1009); if (state.failed) return retval;
                    // /Users/luigi/Documents/workspace/PARSERS/src/OPPLTypes.g:407:41: (i= IDENTIFIER )+
                    int cnt15=0;
                    loop15:
                    do {
                        int alt15=2;
                        int LA15_0 = input.LA(1);

                        if ( (LA15_0==IDENTIFIER) ) {
                            alt15=1;
                        }


                        switch (alt15) {
                    	case 1 :
                    	    // /Users/luigi/Documents/workspace/PARSERS/src/OPPLTypes.g:407:42: i= IDENTIFIER
                    	    {
                    	    i=(OPPLSyntaxTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_constraint1017); if (state.failed) return retval;
                    	    if ( state.backtracking==1 ) {
                    	      identifiers.add(i);
                    	    }

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt15 >= 1 ) break loop15;
                    	    if (state.backtracking>0) {state.failed=true; return retval;}
                                EarlyExitException eee =
                                    new EarlyExitException(15, input);
                                throw eee;
                        }
                        cnt15++;
                    } while (true);


                    match(input, Token.UP, null); if (state.failed) return retval;
                    if ( state.backtracking==1 ) {

                      			retval.constraint = symtab.getInSetConstraint(((OPPLSyntaxTree)retval.start),v,constraintSystem,identifiers.toArray(new OPPLSyntaxTree[identifiers.size()]));
                      		
                    }

                    }
                    break;
                case 3 :
                    // /Users/luigi/Documents/workspace/PARSERS/src/OPPLTypes.g:410:5: ^( REGEXP_CONSTRAINT IDENTIFIER se= stringOperation )
                    {
                    match(input,REGEXP_CONSTRAINT,FOLLOW_REGEXP_CONSTRAINT_in_constraint1030); if (state.failed) return retval;

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    IDENTIFIER19=(OPPLSyntaxTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_constraint1032); if (state.failed) return retval;
                    pushFollow(FOLLOW_stringOperation_in_constraint1038);
                    se=stringOperation();

                    state._fsp--;
                    if (state.failed) return retval;

                    match(input, Token.UP, null); if (state.failed) return retval;
                    if ( state.backtracking==1 ) {

                      			Variable variable = symtab.getVariable(IDENTIFIER19,getConstraintSystem());
                      			retval.constraint =   new InCollectionRegExpConstraint(variable, se, getConstraintSystem());
                      		
                    }

                    }
                    break;
                case 4 :
                    // /Users/luigi/Documents/workspace/PARSERS/src/OPPLTypes.g:415:5: ^( NAF_CONSTRAINT a= . )
                    {
                    match(input,NAF_CONSTRAINT,FOLLOW_NAF_CONSTRAINT_in_constraint1050); if (state.failed) return retval;

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    a=(OPPLSyntaxTree)input.LT(1);
                    matchAny(input); if (state.failed) return retval;

                    match(input, Token.UP, null); if (state.failed) return retval;
                    if ( state.backtracking==1 ) {

                      			OWLObject axiom = a.getOWLObject();
                      			if(axiom instanceof OWLAxiom){
                      				retval.constraint =   new NAFConstraint((OWLAxiom) axiom, getConstraintSystem());
                      			}
                      			
                      		
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
        return retval;
    }
    // $ANTLR end "constraint"

    // Delegated rules


    protected DFA10 dfa10 = new DFA10(this);
    static final String DFA10_eotS =
        "\13\uffff";
    static final String DFA10_eofS =
        "\13\uffff";
    static final String DFA10_minS =
        "\1\140\1\uffff\1\2\1\u01d0\1\106\1\121\5\uffff";
    static final String DFA10_maxS =
        "\1\141\1\uffff\1\2\1\u01d0\1\u01d7\1\u00b0\5\uffff";
    static final String DFA10_acceptS =
        "\1\uffff\1\1\4\uffff\1\2\1\3\1\4\1\5\1\6";
    static final String DFA10_specialS =
        "\13\uffff}>";
    static final String[] DFA10_transitionS = {
            "\1\1\1\2",
            "",
            "\1\3",
            "\1\4",
            "\1\6\22\uffff\1\5\u017a\uffff\4\6",
            "\1\11\1\12\17\uffff\1\10\115\uffff\1\7",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA10_eot = DFA.unpackEncodedString(DFA10_eotS);
    static final short[] DFA10_eof = DFA.unpackEncodedString(DFA10_eofS);
    static final char[] DFA10_min = DFA.unpackEncodedStringToUnsignedChars(DFA10_minS);
    static final char[] DFA10_max = DFA.unpackEncodedStringToUnsignedChars(DFA10_maxS);
    static final short[] DFA10_accept = DFA.unpackEncodedString(DFA10_acceptS);
    static final short[] DFA10_special = DFA.unpackEncodedString(DFA10_specialS);
    static final short[][] DFA10_transition;

    static {
        int numStates = DFA10_transitionS.length;
        DFA10_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA10_transition[i] = DFA.unpackEncodedString(DFA10_transitionS[i]);
        }
    }

    class DFA10 extends DFA {

        public DFA10(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 10;
            this.eot = DFA10_eot;
            this.eof = DFA10_eof;
            this.min = DFA10_min;
            this.max = DFA10_max;
            this.accept = DFA10_accept;
            this.special = DFA10_special;
            this.transition = DFA10_transition;
        }
        public String getDescription() {
            return "243:1: variableDefinition returns [Variable variable] : ( ^( INPUT_VARIABLE_DEFINITION VARIABLE_NAME VARIABLE_TYPE (vs= variableScope )? ) | ^( GENERATED_VARIABLE_DEFINITION VARIABLE_NAME generatedVariableAssignment ) | ^( GENERATED_VARIABLE_DEFINITION VARIABLE_NAME VARIABLE_TYPE ^( MATCH se= stringOperation ) ) | ^( GENERATED_VARIABLE_DEFINITION VARIABLE_NAME VARIABLE_TYPE ^( CREATE_OPPL_FUNCTION value= stringOperation ) ) | ^( GENERATED_VARIABLE_DEFINITION name= VARIABLE_NAME VARIABLE_TYPE ^( CREATE_INTERSECTION va= IDENTIFIER ) ) | ^( GENERATED_VARIABLE_DEFINITION name= VARIABLE_NAME VARIABLE_TYPE ^( CREATE_DISJUNCTION va= IDENTIFIER ) ) );";
        }
    }
 

    public static final BitSet FOLLOW_statement_in_bottomup81 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OPPL_STATEMENT_in_statement103 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_variableDefinitions_in_statement109 = new BitSet(new long[]{0x0000000000000000L,0x000000A000000000L});
    public static final BitSet FOLLOW_query_in_statement114 = new BitSet(new long[]{0x0000000000000000L,0x000000A000000000L});
    public static final BitSet FOLLOW_actions_in_statement117 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_VARIABLE_DEFINITIONS_in_variableDefinitions148 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_variableDefinition_in_variableDefinitions155 = new BitSet(new long[]{0x0000000000000008L,0x0000000300000000L});
    public static final BitSet FOLLOW_QUERY_in_query185 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_selectClause_in_query188 = new BitSet(new long[]{0x0000000000000008L,0x00000000F0000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x00000000000A0000L});
    public static final BitSet FOLLOW_constraint_in_query201 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ASSERTED_CLAUSE_in_selectClause231 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_PLAIN_CLAUSE_in_selectClause249 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ACTIONS_in_actions282 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_action_in_actions285 = new BitSet(new long[]{0x0000000000000008L,0x000000000C000000L});
    public static final BitSet FOLLOW_ADD_in_action316 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_REMOVE_in_action331 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_INPUT_VARIABLE_DEFINITION_in_variableDefinition361 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_VARIABLE_NAME_in_variableDefinition363 = new BitSet(new long[]{0x0000000000000000L,0x0000000002000000L});
    public static final BitSet FOLLOW_VARIABLE_TYPE_in_variableDefinition365 = new BitSet(new long[]{0x0000000000000008L,0x0000010000000000L});
    public static final BitSet FOLLOW_variableScope_in_variableDefinition371 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_GENERATED_VARIABLE_DEFINITION_in_variableDefinition387 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_VARIABLE_NAME_in_variableDefinition389 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000F00000L});
    public static final BitSet FOLLOW_generatedVariableAssignment_in_variableDefinition391 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_GENERATED_VARIABLE_DEFINITION_in_variableDefinition408 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_VARIABLE_NAME_in_variableDefinition410 = new BitSet(new long[]{0x0000000000000000L,0x0000000002000000L});
    public static final BitSet FOLLOW_VARIABLE_TYPE_in_variableDefinition412 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0001000000000000L});
    public static final BitSet FOLLOW_MATCH_in_variableDefinition415 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_stringOperation_in_variableDefinition421 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_GENERATED_VARIABLE_DEFINITION_in_variableDefinition440 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_VARIABLE_NAME_in_variableDefinition442 = new BitSet(new long[]{0x0000000000000000L,0x0000000002000000L});
    public static final BitSet FOLLOW_VARIABLE_TYPE_in_variableDefinition444 = new BitSet(new long[]{0x0000000000000000L,0x0000000400000000L});
    public static final BitSet FOLLOW_CREATE_OPPL_FUNCTION_in_variableDefinition447 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_stringOperation_in_variableDefinition454 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_GENERATED_VARIABLE_DEFINITION_in_variableDefinition473 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_VARIABLE_NAME_in_variableDefinition479 = new BitSet(new long[]{0x0000000000000000L,0x0000000002000000L});
    public static final BitSet FOLLOW_VARIABLE_TYPE_in_variableDefinition481 = new BitSet(new long[]{0x0000000000000000L,0x0000000000020000L});
    public static final BitSet FOLLOW_CREATE_INTERSECTION_in_variableDefinition484 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENTIFIER_in_variableDefinition490 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_GENERATED_VARIABLE_DEFINITION_in_variableDefinition512 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_VARIABLE_NAME_in_variableDefinition518 = new BitSet(new long[]{0x0000000000000000L,0x0000000002000000L});
    public static final BitSet FOLLOW_VARIABLE_TYPE_in_variableDefinition520 = new BitSet(new long[]{0x0000000000000000L,0x0000000000040000L});
    public static final BitSet FOLLOW_CREATE_DISJUNCTION_in_variableDefinition523 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENTIFIER_in_variableDefinition529 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_STRING_OPERATION_in_stringOperation588 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_stringExpression_in_stringOperation595 = new BitSet(new long[]{0x0000110000000008L});
    public static final BitSet FOLLOW_DBLQUOTE_in_stringExpression632 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_stringExpression648 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CLASS_in_generatedVariableAssignment697 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_EXPRESSION_in_generatedVariableAssignment700 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_OBJECTPROPERTY_in_generatedVariableAssignment719 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_EXPRESSION_in_generatedVariableAssignment722 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_DATAPROPERTY_in_generatedVariableAssignment741 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_EXPRESSION_in_generatedVariableAssignment744 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_INDIVIDUAL_in_generatedVariableAssignment763 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_EXPRESSION_in_generatedVariableAssignment766 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_CONSTANT_in_generatedVariableAssignment785 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_EXPRESSION_in_generatedVariableAssignment788 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_VARIABLE_SCOPE_in_variableScope836 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_SUBCLASS_OF_in_variableScope838 = new BitSet(new long[]{0xFFFFFFFFFFFFFFF0L,0xFFFFFFFFFFFFFFFFL,0xFFFFFFFFFFFFFFFFL,0xFFFFFFFFFFFFFFFFL,0xFFFFFFFFFFFFFFFFL,0xFFFFFFFFFFFFFFFFL,0xFFFFFFFFFFFFFFFFL,0x0000000000FFFFFFL});
    public static final BitSet FOLLOW_VARIABLE_SCOPE_in_variableScope860 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_SUPER_CLASS_OF_in_variableScope862 = new BitSet(new long[]{0xFFFFFFFFFFFFFFF0L,0xFFFFFFFFFFFFFFFFL,0xFFFFFFFFFFFFFFFFL,0xFFFFFFFFFFFFFFFFL,0xFFFFFFFFFFFFFFFFL,0xFFFFFFFFFFFFFFFFL,0xFFFFFFFFFFFFFFFFL,0x0000000000FFFFFFL});
    public static final BitSet FOLLOW_VARIABLE_SCOPE_in_variableScope886 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_SUPER_PROPERTY_OF_in_variableScope888 = new BitSet(new long[]{0xFFFFFFFFFFFFFFF0L,0xFFFFFFFFFFFFFFFFL,0xFFFFFFFFFFFFFFFFL,0xFFFFFFFFFFFFFFFFL,0xFFFFFFFFFFFFFFFFL,0xFFFFFFFFFFFFFFFFL,0xFFFFFFFFFFFFFFFFL,0x0000000000FFFFFFL});
    public static final BitSet FOLLOW_VARIABLE_SCOPE_in_variableScope908 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_SUBPROPERTY_OF_in_variableScope910 = new BitSet(new long[]{0xFFFFFFFFFFFFFFF0L,0xFFFFFFFFFFFFFFFFL,0xFFFFFFFFFFFFFFFFL,0xFFFFFFFFFFFFFFFFL,0xFFFFFFFFFFFFFFFFL,0xFFFFFFFFFFFFFFFFL,0xFFFFFFFFFFFFFFFFL,0x0000000000FFFFFFL});
    public static final BitSet FOLLOW_VARIABLE_SCOPE_in_variableScope935 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_set_in_variableScope937 = new BitSet(new long[]{0xFFFFFFFFFFFFFFF0L,0xFFFFFFFFFFFFFFFFL,0xFFFFFFFFFFFFFFFFL,0xFFFFFFFFFFFFFFFFL,0xFFFFFFFFFFFFFFFFL,0xFFFFFFFFFFFFFFFFL,0xFFFFFFFFFFFFFFFFL,0x0000000000FFFFFFL});
    public static final BitSet FOLLOW_INEQUALITY_CONSTRAINT_in_constraint984 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENTIFIER_in_constraint986 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_EXPRESSION_in_constraint989 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IN_SET_CONSTRAINT_in_constraint1003 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENTIFIER_in_constraint1009 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_constraint1017 = new BitSet(new long[]{0x0000100000000008L});
    public static final BitSet FOLLOW_REGEXP_CONSTRAINT_in_constraint1030 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENTIFIER_in_constraint1032 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000400L});
    public static final BitSet FOLLOW_stringOperation_in_constraint1038 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_NAF_CONSTRAINT_in_constraint1050 = new BitSet(new long[]{0x0000000000000004L});

}