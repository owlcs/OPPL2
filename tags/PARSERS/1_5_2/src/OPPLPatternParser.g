parser grammar OPPLPatternParser;
options {
  language = Java;
  output = AST;
  ASTLabelType = OPPLSyntaxTree; // use custom tree nodes
  tokenVocab = OPPLPatternScript;
}

import  OPPLParser;

tokens{
  RENDERING;
  PATTERN_REFERENCE;
  ARGUMENTS;  
}

 @members{
   public Object recoverFromMismatchedSet(IntStream input, RecognitionException e, BitSet follow) throws RecognitionException{
    throw e;
  }
  
  protected void mismatch (IntStream input, int ttype, BitSet follow) throws RecognitionException {
    throw new MismatchedTokenException(ttype,input);
  }
 }
 @rulecatch{
 	catch(RecognitionException e){
 		throw e;
 	}
 }
 
 atomic	       :
		IDENTIFIER 
		| ENTITY_REFERENCE -> ^(ENTITY_REFERENCE)
		| VARIABLE_NAME -> ^(IDENTIFIER[$VARIABLE_NAME])     
	   	| createIdentifier -> ^(createIdentifier)
		| variableAttributeReference -> ^(variableAttributeReference)	
		| THIS_CLASS -> ^(IDENTIFIER[$THIS_CLASS] THIS_CLASS)
	        | patternReference -> ^(patternReference)   
	;


patternReference
	:
		DOLLAR name = IDENTIFIER   arguments   
		-> ^(IDENTIFIER[$DOLLAR.getText() + name.getText() + $arguments.argsString] PATTERN_REFERENCE[name.getText()] arguments)
	;

arguments returns [String argsString]
@init
{
	StringBuilder builder = new StringBuilder();
}
  :
     OPEN_PARENTHESYS
     {
     	builder.append($OPEN_PARENTHESYS.getText());
     } 
     (a = atomic
     {
     	builder.append($a.text);
     } 
     (COMMA a = atomic
     {
     	builder.append($a.text);
     }
     )*)? 
     CLOSED_PARENTHESYS
     {
      builder.append($CLOSED_PARENTHESYS.getText());
     	$argsString = builder.toString();
     }
      -> ^(ARGUMENTS atomic*) 
  ;
