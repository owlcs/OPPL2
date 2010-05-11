grammar OPPLPatternScript;

options {
  language = Java;
  output = AST;
  ASTLabelType = OPPLSyntaxTree; // use custom tree nodes
  tokenVocab = OPPLPatternScript;
}

import OPPLPatternLexer, OPPLParser;

tokens{
  OPPL_STATEMENT;
  OPPL_PATTERN;
  RENDERING;
  PATTERN_REFERENCE;
  ARGUMENTS;
}
 
@header {
  package org.coode.parsers.oppl.patterns;
  import org.coode.parsers.oppl.OPPLSyntaxTree;  
}

  
  
pattern
  :
    statement  rendering?   (SEMICOLON returnClause)?  -> ^(OPPL_PATTERN statement rendering returnClause?) 
  ;

statement
  :
    variableDefinitions  actions -> ^(OPPL_STATEMENT variableDefinitions actions)
  ;
  
returnClause
  :
    RETURN returnValue  ->^(RETURN returnValue)
  ;
  
returnValue
  :
      VARIABLE_NAME -> VARIABLE_NAME
    | THIS_CLASS -> THIS_CLASS 
  ;

rendering 
@init
{
  StringBuilder builder = new StringBuilder();
}
  :
    (part = renderingPart
    {
      builder.append(part.string);
      builder.append(" ");
    }
    )+  ->^(RENDERING[builder.toString()] renderingPart+)
  ;
  
renderingPart returns [String string]
@after
{
  $string = $start.getText();
}
  :
      IDENTIFIER -> IDENTIFIER
    | VARIABLE_NAME -> VARIABLE_NAME
    | THIS_CLASS -> THIS_CLASS
  ;

unary 
  :
    IDENTIFIER
    | VARIABLE_NAME -> ^(IDENTIFIER[$VARIABLE_NAME])     
    | createIdentifier -> ^(createIdentifier)
    | variableAttributeReference -> ^(variableAttributeReference)
    | NOT OPEN_PARENTHESYS expression CLOSED_PARENTHESYS -> ^(NEGATED_EXPRESSION expression)
    | NOT IDENTIFIER -> ^(NEGATED_EXPRESSION IDENTIFIER)
		| NOT VARIABLE_NAME -> ^(NEGATED_EXPRESSION ^(IDENTIFIER[$VARIABLE_NAME]))
    | ENTITY_REFERENCE -> ^(ENTITY_REFERENCE)
    | qualifiedRestriction -> ^(qualifiedRestriction)
    | constant
    | THIS_CLASS -> ^(IDENTIFIER[$THIS_CLASS] THIS_CLASS)
    | patternReference -> ^(patternReference)    
  ;


patternReference
	:
		DOLLAR name = IDENTIFIER   arguments   
		-> ^(IDENTIFIER[$DOLLAR.getText() + name.getText() + $arguments.argsString] PATTERN_REFERENCE[name.getText()] arguments)
	;

propertyExpression  :
      IDENTIFIER -> ^(IDENTIFIER)
    | complexPropertyExpression -> ^(complexPropertyExpression)
    | VARIABLE_NAME -> ^(IDENTIFIER[$VARIABLE_NAME])
    | createIdentifier -> ^(createIdentifier)
    ;

value:
      IDENTIFIER -> ^(IDENTIFIER) 
    | constant -> ^(constant)
    | VARIABLE_NAME -> ^(IDENTIFIER[$VARIABLE_NAME])
  ;

filler: 
    IDENTIFIER -> ^(IDENTIFIER)
    | createIdentifier -> ^(createIdentifier)
    | OPEN_PARENTHESYS expression CLOSED_PARENTHESYS -> ^(expression)
    | VARIABLE_NAME -> ^(IDENTIFIER[$VARIABLE_NAME])
		| THIS_CLASS -> ^(IDENTIFIER[$THIS_CLASS] THIS_CLASS)
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
     (a = argument
     {
     	builder.append($a.text);
     } 
     (COMMA a = argument
     {
     	builder.append($a.text);
     }
     )*)? 
     CLOSED_PARENTHESYS
     {
      builder.append($CLOSED_PARENTHESYS.getText());
     	$argsString = builder.toString();
     }
      -> ^(ARGUMENTS argument*) 
  ;
  
argument returns[String text]
@after
{
	$text = $start.getText();
}
	:
		IDENTIFIER
    | VARIABLE_NAME -> ^(IDENTIFIER[$VARIABLE_NAME])     
    | createIdentifier -> ^(createIdentifier)    
    | ENTITY_REFERENCE -> ^(ENTITY_REFERENCE)
    | THIS_CLASS -> ^(IDENTIFIER[$THIS_CLASS] THIS_CLASS)
    | patternReference -> ^(patternReference)    
	;