// $ANTLR 3.2 Sep 23, 2009 12:02:23 /Users/luigi/Documents/workspace/Parsers/src/OPPLTypes.g 2010-11-16 17:25:05

  package org.coode.parsers.oppl;
  import java.util.regex.Pattern; 
  import java.util.Collections;
  import java.util.Set;
  import java.util.HashSet;
  import java.util.Collection;
  import org.coode.oppl.VariableScopeChecker;   
  import org.coode.oppl.entity.OWLEntityRenderer;
  import org.coode.oppl.generated.RegexpGeneratedVariable;
  import org.coode.oppl.AbstractConstraint;
  import org.coode.oppl.ConstraintSystem;
  import org.coode.oppl.OPPLQuery;
  import org.coode.oppl.Variable;
  import org.coode.oppl.VariableScope;
  import org.coode.oppl.VariableScopes;
  import org.coode.oppl.exceptions.OPPLException;
  import org.coode.oppl.generated.GeneratedVariable;
  import org.coode.oppl.NAFConstraint;
  import org.coode.oppl.RegExpConstraint;
  import org.coode.oppl.function.Aggregation;
  import org.coode.oppl.function.OPPLFunction;
  import org.coode.oppl.function.Constant;
  import org.coode.oppl.function.Aggregandum;
  import org.coode.oppl.function.Adapter;
  import org.coode.oppl.OPPLAbstractFactory;
  import org.coode.oppl.variabletypes.VariableTypeFactory;
  import org.coode.parsers.Symbol;
  import org.coode.parsers.oppl.variableattribute.CollectionVariableAttributeSymbol;  
  import org.semanticweb.owlapi.model.OWLAxiom;
  import org.semanticweb.owlapi.model.OWLObject;
  import org.semanticweb.owlapi.model.OWLClass;
  import org.semanticweb.owlapi.model.OWLAxiomChange;
  import org.semanticweb.owlapi.model.OWLPropertyExpression;
  import org.semanticweb.owlapi.model.OWLClassExpression;
  import org.semanticweb.owlapi.model.RemoveAxiom;
  import org.semanticweb.owlapi.model.AddAxiom;    
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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "COMPOSITION", "OPEN_PARENTHESYS", "OPEN_CURLY_BRACES", "CLOSED_CURLY_BRACES", "CLOSED_PARENTHESYS", "WHITESPACE", "AND", "OR", "NOT", "SOME", "ONLY", "MIN", "MAX", "EXACTLY", "VALUE", "INVERSE", "SUBCLASS_OF", "SUB_PROPERTY_OF", "EQUIVALENT_TO", "SAME_AS", "DIFFERENT_FROM", "INVERSE_OF", "DISJOINT_WITH", "DOMAIN", "RANGE", "FUNCTIONAL", "SYMMETRIC", "ANTI_SYMMETRIC", "REFLEXIVE", "IRREFLEXIVE", "TRANSITIVE", "INVERSE_FUNCTIONAL", "POW", "COMMA", "INSTANCE_OF", "TYPES", "DBLQUOTE", "DIGIT", "INTEGER", "LETTER", "IDENTIFIER", "ENTITY_REFERENCE", "QUESTION_MARK", "Tokens", "SUB_CLASS_AXIOM", "EQUIVALENT_TO_AXIOM", "DISJOINT_WITH_AXIOM", "SUB_PROPERTY_AXIOM", "SAME_AS_AXIOM", "DIFFERENT_FROM_AXIOM", "UNARY_AXIOM", "DISJUNCTION", "CONJUNCTION", "PROPERTY_CHAIN", "NEGATED_EXPRESSION", "NEGATED_ASSERTION", "INVERSE_PROPERTY", "SOME_RESTRICTION", "ALL_RESTRICTION", "VALUE_RESTRICTION", "CARDINALITY_RESTRICTION", "ONE_OF", "TYPE_ASSERTION", "ROLE_ASSERTION", "INVERSE_OBJECT_PROPERTY_EXPRESSION", "EXPRESSION", "CONSTANT", "WHERE", "NOT_EQUAL", "EQUAL", "IN", "SELECT", "ASSERTED", "COLON", "DOT", "PLUS", "CREATE", "CREATE_INTERSECTION", "CREATE_DISJUNCTION", "BEGIN", "END", "OPEN_SQUARE_BRACKET", "CLOSED_SQUARE_BRACKET", "SUPER_CLASS_OF", "SUPER_PROPERTY_OF", "VARIABLE_TYPE", "ADD", "REMOVE", "ASSERTED_CLAUSE", "PLAIN_CLAUSE", "INEQUALITY_CONSTRAINT", "IN_SET_CONSTRAINT", "INPUT_VARIABLE_DEFINITION", "GENERATED_VARIABLE_DEFINITION", "CREATE_OPPL_FUNCTION", "VARIABLE_ATTRIBUTE", "OPPL_FUNCTION", "ACTIONS", "VARIABLE_DEFINITIONS", "QUERY", "VARIABLE_SCOPE", "SUBPROPERTY_OF", "VARIABLE_IDENTIFIER", "OPPL_STATEMENT", "HAS_KEY", "IRI", "ANNOTATION_ASSERTION", "IRI_ATTRIBUTE_NAME", "ESCLAMATION_MARK", "MATCH", "ATTRIBUTE_SELECTOR", "VALUES", "RENDERING", "GROUPS", "STRING_OPERATION", "VARIABLE_NAME", "REGEXP_CONSTRAINT", "FAIL", "NAF_CONSTRAINT"
    };
    public static final int COMMA=37;
    public static final int ASSERTED=76;
    public static final int VARIABLE_DEFINITIONS=102;
    public static final int REGEXP_CONSTRAINT=465;
    public static final int END=84;
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
    public static final int AND=10;
    public static final int EXPRESSION=69;
    public static final int CONSTANT=70;
    public static final int VALUE_RESTRICTION=63;
    public static final int ONE_OF=65;
    public static final int SUBPROPERTY_OF=105;
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
    public static final int RANGE=28;
    public static final int CLOSED_PARENTHESYS=8;
    public static final int PROPERTY_CHAIN=57;
    public static final int CREATE_INTERSECTION=81;
    public static final int EQUIVALENT_TO_AXIOM=49;
    public static final int OPEN_SQUARE_BRACKET=85;
    public static final int NAF_CONSTRAINT=467;
    public static final int SYMMETRIC=30;
    public static final int DISJOINT_WITH=26;
    public static final int VARIABLE_TYPE=89;
    public static final int DISJUNCTION=55;
    public static final int GROUPS=356;
    public static final int NEGATED_EXPRESSION=58;
    public static final int EQUAL=73;
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
    public static final int WHITESPACE=9;
    public static final int IN=74;
    public static final int SUPER_PROPERTY_OF=88;
    public static final int INEQUALITY_CONSTRAINT=94;
    public static final int SOME=13;
    public static final int EOF=-1;
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


        public OPPLTypes(TreeNodeStream input) {
            this(input, new RecognizerSharedState());
        }
        public OPPLTypes(TreeNodeStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return OPPLTypes.tokenNames; }
    public String getGrammarFileName() { return "/Users/luigi/Documents/workspace/Parsers/src/OPPLTypes.g"; }


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
    // /Users/luigi/Documents/workspace/Parsers/src/OPPLTypes.g:127:1: bottomup : statement ;
    public final void bottomup() throws RecognitionException {
        try {
            // /Users/luigi/Documents/workspace/Parsers/src/OPPLTypes.g:128:5: ( statement )
            // /Users/luigi/Documents/workspace/Parsers/src/OPPLTypes.g:129:6: statement
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
    // /Users/luigi/Documents/workspace/Parsers/src/OPPLTypes.g:133:1: statement : ^( OPPL_STATEMENT (vd= variableDefinitions )? (q= query )? actions ) ;
    public final OPPLTypes.statement_return statement() throws RecognitionException {
        OPPLTypes.statement_return retval = new OPPLTypes.statement_return();
        retval.start = input.LT(1);

        OPPLTypes.variableDefinitions_return vd = null;

        OPPLTypes.query_return q = null;

        OPPLTypes.actions_return actions1 = null;



        	List<Variable<?>> vds = new ArrayList<Variable<?>>();

        try {
            // /Users/luigi/Documents/workspace/Parsers/src/OPPLTypes.g:137:2: ( ^( OPPL_STATEMENT (vd= variableDefinitions )? (q= query )? actions ) )
            // /Users/luigi/Documents/workspace/Parsers/src/OPPLTypes.g:138:3: ^( OPPL_STATEMENT (vd= variableDefinitions )? (q= query )? actions )
            {
            match(input,OPPL_STATEMENT,FOLLOW_OPPL_STATEMENT_in_statement103); if (state.failed) return retval;

            match(input, Token.DOWN, null); if (state.failed) return retval;
            // /Users/luigi/Documents/workspace/Parsers/src/OPPLTypes.g:138:23: (vd= variableDefinitions )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==VARIABLE_DEFINITIONS) ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // /Users/luigi/Documents/workspace/Parsers/src/OPPLTypes.g:138:23: vd= variableDefinitions
                    {
                    pushFollow(FOLLOW_variableDefinitions_in_statement109);
                    vd=variableDefinitions();

                    state._fsp--;
                    if (state.failed) return retval;

                    }
                    break;

            }

            // /Users/luigi/Documents/workspace/Parsers/src/OPPLTypes.g:138:47: (q= query )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==QUERY) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // /Users/luigi/Documents/workspace/Parsers/src/OPPLTypes.g:138:47: q= query
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

              			try{
              				if(vd!=null){
              					vds.addAll((vd!=null?vd.variables:null));
              				}
              				if(!(actions1!=null?actions1.actions:null).isEmpty()){
              					if(q!=null){
              						 // If the query tree is not null but the returned query contains errors (hence it is null) the script should be null.
              			    			 ((OPPLSyntaxTree)retval.start).setOPPLContent((q!=null?q.query:null) ==null?null:getOPPLFactory().buildOPPLScript(getConstraintSystem(),
              				    					vds, (q!=null?q.query:null),
              					    				(actions1!=null?actions1.actions:null)));
              					}else{
              						((OPPLSyntaxTree)retval.start).setOPPLContent(getOPPLFactory().buildOPPLScript(getConstraintSystem(),vds, null,(actions1!=null?actions1.actions:null)));
              					}
              				}
              			}catch(IllegalArgumentException e){
              				getErrorListener().reportThrowable(e,((OPPLSyntaxTree)retval.start).getLine(),((OPPLSyntaxTree)retval.start).getCharPositionInLine(),((OPPLSyntaxTree)retval.start).getText().length());
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

    public static class variableDefinitions_return extends TreeRuleReturnScope {
        public List<Variable<?>> variables;
    };

    // $ANTLR start "variableDefinitions"
    // /Users/luigi/Documents/workspace/Parsers/src/OPPLTypes.g:160:1: variableDefinitions returns [List<Variable<?>> variables] : ^( VARIABLE_DEFINITIONS (vd= variableDefinition )+ ) ;
    public final OPPLTypes.variableDefinitions_return variableDefinitions() throws RecognitionException {
        OPPLTypes.variableDefinitions_return retval = new OPPLTypes.variableDefinitions_return();
        retval.start = input.LT(1);

        OPPLTypes.variableDefinition_return vd = null;



        	List<Variable<?>> toReturn = new ArrayList<Variable<?>>();

        try {
            // /Users/luigi/Documents/workspace/Parsers/src/OPPLTypes.g:168:2: ( ^( VARIABLE_DEFINITIONS (vd= variableDefinition )+ ) )
            // /Users/luigi/Documents/workspace/Parsers/src/OPPLTypes.g:169:3: ^( VARIABLE_DEFINITIONS (vd= variableDefinition )+ )
            {
            match(input,VARIABLE_DEFINITIONS,FOLLOW_VARIABLE_DEFINITIONS_in_variableDefinitions148); if (state.failed) return retval;

            match(input, Token.DOWN, null); if (state.failed) return retval;
            // /Users/luigi/Documents/workspace/Parsers/src/OPPLTypes.g:169:26: (vd= variableDefinition )+
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
            	    // /Users/luigi/Documents/workspace/Parsers/src/OPPLTypes.g:169:27: vd= variableDefinition
            	    {
            	    pushFollow(FOLLOW_variableDefinition_in_variableDefinitions155);
            	    vd=variableDefinition();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==1 ) {
            	      toReturn.add(vd.variable);
            	    }

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

            }

            if ( state.backtracking==1 ) {

              	retval.variables = toReturn;
              	((OPPLSyntaxTree)retval.start).setOPPLContent(retval.variables);

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
    // $ANTLR end "variableDefinitions"

    public static class query_return extends TreeRuleReturnScope {
        public OPPLQuery query;
        public OPPLSyntaxTree node;
    };

    // $ANTLR start "query"
    // /Users/luigi/Documents/workspace/Parsers/src/OPPLTypes.g:172:1: query returns [OPPLQuery query, OPPLSyntaxTree node] : ^( QUERY ( selectClause )+ ( constraint )* ) ;
    public final OPPLTypes.query_return query() throws RecognitionException {
        OPPLTypes.query_return retval = new OPPLTypes.query_return();
        retval.start = input.LT(1);

        OPPLTypes.selectClause_return selectClause2 = null;

        OPPLTypes.constraint_return constraint3 = null;



        		retval.query = getOPPLFactory().buildNewQuery(getConstraintSystem());

        try {
            // /Users/luigi/Documents/workspace/Parsers/src/OPPLTypes.g:184:2: ( ^( QUERY ( selectClause )+ ( constraint )* ) )
            // /Users/luigi/Documents/workspace/Parsers/src/OPPLTypes.g:185:3: ^( QUERY ( selectClause )+ ( constraint )* )
            {
            match(input,QUERY,FOLLOW_QUERY_in_query189); if (state.failed) return retval;

            match(input, Token.DOWN, null); if (state.failed) return retval;
            // /Users/luigi/Documents/workspace/Parsers/src/OPPLTypes.g:185:11: ( selectClause )+
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
            	    // /Users/luigi/Documents/workspace/Parsers/src/OPPLTypes.g:185:12: selectClause
            	    {
            	    pushFollow(FOLLOW_selectClause_in_query192);
            	    selectClause2=selectClause();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==1 ) {

            	      		  if((selectClause2!=null?selectClause2.axiom:null)!=null){
            	      			   if((selectClause2!=null?selectClause2.asserted:false)){
            	      				  retval.query.addAssertedAxiom((selectClause2!=null?selectClause2.axiom:null));
            	      			   }else{
            	      				  retval.query.addAxiom((selectClause2!=null?selectClause2.axiom:null));
            	      			   }
            	      			}
            	      		
            	    }

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

            // /Users/luigi/Documents/workspace/Parsers/src/OPPLTypes.g:195:6: ( constraint )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( ((LA5_0>=INEQUALITY_CONSTRAINT && LA5_0<=IN_SET_CONSTRAINT)||LA5_0==REGEXP_CONSTRAINT||LA5_0==NAF_CONSTRAINT) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // /Users/luigi/Documents/workspace/Parsers/src/OPPLTypes.g:195:7: constraint
            	    {
            	    pushFollow(FOLLOW_constraint_in_query205);
            	    constraint3=constraint();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==1 ) {

            	      				  if((constraint3!=null?constraint3.constraint:null)!=null){
            	      					 retval.query.addConstraint((constraint3!=null?constraint3.constraint:null));
            	      					}
            	      				
            	    }

            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);


            match(input, Token.UP, null); if (state.failed) return retval;

            }

            if ( state.backtracking==1 ) {

              		// No asserted axioms and plains axioms means no query at all.
              		if(retval.query.getAssertedAxioms().isEmpty() && retval.query.getAxioms().isEmpty()){
              			retval.query =null;
              		}
              		((OPPLSyntaxTree)retval.start).setOPPLContent(retval.query);
              		retval.node = ((OPPLSyntaxTree)retval.start);

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
    // $ANTLR end "query"

    public static class selectClause_return extends TreeRuleReturnScope {
        public OWLAxiom axiom;
        public boolean asserted;
    };

    // $ANTLR start "selectClause"
    // /Users/luigi/Documents/workspace/Parsers/src/OPPLTypes.g:204:1: selectClause returns [OWLAxiom axiom, boolean asserted] : ( ^( ASSERTED_CLAUSE a= . ) | ^( PLAIN_CLAUSE a= . ) );
    public final OPPLTypes.selectClause_return selectClause() throws RecognitionException {
        OPPLTypes.selectClause_return retval = new OPPLTypes.selectClause_return();
        retval.start = input.LT(1);

        OPPLSyntaxTree a=null;

        try {
            // /Users/luigi/Documents/workspace/Parsers/src/OPPLTypes.g:205:2: ( ^( ASSERTED_CLAUSE a= . ) | ^( PLAIN_CLAUSE a= . ) )
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
                    // /Users/luigi/Documents/workspace/Parsers/src/OPPLTypes.g:206:3: ^( ASSERTED_CLAUSE a= . )
                    {
                    match(input,ASSERTED_CLAUSE,FOLLOW_ASSERTED_CLAUSE_in_selectClause234); if (state.failed) return retval;

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
                    // /Users/luigi/Documents/workspace/Parsers/src/OPPLTypes.g:217:5: ^( PLAIN_CLAUSE a= . )
                    {
                    match(input,PLAIN_CLAUSE,FOLLOW_PLAIN_CLAUSE_in_selectClause252); if (state.failed) return retval;

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

    public static class actions_return extends TreeRuleReturnScope {
        public List<OWLAxiomChange> actions;
    };

    // $ANTLR start "actions"
    // /Users/luigi/Documents/workspace/Parsers/src/OPPLTypes.g:229:1: actions returns [List<OWLAxiomChange> actions] : ^( ACTIONS ( action )+ ) ;
    public final OPPLTypes.actions_return actions() throws RecognitionException {
        OPPLTypes.actions_return retval = new OPPLTypes.actions_return();
        retval.start = input.LT(1);

        OWLAxiomChange action4 = null;



        	retval.actions = new ArrayList<OWLAxiomChange>();

        try {
            // /Users/luigi/Documents/workspace/Parsers/src/OPPLTypes.g:236:2: ( ^( ACTIONS ( action )+ ) )
            // /Users/luigi/Documents/workspace/Parsers/src/OPPLTypes.g:237:3: ^( ACTIONS ( action )+ )
            {
            match(input,ACTIONS,FOLLOW_ACTIONS_in_actions289); if (state.failed) return retval;

            match(input, Token.DOWN, null); if (state.failed) return retval;
            // /Users/luigi/Documents/workspace/Parsers/src/OPPLTypes.g:237:13: ( action )+
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
            	    // /Users/luigi/Documents/workspace/Parsers/src/OPPLTypes.g:237:14: action
            	    {
            	    pushFollow(FOLLOW_action_in_actions292);
            	    action4=action();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==1 ) {

            	      		  if(action4!=null){
            	      		    retval.actions.add(action4);
            	      		  }
            	      		
            	    }

            	    }
            	    break;

            	default :
            	    if ( cnt7 >= 1 ) break loop7;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(7, input);
                        throw eee;
                }
                cnt7++;
            } while (true);


            match(input, Token.UP, null); if (state.failed) return retval;

            }

            if ( state.backtracking==1 ) {

              	((OPPLSyntaxTree)retval.start).setOPPLContent(retval.actions);

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
    // $ANTLR end "actions"


    // $ANTLR start "action"
    // /Users/luigi/Documents/workspace/Parsers/src/OPPLTypes.g:247:1: action returns [OWLAxiomChange change] : ( ^( ADD a= . ) | ^( REMOVE a= . ) );
    public final OWLAxiomChange action() throws RecognitionException {
        OWLAxiomChange change = null;

        OPPLSyntaxTree a=null;

        try {
            // /Users/luigi/Documents/workspace/Parsers/src/OPPLTypes.g:248:2: ( ^( ADD a= . ) | ^( REMOVE a= . ) )
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
                    // /Users/luigi/Documents/workspace/Parsers/src/OPPLTypes.g:249:3: ^( ADD a= . )
                    {
                    match(input,ADD,FOLLOW_ADD_in_action323); if (state.failed) return change;

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
                    // /Users/luigi/Documents/workspace/Parsers/src/OPPLTypes.g:257:5: ^( REMOVE a= . )
                    {
                    match(input,REMOVE,FOLLOW_REMOVE_in_action338); if (state.failed) return change;

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
    // /Users/luigi/Documents/workspace/Parsers/src/OPPLTypes.g:267:1: variableDefinition returns [Variable variable] : ( ^( INPUT_VARIABLE_DEFINITION VARIABLE_NAME VARIABLE_TYPE (vs= variableScope )? ) | ^( GENERATED_VARIABLE_DEFINITION VARIABLE_NAME VARIABLE_TYPE ^(expr= EXPRESSION ( . )* ) ) | ^( GENERATED_VARIABLE_DEFINITION VARIABLE_NAME VARIABLE_TYPE ^( MATCH se= stringOperation ) ) | ^( GENERATED_VARIABLE_DEFINITION VARIABLE_NAME VARIABLE_TYPE ^( CREATE_OPPL_FUNCTION value= stringOperation ) ) | ^( GENERATED_VARIABLE_DEFINITION name= VARIABLE_NAME VARIABLE_TYPE ^( CREATE_INTERSECTION va= aggregandums ) ) | ^( GENERATED_VARIABLE_DEFINITION name= VARIABLE_NAME VARIABLE_TYPE ^( CREATE_DISJUNCTION va= aggregandums ) ) );
    public final OPPLTypes.variableDefinition_return variableDefinition() throws RecognitionException {
        OPPLTypes.variableDefinition_return retval = new OPPLTypes.variableDefinition_return();
        retval.start = input.LT(1);

        OPPLSyntaxTree expr=null;
        OPPLSyntaxTree name=null;
        OPPLSyntaxTree VARIABLE_NAME5=null;
        OPPLSyntaxTree VARIABLE_TYPE6=null;
        OPPLSyntaxTree INPUT_VARIABLE_DEFINITION7=null;
        OPPLSyntaxTree VARIABLE_TYPE8=null;
        OPPLSyntaxTree VARIABLE_NAME9=null;
        OPPLSyntaxTree VARIABLE_TYPE10=null;
        OPPLSyntaxTree VARIABLE_NAME11=null;
        OPPLSyntaxTree VARIABLE_TYPE12=null;
        OPPLSyntaxTree VARIABLE_NAME13=null;
        OPPLSyntaxTree CREATE_INTERSECTION14=null;
        OPPLSyntaxTree CREATE_DISJUNCTION15=null;
        OPPLTypes.variableScope_return vs = null;

        OPPLFunction<String> se = null;

        OPPLFunction<String> value = null;

        OPPLTypes.aggregandums_return va = null;


        try {
            // /Users/luigi/Documents/workspace/Parsers/src/OPPLTypes.g:268:2: ( ^( INPUT_VARIABLE_DEFINITION VARIABLE_NAME VARIABLE_TYPE (vs= variableScope )? ) | ^( GENERATED_VARIABLE_DEFINITION VARIABLE_NAME VARIABLE_TYPE ^(expr= EXPRESSION ( . )* ) ) | ^( GENERATED_VARIABLE_DEFINITION VARIABLE_NAME VARIABLE_TYPE ^( MATCH se= stringOperation ) ) | ^( GENERATED_VARIABLE_DEFINITION VARIABLE_NAME VARIABLE_TYPE ^( CREATE_OPPL_FUNCTION value= stringOperation ) ) | ^( GENERATED_VARIABLE_DEFINITION name= VARIABLE_NAME VARIABLE_TYPE ^( CREATE_INTERSECTION va= aggregandums ) ) | ^( GENERATED_VARIABLE_DEFINITION name= VARIABLE_NAME VARIABLE_TYPE ^( CREATE_DISJUNCTION va= aggregandums ) ) )
            int alt11=6;
            alt11 = dfa11.predict(input);
            switch (alt11) {
                case 1 :
                    // /Users/luigi/Documents/workspace/Parsers/src/OPPLTypes.g:269:3: ^( INPUT_VARIABLE_DEFINITION VARIABLE_NAME VARIABLE_TYPE (vs= variableScope )? )
                    {
                    INPUT_VARIABLE_DEFINITION7=(OPPLSyntaxTree)match(input,INPUT_VARIABLE_DEFINITION,FOLLOW_INPUT_VARIABLE_DEFINITION_in_variableDefinition366); if (state.failed) return retval;

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    VARIABLE_NAME5=(OPPLSyntaxTree)match(input,VARIABLE_NAME,FOLLOW_VARIABLE_NAME_in_variableDefinition368); if (state.failed) return retval;
                    VARIABLE_TYPE6=(OPPLSyntaxTree)match(input,VARIABLE_TYPE,FOLLOW_VARIABLE_TYPE_in_variableDefinition370); if (state.failed) return retval;
                    // /Users/luigi/Documents/workspace/Parsers/src/OPPLTypes.g:269:62: (vs= variableScope )?
                    int alt9=2;
                    int LA9_0 = input.LA(1);

                    if ( (LA9_0==VARIABLE_SCOPE) ) {
                        alt9=1;
                    }
                    switch (alt9) {
                        case 1 :
                            // /Users/luigi/Documents/workspace/Parsers/src/OPPLTypes.g:269:62: vs= variableScope
                            {
                            pushFollow(FOLLOW_variableScope_in_variableDefinition376);
                            vs=variableScope();

                            state._fsp--;
                            if (state.failed) return retval;

                            }
                            break;

                    }


                    match(input, Token.UP, null); if (state.failed) return retval;
                    if ( state.backtracking==1 ) {

                      			try {
                      				if((vs!=null && vs.variableScope==null)){
                      					getErrorListener().illegalToken(((OPPLSyntaxTree)retval.start), "Invalid variable scope");
                      				}else{
                      					retval.variable = getConstraintSystem().createVariable(VARIABLE_NAME5.getToken().getText(), symtab.getVaribaleType(VARIABLE_TYPE6), vs==null?null:vs.variableScope);
                      				}
                      			   } catch(OPPLException e){
                      			      getErrorListener().reportThrowable(e, INPUT_VARIABLE_DEFINITION7.token.getLine(), INPUT_VARIABLE_DEFINITION7.token.getCharPositionInLine(),INPUT_VARIABLE_DEFINITION7.token.getText().length());
                      		   	}
                      		
                    }

                    }
                    break;
                case 2 :
                    // /Users/luigi/Documents/workspace/Parsers/src/OPPLTypes.g:281:7: ^( GENERATED_VARIABLE_DEFINITION VARIABLE_NAME VARIABLE_TYPE ^(expr= EXPRESSION ( . )* ) )
                    {
                    match(input,GENERATED_VARIABLE_DEFINITION,FOLLOW_GENERATED_VARIABLE_DEFINITION_in_variableDefinition391); if (state.failed) return retval;

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    VARIABLE_NAME9=(OPPLSyntaxTree)match(input,VARIABLE_NAME,FOLLOW_VARIABLE_NAME_in_variableDefinition393); if (state.failed) return retval;
                    VARIABLE_TYPE8=(OPPLSyntaxTree)match(input,VARIABLE_TYPE,FOLLOW_VARIABLE_TYPE_in_variableDefinition395); if (state.failed) return retval;
                    expr=(OPPLSyntaxTree)match(input,EXPRESSION,FOLLOW_EXPRESSION_in_variableDefinition403); if (state.failed) return retval;

                    if ( input.LA(1)==Token.DOWN ) {
                        match(input, Token.DOWN, null); if (state.failed) return retval;
                        // /Users/luigi/Documents/workspace/Parsers/src/OPPLTypes.g:281:88: ( . )*
                        loop10:
                        do {
                            int alt10=2;
                            int LA10_0 = input.LA(1);

                            if ( ((LA10_0>=COMPOSITION && LA10_0<=NAF_CONSTRAINT)) ) {
                                alt10=1;
                            }
                            else if ( (LA10_0==UP) ) {
                                alt10=2;
                            }


                            switch (alt10) {
                        	case 1 :
                        	    // /Users/luigi/Documents/workspace/Parsers/src/OPPLTypes.g:281:88: .
                        	    {
                        	    matchAny(input); if (state.failed) return retval;

                        	    }
                        	    break;

                        	default :
                        	    break loop10;
                            }
                        } while (true);


                        match(input, Token.UP, null); if (state.failed) return retval;
                    }

                    match(input, Token.UP, null); if (state.failed) return retval;
                    if ( state.backtracking==1 ) {

                      	    		Type type = getSymbolTable().getExpressionGeneratedVariableType(((OPPLSyntaxTree)retval.start),VARIABLE_TYPE8, expr);
                      	    		if(type!=null){
                      		       		OWLObject expressionOWLObject = expr.getOWLObject();
                      		       		if(expressionOWLObject !=null){
                      					GeneratedVariable<?> v = getConstraintSystem().createExpressionGeneratedVariable(VARIABLE_NAME9.getText(), expressionOWLObject);				
                      					if(v==null){
                      						getErrorListener().illegalToken(expr,"Invalid expression to assign to a variable");
                      					} 
                      			        	retval.variable = v;
                      			        }else{
                      			        	getErrorListener().reportThrowable(new NullPointerException("The type of the generated variable is null"), expr.token.getLine(), expr.token.getCharPositionInLine(),expr.token.getText().length());
                      			        }
                      			}else{
                      				getErrorListener().reportThrowable(new NullPointerException("The type of the generated variable is null"), ((OPPLSyntaxTree)retval.start).token.getLine(), ((OPPLSyntaxTree)retval.start).token.getCharPositionInLine(),((OPPLSyntaxTree)retval.start).token.getText().length());
                      			}
                      		
                    }

                    }
                    break;
                case 3 :
                    // /Users/luigi/Documents/workspace/Parsers/src/OPPLTypes.g:299:5: ^( GENERATED_VARIABLE_DEFINITION VARIABLE_NAME VARIABLE_TYPE ^( MATCH se= stringOperation ) )
                    {
                    match(input,GENERATED_VARIABLE_DEFINITION,FOLLOW_GENERATED_VARIABLE_DEFINITION_in_variableDefinition423); if (state.failed) return retval;

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    VARIABLE_NAME11=(OPPLSyntaxTree)match(input,VARIABLE_NAME,FOLLOW_VARIABLE_NAME_in_variableDefinition425); if (state.failed) return retval;
                    VARIABLE_TYPE10=(OPPLSyntaxTree)match(input,VARIABLE_TYPE,FOLLOW_VARIABLE_TYPE_in_variableDefinition427); if (state.failed) return retval;
                    match(input,MATCH,FOLLOW_MATCH_in_variableDefinition430); if (state.failed) return retval;

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    pushFollow(FOLLOW_stringOperation_in_variableDefinition436);
                    se=stringOperation();

                    state._fsp--;
                    if (state.failed) return retval;

                    match(input, Token.UP, null); if (state.failed) return retval;

                    match(input, Token.UP, null); if (state.failed) return retval;
                    if ( state.backtracking==1 ) {

                      			org.coode.oppl.variabletypes.VariableType<?> type = org.coode.parsers.oppl.VariableType.getVariableType(VARIABLE_TYPE10.getText()).getOPPLVariableType();
                      			RegexpGeneratedVariable<?> v = getConstraintSystem().createRegexpGeneratedVariable(VARIABLE_NAME11.getText(),  type, Adapter.buildRegexpPatternAdapter(se));
                      			retval.variable = v;
                      		
                    }

                    }
                    break;
                case 4 :
                    // /Users/luigi/Documents/workspace/Parsers/src/OPPLTypes.g:305:5: ^( GENERATED_VARIABLE_DEFINITION VARIABLE_NAME VARIABLE_TYPE ^( CREATE_OPPL_FUNCTION value= stringOperation ) )
                    {
                    match(input,GENERATED_VARIABLE_DEFINITION,FOLLOW_GENERATED_VARIABLE_DEFINITION_in_variableDefinition450); if (state.failed) return retval;

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    VARIABLE_NAME13=(OPPLSyntaxTree)match(input,VARIABLE_NAME,FOLLOW_VARIABLE_NAME_in_variableDefinition452); if (state.failed) return retval;
                    VARIABLE_TYPE12=(OPPLSyntaxTree)match(input,VARIABLE_TYPE,FOLLOW_VARIABLE_TYPE_in_variableDefinition454); if (state.failed) return retval;
                    match(input,CREATE_OPPL_FUNCTION,FOLLOW_CREATE_OPPL_FUNCTION_in_variableDefinition457); if (state.failed) return retval;

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    pushFollow(FOLLOW_stringOperation_in_variableDefinition464);
                    value=stringOperation();

                    state._fsp--;
                    if (state.failed) return retval;

                    match(input, Token.UP, null); if (state.failed) return retval;

                    match(input, Token.UP, null); if (state.failed) return retval;
                    if ( state.backtracking==1 ) {

                      			org.coode.oppl.variabletypes.VariableType type = org.coode.parsers.oppl.VariableType.getVariableType(VARIABLE_TYPE12.getText()).getOPPLVariableType();
                      			retval.variable = constraintSystem.createStringGeneratedVariable(VARIABLE_NAME13.getText(),type, value);
                      		
                    }

                    }
                    break;
                case 5 :
                    // /Users/luigi/Documents/workspace/Parsers/src/OPPLTypes.g:310:5: ^( GENERATED_VARIABLE_DEFINITION name= VARIABLE_NAME VARIABLE_TYPE ^( CREATE_INTERSECTION va= aggregandums ) )
                    {
                    match(input,GENERATED_VARIABLE_DEFINITION,FOLLOW_GENERATED_VARIABLE_DEFINITION_in_variableDefinition477); if (state.failed) return retval;

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    name=(OPPLSyntaxTree)match(input,VARIABLE_NAME,FOLLOW_VARIABLE_NAME_in_variableDefinition483); if (state.failed) return retval;
                    match(input,VARIABLE_TYPE,FOLLOW_VARIABLE_TYPE_in_variableDefinition485); if (state.failed) return retval;
                    CREATE_INTERSECTION14=(OPPLSyntaxTree)match(input,CREATE_INTERSECTION,FOLLOW_CREATE_INTERSECTION_in_variableDefinition488); if (state.failed) return retval;

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    pushFollow(FOLLOW_aggregandums_in_variableDefinition494);
                    va=aggregandums();

                    state._fsp--;
                    if (state.failed) return retval;

                    match(input, Token.UP, null); if (state.failed) return retval;

                    match(input, Token.UP, null); if (state.failed) return retval;
                    if ( state.backtracking==1 ) {

                      			Collection<? extends Aggregandum<OWLClassExpression>> aggregandumCollection = this.getSymbolTable().getAggregandumCollection(
                      							VariableTypeFactory.getCLASSVariableType(),
                      							va.list,va.tokenList,CREATE_INTERSECTION14);
                      			if(aggregandumCollection!=null){
                      				retval.variable = getConstraintSystem().createIntersectionGeneratedVariable(
                      					name.getText(),
                      					VariableTypeFactory.getCLASSVariableType(),
                      					aggregandumCollection);
                      			}
                      		
                    }

                    }
                    break;
                case 6 :
                    // /Users/luigi/Documents/workspace/Parsers/src/OPPLTypes.g:322:5: ^( GENERATED_VARIABLE_DEFINITION name= VARIABLE_NAME VARIABLE_TYPE ^( CREATE_DISJUNCTION va= aggregandums ) )
                    {
                    match(input,GENERATED_VARIABLE_DEFINITION,FOLLOW_GENERATED_VARIABLE_DEFINITION_in_variableDefinition507); if (state.failed) return retval;

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    name=(OPPLSyntaxTree)match(input,VARIABLE_NAME,FOLLOW_VARIABLE_NAME_in_variableDefinition513); if (state.failed) return retval;
                    match(input,VARIABLE_TYPE,FOLLOW_VARIABLE_TYPE_in_variableDefinition515); if (state.failed) return retval;
                    CREATE_DISJUNCTION15=(OPPLSyntaxTree)match(input,CREATE_DISJUNCTION,FOLLOW_CREATE_DISJUNCTION_in_variableDefinition518); if (state.failed) return retval;

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    pushFollow(FOLLOW_aggregandums_in_variableDefinition524);
                    va=aggregandums();

                    state._fsp--;
                    if (state.failed) return retval;

                    match(input, Token.UP, null); if (state.failed) return retval;

                    match(input, Token.UP, null); if (state.failed) return retval;
                    if ( state.backtracking==1 ) {

                      			Collection<? extends Aggregandum<OWLClassExpression>> aggregandumCollection = this.getSymbolTable().getAggregandumCollection(
                      							VariableTypeFactory.getCLASSVariableType(),
                      							va.list,va.tokenList,CREATE_DISJUNCTION15);
                      			if(aggregandumCollection!=null){
                      				retval.variable = getConstraintSystem().createUnionGeneratedVariable(
                      					name.getText(),
                      					VariableTypeFactory.getCLASSVariableType(),
                      					aggregandumCollection);
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
    // $ANTLR end "variableDefinition"


    // $ANTLR start "stringOperation"
    // /Users/luigi/Documents/workspace/Parsers/src/OPPLTypes.g:341:1: stringOperation returns [OPPLFunction<String> value] : ^( STRING_OPERATION (valuesToAggregate= stringExpression )+ ) ;
    public final OPPLFunction<String> stringOperation() throws RecognitionException {
        OPPLFunction<String> value = null;

        OPPLFunction<String> valuesToAggregate = null;



            List<Aggregandum<String>> values = new ArrayList<Aggregandum<String>>();
          
        try {
            // /Users/luigi/Documents/workspace/Parsers/src/OPPLTypes.g:346:3: ( ^( STRING_OPERATION (valuesToAggregate= stringExpression )+ ) )
            // /Users/luigi/Documents/workspace/Parsers/src/OPPLTypes.g:347:5: ^( STRING_OPERATION (valuesToAggregate= stringExpression )+ )
            {
            match(input,STRING_OPERATION,FOLLOW_STRING_OPERATION_in_stringOperation578); if (state.failed) return value;

            match(input, Token.DOWN, null); if (state.failed) return value;
            // /Users/luigi/Documents/workspace/Parsers/src/OPPLTypes.g:347:25: (valuesToAggregate= stringExpression )+
            int cnt12=0;
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==DBLQUOTE||LA12_0==IDENTIFIER) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // /Users/luigi/Documents/workspace/Parsers/src/OPPLTypes.g:347:26: valuesToAggregate= stringExpression
            	    {
            	    pushFollow(FOLLOW_stringExpression_in_stringOperation585);
            	    valuesToAggregate=stringExpression();

            	    state._fsp--;
            	    if (state.failed) return value;
            	    if ( state.backtracking==1 ) {
            	      values.add(Adapter.buildSingletonAggregandum(valuesToAggregate));
            	    }

            	    }
            	    break;

            	default :
            	    if ( cnt12 >= 1 ) break loop12;
            	    if (state.backtracking>0) {state.failed=true; return value;}
                        EarlyExitException eee =
                            new EarlyExitException(12, input);
                        throw eee;
                }
                cnt12++;
            } while (true);


            match(input, Token.UP, null); if (state.failed) return value;
            if ( state.backtracking==1 ) {

                    value = Aggregation.buildStringConcatenation(values);
                  
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
    // /Users/luigi/Documents/workspace/Parsers/src/OPPLTypes.g:354:1: stringExpression returns [OPPLFunction<String> value] : ( DBLQUOTE | ^( IDENTIFIER VARIABLE_NAME DOT GROUPS ^( ATTRIBUTE_SELECTOR INTEGER ) ) | ^( IDENTIFIER VARIABLE_NAME DOT RENDERING ) );
    public final OPPLFunction<String> stringExpression() throws RecognitionException {
        OPPLFunction<String> value = null;

        OPPLSyntaxTree DBLQUOTE16=null;
        OPPLSyntaxTree VARIABLE_NAME17=null;
        OPPLSyntaxTree INTEGER18=null;
        OPPLSyntaxTree VARIABLE_NAME19=null;

        try {
            // /Users/luigi/Documents/workspace/Parsers/src/OPPLTypes.g:355:3: ( DBLQUOTE | ^( IDENTIFIER VARIABLE_NAME DOT GROUPS ^( ATTRIBUTE_SELECTOR INTEGER ) ) | ^( IDENTIFIER VARIABLE_NAME DOT RENDERING ) )
            int alt13=3;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==DBLQUOTE) ) {
                alt13=1;
            }
            else if ( (LA13_0==IDENTIFIER) ) {
                int LA13_2 = input.LA(2);

                if ( (LA13_2==DOWN) ) {
                    int LA13_3 = input.LA(3);

                    if ( (LA13_3==VARIABLE_NAME) ) {
                        int LA13_4 = input.LA(4);

                        if ( (LA13_4==DOT) ) {
                            int LA13_5 = input.LA(5);

                            if ( (LA13_5==GROUPS) ) {
                                alt13=2;
                            }
                            else if ( (LA13_5==RENDERING) ) {
                                alt13=3;
                            }
                            else {
                                if (state.backtracking>0) {state.failed=true; return value;}
                                NoViableAltException nvae =
                                    new NoViableAltException("", 13, 5, input);

                                throw nvae;
                            }
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return value;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 13, 4, input);

                            throw nvae;
                        }
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return value;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 13, 3, input);

                        throw nvae;
                    }
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return value;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 13, 2, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return value;}
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;
            }
            switch (alt13) {
                case 1 :
                    // /Users/luigi/Documents/workspace/Parsers/src/OPPLTypes.g:356:7: DBLQUOTE
                    {
                    DBLQUOTE16=(OPPLSyntaxTree)match(input,DBLQUOTE,FOLLOW_DBLQUOTE_in_stringExpression622); if (state.failed) return value;
                    if ( state.backtracking==1 ) {

                              value = new Constant<String>(DBLQUOTE16.getText());
                            
                    }

                    }
                    break;
                case 2 :
                    // /Users/luigi/Documents/workspace/Parsers/src/OPPLTypes.g:360:10: ^( IDENTIFIER VARIABLE_NAME DOT GROUPS ^( ATTRIBUTE_SELECTOR INTEGER ) )
                    {
                    match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_stringExpression642); if (state.failed) return value;

                    match(input, Token.DOWN, null); if (state.failed) return value;
                    VARIABLE_NAME17=(OPPLSyntaxTree)match(input,VARIABLE_NAME,FOLLOW_VARIABLE_NAME_in_stringExpression644); if (state.failed) return value;
                    match(input,DOT,FOLLOW_DOT_in_stringExpression646); if (state.failed) return value;
                    match(input,GROUPS,FOLLOW_GROUPS_in_stringExpression648); if (state.failed) return value;
                    match(input,ATTRIBUTE_SELECTOR,FOLLOW_ATTRIBUTE_SELECTOR_in_stringExpression651); if (state.failed) return value;

                    match(input, Token.DOWN, null); if (state.failed) return value;
                    INTEGER18=(OPPLSyntaxTree)match(input,INTEGER,FOLLOW_INTEGER_in_stringExpression653); if (state.failed) return value;

                    match(input, Token.UP, null); if (state.failed) return value;

                    match(input, Token.UP, null); if (state.failed) return value;
                    if ( state.backtracking==1 ) {

                            value = getSymbolTable().defineGroupAttributeReferenceSymbol(VARIABLE_NAME17,INTEGER18, getConstraintSystem());
                          
                    }

                    }
                    break;
                case 3 :
                    // /Users/luigi/Documents/workspace/Parsers/src/OPPLTypes.g:364:7: ^( IDENTIFIER VARIABLE_NAME DOT RENDERING )
                    {
                    match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_stringExpression672); if (state.failed) return value;

                    match(input, Token.DOWN, null); if (state.failed) return value;
                    VARIABLE_NAME19=(OPPLSyntaxTree)match(input,VARIABLE_NAME,FOLLOW_VARIABLE_NAME_in_stringExpression675); if (state.failed) return value;
                    match(input,DOT,FOLLOW_DOT_in_stringExpression677); if (state.failed) return value;
                    match(input,RENDERING,FOLLOW_RENDERING_in_stringExpression681); if (state.failed) return value;

                    match(input, Token.UP, null); if (state.failed) return value;
                    if ( state.backtracking==1 ) {

                            value = getSymbolTable().defineRenderingAttributeReferenceSymbol(VARIABLE_NAME19,getConstraintSystem());
                          
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

    public static class variableScope_return extends TreeRuleReturnScope {
        public Type type;
        public VariableScope variableScope;
    };

    // $ANTLR start "variableScope"
    // /Users/luigi/Documents/workspace/Parsers/src/OPPLTypes.g:377:1: variableScope returns [Type type, VariableScope variableScope] : ( ^( VARIABLE_SCOPE SUBCLASS_OF classExpression= . ) | ^( VARIABLE_SCOPE SUPER_CLASS_OF classExpression= . ) | ^( VARIABLE_SCOPE SUPER_PROPERTY_OF propertyExpression= . ) | ^( VARIABLE_SCOPE SUBPROPERTY_OF propertyExpression= . ) | ^( VARIABLE_SCOPE ( INSTANCE_OF | TYPES ) individualExpression= . ) );
    public final OPPLTypes.variableScope_return variableScope() throws RecognitionException {
        OPPLTypes.variableScope_return retval = new OPPLTypes.variableScope_return();
        retval.start = input.LT(1);

        OPPLSyntaxTree classExpression=null;
        OPPLSyntaxTree propertyExpression=null;
        OPPLSyntaxTree individualExpression=null;

        try {
            // /Users/luigi/Documents/workspace/Parsers/src/OPPLTypes.g:382:2: ( ^( VARIABLE_SCOPE SUBCLASS_OF classExpression= . ) | ^( VARIABLE_SCOPE SUPER_CLASS_OF classExpression= . ) | ^( VARIABLE_SCOPE SUPER_PROPERTY_OF propertyExpression= . ) | ^( VARIABLE_SCOPE SUBPROPERTY_OF propertyExpression= . ) | ^( VARIABLE_SCOPE ( INSTANCE_OF | TYPES ) individualExpression= . ) )
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
                    // /Users/luigi/Documents/workspace/Parsers/src/OPPLTypes.g:383:2: ^( VARIABLE_SCOPE SUBCLASS_OF classExpression= . )
                    {
                    match(input,VARIABLE_SCOPE,FOLLOW_VARIABLE_SCOPE_in_variableScope728); if (state.failed) return retval;

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    match(input,SUBCLASS_OF,FOLLOW_SUBCLASS_OF_in_variableScope730); if (state.failed) return retval;
                    classExpression=(OPPLSyntaxTree)input.LT(1);
                    matchAny(input); if (state.failed) return retval;

                    match(input, Token.UP, null); if (state.failed) return retval;
                    if ( state.backtracking==1 ) {

                      		try{
                      			VariableScopeChecker checker = getConstraintSystem().getOPPLFactory().getVariableScopeChecker();
                      			retval.type = symtab.getClassVariableScopeType(((OPPLSyntaxTree)retval.start), classExpression);
                      			retval.variableScope = VariableScopes.buildSubClassVariableScope((OWLClassExpression)classExpression.getOWLObject(),checker);
                      		}catch(OPPLException e){
                      			getErrorListener().reportThrowable(e,((OPPLSyntaxTree)retval.start).getLine(),((OPPLSyntaxTree)retval.start).getCharPositionInLine(),((OPPLSyntaxTree)retval.start).getText().length());
                      		}
                      	
                    }

                    }
                    break;
                case 2 :
                    // /Users/luigi/Documents/workspace/Parsers/src/OPPLTypes.g:393:5: ^( VARIABLE_SCOPE SUPER_CLASS_OF classExpression= . )
                    {
                    match(input,VARIABLE_SCOPE,FOLLOW_VARIABLE_SCOPE_in_variableScope747); if (state.failed) return retval;

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    match(input,SUPER_CLASS_OF,FOLLOW_SUPER_CLASS_OF_in_variableScope749); if (state.failed) return retval;
                    classExpression=(OPPLSyntaxTree)input.LT(1);
                    matchAny(input); if (state.failed) return retval;

                    match(input, Token.UP, null); if (state.failed) return retval;
                    if ( state.backtracking==1 ) {

                      		try{
                      	   		VariableScopeChecker checker = getConstraintSystem().getOPPLFactory().getVariableScopeChecker();     
                      			retval.type = symtab.getClassVariableScopeType(((OPPLSyntaxTree)retval.start), classExpression);
                      			retval.variableScope = VariableScopes.buildSuperClassVariableScope((OWLClassExpression)classExpression.getOWLObject(),checker);
                      		}catch(OPPLException e){
                      			getErrorListener().reportThrowable(e,((OPPLSyntaxTree)retval.start).getLine(),((OPPLSyntaxTree)retval.start).getCharPositionInLine(),((OPPLSyntaxTree)retval.start).getText().length());
                      		}
                      	
                    }

                    }
                    break;
                case 3 :
                    // /Users/luigi/Documents/workspace/Parsers/src/OPPLTypes.g:403:4: ^( VARIABLE_SCOPE SUPER_PROPERTY_OF propertyExpression= . )
                    {
                    match(input,VARIABLE_SCOPE,FOLLOW_VARIABLE_SCOPE_in_variableScope768); if (state.failed) return retval;

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    match(input,SUPER_PROPERTY_OF,FOLLOW_SUPER_PROPERTY_OF_in_variableScope770); if (state.failed) return retval;
                    propertyExpression=(OPPLSyntaxTree)input.LT(1);
                    matchAny(input); if (state.failed) return retval;

                    match(input, Token.UP, null); if (state.failed) return retval;
                    if ( state.backtracking==1 ) {

                      		try{
                      			VariableScopeChecker checker = getConstraintSystem().getOPPLFactory().getVariableScopeChecker();	   	
                      			retval.type = symtab.getPropertyVariableScopeType(((OPPLSyntaxTree)retval.start), propertyExpression);
                      			retval.variableScope = VariableScopes.buildSuperPropertyVariableScope((OWLPropertyExpression<?,?>) propertyExpression.getOWLObject(),checker);
                      		}catch(OPPLException e){
                      			getErrorListener().reportThrowable(e,((OPPLSyntaxTree)retval.start).getLine(),((OPPLSyntaxTree)retval.start).getCharPositionInLine(),((OPPLSyntaxTree)retval.start).getText().length());
                      		}
                      	
                    }

                    }
                    break;
                case 4 :
                    // /Users/luigi/Documents/workspace/Parsers/src/OPPLTypes.g:413:4: ^( VARIABLE_SCOPE SUBPROPERTY_OF propertyExpression= . )
                    {
                    match(input,VARIABLE_SCOPE,FOLLOW_VARIABLE_SCOPE_in_variableScope785); if (state.failed) return retval;

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    match(input,SUBPROPERTY_OF,FOLLOW_SUBPROPERTY_OF_in_variableScope787); if (state.failed) return retval;
                    propertyExpression=(OPPLSyntaxTree)input.LT(1);
                    matchAny(input); if (state.failed) return retval;

                    match(input, Token.UP, null); if (state.failed) return retval;
                    if ( state.backtracking==1 ) {

                      		try{
                      			VariableScopeChecker checker = getConstraintSystem().getOPPLFactory().getVariableScopeChecker();
                      			retval.type = symtab.getPropertyVariableScopeType(((OPPLSyntaxTree)retval.start), propertyExpression);
                      			retval.variableScope = VariableScopes.buildSubPropertyVariableScope((OWLPropertyExpression<?,?>) propertyExpression.getOWLObject(),checker);
                      		}catch(OPPLException e){
                      			getErrorListener().reportThrowable(e,((OPPLSyntaxTree)retval.start).getLine(),((OPPLSyntaxTree)retval.start).getCharPositionInLine(),((OPPLSyntaxTree)retval.start).getText().length());
                      		}
                      	
                    }

                    }
                    break;
                case 5 :
                    // /Users/luigi/Documents/workspace/Parsers/src/OPPLTypes.g:423:4: ^( VARIABLE_SCOPE ( INSTANCE_OF | TYPES ) individualExpression= . )
                    {
                    match(input,VARIABLE_SCOPE,FOLLOW_VARIABLE_SCOPE_in_variableScope806); if (state.failed) return retval;

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

                      		try{
                      			VariableScopeChecker checker = getConstraintSystem().getOPPLFactory().getVariableScopeChecker();	
                      			retval.type = symtab.getIndividualVariableScopeType(((OPPLSyntaxTree)retval.start), individualExpression);
                      			retval.variableScope = VariableScopes.buildIndividualVariableScope((OWLClassExpression) individualExpression.getOWLObject(),checker);
                      		}catch(OPPLException e){
                      			getErrorListener().reportThrowable(e,((OPPLSyntaxTree)retval.start).getLine(),((OPPLSyntaxTree)retval.start).getCharPositionInLine(),((OPPLSyntaxTree)retval.start).getText().length());
                      		}
                      	
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
    // /Users/luigi/Documents/workspace/Parsers/src/OPPLTypes.g:437:1: constraint returns [AbstractConstraint constraint] : ( ^( INEQUALITY_CONSTRAINT IDENTIFIER ^( EXPRESSION expression= . ) ) | ^( IN_SET_CONSTRAINT v= IDENTIFIER (i= IDENTIFIER )+ ) | ^( REGEXP_CONSTRAINT IDENTIFIER se= stringOperation ) | ^( NAF_CONSTRAINT a= . ) );
    public final OPPLTypes.constraint_return constraint() throws RecognitionException {
        OPPLTypes.constraint_return retval = new OPPLTypes.constraint_return();
        retval.start = input.LT(1);

        OPPLSyntaxTree v=null;
        OPPLSyntaxTree i=null;
        OPPLSyntaxTree IDENTIFIER20=null;
        OPPLSyntaxTree IDENTIFIER21=null;
        OPPLSyntaxTree expression=null;
        OPPLSyntaxTree a=null;
        OPPLFunction<String> se = null;



            List<OPPLSyntaxTree> identifiers = new ArrayList<OPPLSyntaxTree>();
          
        try {
            // /Users/luigi/Documents/workspace/Parsers/src/OPPLTypes.g:442:1: ( ^( INEQUALITY_CONSTRAINT IDENTIFIER ^( EXPRESSION expression= . ) ) | ^( IN_SET_CONSTRAINT v= IDENTIFIER (i= IDENTIFIER )+ ) | ^( REGEXP_CONSTRAINT IDENTIFIER se= stringOperation ) | ^( NAF_CONSTRAINT a= . ) )
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
                    // /Users/luigi/Documents/workspace/Parsers/src/OPPLTypes.g:443:3: ^( INEQUALITY_CONSTRAINT IDENTIFIER ^( EXPRESSION expression= . ) )
                    {
                    match(input,INEQUALITY_CONSTRAINT,FOLLOW_INEQUALITY_CONSTRAINT_in_constraint851); if (state.failed) return retval;

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    IDENTIFIER20=(OPPLSyntaxTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_constraint853); if (state.failed) return retval;
                    match(input,EXPRESSION,FOLLOW_EXPRESSION_in_constraint856); if (state.failed) return retval;

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    expression=(OPPLSyntaxTree)input.LT(1);
                    matchAny(input); if (state.failed) return retval;

                    match(input, Token.UP, null); if (state.failed) return retval;

                    match(input, Token.UP, null); if (state.failed) return retval;
                    if ( state.backtracking==1 ) {

                      			retval.constraint = symtab.getInequalityConstraint(((OPPLSyntaxTree)retval.start), IDENTIFIER20,expression, getConstraintSystem());
                      		
                    }

                    }
                    break;
                case 2 :
                    // /Users/luigi/Documents/workspace/Parsers/src/OPPLTypes.g:446:5: ^( IN_SET_CONSTRAINT v= IDENTIFIER (i= IDENTIFIER )+ )
                    {
                    match(input,IN_SET_CONSTRAINT,FOLLOW_IN_SET_CONSTRAINT_in_constraint870); if (state.failed) return retval;

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    v=(OPPLSyntaxTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_constraint876); if (state.failed) return retval;
                    // /Users/luigi/Documents/workspace/Parsers/src/OPPLTypes.g:446:41: (i= IDENTIFIER )+
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
                    	    // /Users/luigi/Documents/workspace/Parsers/src/OPPLTypes.g:446:42: i= IDENTIFIER
                    	    {
                    	    i=(OPPLSyntaxTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_constraint884); if (state.failed) return retval;
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
                    // /Users/luigi/Documents/workspace/Parsers/src/OPPLTypes.g:449:5: ^( REGEXP_CONSTRAINT IDENTIFIER se= stringOperation )
                    {
                    match(input,REGEXP_CONSTRAINT,FOLLOW_REGEXP_CONSTRAINT_in_constraint897); if (state.failed) return retval;

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    IDENTIFIER21=(OPPLSyntaxTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_constraint899); if (state.failed) return retval;
                    pushFollow(FOLLOW_stringOperation_in_constraint905);
                    se=stringOperation();

                    state._fsp--;
                    if (state.failed) return retval;

                    match(input, Token.UP, null); if (state.failed) return retval;
                    if ( state.backtracking==1 ) {

                      			Variable variable = symtab.getVariable(IDENTIFIER21,getConstraintSystem());
                      			OPPLFunction<Pattern> adapted = Adapter.buildRegexpPatternAdapter(se);
                      			retval.constraint =   new RegExpConstraint(variable, adapted, getConstraintSystem());
                      		
                    }

                    }
                    break;
                case 4 :
                    // /Users/luigi/Documents/workspace/Parsers/src/OPPLTypes.g:455:5: ^( NAF_CONSTRAINT a= . )
                    {
                    match(input,NAF_CONSTRAINT,FOLLOW_NAF_CONSTRAINT_in_constraint917); if (state.failed) return retval;

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

    public static class aggregandums_return extends TreeRuleReturnScope {
        public List<Aggregandum<?>> list;
        public List<OPPLSyntaxTree> tokenList;
    };

    // $ANTLR start "aggregandums"
    // /Users/luigi/Documents/workspace/Parsers/src/OPPLTypes.g:464:1: aggregandums returns [List<Aggregandum<?>> list, List<OPPLSyntaxTree> tokenList] : (a= aggregandum )+ ;
    public final OPPLTypes.aggregandums_return aggregandums() throws RecognitionException {
        OPPLTypes.aggregandums_return retval = new OPPLTypes.aggregandums_return();
        retval.start = input.LT(1);

        OPPLTypes.aggregandum_return a = null;



        	retval.list = new ArrayList<Aggregandum<?>>();
        	retval.tokenList = new ArrayList<OPPLSyntaxTree>();

        try {
            // /Users/luigi/Documents/workspace/Parsers/src/OPPLTypes.g:470:2: ( (a= aggregandum )+ )
            // /Users/luigi/Documents/workspace/Parsers/src/OPPLTypes.g:471:3: (a= aggregandum )+
            {
            // /Users/luigi/Documents/workspace/Parsers/src/OPPLTypes.g:471:3: (a= aggregandum )+
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
            	    // /Users/luigi/Documents/workspace/Parsers/src/OPPLTypes.g:471:4: a= aggregandum
            	    {
            	    pushFollow(FOLLOW_aggregandum_in_aggregandums951);
            	    a=aggregandum();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==1 ) {

            	      			retval.tokenList.add(a.node);
            	      			retval.list.add(a.a);
            	      		
            	    }

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
    // $ANTLR end "aggregandums"

    public static class aggregandum_return extends TreeRuleReturnScope {
        public Aggregandum<?> a;
        public OPPLSyntaxTree node;
    };

    // $ANTLR start "aggregandum"
    // /Users/luigi/Documents/workspace/Parsers/src/OPPLTypes.g:477:1: aggregandum returns [Aggregandum<?> a, OPPLSyntaxTree node] : ( ^( IDENTIFIER VARIABLE_NAME DOT VALUES ) | IDENTIFIER );
    public final OPPLTypes.aggregandum_return aggregandum() throws RecognitionException {
        OPPLTypes.aggregandum_return retval = new OPPLTypes.aggregandum_return();
        retval.start = input.LT(1);

        OPPLSyntaxTree VARIABLE_NAME22=null;
        OPPLSyntaxTree IDENTIFIER23=null;

        try {
            // /Users/luigi/Documents/workspace/Parsers/src/OPPLTypes.g:482:2: ( ^( IDENTIFIER VARIABLE_NAME DOT VALUES ) | IDENTIFIER )
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==IDENTIFIER) ) {
                int LA18_1 = input.LA(2);

                if ( (LA18_1==DOWN) ) {
                    alt18=1;
                }
                else if ( (LA18_1==UP||LA18_1==IDENTIFIER) ) {
                    alt18=2;
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
                    // /Users/luigi/Documents/workspace/Parsers/src/OPPLTypes.g:483:2: ^( IDENTIFIER VARIABLE_NAME DOT VALUES )
                    {
                    match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_aggregandum976); if (state.failed) return retval;

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    VARIABLE_NAME22=(OPPLSyntaxTree)match(input,VARIABLE_NAME,FOLLOW_VARIABLE_NAME_in_aggregandum979); if (state.failed) return retval;
                    match(input,DOT,FOLLOW_DOT_in_aggregandum981); if (state.failed) return retval;
                    match(input,VALUES,FOLLOW_VALUES_in_aggregandum984); if (state.failed) return retval;

                    match(input, Token.UP, null); if (state.failed) return retval;
                    if ( state.backtracking==1 ) {

                            		retval.a = Adapter.buildSingletonAggregandum(getSymbolTable().defineValuesAttributeReferenceSymbol(VARIABLE_NAME22,getConstraintSystem()));
                          	
                    }

                    }
                    break;
                case 2 :
                    // /Users/luigi/Documents/workspace/Parsers/src/OPPLTypes.g:487:8: IDENTIFIER
                    {
                    IDENTIFIER23=(OPPLSyntaxTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_aggregandum1001); if (state.failed) return retval;
                    if ( state.backtracking==1 ) {

                          		Symbol symbol = this.getSymbolTable().resolve(IDENTIFIER23);
                          		if(symbol!=null){
                      	    		retval.a = Adapter.buildSingletonAggregandum(IDENTIFIER23.getOWLObject());
                      	    	}else{
                      	    		getErrorListener().unrecognisedSymbol(IDENTIFIER23);
                      	    	}
                          	
                    }

                    }
                    break;

            }
            if ( state.backtracking==1 ) {

              	retval.node = ((OPPLSyntaxTree)retval.start);

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
    // $ANTLR end "aggregandum"

    // Delegated rules


    protected DFA11 dfa11 = new DFA11(this);
    static final String DFA11_eotS =
        "\13\uffff";
    static final String DFA11_eofS =
        "\13\uffff";
    static final String DFA11_minS =
        "\1\140\1\uffff\1\2\1\u01d0\1\131\1\105\5\uffff";
    static final String DFA11_maxS =
        "\1\141\1\uffff\1\2\1\u01d0\1\131\1\u00b0\5\uffff";
    static final String DFA11_acceptS =
        "\1\uffff\1\1\4\uffff\1\2\1\3\1\4\1\5\1\6";
    static final String DFA11_specialS =
        "\13\uffff}>";
    static final String[] DFA11_transitionS = {
            "\1\1\1\2",
            "",
            "\1\3",
            "\1\4",
            "\1\5",
            "\1\6\13\uffff\1\11\1\12\17\uffff\1\10\115\uffff\1\7",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA11_eot = DFA.unpackEncodedString(DFA11_eotS);
    static final short[] DFA11_eof = DFA.unpackEncodedString(DFA11_eofS);
    static final char[] DFA11_min = DFA.unpackEncodedStringToUnsignedChars(DFA11_minS);
    static final char[] DFA11_max = DFA.unpackEncodedStringToUnsignedChars(DFA11_maxS);
    static final short[] DFA11_accept = DFA.unpackEncodedString(DFA11_acceptS);
    static final short[] DFA11_special = DFA.unpackEncodedString(DFA11_specialS);
    static final short[][] DFA11_transition;

    static {
        int numStates = DFA11_transitionS.length;
        DFA11_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA11_transition[i] = DFA.unpackEncodedString(DFA11_transitionS[i]);
        }
    }

    class DFA11 extends DFA {

        public DFA11(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 11;
            this.eot = DFA11_eot;
            this.eof = DFA11_eof;
            this.min = DFA11_min;
            this.max = DFA11_max;
            this.accept = DFA11_accept;
            this.special = DFA11_special;
            this.transition = DFA11_transition;
        }
        public String getDescription() {
            return "267:1: variableDefinition returns [Variable variable] : ( ^( INPUT_VARIABLE_DEFINITION VARIABLE_NAME VARIABLE_TYPE (vs= variableScope )? ) | ^( GENERATED_VARIABLE_DEFINITION VARIABLE_NAME VARIABLE_TYPE ^(expr= EXPRESSION ( . )* ) ) | ^( GENERATED_VARIABLE_DEFINITION VARIABLE_NAME VARIABLE_TYPE ^( MATCH se= stringOperation ) ) | ^( GENERATED_VARIABLE_DEFINITION VARIABLE_NAME VARIABLE_TYPE ^( CREATE_OPPL_FUNCTION value= stringOperation ) ) | ^( GENERATED_VARIABLE_DEFINITION name= VARIABLE_NAME VARIABLE_TYPE ^( CREATE_INTERSECTION va= aggregandums ) ) | ^( GENERATED_VARIABLE_DEFINITION name= VARIABLE_NAME VARIABLE_TYPE ^( CREATE_DISJUNCTION va= aggregandums ) ) );";
        }
    }
 

    public static final BitSet FOLLOW_statement_in_bottomup81 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OPPL_STATEMENT_in_statement103 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_variableDefinitions_in_statement109 = new BitSet(new long[]{0x0000000000000000L,0x000000A000000000L});
    public static final BitSet FOLLOW_query_in_statement114 = new BitSet(new long[]{0x0000000000000000L,0x000000A000000000L});
    public static final BitSet FOLLOW_actions_in_statement117 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_VARIABLE_DEFINITIONS_in_variableDefinitions148 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_variableDefinition_in_variableDefinitions155 = new BitSet(new long[]{0x0000000000000008L,0x0000000300000000L});
    public static final BitSet FOLLOW_QUERY_in_query189 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_selectClause_in_query192 = new BitSet(new long[]{0x0000000000000008L,0x00000000F0000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x00000000000A0000L});
    public static final BitSet FOLLOW_constraint_in_query205 = new BitSet(new long[]{0x0000000000000008L,0x00000000C0000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x00000000000A0000L});
    public static final BitSet FOLLOW_ASSERTED_CLAUSE_in_selectClause234 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_PLAIN_CLAUSE_in_selectClause252 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ACTIONS_in_actions289 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_action_in_actions292 = new BitSet(new long[]{0x0000000000000008L,0x000000000C000000L});
    public static final BitSet FOLLOW_ADD_in_action323 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_REMOVE_in_action338 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_INPUT_VARIABLE_DEFINITION_in_variableDefinition366 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_VARIABLE_NAME_in_variableDefinition368 = new BitSet(new long[]{0x0000000000000000L,0x0000000002000000L});
    public static final BitSet FOLLOW_VARIABLE_TYPE_in_variableDefinition370 = new BitSet(new long[]{0x0000000000000008L,0x0000010000000000L});
    public static final BitSet FOLLOW_variableScope_in_variableDefinition376 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_GENERATED_VARIABLE_DEFINITION_in_variableDefinition391 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_VARIABLE_NAME_in_variableDefinition393 = new BitSet(new long[]{0x0000000000000000L,0x0000000002000000L});
    public static final BitSet FOLLOW_VARIABLE_TYPE_in_variableDefinition395 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_EXPRESSION_in_variableDefinition403 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_GENERATED_VARIABLE_DEFINITION_in_variableDefinition423 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_VARIABLE_NAME_in_variableDefinition425 = new BitSet(new long[]{0x0000000000000000L,0x0000000002000000L});
    public static final BitSet FOLLOW_VARIABLE_TYPE_in_variableDefinition427 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0001000000000000L});
    public static final BitSet FOLLOW_MATCH_in_variableDefinition430 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_stringOperation_in_variableDefinition436 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_GENERATED_VARIABLE_DEFINITION_in_variableDefinition450 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_VARIABLE_NAME_in_variableDefinition452 = new BitSet(new long[]{0x0000000000000000L,0x0000000002000000L});
    public static final BitSet FOLLOW_VARIABLE_TYPE_in_variableDefinition454 = new BitSet(new long[]{0x0000000000000000L,0x0000000400000000L});
    public static final BitSet FOLLOW_CREATE_OPPL_FUNCTION_in_variableDefinition457 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_stringOperation_in_variableDefinition464 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_GENERATED_VARIABLE_DEFINITION_in_variableDefinition477 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_VARIABLE_NAME_in_variableDefinition483 = new BitSet(new long[]{0x0000000000000000L,0x0000000002000000L});
    public static final BitSet FOLLOW_VARIABLE_TYPE_in_variableDefinition485 = new BitSet(new long[]{0x0000000000000000L,0x0000000000020000L});
    public static final BitSet FOLLOW_CREATE_INTERSECTION_in_variableDefinition488 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_aggregandums_in_variableDefinition494 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_GENERATED_VARIABLE_DEFINITION_in_variableDefinition507 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_VARIABLE_NAME_in_variableDefinition513 = new BitSet(new long[]{0x0000000000000000L,0x0000000002000000L});
    public static final BitSet FOLLOW_VARIABLE_TYPE_in_variableDefinition515 = new BitSet(new long[]{0x0000000000000000L,0x0000000000040000L});
    public static final BitSet FOLLOW_CREATE_DISJUNCTION_in_variableDefinition518 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_aggregandums_in_variableDefinition524 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_STRING_OPERATION_in_stringOperation578 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_stringExpression_in_stringOperation585 = new BitSet(new long[]{0x0000110000000008L});
    public static final BitSet FOLLOW_DBLQUOTE_in_stringExpression622 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_stringExpression642 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_VARIABLE_NAME_in_stringExpression644 = new BitSet(new long[]{0x0000000000000000L,0x0000000000004000L});
    public static final BitSet FOLLOW_DOT_in_stringExpression646 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000001000000000L});
    public static final BitSet FOLLOW_GROUPS_in_stringExpression648 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000008000000L});
    public static final BitSet FOLLOW_ATTRIBUTE_SELECTOR_in_stringExpression651 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_INTEGER_in_stringExpression653 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_IDENTIFIER_in_stringExpression672 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_VARIABLE_NAME_in_stringExpression675 = new BitSet(new long[]{0x0000000000000000L,0x0000000000004000L});
    public static final BitSet FOLLOW_DOT_in_stringExpression677 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000800000000L});
    public static final BitSet FOLLOW_RENDERING_in_stringExpression681 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_VARIABLE_SCOPE_in_variableScope728 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_SUBCLASS_OF_in_variableScope730 = new BitSet(new long[]{0xFFFFFFFFFFFFFFF0L,0xFFFFFFFFFFFFFFFFL,0xFFFFFFFFFFFFFFFFL,0xFFFFFFFFFFFFFFFFL,0xFFFFFFFFFFFFFFFFL,0xFFFFFFFFFFFFFFFFL,0xFFFFFFFFFFFFFFFFL,0x00000000000FFFFFL});
    public static final BitSet FOLLOW_VARIABLE_SCOPE_in_variableScope747 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_SUPER_CLASS_OF_in_variableScope749 = new BitSet(new long[]{0xFFFFFFFFFFFFFFF0L,0xFFFFFFFFFFFFFFFFL,0xFFFFFFFFFFFFFFFFL,0xFFFFFFFFFFFFFFFFL,0xFFFFFFFFFFFFFFFFL,0xFFFFFFFFFFFFFFFFL,0xFFFFFFFFFFFFFFFFL,0x00000000000FFFFFL});
    public static final BitSet FOLLOW_VARIABLE_SCOPE_in_variableScope768 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_SUPER_PROPERTY_OF_in_variableScope770 = new BitSet(new long[]{0xFFFFFFFFFFFFFFF0L,0xFFFFFFFFFFFFFFFFL,0xFFFFFFFFFFFFFFFFL,0xFFFFFFFFFFFFFFFFL,0xFFFFFFFFFFFFFFFFL,0xFFFFFFFFFFFFFFFFL,0xFFFFFFFFFFFFFFFFL,0x00000000000FFFFFL});
    public static final BitSet FOLLOW_VARIABLE_SCOPE_in_variableScope785 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_SUBPROPERTY_OF_in_variableScope787 = new BitSet(new long[]{0xFFFFFFFFFFFFFFF0L,0xFFFFFFFFFFFFFFFFL,0xFFFFFFFFFFFFFFFFL,0xFFFFFFFFFFFFFFFFL,0xFFFFFFFFFFFFFFFFL,0xFFFFFFFFFFFFFFFFL,0xFFFFFFFFFFFFFFFFL,0x00000000000FFFFFL});
    public static final BitSet FOLLOW_VARIABLE_SCOPE_in_variableScope806 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_set_in_variableScope808 = new BitSet(new long[]{0xFFFFFFFFFFFFFFF0L,0xFFFFFFFFFFFFFFFFL,0xFFFFFFFFFFFFFFFFL,0xFFFFFFFFFFFFFFFFL,0xFFFFFFFFFFFFFFFFL,0xFFFFFFFFFFFFFFFFL,0xFFFFFFFFFFFFFFFFL,0x00000000000FFFFFL});
    public static final BitSet FOLLOW_INEQUALITY_CONSTRAINT_in_constraint851 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENTIFIER_in_constraint853 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_EXPRESSION_in_constraint856 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IN_SET_CONSTRAINT_in_constraint870 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENTIFIER_in_constraint876 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_constraint884 = new BitSet(new long[]{0x0000100000000008L});
    public static final BitSet FOLLOW_REGEXP_CONSTRAINT_in_constraint897 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENTIFIER_in_constraint899 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000400L});
    public static final BitSet FOLLOW_stringOperation_in_constraint905 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_NAF_CONSTRAINT_in_constraint917 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_aggregandum_in_aggregandums951 = new BitSet(new long[]{0x0000100000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_aggregandum976 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_VARIABLE_NAME_in_aggregandum979 = new BitSet(new long[]{0x0000000000000000L,0x0000000000004000L});
    public static final BitSet FOLLOW_DOT_in_aggregandum981 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000400000000L});
    public static final BitSet FOLLOW_VALUES_in_aggregandum984 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_IDENTIFIER_in_aggregandum1001 = new BitSet(new long[]{0x0000000000000002L});

}