grammar OPPLTestCaseCombined;

options {
  language = Java;
  output = AST;
  ASTLabelType = OPPLSyntaxTree; // use custom tree nodes
  tokenVocab = OPPLTestCaseCombined;
}

import OPPLTestCaseLexer, OPPLParser;

tokens{
  OPPL_STATEMENT;
  OPPL_TEST_CASE;
  MESSAGE;
  TEST;
  ASSERT_EQUAL;
  ASSERT_NOT_EQUAL;
  ASSERT_TRUE;
  ASSERT_FALSE;
  TEXT;
}
 
@header {
	package org.coode.parsers.oppl.testcase;
	import org.coode.parsers.oppl.OPPLSyntaxTree;
	import org.coode.parsers.ErrorListener;
}


@members{

  private  ErrorListener errorListener;
  
  public OPPLTestCaseCombinedParser(TokenStream input, ErrorListener errorListener) {
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
  

testCase
  :
    name = text SEMICOLON INFERENCE?  statement  test+->^(OPPL_TEST_CASE IDENTIFIER[$name.text] INFERENCE? statement test+) 
  ;


test
	:
		ASSERT assertion (SEMICOLON message= text)? -> ^(TEST assertion ^(MESSAGE[$message.text] $message)? )
	;
	

assertion options{backtrack = true;}
	:
		left =assertionExpression EQUAL right= assertionExpression -> ^(ASSERT_EQUAL $left $right)
		| left =assertionExpression NOT_EQUAL right= assertionExpression -> ^(ASSERT_NOT_EQUAL $left $right)
		| VARIABLE_NAME 	CONTAINS assertionExpression ->^(CONTAINS VARIABLE_NAME  assertionExpression)
		| NOT OPEN_PARENTHESYS assertion CLOSED_PARENTHESYS ->^(NOT assertion)
	;
	
assertionExpression
	:
		COUNT OPEN_PARENTHESYS VARIABLE_NAME CLOSED_PARENTHESYS ->^(COUNT VARIABLE_NAME)
		| INTEGER 
		| expression ->^(EXPRESSION expression)
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
   | NOT -> ^(TEXT [$NOT.text])
   | AND -> ^(TEXT [$AND.text])
   | OR -> ^(TEXT [$OR.text])
   | SOME -> ^(TEXT [$SOME.text])
   | ONLY -> ^(TEXT [$ONLY.text])
   | MIN -> ^(TEXT [$MIN.text])
   | MAX -> ^(TEXT [$MAX.text])   
   | EXACTLY -> ^(TEXT [$EXACTLY.text])   
   | VALUE -> ^(TEXT [$VALUE.text])   
   | INVERSE -> ^(TEXT [$INVERSE.text])   
   | DOMAIN -> ^(TEXT [$DOMAIN.text])   
   | RANGE -> ^(TEXT [$RANGE.text])
   | TYPES -> ^(TEXT [$TYPES.text])      
   | INTEGER -> ^(TEXT [$INTEGER.text])      
   | COUNT -> ^(TEXT [$COUNT.text])   
  ; 

statement
  :
    variableDefinitions? query  -> ^(OPPL_STATEMENT variableDefinitions? query)
  ;
  





 

  

