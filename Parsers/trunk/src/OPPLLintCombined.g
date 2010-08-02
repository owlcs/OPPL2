grammar OPPLLintCombined;

options {
  language = Java;
  output = AST;
  ASTLabelType = OPPLSyntaxTree; // use custom tree nodes
  tokenVocab = OPPLLintCombined;
}

import OPPLLintLexer, OPPLParser;

tokens{
  OPPL_STATEMENT;
  OPPL_LINT;
  DESCRIPTION;
  EXPLANATION;
}
 
@header {
  package org.coode.parsers.oppl.lint;
  import org.coode.parsers.oppl.OPPLSyntaxTree;
    import org.coode.parsers.ErrorListener;
}


@members{

  private  ErrorListener errorListener;
  
  public OPPLLintCombinedParser(TokenStream input, ErrorListener errorListener) {
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
  

lint
  :
    name = text SEMICOLON  statement returnClause  SEMICOLON exp = text SEMICOLON description ->^(OPPL_LINT IDENTIFIER[$name.text] statement returnClause ^(EXPLANATION[$exp.text] $exp)  description) 
  ;

text

@init
{
  StringBuilder builder = new StringBuilder();
}
:
( t = textBit
	{
		builder.append($t.text);
		builder.append(" ");
	})+   -> ^(TEXT [builder.toString()] textBit+)
	;

textBit
	:
	IDENTIFIER -> ^(TEXT [$IDENTIFIER.text])
	| VARIABLE_NAME  -> ^(TEXT VARIABLE_NAME)
	| FUNCTIONAL -> ^(TEXT [$FUNCTIONAL.text])
    	| INVERSE_FUNCTIONAL -> ^(TEXT [$INVERSE_FUNCTIONAL.text])
    | SYMMETRIC -> ^(TEXT [$SYMMETRIC.text])
    | ANTI_SYMMETRIC -> ^(TEXT [$ANTI_SYMMETRIC.text])
    | REFLEXIVE -> ^(TEXT [$REFLEXIVE.text])
    | IRREFLEXIVE -> ^(TEXT [$IRREFLEXIVE.text])
    |  TRANSITIVE -> ^(TEXT [$TRANSITIVE.text])
	;

statement
  :
    variableDefinitions? query actions? -> ^(OPPL_STATEMENT variableDefinitions? query actions?)
  ;
  


returnClause
  :
    RETURN returnValue  ->^(RETURN returnValue)
  ;
  
returnValue
  :
      VARIABLE_NAME -> VARIABLE_NAME
  ;

description 
@init
{
  StringBuilder builder = new StringBuilder();
}
  :
    (a= .
    {
      builder.append($a.text);
      builder.append(" ");
    }
    )+  ->^(DESCRIPTION [builder.toString()] $a+)
  ; 
  
 

  