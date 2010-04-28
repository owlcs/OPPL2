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
    statement  rendering  SEMICOLON returnClause? SEMICOLON -> ^(OPPL_PATTERN returnClause? rendering) 
  ;

statement
  :
    variableDefinitions  actions -> ^(OPPL_STATEMENT variableDefinitions actions)
  ;
  
returnClause
  :
    RETURN IDENTIFIER ->^(RETURN IDENTIFIER)
  ;

rendering
  :
    IDENTIFIER+ SEMICOLON ->^(RENDERING IDENTIFIER+)
  ;


unary :
    IDENTIFIER
    | DOLLAR IDENTIFIER OPEN_PARENTHESYS arguments? CLOSED_PARENTHESYS -> ^(IDENTIFIER ^(PATTERN_REFERENCE arguments?))     
    | NOT OPEN_PARENTHESYS expression CLOSED_PARENTHESYS -> ^(NEGATED_EXPRESSION expression)
    | NOT IDENTIFIER -> ^(NEGATED_EXPRESSION IDENTIFIER)          
    | ENTITY_REFERENCE -> ^(ENTITY_REFERENCE)
    | qualifiedRestriction -> ^(qualifiedRestriction)
    | constant    
  ;

arguments
  :
     IDENTIFIER (COMMA IDENTIFIER)*  -> ^(ARGUMENTS IDENTIFIER+) 
  ;
  
 