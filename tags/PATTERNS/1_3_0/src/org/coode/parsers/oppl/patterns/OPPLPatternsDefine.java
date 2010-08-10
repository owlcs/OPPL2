// $ANTLR 3.2 Sep 23, 2009 12:02:23 /Users/luigi/Documents/workspace/Parsers/src/OPPLPatternsDefine.g 2010-07-15 18:27:26

  package org.coode.parsers.oppl.patterns;
  import org.coode.parsers.oppl.OPPLSyntaxTree;
  import org.coode.parsers.ErrorListener;
  import org.coode.parsers.ManchesterOWLSyntaxTree;
  import org.coode.patterns.PatternConstraintSystem;
  import org.coode.patterns.OPPLPatternParser.PatternReferenceResolver;


import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class OPPLPatternsDefine extends TreeRewriter {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "COMPOSITION", "OPEN_PARENTHESYS", "OPEN_CURLY_BRACES", "CLOSED_CURLY_BRACES", "CLOSED_PARENTHESYS", "WHITESPACE", "AND", "OR", "NOT", "SOME", "ONLY", "MIN", "MAX", "EXACTLY", "VALUE", "INVERSE", "SUBCLASS_OF", "SUB_PROPERTY_OF", "EQUIVALENT_TO", "SAME_AS", "DIFFERENT_FROM", "INVERSE_OF", "DISJOINT_WITH", "DOMAIN", "RANGE", "FUNCTIONAL", "SYMMETRIC", "ANTI_SYMMETRIC", "REFLEXIVE", "IRREFLEXIVE", "TRANSITIVE", "INVERSE_FUNCTIONAL", "POW", "COMMA", "INSTANCE_OF", "TYPES", "DBLQUOTE", "DIGIT", "INTEGER", "LETTER", "IDENTIFIER", "ENTITY_REFERENCE", "QUESTION_MARK", "Tokens", "SUB_CLASS_AXIOM", "EQUIVALENT_TO_AXIOM", "DISJOINT_WITH_AXIOM", "SUB_PROPERTY_AXIOM", "SAME_AS_AXIOM", "DIFFERENT_FROM_AXIOM", "UNARY_AXIOM", "DISJUNCTION", "CONJUNCTION", "PROPERTY_CHAIN", "NEGATED_EXPRESSION", "NEGATED_ASSERTION", "INVERSE_PROPERTY", "SOME_RESTRICTION", "ALL_RESTRICTION", "VALUE_RESTRICTION", "CARDINALITY_RESTRICTION", "ONE_OF", "TYPE_ASSERTION", "ROLE_ASSERTION", "INVERSE_OBJECT_PROPERTY_EXPRESSION", "EXPRESSION", "CONSTANT", "WHERE", "NOT_EQUAL", "EQUAL", "IN", "SELECT", "ASSERTED", "COLON", "DOT", "PLUS", "CREATE", "CREATE_INTERSECTION", "CREATE_DISJUNCTION", "BEGIN", "END", "OPEN_SQUARE_BRACKET", "CLOSED_SQUARE_BRACKET", "SUPER_CLASS_OF", "SUPER_PROPERTY_OF", "VARIABLE_TYPE", "ADD", "REMOVE", "ASSERTED_CLAUSE", "PLAIN_CLAUSE", "INEQUALITY_CONSTRAINT", "IN_SET_CONSTRAINT", "INPUT_VARIABLE_DEFINITION", "GENERATED_VARIABLE_DEFINITION", "CREATE_OPPL_FUNCTION", "VARIABLE_ATTRIBUTE", "OPPL_FUNCTION", "ACTIONS", "VARIABLE_DEFINITIONS", "QUERY", "VARIABLE_SCOPE", "SUBPROPERTY_OF", "VARIABLE_IDENTIFIER", "OPPL_STATEMENT", "ESCLAMATION_MARK", "CREATE_IDENTIFIER", "PLAIN_IDENTIFIER", "MATCH", "ATTRIBUTE_SELECTOR", "VALUES", "RENDERING", "GROUPS", "STRING_OPERATION", "DOLLAR", "RETURN", "THIS_CLASS", "ARGUMENTS", "OPPL_PATTERN", "PATTERN_REFERENCE", "SEMICOLON", "VARIABLE_NAME", "REGEXP_CONSTRAINT"
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
    public static final int ARGUMENTS=417;
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
    public static final int DBLQUOTE=40;
    public static final int STRING_OPERATION=394;
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
    public static final int OPPL_PATTERN=419;
    public static final int VARIABLE_NAME=464;
    public static final int THIS_CLASS=416;
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
    public static final int PLAIN_CLAUSE=93;
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
    public static final int PLAIN_IDENTIFIER=152;
    public static final int VARIABLE_ATTRIBUTE=99;
    public static final int ASSERTED=76;
    public static final int FUNCTIONAL=29;
    public static final int PROPERTY_CHAIN=57;
    public static final int PATTERN_REFERENCE=421;
    public static final int TYPE_ASSERTION=66;

    // delegates
    // delegators


        public OPPLPatternsDefine(TreeNodeStream input) {
            this(input, new RecognizerSharedState());
        }
        public OPPLPatternsDefine(TreeNodeStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        
    protected TreeAdaptor adaptor = new CommonTreeAdaptor();

    public void setTreeAdaptor(TreeAdaptor adaptor) {
        this.adaptor = adaptor;
    }
    public TreeAdaptor getTreeAdaptor() {
        return adaptor;
    }

    public String[] getTokenNames() { return OPPLPatternsDefine.tokenNames; }
    public String getGrammarFileName() { return "/Users/luigi/Documents/workspace/Parsers/src/OPPLPatternsDefine.g"; }


      private  OPPLPatternsSymbolTable symtab;
      private  ErrorListener errorListener;
      private PatternConstraintSystem constraintSystem;
      private PatternReferenceResolver patternReferenceResolver;
      public OPPLPatternsDefine(TreeNodeStream input, OPPLPatternsSymbolTable symtab, ErrorListener errorListener,PatternReferenceResolver patternReferenceResolver, PatternConstraintSystem constraintSystem) {
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
        if(patternReferenceResolver == null){
          throw new NullPointerException("The pattern reference resolver cannot be null");
        }
        this.symtab = symtab;
        this.errorListener = errorListener;
        this.constraintSystem = constraintSystem;
        this.patternReferenceResolver = patternReferenceResolver;
      }
      
      public PatternReferenceResolver getPatternReferenceResolver(){
      	return patternReferenceResolver;
      }
      
      public PatternConstraintSystem getConstraintSystem(){
        return this.constraintSystem;
      }
      
      public ErrorListener getErrorListener(){
      	return this.errorListener;
      }
      
      public OPPLPatternsSymbolTable getSymbolTable(){
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
      


    public static class bottomup_return extends TreeRuleReturnScope {
        OPPLSyntaxTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "bottomup"
    // /Users/luigi/Documents/workspace/Parsers/src/OPPLPatternsDefine.g:90:1: bottomup : ( patternReference | thisClass );
    public final OPPLPatternsDefine.bottomup_return bottomup() throws RecognitionException {
        OPPLPatternsDefine.bottomup_return retval = new OPPLPatternsDefine.bottomup_return();
        retval.start = input.LT(1);

        OPPLSyntaxTree root_0 = null;

        OPPLSyntaxTree _first_0 = null;
        OPPLSyntaxTree _last = null;

        OPPLPatternsDefine.patternReference_return patternReference1 = null;

        OPPLPatternsDefine.thisClass_return thisClass2 = null;



        try {
            // /Users/luigi/Documents/workspace/Parsers/src/OPPLPatternsDefine.g:90:11: ( patternReference | thisClass )
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==IDENTIFIER) ) {
                int LA1_1 = input.LA(2);

                if ( (LA1_1==DOWN) ) {
                    int LA1_2 = input.LA(3);

                    if ( (LA1_2==PATTERN_REFERENCE) ) {
                        alt1=1;
                    }
                    else if ( (LA1_2==THIS_CLASS) ) {
                        alt1=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 1, 2, input);

                        throw nvae;
                    }
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 1, 1, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // /Users/luigi/Documents/workspace/Parsers/src/OPPLPatternsDefine.g:91:7: patternReference
                    {
                    _last = (OPPLSyntaxTree)input.LT(1);
                    pushFollow(FOLLOW_patternReference_in_bottomup84);
                    patternReference1=patternReference();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==1 ) 
                     
                    if ( _first_0==null ) _first_0 = patternReference1.tree;

                    if ( state.backtracking==1 ) {
                    retval.tree = (OPPLSyntaxTree)_first_0;
                    if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
                        retval.tree = (OPPLSyntaxTree)adaptor.getParent(retval.tree);}
                    }
                    break;
                case 2 :
                    // /Users/luigi/Documents/workspace/Parsers/src/OPPLPatternsDefine.g:92:7: thisClass
                    {
                    _last = (OPPLSyntaxTree)input.LT(1);
                    pushFollow(FOLLOW_thisClass_in_bottomup92);
                    thisClass2=thisClass();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==1 ) 
                     
                    if ( _first_0==null ) _first_0 = thisClass2.tree;

                    if ( state.backtracking==1 ) {
                    retval.tree = (OPPLSyntaxTree)_first_0;
                    if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
                        retval.tree = (OPPLSyntaxTree)adaptor.getParent(retval.tree);}
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
    // $ANTLR end "bottomup"

    public static class patternReference_return extends TreeRuleReturnScope {
        OPPLSyntaxTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "patternReference"
    // /Users/luigi/Documents/workspace/Parsers/src/OPPLPatternsDefine.g:95:1: patternReference : ^(pr= IDENTIFIER PATTERN_REFERENCE (args= arguments )? ) -> ^( $pr) ;
    public final OPPLPatternsDefine.patternReference_return patternReference() throws RecognitionException {
        OPPLPatternsDefine.patternReference_return retval = new OPPLPatternsDefine.patternReference_return();
        retval.start = input.LT(1);

        OPPLSyntaxTree root_0 = null;

        OPPLSyntaxTree _first_0 = null;
        OPPLSyntaxTree _last = null;

        OPPLSyntaxTree pr=null;
        OPPLSyntaxTree PATTERN_REFERENCE3=null;
        OPPLPatternsDefine.arguments_return args = null;


        OPPLSyntaxTree pr_tree=null;
        OPPLSyntaxTree PATTERN_REFERENCE3_tree=null;
        RewriteRuleNodeStream stream_PATTERN_REFERENCE=new RewriteRuleNodeStream(adaptor,"token PATTERN_REFERENCE");
        RewriteRuleNodeStream stream_IDENTIFIER=new RewriteRuleNodeStream(adaptor,"token IDENTIFIER");
        RewriteRuleSubtreeStream stream_arguments=new RewriteRuleSubtreeStream(adaptor,"rule arguments");
        try {
            // /Users/luigi/Documents/workspace/Parsers/src/OPPLPatternsDefine.g:96:2: ( ^(pr= IDENTIFIER PATTERN_REFERENCE (args= arguments )? ) -> ^( $pr) )
            // /Users/luigi/Documents/workspace/Parsers/src/OPPLPatternsDefine.g:97:3: ^(pr= IDENTIFIER PATTERN_REFERENCE (args= arguments )? )
            {
            _last = (OPPLSyntaxTree)input.LT(1);
            {
            OPPLSyntaxTree _save_last_1 = _last;
            OPPLSyntaxTree _first_1 = null;
            _last = (OPPLSyntaxTree)input.LT(1);
            pr=(OPPLSyntaxTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_patternReference110); if (state.failed) return retval; 
            if ( state.backtracking==1 ) stream_IDENTIFIER.add(pr);


            if ( state.backtracking==1 )
            if ( _first_0==null ) _first_0 = pr;
            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (OPPLSyntaxTree)input.LT(1);
            PATTERN_REFERENCE3=(OPPLSyntaxTree)match(input,PATTERN_REFERENCE,FOLLOW_PATTERN_REFERENCE_in_patternReference112); if (state.failed) return retval; 
            if ( state.backtracking==1 ) stream_PATTERN_REFERENCE.add(PATTERN_REFERENCE3);

            // /Users/luigi/Documents/workspace/Parsers/src/OPPLPatternsDefine.g:97:42: (args= arguments )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==ARGUMENTS) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // /Users/luigi/Documents/workspace/Parsers/src/OPPLPatternsDefine.g:97:42: args= arguments
                    {
                    _last = (OPPLSyntaxTree)input.LT(1);
                    pushFollow(FOLLOW_arguments_in_patternReference117);
                    args=arguments();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==1 ) stream_arguments.add(args.getTree());

                    if ( state.backtracking==1 ) {
                    retval.tree = (OPPLSyntaxTree)_first_0;
                    if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
                        retval.tree = (OPPLSyntaxTree)adaptor.getParent(retval.tree);}
                    }
                    break;

            }


            match(input, Token.UP, null); if (state.failed) return retval;_last = _save_last_1;
            }

            if ( state.backtracking==1 ) {

              	   if(args==null){
              	     getPatternReferenceResolver().resolvePattern(pr, PATTERN_REFERENCE3.getText(),getConstraintSystem(),getSymbolTable());
              	   }else{
              	     getPatternReferenceResolver().resolvePattern(pr, PATTERN_REFERENCE3.getText(),getConstraintSystem(),getSymbolTable(), args.argStrings.toArray(new String[args.argStrings.size()]));
              	   } 
              	 
            }


            // AST REWRITE
            // elements: pr
            // token labels: pr
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==1 ) {
            retval.tree = root_0;
            RewriteRuleNodeStream stream_pr=new RewriteRuleNodeStream(adaptor,"token pr",pr);
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (OPPLSyntaxTree)adaptor.nil();
            // 105:3: -> ^( $pr)
            {
                // /Users/luigi/Documents/workspace/Parsers/src/OPPLPatternsDefine.g:106:3: ^( $pr)
                {
                OPPLSyntaxTree root_1 = (OPPLSyntaxTree)adaptor.nil();
                root_1 = (OPPLSyntaxTree)adaptor.becomeRoot(stream_pr.nextNode(), root_1);

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = (OPPLSyntaxTree)adaptor.rulePostProcessing(root_0);
            input.replaceChildren(adaptor.getParent(retval.start),
                                  adaptor.getChildIndex(retval.start),
                                  adaptor.getChildIndex(_last),
                                  retval.tree);}
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
    // $ANTLR end "patternReference"

    public static class arguments_return extends TreeRuleReturnScope {
        public List<String> argStrings;
        OPPLSyntaxTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "arguments"
    // /Users/luigi/Documents/workspace/Parsers/src/OPPLPatternsDefine.g:109:1: arguments returns [List<String> argStrings] : ^( ARGUMENTS (argument= . )+ ) ;
    public final OPPLPatternsDefine.arguments_return arguments() throws RecognitionException {
        OPPLPatternsDefine.arguments_return retval = new OPPLPatternsDefine.arguments_return();
        retval.start = input.LT(1);

        OPPLSyntaxTree root_0 = null;

        OPPLSyntaxTree _first_0 = null;
        OPPLSyntaxTree _last = null;

        OPPLSyntaxTree ARGUMENTS4=null;
        OPPLSyntaxTree argument=null;

        OPPLSyntaxTree ARGUMENTS4_tree=null;
        OPPLSyntaxTree argument_tree=null;


          retval.argStrings = new ArrayList<String>();

        try {
            // /Users/luigi/Documents/workspace/Parsers/src/OPPLPatternsDefine.g:113:3: ( ^( ARGUMENTS (argument= . )+ ) )
            // /Users/luigi/Documents/workspace/Parsers/src/OPPLPatternsDefine.g:114:5: ^( ARGUMENTS (argument= . )+ )
            {
            _last = (OPPLSyntaxTree)input.LT(1);
            {
            OPPLSyntaxTree _save_last_1 = _last;
            OPPLSyntaxTree _first_1 = null;
            _last = (OPPLSyntaxTree)input.LT(1);
            ARGUMENTS4=(OPPLSyntaxTree)match(input,ARGUMENTS,FOLLOW_ARGUMENTS_in_arguments161); if (state.failed) return retval;


            if ( state.backtracking==1 )
            if ( _first_0==null ) _first_0 = ARGUMENTS4;
            match(input, Token.DOWN, null); if (state.failed) return retval;
            // /Users/luigi/Documents/workspace/Parsers/src/OPPLPatternsDefine.g:114:17: (argument= . )+
            int cnt3=0;
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0>=COMPOSITION && LA3_0<=REGEXP_CONSTRAINT)) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // /Users/luigi/Documents/workspace/Parsers/src/OPPLPatternsDefine.g:114:18: argument= .
            	    {
            	    _last = (OPPLSyntaxTree)input.LT(1);
            	    argument=(OPPLSyntaxTree)input.LT(1);
            	    matchAny(input); if (state.failed) return retval;
            	     
            	    if ( state.backtracking==1 )
            	    if ( _first_1==null ) _first_1 = argument;
            	    if ( state.backtracking==1 ) {
            	      retval.argStrings.add(argument.getText());
            	    }

            	    if ( state.backtracking==1 ) {
            	    retval.tree = (OPPLSyntaxTree)_first_0;
            	    if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
            	        retval.tree = (OPPLSyntaxTree)adaptor.getParent(retval.tree);}
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


            match(input, Token.UP, null); if (state.failed) return retval;_last = _save_last_1;
            }


            if ( state.backtracking==1 ) {
            retval.tree = (OPPLSyntaxTree)_first_0;
            if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
                retval.tree = (OPPLSyntaxTree)adaptor.getParent(retval.tree);}
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
    // $ANTLR end "arguments"

    public static class thisClass_return extends TreeRuleReturnScope {
        OPPLSyntaxTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "thisClass"
    // /Users/luigi/Documents/workspace/Parsers/src/OPPLPatternsDefine.g:117:1: thisClass : ^(i= IDENTIFIER THIS_CLASS ) -> ^( $i) ;
    public final OPPLPatternsDefine.thisClass_return thisClass() throws RecognitionException {
        OPPLPatternsDefine.thisClass_return retval = new OPPLPatternsDefine.thisClass_return();
        retval.start = input.LT(1);

        OPPLSyntaxTree root_0 = null;

        OPPLSyntaxTree _first_0 = null;
        OPPLSyntaxTree _last = null;

        OPPLSyntaxTree i=null;
        OPPLSyntaxTree THIS_CLASS5=null;

        OPPLSyntaxTree i_tree=null;
        OPPLSyntaxTree THIS_CLASS5_tree=null;
        RewriteRuleNodeStream stream_THIS_CLASS=new RewriteRuleNodeStream(adaptor,"token THIS_CLASS");
        RewriteRuleNodeStream stream_IDENTIFIER=new RewriteRuleNodeStream(adaptor,"token IDENTIFIER");

        try {
            // /Users/luigi/Documents/workspace/Parsers/src/OPPLPatternsDefine.g:118:3: ( ^(i= IDENTIFIER THIS_CLASS ) -> ^( $i) )
            // /Users/luigi/Documents/workspace/Parsers/src/OPPLPatternsDefine.g:120:5: ^(i= IDENTIFIER THIS_CLASS )
            {
            _last = (OPPLSyntaxTree)input.LT(1);
            {
            OPPLSyntaxTree _save_last_1 = _last;
            OPPLSyntaxTree _first_1 = null;
            _last = (OPPLSyntaxTree)input.LT(1);
            i=(OPPLSyntaxTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_thisClass193); if (state.failed) return retval; 
            if ( state.backtracking==1 ) stream_IDENTIFIER.add(i);


            if ( state.backtracking==1 )
            if ( _first_0==null ) _first_0 = i;
            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (OPPLSyntaxTree)input.LT(1);
            THIS_CLASS5=(OPPLSyntaxTree)match(input,THIS_CLASS,FOLLOW_THIS_CLASS_in_thisClass195); if (state.failed) return retval; 
            if ( state.backtracking==1 ) stream_THIS_CLASS.add(THIS_CLASS5);


            match(input, Token.UP, null); if (state.failed) return retval;_last = _save_last_1;
            }

            if ( state.backtracking==1 ) {

                    symtab.resolveThisClass(THIS_CLASS5,getConstraintSystem());
                  
            }


            // AST REWRITE
            // elements: i
            // token labels: i
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==1 ) {
            retval.tree = root_0;
            RewriteRuleNodeStream stream_i=new RewriteRuleNodeStream(adaptor,"token i",i);
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (OPPLSyntaxTree)adaptor.nil();
            // 124:5: -> ^( $i)
            {
                // /Users/luigi/Documents/workspace/Parsers/src/OPPLPatternsDefine.g:125:5: ^( $i)
                {
                OPPLSyntaxTree root_1 = (OPPLSyntaxTree)adaptor.nil();
                root_1 = (OPPLSyntaxTree)adaptor.becomeRoot(stream_i.nextNode(), root_1);

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = (OPPLSyntaxTree)adaptor.rulePostProcessing(root_0);
            input.replaceChildren(adaptor.getParent(retval.start),
                                  adaptor.getChildIndex(retval.start),
                                  adaptor.getChildIndex(_last),
                                  retval.tree);}
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
    // $ANTLR end "thisClass"

    // Delegated rules


 

    public static final BitSet FOLLOW_patternReference_in_bottomup84 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_thisClass_in_bottomup92 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_patternReference110 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_PATTERN_REFERENCE_in_patternReference112 = new BitSet(new long[]{0x0000000000000008L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000200000000L});
    public static final BitSet FOLLOW_arguments_in_patternReference117 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ARGUMENTS_in_arguments161 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENTIFIER_in_thisClass193 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_THIS_CLASS_in_thisClass195 = new BitSet(new long[]{0x0000000000000008L});

}