tree grammar OPPLLintTypes;
options {
  language = Java;
  tokenVocab = OPPLLintCombined; 
  ASTLabelType = OPPLSyntaxTree;
  filter=true;
}


@members{
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
  
}

@rulecatch{
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
}

@header {
  package org.coode.parsers.oppl.lint;
  import org.coode.parsers.ErrorListener;
  import org.coode.oppl.lint.OPPLLintAbstractFactory;
  import org.coode.oppl.lint.OPPLLintScript;
  import org.coode.parsers.oppl.OPPLSyntaxTree;
  import org.coode.oppl.OPPLScript;
  import org.coode.oppl.Variable;
  import org.coode.oppl.ConstraintSystem;
  import org.coode.parsers.oppl.OPPLSymbolTable;
}

// START: root
bottomup // match subexpressions innermost to outermost
    :  
    	lint
    ;


lint
	:
		^(OPPL_LINT IDENTIFIER ^(s = OPPL_STATEMENT .*) (rc= returnClause) ^(DESCRIPTION .*)) 
		{
		  if(s.getOPPLContent() instanceof OPPLScript){

		     if(rc!=null){                                
           		 Variable v = rc;
			OPPLLintScript lint = this.getLintModelFactory().buildOPPLLintScript($IDENTIFIER.text,
                                (OPPLScript) s.getOPPLContent(),v,$DESCRIPTION.text);
                        $start.setOPPLContent(lint);        
	             }                    
		  }  
		}		
  ;

returnClause returns [Variable variable]
  :
      ^(RETURN VARIABLE_NAME)
      {
        $variable = getConstraintSystem().getVariable($VARIABLE_NAME.getText());
        if($variable==null){
          if(getErrorListener()!=null){
            getErrorListener().illegalToken($VARIABLE_NAME, "Undefined variable");
          }
        }
      }
  ;  
  