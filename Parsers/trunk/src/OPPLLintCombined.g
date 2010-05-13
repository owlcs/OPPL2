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
  DESCRPTION;
}
 
@header {
  package org.coode.parsers.oppl.lint;
  import org.coode.parsers.oppl.OPPLSyntaxTree;
}

  

lint
  :
    IDENTIFIER SEMICOLON statement returnClause SEMICOLON description SEMICOLON ->^(OPPL_LINT statement returnClause description) 
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
    (part = IDENTIFIER
    {
      builder.append(part.getText());
      builder.append(" ");
    }
    )+  ->^(DESCRPTION [builder.toString()] $part+)
  ;  

  