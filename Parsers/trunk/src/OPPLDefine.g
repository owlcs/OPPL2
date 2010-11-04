tree grammar OPPLDefine;
options {
  language = Java;
  tokenVocab = OPPLScript; 
  ASTLabelType = OPPLSyntaxTree;
  filter=true;
  output= AST;
}


@members{
  private  OPPLSymbolTable symtab;
  private  ErrorListener errorListener;
  private ConstraintSystem constraintSystem;
  public OPPLDefine(TreeNodeStream input, OPPLSymbolTable symtab, ErrorListener errorListener, ConstraintSystem constraintSystem) {
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
    this.symtab = symtab;
    this.errorListener = errorListener;
    this.constraintSystem= constraintSystem;
  }
  
  public ConstraintSystem getConstraintSystem(){
    return this.constraintSystem;
  }
  
  public ErrorListener getErrorListener(){
  	return this.errorListener;
  }
  
  public OPPLSymbolTable getSymbolTable(){
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
  package org.coode.parsers.oppl;
  import org.coode.parsers.ErrorListener;
  import org.coode.parsers.ManchesterOWLSyntaxTree;
  import org.coode.oppl.ConstraintSystem;
}

bottomup  : 
    variableDefinition
 
  ;



variableDefinition
	:
		^((INPUT_VARIABLE_DEFINITION |GENERATED_VARIABLE_DEFINITION) VARIABLE_NAME  VARIABLE_TYPE .*)
		{
			getSymbolTable().defineVariable($VARIABLE_NAME, $VARIABLE_TYPE, getConstraintSystem());
		}
	;

