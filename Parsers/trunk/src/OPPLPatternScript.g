grammar OPPLPatternScript;

options {
  language = Java;
  output = AST;
  ASTLabelType = OPPLSyntaxTree; // use custom tree nodes
  tokenVocab = OPPLPatternScript;
}

import OPPLPatternLexer, OPPLParser;

tokens{
  OPPL_PATTERN;
  OPPL_STATEMENT;
  RENDERING; 
  PATTERN_REFERENCE;
  ARGUMENTS;
  ARGUMENT;
}
 
@header {
  package org.coode.parsers.oppl.patterns;
  import org.coode.parsers.oppl.OPPLSyntaxTree;  
  import org.coode.parsers.ErrorListener;
}

@members{

  private  ErrorListener errorListener;
  
  public OPPLPatternScriptParser(TokenStream input, ErrorListener errorListener) {
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
  
pattern
  :
    statement  rendering?   (SEMICOLON returnClause)?  -> ^(OPPL_PATTERN statement rendering? returnClause?) 
  ;

statement
  :
    variableDefinitions?  actions -> ^(OPPL_STATEMENT variableDefinitions? actions)
  ;
  
returnClause
  :
    	RETURN VARIABLE_NAME  ->^(RETURN ^(IDENTIFIER[$VARIABLE_NAME]))
    |	RETURN THIS_CLASS  ->^(RETURN ^(THIS_CLASS))
  ;
  


rendering 
@init
{
  StringBuilder builder = new StringBuilder();
}
  :
    (renderingPart {
    	builder.append($renderingPart.text);
	builder.append(' ');
    })+
      ->^(RENDERING[builder.toString()] renderingPart+)
  ;
  
renderingPart 

	:
      THIS_CLASS -> ^(IDENTIFIER[$THIS_CLASS] THIS_CLASS)
    | IDENTIFIER -> ^(IDENTIFIER) 
    | ENTITY_REFERENCE -> ^(ENTITY_REFERENCE)
    | VARIABLE_NAME -> ^(IDENTIFIER[$VARIABLE_NAME])     
    | HYPHEN -> ^(HYPHEN)
		
	;



atomic 
  :
  	 THIS_CLASS -> ^(IDENTIFIER[$THIS_CLASS] THIS_CLASS)
	| IDENTIFIER -> ^(IDENTIFIER) 
    | ENTITY_REFERENCE -> ^(ENTITY_REFERENCE)
    | VARIABLE_NAME -> ^(IDENTIFIER[$VARIABLE_NAME])     
    | createIdentifier -> ^(createIdentifier)
    | variableAttributeReference -> ^(variableAttributeReference)	    
    | patternReference -> ^(patternReference)    
  ;
  



patternReference
	:
		DOLLAR name = IDENTIFIER   arguments   
		-> ^(IDENTIFIER[$DOLLAR.getText() + name.getText() + $arguments.string] PATTERN_REFERENCE[name.getText()] arguments)
	;

arguments returns [String string]
@init{
	StringBuilder out = new StringBuilder();
}
@after{
	$string = out.toString();
}

  :
     OPEN_PARENTHESYS{
     	out.append($OPEN_PARENTHESYS.getText());
     }
     (a = argument
     {
     	out.append($a.string);
     }
     (COMMA  a = argument
     {
     	out.append($COMMA.getText());
     	out.append($a.string);
     }
     )*)? 
     CLOSED_PARENTHESYS{
     	out.append($CLOSED_PARENTHESYS.getText());
     }
      -> ^(ARGUMENTS argument*) 
  ;


argument returns [String string]
@init{
	StringBuilder out = new StringBuilder();
}

	:
		a = atomic {
				$string = $a.text.trim();
			} -> ^(ARGUMENT ^(EXPRESSION[$a.text.trim()] atomic))
		| OPEN_CURLY_BRACES {
			out.append($OPEN_CURLY_BRACES.getText());
		} a =atomic {
			out.append($a.text.trim());
		} (COMMA a = atomic{
			out.append($COMMA.getText());
			out.append(" ");			
		     	out.append($a.text.trim());
		})* CLOSED_CURLY_BRACES {
			out.append($CLOSED_CURLY_BRACES.getText());
			$string = out.toString();
		} -> ^(ARGUMENT ^(EXPRESSION[$atomic.text.trim()] atomic)+)
	;
