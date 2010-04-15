tree grammar OPPLDefine;
options {
  language = Java;
  tokenVocab = OPPLScript;
ASTLabelType = ManchesterOWLSyntaxTree; // use custom tree nodes  
  filter=true;
}

@members{
  private  OPPLSymbolTable symtab;
  private  ErrorListener errorListener;
  public OPPLDefine(TreeNodeStream input, OPPLSymbolTable symtab, ErrorListener errorListener) {
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
}

topdown  : 
    variableDefinitions  
  ;

variableDefinitions
	:
		^(VARIABLE_DEFINITIONS variableDefinition+)
	;

variableDefinition
	:
		^((INPUT_VARIABLE_DEFINITION |GENERATED_VARIABLE_DEFINITION) IDENTIFIER  VARIABLE_TYPE)
		{
			getSymbolTable().getVariable($IDENTIFIER, $VARIABLE_TYPE);
		}
	;

