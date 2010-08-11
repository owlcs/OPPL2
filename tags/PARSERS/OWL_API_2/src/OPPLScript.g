/*
  Grammar that defines an OPPL statement. It imports its components from the OPPLParser grammar and
  its tokens from OPPL Lexer. Please notice that when ANTLR generates the corresponding code, it 
  inserts compilation errors. Such errors correspond to the rules in OPPLParser that 
  override those in MOWLParser. In other words, the code generator gets confused and tries to invoke 
  those rules on the MOWLParser delegate, rather than on the OPPLParser one. These can be easily
  amended by hand after the code genration.     
*/
grammar OPPLScript;

options {
  language = Java;
  output = AST;
  ASTLabelType = OPPLSyntaxTree; // use custom tree nodes
  tokenVocab = OPPLScript;
}

import OPPLLexer, OPPLParser;



tokens{
  OPPL_STATEMENT;
}
 
@header {
  package org.coode.parsers.oppl;
  import org.coode.parsers.ErrorListener;
}

@members{

  private  ErrorListener errorListener;
  
  public OPPLScriptParser(TokenStream input, ErrorListener errorListener) {
    this(input);   
    if(errorListener == null){
    	throw new NullPointerException("The error listener cannot be null");
    }
    this.errorListener = errorListener;
  }
  
  public ErrorListener getErrorListener(){
  	return this.errorListener;
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

statement
  :
    variableDefinitions? query actions -> ^(OPPL_STATEMENT variableDefinitions? query actions)
  ;

  

  