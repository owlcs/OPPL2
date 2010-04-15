grammar OPPLScript;

options {
  language = Java;
  output = AST;
  ASTLabelType = ManchesterOWLSyntaxTree; // use custom tree nodes
}

import OPPLLexer, OPPLParser;

tokens{
  OPPL_STATEMENT;
}
 
@header {
  package org.coode.parsers.oppl;
}

  

statement
  :
    variableDefinitions query actions -> ^(OPPL_STATEMENT variableDefinitions query actions)
  ;

  

  