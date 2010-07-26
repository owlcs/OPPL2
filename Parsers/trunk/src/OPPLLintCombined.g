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
}
 
@header {
  package org.coode.parsers.oppl.lint;
  import org.coode.parsers.oppl.OPPLSyntaxTree;
}

  

lint
  :
    name = IDENTIFIER SEMICOLON statement returnClause SEMICOLON description SEMICOLON ->^(OPPL_LINT $name statement returnClause description) 
  ;

statement
  :
    variableDefinitions? query actions -> ^(OPPL_STATEMENT variableDefinitions? query actions)
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
    (a= atomic
    {
      builder.append($a.text);
      builder.append(" ");
    }
    )+  ->^(DESCRIPTION [builder.toString()] atomic+)
  ;  

  